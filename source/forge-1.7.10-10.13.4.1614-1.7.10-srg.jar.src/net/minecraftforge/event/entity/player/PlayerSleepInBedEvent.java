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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerSleepInBedEvent
/*    */   extends PlayerEvent
/*    */ {
/* 23 */   public EntityPlayer.EnumStatus result = null;
/*    */   
/*    */   public final int x;
/*    */   public final int y;
/*    */   public final int z;
/*    */   
/*    */   public PlayerSleepInBedEvent(EntityPlayer player, int x, int y, int z) {
/* 30 */     super(player);
/* 31 */     this.x = x;
/* 32 */     this.y = y;
/* 33 */     this.z = z;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerSleepInBedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */