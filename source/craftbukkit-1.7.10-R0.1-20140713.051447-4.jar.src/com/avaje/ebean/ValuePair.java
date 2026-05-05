/*    */ package com.avaje.ebean;
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
/*    */ public class ValuePair
/*    */ {
/*    */   final Object value1;
/*    */   final Object value2;
/*    */   
/*    */   public ValuePair(Object value1, Object value2) {
/* 32 */     this.value1 = value1;
/* 33 */     this.value2 = value2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getValue1() {
/* 40 */     return this.value1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getValue2() {
/* 47 */     return this.value2;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 51 */     return this.value1 + "," + this.value2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\ValuePair.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */