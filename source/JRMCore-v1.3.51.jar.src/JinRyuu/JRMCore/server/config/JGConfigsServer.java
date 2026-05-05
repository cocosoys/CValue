/*     */ package JinRyuu.JRMCore.server.config;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCore;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
/*     */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
/*     */ import JinRyuu.JRMCore.server.config.core.JGConfigSkills;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCAAiDifficulty;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigSkillsDBC;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*     */ import JinRyuu.JRMCore.server.config.nc.JGConfigSkillsNC;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import java.io.File;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGConfigsServer
/*     */ {
/*     */   public static final String CONFIG_JRMC = "/jingames/jrmc/";
/*     */   public static final String CONFIG_MINIGAMES = "/jingames/jrmc/minigames/";
/*     */   public static final String CONFIG_DBC = "/jingames/dbc/";
/*     */   public static final String CONFIG_NC = "/jingames/nc/";
/*     */   public static final String CONFIG_FORM = "/jingames/dbc/forms/";
/*     */   public static final String CONFIG_RACE = "/jingames/dbc/races/";
/*     */   public static final String CONFIG_AAI = "/jingames/dbc/aai/";
/*     */   public static final String CONFIG_DBC_SKILLS = "/jingames/dbc/skills/";
/*     */   public static Configuration minigame_concentration;
/*  39 */   public static Configuration[] configDir_formMastery = new Configuration[JRMCoreH.Races.length]; public static Configuration minigame_airBoxing; public static Configuration ultraInstinct; public static Configuration godOfDestruction; public static Configuration[] dbcRaceClassAttributeMultiplier; public static Configuration configDir_skillsDBC; public static Configuration configDir_skillsNC; public static Configuration configDir_skills; public static Configuration[] configDir_DBCAAiDifficulties;
/*     */   public static Configuration configDir_skillInstantTransmission;
/*     */   public static Configuration configDir_formMasteryMain;
/*     */   
/*     */   public static void preInitServer(FMLPreInitializationEvent event) {
/*  44 */     JRMCore.configDir_minigame_concentration = new File(event.getModConfigurationDirectory().getPath() + "/jingames/jrmc/minigames/" + "concentration.cfg");
/*  45 */     minigame_concentration = new Configuration(JRMCore.configDir_minigame_concentration);
/*  46 */     JGConfigMiniGameConcentration.init(minigame_concentration);
/*     */     
/*  48 */     JRMCore.configDir_minigame_airBoxing = new File(event.getModConfigurationDirectory().getPath() + "/jingames/jrmc/minigames/" + "airboxing.cfg");
/*  49 */     minigame_airBoxing = new Configuration(JRMCore.configDir_minigame_airBoxing);
/*  50 */     JGConfigMiniGameAirBoxing.init(minigame_airBoxing);
/*     */     
/*  52 */     JRMCore.configDir_form = new File(event.getModConfigurationDirectory().getPath() + "/jingames/dbc/forms/" + "ultra_instinct.cfg");
/*  53 */     ultraInstinct = new Configuration(JRMCore.configDir_form);
/*  54 */     JGConfigUltraInstinct.init(ultraInstinct);
/*     */     
/*  56 */     JRMCore.configDir_form_god = new File(event.getModConfigurationDirectory().getPath() + "/jingames/dbc/forms/" + "god_of_destruction.cfg");
/*  57 */     godOfDestruction = new Configuration(JRMCore.configDir_form_god);
/*  58 */     JGConfigDBCGoD.init(godOfDestruction);
/*     */     
/*  60 */     dbcRaceClassAttributeMultiplier = new Configuration[JRMCoreH.Races.length];
/*  61 */     JRMCore.configDir_races = new File[JRMCoreH.Races.length]; int i;
/*  62 */     for (i = 0; i < JRMCoreH.Races.length; i++) {
/*  63 */       String race = JRMCoreH.Races[i];
/*     */       
/*  65 */       JRMCore.configDir_races[i] = new File(event.getModConfigurationDirectory().getPath() + "/jingames/dbc/races/" + race.toLowerCase() + "/main.cfg");
/*  66 */       dbcRaceClassAttributeMultiplier[i] = new Configuration(JRMCore.configDir_races[i]);
/*  67 */       JGConfigRaces.init(dbcRaceClassAttributeMultiplier[i], (byte)i);
/*     */     } 
/*     */     
/*  70 */     JRMCore.configDir_skillsDBC = new File(event.getModConfigurationDirectory().getPath() + "/jingames/dbc/" + "skill_costs.cfg");
/*  71 */     configDir_skillsDBC = new Configuration(JRMCore.configDir_skillsDBC);
/*  72 */     JGConfigSkillsDBC.init(configDir_skillsDBC);
/*     */     
/*  74 */     JRMCore.configDir_skillsNC = new File(event.getModConfigurationDirectory().getPath() + "/jingames/nc/" + "skill_costs.cfg");
/*  75 */     configDir_skillsNC = new Configuration(JRMCore.configDir_skillsNC);
/*  76 */     JGConfigSkillsNC.init(configDir_skillsNC);
/*     */     
/*  78 */     JRMCore.configDir_skills = new File(event.getModConfigurationDirectory().getPath() + "/jingames/jrmc/" + "skill_costs.cfg");
/*  79 */     configDir_skills = new Configuration(JRMCore.configDir_skills);
/*  80 */     JGConfigSkills.init(configDir_skills);
/*     */ 
/*     */     
/*  83 */     configDir_DBCAAiDifficulties = new Configuration[JGConfigDBCAAiDifficulty.DIFFICULTIES.length];
/*  84 */     JRMCore.configDir_DBCAAiDifficulties = new File[JGConfigDBCAAiDifficulty.DIFFICULTIES.length];
/*  85 */     for (i = 0; i < JGConfigDBCAAiDifficulty.DIFFICULTIES.length; i++) {
/*  86 */       String difficulty = JGConfigDBCAAiDifficulty.DIFFICULTIES[i];
/*     */       
/*  88 */       JRMCore.configDir_DBCAAiDifficulties[i] = new File(event.getModConfigurationDirectory().getPath() + "/jingames/dbc/aai/" + difficulty + ".cfg");
/*  89 */       configDir_DBCAAiDifficulties[i] = new Configuration(JRMCore.configDir_DBCAAiDifficulties[i]);
/*  90 */       JGConfigDBCAAiDifficulty.init(configDir_DBCAAiDifficulties[i], (byte)i);
/*     */     } 
/*     */ 
/*     */     
/*  94 */     JRMCore.configDir_skillInstantTransmission = new File(event.getModConfigurationDirectory().getPath() + "/jingames/dbc/skills/" + "instant_transmission.cfg");
/*  95 */     configDir_skillInstantTransmission = new Configuration(JRMCore.configDir_skillInstantTransmission);
/*  96 */     JGConfigDBCInstantTransmission.init(configDir_skillInstantTransmission);
/*     */     
/*  98 */     JRMCore.configDir_formMasteryMain = new File(event.getModConfigurationDirectory().getPath() + "/jingames/dbc/forms/" + "form_mastery_main.cfg");
/*  99 */     configDir_formMasteryMain = new Configuration(JRMCore.configDir_formMasteryMain);
/* 100 */     JGConfigDBCFormMastery.initMain(configDir_formMasteryMain);
/*     */     
/* 102 */     for (i = 0; i < JRMCoreH.Races.length; i++) {
/* 103 */       String race = JRMCoreH.Races[i];
/* 104 */       JRMCore.configDir_formMastery[i] = new File(event.getModConfigurationDirectory().getPath() + "/jingames/dbc/races/" + race.toLowerCase() + "/form_mastery.cfg");
/* 105 */       configDir_formMastery[i] = new Configuration(JRMCore.configDir_formMastery[i]);
/* 106 */       JGConfigDBCFormMastery.init(configDir_formMastery[i], i);
/*     */     } 
/*     */     
/* 109 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 110 */     JRMCoreConfig.init(config);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\JGConfigsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */