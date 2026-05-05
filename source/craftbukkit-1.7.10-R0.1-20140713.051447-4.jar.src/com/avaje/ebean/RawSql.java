/*     */ package com.avaje.ebean;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
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
/*     */ public final class RawSql
/*     */ {
/*     */   private final Sql sql;
/*     */   private final ColumnMapping columnMapping;
/*     */   
/*     */   protected RawSql(Sql sql, ColumnMapping columnMapping) {
/* 170 */     this.sql = sql;
/* 171 */     this.columnMapping = columnMapping;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sql getSql() {
/* 178 */     return this.sql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ColumnMapping getColumnMapping() {
/* 185 */     return this.columnMapping;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int queryHash() {
/* 192 */     return 31 * this.sql.queryHash() + this.columnMapping.queryHash();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Sql
/*     */   {
/*     */     private final boolean parsed;
/*     */ 
/*     */     
/*     */     private final String unparsedSql;
/*     */ 
/*     */     
/*     */     private final String preFrom;
/*     */ 
/*     */     
/*     */     private final String preWhere;
/*     */ 
/*     */     
/*     */     private final boolean andWhereExpr;
/*     */ 
/*     */     
/*     */     private final String preHaving;
/*     */     
/*     */     private final boolean andHavingExpr;
/*     */     
/*     */     private final String orderBy;
/*     */     
/*     */     private final int queryHashCode;
/*     */ 
/*     */     
/*     */     protected Sql(String unparsedSql) {
/* 224 */       this.queryHashCode = unparsedSql.hashCode();
/* 225 */       this.parsed = false;
/* 226 */       this.unparsedSql = unparsedSql;
/* 227 */       this.preFrom = null;
/* 228 */       this.preHaving = null;
/* 229 */       this.preWhere = null;
/* 230 */       this.andHavingExpr = false;
/* 231 */       this.andWhereExpr = false;
/* 232 */       this.orderBy = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Sql(int queryHashCode, String preFrom, String preWhere, boolean andWhereExpr, String preHaving, boolean andHavingExpr, String orderBy) {
/* 241 */       this.queryHashCode = queryHashCode;
/* 242 */       this.parsed = true;
/* 243 */       this.unparsedSql = null;
/* 244 */       this.preFrom = preFrom;
/* 245 */       this.preHaving = preHaving;
/* 246 */       this.preWhere = preWhere;
/* 247 */       this.andHavingExpr = andHavingExpr;
/* 248 */       this.andWhereExpr = andWhereExpr;
/* 249 */       this.orderBy = orderBy;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int queryHash() {
/* 256 */       return this.queryHashCode;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 260 */       if (!this.parsed) {
/* 261 */         return "unparsed[" + this.unparsedSql + "]";
/*     */       }
/* 263 */       return "select[" + this.preFrom + "] preWhere[" + this.preWhere + "] preHaving[" + this.preHaving + "] orderBy[" + this.orderBy + "]";
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isParsed() {
/* 275 */       return this.parsed;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getUnparsedSql() {
/* 282 */       return this.unparsedSql;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPreFrom() {
/* 289 */       return this.preFrom;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPreWhere() {
/* 296 */       return this.preWhere;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAndWhereExpr() {
/* 304 */       return this.andWhereExpr;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPreHaving() {
/* 311 */       return this.preHaving;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isAndHavingExpr() {
/* 319 */       return this.andHavingExpr;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getOrderBy() {
/* 326 */       return this.orderBy;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class ColumnMapping
/*     */   {
/*     */     private final LinkedHashMap<String, Column> dbColumnMap;
/*     */ 
/*     */     
/*     */     private final Map<String, String> propertyMap;
/*     */ 
/*     */     
/*     */     private final Map<String, Column> propertyColumnMap;
/*     */ 
/*     */     
/*     */     private final boolean parsed;
/*     */     
/*     */     private final boolean immutable;
/*     */     
/*     */     private final int queryHashCode;
/*     */ 
/*     */     
/*     */     protected ColumnMapping(List<Column> columns) {
/* 351 */       this.queryHashCode = 0;
/* 352 */       this.immutable = false;
/* 353 */       this.parsed = true;
/* 354 */       this.propertyMap = null;
/* 355 */       this.propertyColumnMap = null;
/* 356 */       this.dbColumnMap = new LinkedHashMap<String, Column>();
/* 357 */       for (int i = 0; i < columns.size(); i++) {
/* 358 */         Column c = columns.get(i);
/* 359 */         this.dbColumnMap.put(c.getDbColumn(), c);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ColumnMapping() {
/* 367 */       this.queryHashCode = 0;
/* 368 */       this.immutable = false;
/* 369 */       this.parsed = false;
/* 370 */       this.propertyMap = null;
/* 371 */       this.propertyColumnMap = null;
/* 372 */       this.dbColumnMap = new LinkedHashMap<String, Column>();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ColumnMapping(boolean parsed, LinkedHashMap<String, Column> dbColumnMap) {
/* 379 */       this.immutable = true;
/* 380 */       this.parsed = parsed;
/* 381 */       this.dbColumnMap = dbColumnMap;
/*     */       
/* 383 */       int hc = ColumnMapping.class.getName().hashCode();
/*     */       
/* 385 */       HashMap<String, Column> pcMap = new HashMap<String, Column>();
/* 386 */       HashMap<String, String> pMap = new HashMap<String, String>();
/*     */       
/* 388 */       for (Column c : dbColumnMap.values()) {
/* 389 */         pMap.put(c.getPropertyName(), c.getDbColumn());
/* 390 */         pcMap.put(c.getPropertyName(), c);
/*     */         
/* 392 */         hc = ((31 * hc) + c.getPropertyName() == null) ? 0 : c.getPropertyName().hashCode();
/* 393 */         hc = ((31 * hc) + c.getDbColumn() == null) ? 0 : c.getDbColumn().hashCode();
/*     */       } 
/* 395 */       this.propertyMap = Collections.unmodifiableMap(pMap);
/* 396 */       this.propertyColumnMap = Collections.unmodifiableMap(pcMap);
/* 397 */       this.queryHashCode = hc;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ColumnMapping createImmutableCopy() {
/* 408 */       for (Column c : this.dbColumnMap.values()) {
/* 409 */         c.checkMapping();
/*     */       }
/*     */       
/* 412 */       return new ColumnMapping(this.parsed, this.dbColumnMap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void columnMapping(String dbColumn, String propertyName) {
/* 417 */       if (this.immutable) {
/* 418 */         throw new IllegalStateException("Should never happen");
/*     */       }
/* 420 */       if (!this.parsed) {
/* 421 */         int pos = this.dbColumnMap.size();
/* 422 */         this.dbColumnMap.put(dbColumn, new Column(pos, dbColumn, null, propertyName));
/*     */       } else {
/* 424 */         Column column = this.dbColumnMap.get(dbColumn);
/* 425 */         if (column == null) {
/* 426 */           String msg = "DB Column [" + dbColumn + "] not found in mapping. Expecting one of [" + this.dbColumnMap.keySet() + "]";
/*     */           
/* 428 */           throw new IllegalArgumentException(msg);
/*     */         } 
/* 430 */         column.setPropertyName(propertyName);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int queryHash() {
/* 438 */       if (this.queryHashCode == 0) {
/* 439 */         throw new RuntimeException("Bug: queryHashCode == 0");
/*     */       }
/* 441 */       return this.queryHashCode;
/*     */     }
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
/*     */     public boolean isParsed() {
/* 454 */       return this.parsed;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 461 */       return this.dbColumnMap.size();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Map<String, Column> mapping() {
/* 468 */       return this.dbColumnMap;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<String, String> getMapping() {
/* 475 */       return this.propertyMap;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getIndexPosition(String property) {
/* 482 */       Column c = this.propertyColumnMap.get(property);
/* 483 */       return (c == null) ? -1 : c.getIndexPos();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Iterator<Column> getColumns() {
/* 490 */       return this.dbColumnMap.values().iterator();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static class Column
/*     */     {
/*     */       private final int indexPos;
/*     */ 
/*     */       
/*     */       private final String dbColumn;
/*     */ 
/*     */       
/*     */       private final String dbAlias;
/*     */       
/*     */       private String propertyName;
/*     */ 
/*     */       
/*     */       public Column(int indexPos, String dbColumn, String dbAlias) {
/* 509 */         this(indexPos, dbColumn, dbAlias, null);
/*     */       }
/*     */       
/*     */       private Column(int indexPos, String dbColumn, String dbAlias, String propertyName) {
/* 513 */         this.indexPos = indexPos;
/* 514 */         this.dbColumn = dbColumn;
/* 515 */         this.dbAlias = dbAlias;
/* 516 */         if (propertyName == null && dbAlias != null) {
/* 517 */           this.propertyName = dbAlias;
/*     */         } else {
/* 519 */           this.propertyName = propertyName;
/*     */         } 
/*     */       }
/*     */       
/*     */       private void checkMapping() {
/* 524 */         if (this.propertyName == null) {
/* 525 */           String msg = "No propertyName defined (Column mapping) for dbColumn [" + this.dbColumn + "]";
/* 526 */           throw new IllegalStateException(msg);
/*     */         } 
/*     */       }
/*     */       
/*     */       public String toString() {
/* 531 */         return this.dbColumn + "->" + this.propertyName;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int getIndexPos() {
/* 538 */         return this.indexPos;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getDbColumn() {
/* 545 */         return this.dbColumn;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getDbAlias() {
/* 552 */         return this.dbAlias;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getPropertyName() {
/* 559 */         return this.propertyName;
/*     */       }
/*     */       
/*     */       private void setPropertyName(String propertyName) {
/* 563 */         this.propertyName = propertyName;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\RawSql.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */