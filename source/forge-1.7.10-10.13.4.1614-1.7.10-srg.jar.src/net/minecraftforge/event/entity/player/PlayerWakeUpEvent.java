/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class PlayerWakeUpEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final boolean wakeImmediatly;
/*    */   public final boolean updateWorld;
/*    */   public final boolean setSpawn;
/*    */   
/*    */   @Deprecated
/*    */   public PlayerWakeUpEvent(EntityPlayer player) {
/* 15 */     this(player, false, false, false);
/*    */   }
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
/*    */   public PlayerWakeUpEvent(EntityPlayer player, boolean wakeImmediatly, boolean updateWorld, boolean setSpawn) {
/* 37 */     super(player);
/* 38 */     this.wakeImmediatly = wakeImmediatly;
/* 39 */     this.updateWorld = updateWorld;
/* 40 */     this.setSpawn = setSpawn;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerWakeUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */