/*     */ package net.minecraft.util;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
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
/*     */ public class MathHelper
/*     */ {
/*  18 */   private static float[] field_76144_a = new float[65536]; static {
/*  19 */     for (byte b = 0; b < 65536; b++) {
/*  20 */       field_76144_a[b] = (float)Math.sin(b * Math.PI * 2.0D / 65536.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final float func_76126_a(float p_76126_0_) {
/*  25 */     return field_76144_a[(int)(p_76126_0_ * 10430.378F) & 0xFFFF];
/*     */   }
/*     */   
/*     */   public static final float func_76134_b(float p_76134_0_) {
/*  29 */     return field_76144_a[(int)(p_76134_0_ * 10430.378F + 16384.0F) & 0xFFFF];
/*     */   }
/*     */   
/*     */   public static final float func_76129_c(float p_76129_0_) {
/*  33 */     return (float)Math.sqrt(p_76129_0_);
/*     */   }
/*     */   
/*     */   public static final float func_76133_a(double p_76133_0_) {
/*  37 */     return (float)Math.sqrt(p_76133_0_);
/*     */   }
/*     */   
/*     */   public static int func_76141_d(float p_76141_0_) {
/*  41 */     int i = (int)p_76141_0_;
/*  42 */     return (p_76141_0_ < i) ? (i - 1) : i;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_76140_b(double p_76140_0_) {
/*  46 */     return (int)(p_76140_0_ + 1024.0D) - 1024;
/*     */   }
/*     */   
/*     */   public static int func_76128_c(double p_76128_0_) {
/*  50 */     int i = (int)p_76128_0_;
/*  51 */     return (p_76128_0_ < i) ? (i - 1) : i;
/*     */   }
/*     */   
/*     */   public static long func_76124_d(double p_76124_0_) {
/*  55 */     long l = (long)p_76124_0_;
/*  56 */     return (p_76124_0_ < l) ? (l - 1L) : l;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_154353_e(double p_154353_0_) {
/*  60 */     return (int)((p_154353_0_ >= 0.0D) ? p_154353_0_ : (-p_154353_0_ + 1.0D));
/*     */   }
/*     */   
/*     */   public static float func_76135_e(float p_76135_0_) {
/*  64 */     return (p_76135_0_ >= 0.0F) ? p_76135_0_ : -p_76135_0_;
/*     */   }
/*     */   
/*     */   public static int func_76130_a(int p_76130_0_) {
/*  68 */     return (p_76130_0_ >= 0) ? p_76130_0_ : -p_76130_0_;
/*     */   }
/*     */   
/*     */   public static int func_76123_f(float p_76123_0_) {
/*  72 */     int i = (int)p_76123_0_;
/*  73 */     return (p_76123_0_ > i) ? (i + 1) : i;
/*     */   }
/*     */   
/*     */   public static int func_76143_f(double p_76143_0_) {
/*  77 */     int i = (int)p_76143_0_;
/*  78 */     return (p_76143_0_ > i) ? (i + 1) : i;
/*     */   }
/*     */   
/*     */   public static int func_76125_a(int p_76125_0_, int p_76125_1_, int p_76125_2_) {
/*  82 */     if (p_76125_0_ < p_76125_1_) {
/*  83 */       return p_76125_1_;
/*     */     }
/*  85 */     if (p_76125_0_ > p_76125_2_) {
/*  86 */       return p_76125_2_;
/*     */     }
/*  88 */     return p_76125_0_;
/*     */   }
/*     */   
/*     */   public static float func_76131_a(float p_76131_0_, float p_76131_1_, float p_76131_2_) {
/*  92 */     if (p_76131_0_ < p_76131_1_) {
/*  93 */       return p_76131_1_;
/*     */     }
/*  95 */     if (p_76131_0_ > p_76131_2_) {
/*  96 */       return p_76131_2_;
/*     */     }
/*  98 */     return p_76131_0_;
/*     */   }
/*     */   
/*     */   public static double func_151237_a(double p_151237_0_, double p_151237_2_, double p_151237_4_) {
/* 102 */     if (p_151237_0_ < p_151237_2_) {
/* 103 */       return p_151237_2_;
/*     */     }
/* 105 */     if (p_151237_0_ > p_151237_4_) {
/* 106 */       return p_151237_4_;
/*     */     }
/* 108 */     return p_151237_0_;
/*     */   }
/*     */   
/*     */   public static double func_151238_b(double p_151238_0_, double p_151238_2_, double p_151238_4_) {
/* 112 */     if (p_151238_4_ < 0.0D) {
/* 113 */       return p_151238_0_;
/*     */     }
/* 115 */     if (p_151238_4_ > 1.0D) {
/* 116 */       return p_151238_2_;
/*     */     }
/* 118 */     return p_151238_0_ + (p_151238_2_ - p_151238_0_) * p_151238_4_;
/*     */   }
/*     */   
/*     */   public static double func_76132_a(double p_76132_0_, double p_76132_2_) {
/* 122 */     if (p_76132_0_ < 0.0D) p_76132_0_ = -p_76132_0_; 
/* 123 */     if (p_76132_2_ < 0.0D) p_76132_2_ = -p_76132_2_; 
/* 124 */     return (p_76132_0_ > p_76132_2_) ? p_76132_0_ : p_76132_2_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_76137_a(int p_76137_0_, int p_76137_1_) {
/* 128 */     if (p_76137_0_ < 0) return -((-p_76137_0_ - 1) / p_76137_1_) - 1; 
/* 129 */     return p_76137_0_ / p_76137_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean func_76139_a(String p_76139_0_) {
/* 133 */     return (p_76139_0_ == null || p_76139_0_.length() == 0);
/*     */   }
/*     */   
/*     */   public static int func_76136_a(Random p_76136_0_, int p_76136_1_, int p_76136_2_) {
/* 137 */     if (p_76136_1_ >= p_76136_2_) {
/* 138 */       return p_76136_1_;
/*     */     }
/* 140 */     return p_76136_0_.nextInt(p_76136_2_ - p_76136_1_ + 1) + p_76136_1_;
/*     */   }
/*     */   
/*     */   public static float func_151240_a(Random p_151240_0_, float p_151240_1_, float p_151240_2_) {
/* 144 */     if (p_151240_1_ >= p_151240_2_) return p_151240_1_; 
/* 145 */     return p_151240_0_.nextFloat() * (p_151240_2_ - p_151240_1_) + p_151240_1_;
/*     */   }
/*     */   
/*     */   public static double func_82716_a(Random p_82716_0_, double p_82716_1_, double p_82716_3_) {
/* 149 */     if (p_82716_1_ >= p_82716_3_) return p_82716_1_; 
/* 150 */     return p_82716_0_.nextDouble() * (p_82716_3_ - p_82716_1_) + p_82716_1_;
/*     */   }
/*     */   
/*     */   public static double func_76127_a(long[] p_76127_0_) {
/* 154 */     long l = 0L;
/*     */     
/* 156 */     for (long l1 : p_76127_0_) {
/* 157 */       l += l1;
/*     */     }
/*     */     
/* 160 */     return l / p_76127_0_.length;
/*     */   }
/*     */   
/*     */   public static float func_76142_g(float p_76142_0_) {
/* 164 */     p_76142_0_ %= 360.0F;
/* 165 */     if (p_76142_0_ >= 180.0F) p_76142_0_ -= 360.0F; 
/* 166 */     if (p_76142_0_ < -180.0F) p_76142_0_ += 360.0F; 
/* 167 */     return p_76142_0_;
/*     */   }
/*     */   
/*     */   public static double func_76138_g(double p_76138_0_) {
/* 171 */     p_76138_0_ %= 360.0D;
/* 172 */     if (p_76138_0_ >= 180.0D) p_76138_0_ -= 360.0D; 
/* 173 */     if (p_76138_0_ < -180.0D) p_76138_0_ += 360.0D; 
/* 174 */     return p_76138_0_;
/*     */   }
/*     */   
/*     */   public static int func_82715_a(String p_82715_0_, int p_82715_1_) {
/* 178 */     int i = p_82715_1_;
/*     */     
/*     */     try {
/* 181 */       i = Integer.parseInt(p_82715_0_);
/* 182 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/* 185 */     return i;
/*     */   }
/*     */   
/*     */   public static int func_82714_a(String p_82714_0_, int p_82714_1_, int p_82714_2_) {
/* 189 */     int i = p_82714_1_;
/*     */     
/*     */     try {
/* 192 */       i = Integer.parseInt(p_82714_0_);
/* 193 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/* 196 */     if (i < p_82714_2_) i = p_82714_2_; 
/* 197 */     return i;
/*     */   }
/*     */   
/*     */   public static double func_82712_a(String p_82712_0_, double p_82712_1_) {
/* 201 */     double d = p_82712_1_;
/*     */     
/*     */     try {
/* 204 */       d = Double.parseDouble(p_82712_0_);
/* 205 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/* 208 */     return d;
/*     */   }
/*     */   
/*     */   public static double func_82713_a(String p_82713_0_, double p_82713_1_, double p_82713_3_) {
/* 212 */     double d = p_82713_1_;
/*     */     
/*     */     try {
/* 215 */       d = Double.parseDouble(p_82713_0_);
/* 216 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/* 219 */     if (d < p_82713_3_) d = p_82713_3_; 
/* 220 */     return d;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_151236_b(int p_151236_0_) {
/* 225 */     int i = p_151236_0_ - 1;
/* 226 */     i |= i >> 1;
/* 227 */     i |= i >> 2;
/* 228 */     i |= i >> 4;
/* 229 */     i |= i >> 8;
/* 230 */     i |= i >> 16;
/* 231 */     return i + 1;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static boolean func_151235_d(int p_151235_0_) {
/* 236 */     return (p_151235_0_ != 0 && (p_151235_0_ & p_151235_0_ - 1) == 0);
/*     */   }
/*     */ 
/*     */   
/* 240 */   private static final int[] field_151242_b = new int[] { 0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };
/*     */   
/*     */   private static final String __OBFID = "CL_00001496";
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static int func_151241_e(int p_151241_0_) {
/* 246 */     p_151241_0_ = func_151235_d(p_151241_0_) ? p_151241_0_ : func_151236_b(p_151241_0_);
/* 247 */     return field_151242_b[(int)(p_151241_0_ * 125613361L >> 27L) & 0x1F];
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_151239_c(int p_151239_0_) {
/* 251 */     return func_151241_e(p_151239_0_) - (func_151235_d(p_151239_0_) ? 0 : 1);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_154354_b(int p_154354_0_, int p_154354_1_) {
/* 255 */     if (p_154354_1_ == 0) return 0;
/*     */     
/* 257 */     if (p_154354_0_ < 0) {
/* 258 */       p_154354_1_ *= -1;
/*     */     }
/*     */     
/* 261 */     int i = p_154354_0_ % p_154354_1_;
/* 262 */     if (i == 0) {
/* 263 */       return p_154354_0_;
/*     */     }
/* 265 */     return p_154354_0_ + p_154354_1_ - i;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MathHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */