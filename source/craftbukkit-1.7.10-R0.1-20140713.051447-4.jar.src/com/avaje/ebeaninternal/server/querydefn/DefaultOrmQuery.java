/*      */ package com.avaje.ebeaninternal.server.querydefn;
/*      */ 
/*      */ import com.avaje.ebean.EbeanServer;
/*      */ import com.avaje.ebean.Expression;
/*      */ import com.avaje.ebean.ExpressionFactory;
/*      */ import com.avaje.ebean.ExpressionList;
/*      */ import com.avaje.ebean.FetchConfig;
/*      */ import com.avaje.ebean.FutureIds;
/*      */ import com.avaje.ebean.FutureList;
/*      */ import com.avaje.ebean.FutureRowCount;
/*      */ import com.avaje.ebean.JoinConfig;
/*      */ import com.avaje.ebean.OrderBy;
/*      */ import com.avaje.ebean.PagingList;
/*      */ import com.avaje.ebean.Query;
/*      */ import com.avaje.ebean.QueryIterator;
/*      */ import com.avaje.ebean.QueryListener;
/*      */ import com.avaje.ebean.QueryResultVisitor;
/*      */ import com.avaje.ebean.RawSql;
/*      */ import com.avaje.ebean.bean.BeanCollectionTouched;
/*      */ import com.avaje.ebean.bean.CallStack;
/*      */ import com.avaje.ebean.bean.EntityBean;
/*      */ import com.avaje.ebean.bean.ObjectGraphNode;
/*      */ import com.avaje.ebean.bean.ObjectGraphOrigin;
/*      */ import com.avaje.ebean.bean.PersistenceContext;
/*      */ import com.avaje.ebean.event.BeanQueryRequest;
/*      */ import com.avaje.ebean.meta.MetaAutoFetchStatistic;
/*      */ import com.avaje.ebeaninternal.api.BindParams;
/*      */ import com.avaje.ebeaninternal.api.ManyWhereJoins;
/*      */ import com.avaje.ebeaninternal.api.SpiExpressionList;
/*      */ import com.avaje.ebeaninternal.api.SpiQuery;
/*      */ import com.avaje.ebeaninternal.server.autofetch.AutoFetchManager;
/*      */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*      */ import com.avaje.ebeaninternal.server.deploy.DRawSqlSelect;
/*      */ import com.avaje.ebeaninternal.server.deploy.DeployNamedQuery;
/*      */ import com.avaje.ebeaninternal.server.deploy.TableJoin;
/*      */ import com.avaje.ebeaninternal.server.query.CancelableQuery;
/*      */ import com.avaje.ebeaninternal.util.DefaultExpressionList;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import javax.persistence.PersistenceException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DefaultOrmQuery<T>
/*      */   implements SpiQuery<T>
/*      */ {
/*      */   private static final long serialVersionUID = 6838006264714672460L;
/*      */   private final Class<T> beanType;
/*      */   private final transient EbeanServer server;
/*      */   private transient BeanCollectionTouched beanCollectionTouched;
/*      */   private final transient ExpressionFactory expressionFactory;
/*      */   private transient ArrayList<EntityBean> contextAdditions;
/*      */   private transient QueryListener<T> queryListener;
/*      */   private transient TableJoin includeTableJoin;
/*      */   private transient AutoFetchManager autoFetchManager;
/*      */   private transient BeanDescriptor<?> beanDescriptor;
/*      */   private boolean cancelled;
/*      */   private transient CancelableQuery cancelableQuery;
/*      */   private String name;
/*      */   private Query.UseIndex useIndex;
/*      */   private Query.Type type;
/*   94 */   private SpiQuery.Mode mode = SpiQuery.Mode.NORMAL;
/*      */ 
/*      */ 
/*      */   
/*      */   private OrmQueryDetail detail;
/*      */ 
/*      */ 
/*      */   
/*      */   private int maxRows;
/*      */ 
/*      */ 
/*      */   
/*      */   private int firstRow;
/*      */ 
/*      */   
/*      */   private String rawWhereClause;
/*      */ 
/*      */   
/*      */   private OrderBy<T> orderBy;
/*      */ 
/*      */   
/*      */   private String loadMode;
/*      */ 
/*      */   
/*      */   private String loadDescription;
/*      */ 
/*      */   
/*      */   private String generatedSql;
/*      */ 
/*      */   
/*      */   private String query;
/*      */ 
/*      */   
/*      */   private String additionalWhere;
/*      */ 
/*      */   
/*      */   private String additionalHaving;
/*      */ 
/*      */   
/*      */   private String lazyLoadProperty;
/*      */ 
/*      */   
/*      */   private String lazyLoadManyPath;
/*      */ 
/*      */   
/*      */   private Boolean vanillaMode;
/*      */ 
/*      */   
/*      */   private boolean distinct;
/*      */ 
/*      */   
/*      */   private boolean futureFetch;
/*      */ 
/*      */   
/*      */   private boolean sharedInstance;
/*      */ 
/*      */   
/*      */   private List<Object> partialIds;
/*      */ 
/*      */   
/*      */   private int backgroundFetchAfter;
/*      */ 
/*      */   
/*  157 */   private int timeout = -1;
/*      */ 
/*      */ 
/*      */   
/*      */   private String mapKey;
/*      */ 
/*      */   
/*      */   private Object id;
/*      */ 
/*      */   
/*      */   private BindParams bindParams;
/*      */ 
/*      */   
/*      */   private DefaultExpressionList<T> whereExpressions;
/*      */ 
/*      */   
/*      */   private DefaultExpressionList<T> havingExpressions;
/*      */ 
/*      */   
/*      */   private int bufferFetchSizeHint;
/*      */ 
/*      */   
/*      */   private boolean usageProfiling = true;
/*      */ 
/*      */   
/*      */   private boolean loadBeanCache;
/*      */ 
/*      */   
/*      */   private Boolean useBeanCache;
/*      */ 
/*      */   
/*      */   private Boolean useQueryCache;
/*      */ 
/*      */   
/*      */   private Boolean readOnly;
/*      */ 
/*      */   
/*      */   private boolean sqlSelect;
/*      */ 
/*      */   
/*      */   private Boolean autoFetch;
/*      */ 
/*      */   
/*      */   private boolean autoFetchTuned;
/*      */ 
/*      */   
/*      */   private ObjectGraphNode parentNode;
/*      */ 
/*      */   
/*      */   private int queryPlanHash;
/*      */ 
/*      */   
/*      */   private transient PersistenceContext persistenceContext;
/*      */ 
/*      */   
/*      */   private ManyWhereJoins manyWhereJoins;
/*      */ 
/*      */   
/*      */   private RawSql rawSql;
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery(Class<T> beanType, EbeanServer server, ExpressionFactory expressionFactory, String query) {
/*  220 */     this.beanType = beanType;
/*  221 */     this.server = server;
/*  222 */     this.expressionFactory = expressionFactory;
/*  223 */     this.detail = new OrmQueryDetail();
/*  224 */     this.name = "";
/*  225 */     if (query != null) {
/*  226 */       setQuery(query);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery(Class<T> beanType, EbeanServer server, ExpressionFactory expressionFactory, DeployNamedQuery namedQuery) throws PersistenceException {
/*  236 */     this.beanType = beanType;
/*  237 */     this.server = server;
/*  238 */     this.expressionFactory = expressionFactory;
/*  239 */     this.detail = new OrmQueryDetail();
/*  240 */     if (namedQuery == null) {
/*  241 */       this.name = "";
/*      */     } else {
/*  243 */       this.name = namedQuery.getName();
/*  244 */       this.sqlSelect = namedQuery.isSqlSelect();
/*  245 */       if (this.sqlSelect) {
/*      */         
/*  247 */         DRawSqlSelect sqlSelect = namedQuery.getSqlSelect();
/*  248 */         this.additionalWhere = sqlSelect.getWhereClause();
/*  249 */         this.additionalHaving = sqlSelect.getHavingClause();
/*  250 */       } else if (namedQuery.isRawSql()) {
/*  251 */         this.rawSql = namedQuery.getRawSql();
/*      */       }
/*      */       else {
/*      */         
/*  255 */         setQuery(namedQuery.getQuery());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeanDescriptor(BeanDescriptor<?> beanDescriptor) {
/*  264 */     this.beanDescriptor = beanDescriptor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectAllForLazyLoadProperty() {
/*  272 */     if (this.lazyLoadProperty != null && 
/*  273 */       !this.detail.containsProperty(this.lazyLoadProperty)) {
/*  274 */       this.detail.select("*");
/*  275 */       return true;
/*      */     } 
/*      */     
/*  278 */     return false;
/*      */   }
/*      */   
/*      */   public RawSql getRawSql() {
/*  282 */     return this.rawSql;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setRawSql(RawSql rawSql) {
/*  286 */     this.rawSql = rawSql;
/*  287 */     return this;
/*      */   }
/*      */   
/*      */   public String getLazyLoadProperty() {
/*  291 */     return this.lazyLoadProperty;
/*      */   }
/*      */   
/*      */   public void setLazyLoadProperty(String lazyLoadProperty) {
/*  295 */     this.lazyLoadProperty = lazyLoadProperty;
/*      */   }
/*      */   
/*      */   public String getLazyLoadManyPath() {
/*  299 */     return this.lazyLoadManyPath;
/*      */   }
/*      */   
/*      */   public ExpressionFactory getExpressionFactory() {
/*  303 */     return this.expressionFactory;
/*      */   }
/*      */   
/*      */   public void setParentState(int parentState) {
/*  307 */     if (parentState == 3) {
/*  308 */       setSharedInstance();
/*  309 */     } else if (parentState == 2) {
/*  310 */       setReadOnly(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public MetaAutoFetchStatistic getMetaAutoFetchStatistic() {
/*  315 */     if (this.parentNode != null && this.server != null) {
/*  316 */       ObjectGraphOrigin origin = this.parentNode.getOriginQueryPoint();
/*  317 */       return (MetaAutoFetchStatistic)this.server.find(MetaAutoFetchStatistic.class, origin.getKey());
/*      */     } 
/*  319 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean initManyWhereJoins() {
/*  326 */     this.manyWhereJoins = new ManyWhereJoins();
/*  327 */     if (this.whereExpressions != null) {
/*  328 */       this.whereExpressions.containsMany(this.beanDescriptor, this.manyWhereJoins);
/*      */     }
/*  330 */     return !this.manyWhereJoins.isEmpty();
/*      */   }
/*      */   
/*      */   public ManyWhereJoins getManyWhereJoins() {
/*  334 */     return this.manyWhereJoins;
/*      */   }
/*      */   
/*      */   public List<OrmQueryProperties> removeQueryJoins() {
/*  338 */     List<OrmQueryProperties> queryJoins = this.detail.removeSecondaryQueries();
/*  339 */     if (queryJoins != null && 
/*  340 */       this.orderBy != null)
/*      */     {
/*      */       
/*  343 */       for (int i = 0; i < queryJoins.size(); i++) {
/*  344 */         OrmQueryProperties joinPath = queryJoins.get(i);
/*      */ 
/*      */ 
/*      */         
/*  348 */         List<OrderBy.Property> properties = this.orderBy.getProperties();
/*  349 */         Iterator<OrderBy.Property> it = properties.iterator();
/*  350 */         while (it.hasNext()) {
/*  351 */           OrderBy.Property property = it.next();
/*  352 */           if (property.getProperty().startsWith(joinPath.getPath())) {
/*      */ 
/*      */             
/*  355 */             it.remove();
/*  356 */             joinPath.addSecJoinOrderProperty(property);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  362 */     return queryJoins;
/*      */   }
/*      */   
/*      */   public List<OrmQueryProperties> removeLazyJoins() {
/*  366 */     return this.detail.removeSecondaryLazyQueries();
/*      */   }
/*      */   
/*      */   public void setLazyLoadManyPath(String lazyLoadManyPath) {
/*  370 */     this.lazyLoadManyPath = lazyLoadManyPath;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void convertManyFetchJoinsToQueryJoins(boolean allowOne, int queryBatch) {
/*  377 */     this.detail.convertManyFetchJoinsToQueryJoins(this.beanDescriptor, this.lazyLoadManyPath, allowOne, queryBatch);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSelectId() {
/*  385 */     this.detail.clear();
/*      */     
/*  387 */     select(this.beanDescriptor.getIdBinder().getIdProperty());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery<T> copy() {
/*  399 */     DefaultOrmQuery<T> copy = new DefaultOrmQuery(this.beanType, this.server, this.expressionFactory, (String)null);
/*  400 */     copy.name = this.name;
/*  401 */     copy.includeTableJoin = this.includeTableJoin;
/*  402 */     copy.autoFetchManager = this.autoFetchManager;
/*      */     
/*  404 */     copy.query = this.query;
/*  405 */     copy.additionalWhere = this.additionalWhere;
/*  406 */     copy.additionalHaving = this.additionalHaving;
/*  407 */     copy.distinct = this.distinct;
/*  408 */     copy.backgroundFetchAfter = this.backgroundFetchAfter;
/*  409 */     copy.timeout = this.timeout;
/*  410 */     copy.mapKey = this.mapKey;
/*  411 */     copy.id = this.id;
/*  412 */     copy.vanillaMode = this.vanillaMode;
/*  413 */     copy.loadBeanCache = this.loadBeanCache;
/*  414 */     copy.useBeanCache = this.useBeanCache;
/*  415 */     copy.useQueryCache = this.useQueryCache;
/*  416 */     copy.readOnly = this.readOnly;
/*  417 */     copy.sqlSelect = this.sqlSelect;
/*  418 */     if (this.detail != null) {
/*  419 */       copy.detail = this.detail.copy();
/*      */     }
/*      */     
/*  422 */     copy.firstRow = this.firstRow;
/*  423 */     copy.maxRows = this.maxRows;
/*  424 */     copy.rawWhereClause = this.rawWhereClause;
/*  425 */     if (this.orderBy != null) {
/*  426 */       copy.orderBy = this.orderBy.copy();
/*      */     }
/*  428 */     if (this.bindParams != null) {
/*  429 */       copy.bindParams = this.bindParams.copy();
/*      */     }
/*  431 */     if (this.whereExpressions != null) {
/*  432 */       copy.whereExpressions = this.whereExpressions.copy((Query)copy);
/*      */     }
/*  434 */     if (this.havingExpressions != null) {
/*  435 */       copy.havingExpressions = this.havingExpressions.copy((Query)copy);
/*      */     }
/*  437 */     copy.usageProfiling = this.usageProfiling;
/*  438 */     copy.autoFetch = this.autoFetch;
/*  439 */     copy.parentNode = this.parentNode;
/*      */     
/*  441 */     return copy;
/*      */   }
/*      */   
/*      */   public Query.Type getType() {
/*  445 */     return this.type;
/*      */   }
/*      */   
/*      */   public void setType(Query.Type type) {
/*  449 */     this.type = type;
/*      */   }
/*      */   
/*      */   public Query.UseIndex getUseIndex() {
/*  453 */     return this.useIndex;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setUseIndex(Query.UseIndex useIndex) {
/*  457 */     this.useIndex = useIndex;
/*  458 */     return this;
/*      */   }
/*      */   
/*      */   public String getLoadDescription() {
/*  462 */     return this.loadDescription;
/*      */   }
/*      */   
/*      */   public String getLoadMode() {
/*  466 */     return this.loadMode;
/*      */   }
/*      */   
/*      */   public void setLoadDescription(String loadMode, String loadDescription) {
/*  470 */     this.loadMode = loadMode;
/*  471 */     this.loadDescription = loadDescription;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PersistenceContext getPersistenceContext() {
/*  482 */     return this.persistenceContext;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersistenceContext(PersistenceContext persistenceContext) {
/*  493 */     this.persistenceContext = persistenceContext;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDetailEmpty() {
/*  500 */     return this.detail.isEmpty();
/*      */   }
/*      */   
/*      */   public boolean isAutofetchTuned() {
/*  504 */     return this.autoFetchTuned;
/*      */   }
/*      */   
/*      */   public void setAutoFetchTuned(boolean autoFetchTuned) {
/*  508 */     this.autoFetchTuned = autoFetchTuned;
/*      */   }
/*      */   
/*      */   public Boolean isAutofetch() {
/*  512 */     return this.sqlSelect ? Boolean.FALSE : this.autoFetch;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setAutoFetch(boolean autoFetch) {
/*  516 */     return setAutofetch(autoFetch);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setAutofetch(boolean autoFetch) {
/*  520 */     this.autoFetch = Boolean.valueOf(autoFetch);
/*  521 */     return this;
/*      */   }
/*      */   
/*      */   public AutoFetchManager getAutoFetchManager() {
/*  525 */     return this.autoFetchManager;
/*      */   }
/*      */   
/*      */   public void setAutoFetchManager(AutoFetchManager autoFetchManager) {
/*  529 */     this.autoFetchManager = autoFetchManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deriveSharedInstance() {
/*  536 */     if (!this.sharedInstance && (
/*  537 */       Boolean.TRUE.equals(this.useQueryCache) || (Boolean.TRUE.equals(this.readOnly) && (Boolean.TRUE.equals(this.useBeanCache) || Boolean.TRUE.equals(Boolean.valueOf(this.loadBeanCache))))))
/*      */     {
/*      */ 
/*      */       
/*  541 */       this.sharedInstance = true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSharedInstance() {
/*  547 */     return this.sharedInstance;
/*      */   }
/*      */   
/*      */   public void setSharedInstance() {
/*  551 */     this.sharedInstance = true;
/*      */   }
/*      */   
/*      */   public SpiQuery.Mode getMode() {
/*  555 */     return this.mode;
/*      */   }
/*      */   
/*      */   public void setMode(SpiQuery.Mode mode) {
/*  559 */     this.mode = mode;
/*      */   }
/*      */   
/*      */   public boolean isUsageProfiling() {
/*  563 */     return this.usageProfiling;
/*      */   }
/*      */   
/*      */   public void setUsageProfiling(boolean usageProfiling) {
/*  567 */     this.usageProfiling = usageProfiling;
/*      */   }
/*      */   
/*      */   public void setParentNode(ObjectGraphNode parentNode) {
/*  571 */     this.parentNode = parentNode;
/*      */   }
/*      */   
/*      */   public ObjectGraphNode getParentNode() {
/*  575 */     return this.parentNode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ObjectGraphNode setOrigin(CallStack callStack) {
/*  582 */     ObjectGraphOrigin o = new ObjectGraphOrigin(calculateOriginQueryHash(), callStack, this.beanType.getName());
/*  583 */     this.parentNode = new ObjectGraphNode(o, null);
/*  584 */     return this.parentNode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int calculateOriginQueryHash() {
/*  599 */     int hc = this.beanType.getName().hashCode();
/*  600 */     hc = hc * 31 + ((this.type == null) ? 0 : this.type.ordinal());
/*  601 */     return hc;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int calculateHash(BeanQueryRequest<?> request) {
/*  614 */     int hc = this.beanType.getName().hashCode();
/*      */     
/*  616 */     hc = hc * 31 + ((this.type == null) ? 0 : this.type.ordinal());
/*  617 */     hc = hc * 31 + ((this.useIndex == null) ? 0 : this.useIndex.hashCode());
/*      */     
/*  619 */     hc = hc * 31 + ((this.rawSql == null) ? 0 : this.rawSql.queryHash());
/*      */     
/*  621 */     hc = hc * 31 + (this.autoFetchTuned ? 31 : 0);
/*  622 */     hc = hc * 31 + (this.distinct ? 31 : 0);
/*  623 */     hc = hc * 31 + ((this.query == null) ? 0 : this.query.hashCode());
/*  624 */     hc = hc * 31 + this.detail.queryPlanHash(request);
/*      */     
/*  626 */     hc = hc * 31 + ((this.firstRow == 0) ? 0 : this.firstRow);
/*  627 */     hc = hc * 31 + ((this.maxRows == 0) ? 0 : this.maxRows);
/*  628 */     hc = hc * 31 + ((this.orderBy == null) ? 0 : this.orderBy.hash());
/*  629 */     hc = hc * 31 + ((this.rawWhereClause == null) ? 0 : this.rawWhereClause.hashCode());
/*      */     
/*  631 */     hc = hc * 31 + ((this.additionalWhere == null) ? 0 : this.additionalWhere.hashCode());
/*  632 */     hc = hc * 31 + ((this.additionalHaving == null) ? 0 : this.additionalHaving.hashCode());
/*  633 */     hc = hc * 31 + ((this.mapKey == null) ? 0 : this.mapKey.hashCode());
/*  634 */     hc = hc * 31 + ((this.id == null) ? 0 : 1);
/*      */     
/*  636 */     if (this.bindParams != null) {
/*  637 */       hc = hc * 31 + this.bindParams.getQueryPlanHash();
/*      */     }
/*      */     
/*  640 */     if (request == null) {
/*      */       
/*  642 */       hc = hc * 31 + ((this.whereExpressions == null) ? 0 : this.whereExpressions.queryAutoFetchHash());
/*  643 */       hc = hc * 31 + ((this.havingExpressions == null) ? 0 : this.havingExpressions.queryAutoFetchHash());
/*      */     }
/*      */     else {
/*      */       
/*  647 */       hc = hc * 31 + ((this.whereExpressions == null) ? 0 : this.whereExpressions.queryPlanHash(request));
/*  648 */       hc = hc * 31 + ((this.havingExpressions == null) ? 0 : this.havingExpressions.queryPlanHash(request));
/*      */     } 
/*      */     
/*  651 */     return hc;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int queryAutofetchHash() {
/*  660 */     return calculateHash(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int queryPlanHash(BeanQueryRequest<?> request) {
/*  675 */     this.queryPlanHash = calculateHash(request);
/*  676 */     return this.queryPlanHash;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int queryBindHash() {
/*  686 */     int hc = (this.id == null) ? 0 : this.id.hashCode();
/*  687 */     hc = hc * 31 + ((this.whereExpressions == null) ? 0 : this.whereExpressions.queryBindHash());
/*  688 */     hc = hc * 31 + ((this.havingExpressions == null) ? 0 : this.havingExpressions.queryBindHash());
/*  689 */     hc = hc * 31 + ((this.bindParams == null) ? 0 : this.bindParams.queryBindHash());
/*  690 */     hc = hc * 31 + ((this.contextAdditions == null) ? 0 : this.contextAdditions.hashCode());
/*      */     
/*  692 */     return hc;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int queryHash() {
/*  705 */     int hc = this.queryPlanHash;
/*  706 */     hc = hc * 31 + queryBindHash();
/*  707 */     return hc;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  714 */     return this.name;
/*      */   }
/*      */   
/*      */   public boolean isSqlSelect() {
/*  718 */     return this.sqlSelect;
/*      */   }
/*      */   
/*      */   public boolean isRawSql() {
/*  722 */     return (this.rawSql != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAdditionalWhere() {
/*  729 */     return this.additionalWhere;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTimeout() {
/*  736 */     return this.timeout;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getAdditionalHaving() {
/*  743 */     return this.additionalHaving;
/*      */   }
/*      */   
/*      */   public boolean hasMaxRowsOrFirstRow() {
/*  747 */     return (this.maxRows > 0 || this.firstRow > 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isVanillaMode(boolean defaultVanillaMode) {
/*  752 */     if (this.vanillaMode != null) {
/*  753 */       return this.vanillaMode.booleanValue();
/*      */     }
/*  755 */     return defaultVanillaMode;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setVanillaMode(boolean vanillaMode) {
/*  759 */     this.vanillaMode = Boolean.valueOf(vanillaMode);
/*  760 */     return this;
/*      */   }
/*      */   
/*      */   public Boolean isReadOnly() {
/*  764 */     return this.readOnly;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setReadOnly(boolean readOnly) {
/*  768 */     this.readOnly = Boolean.valueOf(readOnly);
/*  769 */     return this;
/*      */   }
/*      */   
/*      */   public Boolean isUseBeanCache() {
/*  773 */     return this.useBeanCache;
/*      */   }
/*      */   
/*      */   public boolean isUseQueryCache() {
/*  777 */     return Boolean.TRUE.equals(this.useQueryCache);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setUseCache(boolean useBeanCache) {
/*  781 */     this.useBeanCache = Boolean.valueOf(useBeanCache);
/*  782 */     return this;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setUseQueryCache(boolean useQueryCache) {
/*  786 */     this.useQueryCache = Boolean.valueOf(useQueryCache);
/*  787 */     return this;
/*      */   }
/*      */   
/*      */   public boolean isLoadBeanCache() {
/*  791 */     return this.loadBeanCache;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setLoadBeanCache(boolean loadBeanCache) {
/*  795 */     this.loadBeanCache = loadBeanCache;
/*  796 */     return this;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setTimeout(int secs) {
/*  800 */     this.timeout = secs;
/*  801 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery<T> setQuery(String queryString) throws PersistenceException {
/*  806 */     this.query = queryString;
/*      */     
/*  808 */     OrmQueryDetailParser parser = new OrmQueryDetailParser(queryString);
/*  809 */     parser.parse();
/*  810 */     parser.assign(this);
/*      */     
/*  812 */     return this;
/*      */   }
/*      */   
/*      */   protected void setOrmQueryDetail(OrmQueryDetail detail) {
/*  816 */     this.detail = detail;
/*      */   }
/*      */   protected void setRawWhereClause(String rawWhereClause) {
/*  819 */     this.rawWhereClause = rawWhereClause;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setProperties(String columns) {
/*  823 */     return select(columns);
/*      */   }
/*      */   
/*      */   public void setDefaultSelectClause() {
/*  827 */     this.detail.setDefaultSelectClause(this.beanDescriptor);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> select(String columns) {
/*  831 */     this.detail.select(columns);
/*  832 */     return this;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> join(String property) {
/*  836 */     return join(property, (String)null, (JoinConfig)null);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> join(String property, JoinConfig joinConfig) {
/*  840 */     return join(property, (String)null, joinConfig);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> join(String property, String columns) {
/*  844 */     return join(property, columns, (JoinConfig)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery<T> join(String property, String columns, JoinConfig joinConfig) {
/*      */     FetchConfig c;
/*  850 */     if (joinConfig == null) {
/*  851 */       c = null;
/*      */     } else {
/*  853 */       c = new FetchConfig();
/*  854 */       c.lazy(joinConfig.getLazyBatchSize());
/*  855 */       if (joinConfig.isQueryAll()) {
/*  856 */         c.query(joinConfig.getQueryBatchSize());
/*      */       } else {
/*  858 */         c.queryFirst(joinConfig.getQueryBatchSize());
/*      */       } 
/*      */     } 
/*      */     
/*  862 */     this.detail.addFetch(property, columns, c);
/*  863 */     return this;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> fetch(String property) {
/*  867 */     return fetch(property, (String)null, (FetchConfig)null);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> fetch(String property, FetchConfig joinConfig) {
/*  871 */     return fetch(property, (String)null, joinConfig);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> fetch(String property, String columns) {
/*  875 */     return fetch(property, columns, (FetchConfig)null);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> fetch(String property, String columns, FetchConfig config) {
/*  879 */     this.detail.addFetch(property, columns, config);
/*  880 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<Object> findIds() {
/*  887 */     return this.server.findIds((Query)this, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int findRowCount() {
/*  894 */     return this.server.findRowCount((Query)this, null);
/*      */   }
/*      */   
/*      */   public void findVisit(QueryResultVisitor<T> visitor) {
/*  898 */     this.server.findVisit((Query)this, visitor, null);
/*      */   }
/*      */   
/*      */   public QueryIterator<T> findIterate() {
/*  902 */     return this.server.findIterate((Query)this, null);
/*      */   }
/*      */   
/*      */   public List<T> findList() {
/*  906 */     return this.server.findList((Query)this, null);
/*      */   }
/*      */   
/*      */   public Set<T> findSet() {
/*  910 */     return this.server.findSet((Query)this, null);
/*      */   }
/*      */   
/*      */   public Map<?, T> findMap() {
/*  914 */     return this.server.findMap((Query)this, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public <K> Map<K, T> findMap(String keyProperty, Class<K> keyType) {
/*  919 */     setMapKey(keyProperty);
/*  920 */     return (Map)findMap();
/*      */   }
/*      */   
/*      */   public T findUnique() {
/*  924 */     return (T)this.server.findUnique((Query)this, null);
/*      */   }
/*      */   
/*      */   public FutureIds<T> findFutureIds() {
/*  928 */     return this.server.findFutureIds((Query)this, null);
/*      */   }
/*      */   
/*      */   public FutureList<T> findFutureList() {
/*  932 */     return this.server.findFutureList((Query)this, null);
/*      */   }
/*      */   
/*      */   public FutureRowCount<T> findFutureRowCount() {
/*  936 */     return this.server.findFutureRowCount((Query)this, null);
/*      */   }
/*      */   
/*      */   public PagingList<T> findPagingList(int pageSize) {
/*  940 */     return this.server.findPagingList((Query)this, null, pageSize);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery<T> setParameter(int position, Object value) {
/*  949 */     if (this.bindParams == null) {
/*  950 */       this.bindParams = new BindParams();
/*      */     }
/*  952 */     this.bindParams.setParameter(position, value);
/*  953 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery<T> setParameter(String name, Object value) {
/*  961 */     if (this.bindParams == null) {
/*  962 */       this.bindParams = new BindParams();
/*      */     }
/*  964 */     this.bindParams.setParameter(name, value);
/*  965 */     return this;
/*      */   }
/*      */   
/*      */   public OrderBy<T> getOrderBy() {
/*  969 */     return this.orderBy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getRawWhereClause() {
/*  976 */     return this.rawWhereClause;
/*      */   }
/*      */   
/*      */   public OrderBy<T> orderBy() {
/*  980 */     return order();
/*      */   }
/*      */   
/*      */   public OrderBy<T> order() {
/*  984 */     if (this.orderBy == null) {
/*  985 */       this.orderBy = new OrderBy((Query)this, null);
/*      */     }
/*  987 */     return this.orderBy;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setOrderBy(String orderByClause) {
/*  991 */     return order(orderByClause);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> orderBy(String orderByClause) {
/*  995 */     return order(orderByClause);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> order(String orderByClause) {
/*  999 */     if (orderByClause == null || orderByClause.trim().length() == 0) {
/* 1000 */       this.orderBy = null;
/*      */     } else {
/* 1002 */       this.orderBy = new OrderBy((Query)this, orderByClause);
/*      */     } 
/* 1004 */     return this;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setOrderBy(OrderBy<T> orderBy) {
/* 1008 */     return setOrder(orderBy);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setOrder(OrderBy<T> orderBy) {
/* 1012 */     this.orderBy = orderBy;
/* 1013 */     if (orderBy != null) {
/* 1014 */       orderBy.setQuery((Query)this);
/*      */     }
/* 1016 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDistinct() {
/* 1024 */     return this.distinct;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery<T> setDistinct(boolean isDistinct) {
/* 1031 */     this.distinct = isDistinct;
/* 1032 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public QueryListener<T> getListener() {
/* 1039 */     return this.queryListener;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultOrmQuery<T> setListener(QueryListener<T> queryListener) {
/* 1051 */     this.queryListener = queryListener;
/* 1052 */     return this;
/*      */   }
/*      */   
/*      */   public Class<T> getBeanType() {
/* 1056 */     return this.beanType;
/*      */   }
/*      */   
/*      */   public void setDetail(OrmQueryDetail detail) {
/* 1060 */     this.detail = detail;
/*      */   }
/*      */   
/*      */   public boolean tuneFetchProperties(OrmQueryDetail tunedDetail) {
/* 1064 */     return this.detail.tuneFetchProperties(tunedDetail);
/*      */   }
/*      */   
/*      */   public OrmQueryDetail getDetail() {
/* 1068 */     return this.detail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ArrayList<EntityBean> getContextAdditions() {
/* 1076 */     return this.contextAdditions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void contextAdd(EntityBean bean) {
/* 1086 */     if (this.contextAdditions == null) {
/* 1087 */       this.contextAdditions = new ArrayList<EntityBean>();
/*      */     }
/* 1089 */     this.contextAdditions.add(bean);
/*      */   }
/*      */   
/*      */   public String toString() {
/* 1093 */     return "Query [" + this.whereExpressions + "]";
/*      */   }
/*      */   
/*      */   public TableJoin getIncludeTableJoin() {
/* 1097 */     return this.includeTableJoin;
/*      */   }
/*      */   
/*      */   public void setIncludeTableJoin(TableJoin includeTableJoin) {
/* 1101 */     this.includeTableJoin = includeTableJoin;
/*      */   }
/*      */   
/*      */   public int getFirstRow() {
/* 1105 */     return this.firstRow;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setFirstRow(int firstRow) {
/* 1109 */     this.firstRow = firstRow;
/* 1110 */     return this;
/*      */   }
/*      */   
/*      */   public int getMaxRows() {
/* 1114 */     return this.maxRows;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setMaxRows(int maxRows) {
/* 1118 */     this.maxRows = maxRows;
/* 1119 */     return this;
/*      */   }
/*      */   
/*      */   public String getMapKey() {
/* 1123 */     return this.mapKey;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setMapKey(String mapKey) {
/* 1127 */     this.mapKey = mapKey;
/* 1128 */     return this;
/*      */   }
/*      */   
/*      */   public int getBackgroundFetchAfter() {
/* 1132 */     return this.backgroundFetchAfter;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setBackgroundFetchAfter(int backgroundFetchAfter) {
/* 1136 */     this.backgroundFetchAfter = backgroundFetchAfter;
/* 1137 */     return this;
/*      */   }
/*      */   
/*      */   public Object getId() {
/* 1141 */     return this.id;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> setId(Object id) {
/* 1145 */     this.id = id;
/* 1146 */     return this;
/*      */   }
/*      */   
/*      */   public BindParams getBindParams() {
/* 1150 */     return this.bindParams;
/*      */   }
/*      */   
/*      */   public String getQuery() {
/* 1154 */     return this.query;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> addWhere(String addToWhereClause) {
/* 1158 */     return where(addToWhereClause);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> addWhere(Expression expression) {
/* 1162 */     return where(expression);
/*      */   }
/*      */   
/*      */   public ExpressionList<T> addWhere() {
/* 1166 */     return where();
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> where(String addToWhereClause) {
/* 1170 */     if (this.additionalWhere == null) {
/* 1171 */       this.additionalWhere = addToWhereClause;
/*      */     } else {
/* 1173 */       this.additionalWhere += " " + addToWhereClause;
/*      */     } 
/* 1175 */     return this;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> where(Expression expression) {
/* 1179 */     if (this.whereExpressions == null) {
/* 1180 */       this.whereExpressions = new DefaultExpressionList((Query)this, null);
/*      */     }
/* 1182 */     this.whereExpressions.add(expression);
/* 1183 */     return this;
/*      */   }
/*      */   
/*      */   public ExpressionList<T> where() {
/* 1187 */     if (this.whereExpressions == null) {
/* 1188 */       this.whereExpressions = new DefaultExpressionList((Query)this, null);
/*      */     }
/* 1190 */     return (ExpressionList<T>)this.whereExpressions;
/*      */   }
/*      */ 
/*      */   
/*      */   public ExpressionList<T> filterMany(String prop) {
/* 1195 */     OrmQueryProperties chunk = this.detail.getChunk(prop, true);
/* 1196 */     return (ExpressionList<T>)chunk.filterMany((Query<T>)this);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFilterMany(String prop, ExpressionList<?> filterMany) {
/* 1201 */     if (filterMany != null) {
/* 1202 */       OrmQueryProperties chunk = this.detail.getChunk(prop, true);
/* 1203 */       chunk.setFilterMany((SpiExpressionList)filterMany);
/*      */     } 
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> addHaving(String addToHavingClause) {
/* 1208 */     return having(addToHavingClause);
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> addHaving(Expression expression) {
/* 1212 */     return having(expression);
/*      */   }
/*      */   
/*      */   public ExpressionList<T> addHaving() {
/* 1216 */     return having();
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> having(String addToHavingClause) {
/* 1220 */     if (this.additionalHaving == null) {
/* 1221 */       this.additionalHaving = addToHavingClause;
/*      */     } else {
/* 1223 */       this.additionalHaving += " " + addToHavingClause;
/*      */     } 
/* 1225 */     return this;
/*      */   }
/*      */   
/*      */   public DefaultOrmQuery<T> having(Expression expression) {
/* 1229 */     if (this.havingExpressions == null) {
/* 1230 */       this.havingExpressions = new DefaultExpressionList((Query)this, null);
/*      */     }
/* 1232 */     this.havingExpressions.add(expression);
/* 1233 */     return this;
/*      */   }
/*      */   
/*      */   public ExpressionList<T> having() {
/* 1237 */     if (this.havingExpressions == null) {
/* 1238 */       this.havingExpressions = new DefaultExpressionList((Query)this, null);
/*      */     }
/* 1240 */     return (ExpressionList<T>)this.havingExpressions;
/*      */   }
/*      */   
/*      */   public SpiExpressionList<T> getHavingExpressions() {
/* 1244 */     return (SpiExpressionList<T>)this.havingExpressions;
/*      */   }
/*      */   
/*      */   public SpiExpressionList<T> getWhereExpressions() {
/* 1248 */     return (SpiExpressionList<T>)this.whereExpressions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean createOwnTransaction() {
/* 1255 */     if (this.futureFetch)
/*      */     {
/*      */       
/* 1258 */       return false;
/*      */     }
/* 1260 */     if (this.backgroundFetchAfter > 0 || this.queryListener != null)
/*      */     {
/*      */       
/* 1263 */       return true;
/*      */     }
/* 1265 */     return false;
/*      */   }
/*      */   
/*      */   public String getGeneratedSql() {
/* 1269 */     return this.generatedSql;
/*      */   }
/*      */   
/*      */   public void setGeneratedSql(String generatedSql) {
/* 1273 */     this.generatedSql = generatedSql;
/*      */   }
/*      */   
/*      */   public Query<T> setBufferFetchSizeHint(int bufferFetchSizeHint) {
/* 1277 */     this.bufferFetchSizeHint = bufferFetchSizeHint;
/* 1278 */     return (Query<T>)this;
/*      */   }
/*      */   
/*      */   public int getBufferFetchSizeHint() {
/* 1282 */     return this.bufferFetchSizeHint;
/*      */   }
/*      */   
/*      */   public void setBeanCollectionTouched(BeanCollectionTouched notify) {
/* 1286 */     this.beanCollectionTouched = notify;
/*      */   }
/*      */   
/*      */   public BeanCollectionTouched getBeanCollectionTouched() {
/* 1290 */     return this.beanCollectionTouched;
/*      */   }
/*      */   
/*      */   public List<Object> getIdList() {
/* 1294 */     return this.partialIds;
/*      */   }
/*      */   
/*      */   public void setIdList(List<Object> partialIds) {
/* 1298 */     this.partialIds = partialIds;
/*      */   }
/*      */   
/*      */   public boolean isFutureFetch() {
/* 1302 */     return this.futureFetch;
/*      */   }
/*      */   
/*      */   public void setFutureFetch(boolean backgroundFetch) {
/* 1306 */     this.futureFetch = backgroundFetch;
/*      */   }
/*      */   
/*      */   public void setCancelableQuery(CancelableQuery cancelableQuery) {
/* 1310 */     synchronized (this) {
/* 1311 */       this.cancelableQuery = cancelableQuery;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cancel() {
/* 1316 */     synchronized (this) {
/* 1317 */       this.cancelled = true;
/* 1318 */       if (this.cancelableQuery != null) {
/* 1319 */         this.cancelableQuery.cancel();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isCancelled() {
/* 1325 */     synchronized (this) {
/* 1326 */       return this.cancelled;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\querydefn\DefaultOrmQuery.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */