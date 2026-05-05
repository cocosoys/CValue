/*    */ package net.minecraft.dispenser;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IBehaviorDispenseItem
/*    */ {
/*  9 */   public static final IBehaviorDispenseItem field_82483_a = new IBehaviorDispenseItem()
/*    */     {
/*    */       public ItemStack func_82482_a(IBlockSource p_82482_1_, ItemStack p_82482_2_) {
/* 12 */         return p_82482_2_;
/*    */       }
/*    */       
/*    */       private static final String __OBFID = "CL_00001200";
/*    */     };
/*    */   
/*    */   ItemStack func_82482_a(IBlockSource paramIBlockSource, ItemStack paramItemStack);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\dispenser\IBehaviorDispenseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */