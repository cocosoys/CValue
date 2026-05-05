/*     */ package net.minecraft.block;
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
/*     */ public class BlockCarpet extends Block {
/*     */   protected BlockCarpet() {
/*  18 */     super(Material.field_151593_r);
/*  19 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
/*  20 */     func_149675_a(true);
/*  21 */     func_149647_a(CreativeTabs.field_78031_c);
/*  22 */     func_150089_b(0);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000338";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  27 */     return Blocks.field_150325_L.func_149691_a(p_149691_1_, p_149691_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  32 */     boolean bool = false;
/*  33 */     float f = 0.0625F;
/*  34 */     return AxisAlignedBB.func_72330_a(p_149668_2_ + this.field_149759_B, p_149668_3_ + this.field_149760_C, p_149668_4_ + this.field_149754_D, p_149668_2_ + this.field_149755_E, (p_149668_3_ + bool * f), p_149668_4_ + this.field_149757_G);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  48 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  53 */     func_150089_b(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  58 */     func_150089_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
/*     */   }
/*     */   
/*     */   protected void func_150089_b(int p_150089_1_) {
/*  62 */     byte b = 0;
/*  63 */     float f = (1 * (1 + b)) / 16.0F;
/*  64 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  69 */     return (super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && func_149718_j(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  74 */     func_150090_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/*     */   }
/*     */   
/*     */   private boolean func_150090_e(World p_150090_1_, int p_150090_2_, int p_150090_3_, int p_150090_4_) {
/*  78 */     if (!func_149718_j(p_150090_1_, p_150090_2_, p_150090_3_, p_150090_4_)) {
/*  79 */       func_149697_b(p_150090_1_, p_150090_2_, p_150090_3_, p_150090_4_, p_150090_1_.func_72805_g(p_150090_2_, p_150090_3_, p_150090_4_), 0);
/*  80 */       p_150090_1_.func_147468_f(p_150090_2_, p_150090_3_, p_150090_4_);
/*  81 */       return false;
/*     */     } 
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  88 */     return !p_149718_1_.func_147437_c(p_149718_2_, p_149718_3_ - 1, p_149718_4_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/*  93 */     if (p_149646_5_ == 1) return true; 
/*  94 */     return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/*  99 */     return p_149692_1_;
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 112 */     for (byte b = 0; b < 16; b++)
/* 113 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b)); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCarpet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */