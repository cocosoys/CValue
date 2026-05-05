/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockStem extends BlockBush implements IGrowable {
/*     */   private final Block field_149877_a;
/*     */   
/*     */   protected BlockStem(Block p_i45430_1_) {
/*  16 */     this.field_149877_a = p_i45430_1_;
/*     */     
/*  18 */     func_149675_a(true);
/*  19 */     float f = 0.125F;
/*  20 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
/*  21 */     func_149647_a(null);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149876_b; private static final String __OBFID = "CL_00000316";
/*     */   protected boolean func_149854_a(Block p_149854_1_) {
/*  26 */     return (p_149854_1_ == Blocks.field_150458_ak);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  31 */     super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*  32 */     if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
/*     */       
/*  34 */       float f = func_149875_n(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*     */       
/*  36 */       if (p_149674_5_.nextInt((int)(25.0F / f) + 1) == 0) {
/*  37 */         int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  38 */         if (i < 7) {
/*  39 */           i++;
/*  40 */           p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i, 2);
/*     */         } else {
/*  42 */           if (p_149674_1_.func_147439_a(p_149674_2_ - 1, p_149674_3_, p_149674_4_) == this.field_149877_a)
/*  43 */             return;  if (p_149674_1_.func_147439_a(p_149674_2_ + 1, p_149674_3_, p_149674_4_) == this.field_149877_a)
/*  44 */             return;  if (p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_, p_149674_4_ - 1) == this.field_149877_a)
/*  45 */             return;  if (p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_, p_149674_4_ + 1) == this.field_149877_a)
/*     */             return; 
/*  47 */           int j = p_149674_5_.nextInt(4);
/*  48 */           int k = p_149674_2_;
/*  49 */           int m = p_149674_4_;
/*  50 */           if (j == 0) k--; 
/*  51 */           if (j == 1) k++; 
/*  52 */           if (j == 2) m--; 
/*  53 */           if (j == 3) m++; 
/*  54 */           Block block = p_149674_1_.func_147439_a(k, p_149674_3_ - 1, m);
/*  55 */           if ((p_149674_1_.func_147439_a(k, p_149674_3_, m)).field_149764_J == Material.field_151579_a && (block == Blocks.field_150458_ak || block == Blocks.field_150346_d || block == Blocks.field_150349_c)) {
/*  56 */             p_149674_1_.func_147449_b(k, p_149674_3_, m, this.field_149877_a);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149874_m(World p_149874_1_, int p_149874_2_, int p_149874_3_, int p_149874_4_) {
/*  65 */     int i = p_149874_1_.func_72805_g(p_149874_2_, p_149874_3_, p_149874_4_) + MathHelper.func_76136_a(p_149874_1_.field_73012_v, 2, 5);
/*  66 */     if (i > 7) i = 7; 
/*  67 */     p_149874_1_.func_72921_c(p_149874_2_, p_149874_3_, p_149874_4_, i, 2);
/*     */   }
/*     */   
/*     */   private float func_149875_n(World p_149875_1_, int p_149875_2_, int p_149875_3_, int p_149875_4_) {
/*  71 */     float f = 1.0F;
/*     */     
/*  73 */     Block block1 = p_149875_1_.func_147439_a(p_149875_2_, p_149875_3_, p_149875_4_ - 1);
/*  74 */     Block block2 = p_149875_1_.func_147439_a(p_149875_2_, p_149875_3_, p_149875_4_ + 1);
/*  75 */     Block block3 = p_149875_1_.func_147439_a(p_149875_2_ - 1, p_149875_3_, p_149875_4_);
/*  76 */     Block block4 = p_149875_1_.func_147439_a(p_149875_2_ + 1, p_149875_3_, p_149875_4_);
/*     */     
/*  78 */     Block block5 = p_149875_1_.func_147439_a(p_149875_2_ - 1, p_149875_3_, p_149875_4_ - 1);
/*  79 */     Block block6 = p_149875_1_.func_147439_a(p_149875_2_ + 1, p_149875_3_, p_149875_4_ - 1);
/*  80 */     Block block7 = p_149875_1_.func_147439_a(p_149875_2_ + 1, p_149875_3_, p_149875_4_ + 1);
/*  81 */     Block block8 = p_149875_1_.func_147439_a(p_149875_2_ - 1, p_149875_3_, p_149875_4_ + 1);
/*     */     
/*  83 */     boolean bool1 = (block3 == this || block4 == this) ? true : false;
/*  84 */     boolean bool2 = (block1 == this || block2 == this) ? true : false;
/*  85 */     boolean bool3 = (block5 == this || block6 == this || block7 == this || block8 == this) ? true : false;
/*     */     
/*  87 */     for (int i = p_149875_2_ - 1; i <= p_149875_2_ + 1; i++) {
/*  88 */       for (int j = p_149875_4_ - 1; j <= p_149875_4_ + 1; j++) {
/*  89 */         Block block = p_149875_1_.func_147439_a(i, p_149875_3_ - 1, j);
/*     */         
/*  91 */         float f1 = 0.0F;
/*  92 */         if (block == Blocks.field_150458_ak) {
/*  93 */           f1 = 1.0F;
/*  94 */           if (p_149875_1_.func_72805_g(i, p_149875_3_ - 1, j) > 0) f1 = 3.0F;
/*     */         
/*     */         } 
/*  97 */         if (i != p_149875_2_ || j != p_149875_4_) f1 /= 4.0F;
/*     */         
/*  99 */         f += f1;
/*     */       } 
/*     */     } 
/* 102 */     if (bool3 || (bool1 && bool2)) f /= 2.0F;
/*     */     
/* 104 */     return f;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149741_i(int p_149741_1_) {
/* 109 */     int i = p_149741_1_ * 32;
/* 110 */     int j = 255 - p_149741_1_ * 8;
/* 111 */     int k = p_149741_1_ * 4;
/* 112 */     return i << 16 | j << 8 | k;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/* 117 */     return func_149741_i(p_149720_1_.func_72805_g(p_149720_2_, p_149720_3_, p_149720_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/* 122 */     float f = 0.125F;
/* 123 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/* 128 */     this.field_149756_F = ((p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_) * 2 + 2) / 16.0F);
/* 129 */     float f = 0.125F;
/* 130 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, (float)this.field_149756_F, 0.5F + f);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 135 */     return 19;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149873_e(IBlockAccess p_149873_1_, int p_149873_2_, int p_149873_3_, int p_149873_4_) {
/* 139 */     int i = p_149873_1_.func_72805_g(p_149873_2_, p_149873_3_, p_149873_4_);
/* 140 */     if (i < 7) return -1; 
/* 141 */     if (p_149873_1_.func_147439_a(p_149873_2_ - 1, p_149873_3_, p_149873_4_) == this.field_149877_a) return 0; 
/* 142 */     if (p_149873_1_.func_147439_a(p_149873_2_ + 1, p_149873_3_, p_149873_4_) == this.field_149877_a) return 1; 
/* 143 */     if (p_149873_1_.func_147439_a(p_149873_2_, p_149873_3_, p_149873_4_ - 1) == this.field_149877_a) return 2; 
/* 144 */     if (p_149873_1_.func_147439_a(p_149873_2_, p_149873_3_, p_149873_4_ + 1) == this.field_149877_a) return 3; 
/* 145 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 154 */     super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
/*     */     
/* 156 */     if (p_149690_1_.field_72995_K) {
/*     */       return;
/*     */     }
/*     */     
/* 160 */     Item item = null;
/* 161 */     if (this.field_149877_a == Blocks.field_150423_aK) item = Items.field_151080_bb; 
/* 162 */     if (this.field_149877_a == Blocks.field_150440_ba) item = Items.field_151081_bc; 
/* 163 */     for (byte b = 0; b < 3; b++) {
/* 164 */       if (p_149690_1_.field_73012_v.nextInt(15) <= p_149690_5_) {
/* 165 */         func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(item));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 176 */     return 1;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 181 */     if (this.field_149877_a == Blocks.field_150423_aK)
/* 182 */       return Items.field_151080_bb; 
/* 183 */     if (this.field_149877_a == Blocks.field_150440_ba) {
/* 184 */       return Items.field_151081_bc;
/*     */     }
/*     */     
/* 187 */     return Item.func_150899_d(0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 192 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_disconnected");
/* 193 */     this.field_149876_b = p_149651_1_.func_94245_a(func_149641_N() + "_connected");
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149872_i() {
/* 197 */     return this.field_149876_b;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 202 */     if (p_149851_1_.func_72805_g(p_149851_2_, p_149851_3_, p_149851_4_) == 7) {
/* 203 */       return false;
/*     */     }
/* 205 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 210 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 215 */     func_149874_m(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockStem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */