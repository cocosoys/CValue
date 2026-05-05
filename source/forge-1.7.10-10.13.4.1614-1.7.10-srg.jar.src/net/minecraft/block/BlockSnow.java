/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockSnow extends Block {
/*     */   protected BlockSnow() {
/*  19 */     super(Material.field_151597_y);
/*  20 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*  21 */     func_149675_a(true);
/*  22 */     func_149647_a(CreativeTabs.field_78031_c);
/*  23 */     func_150154_b(0);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000309";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  28 */     this.field_149761_L = p_149651_1_.func_94245_a("snow");
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  33 */     int i = p_149668_1_.func_72805_g(p_149668_2_, p_149668_3_, p_149668_4_) & 0x7;
/*  34 */     float f = 0.125F;
/*  35 */     return AxisAlignedBB.func_72330_a(p_149668_2_ + this.field_149759_B, p_149668_3_ + this.field_149760_C, p_149668_4_ + this.field_149754_D, p_149668_2_ + this.field_149755_E, (p_149668_3_ + i * f), p_149668_4_ + this.field_149757_G);
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
/*     */   public boolean func_149662_c() {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  59 */     func_150154_b(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  64 */     func_150154_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
/*     */   }
/*     */   
/*     */   protected void func_150154_b(int p_150154_1_) {
/*  68 */     int i = p_150154_1_ & 0x7;
/*  69 */     float f = (2 * (1 + i)) / 16.0F;
/*  70 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  75 */     Block block = p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_);
/*     */     
/*  77 */     if (block == Blocks.field_150432_aD || block == Blocks.field_150403_cj) return false;
/*     */     
/*  79 */     if (block.func_149688_o() == Material.field_151584_j) return true;
/*     */     
/*  81 */     if (block == this && (p_149742_1_.func_72805_g(p_149742_2_, p_149742_3_ - 1, p_149742_4_) & 0x7) == 7) return true;
/*     */     
/*  83 */     return (block.func_149662_c() && block.field_149764_J.func_76230_c());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  88 */     func_150155_m(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/*     */   }
/*     */   
/*     */   private boolean func_150155_m(World p_150155_1_, int p_150155_2_, int p_150155_3_, int p_150155_4_) {
/*  92 */     if (!func_149742_c(p_150155_1_, p_150155_2_, p_150155_3_, p_150155_4_)) {
/*  93 */       func_149697_b(p_150155_1_, p_150155_2_, p_150155_3_, p_150155_4_, p_150155_1_.func_72805_g(p_150155_2_, p_150155_3_, p_150155_4_), 0);
/*  94 */       p_150155_1_.func_147468_f(p_150155_2_, p_150155_3_, p_150155_4_);
/*  95 */       return false;
/*     */     } 
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
/* 102 */     int i = p_149636_6_ & 0x7;
/* 103 */     func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, new ItemStack(Items.field_151126_ay, i + 1, 0));
/* 104 */     p_149636_1_.func_147468_f(p_149636_3_, p_149636_4_, p_149636_5_);
/*     */     
/* 106 */     p_149636_2_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 111 */     return Items.field_151126_ay;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 116 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 121 */     if (p_149674_1_.func_72972_b(EnumSkyBlock.Block, p_149674_2_, p_149674_3_, p_149674_4_) > 11) {
/* 122 */       func_149697_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 0);
/* 123 */       p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 129 */     if (p_149646_5_ == 1) return true; 
/* 130 */     return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSnow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */