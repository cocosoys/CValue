/*    */ package net.minecraft.scoreboard;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public interface IScoreObjectiveCriteria
/*    */ {
/* 10 */   public static final Map field_96643_a = new HashMap<Object, Object>();
/*    */   
/* 12 */   public static final IScoreObjectiveCriteria field_96641_b = new ScoreDummyCriteria("dummy");
/* 13 */   public static final IScoreObjectiveCriteria field_96642_c = new ScoreDummyCriteria("deathCount");
/* 14 */   public static final IScoreObjectiveCriteria field_96639_d = new ScoreDummyCriteria("playerKillCount");
/* 15 */   public static final IScoreObjectiveCriteria field_96640_e = new ScoreDummyCriteria("totalKillCount");
/* 16 */   public static final IScoreObjectiveCriteria field_96638_f = new ScoreHealthCriteria("health");
/*    */   
/*    */   String func_96636_a();
/*    */   
/*    */   int func_96635_a(List paramList);
/*    */   
/*    */   boolean func_96637_b();
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\IScoreObjectiveCriteria.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */