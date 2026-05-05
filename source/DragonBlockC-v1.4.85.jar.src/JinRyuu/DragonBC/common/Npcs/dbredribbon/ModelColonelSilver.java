/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelColonelSilver
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer shape28;
/*     */   public ModelRenderer Ribbon;
/*     */   
/*     */   public ModelColonelSilver() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.Hair5 = new ModelRenderer(this, 17, 56);
/*  30 */     this.Hair5.func_78793_a(4.1F, -6.8F, -1.2F);
/*  31 */     this.Hair5.func_78790_a(-1.4F, -2.8F, -1.9F, 2, 3, 4, 0.0F);
/*  32 */     setRotateAngle(this.Hair5, -0.045553092F, 0.091106184F, -0.3642502F);
/*  33 */     this.Hair = new ModelRenderer(this, 0, 0);
/*  34 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.Hair.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
/*  36 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  37 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  38 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  39 */     this.Body = new ModelRenderer(this, 16, 16);
/*  40 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  42 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  43 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  44 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  45 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  46 */     this.ArmL.field_78809_i = true;
/*  47 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  48 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  49 */     this.Hair2 = new ModelRenderer(this, 52, 55);
/*  50 */     this.Hair2.func_78793_a(-3.0F, -5.8F, -0.6F);
/*  51 */     this.Hair2.func_78790_a(-1.4F, -3.8F, -3.3F, 2, 4, 4, 0.0F);
/*  52 */     setRotateAngle(this.Hair2, 0.024085544F, 0.045553092F, 0.51749015F);
/*  53 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  54 */     this.LegL.field_78809_i = true;
/*  55 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  56 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  57 */     this.Hair4 = new ModelRenderer(this, 30, 56);
/*  58 */     this.Hair4.func_78793_a(3.9F, -5.3F, 2.4F);
/*  59 */     this.Hair4.func_78790_a(-1.4F, -3.4F, -1.5F, 2, 5, 2, 0.0F);
/*  60 */     setRotateAngle(this.Hair4, -0.13665928F, -0.13665928F, -0.31869712F);
/*  61 */     this.Head = new ModelRenderer(this, 0, 0);
/*  62 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  64 */     this.Ribbon = new ModelRenderer(this, 25, 1);
/*  65 */     this.Ribbon.func_78793_a(0.0F, 1.5F, -2.0F);
/*  66 */     this.Ribbon.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 5, 0, 0.0F);
/*  67 */     setRotateAngle(this.Ribbon, -0.18203785F, 0.0F, 0.0F);
/*  68 */     this.Head2 = new ModelRenderer(this, 0, 32);
/*  69 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.Head2.func_78790_a(-4.5F, -8.9F, -4.5F, 9, 9, 9, 0.0F);
/*  71 */     this.shape28 = new ModelRenderer(this, 49, 50);
/*  72 */     this.shape28.func_78793_a(0.0F, -7.3F, -4.0F);
/*  73 */     this.shape28.func_78790_a(-3.6F, 0.0F, 0.0F, 7, 4, 0, 0.0F);
/*  74 */     setRotateAngle(this.shape28, -0.13543755F, 0.0F, 0.0F);
/*  75 */     this.Hair3 = new ModelRenderer(this, 39, 55);
/*  76 */     this.Hair3.func_78793_a(-3.3F, -6.7F, 0.9F);
/*  77 */     this.Hair3.func_78790_a(-1.4F, -4.3F, -1.5F, 3, 5, 3, 0.0F);
/*  78 */     setRotateAngle(this.Hair3, 0.045553092F, 0.091106184F, 0.59184116F);
/*  79 */     this.Hair.func_78792_a(this.Hair5);
/*  80 */     this.Head.func_78792_a(this.Hair);
/*  81 */     this.Hair.func_78792_a(this.Hair2);
/*  82 */     this.Hair.func_78792_a(this.Hair4);
/*  83 */     this.Body.func_78792_a(this.Ribbon);
/*  84 */     this.Head.func_78792_a(this.Head2);
/*  85 */     this.Hair.func_78792_a(this.shape28);
/*  86 */     this.Hair.func_78792_a(this.Hair3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  91 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  93 */     this.Head.func_78785_a(f5);
/*     */     
/*  95 */     this.Body.func_78785_a(f5);
/*  96 */     this.ArmR.func_78785_a(f5);
/*  97 */     this.ArmL.func_78785_a(f5);
/*  98 */     this.LegL.func_78785_a(f5);
/*  99 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 108 */     modelRenderer.field_78795_f = x;
/* 109 */     modelRenderer.field_78796_g = y;
/* 110 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 114 */     int calc = par7Entity.field_70173_aa;
/* 115 */     if (calc > 100) calc -= 100; 
/* 116 */     float r = 360.0F;
/* 117 */     float r2 = 180.0F;
/* 118 */     float n4 = par4;
/* 119 */     float n5 = par5;
/*     */     
/* 121 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 122 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 123 */     float ex = par7Entity.field_70173_aa;
/* 124 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 125 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 127 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 128 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 177 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 178 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 179 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 180 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 182 */     this.LegR.field_78796_g = 0.0F;
/* 183 */     this.LegL.field_78796_g = 0.0F;
/* 184 */     this.ArmR.field_78796_g = 0.0F;
/* 185 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelColonelSilver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */