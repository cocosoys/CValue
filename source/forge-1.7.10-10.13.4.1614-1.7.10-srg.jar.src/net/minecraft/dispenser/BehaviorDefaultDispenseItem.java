/*    */ package net.minecraft.dispenser;
/*    */ 
/*    */ import net.minecraft.block.BlockDispenser;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BehaviorDefaultDispenseItem implements IBehaviorDispenseItem {
/*    */   public final ItemStack func_82482_a(IBlockSource p_82482_1_, ItemStack p_82482_2_) {
/* 12 */     ItemStack itemStack = func_82487_b(p_82482_1_, p_82482_2_);
/*    */     
/* 14 */     func_82485_a(p_82482_1_);
/* 15 */     func_82489_a(p_82482_1_, BlockDispenser.func_149937_b(p_82482_1_.func_82620_h()));
/*    */     
/* 17 */     return itemStack;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001195";
/*    */   protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/* 21 */     EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/* 22 */     IPosition iPosition = BlockDispenser.func_149939_a(p_82487_1_);
/*    */     
/* 24 */     ItemStack itemStack = p_82487_2_.func_77979_a(1);
/*    */     
/* 26 */     func_82486_a(p_82487_1_.func_82618_k(), itemStack, 6, enumFacing, iPosition);
/*    */     
/* 28 */     return p_82487_2_;
/*    */   }
/*    */   
/*    */   public static void func_82486_a(World p_82486_0_, ItemStack p_82486_1_, int p_82486_2_, EnumFacing p_82486_3_, IPosition p_82486_4_) {
/* 32 */     double d1 = p_82486_4_.func_82615_a();
/* 33 */     double d2 = p_82486_4_.func_82617_b();
/* 34 */     double d3 = p_82486_4_.func_82616_c();
/*    */     
/* 36 */     EntityItem entityItem = new EntityItem(p_82486_0_, d1, d2 - 0.3D, d3, p_82486_1_);
/*    */     
/* 38 */     double d4 = p_82486_0_.field_73012_v.nextDouble() * 0.1D + 0.2D;
/* 39 */     entityItem.field_70159_w = p_82486_3_.func_82601_c() * d4;
/* 40 */     entityItem.field_70181_x = 0.20000000298023224D;
/* 41 */     entityItem.field_70179_y = p_82486_3_.func_82599_e() * d4;
/*    */     
/* 43 */     entityItem.field_70159_w += p_82486_0_.field_73012_v.nextGaussian() * 0.007499999832361937D * p_82486_2_;
/* 44 */     entityItem.field_70181_x += p_82486_0_.field_73012_v.nextGaussian() * 0.007499999832361937D * p_82486_2_;
/* 45 */     entityItem.field_70179_y += p_82486_0_.field_73012_v.nextGaussian() * 0.007499999832361937D * p_82486_2_;
/*    */     
/* 47 */     p_82486_0_.func_72838_d((Entity)entityItem);
/*    */   }
/*    */   
/*    */   protected void func_82485_a(IBlockSource p_82485_1_) {
/* 51 */     p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*    */   }
/*    */   
/*    */   protected void func_82489_a(IBlockSource p_82489_1_, EnumFacing p_82489_2_) {
/* 55 */     p_82489_1_.func_82618_k().func_72926_e(2000, p_82489_1_.func_82623_d(), p_82489_1_.func_82622_e(), p_82489_1_.func_82621_f(), func_82488_a(p_82489_2_));
/*    */   }
/*    */   
/*    */   private int func_82488_a(EnumFacing p_82488_1_) {
/* 59 */     return p_82488_1_.func_82601_c() + 1 + (p_82488_1_.func_82599_e() + 1) * 3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\dispenser\BehaviorDefaultDispenseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */