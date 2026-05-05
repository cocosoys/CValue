/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelAndroid8
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Body2;
/*     */   
/*     */   public ModelAndroid8() {
/*  23 */     this.field_78090_t = 128;
/*  24 */     this.field_78089_u = 64;
/*  25 */     this.LegL = new ModelRenderer(this, 50, 36);
/*  26 */     this.LegL.field_78809_i = true;
/*  27 */     this.LegL.func_78793_a(3.3F, 10.0F, 1.5F);
/*  28 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 14, 6, 0.1F);
/*  29 */     this.Body2 = new ModelRenderer(this, 0, 38);
/*  30 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  31 */     this.Body2.func_78790_a(-6.5F, 8.0F, -2.2F, 13, 7, 7, 0.0F);
/*  32 */     this.Head = new ModelRenderer(this, 0, 0);
/*  33 */     this.Head.func_78793_a(0.0F, -4.5F, 0.6F);
/*  34 */     this.Head.func_78790_a(-4.0F, -8.1F, -4.0F, 8, 8, 8, 0.0F);
/*  35 */     this.LegR = new ModelRenderer(this, 50, 36);
/*  36 */     this.LegR.func_78793_a(-3.3F, 10.0F, 1.5F);
/*  37 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 14, 6, 0.1F);
/*  38 */     this.ArmR1 = new ModelRenderer(this, 52, 12);
/*  39 */     this.ArmR1.func_78793_a(-8.5F, -3.0F, 1.7F);
/*  40 */     this.ArmR1.func_78790_a(-3.5F, -2.0F, -3.0F, 5, 15, 6, 0.0F);
/*  41 */     this.ArmL1 = new ModelRenderer(this, 52, 12);
/*  42 */     this.ArmL1.field_78809_i = true;
/*  43 */     this.ArmL1.func_78793_a(8.5F, -3.0F, 1.7F);
/*  44 */     this.ArmL1.func_78790_a(-1.5F, -2.0F, -3.0F, 5, 15, 6, 0.0F);
/*  45 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  46 */     this.Body1.func_78793_a(0.0F, -5.0F, 0.0F);
/*  47 */     this.Body1.func_78790_a(-7.0F, 0.0F, -2.4F, 14, 8, 8, 0.0F);
/*  48 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  53 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  55 */     GL11.glPushMatrix();
/*  56 */     float F = 1.3F;
/*  57 */     JGRenderHelper.modelScalePositionHelper(1.3F);
/*     */     
/*  59 */     this.Head.func_78785_a(f5);
/*  60 */     this.Body1.func_78785_a(f5);
/*  61 */     this.ArmR1.func_78785_a(f5);
/*  62 */     this.ArmL1.func_78785_a(f5);
/*  63 */     this.LegL.func_78785_a(f5);
/*  64 */     this.LegR.func_78785_a(f5);
/*     */     
/*  66 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  70 */     modelRenderer.field_78795_f = x;
/*  71 */     modelRenderer.field_78796_g = y;
/*  72 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  76 */     int calc = par7Entity.field_70173_aa;
/*  77 */     if (calc > 100) calc -= 100; 
/*  78 */     float r = 360.0F;
/*  79 */     float r2 = 180.0F;
/*  80 */     float n4 = par4;
/*  81 */     float n5 = par5;
/*     */     
/*  83 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  84 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  85 */     float ex = par7Entity.field_70173_aa;
/*  86 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  87 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  89 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  90 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 139 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 140 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 141 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 142 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 144 */     this.LegR.field_78796_g = 0.0F;
/* 145 */     this.LegL.field_78796_g = 0.0F;
/* 146 */     this.ArmR1.field_78796_g = 0.0F;
/* 147 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelAndroid8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */