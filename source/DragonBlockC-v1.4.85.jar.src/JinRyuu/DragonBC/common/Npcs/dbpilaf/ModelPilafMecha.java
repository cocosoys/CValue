/*     */ package JinRyuu.DragonBC.common.Npcs.dbpilaf;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelPilafMecha
/*     */   extends ModelBase {
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
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
/*     */   public ModelRenderer PlateR;
/*     */   public ModelRenderer PlateL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmR4;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmL4;
/*     */   public ModelRenderer Leg2L;
/*     */   public ModelRenderer Leg3L;
/*     */   public ModelRenderer KneeL;
/*     */   public ModelRenderer FootL;
/*     */   public ModelRenderer Leg2R;
/*     */   public ModelRenderer Leg3R;
/*     */   public ModelRenderer KneeR;
/*     */   public ModelRenderer FootR;
/*     */   
/*     */   public ModelPilafMecha() {
/*  42 */     this.field_78090_t = 128;
/*  43 */     this.field_78089_u = 128;
/*  44 */     this.Head2 = new ModelRenderer(this, 78, 26);
/*  45 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Head2.func_78790_a(-4.0F, -10.5F, -10.0F, 8, 12, 11, 0.0F);
/*  47 */     this.FootR = new ModelRenderer(this, 1, 91);
/*  48 */     this.FootR.func_78793_a(0.0F, 9.0F, 0.0F);
/*  49 */     this.FootR.func_78790_a(-2.0F, -0.1F, -6.0F, 4, 2, 11, 0.0F);
/*  50 */     this.Back = new ModelRenderer(this, 82, 62);
/*  51 */     this.Back.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.Back.func_78790_a(-4.0F, -8.5F, 4.7F, 8, 11, 6, 0.0F);
/*  53 */     this.BodyL = new ModelRenderer(this, 44, 29);
/*  54 */     this.BodyL.field_78809_i = true;
/*  55 */     this.BodyL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.BodyL.func_78790_a(7.5F, -6.5F, -6.0F, 2, 10, 11, 0.0F);
/*  57 */     this.KneeR = new ModelRenderer(this, 20, 79);
/*  58 */     this.KneeR.func_78793_a(0.1F, 1.6F, 0.0F);
/*  59 */     this.KneeR.func_78790_a(-1.0F, -2.7F, -3.0F, 2, 3, 2, 0.0F);
/*  60 */     this.ArmL2 = new ModelRenderer(this, 43, 71);
/*  61 */     this.ArmL2.field_78809_i = true;
/*  62 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.ArmL2.func_78790_a(-0.6F, -0.4F, -1.2F, 2, 7, 2, 0.0F);
/*  64 */     setRotateAngle(this.ArmL2, 0.0F, 0.0F, -0.6981317F);
/*  65 */     this.ArmR2 = new ModelRenderer(this, 43, 71);
/*  66 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.ArmR2.func_78790_a(-1.3F, -0.4F, -1.1F, 2, 7, 2, 0.0F);
/*  68 */     setRotateAngle(this.ArmR2, 0.0F, 0.0F, 0.6981317F);
/*  69 */     this.BodyR = new ModelRenderer(this, 44, 29);
/*  70 */     this.BodyR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.BodyR.func_78790_a(-9.5F, -6.5F, -6.0F, 2, 10, 11, 0.0F);
/*  72 */     this.Leg2L = new ModelRenderer(this, 20, 68);
/*  73 */     this.Leg2L.field_78809_i = true;
/*  74 */     this.Leg2L.func_78793_a(0.0F, 1.6F, 0.0F);
/*  75 */     this.Leg2L.func_78790_a(-1.0F, -0.1F, -1.0F, 2, 6, 2, 0.0F);
/*  76 */     setRotateAngle(this.Leg2L, -0.31415927F, -0.06981317F, -0.6370452F);
/*  77 */     this.PlateR = new ModelRenderer(this, 44, 52);
/*  78 */     this.PlateR.func_78793_a(-10.0F, -5.0F, 0.0F);
/*  79 */     this.PlateR.func_78790_a(-1.0F, -0.4F, -3.5F, 1, 8, 7, 0.0F);
/*  80 */     setRotateAngle(this.PlateR, 0.0F, 0.0F, 1.7453293F);
/*  81 */     this.ArmR3 = new ModelRenderer(this, 44, 82);
/*  82 */     this.ArmR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.ArmR3.func_78790_a(-2.5F, 5.8F, 1.5F, 4, 7, 3, 0.0F);
/*  84 */     setRotateAngle(this.ArmR3, -0.4553564F, 0.0F, 0.0F);
/*  85 */     this.Leg1R = new ModelRenderer(this, 3, 68);
/*  86 */     this.Leg1R.func_78793_a(-5.5F, 7.4F, 1.5F);
/*  87 */     this.Leg1R.func_78790_a(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
/*  88 */     this.FootL = new ModelRenderer(this, 1, 91);
/*  89 */     this.FootL.field_78809_i = true;
/*  90 */     this.FootL.func_78793_a(0.0F, 9.0F, 0.0F);
/*  91 */     this.FootL.func_78790_a(-2.0F, -0.1F, -6.0F, 4, 2, 11, 0.0F);
/*  92 */     this.PlateL = new ModelRenderer(this, 44, 52);
/*  93 */     this.PlateL.field_78809_i = true;
/*  94 */     this.PlateL.func_78793_a(10.0F, -5.0F, 0.0F);
/*  95 */     this.PlateL.func_78790_a(0.0F, -0.4F, -3.5F, 1, 8, 7, 0.0F);
/*  96 */     setRotateAngle(this.PlateL, 0.0F, 0.0F, -1.7453293F);
/*  97 */     this.BodyTop = new ModelRenderer(this, 0, 34);
/*  98 */     this.BodyTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     this.BodyTop.func_78790_a(-5.5F, -9.6F, -5.0F, 11, 2, 10, 0.0F);
/* 100 */     this.Leg3L = new ModelRenderer(this, 1, 76);
/* 101 */     this.Leg3L.field_78809_i = true;
/* 102 */     this.Leg3L.func_78793_a(0.0F, 5.3F, -0.1F);
/* 103 */     this.Leg3L.func_78790_a(-2.0F, -0.1F, -2.0F, 4, 9, 4, 0.0F);
/* 104 */     setRotateAngle(this.Leg3L, 0.31415927F, -0.14486232F, 0.6161012F);
/* 105 */     this.ArmR1 = new ModelRenderer(this, 0, 0);
/* 106 */     this.ArmR1.func_78793_a(-9.0F, 1.0F, 0.0F);
/* 107 */     this.ArmR1.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/* 108 */     this.Body = new ModelRenderer(this, 0, 0);
/* 109 */     this.Body.func_78793_a(0.0F, 4.0F, 0.0F);
/* 110 */     this.Body.func_78790_a(-7.5F, -8.0F, -7.0F, 15, 13, 13, 0.0F);
/* 111 */     this.Head1 = new ModelRenderer(this, 72, 0);
/* 112 */     this.Head1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.Head1.func_78790_a(-5.0F, -10.0F, -9.6F, 10, 12, 12, 0.0F);
/* 114 */     this.ArmR4 = new ModelRenderer(this, 44, 93);
/* 115 */     this.ArmR4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.ArmR4.func_78790_a(-2.4F, 12.6F, 1.0F, 3, 4, 4, 0.0F);
/* 117 */     setRotateAngle(this.ArmR4, -0.4553564F, -0.1829105F, 0.0F);
/* 118 */     this.BodyFront = new ModelRenderer(this, 1, 51);
/* 119 */     this.BodyFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 120 */     this.BodyFront.func_78790_a(-6.0F, -6.5F, -9.0F, 12, 10, 2, 0.0F);
/* 121 */     setRotateAngle(this.BodyFront, 0.0F, -0.014486233F, 0.0F);
/* 122 */     this.ArmL3 = new ModelRenderer(this, 44, 82);
/* 123 */     this.ArmL3.field_78809_i = true;
/* 124 */     this.ArmL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 125 */     this.ArmL3.func_78790_a(-1.4F, 5.8F, 1.5F, 4, 7, 3, 0.0F);
/* 126 */     setRotateAngle(this.ArmL3, -0.4553564F, 0.0F, 0.0F);
/* 127 */     this.ArmL4 = new ModelRenderer(this, 44, 93);
/* 128 */     this.ArmL4.field_78809_i = true;
/* 129 */     this.ArmL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.ArmL4.func_78790_a(-0.6F, 12.6F, 1.0F, 3, 4, 4, 0.0F);
/* 131 */     setRotateAngle(this.ArmL4, -0.4553564F, 0.16475908F, 0.0F);
/* 132 */     this.Leg2R = new ModelRenderer(this, 20, 68);
/* 133 */     this.Leg2R.func_78793_a(0.0F, 1.6F, 0.0F);
/* 134 */     this.Leg2R.func_78790_a(-1.0F, -0.1F, -1.0F, 2, 6, 2, 0.0F);
/* 135 */     setRotateAngle(this.Leg2R, -0.31415927F, 0.06981317F, 0.6370452F);
/* 136 */     this.ArmL1 = new ModelRenderer(this, 0, 0);
/* 137 */     this.ArmL1.func_78793_a(9.0F, 1.0F, 0.0F);
/* 138 */     this.ArmL1.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/* 139 */     this.Leg3R = new ModelRenderer(this, 1, 76);
/* 140 */     this.Leg3R.func_78793_a(0.0F, 5.3F, -0.1F);
/* 141 */     this.Leg3R.func_78790_a(-2.0F, -0.1F, -2.0F, 4, 9, 4, 0.0F);
/* 142 */     setRotateAngle(this.Leg3R, 0.31415927F, 0.14486232F, -0.6161012F);
/* 143 */     this.BodyBottom = new ModelRenderer(this, 0, 34);
/* 144 */     this.BodyBottom.func_78793_a(0.0F, -2.5F, 0.0F);
/* 145 */     this.BodyBottom.func_78790_a(-5.5F, 7.5F, -5.0F, 11, 2, 10, 0.0F);
/* 146 */     this.Leg1L = new ModelRenderer(this, 3, 68);
/* 147 */     this.Leg1L.func_78793_a(5.5F, 7.4F, 1.5F);
/* 148 */     this.Leg1L.func_78790_a(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
/* 149 */     this.KneeL = new ModelRenderer(this, 20, 79);
/* 150 */     this.KneeL.field_78809_i = true;
/* 151 */     this.KneeL.func_78793_a(0.1F, 1.6F, 0.0F);
/* 152 */     this.KneeL.func_78790_a(-1.0F, -2.7F, -3.0F, 2, 3, 2, 0.0F);
/* 153 */     this.BodyBack = new ModelRenderer(this, 1, 51);
/* 154 */     this.BodyBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.BodyBack.func_78790_a(-6.0F, -6.5F, 6.0F, 12, 10, 2, 0.0F);
/* 156 */     this.Head1.func_78792_a(this.Head2);
/* 157 */     this.Leg3R.func_78792_a(this.FootR);
/* 158 */     this.BodyBack.func_78792_a(this.Back);
/* 159 */     this.Body.func_78792_a(this.BodyL);
/* 160 */     this.Leg3R.func_78792_a(this.KneeR);
/* 161 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 162 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 163 */     this.Body.func_78792_a(this.BodyR);
/* 164 */     this.Leg1L.func_78792_a(this.Leg2L);
/* 165 */     this.BodyR.func_78792_a(this.PlateR);
/* 166 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 167 */     this.Leg3L.func_78792_a(this.FootL);
/* 168 */     this.BodyL.func_78792_a(this.PlateL);
/* 169 */     this.Body.func_78792_a(this.BodyTop);
/* 170 */     this.Leg2L.func_78792_a(this.Leg3L);
/* 171 */     this.Body.func_78792_a(this.Head1);
/* 172 */     this.ArmR2.func_78792_a(this.ArmR4);
/* 173 */     this.Body.func_78792_a(this.BodyFront);
/* 174 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 175 */     this.ArmL2.func_78792_a(this.ArmL4);
/* 176 */     this.Leg1R.func_78792_a(this.Leg2R);
/* 177 */     this.Leg2R.func_78792_a(this.Leg3R);
/* 178 */     this.Body.func_78792_a(this.BodyBottom);
/* 179 */     this.Leg3L.func_78792_a(this.KneeL);
/* 180 */     this.Body.func_78792_a(this.BodyBack);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 185 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 187 */     this.Body.func_78785_a(f5);
/* 188 */     this.ArmR1.func_78785_a(f5);
/* 189 */     this.ArmL1.func_78785_a(f5);
/* 190 */     this.Leg1L.func_78785_a(f5);
/*     */     
/* 192 */     this.Leg1R.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 199 */     modelRenderer.field_78795_f = x;
/* 200 */     modelRenderer.field_78796_g = y;
/* 201 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 205 */     int calc = par7Entity.field_70173_aa;
/* 206 */     if (calc > 100) calc -= 100; 
/* 207 */     float r = 360.0F;
/* 208 */     float r2 = 180.0F;
/* 209 */     float n4 = par4;
/* 210 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 214 */     float ex = par7Entity.field_70173_aa;
/* 215 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 216 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 218 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 219 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 268 */     this.Leg1R.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 269 */     this.Leg1L.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 270 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 271 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 273 */     this.Leg1R.field_78796_g = 0.0F;
/* 274 */     this.Leg1L.field_78796_g = 0.0F;
/* 275 */     this.ArmR1.field_78796_g = 0.0F;
/* 276 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbpilaf\ModelPilafMecha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */