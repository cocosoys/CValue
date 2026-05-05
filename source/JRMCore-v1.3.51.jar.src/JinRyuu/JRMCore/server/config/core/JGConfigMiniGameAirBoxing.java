/*     */ package JinRyuu.JRMCore.server.config.core;
/*     */ 
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ 
/*     */ public class JGConfigMiniGameAirBoxing
/*     */   extends JGConfigBase
/*     */ {
/*     */   public static final String CATEGORY_MINIGAME_SERVERSIDED = "MiniGame";
/*     */   public static final String CATEGORY_MINIGAME_AIRBOXING_SERVERSIDED = "MiniGame AirBoxing";
/*     */   public static final String CATEGORY_MINIGAME_MODE_SERVERSIDED = "MiniGame Mode";
/*     */   public static boolean TPGainOn;
/*     */   public static boolean cTPGainOn;
/*     */   public static float TPlimitIncreasesWithPlayerLevel;
/*     */   public static float cTPlimitIncreasesWithPlayerLevel;
/*     */   public static float TPMultiplier;
/*     */   public static float cTPMultiplier;
/*     */   public static int TPDailyLimit;
/*     */   public static int cTPDailyLimit;
/*     */   public static final int MODES = 4;
/*     */   public static int StartLife;
/*     */   public static int cStartLife;
/*  25 */   public static float[] KeySpawnSpeed = new float[4];
/*  26 */   public static float[] cKeySpawnSpeed = new float[4];
/*  27 */   public static float[] KeySpeed = new float[4];
/*  28 */   public static float[] cKeySpeed = new float[4];
/*  29 */   public static int[] KeyLifeTaken = new int[4];
/*  30 */   public static int[] cKeyLifeTaken = new int[4];
/*  31 */   public static int[][] KeyTypeIDs = new int[4][];
/*  32 */   public static int[][] cKeyTypeIDs = new int[4][];
/*     */ 
/*     */   
/*     */   public static void init(Configuration config) {
/*  36 */     config.load();
/*  37 */     init_minigame(config);
/*  38 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_minigame(Configuration config) {
/*  44 */     String name = "";
/*  45 */     String CATEGORY = "MiniGame AirBoxing";
/*  46 */     String percentage = " (Percentage)";
/*  47 */     String SERVERSIDE = "Server Sided! ";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  53 */     String defaultValue = ". (true).";
/*  54 */     String title = "TP Gain On";
/*  55 */     String description = "If 'true' then from this minigame the TP gain feature will be enabled, if 'false' then players can't earn TP";
/*  56 */     Property property = config.get(CATEGORY, "" + title, true);
/*  57 */     property.comment = "Server Sided! " + description + defaultValue;
/*  58 */     cTPGainOn = property.getBoolean();
/*  59 */     TPGainOn = cTPGainOn;
/*     */     
/*  61 */     int min = 0, max = 100000;
/*  62 */     defaultValue = "" + getDefault("" + min, "" + max);
/*  63 */     title = "TP Limit Increases With Player Level Multiplier";
/*  64 */     description = "If value is above 0 then the minigame's TP daily limit will increase based on the player's level multiplied with the config. Setting it to 0 disables this";
/*  65 */     property = config.get(CATEGORY, "" + title, 1.0D);
/*  66 */     property.comment = "Server Sided! " + description + defaultValue;
/*  67 */     cTPlimitIncreasesWithPlayerLevel = (float)property.getDouble();
/*  68 */     if (cTPlimitIncreasesWithPlayerLevel < min) { cTPlimitIncreasesWithPlayerLevel = min; } else if (cTPlimitIncreasesWithPlayerLevel > max) { cTPlimitIncreasesWithPlayerLevel = max; }
/*  69 */      TPlimitIncreasesWithPlayerLevel = cTPlimitIncreasesWithPlayerLevel;
/*     */     
/*  71 */     min = 0; max = 100000;
/*  72 */     defaultValue = "" + getDefault("" + min, "" + max);
/*  73 */     title = "TP Multiplier";
/*  74 */     description = "TP gain reward multiplier";
/*  75 */     property = config.get(CATEGORY, "" + title, 0.035D);
/*  76 */     property.comment = "Server Sided! " + description + defaultValue;
/*  77 */     cTPMultiplier = (float)property.getDouble();
/*  78 */     if (cTPMultiplier < min) { cTPMultiplier = min; } else if (cTPMultiplier > max) { cTPMultiplier = max; }
/*  79 */      TPMultiplier = cTPMultiplier;
/*     */     
/*  81 */     min = 0; max = 1000000000;
/*  82 */     defaultValue = "" + getDefault("" + min, "" + max);
/*  83 */     title = "TP Daily Limit";
/*  84 */     description = "TP daily reward limitation";
/*  85 */     property = config.get(CATEGORY, "" + title, 20);
/*  86 */     property.comment = "Server Sided! " + description + defaultValue;
/*  87 */     cTPDailyLimit = property.getInt();
/*  88 */     if (cTPDailyLimit < min) { cTPDailyLimit = min; } else if (cTPDailyLimit > max) { cTPDailyLimit = max; }
/*  89 */      TPDailyLimit = cTPDailyLimit;
/*     */     
/*  91 */     min = 0; max = 1000000;
/*  92 */     defaultValue = "" + getDefault("" + min, "" + max);
/*  93 */     title = "Starting Life";
/*  94 */     description = "Starting Life points";
/*  95 */     property = config.get(CATEGORY, "" + title, 1);
/*  96 */     property.comment = "Server Sided! " + description + defaultValue;
/*  97 */     cStartLife = property.getInt();
/*  98 */     if (cStartLife < min) { cStartLife = min; } else if (cStartLife > max) { cStartLife = max; }
/*  99 */      StartLife = cStartLife;
/*     */ 
/*     */     
/* 102 */     double[] KeySpawnSpeed2 = { 1.0D, 0.8D, 0.7D, 1.0D };
/* 103 */     double[] KeySpeed2 = { 0.09D, 0.085D, 0.08D, 0.1D };
/* 104 */     int[] KeyLifeTaken2 = { 0, 0, 0, 0 };
/*     */ 
/*     */ 
/*     */     
/* 108 */     String[][] KeyTypeIDs2 = { { "W" }, { "W", "A" }, { "W", "A", "S" }, { "W", "A", "S", "D" } };
/*     */     
/* 110 */     for (int i = 0; i < 4; i++) {
/*     */       
/* 112 */       CATEGORY = "MiniGame Mode" + i;
/*     */       
/* 114 */       min = 0; max = 1000;
/* 115 */       defaultValue = "" + getDefault("" + min, "" + max);
/* 116 */       title = "Key Spawn Timer";
/* 117 */       description = "Key Spawn Speed in seconds";
/* 118 */       property = config.get(CATEGORY, "" + title, KeySpawnSpeed2[i]);
/* 119 */       property.comment = "Server Sided! " + description + defaultValue;
/* 120 */       cKeySpawnSpeed[i] = (float)property.getDouble();
/* 121 */       if (cKeySpawnSpeed[i] < min) { cKeySpawnSpeed[i] = min; } else if (cKeySpawnSpeed[i] > max) { cKeySpawnSpeed[i] = max; }
/* 122 */        KeySpawnSpeed[i] = cKeySpawnSpeed[i];
/*     */       
/* 124 */       min = 0; max = 1000;
/* 125 */       defaultValue = "" + getDefault("" + min, "" + max);
/* 126 */       title = "Key Movement Speed";
/* 127 */       description = "Key Movement Speed value";
/* 128 */       property = config.get(CATEGORY, "" + title, KeySpeed2[i]);
/* 129 */       property.comment = "Server Sided! " + description + defaultValue;
/* 130 */       cKeySpeed[i] = (float)property.getDouble();
/* 131 */       if (cKeySpeed[i] < min) { cKeySpeed[i] = min; } else if (cKeySpeed[i] > max) { cKeySpeed[i] = max; }
/* 132 */        KeySpeed[i] = cKeySpeed[i];
/*     */       
/* 134 */       min = 0; max = 1000;
/* 135 */       defaultValue = "" + getDefault("" + min, "" + max);
/* 136 */       title = "Life Taken on Miss";
/* 137 */       description = "Life lost on Key Miss";
/* 138 */       property = config.get(CATEGORY, "" + title, KeyLifeTaken2[i]);
/* 139 */       property.comment = "Server Sided! " + description + defaultValue;
/* 140 */       cKeyLifeTaken[i] = property.getInt();
/* 141 */       if (cKeyLifeTaken[i] < min) { cKeyLifeTaken[i] = min; } else if (cKeyLifeTaken[i] > max) { cKeyLifeTaken[i] = max; }
/* 142 */        KeyLifeTaken[i] = cKeyLifeTaken[i];
/*     */       
/* 144 */       min = 0; max = 4;
/* 145 */       defaultValue = ". (W A S D).";
/* 146 */       String[] defaultValueS = KeyTypeIDs2[i];
/* 147 */       title = "Key Types";
/* 148 */       description = "Key Types in the mode";
/*     */ 
/*     */ 
/*     */       
/* 152 */       property = config.get(CATEGORY, "" + title, defaultValueS, "Server Sided! " + description + defaultValue);
/* 153 */       String text = property.getString();
/* 154 */       String[] keyValues = property.getStringList();
/* 155 */       cKeyTypeIDs[i] = new int[keyValues.length];
/* 156 */       KeyTypeIDs[i] = new int[keyValues.length];
/* 157 */       for (int j = 0; j < keyValues.length; j++) {
/*     */         
/* 159 */         cKeyTypeIDs[i][j] = keyToId(keyValues[j]);
/* 160 */         if (cKeyTypeIDs[i][j] < min) { cKeyTypeIDs[i][j] = min; } else if (cKeyTypeIDs[i][j] > max) { cKeyTypeIDs[i][j] = max; }
/* 161 */          KeyTypeIDs[i][j] = cKeyTypeIDs[i][j];
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int keyToId(String s) {
/* 168 */     if (s.equals("W")) return 0; 
/* 169 */     if (s.equals("A")) return 1; 
/* 170 */     if (s.equals("S")) return 2; 
/* 171 */     return 3;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\core\JGConfigMiniGameAirBoxing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */