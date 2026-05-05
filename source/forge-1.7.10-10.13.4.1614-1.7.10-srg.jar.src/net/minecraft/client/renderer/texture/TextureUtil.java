/*     */ package net.minecraft.client.renderer.texture;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.nio.IntBuffer;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GLAllocation;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TextureUtil
/*     */ {
/*  25 */   private static final Logger field_147959_c = LogManager.getLogger();
/*     */   
/*  27 */   private static final IntBuffer field_111000_c = GLAllocation.func_74527_f(4194304);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   public static final DynamicTexture field_111001_a = new DynamicTexture(16, 16);
/*  33 */   public static final int[] field_110999_b = field_111001_a.func_110565_c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static int field_147958_e = -1;
/*  40 */   private static int field_147956_f = -1;
/*  41 */   private static float field_152779_g = -1.0F;
/*     */   
/*     */   static {
/*  44 */     int i = -16777216;
/*  45 */     int j = -524040;
/*  46 */     int[] arrayOfInt1 = { -524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040 };
/*  47 */     int[] arrayOfInt2 = { -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216 };
/*  48 */     int k = arrayOfInt1.length;
/*  49 */     for (byte b = 0; b < 16; b++) {
/*  50 */       System.arraycopy((b < k) ? arrayOfInt1 : arrayOfInt2, 0, field_110999_b, 16 * b, k);
/*  51 */       System.arraycopy((b < k) ? arrayOfInt2 : arrayOfInt1, 0, field_110999_b, 16 * b + k, k);
/*     */     } 
/*  53 */     field_111001_a.func_110564_a();
/*     */   }
/*     */   
/*     */   public static int func_110996_a() {
/*  57 */     return GL11.glGenTextures();
/*     */   }
/*     */   
/*     */   public static void func_147942_a(int p_147942_0_) {
/*  61 */     GL11.glDeleteTextures(p_147942_0_);
/*     */   }
/*     */   
/*     */   public static int func_110987_a(int p_110987_0_, BufferedImage p_110987_1_) {
/*  65 */     return func_110989_a(p_110987_0_, p_110987_1_, false, false);
/*     */   }
/*     */   
/*     */   public static void func_110988_a(int p_110988_0_, int[] p_110988_1_, int p_110988_2_, int p_110988_3_) {
/*  69 */     func_94277_a(p_110988_0_);
/*     */     
/*  71 */     func_147947_a(0, p_110988_1_, p_110988_2_, p_110988_3_, 0, 0, false, false, false);
/*     */   }
/*     */   
/*     */   public static int[][] func_147949_a(int p_147949_0_, int p_147949_1_, int[][] p_147949_2_) {
/*  75 */     int[][] arrayOfInt = new int[p_147949_0_ + 1][];
/*  76 */     arrayOfInt[0] = p_147949_2_[0];
/*     */     
/*  78 */     if (p_147949_0_ > 0) {
/*     */       
/*  80 */       boolean bool = false; byte b;
/*  81 */       for (b = 0; b < p_147949_2_.length; b++) {
/*  82 */         if (p_147949_2_[0][b] >> 24 == 0) {
/*  83 */           bool = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  88 */       for (b = 1; b <= p_147949_0_; b++) {
/*     */         
/*  90 */         if (p_147949_2_[b] != null) {
/*  91 */           arrayOfInt[b] = p_147949_2_[b];
/*     */         }
/*     */         else {
/*     */           
/*  95 */           int[] arrayOfInt1 = arrayOfInt[b - 1];
/*  96 */           int[] arrayOfInt2 = new int[arrayOfInt1.length >> 2];
/*     */           
/*  98 */           int i = p_147949_1_ >> b;
/*  99 */           int j = arrayOfInt2.length / i;
/* 100 */           int k = i << 1;
/*     */           
/* 102 */           for (byte b1 = 0; b1 < i; b1++) {
/* 103 */             for (byte b2 = 0; b2 < j; b2++) {
/* 104 */               int m = 2 * (b1 + b2 * k);
/* 105 */               arrayOfInt2[b1 + b2 * i] = func_147943_a(arrayOfInt1[m + 0], arrayOfInt1[m + 1], arrayOfInt1[m + 0 + k], arrayOfInt1[m + 1 + k], bool);
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 115 */           arrayOfInt[b] = arrayOfInt2;
/*     */         } 
/*     */       } 
/*     */     } 
/* 119 */     return arrayOfInt;
/*     */   }
/*     */   
/* 122 */   private static final int[] field_147957_g = new int[4];
/*     */   private static int func_147943_a(int p_147943_0_, int p_147943_1_, int p_147943_2_, int p_147943_3_, boolean p_147943_4_) {
/* 124 */     if (!p_147943_4_) {
/* 125 */       int n = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 24);
/* 126 */       int i1 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 16);
/* 127 */       int i2 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 8);
/* 128 */       int i3 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 0);
/*     */       
/* 130 */       return n << 24 | i1 << 16 | i2 << 8 | i3;
/*     */     } 
/* 132 */     field_147957_g[0] = p_147943_0_;
/* 133 */     field_147957_g[1] = p_147943_1_;
/* 134 */     field_147957_g[2] = p_147943_2_;
/* 135 */     field_147957_g[3] = p_147943_3_;
/*     */     
/* 137 */     float f1 = 0.0F;
/* 138 */     float f2 = 0.0F;
/* 139 */     float f3 = 0.0F;
/* 140 */     float f4 = 0.0F;
/*     */     int i;
/* 142 */     for (i = 0; i < 4; i++) {
/* 143 */       if (field_147957_g[i] >> 24 != 0) {
/* 144 */         f1 += (float)Math.pow(((field_147957_g[i] >> 24 & 0xFF) / 255.0F), 2.2D);
/* 145 */         f2 += (float)Math.pow(((field_147957_g[i] >> 16 & 0xFF) / 255.0F), 2.2D);
/* 146 */         f3 += (float)Math.pow(((field_147957_g[i] >> 8 & 0xFF) / 255.0F), 2.2D);
/* 147 */         f4 += (float)Math.pow(((field_147957_g[i] >> 0 & 0xFF) / 255.0F), 2.2D);
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     f1 /= 4.0F;
/* 152 */     f2 /= 4.0F;
/* 153 */     f3 /= 4.0F;
/* 154 */     f4 /= 4.0F;
/*     */     
/* 156 */     i = (int)(Math.pow(f1, 0.45454545454545453D) * 255.0D);
/* 157 */     int j = (int)(Math.pow(f2, 0.45454545454545453D) * 255.0D);
/* 158 */     int k = (int)(Math.pow(f3, 0.45454545454545453D) * 255.0D);
/* 159 */     int m = (int)(Math.pow(f4, 0.45454545454545453D) * 255.0D);
/*     */     
/* 161 */     if (i < 96) {
/* 162 */       i = 0;
/*     */     }
/* 164 */     return i << 24 | j << 16 | k << 8 | m;
/*     */   }
/*     */   private static final String __OBFID = "CL_00001067";
/*     */   
/*     */   private static int func_147944_a(int p_147944_0_, int p_147944_1_, int p_147944_2_, int p_147944_3_, int p_147944_4_) {
/* 169 */     float f1 = (float)Math.pow(((p_147944_0_ >> p_147944_4_ & 0xFF) / 255.0F), 2.2D);
/* 170 */     float f2 = (float)Math.pow(((p_147944_1_ >> p_147944_4_ & 0xFF) / 255.0F), 2.2D);
/* 171 */     float f3 = (float)Math.pow(((p_147944_2_ >> p_147944_4_ & 0xFF) / 255.0F), 2.2D);
/* 172 */     float f4 = (float)Math.pow(((p_147944_3_ >> p_147944_4_ & 0xFF) / 255.0F), 2.2D);
/* 173 */     float f5 = (float)Math.pow((f1 + f2 + f3 + f4) * 0.25D, 0.45454545454545453D);
/*     */     
/* 175 */     return (int)(f5 * 255.0D);
/*     */   }
/*     */   
/*     */   public static void func_147955_a(int[][] p_147955_0_, int p_147955_1_, int p_147955_2_, int p_147955_3_, int p_147955_4_, boolean p_147955_5_, boolean p_147955_6_) {
/* 179 */     for (byte b = 0; b < p_147955_0_.length; b++) {
/* 180 */       int[] arrayOfInt = p_147955_0_[b];
/*     */       
/* 182 */       func_147947_a(b, arrayOfInt, p_147955_1_ >> b, p_147955_2_ >> b, p_147955_3_ >> b, p_147955_4_ >> b, p_147955_5_, p_147955_6_, (p_147955_0_.length > 1));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void func_147947_a(int p_147947_0_, int[] p_147947_1_, int p_147947_2_, int p_147947_3_, int p_147947_4_, int p_147947_5_, boolean p_147947_6_, boolean p_147947_7_, boolean p_147947_8_) {
/* 187 */     int i = 4194304 / p_147947_2_;
/*     */     
/* 189 */     func_147954_b(p_147947_6_, p_147947_8_);
/* 190 */     func_110997_a(p_147947_7_);
/*     */     
/* 192 */     int j = 0;
/* 193 */     while (j < p_147947_2_ * p_147947_3_) {
/* 194 */       int k = j / p_147947_2_;
/* 195 */       int m = Math.min(i, p_147947_3_ - k);
/* 196 */       int n = p_147947_2_ * m;
/*     */       
/* 198 */       func_110994_a(p_147947_1_, j, n);
/*     */       
/* 200 */       GL11.glTexSubImage2D(3553, p_147947_0_, p_147947_4_, p_147947_5_ + k, p_147947_2_, m, 32993, 33639, field_111000_c);
/*     */       
/* 202 */       j += p_147947_2_ * m;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_110989_a(int p_110989_0_, BufferedImage p_110989_1_, boolean p_110989_2_, boolean p_110989_3_) {
/* 207 */     func_110991_a(p_110989_0_, p_110989_1_.getWidth(), p_110989_1_.getHeight());
/*     */     
/* 209 */     return func_110995_a(p_110989_0_, p_110989_1_, 0, 0, p_110989_2_, p_110989_3_);
/*     */   }
/*     */   
/*     */   public static void func_110991_a(int p_110991_0_, int p_110991_1_, int p_110991_2_) {
/* 213 */     func_147946_a(p_110991_0_, 0, p_110991_1_, p_110991_2_, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_147946_a(int p_147946_0_, int p_147946_1_, int p_147946_2_, int p_147946_3_, float p_147946_4_) {
/* 218 */     func_147942_a(p_147946_0_);
/*     */     
/* 220 */     func_94277_a(p_147946_0_);
/*     */     
/* 222 */     if (OpenGlHelper.field_148825_d) {
/* 223 */       GL11.glTexParameterf(3553, 34046, p_147946_4_);
/*     */     }
/*     */     
/* 226 */     if (p_147946_1_ > 0) {
/* 227 */       GL11.glTexParameteri(3553, 33085, p_147946_1_);
/* 228 */       GL11.glTexParameterf(3553, 33082, 0.0F);
/* 229 */       GL11.glTexParameterf(3553, 33083, p_147946_1_);
/* 230 */       GL11.glTexParameterf(3553, 34049, 0.0F);
/*     */     } 
/*     */     
/* 233 */     for (byte b = 0; b <= p_147946_1_; b++) {
/* 234 */       GL11.glTexImage2D(3553, b, 6408, p_147946_2_ >> b, p_147946_3_ >> b, 0, 32993, 33639, (IntBuffer)null);
/*     */     }
/*     */   }
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
/*     */   public static int func_110995_a(int p_110995_0_, BufferedImage p_110995_1_, int p_110995_2_, int p_110995_3_, boolean p_110995_4_, boolean p_110995_5_) {
/* 277 */     func_94277_a(p_110995_0_);
/*     */     
/* 279 */     func_110993_a(p_110995_1_, p_110995_2_, p_110995_3_, p_110995_4_, p_110995_5_);
/*     */     
/* 281 */     return p_110995_0_;
/*     */   }
/*     */   
/*     */   private static void func_110993_a(BufferedImage p_110993_0_, int p_110993_1_, int p_110993_2_, boolean p_110993_3_, boolean p_110993_4_) {
/* 285 */     int i = p_110993_0_.getWidth();
/* 286 */     int j = p_110993_0_.getHeight();
/*     */     
/* 288 */     int k = 4194304 / i;
/* 289 */     int[] arrayOfInt = new int[k * i];
/*     */     
/* 291 */     func_147951_b(p_110993_3_);
/* 292 */     func_110997_a(p_110993_4_);
/*     */     
/* 294 */     int m = 0;
/* 295 */     while (m < i * j) {
/* 296 */       int n = m / i;
/* 297 */       int i1 = Math.min(k, j - n);
/* 298 */       int i2 = i * i1;
/*     */       
/* 300 */       p_110993_0_.getRGB(0, n, i, i1, arrayOfInt, 0, i);
/*     */       
/* 302 */       func_110990_a(arrayOfInt, i2);
/*     */       
/* 304 */       GL11.glTexSubImage2D(3553, 0, p_110993_1_, p_110993_2_ + n, i, i1, 32993, 33639, field_111000_c);
/*     */       
/* 306 */       m += i * k;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void func_110997_a(boolean p_110997_0_) {
/* 311 */     if (p_110997_0_) {
/* 312 */       GL11.glTexParameteri(3553, 10242, 10496);
/* 313 */       GL11.glTexParameteri(3553, 10243, 10496);
/*     */     } else {
/* 315 */       GL11.glTexParameteri(3553, 10242, 10497);
/* 316 */       GL11.glTexParameteri(3553, 10243, 10497);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void func_147951_b(boolean p_147951_0_) {
/* 321 */     func_147954_b(p_147951_0_, false);
/*     */   }
/*     */   
/*     */   public static void func_152777_a(boolean p_152777_0_, boolean p_152777_1_, float p_152777_2_) {
/* 325 */     field_147958_e = GL11.glGetTexParameteri(3553, 10241);
/* 326 */     field_147956_f = GL11.glGetTexParameteri(3553, 10240);
/* 327 */     field_152779_g = GL11.glGetTexParameterf(3553, 34046);
/* 328 */     func_147954_b(p_152777_0_, p_152777_1_);
/* 329 */     func_152778_a(p_152777_2_);
/*     */   }
/*     */   
/*     */   public static void func_147945_b() {
/* 333 */     if (field_147958_e < 0 || field_147956_f < 0 || field_152779_g < 0.0F) {
/*     */       return;
/*     */     }
/* 336 */     func_147952_b(field_147958_e, field_147956_f);
/* 337 */     func_152778_a(field_152779_g);
/* 338 */     field_152779_g = -1.0F;
/* 339 */     field_147958_e = -1;
/* 340 */     field_147956_f = -1;
/*     */   }
/*     */   
/*     */   private static void func_147952_b(int p_147952_0_, int p_147952_1_) {
/* 344 */     GL11.glTexParameteri(3553, 10241, p_147952_0_);
/* 345 */     GL11.glTexParameteri(3553, 10240, p_147952_1_);
/*     */   }
/*     */   
/*     */   private static void func_152778_a(float p_152778_0_) {
/* 349 */     GL11.glTexParameterf(3553, 34046, p_152778_0_);
/*     */   }
/*     */   
/*     */   private static void func_147954_b(boolean p_147954_0_, boolean p_147954_1_) {
/* 353 */     if (p_147954_0_) {
/* 354 */       GL11.glTexParameteri(3553, 10241, p_147954_1_ ? 9987 : 9729);
/* 355 */       GL11.glTexParameteri(3553, 10240, 9729);
/*     */     } else {
/* 357 */       GL11.glTexParameteri(3553, 10241, p_147954_1_ ? 9986 : 9728);
/* 358 */       GL11.glTexParameteri(3553, 10240, 9728);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void func_110990_a(int[] p_110990_0_, int p_110990_1_) {
/* 363 */     func_110994_a(p_110990_0_, 0, p_110990_1_);
/*     */   }
/*     */   
/*     */   private static void func_110994_a(int[] p_110994_0_, int p_110994_1_, int p_110994_2_) {
/* 367 */     int[] arrayOfInt = p_110994_0_;
/*     */     
/* 369 */     if ((Minecraft.func_71410_x()).field_71474_y.field_74337_g) {
/* 370 */       arrayOfInt = func_110985_a(p_110994_0_);
/*     */     }
/*     */     
/* 373 */     field_111000_c.clear();
/* 374 */     field_111000_c.put(arrayOfInt, p_110994_1_, p_110994_2_);
/* 375 */     field_111000_c.position(0).limit(p_110994_2_);
/*     */   }
/*     */   
/*     */   static void func_94277_a(int p_94277_0_) {
/* 379 */     GL11.glBindTexture(3553, p_94277_0_);
/*     */   }
/*     */   
/*     */   public static int[] func_110986_a(IResourceManager p_110986_0_, ResourceLocation p_110986_1_) throws IOException {
/* 383 */     BufferedImage bufferedImage = ImageIO.read(p_110986_0_.func_110536_a(p_110986_1_).func_110527_b());
/*     */     
/* 385 */     int i = bufferedImage.getWidth();
/* 386 */     int j = bufferedImage.getHeight();
/*     */     
/* 388 */     int[] arrayOfInt = new int[i * j];
/* 389 */     bufferedImage.getRGB(0, 0, i, j, arrayOfInt, 0, i);
/*     */     
/* 391 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public static int[] func_110985_a(int[] p_110985_0_) {
/* 395 */     int[] arrayOfInt = new int[p_110985_0_.length];
/* 396 */     for (byte b = 0; b < p_110985_0_.length; b++) {
/* 397 */       int i = p_110985_0_[b] >> 24 & 0xFF;
/* 398 */       int j = p_110985_0_[b] >> 16 & 0xFF;
/* 399 */       int k = p_110985_0_[b] >> 8 & 0xFF;
/* 400 */       int m = p_110985_0_[b] & 0xFF;
/*     */       
/* 402 */       int n = (j * 30 + k * 59 + m * 11) / 100;
/* 403 */       int i1 = (j * 30 + k * 70) / 100;
/* 404 */       int i2 = (j * 30 + m * 70) / 100;
/*     */       
/* 406 */       arrayOfInt[b] = i << 24 | n << 16 | i1 << 8 | i2;
/*     */     } 
/*     */     
/* 409 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public static int[] func_147948_a(int[] p_147948_0_, int p_147948_1_, int p_147948_2_, int p_147948_3_) {
/* 413 */     int i = p_147948_1_ + 2 * p_147948_3_;
/*     */     int j;
/* 415 */     for (j = p_147948_2_ - 1; j >= 0; j--) {
/* 416 */       int k = j * p_147948_1_;
/* 417 */       int m = p_147948_3_ + (j + p_147948_3_) * i;
/*     */       
/*     */       int n;
/* 420 */       for (n = 0; n < p_147948_3_; n += p_147948_1_) {
/* 421 */         int i1 = Math.min(p_147948_1_, p_147948_3_ - n);
/*     */         
/* 423 */         System.arraycopy(p_147948_0_, k + p_147948_1_ - i1, p_147948_0_, m - n - i1, i1);
/*     */       } 
/*     */       
/* 426 */       System.arraycopy(p_147948_0_, k, p_147948_0_, m, p_147948_1_);
/*     */ 
/*     */       
/* 429 */       for (n = 0; n < p_147948_3_; n += p_147948_1_) {
/* 430 */         System.arraycopy(p_147948_0_, k, p_147948_0_, m + p_147948_1_ + n, Math.min(p_147948_1_, p_147948_3_ - n));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 435 */     for (j = 0; j < p_147948_3_; j += p_147948_2_) {
/* 436 */       int k = Math.min(p_147948_2_, p_147948_3_ - j);
/* 437 */       System.arraycopy(p_147948_0_, (p_147948_3_ + p_147948_2_ - k) * i, p_147948_0_, (p_147948_3_ - j - k) * i, i * k);
/*     */     } 
/*     */ 
/*     */     
/* 441 */     for (j = 0; j < p_147948_3_; j += p_147948_2_) {
/* 442 */       int k = Math.min(p_147948_2_, p_147948_3_ - j);
/* 443 */       System.arraycopy(p_147948_0_, p_147948_3_ * i, p_147948_0_, (p_147948_2_ + p_147948_3_ + j) * i, i * k);
/*     */     } 
/*     */     
/* 446 */     return p_147948_0_;
/*     */   }
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
/*     */   public static void func_147953_a(int[] p_147953_0_, int p_147953_1_, int p_147953_2_) {
/* 481 */     int[] arrayOfInt = new int[p_147953_1_];
/* 482 */     int i = p_147953_2_ / 2;
/* 483 */     for (byte b = 0; b < i; b++) {
/* 484 */       System.arraycopy(p_147953_0_, b * p_147953_1_, arrayOfInt, 0, p_147953_1_);
/* 485 */       System.arraycopy(p_147953_0_, (p_147953_2_ - 1 - b) * p_147953_1_, p_147953_0_, b * p_147953_1_, p_147953_1_);
/* 486 */       System.arraycopy(arrayOfInt, 0, p_147953_0_, (p_147953_2_ - 1 - b) * p_147953_1_, p_147953_1_);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\TextureUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */