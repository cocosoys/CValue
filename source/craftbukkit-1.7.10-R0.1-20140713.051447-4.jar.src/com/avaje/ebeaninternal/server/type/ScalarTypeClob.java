/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.text.json.JsonValueAdapter;
/*     */ import com.avaje.ebeaninternal.server.core.BasicTypeConverter;
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
/*     */ public class ScalarTypeClob
/*     */   extends ScalarTypeBaseVarchar<String>
/*     */ {
/*     */   static final int clobBufferSize = 512;
/*     */   static final int stringInitialSize = 512;
/*     */   
/*     */   protected ScalarTypeClob(boolean jdbcNative, int jdbcType) {
/*  39 */     super(String.class, jdbcNative, jdbcType);
/*     */   }
/*     */   
/*     */   public ScalarTypeClob() {
/*  43 */     super(String.class, true, 2005);
/*     */   }
/*     */ 
/*     */   
/*     */   public String convertFromDbString(String dbValue) {
/*  48 */     return dbValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public String convertToDbString(String beanValue) {
/*  53 */     return beanValue;
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, String value) throws SQLException {
/*  57 */     if (value == null) {
/*  58 */       b.setNull(12);
/*     */     } else {
/*  60 */       b.setString(value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String read(DataReader dataReader) throws SQLException {
/*  66 */     return dataReader.getStringClob();
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  70 */     return BasicTypeConverter.toString(value);
/*     */   }
/*     */   
/*     */   public String toBeanType(Object value) {
/*  74 */     return BasicTypeConverter.toString(value);
/*     */   }
/*     */ 
/*     */   
/*     */   public String formatValue(String t) {
/*  79 */     return t;
/*     */   }
/*     */   
/*     */   public String parse(String value) {
/*  83 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   public String jsonFromString(String value, JsonValueAdapter ctx) {
/*  88 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   public String jsonToString(String value, JsonValueAdapter ctx) {
/*  93 */     return EscapeJson.escapeQuote(value);
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  97 */     return 0;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/* 101 */     return value;
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 105 */     return value;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeClob.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */