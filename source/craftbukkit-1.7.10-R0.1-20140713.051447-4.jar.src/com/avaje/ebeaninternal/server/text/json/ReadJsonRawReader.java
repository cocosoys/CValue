/*     */ package com.avaje.ebeaninternal.server.text.json;
/*     */ 
/*     */ import com.avaje.ebean.text.json.JsonElement;
/*     */ import com.avaje.ebean.text.json.JsonElementArray;
/*     */ import com.avaje.ebean.text.json.JsonElementBoolean;
/*     */ import com.avaje.ebean.text.json.JsonElementNull;
/*     */ import com.avaje.ebean.text.json.JsonElementNumber;
/*     */ import com.avaje.ebean.text.json.JsonElementObject;
/*     */ import com.avaje.ebean.text.json.JsonElementString;
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
/*     */ public class ReadJsonRawReader
/*     */ {
/*     */   private final ReadJsonContext ctx;
/*     */   
/*     */   public ReadJsonRawReader(ReadJsonContext ctx) {
/*  37 */     this.ctx = ctx;
/*     */   }
/*     */   
/*     */   public JsonElement readUnknownValue() {
/*  41 */     return readValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private JsonElement readValue() {
/*  46 */     this.ctx.ignoreWhiteSpace();
/*     */     
/*  48 */     char c = this.ctx.nextChar();
/*     */     
/*  50 */     switch (c) {
/*     */       case '{':
/*  52 */         return readObject();
/*     */       
/*     */       case '[':
/*  55 */         return readArray();
/*     */       
/*     */       case '"':
/*  58 */         return readString();
/*     */     } 
/*     */     
/*  61 */     return readUnquoted(c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private JsonElement readArray() {
/*  67 */     JsonElementArray a = new JsonElementArray();
/*     */     
/*     */     do {
/*  70 */       JsonElement value = readValue();
/*  71 */       a.add(value);
/*  72 */     } while (this.ctx.readArrayNext());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     return (JsonElement)a;
/*     */   }
/*     */ 
/*     */   
/*     */   private JsonElement readObject() {
/*  82 */     JsonElementObject o = new JsonElementObject();
/*     */ 
/*     */     
/*  85 */     while (this.ctx.readKeyNext()) {
/*     */ 
/*     */ 
/*     */       
/*  89 */       String key = this.ctx.getTokenKey();
/*  90 */       JsonElement value = readValue();
/*     */       
/*  92 */       o.put(key, value);
/*     */       
/*  94 */       if (!this.ctx.readValueNext()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 100 */     return (JsonElement)o;
/*     */   }
/*     */   
/*     */   private JsonElement readString() {
/* 104 */     String s = this.ctx.readQuotedValue();
/* 105 */     return (JsonElement)new JsonElementString(s);
/*     */   }
/*     */   
/*     */   private JsonElement readUnquoted(char c) {
/* 109 */     String s = this.ctx.readUnquotedValue(c);
/* 110 */     if ("null".equals(s)) {
/* 111 */       return (JsonElement)JsonElementNull.NULL;
/*     */     }
/* 113 */     if ("true".equals(s)) {
/* 114 */       return (JsonElement)JsonElementBoolean.TRUE;
/*     */     }
/* 116 */     if ("false".equals(s)) {
/* 117 */       return (JsonElement)JsonElementBoolean.FALSE;
/*     */     }
/*     */     
/* 120 */     return (JsonElement)new JsonElementNumber(s);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\text\json\ReadJsonRawReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */