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
/*    */ 
/*    */ @Cancelable
/*    */ public class LivingFallEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public float distance;
/*    */   
/*    */   public LivingFallEvent(EntityLivingBase entity, float distance) {
/* 28 */     super(entity);
/* 29 */     this.distance = distance;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingFallEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */