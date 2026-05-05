/*     */ package com.avaje.ebeaninternal.server.persist;
/*     */ 
/*     */ import com.avaje.ebeaninternal.api.SpiTransaction;
/*     */ import com.avaje.ebeaninternal.server.core.PersistRequest;
/*     */ import com.avaje.ebeaninternal.server.core.PersistRequestBean;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
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
/*     */ public class BatchedBeanControl
/*     */ {
/*  44 */   private final HashMap<String, BatchedBeanHolder> beanHoldMap = new HashMap<String, BatchedBeanHolder>();
/*     */   
/*     */   private final SpiTransaction transaction;
/*     */   
/*     */   private final BatchControl batchControl;
/*     */   
/*     */   private int topOrder;
/*     */   
/*     */   public BatchedBeanControl(SpiTransaction t, BatchControl batchControl) {
/*  53 */     this.transaction = t;
/*  54 */     this.batchControl = batchControl;
/*     */   }
/*     */   
/*     */   public ArrayList<PersistRequest> getPersistList(PersistRequestBean<?> request) {
/*  58 */     BatchedBeanHolder beanHolder = getBeanHolder(request);
/*  59 */     return beanHolder.getList(request);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BatchedBeanHolder getBeanHolder(PersistRequestBean<?> request) {
/*  68 */     BeanDescriptor<?> beanDescriptor = request.getBeanDescriptor();
/*  69 */     BatchedBeanHolder batchBeanHolder = this.beanHoldMap.get(beanDescriptor.getFullName());
/*  70 */     if (batchBeanHolder == null) {
/*  71 */       int relativeDepth = this.transaction.depth(0);
/*     */       
/*  73 */       if (relativeDepth == 0) {
/*  74 */         this.topOrder++;
/*     */       }
/*  76 */       int stmtOrder = this.topOrder * 100 + relativeDepth;
/*     */       
/*  78 */       batchBeanHolder = new BatchedBeanHolder(this.batchControl, beanDescriptor, stmtOrder);
/*  79 */       this.beanHoldMap.put(beanDescriptor.getFullName(), batchBeanHolder);
/*     */     } 
/*  81 */     return batchBeanHolder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  88 */     return this.beanHoldMap.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BatchedBeanHolder[] getArray() {
/*  98 */     BatchedBeanHolder[] bsArray = new BatchedBeanHolder[this.beanHoldMap.size()];
/*  99 */     this.beanHoldMap.values().toArray((Object[])bsArray);
/* 100 */     this.beanHoldMap.clear();
/* 101 */     this.topOrder = 0;
/* 102 */     return bsArray;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\persist\BatchedBeanControl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */