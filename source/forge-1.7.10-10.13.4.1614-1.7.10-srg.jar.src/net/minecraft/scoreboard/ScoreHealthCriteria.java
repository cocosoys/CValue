/*    */ package net.minecraft.scoreboard;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class ScoreHealthCriteria
/*    */   extends ScoreDummyCriteria {
/*    */   public ScoreHealthCriteria(String p_i2312_1_) {
/* 10 */     super(p_i2312_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000623";
/*    */   
/*    */   public int func_96635_a(List p_96635_1_) {
/* 15 */     float f = 0.0F;
/*    */     
/* 17 */     for (EntityPlayer entityPlayer : p_96635_1_) {
/* 18 */       f += entityPlayer.func_110143_aJ() + entityPlayer.func_110139_bj();
/*    */     }
/*    */     
/* 21 */     if (p_96635_1_.size() > 0) f /= p_96635_1_.size();
/*    */     
/* 23 */     return MathHelper.func_76123_f(f);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_96637_b() {
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\ScoreHealthCriteria.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */