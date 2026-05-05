/*     */ package cpw.mods.fml.common.eventhandler;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
/*     */ import org.apache.logging.log4j.ThreadContext;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.Type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ASMEventHandler
/*     */   implements IEventListener
/*     */ {
/*  19 */   private static int IDs = 0;
/*  20 */   private static final String HANDLER_DESC = Type.getInternalName(IEventListener.class);
/*  21 */   private static final String HANDLER_FUNC_DESC = Type.getMethodDescriptor(IEventListener.class.getDeclaredMethods()[0]);
/*  22 */   private static final ASMClassLoader LOADER = new ASMClassLoader();
/*  23 */   private static final HashMap<Method, Class<?>> cache = Maps.newHashMap();
/*  24 */   private static final boolean GETCONTEXT = Boolean.parseBoolean(System.getProperty("fml.LogContext", "false"));
/*     */   
/*     */   private final IEventListener handler;
/*     */   
/*     */   private final SubscribeEvent subInfo;
/*     */   private ModContainer owner;
/*     */   private String readable;
/*     */   
/*     */   public ASMEventHandler(Object target, Method method, ModContainer owner) throws Exception {
/*  33 */     this.owner = owner;
/*  34 */     this.handler = createWrapper(method).getConstructor(new Class[] { Object.class }).newInstance(new Object[] { target });
/*  35 */     this.subInfo = method.<SubscribeEvent>getAnnotation(SubscribeEvent.class);
/*  36 */     this.readable = "ASM: " + target + " " + method.getName() + Type.getMethodDescriptor(method);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void invoke(Event event) {
/*  42 */     if (this.owner != null && GETCONTEXT) {
/*     */       
/*  44 */       ThreadContext.put("mod", this.owner.getName());
/*     */     }
/*  46 */     else if (GETCONTEXT) {
/*     */       
/*  48 */       ThreadContext.put("mod", "");
/*     */     } 
/*  50 */     if (this.handler != null)
/*     */     {
/*  52 */       if (!event.isCancelable() || !event.isCanceled() || this.subInfo.receiveCanceled())
/*     */       {
/*  54 */         this.handler.invoke(event);
/*     */       }
/*     */     }
/*  57 */     if (GETCONTEXT) {
/*  58 */       ThreadContext.remove("mod");
/*     */     }
/*     */   }
/*     */   
/*     */   public EventPriority getPriority() {
/*  63 */     return this.subInfo.priority();
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> createWrapper(Method callback) {
/*  68 */     if (cache.containsKey(callback))
/*     */     {
/*  70 */       return cache.get(callback);
/*     */     }
/*     */     
/*  73 */     ClassWriter cw = new ClassWriter(0);
/*     */ 
/*     */     
/*  76 */     String name = getUniqueName(callback);
/*  77 */     String desc = name.replace('.', '/');
/*  78 */     String instType = Type.getInternalName(callback.getDeclaringClass());
/*  79 */     String eventType = Type.getInternalName(callback.getParameterTypes()[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     cw.visit(50, 33, desc, null, "java/lang/Object", new String[] { HANDLER_DESC });
/*     */     
/*  91 */     cw.visitSource(".dynamic", null);
/*     */     
/*  93 */     cw.visitField(1, "instance", "Ljava/lang/Object;", null, null).visitEnd();
/*     */ 
/*     */     
/*  96 */     MethodVisitor mv = cw.visitMethod(1, "<init>", "(Ljava/lang/Object;)V", null, null);
/*  97 */     mv.visitCode();
/*  98 */     mv.visitVarInsn(25, 0);
/*  99 */     mv.visitMethodInsn(183, "java/lang/Object", "<init>", "()V", false);
/* 100 */     mv.visitVarInsn(25, 0);
/* 101 */     mv.visitVarInsn(25, 1);
/* 102 */     mv.visitFieldInsn(181, desc, "instance", "Ljava/lang/Object;");
/* 103 */     mv.visitInsn(177);
/* 104 */     mv.visitMaxs(2, 2);
/* 105 */     mv.visitEnd();
/*     */ 
/*     */     
/* 108 */     mv = cw.visitMethod(1, "invoke", HANDLER_FUNC_DESC, null, null);
/* 109 */     mv.visitCode();
/* 110 */     mv.visitVarInsn(25, 0);
/* 111 */     mv.visitFieldInsn(180, desc, "instance", "Ljava/lang/Object;");
/* 112 */     mv.visitTypeInsn(192, instType);
/* 113 */     mv.visitVarInsn(25, 1);
/* 114 */     mv.visitTypeInsn(192, eventType);
/* 115 */     mv.visitMethodInsn(182, instType, callback.getName(), Type.getMethodDescriptor(callback), false);
/* 116 */     mv.visitInsn(177);
/* 117 */     mv.visitMaxs(2, 2);
/* 118 */     mv.visitEnd();
/*     */     
/* 120 */     cw.visitEnd();
/* 121 */     Class<?> ret = LOADER.define(name, cw.toByteArray());
/* 122 */     cache.put(callback, ret);
/* 123 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   private String getUniqueName(Method callback) {
/* 128 */     return String.format("%s_%d_%s_%s_%s", new Object[] { getClass().getName(), Integer.valueOf(IDs++), callback
/* 129 */           .getDeclaringClass().getSimpleName(), callback
/* 130 */           .getName(), callback
/* 131 */           .getParameterTypes()[0].getSimpleName() });
/*     */   }
/*     */   
/*     */   private static class ASMClassLoader
/*     */     extends ClassLoader
/*     */   {
/*     */     private ASMClassLoader() {
/* 138 */       super(ASMClassLoader.class.getClassLoader());
/*     */     }
/*     */ 
/*     */     
/*     */     public Class<?> define(String name, byte[] data) {
/* 143 */       return defineClass(name, data, 0, data.length);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 149 */     return this.readable;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\eventhandler\ASMEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */