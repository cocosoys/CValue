/*     */ package com.avaje.ebeaninternal.util;
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
/*     */ import com.avaje.ebeaninternal.api.SpiExpressionList;
/*     */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*     */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultExpressionList<T>
/*     */   implements SpiExpressionList<T>
/*     */ {
/*     */   private static final long serialVersionUID = -6992345500247035947L;
/*  38 */   private final ArrayList<SpiExpression> list = new ArrayList<SpiExpression>();
/*     */   
/*     */   private final Query<T> query;
/*     */   
/*     */   private final ExpressionList<T> parentExprList;
/*     */   
/*     */   private transient ExpressionFactory expr;
/*     */   
/*     */   private final String exprLang;
/*     */   private final String listAndStart;
/*     */   private final String listAndEnd;
/*     */   private final String listAndJoin;
/*     */   
/*     */   public DefaultExpressionList(Query<T> query, ExpressionList<T> parentExprList) {
/*  52 */     this(query, query.getExpressionFactory(), parentExprList);
/*     */   }
/*     */   
/*     */   public DefaultExpressionList(Query<T> query, ExpressionFactory expr, ExpressionList<T> parentExprList) {
/*  56 */     this.query = query;
/*  57 */     this.expr = expr;
/*  58 */     this.exprLang = expr.getLang();
/*  59 */     this.parentExprList = parentExprList;
/*     */     
/*  61 */     if ("ldap".equals(this.exprLang)) {
/*     */       
/*  63 */       this.listAndStart = "(&";
/*  64 */       this.listAndEnd = ")";
/*  65 */       this.listAndJoin = "";
/*     */     } else {
/*     */       
/*  68 */       this.listAndStart = "";
/*  69 */       this.listAndEnd = "";
/*  70 */       this.listAndJoin = " and ";
/*     */     } 
/*     */   }
/*     */   
/*     */   public void trimPath(int prefixTrim) {
/*  75 */     throw new RuntimeException("Only allowed on FilterExpressionList");
/*     */   }
/*     */   
/*     */   public List<SpiExpression> internalList() {
/*  79 */     return this.list;
/*     */   }
/*     */   
/*     */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/*  83 */     for (int i = 0; i < this.list.size(); i++) {
/*  84 */       if (!((SpiExpression)this.list.get(i)).isLuceneResolvable(req)) {
/*  85 */         return false;
/*     */       }
/*     */     } 
/*  88 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request, SpiLuceneExpr.ExprOccur occur) {
/*  93 */     LuceneQueryList queryList = new LuceneQueryList(occur);
/*  94 */     for (int i = 0; i < this.list.size(); i++) {
/*  95 */       SpiLuceneExpr query = ((SpiExpression)this.list.get(i)).createLuceneExpr(request);
/*  96 */       queryList.add(query);
/*     */     } 
/*  98 */     return queryList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpressionFactory(ExpressionFactory expr) {
/* 109 */     this.expr = expr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultExpressionList<T> copy(Query<T> query) {
/* 120 */     DefaultExpressionList<T> copy = new DefaultExpressionList(query, this.expr, null);
/* 121 */     copy.list.addAll(this.list);
/* 122 */     return copy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins whereManyJoins) {
/* 130 */     for (int i = 0; i < this.list.size(); i++) {
/* 131 */       ((SpiExpression)this.list.get(i)).containsMany(desc, whereManyJoins);
/*     */     }
/*     */   }
/*     */   
/*     */   public ExpressionList<T> endJunction() {
/* 136 */     return (this.parentExprList == null) ? (ExpressionList<T>)this : this.parentExprList;
/*     */   }
/*     */   
/*     */   public Query<T> query() {
/* 140 */     return this.query;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> where() {
/* 144 */     return this.query.where();
/*     */   }
/*     */   
/*     */   public OrderBy<T> order() {
/* 148 */     return this.query.order();
/*     */   }
/*     */   
/*     */   public OrderBy<T> orderBy() {
/* 152 */     return this.query.order();
/*     */   }
/*     */   
/*     */   public Query<T> order(String orderByClause) {
/* 156 */     return this.query.order(orderByClause);
/*     */   }
/*     */   
/*     */   public Query<T> orderBy(String orderBy) {
/* 160 */     return this.query.order(orderBy);
/*     */   }
/*     */   
/*     */   public Query<T> setOrderBy(String orderBy) {
/* 164 */     return this.query.order(orderBy);
/*     */   }
/*     */ 
/*     */   
/*     */   public FutureIds<T> findFutureIds() {
/* 169 */     return this.query.findFutureIds();
/*     */   }
/*     */   
/*     */   public FutureRowCount<T> findFutureRowCount() {
/* 173 */     return this.query.findFutureRowCount();
/*     */   }
/*     */   
/*     */   public FutureList<T> findFutureList() {
/* 177 */     return this.query.findFutureList();
/*     */   }
/*     */   
/*     */   public PagingList<T> findPagingList(int pageSize) {
/* 181 */     return this.query.findPagingList(pageSize);
/*     */   }
/*     */   
/*     */   public int findRowCount() {
/* 185 */     return this.query.findRowCount();
/*     */   }
/*     */   
/*     */   public List<Object> findIds() {
/* 189 */     return this.query.findIds();
/*     */   }
/*     */   
/*     */   public void findVisit(QueryResultVisitor<T> visitor) {
/* 193 */     this.query.findVisit(visitor);
/*     */   }
/*     */   
/*     */   public QueryIterator<T> findIterate() {
/* 197 */     return this.query.findIterate();
/*     */   }
/*     */   
/*     */   public List<T> findList() {
/* 201 */     return this.query.findList();
/*     */   }
/*     */   
/*     */   public Set<T> findSet() {
/* 205 */     return this.query.findSet();
/*     */   }
/*     */   
/*     */   public Map<?, T> findMap() {
/* 209 */     return this.query.findMap();
/*     */   }
/*     */   
/*     */   public <K> Map<K, T> findMap(String keyProperty, Class<K> keyType) {
/* 213 */     return this.query.findMap(keyProperty, keyType);
/*     */   }
/*     */   
/*     */   public T findUnique() {
/* 217 */     return (T)this.query.findUnique();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> filterMany(String prop) {
/* 221 */     return this.query.filterMany(prop);
/*     */   }
/*     */   
/*     */   public Query<T> select(String fetchProperties) {
/* 225 */     return this.query.select(fetchProperties);
/*     */   }
/*     */   
/*     */   public Query<T> join(String assocProperties) {
/* 229 */     return this.query.fetch(assocProperties);
/*     */   }
/*     */   
/*     */   public Query<T> join(String assocProperty, String assocProperties) {
/* 233 */     return this.query.fetch(assocProperty, assocProperties);
/*     */   }
/*     */   
/*     */   public Query<T> setFirstRow(int firstRow) {
/* 237 */     return this.query.setFirstRow(firstRow);
/*     */   }
/*     */   
/*     */   public Query<T> setMaxRows(int maxRows) {
/* 241 */     return this.query.setMaxRows(maxRows);
/*     */   }
/*     */   
/*     */   public Query<T> setBackgroundFetchAfter(int backgroundFetchAfter) {
/* 245 */     return this.query.setBackgroundFetchAfter(backgroundFetchAfter);
/*     */   }
/*     */   
/*     */   public Query<T> setMapKey(String mapKey) {
/* 249 */     return this.query.setMapKey(mapKey);
/*     */   }
/*     */   
/*     */   public Query<T> setListener(QueryListener<T> queryListener) {
/* 253 */     return this.query.setListener(queryListener);
/*     */   }
/*     */   
/*     */   public Query<T> setUseCache(boolean useCache) {
/* 257 */     return this.query.setUseCache(useCache);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> having() {
/* 261 */     return this.query.having();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> add(Expression expr) {
/* 265 */     this.list.add((SpiExpression)expr);
/* 266 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 270 */     return this.list.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public String buildSql(SpiExpressionRequest request) {
/* 275 */     request.append(this.listAndStart);
/* 276 */     for (int i = 0, size = this.list.size(); i < size; i++) {
/* 277 */       SpiExpression expression = this.list.get(i);
/* 278 */       if (i > 0) {
/* 279 */         request.append(this.listAndJoin);
/*     */       }
/* 281 */       expression.addSql(request);
/*     */     } 
/* 283 */     request.append(this.listAndEnd);
/* 284 */     return request.getSql();
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Object> buildBindValues(SpiExpressionRequest request) {
/* 289 */     for (int i = 0, size = this.list.size(); i < size; i++) {
/* 290 */       SpiExpression expression = this.list.get(i);
/* 291 */       expression.addBindValues(request);
/*     */     } 
/* 293 */     return request.getBindValues();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int queryAutoFetchHash() {
/* 301 */     int hash = DefaultExpressionList.class.getName().hashCode();
/* 302 */     for (int i = 0, size = this.list.size(); i < size; i++) {
/* 303 */       SpiExpression expression = this.list.get(i);
/* 304 */       hash = hash * 31 + expression.queryAutoFetchHash();
/*     */     } 
/* 306 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 314 */     int hash = DefaultExpressionList.class.getName().hashCode();
/* 315 */     for (int i = 0, size = this.list.size(); i < size; i++) {
/* 316 */       SpiExpression expression = this.list.get(i);
/* 317 */       hash = hash * 31 + expression.queryPlanHash(request);
/*     */     } 
/* 319 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int queryBindHash() {
/* 326 */     int hash = DefaultExpressionList.class.getName().hashCode();
/* 327 */     for (int i = 0, size = this.list.size(); i < size; i++) {
/* 328 */       SpiExpression expression = this.list.get(i);
/* 329 */       hash = hash * 31 + expression.queryBindHash();
/*     */     } 
/* 331 */     return hash;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> eq(String propertyName, Object value) {
/* 335 */     add(this.expr.eq(propertyName, value));
/* 336 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ieq(String propertyName, String value) {
/* 340 */     add(this.expr.ieq(propertyName, value));
/* 341 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ne(String propertyName, Object value) {
/* 345 */     add(this.expr.ne(propertyName, value));
/* 346 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> allEq(Map<String, Object> propertyMap) {
/* 350 */     add(this.expr.allEq(propertyMap));
/* 351 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> and(Expression expOne, Expression expTwo) {
/* 355 */     add(this.expr.and(expOne, expTwo));
/* 356 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> between(String propertyName, Object value1, Object value2) {
/* 360 */     add(this.expr.between(propertyName, value1, value2));
/* 361 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> betweenProperties(String lowProperty, String highProperty, Object value) {
/* 365 */     add(this.expr.betweenProperties(lowProperty, highProperty, value));
/* 366 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public Junction<T> conjunction() {
/* 370 */     Junction<T> conjunction = this.expr.conjunction(this.query, (ExpressionList)this);
/* 371 */     add((Expression)conjunction);
/* 372 */     return conjunction;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> contains(String propertyName, String value) {
/* 376 */     add(this.expr.contains(propertyName, value));
/* 377 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> lucene(String propertyName, String value) {
/* 381 */     add(this.expr.lucene(propertyName, value));
/* 382 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public Junction<T> disjunction() {
/* 386 */     Junction<T> disjunction = this.expr.disjunction(this.query, (ExpressionList)this);
/* 387 */     add((Expression)disjunction);
/* 388 */     return disjunction;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> endsWith(String propertyName, String value) {
/* 392 */     add(this.expr.endsWith(propertyName, value));
/* 393 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ge(String propertyName, Object value) {
/* 397 */     add(this.expr.ge(propertyName, value));
/* 398 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> gt(String propertyName, Object value) {
/* 402 */     add(this.expr.gt(propertyName, value));
/* 403 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> icontains(String propertyName, String value) {
/* 407 */     add(this.expr.icontains(propertyName, value));
/* 408 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> idIn(List<?> idList) {
/* 412 */     add(this.expr.idIn(idList));
/* 413 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> idEq(Object value) {
/* 417 */     add(this.expr.idEq(value));
/* 418 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> iendsWith(String propertyName, String value) {
/* 422 */     add(this.expr.iendsWith(propertyName, value));
/* 423 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ilike(String propertyName, String value) {
/* 427 */     add(this.expr.ilike(propertyName, value));
/* 428 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Query<?> subQuery) {
/* 432 */     add(this.expr.in(propertyName, subQuery));
/* 433 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Collection<?> values) {
/* 437 */     add(this.expr.in(propertyName, values));
/* 438 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Object... values) {
/* 442 */     add(this.expr.in(propertyName, values));
/* 443 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> isNotNull(String propertyName) {
/* 447 */     add(this.expr.isNotNull(propertyName));
/* 448 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> isNull(String propertyName) {
/* 452 */     add(this.expr.isNull(propertyName));
/* 453 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> istartsWith(String propertyName, String value) {
/* 457 */     add(this.expr.istartsWith(propertyName, value));
/* 458 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> le(String propertyName, Object value) {
/* 462 */     add(this.expr.le(propertyName, value));
/* 463 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> exampleLike(Object example) {
/* 467 */     add((Expression)this.expr.exampleLike(example));
/* 468 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> iexampleLike(Object example) {
/* 472 */     add((Expression)this.expr.iexampleLike(example));
/* 473 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> like(String propertyName, String value) {
/* 477 */     add(this.expr.like(propertyName, value));
/* 478 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> lt(String propertyName, Object value) {
/* 482 */     add(this.expr.lt(propertyName, value));
/* 483 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> not(Expression exp) {
/* 487 */     add(this.expr.not(exp));
/* 488 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> or(Expression expOne, Expression expTwo) {
/* 492 */     add(this.expr.or(expOne, expTwo));
/* 493 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw, Object value) {
/* 497 */     add(this.expr.raw(raw, value));
/* 498 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw, Object[] values) {
/* 502 */     add(this.expr.raw(raw, values));
/* 503 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw) {
/* 507 */     add(this.expr.raw(raw));
/* 508 */     return (ExpressionList<T>)this;
/*     */   }
/*     */   
/*     */   public ExpressionList<T> startsWith(String propertyName, String value) {
/* 512 */     add(this.expr.startsWith(propertyName, value));
/* 513 */     return (ExpressionList<T>)this;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninterna\\util\DefaultExpressionList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */