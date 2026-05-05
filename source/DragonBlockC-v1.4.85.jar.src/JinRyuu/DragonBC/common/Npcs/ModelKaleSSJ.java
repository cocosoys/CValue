/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelKaleSSJ
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer HairR2;
/*     */   public ModelRenderer HairR1;
/*     */   public ModelRenderer HairFrontL1;
/*     */   public ModelRenderer HairL1;
/*     */   public ModelRenderer HairR3;
/*     */   public ModelRenderer HairL2;
/*     */   public ModelRenderer HairL3;
/*     */   public ModelRenderer HairFrontR1;
/*     */   public ModelRenderer HairFrontL2;
/*     */   public ModelRenderer HairFrontR2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelKaleSSJ() {
/*  35 */     this.field_78090_t = 64;
/*  36 */     this.field_78089_u = 64;
/*  37 */     this.Hair = new ModelRenderer(this, 26, 0);
/*  38 */     this.Hair.func_78793_a(0.0F, -4.6F, -1.1F);
/*  39 */     this.Hair.func_78790_a(-1.5F, -7.0F, -2.6F, 3, 6, 2, 0.0F);
/*  40 */     setRotateAngle(this.Hair, -0.53215086F, 0.045553092F, 0.0F);
/*  41 */     this.HairL1 = new ModelRenderer(this, 37, 0);
/*  42 */     this.HairL1.func_78793_a(1.4F, -0.3F, 0.2F);
/*  43 */     this.HairL1.func_78790_a(-1.9F, -6.5F, -2.0F, 4, 7, 4, 0.0F);
/*  44 */     setRotateAngle(this.HairL1, -0.40142572F, 0.045553092F, 0.2268928F);
/*  45 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  46 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  47 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  48 */     this.HairR1 = new ModelRenderer(this, 37, 0);
/*  49 */     this.HairR1.func_78793_a(-1.1F, -0.2F, -0.4F);
/*  50 */     this.HairR1.func_78790_a(-2.6F, -6.5F, -2.0F, 4, 7, 4, 0.0F);
/*  51 */     setRotateAngle(this.HairR1, -0.40142572F, -0.13665928F, -0.2268928F);
/*  52 */     this.HairFrontL1 = new ModelRenderer(this, 54, 1);
/*  53 */     this.HairFrontL1.func_78793_a(1.3F, -0.4F, -2.7F);
/*  54 */     this.HairFrontL1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
/*  55 */     setRotateAngle(this.HairFrontL1, 0.27314404F, -0.3000221F, -0.22759093F);
/*  56 */     this.HairR2 = new ModelRenderer(this, 31, 12);
/*  57 */     this.HairR2.func_78793_a(-2.7F, -0.1F, -0.1F);
/*  58 */     this.HairR2.func_78790_a(-1.0F, -1.9F, -0.5F, 4, 4, 5, 0.0F);
/*  59 */     setRotateAngle(this.HairR2, 0.6981317F, -0.6981317F, -0.2268928F);
/*  60 */     this.HairL2 = new ModelRenderer(this, 31, 12);
/*  61 */     this.HairL2.func_78793_a(2.9F, -0.1F, -0.1F);
/*  62 */     this.HairL2.func_78790_a(-3.3F, -1.9F, -0.5F, 4, 4, 5, 0.0F);
/*  63 */     setRotateAngle(this.HairL2, 0.6981317F, 0.6981317F, 0.2268928F);
/*  64 */     this.ArmL = new ModelRenderer(this, 32, 29);
/*  65 */     this.ArmL.field_78809_i = true;
/*  66 */     this.ArmL.func_78793_a(5.0F, 2.5F, 0.0F);
/*  67 */     this.ArmL.func_78790_a(-1.5F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
/*  68 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  69 */     this.Body2 = new ModelRenderer(this, 0, 27);
/*  70 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.Body2.func_78790_a(-3.0F, 4.3F, -1.5F, 6, 4, 3, 0.0F);
/*  72 */     this.HairL3 = new ModelRenderer(this, 50, 12);
/*  73 */     this.HairL3.func_78793_a(2.7F, 1.7F, 2.7F);
/*  74 */     this.HairL3.func_78790_a(-2.0F, -1.0F, -1.0F, 3, 2, 4, 0.0F);
/*  75 */     setRotateAngle(this.HairL3, 0.715585F, 0.5009095F, 0.4098033F);
/*  76 */     this.HairFrontR2 = new ModelRenderer(this, 54, 5);
/*  77 */     this.HairFrontR2.func_78793_a(0.4F, 0.0F, -0.8F);
/*  78 */     this.HairFrontR2.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 4, 1, 0.0F);
/*  79 */     setRotateAngle(this.HairFrontR2, -0.07679449F, -0.13665928F, 1.4114478F);
/*  80 */     this.Head = new ModelRenderer(this, 0, 0);
/*  81 */     this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
/*  82 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  83 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  84 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/*  85 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.9F, 8, 5, 4, -0.2F);
/*  86 */     this.ArmR = new ModelRenderer(this, 32, 29);
/*  87 */     this.ArmR.func_78793_a(-5.0F, 2.5F, 0.0F);
/*  88 */     this.ArmR.func_78790_a(-2.5F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
/*  89 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  90 */     this.Boobs = new ModelRenderer(this, 19, 27);
/*  91 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.Boobs.func_78790_a(-3.0F, 1.5F, -0.6F, 6, 3, 2, 0.0F);
/*  93 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  94 */     this.HairR3 = new ModelRenderer(this, 50, 12);
/*  95 */     this.HairR3.func_78793_a(-3.2F, 1.7F, 2.7F);
/*  96 */     this.HairR3.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 2, 4, 0.0F);
/*  97 */     setRotateAngle(this.HairR3, 0.715585F, -0.5009095F, -0.4098033F);
/*  98 */     this.HairFrontR1 = new ModelRenderer(this, 54, 1);
/*  99 */     this.HairFrontR1.func_78793_a(-0.9F, 0.1F, -2.8F);
/* 100 */     this.HairFrontR1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
/* 101 */     setRotateAngle(this.HairFrontR1, 0.045553092F, 0.091106184F, -0.05863736F);
/* 102 */     this.HairFrontL2 = new ModelRenderer(this, 54, 5);
/* 103 */     this.HairFrontL2.func_78793_a(0.1F, 0.1F, -0.8F);
/* 104 */     this.HairFrontL2.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 4, 1, 0.0F);
/* 105 */     setRotateAngle(this.HairFrontL2, 0.0F, 0.0F, -0.31869712F);
/* 106 */     this.Body3 = new ModelRenderer(this, 0, 35);
/* 107 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.Body3.func_78790_a(-3.5F, 7.9F, -2.0F, 7, 3, 4, 0.0F);
/* 109 */     this.LegL = new ModelRenderer(this, 0, 46);
/* 110 */     this.LegL.field_78809_i = true;
/* 111 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/* 112 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 113 */     this.Head.func_78792_a(this.Hair);
/* 114 */     this.Hair.func_78792_a(this.HairL1);
/* 115 */     this.Hair.func_78792_a(this.HairR1);
/* 116 */     this.Hair.func_78792_a(this.HairFrontL1);
/* 117 */     this.Hair.func_78792_a(this.HairR2);
/* 118 */     this.Hair.func_78792_a(this.HairL2);
/* 119 */     this.Body1.func_78792_a(this.Body2);
/* 120 */     this.Hair.func_78792_a(this.HairL3);
/* 121 */     this.HairFrontR1.func_78792_a(this.HairFrontR2);
/* 122 */     this.Body1.func_78792_a(this.Boobs);
/* 123 */     this.Hair.func_78792_a(this.HairR3);
/* 124 */     this.Hair.func_78792_a(this.HairFrontR1);
/* 125 */     this.HairFrontL1.func_78792_a(this.HairFrontL2);
/* 126 */     this.Body2.func_78792_a(this.Body3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 131 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 133 */     GL11.glPushMatrix();
/* 134 */     float F = 1.3F;
/* 135 */     JGRenderHelper.modelScalePositionHelper(1.3F);
/*     */     
/* 137 */     this.LegL.func_78785_a(f5);
/* 138 */     this.Head.func_78785_a(f5);
/* 139 */     this.ArmL.func_78785_a(f5);
/* 140 */     this.ArmR.func_78785_a(f5);
/* 141 */     this.Body1.func_78785_a(f5);
/* 142 */     this.LegR.func_78785_a(f5);
/* 143 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 149 */     modelRenderer.field_78795_f = x;
/* 150 */     modelRenderer.field_78796_g = y;
/* 151 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 155 */     int calc = par7Entity.field_70173_aa;
/* 156 */     if (calc > 100) calc -= 100; 
/* 157 */     float r = 360.0F;
/* 158 */     float r2 = 180.0F;
/* 159 */     float n4 = par4;
/* 160 */     float n5 = par5;
/*     */     
/* 162 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 163 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 164 */     float ex = par7Entity.field_70173_aa;
/* 165 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 166 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 168 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 169 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 215 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 216 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 217 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 218 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 220 */     this.LegR.field_78796_g = 0.0F;
/* 221 */     this.LegL.field_78796_g = 0.0F;
/* 222 */     this.ArmR.field_78796_g = 0.0F;
/* 223 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKaleSSJ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */