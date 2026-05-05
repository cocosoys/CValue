/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class EnchantmentUntouching
/*    */   extends Enchantment {
/*    */   protected EnchantmentUntouching(int p_i1938_1_, int p_i1938_2_) {
/*  9 */     super(p_i1938_1_, p_i1938_2_, EnumEnchantmentType.digger);
/*    */     
/* 11 */     func_77322_b("untouching");
/*    */   }
/*    */   private static final String __OBFID = "CL_00000123";
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 16 */     return 15;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 21 */     return super.func_77321_a(p_77317_1_) + 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 26 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77326_a(Enchantment p_77326_1_) {
/* 31 */     return (super.func_77326_a(p_77326_1_) && p_77326_1_.field_77352_x != field_77346_s.field_77352_x);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_92089_a(ItemStack p_92089_1_) {
/* 36 */     if (p_92089_1_.func_77973_b() == Items.field_151097_aZ) return true; 
/* 37 */     return super.func_92089_a(p_92089_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentUntouching.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */