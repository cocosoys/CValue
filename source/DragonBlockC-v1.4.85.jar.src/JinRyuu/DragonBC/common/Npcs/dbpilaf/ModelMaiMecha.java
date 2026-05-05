/*     */ package JinRyuu.DragonBC.common.Npcs.dbpilaf;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelMaiMecha
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer Leg1R;
/*     */   public ModelRenderer Leg1L;
/*     */   public ModelRenderer Extra1;
/*     */   public ModelRenderer BodyBack;
/*     */   public ModelRenderer BodyR;
/*     */   public ModelRenderer BodyL;
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer Back;
/*     */   public ModelRenderer BodyBottom1;
/*     */   public ModelRenderer BodyBottomR;
/*     */   public ModelRenderer BodyBottomL;
/*     */   public ModelRenderer BodyBottom2;
/*     */   public ModelRenderer BodyBottomR2;
/*     */   public ModelRenderer BodyBottomL2;
/*     */   public ModelRenderer PlateR;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer PlateL;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer Head2;
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
/*     */   public ModelRenderer Leg2R;
/*     */   public ModelRenderer Leg3R;
/*     */   public ModelRenderer KneeR;
/*     */   public ModelRenderer FootR;
/*     */   public ModelRenderer Leg2L;
/*     */   public ModelRenderer Leg3L;
/*     */   public ModelRenderer KneeL;
/*     */   public ModelRenderer FootL;
/*     */   public ModelRenderer Extra2;
/*     */   public ModelRenderer Extra3;
/*     */   
/*     */   public ModelMaiMecha() {
/*  63 */     this.field_78090_t = 256;
/*  64 */     this.field_78089_u = 128;
/*  65 */     this.fingerR2 = new ModelRenderer(this, 100, 106);
/*  66 */     this.fingerR2.func_78793_a(-0.3F, 3.4F, 0.0F);
/*  67 */     this.fingerR2.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/*  68 */     setRotateAngle(this.fingerR2, 0.0F, 0.0F, -0.9599311F);
/*  69 */     this.ArmL1 = new ModelRenderer(this, 70, 80);
/*  70 */     this.ArmL1.field_78809_i = true;
/*  71 */     this.ArmL1.func_78793_a(16.6F, -13.0F, 0.0F);
/*  72 */     this.ArmL1.func_78790_a(-2.7F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
/*  73 */     this.fingerR4 = new ModelRenderer(this, 100, 106);
/*  74 */     this.fingerR4.func_78793_a(0.3F, 3.4F, 0.0F);
/*  75 */     this.fingerR4.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/*  76 */     setRotateAngle(this.fingerR4, 0.0F, 0.0F, 0.9599311F);
/*  77 */     this.BodyBottom2 = new ModelRenderer(this, 0, 65);
/*  78 */     this.BodyBottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.BodyBottom2.func_78790_a(-11.0F, -4.1F, -7.8F, 22, 13, 0, 0.0F);
/*  80 */     this.BodyBottomL2 = new ModelRenderer(this, 31, 66);
/*  81 */     this.BodyBottomL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.BodyBottomL2.func_78790_a(10.2F, 8.8F, -7.7F, 5, 2, 14, 0.0F);
/*  83 */     this.fingerL4 = new ModelRenderer(this, 100, 106);
/*  84 */     this.fingerL4.func_78793_a(0.3F, 3.4F, 0.0F);
/*  85 */     this.fingerL4.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/*  86 */     setRotateAngle(this.fingerL4, 0.0F, 0.0F, 0.9599311F);
/*  87 */     this.FootL = new ModelRenderer(this, 1, 113);
/*  88 */     this.FootL.field_78809_i = true;
/*  89 */     this.FootL.func_78793_a(0.0F, 9.0F, 0.0F);
/*  90 */     this.FootL.func_78790_a(-2.0F, -0.1F, -6.0F, 4, 2, 11, 0.0F);
/*  91 */     this.PlateR = new ModelRenderer(this, 130, 34);
/*  92 */     this.PlateR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  93 */     this.PlateR.func_78790_a(-14.0F, -9.7F, -8.5F, 6, 6, 2, 0.0F);
/*  94 */     this.handR = new ModelRenderer(this, 100, 100);
/*  95 */     this.handR.func_78793_a(0.0F, 12.5F, 0.0F);
/*  96 */     this.handR.func_78790_a(-1.0F, -0.5F, -1.6F, 2, 1, 3, 0.0F);
/*  97 */     this.ArmR2 = new ModelRenderer(this, 70, 87);
/*  98 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     this.ArmR2.func_78790_a(-1.3F, -0.4F, -1.1F, 2, 12, 3, 0.0F);
/* 100 */     setRotateAngle(this.ArmR2, 0.11082841F, 0.0F, 0.5009095F);
/* 101 */     this.BodyBack = new ModelRenderer(this, 118, 63);
/* 102 */     this.BodyBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.BodyBack.func_78790_a(-7.0F, -15.7F, 9.6F, 14, 13, 1, 0.0F);
/* 104 */     this.handL = new ModelRenderer(this, 100, 100);
/* 105 */     this.handL.field_78809_i = true;
/* 106 */     this.handL.func_78793_a(-0.4F, 12.5F, 0.0F);
/* 107 */     this.handL.func_78790_a(-1.0F, -0.5F, -1.6F, 2, 1, 3, 0.0F);
/* 108 */     this.BodyL = new ModelRenderer(this, 97, 32);
/* 109 */     this.BodyL.field_78809_i = true;
/* 110 */     this.BodyL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.BodyL.func_78790_a(9.0F, -17.0F, -6.5F, 7, 15, 14, 0.0F);
/* 112 */     this.Head2 = new ModelRenderer(this, 126, 1);
/* 113 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 114 */     this.Head2.func_78790_a(-5.0F, -20.6F, -10.0F, 10, 16, 13, 0.0F);
/* 115 */     this.fingerL2 = new ModelRenderer(this, 100, 106);
/* 116 */     this.fingerL2.func_78793_a(-0.3F, 3.4F, 0.0F);
/* 117 */     this.fingerL2.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 118 */     setRotateAngle(this.fingerL2, 0.0F, 0.0F, -0.9599311F);
/* 119 */     this.Leg3L = new ModelRenderer(this, 1, 98);
/* 120 */     this.Leg3L.field_78809_i = true;
/* 121 */     this.Leg3L.func_78793_a(0.0F, 5.3F, -0.1F);
/* 122 */     this.Leg3L.func_78790_a(-2.5F, -0.1F, -2.0F, 5, 9, 4, 0.0F);
/* 123 */     setRotateAngle(this.Leg3L, 0.6981317F, 0.0F, 0.0F);
/* 124 */     this.KneeL = new ModelRenderer(this, 20, 106);
/* 125 */     this.KneeL.field_78809_i = true;
/* 126 */     this.KneeL.func_78793_a(0.1F, 1.6F, 0.0F);
/* 127 */     this.KneeL.func_78790_a(-1.0F, -2.7F, -3.0F, 2, 3, 2, 0.0F);
/* 128 */     this.BodyBottomL = new ModelRenderer(this, 56, 45);
/* 129 */     this.BodyBottomL.field_78809_i = true;
/* 130 */     this.BodyBottomL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 131 */     this.BodyBottomL.func_78790_a(10.0F, -2.9F, -9.2F, 7, 12, 20, 0.0F);
/* 132 */     this.Extra3 = new ModelRenderer(this, 110, 7);
/* 133 */     this.Extra3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.Extra3.func_78790_a(-3.5F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
/* 135 */     this.fingerR1 = new ModelRenderer(this, 100, 106);
/* 136 */     this.fingerR1.func_78793_a(-0.7F, 0.0F, 0.0F);
/* 137 */     this.fingerR1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 138 */     setRotateAngle(this.fingerR1, 0.0F, 0.0F, 0.6981317F);
/* 139 */     this.fingerR3 = new ModelRenderer(this, 100, 106);
/* 140 */     this.fingerR3.func_78793_a(0.8F, 0.0F, 0.0F);
/* 141 */     this.fingerR3.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 142 */     setRotateAngle(this.fingerR3, 0.0F, 0.0F, -0.6981317F);
/* 143 */     this.ArmR3 = new ModelRenderer(this, 70, 105);
/* 144 */     this.ArmR3.func_78793_a(0.0F, 10.8F, 0.1F);
/* 145 */     this.ArmR3.func_78790_a(-2.7F, 0.0F, -2.1F, 5, 12, 5, 0.0F);
/* 146 */     setRotateAngle(this.ArmR3, -0.4553564F, 0.0F, 0.0F);
/* 147 */     this.BodyBottomR2 = new ModelRenderer(this, 31, 66);
/* 148 */     this.BodyBottomR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 149 */     this.BodyBottomR2.func_78790_a(-15.3F, 8.8F, -7.7F, 5, 2, 14, 0.0F);
/* 150 */     this.BodyBottom1 = new ModelRenderer(this, 0, 43);
/* 151 */     this.BodyBottom1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     this.BodyBottom1.func_78790_a(-14.0F, -4.0F, 5.7F, 28, 14, 7, 0.0F);
/* 153 */     this.Head1 = new ModelRenderer(this, 72, 0);
/* 154 */     this.Head1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.Head1.func_78790_a(-6.0F, -19.8F, -8.8F, 12, 16, 14, 0.0F);
/* 156 */     this.Extra2 = new ModelRenderer(this, 110, 9);
/* 157 */     this.Extra2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.Extra2.func_78790_a(2.9F, -0.5F, 0.5F, 1, 1, 4, 0.0F);
/* 159 */     this.BodyBottomR = new ModelRenderer(this, 56, 45);
/* 160 */     this.BodyBottomR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 161 */     this.BodyBottomR.func_78790_a(-17.0F, -2.9F, -9.2F, 7, 12, 20, 0.0F);
/* 162 */     this.ArmL3 = new ModelRenderer(this, 70, 105);
/* 163 */     this.ArmL3.field_78809_i = true;
/* 164 */     this.ArmL3.func_78793_a(0.0F, 10.8F, 0.1F);
/* 165 */     this.ArmL3.func_78790_a(-2.7F, 0.0F, -2.1F, 5, 12, 5, 0.0F);
/* 166 */     setRotateAngle(this.ArmL3, -0.4553564F, 0.0F, 0.0F);
/* 167 */     this.Leg2R = new ModelRenderer(this, 20, 88);
/* 168 */     this.Leg2R.func_78793_a(0.0F, 1.6F, 0.0F);
/* 169 */     this.Leg2R.func_78790_a(-1.5F, -0.1F, -1.0F, 3, 6, 2, 0.0F);
/* 170 */     setRotateAngle(this.Leg2R, -0.6981317F, 0.06981317F, 0.0F);
/* 171 */     this.PlateL = new ModelRenderer(this, 130, 34);
/* 172 */     this.PlateL.field_78809_i = true;
/* 173 */     this.PlateL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 174 */     this.PlateL.func_78790_a(8.0F, -9.7F, -8.5F, 6, 6, 2, 0.0F);
/* 175 */     this.fingerL3 = new ModelRenderer(this, 100, 106);
/* 176 */     this.fingerL3.func_78793_a(0.8F, 0.0F, 0.0F);
/* 177 */     this.fingerL3.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 178 */     setRotateAngle(this.fingerL3, 0.0F, 0.0F, -0.6981317F);
/* 179 */     this.ArmR4 = new ModelRenderer(this, 81, 93);
/* 180 */     this.ArmR4.func_78793_a(0.0F, 0.0F, 1.3F);
/* 181 */     this.ArmR4.func_78790_a(-3.3F, -1.9F, -2.0F, 2, 6, 3, 0.0F);
/* 182 */     this.Leg3R = new ModelRenderer(this, 1, 98);
/* 183 */     this.Leg3R.func_78793_a(0.0F, 5.3F, -0.1F);
/* 184 */     this.Leg3R.func_78790_a(-2.5F, -0.1F, -2.0F, 5, 9, 4, 0.0F);
/* 185 */     setRotateAngle(this.Leg3R, 0.6981317F, 0.0F, 0.0F);
/* 186 */     this.fingerL1 = new ModelRenderer(this, 100, 106);
/* 187 */     this.fingerL1.func_78793_a(-0.7F, 0.0F, 0.0F);
/* 188 */     this.fingerL1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
/* 189 */     setRotateAngle(this.fingerL1, 0.0F, 0.0F, 0.6981317F);
/* 190 */     this.KneeR = new ModelRenderer(this, 20, 106);
/* 191 */     this.KneeR.func_78793_a(0.1F, 1.6F, 0.0F);
/* 192 */     this.KneeR.func_78790_a(-1.0F, -2.7F, -3.0F, 2, 3, 2, 0.0F);
/* 193 */     this.Leg2L = new ModelRenderer(this, 20, 88);
/* 194 */     this.Leg2L.field_78809_i = true;
/* 195 */     this.Leg2L.func_78793_a(0.0F, 1.6F, 0.0F);
/* 196 */     this.Leg2L.func_78790_a(-1.5F, -0.1F, -1.0F, 3, 6, 2, 0.0F);
/* 197 */     setRotateAngle(this.Leg2L, -0.6981317F, -0.06981317F, 0.0F);
/* 198 */     this.BodyR = new ModelRenderer(this, 97, 32);
/* 199 */     this.BodyR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 200 */     this.BodyR.func_78790_a(-16.0F, -17.0F, -6.5F, 7, 15, 14, 0.0F);
/* 201 */     this.FootR = new ModelRenderer(this, 1, 113);
/* 202 */     this.FootR.func_78793_a(0.0F, 9.0F, 0.0F);
/* 203 */     this.FootR.func_78790_a(-2.0F, -0.1F, -6.0F, 4, 2, 11, 0.0F);
/* 204 */     this.Leg1R = new ModelRenderer(this, 3, 90);
/* 205 */     this.Leg1R.func_78793_a(-8.0F, 7.4F, 1.5F);
/* 206 */     this.Leg1R.func_78790_a(-2.0F, -1.5F, -1.5F, 4, 5, 3, 0.0F);
/* 207 */     this.ShoulderR = new ModelRenderer(this, 143, 36);
/* 208 */     this.ShoulderR.func_78793_a(-15.0F, -15.2F, 0.5F);
/* 209 */     this.ShoulderR.func_78790_a(-2.0F, -2.5F, -5.0F, 4, 11, 10, 0.0F);
/* 210 */     this.Body = new ModelRenderer(this, 0, 0);
/* 211 */     this.Body.func_78793_a(0.0F, 1.0F, 0.0F);
/* 212 */     this.Body.func_78790_a(-9.0F, -18.7F, -7.4F, 18, 24, 17, 0.0F);
/* 213 */     this.Leg1L = new ModelRenderer(this, 3, 90);
/* 214 */     this.Leg1L.field_78809_i = true;
/* 215 */     this.Leg1L.func_78793_a(8.0F, 7.4F, 1.5F);
/* 216 */     this.Leg1L.func_78790_a(-2.0F, -1.5F, -1.5F, 4, 5, 3, 0.0F);
/* 217 */     this.Extra1 = new ModelRenderer(this, 110, 9);
/* 218 */     this.Extra1.func_78793_a(-0.2F, 5.4F, -11.6F);
/* 219 */     this.Extra1.func_78790_a(-3.8F, -0.5F, 0.5F, 1, 1, 4, 0.0F);
/* 220 */     setRotateAngle(this.Extra1, 0.5009095F, 0.0F, 0.0F);
/* 221 */     this.ArmL4 = new ModelRenderer(this, 81, 93);
/* 222 */     this.ArmL4.field_78809_i = true;
/* 223 */     this.ArmL4.func_78793_a(0.0F, 0.0F, 1.3F);
/* 224 */     this.ArmL4.func_78790_a(0.7F, -1.9F, -1.9F, 2, 6, 3, 0.0F);
/* 225 */     this.ArmR1 = new ModelRenderer(this, 70, 80);
/* 226 */     this.ArmR1.func_78793_a(-16.2F, -13.0F, 0.0F);
/* 227 */     this.ArmR1.func_78790_a(-0.7F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
/* 228 */     this.Back = new ModelRenderer(this, 149, 60);
/* 229 */     this.Back.func_78793_a(0.0F, 0.0F, 0.0F);
/* 230 */     this.Back.func_78790_a(-4.5F, -17.4F, 9.5F, 9, 18, 5, 0.0F);
/* 231 */     this.ShoulderL = new ModelRenderer(this, 143, 36);
/* 232 */     this.ShoulderL.field_78809_i = true;
/* 233 */     this.ShoulderL.func_78793_a(15.0F, -15.2F, 0.5F);
/* 234 */     this.ShoulderL.func_78790_a(-2.0F, -2.5F, -5.0F, 4, 11, 10, 0.0F);
/* 235 */     this.ArmL2 = new ModelRenderer(this, 70, 87);
/* 236 */     this.ArmL2.field_78809_i = true;
/* 237 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 238 */     this.ArmL2.func_78790_a(-1.3F, -0.4F, -1.1F, 2, 12, 3, 0.0F);
/* 239 */     setRotateAngle(this.ArmL2, 0.11082841F, 0.0F, -0.5009095F);
/* 240 */     this.fingerR1.func_78792_a(this.fingerR2);
/* 241 */     this.fingerR3.func_78792_a(this.fingerR4);
/* 242 */     this.BodyBottom1.func_78792_a(this.BodyBottom2);
/* 243 */     this.BodyBottomL.func_78792_a(this.BodyBottomL2);
/* 244 */     this.fingerL3.func_78792_a(this.fingerL4);
/* 245 */     this.Leg3L.func_78792_a(this.FootL);
/* 246 */     this.BodyR.func_78792_a(this.PlateR);
/* 247 */     this.ArmR4.func_78792_a(this.handR);
/* 248 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 249 */     this.Body.func_78792_a(this.BodyBack);
/* 250 */     this.ArmL4.func_78792_a(this.handL);
/* 251 */     this.Body.func_78792_a(this.BodyL);
/* 252 */     this.Head1.func_78792_a(this.Head2);
/* 253 */     this.fingerL1.func_78792_a(this.fingerL2);
/* 254 */     this.Leg2L.func_78792_a(this.Leg3L);
/* 255 */     this.Leg3L.func_78792_a(this.KneeL);
/* 256 */     this.BodyBottom1.func_78792_a(this.BodyBottomL);
/* 257 */     this.Extra1.func_78792_a(this.Extra3);
/* 258 */     this.handR.func_78792_a(this.fingerR1);
/* 259 */     this.handR.func_78792_a(this.fingerR3);
/* 260 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 261 */     this.BodyBottomR.func_78792_a(this.BodyBottomR2);
/* 262 */     this.BodyBack.func_78792_a(this.BodyBottom1);
/* 263 */     this.Body.func_78792_a(this.Head1);
/* 264 */     this.Extra1.func_78792_a(this.Extra2);
/* 265 */     this.BodyBottom1.func_78792_a(this.BodyBottomR);
/* 266 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 267 */     this.Leg1R.func_78792_a(this.Leg2R);
/* 268 */     this.BodyL.func_78792_a(this.PlateL);
/* 269 */     this.handL.func_78792_a(this.fingerL3);
/* 270 */     this.ArmR3.func_78792_a(this.ArmR4);
/* 271 */     this.Leg2R.func_78792_a(this.Leg3R);
/* 272 */     this.handL.func_78792_a(this.fingerL1);
/* 273 */     this.Leg3R.func_78792_a(this.KneeR);
/* 274 */     this.Leg1L.func_78792_a(this.Leg2L);
/* 275 */     this.Body.func_78792_a(this.BodyR);
/* 276 */     this.Leg3R.func_78792_a(this.FootR);
/* 277 */     this.BodyR.func_78792_a(this.ShoulderR);
/* 278 */     this.ArmL3.func_78792_a(this.ArmL4);
/* 279 */     this.BodyBack.func_78792_a(this.Back);
/* 280 */     this.BodyL.func_78792_a(this.ShoulderL);
/* 281 */     this.ArmL1.func_78792_a(this.ArmL2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 286 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 288 */     GL11.glPushMatrix();
/* 289 */     float F = 1.6F;
/* 290 */     JGRenderHelper.modelScalePositionHelper(1.6F);
/*     */     
/* 292 */     this.Body.func_78785_a(f5);
/* 293 */     this.ArmR1.func_78785_a(f5);
/* 294 */     this.ArmL1.func_78785_a(f5);
/* 295 */     this.Leg1L.func_78785_a(f5);
/* 296 */     this.Leg1R.func_78785_a(f5);
/* 297 */     this.Extra1.func_78785_a(f5);
/*     */     
/* 299 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 303 */     modelRenderer.field_78795_f = x;
/* 304 */     modelRenderer.field_78796_g = y;
/* 305 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 309 */     int calc = par7Entity.field_70173_aa;
/* 310 */     if (calc > 100) calc -= 100; 
/* 311 */     float r = 360.0F;
/* 312 */     float r2 = 180.0F;
/* 313 */     float n4 = par4;
/* 314 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 318 */     float ex = par7Entity.field_70173_aa;
/* 319 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 320 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 322 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 323 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 372 */     this.Leg1R.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 373 */     this.Leg1L.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 374 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 375 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 377 */     this.Leg1R.field_78796_g = 0.0F;
/* 378 */     this.Leg1L.field_78796_g = 0.0F;
/* 379 */     this.ArmR1.field_78796_g = 0.0F;
/* 380 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbpilaf\ModelMaiMecha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */