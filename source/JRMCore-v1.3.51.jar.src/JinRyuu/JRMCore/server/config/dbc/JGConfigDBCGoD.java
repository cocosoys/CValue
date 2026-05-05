/*     */ package JinRyuu.JRMCore.server.config.dbc;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGConfigDBCGoD
/*     */   extends JGConfigBase
/*     */ {
/*     */   public static final String CATEGORY_FORM_GOD_SERVERSIDED = "God of Destruction";
/*     */   public static final int FLAT_COST = 0;
/*     */   public static final int PERCENTAGE_COST = 1;
/*     */   public static boolean CONFIG_GOD_ENABLED;
/*     */   public static float CONFIG_GOD_ATTRIBUTE_MULTI;
/*     */   public static int CONFIG_GOD_TP_COST;
/*     */   public static int CONFIG_GOD_MIND_REQUIREMENT;
/*     */   public static int CONFIG_GOD_MAX_ALIGNMENT;
/*     */   public static int CONFIG_GOD_LEVEL_REQUIREMENT;
/*     */   public static int CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT;
/*     */   public static boolean CONFIG_GOD_IGNORE_BASE_CONFIG;
/*     */   public static boolean CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG;
/*     */   public static String[] CONFIG_GOD_IGNORED_DAMAGE_SOURCES;
/*     */   public static String[] CONFIG_GOD_IGNORED_ENTITIES;
/*     */   public static float CONFIG_GOD_IGNORE_DAMAGE_MULTI;
/*     */   public static boolean CONFIG_GOD_IGNORE_PROJECTILES_ENABLED;
/*     */   public static boolean CONFIG_GOD_AURA_ENABLED;
/*     */   public static boolean CONFIG_GOD_AURA_ENABLED_WITH_AURA;
/*  32 */   public static float[] CONFIG_GOD_AURA_KI_COST = new float[2];
/*     */   
/*     */   public static boolean CONFIG_GOD_ENERGY_ENABLED;
/*     */   public static float CONFIG_GOD_ENERGY_DAMAGE_MULTI;
/*  36 */   public static float[] CONFIG_GOD_ATTRIBUTE_MULTI_RACE = new float[JRMCoreH.Races.length];
/*     */   
/*     */   public static boolean cCONFIG_GOD_ENABLED;
/*     */   
/*     */   public static float cCONFIG_GOD_ATTRIBUTE_MULTI;
/*     */   
/*     */   public static int cCONFIG_GOD_TP_COST;
/*     */   
/*     */   public static int cCONFIG_GOD_MIND_REQUIREMENT;
/*     */   
/*     */   public static boolean cCONFIG_GOD_IGNORE_BASE_CONFIG;
/*     */   
/*     */   public static String[] cCONFIG_GOD_IGNORED_DAMAGE_SOURCES;
/*     */   
/*     */   public static String[] cCONFIG_GOD_IGNORED_ENTITIES;
/*     */   
/*     */   public static float cCONFIG_GOD_IGNORE_DAMAGE_MULTI;
/*     */   
/*     */   public static boolean cCONFIG_GOD_IGNORE_PROJECTILES_ENABLED;
/*     */   
/*     */   public static boolean cCONFIG_GOD_AURA_ENABLED;
/*     */   
/*     */   public static boolean cCONFIG_GOD_AURA_ENABLED_WITH_AURA;
/*     */   
/*     */   public static boolean cCONFIG_GOD_ENERGY_ENABLED;
/*     */   
/*     */   public static float cCONFIG_GOD_ENERGY_DAMAGE_MULTI;
/*  63 */   public static float[] cCONFIG_GOD_ATTRIBUTE_MULTI_RACE = new float[JRMCoreH.Races.length];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init(Configuration config) {
/*  69 */     config.load();
/*  70 */     init_god(config);
/*  71 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_god(Configuration config) {
/*  77 */     String form = "God of Destruction";
/*  78 */     String CATEGORY = "God of Destruction";
/*  79 */     String percentage = " (Percentage)";
/*  80 */     String warning = " Change only to your own responsibility! Having too high multiplier will cause glitches!";
/*  81 */     String server = "Server Sided!";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     int min = 0;
/*  90 */     int max = 100000;
/*  91 */     String title = "Attribute Multiplier";
/*  92 */     String desc = title + " Change only to your own responsibility! Having too high multiplier will cause glitches!" + getDefault2("" + min, "" + max) + getDefaultValue2("3.8");
/*  93 */     Property property = config.get(CATEGORY, "God of Destruction " + title, 3.8D);
/*  94 */     property.comment = "Server Sided! " + desc;
/*  95 */     cCONFIG_GOD_ATTRIBUTE_MULTI = (float)property.getDouble();
/*  96 */     if (cCONFIG_GOD_ATTRIBUTE_MULTI < min) { cCONFIG_GOD_ATTRIBUTE_MULTI = min; }
/*  97 */     else if (cCONFIG_GOD_ATTRIBUTE_MULTI > max) { cCONFIG_GOD_ATTRIBUTE_MULTI = max; }
/*  98 */      CONFIG_GOD_ATTRIBUTE_MULTI = cCONFIG_GOD_ATTRIBUTE_MULTI;
/*     */     
/* 100 */     min = 0;
/* 101 */     max = 100000;
/* 102 */     String defS = "";
/* 103 */     String[] defaultList = { "1.0", "1.0", "1.0", "1.0", "1.0", "0.75" };
/* 104 */     for (int j = 0; j < defaultList.length; j++) {
/* 105 */       defaultList[j] = JRMCoreH.Races[j] + " " + defaultList[j];
/* 106 */       defS = defS + defaultList[j];
/*     */     } 
/* 108 */     title = "Attribute Multiplier per Race";
/* 109 */     desc = title + " Change only to your own responsibility! Having too high multiplier will cause glitches!" + getDefault2("" + min, "" + max) + getDefaultValue2(defS);
/* 110 */     property = config.get(CATEGORY, "God of Destruction " + title, defaultList);
/* 111 */     property.comment = "Server Sided! " + desc;
/* 112 */     String[] listString = property.getStringList();
/* 113 */     for (int k = 0; k < listString.length; k++) {
/* 114 */       String[] values = listString[k].split(" ");
/* 115 */       float value = Float.parseFloat(values[1]);
/* 116 */       cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[k] = value;
/* 117 */       if (cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[k] < min) { cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[k] = min; }
/* 118 */       else if (cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[k] > max) { cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[k] = max; }
/* 119 */        CONFIG_GOD_ATTRIBUTE_MULTI_RACE[k] = cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[k];
/*     */     } 
/*     */     
/* 122 */     min = -1;
/* 123 */     max = 2000000000;
/* 124 */     title = "TP Cost";
/* 125 */     desc = title + getDefault("" + min, "" + max) + getDefaultValue2("50000");
/* 126 */     property = config.get(CATEGORY, "God of Destruction " + title, 50000);
/* 127 */     property.comment = "Server Sided! " + desc;
/* 128 */     cCONFIG_GOD_TP_COST = property.getInt();
/* 129 */     if (cCONFIG_GOD_TP_COST < min) { cCONFIG_GOD_TP_COST = min; }
/* 130 */     else if (cCONFIG_GOD_TP_COST > max) { cCONFIG_GOD_TP_COST = max; }
/* 131 */      CONFIG_GOD_TP_COST = cCONFIG_GOD_TP_COST;
/*     */     
/* 133 */     min = 0;
/* 134 */     max = 2000000000;
/* 135 */     title = "Mind Cost/Requirement";
/* 136 */     desc = title + getDefault("" + min, "" + max) + getDefaultValue2("10");
/* 137 */     property = config.get(CATEGORY, "God of Destruction " + title, 10);
/* 138 */     property.comment = "Server Sided! " + desc;
/* 139 */     cCONFIG_GOD_MIND_REQUIREMENT = property.getInt();
/* 140 */     if (cCONFIG_GOD_MIND_REQUIREMENT < min) { cCONFIG_GOD_MIND_REQUIREMENT = min; }
/* 141 */     else if (cCONFIG_GOD_MIND_REQUIREMENT > max) { cCONFIG_GOD_MIND_REQUIREMENT = max; }
/* 142 */      CONFIG_GOD_MIND_REQUIREMENT = cCONFIG_GOD_MIND_REQUIREMENT;
/*     */ 
/*     */     
/* 145 */     min = 0;
/* 146 */     max = 1000000;
/* 147 */     title = "Level Requirement";
/* 148 */     desc = title + getDefault("" + min, "" + max) + getDefaultValue2("200");
/* 149 */     property = config.get(CATEGORY, "God of Destruction " + title, 200);
/* 150 */     property.comment = "Server Sided! " + desc;
/* 151 */     CONFIG_GOD_LEVEL_REQUIREMENT = property.getInt();
/* 152 */     if (CONFIG_GOD_LEVEL_REQUIREMENT < min) { CONFIG_GOD_LEVEL_REQUIREMENT = min; }
/* 153 */     else if (CONFIG_GOD_LEVEL_REQUIREMENT > max) { CONFIG_GOD_LEVEL_REQUIREMENT = max; }
/*     */ 
/*     */ 
/*     */     
/* 157 */     min = 0;
/* 158 */     max = 100;
/* 159 */     title = "Regardless Level Requirement";
/* 160 */     desc = title + getDefault("" + min, "" + max) + getDefaultValue2("10");
/* 161 */     property = config.get(CATEGORY, "God of Destruction " + title, 10);
/* 162 */     property.comment = "Server Sided! " + desc;
/* 163 */     CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT = property.getInt();
/* 164 */     if (CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT < min) { CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT = min; }
/* 165 */     else if (CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT > max) { CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT = max; }
/*     */ 
/*     */ 
/*     */     
/* 169 */     title = "Ignore Base Attribute Multiplier Config while in GoD Enabled";
/* 170 */     desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
/* 171 */     property = config.get(CATEGORY, "God of Destruction " + title, true);
/* 172 */     property.comment = "Server Sided! " + desc;
/* 173 */     cCONFIG_GOD_IGNORE_BASE_CONFIG = property.getBoolean();
/* 174 */     CONFIG_GOD_IGNORE_BASE_CONFIG = cCONFIG_GOD_IGNORE_BASE_CONFIG;
/*     */ 
/*     */     
/* 177 */     title = "Ignore Base Ki Regen Config Multiplier while in GoD Enabled";
/* 178 */     desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
/* 179 */     property = config.get(CATEGORY, "God of Destruction " + title, true);
/* 180 */     property.comment = "Server Sided! " + desc;
/* 181 */     CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG = property.getBoolean();
/*     */ 
/*     */ 
/*     */     
/* 185 */     defaultList = new String[] { "" };
/* 186 */     title = "Can Ignore these Damage Source Damages";
/* 187 */     desc = "List of Damage Source names which this form can ignore.";
/* 188 */     property = config.get(CATEGORY, "God of Destruction " + title, defaultList);
/* 189 */     property.comment = "Server Sided! " + desc;
/* 190 */     String[] list = property.getStringList();
/* 191 */     cCONFIG_GOD_IGNORED_DAMAGE_SOURCES = new String[list.length];
/* 192 */     CONFIG_GOD_IGNORED_DAMAGE_SOURCES = new String[list.length]; int i;
/* 193 */     for (i = 0; i < list.length; i++) {
/*     */       
/* 195 */       cCONFIG_GOD_IGNORED_DAMAGE_SOURCES[i] = list[i];
/* 196 */       CONFIG_GOD_IGNORED_DAMAGE_SOURCES[i] = list[i];
/*     */     } 
/*     */ 
/*     */     
/* 200 */     defaultList = new String[] { "" };
/* 201 */     title = "Can Ignore these Entity Damages";
/* 202 */     desc = "List of Entity names which this form can ignore.";
/* 203 */     property = config.get(CATEGORY, "God of Destruction " + title, defaultList);
/* 204 */     property.comment = "Server Sided! " + desc;
/* 205 */     list = property.getStringList();
/* 206 */     cCONFIG_GOD_IGNORED_ENTITIES = new String[list.length];
/* 207 */     CONFIG_GOD_IGNORED_ENTITIES = new String[list.length];
/* 208 */     for (i = 0; i < list.length; i++) {
/*     */       
/* 210 */       cCONFIG_GOD_IGNORED_ENTITIES[i] = list[i];
/* 211 */       CONFIG_GOD_IGNORED_ENTITIES[i] = list[i];
/*     */     } 
/*     */ 
/*     */     
/* 215 */     min = 0;
/* 216 */     max = 100000;
/* 217 */     title = "Ignore Damage Multiplier";
/*     */ 
/*     */     
/* 220 */     desc = "In Destroyer Aura Mode when a GoD form user is attacked then they can completely negate the damage dealt to them IF their melee attack multiplied by this value is stronger than the received damage" + getDefault("" + min, "" + max) + getDefaultValue2("0.8");
/* 221 */     property = config.get(CATEGORY, "God of Destruction " + title, 0.8D);
/* 222 */     property.comment = "Server Sided! " + desc;
/* 223 */     cCONFIG_GOD_IGNORE_DAMAGE_MULTI = (float)property.getDouble();
/* 224 */     if (cCONFIG_GOD_IGNORE_DAMAGE_MULTI < min) { cCONFIG_GOD_IGNORE_DAMAGE_MULTI = min; }
/* 225 */     else if (cCONFIG_GOD_IGNORE_DAMAGE_MULTI > max) { cCONFIG_GOD_IGNORE_DAMAGE_MULTI = max; }
/* 226 */      CONFIG_GOD_IGNORE_DAMAGE_MULTI = cCONFIG_GOD_IGNORE_DAMAGE_MULTI;
/*     */ 
/*     */     
/* 229 */     title = "Ignore Projectile Entity Damages Enabled";
/* 230 */     desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
/* 231 */     property = config.get(CATEGORY, "God of Destruction " + title, true);
/* 232 */     property.comment = "Server Sided! " + desc;
/* 233 */     cCONFIG_GOD_IGNORE_PROJECTILES_ENABLED = property.getBoolean();
/* 234 */     CONFIG_GOD_IGNORE_PROJECTILES_ENABLED = cCONFIG_GOD_IGNORE_PROJECTILES_ENABLED;
/*     */ 
/*     */     
/* 237 */     title = "Form Enabled";
/* 238 */     desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
/* 239 */     property = config.get(CATEGORY, "God of Destruction " + title, true);
/* 240 */     property.comment = "Server Sided! " + desc;
/* 241 */     cCONFIG_GOD_ENABLED = property.getBoolean();
/* 242 */     CONFIG_GOD_ENABLED = cCONFIG_GOD_ENABLED;
/*     */ 
/*     */     
/* 245 */     title = "Destroyer Aura Enabled";
/* 246 */     desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
/* 247 */     property = config.get(CATEGORY, "God of Destruction " + title, true);
/* 248 */     property.comment = "Server Sided! " + desc;
/* 249 */     cCONFIG_GOD_AURA_ENABLED = property.getBoolean();
/* 250 */     CONFIG_GOD_AURA_ENABLED = cCONFIG_GOD_AURA_ENABLED;
/*     */ 
/*     */     
/* 253 */     title = "Destroyer Aura Only in Turbo Mode Enabled";
/* 254 */     desc = "Destroyer Aura is ONLY enabled in Turbo Aura Mode. (true = Enabled, false = Disabled)" + getDefaultValue2("true");
/* 255 */     property = config.get(CATEGORY, "God of Destruction " + title, true);
/* 256 */     property.comment = "Server Sided! " + desc;
/* 257 */     cCONFIG_GOD_AURA_ENABLED_WITH_AURA = property.getBoolean();
/* 258 */     CONFIG_GOD_AURA_ENABLED_WITH_AURA = cCONFIG_GOD_AURA_ENABLED_WITH_AURA;
/*     */ 
/*     */     
/* 261 */     title = "Destroyer Energy Enabled";
/* 262 */     desc = "All Custom Ki Attacks are converted to Destroyer Attacks. (true = Enabled, false = Disabled)" + getDefaultValue2("true");
/* 263 */     property = config.get(CATEGORY, "God of Destruction " + title, true);
/* 264 */     property.comment = "Server Sided! " + desc;
/* 265 */     cCONFIG_GOD_ENERGY_ENABLED = property.getBoolean();
/* 266 */     CONFIG_GOD_ENERGY_ENABLED = cCONFIG_GOD_ENERGY_ENABLED;
/*     */ 
/*     */     
/* 269 */     min = 0;
/* 270 */     max = 100000;
/* 271 */     title = "Destroyer Energy Damage Multiplier";
/*     */ 
/*     */     
/* 274 */     desc = "When a Destroyer Ki Attack hits another Ki Attack then it instantly destroy the other one IF their damage multiplied by this value is stronger than the received damage" + getDefault("" + min, "" + max) + getDefaultValue2("0.8");
/* 275 */     property = config.get(CATEGORY, "God of Destruction " + title, 0.8D);
/* 276 */     property.comment = "Server Sided! " + desc;
/* 277 */     cCONFIG_GOD_ENERGY_DAMAGE_MULTI = (float)property.getDouble();
/* 278 */     if (cCONFIG_GOD_ENERGY_DAMAGE_MULTI < min) { cCONFIG_GOD_ENERGY_DAMAGE_MULTI = min; }
/* 279 */     else if (cCONFIG_GOD_ENERGY_DAMAGE_MULTI > max) { cCONFIG_GOD_ENERGY_DAMAGE_MULTI = max; }
/* 280 */      CONFIG_GOD_ENERGY_DAMAGE_MULTI = cCONFIG_GOD_ENERGY_DAMAGE_MULTI;
/*     */ 
/*     */     
/* 283 */     min = 0;
/* 284 */     max = 100;
/* 285 */     title = "Max Alignment Limit";
/*     */     
/* 287 */     desc = "Using the Form above this Alignment value is not possible" + getDefault("" + min, "" + max) + getDefaultValue2("80");
/* 288 */     property = config.get(CATEGORY, "God of Destruction " + title, 80);
/* 289 */     property.comment = "Server Sided! " + desc;
/* 290 */     CONFIG_GOD_MAX_ALIGNMENT = property.getInt();
/* 291 */     if (CONFIG_GOD_MAX_ALIGNMENT < min) { CONFIG_GOD_MAX_ALIGNMENT = min; }
/* 292 */     else if (CONFIG_GOD_MAX_ALIGNMENT > max) { CONFIG_GOD_MAX_ALIGNMENT = max; }
/*     */ 
/*     */     
/* 295 */     min = 0;
/* 296 */     max = 1000000000;
/* 297 */     title = "Destroyer Aura Ki Cost";
/*     */     
/* 299 */     desc = "Aura Cost per Server update. (FlatCost PercentageCost)" + getDefault("" + min, "" + max) + getDefaultValue2("10 0.0025");
/* 300 */     property = config.get(CATEGORY, "God of Destruction " + title, "10 0.0025");
/* 301 */     property.comment = "Server Sided! " + desc;
/* 302 */     defaultList = property.getString().split(" ");
/* 303 */     for (i = 0; i < defaultList.length; i++) {
/* 304 */       float value = Float.parseFloat(defaultList[i]);
/* 305 */       CONFIG_GOD_AURA_KI_COST[i] = value;
/* 306 */       if (CONFIG_GOD_AURA_KI_COST[i] < min) { CONFIG_GOD_AURA_KI_COST[i] = min; }
/* 307 */       else if (CONFIG_GOD_AURA_KI_COST[i] > max) { CONFIG_GOD_AURA_KI_COST[i] = max; }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\dbc\JGConfigDBCGoD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */