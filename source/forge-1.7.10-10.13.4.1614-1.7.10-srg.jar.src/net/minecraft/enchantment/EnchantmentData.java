/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ import net.minecraft.util.WeightedRandom;
/*    */ 
/*    */ public class EnchantmentData
/*    */   extends WeightedRandom.Item {
/*    */   public final Enchantment field_76302_b;
/*    */   
/*    */   public EnchantmentData(Enchantment p_i1930_1_, int p_i1930_2_) {
/* 10 */     super(p_i1930_1_.func_77324_c());
/* 11 */     this.field_76302_b = p_i1930_1_;
/* 12 */     this.field_76303_c = p_i1930_2_;
/*    */   }
/*    */   public final int field_76303_c; private static final String __OBFID = "CL_00000115";
/*    */   public EnchantmentData(int p_i1931_1_, int p_i1931_2_) {
/* 16 */     this(Enchantment.field_77331_b[p_i1931_1_], p_i1931_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */