/*      */ package net.minecraft.world.chunk;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.ITileEntityProvider;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.command.IEntitySelector;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.crash.CrashReportCategory;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.ChunkCoordIntPair;
/*      */ import net.minecraft.world.ChunkPosition;
/*      */ import net.minecraft.world.EnumSkyBlock;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ import net.minecraft.world.biome.WorldChunkManager;
/*      */ import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
/*      */ 
/*      */ public class Chunk {
/*   25 */   private static final Logger field_150817_t = LogManager.getLogger();
/*      */ 
/*      */   
/*      */   public static boolean field_76640_a;
/*      */   
/*   30 */   private ExtendedBlockStorage[] field_76652_q = new ExtendedBlockStorage[16];
/*   31 */   private byte[] field_76651_r = new byte[256];
/*   32 */   public int[] field_76638_b = new int[256];
/*   33 */   public boolean[] field_76639_c = new boolean[256];
/*      */   public boolean field_76636_d;
/*      */   public World field_76637_e;
/*      */   public int[] field_76634_f;
/*      */   public final int field_76635_g;
/*      */   public final int field_76647_h;
/*      */   private boolean field_76650_s;
/*   40 */   public Map field_150816_i = new HashMap<Object, Object>();
/*      */   
/*      */   public List[] field_76645_j;
/*      */   
/*      */   public boolean field_76646_k;
/*      */   
/*      */   public boolean field_150814_l;
/*      */   public boolean field_150815_m;
/*      */   public boolean field_76643_l;
/*      */   public boolean field_76644_m;
/*      */   public long field_76641_n;
/*      */   public boolean field_76642_o;
/*      */   public int field_82912_p;
/*      */   public long field_111204_q;
/*   54 */   private int field_76649_t = 4096; private static final String __OBFID = "CL_00000373";
/*      */   
/*      */   public Chunk(World p_i1995_1_, int p_i1995_2_, int p_i1995_3_) {
/*   57 */     this.field_76645_j = new List[16];
/*   58 */     this.field_76637_e = p_i1995_1_;
/*   59 */     this.field_76635_g = p_i1995_2_;
/*   60 */     this.field_76647_h = p_i1995_3_;
/*   61 */     this.field_76634_f = new int[256];
/*   62 */     for (byte b = 0; b < this.field_76645_j.length; b++) {
/*   63 */       this.field_76645_j[b] = new ArrayList();
/*      */     }
/*   65 */     Arrays.fill(this.field_76638_b, -999);
/*   66 */     Arrays.fill(this.field_76651_r, (byte)-1);
/*      */   }
/*      */   
/*      */   public Chunk(World p_i45446_1_, Block[] p_i45446_2_, int p_i45446_3_, int p_i45446_4_) {
/*   70 */     this(p_i45446_1_, p_i45446_3_, p_i45446_4_);
/*      */     
/*   72 */     int i = p_i45446_2_.length / 256;
/*   73 */     boolean bool = !p_i45446_1_.field_73011_w.field_76576_e ? true : false;
/*   74 */     for (byte b = 0; b < 16; b++) {
/*   75 */       for (byte b1 = 0; b1 < 16; b1++) {
/*   76 */         for (byte b2 = 0; b2 < i; b2++) {
/*   77 */           Block block = p_i45446_2_[b << 11 | b1 << 7 | b2];
/*      */ 
/*      */           
/*   80 */           if (block != null && block.func_149688_o() != Material.field_151579_a) {
/*      */ 
/*      */ 
/*      */             
/*   84 */             int j = b2 >> 4;
/*   85 */             if (this.field_76652_q[j] == null) {
/*   86 */               this.field_76652_q[j] = new ExtendedBlockStorage(j << 4, bool);
/*      */             }
/*   88 */             this.field_76652_q[j].func_150818_a(b, b2 & 0xF, b1, block);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public Chunk(World p_i45447_1_, Block[] p_i45447_2_, byte[] p_i45447_3_, int p_i45447_4_, int p_i45447_5_) {
/*   95 */     this(p_i45447_1_, p_i45447_4_, p_i45447_5_);
/*      */     
/*   97 */     int i = p_i45447_2_.length / 256;
/*   98 */     boolean bool = !p_i45447_1_.field_73011_w.field_76576_e ? true : false;
/*   99 */     for (byte b = 0; b < 16; b++) {
/*  100 */       for (byte b1 = 0; b1 < 16; b1++) {
/*  101 */         for (byte b2 = 0; b2 < i; b2++) {
/*  102 */           int j = b * i * 16 | b1 * i | b2;
/*  103 */           Block block = p_i45447_2_[j];
/*      */           
/*  105 */           if (block != null && block != Blocks.field_150350_a) {
/*      */ 
/*      */ 
/*      */             
/*  109 */             int k = b2 >> 4;
/*  110 */             if (this.field_76652_q[k] == null) {
/*  111 */               this.field_76652_q[k] = new ExtendedBlockStorage(k << 4, bool);
/*      */             }
/*  113 */             this.field_76652_q[k].func_150818_a(b, b2 & 0xF, b1, block);
/*  114 */             this.field_76652_q[k].func_76654_b(b, b2 & 0xF, b1, p_i45447_3_[j]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public boolean func_76600_a(int p_76600_1_, int p_76600_2_) {
/*  121 */     return (p_76600_1_ == this.field_76635_g && p_76600_2_ == this.field_76647_h);
/*      */   }
/*      */   
/*      */   public int func_76611_b(int p_76611_1_, int p_76611_2_) {
/*  125 */     return this.field_76634_f[p_76611_2_ << 4 | p_76611_1_];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_76625_h() {
/*  139 */     for (int i = this.field_76652_q.length - 1; i >= 0; i--) {
/*  140 */       if (this.field_76652_q[i] != null) {
/*  141 */         return this.field_76652_q[i].func_76662_d();
/*      */       }
/*      */     } 
/*  144 */     return 0;
/*      */   }
/*      */   
/*      */   public ExtendedBlockStorage[] func_76587_i() {
/*  148 */     return this.field_76652_q;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_76590_a() {
/*  152 */     int i = func_76625_h();
/*  153 */     this.field_82912_p = Integer.MAX_VALUE;
/*      */     
/*  155 */     for (byte b = 0; b < 16; b++) {
/*  156 */       for (byte b1 = 0; b1 < 16; b1++) {
/*  157 */         this.field_76638_b[b + (b1 << 4)] = -999;
/*      */         
/*  159 */         for (int j = i + 16 - 1; j > 0; j--) {
/*  160 */           Block block = func_150810_a(b, j - 1, b1);
/*  161 */           if (block.func_149717_k() != 0) {
/*  162 */             this.field_76634_f[b1 << 4 | b] = j;
/*  163 */             if (j < this.field_82912_p) this.field_82912_p = j;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  170 */     this.field_76643_l = true;
/*      */   }
/*      */   
/*      */   public void func_76603_b() {
/*  174 */     int i = func_76625_h();
/*  175 */     this.field_82912_p = Integer.MAX_VALUE;
/*      */     
/*  177 */     for (byte b = 0; b < 16; b++) {
/*  178 */       for (byte b1 = 0; b1 < 16; b1++) {
/*  179 */         this.field_76638_b[b + (b1 << 4)] = -999;
/*      */         int j;
/*  181 */         for (j = i + 16 - 1; j > 0; j--) {
/*  182 */           if (func_150808_b(b, j - 1, b1) != 0) {
/*  183 */             this.field_76634_f[b1 << 4 | b] = j;
/*  184 */             if (j < this.field_82912_p) this.field_82912_p = j;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*  189 */         if (!this.field_76637_e.field_73011_w.field_76576_e) {
/*  190 */           j = 15;
/*  191 */           int k = i + 16 - 1;
/*      */           do {
/*  193 */             int m = func_150808_b(b, k, b1);
/*  194 */             if (m == 0 && j != 15) m = 1; 
/*  195 */             j -= m;
/*      */             
/*  197 */             if (j <= 0)
/*  198 */               continue;  ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[k >> 4];
/*  199 */             if (extendedBlockStorage == null)
/*  200 */               continue;  extendedBlockStorage.func_76657_c(b, k & 0xF, b1, j);
/*  201 */             this.field_76637_e.func_147479_m((this.field_76635_g << 4) + b, k, (this.field_76647_h << 4) + b1);
/*      */ 
/*      */             
/*  204 */             --k;
/*  205 */           } while (k > 0 && j > 0);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  210 */     this.field_76643_l = true;
/*      */   }
/*      */   
/*      */   private void func_76595_e(int p_76595_1_, int p_76595_2_) {
/*  214 */     this.field_76639_c[p_76595_1_ + p_76595_2_ * 16] = true;
/*  215 */     this.field_76650_s = true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void func_150803_c(boolean p_150803_1_) {
/*  221 */     this.field_76637_e.field_72984_F.func_76320_a("recheckGaps");
/*  222 */     if (this.field_76637_e.func_72873_a(this.field_76635_g * 16 + 8, 0, this.field_76647_h * 16 + 8, 16)) {
/*  223 */       for (byte b = 0; b < 16; b++) {
/*  224 */         for (byte b1 = 0; b1 < 16; b1++) {
/*  225 */           if (this.field_76639_c[b + b1 * 16]) {
/*  226 */             this.field_76639_c[b + b1 * 16] = false;
/*  227 */             int i = func_76611_b(b, b1);
/*  228 */             int j = this.field_76635_g * 16 + b;
/*  229 */             int k = this.field_76647_h * 16 + b1;
/*      */             
/*  231 */             int m = this.field_76637_e.func_82734_g(j - 1, k);
/*  232 */             int n = this.field_76637_e.func_82734_g(j + 1, k);
/*  233 */             int i1 = this.field_76637_e.func_82734_g(j, k - 1);
/*  234 */             int i2 = this.field_76637_e.func_82734_g(j, k + 1);
/*  235 */             if (n < m) m = n; 
/*  236 */             if (i1 < m) m = i1; 
/*  237 */             if (i2 < m) m = i2; 
/*  238 */             func_76599_g(j, k, m);
/*  239 */             func_76599_g(j - 1, k, i);
/*  240 */             func_76599_g(j + 1, k, i);
/*  241 */             func_76599_g(j, k - 1, i);
/*  242 */             func_76599_g(j, k + 1, i);
/*      */             
/*  244 */             if (p_150803_1_) {
/*  245 */               this.field_76637_e.field_72984_F.func_76319_b();
/*      */               return;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*  251 */       this.field_76650_s = false;
/*      */     } 
/*  253 */     this.field_76637_e.field_72984_F.func_76319_b();
/*      */   }
/*      */   
/*      */   private void func_76599_g(int p_76599_1_, int p_76599_2_, int p_76599_3_) {
/*  257 */     int i = this.field_76637_e.func_72976_f(p_76599_1_, p_76599_2_);
/*      */     
/*  259 */     if (i > p_76599_3_) {
/*  260 */       func_76609_d(p_76599_1_, p_76599_2_, p_76599_3_, i + 1);
/*  261 */     } else if (i < p_76599_3_) {
/*  262 */       func_76609_d(p_76599_1_, p_76599_2_, i, p_76599_3_ + 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void func_76609_d(int p_76609_1_, int p_76609_2_, int p_76609_3_, int p_76609_4_) {
/*  267 */     if (p_76609_4_ > p_76609_3_ && 
/*  268 */       this.field_76637_e.func_72873_a(p_76609_1_, 0, p_76609_2_, 16)) {
/*  269 */       for (int i = p_76609_3_; i < p_76609_4_; i++) {
/*  270 */         this.field_76637_e.func_147463_c(EnumSkyBlock.Sky, p_76609_1_, i, p_76609_2_);
/*      */       }
/*  272 */       this.field_76643_l = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void func_76615_h(int p_76615_1_, int p_76615_2_, int p_76615_3_) {
/*  278 */     int i = this.field_76634_f[p_76615_3_ << 4 | p_76615_1_] & 0xFF;
/*  279 */     int j = i;
/*  280 */     if (p_76615_2_ > i) j = p_76615_2_;
/*      */     
/*  282 */     while (j > 0 && func_150808_b(p_76615_1_, j - 1, p_76615_3_) == 0)
/*  283 */       j--; 
/*  284 */     if (j == i)
/*      */       return; 
/*  286 */     this.field_76637_e.func_72975_g(p_76615_1_ + this.field_76635_g * 16, p_76615_3_ + this.field_76647_h * 16, j, i);
/*  287 */     this.field_76634_f[p_76615_3_ << 4 | p_76615_1_] = j;
/*      */     
/*  289 */     int k = this.field_76635_g * 16 + p_76615_1_;
/*  290 */     int m = this.field_76647_h * 16 + p_76615_3_;
/*  291 */     if (!this.field_76637_e.field_73011_w.field_76576_e) {
/*  292 */       if (j < i) {
/*  293 */         for (int i4 = j; i4 < i; i4++) {
/*  294 */           ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[i4 >> 4];
/*  295 */           if (extendedBlockStorage != null) {
/*  296 */             extendedBlockStorage.func_76657_c(p_76615_1_, i4 & 0xF, p_76615_3_, 15);
/*  297 */             this.field_76637_e.func_147479_m((this.field_76635_g << 4) + p_76615_1_, i4, (this.field_76647_h << 4) + p_76615_3_);
/*      */           } 
/*      */         } 
/*      */       } else {
/*  301 */         for (int i4 = i; i4 < j; i4++) {
/*  302 */           ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[i4 >> 4];
/*  303 */           if (extendedBlockStorage != null) {
/*  304 */             extendedBlockStorage.func_76657_c(p_76615_1_, i4 & 0xF, p_76615_3_, 0);
/*  305 */             this.field_76637_e.func_147479_m((this.field_76635_g << 4) + p_76615_1_, i4, (this.field_76647_h << 4) + p_76615_3_);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  310 */       int i3 = 15;
/*  311 */       while (j > 0 && i3 > 0) {
/*  312 */         j--;
/*  313 */         int i4 = func_150808_b(p_76615_1_, j, p_76615_3_);
/*  314 */         if (i4 == 0) i4 = 1; 
/*  315 */         i3 -= i4;
/*  316 */         if (i3 < 0) i3 = 0;
/*      */         
/*  318 */         ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[j >> 4];
/*  319 */         if (extendedBlockStorage != null) {
/*  320 */           extendedBlockStorage.func_76657_c(p_76615_1_, j & 0xF, p_76615_3_, i3);
/*      */         }
/*      */       } 
/*      */     } 
/*  324 */     int n = this.field_76634_f[p_76615_3_ << 4 | p_76615_1_];
/*  325 */     int i1 = i;
/*  326 */     int i2 = n;
/*  327 */     if (i2 < i1) {
/*  328 */       int i3 = i1;
/*  329 */       i1 = i2;
/*  330 */       i2 = i3;
/*      */     } 
/*  332 */     if (n < this.field_82912_p) this.field_82912_p = n; 
/*  333 */     if (!this.field_76637_e.field_73011_w.field_76576_e) {
/*  334 */       func_76609_d(k - 1, m, i1, i2);
/*  335 */       func_76609_d(k + 1, m, i1, i2);
/*  336 */       func_76609_d(k, m - 1, i1, i2);
/*  337 */       func_76609_d(k, m + 1, i1, i2);
/*  338 */       func_76609_d(k, m, i1, i2);
/*      */     } 
/*      */     
/*  341 */     this.field_76643_l = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_150808_b(int p_150808_1_, int p_150808_2_, int p_150808_3_) {
/*  354 */     return func_150810_a(p_150808_1_, p_150808_2_, p_150808_3_).func_149717_k();
/*      */   }
/*      */   
/*      */   public Block func_150810_a(int p_150810_1_, int p_150810_2_, int p_150810_3_) {
/*  358 */     Block block = Blocks.field_150350_a;
/*  359 */     if (p_150810_2_ >> 4 < this.field_76652_q.length) {
/*  360 */       ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[p_150810_2_ >> 4];
/*  361 */       if (extendedBlockStorage != null) {
/*      */         try {
/*  363 */           block = extendedBlockStorage.func_150819_a(p_150810_1_, p_150810_2_ & 0xF, p_150810_3_);
/*  364 */         } catch (Throwable throwable) {
/*  365 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Getting block");
/*  366 */           CrashReportCategory crashReportCategory = crashReport.func_85058_a("Block being got");
/*      */           
/*  368 */           crashReportCategory.func_71500_a("Location", new Callable(this, p_150810_1_, p_150810_2_, p_150810_3_) { private static final String __OBFID = "CL_00000374";
/*      */                 
/*      */                 public String call() {
/*  371 */                   return CrashReportCategory.func_85071_a(this.field_150824_a, this.field_150822_b, this.field_150823_c);
/*      */                 } }
/*      */             );
/*      */           
/*  375 */           throw new ReportedException(crashReport);
/*      */         } 
/*      */       }
/*      */     } 
/*  379 */     return block;
/*      */   }
/*      */   
/*      */   public int func_76628_c(int p_76628_1_, int p_76628_2_, int p_76628_3_) {
/*  383 */     if (p_76628_2_ >> 4 >= this.field_76652_q.length) return 0; 
/*  384 */     ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[p_76628_2_ >> 4];
/*  385 */     if (extendedBlockStorage != null) {
/*  386 */       return extendedBlockStorage.func_76665_b(p_76628_1_, p_76628_2_ & 0xF, p_76628_3_);
/*      */     }
/*  388 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_150807_a(int p_150807_1_, int p_150807_2_, int p_150807_3_, Block p_150807_4_, int p_150807_5_) {
/*  396 */     int i = p_150807_3_ << 4 | p_150807_1_;
/*      */     
/*  398 */     if (p_150807_2_ >= this.field_76638_b[i] - 1) {
/*  399 */       this.field_76638_b[i] = -999;
/*      */     }
/*      */     
/*  402 */     int j = this.field_76634_f[i];
/*      */     
/*  404 */     Block block = func_150810_a(p_150807_1_, p_150807_2_, p_150807_3_);
/*  405 */     int k = func_76628_c(p_150807_1_, p_150807_2_, p_150807_3_);
/*  406 */     if (block == p_150807_4_ && k == p_150807_5_) return false;
/*      */     
/*  408 */     ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[p_150807_2_ >> 4];
/*  409 */     boolean bool = false;
/*  410 */     if (extendedBlockStorage == null) {
/*      */       
/*  412 */       if (p_150807_4_ == Blocks.field_150350_a) {
/*  413 */         return false;
/*      */       }
/*      */       
/*  416 */       extendedBlockStorage = this.field_76652_q[p_150807_2_ >> 4] = new ExtendedBlockStorage(p_150807_2_ >> 4 << 4, !this.field_76637_e.field_73011_w.field_76576_e);
/*  417 */       bool = (p_150807_2_ >= j) ? true : false;
/*      */     } 
/*      */     
/*  420 */     int m = this.field_76635_g * 16 + p_150807_1_;
/*  421 */     int n = this.field_76647_h * 16 + p_150807_3_;
/*  422 */     if (!this.field_76637_e.field_72995_K) {
/*  423 */       block.func_149725_f(this.field_76637_e, m, p_150807_2_, n, k);
/*      */     }
/*      */     
/*  426 */     extendedBlockStorage.func_150818_a(p_150807_1_, p_150807_2_ & 0xF, p_150807_3_, p_150807_4_);
/*  427 */     if (!this.field_76637_e.field_72995_K) {
/*  428 */       block.func_149749_a(this.field_76637_e, m, p_150807_2_, n, block, k);
/*  429 */     } else if (block instanceof ITileEntityProvider && block != p_150807_4_) {
/*  430 */       this.field_76637_e.func_147475_p(m, p_150807_2_, n);
/*      */     } 
/*      */     
/*  433 */     if (extendedBlockStorage.func_150819_a(p_150807_1_, p_150807_2_ & 0xF, p_150807_3_) != p_150807_4_) return false;
/*      */     
/*  435 */     extendedBlockStorage.func_76654_b(p_150807_1_, p_150807_2_ & 0xF, p_150807_3_, p_150807_5_);
/*      */     
/*  437 */     if (bool) {
/*  438 */       func_76603_b();
/*      */     } else {
/*  440 */       int i1 = p_150807_4_.func_149717_k();
/*  441 */       int i2 = block.func_149717_k();
/*      */       
/*  443 */       if (i1 > 0) {
/*  444 */         if (p_150807_2_ >= j) {
/*  445 */           func_76615_h(p_150807_1_, p_150807_2_ + 1, p_150807_3_);
/*      */         }
/*      */       }
/*  448 */       else if (p_150807_2_ == j - 1) {
/*  449 */         func_76615_h(p_150807_1_, p_150807_2_, p_150807_3_);
/*      */       } 
/*      */ 
/*      */       
/*  453 */       if (i1 != i2)
/*      */       {
/*  455 */         if (i1 < i2 || func_76614_a(EnumSkyBlock.Sky, p_150807_1_, p_150807_2_, p_150807_3_) > 0 || func_76614_a(EnumSkyBlock.Block, p_150807_1_, p_150807_2_, p_150807_3_) > 0) {
/*  456 */           func_76595_e(p_150807_1_, p_150807_3_);
/*      */         }
/*      */       }
/*      */     } 
/*      */     
/*  461 */     if (block instanceof ITileEntityProvider) {
/*  462 */       TileEntity tileEntity = func_150806_e(p_150807_1_, p_150807_2_, p_150807_3_);
/*  463 */       if (tileEntity != null) {
/*  464 */         tileEntity.func_145836_u();
/*      */       }
/*      */     } 
/*      */     
/*  468 */     if (!this.field_76637_e.field_72995_K) p_150807_4_.func_149726_b(this.field_76637_e, m, p_150807_2_, n); 
/*  469 */     if (p_150807_4_ instanceof ITileEntityProvider) {
/*  470 */       TileEntity tileEntity = func_150806_e(p_150807_1_, p_150807_2_, p_150807_3_);
/*  471 */       if (tileEntity == null) {
/*  472 */         tileEntity = ((ITileEntityProvider)p_150807_4_).func_149915_a(this.field_76637_e, p_150807_5_);
/*  473 */         this.field_76637_e.func_147455_a(m, p_150807_2_, n, tileEntity);
/*      */       } 
/*      */       
/*  476 */       if (tileEntity != null) {
/*  477 */         tileEntity.func_145836_u();
/*      */       }
/*      */     } 
/*      */     
/*  481 */     this.field_76643_l = true;
/*  482 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_76589_b(int p_76589_1_, int p_76589_2_, int p_76589_3_, int p_76589_4_) {
/*  487 */     ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[p_76589_2_ >> 4];
/*  488 */     if (extendedBlockStorage == null) {
/*  489 */       return false;
/*      */     }
/*      */     
/*  492 */     int i = extendedBlockStorage.func_76665_b(p_76589_1_, p_76589_2_ & 0xF, p_76589_3_);
/*  493 */     if (i == p_76589_4_) {
/*  494 */       return false;
/*      */     }
/*      */     
/*  497 */     this.field_76643_l = true;
/*  498 */     extendedBlockStorage.func_76654_b(p_76589_1_, p_76589_2_ & 0xF, p_76589_3_, p_76589_4_);
/*  499 */     if (extendedBlockStorage.func_150819_a(p_76589_1_, p_76589_2_ & 0xF, p_76589_3_) instanceof ITileEntityProvider) {
/*  500 */       TileEntity tileEntity = func_150806_e(p_76589_1_, p_76589_2_, p_76589_3_);
/*  501 */       if (tileEntity != null) {
/*  502 */         tileEntity.func_145836_u();
/*  503 */         tileEntity.field_145847_g = p_76589_4_;
/*      */       } 
/*      */     } 
/*  506 */     return true;
/*      */   }
/*      */   
/*      */   public int func_76614_a(EnumSkyBlock p_76614_1_, int p_76614_2_, int p_76614_3_, int p_76614_4_) {
/*  510 */     ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[p_76614_3_ >> 4];
/*  511 */     if (extendedBlockStorage == null) {
/*  512 */       if (func_76619_d(p_76614_2_, p_76614_3_, p_76614_4_)) {
/*  513 */         return p_76614_1_.field_77198_c;
/*      */       }
/*  515 */       return 0;
/*      */     } 
/*      */ 
/*      */     
/*  519 */     if (p_76614_1_ == EnumSkyBlock.Sky) {
/*  520 */       if (this.field_76637_e.field_73011_w.field_76576_e) {
/*  521 */         return 0;
/*      */       }
/*  523 */       return extendedBlockStorage.func_76670_c(p_76614_2_, p_76614_3_ & 0xF, p_76614_4_);
/*  524 */     }  if (p_76614_1_ == EnumSkyBlock.Block) return extendedBlockStorage.func_76674_d(p_76614_2_, p_76614_3_ & 0xF, p_76614_4_); 
/*  525 */     return p_76614_1_.field_77198_c;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_76633_a(EnumSkyBlock p_76633_1_, int p_76633_2_, int p_76633_3_, int p_76633_4_, int p_76633_5_) {
/*  530 */     ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[p_76633_3_ >> 4];
/*  531 */     if (extendedBlockStorage == null) {
/*  532 */       extendedBlockStorage = this.field_76652_q[p_76633_3_ >> 4] = new ExtendedBlockStorage(p_76633_3_ >> 4 << 4, !this.field_76637_e.field_73011_w.field_76576_e);
/*  533 */       func_76603_b();
/*      */     } 
/*      */     
/*  536 */     this.field_76643_l = true;
/*  537 */     if (p_76633_1_ == EnumSkyBlock.Sky) {
/*  538 */       if (!this.field_76637_e.field_73011_w.field_76576_e) {
/*  539 */         extendedBlockStorage.func_76657_c(p_76633_2_, p_76633_3_ & 0xF, p_76633_4_, p_76633_5_);
/*      */       }
/*      */     }
/*  542 */     else if (p_76633_1_ == EnumSkyBlock.Block) {
/*  543 */       extendedBlockStorage.func_76677_d(p_76633_2_, p_76633_3_ & 0xF, p_76633_4_, p_76633_5_);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int func_76629_c(int p_76629_1_, int p_76629_2_, int p_76629_3_, int p_76629_4_) {
/*  548 */     ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[p_76629_2_ >> 4];
/*  549 */     if (extendedBlockStorage == null) {
/*  550 */       if (!this.field_76637_e.field_73011_w.field_76576_e && p_76629_4_ < EnumSkyBlock.Sky.field_77198_c) {
/*  551 */         return EnumSkyBlock.Sky.field_77198_c - p_76629_4_;
/*      */       }
/*  553 */       return 0;
/*      */     } 
/*      */     
/*  556 */     int i = this.field_76637_e.field_73011_w.field_76576_e ? 0 : extendedBlockStorage.func_76670_c(p_76629_1_, p_76629_2_ & 0xF, p_76629_3_);
/*  557 */     if (i) field_76640_a = true; 
/*  558 */     i -= p_76629_4_;
/*  559 */     int j = extendedBlockStorage.func_76674_d(p_76629_1_, p_76629_2_ & 0xF, p_76629_3_);
/*  560 */     if (j > i) i = j;
/*      */     
/*  562 */     return i;
/*      */   }
/*      */   
/*      */   public void func_76612_a(Entity p_76612_1_) {
/*  566 */     this.field_76644_m = true;
/*      */     
/*  568 */     int i = MathHelper.func_76128_c(p_76612_1_.field_70165_t / 16.0D);
/*  569 */     int j = MathHelper.func_76128_c(p_76612_1_.field_70161_v / 16.0D);
/*  570 */     if (i != this.field_76635_g || j != this.field_76647_h) {
/*  571 */       field_150817_t.warn("Wrong location! " + p_76612_1_ + " (at " + i + ", " + j + " instead of " + this.field_76635_g + ", " + this.field_76647_h + ")");
/*  572 */       Thread.dumpStack();
/*      */     } 
/*  574 */     int k = MathHelper.func_76128_c(p_76612_1_.field_70163_u / 16.0D);
/*  575 */     if (k < 0) k = 0; 
/*  576 */     if (k >= this.field_76645_j.length) k = this.field_76645_j.length - 1; 
/*  577 */     p_76612_1_.field_70175_ag = true;
/*  578 */     p_76612_1_.field_70176_ah = this.field_76635_g;
/*  579 */     p_76612_1_.field_70162_ai = k;
/*  580 */     p_76612_1_.field_70164_aj = this.field_76647_h;
/*  581 */     this.field_76645_j[k].add(p_76612_1_);
/*      */   }
/*      */   
/*      */   public void func_76622_b(Entity p_76622_1_) {
/*  585 */     func_76608_a(p_76622_1_, p_76622_1_.field_70162_ai);
/*      */   }
/*      */   
/*      */   public void func_76608_a(Entity p_76608_1_, int p_76608_2_) {
/*  589 */     if (p_76608_2_ < 0) p_76608_2_ = 0; 
/*  590 */     if (p_76608_2_ >= this.field_76645_j.length) p_76608_2_ = this.field_76645_j.length - 1; 
/*  591 */     this.field_76645_j[p_76608_2_].remove(p_76608_1_);
/*      */   }
/*      */   
/*      */   public boolean func_76619_d(int p_76619_1_, int p_76619_2_, int p_76619_3_) {
/*  595 */     return (p_76619_2_ >= this.field_76634_f[p_76619_3_ << 4 | p_76619_1_]);
/*      */   }
/*      */   
/*      */   public TileEntity func_150806_e(int p_150806_1_, int p_150806_2_, int p_150806_3_) {
/*  599 */     ChunkPosition chunkPosition = new ChunkPosition(p_150806_1_, p_150806_2_, p_150806_3_);
/*      */     
/*  601 */     TileEntity tileEntity = (TileEntity)this.field_150816_i.get(chunkPosition);
/*  602 */     if (tileEntity == null) {
/*  603 */       Block block = func_150810_a(p_150806_1_, p_150806_2_, p_150806_3_);
/*  604 */       if (!block.func_149716_u()) return null;
/*      */       
/*  606 */       tileEntity = ((ITileEntityProvider)block).func_149915_a(this.field_76637_e, func_76628_c(p_150806_1_, p_150806_2_, p_150806_3_));
/*  607 */       this.field_76637_e.func_147455_a(this.field_76635_g * 16 + p_150806_1_, p_150806_2_, this.field_76647_h * 16 + p_150806_3_, tileEntity);
/*      */     } 
/*  609 */     if (tileEntity != null && tileEntity.func_145837_r()) {
/*  610 */       this.field_150816_i.remove(chunkPosition);
/*  611 */       return null;
/*      */     } 
/*      */     
/*  614 */     return tileEntity;
/*      */   }
/*      */   
/*      */   public void func_150813_a(TileEntity p_150813_1_) {
/*  618 */     int i = p_150813_1_.field_145851_c - this.field_76635_g * 16;
/*  619 */     int j = p_150813_1_.field_145848_d;
/*  620 */     int k = p_150813_1_.field_145849_e - this.field_76647_h * 16;
/*  621 */     func_150812_a(i, j, k, p_150813_1_);
/*  622 */     if (this.field_76636_d) {
/*  623 */       this.field_76637_e.field_147482_g.add(p_150813_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_150812_a(int p_150812_1_, int p_150812_2_, int p_150812_3_, TileEntity p_150812_4_) {
/*  628 */     ChunkPosition chunkPosition = new ChunkPosition(p_150812_1_, p_150812_2_, p_150812_3_);
/*      */     
/*  630 */     p_150812_4_.func_145834_a(this.field_76637_e);
/*  631 */     p_150812_4_.field_145851_c = this.field_76635_g * 16 + p_150812_1_;
/*  632 */     p_150812_4_.field_145848_d = p_150812_2_;
/*  633 */     p_150812_4_.field_145849_e = this.field_76647_h * 16 + p_150812_3_;
/*      */     
/*  635 */     if (!(func_150810_a(p_150812_1_, p_150812_2_, p_150812_3_) instanceof ITileEntityProvider)) {
/*      */       return;
/*      */     }
/*  638 */     if (this.field_150816_i.containsKey(chunkPosition)) {
/*  639 */       ((TileEntity)this.field_150816_i.get(chunkPosition)).func_145843_s();
/*      */     }
/*      */     
/*  642 */     p_150812_4_.func_145829_t();
/*  643 */     this.field_150816_i.put(chunkPosition, p_150812_4_);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_150805_f(int p_150805_1_, int p_150805_2_, int p_150805_3_) {
/*  648 */     ChunkPosition chunkPosition = new ChunkPosition(p_150805_1_, p_150805_2_, p_150805_3_);
/*      */     
/*  650 */     if (this.field_76636_d) {
/*  651 */       TileEntity tileEntity = (TileEntity)this.field_150816_i.remove(chunkPosition);
/*  652 */       if (tileEntity != null) {
/*  653 */         tileEntity.func_145843_s();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_76631_c() {
/*  659 */     this.field_76636_d = true;
/*  660 */     this.field_76637_e.func_147448_a(this.field_150816_i.values());
/*  661 */     for (byte b = 0; b < this.field_76645_j.length; b++) {
/*  662 */       for (Entity entity : this.field_76645_j[b]) {
/*  663 */         entity.func_110123_P();
/*      */       }
/*  665 */       this.field_76637_e.func_72868_a(this.field_76645_j[b]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_76623_d() {
/*  670 */     this.field_76636_d = false;
/*  671 */     for (TileEntity tileEntity : this.field_150816_i.values()) {
/*  672 */       this.field_76637_e.func_147457_a(tileEntity);
/*      */     }
/*  674 */     for (byte b = 0; b < this.field_76645_j.length; b++) {
/*  675 */       this.field_76637_e.func_72828_b(this.field_76645_j[b]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_76630_e() {
/*  680 */     this.field_76643_l = true;
/*      */   }
/*      */   
/*      */   public void func_76588_a(Entity p_76588_1_, AxisAlignedBB p_76588_2_, List<Entity> p_76588_3_, IEntitySelector p_76588_4_) {
/*  684 */     int i = MathHelper.func_76128_c((p_76588_2_.field_72338_b - 2.0D) / 16.0D);
/*  685 */     int j = MathHelper.func_76128_c((p_76588_2_.field_72337_e + 2.0D) / 16.0D);
/*  686 */     i = MathHelper.func_76125_a(i, 0, this.field_76645_j.length - 1);
/*  687 */     j = MathHelper.func_76125_a(j, 0, this.field_76645_j.length - 1);
/*      */     
/*  689 */     for (int k = i; k <= j; k++) {
/*  690 */       List<Entity> list = this.field_76645_j[k];
/*  691 */       for (byte b = 0; b < list.size(); b++) {
/*  692 */         Entity entity = list.get(b);
/*  693 */         if (entity != p_76588_1_ && entity.field_70121_D.func_72326_a(p_76588_2_) && (p_76588_4_ == null || p_76588_4_.func_82704_a(entity))) {
/*  694 */           p_76588_3_.add(entity);
/*      */           
/*  696 */           Entity[] arrayOfEntity = entity.func_70021_al();
/*  697 */           if (arrayOfEntity != null) {
/*  698 */             for (byte b1 = 0; b1 < arrayOfEntity.length; b1++) {
/*  699 */               entity = arrayOfEntity[b1];
/*  700 */               if (entity != p_76588_1_ && entity.field_70121_D.func_72326_a(p_76588_2_) && (p_76588_4_ == null || p_76588_4_.func_82704_a(entity))) {
/*  701 */                 p_76588_3_.add(entity);
/*      */               }
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_76618_a(Class p_76618_1_, AxisAlignedBB p_76618_2_, List<Entity> p_76618_3_, IEntitySelector p_76618_4_) {
/*  711 */     int i = MathHelper.func_76128_c((p_76618_2_.field_72338_b - 2.0D) / 16.0D);
/*  712 */     int j = MathHelper.func_76128_c((p_76618_2_.field_72337_e + 2.0D) / 16.0D);
/*  713 */     i = MathHelper.func_76125_a(i, 0, this.field_76645_j.length - 1);
/*  714 */     j = MathHelper.func_76125_a(j, 0, this.field_76645_j.length - 1);
/*      */     
/*  716 */     for (int k = i; k <= j; k++) {
/*  717 */       List<Entity> list = this.field_76645_j[k];
/*  718 */       for (byte b = 0; b < list.size(); b++) {
/*  719 */         Entity entity = list.get(b);
/*  720 */         if (p_76618_1_.isAssignableFrom(entity.getClass()) && entity.field_70121_D.func_72326_a(p_76618_2_) && (
/*  721 */           p_76618_4_ == null || p_76618_4_.func_82704_a(entity))) {
/*  722 */           p_76618_3_.add(entity);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_76601_a(boolean p_76601_1_) {
/*  738 */     if (p_76601_1_)
/*  739 */     { if ((this.field_76644_m && this.field_76637_e.func_82737_E() != this.field_76641_n) || this.field_76643_l) {
/*  740 */         return true;
/*      */       } }
/*      */     
/*  743 */     else if (this.field_76644_m && this.field_76637_e.func_82737_E() >= this.field_76641_n + 600L) { return true; }
/*      */ 
/*      */     
/*  746 */     return this.field_76643_l;
/*      */   }
/*      */   
/*      */   public Random func_76617_a(long p_76617_1_) {
/*  750 */     return new Random(this.field_76637_e.func_72905_C() + (this.field_76635_g * this.field_76635_g * 4987142) + (this.field_76635_g * 5947611) + (this.field_76647_h * this.field_76647_h) * 4392871L + (this.field_76647_h * 389711) ^ p_76617_1_);
/*      */   }
/*      */   
/*      */   public boolean func_76621_g() {
/*  754 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_76624_a(IChunkProvider p_76624_1_, IChunkProvider p_76624_2_, int p_76624_3_, int p_76624_4_) {
/*  771 */     if (!this.field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_)) {
/*  772 */       p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_, p_76624_4_);
/*      */     }
/*  774 */     if (p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_) && !(p_76624_1_.func_73154_d(p_76624_3_ - 1, p_76624_4_)).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ + 1)) {
/*  775 */       p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_ - 1, p_76624_4_);
/*      */     }
/*  777 */     if (p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ - 1) && !(p_76624_1_.func_73154_d(p_76624_3_, p_76624_4_ - 1)).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_)) {
/*  778 */       p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_, p_76624_4_ - 1);
/*      */     }
/*  780 */     if (p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ - 1) && !(p_76624_1_.func_73154_d(p_76624_3_ - 1, p_76624_4_ - 1)).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_)) {
/*  781 */       p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_ - 1, p_76624_4_ - 1);
/*      */     }
/*      */   }
/*      */   
/*      */   public int func_76626_d(int p_76626_1_, int p_76626_2_) {
/*  786 */     int i = p_76626_1_ | p_76626_2_ << 4;
/*  787 */     int j = this.field_76638_b[i];
/*  788 */     if (j == -999) {
/*  789 */       int k = func_76625_h() + 15;
/*  790 */       j = -1;
/*  791 */       while (k > 0 && j == -1) {
/*  792 */         Block block = func_150810_a(p_76626_1_, k, p_76626_2_);
/*  793 */         Material material = block.func_149688_o();
/*  794 */         if (!material.func_76230_c() && !material.func_76224_d()) {
/*  795 */           k--; continue;
/*      */         } 
/*  797 */         j = k + 1;
/*      */       } 
/*      */       
/*  800 */       this.field_76638_b[i] = j;
/*      */     } 
/*      */     
/*  803 */     return j;
/*      */   }
/*      */   
/*      */   public void func_150804_b(boolean p_150804_1_) {
/*  807 */     if (this.field_76650_s && !this.field_76637_e.field_73011_w.field_76576_e && !p_150804_1_) {
/*  808 */       func_150803_c(this.field_76637_e.field_72995_K);
/*      */     }
/*  810 */     this.field_150815_m = true;
/*      */     
/*  812 */     if (!this.field_150814_l && this.field_76646_k) {
/*  813 */       func_150809_p();
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean func_150802_k() {
/*  818 */     return (this.field_150815_m && this.field_76646_k && this.field_150814_l);
/*      */   }
/*      */   
/*      */   public ChunkCoordIntPair func_76632_l() {
/*  822 */     return new ChunkCoordIntPair(this.field_76635_g, this.field_76647_h);
/*      */   }
/*      */   
/*      */   public boolean func_76606_c(int p_76606_1_, int p_76606_2_) {
/*  826 */     if (p_76606_1_ < 0) {
/*  827 */       p_76606_1_ = 0;
/*      */     }
/*  829 */     if (p_76606_2_ >= 256) {
/*  830 */       p_76606_2_ = 255;
/*      */     }
/*  832 */     for (int i = p_76606_1_; i <= p_76606_2_; i += 16) {
/*  833 */       ExtendedBlockStorage extendedBlockStorage = this.field_76652_q[i >> 4];
/*  834 */       if (extendedBlockStorage != null && !extendedBlockStorage.func_76663_a()) {
/*  835 */         return false;
/*      */       }
/*      */     } 
/*  838 */     return true;
/*      */   }
/*      */   
/*      */   public void func_76602_a(ExtendedBlockStorage[] p_76602_1_) {
/*  842 */     this.field_76652_q = p_76602_1_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_76607_a(byte[] p_76607_1_, int p_76607_2_, int p_76607_3_, boolean p_76607_4_) {
/*  854 */     int i = 0;
/*      */     
/*  856 */     boolean bool = !this.field_76637_e.field_73011_w.field_76576_e ? true : false;
/*      */     byte b;
/*  858 */     for (b = 0; b < this.field_76652_q.length; b++) {
/*  859 */       if ((p_76607_2_ & 1 << b) != 0) {
/*      */         
/*  861 */         if (this.field_76652_q[b] == null) {
/*  862 */           this.field_76652_q[b] = new ExtendedBlockStorage(b << 4, bool);
/*      */         }
/*  864 */         byte[] arrayOfByte = this.field_76652_q[b].func_76658_g();
/*  865 */         System.arraycopy(p_76607_1_, i, arrayOfByte, 0, arrayOfByte.length);
/*  866 */         i += arrayOfByte.length;
/*      */       }
/*  868 */       else if (p_76607_4_ && this.field_76652_q[b] != null) {
/*  869 */         this.field_76652_q[b] = null;
/*      */       } 
/*      */     } 
/*  872 */     for (b = 0; b < this.field_76652_q.length; b++) {
/*  873 */       if ((p_76607_2_ & 1 << b) != 0 && this.field_76652_q[b] != null) {
/*  874 */         NibbleArray nibbleArray = this.field_76652_q[b].func_76669_j();
/*  875 */         System.arraycopy(p_76607_1_, i, nibbleArray.field_76585_a, 0, nibbleArray.field_76585_a.length);
/*  876 */         i += nibbleArray.field_76585_a.length;
/*      */       } 
/*      */     } 
/*  879 */     for (b = 0; b < this.field_76652_q.length; b++) {
/*  880 */       if ((p_76607_2_ & 1 << b) != 0 && this.field_76652_q[b] != null) {
/*  881 */         NibbleArray nibbleArray = this.field_76652_q[b].func_76661_k();
/*  882 */         System.arraycopy(p_76607_1_, i, nibbleArray.field_76585_a, 0, nibbleArray.field_76585_a.length);
/*  883 */         i += nibbleArray.field_76585_a.length;
/*      */       } 
/*      */     } 
/*  886 */     if (bool) {
/*  887 */       for (b = 0; b < this.field_76652_q.length; b++) {
/*  888 */         if ((p_76607_2_ & 1 << b) != 0 && this.field_76652_q[b] != null) {
/*  889 */           NibbleArray nibbleArray = this.field_76652_q[b].func_76671_l();
/*  890 */           System.arraycopy(p_76607_1_, i, nibbleArray.field_76585_a, 0, nibbleArray.field_76585_a.length);
/*  891 */           i += nibbleArray.field_76585_a.length;
/*      */         } 
/*      */       } 
/*      */     }
/*  895 */     for (b = 0; b < this.field_76652_q.length; b++) {
/*  896 */       if ((p_76607_3_ & 1 << b) != 0) {
/*  897 */         if (this.field_76652_q[b] == null) {
/*  898 */           i += 2048;
/*      */         } else {
/*  900 */           NibbleArray nibbleArray = this.field_76652_q[b].func_76660_i();
/*  901 */           if (nibbleArray == null) {
/*  902 */             nibbleArray = this.field_76652_q[b].func_76667_m();
/*      */           }
/*  904 */           System.arraycopy(p_76607_1_, i, nibbleArray.field_76585_a, 0, nibbleArray.field_76585_a.length);
/*  905 */           i += nibbleArray.field_76585_a.length;
/*      */         } 
/*  907 */       } else if (p_76607_4_ && this.field_76652_q[b] != null && this.field_76652_q[b].func_76660_i() != null) {
/*  908 */         this.field_76652_q[b].func_76676_h();
/*      */       } 
/*      */     } 
/*  911 */     if (p_76607_4_) {
/*  912 */       System.arraycopy(p_76607_1_, i, this.field_76651_r, 0, this.field_76651_r.length);
/*  913 */       i += this.field_76651_r.length;
/*      */     } 
/*      */     
/*  916 */     for (b = 0; b < this.field_76652_q.length; b++) {
/*  917 */       if (this.field_76652_q[b] != null && (p_76607_2_ & 1 << b) != 0) {
/*  918 */         this.field_76652_q[b].func_76672_e();
/*      */       }
/*      */     } 
/*      */     
/*  922 */     this.field_150814_l = true;
/*  923 */     this.field_76646_k = true;
/*  924 */     func_76590_a();
/*  925 */     for (TileEntity tileEntity : this.field_150816_i.values()) {
/*  926 */       tileEntity.func_145836_u();
/*      */     }
/*      */   }
/*      */   
/*      */   public BiomeGenBase func_76591_a(int p_76591_1_, int p_76591_2_, WorldChunkManager p_76591_3_) {
/*  931 */     int i = this.field_76651_r[p_76591_2_ << 4 | p_76591_1_] & 0xFF;
/*  932 */     if (i == 255) {
/*  933 */       BiomeGenBase biomeGenBase = p_76591_3_.func_76935_a((this.field_76635_g << 4) + p_76591_1_, (this.field_76647_h << 4) + p_76591_2_);
/*  934 */       i = biomeGenBase.field_76756_M;
/*  935 */       this.field_76651_r[p_76591_2_ << 4 | p_76591_1_] = (byte)(i & 0xFF);
/*      */     } 
/*  937 */     if (BiomeGenBase.func_150568_d(i) == null) {
/*  938 */       return BiomeGenBase.field_76772_c;
/*      */     }
/*  940 */     return BiomeGenBase.func_150568_d(i);
/*      */   }
/*      */   
/*      */   public byte[] func_76605_m() {
/*  944 */     return this.field_76651_r;
/*      */   }
/*      */   
/*      */   public void func_76616_a(byte[] p_76616_1_) {
/*  948 */     this.field_76651_r = p_76616_1_;
/*      */   }
/*      */   
/*      */   public void func_76613_n() {
/*  952 */     this.field_76649_t = 0;
/*      */   }
/*      */   
/*      */   public void func_76594_o() {
/*  956 */     for (byte b = 0; b < 8; b++) {
/*  957 */       if (this.field_76649_t >= 4096) {
/*      */         return;
/*      */       }
/*      */       
/*  961 */       int i = this.field_76649_t % 16;
/*  962 */       int j = this.field_76649_t / 16 % 16;
/*  963 */       int k = this.field_76649_t / 256;
/*  964 */       this.field_76649_t++;
/*      */       
/*  966 */       int m = (this.field_76635_g << 4) + j;
/*  967 */       int n = (this.field_76647_h << 4) + k;
/*      */       
/*  969 */       for (byte b1 = 0; b1 < 16; b1++) {
/*  970 */         int i1 = (i << 4) + b1;
/*  971 */         if ((this.field_76652_q[i] == null && (b1 == 0 || b1 == 15 || j == 0 || j == 15 || k == 0 || k == 15)) || (this.field_76652_q[i] != null && this.field_76652_q[i].func_150819_a(j, b1, k).func_149688_o() == Material.field_151579_a)) {
/*      */           
/*  973 */           if (this.field_76637_e.func_147439_a(m, i1 - 1, n).func_149750_m() > 0) {
/*  974 */             this.field_76637_e.func_147451_t(m, i1 - 1, n);
/*      */           }
/*  976 */           if (this.field_76637_e.func_147439_a(m, i1 + 1, n).func_149750_m() > 0) {
/*  977 */             this.field_76637_e.func_147451_t(m, i1 + 1, n);
/*      */           }
/*  979 */           if (this.field_76637_e.func_147439_a(m - 1, i1, n).func_149750_m() > 0) {
/*  980 */             this.field_76637_e.func_147451_t(m - 1, i1, n);
/*      */           }
/*  982 */           if (this.field_76637_e.func_147439_a(m + 1, i1, n).func_149750_m() > 0) {
/*  983 */             this.field_76637_e.func_147451_t(m + 1, i1, n);
/*      */           }
/*  985 */           if (this.field_76637_e.func_147439_a(m, i1, n - 1).func_149750_m() > 0) {
/*  986 */             this.field_76637_e.func_147451_t(m, i1, n - 1);
/*      */           }
/*  988 */           if (this.field_76637_e.func_147439_a(m, i1, n + 1).func_149750_m() > 0) {
/*  989 */             this.field_76637_e.func_147451_t(m, i1, n + 1);
/*      */           }
/*  991 */           this.field_76637_e.func_147451_t(m, i1, n);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_150809_p() {
/*  998 */     this.field_76646_k = true;
/*  999 */     this.field_150814_l = true;
/*      */     
/* 1001 */     if (!this.field_76637_e.field_73011_w.field_76576_e) {
/* 1002 */       if (this.field_76637_e.func_72904_c(this.field_76635_g * 16 - 1, 0, this.field_76647_h * 16 - 1, this.field_76635_g * 16 + 1, 63, this.field_76647_h * 16 + 1)) {
/*      */         
/* 1004 */         for (byte b = 0; b < 16; b++) {
/* 1005 */           for (byte b1 = 0; b1 < 16; b1++) {
/* 1006 */             if (!func_150811_f(b, b1)) {
/* 1007 */               this.field_150814_l = false;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/* 1012 */         if (this.field_150814_l) {
/*      */           
/* 1014 */           Chunk chunk = this.field_76637_e.func_72938_d(this.field_76635_g * 16 - 1, this.field_76647_h * 16);
/* 1015 */           chunk.func_150801_a(3);
/*      */ 
/*      */           
/* 1018 */           chunk = this.field_76637_e.func_72938_d(this.field_76635_g * 16 + 16, this.field_76647_h * 16);
/* 1019 */           chunk.func_150801_a(1);
/*      */ 
/*      */           
/* 1022 */           chunk = this.field_76637_e.func_72938_d(this.field_76635_g * 16, this.field_76647_h * 16 - 1);
/* 1023 */           chunk.func_150801_a(0);
/*      */ 
/*      */           
/* 1026 */           chunk = this.field_76637_e.func_72938_d(this.field_76635_g * 16, this.field_76647_h * 16 + 16);
/* 1027 */           chunk.func_150801_a(2);
/*      */         } 
/*      */       } else {
/*      */         
/* 1031 */         this.field_150814_l = false;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void func_150801_a(int p_150801_1_) {
/* 1037 */     if (!this.field_76646_k) {
/*      */       return;
/*      */     }
/*      */     
/* 1041 */     if (p_150801_1_ == 3) {
/* 1042 */       for (byte b = 0; b < 16; b++) {
/* 1043 */         func_150811_f(15, b);
/*      */       }
/* 1045 */     } else if (p_150801_1_ == 1) {
/* 1046 */       for (byte b = 0; b < 16; b++) {
/* 1047 */         func_150811_f(0, b);
/*      */       }
/* 1049 */     } else if (p_150801_1_ == 0) {
/* 1050 */       for (byte b = 0; b < 16; b++) {
/* 1051 */         func_150811_f(b, 15);
/*      */       }
/* 1053 */     } else if (p_150801_1_ == 2) {
/* 1054 */       for (byte b = 0; b < 16; b++) {
/* 1055 */         func_150811_f(b, 0);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean func_150811_f(int p_150811_1_, int p_150811_2_) {
/* 1061 */     int i = func_76625_h();
/*      */     
/* 1063 */     boolean bool1 = false;
/* 1064 */     boolean bool2 = false;
/*      */     int j;
/* 1066 */     for (j = i + 16 - 1; j > 63 || (j > 0 && !bool2); j--) {
/* 1067 */       int k = func_150808_b(p_150811_1_, j, p_150811_2_);
/*      */       
/* 1069 */       if (k == 255 && j < 63) {
/* 1070 */         bool2 = true;
/*      */       }
/*      */       
/* 1073 */       if (!bool1 && k > 0) {
/* 1074 */         bool1 = true;
/* 1075 */       } else if (bool1 && k == 0) {
/*      */         
/* 1077 */         if (!this.field_76637_e.func_147451_t(this.field_76635_g * 16 + p_150811_1_, j, this.field_76647_h * 16 + p_150811_2_)) {
/* 1078 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1084 */     for (; j > 0; j--) {
/* 1085 */       if (func_150810_a(p_150811_1_, j, p_150811_2_).func_149750_m() > 0) {
/* 1086 */         this.field_76637_e.func_147451_t(this.field_76635_g * 16 + p_150811_1_, j, this.field_76647_h * 16 + p_150811_2_);
/*      */       }
/*      */     } 
/* 1089 */     return true;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\Chunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */