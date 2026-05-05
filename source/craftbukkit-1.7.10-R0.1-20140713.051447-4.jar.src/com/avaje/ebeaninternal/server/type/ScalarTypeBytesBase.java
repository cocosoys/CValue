/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.text.TextException;
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
/*     */ public abstract class ScalarTypeBytesBase
/*     */   extends ScalarTypeBase<byte[]>
/*     */ {
/*     */   protected ScalarTypeBytesBase(boolean jdbcNative, int jdbcType) {
/*  36 */     super((Class)byte[].class, jdbcNative, jdbcType);
/*     */   }
/*     */   
/*     */   public Object convertFromBytes(byte[] bytes) {
/*  40 */     return bytes;
/*     */   }
/*     */   
/*     */   public byte[] convertToBytes(Object value) {
/*  44 */     return (byte[])value;
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, byte[] value) throws SQLException {
/*  48 */     if (value == null) {
/*  49 */       b.setNull(this.jdbcType);
/*     */     } else {
/*  51 */       b.setBytes(value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  56 */     return value;
/*     */   }
/*     */   
/*     */   public byte[] toBeanType(Object value) {
/*  60 */     return (byte[])value;
/*     */   }
/*     */ 
/*     */   
/*     */   public String formatValue(byte[] t) {
/*  65 */     throw new TextException("Not supported");
/*     */   }
/*     */   
/*     */   public byte[] parse(String value) {
/*  69 */     throw new TextException("Not supported");
/*     */   }
/*     */   
/*     */   public byte[] parseDateTime(long systemTimeMillis) {
/*  73 */     throw new TextException("Not supported");
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  81 */     return 7;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  85 */     return value;
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  89 */     return value;
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  93 */     if (!dataInput.readBoolean()) {
/*  94 */       return null;
/*     */     }
/*  96 */     int len = dataInput.readInt();
/*  97 */     byte[] buf = new byte[len];
/*  98 */     dataInput.readFully(buf, 0, buf.length);
/*  99 */     return buf;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 104 */     if (v == null) {
/* 105 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 107 */       byte[] bytes = convertToBytes(v);
/* 108 */       dataOutput.writeInt(bytes.length);
/* 109 */       dataOutput.write(bytes);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeBytesBase.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */