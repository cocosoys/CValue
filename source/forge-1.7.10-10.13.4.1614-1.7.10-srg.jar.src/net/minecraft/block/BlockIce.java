/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockIce extends BlockBreakable {
/*    */   public BlockIce() {
/* 15 */     super("ice", Material.field_151588_w, false);
/* 16 */     this.field_149765_K = 0.98F;
/* 17 */     func_149675_a(true);
/* 18 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000259";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149701_w() {
/* 23 */     return 1;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 28 */     return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, 1 - p_149646_5_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
/* 33 */     p_149636_2_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
/* 34 */     p_149636_2_.func_71020_j(0.025F);
/*    */     
/* 36 */     if (func_149700_E() && EnchantmentHelper.func_77502_d((EntityLivingBase)p_149636_2_)) {
/* 37 */       ItemStack itemStack = func_149644_j(p_149636_6_);
/* 38 */       if (itemStack != null) {
/* 39 */         func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, itemStack);
/*    */       }
/*    */     } else {
/* 42 */       if (p_149636_1_.field_73011_w.field_76575_d) {
/* 43 */         p_149636_1_.func_147468_f(p_149636_3_, p_149636_4_, p_149636_5_);
/*    */         
/*    */         return;
/*    */       } 
/* 47 */       int i = EnchantmentHelper.func_77517_e((EntityLivingBase)p_149636_2_);
/* 48 */       func_149697_b(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_, i);
/*    */       
/* 50 */       Material material = p_149636_1_.func_147439_a(p_149636_3_, p_149636_4_ - 1, p_149636_5_).func_149688_o();
/* 51 */       if (material.func_76230_c() || material.func_76224_d()) {
/* 52 */         p_149636_1_.func_147449_b(p_149636_3_, p_149636_4_, p_149636_5_, Blocks.field_150358_i);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 59 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 64 */     if (p_149674_1_.func_72972_b(EnumSkyBlock.Block, p_149674_2_, p_149674_3_, p_149674_4_) > 11 - func_149717_k()) {
/* 65 */       if (p_149674_1_.field_73011_w.field_76575_d) {
/* 66 */         p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
/*    */         
/*    */         return;
/*    */       } 
/* 70 */       func_149697_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 0);
/* 71 */       p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150355_j);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149656_h() {
/* 77 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockIce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */