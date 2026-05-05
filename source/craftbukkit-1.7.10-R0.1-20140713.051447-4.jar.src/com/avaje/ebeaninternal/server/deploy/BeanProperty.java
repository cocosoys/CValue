/*      */ package com.avaje.ebeaninternal.server.deploy;
/*      */ 
/*      */ import com.avaje.ebean.InvalidValue;
/*      */ import com.avaje.ebean.config.EncryptKey;
/*      */ import com.avaje.ebean.config.dbplatform.DbEncryptFunction;
/*      */ import com.avaje.ebean.config.dbplatform.DbType;
/*      */ import com.avaje.ebean.config.ldap.LdapAttributeAdapter;
/*      */ import com.avaje.ebean.config.lucene.LuceneIndex;
/*      */ import com.avaje.ebean.text.StringFormatter;
/*      */ import com.avaje.ebean.text.StringParser;
/*      */ import com.avaje.ebean.validation.factory.Validator;
/*      */ import com.avaje.ebeaninternal.server.core.InternString;
/*      */ import com.avaje.ebeaninternal.server.deploy.generatedproperty.GeneratedProperty;
/*      */ import com.avaje.ebeaninternal.server.deploy.meta.DeployBeanProperty;
/*      */ import com.avaje.ebeaninternal.server.el.ElPropertyChainBuilder;
/*      */ import com.avaje.ebeaninternal.server.el.ElPropertyValue;
/*      */ import com.avaje.ebeaninternal.server.ldap.LdapPersistenceException;
/*      */ import com.avaje.ebeaninternal.server.lib.util.StringHelper;
/*      */ import com.avaje.ebeaninternal.server.query.SqlBeanLoad;
/*      */ import com.avaje.ebeaninternal.server.reflect.BeanReflectGetter;
/*      */ import com.avaje.ebeaninternal.server.reflect.BeanReflectSetter;
/*      */ import com.avaje.ebeaninternal.server.text.json.ReadJsonContext;
/*      */ import com.avaje.ebeaninternal.server.text.json.WriteJsonContext;
/*      */ import com.avaje.ebeaninternal.server.type.DataBind;
/*      */ import com.avaje.ebeaninternal.server.type.ScalarType;
/*      */ import com.avaje.ebeaninternal.util.ValueUtil;
/*      */ import java.io.DataInput;
/*      */ import java.io.DataOutput;
/*      */ import java.io.IOException;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Method;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.naming.NamingException;
/*      */ import javax.naming.directory.Attribute;
/*      */ import javax.naming.directory.BasicAttribute;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class BeanProperty
/*      */   implements ElPropertyValue
/*      */ {
/*      */   public static final String EXCLUDE_FROM_UPDATE_WHERE = "EXCLUDE_FROM_UPDATE_WHERE";
/*      */   public static final String EXCLUDE_FROM_DELETE_WHERE = "EXCLUDE_FROM_DELETE_WHERE";
/*      */   public static final String EXCLUDE_FROM_INSERT = "EXCLUDE_FROM_INSERT";
/*      */   public static final String EXCLUDE_FROM_UPDATE = "EXCLUDE_FROM_UPDATE";
/*      */   final boolean id;
/*      */   final boolean unidirectionalShadow;
/*      */   final boolean embedded;
/*      */   final boolean version;
/*      */   final boolean nullable;
/*      */   final boolean unique;
/*      */   final boolean dbRead;
/*      */   final boolean dbInsertable;
/*      */   final boolean dbUpdatable;
/*      */   final boolean secondaryTable;
/*      */   final TableJoin secondaryTableJoin;
/*      */   final String secondaryTableJoinPrefix;
/*      */   final boolean inherited;
/*      */   final Class<?> owningType;
/*      */   final boolean local;
/*      */   final boolean lob;
/*      */   final boolean fetchEager;
/*      */   final boolean isTransient;
/*      */   final String name;
/*      */   final Field field;
/*      */   final Class<?> propertyType;
/*      */   final String dbBind;
/*      */   final String dbColumn;
/*      */   final String elPlaceHolder;
/*      */   final String elPlaceHolderEncrypted;
/*      */   final String sqlFormulaSelect;
/*      */   final String sqlFormulaJoin;
/*      */   final boolean formula;
/*      */   final boolean dbEncrypted;
/*      */   final boolean localEncrypted;
/*      */   final int dbEncryptedType;
/*      */   final int dbType;
/*      */   final Object defaultValue;
/*      */   final Map<String, String> extraAttributeMap;
/*      */   final Method readMethod;
/*      */   final Method writeMethod;
/*      */   final GeneratedProperty generatedProperty;
/*      */   final BeanReflectGetter getter;
/*      */   final BeanReflectSetter setter;
/*      */   final BeanDescriptor<?> descriptor;
/*      */   final ScalarType scalarType;
/*      */   final LdapAttributeAdapter ldapAttributeAdapter;
/*      */   final Validator[] validators;
/*      */   final boolean hasLocalValidators;
/*      */   boolean cascadeValidate;
/*      */   final int dbLength;
/*      */   final int dbScale;
/*      */   final String dbColumnDefn;
/*      */   final String dbConstraintExpression;
/*      */   final DbEncryptFunction dbEncryptFunction;
/*      */   final boolean dynamicSubclassWithInheritance;
/*      */   int deployOrder;
/*      */   
/*      */   public BeanProperty(DeployBeanProperty deploy) {
/*  290 */     this(null, null, deploy);
/*      */   }
/*      */ 
/*      */   
/*      */   public BeanProperty(BeanDescriptorMap owner, BeanDescriptor<?> descriptor, DeployBeanProperty deploy) {
/*  295 */     this.descriptor = descriptor;
/*  296 */     this.name = InternString.intern(deploy.getName());
/*  297 */     if (descriptor != null) {
/*  298 */       this.dynamicSubclassWithInheritance = (descriptor.isDynamicSubclass() && descriptor.hasInheritance());
/*      */     } else {
/*  300 */       this.dynamicSubclassWithInheritance = false;
/*      */     } 
/*  302 */     this.unidirectionalShadow = deploy.isUndirectionalShadow();
/*  303 */     this.localEncrypted = deploy.isLocalEncrypted();
/*  304 */     this.dbEncrypted = deploy.isDbEncrypted();
/*  305 */     this.dbEncryptedType = deploy.getDbEncryptedType();
/*  306 */     this.dbEncryptFunction = deploy.getDbEncryptFunction();
/*  307 */     this.dbBind = deploy.getDbBind();
/*  308 */     this.dbRead = deploy.isDbRead();
/*  309 */     this.dbInsertable = deploy.isDbInsertable();
/*  310 */     this.dbUpdatable = deploy.isDbUpdateable();
/*      */     
/*  312 */     this.secondaryTable = deploy.isSecondaryTable();
/*  313 */     if (this.secondaryTable) {
/*  314 */       this.secondaryTableJoin = new TableJoin(deploy.getSecondaryTableJoin(), null);
/*  315 */       this.secondaryTableJoinPrefix = deploy.getSecondaryTableJoinPrefix();
/*      */     } else {
/*  317 */       this.secondaryTableJoin = null;
/*  318 */       this.secondaryTableJoinPrefix = null;
/*      */     } 
/*  320 */     this.fetchEager = deploy.isFetchEager();
/*  321 */     this.isTransient = deploy.isTransient();
/*  322 */     this.nullable = deploy.isNullable();
/*  323 */     this.unique = deploy.isUnique();
/*  324 */     this.dbLength = deploy.getDbLength();
/*  325 */     this.dbScale = deploy.getDbScale();
/*  326 */     this.dbColumnDefn = InternString.intern(deploy.getDbColumnDefn());
/*  327 */     this.dbConstraintExpression = InternString.intern(deploy.getDbConstraintExpression());
/*      */     
/*  329 */     this.inherited = false;
/*  330 */     this.owningType = deploy.getOwningType();
/*  331 */     this.local = deploy.isLocal();
/*      */     
/*  333 */     this.version = deploy.isVersionColumn();
/*  334 */     this.embedded = deploy.isEmbedded();
/*  335 */     this.id = deploy.isId();
/*  336 */     this.generatedProperty = deploy.getGeneratedProperty();
/*  337 */     this.readMethod = deploy.getReadMethod();
/*  338 */     this.writeMethod = deploy.getWriteMethod();
/*  339 */     this.getter = deploy.getGetter();
/*  340 */     if (descriptor != null && this.getter == null && 
/*  341 */       !this.unidirectionalShadow) {
/*  342 */       String m = "Null Getter for: " + getFullBeanName();
/*  343 */       throw new RuntimeException(m);
/*      */     } 
/*      */     
/*  346 */     this.setter = deploy.getSetter();
/*      */     
/*  348 */     this.dbColumn = tableAliasIntern(descriptor, deploy.getDbColumn(), false, null);
/*  349 */     this.sqlFormulaJoin = InternString.intern(deploy.getSqlFormulaJoin());
/*  350 */     this.sqlFormulaSelect = InternString.intern(deploy.getSqlFormulaSelect());
/*  351 */     this.formula = (this.sqlFormulaSelect != null);
/*      */     
/*  353 */     this.extraAttributeMap = deploy.getExtraAttributeMap();
/*  354 */     this.defaultValue = deploy.getDefaultValue();
/*  355 */     this.dbType = deploy.getDbType();
/*  356 */     this.scalarType = deploy.getScalarType();
/*  357 */     this.ldapAttributeAdapter = deploy.getLdapAttributeAdapter();
/*  358 */     this.lob = isLobType(this.dbType);
/*  359 */     this.propertyType = deploy.getPropertyType();
/*  360 */     this.field = deploy.getField();
/*  361 */     this.validators = deploy.getValidators();
/*  362 */     this.hasLocalValidators = (this.validators.length > 0);
/*      */     
/*  364 */     BeanDescriptor.EntityType et = (descriptor == null) ? null : descriptor.getEntityType();
/*  365 */     this.elPlaceHolder = tableAliasIntern(descriptor, deploy.getElPlaceHolder(et), false, null);
/*  366 */     this.elPlaceHolderEncrypted = tableAliasIntern(descriptor, deploy.getElPlaceHolder(et), this.dbEncrypted, this.dbColumn);
/*      */   }
/*      */   
/*      */   private String tableAliasIntern(BeanDescriptor<?> descriptor, String s, boolean dbEncrypted, String dbColumn) {
/*  370 */     if (descriptor != null) {
/*  371 */       s = StringHelper.replaceString(s, "${ta}.", "${}");
/*  372 */       s = StringHelper.replaceString(s, "${ta}", "${}");
/*      */       
/*  374 */       if (dbEncrypted) {
/*  375 */         s = this.dbEncryptFunction.getDecryptSql(s);
/*  376 */         String namedParam = ":encryptkey_" + descriptor.getBaseTable() + "___" + dbColumn;
/*  377 */         s = StringHelper.replaceString(s, "?", namedParam);
/*      */       } 
/*      */     } 
/*  380 */     return InternString.intern(s);
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
/*      */   public BeanProperty(BeanProperty source, BeanPropertyOverride override) {
/*  392 */     this.descriptor = source.descriptor;
/*  393 */     this.name = InternString.intern(source.getName());
/*  394 */     this.dynamicSubclassWithInheritance = source.dynamicSubclassWithInheritance;
/*      */     
/*  396 */     this.dbColumn = InternString.intern(override.getDbColumn());
/*  397 */     this.sqlFormulaJoin = InternString.intern(override.getSqlFormulaJoin());
/*  398 */     this.sqlFormulaSelect = InternString.intern(override.getSqlFormulaSelect());
/*  399 */     this.formula = (this.sqlFormulaSelect != null);
/*      */     
/*  401 */     this.fetchEager = source.fetchEager;
/*  402 */     this.unidirectionalShadow = source.unidirectionalShadow;
/*  403 */     this.localEncrypted = source.isLocalEncrypted();
/*  404 */     this.isTransient = source.isTransient();
/*  405 */     this.secondaryTable = source.isSecondaryTable();
/*  406 */     this.secondaryTableJoin = source.secondaryTableJoin;
/*  407 */     this.secondaryTableJoinPrefix = source.secondaryTableJoinPrefix;
/*      */     
/*  409 */     this.dbBind = source.getDbBind();
/*  410 */     this.dbEncrypted = source.isDbEncrypted();
/*  411 */     this.dbEncryptedType = source.getDbEncryptedType();
/*  412 */     this.dbEncryptFunction = source.dbEncryptFunction;
/*  413 */     this.dbRead = source.isDbRead();
/*  414 */     this.dbInsertable = source.isDbInsertable();
/*  415 */     this.dbUpdatable = source.isDbUpdatable();
/*  416 */     this.nullable = source.isNullable();
/*  417 */     this.unique = source.isUnique();
/*  418 */     this.dbLength = source.getDbLength();
/*  419 */     this.dbScale = source.getDbScale();
/*  420 */     this.dbColumnDefn = InternString.intern(source.getDbColumnDefn());
/*  421 */     this.dbConstraintExpression = InternString.intern(source.getDbConstraintExpression());
/*      */     
/*  423 */     this.inherited = source.isInherited();
/*  424 */     this.owningType = source.owningType;
/*  425 */     this.local = this.owningType.equals(this.descriptor.getBeanType());
/*      */     
/*  427 */     this.version = source.isVersion();
/*  428 */     this.embedded = source.isEmbedded();
/*  429 */     this.id = source.isId();
/*  430 */     this.generatedProperty = source.getGeneratedProperty();
/*  431 */     this.readMethod = source.getReadMethod();
/*  432 */     this.writeMethod = source.getWriteMethod();
/*  433 */     this.getter = source.getter;
/*  434 */     this.setter = source.setter;
/*  435 */     this.extraAttributeMap = source.extraAttributeMap;
/*  436 */     this.defaultValue = source.getDefaultValue();
/*  437 */     this.dbType = source.getDbType();
/*  438 */     this.scalarType = source.scalarType;
/*  439 */     this.ldapAttributeAdapter = source.ldapAttributeAdapter;
/*  440 */     this.lob = isLobType(this.dbType);
/*  441 */     this.propertyType = source.getPropertyType();
/*  442 */     this.field = source.getField();
/*  443 */     this.validators = source.getValidators();
/*  444 */     this.hasLocalValidators = (this.validators.length > 0);
/*      */     
/*  446 */     this.elPlaceHolder = override.replace(source.elPlaceHolder, source.dbColumn);
/*  447 */     this.elPlaceHolderEncrypted = override.replace(source.elPlaceHolderEncrypted, source.dbColumn);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void initialise() {
/*  457 */     if (!this.isTransient && this.scalarType == null) {
/*  458 */       String msg = "No ScalarType assigned to " + this.descriptor.getFullName() + "." + getName();
/*  459 */       throw new RuntimeException(msg);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDeployOrder() {
/*  467 */     return this.deployOrder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDeployOrder(int deployOrder) {
/*  474 */     this.deployOrder = deployOrder;
/*      */   }
/*      */ 
/*      */   
/*      */   public ElPropertyValue buildElPropertyValue(String propName, String remainder, ElPropertyChainBuilder chain, boolean propertyDeploy) {
/*  479 */     throw new PersistenceException("Not valid on scalar bean property " + getFullBeanName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BeanDescriptor<?> getBeanDescriptor() {
/*  486 */     return this.descriptor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isScalar() {
/*  493 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFormula() {
/*  500 */     return this.formula;
/*      */   }
/*      */   
/*      */   public boolean hasChanged(Object bean, Object oldValues) {
/*  504 */     Object value = getValue(bean);
/*  505 */     Object oldVal = getValue(oldValues);
/*      */     
/*  507 */     return !ValueUtil.areEqual(value, oldVal);
/*      */   }
/*      */   
/*      */   public void copyProperty(Object sourceBean, Object destBean) {
/*  511 */     Object value = getValue(sourceBean);
/*  512 */     setValue(destBean, value);
/*      */   }
/*      */   
/*      */   public void copyProperty(Object sourceBean, Object destBean, CopyContext ctx, int maxDepth) {
/*  516 */     Object value = getValue(sourceBean);
/*  517 */     setValue(destBean, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EncryptKey getEncryptKey() {
/*  524 */     return this.descriptor.getEncryptKey(this);
/*      */   }
/*      */   
/*      */   public String getDecryptProperty() {
/*  528 */     return this.dbEncryptFunction.getDecryptSql(getName());
/*      */   }
/*      */   
/*      */   public String getDecryptProperty(String propertyName) {
/*  532 */     return this.dbEncryptFunction.getDecryptSql(propertyName);
/*      */   }
/*      */   
/*      */   public String getDecryptSql() {
/*  536 */     return this.dbEncryptFunction.getDecryptSql(getDbColumn());
/*      */   }
/*      */   
/*      */   public String getDecryptSql(String tableAlias) {
/*  540 */     return this.dbEncryptFunction.getDecryptSql(tableAlias + "." + getDbColumn());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendFrom(DbSqlContext ctx, boolean forceOuterJoin) {
/*  548 */     if (this.formula && this.sqlFormulaJoin != null) {
/*  549 */       ctx.appendFormulaJoin(this.sqlFormulaJoin, forceOuterJoin);
/*      */     }
/*  551 */     else if (this.secondaryTableJoin != null) {
/*      */       
/*  553 */       String relativePrefix = ctx.getRelativePrefix(this.secondaryTableJoinPrefix);
/*  554 */       this.secondaryTableJoin.addJoin(forceOuterJoin, relativePrefix, ctx);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSecondaryTableJoinPrefix() {
/*  563 */     return this.secondaryTableJoinPrefix;
/*      */   }
/*      */   
/*      */   public void appendSelect(DbSqlContext ctx, boolean subQuery) {
/*  567 */     if (this.formula) {
/*  568 */       ctx.appendFormulaSelect(this.sqlFormulaSelect);
/*      */     }
/*  570 */     else if (!this.isTransient) {
/*      */       
/*  572 */       if (this.secondaryTableJoin != null) {
/*  573 */         String relativePrefix = ctx.getRelativePrefix(this.secondaryTableJoinPrefix);
/*  574 */         ctx.pushTableAlias(relativePrefix);
/*      */       } 
/*      */       
/*  577 */       if (this.dbEncrypted) {
/*  578 */         String decryptSql = getDecryptSql(ctx.peekTableAlias());
/*  579 */         ctx.appendRawColumn(decryptSql);
/*  580 */         ctx.addEncryptedProp(this);
/*      */       } else {
/*      */         
/*  583 */         ctx.appendColumn(this.dbColumn);
/*      */       } 
/*      */       
/*  586 */       if (this.secondaryTableJoin != null) {
/*  587 */         ctx.popTableAlias();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isAssignableFrom(Class<?> type) {
/*  593 */     return this.owningType.isAssignableFrom(type);
/*      */   }
/*      */ 
/*      */   
/*      */   public Object readSetOwning(DbReadContext ctx, Object bean, Class<?> type) throws SQLException {
/*      */     try {
/*  599 */       Object value = this.scalarType.read(ctx.getDataReader());
/*  600 */       if (value != null && bean != null)
/*      */       {
/*      */         
/*  603 */         if (this.owningType.equals(type)) {
/*  604 */           setValue(bean, value);
/*      */         }
/*      */       }
/*  607 */       return value;
/*  608 */     } catch (Exception e) {
/*  609 */       String msg = "Error readSet on " + this.descriptor + "." + this.name;
/*  610 */       throw new PersistenceException(msg, e);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void loadIgnore(DbReadContext ctx) {
/*  615 */     this.scalarType.loadIgnore(ctx.getDataReader());
/*      */   }
/*      */   
/*      */   public void load(SqlBeanLoad sqlBeanLoad) throws SQLException {
/*  619 */     sqlBeanLoad.load(this);
/*      */   }
/*      */   
/*      */   public void buildSelectExpressionChain(String prefix, List<String> selectChain) {
/*  623 */     if (prefix == null) {
/*  624 */       selectChain.add(this.name);
/*      */     } else {
/*  626 */       selectChain.add(prefix + "." + this.name);
/*      */     } 
/*      */   }
/*      */   
/*      */   public Object read(DbReadContext ctx) throws SQLException {
/*  631 */     return this.scalarType.read(ctx.getDataReader());
/*      */   }
/*      */ 
/*      */   
/*      */   public Object readSet(DbReadContext ctx, Object bean, Class<?> type) throws SQLException {
/*      */     try {
/*  637 */       Object value = this.scalarType.read(ctx.getDataReader());
/*  638 */       if (bean != null && (type == null || this.owningType.isAssignableFrom(type)))
/*      */       {
/*      */         
/*  641 */         setValue(bean, value);
/*      */       }
/*  643 */       return value;
/*  644 */     } catch (Exception e) {
/*  645 */       String msg = "Error readSet on " + this.descriptor + "." + this.name;
/*  646 */       throw new PersistenceException(msg, e);
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
/*      */   public Object toBeanType(Object value) {
/*  658 */     return this.scalarType.toBeanType(value);
/*      */   }
/*      */ 
/*      */   
/*      */   public void bind(DataBind b, Object value) throws SQLException {
/*  663 */     this.scalarType.bind(b, value);
/*      */   }
/*      */   
/*      */   public void writeData(DataOutput dataOutput, Object value) throws IOException {
/*  667 */     this.scalarType.writeData(dataOutput, value);
/*      */   }
/*      */   
/*      */   public Object readData(DataInput dataInput) throws IOException {
/*  671 */     return this.scalarType.readData(dataInput);
/*      */   }
/*      */   
/*      */   Validator[] getValidators() {
/*  675 */     return this.validators;
/*      */   }
/*      */   
/*      */   public boolean isCascadeValidate() {
/*  679 */     return this.cascadeValidate;
/*      */   }
/*      */   
/*      */   public boolean hasLocalValidators() {
/*  683 */     return this.hasLocalValidators;
/*      */   }
/*      */   
/*      */   public boolean hasValidationRules(boolean cascade) {
/*  687 */     return (this.hasLocalValidators || (cascade && this.cascadeValidate));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isValueLoaded(Object value) {
/*  698 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InvalidValue validateCascade(Object value) {
/*  705 */     return null;
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
/*      */   public final List<InvalidValue> validate(boolean cascade, Object value) {
/*  719 */     if (!isValueLoaded(value)) {
/*  720 */       return null;
/*      */     }
/*      */     
/*  723 */     ArrayList<InvalidValue> list = null;
/*  724 */     for (int i = 0; i < this.validators.length; i++) {
/*  725 */       if (!this.validators[i].isValid(value)) {
/*  726 */         if (list == null) {
/*  727 */           list = new ArrayList<InvalidValue>();
/*      */         }
/*  729 */         Validator v = this.validators[i];
/*  730 */         list.add(new InvalidValue(v.getKey(), v.getAttributes(), this.descriptor.getFullName(), this.name, value));
/*      */       } 
/*      */     } 
/*      */     
/*  734 */     if (list == null && cascade && this.cascadeValidate) {
/*      */       
/*  736 */       InvalidValue recursive = validateCascade(value);
/*  737 */       if (recursive != null) {
/*  738 */         return InvalidValue.toList(recursive);
/*      */       }
/*      */     } 
/*      */     
/*  742 */     return list;
/*      */   }
/*      */   
/*      */   public BeanProperty getBeanProperty() {
/*  746 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Method getReadMethod() {
/*  753 */     return this.readMethod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Method getWriteMethod() {
/*  760 */     return this.writeMethod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInherited() {
/*  767 */     return this.inherited;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLocal() {
/*  774 */     return this.local;
/*      */   }
/*      */   
/*      */   public Attribute createAttribute(Object bean) {
/*  778 */     Object v = getValue(bean);
/*  779 */     if (v == null) {
/*  780 */       return null;
/*      */     }
/*  782 */     if (this.ldapAttributeAdapter != null) {
/*  783 */       return this.ldapAttributeAdapter.createAttribute(v);
/*      */     }
/*  785 */     Object ldapValue = this.scalarType.toJdbcType(v);
/*  786 */     return new BasicAttribute(this.dbColumn, ldapValue);
/*      */   }
/*      */   
/*      */   public void setAttributeValue(Object bean, Attribute attr) {
/*      */     try {
/*  791 */       if (attr != null) {
/*      */         Object beanValue;
/*  793 */         if (this.ldapAttributeAdapter != null) {
/*  794 */           beanValue = this.ldapAttributeAdapter.readAttribute(attr);
/*      */         } else {
/*  796 */           beanValue = this.scalarType.toBeanType(attr.get());
/*      */         } 
/*      */         
/*  799 */         setValue(bean, beanValue);
/*      */       } 
/*  801 */     } catch (NamingException e) {
/*  802 */       throw new LdapPersistenceException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(Object bean, Object value) {
/*      */     try {
/*  812 */       if (bean instanceof com.avaje.ebean.bean.EntityBean) {
/*  813 */         this.setter.set(bean, value);
/*      */       } else {
/*  815 */         Object[] args = new Object[1];
/*  816 */         args[0] = value;
/*  817 */         this.writeMethod.invoke(bean, args);
/*      */       } 
/*  819 */     } catch (Exception ex) {
/*  820 */       String beanType = (bean == null) ? "null" : bean.getClass().getName();
/*  821 */       String msg = "set " + this.name + " on [" + this.descriptor + "] arg[" + value + "] type[" + beanType + "] threw error";
/*      */       
/*  823 */       throw new RuntimeException(msg, ex);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValueIntercept(Object bean, Object value) {
/*      */     try {
/*  832 */       if (bean instanceof com.avaje.ebean.bean.EntityBean) {
/*  833 */         this.setter.setIntercept(bean, value);
/*      */       } else {
/*  835 */         Object[] args = new Object[1];
/*  836 */         args[0] = value;
/*  837 */         this.writeMethod.invoke(bean, args);
/*      */       } 
/*  839 */     } catch (Exception ex) {
/*  840 */       String beanType = (bean == null) ? "null" : bean.getClass().getName();
/*  841 */       String msg = "setIntercept " + this.name + " on [" + this.descriptor + "] arg[" + value + "] type[" + beanType + "] threw error";
/*      */       
/*  843 */       throw new RuntimeException(msg, ex);
/*      */     } 
/*      */   }
/*      */   
/*  847 */   private static Object[] NO_ARGS = new Object[0];
/*      */   
/*      */   private ArrayList<LuceneIndex> luceneIndexes;
/*      */ 
/*      */   
/*      */   public Object getValueWithInheritance(Object bean) {
/*  853 */     if (this.dynamicSubclassWithInheritance) {
/*  854 */       return this.descriptor.getBeanPropertyWithInheritance(bean, this.name);
/*      */     }
/*  856 */     return getValue(bean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getValue(Object bean) {
/*      */     try {
/*  864 */       if (bean instanceof com.avaje.ebean.bean.EntityBean) {
/*  865 */         return this.getter.get(bean);
/*      */       }
/*  867 */       return this.readMethod.invoke(bean, NO_ARGS);
/*      */     }
/*  869 */     catch (Exception ex) {
/*  870 */       String beanType = (bean == null) ? "null" : bean.getClass().getName();
/*  871 */       String msg = "get " + this.name + " on [" + this.descriptor + "] type[" + beanType + "] threw error.";
/*  872 */       throw new RuntimeException(msg, ex);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getValueViaReflection(Object bean) {
/*      */     try {
/*  881 */       return this.readMethod.invoke(bean, NO_ARGS);
/*  882 */     } catch (Exception ex) {
/*  883 */       String beanType = (bean == null) ? "null" : bean.getClass().getName();
/*  884 */       String msg = "get " + this.name + " on [" + this.descriptor + "] type[" + beanType + "] threw error.";
/*  885 */       throw new RuntimeException(msg, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public Object getValueIntercept(Object bean) {
/*      */     try {
/*  891 */       if (bean instanceof com.avaje.ebean.bean.EntityBean) {
/*  892 */         return this.getter.getIntercept(bean);
/*      */       }
/*  894 */       return this.readMethod.invoke(bean, NO_ARGS);
/*      */     }
/*  896 */     catch (Exception ex) {
/*  897 */       String beanType = (bean == null) ? "null" : bean.getClass().getName();
/*  898 */       String msg = "getIntercept " + this.name + " on [" + this.descriptor + "] type[" + beanType + "] threw error.";
/*  899 */       throw new RuntimeException(msg, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public Object elConvertType(Object value) {
/*  904 */     if (value == null) {
/*  905 */       return null;
/*      */     }
/*  907 */     return convertToLogicalType(value);
/*      */   }
/*      */   
/*      */   public void elSetReference(Object bean) {
/*  911 */     throw new RuntimeException("Should not be called");
/*      */   }
/*      */   
/*      */   public void elSetValue(Object bean, Object value, boolean populate, boolean reference) {
/*  915 */     if (bean != null) {
/*  916 */       setValueIntercept(bean, value);
/*      */     }
/*      */   }
/*      */   
/*      */   public Object elGetValue(Object bean) {
/*  921 */     if (bean == null) {
/*  922 */       return null;
/*      */     }
/*  924 */     return getValueIntercept(bean);
/*      */   }
/*      */   
/*      */   public Object elGetReference(Object bean) {
/*  928 */     throw new RuntimeException("Not expected to call this");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  935 */     return this.name;
/*      */   }
/*      */   
/*      */   public String getElName() {
/*  939 */     return this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDeployOnly() {
/*  946 */     return false;
/*      */   }
/*      */   
/*      */   public boolean containsManySince(String sinceProperty) {
/*  950 */     return containsMany();
/*      */   }
/*      */   
/*      */   public boolean containsMany() {
/*  954 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object[] getAssocOneIdValues(Object bean) {
/*  959 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAssocOneIdExpr(String prefix, String operator) {
/*  964 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAssocIdInExpr(String prefix) {
/*  969 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAssocIdInValueExpr(int size) {
/*  974 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isAssocId() {
/*  979 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isAssocProperty() {
/*  984 */     return false;
/*      */   }
/*      */   
/*      */   public String getElPlaceholder(boolean encrypted) {
/*  988 */     return encrypted ? this.elPlaceHolderEncrypted : this.elPlaceHolder;
/*      */   }
/*      */   
/*      */   public String getElPrefix() {
/*  992 */     return this.secondaryTableJoinPrefix;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFullBeanName() {
/*  999 */     return this.descriptor.getFullName() + "." + this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ScalarType<?> getScalarType() {
/* 1006 */     return this.scalarType;
/*      */   }
/*      */   
/*      */   public StringFormatter getStringFormatter() {
/* 1010 */     return (StringFormatter)this.scalarType;
/*      */   }
/*      */   
/*      */   public StringParser getStringParser() {
/* 1014 */     return (StringParser)this.scalarType;
/*      */   }
/*      */   
/*      */   public boolean isDateTimeCapable() {
/* 1018 */     return (this.scalarType != null && this.scalarType.isDateTimeCapable());
/*      */   }
/*      */   
/*      */   public int getJdbcType() {
/* 1022 */     return (this.scalarType == null) ? 0 : this.scalarType.getJdbcType();
/*      */   }
/*      */   
/*      */   public Object parseDateTime(long systemTimeMillis) {
/* 1026 */     return this.scalarType.parseDateTime(systemTimeMillis);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDbLength() {
/* 1033 */     return this.dbLength;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDbScale() {
/* 1040 */     return this.dbScale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDbColumnDefn() {
/* 1047 */     return this.dbColumnDefn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDbConstraintExpression() {
/* 1057 */     return this.dbConstraintExpression;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String renderDbType(DbType dbType) {
/* 1064 */     if (this.dbColumnDefn != null) {
/* 1065 */       return this.dbColumnDefn;
/*      */     }
/* 1067 */     return dbType.renderType(this.dbLength, this.dbScale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Field getField() {
/* 1074 */     return this.field;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GeneratedProperty getGeneratedProperty() {
/* 1081 */     return this.generatedProperty;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNullable() {
/* 1088 */     return this.nullable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDDLNotNull() {
/* 1096 */     return (isVersion() || (this.generatedProperty != null && this.generatedProperty.isDDLNotNullable()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUnique() {
/* 1103 */     return this.unique;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isTransient() {
/* 1110 */     return this.isTransient;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isVersion() {
/* 1117 */     return this.version;
/*      */   }
/*      */   
/*      */   public String getDeployProperty() {
/* 1121 */     return this.dbColumn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDbColumn() {
/* 1128 */     return this.dbColumn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDbType() {
/* 1135 */     return this.dbType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object convertToLogicalType(Object value) {
/* 1142 */     if (this.scalarType != null) {
/* 1143 */       return this.scalarType.toBeanType(value);
/*      */     }
/* 1145 */     return value;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void registerLuceneIndex(LuceneIndex luceneIndex) {
/* 1151 */     if (this.luceneIndexes == null) {
/* 1152 */       this.luceneIndexes = new ArrayList<LuceneIndex>();
/*      */     }
/* 1154 */     this.luceneIndexes.add(luceneIndex);
/*      */   }
/*      */   
/*      */   public boolean isDeltaRequired() {
/* 1158 */     return (this.luceneIndexes != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFetchEager() {
/* 1166 */     return this.fetchEager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLob() {
/* 1174 */     return this.lob;
/*      */   }
/*      */   
/*      */   private boolean isLobType(int type) {
/* 1178 */     switch (type) {
/*      */       case 2005:
/* 1180 */         return true;
/*      */       case 2004:
/* 1182 */         return true;
/*      */       case -4:
/* 1184 */         return true;
/*      */       case -1:
/* 1186 */         return true;
/*      */     } 
/*      */     
/* 1189 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDbBind() {
/* 1198 */     return this.dbBind;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLocalEncrypted() {
/* 1205 */     return this.localEncrypted;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDbEncrypted() {
/* 1212 */     return this.dbEncrypted;
/*      */   }
/*      */   
/*      */   public int getDbEncryptedType() {
/* 1216 */     return this.dbEncryptedType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDbInsertable() {
/* 1223 */     return this.dbInsertable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDbUpdatable() {
/* 1230 */     return this.dbUpdatable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDbRead() {
/* 1237 */     return this.dbRead;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSecondaryTable() {
/* 1245 */     return this.secondaryTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<?> getPropertyType() {
/* 1252 */     return this.propertyType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isId() {
/* 1259 */     return this.id;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmbedded() {
/* 1267 */     return this.embedded;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExtraAttribute(String key) {
/* 1274 */     return this.extraAttributeMap.get(key);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getDefaultValue() {
/* 1281 */     return this.defaultValue;
/*      */   }
/*      */   
/*      */   public String toString() {
/* 1285 */     return this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void jsonWrite(WriteJsonContext ctx, Object bean) {
/* 1291 */     Object value = getValueIntercept(bean);
/* 1292 */     if (value == null) {
/* 1293 */       ctx.appendNull(this.name);
/*      */     } else {
/* 1295 */       String jv = this.scalarType.jsonToString(value, ctx.getValueAdapter());
/* 1296 */       ctx.appendKeyValue(this.name, jv);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void jsonRead(ReadJsonContext ctx, Object bean) {
/*      */     Object objValue;
/* 1302 */     String jsonValue = ctx.readScalarValue();
/*      */ 
/*      */     
/* 1305 */     if (jsonValue == null) {
/* 1306 */       objValue = null;
/*      */     } else {
/* 1308 */       objValue = this.scalarType.jsonFromString(jsonValue, ctx.getValueAdapter());
/*      */     } 
/* 1310 */     setValue(bean, objValue);
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\BeanProperty.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */