/*    */ package com.avaje.ebean.text.json;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
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
/*    */ public class JsonReadOptions
/*    */ {
/*    */   protected JsonValueAdapter valueAdapter;
/* 50 */   protected Map<String, JsonReadBeanVisitor<?>> visitorMap = new LinkedHashMap<String, JsonReadBeanVisitor<?>>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonValueAdapter getValueAdapter() {
/* 57 */     return this.valueAdapter;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, JsonReadBeanVisitor<?>> getVisitorMap() {
/* 64 */     return this.visitorMap;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonReadOptions setValueAdapter(JsonValueAdapter valueAdapter) {
/* 71 */     this.valueAdapter = valueAdapter;
/* 72 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonReadOptions addRootVisitor(JsonReadBeanVisitor<?> visitor) {
/* 79 */     return addVisitor(null, visitor);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonReadOptions addVisitor(String path, JsonReadBeanVisitor<?> visitor) {
/* 86 */     this.visitorMap.put(path, visitor);
/* 87 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonReadOptions.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */