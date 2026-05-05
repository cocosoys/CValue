/*     */ package com.avaje.ebean.config.lucene;
/*     */ 
/*     */ import org.apache.lucene.analysis.Analyzer;
/*     */ import org.apache.lucene.document.Field;
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
/*     */ public class IndexFieldDefn
/*     */ {
/*     */   protected final String name;
/*     */   protected String propertyName;
/*     */   protected Field.Index index;
/*     */   protected Field.Store store;
/*     */   protected Sortable sortable;
/*     */   
/*     */   public enum Sortable
/*     */   {
/*  32 */     YES,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     DEFAULT;
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
/*  51 */   protected int precisionStep = -1;
/*     */   
/*     */   protected float boost;
/*     */   
/*     */   protected Analyzer queryAnalyzer;
/*     */   
/*     */   protected Analyzer indexAnalyzer;
/*     */   
/*     */   protected String[] properties;
/*     */   
/*     */   public IndexFieldDefn(String name) {
/*  62 */     this.name = name;
/*  63 */     this.propertyName = name;
/*     */   }
/*     */   
/*     */   public IndexFieldDefn(String name, Field.Store store, Field.Index index, Sortable sortable) {
/*  67 */     this(name);
/*  68 */     this.store = store;
/*  69 */     this.index = index;
/*  70 */     this.sortable = sortable;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  74 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn copyField(String name) {
/*  85 */     IndexFieldDefn copy = new IndexFieldDefn(name, this.store, this.index, this.sortable);
/*  86 */     copy.setPropertyName(name);
/*     */     
/*  88 */     copy.setIndexAnalyzer(this.indexAnalyzer);
/*  89 */     copy.setQueryAnalyzer(this.queryAnalyzer);
/*  90 */     copy.setPrecisionStep(this.precisionStep);
/*  91 */     copy.setBoost(this.boost);
/*     */     
/*  93 */     return copy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn copyFieldConcat(String fieldName, String[] properties) {
/* 100 */     IndexFieldDefn copy = copyField(fieldName);
/* 101 */     copy.setPropertyName(null);
/* 102 */     copy.setPropertyNames(properties);
/* 103 */     return copy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 110 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyName() {
/* 117 */     return this.propertyName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn setPropertyName(String propertyName) {
/* 124 */     this.propertyName = propertyName;
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Field.Index getIndex() {
/* 132 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn setIndex(Field.Index index) {
/* 139 */     this.index = index;
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Field.Store getStore() {
/* 147 */     return this.store;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn setStore(Field.Store store) {
/* 154 */     this.store = store;
/* 155 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sortable getSortable() {
/* 162 */     return this.sortable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn setSortable(Sortable sortable) {
/* 169 */     this.sortable = sortable;
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPrecisionStep() {
/* 177 */     return this.precisionStep;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn setPrecisionStep(int precisionStep) {
/* 184 */     this.precisionStep = precisionStep;
/* 185 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getBoost() {
/* 192 */     return this.boost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBoost(float boost) {
/* 199 */     this.boost = boost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Analyzer getQueryAnalyzer() {
/* 206 */     return this.queryAnalyzer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Analyzer getIndexAnalyzer() {
/* 213 */     return this.indexAnalyzer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn setQueryAnalyzer(Analyzer queryAnalyzer) {
/* 220 */     this.queryAnalyzer = queryAnalyzer;
/* 221 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn setIndexAnalyzer(Analyzer indexAnalyzer) {
/* 228 */     this.indexAnalyzer = indexAnalyzer;
/* 229 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IndexFieldDefn setBothAnalyzers(Analyzer analyzer) {
/* 236 */     this.queryAnalyzer = analyzer;
/* 237 */     this.indexAnalyzer = analyzer;
/* 238 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getPropertyNames() {
/* 245 */     return this.properties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyNames(String[] properties) {
/* 252 */     this.properties = properties;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\lucene\IndexFieldDefn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */