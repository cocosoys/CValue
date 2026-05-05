/*     */ package net.minecraft.client.model;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelHorse
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer field_110709_a;
/*     */   private ModelRenderer field_110707_b;
/*     */   private ModelRenderer field_110708_c;
/*     */   private ModelRenderer field_110705_d;
/*     */   private ModelRenderer field_110706_e;
/*     */   private ModelRenderer field_110703_f;
/*     */   private ModelRenderer field_110704_g;
/*     */   private ModelRenderer field_110716_h;
/*     */   private ModelRenderer field_110717_i;
/*     */   private ModelRenderer field_110714_j;
/*     */   private ModelRenderer field_110715_k;
/*     */   private ModelRenderer field_110712_l;
/*     */   private ModelRenderer field_110713_m;
/*     */   private ModelRenderer field_110710_n;
/*     */   private ModelRenderer field_110711_o;
/*     */   private ModelRenderer field_110719_v;
/*     */   private ModelRenderer field_110718_w;
/*     */   private ModelRenderer field_110722_x;
/*     */   private ModelRenderer field_110721_y;
/*     */   private ModelRenderer field_110720_z;
/*     */   private ModelRenderer field_110688_A;
/*     */   private ModelRenderer field_110689_B;
/*     */   private ModelRenderer field_110690_C;
/*     */   private ModelRenderer field_110684_D;
/*     */   private ModelRenderer field_110685_E;
/*     */   private ModelRenderer field_110686_F;
/*     */   private ModelRenderer field_110687_G;
/*     */   private ModelRenderer field_110695_H;
/*     */   private ModelRenderer field_110696_I;
/*     */   private ModelRenderer field_110697_J;
/*     */   private ModelRenderer field_110698_K;
/*     */   private ModelRenderer field_110691_L;
/*     */   private ModelRenderer field_110692_M;
/*     */   private ModelRenderer field_110693_N;
/*     */   private ModelRenderer field_110694_O;
/*     */   private ModelRenderer field_110700_P;
/*     */   private ModelRenderer field_110699_Q;
/*     */   private ModelRenderer field_110702_R;
/*     */   private ModelRenderer field_110701_S;
/*     */   private static final String __OBFID = "CL_00000846";
/*     */   
/*     */   public ModelHorse() {
/*  63 */     this.field_78090_t = 128;
/*  64 */     this.field_78089_u = 128;
/*     */ 
/*     */     
/*  67 */     this.field_110715_k = new ModelRenderer(this, 0, 34);
/*  68 */     this.field_110715_k.func_78789_a(-5.0F, -8.0F, -19.0F, 10, 10, 24);
/*  69 */     this.field_110715_k.func_78793_a(0.0F, 11.0F, 9.0F);
/*     */     
/*  71 */     this.field_110712_l = new ModelRenderer(this, 44, 0);
/*  72 */     this.field_110712_l.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 3);
/*  73 */     this.field_110712_l.func_78793_a(0.0F, 3.0F, 14.0F);
/*  74 */     func_110682_a(this.field_110712_l, -1.134464F, 0.0F, 0.0F);
/*     */     
/*  76 */     this.field_110713_m = new ModelRenderer(this, 38, 7);
/*  77 */     this.field_110713_m.func_78789_a(-1.5F, -2.0F, 3.0F, 3, 4, 7);
/*  78 */     this.field_110713_m.func_78793_a(0.0F, 3.0F, 14.0F);
/*  79 */     func_110682_a(this.field_110713_m, -1.134464F, 0.0F, 0.0F);
/*     */     
/*  81 */     this.field_110710_n = new ModelRenderer(this, 24, 3);
/*  82 */     this.field_110710_n.func_78789_a(-1.5F, -4.5F, 9.0F, 3, 4, 7);
/*  83 */     this.field_110710_n.func_78793_a(0.0F, 3.0F, 14.0F);
/*  84 */     func_110682_a(this.field_110710_n, -1.40215F, 0.0F, 0.0F);
/*     */     
/*  86 */     this.field_110711_o = new ModelRenderer(this, 78, 29);
/*  87 */     this.field_110711_o.func_78789_a(-2.5F, -2.0F, -2.5F, 4, 9, 5);
/*  88 */     this.field_110711_o.func_78793_a(4.0F, 9.0F, 11.0F);
/*     */     
/*  90 */     this.field_110719_v = new ModelRenderer(this, 78, 43);
/*  91 */     this.field_110719_v.func_78789_a(-2.0F, 0.0F, -1.5F, 3, 5, 3);
/*  92 */     this.field_110719_v.func_78793_a(4.0F, 16.0F, 11.0F);
/*     */     
/*  94 */     this.field_110718_w = new ModelRenderer(this, 78, 51);
/*  95 */     this.field_110718_w.func_78789_a(-2.5F, 5.1F, -2.0F, 4, 3, 4);
/*  96 */     this.field_110718_w.func_78793_a(4.0F, 16.0F, 11.0F);
/*     */     
/*  98 */     this.field_110722_x = new ModelRenderer(this, 96, 29);
/*  99 */     this.field_110722_x.func_78789_a(-1.5F, -2.0F, -2.5F, 4, 9, 5);
/* 100 */     this.field_110722_x.func_78793_a(-4.0F, 9.0F, 11.0F);
/*     */     
/* 102 */     this.field_110721_y = new ModelRenderer(this, 96, 43);
/* 103 */     this.field_110721_y.func_78789_a(-1.0F, 0.0F, -1.5F, 3, 5, 3);
/* 104 */     this.field_110721_y.func_78793_a(-4.0F, 16.0F, 11.0F);
/*     */     
/* 106 */     this.field_110720_z = new ModelRenderer(this, 96, 51);
/* 107 */     this.field_110720_z.func_78789_a(-1.5F, 5.1F, -2.0F, 4, 3, 4);
/* 108 */     this.field_110720_z.func_78793_a(-4.0F, 16.0F, 11.0F);
/*     */     
/* 110 */     this.field_110688_A = new ModelRenderer(this, 44, 29);
/* 111 */     this.field_110688_A.func_78789_a(-1.9F, -1.0F, -2.1F, 3, 8, 4);
/* 112 */     this.field_110688_A.func_78793_a(4.0F, 9.0F, -8.0F);
/*     */     
/* 114 */     this.field_110689_B = new ModelRenderer(this, 44, 41);
/* 115 */     this.field_110689_B.func_78789_a(-1.9F, 0.0F, -1.6F, 3, 5, 3);
/* 116 */     this.field_110689_B.func_78793_a(4.0F, 16.0F, -8.0F);
/*     */     
/* 118 */     this.field_110690_C = new ModelRenderer(this, 44, 51);
/* 119 */     this.field_110690_C.func_78789_a(-2.4F, 5.1F, -2.1F, 4, 3, 4);
/* 120 */     this.field_110690_C.func_78793_a(4.0F, 16.0F, -8.0F);
/*     */     
/* 122 */     this.field_110684_D = new ModelRenderer(this, 60, 29);
/* 123 */     this.field_110684_D.func_78789_a(-1.1F, -1.0F, -2.1F, 3, 8, 4);
/* 124 */     this.field_110684_D.func_78793_a(-4.0F, 9.0F, -8.0F);
/*     */     
/* 126 */     this.field_110685_E = new ModelRenderer(this, 60, 41);
/* 127 */     this.field_110685_E.func_78789_a(-1.1F, 0.0F, -1.6F, 3, 5, 3);
/* 128 */     this.field_110685_E.func_78793_a(-4.0F, 16.0F, -8.0F);
/*     */     
/* 130 */     this.field_110686_F = new ModelRenderer(this, 60, 51);
/* 131 */     this.field_110686_F.func_78789_a(-1.6F, 5.1F, -2.1F, 4, 3, 4);
/* 132 */     this.field_110686_F.func_78793_a(-4.0F, 16.0F, -8.0F);
/*     */     
/* 134 */     this.field_110709_a = new ModelRenderer(this, 0, 0);
/* 135 */     this.field_110709_a.func_78789_a(-2.5F, -10.0F, -1.5F, 5, 5, 7);
/* 136 */     this.field_110709_a.func_78793_a(0.0F, 4.0F, -10.0F);
/* 137 */     func_110682_a(this.field_110709_a, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 139 */     this.field_110707_b = new ModelRenderer(this, 24, 18);
/* 140 */     this.field_110707_b.func_78789_a(-2.0F, -10.0F, -7.0F, 4, 3, 6);
/* 141 */     this.field_110707_b.func_78793_a(0.0F, 3.95F, -10.0F);
/* 142 */     func_110682_a(this.field_110707_b, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 144 */     this.field_110708_c = new ModelRenderer(this, 24, 27);
/* 145 */     this.field_110708_c.func_78789_a(-2.0F, -7.0F, -6.5F, 4, 2, 5);
/* 146 */     this.field_110708_c.func_78793_a(0.0F, 4.0F, -10.0F);
/* 147 */     func_110682_a(this.field_110708_c, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 149 */     this.field_110709_a.func_78792_a(this.field_110707_b);
/* 150 */     this.field_110709_a.func_78792_a(this.field_110708_c);
/*     */     
/* 152 */     this.field_110705_d = new ModelRenderer(this, 0, 0);
/* 153 */     this.field_110705_d.func_78789_a(0.45F, -12.0F, 4.0F, 2, 3, 1);
/* 154 */     this.field_110705_d.func_78793_a(0.0F, 4.0F, -10.0F);
/* 155 */     func_110682_a(this.field_110705_d, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 157 */     this.field_110706_e = new ModelRenderer(this, 0, 0);
/* 158 */     this.field_110706_e.func_78789_a(-2.45F, -12.0F, 4.0F, 2, 3, 1);
/* 159 */     this.field_110706_e.func_78793_a(0.0F, 4.0F, -10.0F);
/* 160 */     func_110682_a(this.field_110706_e, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 162 */     this.field_110703_f = new ModelRenderer(this, 0, 12);
/* 163 */     this.field_110703_f.func_78789_a(-2.0F, -16.0F, 4.0F, 2, 7, 1);
/* 164 */     this.field_110703_f.func_78793_a(0.0F, 4.0F, -10.0F);
/* 165 */     func_110682_a(this.field_110703_f, 0.5235988F, 0.0F, 0.2617994F);
/*     */     
/* 167 */     this.field_110704_g = new ModelRenderer(this, 0, 12);
/* 168 */     this.field_110704_g.func_78789_a(0.0F, -16.0F, 4.0F, 2, 7, 1);
/* 169 */     this.field_110704_g.func_78793_a(0.0F, 4.0F, -10.0F);
/* 170 */     func_110682_a(this.field_110704_g, 0.5235988F, 0.0F, -0.2617994F);
/*     */     
/* 172 */     this.field_110716_h = new ModelRenderer(this, 0, 12);
/* 173 */     this.field_110716_h.func_78789_a(-2.05F, -9.8F, -2.0F, 4, 14, 8);
/* 174 */     this.field_110716_h.func_78793_a(0.0F, 4.0F, -10.0F);
/* 175 */     func_110682_a(this.field_110716_h, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 177 */     this.field_110687_G = new ModelRenderer(this, 0, 34);
/* 178 */     this.field_110687_G.func_78789_a(-3.0F, 0.0F, 0.0F, 8, 8, 3);
/* 179 */     this.field_110687_G.func_78793_a(-7.5F, 3.0F, 10.0F);
/* 180 */     func_110682_a(this.field_110687_G, 0.0F, 1.570796F, 0.0F);
/*     */     
/* 182 */     this.field_110695_H = new ModelRenderer(this, 0, 47);
/* 183 */     this.field_110695_H.func_78789_a(-3.0F, 0.0F, 0.0F, 8, 8, 3);
/* 184 */     this.field_110695_H.func_78793_a(4.5F, 3.0F, 10.0F);
/* 185 */     func_110682_a(this.field_110695_H, 0.0F, 1.570796F, 0.0F);
/*     */     
/* 187 */     this.field_110696_I = new ModelRenderer(this, 80, 0);
/* 188 */     this.field_110696_I.func_78789_a(-5.0F, 0.0F, -3.0F, 10, 1, 8);
/* 189 */     this.field_110696_I.func_78793_a(0.0F, 2.0F, 2.0F);
/*     */     
/* 191 */     this.field_110697_J = new ModelRenderer(this, 106, 9);
/* 192 */     this.field_110697_J.func_78789_a(-1.5F, -1.0F, -3.0F, 3, 1, 2);
/* 193 */     this.field_110697_J.func_78793_a(0.0F, 2.0F, 2.0F);
/*     */     
/* 195 */     this.field_110698_K = new ModelRenderer(this, 80, 9);
/* 196 */     this.field_110698_K.func_78789_a(-4.0F, -1.0F, 3.0F, 8, 1, 2);
/* 197 */     this.field_110698_K.func_78793_a(0.0F, 2.0F, 2.0F);
/*     */     
/* 199 */     this.field_110692_M = new ModelRenderer(this, 74, 0);
/* 200 */     this.field_110692_M.func_78789_a(-0.5F, 6.0F, -1.0F, 1, 2, 2);
/* 201 */     this.field_110692_M.func_78793_a(5.0F, 3.0F, 2.0F);
/*     */     
/* 203 */     this.field_110691_L = new ModelRenderer(this, 70, 0);
/* 204 */     this.field_110691_L.func_78789_a(-0.5F, 0.0F, -0.5F, 1, 6, 1);
/* 205 */     this.field_110691_L.func_78793_a(5.0F, 3.0F, 2.0F);
/*     */     
/* 207 */     this.field_110694_O = new ModelRenderer(this, 74, 4);
/* 208 */     this.field_110694_O.func_78789_a(-0.5F, 6.0F, -1.0F, 1, 2, 2);
/* 209 */     this.field_110694_O.func_78793_a(-5.0F, 3.0F, 2.0F);
/*     */     
/* 211 */     this.field_110693_N = new ModelRenderer(this, 80, 0);
/* 212 */     this.field_110693_N.func_78789_a(-0.5F, 0.0F, -0.5F, 1, 6, 1);
/* 213 */     this.field_110693_N.func_78793_a(-5.0F, 3.0F, 2.0F);
/*     */     
/* 215 */     this.field_110700_P = new ModelRenderer(this, 74, 13);
/* 216 */     this.field_110700_P.func_78789_a(1.5F, -8.0F, -4.0F, 1, 2, 2);
/* 217 */     this.field_110700_P.func_78793_a(0.0F, 4.0F, -10.0F);
/* 218 */     func_110682_a(this.field_110700_P, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 220 */     this.field_110699_Q = new ModelRenderer(this, 74, 13);
/* 221 */     this.field_110699_Q.func_78789_a(-2.5F, -8.0F, -4.0F, 1, 2, 2);
/* 222 */     this.field_110699_Q.func_78793_a(0.0F, 4.0F, -10.0F);
/* 223 */     func_110682_a(this.field_110699_Q, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 225 */     this.field_110702_R = new ModelRenderer(this, 44, 10);
/* 226 */     this.field_110702_R.func_78789_a(2.6F, -6.0F, -6.0F, 0, 3, 16);
/* 227 */     this.field_110702_R.func_78793_a(0.0F, 4.0F, -10.0F);
/*     */     
/* 229 */     this.field_110701_S = new ModelRenderer(this, 44, 5);
/* 230 */     this.field_110701_S.func_78789_a(-2.6F, -6.0F, -6.0F, 0, 3, 16);
/* 231 */     this.field_110701_S.func_78793_a(0.0F, 4.0F, -10.0F);
/*     */     
/* 233 */     this.field_110714_j = new ModelRenderer(this, 58, 0);
/* 234 */     this.field_110714_j.func_78789_a(-1.0F, -11.5F, 5.0F, 2, 16, 4);
/* 235 */     this.field_110714_j.func_78793_a(0.0F, 4.0F, -10.0F);
/* 236 */     func_110682_a(this.field_110714_j, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 238 */     this.field_110717_i = new ModelRenderer(this, 80, 12);
/* 239 */     this.field_110717_i.func_78790_a(-2.5F, -10.1F, -7.0F, 5, 5, 12, 0.2F);
/* 240 */     this.field_110717_i.func_78793_a(0.0F, 4.0F, -10.0F);
/* 241 */     func_110682_a(this.field_110717_i, 0.5235988F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 246 */     EntityHorse entityHorse = (EntityHorse)p_78088_1_;
/*     */     
/* 248 */     int i = entityHorse.func_110265_bP();
/* 249 */     float f1 = entityHorse.func_110258_o(0.0F);
/* 250 */     boolean bool = entityHorse.func_110228_bR();
/* 251 */     boolean bool1 = (bool && entityHorse.func_110257_ck()) ? true : false;
/* 252 */     boolean bool2 = (bool && entityHorse.func_110261_ca()) ? true : false;
/* 253 */     boolean bool3 = (i == 1 || i == 2) ? true : false;
/* 254 */     float f2 = entityHorse.func_110254_bY();
/*     */     
/* 256 */     boolean bool4 = (entityHorse.field_70153_n != null) ? true : false;
/*     */     
/* 258 */     if (bool1) {
/* 259 */       this.field_110717_i.func_78785_a(p_78088_7_);
/* 260 */       this.field_110696_I.func_78785_a(p_78088_7_);
/* 261 */       this.field_110697_J.func_78785_a(p_78088_7_);
/* 262 */       this.field_110698_K.func_78785_a(p_78088_7_);
/* 263 */       this.field_110691_L.func_78785_a(p_78088_7_);
/* 264 */       this.field_110692_M.func_78785_a(p_78088_7_);
/* 265 */       this.field_110693_N.func_78785_a(p_78088_7_);
/* 266 */       this.field_110694_O.func_78785_a(p_78088_7_);
/* 267 */       this.field_110700_P.func_78785_a(p_78088_7_);
/* 268 */       this.field_110699_Q.func_78785_a(p_78088_7_);
/* 269 */       if (bool4) {
/* 270 */         this.field_110702_R.func_78785_a(p_78088_7_);
/* 271 */         this.field_110701_S.func_78785_a(p_78088_7_);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 276 */     if (!bool) {
/* 277 */       GL11.glPushMatrix();
/* 278 */       GL11.glScalef(f2, 0.5F + f2 * 0.5F, f2);
/* 279 */       GL11.glTranslatef(0.0F, 0.95F * (1.0F - f2), 0.0F);
/*     */     } 
/* 281 */     this.field_110711_o.func_78785_a(p_78088_7_);
/* 282 */     this.field_110719_v.func_78785_a(p_78088_7_);
/* 283 */     this.field_110718_w.func_78785_a(p_78088_7_);
/*     */     
/* 285 */     this.field_110722_x.func_78785_a(p_78088_7_);
/* 286 */     this.field_110721_y.func_78785_a(p_78088_7_);
/* 287 */     this.field_110720_z.func_78785_a(p_78088_7_);
/*     */     
/* 289 */     this.field_110688_A.func_78785_a(p_78088_7_);
/* 290 */     this.field_110689_B.func_78785_a(p_78088_7_);
/* 291 */     this.field_110690_C.func_78785_a(p_78088_7_);
/*     */     
/* 293 */     this.field_110684_D.func_78785_a(p_78088_7_);
/* 294 */     this.field_110685_E.func_78785_a(p_78088_7_);
/* 295 */     this.field_110686_F.func_78785_a(p_78088_7_);
/* 296 */     if (!bool) {
/* 297 */       GL11.glPopMatrix();
/*     */       
/* 299 */       GL11.glPushMatrix();
/* 300 */       GL11.glScalef(f2, f2, f2);
/* 301 */       GL11.glTranslatef(0.0F, 1.35F * (1.0F - f2), 0.0F);
/*     */     } 
/*     */     
/* 304 */     this.field_110715_k.func_78785_a(p_78088_7_);
/* 305 */     this.field_110712_l.func_78785_a(p_78088_7_);
/* 306 */     this.field_110713_m.func_78785_a(p_78088_7_);
/* 307 */     this.field_110710_n.func_78785_a(p_78088_7_);
/* 308 */     this.field_110716_h.func_78785_a(p_78088_7_);
/* 309 */     this.field_110714_j.func_78785_a(p_78088_7_);
/* 310 */     if (!bool) {
/* 311 */       GL11.glPopMatrix();
/*     */       
/* 313 */       GL11.glPushMatrix();
/* 314 */       float f = 0.5F + f2 * f2 * 0.5F;
/* 315 */       GL11.glScalef(f, f, f);
/* 316 */       if (f1 <= 0.0F) {
/* 317 */         GL11.glTranslatef(0.0F, 1.35F * (1.0F - f2), 0.0F);
/*     */       } else {
/* 319 */         GL11.glTranslatef(0.0F, 0.9F * (1.0F - f2) * f1 + 1.35F * (1.0F - f2) * (1.0F - f1), 0.15F * (1.0F - f2) * f1);
/*     */       } 
/*     */     } 
/*     */     
/* 323 */     if (bool3) {
/* 324 */       this.field_110703_f.func_78785_a(p_78088_7_);
/* 325 */       this.field_110704_g.func_78785_a(p_78088_7_);
/*     */     } else {
/* 327 */       this.field_110705_d.func_78785_a(p_78088_7_);
/* 328 */       this.field_110706_e.func_78785_a(p_78088_7_);
/*     */     } 
/* 330 */     this.field_110709_a.func_78785_a(p_78088_7_);
/* 331 */     if (!bool) {
/* 332 */       GL11.glPopMatrix();
/*     */     }
/* 334 */     if (bool2) {
/* 335 */       this.field_110687_G.func_78785_a(p_78088_7_);
/* 336 */       this.field_110695_H.func_78785_a(p_78088_7_);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_110682_a(ModelRenderer p_110682_1_, float p_110682_2_, float p_110682_3_, float p_110682_4_) {
/* 341 */     p_110682_1_.field_78795_f = p_110682_2_;
/* 342 */     p_110682_1_.field_78796_g = p_110682_3_;
/* 343 */     p_110682_1_.field_78808_h = p_110682_4_;
/*     */   }
/*     */   
/*     */   private float func_110683_a(float p_110683_1_, float p_110683_2_, float p_110683_3_) {
/* 347 */     float f = p_110683_2_ - p_110683_1_;
/* 348 */     while (f < -180.0F)
/* 349 */       f += 360.0F; 
/* 350 */     while (f >= 180.0F)
/* 351 */       f -= 360.0F; 
/* 352 */     return p_110683_1_ + p_110683_3_ * f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 357 */     super.func_78086_a(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
/*     */     
/* 359 */     float f1 = func_110683_a(p_78086_1_.field_70760_ar, p_78086_1_.field_70761_aq, p_78086_4_);
/* 360 */     float f2 = func_110683_a(p_78086_1_.field_70758_at, p_78086_1_.field_70759_as, p_78086_4_);
/* 361 */     float f3 = p_78086_1_.field_70127_C + (p_78086_1_.field_70125_A - p_78086_1_.field_70127_C) * p_78086_4_;
/* 362 */     float f4 = f2 - f1;
/*     */ 
/*     */     
/* 365 */     float f5 = f3 / 57.29578F;
/* 366 */     if (f4 > 20.0F) {
/* 367 */       f4 = 20.0F;
/*     */     }
/* 369 */     if (f4 < -20.0F) {
/* 370 */       f4 = -20.0F;
/*     */     }
/*     */     
/* 373 */     if (p_78086_3_ > 0.2F) {
/* 374 */       f5 += MathHelper.func_76134_b(p_78086_2_ * 0.4F) * 0.15F * p_78086_3_;
/*     */     }
/*     */     
/* 377 */     EntityHorse entityHorse = (EntityHorse)p_78086_1_;
/* 378 */     float f6 = entityHorse.func_110258_o(p_78086_4_);
/* 379 */     float f7 = entityHorse.func_110223_p(p_78086_4_);
/* 380 */     float f8 = 1.0F - f7;
/* 381 */     float f9 = entityHorse.func_110201_q(p_78086_4_);
/* 382 */     boolean bool1 = (entityHorse.field_110278_bp != 0) ? true : false;
/* 383 */     boolean bool = entityHorse.func_110257_ck();
/* 384 */     boolean bool2 = (entityHorse.field_70153_n != null) ? true : false;
/* 385 */     float f10 = p_78086_1_.field_70173_aa + p_78086_4_;
/*     */     
/* 387 */     float f11 = MathHelper.func_76134_b(p_78086_2_ * 0.6662F + 3.141593F);
/* 388 */     float f12 = f11 * 0.8F * p_78086_3_;
/*     */ 
/*     */     
/* 391 */     this.field_110709_a.field_78797_d = 4.0F;
/* 392 */     this.field_110709_a.field_78798_e = -10.0F;
/* 393 */     this.field_110712_l.field_78797_d = 3.0F;
/* 394 */     this.field_110713_m.field_78798_e = 14.0F;
/* 395 */     this.field_110695_H.field_78797_d = 3.0F;
/* 396 */     this.field_110695_H.field_78798_e = 10.0F;
/* 397 */     this.field_110715_k.field_78795_f = 0.0F;
/*     */ 
/*     */     
/* 400 */     this.field_110709_a.field_78795_f = 0.5235988F + f5;
/* 401 */     this.field_110709_a.field_78796_g = f4 / 57.29578F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 406 */     this.field_110709_a.field_78795_f = f7 * (0.2617994F + f5) + f6 * 2.18166F + (1.0F - Math.max(f7, f6)) * this.field_110709_a.field_78795_f;
/* 407 */     this.field_110709_a.field_78796_g = f7 * f4 / 57.29578F + (1.0F - Math.max(f7, f6)) * this.field_110709_a.field_78796_g;
/*     */     
/* 409 */     this.field_110709_a.field_78797_d = f7 * -6.0F + f6 * 11.0F + (1.0F - Math.max(f7, f6)) * this.field_110709_a.field_78797_d;
/* 410 */     this.field_110709_a.field_78798_e = f7 * -1.0F + f6 * -10.0F + (1.0F - Math.max(f7, f6)) * this.field_110709_a.field_78798_e;
/*     */     
/* 412 */     this.field_110712_l.field_78797_d = f7 * 9.0F + f8 * this.field_110712_l.field_78797_d;
/* 413 */     this.field_110713_m.field_78798_e = f7 * 18.0F + f8 * this.field_110713_m.field_78798_e;
/* 414 */     this.field_110695_H.field_78797_d = f7 * 5.5F + f8 * this.field_110695_H.field_78797_d;
/* 415 */     this.field_110695_H.field_78798_e = f7 * 15.0F + f8 * this.field_110695_H.field_78798_e;
/* 416 */     this.field_110715_k.field_78795_f = f7 * -0.7853981F + f8 * this.field_110715_k.field_78795_f;
/*     */ 
/*     */     
/* 419 */     this.field_110705_d.field_78797_d = this.field_110709_a.field_78797_d;
/* 420 */     this.field_110706_e.field_78797_d = this.field_110709_a.field_78797_d;
/* 421 */     this.field_110703_f.field_78797_d = this.field_110709_a.field_78797_d;
/* 422 */     this.field_110704_g.field_78797_d = this.field_110709_a.field_78797_d;
/* 423 */     this.field_110716_h.field_78797_d = this.field_110709_a.field_78797_d;
/* 424 */     this.field_110707_b.field_78797_d = 0.02F;
/* 425 */     this.field_110708_c.field_78797_d = 0.0F;
/* 426 */     this.field_110714_j.field_78797_d = this.field_110709_a.field_78797_d;
/*     */     
/* 428 */     this.field_110705_d.field_78798_e = this.field_110709_a.field_78798_e;
/* 429 */     this.field_110706_e.field_78798_e = this.field_110709_a.field_78798_e;
/* 430 */     this.field_110703_f.field_78798_e = this.field_110709_a.field_78798_e;
/* 431 */     this.field_110704_g.field_78798_e = this.field_110709_a.field_78798_e;
/* 432 */     this.field_110716_h.field_78798_e = this.field_110709_a.field_78798_e;
/* 433 */     this.field_110707_b.field_78798_e = 0.02F - f9 * 1.0F;
/* 434 */     this.field_110708_c.field_78798_e = 0.0F + f9 * 1.0F;
/* 435 */     this.field_110714_j.field_78798_e = this.field_110709_a.field_78798_e;
/*     */     
/* 437 */     this.field_110705_d.field_78795_f = this.field_110709_a.field_78795_f;
/* 438 */     this.field_110706_e.field_78795_f = this.field_110709_a.field_78795_f;
/* 439 */     this.field_110703_f.field_78795_f = this.field_110709_a.field_78795_f;
/* 440 */     this.field_110704_g.field_78795_f = this.field_110709_a.field_78795_f;
/* 441 */     this.field_110716_h.field_78795_f = this.field_110709_a.field_78795_f;
/* 442 */     this.field_110707_b.field_78795_f = 0.0F - 0.09424778F * f9;
/* 443 */     this.field_110708_c.field_78795_f = 0.0F + 0.15707964F * f9;
/*     */     
/* 445 */     this.field_110714_j.field_78795_f = this.field_110709_a.field_78795_f;
/*     */     
/* 447 */     this.field_110705_d.field_78796_g = this.field_110709_a.field_78796_g;
/* 448 */     this.field_110706_e.field_78796_g = this.field_110709_a.field_78796_g;
/* 449 */     this.field_110703_f.field_78796_g = this.field_110709_a.field_78796_g;
/* 450 */     this.field_110704_g.field_78796_g = this.field_110709_a.field_78796_g;
/* 451 */     this.field_110716_h.field_78796_g = this.field_110709_a.field_78796_g;
/* 452 */     this.field_110707_b.field_78796_g = 0.0F;
/* 453 */     this.field_110708_c.field_78796_g = 0.0F;
/* 454 */     this.field_110714_j.field_78796_g = this.field_110709_a.field_78796_g;
/*     */ 
/*     */     
/* 457 */     this.field_110687_G.field_78795_f = f12 / 5.0F;
/* 458 */     this.field_110695_H.field_78795_f = -f12 / 5.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 464 */     float f13 = 1.5707964F;
/* 465 */     float f14 = 4.712389F;
/* 466 */     float f15 = -1.0471976F;
/* 467 */     float f16 = 0.2617994F * f7;
/* 468 */     float f17 = MathHelper.func_76134_b(f10 * 0.6F + 3.141593F);
/*     */     
/* 470 */     this.field_110688_A.field_78797_d = -2.0F * f7 + 9.0F * f8;
/* 471 */     this.field_110688_A.field_78798_e = -2.0F * f7 + -8.0F * f8;
/* 472 */     this.field_110684_D.field_78797_d = this.field_110688_A.field_78797_d;
/* 473 */     this.field_110684_D.field_78798_e = this.field_110688_A.field_78798_e;
/*     */     
/* 475 */     this.field_110711_o.field_78797_d += MathHelper.func_76126_a(1.5707964F + f16 + f8 * -f11 * 0.5F * p_78086_3_) * 7.0F;
/* 476 */     this.field_110711_o.field_78798_e += MathHelper.func_76134_b(4.712389F + f16 + f8 * -f11 * 0.5F * p_78086_3_) * 7.0F;
/*     */     
/* 478 */     this.field_110722_x.field_78797_d += MathHelper.func_76126_a(1.5707964F + f16 + f8 * f11 * 0.5F * p_78086_3_) * 7.0F;
/* 479 */     this.field_110722_x.field_78798_e += MathHelper.func_76134_b(4.712389F + f16 + f8 * f11 * 0.5F * p_78086_3_) * 7.0F;
/*     */     
/* 481 */     float f18 = (-1.0471976F + f17) * f7 + f12 * f8;
/* 482 */     float f19 = (-1.0471976F + -f17) * f7 + -f12 * f8;
/* 483 */     this.field_110688_A.field_78797_d += MathHelper.func_76126_a(1.5707964F + f18) * 7.0F;
/* 484 */     this.field_110688_A.field_78798_e += MathHelper.func_76134_b(4.712389F + f18) * 7.0F;
/*     */     
/* 486 */     this.field_110684_D.field_78797_d += MathHelper.func_76126_a(1.5707964F + f19) * 7.0F;
/* 487 */     this.field_110684_D.field_78798_e += MathHelper.func_76134_b(4.712389F + f19) * 7.0F;
/*     */     
/* 489 */     this.field_110711_o.field_78795_f = f16 + -f11 * 0.5F * p_78086_3_ * f8;
/* 490 */     this.field_110719_v.field_78795_f = -0.08726646F * f7 + (-f11 * 0.5F * p_78086_3_ - Math.max(0.0F, f11 * 0.5F * p_78086_3_)) * f8;
/* 491 */     this.field_110718_w.field_78795_f = this.field_110719_v.field_78795_f;
/*     */     
/* 493 */     this.field_110722_x.field_78795_f = f16 + f11 * 0.5F * p_78086_3_ * f8;
/* 494 */     this.field_110721_y.field_78795_f = -0.08726646F * f7 + (f11 * 0.5F * p_78086_3_ - Math.max(0.0F, -f11 * 0.5F * p_78086_3_)) * f8;
/* 495 */     this.field_110720_z.field_78795_f = this.field_110721_y.field_78795_f;
/*     */     
/* 497 */     this.field_110688_A.field_78795_f = f18;
/* 498 */     this.field_110689_B.field_78795_f = (this.field_110688_A.field_78795_f + 3.1415927F * Math.max(0.0F, 0.2F + f17 * 0.2F)) * f7 + (f12 + Math.max(0.0F, f11 * 0.5F * p_78086_3_)) * f8;
/* 499 */     this.field_110690_C.field_78795_f = this.field_110689_B.field_78795_f;
/*     */     
/* 501 */     this.field_110684_D.field_78795_f = f19;
/* 502 */     this.field_110685_E.field_78795_f = (this.field_110684_D.field_78795_f + 3.1415927F * Math.max(0.0F, 0.2F - f17 * 0.2F)) * f7 + (-f12 + Math.max(0.0F, -f11 * 0.5F * p_78086_3_)) * f8;
/* 503 */     this.field_110686_F.field_78795_f = this.field_110685_E.field_78795_f;
/*     */ 
/*     */     
/* 506 */     this.field_110718_w.field_78797_d = this.field_110719_v.field_78797_d;
/* 507 */     this.field_110718_w.field_78798_e = this.field_110719_v.field_78798_e;
/* 508 */     this.field_110720_z.field_78797_d = this.field_110721_y.field_78797_d;
/* 509 */     this.field_110720_z.field_78798_e = this.field_110721_y.field_78798_e;
/* 510 */     this.field_110690_C.field_78797_d = this.field_110689_B.field_78797_d;
/* 511 */     this.field_110690_C.field_78798_e = this.field_110689_B.field_78798_e;
/* 512 */     this.field_110686_F.field_78797_d = this.field_110685_E.field_78797_d;
/* 513 */     this.field_110686_F.field_78798_e = this.field_110685_E.field_78798_e;
/*     */     
/* 515 */     if (bool) {
/*     */       
/* 517 */       this.field_110696_I.field_78797_d = f7 * 0.5F + f8 * 2.0F;
/* 518 */       this.field_110696_I.field_78798_e = f7 * 11.0F + f8 * 2.0F;
/*     */       
/* 520 */       this.field_110697_J.field_78797_d = this.field_110696_I.field_78797_d;
/* 521 */       this.field_110698_K.field_78797_d = this.field_110696_I.field_78797_d;
/* 522 */       this.field_110691_L.field_78797_d = this.field_110696_I.field_78797_d;
/* 523 */       this.field_110693_N.field_78797_d = this.field_110696_I.field_78797_d;
/* 524 */       this.field_110692_M.field_78797_d = this.field_110696_I.field_78797_d;
/* 525 */       this.field_110694_O.field_78797_d = this.field_110696_I.field_78797_d;
/* 526 */       this.field_110687_G.field_78797_d = this.field_110695_H.field_78797_d;
/*     */       
/* 528 */       this.field_110697_J.field_78798_e = this.field_110696_I.field_78798_e;
/* 529 */       this.field_110698_K.field_78798_e = this.field_110696_I.field_78798_e;
/* 530 */       this.field_110691_L.field_78798_e = this.field_110696_I.field_78798_e;
/* 531 */       this.field_110693_N.field_78798_e = this.field_110696_I.field_78798_e;
/* 532 */       this.field_110692_M.field_78798_e = this.field_110696_I.field_78798_e;
/* 533 */       this.field_110694_O.field_78798_e = this.field_110696_I.field_78798_e;
/* 534 */       this.field_110687_G.field_78798_e = this.field_110695_H.field_78798_e;
/*     */       
/* 536 */       this.field_110696_I.field_78795_f = this.field_110715_k.field_78795_f;
/* 537 */       this.field_110697_J.field_78795_f = this.field_110715_k.field_78795_f;
/* 538 */       this.field_110698_K.field_78795_f = this.field_110715_k.field_78795_f;
/*     */       
/* 540 */       this.field_110702_R.field_78797_d = this.field_110709_a.field_78797_d;
/* 541 */       this.field_110701_S.field_78797_d = this.field_110709_a.field_78797_d;
/* 542 */       this.field_110717_i.field_78797_d = this.field_110709_a.field_78797_d;
/* 543 */       this.field_110700_P.field_78797_d = this.field_110709_a.field_78797_d;
/* 544 */       this.field_110699_Q.field_78797_d = this.field_110709_a.field_78797_d;
/*     */       
/* 546 */       this.field_110702_R.field_78798_e = this.field_110709_a.field_78798_e;
/* 547 */       this.field_110701_S.field_78798_e = this.field_110709_a.field_78798_e;
/* 548 */       this.field_110717_i.field_78798_e = this.field_110709_a.field_78798_e;
/* 549 */       this.field_110700_P.field_78798_e = this.field_110709_a.field_78798_e;
/* 550 */       this.field_110699_Q.field_78798_e = this.field_110709_a.field_78798_e;
/*     */       
/* 552 */       this.field_110702_R.field_78795_f = f5;
/* 553 */       this.field_110701_S.field_78795_f = f5;
/* 554 */       this.field_110717_i.field_78795_f = this.field_110709_a.field_78795_f;
/* 555 */       this.field_110700_P.field_78795_f = this.field_110709_a.field_78795_f;
/* 556 */       this.field_110699_Q.field_78795_f = this.field_110709_a.field_78795_f;
/* 557 */       this.field_110717_i.field_78796_g = this.field_110709_a.field_78796_g;
/* 558 */       this.field_110700_P.field_78796_g = this.field_110709_a.field_78796_g;
/* 559 */       this.field_110702_R.field_78796_g = this.field_110709_a.field_78796_g;
/* 560 */       this.field_110699_Q.field_78796_g = this.field_110709_a.field_78796_g;
/* 561 */       this.field_110701_S.field_78796_g = this.field_110709_a.field_78796_g;
/*     */       
/* 563 */       if (bool2) {
/*     */         
/* 565 */         this.field_110691_L.field_78795_f = -1.0471976F;
/* 566 */         this.field_110692_M.field_78795_f = -1.0471976F;
/* 567 */         this.field_110693_N.field_78795_f = -1.0471976F;
/* 568 */         this.field_110694_O.field_78795_f = -1.0471976F;
/*     */         
/* 570 */         this.field_110691_L.field_78808_h = 0.0F;
/* 571 */         this.field_110692_M.field_78808_h = 0.0F;
/* 572 */         this.field_110693_N.field_78808_h = 0.0F;
/* 573 */         this.field_110694_O.field_78808_h = 0.0F;
/*     */       } else {
/* 575 */         this.field_110691_L.field_78795_f = f12 / 3.0F;
/* 576 */         this.field_110692_M.field_78795_f = f12 / 3.0F;
/* 577 */         this.field_110693_N.field_78795_f = f12 / 3.0F;
/* 578 */         this.field_110694_O.field_78795_f = f12 / 3.0F;
/*     */         
/* 580 */         this.field_110691_L.field_78808_h = f12 / 5.0F;
/* 581 */         this.field_110692_M.field_78808_h = f12 / 5.0F;
/* 582 */         this.field_110693_N.field_78808_h = -f12 / 5.0F;
/* 583 */         this.field_110694_O.field_78808_h = -f12 / 5.0F;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 588 */     f13 = -1.3089F + p_78086_3_ * 1.5F;
/* 589 */     if (f13 > 0.0F) {
/* 590 */       f13 = 0.0F;
/*     */     }
/*     */     
/* 593 */     if (bool1) {
/* 594 */       this.field_110712_l.field_78796_g = MathHelper.func_76134_b(f10 * 0.7F);
/* 595 */       f13 = 0.0F;
/*     */     } else {
/* 597 */       this.field_110712_l.field_78796_g = 0.0F;
/*     */     } 
/* 599 */     this.field_110713_m.field_78796_g = this.field_110712_l.field_78796_g;
/* 600 */     this.field_110710_n.field_78796_g = this.field_110712_l.field_78796_g;
/*     */     
/* 602 */     this.field_110713_m.field_78797_d = this.field_110712_l.field_78797_d;
/* 603 */     this.field_110710_n.field_78797_d = this.field_110712_l.field_78797_d;
/* 604 */     this.field_110713_m.field_78798_e = this.field_110712_l.field_78798_e;
/* 605 */     this.field_110710_n.field_78798_e = this.field_110712_l.field_78798_e;
/*     */ 
/*     */     
/* 608 */     this.field_110712_l.field_78795_f = f13;
/* 609 */     this.field_110713_m.field_78795_f = f13;
/* 610 */     this.field_110710_n.field_78795_f = -0.2618F + f13;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelHorse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */