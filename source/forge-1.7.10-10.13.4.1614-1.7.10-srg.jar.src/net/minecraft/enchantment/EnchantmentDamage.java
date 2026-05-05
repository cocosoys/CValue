/*    */ package net.minecraft.enchantment;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.EnumCreatureAttribute;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ 
/*    */ 
/*    */ public class EnchantmentDamage
/*    */   extends Enchantment
/*    */ {
/* 14 */   private static final String[] field_77359_A = new String[] { "all", "undead", "arthropods" };
/*    */ 
/*    */ 
/*    */   
/* 18 */   private static final int[] field_77360_B = new int[] { 1, 5, 5 };
/*    */ 
/*    */ 
/*    */   
/* 22 */   private static final int[] field_77362_C = new int[] { 11, 8, 8 };
/*    */ 
/*    */ 
/*    */   
/* 26 */   private static final int[] field_77358_D = new int[] { 20, 20, 20 };
/*    */   
/*    */   public final int field_77361_a;
/*    */   
/*    */   private static final String __OBFID = "CL_00000102";
/*    */   
/*    */   public EnchantmentDamage(int p_i1923_1_, int p_i1923_2_, int p_i1923_3_) {
/* 33 */     super(p_i1923_1_, p_i1923_2_, EnumEnchantmentType.weapon);
/* 34 */     this.field_77361_a = p_i1923_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77321_a(int p_77321_1_) {
/* 39 */     return field_77360_B[this.field_77361_a] + (p_77321_1_ - 1) * field_77362_C[this.field_77361_a];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77317_b(int p_77317_1_) {
/* 44 */     return func_77321_a(p_77317_1_) + field_77358_D[this.field_77361_a];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77325_b() {
/* 49 */     return 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_152376_a(int p_152376_1_, EnumCreatureAttribute p_152376_2_) {
/* 54 */     if (this.field_77361_a == 0) {
/* 55 */       return p_152376_1_ * 1.25F;
/*    */     }
/* 57 */     if (this.field_77361_a == 1 && p_152376_2_ == EnumCreatureAttribute.UNDEAD) {
/* 58 */       return p_152376_1_ * 2.5F;
/*    */     }
/* 60 */     if (this.field_77361_a == 2 && p_152376_2_ == EnumCreatureAttribute.ARTHROPOD) {
/* 61 */       return p_152376_1_ * 2.5F;
/*    */     }
/* 63 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77320_a() {
/* 68 */     return "enchantment.damage." + field_77359_A[this.field_77361_a];
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77326_a(Enchantment p_77326_1_) {
/* 73 */     return !(p_77326_1_ instanceof EnchantmentDamage);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_92089_a(ItemStack p_92089_1_) {
/* 78 */     if (p_92089_1_.func_77973_b() instanceof net.minecraft.item.ItemAxe) return true; 
/* 79 */     return super.func_92089_a(p_92089_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_151368_a(EntityLivingBase p_151368_1_, Entity p_151368_2_, int p_151368_3_) {
/* 84 */     if (p_151368_2_ instanceof EntityLivingBase) {
/* 85 */       EntityLivingBase entityLivingBase = (EntityLivingBase)p_151368_2_;
/*    */       
/* 87 */       if (this.field_77361_a == 2 && entityLivingBase.func_70668_bt() == EnumCreatureAttribute.ARTHROPOD) {
/* 88 */         int i = 20 + p_151368_1_.func_70681_au().nextInt(10 * p_151368_3_);
/* 89 */         entityLivingBase.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, i, 3));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */