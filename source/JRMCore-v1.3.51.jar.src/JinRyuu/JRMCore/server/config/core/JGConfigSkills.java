/*    */ package JinRyuu.JRMCore.server.config.core;
/*    */ 
/*    */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ import net.minecraftforge.common.config.Property;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JGConfigSkills
/*    */   extends JGConfigBase
/*    */ {
/*    */   public static final String CATEGORY_SKILLS_SERVERSIDED = "Skills";
/*    */   public static float GlobalSkillTPMultiplier;
/*    */   public static float cGlobalSkillTPMultiplier;
/*    */   public static float GlobalSkillMindMultiplier;
/*    */   public static float cGlobalSkillMindMultiplier;
/*    */   public static float GlobalSkillTPMultiplierFirst;
/*    */   
/*    */   public static void init(Configuration config) {
/* 21 */     config.load();
/* 22 */     init_configs(config);
/* 23 */     config.save();
/*    */   }
/*    */   public static float cGlobalSkillTPMultiplierFirst; public static float GlobalSkillMindMultiplierFirst; public static float cGlobalSkillMindMultiplierFirst; public static boolean GlobalSkillTPMultiplierWithLevel; public static boolean cGlobalSkillTPMultiplierWithLevel; public static boolean GlobalSkillMindMultiplierWithLevel;
/*    */   public static boolean cGlobalSkillMindMultiplierWithLevel;
/*    */   
/*    */   private static void init_configs(Configuration config) {
/* 29 */     String CATEGORY = "Skills";
/* 30 */     String server = "Server Sided!";
/*    */ 
/*    */ 
/*    */     
/* 34 */     int min = 0, max = 1000000;
/* 35 */     String title = "Global Skill TP Cost Multiplier";
/* 36 */     String description = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 37 */     Property property = config.get(CATEGORY, title, 1.0D);
/* 38 */     property.comment = description;
/* 39 */     cGlobalSkillTPMultiplier = (float)property.getDouble();
/* 40 */     if (cGlobalSkillTPMultiplier < min) { cGlobalSkillTPMultiplier = min; } else if (cGlobalSkillTPMultiplier > max) { cGlobalSkillTPMultiplier = max; }
/* 41 */      GlobalSkillTPMultiplier = cGlobalSkillTPMultiplier;
/*    */     
/* 43 */     title = "Global Skill Mind Requirement Multiplier";
/* 44 */     description = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 45 */     property = config.get(CATEGORY, title, 1.0D);
/* 46 */     property.comment = description;
/* 47 */     cGlobalSkillMindMultiplier = (float)property.getDouble();
/* 48 */     if (cGlobalSkillMindMultiplier < min) { cGlobalSkillMindMultiplier = min; } else if (cGlobalSkillMindMultiplier > max) { cGlobalSkillMindMultiplier = max; }
/* 49 */      GlobalSkillMindMultiplier = cGlobalSkillMindMultiplier;
/*    */     
/* 51 */     title = "Global Skill TP Cost Multiplier for Level 1";
/* 52 */     description = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 53 */     property = config.get(CATEGORY, title, 1.0D);
/* 54 */     property.comment = description;
/* 55 */     cGlobalSkillTPMultiplierFirst = (float)property.getDouble();
/* 56 */     if (cGlobalSkillTPMultiplierFirst < min) { cGlobalSkillTPMultiplierFirst = min; } else if (cGlobalSkillTPMultiplierFirst > max) { cGlobalSkillTPMultiplierFirst = max; }
/* 57 */      GlobalSkillTPMultiplierFirst = cGlobalSkillTPMultiplierFirst;
/*    */     
/* 59 */     title = "Global Skill Mind Requirement Multiplier for Level 1";
/* 60 */     description = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 61 */     property = config.get(CATEGORY, title, 1.0D);
/* 62 */     property.comment = description;
/* 63 */     cGlobalSkillMindMultiplierFirst = (float)property.getDouble();
/* 64 */     if (cGlobalSkillMindMultiplierFirst < min) { cGlobalSkillMindMultiplierFirst = min; } else if (cGlobalSkillMindMultiplierFirst > max) { cGlobalSkillMindMultiplierFirst = max; }
/* 65 */      GlobalSkillMindMultiplierFirst = cGlobalSkillMindMultiplierFirst;
/*    */ 
/*    */     
/* 68 */     title = "Global Skills TP Cost Multiplied with each Level On";
/* 69 */     description = "Server Sided! " + title + ". (Default: false).";
/* 70 */     property = config.get(CATEGORY, title, false);
/* 71 */     property.comment = description;
/* 72 */     cGlobalSkillTPMultiplierWithLevel = property.getBoolean();
/* 73 */     GlobalSkillTPMultiplierWithLevel = cGlobalSkillTPMultiplierWithLevel;
/*    */     
/* 75 */     title = "Global Skills Mind Requirement Multiplied with each Level On";
/* 76 */     description = "Server Sided! " + title + ". (Default: true).";
/* 77 */     property = config.get(CATEGORY, title, false);
/* 78 */     property.comment = description;
/* 79 */     cGlobalSkillMindMultiplierWithLevel = property.getBoolean();
/* 80 */     GlobalSkillMindMultiplierWithLevel = cGlobalSkillMindMultiplierWithLevel;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\core\JGConfigSkills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */