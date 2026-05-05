/*    */ package net.minecraftforge.event.entity.living;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class EnderTeleportEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public double targetX;
/*    */   public double targetY;
/*    */   public double targetZ;
/*    */   public float attackDamage;
/*    */   
/*    */   public EnderTeleportEvent(EntityLivingBase entity, double targetX, double targetY, double targetZ, float attackDamage) {
/* 22 */     super(entity);
/* 23 */     this.targetX = targetX;
/* 24 */     this.targetY = targetY;
/* 25 */     this.targetZ = targetZ;
/* 26 */     this.attackDamage = attackDamage;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\EnderTeleportEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */