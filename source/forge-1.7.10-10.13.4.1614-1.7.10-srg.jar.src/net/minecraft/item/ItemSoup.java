/*    */ package net.minecraft.item;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemSoup extends ItemFood {
/*    */   public ItemSoup(int p_i45330_1_) {
/*  8 */     super(p_i45330_1_, false);
/*    */     
/* 10 */     func_77625_d(1);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001778";
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
/* 15 */     super.func_77654_b(p_77654_1_, p_77654_2_, p_77654_3_);
/*    */     
/* 17 */     return new ItemStack(Items.field_151054_z);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSoup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */