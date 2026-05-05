/*      */ package com.avaje.ebean.config;
/*      */ 
/*      */ import com.avaje.ebean.LogLevel;
/*      */ import com.avaje.ebean.config.dbplatform.DatabasePlatform;
/*      */ import com.avaje.ebean.config.dbplatform.DbEncrypt;
/*      */ import com.avaje.ebean.config.ldap.LdapConfig;
/*      */ import com.avaje.ebean.config.ldap.LdapContextFactory;
/*      */ import com.avaje.ebean.config.lucene.LuceneConfig;
/*      */ import com.avaje.ebean.event.BeanPersistController;
/*      */ import com.avaje.ebean.event.BeanPersistListener;
/*      */ import com.avaje.ebean.event.BeanQueryAdapter;
/*      */ import com.avaje.ebeaninternal.api.ClassUtil;
/*      */ import com.avaje.ebeaninternal.server.core.DetectLucene;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import javax.sql.DataSource;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ServerConfig
/*      */ {
/*      */   private static final int DEFAULT_QUERY_BATCH_SIZE = 100;
/*      */   private String name;
/*      */   private String resourceDirectory;
/*      */   private int enhanceLogLevel;
/*      */   private boolean register = true;
/*      */   private boolean defaultServer;
/*      */   private boolean validateOnSave = true;
/*  126 */   private List<Class<?>> classes = new ArrayList<Class<?>>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  132 */   private List<String> packages = new ArrayList<String>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  139 */   private List<String> searchJars = new ArrayList<String>();
/*      */ 
/*      */   
/*  142 */   private AutofetchConfig autofetchConfig = new AutofetchConfig();
/*      */ 
/*      */ 
/*      */   
/*      */   private String databasePlatformName;
/*      */ 
/*      */ 
/*      */   
/*      */   private DatabasePlatform databasePlatform;
/*      */ 
/*      */ 
/*      */   
/*  154 */   private int databaseSequenceBatchSize = 20;
/*      */   
/*      */   private boolean persistBatching;
/*      */   
/*  158 */   private int persistBatchSize = 20;
/*      */ 
/*      */   
/*  161 */   private int lazyLoadBatchSize = 1;
/*      */ 
/*      */   
/*  164 */   private int queryBatchSize = -1;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ddlGenerate;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ddlRun;
/*      */ 
/*      */   
/*      */   private boolean debugSql;
/*      */ 
/*      */   
/*      */   private boolean debugLazyLoad;
/*      */ 
/*      */   
/*      */   private boolean useJtaTransactionManager;
/*      */ 
/*      */   
/*      */   private ExternalTransactionManager externalTransactionManager;
/*      */ 
/*      */   
/*      */   private boolean loggingToJavaLogger;
/*      */ 
/*      */   
/*  190 */   private String loggingDirectory = "logs";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  195 */   private LogLevel loggingLevel = LogLevel.NONE;
/*      */ 
/*      */ 
/*      */   
/*      */   private PstmtDelegate pstmtDelegate;
/*      */ 
/*      */ 
/*      */   
/*      */   private DataSource dataSource;
/*      */ 
/*      */ 
/*      */   
/*  207 */   private DataSourceConfig dataSourceConfig = new DataSourceConfig();
/*      */ 
/*      */   
/*      */   private String dataSourceJndiName;
/*      */ 
/*      */   
/*      */   private String databaseBooleanTrue;
/*      */ 
/*      */   
/*      */   private String databaseBooleanFalse;
/*      */ 
/*      */   
/*      */   private NamingConvention namingConvention;
/*      */ 
/*      */   
/*      */   private boolean updateChangesOnly = true;
/*      */   
/*  224 */   private List<BeanPersistController> persistControllers = new ArrayList<BeanPersistController>();
/*  225 */   private List<BeanPersistListener<?>> persistListeners = new ArrayList<BeanPersistListener<?>>();
/*  226 */   private List<BeanQueryAdapter> queryAdapters = new ArrayList<BeanQueryAdapter>();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private EncryptKeyManager encryptKeyManager;
/*      */ 
/*      */ 
/*      */   
/*      */   private EncryptDeployManager encryptDeployManager;
/*      */ 
/*      */ 
/*      */   
/*      */   private Encryptor encryptor;
/*      */ 
/*      */ 
/*      */   
/*      */   private DbEncrypt dbEncrypt;
/*      */ 
/*      */ 
/*      */   
/*      */   private LdapConfig ldapConfig;
/*      */ 
/*      */ 
/*      */   
/*      */   private LuceneConfig luceneConfig;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean vanillaMode;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean vanillaRefMode;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  265 */     return this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String name) {
/*  272 */     this.name = name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRegister() {
/*  283 */     return this.register;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRegister(boolean register) {
/*  294 */     this.register = register;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDefaultServer() {
/*  305 */     return this.defaultServer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultServer(boolean defaultServer) {
/*  316 */     this.defaultServer = defaultServer;
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
/*      */   public boolean isPersistBatching() {
/*  329 */     return this.persistBatching;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUsePersistBatching() {
/*  338 */     return this.persistBatching;
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
/*      */   public void setPersistBatching(boolean persistBatching) {
/*  351 */     this.persistBatching = persistBatching;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUsePersistBatching(boolean persistBatching) {
/*  360 */     this.persistBatching = persistBatching;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPersistBatchSize() {
/*  367 */     return this.persistBatchSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersistBatchSize(int persistBatchSize) {
/*  374 */     this.persistBatchSize = persistBatchSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLazyLoadBatchSize() {
/*  381 */     return this.lazyLoadBatchSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getQueryBatchSize() {
/*  390 */     return this.queryBatchSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQueryBatchSize(int queryBatchSize) {
/*  399 */     this.queryBatchSize = queryBatchSize;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLazyLoadBatchSize(int lazyLoadBatchSize) {
/*  417 */     this.lazyLoadBatchSize = lazyLoadBatchSize;
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
/*      */   public void setDatabaseSequenceBatchSize(int databaseSequenceBatchSize) {
/*  429 */     this.databaseSequenceBatchSize = databaseSequenceBatchSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUseJtaTransactionManager() {
/*  436 */     return this.useJtaTransactionManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUseJtaTransactionManager(boolean useJtaTransactionManager) {
/*  443 */     this.useJtaTransactionManager = useJtaTransactionManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExternalTransactionManager getExternalTransactionManager() {
/*  450 */     return this.externalTransactionManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExternalTransactionManager(ExternalTransactionManager externalTransactionManager) {
/*  457 */     this.externalTransactionManager = externalTransactionManager;
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
/*      */   public boolean isVanillaMode() {
/*  469 */     return this.vanillaMode;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVanillaMode(boolean vanillaMode) {
/*  488 */     this.vanillaMode = vanillaMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isVanillaRefMode() {
/*  499 */     return this.vanillaRefMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVanillaRefMode(boolean vanillaRefMode) {
/*  508 */     this.vanillaRefMode = vanillaRefMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isValidateOnSave() {
/*  515 */     return this.validateOnSave;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValidateOnSave(boolean validateOnSave) {
/*  522 */     this.validateOnSave = validateOnSave;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getEnhanceLogLevel() {
/*  529 */     return this.enhanceLogLevel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnhanceLogLevel(int enhanceLogLevel) {
/*  536 */     this.enhanceLogLevel = enhanceLogLevel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NamingConvention getNamingConvention() {
/*  546 */     return this.namingConvention;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNamingConvention(NamingConvention namingConvention) {
/*  556 */     this.namingConvention = namingConvention;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AutofetchConfig getAutofetchConfig() {
/*  563 */     return this.autofetchConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutofetchConfig(AutofetchConfig autofetchConfig) {
/*  570 */     this.autofetchConfig = autofetchConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PstmtDelegate getPstmtDelegate() {
/*  577 */     return this.pstmtDelegate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPstmtDelegate(PstmtDelegate pstmtDelegate) {
/*  588 */     this.pstmtDelegate = pstmtDelegate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataSource getDataSource() {
/*  595 */     return this.dataSource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDataSource(DataSource dataSource) {
/*  602 */     this.dataSource = dataSource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataSourceConfig getDataSourceConfig() {
/*  610 */     return this.dataSourceConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
/*  618 */     this.dataSourceConfig = dataSourceConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDataSourceJndiName() {
/*  625 */     return this.dataSourceJndiName;
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
/*      */   public void setDataSourceJndiName(String dataSourceJndiName) {
/*  637 */     this.dataSourceJndiName = dataSourceJndiName;
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
/*      */   public String getDatabaseBooleanTrue() {
/*  650 */     return this.databaseBooleanTrue;
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
/*      */   public void setDatabaseBooleanTrue(String databaseTrue) {
/*  663 */     this.databaseBooleanTrue = databaseTrue;
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
/*      */   public String getDatabaseBooleanFalse() {
/*  676 */     return this.databaseBooleanFalse;
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
/*      */   public void setDatabaseBooleanFalse(String databaseFalse) {
/*  689 */     this.databaseBooleanFalse = databaseFalse;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDatabaseSequenceBatchSize() {
/*  696 */     return this.databaseSequenceBatchSize;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDatabaseSequenceBatch(int databaseSequenceBatchSize) {
/*  715 */     this.databaseSequenceBatchSize = databaseSequenceBatchSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDatabasePlatformName() {
/*  726 */     return this.databasePlatformName;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDatabasePlatformName(String databasePlatformName) {
/*  748 */     this.databasePlatformName = databasePlatformName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DatabasePlatform getDatabasePlatform() {
/*  755 */     return this.databasePlatform;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDatabasePlatform(DatabasePlatform databasePlatform) {
/*  766 */     this.databasePlatform = databasePlatform;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EncryptKeyManager getEncryptKeyManager() {
/*  773 */     return this.encryptKeyManager;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEncryptKeyManager(EncryptKeyManager encryptKeyManager) {
/*  792 */     this.encryptKeyManager = encryptKeyManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EncryptDeployManager getEncryptDeployManager() {
/*  803 */     return this.encryptDeployManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEncryptDeployManager(EncryptDeployManager encryptDeployManager) {
/*  814 */     this.encryptDeployManager = encryptDeployManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Encryptor getEncryptor() {
/*  822 */     return this.encryptor;
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
/*      */   public void setEncryptor(Encryptor encryptor) {
/*  834 */     this.encryptor = encryptor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DbEncrypt getDbEncrypt() {
/*  845 */     return this.dbEncrypt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDbEncrypt(DbEncrypt dbEncrypt) {
/*  856 */     this.dbEncrypt = dbEncrypt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDebugSql() {
/*  867 */     return this.debugSql;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDebugSql(boolean debugSql) {
/*  878 */     this.debugSql = debugSql;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDebugLazyLoad() {
/*  885 */     return this.debugLazyLoad;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDebugLazyLoad(boolean debugLazyLoad) {
/*  892 */     this.debugLazyLoad = debugLazyLoad;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LogLevel getLoggingLevel() {
/*  902 */     return this.loggingLevel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLoggingLevel(LogLevel logLevel) {
/*  912 */     this.loggingLevel = logLevel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLoggingDirectory() {
/*  919 */     return this.loggingDirectory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLoggingDirectoryWithEval() {
/*  927 */     return GlobalProperties.evaluateExpressions(this.loggingDirectory);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLoggingDirectory(String loggingDirectory) {
/*  948 */     this.loggingDirectory = loggingDirectory;
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
/*      */   public boolean isLoggingToJavaLogger() {
/*  960 */     return this.loggingToJavaLogger;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLoggingToJavaLogger(boolean transactionLogToJavaLogger) {
/*  969 */     this.loggingToJavaLogger = transactionLogToJavaLogger;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUseJuliTransactionLogger() {
/*  978 */     return isLoggingToJavaLogger();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUseJuliTransactionLogger(boolean transactionLogToJavaLogger) {
/*  987 */     setLoggingToJavaLogger(transactionLogToJavaLogger);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDdlGenerate(boolean ddlGenerate) {
/*  994 */     this.ddlGenerate = ddlGenerate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDdlRun(boolean ddlRun) {
/* 1001 */     this.ddlRun = ddlRun;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDdlGenerate() {
/* 1008 */     return this.ddlGenerate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDdlRun() {
/* 1015 */     return this.ddlRun;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LdapConfig getLdapConfig() {
/* 1022 */     return this.ldapConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLdapConfig(LdapConfig ldapConfig) {
/* 1029 */     this.ldapConfig = ldapConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LuceneConfig getLuceneConfig() {
/* 1036 */     return this.luceneConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLuceneConfig(LuceneConfig luceneConfig) {
/* 1043 */     this.luceneConfig = luceneConfig;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addClass(Class<?> cls) {
/* 1066 */     if (this.classes == null) {
/* 1067 */       this.classes = new ArrayList<Class<?>>();
/*      */     }
/* 1069 */     this.classes.add(cls);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addPackage(String packageName) {
/* 1079 */     if (this.packages == null) {
/* 1080 */       this.packages = new ArrayList<String>();
/*      */     }
/* 1082 */     this.packages.add(packageName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getPackages() {
/* 1092 */     return this.packages;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPackages(List<String> packages) {
/* 1102 */     this.packages = packages;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addJar(String jarName) {
/* 1123 */     if (this.searchJars == null) {
/* 1124 */       this.searchJars = new ArrayList<String>();
/*      */     }
/* 1126 */     this.searchJars.add(jarName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getJars() {
/* 1136 */     return this.searchJars;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setJars(List<String> searchJars) {
/* 1146 */     this.searchJars = searchJars;
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
/*      */   public void setClasses(List<Class<?>> classes) {
/* 1161 */     this.classes = classes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<Class<?>> getClasses() {
/* 1169 */     return this.classes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUpdateChangesOnly() {
/* 1176 */     return this.updateChangesOnly;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateChangesOnly(boolean updateChangesOnly) {
/* 1183 */     this.updateChangesOnly = updateChangesOnly;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getResourceDirectory() {
/* 1190 */     return this.resourceDirectory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setResourceDirectory(String resourceDirectory) {
/* 1197 */     this.resourceDirectory = resourceDirectory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(BeanQueryAdapter beanQueryAdapter) {
/* 1208 */     this.queryAdapters.add(beanQueryAdapter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<BeanQueryAdapter> getQueryAdapters() {
/* 1215 */     return this.queryAdapters;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQueryAdapters(List<BeanQueryAdapter> queryAdapters) {
/* 1226 */     this.queryAdapters = queryAdapters;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(BeanPersistController beanPersistController) {
/* 1237 */     this.persistControllers.add(beanPersistController);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<BeanPersistController> getPersistControllers() {
/* 1244 */     return this.persistControllers;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersistControllers(List<BeanPersistController> persistControllers) {
/* 1255 */     this.persistControllers = persistControllers;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(BeanPersistListener<?> beanPersistListener) {
/* 1266 */     this.persistListeners.add(beanPersistListener);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<BeanPersistListener<?>> getPersistListeners() {
/* 1273 */     return this.persistListeners;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPersistListeners(List<BeanPersistListener<?>> persistListeners) {
/* 1284 */     this.persistListeners = persistListeners;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void loadFromProperties() {
/* 1291 */     ConfigPropertyMap p = new ConfigPropertyMap(this.name);
/* 1292 */     loadSettings(p);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GlobalProperties.PropertySource getPropertySource() {
/* 1299 */     return GlobalProperties.getPropertySource(this.name);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getProperty(String propertyName, String defaultValue) {
/* 1306 */     GlobalProperties.PropertySource p = new ConfigPropertyMap(this.name);
/* 1307 */     return p.get(propertyName, defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getProperty(String propertyName) {
/* 1314 */     return getProperty(propertyName, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private <T> T createInstance(GlobalProperties.PropertySource p, Class<T> type, String key) {
/* 1320 */     String classname = p.get(key, null);
/* 1321 */     if (classname == null) {
/* 1322 */       return null;
/*      */     }
/*      */     
/*      */     try {
/* 1326 */       Class<?> cls = ClassUtil.forName(classname, getClass());
/* 1327 */       return (T)cls.newInstance();
/* 1328 */     } catch (Exception e) {
/* 1329 */       throw new RuntimeException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void loadSettings(ConfigPropertyMap p) {
/* 1338 */     if (this.autofetchConfig == null) {
/* 1339 */       this.autofetchConfig = new AutofetchConfig();
/*      */     }
/* 1341 */     this.autofetchConfig.loadSettings(p);
/* 1342 */     if (this.dataSourceConfig == null) {
/* 1343 */       this.dataSourceConfig = new DataSourceConfig();
/*      */     }
/* 1345 */     this.dataSourceConfig.loadSettings(p.getServerName());
/*      */     
/* 1347 */     if (this.ldapConfig == null) {
/* 1348 */       LdapContextFactory ctxFact = createInstance(p, LdapContextFactory.class, "ldapContextFactory");
/* 1349 */       if (ctxFact != null) {
/* 1350 */         this.ldapConfig = new LdapConfig();
/* 1351 */         this.ldapConfig.setContextFactory(ctxFact);
/* 1352 */         this.ldapConfig.setVanillaMode(p.getBoolean("ldapVanillaMode", false));
/*      */       } 
/*      */     } 
/* 1355 */     if (this.luceneConfig == null && 
/* 1356 */       DetectLucene.isPresent()) {
/* 1357 */       this.luceneConfig = new LuceneConfig();
/* 1358 */       this.luceneConfig.loadSettings(this.name);
/*      */     } 
/*      */ 
/*      */     
/* 1362 */     this.useJtaTransactionManager = p.getBoolean("useJtaTransactionManager", false);
/* 1363 */     this.namingConvention = createNamingConvention(p);
/* 1364 */     this.databasePlatform = createInstance(p, DatabasePlatform.class, "databasePlatform");
/* 1365 */     this.encryptKeyManager = createInstance(p, EncryptKeyManager.class, "encryptKeyManager");
/* 1366 */     this.encryptDeployManager = createInstance(p, EncryptDeployManager.class, "encryptDeployManager");
/* 1367 */     this.encryptor = createInstance(p, Encryptor.class, "encryptor");
/* 1368 */     this.dbEncrypt = createInstance(p, DbEncrypt.class, "dbEncrypt");
/*      */     
/* 1370 */     String jarsProp = p.get("search.jars", p.get("jars", null));
/* 1371 */     if (jarsProp != null) {
/* 1372 */       this.searchJars = getSearchJarsPackages(jarsProp);
/*      */     }
/*      */     
/* 1375 */     String packagesProp = p.get("search.packages", p.get("packages", null));
/* 1376 */     if (this.packages != null) {
/* 1377 */       this.packages = getSearchJarsPackages(packagesProp);
/*      */     }
/*      */     
/* 1380 */     this.vanillaMode = p.getBoolean("vanillaMode", false);
/* 1381 */     this.vanillaRefMode = p.getBoolean("vanillaRefMode", false);
/* 1382 */     this.updateChangesOnly = p.getBoolean("updateChangesOnly", true);
/*      */     
/* 1384 */     boolean batchMode = p.getBoolean("batch.mode", false);
/* 1385 */     this.persistBatching = p.getBoolean("persistBatching", batchMode);
/*      */     
/* 1387 */     int batchSize = p.getInt("batch.size", 20);
/* 1388 */     this.persistBatchSize = p.getInt("persistBatchSize", batchSize);
/*      */     
/* 1390 */     this.dataSourceJndiName = p.get("dataSourceJndiName", null);
/* 1391 */     this.databaseSequenceBatchSize = p.getInt("databaseSequenceBatchSize", 20);
/* 1392 */     this.databaseBooleanTrue = p.get("databaseBooleanTrue", null);
/* 1393 */     this.databaseBooleanFalse = p.get("databaseBooleanFalse", null);
/* 1394 */     this.databasePlatformName = p.get("databasePlatformName", null);
/*      */     
/* 1396 */     this.lazyLoadBatchSize = p.getInt("lazyLoadBatchSize", 1);
/* 1397 */     this.queryBatchSize = p.getInt("queryBatchSize", 100);
/*      */     
/* 1399 */     this.ddlGenerate = p.getBoolean("ddl.generate", false);
/* 1400 */     this.ddlRun = p.getBoolean("ddl.run", false);
/* 1401 */     this.debugSql = p.getBoolean("debug.sql", false);
/* 1402 */     this.debugLazyLoad = p.getBoolean("debug.lazyload", false);
/*      */     
/* 1404 */     this.loggingLevel = getLogLevelValue(p);
/*      */     
/* 1406 */     String s = p.get("useJuliTransactionLogger", null);
/* 1407 */     s = p.get("loggingToJavaLogger", s);
/* 1408 */     this.loggingToJavaLogger = "true".equalsIgnoreCase(s);
/*      */     
/* 1410 */     s = p.get("log.directory", "logs");
/* 1411 */     this.loggingDirectory = p.get("logging.directory", s);
/*      */     
/* 1413 */     this.classes = getClasses(p);
/*      */   }
/*      */ 
/*      */   
/*      */   private LogLevel getLogLevelValue(ConfigPropertyMap p) {
/* 1418 */     String logValue = p.get("logging", "NONE");
/* 1419 */     logValue = p.get("log.level", logValue);
/* 1420 */     logValue = p.get("logging.level", logValue);
/* 1421 */     if (logValue.trim().equalsIgnoreCase("ALL")) {
/* 1422 */       logValue = "SQL";
/*      */     }
/* 1424 */     return Enum.<LogLevel>valueOf(LogLevel.class, logValue.toUpperCase());
/*      */   }
/*      */ 
/*      */   
/*      */   private NamingConvention createNamingConvention(GlobalProperties.PropertySource p) {
/* 1429 */     NamingConvention nc = createInstance(p, NamingConvention.class, "namingconvention");
/* 1430 */     if (nc == null) {
/* 1431 */       return null;
/*      */     }
/* 1433 */     if (nc instanceof AbstractNamingConvention) {
/* 1434 */       AbstractNamingConvention anc = (AbstractNamingConvention)nc;
/* 1435 */       String v = p.get("namingConvention.useForeignKeyPrefix", null);
/* 1436 */       if (v != null) {
/* 1437 */         boolean useForeignKeyPrefix = Boolean.valueOf(v).booleanValue();
/* 1438 */         anc.setUseForeignKeyPrefix(useForeignKeyPrefix);
/*      */       } 
/*      */       
/* 1441 */       String sequenceFormat = p.get("namingConvention.sequenceFormat", null);
/* 1442 */       if (sequenceFormat != null) {
/* 1443 */         anc.setSequenceFormat(sequenceFormat);
/*      */       }
/*      */     } 
/* 1446 */     return nc;
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
/*      */   private ArrayList<Class<?>> getClasses(GlobalProperties.PropertySource p) {
/* 1459 */     String classNames = p.get("classes", null);
/* 1460 */     if (classNames == null)
/*      */     {
/* 1462 */       return null;
/*      */     }
/*      */     
/* 1465 */     ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
/*      */     
/* 1467 */     String[] split = classNames.split("[ ,;]");
/* 1468 */     for (int i = 0; i < split.length; i++) {
/* 1469 */       String cn = split[i].trim();
/* 1470 */       if (cn.length() > 0 && !"class".equalsIgnoreCase(cn)) {
/*      */         try {
/* 1472 */           classes.add(ClassUtil.forName(cn, getClass()));
/* 1473 */         } catch (ClassNotFoundException e) {
/* 1474 */           String msg = "Error registering class [" + cn + "] from [" + classNames + "]";
/* 1475 */           throw new RuntimeException(msg, e);
/*      */         } 
/*      */       }
/*      */     } 
/* 1479 */     return classes;
/*      */   }
/*      */ 
/*      */   
/*      */   private List<String> getSearchJarsPackages(String searchPackages) {
/* 1484 */     List<String> hitList = new ArrayList<String>();
/*      */     
/* 1486 */     if (searchPackages != null) {
/*      */       
/* 1488 */       String[] entries = searchPackages.split("[ ,;]");
/* 1489 */       for (int i = 0; i < entries.length; i++) {
/* 1490 */         hitList.add(entries[i].trim());
/*      */       }
/*      */     } 
/* 1493 */     return hitList;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\ServerConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */