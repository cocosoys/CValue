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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScalarTypeBoolean
/*     */ {
/*     */   public static class Native
/*     */     extends BooleanBase
/*     */   {
/*     */     public Native() {
/*  47 */       super(true, 16);
/*     */     }
/*     */     
/*     */     public Boolean toBeanType(Object value) {
/*  51 */       return BasicTypeConverter.toBoolean(value);
/*     */     }
/*     */     
/*     */     public Object toJdbcType(Object value) {
/*  55 */       return BasicTypeConverter.convert(value, this.jdbcType);
/*     */     }
/*     */     
/*     */     public void bind(DataBind b, Boolean value) throws SQLException {
/*  59 */       if (value == null) {
/*  60 */         b.setNull(16);
/*     */       } else {
/*  62 */         b.setBoolean(value.booleanValue());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Boolean read(DataReader dataReader) throws SQLException {
/*  68 */       return dataReader.getBoolean();
/*     */     }
/*     */   }
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
/*     */   public static class BitBoolean
/*     */     extends BooleanBase
/*     */   {
/*     */     public BitBoolean() {
/*  86 */       super(true, -7);
/*     */     }
/*     */     
/*     */     public Boolean toBeanType(Object value) {
/*  90 */       return BasicTypeConverter.toBoolean(value);
/*     */     }
/*     */ 
/*     */     
/*     */     public Object toJdbcType(Object value) {
/*  95 */       return BasicTypeConverter.toBoolean(value);
/*     */     }
/*     */     
/*     */     public void bind(DataBind b, Boolean value) throws SQLException {
/*  99 */       if (value == null) {
/* 100 */         b.setNull(-7);
/*     */       } else {
/*     */         
/* 103 */         b.setBoolean(value.booleanValue());
/*     */       } 
/*     */     }
/*     */     
/*     */     public Boolean read(DataReader dataReader) throws SQLException {
/* 108 */       return dataReader.getBoolean();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class IntBoolean
/*     */     extends BooleanBase
/*     */   {
/*     */     private final Integer trueValue;
/*     */     
/*     */     private final Integer falseValue;
/*     */ 
/*     */     
/*     */     public IntBoolean(Integer trueValue, Integer falseValue) {
/* 122 */       super(false, 4);
/* 123 */       this.trueValue = trueValue;
/* 124 */       this.falseValue = falseValue;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getLength() {
/* 129 */       return 1;
/*     */     }
/*     */     
/*     */     public void bind(DataBind b, Boolean value) throws SQLException {
/* 133 */       if (value == null) {
/* 134 */         b.setNull(4);
/*     */       } else {
/* 136 */         b.setInt(toInteger(value).intValue());
/*     */       } 
/*     */     }
/*     */     
/*     */     public Boolean read(DataReader dataReader) throws SQLException {
/* 141 */       Integer i = dataReader.getInt();
/* 142 */       if (i == null) {
/* 143 */         return null;
/*     */       }
/* 145 */       if (i.equals(this.trueValue)) {
/* 146 */         return Boolean.TRUE;
/*     */       }
/* 148 */       return Boolean.FALSE;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object toJdbcType(Object value) {
/* 153 */       return toInteger(value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer toInteger(Object value) {
/* 160 */       if (value == null) {
/* 161 */         return null;
/*     */       }
/* 163 */       Boolean b = (Boolean)value;
/* 164 */       if (b.booleanValue()) {
/* 165 */         return this.trueValue;
/*     */       }
/* 167 */       return this.falseValue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Boolean toBeanType(Object value) {
/* 175 */       if (value == null) {
/* 176 */         return null;
/*     */       }
/* 178 */       if (value instanceof Boolean) {
/* 179 */         return (Boolean)value;
/*     */       }
/* 181 */       if (this.trueValue.equals(value)) {
/* 182 */         return Boolean.TRUE;
/*     */       }
/* 184 */       return Boolean.FALSE;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class StringBoolean
/*     */     extends BooleanBase
/*     */   {
/*     */     private final String trueValue;
/*     */     
/*     */     private final String falseValue;
/*     */ 
/*     */     
/*     */     public StringBoolean(String trueValue, String falseValue) {
/* 199 */       super(false, 12);
/* 200 */       this.trueValue = trueValue;
/* 201 */       this.falseValue = falseValue;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getLength() {
/* 207 */       return Math.max(this.trueValue.length(), this.falseValue.length());
/*     */     }
/*     */     
/*     */     public void bind(DataBind b, Boolean value) throws SQLException {
/* 211 */       if (value == null) {
/* 212 */         b.setNull(12);
/*     */       } else {
/* 214 */         b.setString(toString(value));
/*     */       } 
/*     */     }
/*     */     
/*     */     public Boolean read(DataReader dataReader) throws SQLException {
/* 219 */       String string = dataReader.getString();
/* 220 */       if (string == null) {
/* 221 */         return null;
/*     */       }
/*     */       
/* 224 */       if (string.equals(this.trueValue)) {
/* 225 */         return Boolean.TRUE;
/*     */       }
/* 227 */       return Boolean.FALSE;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object toJdbcType(Object value) {
/* 232 */       return toString(value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(Object value) {
/* 239 */       if (value == null) {
/* 240 */         return null;
/*     */       }
/* 242 */       Boolean b = (Boolean)value;
/* 243 */       if (b.booleanValue()) {
/* 244 */         return this.trueValue;
/*     */       }
/* 246 */       return this.falseValue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Boolean toBeanType(Object value) {
/* 254 */       if (value == null) {
/* 255 */         return null;
/*     */       }
/* 257 */       if (value instanceof Boolean) {
/* 258 */         return (Boolean)value;
/*     */       }
/* 260 */       if (this.trueValue.equals(value)) {
/* 261 */         return Boolean.TRUE;
/*     */       }
/* 263 */       return Boolean.FALSE;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class BooleanBase
/*     */     extends ScalarTypeBase<Boolean>
/*     */   {
/*     */     public BooleanBase(boolean jdbcNative, int jdbcType) {
/* 271 */       super(Boolean.class, jdbcNative, jdbcType);
/*     */     }
/*     */     
/*     */     public String formatValue(Boolean t) {
/* 275 */       return t.toString();
/*     */     }
/*     */     
/*     */     public Boolean parse(String value) {
/* 279 */       return Boolean.valueOf(value);
/*     */     }
/*     */     
/*     */     public Boolean parseDateTime(long systemTimeMillis) {
/* 283 */       throw new TextException("Not Supported");
/*     */     }
/*     */     
/*     */     public boolean isDateTimeCapable() {
/* 287 */       return false;
/*     */     }
/*     */     
/*     */     public int getLuceneType() {
/* 291 */       return 0;
/*     */     }
/*     */     
/*     */     public Object luceneFromIndexValue(Object value) {
/* 295 */       return parse((String)value);
/*     */     }
/*     */     
/*     */     public Object luceneToIndexValue(Object value) {
/* 299 */       return format(value);
/*     */     }
/*     */     
/*     */     public Object readData(DataInput dataInput) throws IOException {
/* 303 */       if (!dataInput.readBoolean()) {
/* 304 */         return null;
/*     */       }
/* 306 */       boolean val = dataInput.readBoolean();
/* 307 */       return Boolean.valueOf(val);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void writeData(DataOutput dataOutput, Object v) throws IOException {
/* 313 */       Boolean val = (Boolean)v;
/* 314 */       if (val == null) {
/* 315 */         dataOutput.writeBoolean(false);
/*     */       } else {
/* 317 */         dataOutput.writeBoolean(true);
/* 318 */         dataOutput.writeBoolean(val.booleanValue());
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeBoolean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */