/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FOVUpdateEvent
/*    */   extends Event
/*    */ {
/*    */   public final EntityPlayerSP entity;
/*    */   public final float fov;
/*    */   public float newfov;
/*    */   
/*    */   public FOVUpdateEvent(EntityPlayerSP entity, float fov) {
/* 18 */     this.entity = entity;
/* 19 */     this.fov = fov;
/* 20 */     this.newfov = fov;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\FOVUpdateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */