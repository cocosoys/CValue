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
/*     */ public class ScalarTypeDouble
/*     */   extends ScalarTypeBase<Double>
/*     */ {
/*     */   public ScalarTypeDouble() {
/*  37 */     super(Double.class, true, 8);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, Double value) throws SQLException {
/*  41 */     if (value == null) {
/*  42 */       b.setNull(8);
/*     */     } else {
/*  44 */       b.setDouble(value.doubleValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Double read(DataReader dataReader) throws SQLException {
/*  50 */     return dataReader.getDouble();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  54 */     return BasicTypeConverter.toDouble(value);
/*     */   }
/*     */   
/*     */   public Double toBeanType(Object value) {
/*  58 */     return BasicTypeConverter.toDouble(value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String formatValue(Double t) {
/*  63 */     return t.toString();
/*     */   }
/*     */   
/*     */   public Double parse(String value) {
/*  67 */     return Double.valueOf(value);
/*     */   }
/*     */   
/*     */   public Double parseDateTime(long systemTimeMillis) {
/*  71 */     return Double.valueOf(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  75 */     return true;
/*     */   }
/*     */   
/*     */   public String toJsonString(Double value) {
/*  79 */     if (value.isInfinite() || value.isNaN()) {
/*  80 */       return "null";
/*     */     }
/*  82 */     return value.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLuceneType() {
/*  87 */     return 3;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  91 */     return value;
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  95 */     return value;
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  99 */     if (!dataInput.readBoolean()) {
/* 100 */       return null;
/*     */     }
/* 102 */     double val = dataInput.readDouble();
/* 103 */     return Double.valueOf(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 109 */     Double value = (Double)v;
/* 110 */     if (value == null) {
/* 111 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 113 */       dataOutput.writeBoolean(true);
/* 114 */       dataOutput.writeDouble(value.doubleValue());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeDouble.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */