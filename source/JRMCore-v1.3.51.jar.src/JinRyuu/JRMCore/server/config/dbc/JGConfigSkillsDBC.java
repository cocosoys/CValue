/*     */ package JinRyuu.JRMCore.server.config.dbc;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ public class JGConfigSkillsDBC
/*     */   extends JGConfigBase {
/*     */   public static final int COST_MIN_TP = -1;
/*     */   public static final int COST_MIN_MIND = 0;
/*     */   public static final int COST_MAX = 2000000000;
/*     */   public static final int MIND_COST = 15;
/*     */   public static final String CATEGORY_SKILLS_SERVERSIDED = "Skills";
/*     */   public static final String CATEGORY_DBC_SKILLS_SERVERSIDED = "DBC Skills";
/*     */   public static final String CATEGORY_DBC_RACIAL_SKILLS_SERVERSIDED = "DBC Racial Skills";
/*     */   
/*     */   public static void init(Configuration config) {
/*  19 */     config.load();
/*  20 */     init_configs(config);
/*  21 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_configs(Configuration config) {
/*  27 */     String SERVERSIDE = "Server Sided! ";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  32 */     String CATEGORY = "DBC Racial Skills";
/*     */ 
/*     */ 
/*     */     
/*  36 */     int[][] defaultValuesTP = { { 3500, 7500, 15000, 30000, 60000 }, { 4000, 4500, 5000, 5500, 8000, 15000, 30000, 40000 }, { 4000, 4500, 5000, 5500, 8000, 15000, 30000, 40000 }, { 3500, 7500, 15000, 30000, 60000 }, { 3000, 7500, 11000, 22000, 33000, 44000 }, { 2000, 7000, 15000, 30000, 50000 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     int races = JRMCoreH.Races.length;
/*  57 */     for (int i = 0; i < races; i++) {
/*     */       
/*  59 */       String race = JRMCoreH.Races[i];
/*     */       
/*  61 */       int[] defaultValuesI = defaultValuesTP[i];
/*  62 */       String title = race + " Racial Skill TP Costs";
/*  63 */       String description = "Server Sided! " + race + " transformation skill leveling TP Cost. (From " + -1 + " to " + 2000000000 + ")";
/*  64 */       Property property = config.get(CATEGORY, title, defaultValuesI, description, -1, 2000000000);
/*  65 */       JRMCoreH.DBCRacialSkillTPCost[i] = property.getIntList();
/*  66 */       JRMCoreH.cDBCRacialSkillTPCost[i] = property.getIntList();
/*     */       
/*  68 */       defaultValuesI = new int[] { 15 };
/*  69 */       title = race + " Racial Skill Mind Requirement";
/*  70 */       description = "Server Sided! " + race + " transformation skill leveling MIND Requirement. (From " + Character.MIN_VALUE + " to " + 2000000000 + ")";
/*  71 */       property = config.get(CATEGORY, title, defaultValuesI, description, 0, 2000000000);
/*  72 */       JRMCoreH.DBCRacialSkillMindCost[i] = property.getIntList();
/*  73 */       JRMCoreH.cDBCRacialSkillMindCost[i] = property.getIntList();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     CATEGORY = "DBC Skills";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     int[][] skillDefaultTPCost = { { 300 }, { 40 }, { 50 }, { 60 }, { 150 }, { 400 }, { 300 }, { 250 }, { 400 }, { 20000 }, { 1500 }, { 700 }, { 1000 }, { 800 }, { 600 }, { 200 }, { 50000, 25000, 25000 }, { 5000 }, { 50000 } };
/*  86 */     int[][] skillDefaultMindCost = { { 10, 5 }, { 5, 2 }, { 5, 2 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 10, 5 }, { 5, 5 }, { 10, 5, 5 }, { 10, 5 }, { 10 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     int skills = JRMCoreH.DBCSkillNames.length;
/*  94 */     for (int j = 0; j < skills; j++) {
/*     */       
/*  96 */       String skill = JRMCoreH.DBCSkillNames[j];
/*     */       
/*  98 */       if (JRMCoreH.DBCSkillNames[j].equals(JRMCoreH.DBCSkillNames[16])) {
/*     */         
/* 100 */         if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0)
/*     */         {
/*     */           
/* 103 */           JRMCoreH.DBCSkillTPCost[j] = JGConfigUltraInstinct.CONFIG_UI_TP_COST;
/* 104 */           JRMCoreH.cDBCSkillTPCost[j] = JGConfigUltraInstinct.cCONFIG_UI_TP_COST;
/*     */ 
/*     */           
/* 107 */           JRMCoreH.DBCSkillMindCost[j] = JGConfigUltraInstinct.CONFIG_UI_MIND_REQUIREMENT;
/* 108 */           JRMCoreH.cDBCSkillMindCost[j] = JGConfigUltraInstinct.cCONFIG_UI_MIND_REQUIREMENT;
/*     */         
/*     */         }
/*     */         else
/*     */         {
/* 113 */           int[] d = { 1 };
/* 114 */           JRMCoreH.DBCSkillTPCost[j] = d;
/* 115 */           JRMCoreH.cDBCSkillTPCost[j] = d;
/*     */ 
/*     */           
/* 118 */           JRMCoreH.DBCSkillMindCost[j] = d;
/* 119 */           JRMCoreH.cDBCSkillMindCost[j] = d;
/*     */         }
/*     */       
/* 122 */       } else if (JRMCoreH.DBCSkillNames[j].equals(JRMCoreH.DBCSkillNames[18])) {
/*     */ 
/*     */         
/* 125 */         (new int[1])[0] = JGConfigDBCGoD.CONFIG_GOD_TP_COST; JRMCoreH.DBCSkillTPCost[j] = new int[1];
/* 126 */         (new int[1])[0] = JGConfigDBCGoD.cCONFIG_GOD_TP_COST; JRMCoreH.cDBCSkillTPCost[j] = new int[1];
/*     */ 
/*     */         
/* 129 */         (new int[1])[0] = JGConfigDBCGoD.CONFIG_GOD_MIND_REQUIREMENT; JRMCoreH.DBCSkillMindCost[j] = new int[1];
/* 130 */         (new int[1])[0] = JGConfigDBCGoD.cCONFIG_GOD_MIND_REQUIREMENT; JRMCoreH.cDBCSkillMindCost[j] = new int[1];
/*     */       }
/*     */       else {
/*     */         
/* 134 */         int[] defaultValuesI = skillDefaultTPCost[j];
/* 135 */         String title = skill + " Skill TP Costs";
/* 136 */         String description = "Server Sided! " + skill + " skill leveling TP Cost. (From " + -1 + " to " + 2000000000 + ")";
/* 137 */         Property property = config.get(CATEGORY, title, defaultValuesI, description, -1, 2000000000);
/* 138 */         JRMCoreH.DBCSkillTPCost[j] = property.getIntList();
/* 139 */         JRMCoreH.cDBCSkillTPCost[j] = property.getIntList();
/*     */         
/* 141 */         defaultValuesI = skillDefaultMindCost[j];
/* 142 */         title = skill + " Skill Mind Requirement";
/* 143 */         description = "Server Sided! " + skill + " skill leveling MIND Requirement. (From " + Character.MIN_VALUE + " to " + 2000000000 + ")";
/* 144 */         property = config.get(CATEGORY, title, defaultValuesI, description, 0, 2000000000);
/* 145 */         JRMCoreH.DBCSkillMindCost[j] = property.getIntList();
/* 146 */         JRMCoreH.cDBCSkillMindCost[j] = property.getIntList();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\dbc\JGConfigSkillsDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */