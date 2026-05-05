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
/*    */ public final class AliasToken
/*    */   extends Token
/*    */ {
/*    */   private final String value;
/*    */   
/*    */   public AliasToken(String value, Mark startMark, Mark endMark) {
/* 25 */     super(startMark, endMark);
/* 26 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 30 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getArguments() {
/* 35 */     return "value=" + this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public Token.ID getTokenId() {
/* 40 */     return Token.ID.Alias;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\tokens\AliasToken.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */