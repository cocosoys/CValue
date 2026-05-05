/*     */ package com.avaje.ebeaninternal.server.expression;
/*     */ 
/*     */ import com.avaje.ebean.ExampleExpression;
/*     */ import com.avaje.ebean.Expression;
/*     */ import com.avaje.ebean.ExpressionFactory;
/*     */ import com.avaje.ebean.ExpressionList;
/*     */ import com.avaje.ebean.Junction;
/*     */ import com.avaje.ebean.LikeType;
/*     */ import com.avaje.ebean.Query;
/*     */ import com.avaje.ebeaninternal.api.SpiExpressionFactory;
/*     */ import com.avaje.ebeaninternal.api.SpiQuery;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultExpressionFactory
/*     */   implements SpiExpressionFactory
/*     */ {
/*  22 */   private static final Object[] EMPTY_ARRAY = new Object[0];
/*     */   
/*     */   private final FilterExprPath prefix;
/*     */   
/*     */   public DefaultExpressionFactory() {
/*  27 */     this(null);
/*     */   }
/*     */   
/*     */   public DefaultExpressionFactory(FilterExprPath prefix) {
/*  31 */     this.prefix = prefix;
/*     */   }
/*     */   
/*     */   public ExpressionFactory createExpressionFactory(FilterExprPath prefix) {
/*  35 */     return (ExpressionFactory)new DefaultExpressionFactory(prefix);
/*     */   }
/*     */   
/*     */   public String getLang() {
/*  39 */     return "sql";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression eq(String propertyName, Object value) {
/*  46 */     if (value == null) {
/*  47 */       return isNull(propertyName);
/*     */     }
/*  49 */     return (Expression)new SimpleExpression(this.prefix, propertyName, SimpleExpression.Op.EQ, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression ne(String propertyName, Object value) {
/*  56 */     if (value == null) {
/*  57 */       return isNotNull(propertyName);
/*     */     }
/*  59 */     return (Expression)new SimpleExpression(this.prefix, propertyName, SimpleExpression.Op.NOT_EQ, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression ieq(String propertyName, String value) {
/*  67 */     if (value == null) {
/*  68 */       return isNull(propertyName);
/*     */     }
/*  70 */     return (Expression)new CaseInsensitiveEqualExpression(this.prefix, propertyName, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression between(String propertyName, Object value1, Object value2) {
/*  78 */     return (Expression)new BetweenExpression(this.prefix, propertyName, value1, value2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression betweenProperties(String lowProperty, String highProperty, Object value) {
/*  86 */     return (Expression)new BetweenPropertyExpression(this.prefix, lowProperty, highProperty, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression gt(String propertyName, Object value) {
/*  94 */     return (Expression)new SimpleExpression(this.prefix, propertyName, SimpleExpression.Op.GT, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression ge(String propertyName, Object value) {
/* 103 */     return (Expression)new SimpleExpression(this.prefix, propertyName, SimpleExpression.Op.GT_EQ, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression lt(String propertyName, Object value) {
/* 111 */     return (Expression)new SimpleExpression(this.prefix, propertyName, SimpleExpression.Op.LT, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression le(String propertyName, Object value) {
/* 119 */     return (Expression)new SimpleExpression(this.prefix, propertyName, SimpleExpression.Op.LT_EQ, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression isNull(String propertyName) {
/* 127 */     return (Expression)new NullExpression(this.prefix, propertyName, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression isNotNull(String propertyName) {
/* 135 */     return (Expression)new NullExpression(this.prefix, propertyName, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExampleExpression iexampleLike(Object example) {
/* 142 */     return new DefaultExampleExpression(this.prefix, example, true, LikeType.RAW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExampleExpression exampleLike(Object example) {
/* 149 */     return new DefaultExampleExpression(this.prefix, example, false, LikeType.RAW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExampleExpression exampleLike(Object example, boolean caseInsensitive, LikeType likeType) {
/* 156 */     return new DefaultExampleExpression(this.prefix, example, caseInsensitive, likeType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression like(String propertyName, String value) {
/* 164 */     return (Expression)new LikeExpression(this.prefix, propertyName, value, false, LikeType.RAW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression ilike(String propertyName, String value) {
/* 173 */     return (Expression)new LikeExpression(this.prefix, propertyName, value, true, LikeType.RAW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression startsWith(String propertyName, String value) {
/* 180 */     return (Expression)new LikeExpression(this.prefix, propertyName, value, false, LikeType.STARTS_WITH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression istartsWith(String propertyName, String value) {
/* 188 */     return (Expression)new LikeExpression(this.prefix, propertyName, value, true, LikeType.STARTS_WITH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression endsWith(String propertyName, String value) {
/* 195 */     return (Expression)new LikeExpression(this.prefix, propertyName, value, false, LikeType.ENDS_WITH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression iendsWith(String propertyName, String value) {
/* 203 */     return (Expression)new LikeExpression(this.prefix, propertyName, value, true, LikeType.ENDS_WITH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression contains(String propertyName, String value) {
/* 210 */     return (Expression)new LikeExpression(this.prefix, propertyName, value, false, LikeType.CONTAINS);
/*     */   }
/*     */   
/*     */   public Expression lucene(String propertyName, String value) {
/* 214 */     return (Expression)new LuceneExpression(this.prefix, propertyName, value, true);
/*     */   }
/*     */   
/*     */   public Expression lucene(String value) {
/* 218 */     return (Expression)new LuceneExpression(this.prefix, null, value, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression icontains(String propertyName, String value) {
/* 226 */     return (Expression)new LikeExpression(this.prefix, propertyName, value, true, LikeType.CONTAINS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression in(String propertyName, Object[] values) {
/* 233 */     return (Expression)new InExpression(this.prefix, propertyName, values);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression in(String propertyName, Query<?> subQuery) {
/* 240 */     return (Expression)new InQueryExpression(this.prefix, propertyName, (SpiQuery)subQuery);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression in(String propertyName, Collection<?> values) {
/* 247 */     return (Expression)new InExpression(this.prefix, propertyName, values);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression idEq(Object value) {
/* 254 */     return (Expression)new IdExpression(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression idIn(List<?> idList) {
/* 261 */     return (Expression)new IdInExpression(idList);
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
/*     */   public Expression allEq(Map<String, Object> propertyMap) {
/* 275 */     return (Expression)new AllEqualsExpression(this.prefix, propertyMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression raw(String raw, Object value) {
/* 286 */     return (Expression)new RawExpression(raw, new Object[] { value });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression raw(String raw, Object[] values) {
/* 297 */     return (Expression)new RawExpression(raw, values);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression raw(String raw) {
/* 304 */     return (Expression)new RawExpression(raw, EMPTY_ARRAY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression and(Expression expOne, Expression expTwo) {
/* 312 */     return (Expression)new LogicExpression.And(expOne, expTwo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression or(Expression expOne, Expression expTwo) {
/* 320 */     return (Expression)new LogicExpression.Or(expOne, expTwo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression not(Expression exp) {
/* 328 */     return (Expression)new NotExpression(exp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> Junction<T> conjunction(Query<T> query) {
/* 336 */     return new JunctionExpression.Conjunction<T>(query, query.where());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> Junction<T> disjunction(Query<T> query) {
/* 344 */     return new JunctionExpression.Disjunction<T>(query, query.where());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> Junction<T> conjunction(Query<T> query, ExpressionList<T> parent) {
/* 352 */     return new JunctionExpression.Conjunction<T>(query, parent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> Junction<T> disjunction(Query<T> query, ExpressionList<T> parent) {
/* 360 */     return new JunctionExpression.Disjunction<T>(query, parent);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\DefaultExpressionFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */