/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelAngelMarcarita
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer HairR1;
/*     */   public ModelRenderer HairL1;
/*     */   public ModelRenderer HairFrontL1;
/*     */   public ModelRenderer HairFrontR1;
/*     */   public ModelRenderer HairR2;
/*     */   public ModelRenderer HairR3;
/*     */   public ModelRenderer HairR4;
/*     */   public ModelRenderer HairR5;
/*     */   public ModelRenderer HairL2;
/*     */   public ModelRenderer HairL3;
/*     */   public ModelRenderer HairL4;
/*     */   public ModelRenderer HairL5;
/*     */   public ModelRenderer HairFrontL2;
/*     */   public ModelRenderer HairFrontR2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer NeckRing;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer ClothB;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer NeckRing_1;
/*     */   public ModelRenderer NeckRing_2;
/*     */   public ModelRenderer NeckRing_3;
/*     */   public ModelRenderer NeckRing_4;
/*     */   public ModelRenderer NeckRing_5;
/*     */   public ModelRenderer NeckRing_6;
/*     */   public ModelRenderer NeckRing_7;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL4;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelAngelMarcarita() {
/*  52 */     this.field_78090_t = 64;
/*  53 */     this.field_78089_u = 64;
/*  54 */     this.Boobs = new ModelRenderer(this, 35, 28);
/*  55 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.Boobs.func_78790_a(-3.5F, 1.4F, -1.2F, 7, 3, 3, 0.0F);
/*  57 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  58 */     this.LegR2 = new ModelRenderer(this, 17, 47);
/*  59 */     this.LegR2.field_78809_i = true;
/*  60 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.LegR2.func_78790_a(-1.6F, 13.0F, -4.0F, 3, 2, 2, 0.0F);
/*  62 */     this.HairR3 = new ModelRenderer(this, 44, 0);
/*  63 */     this.HairR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.HairR3.func_78790_a(-2.3F, -12.4F, -1.3F, 5, 4, 4, 0.0F);
/*  65 */     setRotateAngle(this.HairR3, 0.0F, 0.0F, 0.31869712F);
/*  66 */     this.LegL4 = new ModelRenderer(this, 0, 33);
/*  67 */     this.LegL4.field_78809_i = true;
/*  68 */     this.LegL4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.LegL4.func_78790_a(-1.4F, 0.0F, -2.0F, 3, 15, 4, 0.0F);
/*  70 */     this.ArmL = new ModelRenderer(this, 40, 35);
/*  71 */     this.ArmL.field_78809_i = true;
/*  72 */     this.ArmL.func_78793_a(5.0F, -1.0F, 0.0F);
/*  73 */     this.ArmL.func_78790_a(-1.0F, -1.5F, -1.4F, 3, 13, 3, 0.0F);
/*  74 */     this.NeckRing_1 = new ModelRenderer(this, 0, 56);
/*  75 */     this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.NeckRing_1.func_78790_a(-9.7F, -2.0F, -2.9F, 2, 1, 7, 0.0F);
/*  77 */     setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F);
/*  78 */     this.ShoulderL = new ModelRenderer(this, 31, 10);
/*  79 */     this.ShoulderL.field_78809_i = true;
/*  80 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.ShoulderL.func_78790_a(-1.0F, -2.3F, -1.9F, 4, 4, 4, 0.0F);
/*  82 */     this.HairR1 = new ModelRenderer(this, 23, 0);
/*  83 */     this.HairR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.HairR1.func_78790_a(0.9F, -8.7F, -0.3F, 2, 2, 2, 0.0F);
/*  85 */     setRotateAngle(this.HairR1, 0.0F, 0.0F, -0.63739425F);
/*  86 */     this.HairL3 = new ModelRenderer(this, 44, 0);
/*  87 */     this.HairL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.HairL3.func_78790_a(-3.6F, -12.4F, -1.3F, 5, 4, 4, 0.0F);
/*  89 */     setRotateAngle(this.HairL3, 0.0F, 0.0F, -0.22759093F);
/*  90 */     this.HairR2 = new ModelRenderer(this, 31, 0);
/*  91 */     this.HairR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.HairR2.func_78790_a(3.3F, -10.5F, -0.8F, 3, 4, 3, 0.0F);
/*  93 */     setRotateAngle(this.HairR2, 0.0F, 0.0F, -0.4098033F);
/*  94 */     this.HairR5 = new ModelRenderer(this, 52, 15);
/*  95 */     this.HairR5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.HairR5.func_78790_a(-9.9F, -0.5F, -0.4F, 2, 6, 2, 0.0F);
/*  97 */     setRotateAngle(this.HairR5, 0.0F, 0.0F, 1.7301449F);
/*  98 */     this.LegR = new ModelRenderer(this, 0, 20);
/*  99 */     this.LegR.func_78793_a(-1.9F, 9.0F, 0.0F);
/* 100 */     this.LegR.func_78790_a(-2.3F, 0.0F, -2.0F, 4, 9, 4, 0.3F);
/* 101 */     this.HairR4 = new ModelRenderer(this, 47, 8);
/* 102 */     this.HairR4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.HairR4.func_78790_a(1.6F, -9.9F, -0.8F, 5, 3, 3, 0.0F);
/* 104 */     setRotateAngle(this.HairR4, 0.0F, 0.0F, -0.7740535F);
/* 105 */     this.NeckRing_6 = new ModelRenderer(this, 19, 54);
/* 106 */     this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.NeckRing_6.func_78790_a(-8.3F, -2.0F, -5.5F, 2, 1, 9, 0.0F);
/* 108 */     setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F);
/* 109 */     this.Neck = new ModelRenderer(this, 7, 16);
/* 110 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.Neck.func_78790_a(-2.0F, -1.3F, -0.8F, 4, 2, 2, 0.0F);
/* 112 */     this.NeckRing_5 = new ModelRenderer(this, 0, 56);
/* 113 */     this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 114 */     this.NeckRing_5.func_78790_a(-8.3F, -2.0F, -3.3F, 2, 1, 7, 0.0F);
/* 115 */     setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F);
/* 116 */     this.HairFrontL1 = new ModelRenderer(this, 2, 2);
/* 117 */     this.HairFrontL1.field_78809_i = true;
/* 118 */     this.HairFrontL1.func_78793_a(0.5F, -6.4F, -3.5F);
/* 119 */     this.HairFrontL1.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 0, 0.0F);
/* 120 */     setRotateAngle(this.HairFrontL1, -0.27314404F, -0.27314404F, -0.4098033F);
/* 121 */     this.NeckRing_4 = new ModelRenderer(this, 0, 56);
/* 122 */     this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.NeckRing_4.func_78790_a(-8.5F, -2.0F, -3.3F, 2, 1, 7, 0.0F);
/* 124 */     setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F);
/* 125 */     this.HairFrontL2 = new ModelRenderer(this, 2, 2);
/* 126 */     this.HairFrontL2.field_78809_i = true;
/* 127 */     this.HairFrontL2.func_78793_a(0.0F, 2.8F, -0.4F);
/* 128 */     this.HairFrontL2.func_78790_a(-0.5F, -0.2F, -0.1F, 1, 3, 0, 0.0F);
/* 129 */     setRotateAngle(this.HairFrontL2, 0.27314404F, 0.0F, 0.27314404F);
/* 130 */     this.HairL4 = new ModelRenderer(this, 47, 8);
/* 131 */     this.HairL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.HairL4.func_78790_a(-6.8F, -9.2F, -0.8F, 5, 3, 3, 0.0F);
/* 133 */     setRotateAngle(this.HairL4, 0.0F, 0.0F, 0.7740535F);
/* 134 */     this.ClothB = new ModelRenderer(this, 44, 52);
/* 135 */     this.ClothB.func_78793_a(0.0F, 9.0F, 2.0F);
/* 136 */     this.ClothB.func_78790_a(-2.5F, 0.0F, 0.0F, 5, 11, 0, 0.0F);
/* 137 */     setRotateAngle(this.ClothB, 0.13264503F, 0.0F, 0.0F);
/* 138 */     this.ArmR = new ModelRenderer(this, 40, 35);
/* 139 */     this.ArmR.func_78793_a(-5.0F, -1.0F, 0.0F);
/* 140 */     this.ArmR.func_78790_a(-2.0F, -1.5F, -1.3F, 3, 13, 3, 0.0F);
/* 141 */     this.Head = new ModelRenderer(this, 0, 0);
/* 142 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/* 143 */     this.Head.func_78790_a(-3.5F, -7.5F, -4.0F, 7, 8, 8, -0.4F);
/* 144 */     this.Body2 = new ModelRenderer(this, 16, 28);
/* 145 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 146 */     this.Body2.func_78790_a(-3.0F, 5.0F, -1.5F, 6, 4, 3, 0.0F);
/* 147 */     this.HairL2 = new ModelRenderer(this, 31, 0);
/* 148 */     this.HairL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 149 */     this.HairL2.func_78790_a(-6.2F, -10.5F, -0.8F, 3, 4, 3, 0.0F);
/* 150 */     setRotateAngle(this.HairL2, 0.0F, 0.0F, 0.4098033F);
/* 151 */     this.ClothF = new ModelRenderer(this, 44, 52);
/* 152 */     this.ClothF.func_78793_a(0.0F, 9.0F, -2.1F);
/* 153 */     this.ClothF.func_78790_a(-2.5F, 0.0F, 0.1F, 5, 11, 0, 0.0F);
/* 154 */     setRotateAngle(this.ClothF, -0.11519173F, 0.0F, 0.0F);
/* 155 */     this.NeckRing_2 = new ModelRenderer(this, 19, 54);
/* 156 */     this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 157 */     this.NeckRing_2.func_78790_a(-8.7F, -2.0F, -3.9F, 2, 1, 9, 0.0F);
/* 158 */     setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F);
/* 159 */     this.ShoulderR = new ModelRenderer(this, 31, 10);
/* 160 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 161 */     this.ShoulderR.func_78790_a(-2.8F, -2.3F, -1.7F, 4, 4, 4, 0.0F);
/* 162 */     this.Body1 = new ModelRenderer(this, 16, 18);
/* 163 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/* 164 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
/* 165 */     this.LegL = new ModelRenderer(this, 0, 20);
/* 166 */     this.LegL.field_78809_i = true;
/* 167 */     this.LegL.func_78793_a(1.9F, 9.0F, 0.0F);
/* 168 */     this.LegL.func_78790_a(-1.7F, 0.0F, -2.0F, 4, 9, 4, 0.3F);
/* 169 */     this.NeckRing_7 = new ModelRenderer(this, 0, 56);
/* 170 */     this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 171 */     this.NeckRing_7.func_78790_a(-9.6F, -2.0F, -4.2F, 2, 1, 7, 0.0F);
/* 172 */     setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F);
/* 173 */     this.HairL1 = new ModelRenderer(this, 23, 0);
/* 174 */     this.HairL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 175 */     this.HairL1.func_78790_a(-2.8F, -8.7F, -0.3F, 2, 2, 2, 0.0F);
/* 176 */     setRotateAngle(this.HairL1, 0.0F, 0.0F, 0.63739425F);
/* 177 */     this.NeckRing_3 = new ModelRenderer(this, 0, 56);
/* 178 */     this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 179 */     this.NeckRing_3.func_78790_a(-8.7F, -2.0F, -3.2F, 2, 1, 7, 0.0F);
/* 180 */     setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F);
/* 181 */     this.HairFrontR1 = new ModelRenderer(this, 2, 2);
/* 182 */     this.HairFrontR1.func_78793_a(-0.8F, -6.4F, -3.5F);
/* 183 */     this.HairFrontR1.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 0, 0.0F);
/* 184 */     setRotateAngle(this.HairFrontR1, -0.27314404F, 0.13665928F, 0.3642502F);
/* 185 */     this.HairL5 = new ModelRenderer(this, 52, 15);
/* 186 */     this.HairL5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 187 */     this.HairL5.func_78790_a(7.2F, 0.8F, -0.4F, 2, 6, 2, 0.0F);
/* 188 */     setRotateAngle(this.HairL5, 0.0F, 0.0F, -1.9577358F);
/* 189 */     this.Body3 = new ModelRenderer(this, 15, 36);
/* 190 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 191 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/* 192 */     this.NeckRing = new ModelRenderer(this, 0, 53);
/* 193 */     this.NeckRing.func_78793_a(0.0F, 0.0F, 0.0F);
/* 194 */     this.NeckRing.func_78790_a(-3.5F, -2.0F, 7.9F, 7, 1, 2, 0.0F);
/* 195 */     setRotateAngle(this.NeckRing, 0.59184116F, 0.0F, 0.0F);
/* 196 */     this.LegL2 = new ModelRenderer(this, 17, 47);
/* 197 */     this.LegL2.field_78809_i = true;
/* 198 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 199 */     this.LegL2.func_78790_a(-1.4F, 13.0F, -4.0F, 3, 2, 2, 0.0F);
/* 200 */     this.HairFrontR2 = new ModelRenderer(this, 2, 2);
/* 201 */     this.HairFrontR2.func_78793_a(0.0F, 2.8F, -0.4F);
/* 202 */     this.HairFrontR2.func_78790_a(-0.5F, -0.2F, -0.1F, 1, 3, 0, 0.0F);
/* 203 */     setRotateAngle(this.HairFrontR2, 0.18203785F, 0.0F, -0.18203785F);
/* 204 */     this.LegR3 = new ModelRenderer(this, 0, 33);
/* 205 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 206 */     this.LegR3.func_78790_a(-1.6F, 0.0F, -2.0F, 3, 15, 4, 0.0F);
/* 207 */     this.Body1.func_78792_a(this.Boobs);
/* 208 */     this.LegR.func_78792_a(this.LegR2);
/* 209 */     this.HairR2.func_78792_a(this.HairR3);
/* 210 */     this.LegL.func_78792_a(this.LegL4);
/* 211 */     this.NeckRing.func_78792_a(this.NeckRing_1);
/* 212 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 213 */     this.Head.func_78792_a(this.HairR1);
/* 214 */     this.HairL2.func_78792_a(this.HairL3);
/* 215 */     this.HairR1.func_78792_a(this.HairR2);
/* 216 */     this.HairR4.func_78792_a(this.HairR5);
/* 217 */     this.HairR3.func_78792_a(this.HairR4);
/* 218 */     this.NeckRing_5.func_78792_a(this.NeckRing_6);
/* 219 */     this.Body1.func_78792_a(this.Neck);
/* 220 */     this.NeckRing_4.func_78792_a(this.NeckRing_5);
/* 221 */     this.Head.func_78792_a(this.HairFrontL1);
/* 222 */     this.NeckRing_3.func_78792_a(this.NeckRing_4);
/* 223 */     this.HairFrontL1.func_78792_a(this.HairFrontL2);
/* 224 */     this.HairL3.func_78792_a(this.HairL4);
/* 225 */     this.Body1.func_78792_a(this.ClothB);
/* 226 */     this.Body1.func_78792_a(this.Body2);
/* 227 */     this.HairL1.func_78792_a(this.HairL2);
/* 228 */     this.Body1.func_78792_a(this.ClothF);
/* 229 */     this.NeckRing_1.func_78792_a(this.NeckRing_2);
/* 230 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 231 */     this.NeckRing_6.func_78792_a(this.NeckRing_7);
/* 232 */     this.Head.func_78792_a(this.HairL1);
/* 233 */     this.NeckRing_2.func_78792_a(this.NeckRing_3);
/* 234 */     this.Head.func_78792_a(this.HairFrontR1);
/* 235 */     this.HairL4.func_78792_a(this.HairL5);
/* 236 */     this.Body2.func_78792_a(this.Body3);
/* 237 */     this.Body1.func_78792_a(this.NeckRing);
/* 238 */     this.LegL.func_78792_a(this.LegL2);
/* 239 */     this.HairFrontR1.func_78792_a(this.HairFrontR2);
/* 240 */     this.LegR.func_78792_a(this.LegR3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 245 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 248 */     this.LegL.func_78785_a(f5);
/* 249 */     this.Head.func_78785_a(f5);
/* 250 */     this.ArmL.func_78785_a(f5);
/* 251 */     this.ArmR.func_78785_a(f5);
/* 252 */     this.Body1.func_78785_a(f5);
/* 253 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 258 */     modelRenderer.field_78795_f = x;
/* 259 */     modelRenderer.field_78796_g = y;
/* 260 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 264 */     int calc = par7Entity.field_70173_aa;
/* 265 */     if (calc > 100) calc -= 100; 
/* 266 */     float r = 360.0F;
/* 267 */     float r2 = 180.0F;
/* 268 */     float n4 = par4;
/* 269 */     float n5 = par5;
/*     */     
/* 271 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 272 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 273 */     float ex = par7Entity.field_70173_aa;
/* 274 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 275 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 277 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 278 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 320 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 321 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 322 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 323 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 325 */     this.LegR.field_78796_g = 0.0F;
/* 326 */     this.LegL.field_78796_g = 0.0F;
/* 327 */     this.ArmR.field_78796_g = 0.0F;
/* 328 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 331 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 333 */     this.ClothB.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 335 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelAngelMarcarita.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */