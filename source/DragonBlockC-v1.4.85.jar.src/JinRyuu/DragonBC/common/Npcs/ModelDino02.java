/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelDino02
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer LeftLeg;
/*     */   public ModelRenderer RightLeg;
/*     */   public ModelRenderer Tail;
/*     */   public ModelRenderer Neck2;
/*     */   public ModelRenderer Neck3;
/*     */   public ModelRenderer Neck4;
/*     */   public ModelRenderer Neck5;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer L;
/*     */   public ModelRenderer R;
/*     */   public ModelRenderer T;
/*     */   public ModelRenderer Mouth;
/*     */   public ModelRenderer T2;
/*     */   public ModelRenderer LeftLeg2;
/*     */   public ModelRenderer LeftLeg3;
/*     */   public ModelRenderer lf1;
/*     */   public ModelRenderer lf2;
/*     */   public ModelRenderer lf3;
/*     */   public ModelRenderer lf4;
/*     */   public ModelRenderer RightLeg2;
/*     */   public ModelRenderer RightLeg3;
/*     */   public ModelRenderer rf1;
/*     */   public ModelRenderer rf2;
/*     */   public ModelRenderer rf3;
/*     */   public ModelRenderer lf4_1;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Tail5;
/*     */   public ModelRenderer Tail6;
/*     */   
/*     */   public ModelDino02() {
/*  56 */     this.field_78090_t = 128;
/*  57 */     this.field_78089_u = 128;
/*  58 */     this.rf3 = new ModelRenderer(this, 67, 76);
/*  59 */     this.rf3.func_78793_a(-1.1F, 10.0F, 0.8F);
/*  60 */     this.rf3.func_78790_a(-0.5F, 0.0F, -0.8F, 1, 5, 1, 0.0F);
/*  61 */     setRotation(this.rf3, -1.0471976F, 0.4098033F, 0.0F);
/*  62 */     this.lf3 = new ModelRenderer(this, 67, 76);
/*  63 */     this.lf3.field_78809_i = true;
/*  64 */     this.lf3.func_78793_a(-1.1F, 10.0F, 0.8F);
/*  65 */     this.lf3.func_78790_a(-0.5F, 0.0F, -0.8F, 1, 5, 1, 0.0F);
/*  66 */     setRotation(this.lf3, -1.0471976F, 0.4098033F, 0.0F);
/*  67 */     this.lf4 = new ModelRenderer(this, 67, 76);
/*  68 */     this.lf4.field_78809_i = true;
/*  69 */     this.lf4.func_78793_a(0.0F, 9.9F, 3.4F);
/*  70 */     this.lf4.func_78790_a(-1.0F, 0.0F, -0.5F, 2, 4, 1, 0.0F);
/*  71 */     setRotation(this.lf4, 1.3203416F, 0.0F, 0.0F);
/*  72 */     this.R = new ModelRenderer(this, 35, 0);
/*  73 */     this.R.func_78793_a(0.0F, 0.0F, -5.7F);
/*  74 */     this.R.func_78790_a(-4.0F, -2.5F, 0.0F, 4, 5, 6, 0.0F);
/*  75 */     setRotation(this.R, 0.0F, -0.59184116F, 0.0F);
/*  76 */     this.RightLeg2 = new ModelRenderer(this, 73, 54);
/*  77 */     this.RightLeg2.func_78793_a(-3.0F, 10.1F, -2.8F);
/*  78 */     this.RightLeg2.func_78790_a(-3.0F, 0.0F, -4.4F, 6, 11, 5, 0.0F);
/*  79 */     setRotation(this.RightLeg2, 1.5934856F, 0.0F, 0.0F);
/*  80 */     this.Tail2 = new ModelRenderer(this, 0, 89);
/*  81 */     this.Tail2.func_78793_a(0.5F, 0.5F, 10.9F);
/*  82 */     this.Tail2.func_78790_a(-5.0F, -5.0F, 0.0F, 9, 9, 13, 0.0F);
/*  83 */     setRotation(this.Tail2, -0.27314404F, 0.0F, 0.0F);
/*  84 */     this.LeftLeg = new ModelRenderer(this, 73, 32);
/*  85 */     this.LeftLeg.field_78809_i = true;
/*  86 */     this.LeftLeg.func_78793_a(7.9F, 7.8F, 8.5F);
/*  87 */     this.LeftLeg.func_78790_a(0.4F, -0.8F, -3.5F, 7, 11, 7, 0.0F);
/*  88 */     setRotation(this.LeftLeg, -0.5009095F, 0.0F, 0.0F);
/*  89 */     this.lf2 = new ModelRenderer(this, 67, 76);
/*  90 */     this.lf2.field_78809_i = true;
/*  91 */     this.lf2.func_78793_a(0.0F, 10.0F, 0.8F);
/*  92 */     this.lf2.func_78790_a(-0.5F, 0.0F, -0.8F, 1, 5, 1, 0.0F);
/*  93 */     setRotation(this.lf2, -1.0471976F, 0.0F, 0.091106184F);
/*  94 */     this.lf4_1 = new ModelRenderer(this, 67, 76);
/*  95 */     this.lf4_1.func_78793_a(0.0F, 9.9F, 3.4F);
/*  96 */     this.lf4_1.func_78790_a(-1.0F, 0.0F, -0.5F, 2, 4, 1, 0.0F);
/*  97 */     setRotation(this.lf4_1, 1.3203416F, 0.0F, 0.0F);
/*  98 */     this.Tail6 = new ModelRenderer(this, 81, 101);
/*  99 */     this.Tail6.func_78793_a(-0.5F, 0.0F, 9.7F);
/* 100 */     this.Tail6.func_78790_a(-3.0F, -3.0F, 0.0F, 6, 6, 13, 0.0F);
/* 101 */     this.RightLeg = new ModelRenderer(this, 73, 32);
/* 102 */     this.RightLeg.func_78793_a(-7.9F, 7.8F, 8.5F);
/* 103 */     this.RightLeg.func_78790_a(-6.5F, -0.8F, -3.5F, 7, 11, 7, 0.0F);
/* 104 */     setRotation(this.RightLeg, -0.5009095F, 0.0F, 0.0F);
/* 105 */     this.T2 = new ModelRenderer(this, 59, 0);
/* 106 */     this.T2.func_78793_a(0.0F, -5.0F, 0.1F);
/* 107 */     this.T2.func_78790_a(-1.0F, -6.0F, -2.5F, 2, 6, 3, 0.0F);
/* 108 */     setRotation(this.T2, -0.31869712F, 0.0F, 0.0F);
/* 109 */     this.Tail3 = new ModelRenderer(this, 34, 101);
/* 110 */     this.Tail3.func_78793_a(-0.5F, -1.0F, 9.7F);
/* 111 */     this.Tail3.func_78790_a(-4.0F, -4.0F, 0.0F, 8, 8, 13, 0.0F);
/* 112 */     setRotation(this.Tail3, -0.27314404F, 0.0F, 0.0F);
/* 113 */     this.RightLeg3 = new ModelRenderer(this, 73, 71);
/* 114 */     this.RightLeg3.func_78793_a(0.0F, 9.8F, -0.5F);
/* 115 */     this.RightLeg3.func_78790_a(-2.0F, -0.7F, 0.0F, 4, 11, 4, 0.0F);
/* 116 */     setRotation(this.RightLeg3, -1.2747885F, 0.0F, 0.0F);
/* 117 */     this.Tail5 = new ModelRenderer(this, 34, 101);
/* 118 */     this.Tail5.func_78793_a(-0.5F, 0.0F, 9.7F);
/* 119 */     this.Tail5.func_78790_a(-4.0F, -4.0F, 0.0F, 8, 8, 13, 0.0F);
/* 120 */     setRotation(this.Tail5, 0.27314404F, 0.0F, 0.0F);
/* 121 */     this.rf2 = new ModelRenderer(this, 67, 76);
/* 122 */     this.rf2.func_78793_a(0.0F, 10.0F, 0.8F);
/* 123 */     this.rf2.func_78790_a(-0.5F, 0.0F, -0.8F, 1, 5, 1, 0.0F);
/* 124 */     setRotation(this.rf2, -1.0471976F, 0.0F, 0.091106184F);
/* 125 */     this.Head = new ModelRenderer(this, 0, 0);
/* 126 */     this.Head.func_78793_a(0.0F, 0.0F, -7.0F);
/* 127 */     this.Head.func_78790_a(-4.0F, -3.5F, -8.0F, 8, 7, 8, 0.0F);
/* 128 */     setRotation(this.Head, 0.31869712F, 0.0F, 0.0F);
/* 129 */     this.T = new ModelRenderer(this, 59, 11);
/* 130 */     this.T.func_78793_a(0.0F, -1.9F, -5.4F);
/* 131 */     this.T.func_78790_a(-1.5F, -6.0F, -2.5F, 3, 6, 5, 0.0F);
/* 132 */     setRotation(this.T, -0.5009095F, 0.0F, 0.0F);
/* 133 */     this.Neck4 = new ModelRenderer(this, 80, 0);
/* 134 */     this.Neck4.func_78793_a(0.0F, 0.0F, -7.0F);
/* 135 */     this.Neck4.func_78790_a(-4.0F, -3.0F, -8.0F, 8, 6, 8, 0.0F);
/* 136 */     this.Tail4 = new ModelRenderer(this, 34, 101);
/* 137 */     this.Tail4.func_78793_a(-0.5F, 0.0F, 9.7F);
/* 138 */     this.Tail4.func_78790_a(-4.0F, -4.0F, 0.0F, 8, 8, 13, 0.0F);
/* 139 */     this.rf1 = new ModelRenderer(this, 67, 76);
/* 140 */     this.rf1.func_78793_a(1.1F, 10.0F, 0.8F);
/* 141 */     this.rf1.func_78790_a(-0.5F, 0.0F, -0.8F, 1, 5, 1, 0.0F);
/* 142 */     setRotation(this.rf1, -1.0471976F, -0.4098033F, 0.0F);
/* 143 */     this.lf1 = new ModelRenderer(this, 67, 76);
/* 144 */     this.lf1.field_78809_i = true;
/* 145 */     this.lf1.func_78793_a(1.1F, 10.0F, 0.8F);
/* 146 */     this.lf1.func_78790_a(-0.5F, 0.0F, -0.8F, 1, 5, 1, 0.0F);
/* 147 */     setRotation(this.lf1, -1.0471976F, -0.4098033F, 0.0F);
/* 148 */     this.Neck5 = new ModelRenderer(this, 80, 0);
/* 149 */     this.Neck5.func_78793_a(0.0F, -0.5F, -6.2F);
/* 150 */     this.Neck5.func_78790_a(-4.0F, -3.0F, -8.0F, 8, 6, 8, 0.0F);
/* 151 */     setRotation(this.Neck5, 0.67945665F, 0.0F, 0.0F);
/* 152 */     this.Neck2 = new ModelRenderer(this, 80, 0);
/* 153 */     this.Neck2.func_78793_a(0.0F, 0.0F, -7.0F);
/* 154 */     this.Neck2.func_78790_a(-4.0F, -3.0F, -8.0F, 8, 6, 8, 0.0F);
/* 155 */     setRotation(this.Neck2, -0.22759093F, 0.0F, 0.0F);
/* 156 */     this.Body = new ModelRenderer(this, 0, 30);
/* 157 */     this.Body.func_78793_a(0.0F, -7.0F, 0.0F);
/* 158 */     this.Body.func_78790_a(-8.0F, -2.0F, -1.8F, 16, 13, 19, 0.0F);
/* 159 */     this.Tail = new ModelRenderer(this, 0, 65);
/* 160 */     this.Tail.func_78793_a(0.0F, 4.1F, 13.6F);
/* 161 */     this.Tail.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 13, 0.0F);
/* 162 */     this.LeftLeg3 = new ModelRenderer(this, 73, 71);
/* 163 */     this.LeftLeg3.field_78809_i = true;
/* 164 */     this.LeftLeg3.func_78793_a(0.0F, 9.8F, -0.5F);
/* 165 */     this.LeftLeg3.func_78790_a(-2.0F, -0.7F, 0.0F, 4, 11, 4, 0.0F);
/* 166 */     setRotation(this.LeftLeg3, -1.2747885F, 0.0F, 0.0F);
/* 167 */     this.Neck = new ModelRenderer(this, 80, 0);
/* 168 */     this.Neck.func_78793_a(0.0F, 1.6F, 1.8F);
/* 169 */     this.Neck.func_78790_a(-4.0F, -3.0F, -8.0F, 8, 6, 8, 0.0F);
/* 170 */     setRotation(this.Neck, 0.18203785F, 0.0F, 0.0F);
/* 171 */     this.Mouth = new ModelRenderer(this, 0, 16);
/* 172 */     this.Mouth.func_78793_a(0.0F, 1.2F, -7.5F);
/* 173 */     this.Mouth.func_78790_a(-2.5F, -2.0F, -7.0F, 5, 4, 7, 0.0F);
/* 174 */     this.Neck3 = new ModelRenderer(this, 80, 0);
/* 175 */     this.Neck3.func_78793_a(0.0F, 0.5F, -6.4F);
/* 176 */     this.Neck3.func_78790_a(-4.0F, -3.0F, -8.0F, 8, 6, 8, 0.0F);
/* 177 */     setRotation(this.Neck3, -0.7285004F, 0.0F, 0.0F);
/* 178 */     this.LeftLeg2 = new ModelRenderer(this, 73, 54);
/* 179 */     this.LeftLeg2.field_78809_i = true;
/* 180 */     this.LeftLeg2.func_78793_a(4.0F, 10.1F, -2.8F);
/* 181 */     this.LeftLeg2.func_78790_a(-3.0F, 0.0F, -4.4F, 6, 11, 5, 0.0F);
/* 182 */     setRotation(this.LeftLeg2, 1.5934856F, 0.0F, 0.0F);
/* 183 */     this.L = new ModelRenderer(this, 35, 0);
/* 184 */     this.L.field_78809_i = true;
/* 185 */     this.L.func_78793_a(0.0F, 0.0F, -5.0F);
/* 186 */     this.L.func_78790_a(0.0F, -2.5F, 0.0F, 4, 5, 6, 0.0F);
/* 187 */     setRotation(this.L, 0.0F, 0.59184116F, 0.0F);
/* 188 */     this.RightLeg3.func_78792_a(this.rf3);
/* 189 */     this.LeftLeg3.func_78792_a(this.lf3);
/* 190 */     this.LeftLeg3.func_78792_a(this.lf4);
/* 191 */     this.Head.func_78792_a(this.R);
/* 192 */     this.RightLeg.func_78792_a(this.RightLeg2);
/* 193 */     this.Tail.func_78792_a(this.Tail2);
/* 194 */     this.Body.func_78792_a(this.LeftLeg);
/* 195 */     this.LeftLeg3.func_78792_a(this.lf2);
/* 196 */     this.RightLeg3.func_78792_a(this.lf4_1);
/* 197 */     this.Tail5.func_78792_a(this.Tail6);
/* 198 */     this.Body.func_78792_a(this.RightLeg);
/* 199 */     this.T.func_78792_a(this.T2);
/* 200 */     this.Tail2.func_78792_a(this.Tail3);
/* 201 */     this.RightLeg2.func_78792_a(this.RightLeg3);
/* 202 */     this.Tail4.func_78792_a(this.Tail5);
/* 203 */     this.RightLeg3.func_78792_a(this.rf2);
/* 204 */     this.Neck5.func_78792_a(this.Head);
/* 205 */     this.Head.func_78792_a(this.T);
/* 206 */     this.Neck3.func_78792_a(this.Neck4);
/* 207 */     this.Tail3.func_78792_a(this.Tail4);
/* 208 */     this.RightLeg3.func_78792_a(this.rf1);
/* 209 */     this.LeftLeg3.func_78792_a(this.lf1);
/* 210 */     this.Neck4.func_78792_a(this.Neck5);
/* 211 */     this.Neck.func_78792_a(this.Neck2);
/* 212 */     this.Body.func_78792_a(this.Tail);
/* 213 */     this.LeftLeg2.func_78792_a(this.LeftLeg3);
/* 214 */     this.Body.func_78792_a(this.Neck);
/* 215 */     this.Head.func_78792_a(this.Mouth);
/* 216 */     this.Neck2.func_78792_a(this.Neck3);
/* 217 */     this.LeftLeg.func_78792_a(this.LeftLeg2);
/* 218 */     this.Head.func_78792_a(this.L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 224 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 225 */     GL11.glPushMatrix();
/*     */ 
/*     */     
/* 228 */     this.Body.func_78785_a(f5);
/* 229 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 233 */     model.field_78795_f = x;
/* 234 */     model.field_78796_g = y;
/* 235 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 240 */     float r = 360.0F;
/* 241 */     float r2 = 180.0F;
/*     */     
/* 243 */     float n4 = (par4 + r2) % r; n4 = (n4 > 0.0F) ? (n4 - r2) : (n4 + r2); n4 = (n4 > r2) ? r2 : ((n4 < -r2) ? -r2 : n4);
/* 244 */     float n5 = par5;
/* 245 */     float p = 5.0F;
/*     */ 
/*     */     
/* 248 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F / p;
/* 249 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F / p;
/* 250 */     this.Neck.field_78796_g = n4 / r2 / 3.1415927F / p;
/* 251 */     this.Neck.field_78795_f = n5 / r2 / 3.1415927F / p;
/* 252 */     this.Neck2.field_78796_g = n4 / r2 / 3.1415927F / p;
/* 253 */     this.Neck2.field_78795_f = n5 / r2 / 3.1415927F / p;
/* 254 */     this.Neck3.field_78796_g = n4 / r2 / 3.1415927F / p;
/* 255 */     this.Neck3.field_78795_f = n5 / r2 / 3.1415927F / p;
/* 256 */     this.Neck4.field_78796_g = n4 / r2 / 3.1415927F / p;
/* 257 */     this.Neck4.field_78795_f = n5 / r2 / 3.1415927F / p;
/* 258 */     this.Neck5.field_78796_g = n4 / r2 / 3.1415927F / p;
/* 259 */     this.Neck5.field_78795_f = n5 / r2 / 3.1415927F / p;
/* 260 */     this.RightLeg.field_78795_f = -0.5F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 261 */     this.LeftLeg.field_78795_f = -0.5F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 262 */     this.RightLeg.field_78796_g = 0.0F;
/* 263 */     this.LeftLeg.field_78796_g = 0.0F;
/*     */     
/* 265 */     float ex = par7Entity.field_70173_aa;
/* 266 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 267 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 4.0F - 0.2F;
/* 268 */     this.Tail.field_78796_g = 0.2F;
/* 269 */     this.Tail.field_78796_g += r4;
/*     */     
/* 271 */     this.Tail2.field_78796_g = 0.2F;
/* 272 */     this.Tail2.field_78796_g += r4;
/*     */     
/* 274 */     this.Tail3.field_78796_g = 0.2F;
/* 275 */     this.Tail3.field_78796_g += r4;
/*     */     
/* 277 */     this.Tail4.field_78796_g = 0.2F;
/* 278 */     this.Tail4.field_78796_g += r4;
/*     */     
/* 280 */     this.Tail5.field_78796_g = 0.2F;
/* 281 */     this.Tail5.field_78796_g += r4;
/*     */     
/* 283 */     this.Tail6.field_78796_g = 0.2F;
/* 284 */     this.Tail6.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */     
/* 288 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelDino02.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */