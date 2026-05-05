/*     */ package org.yaml.snakeyaml;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.yaml.snakeyaml.nodes.Tag;
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
/*     */ public final class TypeDescription
/*     */ {
/*     */   private final Class<? extends Object> type;
/*     */   private Tag tag;
/*     */   private Map<String, Class<? extends Object>> listProperties;
/*     */   private Map<String, Class<? extends Object>> keyProperties;
/*     */   private Map<String, Class<? extends Object>> valueProperties;
/*     */   
/*     */   public TypeDescription(Class<? extends Object> clazz, Tag tag) {
/*  36 */     this.type = clazz;
/*  37 */     this.tag = tag;
/*  38 */     this.listProperties = new HashMap<String, Class<? extends Object>>();
/*  39 */     this.keyProperties = new HashMap<String, Class<? extends Object>>();
/*  40 */     this.valueProperties = new HashMap<String, Class<? extends Object>>();
/*     */   }
/*     */   
/*     */   public TypeDescription(Class<? extends Object> clazz, String tag) {
/*  44 */     this(clazz, new Tag(tag));
/*     */   }
/*     */   
/*     */   public TypeDescription(Class<? extends Object> clazz) {
/*  48 */     this(clazz, (Tag)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tag getTag() {
/*  58 */     return this.tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTag(Tag tag) {
/*  68 */     this.tag = tag;
/*     */   }
/*     */   
/*     */   public void setTag(String tag) {
/*  72 */     setTag(new Tag(tag));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends Object> getType() {
/*  81 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putListPropertyType(String property, Class<? extends Object> type) {
/*  93 */     this.listProperties.put(property, type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends Object> getListPropertyType(String property) {
/* 104 */     return this.listProperties.get(property);
/*     */   }
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
/*     */   public void putMapPropertyType(String property, Class<? extends Object> key, Class<? extends Object> value) {
/* 119 */     this.keyProperties.put(property, key);
/* 120 */     this.valueProperties.put(property, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends Object> getMapKeyType(String property) {
/* 131 */     return this.keyProperties.get(property);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends Object> getMapValueType(String property) {
/* 142 */     return this.valueProperties.get(property);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 147 */     return "TypeDescription for " + getType() + " (tag='" + getTag() + "')";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\TypeDescription.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */