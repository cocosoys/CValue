/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class EnchantmentDigging
/*    */   extends Enchantment {
/*    */   protected EnchantmentDigging(int p_i1925_1_, int p_i1925_2_) {
/*  9 */     super(p_i1925_1_, p_i1925_2_, EnumEnchantmentType.digger);
/*    */     
/* 11 */     func_77322_b("digging");
/*    */   }
/*    */   private static final String __OBFID = "CL_00000104";
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 16 */     return 1 + 10 * (p_77321_1_ - 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 21 */     return super.func_77321_a(p_77317_1_) + 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 26 */     return 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_92089_a(ItemStack p_92089_1_) {
/* 31 */     if (p_92089_1_.func_77973_b() == Items.field_151097_aZ) return true; 
/* 32 */     return super.func_92089_a(p_92089_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentDigging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */