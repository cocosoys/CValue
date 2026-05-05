/*    */ package com.avaje.ebean.config;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PropertyMap
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 16 */   private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
/*    */   
/*    */   public String toString() {
/* 19 */     return this.map.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void evaluateProperties() {
/* 28 */     for (Map.Entry<String, String> e : entrySet()) {
/* 29 */       String key = e.getKey();
/* 30 */       String val = e.getValue();
/* 31 */       String eval = eval(val);
/* 32 */       if (eval != null && !eval.equals(val)) {
/* 33 */         put(key, eval);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public synchronized String eval(String val) {
/* 39 */     return PropertyExpression.eval(val, this);
/*    */   }
/*    */   
/*    */   public synchronized boolean getBoolean(String key, boolean defaultValue) {
/* 43 */     String value = get(key);
/* 44 */     if (value == null) {
/* 45 */       return defaultValue;
/*    */     }
/* 47 */     return Boolean.parseBoolean(value);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized int getInt(String key, int defaultValue) {
/* 52 */     String value = get(key);
/* 53 */     if (value == null) {
/* 54 */       return defaultValue;
/*    */     }
/* 56 */     return Integer.parseInt(value);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized String get(String key, String defaultValue) {
/* 61 */     String value = this.map.get(key.toLowerCase());
/* 62 */     return (value == null) ? defaultValue : value;
/*    */   }
/*    */   
/*    */   public synchronized String get(String key) {
/* 66 */     return this.map.get(key.toLowerCase());
/*    */   }
/*    */   
/*    */   synchronized void putAll(Map<String, String> keyValueMap) {
/* 70 */     Iterator<Map.Entry<String, String>> it = keyValueMap.entrySet().iterator();
/* 71 */     while (it.hasNext()) {
/* 72 */       Map.Entry<String, String> entry = it.next();
/* 73 */       put(entry.getKey(), entry.getValue());
/*    */     } 
/*    */   }
/*    */   
/*    */   synchronized String putEval(String key, String value) {
/* 78 */     value = PropertyExpression.eval(value, this);
/* 79 */     return this.map.put(key.toLowerCase(), value);
/*    */   }
/*    */   
/*    */   synchronized String put(String key, String value) {
/* 83 */     return this.map.put(key.toLowerCase(), value);
/*    */   }
/*    */   
/*    */   synchronized String remove(String key) {
/* 87 */     return this.map.remove(key.toLowerCase());
/*    */   }
/*    */   
/*    */   synchronized Set<Map.Entry<String, String>> entrySet() {
/* 91 */     return this.map.entrySet();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\PropertyMap.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */