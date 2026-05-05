/*     */ package com.avaje.ebeaninternal.server.expression;
/*     */ 
/*     */ import com.avaje.ebean.Expression;
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
/*     */ 
/*     */ abstract class JunctionExpression<T>
/*     */   implements Junction<T>, SpiExpression, ExpressionList<T>
/*     */ {
/*     */   private static final long serialVersionUID = -7422204102750462676L;
/*     */   private static final String OR = " or ";
/*     */   private static final String AND = " and ";
/*     */   private final DefaultExpressionList<T> exprList;
/*     */   private final String joinType;
/*     */   
/*     */   static class Conjunction<T>
/*     */     extends JunctionExpression<T>
/*     */   {
/*     */     private static final long serialVersionUID = -645619859900030678L;
/*     */     
/*     */     Conjunction(Query<T> query, ExpressionList<T> parent) {
/*  44 */       super(" and ", query, parent);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Disjunction<T>
/*     */     extends JunctionExpression<T> {
/*     */     private static final long serialVersionUID = -8464470066692221413L;
/*     */     
/*     */     Disjunction(Query<T> query, ExpressionList<T> parent) {
/*  53 */       super(" or ", query, parent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JunctionExpression(String joinType, Query<T> query, ExpressionList<T> parent) {
/*  64 */     this.joinType = joinType;
/*  65 */     this.exprList = new DefaultExpressionList(query, parent);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/*  70 */     List<SpiExpression> list = this.exprList.internalList();
/*     */     
/*  72 */     for (int i = 0; i < list.size(); i++) {
/*  73 */       if (!((SpiExpression)list.get(i)).isLuceneResolvable(req)) {
/*  74 */         return false;
/*     */       }
/*     */     } 
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/*  82 */     boolean disjunction = " or ".equals(this.joinType);
/*  83 */     return (new JunctionExpressionLucene()).createLuceneExpr(request, this.exprList.internalList(), disjunction);
/*     */   }
/*     */ 
/*     */   
/*     */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins manyWhereJoin) {
/*  88 */     List<SpiExpression> list = this.exprList.internalList();
/*     */     
/*  90 */     for (int i = 0; i < list.size(); i++) {
/*  91 */       ((SpiExpression)list.get(i)).containsMany(desc, manyWhereJoin);
/*     */     }
/*     */   }
/*     */   
/*     */   public Junction<T> add(Expression item) {
/*  96 */     SpiExpression i = (SpiExpression)item;
/*  97 */     this.exprList.add((Expression)i);
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBindValues(SpiExpressionRequest request) {
/* 103 */     List<SpiExpression> list = this.exprList.internalList();
/*     */     
/* 105 */     for (int i = 0; i < list.size(); i++) {
/* 106 */       SpiExpression item = list.get(i);
/* 107 */       item.addBindValues(request);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSql(SpiExpressionRequest request) {
/* 113 */     List<SpiExpression> list = this.exprList.internalList();
/*     */     
/* 115 */     if (!list.isEmpty()) {
/* 116 */       request.append("(");
/*     */       
/* 118 */       for (int i = 0; i < list.size(); i++) {
/* 119 */         SpiExpression item = list.get(i);
/* 120 */         if (i > 0) {
/* 121 */           request.append(this.joinType);
/*     */         }
/* 123 */         item.addSql(request);
/*     */       } 
/*     */       
/* 126 */       request.append(") ");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int queryAutoFetchHash() {
/* 134 */     int hc = JunctionExpression.class.getName().hashCode();
/* 135 */     hc = hc * 31 + this.joinType.hashCode();
/*     */     
/* 137 */     List<SpiExpression> list = this.exprList.internalList();
/* 138 */     for (int i = 0; i < list.size(); i++) {
/* 139 */       hc = hc * 31 + ((SpiExpression)list.get(i)).queryAutoFetchHash();
/*     */     }
/*     */     
/* 142 */     return hc;
/*     */   }
/*     */   
/*     */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 146 */     int hc = JunctionExpression.class.getName().hashCode();
/* 147 */     hc = hc * 31 + this.joinType.hashCode();
/*     */     
/* 149 */     List<SpiExpression> list = this.exprList.internalList();
/* 150 */     for (int i = 0; i < list.size(); i++) {
/* 151 */       hc = hc * 31 + ((SpiExpression)list.get(i)).queryPlanHash(request);
/*     */     }
/*     */     
/* 154 */     return hc;
/*     */   }
/*     */   
/*     */   public int queryBindHash() {
/* 158 */     int hc = JunctionExpression.class.getName().hashCode();
/*     */     
/* 160 */     List<SpiExpression> list = this.exprList.internalList();
/* 161 */     for (int i = 0; i < list.size(); i++) {
/* 162 */       hc = hc * 31 + ((SpiExpression)list.get(i)).queryBindHash();
/*     */     }
/*     */     
/* 165 */     return hc;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExpressionList<T> endJunction() {
/* 170 */     return this.exprList.endJunction();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> allEq(Map<String, Object> propertyMap) {
/* 174 */     return this.exprList.allEq(propertyMap);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> and(Expression expOne, Expression expTwo) {
/* 178 */     return this.exprList.and(expOne, expTwo);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> between(String propertyName, Object value1, Object value2) {
/* 182 */     return this.exprList.between(propertyName, value1, value2);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> betweenProperties(String lowProperty, String highProperty, Object value) {
/* 186 */     return this.exprList.betweenProperties(lowProperty, highProperty, value);
/*     */   }
/*     */   
/*     */   public Junction<T> conjunction() {
/* 190 */     return this.exprList.conjunction();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> contains(String propertyName, String value) {
/* 194 */     return this.exprList.contains(propertyName, value);
/*     */   }
/*     */   
/*     */   public Junction<T> disjunction() {
/* 198 */     return this.exprList.disjunction();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> endsWith(String propertyName, String value) {
/* 202 */     return this.exprList.endsWith(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> eq(String propertyName, Object value) {
/* 206 */     return this.exprList.eq(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> exampleLike(Object example) {
/* 210 */     return this.exprList.exampleLike(example);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> filterMany(String prop) {
/* 214 */     throw new RuntimeException("filterMany not allowed on Junction expression list");
/*     */   }
/*     */   
/*     */   public FutureIds<T> findFutureIds() {
/* 218 */     return this.exprList.findFutureIds();
/*     */   }
/*     */   
/*     */   public FutureList<T> findFutureList() {
/* 222 */     return this.exprList.findFutureList();
/*     */   }
/*     */   
/*     */   public FutureRowCount<T> findFutureRowCount() {
/* 226 */     return this.exprList.findFutureRowCount();
/*     */   }
/*     */   
/*     */   public List<Object> findIds() {
/* 230 */     return this.exprList.findIds();
/*     */   }
/*     */   
/*     */   public void findVisit(QueryResultVisitor<T> visitor) {
/* 234 */     this.exprList.findVisit(visitor);
/*     */   }
/*     */   
/*     */   public QueryIterator<T> findIterate() {
/* 238 */     return this.exprList.findIterate();
/*     */   }
/*     */   
/*     */   public List<T> findList() {
/* 242 */     return this.exprList.findList();
/*     */   }
/*     */   
/*     */   public Map<?, T> findMap() {
/* 246 */     return this.exprList.findMap();
/*     */   }
/*     */   
/*     */   public <K> Map<K, T> findMap(String keyProperty, Class<K> keyType) {
/* 250 */     return this.exprList.findMap(keyProperty, keyType);
/*     */   }
/*     */   
/*     */   public PagingList<T> findPagingList(int pageSize) {
/* 254 */     return this.exprList.findPagingList(pageSize);
/*     */   }
/*     */   
/*     */   public int findRowCount() {
/* 258 */     return this.exprList.findRowCount();
/*     */   }
/*     */   
/*     */   public Set<T> findSet() {
/* 262 */     return this.exprList.findSet();
/*     */   }
/*     */   
/*     */   public T findUnique() {
/* 266 */     return (T)this.exprList.findUnique();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ge(String propertyName, Object value) {
/* 270 */     return this.exprList.ge(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> gt(String propertyName, Object value) {
/* 274 */     return this.exprList.gt(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> having() {
/* 278 */     throw new RuntimeException("having() not allowed on Junction expression list");
/*     */   }
/*     */   
/*     */   public ExpressionList<T> icontains(String propertyName, String value) {
/* 282 */     return this.exprList.icontains(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> idEq(Object value) {
/* 286 */     return this.exprList.idEq(value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> idIn(List<?> idValues) {
/* 290 */     return this.exprList.idIn(idValues);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> iendsWith(String propertyName, String value) {
/* 294 */     return this.exprList.iendsWith(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ieq(String propertyName, String value) {
/* 298 */     return this.exprList.ieq(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> iexampleLike(Object example) {
/* 302 */     return this.exprList.iexampleLike(example);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ilike(String propertyName, String value) {
/* 306 */     return this.exprList.ilike(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Collection<?> values) {
/* 310 */     return this.exprList.in(propertyName, values);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Object... values) {
/* 314 */     return this.exprList.in(propertyName, values);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> in(String propertyName, Query<?> subQuery) {
/* 318 */     return this.exprList.in(propertyName, subQuery);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> isNotNull(String propertyName) {
/* 322 */     return this.exprList.isNotNull(propertyName);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> isNull(String propertyName) {
/* 326 */     return this.exprList.isNull(propertyName);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> istartsWith(String propertyName, String value) {
/* 330 */     return this.exprList.istartsWith(propertyName, value);
/*     */   }
/*     */   
/*     */   public Query<T> join(String assocProperty, String assocProperties) {
/* 334 */     return this.exprList.join(assocProperty, assocProperties);
/*     */   }
/*     */   
/*     */   public Query<T> join(String assocProperties) {
/* 338 */     return this.exprList.join(assocProperties);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> le(String propertyName, Object value) {
/* 342 */     return this.exprList.le(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> like(String propertyName, String value) {
/* 346 */     return this.exprList.like(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> lt(String propertyName, Object value) {
/* 350 */     return this.exprList.lt(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> lucene(String propertyName, String value) {
/* 354 */     return this.exprList.lucene(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> ne(String propertyName, Object value) {
/* 358 */     return this.exprList.ne(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> not(Expression exp) {
/* 362 */     return this.exprList.not(exp);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> or(Expression expOne, Expression expTwo) {
/* 366 */     return this.exprList.or(expOne, expTwo);
/*     */   }
/*     */   
/*     */   public OrderBy<T> order() {
/* 370 */     return this.exprList.order();
/*     */   }
/*     */   
/*     */   public Query<T> order(String orderByClause) {
/* 374 */     return this.exprList.order(orderByClause);
/*     */   }
/*     */   
/*     */   public OrderBy<T> orderBy() {
/* 378 */     return this.exprList.orderBy();
/*     */   }
/*     */   
/*     */   public Query<T> orderBy(String orderBy) {
/* 382 */     return this.exprList.orderBy(orderBy);
/*     */   }
/*     */   
/*     */   public Query<T> query() {
/* 386 */     return this.exprList.query();
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw, Object value) {
/* 390 */     return this.exprList.raw(raw, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw, Object[] values) {
/* 394 */     return this.exprList.raw(raw, values);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> raw(String raw) {
/* 398 */     return this.exprList.raw(raw);
/*     */   }
/*     */   
/*     */   public Query<T> select(String properties) {
/* 402 */     return this.exprList.select(properties);
/*     */   }
/*     */   
/*     */   public Query<T> setBackgroundFetchAfter(int backgroundFetchAfter) {
/* 406 */     return this.exprList.setBackgroundFetchAfter(backgroundFetchAfter);
/*     */   }
/*     */   
/*     */   public Query<T> setFirstRow(int firstRow) {
/* 410 */     return this.exprList.setFirstRow(firstRow);
/*     */   }
/*     */   
/*     */   public Query<T> setListener(QueryListener<T> queryListener) {
/* 414 */     return this.exprList.setListener(queryListener);
/*     */   }
/*     */   
/*     */   public Query<T> setMapKey(String mapKey) {
/* 418 */     return this.exprList.setMapKey(mapKey);
/*     */   }
/*     */   
/*     */   public Query<T> setMaxRows(int maxRows) {
/* 422 */     return this.exprList.setMaxRows(maxRows);
/*     */   }
/*     */   
/*     */   public Query<T> setOrderBy(String orderBy) {
/* 426 */     return this.exprList.setOrderBy(orderBy);
/*     */   }
/*     */   
/*     */   public Query<T> setUseCache(boolean useCache) {
/* 430 */     return this.exprList.setUseCache(useCache);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> startsWith(String propertyName, String value) {
/* 434 */     return this.exprList.startsWith(propertyName, value);
/*     */   }
/*     */   
/*     */   public ExpressionList<T> where() {
/* 438 */     return this.exprList.where();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\JunctionExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */