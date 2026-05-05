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
/*     */ public class ScalarTypeByte
/*     */   extends ScalarTypeBase<Byte>
/*     */ {
/*     */   public ScalarTypeByte() {
/*  38 */     super(Byte.class, true, -6);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, Byte value) throws SQLException {
/*  42 */     if (value == null) {
/*  43 */       b.setNull(-6);
/*     */     } else {
/*  45 */       b.setByte(value.byteValue());
/*     */     } 
/*     */   }
/*     */   
/*     */   public Byte read(DataReader dataReader) throws SQLException {
/*  50 */     return dataReader.getByte();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  54 */     return BasicTypeConverter.toByte(value);
/*     */   }
/*     */   
/*     */   public Byte toBeanType(Object value) {
/*  58 */     return BasicTypeConverter.toByte(value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String formatValue(Byte t) {
/*  63 */     return t.toString();
/*     */   }
/*     */   
/*     */   public Byte parse(String value) {
/*  67 */     throw new TextException("Not supported");
/*     */   }
/*     */   
/*     */   public Byte parseDateTime(long systemTimeMillis) {
/*  71 */     throw new TextException("Not Supported");
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  79 */     return 7;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  83 */     byte[] ba = new byte[1];
/*  84 */     ba[0] = ((Byte)value).byteValue();
/*  85 */     return ba;
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  89 */     return Byte.valueOf(((byte[])value)[0]);
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  93 */     if (!dataInput.readBoolean()) {
/*  94 */       return null;
/*     */     }
/*  96 */     byte val = dataInput.readByte();
/*  97 */     return Byte.valueOf(val);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 103 */     Byte val = (Byte)v;
/* 104 */     if (val == null) {
/* 105 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 107 */       dataOutput.writeBoolean(true);
/* 108 */       dataOutput.writeByte(val.byteValue());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeByte.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */