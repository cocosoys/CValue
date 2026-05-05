/*    */ package net.minecraft.potion;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.attributes.BaseAttributeMap;
/*    */ 
/*    */ public class PotionAbsoption extends Potion {
/*    */   protected PotionAbsoption(int p_i1569_1_, boolean p_i1569_2_, int p_i1569_3_) {
/*  8 */     super(p_i1569_1_, p_i1569_2_, p_i1569_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_111187_a(EntityLivingBase p_111187_1_, BaseAttributeMap p_111187_2_, int p_111187_3_) {
/* 13 */     p_111187_1_.func_110149_m(p_111187_1_.func_110139_bj() - (4 * (p_111187_3_ + 1)));
/* 14 */     super.func_111187_a(p_111187_1_, p_111187_2_, p_111187_3_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001524";
/*    */   
/*    */   public void func_111185_a(EntityLivingBase p_111185_1_, BaseAttributeMap p_111185_2_, int p_111185_3_) {
/* 19 */     p_111185_1_.func_110149_m(p_111185_1_.func_110139_bj() + (4 * (p_111185_3_ + 1)));
/* 20 */     super.func_111185_a(p_111185_1_, p_111185_2_, p_111185_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\potion\PotionAbsoption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */