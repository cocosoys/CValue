/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.item.EntityXPOrb;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class PlayerPickupXpEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final EntityXPOrb orb;
/*    */   
/*    */   public PlayerPickupXpEvent(EntityPlayer player, EntityXPOrb orb) {
/* 18 */     super(player);
/* 19 */     this.orb = orb;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerPickupXpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */