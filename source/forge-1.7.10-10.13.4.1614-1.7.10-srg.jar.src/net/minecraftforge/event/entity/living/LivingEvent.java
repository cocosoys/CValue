/*    */ package net.minecraftforge.event.entity.living;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraftforge.event.entity.EntityEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LivingEvent
/*    */   extends EntityEvent
/*    */ {
/*    */   public final EntityLivingBase entityLiving;
/*    */   
/*    */   public LivingEvent(EntityLivingBase entity) {
/* 19 */     super((Entity)entity);
/* 20 */     this.entityLiving = entity;
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
/*    */   @Cancelable
/*    */   public static class LivingUpdateEvent
/*    */     extends LivingEvent
/*    */   {
/*    */     public LivingUpdateEvent(EntityLivingBase e) {
/* 40 */       super(e);
/*    */     }
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
/*    */   public static class LivingJumpEvent
/*    */     extends LivingEvent
/*    */   {
/*    */     public LivingJumpEvent(EntityLivingBase e) {
/* 59 */       super(e);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */