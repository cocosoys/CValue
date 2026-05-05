/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.core.BasicTypeConverter;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
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
/*     */ public class ScalarTypeTime
/*     */   extends ScalarTypeBase<Time>
/*     */ {
/*     */   public ScalarTypeTime() {
/*  38 */     super(Time.class, true, 92);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, Time value) throws SQLException {
/*  42 */     if (value == null) {
/*  43 */       b.setNull(92);
/*     */     } else {
/*  45 */       b.setTime(value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Time read(DataReader dataReader) throws SQLException {
/*  51 */     return dataReader.getTime();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  55 */     return BasicTypeConverter.toTime(value);
/*     */   }
/*     */   
/*     */   public Time toBeanType(Object value) {
/*  59 */     return BasicTypeConverter.toTime(value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String formatValue(Time v) {
/*  64 */     return v.toString();
/*     */   }
/*     */   
/*     */   public Time parse(String value) {
/*  68 */     return Time.valueOf(value);
/*     */   }
/*     */   
/*     */   public Time parseDateTime(long systemTimeMillis) {
/*  72 */     return new Time(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  76 */     return true;
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  80 */     return 0;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  84 */     return parse((String)value);
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  88 */     return format(value);
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  92 */     if (!dataInput.readBoolean()) {
/*  93 */       return null;
/*     */     }
/*  95 */     String val = dataInput.readUTF();
/*  96 */     return parse(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 102 */     Time value = (Time)v;
/* 103 */     if (value == null) {
/* 104 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 106 */       dataOutput.writeBoolean(true);
/* 107 */       dataOutput.writeUTF(format(value));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeTime.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */