/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelAngelSour
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer HairL;
/*     */   public ModelRenderer HairR;
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
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer ShoulderArmorL;
/*     */   public ModelRenderer ShoulderArmorR;
/*     */   
/*     */   public ModelAngelSour() {
/*  40 */     this.field_78090_t = 64;
/*  41 */     this.field_78089_u = 64;
/*  42 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  43 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  44 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/*  45 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/*  46 */     this.LegR2.field_78809_i = true;
/*  47 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.LegR2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  49 */     this.Neck = new ModelRenderer(this, 2, 20);
/*  50 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.Neck.func_78790_a(-2.0F, -1.1F, -0.8F, 4, 2, 2, 0.0F);
/*  52 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/*  53 */     this.NeckRing.func_78793_a(0.0F, -1.0F, 0.0F);
/*  54 */     this.NeckRing.func_78790_a(-3.5F, -1.5F, 7.9F, 7, 1, 2, 0.0F);
/*  55 */     setRotateAngle(this.NeckRing, 0.53249997F, 0.0F, 0.0F);
/*  56 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/*  57 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.NeckRing_7.func_78790_a(-9.6F, -1.5F, -4.2F, 2, 1, 7, 0.0F);
/*  59 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/*  60 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  61 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/*  62 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/*  63 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/*  64 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.NeckRing_6.func_78790_a(-8.3F, -1.5F, -5.5F, 2, 1, 9, 0.0F);
/*  66 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/*  67 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/*  68 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.NeckRing_2.func_78790_a(-8.7F, -1.5F, -3.9F, 2, 1, 9, 0.0F);
/*  70 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/*  71 */     this.ArmL = new ModelRenderer(this, 50, 16);
/*  72 */     this.ArmL.field_78809_i = true;
/*  73 */     this.ArmL.func_78793_a(5.0F, -1.0F, 0.0F);
/*  74 */     this.ArmL.func_78790_a(-1.0F, -1.6F, -1.8F, 3, 13, 4, -0.1F);
/*  75 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/*  76 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.NeckRing_4.func_78790_a(-8.5F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/*  78 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/*  79 */     this.ShoulderArmorR = new ModelRenderer(this, 35, 9);
/*  80 */     this.ShoulderArmorR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.ShoulderArmorR.func_78790_a(-4.0F, -2.0F, -1.8F, 5, 4, 4, 0.0F);
/*  82 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/*  83 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.NeckRing_3.func_78790_a(-8.7F, -1.5F, -3.2F, 2, 1, 7, 0.0F);
/*  85 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/*  86 */     this.Body3 = new ModelRenderer(this, 20, 37);
/*  87 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/*  89 */     this.HairL = new ModelRenderer(this, 54, 0);
/*  90 */     this.HairL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.HairL.func_78790_a(2.4F, 0.3F, -1.0F, 2, 2, 2, 0.0F);
/*  92 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/*  93 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.NeckRing_1.func_78790_a(-9.7F, -1.5F, -2.9F, 2, 1, 7, 0.0F);
/*  95 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/*  96 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  97 */     this.ArmR.func_78793_a(-5.0F, -1.0F, 0.0F);
/*  98 */     this.ArmR.func_78790_a(-2.0F, -1.6F, -1.8F, 3, 13, 4, -0.1F);
/*  99 */     this.ShoulderArmorL = new ModelRenderer(this, 35, 9);
/* 100 */     this.ShoulderArmorL.field_78809_i = true;
/* 101 */     this.ShoulderArmorL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.ShoulderArmorL.func_78790_a(-1.0F, -2.0F, -1.8F, 5, 4, 4, 0.0F);
/* 103 */     this.LegL = new ModelRenderer(this, 0, 33);
/* 104 */     this.LegL.field_78809_i = true;
/* 105 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/* 106 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/* 107 */     this.Hair1 = new ModelRenderer(this, 32, 0);
/* 108 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.Hair1.func_78790_a(-3.5F, -2.9F, -0.2F, 7, 5, 4, 0.0F);
/* 110 */     this.ClothB = new ModelRenderer(this, 44, 46);
/* 111 */     this.ClothB.func_78793_a(0.0F, 7.0F, 2.2F);
/* 112 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/* 113 */     setRotateAngle(this.ClothB, 0.054105207F, 0.0F, 0.0F);
/* 114 */     this.HairR = new ModelRenderer(this, 54, 0);
/* 115 */     this.HairR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.HairR.func_78790_a(-4.4F, 0.3F, -1.0F, 2, 2, 2, 0.0F);
/* 117 */     this.ClothB2 = new ModelRenderer(this, 33, 46);
/* 118 */     this.ClothB2.func_78793_a(0.0F, 5.0F, 0.0F);
/* 119 */     this.ClothB2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/* 120 */     setRotateAngle(this.ClothB2, -0.006981317F, 0.0F, 0.0F);
/* 121 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/* 122 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.NeckRing_5.func_78790_a(-8.3F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/* 124 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/* 125 */     this.ClothF2 = new ModelRenderer(this, 33, 46);
/* 126 */     this.ClothF2.func_78793_a(0.0F, 5.0F, 0.0F);
/* 127 */     this.ClothF2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/* 128 */     setRotateAngle(this.ClothF2, 0.04712389F, 0.0F, 0.0F);
/* 129 */     this.ClothF = new ModelRenderer(this, 44, 46);
/* 130 */     this.ClothF.func_78793_a(0.0F, 6.9F, -1.8F);
/* 131 */     this.ClothF.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/* 132 */     setRotateAngle(this.ClothF, -0.09424778F, 0.0F, 0.0F);
/* 133 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/* 134 */     this.LegL2.field_78809_i = true;
/* 135 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 136 */     this.LegL2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/* 137 */     this.Head = new ModelRenderer(this, 0, 0);
/* 138 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/* 139 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 9, 8, -0.8F);
/* 140 */     this.Body2 = new ModelRenderer(this, 23, 31);
/* 141 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 142 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 2, 3, 0.0F);
/* 143 */     this.LegR.func_78792_a(this.LegR2);
/* 144 */     this.Body1.func_78792_a(this.Neck);
/* 145 */     this.Body1.func_78792_a(this.NeckRing);
/* 146 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 147 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 148 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 149 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 150 */     this.ArmR.func_78792_a(this.ShoulderArmorR);
/* 151 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 152 */     this.Body2.func_78792_a(this.Body3);
/* 153 */     this.Hair1.func_78792_a(this.HairL);
/* 154 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 155 */     this.ArmL.func_78792_a(this.ShoulderArmorL);
/* 156 */     this.Head.func_78792_a(this.Hair1);
/* 157 */     this.Body3.func_78792_a(this.ClothB);
/* 158 */     this.Hair1.func_78792_a(this.HairR);
/* 159 */     this.ClothB.func_78792_a(this.ClothB2);
/* 160 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 161 */     this.ClothF.func_78792_a(this.ClothF2);
/* 162 */     this.Body3.func_78792_a(this.ClothF);
/* 163 */     this.LegL.func_78792_a(this.LegL2);
/* 164 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 169 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 172 */     this.LegL.func_78785_a(f5);
/* 173 */     this.Head.func_78785_a(f5);
/* 174 */     this.ArmL.func_78785_a(f5);
/* 175 */     this.ArmR.func_78785_a(f5);
/* 176 */     this.Body1.func_78785_a(f5);
/* 177 */     this.LegR.func_78785_a(f5);
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
/* 195 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 196 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
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
/* 244 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 245 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 246 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 247 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 249 */     this.LegR.field_78796_g = 0.0F;
/* 250 */     this.LegL.field_78796_g = 0.0F;
/* 251 */     this.ArmR.field_78796_g = 0.0F;
/* 252 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 255 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 256 */     this.ClothF2.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 257 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 258 */     this.ClothB2.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 259 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelSour.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */