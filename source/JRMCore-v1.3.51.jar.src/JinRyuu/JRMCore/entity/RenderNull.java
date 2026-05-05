/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class RenderNull
/*    */   extends RenderJRMC {
/* 11 */   private static final ResourceLocation texture = new ResourceLocation(JRMCoreH.tjjrmc + ":npcs/TrainingShadowDummyUniform.png");
/*    */   
/*    */   public RenderNull(ModelBase model, float f) {
/* 14 */     super(model, f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(EntityNull entity, double d, double d1, double d2, float d3, float f) {
/* 19 */     float f5 = 0.0625F;
/* 20 */     func_110776_a(func_110775_a((Entity)entity));
/* 21 */     GL11.glPushMatrix();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 27 */     GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/* 28 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*    */     
/* 30 */     GL11.glRotatef(-30.0F, 0.0F, 1.0F, 0.0F);
/* 31 */     this.field_77045_g.func_78088_a((Entity)entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f5);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 36 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 40 */     return texture;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double d0, double d1, double d2, float f, float f1) {
/* 44 */     doRender((EntityNull)entity, d0, d1, d2, f, f1);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderNull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */