/*    */ package com.avaje.ebeaninternal.server.cluster;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class DataHolder
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 9090748723571322192L;
/*    */   private final byte[] data;
/*    */   
/*    */   public DataHolder(byte[] data) {
/* 36 */     this.data = data;
/*    */   }
/*    */   
/*    */   public byte[] getData() {
/* 40 */     return this.data;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\cluster\DataHolder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */