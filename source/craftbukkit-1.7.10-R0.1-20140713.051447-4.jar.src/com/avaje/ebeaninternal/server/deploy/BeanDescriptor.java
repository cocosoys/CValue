/*      */ package com.avaje.ebeaninternal.server.deploy;
/*      */ 
/*      */ import com.avaje.ebean.InvalidValue;
/*      */ import com.avaje.ebean.Query;
/*      */ import com.avaje.ebean.SqlUpdate;
/*      */ import com.avaje.ebean.Transaction;
/*      */ import com.avaje.ebean.bean.BeanCollection;
/*      */ import com.avaje.ebean.bean.BeanCollectionLoader;
/*      */ import com.avaje.ebean.bean.BeanLoader;
/*      */ import com.avaje.ebean.bean.EntityBean;
/*      */ import com.avaje.ebean.bean.EntityBeanIntercept;
/*      */ import com.avaje.ebean.cache.ServerCache;
/*      */ import com.avaje.ebean.cache.ServerCacheManager;
/*      */ import com.avaje.ebean.config.EncryptKey;
/*      */ import com.avaje.ebean.config.dbplatform.IdGenerator;
/*      */ import com.avaje.ebean.config.dbplatform.IdType;
/*      */ import com.avaje.ebean.config.lucene.IndexDefn;
/*      */ import com.avaje.ebean.event.BeanFinder;
/*      */ import com.avaje.ebean.event.BeanPersistController;
/*      */ import com.avaje.ebean.event.BeanPersistListener;
/*      */ import com.avaje.ebean.event.BeanQueryAdapter;
/*      */ import com.avaje.ebean.text.TextException;
/*      */ import com.avaje.ebean.text.json.JsonWriteBeanVisitor;
/*      */ import com.avaje.ebean.text.json.JsonWriter;
/*      */ import com.avaje.ebean.validation.factory.Validator;
/*      */ import com.avaje.ebeaninternal.api.SpiEbeanServer;
/*      */ import com.avaje.ebeaninternal.api.SpiQuery;
/*      */ import com.avaje.ebeaninternal.api.SpiUpdatePlan;
/*      */ import com.avaje.ebeaninternal.api.TransactionEvent;
/*      */ import com.avaje.ebeaninternal.api.TransactionEventTable;
/*      */ import com.avaje.ebeaninternal.server.core.ConcurrencyMode;
/*      */ import com.avaje.ebeaninternal.server.core.DefaultSqlUpdate;
/*      */ import com.avaje.ebeaninternal.server.core.InternString;
/*      */ import com.avaje.ebeaninternal.server.core.ReferenceOptions;
/*      */ import com.avaje.ebeaninternal.server.deploy.id.IdBinder;
/*      */ import com.avaje.ebeaninternal.server.deploy.meta.DeployBeanDescriptor;
/*      */ import com.avaje.ebeaninternal.server.deploy.meta.DeployBeanPropertyLists;
/*      */ import com.avaje.ebeaninternal.server.el.ElComparator;
/*      */ import com.avaje.ebeaninternal.server.el.ElComparatorCompound;
/*      */ import com.avaje.ebeaninternal.server.el.ElComparatorProperty;
/*      */ import com.avaje.ebeaninternal.server.el.ElPropertyChainBuilder;
/*      */ import com.avaje.ebeaninternal.server.el.ElPropertyDeploy;
/*      */ import com.avaje.ebeaninternal.server.el.ElPropertyValue;
/*      */ import com.avaje.ebeaninternal.server.ldap.LdapPersistenceException;
/*      */ import com.avaje.ebeaninternal.server.lucene.LIndex;
/*      */ import com.avaje.ebeaninternal.server.persist.DmlUtil;
/*      */ import com.avaje.ebeaninternal.server.query.CQueryPlan;
/*      */ import com.avaje.ebeaninternal.server.query.SplitName;
/*      */ import com.avaje.ebeaninternal.server.querydefn.OrmQueryDetail;
/*      */ import com.avaje.ebeaninternal.server.reflect.BeanReflect;
/*      */ import com.avaje.ebeaninternal.server.text.json.ReadJsonContext;
/*      */ import com.avaje.ebeaninternal.server.text.json.WriteJsonContext;
/*      */ import com.avaje.ebeaninternal.server.transaction.IndexInvalidate;
/*      */ import com.avaje.ebeaninternal.server.type.DataBind;
/*      */ import com.avaje.ebeaninternal.server.type.TypeManager;
/*      */ import com.avaje.ebeaninternal.util.SortByClause;
/*      */ import com.avaje.ebeaninternal.util.SortByClauseParser;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.naming.InvalidNameException;
/*      */ import javax.naming.directory.Attributes;
/*      */ import javax.naming.directory.BasicAttribute;
/*      */ import javax.naming.directory.BasicAttributes;
/*      */ import javax.naming.ldap.LdapName;
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
/*      */ public class BeanDescriptor<T>
/*      */ {
/*  105 */   private static final Logger logger = Logger.getLogger(BeanDescriptor.class.getName());
/*      */   
/*  107 */   private final ConcurrentHashMap<Integer, SpiUpdatePlan> updatePlanCache = new ConcurrentHashMap<Integer, SpiUpdatePlan>();
/*      */   
/*  109 */   private final ConcurrentHashMap<Integer, CQueryPlan> queryPlanCache = new ConcurrentHashMap<Integer, CQueryPlan>();
/*      */   
/*  111 */   private final ConcurrentHashMap<String, ElPropertyValue> elGetCache = new ConcurrentHashMap<String, ElPropertyValue>();
/*      */   
/*  113 */   private final ConcurrentHashMap<String, ElComparator<T>> comparatorCache = new ConcurrentHashMap<String, ElComparator<T>>(); private final String serverName; private final EntityType entityType; private final IdType idType; private final IdGenerator idGenerator; private final String sequenceName; private final String ldapBaseDn; private final String[] ldapObjectclasses; private final String selectLastInsertedId; private final boolean autoFetchTunable; private final String lazyFetchIncludes; private final ConcurrencyMode concurrencyMode; private final String[] dependantTables; private final CompoundUniqueContraint[] compoundUniqueConstraints; private final Map<String, String> extraAttrMap; private final String baseTable; private final BeanReflect beanReflect; private final LinkedHashMap<String, BeanProperty> propMap; private final LinkedHashMap<String, BeanProperty> propMapByDbColumn; private final Class<T> beanType; private final BeanDescriptorMap owner; private final Class<?> factoryType; private final boolean enhancedBean; private volatile BeanPersistController persistController; private volatile BeanPersistListener<T> persistListener; private volatile BeanQueryAdapter queryAdapter; private final BeanFinder<T> beanFinder; private final IndexDefn<?> luceneIndexDefn; private final TableJoin[] derivedTableJoins; private final InheritInfo inheritInfo; private final BeanProperty[] propertiesId; private final BeanProperty[] propertiesVersion; private final BeanProperty[] propertiesLocal; private final BeanPropertyAssocOne<?> unidirectional; private final int namesOfManyPropsHash; private final Set<String> namesOfManyProps; private final BeanPropertyAssocMany<?>[] propertiesMany; private final BeanPropertyAssocMany<?>[] propertiesManySave; private final BeanPropertyAssocMany<?>[] propertiesManyDelete; private final BeanPropertyAssocMany<?>[] propertiesManyToMany; private final BeanPropertyAssocOne<?>[] propertiesOne; private final BeanPropertyAssocOne<?>[] propertiesOneImported; private final BeanPropertyAssocOne<?>[] propertiesOneImportedSave; private final BeanPropertyAssocOne<?>[] propertiesOneImportedDelete; private final BeanPropertyAssocOne<?>[] propertiesOneExported; private final BeanPropertyAssocOne<?>[] propertiesOneExportedSave; private final BeanPropertyAssocOne<?>[] propertiesOneExportedDelete; private final BeanPropertyAssocOne<?>[] propertiesEmbedded; private final BeanProperty[] propertiesBaseScalar; private final BeanPropertyCompound[] propertiesBaseCompound; private final BeanProperty[] propertiesTransient; final BeanProperty[] propertiesNonTransient; private final BeanProperty propertyFirstVersion; private final BeanProperty propertySingleId; private final String fullName; private final Map<String, DeployNamedQuery> namedQueries; private final Map<String, DeployNamedUpdate> namedUpdates; private final boolean hasLocalValidation; private final boolean hasCascadeValidation; private final BeanProperty[] propertiesValidationLocal; private final BeanProperty[] propertiesValidationCascade; private final Validator[] beanValidators; private boolean saveRecurseSkippable;
/*      */   private boolean deleteRecurseSkippable;
/*  115 */   private final ConcurrentHashMap<String, BeanFkeyProperty> fkeyMap = new ConcurrentHashMap<String, BeanFkeyProperty>(); private final TypeManager typeManager; private final IdBinder idBinder; private String idBinderInLHSSql; private String idBinderIdSql; private String deleteByIdSql; private String deleteByIdInSql; private final String name; private final String baseTableAlias; private final boolean updateChangesOnly; private final ServerCacheManager cacheManager; private final ReferenceOptions referenceOptions; private final String defaultSelectClause; private final Set<String> defaultSelectClauseSet; private final String[] defaultSelectDbArray; private final String descriptorId; private final Query.UseIndex useIndex; private SpiEbeanServer ebeanServer; private ServerCache beanCache; private ServerCache queryCache; private LIndex luceneIndex;
/*      */   private Set<IndexInvalidate> luceneIndexInvalidations;
/*      */   
/*  118 */   public enum EntityType { ORM,
/*  119 */     EMBEDDED,
/*  120 */     SQL,
/*  121 */     META,
/*  122 */     LDAP,
/*  123 */     XMLELEMENT; }
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
/*      */ 
/*      */   
/*      */   public BeanDescriptor(BeanDescriptorMap owner, TypeManager typeManager, DeployBeanDescriptor<T> deploy, String descriptorId) {
/*  415 */     this.owner = owner;
/*  416 */     this.cacheManager = owner.getCacheManager();
/*  417 */     this.serverName = owner.getServerName();
/*  418 */     this.luceneIndexDefn = deploy.getIndexDefn();
/*  419 */     this.entityType = deploy.getEntityType();
/*  420 */     this.name = InternString.intern(deploy.getName());
/*  421 */     this.baseTableAlias = "t0";
/*  422 */     this.fullName = InternString.intern(deploy.getFullName());
/*  423 */     this.descriptorId = descriptorId;
/*      */     
/*  425 */     this.useIndex = deploy.getUseIndex();
/*  426 */     this.typeManager = typeManager;
/*  427 */     this.beanType = deploy.getBeanType();
/*  428 */     this.factoryType = deploy.getFactoryType();
/*  429 */     this.enhancedBean = this.beanType.equals(this.factoryType);
/*  430 */     this.namedQueries = deploy.getNamedQueries();
/*  431 */     this.namedUpdates = deploy.getNamedUpdates();
/*      */     
/*  433 */     this.inheritInfo = deploy.getInheritInfo();
/*      */     
/*  435 */     this.beanFinder = deploy.getBeanFinder();
/*  436 */     this.persistController = deploy.getPersistController();
/*  437 */     this.persistListener = deploy.getPersistListener();
/*  438 */     this.queryAdapter = deploy.getQueryAdapter();
/*  439 */     this.referenceOptions = deploy.getReferenceOptions();
/*      */     
/*  441 */     this.defaultSelectClause = deploy.getDefaultSelectClause();
/*  442 */     this.defaultSelectClauseSet = deploy.parseDefaultSelectClause(this.defaultSelectClause);
/*  443 */     this.defaultSelectDbArray = deploy.getDefaultSelectDbArray(this.defaultSelectClauseSet);
/*      */     
/*  445 */     this.idType = deploy.getIdType();
/*  446 */     this.idGenerator = deploy.getIdGenerator();
/*  447 */     this.ldapBaseDn = deploy.getLdapBaseDn();
/*  448 */     this.ldapObjectclasses = deploy.getLdapObjectclasses();
/*  449 */     this.sequenceName = deploy.getSequenceName();
/*  450 */     this.selectLastInsertedId = deploy.getSelectLastInsertedId();
/*  451 */     this.lazyFetchIncludes = InternString.intern(deploy.getLazyFetchIncludes());
/*  452 */     this.concurrencyMode = deploy.getConcurrencyMode();
/*  453 */     this.updateChangesOnly = deploy.isUpdateChangesOnly();
/*      */     
/*  455 */     this.dependantTables = deploy.getDependantTables();
/*  456 */     this.compoundUniqueConstraints = deploy.getCompoundUniqueConstraints();
/*      */     
/*  458 */     this.extraAttrMap = deploy.getExtraAttributeMap();
/*      */     
/*  460 */     this.baseTable = InternString.intern(deploy.getBaseTable());
/*      */     
/*  462 */     this.beanReflect = deploy.getBeanReflect();
/*      */     
/*  464 */     this.autoFetchTunable = (EntityType.ORM.equals(this.entityType) && this.beanFinder == null);
/*      */ 
/*      */     
/*  467 */     DeployBeanPropertyLists listHelper = new DeployBeanPropertyLists(owner, this, deploy);
/*      */     
/*  469 */     this.propMap = listHelper.getPropertyMap();
/*  470 */     this.propMapByDbColumn = getReverseMap(this.propMap);
/*  471 */     this.propertiesTransient = listHelper.getTransients();
/*  472 */     this.propertiesNonTransient = listHelper.getNonTransients();
/*  473 */     this.propertiesBaseScalar = listHelper.getBaseScalar();
/*  474 */     this.propertiesBaseCompound = listHelper.getBaseCompound();
/*  475 */     this.propertiesId = listHelper.getId();
/*  476 */     this.propertiesVersion = listHelper.getVersion();
/*  477 */     this.propertiesEmbedded = (BeanPropertyAssocOne<?>[])listHelper.getEmbedded();
/*  478 */     this.propertiesLocal = listHelper.getLocal();
/*  479 */     this.unidirectional = listHelper.getUnidirectional();
/*  480 */     this.propertiesOne = (BeanPropertyAssocOne<?>[])listHelper.getOnes();
/*  481 */     this.propertiesOneExported = (BeanPropertyAssocOne<?>[])listHelper.getOneExported();
/*  482 */     this.propertiesOneExportedSave = (BeanPropertyAssocOne<?>[])listHelper.getOneExportedSave();
/*  483 */     this.propertiesOneExportedDelete = (BeanPropertyAssocOne<?>[])listHelper.getOneExportedDelete();
/*  484 */     this.propertiesOneImported = (BeanPropertyAssocOne<?>[])listHelper.getOneImported();
/*  485 */     this.propertiesOneImportedSave = (BeanPropertyAssocOne<?>[])listHelper.getOneImportedSave();
/*  486 */     this.propertiesOneImportedDelete = (BeanPropertyAssocOne<?>[])listHelper.getOneImportedDelete();
/*      */     
/*  488 */     this.propertiesMany = (BeanPropertyAssocMany<?>[])listHelper.getMany();
/*  489 */     this.propertiesManySave = (BeanPropertyAssocMany<?>[])listHelper.getManySave();
/*  490 */     this.propertiesManyDelete = (BeanPropertyAssocMany<?>[])listHelper.getManyDelete();
/*  491 */     this.propertiesManyToMany = (BeanPropertyAssocMany<?>[])listHelper.getManyToMany();
/*      */     
/*  493 */     this.namesOfManyProps = deriveManyPropNames();
/*  494 */     this.namesOfManyPropsHash = this.namesOfManyProps.hashCode();
/*      */     
/*  496 */     this.derivedTableJoins = listHelper.getTableJoin();
/*  497 */     this.propertyFirstVersion = listHelper.getFirstVersion();
/*      */     
/*  499 */     if (this.propertiesId.length == 1) {
/*  500 */       this.propertySingleId = this.propertiesId[0];
/*      */     } else {
/*  502 */       this.propertySingleId = null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  509 */     this.saveRecurseSkippable = (0 == this.propertiesOneExportedSave.length + this.propertiesOneImportedSave.length + this.propertiesManySave.length);
/*      */ 
/*      */     
/*  512 */     this.deleteRecurseSkippable = (0 == this.propertiesOneExportedDelete.length + this.propertiesOneImportedDelete.length + this.propertiesManyDelete.length);
/*      */     
/*  514 */     this.propertiesValidationLocal = listHelper.getPropertiesWithValidators(false);
/*  515 */     this.propertiesValidationCascade = listHelper.getPropertiesWithValidators(true);
/*  516 */     this.beanValidators = listHelper.getBeanValidators();
/*  517 */     this.hasLocalValidation = (this.propertiesValidationLocal.length > 0 || this.beanValidators.length > 0);
/*  518 */     this.hasCascadeValidation = (this.propertiesValidationCascade.length > 0 || this.beanValidators.length > 0);
/*      */ 
/*      */     
/*  521 */     this.idBinder = owner.createIdBinder(this.propertiesId);
/*      */   }
/*      */ 
/*      */   
/*      */   private LinkedHashMap<String, BeanProperty> getReverseMap(LinkedHashMap<String, BeanProperty> propMap) {
/*  526 */     LinkedHashMap<String, BeanProperty> revMap = new LinkedHashMap<String, BeanProperty>(propMap.size() * 2);
/*      */     
/*  528 */     for (BeanProperty prop : propMap.values()) {
/*  529 */       if (prop.getDbColumn() != null) {
/*  530 */         revMap.put(prop.getDbColumn(), prop);
/*      */       }
/*      */     } 
/*      */     
/*  534 */     return revMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEbeanServer(SpiEbeanServer ebeanServer) {
/*  541 */     this.ebeanServer = ebeanServer;
/*  542 */     for (int i = 0; i < this.propertiesMany.length; i++)
/*      */     {
/*  544 */       this.propertiesMany[i].setLoader((BeanCollectionLoader)ebeanServer);
/*      */     }
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
/*      */   public T createCopy(Object source, CopyContext ctx, int maxDepth) {
/*  559 */     Object destBean = createBean(ctx.isVanillaMode());
/*  560 */     for (int j = 0; j < this.propertiesId.length; j++) {
/*  561 */       this.propertiesId[j].copyProperty(source, destBean, ctx, maxDepth);
/*      */     }
/*      */     
/*  564 */     Object destId = getId(destBean);
/*  565 */     Object existing = ctx.putIfAbsent(destId, destBean);
/*  566 */     if (existing != null) {
/*  567 */       return (T)existing;
/*      */     }
/*  569 */     for (int i = 0; i < this.propertiesNonTransient.length; i++) {
/*  570 */       this.propertiesNonTransient[i].copyProperty(source, destBean, ctx, maxDepth);
/*      */     }
/*      */     
/*  573 */     if (destBean instanceof EntityBean) {
/*  574 */       EntityBeanIntercept copyEbi = ((EntityBean)destBean)._ebean_getIntercept();
/*  575 */       if (source instanceof EntityBean) {
/*  576 */         EntityBeanIntercept origEbi = ((EntityBean)source)._ebean_getIntercept();
/*  577 */         origEbi.copyStateTo(copyEbi);
/*      */       } 
/*  579 */       copyEbi.setBeanLoader(0, (BeanLoader)this.ebeanServer);
/*  580 */       copyEbi.setPersistenceContext(ctx.getPersistenceContext());
/*      */       
/*  582 */       if (ctx.isSharing()) {
/*  583 */         copyEbi.setSharedInstance();
/*      */       }
/*      */     } 
/*      */     
/*  587 */     return (T)destBean;
/*      */   }
/*      */   
/*      */   public T createCopyForUpdate(Object orig, boolean vanilla) {
/*  591 */     return createCopy(orig, new CopyContext(false, false), 3);
/*      */   }
/*      */   
/*      */   public T createCopyForSharing(Object orig) {
/*  595 */     return createCopy(orig, new CopyContext(false, true), 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ConcurrencyMode determineConcurrencyMode(Object bean) {
/*  604 */     if (this.propertyFirstVersion == null) {
/*  605 */       return ConcurrencyMode.NONE;
/*      */     }
/*  607 */     Object v = this.propertyFirstVersion.getValue(bean);
/*  608 */     return (v == null) ? ConcurrencyMode.NONE : ConcurrencyMode.VERSION;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> getDirtyEmbeddedProperties(Object bean) {
/*  616 */     HashSet<String> dirtyProperties = null;
/*      */     
/*  618 */     for (int i = 0; i < this.propertiesEmbedded.length; i++) {
/*  619 */       Object embValue = this.propertiesEmbedded[i].getValue(bean);
/*  620 */       if (embValue instanceof EntityBean) {
/*  621 */         if (((EntityBean)embValue)._ebean_getIntercept().isDirty()) {
/*      */           
/*  623 */           if (dirtyProperties == null) {
/*  624 */             dirtyProperties = new HashSet<String>();
/*      */           }
/*  626 */           dirtyProperties.add(this.propertiesEmbedded[i].getName());
/*      */         } 
/*      */       } else {
/*      */         
/*  630 */         if (dirtyProperties == null) {
/*  631 */           dirtyProperties = new HashSet<String>();
/*      */         }
/*  633 */         dirtyProperties.add(this.propertiesEmbedded[i].getName());
/*      */       } 
/*      */     } 
/*      */     
/*  637 */     return dirtyProperties;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> determineLoadedProperties(Object bean) {
/*  645 */     HashSet<String> nonNullProps = new HashSet<String>();
/*      */     
/*  647 */     for (int j = 0; j < this.propertiesId.length; j++) {
/*  648 */       if (this.propertiesId[j].getValue(bean) != null) {
/*  649 */         nonNullProps.add(this.propertiesId[j].getName());
/*      */       }
/*      */     } 
/*  652 */     for (int i = 0; i < this.propertiesNonTransient.length; i++) {
/*  653 */       if (this.propertiesNonTransient[i].getValue(bean) != null) {
/*  654 */         nonNullProps.add(this.propertiesNonTransient[i].getName());
/*      */       }
/*      */     } 
/*  657 */     return nonNullProps;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SpiEbeanServer getEbeanServer() {
/*  664 */     return this.ebeanServer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityType getEntityType() {
/*  671 */     return this.entityType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IndexDefn<?> getLuceneIndexDefn() {
/*  678 */     return this.luceneIndexDefn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Query.UseIndex getUseIndex() {
/*  686 */     return this.useIndex;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LIndex getLuceneIndex() {
/*  693 */     return this.luceneIndex;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLuceneIndex(LIndex luceneIndex) {
/*  700 */     this.luceneIndex = luceneIndex;
/*      */   }
/*      */   
/*      */   public void addIndexInvalidate(IndexInvalidate e) {
/*  704 */     if (this.luceneIndexInvalidations == null) {
/*  705 */       this.luceneIndexInvalidations = new HashSet<IndexInvalidate>();
/*      */     }
/*  707 */     this.luceneIndexInvalidations.add(e);
/*      */   }
/*      */   
/*      */   public boolean isNotifyLucene(TransactionEvent txnEvent) {
/*  711 */     if (this.luceneIndexInvalidations != null) {
/*  712 */       for (IndexInvalidate invalidate : this.luceneIndexInvalidations) {
/*  713 */         txnEvent.addIndexInvalidate(invalidate);
/*      */       }
/*      */     }
/*  716 */     return (this.luceneIndex != null);
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
/*      */   public void initialiseId() {
/*  728 */     if (logger.isLoggable(Level.FINER)) {
/*  729 */       logger.finer("BeanDescriptor initialise " + this.fullName);
/*      */     }
/*      */     
/*  732 */     if (this.inheritInfo != null) {
/*  733 */       this.inheritInfo.setDescriptor(this);
/*      */     }
/*      */     
/*  736 */     if (isEmbedded()) {
/*      */       
/*  738 */       Iterator<BeanProperty> it = propertiesAll();
/*  739 */       while (it.hasNext()) {
/*  740 */         BeanProperty prop = it.next();
/*  741 */         prop.initialise();
/*      */       } 
/*      */     } else {
/*      */       
/*  745 */       BeanProperty[] idProps = propertiesId();
/*  746 */       for (int i = 0; i < idProps.length; i++) {
/*  747 */         idProps[i].initialise();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void initialiseOther() {
/*  757 */     if (!isEmbedded()) {
/*      */       
/*  759 */       Iterator<BeanProperty> it = propertiesAll();
/*  760 */       while (it.hasNext()) {
/*  761 */         BeanProperty prop = it.next();
/*  762 */         if (!prop.isId()) {
/*  763 */           prop.initialise();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  768 */     if (this.unidirectional != null) {
/*  769 */       this.unidirectional.initialise();
/*      */     }
/*      */     
/*  772 */     this.idBinder.initialise();
/*  773 */     this.idBinderInLHSSql = this.idBinder.getBindIdInSql(this.baseTableAlias);
/*  774 */     this.idBinderIdSql = this.idBinder.getBindIdSql(this.baseTableAlias);
/*  775 */     String idBinderInLHSSqlNoAlias = this.idBinder.getBindIdInSql(null);
/*  776 */     String idEqualsSql = this.idBinder.getBindIdSql(null);
/*      */     
/*  778 */     this.deleteByIdSql = "delete from " + this.baseTable + " where " + idEqualsSql;
/*  779 */     this.deleteByIdInSql = "delete from " + this.baseTable + " where " + idBinderInLHSSqlNoAlias + " ";
/*      */     
/*  781 */     if (!isEmbedded())
/*      */     {
/*  783 */       for (DeployNamedUpdate namedUpdate : this.namedUpdates.values()) {
/*  784 */         DeployUpdateParser parser = new DeployUpdateParser(this);
/*  785 */         namedUpdate.initialise(parser);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void initInheritInfo() {
/*  792 */     if (this.inheritInfo != null) {
/*      */       
/*  794 */       if (this.saveRecurseSkippable) {
/*  795 */         this.saveRecurseSkippable = this.inheritInfo.isSaveRecurseSkippable();
/*      */       }
/*  797 */       if (this.deleteRecurseSkippable) {
/*  798 */         this.deleteRecurseSkippable = this.inheritInfo.isDeleteRecurseSkippable();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cacheInitialise() {
/*  808 */     if (this.referenceOptions != null && this.referenceOptions.isUseCache()) {
/*  809 */       this.beanCache = this.cacheManager.getBeanCache(this.beanType);
/*      */     }
/*      */   }
/*      */   
/*      */   protected boolean hasInheritance() {
/*  814 */     return (this.inheritInfo != null);
/*      */   }
/*      */   
/*      */   protected boolean isDynamicSubclass() {
/*  818 */     return !this.beanType.equals(this.factoryType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLdapObjectClasses(Attributes attributes) {
/*  826 */     if (this.ldapObjectclasses != null) {
/*  827 */       BasicAttribute ocAttrs = new BasicAttribute("objectclass");
/*  828 */       for (int i = 0; i < this.ldapObjectclasses.length; i++) {
/*  829 */         ocAttrs.add(this.ldapObjectclasses[i]);
/*      */       }
/*  831 */       attributes.put(ocAttrs);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attributes createAttributes() {
/*  840 */     Attributes attrs = new BasicAttributes(true);
/*  841 */     setLdapObjectClasses(attrs);
/*  842 */     return attrs;
/*      */   }
/*      */   
/*      */   public String getLdapBaseDn() {
/*  846 */     return this.ldapBaseDn;
/*      */   }
/*      */ 
/*      */   
/*      */   public LdapName createLdapNameById(Object id) throws InvalidNameException {
/*  851 */     LdapName baseDn = new LdapName(this.ldapBaseDn);
/*  852 */     this.idBinder.createLdapNameById(baseDn, id);
/*  853 */     return baseDn;
/*      */   }
/*      */ 
/*      */   
/*      */   public LdapName createLdapName(Object bean) {
/*      */     try {
/*  859 */       LdapName name = new LdapName(this.ldapBaseDn);
/*  860 */       if (bean != null) {
/*  861 */         this.idBinder.createLdapNameByBean(name, bean);
/*      */       }
/*  863 */       return name;
/*      */     }
/*  865 */     catch (InvalidNameException e) {
/*  866 */       throw new LdapPersistenceException(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public SqlUpdate deleteById(Object id, List<Object> idList) {
/*  871 */     if (id != null) {
/*  872 */       return deleteById(id);
/*      */     }
/*  874 */     return deleteByIdList(idList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private SqlUpdate deleteByIdList(List<Object> idList) {
/*  884 */     StringBuilder sb = new StringBuilder(this.deleteByIdInSql);
/*  885 */     String inClause = this.idBinder.getIdInValueExprDelete(idList.size());
/*  886 */     sb.append(inClause);
/*      */     
/*  888 */     DefaultSqlUpdate delete = new DefaultSqlUpdate(sb.toString());
/*  889 */     for (int i = 0; i < idList.size(); i++) {
/*  890 */       this.idBinder.bindId(delete, idList.get(i));
/*      */     }
/*  892 */     return (SqlUpdate)delete;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private SqlUpdate deleteById(Object id) {
/*  901 */     DefaultSqlUpdate sqlDelete = new DefaultSqlUpdate(this.deleteByIdSql);
/*      */     
/*  903 */     Object[] bindValues = this.idBinder.getBindValues(id);
/*  904 */     for (int i = 0; i < bindValues.length; i++) {
/*  905 */       sqlDelete.addParameter(bindValues[i]);
/*      */     }
/*      */     
/*  908 */     return (SqlUpdate)sqlDelete;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(BeanFkeyProperty fkey) {
/*  916 */     this.fkeyMap.put(fkey.getName(), fkey);
/*      */   }
/*      */   
/*      */   public void initialiseFkeys() {
/*  920 */     for (int i = 0; i < this.propertiesOneImported.length; i++) {
/*  921 */       this.propertiesOneImported[i].addFkey();
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean calculateUseCache(Boolean queryUseCache) {
/*  926 */     if (queryUseCache != null) {
/*  927 */       return queryUseCache.booleanValue();
/*      */     }
/*  929 */     if (this.referenceOptions != null) {
/*  930 */       return this.referenceOptions.isUseCache();
/*      */     }
/*  932 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean calculateReadOnly(Boolean queryReadOnly) {
/*  938 */     if (queryReadOnly != null) {
/*  939 */       return queryReadOnly.booleanValue();
/*      */     }
/*  941 */     if (this.referenceOptions != null) {
/*  942 */       return this.referenceOptions.isReadOnly();
/*      */     }
/*  944 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ReferenceOptions getReferenceOptions() {
/*  953 */     return this.referenceOptions;
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
/*      */   public EncryptKey getEncryptKey(BeanProperty p) {
/*  967 */     return this.owner.getEncryptKey(this.baseTable, p.getDbColumn());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EncryptKey getEncryptKey(String tableName, String columnName) {
/*  974 */     return this.owner.getEncryptKey(tableName, columnName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void runCacheWarming() {
/*  982 */     if (this.referenceOptions == null) {
/*      */       return;
/*      */     }
/*  985 */     String warmingQuery = this.referenceOptions.getWarmingQuery();
/*  986 */     if (warmingQuery != null && warmingQuery.trim().length() > 0) {
/*  987 */       Query<T> query = this.ebeanServer.createQuery(this.beanType, warmingQuery);
/*  988 */       query.setUseCache(true);
/*  989 */       query.setReadOnly(true);
/*  990 */       query.setLoadBeanCache(true);
/*  991 */       List<T> list = query.findList();
/*  992 */       if (logger.isLoggable(Level.INFO)) {
/*  993 */         String msg = "Loaded " + this.beanType + " cache with [" + list.size() + "] beans";
/*  994 */         logger.info(msg);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasDefaultSelectClause() {
/* 1004 */     return (this.defaultSelectClause != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefaultSelectClause() {
/* 1011 */     return this.defaultSelectClause;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> getDefaultSelectClauseSet() {
/* 1018 */     return this.defaultSelectClauseSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getDefaultSelectDbArray() {
/* 1026 */     return this.defaultSelectDbArray;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInheritanceRoot() {
/* 1034 */     return (this.inheritInfo == null || this.inheritInfo.isRoot());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isQueryCaching() {
/* 1041 */     return (this.queryCache != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBeanCaching() {
/* 1048 */     return (this.beanCache != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isCacheNotify(boolean isInsertRequest) {
/* 1056 */     if (isInsertRequest)
/*      */     {
/* 1058 */       return (this.queryCache != null);
/*      */     }
/* 1060 */     return (this.beanCache != null || this.queryCache != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUsingL2Cache() {
/* 1068 */     return (this.beanCache != null || this.luceneIndex != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLuceneIndexed() {
/* 1075 */     return (this.luceneIndex != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cacheNotify(TransactionEventTable.TableIUD tableIUD) {
/* 1083 */     if (tableIUD.isUpdateOrDelete()) {
/* 1084 */       cacheClear();
/*      */     }
/*      */     
/* 1087 */     queryCacheClear();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void queryCacheClear() {
/* 1094 */     if (this.queryCache != null) {
/* 1095 */       this.queryCache.clear();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanCollection<T> queryCacheGet(Object id) {
/* 1104 */     if (this.queryCache == null) {
/* 1105 */       return null;
/*      */     }
/* 1107 */     return (BeanCollection<T>)this.queryCache.get(id);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void queryCachePut(Object id, BeanCollection<T> query) {
/* 1115 */     if (this.queryCache == null) {
/* 1116 */       this.queryCache = this.cacheManager.getQueryCache(this.beanType);
/*      */     }
/* 1118 */     this.queryCache.put(id, query);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cacheClear() {
/* 1125 */     if (this.beanCache != null) {
/* 1126 */       this.beanCache.clear();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public T cachePutObject(Object bean) {
/* 1132 */     Object cacheBean = createCopyForSharing(bean);
/* 1133 */     return cachePut((T)cacheBean, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public T cachePut(T bean, boolean alreadyShared) {
/* 1141 */     if (this.beanCache == null) {
/* 1142 */       this.beanCache = this.cacheManager.getBeanCache(this.beanType);
/*      */     }
/*      */     
/* 1145 */     if (!alreadyShared) {
/* 1146 */       bean = createCopyForSharing(bean);
/*      */     }
/* 1148 */     Object id = getId(bean);
/* 1149 */     return (T)this.beanCache.put(id, bean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public T cacheGet(Object id) {
/* 1157 */     if (this.beanCache == null) {
/* 1158 */       return null;
/*      */     }
/* 1160 */     return (T)this.beanCache.get(id);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cacheRemove(Object id) {
/* 1168 */     if (this.beanCache != null) {
/* 1169 */       this.beanCache.remove(id);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBaseTableAlias() {
/* 1178 */     return this.baseTableAlias;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean refreshFromCache(EntityBeanIntercept ebi, Object id) {
/* 1185 */     if (ebi.isUseCache() && ebi.isReference()) {
/*      */       
/* 1187 */       Object cacheBean = cacheGet(id);
/* 1188 */       if (cacheBean != null) {
/*      */ 
/*      */         
/* 1191 */         String lazyLoadProperty = ebi.getLazyLoadProperty();
/* 1192 */         Set<String> loadedProps = ((EntityBean)cacheBean)._ebean_getIntercept().getLoadedProps();
/* 1193 */         if (loadedProps == null || loadedProps.contains(lazyLoadProperty)) {
/*      */           
/* 1195 */           refreshFromCacheBean(ebi, cacheBean, true);
/* 1196 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1200 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void refreshFromCacheBean(EntityBeanIntercept ebi, Object cacheBean, boolean isLazyLoad) {
/* 1207 */     (new BeanRefreshFromCacheHelp(this, ebi, cacheBean, isLazyLoad)).refresh();
/*      */   }
/*      */   
/*      */   public void preAllocateIds(int batchSize) {
/* 1211 */     if (this.idGenerator != null) {
/* 1212 */       this.idGenerator.preAllocateIds(batchSize);
/*      */     }
/*      */   }
/*      */   
/*      */   public Object nextId(Transaction t) {
/* 1217 */     if (this.idGenerator != null) {
/* 1218 */       return this.idGenerator.nextId(t);
/*      */     }
/* 1220 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public DeployPropertyParser createDeployPropertyParser() {
/* 1225 */     return new DeployPropertyParser(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String convertOrmUpdateToSql(String ormUpdateStatement) {
/* 1233 */     return (new DeployUpdateParser(this)).parse(ormUpdateStatement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearQueryStatistics() {
/* 1240 */     Iterator<CQueryPlan> it = this.queryPlanCache.values().iterator();
/* 1241 */     while (it.hasNext()) {
/* 1242 */       CQueryPlan queryPlan = it.next();
/* 1243 */       queryPlan.resetStatistics();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void postLoad(Object bean, Set<String> includedProperties) {
/* 1252 */     BeanPersistController c = this.persistController;
/* 1253 */     if (c != null) {
/* 1254 */       c.postLoad(bean, includedProperties);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<CQueryPlan> queryPlans() {
/* 1262 */     return this.queryPlanCache.values().iterator();
/*      */   }
/*      */   
/*      */   public CQueryPlan getQueryPlan(Integer key) {
/* 1266 */     return this.queryPlanCache.get(key);
/*      */   }
/*      */   
/*      */   public void putQueryPlan(Integer key, CQueryPlan plan) {
/* 1270 */     this.queryPlanCache.put(key, plan);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SpiUpdatePlan getUpdatePlan(Integer key) {
/* 1277 */     return this.updatePlanCache.get(key);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void putUpdatePlan(Integer key, SpiUpdatePlan plan) {
/* 1284 */     this.updatePlanCache.put(key, plan);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TypeManager getTypeManager() {
/* 1291 */     return this.typeManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUpdateChangesOnly() {
/* 1299 */     return this.updateChangesOnly;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSaveRecurseSkippable() {
/* 1307 */     return this.saveRecurseSkippable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDeleteRecurseSkippable() {
/* 1315 */     return this.deleteRecurseSkippable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasLocalValidation() {
/* 1322 */     return this.hasLocalValidation;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasCascadeValidation() {
/* 1329 */     return this.hasCascadeValidation;
/*      */   }
/*      */ 
/*      */   
/*      */   public InvalidValue validate(boolean cascade, Object bean) {
/* 1334 */     if (!this.hasCascadeValidation)
/*      */     {
/* 1336 */       return null;
/*      */     }
/*      */     
/* 1339 */     List<InvalidValue> errList = null;
/*      */     
/* 1341 */     Set<String> loadedProps = null;
/* 1342 */     if (bean instanceof EntityBean) {
/* 1343 */       EntityBeanIntercept ebi = ((EntityBean)bean)._ebean_getIntercept();
/* 1344 */       loadedProps = ebi.getLoadedProps();
/*      */     } 
/* 1346 */     if (loadedProps != null) {
/*      */       
/* 1348 */       Iterator<String> propIt = loadedProps.iterator();
/* 1349 */       while (propIt.hasNext()) {
/* 1350 */         String propName = propIt.next();
/* 1351 */         BeanProperty property = getBeanProperty(propName);
/*      */ 
/*      */         
/* 1354 */         if (property != null && property.hasValidationRules(cascade)) {
/* 1355 */           Object value = property.getValue(bean);
/* 1356 */           List<InvalidValue> errs = property.validate(cascade, value);
/* 1357 */           if (errs != null) {
/* 1358 */             if (errList == null) {
/* 1359 */               errList = new ArrayList<InvalidValue>();
/*      */             }
/* 1361 */             errList.addAll(errs);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*      */       
/* 1367 */       BeanProperty[] props = cascade ? this.propertiesValidationCascade : this.propertiesValidationLocal;
/*      */ 
/*      */       
/* 1370 */       for (int j = 0; j < props.length; j++) {
/* 1371 */         BeanProperty prop = props[j];
/* 1372 */         Object value = prop.getValue(bean);
/* 1373 */         List<InvalidValue> errs = prop.validate(cascade, value);
/* 1374 */         if (errs != null) {
/* 1375 */           if (errList == null) {
/* 1376 */             errList = new ArrayList<InvalidValue>();
/*      */           }
/* 1378 */           errList.addAll(errs);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1383 */     for (int i = 0; i < this.beanValidators.length; i++) {
/* 1384 */       if (!this.beanValidators[i].isValid(bean)) {
/* 1385 */         if (errList == null) {
/* 1386 */           errList = new ArrayList<InvalidValue>();
/*      */         }
/* 1388 */         Validator v = this.beanValidators[i];
/* 1389 */         errList.add(new InvalidValue(v.getKey(), v.getAttributes(), getFullName(), null, bean));
/*      */       } 
/*      */     } 
/*      */     
/* 1393 */     if (errList == null) {
/* 1394 */       return null;
/*      */     }
/*      */     
/* 1397 */     return new InvalidValue(null, getFullName(), bean, InvalidValue.toArray(errList));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocMany<?> getManyProperty(SpiQuery<?> query) {
/* 1405 */     OrmQueryDetail detail = query.getDetail();
/* 1406 */     for (int i = 0; i < this.propertiesMany.length; i++) {
/* 1407 */       if (detail.includes(this.propertiesMany[i].getName())) {
/* 1408 */         return this.propertiesMany[i];
/*      */       }
/*      */     } 
/*      */     
/* 1412 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IdBinder getIdBinder() {
/* 1420 */     return this.idBinder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getIdBinderIdSql() {
/* 1428 */     return this.idBinderIdSql;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getIdBinderInLHSSql() {
/* 1435 */     return this.idBinderInLHSSql;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void bindId(DataBind dataBind, Object idValue) throws SQLException {
/* 1445 */     this.idBinder.bindId(dataBind, idValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object[] getBindIdValues(Object idValue) {
/* 1455 */     return this.idBinder.getBindValues(idValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DeployNamedQuery getNamedQuery(String name) {
/* 1462 */     return this.namedQueries.get(name);
/*      */   }
/*      */   
/*      */   public DeployNamedQuery addNamedQuery(DeployNamedQuery deployNamedQuery) {
/* 1466 */     return this.namedQueries.put(deployNamedQuery.getName(), deployNamedQuery);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DeployNamedUpdate getNamedUpdate(String name) {
/* 1473 */     return this.namedUpdates.get(name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object createBean(boolean vanillaMode) {
/* 1480 */     return vanillaMode ? createVanillaBean() : createEntityBean();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object createVanillaBean() {
/* 1490 */     return this.beanReflect.createVanillaBean();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityBean createEntityBean() {
/*      */     try {
/* 1499 */       EntityBean eb = (EntityBean)this.beanReflect.createEntityBean();
/*      */       
/* 1501 */       return eb;
/*      */     }
/* 1503 */     catch (Exception ex) {
/* 1504 */       throw new PersistenceException(ex);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public T createReference(boolean vanillaMode, Object id, Object parent, ReferenceOptions options) {
/*      */     try {
/* 1515 */       Object bean = createBean(vanillaMode);
/*      */       
/* 1517 */       convertSetId(id, bean);
/*      */       
/* 1519 */       if (!vanillaMode) {
/* 1520 */         EntityBean eb = (EntityBean)bean;
/*      */         
/* 1522 */         EntityBeanIntercept ebi = eb._ebean_getIntercept();
/* 1523 */         ebi.setBeanLoader(0, (BeanLoader)this.ebeanServer);
/*      */         
/* 1525 */         if (parent != null)
/*      */         {
/*      */           
/* 1528 */           ebi.setParentBean(parent);
/*      */         }
/*      */         
/* 1531 */         if (options != null) {
/* 1532 */           ebi.setUseCache(options.isUseCache());
/* 1533 */           ebi.setReadOnly(options.isReadOnly());
/*      */         } 
/*      */ 
/*      */         
/* 1537 */         ebi.setReference();
/*      */       } 
/*      */       
/* 1540 */       return (T)bean;
/*      */     }
/* 1542 */     catch (Exception ex) {
/* 1543 */       throw new PersistenceException(ex);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty getBeanPropertyFromDbColumn(String dbColumn) {
/* 1551 */     return this.propMapByDbColumn.get(dbColumn);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty getBeanPropertyFromPath(String path) {
/* 1560 */     String[] split = SplitName.splitBegin(path);
/* 1561 */     if (split[1] == null) {
/* 1562 */       return _findBeanProperty(split[0]);
/*      */     }
/* 1564 */     BeanPropertyAssoc<?> assocProp = (BeanPropertyAssoc)_findBeanProperty(split[0]);
/* 1565 */     BeanDescriptor<?> targetDesc = assocProp.getTargetDescriptor();
/*      */     
/* 1567 */     return targetDesc.getBeanPropertyFromPath(split[1]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanDescriptor<?> getBeanDescriptor(String path) {
/* 1575 */     if (path == null) {
/* 1576 */       return this;
/*      */     }
/* 1578 */     String[] splitBegin = SplitName.splitBegin(path);
/*      */     
/* 1580 */     BeanProperty beanProperty = this.propMap.get(splitBegin[0]);
/* 1581 */     if (beanProperty instanceof BeanPropertyAssoc) {
/* 1582 */       BeanPropertyAssoc<?> assocProp = (BeanPropertyAssoc)beanProperty;
/* 1583 */       return assocProp.getTargetDescriptor().getBeanDescriptor(splitBegin[1]);
/*      */     } 
/*      */     
/* 1586 */     throw new RuntimeException("Error getting BeanDescriptor for path " + path + " from " + getFullName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <U> BeanDescriptor<U> getBeanDescriptor(Class<U> otherType) {
/* 1594 */     return this.owner.getBeanDescriptor(otherType);
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
/*      */   public BeanPropertyAssocOne<?> getUnidirectional() {
/* 1606 */     if (this.unidirectional != null) {
/* 1607 */       return this.unidirectional;
/*      */     }
/* 1609 */     if (this.inheritInfo != null && !this.inheritInfo.isRoot()) {
/* 1610 */       return this.inheritInfo.getParent().getBeanDescriptor().getUnidirectional();
/*      */     }
/* 1612 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getValue(Object bean, String property) {
/* 1619 */     return getBeanProperty(property).getValue(bean);
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
/* 1630 */     return (this.idGenerator != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDescriptorId() {
/* 1638 */     return this.descriptorId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<T> getBeanType() {
/* 1645 */     return this.beanType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<?> getFactoryType() {
/* 1652 */     return this.factoryType;
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
/* 1663 */     return this.fullName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/* 1670 */     return this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1677 */     return this.fullName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getId(Object bean) {
/* 1688 */     if (this.propertySingleId != null) {
/* 1689 */       if (this.inheritInfo != null && !this.enhancedBean)
/*      */       {
/* 1691 */         return this.propertySingleId.getValueViaReflection(bean);
/*      */       }
/*      */       
/* 1694 */       return this.propertySingleId.getValue(bean);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1700 */     LinkedHashMap<String, Object> idMap = new LinkedHashMap<String, Object>();
/* 1701 */     for (int i = 0; i < this.propertiesId.length; i++) {
/*      */       
/* 1703 */       Object value = this.propertiesId[i].getValue(bean);
/* 1704 */       idMap.put(this.propertiesId[i].getName(), value);
/*      */     } 
/* 1706 */     return idMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isComplexId() {
/* 1714 */     return this.idBinder.isComplexId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefaultOrderBy() {
/* 1722 */     return this.idBinder.getDefaultOrderBy();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object convertId(Object idValue) {
/* 1729 */     return this.idBinder.convertSetId(idValue, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object convertSetId(Object idValue, Object bean) {
/* 1740 */     return this.idBinder.convertSetId(idValue, bean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty getBeanProperty(String propName) {
/* 1747 */     return this.propMap.get(propName);
/*      */   }
/*      */ 
/*      */   
/*      */   public void sort(List<T> list, String sortByClause) {
/* 1752 */     ElComparator<T> comparator = getElComparator(sortByClause);
/* 1753 */     Collections.sort(list, (Comparator<? super T>)comparator);
/*      */   }
/*      */   
/*      */   public ElComparator<T> getElComparator(String propNameOrSortBy) {
/* 1757 */     ElComparator<T> c = this.comparatorCache.get(propNameOrSortBy);
/* 1758 */     if (c == null) {
/* 1759 */       c = createComparator(propNameOrSortBy);
/* 1760 */       this.comparatorCache.put(propNameOrSortBy, c);
/*      */     } 
/* 1762 */     return c;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean lazyLoadMany(EntityBeanIntercept ebi) {
/* 1771 */     String lazyLoadProperty = ebi.getLazyLoadProperty();
/* 1772 */     BeanProperty lazyLoadBeanProp = getBeanProperty(lazyLoadProperty);
/*      */     
/* 1774 */     if (lazyLoadBeanProp instanceof BeanPropertyAssocMany) {
/* 1775 */       BeanPropertyAssocMany<?> manyProp = (BeanPropertyAssocMany)lazyLoadBeanProp;
/* 1776 */       manyProp.createReference(ebi.getOwner());
/* 1777 */       Set<String> loadedProps = ebi.getLoadedProps();
/* 1778 */       HashSet<String> newLoadedProps = new HashSet<String>();
/* 1779 */       if (loadedProps != null) {
/* 1780 */         newLoadedProps.addAll(loadedProps);
/*      */       }
/* 1782 */       newLoadedProps.add(lazyLoadProperty);
/* 1783 */       ebi.setLoadedProps(newLoadedProps);
/* 1784 */       ebi.setLoadedLazy();
/* 1785 */       return true;
/*      */     } 
/*      */     
/* 1788 */     return false;
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
/*      */   private ElComparator<T> createComparator(String sortByClause) {
/* 1800 */     SortByClause sortBy = SortByClauseParser.parse(sortByClause);
/* 1801 */     if (sortBy.size() == 1)
/*      */     {
/* 1803 */       return createPropertyComparator(sortBy.getProperties().get(0));
/*      */     }
/*      */ 
/*      */     
/* 1807 */     ElComparator[] arrayOfElComparator = new ElComparator[sortBy.size()];
/*      */     
/* 1809 */     List<SortByClause.Property> sortProps = sortBy.getProperties();
/* 1810 */     for (int i = 0; i < sortProps.size(); i++) {
/* 1811 */       SortByClause.Property sortProperty = sortProps.get(i);
/* 1812 */       arrayOfElComparator[i] = createPropertyComparator(sortProperty);
/*      */     } 
/*      */     
/* 1815 */     return (ElComparator<T>)new ElComparatorCompound(arrayOfElComparator);
/*      */   }
/*      */ 
/*      */   
/*      */   private ElComparator<T> createPropertyComparator(SortByClause.Property sortProp) {
/* 1820 */     ElPropertyValue elGetValue = getElGetValue(sortProp.getName());
/*      */     
/* 1822 */     Boolean nullsHigh = sortProp.getNullsHigh();
/* 1823 */     if (nullsHigh == null) {
/* 1824 */       nullsHigh = Boolean.TRUE;
/*      */     }
/* 1826 */     return (ElComparator<T>)new ElComparatorProperty(elGetValue, sortProp.isAscending(), nullsHigh.booleanValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ElPropertyValue getElGetValue(String propName) {
/* 1833 */     return getElPropertyValue(propName, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ElPropertyDeploy getElPropertyDeploy(String propName) {
/* 1843 */     ElPropertyDeploy fk = (ElPropertyDeploy)this.fkeyMap.get(propName);
/* 1844 */     if (fk != null) {
/* 1845 */       return fk;
/*      */     }
/* 1847 */     return (ElPropertyDeploy)getElPropertyValue(propName, true);
/*      */   }
/*      */   
/*      */   private ElPropertyValue getElPropertyValue(String propName, boolean propertyDeploy) {
/* 1851 */     ElPropertyValue elGetValue = this.elGetCache.get(propName);
/* 1852 */     if (elGetValue == null) {
/*      */       
/* 1854 */       elGetValue = buildElGetValue(propName, null, propertyDeploy);
/* 1855 */       if (elGetValue == null) {
/* 1856 */         return null;
/*      */       }
/* 1858 */       if (elGetValue instanceof BeanFkeyProperty) {
/* 1859 */         this.fkeyMap.put(propName, (BeanFkeyProperty)elGetValue);
/*      */       } else {
/* 1861 */         this.elGetCache.put(propName, elGetValue);
/*      */       } 
/*      */     } 
/* 1864 */     return elGetValue;
/*      */   }
/*      */ 
/*      */   
/*      */   protected ElPropertyValue buildElGetValue(String propName, ElPropertyChainBuilder chain, boolean propertyDeploy) {
/* 1869 */     if (propertyDeploy && chain != null) {
/* 1870 */       BeanFkeyProperty fk = this.fkeyMap.get(propName);
/* 1871 */       if (fk != null) {
/* 1872 */         return fk.create(chain.getExpression());
/*      */       }
/*      */     } 
/*      */     
/* 1876 */     int basePos = propName.indexOf('.');
/* 1877 */     if (basePos > -1) {
/*      */       
/* 1879 */       String baseName = propName.substring(0, basePos);
/* 1880 */       String remainder = propName.substring(basePos + 1);
/*      */       
/* 1882 */       BeanProperty assocProp = _findBeanProperty(baseName);
/* 1883 */       if (assocProp == null) {
/* 1884 */         return null;
/*      */       }
/* 1886 */       return assocProp.buildElPropertyValue(propName, remainder, chain, propertyDeploy);
/*      */     } 
/*      */     
/* 1889 */     BeanProperty property = _findBeanProperty(propName);
/* 1890 */     if (chain == null) {
/* 1891 */       return property;
/*      */     }
/* 1893 */     if (property == null) {
/* 1894 */       throw new PersistenceException("No property found for [" + propName + "] in expression " + chain.getExpression());
/*      */     }
/*      */     
/* 1897 */     if (property.containsMany()) {
/* 1898 */       chain.setContainsMany(true);
/*      */     }
/* 1900 */     return (ElPropertyValue)chain.add(property).build();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty findBeanProperty(String propName) {
/* 1911 */     int basePos = propName.indexOf('.');
/* 1912 */     if (basePos > -1) {
/*      */       
/* 1914 */       String baseName = propName.substring(0, basePos);
/* 1915 */       return _findBeanProperty(baseName);
/*      */     } 
/*      */     
/* 1918 */     return _findBeanProperty(propName);
/*      */   }
/*      */   
/*      */   private BeanProperty _findBeanProperty(String propName) {
/* 1922 */     BeanProperty prop = this.propMap.get(propName);
/* 1923 */     if (prop == null && this.inheritInfo != null)
/*      */     {
/* 1925 */       return this.inheritInfo.findSubTypeProperty(propName);
/*      */     }
/* 1927 */     return prop;
/*      */   }
/*      */ 
/*      */   
/*      */   protected Object getBeanPropertyWithInheritance(Object bean, String propName) {
/* 1932 */     BeanDescriptor<?> desc = getBeanDescriptor(bean.getClass());
/* 1933 */     BeanProperty beanProperty = desc.findBeanProperty(propName);
/* 1934 */     return beanProperty.getValue(bean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getServerName() {
/* 1941 */     return this.serverName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAutoFetchTunable() {
/* 1948 */     return this.autoFetchTunable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InheritInfo getInheritInfo() {
/* 1956 */     return this.inheritInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmbedded() {
/* 1963 */     return EntityType.EMBEDDED.equals(this.entityType);
/*      */   }
/*      */   
/*      */   public boolean isBaseTableType() {
/* 1967 */     return EntityType.ORM.equals(this.entityType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ConcurrencyMode getConcurrencyMode() {
/* 1974 */     return this.concurrencyMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getDependantTables() {
/* 1982 */     return this.dependantTables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompoundUniqueContraint[] getCompoundUniqueConstraints() {
/* 1989 */     return this.compoundUniqueConstraints;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPersistListener<T> getPersistListener() {
/* 1996 */     return this.persistListener;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanFinder<T> getBeanFinder() {
/* 2003 */     return this.beanFinder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanQueryAdapter getQueryAdapter() {
/* 2010 */     return this.queryAdapter;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deregister(BeanPersistListener<?> listener) {
/* 2019 */     BeanPersistListener<T> currListener = this.persistListener;
/* 2020 */     if (currListener != null) {
/*      */ 
/*      */       
/* 2023 */       BeanPersistListener<T> deregListener = (BeanPersistListener)listener;
/* 2024 */       if (currListener instanceof ChainedBeanPersistListener) {
/*      */         
/* 2026 */         this.persistListener = ((ChainedBeanPersistListener<T>)currListener).deregister(deregListener);
/* 2027 */       } else if (currListener.equals(deregListener)) {
/* 2028 */         this.persistListener = null;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void deregister(BeanPersistController controller) {
/* 2038 */     BeanPersistController c = this.persistController;
/* 2039 */     if (c != null)
/*      */     {
/*      */       
/* 2042 */       if (c instanceof ChainedBeanPersistController) {
/*      */         
/* 2044 */         this.persistController = ((ChainedBeanPersistController)c).deregister(controller);
/* 2045 */       } else if (c.equals(controller)) {
/* 2046 */         this.persistController = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void register(BeanPersistListener<?> newPersistListener) {
/* 2057 */     if (PersistListenerManager.isRegisterFor(this.beanType, newPersistListener)) {
/*      */ 
/*      */       
/* 2060 */       BeanPersistListener<T> newListener = (BeanPersistListener)newPersistListener;
/*      */       
/* 2062 */       BeanPersistListener<T> currListener = this.persistListener;
/* 2063 */       if (currListener == null) {
/* 2064 */         this.persistListener = newListener;
/*      */       }
/* 2066 */       else if (currListener instanceof ChainedBeanPersistListener) {
/*      */         
/* 2068 */         this.persistListener = ((ChainedBeanPersistListener<T>)currListener).register(newListener);
/*      */       } else {
/*      */         
/* 2071 */         this.persistListener = new ChainedBeanPersistListener<T>(currListener, newListener);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void register(BeanPersistController newController) {
/* 2082 */     if (newController.isRegisterFor(this.beanType)) {
/*      */ 
/*      */ 
/*      */       
/* 2086 */       BeanPersistController c = this.persistController;
/* 2087 */       if (c == null) {
/* 2088 */         this.persistController = newController;
/*      */       }
/* 2090 */       else if (c instanceof ChainedBeanPersistController) {
/*      */         
/* 2092 */         this.persistController = ((ChainedBeanPersistController)c).register(newController);
/*      */       } else {
/*      */         
/* 2095 */         this.persistController = new ChainedBeanPersistController(c, newController);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPersistController getPersistController() {
/* 2105 */     return this.persistController;
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
/*      */   public boolean isSqlSelectBased() {
/* 2117 */     return EntityType.SQL.equals(this.entityType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLdapEntityType() {
/* 2124 */     return EntityType.LDAP.equals(this.entityType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getBaseTable() {
/* 2132 */     return this.baseTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExtraAttribute(String key) {
/* 2139 */     return this.extraAttrMap.get(key);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IdType getIdType() {
/* 2146 */     return this.idType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSequenceName() {
/* 2153 */     return this.sequenceName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSelectLastInsertedId() {
/* 2164 */     return this.selectLastInsertedId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IdGenerator getIdGenerator() {
/* 2171 */     return this.idGenerator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLazyFetchIncludes() {
/* 2178 */     return this.lazyFetchIncludes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TableJoin[] tableJoins() {
/* 2188 */     return this.derivedTableJoins;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<BeanProperty> propertiesAll() {
/* 2196 */     return this.propMap.values().iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty[] propertiesId() {
/* 2207 */     return this.propertiesId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty[] propertiesNonTransient() {
/* 2214 */     return this.propertiesNonTransient;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty[] propertiesTransient() {
/* 2221 */     return this.propertiesTransient;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty getSingleIdProperty() {
/* 2229 */     return this.propertySingleId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocOne<?>[] propertiesEmbedded() {
/* 2237 */     return this.propertiesEmbedded;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocOne<?>[] propertiesOne() {
/* 2245 */     return this.propertiesOne;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocOne<?>[] propertiesOneImported() {
/* 2255 */     return this.propertiesOneImported;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocOne<?>[] propertiesOneImportedSave() {
/* 2262 */     return this.propertiesOneImportedSave;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocOne<?>[] propertiesOneImportedDelete() {
/* 2269 */     return this.propertiesOneImportedDelete;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocOne<?>[] propertiesOneExported() {
/* 2279 */     return this.propertiesOneExported;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocOne<?>[] propertiesOneExportedSave() {
/* 2286 */     return this.propertiesOneExportedSave;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocOne<?>[] propertiesOneExportedDelete() {
/* 2293 */     return this.propertiesOneExportedDelete;
/*      */   }
/*      */ 
/*      */   
/*      */   private Set<String> deriveManyPropNames() {
/* 2298 */     LinkedHashSet<String> names = new LinkedHashSet<String>();
/* 2299 */     for (int i = 0; i < this.propertiesMany.length; i++) {
/* 2300 */       names.add(this.propertiesMany[i].getName());
/*      */     }
/*      */     
/* 2303 */     return Collections.unmodifiableSet(names);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNamesOfManyPropsHash() {
/* 2312 */     return this.namesOfManyPropsHash;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> getNamesOfManyProps() {
/* 2319 */     return this.namesOfManyProps;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocMany<?>[] propertiesMany() {
/* 2326 */     return this.propertiesMany;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocMany<?>[] propertiesManySave() {
/* 2333 */     return this.propertiesManySave;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocMany<?>[] propertiesManyDelete() {
/* 2340 */     return this.propertiesManyDelete;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyAssocMany<?>[] propertiesManyToMany() {
/* 2347 */     return this.propertiesManyToMany;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty firstVersionProperty() {
/* 2358 */     return this.propertyFirstVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isVanillaInsert(Object bean) {
/* 2365 */     if (this.propertyFirstVersion == null) {
/* 2366 */       return true;
/*      */     }
/* 2368 */     Object versionValue = this.propertyFirstVersion.getValue(bean);
/* 2369 */     return DmlUtil.isNullOrZero(versionValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStatelessUpdate(Object bean) {
/* 2377 */     if (this.propertyFirstVersion == null) {
/* 2378 */       Object object = getId(bean);
/* 2379 */       return !DmlUtil.isNullOrZero(object);
/*      */     } 
/* 2381 */     Object versionValue = this.propertyFirstVersion.getValue(bean);
/* 2382 */     return !DmlUtil.isNullOrZero(versionValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty[] propertiesVersion() {
/* 2392 */     return this.propertiesVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty[] propertiesBaseScalar() {
/* 2399 */     return this.propertiesBaseScalar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanPropertyCompound[] propertiesBaseCompound() {
/* 2409 */     return this.propertiesBaseCompound;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanProperty[] propertiesLocal() {
/* 2416 */     return this.propertiesLocal;
/*      */   }
/*      */ 
/*      */   
/*      */   public void jsonWrite(WriteJsonContext ctx, Object bean) {
/* 2421 */     if (bean != null) {
/*      */       
/* 2423 */       ctx.appendObjectBegin();
/* 2424 */       WriteJsonContext.WriteBeanState prevState = ctx.pushBeanState(bean);
/*      */       
/* 2426 */       if (this.inheritInfo != null) {
/* 2427 */         InheritInfo localInheritInfo = this.inheritInfo.readType(bean.getClass());
/* 2428 */         String discValue = localInheritInfo.getDiscriminatorStringValue();
/* 2429 */         String discColumn = localInheritInfo.getDiscriminatorColumn();
/* 2430 */         ctx.appendKeyValue(discColumn, "\"" + discValue + "\"");
/*      */         
/* 2432 */         BeanDescriptor<?> localDescriptor = localInheritInfo.getBeanDescriptor();
/* 2433 */         localDescriptor.jsonWriteProperties(ctx, bean);
/*      */       } else {
/*      */         
/* 2436 */         jsonWriteProperties(ctx, bean);
/*      */       } 
/*      */       
/* 2439 */       ctx.pushPreviousState(prevState);
/* 2440 */       ctx.appendObjectEnd();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jsonWriteProperties(WriteJsonContext ctx, Object bean) {
/* 2448 */     boolean explicitAllProps, referenceBean = ctx.isReferenceBean();
/*      */     
/* 2450 */     JsonWriteBeanVisitor<T> beanVisitor = ctx.getBeanVisitor();
/*      */     
/* 2452 */     Set<String> props = ctx.getIncludeProperties();
/*      */ 
/*      */     
/* 2455 */     if (props == null) {
/* 2456 */       explicitAllProps = false;
/*      */     } else {
/* 2458 */       explicitAllProps = props.contains("*");
/* 2459 */       if (explicitAllProps || props.isEmpty()) {
/* 2460 */         props = null;
/*      */       }
/*      */     } 
/*      */     
/* 2464 */     for (int i = 0; i < this.propertiesId.length; i++) {
/* 2465 */       Object idValue = this.propertiesId[i].getValue(bean);
/* 2466 */       if (idValue != null && (
/* 2467 */         props == null || props.contains(this.propertiesId[i].getName()))) {
/* 2468 */         this.propertiesId[i].jsonWrite(ctx, bean);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2473 */     if (!explicitAllProps && props == null) {
/* 2474 */       props = ctx.getLoadedProps();
/*      */     }
/* 2476 */     if (props != null) {
/* 2477 */       for (String prop : props) {
/* 2478 */         BeanProperty p = getBeanProperty(prop);
/* 2479 */         if (!p.isId()) {
/* 2480 */           p.jsonWrite(ctx, bean);
/*      */         }
/*      */       }
/*      */     
/* 2484 */     } else if (!referenceBean) {
/* 2485 */       for (int j = 0; j < this.propertiesNonTransient.length; j++) {
/* 2486 */         this.propertiesNonTransient[j].jsonWrite(ctx, bean);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2491 */     if (beanVisitor != null) {
/* 2492 */       beanVisitor.visit(bean, (JsonWriter)ctx);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public T jsonReadBean(ReadJsonContext ctx, String path) {
/* 2498 */     ReadJsonContext.ReadBeanState beanState = jsonRead(ctx, path);
/* 2499 */     if (beanState == null) {
/* 2500 */       return null;
/*      */     }
/* 2502 */     beanState.setLoadedState();
/* 2503 */     return (T)beanState.getBean();
/*      */   }
/*      */ 
/*      */   
/*      */   public ReadJsonContext.ReadBeanState jsonRead(ReadJsonContext ctx, String path) {
/* 2508 */     if (!ctx.readObjectBegin())
/*      */     {
/* 2510 */       return null;
/*      */     }
/*      */     
/* 2513 */     if (this.inheritInfo == null) {
/* 2514 */       return jsonReadObject(ctx, path);
/*      */     }
/*      */ 
/*      */     
/* 2518 */     String discColumn = this.inheritInfo.getRoot().getDiscriminatorColumn();
/*      */     
/* 2520 */     if (!ctx.readKeyNext()) {
/* 2521 */       String msg = "Error reading inheritance discriminator - expected [" + discColumn + "] but no json key?";
/* 2522 */       throw new TextException(msg);
/*      */     } 
/* 2524 */     String propName = ctx.getTokenKey();
/*      */     
/* 2526 */     if (!propName.equalsIgnoreCase(discColumn)) {
/* 2527 */       String msg = "Error reading inheritance discriminator - expected [" + discColumn + "] but read [" + propName + "]";
/* 2528 */       throw new TextException(msg);
/*      */     } 
/*      */     
/* 2531 */     String discValue = ctx.readScalarValue();
/* 2532 */     if (!ctx.readValueNext()) {
/* 2533 */       String msg = "Error reading inheritance discriminator [" + discColumn + "]. Expected more json name values?";
/* 2534 */       throw new TextException(msg);
/*      */     } 
/*      */ 
/*      */     
/* 2538 */     InheritInfo localInheritInfo = this.inheritInfo.readType(discValue);
/* 2539 */     BeanDescriptor<?> localDescriptor = localInheritInfo.getBeanDescriptor();
/* 2540 */     return localDescriptor.jsonReadObject(ctx, path);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ReadJsonContext.ReadBeanState jsonReadObject(ReadJsonContext ctx, String path) {
/* 2547 */     EntityBean entityBean = createEntityBean();
/* 2548 */     ctx.pushBean(entityBean, path, this);
/*      */ 
/*      */     
/* 2551 */     while (ctx.readKeyNext()) {
/*      */ 
/*      */ 
/*      */       
/* 2555 */       String propName = ctx.getTokenKey();
/* 2556 */       BeanProperty p = getBeanProperty(propName);
/* 2557 */       if (p != null) {
/* 2558 */         p.jsonRead(ctx, entityBean);
/* 2559 */         ctx.setProperty(propName);
/*      */       } else {
/*      */         
/* 2562 */         ctx.readUnmappedJson(propName);
/*      */       } 
/*      */       
/* 2565 */       if (!ctx.readValueNext()) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2571 */     return ctx.popBeanState();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLoadedProps(EntityBeanIntercept ebi, Set<String> loadedProps) {
/* 2579 */     if (isLoadedReference(loadedProps)) {
/* 2580 */       ebi.setReference();
/*      */     } else {
/* 2582 */       ebi.setLoadedProps(loadedProps);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLoadedReference(Set<String> loadedProps) {
/* 2592 */     if (loadedProps != null && 
/* 2593 */       loadedProps.size() == this.propertiesId.length) {
/* 2594 */       for (int i = 0; i < this.propertiesId.length; i++) {
/* 2595 */         if (!loadedProps.contains(this.propertiesId[i].getName())) {
/* 2596 */           return false;
/*      */         }
/*      */       } 
/* 2599 */       return true;
/*      */     } 
/*      */ 
/*      */     
/* 2603 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\BeanDescriptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */