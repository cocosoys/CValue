/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelAngelMohito
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer HairR1;
/*     */   public ModelRenderer HairL1;
/*     */   public ModelRenderer HairR2;
/*     */   public ModelRenderer HairR3;
/*     */   public ModelRenderer HairL2;
/*     */   public ModelRenderer HairL3;
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
/*     */   public ModelRenderer ShoulderArmorR;
/*     */   public ModelRenderer ShoulderArmorL;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   
/*     */   public ModelAngelMohito() {
/*  43 */     this.field_78090_t = 64;
/*  44 */     this.field_78089_u = 64;
/*  45 */     this.ArmL = new ModelRenderer(this, 50, 16);
/*  46 */     this.ArmL.field_78809_i = true;
/*  47 */     this.ArmL.func_78793_a(5.0F, -1.0F, 0.0F);
/*  48 */     this.ArmL.func_78790_a(-1.0F, -1.5F, -1.8F, 3, 13, 4, -0.1F);
/*  49 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  50 */     this.ArmR.func_78793_a(-5.0F, -1.0F, 0.0F);
/*  51 */     this.ArmR.func_78790_a(-2.0F, -1.5F, -1.8F, 3, 13, 4, -0.1F);
/*  52 */     this.Head = new ModelRenderer(this, 0, 0);
/*  53 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/*  54 */     this.Head.func_78790_a(-3.5F, -7.5F, -4.0F, 7, 8, 8, -0.4F);
/*  55 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  56 */     this.LegL.field_78809_i = true;
/*  57 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/*  58 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/*  59 */     this.ShoulderArmorR = new ModelRenderer(this, 35, 10);
/*  60 */     this.ShoulderArmorR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.ShoulderArmorR.func_78790_a(-4.0F, -2.0F, -1.8F, 5, 4, 4, 0.0F);
/*  62 */     this.Body3 = new ModelRenderer(this, 20, 37);
/*  63 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/*  65 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  66 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  67 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/*  68 */     this.HairL3 = new ModelRenderer(this, 0, 22);
/*  69 */     this.HairL3.field_78809_i = true;
/*  70 */     this.HairL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.HairL3.func_78790_a(0.7F, -7.1F, -3.9F, 3, 1, 8, 0.0F);
/*  72 */     setRotateAngle(this.HairL3, 0.0F, 0.0F, 0.00837758F);
/*  73 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/*  74 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.NeckRing_6.func_78790_a(-8.3F, -1.5F, -5.5F, 2, 1, 9, 0.0F);
/*  76 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/*  77 */     this.ClothF = new ModelRenderer(this, 44, 46);
/*  78 */     this.ClothF.func_78793_a(0.0F, 6.9F, -1.8F);
/*  79 */     this.ClothF.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/*  80 */     setRotateAngle(this.ClothF, -0.09424778F, 0.0F, 0.0F);
/*  81 */     this.ClothF2 = new ModelRenderer(this, 33, 46);
/*  82 */     this.ClothF2.func_78793_a(0.0F, 5.0F, 0.0F);
/*  83 */     this.ClothF2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/*  84 */     setRotateAngle(this.ClothF2, 0.04712389F, 0.0F, 0.0F);
/*  85 */     this.Neck = new ModelRenderer(this, 7, 17);
/*  86 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.Neck.func_78790_a(-2.0F, -1.1F, -0.8F, 4, 2, 2, 0.0F);
/*  88 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/*  89 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.NeckRing_5.func_78790_a(-8.3F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/*  91 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/*  92 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/*  93 */     this.LegL2.field_78809_i = true;
/*  94 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.LegL2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  96 */     this.HairR1 = new ModelRenderer(this, 31, 0);
/*  97 */     this.HairR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.HairR1.func_78790_a(-4.6F, -7.1F, -4.0F, 2, 6, 4, 0.0F);
/*  99 */     setRotateAngle(this.HairR1, 0.0F, 0.0F, 0.090757124F);
/* 100 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/* 101 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.NeckRing_3.func_78790_a(-8.7F, -1.5F, -3.2F, 2, 1, 7, 0.0F);
/* 103 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/* 104 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/* 105 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 106 */     this.NeckRing_1.func_78790_a(-9.7F, -1.5F, -2.9F, 2, 1, 7, 0.0F);
/* 107 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/* 108 */     this.HairR3 = new ModelRenderer(this, 0, 22);
/* 109 */     this.HairR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.HairR3.func_78790_a(-3.6F, -7.1F, -3.9F, 3, 1, 8, 0.0F);
/* 111 */     setRotateAngle(this.HairR3, 0.0F, 0.0F, -0.00837758F);
/* 112 */     this.HairL1 = new ModelRenderer(this, 31, 0);
/* 113 */     this.HairL1.field_78809_i = true;
/* 114 */     this.HairL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 115 */     this.HairL1.func_78790_a(2.7F, -7.1F, -4.0F, 2, 6, 4, 0.0F);
/* 116 */     setRotateAngle(this.HairL1, 0.0F, 0.0F, -0.090757124F);
/* 117 */     this.Body2 = new ModelRenderer(this, 23, 31);
/* 118 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 2, 3, 0.0F);
/* 120 */     this.ClothB2 = new ModelRenderer(this, 33, 46);
/* 121 */     this.ClothB2.func_78793_a(0.0F, 5.0F, 0.0F);
/* 122 */     this.ClothB2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/* 123 */     setRotateAngle(this.ClothB2, -0.006981317F, 0.0F, 0.0F);
/* 124 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/* 125 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.NeckRing_2.func_78790_a(-8.7F, -1.5F, -3.9F, 2, 1, 9, 0.0F);
/* 127 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/* 128 */     this.HairR2 = new ModelRenderer(this, 46, 0);
/* 129 */     this.HairR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.HairR2.func_78790_a(-4.3F, -6.9F, -0.8F, 4, 5, 5, 0.0F);
/* 131 */     this.LegR = new ModelRenderer(this, 0, 33);
/* 132 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/* 133 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/* 134 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/* 135 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 136 */     this.NeckRing_7.func_78790_a(-9.6F, -1.5F, -4.2F, 2, 1, 7, 0.0F);
/* 137 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/* 138 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/* 139 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.NeckRing_4.func_78790_a(-8.5F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/* 141 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/* 142 */     this.ShoulderArmorL = new ModelRenderer(this, 35, 10);
/* 143 */     this.ShoulderArmorL.field_78809_i = true;
/* 144 */     this.ShoulderArmorL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 145 */     this.ShoulderArmorL.func_78790_a(-1.0F, -2.0F, -1.8F, 5, 4, 4, 0.0F);
/* 146 */     this.ClothB = new ModelRenderer(this, 44, 46);
/* 147 */     this.ClothB.func_78793_a(0.0F, 7.0F, 2.2F);
/* 148 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/* 149 */     setRotateAngle(this.ClothB, 0.054105207F, 0.0F, 0.0F);
/* 150 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/* 151 */     this.LegR2.field_78809_i = true;
/* 152 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 153 */     this.LegR2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/* 154 */     this.HairL2 = new ModelRenderer(this, 46, 0);
/* 155 */     this.HairL2.field_78809_i = true;
/* 156 */     this.HairL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 157 */     this.HairL2.func_78790_a(0.4F, -6.9F, -0.8F, 4, 5, 5, 0.0F);
/* 158 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/* 159 */     this.NeckRing.func_78793_a(0.0F, -1.0F, 0.0F);
/* 160 */     this.NeckRing.func_78790_a(-3.5F, -1.5F, 7.9F, 7, 1, 2, 0.0F);
/* 161 */     setRotateAngle(this.NeckRing, 0.53249997F, 0.0F, 0.0F);
/* 162 */     this.ArmR.func_78792_a(this.ShoulderArmorR);
/* 163 */     this.Body2.func_78792_a(this.Body3);
/* 164 */     this.HairL1.func_78792_a(this.HairL3);
/* 165 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 166 */     this.Body3.func_78792_a(this.ClothF);
/* 167 */     this.ClothF.func_78792_a(this.ClothF2);
/* 168 */     this.Body1.func_78792_a(this.Neck);
/* 169 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 170 */     this.LegL.func_78792_a(this.LegL2);
/* 171 */     this.Head.func_78792_a(this.HairR1);
/* 172 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 173 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 174 */     this.HairR1.func_78792_a(this.HairR3);
/* 175 */     this.Head.func_78792_a(this.HairL1);
/* 176 */     this.Body1.func_78792_a(this.Body2);
/* 177 */     this.ClothB.func_78792_a(this.ClothB2);
/* 178 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 179 */     this.HairR1.func_78792_a(this.HairR2);
/* 180 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 181 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 182 */     this.ArmL.func_78792_a(this.ShoulderArmorL);
/* 183 */     this.Body3.func_78792_a(this.ClothB);
/* 184 */     this.LegR.func_78792_a(this.LegR2);
/* 185 */     this.HairL1.func_78792_a(this.HairL2);
/* 186 */     this.Body1.func_78792_a(this.NeckRing);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 191 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 194 */     this.LegL.func_78785_a(f5);
/* 195 */     this.Head.func_78785_a(f5);
/* 196 */     this.ArmL.func_78785_a(f5);
/* 197 */     this.ArmR.func_78785_a(f5);
/* 198 */     this.Body1.func_78785_a(f5);
/* 199 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 204 */     modelRenderer.field_78795_f = x;
/* 205 */     modelRenderer.field_78796_g = y;
/* 206 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 210 */     int calc = par7Entity.field_70173_aa;
/* 211 */     if (calc > 100) calc -= 100; 
/* 212 */     float r = 360.0F;
/* 213 */     float r2 = 180.0F;
/* 214 */     float n4 = par4;
/* 215 */     float n5 = par5;
/*     */     
/* 217 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 218 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 219 */     float ex = par7Entity.field_70173_aa;
/* 220 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 221 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 223 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 224 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 266 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 267 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 268 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 269 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 271 */     this.LegR.field_78796_g = 0.0F;
/* 272 */     this.LegL.field_78796_g = 0.0F;
/* 273 */     this.ArmR.field_78796_g = 0.0F;
/* 274 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 277 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 278 */     this.ClothF2.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 279 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 280 */     this.ClothB2.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 281 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelMohito.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */