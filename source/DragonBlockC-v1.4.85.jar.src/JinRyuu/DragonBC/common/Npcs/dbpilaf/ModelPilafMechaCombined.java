/*     */ package JinRyuu.DragonBC.common.Npcs.dbpilaf;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelPilafMechaCombined
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Leg1R;
/*     */   public ModelRenderer Leg1L;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer BodyBack;
/*     */   public ModelRenderer BodyR;
/*     */   public ModelRenderer BodyL;
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer BodyBottom1;
/*     */   public ModelRenderer Back;
/*     */   public ModelRenderer PlateR;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer PlateL;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer BodyBottomR;
/*     */   public ModelRenderer BodyBottomL;
/*     */   public ModelRenderer BodyBottom2;
/*     */   public ModelRenderer BodyBottomR2;
/*     */   public ModelRenderer BodyBottomL2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmR4;
/*     */   public ModelRenderer handR;
/*     */   public ModelRenderer fingerR3;
/*     */   public ModelRenderer fingerR1;
/*     */   public ModelRenderer fingerR4;
/*     */   public ModelRenderer fingerR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmL4;
/*     */   public ModelRenderer handL;
/*     */   public ModelRenderer fingerL3;
/*     */   public ModelRenderer fingerL1;
/*     */   public ModelRenderer fingerL4;
/*     */   public ModelRenderer fingerL2;
/*     */   public ModelRenderer BodyBack_1;
/*     */   public ModelRenderer BodyFront;
/*     */   public ModelRenderer BodyR_1;
/*     */   public ModelRenderer BodyL_1;
/*     */   public ModelRenderer BodyBottom;
/*     */   public ModelRenderer BodyTop;
/*     */   public ModelRenderer Head1_1;
/*     */   public ModelRenderer Bottom;
/*     */   public ModelRenderer Head2_1;
/*     */   public ModelRenderer Leg2R;
/*     */   public ModelRenderer Leg3R;
/*     */   public ModelRenderer KneeR;
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer Leg2L;
/*     */   public ModelRenderer Leg3L;
/*     */   public ModelRenderer KneeL;
/*     */   public ModelRenderer FootL;
/*     */   public ModelRenderer BodyBack_2;
/*     */   public ModelRenderer BodyFront_1;
/*     */   public ModelRenderer BodyR_2;
/*     */   public ModelRenderer BodyL_2;
/*     */   public ModelRenderer BodyTop_1;
/*     */   public ModelRenderer Head1_2;
/*     */   public ModelRenderer Back_1;
/*     */   public ModelRenderer PlateR_1;
/*     */   public ModelRenderer PlateL_1;
/*     */   public ModelRenderer Head2_2;
/*     */   
/*     */   public ModelPilafMechaCombined() {
/*  81 */     this.field_78090_t = 512;
/*  82 */     this.field_78089_u = 256;
/*  83 */     this.KneeR = new ModelRenderer(this, 147, 91);
/*  84 */     this.KneeR.func_78793_a(0.0F, 1.6F, 0.0F);
/*  85 */     this.KneeR.func_78790_a(-1.5F, -2.7F, -3.0F, 3, 4, 1, 0.0F);
/*  86 */     this.Back = new ModelRenderer(this, 149, 188);
/*  87 */     this.Back.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.Back.func_78790_a(-4.5F, -17.4F, 9.5F, 9, 18, 5, 0.0F);
/*  89 */     this.BodyTop_1 = new ModelRenderer(this, 0, 34);
/*  90 */     this.BodyTop_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.BodyTop_1.func_78790_a(-5.5F, -9.6F, -5.0F, 11, 2, 10, 0.0F);
/*  92 */     this.Head1 = new ModelRenderer(this, 72, 128);
/*  93 */     this.Head1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.Head1.func_78790_a(-6.0F, -19.8F, -8.8F, 12, 16, 14, 0.0F);
/*  95 */     this.fingerR2 = new ModelRenderer(this, 100, 234);
/*  96 */     this.fingerR2.func_78793_a(-0.3F, 3.4F, 0.0F);
/*  97 */     this.fingerR2.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/*  98 */     setRotateAngle(this.fingerR2, 0.0F, 0.0F, -0.9599311F);
/*  99 */     this.BodyTop = new ModelRenderer(this, 122, 34);
/* 100 */     this.BodyTop.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.BodyTop.func_78790_a(-7.0F, -9.6F, -6.0F, 14, 2, 13, 0.0F);
/* 102 */     this.Leg2L = new ModelRenderer(this, 148, 73);
/* 103 */     this.Leg2L.field_78809_i = true;
/* 104 */     this.Leg2L.func_78793_a(0.0F, 4.6F, 0.0F);
/* 105 */     this.Leg2L.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 11, 3, 0.0F);
/* 106 */     setRotateAngle(this.Leg2L, -0.31415927F, 0.0F, 0.0F);
/* 107 */     this.ArmR2 = new ModelRenderer(this, 70, 215);
/* 108 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.ArmR2.func_78790_a(-1.3F, -0.4F, -1.1F, 2, 12, 3, 0.0F);
/* 110 */     setRotateAngle(this.ArmR2, 0.11082841F, 0.0F, 0.5009095F);
/* 111 */     this.BodyL = new ModelRenderer(this, 97, 160);
/* 112 */     this.BodyL.field_78809_i = true;
/* 113 */     this.BodyL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 114 */     this.BodyL.func_78790_a(9.0F, -17.0F, -6.5F, 7, 15, 14, 0.0F);
/* 115 */     this.Leg1L = new ModelRenderer(this, 123, 71);
/* 116 */     this.Leg1L.field_78809_i = true;
/* 117 */     this.Leg1L.func_78793_a(10.7F, -9.5F, 1.5F);
/* 118 */     this.Leg1L.func_78790_a(-3.0F, -2.0F, -3.0F, 5, 7, 6, 0.0F);
/* 119 */     this.BodyBottomL2 = new ModelRenderer(this, 31, 194);
/* 120 */     this.BodyBottomL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 121 */     this.BodyBottomL2.func_78790_a(10.2F, 8.8F, -7.7F, 5, 2, 14, 0.0F);
/* 122 */     this.ArmL2 = new ModelRenderer(this, 70, 215);
/* 123 */     this.ArmL2.field_78809_i = true;
/* 124 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 125 */     this.ArmL2.func_78790_a(-1.3F, -0.4F, -1.1F, 2, 12, 3, 0.0F);
/* 126 */     setRotateAngle(this.ArmL2, 0.11082841F, 0.0F, -0.5009095F);
/* 127 */     this.fingerR1 = new ModelRenderer(this, 100, 234);
/* 128 */     this.fingerR1.func_78793_a(-0.7F, 0.0F, 0.0F);
/* 129 */     this.fingerR1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 130 */     setRotateAngle(this.fingerR1, 0.0F, 0.0F, 0.6981317F);
/* 131 */     this.Head2_1 = new ModelRenderer(this, 200, 30);
/* 132 */     this.Head2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 133 */     this.Head2_1.func_78790_a(-5.0F, -3.0F, -10.7F, 10, 14, 13, 0.0F);
/* 134 */     this.Leg1R = new ModelRenderer(this, 123, 71);
/* 135 */     this.Leg1R.func_78793_a(-10.7F, -9.5F, 1.5F);
/* 136 */     this.Leg1R.func_78790_a(-2.0F, -2.0F, -3.0F, 5, 7, 6, 0.0F);
/* 137 */     this.ArmL4 = new ModelRenderer(this, 81, 221);
/* 138 */     this.ArmL4.field_78809_i = true;
/* 139 */     this.ArmL4.func_78793_a(0.0F, 0.0F, 1.3F);
/* 140 */     this.ArmL4.func_78790_a(0.7F, -1.9F, -1.9F, 2, 6, 3, 0.0F);
/* 141 */     this.Body2 = new ModelRenderer(this, 122, 0);
/* 142 */     this.Body2.func_78793_a(0.0F, -17.0F, 0.0F);
/* 143 */     this.Body2.func_78790_a(-9.0F, -8.0F, -7.4F, 18, 16, 16, 0.0F);
/* 144 */     this.fingerL2 = new ModelRenderer(this, 100, 234);
/* 145 */     this.fingerL2.func_78793_a(-0.3F, 3.4F, 0.0F);
/* 146 */     this.fingerL2.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 147 */     setRotateAngle(this.fingerL2, 0.0F, 0.0F, -0.9599311F);
/* 148 */     this.BodyBottomR = new ModelRenderer(this, 56, 173);
/* 149 */     this.BodyBottomR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 150 */     this.BodyBottomR.func_78790_a(-17.0F, -2.9F, -9.2F, 7, 12, 20, 0.0F);
/* 151 */     this.BodyBottomL = new ModelRenderer(this, 56, 173);
/* 152 */     this.BodyBottomL.field_78809_i = true;
/* 153 */     this.BodyBottomL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 154 */     this.BodyBottomL.func_78790_a(10.0F, -2.9F, -9.2F, 7, 12, 20, 0.0F);
/* 155 */     this.ArmR4 = new ModelRenderer(this, 81, 221);
/* 156 */     this.ArmR4.func_78793_a(0.0F, 0.0F, 1.3F);
/* 157 */     this.ArmR4.func_78790_a(-3.3F, -1.9F, -2.0F, 2, 6, 3, 0.0F);
/* 158 */     this.PlateR_1 = new ModelRenderer(this, 44, 52);
/* 159 */     this.PlateR_1.func_78793_a(-9.4F, -5.0F, 0.0F);
/* 160 */     this.PlateR_1.func_78790_a(-1.0F, -0.4F, -3.5F, 1, 8, 7, 0.0F);
/* 161 */     this.BodyBottomR2 = new ModelRenderer(this, 31, 194);
/* 162 */     this.BodyBottomR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 163 */     this.BodyBottomR2.func_78790_a(-15.3F, 8.8F, -7.7F, 5, 2, 14, 0.0F);
/* 164 */     this.fingerL1 = new ModelRenderer(this, 100, 234);
/* 165 */     this.fingerL1.func_78793_a(-0.7F, 0.0F, 0.0F);
/* 166 */     this.fingerL1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 167 */     setRotateAngle(this.fingerL1, 0.0F, 0.0F, 0.6981317F);
/* 168 */     this.Head1_1 = new ModelRenderer(this, 194, 0);
/* 169 */     this.Head1_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 170 */     this.Head1_1.func_78790_a(-6.0F, -4.6F, -10.0F, 12, 15, 14, 0.0F);
/* 171 */     this.Back_1 = new ModelRenderer(this, 82, 62);
/* 172 */     this.Back_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 173 */     this.Back_1.func_78790_a(-4.0F, -8.5F, 4.7F, 8, 11, 6, 0.0F);
/* 174 */     this.BodyL_2 = new ModelRenderer(this, 44, 29);
/* 175 */     this.BodyL_2.field_78809_i = true;
/* 176 */     this.BodyL_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 177 */     this.BodyL_2.func_78790_a(7.5F, -6.5F, -6.0F, 2, 10, 11, 0.0F);
/* 178 */     this.ArmR1 = new ModelRenderer(this, 70, 208);
/* 179 */     this.ArmR1.func_78793_a(-16.2F, -36.0F, 0.0F);
/* 180 */     this.ArmR1.func_78790_a(-0.7F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
/* 181 */     this.PlateR = new ModelRenderer(this, 130, 162);
/* 182 */     this.PlateR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 183 */     this.PlateR.func_78790_a(-14.0F, -9.7F, -8.5F, 6, 6, 2, 0.0F);
/* 184 */     this.BodyBottom1 = new ModelRenderer(this, 0, 171);
/* 185 */     this.BodyBottom1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 186 */     this.BodyBottom1.func_78790_a(-14.0F, -4.0F, 5.7F, 28, 14, 7, 0.0F);
/* 187 */     this.BodyBack_2 = new ModelRenderer(this, 1, 51);
/* 188 */     this.BodyBack_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 189 */     this.BodyBack_2.func_78790_a(-6.0F, -6.5F, 6.0F, 12, 10, 2, 0.0F);
/* 190 */     this.ArmL3 = new ModelRenderer(this, 70, 233);
/* 191 */     this.ArmL3.field_78809_i = true;
/* 192 */     this.ArmL3.func_78793_a(0.0F, 10.8F, 0.1F);
/* 193 */     this.ArmL3.func_78790_a(-2.7F, 0.0F, -2.1F, 5, 12, 5, 0.0F);
/* 194 */     setRotateAngle(this.ArmL3, -0.4553564F, 0.0F, 0.0F);
/* 195 */     this.Head2_2 = new ModelRenderer(this, 78, 26);
/* 196 */     this.Head2_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 197 */     this.Head2_2.func_78790_a(-4.0F, -11.0F, -10.5F, 8, 12, 11, 0.0F);
/* 198 */     this.ArmL1 = new ModelRenderer(this, 70, 208);
/* 199 */     this.ArmL1.field_78809_i = true;
/* 200 */     this.ArmL1.func_78793_a(16.6F, -36.0F, 0.0F);
/* 201 */     this.ArmL1.func_78790_a(-2.7F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
/* 202 */     this.Head2 = new ModelRenderer(this, 126, 129);
/* 203 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 204 */     this.Head2.func_78790_a(-5.0F, -20.6F, -9.6F, 10, 16, 13, 0.0F);
/* 205 */     this.PlateL_1 = new ModelRenderer(this, 44, 52);
/* 206 */     this.PlateL_1.field_78809_i = true;
/* 207 */     this.PlateL_1.func_78793_a(9.4F, -5.0F, 0.0F);
/* 208 */     this.PlateL_1.func_78790_a(0.0F, -0.4F, -3.5F, 1, 8, 7, 0.0F);
/* 209 */     this.BodyBack = new ModelRenderer(this, 118, 191);
/* 210 */     this.BodyBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 211 */     this.BodyBack.func_78790_a(-7.0F, -15.7F, 9.6F, 14, 13, 1, 0.0F);
/* 212 */     this.FootL = new ModelRenderer(this, 123, 113);
/* 213 */     this.FootL.field_78809_i = true;
/* 214 */     this.FootL.func_78793_a(0.0F, 17.0F, 0.0F);
/* 215 */     this.FootL.func_78790_a(-2.0F, 0.0F, -6.0F, 4, 2, 11, 0.0F);
/* 216 */     this.ShoulderR = new ModelRenderer(this, 143, 164);
/* 217 */     this.ShoulderR.func_78793_a(-15.0F, -15.2F, 0.5F);
/* 218 */     this.ShoulderR.func_78790_a(-2.0F, -2.5F, -5.0F, 4, 11, 10, 0.0F);
/* 219 */     this.Leg3L = new ModelRenderer(this, 123, 87);
/* 220 */     this.Leg3L.field_78809_i = true;
/* 221 */     this.Leg3L.func_78793_a(0.0F, 10.7F, -0.1F);
/* 222 */     this.Leg3L.func_78790_a(-3.0F, -0.1F, -2.5F, 6, 18, 5, 0.0F);
/* 223 */     setRotateAngle(this.Leg3L, 0.31415927F, 0.0F, 0.0F);
/* 224 */     this.fingerR4 = new ModelRenderer(this, 100, 234);
/* 225 */     this.fingerR4.func_78793_a(0.3F, 3.4F, 0.0F);
/* 226 */     this.fingerR4.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 227 */     setRotateAngle(this.fingerR4, 0.0F, 0.0F, 0.9599311F);
/* 228 */     this.handR = new ModelRenderer(this, 100, 228);
/* 229 */     this.handR.func_78793_a(0.0F, 12.5F, 0.0F);
/* 230 */     this.handR.func_78790_a(-1.0F, -0.5F, -1.6F, 2, 1, 3, 0.0F);
/* 231 */     this.fingerR3 = new ModelRenderer(this, 100, 234);
/* 232 */     this.fingerR3.func_78793_a(0.8F, 0.0F, 0.0F);
/* 233 */     this.fingerR3.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 234 */     setRotateAngle(this.fingerR3, 0.0F, 0.0F, -0.6981317F);
/* 235 */     this.Leg2R = new ModelRenderer(this, 148, 73);
/* 236 */     this.Leg2R.func_78793_a(0.0F, 4.6F, 0.0F);
/* 237 */     this.Leg2R.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 11, 3, 0.0F);
/* 238 */     setRotateAngle(this.Leg2R, -0.31415927F, 0.0F, 0.0F);
/* 239 */     this.BodyBottom = new ModelRenderer(this, 122, 34);
/* 240 */     this.BodyBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 241 */     this.BodyBottom.func_78790_a(-7.0F, 7.8F, -6.0F, 14, 2, 13, 0.0F);
/* 242 */     this.ShoulderL = new ModelRenderer(this, 143, 164);
/* 243 */     this.ShoulderL.field_78809_i = true;
/* 244 */     this.ShoulderL.func_78793_a(15.0F, -15.2F, 0.5F);
/* 245 */     this.ShoulderL.func_78790_a(-2.0F, -2.5F, -5.0F, 4, 11, 10, 0.0F);
/* 246 */     this.BodyBack_1 = new ModelRenderer(this, 122, 54);
/* 247 */     this.BodyBack_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 248 */     this.BodyBack_1.func_78790_a(-7.0F, -6.5F, 8.3F, 14, 13, 2, 0.0F);
/* 249 */     this.ArmR3 = new ModelRenderer(this, 70, 233);
/* 250 */     this.ArmR3.func_78793_a(0.0F, 10.8F, 0.1F);
/* 251 */     this.ArmR3.func_78790_a(-2.7F, 0.0F, -2.1F, 5, 12, 5, 0.0F);
/* 252 */     setRotateAngle(this.ArmR3, -0.4553564F, 0.0F, 0.0F);
/* 253 */     this.fingerL3 = new ModelRenderer(this, 100, 234);
/* 254 */     this.fingerL3.func_78793_a(0.8F, 0.0F, 0.0F);
/* 255 */     this.fingerL3.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 256 */     setRotateAngle(this.fingerL3, 0.0F, 0.0F, -0.6981317F);
/* 257 */     this.BodyR_1 = new ModelRenderer(this, 166, 42);
/* 258 */     this.BodyR_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 259 */     this.BodyR_1.func_78790_a(-10.5F, -6.5F, -6.5F, 2, 13, 14, 0.0F);
/* 260 */     this.Leg3R = new ModelRenderer(this, 123, 87);
/* 261 */     this.Leg3R.func_78793_a(0.0F, 10.7F, -0.1F);
/* 262 */     this.Leg3R.func_78790_a(-3.0F, -0.1F, -2.5F, 6, 18, 5, 0.0F);
/* 263 */     setRotateAngle(this.Leg3R, 0.31415927F, 0.0F, 0.0F);
/* 264 */     this.KneeL = new ModelRenderer(this, 147, 91);
/* 265 */     this.KneeL.field_78809_i = true;
/* 266 */     this.KneeL.func_78793_a(0.0F, 1.6F, 0.0F);
/* 267 */     this.KneeL.func_78790_a(-1.5F, -2.7F, -3.0F, 3, 4, 1, 0.0F);
/* 268 */     this.BodyFront = new ModelRenderer(this, 122, 54);
/* 269 */     this.BodyFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 270 */     this.BodyFront.func_78790_a(-7.0F, -6.5F, -8.9F, 14, 13, 2, 0.0F);
/* 271 */     this.BodyBottom2 = new ModelRenderer(this, 0, 193);
/* 272 */     this.BodyBottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 273 */     this.BodyBottom2.func_78790_a(-11.0F, -4.1F, -7.9F, 22, 13, 0, 0.0F);
/* 274 */     this.BodyFront_1 = new ModelRenderer(this, 1, 51);
/* 275 */     this.BodyFront_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 276 */     this.BodyFront_1.func_78790_a(-6.0F, -6.5F, -9.0F, 12, 10, 2, 0.0F);
/* 277 */     setRotateAngle(this.BodyFront_1, 0.0F, -0.014486233F, 0.0F);
/* 278 */     this.BodyL_1 = new ModelRenderer(this, 166, 42);
/* 279 */     this.BodyL_1.field_78809_i = true;
/* 280 */     this.BodyL_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 281 */     this.BodyL_1.func_78790_a(8.5F, -6.5F, -6.5F, 2, 13, 14, 0.0F);
/* 282 */     this.Bottom = new ModelRenderer(this, 237, 47);
/* 283 */     this.Bottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 284 */     this.Bottom.func_78790_a(-3.0F, 9.3F, -8.1F, 6, 6, 14, 0.0F);
/* 285 */     this.Body1 = new ModelRenderer(this, 0, 128);
/* 286 */     this.Body1.func_78793_a(0.0F, -21.3F, -2.2F);
/* 287 */     this.Body1.func_78790_a(-9.0F, -18.7F, -7.4F, 18, 21, 17, 0.0F);
/* 288 */     this.BodyR = new ModelRenderer(this, 97, 160);
/* 289 */     this.BodyR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 290 */     this.BodyR.func_78790_a(-16.0F, -17.0F, -6.5F, 7, 15, 14, 0.0F);
/* 291 */     this.PlateL = new ModelRenderer(this, 130, 162);
/* 292 */     this.PlateL.field_78809_i = true;
/* 293 */     this.PlateL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 294 */     this.PlateL.func_78790_a(8.0F, -9.7F, -8.5F, 6, 6, 2, 0.0F);
/* 295 */     this.BodyR_2 = new ModelRenderer(this, 44, 29);
/* 296 */     this.BodyR_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 297 */     this.BodyR_2.func_78790_a(-9.5F, -6.5F, -6.0F, 2, 10, 11, 0.0F);
/* 298 */     this.Body3 = new ModelRenderer(this, 0, 0);
/* 299 */     this.Body3.func_78793_a(0.0F, -46.7F, 0.0F);
/* 300 */     this.Body3.func_78790_a(-7.5F, -8.0F, -7.0F, 15, 13, 13, 0.0F);
/* 301 */     this.fingerL4 = new ModelRenderer(this, 100, 234);
/* 302 */     this.fingerL4.func_78793_a(0.3F, 3.4F, 0.0F);
/* 303 */     this.fingerL4.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 304 */     setRotateAngle(this.fingerL4, 0.0F, 0.0F, 0.9599311F);
/* 305 */     this.FootR = new ModelRenderer(this, 123, 113);
/* 306 */     this.FootR.func_78793_a(0.0F, 17.0F, 0.0F);
/* 307 */     this.FootR.func_78790_a(-2.0F, 0.0F, -6.0F, 4, 2, 11, 0.0F);
/* 308 */     this.Head1_2 = new ModelRenderer(this, 72, 0);
/* 309 */     this.Head1_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 310 */     this.Head1_2.func_78790_a(-5.0F, -10.5F, -9.6F, 10, 12, 12, 0.0F);
/* 311 */     this.handL = new ModelRenderer(this, 100, 228);
/* 312 */     this.handL.field_78809_i = true;
/* 313 */     this.handL.func_78793_a(-0.4F, 12.5F, 0.0F);
/* 314 */     this.handL.func_78790_a(-1.0F, -0.5F, -1.6F, 2, 1, 3, 0.0F);
/* 315 */     this.Leg3R.func_78792_a(this.KneeR);
/* 316 */     this.BodyBack.func_78792_a(this.Back);
/* 317 */     this.Body3.func_78792_a(this.BodyTop_1);
/* 318 */     this.Body1.func_78792_a(this.Head1);
/* 319 */     this.fingerR1.func_78792_a(this.fingerR2);
/* 320 */     this.Body2.func_78792_a(this.BodyTop);
/* 321 */     this.Leg1L.func_78792_a(this.Leg2L);
/* 322 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 323 */     this.Body1.func_78792_a(this.BodyL);
/* 324 */     this.BodyBottomL.func_78792_a(this.BodyBottomL2);
/* 325 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 326 */     this.handR.func_78792_a(this.fingerR1);
/* 327 */     this.Head1_1.func_78792_a(this.Head2_1);
/* 328 */     this.ArmL3.func_78792_a(this.ArmL4);
/* 329 */     this.fingerL1.func_78792_a(this.fingerL2);
/* 330 */     this.BodyBottom1.func_78792_a(this.BodyBottomR);
/* 331 */     this.BodyBottom1.func_78792_a(this.BodyBottomL);
/* 332 */     this.ArmR3.func_78792_a(this.ArmR4);
/* 333 */     this.BodyR_2.func_78792_a(this.PlateR_1);
/* 334 */     this.BodyBottomR.func_78792_a(this.BodyBottomR2);
/* 335 */     this.handL.func_78792_a(this.fingerL1);
/* 336 */     this.Body2.func_78792_a(this.Head1_1);
/* 337 */     this.BodyBack_2.func_78792_a(this.Back_1);
/* 338 */     this.Body3.func_78792_a(this.BodyL_2);
/* 339 */     this.BodyR.func_78792_a(this.PlateR);
/* 340 */     this.Body1.func_78792_a(this.BodyBottom1);
/* 341 */     this.Body3.func_78792_a(this.BodyBack_2);
/* 342 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 343 */     this.Head1_2.func_78792_a(this.Head2_2);
/* 344 */     this.Head1.func_78792_a(this.Head2);
/* 345 */     this.BodyL_2.func_78792_a(this.PlateL_1);
/* 346 */     this.Body1.func_78792_a(this.BodyBack);
/* 347 */     this.Leg3L.func_78792_a(this.FootL);
/* 348 */     this.BodyR.func_78792_a(this.ShoulderR);
/* 349 */     this.Leg2L.func_78792_a(this.Leg3L);
/* 350 */     this.fingerR3.func_78792_a(this.fingerR4);
/* 351 */     this.ArmR4.func_78792_a(this.handR);
/* 352 */     this.handR.func_78792_a(this.fingerR3);
/* 353 */     this.Leg1R.func_78792_a(this.Leg2R);
/* 354 */     this.Body2.func_78792_a(this.BodyBottom);
/* 355 */     this.BodyL.func_78792_a(this.ShoulderL);
/* 356 */     this.Body2.func_78792_a(this.BodyBack_1);
/* 357 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 358 */     this.handL.func_78792_a(this.fingerL3);
/* 359 */     this.Body2.func_78792_a(this.BodyR_1);
/* 360 */     this.Leg2R.func_78792_a(this.Leg3R);
/* 361 */     this.Leg3L.func_78792_a(this.KneeL);
/* 362 */     this.Body2.func_78792_a(this.BodyFront);
/* 363 */     this.BodyBottom1.func_78792_a(this.BodyBottom2);
/* 364 */     this.Body3.func_78792_a(this.BodyFront_1);
/* 365 */     this.Body2.func_78792_a(this.BodyL_1);
/* 366 */     this.BodyBottom.func_78792_a(this.Bottom);
/* 367 */     this.Body1.func_78792_a(this.BodyR);
/* 368 */     this.BodyL.func_78792_a(this.PlateL);
/* 369 */     this.Body3.func_78792_a(this.BodyR_2);
/* 370 */     this.fingerL3.func_78792_a(this.fingerL4);
/* 371 */     this.Leg3R.func_78792_a(this.FootR);
/* 372 */     this.Body3.func_78792_a(this.Head1_2);
/* 373 */     this.ArmL4.func_78792_a(this.handL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 378 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 380 */     GL11.glPushMatrix();
/* 381 */     float F = 1.5F;
/* 382 */     JGRenderHelper.modelScalePositionHelper(1.5F);
/*     */     
/* 384 */     this.Body1.func_78785_a(f5);
/* 385 */     this.Body2.func_78785_a(f5);
/* 386 */     this.Body3.func_78785_a(f5);
/* 387 */     this.ArmR1.func_78785_a(f5);
/* 388 */     this.ArmL1.func_78785_a(f5);
/* 389 */     this.Leg1L.func_78785_a(f5);
/* 390 */     this.Leg1R.func_78785_a(f5);
/*     */     
/* 392 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 396 */     modelRenderer.field_78795_f = x;
/* 397 */     modelRenderer.field_78796_g = y;
/* 398 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 402 */     int calc = par7Entity.field_70173_aa;
/* 403 */     if (calc > 100) calc -= 100; 
/* 404 */     float r = 360.0F;
/* 405 */     float r2 = 180.0F;
/* 406 */     float n4 = par4;
/* 407 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 411 */     float ex = par7Entity.field_70173_aa;
/* 412 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 413 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 415 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 416 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 465 */     this.Leg1R.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 466 */     this.Leg1L.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 467 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 468 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 470 */     this.Leg1R.field_78796_g = 0.0F;
/* 471 */     this.Leg1L.field_78796_g = 0.0F;
/* 472 */     this.ArmR1.field_78796_g = 0.0F;
/* 473 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbpilaf\ModelPilafMechaCombined.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */