/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemMonsterPlacer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockPortal
/*     */   extends BlockBreakable
/*     */ {
/*  24 */   public static final int[][] field_150001_a = new int[][] { {}, { 3, 1 }, { 2, 0 } };
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000284";
/*     */ 
/*     */   
/*     */   public BlockPortal() {
/*  31 */     super("portal", Material.field_151567_E, false);
/*  32 */     func_149675_a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  37 */     super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */     
/*  39 */     if (p_149674_1_.field_73011_w.func_76569_d() && p_149674_1_.func_82736_K().func_82766_b("doMobSpawning") && p_149674_5_.nextInt(2000) < p_149674_1_.field_73013_u.func_151525_a()) {
/*     */       
/*  41 */       int i = p_149674_3_;
/*  42 */       while (!World.func_147466_a((IBlockAccess)p_149674_1_, p_149674_2_, i, p_149674_4_) && i > 0) {
/*  43 */         i--;
/*     */       }
/*  45 */       if (i > 0 && !p_149674_1_.func_147439_a(p_149674_2_, i + 1, p_149674_4_).func_149721_r()) {
/*     */         
/*  47 */         Entity entity = ItemMonsterPlacer.func_77840_a(p_149674_1_, 57, p_149674_2_ + 0.5D, i + 1.1D, p_149674_4_ + 0.5D);
/*  48 */         if (entity != null) {
/*  49 */           entity.field_71088_bW = entity.func_82147_ab();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  62 */     int i = func_149999_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
/*     */     
/*  64 */     if (i == 0) {
/*  65 */       if (p_149719_1_.func_147439_a(p_149719_2_ - 1, p_149719_3_, p_149719_4_) == this || p_149719_1_.func_147439_a(p_149719_2_ + 1, p_149719_3_, p_149719_4_) == this) {
/*  66 */         i = 1;
/*     */       } else {
/*  68 */         i = 2;
/*     */       } 
/*     */       
/*  71 */       if (p_149719_1_ instanceof World && !((World)p_149719_1_).field_72995_K) {
/*  72 */         ((World)p_149719_1_).func_72921_c(p_149719_2_, p_149719_3_, p_149719_4_, i, 2);
/*     */       }
/*     */     } 
/*     */     
/*  76 */     float f1 = 0.125F;
/*  77 */     float f2 = 0.125F;
/*     */     
/*  79 */     if (i == 1) {
/*  80 */       f1 = 0.5F;
/*     */     }
/*  82 */     if (i == 2) {
/*  83 */       f2 = 0.5F;
/*     */     }
/*     */     
/*  86 */     func_149676_a(0.5F - f1, 0.0F, 0.5F - f2, 0.5F + f1, 1.0F, 0.5F + f2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_150000_e(World p_150000_1_, int p_150000_2_, int p_150000_3_, int p_150000_4_) {
/*  95 */     Size size1 = new Size(p_150000_1_, p_150000_2_, p_150000_3_, p_150000_4_, 1);
/*  96 */     Size size2 = new Size(p_150000_1_, p_150000_2_, p_150000_3_, p_150000_4_, 2);
/*     */     
/*  98 */     if (size1.func_150860_b() && size1.field_150864_e == 0) {
/*  99 */       size1.func_150859_c();
/* 100 */       return true;
/* 101 */     }  if (size2.func_150860_b() && size2.field_150864_e == 0) {
/* 102 */       size2.func_150859_c();
/* 103 */       return true;
/*     */     } 
/*     */     
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 111 */     int i = func_149999_b(p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_));
/* 112 */     Size size1 = new Size(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 1);
/* 113 */     Size size2 = new Size(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 2);
/*     */     
/* 115 */     if (i == 1 && (!size1.func_150860_b() || size1.field_150864_e < size1.field_150868_h * size1.field_150862_g)) {
/* 116 */       p_149695_1_.func_147449_b(p_149695_2_, p_149695_3_, p_149695_4_, Blocks.field_150350_a);
/* 117 */     } else if (i == 2 && (!size2.func_150860_b() || size2.field_150864_e < size2.field_150868_h * size2.field_150862_g)) {
/* 118 */       p_149695_1_.func_147449_b(p_149695_2_, p_149695_3_, p_149695_4_, Blocks.field_150350_a);
/* 119 */     } else if (i == 0 && !size1.func_150860_b() && !size2.func_150860_b()) {
/* 120 */       p_149695_1_.func_147449_b(p_149695_2_, p_149695_3_, p_149695_4_, Blocks.field_150350_a);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 126 */     int i = 0;
/*     */     
/* 128 */     if (p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_) == this) {
/* 129 */       i = func_149999_b(p_149646_1_.func_72805_g(p_149646_2_, p_149646_3_, p_149646_4_));
/*     */       
/* 131 */       if (i == 0) return false; 
/* 132 */       if (i == 2 && p_149646_5_ != 5 && p_149646_5_ != 4) return false; 
/* 133 */       if (i == 1 && p_149646_5_ != 3 && p_149646_5_ != 2) return false;
/*     */     
/*     */     } 
/* 136 */     boolean bool1 = (p_149646_1_.func_147439_a(p_149646_2_ - 1, p_149646_3_, p_149646_4_) == this && p_149646_1_.func_147439_a(p_149646_2_ - 2, p_149646_3_, p_149646_4_) != this) ? true : false;
/* 137 */     boolean bool2 = (p_149646_1_.func_147439_a(p_149646_2_ + 1, p_149646_3_, p_149646_4_) == this && p_149646_1_.func_147439_a(p_149646_2_ + 2, p_149646_3_, p_149646_4_) != this) ? true : false;
/*     */     
/* 139 */     boolean bool3 = (p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_ - 1) == this && p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_ - 2) != this) ? true : false;
/* 140 */     boolean bool4 = (p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_ + 1) == this && p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_ + 2) != this) ? true : false;
/*     */     
/* 142 */     boolean bool5 = (bool1 || bool2 || i == 1) ? true : false;
/* 143 */     boolean bool6 = (bool3 || bool4 || i == 2) ? true : false;
/*     */     
/* 145 */     if (bool5 && p_149646_5_ == 4) return true; 
/* 146 */     if (bool5 && p_149646_5_ == 5) return true; 
/* 147 */     if (bool6 && p_149646_5_ == 2) return true; 
/* 148 */     if (bool6 && p_149646_5_ == 3) return true;
/*     */     
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 155 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/* 160 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/* 165 */     if (p_149670_5_.field_70154_o == null && p_149670_5_.field_70153_n == null) p_149670_5_.func_70063_aa(); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 170 */     if (p_149734_5_.nextInt(100) == 0) {
/* 171 */       p_149734_1_.func_72980_b(p_149734_2_ + 0.5D, p_149734_3_ + 0.5D, p_149734_4_ + 0.5D, "portal.portal", 0.5F, p_149734_5_.nextFloat() * 0.4F + 0.8F, false);
/*     */     }
/* 173 */     for (byte b = 0; b < 4; b++) {
/* 174 */       double d1 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 175 */       double d2 = (p_149734_3_ + p_149734_5_.nextFloat());
/* 176 */       double d3 = (p_149734_4_ + p_149734_5_.nextFloat());
/* 177 */       double d4 = 0.0D;
/* 178 */       double d5 = 0.0D;
/* 179 */       double d6 = 0.0D;
/* 180 */       int i = p_149734_5_.nextInt(2) * 2 - 1;
/* 181 */       d4 = (p_149734_5_.nextFloat() - 0.5D) * 0.5D;
/* 182 */       d5 = (p_149734_5_.nextFloat() - 0.5D) * 0.5D;
/* 183 */       d6 = (p_149734_5_.nextFloat() - 0.5D) * 0.5D;
/* 184 */       if (p_149734_1_.func_147439_a(p_149734_2_ - 1, p_149734_3_, p_149734_4_) == this || p_149734_1_.func_147439_a(p_149734_2_ + 1, p_149734_3_, p_149734_4_) == this) {
/* 185 */         d3 = p_149734_4_ + 0.5D + 0.25D * i;
/* 186 */         d6 = (p_149734_5_.nextFloat() * 2.0F * i);
/*     */       } else {
/* 188 */         d1 = p_149734_2_ + 0.5D + 0.25D * i;
/* 189 */         d4 = (p_149734_5_.nextFloat() * 2.0F * i);
/*     */       } 
/*     */       
/* 192 */       p_149734_1_.func_72869_a("portal", d1, d2, d3, d4, d5, d6);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 198 */     return Item.func_150899_d(0);
/*     */   }
/*     */   
/*     */   public static int func_149999_b(int p_149999_0_) {
/* 202 */     return p_149999_0_ & 0x3;
/*     */   }
/*     */   
/*     */   public static class Size {
/*     */     private final World field_150867_a;
/*     */     private final int field_150865_b;
/*     */     private final int field_150866_c;
/*     */     private final int field_150863_d;
/* 210 */     private int field_150864_e = 0; private ChunkCoordinates field_150861_f;
/*     */     private int field_150862_g;
/*     */     private int field_150868_h;
/*     */     private static final String __OBFID = "CL_00000285";
/*     */     
/*     */     public Size(World p_i45415_1_, int p_i45415_2_, int p_i45415_3_, int p_i45415_4_, int p_i45415_5_) {
/* 216 */       this.field_150867_a = p_i45415_1_;
/* 217 */       this.field_150865_b = p_i45415_5_;
/* 218 */       this.field_150863_d = BlockPortal.field_150001_a[p_i45415_5_][0];
/* 219 */       this.field_150866_c = BlockPortal.field_150001_a[p_i45415_5_][1];
/*     */       
/* 221 */       int i = p_i45415_3_;
/*     */       
/* 223 */       while (p_i45415_3_ > i - 21 && p_i45415_3_ > 0 && func_150857_a(p_i45415_1_.func_147439_a(p_i45415_2_, p_i45415_3_ - 1, p_i45415_4_))) {
/* 224 */         p_i45415_3_--;
/*     */       }
/*     */       
/* 227 */       int j = func_150853_a(p_i45415_2_, p_i45415_3_, p_i45415_4_, this.field_150863_d) - 1;
/*     */       
/* 229 */       if (j >= 0) {
/* 230 */         this.field_150861_f = new ChunkCoordinates(p_i45415_2_ + j * Direction.field_71583_a[this.field_150863_d], p_i45415_3_, p_i45415_4_ + j * Direction.field_71581_b[this.field_150863_d]);
/* 231 */         this.field_150868_h = func_150853_a(this.field_150861_f.field_71574_a, this.field_150861_f.field_71572_b, this.field_150861_f.field_71573_c, this.field_150866_c);
/*     */         
/* 233 */         if (this.field_150868_h < 2 || this.field_150868_h > 21) {
/* 234 */           this.field_150861_f = null;
/* 235 */           this.field_150868_h = 0;
/*     */         } 
/*     */       } 
/*     */       
/* 239 */       if (this.field_150861_f != null) {
/* 240 */         this.field_150862_g = func_150858_a();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_150853_a(int p_150853_1_, int p_150853_2_, int p_150853_3_, int p_150853_4_) {
/* 246 */       int i = Direction.field_71583_a[p_150853_4_];
/* 247 */       int j = Direction.field_71581_b[p_150853_4_];
/*     */       byte b;
/* 249 */       for (b = 0; b < 22; b++) {
/* 250 */         Block block1 = this.field_150867_a.func_147439_a(p_150853_1_ + i * b, p_150853_2_, p_150853_3_ + j * b);
/* 251 */         if (!func_150857_a(block1)) {
/*     */           break;
/*     */         }
/*     */         
/* 255 */         Block block2 = this.field_150867_a.func_147439_a(p_150853_1_ + i * b, p_150853_2_ - 1, p_150853_3_ + j * b);
/* 256 */         if (block2 != Blocks.field_150343_Z) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */       
/* 261 */       Block block = this.field_150867_a.func_147439_a(p_150853_1_ + i * b, p_150853_2_, p_150853_3_ + j * b);
/* 262 */       if (block == Blocks.field_150343_Z) {
/* 263 */         return b;
/*     */       }
/* 265 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_150858_a() {
/* 270 */       label39: for (this.field_150862_g = 0; this.field_150862_g < 21; this.field_150862_g++) {
/* 271 */         int i = this.field_150861_f.field_71572_b + this.field_150862_g;
/*     */         
/* 273 */         for (byte b1 = 0; b1 < this.field_150868_h; b1++) {
/* 274 */           int j = this.field_150861_f.field_71574_a + b1 * Direction.field_71583_a[BlockPortal.field_150001_a[this.field_150865_b][1]];
/* 275 */           int k = this.field_150861_f.field_71573_c + b1 * Direction.field_71581_b[BlockPortal.field_150001_a[this.field_150865_b][1]];
/*     */           
/* 277 */           Block block = this.field_150867_a.func_147439_a(j, i, k);
/* 278 */           if (!func_150857_a(block)) {
/*     */             break label39;
/*     */           }
/*     */           
/* 282 */           if (block == Blocks.field_150427_aO) this.field_150864_e++;
/*     */           
/* 284 */           if (b1 == 0) {
/* 285 */             block = this.field_150867_a.func_147439_a(j + Direction.field_71583_a[BlockPortal.field_150001_a[this.field_150865_b][0]], i, k + Direction.field_71581_b[BlockPortal.field_150001_a[this.field_150865_b][0]]);
/* 286 */             if (block != Blocks.field_150343_Z) {
/*     */               break label39;
/*     */             }
/* 289 */           } else if (b1 == this.field_150868_h - 1) {
/* 290 */             block = this.field_150867_a.func_147439_a(j + Direction.field_71583_a[BlockPortal.field_150001_a[this.field_150865_b][1]], i, k + Direction.field_71581_b[BlockPortal.field_150001_a[this.field_150865_b][1]]);
/* 291 */             if (block != Blocks.field_150343_Z) {
/*     */               break label39;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 298 */       for (byte b = 0; b < this.field_150868_h; b++) {
/* 299 */         int i = this.field_150861_f.field_71574_a + b * Direction.field_71583_a[BlockPortal.field_150001_a[this.field_150865_b][1]];
/* 300 */         int j = this.field_150861_f.field_71572_b + this.field_150862_g;
/* 301 */         int k = this.field_150861_f.field_71573_c + b * Direction.field_71581_b[BlockPortal.field_150001_a[this.field_150865_b][1]];
/*     */         
/* 303 */         if (this.field_150867_a.func_147439_a(i, j, k) != Blocks.field_150343_Z) {
/* 304 */           this.field_150862_g = 0;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 309 */       if (this.field_150862_g > 21 || this.field_150862_g < 3) {
/* 310 */         this.field_150861_f = null;
/* 311 */         this.field_150868_h = 0;
/* 312 */         this.field_150862_g = 0;
/* 313 */         return 0;
/*     */       } 
/* 315 */       return this.field_150862_g;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean func_150857_a(Block p_150857_1_) {
/* 320 */       return (p_150857_1_.field_149764_J == Material.field_151579_a || p_150857_1_ == Blocks.field_150480_ab || p_150857_1_ == Blocks.field_150427_aO);
/*     */     }
/*     */     
/*     */     public boolean func_150860_b() {
/* 324 */       return (this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21);
/*     */     }
/*     */     
/*     */     public void func_150859_c() {
/* 328 */       for (byte b = 0; b < this.field_150868_h; b++) {
/* 329 */         int i = this.field_150861_f.field_71574_a + Direction.field_71583_a[this.field_150866_c] * b;
/* 330 */         int j = this.field_150861_f.field_71573_c + Direction.field_71581_b[this.field_150866_c] * b;
/*     */         
/* 332 */         for (byte b1 = 0; b1 < this.field_150862_g; b1++) {
/* 333 */           int k = this.field_150861_f.field_71572_b + b1;
/* 334 */           this.field_150867_a.func_147465_d(i, k, j, Blocks.field_150427_aO, this.field_150865_b, 2);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPortal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */