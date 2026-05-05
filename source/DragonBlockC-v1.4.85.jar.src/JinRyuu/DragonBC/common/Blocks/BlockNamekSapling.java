/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Worlds.WorldGenNamekTrees;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockSapling;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ import net.minecraftforge.event.terraingen.TerrainGen;
/*     */ 
/*     */ public class BlockNamekSapling
/*     */   extends BlockSapling {
/*     */   private IIcon BSide;
/*     */   private IIcon BTop;
/*     */   private IIcon BBottom;
/*  22 */   private String side = "ajisasapling";
/*  23 */   private String top = "namekgrasstop";
/*  24 */   private String bottom = "lightdirt";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockNamekSapling() {
/*  30 */     float f = 0.4F;
/*  31 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
/*  32 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  40 */     if (!p_149674_1_.field_72995_K) {
/*     */       
/*  42 */       super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */ 
/*     */       
/*  45 */       if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9 && p_149674_5_.nextInt(7) == 0)
/*     */       {
/*  47 */         func_149879_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  54 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
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
/*     */   public String getTextureFile() {
/*  72 */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */   
/*  76 */   public static final String[] WOOD_TYPES = new String[] { "namek" };
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
/*     */   public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5) {
/* 133 */     return (par1World.func_147439_a(par2, par3, par4) == this && (par1World.func_72805_g(par2, par3, par4) & 0x3) == par5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_149854_a(Block p_149854_1_) {
/* 143 */     return (p_149854_1_ == BlocksDBC.BlockNamekGrass);
/*     */   }
/*     */   
/*     */   protected boolean canThisPlantGrowOnThisBlockID(Block i) {
/* 147 */     return (i == BlocksDBC.BlockNamekGrass);
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
/*     */   public void func_149878_d(World world, int i, int j, int k, Random random) {
/* 176 */     if (!TerrainGen.saplingGrowTree(world, random, i, j, k))
/* 177 */       return;  int l = world.func_72805_g(i, j, k) & 0x3;
/*     */     
/* 179 */     WorldGenerator obj = null;
/* 180 */     WorldGenNamekTrees worldGenNamekTrees = new WorldGenNamekTrees(true);
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
/* 196 */     if (!worldGenNamekTrees.func_76484_a(world, random, i, j, k));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int par1) {
/* 207 */     return par1 & 0x3;
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
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 234 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 242 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 250 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149879_c(World p_149879_1_, int p_149879_2_, int p_149879_3_, int p_149879_4_, Random p_149879_5_) {
/* 256 */     int l = p_149879_1_.func_72805_g(p_149879_2_, p_149879_3_, p_149879_4_);
/*     */     
/* 258 */     if ((l & 0x8) == 0) {
/*     */       
/* 260 */       p_149879_1_.func_72921_c(p_149879_2_, p_149879_3_, p_149879_4_, l | 0x8, 4);
/*     */     }
/*     */     else {
/*     */       
/* 264 */       func_149878_d(p_149879_1_, p_149879_2_, p_149879_3_, p_149879_4_, p_149879_5_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 272 */     return 1;
/*     */   }
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 276 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 281 */     return (p_149852_1_.field_73012_v.nextFloat() < 0.45D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 286 */     func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockNamekSapling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */