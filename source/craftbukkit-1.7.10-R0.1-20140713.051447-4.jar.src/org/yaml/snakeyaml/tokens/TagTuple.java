/*    */ package org.yaml.snakeyaml.tokens;
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
/*    */ public final class TagTuple
/*    */ {
/*    */   private final String handle;
/*    */   private final String suffix;
/*    */   
/*    */   public TagTuple(String handle, String suffix) {
/* 24 */     if (suffix == null) {
/* 25 */       throw new NullPointerException("Suffix must be provided.");
/*    */     }
/* 27 */     this.handle = handle;
/* 28 */     this.suffix = suffix;
/*    */   }
/*    */   
/*    */   public String getHandle() {
/* 32 */     return this.handle;
/*    */   }
/*    */   
/*    */   public String getSuffix() {
/* 36 */     return this.suffix;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\tokens\TagTuple.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */