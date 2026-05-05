/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.text.json.JsonValueAdapter;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ import java.sql.Date;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.persistence.PersistenceException;
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
/*     */ public class ScalarTypeLdapDate<T>
/*     */   implements ScalarType<T>
/*     */ {
/*     */   private static final String timestampLDAPFormat = "yyyyMMddHHmmss'Z'";
/*     */   private final ScalarType<T> baseType;
/*     */   
/*     */   public ScalarTypeLdapDate(ScalarType<T> baseType) {
/*  46 */     this.baseType = baseType;
/*     */   }
/*     */   
/*     */   public T toBeanType(Object value) {
/*  50 */     if (value == null) {
/*  51 */       return null;
/*     */     }
/*  53 */     if (!(value instanceof String)) {
/*  54 */       String msg = "Expecting a String type but got " + value.getClass() + " value[" + value + "]";
/*  55 */       throw new PersistenceException(msg);
/*     */     } 
/*     */     try {
/*  58 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
/*  59 */       Date date = sdf.parse((String)value);
/*     */       
/*  61 */       return this.baseType.parseDateTime(date.getTime());
/*     */     }
/*  63 */     catch (Exception e) {
/*  64 */       String msg = "Error parsing LDAP timestamp " + value;
/*  65 */       throw new PersistenceException(msg, e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  71 */     if (value == null) {
/*  72 */       return null;
/*     */     }
/*     */     
/*  75 */     Object ts = this.baseType.toJdbcType(value);
/*  76 */     if (!(ts instanceof Date)) {
/*  77 */       String msg = "Expecting a java.sql.Date type but got " + value.getClass() + " value[" + value + "]";
/*  78 */       throw new PersistenceException(msg);
/*     */     } 
/*     */     
/*  81 */     Date t = (Date)ts;
/*  82 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
/*  83 */     return sdf.format(t);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(DataBind b, T value) throws SQLException {
/*  88 */     this.baseType.bind(b, value);
/*     */   }
/*     */   
/*     */   public int getJdbcType() {
/*  92 */     return 12;
/*     */   }
/*     */   
/*     */   public int getLength() {
/*  96 */     return this.baseType.getLength();
/*     */   }
/*     */   
/*     */   public Class<T> getType() {
/* 100 */     return this.baseType.getType();
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/* 104 */     return this.baseType.isDateTimeCapable();
/*     */   }
/*     */   
/*     */   public boolean isJdbcNative() {
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public void loadIgnore(DataReader dataReader) {
/* 112 */     this.baseType.loadIgnore(dataReader);
/*     */   }
/*     */   
/*     */   public String format(Object v) {
/* 116 */     return this.baseType.format(v);
/*     */   }
/*     */   
/*     */   public String formatValue(T t) {
/* 120 */     return this.baseType.formatValue(t);
/*     */   }
/*     */   
/*     */   public T parse(String value) {
/* 124 */     return this.baseType.parse(value);
/*     */   }
/*     */   
/*     */   public T parseDateTime(long systemTimeMillis) {
/* 128 */     return this.baseType.parseDateTime(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public T read(DataReader dataReader) throws SQLException {
/* 132 */     return this.baseType.read(dataReader);
/*     */   }
/*     */   
/*     */   public void accumulateScalarTypes(String propName, CtCompoundTypeScalarList list) {
/* 136 */     this.baseType.accumulateScalarTypes(propName, list);
/*     */   }
/*     */   
/*     */   public String jsonToString(T value, JsonValueAdapter ctx) {
/* 140 */     return this.baseType.jsonToString(value, ctx);
/*     */   }
/*     */   
/*     */   public T jsonFromString(String value, JsonValueAdapter ctx) {
/* 144 */     return this.baseType.jsonFromString(value, ctx);
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/* 148 */     return this.baseType.readData(dataInput);
/*     */   }
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 152 */     this.baseType.writeData(dataOutput, v);
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/* 156 */     return this.baseType.getLuceneType();
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/* 160 */     return this.baseType.luceneFromIndexValue(value);
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 164 */     return this.baseType.luceneToIndexValue(value);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeLdapDate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */