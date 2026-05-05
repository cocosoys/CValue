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
/*     */ public class ScalarTypeLong
/*     */   extends ScalarTypeBase<Long>
/*     */ {
/*     */   public ScalarTypeLong() {
/*  37 */     super(Long.class, true, -5);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, Long value) throws SQLException {
/*  41 */     if (value == null) {
/*  42 */       b.setNull(-5);
/*     */     } else {
/*  44 */       b.setLong(value.longValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Long read(DataReader dataReader) throws SQLException {
/*  50 */     return dataReader.getLong();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  54 */     return BasicTypeConverter.toLong(value);
/*     */   }
/*     */   
/*     */   public Long toBeanType(Object value) {
/*  58 */     return BasicTypeConverter.toLong(value);
/*     */   }
/*     */   
/*     */   public String formatValue(Long t) {
/*  62 */     return t.toString();
/*     */   }
/*     */   
/*     */   public Long parse(String value) {
/*  66 */     return Long.valueOf(value);
/*     */   }
/*     */   
/*     */   public Long parseDateTime(long systemTimeMillis) {
/*  70 */     return Long.valueOf(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  74 */     return true;
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  78 */     return 2;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  82 */     return value;
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  86 */     return value;
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  90 */     if (!dataInput.readBoolean()) {
/*  91 */       return null;
/*     */     }
/*  93 */     long val = dataInput.readLong();
/*  94 */     return Long.valueOf(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 100 */     Long value = (Long)v;
/* 101 */     if (value == null) {
/* 102 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 104 */       dataOutput.writeBoolean(true);
/* 105 */       dataOutput.writeLong(value.longValue());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeLong.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */