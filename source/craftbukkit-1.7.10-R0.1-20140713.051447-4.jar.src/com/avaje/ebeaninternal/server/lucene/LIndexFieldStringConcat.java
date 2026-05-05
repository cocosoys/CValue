/*     */ package com.avaje.ebeaninternal.server.lucene;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.el.ElPropertyValue;
/*     */ import com.avaje.ebeaninternal.server.query.SplitName;
/*     */ import com.avaje.ebeaninternal.server.type.ScalarType;
/*     */ import java.io.StringReader;
/*     */ import java.util.Set;
/*     */ import org.apache.lucene.analysis.Analyzer;
/*     */ import org.apache.lucene.analysis.TokenStream;
/*     */ import org.apache.lucene.document.Document;
/*     */ import org.apache.lucene.document.Field;
/*     */ import org.apache.lucene.document.Fieldable;
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
/*     */ public final class LIndexFieldStringConcat
/*     */   extends LIndexFieldBase
/*     */ {
/*     */   private final ElPropertyValue[] properties;
/*     */   private final ScalarType<?>[] scalarTypes;
/*     */   private final Analyzer indexAnalyzer;
/*     */   
/*     */   public LIndexFieldStringConcat(Analyzer queryAnalyzer, String fieldName, FieldFactory fieldFactory, ElPropertyValue[] properties, Analyzer indexAnalyzer) {
/*  43 */     super(queryAnalyzer, fieldName, 0, null, fieldFactory);
/*  44 */     this.properties = properties;
/*  45 */     this.indexAnalyzer = indexAnalyzer;
/*  46 */     this.scalarTypes = (ScalarType<?>[])new ScalarType[properties.length];
/*  47 */     for (int i = 0; i < this.scalarTypes.length; i++) {
/*  48 */       this.scalarTypes[i] = properties[i].getBeanProperty().getScalarType();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void addIndexRequiredPropertyNames(Set<String> requiredPropertyNames) {
/*  54 */     for (int i = 0; i < this.properties.length; i++) {
/*  55 */       String prefix = this.properties[i].getElPrefix();
/*  56 */       String name = this.properties[i].getName();
/*  57 */       String fullPath = SplitName.add(prefix, name);
/*  58 */       requiredPropertyNames.add(fullPath);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addIndexResolvePropertyNames(Set<String> resolvePropertyNames) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void addIndexRestorePropertyNames(Set<String> restorePropertyNames) {}
/*     */ 
/*     */   
/*     */   public String getSortableProperty() {
/*  72 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isBeanProperty() {
/*  76 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void readValue(Document doc, Object bean) {}
/*     */ 
/*     */   
/*     */   public DocFieldWriter createDocFieldWriter() {
/*  84 */     Field f = (Field)this.fieldFactory.createFieldable();
/*  85 */     return new Writer(f, this.properties, (ScalarType[])this.scalarTypes, this.indexAnalyzer);
/*     */   }
/*     */   
/*     */   private static class Writer
/*     */     implements DocFieldWriter
/*     */   {
/*     */     private final Field field;
/*     */     private final ElPropertyValue[] properties;
/*     */     private final ScalarType<?>[] scalarTypes;
/*     */     private final Analyzer indexAnalyzer;
/*     */     
/*     */     private Writer(Field field, ElPropertyValue[] properties, ScalarType<?>[] scalarTypes, Analyzer indexAnalyzer) {
/*  97 */       this.field = field;
/*  98 */       this.properties = properties;
/*  99 */       this.scalarTypes = scalarTypes;
/* 100 */       this.indexAnalyzer = indexAnalyzer;
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeValue(Object bean, Document document) {
/* 105 */       StringBuilder sb = new StringBuilder();
/* 106 */       for (int i = 0; i < this.properties.length; i++) {
/* 107 */         Object value = this.properties[i].elGetValue(bean);
/* 108 */         if (value != null) {
/* 109 */           String str = (String)this.scalarTypes[i].luceneToIndexValue(value);
/* 110 */           sb.append(str);
/* 111 */           sb.append(" ");
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 116 */       String s = sb.toString();
/* 117 */       if (this.indexAnalyzer == null) {
/* 118 */         this.field.setValue(s);
/*     */       } else {
/*     */         
/* 121 */         StringReader sr = new StringReader(s);
/* 122 */         TokenStream tokenStream = this.indexAnalyzer.tokenStream(this.field.name(), sr);
/* 123 */         this.field.setTokenStream(tokenStream);
/*     */       } 
/* 125 */       document.add((Fieldable)this.field);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexFieldStringConcat.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */