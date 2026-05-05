/*     */ package com.avaje.ebeaninternal.server.text.json;
/*     */ 
/*     */ import com.avaje.ebean.text.TextException;
/*     */ import com.avaje.ebean.text.json.JsonContext;
/*     */ import com.avaje.ebean.text.json.JsonReadOptions;
/*     */ import com.avaje.ebean.text.json.JsonValueAdapter;
/*     */ import com.avaje.ebean.text.json.JsonWriteOptions;
/*     */ import com.avaje.ebeaninternal.api.SpiEbeanServer;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.util.ParamTypeHelper;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class DJsonContext
/*     */   implements JsonContext
/*     */ {
/*     */   private final SpiEbeanServer server;
/*     */   private final JsonValueAdapter dfltValueAdapter;
/*     */   private final boolean dfltPretty;
/*     */   
/*     */   public DJsonContext(SpiEbeanServer server, JsonValueAdapter dfltValueAdapter, boolean dfltPretty) {
/*  55 */     this.server = server;
/*  56 */     this.dfltValueAdapter = dfltValueAdapter;
/*  57 */     this.dfltPretty = dfltPretty;
/*     */   }
/*     */   
/*     */   public boolean isSupportedType(Type genericType) {
/*  61 */     return this.server.isSupportedType(genericType);
/*     */   }
/*     */   
/*     */   private ReadJsonSource createReader(Reader jsonReader) {
/*  65 */     return new ReadJsonSourceReader(jsonReader, 256, 512);
/*     */   }
/*     */   
/*     */   public <T> T toBean(Class<T> cls, String json) {
/*  69 */     return toBean(cls, new ReadJsonSourceString(json), (JsonReadOptions)null);
/*     */   }
/*     */   
/*     */   public <T> T toBean(Class<T> cls, Reader jsonReader) {
/*  73 */     return toBean(cls, createReader(jsonReader), (JsonReadOptions)null);
/*     */   }
/*     */   
/*     */   public <T> T toBean(Class<T> cls, String json, JsonReadOptions options) {
/*  77 */     return toBean(cls, new ReadJsonSourceString(json), options);
/*     */   }
/*     */   
/*     */   public <T> T toBean(Class<T> cls, Reader jsonReader, JsonReadOptions options) {
/*  81 */     return toBean(cls, createReader(jsonReader), options);
/*     */   }
/*     */ 
/*     */   
/*     */   private <T> T toBean(Class<T> cls, ReadJsonSource src, JsonReadOptions options) {
/*  86 */     BeanDescriptor<T> d = getDecriptor(cls);
/*  87 */     ReadJsonContext ctx = new ReadJsonContext(src, this.dfltValueAdapter, options);
/*  88 */     return (T)d.jsonReadBean(ctx, null);
/*     */   }
/*     */   
/*     */   public <T> List<T> toList(Class<T> cls, String json) {
/*  92 */     return toList(cls, new ReadJsonSourceString(json), (JsonReadOptions)null);
/*     */   }
/*     */   
/*     */   public <T> List<T> toList(Class<T> cls, String json, JsonReadOptions options) {
/*  96 */     return toList(cls, new ReadJsonSourceString(json), options);
/*     */   }
/*     */   
/*     */   public <T> List<T> toList(Class<T> cls, Reader jsonReader) {
/* 100 */     return toList(cls, createReader(jsonReader), (JsonReadOptions)null);
/*     */   }
/*     */   
/*     */   public <T> List<T> toList(Class<T> cls, Reader jsonReader, JsonReadOptions options) {
/* 104 */     return toList(cls, createReader(jsonReader), options);
/*     */   }
/*     */ 
/*     */   
/*     */   private <T> List<T> toList(Class<T> cls, ReadJsonSource src, JsonReadOptions options) {
/*     */     try {
/* 110 */       BeanDescriptor<T> d = getDecriptor(cls);
/*     */       
/* 112 */       List<T> list = new ArrayList<T>();
/*     */       
/* 114 */       ReadJsonContext ctx = new ReadJsonContext(src, this.dfltValueAdapter, options);
/* 115 */       ctx.readArrayBegin();
/*     */       do {
/* 117 */         T bean = (T)d.jsonReadBean(ctx, null);
/* 118 */         if (bean == null)
/* 119 */           continue;  list.add(bean);
/*     */       }
/* 121 */       while (ctx.readArrayNext());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 126 */       return list;
/* 127 */     } catch (RuntimeException e) {
/* 128 */       throw new TextException("Error parsing " + src, e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object toObject(Type genericType, String json, JsonReadOptions options) {
/* 135 */     ParamTypeHelper.TypeInfo info = ParamTypeHelper.getTypeInfo(genericType);
/* 136 */     ParamTypeHelper.ManyType manyType = info.getManyType();
/* 137 */     switch (manyType) {
/*     */       case NONE:
/* 139 */         return toBean(info.getBeanType(), json, options);
/*     */       
/*     */       case LIST:
/* 142 */         return toList(info.getBeanType(), json, options);
/*     */     } 
/*     */     
/* 145 */     String msg = "ManyType " + manyType + " not supported yet";
/* 146 */     throw new TextException(msg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object toObject(Type genericType, Reader json, JsonReadOptions options) {
/* 152 */     ParamTypeHelper.TypeInfo info = ParamTypeHelper.getTypeInfo(genericType);
/* 153 */     ParamTypeHelper.ManyType manyType = info.getManyType();
/* 154 */     switch (manyType) {
/*     */       case NONE:
/* 156 */         return toBean(info.getBeanType(), json, options);
/*     */       
/*     */       case LIST:
/* 159 */         return toList(info.getBeanType(), json, options);
/*     */     } 
/*     */     
/* 162 */     String msg = "ManyType " + manyType + " not supported yet";
/* 163 */     throw new TextException(msg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toJsonWriter(Object o, Writer writer) {
/* 169 */     toJsonWriter(o, writer, this.dfltPretty, null, null);
/*     */   }
/*     */   
/*     */   public void toJsonWriter(Object o, Writer writer, boolean pretty) {
/* 173 */     toJsonWriter(o, writer, pretty, null, null);
/*     */   }
/*     */   
/*     */   public void toJsonWriter(Object o, Writer writer, boolean pretty, JsonWriteOptions options) {
/* 177 */     toJsonWriter(o, writer, pretty, null, null);
/*     */   }
/*     */   
/*     */   public void toJsonWriter(Object o, Writer writer, boolean pretty, JsonWriteOptions options, String callback) {
/* 181 */     toJsonInternal(o, new WriteJsonBufferWriter(writer), pretty, options, callback);
/*     */   }
/*     */   
/*     */   public String toJsonString(Object o) {
/* 185 */     return toJsonString(o, this.dfltPretty, null);
/*     */   }
/*     */   
/*     */   public String toJsonString(Object o, boolean pretty) {
/* 189 */     return toJsonString(o, pretty, null);
/*     */   }
/*     */   
/*     */   public String toJsonString(Object o, boolean pretty, JsonWriteOptions options) {
/* 193 */     return toJsonString(o, pretty, options, null);
/*     */   }
/*     */   
/*     */   public String toJsonString(Object o, boolean pretty, JsonWriteOptions options, String callback) {
/* 197 */     WriteJsonBufferString b = new WriteJsonBufferString();
/* 198 */     toJsonInternal(o, b, pretty, options, callback);
/* 199 */     return b.getBufferOutput();
/*     */   }
/*     */ 
/*     */   
/*     */   private void toJsonInternal(Object o, WriteJsonBuffer buffer, boolean pretty, JsonWriteOptions options, String requestCallback) {
/* 204 */     if (o instanceof Collection) {
/* 205 */       toJsonFromCollection((Collection)o, buffer, pretty, options, requestCallback);
/*     */     } else {
/*     */       
/* 208 */       BeanDescriptor<?> d = getDecriptor(o.getClass());
/* 209 */       WriteJsonContext ctx = new WriteJsonContext(buffer, pretty, this.dfltValueAdapter, options, requestCallback);
/* 210 */       d.jsonWrite(ctx, o);
/* 211 */       ctx.end();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private <T> String toJsonFromCollection(Collection<T> c, WriteJsonBuffer buffer, boolean pretty, JsonWriteOptions options, String requestCallback) {
/* 219 */     Iterator<T> it = c.iterator();
/* 220 */     if (!it.hasNext()) {
/* 221 */       return null;
/*     */     }
/*     */     
/* 224 */     WriteJsonContext ctx = new WriteJsonContext(buffer, pretty, this.dfltValueAdapter, options, requestCallback);
/*     */     
/* 226 */     Object o = it.next();
/* 227 */     BeanDescriptor<?> d = getDecriptor(o.getClass());
/*     */     
/* 229 */     ctx.appendArrayBegin();
/* 230 */     d.jsonWrite(ctx, o);
/* 231 */     while (it.hasNext()) {
/* 232 */       ctx.appendComma();
/* 233 */       T t = it.next();
/* 234 */       d.jsonWrite(ctx, t);
/*     */     } 
/* 236 */     ctx.appendArrayEnd();
/* 237 */     ctx.end();
/* 238 */     return ctx.getJson();
/*     */   }
/*     */   
/*     */   private <T> BeanDescriptor<T> getDecriptor(Class<T> cls) {
/* 242 */     BeanDescriptor<T> d = this.server.getBeanDescriptor(cls);
/* 243 */     if (d == null) {
/* 244 */       String msg = "No BeanDescriptor found for " + cls;
/* 245 */       throw new RuntimeException(msg);
/*     */     } 
/* 247 */     return d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\text\json\DJsonContext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */