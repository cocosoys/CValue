/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class RenderSafeZone
/*     */   extends RenderJRMC {
/*     */   public RenderSafeZone() {
/*  12 */     super((ModelBase)new ModelNPCNormalScaled(), 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAura(EntitySafeZone entity, double parX, double parY, double parZ, float par8, float par9) {
/*  93 */     if (JRMCoreClient.mc.field_71442_b.func_78758_h()) {
/*     */       
/*  95 */       float f5 = 0.0625F;
/*  96 */       this.field_76989_e = 0.0F;
/*  97 */       GL11.glPushMatrix();
/*  98 */       GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*  99 */       GL11.glTranslatef((float)-parX, (float)-parY - entity.field_70131_O, (float)parZ);
/* 100 */       GL11.glRotatef((entity.field_70173_aa * 2), 0.0F, 1.0F, 0.0F);
/* 101 */       GL11.glPushMatrix();
/*     */ 
/*     */ 
/*     */       
/* 105 */       GL11.glEnable(3042);
/* 106 */       GL11.glDisable(2896);
/* 107 */       GL11.glBlendFunc(770, 771);
/* 108 */       GL11.glAlphaFunc(516, 0.003921569F);
/* 109 */       GL11.glDepthMask(false);
/*     */       
/* 111 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
/*     */ 
/*     */       
/* 114 */       ResourceLocation tx = new ResourceLocation(entity.getTexture());
/* 115 */       this.field_76990_c.field_78724_e.func_110577_a(tx);
/* 116 */       this.field_77045_g.func_78088_a((Entity)entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f5);
/*     */       
/* 118 */       GL11.glDisable(3042);
/* 119 */       GL11.glEnable(2896);
/* 120 */       GL11.glDepthMask(true);
/*     */       
/* 122 */       GL11.glPopMatrix();
/* 123 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   public void func_76986_a(Entity entity, double par2, double par4, double par6, float par8, float par9) {
/* 127 */     renderAura((EntitySafeZone)entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderSafeZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */