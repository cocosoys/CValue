/*    */ package net.minecraft.dispenser;
/*    */ 
/*    */ import net.minecraft.block.BlockDispenser;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.IProjectile;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public abstract class BehaviorProjectileDispense
/*    */   extends BehaviorDefaultDispenseItem
/*    */ {
/*    */   private static final String __OBFID = "CL_00001394";
/*    */   
/*    */   public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/* 17 */     World world = p_82487_1_.func_82618_k();
/* 18 */     IPosition iPosition = BlockDispenser.func_149939_a(p_82487_1_);
/* 19 */     EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/*    */     
/* 21 */     IProjectile iProjectile = func_82499_a(world, iPosition);
/* 22 */     iProjectile.func_70186_c(enumFacing.func_82601_c(), (enumFacing.func_96559_d() + 0.1F), enumFacing.func_82599_e(), func_82500_b(), func_82498_a());
/* 23 */     world.func_72838_d((Entity)iProjectile);
/*    */     
/* 25 */     p_82487_2_.func_77979_a(1);
/*    */     
/* 27 */     return p_82487_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_82485_a(IBlockSource p_82485_1_) {
/* 32 */     p_82485_1_.func_82618_k().func_72926_e(1002, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*    */   }
/*    */   
/*    */   protected abstract IProjectile func_82499_a(World paramWorld, IPosition paramIPosition);
/*    */   
/*    */   protected float func_82498_a() {
/* 38 */     return 6.0F;
/*    */   }
/*    */   
/*    */   protected float func_82500_b() {
/* 42 */     return 1.1F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\dispenser\BehaviorProjectileDispense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */