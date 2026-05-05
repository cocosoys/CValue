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
/*    */ 
/*    */ public class JsonElementBoolean
/*    */   implements JsonElement
/*    */ {
/* 37 */   public static final JsonElementBoolean TRUE = new JsonElementBoolean(true);
/*    */   
/* 39 */   public static final JsonElementBoolean FALSE = new JsonElementBoolean(false);
/*    */   
/*    */   private final boolean value;
/*    */   
/*    */   private JsonElementBoolean(boolean value) {
/* 44 */     this.value = value;
/*    */   }
/*    */   
/*    */   public boolean getValue() {
/* 48 */     return this.value;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     return Boolean.toString(this.value);
/*    */   }
/*    */   
/*    */   public boolean isPrimitive() {
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   public String toPrimitiveString() {
/* 60 */     return Boolean.toString(this.value);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonElementBoolean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */