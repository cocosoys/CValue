/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.stats.Achievement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class AchievementEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final Achievement achievement;
/*    */   
/*    */   public AchievementEvent(EntityPlayer player, Achievement achievement) {
/* 17 */     super(player);
/* 18 */     this.achievement = achievement;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\AchievementEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */