/*    */ package org.yaml.snakeyaml.emitter;
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
/*    */ public final class ScalarAnalysis
/*    */ {
/*    */   public String scalar;
/*    */   public boolean empty;
/*    */   public boolean multiline;
/*    */   public boolean allowFlowPlain;
/*    */   public boolean allowBlockPlain;
/*    */   public boolean allowSingleQuoted;
/*    */   public boolean allowDoubleQuoted;
/*    */   public boolean allowBlock;
/*    */   
/*    */   public ScalarAnalysis(String scalar, boolean empty, boolean multiline, boolean allowFlowPlain, boolean allowBlockPlain, boolean allowSingleQuoted, boolean allowDoubleQuoted, boolean allowBlock) {
/* 32 */     this.scalar = scalar;
/* 33 */     this.empty = empty;
/* 34 */     this.multiline = multiline;
/* 35 */     this.allowFlowPlain = allowFlowPlain;
/* 36 */     this.allowBlockPlain = allowBlockPlain;
/* 37 */     this.allowSingleQuoted = allowSingleQuoted;
/* 38 */     this.allowDoubleQuoted = allowDoubleQuoted;
/* 39 */     this.allowBlock = allowBlock;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\emitter\ScalarAnalysis.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */