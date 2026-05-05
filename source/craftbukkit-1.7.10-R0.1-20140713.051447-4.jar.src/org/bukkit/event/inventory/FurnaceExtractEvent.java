/*    */ package org.bukkit.event.inventory;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.block.BlockExpEvent;
/*    */ 
/*    */ 
/*    */ public class FurnaceExtractEvent
/*    */   extends BlockExpEvent
/*    */ {
/*    */   private final Player player;
/*    */   private final Material itemType;
/*    */   private final int itemAmount;
/*    */   
/*    */   public FurnaceExtractEvent(Player player, Block block, Material itemType, int itemAmount, int exp) {
/* 17 */     super(block, exp);
/* 18 */     this.player = player;
/* 19 */     this.itemType = itemType;
/* 20 */     this.itemAmount = itemAmount;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Player getPlayer() {
/* 29 */     return this.player;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Material getItemType() {
/* 38 */     return this.itemType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getItemAmount() {
/* 47 */     return this.itemAmount;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\inventory\FurnaceExtractEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */