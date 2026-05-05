/*     */ package com.avaje.ebeaninternal.server.loadcontext;
/*     */ 
/*     */ import com.avaje.ebean.Transaction;
/*     */ import com.avaje.ebean.bean.BeanCollection;
/*     */ import com.avaje.ebean.bean.BeanCollectionLoader;
/*     */ import com.avaje.ebean.bean.ObjectGraphNode;
/*     */ import com.avaje.ebean.bean.PersistenceContext;
/*     */ import com.avaje.ebeaninternal.api.LoadManyContext;
/*     */ import com.avaje.ebeaninternal.api.LoadManyRequest;
/*     */ import com.avaje.ebeaninternal.api.SpiQuery;
/*     */ import com.avaje.ebeaninternal.server.core.OrmQueryRequest;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocMany;
/*     */ import com.avaje.ebeaninternal.server.querydefn.OrmQueryProperties;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DLoadManyContext
/*     */   implements LoadManyContext, BeanCollectionLoader
/*     */ {
/*     */   protected final DLoadContext parent;
/*     */   protected final String fullPath;
/*     */   private final BeanDescriptor<?> desc;
/*     */   private final BeanPropertyAssocMany<?> property;
/*     */   private final String path;
/*     */   private final int batchSize;
/*     */   private final OrmQueryProperties queryProps;
/*     */   private final DLoadWeakList<BeanCollection<?>> weakList;
/*     */   
/*     */   public DLoadManyContext(DLoadContext parent, BeanPropertyAssocMany<?> p, String path, int batchSize, OrmQueryProperties queryProps) {
/*  57 */     this.parent = parent;
/*  58 */     this.property = p;
/*  59 */     this.desc = p.getBeanDescriptor();
/*  60 */     this.path = path;
/*  61 */     this.batchSize = batchSize;
/*  62 */     this.queryProps = queryProps;
/*  63 */     this.weakList = new DLoadWeakList<BeanCollection<?>>();
/*     */     
/*  65 */     if (parent.getRelativePath() == null) {
/*  66 */       this.fullPath = path;
/*     */     } else {
/*  68 */       this.fullPath = parent.getRelativePath() + "." + path;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void configureQuery(SpiQuery<?> query) {
/*  76 */     query.setParentState(this.parent.getParentState());
/*  77 */     query.setParentNode(getObjectGraphNode());
/*     */     
/*  79 */     if (this.queryProps != null) {
/*  80 */       this.queryProps.configureManyQuery(query);
/*     */     }
/*     */     
/*  83 */     if (this.parent.isUseAutofetchManager()) {
/*  84 */       query.setAutofetch(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectGraphNode getObjectGraphNode() {
/*  93 */     int pos = this.path.lastIndexOf('.');
/*  94 */     if (pos == -1) {
/*  95 */       return this.parent.getObjectGraphNode(null);
/*     */     }
/*  97 */     String parentPath = this.path.substring(0, pos);
/*  98 */     return this.parent.getObjectGraphNode(parentPath);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFullPath() {
/* 103 */     return this.fullPath;
/*     */   }
/*     */   
/*     */   public PersistenceContext getPersistenceContext() {
/* 107 */     return this.parent.getPersistenceContext();
/*     */   }
/*     */   
/*     */   public int getBatchSize() {
/* 111 */     return this.batchSize;
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocMany<?> getBeanProperty() {
/* 115 */     return this.property;
/*     */   }
/*     */   
/*     */   public BeanDescriptor<?> getBeanDescriptor() {
/* 119 */     return this.desc;
/*     */   }
/*     */   
/*     */   public String getPath() {
/* 123 */     return this.path;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 127 */     return this.parent.getEbeanServer().getName();
/*     */   }
/*     */   
/*     */   public void register(BeanCollection<?> bc) {
/* 131 */     int pos = this.weakList.add(bc);
/* 132 */     bc.setLoader(pos, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadMany(BeanCollection<?> bc, boolean onlyIds) {
/* 137 */     int position = bc.getLoaderIndex();
/*     */     
/* 139 */     List<BeanCollection<?>> loadBatch = this.weakList.getLoadBatch(position, this.batchSize);
/*     */     
/* 141 */     LoadManyRequest req = new LoadManyRequest(this, loadBatch, null, this.batchSize, true, onlyIds);
/* 142 */     this.parent.getEbeanServer().loadMany(req);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadSecondaryQuery(OrmQueryRequest<?> parentRequest, int requestedBatchSize, boolean all) {
/*     */     do {
/* 148 */       List<BeanCollection<?>> batch = this.weakList.getNextBatch(requestedBatchSize);
/* 149 */       if (batch.size() == 0) {
/*     */         break;
/*     */       }
/*     */       
/* 153 */       LoadManyRequest req = new LoadManyRequest(this, batch, (Transaction)parentRequest.getTransaction(), requestedBatchSize, false, false);
/* 154 */       this.parent.getEbeanServer().loadMany(req);
/* 155 */     } while (all);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\loadcontext\DLoadManyContext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */