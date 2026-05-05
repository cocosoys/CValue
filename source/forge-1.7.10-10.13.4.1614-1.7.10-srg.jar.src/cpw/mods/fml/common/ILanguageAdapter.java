/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ public interface ILanguageAdapter {
/*     */   Object getNewInstance(FMLModContainer paramFMLModContainer, Class<?> paramClass, ClassLoader paramClassLoader, Method paramMethod) throws Exception;
/*     */   
/*     */   boolean supportsStatics();
/*     */   
/*     */   void setProxy(Field paramField, Class<?> paramClass, Object paramObject) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
/*     */   
/*     */   void setInternalProxies(ModContainer paramModContainer, Side paramSide, ClassLoader paramClassLoader);
/*     */   
/*     */   public static class ScalaAdapter implements ILanguageAdapter {
/*     */     public Object getNewInstance(FMLModContainer container, Class<?> scalaObjectClass, ClassLoader classLoader, Method factoryMarkedAnnotation) throws Exception {
/*  20 */       Class<?> sObjectClass = Class.forName(scalaObjectClass.getName() + "$", true, classLoader);
/*  21 */       return sObjectClass.getField("MODULE$").get(null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean supportsStatics() {
/*  27 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setProxy(Field target, Class<?> proxyTarget, Object proxy) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
/*     */       try {
/*  48 */         if (!proxyTarget.getName().endsWith("$"))
/*     */         {
/*     */           
/*  51 */           proxyTarget = Class.forName(proxyTarget.getName() + "$", true, proxyTarget.getClassLoader());
/*     */         }
/*     */       }
/*  54 */       catch (ClassNotFoundException e) {
/*     */ 
/*     */         
/*  57 */         FMLLog.log(Level.INFO, e, "An error occured trying to load a proxy into %s.%s. Did you declare your mod as 'class' instead of 'object'?", new Object[] { proxyTarget.getSimpleName(), target.getName() });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */ 
/*     */       
/*  64 */       Object targetInstance = proxyTarget.getField("MODULE$").get(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/*  76 */         String setterName = target.getName() + "_$eq";
/*  77 */         for (Method setter : proxyTarget.getMethods()) {
/*     */           
/*  79 */           Class<?>[] setterParameters = setter.getParameterTypes();
/*  80 */           if (setterName.equals(setter.getName()) && setterParameters.length == 1 && setterParameters[0]
/*     */ 
/*     */             
/*  83 */             .isAssignableFrom(proxy.getClass())) {
/*     */ 
/*     */             
/*  86 */             setter.invoke(targetInstance, new Object[] { proxy });
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*  91 */       } catch (InvocationTargetException e) {
/*     */         
/*  93 */         FMLLog.log(Level.ERROR, e, "An error occured trying to load a proxy into %s.%s", new Object[] { proxyTarget.getSimpleName(), target.getName() });
/*  94 */         throw new LoaderException(e);
/*     */       } 
/*     */ 
/*     */       
/*  98 */       FMLLog.severe("Failed loading proxy into %s.%s, could not find setter function. Did you declare the field with 'val' instead of 'var'?", new Object[] { proxyTarget.getSimpleName(), target.getName() });
/*  99 */       throw new LoaderException(String.format("Failed loading proxy into %s.%s, could not find setter function. Did you declare the field with 'val' instead of 'var'?", new Object[] { proxyTarget.getSimpleName(), target.getName() }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setInternalProxies(ModContainer mod, Side side, ClassLoader loader) {
/* 125 */       Class<?> proxyTarget = mod.getMod().getClass();
/* 126 */       if (proxyTarget.getName().endsWith("$")) {
/*     */ 
/*     */         
/* 129 */         for (Field target : proxyTarget.getDeclaredFields()) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 134 */           if (target.getAnnotation(SidedProxy.class) != null) {
/*     */             
/* 136 */             String targetType = side.isClient() ? ((SidedProxy)target.<SidedProxy>getAnnotation(SidedProxy.class)).clientSide() : ((SidedProxy)target.<SidedProxy>getAnnotation(SidedProxy.class)).serverSide();
/*     */             
/*     */             try {
/* 139 */               Object proxy = Class.forName(targetType, true, loader).newInstance();
/*     */               
/* 141 */               if (!target.getType().isAssignableFrom(proxy.getClass())) {
/*     */                 
/* 143 */                 FMLLog.severe("Attempted to load a proxy type %s into %s.%s, but the types don't match", new Object[] { targetType, proxyTarget.getSimpleName(), target.getName() });
/* 144 */                 throw new LoaderException(String.format("Attempted to load a proxy type %s into %s.%s, but the types don't match", new Object[] { targetType, proxyTarget.getSimpleName(), target.getName() }));
/*     */               } 
/*     */               
/* 147 */               setProxy(target, proxyTarget, proxy);
/*     */             }
/* 149 */             catch (Exception e) {
/* 150 */               FMLLog.log(Level.ERROR, e, "An error occured trying to load a proxy into %s.%s", new Object[] { proxyTarget.getSimpleName(), target.getName() });
/* 151 */               throw new LoaderException(e);
/*     */             }
/*     */           
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 158 */         FMLLog.finer("Mod does not appear to be a singleton.", new Object[0]);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class JavaAdapter
/*     */     implements ILanguageAdapter
/*     */   {
/*     */     public Object getNewInstance(FMLModContainer container, Class<?> objectClass, ClassLoader classLoader, Method factoryMarkedMethod) throws Exception {
/* 167 */       if (factoryMarkedMethod != null)
/*     */       {
/* 169 */         return factoryMarkedMethod.invoke(null, new Object[0]);
/*     */       }
/*     */ 
/*     */       
/* 173 */       return objectClass.newInstance();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean supportsStatics() {
/* 180 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setProxy(Field target, Class<?> proxyTarget, Object proxy) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
/* 187 */       target.set(null, proxy);
/*     */     }
/*     */     
/*     */     public void setInternalProxies(ModContainer mod, Side side, ClassLoader loader) {}
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ILanguageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */