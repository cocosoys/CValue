/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelMagetta
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer BodyBase;
/*     */   public ModelRenderer HeadBottom;
/*     */   public ModelRenderer Leg1R;
/*     */   public ModelRenderer Arm1L;
/*     */   public ModelRenderer Arm1R;
/*     */   public ModelRenderer Leg1L;
/*     */   public ModelRenderer BodyTopSideR;
/*     */   public ModelRenderer BodyTopsideL;
/*     */   public ModelRenderer BodyBottom1;
/*     */   public ModelRenderer BodySideL;
/*     */   public ModelRenderer BodyMid;
/*     */   public ModelRenderer BodySideR;
/*     */   public ModelRenderer BodyBottom2;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer HeadTop1;
/*     */   public ModelRenderer HeadSideL;
/*     */   public ModelRenderer HeadSideR;
/*     */   public ModelRenderer HeadTop2;
/*     */   public ModelRenderer Leg2;
/*     */   public ModelRenderer Leg3;
/*     */   public ModelRenderer Leg4;
/*     */   public ModelRenderer LegGuardR;
/*     */   public ModelRenderer Leg5;
/*     */   public ModelRenderer Leg6;
/*     */   public ModelRenderer Arm2L;
/*     */   public ModelRenderer Arm3L;
/*     */   public ModelRenderer Arm4L;
/*     */   public ModelRenderer ArmGuardL;
/*     */   public ModelRenderer Arm5L;
/*     */   public ModelRenderer Arm6L;
/*     */   public ModelRenderer Arm2R;
/*     */   public ModelRenderer Arm3R;
/*     */   public ModelRenderer Arm4R;
/*     */   public ModelRenderer ArmGuardR;
/*     */   public ModelRenderer Arm5R;
/*     */   public ModelRenderer Arm6R;
/*     */   public ModelRenderer Leg2_1;
/*     */   public ModelRenderer Leg3_1;
/*     */   public ModelRenderer Leg4_1;
/*     */   public ModelRenderer LegGuardL;
/*     */   public ModelRenderer Leg5_1;
/*     */   public ModelRenderer Leg6_1;
/*     */   
/*     */   public ModelMagetta() {
/*  57 */     this.field_78090_t = 128;
/*  58 */     this.field_78089_u = 64;
/*  59 */     this.Head = new ModelRenderer(this, 59, 5);
/*  60 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Head.func_78790_a(-3.0F, -4.9F, -2.5F, 6, 4, 5, 0.0F);
/*  62 */     this.Arm1R = new ModelRenderer(this, 111, 7);
/*  63 */     this.Arm1R.func_78793_a(-9.3F, -6.4F, 0.0F);
/*  64 */     this.Arm1R.func_78790_a(-2.0F, -1.8F, -2.0F, 4, 4, 4, 0.0F);
/*  65 */     this.Arm2R = new ModelRenderer(this, 117, 16);
/*  66 */     this.Arm2R.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.Arm2R.func_78790_a(-1.3F, 2.2F, -0.5F, 1, 4, 1, 0.0F);
/*  68 */     setRotateAngle(this.Arm2R, 0.0F, 0.0F, 0.28012535F);
/*  69 */     this.Arm1L = new ModelRenderer(this, 111, 7);
/*  70 */     this.Arm1L.field_78809_i = true;
/*  71 */     this.Arm1L.func_78793_a(9.3F, -6.4F, 0.0F);
/*  72 */     this.Arm1L.func_78790_a(-2.0F, -1.8F, -2.0F, 4, 4, 4, 0.0F);
/*  73 */     this.BodyBottom1 = new ModelRenderer(this, 4, 34);
/*  74 */     this.BodyBottom1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.BodyBottom1.func_78790_a(-4.0F, 12.7F, -3.5F, 8, 3, 7, 0.0F);
/*  76 */     this.Arm4L = new ModelRenderer(this, 103, 28);
/*  77 */     this.Arm4L.field_78809_i = true;
/*  78 */     this.Arm4L.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Arm4L.func_78790_a(-1.9F, 6.8F, -3.0F, 6, 3, 6, 0.0F);
/*  80 */     this.BodySideR = new ModelRenderer(this, 1, 23);
/*  81 */     this.BodySideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.BodySideR.func_78790_a(-5.5F, 7.5F, -3.5F, 3, 3, 7, 0.0F);
/*  83 */     this.Leg2_1 = new ModelRenderer(this, 36, 54);
/*  84 */     this.Leg2_1.field_78809_i = true;
/*  85 */     this.Leg2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.Leg2_1.func_78790_a(0.3F, 2.2F, -0.5F, 1, 4, 1, 0.0F);
/*  87 */     setRotateAngle(this.Leg2_1, 0.0F, 0.0F, -0.27314404F);
/*  88 */     this.Leg3_1 = new ModelRenderer(this, 60, 26);
/*  89 */     this.Leg3_1.field_78809_i = true;
/*  90 */     this.Leg3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Leg3_1.func_78790_a(0.8F, 5.5F, -1.5F, 3, 1, 3, 0.0F);
/*  92 */     setRotateAngle(this.Leg3_1, 0.0F, 0.0F, 0.25743607F);
/*  93 */     this.Arm5L = new ModelRenderer(this, 99, 38);
/*  94 */     this.Arm5L.field_78809_i = true;
/*  95 */     this.Arm5L.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.Arm5L.func_78790_a(-2.3F, 9.7F, -3.5F, 7, 5, 7, 0.0F);
/*  97 */     this.Arm2L = new ModelRenderer(this, 117, 16);
/*  98 */     this.Arm2L.field_78809_i = true;
/*  99 */     this.Arm2L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.Arm2L.func_78790_a(-0.2F, 2.2F, -0.5F, 1, 4, 1, 0.0F);
/* 101 */     setRotateAngle(this.Arm2L, 0.0F, 0.0F, -0.28012535F);
/* 102 */     this.Leg1R = new ModelRenderer(this, 26, 45);
/* 103 */     this.Leg1R.func_78793_a(-3.5F, 6.4F, 0.0F);
/* 104 */     this.Leg1R.func_78790_a(-2.0F, -1.8F, -2.0F, 4, 4, 4, 0.0F);
/* 105 */     this.LegGuardL = new ModelRenderer(this, 73, 27);
/* 106 */     this.LegGuardL.field_78809_i = true;
/* 107 */     this.LegGuardL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.LegGuardL.func_78790_a(-0.2F, 5.3F, -3.0F, 5, 2, 1, 0.0F);
/* 109 */     this.Leg5 = new ModelRenderer(this, 47, 41);
/* 110 */     this.Leg5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.Leg5.func_78790_a(-6.1F, 9.3F, -3.6F, 7, 6, 7, 0.0F);
/* 112 */     this.BodyTopSideR = new ModelRenderer(this, 90, 1);
/* 113 */     this.BodyTopSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 114 */     this.BodyTopSideR.func_78790_a(-9.0F, 0.3F, -4.0F, 2, 6, 8, 0.0F);
/* 115 */     this.HeadTop1 = new ModelRenderer(this, 82, 18);
/* 116 */     this.HeadTop1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.HeadTop1.func_78790_a(-1.0F, -5.8F, -1.0F, 2, 1, 2, 0.0F);
/* 118 */     this.ArmGuardR = new ModelRenderer(this, 100, 20);
/* 119 */     this.ArmGuardR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 120 */     this.ArmGuardR.func_78790_a(-4.9F, 5.3F, -2.4F, 1, 2, 5, 0.0F);
/* 121 */     this.BodyBase = new ModelRenderer(this, 6, 0);
/* 122 */     this.BodyBase.func_78793_a(0.0F, -9.6F, 0.0F);
/* 123 */     this.BodyBase.func_78790_a(-7.0F, 0.0F, -4.9F, 14, 8, 10, 0.0F);
/* 124 */     this.LegGuardR = new ModelRenderer(this, 73, 27);
/* 125 */     this.LegGuardR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.LegGuardR.func_78790_a(-5.1F, 5.3F, -3.0F, 5, 2, 1, 0.0F);
/* 127 */     this.Leg4 = new ModelRenderer(this, 52, 31);
/* 128 */     this.Leg4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 129 */     this.Leg4.func_78790_a(-5.5F, 6.4F, -3.2F, 6, 3, 6, 0.0F);
/* 130 */     this.HeadBottom = new ModelRenderer(this, 55, 15);
/* 131 */     this.HeadBottom.func_78793_a(0.0F, -9.7F, 0.0F);
/* 132 */     this.HeadBottom.func_78790_a(-4.1F, -1.6F, -3.5F, 8, 2, 7, 0.0F);
/* 133 */     this.Leg2 = new ModelRenderer(this, 36, 54);
/* 134 */     this.Leg2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 135 */     this.Leg2.func_78790_a(-1.3F, 2.2F, -0.5F, 1, 4, 1, 0.0F);
/* 136 */     setRotateAngle(this.Leg2, 0.0F, 0.0F, 0.27314404F);
/* 137 */     this.ArmGuardL = new ModelRenderer(this, 100, 20);
/* 138 */     this.ArmGuardL.field_78809_i = true;
/* 139 */     this.ArmGuardL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.ArmGuardL.func_78790_a(2.9F, 5.3F, -2.5F, 1, 2, 5, 0.0F);
/* 141 */     this.Leg4_1 = new ModelRenderer(this, 52, 31);
/* 142 */     this.Leg4_1.field_78809_i = true;
/* 143 */     this.Leg4_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.Leg4_1.func_78790_a(-0.7F, 6.4F, -3.2F, 6, 3, 6, 0.0F);
/* 145 */     this.BodyMid = new ModelRenderer(this, 15, 19);
/* 146 */     this.BodyMid.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.BodyMid.func_78790_a(-3.0F, 7.9F, -2.5F, 6, 5, 5, 0.0F);
/* 148 */     this.Arm3L = new ModelRenderer(this, 113, 22);
/* 149 */     this.Arm3L.field_78809_i = true;
/* 150 */     this.Arm3L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.Arm3L.func_78790_a(-0.5F, 6.0F, -1.5F, 3, 1, 3, 0.0F);
/* 152 */     setRotateAngle(this.Arm3L, 0.0F, 0.0F, 0.13665928F);
/* 153 */     this.HeadSideR = new ModelRenderer(this, 55, 15);
/* 154 */     this.HeadSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.HeadSideR.func_78790_a(-3.9F, -3.1F, -1.0F, 1, 2, 2, 0.0F);
/* 156 */     this.BodyTopsideL = new ModelRenderer(this, 90, 1);
/* 157 */     this.BodyTopsideL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.BodyTopsideL.func_78790_a(7.0F, 0.3F, -4.0F, 2, 6, 8, 0.0F);
/* 159 */     this.Leg3 = new ModelRenderer(this, 60, 26);
/* 160 */     this.Leg3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 161 */     this.Leg3.func_78790_a(-3.9F, 5.5F, -1.5F, 3, 1, 3, 0.0F);
/* 162 */     setRotateAngle(this.Leg3, 0.0F, 0.0F, -0.25743607F);
/* 163 */     this.Arm6R = new ModelRenderer(this, 103, 51);
/* 164 */     this.Arm6R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 165 */     this.Arm6R.func_78790_a(-5.2F, 14.7F, -2.8F, 6, 3, 6, 0.0F);
/* 166 */     this.BodySideL = new ModelRenderer(this, 31, 23);
/* 167 */     this.BodySideL.field_78809_i = true;
/* 168 */     this.BodySideL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 169 */     this.BodySideL.func_78790_a(2.5F, 7.5F, -3.5F, 3, 3, 7, 0.0F);
/* 170 */     this.Leg5_1 = new ModelRenderer(this, 47, 41);
/* 171 */     this.Leg5_1.field_78809_i = true;
/* 172 */     this.Leg5_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 173 */     this.Leg5_1.func_78790_a(-1.2F, 9.3F, -3.6F, 7, 6, 7, 0.0F);
/* 174 */     this.Leg1L = new ModelRenderer(this, 26, 45);
/* 175 */     this.Leg1L.field_78809_i = true;
/* 176 */     this.Leg1L.func_78793_a(3.1F, 6.4F, 0.0F);
/* 177 */     this.Leg1L.func_78790_a(-2.0F, -1.8F, -2.0F, 4, 4, 4, 0.0F);
/* 178 */     this.Leg6_1 = new ModelRenderer(this, 66, 50);
/* 179 */     this.Leg6_1.field_78809_i = true;
/* 180 */     this.Leg6_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 181 */     this.Leg6_1.func_78790_a(-1.6F, 14.8F, -5.7F, 8, 3, 10, 0.0F);
/* 182 */     this.Arm5R = new ModelRenderer(this, 99, 38);
/* 183 */     this.Arm5R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 184 */     this.Arm5R.func_78790_a(-5.7F, 9.7F, -3.3F, 7, 5, 7, 0.0F);
/* 185 */     this.HeadTop2 = new ModelRenderer(this, 84, 14);
/* 186 */     this.HeadTop2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 187 */     this.HeadTop2.func_78790_a(-0.5F, -7.8F, -0.5F, 1, 2, 1, 0.0F);
/* 188 */     this.BodyBottom2 = new ModelRenderer(this, 4, 45);
/* 189 */     this.BodyBottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 190 */     this.BodyBottom2.func_78790_a(-2.0F, 15.6F, -3.0F, 4, 3, 6, 0.0F);
/* 191 */     this.Arm6L = new ModelRenderer(this, 103, 51);
/* 192 */     this.Arm6L.field_78809_i = true;
/* 193 */     this.Arm6L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 194 */     this.Arm6L.func_78790_a(-1.8F, 14.7F, -3.0F, 6, 3, 6, 0.0F);
/* 195 */     this.Arm4R = new ModelRenderer(this, 103, 28);
/* 196 */     this.Arm4R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 197 */     this.Arm4R.func_78790_a(-5.1F, 6.8F, -2.8F, 6, 3, 6, 0.0F);
/* 198 */     this.Arm3R = new ModelRenderer(this, 113, 22);
/* 199 */     this.Arm3R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 200 */     this.Arm3R.func_78790_a(-3.4F, 5.8F, -1.5F, 3, 1, 3, 0.0F);
/* 201 */     setRotateAngle(this.Arm3R, 0.0F, 0.0F, -0.13665928F);
/* 202 */     this.HeadSideL = new ModelRenderer(this, 55, 15);
/* 203 */     this.HeadSideL.field_78809_i = true;
/* 204 */     this.HeadSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 205 */     this.HeadSideL.func_78790_a(2.7F, -3.1F, -1.0F, 1, 2, 2, 0.0F);
/* 206 */     this.Leg6 = new ModelRenderer(this, 66, 50);
/* 207 */     this.Leg6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 208 */     this.Leg6.func_78790_a(-6.5F, 14.8F, -5.7F, 8, 3, 10, 0.0F);
/* 209 */     this.HeadBottom.func_78792_a(this.Head);
/* 210 */     this.Arm1R.func_78792_a(this.Arm2R);
/* 211 */     this.BodyBase.func_78792_a(this.BodyBottom1);
/* 212 */     this.Arm3L.func_78792_a(this.Arm4L);
/* 213 */     this.BodyBase.func_78792_a(this.BodySideR);
/* 214 */     this.Leg1L.func_78792_a(this.Leg2_1);
/* 215 */     this.Leg2_1.func_78792_a(this.Leg3_1);
/* 216 */     this.Arm4L.func_78792_a(this.Arm5L);
/* 217 */     this.Arm1L.func_78792_a(this.Arm2L);
/* 218 */     this.Leg3_1.func_78792_a(this.LegGuardL);
/* 219 */     this.Leg4.func_78792_a(this.Leg5);
/* 220 */     this.BodyBase.func_78792_a(this.BodyTopSideR);
/* 221 */     this.Head.func_78792_a(this.HeadTop1);
/* 222 */     this.Arm3R.func_78792_a(this.ArmGuardR);
/* 223 */     this.Leg3.func_78792_a(this.LegGuardR);
/* 224 */     this.Leg3.func_78792_a(this.Leg4);
/* 225 */     this.Leg1R.func_78792_a(this.Leg2);
/* 226 */     this.Arm3L.func_78792_a(this.ArmGuardL);
/* 227 */     this.Leg3_1.func_78792_a(this.Leg4_1);
/* 228 */     this.BodyBase.func_78792_a(this.BodyMid);
/* 229 */     this.Arm2L.func_78792_a(this.Arm3L);
/* 230 */     this.Head.func_78792_a(this.HeadSideR);
/* 231 */     this.BodyBase.func_78792_a(this.BodyTopsideL);
/* 232 */     this.Leg2.func_78792_a(this.Leg3);
/* 233 */     this.Arm5R.func_78792_a(this.Arm6R);
/* 234 */     this.BodyBase.func_78792_a(this.BodySideL);
/* 235 */     this.Leg4_1.func_78792_a(this.Leg5_1);
/* 236 */     this.Leg5_1.func_78792_a(this.Leg6_1);
/* 237 */     this.Arm4R.func_78792_a(this.Arm5R);
/* 238 */     this.HeadTop1.func_78792_a(this.HeadTop2);
/* 239 */     this.BodyBottom1.func_78792_a(this.BodyBottom2);
/* 240 */     this.Arm5L.func_78792_a(this.Arm6L);
/* 241 */     this.Arm3R.func_78792_a(this.Arm4R);
/* 242 */     this.Arm2R.func_78792_a(this.Arm3R);
/* 243 */     this.Head.func_78792_a(this.HeadSideL);
/* 244 */     this.Leg5.func_78792_a(this.Leg6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 249 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 250 */     GL11.glPushMatrix();
/* 251 */     float sc = 1.5F;
/* 252 */     GL11.glScalef(sc, sc, sc);
/* 253 */     GL11.glTranslatef(0.0F, -sc * 0.35F, 0.0F);
/* 254 */     this.Leg1L.func_78785_a(f5);
/* 255 */     this.HeadBottom.func_78785_a(f5);
/* 256 */     this.Arm1L.func_78785_a(f5);
/* 257 */     this.Arm1R.func_78785_a(f5);
/* 258 */     this.BodyBase.func_78785_a(f5);
/* 259 */     this.Leg1R.func_78785_a(f5);
/* 260 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 265 */     modelRenderer.field_78795_f = x;
/* 266 */     modelRenderer.field_78796_g = y;
/* 267 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 271 */     int calc = par7Entity.field_70173_aa;
/* 272 */     if (calc > 100) calc -= 100; 
/* 273 */     float r = 360.0F;
/* 274 */     float r2 = 180.0F;
/* 275 */     float n4 = par4;
/* 276 */     float n5 = par5;
/*     */     
/* 278 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 279 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 280 */     float ex = par7Entity.field_70173_aa;
/* 281 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 282 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 293 */     this.Leg1R.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 294 */     this.Leg1L.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 295 */     this.Arm1R.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 296 */     this.Arm1L.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 297 */     this.Leg1R.field_78796_g = 0.0F;
/* 298 */     this.Leg1L.field_78796_g = 0.0F;
/* 299 */     this.Arm1R.field_78796_g = 0.0F;
/* 300 */     this.Arm1L.field_78796_g = 0.0F;
/* 301 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelMagetta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */