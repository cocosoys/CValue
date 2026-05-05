/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenBigTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenCanopyTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenForest;
/*     */ import net.minecraft.world.gen.feature.WorldGenMegaJungle;
/*     */ import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenSavannaTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenTaiga2;
/*     */ import net.minecraft.world.gen.feature.WorldGenTrees;
/*     */ 
/*     */ public class BlockSapling
/*     */   extends BlockBush
/*     */   implements IGrowable {
/*  27 */   public static final String[] field_149882_a = new String[] { "oak", "spruce", "birch", "jungle", "acacia", "roofed_oak" };
/*     */ 
/*     */ 
/*     */   
/*  31 */   private static final IIcon[] field_149881_b = new IIcon[field_149882_a.length]; private static final String __OBFID = "CL_00000305";
/*     */   
/*     */   protected BlockSapling() {
/*  34 */     float f = 0.4F;
/*  35 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
/*  36 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  41 */     if (p_149674_1_.field_72995_K)
/*     */       return; 
/*  43 */     super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */     
/*  45 */     if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9 && 
/*  46 */       p_149674_5_.nextInt(7) == 0) {
/*  47 */       func_149879_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  54 */     p_149691_2_ &= 0x7;
/*  55 */     return field_149881_b[MathHelper.func_76125_a(p_149691_2_, 0, 5)];
/*     */   }
/*     */   
/*     */   public void func_149879_c(World p_149879_1_, int p_149879_2_, int p_149879_3_, int p_149879_4_, Random p_149879_5_) {
/*  59 */     int i = p_149879_1_.func_72805_g(p_149879_2_, p_149879_3_, p_149879_4_);
/*  60 */     if ((i & 0x8) == 0) {
/*  61 */       p_149879_1_.func_72921_c(p_149879_2_, p_149879_3_, p_149879_4_, i | 0x8, 4);
/*     */     } else {
/*  63 */       func_149878_d(p_149879_1_, p_149879_2_, p_149879_3_, p_149879_4_, p_149879_5_);
/*     */     }  } public void func_149878_d(World p_149878_1_, int p_149878_2_, int p_149878_3_, int p_149878_4_, Random p_149878_5_) {
/*     */     WorldGenForest worldGenForest;
/*     */     WorldGenSavannaTree worldGenSavannaTree;
/*     */     WorldGenCanopyTree worldGenCanopyTree;
/*  68 */     int i = p_149878_1_.func_72805_g(p_149878_2_, p_149878_3_, p_149878_4_) & 0x7;
/*     */     
/*  70 */     WorldGenMegaPineTree worldGenMegaPineTree = (WorldGenMegaPineTree)((p_149878_5_.nextInt(10) == 0) ? new WorldGenBigTree(true) : new WorldGenTrees(true));
/*     */     
/*  72 */     byte b1 = 0, b2 = 0;
/*  73 */     boolean bool = false;
/*     */     
/*  75 */     switch (i) {
/*     */ 
/*     */       
/*     */       case 1:
/*  79 */         label78: for (b1 = 0; b1 >= -1; b1--) {
/*  80 */           for (b2 = 0; b2 >= -1; b2--) {
/*  81 */             if (func_149880_a(p_149878_1_, p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2, 1) && func_149880_a(p_149878_1_, p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2, 1) && func_149880_a(p_149878_1_, p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2 + 1, 1) && func_149880_a(p_149878_1_, p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2 + 1, 1)) {
/*     */               
/*  83 */               worldGenMegaPineTree = new WorldGenMegaPineTree(false, p_149878_5_.nextBoolean());
/*  84 */               bool = true;
/*     */               
/*     */               break label78;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*  91 */         if (!bool) {
/*  92 */           b1 = b2 = 0;
/*  93 */           WorldGenTaiga2 worldGenTaiga2 = new WorldGenTaiga2(true);
/*     */         } 
/*     */         break;
/*     */       
/*     */       case 2:
/*  98 */         worldGenForest = new WorldGenForest(true, false);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/* 103 */         label79: for (b1 = 0; b1 >= -1; b1--) {
/* 104 */           for (b2 = 0; b2 >= -1; b2--) {
/* 105 */             if (func_149880_a(p_149878_1_, p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2, 3) && func_149880_a(p_149878_1_, p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2, 3) && func_149880_a(p_149878_1_, p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2 + 1, 3) && func_149880_a(p_149878_1_, p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2 + 1, 3)) {
/*     */               
/* 107 */               WorldGenMegaJungle worldGenMegaJungle = new WorldGenMegaJungle(true, 10, 20, 3, 3);
/* 108 */               bool = true;
/*     */               
/*     */               break label79;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 115 */         if (!bool) {
/* 116 */           b1 = b2 = 0;
/* 117 */           WorldGenTrees worldGenTrees = new WorldGenTrees(true, 4 + p_149878_5_.nextInt(7), 3, 3, false);
/*     */         } 
/*     */         break;
/*     */       
/*     */       case 4:
/* 122 */         worldGenSavannaTree = new WorldGenSavannaTree(true);
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 5:
/* 128 */         label80: for (b1 = 0; b1 >= -1; b1--) {
/* 129 */           for (b2 = 0; b2 >= -1; b2--) {
/* 130 */             if (func_149880_a(p_149878_1_, p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2, 5) && func_149880_a(p_149878_1_, p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2, 5) && func_149880_a(p_149878_1_, p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2 + 1, 5) && func_149880_a(p_149878_1_, p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2 + 1, 5)) {
/*     */               
/* 132 */               worldGenCanopyTree = new WorldGenCanopyTree(true);
/* 133 */               bool = true;
/*     */               
/*     */               break label80;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 140 */         if (!bool) {
/*     */           return;
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     Block block = Blocks.field_150350_a;
/* 151 */     if (bool) {
/* 152 */       p_149878_1_.func_147465_d(p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2, block, 0, 4);
/* 153 */       p_149878_1_.func_147465_d(p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2, block, 0, 4);
/* 154 */       p_149878_1_.func_147465_d(p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2 + 1, block, 0, 4);
/* 155 */       p_149878_1_.func_147465_d(p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2 + 1, block, 0, 4);
/*     */     } else {
/* 157 */       p_149878_1_.func_147465_d(p_149878_2_, p_149878_3_, p_149878_4_, block, 0, 4);
/*     */     } 
/*     */     
/* 160 */     if (!worldGenCanopyTree.func_76484_a(p_149878_1_, p_149878_5_, p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2)) {
/* 161 */       if (bool) {
/* 162 */         p_149878_1_.func_147465_d(p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2, this, i, 4);
/* 163 */         p_149878_1_.func_147465_d(p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2, this, i, 4);
/* 164 */         p_149878_1_.func_147465_d(p_149878_2_ + b1, p_149878_3_, p_149878_4_ + b2 + 1, this, i, 4);
/* 165 */         p_149878_1_.func_147465_d(p_149878_2_ + b1 + 1, p_149878_3_, p_149878_4_ + b2 + 1, this, i, 4);
/*     */       } else {
/* 167 */         p_149878_1_.func_147465_d(p_149878_2_, p_149878_3_, p_149878_4_, this, i, 4);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_149880_a(World p_149880_1_, int p_149880_2_, int p_149880_3_, int p_149880_4_, int p_149880_5_) {
/* 173 */     return (p_149880_1_.func_147439_a(p_149880_2_, p_149880_3_, p_149880_4_) == this && (p_149880_1_.func_72805_g(p_149880_2_, p_149880_3_, p_149880_4_) & 0x7) == p_149880_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/* 178 */     return MathHelper.func_76125_a(p_149692_1_ & 0x7, 0, 5);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 183 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/* 184 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/* 185 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
/* 186 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 3));
/* 187 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 4));
/* 188 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 5));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 193 */     for (byte b = 0; b < field_149881_b.length; b++) {
/* 194 */       field_149881_b[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + field_149882_a[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 200 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 205 */     return (p_149852_1_.field_73012_v.nextFloat() < 0.45D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 210 */     func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSapling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */