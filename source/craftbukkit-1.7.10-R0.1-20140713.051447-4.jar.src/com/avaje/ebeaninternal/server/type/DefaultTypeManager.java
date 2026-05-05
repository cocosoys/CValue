/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebean.annotation.EnumMapping;
/*     */ import com.avaje.ebean.annotation.EnumValue;
/*     */ import com.avaje.ebean.config.CompoundType;
/*     */ import com.avaje.ebean.config.CompoundTypeProperty;
/*     */ import com.avaje.ebean.config.ScalarTypeConverter;
/*     */ import com.avaje.ebean.config.ServerConfig;
/*     */ import com.avaje.ebeaninternal.api.ClassUtil;
/*     */ import com.avaje.ebeaninternal.server.core.BootupClasses;
/*     */ import com.avaje.ebeaninternal.server.lib.util.StringHelper;
/*     */ import com.avaje.ebeaninternal.server.type.reflect.CheckImmutable;
/*     */ import com.avaje.ebeaninternal.server.type.reflect.CheckImmutableResponse;
/*     */ import com.avaje.ebeaninternal.server.type.reflect.ImmutableMeta;
/*     */ import com.avaje.ebeaninternal.server.type.reflect.ImmutableMetaFactory;
/*     */ import com.avaje.ebeaninternal.server.type.reflect.KnownImmutable;
/*     */ import com.avaje.ebeaninternal.server.type.reflect.ReflectionBasedCompoundType;
/*     */ import com.avaje.ebeaninternal.server.type.reflect.ReflectionBasedCompoundTypeProperty;
/*     */ import com.avaje.ebeaninternal.server.type.reflect.ReflectionBasedTypeBuilder;
/*     */ import java.lang.reflect.Field;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.sql.Date;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Currency;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TimeZone;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import org.joda.time.DateMidnight;
/*     */ import org.joda.time.DateTime;
/*     */ import org.joda.time.LocalDate;
/*     */ import org.joda.time.LocalDateTime;
/*     */ import org.joda.time.LocalTime;
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
/*     */ public final class DefaultTypeManager
/*     */   implements TypeManager, KnownImmutable
/*     */ {
/*  78 */   private static final Logger logger = Logger.getLogger(DefaultTypeManager.class.getName());
/*     */   
/*     */   private final ConcurrentHashMap<Class<?>, CtCompoundType<?>> compoundTypeMap;
/*     */   
/*     */   private final ConcurrentHashMap<Class<?>, ScalarType<?>> typeMap;
/*     */   
/*     */   private final ConcurrentHashMap<Integer, ScalarType<?>> nativeMap;
/*     */   
/*     */   private final DefaultTypeFactory extraTypeFactory;
/*     */   
/*  88 */   private final ScalarType<?> charType = new ScalarTypeChar();
/*     */   
/*  90 */   private final ScalarType<?> charArrayType = new ScalarTypeCharArray();
/*     */   
/*  92 */   private final ScalarType<?> longVarcharType = new ScalarTypeLongVarchar();
/*     */   
/*  94 */   private final ScalarType<?> clobType = new ScalarTypeClob();
/*     */   
/*  96 */   private final ScalarType<?> byteType = new ScalarTypeByte();
/*     */   
/*  98 */   private final ScalarType<?> binaryType = new ScalarTypeBytesBinary();
/*     */   
/* 100 */   private final ScalarType<?> blobType = new ScalarTypeBytesBlob();
/*     */   
/* 102 */   private final ScalarType<?> varbinaryType = new ScalarTypeBytesVarbinary();
/*     */   
/* 104 */   private final ScalarType<?> longVarbinaryType = new ScalarTypeBytesLongVarbinary();
/*     */   
/* 106 */   private final ScalarType<?> shortType = new ScalarTypeShort();
/*     */   
/* 108 */   private final ScalarType<?> integerType = new ScalarTypeInteger();
/*     */   
/* 110 */   private final ScalarType<?> longType = new ScalarTypeLong();
/*     */   
/* 112 */   private final ScalarType<?> doubleType = new ScalarTypeDouble();
/*     */   
/* 114 */   private final ScalarType<?> floatType = new ScalarTypeFloat();
/*     */   
/* 116 */   private final ScalarType<?> bigDecimalType = new ScalarTypeBigDecimal();
/*     */   
/* 118 */   private final ScalarType<?> timeType = new ScalarTypeTime();
/*     */   
/* 120 */   private final ScalarType<?> dateType = new ScalarTypeDate();
/*     */   
/* 122 */   private final ScalarType<?> timestampType = new ScalarTypeTimestamp();
/*     */   
/* 124 */   private final ScalarType<?> uuidType = new ScalarTypeUUID();
/* 125 */   private final ScalarType<?> urlType = new ScalarTypeURL();
/* 126 */   private final ScalarType<?> uriType = new ScalarTypeURI();
/* 127 */   private final ScalarType<?> localeType = new ScalarTypeLocale();
/* 128 */   private final ScalarType<?> currencyType = new ScalarTypeCurrency();
/* 129 */   private final ScalarType<?> timeZoneType = new ScalarTypeTimeZone();
/*     */   
/* 131 */   private final ScalarType<?> stringType = new ScalarTypeString();
/*     */   
/* 133 */   private final ScalarType<?> classType = new ScalarTypeClass();
/*     */ 
/*     */ 
/*     */   
/* 137 */   private final ScalarTypeLongToTimestamp longToTimestamp = new ScalarTypeLongToTimestamp();
/*     */   
/* 139 */   private final List<ScalarType<?>> customScalarTypes = new ArrayList<ScalarType<?>>();
/*     */   
/*     */   private final CheckImmutable checkImmutable;
/*     */   
/* 143 */   private final ImmutableMetaFactory immutableMetaFactory = new ImmutableMetaFactory();
/*     */ 
/*     */ 
/*     */   
/*     */   private final ReflectionBasedTypeBuilder reflectScalarBuilder;
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultTypeManager(ServerConfig config, BootupClasses bootupClasses) {
/* 152 */     int clobType = (config == null) ? 2005 : config.getDatabasePlatform().getClobDbType();
/* 153 */     int blobType = (config == null) ? 2004 : config.getDatabasePlatform().getBlobDbType();
/*     */     
/* 155 */     this.checkImmutable = new CheckImmutable(this);
/* 156 */     this.reflectScalarBuilder = new ReflectionBasedTypeBuilder(this);
/*     */     
/* 158 */     this.compoundTypeMap = new ConcurrentHashMap<Class<?>, CtCompoundType<?>>();
/* 159 */     this.typeMap = new ConcurrentHashMap<Class<?>, ScalarType<?>>();
/* 160 */     this.nativeMap = new ConcurrentHashMap<Integer, ScalarType<?>>();
/*     */     
/* 162 */     this.extraTypeFactory = new DefaultTypeFactory(config);
/*     */     
/* 164 */     initialiseStandard(clobType, blobType);
/* 165 */     initialiseJodaTypes();
/*     */     
/* 167 */     if (bootupClasses != null) {
/* 168 */       initialiseCustomScalarTypes(bootupClasses);
/* 169 */       initialiseScalarConverters(bootupClasses);
/* 170 */       initialiseCompoundTypes(bootupClasses);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isKnownImmutable(Class<?> cls) {
/* 176 */     if (cls == null)
/*     */     {
/* 178 */       return true;
/*     */     }
/*     */     
/* 181 */     if (cls.isPrimitive() || Object.class.equals(cls)) {
/* 182 */       return true;
/*     */     }
/*     */     
/* 185 */     ScalarDataReader<?> scalarDataReader = getScalarDataReader(cls);
/* 186 */     return (scalarDataReader != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public CheckImmutableResponse checkImmutable(Class<?> cls) {
/* 191 */     return this.checkImmutable.checkImmutable(cls);
/*     */   }
/*     */   
/*     */   private ScalarType<?> register(ScalarType<?> st) {
/* 195 */     add(st);
/* 196 */     logger.info("Registering ScalarType for " + st.getType() + " implemented using reflection");
/* 197 */     return st;
/*     */   }
/*     */ 
/*     */   
/*     */   public ScalarDataReader<?> recursiveCreateScalarDataReader(Class<?> cls) {
/* 202 */     ScalarDataReader<?> scalarReader = getScalarDataReader(cls);
/* 203 */     if (scalarReader != null) {
/* 204 */       return scalarReader;
/*     */     }
/*     */     
/* 207 */     ImmutableMeta meta = this.immutableMetaFactory.createImmutableMeta(cls);
/*     */     
/* 209 */     if (!meta.isCompoundType()) {
/* 210 */       return register(this.reflectScalarBuilder.buildScalarType(meta));
/*     */     }
/*     */     
/* 213 */     ReflectionBasedCompoundType compoundType = this.reflectScalarBuilder.buildCompound(meta);
/* 214 */     Class<?> compoundTypeClass = compoundType.getCompoundType();
/*     */     
/* 216 */     return createCompoundScalarDataReader(compoundTypeClass, (CompoundType<?>)compoundType, " using reflection");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ScalarType<?> recursiveCreateScalarTypes(Class<?> cls) {
/* 222 */     ScalarType<?> scalarType = getScalarType(cls);
/* 223 */     if (scalarType != null) {
/* 224 */       return scalarType;
/*     */     }
/*     */     
/* 227 */     ImmutableMeta meta = this.immutableMetaFactory.createImmutableMeta(cls);
/*     */     
/* 229 */     if (!meta.isCompoundType()) {
/* 230 */       return register(this.reflectScalarBuilder.buildScalarType(meta));
/*     */     }
/*     */     
/* 233 */     throw new RuntimeException("Not allowed compound types here");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(ScalarType<?> scalarType) {
/* 241 */     this.typeMap.put(scalarType.getType(), scalarType);
/* 242 */     logAdd(scalarType);
/*     */   }
/*     */   
/*     */   protected void logAdd(ScalarType<?> scalarType) {
/* 246 */     if (logger.isLoggable(Level.FINE)) {
/* 247 */       String msg = "ScalarType register [" + scalarType.getClass().getName() + "]";
/* 248 */       msg = msg + " for [" + scalarType.getType().getName() + "]";
/* 249 */       logger.fine(msg);
/*     */     } 
/*     */   }
/*     */   
/*     */   public CtCompoundType<?> getCompoundType(Class<?> type) {
/* 254 */     return this.compoundTypeMap.get(type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScalarType<?> getScalarType(int jdbcType) {
/* 261 */     return this.nativeMap.get(Integer.valueOf(jdbcType));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> ScalarType<T> getScalarType(Class<T> type) {
/* 269 */     return (ScalarType<T>)this.typeMap.get(type);
/*     */   }
/*     */ 
/*     */   
/*     */   public ScalarDataReader<?> getScalarDataReader(Class<?> propertyType, int sqlType) {
/* 274 */     if (sqlType == 0) {
/* 275 */       return recursiveCreateScalarDataReader(propertyType);
/*     */     }
/*     */     
/* 278 */     for (int i = 0; i < this.customScalarTypes.size(); i++) {
/* 279 */       ScalarType<?> customScalarType = this.customScalarTypes.get(i);
/*     */       
/* 281 */       if (sqlType == customScalarType.getJdbcType() && propertyType.equals(customScalarType.getType()))
/*     */       {
/*     */         
/* 284 */         return customScalarType;
/*     */       }
/*     */     } 
/*     */     
/* 288 */     String msg = "Unable to find a custom ScalarType with type [" + propertyType + "] and java.sql.Type [" + sqlType + "]";
/*     */     
/* 290 */     throw new RuntimeException(msg);
/*     */   }
/*     */   
/*     */   public ScalarDataReader<?> getScalarDataReader(Class<?> type) {
/* 294 */     ScalarDataReader<?> reader = this.typeMap.get(type);
/* 295 */     if (reader == null) {
/* 296 */       reader = this.compoundTypeMap.get(type);
/*     */     }
/* 298 */     return reader;
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
/*     */ 
/*     */   
/*     */   public <T> ScalarType<T> getScalarType(Class<T> type, int jdbcType) {
/* 314 */     ScalarType<?> scalarType = getLobTypes(jdbcType);
/* 315 */     if (scalarType != null)
/*     */     {
/* 317 */       return (ScalarType)scalarType;
/*     */     }
/*     */     
/* 320 */     scalarType = this.typeMap.get(type);
/* 321 */     if (scalarType != null && (
/* 322 */       jdbcType == 0 || scalarType.getJdbcType() == jdbcType))
/*     */     {
/* 324 */       return (ScalarType)scalarType;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     if (type.equals(Date.class)) {
/* 333 */       return (ScalarType)this.extraTypeFactory.createUtilDate(jdbcType);
/*     */     }
/*     */     
/* 336 */     if (type.equals(Calendar.class)) {
/* 337 */       return (ScalarType)this.extraTypeFactory.createCalendar(jdbcType);
/*     */     }
/*     */     
/* 340 */     String msg = "Unmatched ScalarType for " + type + " jdbcType:" + jdbcType;
/* 341 */     throw new RuntimeException(msg);
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
/*     */   private ScalarType<?> getLobTypes(int jdbcType) {
/* 354 */     return getScalarType(jdbcType);
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
/*     */   public Object convert(Object value, int toJdbcType) {
/* 366 */     if (value == null) {
/* 367 */       return null;
/*     */     }
/* 369 */     ScalarType<?> type = this.nativeMap.get(Integer.valueOf(toJdbcType));
/* 370 */     if (type != null) {
/* 371 */       return type.toJdbcType(value);
/*     */     }
/* 373 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isIntegerType(String s) {
/*     */     try {
/* 379 */       Integer.parseInt(s);
/* 380 */       return true;
/* 381 */     } catch (NumberFormatException e) {
/* 382 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ScalarType<?> createEnumScalarType2(Class<?> enumType) {
/* 394 */     boolean integerType = true;
/*     */     
/* 396 */     Map<String, String> nameValueMap = new HashMap<String, String>();
/*     */     
/* 398 */     Field[] fields = enumType.getDeclaredFields();
/* 399 */     for (int i = 0; i < fields.length; i++) {
/* 400 */       EnumValue enumValue = fields[i].<EnumValue>getAnnotation(EnumValue.class);
/* 401 */       if (enumValue != null) {
/* 402 */         nameValueMap.put(fields[i].getName(), enumValue.value());
/* 403 */         if (integerType && !isIntegerType(enumValue.value()))
/*     */         {
/* 405 */           integerType = false;
/*     */         }
/*     */       } 
/*     */     } 
/* 409 */     if (nameValueMap.isEmpty())
/*     */     {
/* 411 */       return null;
/*     */     }
/*     */     
/* 414 */     return createEnumScalarType(enumType, nameValueMap, integerType, 0);
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
/*     */   
/*     */   public ScalarType<?> createEnumScalarType(Class<?> enumType) {
/* 429 */     EnumMapping enumMapping = enumType.<EnumMapping>getAnnotation(EnumMapping.class);
/* 430 */     if (enumMapping == null)
/*     */     {
/* 432 */       return createEnumScalarType2(enumType);
/*     */     }
/*     */     
/* 435 */     String nameValuePairs = enumMapping.nameValuePairs();
/* 436 */     boolean integerType = enumMapping.integerType();
/* 437 */     int dbColumnLength = enumMapping.length();
/*     */ 
/*     */     
/* 440 */     Map<String, String> nameValueMap = StringHelper.delimitedToMap(nameValuePairs, ",", "=");
/*     */     
/* 442 */     return createEnumScalarType(enumType, nameValueMap, integerType, dbColumnLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ScalarType<?> createEnumScalarType(Class<Enum> enumType, Map<String, String> nameValueMap, boolean integerType, int dbColumnLength) {
/* 452 */     EnumToDbValueMap<?> beanDbMap = EnumToDbValueMap.create(integerType);
/*     */     
/* 454 */     int maxValueLen = 0;
/*     */     
/* 456 */     Iterator<Map.Entry> it = nameValueMap.entrySet().iterator();
/* 457 */     while (it.hasNext()) {
/* 458 */       Map.Entry entry = it.next();
/* 459 */       String name = (String)entry.getKey();
/* 460 */       String value = (String)entry.getValue();
/*     */       
/* 462 */       maxValueLen = Math.max(maxValueLen, value.length());
/*     */       
/* 464 */       Object enumValue = Enum.valueOf(enumType, name.trim());
/* 465 */       beanDbMap.add(enumValue, value.trim());
/*     */     } 
/*     */     
/* 468 */     if (dbColumnLength == 0 && !integerType) {
/* 469 */       dbColumnLength = maxValueLen;
/*     */     }
/*     */     
/* 472 */     return new ScalarTypeEnumWithMapping(beanDbMap, enumType, dbColumnLength);
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
/*     */   protected void initialiseCustomScalarTypes(BootupClasses bootupClasses) {
/* 485 */     this.customScalarTypes.add(this.longToTimestamp);
/*     */     
/* 487 */     List<Class<?>> foundTypes = bootupClasses.getScalarTypes();
/*     */     
/* 489 */     for (int i = 0; i < foundTypes.size(); i++) {
/* 490 */       Class<?> cls = foundTypes.get(i);
/*     */       
/*     */       try {
/* 493 */         ScalarType<?> scalarType = (ScalarType)cls.newInstance();
/* 494 */         add(scalarType);
/*     */         
/* 496 */         this.customScalarTypes.add(scalarType);
/*     */       }
/* 498 */       catch (Exception e) {
/* 499 */         String msg = "Error loading ScalarType [" + cls.getName() + "]";
/* 500 */         logger.log(Level.SEVERE, msg, e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initialiseScalarConverters(BootupClasses bootupClasses) {
/* 510 */     List<Class<?>> foundTypes = bootupClasses.getScalarConverters();
/*     */     
/* 512 */     for (int i = 0; i < foundTypes.size(); i++) {
/* 513 */       Class<?> cls = foundTypes.get(i);
/*     */       
/*     */       try {
/* 516 */         Class<?>[] paramTypes = TypeReflectHelper.getParams(cls, ScalarTypeConverter.class);
/* 517 */         if (paramTypes.length != 2) {
/* 518 */           throw new IllegalStateException("Expected 2 generics paramtypes but got: " + Arrays.toString(paramTypes));
/*     */         }
/*     */         
/* 521 */         Class<?> logicalType = paramTypes[0];
/* 522 */         Class<?> persistType = paramTypes[1];
/*     */         
/* 524 */         ScalarType<?> wrappedType = getScalarType(persistType);
/* 525 */         if (wrappedType == null) {
/* 526 */           throw new IllegalStateException("Could not find ScalarType for: " + paramTypes[1]);
/*     */         }
/*     */         
/* 529 */         ScalarTypeConverter<?, ?> converter = (ScalarTypeConverter)cls.newInstance();
/* 530 */         ScalarTypeWrapper<Object, Object> stw = new ScalarTypeWrapper<Object, Object>(logicalType, wrappedType, converter);
/*     */         
/* 532 */         logger.info("Register ScalarTypeWrapper from " + logicalType + " -> " + persistType + " using:" + cls);
/*     */         
/* 534 */         add(stw);
/*     */       }
/* 536 */       catch (Exception e) {
/* 537 */         String msg = "Error loading ScalarType [" + cls.getName() + "]";
/* 538 */         logger.log(Level.SEVERE, msg, e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initialiseCompoundTypes(BootupClasses bootupClasses) {
/* 546 */     ArrayList<Class<?>> compoundTypes = bootupClasses.getCompoundTypes();
/* 547 */     for (int j = 0; j < compoundTypes.size(); j++) {
/*     */       
/* 549 */       Class<?> type = compoundTypes.get(j);
/*     */       
/*     */       try {
/* 552 */         Class<?>[] paramTypes = TypeReflectHelper.getParams(type, CompoundType.class);
/* 553 */         if (paramTypes.length != 1) {
/* 554 */           throw new RuntimeException("Expecting 1 generic paramter type but got " + Arrays.toString(paramTypes) + " for " + type);
/*     */         }
/*     */ 
/*     */         
/* 558 */         Class<?> compoundTypeClass = paramTypes[0];
/*     */         
/* 560 */         CompoundType<?> compoundType = (CompoundType)type.newInstance();
/* 561 */         createCompoundScalarDataReader(compoundTypeClass, compoundType, "");
/*     */       }
/* 563 */       catch (Exception e) {
/* 564 */         String msg = "Error initialising component " + type;
/* 565 */         throw new RuntimeException(msg, e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CtCompoundType createCompoundScalarDataReader(Class<?> compoundTypeClass, CompoundType<?> compoundType, String info) {
/* 573 */     CtCompoundType<?> ctCompoundType = this.compoundTypeMap.get(compoundTypeClass);
/* 574 */     if (ctCompoundType != null) {
/* 575 */       logger.info("Already registered compound type " + compoundTypeClass);
/* 576 */       return ctCompoundType;
/*     */     } 
/*     */     
/* 579 */     CompoundTypeProperty[] arrayOfCompoundTypeProperty = compoundType.getProperties();
/*     */     
/* 581 */     ScalarDataReader[] dataReaders = new ScalarDataReader[arrayOfCompoundTypeProperty.length];
/*     */     
/* 583 */     for (int i = 0; i < arrayOfCompoundTypeProperty.length; i++) {
/*     */       
/* 585 */       Class<?> propertyType = getCompoundPropertyType(arrayOfCompoundTypeProperty[i]);
/*     */       
/* 587 */       ScalarDataReader<?> scalarDataReader = getScalarDataReader(propertyType, arrayOfCompoundTypeProperty[i].getDbType());
/* 588 */       if (scalarDataReader == null) {
/* 589 */         throw new RuntimeException("Could not find ScalarDataReader for " + propertyType);
/*     */       }
/*     */       
/* 592 */       dataReaders[i] = scalarDataReader;
/*     */     } 
/*     */     
/* 595 */     CtCompoundType<?> ctType = new CtCompoundType(compoundTypeClass, compoundType, dataReaders);
/*     */     
/* 597 */     logger.info("Registering CompoundType " + compoundTypeClass + " " + info);
/* 598 */     this.compoundTypeMap.put(compoundTypeClass, ctType);
/*     */     
/* 600 */     return ctType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?> getCompoundPropertyType(CompoundTypeProperty<?, ?> prop) {
/* 608 */     if (prop instanceof ReflectionBasedCompoundTypeProperty) {
/* 609 */       return ((ReflectionBasedCompoundTypeProperty)prop).getPropertyType();
/*     */     }
/*     */ 
/*     */     
/* 613 */     Class<?>[] propParamTypes = TypeReflectHelper.getParams(prop.getClass(), CompoundTypeProperty.class);
/* 614 */     if (propParamTypes.length != 2) {
/* 615 */       throw new RuntimeException("Expecting 2 generic paramter types but got " + Arrays.toString(propParamTypes) + " for " + prop.getClass());
/*     */     }
/*     */ 
/*     */     
/* 619 */     return propParamTypes[1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initialiseJodaTypes() {
/* 629 */     if (ClassUtil.isPresent("org.joda.time.LocalDateTime", getClass())) {
/*     */       
/* 631 */       String msg = "Registering Joda data types";
/* 632 */       logger.log(Level.INFO, msg);
/* 633 */       this.typeMap.put(LocalDateTime.class, new ScalarTypeJodaLocalDateTime());
/* 634 */       this.typeMap.put(LocalDate.class, new ScalarTypeJodaLocalDate());
/* 635 */       this.typeMap.put(LocalTime.class, new ScalarTypeJodaLocalTime());
/* 636 */       this.typeMap.put(DateTime.class, new ScalarTypeJodaDateTime());
/* 637 */       this.typeMap.put(DateMidnight.class, new ScalarTypeJodaDateMidnight());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initialiseStandard(int platformClobType, int platformBlobType) {
/* 648 */     ScalarType<?> utilDateType = this.extraTypeFactory.createUtilDate();
/* 649 */     this.typeMap.put(Date.class, utilDateType);
/*     */     
/* 651 */     ScalarType<?> calType = this.extraTypeFactory.createCalendar();
/* 652 */     this.typeMap.put(Calendar.class, calType);
/*     */     
/* 654 */     ScalarType<?> mathBigIntType = this.extraTypeFactory.createMathBigInteger();
/* 655 */     this.typeMap.put(BigInteger.class, mathBigIntType);
/*     */     
/* 657 */     ScalarType<?> booleanType = this.extraTypeFactory.createBoolean();
/* 658 */     this.typeMap.put(Boolean.class, booleanType);
/* 659 */     this.typeMap.put(boolean.class, booleanType);
/*     */ 
/*     */     
/* 662 */     this.nativeMap.put(Integer.valueOf(16), booleanType);
/* 663 */     if (booleanType.getJdbcType() == -7)
/*     */     {
/* 665 */       this.nativeMap.put(Integer.valueOf(-7), booleanType);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 670 */     this.typeMap.put(Locale.class, this.localeType);
/* 671 */     this.typeMap.put(Currency.class, this.currencyType);
/* 672 */     this.typeMap.put(TimeZone.class, this.timeZoneType);
/* 673 */     this.typeMap.put(UUID.class, this.uuidType);
/* 674 */     this.typeMap.put(URL.class, this.urlType);
/* 675 */     this.typeMap.put(URI.class, this.uriType);
/*     */ 
/*     */     
/* 678 */     this.typeMap.put(char[].class, this.charArrayType);
/* 679 */     this.typeMap.put(char.class, this.charType);
/* 680 */     this.typeMap.put(String.class, this.stringType);
/* 681 */     this.nativeMap.put(Integer.valueOf(12), this.stringType);
/* 682 */     this.nativeMap.put(Integer.valueOf(1), this.stringType);
/* 683 */     this.nativeMap.put(Integer.valueOf(-1), this.longVarcharType);
/*     */ 
/*     */     
/* 686 */     this.typeMap.put(Class.class, this.classType);
/*     */     
/* 688 */     if (platformClobType == 2005) {
/* 689 */       this.nativeMap.put(Integer.valueOf(2005), this.clobType);
/*     */     } else {
/*     */       
/* 692 */       ScalarType<?> platClobScalarType = this.nativeMap.get(Integer.valueOf(platformClobType));
/* 693 */       if (platClobScalarType == null) {
/* 694 */         throw new IllegalArgumentException("Type for dbPlatform clobType [" + this.clobType + "] not found.");
/*     */       }
/* 696 */       this.nativeMap.put(Integer.valueOf(2005), platClobScalarType);
/*     */     } 
/*     */ 
/*     */     
/* 700 */     this.typeMap.put(byte[].class, this.varbinaryType);
/* 701 */     this.nativeMap.put(Integer.valueOf(-2), this.binaryType);
/* 702 */     this.nativeMap.put(Integer.valueOf(-3), this.varbinaryType);
/* 703 */     this.nativeMap.put(Integer.valueOf(-4), this.longVarbinaryType);
/*     */     
/* 705 */     if (platformBlobType == 2004) {
/* 706 */       this.nativeMap.put(Integer.valueOf(2004), this.blobType);
/*     */     } else {
/*     */       
/* 709 */       ScalarType<?> platBlobScalarType = this.nativeMap.get(Integer.valueOf(platformBlobType));
/* 710 */       if (platBlobScalarType == null) {
/* 711 */         throw new IllegalArgumentException("Type for dbPlatform blobType [" + this.blobType + "] not found.");
/*     */       }
/* 713 */       this.nativeMap.put(Integer.valueOf(2004), platBlobScalarType);
/*     */     } 
/*     */ 
/*     */     
/* 717 */     this.typeMap.put(Byte.class, this.byteType);
/* 718 */     this.typeMap.put(byte.class, this.byteType);
/* 719 */     this.nativeMap.put(Integer.valueOf(-6), this.byteType);
/*     */     
/* 721 */     this.typeMap.put(Short.class, this.shortType);
/* 722 */     this.typeMap.put(short.class, this.shortType);
/* 723 */     this.nativeMap.put(Integer.valueOf(5), this.shortType);
/*     */     
/* 725 */     this.typeMap.put(Integer.class, this.integerType);
/* 726 */     this.typeMap.put(int.class, this.integerType);
/* 727 */     this.nativeMap.put(Integer.valueOf(4), this.integerType);
/*     */     
/* 729 */     this.typeMap.put(Long.class, this.longType);
/* 730 */     this.typeMap.put(long.class, this.longType);
/* 731 */     this.nativeMap.put(Integer.valueOf(-5), this.longType);
/*     */     
/* 733 */     this.typeMap.put(Double.class, this.doubleType);
/* 734 */     this.typeMap.put(double.class, this.doubleType);
/* 735 */     this.nativeMap.put(Integer.valueOf(6), this.doubleType);
/* 736 */     this.nativeMap.put(Integer.valueOf(8), this.doubleType);
/*     */     
/* 738 */     this.typeMap.put(Float.class, this.floatType);
/* 739 */     this.typeMap.put(float.class, this.floatType);
/* 740 */     this.nativeMap.put(Integer.valueOf(7), this.floatType);
/*     */     
/* 742 */     this.typeMap.put(BigDecimal.class, this.bigDecimalType);
/* 743 */     this.nativeMap.put(Integer.valueOf(3), this.bigDecimalType);
/* 744 */     this.nativeMap.put(Integer.valueOf(2), this.bigDecimalType);
/*     */ 
/*     */     
/* 747 */     this.typeMap.put(Time.class, this.timeType);
/* 748 */     this.nativeMap.put(Integer.valueOf(92), this.timeType);
/* 749 */     this.typeMap.put(Date.class, this.dateType);
/* 750 */     this.nativeMap.put(Integer.valueOf(91), this.dateType);
/* 751 */     this.typeMap.put(Timestamp.class, this.timestampType);
/* 752 */     this.nativeMap.put(Integer.valueOf(93), this.timestampType);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\DefaultTypeManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */