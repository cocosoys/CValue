/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ModelKoichiarator
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer KoitsukaiHead;
/*     */   public ModelRenderer KoitsukaiBody;
/*     */   public ModelRenderer Arm1R;
/*     */   public ModelRenderer Arm1L;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head5;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer BodyTop1;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer BodyBackR;
/*     */   public ModelRenderer BodyBackL;
/*     */   public ModelRenderer PanchiaBody;
/*     */   public ModelRenderer PanchiaHead;
/*     */   public ModelRenderer BodyTop2;
/*     */   public ModelRenderer PSide1L;
/*     */   public ModelRenderer PSide1R;
/*     */   public ModelRenderer PSide1F;
/*     */   public ModelRenderer PSide1B;
/*     */   public ModelRenderer PBody2;
/*     */   public ModelRenderer BoraretaBody;
/*     */   public ModelRenderer PBody3;
/*     */   public ModelRenderer PSide2B;
/*     */   public ModelRenderer PSide2R;
/*     */   public ModelRenderer PSide2L;
/*     */   public ModelRenderer PSide2F;
/*     */   public ModelRenderer PShoulderR;
/*     */   public ModelRenderer PShoulderL;
/*     */   public ModelRenderer extraR;
/*     */   public ModelRenderer extraL;
/*     */   public ModelRenderer PHandR;
/*     */   public ModelRenderer PHandL;
/*     */   public ModelRenderer BSideL1;
/*     */   public ModelRenderer BSideR1;
/*     */   public ModelRenderer BSideF;
/*     */   public ModelRenderer BSideB;
/*     */   public ModelRenderer BLowerBody;
/*     */   public ModelRenderer BSideL2;
/*     */   public ModelRenderer BHandL;
/*     */   public ModelRenderer HandL1;
/*     */   public ModelRenderer HandL2;
/*     */   public ModelRenderer HandL3;
/*     */   public ModelRenderer HandL4;
/*     */   public ModelRenderer HandL5;
/*     */   public ModelRenderer BSideR2;
/*     */   public ModelRenderer BHandR;
/*     */   public ModelRenderer HandR1;
/*     */   public ModelRenderer HandR2;
/*     */   public ModelRenderer HandR3;
/*     */   public ModelRenderer HandR4;
/*     */   public ModelRenderer HandR5;
/*     */   public ModelRenderer BLowerBodyF;
/*     */   public ModelRenderer BLowerBodyB;
/*     */   public ModelRenderer Pipes;
/*     */   public ModelRenderer PipeL1;
/*     */   public ModelRenderer PipeR1;
/*     */   public ModelRenderer PipeL2;
/*     */   public ModelRenderer PipeR2;
/*     */   public ModelRenderer Arm2R;
/*     */   public ModelRenderer Arm3R;
/*     */   public ModelRenderer Arm4R;
/*     */   public ModelRenderer Arm5R;
/*     */   public ModelRenderer Arm6R;
/*     */   public ModelRenderer Arm7R;
/*     */   public ModelRenderer Arm8R;
/*     */   public ModelRenderer Arm9R;
/*     */   public ModelRenderer Arm10R;
/*     */   public ModelRenderer Arm11R;
/*     */   public ModelRenderer Arm13R;
/*     */   public ModelRenderer ArmVentR;
/*     */   public ModelRenderer HandR;
/*     */   public ModelRenderer Arm12R;
/*     */   public ModelRenderer Finger11R;
/*     */   public ModelRenderer Finger21R;
/*     */   public ModelRenderer Finger31R;
/*     */   public ModelRenderer Finger12R;
/*     */   public ModelRenderer Finger22R;
/*     */   public ModelRenderer Finger32R;
/*     */   public ModelRenderer Arm2L;
/*     */   public ModelRenderer Arm3L;
/*     */   public ModelRenderer Arm4L;
/*     */   public ModelRenderer Arm5L;
/*     */   public ModelRenderer Arm6L;
/*     */   public ModelRenderer Arm7L;
/*     */   public ModelRenderer Arm8L;
/*     */   public ModelRenderer Arm9L;
/*     */   public ModelRenderer Arm10L;
/*     */   public ModelRenderer Arm11L;
/*     */   public ModelRenderer Arm13L;
/*     */   public ModelRenderer ArmVentL;
/*     */   public ModelRenderer HandL;
/*     */   public ModelRenderer Arm12L;
/*     */   public ModelRenderer Finger11L;
/*     */   public ModelRenderer Finger21L;
/*     */   public ModelRenderer Finger31L;
/*     */   public ModelRenderer Finger12L;
/*     */   public ModelRenderer Finger22L;
/*     */   public ModelRenderer Finger32L;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegR4;
/*     */   public ModelRenderer LegR5;
/*     */   public ModelRenderer LegR8;
/*     */   public ModelRenderer LegR9;
/*     */   public ModelRenderer LegR6;
/*     */   public ModelRenderer LegR7;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   public ModelRenderer LegL4;
/*     */   public ModelRenderer LegL5;
/*     */   public ModelRenderer LegL8;
/*     */   public ModelRenderer LegL9;
/*     */   public ModelRenderer LegL6;
/*     */   public ModelRenderer LegL7;
/*     */   
/*     */   public ModelKoichiarator() {
/* 131 */     this.field_78090_t = 512;
/* 132 */     this.field_78089_u = 256;
/* 133 */     this.Finger31R = new ModelRenderer(this, 147, 112);
/* 134 */     this.Finger31R.func_78793_a(4.2F, 24.0F, 0.0F);
/* 135 */     this.Finger31R.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 136 */     setRotateAngle(this.Finger31R, 0.0F, 0.0F, -0.34906584F);
/* 137 */     this.Head5 = new ModelRenderer(this, 44, 6);
/* 138 */     this.Head5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 139 */     this.Head5.func_78790_a(-3.5F, -1.0F, -8.6F, 7, 1, 2, 0.0F);
/* 140 */     this.ShoulderR = new ModelRenderer(this, 170, 18);
/* 141 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 142 */     this.ShoulderR.func_78790_a(-10.5F, 1.0F, -3.5F, 4, 5, 8, 0.0F);
/* 143 */     this.BSideF = new ModelRenderer(this, 15, 165);
/* 144 */     this.BSideF.func_78793_a(0.0F, -0.5F, -12.8F);
/* 145 */     this.BSideF.func_78790_a(-9.5F, -5.0F, -3.7F, 19, 10, 4, 0.0F);
/* 146 */     this.Head3 = new ModelRenderer(this, 1, 24);
/* 147 */     this.Head3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 148 */     this.Head3.func_78790_a(-3.5F, -3.0F, -6.7F, 7, 1, 13, 0.0F);
/* 149 */     this.PBody3 = new ModelRenderer(this, 388, 23);
/* 150 */     this.PBody3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.PBody3.func_78790_a(-9.5F, -16.2F, -9.5F, 19, 3, 19, 0.0F);
/* 152 */     this.Finger21R = new ModelRenderer(this, 147, 112);
/* 153 */     this.Finger21R.func_78793_a(-3.1F, 24.0F, 4.7F);
/* 154 */     this.Finger21R.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 155 */     setRotateAngle(this.Finger21R, 0.0F, 0.34906584F, 0.34906584F);
/* 156 */     this.PHandR = new ModelRenderer(this, 406, 1);
/* 157 */     this.PHandR.func_78793_a(-7.1F, 0.2F, 0.0F);
/* 158 */     this.PHandR.func_78790_a(-2.8F, 0.1F, -4.5F, 6, 7, 8, 0.0F);
/* 159 */     setRotateAngle(this.PHandR, 0.0F, 0.0F, 0.9599311F);
/* 160 */     this.Arm13L = new ModelRenderer(this, 148, 78);
/* 161 */     this.Arm13L.field_78809_i = true;
/* 162 */     this.Arm13L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 163 */     this.Arm13L.func_78790_a(-6.0F, 6.0F, -6.5F, 12, 12, 13, 0.0F);
/* 164 */     this.ArmVentL = new ModelRenderer(this, 209, 108);
/* 165 */     this.ArmVentL.field_78809_i = true;
/* 166 */     this.ArmVentL.func_78793_a(6.7F, 13.6F, 0.0F);
/* 167 */     this.ArmVentL.func_78790_a(-1.6F, -4.4F, -3.0F, 3, 7, 6, 0.0F);
/* 168 */     setRotateAngle(this.ArmVentL, 0.0F, 0.0F, -0.2443461F);
/* 169 */     this.LegL4 = new ModelRenderer(this, 50, 225);
/* 170 */     this.LegL4.field_78809_i = true;
/* 171 */     this.LegL4.func_78793_a(0.0F, 4.0F, -0.5F);
/* 172 */     this.LegL4.func_78790_a(-5.0F, -0.5F, -5.0F, 10, 15, 10, 0.0F);
/* 173 */     setRotateAngle(this.LegL4, 0.13473941F, 0.0F, 0.0F);
/* 174 */     this.Arm9L = new ModelRenderer(this, 150, 38);
/* 175 */     this.Arm9L.field_78809_i = true;
/* 176 */     this.Arm9L.func_78793_a(0.0F, 5.1F, 0.0F);
/* 177 */     this.Arm9L.func_78790_a(-3.0F, 0.0F, -4.0F, 6, 2, 8, 0.0F);
/* 178 */     setRotateAngle(this.Arm9L, -0.34906584F, 0.0F, 0.0F);
/* 179 */     this.Arm10L = new ModelRenderer(this, 150, 49);
/* 180 */     this.Arm10L.field_78809_i = true;
/* 181 */     this.Arm10L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 182 */     this.Arm10L.func_78790_a(-4.0F, 2.0F, -5.5F, 8, 2, 11, 0.0F);
/* 183 */     this.Finger22R = new ModelRenderer(this, 150, 121);
/* 184 */     this.Finger22R.func_78793_a(0.0F, 4.1F, 0.0F);
/* 185 */     this.Finger22R.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 186 */     setRotateAngle(this.Finger22R, 0.0F, 0.0F, -0.87266463F);
/* 187 */     this.BodyTop1 = new ModelRenderer(this, 58, 45);
/* 188 */     this.BodyTop1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 189 */     this.BodyTop1.func_78790_a(-6.0F, -1.0F, -6.0F, 12, 1, 12, 0.0F);
/* 190 */     this.PBody2 = new ModelRenderer(this, 383, 47);
/* 191 */     this.PBody2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 192 */     this.PBody2.func_78790_a(-11.0F, -13.4F, -11.0F, 22, 8, 22, 0.0F);
/* 193 */     this.Finger32L = new ModelRenderer(this, 150, 121);
/* 194 */     this.Finger32L.func_78793_a(0.0F, 4.1F, 0.0F);
/* 195 */     this.Finger32L.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 196 */     setRotateAngle(this.Finger32L, 0.0F, 0.0F, -0.87266463F);
/* 197 */     this.HandL = new ModelRenderer(this, 159, 104);
/* 198 */     this.HandL.field_78809_i = true;
/* 199 */     this.HandL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 200 */     this.HandL.func_78790_a(-5.3F, 18.0F, -5.5F, 10, 7, 11, 0.0F);
/* 201 */     this.Arm13R = new ModelRenderer(this, 148, 78);
/* 202 */     this.Arm13R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 203 */     this.Arm13R.func_78790_a(-6.0F, 6.0F, -6.5F, 12, 12, 13, 0.0F);
/* 204 */     this.KoitsukaiBody = new ModelRenderer(this, 1, 44);
/* 205 */     this.KoitsukaiBody.func_78793_a(0.0F, -62.8F, 0.0F);
/* 206 */     this.KoitsukaiBody.func_78790_a(-7.0F, 0.0F, -6.5F, 14, 12, 13, 0.0F);
/* 207 */     this.LegR1 = new ModelRenderer(this, 2, 208);
/* 208 */     this.LegR1.func_78793_a(-8.0F, -11.5F, 1.9F);
/* 209 */     this.LegR1.func_78790_a(-4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F);
/* 210 */     this.LegL1 = new ModelRenderer(this, 2, 208);
/* 211 */     this.LegL1.field_78809_i = true;
/* 212 */     this.LegL1.func_78793_a(8.0F, -11.5F, 1.9F);
/* 213 */     this.LegL1.func_78790_a(-4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F);
/* 214 */     this.PShoulderR = new ModelRenderer(this, 450, 18);
/* 215 */     this.PShoulderR.func_78793_a(-6.0F, -15.0F, 0.5F);
/* 216 */     this.PShoulderR.func_78790_a(-11.6F, -4.0F, -5.0F, 12, 8, 10, 0.0F);
/* 217 */     this.LegR5 = new ModelRenderer(this, 136, 222);
/* 218 */     this.LegR5.func_78793_a(0.0F, 14.0F, 0.0F);
/* 219 */     this.LegR5.func_78790_a(-5.5F, 0.4F, -7.2F, 11, 6, 13, 0.0F);
/* 220 */     setRotateAngle(this.LegR5, -0.09599311F, 0.0F, 0.0F);
/* 221 */     this.BLowerBodyF = new ModelRenderer(this, 39, 184);
/* 222 */     this.BLowerBodyF.func_78793_a(0.0F, 0.0F, 0.0F);
/* 223 */     this.BLowerBodyF.func_78790_a(-4.0F, 0.0F, -14.0F, 8, 5, 5, 0.0F);
/* 224 */     this.Arm8R = new ModelRenderer(this, 150, 18);
/* 225 */     this.Arm8R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 226 */     this.Arm8R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 227 */     setRotateAngle(this.Arm8R, -0.17453292F, 0.0F, 0.0F);
/* 228 */     this.Arm1R = new ModelRenderer(this, 124, 24);
/* 229 */     this.Arm1R.func_78793_a(-6.8F, -57.6F, 0.5F);
/* 230 */     this.Arm1R.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/* 231 */     this.PSide2R = new ModelRenderer(this, 457, 41);
/* 232 */     this.PSide2R.func_78793_a(-11.3F, -9.0F, 0.0F);
/* 233 */     this.PSide2R.func_78790_a(-1.7F, -3.5F, -8.0F, 2, 7, 16, 0.0F);
/* 234 */     this.Finger12L = new ModelRenderer(this, 150, 121);
/* 235 */     this.Finger12L.func_78793_a(0.0F, 4.1F, 0.0F);
/* 236 */     this.Finger12L.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 237 */     setRotateAngle(this.Finger12L, 0.0F, 0.0F, 0.87266463F);
/* 238 */     this.extraL = new ModelRenderer(this, 256, 0);
/* 239 */     this.extraL.func_78793_a(7.5F, -2.0F, -13.7F);
/* 240 */     this.extraL.func_78790_a(-3.0F, -3.0F, -1.0F, 6, 6, 3, 0.0F);
/* 241 */     this.LegL2 = new ModelRenderer(this, 2, 228);
/* 242 */     this.LegL2.field_78809_i = true;
/* 243 */     this.LegL2.func_78793_a(1.5F, 1.4F, -1.5F);
/* 244 */     this.LegL2.func_78790_a(-5.0F, 0.0F, -4.7F, 10, 12, 10, 0.0F);
/* 245 */     setRotateAngle(this.LegL2, -0.7740535F, -0.13665928F, 0.0F);
/* 246 */     this.BSideB = new ModelRenderer(this, 60, 165);
/* 247 */     this.BSideB.field_78809_i = true;
/* 248 */     this.BSideB.func_78793_a(0.0F, -0.5F, 12.5F);
/* 249 */     this.BSideB.func_78790_a(-9.5F, -5.0F, 0.0F, 19, 10, 4, 0.0F);
/* 250 */     this.HandL3 = new ModelRenderer(this, 221, 189);
/* 251 */     this.HandL3.field_78809_i = true;
/* 252 */     this.HandL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 253 */     this.HandL3.func_78790_a(-0.4F, -5.5F, -3.5F, 7, 1, 7, 0.0F);
/* 254 */     this.LegR4 = new ModelRenderer(this, 50, 225);
/* 255 */     this.LegR4.func_78793_a(0.0F, 4.0F, 0.5F);
/* 256 */     this.LegR4.func_78790_a(-5.0F, -0.5F, -5.0F, 10, 15, 10, 0.0F);
/* 257 */     setRotateAngle(this.LegR4, 0.13473941F, 0.0F, 0.0F);
/* 258 */     this.BLowerBody = new ModelRenderer(this, 1, 181);
/* 259 */     this.BLowerBody.func_78793_a(0.0F, 4.5F, 0.0F);
/* 260 */     this.BLowerBody.func_78790_a(-4.0F, 0.0F, -9.0F, 8, 7, 18, 0.0F);
/* 261 */     this.Finger11R = new ModelRenderer(this, 147, 112);
/* 262 */     this.Finger11R.func_78793_a(-3.1F, 24.0F, -4.7F);
/* 263 */     this.Finger11R.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 264 */     setRotateAngle(this.Finger11R, 0.0F, -0.34906584F, 0.34906584F);
/* 265 */     this.PanchiaBody = new ModelRenderer(this, 378, 79);
/* 266 */     this.PanchiaBody.func_78793_a(0.0F, 32.9F, 3.7F);
/* 267 */     this.PanchiaBody.func_78790_a(-12.5F, -5.5F, -12.5F, 25, 10, 25, 0.0F);
/* 268 */     this.BodyBackL = new ModelRenderer(this, 93, 64);
/* 269 */     this.BodyBackL.func_78793_a(5.0F, 9.0F, 6.2F);
/* 270 */     this.BodyBackL.func_78790_a(-1.0F, -2.8F, -0.4F, 2, 8, 2, 0.0F);
/* 271 */     this.PSide2F = new ModelRenderer(this, 325, 57);
/* 272 */     this.PSide2F.func_78793_a(0.0F, -9.0F, -11.3F);
/* 273 */     this.PSide2F.func_78790_a(-8.5F, -3.5F, -1.7F, 17, 7, 2, 0.0F);
/* 274 */     this.Arm7L = new ModelRenderer(this, 150, 18);
/* 275 */     this.Arm7L.field_78809_i = true;
/* 276 */     this.Arm7L.func_78793_a(0.0F, 5.9F, 0.0F);
/* 277 */     this.Arm7L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 278 */     setRotateAngle(this.Arm7L, -0.17453292F, 0.0F, 0.0F);
/* 279 */     this.Arm12L = new ModelRenderer(this, 191, 112);
/* 280 */     this.Arm12L.field_78809_i = true;
/* 281 */     this.Arm12L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 282 */     this.Arm12L.func_78790_a(3.5F, 18.0F, -6.0F, 2, 3, 12, 0.0F);
/* 283 */     this.PipeL1 = new ModelRenderer(this, 110, 182);
/* 284 */     this.PipeL1.field_78809_i = true;
/* 285 */     this.PipeL1.func_78793_a(2.1F, 0.8F, 2.8F);
/* 286 */     this.PipeL1.func_78790_a(-1.5F, -0.5F, -0.1F, 3, 4, 13, 0.0F);
/* 287 */     setRotateAngle(this.PipeL1, 1.2292354F, 0.0F, 0.0F);
/* 288 */     this.Arm11R = new ModelRenderer(this, 150, 63);
/* 289 */     this.Arm11R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 290 */     this.Arm11R.func_78790_a(-5.0F, 4.0F, -6.0F, 10, 2, 12, 0.0F);
/* 291 */     this.HandL4 = new ModelRenderer(this, 215, 218);
/* 292 */     this.HandL4.field_78809_i = true;
/* 293 */     this.HandL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 294 */     this.HandL4.func_78790_a(-0.3F, 4.5F, -3.5F, 7, 1, 7, 0.0F);
/* 295 */     this.LegL3 = new ModelRenderer(this, 50, 205);
/* 296 */     this.LegL3.field_78809_i = true;
/* 297 */     this.LegL3.func_78793_a(0.0F, 12.5F, 1.3F);
/* 298 */     this.LegL3.func_78790_a(-4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F);
/* 299 */     setRotateAngle(this.LegL3, 0.74036866F, 0.0F, 0.0F);
/* 300 */     this.Finger12R = new ModelRenderer(this, 150, 121);
/* 301 */     this.Finger12R.func_78793_a(0.0F, 4.1F, 0.0F);
/* 302 */     this.Finger12R.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 303 */     setRotateAngle(this.Finger12R, 0.0F, 0.0F, -0.87266463F);
/* 304 */     this.LegR8 = new ModelRenderer(this, 114, 223);
/* 305 */     this.LegR8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 306 */     this.LegR8.func_78790_a(-6.0F, 5.5F, -3.0F, 1, 11, 7, 0.0F);
/* 307 */     this.PHandL = new ModelRenderer(this, 406, 1);
/* 308 */     this.PHandL.field_78809_i = true;
/* 309 */     this.PHandL.func_78793_a(6.6F, 0.2F, 0.0F);
/* 310 */     this.PHandL.func_78790_a(-2.8F, 0.1F, -4.5F, 6, 7, 8, 0.0F);
/* 311 */     setRotateAngle(this.PHandL, 0.0F, 0.0F, -0.9599311F);
/* 312 */     this.Pipes = new ModelRenderer(this, 96, 184);
/* 313 */     this.Pipes.func_78793_a(0.0F, 2.6F, 13.7F);
/* 314 */     this.Pipes.func_78790_a(-3.5F, -1.9F, 0.0F, 7, 4, 6, 0.0F);
/* 315 */     setRotateAngle(this.Pipes, 0.13962634F, 0.0F, 0.0F);
/* 316 */     this.HandR4 = new ModelRenderer(this, 215, 218);
/* 317 */     this.HandR4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 318 */     this.HandR4.func_78790_a(-8.0F, 4.5F, -3.5F, 7, 1, 7, 0.0F);
/* 319 */     this.PSide1R = new ModelRenderer(this, 459, 73);
/* 320 */     this.PSide1R.func_78793_a(-12.8F, -0.5F, 0.0F);
/* 321 */     this.PSide1R.func_78790_a(-1.7F, -5.0F, -8.5F, 2, 10, 18, 0.0F);
/* 322 */     this.BHandL = new ModelRenderer(this, 193, 189);
/* 323 */     this.BHandL.field_78809_i = true;
/* 324 */     this.BHandL.func_78793_a(2.9F, 1.5F, 0.0F);
/* 325 */     this.BHandL.func_78790_a(-1.2F, -4.5F, -4.5F, 9, 9, 9, 0.0F);
/* 326 */     setRotateAngle(this.BHandL, 0.0F, 0.0F, 0.10471976F);
/* 327 */     this.LegR2 = new ModelRenderer(this, 2, 228);
/* 328 */     this.LegR2.func_78793_a(-1.5F, 1.4F, -1.5F);
/* 329 */     this.LegR2.func_78790_a(-5.0F, 0.0F, -4.7F, 10, 12, 10, 0.0F);
/* 330 */     setRotateAngle(this.LegR2, -0.7740535F, 0.13665928F, 0.0F);
/* 331 */     this.PSide1B = new ModelRenderer(this, 359, 83);
/* 332 */     this.PSide1B.func_78793_a(0.0F, -0.5F, 12.5F);
/* 333 */     this.PSide1B.func_78790_a(-9.5F, -5.0F, 0.0F, 19, 10, 2, 0.0F);
/* 334 */     this.BSideL1 = new ModelRenderer(this, 101, 135);
/* 335 */     this.BSideL1.field_78809_i = true;
/* 336 */     this.BSideL1.func_78793_a(12.8F, -0.5F, 0.0F);
/* 337 */     this.BSideL1.func_78790_a(-0.3F, -5.0F, -8.5F, 4, 10, 18, 0.0F);
/* 338 */     this.Arm3L = new ModelRenderer(this, 150, 18);
/* 339 */     this.Arm3L.field_78809_i = true;
/* 340 */     this.Arm3L.func_78793_a(0.0F, 5.9F, 0.0F);
/* 341 */     this.Arm3L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 342 */     setRotateAngle(this.Arm3L, -0.17453292F, 0.0F, 0.034906585F);
/* 343 */     this.Finger32R = new ModelRenderer(this, 150, 121);
/* 344 */     this.Finger32R.func_78793_a(0.0F, 4.1F, 0.0F);
/* 345 */     this.Finger32R.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 346 */     setRotateAngle(this.Finger32R, 0.0F, 0.0F, 0.87266463F);
/* 347 */     this.HandL5 = new ModelRenderer(this, 203, 209);
/* 348 */     this.HandL5.field_78809_i = true;
/* 349 */     this.HandL5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 350 */     this.HandL5.func_78790_a(7.8F, -3.6F, -3.4F, 1, 7, 7, 0.0F);
/* 351 */     this.Head2 = new ModelRenderer(this, 48, 6);
/* 352 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 353 */     this.Head2.func_78790_a(-3.5F, -2.0F, -7.5F, 7, 2, 15, 0.0F);
/* 354 */     this.HandL1 = new ModelRenderer(this, 221, 209);
/* 355 */     this.HandL1.field_78809_i = true;
/* 356 */     this.HandL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 357 */     this.HandL1.func_78790_a(-0.3F, -3.5F, -5.5F, 7, 7, 1, 0.0F);
/* 358 */     this.Finger21L = new ModelRenderer(this, 147, 112);
/* 359 */     this.Finger21L.func_78793_a(3.3F, 24.0F, 4.7F);
/* 360 */     this.Finger21L.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 361 */     setRotateAngle(this.Finger21L, 0.0F, -0.34906584F, -0.34906584F);
/* 362 */     this.LegL8 = new ModelRenderer(this, 114, 223);
/* 363 */     this.LegL8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 364 */     this.LegL8.func_78790_a(-6.0F, 5.5F, -3.0F, 1, 11, 7, 0.0F);
/* 365 */     this.PanchiaHead = new ModelRenderer(this, 256, 0);
/* 366 */     this.PanchiaHead.func_78793_a(0.0F, 16.2F, 3.7F);
/* 367 */     this.PanchiaHead.func_78790_a(-7.5F, -4.2F, -14.1F, 15, 11, 28, 0.0F);
/* 368 */     this.HandL2 = new ModelRenderer(this, 185, 209);
/* 369 */     this.HandL2.field_78809_i = true;
/* 370 */     this.HandL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 371 */     this.HandL2.func_78790_a(-0.3F, -3.5F, 4.5F, 7, 7, 1, 0.0F);
/* 372 */     this.LegR9 = new ModelRenderer(this, 188, 223);
/* 373 */     this.LegR9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 374 */     this.LegR9.func_78790_a(5.0F, 5.5F, -3.0F, 1, 11, 7, 0.0F);
/* 375 */     this.Arm2L = new ModelRenderer(this, 150, 18);
/* 376 */     this.Arm2L.field_78809_i = true;
/* 377 */     this.Arm2L.func_78793_a(1.2F, -0.8F, -0.7F);
/* 378 */     this.Arm2L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 379 */     setRotateAngle(this.Arm2L, 0.34906584F, 0.0F, -1.134464F);
/* 380 */     this.Finger22L = new ModelRenderer(this, 150, 121);
/* 381 */     this.Finger22L.func_78793_a(0.0F, 4.1F, 0.0F);
/* 382 */     this.Finger22L.func_78790_a(-1.0F, -0.9F, -0.5F, 2, 5, 1, 0.0F);
/* 383 */     setRotateAngle(this.Finger22L, 0.0F, 0.0F, 0.87266463F);
/* 384 */     this.Arm6R = new ModelRenderer(this, 150, 18);
/* 385 */     this.Arm6R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 386 */     this.Arm6R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 387 */     setRotateAngle(this.Arm6R, -0.17453292F, 0.0F, 0.0F);
/* 388 */     this.BHandR = new ModelRenderer(this, 193, 189);
/* 389 */     this.BHandR.func_78793_a(-1.9F, 1.5F, 0.0F);
/* 390 */     this.BHandR.func_78790_a(-8.8F, -4.5F, -4.5F, 9, 9, 9, 0.0F);
/* 391 */     setRotateAngle(this.BHandR, 0.0F, 0.0F, -0.10471976F);
/* 392 */     this.PSide2L = new ModelRenderer(this, 457, 41);
/* 393 */     this.PSide2L.field_78809_i = true;
/* 394 */     this.PSide2L.func_78793_a(11.2F, -9.0F, 0.0F);
/* 395 */     this.PSide2L.func_78790_a(-0.3F, -3.5F, -8.0F, 2, 7, 16, 0.0F);
/* 396 */     this.PipeR2 = new ModelRenderer(this, 130, 184);
/* 397 */     this.PipeR2.func_78793_a(-0.1F, 0.2F, 12.1F);
/* 398 */     this.PipeR2.func_78790_a(-1.5F, -1.0F, -0.1F, 3, 4, 6, 0.0F);
/* 399 */     setRotateAngle(this.PipeR2, -1.0016445F, 0.0F, 0.0F);
/* 400 */     this.LegR3 = new ModelRenderer(this, 50, 205);
/* 401 */     this.LegR3.func_78793_a(0.0F, 12.5F, 1.3F);
/* 402 */     this.LegR3.func_78790_a(-4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F);
/* 403 */     setRotateAngle(this.LegR3, 0.74036866F, 0.0F, 0.0F);
/* 404 */     this.PipeR1 = new ModelRenderer(this, 110, 182);
/* 405 */     this.PipeR1.func_78793_a(-2.1F, 0.8F, 2.8F);
/* 406 */     this.PipeR1.func_78790_a(-1.5F, -0.5F, -0.1F, 3, 4, 13, 0.0F);
/* 407 */     setRotateAngle(this.PipeR1, 1.2292354F, 0.0F, 0.0F);
/* 408 */     this.Finger11L = new ModelRenderer(this, 147, 112);
/* 409 */     this.Finger11L.func_78793_a(3.3F, 24.0F, -4.7F);
/* 410 */     this.Finger11L.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 411 */     setRotateAngle(this.Finger11L, 0.0F, 0.34906584F, -0.34906584F);
/* 412 */     this.LegR6 = new ModelRenderer(this, 136, 243);
/* 413 */     this.LegR6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 414 */     this.LegR6.func_78790_a(-3.9F, 2.4F, -12.2F, 8, 4, 5, 0.0F);
/* 415 */     this.LegR7 = new ModelRenderer(this, 138, 212);
/* 416 */     this.LegR7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 417 */     this.LegR7.func_78790_a(-3.9F, 2.4F, 5.7F, 8, 4, 3, 0.0F);
/* 418 */     this.LegL7 = new ModelRenderer(this, 138, 212);
/* 419 */     this.LegL7.field_78809_i = true;
/* 420 */     this.LegL7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 421 */     this.LegL7.func_78790_a(-3.9F, 2.4F, 5.7F, 8, 4, 3, 0.0F);
/* 422 */     this.Arm1L = new ModelRenderer(this, 124, 24);
/* 423 */     this.Arm1L.field_78809_i = true;
/* 424 */     this.Arm1L.func_78793_a(6.8F, -57.6F, 0.5F);
/* 425 */     this.Arm1L.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/* 426 */     this.BSideR1 = new ModelRenderer(this, 101, 135);
/* 427 */     this.BSideR1.func_78793_a(-12.8F, -0.5F, 0.0F);
/* 428 */     this.BSideR1.func_78790_a(-3.7F, -5.0F, -8.5F, 4, 10, 18, 0.0F);
/* 429 */     this.Finger31L = new ModelRenderer(this, 147, 112);
/* 430 */     this.Finger31L.func_78793_a(-3.9F, 24.0F, -0.5F);
/* 431 */     this.Finger31L.func_78790_a(-1.5F, -0.9F, -1.0F, 3, 5, 2, 0.0F);
/* 432 */     setRotateAngle(this.Finger31L, 0.0F, 0.0F, 0.34906584F);
/* 433 */     this.Head4 = new ModelRenderer(this, 43, 28);
/* 434 */     this.Head4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 435 */     this.Head4.func_78790_a(-3.5F, -4.0F, -4.5F, 7, 1, 9, 0.0F);
/* 436 */     this.ArmVentR = new ModelRenderer(this, 209, 108);
/* 437 */     this.ArmVentR.func_78793_a(-6.3F, 13.6F, 0.0F);
/* 438 */     this.ArmVentR.func_78790_a(-1.9F, -4.4F, -3.0F, 3, 7, 6, 0.0F);
/* 439 */     setRotateAngle(this.ArmVentR, 0.0F, 0.0F, 0.2443461F);
/* 440 */     this.Arm10R = new ModelRenderer(this, 150, 49);
/* 441 */     this.Arm10R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 442 */     this.Arm10R.func_78790_a(-4.0F, 2.0F, -5.5F, 8, 2, 11, 0.0F);
/* 443 */     this.extraR = new ModelRenderer(this, 256, 0);
/* 444 */     this.extraR.func_78793_a(-7.5F, -2.0F, -13.7F);
/* 445 */     this.extraR.func_78790_a(-3.0F, -3.0F, -1.0F, 6, 6, 3, 0.0F);
/* 446 */     this.ShoulderL = new ModelRenderer(this, 170, 18);
/* 447 */     this.ShoulderL.field_78809_i = true;
/* 448 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 449 */     this.ShoulderL.func_78790_a(6.5F, 1.0F, -3.5F, 4, 5, 8, 0.0F);
/* 450 */     this.Arm5L = new ModelRenderer(this, 150, 18);
/* 451 */     this.Arm5L.field_78809_i = true;
/* 452 */     this.Arm5L.func_78793_a(0.0F, 5.9F, 0.0F);
/* 453 */     this.Arm5L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 454 */     setRotateAngle(this.Arm5L, -0.17453292F, 0.0F, 0.034906585F);
/* 455 */     this.BoraretaBody = new ModelRenderer(this, 0, 128);
/* 456 */     this.BoraretaBody.func_78793_a(0.0F, 10.0F, 0.0F);
/* 457 */     this.BoraretaBody.func_78790_a(-12.5F, -5.5F, -12.5F, 25, 10, 25, 0.0F);
/* 458 */     this.LegL9 = new ModelRenderer(this, 188, 223);
/* 459 */     this.LegL9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 460 */     this.LegL9.func_78790_a(5.0F, 5.5F, -3.0F, 1, 11, 7, 0.0F);
/* 461 */     this.HandR3 = new ModelRenderer(this, 221, 189);
/* 462 */     this.HandR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 463 */     this.HandR3.func_78790_a(-8.0F, -5.5F, -3.5F, 7, 1, 7, 0.0F);
/* 464 */     this.PSide2B = new ModelRenderer(this, 365, 57);
/* 465 */     this.PSide2B.func_78793_a(0.0F, -9.0F, 11.0F);
/* 466 */     this.PSide2B.func_78790_a(-8.5F, -3.5F, 0.0F, 17, 7, 2, 0.0F);
/* 467 */     this.Arm2R = new ModelRenderer(this, 150, 18);
/* 468 */     this.Arm2R.func_78793_a(-1.0F, -0.8F, -0.7F);
/* 469 */     this.Arm2R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 470 */     setRotateAngle(this.Arm2R, 0.34906584F, 0.0F, 1.134464F);
/* 471 */     this.HandR2 = new ModelRenderer(this, 185, 209);
/* 472 */     this.HandR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 473 */     this.HandR2.func_78790_a(-8.0F, -3.5F, 4.5F, 7, 7, 1, 0.0F);
/* 474 */     this.Arm3R = new ModelRenderer(this, 150, 18);
/* 475 */     this.Arm3R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 476 */     this.Arm3R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 477 */     setRotateAngle(this.Arm3R, -0.17453292F, 0.0F, -0.034906585F);
/* 478 */     this.Arm4L = new ModelRenderer(this, 150, 18);
/* 479 */     this.Arm4L.field_78809_i = true;
/* 480 */     this.Arm4L.func_78793_a(0.0F, 5.9F, 0.0F);
/* 481 */     this.Arm4L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 482 */     setRotateAngle(this.Arm4L, -0.17453292F, 0.0F, 0.034906585F);
/* 483 */     this.HandR = new ModelRenderer(this, 159, 104);
/* 484 */     this.HandR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 485 */     this.HandR.func_78790_a(-4.5F, 18.0F, -5.5F, 10, 7, 11, 0.0F);
/* 486 */     this.HandR5 = new ModelRenderer(this, 203, 209);
/* 487 */     this.HandR5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 488 */     this.HandR5.func_78790_a(-9.7F, -3.6F, -3.4F, 1, 7, 7, 0.0F);
/* 489 */     this.Arm11L = new ModelRenderer(this, 150, 63);
/* 490 */     this.Arm11L.field_78809_i = true;
/* 491 */     this.Arm11L.func_78793_a(0.0F, 0.0F, 0.0F);
/* 492 */     this.Arm11L.func_78790_a(-5.0F, 4.0F, -6.0F, 10, 2, 12, 0.0F);
/* 493 */     this.Arm4R = new ModelRenderer(this, 150, 18);
/* 494 */     this.Arm4R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 495 */     this.Arm4R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 496 */     setRotateAngle(this.Arm4R, -0.17453292F, 0.0F, -0.034906585F);
/* 497 */     this.Arm9R = new ModelRenderer(this, 150, 38);
/* 498 */     this.Arm9R.func_78793_a(0.0F, 5.1F, 0.0F);
/* 499 */     this.Arm9R.func_78790_a(-3.0F, 0.0F, -4.0F, 6, 2, 8, 0.0F);
/* 500 */     setRotateAngle(this.Arm9R, -0.34906584F, 0.0F, 0.0F);
/* 501 */     this.LegL5 = new ModelRenderer(this, 136, 222);
/* 502 */     this.LegL5.field_78809_i = true;
/* 503 */     this.LegL5.func_78793_a(0.0F, 14.0F, 0.0F);
/* 504 */     this.LegL5.func_78790_a(-5.5F, 0.4F, -7.2F, 11, 6, 13, 0.0F);
/* 505 */     setRotateAngle(this.LegL5, -0.09599311F, 0.0F, 0.0F);
/* 506 */     this.PShoulderL = new ModelRenderer(this, 450, 18);
/* 507 */     this.PShoulderL.field_78809_i = true;
/* 508 */     this.PShoulderL.func_78793_a(6.0F, -15.0F, 0.5F);
/* 509 */     this.PShoulderL.func_78790_a(-0.3F, -4.0F, -5.0F, 12, 8, 10, 0.0F);
/* 510 */     this.KoitsukaiHead = new ModelRenderer(this, 0, 0);
/* 511 */     this.KoitsukaiHead.func_78793_a(0.0F, -62.8F, 0.0F);
/* 512 */     this.KoitsukaiHead.func_78790_a(-3.5F, 0.0F, -8.0F, 7, 7, 16, 0.0F);
/* 513 */     this.PSide1F = new ModelRenderer(this, 315, 83);
/* 514 */     this.PSide1F.func_78793_a(0.0F, -0.5F, -12.8F);
/* 515 */     this.PSide1F.func_78790_a(-9.5F, -5.0F, -1.7F, 19, 10, 2, 0.0F);
/* 516 */     this.BodyBackR = new ModelRenderer(this, 93, 64);
/* 517 */     this.BodyBackR.func_78793_a(-5.0F, 9.0F, 6.2F);
/* 518 */     this.BodyBackR.func_78790_a(-1.0F, -2.8F, -0.4F, 2, 8, 2, 0.0F);
/* 519 */     this.BSideL2 = new ModelRenderer(this, 129, 131);
/* 520 */     this.BSideL2.field_78809_i = true;
/* 521 */     this.BSideL2.func_78793_a(3.0F, 0.0F, 0.0F);
/* 522 */     this.BSideL2.func_78790_a(-0.5F, -4.2F, -5.0F, 4, 8, 10, 0.0F);
/* 523 */     setRotateAngle(this.BSideL2, 0.0F, 0.0F, 0.17453292F);
/* 524 */     this.Arm5R = new ModelRenderer(this, 150, 18);
/* 525 */     this.Arm5R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 526 */     this.Arm5R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 527 */     setRotateAngle(this.Arm5R, -0.17453292F, 0.0F, -0.034906585F);
/* 528 */     this.HandR1 = new ModelRenderer(this, 221, 209);
/* 529 */     this.HandR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 530 */     this.HandR1.func_78790_a(-8.0F, -3.5F, -5.5F, 7, 7, 1, 0.0F);
/* 531 */     this.Arm7R = new ModelRenderer(this, 150, 18);
/* 532 */     this.Arm7R.func_78793_a(0.0F, 5.9F, 0.0F);
/* 533 */     this.Arm7R.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 534 */     setRotateAngle(this.Arm7R, -0.17453292F, 0.0F, 0.0F);
/* 535 */     this.LegL6 = new ModelRenderer(this, 136, 243);
/* 536 */     this.LegL6.field_78809_i = true;
/* 537 */     this.LegL6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 538 */     this.LegL6.func_78790_a(-3.9F, 2.4F, -12.2F, 8, 4, 5, 0.0F);
/* 539 */     this.PSide1L = new ModelRenderer(this, 459, 73);
/* 540 */     this.PSide1L.field_78809_i = true;
/* 541 */     this.PSide1L.func_78793_a(12.8F, -0.5F, 0.0F);
/* 542 */     this.PSide1L.func_78790_a(-0.3F, -5.0F, -8.5F, 2, 10, 18, 0.0F);
/* 543 */     this.BLowerBodyB = new ModelRenderer(this, 68, 184);
/* 544 */     this.BLowerBodyB.func_78793_a(0.0F, 0.0F, 0.0F);
/* 545 */     this.BLowerBodyB.func_78790_a(-4.0F, 0.0F, 9.0F, 8, 5, 5, 0.0F);
/* 546 */     this.BodyTop2 = new ModelRenderer(this, 95, 44);
/* 547 */     this.BodyTop2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 548 */     this.BodyTop2.func_78790_a(-5.0F, -2.0F, -5.0F, 10, 1, 10, 0.0F);
/* 549 */     this.Arm6L = new ModelRenderer(this, 150, 18);
/* 550 */     this.Arm6L.field_78809_i = true;
/* 551 */     this.Arm6L.func_78793_a(0.0F, 5.9F, 0.0F);
/* 552 */     this.Arm6L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 553 */     setRotateAngle(this.Arm6L, -0.17453292F, 0.0F, 0.0F);
/* 554 */     this.Arm12R = new ModelRenderer(this, 191, 112);
/* 555 */     this.Arm12R.func_78793_a(0.0F, 0.0F, 0.0F);
/* 556 */     this.Arm12R.func_78790_a(-5.5F, 18.0F, -6.0F, 2, 3, 12, 0.0F);
/* 557 */     this.BSideR2 = new ModelRenderer(this, 129, 131);
/* 558 */     this.BSideR2.func_78793_a(-3.0F, 0.0F, 0.0F);
/* 559 */     this.BSideR2.func_78790_a(-3.4F, -4.2F, -5.0F, 4, 8, 10, 0.0F);
/* 560 */     setRotateAngle(this.BSideR2, 0.0F, 0.0F, -0.17453292F);
/* 561 */     this.Arm8L = new ModelRenderer(this, 150, 18);
/* 562 */     this.Arm8L.field_78809_i = true;
/* 563 */     this.Arm8L.func_78793_a(0.0F, 5.9F, 0.0F);
/* 564 */     this.Arm8L.func_78790_a(-2.0F, 0.1F, -2.0F, 4, 6, 4, 0.0F);
/* 565 */     setRotateAngle(this.Arm8L, -0.17453292F, 0.0F, 0.0F);
/* 566 */     this.PipeL2 = new ModelRenderer(this, 130, 184);
/* 567 */     this.PipeL2.field_78809_i = true;
/* 568 */     this.PipeL2.func_78793_a(0.1F, 0.2F, 12.1F);
/* 569 */     this.PipeL2.func_78790_a(-1.5F, -1.0F, -0.1F, 3, 4, 6, 0.0F);
/* 570 */     setRotateAngle(this.PipeL2, -1.0016445F, 0.0F, 0.0F);
/* 571 */     this.HandR.func_78792_a(this.Finger31R);
/* 572 */     this.KoitsukaiHead.func_78792_a(this.Head5);
/* 573 */     this.KoitsukaiBody.func_78792_a(this.ShoulderR);
/* 574 */     this.BoraretaBody.func_78792_a(this.BSideF);
/* 575 */     this.Head2.func_78792_a(this.Head3);
/* 576 */     this.PBody2.func_78792_a(this.PBody3);
/* 577 */     this.HandR.func_78792_a(this.Finger21R);
/* 578 */     this.PShoulderR.func_78792_a(this.PHandR);
/* 579 */     this.Arm11L.func_78792_a(this.Arm13L);
/* 580 */     this.Arm13L.func_78792_a(this.ArmVentL);
/* 581 */     this.LegL3.func_78792_a(this.LegL4);
/* 582 */     this.Arm8L.func_78792_a(this.Arm9L);
/* 583 */     this.Arm9L.func_78792_a(this.Arm10L);
/* 584 */     this.Finger21R.func_78792_a(this.Finger22R);
/* 585 */     this.KoitsukaiBody.func_78792_a(this.BodyTop1);
/* 586 */     this.PanchiaBody.func_78792_a(this.PBody2);
/* 587 */     this.Finger31L.func_78792_a(this.Finger32L);
/* 588 */     this.Arm13L.func_78792_a(this.HandL);
/* 589 */     this.Arm11R.func_78792_a(this.Arm13R);
/* 590 */     this.PBody2.func_78792_a(this.PShoulderR);
/* 591 */     this.LegR4.func_78792_a(this.LegR5);
/* 592 */     this.BLowerBody.func_78792_a(this.BLowerBodyF);
/* 593 */     this.Arm7R.func_78792_a(this.Arm8R);
/* 594 */     this.PBody2.func_78792_a(this.PSide2R);
/* 595 */     this.Finger11L.func_78792_a(this.Finger12L);
/* 596 */     this.PBody2.func_78792_a(this.extraL);
/* 597 */     this.LegL1.func_78792_a(this.LegL2);
/* 598 */     this.BoraretaBody.func_78792_a(this.BSideB);
/* 599 */     this.BHandL.func_78792_a(this.HandL3);
/* 600 */     this.LegR3.func_78792_a(this.LegR4);
/* 601 */     this.BoraretaBody.func_78792_a(this.BLowerBody);
/* 602 */     this.HandR.func_78792_a(this.Finger11R);
/* 603 */     this.KoitsukaiBody.func_78792_a(this.PanchiaBody);
/* 604 */     this.KoitsukaiBody.func_78792_a(this.BodyBackL);
/* 605 */     this.PBody2.func_78792_a(this.PSide2F);
/* 606 */     this.Arm6L.func_78792_a(this.Arm7L);
/* 607 */     this.Arm13L.func_78792_a(this.Arm12L);
/* 608 */     this.Pipes.func_78792_a(this.PipeL1);
/* 609 */     this.Arm10R.func_78792_a(this.Arm11R);
/* 610 */     this.BHandL.func_78792_a(this.HandL4);
/* 611 */     this.LegL2.func_78792_a(this.LegL3);
/* 612 */     this.Finger11R.func_78792_a(this.Finger12R);
/* 613 */     this.LegR4.func_78792_a(this.LegR8);
/* 614 */     this.PShoulderL.func_78792_a(this.PHandL);
/* 615 */     this.BLowerBodyB.func_78792_a(this.Pipes);
/* 616 */     this.BHandR.func_78792_a(this.HandR4);
/* 617 */     this.PanchiaBody.func_78792_a(this.PSide1R);
/* 618 */     this.BSideL2.func_78792_a(this.BHandL);
/* 619 */     this.LegR1.func_78792_a(this.LegR2);
/* 620 */     this.PanchiaBody.func_78792_a(this.PSide1B);
/* 621 */     this.BoraretaBody.func_78792_a(this.BSideL1);
/* 622 */     this.Arm2L.func_78792_a(this.Arm3L);
/* 623 */     this.Finger31R.func_78792_a(this.Finger32R);
/* 624 */     this.BHandL.func_78792_a(this.HandL5);
/* 625 */     this.KoitsukaiHead.func_78792_a(this.Head2);
/* 626 */     this.BHandL.func_78792_a(this.HandL1);
/* 627 */     this.HandL.func_78792_a(this.Finger21L);
/* 628 */     this.LegL4.func_78792_a(this.LegL8);
/* 629 */     this.KoitsukaiBody.func_78792_a(this.PanchiaHead);
/* 630 */     this.BHandL.func_78792_a(this.HandL2);
/* 631 */     this.LegR4.func_78792_a(this.LegR9);
/* 632 */     this.Arm1L.func_78792_a(this.Arm2L);
/* 633 */     this.Finger21L.func_78792_a(this.Finger22L);
/* 634 */     this.Arm5R.func_78792_a(this.Arm6R);
/* 635 */     this.BSideR2.func_78792_a(this.BHandR);
/* 636 */     this.PBody2.func_78792_a(this.PSide2L);
/* 637 */     this.PipeR1.func_78792_a(this.PipeR2);
/* 638 */     this.LegR2.func_78792_a(this.LegR3);
/* 639 */     this.Pipes.func_78792_a(this.PipeR1);
/* 640 */     this.HandL.func_78792_a(this.Finger11L);
/* 641 */     this.LegR5.func_78792_a(this.LegR6);
/* 642 */     this.LegR5.func_78792_a(this.LegR7);
/* 643 */     this.LegL5.func_78792_a(this.LegL7);
/* 644 */     this.BoraretaBody.func_78792_a(this.BSideR1);
/* 645 */     this.HandL.func_78792_a(this.Finger31L);
/* 646 */     this.Head3.func_78792_a(this.Head4);
/* 647 */     this.Arm13R.func_78792_a(this.ArmVentR);
/* 648 */     this.Arm9R.func_78792_a(this.Arm10R);
/* 649 */     this.PBody2.func_78792_a(this.extraR);
/* 650 */     this.KoitsukaiBody.func_78792_a(this.ShoulderL);
/* 651 */     this.Arm4L.func_78792_a(this.Arm5L);
/* 652 */     this.PanchiaBody.func_78792_a(this.BoraretaBody);
/* 653 */     this.LegL4.func_78792_a(this.LegL9);
/* 654 */     this.BHandR.func_78792_a(this.HandR3);
/* 655 */     this.PBody2.func_78792_a(this.PSide2B);
/* 656 */     this.Arm1R.func_78792_a(this.Arm2R);
/* 657 */     this.BHandR.func_78792_a(this.HandR2);
/* 658 */     this.Arm2R.func_78792_a(this.Arm3R);
/* 659 */     this.Arm3L.func_78792_a(this.Arm4L);
/* 660 */     this.Arm13R.func_78792_a(this.HandR);
/* 661 */     this.BHandR.func_78792_a(this.HandR5);
/* 662 */     this.Arm10L.func_78792_a(this.Arm11L);
/* 663 */     this.Arm3R.func_78792_a(this.Arm4R);
/* 664 */     this.Arm8R.func_78792_a(this.Arm9R);
/* 665 */     this.LegL4.func_78792_a(this.LegL5);
/* 666 */     this.PBody2.func_78792_a(this.PShoulderL);
/* 667 */     this.PanchiaBody.func_78792_a(this.PSide1F);
/* 668 */     this.KoitsukaiBody.func_78792_a(this.BodyBackR);
/* 669 */     this.BSideL1.func_78792_a(this.BSideL2);
/* 670 */     this.Arm4R.func_78792_a(this.Arm5R);
/* 671 */     this.BHandR.func_78792_a(this.HandR1);
/* 672 */     this.Arm6R.func_78792_a(this.Arm7R);
/* 673 */     this.LegL5.func_78792_a(this.LegL6);
/* 674 */     this.PanchiaBody.func_78792_a(this.PSide1L);
/* 675 */     this.BLowerBody.func_78792_a(this.BLowerBodyB);
/* 676 */     this.BodyTop1.func_78792_a(this.BodyTop2);
/* 677 */     this.Arm5L.func_78792_a(this.Arm6L);
/* 678 */     this.Arm13R.func_78792_a(this.Arm12R);
/* 679 */     this.BSideR1.func_78792_a(this.BSideR2);
/* 680 */     this.Arm7L.func_78792_a(this.Arm8L);
/* 681 */     this.PipeL1.func_78792_a(this.PipeL2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 686 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 689 */     this.LegL1.func_78785_a(f5);
/* 690 */     this.KoitsukaiHead.func_78785_a(f5);
/* 691 */     this.Arm1L.func_78785_a(f5);
/* 692 */     this.Arm1R.func_78785_a(f5);
/* 693 */     this.KoitsukaiBody.func_78785_a(f5);
/* 694 */     this.LegR1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 700 */     modelRenderer.field_78795_f = x;
/* 701 */     modelRenderer.field_78796_g = y;
/* 702 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 706 */     int calc = par7Entity.field_70173_aa;
/* 707 */     if (calc > 100) calc -= 100; 
/* 708 */     float r = 360.0F;
/* 709 */     float r2 = 180.0F;
/* 710 */     float n4 = par4;
/* 711 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 715 */     float ex = par7Entity.field_70173_aa;
/* 716 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 717 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 719 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 720 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 766 */     this.LegR1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 767 */     this.LegL1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */ 
/*     */ 
/*     */     
/* 771 */     this.LegR1.field_78796_g = 0.0F;
/* 772 */     this.LegL1.field_78796_g = 0.0F;
/* 773 */     this.Arm1R.field_78796_g = 0.0F;
/* 774 */     this.Arm1L.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 781 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKoichiarator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */