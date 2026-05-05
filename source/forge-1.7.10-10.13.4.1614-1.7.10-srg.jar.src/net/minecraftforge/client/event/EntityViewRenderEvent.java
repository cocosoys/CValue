/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.EntityRenderer;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class EntityViewRenderEvent
/*    */   extends Event
/*    */ {
/*    */   public final EntityRenderer renderer;
/*    */   public final EntityLivingBase entity;
/*    */   public final Block block;
/*    */   public final double renderPartialTicks;
/*    */   
/*    */   public EntityViewRenderEvent(EntityRenderer renderer, EntityLivingBase entity, Block block, double renderPartialTicks) {
/* 23 */     this.renderer = renderer;
/* 24 */     this.entity = entity;
/* 25 */     this.block = block;
/* 26 */     this.renderPartialTicks = renderPartialTicks;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Cancelable
/*    */   public static class FogDensity
/*    */     extends EntityViewRenderEvent
/*    */   {
/*    */     public float density;
/*    */ 
/*    */ 
/*    */     
/*    */     public FogDensity(EntityRenderer renderer, EntityLivingBase entity, Block block, double renderPartialTicks, float density) {
/* 40 */       super(renderer, entity, block, renderPartialTicks);
/* 41 */       this.density = density;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @HasResult
/*    */   public static class RenderFogEvent
/*    */     extends EntityViewRenderEvent
/*    */   {
/*    */     public final int fogMode;
/*    */     
/*    */     public final float farPlaneDistance;
/*    */ 
/*    */     
/*    */     public RenderFogEvent(EntityRenderer renderer, EntityLivingBase entity, Block block, double renderPartialTicks, int fogMode, float farPlaneDistance) {
/* 56 */       super(renderer, entity, block, renderPartialTicks);
/* 57 */       this.fogMode = fogMode;
/* 58 */       this.farPlaneDistance = farPlaneDistance;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static class FogColors
/*    */     extends EntityViewRenderEvent
/*    */   {
/*    */     public float red;
/*    */     
/*    */     public float green;
/*    */     
/*    */     public float blue;
/*    */ 
/*    */     
/*    */     public FogColors(EntityRenderer renderer, EntityLivingBase entity, Block block, double renderPartialTicks, float red, float green, float blue) {
/* 74 */       super(renderer, entity, block, renderPartialTicks);
/* 75 */       this.red = red;
/* 76 */       this.green = green;
/* 77 */       this.blue = blue;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\EntityViewRenderEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */