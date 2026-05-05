/*    */ package net.minecraftforge.event.entity;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.effect.EntityLightningBolt;
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
/*    */ public class EntityStruckByLightningEvent
/*    */   extends EntityEvent
/*    */ {
/*    */   public final EntityLightningBolt lightning;
/*    */   
/*    */   public EntityStruckByLightningEvent(Entity entity, EntityLightningBolt lightning) {
/* 28 */     super(entity);
/* 29 */     this.lightning = lightning;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\EntityStruckByLightningEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */