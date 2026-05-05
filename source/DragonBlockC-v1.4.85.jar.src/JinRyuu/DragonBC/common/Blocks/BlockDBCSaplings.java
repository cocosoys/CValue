/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Worlds.WorldGenNamekTrees;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockSapling;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ import net.minecraftforge.event.terraingen.TerrainGen;
/*     */ 
/*     */ public class BlockDBCSaplings
/*     */   extends BlockSapling {
/*  24 */   public static final String[] field_149882_a = new String[] { "Namek" };
/*  25 */   private static final IIcon[] field_149881_b = new IIcon[field_149882_a.length];
/*     */ 
/*     */   
/*     */   protected BlockDBCSaplings() {
/*  29 */     float f = 0.4F;
/*  30 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
/*  31 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  39 */     if (!p_149674_1_.field_72995_K) {
/*     */       
/*  41 */       super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */       
/*  43 */       if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9 && p_149674_5_.nextInt(7) == 0)
/*     */       {
/*  45 */         func_149879_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  56 */     p_149691_2_ &= 0x7;
/*  57 */     if (p_149691_2_ != 0) return field_149881_b[0]; 
/*  58 */     return field_149881_b[MathHelper.func_76125_a(p_149691_2_, 0, 5)];
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149879_c(World p_149879_1_, int p_149879_2_, int p_149879_3_, int p_149879_4_, Random p_149879_5_) {
/*  63 */     int l = p_149879_1_.func_72805_g(p_149879_2_, p_149879_3_, p_149879_4_);
/*     */     
/*  65 */     if ((l & 0x8) == 0) {
/*     */       
/*  67 */       p_149879_1_.func_72921_c(p_149879_2_, p_149879_3_, p_149879_4_, l | 0x8, 4);
/*     */     }
/*     */     else {
/*     */       
/*  71 */       func_149878_d(p_149879_1_, p_149879_2_, p_149879_3_, p_149879_4_, p_149879_5_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149878_d(World p_149878_1_, int p_149878_2_, int p_149878_3_, int p_149878_4_, Random p_149878_5_) {
/*  77 */     if (!TerrainGen.saplingGrowTree(p_149878_1_, p_149878_5_, p_149878_2_, p_149878_3_, p_149878_4_))
/*  78 */       return;  int l = p_149878_1_.func_72805_g(p_149878_2_, p_149878_3_, p_149878_4_) & 0x7;
/*  79 */     Object object = (p_149878_5_.nextInt(10) == 0) ? new WorldGenNamekTrees(true) : new WorldGenNamekTrees(true);
/*  80 */     int i1 = 0;
/*  81 */     int j1 = 0;
/*  82 */     boolean flag = false;
/*     */     
/*  84 */     switch (l) {
/*     */ 
/*     */       
/*     */       default:
/*  88 */         object = new WorldGenNamekTrees(true);
/*     */         break;
/*     */       
/*     */       case 1:
/*     */         break;
/*     */     } 
/*  94 */     Block block = Blocks.field_150350_a;
/*     */     
/*  96 */     if (flag) {
/*     */       
/*  98 */       p_149878_1_.func_147465_d(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, block, 0, 4);
/*  99 */       p_149878_1_.func_147465_d(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, block, 0, 4);
/* 100 */       p_149878_1_.func_147465_d(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, block, 0, 4);
/* 101 */       p_149878_1_.func_147465_d(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, block, 0, 4);
/*     */     }
/*     */     else {
/*     */       
/* 105 */       p_149878_1_.func_147465_d(p_149878_2_, p_149878_3_, p_149878_4_, block, 0, 4);
/*     */     } 
/*     */     
/* 108 */     if (!((WorldGenerator)object).func_76484_a(p_149878_1_, p_149878_5_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1))
/*     */     {
/* 110 */       if (flag) {
/*     */         
/* 112 */         p_149878_1_.func_147465_d(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, (Block)this, l, 4);
/* 113 */         p_149878_1_.func_147465_d(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, (Block)this, l, 4);
/* 114 */         p_149878_1_.func_147465_d(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, (Block)this, l, 4);
/* 115 */         p_149878_1_.func_147465_d(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, (Block)this, l, 4);
/*     */       }
/*     */       else {
/*     */         
/* 119 */         p_149878_1_.func_147465_d(p_149878_2_, p_149878_3_, p_149878_4_, (Block)this, l, 4);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149880_a(World p_149880_1_, int p_149880_2_, int p_149880_3_, int p_149880_4_, int p_149880_5_) {
/* 126 */     return (p_149880_1_.func_147439_a(p_149880_2_, p_149880_3_, p_149880_4_) == this && (p_149880_1_.func_72805_g(p_149880_2_, p_149880_3_, p_149880_4_) & 0x7) == p_149880_5_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/* 134 */     return MathHelper.func_76125_a(p_149692_1_ & 0x7, 0, 5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 143 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 154 */     for (int i = 0; i < field_149881_b.length; i++)
/*     */     {
/* 156 */       field_149881_b[i] = par1IconRegister.func_94245_a("jinryuudragonbc:tile.Block" + field_149882_a[i] + "Sapling");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 167 */     return (p_149852_1_.field_73012_v.nextFloat() < 0.45D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 172 */     func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_149854_a(Block p_149854_1_) {
/* 179 */     return (p_149854_1_ == BlocksDBC.BlockNamekGrass);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockDBCSaplings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */