/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ public class EnchantmentOxygen
/*    */   extends Enchantment {
/*    */   public EnchantmentOxygen(int p_i1935_1_, int p_i1935_2_) {
/*  6 */     super(p_i1935_1_, p_i1935_2_, EnumEnchantmentType.armor_head);
/*  7 */     func_77322_b("oxygen");
/*    */   }
/*    */   private static final String __OBFID = "CL_00000120";
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 12 */     return 10 * p_77321_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 17 */     return func_77321_a(p_77317_1_) + 30;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 22 */     return 3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentOxygen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */