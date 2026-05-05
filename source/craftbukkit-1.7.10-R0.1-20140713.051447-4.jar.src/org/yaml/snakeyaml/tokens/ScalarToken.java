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
/*    */ public final class ScalarToken
/*    */   extends Token
/*    */ {
/*    */   private final String value;
/*    */   private final boolean plain;
/*    */   private final char style;
/*    */   
/*    */   public ScalarToken(String value, Mark startMark, Mark endMark, boolean plain) {
/* 27 */     this(value, plain, startMark, endMark, false);
/*    */   }
/*    */   
/*    */   public ScalarToken(String value, boolean plain, Mark startMark, Mark endMark, char style) {
/* 31 */     super(startMark, endMark);
/* 32 */     this.value = value;
/* 33 */     this.plain = plain;
/* 34 */     this.style = style;
/*    */   }
/*    */   
/*    */   public boolean getPlain() {
/* 38 */     return this.plain;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 42 */     return this.value;
/*    */   }
/*    */   
/*    */   public char getStyle() {
/* 46 */     return this.style;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getArguments() {
/* 51 */     return "value=" + this.value + ", plain=" + this.plain + ", style=" + this.style;
/*    */   }
/*    */ 
/*    */   
/*    */   public Token.ID getTokenId() {
/* 56 */     return Token.ID.Scalar;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\tokens\ScalarToken.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */