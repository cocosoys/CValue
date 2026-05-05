/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelAngelCognac
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
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer NeckRing;
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
/*     */   public ModelRenderer ClothF2;
/*     */   public ModelRenderer ClothB2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer ShoulderArmorR;
/*     */   public ModelRenderer ShoulderArmorL;
/*     */   
/*     */   public ModelAngelCognac() {
/*  41 */     this.field_78090_t = 64;
/*  42 */     this.field_78089_u = 64;
/*  43 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/*  44 */     this.LegL2.field_78809_i = true;
/*  45 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.LegL2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  47 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  48 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  49 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/*  50 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  51 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/*  52 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/*  53 */     this.Hair4 = new ModelRenderer(this, 54, 7);
/*  54 */     this.Hair4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.Hair4.func_78790_a(-2.0F, -8.5F, -10.0F, 2, 5, 3, 0.0F);
/*  56 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/*  57 */     this.LegR2.field_78809_i = true;
/*  58 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.LegR2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  60 */     this.Hair1 = new ModelRenderer(this, 31, 0);
/*  61 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Hair1.func_78790_a(-2.5F, -10.7F, -4.0F, 5, 4, 4, 0.0F);
/*  63 */     this.ArmL = new ModelRenderer(this, 50, 16);
/*  64 */     this.ArmL.field_78809_i = true;
/*  65 */     this.ArmL.func_78793_a(5.0F, -1.3F, 0.0F);
/*  66 */     this.ArmL.func_78790_a(-1.0F, -1.5F, -1.8F, 3, 13, 4, -0.1F);
/*  67 */     this.ClothF = new ModelRenderer(this, 44, 46);
/*  68 */     this.ClothF.func_78793_a(0.0F, 6.9F, -1.8F);
/*  69 */     this.ClothF.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/*  70 */     setRotateAngle(this.ClothF, -0.09599311F, 0.0F, 0.0F);
/*  71 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/*  72 */     this.NeckRing.func_78793_a(0.0F, -0.8F, 1.1F);
/*  73 */     this.NeckRing.func_78790_a(-3.5F, -1.5F, 7.9F, 7, 1, 2, 0.0F);
/*  74 */     setRotateAngle(this.NeckRing, 0.42428955F, 0.0F, 0.0F);
/*  75 */     this.ClothF2 = new ModelRenderer(this, 33, 47);
/*  76 */     this.ClothF2.func_78793_a(0.0F, 4.9F, 0.0F);
/*  77 */     this.ClothF2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 10, 0, 0.0F);
/*  78 */     setRotateAngle(this.ClothF2, 0.04363323F, 0.0F, 0.0F);
/*  79 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/*  80 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.NeckRing_7.func_78790_a(-9.6F, -1.5F, -4.2F, 2, 1, 7, 0.0F);
/*  82 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/*  83 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/*  84 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.NeckRing_3.func_78790_a(-8.7F, -1.5F, -3.2F, 2, 1, 7, 0.0F);
/*  86 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/*  87 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/*  88 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.NeckRing_4.func_78790_a(-8.5F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/*  90 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/*  91 */     this.ShoulderArmorR = new ModelRenderer(this, 35, 9);
/*  92 */     this.ShoulderArmorR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  93 */     this.ShoulderArmorR.func_78790_a(-4.0F, -1.7F, -1.8F, 5, 4, 4, 0.0F);
/*  94 */     this.Neck = new ModelRenderer(this, 7, 17);
/*  95 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.Neck.func_78790_a(-2.0F, -1.3F, -0.8F, 4, 2, 2, 0.0F);
/*  97 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  98 */     this.LegL.field_78809_i = true;
/*  99 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/* 100 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/* 101 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/* 102 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.NeckRing_5.func_78790_a(-8.3F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/* 104 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/* 105 */     this.ArmR = new ModelRenderer(this, 50, 16);
/* 106 */     this.ArmR.func_78793_a(-5.0F, -1.3F, 0.0F);
/* 107 */     this.ArmR.func_78790_a(-2.0F, -1.5F, -1.8F, 3, 13, 4, -0.1F);
/* 108 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/* 109 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.NeckRing_1.func_78790_a(-9.7F, -1.5F, -2.9F, 2, 1, 7, 0.0F);
/* 111 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/* 112 */     this.Body3 = new ModelRenderer(this, 20, 37);
/* 113 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 114 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/* 115 */     this.Hair2 = new ModelRenderer(this, 30, 0);
/* 116 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.Hair2.func_78790_a(-2.3F, -11.1F, -7.2F, 4, 3, 6, 0.0F);
/* 118 */     this.Body2 = new ModelRenderer(this, 23, 31);
/* 119 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 120 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 2, 3, 0.0F);
/* 121 */     this.Head = new ModelRenderer(this, 0, 0);
/* 122 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/* 123 */     this.Head.func_78790_a(-3.5F, -7.5F, -4.0F, 7, 8, 8, -0.4F);
/* 124 */     this.Hair3 = new ModelRenderer(this, 50, 0);
/* 125 */     this.Hair3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.Hair3.func_78790_a(-2.2F, -10.4F, -9.2F, 3, 3, 4, 0.0F);
/* 127 */     this.ShoulderArmorL = new ModelRenderer(this, 35, 9);
/* 128 */     this.ShoulderArmorL.field_78809_i = true;
/* 129 */     this.ShoulderArmorL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.ShoulderArmorL.func_78790_a(-1.0F, -1.7F, -1.8F, 5, 4, 4, 0.0F);
/* 131 */     this.ClothB = new ModelRenderer(this, 44, 46);
/* 132 */     this.ClothB.func_78793_a(0.0F, 7.0F, 2.2F);
/* 133 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/* 134 */     setRotateAngle(this.ClothB, 0.054105207F, 0.0F, 0.0F);
/* 135 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/* 136 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.NeckRing_6.func_78790_a(-8.3F, -1.5F, -5.5F, 2, 1, 9, 0.0F);
/* 138 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/* 139 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/* 140 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 141 */     this.NeckRing_2.func_78790_a(-8.7F, -1.5F, -3.9F, 2, 1, 9, 0.0F);
/* 142 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/* 143 */     this.ClothB2 = new ModelRenderer(this, 33, 47);
/* 144 */     this.ClothB2.func_78793_a(0.0F, 5.0F, 0.0F);
/* 145 */     this.ClothB2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 10, 0, 0.0F);
/* 146 */     setRotateAngle(this.ClothB2, -0.006981317F, 0.0F, 0.0F);
/* 147 */     this.LegL.func_78792_a(this.LegL2);
/* 148 */     this.Hair3.func_78792_a(this.Hair4);
/* 149 */     this.LegR.func_78792_a(this.LegR2);
/* 150 */     this.Head.func_78792_a(this.Hair1);
/* 151 */     this.Body1.func_78792_a(this.ClothF);
/* 152 */     this.Body1.func_78792_a(this.NeckRing);
/* 153 */     this.ClothF.func_78792_a(this.ClothF2);
/* 154 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 155 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 156 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 157 */     this.ArmR.func_78792_a(this.ShoulderArmorR);
/* 158 */     this.Body1.func_78792_a(this.Neck);
/* 159 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 160 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 161 */     this.Body2.func_78792_a(this.Body3);
/* 162 */     this.Hair1.func_78792_a(this.Hair2);
/* 163 */     this.Body1.func_78792_a(this.Body2);
/* 164 */     this.Hair2.func_78792_a(this.Hair3);
/* 165 */     this.ArmL.func_78792_a(this.ShoulderArmorL);
/* 166 */     this.Body1.func_78792_a(this.ClothB);
/* 167 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 168 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 169 */     this.ClothB.func_78792_a(this.ClothB2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 174 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 177 */     this.LegL.func_78785_a(f5);
/* 178 */     this.Head.func_78785_a(f5);
/* 179 */     this.ArmL.func_78785_a(f5);
/* 180 */     this.ArmR.func_78785_a(f5);
/* 181 */     this.Body1.func_78785_a(f5);
/* 182 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 187 */     modelRenderer.field_78795_f = x;
/* 188 */     modelRenderer.field_78796_g = y;
/* 189 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 193 */     int calc = par7Entity.field_70173_aa;
/* 194 */     if (calc > 100) calc -= 100; 
/* 195 */     float r = 360.0F;
/* 196 */     float r2 = 180.0F;
/* 197 */     float n4 = par4;
/* 198 */     float n5 = par5;
/*     */     
/* 200 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 201 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 202 */     float ex = par7Entity.field_70173_aa;
/* 203 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 204 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 206 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 207 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 249 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 250 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 251 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 252 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 254 */     this.LegR.field_78796_g = 0.0F;
/* 255 */     this.LegL.field_78796_g = 0.0F;
/* 256 */     this.ArmR.field_78796_g = 0.0F;
/* 257 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 260 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 261 */     this.ClothF2.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 262 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 263 */     this.ClothB2.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 264 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelCognac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */