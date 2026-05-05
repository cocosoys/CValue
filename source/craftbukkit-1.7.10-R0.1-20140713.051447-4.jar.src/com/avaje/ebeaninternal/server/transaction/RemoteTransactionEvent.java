/*     */ package com.avaje.ebeaninternal.server.transaction;
/*     */ 
/*     */ import com.avaje.ebeaninternal.api.SpiEbeanServer;
/*     */ import com.avaje.ebeaninternal.api.TransactionEventTable;
/*     */ import com.avaje.ebeaninternal.server.cluster.BinaryMessageList;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public class RemoteTransactionEvent
/*     */   implements Serializable, Runnable
/*     */ {
/*     */   private static final long serialVersionUID = 757920022500956949L;
/*  37 */   private List<BeanPersistIds> beanPersistList = new ArrayList<BeanPersistIds>();
/*     */   
/*     */   private List<TransactionEventTable.TableIUD> tableList;
/*     */   
/*     */   private List<BeanDeltaList> beanDeltaLists;
/*     */   
/*     */   private BeanDeltaMap beanDeltaMap;
/*     */   
/*     */   private List<IndexEvent> indexEventList;
/*     */   
/*     */   private Set<IndexInvalidate> indexInvalidations;
/*     */   
/*     */   private DeleteByIdMap deleteByIdMap;
/*     */   
/*     */   private String serverName;
/*     */   
/*     */   private transient SpiEbeanServer server;
/*     */   
/*     */   public RemoteTransactionEvent(String serverName) {
/*  56 */     this.serverName = serverName;
/*     */   }
/*     */   
/*     */   public RemoteTransactionEvent(SpiEbeanServer server) {
/*  60 */     this.server = server;
/*     */   }
/*     */   
/*     */   public void run() {
/*  64 */     this.server.remoteTransactionEvent(this);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  68 */     StringBuilder sb = new StringBuilder();
/*  69 */     if (this.beanDeltaMap != null) {
/*  70 */       sb.append(this.beanDeltaMap);
/*     */     }
/*  72 */     sb.append(this.beanPersistList);
/*  73 */     if (this.tableList != null) {
/*  74 */       sb.append(this.tableList);
/*     */     }
/*  76 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeBinaryMessage(BinaryMessageList msgList) throws IOException {
/*  81 */     if (this.indexInvalidations != null) {
/*  82 */       for (IndexInvalidate indexInvalidate : this.indexInvalidations) {
/*  83 */         indexInvalidate.writeBinaryMessage(msgList);
/*     */       }
/*     */     }
/*     */     
/*  87 */     if (this.tableList != null) {
/*  88 */       for (int i = 0; i < this.tableList.size(); i++) {
/*  89 */         ((TransactionEventTable.TableIUD)this.tableList.get(i)).writeBinaryMessage(msgList);
/*     */       }
/*     */     }
/*     */     
/*  93 */     if (this.deleteByIdMap != null) {
/*  94 */       for (BeanPersistIds deleteIds : this.deleteByIdMap.values()) {
/*  95 */         deleteIds.writeBinaryMessage(msgList);
/*     */       }
/*     */     }
/*     */     
/*  99 */     if (this.beanPersistList != null) {
/* 100 */       for (int i = 0; i < this.beanPersistList.size(); i++) {
/* 101 */         ((BeanPersistIds)this.beanPersistList.get(i)).writeBinaryMessage(msgList);
/*     */       }
/*     */     }
/*     */     
/* 105 */     if (this.beanDeltaLists != null) {
/* 106 */       for (int i = 0; i < this.beanDeltaLists.size(); i++) {
/* 107 */         ((BeanDeltaList)this.beanDeltaLists.get(i)).writeBinaryMessage(msgList);
/*     */       }
/*     */     }
/*     */     
/* 111 */     if (this.indexEventList != null) {
/* 112 */       for (int i = 0; i < this.indexEventList.size(); i++) {
/* 113 */         ((IndexEvent)this.indexEventList.get(i)).writeBinaryMessage(msgList);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 119 */     return (this.beanPersistList.isEmpty() && (this.tableList == null || this.tableList.isEmpty()));
/*     */   }
/*     */   
/*     */   public void addBeanPersistIds(BeanPersistIds beanPersist) {
/* 123 */     this.beanPersistList.add(beanPersist);
/*     */   }
/*     */   
/*     */   public void addIndexInvalidate(IndexInvalidate indexInvalidate) {
/* 127 */     if (this.indexInvalidations == null) {
/* 128 */       this.indexInvalidations = new HashSet<IndexInvalidate>();
/*     */     }
/* 130 */     this.indexInvalidations.add(indexInvalidate);
/*     */   }
/*     */   
/*     */   public void addTableIUD(TransactionEventTable.TableIUD tableIud) {
/* 134 */     if (this.tableList == null) {
/* 135 */       this.tableList = new ArrayList<TransactionEventTable.TableIUD>(4);
/*     */     }
/* 137 */     this.tableList.add(tableIud);
/*     */   }
/*     */   
/*     */   public void addBeanDeltaList(BeanDeltaList deltaList) {
/* 141 */     if (this.beanDeltaLists == null) {
/* 142 */       this.beanDeltaLists = new ArrayList<BeanDeltaList>();
/*     */     }
/* 144 */     this.beanDeltaLists.add(deltaList);
/*     */   }
/*     */   
/*     */   public void addBeanDelta(BeanDelta beanDelta) {
/* 148 */     if (this.beanDeltaMap == null) {
/* 149 */       this.beanDeltaMap = new BeanDeltaMap();
/*     */     }
/* 151 */     this.beanDeltaMap.addBeanDelta(beanDelta);
/*     */   }
/*     */   
/*     */   public void addIndexEvent(IndexEvent indexEvent) {
/* 155 */     if (this.indexEventList == null) {
/* 156 */       this.indexEventList = new ArrayList<IndexEvent>(2);
/*     */     }
/* 158 */     this.indexEventList.add(indexEvent);
/*     */   }
/*     */   
/*     */   public String getServerName() {
/* 162 */     return this.serverName;
/*     */   }
/*     */   
/*     */   public SpiEbeanServer getServer() {
/* 166 */     return this.server;
/*     */   }
/*     */   
/*     */   public void setServer(SpiEbeanServer server) {
/* 170 */     this.server = server;
/*     */   }
/*     */   
/*     */   public DeleteByIdMap getDeleteByIdMap() {
/* 174 */     return this.deleteByIdMap;
/*     */   }
/*     */   
/*     */   public void setDeleteByIdMap(DeleteByIdMap deleteByIdMap) {
/* 178 */     this.deleteByIdMap = deleteByIdMap;
/*     */   }
/*     */   
/*     */   public Set<IndexInvalidate> getIndexInvalidations() {
/* 182 */     return this.indexInvalidations;
/*     */   }
/*     */   
/*     */   public List<IndexEvent> getIndexEventList() {
/* 186 */     return this.indexEventList;
/*     */   }
/*     */   
/*     */   public List<TransactionEventTable.TableIUD> getTableIUDList() {
/* 190 */     return this.tableList;
/*     */   }
/*     */   
/*     */   public List<BeanPersistIds> getBeanPersistList() {
/* 194 */     return this.beanPersistList;
/*     */   }
/*     */   
/*     */   public List<BeanDeltaList> getBeanDeltaLists() {
/* 198 */     if (this.beanDeltaMap != null) {
/* 199 */       this.beanDeltaLists.addAll(this.beanDeltaMap.deltaLists());
/*     */     }
/* 201 */     return this.beanDeltaLists;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\transaction\RemoteTransactionEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */