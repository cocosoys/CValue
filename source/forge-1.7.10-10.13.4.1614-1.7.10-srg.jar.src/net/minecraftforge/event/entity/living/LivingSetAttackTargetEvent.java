/*    */ package net.minecraftforge.event.entity.living;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
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
/*    */ public class LivingSetAttackTargetEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public final EntityLivingBase target;
/*    */   
/*    */   public LivingSetAttackTargetEvent(EntityLivingBase entity, EntityLivingBase target) {
/* 27 */     super(entity);
/* 28 */     this.target = target;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingSetAttackTargetEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */