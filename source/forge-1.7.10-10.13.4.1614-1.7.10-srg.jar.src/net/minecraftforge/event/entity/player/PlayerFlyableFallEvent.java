/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerFlyableFallEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public float distance;
/*    */   
/*    */   public PlayerFlyableFallEvent(EntityPlayer player, float f) {
/* 17 */     super(player);
/* 18 */     this.distance = f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerFlyableFallEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */