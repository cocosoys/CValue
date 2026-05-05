/*    */ package net.minecraft.block;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockBush extends Block {
/*    */   protected BlockBush(Material p_i45395_1_) {
/* 12 */     super(p_i45395_1_);
/* 13 */     func_149675_a(true);
/* 14 */     float f = 0.2F;
/* 15 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
/* 16 */     func_149647_a(CreativeTabs.field_78031_c);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000208";
/*    */   protected BlockBush() {
/* 20 */     this(Material.field_151585_k);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 25 */     return (super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && func_149854_a(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_)));
/*    */   }
/*    */   
/*    */   protected boolean func_149854_a(Block p_149854_1_) {
/* 29 */     return (p_149854_1_ == Blocks.field_150349_c || p_149854_1_ == Blocks.field_150346_d || p_149854_1_ == Blocks.field_150458_ak);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 34 */     super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
/* 35 */     func_149855_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 40 */     func_149855_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*    */   }
/*    */   
/*    */   protected void func_149855_e(World p_149855_1_, int p_149855_2_, int p_149855_3_, int p_149855_4_) {
/* 44 */     if (!func_149718_j(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_)) {
/* 45 */       func_149697_b(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_, p_149855_1_.func_72805_g(p_149855_2_, p_149855_3_, p_149855_4_), 0);
/* 46 */       p_149855_1_.func_147465_d(p_149855_2_, p_149855_3_, p_149855_4_, func_149729_e(0), 0, 2);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/* 52 */     return func_149854_a(p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_));
/*    */   }
/*    */ 
/*    */   
/*    */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 66 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149686_d() {
/* 71 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149645_b() {
/* 76 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockBush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */