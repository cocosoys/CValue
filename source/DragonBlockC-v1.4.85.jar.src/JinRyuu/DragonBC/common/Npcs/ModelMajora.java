/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMajora
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer EarR1;
/*     */   public ModelRenderer Snout1;
/*     */   public ModelRenderer SideFurR1;
/*     */   public ModelRenderer EarL1;
/*     */   public ModelRenderer SideFurL1;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarR3;
/*     */   public ModelRenderer Earing1;
/*     */   public ModelRenderer Earing2;
/*     */   public ModelRenderer Snout2;
/*     */   public ModelRenderer SnoutSideR;
/*     */   public ModelRenderer SnoutSideL;
/*     */   public ModelRenderer SideFurR2;
/*     */   public ModelRenderer EarL2;
/*     */   public ModelRenderer EarL3;
/*     */   public ModelRenderer SideFurL2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Cloth2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   
/*     */   public ModelMajora() {
/*  43 */     this.field_78090_t = 128;
/*  44 */     this.field_78089_u = 64;
/*  45 */     this.SnoutSideR = new ModelRenderer(this, 47, 8);
/*  46 */     this.SnoutSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.SnoutSideR.func_78790_a(-0.2F, -2.6F, -4.9F, 2, 2, 1, 0.0F);
/*  48 */     setRotateAngle(this.SnoutSideR, 0.0F, 0.5934119F, 0.0F);
/*  49 */     this.ArmR2 = new ModelRenderer(this, 47, 48);
/*  50 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.ArmR2.func_78790_a(-3.0F, 6.7F, -2.0F, 4, 7, 4, 0.0F);
/*  52 */     this.SnoutSideL = new ModelRenderer(this, 47, 8);
/*  53 */     this.SnoutSideL.field_78809_i = true;
/*  54 */     this.SnoutSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.SnoutSideL.func_78790_a(-1.7F, -2.6F, -4.9F, 2, 2, 1, 0.0F);
/*  56 */     setRotateAngle(this.SnoutSideL, 0.0F, -0.5934119F, 0.0F);
/*  57 */     this.Cloth1 = new ModelRenderer(this, 28, 21);
/*  58 */     this.Cloth1.func_78793_a(0.0F, 8.8F, -2.0F);
/*  59 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 10, 0, 0.0F);
/*  60 */     setRotateAngle(this.Cloth1, -0.090757124F, 0.0F, 0.0F);
/*  61 */     this.ArmL2 = new ModelRenderer(this, 47, 48);
/*  62 */     this.ArmL2.field_78809_i = true;
/*  63 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.ArmL2.func_78790_a(-1.0F, 6.7F, -2.0F, 4, 7, 4, 0.0F);
/*  65 */     this.Head = new ModelRenderer(this, 0, 0);
/*  66 */     this.Head.func_78793_a(0.0F, -0.8F, 0.0F);
/*  67 */     this.Head.func_78790_a(-3.5F, -6.7F, -4.0F, 7, 7, 8, -0.2F);
/*  68 */     this.EarR1 = new ModelRenderer(this, 70, 11);
/*  69 */     this.EarR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.EarR1.func_78790_a(-4.4F, -9.8F, 1.0F, 4, 4, 1, 0.0F);
/*  71 */     setRotateAngle(this.EarR1, 0.18675023F, 0.07853982F, 0.0F);
/*  72 */     this.Earing1 = new ModelRenderer(this, 26, 3);
/*  73 */     this.Earing1.func_78793_a(-3.5F, -10.0F, 1.6F);
/*  74 */     this.Earing1.func_78790_a(-2.4F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
/*  75 */     setRotateAngle(this.Earing1, 0.1605703F, 0.0F, -0.4553564F);
/*  76 */     this.EarR3 = new ModelRenderer(this, 81, 7);
/*  77 */     this.EarR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.EarR3.func_78790_a(-3.3F, -11.2F, 2.7F, 2, 6, 1, 0.0F);
/*  79 */     setRotateAngle(this.EarR3, 0.13665928F, 0.0F, 0.0F);
/*  80 */     this.LegL = new ModelRenderer(this, 26, 37);
/*  81 */     this.LegL.field_78809_i = true;
/*  82 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  83 */     this.LegL.func_78790_a(-1.8F, 1.1F, -2.0F, 4, 5, 4, 0.3F);
/*  84 */     this.SideFurR2 = new ModelRenderer(this, 58, 10);
/*  85 */     this.SideFurR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.SideFurR2.func_78790_a(-4.6F, -1.7F, -1.4F, 1, 2, 3, 0.0F);
/*  87 */     this.LegL2 = new ModelRenderer(this, 26, 47);
/*  88 */     this.LegL2.field_78809_i = true;
/*  89 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  91 */     this.ArmR1 = new ModelRenderer(this, 47, 34);
/*  92 */     this.ArmR1.func_78793_a(-4.7F, 0.7F, 0.0F);
/*  93 */     this.ArmR1.func_78790_a(-2.9F, -1.0F, -2.0F, 4, 8, 4, -0.3F);
/*  94 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, 0.0418879F);
/*  95 */     this.EarR2 = new ModelRenderer(this, 71, 5);
/*  96 */     this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.EarR2.func_78790_a(-3.9F, -12.8F, 1.0F, 3, 3, 1, 0.0F);
/*  98 */     this.ArmL1 = new ModelRenderer(this, 47, 34);
/*  99 */     this.ArmL1.field_78809_i = true;
/* 100 */     this.ArmL1.func_78793_a(4.7F, 0.7F, 0.0F);
/* 101 */     this.ArmL1.func_78790_a(-1.1F, -1.0F, -2.0F, 4, 8, 4, -0.3F);
/* 102 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, -0.0418879F);
/* 103 */     this.SideFurR1 = new ModelRenderer(this, 56, 1);
/* 104 */     this.SideFurR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 105 */     this.SideFurR1.func_78790_a(-4.2F, -2.8F, -3.2F, 1, 3, 5, 0.0F);
/* 106 */     this.Body2 = new ModelRenderer(this, 0, 32);
/* 107 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.Body2.func_78790_a(-3.5F, 6.0F, -1.9F, 7, 3, 3, 0.0F);
/* 109 */     this.Snout2 = new ModelRenderer(this, 42, 8);
/* 110 */     this.Snout2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.Snout2.func_78790_a(-0.5F, 1.1F, -4.5F, 1, 2, 1, 0.0F);
/* 112 */     setRotateAngle(this.Snout2, -1.0927507F, 0.0F, 0.0F);
/* 113 */     this.EarL3 = new ModelRenderer(this, 81, 7);
/* 114 */     this.EarL3.field_78809_i = true;
/* 115 */     this.EarL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.EarL3.func_78790_a(1.3F, -11.2F, 2.7F, 2, 6, 1, 0.0F);
/* 117 */     setRotateAngle(this.EarL3, 0.13665928F, 0.0F, 0.0F);
/* 118 */     this.LegR2 = new ModelRenderer(this, 26, 47);
/* 119 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 120 */     this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 121 */     this.LegR = new ModelRenderer(this, 26, 37);
/* 122 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/* 123 */     this.LegR.func_78790_a(-2.3F, 1.1F, -2.0F, 4, 5, 4, 0.3F);
/* 124 */     this.Earing2 = new ModelRenderer(this, 26, 3);
/* 125 */     this.Earing2.func_78793_a(-4.0F, -8.8F, 1.6F);
/* 126 */     this.Earing2.func_78790_a(-2.4F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
/* 127 */     setRotateAngle(this.Earing2, 0.21293017F, 0.0F, -0.64385194F);
/* 128 */     this.SideFurL2 = new ModelRenderer(this, 58, 10);
/* 129 */     this.SideFurL2.field_78809_i = true;
/* 130 */     this.SideFurL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 131 */     this.SideFurL2.func_78790_a(3.8F, -1.7F, -1.4F, 1, 2, 3, 0.0F);
/* 132 */     this.Body3 = new ModelRenderer(this, 0, 41);
/* 133 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/* 135 */     this.Neck = new ModelRenderer(this, 5, 16);
/* 136 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.Neck.func_78790_a(-2.0F, -0.9F, -0.8F, 4, 1, 2, 0.0F);
/* 138 */     this.EarL2 = new ModelRenderer(this, 71, 5);
/* 139 */     this.EarL2.field_78809_i = true;
/* 140 */     this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 141 */     this.EarL2.func_78790_a(1.0F, -12.8F, 1.0F, 3, 3, 1, 0.0F);
/* 142 */     this.Cloth2 = new ModelRenderer(this, 41, 20);
/* 143 */     this.Cloth2.func_78793_a(0.0F, 9.0F, 2.0F);
/* 144 */     this.Cloth2.func_78790_a(-4.5F, 0.0F, 0.0F, 9, 12, 0, 0.0F);
/* 145 */     setRotateAngle(this.Cloth2, 0.090757124F, 0.0F, 0.0F);
/* 146 */     this.Body1 = new ModelRenderer(this, 0, 20);
/* 147 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 148 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.2F, 8, 6, 4, 0.0F);
/* 149 */     this.EarL1 = new ModelRenderer(this, 70, 11);
/* 150 */     this.EarL1.field_78809_i = true;
/* 151 */     this.EarL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     this.EarL1.func_78790_a(0.5F, -9.8F, 1.0F, 4, 4, 1, 0.0F);
/* 153 */     setRotateAngle(this.EarL1, 0.18675023F, -0.07853982F, 0.0F);
/* 154 */     this.SideFurL1 = new ModelRenderer(this, 56, 1);
/* 155 */     this.SideFurL1.field_78809_i = true;
/* 156 */     this.SideFurL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 157 */     this.SideFurL1.func_78790_a(3.2F, -2.8F, -3.2F, 1, 3, 5, 0.0F);
/* 158 */     this.Snout1 = new ModelRenderer(this, 41, 1);
/* 159 */     this.Snout1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 160 */     this.Snout1.func_78790_a(-1.5F, -2.7F, -5.8F, 3, 3, 2, 0.0F);
/* 161 */     this.Snout1.func_78792_a(this.SnoutSideR);
/* 162 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 163 */     this.Snout1.func_78792_a(this.SnoutSideL);
/* 164 */     this.Body3.func_78792_a(this.Cloth1);
/* 165 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 166 */     this.Head.func_78792_a(this.EarR1);
/* 167 */     this.EarR1.func_78792_a(this.Earing1);
/* 168 */     this.EarR1.func_78792_a(this.EarR3);
/* 169 */     this.SideFurR1.func_78792_a(this.SideFurR2);
/* 170 */     this.LegL.func_78792_a(this.LegL2);
/* 171 */     this.EarR1.func_78792_a(this.EarR2);
/* 172 */     this.Head.func_78792_a(this.SideFurR1);
/* 173 */     this.Body1.func_78792_a(this.Body2);
/* 174 */     this.Snout1.func_78792_a(this.Snout2);
/* 175 */     this.EarL1.func_78792_a(this.EarL3);
/* 176 */     this.LegR.func_78792_a(this.LegR2);
/* 177 */     this.EarR1.func_78792_a(this.Earing2);
/* 178 */     this.SideFurL1.func_78792_a(this.SideFurL2);
/* 179 */     this.Body2.func_78792_a(this.Body3);
/* 180 */     this.Body1.func_78792_a(this.Neck);
/* 181 */     this.EarL1.func_78792_a(this.EarL2);
/* 182 */     this.Body3.func_78792_a(this.Cloth2);
/* 183 */     this.Head.func_78792_a(this.EarL1);
/* 184 */     this.Head.func_78792_a(this.SideFurL1);
/* 185 */     this.Head.func_78792_a(this.Snout1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 190 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 193 */     this.ArmL1.func_78785_a(f5);
/* 194 */     this.Head.func_78785_a(f5);
/* 195 */     this.ArmR1.func_78785_a(f5);
/* 196 */     this.Body1.func_78785_a(f5);
/* 197 */     this.LegL.func_78785_a(f5);
/* 198 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
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
/*     */ 
/*     */     
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 270 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 271 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 272 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 273 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 275 */     this.LegR.field_78796_g = 0.0F;
/* 276 */     this.LegL.field_78796_g = 0.0F;
/* 277 */     this.ArmR1.field_78796_g = 0.0F;
/* 278 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 281 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 282 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 283 */     this.Cloth2.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 284 */     this.Cloth2.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 285 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelMajora.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */