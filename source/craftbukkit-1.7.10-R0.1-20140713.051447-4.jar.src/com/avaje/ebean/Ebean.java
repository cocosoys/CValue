/*      */ package com.avaje.ebean;
/*      */ 
/*      */ import com.avaje.ebean.cache.ServerCacheManager;
/*      */ import com.avaje.ebean.config.GlobalProperties;
/*      */ import com.avaje.ebean.text.csv.CsvReader;
/*      */ import com.avaje.ebean.text.json.JsonContext;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.logging.Logger;
/*      */ import javax.persistence.OptimisticLockException;
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
/*      */ public final class Ebean
/*      */ {
/*  138 */   private static final Logger logger = Logger.getLogger(Ebean.class.getName());
/*      */ 
/*      */   
/*      */   private static final String EBVERSION = "2.7.3";
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  146 */     String version = System.getProperty("java.version");
/*  147 */     logger.info("Ebean Version[2.7.3] Java Version[" + version + "]");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  153 */   private static final ServerManager serverMgr = new ServerManager();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class ServerManager
/*      */   {
/*  164 */     private final ConcurrentHashMap<String, EbeanServer> concMap = new ConcurrentHashMap<String, EbeanServer>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  170 */     private final HashMap<String, EbeanServer> syncMap = new HashMap<String, EbeanServer>();
/*      */     
/*  172 */     private final Object monitor = new Object();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private EbeanServer primaryServer;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private ServerManager() {
/*  183 */       if (GlobalProperties.isSkipPrimaryServer()) {
/*      */ 
/*      */         
/*  186 */         Ebean.logger.fine("GlobalProperties.isSkipPrimaryServer()");
/*      */       }
/*      */       else {
/*      */         
/*  190 */         String primaryName = getPrimaryServerName();
/*  191 */         Ebean.logger.fine("primaryName:" + primaryName);
/*  192 */         if (primaryName != null && primaryName.trim().length() > 0) {
/*  193 */           this.primaryServer = getWithCreate(primaryName.trim());
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private String getPrimaryServerName() {
/*  200 */       String serverName = GlobalProperties.get("ebean.default.datasource", null);
/*  201 */       return GlobalProperties.get("datasource.default", serverName);
/*      */     }
/*      */     
/*      */     private EbeanServer getPrimaryServer() {
/*  205 */       if (this.primaryServer == null) {
/*  206 */         String msg = "The default EbeanServer has not been defined?";
/*  207 */         msg = msg + " This is normally set via the ebean.datasource.default property.";
/*  208 */         msg = msg + " Otherwise it should be registered programatically via registerServer()";
/*  209 */         throw new PersistenceException(msg);
/*      */       } 
/*  211 */       return this.primaryServer;
/*      */     }
/*      */     
/*      */     private EbeanServer get(String name) {
/*  215 */       if (name == null || name.length() == 0) {
/*  216 */         return this.primaryServer;
/*      */       }
/*      */       
/*  219 */       EbeanServer server = this.concMap.get(name);
/*  220 */       if (server != null) {
/*  221 */         return server;
/*      */       }
/*      */       
/*  224 */       return getWithCreate(name);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private EbeanServer getWithCreate(String name) {
/*  232 */       synchronized (this.monitor) {
/*      */         
/*  234 */         EbeanServer server = this.syncMap.get(name);
/*  235 */         if (server == null) {
/*      */           
/*  237 */           server = EbeanServerFactory.create(name);
/*  238 */           register(server, false);
/*      */         } 
/*  240 */         return server;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void register(EbeanServer server, boolean isPrimaryServer) {
/*  248 */       synchronized (this.monitor) {
/*  249 */         this.concMap.put(server.getName(), server);
/*  250 */         EbeanServer existingServer = this.syncMap.put(server.getName(), server);
/*  251 */         if (existingServer != null) {
/*  252 */           String msg = "Existing EbeanServer [" + server.getName() + "] is being replaced?";
/*  253 */           Ebean.logger.warning(msg);
/*      */         } 
/*      */         
/*  256 */         if (isPrimaryServer) {
/*  257 */           this.primaryServer = server;
/*      */         }
/*      */       } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static EbeanServer getServer(String name) {
/*  288 */     return serverMgr.get(name);
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
/*      */   public static ExpressionFactory getExpressionFactory() {
/*  309 */     return serverMgr.getPrimaryServer().getExpressionFactory();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static void register(EbeanServer server, boolean isPrimaryServer) {
/*  317 */     serverMgr.register(server, isPrimaryServer);
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
/*      */   public static Object nextId(Class<?> beanType) {
/*  333 */     return serverMgr.getPrimaryServer().nextId(beanType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void logComment(String msg) {
/*  343 */     serverMgr.getPrimaryServer().logComment(msg);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Transaction beginTransaction() {
/*  386 */     return serverMgr.getPrimaryServer().beginTransaction();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Transaction beginTransaction(TxIsolation isolation) {
/*  397 */     return serverMgr.getPrimaryServer().beginTransaction(isolation);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Transaction currentTransaction() {
/*  405 */     return serverMgr.getPrimaryServer().currentTransaction();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void commitTransaction() {
/*  412 */     serverMgr.getPrimaryServer().commitTransaction();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void rollbackTransaction() {
/*  419 */     serverMgr.getPrimaryServer().rollbackTransaction();
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void endTransaction() {
/*  446 */     serverMgr.getPrimaryServer().endTransaction();
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
/*      */   public static InvalidValue validate(Object bean) {
/*  465 */     return serverMgr.getPrimaryServer().validate(bean);
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
/*      */   
/*      */   public static InvalidValue[] validate(Object bean, String propertyName, Object value) {
/*  489 */     return serverMgr.getPrimaryServer().validate(bean, propertyName, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<String, ValuePair> diff(Object a, Object b) {
/*  500 */     return serverMgr.getPrimaryServer().diff(a, b);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void save(Object bean) throws OptimisticLockException {
/*  538 */     serverMgr.getPrimaryServer().save(bean);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void update(Object bean) {
/*  581 */     serverMgr.getPrimaryServer().update(bean);
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
/*      */   public static void update(Object bean, Set<String> updateProps) {
/*  601 */     serverMgr.getPrimaryServer().update(bean, updateProps);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int save(Iterator<?> iterator) throws OptimisticLockException {
/*  608 */     return serverMgr.getPrimaryServer().save(iterator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int save(Collection<?> c) throws OptimisticLockException {
/*  615 */     return save(c.iterator());
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
/*      */   public static int deleteManyToManyAssociations(Object ownerBean, String propertyName) {
/*  629 */     return serverMgr.getPrimaryServer().deleteManyToManyAssociations(ownerBean, propertyName);
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
/*      */   public static void saveManyToManyAssociations(Object ownerBean, String propertyName) {
/*  647 */     serverMgr.getPrimaryServer().saveManyToManyAssociations(ownerBean, propertyName);
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
/*      */   public static void saveAssociation(Object ownerBean, String propertyName) {
/*  667 */     serverMgr.getPrimaryServer().saveAssociation(ownerBean, propertyName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void delete(Object bean) throws OptimisticLockException {
/*  678 */     serverMgr.getPrimaryServer().delete(bean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int delete(Class<?> beanType, Object id) {
/*  685 */     return serverMgr.getPrimaryServer().delete(beanType, id);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void delete(Class<?> beanType, Collection<?> ids) {
/*  692 */     serverMgr.getPrimaryServer().delete(beanType, ids);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int delete(Iterator<?> it) throws OptimisticLockException {
/*  699 */     return serverMgr.getPrimaryServer().delete(it);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int delete(Collection<?> c) throws OptimisticLockException {
/*  706 */     return delete(c.iterator());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void refresh(Object bean) {
/*  716 */     serverMgr.getPrimaryServer().refresh(bean);
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
/*      */   public static void refreshMany(Object bean, String manyPropertyName) {
/*  735 */     serverMgr.getPrimaryServer().refreshMany(bean, manyPropertyName);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T getReference(Class<T> beanType, Object id) {
/*  761 */     return serverMgr.getPrimaryServer().getReference(beanType, id);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> void sort(List<T> list, String sortByClause) {
/*  807 */     serverMgr.getPrimaryServer().sort(list, sortByClause);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T find(Class<T> beanType, Object id) {
/*  855 */     return serverMgr.getPrimaryServer().find(beanType, id);
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
/*      */   public static SqlQuery createSqlQuery(String sql) {
/*  867 */     return serverMgr.getPrimaryServer().createSqlQuery(sql);
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
/*      */   public static SqlQuery createNamedSqlQuery(String namedQuery) {
/*  880 */     return serverMgr.getPrimaryServer().createNamedSqlQuery(namedQuery);
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
/*      */   public static SqlUpdate createSqlUpdate(String sql) {
/*  900 */     return serverMgr.getPrimaryServer().createSqlUpdate(sql);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CallableSql createCallableSql(String sql) {
/*  909 */     return serverMgr.getPrimaryServer().createCallableSql(sql);
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
/*      */   public static SqlUpdate createNamedSqlUpdate(String namedQuery) {
/*  930 */     return serverMgr.getPrimaryServer().createNamedSqlUpdate(namedQuery);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Query<T> createNamedQuery(Class<T> beanType, String namedQuery) {
/*  957 */     return serverMgr.getPrimaryServer().createNamedQuery(beanType, namedQuery);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Query<T> createQuery(Class<T> beanType, String query) {
/*  985 */     return serverMgr.getPrimaryServer().createQuery(beanType, query);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Update<T> createNamedUpdate(Class<T> beanType, String namedUpdate) {
/* 1041 */     return serverMgr.getPrimaryServer().createNamedUpdate(beanType, namedUpdate);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Update<T> createUpdate(Class<T> beanType, String ormUpdate) {
/* 1074 */     return serverMgr.getPrimaryServer().createUpdate(beanType, ormUpdate);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> CsvReader<T> createCsvReader(Class<T> beanType) {
/* 1082 */     return serverMgr.getPrimaryServer().createCsvReader(beanType);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Query<T> createQuery(Class<T> beanType) {
/* 1138 */     return serverMgr.getPrimaryServer().createQuery(beanType);
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
/*      */   public static <T> Query<T> find(Class<T> beanType) {
/* 1155 */     return serverMgr.getPrimaryServer().find(beanType);
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
/*      */   public static <T> Filter<T> filter(Class<T> beanType) {
/* 1169 */     return serverMgr.getPrimaryServer().filter(beanType);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int execute(SqlUpdate sqlUpdate) {
/* 1214 */     return serverMgr.getPrimaryServer().execute(sqlUpdate);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int execute(CallableSql callableSql) {
/* 1241 */     return serverMgr.getPrimaryServer().execute(callableSql);
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
/*      */   
/*      */   public static void execute(TxScope scope, TxRunnable r) {
/* 1265 */     serverMgr.getPrimaryServer().execute(scope, r);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void execute(TxRunnable r) {
/* 1291 */     serverMgr.getPrimaryServer().execute(r);
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
/*      */ 
/*      */   
/*      */   public static <T> T execute(TxScope scope, TxCallable<T> c) {
/* 1316 */     return serverMgr.getPrimaryServer().execute(scope, c);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T execute(TxCallable<T> c) {
/* 1348 */     return serverMgr.getPrimaryServer().execute(c);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void externalModification(String tableName, boolean inserts, boolean updates, boolean deletes) {
/* 1388 */     serverMgr.getPrimaryServer().externalModification(tableName, inserts, updates, deletes);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BeanState getBeanState(Object bean) {
/* 1399 */     return serverMgr.getPrimaryServer().getBeanState(bean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ServerCacheManager getServerCacheManager() {
/* 1407 */     return serverMgr.getPrimaryServer().getServerCacheManager();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BackgroundExecutor getBackgroundExecutor() {
/* 1415 */     return serverMgr.getPrimaryServer().getBackgroundExecutor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void runCacheWarming() {
/* 1426 */     serverMgr.getPrimaryServer().runCacheWarming();
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
/*      */   public static void runCacheWarming(Class<?> beanType) {
/* 1438 */     serverMgr.getPrimaryServer().runCacheWarming(beanType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static JsonContext createJsonContext() {
/* 1446 */     return serverMgr.getPrimaryServer().createJsonContext();
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\Ebean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */