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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class LivingHealEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public float amount;
/*    */   
/*    */   public LivingHealEvent(EntityLivingBase entity, float amount) {
/* 27 */     super(entity);
/* 28 */     this.amount = amount;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingHealEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */