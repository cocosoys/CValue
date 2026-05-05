/*     */ package net.minecraft.world;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ public class ChunkCache implements IBlockAccess {
/*     */   private int field_72818_a;
/*     */   private int field_72816_b;
/*     */   private Chunk[][] field_72817_c;
/*     */   
/*     */   public ChunkCache(World p_i1964_1_, int p_i1964_2_, int p_i1964_3_, int p_i1964_4_, int p_i1964_5_, int p_i1964_6_, int p_i1964_7_, int p_i1964_8_) {
/*  18 */     this.field_72815_e = p_i1964_1_;
/*     */     
/*  20 */     this.field_72818_a = p_i1964_2_ - p_i1964_8_ >> 4;
/*  21 */     this.field_72816_b = p_i1964_4_ - p_i1964_8_ >> 4;
/*  22 */     int i = p_i1964_5_ + p_i1964_8_ >> 4;
/*  23 */     int j = p_i1964_7_ + p_i1964_8_ >> 4;
/*     */     
/*  25 */     this.field_72817_c = new Chunk[i - this.field_72818_a + 1][j - this.field_72816_b + 1];
/*     */     
/*  27 */     this.field_72814_d = true; int k;
/*  28 */     for (k = this.field_72818_a; k <= i; k++) {
/*  29 */       for (int m = this.field_72816_b; m <= j; m++) {
/*  30 */         Chunk chunk = p_i1964_1_.func_72964_e(k, m);
/*  31 */         if (chunk != null) {
/*  32 */           this.field_72817_c[k - this.field_72818_a][m - this.field_72816_b] = chunk;
/*     */         }
/*     */       } 
/*     */     } 
/*  36 */     for (k = p_i1964_2_ >> 4; k <= p_i1964_5_ >> 4; k++) {
/*  37 */       for (int m = p_i1964_4_ >> 4; m <= p_i1964_7_ >> 4; m++) {
/*  38 */         Chunk chunk = this.field_72817_c[k - this.field_72818_a][m - this.field_72816_b];
/*  39 */         if (chunk != null && 
/*  40 */           !chunk.func_76606_c(p_i1964_3_, p_i1964_6_))
/*  41 */           this.field_72814_d = false; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean field_72814_d;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_72806_N() {
/*  50 */     return this.field_72814_d;
/*     */   }
/*     */   private World field_72815_e; private static final String __OBFID = "CL_00000155";
/*     */   
/*     */   public Block func_147439_a(int p_147439_1_, int p_147439_2_, int p_147439_3_) {
/*  55 */     Block block = Blocks.field_150350_a;
/*  56 */     if (p_147439_2_ >= 0 && 
/*  57 */       p_147439_2_ < 256) {
/*     */       
/*  59 */       int i = (p_147439_1_ >> 4) - this.field_72818_a;
/*  60 */       int j = (p_147439_3_ >> 4) - this.field_72816_b;
/*     */       
/*  62 */       if (i >= 0 && i < this.field_72817_c.length && j >= 0 && j < (this.field_72817_c[i]).length) {
/*     */         
/*  64 */         Chunk chunk = this.field_72817_c[i][j];
/*  65 */         if (chunk != null) {
/*  66 */           block = chunk.func_150810_a(p_147439_1_ & 0xF, p_147439_2_, p_147439_3_ & 0xF);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  71 */     return block;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_147438_o(int p_147438_1_, int p_147438_2_, int p_147438_3_) {
/*  76 */     int i = (p_147438_1_ >> 4) - this.field_72818_a;
/*  77 */     int j = (p_147438_3_ >> 4) - this.field_72816_b;
/*     */     
/*  79 */     return this.field_72817_c[i][j].func_150806_e(p_147438_1_ & 0xF, p_147438_2_, p_147438_3_ & 0xF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_72802_i(int p_72802_1_, int p_72802_2_, int p_72802_3_, int p_72802_4_) {
/*  91 */     int i = func_72810_a(EnumSkyBlock.Sky, p_72802_1_, p_72802_2_, p_72802_3_);
/*  92 */     int j = func_72810_a(EnumSkyBlock.Block, p_72802_1_, p_72802_2_, p_72802_3_);
/*  93 */     if (j < p_72802_4_) j = p_72802_4_; 
/*  94 */     return i << 20 | j << 4;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_72805_g(int p_72805_1_, int p_72805_2_, int p_72805_3_) {
/* 142 */     if (p_72805_2_ < 0) return 0; 
/* 143 */     if (p_72805_2_ >= 256) return 0; 
/* 144 */     int i = (p_72805_1_ >> 4) - this.field_72818_a;
/* 145 */     int j = (p_72805_3_ >> 4) - this.field_72816_b;
/*     */     
/* 147 */     return this.field_72817_c[i][j].func_76628_c(p_72805_1_ & 0xF, p_72805_2_, p_72805_3_ & 0xF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BiomeGenBase func_72807_a(int p_72807_1_, int p_72807_2_) {
/* 157 */     return this.field_72815_e.func_72807_a(p_72807_1_, p_72807_2_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_147437_c(int p_147437_1_, int p_147437_2_, int p_147437_3_) {
/* 162 */     return (func_147439_a(p_147437_1_, p_147437_2_, p_147437_3_).func_149688_o() == Material.field_151579_a);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_72810_a(EnumSkyBlock p_72810_1_, int p_72810_2_, int p_72810_3_, int p_72810_4_) {
/* 166 */     if (p_72810_3_ < 0) p_72810_3_ = 0; 
/* 167 */     if (p_72810_3_ >= 256) p_72810_3_ = 255; 
/* 168 */     if (p_72810_3_ < 0 || p_72810_3_ >= 256 || p_72810_2_ < -30000000 || p_72810_4_ < -30000000 || p_72810_2_ >= 30000000 || p_72810_4_ > 30000000) {
/* 169 */       return p_72810_1_.field_77198_c;
/*     */     }
/* 171 */     if (p_72810_1_ == EnumSkyBlock.Sky && this.field_72815_e.field_73011_w.field_76576_e) {
/* 172 */       return 0;
/*     */     }
/*     */     
/* 175 */     if (func_147439_a(p_72810_2_, p_72810_3_, p_72810_4_).func_149710_n()) {
/* 176 */       int k = func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_ + 1, p_72810_4_);
/* 177 */       int m = func_72812_b(p_72810_1_, p_72810_2_ + 1, p_72810_3_, p_72810_4_);
/* 178 */       int n = func_72812_b(p_72810_1_, p_72810_2_ - 1, p_72810_3_, p_72810_4_);
/* 179 */       int i1 = func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_, p_72810_4_ + 1);
/* 180 */       int i2 = func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_, p_72810_4_ - 1);
/* 181 */       if (m > k) k = m; 
/* 182 */       if (n > k) k = n; 
/* 183 */       if (i1 > k) k = i1; 
/* 184 */       if (i2 > k) k = i2; 
/* 185 */       return k;
/*     */     } 
/*     */     
/* 188 */     int i = (p_72810_2_ >> 4) - this.field_72818_a;
/* 189 */     int j = (p_72810_4_ >> 4) - this.field_72816_b;
/*     */     
/* 191 */     return this.field_72817_c[i][j].func_76614_a(p_72810_1_, p_72810_2_ & 0xF, p_72810_3_, p_72810_4_ & 0xF);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_72812_b(EnumSkyBlock p_72812_1_, int p_72812_2_, int p_72812_3_, int p_72812_4_) {
/* 196 */     if (p_72812_3_ < 0) p_72812_3_ = 0; 
/* 197 */     if (p_72812_3_ >= 256) p_72812_3_ = 255; 
/* 198 */     if (p_72812_3_ < 0 || p_72812_3_ >= 256 || p_72812_2_ < -30000000 || p_72812_4_ < -30000000 || p_72812_2_ >= 30000000 || p_72812_4_ > 30000000) {
/* 199 */       return p_72812_1_.field_77198_c;
/*     */     }
/* 201 */     int i = (p_72812_2_ >> 4) - this.field_72818_a;
/* 202 */     int j = (p_72812_4_ >> 4) - this.field_72816_b;
/*     */     
/* 204 */     return this.field_72817_c[i][j].func_76614_a(p_72812_1_, p_72812_2_ & 0xF, p_72812_3_, p_72812_4_ & 0xF);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_72800_K() {
/* 209 */     return 256;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_72879_k(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_) {
/* 214 */     return func_147439_a(p_72879_1_, p_72879_2_, p_72879_3_).func_149748_c(this, p_72879_1_, p_72879_2_, p_72879_3_, p_72879_4_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\ChunkCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */