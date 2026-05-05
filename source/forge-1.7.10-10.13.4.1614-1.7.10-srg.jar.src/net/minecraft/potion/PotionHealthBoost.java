/*    */ package net.minecraft.potion;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.attributes.BaseAttributeMap;
/*    */ 
/*    */ public class PotionHealthBoost extends Potion {
/*    */   public PotionHealthBoost(int p_i1571_1_, boolean p_i1571_2_, int p_i1571_3_) {
/*  8 */     super(p_i1571_1_, p_i1571_2_, p_i1571_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_111187_a(EntityLivingBase p_111187_1_, BaseAttributeMap p_111187_2_, int p_111187_3_) {
/* 13 */     super.func_111187_a(p_111187_1_, p_111187_2_, p_111187_3_);
/* 14 */     if (p_111187_1_.func_110143_aJ() > p_111187_1_.func_110138_aP())
/* 15 */       p_111187_1_.func_70606_j(p_111187_1_.func_110138_aP()); 
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001526";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\potion\PotionHealthBoost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */