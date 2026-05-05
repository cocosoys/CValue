/*    */ package org.bukkit.event.block;
/*    */ 
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.event.Event;
/*    */ 
/*    */ 
/*    */ public abstract class BlockEvent
/*    */   extends Event
/*    */ {
/*    */   protected Block block;
/*    */   
/*    */   public BlockEvent(Block theBlock) {
/* 13 */     this.block = theBlock;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Block getBlock() {
/* 22 */     return this.block;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\block\BlockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */