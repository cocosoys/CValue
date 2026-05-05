/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKale
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer HairBand;
/*     */   public ModelRenderer HairFront1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer HairFront2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelKale() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.ArmL = new ModelRenderer(this, 32, 29);
/*  30 */     this.ArmL.field_78809_i = true;
/*  31 */     this.ArmL.func_78793_a(4.3F, 2.5F, 0.0F);
/*  32 */     this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 12, 4, -0.3F);
/*  33 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  34 */     this.Boobs = new ModelRenderer(this, 19, 27);
/*  35 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.Boobs.func_78790_a(-3.0F, 1.8F, -0.7F, 6, 3, 2, 0.0F);
/*  37 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  38 */     this.Body3 = new ModelRenderer(this, 0, 35);
/*  39 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Body3.func_78790_a(-3.5F, 7.9F, -2.0F, 7, 3, 4, 0.0F);
/*  41 */     this.HairFront1 = new ModelRenderer(this, 54, 1);
/*  42 */     this.HairFront1.func_78793_a(1.3F, 0.4F, -3.0F);
/*  43 */     this.HairFront1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
/*  44 */     setRotateAngle(this.HairFront1, 0.27314404F, -0.3000221F, -0.22759093F);
/*  45 */     this.Hair2 = new ModelRenderer(this, 37, 0);
/*  46 */     this.Hair2.func_78793_a(-0.4F, -4.2F, 1.6F);
/*  47 */     this.Hair2.func_78790_a(-1.2F, -5.4F, -2.0F, 2, 5, 3, 0.0F);
/*  48 */     setRotateAngle(this.Hair2, -0.3642502F, -0.13665928F, -0.091106184F);
/*  49 */     this.HairFront2 = new ModelRenderer(this, 54, 5);
/*  50 */     this.HairFront2.func_78793_a(0.1F, 0.1F, -0.8F);
/*  51 */     this.HairFront2.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 4, 1, 0.0F);
/*  52 */     setRotateAngle(this.HairFront2, 0.0F, 0.0F, -0.31869712F);
/*  53 */     this.Body2 = new ModelRenderer(this, 0, 27);
/*  54 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.Body2.func_78790_a(-3.0F, 4.3F, -1.6F, 6, 4, 3, 0.0F);
/*  56 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  57 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/*  58 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, -0.2F);
/*  59 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  60 */     this.LegL.field_78809_i = true;
/*  61 */     this.LegL.func_78793_a(1.6F, 12.0F, 0.0F);
/*  62 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  63 */     this.Hair4 = new ModelRenderer(this, 48, 11);
/*  64 */     this.Hair4.func_78793_a(-0.7F, -2.0F, 0.0F);
/*  65 */     this.Hair4.func_78790_a(-1.2F, -4.1F, -0.9F, 2, 4, 2, 0.0F);
/*  66 */     setRotateAngle(this.Hair4, -0.8651597F, 0.0F, 0.0F);
/*  67 */     this.Head = new ModelRenderer(this, 0, 0);
/*  68 */     this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
/*  69 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  70 */     this.ArmR = new ModelRenderer(this, 32, 29);
/*  71 */     this.ArmR.func_78793_a(-4.3F, 2.5F, 0.0F);
/*  72 */     this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 12, 4, -0.3F);
/*  73 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  74 */     this.Hair3 = new ModelRenderer(this, 37, 9);
/*  75 */     this.Hair3.func_78793_a(1.2F, 0.6F, -0.2F);
/*  76 */     this.Hair3.func_78790_a(-1.2F, -5.4F, -2.0F, 2, 5, 3, 0.0F);
/*  77 */     setRotateAngle(this.Hair3, -0.3642502F, 0.13665928F, 0.18203785F);
/*  78 */     this.HairBand = new ModelRenderer(this, 26, 0);
/*  79 */     this.HairBand.func_78793_a(0.0F, -4.6F, -1.1F);
/*  80 */     this.HairBand.func_78790_a(-1.5F, -5.0F, 1.0F, 3, 2, 2, 0.0F);
/*  81 */     setRotateAngle(this.HairBand, -0.7285004F, 0.045553092F, 0.0F);
/*  82 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  83 */     this.LegR.func_78793_a(-1.6F, 12.0F, 0.0F);
/*  84 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  85 */     this.Body1.func_78792_a(this.Boobs);
/*  86 */     this.Body2.func_78792_a(this.Body3);
/*  87 */     this.HairBand.func_78792_a(this.HairFront1);
/*  88 */     this.HairBand.func_78792_a(this.Hair2);
/*  89 */     this.HairFront1.func_78792_a(this.HairFront2);
/*  90 */     this.Body1.func_78792_a(this.Body2);
/*  91 */     this.Hair3.func_78792_a(this.Hair4);
/*  92 */     this.Hair2.func_78792_a(this.Hair3);
/*  93 */     this.Head.func_78792_a(this.HairBand);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  98 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 101 */     this.LegL.func_78785_a(f5);
/* 102 */     this.Head.func_78785_a(f5);
/* 103 */     this.ArmL.func_78785_a(f5);
/* 104 */     this.ArmR.func_78785_a(f5);
/* 105 */     this.Body1.func_78785_a(f5);
/* 106 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 112 */     modelRenderer.field_78795_f = x;
/* 113 */     modelRenderer.field_78796_g = y;
/* 114 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 118 */     int calc = par7Entity.field_70173_aa;
/* 119 */     if (calc > 100) calc -= 100; 
/* 120 */     float r = 360.0F;
/* 121 */     float r2 = 180.0F;
/* 122 */     float n4 = par4;
/* 123 */     float n5 = par5;
/*     */     
/* 125 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 126 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 127 */     float ex = par7Entity.field_70173_aa;
/* 128 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 129 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 131 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 132 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 178 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 179 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 180 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 181 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 183 */     this.LegR.field_78796_g = 0.0F;
/* 184 */     this.LegL.field_78796_g = 0.0F;
/* 185 */     this.ArmR.field_78796_g = 0.0F;
/* 186 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */