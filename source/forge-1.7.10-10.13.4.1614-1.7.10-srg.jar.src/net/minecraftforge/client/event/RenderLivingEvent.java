/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public abstract class RenderLivingEvent
/*    */   extends Event
/*    */ {
/*    */   public final EntityLivingBase entity;
/*    */   public final RendererLivingEntity renderer;
/*    */   public final double x;
/*    */   public final double y;
/*    */   public final double z;
/*    */   
/*    */   public RenderLivingEvent(EntityLivingBase entity, RendererLivingEntity renderer, double x, double y, double z) {
/* 18 */     this.entity = entity;
/* 19 */     this.renderer = renderer;
/* 20 */     this.x = x;
/* 21 */     this.y = y;
/* 22 */     this.z = z;
/*    */   }
/*    */   
/*    */   @Cancelable
/*    */   public static class Pre extends RenderLivingEvent {
/*    */     public Pre(EntityLivingBase entity, RendererLivingEntity renderer, double x, double y, double z) {
/* 28 */       super(entity, renderer, x, y, z);
/*    */     } }
/*    */   
/*    */   public static class Post extends RenderLivingEvent { public Post(EntityLivingBase entity, RendererLivingEntity renderer, double x, double y, double z) {
/* 32 */       super(entity, renderer, x, y, z);
/*    */     } }
/*    */   
/*    */   public static abstract class Specials extends RenderLivingEvent {
/*    */     public Specials(EntityLivingBase entity, RendererLivingEntity renderer, double x, double y, double z) {
/* 37 */       super(entity, renderer, x, y, z);
/*    */     }
/*    */     
/*    */     @Cancelable
/*    */     public static class Pre extends Specials { public Pre(EntityLivingBase entity, RendererLivingEntity renderer, double x, double y, double z) {
/* 42 */         super(entity, renderer, x, y, z);
/*    */       } }
/*    */     
/*    */     public static class Post extends Specials { public Post(EntityLivingBase entity, RendererLivingEntity renderer, double x, double y, double z) {
/* 46 */         super(entity, renderer, x, y, z);
/*    */       } }
/*    */   
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\RenderLivingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */