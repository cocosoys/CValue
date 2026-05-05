/*     */ package JinRyuu.DragonBC.common.Blocks.m;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.m.WorldGenMahagonyTree;
/*     */ import JinRyuu.DragonBC.common.m.WorldGenMapleTree;
/*     */ import JinRyuu.DragonBC.common.m.WorldGenSakuraTree;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
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
/*     */ import net.minecraft.world.gen.feature.WorldGenBigTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenTrees;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ import net.minecraftforge.event.terraingen.TerrainGen;
/*     */ 
/*     */ public class MySapling
/*     */   extends BlockSapling {
/*  29 */   public static final String[] saplings = new String[] { "Sakura", "Mahagony", "Maple" };
/*  30 */   private static final IIcon[] iconLength = new IIcon[saplings.length];
/*     */ 
/*     */   
/*     */   public MySapling() {
/*  34 */     float f = 0.4F;
/*  35 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
/*  36 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*  37 */     func_149672_a(field_149779_h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random random) {
/*  45 */     if (!world.field_72995_K) {
/*     */       
/*  47 */       super.func_149674_a(world, x, y, z, random);
/*     */       
/*  49 */       if (world.func_72957_l(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
/*     */       {
/*  51 */         func_149879_c(world, x, y, z, random);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  62 */     meta &= 0x7;
/*  63 */     return iconLength[MathHelper.func_76125_a(meta, 0, 5)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149879_c(World world, int x, int y, int z, Random random) {
/*  69 */     int l = world.func_72805_g(x, y, z);
/*     */     
/*  71 */     if ((l & 0x8) == 0) {
/*     */       
/*  73 */       world.func_72921_c(x, y, z, l | 0x8, 4);
/*     */     }
/*     */     else {
/*     */       
/*  77 */       func_149878_d(world, x, y, z, random);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149878_d(World world, int x, int y, int z, Random random) {
/*  84 */     if (!TerrainGen.saplingGrowTree(world, random, x, y, z))
/*  85 */       return;  int l = world.func_72805_g(x, y, z) & 0x7;
/*  86 */     Object object = (random.nextInt(10) == 0) ? new WorldGenBigTree(true) : new WorldGenTrees(true);
/*  87 */     int i1 = 0;
/*  88 */     int j1 = 0;
/*  89 */     boolean flag = false;
/*     */     
/*  91 */     switch (l) {
/*     */       
/*     */       case 0:
/*  94 */         object = new WorldGenSakuraTree();
/*     */         break;
/*     */       case 1:
/*  97 */         object = new WorldGenMahagonyTree();
/*     */         break;
/*     */       case 2:
/* 100 */         object = new WorldGenMapleTree();
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     Block block = Blocks.field_150350_a;
/*     */     
/* 114 */     if (flag) {
/*     */       
/* 116 */       world.func_147465_d(x + i1, y, z + j1, block, 0, 4);
/* 117 */       world.func_147465_d(x + i1 + 1, y, z + j1, block, 0, 4);
/* 118 */       world.func_147465_d(x + i1, y, z + j1 + 1, block, 0, 4);
/* 119 */       world.func_147465_d(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
/*     */     }
/*     */     else {
/*     */       
/* 123 */       world.func_147465_d(x, y, z, block, 0, 4);
/*     */     } 
/*     */     
/* 126 */     if (!((WorldGenerator)object).func_76484_a(world, random, x + i1, y, z + j1))
/*     */     {
/* 128 */       if (flag) {
/*     */         
/* 130 */         world.func_147465_d(x + i1, y, z + j1, (Block)this, l, 4);
/* 131 */         world.func_147465_d(x + i1 + 1, y, z + j1, (Block)this, l, 4);
/* 132 */         world.func_147465_d(x + i1, y, z + j1 + 1, (Block)this, l, 4);
/* 133 */         world.func_147465_d(x + i1 + 1, y, z + j1 + 1, (Block)this, l, 4);
/*     */       }
/*     */       else {
/*     */         
/* 137 */         world.func_147465_d(x, y, z, (Block)this, l, 4);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149880_a(World world, int x, int y, int z, int par1) {
/* 144 */     return (world.func_147439_a(x, y, z) == this && (world.func_72805_g(x, y, z) & 0x7) == par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/* 152 */     return MathHelper.func_76125_a(p_149692_1_ & 0x7, 0, 5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 161 */     for (int i = 0; i < saplings.length; i++) {
/* 162 */       list.add(new ItemStack(item, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister iconRegister) {
/* 169 */     for (int i = 0; i < iconLength.length; i++)
/*     */     {
/* 171 */       iconLength[i] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_149739_a().substring(5) + saplings[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 182 */     return (p_149852_1_.field_73012_v.nextFloat() < 0.45D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 187 */     func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\MySapling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */