/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGodLiquiir
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer tail11;
/*     */   public ModelRenderer tail21;
/*     */   public ModelRenderer tail31;
/*     */   public ModelRenderer EarR1;
/*     */   public ModelRenderer Snout1;
/*     */   public ModelRenderer SideFurR1;
/*     */   public ModelRenderer EarL1;
/*     */   public ModelRenderer SideFurL1;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarR3;
/*     */   public ModelRenderer Earing;
/*     */   public ModelRenderer Snout2;
/*     */   public ModelRenderer SnoutSideR;
/*     */   public ModelRenderer SnoutSideL;
/*     */   public ModelRenderer SideFurR2;
/*     */   public ModelRenderer EarL2;
/*     */   public ModelRenderer EarL3;
/*     */   public ModelRenderer SideFurL2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer ChestPuff1;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ChestPuff2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer tail12;
/*     */   public ModelRenderer tail13;
/*     */   public ModelRenderer tail14;
/*     */   public ModelRenderer tail15;
/*     */   public ModelRenderer tail22;
/*     */   public ModelRenderer tail23;
/*     */   public ModelRenderer tail24;
/*     */   public ModelRenderer tail25;
/*     */   public ModelRenderer tail32;
/*     */   public ModelRenderer tail33;
/*     */   public ModelRenderer tail34;
/*     */   public ModelRenderer tail35;
/*     */   
/*     */   public ModelGodLiquiir() {
/*  56 */     this.field_78090_t = 64;
/*  57 */     this.field_78089_u = 64;
/*  58 */     this.ChestPuff2 = new ModelRenderer(this, 22, 61);
/*  59 */     this.ChestPuff2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.ChestPuff2.func_78790_a(-1.0F, 6.0F, -2.6F, 2, 1, 1, 0.0F);
/*  61 */     this.SideFurR2 = new ModelRenderer(this, 13, 56);
/*  62 */     this.SideFurR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.SideFurR2.func_78790_a(-4.6F, -1.7F, -1.4F, 1, 2, 3, 0.0F);
/*  64 */     this.tail32 = new ModelRenderer(this, 11, 48);
/*  65 */     this.tail32.func_78793_a(0.0F, 2.4F, 0.0F);
/*  66 */     this.tail32.func_78790_a(-1.0F, -0.3F, -1.0F, 2, 2, 2, 0.0F);
/*  67 */     setRotateAngle(this.tail32, 0.13665928F, 0.0F, 0.0F);
/*  68 */     this.SideFurR1 = new ModelRenderer(this, 0, 54);
/*  69 */     this.SideFurR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.SideFurR1.func_78790_a(-4.2F, -2.8F, -3.2F, 1, 3, 5, 0.0F);
/*  71 */     this.EarR2 = new ModelRenderer(this, 33, 7);
/*  72 */     this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.EarR2.func_78790_a(-3.9F, -12.8F, 1.0F, 3, 3, 1, 0.0F);
/*  74 */     this.tail13 = new ModelRenderer(this, 20, 47);
/*  75 */     this.tail13.func_78793_a(0.0F, 2.0F, 0.0F);
/*  76 */     this.tail13.func_78790_a(-1.5F, -0.5F, -1.6F, 3, 3, 3, 0.0F);
/*  77 */     setRotateAngle(this.tail13, 0.22759093F, 0.0F, 0.0F);
/*  78 */     this.tail31 = new ModelRenderer(this, 2, 47);
/*  79 */     this.tail31.func_78793_a(0.0F, 10.3F, 1.5F);
/*  80 */     this.tail31.func_78790_a(-1.0F, -0.5F, -1.0F, 2, 3, 2, 0.0F);
/*  81 */     setRotateAngle(this.tail31, 0.8196066F, -0.4553564F, 0.0F);
/*  82 */     this.EarL1 = new ModelRenderer(this, 25, 1);
/*  83 */     this.EarL1.field_78809_i = true;
/*  84 */     this.EarL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.EarL1.func_78790_a(0.5F, -9.8F, 1.0F, 4, 4, 1, 0.0F);
/*  86 */     setRotateAngle(this.EarL1, 0.18675023F, -0.07853982F, 0.0F);
/*  87 */     this.tail15 = new ModelRenderer(this, 50, 47);
/*  88 */     this.tail15.func_78793_a(0.0F, 3.3F, 0.0F);
/*  89 */     this.tail15.func_78790_a(-1.5F, -0.3F, -1.4F, 3, 3, 3, 0.0F);
/*  90 */     setRotateAngle(this.tail15, 0.27314404F, 0.0F, 0.0F);
/*  91 */     this.tail35 = new ModelRenderer(this, 50, 47);
/*  92 */     this.tail35.func_78793_a(0.0F, 3.3F, 0.0F);
/*  93 */     this.tail35.func_78790_a(-1.5F, -0.3F, -1.4F, 3, 3, 3, 0.0F);
/*  94 */     setRotateAngle(this.tail35, -0.31869712F, 0.0F, 0.0F);
/*  95 */     this.SideFurL2 = new ModelRenderer(this, 13, 56);
/*  96 */     this.SideFurL2.field_78809_i = true;
/*  97 */     this.SideFurL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.SideFurL2.func_78790_a(3.8F, -1.7F, -1.4F, 1, 2, 3, 0.0F);
/*  99 */     this.Snout1 = new ModelRenderer(this, 41, 14);
/* 100 */     this.Snout1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.Snout1.func_78790_a(-1.5F, -2.7F, -6.7F, 3, 3, 3, 0.0F);
/* 102 */     this.SideFurL1 = new ModelRenderer(this, 0, 54);
/* 103 */     this.SideFurL1.field_78809_i = true;
/* 104 */     this.SideFurL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 105 */     this.SideFurL1.func_78790_a(3.2F, -2.8F, -3.2F, 1, 3, 5, 0.0F);
/* 106 */     this.EarR1 = new ModelRenderer(this, 25, 1);
/* 107 */     this.EarR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.EarR1.func_78790_a(-4.4F, -9.8F, 1.0F, 4, 4, 1, 0.0F);
/* 109 */     setRotateAngle(this.EarR1, 0.18675023F, 0.07853982F, 0.0F);
/* 110 */     this.EarL2 = new ModelRenderer(this, 33, 7);
/* 111 */     this.EarL2.field_78809_i = true;
/* 112 */     this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.EarL2.func_78790_a(1.0F, -12.8F, 1.0F, 3, 3, 1, 0.0F);
/* 114 */     this.LegL2 = new ModelRenderer(this, 0, 16);
/* 115 */     this.LegL2.field_78809_i = true;
/* 116 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 118 */     this.tail22 = new ModelRenderer(this, 11, 48);
/* 119 */     this.tail22.func_78793_a(0.0F, 2.4F, 0.0F);
/* 120 */     this.tail22.func_78790_a(-1.0F, -0.3F, -1.0F, 2, 2, 2, 0.0F);
/* 121 */     setRotateAngle(this.tail22, -0.18203785F, 0.0F, -0.13665928F);
/* 122 */     this.Body1 = new ModelRenderer(this, 18, 18);
/* 123 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 124 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.6F, 8, 5, 5, 0.0F);
/* 125 */     this.Neck = new ModelRenderer(this, 42, 5);
/* 126 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/* 127 */     this.Neck.func_78790_a(-2.0F, -1.0F, -0.8F, 4, 1, 2, 0.0F);
/* 128 */     this.tail24 = new ModelRenderer(this, 33, 46);
/* 129 */     this.tail24.func_78793_a(0.0F, 2.5F, -0.2F);
/* 130 */     this.tail24.func_78790_a(-2.0F, -0.6F, -1.8F, 4, 4, 4, 0.0F);
/* 131 */     setRotateAngle(this.tail24, 0.27314404F, 0.0F, 0.0F);
/* 132 */     this.tail21 = new ModelRenderer(this, 2, 47);
/* 133 */     this.tail21.func_78793_a(0.0F, 10.3F, 1.5F);
/* 134 */     this.tail21.func_78790_a(-1.0F, -0.5F, -1.0F, 2, 3, 2, 0.0F);
/* 135 */     setRotateAngle(this.tail21, 1.0011208F, 0.4553564F, 0.0F);
/* 136 */     this.Head = new ModelRenderer(this, 0, 0);
/* 137 */     this.Head.func_78793_a(0.0F, -0.8F, 0.0F);
/* 138 */     this.Head.func_78790_a(-3.5F, -6.7F, -4.0F, 7, 7, 8, -0.2F);
/* 139 */     this.EarR3 = new ModelRenderer(this, 35, 0);
/* 140 */     this.EarR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 141 */     this.EarR3.func_78790_a(-3.3F, -11.2F, 2.7F, 2, 6, 1, 0.0F);
/* 142 */     setRotateAngle(this.EarR3, 0.13665928F, 0.0F, 0.0F);
/* 143 */     this.tail25 = new ModelRenderer(this, 50, 47);
/* 144 */     this.tail25.func_78793_a(0.0F, 3.3F, 0.0F);
/* 145 */     this.tail25.func_78790_a(-1.5F, -0.3F, -1.4F, 3, 3, 3, 0.0F);
/* 146 */     setRotateAngle(this.tail25, 0.27314404F, 0.0F, 0.0F);
/* 147 */     this.EarL3 = new ModelRenderer(this, 35, 0);
/* 148 */     this.EarL3.field_78809_i = true;
/* 149 */     this.EarL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 150 */     this.EarL3.func_78790_a(1.3F, -11.2F, 2.7F, 2, 6, 1, 0.0F);
/* 151 */     setRotateAngle(this.EarL3, 0.13665928F, 0.0F, 0.0F);
/* 152 */     this.tail14 = new ModelRenderer(this, 33, 46);
/* 153 */     this.tail14.func_78793_a(0.0F, 2.5F, -0.2F);
/* 154 */     this.tail14.func_78790_a(-2.0F, -0.6F, -1.8F, 4, 4, 4, 0.0F);
/* 155 */     setRotateAngle(this.tail14, 0.27314404F, 0.0F, 0.0F);
/* 156 */     this.ArmR = new ModelRenderer(this, 50, 16);
/* 157 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.1F);
/* 158 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -1.7F, 3, 12, 4, 0.0F);
/* 159 */     this.Cloth1 = new ModelRenderer(this, 54, 1);
/* 160 */     this.Cloth1.func_78793_a(0.0F, 10.0F, -1.7F);
/* 161 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 10, 0, 0.0F);
/* 162 */     setRotateAngle(this.Cloth1, -0.090757124F, 0.0F, 0.0F);
/* 163 */     this.SnoutSideR = new ModelRenderer(this, 47, 11);
/* 164 */     this.SnoutSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 165 */     this.SnoutSideR.func_78790_a(-0.2F, -2.6F, -4.9F, 2, 2, 1, 0.0F);
/* 166 */     setRotateAngle(this.SnoutSideR, 0.0F, 0.5934119F, 0.0F);
/* 167 */     this.Snout2 = new ModelRenderer(this, 42, 11);
/* 168 */     this.Snout2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 169 */     this.Snout2.func_78790_a(-0.5F, 1.1F, -4.5F, 1, 2, 1, 0.0F);
/* 170 */     setRotateAngle(this.Snout2, -1.0927507F, 0.0F, 0.0F);
/* 171 */     this.tail12 = new ModelRenderer(this, 11, 48);
/* 172 */     this.tail12.func_78793_a(0.0F, 2.4F, 0.0F);
/* 173 */     this.tail12.func_78790_a(-1.0F, -0.3F, -1.0F, 2, 2, 2, 0.0F);
/* 174 */     setRotateAngle(this.tail12, 0.045553092F, 0.0F, 0.0F);
/* 175 */     this.Earing = new ModelRenderer(this, 0, 0);
/* 176 */     this.Earing.func_78793_a(0.0F, 0.0F, 0.0F);
/* 177 */     this.Earing.func_78790_a(-4.5F, -10.4F, 0.6F, 1, 1, 2, 0.0F);
/* 178 */     this.Body3 = new ModelRenderer(this, 20, 37);
/* 179 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 180 */     this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
/* 181 */     this.tail33 = new ModelRenderer(this, 20, 47);
/* 182 */     this.tail33.func_78793_a(0.0F, 2.0F, 0.0F);
/* 183 */     this.tail33.func_78790_a(-1.5F, -0.5F, -1.6F, 3, 3, 3, 0.0F);
/* 184 */     setRotateAngle(this.tail33, -0.18203785F, 0.0F, 0.13665928F);
/* 185 */     this.ArmL = new ModelRenderer(this, 50, 16);
/* 186 */     this.ArmL.field_78809_i = true;
/* 187 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/* 188 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.6F, 3, 12, 4, 0.0F);
/* 189 */     this.LegR = new ModelRenderer(this, 0, 33);
/* 190 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/* 191 */     this.LegR.func_78790_a(-2.3F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
/* 192 */     this.tail34 = new ModelRenderer(this, 33, 46);
/* 193 */     this.tail34.func_78793_a(0.0F, 2.5F, -0.2F);
/* 194 */     this.tail34.func_78790_a(-2.0F, -0.6F, -1.8F, 4, 4, 4, 0.0F);
/* 195 */     setRotateAngle(this.tail34, 0.4553564F, 0.0F, 0.18203785F);
/* 196 */     this.Body2 = new ModelRenderer(this, 23, 29);
/* 197 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 198 */     this.Body2.func_78790_a(-3.0F, 5.0F, -1.7F, 6, 3, 3, 0.0F);
/* 199 */     this.ChestPuff1 = new ModelRenderer(this, 22, 58);
/* 200 */     this.ChestPuff1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 201 */     this.ChestPuff1.func_78790_a(-2.0F, 5.0F, -2.6F, 4, 1, 1, 0.0F);
/* 202 */     this.LegL = new ModelRenderer(this, 0, 33);
/* 203 */     this.LegL.field_78809_i = true;
/* 204 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/* 205 */     this.LegL.func_78790_a(-1.8F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
/* 206 */     this.tail11 = new ModelRenderer(this, 2, 47);
/* 207 */     this.tail11.func_78793_a(0.0F, 10.3F, 1.5F);
/* 208 */     this.tail11.func_78790_a(-1.0F, -0.5F, -1.0F, 2, 3, 2, 0.0F);
/* 209 */     setRotateAngle(this.tail11, 1.6390387F, 0.0F, 0.0F);
/* 210 */     this.SnoutSideL = new ModelRenderer(this, 47, 11);
/* 211 */     this.SnoutSideL.field_78809_i = true;
/* 212 */     this.SnoutSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 213 */     this.SnoutSideL.func_78790_a(-1.7F, -2.6F, -4.9F, 2, 2, 1, 0.0F);
/* 214 */     setRotateAngle(this.SnoutSideL, 0.0F, -0.5934119F, 0.0F);
/* 215 */     this.tail23 = new ModelRenderer(this, 20, 47);
/* 216 */     this.tail23.func_78793_a(0.0F, 2.0F, 0.0F);
/* 217 */     this.tail23.func_78790_a(-1.5F, -0.5F, -1.6F, 3, 3, 3, 0.0F);
/* 218 */     setRotateAngle(this.tail23, -0.18203785F, 0.0F, -0.091106184F);
/* 219 */     this.LegR2 = new ModelRenderer(this, 0, 16);
/* 220 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 221 */     this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 222 */     this.ChestPuff1.func_78792_a(this.ChestPuff2);
/* 223 */     this.SideFurR1.func_78792_a(this.SideFurR2);
/* 224 */     this.tail31.func_78792_a(this.tail32);
/* 225 */     this.Head.func_78792_a(this.SideFurR1);
/* 226 */     this.EarR1.func_78792_a(this.EarR2);
/* 227 */     this.tail12.func_78792_a(this.tail13);
/* 228 */     this.Head.func_78792_a(this.EarL1);
/* 229 */     this.tail14.func_78792_a(this.tail15);
/* 230 */     this.tail34.func_78792_a(this.tail35);
/* 231 */     this.SideFurL1.func_78792_a(this.SideFurL2);
/* 232 */     this.Head.func_78792_a(this.Snout1);
/* 233 */     this.Head.func_78792_a(this.SideFurL1);
/* 234 */     this.Head.func_78792_a(this.EarR1);
/* 235 */     this.EarL1.func_78792_a(this.EarL2);
/* 236 */     this.LegL.func_78792_a(this.LegL2);
/* 237 */     this.tail21.func_78792_a(this.tail22);
/* 238 */     this.Body1.func_78792_a(this.Neck);
/* 239 */     this.tail23.func_78792_a(this.tail24);
/* 240 */     this.EarR1.func_78792_a(this.EarR3);
/* 241 */     this.tail24.func_78792_a(this.tail25);
/* 242 */     this.EarL1.func_78792_a(this.EarL3);
/* 243 */     this.tail13.func_78792_a(this.tail14);
/* 244 */     this.Body1.func_78792_a(this.Cloth1);
/* 245 */     this.Snout1.func_78792_a(this.SnoutSideR);
/* 246 */     this.Snout1.func_78792_a(this.Snout2);
/* 247 */     this.tail11.func_78792_a(this.tail12);
/* 248 */     this.EarR1.func_78792_a(this.Earing);
/* 249 */     this.Body2.func_78792_a(this.Body3);
/* 250 */     this.tail32.func_78792_a(this.tail33);
/* 251 */     this.tail33.func_78792_a(this.tail34);
/* 252 */     this.Body1.func_78792_a(this.Body2);
/* 253 */     this.Body1.func_78792_a(this.ChestPuff1);
/* 254 */     this.Snout1.func_78792_a(this.SnoutSideL);
/* 255 */     this.tail22.func_78792_a(this.tail23);
/* 256 */     this.LegR.func_78792_a(this.LegR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 261 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 264 */     this.LegL.func_78785_a(f5);
/* 265 */     this.Head.func_78785_a(f5);
/* 266 */     this.ArmL.func_78785_a(f5);
/* 267 */     this.ArmR.func_78785_a(f5);
/* 268 */     this.Body1.func_78785_a(f5);
/* 269 */     this.LegR.func_78785_a(f5);
/* 270 */     this.tail11.func_78785_a(f5);
/* 271 */     this.tail21.func_78785_a(f5);
/* 272 */     this.tail31.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 276 */     modelRenderer.field_78795_f = x;
/* 277 */     modelRenderer.field_78796_g = y;
/* 278 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 282 */     int calc = par7Entity.field_70173_aa;
/* 283 */     if (calc > 100) calc -= 100; 
/* 284 */     float r = 360.0F;
/* 285 */     float r2 = 180.0F;
/* 286 */     float n4 = par4;
/* 287 */     float n5 = par5;
/*     */     
/* 289 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 290 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 291 */     float ex = par7Entity.field_70173_aa;
/* 292 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 293 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 295 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 296 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 301 */     this.tail12.field_78795_f = 0.2F;
/* 302 */     this.tail12.field_78795_f += r4 / 2.0F;
/*     */     
/* 304 */     this.tail13.field_78795_f = 0.2F;
/* 305 */     this.tail13.field_78795_f += r4 / 2.0F;
/*     */     
/* 307 */     this.tail14.field_78795_f = 0.2F;
/* 308 */     this.tail14.field_78795_f += r4 / 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 316 */     this.tail22.field_78795_f = 0.2F;
/* 317 */     this.tail22.field_78795_f += r4 / 2.0F;
/*     */     
/* 319 */     this.tail23.field_78795_f = 0.2F;
/* 320 */     this.tail23.field_78795_f += r4 / 2.0F;
/*     */     
/* 322 */     this.tail24.field_78795_f = 0.2F;
/* 323 */     this.tail24.field_78795_f += r4 / 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 331 */     this.tail32.field_78795_f = 0.2F;
/* 332 */     this.tail32.field_78795_f += r4 / 2.0F;
/*     */     
/* 334 */     this.tail33.field_78795_f = 0.2F;
/* 335 */     this.tail33.field_78795_f += r4 / 2.0F;
/*     */     
/* 337 */     this.tail34.field_78795_f = 0.2F;
/* 338 */     this.tail34.field_78795_f += r4 / 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 367 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 368 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 369 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 370 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 372 */     this.LegR.field_78796_g = 0.0F;
/* 373 */     this.LegL.field_78796_g = 0.0F;
/* 374 */     this.ArmR.field_78796_g = 0.0F;
/* 375 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 378 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 382 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodLiquiir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */