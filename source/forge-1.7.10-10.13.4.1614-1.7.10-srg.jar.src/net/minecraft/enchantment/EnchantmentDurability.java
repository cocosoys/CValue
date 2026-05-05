/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class EnchantmentDurability
/*    */   extends Enchantment {
/*    */   private static final String __OBFID = "CL_00000103";
/*    */   
/*    */   protected EnchantmentDurability(int p_i1924_1_, int p_i1924_2_) {
/* 11 */     super(p_i1924_1_, p_i1924_2_, EnumEnchantmentType.breakable);
/*    */     
/* 13 */     func_77322_b("durability");
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 18 */     return 5 + (p_77321_1_ - 1) * 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 23 */     return super.func_77321_a(p_77317_1_) + 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 28 */     return 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_92089_a(ItemStack p_92089_1_) {
/* 33 */     if (p_92089_1_.func_77984_f()) return true; 
/* 34 */     return super.func_92089_a(p_92089_1_);
/*    */   }
/*    */   
/*    */   public static boolean func_92097_a(ItemStack p_92097_0_, int p_92097_1_, Random p_92097_2_) {
/* 38 */     if (p_92097_0_.func_77973_b() instanceof net.minecraft.item.ItemArmor && p_92097_2_.nextFloat() < 0.6F) return false; 
/* 39 */     return (p_92097_2_.nextInt(p_92097_1_ + 1) > 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentDurability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */