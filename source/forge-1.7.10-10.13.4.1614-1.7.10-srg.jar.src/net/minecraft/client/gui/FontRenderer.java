/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import com.ibm.icu.text.ArabicShaping;
/*     */ import com.ibm.icu.text.ArabicShapingException;
/*     */ import com.ibm.icu.text.Bidi;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.resources.IResourceManagerReloadListener;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class FontRenderer
/*     */   implements IResourceManagerReloadListener {
/*  27 */   private static final ResourceLocation[] field_111274_c = new ResourceLocation[256];
/*     */ 
/*     */ 
/*     */   
/*  31 */   protected int[] field_78286_d = new int[256];
/*  32 */   public int field_78288_b = 9;
/*  33 */   public Random field_78289_c = new Random();
/*     */   
/*  35 */   protected byte[] field_78287_e = new byte[65536];
/*     */   
/*  37 */   private int[] field_78285_g = new int[32];
/*     */   
/*     */   protected final ResourceLocation field_111273_g;
/*     */   
/*     */   private final TextureManager field_78298_i;
/*     */   
/*     */   protected float field_78295_j;
/*     */   
/*     */   protected float field_78296_k;
/*     */   
/*     */   private boolean field_78293_l;
/*     */   
/*     */   private boolean field_78294_m;
/*     */   private float field_78291_n;
/*     */   private float field_78292_o;
/*     */   
/*     */   public FontRenderer(GameSettings p_i1035_1_, ResourceLocation p_i1035_2_, TextureManager p_i1035_3_, boolean p_i1035_4_) {
/*  54 */     this.field_111273_g = p_i1035_2_;
/*  55 */     this.field_78298_i = p_i1035_3_;
/*  56 */     this.field_78293_l = p_i1035_4_;
/*     */     
/*  58 */     p_i1035_3_.func_110577_a(this.field_111273_g);
/*     */ 
/*     */     
/*  61 */     for (byte b = 0; b < 32; b++) {
/*  62 */       int i = (b >> 3 & 0x1) * 85;
/*  63 */       int j = (b >> 2 & 0x1) * 170 + i;
/*  64 */       int k = (b >> 1 & 0x1) * 170 + i;
/*  65 */       int m = (b >> 0 & 0x1) * 170 + i;
/*     */       
/*  67 */       if (b == 6) {
/*  68 */         j += 85;
/*     */       }
/*     */       
/*  71 */       if (p_i1035_1_.field_74337_g) {
/*  72 */         int n = (j * 30 + k * 59 + m * 11) / 100;
/*  73 */         int i1 = (j * 30 + k * 70) / 100;
/*  74 */         int i2 = (j * 30 + m * 70) / 100;
/*  75 */         j = n;
/*  76 */         k = i1;
/*  77 */         m = i2;
/*     */       } 
/*     */       
/*  80 */       if (b >= 16) {
/*  81 */         j /= 4;
/*  82 */         k /= 4;
/*  83 */         m /= 4;
/*     */       } 
/*     */       
/*  86 */       this.field_78285_g[b] = (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF;
/*     */     } 
/*     */     
/*  89 */     func_98306_d();
/*     */   }
/*     */   private float field_78306_p; private float field_78305_q; private int field_78304_r; private boolean field_78303_s; private boolean field_78302_t; private boolean field_78301_u; private boolean field_78300_v; private boolean field_78299_w; private static final String __OBFID = "CL_00000660";
/*     */   
/*     */   public void func_110549_a(IResourceManager p_110549_1_) {
/*  94 */     func_111272_d();
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_111272_d() {
/*     */     BufferedImage bufferedImage;
/*     */     try {
/* 101 */       bufferedImage = ImageIO.read(Minecraft.func_71410_x().func_110442_L().func_110536_a(this.field_111273_g).func_110527_b());
/* 102 */     } catch (IOException iOException) {
/* 103 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */     
/* 106 */     int i = bufferedImage.getWidth();
/* 107 */     int j = bufferedImage.getHeight();
/* 108 */     int[] arrayOfInt = new int[i * j];
/* 109 */     bufferedImage.getRGB(0, 0, i, j, arrayOfInt, 0, i);
/*     */     
/* 111 */     int k = j / 16;
/* 112 */     int m = i / 16;
/*     */     
/* 114 */     byte b1 = 1;
/*     */     
/* 116 */     float f = 8.0F / m;
/*     */     
/* 118 */     for (byte b2 = 0; b2 < 'Ā'; b2++) {
/* 119 */       int n = b2 % 16;
/* 120 */       int i1 = b2 / 16;
/*     */       
/* 122 */       if (b2 == 32) this.field_78286_d[b2] = 3 + b1;
/*     */       
/* 124 */       int i2 = m - 1;
/* 125 */       for (; i2 >= 0; i2--) {
/* 126 */         int i3 = n * m + i2;
/* 127 */         boolean bool = true;
/* 128 */         for (byte b = 0; b < k && bool; b++) {
/* 129 */           int i4 = (i1 * m + b) * i;
/*     */           
/* 131 */           if ((arrayOfInt[i3 + i4] >> 24 & 0xFF) != 0) {
/* 132 */             bool = false;
/*     */           }
/*     */         } 
/* 135 */         if (!bool) {
/*     */           break;
/*     */         }
/*     */       } 
/* 139 */       i2++;
/*     */ 
/*     */       
/* 142 */       this.field_78286_d[b2] = (int)(0.5D + (i2 * f)) + b1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_98306_d() {
/*     */     try {
/* 148 */       InputStream inputStream = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("font/glyph_sizes.bin")).func_110527_b();
/* 149 */       inputStream.read(this.field_78287_e);
/* 150 */     } catch (IOException iOException) {
/* 151 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private float func_78278_a(int p_78278_1_, char p_78278_2_, boolean p_78278_3_) {
/* 156 */     if (p_78278_2_ == ' ')
/* 157 */       return 4.0F; 
/* 158 */     if ("ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000".indexOf(p_78278_2_) != -1 && !this.field_78293_l) {
/* 159 */       return func_78266_a(p_78278_1_, p_78278_3_);
/*     */     }
/* 161 */     return func_78277_a(p_78278_2_, p_78278_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_78266_a(int p_78266_1_, boolean p_78266_2_) {
/* 166 */     float f1 = (p_78266_1_ % 16 * 8);
/* 167 */     float f2 = (p_78266_1_ / 16 * 8);
/* 168 */     float f3 = p_78266_2_ ? 1.0F : 0.0F;
/*     */     
/* 170 */     this.field_78298_i.func_110577_a(this.field_111273_g);
/*     */     
/* 172 */     float f4 = this.field_78286_d[p_78266_1_] - 0.01F;
/*     */     
/* 174 */     GL11.glBegin(5);
/* 175 */     GL11.glTexCoord2f(f1 / 128.0F, f2 / 128.0F);
/* 176 */     GL11.glVertex3f(this.field_78295_j + f3, this.field_78296_k, 0.0F);
/* 177 */     GL11.glTexCoord2f(f1 / 128.0F, (f2 + 7.99F) / 128.0F);
/* 178 */     GL11.glVertex3f(this.field_78295_j - f3, this.field_78296_k + 7.99F, 0.0F);
/* 179 */     GL11.glTexCoord2f((f1 + f4 - 1.0F) / 128.0F, f2 / 128.0F);
/* 180 */     GL11.glVertex3f(this.field_78295_j + f4 - 1.0F + f3, this.field_78296_k, 0.0F);
/* 181 */     GL11.glTexCoord2f((f1 + f4 - 1.0F) / 128.0F, (f2 + 7.99F) / 128.0F);
/* 182 */     GL11.glVertex3f(this.field_78295_j + f4 - 1.0F - f3, this.field_78296_k + 7.99F, 0.0F);
/* 183 */     GL11.glEnd();
/*     */     
/* 185 */     return this.field_78286_d[p_78266_1_];
/*     */   }
/*     */   
/*     */   private ResourceLocation func_111271_a(int p_111271_1_) {
/* 189 */     if (field_111274_c[p_111271_1_] == null) {
/* 190 */       field_111274_c[p_111271_1_] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", new Object[] { Integer.valueOf(p_111271_1_) }));
/*     */     }
/*     */     
/* 193 */     return field_111274_c[p_111271_1_];
/*     */   }
/*     */   
/*     */   private void func_78257_a(int p_78257_1_) {
/* 197 */     this.field_78298_i.func_110577_a(func_111271_a(p_78257_1_));
/*     */   }
/*     */   
/*     */   protected float func_78277_a(char p_78277_1_, boolean p_78277_2_) {
/* 201 */     if (this.field_78287_e[p_78277_1_] == 0) {
/* 202 */       return 0.0F;
/*     */     }
/*     */     
/* 205 */     int i = p_78277_1_ / 256;
/*     */     
/* 207 */     func_78257_a(i);
/*     */ 
/*     */     
/* 210 */     int j = this.field_78287_e[p_78277_1_] >>> 4;
/*     */     
/* 212 */     int k = this.field_78287_e[p_78277_1_] & 0xF;
/*     */     
/* 214 */     float f1 = j;
/* 215 */     float f2 = (k + 1);
/*     */     
/* 217 */     float f3 = (p_78277_1_ % 16 * 16) + f1;
/* 218 */     float f4 = ((p_78277_1_ & 0xFF) / 16 * 16);
/* 219 */     float f5 = f2 - f1 - 0.02F;
/* 220 */     float f6 = p_78277_2_ ? 1.0F : 0.0F;
/*     */     
/* 222 */     GL11.glBegin(5);
/* 223 */     GL11.glTexCoord2f(f3 / 256.0F, f4 / 256.0F);
/* 224 */     GL11.glVertex3f(this.field_78295_j + f6, this.field_78296_k, 0.0F);
/* 225 */     GL11.glTexCoord2f(f3 / 256.0F, (f4 + 15.98F) / 256.0F);
/* 226 */     GL11.glVertex3f(this.field_78295_j - f6, this.field_78296_k + 7.99F, 0.0F);
/* 227 */     GL11.glTexCoord2f((f3 + f5) / 256.0F, f4 / 256.0F);
/* 228 */     GL11.glVertex3f(this.field_78295_j + f5 / 2.0F + f6, this.field_78296_k, 0.0F);
/* 229 */     GL11.glTexCoord2f((f3 + f5) / 256.0F, (f4 + 15.98F) / 256.0F);
/* 230 */     GL11.glVertex3f(this.field_78295_j + f5 / 2.0F - f6, this.field_78296_k + 7.99F, 0.0F);
/* 231 */     GL11.glEnd();
/*     */     
/* 233 */     return (f2 - f1) / 2.0F + 1.0F;
/*     */   }
/*     */   
/*     */   public int func_78261_a(String p_78261_1_, int p_78261_2_, int p_78261_3_, int p_78261_4_) {
/* 237 */     return func_85187_a(p_78261_1_, p_78261_2_, p_78261_3_, p_78261_4_, true);
/*     */   }
/*     */   
/*     */   public int func_78276_b(String p_78276_1_, int p_78276_2_, int p_78276_3_, int p_78276_4_) {
/* 241 */     return func_85187_a(p_78276_1_, p_78276_2_, p_78276_3_, p_78276_4_, false);
/*     */   }
/*     */   public int func_85187_a(String p_85187_1_, int p_85187_2_, int p_85187_3_, int p_85187_4_, boolean p_85187_5_) {
/*     */     int i;
/* 245 */     GL11.glEnable(3008);
/* 246 */     func_78265_b();
/*     */ 
/*     */ 
/*     */     
/* 250 */     if (p_85187_5_) {
/* 251 */       i = func_78258_a(p_85187_1_, p_85187_2_ + 1, p_85187_3_ + 1, p_85187_4_, true);
/* 252 */       i = Math.max(i, func_78258_a(p_85187_1_, p_85187_2_, p_85187_3_, p_85187_4_, false));
/*     */     } else {
/* 254 */       i = func_78258_a(p_85187_1_, p_85187_2_, p_85187_3_, p_85187_4_, false);
/*     */     } 
/*     */     
/* 257 */     return i;
/*     */   }
/*     */   
/*     */   private String func_147647_b(String p_147647_1_) {
/*     */     try {
/* 262 */       Bidi bidi = new Bidi((new ArabicShaping(8)).shape(p_147647_1_), 127);
/* 263 */       bidi.setReorderingMode(0);
/* 264 */       return bidi.writeReordered(2);
/* 265 */     } catch (ArabicShapingException arabicShapingException) {
/*     */ 
/*     */       
/* 268 */       return p_147647_1_;
/*     */     } 
/*     */   }
/*     */   private void func_78265_b() {
/* 272 */     this.field_78303_s = false;
/* 273 */     this.field_78302_t = false;
/* 274 */     this.field_78301_u = false;
/* 275 */     this.field_78300_v = false;
/* 276 */     this.field_78299_w = false;
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
/*     */   private void func_78255_a(String p_78255_1_, boolean p_78255_2_) {
/* 288 */     for (byte b = 0; b < p_78255_1_.length(); b++) {
/* 289 */       char c = p_78255_1_.charAt(b);
/*     */       
/* 291 */       if (c == '§' && b + 1 < p_78255_1_.length()) {
/* 292 */         int i = "0123456789abcdefklmnor".indexOf(p_78255_1_.toLowerCase().charAt(b + 1));
/*     */         
/* 294 */         if (i < 16) {
/* 295 */           this.field_78303_s = false;
/* 296 */           this.field_78302_t = false;
/* 297 */           this.field_78299_w = false;
/* 298 */           this.field_78300_v = false;
/* 299 */           this.field_78301_u = false;
/* 300 */           if (i < 0 || i > 15) i = 15;
/*     */           
/* 302 */           if (p_78255_2_) i += 16;
/*     */           
/* 304 */           int j = this.field_78285_g[i];
/* 305 */           this.field_78304_r = j;
/* 306 */           GL11.glColor4f((j >> 16) / 255.0F, (j >> 8 & 0xFF) / 255.0F, (j & 0xFF) / 255.0F, this.field_78305_q);
/* 307 */         } else if (i == 16) {
/* 308 */           this.field_78303_s = true;
/* 309 */         } else if (i == 17) {
/* 310 */           this.field_78302_t = true;
/* 311 */         } else if (i == 18) {
/* 312 */           this.field_78299_w = true;
/* 313 */         } else if (i == 19) {
/* 314 */           this.field_78300_v = true;
/* 315 */         } else if (i == 20) {
/* 316 */           this.field_78301_u = true;
/* 317 */         } else if (i == 21) {
/* 318 */           this.field_78303_s = false;
/* 319 */           this.field_78302_t = false;
/* 320 */           this.field_78299_w = false;
/* 321 */           this.field_78300_v = false;
/* 322 */           this.field_78301_u = false;
/*     */           
/* 324 */           GL11.glColor4f(this.field_78291_n, this.field_78292_o, this.field_78306_p, this.field_78305_q);
/*     */         } 
/*     */         
/* 327 */         b++;
/*     */       }
/*     */       else {
/*     */         
/* 331 */         int i = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000".indexOf(c);
/*     */         
/* 333 */         if (this.field_78303_s && i != -1) {
/*     */           while (true) {
/*     */             
/* 336 */             int j = this.field_78289_c.nextInt(this.field_78286_d.length);
/* 337 */             if (this.field_78286_d[i] == this.field_78286_d[j]) {
/* 338 */               i = j;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         }
/* 344 */         float f1 = this.field_78293_l ? 0.5F : 1.0F;
/* 345 */         boolean bool = ((c == '\000' || i == -1 || this.field_78293_l) && p_78255_2_) ? true : false;
/*     */         
/* 347 */         if (bool) {
/* 348 */           this.field_78295_j -= f1;
/* 349 */           this.field_78296_k -= f1;
/*     */         } 
/* 351 */         float f2 = func_78278_a(i, c, this.field_78301_u);
/* 352 */         if (bool) {
/* 353 */           this.field_78295_j += f1;
/* 354 */           this.field_78296_k += f1;
/*     */         } 
/*     */         
/* 357 */         if (this.field_78302_t) {
/* 358 */           this.field_78295_j += f1;
/* 359 */           if (bool) {
/* 360 */             this.field_78295_j -= f1;
/* 361 */             this.field_78296_k -= f1;
/*     */           } 
/* 363 */           func_78278_a(i, c, this.field_78301_u);
/* 364 */           this.field_78295_j -= f1;
/* 365 */           if (bool) {
/* 366 */             this.field_78295_j += f1;
/* 367 */             this.field_78296_k += f1;
/*     */           } 
/* 369 */           f2++;
/*     */         } 
/*     */         
/* 372 */         if (this.field_78299_w) {
/* 373 */           Tessellator tessellator = Tessellator.field_78398_a;
/* 374 */           GL11.glDisable(3553);
/* 375 */           tessellator.func_78382_b();
/* 376 */           tessellator.func_78377_a(this.field_78295_j, (this.field_78296_k + (this.field_78288_b / 2)), 0.0D);
/* 377 */           tessellator.func_78377_a((this.field_78295_j + f2), (this.field_78296_k + (this.field_78288_b / 2)), 0.0D);
/* 378 */           tessellator.func_78377_a((this.field_78295_j + f2), (this.field_78296_k + (this.field_78288_b / 2) - 1.0F), 0.0D);
/* 379 */           tessellator.func_78377_a(this.field_78295_j, (this.field_78296_k + (this.field_78288_b / 2) - 1.0F), 0.0D);
/* 380 */           tessellator.func_78381_a();
/* 381 */           GL11.glEnable(3553);
/*     */         } 
/*     */         
/* 384 */         if (this.field_78300_v) {
/* 385 */           Tessellator tessellator = Tessellator.field_78398_a;
/* 386 */           GL11.glDisable(3553);
/* 387 */           tessellator.func_78382_b();
/* 388 */           boolean bool1 = this.field_78300_v ? true : false;
/* 389 */           tessellator.func_78377_a((this.field_78295_j + bool1), (this.field_78296_k + this.field_78288_b), 0.0D);
/* 390 */           tessellator.func_78377_a((this.field_78295_j + f2), (this.field_78296_k + this.field_78288_b), 0.0D);
/* 391 */           tessellator.func_78377_a((this.field_78295_j + f2), (this.field_78296_k + this.field_78288_b - 1.0F), 0.0D);
/* 392 */           tessellator.func_78377_a((this.field_78295_j + bool1), (this.field_78296_k + this.field_78288_b - 1.0F), 0.0D);
/* 393 */           tessellator.func_78381_a();
/* 394 */           GL11.glEnable(3553);
/*     */         } 
/*     */         
/* 397 */         this.field_78295_j += (int)f2;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private int func_78274_b(String p_78274_1_, int p_78274_2_, int p_78274_3_, int p_78274_4_, int p_78274_5_, boolean p_78274_6_) {
/* 402 */     if (this.field_78294_m) {
/* 403 */       int i = func_78256_a(func_147647_b(p_78274_1_));
/* 404 */       p_78274_2_ = p_78274_2_ + p_78274_4_ - i;
/*     */     } 
/* 406 */     return func_78258_a(p_78274_1_, p_78274_2_, p_78274_3_, p_78274_5_, p_78274_6_);
/*     */   }
/*     */   
/*     */   private int func_78258_a(String p_78258_1_, int p_78258_2_, int p_78258_3_, int p_78258_4_, boolean p_78258_5_) {
/* 410 */     if (p_78258_1_ == null) {
/* 411 */       return 0;
/*     */     }
/* 413 */     if (this.field_78294_m) {
/* 414 */       p_78258_1_ = func_147647_b(p_78258_1_);
/*     */     }
/*     */     
/* 417 */     if ((p_78258_4_ & 0xFC000000) == 0) p_78258_4_ |= 0xFF000000;
/*     */     
/* 419 */     if (p_78258_5_) {
/* 420 */       p_78258_4_ = (p_78258_4_ & 0xFCFCFC) >> 2 | p_78258_4_ & 0xFF000000;
/*     */     }
/*     */     
/* 423 */     this.field_78291_n = (p_78258_4_ >> 16 & 0xFF) / 255.0F;
/* 424 */     this.field_78292_o = (p_78258_4_ >> 8 & 0xFF) / 255.0F;
/* 425 */     this.field_78306_p = (p_78258_4_ & 0xFF) / 255.0F;
/* 426 */     this.field_78305_q = (p_78258_4_ >> 24 & 0xFF) / 255.0F;
/*     */     
/* 428 */     GL11.glColor4f(this.field_78291_n, this.field_78292_o, this.field_78306_p, this.field_78305_q);
/*     */     
/* 430 */     this.field_78295_j = p_78258_2_;
/* 431 */     this.field_78296_k = p_78258_3_;
/* 432 */     func_78255_a(p_78258_1_, p_78258_5_);
/*     */     
/* 434 */     return (int)this.field_78295_j;
/*     */   }
/*     */   
/*     */   public int func_78256_a(String p_78256_1_) {
/* 438 */     if (p_78256_1_ == null) return 0; 
/* 439 */     int i = 0;
/* 440 */     boolean bool = false;
/*     */     
/* 442 */     for (byte b = 0; b < p_78256_1_.length(); b++) {
/* 443 */       char c = p_78256_1_.charAt(b);
/*     */       
/* 445 */       int j = func_78263_a(c);
/* 446 */       if (j < 0 && b < p_78256_1_.length() - 1) {
/* 447 */         c = p_78256_1_.charAt(++b);
/*     */         
/* 449 */         if (c == 'l' || c == 'L') {
/* 450 */           bool = true;
/* 451 */         } else if (c == 'r' || c == 'R') {
/* 452 */           bool = false;
/*     */         } 
/* 454 */         j = 0;
/*     */       } 
/* 456 */       i += j;
/* 457 */       if (bool && j > 0) i++;
/*     */     
/*     */     } 
/* 460 */     return i;
/*     */   }
/*     */   
/*     */   public int func_78263_a(char p_78263_1_) {
/* 464 */     if (p_78263_1_ == '§') {
/* 465 */       return -1;
/*     */     }
/*     */     
/* 468 */     if (p_78263_1_ == ' ') {
/* 469 */       return 4;
/*     */     }
/*     */     
/* 472 */     int i = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000".indexOf(p_78263_1_);
/* 473 */     if (p_78263_1_ > '\000' && i != -1 && !this.field_78293_l) {
/* 474 */       return this.field_78286_d[i];
/*     */     }
/*     */ 
/*     */     
/* 478 */     if (this.field_78287_e[p_78263_1_] != 0) {
/* 479 */       int j = this.field_78287_e[p_78263_1_] >>> 4;
/* 480 */       int k = this.field_78287_e[p_78263_1_] & 0xF;
/*     */       
/* 482 */       if (k > 7) {
/* 483 */         k = 15;
/* 484 */         j = 0;
/*     */       } 
/* 486 */       k++;
/*     */       
/* 488 */       return (k - j) / 2 + 1;
/*     */     } 
/*     */     
/* 491 */     return 0;
/*     */   }
/*     */   
/*     */   public String func_78269_a(String p_78269_1_, int p_78269_2_) {
/* 495 */     return func_78262_a(p_78269_1_, p_78269_2_, false);
/*     */   }
/*     */   
/*     */   public String func_78262_a(String p_78262_1_, int p_78262_2_, boolean p_78262_3_) {
/* 499 */     StringBuilder stringBuilder = new StringBuilder();
/* 500 */     int i = 0;
/* 501 */     byte b1 = p_78262_3_ ? (p_78262_1_.length() - 1) : 0;
/* 502 */     byte b2 = p_78262_3_ ? -1 : 1;
/* 503 */     boolean bool1 = false;
/* 504 */     boolean bool2 = false;
/*     */     int j;
/* 506 */     for (j = b1; j && j < p_78262_1_.length() && i < p_78262_2_; j += b2) {
/* 507 */       char c = p_78262_1_.charAt(j);
/* 508 */       int k = func_78263_a(c);
/*     */       
/* 510 */       if (bool1) {
/* 511 */         bool1 = false;
/*     */         
/* 513 */         if (c == 'l' || c == 'L') {
/* 514 */           bool2 = true;
/* 515 */         } else if (c == 'r' || c == 'R') {
/* 516 */           bool2 = false;
/*     */         } 
/* 518 */       } else if (k < 0) {
/* 519 */         bool1 = true;
/*     */       } else {
/* 521 */         i += k;
/* 522 */         if (bool2) i++;
/*     */       
/*     */       } 
/* 525 */       if (i > p_78262_2_)
/*     */         break; 
/* 527 */       if (p_78262_3_) {
/* 528 */         stringBuilder.insert(0, c);
/*     */       } else {
/* 530 */         stringBuilder.append(c);
/*     */       } 
/*     */     } 
/*     */     
/* 534 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String func_78273_d(String p_78273_1_) {
/* 545 */     while (p_78273_1_ != null && p_78273_1_.endsWith("\n")) {
/* 546 */       p_78273_1_ = p_78273_1_.substring(0, p_78273_1_.length() - 1);
/*     */     }
/* 548 */     return p_78273_1_;
/*     */   }
/*     */   
/*     */   public void func_78279_b(String p_78279_1_, int p_78279_2_, int p_78279_3_, int p_78279_4_, int p_78279_5_) {
/* 552 */     func_78265_b();
/* 553 */     this.field_78304_r = p_78279_5_;
/* 554 */     p_78279_1_ = func_78273_d(p_78279_1_);
/*     */     
/* 556 */     func_78268_b(p_78279_1_, p_78279_2_, p_78279_3_, p_78279_4_, false);
/*     */   }
/*     */   
/*     */   private void func_78268_b(String p_78268_1_, int p_78268_2_, int p_78268_3_, int p_78268_4_, boolean p_78268_5_) {
/* 560 */     List list = func_78271_c(p_78268_1_, p_78268_4_);
/* 561 */     for (String str : list) {
/* 562 */       func_78274_b(str, p_78268_2_, p_78268_3_, p_78268_4_, this.field_78304_r, p_78268_5_);
/* 563 */       p_78268_3_ += this.field_78288_b;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_78267_b(String p_78267_1_, int p_78267_2_) {
/* 568 */     return this.field_78288_b * func_78271_c(p_78267_1_, p_78267_2_).size();
/*     */   }
/*     */   
/*     */   public void func_78264_a(boolean p_78264_1_) {
/* 572 */     this.field_78293_l = p_78264_1_;
/*     */   }
/*     */   
/*     */   public boolean func_82883_a() {
/* 576 */     return this.field_78293_l;
/*     */   }
/*     */   
/*     */   public void func_78275_b(boolean p_78275_1_) {
/* 580 */     this.field_78294_m = p_78275_1_;
/*     */   }
/*     */   
/*     */   public List func_78271_c(String p_78271_1_, int p_78271_2_) {
/* 584 */     return Arrays.asList(func_78280_d(p_78271_1_, p_78271_2_).split("\n"));
/*     */   }
/*     */   
/*     */   String func_78280_d(String p_78280_1_, int p_78280_2_) {
/* 588 */     int i = func_78259_e(p_78280_1_, p_78280_2_);
/* 589 */     if (p_78280_1_.length() <= i) return p_78280_1_;
/*     */     
/* 591 */     String str1 = p_78280_1_.substring(0, i);
/*     */     
/* 593 */     char c = p_78280_1_.charAt(i);
/* 594 */     boolean bool = (c == ' ' || c == '\n') ? true : false;
/* 595 */     String str2 = func_78282_e(str1) + p_78280_1_.substring(i + (bool ? 1 : 0));
/*     */     
/* 597 */     return str1 + "\n" + func_78280_d(str2, p_78280_2_);
/*     */   }
/*     */   
/*     */   private int func_78259_e(String p_78259_1_, int p_78259_2_) {
/* 601 */     int i = p_78259_1_.length();
/* 602 */     int j = 0;
/* 603 */     byte b = 0;
/* 604 */     byte b1 = -1;
/* 605 */     boolean bool = false;
/*     */ 
/*     */     
/* 608 */     for (; b < i; b++) {
/* 609 */       char c = p_78259_1_.charAt(b);
/*     */       
/* 611 */       switch (c) {
/*     */         case '§':
/* 613 */           if (b < i - 1) {
/* 614 */             char c1 = p_78259_1_.charAt(++b);
/* 615 */             if (c1 == 'l' || c1 == 'L') {
/* 616 */               bool = true; break;
/* 617 */             }  if (c1 == 'r' || c1 == 'R' || func_78272_b(c1)) {
/* 618 */               bool = false;
/*     */             }
/*     */           } 
/*     */           break;
/*     */         case '\n':
/* 623 */           b--;
/*     */           break;
/*     */         case ' ':
/* 626 */           b1 = b;
/*     */         default:
/* 628 */           j += func_78263_a(c);
/* 629 */           if (bool) j++; 
/*     */           break;
/*     */       } 
/* 632 */       if (c == '\n') {
/* 633 */         b1 = ++b;
/*     */         
/*     */         break;
/*     */       } 
/* 637 */       if (j > p_78259_2_) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 642 */     if (b != i && b1 != -1 && b1 < b) {
/* 643 */       return b1;
/*     */     }
/* 645 */     return b;
/*     */   }
/*     */   
/*     */   private static boolean func_78272_b(char p_78272_0_) {
/* 649 */     return ((p_78272_0_ >= '0' && p_78272_0_ <= '9') || (p_78272_0_ >= 'a' && p_78272_0_ <= 'f') || (p_78272_0_ >= 'A' && p_78272_0_ <= 'F'));
/*     */   }
/*     */   
/*     */   private static boolean func_78270_c(char p_78270_0_) {
/* 653 */     return ((p_78270_0_ >= 'k' && p_78270_0_ <= 'o') || (p_78270_0_ >= 'K' && p_78270_0_ <= 'O') || p_78270_0_ == 'r' || p_78270_0_ == 'R');
/*     */   }
/*     */   
/*     */   private static String func_78282_e(String p_78282_0_) {
/* 657 */     String str = "";
/* 658 */     int i = -1;
/* 659 */     int j = p_78282_0_.length();
/*     */     
/* 661 */     while ((i = p_78282_0_.indexOf('§', i + 1)) != -1) {
/* 662 */       if (i < j - 1) {
/* 663 */         char c = p_78282_0_.charAt(i + 1);
/*     */         
/* 665 */         if (func_78272_b(c)) {
/* 666 */           str = "§" + c; continue;
/* 667 */         }  if (func_78270_c(c)) {
/* 668 */           str = str + "§" + c;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 673 */     return str;
/*     */   }
/*     */   
/*     */   public boolean func_78260_a() {
/* 677 */     return this.field_78294_m;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\FontRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */