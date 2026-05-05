/*     */ package net.minecraft.block;
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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.world.ColorizerFoliage;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockVine extends Block {
/*     */   public BlockVine() {
/*  21 */     super(Material.field_151582_l);
/*  22 */     func_149675_a(true);
/*  23 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000330";
/*     */   
/*     */   public void func_149683_g() {
/*  28 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  33 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  38 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  49 */     float f1 = 0.0625F;
/*     */     
/*  51 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
/*     */     
/*  53 */     float f2 = 1.0F;
/*  54 */     float f3 = 1.0F;
/*  55 */     float f4 = 1.0F;
/*  56 */     float f5 = 0.0F;
/*  57 */     float f6 = 0.0F;
/*  58 */     float f7 = 0.0F;
/*  59 */     boolean bool = (i > 0) ? true : false;
/*     */     
/*  61 */     if ((i & 0x2) != 0) {
/*  62 */       f5 = Math.max(f5, 0.0625F);
/*  63 */       f2 = 0.0F;
/*  64 */       f3 = 0.0F;
/*  65 */       f6 = 1.0F;
/*  66 */       f4 = 0.0F;
/*  67 */       f7 = 1.0F;
/*  68 */       bool = true;
/*     */     } 
/*  70 */     if ((i & 0x8) != 0) {
/*  71 */       f2 = Math.min(f2, 0.9375F);
/*  72 */       f5 = 1.0F;
/*  73 */       f3 = 0.0F;
/*  74 */       f6 = 1.0F;
/*  75 */       f4 = 0.0F;
/*  76 */       f7 = 1.0F;
/*  77 */       bool = true;
/*     */     } 
/*  79 */     if ((i & 0x4) != 0) {
/*  80 */       f7 = Math.max(f7, 0.0625F);
/*  81 */       f4 = 0.0F;
/*  82 */       f2 = 0.0F;
/*  83 */       f5 = 1.0F;
/*  84 */       f3 = 0.0F;
/*  85 */       f6 = 1.0F;
/*  86 */       bool = true;
/*     */     } 
/*  88 */     if ((i & 0x1) != 0) {
/*  89 */       f4 = Math.min(f4, 0.9375F);
/*  90 */       f7 = 1.0F;
/*  91 */       f2 = 0.0F;
/*  92 */       f5 = 1.0F;
/*  93 */       f3 = 0.0F;
/*  94 */       f6 = 1.0F;
/*  95 */       bool = true;
/*     */     } 
/*  97 */     if (!bool && func_150093_a(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_ + 1, p_149719_4_))) {
/*  98 */       f3 = Math.min(f3, 0.9375F);
/*  99 */       f6 = 1.0F;
/* 100 */       f2 = 0.0F;
/* 101 */       f5 = 1.0F;
/* 102 */       f4 = 0.0F;
/* 103 */       f7 = 1.0F;
/*     */     } 
/* 105 */     func_149676_a(f2, f3, f4, f5, f6, f7);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
/* 115 */     switch (p_149707_5_)
/*     */     { default:
/* 117 */         return false;
/*     */       case 1:
/* 119 */         return func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_ + 1, p_149707_4_));
/*     */       case 2:
/* 121 */         return func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ + 1));
/*     */       case 3:
/* 123 */         return func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ - 1));
/*     */       case 5:
/* 125 */         return func_150093_a(p_149707_1_.func_147439_a(p_149707_2_ - 1, p_149707_3_, p_149707_4_));
/*     */       case 4:
/* 127 */         break; }  return func_150093_a(p_149707_1_.func_147439_a(p_149707_2_ + 1, p_149707_3_, p_149707_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_150093_a(Block p_150093_1_) {
/* 132 */     return (p_150093_1_.func_149686_d() && p_150093_1_.field_149764_J.func_76230_c());
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_150094_e(World p_150094_1_, int p_150094_2_, int p_150094_3_, int p_150094_4_) {
/* 137 */     int i = p_150094_1_.func_72805_g(p_150094_2_, p_150094_3_, p_150094_4_);
/* 138 */     int j = i;
/*     */     
/* 140 */     if (j > 0) {
/* 141 */       for (byte b = 0; b <= 3; b++) {
/* 142 */         int k = 1 << b;
/* 143 */         if ((i & k) != 0 && 
/* 144 */           !func_150093_a(p_150094_1_.func_147439_a(p_150094_2_ + Direction.field_71583_a[b], p_150094_3_, p_150094_4_ + Direction.field_71581_b[b])))
/*     */         {
/* 146 */           if (p_150094_1_.func_147439_a(p_150094_2_, p_150094_3_ + 1, p_150094_4_) != this || (p_150094_1_.func_72805_g(p_150094_2_, p_150094_3_ + 1, p_150094_4_) & k) == 0) {
/* 147 */             j &= k ^ 0xFFFFFFFF;
/*     */           }
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 154 */     if (j == 0)
/*     */     {
/* 156 */       if (!func_150093_a(p_150094_1_.func_147439_a(p_150094_2_, p_150094_3_ + 1, p_150094_4_))) {
/* 157 */         return false;
/*     */       }
/*     */     }
/* 160 */     if (j != i) {
/* 161 */       p_150094_1_.func_72921_c(p_150094_2_, p_150094_3_, p_150094_4_, j, 2);
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149635_D() {
/* 169 */     return ColorizerFoliage.func_77468_c();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149741_i(int p_149741_1_) {
/* 174 */     return ColorizerFoliage.func_77468_c();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/* 179 */     return p_149720_1_.func_72807_a(p_149720_2_, p_149720_4_).func_150571_c(p_149720_2_, p_149720_3_, p_149720_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 184 */     if (!p_149695_1_.field_72995_K && !func_150094_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
/* 185 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
/* 186 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 192 */     if (!p_149674_1_.field_72995_K && 
/* 193 */       p_149674_1_.field_73012_v.nextInt(4) == 0) {
/* 194 */       byte b1 = 4;
/* 195 */       byte b2 = 5;
/* 196 */       boolean bool = false; int i;
/* 197 */       label85: for (i = p_149674_2_ - b1; i <= p_149674_2_ + b1; i++) {
/* 198 */         for (int m = p_149674_4_ - b1; m <= p_149674_4_ + b1; m++) {
/* 199 */           for (int n = p_149674_3_ - 1; n <= p_149674_3_ + 1; n++) {
/* 200 */             if (p_149674_1_.func_147439_a(i, n, m) == this && --b2 <= 0) {
/* 201 */               bool = true; break label85;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 206 */       i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/* 207 */       int j = p_149674_1_.field_73012_v.nextInt(6);
/* 208 */       int k = Direction.field_71579_d[j];
/*     */       
/* 210 */       if (j == 1 && p_149674_3_ < 255 && p_149674_1_.func_147437_c(p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
/* 211 */         if (bool)
/*     */           return; 
/* 213 */         int m = p_149674_1_.field_73012_v.nextInt(16) & i;
/* 214 */         if (m > 0) {
/* 215 */           for (byte b = 0; b <= 3; b++) {
/* 216 */             if (!func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[b], p_149674_3_ + 1, p_149674_4_ + Direction.field_71581_b[b]))) {
/* 217 */               m &= 1 << b ^ 0xFFFFFFFF;
/*     */             }
/*     */           } 
/* 220 */           if (m > 0) {
/* 221 */             p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_ + 1, p_149674_4_, this, m, 2);
/*     */           }
/*     */         } 
/* 224 */       } else if (j >= 2 && j <= 5 && (i & 1 << k) == 0) {
/* 225 */         if (bool)
/*     */           return; 
/* 227 */         Block block = p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[k], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k]);
/* 228 */         if (block.field_149764_J == Material.field_151579_a) {
/*     */           
/* 230 */           int m = k + 1 & 0x3;
/* 231 */           int n = k + 3 & 0x3;
/*     */ 
/*     */           
/* 234 */           if ((i & 1 << m) != 0 && func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[k] + Direction.field_71583_a[m], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k] + Direction.field_71581_b[m]))) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 239 */             p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[k], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k], this, 1 << m, 2);
/* 240 */           } else if ((i & 1 << n) != 0 && func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[k] + Direction.field_71583_a[n], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k] + Direction.field_71581_b[n]))) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 245 */             p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[k], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k], this, 1 << n, 2);
/*     */           
/*     */           }
/* 248 */           else if ((i & 1 << m) != 0 && p_149674_1_.func_147437_c(p_149674_2_ + Direction.field_71583_a[k] + Direction.field_71583_a[m], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k] + Direction.field_71581_b[m]) && func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[m], p_149674_3_, p_149674_4_ + Direction.field_71581_b[m]))) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 257 */             p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[k] + Direction.field_71583_a[m], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k] + Direction.field_71581_b[m], this, 1 << (k + 2 & 0x3), 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/* 265 */           else if ((i & 1 << n) != 0 && p_149674_1_.func_147437_c(p_149674_2_ + Direction.field_71583_a[k] + Direction.field_71583_a[n], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k] + Direction.field_71581_b[n]) && func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[n], p_149674_3_, p_149674_4_ + Direction.field_71581_b[n]))) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 274 */             p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[k] + Direction.field_71583_a[n], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k] + Direction.field_71581_b[n], this, 1 << (k + 2 & 0x3), 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/* 284 */           else if (func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[k], p_149674_3_ + 1, p_149674_4_ + Direction.field_71581_b[k]))) {
/* 285 */             p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[k], p_149674_3_, p_149674_4_ + Direction.field_71581_b[k], this, 0, 2);
/*     */           }
/*     */         
/* 288 */         } else if (block.field_149764_J.func_76218_k() && block.func_149686_d()) {
/*     */           
/* 290 */           p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i | 1 << k, 2);
/*     */         }
/*     */       
/*     */       }
/* 294 */       else if (p_149674_3_ > 1) {
/* 295 */         Block block = p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - 1, p_149674_4_);
/*     */         
/* 297 */         if (block.field_149764_J == Material.field_151579_a) {
/* 298 */           int m = p_149674_1_.field_73012_v.nextInt(16) & i;
/* 299 */           if (m > 0) {
/* 300 */             p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_ - 1, p_149674_4_, this, m, 2);
/*     */           }
/* 302 */         } else if (block == this) {
/* 303 */           int m = p_149674_1_.field_73012_v.nextInt(16) & i;
/* 304 */           int n = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_ - 1, p_149674_4_);
/* 305 */           if (n != (n | m)) {
/* 306 */             p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_ - 1, p_149674_4_, n | m, 2);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/* 317 */     byte b = 0;
/* 318 */     switch (p_149660_5_) {
/*     */       case 2:
/* 320 */         b = 1;
/*     */         break;
/*     */       case 3:
/* 323 */         b = 4;
/*     */         break;
/*     */       case 4:
/* 326 */         b = 8;
/*     */         break;
/*     */       case 5:
/* 329 */         b = 2;
/*     */         break;
/*     */     } 
/* 332 */     if (b != 0) {
/* 333 */       return b;
/*     */     }
/* 335 */     return p_149660_9_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 341 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 346 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
/* 351 */     if (!p_149636_1_.field_72995_K && p_149636_2_.func_71045_bC() != null && p_149636_2_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
/* 352 */       p_149636_2_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
/*     */ 
/*     */       
/* 355 */       func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, new ItemStack(Blocks.field_150395_bd, 1, 0));
/*     */     } else {
/* 357 */       super.func_149636_a(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockVine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */