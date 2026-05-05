/*    */ package net.minecraftforge.event.entity.item;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
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
/*    */ @Cancelable
/*    */ public class ItemTossEvent
/*    */   extends ItemEvent
/*    */ {
/*    */   public final EntityPlayer player;
/*    */   
/*    */   public ItemTossEvent(EntityItem entityItem, EntityPlayer player) {
/* 30 */     super(entityItem);
/* 31 */     this.player = player;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\item\ItemTossEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */