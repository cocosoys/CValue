/*     */ package cpw.mods.fml.common.eventhandler;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.MapMaker;
/*     */ import com.google.common.reflect.TypeToken;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.MinecraftDummyContainer;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import javax.annotation.Nonnull;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventBus
/*     */   implements IEventExceptionHandler
/*     */ {
/*  25 */   private static int maxID = 0;
/*     */   
/*  27 */   private ConcurrentHashMap<Object, ArrayList<IEventListener>> listeners = new ConcurrentHashMap<Object, ArrayList<IEventListener>>();
/*  28 */   private Map<Object, ModContainer> listenerOwners = (new MapMaker()).weakKeys().weakValues().makeMap();
/*  29 */   private final int busID = maxID++;
/*     */   
/*     */   private IEventExceptionHandler exceptionHandler;
/*     */   
/*     */   public EventBus() {
/*  34 */     ListenerList.resize(this.busID + 1);
/*  35 */     this.exceptionHandler = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public EventBus(@Nonnull IEventExceptionHandler handler) {
/*  40 */     this();
/*  41 */     Preconditions.checkArgument((handler != null), "EventBus exception handler can not be null");
/*  42 */     this.exceptionHandler = handler;
/*     */   }
/*     */   
/*     */   public void register(Object target) {
/*     */     MinecraftDummyContainer minecraftDummyContainer;
/*  47 */     if (this.listeners.containsKey(target)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  52 */     ModContainer activeModContainer = Loader.instance().activeModContainer();
/*  53 */     if (activeModContainer == null) {
/*     */       
/*  55 */       FMLLog.log(Level.ERROR, new Throwable(), "Unable to determine registrant mod for %s. This is a critical error and should be impossible", new Object[] { target });
/*  56 */       minecraftDummyContainer = Loader.instance().getMinecraftModContainer();
/*     */     } 
/*  58 */     this.listenerOwners.put(target, minecraftDummyContainer);
/*  59 */     Set<? extends Class<?>> supers = TypeToken.of(target.getClass()).getTypes().rawTypes();
/*  60 */     for (Method method : target.getClass().getMethods()) {
/*     */       
/*  62 */       for (Class<?> cls : supers) {
/*     */ 
/*     */         
/*     */         try {
/*  66 */           Method real = cls.getDeclaredMethod(method.getName(), method.getParameterTypes());
/*  67 */           if (real.isAnnotationPresent((Class)SubscribeEvent.class)) {
/*     */             
/*  69 */             Class<?>[] parameterTypes = method.getParameterTypes();
/*  70 */             if (parameterTypes.length != 1)
/*     */             {
/*  72 */               throw new IllegalArgumentException("Method " + method + " has @SubscribeEvent annotation, but requires " + parameterTypes.length + " arguments.  Event handler methods must require a single argument.");
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  78 */             Class<?> eventType = parameterTypes[0];
/*     */             
/*  80 */             if (!Event.class.isAssignableFrom(eventType))
/*     */             {
/*  82 */               throw new IllegalArgumentException("Method " + method + " has @SubscribeEvent annotation, but takes a argument that is not an Event " + eventType);
/*     */             }
/*     */             
/*  85 */             register(eventType, target, method, (ModContainer)minecraftDummyContainer);
/*     */             
/*     */             break;
/*     */           } 
/*  89 */         } catch (NoSuchMethodException noSuchMethodException) {}
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void register(Class<?> eventType, Object target, Method method, ModContainer owner) {
/*     */     try {
/* 101 */       Constructor<?> ctr = eventType.getConstructor(new Class[0]);
/* 102 */       ctr.setAccessible(true);
/* 103 */       Event event = (Event)ctr.newInstance(new Object[0]);
/* 104 */       ASMEventHandler listener = new ASMEventHandler(target, method, owner);
/* 105 */       event.getListenerList().register(this.busID, listener.getPriority(), listener);
/*     */       
/* 107 */       ArrayList<IEventListener> others = this.listeners.get(target);
/* 108 */       if (others == null) {
/*     */         
/* 110 */         others = new ArrayList<IEventListener>();
/* 111 */         this.listeners.put(target, others);
/*     */       } 
/* 113 */       others.add(listener);
/*     */     }
/* 115 */     catch (Exception e) {
/*     */       
/* 117 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void unregister(Object object) {
/* 123 */     ArrayList<IEventListener> list = this.listeners.remove(object);
/* 124 */     if (list == null)
/*     */       return; 
/* 126 */     for (IEventListener listener : list)
/*     */     {
/* 128 */       ListenerList.unregisterAll(this.busID, listener);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean post(Event event) {
/* 134 */     IEventListener[] listeners = event.getListenerList().getListeners(this.busID);
/* 135 */     int index = 0;
/*     */     
/*     */     try {
/* 138 */       for (; index < listeners.length; index++)
/*     */       {
/* 140 */         listeners[index].invoke(event);
/*     */       }
/*     */     }
/* 143 */     catch (Throwable throwable) {
/*     */       
/* 145 */       this.exceptionHandler.handleException(this, event, listeners, index, throwable);
/* 146 */       Throwables.propagate(throwable);
/*     */     } 
/* 148 */     return event.isCancelable() ? event.isCanceled() : false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleException(EventBus bus, Event event, IEventListener[] listeners, int index, Throwable throwable) {
/* 154 */     FMLLog.log(Level.ERROR, throwable, "Exception caught during firing event %s:", new Object[] { event });
/* 155 */     FMLLog.log(Level.ERROR, "Index: %d Listeners:", new Object[] { Integer.valueOf(index) });
/* 156 */     for (int x = 0; x < listeners.length; x++) {
/*     */       
/* 158 */       FMLLog.log(Level.ERROR, "%d: %s", new Object[] { Integer.valueOf(x), listeners[x] });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\eventhandler\EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */