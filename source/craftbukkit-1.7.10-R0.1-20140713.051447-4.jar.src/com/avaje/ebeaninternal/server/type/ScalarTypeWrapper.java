/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.config.ScalarTypeConverter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScalarTypeWrapper<B, S>
/*     */   implements ScalarType<B>
/*     */ {
/*     */   private final ScalarType<S> scalarType;
/*     */   private final ScalarTypeConverter<B, S> converter;
/*     */   private final Class<B> wrapperType;
/*     */   private final B nullValue;
/*     */   
/*     */   public ScalarTypeWrapper(Class<B> wrapperType, ScalarType<S> scalarType, ScalarTypeConverter<B, S> converter) {
/*  53 */     this.scalarType = scalarType;
/*  54 */     this.converter = converter;
/*  55 */     this.nullValue = (B)converter.getNullValue();
/*  56 */     this.wrapperType = wrapperType;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  60 */     return "ScalarTypeWrapper " + this.wrapperType + " to " + this.scalarType.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object readData(DataInput dataInput) throws IOException {
/*  65 */     Object v = this.scalarType.readData(dataInput);
/*  66 */     return this.converter.wrapValue(v);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeData(DataOutput dataOutput, Object v) throws IOException {
/*  71 */     S sv = (S)this.converter.unwrapValue(v);
/*  72 */     this.scalarType.writeData(dataOutput, sv);
/*     */   }
/*     */   
/*     */   public void bind(DataBind b, B value) throws SQLException {
/*  76 */     if (value == null) {
/*  77 */       this.scalarType.bind(b, null);
/*     */     } else {
/*  79 */       S sv = (S)this.converter.unwrapValue(value);
/*  80 */       this.scalarType.bind(b, sv);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getJdbcType() {
/*  85 */     return this.scalarType.getJdbcType();
/*     */   }
/*     */   
/*     */   public int getLength() {
/*  89 */     return this.scalarType.getLength();
/*     */   }
/*     */   
/*     */   public Class<B> getType() {
/*  93 */     return this.wrapperType;
/*     */   }
/*     */   
/*     */   public boolean isDateTimeCapable() {
/*  97 */     return this.scalarType.isDateTimeCapable();
/*     */   }
/*     */   
/*     */   public boolean isJdbcNative() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String format(Object v) {
/* 106 */     return formatValue((B)v);
/*     */   }
/*     */   
/*     */   public String formatValue(B v) {
/* 110 */     S sv = (S)this.converter.unwrapValue(v);
/* 111 */     return this.scalarType.formatValue(sv);
/*     */   }
/*     */   
/*     */   public B parse(String value) {
/* 115 */     S sv = this.scalarType.parse(value);
/* 116 */     if (sv == null) {
/* 117 */       return this.nullValue;
/*     */     }
/* 119 */     return (B)this.converter.wrapValue(sv);
/*     */   }
/*     */   
/*     */   public B parseDateTime(long systemTimeMillis) {
/* 123 */     S sv = this.scalarType.parseDateTime(systemTimeMillis);
/* 124 */     if (sv == null) {
/* 125 */       return this.nullValue;
/*     */     }
/* 127 */     return (B)this.converter.wrapValue(sv);
/*     */   }
/*     */   
/*     */   public void loadIgnore(DataReader dataReader) {
/* 131 */     dataReader.incrementPos(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public B read(DataReader dataReader) throws SQLException {
/* 136 */     S sv = this.scalarType.read(dataReader);
/* 137 */     if (sv == null) {
/* 138 */       return this.nullValue;
/*     */     }
/* 140 */     return (B)this.converter.wrapValue(sv);
/*     */   }
/*     */ 
/*     */   
/*     */   public B toBeanType(Object value) {
/* 145 */     if (value == null) {
/* 146 */       return this.nullValue;
/*     */     }
/* 148 */     if (getType().isAssignableFrom(value.getClass())) {
/* 149 */       return (B)value;
/*     */     }
/* 151 */     if (value instanceof String) {
/* 152 */       return parse((String)value);
/*     */     }
/* 154 */     S sv = this.scalarType.toBeanType(value);
/* 155 */     return (B)this.converter.wrapValue(sv);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object toJdbcType(Object value) {
/* 161 */     Object sv = this.converter.unwrapValue(value);
/* 162 */     if (sv == null) {
/* 163 */       return this.nullValue;
/*     */     }
/* 165 */     return this.scalarType.toJdbcType(sv);
/*     */   }
/*     */   
/*     */   public void accumulateScalarTypes(String propName, CtCompoundTypeScalarList list) {
/* 169 */     list.addScalarType(propName, this);
/*     */   }
/*     */   
/*     */   public ScalarType<?> getScalarType() {
/* 173 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String jsonToString(B value, JsonValueAdapter ctx) {
/* 178 */     S sv = (S)this.converter.unwrapValue(value);
/* 179 */     return this.scalarType.jsonToString(sv, ctx);
/*     */   }
/*     */   
/*     */   public B jsonFromString(String value, JsonValueAdapter ctx) {
/* 183 */     S s = this.scalarType.jsonFromString(value, ctx);
/* 184 */     return (B)this.converter.wrapValue(s);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object luceneFromIndexValue(Object value) {
/* 189 */     S s = (S)this.scalarType.luceneFromIndexValue(value);
/* 190 */     return this.converter.wrapValue(s);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object luceneToIndexValue(Object value) {
/* 195 */     S sv = (S)this.converter.unwrapValue(value);
/* 196 */     return this.scalarType.luceneToIndexValue(sv);
/*     */   }
/*     */   
/*     */   public int getLuceneType() {
/* 200 */     return this.scalarType.getLuceneType();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */