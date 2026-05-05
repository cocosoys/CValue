/*     */ package com.avaje.ebeaninternal.server.ldap.expression;
/*     */ 
/*     */ import com.avaje.ebean.event.BeanQueryRequest;
/*     */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*     */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*     */ import com.avaje.ebeaninternal.server.el.ElPropertyValue;
/*     */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*     */ import com.avaje.ebeaninternal.server.type.ScalarType;
/*     */ 
/*     */ class LdSimpleExpression extends LdAbstractExpression {
/*     */   private static final long serialVersionUID = 4091359751840929075L;
/*     */   private final Op type;
/*     */   private final Object value;
/*     */   
/*     */   enum Op {
/*  16 */     EQ {
/*     */       public String toString() {
/*  18 */         return "=";
/*     */       }
/*     */     },
/*  21 */     NOT_EQ {
/*     */       public String toString() {
/*  23 */         return "<>";
/*     */       }
/*     */     },
/*  26 */     LT {
/*     */       public String toString() {
/*  28 */         return "<";
/*     */       }
/*     */     },
/*  31 */     LT_EQ {
/*     */       public String toString() {
/*  33 */         return "<=";
/*     */       }
/*     */     },
/*  36 */     GT {
/*     */       public String toString() {
/*  38 */         return ">";
/*     */       }
/*     */     },
/*  41 */     GT_EQ {
/*     */       public String toString() {
/*  43 */         return ">=";
/*     */       }
/*     */     };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LdSimpleExpression(String propertyName, Op type, Object value) {
/*  53 */     super(propertyName);
/*  54 */     this.type = type;
/*  55 */     this.value = value;
/*     */   }
/*     */   
/*     */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/*  63 */     return null;
/*     */   }
/*     */   
/*     */   public String getPropertyName() {
/*  67 */     return this.propertyName;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBindValues(SpiExpressionRequest request) {
/*  72 */     ElPropertyValue prop = getElProp(request);
/*  73 */     if (prop != null) {
/*  74 */       if (prop.isAssocId()) {
/*  75 */         Object[] ids = prop.getAssocOneIdValues(this.value);
/*  76 */         if (ids != null) {
/*  77 */           for (int i = 0; i < ids.length; i++) {
/*  78 */             request.addBindValue(ids[i]);
/*     */           }
/*     */         }
/*     */         return;
/*     */       } 
/*  83 */       ScalarType<?> scalarType = prop.getBeanProperty().getScalarType();
/*  84 */       Object v = scalarType.toJdbcType(this.value);
/*  85 */       request.addBindValue(v);
/*     */     } else {
/*  87 */       request.addBindValue(this.value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addSql(SpiExpressionRequest request) {
/*  92 */     ElPropertyValue prop = getElProp(request);
/*  93 */     if (prop != null && 
/*  94 */       prop.isAssocId()) {
/*  95 */       String rawExpr = prop.getAssocOneIdExpr(this.propertyName, this.type.toString());
/*  96 */       String str1 = request.parseDeploy(rawExpr);
/*  97 */       request.append(str1);
/*     */       
/*     */       return;
/*     */     } 
/* 101 */     String parsed = request.parseDeploy(this.propertyName);
/*     */     
/* 103 */     request.append("(").append(parsed).append("").append(this.type.toString()).append(nextParam(request)).append(")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int queryAutoFetchHash() {
/* 111 */     int hc = LdSimpleExpression.class.getName().hashCode();
/* 112 */     hc = hc * 31 + this.propertyName.hashCode();
/* 113 */     hc = hc * 31 + this.type.name().hashCode();
/* 114 */     return hc;
/*     */   }
/*     */   
/*     */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 118 */     return queryAutoFetchHash();
/*     */   }
/*     */   
/*     */   public int queryBindHash() {
/* 122 */     return this.value.hashCode();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\ldap\expression\LdSimpleExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */