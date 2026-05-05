/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ public class EnchantmentFishingSpeed
/*    */   extends Enchantment {
/*    */   protected EnchantmentFishingSpeed(int p_i45361_1_, int p_i45361_2_, EnumEnchantmentType p_i45361_3_) {
/*  6 */     super(p_i45361_1_, p_i45361_2_, p_i45361_3_);
/*    */     
/*  8 */     func_77322_b("fishingSpeed");
/*    */   }
/*    */   private static final String __OBFID = "CL_00000117";
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 13 */     return 15 + (p_77321_1_ - 1) * 9;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 18 */     return super.func_77321_a(p_77317_1_) + 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 23 */     return 3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentFishingSpeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */