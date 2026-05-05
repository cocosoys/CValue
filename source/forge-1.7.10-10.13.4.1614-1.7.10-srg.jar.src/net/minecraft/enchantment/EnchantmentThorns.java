/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.DamageSource;
/*    */ 
/*    */ public class EnchantmentThorns
/*    */   extends Enchantment
/*    */ {
/*    */   private static final String __OBFID = "CL_00000122";
/*    */   
/*    */   public EnchantmentThorns(int p_i1937_1_, int p_i1937_2_) {
/* 15 */     super(p_i1937_1_, p_i1937_2_, EnumEnchantmentType.armor_torso);
/*    */     
/* 17 */     func_77322_b("thorns");
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 22 */     return 10 + 20 * (p_77321_1_ - 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 27 */     return super.func_77321_a(p_77317_1_) + 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 32 */     return 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_92089_a(ItemStack p_92089_1_) {
/* 37 */     if (p_92089_1_.func_77973_b() instanceof net.minecraft.item.ItemArmor) return true; 
/* 38 */     return super.func_92089_a(p_92089_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_151367_b(EntityLivingBase p_151367_1_, Entity p_151367_2_, int p_151367_3_) {
/* 43 */     Random random = p_151367_1_.func_70681_au();
/* 44 */     ItemStack itemStack = EnchantmentHelper.func_92099_a(Enchantment.field_92091_k, p_151367_1_);
/*    */     
/* 46 */     if (func_92094_a(p_151367_3_, random)) {
/* 47 */       p_151367_2_.func_70097_a(DamageSource.func_92087_a((Entity)p_151367_1_), func_92095_b(p_151367_3_, random));
/* 48 */       p_151367_2_.func_85030_a("damage.thorns", 0.5F, 1.0F);
/*    */       
/* 50 */       if (itemStack != null) {
/* 51 */         itemStack.func_77972_a(3, p_151367_1_);
/*    */       }
/*    */     }
/* 54 */     else if (itemStack != null) {
/* 55 */       itemStack.func_77972_a(1, p_151367_1_);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean func_92094_a(int p_92094_0_, Random p_92094_1_) {
/* 61 */     if (p_92094_0_ <= 0) return false; 
/* 62 */     return (p_92094_1_.nextFloat() < 0.15F * p_92094_0_);
/*    */   }
/*    */   
/*    */   public static int func_92095_b(int p_92095_0_, Random p_92095_1_) {
/* 66 */     if (p_92095_0_ > 10) {
/* 67 */       return p_92095_0_ - 10;
/*    */     }
/* 69 */     return 1 + p_92095_1_.nextInt(4);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentThorns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */