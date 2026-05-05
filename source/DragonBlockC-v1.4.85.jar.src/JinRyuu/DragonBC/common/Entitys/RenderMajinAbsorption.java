/*     */ package JinRyuu.DragonBC.common.Entitys;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCClient;
/*     */ import JinRyuu.DragonBC.common.Npcs.ModelEnergy;
/*     */ import JinRyuu.DragonBC.common.Npcs.RenderDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderMajinAbsorption
/*     */   extends RenderDBC {
/*     */   private ModelEnergy ener;
/*     */   
/*     */   public RenderMajinAbsorption() {
/*  21 */     super((ModelBase)new ModelEnergy(), 0.0F);
/*  22 */     this.ener = new ModelEnergy();
/*     */   }
/*     */   
/*     */   public void renderEnergy(EntityMajinAbsorption par1Entity, double par2, double par4, double par6, float par8, float par9) {
/*  26 */     this.field_76989_e = 0.0F;
/*  27 */     if (par1Entity != null && par1Entity.shootingEntity != null) {
/*     */       
/*  29 */       int col = par1Entity.getBodyColor();
/*  30 */       boolean b = false;
/*  31 */       if (par1Entity.shootingEntity != null) {
/*  32 */         b = (par1Entity.shootingEntity.func_145782_y() == JRMCoreClient.mc.field_71439_g.func_145782_y());
/*     */       }
/*     */       
/*  35 */       float var13 = handleRotationFloat(par1Entity, par9);
/*     */       
/*  37 */       double x = par1Entity.field_70165_t;
/*  38 */       double y = par1Entity.field_70163_u;
/*  39 */       double z = par1Entity.field_70161_v;
/*     */       
/*  41 */       boolean hasTarget = (par1Entity.getMode() == 1);
/*  42 */       boolean isComingBack = (par1Entity.getMode() == 2);
/*     */       
/*  44 */       float BASE_SCALE = 1.0F;
/*     */       
/*  46 */       float size = (par1Entity.targetH > par1Entity.targetW) ? par1Entity.targetH : par1Entity.targetW;
/*  47 */       float sin = (float)(Math.sin(var13) / 2.0D);
/*  48 */       float scaleH = hasTarget ? (size * 0.65F + 0.5F + sin / 2.0F) : (1.0F + sin);
/*  49 */       float scaleW = hasTarget ? (size * 0.65F + 0.5F - sin / 2.0F) : (1.0F - sin);
/*     */       
/*  51 */       if (!DBCClient.mc.func_147113_T()) {
/*  52 */         par1Entity.visualH += (scaleH / 20.0F * (isComingBack ? -3.0F : 0.3F)); if (isComingBack ? (par1Entity.visualH < scaleH) : (par1Entity.visualH > scaleH)) par1Entity.visualH = scaleH; 
/*  53 */         par1Entity.visualW += (scaleW / 20.0F * (isComingBack ? -3.0F : 0.3F)); if (isComingBack ? (par1Entity.visualW < scaleW) : (par1Entity.visualW > scaleW)) par1Entity.visualW = scaleW;
/*     */       
/*     */       } 
/*     */       
/*  57 */       GL11.glPushMatrix();
/*  58 */       GL11.glDisable(2896);
/*  59 */       OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  68 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  69 */       GL11.glRotatef(par1Entity.field_70126_B + (par1Entity.field_70177_z - par1Entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  70 */       GL11.glRotatef(par1Entity.field_70127_C + (par1Entity.field_70125_A - par1Entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  71 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*  72 */       tex(col);
/*     */ 
/*     */       
/*  75 */       GL11.glScaled(par1Entity.visualW, par1Entity.visualH, par1Entity.visualW);
/*  76 */       this.ener.renderModel((byte)1, par1Entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  81 */       GL11.glDepthMask(true);
/*     */ 
/*     */       
/*  84 */       GL11.glEnable(2896);
/*     */       
/*  86 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  87 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76979_b(Entity p_76979_1_, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {}
/*     */ 
/*     */   
/*     */   public void tex(int col) {
/*  96 */     float h2 = (col >> 16 & 0xFF) / 255.0F;
/*  97 */     float h3 = (col >> 8 & 0xFF) / 255.0F;
/*  98 */     float h4 = (col & 0xFF) / 255.0F;
/*  99 */     GL11.glColor4f(h2, h3, h4, 1.0F);
/* 100 */     ResourceLocation txx = new ResourceLocation("jinryuudragonbc:majin_absorption.png");
/* 101 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 106 */     return (par1Entity.field_70173_aa + par2) / 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 111 */     renderEnergy((EntityMajinAbsorption)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Entitys\RenderMajinAbsorption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */