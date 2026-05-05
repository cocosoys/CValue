/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.text.json.JsonValueAdapter;
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
/*     */ public class ScalarTypeString
/*     */   extends ScalarTypeBase<String>
/*     */ {
/*     */   public ScalarTypeString() {
/*  38 */     super(String.class, true, 12);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, String value) throws SQLException {
/*  42 */     if (value == null) {
/*  43 */       b.setNull(12);
/*     */     } else {
/*  45 */       b.setString(value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String read(DataReader dataReader) throws SQLException {
/*  51 */     return dataReader.getString();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  55 */     return BasicTypeConverter.toString(value);
/*     */   }
/*     */   
/*     */   public String toBeanType(Object value) {
/*  59 */     return BasicTypeConverter.toString(value);
/*     */   }
/*     */   
/*     */   public String formatValue(String t) {
/*  63 */     return t;
/*     */   }
/*     */   
/*     */   public String parse(String value) {
/*  67 */     return value;
/*     */   }
/*     */   
/*     */   public String parseDateTime(long systemTimeMillis) {
/*  71 */     return String.valueOf(systemTimeMillis);
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  75 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String jsonFromString(String value, JsonValueAdapter ctx) {
/*  80 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   public String jsonToString(String value, JsonValueAdapter ctx) {
/*  85 */     return EscapeJson.escapeQuote(value);
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  89 */     return 0;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/*  93 */     return value;
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/*  97 */     return value;
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/* 101 */     if (!dataInput.readBoolean()) {
/* 102 */       return null;
/*     */     }
/* 104 */     return dataInput.readUTF();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 110 */     String value = (String)v;
/* 111 */     if (value == null) {
/* 112 */       dataOutput.writeBoolean(false);
/*     */     } else {
/* 114 */       dataOutput.writeBoolean(true);
/* 115 */       dataOutput.writeUTF(value);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeString.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */