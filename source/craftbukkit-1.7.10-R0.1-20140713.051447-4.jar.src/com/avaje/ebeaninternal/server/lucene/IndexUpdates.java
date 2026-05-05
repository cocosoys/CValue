/*    */ package com.avaje.ebeaninternal.server.lucene;
/*    */ 
/*    */ import com.avaje.ebeaninternal.api.TransactionEventTable;
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*    */ import com.avaje.ebeaninternal.server.transaction.BeanDeltaList;
/*    */ import com.avaje.ebeaninternal.server.transaction.BeanPersistIds;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IndexUpdates
/*    */ {
/*    */   private final BeanDescriptor<?> beanDescriptor;
/*    */   private List<TransactionEventTable.TableIUD> tableList;
/*    */   private BeanPersistIds deleteIds;
/*    */   private BeanPersistIds beanPersistIds;
/*    */   private BeanDeltaList deltaList;
/*    */   private boolean invalidate;
/*    */   
/*    */   public IndexUpdates(BeanDescriptor<?> beanDescriptor) {
/* 45 */     this.beanDescriptor = beanDescriptor;
/*    */   }
/*    */   
/*    */   public BeanDescriptor<?> getBeanDescriptor() {
/* 49 */     return this.beanDescriptor;
/*    */   }
/*    */   
/*    */   public boolean isInvalidate() {
/* 53 */     return this.invalidate;
/*    */   }
/*    */   
/*    */   public void setInvalidate(boolean invalidate) {
/* 57 */     this.invalidate = invalidate;
/*    */   }
/*    */   
/*    */   public void addTableIUD(TransactionEventTable.TableIUD tableIud) {
/* 61 */     if (this.tableList == null) {
/* 62 */       this.tableList = new ArrayList<TransactionEventTable.TableIUD>(4);
/*    */     }
/* 64 */     this.tableList.add(tableIud);
/*    */   }
/*    */   
/*    */   public List<TransactionEventTable.TableIUD> getTableList() {
/* 68 */     return this.tableList;
/*    */   }
/*    */   
/*    */   public void setTableList(List<TransactionEventTable.TableIUD> tableList) {
/* 72 */     this.tableList = tableList;
/*    */   }
/*    */   
/*    */   public BeanPersistIds getBeanPersistIds() {
/* 76 */     return this.beanPersistIds;
/*    */   }
/*    */   
/*    */   public void setBeanPersistIds(BeanPersistIds beanPersistIds) {
/* 80 */     this.beanPersistIds = beanPersistIds;
/*    */   }
/*    */   
/*    */   public BeanPersistIds getDeleteIds() {
/* 84 */     return this.deleteIds;
/*    */   }
/*    */   
/*    */   public void setDeleteIds(BeanPersistIds deleteIds) {
/* 88 */     this.deleteIds = deleteIds;
/*    */   }
/*    */   
/*    */   public BeanDeltaList getDeltaList() {
/* 92 */     return this.deltaList;
/*    */   }
/*    */   
/*    */   public void setDeltaList(BeanDeltaList deltaList) {
/* 96 */     this.deltaList = deltaList;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\IndexUpdates.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */