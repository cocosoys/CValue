/*     */ package com.avaje.ebeaninternal.server.lucene;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.el.ElPropertyValue;
/*     */ import com.avaje.ebeaninternal.server.type.ScalarType;
/*     */ import java.util.Set;
/*     */ import org.apache.lucene.analysis.Analyzer;
/*     */ import org.apache.lucene.document.Document;
/*     */ import org.apache.lucene.document.Fieldable;
/*     */ import org.apache.lucene.document.NumericField;
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
/*     */ public final class LIndexFieldNumeric
/*     */   extends LIndexFieldBase
/*     */ {
/*     */   public LIndexFieldNumeric(Analyzer queryAnalyzer, String fieldName, FieldFactory fieldFactory, int luceneType, ElPropertyValue property) {
/*  34 */     super(queryAnalyzer, fieldName, luceneType, property, fieldFactory);
/*     */   }
/*     */   
/*     */   public void addIndexResolvePropertyNames(Set<String> resolvePropertyNames) {
/*  38 */     if (this.propertyName != null && isIndexed()) {
/*  39 */       resolvePropertyNames.add(this.propertyName);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addIndexRestorePropertyNames(Set<String> restorePropertyNames) {
/*  44 */     if (this.propertyName != null && isStored()) {
/*  45 */       restorePropertyNames.add(this.propertyName);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSortableProperty() {
/*  50 */     return isIndexed() ? this.propertyName : null;
/*     */   }
/*     */   
/*     */   public DocFieldWriter createDocFieldWriter() {
/*  54 */     NumericField f = (NumericField)this.fieldFactory.createFieldable();
/*  55 */     return new Writer(this.luceneType, this.property, this.scalarType, f);
/*     */   }
/*     */   
/*     */   private static class Writer
/*     */     implements DocFieldWriter {
/*     */     private final int luceneType;
/*     */     private final ElPropertyValue property;
/*     */     private final ScalarType<?> scalarType;
/*     */     private final NumericField field;
/*     */     
/*     */     Writer(int luceneType, ElPropertyValue property, ScalarType<?> scalarType, NumericField field) {
/*  66 */       this.luceneType = luceneType;
/*  67 */       this.property = property;
/*  68 */       this.scalarType = scalarType;
/*  69 */       this.field = field;
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeValue(Object bean, Document document) {
/*  74 */       Object value = this.property.elGetValue(bean);
/*  75 */       if (value != null) {
/*     */ 
/*     */ 
/*     */         
/*  79 */         System.out.println("- write " + this.field.name() + " " + value);
/*     */         
/*  81 */         value = this.scalarType.luceneToIndexValue(value);
/*  82 */         setValueToField(value);
/*  83 */         document.add((Fieldable)this.field);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void setValueToField(Object value) {
/*  89 */       switch (this.luceneType) {
/*     */         case 1:
/*  91 */           this.field.setIntValue(((Integer)value).intValue());
/*     */           return;
/*     */         
/*     */         case 2:
/*  95 */           this.field.setLongValue(((Long)value).longValue());
/*     */           return;
/*     */         
/*     */         case 5:
/*  99 */           this.field.setLongValue(((Long)value).longValue());
/*     */           return;
/*     */         
/*     */         case 6:
/* 103 */           this.field.setLongValue(((Long)value).longValue());
/*     */           return;
/*     */         
/*     */         case 3:
/* 107 */           this.field.setDoubleValue(((Double)value).doubleValue());
/*     */           return;
/*     */         
/*     */         case 4:
/* 111 */           this.field.setFloatValue(((Float)value).floatValue());
/*     */           return;
/*     */       } 
/*     */       
/* 115 */       throw new RuntimeException("Unhandled type " + this.luceneType);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexFieldNumeric.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */