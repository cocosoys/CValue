/*    */ package org.yaml.snakeyaml;
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
/*    */ public class LoaderOptions
/*    */ {
/*    */   private TypeDescription rootTypeDescription;
/*    */   
/*    */   public LoaderOptions() {
/* 23 */     this(new TypeDescription(Object.class));
/*    */   }
/*    */   
/*    */   public LoaderOptions(TypeDescription rootTypeDescription) {
/* 27 */     this.rootTypeDescription = rootTypeDescription;
/*    */   }
/*    */   
/*    */   public TypeDescription getRootTypeDescription() {
/* 31 */     return this.rootTypeDescription;
/*    */   }
/*    */   
/*    */   public void setRootTypeDescription(TypeDescription rootTypeDescription) {
/* 35 */     this.rootTypeDescription = rootTypeDescription;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\LoaderOptions.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */