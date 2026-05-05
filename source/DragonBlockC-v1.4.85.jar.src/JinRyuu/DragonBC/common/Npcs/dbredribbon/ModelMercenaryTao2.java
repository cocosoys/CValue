/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMercenaryTao2
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer EyeR;
/*     */   public ModelRenderer EyeL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Cloth2;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer Blade;
/*     */   
/*     */   public ModelMercenaryTao2() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.ArmR = new ModelRenderer(this, 26, 36);
/*  30 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  31 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F);
/*  32 */     this.EyeL = new ModelRenderer(this, 0, 0);
/*  33 */     this.EyeL.func_78793_a(2.0F, -4.3F, -4.3F);
/*  34 */     this.EyeL.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  35 */     this.Head = new ModelRenderer(this, 0, 0);
/*  36 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  38 */     this.EyeR = new ModelRenderer(this, 0, 0);
/*  39 */     this.EyeR.func_78793_a(-2.0F, -4.3F, -4.3F);
/*  40 */     this.EyeR.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  41 */     this.Cloth2 = new ModelRenderer(this, 23, 52);
/*  42 */     this.Cloth2.func_78793_a(0.0F, 10.1F, 1.2F);
/*  43 */     this.Cloth2.func_78790_a(-4.5F, 0.0F, -1.0F, 9, 9, 2, 0.0F);
/*  44 */     setRotateAngle(this.Cloth2, 0.045378562F, 0.0F, 0.0F);
/*  45 */     this.Hair = new ModelRenderer(this, 35, 3);
/*  46 */     this.Hair.func_78793_a(0.0F, -1.2F, 4.0F);
/*  47 */     this.Hair.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 10, 0, 0.0F);
/*  48 */     setRotateAngle(this.Hair, 0.045553092F, 0.0F, 0.0F);
/*  49 */     this.EarR = new ModelRenderer(this, 0, 3);
/*  50 */     this.EarR.func_78793_a(-4.4F, -3.7F, 0.0F);
/*  51 */     this.EarR.func_78790_a(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
/*  52 */     this.Body = new ModelRenderer(this, 0, 17);
/*  53 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  55 */     this.ArmL = new ModelRenderer(this, 26, 19);
/*  56 */     this.ArmL.field_78809_i = true;
/*  57 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  58 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  59 */     this.LegL = new ModelRenderer(this, 0, 35);
/*  60 */     this.LegL.field_78809_i = true;
/*  61 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  62 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  63 */     this.EarL = new ModelRenderer(this, 0, 3);
/*  64 */     this.EarL.field_78809_i = true;
/*  65 */     this.EarL.func_78793_a(4.4F, -3.7F, 0.0F);
/*  66 */     this.EarL.func_78790_a(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
/*  67 */     this.Cloth1 = new ModelRenderer(this, 0, 52);
/*  68 */     this.Cloth1.func_78793_a(0.0F, 10.0F, -1.2F);
/*  69 */     this.Cloth1.func_78790_a(-4.5F, 0.0F, -1.0F, 9, 9, 2, 0.0F);
/*  70 */     setRotateAngle(this.Cloth1, -0.045378562F, 0.0F, 0.0F);
/*  71 */     this.ArmR2 = new ModelRenderer(this, 43, 19);
/*  72 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.ArmR2.func_78790_a(-3.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F);
/*  74 */     this.Blade = new ModelRenderer(this, 44, 22);
/*  75 */     this.Blade.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.Blade.func_78790_a(-1.0F, 8.0F, -2.0F, 0, 5, 4, 0.0F);
/*  77 */     this.LegR = new ModelRenderer(this, 0, 35);
/*  78 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  79 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  80 */     this.Head.func_78792_a(this.EyeL);
/*  81 */     this.Head.func_78792_a(this.EyeR);
/*  82 */     this.Body.func_78792_a(this.Cloth2);
/*  83 */     this.Head.func_78792_a(this.Hair);
/*  84 */     this.Head.func_78792_a(this.EarR);
/*  85 */     this.Head.func_78792_a(this.EarL);
/*  86 */     this.Body.func_78792_a(this.Cloth1);
/*  87 */     this.ArmR.func_78792_a(this.ArmR2);
/*  88 */     this.ArmR.func_78792_a(this.Blade);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  93 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  95 */     this.Head.func_78785_a(f5);
/*     */     
/*  97 */     this.Body.func_78785_a(f5);
/*  98 */     this.ArmR.func_78785_a(f5);
/*  99 */     this.ArmL.func_78785_a(f5);
/* 100 */     this.LegL.func_78785_a(f5);
/* 101 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 111 */     modelRenderer.field_78795_f = x;
/* 112 */     modelRenderer.field_78796_g = y;
/* 113 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 117 */     int calc = par7Entity.field_70173_aa;
/* 118 */     if (calc > 100) calc -= 100; 
/* 119 */     float r = 360.0F;
/* 120 */     float r2 = 180.0F;
/* 121 */     float n4 = par4;
/* 122 */     float n5 = par5;
/*     */     
/* 124 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 125 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 126 */     float ex = par7Entity.field_70173_aa;
/* 127 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 128 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 130 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 131 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 163 */     this.Hair.field_78795_f = 0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.5F * par2;
/* 164 */     if (0.0F > this.Hair.field_78795_f) this.Hair.field_78795_f *= -1.0F; 
/* 165 */     this.Hair.field_78796_g = 0.0F;
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
/* 185 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 186 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 187 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 188 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 190 */     this.LegR.field_78796_g = 0.0F;
/* 191 */     this.LegL.field_78796_g = 0.0F;
/* 192 */     this.ArmR.field_78796_g = 0.0F;
/* 193 */     this.ArmL.field_78796_g = 0.0F;
/*     */     
/* 195 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 197 */     this.Cloth2.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? true : -1) * 1.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelMercenaryTao2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */