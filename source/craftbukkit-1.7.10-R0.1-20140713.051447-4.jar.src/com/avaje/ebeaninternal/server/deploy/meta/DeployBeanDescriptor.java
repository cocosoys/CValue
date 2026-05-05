/*      */ package com.avaje.ebeaninternal.server.deploy.meta;
/*      */ 
/*      */ import com.avaje.ebean.Query;
/*      */ import com.avaje.ebean.config.TableName;
/*      */ import com.avaje.ebean.config.dbplatform.IdGenerator;
/*      */ import com.avaje.ebean.config.dbplatform.IdType;
/*      */ import com.avaje.ebean.config.lucene.IndexDefn;
/*      */ import com.avaje.ebean.event.BeanFinder;
/*      */ import com.avaje.ebean.event.BeanPersistController;
/*      */ import com.avaje.ebean.event.BeanPersistListener;
/*      */ import com.avaje.ebean.event.BeanQueryAdapter;
/*      */ import com.avaje.ebean.meta.MetaAutoFetchStatistic;
/*      */ import com.avaje.ebeaninternal.server.core.ConcurrencyMode;
/*      */ import com.avaje.ebeaninternal.server.core.ReferenceOptions;
/*      */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*      */ import com.avaje.ebeaninternal.server.deploy.ChainedBeanPersistController;
/*      */ import com.avaje.ebeaninternal.server.deploy.ChainedBeanPersistListener;
/*      */ import com.avaje.ebeaninternal.server.deploy.ChainedBeanQueryAdapter;
/*      */ import com.avaje.ebeaninternal.server.deploy.CompoundUniqueContraint;
/*      */ import com.avaje.ebeaninternal.server.deploy.DRawSqlMeta;
/*      */ import com.avaje.ebeaninternal.server.deploy.DeployNamedQuery;
/*      */ import com.avaje.ebeaninternal.server.deploy.DeployNamedUpdate;
/*      */ import com.avaje.ebeaninternal.server.deploy.InheritInfo;
/*      */ import com.avaje.ebeaninternal.server.reflect.BeanReflect;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
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
/*      */ public class DeployBeanDescriptor<T>
/*      */ {
/*      */   static class PropOrder
/*      */     implements Comparator<DeployBeanProperty>
/*      */   {
/*      */     public int compare(DeployBeanProperty o1, DeployBeanProperty o2) {
/*   69 */       int v2 = o1.getSortOrder();
/*   70 */       int v1 = o2.getSortOrder();
/*   71 */       return (v1 < v2) ? -1 : ((v1 == v2) ? 0 : 1);
/*      */     } }
/*      */   
/*   74 */   private static final PropOrder PROP_ORDER = new PropOrder();
/*      */   
/*      */   private static final String I_SCALAOBJECT = "scala.ScalaObject";
/*      */   
/*   78 */   private static final Logger logger = Logger.getLogger(DeployBeanDescriptor.class.getName());
/*      */   
/*   80 */   private static final String META_BEAN_PREFIX = MetaAutoFetchStatistic.class.getName().substring(0, 20);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   85 */   private LinkedHashMap<String, DeployBeanProperty> propMap = new LinkedHashMap<String, DeployBeanProperty>();
/*      */ 
/*      */   
/*      */   private final Class<T> beanType;
/*      */ 
/*      */   
/*      */   private BeanDescriptor.EntityType entityType;
/*      */ 
/*      */   
/*   94 */   private final Map<String, DeployNamedQuery> namedQueries = new LinkedHashMap<String, DeployNamedQuery>();
/*      */   
/*   96 */   private final Map<String, DeployNamedUpdate> namedUpdates = new LinkedHashMap<String, DeployNamedUpdate>();
/*      */   
/*   98 */   private final Map<String, DRawSqlMeta> rawSqlMetas = new LinkedHashMap<String, DRawSqlMeta>();
/*      */ 
/*      */ 
/*      */   
/*      */   private DeployBeanPropertyAssocOne<?> unidirectional;
/*      */ 
/*      */ 
/*      */   
/*      */   private IdType idType;
/*      */ 
/*      */ 
/*      */   
/*      */   private String idGeneratorName;
/*      */ 
/*      */ 
/*      */   
/*      */   private IdGenerator idGenerator;
/*      */ 
/*      */ 
/*      */   
/*      */   private String sequenceName;
/*      */ 
/*      */   
/*      */   private String ldapBaseDn;
/*      */ 
/*      */   
/*      */   private String[] ldapObjectclasses;
/*      */ 
/*      */   
/*      */   private String selectLastInsertedId;
/*      */ 
/*      */   
/*      */   private String lazyFetchIncludes;
/*      */ 
/*      */   
/*  133 */   private ConcurrencyMode concurrencyMode = ConcurrencyMode.ALL;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean updateChangesOnly;
/*      */ 
/*      */ 
/*      */   
/*      */   private String[] dependantTables;
/*      */ 
/*      */   
/*      */   private List<CompoundUniqueContraint> compoundUniqueConstraints;
/*      */ 
/*      */   
/*  147 */   private HashMap<String, String> extraAttrMap = new HashMap<String, String>();
/*      */ 
/*      */ 
/*      */   
/*      */   private String baseTable;
/*      */ 
/*      */ 
/*      */   
/*      */   private TableName baseTableFull;
/*      */ 
/*      */ 
/*      */   
/*      */   private BeanReflect beanReflect;
/*      */ 
/*      */ 
/*      */   
/*      */   private Class<?> factoryType;
/*      */ 
/*      */ 
/*      */   
/*  167 */   private List<BeanPersistController> persistControllers = new ArrayList<BeanPersistController>();
/*  168 */   private List<BeanPersistListener<T>> persistListeners = new ArrayList<BeanPersistListener<T>>();
/*  169 */   private List<BeanQueryAdapter> queryAdapters = new ArrayList<BeanQueryAdapter>();
/*      */ 
/*      */ 
/*      */   
/*      */   private ReferenceOptions referenceOptions;
/*      */ 
/*      */   
/*      */   private BeanFinder<T> beanFinder;
/*      */ 
/*      */   
/*      */   private Query.UseIndex useIndex;
/*      */ 
/*      */   
/*      */   private IndexDefn<?> indexDefn;
/*      */ 
/*      */   
/*  185 */   private ArrayList<DeployTableJoin> tableJoinList = new ArrayList<DeployTableJoin>();
/*      */ 
/*      */ 
/*      */   
/*      */   private InheritInfo inheritInfo;
/*      */ 
/*      */   
/*      */   private String name;
/*      */ 
/*      */   
/*      */   private boolean processedRawSqlExtend;
/*      */ 
/*      */ 
/*      */   
/*      */   public DeployBeanDescriptor(Class<T> beanType) {
/*  200 */     this.beanType = beanType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAbstract() {
/*  207 */     return Modifier.isAbstract(this.beanType.getModifiers());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Query.UseIndex getUseIndex() {
/*  214 */     return this.useIndex;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUseIndex(Query.UseIndex useIndex) {
/*  221 */     this.useIndex = useIndex;
/*      */   }
/*      */   
/*      */   public IndexDefn<?> getIndexDefn() {
/*  225 */     return this.indexDefn;
/*      */   }
/*      */   
/*      */   public void setIndexDefn(IndexDefn<?> indexDefn) {
/*  229 */     this.indexDefn = indexDefn;
/*      */   }
/*      */   
/*      */   public boolean isScalaObject() {
/*  233 */     Class<?>[] interfaces = this.beanType.getInterfaces();
/*  234 */     for (int i = 0; i < interfaces.length; i++) {
/*  235 */       String iname = interfaces[i].getName();
/*  236 */       if ("scala.ScalaObject".equals(iname)) {
/*  237 */         return true;
/*      */       }
/*      */     } 
/*  240 */     return false;
/*      */   }
/*      */   
/*      */   public Collection<DRawSqlMeta> getRawSqlMeta() {
/*  244 */     if (!this.processedRawSqlExtend) {
/*  245 */       rawSqlProcessExtend();
/*  246 */       this.processedRawSqlExtend = true;
/*      */     } 
/*  248 */     return this.rawSqlMetas.values();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void rawSqlProcessExtend() {
/*  257 */     for (DRawSqlMeta rawSqlMeta : this.rawSqlMetas.values()) {
/*  258 */       String extend = rawSqlMeta.getExtend();
/*  259 */       if (extend != null) {
/*  260 */         DRawSqlMeta parentQuery = this.rawSqlMetas.get(extend);
/*  261 */         if (parentQuery == null) {
/*  262 */           throw new RuntimeException("parent query [" + extend + "] not found for sql-select " + rawSqlMeta.getName());
/*      */         }
/*  264 */         rawSqlMeta.extend(parentQuery);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public DeployBeanTable createDeployBeanTable() {
/*  272 */     DeployBeanTable beanTable = new DeployBeanTable(getBeanType());
/*  273 */     beanTable.setBaseTable(this.baseTable);
/*  274 */     beanTable.setIdProperties(propertiesId());
/*      */     
/*  276 */     return beanTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkReadAndWriteMethods() {
/*  285 */     if (isMeta()) {
/*  286 */       return true;
/*      */     }
/*  288 */     boolean missingMethods = false;
/*      */     
/*  290 */     Iterator<DeployBeanProperty> it = this.propMap.values().iterator();
/*  291 */     while (it.hasNext()) {
/*  292 */       DeployBeanProperty prop = it.next();
/*  293 */       if (!prop.isTransient()) {
/*  294 */         String m = "";
/*  295 */         if (prop.getReadMethod() == null) {
/*  296 */           m = m + " missing readMethod ";
/*      */         }
/*  298 */         if (prop.getWriteMethod() == null) {
/*  299 */           m = m + " missing writeMethod ";
/*      */         }
/*  301 */         if (!"".equals(m)) {
/*  302 */           m = m + ". Should it be transient?";
/*  303 */           String msg = "Bean property " + getFullName() + "." + prop.getName() + " has " + m;
/*  304 */           logger.log(Level.SEVERE, msg);
/*  305 */           missingMethods = true;
/*      */         } 
/*      */       } 
/*      */     } 
/*  309 */     return !missingMethods;
/*      */   }
/*      */   
/*      */   public void setEntityType(BeanDescriptor.EntityType entityType) {
/*  313 */     this.entityType = entityType;
/*      */   }
/*      */   
/*      */   public boolean isEmbedded() {
/*  317 */     return BeanDescriptor.EntityType.EMBEDDED.equals(this.entityType);
/*      */   }
/*      */   
/*      */   public boolean isBaseTableType() {
/*  321 */     BeanDescriptor.EntityType et = getEntityType();
/*  322 */     return BeanDescriptor.EntityType.ORM.equals(et);
/*      */   }
/*      */   
/*      */   public BeanDescriptor.EntityType getEntityType() {
/*  326 */     if (this.entityType == null) {
/*  327 */       this.entityType = isMeta() ? BeanDescriptor.EntityType.META : BeanDescriptor.EntityType.ORM;
/*      */     }
/*  329 */     return this.entityType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isMeta() {
/*  340 */     return this.beanType.getName().startsWith(META_BEAN_PREFIX);
/*      */   }
/*      */   
/*      */   public void add(DRawSqlMeta rawSqlMeta) {
/*  344 */     this.rawSqlMetas.put(rawSqlMeta.getName(), rawSqlMeta);
/*  345 */     if ("default".equals(rawSqlMeta.getName())) {
/*  346 */       setEntityType(BeanDescriptor.EntityType.SQL);
/*      */     }
/*      */   }
/*      */   
/*      */   public void add(DeployNamedUpdate namedUpdate) {
/*  351 */     this.namedUpdates.put(namedUpdate.getName(), namedUpdate);
/*      */   }
/*      */   
/*      */   public void add(DeployNamedQuery namedQuery) {
/*  355 */     this.namedQueries.put(namedQuery.getName(), namedQuery);
/*  356 */     if ("default".equals(namedQuery.getName())) {
/*  357 */       setEntityType(BeanDescriptor.EntityType.SQL);
/*      */     }
/*      */   }
/*      */   
/*      */   public Map<String, DeployNamedQuery> getNamedQueries() {
/*  362 */     return this.namedQueries;
/*      */   }
/*      */   
/*      */   public Map<String, DeployNamedUpdate> getNamedUpdates() {
/*  366 */     return this.namedUpdates;
/*      */   }
/*      */   
/*      */   public BeanReflect getBeanReflect() {
/*  370 */     return this.beanReflect;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<T> getBeanType() {
/*  377 */     return this.beanType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<?> getFactoryType() {
/*  384 */     return this.factoryType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFactoryType(Class<?> factoryType) {
/*  394 */     this.factoryType = factoryType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeanReflect(BeanReflect beanReflect) {
/*  402 */     this.beanReflect = beanReflect;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InheritInfo getInheritInfo() {
/*  410 */     return this.inheritInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInheritInfo(InheritInfo inheritInfo) {
/*  417 */     this.inheritInfo = inheritInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ReferenceOptions getReferenceOptions() {
/*  424 */     return this.referenceOptions;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReferenceOptions(ReferenceOptions referenceOptions) {
/*  431 */     this.referenceOptions = referenceOptions;
/*      */   }
/*      */   
/*      */   public DeployBeanPropertyAssocOne<?> getUnidirectional() {
/*  435 */     return this.unidirectional;
/*      */   }
/*      */   
/*      */   public void setUnidirectional(DeployBeanPropertyAssocOne<?> unidirectional) {
/*  439 */     this.unidirectional = unidirectional;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ConcurrencyMode getConcurrencyMode() {
/*  446 */     return this.concurrencyMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setConcurrencyMode(ConcurrencyMode concurrencyMode) {
/*  453 */     this.concurrencyMode = concurrencyMode;
/*      */   }
/*      */   
/*      */   public String getLdapBaseDn() {
/*  457 */     return this.ldapBaseDn;
/*      */   }
/*      */   
/*      */   public void setLdapBaseDn(String ldapBaseDn) {
/*  461 */     this.ldapBaseDn = ldapBaseDn;
/*      */   }
/*      */   
/*      */   public String[] getLdapObjectclasses() {
/*  465 */     return this.ldapObjectclasses;
/*      */   }
/*      */   
/*      */   public void setLdapObjectclasses(String[] ldapObjectclasses) {
/*  469 */     this.ldapObjectclasses = ldapObjectclasses;
/*      */   }
/*      */   
/*      */   public boolean isUpdateChangesOnly() {
/*  473 */     return this.updateChangesOnly;
/*      */   }
/*      */   
/*      */   public void setUpdateChangesOnly(boolean updateChangesOnly) {
/*  477 */     this.updateChangesOnly = updateChangesOnly;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getDependantTables() {
/*  485 */     return this.dependantTables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCompoundUniqueConstraint(CompoundUniqueContraint c) {
/*  492 */     if (this.compoundUniqueConstraints == null) {
/*  493 */       this.compoundUniqueConstraints = new ArrayList<CompoundUniqueContraint>();
/*      */     }
/*  495 */     this.compoundUniqueConstraints.add(c);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompoundUniqueContraint[] getCompoundUniqueConstraints() {
/*  502 */     if (this.compoundUniqueConstraints == null) {
/*  503 */       return null;
/*      */     }
/*  505 */     return this.compoundUniqueConstraints.<CompoundUniqueContraint>toArray(new CompoundUniqueContraint[this.compoundUniqueConstraints.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDependantTables(String[] dependantTables) {
/*  514 */     this.dependantTables = dependantTables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanFinder<T> getBeanFinder() {
/*  521 */     return this.beanFinder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBeanFinder(BeanFinder<T> beanFinder) {
/*  529 */     this.beanFinder = beanFinder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPersistController getPersistController() {
/*  536 */     if (this.persistControllers.size() == 0)
/*  537 */       return null; 
/*  538 */     if (this.persistControllers.size() == 1) {
/*  539 */       return this.persistControllers.get(0);
/*      */     }
/*  541 */     return (BeanPersistController)new ChainedBeanPersistController(this.persistControllers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPersistListener<T> getPersistListener() {
/*  549 */     if (this.persistListeners.size() == 0)
/*  550 */       return null; 
/*  551 */     if (this.persistListeners.size() == 1) {
/*  552 */       return this.persistListeners.get(0);
/*      */     }
/*  554 */     return (BeanPersistListener<T>)new ChainedBeanPersistListener(this.persistListeners);
/*      */   }
/*      */ 
/*      */   
/*      */   public BeanQueryAdapter getQueryAdapter() {
/*  559 */     if (this.queryAdapters.size() == 0)
/*  560 */       return null; 
/*  561 */     if (this.queryAdapters.size() == 1) {
/*  562 */       return this.queryAdapters.get(0);
/*      */     }
/*  564 */     return (BeanQueryAdapter)new ChainedBeanQueryAdapter(this.queryAdapters);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addPersistController(BeanPersistController controller) {
/*  572 */     this.persistControllers.add(controller);
/*      */   }
/*      */   
/*      */   public void addPersistListener(BeanPersistListener<T> listener) {
/*  576 */     this.persistListeners.add(listener);
/*      */   }
/*      */   
/*      */   public void addQueryAdapter(BeanQueryAdapter queryAdapter) {
/*  580 */     this.queryAdapters.add(queryAdapter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUseIdGenerator() {
/*  591 */     return (this.idType == IdType.GENERATOR);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBaseTable() {
/*  599 */     return this.baseTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TableName getBaseTableFull() {
/*  606 */     return this.baseTableFull;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseTable(TableName baseTableFull) {
/*  614 */     this.baseTableFull = baseTableFull;
/*  615 */     this.baseTable = (baseTableFull == null) ? null : baseTableFull.getQualifiedName();
/*      */   }
/*      */ 
/*      */   
/*      */   public void sortProperties() {
/*  620 */     ArrayList<DeployBeanProperty> list = new ArrayList<DeployBeanProperty>();
/*  621 */     list.addAll(this.propMap.values());
/*      */     
/*  623 */     Collections.sort(list, PROP_ORDER);
/*      */     
/*  625 */     this.propMap = new LinkedHashMap<String, DeployBeanProperty>(list.size());
/*  626 */     for (int i = 0; i < list.size(); i++) {
/*  627 */       addBeanProperty(list.get(i));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DeployBeanProperty addBeanProperty(DeployBeanProperty prop) {
/*  635 */     return this.propMap.put(prop.getName(), prop);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DeployBeanProperty getBeanProperty(String propName) {
/*  642 */     return this.propMap.get(propName);
/*      */   }
/*      */   
/*      */   public Map<String, String> getExtraAttributeMap() {
/*  646 */     return this.extraAttrMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExtraAttribute(String key) {
/*  653 */     return this.extraAttrMap.get(key);
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
/*      */   public void setExtraAttribute(String key, String value) {
/*  665 */     this.extraAttrMap.put(key, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFullName() {
/*  676 */     return this.beanType.getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  683 */     return this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String name) {
/*  690 */     this.name = name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IdType getIdType() {
/*  698 */     return this.idType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIdType(IdType idType) {
/*  705 */     this.idType = idType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSequenceName() {
/*  712 */     return this.sequenceName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequenceName(String sequenceName) {
/*  719 */     this.sequenceName = sequenceName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSelectLastInsertedId() {
/*  729 */     return this.selectLastInsertedId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSelectLastInsertedId(String selectLastInsertedId) {
/*  736 */     this.selectLastInsertedId = selectLastInsertedId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getIdGeneratorName() {
/*  744 */     return this.idGeneratorName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIdGeneratorName(String idGeneratorName) {
/*  752 */     this.idGeneratorName = idGeneratorName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IdGenerator getIdGenerator() {
/*  759 */     return this.idGenerator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIdGenerator(IdGenerator idGenerator) {
/*  766 */     this.idGenerator = idGenerator;
/*  767 */     if (idGenerator != null && idGenerator.isDbSequence()) {
/*  768 */       setSequenceName(idGenerator.getName());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLazyFetchIncludes() {
/*  776 */     return this.lazyFetchIncludes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLazyFetchIncludes(String lazyFetchIncludes) {
/*  785 */     if (lazyFetchIncludes != null && lazyFetchIncludes.length() > 0) {
/*  786 */       this.lazyFetchIncludes = lazyFetchIncludes;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  794 */     return getFullName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTableJoin(DeployTableJoin join) {
/*  801 */     this.tableJoinList.add(join);
/*      */   }
/*      */   
/*      */   public List<DeployTableJoin> getTableJoins() {
/*  805 */     return this.tableJoinList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<DeployBeanProperty> propertiesAll() {
/*  812 */     return this.propMap.values().iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefaultSelectClause() {
/*  820 */     StringBuilder sb = new StringBuilder();
/*      */     
/*  822 */     boolean hasLazyFetch = false;
/*      */     
/*  824 */     Iterator<DeployBeanProperty> it = this.propMap.values().iterator();
/*  825 */     while (it.hasNext()) {
/*  826 */       DeployBeanProperty prop = it.next();
/*  827 */       if (prop.isTransient())
/*      */         continue; 
/*  829 */       if (prop instanceof DeployBeanPropertyAssocMany) {
/*      */         continue;
/*      */       }
/*  832 */       if (prop.isFetchEager()) {
/*  833 */         sb.append(prop.getName()).append(","); continue;
/*      */       } 
/*  835 */       hasLazyFetch = true;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  840 */     if (!hasLazyFetch) {
/*  841 */       return null;
/*      */     }
/*  843 */     String selectClause = sb.toString();
/*  844 */     return selectClause.substring(0, selectClause.length() - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getDefaultSelectDbArray(Set<String> defaultSelect) {
/*  852 */     ArrayList<String> list = new ArrayList<String>();
/*  853 */     for (DeployBeanProperty p : this.propMap.values()) {
/*  854 */       if (defaultSelect != null) {
/*  855 */         if (defaultSelect.contains(p.getName()))
/*      */         {
/*  857 */           list.add(p.getDbColumn()); }  continue;
/*      */       } 
/*  859 */       if (!p.isTransient() && p.isDbRead())
/*      */       {
/*  861 */         list.add(p.getDbColumn());
/*      */       }
/*      */     } 
/*  864 */     return list.<String>toArray(new String[list.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> parseDefaultSelectClause(String rawList) {
/*  872 */     if (rawList == null) {
/*  873 */       return null;
/*      */     }
/*      */     
/*  876 */     String[] res = rawList.split(",");
/*      */     
/*  878 */     LinkedHashSet<String> set = new LinkedHashSet<String>(res.length + 3);
/*      */     
/*  880 */     String temp = null;
/*  881 */     for (int i = 0; i < res.length; i++) {
/*  882 */       temp = res[i].trim();
/*  883 */       if (temp.length() > 0) {
/*  884 */         set.add(temp);
/*      */       }
/*      */     } 
/*  887 */     return Collections.unmodifiableSet(set);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSinglePrimaryKeyColumn() {
/*  895 */     List<DeployBeanProperty> ids = propertiesId();
/*  896 */     if (ids.size() == 1) {
/*  897 */       DeployBeanProperty p = ids.get(0);
/*  898 */       if (p instanceof DeployBeanPropertyAssoc)
/*      */       {
/*  900 */         return null;
/*      */       }
/*  902 */       return p.getDbColumn();
/*      */     } 
/*      */     
/*  905 */     return null;
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
/*      */   public List<DeployBeanProperty> propertiesId() {
/*  917 */     ArrayList<DeployBeanProperty> list = new ArrayList<DeployBeanProperty>(2);
/*      */     
/*  919 */     Iterator<DeployBeanProperty> it = this.propMap.values().iterator();
/*  920 */     while (it.hasNext()) {
/*  921 */       DeployBeanProperty prop = it.next();
/*  922 */       if (prop.isId()) {
/*  923 */         list.add(prop);
/*      */       }
/*      */     } 
/*      */     
/*  927 */     return list;
/*      */   }
/*      */ 
/*      */   
/*      */   public DeployBeanPropertyAssocOne<?> findJoinToTable(String tableName) {
/*  932 */     List<DeployBeanPropertyAssocOne<?>> assocOne = propertiesAssocOne();
/*  933 */     for (DeployBeanPropertyAssocOne<?> prop : assocOne) {
/*  934 */       DeployTableJoin tableJoin = prop.getTableJoin();
/*  935 */       if (tableJoin != null && tableJoin.getTable().equalsIgnoreCase(tableName)) {
/*  936 */         return prop;
/*      */       }
/*      */     } 
/*  939 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<DeployBeanPropertyAssocOne<?>> propertiesAssocOne() {
/*  948 */     ArrayList<DeployBeanPropertyAssocOne<?>> list = new ArrayList<DeployBeanPropertyAssocOne<?>>();
/*      */     
/*  950 */     Iterator<DeployBeanProperty> it = this.propMap.values().iterator();
/*  951 */     while (it.hasNext()) {
/*  952 */       DeployBeanProperty prop = it.next();
/*  953 */       if (prop instanceof DeployBeanPropertyAssocOne && 
/*  954 */         !prop.isEmbedded()) {
/*  955 */         list.add((DeployBeanPropertyAssocOne)prop);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  960 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<DeployBeanPropertyAssocMany<?>> propertiesAssocMany() {
/*  969 */     ArrayList<DeployBeanPropertyAssocMany<?>> list = new ArrayList<DeployBeanPropertyAssocMany<?>>();
/*      */     
/*  971 */     Iterator<DeployBeanProperty> it = this.propMap.values().iterator();
/*  972 */     while (it.hasNext()) {
/*  973 */       DeployBeanProperty prop = it.next();
/*  974 */       if (prop instanceof DeployBeanPropertyAssocMany) {
/*  975 */         list.add((DeployBeanPropertyAssocMany)prop);
/*      */       }
/*      */     } 
/*      */     
/*  979 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<DeployBeanProperty> propertiesVersion() {
/*  989 */     ArrayList<DeployBeanProperty> list = new ArrayList<DeployBeanProperty>();
/*      */     
/*  991 */     Iterator<DeployBeanProperty> it = this.propMap.values().iterator();
/*  992 */     while (it.hasNext()) {
/*  993 */       DeployBeanProperty prop = it.next();
/*      */       
/*  995 */       if (prop instanceof DeployBeanPropertyAssoc) {
/*      */         continue;
/*      */       }
/*  998 */       if (!prop.isId() && prop.isVersionColumn()) {
/*  999 */         list.add(prop);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1004 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<DeployBeanProperty> propertiesBase() {
/* 1012 */     ArrayList<DeployBeanProperty> list = new ArrayList<DeployBeanProperty>();
/*      */     
/* 1014 */     Iterator<DeployBeanProperty> it = this.propMap.values().iterator();
/* 1015 */     while (it.hasNext()) {
/* 1016 */       DeployBeanProperty prop = it.next();
/*      */       
/* 1018 */       if (prop instanceof DeployBeanPropertyAssoc) {
/*      */         continue;
/*      */       }
/* 1021 */       if (!prop.isId()) {
/* 1022 */         list.add(prop);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1027 */     return list;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\meta\DeployBeanDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */