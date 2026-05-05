/*     */ package JinRyuu.JRMCore.server.config.core;
/*     */ 
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGConfigMiniGameConcentration
/*     */   extends JGConfigBase
/*     */ {
/*     */   public static final String CATEGORY_MINIGAME_SERVERSIDED = "MiniGame";
/*     */   public static final String CATEGORY_MINIGAME_CONCENTRATION_SERVERSIDED = "MiniGame Concentration";
/*     */   public static boolean TPGainOn;
/*     */   public static boolean cTPGainOn;
/*     */   public static float TPlimitIncreasesWithPlayerLevel;
/*     */   public static float cTPlimitIncreasesWithPlayerLevel;
/*     */   public static float TPMultiplier;
/*     */   public static float cTPMultiplier;
/*     */   public static int TPDailyLimit;
/*     */   public static int cTPDailyLimit;
/*     */   public static float ComboTimer;
/*     */   public static float cComboTimer;
/*     */   public static boolean ConstantClickOn;
/*     */   public static boolean cConstantClickOn;
/*     */   public static int RandomMovementSpeed;
/*     */   public static int cRandomMovementSpeed;
/*     */   
/*     */   public static void init(Configuration config) {
/*  31 */     config.load();
/*  32 */     init_minigame(config);
/*  33 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_minigame(Configuration config) {
/*  39 */     String name = "";
/*  40 */     String CATEGORY = "MiniGame Concentration";
/*  41 */     String percentage = " (Percentage)";
/*  42 */     String SERVERSIDE = "Server Sided! ";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     String defaultValue = ". (true).";
/*  49 */     String title = "TP Gain On";
/*  50 */     String description = "If this is 'true' then from this minigame the TP gain feature will be enabled, if 'false' then players can't earn TP";
/*  51 */     Property property = config.get(CATEGORY, "" + title, true);
/*  52 */     property.comment = "Server Sided! " + description + defaultValue;
/*  53 */     cTPGainOn = property.getBoolean();
/*  54 */     TPGainOn = cTPGainOn;
/*     */     
/*  56 */     int min = 0, max = 100000;
/*  57 */     defaultValue = "" + getDefault("" + min, "" + max);
/*  58 */     title = "TP Limit Increases With Player Level Multiplier";
/*  59 */     description = "If value is above 0 then the minigame's TP daily limit will increase based on the player's level multiplied with the config. Setting it to 0 disables this";
/*  60 */     property = config.get(CATEGORY, "" + title, 1.0D);
/*  61 */     property.comment = "Server Sided! " + description + defaultValue;
/*  62 */     cTPlimitIncreasesWithPlayerLevel = (float)property.getDouble();
/*  63 */     if (cTPlimitIncreasesWithPlayerLevel < min) { cTPlimitIncreasesWithPlayerLevel = min; } else if (cTPlimitIncreasesWithPlayerLevel > max) { cTPlimitIncreasesWithPlayerLevel = max; }
/*  64 */      TPlimitIncreasesWithPlayerLevel = cTPlimitIncreasesWithPlayerLevel;
/*     */     
/*  66 */     min = 0; max = 100000;
/*  67 */     defaultValue = "" + getDefault("" + min, "" + max);
/*  68 */     title = "TP Multiplier";
/*  69 */     description = "TP gain reward multiplier";
/*  70 */     property = config.get(CATEGORY, "" + title, 0.02D);
/*  71 */     property.comment = "Server Sided! " + description + defaultValue;
/*  72 */     cTPMultiplier = (float)property.getDouble();
/*  73 */     if (cTPMultiplier < min) { cTPMultiplier = min; } else if (cTPMultiplier > max) { cTPMultiplier = max; }
/*  74 */      TPMultiplier = cTPMultiplier;
/*     */     
/*  76 */     min = 0; max = 1000000000;
/*  77 */     defaultValue = "" + getDefault("" + min, "" + max);
/*  78 */     title = "TP Daily Limit";
/*  79 */     description = "TP daily reward limitation";
/*  80 */     property = config.get(CATEGORY, "" + title, 20);
/*  81 */     property.comment = "Server Sided! " + description + defaultValue;
/*  82 */     cTPDailyLimit = property.getInt();
/*  83 */     if (cTPDailyLimit < min) { cTPDailyLimit = min; } else if (cTPDailyLimit > max) { cTPDailyLimit = max; }
/*  84 */      TPDailyLimit = cTPDailyLimit;
/*     */     
/*  86 */     min = 0; max = 100000;
/*  87 */     defaultValue = "" + getDefault("" + min, "" + max);
/*  88 */     title = "Combo Timer";
/*  89 */     description = "Combo Timer in seconds";
/*  90 */     property = config.get(CATEGORY, "" + title, 3.0D);
/*  91 */     property.comment = "Server Sided! " + description + defaultValue;
/*  92 */     cComboTimer = (float)property.getDouble();
/*  93 */     if (cComboTimer < min) { cComboTimer = min; } else if (cComboTimer > max) { cComboTimer = max; }
/*  94 */      ComboTimer = cComboTimer;
/*     */ 
/*     */ 
/*     */     
/*  98 */     defaultValue = ". (true).";
/*  99 */     title = "Constant Click On";
/* 100 */     description = "If this is 'true' then Constant clicking in the minigame is enabled";
/* 101 */     property = config.get(CATEGORY, "" + title, true);
/* 102 */     property.comment = "Server Sided! " + description + defaultValue;
/* 103 */     cConstantClickOn = property.getBoolean();
/* 104 */     ConstantClickOn = cConstantClickOn;
/*     */     
/* 106 */     min = 0; max = 1000;
/* 107 */     defaultValue = "" + getDefault("" + min, "" + max);
/* 108 */     title = "Energy Random Movement Speed";
/* 109 */     description = "Energy Balls Random Movement Speed from Value to -Value";
/* 110 */     property = config.get(CATEGORY, "" + title, 1);
/* 111 */     property.comment = "Server Sided! " + description + defaultValue;
/* 112 */     cRandomMovementSpeed = property.getInt();
/* 113 */     if (cRandomMovementSpeed < min) { cRandomMovementSpeed = min; } else if (cRandomMovementSpeed > max) { cRandomMovementSpeed = max; }
/* 114 */      RandomMovementSpeed = cRandomMovementSpeed;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\core\JGConfigMiniGameConcentration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */