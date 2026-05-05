/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockReed extends Block {
/*     */   protected BlockReed() {
/*  14 */     super(Material.field_151585_k);
/*  15 */     float f = 0.375F;
/*  16 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
/*  17 */     func_149675_a(true);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000300";
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  22 */     if (p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - 1, p_149674_4_) != Blocks.field_150436_aH && 
/*  23 */       !func_150170_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
/*     */       return;
/*     */     }
/*     */     
/*  27 */     if (p_149674_1_.func_147437_c(p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
/*  28 */       byte b = 1;
/*  29 */       while (p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - b, p_149674_4_) == this) {
/*  30 */         b++;
/*     */       }
/*  32 */       if (b < 3) {
/*  33 */         int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  34 */         if (i == 15) {
/*  35 */           p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_ + 1, p_149674_4_, this);
/*  36 */           p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, 0, 4);
/*     */         } else {
/*  38 */           p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i + 1, 4);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  46 */     Block block = p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_);
/*  47 */     if (block == this) return true; 
/*  48 */     if (block != Blocks.field_150349_c && block != Blocks.field_150346_d && block != Blocks.field_150354_m) return false; 
/*  49 */     if (p_149742_1_.func_147439_a(p_149742_2_ - 1, p_149742_3_ - 1, p_149742_4_).func_149688_o() == Material.field_151586_h) return true; 
/*  50 */     if (p_149742_1_.func_147439_a(p_149742_2_ + 1, p_149742_3_ - 1, p_149742_4_).func_149688_o() == Material.field_151586_h) return true; 
/*  51 */     if (p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_ - 1).func_149688_o() == Material.field_151586_h) return true; 
/*  52 */     if (p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_ + 1).func_149688_o() == Material.field_151586_h) return true; 
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  58 */     func_150170_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/*     */   }
/*     */   
/*     */   protected final boolean func_150170_e(World p_150170_1_, int p_150170_2_, int p_150170_3_, int p_150170_4_) {
/*  62 */     if (!func_149718_j(p_150170_1_, p_150170_2_, p_150170_3_, p_150170_4_)) {
/*  63 */       func_149697_b(p_150170_1_, p_150170_2_, p_150170_3_, p_150170_4_, p_150170_1_.func_72805_g(p_150170_2_, p_150170_3_, p_150170_4_), 0);
/*  64 */       p_150170_1_.func_147468_f(p_150170_2_, p_150170_3_, p_150170_4_);
/*  65 */       return false;
/*     */     } 
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  72 */     return func_149742_c(p_149718_1_, p_149718_2_, p_149718_3_, p_149718_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  82 */     return Items.field_151120_aE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 101 */     return 1;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 106 */     return Items.field_151120_aE;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/* 111 */     return p_149720_1_.func_72807_a(p_149720_2_, p_149720_4_).func_150558_b(p_149720_2_, p_149720_3_, p_149720_4_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockReed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */