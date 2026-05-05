/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.text.TextException;
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
/*     */ public class ScalarTypeInteger
/*     */   extends ScalarTypeBase<Integer>
/*     */ {
/*     */   public ScalarTypeInteger() {
/*  39 */     super(Integer.class, true, 4);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, Integer value) throws SQLException {
/*  43 */     if (value == null) {
/*  44 */       b.setNull(4);
/*     */     } else {
/*  46 */       b.setInt(value.intValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer read(DataReader dataReader) throws SQLException {
/*  52 */     return dataReader.getInt();
/*     */   }
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  56 */     return Integer.valueOf(dataInput.readInt());
/*     */   }
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/*  60 */     dataOutput.writeInt(((Integer)v).intValue());
/*     */   }
/*     */   
/*     */   public Object toJdbcType(Object value) {
/*  64 */     return BasicTypeConverter.toInteger(value);
/*     */   }
/*     */   
/*     */   public Integer toBeanType(Object value) {
/*  68 */     return BasicTypeConverter.toInteger(value);
/*     */   }
/*     */   
/*     */   public String formatValue(Integer v) {
/*  72 */     return v.toString();
/*     */   }
/*     */   
/*     */   public Integer parse(String value) {
/*  76 */     return Integer.valueOf(value);
/*     */   }
/*     */   
/*     */   public Integer parseDateTime(long systemTimeMillis) {
/*  80 */     throw new TextException("Not Supported");
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public String jsonToString(Integer value, JsonValueAdapter ctx) {
/*  88 */     return value.toString();
/*     */   }
/*     */   
/*     */   public Integer jsonFromString(String value, JsonValueAdapter ctx) {
/*  92 */     return Integer.valueOf(value);
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/*  96 */     return 1;
/*     */   }
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/* 100 */     return value;
/*     */   }
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 104 */     return value;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeInteger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */