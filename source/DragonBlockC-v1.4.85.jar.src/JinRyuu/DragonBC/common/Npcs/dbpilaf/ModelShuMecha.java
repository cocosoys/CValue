/*     */ package JinRyuu.DragonBC.common.Npcs.dbpilaf;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelShuMecha
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer Leg1L;
/*     */   public ModelRenderer Leg1R;
/*     */   public ModelRenderer BodyBack;
/*     */   public ModelRenderer BodyFront;
/*     */   public ModelRenderer BodyR;
/*     */   public ModelRenderer BodyL;
/*     */   public ModelRenderer BodyBottom;
/*     */   public ModelRenderer BodyTop;
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer Back;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Bottom;
/*     */   public ModelRenderer PlateR;
/*     */   public ModelRenderer PlateL;
/*     */   public ModelRenderer Bottom_1;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmGunR1;
/*     */   public ModelRenderer ArmGunR2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmGunR1_1;
/*     */   public ModelRenderer ArmGunR2_1;
/*     */   public ModelRenderer Leg2L;
/*     */   public ModelRenderer Leg3L;
/*     */   public ModelRenderer KneeL;
/*     */   public ModelRenderer FootL;
/*     */   public ModelRenderer Leg2R;
/*     */   public ModelRenderer Leg3R;
/*     */   public ModelRenderer KneeR;
/*     */   public ModelRenderer FootR;
/*     */   
/*     */   public ModelShuMecha() {
/*  53 */     this.field_78090_t = 256;
/*  54 */     this.field_78089_u = 128;
/*  55 */     this.Head1 = new ModelRenderer(this, 72, 0);
/*  56 */     this.Head1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.Head1.func_78790_a(-6.0F, -4.6F, -10.0F, 12, 15, 14, 0.0F);
/*  58 */     this.Leg3L = new ModelRenderer(this, 1, 87);
/*  59 */     this.Leg3L.field_78809_i = true;
/*  60 */     this.Leg3L.func_78793_a(0.0F, 10.7F, -0.1F);
/*  61 */     this.Leg3L.func_78790_a(-3.0F, -0.1F, -2.5F, 6, 18, 5, 0.0F);
/*  62 */     setRotateAngle(this.Leg3L, 0.31415927F, 0.0F, 0.0F);
/*  63 */     this.ArmR3 = new ModelRenderer(this, 46, 101);
/*  64 */     this.ArmR3.func_78793_a(0.0F, 6.5F, 0.0F);
/*  65 */     this.ArmR3.func_78790_a(-2.5F, 0.0F, -2.0F, 4, 7, 5, 0.0F);
/*  66 */     setRotateAngle(this.ArmR3, -1.2217305F, 0.0F, 0.0F);
/*  67 */     this.KneeR = new ModelRenderer(this, 25, 91);
/*  68 */     this.KneeR.func_78793_a(0.0F, 1.6F, 0.0F);
/*  69 */     this.KneeR.func_78790_a(-1.5F, -2.7F, -3.0F, 3, 4, 1, 0.0F);
/*  70 */     this.Bottom_1 = new ModelRenderer(this, 115, 47);
/*  71 */     this.Bottom_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.Bottom_1.func_78790_a(-3.0F, 9.3F, -8.1F, 6, 6, 14, 0.0F);
/*  73 */     this.Bottom = new ModelRenderer(this, 152, 29);
/*  74 */     this.Bottom.func_78793_a(0.0F, -9.3F, 0.0F);
/*  75 */     this.Bottom.func_78790_a(-2.0F, -6.2F, -2.0F, 4, 7, 4, 0.0F);
/*  76 */     setRotateAngle(this.Bottom, 0.3642502F, 0.0F, 0.0F);
/*  77 */     this.BodyTop = new ModelRenderer(this, 0, 34);
/*  78 */     this.BodyTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.BodyTop.func_78790_a(-7.0F, -9.6F, -6.0F, 14, 2, 13, 0.0F);
/*  80 */     this.ArmGunR1_1 = new ModelRenderer(this, 46, 114);
/*  81 */     this.ArmGunR1_1.func_78793_a(-0.5F, 7.0F, -0.7F);
/*  82 */     this.ArmGunR1_1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
/*  83 */     this.BodyBack = new ModelRenderer(this, 0, 54);
/*  84 */     this.BodyBack.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.BodyBack.func_78790_a(-7.0F, -6.5F, 8.3F, 14, 13, 2, 0.0F);
/*  86 */     this.BodyR = new ModelRenderer(this, 44, 42);
/*  87 */     this.BodyR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.BodyR.func_78790_a(-10.5F, -6.5F, -6.5F, 2, 13, 14, 0.0F);
/*  89 */     this.KneeL = new ModelRenderer(this, 25, 91);
/*  90 */     this.KneeL.field_78809_i = true;
/*  91 */     this.KneeL.func_78793_a(0.0F, 1.6F, 0.0F);
/*  92 */     this.KneeL.func_78790_a(-1.5F, -2.7F, -3.0F, 3, 4, 1, 0.0F);
/*  93 */     this.ArmL3 = new ModelRenderer(this, 46, 101);
/*  94 */     this.ArmL3.field_78809_i = true;
/*  95 */     this.ArmL3.func_78793_a(0.0F, 6.5F, 0.0F);
/*  96 */     this.ArmL3.func_78790_a(-1.4F, 0.0F, -2.0F, 4, 7, 5, 0.0F);
/*  97 */     setRotateAngle(this.ArmL3, -1.2217305F, 0.0F, 0.0F);
/*  98 */     this.ArmR2 = new ModelRenderer(this, 46, 91);
/*  99 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.ArmR2.func_78790_a(-1.3F, -0.4F, -1.1F, 2, 7, 2, 0.0F);
/* 101 */     setRotateAngle(this.ArmR2, 0.0F, 0.0F, 1.0471976F);
/* 102 */     this.ArmGunR1 = new ModelRenderer(this, 46, 114);
/* 103 */     this.ArmGunR1.func_78793_a(0.5F, 7.0F, -0.7F);
/* 104 */     this.ArmGunR1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
/* 105 */     this.FootL = new ModelRenderer(this, 1, 113);
/* 106 */     this.FootL.field_78809_i = true;
/* 107 */     this.FootL.func_78793_a(0.0F, 17.0F, 0.0F);
/* 108 */     this.FootL.func_78790_a(-2.0F, 0.0F, -6.0F, 4, 2, 11, 0.0F);
/* 109 */     this.Tail3 = new ModelRenderer(this, 141, 29);
/* 110 */     this.Tail3.func_78793_a(0.0F, -8.6F, 0.0F);
/* 111 */     this.Tail3.func_78790_a(-1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F);
/* 112 */     setRotateAngle(this.Tail3, 0.5235988F, 0.0F, 0.0F);
/* 113 */     this.Leg2R = new ModelRenderer(this, 26, 73);
/* 114 */     this.Leg2R.func_78793_a(0.0F, 4.6F, 0.0F);
/* 115 */     this.Leg2R.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 11, 3, 0.0F);
/* 116 */     setRotateAngle(this.Leg2R, -0.31415927F, 0.0F, 0.0F);
/* 117 */     this.Leg3R = new ModelRenderer(this, 1, 87);
/* 118 */     this.Leg3R.func_78793_a(0.0F, 10.7F, -0.1F);
/* 119 */     this.Leg3R.func_78790_a(-3.0F, -0.1F, -2.5F, 6, 18, 5, 0.0F);
/* 120 */     setRotateAngle(this.Leg3R, 0.31415927F, 0.0F, 0.0F);
/* 121 */     this.Leg2L = new ModelRenderer(this, 26, 73);
/* 122 */     this.Leg2L.field_78809_i = true;
/* 123 */     this.Leg2L.func_78793_a(0.0F, 4.6F, 0.0F);
/* 124 */     this.Leg2L.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 11, 3, 0.0F);
/* 125 */     setRotateAngle(this.Leg2L, -0.31415927F, 0.0F, 0.0F);
/* 126 */     this.Head2 = new ModelRenderer(this, 78, 30);
/* 127 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.Head2.func_78790_a(-5.0F, -3.0F, -10.7F, 10, 14, 13, 0.0F);
/* 129 */     this.ArmR1 = new ModelRenderer(this, 0, 0);
/* 130 */     this.ArmR1.func_78793_a(-10.0F, -18.0F, 0.0F);
/* 131 */     this.ArmR1.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/* 132 */     this.Body = new ModelRenderer(this, 0, 0);
/* 133 */     this.Body.func_78793_a(0.0F, -17.0F, 0.0F);
/* 134 */     this.Body.func_78790_a(-9.0F, -8.0F, -7.4F, 18, 16, 16, 0.0F);
/* 135 */     this.Tail2 = new ModelRenderer(this, 127, 28);
/* 136 */     this.Tail2.func_78793_a(0.0F, -8.7F, 0.0F);
/* 137 */     this.Tail2.func_78790_a(-1.5F, -9.0F, -1.5F, 3, 9, 3, 0.0F);
/* 138 */     setRotateAngle(this.Tail2, 0.6981317F, 0.0F, 0.0F);
/* 139 */     this.PlateR = new ModelRenderer(this, 44, 72);
/* 140 */     this.PlateR.func_78793_a(-10.5F, -5.0F, 0.5F);
/* 141 */     this.PlateR.func_78790_a(-1.0F, -0.4F, -3.5F, 1, 10, 7, 0.0F);
/* 142 */     setRotateAngle(this.PlateR, 0.0F, 0.0F, 1.7453293F);
/* 143 */     this.BodyBottom = new ModelRenderer(this, 0, 34);
/* 144 */     this.BodyBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 145 */     this.BodyBottom.func_78790_a(-7.0F, 7.8F, -6.0F, 14, 2, 13, 0.0F);
/* 146 */     this.ArmGunR2_1 = new ModelRenderer(this, 46, 114);
/* 147 */     this.ArmGunR2_1.func_78793_a(-0.5F, 7.0F, 1.7F);
/* 148 */     this.ArmGunR2_1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
/* 149 */     this.Back = new ModelRenderer(this, 82, 62);
/* 150 */     this.Back.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.Back.func_78790_a(-4.5F, -5.4F, 6.5F, 9, 14, 6, 0.0F);
/* 152 */     this.Leg1L = new ModelRenderer(this, 1, 71);
/* 153 */     this.Leg1L.func_78793_a(10.7F, -9.5F, 1.5F);
/* 154 */     this.Leg1L.func_78790_a(-3.0F, -2.0F, -3.0F, 5, 7, 6, 0.0F);
/* 155 */     this.Tail1 = new ModelRenderer(this, 127, 28);
/* 156 */     this.Tail1.func_78793_a(0.0F, -4.6F, 11.0F);
/* 157 */     this.Tail1.func_78790_a(-1.5F, -9.0F, -1.5F, 3, 9, 3, 0.0F);
/* 158 */     setRotateAngle(this.Tail1, -0.3642502F, 0.0F, 0.0F);
/* 159 */     this.FootR = new ModelRenderer(this, 1, 113);
/* 160 */     this.FootR.func_78793_a(0.0F, 17.0F, 0.0F);
/* 161 */     this.FootR.func_78790_a(-2.0F, 0.0F, -6.0F, 4, 2, 11, 0.0F);
/* 162 */     this.BodyFront = new ModelRenderer(this, 0, 54);
/* 163 */     this.BodyFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 164 */     this.BodyFront.func_78790_a(-7.0F, -6.5F, -8.9F, 14, 13, 2, 0.0F);
/* 165 */     this.Leg1R = new ModelRenderer(this, 1, 71);
/* 166 */     this.Leg1R.func_78793_a(-10.7F, -9.5F, 1.5F);
/* 167 */     this.Leg1R.func_78790_a(-2.0F, -2.0F, -3.0F, 5, 7, 6, 0.0F);
/* 168 */     this.ArmL2 = new ModelRenderer(this, 46, 91);
/* 169 */     this.ArmL2.field_78809_i = true;
/* 170 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 171 */     this.ArmL2.func_78790_a(-0.6F, -0.4F, -1.2F, 2, 7, 2, 0.0F);
/* 172 */     setRotateAngle(this.ArmL2, 0.0F, 0.0F, -1.0471976F);
/* 173 */     this.ArmL1 = new ModelRenderer(this, 0, 0);
/* 174 */     this.ArmL1.func_78793_a(10.0F, -18.0F, 0.0F);
/* 175 */     this.ArmL1.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/* 176 */     this.PlateL = new ModelRenderer(this, 44, 72);
/* 177 */     this.PlateL.field_78809_i = true;
/* 178 */     this.PlateL.func_78793_a(10.5F, -5.0F, 0.5F);
/* 179 */     this.PlateL.func_78790_a(0.0F, -0.4F, -3.5F, 1, 10, 7, 0.0F);
/* 180 */     setRotateAngle(this.PlateL, 0.0F, 0.0F, -1.7453293F);
/* 181 */     this.ArmGunR2 = new ModelRenderer(this, 46, 114);
/* 182 */     this.ArmGunR2.func_78793_a(0.5F, 7.0F, 1.7F);
/* 183 */     this.ArmGunR2.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
/* 184 */     this.Tail4 = new ModelRenderer(this, 141, 29);
/* 185 */     this.Tail4.func_78793_a(0.0F, -8.6F, 0.0F);
/* 186 */     this.Tail4.func_78790_a(-1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F);
/* 187 */     setRotateAngle(this.Tail4, 0.5235988F, 0.0F, 0.0F);
/* 188 */     this.BodyL = new ModelRenderer(this, 44, 42);
/* 189 */     this.BodyL.field_78809_i = true;
/* 190 */     this.BodyL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 191 */     this.BodyL.func_78790_a(8.5F, -6.5F, -6.5F, 2, 13, 14, 0.0F);
/* 192 */     this.Body.func_78792_a(this.Head1);
/* 193 */     this.Leg2L.func_78792_a(this.Leg3L);
/* 194 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 195 */     this.Leg3R.func_78792_a(this.KneeR);
/* 196 */     this.BodyBottom.func_78792_a(this.Bottom_1);
/* 197 */     this.Tail4.func_78792_a(this.Bottom);
/* 198 */     this.Body.func_78792_a(this.BodyTop);
/* 199 */     this.ArmR3.func_78792_a(this.ArmGunR1_1);
/* 200 */     this.Body.func_78792_a(this.BodyBack);
/* 201 */     this.Body.func_78792_a(this.BodyR);
/* 202 */     this.Leg3L.func_78792_a(this.KneeL);
/* 203 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 204 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 205 */     this.ArmL3.func_78792_a(this.ArmGunR1);
/* 206 */     this.Leg3L.func_78792_a(this.FootL);
/* 207 */     this.Tail2.func_78792_a(this.Tail3);
/* 208 */     this.Leg1R.func_78792_a(this.Leg2R);
/* 209 */     this.Leg2R.func_78792_a(this.Leg3R);
/* 210 */     this.Leg1L.func_78792_a(this.Leg2L);
/* 211 */     this.Head1.func_78792_a(this.Head2);
/* 212 */     this.Tail1.func_78792_a(this.Tail2);
/* 213 */     this.BodyR.func_78792_a(this.PlateR);
/* 214 */     this.Body.func_78792_a(this.BodyBottom);
/* 215 */     this.ArmR3.func_78792_a(this.ArmGunR2_1);
/* 216 */     this.BodyBack.func_78792_a(this.Back);
/* 217 */     this.Back.func_78792_a(this.Tail1);
/* 218 */     this.Leg3R.func_78792_a(this.FootR);
/* 219 */     this.Body.func_78792_a(this.BodyFront);
/* 220 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 221 */     this.BodyL.func_78792_a(this.PlateL);
/* 222 */     this.ArmL3.func_78792_a(this.ArmGunR2);
/* 223 */     this.Tail3.func_78792_a(this.Tail4);
/* 224 */     this.Body.func_78792_a(this.BodyL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 229 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 231 */     GL11.glPushMatrix();
/* 232 */     float F = 1.4F;
/* 233 */     JGRenderHelper.modelScalePositionHelper(1.4F);
/*     */     
/* 235 */     this.Body.func_78785_a(f5);
/* 236 */     this.ArmR1.func_78785_a(f5);
/* 237 */     this.ArmL1.func_78785_a(f5);
/* 238 */     this.Leg1L.func_78785_a(f5);
/* 239 */     this.Leg1R.func_78785_a(f5);
/*     */     
/* 241 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 246 */     modelRenderer.field_78795_f = x;
/* 247 */     modelRenderer.field_78796_g = y;
/* 248 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 252 */     int calc = par7Entity.field_70173_aa;
/* 253 */     if (calc > 100) calc -= 100; 
/* 254 */     float r = 360.0F;
/* 255 */     float r2 = 180.0F;
/* 256 */     float n4 = par4;
/* 257 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 261 */     float ex = par7Entity.field_70173_aa;
/* 262 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 263 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 265 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 266 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 315 */     this.Leg1R.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 316 */     this.Leg1L.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 317 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 318 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 320 */     this.Leg1R.field_78796_g = 0.0F;
/* 321 */     this.Leg1L.field_78796_g = 0.0F;
/* 322 */     this.ArmR1.field_78796_g = 0.0F;
/* 323 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbpilaf\ModelShuMecha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */