/*    */ package com.avaje.ebeaninternal.server.lucene;
/*    */ 
/*    */ import org.apache.lucene.document.Field;
/*    */ import org.apache.lucene.document.Fieldable;
/*    */ import org.apache.lucene.document.NumericField;
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
/*    */ public class FieldFactory
/*    */ {
/*    */   private final boolean numericField;
/*    */   private final String fieldName;
/*    */   private final Field.Store store;
/*    */   private final Field.Index index;
/*    */   private final float boost;
/*    */   private final int precisionStep;
/*    */   
/*    */   public static FieldFactory numeric(String fieldName, Field.Store store, Field.Index index, float boost, int precisionStep) {
/* 41 */     return new FieldFactory(true, fieldName, store, index, boost, precisionStep);
/*    */   }
/*    */   
/*    */   public static FieldFactory normal(String fieldName, Field.Store store, Field.Index index, float boost) {
/* 45 */     return new FieldFactory(false, fieldName, store, index, boost, 0);
/*    */   }
/*    */   
/*    */   private FieldFactory(boolean numericField, String fieldName, Field.Store store, Field.Index index, float boost, int precisionStep) {
/* 49 */     this.numericField = numericField;
/* 50 */     this.fieldName = fieldName;
/* 51 */     this.store = store;
/* 52 */     this.index = index;
/* 53 */     this.boost = boost;
/* 54 */     this.precisionStep = precisionStep;
/*    */   }
/*    */   
/*    */   public Fieldable createFieldable() {
/* 58 */     return this.numericField ? createNumericField() : createNormalField();
/*    */   }
/*    */   
/*    */   private Fieldable createNormalField() {
/* 62 */     Field f = new Field(this.fieldName, "", this.store, this.index);
/* 63 */     if (this.boost > 0.0F) {
/* 64 */       f.setBoost(this.boost);
/*    */     }
/* 66 */     return (Fieldable)f;
/*    */   }
/*    */   
/*    */   private Fieldable createNumericField() {
/* 70 */     boolean indexed = this.index.isIndexed();
/* 71 */     NumericField f = new NumericField(this.fieldName, this.precisionStep, this.store, indexed);
/* 72 */     if (this.boost > 0.0F) {
/* 73 */       f.setBoost(this.boost);
/*    */     }
/* 75 */     return (Fieldable)f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\FieldFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */