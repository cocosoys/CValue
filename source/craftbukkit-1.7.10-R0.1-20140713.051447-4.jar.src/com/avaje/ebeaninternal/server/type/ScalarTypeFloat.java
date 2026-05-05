/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.core.BasicTypeConverter;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ import java.sql.SQLException;
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
/*     */ public class ScalarTypeFloat
/*     */   extends ScalarTypeBase<Float>
/*     */ {
/*     */   public ScalarTypeFloat() {
/*  37 */     super(Float.class, true, 7);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, Float value) throws SQLException {
/*  41 */     if (value == null) {
/*  42 */       b.setNull(7);
/*     */     } else {
/*  44 */       b.setFloat(value.floatValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Float read(DataReader dataReader) throws SQLException {
/*  50 */     return dataReader.getFloat();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  54 */     return BasicTypeConverter.toFloat(value);
/*     */   }
/*     */   
/*     */   public Float toBeanType(Object value) {
/*  58 */     return BasicTypeConverter.toFloat(value);
/*     */   }
/*     */   
/*     */   public String formatValue(Float t) {
/*  62 */     return t.toString();
/*     */   }
/*     */   
/*     */   public Float parse(String value) {
/*  66 */     return Float.valueOf(value);
/*     */   }
/*     */   
/*     */   public Float parseDateTime(long systemTimeMillis) {
/*  70 */     return Float.valueOf((float)systemTimeMillis);
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  74 */     return true;
/*     */   }
/*     */   
/*     */   public String toJsonString(Float value) {
/*  78 */     if (value.isInfinite() || value.isNaN()) {
/*  79 */       return "null";
/*     */     }
/*  81 */     return value.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLuceneType() {
/*  86 */     return 4;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  90 */     return value;
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  94 */     return value;
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  98 */     if (!dataInput.readBoolean()) {
/*  99 */       return null;
/*     */     }
/* 101 */     float val = dataInput.readFloat();
/* 102 */     return Float.valueOf(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 108 */     Float value = (Float)v;
/* 109 */     if (value == null) {
/* 110 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 112 */       dataOutput.writeBoolean(true);
/* 113 */       dataOutput.writeFloat(value.floatValue());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeFloat.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */