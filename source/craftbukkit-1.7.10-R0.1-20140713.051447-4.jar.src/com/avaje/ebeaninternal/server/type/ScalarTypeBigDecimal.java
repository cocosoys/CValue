/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.core.BasicTypeConverter;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ import java.math.BigDecimal;
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
/*     */ public class ScalarTypeBigDecimal
/*     */   extends ScalarTypeBase<BigDecimal>
/*     */ {
/*     */   public ScalarTypeBigDecimal() {
/*  38 */     super(BigDecimal.class, true, 3);
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  42 */     if (!dataInput.readBoolean()) {
/*  43 */       return null;
/*     */     }
/*  45 */     double val = dataInput.readDouble();
/*  46 */     return new BigDecimal(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/*  52 */     BigDecimal b = (BigDecimal)v;
/*  53 */     if (b == null) {
/*  54 */       dataOutput.writeBoolean(false);
/*     */     } else {
/*  56 */       dataOutput.writeBoolean(true);
/*  57 */       dataOutput.writeDouble(b.doubleValue());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, BigDecimal value) throws SQLException {
/*  62 */     if (value == null) {
/*  63 */       b.setNull(3);
/*     */     } else {
/*  65 */       b.setBigDecimal(value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal read(DataReader dataReader) throws SQLException {
/*  71 */     return dataReader.getBigDecimal();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  75 */     return BasicTypeConverter.toBigDecimal(value);
/*     */   }
/*     */   
/*     */   public BigDecimal toBeanType(Object value) {
/*  79 */     return BasicTypeConverter.toBigDecimal(value);
/*     */   }
/*     */   
/*     */   public String formatValue(BigDecimal t) {
/*  83 */     return t.toPlainString();
/*     */   }
/*     */   
/*     */   public BigDecimal parse(String value) {
/*  87 */     return new BigDecimal(value);
/*     */   }
/*     */   
/*     */   public BigDecimal parseDateTime(long systemTimeMillis) {
/*  91 */     return BigDecimal.valueOf(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  99 */     Double v = (Double)value;
/* 100 */     return new BigDecimal(v.doubleValue());
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 104 */     BigDecimal v = (BigDecimal)value;
/* 105 */     return Double.valueOf(v.doubleValue());
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/* 109 */     return 3;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeBigDecimal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */