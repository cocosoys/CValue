/*     */ package JinRyuu.JRMCore.server.config.dbc;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ public class JGConfigUltraInstinct extends JGConfigBase {
/*     */   public static final String CATEGORY_FORM_UI_SERVERSIDED = "Ultra Instinct";
/*     */   public static final String CATEGORY_FORM_UI_LVL_SERVERSIDED = " Level ";
/*     */   public static byte CONFIG_UI_LEVELS;
/*     */   
/*     */   public static void init(Configuration config) {
/*  14 */     config.load();
/*  15 */     init_form_ultra_instinct(config);
/*  16 */     config.save();
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte CONFIG_UI_EXPERIENCE_PAIN_MODE;
/*     */   
/*     */   public static int CONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION;
/*     */   
/*     */   public static String[] CONFIG_UI_CHAT_SUCCEED;
/*     */   
/*     */   public static boolean[] CONFIG_UI_SKIP;
/*     */   
/*     */   public static int[] CONFIG_UI_LEVEL_REQUIREMENT;
/*     */   
/*     */   public static int[] CONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT;
/*     */   
/*     */   public static int[] CONFIG_UI_TP_COST;
/*     */   
/*     */   public static int[] CONFIG_UI_MIND_REQUIREMENT;
/*     */   
/*     */   public static byte[] CONFIG_UI_HEALTH_PERCENTAGE;
/*     */   
/*     */   public static int[] CONFIG_UI_HEAT_DURATION;
/*     */   
/*     */   public static int[] CONFIG_UI_PAIN_DURATION;
/*     */   
/*     */   public static boolean[] CONFIG_UI_HAIR_WHITE;
/*     */   
/*     */   public static int[] CONFIG_UI_ATTRIBUTE_MULTI;
/*     */   
/*     */   public static byte[][] CONFIG_UI_DODGE_RATE;
/*     */   
/*     */   public static byte[][] CONFIG_UI_ATTACK_RATE;
/*     */   
/*     */   public static int[] CONFIG_UI_ATTACK_DAMAGE_PERCENTAGE;
/*     */   
/*     */   public static String CONFIG_UI_CANT_DODGE;
/*     */   
/*     */   public static String CONFIG_UI_CAN_COUNTER;
/*     */   
/*     */   public static int[] CONFIG_UI_DODGE_STAMINA_COST;
/*     */   
/*     */   public static int[] CONFIG_UI_COUNTER_STAMINA_COST;
/*     */   
/*     */   public static boolean CONFIG_UI_PERCENTAGE_STAMINA_COST;
/*     */   
/*     */   public static byte CONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL;
/*     */   
/*     */   public static final byte CHECK_EACH_LEVEL = 0;
/*     */   
/*     */   public static final byte CHECK_LAST_SKIPPABLE = 1;
/*     */   
/*     */   public static boolean CONFIG_UI_IGNORE_BASE_CONFIG;
/*     */   public static boolean CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG;
/*     */   public static float[][] CONFIG_UI_ATTRIBUTE_MULTI_RACE;
/*     */   public static byte cCONFIG_UI_LEVELS;
/*     */   public static byte cCONFIG_UI_EXPERIENCE_PAIN_MODE;
/*     */   public static int cCONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION;
/*     */   public static String[] cCONFIG_UI_CHAT_SUCCEED;
/*     */   public static boolean[] cCONFIG_UI_SKIP;
/*     */   public static int[] cCONFIG_UI_LEVEL_REQUIREMENT;
/*     */   public static int[] cCONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT;
/*     */   public static int[] cCONFIG_UI_TP_COST;
/*     */   public static int[] cCONFIG_UI_MIND_REQUIREMENT;
/*     */   public static byte[] cCONFIG_UI_HEALTH_PERCENTAGE;
/*     */   public static int[] cCONFIG_UI_HEAT_DURATION;
/*     */   public static int[] cCONFIG_UI_PAIN_DURATION;
/*     */   public static boolean[] cCONFIG_UI_HAIR_WHITE;
/*     */   public static int[] cCONFIG_UI_ATTRIBUTE_MULTI;
/*     */   public static byte[][] cCONFIG_UI_DODGE_RATE;
/*     */   public static byte[][] cCONFIG_UI_ATTACK_RATE;
/*     */   public static int[] cCONFIG_UI_ATTACK_DAMAGE_PERCENTAGE;
/*     */   public static String cCONFIG_UI_CANT_DODGE;
/*     */   public static String cCONFIG_UI_CAN_COUNTER;
/*     */   public static int[] cCONFIG_UI_DODGE_STAMINA_COST;
/*     */   public static int[] cCONFIG_UI_COUNTER_STAMINA_COST;
/*     */   public static boolean cCONFIG_UI_PERCENTAGE_STAMINA_COST;
/*     */   public static byte cCONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL;
/*     */   public static boolean cCONFIG_UI_IGNORE_BASE_CONFIG;
/*     */   public static boolean cCONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG;
/*     */   public static float[][] cCONFIG_UI_ATTRIBUTE_MULTI_RACE;
/*     */   
/*     */   private static void init_form_ultra_instinct(Configuration config) {
/*  99 */     String form = "Ultra Instinct";
/* 100 */     String CATEGORY = "Ultra Instinct";
/* 101 */     String percentage = " (Percentage)";
/* 102 */     String warning = " Change only to your own responsibility! Having too high multiplier will cause glitches!";
/* 103 */     String server = "Server Sided!";
/*     */ 
/*     */ 
/*     */     
/* 107 */     int min = 0;
/* 108 */     int max = 10;
/* 109 */     Property property = config.get(CATEGORY, "Ultra Instinct Levels", 3);
/* 110 */     property.comment = "Server Sided! Ultra Instinct Skill Levels" + getDefault("" + min, "" + max) + " (Setting to 0 disables Ultra instinct)";
/* 111 */     cCONFIG_UI_LEVELS = (byte)property.getInt();
/* 112 */     if (cCONFIG_UI_LEVELS < min) { cCONFIG_UI_LEVELS = (byte)min; }
/* 113 */     else if (cCONFIG_UI_LEVELS > max) { cCONFIG_UI_LEVELS = (byte)max; }
/* 114 */      CONFIG_UI_LEVELS = cCONFIG_UI_LEVELS;
/*     */     
/* 116 */     min = 0;
/* 117 */     max = 3;
/* 118 */     String title = "Was In Pain Requirement";
/* 119 */     property = config.get(CATEGORY, "Ultra Instinct " + title, 1);
/* 120 */     property.comment = "Server Sided! Ultra Instinct " + title + "(0 = Disable, 1 = Once, 2 = Every time) (Gives a requirement to enter a White Hair level. The player must receive the pain Status effect)";
/* 121 */     cCONFIG_UI_EXPERIENCE_PAIN_MODE = (byte)property.getInt();
/* 122 */     if (cCONFIG_UI_EXPERIENCE_PAIN_MODE < min) { cCONFIG_UI_EXPERIENCE_PAIN_MODE = (byte)min; }
/* 123 */     else if (cCONFIG_UI_EXPERIENCE_PAIN_MODE > max) { cCONFIG_UI_EXPERIENCE_PAIN_MODE = (byte)max; }
/* 124 */      CONFIG_UI_EXPERIENCE_PAIN_MODE = cCONFIG_UI_EXPERIENCE_PAIN_MODE;
/*     */     
/* 126 */     min = 0;
/* 127 */     max = 1000;
/* 128 */     title = "Was In Pain Reset Duration";
/* 129 */     property = config.get(CATEGORY, "Ultra Instinct " + title, 50);
/* 130 */     property.comment = "Server Sided! Ultra Instinct " + title + getDefault("" + min, "" + max) + " (Time until the Was in Pain vanishes (ONLY WORKS WITH Was in Pain MODE 2))";
/* 131 */     cCONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION = property.getInt();
/* 132 */     if (cCONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION < min) { cCONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION = min; }
/* 133 */     else if (cCONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION > max) { cCONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION = max; }
/* 134 */      CONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION = cCONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION;
/*     */ 
/*     */     
/* 137 */     String[] default01 = { "outOfWorld", "fall", "drown", "starve", "cactus", "UICounter" };
/* 138 */     title = "Can't dodge these Damage Sources";
/* 139 */     property = config.get(CATEGORY, "Ultra Instinct " + title, default01);
/* 140 */     property.comment = "Server Sided! " + title;
/* 141 */     String[] content_list1 = property.getStringList();
/* 142 */     for (int i = 0; i < content_list1.length; i++)
/*     */     {
/* 144 */       cCONFIG_UI_CANT_DODGE += content_list1[i] + ((i < content_list1.length - 1) ? ";" : "");
/*     */     }
/* 146 */     CONFIG_UI_CANT_DODGE = cCONFIG_UI_CANT_DODGE;
/*     */ 
/*     */     
/* 149 */     String[] default02 = { "mob", "player" };
/* 150 */     title = "Can Counter these Damage Sources";
/* 151 */     property = config.get(CATEGORY, "Ultra Instinct " + title, default02);
/* 152 */     property.comment = "Server Sided! " + title;
/* 153 */     String[] content_list2 = property.getStringList();
/* 154 */     for (int j = 0; j < content_list2.length; j++)
/*     */     {
/* 156 */       cCONFIG_UI_CAN_COUNTER += content_list2[j] + ((j < content_list2.length - 1) ? ";" : "");
/*     */     }
/* 158 */     CONFIG_UI_CAN_COUNTER = cCONFIG_UI_CAN_COUNTER;
/*     */ 
/*     */     
/* 161 */     title = "Stamina Costs are Percentage On";
/* 162 */     property = config.get(CATEGORY, "Ultra Instinct " + title, true);
/* 163 */     property.comment = "Server Sided! " + title + " (Counter and Dodge Stamina Cost Config values will be become percentage values)";
/* 164 */     cCONFIG_UI_PERCENTAGE_STAMINA_COST = property.getBoolean();
/* 165 */     CONFIG_UI_PERCENTAGE_STAMINA_COST = cCONFIG_UI_PERCENTAGE_STAMINA_COST;
/*     */     
/* 167 */     title = "Ignore Base Attribute Multiplier Config while in UI - On";
/* 168 */     property = config.get(CATEGORY, "Ultra Instinct " + title, true);
/* 169 */     property.comment = "Server Sided! " + title;
/* 170 */     cCONFIG_UI_IGNORE_BASE_CONFIG = property.getBoolean();
/* 171 */     CONFIG_UI_IGNORE_BASE_CONFIG = cCONFIG_UI_IGNORE_BASE_CONFIG;
/*     */     
/* 173 */     title = "Ignore Base Ki Regen Config Multiplier while in UI - On";
/* 174 */     property = config.get(CATEGORY, "Ultra Instinct " + title, true);
/* 175 */     property.comment = "Server Sided! " + title;
/* 176 */     cCONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG = property.getBoolean();
/* 177 */     CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG = cCONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG;
/*     */ 
/*     */ 
/*     */     
/* 181 */     min = 0;
/* 182 */     max = 1;
/* 183 */     title = "Check Skippable Level Requirement for each level";
/* 184 */     property = config.get(CATEGORY, "Ultra Instinct " + title, 0);
/*     */     
/* 186 */     property.comment = "Server Sided! Ultra Instinct " + title + getDefault("" + min, "" + max) + " (0 - Checks each level | 1 - Checks last skippable level only)";
/* 187 */     cCONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL = (byte)property.getInt();
/* 188 */     if (cCONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL < min) { cCONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL = (byte)min; }
/* 189 */     else if (cCONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL > max) { cCONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL = (byte)max; }
/* 190 */      CONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL = cCONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 197 */     cCONFIG_UI_CHAT_SUCCEED = new String[CONFIG_UI_LEVELS];
/* 198 */     cCONFIG_UI_SKIP = new boolean[CONFIG_UI_LEVELS];
/* 199 */     cCONFIG_UI_LEVEL_REQUIREMENT = new int[CONFIG_UI_LEVELS];
/* 200 */     cCONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT = new int[CONFIG_UI_LEVELS];
/* 201 */     cCONFIG_UI_TP_COST = new int[CONFIG_UI_LEVELS];
/* 202 */     cCONFIG_UI_MIND_REQUIREMENT = new int[CONFIG_UI_LEVELS];
/* 203 */     cCONFIG_UI_HEALTH_PERCENTAGE = new byte[CONFIG_UI_LEVELS];
/* 204 */     cCONFIG_UI_HEAT_DURATION = new int[CONFIG_UI_LEVELS];
/* 205 */     cCONFIG_UI_PAIN_DURATION = new int[CONFIG_UI_LEVELS];
/* 206 */     cCONFIG_UI_HAIR_WHITE = new boolean[CONFIG_UI_LEVELS];
/* 207 */     cCONFIG_UI_ATTRIBUTE_MULTI = new int[CONFIG_UI_LEVELS];
/* 208 */     cCONFIG_UI_DODGE_RATE = new byte[CONFIG_UI_LEVELS][2];
/* 209 */     cCONFIG_UI_ATTACK_RATE = new byte[CONFIG_UI_LEVELS][2];
/* 210 */     cCONFIG_UI_ATTACK_DAMAGE_PERCENTAGE = new int[CONFIG_UI_LEVELS];
/* 211 */     cCONFIG_UI_DODGE_STAMINA_COST = new int[CONFIG_UI_LEVELS];
/* 212 */     cCONFIG_UI_COUNTER_STAMINA_COST = new int[CONFIG_UI_LEVELS];
/* 213 */     cCONFIG_UI_ATTRIBUTE_MULTI_RACE = new float[CONFIG_UI_LEVELS][JRMCoreH.Races.length];
/*     */     
/* 215 */     CONFIG_UI_CHAT_SUCCEED = new String[CONFIG_UI_LEVELS];
/* 216 */     CONFIG_UI_SKIP = new boolean[CONFIG_UI_LEVELS];
/* 217 */     CONFIG_UI_LEVEL_REQUIREMENT = new int[CONFIG_UI_LEVELS];
/* 218 */     CONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT = new int[CONFIG_UI_LEVELS];
/* 219 */     CONFIG_UI_TP_COST = new int[CONFIG_UI_LEVELS];
/* 220 */     CONFIG_UI_MIND_REQUIREMENT = new int[CONFIG_UI_LEVELS];
/* 221 */     CONFIG_UI_HEALTH_PERCENTAGE = new byte[CONFIG_UI_LEVELS];
/* 222 */     CONFIG_UI_HEAT_DURATION = new int[CONFIG_UI_LEVELS];
/* 223 */     CONFIG_UI_PAIN_DURATION = new int[CONFIG_UI_LEVELS];
/* 224 */     CONFIG_UI_HAIR_WHITE = new boolean[CONFIG_UI_LEVELS];
/* 225 */     CONFIG_UI_ATTRIBUTE_MULTI = new int[CONFIG_UI_LEVELS];
/* 226 */     CONFIG_UI_DODGE_RATE = new byte[CONFIG_UI_LEVELS][2];
/* 227 */     CONFIG_UI_ATTACK_RATE = new byte[CONFIG_UI_LEVELS][2];
/* 228 */     CONFIG_UI_ATTACK_DAMAGE_PERCENTAGE = new int[CONFIG_UI_LEVELS];
/* 229 */     CONFIG_UI_DODGE_STAMINA_COST = new int[CONFIG_UI_LEVELS];
/* 230 */     CONFIG_UI_COUNTER_STAMINA_COST = new int[CONFIG_UI_LEVELS];
/* 231 */     CONFIG_UI_ATTRIBUTE_MULTI_RACE = new float[CONFIG_UI_LEVELS][JRMCoreH.Races.length];
/*     */     
/* 233 */     int max_id = 2;
/*     */     
/* 235 */     for (int k = 0; k < CONFIG_UI_LEVELS; k++) {
/*     */       
/* 237 */       int level_id = k + 1;
/*     */       
/* 239 */       CATEGORY = "Ultra Instinct Level " + level_id;
/*     */ 
/*     */       
/* 242 */       String[] default00 = { "A sign of Ultra Instinct", "@p is Near completion", "This is Ultra Instinct" };
/* 243 */       title = "Successful transformation Chat Message";
/* 244 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default00[getID(k, max_id)]);
/* 245 */       property.comment = "Server Sided! " + title + " (Percentage)" + " (Writes the message out for the player only)";
/* 246 */       cCONFIG_UI_CHAT_SUCCEED[k] = property.getString();
/* 247 */       CONFIG_UI_CHAT_SUCCEED[k] = cCONFIG_UI_CHAT_SUCCEED[k];
/*     */       
/* 249 */       boolean[] default0 = { true, false, false };
/* 250 */       title = "Skippable Level On";
/* 251 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default0[getID(k, max_id)]);
/* 252 */       property.comment = "Server Sided! " + title + " (If the user has learned a higher level then it will jump straight to it)";
/* 253 */       cCONFIG_UI_SKIP[k] = property.getBoolean();
/* 254 */       CONFIG_UI_SKIP[k] = cCONFIG_UI_SKIP[k];
/*     */       
/* 256 */       min = 0;
/* 257 */       max = 1000000;
/* 258 */       int[] default1 = { 200, 250, 300 };
/* 259 */       title = "Level Requirement";
/* 260 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default1[getID(k, max_id)]);
/* 261 */       property.comment = "Server Sided! " + title;
/* 262 */       cCONFIG_UI_LEVEL_REQUIREMENT[k] = property.getInt();
/* 263 */       if (cCONFIG_UI_LEVEL_REQUIREMENT[k] < min) cCONFIG_UI_LEVEL_REQUIREMENT[k] = min; 
/* 264 */       CONFIG_UI_LEVEL_REQUIREMENT[k] = cCONFIG_UI_LEVEL_REQUIREMENT[k];
/*     */       
/* 266 */       min = 0;
/* 267 */       max = 100;
/* 268 */       int[] default2 = { 10, 8, 6 };
/* 269 */       title = "Regardless Level Requirement";
/* 270 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default2[getID(k, max_id)]);
/* 271 */       property.comment = "Server Sided! " + title + " (Percentage)" + getDefault("" + min, "" + max);
/* 272 */       cCONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[k] = property.getInt();
/* 273 */       if (cCONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[k] < min) { cCONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[k] = min; }
/* 274 */       else if (cCONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[k] > max) { cCONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[k] = max; }
/* 275 */        CONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[k] = cCONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[k];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 280 */       min = -1;
/* 281 */       max = 2000000000;
/* 282 */       int[] default3 = { 50000, 25000, 25000 };
/* 283 */       title = "TP Cost";
/* 284 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default3[getID(k, max_id)]);
/* 285 */       property.comment = "Server Sided! " + title + getDefault("" + default3[getID(k, max_id)]);
/* 286 */       cCONFIG_UI_TP_COST[k] = property.getInt();
/* 287 */       if (cCONFIG_UI_TP_COST[k] < min) cCONFIG_UI_TP_COST[k] = min;
/*     */       
/* 289 */       CONFIG_UI_TP_COST[k] = cCONFIG_UI_TP_COST[k];
/*     */ 
/*     */       
/* 292 */       min = 0;
/* 293 */       max = 2000000000;
/*     */       
/* 295 */       int[] default4 = { 10, 5, 5 };
/* 296 */       title = "Mind Cost/Requirement";
/* 297 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default4[getID(k, max_id)]);
/* 298 */       property.comment = "Server Sided! " + title + getDefault("" + default4[getID(k, max_id)]);
/* 299 */       cCONFIG_UI_MIND_REQUIREMENT[k] = property.getInt();
/* 300 */       if (cCONFIG_UI_MIND_REQUIREMENT[k] < min) cCONFIG_UI_MIND_REQUIREMENT[k] = min;
/*     */       
/* 302 */       CONFIG_UI_MIND_REQUIREMENT[k] = cCONFIG_UI_MIND_REQUIREMENT[k];
/*     */       
/* 304 */       min = 0;
/* 305 */       max = 100;
/* 306 */       int[] default5 = { 60, 50, 40 };
/* 307 */       title = "Health Requirement";
/* 308 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default5[getID(k, max_id)]);
/* 309 */       property.comment = "Server Sided! " + title + " (Percentage)" + getDefault("" + min, "" + max);
/* 310 */       cCONFIG_UI_HEALTH_PERCENTAGE[k] = (byte)property.getInt();
/* 311 */       if (cCONFIG_UI_HEALTH_PERCENTAGE[k] < min) { cCONFIG_UI_HEALTH_PERCENTAGE[k] = (byte)min; }
/* 312 */       else if (cCONFIG_UI_HEALTH_PERCENTAGE[k] > max) { cCONFIG_UI_HEALTH_PERCENTAGE[k] = (byte)max; }
/* 313 */        CONFIG_UI_HEALTH_PERCENTAGE[k] = cCONFIG_UI_HEALTH_PERCENTAGE[k];
/*     */       
/* 315 */       min = 0;
/* 316 */       max = 1000;
/* 317 */       int[] default6 = { 150, 100, 75 };
/* 318 */       title = "Heat Timer";
/* 319 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default6[getID(k, max_id)]);
/* 320 */       property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 321 */       cCONFIG_UI_HEAT_DURATION[k] = property.getInt();
/* 322 */       if (cCONFIG_UI_HEAT_DURATION[k] < min) { cCONFIG_UI_HEAT_DURATION[k] = min; }
/* 323 */       else if (cCONFIG_UI_HEAT_DURATION[k] > max) { cCONFIG_UI_HEAT_DURATION[k] = max; }
/* 324 */        CONFIG_UI_HEAT_DURATION[k] = cCONFIG_UI_HEAT_DURATION[k];
/*     */       
/* 326 */       min = 0;
/* 327 */       max = 1000;
/* 328 */       int[] default7 = { 10, 15, 20 };
/* 329 */       title = "Pain Duration";
/* 330 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default7[getID(k, max_id)]);
/* 331 */       property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 332 */       cCONFIG_UI_PAIN_DURATION[k] = property.getInt();
/* 333 */       if (cCONFIG_UI_PAIN_DURATION[k] < min) { cCONFIG_UI_PAIN_DURATION[k] = min; }
/* 334 */       else if (cCONFIG_UI_PAIN_DURATION[k] > max) { cCONFIG_UI_PAIN_DURATION[k] = max; }
/* 335 */        CONFIG_UI_PAIN_DURATION[k] = cCONFIG_UI_PAIN_DURATION[k];
/*     */       
/* 337 */       boolean[] default8 = { false, false, true };
/* 338 */       title = "White Hair On";
/* 339 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default8[getID(k, max_id)]);
/* 340 */       property.comment = "Server Sided! " + title + " (This will also set whenever the form is the Complete version of Ultra Instinct)";
/* 341 */       cCONFIG_UI_HAIR_WHITE[k] = property.getBoolean();
/* 342 */       CONFIG_UI_HAIR_WHITE[k] = cCONFIG_UI_HAIR_WHITE[k];
/*     */       
/* 344 */       min = 0;
/* 345 */       max = 100000;
/* 346 */       int[] default9 = { 370, 400, 440 };
/* 347 */       title = "Attribute Multiplier";
/* 348 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default9[getID(k, max_id)]);
/* 349 */       property.comment = "Server Sided! " + title + " (Percentage)" + " Change only to your own responsibility! Having too high multiplier will cause glitches!" + getDefault("" + min, "" + max);
/* 350 */       cCONFIG_UI_ATTRIBUTE_MULTI[k] = property.getInt();
/* 351 */       if (cCONFIG_UI_ATTRIBUTE_MULTI[k] < min) { cCONFIG_UI_ATTRIBUTE_MULTI[k] = min; }
/* 352 */       else if (cCONFIG_UI_ATTRIBUTE_MULTI[k] > max) { cCONFIG_UI_ATTRIBUTE_MULTI[k] = max; }
/* 353 */        CONFIG_UI_ATTRIBUTE_MULTI[k] = cCONFIG_UI_ATTRIBUTE_MULTI[k];
/*     */       
/* 355 */       min = 0;
/* 356 */       max = 100000;
/* 357 */       String defS = "";
/* 358 */       String[] default13 = { "1.0", "1.0", "1.0", "1.0", "1.0", "0.75" };
/* 359 */       for (int m = 0; m < default13.length; m++) {
/* 360 */         default13[m] = JRMCoreH.Races[m] + " " + default13[m];
/* 361 */         defS = defS + default13[m];
/*     */       } 
/* 363 */       title = "Attribute Multiplier per Race";
/* 364 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default13);
/* 365 */       property.comment = "Server Sided! " + title + " (Percentage)" + " Change only to your own responsibility! Having too high multiplier will cause glitches!" + getDefault(defS);
/* 366 */       String[] listString = property.getStringList();
/* 367 */       for (int n = 0; n < listString.length; n++) {
/* 368 */         String[] values = listString[n].split(" ");
/* 369 */         float value = Float.parseFloat(values[1]);
/* 370 */         cCONFIG_UI_ATTRIBUTE_MULTI_RACE[k][n] = value;
/* 371 */         if (cCONFIG_UI_ATTRIBUTE_MULTI_RACE[k][n] < min) { cCONFIG_UI_ATTRIBUTE_MULTI_RACE[k][n] = min; }
/* 372 */         else if (cCONFIG_UI_ATTRIBUTE_MULTI_RACE[k][n] > max) { cCONFIG_UI_ATTRIBUTE_MULTI_RACE[k][n] = max; }
/* 373 */          CONFIG_UI_ATTRIBUTE_MULTI_RACE[k][n] = cCONFIG_UI_ATTRIBUTE_MULTI_RACE[k][n];
/*     */       } 
/*     */       
/* 376 */       min = 0;
/* 377 */       max = 1000;
/* 378 */       int[] default10 = { 0, 0, 80 };
/* 379 */       title = "Counter Attack Damage";
/* 380 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default10[getID(k, max_id)]);
/* 381 */       property.comment = "Server Sided! " + title + " (Percentage)" + getDefault("" + min, "" + max);
/* 382 */       cCONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[k] = property.getInt();
/* 383 */       if (cCONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[k] < min) { cCONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[k] = min; }
/* 384 */       else if (cCONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[k] > max) { cCONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[k] = max; }
/* 385 */        CONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[k] = cCONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[k];
/*     */       
/* 387 */       min = 0;
/* 388 */       max = 1000;
/* 389 */       int[] default11 = { 0, 0, 0 };
/* 390 */       title = "Dodge Stamina Cost";
/* 391 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default11[getID(k, max_id)]);
/* 392 */       property.comment = "Server Sided! " + title + " [IF 'Stamina Costs are Percentage On' is true then " + getDefault("" + min, "100") + " OTHERWISE " + getDefault("" + min, "" + max) + "]";
/* 393 */       cCONFIG_UI_DODGE_STAMINA_COST[k] = property.getInt();
/* 394 */       if (cCONFIG_UI_DODGE_STAMINA_COST[k] < min) cCONFIG_UI_DODGE_STAMINA_COST[k] = min;
/*     */       
/* 396 */       CONFIG_UI_DODGE_STAMINA_COST[k] = cCONFIG_UI_DODGE_STAMINA_COST[k];
/*     */       
/* 398 */       min = 0;
/* 399 */       max = 1000;
/* 400 */       int[] default12 = { 0, 0, 0 };
/* 401 */       title = "Counter Attack Stamina Cost";
/* 402 */       property = config.get(CATEGORY, "Ultra Instinct " + title, default12[getID(k, max_id)]);
/* 403 */       property.comment = "Server Sided! " + title + " [IF 'Stamina Costs are Percentage On' is true then " + getDefault("" + min, "100") + " OTHERWISE " + getDefault("" + min, "" + max) + "]";
/* 404 */       cCONFIG_UI_COUNTER_STAMINA_COST[k] = property.getInt();
/* 405 */       if (cCONFIG_UI_COUNTER_STAMINA_COST[k] < min) cCONFIG_UI_COUNTER_STAMINA_COST[k] = min;
/*     */       
/* 407 */       CONFIG_UI_COUNTER_STAMINA_COST[k] = cCONFIG_UI_COUNTER_STAMINA_COST[k];
/*     */ 
/*     */       
/* 410 */       for (int i1 = 0; i1 < 2; i1++) {
/*     */         
/* 412 */         String[][] dodge_rates = { { "10", "40" }, { "15", "60" }, { "20", "80" } };
/* 413 */         String[][] attack_rates = { { "0", "0" }, { "0", "0" }, { "10", "30" } };
/*     */         
/* 415 */         min = 0;
/* 416 */         max = 100;
/* 417 */         title = "Dodge Rate";
/* 418 */         property = config.get(CATEGORY, "Ultra Instinct " + title, dodge_rates[
/*     */ 
/*     */               
/* 421 */               getID(k, max_id)], "Server Sided! " + title + " (Percentage)" + " (Min Max)" + 
/* 422 */             getDefault("" + min, "" + max));
/* 423 */         int[] list = property.getIntList();
/* 424 */         cCONFIG_UI_DODGE_RATE[k][i1] = (byte)list[i1];
/* 425 */         if (cCONFIG_UI_DODGE_RATE[k][i1] < min) { cCONFIG_UI_DODGE_RATE[k][i1] = (byte)min; }
/* 426 */         else if (cCONFIG_UI_DODGE_RATE[k][i1] > max) { cCONFIG_UI_DODGE_RATE[k][i1] = (byte)max; }
/* 427 */          CONFIG_UI_DODGE_RATE[k][i1] = cCONFIG_UI_DODGE_RATE[k][i1];
/*     */         
/* 429 */         min = 0;
/* 430 */         max = 100;
/* 431 */         title = "Counter Attack Rate";
/* 432 */         property = config.get(CATEGORY, "Ultra Instinct " + title, attack_rates[
/*     */ 
/*     */               
/* 435 */               getID(k, max_id)], "Server Sided! " + title + " (Percentage)" + " (Min Max)" + 
/* 436 */             getDefault("" + min, "" + max));
/* 437 */         list = property.getIntList();
/* 438 */         cCONFIG_UI_ATTACK_RATE[k][i1] = (byte)list[i1];
/* 439 */         if (cCONFIG_UI_ATTACK_RATE[k][i1] < min) { cCONFIG_UI_ATTACK_RATE[k][i1] = (byte)min; }
/* 440 */         else if (cCONFIG_UI_ATTACK_RATE[k][i1] > max) { cCONFIG_UI_ATTACK_RATE[k][i1] = (byte)max; }
/* 441 */          CONFIG_UI_ATTACK_RATE[k][i1] = cCONFIG_UI_ATTACK_RATE[k][i1];
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\dbc\JGConfigUltraInstinct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */