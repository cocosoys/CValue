/*    */ package org.yaml.snakeyaml.constructor;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomClassLoaderConstructor
/*    */   extends Constructor
/*    */ {
/* 23 */   private ClassLoader loader = CustomClassLoaderConstructor.class.getClassLoader();
/*    */   
/*    */   public CustomClassLoaderConstructor(ClassLoader cLoader) {
/* 26 */     this(Object.class, cLoader);
/*    */   }
/*    */   
/*    */   public CustomClassLoaderConstructor(Class<? extends Object> theRoot, ClassLoader theLoader) {
/* 30 */     super(theRoot);
/* 31 */     if (theLoader == null) {
/* 32 */       throw new NullPointerException("Loader must be provided.");
/*    */     }
/* 34 */     this.loader = theLoader;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Class<?> getClassForName(String name) throws ClassNotFoundException {
/* 39 */     return Class.forName(name, true, this.loader);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\constructor\CustomClassLoaderConstructor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */