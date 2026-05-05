/*    */ package com.avaje.ebeaninternal.server.type;
/*    */ 
/*    */ import com.avaje.ebean.text.json.JsonValueAdapter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ScalarTypeBase<T>
/*    */   implements ScalarType<T>
/*    */ {
/*    */   protected final Class<T> type;
/*    */   protected final boolean jdbcNative;
/*    */   protected final int jdbcType;
/*    */   
/*    */   public ScalarTypeBase(Class<T> type, boolean jdbcNative, int jdbcType) {
/* 36 */     this.type = type;
/* 37 */     this.jdbcNative = jdbcNative;
/* 38 */     this.jdbcType = jdbcType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLength() {
/* 45 */     return 0;
/*    */   }
/*    */   
/*    */   public boolean isJdbcNative() {
/* 49 */     return this.jdbcNative;
/*    */   }
/*    */   
/*    */   public int getJdbcType() {
/* 53 */     return this.jdbcType;
/*    */   }
/*    */   
/*    */   public Class<T> getType() {
/* 57 */     return this.type;
/*    */   }
/*    */ 
/*    */   
/*    */   public String format(Object v) {
/* 62 */     return formatValue((T)v);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDbNull(Object value) {
/* 69 */     return (value == null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getDbNullValue(Object value) {
/* 76 */     return value;
/*    */   }
/*    */   
/*    */   public void loadIgnore(DataReader dataReader) {
/* 80 */     dataReader.incrementPos(1);
/*    */   }
/*    */   
/*    */   public void accumulateScalarTypes(String propName, CtCompoundTypeScalarList list) {
/* 84 */     list.addScalarType(propName, this);
/*    */   }
/*    */   
/*    */   public String jsonToString(T value, JsonValueAdapter ctx) {
/* 88 */     return formatValue(value);
/*    */   }
/*    */   
/*    */   public T jsonFromString(String value, JsonValueAdapter ctx) {
/* 92 */     return parse(value);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeBase.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */