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
/*    */ 
/*    */ @Cancelable
/*    */ public class ArrowLooseEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final ItemStack bow;
/*    */   public int charge;
/*    */   
/*    */   public ArrowLooseEvent(EntityPlayer player, ItemStack bow, int charge) {
/* 30 */     super(player);
/* 31 */     this.bow = bow;
/* 32 */     this.charge = charge;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\ArrowLooseEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */