/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemBucketMilk
/*    */   extends Item {
/*    */   public ItemBucketMilk() {
/* 11 */     func_77625_d(1);
/* 12 */     func_77637_a(CreativeTabs.field_78026_f);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000048";
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
/* 17 */     if (!p_77654_3_.field_71075_bZ.field_75098_d) p_77654_1_.field_77994_a--;
/*    */     
/* 19 */     if (!p_77654_2_.field_72995_K) {
/* 20 */       p_77654_3_.func_70674_bp();
/*    */     }
/*    */     
/* 23 */     if (p_77654_1_.field_77994_a <= 0) {
/* 24 */       return new ItemStack(Items.field_151133_ar);
/*    */     }
/* 26 */     return p_77654_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77626_a(ItemStack p_77626_1_) {
/* 31 */     return 32;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack p_77661_1_) {
/* 36 */     return EnumAction.drink;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 41 */     p_77659_3_.func_71008_a(p_77659_1_, func_77626_a(p_77659_1_));
/* 42 */     return p_77659_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemBucketMilk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */