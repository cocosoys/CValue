/*    */ package net.minecraft.potion;
/*    */ 
/*    */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*    */ 
/*    */ public class PotionAttackDamage extends Potion {
/*    */   protected PotionAttackDamage(int p_i1570_1_, boolean p_i1570_2_, int p_i1570_3_) {
/*  7 */     super(p_i1570_1_, p_i1570_2_, p_i1570_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_111183_a(int p_111183_1_, AttributeModifier p_111183_2_) {
/* 12 */     if (this.field_76415_H == Potion.field_76437_t.field_76415_H) {
/* 13 */       return (-0.5F * (p_111183_1_ + 1));
/*    */     }
/* 15 */     return 1.3D * (p_111183_1_ + 1);
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001525";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\potion\PotionAttackDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */