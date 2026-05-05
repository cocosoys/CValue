/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
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
/*    */ @HasResult
/*    */ public class PlayerOpenContainerEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final boolean canInteractWith;
/*    */   
/*    */   public PlayerOpenContainerEvent(EntityPlayer player, Container openContainer) {
/* 26 */     super(player);
/* 27 */     this.canInteractWith = openContainer.canInteractWith(player);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerOpenContainerEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */