/*     */ package net.minecraft.client.renderer.texture;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.client.resources.data.AnimationFrame;
/*     */ import net.minecraft.client.resources.data.AnimationMetadataSection;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.ReportedException;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TextureAtlasSprite implements IIcon {
/*  20 */   protected List field_110976_a = Lists.newArrayList();
/*     */   
/*     */   private final String field_110984_i;
/*     */   private AnimationMetadataSection field_110982_k;
/*     */   protected boolean field_130222_e;
/*     */   private boolean field_147966_k;
/*     */   protected int field_110975_c;
/*     */   protected int field_110974_d;
/*     */   protected int field_130223_c;
/*     */   protected int field_130224_d;
/*     */   private float field_110979_l;
/*     */   private float field_110980_m;
/*     */   private float field_110977_n;
/*     */   private float field_110978_o;
/*     */   protected int field_110973_g;
/*     */   protected int field_110983_h;
/*     */   private static final String __OBFID = "CL_00001062";
/*     */   
/*     */   protected TextureAtlasSprite(String p_i1282_1_) {
/*  39 */     this.field_110984_i = p_i1282_1_;
/*     */   }
/*     */   
/*     */   public void func_110971_a(int p_110971_1_, int p_110971_2_, int p_110971_3_, int p_110971_4_, boolean p_110971_5_) {
/*  43 */     this.field_110975_c = p_110971_3_;
/*  44 */     this.field_110974_d = p_110971_4_;
/*  45 */     this.field_130222_e = p_110971_5_;
/*     */     
/*  47 */     float f1 = (float)(0.009999999776482582D / p_110971_1_);
/*  48 */     float f2 = (float)(0.009999999776482582D / p_110971_2_);
/*     */     
/*  50 */     this.field_110979_l = p_110971_3_ / (float)p_110971_1_ + f1;
/*  51 */     this.field_110980_m = (p_110971_3_ + this.field_130223_c) / (float)p_110971_1_ - f1;
/*  52 */     this.field_110977_n = p_110971_4_ / p_110971_2_ + f2;
/*  53 */     this.field_110978_o = (p_110971_4_ + this.field_130224_d) / p_110971_2_ - f2;
/*     */ 
/*     */     
/*  56 */     if (this.field_147966_k) {
/*  57 */       float f3 = 8.0F / p_110971_1_;
/*  58 */       float f4 = 8.0F / p_110971_2_;
/*     */       
/*  60 */       this.field_110979_l += f3;
/*  61 */       this.field_110980_m -= f3;
/*  62 */       this.field_110977_n += f4;
/*  63 */       this.field_110978_o -= f4;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_94217_a(TextureAtlasSprite p_94217_1_) {
/*  68 */     this.field_110975_c = p_94217_1_.field_110975_c;
/*  69 */     this.field_110974_d = p_94217_1_.field_110974_d;
/*     */     
/*  71 */     this.field_130223_c = p_94217_1_.field_130223_c;
/*  72 */     this.field_130224_d = p_94217_1_.field_130224_d;
/*     */     
/*  74 */     this.field_130222_e = p_94217_1_.field_130222_e;
/*     */     
/*  76 */     this.field_110979_l = p_94217_1_.field_110979_l;
/*  77 */     this.field_110980_m = p_94217_1_.field_110980_m;
/*  78 */     this.field_110977_n = p_94217_1_.field_110977_n;
/*  79 */     this.field_110978_o = p_94217_1_.field_110978_o;
/*     */   }
/*     */   
/*     */   public int func_130010_a() {
/*  83 */     return this.field_110975_c;
/*     */   }
/*     */   
/*     */   public int func_110967_i() {
/*  87 */     return this.field_110974_d;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_94211_a() {
/*  92 */     return this.field_130223_c;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_94216_b() {
/*  97 */     return this.field_130224_d;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_94209_e() {
/* 102 */     return this.field_110979_l;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_94212_f() {
/* 107 */     return this.field_110980_m;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_94214_a(double p_94214_1_) {
/* 112 */     float f = this.field_110980_m - this.field_110979_l;
/* 113 */     return this.field_110979_l + f * (float)p_94214_1_ / 16.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_94206_g() {
/* 118 */     return this.field_110977_n;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_94210_h() {
/* 123 */     return this.field_110978_o;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_94207_b(double p_94207_1_) {
/* 128 */     float f = this.field_110978_o - this.field_110977_n;
/* 129 */     return this.field_110977_n + f * (float)p_94207_1_ / 16.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_94215_i() {
/* 134 */     return this.field_110984_i;
/*     */   }
/*     */   
/*     */   public void func_94219_l() {
/* 138 */     this.field_110983_h++;
/* 139 */     if (this.field_110983_h >= this.field_110982_k.func_110472_a(this.field_110973_g)) {
/* 140 */       int i = this.field_110982_k.func_110468_c(this.field_110973_g);
/* 141 */       int j = (this.field_110982_k.func_110473_c() == 0) ? this.field_110976_a.size() : this.field_110982_k.func_110473_c();
/* 142 */       this.field_110973_g = (this.field_110973_g + 1) % j;
/* 143 */       this.field_110983_h = 0;
/*     */       
/* 145 */       int k = this.field_110982_k.func_110468_c(this.field_110973_g);
/* 146 */       if (i != k && k >= 0 && k < this.field_110976_a.size()) {
/* 147 */         TextureUtil.func_147955_a(this.field_110976_a.get(k), this.field_130223_c, this.field_130224_d, this.field_110975_c, this.field_110974_d, false, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public int[][] func_147965_a(int p_147965_1_) {
/* 153 */     return this.field_110976_a.get(p_147965_1_);
/*     */   }
/*     */   
/*     */   public int func_110970_k() {
/* 157 */     return this.field_110976_a.size();
/*     */   }
/*     */   
/*     */   public void func_110966_b(int p_110966_1_) {
/* 161 */     this.field_130223_c = p_110966_1_;
/*     */   }
/*     */   
/*     */   public void func_110969_c(int p_110969_1_) {
/* 165 */     this.field_130224_d = p_110969_1_;
/*     */   }
/*     */   
/*     */   public void func_147964_a(BufferedImage[] p_147964_1_, AnimationMetadataSection p_147964_2_, boolean p_147964_3_) {
/* 169 */     func_130102_n();
/*     */     
/* 171 */     this.field_147966_k = p_147964_3_;
/*     */     
/* 173 */     int i = p_147964_1_[0].getWidth();
/* 174 */     int j = p_147964_1_[0].getHeight();
/*     */     
/* 176 */     this.field_130223_c = i;
/* 177 */     this.field_130224_d = j;
/*     */     
/* 179 */     if (p_147964_3_) {
/* 180 */       this.field_130223_c += 16;
/* 181 */       this.field_130224_d += 16;
/*     */     } 
/*     */ 
/*     */     
/* 185 */     int[][] arrayOfInt = new int[p_147964_1_.length][]; int k;
/* 186 */     for (k = 0; k < p_147964_1_.length; k++) {
/* 187 */       BufferedImage bufferedImage = p_147964_1_[k];
/*     */ 
/*     */       
/* 190 */       if (bufferedImage != null) {
/*     */         
/* 192 */         if (k > 0 && (bufferedImage.getWidth() != i >> k || bufferedImage.getHeight() != j >> k)) {
/* 193 */           throw new RuntimeException(String.format("Unable to load miplevel: %d, image is size: %dx%d, expected %dx%d", new Object[] { Integer.valueOf(k), Integer.valueOf(bufferedImage.getWidth()), Integer.valueOf(bufferedImage.getHeight()), Integer.valueOf(i >> k), Integer.valueOf(j >> k) }));
/*     */         }
/*     */         
/* 196 */         arrayOfInt[k] = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
/* 197 */         bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), arrayOfInt[k], 0, bufferedImage.getWidth());
/*     */       } 
/*     */     } 
/* 200 */     if (p_147964_2_ == null) {
/* 201 */       if (j != i) {
/* 202 */         throw new RuntimeException("broken aspect ratio and not an animation");
/*     */       }
/*     */       
/* 205 */       func_147961_a(arrayOfInt);
/* 206 */       this.field_110976_a.add(func_147960_a(arrayOfInt, i, j));
/*     */     } else {
/* 208 */       k = j / i;
/* 209 */       int m = i;
/* 210 */       int n = i;
/* 211 */       this.field_130224_d = this.field_130223_c;
/*     */       
/* 213 */       if (p_147964_2_.func_110473_c() > 0) {
/*     */         
/* 215 */         for (Iterator<Integer> iterator = p_147964_2_.func_130073_e().iterator(); iterator.hasNext(); ) { int i1 = ((Integer)iterator.next()).intValue();
/* 216 */           if (i1 >= k) {
/* 217 */             throw new RuntimeException("invalid frameindex " + i1);
/*     */           }
/* 219 */           func_130099_d(i1);
/* 220 */           this.field_110976_a.set(i1, func_147960_a(func_147962_a(arrayOfInt, m, n, i1), m, n)); }
/*     */         
/* 222 */         this.field_110982_k = p_147964_2_;
/*     */       } else {
/*     */         
/* 225 */         ArrayList<AnimationFrame> arrayList = Lists.newArrayList();
/*     */         
/* 227 */         for (byte b = 0; b < k; b++) {
/* 228 */           this.field_110976_a.add(func_147960_a(func_147962_a(arrayOfInt, m, n, b), m, n));
/*     */           
/* 230 */           arrayList.add(new AnimationFrame(b, -1));
/*     */         } 
/*     */         
/* 233 */         this.field_110982_k = new AnimationMetadataSection(arrayList, this.field_130223_c, this.field_130224_d, p_147964_2_.func_110469_d());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147963_d(int p_147963_1_) {
/* 239 */     ArrayList<int[][]> arrayList = Lists.newArrayList();
/*     */     
/* 241 */     for (byte b = 0; b < this.field_110976_a.size(); b++) {
/* 242 */       int[][] arrayOfInt = this.field_110976_a.get(b);
/*     */       
/* 244 */       if (arrayOfInt != null) {
/*     */         
/*     */         try {
/* 247 */           arrayList.add(TextureUtil.func_147949_a(p_147963_1_, this.field_130223_c, arrayOfInt));
/* 248 */         } catch (Throwable throwable) {
/* 249 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Generating mipmaps for frame");
/* 250 */           CrashReportCategory crashReportCategory = crashReport.func_85058_a("Frame being iterated");
/*     */           
/* 252 */           crashReportCategory.func_71507_a("Frame index", Integer.valueOf(b));
/* 253 */           crashReportCategory.func_71500_a("Frame sizes", new Callable(this, arrayOfInt) { private static final String __OBFID = "CL_00001063";
/*     */                 
/*     */                 public String call() {
/* 256 */                   StringBuilder stringBuilder = new StringBuilder();
/*     */                   
/* 258 */                   for (int[] arrayOfInt : this.field_147983_a) {
/* 259 */                     if (stringBuilder.length() > 0) stringBuilder.append(", "); 
/* 260 */                     stringBuilder.append((arrayOfInt == null) ? "null" : Integer.valueOf(arrayOfInt.length));
/*     */                   } 
/*     */                   
/* 263 */                   return stringBuilder.toString();
/*     */                 } }
/*     */             );
/*     */           
/* 267 */           throw new ReportedException(crashReport);
/*     */         } 
/*     */       }
/*     */     } 
/* 271 */     func_110968_a(arrayList);
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_147961_a(int[][] p_147961_1_) {
/* 276 */     int[] arrayOfInt = p_147961_1_[0];
/*     */     
/* 278 */     byte b1 = 0;
/* 279 */     int i = 0;
/* 280 */     int j = 0;
/* 281 */     int k = 0; byte b2;
/* 282 */     for (b2 = 0; b2 < arrayOfInt.length; b2++) {
/* 283 */       if ((arrayOfInt[b2] & 0xFF000000) != 0) {
/* 284 */         i += arrayOfInt[b2] >> 16 & 0xFF;
/* 285 */         j += arrayOfInt[b2] >> 8 & 0xFF;
/* 286 */         k += arrayOfInt[b2] >> 0 & 0xFF;
/* 287 */         b1++;
/*     */       } 
/*     */     } 
/* 290 */     if (b1 == 0) {
/*     */       return;
/*     */     }
/* 293 */     i /= b1;
/* 294 */     j /= b1;
/* 295 */     k /= b1;
/* 296 */     for (b2 = 0; b2 < arrayOfInt.length; b2++) {
/* 297 */       if ((arrayOfInt[b2] & 0xFF000000) == 0) {
/* 298 */         arrayOfInt[b2] = i << 16 | j << 8 | k;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private int[][] func_147960_a(int[][] p_147960_1_, int p_147960_2_, int p_147960_3_) {
/* 304 */     if (!this.field_147966_k) return p_147960_1_;
/*     */     
/* 306 */     int[][] arrayOfInt = new int[p_147960_1_.length][];
/*     */     
/* 308 */     for (byte b = 0; b < p_147960_1_.length; b++) {
/* 309 */       int[] arrayOfInt1 = p_147960_1_[b];
/*     */ 
/*     */       
/* 312 */       if (arrayOfInt1 != null) {
/*     */         
/* 314 */         int[] arrayOfInt2 = new int[(p_147960_2_ + 16 >> b) * (p_147960_3_ + 16 >> b)];
/* 315 */         System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
/* 316 */         arrayOfInt[b] = TextureUtil.func_147948_a(arrayOfInt2, p_147960_2_ >> b, p_147960_3_ >> b, 8 >> b);
/*     */       } 
/*     */     } 
/* 319 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   private void func_130099_d(int p_130099_1_) {
/* 323 */     if (this.field_110976_a.size() > p_130099_1_) {
/*     */       return;
/*     */     }
/*     */     
/* 327 */     for (int i = this.field_110976_a.size(); i <= p_130099_1_; i++) {
/* 328 */       this.field_110976_a.add(null);
/*     */     }
/*     */   }
/*     */   
/*     */   private static int[][] func_147962_a(int[][] p_147962_0_, int p_147962_1_, int p_147962_2_, int p_147962_3_) {
/* 333 */     int[][] arrayOfInt = new int[p_147962_0_.length][];
/*     */     
/* 335 */     for (byte b = 0; b < p_147962_0_.length; b++) {
/* 336 */       int[] arrayOfInt1 = p_147962_0_[b];
/*     */ 
/*     */       
/* 339 */       if (arrayOfInt1 != null) {
/*     */         
/* 341 */         arrayOfInt[b] = new int[(p_147962_1_ >> b) * (p_147962_2_ >> b)];
/* 342 */         System.arraycopy(arrayOfInt1, p_147962_3_ * (arrayOfInt[b]).length, arrayOfInt[b], 0, (arrayOfInt[b]).length);
/*     */       } 
/*     */     } 
/* 345 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public void func_130103_l() {
/* 349 */     this.field_110976_a.clear();
/*     */   }
/*     */   
/*     */   public boolean func_130098_m() {
/* 353 */     return (this.field_110982_k != null);
/*     */   }
/*     */   
/*     */   public void func_110968_a(List p_110968_1_) {
/* 357 */     this.field_110976_a = p_110968_1_;
/*     */   }
/*     */   
/*     */   private void func_130102_n() {
/* 361 */     this.field_110982_k = null;
/* 362 */     func_110968_a(Lists.newArrayList());
/* 363 */     this.field_110973_g = 0;
/* 364 */     this.field_110983_h = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 369 */     return "TextureAtlasSprite{name='" + this.field_110984_i + '\'' + ", frameCount=" + this.field_110976_a.size() + ", rotated=" + this.field_130222_e + ", x=" + this.field_110975_c + ", y=" + this.field_110974_d + ", height=" + this.field_130224_d + ", width=" + this.field_130223_c + ", u0=" + this.field_110979_l + ", u1=" + this.field_110980_m + ", v0=" + this.field_110977_n + ", v1=" + this.field_110978_o + '}';
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\TextureAtlasSprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */