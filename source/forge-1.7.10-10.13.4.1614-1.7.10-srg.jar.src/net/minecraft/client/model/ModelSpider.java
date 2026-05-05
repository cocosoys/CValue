/*     */ package net.minecraft.client.model;@SideOnly(Side.CLIENT)
/*     */ public class ModelSpider extends ModelBase {
/*     */   public ModelRenderer field_78209_a;
/*     */   public ModelRenderer field_78207_b;
/*     */   public ModelRenderer field_78208_c;
/*     */   public ModelRenderer field_78205_d;
/*     */   public ModelRenderer field_78206_e;
/*     */   public ModelRenderer field_78203_f;
/*     */   
/*     */   public ModelSpider() {
/*  11 */     float f = 0.0F;
/*     */     
/*  13 */     byte b = 15;
/*     */     
/*  15 */     this.field_78209_a = new ModelRenderer(this, 32, 4);
/*  16 */     this.field_78209_a.func_78790_a(-4.0F, -4.0F, -8.0F, 8, 8, 8, f);
/*  17 */     this.field_78209_a.func_78793_a(0.0F, b, -3.0F);
/*     */     
/*  19 */     this.field_78207_b = new ModelRenderer(this, 0, 0);
/*  20 */     this.field_78207_b.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, f);
/*  21 */     this.field_78207_b.func_78793_a(0.0F, b, 0.0F);
/*     */     
/*  23 */     this.field_78208_c = new ModelRenderer(this, 0, 12);
/*  24 */     this.field_78208_c.func_78790_a(-5.0F, -4.0F, -6.0F, 10, 8, 12, f);
/*  25 */     this.field_78208_c.func_78793_a(0.0F, b, 9.0F);
/*     */     
/*  27 */     this.field_78205_d = new ModelRenderer(this, 18, 0);
/*  28 */     this.field_78205_d.func_78790_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, f);
/*  29 */     this.field_78205_d.func_78793_a(-4.0F, b, 2.0F);
/*     */     
/*  31 */     this.field_78206_e = new ModelRenderer(this, 18, 0);
/*  32 */     this.field_78206_e.func_78790_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, f);
/*  33 */     this.field_78206_e.func_78793_a(4.0F, b, 2.0F);
/*     */     
/*  35 */     this.field_78203_f = new ModelRenderer(this, 18, 0);
/*  36 */     this.field_78203_f.func_78790_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, f);
/*  37 */     this.field_78203_f.func_78793_a(-4.0F, b, 1.0F);
/*     */     
/*  39 */     this.field_78204_g = new ModelRenderer(this, 18, 0);
/*  40 */     this.field_78204_g.func_78790_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, f);
/*  41 */     this.field_78204_g.func_78793_a(4.0F, b, 1.0F);
/*     */     
/*  43 */     this.field_78212_h = new ModelRenderer(this, 18, 0);
/*  44 */     this.field_78212_h.func_78790_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, f);
/*  45 */     this.field_78212_h.func_78793_a(-4.0F, b, 0.0F);
/*     */     
/*  47 */     this.field_78213_i = new ModelRenderer(this, 18, 0);
/*  48 */     this.field_78213_i.func_78790_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, f);
/*  49 */     this.field_78213_i.func_78793_a(4.0F, b, 0.0F);
/*     */     
/*  51 */     this.field_78210_j = new ModelRenderer(this, 18, 0);
/*  52 */     this.field_78210_j.func_78790_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, f);
/*  53 */     this.field_78210_j.func_78793_a(-4.0F, b, -1.0F);
/*     */     
/*  55 */     this.field_78211_k = new ModelRenderer(this, 18, 0);
/*  56 */     this.field_78211_k.func_78790_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, f);
/*  57 */     this.field_78211_k.func_78793_a(4.0F, b, -1.0F);
/*     */   }
/*     */   public ModelRenderer field_78204_g; public ModelRenderer field_78212_h; public ModelRenderer field_78213_i; public ModelRenderer field_78210_j; public ModelRenderer field_78211_k; private static final String __OBFID = "CL_00000860";
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/*  62 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*     */     
/*  64 */     this.field_78209_a.func_78785_a(p_78088_7_);
/*  65 */     this.field_78207_b.func_78785_a(p_78088_7_);
/*  66 */     this.field_78208_c.func_78785_a(p_78088_7_);
/*  67 */     this.field_78205_d.func_78785_a(p_78088_7_);
/*  68 */     this.field_78206_e.func_78785_a(p_78088_7_);
/*  69 */     this.field_78203_f.func_78785_a(p_78088_7_);
/*  70 */     this.field_78204_g.func_78785_a(p_78088_7_);
/*  71 */     this.field_78212_h.func_78785_a(p_78088_7_);
/*  72 */     this.field_78213_i.func_78785_a(p_78088_7_);
/*  73 */     this.field_78210_j.func_78785_a(p_78088_7_);
/*  74 */     this.field_78211_k.func_78785_a(p_78088_7_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/*  79 */     this.field_78209_a.field_78796_g = p_78087_4_ / 57.295776F;
/*  80 */     this.field_78209_a.field_78795_f = p_78087_5_ / 57.295776F;
/*     */     
/*  82 */     float f1 = 0.7853982F;
/*  83 */     this.field_78205_d.field_78808_h = -f1;
/*  84 */     this.field_78206_e.field_78808_h = f1;
/*     */     
/*  86 */     this.field_78203_f.field_78808_h = -f1 * 0.74F;
/*  87 */     this.field_78204_g.field_78808_h = f1 * 0.74F;
/*     */     
/*  89 */     this.field_78212_h.field_78808_h = -f1 * 0.74F;
/*  90 */     this.field_78213_i.field_78808_h = f1 * 0.74F;
/*     */     
/*  92 */     this.field_78210_j.field_78808_h = -f1;
/*  93 */     this.field_78211_k.field_78808_h = f1;
/*     */     
/*  95 */     float f2 = -0.0F;
/*  96 */     float f3 = 0.3926991F;
/*  97 */     this.field_78205_d.field_78796_g = f3 * 2.0F + f2;
/*  98 */     this.field_78206_e.field_78796_g = -f3 * 2.0F - f2;
/*  99 */     this.field_78203_f.field_78796_g = f3 * 1.0F + f2;
/* 100 */     this.field_78204_g.field_78796_g = -f3 * 1.0F - f2;
/* 101 */     this.field_78212_h.field_78796_g = -f3 * 1.0F + f2;
/* 102 */     this.field_78213_i.field_78796_g = f3 * 1.0F - f2;
/* 103 */     this.field_78210_j.field_78796_g = -f3 * 2.0F + f2;
/* 104 */     this.field_78211_k.field_78796_g = f3 * 2.0F - f2;
/*     */     
/* 106 */     float f4 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 0.0F) * 0.4F) * p_78087_2_;
/* 107 */     float f5 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 3.1415927F) * 0.4F) * p_78087_2_;
/* 108 */     float f6 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 1.5707964F) * 0.4F) * p_78087_2_;
/* 109 */     float f7 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 4.712389F) * 0.4F) * p_78087_2_;
/*     */     
/* 111 */     float f8 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 0.0F) * 0.4F) * p_78087_2_;
/* 112 */     float f9 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 3.1415927F) * 0.4F) * p_78087_2_;
/* 113 */     float f10 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 1.5707964F) * 0.4F) * p_78087_2_;
/* 114 */     float f11 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 4.712389F) * 0.4F) * p_78087_2_;
/*     */     
/* 116 */     this.field_78205_d.field_78796_g += f4;
/* 117 */     this.field_78206_e.field_78796_g += -f4;
/* 118 */     this.field_78203_f.field_78796_g += f5;
/* 119 */     this.field_78204_g.field_78796_g += -f5;
/* 120 */     this.field_78212_h.field_78796_g += f6;
/* 121 */     this.field_78213_i.field_78796_g += -f6;
/* 122 */     this.field_78210_j.field_78796_g += f7;
/* 123 */     this.field_78211_k.field_78796_g += -f7;
/*     */     
/* 125 */     this.field_78205_d.field_78808_h += f8;
/* 126 */     this.field_78206_e.field_78808_h += -f8;
/* 127 */     this.field_78203_f.field_78808_h += f9;
/* 128 */     this.field_78204_g.field_78808_h += -f9;
/* 129 */     this.field_78212_h.field_78808_h += f10;
/* 130 */     this.field_78213_i.field_78808_h += -f10;
/* 131 */     this.field_78210_j.field_78808_h += f11;
/* 132 */     this.field_78211_k.field_78808_h += -f11;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSpider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */