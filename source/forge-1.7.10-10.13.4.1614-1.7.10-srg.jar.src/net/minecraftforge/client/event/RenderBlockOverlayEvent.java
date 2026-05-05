/*    */ package net.minecraftforge.client.event;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ @Cancelable
/*    */ public class RenderBlockOverlayEvent extends Event {
/*    */   public final EntityPlayer player;
/*    */   public final float renderPartialTicks;
/*    */   public final OverlayType overlayType;
/*    */   public final Block blockForOverlay;
/*    */   public final int blockX;
/*    */   public final int blockY;
/*    */   public final int blockZ;
/*    */   
/*    */   public enum OverlayType {
/* 16 */     FIRE, BLOCK, WATER;
/*    */   }
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
/*    */   public RenderBlockOverlayEvent(EntityPlayer player, float renderPartialTicks, OverlayType type, Block block, int blockX, int blockY, int blockZ) {
/* 38 */     this.player = player;
/* 39 */     this.renderPartialTicks = renderPartialTicks;
/* 40 */     this.overlayType = type;
/* 41 */     if (this.overlayType == OverlayType.BLOCK) {
/* 42 */       this.blockForOverlay = block;
/*    */     } else {
/* 44 */       this.blockForOverlay = null;
/* 45 */     }  this.blockX = blockX;
/* 46 */     this.blockY = blockY;
/* 47 */     this.blockZ = blockZ;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\RenderBlockOverlayEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */