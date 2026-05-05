/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBorareta
/*     */   extends ModelBase {
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer SideL1;
/*     */   public ModelRenderer SideR1;
/*     */   public ModelRenderer SideF;
/*     */   public ModelRenderer SideB;
/*     */   public ModelRenderer LowerBody;
/*     */   public ModelRenderer EyeR;
/*     */   public ModelRenderer EyeL;
/*     */   public ModelRenderer SideL2;
/*     */   public ModelRenderer SideR2;
/*     */   public ModelRenderer LowerBodyF;
/*     */   public ModelRenderer LowerBodyB;
/*     */   public ModelRenderer Pipes;
/*     */   public ModelRenderer PipeL1;
/*     */   public ModelRenderer PipeR1;
/*     */   public ModelRenderer PipeL2;
/*     */   public ModelRenderer PipeR2;
/*     */   public ModelRenderer BaseR;
/*     */   public ModelRenderer BaseRSideR;
/*     */   public ModelRenderer BaseRSideL;
/*     */   public ModelRenderer BaseRFront;
/*     */   public ModelRenderer BaseRBack;
/*     */   public ModelRenderer BaseRTop;
/*     */   public ModelRenderer BaseRBottom;
/*     */   public ModelRenderer BaseL;
/*     */   public ModelRenderer BaseLSideR;
/*     */   public ModelRenderer BaseLBackL;
/*     */   public ModelRenderer BaseLFront;
/*     */   public ModelRenderer BaseLBack;
/*     */   public ModelRenderer BaseLTop;
/*     */   public ModelRenderer BaseLBottom;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmR4;
/*     */   public ModelRenderer ArmR5;
/*     */   public ModelRenderer ArmR6;
/*     */   public ModelRenderer HandR;
/*     */   public ModelRenderer HandR1;
/*     */   public ModelRenderer HandR2;
/*     */   public ModelRenderer HandR3;
/*     */   public ModelRenderer HandR4;
/*     */   public ModelRenderer HandR5;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmL4;
/*     */   public ModelRenderer ArmL5;
/*     */   public ModelRenderer ArmL6;
/*     */   public ModelRenderer HandL;
/*     */   public ModelRenderer HandL1;
/*     */   public ModelRenderer HandL2;
/*     */   public ModelRenderer HandL3;
/*     */   public ModelRenderer HandL4;
/*     */   public ModelRenderer HandL5;
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
/*     */   public ModelBorareta() {
/*  85 */     this.field_78090_t = 256;
/*  86 */     this.field_78089_u = 128;
/*  87 */     this.BaseLSideR = new ModelRenderer(this, 183, 28);
/*  88 */     this.BaseLSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.BaseLSideR.func_78790_a(-5.0F, -3.0F, -3.0F, 2, 6, 6, 0.0F);
/*  90 */     this.LowerBodyB = new ModelRenderer(this, 68, 56);
/*  91 */     this.LowerBodyB.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.LowerBodyB.func_78790_a(-4.0F, 0.0F, 9.0F, 8, 5, 5, 0.0F);
/*  93 */     this.ArmR3 = new ModelRenderer(this, 170, 65);
/*  94 */     this.ArmR3.func_78793_a(-5.9F, 0.0F, 0.0F);
/*  95 */     this.ArmR3.func_78790_a(-6.2F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/*  96 */     setRotateAngle(this.ArmR3, 0.0F, -0.22759093F, 0.0F);
/*  97 */     this.LegL3 = new ModelRenderer(this, 50, 77);
/*  98 */     this.LegL3.field_78809_i = true;
/*  99 */     this.LegL3.func_78793_a(0.0F, 12.5F, 1.3F);
/* 100 */     this.LegL3.func_78790_a(-4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F);
/* 101 */     setRotateAngle(this.LegL3, 0.74036866F, 0.0F, 0.0F);
/* 102 */     this.EyeR = new ModelRenderer(this, 166, 8);
/* 103 */     this.EyeR.func_78793_a(-7.0F, -5.0F, 0.0F);
/* 104 */     this.EyeR.func_78790_a(-2.5F, -3.7F, -2.5F, 5, 4, 5, 0.0F);
/* 105 */     this.PipeL1 = new ModelRenderer(this, 110, 54);
/* 106 */     this.PipeL1.field_78809_i = true;
/* 107 */     this.PipeL1.func_78793_a(2.1F, 0.8F, 2.8F);
/* 108 */     this.PipeL1.func_78790_a(-1.5F, -0.5F, -0.1F, 3, 4, 13, 0.0F);
/* 109 */     setRotateAngle(this.PipeL1, 1.2292354F, 0.0F, 0.0F);
/* 110 */     this.PipeL2 = new ModelRenderer(this, 130, 56);
/* 111 */     this.PipeL2.field_78809_i = true;
/* 112 */     this.PipeL2.func_78793_a(0.1F, 0.2F, 12.1F);
/* 113 */     this.PipeL2.func_78790_a(-1.5F, -1.0F, -0.1F, 3, 4, 6, 0.0F);
/* 114 */     setRotateAngle(this.PipeL2, -1.0016445F, 0.0F, 0.0F);
/* 115 */     this.HandL1 = new ModelRenderer(this, 221, 81);
/* 116 */     this.HandL1.field_78809_i = true;
/* 117 */     this.HandL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 118 */     this.HandL1.func_78790_a(-0.3F, -3.5F, -5.5F, 7, 7, 1, 0.0F);
/* 119 */     this.LegR5 = new ModelRenderer(this, 136, 94);
/* 120 */     this.LegR5.func_78793_a(0.0F, 14.0F, 0.0F);
/* 121 */     this.LegR5.func_78790_a(-5.5F, 0.4F, -7.2F, 11, 6, 13, 0.0F);
/* 122 */     setRotateAngle(this.LegR5, -0.09599311F, 0.0F, 0.0F);
/* 123 */     this.BaseLBack = new ModelRenderer(this, 190, 15);
/* 124 */     this.BaseLBack.field_78809_i = true;
/* 125 */     this.BaseLBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.BaseLBack.func_78790_a(-3.0F, -3.0F, 3.0F, 6, 6, 2, 0.0F);
/* 127 */     this.LegR3 = new ModelRenderer(this, 50, 77);
/* 128 */     this.LegR3.func_78793_a(0.0F, 12.5F, 1.3F);
/* 129 */     this.LegR3.func_78790_a(-4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F);
/* 130 */     setRotateAngle(this.LegR3, 0.74036866F, 0.0F, 0.0F);
/* 131 */     this.Body = new ModelRenderer(this, 0, 0);
/* 132 */     this.Body.func_78793_a(0.0F, -19.9F, 0.0F);
/* 133 */     this.Body.func_78790_a(-12.5F, -5.5F, -12.5F, 25, 10, 25, 0.0F);
/* 134 */     this.LegL7 = new ModelRenderer(this, 138, 84);
/* 135 */     this.LegL7.field_78809_i = true;
/* 136 */     this.LegL7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.LegL7.func_78790_a(-3.9F, 2.4F, 5.7F, 8, 4, 3, 0.0F);
/* 138 */     this.HandR = new ModelRenderer(this, 193, 61);
/* 139 */     this.HandR.func_78793_a(-5.9F, 0.0F, 0.0F);
/* 140 */     this.HandR.func_78790_a(-8.8F, -4.5F, -4.5F, 9, 9, 9, 0.0F);
/* 141 */     setRotateAngle(this.HandR, 0.0F, -0.22759093F, 0.0F);
/* 142 */     this.LegR7 = new ModelRenderer(this, 138, 84);
/* 143 */     this.LegR7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.LegR7.func_78790_a(-3.9F, 2.4F, 5.7F, 8, 4, 3, 0.0F);
/* 145 */     this.LegL9 = new ModelRenderer(this, 188, 95);
/* 146 */     this.LegL9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.LegL9.func_78790_a(5.0F, 5.5F, -3.0F, 1, 11, 7, 0.0F);
/* 148 */     this.HandR5 = new ModelRenderer(this, 203, 81);
/* 149 */     this.HandR5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 150 */     this.HandR5.func_78790_a(-9.7F, -3.6F, -3.4F, 1, 7, 7, 0.0F);
/* 151 */     this.HandR1 = new ModelRenderer(this, 221, 81);
/* 152 */     this.HandR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 153 */     this.HandR1.func_78790_a(-8.0F, -3.5F, -5.5F, 7, 7, 1, 0.0F);
/* 154 */     this.LegR4 = new ModelRenderer(this, 50, 97);
/* 155 */     this.LegR4.func_78793_a(0.0F, 4.0F, 0.5F);
/* 156 */     this.LegR4.func_78790_a(-5.0F, -0.5F, -5.0F, 10, 15, 10, 0.0F);
/* 157 */     setRotateAngle(this.LegR4, 0.13473941F, 0.0F, 0.0F);
/* 158 */     this.LegR8 = new ModelRenderer(this, 114, 95);
/* 159 */     this.LegR8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 160 */     this.LegR8.func_78790_a(-6.0F, 5.5F, -3.0F, 1, 11, 7, 0.0F);
/* 161 */     this.LegR6 = new ModelRenderer(this, 136, 115);
/* 162 */     this.LegR6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 163 */     this.LegR6.func_78790_a(-3.9F, 2.4F, -12.2F, 8, 4, 5, 0.0F);
/* 164 */     this.ArmR1 = new ModelRenderer(this, 170, 65);
/* 165 */     this.ArmR1.func_78793_a(-15.9F, -21.8F, 0.0F);
/* 166 */     this.ArmR1.func_78790_a(-6.6F, -1.8F, -2.6F, 6, 5, 5, 0.0F);
/* 167 */     setRotateAngle(this.ArmR1, 0.0F, 0.0F, -0.59184116F);
/* 168 */     this.ArmL6 = new ModelRenderer(this, 170, 65);
/* 169 */     this.ArmL6.field_78809_i = true;
/* 170 */     this.ArmL6.func_78793_a(5.9F, 0.0F, 0.0F);
/* 171 */     this.ArmL6.func_78790_a(-0.8F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 172 */     setRotateAngle(this.ArmL6, 0.0F, 0.22759093F, 0.0F);
/* 173 */     this.BaseRFront = new ModelRenderer(this, 189, 43);
/* 174 */     this.BaseRFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 175 */     this.BaseRFront.func_78790_a(-3.0F, -3.0F, -5.0F, 6, 6, 2, 0.0F);
/* 176 */     this.ArmL3 = new ModelRenderer(this, 170, 65);
/* 177 */     this.ArmL3.field_78809_i = true;
/* 178 */     this.ArmL3.func_78793_a(5.9F, 0.0F, 0.0F);
/* 179 */     this.ArmL3.func_78790_a(-0.8F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 180 */     setRotateAngle(this.ArmL3, 0.0F, 0.22759093F, 0.0F);
/* 181 */     this.BaseRSideL = new ModelRenderer(this, 235, 28);
/* 182 */     this.BaseRSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 183 */     this.BaseRSideL.func_78790_a(3.0F, -3.0F, -3.0F, 2, 6, 6, 0.0F);
/* 184 */     this.SideL2 = new ModelRenderer(this, 129, 3);
/* 185 */     this.SideL2.field_78809_i = true;
/* 186 */     this.SideL2.func_78793_a(3.0F, 0.0F, 0.0F);
/* 187 */     this.SideL2.func_78790_a(-0.5F, -4.2F, -5.0F, 4, 8, 10, 0.0F);
/* 188 */     setRotateAngle(this.SideL2, 0.0F, 0.0F, 0.17453292F);
/* 189 */     this.BaseR = new ModelRenderer(this, 201, 25);
/* 190 */     this.BaseR.func_78793_a(0.0F, -7.6F, 0.0F);
/* 191 */     this.BaseR.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
/* 192 */     this.LegL2 = new ModelRenderer(this, 2, 100);
/* 193 */     this.LegL2.field_78809_i = true;
/* 194 */     this.LegL2.func_78793_a(1.5F, 1.4F, -1.5F);
/* 195 */     this.LegL2.func_78790_a(-5.0F, 0.0F, -4.7F, 10, 12, 10, 0.0F);
/* 196 */     setRotateAngle(this.LegL2, -0.7740535F, -0.13665928F, 0.0F);
/* 197 */     this.BaseRSideR = new ModelRenderer(this, 183, 28);
/* 198 */     this.BaseRSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 199 */     this.BaseRSideR.func_78790_a(-5.0F, -3.0F, -3.0F, 2, 6, 6, 0.0F);
/* 200 */     this.LegL8 = new ModelRenderer(this, 114, 95);
/* 201 */     this.LegL8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 202 */     this.LegL8.func_78790_a(-6.0F, 5.5F, -3.0F, 1, 11, 7, 0.0F);
/* 203 */     this.ArmR6 = new ModelRenderer(this, 170, 65);
/* 204 */     this.ArmR6.func_78793_a(-5.9F, 0.0F, 0.0F);
/* 205 */     this.ArmR6.func_78790_a(-6.2F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 206 */     setRotateAngle(this.ArmR6, 0.0F, -0.22759093F, 0.0F);
/* 207 */     this.SideB = new ModelRenderer(this, 60, 37);
/* 208 */     this.SideB.field_78809_i = true;
/* 209 */     this.SideB.func_78793_a(0.0F, -0.5F, 12.5F);
/* 210 */     this.SideB.func_78790_a(-9.5F, -5.0F, 0.0F, 19, 10, 4, 0.0F);
/* 211 */     this.PipeR1 = new ModelRenderer(this, 110, 54);
/* 212 */     this.PipeR1.func_78793_a(-2.1F, 0.8F, 2.8F);
/* 213 */     this.PipeR1.func_78790_a(-1.5F, -0.5F, -0.1F, 3, 4, 13, 0.0F);
/* 214 */     setRotateAngle(this.PipeR1, 1.2292354F, 0.0F, 0.0F);
/* 215 */     this.BaseRBack = new ModelRenderer(this, 190, 15);
/* 216 */     this.BaseRBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 217 */     this.BaseRBack.func_78790_a(-3.0F, -3.0F, 3.0F, 6, 6, 2, 0.0F);
/* 218 */     this.ArmL4 = new ModelRenderer(this, 170, 65);
/* 219 */     this.ArmL4.field_78809_i = true;
/* 220 */     this.ArmL4.func_78793_a(5.9F, 0.0F, 0.0F);
/* 221 */     this.ArmL4.func_78790_a(-0.8F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 222 */     setRotateAngle(this.ArmL4, 0.0F, 0.22759093F, 0.0F);
/* 223 */     this.HandR2 = new ModelRenderer(this, 185, 81);
/* 224 */     this.HandR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 225 */     this.HandR2.func_78790_a(-8.0F, -3.5F, 4.5F, 7, 7, 1, 0.0F);
/* 226 */     this.EyeL = new ModelRenderer(this, 166, 8);
/* 227 */     this.EyeL.field_78809_i = true;
/* 228 */     this.EyeL.func_78793_a(7.0F, -5.0F, 0.0F);
/* 229 */     this.EyeL.func_78790_a(-2.5F, -3.7F, -2.5F, 5, 4, 5, 0.0F);
/* 230 */     this.LowerBodyF = new ModelRenderer(this, 39, 56);
/* 231 */     this.LowerBodyF.func_78793_a(0.0F, 0.0F, 0.0F);
/* 232 */     this.LowerBodyF.func_78790_a(-4.0F, 0.0F, -14.0F, 8, 5, 5, 0.0F);
/* 233 */     this.HandL = new ModelRenderer(this, 193, 61);
/* 234 */     this.HandL.field_78809_i = true;
/* 235 */     this.HandL.func_78793_a(5.9F, 0.0F, 0.0F);
/* 236 */     this.HandL.func_78790_a(-1.2F, -4.5F, -4.5F, 9, 9, 9, 0.0F);
/* 237 */     setRotateAngle(this.HandL, 0.0F, 0.22759093F, 0.0F);
/* 238 */     this.HandL4 = new ModelRenderer(this, 215, 90);
/* 239 */     this.HandL4.field_78809_i = true;
/* 240 */     this.HandL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 241 */     this.HandL4.func_78790_a(-0.3F, 4.5F, -3.5F, 7, 1, 7, 0.0F);
/* 242 */     this.LegR2 = new ModelRenderer(this, 2, 100);
/* 243 */     this.LegR2.func_78793_a(-1.5F, 1.4F, -1.5F);
/* 244 */     this.LegR2.func_78790_a(-5.0F, 0.0F, -4.7F, 10, 12, 10, 0.0F);
/* 245 */     setRotateAngle(this.LegR2, -0.7740535F, 0.13665928F, 0.0F);
/* 246 */     this.ArmR4 = new ModelRenderer(this, 170, 65);
/* 247 */     this.ArmR4.func_78793_a(-5.9F, 0.0F, 0.0F);
/* 248 */     this.ArmR4.func_78790_a(-6.2F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 249 */     setRotateAngle(this.ArmR4, 0.0F, -0.22759093F, 0.0F);
/* 250 */     this.LowerBody = new ModelRenderer(this, 1, 53);
/* 251 */     this.LowerBody.func_78793_a(0.0F, 4.5F, 0.0F);
/* 252 */     this.LowerBody.func_78790_a(-4.0F, 0.0F, -9.0F, 8, 7, 18, 0.0F);
/* 253 */     this.SideR2 = new ModelRenderer(this, 129, 3);
/* 254 */     this.SideR2.func_78793_a(-3.0F, 0.0F, 0.0F);
/* 255 */     this.SideR2.func_78790_a(-3.4F, -4.2F, -5.0F, 4, 8, 10, 0.0F);
/* 256 */     setRotateAngle(this.SideR2, 0.0F, 0.0F, -0.17453292F);
/* 257 */     this.HandL5 = new ModelRenderer(this, 203, 81);
/* 258 */     this.HandL5.field_78809_i = true;
/* 259 */     this.HandL5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 260 */     this.HandL5.func_78790_a(7.8F, -3.6F, -3.4F, 1, 7, 7, 0.0F);
/* 261 */     this.BaseLBottom = new ModelRenderer(this, 207, 43);
/* 262 */     this.BaseLBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 263 */     this.BaseLBottom.func_78790_a(-3.0F, 3.0F, -3.0F, 6, 2, 6, 0.0F);
/* 264 */     this.HandR4 = new ModelRenderer(this, 215, 90);
/* 265 */     this.HandR4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 266 */     this.HandR4.func_78790_a(-8.0F, 4.5F, -3.5F, 7, 1, 7, 0.0F);
/* 267 */     this.HandL3 = new ModelRenderer(this, 221, 61);
/* 268 */     this.HandL3.field_78809_i = true;
/* 269 */     this.HandL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 270 */     this.HandL3.func_78790_a(-0.4F, -5.5F, -3.5F, 7, 1, 7, 0.0F);
/* 271 */     this.HandL2 = new ModelRenderer(this, 185, 81);
/* 272 */     this.HandL2.field_78809_i = true;
/* 273 */     this.HandL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 274 */     this.HandL2.func_78790_a(-0.3F, -3.5F, 4.5F, 7, 7, 1, 0.0F);
/* 275 */     this.SideF = new ModelRenderer(this, 15, 37);
/* 276 */     this.SideF.func_78793_a(0.0F, -0.5F, -12.8F);
/* 277 */     this.SideF.func_78790_a(-9.5F, -5.0F, -3.7F, 19, 10, 4, 0.0F);
/* 278 */     this.HandR3 = new ModelRenderer(this, 221, 61);
/* 279 */     this.HandR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 280 */     this.HandR3.func_78790_a(-8.0F, -5.5F, -3.5F, 7, 1, 7, 0.0F);
/* 281 */     this.BaseL = new ModelRenderer(this, 201, 25);
/* 282 */     this.BaseL.field_78809_i = true;
/* 283 */     this.BaseL.func_78793_a(0.0F, -7.6F, 0.0F);
/* 284 */     this.BaseL.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
/* 285 */     this.BaseLFront = new ModelRenderer(this, 189, 43);
/* 286 */     this.BaseLFront.field_78809_i = true;
/* 287 */     this.BaseLFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 288 */     this.BaseLFront.func_78790_a(-3.0F, -3.0F, -5.0F, 6, 6, 2, 0.0F);
/* 289 */     this.ArmL5 = new ModelRenderer(this, 170, 65);
/* 290 */     this.ArmL5.field_78809_i = true;
/* 291 */     this.ArmL5.func_78793_a(5.9F, 0.0F, 0.0F);
/* 292 */     this.ArmL5.func_78790_a(-0.8F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 293 */     setRotateAngle(this.ArmL5, 0.0F, 0.22759093F, 0.0F);
/* 294 */     this.SideR1 = new ModelRenderer(this, 101, 7);
/* 295 */     this.SideR1.func_78793_a(-12.8F, -0.5F, 0.0F);
/* 296 */     this.SideR1.func_78790_a(-3.7F, -5.0F, -8.5F, 4, 10, 18, 0.0F);
/* 297 */     this.ArmR5 = new ModelRenderer(this, 170, 65);
/* 298 */     this.ArmR5.func_78793_a(-5.9F, 0.0F, 0.0F);
/* 299 */     this.ArmR5.func_78790_a(-6.2F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 300 */     setRotateAngle(this.ArmR5, 0.0F, -0.22759093F, 0.0F);
/* 301 */     this.ArmL2 = new ModelRenderer(this, 170, 65);
/* 302 */     this.ArmL2.field_78809_i = true;
/* 303 */     this.ArmL2.func_78793_a(6.4F, 0.7F, 0.0F);
/* 304 */     this.ArmL2.func_78790_a(-0.8F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 305 */     this.BaseLBackL = new ModelRenderer(this, 235, 28);
/* 306 */     this.BaseLBackL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 307 */     this.BaseLBackL.func_78790_a(3.0F, -3.0F, -3.0F, 2, 6, 6, 0.0F);
/* 308 */     this.BaseLTop = new ModelRenderer(this, 208, 15);
/* 309 */     this.BaseLTop.field_78809_i = true;
/* 310 */     this.BaseLTop.func_78793_a(0.0F, 0.0F, 0.0F);
/* 311 */     this.BaseLTop.func_78790_a(-3.0F, -5.0F, -3.0F, 6, 2, 6, 0.0F);
/* 312 */     this.LegL5 = new ModelRenderer(this, 136, 94);
/* 313 */     this.LegL5.field_78809_i = true;
/* 314 */     this.LegL5.func_78793_a(0.0F, 14.0F, 0.0F);
/* 315 */     this.LegL5.func_78790_a(-5.5F, 0.4F, -7.2F, 11, 6, 13, 0.0F);
/* 316 */     setRotateAngle(this.LegL5, -0.09599311F, 0.0F, 0.0F);
/* 317 */     this.ArmR2 = new ModelRenderer(this, 170, 65);
/* 318 */     this.ArmR2.func_78793_a(-6.4F, 0.7F, 0.0F);
/* 319 */     this.ArmR2.func_78790_a(-6.2F, -2.5F, -2.5F, 6, 5, 5, 0.0F);
/* 320 */     this.LegL6 = new ModelRenderer(this, 136, 115);
/* 321 */     this.LegL6.field_78809_i = true;
/* 322 */     this.LegL6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 323 */     this.LegL6.func_78790_a(-3.9F, 2.4F, -12.2F, 8, 4, 5, 0.0F);
/* 324 */     this.SideL1 = new ModelRenderer(this, 101, 7);
/* 325 */     this.SideL1.field_78809_i = true;
/* 326 */     this.SideL1.func_78793_a(12.8F, -0.5F, 0.0F);
/* 327 */     this.SideL1.func_78790_a(-0.3F, -5.0F, -8.5F, 4, 10, 18, 0.0F);
/* 328 */     this.LegR9 = new ModelRenderer(this, 188, 95);
/* 329 */     this.LegR9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 330 */     this.LegR9.func_78790_a(5.0F, 5.5F, -3.0F, 1, 11, 7, 0.0F);
/* 331 */     this.PipeR2 = new ModelRenderer(this, 130, 56);
/* 332 */     this.PipeR2.func_78793_a(-0.1F, 0.2F, 12.1F);
/* 333 */     this.PipeR2.func_78790_a(-1.5F, -1.0F, -0.1F, 3, 4, 6, 0.0F);
/* 334 */     setRotateAngle(this.PipeR2, -1.0016445F, 0.0F, 0.0F);
/* 335 */     this.BaseRTop = new ModelRenderer(this, 208, 15);
/* 336 */     this.BaseRTop.func_78793_a(0.0F, 0.0F, 0.0F);
/* 337 */     this.BaseRTop.func_78790_a(-3.0F, -5.0F, -3.0F, 6, 2, 6, 0.0F);
/* 338 */     this.ArmL1 = new ModelRenderer(this, 170, 65);
/* 339 */     this.ArmL1.field_78809_i = true;
/* 340 */     this.ArmL1.func_78793_a(15.9F, -21.8F, 0.0F);
/* 341 */     this.ArmL1.func_78790_a(-0.4F, -1.8F, -2.6F, 6, 5, 5, 0.0F);
/* 342 */     setRotateAngle(this.ArmL1, 0.0F, 0.0F, 0.59184116F);
/* 343 */     this.LegL4 = new ModelRenderer(this, 50, 97);
/* 344 */     this.LegL4.field_78809_i = true;
/* 345 */     this.LegL4.func_78793_a(0.0F, 4.0F, -0.5F);
/* 346 */     this.LegL4.func_78790_a(-5.0F, -0.5F, -5.0F, 10, 15, 10, 0.0F);
/* 347 */     setRotateAngle(this.LegL4, 0.13473941F, 0.0F, 0.0F);
/* 348 */     this.Pipes = new ModelRenderer(this, 96, 56);
/* 349 */     this.Pipes.func_78793_a(0.0F, 2.6F, 13.7F);
/* 350 */     this.Pipes.func_78790_a(-3.5F, -1.9F, 0.0F, 7, 4, 6, 0.0F);
/* 351 */     setRotateAngle(this.Pipes, 0.13962634F, 0.0F, 0.0F);
/* 352 */     this.BaseRBottom = new ModelRenderer(this, 207, 43);
/* 353 */     this.BaseRBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 354 */     this.BaseRBottom.func_78790_a(-3.0F, 3.0F, -3.0F, 6, 2, 6, 0.0F);
/* 355 */     this.LegR1 = new ModelRenderer(this, 2, 80);
/* 356 */     this.LegR1.func_78793_a(-8.0F, -11.5F, 1.9F);
/* 357 */     this.LegR1.func_78790_a(-4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F);
/* 358 */     this.LegL1 = new ModelRenderer(this, 2, 80);
/* 359 */     this.LegL1.field_78809_i = true;
/* 360 */     this.LegL1.func_78793_a(8.0F, -11.5F, 1.9F);
/* 361 */     this.LegL1.func_78790_a(-4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F);
/* 362 */     this.BaseL.func_78792_a(this.BaseLSideR);
/* 363 */     this.LowerBody.func_78792_a(this.LowerBodyB);
/* 364 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 365 */     this.LegL2.func_78792_a(this.LegL3);
/* 366 */     this.Body.func_78792_a(this.EyeR);
/* 367 */     this.Pipes.func_78792_a(this.PipeL1);
/* 368 */     this.PipeL1.func_78792_a(this.PipeL2);
/* 369 */     this.HandL.func_78792_a(this.HandL1);
/* 370 */     this.LegR4.func_78792_a(this.LegR5);
/* 371 */     this.BaseL.func_78792_a(this.BaseLBack);
/* 372 */     this.LegR2.func_78792_a(this.LegR3);
/* 373 */     this.LegL5.func_78792_a(this.LegL7);
/* 374 */     this.ArmR6.func_78792_a(this.HandR);
/* 375 */     this.LegR5.func_78792_a(this.LegR7);
/* 376 */     this.LegL4.func_78792_a(this.LegL9);
/* 377 */     this.HandR.func_78792_a(this.HandR5);
/* 378 */     this.HandR.func_78792_a(this.HandR1);
/* 379 */     this.LegR3.func_78792_a(this.LegR4);
/* 380 */     this.LegR4.func_78792_a(this.LegR8);
/* 381 */     this.LegR5.func_78792_a(this.LegR6);
/* 382 */     this.ArmL5.func_78792_a(this.ArmL6);
/* 383 */     this.BaseR.func_78792_a(this.BaseRFront);
/* 384 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 385 */     this.BaseR.func_78792_a(this.BaseRSideL);
/* 386 */     this.SideL1.func_78792_a(this.SideL2);
/* 387 */     this.EyeR.func_78792_a(this.BaseR);
/* 388 */     this.LegL1.func_78792_a(this.LegL2);
/* 389 */     this.BaseR.func_78792_a(this.BaseRSideR);
/* 390 */     this.LegL4.func_78792_a(this.LegL8);
/* 391 */     this.ArmR5.func_78792_a(this.ArmR6);
/* 392 */     this.Body.func_78792_a(this.SideB);
/* 393 */     this.Pipes.func_78792_a(this.PipeR1);
/* 394 */     this.BaseR.func_78792_a(this.BaseRBack);
/* 395 */     this.ArmL3.func_78792_a(this.ArmL4);
/* 396 */     this.HandR.func_78792_a(this.HandR2);
/* 397 */     this.Body.func_78792_a(this.EyeL);
/* 398 */     this.LowerBody.func_78792_a(this.LowerBodyF);
/* 399 */     this.ArmL6.func_78792_a(this.HandL);
/* 400 */     this.HandL.func_78792_a(this.HandL4);
/* 401 */     this.LegR1.func_78792_a(this.LegR2);
/* 402 */     this.ArmR3.func_78792_a(this.ArmR4);
/* 403 */     this.Body.func_78792_a(this.LowerBody);
/* 404 */     this.SideR1.func_78792_a(this.SideR2);
/* 405 */     this.HandL.func_78792_a(this.HandL5);
/* 406 */     this.BaseL.func_78792_a(this.BaseLBottom);
/* 407 */     this.HandR.func_78792_a(this.HandR4);
/* 408 */     this.HandL.func_78792_a(this.HandL3);
/* 409 */     this.HandL.func_78792_a(this.HandL2);
/* 410 */     this.Body.func_78792_a(this.SideF);
/* 411 */     this.HandR.func_78792_a(this.HandR3);
/* 412 */     this.EyeL.func_78792_a(this.BaseL);
/* 413 */     this.BaseL.func_78792_a(this.BaseLFront);
/* 414 */     this.ArmL4.func_78792_a(this.ArmL5);
/* 415 */     this.Body.func_78792_a(this.SideR1);
/* 416 */     this.ArmR4.func_78792_a(this.ArmR5);
/* 417 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 418 */     this.BaseL.func_78792_a(this.BaseLBackL);
/* 419 */     this.BaseL.func_78792_a(this.BaseLTop);
/* 420 */     this.LegL4.func_78792_a(this.LegL5);
/* 421 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 422 */     this.LegL5.func_78792_a(this.LegL6);
/* 423 */     this.Body.func_78792_a(this.SideL1);
/* 424 */     this.LegR4.func_78792_a(this.LegR9);
/* 425 */     this.PipeR1.func_78792_a(this.PipeR2);
/* 426 */     this.BaseR.func_78792_a(this.BaseRTop);
/* 427 */     this.LegL3.func_78792_a(this.LegL4);
/* 428 */     this.LowerBodyB.func_78792_a(this.Pipes);
/* 429 */     this.BaseR.func_78792_a(this.BaseRBottom);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 434 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 437 */     this.LegL1.func_78785_a(f5);
/*     */     
/* 439 */     this.ArmL1.func_78785_a(f5);
/* 440 */     this.ArmR1.func_78785_a(f5);
/* 441 */     this.Body.func_78785_a(f5);
/* 442 */     this.LegR1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 448 */     modelRenderer.field_78795_f = x;
/* 449 */     modelRenderer.field_78796_g = y;
/* 450 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 454 */     int calc = par7Entity.field_70173_aa;
/* 455 */     if (calc > 100) calc -= 100; 
/* 456 */     float r = 360.0F;
/* 457 */     float r2 = 180.0F;
/* 458 */     float n4 = par4;
/* 459 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 463 */     float ex = par7Entity.field_70173_aa;
/* 464 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 465 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 467 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 468 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 514 */     this.LegR1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 515 */     this.LegL1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */ 
/*     */ 
/*     */     
/* 519 */     this.LegR1.field_78796_g = 0.0F;
/* 520 */     this.LegL1.field_78796_g = 0.0F;
/* 521 */     this.ArmR1.field_78796_g = 0.0F;
/* 522 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 529 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBorareta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */