/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBuuSuper
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
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer FootL;
/*     */   
/*     */   public ModelBuuSuper() {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.Body = new ModelRenderer(this, 22, 29);
/*  29 */     this.Body.func_78793_a(0.0F, -2.7F, 0.0F);
/*  30 */     this.Body.func_78790_a(-3.5F, 2.6F, -1.9F, 7, 7, 4, 0.0F);
/*  31 */     this.LegL = new ModelRenderer(this, 0, 28);
/*  32 */     this.LegL.field_78809_i = true;
/*  33 */     this.LegL.func_78793_a(2.0F, 9.0F, 0.0F);
/*  34 */     this.LegL.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
/*  35 */     this.LegR = new ModelRenderer(this, 0, 28);
/*  36 */     this.LegR.func_78793_a(-2.0F, 9.0F, 0.0F);
/*  37 */     this.LegR.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
/*  38 */     this.ChestR = new ModelRenderer(this, 0, 22);
/*  39 */     this.ChestR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.ChestR.func_78790_a(-4.1F, 1.1F, -1.8F, 8, 3, 2, 0.0F);
/*  41 */     setRotateAngle(this.ChestR, -0.077667154F, 0.0F, 0.0F);
/*  42 */     this.ArmL = new ModelRenderer(this, 48, 19);
/*  43 */     this.ArmL.field_78809_i = true;
/*  44 */     this.ArmL.func_78793_a(5.4F, -1.4F, 0.3F);
/*  45 */     this.ArmL.func_78790_a(-1.0F, -1.3F, -1.7F, 4, 12, 4, -0.1F);
/*  46 */     this.FootR = new ModelRenderer(this, 0, 43);
/*  47 */     this.FootR.field_78809_i = true;
/*  48 */     this.FootR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.FootR.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
/*  50 */     this.FootL = new ModelRenderer(this, 0, 43);
/*  51 */     this.FootL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.FootL.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
/*  53 */     this.Head2 = new ModelRenderer(this, 25, 0);
/*  54 */     this.Head2.func_78793_a(0.0F, -6.9F, -1.8F);
/*  55 */     this.Head2.func_78790_a(-1.0F, -3.4F, -1.4F, 2, 4, 3, 0.0F);
/*  56 */     setRotateAngle(this.Head2, -0.3635521F, 0.0F, 0.0F);
/*  57 */     this.Head4 = new ModelRenderer(this, 36, 0);
/*  58 */     this.Head4.func_78793_a(0.0F, -0.1F, 2.4F);
/*  59 */     this.Head4.func_78790_a(-0.5F, -0.5F, -0.3F, 1, 1, 3, 0.0F);
/*  60 */     setRotateAngle(this.Head4, -0.63739425F, 0.0F, 0.0F);
/*  61 */     this.Hips = new ModelRenderer(this, 19, 41);
/*  62 */     this.Hips.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.Hips.func_78790_a(-4.0F, 8.8F, -2.3F, 8, 3, 5, 0.0F);
/*  64 */     this.Torso = new ModelRenderer(this, 21, 19);
/*  65 */     this.Torso.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.Torso.func_78790_a(-4.5F, 0.1F, -0.9F, 9, 5, 4, 0.0F);
/*  67 */     this.Head = new ModelRenderer(this, 0, 0);
/*  68 */     this.Head.func_78793_a(0.0F, -2.5F, 0.2F);
/*  69 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.1F, 8, 8, 8, -0.6F);
/*  70 */     this.Head3 = new ModelRenderer(this, 36, 0);
/*  71 */     this.Head3.func_78793_a(0.0F, -3.6F, 0.0F);
/*  72 */     this.Head3.func_78790_a(-0.5F, -1.0F, -0.6F, 1, 2, 3, 0.0F);
/*  73 */     setRotateAngle(this.Head3, 1.1383038F, 0.0F, 0.0F);
/*  74 */     this.ArmR = new ModelRenderer(this, 48, 19);
/*  75 */     this.ArmR.func_78793_a(-5.4F, -1.4F, 0.3F);
/*  76 */     this.ArmR.func_78790_a(-3.0F, -1.3F, -1.7F, 4, 12, 4, -0.1F);
/*  77 */     this.Torso.func_78792_a(this.ChestR);
/*  78 */     this.LegR.func_78792_a(this.FootR);
/*  79 */     this.LegL.func_78792_a(this.FootL);
/*  80 */     this.Head.func_78792_a(this.Head2);
/*  81 */     this.Head3.func_78792_a(this.Head4);
/*  82 */     this.Body.func_78792_a(this.Hips);
/*  83 */     this.Body.func_78792_a(this.Torso);
/*  84 */     this.Head2.func_78792_a(this.Head3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  89 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  92 */     this.LegL.func_78785_a(f5);
/*  93 */     this.Head.func_78785_a(f5);
/*  94 */     this.ArmL.func_78785_a(f5);
/*  95 */     this.ArmR.func_78785_a(f5);
/*  96 */     this.Body.func_78785_a(f5);
/*  97 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 102 */     modelRenderer.field_78795_f = x;
/* 103 */     modelRenderer.field_78796_g = y;
/* 104 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 108 */     int calc = par7Entity.field_70173_aa;
/* 109 */     if (calc > 100) calc -= 100; 
/* 110 */     float r = 360.0F;
/* 111 */     float r2 = 180.0F;
/* 112 */     float n4 = par4;
/* 113 */     float n5 = par5;
/*     */     
/* 115 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 116 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 117 */     float ex = par7Entity.field_70173_aa;
/* 118 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 119 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 121 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 122 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 153 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 154 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 155 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 156 */     this.LegR.field_78796_g = 0.0F;
/* 157 */     this.LegL.field_78796_g = 0.0F;
/* 158 */     this.ArmR.field_78796_g = 0.0F;
/* 159 */     this.ArmL.field_78796_g = 0.0F;
/* 160 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBuuSuper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */