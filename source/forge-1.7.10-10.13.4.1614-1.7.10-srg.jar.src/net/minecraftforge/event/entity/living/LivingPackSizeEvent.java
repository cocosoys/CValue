/*    */ package net.minecraftforge.event.entity.living;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @HasResult
/*    */ public class LivingPackSizeEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public int maxPackSize;
/*    */   
/*    */   public LivingPackSizeEvent(EntityLiving entity) {
/* 21 */     super((EntityLivingBase)entity);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingPackSizeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */