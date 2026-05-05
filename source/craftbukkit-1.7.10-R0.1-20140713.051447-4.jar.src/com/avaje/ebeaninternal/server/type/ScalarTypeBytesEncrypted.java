/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.text.json.JsonValueAdapter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScalarTypeBytesEncrypted
/*     */   implements ScalarType<byte[]>
/*     */ {
/*     */   private final ScalarTypeBytesBase baseType;
/*     */   private final DataEncryptSupport dataEncryptSupport;
/*     */   
/*     */   public ScalarTypeBytesEncrypted(ScalarTypeBytesBase baseType, DataEncryptSupport dataEncryptSupport) {
/*  43 */     this.baseType = baseType;
/*  44 */     this.dataEncryptSupport = dataEncryptSupport;
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, byte[] value) throws SQLException {
/*  48 */     value = this.dataEncryptSupport.encrypt(value);
/*  49 */     this.baseType.bind(b, value);
/*     */   }
/*     */   
/*     */   public int getJdbcType() {
/*  53 */     return this.baseType.getJdbcType();
/*     */   }
/*     */   
/*     */   public int getLength() {
/*  57 */     return this.baseType.getLength();
/*     */   }
/*     */   
/*     */   public Class<byte[]> getType() {
/*  61 */     return byte[].class;
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  65 */     return this.baseType.isDateTimeCapable();
/*     */   }
/*     */   
/*     */   public boolean isJdbcNative() {
/*  69 */     return this.baseType.isJdbcNative();
/*     */   }
/*     */   
/*     */   public void loadIgnore(DataReader dataReader) {
/*  73 */     this.baseType.loadIgnore(dataReader);
/*     */   }
/*     */   
/*     */   public String format(Object v) {
/*  77 */     throw new RuntimeException("Not used");
/*     */   }
/*     */   
/*     */   public String formatValue(byte[] v) {
/*  81 */     throw new RuntimeException("Not used");
/*     */   }
/*     */   
/*     */   public byte[] parse(String value) {
/*  85 */     return this.baseType.parse(value);
/*     */   }
/*     */   
/*     */   public byte[] parseDateTime(long systemTimeMillis) {
/*  89 */     return this.baseType.parseDateTime(systemTimeMillis);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] read(DataReader dataReader) throws SQLException {
/*  94 */     byte[] data = this.baseType.read(dataReader);
/*  95 */     data = this.dataEncryptSupport.decrypt(data);
/*  96 */     return data;
/*     */   }
/*     */   
/*     */   public byte[] toBeanType(Object value) {
/* 100 */     return this.baseType.toBeanType(value);
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/* 104 */     return this.baseType.toJdbcType(value);
/*     */   }
/*     */   
/*     */   public void accumulateScalarTypes(String propName, CtCompoundTypeScalarList list) {
/* 108 */     this.baseType.accumulateScalarTypes(propName, list);
/*     */   }
/*     */   
/*     */   public String jsonToString(byte[] value, JsonValueAdapter ctx) {
/* 112 */     return this.baseType.jsonToString(value, ctx);
/*     */   }
/*     */   
/*     */   public byte[] jsonFromString(String value, JsonValueAdapter ctx) {
/* 116 */     return this.baseType.jsonFromString(value, ctx);
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/* 120 */     int len = dataInput.readInt();
/* 121 */     byte[] value = new byte[len];
/* 122 */     dataInput.readFully(value);
/* 123 */     return value;
/*     */   }
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 127 */     byte[] value = (byte[])v;
/* 128 */     dataOutput.writeInt(value.length);
/* 129 */     dataOutput.write(value);
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/* 133 */     return this.baseType.getLuceneType();
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/* 137 */     return this.baseType.luceneFromIndexValue(value);
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 141 */     return this.baseType.luceneToIndexValue(value);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeBytesEncrypted.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */