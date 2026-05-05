/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBuuSuper_Ultimate
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
/*     */   public ModelRenderer Head5;
/*     */   public ModelRenderer Head6;
/*     */   public ModelRenderer Torso;
/*     */   public ModelRenderer Hips;
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer FootL;
/*     */   
/*     */   public ModelBuuSuper_Ultimate() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.Head2 = new ModelRenderer(this, 25, 0);
/*  30 */     this.Head2.func_78793_a(0.0F, -6.1F, -2.4F);
/*  31 */     this.Head2.func_78790_a(-1.5F, -4.2F, -1.0F, 3, 4, 3, 0.0F);
/*  32 */     setRotateAngle(this.Head2, -0.49392816F, 0.0F, 0.0F);
/*  33 */     this.Head = new ModelRenderer(this, 0, 0);
/*  34 */     this.Head.func_78793_a(0.0F, -2.5F, 0.6F);
/*  35 */     this.Head.func_78790_a(-4.0F, -7.4F, -4.1F, 8, 8, 8, -0.7F);
/*  36 */     this.Head3 = new ModelRenderer(this, 38, 1);
/*  37 */     this.Head3.func_78793_a(0.0F, -3.8F, -0.6F);
/*  38 */     this.Head3.func_78790_a(-1.5F, -6.1F, -0.5F, 3, 6, 2, 0.0F);
/*  39 */     setRotateAngle(this.Head3, -0.68294734F, 0.0F, 0.0F);
/*  40 */     this.Head4 = new ModelRenderer(this, 49, 1);
/*  41 */     this.Head4.func_78793_a(0.0F, -5.5F, 0.1F);
/*  42 */     this.Head4.func_78790_a(-1.0F, -5.1F, -0.8F, 2, 5, 2, 0.0F);
/*  43 */     setRotateAngle(this.Head4, -0.7285004F, 0.0F, 0.0F);
/*  44 */     this.ArmL = new ModelRenderer(this, 46, 30);
/*  45 */     this.ArmL.field_78809_i = true;
/*  46 */     this.ArmL.func_78793_a(5.4F, -1.5F, 0.5F);
/*  47 */     this.ArmL.func_78790_a(-1.2F, -1.3F, -1.8F, 4, 12, 4, -0.2F);
/*  48 */     this.LegR = new ModelRenderer(this, 0, 28);
/*  49 */     this.LegR.func_78793_a(-2.0F, 9.0F, 0.0F);
/*  50 */     this.LegR.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
/*  51 */     this.LegL = new ModelRenderer(this, 0, 28);
/*  52 */     this.LegL.field_78809_i = true;
/*  53 */     this.LegL.func_78793_a(2.0F, 9.0F, 0.0F);
/*  54 */     this.LegL.func_78790_a(-2.0F, 2.0F, -2.3F, 4, 7, 5, 0.3F);
/*  55 */     this.Head5 = new ModelRenderer(this, 37, 10);
/*  56 */     this.Head5.func_78793_a(0.0F, -4.7F, -0.3F);
/*  57 */     this.Head5.func_78790_a(-0.5F, -6.0F, -0.6F, 1, 6, 2, 0.0F);
/*  58 */     setRotateAngle(this.Head5, -0.63739425F, 0.0F, 0.0F);
/*  59 */     this.Torso = new ModelRenderer(this, 21, 20);
/*  60 */     this.Torso.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Torso.func_78790_a(-4.5F, 0.1F, -1.8F, 9, 7, 5, 0.0F);
/*  62 */     this.FootR = new ModelRenderer(this, 0, 43);
/*  63 */     this.FootR.field_78809_i = true;
/*  64 */     this.FootR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.FootR.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
/*  66 */     this.Body = new ModelRenderer(this, 19, 34);
/*  67 */     this.Body.func_78793_a(0.0F, -2.7F, 0.0F);
/*  68 */     this.Body.func_78790_a(-4.0F, 2.7F, -2.2F, 8, 6, 5, 0.0F);
/*  69 */     this.FootL = new ModelRenderer(this, 0, 43);
/*  70 */     this.FootL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.FootL.func_78790_a(-2.0F, 0.0F, -2.3F, 4, 15, 5, 0.0F);
/*  72 */     this.Hips = new ModelRenderer(this, 19, 50);
/*  73 */     this.Hips.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.Hips.func_78790_a(-4.0F, 8.7F, -2.3F, 8, 3, 5, 0.0F);
/*  75 */     this.ArmR = new ModelRenderer(this, 46, 30);
/*  76 */     this.ArmR.func_78793_a(-5.5F, -1.5F, 0.5F);
/*  77 */     this.ArmR.func_78790_a(-2.8F, -1.3F, -1.8F, 4, 12, 4, -0.2F);
/*  78 */     this.Head6 = new ModelRenderer(this, 44, 11);
/*  79 */     this.Head6.func_78793_a(0.0F, -5.6F, 0.3F);
/*  80 */     this.Head6.func_78790_a(-0.5F, -6.0F, -0.6F, 1, 6, 1, 0.0F);
/*  81 */     setRotateAngle(this.Head6, -0.46251225F, 0.0F, 0.0F);
/*  82 */     this.Head.func_78792_a(this.Head2);
/*  83 */     this.Head2.func_78792_a(this.Head3);
/*  84 */     this.Head3.func_78792_a(this.Head4);
/*  85 */     this.Head4.func_78792_a(this.Head5);
/*  86 */     this.Body.func_78792_a(this.Torso);
/*  87 */     this.LegR.func_78792_a(this.FootR);
/*  88 */     this.LegL.func_78792_a(this.FootL);
/*  89 */     this.Body.func_78792_a(this.Hips);
/*  90 */     this.Head5.func_78792_a(this.Head6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  95 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  98 */     this.LegL.func_78785_a(f5);
/*  99 */     this.Head.func_78785_a(f5);
/* 100 */     this.ArmL.func_78785_a(f5);
/* 101 */     this.ArmR.func_78785_a(f5);
/* 102 */     this.Body.func_78785_a(f5);
/* 103 */     this.LegR.func_78785_a(f5);
/*     */   }
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
/* 158 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 159 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 160 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 161 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 162 */     this.LegR.field_78796_g = 0.0F;
/* 163 */     this.LegL.field_78796_g = 0.0F;
/* 164 */     this.ArmR.field_78796_g = 0.0F;
/* 165 */     this.ArmL.field_78796_g = 0.0F;
/* 166 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBuuSuper_Ultimate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */