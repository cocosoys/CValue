/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelAngelCamparri
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Nose1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Nose2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer NeckRing;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer ClothB;
/*     */   public ModelRenderer ClothF2;
/*     */   public ModelRenderer ClothB2;
/*     */   public ModelRenderer NeckRing_1;
/*     */   public ModelRenderer NeckRing_2;
/*     */   public ModelRenderer NeckRing_3;
/*     */   public ModelRenderer NeckRing_4;
/*     */   public ModelRenderer NeckRing_5;
/*     */   public ModelRenderer NeckRing_6;
/*     */   public ModelRenderer NeckRing_7;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelAngelCamparri() {
/*  41 */     this.field_78090_t = 64;
/*  42 */     this.field_78089_u = 64;
/*  43 */     this.Hair2 = new ModelRenderer(this, 31, 6);
/*  44 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  45 */     this.Hair2.func_78790_a(-4.0F, -3.7F, 3.8F, 8, 2, 2, 0.0F);
/*  46 */     this.ShoulderR = new ModelRenderer(this, 31, 10);
/*  47 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.ShoulderR.func_78790_a(-2.8F, -2.3F, -1.7F, 4, 4, 4, 0.0F);
/*  49 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/*  50 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.NeckRing_1.func_78790_a(-9.7F, -1.5F, -2.9F, 2, 1, 7, 0.0F);
/*  52 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/*  53 */     this.ClothF2 = new ModelRenderer(this, 33, 46);
/*  54 */     this.ClothF2.func_78793_a(0.0F, 4.9F, 0.0F);
/*  55 */     this.ClothF2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/*  56 */     setRotateAngle(this.ClothF2, 0.04363323F, 0.0F, 0.0F);
/*  57 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/*  58 */     this.LegL2.field_78809_i = true;
/*  59 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.LegL2.func_78790_a(-1.9F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  61 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/*  62 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.NeckRing_4.func_78790_a(-8.5F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/*  64 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/*  65 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  66 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/*  67 */     this.LegR.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/*  68 */     this.Hair1 = new ModelRenderer(this, 31, 0);
/*  69 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.Hair1.func_78790_a(-3.5F, -4.7F, 1.5F, 7, 3, 3, 0.0F);
/*  71 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/*  72 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.NeckRing_3.func_78790_a(-8.7F, -1.5F, -3.2F, 2, 1, 7, 0.0F);
/*  74 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/*  75 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/*  76 */     this.LegR2.field_78809_i = true;
/*  77 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.LegR2.func_78790_a(-2.1F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  79 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/*  80 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.NeckRing_2.func_78790_a(-8.7F, -1.5F, -3.9F, 2, 1, 9, 0.0F);
/*  82 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/*  83 */     this.ClothF = new ModelRenderer(this, 44, 46);
/*  84 */     this.ClothF.func_78793_a(0.0F, 6.9F, -1.8F);
/*  85 */     this.ClothF.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/*  86 */     setRotateAngle(this.ClothF, -0.09424778F, 0.0F, 0.0F);
/*  87 */     this.Body2 = new ModelRenderer(this, 23, 31);
/*  88 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 2, 3, 0.0F);
/*  90 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  91 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  92 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/*  93 */     this.Head = new ModelRenderer(this, 0, 0);
/*  94 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/*  95 */     this.Head.func_78790_a(-3.5F, -7.5F, -4.0F, 7, 8, 8, -0.4F);
/*  96 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  97 */     this.ArmR.func_78793_a(-5.0F, -1.0F, 0.0F);
/*  98 */     this.ArmR.func_78790_a(-2.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
/*  99 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/* 100 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.NeckRing_5.func_78790_a(-8.3F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/* 102 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/* 103 */     this.LegL = new ModelRenderer(this, 0, 33);
/* 104 */     this.LegL.field_78809_i = true;
/* 105 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/* 106 */     this.LegL.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/* 107 */     this.Neck = new ModelRenderer(this, 7, 17);
/* 108 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.Neck.func_78790_a(-2.0F, -1.1F, -0.8F, 4, 2, 2, 0.0F);
/* 110 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/* 111 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.NeckRing_6.func_78790_a(-8.3F, -1.5F, -5.5F, 2, 1, 9, 0.0F);
/* 113 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/* 114 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/* 115 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.NeckRing_7.func_78790_a(-9.6F, -1.5F, -4.2F, 2, 1, 7, 0.0F);
/* 117 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/* 118 */     this.ShoulderL = new ModelRenderer(this, 31, 10);
/* 119 */     this.ShoulderL.field_78809_i = true;
/* 120 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 121 */     this.ShoulderL.func_78790_a(-1.0F, -2.3F, -1.9F, 4, 4, 4, 0.0F);
/* 122 */     this.ClothB = new ModelRenderer(this, 44, 46);
/* 123 */     this.ClothB.func_78793_a(0.0F, 7.0F, 2.2F);
/* 124 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/* 125 */     setRotateAngle(this.ClothB, 0.054105207F, 0.0F, 0.0F);
/* 126 */     this.Nose2 = new ModelRenderer(this, 24, 0);
/* 127 */     this.Nose2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.Nose2.func_78790_a(-0.5F, -2.3F, -4.8F, 1, 1, 2, 0.0F);
/* 129 */     setRotateAngle(this.Nose2, -0.8196066F, 0.0F, 0.0F);
/* 130 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/* 131 */     this.NeckRing.func_78793_a(0.0F, -1.0F, 0.0F);
/* 132 */     this.NeckRing.func_78790_a(-3.5F, -1.5F, 7.9F, 7, 1, 2, 0.0F);
/* 133 */     setRotateAngle(this.NeckRing, 0.53249997F, 0.0F, 0.0F);
/* 134 */     this.ClothB2 = new ModelRenderer(this, 33, 46);
/* 135 */     this.ClothB2.func_78793_a(0.0F, 5.0F, 0.0F);
/* 136 */     this.ClothB2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/* 137 */     setRotateAngle(this.ClothB2, -0.006981317F, 0.0F, 0.0F);
/* 138 */     this.ArmL = new ModelRenderer(this, 50, 16);
/* 139 */     this.ArmL.field_78809_i = true;
/* 140 */     this.ArmL.func_78793_a(5.0F, -1.0F, 0.0F);
/* 141 */     this.ArmL.func_78790_a(-1.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
/* 142 */     this.Body3 = new ModelRenderer(this, 20, 37);
/* 143 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/* 145 */     this.Nose1 = new ModelRenderer(this, 24, 0);
/* 146 */     this.Nose1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.Nose1.func_78790_a(-0.5F, -4.8F, -1.4F, 1, 2, 2, 0.0F);
/* 148 */     setRotateAngle(this.Nose1, 0.8196066F, 0.0F, 0.0F);
/* 149 */     this.Hair1.func_78792_a(this.Hair2);
/* 150 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 151 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 152 */     this.ClothF.func_78792_a(this.ClothF2);
/* 153 */     this.LegL.func_78792_a(this.LegL2);
/* 154 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 155 */     this.Head.func_78792_a(this.Hair1);
/* 156 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 157 */     this.LegR.func_78792_a(this.LegR2);
/* 158 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 159 */     this.Body3.func_78792_a(this.ClothF);
/* 160 */     this.Body1.func_78792_a(this.Body2);
/* 161 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 162 */     this.Body1.func_78792_a(this.Neck);
/* 163 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 164 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 165 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 166 */     this.Body3.func_78792_a(this.ClothB);
/* 167 */     this.Nose1.func_78792_a(this.Nose2);
/* 168 */     this.Body1.func_78792_a(this.NeckRing);
/* 169 */     this.ClothB.func_78792_a(this.ClothB2);
/* 170 */     this.Body2.func_78792_a(this.Body3);
/* 171 */     this.Head.func_78792_a(this.Nose1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 176 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 179 */     this.LegL.func_78785_a(f5);
/* 180 */     this.Head.func_78785_a(f5);
/* 181 */     this.ArmL.func_78785_a(f5);
/* 182 */     this.ArmR.func_78785_a(f5);
/* 183 */     this.Body1.func_78785_a(f5);
/* 184 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 189 */     modelRenderer.field_78795_f = x;
/* 190 */     modelRenderer.field_78796_g = y;
/* 191 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 195 */     int calc = par7Entity.field_70173_aa;
/* 196 */     if (calc > 100) calc -= 100; 
/* 197 */     float r = 360.0F;
/* 198 */     float r2 = 180.0F;
/* 199 */     float n4 = par4;
/* 200 */     float n5 = par5;
/*     */     
/* 202 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 203 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 204 */     float ex = par7Entity.field_70173_aa;
/* 205 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 206 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 208 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 209 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 251 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 252 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 253 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 254 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 256 */     this.LegR.field_78796_g = 0.0F;
/* 257 */     this.LegL.field_78796_g = 0.0F;
/* 258 */     this.ArmR.field_78796_g = 0.0F;
/* 259 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 262 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 263 */     this.ClothF2.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 264 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 265 */     this.ClothB2.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 266 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelCamparri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */