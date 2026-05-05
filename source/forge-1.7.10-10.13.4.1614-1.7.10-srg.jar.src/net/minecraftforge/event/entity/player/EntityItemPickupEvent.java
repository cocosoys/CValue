/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
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
/*    */ @Cancelable
/*    */ @HasResult
/*    */ public class EntityItemPickupEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final EntityItem item;
/*    */   
/*    */   public EntityItemPickupEvent(EntityPlayer player, EntityItem item) {
/* 26 */     super(player);
/* 27 */     this.item = item;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\EntityItemPickupEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */