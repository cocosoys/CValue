/*    */ package net.minecraft.util.io.netty.handler.codec.serialization;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CachingClassResolver
/*    */   implements ClassResolver
/*    */ {
/*    */   private final Map<String, Class<?>> classCache;
/*    */   private final ClassResolver delegate;
/*    */   
/*    */   CachingClassResolver(ClassResolver delegate, Map<String, Class<?>> classCache) {
/* 26 */     this.delegate = delegate;
/* 27 */     this.classCache = classCache;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> resolve(String className) throws ClassNotFoundException {
/* 34 */     Class<?> clazz = this.classCache.get(className);
/* 35 */     if (clazz != null) {
/* 36 */       return clazz;
/*    */     }
/*    */ 
/*    */     
/* 40 */     clazz = this.delegate.resolve(className);
/*    */     
/* 42 */     this.classCache.put(className, clazz);
/* 43 */     return clazz;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\serialization\CachingClassResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */