/*    */ package com.avaje.ebeaninternal.server.lucene;
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
/*    */ public class LIndexVersion
/*    */ {
/*    */   private final long generation;
/*    */   private final long version;
/*    */   
/*    */   public LIndexVersion(long generation, long version) {
/* 29 */     this.generation = generation;
/* 30 */     this.version = version;
/*    */   }
/*    */   
/*    */   public long getGeneration() {
/* 34 */     return this.generation;
/*    */   }
/*    */   
/*    */   public long getVersion() {
/* 38 */     return this.version;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 42 */     return "gen[" + this.generation + "] ver[" + this.version + "]";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexVersion.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */