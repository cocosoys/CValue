/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.Entity;
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
/*    */ @Cancelable
/*    */ public class EntityInteractEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final Entity target;
/*    */   
/*    */   public EntityInteractEvent(EntityPlayer player, Entity target) {
/* 28 */     super(player);
/* 29 */     this.target = target;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\EntityInteractEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */