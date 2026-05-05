/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
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
/*    */ @Cancelable
/*    */ public class ArrowNockEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public ItemStack result;
/*    */   
/*    */   public ArrowNockEvent(EntityPlayer player, ItemStack result) {
/* 28 */     super(player);
/* 29 */     this.result = result;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\ArrowNockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */