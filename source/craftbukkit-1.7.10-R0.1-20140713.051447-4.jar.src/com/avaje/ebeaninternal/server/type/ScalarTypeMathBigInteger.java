/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.core.BasicTypeConverter;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ import java.math.BigInteger;
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
/*     */ public class ScalarTypeMathBigInteger
/*     */   extends ScalarTypeBase<BigInteger>
/*     */ {
/*     */   public ScalarTypeMathBigInteger() {
/*  38 */     super(BigInteger.class, false, -5);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, BigInteger value) throws SQLException {
/*  42 */     if (value == null) {
/*  43 */       b.setNull(-5);
/*     */     } else {
/*  45 */       b.setLong(value.longValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BigInteger read(DataReader dataReader) throws SQLException {
/*  51 */     Long l = dataReader.getLong();
/*  52 */     if (l == null) {
/*  53 */       return null;
/*     */     }
/*  55 */     return new BigInteger(String.valueOf(l));
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  59 */     return BasicTypeConverter.toLong(value);
/*     */   }
/*     */   
/*     */   public BigInteger toBeanType(Object value) {
/*  63 */     return BasicTypeConverter.toMathBigInteger(value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String formatValue(BigInteger v) {
/*  68 */     return v.toString();
/*     */   }
/*     */   
/*     */   public BigInteger parse(String value) {
/*  72 */     return new BigInteger(value);
/*     */   }
/*     */   
/*     */   public BigInteger parseDateTime(long systemTimeMillis) {
/*  76 */     return BigInteger.valueOf(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  84 */     return 2;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  88 */     return BigInteger.valueOf(((Long)value).longValue());
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  92 */     return Long.valueOf(((BigInteger)value).longValue());
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  96 */     if (!dataInput.readBoolean()) {
/*  97 */       return null;
/*     */     }
/*  99 */     long val = dataInput.readLong();
/* 100 */     return Long.valueOf(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 106 */     Long value = (Long)v;
/* 107 */     if (value == null) {
/* 108 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 110 */       dataOutput.writeBoolean(true);
/* 111 */       dataOutput.writeLong(value.longValue());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeMathBigInteger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */