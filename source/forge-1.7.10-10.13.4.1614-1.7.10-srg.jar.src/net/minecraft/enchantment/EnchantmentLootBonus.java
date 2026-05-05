/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ public class EnchantmentLootBonus
/*    */   extends Enchantment {
/*    */   protected EnchantmentLootBonus(int p_i1934_1_, int p_i1934_2_, EnumEnchantmentType p_i1934_3_) {
/*  6 */     super(p_i1934_1_, p_i1934_2_, p_i1934_3_);
/*    */     
/*  8 */     if (p_i1934_3_ == EnumEnchantmentType.digger) {
/*  9 */       func_77322_b("lootBonusDigger");
/* 10 */     } else if (p_i1934_3_ == EnumEnchantmentType.fishing_rod) {
/* 11 */       func_77322_b("lootBonusFishing");
/*    */     } else {
/* 13 */       func_77322_b("lootBonus");
/*    */     } 
/*    */   }
/*    */   private static final String __OBFID = "CL_00000119";
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 19 */     return 15 + (p_77321_1_ - 1) * 9;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 24 */     return super.func_77321_a(p_77317_1_) + 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 29 */     return 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77326_a(Enchantment p_77326_1_) {
/* 34 */     return (super.func_77326_a(p_77326_1_) && p_77326_1_.field_77352_x != field_77348_q.field_77352_x);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentLootBonus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */