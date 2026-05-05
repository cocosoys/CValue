/*    */ package org.yaml.snakeyaml.events;
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
/*    */ public class ImplicitTuple
/*    */ {
/*    */   private final boolean plain;
/*    */   private final boolean nonPlain;
/*    */   
/*    */   public ImplicitTuple(boolean plain, boolean nonplain) {
/* 31 */     this.plain = plain;
/* 32 */     this.nonPlain = nonplain;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canOmitTagInPlainScalar() {
/* 40 */     return this.plain;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canOmitTagInNonPlainScalar() {
/* 48 */     return this.nonPlain;
/*    */   }
/*    */   
/*    */   public boolean bothFalse() {
/* 52 */     return (!this.plain && !this.nonPlain);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 57 */     return "implicit=[" + this.plain + ", " + this.nonPlain + "]";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\events\ImplicitTuple.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */