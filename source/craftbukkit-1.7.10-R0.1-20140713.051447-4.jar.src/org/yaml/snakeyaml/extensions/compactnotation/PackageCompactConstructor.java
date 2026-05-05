/*    */ package org.yaml.snakeyaml.extensions.compactnotation;
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
/*    */ public class PackageCompactConstructor
/*    */   extends CompactConstructor
/*    */ {
/*    */   private String packageName;
/*    */   
/*    */   public PackageCompactConstructor(String packageName) {
/* 23 */     this.packageName = packageName;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Class<?> getClassForName(String name) throws ClassNotFoundException {
/* 28 */     if (name.indexOf('.') < 0) {
/*    */       try {
/* 30 */         Class<?> clazz = Class.forName(this.packageName + "." + name);
/* 31 */         return clazz;
/* 32 */       } catch (ClassNotFoundException e) {}
/*    */     }
/*    */ 
/*    */     
/* 36 */     return super.getClassForName(name);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\extensions\compactnotation\PackageCompactConstructor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */