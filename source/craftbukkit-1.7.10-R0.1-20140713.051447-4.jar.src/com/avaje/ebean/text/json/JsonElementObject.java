/*    */ package com.avaje.ebean.text.json;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
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
/*    */ public class JsonElementObject
/*    */   implements JsonElement
/*    */ {
/* 40 */   private final Map<String, JsonElement> map = new LinkedHashMap<String, JsonElement>();
/*    */   
/*    */   public void put(String key, JsonElement value) {
/* 43 */     this.map.put(key, value);
/*    */   }
/*    */   
/*    */   public JsonElement get(String key) {
/* 47 */     return this.map.get(key);
/*    */   }
/*    */   
/*    */   public JsonElement getValue(String key) {
/* 51 */     return this.map.get(key);
/*    */   }
/*    */   
/*    */   public Set<String> keySet() {
/* 55 */     return this.map.keySet();
/*    */   }
/*    */   
/*    */   public Set<Map.Entry<String, JsonElement>> entrySet() {
/* 59 */     return this.map.entrySet();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     return this.map.toString();
/*    */   }
/*    */   
/*    */   public boolean isPrimitive() {
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public String toPrimitiveString() {
/* 71 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonElementObject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */