/*    */ package org.yaml.snakeyaml.tokens;
/*    */ 
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DirectiveToken<T>
/*    */   extends Token
/*    */ {
/*    */   private final String name;
/*    */   private final List<T> value;
/*    */   
/*    */   public DirectiveToken(String name, List<T> value, Mark startMark, Mark endMark) {
/* 29 */     super(startMark, endMark);
/* 30 */     this.name = name;
/* 31 */     if (value != null && value.size() != 2) {
/* 32 */       throw new YAMLException("Two strings must be provided instead of " + String.valueOf(value.size()));
/*    */     }
/*    */     
/* 35 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 39 */     return this.name;
/*    */   }
/*    */   
/*    */   public List<T> getValue() {
/* 43 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getArguments() {
/* 48 */     if (this.value != null) {
/* 49 */       return "name=" + this.name + ", value=[" + this.value.get(0) + ", " + this.value.get(1) + "]";
/*    */     }
/* 51 */     return "name=" + this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Token.ID getTokenId() {
/* 57 */     return Token.ID.Directive;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\tokens\DirectiveToken.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */