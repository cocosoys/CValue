/*     */ package JinRyuu.JRMCore.server.config.dbc;
/*     */ 
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import java.util.HashMap;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGConfigDBCInstantTransmission
/*     */   extends JGConfigBase
/*     */ {
/*     */   public static final String CATEGORY_SERVERSIDED_MAIN = "main";
/*     */   public static final String CATEGORY_SERVERSIDED_SHORT = "short distance mode only";
/*     */   public static final String CATEGORY_SERVERSIDED_LONG = "long distance mode only";
/*     */   public static final String CATEGORY_SERVERSIDED_COMMON = "both distance modes";
/*  21 */   public static final String[] TP_MODES = new String[] { "Short Distance Teleportation", "Long Distance Teleportation" };
/*  22 */   public static final String[] SHORT_MODES = new String[] { "To Target", "In-front Target", "Behind Target" };
/*  23 */   public static final String[] SURROUND_MODES = new String[] { "Alone", "Group Members", "All Players" };
/*     */   
/*     */   public static final int MAX_LEVELS = 10;
/*     */   
/*     */   public static final int SHORT_TP = 0;
/*     */   public static final int LONG_TP = 1;
/*     */   public static final int FLAT_COST = 0;
/*     */   public static final int PERCENTAGE_COST = 1;
/*     */   public static boolean CONFIG_INSTANT_TRANSMISSION_NOTIFY_SERVER_ENABLED;
/*     */   public static final int MODES = 2;
/*  33 */   public static boolean[] CCONFIG_INSTANT_TRANSMISSION_ENABLED = new boolean[2];
/*  34 */   public static boolean[] CONFIG_INSTANT_TRANSMISSION_ENABLED = new boolean[2];
/*  35 */   public static byte[] CONFIG_INSTANT_TRANSMISSION_UNLOCK_SKILL_LEVEL = new byte[2];
/*  36 */   public static float[][][] CONFIG_INSTANT_TRANSMISSION_COST = new float[2][2][10];
/*     */   
/*  38 */   public static byte[] CONFIG_INSTANT_TRANSMISSION_KI_SENSE_REQUIREMENT = new byte[2];
/*     */   
/*     */   static final int MODES_SHORT = 3;
/*  41 */   public static boolean[] CONFIG_INSTANT_TRANSMISSION_ENABLED_SHORT = new boolean[3];
/*     */   
/*     */   public static boolean CONFIG_INSTANT_TRANSMISSION_SHORT_GO_THROUGH_BLOCKS_ENABLED;
/*     */   public static double CONFIG_INSTANT_TRANSMISSION_SHORT_TARGET_FINDER_RANGE;
/*     */   static final int MODES_SURROUND = 3;
/*  46 */   public static boolean[] CONFIG_INSTANT_TRANSMISSION_ENABLED_SURROUND = new boolean[3];
/*  47 */   public static int[][] CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL = new int[2][10];
/*     */   public static double CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE;
/*  49 */   public static float[][] CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER = new float[2][10];
/*     */   
/*     */   public static boolean CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_TP_ENABLED;
/*  52 */   public static float[][] CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST = new float[2][10];
/*  53 */   public static HashMap<Integer, Boolean> CONFIG_INSTANT_TRANSMISSION_DIMENSION_BLACKLIST = new HashMap<Integer, Boolean>();
/*     */   
/*  55 */   public static int[] CONFIG_INSTANT_TRANSMISSION_SHORT_MAX_RANGE = new int[10];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static int[][] CONFIG_INSTANT_TRANSMISSION_COOLDOWN = new int[2][10];
/*     */ 
/*     */   
/*  65 */   public static boolean[] CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_RELEASE_SENSE_REQUIRED_ENABLED = new boolean[2];
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init(Configuration config) {
/*  70 */     config.load();
/*  71 */     init_instantTransmission(config);
/*  72 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_instantTransmission(Configuration config) {
/*  78 */     String name = "";
/*  79 */     String nameShort = "Short Distance";
/*  80 */     String nameLong = "Long Distance";
/*  81 */     String CATEGORY = "main";
/*  82 */     String percentage = " (Percentage)";
/*  83 */     String warning = " Change only to your own responsibility! Having too high multiplier will cause glitches!";
/*  84 */     String server = "Server Sided!";
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
/*  96 */     String[] titles = TP_MODES;
/*  97 */     for (int m = 0; m < 2; m++) {
/*  98 */       String modeName = (m == 0) ? "Short Distance" : "Long Distance";
/*     */ 
/*     */       
/* 101 */       boolean bool = true;
/* 102 */       String str1 = "Teleport Mode: '" + modeName + "' Enabled";
/* 103 */       String str2 = "(true = Enabled, false = Disabled) (Default: " + bool + ")";
/* 104 */       Property property1 = config.get(CATEGORY, "" + str1, bool);
/* 105 */       property1.comment = "Server Sided! " + str2;
/* 106 */       CCONFIG_INSTANT_TRANSMISSION_ENABLED[m] = property1.getBoolean();
/* 107 */       CONFIG_INSTANT_TRANSMISSION_ENABLED[m] = CCONFIG_INSTANT_TRANSMISSION_ENABLED[m];
/*     */ 
/*     */       
/* 110 */       bool = true;
/* 111 */       str1 = "Teleport Mode: '" + modeName + "' Release Level Required Enabled";
/* 112 */       str2 = "Teleport player targets must have a release level above 0%. (true = Enabled, false = Disabled) (Default: " + bool + ")";
/* 113 */       property1 = config.get(CATEGORY, "" + str1, bool);
/* 114 */       property1.comment = "Server Sided! " + str2;
/* 115 */       CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_RELEASE_SENSE_REQUIRED_ENABLED[m] = property1.getBoolean();
/*     */ 
/*     */       
/* 118 */       int n = 1;
/* 119 */       int i1 = 10;
/* 120 */       str1 = "Teleport Mode: '" + modeName + "' Unlock level";
/* 121 */       str2 = "Set which Instant Transmission Skill Level unlocks this Mode" + getDefault("" + n, "" + i1);
/* 122 */       property1 = config.get(CATEGORY, str1, 1);
/* 123 */       property1.comment = "Server Sided! " + str2;
/* 124 */       CONFIG_INSTANT_TRANSMISSION_UNLOCK_SKILL_LEVEL[m] = (byte)property1.getInt();
/* 125 */       if (CONFIG_INSTANT_TRANSMISSION_UNLOCK_SKILL_LEVEL[m] < n) { CONFIG_INSTANT_TRANSMISSION_UNLOCK_SKILL_LEVEL[m] = (byte)n; }
/* 126 */       else if (CONFIG_INSTANT_TRANSMISSION_UNLOCK_SKILL_LEVEL[m] > i1) { CONFIG_INSTANT_TRANSMISSION_UNLOCK_SKILL_LEVEL[m] = (byte)i1; }
/*     */ 
/*     */       
/* 129 */       n = 0;
/* 130 */       i1 = 1000000000;
/* 131 */       (new String[10])[0] = "500 9.5"; (new String[10])[1] = "500 9"; (new String[10])[2] = "500 8.5"; (new String[10])[3] = "500 8"; (new String[10])[4] = "500 7.5"; (new String[10])[5] = "500 7"; (new String[10])[6] = "500 6.5"; (new String[10])[7] = "500 6"; (new String[10])[8] = "500 5.5"; (new String[10])[9] = "500 5"; (new String[10])[0] = "500 9.5"; (new String[10])[1] = "500 9"; (new String[10])[2] = "500 8.5"; (new String[10])[3] = "500 8"; (new String[10])[4] = "500 7.5"; (new String[10])[5] = "500 7"; (new String[10])[6] = "500 6.5"; (new String[10])[7] = "500 6"; (new String[10])[8] = "500 5.5"; (new String[10])[9] = "500 5"; String[] arrayOfString1 = (m == 0) ? new String[10] : new String[10];
/*     */       
/* 133 */       str1 = "Teleport Mode: '" + modeName + "' Ki Cost";
/* 134 */       str2 = "Set the Ki Cost of using the Skill per level (FlatCost PercentageCost)" + getDefault("" + n, "" + i1);
/* 135 */       property1 = config.get(CATEGORY, str1, arrayOfString1, "Server Sided! " + str2);
/* 136 */       String[] arrayOfString2 = property1.getStringList(); int i2;
/* 137 */       for (i2 = 0; i2 < 10; i2++) {
/*     */         
/* 139 */         String line = arrayOfString2[i2];
/* 140 */         String[] values = line.split(" ");
/* 141 */         CONFIG_INSTANT_TRANSMISSION_COST[m][0][i2] = Float.parseFloat(values[0]);
/* 142 */         if (CONFIG_INSTANT_TRANSMISSION_COST[m][0][i2] < n) { CONFIG_INSTANT_TRANSMISSION_COST[m][0][i2] = n; }
/* 143 */         else if (CONFIG_INSTANT_TRANSMISSION_COST[m][0][i2] > i1) { CONFIG_INSTANT_TRANSMISSION_COST[m][0][i2] = i1; }
/*     */         
/* 145 */         CONFIG_INSTANT_TRANSMISSION_COST[m][1][i2] = Float.parseFloat(values[1]);
/* 146 */         if (CONFIG_INSTANT_TRANSMISSION_COST[m][1][i2] < n) { CONFIG_INSTANT_TRANSMISSION_COST[m][1][i2] = n; }
/* 147 */         else if (CONFIG_INSTANT_TRANSMISSION_COST[m][1][i2] > i1) { CONFIG_INSTANT_TRANSMISSION_COST[m][1][i2] = i1; }
/*     */       
/*     */       } 
/*     */       
/* 151 */       n = -1;
/* 152 */       i1 = 1000000000;
/* 153 */       (new String[10])[0] = "0"; (new String[10])[1] = "1"; (new String[10])[2] = "2"; (new String[10])[3] = "4"; (new String[10])[4] = "6"; (new String[10])[5] = "9"; (new String[10])[6] = "12"; (new String[10])[7] = "16"; (new String[10])[8] = "20"; (new String[10])[9] = "25"; (new String[10])[0] = "0"; (new String[10])[1] = "1"; (new String[10])[2] = "2"; (new String[10])[3] = "4"; (new String[10])[4] = "6"; (new String[10])[5] = "9"; (new String[10])[6] = "12"; (new String[10])[7] = "16"; (new String[10])[8] = "20"; (new String[10])[9] = "25"; arrayOfString1 = (m == 0) ? new String[10] : new String[10];
/*     */       
/* 155 */       str1 = "Teleport Mode: '" + modeName + "' 'Surround' Player Limit";
/* 156 */       str2 = "Set the MAX number of Nearby Players the 'Surround' Mode can Teleport with the user per level. (-1 = No Limit)" + getDefault("" + n, "" + i1);
/* 157 */       property1 = config.get(CATEGORY, str1, arrayOfString1, "Server Sided! " + str2);
/* 158 */       arrayOfString2 = property1.getStringList();
/* 159 */       for (i2 = 0; i2 < 10; i2++) {
/*     */         
/* 161 */         String line = arrayOfString2[i2];
/* 162 */         CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL[m][i2] = Integer.parseInt(line);
/* 163 */         if (CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL[m][i2] < n) { CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL[m][i2] = n; }
/* 164 */         else if (CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL[m][i2] > i1) { CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL[m][i2] = i1; }
/*     */       
/*     */       } 
/*     */       
/* 168 */       n = 0;
/* 169 */       i1 = 9;
/* 170 */       str1 = "Teleport Mode: '" + modeName + "' Ki Sense Skill Level Requirement";
/* 171 */       str2 = "Required level of Ki Sense in order to this teleportation mode" + getDefault("" + n, "" + i1);
/* 172 */       property1 = config.get(CATEGORY, str1, (m == 0) ? 1 : 3, "Server Sided! " + str2);
/* 173 */       CONFIG_INSTANT_TRANSMISSION_KI_SENSE_REQUIREMENT[m] = (byte)property1.getInt();
/* 174 */       if (CONFIG_INSTANT_TRANSMISSION_KI_SENSE_REQUIREMENT[m] < n) { CONFIG_INSTANT_TRANSMISSION_KI_SENSE_REQUIREMENT[m] = (byte)n; }
/* 175 */       else if (CONFIG_INSTANT_TRANSMISSION_KI_SENSE_REQUIREMENT[m] > i1) { CONFIG_INSTANT_TRANSMISSION_KI_SENSE_REQUIREMENT[m] = (byte)i1; }
/*     */ 
/*     */       
/* 178 */       n = 0;
/* 179 */       i1 = 1000000000;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       (new String[10])[0] = "2"; (new String[10])[1] = "2"; (new String[10])[2] = "2"; (new String[10])[3] = "2"; (new String[10])[4] = "1"; (new String[10])[5] = "1"; (new String[10])[6] = "1"; (new String[10])[7] = "1"; (new String[10])[8] = "0"; (new String[10])[9] = "0"; (new String[10])[0] = "12"; (new String[10])[1] = "11"; (new String[10])[2] = "10"; (new String[10])[3] = "9"; (new String[10])[4] = "8"; (new String[10])[5] = "7"; (new String[10])[6] = "6"; (new String[10])[7] = "5"; (new String[10])[8] = "4"; (new String[10])[9] = "3"; arrayOfString1 = (m == 0) ? new String[10] : new String[10];
/*     */       
/* 186 */       str1 = "Teleport Mode: '" + modeName + "' Cooldown";
/* 187 */       str2 = "Cooldown timer. Result is ConfigValue multiplied by 5 Seconds! Timer until the Skill can be used again" + getDefault("" + n, "" + i1);
/* 188 */       property1 = config.get(CATEGORY, str1, arrayOfString1, "Server Sided! " + str2);
/* 189 */       arrayOfString2 = property1.getStringList();
/* 190 */       for (i2 = 0; i2 < 10; i2++) {
/*     */         
/* 192 */         String line = arrayOfString2[i2];
/* 193 */         CONFIG_INSTANT_TRANSMISSION_COOLDOWN[m][i2] = Integer.parseInt(line);
/* 194 */         if (CONFIG_INSTANT_TRANSMISSION_COOLDOWN[m][i2] < n) { CONFIG_INSTANT_TRANSMISSION_COOLDOWN[m][i2] = n; }
/* 195 */         else if (CONFIG_INSTANT_TRANSMISSION_COOLDOWN[m][i2] > i1) { CONFIG_INSTANT_TRANSMISSION_COOLDOWN[m][i2] = i1; }
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/* 200 */     CATEGORY = "long distance mode only";
/*     */     
/* 202 */     boolean defaultB = false;
/* 203 */     String title = "Long Teleport Mode: Notify Server if someone Teleported Enabled";
/* 204 */     String description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 205 */     Property property = config.get(CATEGORY, "" + title, defaultB);
/* 206 */     property.comment = "Server Sided! " + description;
/* 207 */     CONFIG_INSTANT_TRANSMISSION_NOTIFY_SERVER_ENABLED = property.getBoolean();
/*     */ 
/*     */     
/* 210 */     defaultB = true;
/* 211 */     title = "Long Teleport Mode: Dimensional Teleport Enabled";
/* 212 */     description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 213 */     property = config.get(CATEGORY, "" + title, defaultB);
/* 214 */     property.comment = "Server Sided! " + description;
/* 215 */     CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_TP_ENABLED = property.getBoolean();
/*     */ 
/*     */     
/* 218 */     int min = 0;
/* 219 */     int max = 1000000000;
/* 220 */     String[] defaultStringArray = { "500 9.5", "500 9", "500 8.5", "500 8", "500 7.5", "500 7", "500 6.5", "500 6", "500 5.5", "500 5" };
/* 221 */     title = "Long Teleport Mode: Dimensional Teleport Ki Cost";
/* 222 */     description = "Set the Ki Cost of using the Skill per level (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
/* 223 */     property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 224 */     String[] data = property.getStringList(); int k;
/* 225 */     for (k = 0; k < 10; k++) {
/*     */       
/* 227 */       String line = data[k];
/* 228 */       String[] values = line.split(" ");
/* 229 */       CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[0][k] = Float.parseFloat(values[0]);
/* 230 */       if (CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[0][k] < min) { CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[0][k] = min; }
/* 231 */       else if (CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[0][k] > max) { CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[0][k] = max; }
/*     */       
/* 233 */       CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[1][k] = Float.parseFloat(values[1]);
/* 234 */       if (CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[1][k] < min) { CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[1][k] = min; }
/* 235 */       else if (CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[1][k] > max) { CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[1][k] = max; }
/*     */     
/*     */     } 
/*     */     
/* 239 */     min = 0;
/* 240 */     max = 1000000000;
/* 241 */     defaultStringArray = new String[] { "" };
/* 242 */     title = "Long Teleport Mode: Dimensional Blacklist";
/* 243 */     description = "List of Dimension IDs where you can't use OR go into with Dimensional Teleportation.";
/* 244 */     property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 245 */     data = property.getStringList();
/* 246 */     for (k = 0; k < data.length; k++) {
/*     */       
/* 248 */       String line = data[k];
/* 249 */       if (line != null && line.length() > 0) {
/* 250 */         int value = Integer.parseInt(line);
/* 251 */         if (value < min) { value = min; }
/* 252 */         else if (value > max) { value = max; }
/* 253 */          CONFIG_INSTANT_TRANSMISSION_DIMENSION_BLACKLIST.put(Integer.valueOf(value), Boolean.valueOf(true));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 258 */     CATEGORY = "short distance mode only";
/*     */     
/* 260 */     defaultB = true;
/* 261 */     title = "Short Teleport Mode: Target Finder can go through blocks Enabled";
/* 262 */     description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 263 */     property = config.get(CATEGORY, "" + title, defaultB);
/* 264 */     property.comment = "Server Sided! " + description;
/* 265 */     CONFIG_INSTANT_TRANSMISSION_SHORT_GO_THROUGH_BLOCKS_ENABLED = property.getBoolean();
/*     */ 
/*     */     
/* 268 */     min = 0;
/* 269 */     max = 1000;
/* 270 */     title = "Short Teleport Mode: Target Finder Range per Update";
/* 271 */     description = "Block Radius around Target Finder. (Higher number = More Lagg)" + getDefault("" + min, "" + max);
/* 272 */     property = config.get(CATEGORY, "" + title, 1);
/* 273 */     property.comment = "Server Sided! " + description;
/* 274 */     CONFIG_INSTANT_TRANSMISSION_SHORT_TARGET_FINDER_RANGE = property.getDouble();
/* 275 */     if (CONFIG_INSTANT_TRANSMISSION_SHORT_TARGET_FINDER_RANGE < min) { CONFIG_INSTANT_TRANSMISSION_SHORT_TARGET_FINDER_RANGE = min; }
/* 276 */     else if (CONFIG_INSTANT_TRANSMISSION_SHORT_TARGET_FINDER_RANGE > max) { CONFIG_INSTANT_TRANSMISSION_SHORT_TARGET_FINDER_RANGE = max; }
/*     */ 
/*     */     
/* 279 */     min = 0;
/* 280 */     max = 1000000;
/* 281 */     defaultStringArray = new String[] { "55", "60", "65", "70", "75", "80", "85", "90", "95", "100" };
/* 282 */     title = "Short Teleport Mode: Target Finder Distance Range";
/* 283 */     description = "(Higher number = More Lagg)" + getDefault("" + min, "" + max);
/* 284 */     property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 285 */     data = property.getStringList();
/* 286 */     for (k = 0; k < 10; k++) {
/*     */       
/* 288 */       String line = data[k];
/* 289 */       CONFIG_INSTANT_TRANSMISSION_SHORT_MAX_RANGE[k] = Integer.parseInt(line);
/* 290 */       if (CONFIG_INSTANT_TRANSMISSION_SHORT_MAX_RANGE[k] < min) { CONFIG_INSTANT_TRANSMISSION_SHORT_MAX_RANGE[k] = min; }
/* 291 */       else if (CONFIG_INSTANT_TRANSMISSION_SHORT_MAX_RANGE[k] > max) { CONFIG_INSTANT_TRANSMISSION_SHORT_MAX_RANGE[k] = max; }
/*     */     
/*     */     } 
/* 294 */     titles = SHORT_MODES; int i;
/* 295 */     for (i = 0; i < 3; i++) {
/*     */       
/* 297 */       defaultB = true;
/* 298 */       title = "Short Teleport Mode: '" + titles[i] + "' Enabled";
/* 299 */       description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 300 */       property = config.get(CATEGORY, "" + title, defaultB);
/* 301 */       property.comment = "Server Sided! " + description;
/* 302 */       CONFIG_INSTANT_TRANSMISSION_ENABLED_SHORT[i] = property.getBoolean();
/*     */     } 
/*     */     
/* 305 */     CATEGORY = "both distance modes";
/* 306 */     titles = SURROUND_MODES;
/* 307 */     for (i = 0; i < 3; i++) {
/*     */       
/* 309 */       defaultB = true;
/* 310 */       title = "Surround Teleport Mode: '" + titles[i] + "' Enabled";
/* 311 */       description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
/* 312 */       property = config.get(CATEGORY, "" + title, defaultB);
/* 313 */       property.comment = "Server Sided! " + description;
/* 314 */       CONFIG_INSTANT_TRANSMISSION_ENABLED_SURROUND[i] = property.getBoolean();
/*     */     } 
/*     */ 
/*     */     
/* 318 */     min = 0;
/* 319 */     max = 1000000000;
/* 320 */     defaultStringArray = new String[] { "50 0.275", "50 0.25", "50 0.225", "50 0.2", "50 0.175", "50 0.15", "50 0.125", "50 0.1", "50 0.075", "50 0.05" };
/* 321 */     title = "Surround Teleport Mode: Ki Cost per Player";
/* 322 */     description = "Set the Ki Cost of using the Skill per level (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
/* 323 */     property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
/* 324 */     data = property.getStringList();
/* 325 */     for (int j = 0; j < 10; j++) {
/*     */       
/* 327 */       String line = data[j];
/* 328 */       String[] values = line.split(" ");
/* 329 */       CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[0][j] = Float.parseFloat(values[0]);
/* 330 */       if (CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[0][j] < min) { CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[0][j] = min; }
/* 331 */       else if (CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[0][j] > max) { CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[0][j] = max; }
/*     */       
/* 333 */       CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[1][j] = Float.parseFloat(values[1]);
/* 334 */       if (CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[1][j] < min) { CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[1][j] = min; }
/* 335 */       else if (CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[1][j] > max) { CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[1][j] = max; }
/*     */     
/*     */     } 
/*     */     
/* 339 */     min = 0;
/* 340 */     max = 1000;
/* 341 */     title = "Surround Teleport Mode: Target(s) Finder Range";
/* 342 */     description = "Block Radius around Target(s) Finder. (Higher number = More Lagg)" + getDefault("" + min, "" + max);
/* 343 */     property = config.get(CATEGORY, "" + title, 3);
/* 344 */     property.comment = "Server Sided! " + description;
/* 345 */     CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE = property.getDouble();
/* 346 */     if (CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE < min) { CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE = min; }
/* 347 */     else if (CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE > max) { CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE = max; }
/*     */   
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\dbc\JGConfigDBCInstantTransmission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */