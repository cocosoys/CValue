/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class RenderAuraFlat
/*    */   extends RenderJRMC
/*    */ {
/*    */   public RenderAuraFlat(ModelBase model, float f) {
/* 13 */     super(model, f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(EntityAuraFlat entity, double d, double d1, double d2, float d3, float f) {
/* 18 */     float f5 = 0.0625F;
/* 19 */     func_110776_a(func_110775_a((Entity)entity));
/* 20 */     GL11.glPushMatrix();
/*    */ 
/*    */     
/* 23 */     GL11.glEnable(3042);
/* 24 */     GL11.glBlendFunc(770, 771);
/*    */     
/* 26 */     GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/* 27 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 28 */     entity.update();
/* 29 */     float scale = 0.5F;
/* 30 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/*    */ 
/*    */     
/* 33 */     GL11.glRotatef(-30.0F, 0.0F, 1.0F, 0.0F);
/* 34 */     GL11.glRotatef(-5.0F, 1.0F, 0.0F, 0.0F);
/* 35 */     GL11.glColor4f(entity.aura.getRed() / 255.0F, entity.aura
/* 36 */         .getGreen() / 255.0F, entity.aura
/* 37 */         .getBlue() / 255.0F, entity.transparency.lastValue);
/*    */     
/* 39 */     GL11.glTranslatef((float)entity.field_70165_t, (float)entity.field_70163_u, (float)entity.field_70161_v);
/*    */ 
/*    */     
/* 42 */     GL11.glRotatef(((int)entity.field_70165_t * 30), 0.0F, 0.0F, 1.0F);
/* 43 */     GL11.glRotatef(((int)entity.field_70161_v * 30), 1.0F, 0.0F, 0.0F);
/*    */ 
/*    */     
/* 46 */     this.field_77045_g.func_78088_a((Entity)entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f5);
/*    */ 
/*    */ 
/*    */     
/* 50 */     GL11.glDisable(3042);
/* 51 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 55 */     return ((EntityAuraFlat)entity).getTexture();
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double d0, double d1, double d2, float f, float f1) {
/* 59 */     doRender((EntityAuraFlat)entity, d0, d1, d2, f, f1);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderAuraFlat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */