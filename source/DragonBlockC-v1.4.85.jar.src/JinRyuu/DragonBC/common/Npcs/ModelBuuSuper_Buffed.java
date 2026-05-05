/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBuuSuper_Buffed
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer Hips;
/*     */   public ModelRenderer Torso;
/*     */   public ModelRenderer ChestR;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer FootL;
/*     */   
/*     */   public ModelBuuSuper_Buffed() {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.ArmR2 = new ModelRenderer(this, 23, 49);
/*  31 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.ArmR2.func_78790_a(-3.4F, 2.4F, -2.2F, 4, 10, 5, 0.0F);
/*  33 */     this.LegL = new ModelRenderer(this, 0, 29);
/*  34 */     this.LegL.field_78809_i = true;
/*  35 */     this.LegL.func_78793_a(1.9F, 8.6F, 0.5F);
/*  36 */     this.LegL.func_78790_a(-1.9F, 2.7F, -3.0F, 5, 7, 6, 0.1F);
/*  37 */     this.Torso = new ModelRenderer(this, 28, 10);
/*  38 */     this.Torso.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.Torso.func_78790_a(-5.5F, 0.3F, -2.5F, 11, 6, 7, 0.0F);
/*  40 */     this.Head = new ModelRenderer(this, 0, 0);
/*  41 */     this.Head.func_78793_a(0.0F, -2.8F, 0.8F);
/*  42 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.6F);
/*  43 */     this.ArmR = new ModelRenderer(this, 42, 52);
/*  44 */     this.ArmR.func_78793_a(-6.1F, -1.4F, 0.9F);
/*  45 */     this.ArmR.func_78790_a(-3.8F, -2.3F, -2.7F, 5, 5, 6, -0.1F);
/*  46 */     this.Head4 = new ModelRenderer(this, 36, 0);
/*  47 */     this.Head4.func_78793_a(0.0F, -0.1F, 2.4F);
/*  48 */     this.Head4.func_78790_a(-0.5F, -0.5F, -0.3F, 1, 1, 3, 0.0F);
/*  49 */     setRotateAngle(this.Head4, -0.63739425F, 0.0F, 0.0F);
/*  50 */     this.ArmL = new ModelRenderer(this, 42, 52);
/*  51 */     this.ArmL.field_78809_i = true;
/*  52 */     this.ArmL.func_78793_a(6.2F, -1.4F, 0.9F);
/*  53 */     this.ArmL.func_78790_a(-1.2F, -2.3F, -2.7F, 5, 5, 6, -0.1F);
/*  54 */     this.ChestR = new ModelRenderer(this, 0, 17);
/*  55 */     this.ChestR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.ChestR.func_78790_a(-5.0F, 1.4F, -2.9F, 10, 4, 3, 0.0F);
/*  57 */     setRotateAngle(this.ChestR, -0.06492625F, 0.0F, 0.0F);
/*  58 */     this.Body = new ModelRenderer(this, 27, 24);
/*  59 */     this.Body.func_78793_a(0.0F, -3.3F, 0.0F);
/*  60 */     this.Body.func_78790_a(-4.0F, 2.9F, -2.8F, 8, 7, 6, 0.0F);
/*  61 */     setRotateAngle(this.Body, 0.0F, 0.0F, 0.006981317F);
/*  62 */     this.Hips = new ModelRenderer(this, 23, 38);
/*  63 */     this.Hips.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.Hips.func_78790_a(-4.5F, 9.3F, -2.5F, 9, 3, 6, 0.0F);
/*  65 */     this.LegR = new ModelRenderer(this, 0, 29);
/*  66 */     this.LegR.func_78793_a(-1.9F, 8.6F, 0.5F);
/*  67 */     this.LegR.func_78790_a(-3.2F, 2.7F, -3.0F, 5, 7, 6, 0.1F);
/*  68 */     this.FootR = new ModelRenderer(this, 0, 43);
/*  69 */     this.FootR.field_78809_i = true;
/*  70 */     this.FootR.func_78793_a(0.3F, 0.0F, 0.0F);
/*  71 */     this.FootR.func_78790_a(-3.3F, 0.4F, -3.0F, 5, 15, 6, 0.0F);
/*  72 */     this.Head2 = new ModelRenderer(this, 25, 0);
/*  73 */     this.Head2.func_78793_a(0.0F, -6.6F, -1.7F);
/*  74 */     this.Head2.func_78790_a(-1.0F, -3.4F, -1.3F, 2, 4, 3, 0.0F);
/*  75 */     setRotateAngle(this.Head2, -0.5677556F, 0.0F, 0.0F);
/*  76 */     this.Head3 = new ModelRenderer(this, 36, 0);
/*  77 */     this.Head3.func_78793_a(0.0F, -3.5F, 0.1F);
/*  78 */     this.Head3.func_78790_a(-0.5F, -1.0F, -0.6F, 1, 2, 3, 0.0F);
/*  79 */     setRotateAngle(this.Head3, 1.1383038F, 0.0F, 0.0F);
/*  80 */     this.ArmL2 = new ModelRenderer(this, 23, 49);
/*  81 */     this.ArmL2.field_78809_i = true;
/*  82 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.ArmL2.func_78790_a(-0.8F, 2.4F, -2.2F, 4, 10, 5, 0.0F);
/*  84 */     this.FootL = new ModelRenderer(this, 0, 43);
/*  85 */     this.FootL.func_78793_a(0.3F, 0.0F, 0.0F);
/*  86 */     this.FootL.func_78790_a(-2.4F, 0.4F, -3.0F, 5, 15, 6, 0.0F);
/*  87 */     this.ArmR.func_78792_a(this.ArmR2);
/*  88 */     this.Body.func_78792_a(this.Torso);
/*  89 */     this.Head3.func_78792_a(this.Head4);
/*  90 */     this.Torso.func_78792_a(this.ChestR);
/*  91 */     this.Body.func_78792_a(this.Hips);
/*  92 */     this.LegR.func_78792_a(this.FootR);
/*  93 */     this.Head.func_78792_a(this.Head2);
/*  94 */     this.Head2.func_78792_a(this.Head3);
/*  95 */     this.ArmL.func_78792_a(this.ArmL2);
/*  96 */     this.LegL.func_78792_a(this.FootL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 101 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 104 */     this.LegL.func_78785_a(f5);
/* 105 */     this.Head.func_78785_a(f5);
/* 106 */     this.ArmL.func_78785_a(f5);
/* 107 */     this.ArmR.func_78785_a(f5);
/* 108 */     this.Body.func_78785_a(f5);
/* 109 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 114 */     modelRenderer.field_78795_f = x;
/* 115 */     modelRenderer.field_78796_g = y;
/* 116 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 120 */     int calc = par7Entity.field_70173_aa;
/* 121 */     if (calc > 100) calc -= 100; 
/* 122 */     float r = 360.0F;
/* 123 */     float r2 = 180.0F;
/* 124 */     float n4 = par4;
/* 125 */     float n5 = par5;
/*     */     
/* 127 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 128 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 129 */     float ex = par7Entity.field_70173_aa;
/* 130 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 131 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 133 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 134 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 165 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 166 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 167 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 168 */     this.LegR.field_78796_g = 0.0F;
/* 169 */     this.LegL.field_78796_g = 0.0F;
/* 170 */     this.ArmR.field_78796_g = 0.0F;
/* 171 */     this.ArmL.field_78796_g = 0.0F;
/* 172 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBuuSuper_Buffed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */