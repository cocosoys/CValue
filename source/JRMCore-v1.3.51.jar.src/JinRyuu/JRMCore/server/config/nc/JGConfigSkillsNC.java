/*    */ package JinRyuu.JRMCore.server.config.nc;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ import net.minecraftforge.common.config.Property;
/*    */ 
/*    */ public class JGConfigSkillsNC
/*    */   extends JGConfigBase {
/*    */   public static final int COST_MIN_TP = -1;
/*    */   public static final int COST_MIN_MIND = 0;
/*    */   public static final int COST_MAX = 2000000000;
/*    */   public static final String CATEGORY_SKILLS_SERVERSIDED = "Skills";
/*    */   public static final String CATEGORY_NC_CLAN_SKILLS_SERVERSIDED = "NC Clan Skills";
/*    */   public static final String CATEGORY_NC_SKILLS_SERVERSIDED = "NC Skills";
/*    */   
/*    */   public static void init(Configuration config) {
/* 18 */     config.load();
/* 19 */     init_configs(config);
/* 20 */     config.save();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static void init_configs(Configuration config) {
/* 26 */     String SERVERSIDE = "Server Sided! ";
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 31 */     String CATEGORY = "NC Clan Skills";
/*    */ 
/*    */ 
/*    */     
/* 35 */     int[][] defaultValuesTP = { { 250 }, { 250 }, { 250 } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 41 */     int clans = JRMCoreH.Clans.length;
/* 42 */     for (int i = 0; i < clans; i++) {
/*    */       
/* 44 */       String clan = JRMCoreH.Clans[i];
/*    */       
/* 46 */       int[] defaultValuesI = defaultValuesTP[i];
/* 47 */       String title = clan + " Clan Skill TP Costs";
/* 48 */       String description = "Server Sided! " + clan + " unique skill leveling TP Cost. (From " + -1 + " to " + 2000000000 + ")";
/* 49 */       Property property = config.get(CATEGORY, title, defaultValuesI, description, -1, 2000000000);
/* 50 */       JRMCoreH.NCRacialSkillTPCost[i] = property.getIntList();
/* 51 */       JRMCoreH.cNCRacialSkillTPCost[i] = property.getIntList();
/*    */       
/* 53 */       defaultValuesI = new int[] { 15 };
/* 54 */       title = clan + " Clan Skill Mind Requirement";
/* 55 */       description = "Server Sided! " + clan + " unique skill leveling MIND Requirement. (From " + Character.MIN_VALUE + " to " + 2000000000 + ")";
/* 56 */       property = config.get(CATEGORY, title, defaultValuesI, description, 0, 2000000000);
/* 57 */       JRMCoreH.NCRacialSkillMindCost[i] = property.getIntList();
/* 58 */       JRMCoreH.cNCRacialSkillMindCost[i] = property.getIntList();
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 64 */     CATEGORY = "NC Skills";
/*    */     
/* 66 */     int[][] skillDefaultTPCost = { { 70 }, { 90 }, { 80 }, { 100 }, { 150 }, { 150 }, { 150 }, { 150 }, { 150 }, { 200 }, { 130 }, { 250 }, { 1000 } };
/*    */     
/* 68 */     int[][] skillDefaultMindCost = { { 15 }, { 15 }, { 15 }, { 15 }, { 15 }, { 15 }, { 15 }, { 15 }, { 15 }, { 15 }, { 15 }, { 15 }, { 15 } };
/*    */ 
/*    */ 
/*    */     
/* 72 */     int skills = JRMCoreH.NCSkillNames.length;
/* 73 */     for (int j = 0; j < skills; j++) {
/*    */       
/* 75 */       String skill = JRMCoreH.NCSkillNames[j];
/*    */       
/* 77 */       int[] defaultValuesI = skillDefaultTPCost[j];
/* 78 */       String title = skill + " Skill TP Costs";
/* 79 */       String description = "Server Sided! " + skill + " skill leveling TP Cost. (From " + -1 + " to " + 2000000000 + ")";
/* 80 */       Property property = config.get(CATEGORY, title, defaultValuesI, description, -1, 2000000000);
/* 81 */       JRMCoreH.NCSkillTPCost[j] = property.getIntList();
/* 82 */       JRMCoreH.cNCSkillTPCost[j] = property.getIntList();
/*    */       
/* 84 */       defaultValuesI = skillDefaultMindCost[j];
/* 85 */       title = skill + " Skill Mind Requirement";
/* 86 */       description = "Server Sided! " + skill + " skill leveling MIND Requirement. (From " + Character.MIN_VALUE + " to " + 2000000000 + ")";
/* 87 */       property = config.get(CATEGORY, title, defaultValuesI, description, 0, 2000000000);
/* 88 */       JRMCoreH.NCSkillMindCost[j] = property.getIntList();
/* 89 */       JRMCoreH.cNCSkillMindCost[j] = property.getIntList();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\nc\JGConfigSkillsNC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */