/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelHop
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer Hair6;
/*     */   public ModelRenderer Hair7;
/*     */   public ModelRenderer Hair8;
/*     */   public ModelRenderer Hair9;
/*     */   public ModelRenderer Hair11;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   public ModelRenderer tail4;
/*     */   public ModelRenderer tail5;
/*     */   
/*     */   public ModelHop() {
/*  39 */     this.field_78090_t = 64;
/*  40 */     this.field_78089_u = 64;
/*  41 */     this.tail1 = new ModelRenderer(this, 42, 19);
/*  42 */     this.tail1.func_78793_a(0.0F, 11.4F, 1.6F);
/*  43 */     this.tail1.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  44 */     setRotateAngle(this.tail1, 1.0011208F, 0.0F, 0.0F);
/*  45 */     this.tail4 = new ModelRenderer(this, 42, 23);
/*  46 */     this.tail4.func_78793_a(0.0F, 2.6F, 0.0F);
/*  47 */     this.tail4.func_78790_a(-0.5F, 0.2F, -0.5F, 1, 3, 1, 0.0F);
/*  48 */     setRotateAngle(this.tail4, 0.20507619F, 0.0F, 0.0F);
/*  49 */     this.Boobs = new ModelRenderer(this, 19, 31);
/*  50 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.Boobs.func_78790_a(-3.0F, 2.1F, -0.7F, 6, 3, 2, 0.0F);
/*  52 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  53 */     this.Hair4 = new ModelRenderer(this, 39, 0);
/*  54 */     this.Hair4.func_78793_a(1.6F, -6.2F, -0.5F);
/*  55 */     this.Hair4.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/*  56 */     setRotateAngle(this.Hair4, 0.0F, -0.007853982F, 0.8237954F);
/*  57 */     this.ArmR = new ModelRenderer(this, 32, 35);
/*  58 */     this.ArmR.func_78793_a(-4.3F, 2.8F, 0.0F);
/*  59 */     this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
/*  60 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  61 */     this.Hair7 = new ModelRenderer(this, 50, 8);
/*  62 */     this.Hair7.func_78793_a(0.2F, -6.3F, -1.3F);
/*  63 */     this.Hair7.func_78790_a(-0.5F, -2.3F, -0.8F, 1, 2, 2, 0.0F);
/*  64 */     setRotateAngle(this.Hair7, 0.0F, 0.0F, 0.3970624F);
/*  65 */     this.Head = new ModelRenderer(this, 0, 0);
/*  66 */     this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
/*  67 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  68 */     this.tail2 = new ModelRenderer(this, 42, 19);
/*  69 */     this.tail2.func_78793_a(0.0F, 2.6F, 0.0F);
/*  70 */     this.tail2.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  71 */     setRotateAngle(this.tail2, -0.18203785F, 0.0F, 0.0F);
/*  72 */     this.tail5 = new ModelRenderer(this, 42, 23);
/*  73 */     this.tail5.func_78793_a(0.0F, 3.1F, 0.0F);
/*  74 */     this.tail5.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  75 */     setRotateAngle(this.tail5, 0.27314404F, 0.0F, 0.0F);
/*  76 */     this.EarL = new ModelRenderer(this, 28, 1);
/*  77 */     this.EarL.field_78809_i = true;
/*  78 */     this.EarL.func_78793_a(2.4F, -5.9F, 0.0F);
/*  79 */     this.EarL.func_78790_a(-2.0F, -5.0F, 0.0F, 4, 5, 0, 0.0F);
/*  80 */     setRotateAngle(this.EarL, 0.0F, 0.0F, 0.13665928F);
/*  81 */     this.ArmL = new ModelRenderer(this, 32, 35);
/*  82 */     this.ArmL.field_78809_i = true;
/*  83 */     this.ArmL.func_78793_a(4.3F, 2.8F, 0.0F);
/*  84 */     this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
/*  85 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  86 */     this.Hair11 = new ModelRenderer(this, 49, 0);
/*  87 */     this.Hair11.func_78793_a(1.6F, -6.4F, 0.9F);
/*  88 */     this.Hair11.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 3, 0.0F);
/*  89 */     setRotateAngle(this.Hair11, -0.27314404F, 0.091106184F, 1.4114478F);
/*  90 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  91 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/*  92 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
/*  93 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  94 */     this.LegL.field_78809_i = true;
/*  95 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  96 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  97 */     this.tail3 = new ModelRenderer(this, 42, 19);
/*  98 */     this.tail3.func_78793_a(0.0F, 2.6F, 0.0F);
/*  99 */     this.tail3.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/* 100 */     setRotateAngle(this.tail3, -0.18203785F, 0.0F, 0.0F);
/* 101 */     this.Hair5 = new ModelRenderer(this, 39, 0);
/* 102 */     this.Hair5.func_78793_a(2.4F, -6.2F, -1.3F);
/* 103 */     this.Hair5.func_78790_a(-1.0F, -0.2F, -0.8F, 2, 3, 2, 0.0F);
/* 104 */     setRotateAngle(this.Hair5, 0.0F, 0.0F, -0.54209924F);
/* 105 */     this.Hair8 = new ModelRenderer(this, 39, 0);
/* 106 */     this.Hair8.func_78793_a(2.7F, -4.4F, 0.7F);
/* 107 */     this.Hair8.func_78790_a(-1.0F, -0.2F, -0.8F, 2, 3, 2, 0.0F);
/* 108 */     setRotateAngle(this.Hair8, 0.0F, 0.0F, -0.24137904F);
/* 109 */     this.Hair6 = new ModelRenderer(this, 49, 0);
/* 110 */     this.Hair6.func_78793_a(0.0F, -6.1F, 0.4F);
/* 111 */     this.Hair6.func_78790_a(-1.1F, -3.4F, -0.9F, 2, 4, 3, 0.0F);
/* 112 */     setRotateAngle(this.Hair6, -0.46617743F, -0.05427974F, -0.82396996F);
/* 113 */     this.Hair2 = new ModelRenderer(this, 37, 6);
/* 114 */     this.Hair2.func_78793_a(0.0F, -6.3F, -1.9F);
/* 115 */     this.Hair2.func_78790_a(-4.7F, -1.6F, -0.8F, 4, 3, 2, 0.0F);
/* 116 */     setRotateAngle(this.Hair2, 0.0F, -0.2602286F, 0.043284167F);
/* 117 */     this.Body2 = new ModelRenderer(this, 0, 30);
/* 118 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
/* 120 */     this.Hair1 = new ModelRenderer(this, 39, 0);
/* 121 */     this.Hair1.func_78793_a(-0.6F, -6.8F, -1.3F);
/* 122 */     this.Hair1.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/* 123 */     setRotateAngle(this.Hair1, 0.0F, 0.0F, -0.34697145F);
/* 124 */     this.LegR = new ModelRenderer(this, 0, 46);
/* 125 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/* 126 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 127 */     this.Hair3 = new ModelRenderer(this, 39, 0);
/* 128 */     this.Hair3.func_78793_a(-3.4F, -6.0F, -1.2F);
/* 129 */     this.Hair3.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/* 130 */     setRotateAngle(this.Hair3, 0.0F, 0.0F, 0.34697145F);
/* 131 */     this.Hair = new ModelRenderer(this, 0, 0);
/* 132 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/* 133 */     this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
/* 134 */     this.Hair9 = new ModelRenderer(this, 39, 0);
/* 135 */     this.Hair9.func_78793_a(-2.7F, -4.3F, 0.8F);
/* 136 */     this.Hair9.func_78790_a(-1.1F, 0.0F, -0.7F, 2, 3, 2, 0.0F);
/* 137 */     setRotateAngle(this.Hair9, 0.0F, 0.0F, 0.22828907F);
/* 138 */     this.Body3 = new ModelRenderer(this, 0, 38);
/* 139 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
/* 141 */     this.EarR = new ModelRenderer(this, 28, 1);
/* 142 */     this.EarR.func_78793_a(-2.4F, -5.9F, 0.0F);
/* 143 */     this.EarR.func_78790_a(-2.0F, -5.0F, 0.0F, 4, 5, 0, 0.0F);
/* 144 */     setRotateAngle(this.EarR, 0.0F, 0.0F, -0.13665928F);
/* 145 */     this.tail3.func_78792_a(this.tail4);
/* 146 */     this.Body1.func_78792_a(this.Boobs);
/* 147 */     this.Hair.func_78792_a(this.Hair4);
/* 148 */     this.Hair.func_78792_a(this.Hair7);
/* 149 */     this.tail1.func_78792_a(this.tail2);
/* 150 */     this.tail4.func_78792_a(this.tail5);
/* 151 */     this.Head.func_78792_a(this.EarL);
/* 152 */     this.Hair.func_78792_a(this.Hair11);
/* 153 */     this.tail2.func_78792_a(this.tail3);
/* 154 */     this.Hair.func_78792_a(this.Hair5);
/* 155 */     this.Hair.func_78792_a(this.Hair8);
/* 156 */     this.Hair.func_78792_a(this.Hair6);
/* 157 */     this.Hair.func_78792_a(this.Hair2);
/* 158 */     this.Body1.func_78792_a(this.Body2);
/* 159 */     this.Hair.func_78792_a(this.Hair1);
/* 160 */     this.Hair.func_78792_a(this.Hair3);
/* 161 */     this.Head.func_78792_a(this.Hair);
/* 162 */     this.Hair.func_78792_a(this.Hair9);
/* 163 */     this.Body2.func_78792_a(this.Body3);
/* 164 */     this.Head.func_78792_a(this.EarR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 169 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 171 */     this.ArmR.func_78785_a(f5);
/* 172 */     this.Head.func_78785_a(f5);
/* 173 */     this.ArmL.func_78785_a(f5);
/* 174 */     this.Body1.func_78785_a(f5);
/* 175 */     this.LegL.func_78785_a(f5);
/* 176 */     this.LegR.func_78785_a(f5);
/* 177 */     this.tail1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 182 */     modelRenderer.field_78795_f = x;
/* 183 */     modelRenderer.field_78796_g = y;
/* 184 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 188 */     int calc = par7Entity.field_70173_aa;
/* 189 */     if (calc > 100) calc -= 100; 
/* 190 */     float r = 360.0F;
/* 191 */     float r2 = 180.0F;
/* 192 */     float n4 = par4;
/* 193 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 197 */     float ex = par7Entity.field_70173_aa;
/* 198 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 199 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 201 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 202 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     this.tail2.field_78795_f = 0.2F;
/* 208 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 210 */     this.tail3.field_78795_f = 0.2F;
/* 211 */     this.tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 213 */     this.tail4.field_78795_f = 0.2F;
/* 214 */     this.tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 216 */     this.tail5.field_78796_g = 0.2F;
/* 217 */     this.tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 248 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 249 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 250 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 251 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 253 */     this.LegR.field_78796_g = 0.0F;
/* 254 */     this.LegL.field_78796_g = 0.0F;
/* 255 */     this.ArmR.field_78796_g = 0.0F;
/* 256 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 263 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelHop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */