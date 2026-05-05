/*     */ package com.avaje.ebean.text.json;
/*     */ 
/*     */ import com.avaje.ebean.text.PathProperties;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JsonWriteOptions
/*     */ {
/*     */   protected String callback;
/*     */   protected JsonValueAdapter valueAdapter;
/*     */   protected Map<String, JsonWriteBeanVisitor<?>> visitorMap;
/*     */   protected PathProperties pathProperties;
/*     */   
/*     */   public JsonWriteOptions copy() {
/* 104 */     JsonWriteOptions copy = new JsonWriteOptions();
/* 105 */     copy.callback = this.callback;
/* 106 */     copy.valueAdapter = this.valueAdapter;
/* 107 */     copy.pathProperties = this.pathProperties;
/* 108 */     if (this.visitorMap != null) {
/* 109 */       copy.visitorMap = new HashMap<String, JsonWriteBeanVisitor<?>>(this.visitorMap);
/*     */     }
/* 111 */     return copy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCallback() {
/* 118 */     return this.callback;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriteOptions setCallback(String callback) {
/* 125 */     this.callback = callback;
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonValueAdapter getValueAdapter() {
/* 133 */     return this.valueAdapter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriteOptions setValueAdapter(JsonValueAdapter valueAdapter) {
/* 140 */     this.valueAdapter = valueAdapter;
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriteOptions setRootPathVisitor(JsonWriteBeanVisitor<?> visitor) {
/* 148 */     return setPathVisitor(null, visitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriteOptions setPathVisitor(String path, JsonWriteBeanVisitor<?> visitor) {
/* 155 */     if (this.visitorMap == null) {
/* 156 */       this.visitorMap = new HashMap<String, JsonWriteBeanVisitor<?>>();
/*     */     }
/* 158 */     this.visitorMap.put(path, visitor);
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriteOptions setPathProperties(String path, Set<String> propertiesToInclude) {
/* 169 */     if (this.pathProperties == null) {
/* 170 */       this.pathProperties = new PathProperties();
/*     */     }
/* 172 */     this.pathProperties.put(path, propertiesToInclude);
/* 173 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriteOptions setPathProperties(String path, String propertiesToInclude) {
/* 183 */     return setPathProperties(path, parseProps(propertiesToInclude));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriteOptions setRootPathProperties(String propertiesToInclude) {
/* 193 */     return setPathProperties((String)null, parseProps(propertiesToInclude));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonWriteOptions setRootPathProperties(Set<String> propertiesToInclude) {
/* 203 */     return setPathProperties((String)null, propertiesToInclude);
/*     */   }
/*     */ 
/*     */   
/*     */   private Set<String> parseProps(String propertiesToInclude) {
/* 208 */     LinkedHashSet<String> props = new LinkedHashSet<String>();
/*     */     
/* 210 */     String[] split = propertiesToInclude.split(",");
/* 211 */     for (int i = 0; i < split.length; i++) {
/* 212 */       String s = split[i].trim();
/* 213 */       if (s.length() > 0) {
/* 214 */         props.add(s);
/*     */       }
/*     */     } 
/* 217 */     return props;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, JsonWriteBeanVisitor<?>> getVisitorMap() {
/* 224 */     return this.visitorMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPathProperties(PathProperties pathProperties) {
/* 231 */     this.pathProperties = pathProperties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PathProperties getPathProperties() {
/* 238 */     return this.pathProperties;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonWriteOptions.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */