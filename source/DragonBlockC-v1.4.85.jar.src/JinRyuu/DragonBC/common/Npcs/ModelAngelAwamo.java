/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelAngelAwamo
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer NeckRing;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer ClothB;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderArmorR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer ShoulderArmorL;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   public ModelRenderer NeckRing_1;
/*     */   public ModelRenderer NeckRing_2;
/*     */   public ModelRenderer NeckRing_3;
/*     */   public ModelRenderer NeckRing_4;
/*     */   public ModelRenderer NeckRing_5;
/*     */   public ModelRenderer NeckRing_6;
/*     */   public ModelRenderer NeckRing_7;
/*     */   
/*     */   public ModelAngelAwamo() {
/*  42 */     this.field_78090_t = 128;
/*  43 */     this.field_78089_u = 64;
/*  44 */     this.Hair1 = new ModelRenderer(this, 30, 0);
/*  45 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Hair1.func_78790_a(-2.5F, -8.2F, -3.2F, 5, 2, 4, 0.0F);
/*  47 */     this.Body3 = new ModelRenderer(this, 29, 36);
/*  48 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.Body3.func_78790_a(-5.9F, 10.1F, -4.1F, 12, 3, 8, 0.0F);
/*  50 */     this.LegL3 = new ModelRenderer(this, 17, 41);
/*  51 */     this.LegL3.field_78809_i = true;
/*  52 */     this.LegL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.LegL3.func_78790_a(-1.3F, 10.0F, -4.0F, 3, 2, 2, 0.0F);
/*  54 */     this.Hair2 = new ModelRenderer(this, 49, 0);
/*  55 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.Hair2.func_78790_a(-2.0F, -9.6F, -3.5F, 3, 2, 3, 0.0F);
/*  57 */     this.LegR = new ModelRenderer(this, 0, 42);
/*  58 */     this.LegR.func_78793_a(-2.6F, 12.0F, 0.0F);
/*  59 */     this.LegR.func_78790_a(-1.5F, 6.0F, -2.0F, 3, 6, 4, 0.0F);
/*  60 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/*  61 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.NeckRing_2.func_78790_a(-8.7F, -3.0F, -3.9F, 2, 1, 9, 0.0F);
/*  63 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/*  64 */     this.ArmL = new ModelRenderer(this, 82, 21);
/*  65 */     this.ArmL.field_78809_i = true;
/*  66 */     this.ArmL.func_78793_a(6.2F, 1.5F, -0.2F);
/*  67 */     this.ArmL.func_78790_a(-0.9F, -1.7F, -1.8F, 3, 11, 4, 0.0F);
/*  68 */     this.Head = new ModelRenderer(this, 0, 0);
/*  69 */     this.Head.func_78793_a(0.0F, -0.8F, 0.0F);
/*  70 */     this.Head.func_78790_a(-4.0F, -6.7F, -4.0F, 8, 7, 8, -0.4F);
/*  71 */     this.LegL = new ModelRenderer(this, 0, 42);
/*  72 */     this.LegL.field_78809_i = true;
/*  73 */     this.LegL.func_78793_a(2.4F, 12.0F, 0.0F);
/*  74 */     this.LegL.func_78790_a(-1.3F, 6.0F, -2.0F, 3, 6, 4, 0.0F);
/*  75 */     this.ShoulderL = new ModelRenderer(this, 81, 12);
/*  76 */     this.ShoulderL.field_78809_i = true;
/*  77 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.ShoulderL.func_78790_a(-1.2F, -2.1F, -1.9F, 4, 4, 4, 0.0F);
/*  79 */     this.LegR3 = new ModelRenderer(this, 17, 41);
/*  80 */     this.LegR3.field_78809_i = true;
/*  81 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.LegR3.func_78790_a(-1.5F, 10.0F, -4.0F, 3, 2, 2, 0.0F);
/*  83 */     this.Hair4 = new ModelRenderer(this, 71, 0);
/*  84 */     this.Hair4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.Hair4.func_78790_a(-0.3F, -12.0F, -4.5F, 1, 1, 2, 0.0F);
/*  86 */     this.ShoulderR = new ModelRenderer(this, 81, 12);
/*  87 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.ShoulderR.func_78790_a(-2.8F, -2.1F, -1.7F, 4, 4, 4, 0.0F);
/*  89 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/*  90 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.NeckRing_1.func_78790_a(-9.7F, -3.0F, -2.9F, 2, 1, 7, 0.0F);
/*  92 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/*  93 */     this.Body1 = new ModelRenderer(this, 32, 9);
/*  94 */     this.Body1.func_78793_a(0.0F, -1.0F, 0.0F);
/*  95 */     this.Body1.func_78790_a(-5.0F, 0.1F, -3.7F, 10, 5, 7, 0.0F);
/*  96 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/*  97 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.NeckRing_6.func_78790_a(-8.3F, -3.0F, -5.5F, 2, 1, 9, 0.0F);
/*  99 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/* 100 */     this.Body2 = new ModelRenderer(this, 30, 22);
/* 101 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.Body2.func_78790_a(-5.5F, 5.1F, -4.2F, 11, 5, 8, 0.0F);
/* 103 */     this.ArmR = new ModelRenderer(this, 82, 21);
/* 104 */     this.ArmR.func_78793_a(-6.2F, 1.5F, -0.2F);
/* 105 */     this.ArmR.func_78790_a(-2.1F, -1.7F, -1.8F, 3, 11, 4, 0.0F);
/* 106 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/* 107 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.NeckRing_3.func_78790_a(-8.7F, -3.0F, -3.2F, 2, 1, 7, 0.0F);
/* 109 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/* 110 */     this.ShoulderArmorR = new ModelRenderer(this, 78, 3);
/* 111 */     this.ShoulderArmorR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.ShoulderArmorR.func_78790_a(-3.7F, -2.5F, -3.0F, 5, 2, 6, 0.0F);
/* 113 */     setRotateAngle(this.ShoulderArmorR, 0.0F, 0.0F, 0.1134464F);
/* 114 */     this.LegR2 = new ModelRenderer(this, 0, 23);
/* 115 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.LegR2.func_78790_a(-3.3F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
/* 117 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/* 118 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.NeckRing_4.func_78790_a(-8.5F, -3.0F, -3.3F, 2, 1, 7, 0.0F);
/* 120 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/* 121 */     this.ClothB = new ModelRenderer(this, 33, 52);
/* 122 */     this.ClothB.func_78793_a(0.0F, 10.4F, 3.8F);
/* 123 */     this.ClothB.func_78790_a(-4.6F, -0.3F, 0.2F, 9, 9, 0, 0.0F);
/* 124 */     setRotateAngle(this.ClothB, 0.11868239F, 0.0F, 0.0F);
/* 125 */     this.LegL2 = new ModelRenderer(this, 0, 23);
/* 126 */     this.LegL2.field_78809_i = true;
/* 127 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.LegL2.func_78790_a(-2.4F, 0.1F, -3.5F, 6, 8, 7, 0.0F);
/* 129 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/* 130 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 131 */     this.NeckRing_5.func_78790_a(-8.3F, -3.0F, -3.3F, 2, 1, 7, 0.0F);
/* 132 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/* 133 */     this.ClothF = new ModelRenderer(this, 33, 52);
/* 134 */     this.ClothF.func_78793_a(0.0F, 10.4F, -3.5F);
/* 135 */     this.ClothF.func_78790_a(-4.5F, -0.3F, -0.7F, 9, 9, 0, 0.0F);
/* 136 */     setRotateAngle(this.ClothF, -0.11868239F, 0.0F, 0.0F);
/* 137 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/* 138 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 139 */     this.NeckRing_7.func_78790_a(-9.6F, -3.0F, -4.2F, 2, 1, 7, 0.0F);
/* 140 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/* 141 */     this.Hair3 = new ModelRenderer(this, 62, 0);
/* 142 */     this.Hair3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 143 */     this.Hair3.func_78790_a(-1.8F, -11.8F, -3.8F, 2, 3, 2, 0.0F);
/* 144 */     this.ShoulderArmorL = new ModelRenderer(this, 78, 3);
/* 145 */     this.ShoulderArmorL.field_78809_i = true;
/* 146 */     this.ShoulderArmorL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.ShoulderArmorL.func_78790_a(-1.3F, -2.5F, -3.0F, 5, 2, 6, 0.0F);
/* 148 */     setRotateAngle(this.ShoulderArmorL, 0.0F, 0.0F, -0.1134464F);
/* 149 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/* 150 */     this.NeckRing.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.NeckRing.func_78790_a(-3.5F, -3.0F, 7.9F, 7, 1, 2, 0.0F);
/* 152 */     setRotateAngle(this.NeckRing, 0.36669368F, 0.0F, 0.0F);
/* 153 */     this.Head.func_78792_a(this.Hair1);
/* 154 */     this.Body2.func_78792_a(this.Body3);
/* 155 */     this.LegL.func_78792_a(this.LegL3);
/* 156 */     this.Hair1.func_78792_a(this.Hair2);
/* 157 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 158 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 159 */     this.LegR.func_78792_a(this.LegR3);
/* 160 */     this.Hair3.func_78792_a(this.Hair4);
/* 161 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 162 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 163 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 164 */     this.Body1.func_78792_a(this.Body2);
/* 165 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 166 */     this.ArmR.func_78792_a(this.ShoulderArmorR);
/* 167 */     this.LegR.func_78792_a(this.LegR2);
/* 168 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 169 */     this.Body3.func_78792_a(this.ClothB);
/* 170 */     this.LegL.func_78792_a(this.LegL2);
/* 171 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 172 */     this.Body3.func_78792_a(this.ClothF);
/* 173 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 174 */     this.Hair2.func_78792_a(this.Hair3);
/* 175 */     this.ArmL.func_78792_a(this.ShoulderArmorL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 180 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */     
/* 184 */     this.LegL.func_78785_a(f5);
/* 185 */     this.Head.func_78785_a(f5);
/* 186 */     this.ArmL.func_78785_a(f5);
/* 187 */     this.ArmR.func_78785_a(f5);
/* 188 */     this.Body1.func_78785_a(f5);
/* 189 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 198 */     modelRenderer.field_78795_f = x;
/* 199 */     modelRenderer.field_78796_g = y;
/* 200 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 204 */     int calc = par7Entity.field_70173_aa;
/* 205 */     if (calc > 100) calc -= 100; 
/* 206 */     float r = 360.0F;
/* 207 */     float r2 = 180.0F;
/* 208 */     float n4 = par4;
/* 209 */     float n5 = par5;
/*     */     
/* 211 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 212 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 213 */     float ex = par7Entity.field_70173_aa;
/* 214 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 215 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 217 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 218 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 271 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 272 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 273 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 274 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 276 */     this.LegR.field_78796_g = 0.0F;
/* 277 */     this.LegL.field_78796_g = 0.0F;
/* 278 */     this.ArmR.field_78796_g = 0.0F;
/* 279 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 283 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 285 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 287 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelAwamo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */