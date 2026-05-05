/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockTallGrass extends BlockBush implements IGrowable {
/*  13 */   private static final String[] field_149871_a = new String[] { "deadbush", "tallgrass", "fern" };
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149870_b;
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000321";
/*     */ 
/*     */   
/*     */   protected BlockTallGrass() {
/*  24 */     super(Material.field_151582_l);
/*  25 */     float f = 0.4F;
/*  26 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  31 */     if (p_149691_2_ >= this.field_149870_b.length) p_149691_2_ = 0; 
/*  32 */     return this.field_149870_b[p_149691_2_];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149635_D() {
/*  37 */     double d1 = 0.5D;
/*  38 */     double d2 = 1.0D;
/*     */     
/*  40 */     return ColorizerGrass.func_77480_a(d1, d2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  45 */     return func_149854_a(p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149741_i(int p_149741_1_) {
/*  50 */     if (p_149741_1_ == 0) return 16777215;
/*     */     
/*  52 */     return ColorizerGrass.func_77480_a(0.5D, 1.0D);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/*  57 */     int i = p_149720_1_.func_72805_g(p_149720_2_, p_149720_3_, p_149720_4_);
/*  58 */     if (i == 0) return 16777215;
/*     */     
/*  60 */     return p_149720_1_.func_72807_a(p_149720_2_, p_149720_4_).func_150558_b(p_149720_2_, p_149720_3_, p_149720_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  65 */     if (p_149650_2_.nextInt(8) == 0) {
/*  66 */       return Items.field_151014_N;
/*     */     }
/*     */     
/*  69 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
/*  74 */     return 1 + p_149679_2_.nextInt(p_149679_1_ * 2 + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
/*  79 */     if (!p_149636_1_.field_72995_K && p_149636_2_.func_71045_bC() != null && p_149636_2_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
/*  80 */       p_149636_2_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
/*     */ 
/*     */       
/*  83 */       func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, new ItemStack(Blocks.field_150329_H, 1, p_149636_6_));
/*     */     } else {
/*  85 */       super.func_149636_a(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/*  91 */     return p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/*  96 */     for (byte b = 1; b < 3; b++) {
/*  97 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b));
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 103 */     this.field_149870_b = new IIcon[field_149871_a.length];
/*     */     
/* 105 */     for (byte b = 0; b < this.field_149870_b.length; b++) {
/* 106 */       this.field_149870_b[b] = p_149651_1_.func_94245_a(field_149871_a[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 112 */     int i = p_149851_1_.func_72805_g(p_149851_2_, p_149851_3_, p_149851_4_);
/* 113 */     if (i == 0) {
/* 114 */       return false;
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 126 */     int i = p_149853_1_.func_72805_g(p_149853_3_, p_149853_4_, p_149853_5_);
/* 127 */     byte b = 2;
/* 128 */     if (i == 2) {
/* 129 */       b = 3;
/*     */     }
/* 131 */     if (Blocks.field_150398_cm.func_149742_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_))
/* 132 */       Blocks.field_150398_cm.func_149889_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, b, 2); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockTallGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */