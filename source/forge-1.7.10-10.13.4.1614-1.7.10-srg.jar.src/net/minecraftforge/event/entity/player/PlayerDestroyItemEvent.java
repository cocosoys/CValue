/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
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
/*    */ public class PlayerDestroyItemEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final ItemStack original;
/*    */   
/*    */   public PlayerDestroyItemEvent(EntityPlayer player, ItemStack original) {
/* 30 */     super(player);
/* 31 */     this.original = original;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerDestroyItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */