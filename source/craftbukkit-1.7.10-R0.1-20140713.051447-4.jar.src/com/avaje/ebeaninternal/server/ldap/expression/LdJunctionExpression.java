/*     */ package com.avaje.ebeaninternal.server.ldap.expression;
/*     */ 
/*     */ import com.avaje.ebean.Expression;
/*     */ import com.avaje.ebean.ExpressionFactory;
/*     */ import com.avaje.ebean.ExpressionList;
/*     */ import com.avaje.ebean.FutureIds;
/*     */ import com.avaje.ebean.FutureList;
/*     */ import com.avaje.ebean.FutureRowCount;
/*     */ import com.avaje.ebean.Junction;
/*     */ import com.avaje.ebean.OrderBy;
/*     */ import com.avaje.ebean.PagingList;
/*     */ import com.avaje.ebean.Query;
/*     */ import com.avaje.ebean.QueryIterator;
/*     */ import com.avaje.ebean.QueryListener;
/*     */ import com.avaje.ebean.QueryResultVisitor;
/*     */ import com.avaje.ebean.event.BeanQueryRequest;
/*     */ import com.avaje.ebeaninternal.api.ManyWhereJoins;
/*     */ import com.avaje.ebeaninternal.api.SpiExpression;
/*     */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*     */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*     */ import com.avaje.ebeaninternal.util.DefaultExpressionList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ abstract class LdJunctionExpression<T>
/*     */   implements Junction<T>, SpiExpression
/*     */ {
/*     */   private static final long serialVersionUID = -7422204102750462677L;
/*     */   private final DefaultExpressionList<T> exprList;
/*     */   private final String joinType;
/*     */   
/*     */   static class Conjunction<T>
/*     */     extends LdJunctionExpression<T> {
/*     */     private static final long serialVersionUID = -645619859900030679L;
/*     */     
/*     */     Conjunction(Query<T> query, ExpressionList<T> parent) {
/*  41 */       super("&", query, parent);
/*     */     }
/*     */     
/*     */     Conjunction(ExpressionFactory exprFactory) {
/*  45 */       super("&", exprFactory);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Disjunction<T>
/*     */     extends LdJunctionExpression<T> {
/*     */     private static final long serialVersionUID = -8464470066692221414L;
/*     */     
/*     */     Disjunction(Query<T> query, ExpressionList<T> parent) {
/*  54 */       super("|", query, parent);
/*     */     }
/*     */     
/*     */     Disjunction(ExpressionFactory exprFactory) {
/*  58 */       super("|", exprFactory);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LdJunctionExpression(String joinType, Query<T> query, ExpressionList<T> parent) {
/*  68 */     this.joinType = joinType;
/*  69 */     this.exprList = new DefaultExpressionList(query, parent);
/*     */   }
/*     */   
/*     */   LdJunctionExpression(String joinType, ExpressionFactory exprFactory) {
/*  73 */     this.joinType = joinType;
/*  74 */     this.exprList = new DefaultExpressionList(null, exprFactory, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/*  83 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins manyWhereJoin) {
/*  88 */     List<SpiExpression> list = this.exprList.internalList();
/*  89 */     for (int i = 0; i < list.size(); i++) {
/*  90 */       ((SpiExpression)list.get(i)).containsMany(desc, manyWhereJoin);
/*     */     }
/*     */   }
/*     */   
/*     */   public Junction<T> add(Expression item) {
/*  95 */     SpiExpression i = (SpiExpression)item;
/*  96 */     this.exprList.add((Expression)i);
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBindValues(SpiExpressionRequest request) {
/* 102 */     List<SpiExpression> list = this.exprList.internalList();
/* 103 */     for (int i = 0; i < list.size(); i++) {
/* 104 */       SpiExpression item = list.get(i);
/* 105 */       item.addBindValues(request);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSql(SpiExpressionRequest request) {
/* 111 */     List<SpiExpression> list = this.exprList.internalList();
/* 112 */     if (!list.isEmpty()) {
/* 113 */       request.append("(");
/* 114 */       request.append(this.joinType);
/*     */       
/* 116 */       for (int i = 0; i < list.size(); i++) {
/* 117 */         SpiExpression item = list.get(i);
/* 118 */         item.addSql(request);
/*     */       } 
/*     */       
/* 121 */       request.append(") ");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int queryAutoFetchHash() {
/* 129 */     int hc = LdJunctionExpression.class.getName().hashCode();
/* 130 */     hc = hc * 31 + this.joinType.hashCode();
/* 131 */     List<SpiExpression> list = this.exprList.internalList();
/* 132 */     for (int i = 0; i < list.size(); i++) {
/* 133 */       hc = hc * 31 + ((SpiExpression)list.get(i)).queryAutoFetchHash();
/*     */     }
/*     */     
/* 136 */     return hc;
/*     */   }
/*     */   
/*     */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 140 */     int hc = LdJunctionExpression.class.getName().hashCode();
/* 141 */     hc = hc * 31 + this.joinType.hashCode();
/* 142 */     List<SpiExpression> list = this.exprList.internalList();
/* 143 */     for (int i = 0; i < list.size(); i++) {
/* 144 */       hc = hc * 31 + ((SpiExpression)list.get(i)).queryPlanHash(request);
/*     */     }
/*     */     
/* 147 */     return hc;
/*     */   }
/*     */   
/*     */   public int queryBindHash() {
/* 151 */     int hc = LdJunctionExpression.class.getName().hashCode();
/* 152 */     List<SpiExpression> list = this.exprList.internalList();
/* 153 */     for (int i = 0; i < list.size(); i++) {
/* 154 */       hc = hc * 31 + ((SpiExpression)list.get(i)).queryBindHash();
/*     */     }
/*     */     
/* 157 */     return hc;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> endJunction() {
/* 161 */     return this.exprList.endJunction();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> allEq(Map<String, Object> propertyMap) {
/* 165 */     return this.exprList.allEq(propertyMap);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> and(Expression expOne, Expression expTwo) {
/* 169 */     return this.exprList.and(expOne, expTwo);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> between(String propertyName, Object value1, Object value2) {
/* 173 */     return this.exprList.between(propertyName, value1, value2);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> betweenProperties(String lowProperty, String highProperty, Object value) {
/* 177 */     return this.exprList.betweenProperties(lowProperty, highProperty, value);
/*     */   }
/*     */   
/*     */   public Junction<T> conjunction() {
/* 181 */     return this.exprList.conjunction();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> contains(String propertyName, String value) {
/* 185 */     return this.exprList.contains(propertyName, value);
/*     */   }
/*     */   
/*     */   public Junction<T> disjunction() {
/* 189 */     return this.exprList.disjunction();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> endsWith(String propertyName, String value) {
/* 193 */     return this.exprList.endsWith(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> eq(String propertyName, Object value) {
/* 197 */     return this.exprList.eq(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> exampleLike(Object example) {
/* 201 */     return this.exprList.exampleLike(example);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> filterMany(String prop) {
/* 205 */     throw new RuntimeException("filterMany not allowed on Junction expression list");
/*     */   }
/*     */   
/*     */   public FutureIds<T> findFutureIds() {
/* 209 */     return this.exprList.findFutureIds();
/*     */   }
/*     */   
/*     */   public FutureList<T> findFutureList() {
/* 213 */     return this.exprList.findFutureList();
/*     */   }
/*     */   
/*     */   public FutureRowCount<T> findFutureRowCount() {
/* 217 */     return this.exprList.findFutureRowCount();
/*     */   }
/*     */   
/*     */   public List<Object> findIds() {
/* 221 */     return this.exprList.findIds();
/*     */   }
/*     */   
/*     */   public void findVisit(QueryResultVisitor<T> visitor) {
/* 225 */     this.exprList.findVisit(visitor);
/*     */   }
/*     */   
/*     */   public QueryIterator<T> findIterate() {
/* 229 */     return this.exprList.findIterate();
/*     */   }
/*     */   
/*     */   public List<T> findList() {
/* 233 */     return this.exprList.findList();
/*     */   }
/*     */   
/*     */   public Map<?, T> findMap() {
/* 237 */     return this.exprList.findMap();
/*     */   }
/*     */   
/*     */   public <K> Map<K, T> findMap(String keyProperty, Class<K> keyType) {
/* 241 */     return this.exprList.findMap(keyProperty, keyType);
/*     */   }
/*     */   
/*     */   public PagingList<T> findPagingList(int pageSize) {
/* 245 */     return this.exprList.findPagingList(pageSize);
/*     */   }
/*     */   
/*     */   public int findRowCount() {
/* 249 */     return this.exprList.findRowCount();
/*     */   }
/*     */   
/*     */   public Set<T> findSet() {
/* 253 */     return this.exprList.findSet();
/*     */   }
/*     */   
/*     */   public T findUnique() {
/* 257 */     return (T)this.exprList.findUnique();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ge(String propertyName, Object value) {
/* 261 */     return this.exprList.ge(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> gt(String propertyName, Object value) {
/* 265 */     return this.exprList.gt(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> having() {
/* 269 */     throw new RuntimeException("having() not allowed on Junction expression list");
/*     */   }
/*     */   
/*     */   public ExpressionList<T> icontains(String propertyName, String value) {
/* 273 */     return this.exprList.icontains(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> idEq(Object value) {
/* 277 */     return this.exprList.idEq(value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> idIn(List<?> idValues) {
/* 281 */     return this.exprList.idIn(idValues);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> iendsWith(String propertyName, String value) {
/* 285 */     return this.exprList.iendsWith(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ieq(String propertyName, String value) {
/* 289 */     return this.exprList.ieq(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> iexampleLike(Object example) {
/* 293 */     return this.exprList.iexampleLike(example);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ilike(String propertyName, String value) {
/* 297 */     return this.exprList.ilike(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Collection<?> values) {
/* 301 */     return this.exprList.in(propertyName, values);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Object... values) {
/* 305 */     return this.exprList.in(propertyName, values);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Query<?> subQuery) {
/* 309 */     return this.exprList.in(propertyName, subQuery);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> isNotNull(String propertyName) {
/* 313 */     return this.exprList.isNotNull(propertyName);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> isNull(String propertyName) {
/* 317 */     return this.exprList.isNull(propertyName);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> istartsWith(String propertyName, String value) {
/* 321 */     return this.exprList.istartsWith(propertyName, value);
/*     */   }
/*     */   
/*     */   public Query<T> join(String assocProperty, String assocProperties) {
/* 325 */     return this.exprList.join(assocProperty, assocProperties);
/*     */   }
/*     */   
/*     */   public Query<T> join(String assocProperties) {
/* 329 */     return this.exprList.join(assocProperties);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> le(String propertyName, Object value) {
/* 333 */     return this.exprList.le(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> like(String propertyName, String value) {
/* 337 */     return this.exprList.like(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> lt(String propertyName, Object value) {
/* 341 */     return this.exprList.lt(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> lucene(String propertyName, String value) {
/* 345 */     return this.exprList.lucene(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ne(String propertyName, Object value) {
/* 349 */     return this.exprList.ne(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> not(Expression exp) {
/* 353 */     return this.exprList.not(exp);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> or(Expression expOne, Expression expTwo) {
/* 357 */     return this.exprList.or(expOne, expTwo);
/*     */   }
/*     */   
/*     */   public OrderBy<T> order() {
/* 361 */     return this.exprList.order();
/*     */   }
/*     */   
/*     */   public Query<T> order(String orderByClause) {
/* 365 */     return this.exprList.order(orderByClause);
/*     */   }
/*     */   
/*     */   public OrderBy<T> orderBy() {
/* 369 */     return this.exprList.orderBy();
/*     */   }
/*     */   
/*     */   public Query<T> orderBy(String orderBy) {
/* 373 */     return this.exprList.orderBy(orderBy);
/*     */   }
/*     */   
/*     */   public Query<T> query() {
/* 377 */     return this.exprList.query();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw, Object value) {
/* 381 */     return this.exprList.raw(raw, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw, Object[] values) {
/* 385 */     return this.exprList.raw(raw, values);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw) {
/* 389 */     return this.exprList.raw(raw);
/*     */   }
/*     */   
/*     */   public Query<T> select(String properties) {
/* 393 */     return this.exprList.select(properties);
/*     */   }
/*     */   
/*     */   public Query<T> setBackgroundFetchAfter(int backgroundFetchAfter) {
/* 397 */     return this.exprList.setBackgroundFetchAfter(backgroundFetchAfter);
/*     */   }
/*     */   
/*     */   public Query<T> setFirstRow(int firstRow) {
/* 401 */     return this.exprList.setFirstRow(firstRow);
/*     */   }
/*     */   
/*     */   public Query<T> setListener(QueryListener<T> queryListener) {
/* 405 */     return this.exprList.setListener(queryListener);
/*     */   }
/*     */   
/*     */   public Query<T> setMapKey(String mapKey) {
/* 409 */     return this.exprList.setMapKey(mapKey);
/*     */   }
/*     */   
/*     */   public Query<T> setMaxRows(int maxRows) {
/* 413 */     return this.exprList.setMaxRows(maxRows);
/*     */   }
/*     */   
/*     */   public Query<T> setOrderBy(String orderBy) {
/* 417 */     return this.exprList.setOrderBy(orderBy);
/*     */   }
/*     */   
/*     */   public Query<T> setUseCache(boolean useCache) {
/* 421 */     return this.exprList.setUseCache(useCache);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> startsWith(String propertyName, String value) {
/* 425 */     return this.exprList.startsWith(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> where() {
/* 429 */     return this.exprList.where();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\ldap\expression\LdJunctionExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */