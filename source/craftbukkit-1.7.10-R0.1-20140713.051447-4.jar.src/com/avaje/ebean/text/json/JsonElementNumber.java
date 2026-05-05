/*    */ package com.avaje.ebean.text.json;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonElementNumber
/*    */   implements JsonElement
/*    */ {
/*    */   private final String value;
/*    */   
/*    */   public JsonElementNumber(String value) {
/* 39 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 43 */     return this.value;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 47 */     return this.value;
/*    */   }
/*    */   
/*    */   public boolean isPrimitive() {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public String toPrimitiveString() {
/* 55 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonElementNumber.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */