/*     */ package com.avaje.ebeaninternal.server.deploy.meta;
/*     */ 
/*     */ import com.avaje.ebean.annotation.CreatedTimestamp;
/*     */ import com.avaje.ebean.annotation.UpdatedTimestamp;
/*     */ import com.avaje.ebean.config.ScalarTypeConverter;
/*     */ import com.avaje.ebean.config.dbplatform.DbEncrypt;
/*     */ import com.avaje.ebean.config.dbplatform.DbEncryptFunction;
/*     */ import com.avaje.ebean.config.ldap.LdapAttributeAdapter;
/*     */ import com.avaje.ebean.validation.factory.Validator;
/*     */ import com.avaje.ebeaninternal.server.core.InternString;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.server.deploy.generatedproperty.GeneratedProperty;
/*     */ import com.avaje.ebeaninternal.server.reflect.BeanReflectGetter;
/*     */ import com.avaje.ebeaninternal.server.reflect.BeanReflectSetter;
/*     */ import com.avaje.ebeaninternal.server.type.ScalarType;
/*     */ import com.avaje.ebeaninternal.server.type.ScalarTypeEnum;
/*     */ import com.avaje.ebeaninternal.server.type.ScalarTypeWrapper;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.persistence.EmbeddedId;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Version;
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
/*     */ public class DeployBeanProperty
/*     */ {
/*     */   private static final int ID_ORDER = 1000000;
/*     */   private static final int UNIDIRECTIONAL_ORDER = 100000;
/*     */   private static final int AUDITCOLUMN_ORDER = -1000000;
/*     */   private static final int VERSIONCOLUMN_ORDER = -1000000;
/*     */   public static final String EXCLUDE_FROM_UPDATE_WHERE = "EXCLUDE_FROM_UPDATE_WHERE";
/*     */   public static final String EXCLUDE_FROM_DELETE_WHERE = "EXCLUDE_FROM_DELETE_WHERE";
/*     */   public static final String EXCLUDE_FROM_INSERT = "EXCLUDE_FROM_INSERT";
/*     */   public static final String EXCLUDE_FROM_UPDATE = "EXCLUDE_FROM_UPDATE";
/*     */   private boolean id;
/*     */   private boolean embedded;
/*     */   private boolean versionColumn;
/*     */   private boolean fetchEager = true;
/*     */   private boolean nullable = true;
/*     */   private boolean unique;
/*     */   private LdapAttributeAdapter ldapAttributeAdapter;
/*     */   private int dbLength;
/*     */   private int dbScale;
/*     */   private String dbColumnDefn;
/*     */   private boolean isTransient;
/*     */   private boolean localEncrypted;
/*     */   private boolean dbEncrypted;
/*     */   private DbEncryptFunction dbEncryptFunction;
/*     */   private int dbEncryptedType;
/* 133 */   private String dbBind = "?";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dbRead;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dbInsertable;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dbUpdateable;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DeployTableJoin secondaryTableJoin;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String secondaryTableJoinPrefix;
/*     */ 
/*     */ 
/*     */   
/*     */   private String secondaryTable;
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?> owningType;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean lob;
/*     */ 
/*     */ 
/*     */   
/*     */   private String name;
/*     */ 
/*     */ 
/*     */   
/*     */   private Field field;
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?> propertyType;
/*     */ 
/*     */ 
/*     */   
/*     */   private ScalarType<?> scalarType;
/*     */ 
/*     */ 
/*     */   
/*     */   private String dbColumn;
/*     */ 
/*     */ 
/*     */   
/*     */   private String sqlFormulaSelect;
/*     */ 
/*     */ 
/*     */   
/*     */   private String sqlFormulaJoin;
/*     */ 
/*     */ 
/*     */   
/*     */   private int dbType;
/*     */ 
/*     */ 
/*     */   
/*     */   private Object defaultValue;
/*     */ 
/*     */ 
/*     */   
/* 210 */   private HashMap<String, String> extraAttributeMap = new HashMap<String, String>();
/*     */ 
/*     */ 
/*     */   
/*     */   private Method readMethod;
/*     */ 
/*     */ 
/*     */   
/*     */   private Method writeMethod;
/*     */ 
/*     */ 
/*     */   
/*     */   private BeanReflectGetter getter;
/*     */ 
/*     */   
/*     */   private BeanReflectSetter setter;
/*     */ 
/*     */   
/*     */   private GeneratedProperty generatedProperty;
/*     */ 
/*     */   
/* 231 */   private List<Validator> validators = new ArrayList<Validator>();
/*     */   
/*     */   private final DeployBeanDescriptor<?> desc;
/*     */   
/*     */   private boolean undirectionalShadow;
/*     */   
/*     */   private int sortOrder;
/*     */   
/*     */   public DeployBeanProperty(DeployBeanDescriptor<?> desc, Class<?> propertyType, ScalarType<?> scalarType, ScalarTypeConverter<?, ?> typeConverter) {
/* 240 */     this.desc = desc;
/* 241 */     this.propertyType = propertyType;
/* 242 */     this.scalarType = wrapScalarType(propertyType, scalarType, typeConverter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ScalarType<?> wrapScalarType(Class<?> propertyType, ScalarType<?> scalarType, ScalarTypeConverter<?, ?> typeConverter) {
/* 250 */     if (typeConverter == null) {
/* 251 */       return scalarType;
/*     */     }
/* 253 */     return (ScalarType<?>)new ScalarTypeWrapper(propertyType, scalarType, typeConverter);
/*     */   }
/*     */   
/*     */   public int getSortOverride() {
/* 257 */     if (this.field == null) {
/* 258 */       return 0;
/*     */     }
/* 260 */     if (this.field.getAnnotation(Id.class) != null)
/* 261 */       return 1000000; 
/* 262 */     if (this.field.getAnnotation(EmbeddedId.class) != null)
/* 263 */       return 1000000; 
/* 264 */     if (this.undirectionalShadow)
/* 265 */       return 100000; 
/* 266 */     if (this.field.getAnnotation(CreatedTimestamp.class) != null)
/* 267 */       return -1000000; 
/* 268 */     if (this.field.getAnnotation(UpdatedTimestamp.class) != null)
/* 269 */       return -1000000; 
/* 270 */     if (this.field.getAnnotation(Version.class) != null) {
/* 271 */       return -1000000;
/*     */     }
/* 273 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isScalar() {
/* 280 */     return true;
/*     */   }
/*     */   
/*     */   public String getFullBeanName() {
/* 284 */     return this.desc.getFullName() + "." + this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNullablePrimitive() {
/* 294 */     if (this.nullable && this.propertyType.isPrimitive()) {
/* 295 */       return true;
/*     */     }
/* 297 */     return false;
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
/*     */   public int getDbLength() {
/* 309 */     if (this.dbLength == 0 && this.scalarType != null) {
/* 310 */       return this.scalarType.getLength();
/*     */     }
/*     */     
/* 313 */     return this.dbLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 320 */     return this.sortOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int sortOrder) {
/* 327 */     this.sortOrder = sortOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUndirectionalShadow() {
/* 334 */     return this.undirectionalShadow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUndirectionalShadow(boolean undirectionalShadow) {
/* 341 */     this.undirectionalShadow = undirectionalShadow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLocalEncrypted() {
/* 348 */     return this.localEncrypted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocalEncrypted(boolean localEncrypted) {
/* 355 */     this.localEncrypted = localEncrypted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDbLength(int dbLength) {
/* 362 */     this.dbLength = dbLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDbScale() {
/* 369 */     return this.dbScale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDbScale(int dbScale) {
/* 376 */     this.dbScale = dbScale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDbColumnDefn() {
/* 383 */     return this.dbColumnDefn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDbColumnDefn(String dbColumnDefn) {
/* 390 */     if (dbColumnDefn == null || dbColumnDefn.trim().length() == 0) {
/* 391 */       this.dbColumnDefn = null;
/*     */     } else {
/* 393 */       this.dbColumnDefn = InternString.intern(dbColumnDefn);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getDbConstraintExpression() {
/* 398 */     if (this.scalarType instanceof ScalarTypeEnum) {
/*     */       
/* 400 */       ScalarTypeEnum etype = (ScalarTypeEnum)this.scalarType;
/*     */ 
/*     */       
/* 403 */       return "check (" + this.dbColumn + " in " + etype.getContraintInValues() + ")";
/*     */     } 
/* 405 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addValidator(Validator validator) {
/* 412 */     this.validators.add(validator);
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
/*     */   public boolean containsValidatorType(Class<?> type) {
/* 424 */     Iterator<Validator> it = this.validators.iterator();
/* 425 */     while (it.hasNext()) {
/* 426 */       Validator validator = it.next();
/* 427 */       if (validator.getClass().equals(type)) {
/* 428 */         return true;
/*     */       }
/*     */     } 
/* 431 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Validator[] getValidators() {
/* 438 */     return this.validators.<Validator>toArray(new Validator[this.validators.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScalarType<?> getScalarType() {
/* 446 */     return this.scalarType;
/*     */   }
/*     */   
/*     */   public void setScalarType(ScalarType<?> scalarType) {
/* 450 */     this.scalarType = scalarType;
/*     */   }
/*     */   
/*     */   public BeanReflectGetter getGetter() {
/* 454 */     return this.getter;
/*     */   }
/*     */   
/*     */   public BeanReflectSetter getSetter() {
/* 458 */     return this.setter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Method getReadMethod() {
/* 465 */     return this.readMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Method getWriteMethod() {
/* 472 */     return this.writeMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOwningType(Class<?> owningType) {
/* 479 */     this.owningType = owningType;
/*     */   }
/*     */   
/*     */   public Class<?> getOwningType() {
/* 483 */     return this.owningType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLocal() {
/* 490 */     return (this.owningType == null || this.owningType.equals(this.desc.getBeanType()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGetter(BeanReflectGetter getter) {
/* 497 */     this.getter = getter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSetter(BeanReflectSetter setter) {
/* 504 */     this.setter = setter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 511 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/* 518 */     this.name = InternString.intern(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Field getField() {
/* 525 */     return this.field;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(Field field) {
/* 532 */     this.field = field;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isGenerated() {
/* 540 */     return (this.generatedProperty != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GeneratedProperty getGeneratedProperty() {
/* 547 */     return this.generatedProperty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGeneratedProperty(GeneratedProperty generatedValue) {
/* 554 */     this.generatedProperty = generatedValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNullable() {
/* 561 */     return this.nullable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNullable(boolean isNullable) {
/* 568 */     this.nullable = isNullable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUnique() {
/* 575 */     return this.unique;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnique(boolean unique) {
/* 582 */     this.unique = unique;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LdapAttributeAdapter getLdapAttributeAdapter() {
/* 589 */     return this.ldapAttributeAdapter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLdapAttributeAdapter(LdapAttributeAdapter ldapAttributeAdapter) {
/* 596 */     this.ldapAttributeAdapter = ldapAttributeAdapter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVersionColumn() {
/* 603 */     return this.versionColumn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersionColumn(boolean isVersionColumn) {
/* 610 */     this.versionColumn = isVersionColumn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFetchEager() {
/* 617 */     return this.fetchEager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFetchType(FetchType fetchType) {
/* 624 */     this.fetchEager = FetchType.EAGER.equals(fetchType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSqlFormulaSelect() {
/* 631 */     return this.sqlFormulaSelect;
/*     */   }
/*     */   
/*     */   public String getSqlFormulaJoin() {
/* 635 */     return this.sqlFormulaJoin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSqlFormula(String formulaSelect, String formulaJoin) {
/* 642 */     this.sqlFormulaSelect = formulaSelect;
/* 643 */     this.sqlFormulaJoin = formulaJoin.equals("") ? null : formulaJoin;
/* 644 */     this.dbRead = true;
/* 645 */     this.dbInsertable = false;
/* 646 */     this.dbUpdateable = false;
/*     */   }
/*     */   
/*     */   public String getElPlaceHolder(BeanDescriptor.EntityType et) {
/* 650 */     if (this.sqlFormulaSelect != null)
/* 651 */       return this.sqlFormulaSelect; 
/* 652 */     if (BeanDescriptor.EntityType.LDAP.equals(et)) {
/* 653 */       return getDbColumn();
/*     */     }
/* 655 */     if (this.secondaryTableJoinPrefix != null) {
/* 656 */       return "${" + this.secondaryTableJoinPrefix + "}" + getDbColumn();
/*     */     }
/*     */     
/* 659 */     return "${}" + getDbColumn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDbColumn() {
/* 667 */     if (this.sqlFormulaSelect != null) {
/* 668 */       return this.sqlFormulaSelect;
/*     */     }
/* 670 */     return this.dbColumn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDbColumn(String dbColumn) {
/* 677 */     this.dbColumn = InternString.intern(dbColumn);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDbType() {
/* 684 */     return this.dbType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDbType(int dbType) {
/* 691 */     this.dbType = dbType;
/* 692 */     this.lob = isLobType(dbType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLob() {
/* 700 */     return this.lob;
/*     */   }
/*     */   
/*     */   private boolean isLobType(int type) {
/* 704 */     switch (type) {
/*     */       case 2005:
/* 706 */         return true;
/*     */       case 2004:
/* 708 */         return true;
/*     */       case -4:
/* 710 */         return true;
/*     */       case -1:
/* 712 */         return true;
/*     */     } 
/*     */     
/* 715 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecondaryTable() {
/* 723 */     return (this.secondaryTable != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSecondaryTable() {
/* 730 */     return this.secondaryTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecondaryTable(String secondaryTable) {
/* 737 */     this.secondaryTable = secondaryTable;
/* 738 */     this.dbInsertable = false;
/* 739 */     this.dbUpdateable = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSecondaryTableJoinPrefix() {
/* 746 */     return this.secondaryTableJoinPrefix;
/*     */   }
/*     */   
/*     */   public DeployTableJoin getSecondaryTableJoin() {
/* 750 */     return this.secondaryTableJoin;
/*     */   }
/*     */   
/*     */   public void setSecondaryTableJoin(DeployTableJoin secondaryTableJoin, String prefix) {
/* 754 */     this.secondaryTableJoin = secondaryTableJoin;
/* 755 */     this.secondaryTableJoinPrefix = prefix;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDbBind() {
/* 763 */     return this.dbBind;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDbBind(String dbBind) {
/* 770 */     this.dbBind = dbBind;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDbEncrypted() {
/* 777 */     return this.dbEncrypted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbEncryptFunction getDbEncryptFunction() {
/* 788 */     return this.dbEncryptFunction;
/*     */   }
/*     */   
/*     */   public void setDbEncryptFunction(DbEncryptFunction dbEncryptFunction, DbEncrypt dbEncrypt, int dbLen) {
/* 792 */     this.dbEncryptFunction = dbEncryptFunction;
/* 793 */     this.dbEncrypted = true;
/* 794 */     this.dbBind = dbEncryptFunction.getEncryptBindSql();
/*     */     
/* 796 */     this.dbEncryptedType = isLob() ? 2004 : dbEncrypt.getEncryptDbType();
/* 797 */     if (dbLen > 0) {
/* 798 */       setDbLength(dbLen);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDbEncryptedType() {
/* 807 */     return this.dbEncryptedType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDbEncryptedType(int dbEncryptedType) {
/* 814 */     this.dbEncryptedType = dbEncryptedType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDbRead() {
/* 821 */     return this.dbRead;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDbRead(boolean isDBRead) {
/* 828 */     this.dbRead = isDBRead;
/*     */   }
/*     */   
/*     */   public boolean isDbInsertable() {
/* 832 */     return this.dbInsertable;
/*     */   }
/*     */   
/*     */   public void setDbInsertable(boolean insertable) {
/* 836 */     this.dbInsertable = insertable;
/*     */   }
/*     */   
/*     */   public boolean isDbUpdateable() {
/* 840 */     return this.dbUpdateable;
/*     */   }
/*     */   
/*     */   public void setDbUpdateable(boolean updateable) {
/* 844 */     this.dbUpdateable = updateable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTransient() {
/* 851 */     return this.isTransient;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransient(boolean isTransient) {
/* 858 */     this.isTransient = isTransient;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadMethod(Method readMethod) {
/* 869 */     this.readMethod = readMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWriteMethod(Method writeMethod) {
/* 880 */     this.writeMethod = writeMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getPropertyType() {
/* 887 */     return this.propertyType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isId() {
/* 894 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(boolean id) {
/* 901 */     this.id = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmbedded() {
/* 909 */     return this.embedded;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmbedded(boolean embedded) {
/* 916 */     this.embedded = embedded;
/*     */   }
/*     */   
/*     */   public Map<String, String> getExtraAttributeMap() {
/* 920 */     return this.extraAttributeMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExtraAttribute(String key) {
/* 927 */     return this.extraAttributeMap.get(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExtraAttribute(String key, String value) {
/* 934 */     this.extraAttributeMap.put(key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDefaultValue() {
/* 941 */     return this.defaultValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultValue(Object defaultValue) {
/* 948 */     this.defaultValue = defaultValue;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 952 */     return this.desc.getFullName() + "." + this.name;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\meta\DeployBeanProperty.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */