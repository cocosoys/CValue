/*    */ package com.avaje.ebean.text.json;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class JsonElementArray
/*    */   implements JsonElement
/*    */ {
/* 39 */   private final List<JsonElement> values = new ArrayList<JsonElement>();
/*    */   
/*    */   public List<JsonElement> getValues() {
/* 42 */     return this.values;
/*    */   }
/*    */   
/*    */   public void add(JsonElement value) {
/* 46 */     this.values.add(value);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 50 */     return this.values.toString();
/*    */   }
/*    */   
/*    */   public boolean isPrimitive() {
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public String toPrimitiveString() {
/* 58 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonElementArray.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */