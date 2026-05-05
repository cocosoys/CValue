/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGodBelmod
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelGodBelmod() {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.Head = new ModelRenderer(this, 0, 0);
/*  29 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  30 */     this.Head.func_78790_a(-4.0F, -7.8F, -4.0F, 8, 8, 8, -0.3F);
/*  31 */     this.LegR2 = new ModelRenderer(this, 3, 29);
/*  32 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  33 */     this.LegR2.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  34 */     this.Nose = new ModelRenderer(this, 25, 1);
/*  35 */     this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.Nose.func_78790_a(-1.0F, -3.8F, -4.9F, 2, 1, 2, 0.0F);
/*  37 */     this.Neck = new ModelRenderer(this, 33, 10);
/*  38 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.Neck.func_78790_a(-2.0F, -0.5F, -0.8F, 4, 2, 2, 0.0F);
/*  40 */     this.LegL2 = new ModelRenderer(this, 3, 47);
/*  41 */     this.LegL2.field_78809_i = true;
/*  42 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.LegL2.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  44 */     this.Cloth1 = new ModelRenderer(this, 47, 35);
/*  45 */     this.Cloth1.func_78793_a(0.0F, 9.9F, -1.8F);
/*  46 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.2F, 5, 10, 0, 0.0F);
/*  47 */     setRotateAngle(this.Cloth1, -0.082030475F, 0.0F, 0.0F);
/*  48 */     this.Body2 = new ModelRenderer(this, 23, 29);
/*  49 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Body2.func_78790_a(-2.9F, 5.0F, -1.7F, 6, 3, 3, 0.0F);
/*  51 */     this.ArmL = new ModelRenderer(this, 50, 16);
/*  52 */     this.ArmL.field_78809_i = true;
/*  53 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  54 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  55 */     this.LegL = new ModelRenderer(this, 37, 53);
/*  56 */     this.LegL.field_78809_i = true;
/*  57 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  58 */     this.LegL.func_78790_a(-1.7F, 3.3F, -2.0F, 4, 6, 4, 0.3F);
/*  59 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  60 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
/*  62 */     this.Body3 = new ModelRenderer(this, 20, 37);
/*  63 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
/*  65 */     this.Hair = new ModelRenderer(this, 32, 0);
/*  66 */     this.Hair.field_78809_i = true;
/*  67 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Hair.func_78790_a(-5.5F, -7.1F, 0.0F, 11, 4, 5, 0.0F);
/*  69 */     this.LegR = new ModelRenderer(this, 21, 53);
/*  70 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  71 */     this.LegR.func_78790_a(-2.4F, 3.3F, -2.0F, 4, 6, 4, 0.3F);
/*  72 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  73 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  74 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  75 */     this.LegR.func_78792_a(this.LegR2);
/*  76 */     this.Head.func_78792_a(this.Nose);
/*  77 */     this.Body1.func_78792_a(this.Neck);
/*  78 */     this.Body1.func_78792_a(this.Cloth1);
/*  79 */     this.LegL.func_78792_a(this.LegL2);
/*  80 */     this.Body1.func_78792_a(this.Body2);
/*  81 */     this.Body2.func_78792_a(this.Body3);
/*  82 */     this.Head.func_78792_a(this.Hair);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  87 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  90 */     this.LegL.func_78785_a(f5);
/*  91 */     this.Head.func_78785_a(f5);
/*  92 */     this.ArmL.func_78785_a(f5);
/*  93 */     this.ArmR.func_78785_a(f5);
/*  94 */     this.Body1.func_78785_a(f5);
/*  95 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 100 */     modelRenderer.field_78795_f = x;
/* 101 */     modelRenderer.field_78796_g = y;
/* 102 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 106 */     int calc = par7Entity.field_70173_aa;
/* 107 */     if (calc > 100) calc -= 100; 
/* 108 */     float r = 360.0F;
/* 109 */     float r2 = 180.0F;
/* 110 */     float n4 = par4;
/* 111 */     float n5 = par5;
/*     */     
/* 113 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 114 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 115 */     float ex = par7Entity.field_70173_aa;
/* 116 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 117 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 119 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 120 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 161 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 162 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 163 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 164 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 166 */     this.LegR.field_78796_g = 0.0F;
/* 167 */     this.LegL.field_78796_g = 0.0F;
/* 168 */     this.ArmR.field_78796_g = 0.0F;
/* 169 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 172 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 176 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodBelmod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */