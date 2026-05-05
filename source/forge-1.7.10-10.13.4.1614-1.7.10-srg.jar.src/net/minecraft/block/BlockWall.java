/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockWall
/*     */   extends Block
/*     */ {
/*  22 */   public static final String[] field_150092_a = new String[] { "normal", "mossy" };
/*     */   
/*     */   private static final String __OBFID = "CL_00000331";
/*     */   
/*     */   public BlockWall(Block p_i45435_1_) {
/*  27 */     super(p_i45435_1_.field_149764_J);
/*     */     
/*  29 */     func_149711_c(p_i45435_1_.field_149782_v);
/*  30 */     func_149752_b(p_i45435_1_.field_149781_w / 3.0F);
/*  31 */     func_149672_a(p_i45435_1_.field_149762_H);
/*  32 */     func_149647_a(CreativeTabs.field_78030_b);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  37 */     if (p_149691_2_ == 1) {
/*  38 */       return Blocks.field_150341_Y.func_149733_h(p_149691_1_);
/*     */     }
/*  40 */     return Blocks.field_150347_e.func_149733_h(p_149691_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  45 */     return 32;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  55 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  65 */     boolean bool1 = func_150091_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1);
/*  66 */     boolean bool2 = func_150091_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1);
/*  67 */     boolean bool3 = func_150091_e(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_);
/*  68 */     boolean bool4 = func_150091_e(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_);
/*     */     
/*  70 */     float f1 = 0.25F;
/*  71 */     float f2 = 0.75F;
/*  72 */     float f3 = 0.25F;
/*  73 */     float f4 = 0.75F;
/*  74 */     float f5 = 1.0F;
/*     */     
/*  76 */     if (bool1) {
/*  77 */       f3 = 0.0F;
/*     */     }
/*  79 */     if (bool2) {
/*  80 */       f4 = 1.0F;
/*     */     }
/*  82 */     if (bool3) {
/*  83 */       f1 = 0.0F;
/*     */     }
/*  85 */     if (bool4) {
/*  86 */       f2 = 1.0F;
/*     */     }
/*     */     
/*  89 */     if (bool1 && bool2 && !bool3 && !bool4) {
/*  90 */       f5 = 0.8125F;
/*  91 */       f1 = 0.3125F;
/*  92 */       f2 = 0.6875F;
/*  93 */     } else if (!bool1 && !bool2 && bool3 && bool4) {
/*  94 */       f5 = 0.8125F;
/*  95 */       f3 = 0.3125F;
/*  96 */       f4 = 0.6875F;
/*     */     } 
/*     */     
/*  99 */     func_149676_a(f1, 0.0F, f3, f2, f5, f4);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 104 */     func_149719_a((IBlockAccess)p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/* 105 */     this.field_149756_F = 1.5D;
/* 106 */     return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_150091_e(IBlockAccess p_150091_1_, int p_150091_2_, int p_150091_3_, int p_150091_4_) {
/* 111 */     Block block = p_150091_1_.func_147439_a(p_150091_2_, p_150091_3_, p_150091_4_);
/* 112 */     if (block == this || block == Blocks.field_150396_be) {
/* 113 */       return true;
/*     */     }
/* 115 */     if (block.field_149764_J.func_76218_k() && block.func_149686_d()) {
/* 116 */       return (block.field_149764_J != Material.field_151572_C);
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 123 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/* 124 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/* 129 */     return p_149692_1_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 134 */     if (p_149646_5_ == 0) {
/* 135 */       return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*     */     }
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */