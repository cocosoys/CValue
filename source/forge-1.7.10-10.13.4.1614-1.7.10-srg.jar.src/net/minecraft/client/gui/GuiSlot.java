/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class GuiSlot
/*     */ {
/*     */   private final Minecraft field_148161_k;
/*     */   public int field_148155_a;
/*     */   public int field_148158_l;
/*     */   public int field_148153_b;
/*     */   public int field_148154_c;
/*     */   public int field_148151_d;
/*     */   public int field_148152_e;
/*     */   public final int field_148149_f;
/*     */   private int field_148159_m;
/*     */   private int field_148156_n;
/*     */   protected int field_148150_g;
/*     */   protected int field_148162_h;
/*     */   protected boolean field_148163_i = true;
/*  28 */   private float field_148157_o = -2.0F;
/*     */   
/*     */   private float field_148170_p;
/*     */   private float field_148169_q;
/*  32 */   private int field_148168_r = -1;
/*     */   private long field_148167_s;
/*     */   private boolean field_148166_t = true;
/*     */   private boolean field_148165_u;
/*     */   public int field_148160_j;
/*     */   private boolean field_148164_v = true;
/*     */   private static final String __OBFID = "CL_00000679";
/*     */   
/*     */   public GuiSlot(Minecraft p_i1052_1_, int p_i1052_2_, int p_i1052_3_, int p_i1052_4_, int p_i1052_5_, int p_i1052_6_) {
/*  41 */     this.field_148161_k = p_i1052_1_;
/*  42 */     this.field_148155_a = p_i1052_2_;
/*  43 */     this.field_148158_l = p_i1052_3_;
/*  44 */     this.field_148153_b = p_i1052_4_;
/*  45 */     this.field_148154_c = p_i1052_5_;
/*  46 */     this.field_148149_f = p_i1052_6_;
/*  47 */     this.field_148152_e = 0;
/*  48 */     this.field_148151_d = p_i1052_2_;
/*     */   }
/*     */   
/*     */   public void func_148122_a(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_) {
/*  52 */     this.field_148155_a = p_148122_1_;
/*  53 */     this.field_148158_l = p_148122_2_;
/*  54 */     this.field_148153_b = p_148122_3_;
/*  55 */     this.field_148154_c = p_148122_4_;
/*  56 */     this.field_148152_e = 0;
/*  57 */     this.field_148151_d = p_148122_1_;
/*     */   }
/*     */   
/*     */   public void func_148130_a(boolean p_148130_1_) {
/*  61 */     this.field_148166_t = p_148130_1_;
/*     */   }
/*     */   
/*     */   protected void func_148133_a(boolean p_148133_1_, int p_148133_2_) {
/*  65 */     this.field_148165_u = p_148133_1_;
/*  66 */     this.field_148160_j = p_148133_2_;
/*     */     
/*  68 */     if (!p_148133_1_) {
/*  69 */       this.field_148160_j = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract int func_148127_b();
/*     */ 
/*     */   
/*     */   protected abstract void func_148144_a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
/*     */ 
/*     */   
/*     */   protected abstract boolean func_148131_a(int paramInt);
/*     */ 
/*     */   
/*     */   protected int func_148138_e() {
/*  84 */     return func_148127_b() * this.field_148149_f + this.field_148160_j;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void func_148123_a();
/*     */ 
/*     */   
/*     */   protected abstract void func_148126_a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Tessellator paramTessellator, int paramInt5, int paramInt6);
/*     */ 
/*     */   
/*     */   protected void func_148129_a(int p_148129_1_, int p_148129_2_, Tessellator p_148129_3_) {}
/*     */ 
/*     */   
/*     */   protected void func_148132_a(int p_148132_1_, int p_148132_2_) {}
/*     */   
/*     */   protected void func_148142_b(int p_148142_1_, int p_148142_2_) {}
/*     */   
/*     */   public int func_148124_c(int p_148124_1_, int p_148124_2_) {
/* 102 */     int i = this.field_148152_e + this.field_148155_a / 2 - func_148139_c() / 2;
/* 103 */     int j = this.field_148152_e + this.field_148155_a / 2 + func_148139_c() / 2;
/*     */     
/* 105 */     int k = p_148124_2_ - this.field_148153_b - this.field_148160_j + (int)this.field_148169_q - 4;
/* 106 */     int m = k / this.field_148149_f;
/* 107 */     if (p_148124_1_ < func_148137_d() && p_148124_1_ >= i && p_148124_1_ <= j && m >= 0 && k >= 0 && m < func_148127_b()) {
/* 108 */       return m;
/*     */     }
/* 110 */     return -1;
/*     */   }
/*     */   
/*     */   public void func_148134_d(int p_148134_1_, int p_148134_2_) {
/* 114 */     this.field_148159_m = p_148134_1_;
/* 115 */     this.field_148156_n = p_148134_2_;
/*     */   }
/*     */   
/*     */   private void func_148121_k() {
/* 119 */     int i = func_148135_f();
/* 120 */     if (i < 0) i /= 2; 
/* 121 */     if (!this.field_148163_i && i < 0) i = 0; 
/* 122 */     if (this.field_148169_q < 0.0F) this.field_148169_q = 0.0F; 
/* 123 */     if (this.field_148169_q > i) this.field_148169_q = i; 
/*     */   }
/*     */   
/*     */   public int func_148135_f() {
/* 127 */     return func_148138_e() - this.field_148154_c - this.field_148153_b - 4;
/*     */   }
/*     */   
/*     */   public int func_148148_g() {
/* 131 */     return (int)this.field_148169_q;
/*     */   }
/*     */   
/*     */   public boolean func_148141_e(int p_148141_1_) {
/* 135 */     return (p_148141_1_ >= this.field_148153_b && p_148141_1_ <= this.field_148154_c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_148145_f(int p_148145_1_) {
/* 143 */     this.field_148169_q += p_148145_1_;
/* 144 */     func_148121_k();
/* 145 */     this.field_148157_o = -2.0F;
/*     */   }
/*     */   
/*     */   public void func_148147_a(GuiButton p_148147_1_) {
/* 149 */     if (!p_148147_1_.field_146124_l)
/*     */       return; 
/* 151 */     if (p_148147_1_.field_146127_k == this.field_148159_m) {
/* 152 */       this.field_148169_q -= (this.field_148149_f * 2 / 3);
/* 153 */       this.field_148157_o = -2.0F;
/* 154 */       func_148121_k();
/* 155 */     } else if (p_148147_1_.field_146127_k == this.field_148156_n) {
/* 156 */       this.field_148169_q += (this.field_148149_f * 2 / 3);
/* 157 */       this.field_148157_o = -2.0F;
/* 158 */       func_148121_k();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_148128_a(int p_148128_1_, int p_148128_2_, float p_148128_3_) {
/* 163 */     this.field_148150_g = p_148128_1_;
/* 164 */     this.field_148162_h = p_148128_2_;
/* 165 */     func_148123_a();
/*     */     
/* 167 */     int i = func_148127_b();
/*     */     
/* 169 */     int j = func_148137_d();
/* 170 */     int k = j + 6;
/*     */     
/* 172 */     if (p_148128_1_ > this.field_148152_e && p_148128_1_ < this.field_148151_d && p_148128_2_ > this.field_148153_b && p_148128_2_ < this.field_148154_c) {
/* 173 */       if (Mouse.isButtonDown(0) && func_148125_i()) {
/* 174 */         if (this.field_148157_o == -1.0F) {
/* 175 */           boolean bool = true;
/* 176 */           if (p_148128_2_ >= this.field_148153_b && p_148128_2_ <= this.field_148154_c) {
/* 177 */             int i2 = this.field_148155_a / 2 - func_148139_c() / 2;
/* 178 */             int i3 = this.field_148155_a / 2 + func_148139_c() / 2;
/*     */             
/* 180 */             int i4 = p_148128_2_ - this.field_148153_b - this.field_148160_j + (int)this.field_148169_q - 4;
/* 181 */             int i5 = i4 / this.field_148149_f;
/* 182 */             if (p_148128_1_ >= i2 && p_148128_1_ <= i3 && i5 >= 0 && i4 >= 0 && i5 < i) {
/*     */               
/* 184 */               boolean bool1 = (i5 == this.field_148168_r && Minecraft.func_71386_F() - this.field_148167_s < 250L) ? true : false;
/*     */               
/* 186 */               func_148144_a(i5, bool1, p_148128_1_, p_148128_2_);
/* 187 */               this.field_148168_r = i5;
/* 188 */               this.field_148167_s = Minecraft.func_71386_F();
/* 189 */             } else if (p_148128_1_ >= i2 && p_148128_1_ <= i3 && i4 < 0) {
/* 190 */               func_148132_a(p_148128_1_ - i2, p_148128_2_ - this.field_148153_b + (int)this.field_148169_q - 4);
/* 191 */               bool = false;
/*     */             } 
/* 193 */             if (p_148128_1_ >= j && p_148128_1_ <= k) {
/* 194 */               this.field_148170_p = -1.0F;
/*     */               
/* 196 */               int i6 = func_148135_f();
/* 197 */               if (i6 < 1) i6 = 1; 
/* 198 */               int i7 = (int)(((this.field_148154_c - this.field_148153_b) * (this.field_148154_c - this.field_148153_b)) / func_148138_e());
/* 199 */               if (i7 < 32) i7 = 32; 
/* 200 */               if (i7 > this.field_148154_c - this.field_148153_b - 8) i7 = this.field_148154_c - this.field_148153_b - 8;
/*     */               
/* 202 */               this.field_148170_p /= (this.field_148154_c - this.field_148153_b - i7) / i6;
/*     */             } else {
/*     */               
/* 205 */               this.field_148170_p = 1.0F;
/*     */             } 
/* 207 */             if (bool) {
/* 208 */               this.field_148157_o = p_148128_2_;
/*     */             } else {
/* 210 */               this.field_148157_o = -2.0F;
/*     */             } 
/*     */           } else {
/* 213 */             this.field_148157_o = -2.0F;
/*     */           } 
/* 215 */         } else if (this.field_148157_o >= 0.0F) {
/* 216 */           this.field_148169_q -= (p_148128_2_ - this.field_148157_o) * this.field_148170_p;
/* 217 */           this.field_148157_o = p_148128_2_;
/*     */         } 
/*     */       } else {
/* 220 */         while (!this.field_148161_k.field_71474_y.field_85185_A && Mouse.next()) {
/* 221 */           int i2 = Mouse.getEventDWheel();
/* 222 */           if (i2 != 0) {
/* 223 */             if (i2 > 0) { i2 = -1; }
/* 224 */             else if (i2 < 0) { i2 = 1; }
/* 225 */              this.field_148169_q += (i2 * this.field_148149_f / 2);
/*     */           } 
/*     */           
/* 228 */           this.field_148161_k.field_71462_r.func_146274_d();
/*     */         } 
/*     */         
/* 231 */         this.field_148157_o = -1.0F;
/*     */       } 
/*     */     }
/*     */     
/* 235 */     func_148121_k();
/*     */     
/* 237 */     GL11.glDisable(2896);
/* 238 */     GL11.glDisable(2912);
/* 239 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 241 */     this.field_148161_k.func_110434_K().func_110577_a(Gui.field_110325_k);
/* 242 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 243 */     float f = 32.0F;
/* 244 */     tessellator.func_78382_b();
/* 245 */     tessellator.func_78378_d(2105376);
/* 246 */     tessellator.func_78374_a(this.field_148152_e, this.field_148154_c, 0.0D, (this.field_148152_e / f), ((this.field_148154_c + (int)this.field_148169_q) / f));
/* 247 */     tessellator.func_78374_a(this.field_148151_d, this.field_148154_c, 0.0D, (this.field_148151_d / f), ((this.field_148154_c + (int)this.field_148169_q) / f));
/* 248 */     tessellator.func_78374_a(this.field_148151_d, this.field_148153_b, 0.0D, (this.field_148151_d / f), ((this.field_148153_b + (int)this.field_148169_q) / f));
/* 249 */     tessellator.func_78374_a(this.field_148152_e, this.field_148153_b, 0.0D, (this.field_148152_e / f), ((this.field_148153_b + (int)this.field_148169_q) / f));
/* 250 */     tessellator.func_78381_a();
/*     */     
/* 252 */     int m = this.field_148152_e + this.field_148155_a / 2 - func_148139_c() / 2 + 2;
/* 253 */     int n = this.field_148153_b + 4 - (int)this.field_148169_q;
/*     */     
/* 255 */     if (this.field_148165_u) {
/* 256 */       func_148129_a(m, n, tessellator);
/*     */     }
/*     */     
/* 259 */     func_148120_b(m, n, p_148128_1_, p_148128_2_);
/*     */     
/* 261 */     GL11.glDisable(2929);
/*     */     
/* 263 */     byte b = 4;
/*     */     
/* 265 */     func_148136_c(0, this.field_148153_b, 255, 255);
/* 266 */     func_148136_c(this.field_148154_c, this.field_148158_l, 255, 255);
/*     */     
/* 268 */     GL11.glEnable(3042);
/* 269 */     OpenGlHelper.func_148821_a(770, 771, 0, 1);
/* 270 */     GL11.glDisable(3008);
/* 271 */     GL11.glShadeModel(7425);
/*     */     
/* 273 */     GL11.glDisable(3553);
/*     */     
/* 275 */     tessellator.func_78382_b();
/* 276 */     tessellator.func_78384_a(0, 0);
/* 277 */     tessellator.func_78374_a(this.field_148152_e, (this.field_148153_b + b), 0.0D, 0.0D, 1.0D);
/* 278 */     tessellator.func_78374_a(this.field_148151_d, (this.field_148153_b + b), 0.0D, 1.0D, 1.0D);
/* 279 */     tessellator.func_78384_a(0, 255);
/* 280 */     tessellator.func_78374_a(this.field_148151_d, this.field_148153_b, 0.0D, 1.0D, 0.0D);
/* 281 */     tessellator.func_78374_a(this.field_148152_e, this.field_148153_b, 0.0D, 0.0D, 0.0D);
/* 282 */     tessellator.func_78381_a();
/*     */     
/* 284 */     tessellator.func_78382_b();
/* 285 */     tessellator.func_78384_a(0, 255);
/* 286 */     tessellator.func_78374_a(this.field_148152_e, this.field_148154_c, 0.0D, 0.0D, 1.0D);
/* 287 */     tessellator.func_78374_a(this.field_148151_d, this.field_148154_c, 0.0D, 1.0D, 1.0D);
/* 288 */     tessellator.func_78384_a(0, 0);
/* 289 */     tessellator.func_78374_a(this.field_148151_d, (this.field_148154_c - b), 0.0D, 1.0D, 0.0D);
/* 290 */     tessellator.func_78374_a(this.field_148152_e, (this.field_148154_c - b), 0.0D, 0.0D, 0.0D);
/* 291 */     tessellator.func_78381_a();
/*     */     
/* 293 */     int i1 = func_148135_f();
/* 294 */     if (i1 > 0) {
/* 295 */       int i2 = (this.field_148154_c - this.field_148153_b) * (this.field_148154_c - this.field_148153_b) / func_148138_e();
/* 296 */       if (i2 < 32) i2 = 32; 
/* 297 */       if (i2 > this.field_148154_c - this.field_148153_b - 8) i2 = this.field_148154_c - this.field_148153_b - 8;
/*     */       
/* 299 */       int i3 = (int)this.field_148169_q * (this.field_148154_c - this.field_148153_b - i2) / i1 + this.field_148153_b;
/* 300 */       if (i3 < this.field_148153_b) i3 = this.field_148153_b;
/*     */       
/* 302 */       tessellator.func_78382_b();
/* 303 */       tessellator.func_78384_a(0, 255);
/* 304 */       tessellator.func_78374_a(j, this.field_148154_c, 0.0D, 0.0D, 1.0D);
/* 305 */       tessellator.func_78374_a(k, this.field_148154_c, 0.0D, 1.0D, 1.0D);
/* 306 */       tessellator.func_78374_a(k, this.field_148153_b, 0.0D, 1.0D, 0.0D);
/* 307 */       tessellator.func_78374_a(j, this.field_148153_b, 0.0D, 0.0D, 0.0D);
/* 308 */       tessellator.func_78381_a();
/*     */       
/* 310 */       tessellator.func_78382_b();
/* 311 */       tessellator.func_78384_a(8421504, 255);
/* 312 */       tessellator.func_78374_a(j, (i3 + i2), 0.0D, 0.0D, 1.0D);
/* 313 */       tessellator.func_78374_a(k, (i3 + i2), 0.0D, 1.0D, 1.0D);
/* 314 */       tessellator.func_78374_a(k, i3, 0.0D, 1.0D, 0.0D);
/* 315 */       tessellator.func_78374_a(j, i3, 0.0D, 0.0D, 0.0D);
/* 316 */       tessellator.func_78381_a();
/*     */       
/* 318 */       tessellator.func_78382_b();
/* 319 */       tessellator.func_78384_a(12632256, 255);
/* 320 */       tessellator.func_78374_a(j, (i3 + i2 - 1), 0.0D, 0.0D, 1.0D);
/* 321 */       tessellator.func_78374_a((k - 1), (i3 + i2 - 1), 0.0D, 1.0D, 1.0D);
/* 322 */       tessellator.func_78374_a((k - 1), i3, 0.0D, 1.0D, 0.0D);
/* 323 */       tessellator.func_78374_a(j, i3, 0.0D, 0.0D, 0.0D);
/* 324 */       tessellator.func_78381_a();
/*     */     } 
/*     */     
/* 327 */     func_148142_b(p_148128_1_, p_148128_2_);
/*     */     
/* 329 */     GL11.glEnable(3553);
/*     */     
/* 331 */     GL11.glShadeModel(7424);
/* 332 */     GL11.glEnable(3008);
/* 333 */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   public void func_148143_b(boolean p_148143_1_) {
/* 337 */     this.field_148164_v = p_148143_1_;
/*     */   }
/*     */   
/*     */   public boolean func_148125_i() {
/* 341 */     return this.field_148164_v;
/*     */   }
/*     */   
/*     */   public int func_148139_c() {
/* 345 */     return 220;
/*     */   }
/*     */   
/*     */   protected void func_148120_b(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_) {
/* 349 */     int i = func_148127_b();
/* 350 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 352 */     for (byte b = 0; b < i; b++) {
/* 353 */       int j = p_148120_2_ + b * this.field_148149_f + this.field_148160_j;
/* 354 */       int k = this.field_148149_f - 4;
/*     */       
/* 356 */       if (j <= this.field_148154_c && j + k >= this.field_148153_b) {
/*     */ 
/*     */ 
/*     */         
/* 360 */         if (this.field_148166_t && func_148131_a(b)) {
/* 361 */           int m = this.field_148152_e + this.field_148155_a / 2 - func_148139_c() / 2;
/* 362 */           int n = this.field_148152_e + this.field_148155_a / 2 + func_148139_c() / 2;
/* 363 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 364 */           GL11.glDisable(3553);
/* 365 */           tessellator.func_78382_b();
/* 366 */           tessellator.func_78378_d(8421504);
/* 367 */           tessellator.func_78374_a(m, (j + k + 2), 0.0D, 0.0D, 1.0D);
/* 368 */           tessellator.func_78374_a(n, (j + k + 2), 0.0D, 1.0D, 1.0D);
/* 369 */           tessellator.func_78374_a(n, (j - 2), 0.0D, 1.0D, 0.0D);
/* 370 */           tessellator.func_78374_a(m, (j - 2), 0.0D, 0.0D, 0.0D);
/*     */           
/* 372 */           tessellator.func_78378_d(0);
/* 373 */           tessellator.func_78374_a((m + 1), (j + k + 1), 0.0D, 0.0D, 1.0D);
/* 374 */           tessellator.func_78374_a((n - 1), (j + k + 1), 0.0D, 1.0D, 1.0D);
/* 375 */           tessellator.func_78374_a((n - 1), (j - 1), 0.0D, 1.0D, 0.0D);
/* 376 */           tessellator.func_78374_a((m + 1), (j - 1), 0.0D, 0.0D, 0.0D);
/*     */           
/* 378 */           tessellator.func_78381_a();
/* 379 */           GL11.glEnable(3553);
/*     */         } 
/*     */         
/* 382 */         func_148126_a(b, p_148120_1_, j, k, tessellator, p_148120_3_, p_148120_4_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   protected int func_148137_d() {
/* 387 */     return this.field_148155_a / 2 + 124;
/*     */   }
/*     */   
/*     */   private void func_148136_c(int p_148136_1_, int p_148136_2_, int p_148136_3_, int p_148136_4_) {
/* 391 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 392 */     this.field_148161_k.func_110434_K().func_110577_a(Gui.field_110325_k);
/* 393 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 394 */     float f = 32.0F;
/* 395 */     tessellator.func_78382_b();
/* 396 */     tessellator.func_78384_a(4210752, p_148136_4_);
/* 397 */     tessellator.func_78374_a(this.field_148152_e, p_148136_2_, 0.0D, 0.0D, (p_148136_2_ / f));
/* 398 */     tessellator.func_78374_a((this.field_148152_e + this.field_148155_a), p_148136_2_, 0.0D, (this.field_148155_a / f), (p_148136_2_ / f));
/* 399 */     tessellator.func_78384_a(4210752, p_148136_3_);
/* 400 */     tessellator.func_78374_a((this.field_148152_e + this.field_148155_a), p_148136_1_, 0.0D, (this.field_148155_a / f), (p_148136_1_ / f));
/* 401 */     tessellator.func_78374_a(this.field_148152_e, p_148136_1_, 0.0D, 0.0D, (p_148136_1_ / f));
/* 402 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void func_148140_g(int p_148140_1_) {
/* 406 */     this.field_148152_e = p_148140_1_;
/* 407 */     this.field_148151_d = p_148140_1_ + this.field_148155_a;
/*     */   }
/*     */   
/*     */   public int func_148146_j() {
/* 411 */     return this.field_148149_f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */