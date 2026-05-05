/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiTextField
/*     */   extends Gui
/*     */ {
/*     */   private final FontRenderer field_146211_a;
/*     */   public int field_146209_f;
/*     */   public int field_146210_g;
/*     */   public int field_146218_h;
/*     */   public int field_146219_i;
/*  31 */   private String field_146216_j = "";
/*  32 */   private int field_146217_k = 32;
/*     */   private int field_146214_l;
/*     */   private boolean field_146215_m = true;
/*     */   private boolean field_146212_n = true;
/*     */   private boolean field_146213_o;
/*     */   private boolean field_146226_p = true;
/*     */   private int field_146225_q;
/*     */   private int field_146224_r;
/*     */   private int field_146223_s;
/*  41 */   private int field_146222_t = 14737632;
/*  42 */   private int field_146221_u = 7368816;
/*     */   private boolean field_146220_v = true;
/*     */   
/*     */   public GuiTextField(FontRenderer p_i1032_1_, int p_i1032_2_, int p_i1032_3_, int p_i1032_4_, int p_i1032_5_) {
/*  46 */     this.field_146211_a = p_i1032_1_;
/*  47 */     this.field_146209_f = p_i1032_2_;
/*  48 */     this.field_146210_g = p_i1032_3_;
/*  49 */     this.field_146218_h = p_i1032_4_;
/*  50 */     this.field_146219_i = p_i1032_5_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000670";
/*     */   public void func_146178_a() {
/*  54 */     this.field_146214_l++;
/*     */   }
/*     */   
/*     */   public void func_146180_a(String p_146180_1_) {
/*  58 */     if (p_146180_1_.length() > this.field_146217_k) {
/*  59 */       this.field_146216_j = p_146180_1_.substring(0, this.field_146217_k);
/*     */     } else {
/*  61 */       this.field_146216_j = p_146180_1_;
/*     */     } 
/*     */     
/*  64 */     func_146202_e();
/*     */   }
/*     */   
/*     */   public String func_146179_b() {
/*  68 */     return this.field_146216_j;
/*     */   }
/*     */   
/*     */   public String func_146207_c() {
/*  72 */     int i = (this.field_146224_r < this.field_146223_s) ? this.field_146224_r : this.field_146223_s;
/*  73 */     int j = (this.field_146224_r < this.field_146223_s) ? this.field_146223_s : this.field_146224_r;
/*     */     
/*  75 */     return this.field_146216_j.substring(i, j);
/*     */   }
/*     */   
/*     */   public void func_146191_b(String p_146191_1_) {
/*  79 */     String str1 = "";
/*  80 */     String str2 = ChatAllowedCharacters.func_71565_a(p_146191_1_);
/*  81 */     int i = (this.field_146224_r < this.field_146223_s) ? this.field_146224_r : this.field_146223_s;
/*  82 */     int j = (this.field_146224_r < this.field_146223_s) ? this.field_146223_s : this.field_146224_r;
/*  83 */     int k = this.field_146217_k - this.field_146216_j.length() - i - this.field_146223_s;
/*  84 */     int m = 0;
/*     */     
/*  86 */     if (this.field_146216_j.length() > 0) str1 = str1 + this.field_146216_j.substring(0, i);
/*     */     
/*  88 */     if (k < str2.length()) {
/*  89 */       str1 = str1 + str2.substring(0, k);
/*  90 */       m = k;
/*     */     } else {
/*  92 */       str1 = str1 + str2;
/*  93 */       m = str2.length();
/*     */     } 
/*     */     
/*  96 */     if (this.field_146216_j.length() > 0 && j < this.field_146216_j.length()) str1 = str1 + this.field_146216_j.substring(j);
/*     */     
/*  98 */     this.field_146216_j = str1;
/*  99 */     func_146182_d(i - this.field_146223_s + m);
/*     */   }
/*     */   
/*     */   public void func_146177_a(int p_146177_1_) {
/* 103 */     if (this.field_146216_j.length() == 0)
/*     */       return; 
/* 105 */     if (this.field_146223_s != this.field_146224_r) {
/* 106 */       func_146191_b("");
/*     */       
/*     */       return;
/*     */     } 
/* 110 */     func_146175_b(func_146187_c(p_146177_1_) - this.field_146224_r);
/*     */   }
/*     */   
/*     */   public void func_146175_b(int p_146175_1_) {
/* 114 */     if (this.field_146216_j.length() == 0)
/*     */       return; 
/* 116 */     if (this.field_146223_s != this.field_146224_r) {
/* 117 */       func_146191_b("");
/*     */       
/*     */       return;
/*     */     } 
/* 121 */     boolean bool = (p_146175_1_ < 0) ? true : false;
/* 122 */     int i = bool ? (this.field_146224_r + p_146175_1_) : this.field_146224_r;
/* 123 */     int j = bool ? this.field_146224_r : (this.field_146224_r + p_146175_1_);
/* 124 */     String str = "";
/*     */     
/* 126 */     if (i >= 0) str = this.field_146216_j.substring(0, i);
/*     */     
/* 128 */     if (j < this.field_146216_j.length()) str = str + this.field_146216_j.substring(j);
/*     */     
/* 130 */     this.field_146216_j = str;
/* 131 */     if (bool) func_146182_d(p_146175_1_); 
/*     */   }
/*     */   
/*     */   public int func_146187_c(int p_146187_1_) {
/* 135 */     return func_146183_a(p_146187_1_, func_146198_h());
/*     */   }
/*     */   
/*     */   public int func_146183_a(int p_146183_1_, int p_146183_2_) {
/* 139 */     return func_146197_a(p_146183_1_, func_146198_h(), true);
/*     */   }
/*     */   
/*     */   public int func_146197_a(int p_146197_1_, int p_146197_2_, boolean p_146197_3_) {
/* 143 */     int i = p_146197_2_;
/* 144 */     boolean bool = (p_146197_1_ < 0) ? true : false;
/* 145 */     int j = Math.abs(p_146197_1_);
/*     */     
/* 147 */     for (byte b = 0; b < j; b++) {
/* 148 */       if (bool) {
/* 149 */         while (p_146197_3_ && i > 0 && this.field_146216_j.charAt(i - 1) == ' ')
/* 150 */           i--; 
/* 151 */         while (i > 0 && this.field_146216_j.charAt(i - 1) != ' ')
/* 152 */           i--; 
/*     */       } else {
/* 154 */         int k = this.field_146216_j.length();
/*     */         
/* 156 */         i = this.field_146216_j.indexOf(' ', i);
/* 157 */         if (i == -1) {
/* 158 */           i = k;
/*     */         } else {
/* 160 */           while (p_146197_3_ && i < k && this.field_146216_j.charAt(i) == ' ') {
/* 161 */             i++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 166 */     return i;
/*     */   }
/*     */   
/*     */   public void func_146182_d(int p_146182_1_) {
/* 170 */     func_146190_e(this.field_146223_s + p_146182_1_);
/*     */   }
/*     */   
/*     */   public void func_146190_e(int p_146190_1_) {
/* 174 */     this.field_146224_r = p_146190_1_;
/*     */     
/* 176 */     int i = this.field_146216_j.length();
/* 177 */     if (this.field_146224_r < 0) this.field_146224_r = 0; 
/* 178 */     if (this.field_146224_r > i) this.field_146224_r = i;
/*     */     
/* 180 */     func_146199_i(this.field_146224_r);
/*     */   }
/*     */   
/*     */   public void func_146196_d() {
/* 184 */     func_146190_e(0);
/*     */   }
/*     */   
/*     */   public void func_146202_e() {
/* 188 */     func_146190_e(this.field_146216_j.length());
/*     */   }
/*     */   
/*     */   public boolean func_146201_a(char p_146201_1_, int p_146201_2_) {
/* 192 */     if (!this.field_146213_o) {
/* 193 */       return false;
/*     */     }
/*     */     
/* 196 */     switch (p_146201_1_) {
/*     */       case '\001':
/* 198 */         func_146202_e();
/* 199 */         func_146199_i(0);
/* 200 */         return true;
/*     */       case '\003':
/* 202 */         GuiScreen.func_146275_d(func_146207_c());
/* 203 */         return true;
/*     */       case '\026':
/* 205 */         if (this.field_146226_p) func_146191_b(GuiScreen.func_146277_j()); 
/* 206 */         return true;
/*     */       case '\030':
/* 208 */         GuiScreen.func_146275_d(func_146207_c());
/* 209 */         if (this.field_146226_p) func_146191_b(""); 
/* 210 */         return true;
/*     */     } 
/*     */     
/* 213 */     switch (p_146201_2_) {
/*     */       case 203:
/* 215 */         if (GuiScreen.func_146272_n()) {
/* 216 */           if (GuiScreen.func_146271_m()) {
/* 217 */             func_146199_i(func_146183_a(-1, func_146186_n()));
/*     */           } else {
/* 219 */             func_146199_i(func_146186_n() - 1);
/*     */           }
/*     */         
/* 222 */         } else if (GuiScreen.func_146271_m()) {
/* 223 */           func_146190_e(func_146187_c(-1));
/*     */         } else {
/* 225 */           func_146182_d(-1);
/*     */         } 
/*     */ 
/*     */         
/* 229 */         return true;
/*     */       case 205:
/* 231 */         if (GuiScreen.func_146272_n()) {
/* 232 */           if (GuiScreen.func_146271_m()) {
/* 233 */             func_146199_i(func_146183_a(1, func_146186_n()));
/*     */           } else {
/* 235 */             func_146199_i(func_146186_n() + 1);
/*     */           }
/*     */         
/* 238 */         } else if (GuiScreen.func_146271_m()) {
/* 239 */           func_146190_e(func_146187_c(1));
/*     */         } else {
/* 241 */           func_146182_d(1);
/*     */         } 
/*     */ 
/*     */         
/* 245 */         return true;
/*     */       case 14:
/* 247 */         if (GuiScreen.func_146271_m())
/* 248 */         { if (this.field_146226_p) func_146177_a(-1);
/*     */            }
/* 250 */         else if (this.field_146226_p) { func_146175_b(-1); }
/*     */ 
/*     */         
/* 253 */         return true;
/*     */       
/*     */       case 211:
/* 256 */         if (GuiScreen.func_146271_m())
/* 257 */         { if (this.field_146226_p) func_146177_a(1);
/*     */            }
/* 259 */         else if (this.field_146226_p) { func_146175_b(1); }
/*     */ 
/*     */         
/* 262 */         return true;
/*     */       
/*     */       case 199:
/* 265 */         if (GuiScreen.func_146272_n()) {
/* 266 */           func_146199_i(0);
/*     */         } else {
/* 268 */           func_146196_d();
/*     */         } 
/*     */         
/* 271 */         return true;
/*     */       
/*     */       case 207:
/* 274 */         if (GuiScreen.func_146272_n()) {
/* 275 */           func_146199_i(this.field_146216_j.length());
/*     */         } else {
/* 277 */           func_146202_e();
/*     */         } 
/*     */         
/* 280 */         return true;
/*     */     } 
/*     */     
/* 283 */     if (ChatAllowedCharacters.func_71566_a(p_146201_1_)) {
/* 284 */       if (this.field_146226_p) func_146191_b(Character.toString(p_146201_1_));
/*     */       
/* 286 */       return true;
/*     */     } 
/*     */     
/* 289 */     return false;
/*     */   }
/*     */   
/*     */   public void func_146192_a(int p_146192_1_, int p_146192_2_, int p_146192_3_) {
/* 293 */     boolean bool = (p_146192_1_ >= this.field_146209_f && p_146192_1_ < this.field_146209_f + this.field_146218_h && p_146192_2_ >= this.field_146210_g && p_146192_2_ < this.field_146210_g + this.field_146219_i) ? true : false;
/*     */     
/* 295 */     if (this.field_146212_n) {
/* 296 */       func_146195_b(bool);
/*     */     }
/*     */     
/* 299 */     if (this.field_146213_o && p_146192_3_ == 0) {
/* 300 */       int i = p_146192_1_ - this.field_146209_f;
/*     */       
/* 302 */       if (this.field_146215_m) {
/* 303 */         i -= 4;
/*     */       }
/*     */       
/* 306 */       String str = this.field_146211_a.func_78269_a(this.field_146216_j.substring(this.field_146225_q), func_146200_o());
/* 307 */       func_146190_e(this.field_146211_a.func_78269_a(str, i).length() + this.field_146225_q);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146194_f() {
/* 312 */     if (!func_146176_q())
/*     */       return; 
/* 314 */     if (func_146181_i()) {
/* 315 */       func_73734_a(this.field_146209_f - 1, this.field_146210_g - 1, this.field_146209_f + this.field_146218_h + 1, this.field_146210_g + this.field_146219_i + 1, -6250336);
/* 316 */       func_73734_a(this.field_146209_f, this.field_146210_g, this.field_146209_f + this.field_146218_h, this.field_146210_g + this.field_146219_i, -16777216);
/*     */     } 
/*     */     
/* 319 */     int i = this.field_146226_p ? this.field_146222_t : this.field_146221_u;
/* 320 */     int j = this.field_146224_r - this.field_146225_q;
/* 321 */     int k = this.field_146223_s - this.field_146225_q;
/* 322 */     String str = this.field_146211_a.func_78269_a(this.field_146216_j.substring(this.field_146225_q), func_146200_o());
/* 323 */     boolean bool1 = (j >= 0 && j <= str.length()) ? true : false;
/* 324 */     boolean bool2 = (this.field_146213_o && this.field_146214_l / 6 % 2 == 0 && bool1) ? true : false;
/* 325 */     int m = this.field_146215_m ? (this.field_146209_f + 4) : this.field_146209_f;
/* 326 */     int n = this.field_146215_m ? (this.field_146210_g + (this.field_146219_i - 8) / 2) : this.field_146210_g;
/* 327 */     int i1 = m;
/*     */     
/* 329 */     if (k > str.length()) k = str.length();
/*     */     
/* 331 */     if (str.length() > 0) {
/* 332 */       String str1 = bool1 ? str.substring(0, j) : str;
/* 333 */       i1 = this.field_146211_a.func_78261_a(str1, i1, n, i);
/*     */     } 
/*     */     
/* 336 */     boolean bool3 = (this.field_146224_r < this.field_146216_j.length() || this.field_146216_j.length() >= func_146208_g()) ? true : false;
/* 337 */     int i2 = i1;
/*     */     
/* 339 */     if (!bool1) {
/* 340 */       i2 = (j > 0) ? (m + this.field_146218_h) : m;
/* 341 */     } else if (bool3) {
/* 342 */       i2--;
/* 343 */       i1--;
/*     */     } 
/*     */     
/* 346 */     if (str.length() > 0 && bool1 && j < str.length()) {
/* 347 */       i1 = this.field_146211_a.func_78261_a(str.substring(j), i1, n, i);
/*     */     }
/*     */     
/* 350 */     if (bool2) {
/* 351 */       if (bool3) {
/* 352 */         Gui.func_73734_a(i2, n - 1, i2 + 1, n + 1 + this.field_146211_a.field_78288_b, -3092272);
/*     */       } else {
/* 354 */         this.field_146211_a.func_78261_a("_", i2, n, i);
/*     */       } 
/*     */     }
/*     */     
/* 358 */     if (k != j) {
/* 359 */       int i3 = m + this.field_146211_a.func_78256_a(str.substring(0, k));
/* 360 */       func_146188_c(i2, n - 1, i3 - 1, n + 1 + this.field_146211_a.field_78288_b);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146188_c(int p_146188_1_, int p_146188_2_, int p_146188_3_, int p_146188_4_) {
/* 365 */     if (p_146188_1_ < p_146188_3_) {
/* 366 */       int i = p_146188_1_;
/* 367 */       p_146188_1_ = p_146188_3_;
/* 368 */       p_146188_3_ = i;
/*     */     } 
/* 370 */     if (p_146188_2_ < p_146188_4_) {
/* 371 */       int i = p_146188_2_;
/* 372 */       p_146188_2_ = p_146188_4_;
/* 373 */       p_146188_4_ = i;
/*     */     } 
/*     */     
/* 376 */     if (p_146188_3_ > this.field_146209_f + this.field_146218_h) p_146188_3_ = this.field_146209_f + this.field_146218_h; 
/* 377 */     if (p_146188_1_ > this.field_146209_f + this.field_146218_h) p_146188_1_ = this.field_146209_f + this.field_146218_h;
/*     */     
/* 379 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 381 */     GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
/* 382 */     GL11.glDisable(3553);
/* 383 */     GL11.glEnable(3058);
/* 384 */     GL11.glLogicOp(5387);
/*     */     
/* 386 */     tessellator.func_78382_b();
/* 387 */     tessellator.func_78377_a(p_146188_1_, p_146188_4_, 0.0D);
/* 388 */     tessellator.func_78377_a(p_146188_3_, p_146188_4_, 0.0D);
/* 389 */     tessellator.func_78377_a(p_146188_3_, p_146188_2_, 0.0D);
/* 390 */     tessellator.func_78377_a(p_146188_1_, p_146188_2_, 0.0D);
/* 391 */     tessellator.func_78381_a();
/*     */     
/* 393 */     GL11.glDisable(3058);
/* 394 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public void func_146203_f(int p_146203_1_) {
/* 398 */     this.field_146217_k = p_146203_1_;
/*     */     
/* 400 */     if (this.field_146216_j.length() > p_146203_1_) {
/* 401 */       this.field_146216_j = this.field_146216_j.substring(0, p_146203_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_146208_g() {
/* 406 */     return this.field_146217_k;
/*     */   }
/*     */   
/*     */   public int func_146198_h() {
/* 410 */     return this.field_146224_r;
/*     */   }
/*     */   
/*     */   public boolean func_146181_i() {
/* 414 */     return this.field_146215_m;
/*     */   }
/*     */   
/*     */   public void func_146185_a(boolean p_146185_1_) {
/* 418 */     this.field_146215_m = p_146185_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146193_g(int p_146193_1_) {
/* 426 */     this.field_146222_t = p_146193_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146204_h(int p_146204_1_) {
/* 434 */     this.field_146221_u = p_146204_1_;
/*     */   }
/*     */   
/*     */   public void func_146195_b(boolean p_146195_1_) {
/* 438 */     if (p_146195_1_ && !this.field_146213_o)
/*     */     {
/* 440 */       this.field_146214_l = 0;
/*     */     }
/* 442 */     this.field_146213_o = p_146195_1_;
/*     */   }
/*     */   
/*     */   public boolean func_146206_l() {
/* 446 */     return this.field_146213_o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146184_c(boolean p_146184_1_) {
/* 454 */     this.field_146226_p = p_146184_1_;
/*     */   }
/*     */   
/*     */   public int func_146186_n() {
/* 458 */     return this.field_146223_s;
/*     */   }
/*     */   
/*     */   public int func_146200_o() {
/* 462 */     return func_146181_i() ? (this.field_146218_h - 8) : this.field_146218_h;
/*     */   }
/*     */   
/*     */   public void func_146199_i(int p_146199_1_) {
/* 466 */     int i = this.field_146216_j.length();
/*     */     
/* 468 */     if (p_146199_1_ > i) p_146199_1_ = i; 
/* 469 */     if (p_146199_1_ < 0) p_146199_1_ = 0;
/*     */     
/* 471 */     this.field_146223_s = p_146199_1_;
/*     */     
/* 473 */     if (this.field_146211_a != null) {
/* 474 */       if (this.field_146225_q > i) this.field_146225_q = i; 
/* 475 */       int j = func_146200_o();
/* 476 */       String str = this.field_146211_a.func_78269_a(this.field_146216_j.substring(this.field_146225_q), j);
/* 477 */       int k = str.length() + this.field_146225_q;
/*     */       
/* 479 */       if (p_146199_1_ == this.field_146225_q) {
/* 480 */         this.field_146225_q -= this.field_146211_a.func_78262_a(this.field_146216_j, j, true).length();
/*     */       }
/* 482 */       if (p_146199_1_ > k) {
/* 483 */         this.field_146225_q += p_146199_1_ - k;
/* 484 */       } else if (p_146199_1_ <= this.field_146225_q) {
/* 485 */         this.field_146225_q -= this.field_146225_q - p_146199_1_;
/*     */       } 
/*     */       
/* 488 */       if (this.field_146225_q < 0) this.field_146225_q = 0; 
/* 489 */       if (this.field_146225_q > i) this.field_146225_q = i;
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146205_d(boolean p_146205_1_) {
/* 498 */     this.field_146212_n = p_146205_1_;
/*     */   }
/*     */   
/*     */   public boolean func_146176_q() {
/* 502 */     return this.field_146220_v;
/*     */   }
/*     */   
/*     */   public void func_146189_e(boolean p_146189_1_) {
/* 506 */     this.field_146220_v = p_146189_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiTextField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */