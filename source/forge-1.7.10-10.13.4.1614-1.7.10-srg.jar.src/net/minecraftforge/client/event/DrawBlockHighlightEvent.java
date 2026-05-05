/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.renderer.RenderGlobal;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ 
/*    */ @Cancelable
/*    */ public class DrawBlockHighlightEvent
/*    */   extends Event
/*    */ {
/*    */   public final RenderGlobal context;
/*    */   public final EntityPlayer player;
/*    */   public final MovingObjectPosition target;
/*    */   public final int subID;
/*    */   public final ItemStack currentItem;
/*    */   public final float partialTicks;
/*    */   
/*    */   public DrawBlockHighlightEvent(RenderGlobal context, EntityPlayer player, MovingObjectPosition target, int subID, ItemStack currentItem, float partialTicks) {
/* 22 */     this.context = context;
/* 23 */     this.player = player;
/* 24 */     this.target = target;
/* 25 */     this.subID = subID;
/* 26 */     this.currentItem = currentItem;
/* 27 */     this.partialTicks = partialTicks;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\DrawBlockHighlightEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */