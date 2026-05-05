/*     */ package com.avaje.ebeaninternal.server.loadcontext;
/*     */ 
/*     */ import com.avaje.ebean.Transaction;
/*     */ import com.avaje.ebean.bean.BeanLoader;
/*     */ import com.avaje.ebean.bean.EntityBeanIntercept;
/*     */ import com.avaje.ebean.bean.ObjectGraphNode;
/*     */ import com.avaje.ebean.bean.PersistenceContext;
/*     */ import com.avaje.ebeaninternal.api.LoadBeanContext;
/*     */ import com.avaje.ebeaninternal.api.LoadBeanRequest;
/*     */ import com.avaje.ebeaninternal.api.LoadContext;
/*     */ import com.avaje.ebeaninternal.api.SpiQuery;
/*     */ import com.avaje.ebeaninternal.server.core.OrmQueryRequest;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
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
/*     */ public class DLoadBeanContext
/*     */   implements LoadBeanContext, BeanLoader
/*     */ {
/*     */   protected final DLoadContext parent;
/*     */   protected final BeanDescriptor<?> desc;
/*     */   protected final String path;
/*     */   protected final String fullPath;
/*     */   private final DLoadWeakList<EntityBeanIntercept> weakList;
/*     */   private final OrmQueryProperties queryProps;
/*     */   private int batchSize;
/*     */   
/*     */   public DLoadBeanContext(DLoadContext parent, BeanDescriptor<?> desc, String path, int batchSize, OrmQueryProperties queryProps) {
/*  56 */     this.parent = parent;
/*  57 */     this.desc = desc;
/*  58 */     this.path = path;
/*  59 */     this.batchSize = batchSize;
/*  60 */     this.queryProps = queryProps;
/*  61 */     this.weakList = new DLoadWeakList<EntityBeanIntercept>();
/*     */     
/*  63 */     if (parent.getRelativePath() == null) {
/*  64 */       this.fullPath = path;
/*     */     } else {
/*  66 */       this.fullPath = parent.getRelativePath() + "." + path;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void configureQuery(SpiQuery<?> query, String lazyLoadProperty) {
/*  73 */     query.setParentState(this.parent.getParentState());
/*  74 */     query.setParentNode(getObjectGraphNode());
/*  75 */     query.setLazyLoadProperty(lazyLoadProperty);
/*     */     
/*  77 */     if (this.queryProps != null) {
/*  78 */       this.queryProps.configureBeanQuery(query);
/*     */     }
/*  80 */     if (this.parent.isUseAutofetchManager()) {
/*  81 */       query.setAutofetch(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFullPath() {
/*  86 */     return this.fullPath;
/*     */   }
/*     */   
/*     */   public PersistenceContext getPersistenceContext() {
/*  90 */     return this.parent.getPersistenceContext();
/*     */   }
/*     */   
/*     */   public OrmQueryProperties getQueryProps() {
/*  94 */     return this.queryProps;
/*     */   }
/*     */   
/*     */   public ObjectGraphNode getObjectGraphNode() {
/*  98 */     return this.parent.getObjectGraphNode(this.path);
/*     */   }
/*     */   
/*     */   public String getPath() {
/* 102 */     return this.path;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 106 */     return this.parent.getEbeanServer().getName();
/*     */   }
/*     */   
/*     */   public int getBatchSize() {
/* 110 */     return this.batchSize;
/*     */   }
/*     */   
/*     */   public void setBatchSize(int batchSize) {
/* 114 */     this.batchSize = batchSize;
/*     */   }
/*     */   
/*     */   public BeanDescriptor<?> getBeanDescriptor() {
/* 118 */     return this.desc;
/*     */   }
/*     */   
/*     */   public LoadContext getGraphContext() {
/* 122 */     return this.parent;
/*     */   }
/*     */   
/*     */   public void register(EntityBeanIntercept ebi) {
/* 126 */     int pos = this.weakList.add(ebi);
/* 127 */     ebi.setBeanLoader(pos, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadBean(EntityBeanIntercept ebi) {
/* 132 */     if (this.desc.lazyLoadMany(ebi)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 137 */     int position = ebi.getBeanLoaderIndex();
/*     */ 
/*     */     
/* 140 */     List<EntityBeanIntercept> batch = this.weakList.getLoadBatch(position, this.batchSize);
/*     */     
/* 142 */     LoadBeanRequest req = new LoadBeanRequest(this, batch, null, this.batchSize, true, ebi.getLazyLoadProperty());
/* 143 */     this.parent.getEbeanServer().loadBean(req);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadSecondaryQuery(OrmQueryRequest<?> parentRequest, int requestedBatchSize, boolean all) {
/*     */     do {
/* 149 */       List<EntityBeanIntercept> batch = this.weakList.getNextBatch(requestedBatchSize);
/* 150 */       if (batch.size() == 0) {
/*     */         break;
/*     */       }
/*     */       
/* 154 */       LoadBeanRequest req = new LoadBeanRequest(this, batch, (Transaction)parentRequest.getTransaction(), requestedBatchSize, false, null);
/* 155 */       this.parent.getEbeanServer().loadBean(req);
/* 156 */     } while (all);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\loadcontext\DLoadBeanContext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */