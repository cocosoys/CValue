/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelAngelKusu
/*     */   extends ModelBase
/*     */ {
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
/*     */   
/*     */   public ModelAngelKusu() {
/*  44 */     this.field_78090_t = 64;
/*  45 */     this.field_78089_u = 64;
/*  46 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/*  47 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.NeckRing_3.func_78790_a(-8.7F, -1.3F, -3.2F, 2, 1, 7, 0.0F);
/*  49 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/*  50 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/*  51 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.NeckRing_5.func_78790_a(-8.3F, -1.3F, -3.3F, 2, 1, 7, 0.0F);
/*  53 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/*  54 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/*  55 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.NeckRing_1.func_78790_a(-9.7F, -1.3F, -2.9F, 2, 1, 7, 0.0F);
/*  57 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/*  58 */     this.Neck = new ModelRenderer(this, 7, 16);
/*  59 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Neck.func_78790_a(-2.0F, -1.3F, -0.8F, 4, 2, 2, 0.0F);
/*  61 */     this.ClothF = new ModelRenderer(this, 44, 52);
/*  62 */     this.ClothF.func_78793_a(0.0F, 9.0F, -2.1F);
/*  63 */     this.ClothF.func_78790_a(-2.5F, 0.0F, 0.1F, 5, 11, 0, 0.0F);
/*  64 */     setRotateAngle(this.ClothF, -0.11519173F, 0.0F, 0.0F);
/*  65 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/*  66 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.NeckRing_4.func_78790_a(-8.5F, -1.3F, -3.3F, 2, 1, 7, 0.0F);
/*  68 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/*  69 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/*  70 */     this.NeckRing.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.NeckRing.func_78790_a(-3.5F, -1.3F, 7.9F, 7, 1, 2, 0.0F);
/*  72 */     setRotateAngle(this.NeckRing, 0.59184116F, 0.0F, 0.0F);
/*  73 */     this.Hair5 = new ModelRenderer(this, 49, 16);
/*  74 */     this.Hair5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.Hair5.func_78790_a(-4.9F, 1.2F, -3.1F, 2, 3, 2, 0.0F);
/*  76 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/*  77 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.NeckRing_7.func_78790_a(-9.6F, -1.3F, -4.2F, 2, 1, 7, 0.0F);
/*  79 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/*  80 */     this.Hair4 = new ModelRenderer(this, 49, 11);
/*  81 */     this.Hair4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.Hair4.func_78790_a(-5.7F, -0.1F, -2.1F, 2, 2, 2, 0.0F);
/*  83 */     this.LegR3 = new ModelRenderer(this, 0, 33);
/*  84 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.LegR3.func_78790_a(-1.6F, 0.0F, -2.0F, 3, 15, 4, 0.0F);
/*  86 */     this.Head = new ModelRenderer(this, 0, 0);
/*  87 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/*  88 */     this.Head.func_78790_a(-3.5F, -7.8F, -4.0F, 7, 8, 8, -0.1F);
/*  89 */     this.Boobs = new ModelRenderer(this, 35, 28);
/*  90 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Boobs.func_78790_a(-3.5F, 0.9F, -1.0F, 7, 3, 3, 0.0F);
/*  92 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  93 */     this.Body2 = new ModelRenderer(this, 16, 29);
/*  94 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.Body2.func_78790_a(-3.0F, 6.0F, -1.5F, 6, 3, 3, 0.0F);
/*  96 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/*  97 */     this.LegL2.field_78809_i = true;
/*  98 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     this.LegL2.func_78790_a(-1.4F, 13.0F, -4.0F, 3, 2, 2, 0.0F);
/* 100 */     this.ArmL = new ModelRenderer(this, 40, 35);
/* 101 */     this.ArmL.field_78809_i = true;
/* 102 */     this.ArmL.func_78793_a(5.0F, -1.2F, 0.0F);
/* 103 */     this.ArmL.func_78790_a(-1.0F, -1.5F, -1.4F, 3, 13, 3, 0.0F);
/* 104 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/* 105 */     this.LegR2.field_78809_i = true;
/* 106 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.LegR2.func_78790_a(-1.6F, 13.0F, -4.0F, 3, 2, 2, 0.0F);
/* 108 */     this.ArmR = new ModelRenderer(this, 40, 35);
/* 109 */     this.ArmR.func_78793_a(-5.0F, -1.2F, 0.0F);
/* 110 */     this.ArmR.func_78790_a(-2.0F, -1.5F, -1.3F, 3, 13, 3, 0.0F);
/* 111 */     this.Body3 = new ModelRenderer(this, 15, 36);
/* 112 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/* 114 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/* 115 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.NeckRing_2.func_78790_a(-8.7F, -1.3F, -3.9F, 2, 1, 9, 0.0F);
/* 117 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/* 118 */     this.Body1 = new ModelRenderer(this, 16, 17);
/* 119 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/* 120 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 6, 4, 0.0F);
/* 121 */     this.ClothB = new ModelRenderer(this, 44, 52);
/* 122 */     this.ClothB.func_78793_a(0.0F, 9.0F, 2.0F);
/* 123 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/* 124 */     setRotateAngle(this.ClothB, 0.13264503F, 0.0F, 0.0F);
/* 125 */     this.LegL4 = new ModelRenderer(this, 0, 33);
/* 126 */     this.LegL4.field_78809_i = true;
/* 127 */     this.LegL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.LegL4.func_78790_a(-1.4F, 0.0F, -2.0F, 3, 15, 4, 0.0F);
/* 129 */     this.LegR = new ModelRenderer(this, 0, 20);
/* 130 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/* 131 */     this.LegR.func_78790_a(-2.3F, 0.0F, -2.0F, 4, 9, 4, 0.3F);
/* 132 */     this.Hair1 = new ModelRenderer(this, 25, 1);
/* 133 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.Hair1.func_78790_a(-5.1F, -5.4F, -0.1F, 2, 2, 2, 0.0F);
/* 135 */     this.Hair2 = new ModelRenderer(this, 34, 1);
/* 136 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.Hair2.func_78790_a(-5.6F, -3.8F, -0.5F, 3, 3, 3, 0.0F);
/* 138 */     this.Hair3 = new ModelRenderer(this, 47, 3);
/* 139 */     this.Hair3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.Hair3.func_78790_a(-6.2F, -2.3F, -1.1F, 3, 3, 3, 0.0F);
/* 141 */     this.LegL = new ModelRenderer(this, 0, 20);
/* 142 */     this.LegL.field_78809_i = true;
/* 143 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/* 144 */     this.LegL.func_78790_a(-1.7F, 0.0F, -2.0F, 4, 9, 4, 0.3F);
/* 145 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/* 146 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.NeckRing_6.func_78790_a(-8.3F, -1.3F, -5.5F, 2, 1, 9, 0.0F);
/* 148 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/* 149 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 150 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 151 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 152 */     this.Body1.func_78792_a(this.Neck);
/* 153 */     this.Body1.func_78792_a(this.ClothF);
/* 154 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 155 */     this.Body1.func_78792_a(this.NeckRing);
/* 156 */     this.Hair4.func_78792_a(this.Hair5);
/* 157 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 158 */     this.Hair3.func_78792_a(this.Hair4);
/* 159 */     this.LegR.func_78792_a(this.LegR3);
/* 160 */     this.Body1.func_78792_a(this.Boobs);
/* 161 */     this.Body1.func_78792_a(this.Body2);
/* 162 */     this.LegL.func_78792_a(this.LegL2);
/* 163 */     this.LegR.func_78792_a(this.LegR2);
/* 164 */     this.Body2.func_78792_a(this.Body3);
/* 165 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 166 */     this.Body1.func_78792_a(this.ClothB);
/* 167 */     this.LegL.func_78792_a(this.LegL4);
/* 168 */     this.Head.func_78792_a(this.Hair1);
/* 169 */     this.Hair1.func_78792_a(this.Hair2);
/* 170 */     this.Hair2.func_78792_a(this.Hair3);
/* 171 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 176 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 178 */     GL11.glPushMatrix();
/* 179 */     float F = 0.7F;
/* 180 */     JGRenderHelper.modelScalePositionHelper(0.7F);
/*     */     
/* 182 */     this.LegL.func_78785_a(f5);
/* 183 */     this.Head.func_78785_a(f5);
/* 184 */     this.ArmL.func_78785_a(f5);
/* 185 */     this.ArmR.func_78785_a(f5);
/* 186 */     this.Body1.func_78785_a(f5);
/* 187 */     this.LegR.func_78785_a(f5);
/* 188 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 193 */     modelRenderer.field_78795_f = x;
/* 194 */     modelRenderer.field_78796_g = y;
/* 195 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 199 */     int calc = par7Entity.field_70173_aa;
/* 200 */     if (calc > 100) calc -= 100; 
/* 201 */     float r = 360.0F;
/* 202 */     float r2 = 180.0F;
/* 203 */     float n4 = par4;
/* 204 */     float n5 = par5;
/*     */     
/* 206 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 207 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 208 */     float ex = par7Entity.field_70173_aa;
/* 209 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 210 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 212 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 213 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 256 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 257 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 258 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 260 */     this.LegR.field_78796_g = 0.0F;
/* 261 */     this.LegL.field_78796_g = 0.0F;
/* 262 */     this.ArmR.field_78796_g = 0.0F;
/* 263 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 266 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 268 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 270 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelKusu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */