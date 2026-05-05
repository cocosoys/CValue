/*    */ package net.minecraftforge.event.entity.living;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.DamageSource;
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
/*    */ @Cancelable
/*    */ public class LivingDeathEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public final DamageSource source;
/*    */   
/*    */   public LivingDeathEvent(EntityLivingBase entity, DamageSource source) {
/* 31 */     super(entity);
/* 32 */     this.source = source;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingDeathEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */