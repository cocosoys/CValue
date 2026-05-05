/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelAniraza
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer HeadExtra1;
/*     */   public ModelRenderer HeadExtra1_1;
/*     */   public ModelRenderer HeadExtra2;
/*     */   public ModelRenderer HeadExtra3;
/*     */   public ModelRenderer HeadExtra2_1;
/*     */   public ModelRenderer HeadExtra3_1;
/*     */   public ModelRenderer Neck1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Neck2;
/*     */   public ModelRenderer Neck3;
/*     */   public ModelRenderer Abs;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer BicepR;
/*     */   public ModelRenderer ForeArmR;
/*     */   public ModelRenderer BicepL;
/*     */   public ModelRenderer ForeArmL;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   public ModelRenderer FootL;
/*     */   
/*     */   public ModelAniraza() {
/*  45 */     this.field_78090_t = 256;
/*  46 */     this.field_78089_u = 256;
/*  47 */     this.HeadExtra1 = new ModelRenderer(this, 43, 1);
/*  48 */     this.HeadExtra1.func_78793_a(-4.6F, -6.0F, -0.5F);
/*  49 */     this.HeadExtra1.func_78790_a(-4.0F, -1.5F, -2.0F, 4, 3, 4, 0.0F);
/*  50 */     setRotateAngle(this.HeadExtra1, 0.0F, 0.0F, -0.19198622F);
/*  51 */     this.ShoulderR = new ModelRenderer(this, 144, 54);
/*  52 */     this.ShoulderR.func_78793_a(-12.3F, -54.5F, 4.0F);
/*  53 */     this.ShoulderR.func_78790_a(-11.1F, -3.6F, -5.5F, 11, 10, 11, 0.0F);
/*  54 */     this.Neck2 = new ModelRenderer(this, 62, 27);
/*  55 */     this.Neck2.func_78793_a(0.0F, 0.0F, -1.0F);
/*  56 */     this.Neck2.func_78790_a(-7.0F, -4.1F, 0.3F, 14, 6, 4, 0.0F);
/*  57 */     this.Body4 = new ModelRenderer(this, 2, 131);
/*  58 */     this.Body4.func_78793_a(0.0F, 9.4F, 1.0F);
/*  59 */     this.Body4.func_78790_a(-10.0F, -2.7F, -6.9F, 20, 7, 12, 0.0F);
/*  60 */     this.BicepR = new ModelRenderer(this, 146, 78);
/*  61 */     this.BicepR.func_78793_a(-6.1F, 5.7F, 0.0F);
/*  62 */     this.BicepR.func_78790_a(-4.5F, 0.0F, -5.0F, 9, 14, 10, 0.0F);
/*  63 */     setRotateAngle(this.BicepR, 0.06632251F, 0.0F, 0.08726646F);
/*  64 */     this.HeadExtra2_1 = new ModelRenderer(this, 43, 9);
/*  65 */     this.HeadExtra2_1.field_78809_i = true;
/*  66 */     this.HeadExtra2_1.func_78793_a(3.5F, -0.4F, 0.0F);
/*  67 */     this.HeadExtra2_1.func_78790_a(0.1F, -0.9F, -1.5F, 4, 2, 3, 0.0F);
/*  68 */     setRotateAngle(this.HeadExtra2_1, -0.034906585F, 0.0F, 0.034906585F);
/*  69 */     this.Body3 = new ModelRenderer(this, 4, 106);
/*  70 */     this.Body3.func_78793_a(0.0F, 8.0F, 1.2F);
/*  71 */     this.Body3.func_78790_a(-9.0F, -3.0F, -6.4F, 18, 11, 12, 0.0F);
/*  72 */     this.HeadExtra3 = new ModelRenderer(this, 43, 15);
/*  73 */     this.HeadExtra3.func_78793_a(-4.0F, 0.1F, 0.0F);
/*  74 */     this.HeadExtra3.func_78790_a(-4.2F, -0.8F, -2.0F, 4, 2, 4, 0.0F);
/*  75 */     setRotateAngle(this.HeadExtra3, -0.05235988F, 0.0F, 0.0F);
/*  76 */     this.LegL3 = new ModelRenderer(this, 49, 157);
/*  77 */     this.LegL3.field_78809_i = true;
/*  78 */     this.LegL3.func_78793_a(0.0F, 6.5F, 0.9F);
/*  79 */     this.LegL3.func_78790_a(-6.0F, -4.8F, -5.1F, 12, 11, 10, 0.0F);
/*  80 */     this.ForeArmR = new ModelRenderer(this, 149, 105);
/*  81 */     this.ForeArmR.func_78793_a(0.0F, 13.8F, 0.0F);
/*  82 */     this.ForeArmR.func_78790_a(-5.0F, -0.5F, -4.2F, 10, 18, 10, 0.0F);
/*  83 */     setRotateAngle(this.ForeArmR, -0.14660765F, 0.0F, -0.05235988F);
/*  84 */     this.ShoulderL = new ModelRenderer(this, 144, 54);
/*  85 */     this.ShoulderL.field_78809_i = true;
/*  86 */     this.ShoulderL.func_78793_a(12.3F, -54.5F, 4.0F);
/*  87 */     this.ShoulderL.func_78790_a(0.1F, -3.6F, -5.5F, 11, 10, 11, 0.0F);
/*  88 */     this.HeadExtra1_1 = new ModelRenderer(this, 43, 1);
/*  89 */     this.HeadExtra1_1.field_78809_i = true;
/*  90 */     this.HeadExtra1_1.func_78793_a(4.6F, -6.0F, -0.5F);
/*  91 */     this.HeadExtra1_1.func_78790_a(0.0F, -1.5F, -2.0F, 4, 3, 4, 0.0F);
/*  92 */     setRotateAngle(this.HeadExtra1_1, 0.0F, 0.0F, 0.19198622F);
/*  93 */     this.FootR = new ModelRenderer(this, 89, 193);
/*  94 */     this.FootR.func_78793_a(0.0F, 15.7F, -0.3F);
/*  95 */     this.FootR.func_78790_a(-5.5F, 0.1F, -9.2F, 11, 5, 14, 0.0F);
/*  96 */     setRotateAngle(this.FootR, -0.05235988F, 0.0F, -0.017453292F);
/*  97 */     this.Neck1 = new ModelRenderer(this, 0, 27);
/*  98 */     this.Neck1.func_78793_a(0.0F, -1.9F, 5.3F);
/*  99 */     this.Neck1.func_78790_a(-11.0F, -1.1F, -5.1F, 22, 3, 7, 0.0F);
/* 100 */     this.FootL = new ModelRenderer(this, 89, 193);
/* 101 */     this.FootL.field_78809_i = true;
/* 102 */     this.FootL.func_78793_a(0.0F, 15.7F, -0.3F);
/* 103 */     this.FootL.func_78790_a(-5.5F, 0.1F, -9.2F, 11, 5, 14, 0.0F);
/* 104 */     setRotateAngle(this.FootL, -0.05235988F, 0.0F, 0.017453292F);
/* 105 */     this.LegL2 = new ModelRenderer(this, 94, 157);
/* 106 */     this.LegL2.field_78809_i = true;
/* 107 */     this.LegL2.func_78793_a(-0.1F, 20.0F, -0.8F);
/* 108 */     this.LegL2.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 24, 10, 0.0F);
/* 109 */     setRotateAngle(this.LegL2, 0.12217305F, 0.0F, 0.017453292F);
/* 110 */     this.Neck3 = new ModelRenderer(this, 100, 26);
/* 111 */     this.Neck3.func_78793_a(0.0F, 0.0F, -1.0F);
/* 112 */     this.Neck3.func_78790_a(-4.5F, -1.5F, -4.4F, 9, 4, 7, 0.0F);
/* 113 */     this.Body1 = new ModelRenderer(this, 0, 42);
/* 114 */     this.Body1.func_78793_a(0.0F, -58.0F, 0.0F);
/* 115 */     this.Body1.func_78790_a(-13.0F, 0.0F, -2.0F, 26, 16, 13, 0.0F);
/* 116 */     this.LegR2 = new ModelRenderer(this, 94, 157);
/* 117 */     this.LegR2.func_78793_a(-0.1F, 20.0F, -0.8F);
/* 118 */     this.LegR2.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 24, 10, 0.0F);
/* 119 */     setRotateAngle(this.LegR2, 0.12217305F, 0.0F, -0.017453292F);
/* 120 */     this.LegL1 = new ModelRenderer(this, 93, 122);
/* 121 */     this.LegL1.field_78809_i = true;
/* 122 */     this.LegL1.func_78793_a(6.0F, -23.0F, 2.7F);
/* 123 */     this.LegL1.func_78790_a(-5.5F, 0.0F, -6.0F, 11, 20, 12, 0.0F);
/* 124 */     setRotateAngle(this.LegL1, -0.06981317F, 0.0F, -0.034906585F);
/* 125 */     this.Chest = new ModelRenderer(this, 68, 73);
/* 126 */     this.Chest.func_78793_a(0.0F, 6.2F, -1.7F);
/* 127 */     this.Chest.func_78790_a(-10.0F, -3.7F, -3.5F, 20, 8, 4, 0.0F);
/* 128 */     this.BicepL = new ModelRenderer(this, 146, 78);
/* 129 */     this.BicepL.field_78809_i = true;
/* 130 */     this.BicepL.func_78793_a(6.1F, 5.7F, 0.0F);
/* 131 */     this.BicepL.func_78790_a(-4.5F, 0.0F, -5.0F, 9, 14, 10, 0.0F);
/* 132 */     setRotateAngle(this.BicepL, 0.06632251F, 0.0F, -0.08726646F);
/* 133 */     this.HeadExtra2 = new ModelRenderer(this, 43, 9);
/* 134 */     this.HeadExtra2.func_78793_a(-3.5F, -0.4F, 0.0F);
/* 135 */     this.HeadExtra2.func_78790_a(-4.1F, -0.9F, -1.5F, 4, 2, 3, 0.0F);
/* 136 */     setRotateAngle(this.HeadExtra2, -0.034906585F, 0.0F, -0.034906585F);
/* 137 */     this.ForeArmL = new ModelRenderer(this, 149, 105);
/* 138 */     this.ForeArmL.field_78809_i = true;
/* 139 */     this.ForeArmL.func_78793_a(0.0F, 13.8F, 0.0F);
/* 140 */     this.ForeArmL.func_78790_a(-4.5F, -0.5F, -4.2F, 10, 18, 10, 0.0F);
/* 141 */     setRotateAngle(this.ForeArmL, -0.14660765F, 0.0F, 0.05235988F);
/* 142 */     this.Head1 = new ModelRenderer(this, 0, 0);
/* 143 */     this.Head1.func_78793_a(0.0F, -63.2F, 2.7F);
/* 144 */     this.Head1.func_78790_a(-5.0F, -9.0F, -6.0F, 10, 11, 10, 0.0F);
/* 145 */     this.Abs = new ModelRenderer(this, 76, 88);
/* 146 */     this.Abs.func_78793_a(0.0F, 0.0F, -5.7F);
/* 147 */     this.Abs.func_78790_a(-6.0F, -2.7F, -0.5F, 12, 11, 1, 0.0F);
/* 148 */     this.Body2 = new ModelRenderer(this, 1, 73);
/* 149 */     this.Body2.func_78793_a(0.0F, 13.0F, 1.2F);
/* 150 */     this.Body2.func_78790_a(-11.0F, -11.9F, -5.5F, 22, 17, 14, 0.0F);
/* 151 */     this.LegR1 = new ModelRenderer(this, 93, 122);
/* 152 */     this.LegR1.func_78793_a(-6.0F, -23.0F, 2.7F);
/* 153 */     this.LegR1.func_78790_a(-5.5F, 0.0F, -6.0F, 11, 20, 12, 0.0F);
/* 154 */     setRotateAngle(this.LegR1, -0.06981317F, 0.0F, 0.034906585F);
/* 155 */     this.LegR3 = new ModelRenderer(this, 49, 157);
/* 156 */     this.LegR3.func_78793_a(0.0F, 6.5F, 0.9F);
/* 157 */     this.LegR3.func_78790_a(-6.0F, -4.8F, -5.1F, 12, 11, 10, 0.0F);
/* 158 */     this.HeadExtra3_1 = new ModelRenderer(this, 43, 15);
/* 159 */     this.HeadExtra3_1.field_78809_i = true;
/* 160 */     this.HeadExtra3_1.func_78793_a(4.0F, 0.1F, 0.0F);
/* 161 */     this.HeadExtra3_1.func_78790_a(0.2F, -0.8F, -2.0F, 4, 2, 4, 0.0F);
/* 162 */     setRotateAngle(this.HeadExtra3_1, -0.05235988F, 0.0F, 0.0F);
/* 163 */     this.Head1.func_78792_a(this.HeadExtra1);
/* 164 */     this.Neck1.func_78792_a(this.Neck2);
/* 165 */     this.Body3.func_78792_a(this.Body4);
/* 166 */     this.ShoulderR.func_78792_a(this.BicepR);
/* 167 */     this.HeadExtra1_1.func_78792_a(this.HeadExtra2_1);
/* 168 */     this.Body2.func_78792_a(this.Body3);
/* 169 */     this.HeadExtra2.func_78792_a(this.HeadExtra3);
/* 170 */     this.LegL2.func_78792_a(this.LegL3);
/* 171 */     this.BicepR.func_78792_a(this.ForeArmR);
/* 172 */     this.Head1.func_78792_a(this.HeadExtra1_1);
/* 173 */     this.LegR3.func_78792_a(this.FootR);
/* 174 */     this.Body1.func_78792_a(this.Neck1);
/* 175 */     this.LegL3.func_78792_a(this.FootL);
/* 176 */     this.LegL1.func_78792_a(this.LegL2);
/* 177 */     this.Neck2.func_78792_a(this.Neck3);
/* 178 */     this.LegR1.func_78792_a(this.LegR2);
/* 179 */     this.Body1.func_78792_a(this.Chest);
/* 180 */     this.ShoulderL.func_78792_a(this.BicepL);
/* 181 */     this.HeadExtra1.func_78792_a(this.HeadExtra2);
/* 182 */     this.BicepL.func_78792_a(this.ForeArmL);
/* 183 */     this.Body2.func_78792_a(this.Abs);
/* 184 */     this.Body1.func_78792_a(this.Body2);
/* 185 */     this.LegR2.func_78792_a(this.LegR3);
/* 186 */     this.HeadExtra2_1.func_78792_a(this.HeadExtra3_1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 191 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 193 */     GL11.glPushMatrix();
/* 194 */     float F = 2.5F;
/* 195 */     JGRenderHelper.modelScalePositionHelper(2.5F);
/* 196 */     this.LegL1.func_78785_a(f5);
/* 197 */     this.Head1.func_78785_a(f5);
/* 198 */     this.ShoulderL.func_78785_a(f5);
/* 199 */     this.ShoulderR.func_78785_a(f5);
/* 200 */     this.Body1.func_78785_a(f5);
/* 201 */     this.LegR1.func_78785_a(f5);
/* 202 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 208 */     modelRenderer.field_78795_f = x;
/* 209 */     modelRenderer.field_78796_g = y;
/* 210 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 214 */     int calc = par7Entity.field_70173_aa;
/* 215 */     if (calc > 100) calc -= 100; 
/* 216 */     float r = 360.0F;
/* 217 */     float r2 = 180.0F;
/* 218 */     float n4 = par4;
/* 219 */     float n5 = par5;
/*     */     
/* 221 */     this.Head1.field_78796_g = n4 / r2 / 3.1415927F;
/* 222 */     this.Head1.field_78795_f = n5 / r2 / 3.1415927F;
/* 223 */     float ex = par7Entity.field_70173_aa;
/* 224 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 225 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 227 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 228 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 274 */     this.LegR1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 275 */     this.LegL1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 276 */     this.ShoulderR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 277 */     this.ShoulderL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 279 */     this.LegR1.field_78796_g = 0.0F;
/* 280 */     this.LegL1.field_78796_g = 0.0F;
/* 281 */     this.ShoulderR.field_78796_g = 0.0F;
/* 282 */     this.ShoulderL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 289 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAniraza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */