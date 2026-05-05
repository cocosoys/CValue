/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.MapColor;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
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
/*     */ public class BlockFire
/*     */   extends Block
/*     */ {
/*  28 */   private int[] field_149849_a = new int[256];
/*  29 */   private int[] field_149848_b = new int[256]; @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149850_M;
/*     */   
/*     */   protected BlockFire() {
/*  33 */     super(Material.field_151581_o);
/*     */     
/*  35 */     func_149675_a(true);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000245";
/*     */   
/*     */   public static void func_149843_e() {
/*  40 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150344_f), 5, 20);
/*  41 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150373_bw), 5, 20);
/*  42 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150376_bx), 5, 20);
/*  43 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150422_aJ), 5, 20);
/*  44 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150476_ad), 5, 20);
/*  45 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150487_bG), 5, 20);
/*  46 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150485_bF), 5, 20);
/*  47 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150481_bH), 5, 20);
/*  48 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150364_r), 5, 5);
/*  49 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150363_s), 5, 5);
/*  50 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150362_t), 30, 60);
/*  51 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150361_u), 30, 60);
/*  52 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150342_X), 30, 20);
/*  53 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150335_W), 15, 100);
/*  54 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150329_H), 60, 100);
/*  55 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150398_cm), 60, 100);
/*  56 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150327_N), 60, 100);
/*  57 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150328_O), 60, 100);
/*  58 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150325_L), 30, 60);
/*  59 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150395_bd), 15, 100);
/*  60 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150402_ci), 5, 5);
/*  61 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150407_cf), 60, 20);
/*  62 */     Blocks.field_150480_ab.func_149842_a(func_149682_b(Blocks.field_150404_cg), 60, 20);
/*     */   }
/*     */   
/*     */   public void func_149842_a(int p_149842_1_, int p_149842_2_, int p_149842_3_) {
/*  66 */     this.field_149849_a[p_149842_1_] = p_149842_2_;
/*  67 */     this.field_149848_b[p_149842_1_] = p_149842_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  72 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  91 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/*  96 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/* 101 */     return 30;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 107 */     if (!p_149674_1_.func_82736_K().func_82766_b("doFireTick")) {
/*     */       return;
/*     */     }
/*     */     
/* 111 */     boolean bool = (p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - 1, p_149674_4_) == Blocks.field_150424_aL) ? true : false;
/* 112 */     if (p_149674_1_.field_73011_w instanceof net.minecraft.world.WorldProviderEnd && 
/* 113 */       p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - 1, p_149674_4_) == Blocks.field_150357_h) bool = true;
/*     */ 
/*     */     
/* 116 */     if (!func_149742_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
/* 117 */       p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
/*     */     }
/*     */     
/* 120 */     if (!bool && p_149674_1_.func_72896_J() && (
/* 121 */       p_149674_1_.func_72951_B(p_149674_2_, p_149674_3_, p_149674_4_) || p_149674_1_.func_72951_B(p_149674_2_ - 1, p_149674_3_, p_149674_4_) || p_149674_1_.func_72951_B(p_149674_2_ + 1, p_149674_3_, p_149674_4_) || p_149674_1_.func_72951_B(p_149674_2_, p_149674_3_, p_149674_4_ - 1) || p_149674_1_.func_72951_B(p_149674_2_, p_149674_3_, p_149674_4_ + 1))) {
/* 122 */       p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 127 */     int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/* 128 */     if (i < 15) {
/* 129 */       p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i + p_149674_5_.nextInt(3) / 2, 4);
/*     */     }
/* 131 */     p_149674_1_.func_147464_a(p_149674_2_, p_149674_3_, p_149674_4_, this, func_149738_a(p_149674_1_) + p_149674_5_.nextInt(10));
/*     */     
/* 133 */     if (!bool && !func_149847_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
/* 134 */       if (!World.func_147466_a((IBlockAccess)p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_) || i > 3) p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
/*     */       
/*     */       return;
/*     */     } 
/* 138 */     if (!bool && !func_149844_e((IBlockAccess)p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_) && 
/* 139 */       i == 15 && p_149674_5_.nextInt(4) == 0) {
/* 140 */       p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 145 */     boolean bool1 = p_149674_1_.func_72958_C(p_149674_2_, p_149674_3_, p_149674_4_);
/* 146 */     byte b = 0;
/* 147 */     if (bool1) {
/* 148 */       b = -50;
/*     */     }
/* 150 */     func_149841_a(p_149674_1_, p_149674_2_ + 1, p_149674_3_, p_149674_4_, 300 + b, p_149674_5_, i);
/* 151 */     func_149841_a(p_149674_1_, p_149674_2_ - 1, p_149674_3_, p_149674_4_, 300 + b, p_149674_5_, i);
/* 152 */     func_149841_a(p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_, 250 + b, p_149674_5_, i);
/* 153 */     func_149841_a(p_149674_1_, p_149674_2_, p_149674_3_ + 1, p_149674_4_, 250 + b, p_149674_5_, i);
/* 154 */     func_149841_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_ - 1, 300 + b, p_149674_5_, i);
/* 155 */     func_149841_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_ + 1, 300 + b, p_149674_5_, i);
/*     */     
/* 157 */     for (int j = p_149674_2_ - 1; j <= p_149674_2_ + 1; j++) {
/* 158 */       for (int k = p_149674_4_ - 1; k <= p_149674_4_ + 1; k++) {
/* 159 */         for (int m = p_149674_3_ - 1; m <= p_149674_3_ + 4; m++) {
/* 160 */           if (j != p_149674_2_ || m != p_149674_3_ || k != p_149674_4_) {
/*     */             
/* 162 */             int n = 100;
/* 163 */             if (m > p_149674_3_ + 1) {
/* 164 */               n += (m - p_149674_3_ + 1) * 100;
/*     */             }
/*     */             
/* 167 */             int i1 = func_149845_m(p_149674_1_, j, m, k);
/* 168 */             if (i1 > 0) {
/* 169 */               int i2 = (i1 + 40 + p_149674_1_.field_73013_u.func_151525_a() * 7) / (i + 30);
/* 170 */               if (bool1) {
/* 171 */                 i2 /= 2;
/*     */               }
/* 173 */               if (i2 > 0 && p_149674_5_.nextInt(n) <= i2 && (
/* 174 */                 !p_149674_1_.func_72896_J() || !p_149674_1_.func_72951_B(j, m, k)) && !p_149674_1_.func_72951_B(j - 1, m, p_149674_4_) && !p_149674_1_.func_72951_B(j + 1, m, k) && !p_149674_1_.func_72951_B(j, m, k - 1) && !p_149674_1_.func_72951_B(j, m, k + 1)) {
/*     */                 
/* 176 */                 int i3 = i + p_149674_5_.nextInt(5) / 4;
/* 177 */                 if (i3 > 15) i3 = 15; 
/* 178 */                 p_149674_1_.func_147465_d(j, m, k, this, i3, 3);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149698_L() {
/* 189 */     return false;
/*     */   }
/*     */   
/*     */   private void func_149841_a(World p_149841_1_, int p_149841_2_, int p_149841_3_, int p_149841_4_, int p_149841_5_, Random p_149841_6_, int p_149841_7_) {
/* 193 */     int i = this.field_149848_b[Block.func_149682_b(p_149841_1_.func_147439_a(p_149841_2_, p_149841_3_, p_149841_4_))];
/* 194 */     if (p_149841_6_.nextInt(p_149841_5_) < i) {
/* 195 */       boolean bool = (p_149841_1_.func_147439_a(p_149841_2_, p_149841_3_, p_149841_4_) == Blocks.field_150335_W) ? true : false;
/* 196 */       if (p_149841_6_.nextInt(p_149841_7_ + 10) < 5 && !p_149841_1_.func_72951_B(p_149841_2_, p_149841_3_, p_149841_4_)) {
/* 197 */         int j = p_149841_7_ + p_149841_6_.nextInt(5) / 4;
/* 198 */         if (j > 15) j = 15; 
/* 199 */         p_149841_1_.func_147465_d(p_149841_2_, p_149841_3_, p_149841_4_, this, j, 3);
/*     */       } else {
/* 201 */         p_149841_1_.func_147468_f(p_149841_2_, p_149841_3_, p_149841_4_);
/*     */       } 
/* 203 */       if (bool) {
/* 204 */         Blocks.field_150335_W.func_149664_b(p_149841_1_, p_149841_2_, p_149841_3_, p_149841_4_, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_149847_e(World p_149847_1_, int p_149847_2_, int p_149847_3_, int p_149847_4_) {
/* 210 */     if (func_149844_e((IBlockAccess)p_149847_1_, p_149847_2_ + 1, p_149847_3_, p_149847_4_)) return true; 
/* 211 */     if (func_149844_e((IBlockAccess)p_149847_1_, p_149847_2_ - 1, p_149847_3_, p_149847_4_)) return true; 
/* 212 */     if (func_149844_e((IBlockAccess)p_149847_1_, p_149847_2_, p_149847_3_ - 1, p_149847_4_)) return true; 
/* 213 */     if (func_149844_e((IBlockAccess)p_149847_1_, p_149847_2_, p_149847_3_ + 1, p_149847_4_)) return true; 
/* 214 */     if (func_149844_e((IBlockAccess)p_149847_1_, p_149847_2_, p_149847_3_, p_149847_4_ - 1)) return true; 
/* 215 */     if (func_149844_e((IBlockAccess)p_149847_1_, p_149847_2_, p_149847_3_, p_149847_4_ + 1)) return true;
/*     */     
/* 217 */     return false;
/*     */   }
/*     */   
/*     */   private int func_149845_m(World p_149845_1_, int p_149845_2_, int p_149845_3_, int p_149845_4_) {
/* 221 */     int i = 0;
/* 222 */     if (!p_149845_1_.func_147437_c(p_149845_2_, p_149845_3_, p_149845_4_)) return 0;
/*     */     
/* 224 */     i = func_149846_a(p_149845_1_, p_149845_2_ + 1, p_149845_3_, p_149845_4_, i);
/* 225 */     i = func_149846_a(p_149845_1_, p_149845_2_ - 1, p_149845_3_, p_149845_4_, i);
/* 226 */     i = func_149846_a(p_149845_1_, p_149845_2_, p_149845_3_ - 1, p_149845_4_, i);
/* 227 */     i = func_149846_a(p_149845_1_, p_149845_2_, p_149845_3_ + 1, p_149845_4_, i);
/* 228 */     i = func_149846_a(p_149845_1_, p_149845_2_, p_149845_3_, p_149845_4_ - 1, i);
/* 229 */     i = func_149846_a(p_149845_1_, p_149845_2_, p_149845_3_, p_149845_4_ + 1, i);
/*     */     
/* 231 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149703_v() {
/* 236 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149844_e(IBlockAccess p_149844_1_, int p_149844_2_, int p_149844_3_, int p_149844_4_) {
/* 240 */     return (this.field_149849_a[Block.func_149682_b(p_149844_1_.func_147439_a(p_149844_2_, p_149844_3_, p_149844_4_))] > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149846_a(World p_149846_1_, int p_149846_2_, int p_149846_3_, int p_149846_4_, int p_149846_5_) {
/* 245 */     int i = this.field_149849_a[Block.func_149682_b(p_149846_1_.func_147439_a(p_149846_2_, p_149846_3_, p_149846_4_))];
/* 246 */     if (i > p_149846_5_) return i; 
/* 247 */     return p_149846_5_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 252 */     return (World.func_147466_a((IBlockAccess)p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) || func_149847_e(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 257 */     if (!World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_) && !func_149847_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
/* 258 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 264 */     if (p_149726_1_.field_73011_w.field_76574_g <= 0 && 
/* 265 */       Blocks.field_150427_aO.func_150000_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_)) {
/*     */       return;
/*     */     }
/*     */     
/* 269 */     if (!World.func_147466_a((IBlockAccess)p_149726_1_, p_149726_2_, p_149726_3_ - 1, p_149726_4_) && !func_149847_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_)) {
/* 270 */       p_149726_1_.func_147468_f(p_149726_2_, p_149726_3_, p_149726_4_);
/*     */       
/*     */       return;
/*     */     } 
/* 274 */     p_149726_1_.func_147464_a(p_149726_2_, p_149726_3_, p_149726_4_, this, func_149738_a(p_149726_1_) + p_149726_1_.field_73012_v.nextInt(10));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 283 */     if (p_149734_5_.nextInt(24) == 0) {
/* 284 */       p_149734_1_.func_72980_b((p_149734_2_ + 0.5F), (p_149734_3_ + 0.5F), (p_149734_4_ + 0.5F), "fire.fire", 1.0F + p_149734_5_.nextFloat(), p_149734_5_.nextFloat() * 0.7F + 0.3F, false);
/*     */     }
/*     */     
/* 287 */     if (World.func_147466_a((IBlockAccess)p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) || Blocks.field_150480_ab.func_149844_e((IBlockAccess)p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_)) {
/* 288 */       for (byte b = 0; b < 3; b++) {
/* 289 */         float f1 = p_149734_2_ + p_149734_5_.nextFloat();
/* 290 */         float f2 = p_149734_3_ + p_149734_5_.nextFloat() * 0.5F + 0.5F;
/* 291 */         float f3 = p_149734_4_ + p_149734_5_.nextFloat();
/* 292 */         p_149734_1_.func_72869_a("largesmoke", f1, f2, f3, 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */     } else {
/* 295 */       if (Blocks.field_150480_ab.func_149844_e((IBlockAccess)p_149734_1_, p_149734_2_ - 1, p_149734_3_, p_149734_4_)) {
/* 296 */         for (byte b = 0; b < 2; b++) {
/* 297 */           float f1 = p_149734_2_ + p_149734_5_.nextFloat() * 0.1F;
/* 298 */           float f2 = p_149734_3_ + p_149734_5_.nextFloat();
/* 299 */           float f3 = p_149734_4_ + p_149734_5_.nextFloat();
/* 300 */           p_149734_1_.func_72869_a("largesmoke", f1, f2, f3, 0.0D, 0.0D, 0.0D);
/*     */         } 
/*     */       }
/* 303 */       if (Blocks.field_150480_ab.func_149844_e((IBlockAccess)p_149734_1_, p_149734_2_ + 1, p_149734_3_, p_149734_4_)) {
/* 304 */         for (byte b = 0; b < 2; b++) {
/* 305 */           float f1 = (p_149734_2_ + 1) - p_149734_5_.nextFloat() * 0.1F;
/* 306 */           float f2 = p_149734_3_ + p_149734_5_.nextFloat();
/* 307 */           float f3 = p_149734_4_ + p_149734_5_.nextFloat();
/* 308 */           p_149734_1_.func_72869_a("largesmoke", f1, f2, f3, 0.0D, 0.0D, 0.0D);
/*     */         } 
/*     */       }
/* 311 */       if (Blocks.field_150480_ab.func_149844_e((IBlockAccess)p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_ - 1)) {
/* 312 */         for (byte b = 0; b < 2; b++) {
/* 313 */           float f1 = p_149734_2_ + p_149734_5_.nextFloat();
/* 314 */           float f2 = p_149734_3_ + p_149734_5_.nextFloat();
/* 315 */           float f3 = p_149734_4_ + p_149734_5_.nextFloat() * 0.1F;
/* 316 */           p_149734_1_.func_72869_a("largesmoke", f1, f2, f3, 0.0D, 0.0D, 0.0D);
/*     */         } 
/*     */       }
/* 319 */       if (Blocks.field_150480_ab.func_149844_e((IBlockAccess)p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_ + 1)) {
/* 320 */         for (byte b = 0; b < 2; b++) {
/* 321 */           float f1 = p_149734_2_ + p_149734_5_.nextFloat();
/* 322 */           float f2 = p_149734_3_ + p_149734_5_.nextFloat();
/* 323 */           float f3 = (p_149734_4_ + 1) - p_149734_5_.nextFloat() * 0.1F;
/* 324 */           p_149734_1_.func_72869_a("largesmoke", f1, f2, f3, 0.0D, 0.0D, 0.0D);
/*     */         } 
/*     */       }
/* 327 */       if (Blocks.field_150480_ab.func_149844_e((IBlockAccess)p_149734_1_, p_149734_2_, p_149734_3_ + 1, p_149734_4_)) {
/* 328 */         for (byte b = 0; b < 2; b++) {
/* 329 */           float f1 = p_149734_2_ + p_149734_5_.nextFloat();
/* 330 */           float f2 = (p_149734_3_ + 1) - p_149734_5_.nextFloat() * 0.1F;
/* 331 */           float f3 = p_149734_4_ + p_149734_5_.nextFloat();
/* 332 */           p_149734_1_.func_72869_a("largesmoke", f1, f2, f3, 0.0D, 0.0D, 0.0D);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 340 */     this.field_149850_M = new IIcon[] { p_149651_1_.func_94245_a(func_149641_N() + "_layer_0"), p_149651_1_.func_94245_a(func_149641_N() + "_layer_1") };
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149840_c(int p_149840_1_) {
/* 346 */     return this.field_149850_M[p_149840_1_];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 351 */     return this.field_149850_M[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public MapColor func_149728_f(int p_149728_1_) {
/* 356 */     return MapColor.field_151656_f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockFire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */