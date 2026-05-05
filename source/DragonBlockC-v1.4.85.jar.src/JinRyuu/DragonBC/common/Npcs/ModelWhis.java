/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelWhis
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer ShoulderArmorL;
/*     */   public ModelRenderer ShoulderArmorR;
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
/*     */   
/*     */   public ModelWhis() {
/*  39 */     this.field_78090_t = 64;
/*  40 */     this.field_78089_u = 64;
/*  41 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/*  42 */     this.LegL2.field_78809_i = true;
/*  43 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.LegL2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  45 */     this.ClothB = new ModelRenderer(this, 44, 46);
/*  46 */     this.ClothB.func_78793_a(0.0F, 7.0F, 2.2F);
/*  47 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 5, 0, 0.0F);
/*  48 */     setRotateAngle(this.ClothB, 0.054105207F, 0.0F, 0.0F);
/*  49 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/*  50 */     this.LegR2.field_78809_i = true;
/*  51 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.LegR2.func_78790_a(-2.0F, 13.1F, -4.0F, 4, 2, 2, 0.0F);
/*  53 */     this.Body3 = new ModelRenderer(this, 20, 37);
/*  54 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/*  56 */     this.ShoulderArmorR = new ModelRenderer(this, 35, 9);
/*  57 */     this.ShoulderArmorR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.ShoulderArmorR.func_78790_a(-8.0F, 0.0F, -1.8F, 4, 3, 4, 0.0F);
/*  59 */     this.ClothF2 = new ModelRenderer(this, 33, 46);
/*  60 */     this.ClothF2.func_78793_a(0.0F, 5.0F, -0.2F);
/*  61 */     this.ClothF2.func_78790_a(-2.5F, 0.0F, 0.1F, 5, 11, 0, 0.0F);
/*  62 */     setRotateAngle(this.ClothF2, 0.04712389F, 0.0F, 0.0F);
/*  63 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/*  64 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.NeckRing_4.func_78790_a(-8.5F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/*  66 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/*  67 */     this.ArmL = new ModelRenderer(this, 50, 16);
/*  68 */     this.ArmL.field_78809_i = true;
/*  69 */     this.ArmL.func_78793_a(4.9F, -1.4F, 0.0F);
/*  70 */     this.ArmL.func_78790_a(-1.0F, -1.6F, -1.8F, 3, 13, 4, -0.1F);
/*  71 */     this.Neck = new ModelRenderer(this, 7, 17);
/*  72 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.Neck.func_78790_a(-2.0F, -1.1F, -0.8F, 4, 2, 2, 0.0F);
/*  74 */     this.Body2 = new ModelRenderer(this, 23, 31);
/*  75 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.5F, 7, 2, 3, 0.0F);
/*  77 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/*  78 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.NeckRing_1.func_78790_a(-9.7F, -1.5F, -2.9F, 2, 1, 7, 0.0F);
/*  80 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/*  81 */     this.Head = new ModelRenderer(this, 0, 0);
/*  82 */     this.Head.func_78793_a(0.0F, -3.7F, 0.0F);
/*  83 */     this.Head.func_78790_a(-3.5F, -7.5F, -4.0F, 7, 8, 8, -0.4F);
/*  84 */     this.ClothB2 = new ModelRenderer(this, 33, 46);
/*  85 */     this.ClothB2.func_78793_a(0.0F, 5.0F, 0.0F);
/*  86 */     this.ClothB2.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/*  87 */     setRotateAngle(this.ClothB2, -0.006981317F, 0.0F, 0.0F);
/*  88 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  89 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  90 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/*  91 */     this.Hair1 = new ModelRenderer(this, 31, 0);
/*  92 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  93 */     this.Hair1.func_78790_a(-2.5F, -11.8F, -4.0F, 5, 5, 4, 0.0F);
/*  94 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/*  95 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.NeckRing_7.func_78790_a(-9.6F, -1.5F, -4.2F, 2, 1, 7, 0.0F);
/*  97 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/*  98 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/*  99 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.NeckRing_3.func_78790_a(-8.7F, -1.5F, -3.2F, 2, 1, 7, 0.0F);
/* 101 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/* 102 */     this.ShoulderArmorL = new ModelRenderer(this, 35, 9);
/* 103 */     this.ShoulderArmorL.field_78809_i = true;
/* 104 */     this.ShoulderArmorL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 105 */     this.ShoulderArmorL.func_78790_a(4.0F, 0.0F, -1.8F, 4, 3, 4, 0.0F);
/* 106 */     this.Hair2 = new ModelRenderer(this, 50, 0);
/* 107 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.Hair2.func_78790_a(-1.6F, -12.8F, -2.9F, 3, 1, 4, 0.0F);
/* 109 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/* 110 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.NeckRing_5.func_78790_a(-8.3F, -1.5F, -3.3F, 2, 1, 7, 0.0F);
/* 112 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/* 113 */     this.LegR = new ModelRenderer(this, 0, 33);
/* 114 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/* 115 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/* 116 */     this.LegL = new ModelRenderer(this, 0, 33);
/* 117 */     this.LegL.field_78809_i = true;
/* 118 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/* 119 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/* 120 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/* 121 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 122 */     this.NeckRing_2.func_78790_a(-8.7F, -1.5F, -3.9F, 2, 1, 9, 0.0F);
/* 123 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/* 124 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/* 125 */     this.NeckRing.func_78793_a(0.0F, -1.0F, 0.0F);
/* 126 */     this.NeckRing.func_78790_a(-3.5F, -1.5F, 7.9F, 7, 1, 2, 0.0F);
/* 127 */     setRotateAngle(this.NeckRing, 0.53249997F, 0.0F, 0.0F);
/* 128 */     this.ClothF = new ModelRenderer(this, 44, 46);
/* 129 */     this.ClothF.func_78793_a(0.0F, 6.9F, -1.8F);
/* 130 */     this.ClothF.func_78790_a(-2.5F, 0.0F, -0.1F, 5, 5, 0, 0.0F);
/* 131 */     setRotateAngle(this.ClothF, -0.09424778F, 0.0F, 0.0F);
/* 132 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/* 133 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.NeckRing_6.func_78790_a(-8.3F, -1.5F, -5.5F, 2, 1, 9, 0.0F);
/* 135 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/* 136 */     this.ArmR = new ModelRenderer(this, 50, 16);
/* 137 */     this.ArmR.func_78793_a(-5.2F, -1.4F, 0.0F);
/* 138 */     this.ArmR.func_78790_a(-1.7F, -1.6F, -1.8F, 3, 13, 4, -0.1F);
/* 139 */     this.LegL.func_78792_a(this.LegL2);
/* 140 */     this.Body3.func_78792_a(this.ClothB);
/* 141 */     this.LegR.func_78792_a(this.LegR2);
/* 142 */     this.Body2.func_78792_a(this.Body3);
/* 143 */     this.Body1.func_78792_a(this.ShoulderArmorR);
/* 144 */     this.ClothF.func_78792_a(this.ClothF2);
/* 145 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 146 */     this.Body1.func_78792_a(this.Neck);
/* 147 */     this.Body1.func_78792_a(this.Body2);
/* 148 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 149 */     this.ClothB.func_78792_a(this.ClothB2);
/* 150 */     this.Head.func_78792_a(this.Hair1);
/* 151 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 152 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 153 */     this.Body1.func_78792_a(this.ShoulderArmorL);
/* 154 */     this.Hair1.func_78792_a(this.Hair2);
/* 155 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 156 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 157 */     this.Body1.func_78792_a(this.NeckRing);
/* 158 */     this.Body3.func_78792_a(this.ClothF);
/* 159 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 164 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 167 */     this.LegL.func_78785_a(f5);
/* 168 */     this.Head.func_78785_a(f5);
/* 169 */     this.ArmL.func_78785_a(f5);
/* 170 */     this.ArmR.func_78785_a(f5);
/* 171 */     this.Body1.func_78785_a(f5);
/* 172 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 177 */     modelRenderer.field_78795_f = x;
/* 178 */     modelRenderer.field_78796_g = y;
/* 179 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 183 */     int calc = par7Entity.field_70173_aa;
/* 184 */     if (calc > 100) calc -= 100; 
/* 185 */     float r = 360.0F;
/* 186 */     float r2 = 180.0F;
/* 187 */     float n4 = par4;
/* 188 */     float n5 = par5;
/*     */     
/* 190 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 191 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 192 */     float ex = par7Entity.field_70173_aa;
/* 193 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 194 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 196 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 197 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 239 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 240 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 241 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 242 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 244 */     this.LegR.field_78796_g = 0.0F;
/* 245 */     this.LegL.field_78796_g = 0.0F;
/* 246 */     this.ArmR.field_78796_g = 0.0F;
/* 247 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 250 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 251 */     this.ClothF2.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 252 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 253 */     this.ClothB2.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 254 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelWhis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */