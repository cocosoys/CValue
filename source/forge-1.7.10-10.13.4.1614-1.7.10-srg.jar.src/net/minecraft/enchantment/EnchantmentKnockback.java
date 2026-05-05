/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ public class EnchantmentKnockback
/*    */   extends Enchantment {
/*    */   protected EnchantmentKnockback(int p_i1933_1_, int p_i1933_2_) {
/*  6 */     super(p_i1933_1_, p_i1933_2_, EnumEnchantmentType.weapon);
/*    */     
/*  8 */     func_77322_b("knockback");
/*    */   }
/*    */   private static final String __OBFID = "CL_00000118";
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 13 */     return 5 + 20 * (p_77321_1_ - 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 18 */     return super.func_77321_a(p_77317_1_) + 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 23 */     return 2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentKnockback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */