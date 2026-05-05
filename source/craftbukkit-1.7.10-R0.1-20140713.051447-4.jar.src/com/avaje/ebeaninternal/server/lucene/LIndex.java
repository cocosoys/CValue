/*     */ package com.avaje.ebeaninternal.server.lucene;
/*     */ 
/*     */ import com.avaje.ebean.config.lucene.IndexUpdateFuture;
/*     */ import com.avaje.ebean.config.lucene.LuceneIndex;
/*     */ import com.avaje.ebeaninternal.api.SpiQuery;
/*     */ import com.avaje.ebeaninternal.api.TransactionEventTable;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.server.querydefn.OrmQueryDetail;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.lucene.analysis.Analyzer;
/*     */ import org.apache.lucene.document.Document;
/*     */ import org.apache.lucene.index.IndexWriter;
/*     */ import org.apache.lucene.index.Term;
/*     */ import org.apache.lucene.queryParser.QueryParser;
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
/*     */ public class LIndex
/*     */   implements LuceneIndex
/*     */ {
/*     */   private final DefaultLuceneIndexManager manager;
/*     */   private final String name;
/*     */   private final Analyzer analyzer;
/*     */   private final IndexWriter.MaxFieldLength maxFieldLength;
/*     */   private final LIndexFields fieldDefn;
/*     */   private final BeanDescriptor<?> desc;
/*     */   private final OrmQueryDetail ormQueryDetail;
/*     */   private final LIndexIo indexIo;
/*     */   private final LIndexFieldId idField;
/*  62 */   private final Object syncMonitor = new Object();
/*     */ 
/*     */   
/*     */   private boolean runningSync;
/*     */   
/*     */   private LIndexSync queuedSync;
/*     */ 
/*     */   
/*     */   public LIndex(DefaultLuceneIndexManager manager, String indexName, String indexDir, Analyzer analyzer, IndexWriter.MaxFieldLength maxFieldLength, BeanDescriptor<?> desc, LIndexFields fieldDefn, String[] updateProps) throws IOException {
/*  71 */     this.manager = manager;
/*  72 */     this.name = desc.getFullName();
/*  73 */     this.analyzer = analyzer;
/*  74 */     this.maxFieldLength = maxFieldLength;
/*  75 */     this.desc = desc;
/*  76 */     this.fieldDefn = fieldDefn;
/*  77 */     this.idField = fieldDefn.getIdField();
/*  78 */     this.ormQueryDetail = fieldDefn.getOrmQueryDetail();
/*     */     
/*  80 */     this.indexIo = new LIndexIo(manager, indexDir, this, updateProps);
/*  81 */     manager.addIndex(this);
/*  82 */     fieldDefn.registerIndexWithProperties(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void syncFinished(boolean success) {
/*  91 */     synchronized (this.syncMonitor) {
/*  92 */       this.runningSync = false;
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
/*     */   
/*     */   public void queueSync(String masterHost) {
/* 105 */     synchronized (this.syncMonitor) {
/* 106 */       LIndexSync sync = new LIndexSync(this, masterHost);
/* 107 */       if (!this.runningSync) {
/*     */         
/* 109 */         this.runningSync = true;
/* 110 */         this.manager.execute(sync);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 116 */         this.queuedSync = sync;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void manage(LuceneIndexManager indexManager) {
/* 126 */     synchronized (this.syncMonitor) {
/* 127 */       this.indexIo.manage(indexManager);
/* 128 */       if (!this.runningSync && this.queuedSync != null) {
/*     */         
/* 130 */         LIndexSync sync = this.queuedSync;
/* 131 */         this.runningSync = true;
/* 132 */         this.queuedSync = null;
/* 133 */         this.manager.execute(sync);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addNotifyCommitRunnable(Runnable r) {
/* 139 */     this.indexIo.addNotifyCommitRunnable(r);
/*     */   }
/*     */   
/*     */   public LIndexVersion getLastestVersion() {
/* 143 */     return this.indexIo.getLastestVersion();
/*     */   }
/*     */   
/*     */   public File getIndexDir() {
/* 147 */     return this.indexIo.getIndexDir();
/*     */   }
/*     */   
/*     */   public void refresh(boolean nearRealTime) {
/* 151 */     this.indexIo.refresh(nearRealTime);
/*     */   }
/*     */   
/*     */   public LIndexFileInfo getLocalFile(String fileName) {
/* 155 */     return this.indexIo.getLocalFile(fileName);
/*     */   }
/*     */   
/*     */   public LIndexCommitInfo obtainLastIndexCommitIfNewer(long remoteIndexVersion) {
/* 159 */     return this.indexIo.obtainLastIndexCommitIfNewer(remoteIndexVersion);
/*     */   }
/*     */   
/*     */   public void releaseIndexCommit(long remoteIndexVersion) {
/* 163 */     this.indexIo.releaseIndexCommit(remoteIndexVersion);
/*     */   }
/*     */   
/*     */   public LIndexFileInfo getFile(long remoteIndexVersion, String fileName) {
/* 167 */     return this.indexIo.getFile(remoteIndexVersion, fileName);
/*     */   }
/*     */   
/*     */   public Term createIdTerm(Object id) {
/* 171 */     return this.idField.createTerm(id);
/*     */   }
/*     */   
/*     */   public void shutdown() {
/* 175 */     this.indexIo.shutdown();
/*     */   }
/*     */   
/*     */   public LIndexUpdateFuture rebuild() {
/* 179 */     LIndexUpdateFuture future = new LIndexUpdateFuture(this.desc.getBeanType());
/* 180 */     this.indexIo.addWorkToQueue(LIndexWork.newRebuild(future));
/* 181 */     return future;
/*     */   }
/*     */   
/*     */   public LIndexUpdateFuture update() {
/* 185 */     LIndexUpdateFuture future = new LIndexUpdateFuture(this.desc.getBeanType());
/* 186 */     this.indexIo.addWorkToQueue(LIndexWork.newQueryUpdate(future));
/* 187 */     return future;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 191 */     return this.name;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 195 */     return this.name;
/*     */   }
/*     */   
/*     */   public Class<?> getBeanType() {
/* 199 */     return this.desc.getBeanType();
/*     */   }
/*     */   
/*     */   public BeanDescriptor<?> getBeanDescriptor() {
/* 203 */     return this.desc;
/*     */   }
/*     */   
/*     */   public LIndexSearch getIndexSearch() {
/* 207 */     return this.indexIo.getIndexSearch();
/*     */   }
/*     */   
/*     */   public Analyzer getAnalyzer() {
/* 211 */     return this.analyzer;
/*     */   }
/*     */   
/*     */   public IndexWriter.MaxFieldLength getMaxFieldLength() {
/* 215 */     return this.maxFieldLength;
/*     */   }
/*     */   
/*     */   public QueryParser createQueryParser(String fieldName) {
/* 219 */     QueryParser p = this.fieldDefn.createQueryParser(fieldName);
/* 220 */     p.setDefaultOperator(QueryParser.Operator.AND);
/* 221 */     return p;
/*     */   }
/*     */   
/*     */   public LIndexFields getIndexFieldDefn() {
/* 225 */     return this.fieldDefn;
/*     */   }
/*     */   
/*     */   public Set<String> getResolvePropertyNames() {
/* 229 */     return this.fieldDefn.getResolvePropertyNames();
/*     */   }
/*     */   
/*     */   public OrmQueryDetail getOrmQueryDetail() {
/* 233 */     return this.ormQueryDetail;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object readDocument(Document doc) {
/* 238 */     Object bean = this.desc.createEntityBean();
/* 239 */     this.fieldDefn.readDocument(doc, bean);
/* 240 */     return bean;
/*     */   }
/*     */   
/*     */   public DocFieldWriter createDocFieldWriter() {
/* 244 */     return this.fieldDefn.createDocFieldWriter();
/*     */   }
/*     */   
/*     */   public SpiQuery<?> createQuery() {
/* 248 */     return this.indexIo.createQuery();
/*     */   }
/*     */ 
/*     */   
/*     */   public LIndexUpdateFuture process(IndexUpdates indexUpdates) {
/* 253 */     List<TransactionEventTable.TableIUD> tableList = indexUpdates.getTableList();
/* 254 */     if (tableList != null && tableList.size() > 0) {
/* 255 */       boolean bulkDelete = false;
/* 256 */       for (int i = 0; i < tableList.size(); i++) {
/* 257 */         TransactionEventTable.TableIUD bulkTableEvent = tableList.get(i);
/* 258 */         if (bulkTableEvent.isDelete()) {
/* 259 */           bulkDelete = true;
/*     */         }
/*     */       } 
/* 262 */       if (bulkDelete) {
/* 263 */         return rebuild();
/*     */       }
/* 265 */       return update();
/*     */     } 
/*     */ 
/*     */     
/* 269 */     if (indexUpdates.isInvalidate()) {
/* 270 */       return update();
/*     */     }
/*     */     
/* 273 */     LIndexUpdateFuture f = new LIndexUpdateFuture(this.desc.getBeanType());
/* 274 */     this.indexIo.addWorkToQueue(LIndexWork.newTxnUpdate(f, indexUpdates));
/* 275 */     return f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndex.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */