/*     */ package JinRyuu.JRMCore.server.config.dbc;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import java.util.HashMap;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ 
/*     */ public class JGConfigRaces
/*     */   extends JGConfigBase
/*     */ {
/*     */   public static final int FLAT_COST = 0;
/*     */   public static final int PERCENTAGE_COST = 1;
/*     */   public static final int DAMAGE_MULTI = 0;
/*  16 */   public static final int CLASSES = JRMCoreH.ClassesDBC.length; public static final int HEALTH_MULTI = 1; public static final int KI_POWER_MULTI = 2;
/*     */   public static final int TICK_EXISTED = 0;
/*     */   public static final int COUNTDOWN_TIMER = 1;
/*     */   public static final String CATEGORY_RACES_SERVERSIDED = "Race Main Attribute";
/*     */   public static final String CATEGORY_RACE_SPECIAL_SERVERSIDED = "Race Special";
/*     */   private static byte lastRaceID;
/*  22 */   public static double[][][] CONFIG_RACES_ATTRIBUTE_MULTI = new double[JRMCoreH.Races.length][CLASSES][(JRMCoreH.attrInit[1]).length];
/*  23 */   public static double[][][] cCONFIG_RACES_ATTRIBUTE_MULTI = new double[JRMCoreH.Races.length][CLASSES][(JRMCoreH.attrInit[1]).length];
/*     */ 
/*     */ 
/*     */   
/*  27 */   public static int[][][] CONFIG_RACES_ATTRIBUTE_START = new int[JRMCoreH.Races.length][CLASSES][(JRMCoreH.attrInit[1]).length];
/*  28 */   public static int[][][] cCONFIG_RACES_ATTRIBUTE_START = new int[JRMCoreH.Races.length][CLASSES][(JRMCoreH.attrInit[1]).length];
/*     */ 
/*     */   
/*  31 */   public static float[][][] CONFIG_RACES_STATS_MULTI = new float[JRMCoreH.Races.length][CLASSES][(JRMCoreH.statNames[1]).length];
/*     */   
/*  33 */   public static float[][][] cCONFIG_RACES_STATS_MULTI = new float[JRMCoreH.Races.length][CLASSES][(JRMCoreH.statNames[1]).length];
/*     */   
/*  35 */   public static int[][][] CONFIG_RACES_STAT_BONUS = new int[JRMCoreH.Races.length][CLASSES][(JRMCoreH.statNames[1]).length];
/*  36 */   public static int[][][] cCONFIG_RACES_STAT_BONUS = new int[JRMCoreH.Races.length][CLASSES][(JRMCoreH.statNames[1]).length];
/*     */ 
/*     */   
/*     */   public static boolean CONFIG_MAJIN_ENABLED;
/*     */ 
/*     */   
/*     */   public static boolean cCONFIG_MAJIN_ENABLED;
/*     */ 
/*     */   
/*     */   public static boolean CONFIG_MAJIN_ABSORPTION_ENABLED;
/*     */ 
/*     */   
/*     */   public static boolean cCONFIG_MAJIN_ABSORPTION_ENABLED;
/*     */   
/*     */   public static boolean CONFIG_MAJIN_SUPER_REGEN_ENABLED;
/*     */   
/*  52 */   public static float[][] CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES = new float[(JRMCoreH.TransNms[5]).length + 3][2];
/*     */   
/*  54 */   public static float[][] CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES = new float[(JRMCoreH.TransNms[5]).length + 3][2];
/*     */   
/*  56 */   public static float[][] CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES = new float[(JRMCoreH.TransNms[5]).length + 3][2];
/*     */ 
/*     */   
/*  59 */   public static float[] CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES = new float[5];
/*  60 */   public static float[] CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES = new float[5];
/*  61 */   public static float[] CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES = new float[5];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static float[] CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI = new float[(JRMCoreH.TransNms[5]).length + 3];
/*  69 */   public static float[] cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI = new float[(JRMCoreH.TransNms[5]).length + 3];
/*     */   
/*  71 */   public static float[][] CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI = new float[(JRMCoreH.TransNms[5]).length + 3][3];
/*     */   
/*  73 */   public static float[][] CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI = new float[(JRMCoreH.TransNms[5]).length + 3][3];
/*     */   
/*  75 */   public static float[][] CONFIG_MAJIN_ABSORPTON_HEALTH_COST = new float[(JRMCoreH.TransNms[5]).length + 3][2];
/*  76 */   public static int[] CONFIG_MAJIN_ABSORPTON_CD_TIMER = new int[(JRMCoreH.TransNms[5]).length + 3];
/*     */   
/*  78 */   public static int[][] CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE = new int[(JRMCoreH.TransNms[5]).length + 3][2];
/*  79 */   public static float[] CONFIG_MAJIN_ABSORPTON_SPEED_MULTI = new float[(JRMCoreH.TransNms[5]).length + 3];
/*  80 */   public static float[] cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI = new float[(JRMCoreH.TransNms[5]).length + 3];
/*     */   
/*     */   public static int CONFIG_MAJIN_ABSORPTON_MAX_LEVEL;
/*     */   
/*     */   public static int CONFIG_MAJIN_ABSORPTON_MIN_GAIN;
/*     */   public static float CONFIG_MAJIN_ABSORPTON_GAIN_MULTI;
/*     */   public static boolean CONFIG_MAJIN_ADD_GAIN_ENABLED;
/*  87 */   public static HashMap<String, Boolean> CONFIG_MAJIN_ENTITY_BLACKLIST = new HashMap<String, Boolean>();
/*     */   
/*     */   public static boolean CONFIG_MAJIN_PURE_PINK_SKIN;
/*     */   
/*     */   public static boolean cCONFIG_MAJIN_PURE_PINK_SKIN;
/*     */   
/*     */   public static boolean CONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS;
/*     */   
/*     */   public static boolean cCONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS;
/*  96 */   public static float[][][] CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTIS = new float[(JRMCoreH.TransNms[5]).length + 3][][];
/*     */   
/*  98 */   public static float[][][] cCONFIG_MAJIN_ABSORPTON_USER_POWER_MULTIS = new float[(JRMCoreH.TransNms[5]).length + 3][][];
/*     */ 
/*     */   
/* 101 */   public static float[][][] CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTIS = new float[(JRMCoreH.TransNms[5]).length + 3][][];
/*     */   
/* 103 */   public static float[][][] cCONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTIS = new float[(JRMCoreH.TransNms[5]).length + 3][][];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init(Configuration config, byte raceID) {
/* 109 */     lastRaceID = raceID;
/* 110 */     config.load();
/* 111 */     init_races(config, raceID);
/* 112 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_races(Configuration config, byte raceID) {
/* 118 */     String name = "DBC " + JRMCoreH.Races[raceID];
/* 119 */     String CATEGORY = "Race Main Attribute";
/* 120 */     String percentage = " (Percentage)";
/* 121 */     String warning = " Change only to your own responsibility! Having too high multiplier will cause glitches!";
/* 122 */     String server = "Server Sided!";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     String raceName = JRMCoreH.Races[raceID];
/*     */     
/* 132 */     String[] defaultsAttributeMulti = new String[(JRMCoreH.attrInit[1]).length];
/* 133 */     String[] defaultsStartAttributes = new String[(JRMCoreH.attrInit[1]).length];
/* 134 */     String[] defaultsStarts = new String[(JRMCoreH.statNames[1]).length];
/* 135 */     String[][] defaultsStartBonus = new String[CLASSES][(JRMCoreH.statNames[1]).length]; int k;
/* 136 */     for (k = 0; k < (JRMCoreH.attrInit[1]).length; k++) {
/*     */       
/* 138 */       defaultsAttributeMulti[k] = JRMCoreH.attrInit[1][k] + (JRMCoreH.attrInit[1][k].contains(" ") ? "" : " ") + 1.0D;
/* 139 */       defaultsStartAttributes[k] = JRMCoreH.attrInit[1][k] + (JRMCoreH.attrInit[1][k].contains(" ") ? "" : " ") + JRMCoreH.attrStart[1][k][lastRaceID];
/*     */     } 
/* 141 */     for (k = 0; k < (JRMCoreH.statNames[1]).length; k++)
/*     */     {
/* 143 */       defaultsStarts[k] = JRMCoreH.statNames[1][k] + (JRMCoreH.statNames[1][k].contains(" ") ? "" : " ") + JRMCoreH.statInc[1][k];
/*     */     }
/* 145 */     for (int j = 0; j < JRMCoreH.ClassesDBC.length; j++) {
/*     */       
/* 147 */       for (int m = 0; m < (JRMCoreH.statNames[1]).length; m++)
/*     */       {
/* 149 */         defaultsStartBonus[j][m] = JRMCoreH.statNames[1][m] + (JRMCoreH.statNames[1][m].contains(" ") ? "" : " ") + (JRMCoreH.statIncBonusRaceDBC[m][lastRaceID] + JRMCoreH.statIncBonusClass[1][m][j]);
/*     */       }
/*     */     } 
/*     */     int i;
/* 153 */     for (i = 0; i < JRMCoreH.ClassesDBC.length; i++) {
/*     */       
/* 155 */       String className = JRMCoreH.ClassesDBC[i];
/*     */       
/* 157 */       int min = -100000, max = 100000;
/* 158 */       String title = " Attribute Multiplier";
/* 159 */       Property property = config.get(CATEGORY, name + " " + className + title, defaultsAttributeMulti, "Server Sided! " + name + title + getDefault("" + min, "" + max));
/* 160 */       String text = property.getString();
/* 161 */       String[] attributes = property.getStringList(); int m;
/* 162 */       for (m = 0; m < attributes.length; m++) {
/*     */         String value;
/*     */         
/* 165 */         if ((attributes[m].split(" ")).length > 1) { value = attributes[m].split(" ")[1]; }
/* 166 */         else { value = attributes[m]; }
/*     */         
/* 168 */         cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][m] = Double.parseDouble(value);
/* 169 */         if (cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][m] < min) { cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][m] = min; }
/* 170 */         else if (cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][m] > max) { cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][m] = max; }
/* 171 */          CONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][m] = cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][m];
/*     */       } 
/*     */ 
/*     */       
/* 175 */       min = -1000000000; max = 1000000000;
/* 176 */       title = " Starting Attribute";
/* 177 */       property = config.get(CATEGORY, name + " " + className + title, defaultsStartAttributes, "Server Sided! " + name + title + getDefault("" + min, "" + max));
/* 178 */       text = property.getString();
/* 179 */       attributes = property.getStringList();
/* 180 */       for (m = 0; m < attributes.length; m++) {
/*     */         String value;
/*     */         
/* 183 */         if ((attributes[m].split(" ")).length > 1) { value = attributes[m].split(" ")[1]; }
/* 184 */         else { value = attributes[m]; }
/*     */         
/* 186 */         cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][m] = Integer.parseInt(value);
/* 187 */         if (cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][m] < min) { cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][m] = min; }
/* 188 */         else if (cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][m] > max) { cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][m] = max; }
/* 189 */          CONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][m] = cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][m];
/*     */       } 
/*     */ 
/*     */       
/* 193 */       min = -100000; max = 100000;
/* 194 */       title = " Stat Multiplier from Attribute";
/* 195 */       property = config.get(CATEGORY, name + " " + className + title, defaultsStarts, "Server Sided! " + name + title + getDefault("" + min, "" + max));
/* 196 */       text = property.getString();
/* 197 */       attributes = property.getStringList();
/* 198 */       for (m = 0; m < attributes.length; m++) {
/*     */         String value;
/*     */         
/* 201 */         if ((attributes[m].split(" ")).length > 1) { value = attributes[m].split(" ")[1]; }
/* 202 */         else { value = attributes[m]; }
/*     */         
/* 204 */         cCONFIG_RACES_STATS_MULTI[lastRaceID][i][m] = Float.parseFloat(value);
/* 205 */         if (cCONFIG_RACES_STATS_MULTI[lastRaceID][i][m] < min) { cCONFIG_RACES_STATS_MULTI[lastRaceID][i][m] = min; }
/* 206 */         else if (cCONFIG_RACES_STATS_MULTI[lastRaceID][i][m] > max) { cCONFIG_RACES_STATS_MULTI[lastRaceID][i][m] = max; }
/* 207 */          CONFIG_RACES_STATS_MULTI[lastRaceID][i][m] = cCONFIG_RACES_STATS_MULTI[lastRaceID][i][m];
/*     */       } 
/*     */ 
/*     */       
/* 211 */       min = -1000000000; max = 1000000000;
/* 212 */       title = " Stat Bonus";
/* 213 */       property = config.get(CATEGORY, name + " " + className + title, defaultsStartBonus[i], "Server Sided! " + name + title + getDefault("" + min, "" + max));
/* 214 */       text = property.getString();
/* 215 */       attributes = property.getStringList();
/* 216 */       for (m = 0; m < attributes.length; m++) {
/*     */         String value;
/*     */         
/* 219 */         if ((attributes[m].split(" ")).length > 1) { value = attributes[m].split(" ")[1]; }
/* 220 */         else { value = attributes[m]; }
/*     */         
/* 222 */         cCONFIG_RACES_STAT_BONUS[lastRaceID][i][m] = Integer.parseInt(value);
/* 223 */         if (cCONFIG_RACES_STAT_BONUS[lastRaceID][i][m] < min) { cCONFIG_RACES_STAT_BONUS[lastRaceID][i][m] = min; }
/* 224 */         else if (cCONFIG_RACES_STAT_BONUS[lastRaceID][i][m] > max) { cCONFIG_RACES_STAT_BONUS[lastRaceID][i][m] = max; }
/* 225 */          CONFIG_RACES_STAT_BONUS[lastRaceID][i][m] = cCONFIG_RACES_STAT_BONUS[lastRaceID][i][m];
/*     */       } 
/*     */     } 
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
/*     */ 
/*     */     
/* 249 */     if (JRMCoreH.isRaceMajin(raceID)) {
/* 250 */       CATEGORY = "Race Special";
/*     */       
/* 252 */       boolean defaultB = true;
/* 253 */       String title = " Ki Powertype Enabled";
/* 254 */       String description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 255 */       Property property = config.get(CATEGORY, name + title, defaultB);
/* 256 */       property.comment = "Server Sided! " + description;
/* 257 */       cCONFIG_MAJIN_ENABLED = property.getBoolean();
/* 258 */       CONFIG_MAJIN_ENABLED = cCONFIG_MAJIN_ENABLED;
/*     */ 
/*     */       
/* 261 */       defaultB = true;
/* 262 */       title = " Super Regeneration Enabled";
/* 263 */       description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 264 */       property = config.get(CATEGORY, name + title, defaultB);
/* 265 */       property.comment = "Server Sided! " + description;
/* 266 */       CONFIG_MAJIN_SUPER_REGEN_ENABLED = property.getBoolean();
/*     */ 
/*     */       
/* 269 */       defaultB = true;
/* 270 */       title = " Absorption Enabled";
/* 271 */       description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 272 */       property = config.get(CATEGORY, name + title, defaultB);
/* 273 */       property.comment = "Server Sided! " + description;
/* 274 */       cCONFIG_MAJIN_ABSORPTION_ENABLED = property.getBoolean();
/* 275 */       CONFIG_MAJIN_ABSORPTION_ENABLED = cCONFIG_MAJIN_ABSORPTION_ENABLED;
/*     */ 
/*     */       
/* 278 */       defaultB = true;
/* 279 */       title = " Pure Form Pink Skin Color Enabled";
/* 280 */       description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 281 */       property = config.get(CATEGORY, name + title, defaultB);
/* 282 */       property.comment = "Server Sided! " + description;
/* 283 */       cCONFIG_MAJIN_PURE_PINK_SKIN = property.getBoolean();
/* 284 */       CONFIG_MAJIN_PURE_PINK_SKIN = cCONFIG_MAJIN_PURE_PINK_SKIN;
/*     */ 
/*     */       
/* 287 */       defaultB = false;
/* 288 */       title = " Absorption Multiplies Bonus Attribute Multipliers Enabled";
/* 289 */       description = "Enabled = Multiplies Bonus Attribute Multipliers, Disabled = Adds to the Bonus Attribute Multipliers. (true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 290 */       property = config.get(CATEGORY, name + title, defaultB);
/* 291 */       property.comment = "Server Sided! " + description;
/* 292 */       cCONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS = property.getBoolean();
/* 293 */       CONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS = cCONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 298 */       int min = 0;
/* 299 */       int max = 1000000000;
/* 300 */       String[] defaultStringArray = { "Base 1 0.05", "Evil 2 0.075", "Full 3 0.1", "Pure 5 0.175", "God 4 0.125", "Mystic 3 0.125", "UI 5 0.125", "G.O.D. 5 0.125" };
/*     */       
/* 302 */       title = " Super Regeneration Health Gain";
/* 303 */       description = "Set the Health Gain of using the Skill per Form (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
/* 304 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 305 */       String[] data = property.getStringList();
/* 306 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 308 */         String line = data[i];
/* 309 */         String[] values = line.split(" ");
/* 310 */         CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] = Float.parseFloat(values[1]);
/* 311 */         if (CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] < min) { CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] = min; }
/* 312 */         else if (CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] > max) { CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] = max; }
/*     */         
/* 314 */         CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] = Float.parseFloat(values[2]);
/* 315 */         if (CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] < min) { CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] = min; }
/* 316 */         else if (CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] > max) { CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] = max; }
/*     */       
/*     */       } 
/*     */       
/* 320 */       min = 0;
/* 321 */       max = 1000000000;
/* 322 */       defaultStringArray = new String[] { "Base 1 0.05", "Evil 2 0.06", "Full 3 0.07", "Pure 5 0.09", "God 4 0.08", "Mystic 3 0.07", "UI 4 0.08", "G.O.D. 4 0.08" };
/*     */       
/* 324 */       title = " Super Regeneration Ki Cost";
/* 325 */       description = "Set the Ki Cost of using the Skill per Form (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
/* 326 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 327 */       data = property.getStringList();
/* 328 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 330 */         String line = data[i];
/* 331 */         String[] values = line.split(" ");
/* 332 */         CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] = Float.parseFloat(values[1]);
/* 333 */         if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] < min) { CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] = min; }
/* 334 */         else if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] > max) { CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] = max; }
/*     */         
/* 336 */         CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] = Float.parseFloat(values[2]);
/* 337 */         if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] < min) { CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] = min; }
/* 338 */         else if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] > max) { CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] = max; }
/*     */       
/*     */       } 
/*     */       
/* 342 */       min = 0;
/* 343 */       max = 1000000000;
/* 344 */       defaultStringArray = new String[] { "Base 1 0.025", "Evil 2 0.03", "Full 3 0.035", "Pure 5 0.045", "God 4 0.04", "Mystic 3 0.035", "UI 4 0.04", "G.O.D. 4 0.04" };
/*     */       
/* 346 */       title = " Super Regeneration Stamina Cost";
/* 347 */       description = "Set the Stamina Cost of using the Skill per Form (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
/* 348 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 349 */       data = property.getStringList();
/* 350 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 352 */         String line = data[i];
/* 353 */         String[] values = line.split(" ");
/* 354 */         CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] = Float.parseFloat(values[1]);
/* 355 */         if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] < min) { CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] = min; }
/* 356 */         else if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] > max) { CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] = max; }
/*     */         
/* 358 */         CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] = Float.parseFloat(values[2]);
/* 359 */         if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] < min) { CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] = min; }
/* 360 */         else if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] > max) { CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] = max; }
/*     */       
/*     */       } 
/*     */       
/* 364 */       min = 0;
/* 365 */       max = 1000000000;
/* 366 */       defaultStringArray = new String[] { "0.9", "0.95", "0.1", "1.05", "1.1" };
/*     */       
/* 368 */       title = " Super Regeneration Health Gain multiplier per Racial Skill Level";
/* 369 */       description = "Set the Health Gain of using the Skill per Form" + getDefault("" + min, "" + max);
/* 370 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 371 */       data = property.getStringList();
/* 372 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 374 */         String line = data[i];
/* 375 */         CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] = Float.parseFloat(line);
/* 376 */         if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] < min) { CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] = min; }
/* 377 */         else if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] > max) { CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] = max; }
/*     */       
/*     */       } 
/*     */       
/* 381 */       min = 0;
/* 382 */       max = 1000000000;
/* 383 */       defaultStringArray = new String[] { "0.9", "0.95", "0.1", "1.15", "1.2" };
/*     */       
/* 385 */       title = " Super Regeneration Ki Cost multiplier per Racial Skill Level";
/* 386 */       description = "Set the Ki Cost of using the Skill per Form" + getDefault("" + min, "" + max);
/* 387 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 388 */       data = property.getStringList();
/* 389 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 391 */         String line = data[i];
/* 392 */         CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] = Float.parseFloat(line);
/* 393 */         if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] < min) { CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] = min; }
/* 394 */         else if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] > max) { CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] = max; }
/*     */       
/*     */       } 
/*     */       
/* 398 */       min = 0;
/* 399 */       max = 1000000000;
/* 400 */       defaultStringArray = new String[] { "0.9", "0.95", "0.1", "1.15", "1.2" };
/*     */       
/* 402 */       title = " Super Regeneration Stamina Cost multiplier per Racial Skill Level";
/* 403 */       description = "Set the Stamina Cost of using the Skill per Form" + getDefault("" + min, "" + max);
/* 404 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 405 */       data = property.getStringList();
/* 406 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 408 */         String line = data[i];
/* 409 */         CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] = Float.parseFloat(line);
/* 410 */         if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] < min) { CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] = min; }
/* 411 */         else if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] > max) { CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] = max; }
/*     */       
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 418 */       min = 0;
/* 419 */       max = 1000000000;
/* 420 */       defaultStringArray = new String[] { "Base 0.01", "Evil 0.01", "Full 0.01", "Pure 0.01", "God 0.01", "Mystic 0.01", "UI 0.01", "G.O.D. 0.01" };
/* 421 */       title = " Absorption Attribute Multiplier";
/* 422 */       description = "Set the Attribute Multiplier of using the Skill per Form " + getDefault("" + min, "" + max);
/* 423 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 424 */       data = property.getStringList();
/* 425 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 427 */         String line = data[i];
/* 428 */         String[] values = line.split(" ");
/* 429 */         cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] = Float.parseFloat(values[1]);
/* 430 */         if (cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] < min) { cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] = min; }
/* 431 */         else if (cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] > max) { cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] = max; }
/* 432 */          CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] = cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i];
/*     */       } 
/*     */ 
/*     */       
/* 436 */       min = 0;
/* 437 */       max = 1000000000;
/* 438 */       defaultStringArray = new String[] { "Base 0.25 0.05 0.25", "Evil 0.25 0.05 0.25", "Full 0.25 0.05 0.25", "Pure 0.25 0.05 0.25", "God 0.25 0.05 0.25", "Mystic 0.25 0.05 0.25", "UI 0.25 0.05 0.25", "G.O.D. 0.25 0.05 0.25" };
/*     */       
/* 440 */       title = " Absorption User Power Multiplier";
/* 441 */       description = "Set the Power Multiplier of using the Skill per Form, which decides whether or not you can Absorb the target (DamageMulti HealthMulti KiPowerMulti)" + getDefault("" + min, "" + max) + " Power Result = (UserDamage * DamageMulti + UserHealth * HealthMulti + UserKiPower * KiPowerMulti)";
/*     */       
/* 443 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 444 */       data = property.getStringList();
/* 445 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 447 */         String line = data[i];
/* 448 */         String[] values = line.split(" ");
/* 449 */         CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] = Float.parseFloat(values[1]);
/* 450 */         if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] < min) { CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] = min; }
/* 451 */         else if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] > max) { CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] = max; }
/*     */         
/* 453 */         CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] = Float.parseFloat(values[2]);
/* 454 */         if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] < min) { CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] = min; }
/* 455 */         else if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] > max) { CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] = max; }
/*     */         
/* 457 */         CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] = (values.length > 3) ? Float.parseFloat(values[3]) : 0.25F;
/* 458 */         if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] < min) { CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] = min; }
/* 459 */         else if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] > max) { CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] = max; }
/*     */         
/* 461 */         String[] defaultArrayS = defaultStringArray[i].split(" ");
/* 462 */         if (values.length > defaultArrayS.length)
/* 463 */         { data[i] = values[0] + " " + values[1] + " " + values[2] + " " + values[3]; }
/*     */         
/* 465 */         else if (values.length == 3) { data[i] = data[i] + " " + defaultArrayS[3]; }
/*     */       
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 475 */       property.set(data);
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
/* 530 */       min = 0;
/* 531 */       max = 1000000000;
/*     */       
/* 533 */       defaultStringArray = new String[] { "Base 0.25 0.05 0.25", "Evil 0.25 0.05 0.25", "Full 0.25 0.05 0.25", "Pure 0.25 0.05 0.25", "God 0.25 0.05 0.25", "Mystic 0.25 0.05 0.25", "UI 0.25 0.05 0.25", "G.O.D. 0.25 0.05 0.25" };
/*     */       
/* 535 */       title = " Absorption Target Power Multiplier";
/* 536 */       description = "Set the Power Multiplier of using the Skill per Absorption User's Form, which decides whether or not you can Absorb the target (DamageMulti HealthMulti KiPowerMulti)" + getDefault("" + min, "" + max) + " Power Result = (TargetDamage * DamageMulti + TargetHealth * HealthMulti + TargetKiPower * KiPowerMulti)";
/*     */       
/* 538 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 539 */       data = property.getStringList();
/* 540 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 542 */         String line = data[i];
/* 543 */         String[] values = line.split(" ");
/* 544 */         CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] = Float.parseFloat(values[1]);
/* 545 */         if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] < min) { CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] = min; }
/* 546 */         else if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] > max) { CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] = max; }
/*     */         
/* 548 */         CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] = Float.parseFloat(values[2]);
/* 549 */         if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] < min) { CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] = min; }
/* 550 */         else if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] > max) { CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] = max; }
/*     */         
/* 552 */         CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] = (values.length > 3) ? Float.parseFloat(values[3]) : 0.25F;
/* 553 */         if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] < min) { CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] = min; }
/* 554 */         else if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] > max) { CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] = max; }
/*     */         
/* 556 */         String[] defaultArrayS = defaultStringArray[i].split(" ");
/* 557 */         if (values.length > defaultArrayS.length)
/* 558 */         { data[i] = values[0] + " " + values[1] + " " + values[2] + " " + values[3]; }
/*     */         
/* 560 */         else if (values.length == 3) { data[i] = data[i] + " " + defaultArrayS[3]; }
/*     */       
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 566 */       property.set(data);
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
/* 638 */       min = 0;
/* 639 */       max = 1000000000;
/* 640 */       defaultStringArray = new String[] { "Base 10 0.1", "Evil 10 0.1", "Full 10 0.1", "Pure 10 0.1", "God 10 0.1", "Mystic 10 0.1", "UI 10 0.1", "G.O.D. 10 0.1" };
/* 641 */       title = " Absorption Health Cost";
/* 642 */       description = "Set the Health Cost of using the Skill per Form (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
/* 643 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 644 */       data = property.getStringList();
/* 645 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 647 */         String line = data[i];
/* 648 */         String[] values = line.split(" ");
/* 649 */         CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] = Float.parseFloat(values[1]);
/* 650 */         if (CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] < min) { CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] = min; }
/* 651 */         else if (CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] > max) { CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] = max; }
/*     */         
/* 653 */         CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] = Float.parseFloat(values[2]);
/* 654 */         if (CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] < min) { CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] = min; }
/* 655 */         else if (CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] > max) { CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] = max; }
/*     */       
/*     */       } 
/*     */       
/* 659 */       min = 0;
/* 660 */       max = 1000000000;
/* 661 */       defaultStringArray = new String[] { "Base 3", "Evil 3", "Full 3", "Pure 3", "God 3", "Mystic 3", "UI 3", "G.O.D. 3" };
/* 662 */       title = " Absorption Cooldown";
/* 663 */       description = "Skill Cooldown timer per Form. Result is ConfigValue multiplied by 5 Seconds! Timer until the Skill can be used again" + getDefault("" + min, "" + max);
/* 664 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 665 */       data = property.getStringList();
/* 666 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 668 */         String line = data[i];
/* 669 */         String[] values = line.split(" ");
/* 670 */         CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] = Integer.parseInt(values[1]);
/* 671 */         if (CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] < min) { CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] = min; }
/* 672 */         else if (CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] > max) { CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] = max; }
/*     */       
/*     */       } 
/*     */       
/* 676 */       min = 0;
/* 677 */       max = 1000000000;
/* 678 */       defaultStringArray = new String[] { "Base 500 80", "Evil 525 80", "Full 550 80", "Pure 650 80", "God 575 80", "Mystic 550 80", "UI 575 80", "G.O.D. 575 80" };
/* 679 */       title = " Absorption Max Tick Life";
/*     */       
/* 681 */       description = "Absorption Entity Max Life Tick TImer (TicksExisted CountdownTimer). The Absorption Entity will vanish once the CountdownTimer is done. The CountdownTimer start either when the TicksExisted timer is reached OR if the Entity stops moving" + getDefault("" + min, "" + max);
/* 682 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 683 */       data = property.getStringList();
/* 684 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 686 */         String line = data[i];
/* 687 */         String[] values = line.split(" ");
/* 688 */         CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] = Integer.parseInt(values[1]);
/* 689 */         if (CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] < min) { CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] = min; }
/* 690 */         else if (CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] > max) { CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] = max; }
/*     */         
/* 692 */         CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] = Integer.parseInt(values[2]);
/* 693 */         if (CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] < min) { CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] = min; }
/* 694 */         else if (CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] > max) { CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] = max; }
/*     */       
/*     */       } 
/*     */       
/* 698 */       min = 0;
/* 699 */       max = 1000000000;
/* 700 */       defaultStringArray = new String[] { "Base 0.75", "Evil 0.75", "Full 0.75", "Pure 0.75", "God 0.75", "Mystic 0.75", "UI 0.75", "G.O.D. 0.75" };
/* 701 */       title = " Absorption Entity Speed Multiplier";
/* 702 */       description = "Set the Speed Multiplier of the Skill per Form" + getDefault("" + min, "" + max);
/* 703 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 704 */       data = property.getStringList();
/* 705 */       for (i = 0; i < data.length; i++) {
/*     */         
/* 707 */         String line = data[i];
/* 708 */         String[] values = line.split(" ");
/* 709 */         cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] = Float.parseFloat(values[1]);
/* 710 */         if (cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] < min) { cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] = min; }
/* 711 */         else if (cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] > max) { cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] = max; }
/* 712 */          CONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] = cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i];
/*     */       } 
/*     */ 
/*     */       
/* 716 */       min = 0;
/* 717 */       max = 1000000000;
/* 718 */       title = " Absorption Max Level";
/* 719 */       description = "Max Absorption Level you can reach" + getDefault("" + min, "" + max);
/* 720 */       property = config.get(CATEGORY, name + title, 50);
/* 721 */       property.comment = "Server Sided! " + description;
/* 722 */       CONFIG_MAJIN_ABSORPTON_MAX_LEVEL = property.getInt();
/* 723 */       if (CONFIG_MAJIN_ABSORPTON_MAX_LEVEL < min) { CONFIG_MAJIN_ABSORPTON_MAX_LEVEL = min; }
/* 724 */       else if (CONFIG_MAJIN_ABSORPTON_MAX_LEVEL > max) { CONFIG_MAJIN_ABSORPTON_MAX_LEVEL = max; }
/*     */ 
/*     */       
/* 727 */       min = 0;
/* 728 */       max = 1000000000;
/* 729 */       title = " Absorption Min Gain";
/* 730 */       description = "Minimum Gain from Absorbing someone" + getDefault("" + min, "" + max);
/* 731 */       property = config.get(CATEGORY, name + title, 3);
/* 732 */       property.comment = "Server Sided! " + description;
/* 733 */       CONFIG_MAJIN_ABSORPTON_MIN_GAIN = property.getInt();
/* 734 */       if (CONFIG_MAJIN_ABSORPTON_MIN_GAIN < min) { CONFIG_MAJIN_ABSORPTON_MIN_GAIN = min; }
/* 735 */       else if (CONFIG_MAJIN_ABSORPTON_MIN_GAIN > max) { CONFIG_MAJIN_ABSORPTON_MIN_GAIN = max; }
/*     */ 
/*     */       
/* 738 */       min = 0;
/* 739 */       max = 1000000000;
/* 740 */       title = " Absorption Gain Multiplier";
/* 741 */       description = "Gain Multiplier when Absorbing someone. Result = (attackTarget / userAttack * THIS_CONFIG)" + getDefault("" + min, "" + max);
/* 742 */       property = config.get(CATEGORY, name + title, 500.0D);
/* 743 */       property.comment = "Server Sided! " + description;
/* 744 */       CONFIG_MAJIN_ABSORPTON_GAIN_MULTI = (float)property.getDouble();
/* 745 */       if (CONFIG_MAJIN_ABSORPTON_GAIN_MULTI < min) { CONFIG_MAJIN_ABSORPTON_GAIN_MULTI = min; }
/* 746 */       else if (CONFIG_MAJIN_ABSORPTON_GAIN_MULTI > max) { CONFIG_MAJIN_ABSORPTON_GAIN_MULTI = max; }
/*     */ 
/*     */       
/* 749 */       defaultB = true;
/* 750 */       title = " Absorption Add Gain Enabled";
/* 751 */       description = "(true = Enabled (Add to Absorption Level), false = Disabled (Replace the Absorption Level)) (Default: " + defaultB + ")";
/* 752 */       property = config.get(CATEGORY, name + title, defaultB);
/* 753 */       property.comment = "Server Sided! " + description;
/* 754 */       CONFIG_MAJIN_ADD_GAIN_ENABLED = property.getBoolean();
/*     */ 
/*     */       
/* 757 */       defaultStringArray = new String[] { "JinRyuu.JRMCore.entity.EntitySafeZone", "JinRyuu.JRMCore.entity.EntityNPCshadow" };
/* 758 */       title = " Absorption LivingEntity Blacklist";
/* 759 */       description = "List down the Class paths and name of the Entities.";
/* 760 */       property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 761 */       data = property.getStringList();
/* 762 */       for (String line : data)
/*     */       {
/* 764 */         CONFIG_MAJIN_ENTITY_BLACKLIST.put(line, Boolean.valueOf(true));
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\dbc\JGConfigRaces.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */