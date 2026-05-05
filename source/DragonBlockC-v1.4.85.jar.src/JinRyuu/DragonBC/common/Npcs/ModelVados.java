/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelVados
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer NeckRing;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer ClothB;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer NeckRing_1;
/*     */   public ModelRenderer NeckRing_2;
/*     */   public ModelRenderer NeckRing_3;
/*     */   public ModelRenderer NeckRing_4;
/*     */   public ModelRenderer NeckRing_5;
/*     */   public ModelRenderer NeckRing_6;
/*     */   public ModelRenderer NeckRing_7;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL4;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelVados() {
/*  43 */     this.field_78090_t = 64;
/*  44 */     this.field_78089_u = 64;
/*  45 */     this.Hair2 = new ModelRenderer(this, 30, 1);
/*  46 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.Hair2.func_78790_a(-2.5F, -11.6F, 0.2F, 5, 3, 6, 0.0F);
/*  48 */     this.Hair5 = new ModelRenderer(this, 56, 18);
/*  49 */     this.Hair5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Hair5.func_78790_a(-1.0F, -1.9F, 7.4F, 2, 6, 2, 0.0F);
/*  51 */     this.LegR3 = new ModelRenderer(this, 0, 33);
/*  52 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.LegR3.func_78790_a(-1.6F, 0.0F, -2.0F, 3, 15, 4, 0.0F);
/*  54 */     this.Boobs = new ModelRenderer(this, 35, 28);
/*  55 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.Boobs.func_78790_a(-3.5F, 1.4F, -1.2F, 7, 3, 3, 0.0F);
/*  57 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  58 */     this.Head = new ModelRenderer(this, 0, 0);
/*  59 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/*  60 */     this.Head.func_78790_a(-3.5F, -7.5F, -4.0F, 7, 8, 8, -0.4F);
/*  61 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/*  62 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.NeckRing_5.func_78790_a(-8.3F, -2.0F, -3.3F, 2, 1, 7, 0.0F);
/*  64 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/*  65 */     this.LegL4 = new ModelRenderer(this, 0, 33);
/*  66 */     this.LegL4.field_78809_i = true;
/*  67 */     this.LegL4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.LegL4.func_78790_a(-1.4F, 0.0F, -2.0F, 3, 15, 4, 0.0F);
/*  69 */     this.Body1 = new ModelRenderer(this, 16, 18);
/*  70 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  71 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
/*  72 */     this.LegL = new ModelRenderer(this, 0, 20);
/*  73 */     this.LegL.field_78809_i = true;
/*  74 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/*  75 */     this.LegL.func_78790_a(-1.7F, 0.0F, -2.0F, 4, 9, 4, 0.3F);
/*  76 */     this.ClothF = new ModelRenderer(this, 49, 52);
/*  77 */     this.ClothF.func_78793_a(0.0F, 9.0F, -2.1F);
/*  78 */     this.ClothF.func_78790_a(-2.5F, 0.0F, 0.1F, 5, 11, 0, 0.0F);
/*  79 */     setRotateAngle(this.ClothF, -0.11519173F, 0.0F, 0.0F);
/*  80 */     this.Hair4 = new ModelRenderer(this, 52, 7);
/*  81 */     this.Hair4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.Hair4.func_78790_a(-1.5F, -8.4F, 7.2F, 3, 7, 3, 0.0F);
/*  83 */     this.Body2 = new ModelRenderer(this, 16, 28);
/*  84 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.Body2.func_78790_a(-3.0F, 5.0F, -1.5F, 6, 4, 3, 0.0F);
/*  86 */     this.Body3 = new ModelRenderer(this, 15, 36);
/*  87 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/*  89 */     this.ClothB = new ModelRenderer(this, 49, 52);
/*  90 */     this.ClothB.func_78793_a(0.0F, 9.0F, 2.0F);
/*  91 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/*  92 */     setRotateAngle(this.ClothB, 0.13264503F, 0.0F, 0.0F);
/*  93 */     this.Hair3 = new ModelRenderer(this, 48, 0);
/*  94 */     this.Hair3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.Hair3.func_78790_a(-2.1F, -10.7F, 5.2F, 4, 3, 4, 0.0F);
/*  96 */     this.Hair1 = new ModelRenderer(this, 23, 0);
/*  97 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.Hair1.func_78790_a(-1.5F, -8.7F, 0.9F, 3, 2, 3, 0.0F);
/*  99 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/* 100 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.NeckRing_3.func_78790_a(-8.7F, -2.0F, -3.2F, 2, 1, 7, 0.0F);
/* 102 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/* 103 */     this.LegR = new ModelRenderer(this, 0, 20);
/* 104 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/* 105 */     this.LegR.func_78790_a(-2.3F, 0.0F, -2.0F, 4, 9, 4, 0.3F);
/* 106 */     this.ArmL = new ModelRenderer(this, 40, 35);
/* 107 */     this.ArmL.field_78809_i = true;
/* 108 */     this.ArmL.func_78793_a(5.0F, -1.0F, 0.0F);
/* 109 */     this.ArmL.func_78790_a(-1.0F, -1.5F, -1.4F, 3, 13, 3, 0.0F);
/* 110 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/* 111 */     this.LegL2.field_78809_i = true;
/* 112 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.LegL2.func_78790_a(-1.4F, 13.0F, -4.0F, 3, 2, 2, 0.0F);
/* 114 */     this.Neck = new ModelRenderer(this, 7, 16);
/* 115 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.Neck.func_78790_a(-2.0F, -1.3F, -0.8F, 4, 2, 2, 0.0F);
/* 117 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/* 118 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.NeckRing_1.func_78790_a(-9.7F, -2.0F, -2.9F, 2, 1, 7, 0.0F);
/* 120 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/* 121 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/* 122 */     this.NeckRing.func_78793_a(0.0F, -0.6F, -0.5F);
/* 123 */     this.NeckRing.func_78790_a(-3.5F, -2.0F, 7.9F, 7, 1, 2, 0.0F);
/* 124 */     setRotateAngle(this.NeckRing, 0.5359906F, 0.0F, 0.0F);
/* 125 */     this.ShoulderL = new ModelRenderer(this, 31, 10);
/* 126 */     this.ShoulderL.field_78809_i = true;
/* 127 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.ShoulderL.func_78790_a(-1.0F, -2.3F, -1.9F, 4, 4, 4, 0.0F);
/* 129 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/* 130 */     this.LegR2.field_78809_i = true;
/* 131 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.LegR2.func_78790_a(-1.6F, 13.0F, -4.0F, 3, 2, 2, 0.0F);
/* 133 */     this.ArmR = new ModelRenderer(this, 40, 35);
/* 134 */     this.ArmR.func_78793_a(-5.0F, -1.0F, 0.0F);
/* 135 */     this.ArmR.func_78790_a(-2.0F, -1.5F, -1.3F, 3, 13, 3, 0.0F);
/* 136 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/* 137 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 138 */     this.NeckRing_2.func_78790_a(-8.7F, -2.0F, -3.9F, 2, 1, 9, 0.0F);
/* 139 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/* 140 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/* 141 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 142 */     this.NeckRing_6.func_78790_a(-8.3F, -2.0F, -5.5F, 2, 1, 9, 0.0F);
/* 143 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/* 144 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/* 145 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 146 */     this.NeckRing_4.func_78790_a(-8.5F, -2.0F, -3.3F, 2, 1, 7, 0.0F);
/* 147 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/* 148 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/* 149 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 150 */     this.NeckRing_7.func_78790_a(-9.6F, -2.0F, -4.2F, 2, 1, 7, 0.0F);
/* 151 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/* 152 */     this.ShoulderR = new ModelRenderer(this, 31, 10);
/* 153 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 154 */     this.ShoulderR.func_78790_a(-2.8F, -2.3F, -1.7F, 4, 4, 4, 0.0F);
/* 155 */     this.Hair1.func_78792_a(this.Hair2);
/* 156 */     this.Hair4.func_78792_a(this.Hair5);
/* 157 */     this.LegR.func_78792_a(this.LegR3);
/* 158 */     this.Body1.func_78792_a(this.Boobs);
/* 159 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 160 */     this.LegL.func_78792_a(this.LegL4);
/* 161 */     this.Body1.func_78792_a(this.ClothF);
/* 162 */     this.Hair3.func_78792_a(this.Hair4);
/* 163 */     this.Body1.func_78792_a(this.Body2);
/* 164 */     this.Body2.func_78792_a(this.Body3);
/* 165 */     this.Body1.func_78792_a(this.ClothB);
/* 166 */     this.Hair2.func_78792_a(this.Hair3);
/* 167 */     this.Head.func_78792_a(this.Hair1);
/* 168 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 169 */     this.LegL.func_78792_a(this.LegL2);
/* 170 */     this.Body1.func_78792_a(this.Neck);
/* 171 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 172 */     this.Body1.func_78792_a(this.NeckRing);
/* 173 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 174 */     this.LegR.func_78792_a(this.LegR2);
/* 175 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 176 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 177 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 178 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 179 */     this.ArmR.func_78792_a(this.ShoulderR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 184 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 187 */     this.LegL.func_78785_a(f5);
/* 188 */     this.Head.func_78785_a(f5);
/* 189 */     this.ArmL.func_78785_a(f5);
/* 190 */     this.ArmR.func_78785_a(f5);
/* 191 */     this.Body1.func_78785_a(f5);
/* 192 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 197 */     modelRenderer.field_78795_f = x;
/* 198 */     modelRenderer.field_78796_g = y;
/* 199 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 203 */     int calc = par7Entity.field_70173_aa;
/* 204 */     if (calc > 100) calc -= 100; 
/* 205 */     float r = 360.0F;
/* 206 */     float r2 = 180.0F;
/* 207 */     float n4 = par4;
/* 208 */     float n5 = par5;
/*     */     
/* 210 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 211 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 212 */     float ex = par7Entity.field_70173_aa;
/* 213 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 214 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 216 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 217 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 244 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 246 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 255 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 256 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 257 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 258 */     this.LegR.field_78796_g = 0.0F;
/* 259 */     this.LegL.field_78796_g = 0.0F;
/* 260 */     this.ArmR.field_78796_g = 0.0F;
/* 261 */     this.ArmL.field_78796_g = 0.0F;
/* 262 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelVados.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */