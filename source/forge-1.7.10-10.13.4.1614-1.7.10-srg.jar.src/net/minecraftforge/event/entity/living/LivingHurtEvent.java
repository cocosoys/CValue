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
/*    */ public class LivingHurtEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public final DamageSource source;
/*    */   public float ammount;
/*    */   
/*    */   public LivingHurtEvent(EntityLivingBase entity, DamageSource source, float ammount) {
/* 32 */     super(entity);
/* 33 */     this.source = source;
/* 34 */     this.ammount = ammount;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingHurtEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */