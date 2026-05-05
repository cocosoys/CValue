/*    */ package org.yaml.snakeyaml.tokens;
/*    */ 
/*    */ import org.yaml.snakeyaml.error.Mark;
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
/*    */ public final class TagToken
/*    */   extends Token
/*    */ {
/*    */   private final TagTuple value;
/*    */   
/*    */   public TagToken(TagTuple value, Mark startMark, Mark endMark) {
/* 25 */     super(startMark, endMark);
/* 26 */     this.value = value;
/*    */   }
/*    */   
/*    */   public TagTuple getValue() {
/* 30 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getArguments() {
/* 35 */     return "value=[" + this.value.getHandle() + ", " + this.value.getSuffix() + "]";
/*    */   }
/*    */ 
/*    */   
/*    */   public Token.ID getTokenId() {
/* 40 */     return Token.ID.Tag;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\tokens\TagToken.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */