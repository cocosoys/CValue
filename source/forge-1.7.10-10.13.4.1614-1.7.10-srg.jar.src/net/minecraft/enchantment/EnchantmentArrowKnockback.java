/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ public class EnchantmentArrowKnockback
/*    */   extends Enchantment {
/*    */   public EnchantmentArrowKnockback(int p_i1922_1_, int p_i1922_2_) {
/*  6 */     super(p_i1922_1_, p_i1922_2_, EnumEnchantmentType.bow);
/*  7 */     func_77322_b("arrowKnockback");
/*    */   }
/*    */   private static final String __OBFID = "CL_00000101";
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 12 */     return 12 + (p_77321_1_ - 1) * 20;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 17 */     return func_77321_a(p_77317_1_) + 25;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 22 */     return 2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentArrowKnockback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */