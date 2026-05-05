/*     */ package com.avaje.ebeaninternal.api;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class BindParams
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 4541081933302086285L;
/*  42 */   private ArrayList<Param> positionedParameters = new ArrayList<Param>();
/*     */   
/*  44 */   private HashMap<String, Param> namedParameters = new HashMap<String, Param>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private int queryPlanHash = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String preparedSql;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BindParams copy() {
/*  62 */     BindParams copy = new BindParams();
/*  63 */     for (Param p : this.positionedParameters) {
/*  64 */       copy.positionedParameters.add(p.copy());
/*     */     }
/*  66 */     Iterator<Map.Entry<String, Param>> it = this.namedParameters.entrySet().iterator();
/*  67 */     while (it.hasNext()) {
/*  68 */       Map.Entry<String, Param> entry = it.next();
/*  69 */       copy.namedParameters.put(entry.getKey(), ((Param)entry.getValue()).copy());
/*     */     } 
/*  71 */     return copy;
/*     */   }
/*     */   
/*     */   public int queryBindHash() {
/*  75 */     int hc = this.namedParameters.hashCode();
/*  76 */     for (int i = 0; i < this.positionedParameters.size(); i++) {
/*  77 */       hc = hc * 31 + ((Param)this.positionedParameters.get(i)).hashCode();
/*     */     }
/*  79 */     return hc;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int hc = getClass().hashCode();
/*  84 */     hc = hc * 31 + this.namedParameters.hashCode();
/*  85 */     for (int i = 0; i < this.positionedParameters.size(); i++) {
/*  86 */       hc = hc * 31 + ((Param)this.positionedParameters.get(i)).hashCode();
/*     */     }
/*  88 */     hc = hc * 31 + ((this.preparedSql == null) ? 0 : this.preparedSql.hashCode());
/*  89 */     return hc;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o) {
/*  93 */     if (o == null) {
/*  94 */       return false;
/*     */     }
/*  96 */     if (o == this) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (o instanceof BindParams) {
/* 100 */       return (hashCode() == o.hashCode());
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 109 */     return (this.positionedParameters.isEmpty() && this.namedParameters.isEmpty());
/*     */   }
/*     */   
/*     */   public int size() {
/* 113 */     return this.positionedParameters.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean requiresNamedParamsPrepare() {
/* 122 */     return (!this.namedParameters.isEmpty() && this.positionedParameters.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNullParameter(int position, int jdbcType) {
/* 129 */     Param p = getParam(position);
/* 130 */     p.setInNullType(jdbcType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(int position, Object value, int outType) {
/* 138 */     addToQueryPlanHash(String.valueOf(position), value);
/*     */     
/* 140 */     Param p = getParam(position);
/* 141 */     p.setInValue(value);
/* 142 */     p.setOutType(outType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(int position, Object value) {
/* 151 */     addToQueryPlanHash(String.valueOf(position), value);
/*     */     
/* 153 */     Param p = getParam(position);
/* 154 */     p.setInValue(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOut(int position, int outType) {
/* 161 */     Param p = getParam(position);
/* 162 */     p.setOutType(outType);
/*     */   }
/*     */   
/*     */   private Param getParam(String name) {
/* 166 */     Param p = this.namedParameters.get(name);
/* 167 */     if (p == null) {
/* 168 */       p = new Param();
/* 169 */       this.namedParameters.put(name, p);
/*     */     } 
/* 171 */     return p;
/*     */   }
/*     */   
/*     */   private Param getParam(int position) {
/* 175 */     int more = position - this.positionedParameters.size();
/* 176 */     if (more > 0) {
/* 177 */       for (int i = 0; i < more; i++) {
/* 178 */         this.positionedParameters.add(new Param());
/*     */       }
/*     */     }
/* 181 */     return this.positionedParameters.get(position - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String name, Object value, int outType) {
/* 189 */     addToQueryPlanHash(name, value);
/*     */     
/* 191 */     Param p = getParam(name);
/* 192 */     p.setInValue(value);
/* 193 */     p.setOutType(outType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNullParameter(String name, int jdbcType) {
/* 200 */     Param p = getParam(name);
/* 201 */     p.setInNullType(jdbcType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Param setParameter(String name, Object value) {
/* 209 */     addToQueryPlanHash(name, value);
/*     */     
/* 211 */     Param p = getParam(name);
/* 212 */     p.setInValue(value);
/* 213 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addToQueryPlanHash(String name, Object value) {
/* 220 */     if (value != null && 
/* 221 */       value instanceof Collection) {
/* 222 */       this.queryPlanHash = this.queryPlanHash * 31 + name.hashCode();
/* 223 */       this.queryPlanHash = this.queryPlanHash * 31 + ((Collection)value).size();
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
/*     */   public int getQueryPlanHash() {
/* 237 */     return this.queryPlanHash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Param setEncryptionKey(String name, Object value) {
/* 247 */     Param p = getParam(name);
/* 248 */     p.setEncryptionKey(value);
/* 249 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerOut(String name, int outType) {
/* 256 */     Param p = getParam(name);
/* 257 */     p.setOutType(outType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Param getParameter(int position) {
/* 265 */     return getParam(position);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Param getParameter(String name) {
/* 272 */     return getParam(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Param> positionedParameters() {
/* 279 */     return this.positionedParameters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPreparedSql(String preparedSql) {
/* 286 */     this.preparedSql = preparedSql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPreparedSql() {
/* 294 */     return this.preparedSql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class OrderedList
/*     */   {
/*     */     final List<BindParams.Param> paramList;
/*     */ 
/*     */ 
/*     */     
/*     */     final StringBuilder preparedSql;
/*     */ 
/*     */ 
/*     */     
/*     */     public OrderedList() {
/* 311 */       this(new ArrayList<BindParams.Param>());
/*     */     }
/*     */     
/*     */     public OrderedList(List<BindParams.Param> paramList) {
/* 315 */       this.paramList = paramList;
/* 316 */       this.preparedSql = new StringBuilder();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void add(BindParams.Param param) {
/* 323 */       this.paramList.add(param);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 330 */       return this.paramList.size();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<BindParams.Param> list() {
/* 337 */       return this.paramList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendSql(String parsedSql) {
/* 344 */       this.preparedSql.append(parsedSql);
/*     */     }
/*     */     
/*     */     public String getPreparedSql() {
/* 348 */       return this.preparedSql.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Param
/*     */   {
/*     */     private boolean encryptionKey;
/*     */ 
/*     */     
/*     */     private boolean isInParam;
/*     */ 
/*     */     
/*     */     private boolean isOutParam;
/*     */ 
/*     */     
/*     */     private int type;
/*     */ 
/*     */     
/*     */     private Object inValue;
/*     */ 
/*     */     
/*     */     private Object outValue;
/*     */ 
/*     */     
/*     */     private int textLocation;
/*     */ 
/*     */ 
/*     */     
/*     */     public Param copy() {
/* 380 */       Param copy = new Param();
/* 381 */       copy.isInParam = this.isInParam;
/* 382 */       copy.isOutParam = this.isOutParam;
/* 383 */       copy.type = this.type;
/* 384 */       copy.inValue = this.inValue;
/* 385 */       copy.outValue = this.outValue;
/* 386 */       return copy;
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 390 */       int hc = getClass().hashCode();
/* 391 */       hc = hc * 31 + (this.isInParam ? 0 : 1);
/* 392 */       hc = hc * 31 + (this.isOutParam ? 0 : 1);
/* 393 */       hc = hc * 31 + this.type;
/* 394 */       hc = hc * 31 + ((this.inValue == null) ? 0 : this.inValue.hashCode());
/* 395 */       return hc;
/*     */     }
/*     */     
/*     */     public boolean equals(Object o) {
/* 399 */       if (o == null) {
/* 400 */         return false;
/*     */       }
/* 402 */       if (o == this) {
/* 403 */         return true;
/*     */       }
/* 405 */       if (o instanceof Param) {
/* 406 */         return (hashCode() == o.hashCode());
/*     */       }
/* 408 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isInParam() {
/* 416 */       return this.isInParam;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isOutParam() {
/* 424 */       return this.isOutParam;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getType() {
/* 432 */       return this.type;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setOutType(int type) {
/* 439 */       this.type = type;
/* 440 */       this.isOutParam = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setInValue(Object in) {
/* 447 */       this.inValue = in;
/* 448 */       this.isInParam = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setEncryptionKey(Object in) {
/* 455 */       this.inValue = in;
/* 456 */       this.isInParam = true;
/* 457 */       this.encryptionKey = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setInNullType(int type) {
/* 465 */       this.type = type;
/* 466 */       this.inValue = null;
/* 467 */       this.isInParam = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getOutValue() {
/* 475 */       return this.outValue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getInValue() {
/* 483 */       return this.inValue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setOutValue(Object out) {
/* 491 */       this.outValue = out;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTextLocation() {
/* 498 */       return this.textLocation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setTextLocation(int textLocation) {
/* 506 */       this.textLocation = textLocation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isEncryptionKey() {
/* 513 */       return this.encryptionKey;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\api\BindParams.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */