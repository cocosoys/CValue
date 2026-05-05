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
/*    */ public class JsonElementNull
/*    */   implements JsonElement
/*    */ {
/* 36 */   public static final JsonElementNull NULL = new JsonElementNull();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 42 */     return "null";
/*    */   }
/*    */   
/*    */   public String toString() {
/* 46 */     return "json null";
/*    */   }
/*    */   
/*    */   public boolean isPrimitive() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public String toPrimitiveString() {
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonElementNull.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */