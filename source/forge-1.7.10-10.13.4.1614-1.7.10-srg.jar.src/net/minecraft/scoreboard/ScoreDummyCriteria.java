/*    */ package net.minecraft.scoreboard;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class ScoreDummyCriteria
/*    */   implements IScoreObjectiveCriteria {
/*    */   private final String field_96644_g;
/*    */   private static final String __OBFID = "CL_00000622";
/*    */   
/*    */   public ScoreDummyCriteria(String p_i2311_1_) {
/* 11 */     this.field_96644_g = p_i2311_1_;
/* 12 */     IScoreObjectiveCriteria.field_96643_a.put(p_i2311_1_, this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_96636_a() {
/* 17 */     return this.field_96644_g;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_96635_a(List p_96635_1_) {
/* 22 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_96637_b() {
/* 27 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\ScoreDummyCriteria.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */