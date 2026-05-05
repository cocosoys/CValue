/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.ColorizerFoliage;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BlockLeaves
/*     */   extends BlockLeavesBase
/*     */ {
/*     */   int[] field_150128_a;
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected int field_150127_b;
/*  28 */   protected IIcon[][] field_150129_M = new IIcon[2][]; private static final String __OBFID = "CL_00000263";
/*     */   
/*     */   public BlockLeaves() {
/*  31 */     super(Material.field_151584_j, false);
/*  32 */     func_149675_a(true);
/*  33 */     func_149647_a(CreativeTabs.field_78031_c);
/*  34 */     func_149711_c(0.2F);
/*  35 */     func_149713_g(1);
/*  36 */     func_149672_a(field_149779_h);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149635_D() {
/*  41 */     double d1 = 0.5D;
/*  42 */     double d2 = 1.0D;
/*     */     
/*  44 */     return ColorizerFoliage.func_77470_a(d1, d2);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149741_i(int p_149741_1_) {
/*  49 */     return ColorizerFoliage.func_77468_c();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/*  54 */     int i = 0;
/*  55 */     int j = 0;
/*  56 */     int k = 0;
/*     */     
/*  58 */     for (byte b = -1; b <= 1; b++) {
/*  59 */       for (byte b1 = -1; b1 <= 1; b1++) {
/*  60 */         int m = p_149720_1_.func_72807_a(p_149720_2_ + b1, p_149720_4_ + b).func_150571_c(p_149720_2_ + b1, p_149720_3_, p_149720_4_ + b);
/*     */         
/*  62 */         i += (m & 0xFF0000) >> 16;
/*  63 */         j += (m & 0xFF00) >> 8;
/*  64 */         k += m & 0xFF;
/*     */       } 
/*     */     } 
/*     */     
/*  68 */     return (i / 9 & 0xFF) << 16 | (j / 9 & 0xFF) << 8 | k / 9 & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/*  73 */     byte b = 1;
/*  74 */     int i = b + 1;
/*     */     
/*  76 */     if (p_149749_1_.func_72904_c(p_149749_2_ - i, p_149749_3_ - i, p_149749_4_ - i, p_149749_2_ + i, p_149749_3_ + i, p_149749_4_ + i))
/*  77 */       for (byte b1 = -b; b1 <= b; b1++) {
/*  78 */         for (byte b2 = -b; b2 <= b; b2++) {
/*  79 */           for (byte b3 = -b; b3 <= b; b3++) {
/*  80 */             if (p_149749_1_.func_147439_a(p_149749_2_ + b1, p_149749_3_ + b2, p_149749_4_ + b3).func_149688_o() == Material.field_151584_j) {
/*  81 */               int j = p_149749_1_.func_72805_g(p_149749_2_ + b1, p_149749_3_ + b2, p_149749_4_ + b3);
/*  82 */               p_149749_1_.func_72921_c(p_149749_2_ + b1, p_149749_3_ + b2, p_149749_4_ + b3, j | 0x8, 4);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }  
/*     */   }
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  90 */     if (p_149674_1_.field_72995_K)
/*     */       return; 
/*  92 */     int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  93 */     if ((i & 0x8) != 0 && (i & 0x4) == 0) {
/*  94 */       byte b1 = 4;
/*  95 */       int j = b1 + 1;
/*     */       
/*  97 */       byte b2 = 32;
/*  98 */       int k = b2 * b2;
/*  99 */       int m = b2 / 2;
/* 100 */       if (this.field_150128_a == null) {
/* 101 */         this.field_150128_a = new int[b2 * b2 * b2];
/*     */       }
/*     */       
/* 104 */       if (p_149674_1_.func_72904_c(p_149674_2_ - j, p_149674_3_ - j, p_149674_4_ - j, p_149674_2_ + j, p_149674_3_ + j, p_149674_4_ + j)) {
/* 105 */         byte b; for (b = -b1; b <= b1; b++) {
/* 106 */           for (byte b3 = -b1; b3 <= b1; b3++) {
/* 107 */             for (byte b4 = -b1; b4 <= b1; b4++) {
/* 108 */               Block block = p_149674_1_.func_147439_a(p_149674_2_ + b, p_149674_3_ + b3, p_149674_4_ + b4);
/* 109 */               if (block == Blocks.field_150364_r || block == Blocks.field_150363_s)
/* 110 */               { this.field_150128_a[(b + m) * k + (b3 + m) * b2 + b4 + m] = 0; }
/* 111 */               else if (block.func_149688_o() == Material.field_151584_j)
/* 112 */               { this.field_150128_a[(b + m) * k + (b3 + m) * b2 + b4 + m] = -2; }
/*     */               else
/* 114 */               { this.field_150128_a[(b + m) * k + (b3 + m) * b2 + b4 + m] = -1; } 
/*     */             } 
/*     */           } 
/* 117 */         }  for (b = 1; b <= 4; b++) {
/* 118 */           for (byte b3 = -b1; b3 <= b1; b3++) {
/* 119 */             for (byte b4 = -b1; b4 <= b1; b4++) {
/* 120 */               for (byte b5 = -b1; b5 <= b1; b5++) {
/* 121 */                 if (this.field_150128_a[(b3 + m) * k + (b4 + m) * b2 + b5 + m] == b - 1) {
/* 122 */                   if (this.field_150128_a[(b3 + m - 1) * k + (b4 + m) * b2 + b5 + m] == -2) {
/* 123 */                     this.field_150128_a[(b3 + m - 1) * k + (b4 + m) * b2 + b5 + m] = b;
/*     */                   }
/* 125 */                   if (this.field_150128_a[(b3 + m + 1) * k + (b4 + m) * b2 + b5 + m] == -2) {
/* 126 */                     this.field_150128_a[(b3 + m + 1) * k + (b4 + m) * b2 + b5 + m] = b;
/*     */                   }
/* 128 */                   if (this.field_150128_a[(b3 + m) * k + (b4 + m - 1) * b2 + b5 + m] == -2) {
/* 129 */                     this.field_150128_a[(b3 + m) * k + (b4 + m - 1) * b2 + b5 + m] = b;
/*     */                   }
/* 131 */                   if (this.field_150128_a[(b3 + m) * k + (b4 + m + 1) * b2 + b5 + m] == -2) {
/* 132 */                     this.field_150128_a[(b3 + m) * k + (b4 + m + 1) * b2 + b5 + m] = b;
/*     */                   }
/* 134 */                   if (this.field_150128_a[(b3 + m) * k + (b4 + m) * b2 + b5 + m - 1] == -2) {
/* 135 */                     this.field_150128_a[(b3 + m) * k + (b4 + m) * b2 + b5 + m - 1] = b;
/*     */                   }
/* 137 */                   if (this.field_150128_a[(b3 + m) * k + (b4 + m) * b2 + b5 + m + 1] == -2)
/* 138 */                     this.field_150128_a[(b3 + m) * k + (b4 + m) * b2 + b5 + m + 1] = b; 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 145 */       int n = this.field_150128_a[m * k + m * b2 + m];
/* 146 */       if (n >= 0) {
/* 147 */         p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i & 0xFFFFFFF7, 4);
/*     */       } else {
/* 149 */         func_150126_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 156 */     if (p_149734_1_.func_72951_B(p_149734_2_, p_149734_3_ + 1, p_149734_4_) && !World.func_147466_a((IBlockAccess)p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && p_149734_5_.nextInt(15) == 1) {
/* 157 */       double d1 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 158 */       double d2 = p_149734_3_ - 0.05D;
/* 159 */       double d3 = (p_149734_4_ + p_149734_5_.nextFloat());
/*     */       
/* 161 */       p_149734_1_.func_72869_a("dripWater", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_150126_e(World p_150126_1_, int p_150126_2_, int p_150126_3_, int p_150126_4_) {
/* 166 */     func_149697_b(p_150126_1_, p_150126_2_, p_150126_3_, p_150126_4_, p_150126_1_.func_72805_g(p_150126_2_, p_150126_3_, p_150126_4_), 0);
/* 167 */     p_150126_1_.func_147468_f(p_150126_2_, p_150126_3_, p_150126_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 172 */     return (p_149745_1_.nextInt(20) == 0) ? 1 : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 177 */     return Item.func_150898_a(Blocks.field_150345_g);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 182 */     if (!p_149690_1_.field_72995_K) {
/* 183 */       int i = func_150123_b(p_149690_5_);
/* 184 */       if (p_149690_7_ > 0) {
/* 185 */         i -= 2 << p_149690_7_;
/* 186 */         if (i < 10) {
/* 187 */           i = 10;
/*     */         }
/*     */       } 
/* 190 */       if (p_149690_1_.field_73012_v.nextInt(i) == 0) {
/* 191 */         Item item = func_149650_a(p_149690_5_, p_149690_1_.field_73012_v, p_149690_7_);
/* 192 */         func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(item, 1, func_149692_a(p_149690_5_)));
/*     */       } 
/*     */       
/* 195 */       i = 200;
/* 196 */       if (p_149690_7_ > 0) {
/* 197 */         i -= 10 << p_149690_7_;
/* 198 */         if (i < 40) {
/* 199 */           i = 40;
/*     */         }
/*     */       } 
/* 202 */       func_150124_c(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {}
/*     */ 
/*     */   
/*     */   protected int func_150123_b(int p_150123_1_) {
/* 211 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
/* 216 */     if (!p_149636_1_.field_72995_K && p_149636_2_.func_71045_bC() != null && p_149636_2_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
/* 217 */       p_149636_2_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
/*     */ 
/*     */       
/* 220 */       func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, new ItemStack(Item.func_150898_a(this), 1, p_149636_6_ & 0x3));
/*     */     } else {
/* 222 */       super.func_149636_a(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/* 228 */     return p_149692_1_ & 0x3;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 233 */     return !this.field_150121_P;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public abstract IIcon func_149691_a(int paramInt1, int paramInt2);
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150122_b(boolean p_150122_1_) {
/* 240 */     this.field_150121_P = p_150122_1_;
/* 241 */     this.field_150127_b = p_150122_1_ ? 0 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 249 */     return new ItemStack(Item.func_150898_a(this), 1, p_149644_1_ & 0x3);
/*     */   }
/*     */   
/*     */   public abstract String[] func_150125_e();
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */