/*    */ package org.yaml.snakeyaml.scanner;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class SimpleKey
/*    */ {
/*    */   private int tokenNumber;
/*    */   private boolean required;
/*    */   private int index;
/*    */   private int line;
/*    */   private int column;
/*    */   private Mark mark;
/*    */   
/*    */   public SimpleKey(int tokenNumber, boolean required, int index, int line, int column, Mark mark) {
/* 38 */     this.tokenNumber = tokenNumber;
/* 39 */     this.required = required;
/* 40 */     this.index = index;
/* 41 */     this.line = line;
/* 42 */     this.column = column;
/* 43 */     this.mark = mark;
/*    */   }
/*    */   
/*    */   public int getTokenNumber() {
/* 47 */     return this.tokenNumber;
/*    */   }
/*    */   
/*    */   public int getColumn() {
/* 51 */     return this.column;
/*    */   }
/*    */   
/*    */   public Mark getMark() {
/* 55 */     return this.mark;
/*    */   }
/*    */   
/*    */   public int getIndex() {
/* 59 */     return this.index;
/*    */   }
/*    */   
/*    */   public int getLine() {
/* 63 */     return this.line;
/*    */   }
/*    */   
/*    */   public boolean isRequired() {
/* 67 */     return this.required;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     return "SimpleKey - tokenNumber=" + this.tokenNumber + " required=" + this.required + " index=" + this.index + " line=" + this.line + " column=" + this.column;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\scanner\SimpleKey.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */