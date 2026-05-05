/*    */ package org.yaml.snakeyaml.tokens;
/*    */ 
/*    */ import org.yaml.snakeyaml.error.Mark;
/*    */ import org.yaml.snakeyaml.error.YAMLException;
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
/*    */ public abstract class Token
/*    */ {
/*    */   private final Mark startMark;
/*    */   private final Mark endMark;
/*    */   
/*    */   public enum ID
/*    */   {
/* 24 */     Alias, Anchor, BlockEnd, BlockEntry, BlockMappingStart, BlockSequenceStart, Directive, DocumentEnd, DocumentStart, FlowEntry, FlowMappingEnd, FlowMappingStart, FlowSequenceEnd, FlowSequenceStart, Key, Scalar, StreamEnd, StreamStart, Tag, Value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Token(Mark startMark, Mark endMark) {
/* 31 */     if (startMark == null || endMark == null) {
/* 32 */       throw new YAMLException("Token requires marks.");
/*    */     }
/* 34 */     this.startMark = startMark;
/* 35 */     this.endMark = endMark;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 39 */     return "<" + getClass().getName() + "(" + getArguments() + ")>";
/*    */   }
/*    */   
/*    */   public Mark getStartMark() {
/* 43 */     return this.startMark;
/*    */   }
/*    */   
/*    */   public Mark getEndMark() {
/* 47 */     return this.endMark;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getArguments() {
/* 54 */     return "";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract ID getTokenId();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 69 */     if (obj instanceof Token) {
/* 70 */       return toString().equals(obj.toString());
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\tokens\Token.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */