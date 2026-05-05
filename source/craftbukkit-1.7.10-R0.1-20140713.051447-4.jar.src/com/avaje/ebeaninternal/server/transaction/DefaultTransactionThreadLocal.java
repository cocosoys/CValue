/*     */ package com.avaje.ebeaninternal.server.transaction;
/*     */ 
/*     */ import com.avaje.ebeaninternal.api.SpiTransaction;
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
/*     */ public final class DefaultTransactionThreadLocal
/*     */ {
/*  31 */   private static ThreadLocal<TransactionMap> local = new ThreadLocal<TransactionMap>() {
/*     */       protected synchronized TransactionMap initialValue() {
/*  33 */         return new TransactionMap();
/*     */       }
/*     */     };
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
/*     */   private static TransactionMap.State getState(String serverName) {
/*  48 */     return ((TransactionMap)local.get()).getState(serverName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SpiTransaction get(String serverName) {
/*  55 */     return (getState(serverName)).transaction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void set(String serverName, SpiTransaction trans) {
/*  62 */     getState(serverName).set(trans);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void commit(String serverName) {
/*  69 */     getState(serverName).commit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void rollback(String serverName) {
/*  76 */     getState(serverName).rollback();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void end(String serverName) {
/*  99 */     getState(serverName).end();
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
/*     */   public static void replace(String serverName, SpiTransaction trans) {
/* 112 */     getState(serverName).replace(trans);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\transaction\DefaultTransactionThreadLocal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */