/*    */ package org.bukkit.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum EventPriority
/*    */ {
/* 12 */   LOWEST(0),
/*    */ 
/*    */ 
/*    */   
/* 16 */   LOW(1),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 21 */   NORMAL(2),
/*    */ 
/*    */ 
/*    */   
/* 25 */   HIGH(3),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 30 */   HIGHEST(4),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   MONITOR(5);
/*    */   
/*    */   private final int slot;
/*    */   
/*    */   EventPriority(int slot) {
/* 41 */     this.slot = slot;
/*    */   }
/*    */   
/*    */   public int getSlot() {
/* 45 */     return this.slot;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\EventPriority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */