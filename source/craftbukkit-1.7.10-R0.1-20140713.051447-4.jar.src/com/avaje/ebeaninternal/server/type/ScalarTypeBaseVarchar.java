/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.text.TextException;
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
/*     */ public abstract class ScalarTypeBaseVarchar<T>
/*     */   extends ScalarTypeBase<T>
/*     */ {
/*     */   public ScalarTypeBaseVarchar(Class<T> type) {
/*  38 */     super(type, false, 12);
/*     */   }
/*     */   
/*     */   public ScalarTypeBaseVarchar(Class<T> type, boolean jdbcNative, int jdbcType) {
/*  42 */     super(type, jdbcNative, jdbcType);
/*     */   }
/*     */   
/*     */   public abstract String formatValue(T paramT);
/*     */   
/*     */   public abstract T parse(String paramString);
/*     */   
/*     */   public abstract T convertFromDbString(String paramString);
/*     */   
/*     */   public abstract String convertToDbString(T paramT);
/*     */   
/*     */   public void bind(DataBind b, T value) throws SQLException {
/*  54 */     if (value == null) {
/*  55 */       b.setNull(12);
/*     */     } else {
/*     */       
/*  58 */       String s = convertToDbString(value);
/*  59 */       b.setString(s);
/*     */     } 
/*     */   }
/*     */   
/*     */   public T read(DataReader dataReader) throws SQLException {
/*  64 */     String s = dataReader.getString();
/*  65 */     if (s == null) {
/*  66 */       return null;
/*     */     }
/*  68 */     return convertFromDbString(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T toBeanType(Object value) {
/*  74 */     if (value == null) {
/*  75 */       return null;
/*     */     }
/*  77 */     if (value instanceof String) {
/*  78 */       return parse((String)value);
/*     */     }
/*  80 */     return (T)value;
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  84 */     if (value instanceof String) {
/*  85 */       return parse((String)value);
/*     */     }
/*  87 */     return value;
/*     */   }
/*     */   
/*     */   public T parseDateTime(long systemTimeMillis) {
/*  91 */     throw new TextException("Not Supported");
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String format(Object v) {
/* 100 */     return formatValue((T)v);
/*     */   }
/*     */   
/*     */   public T jsonFromString(String value, JsonValueAdapter ctx) {
/* 104 */     return parse(value);
/*     */   }
/*     */   
/*     */   public String toJsonString(Object value, JsonValueAdapter ctx) {
/* 108 */     String s = format(value);
/* 109 */     return EscapeJson.escapeQuote(s);
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/* 113 */     String v = (String)value;
/* 114 */     return convertFromDbString(v);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 119 */     return convertToDbString((T)value);
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/* 123 */     return 0;
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/* 127 */     if (!dataInput.readBoolean()) {
/* 128 */       return null;
/*     */     }
/* 130 */     String val = dataInput.readUTF();
/* 131 */     return convertFromDbString(val);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 138 */     T value = (T)v;
/* 139 */     if (value == null) {
/* 140 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 142 */       dataOutput.writeBoolean(true);
/* 143 */       String s = convertToDbString(value);
/* 144 */       dataOutput.writeUTF(s);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeBaseVarchar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */