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
/*     */ public class ScalarTypeEncryptedWrapper<T>
/*     */   implements ScalarType<T>
/*     */ {
/*     */   private final ScalarType<T> wrapped;
/*     */   private final DataEncryptSupport dataEncryptSupport;
/*     */   private final ScalarTypeBytesBase byteArrayType;
/*     */   
/*     */   public ScalarTypeEncryptedWrapper(ScalarType<T> wrapped, ScalarTypeBytesBase byteArrayType, DataEncryptSupport dataEncryptSupport) {
/*  38 */     this.wrapped = wrapped;
/*  39 */     this.byteArrayType = byteArrayType;
/*  40 */     this.dataEncryptSupport = dataEncryptSupport;
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  44 */     return this.wrapped.readData(dataInput);
/*     */   }
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/*  48 */     this.wrapped.writeData(dataOutput, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public T read(DataReader dataReader) throws SQLException {
/*  53 */     byte[] data = dataReader.getBytes();
/*  54 */     String formattedValue = this.dataEncryptSupport.decryptObject(data);
/*  55 */     if (formattedValue == null) {
/*  56 */       return null;
/*     */     }
/*  58 */     return this.wrapped.parse(formattedValue);
/*     */   }
/*     */   
/*     */   private byte[] encrypt(T value) {
/*  62 */     String formatValue = this.wrapped.formatValue(value);
/*  63 */     return this.dataEncryptSupport.encryptObject(formatValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(DataBind b, T value) throws SQLException {
/*  68 */     byte[] encryptedValue = encrypt(value);
/*  69 */     this.byteArrayType.bind(b, encryptedValue);
/*     */   }
/*     */   
/*     */   public int getJdbcType() {
/*  73 */     return this.byteArrayType.getJdbcType();
/*     */   }
/*     */   
/*     */   public int getLength() {
/*  77 */     return this.byteArrayType.getLength();
/*     */   }
/*     */   
/*     */   public Class<T> getType() {
/*  81 */     return this.wrapped.getType();
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  85 */     return this.wrapped.isDateTimeCapable();
/*     */   }
/*     */   
/*     */   public boolean isJdbcNative() {
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public void loadIgnore(DataReader dataReader) {
/*  93 */     this.wrapped.loadIgnore(dataReader);
/*     */   }
/*     */ 
/*     */   
/*     */   public String format(Object v) {
/*  98 */     return formatValue((T)v);
/*     */   }
/*     */   
/*     */   public String formatValue(T v) {
/* 102 */     return this.wrapped.formatValue(v);
/*     */   }
/*     */   
/*     */   public T parse(String value) {
/* 106 */     return this.wrapped.parse(value);
/*     */   }
/*     */   
/*     */   public T parseDateTime(long systemTimeMillis) {
/* 110 */     return this.wrapped.parseDateTime(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public T toBeanType(Object value) {
/* 114 */     return this.wrapped.toBeanType(value);
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/* 118 */     return this.wrapped.toJdbcType(value);
/*     */   }
/*     */   
/*     */   public void accumulateScalarTypes(String propName, CtCompoundTypeScalarList list) {
/* 122 */     this.wrapped.accumulateScalarTypes(propName, list);
/*     */   }
/*     */   
/*     */   public String jsonToString(T value, JsonValueAdapter ctx) {
/* 126 */     return this.wrapped.jsonToString(value, ctx);
/*     */   }
/*     */   
/*     */   public T jsonFromString(String value, JsonValueAdapter ctx) {
/* 130 */     return this.wrapped.jsonFromString(value, ctx);
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/* 134 */     return this.wrapped.getLuceneType();
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/* 138 */     return this.wrapped.luceneFromIndexValue(value);
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 142 */     return this.wrapped.luceneToIndexValue(value);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeEncryptedWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */