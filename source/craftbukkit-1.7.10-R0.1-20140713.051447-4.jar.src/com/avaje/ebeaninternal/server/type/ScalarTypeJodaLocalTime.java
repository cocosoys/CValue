/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.core.BasicTypeConverter;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
/*     */ import org.joda.time.DateTimeZone;
/*     */ import org.joda.time.LocalTime;
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
/*     */ 
/*     */ public class ScalarTypeJodaLocalTime
/*     */   extends ScalarTypeBase<LocalTime>
/*     */ {
/*     */   public ScalarTypeJodaLocalTime() {
/*  41 */     super(LocalTime.class, false, 92);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, LocalTime value) throws SQLException {
/*  45 */     if (value == null) {
/*  46 */       b.setNull(92);
/*     */     } else {
/*  48 */       Time sqlTime = new Time(value.getMillisOfDay());
/*  49 */       b.setTime(sqlTime);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public LocalTime read(DataReader dataReader) throws SQLException {
/*  55 */     Time sqlTime = dataReader.getTime();
/*  56 */     if (sqlTime == null) {
/*  57 */       return null;
/*     */     }
/*  59 */     return new LocalTime(sqlTime, DateTimeZone.UTC);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  64 */     if (value instanceof LocalTime) {
/*  65 */       return new Time(((LocalTime)value).getMillisOfDay());
/*     */     }
/*  67 */     return BasicTypeConverter.toTime(value);
/*     */   }
/*     */   
/*     */   public LocalTime toBeanType(Object value) {
/*  71 */     if (value instanceof java.util.Date) {
/*  72 */       return new LocalTime(value, DateTimeZone.UTC);
/*     */     }
/*  74 */     return (LocalTime)value;
/*     */   }
/*     */   
/*     */   public String formatValue(LocalTime v) {
/*  78 */     return v.toString();
/*     */   }
/*     */   
/*     */   public LocalTime parse(String value) {
/*  82 */     return new LocalTime(value);
/*     */   }
/*     */   
/*     */   public LocalTime parseDateTime(long systemTimeMillis) {
/*  86 */     return new LocalTime(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  94 */     return 0;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  98 */     return parse((String)value);
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 102 */     return format(value);
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/* 106 */     if (!dataInput.readBoolean()) {
/* 107 */       return null;
/*     */     }
/* 109 */     String val = dataInput.readUTF();
/* 110 */     return parse(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 116 */     Time value = (Time)v;
/* 117 */     if (value == null) {
/* 118 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 120 */       dataOutput.writeBoolean(true);
/* 121 */       dataOutput.writeUTF(format(value));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeJodaLocalTime.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */