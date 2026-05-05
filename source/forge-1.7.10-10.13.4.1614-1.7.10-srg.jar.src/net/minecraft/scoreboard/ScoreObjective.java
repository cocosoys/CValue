/*    */ package net.minecraft.scoreboard;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class ScoreObjective
/*    */ {
/*    */   private final Scoreboard field_96686_a;
/*    */   private final String field_96684_b;
/*    */   private final IScoreObjectiveCriteria field_96685_c;
/*    */   private String field_96683_d;
/*    */   private static final String __OBFID = "CL_00000614";
/*    */   
/*    */   public ScoreObjective(Scoreboard p_i2307_1_, String p_i2307_2_, IScoreObjectiveCriteria p_i2307_3_) {
/* 15 */     this.field_96686_a = p_i2307_1_;
/* 16 */     this.field_96684_b = p_i2307_2_;
/* 17 */     this.field_96685_c = p_i2307_3_;
/*    */     
/* 19 */     this.field_96683_d = p_i2307_2_;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Scoreboard func_96682_a() {
/* 23 */     return this.field_96686_a;
/*    */   }
/*    */   
/*    */   public String func_96679_b() {
/* 27 */     return this.field_96684_b;
/*    */   }
/*    */   
/*    */   public IScoreObjectiveCriteria func_96680_c() {
/* 31 */     return this.field_96685_c;
/*    */   }
/*    */   
/*    */   public String func_96678_d() {
/* 35 */     return this.field_96683_d;
/*    */   }
/*    */   
/*    */   public void func_96681_a(String p_96681_1_) {
/* 39 */     this.field_96683_d = p_96681_1_;
/* 40 */     this.field_96686_a.func_96532_b(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\ScoreObjective.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */