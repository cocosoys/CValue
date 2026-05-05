/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelPanchia
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer Arm1L;
/*     */   public ModelRenderer Arm1R;
/*     */   public ModelRenderer Leg1R;
/*     */   public ModelRenderer Leg1L;
/*     */   public ModelRenderer Headgear1;
/*     */   public ModelRenderer Headgear2;
/*     */   public ModelRenderer Headgear3;
/*     */   public ModelRenderer Side1L;
/*     */   public ModelRenderer Side1R;
/*     */   public ModelRenderer Side1F;
/*     */   public ModelRenderer Side1B;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Side2B;
/*     */   public ModelRenderer Side2R;
/*     */   public ModelRenderer Side2L;
/*     */   public ModelRenderer Side2F;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer BodyBottom1;
/*     */   public ModelRenderer extraR;
/*     */   public ModelRenderer extraL;
/*     */   public ModelRenderer BodyBottom2;
/*     */   public ModelRenderer BodyBottom3;
/*     */   public ModelRenderer Arm2L;
/*     */   public ModelRenderer Arm3L;
/*     */   public ModelRenderer Arm4L;
/*     */   public ModelRenderer Arm5L;
/*     */   public ModelRenderer HandL;
/*     */   public ModelRenderer Arm2R;
/*     */   public ModelRenderer Arm3R;
/*     */   public ModelRenderer Arm4R;
/*     */   public ModelRenderer Arm5R;
/*     */   public ModelRenderer HandR;
/*     */   public ModelRenderer Leg2R;
/*     */   public ModelRenderer Leg3R;
/*     */   public ModelRenderer KneeR;
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer Leg2L;
/*     */   public ModelRenderer Leg3L;
/*     */   public ModelRenderer FootL;
/*     */   public ModelRenderer KneeL;
/*     */   
/*     */   public ModelPanchia() {
/*  56 */     this.field_78090_t = 256;
/*  57 */     this.field_78089_u = 128;
/*  58 */     this.Arm4L = new ModelRenderer(this, 131, 2);
/*  59 */     this.Arm4L.field_78809_i = true;
/*  60 */     this.Arm4L.func_78793_a(0.0F, 5.9F, 0.0F);
/*  61 */     this.Arm4L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/*  62 */     setRotateAngle(this.Arm4L, -0.057595864F, 0.0F, 0.0F);
/*  63 */     this.BodyBottom1 = new ModelRenderer(this, 44, 101);
/*  64 */     this.BodyBottom1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.BodyBottom1.func_78790_a(-11.0F, 4.3F, -11.0F, 22, 3, 22, 0.0F);
/*  66 */     this.BodyBottom2 = new ModelRenderer(this, 1, 99);
/*  67 */     this.BodyBottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.BodyBottom2.func_78790_a(-2.5F, 4.1F, -6.6F, 5, 5, 13, 0.0F);
/*  69 */     this.BodyBottom3 = new ModelRenderer(this, 1, 119);
/*  70 */     this.BodyBottom3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.BodyBottom3.func_78790_a(-6.5F, 4.0F, -2.1F, 13, 3, 4, 0.0F);
/*  72 */     this.FootR = new ModelRenderer(this, 19, 78);
/*  73 */     this.FootR.func_78793_a(0.0F, 12.2F, 0.0F);
/*  74 */     this.FootR.func_78790_a(-3.5F, -0.1F, -6.9F, 7, 4, 11, 0.0F);
/*  75 */     this.Leg1R = new ModelRenderer(this, 2, 42);
/*  76 */     this.Leg1R.func_78793_a(-7.0F, -3.0F, 0.0F);
/*  77 */     this.Leg1R.func_78790_a(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
/*  78 */     this.Arm3L = new ModelRenderer(this, 131, 2);
/*  79 */     this.Arm3L.field_78809_i = true;
/*  80 */     this.Arm3L.func_78793_a(0.0F, 5.9F, 0.0F);
/*  81 */     this.Arm3L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/*  82 */     setRotateAngle(this.Arm3L, -0.057595864F, 0.0F, 0.0F);
/*  83 */     this.Arm2L = new ModelRenderer(this, 131, 2);
/*  84 */     this.Arm2L.field_78809_i = true;
/*  85 */     this.Arm2L.func_78793_a(1.0F, 1.6F, 0.0F);
/*  86 */     this.Arm2L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/*  87 */     setRotateAngle(this.Arm2L, -0.057595864F, 0.0F, -0.31869712F);
/*  88 */     this.Leg3L = new ModelRenderer(this, 3, 61);
/*  89 */     this.Leg3L.field_78809_i = true;
/*  90 */     this.Leg3L.func_78793_a(0.0F, 8.8F, 0.0F);
/*  91 */     this.Leg3L.func_78790_a(-3.0F, -0.1F, -3.0F, 6, 13, 6, 0.0F);
/*  92 */     setRotateAngle(this.Leg3L, 0.05235988F, 0.0F, 0.0F);
/*  93 */     this.Body1 = new ModelRenderer(this, 122, 79);
/*  94 */     this.Body1.func_78793_a(0.0F, -8.4F, 0.0F);
/*  95 */     this.Body1.func_78790_a(-12.5F, -5.5F, -12.5F, 25, 10, 25, 0.0F);
/*  96 */     this.Arm1R = new ModelRenderer(this, 105, 2);
/*  97 */     this.Arm1R.func_78793_a(-14.0F, -22.8F, 0.5F);
/*  98 */     this.Arm1R.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  99 */     this.Side2B = new ModelRenderer(this, 109, 57);
/* 100 */     this.Side2B.func_78793_a(0.0F, -9.0F, 11.0F);
/* 101 */     this.Side2B.func_78790_a(-8.5F, -3.5F, 0.0F, 17, 7, 2, 0.0F);
/* 102 */     this.Headgear1 = new ModelRenderer(this, 61, 14);
/* 103 */     this.Headgear1.func_78793_a(0.0F, -2.8F, -4.1F);
/* 104 */     this.Headgear1.func_78790_a(-5.5F, -3.4F, -5.0F, 11, 2, 11, 0.0F);
/* 105 */     this.Side1R = new ModelRenderer(this, 203, 73);
/* 106 */     this.Side1R.func_78793_a(-12.8F, -0.5F, 0.0F);
/* 107 */     this.Side1R.func_78790_a(-1.7F, -5.0F, -8.5F, 2, 10, 18, 0.0F);
/* 108 */     this.FootL = new ModelRenderer(this, 19, 78);
/* 109 */     this.FootL.field_78809_i = true;
/* 110 */     this.FootL.func_78793_a(0.0F, 12.2F, 0.0F);
/* 111 */     this.FootL.func_78790_a(-3.5F, -0.1F, -6.9F, 7, 4, 11, 0.0F);
/* 112 */     this.Side1F = new ModelRenderer(this, 59, 83);
/* 113 */     this.Side1F.func_78793_a(0.0F, -0.5F, -12.8F);
/* 114 */     this.Side1F.func_78790_a(-9.5F, -5.0F, -1.7F, 19, 10, 2, 0.0F);
/* 115 */     this.Side2F = new ModelRenderer(this, 69, 57);
/* 116 */     this.Side2F.func_78793_a(0.0F, -9.0F, -11.3F);
/* 117 */     this.Side2F.func_78790_a(-8.5F, -3.5F, -1.7F, 17, 7, 2, 0.0F);
/* 118 */     this.HandL = new ModelRenderer(this, 150, 1);
/* 119 */     this.HandL.field_78809_i = true;
/* 120 */     this.HandL.func_78793_a(0.0F, 5.9F, 0.0F);
/* 121 */     this.HandL.func_78790_a(-2.8F, 0.1F, -4.5F, 6, 7, 8, 0.0F);
/* 122 */     setRotateAngle(this.HandL, -0.033161256F, 0.0F, 0.15882497F);
/* 123 */     this.Leg2L = new ModelRenderer(this, 24, 43);
/* 124 */     this.Leg2L.field_78809_i = true;
/* 125 */     this.Leg2L.func_78793_a(0.1F, 2.1F, 0.0F);
/* 126 */     this.Leg2L.func_78790_a(-2.0F, -0.1F, -2.0F, 4, 10, 4, 0.0F);
/* 127 */     setRotateAngle(this.Leg2L, -0.05235988F, 0.0F, 0.0F);
/* 128 */     this.Arm1L = new ModelRenderer(this, 105, 2);
/* 129 */     this.Arm1L.field_78809_i = true;
/* 130 */     this.Arm1L.func_78793_a(14.0F, -22.8F, 0.5F);
/* 131 */     this.Arm1L.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/* 132 */     this.Side2R = new ModelRenderer(this, 201, 41);
/* 133 */     this.Side2R.func_78793_a(-11.3F, -9.0F, 0.0F);
/* 134 */     this.Side2R.func_78790_a(-1.7F, -3.5F, -8.0F, 2, 7, 16, 0.0F);
/* 135 */     this.Headgear3 = new ModelRenderer(this, 87, 5);
/* 136 */     this.Headgear3.func_78793_a(0.0F, -1.6F, 0.0F);
/* 137 */     this.Headgear3.func_78790_a(-1.5F, -3.6F, -1.5F, 3, 4, 3, 0.0F);
/* 138 */     this.Side1B = new ModelRenderer(this, 103, 83);
/* 139 */     this.Side1B.func_78793_a(0.0F, -0.5F, 12.5F);
/* 140 */     this.Side1B.func_78790_a(-9.5F, -5.0F, 0.0F, 19, 10, 2, 0.0F);
/* 141 */     this.Leg1L = new ModelRenderer(this, 2, 42);
/* 142 */     this.Leg1L.field_78809_i = true;
/* 143 */     this.Leg1L.func_78793_a(7.0F, -3.0F, 0.0F);
/* 144 */     this.Leg1L.func_78790_a(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
/* 145 */     this.Body2 = new ModelRenderer(this, 127, 47);
/* 146 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.Body2.func_78790_a(-11.0F, -13.4F, -11.0F, 22, 8, 22, 0.0F);
/* 148 */     this.Headgear2 = new ModelRenderer(this, 59, 5);
/* 149 */     this.Headgear2.func_78793_a(0.0F, -3.1F, 0.0F);
/* 150 */     this.Headgear2.func_78790_a(-3.0F, -1.3F, -3.0F, 6, 1, 6, 0.0F);
/* 151 */     this.extraR = new ModelRenderer(this, 0, 0);
/* 152 */     this.extraR.func_78793_a(-7.5F, -2.0F, -13.7F);
/* 153 */     this.extraR.func_78790_a(-3.0F, -3.0F, -1.0F, 6, 6, 3, 0.0F);
/* 154 */     this.Leg3R = new ModelRenderer(this, 3, 61);
/* 155 */     this.Leg3R.func_78793_a(0.0F, 8.8F, 0.0F);
/* 156 */     this.Leg3R.func_78790_a(-3.0F, -0.1F, -3.0F, 6, 13, 6, 0.0F);
/* 157 */     setRotateAngle(this.Leg3R, 0.05235988F, 0.0F, 0.0F);
/* 158 */     this.Arm4R = new ModelRenderer(this, 131, 2);
/* 159 */     this.Arm4R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 160 */     this.Arm4R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 161 */     setRotateAngle(this.Arm4R, -0.057595864F, 0.0F, 0.0F);
/* 162 */     this.HandR = new ModelRenderer(this, 150, 1);
/* 163 */     this.HandR.func_78793_a(0.0F, 5.9F, 0.0F);
/* 164 */     this.HandR.func_78790_a(-2.8F, 0.1F, -4.5F, 6, 7, 8, 0.0F);
/* 165 */     setRotateAngle(this.HandR, -0.033161256F, 0.0F, -0.15882497F);
/* 166 */     this.ShoulderL = new ModelRenderer(this, 194, 18);
/* 167 */     this.ShoulderL.field_78809_i = true;
/* 168 */     this.ShoulderL.func_78793_a(6.0F, -15.0F, 0.5F);
/* 169 */     this.ShoulderL.func_78790_a(-0.3F, -4.0F, -5.0F, 12, 8, 10, 0.0F);
/* 170 */     this.Leg2R = new ModelRenderer(this, 24, 43);
/* 171 */     this.Leg2R.func_78793_a(0.1F, 2.1F, 0.0F);
/* 172 */     this.Leg2R.func_78790_a(-2.0F, -0.1F, -2.0F, 4, 10, 4, 0.0F);
/* 173 */     setRotateAngle(this.Leg2R, -0.05235988F, 0.0F, 0.0F);
/* 174 */     this.ShoulderR = new ModelRenderer(this, 194, 18);
/* 175 */     this.ShoulderR.func_78793_a(-6.0F, -15.0F, 0.5F);
/* 176 */     this.ShoulderR.func_78790_a(-11.6F, -4.0F, -5.0F, 12, 8, 10, 0.0F);
/* 177 */     this.KneeR = new ModelRenderer(this, 29, 66);
/* 178 */     this.KneeR.func_78793_a(0.1F, 1.6F, 0.0F);
/* 179 */     this.KneeR.func_78790_a(-2.0F, -3.6F, -4.0F, 4, 5, 2, 0.0F);
/* 180 */     this.Arm5L = new ModelRenderer(this, 131, 2);
/* 181 */     this.Arm5L.field_78809_i = true;
/* 182 */     this.Arm5L.func_78793_a(0.0F, 5.9F, 0.0F);
/* 183 */     this.Arm5L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 184 */     setRotateAngle(this.Arm5L, -0.057595864F, 0.0F, 0.0F);
/* 185 */     this.Arm3R = new ModelRenderer(this, 131, 2);
/* 186 */     this.Arm3R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 187 */     this.Arm3R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 188 */     setRotateAngle(this.Arm3R, -0.057595864F, 0.0F, 0.0F);
/* 189 */     this.KneeL = new ModelRenderer(this, 29, 66);
/* 190 */     this.KneeL.field_78809_i = true;
/* 191 */     this.KneeL.func_78793_a(0.1F, 1.6F, 0.0F);
/* 192 */     this.KneeL.func_78790_a(-2.0F, -3.6F, -4.0F, 4, 5, 2, 0.0F);
/* 193 */     this.Head = new ModelRenderer(this, 0, 0);
/* 194 */     this.Head.func_78793_a(0.0F, -25.4F, 0.0F);
/* 195 */     this.Head.func_78790_a(-7.5F, -4.2F, -14.1F, 15, 11, 28, 0.0F);
/* 196 */     this.extraL = new ModelRenderer(this, 0, 0);
/* 197 */     this.extraL.func_78793_a(7.5F, -2.0F, -13.7F);
/* 198 */     this.extraL.func_78790_a(-3.0F, -3.0F, -1.0F, 6, 6, 3, 0.0F);
/* 199 */     this.Arm2R = new ModelRenderer(this, 131, 2);
/* 200 */     this.Arm2R.func_78793_a(-1.0F, 1.6F, 0.0F);
/* 201 */     this.Arm2R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 202 */     setRotateAngle(this.Arm2R, -0.057595864F, 0.0F, 0.31869712F);
/* 203 */     this.Side1L = new ModelRenderer(this, 203, 73);
/* 204 */     this.Side1L.field_78809_i = true;
/* 205 */     this.Side1L.func_78793_a(12.8F, -0.5F, 0.0F);
/* 206 */     this.Side1L.func_78790_a(-0.3F, -5.0F, -8.5F, 2, 10, 18, 0.0F);
/* 207 */     this.Arm5R = new ModelRenderer(this, 131, 2);
/* 208 */     this.Arm5R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 209 */     this.Arm5R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 210 */     setRotateAngle(this.Arm5R, -0.057595864F, 0.0F, 0.0F);
/* 211 */     this.Body3 = new ModelRenderer(this, 132, 23);
/* 212 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 213 */     this.Body3.func_78790_a(-9.5F, -16.2F, -9.5F, 19, 3, 19, 0.0F);
/* 214 */     this.Side2L = new ModelRenderer(this, 201, 41);
/* 215 */     this.Side2L.field_78809_i = true;
/* 216 */     this.Side2L.func_78793_a(11.2F, -9.0F, 0.0F);
/* 217 */     this.Side2L.func_78790_a(-0.3F, -3.5F, -8.0F, 2, 7, 16, 0.0F);
/* 218 */     this.Arm3L.func_78792_a(this.Arm4L);
/* 219 */     this.Body2.func_78792_a(this.BodyBottom1);
/* 220 */     this.BodyBottom1.func_78792_a(this.BodyBottom2);
/* 221 */     this.BodyBottom2.func_78792_a(this.BodyBottom3);
/* 222 */     this.Leg3R.func_78792_a(this.FootR);
/* 223 */     this.Arm2L.func_78792_a(this.Arm3L);
/* 224 */     this.Arm1L.func_78792_a(this.Arm2L);
/* 225 */     this.Leg2L.func_78792_a(this.Leg3L);
/* 226 */     this.Body2.func_78792_a(this.Side2B);
/* 227 */     this.Head.func_78792_a(this.Headgear1);
/* 228 */     this.Body1.func_78792_a(this.Side1R);
/* 229 */     this.Leg3L.func_78792_a(this.FootL);
/* 230 */     this.Body1.func_78792_a(this.Side1F);
/* 231 */     this.Body2.func_78792_a(this.Side2F);
/* 232 */     this.Arm5L.func_78792_a(this.HandL);
/* 233 */     this.Leg1L.func_78792_a(this.Leg2L);
/* 234 */     this.Body2.func_78792_a(this.Side2R);
/* 235 */     this.Headgear2.func_78792_a(this.Headgear3);
/* 236 */     this.Body1.func_78792_a(this.Side1B);
/* 237 */     this.Body1.func_78792_a(this.Body2);
/* 238 */     this.Headgear1.func_78792_a(this.Headgear2);
/* 239 */     this.Body2.func_78792_a(this.extraR);
/* 240 */     this.Leg2R.func_78792_a(this.Leg3R);
/* 241 */     this.Arm3R.func_78792_a(this.Arm4R);
/* 242 */     this.Arm5R.func_78792_a(this.HandR);
/* 243 */     this.Body2.func_78792_a(this.ShoulderL);
/* 244 */     this.Leg1R.func_78792_a(this.Leg2R);
/* 245 */     this.Body2.func_78792_a(this.ShoulderR);
/* 246 */     this.Leg3R.func_78792_a(this.KneeR);
/* 247 */     this.Arm4L.func_78792_a(this.Arm5L);
/* 248 */     this.Arm2R.func_78792_a(this.Arm3R);
/* 249 */     this.Leg3L.func_78792_a(this.KneeL);
/* 250 */     this.Body2.func_78792_a(this.extraL);
/* 251 */     this.Arm1R.func_78792_a(this.Arm2R);
/* 252 */     this.Body1.func_78792_a(this.Side1L);
/* 253 */     this.Arm4R.func_78792_a(this.Arm5R);
/* 254 */     this.Body2.func_78792_a(this.Body3);
/* 255 */     this.Body2.func_78792_a(this.Side2L);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 260 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 263 */     this.Head.func_78785_a(f5);
/* 264 */     this.Arm1R.func_78785_a(f5);
/* 265 */     this.Leg1R.func_78785_a(f5);
/* 266 */     this.Arm1L.func_78785_a(f5);
/* 267 */     this.Body1.func_78785_a(f5);
/* 268 */     this.Leg1L.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 274 */     modelRenderer.field_78795_f = x;
/* 275 */     modelRenderer.field_78796_g = y;
/* 276 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 280 */     int calc = par7Entity.field_70173_aa;
/* 281 */     if (calc > 100) calc -= 100; 
/* 282 */     float r = 360.0F;
/* 283 */     float r2 = 180.0F;
/* 284 */     float n4 = par4;
/* 285 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 289 */     float ex = par7Entity.field_70173_aa;
/* 290 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 291 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 293 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 294 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 340 */     this.Leg1R.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 341 */     this.Leg1L.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */ 
/*     */ 
/*     */     
/* 345 */     this.Leg1R.field_78796_g = 0.0F;
/* 346 */     this.Leg1L.field_78796_g = 0.0F;
/* 347 */     this.Arm1R.field_78796_g = 0.0F;
/* 348 */     this.Arm1L.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 355 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelPanchia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */