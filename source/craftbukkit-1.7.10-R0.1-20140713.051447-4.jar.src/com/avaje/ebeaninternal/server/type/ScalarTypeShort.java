/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.text.TextException;
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
/*     */ public class ScalarTypeShort
/*     */   extends ScalarTypeBase<Short>
/*     */ {
/*     */   public ScalarTypeShort() {
/*  38 */     super(Short.class, true, 5);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, Short value) throws SQLException {
/*  42 */     if (value == null) {
/*  43 */       b.setNull(5);
/*     */     } else {
/*  45 */       b.setShort(value.shortValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Short read(DataReader dataReader) throws SQLException {
/*  51 */     return dataReader.getShort();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  55 */     return BasicTypeConverter.toShort(value);
/*     */   }
/*     */   
/*     */   public Short toBeanType(Object value) {
/*  59 */     return BasicTypeConverter.toShort(value);
/*     */   }
/*     */   
/*     */   public String formatValue(Short v) {
/*  63 */     return v.toString();
/*     */   }
/*     */   
/*     */   public Short parse(String value) {
/*  67 */     return Short.valueOf(value);
/*     */   }
/*     */   
/*     */   public Short parseDateTime(long systemTimeMillis) {
/*  71 */     throw new TextException("Not Supported");
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  79 */     return 1;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  83 */     return Short.valueOf(value.toString());
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  87 */     return Integer.valueOf(((Short)value).intValue());
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  91 */     if (!dataInput.readBoolean()) {
/*  92 */       return null;
/*     */     }
/*  94 */     short val = dataInput.readShort();
/*  95 */     return Short.valueOf(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 101 */     Short value = (Short)v;
/* 102 */     if (value == null) {
/* 103 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 105 */       dataOutput.writeBoolean(true);
/* 106 */       dataOutput.writeShort(value.shortValue());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeShort.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */