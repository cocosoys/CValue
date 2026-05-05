/*     */ package JinRyuu.JRMCore.server.config.dbc;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ public class JGConfigDBCFormMastery
/*     */   extends JGConfigBase {
/*     */   public static final String CATEGORY_FORM_MASTERIES_SERVERSIDED = "Form Masteries";
/*  11 */   public static int DATA_ID_MAX_LEVEL = 0, DATA_ID_INSTANT_TRANSFORM_UNLOCK = 1, DATA_ID_AUTO_LEARN_ON_LEVEL = 2;
/*  12 */   public static int DATA_ID_REQUIRED_MASTERIES = 3, DATA_ID_GAIN_TO_OTHER_MASTERIES = 4;
/*  13 */   public static int DATA_ID_DAMAGE_MULTI = 5;
/*  14 */   public static int DATA_ID_GAIN_PASSIVE = 6, DATA_ID_GAIN_ATTACK = 7, DATA_ID_GAIN_DAMAGE_TAKEN = 8, DATA_ID_FIRE_KI = 9;
/*  15 */   public static int DATA_ID_COST_MULTI = 10, DATA_ID_COST_MULTI2 = 11;
/*     */   
/*  17 */   public static int DATA_ID_KI_COST_MULTI = 10, DATA_ID_ARCOSIAN_PP_COST_MULTI = 11, DATA_ID_GOD_RITUAL_TIMER_MULTI = 11, DATA_ID_GOD_RITUAL_STRAIN_COST_MULTI = 12;
/*  18 */   public static int DATA_ID_KAIOKEN_HEALTH_COST_MULTI = 10, DATA_ID_KAIOKEN_STRAIN_TEMP_MULTI = 11, DATA_ID_KAIOKEN_STRAIN_ACTIVE_MULTI = 12;
/*  19 */   public static int DATA_ID_UI_HEAT_MULTI = 10, DATA_ID_UI_PAIN_MULTI = 11, DATA_ID_UI_HEALTH_REQ_MULTI = 12;
/*  20 */   public static int DATA_ID_GOD_AURA_COST_MULTI = 10;
/*  21 */   public static int DATA_ID_MYSTIC_TIMER_MULTI = 10;
/*  22 */   public static int DATA_ID_GAIN_MULTI_DIV_PLUS = 1; public static boolean cFM_Enabled;
/*     */   public static boolean FM_Enabled;
/*     */   
/*     */   public static int getDataID_ArcosianPPCostMulti(int race, int formID) {
/*  26 */     boolean isRacial = (formID < (JRMCoreH.trans[race]).length);
/*  27 */     int formIDRace = formID - (isRacial ? (JRMCoreH.trans[race]).length : 0);
/*  28 */     if (!isRacial && formIDRace == 2) return DATA_ID_ARCOSIAN_PP_COST_MULTI + 2; 
/*  29 */     return DATA_ID_ARCOSIAN_PP_COST_MULTI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   public static int FM_Data_Separation_Per_Player = 40;
/*     */ 
/*     */   
/*  42 */   public static double FM_LevelMax = 50.0D;
/*     */   
/*  44 */   public static double FM_GainMultiDivPlus = 100.0D;
/*     */   
/*     */   public static double getMultipliedGain(double level, double gain, int gainID, int race, int formID) {
/*  47 */     double FM_GainMultiDivPlus = getDouble(race, formID, gainID, DATA_ID_GAIN_MULTI_DIV_PLUS);
/*  48 */     if (FM_GainMultiDivPlus == 0.0D || gain == 0.0D) return gain; 
/*  49 */     double lossFromLevel = level / (level + FM_GainMultiDivPlus);
/*  50 */     double multipliedGain = gain - gain * lossFromLevel;
/*  51 */     return multipliedGain;
/*     */   }
/*     */   
/*  54 */   public static double FM_InstantTransformUnlockLevel = 0.0D;
/*     */   
/*  56 */   public static String FM_AutoLearnOnLevel = "";
/*  57 */   public static String FM_RequiredMastery = "";
/*     */   
/*  59 */   public static String FM_AddGainsToOtherMastery = "";
/*  60 */   public static double FM_DamageMultiFlat = 1.0D, FM_DamageMultiPerLevel = 0.01D, FM_DamageMultiMax = 1.5D;
/*     */   
/*  62 */   public static double FM_GainPassive = 0.00375D, FM_GainDamageDealt = 0.0015D, FM_GainDamageTaken = 0.0015D, FM_GainKiFire = 0.0015D;
/*  63 */   public static double FM_GainPassiveForm = 0.01D; public static double FM_GainDamageDealtForm = 0.003D; public static double FM_GainDamageTakenForm = 0.003D; public static double FM_GainKiFireForm = 0.003D;
/*     */   public static final int FM_GainPassiveID = 0;
/*     */   public static final int FM_GainDamageDealtID = 1;
/*  66 */   public static double FM_MindGainMultiFlat = 1.0D, FM_MindGainMultiPerMind = 0.001D, FM_MindGainMultiMax = 1.5D; public static final int FM_GainDamageTakenID = 2; public static final int FM_GainKiFireID = 3;
/*     */   
/*     */   public static double getMindGainMulti(int id, int mind, int gainMultiID, int race, int formID) {
/*  69 */     int gainID = DATA_ID_GAIN_PASSIVE + gainMultiID;
/*     */ 
/*     */     
/*  72 */     double max = getDouble(race, formID, gainID, 4);
/*  73 */     if (max <= 0.0D) return max;
/*     */     
/*  75 */     double flat = getDouble(race, formID, gainID, 2);
/*  76 */     double perMind = getDouble(race, formID, gainID, 3);
/*     */     
/*  78 */     double mindGainMulti = mind * perMind + flat;
/*  79 */     if (mindGainMulti > max) mindGainMulti = max; 
/*  80 */     return mindGainMulti;
/*     */   }
/*     */   
/*  83 */   public static double FM_CostMultiFlat = 1.0D, FM_CostMultiPerLevel = -0.01D, FM_CostMultiMin = 0.5D;
/*  84 */   public static double FM_CostMultiFlat2 = 1.0D; public static double FM_CostMultiPerLevel2 = 0.01D; public static double FM_CostMultiMax2 = 1.5D;
/*     */ 
/*     */   
/*     */   public static double getCostMulti(double masteryLevel, int race, int formID, int dataID) {
/*  88 */     double FM_CostMultiFlat = getDouble(race, formID, dataID, 0);
/*  89 */     double FM_CostMultiPerLevel = getDouble(race, formID, dataID, 1);
/*  90 */     double FM_CostMultiMinMax = getDouble(race, formID, dataID, 2);
/*  91 */     double costMulti = masteryLevel * FM_CostMultiPerLevel + FM_CostMultiFlat;
/*  92 */     boolean downwards = (FM_CostMultiPerLevel < 0.0D);
/*  93 */     if (downwards ? (costMulti < FM_CostMultiMinMax) : (costMulti > FM_CostMultiMinMax)) costMulti = FM_CostMultiMinMax; 
/*  94 */     return costMulti;
/*     */   }
/*     */   
/*     */   public static double getCostMulti(double masteryLevel, int race, int formID, int dataID, boolean downwards) {
/*  98 */     double FM_CostMultiFlat = getDouble(race, formID, dataID, 0);
/*  99 */     double FM_CostMultiPerLevel = getDouble(race, formID, dataID, 1);
/* 100 */     double FM_CostMultiMinMax = getDouble(race, formID, dataID, 2);
/* 101 */     double costMulti = masteryLevel * FM_CostMultiPerLevel + FM_CostMultiFlat;
/* 102 */     if (downwards ? (costMulti < FM_CostMultiMinMax) : (costMulti > FM_CostMultiMinMax)) costMulti = FM_CostMultiMinMax; 
/* 103 */     return costMulti;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public static FormMastery[][] FormMasteries = new FormMastery[JRMCoreH.Races.length][];
/*     */   
/* 113 */   public static FormMastery[][] cFormMasteries = new FormMastery[JRMCoreH.Races.length][];
/*     */   
/*     */   public static String getString(int race, int form, int dataID, int arrayID) {
/* 116 */     if (FormMasteries.length > race && (FormMasteries[race]).length > form) {
/* 117 */       return FormMasteries[race][form].getString(dataID, arrayID);
/*     */     }
/* 119 */     return "";
/*     */   } public static String getString(int race, int form, int dataID) {
/* 121 */     return getString(race, form, dataID, 0);
/*     */   } public static double getDouble(int race, int form, int dataID, int arrayID) {
/* 123 */     if (FormMasteries.length > race && (FormMasteries[race]).length > form) {
/* 124 */       return FormMasteries[race][form].getDouble(dataID, arrayID);
/*     */     }
/* 126 */     return 0.0D;
/*     */   } public static double getDouble(int race, int form, int dataID) {
/* 128 */     return getDouble(race, form, dataID, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void initMain(Configuration config) {
/* 133 */     config.load();
/* 134 */     init_formMasteryMain(config);
/* 135 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_formMasteryMain(Configuration config) {
/* 141 */     String CATEGORY = "Form Masteries";
/*     */ 
/*     */     
/* 144 */     String server = "Server Sided!";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     String title = "Form Mastery Enabled";
/* 153 */     String desc = "(Form Mastery configs can be found in: config/jingames/dbc/races/RACE_NAME/form_mastery.cfg) (true = Enabled, false = Disabled) (Default: true)";
/* 154 */     Property property = config.get(CATEGORY, title, true);
/* 155 */     property.comment = "Server Sided! " + desc;
/* 156 */     cFM_Enabled = property.getBoolean();
/* 157 */     FM_Enabled = cFM_Enabled;
/*     */ 
/*     */ 
/*     */     
/* 161 */     int min = 1;
/* 162 */     int max = 200;
/* 163 */     int def = 40;
/* 164 */     title = "Form Mastery Data Separation Per Player";
/* 165 */     desc = "Separates the Form Mastery Server Packet when Player count is above this config's value.\nHigh numbers can cause Errors, which blocks Form Mastery from sending Data (Packets) to Clients and Small numbers can cause more lag for Sending and Receiving Form Mastery Data.\nUsing the Default value is Recommended, unless if you encounter an 'The string is too long for this encoding' server SimpleChannelHandlerWrapper exception Error!\n(From 1 to 200) (Default: " + def + ")";
/*     */ 
/*     */ 
/*     */     
/* 169 */     property = config.get(CATEGORY, title, def);
/* 170 */     property.comment = "Server Sided! " + desc;
/* 171 */     FM_Data_Separation_Per_Player = property.getInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void init(Configuration config, int race) {
/* 176 */     config.load();
/* 177 */     init_formMastery(config, race);
/* 178 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_formMastery(Configuration config, int raceID) {
/* 185 */     String percentage = " (Percentage)";
/* 186 */     String warning = " Change only to your own responsibility! Having too high multiplier will cause glitches!";
/* 187 */     String server = "Server Sided!";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     String race = JRMCoreH.Races[raceID];
/* 197 */     int racials = (JRMCoreH.trans[raceID]).length;
/* 198 */     FormMasteries[raceID] = new FormMastery[racials + JRMCoreH.transNonRacial.length];
/* 199 */     cFormMasteries[raceID] = new FormMastery[racials + JRMCoreH.transNonRacial.length];
/*     */     
/* 201 */     int formID = 0;
/* 202 */     for (String form : JRMCoreH.trans[raceID]) {
/* 203 */       FormMasteries[raceID][formID] = new FormMastery();
/* 204 */       cFormMasteries[raceID][formID] = new FormMastery();
/* 205 */       formID++;
/*     */     } 
/* 207 */     for (String form : JRMCoreH.transNonRacial) {
/* 208 */       FormMasteries[raceID][formID] = new FormMastery();
/* 209 */       cFormMasteries[raceID][formID] = new FormMastery();
/* 210 */       formID++;
/*     */     } 
/*     */     
/* 213 */     int length = (FormMasteries[raceID]).length;
/* 214 */     for (formID = 0; formID < length; formID++) {
/* 215 */       boolean isRacial = (formID < racials);
/* 216 */       String form = isRacial ? JRMCoreH.trans[raceID][formID] : JRMCoreH.transNonRacial[formID - racials];
/* 217 */       FormMastery formMastery = FormMasteries[raceID][formID];
/* 218 */       FormMastery cformMastery = cFormMasteries[raceID][formID];
/* 219 */       String CATEGORY = isRacial ? "racial" : "non_racial";
/*     */       
/* 221 */       if (!isRacial || !JRMCoreH.isRaceSaiyan(raceID) || (!form.equals(JRMCoreH.trans[raceID][12]) && !form.equals(JRMCoreH.trans[raceID][13]))) {
/*     */ 
/*     */ 
/*     */         
/* 225 */         int min = -2000000000;
/* 226 */         int max = 2000000000;
/* 227 */         int configs = 11;
/* 228 */         if (race.equals("Arcosian") && (isRacial || !form.equals("Kaioken"))) { configs++; }
/* 229 */         else if ((race.equals("Saiyan") || race.equals("Half-Saiyan")) && form.equals(JRMCoreH.trans[raceID][11])) { configs += 2; }
/* 230 */          if (form.equals("Kaioken")) { configs += 2; }
/* 231 */         else if (form.equals("UltraInstict")) { configs += 2; }
/*     */         
/* 233 */         boolean formConfig = (!form.equals("Base") && !form.equals("Mystic"));
/*     */         
/* 235 */         String[] defaultList = new String[configs];
/* 236 */         String name = "";
/* 237 */         boolean minMode = true;
/* 238 */         boolean racialKiCostMinMode = true;
/* 239 */         if (isRacial) {
/* 240 */           if (form.equals("Base"))
/* 241 */           { racialKiCostMinMode = false; }
/*     */           
/* 243 */           else if (race.equals("Arcosian"))
/* 244 */           { if (formID < 4) racialKiCostMinMode = false;
/*     */              }
/* 246 */           else if (race.equals("Majin") && 
/* 247 */             formID > 0 && formID < 4) { racialKiCostMinMode = false; }
/*     */         
/*     */         }
/*     */         int j;
/* 251 */         for (j = 0; j < defaultList.length; j++) {
/*     */           
/* 253 */           switch (j) {
/*     */             case 0:
/* 255 */               defaultList[j] = "(MaxLevel) " + FM_LevelMax;
/*     */               break;
/*     */ 
/*     */ 
/*     */             
/*     */             case 1:
/* 261 */               defaultList[j] = "(Instant_Transform_Unlock_Level) " + FM_InstantTransformUnlockLevel;
/*     */               break;
/*     */             case 2:
/* 264 */               defaultList[j] = "(Auto_Learn_On_Level) " + FM_AutoLearnOnLevel;
/*     */               break;
/*     */             case 3:
/* 267 */               defaultList[j] = "(Required_Masteries) " + FM_RequiredMastery;
/*     */               break;
/*     */             case 4:
/* 270 */               name = FM_AddGainsToOtherMastery;
/* 271 */               if (form.equals("UltraInstict") || form.equals("GodOfDestruction")) { name = "Base,1.0"; }
/* 272 */               else if (race.equals("Saiyan") || race.equals("Half-Saiyan"))
/* 273 */               { if (form.equals(JRMCoreH.trans[raceID][1])) { name = JRMCoreH.trans[raceID][4] + ",1.0"; }
/* 274 */                 else if (form.equals(JRMCoreH.trans[raceID][4])) { name = JRMCoreH.trans[raceID][1] + ",1.0"; }
/*     */                  }
/* 276 */                defaultList[j] = "(Add_Gains_To_Other_Masteries) " + name;
/*     */               break;
/*     */             
/*     */             case 5:
/* 280 */               defaultList[j] = "(Attribute_Multi_Flat) " + FM_DamageMultiFlat + " (Attribute_Multi_PerLevel) " + FM_DamageMultiPerLevel + " (Attribute_Multi_Max) " + FM_DamageMultiMax;
/*     */               break;
/*     */             case 6:
/* 283 */               defaultList[j] = "(Gain_On_Update) " + (formConfig ? FM_GainPassiveForm : FM_GainPassive) + " (Gain_Multi_Div_Plus) " + FM_GainMultiDivPlus + " (MindBonus_Flat) " + FM_MindGainMultiFlat + " (MindBonus_PerMind) " + FM_MindGainMultiPerMind + " (MindBonus_Max) " + FM_MindGainMultiMax;
/*     */               break;
/*     */             case 7:
/* 286 */               defaultList[j] = "(Gain_On_Attack) " + (formConfig ? FM_GainDamageDealtForm : FM_GainDamageDealt) + " (Gain_Multi_Div_Plus) " + FM_GainMultiDivPlus + " (MindBonus_Flat) " + FM_MindGainMultiFlat + " (MindBonus_PerMind) " + FM_MindGainMultiPerMind + " (MindBonus_Max) " + FM_MindGainMultiMax;
/*     */               break;
/*     */             case 8:
/* 289 */               defaultList[j] = "(Gain_On_Damage_Taken) " + (formConfig ? FM_GainDamageTakenForm : FM_GainDamageTaken) + " (Gain_Multi_Div_Plus) " + FM_GainMultiDivPlus + " (MindBonus_Flat) " + FM_MindGainMultiFlat + " (MindBonus_PerMind) " + FM_MindGainMultiPerMind + " (MindBonus_Max) " + FM_MindGainMultiMax;
/*     */               break;
/*     */             case 9:
/* 292 */               defaultList[j] = "(Gain_On_Fire_Ki) " + (formConfig ? FM_GainKiFireForm : FM_GainKiFire) + " (Gain_Multi_Div_Plus) " + FM_GainMultiDivPlus + " (MindBonus_Flat) " + FM_MindGainMultiFlat + " MindBonus_PerMind) " + FM_MindGainMultiPerMind + " MindBonus_Max) " + FM_MindGainMultiMax;
/*     */               break;
/*     */             case 10:
/* 295 */               if (form.equals("Kaioken")) { name = "Health_Cost_Multi_"; minMode = true; }
/* 296 */               else if (form.equals("Mystic")) { name = "Mystic_Level_Loss_Timer_Multi_"; minMode = false; }
/* 297 */               else if (form.equals("UltraInstict")) { name = "Heat_Gain_Multi_"; minMode = true; }
/* 298 */               else if (form.equals("GodOfDestruction")) { name = "Destroyer_Aura_Ki_Cost_Multi_"; minMode = true; }
/* 299 */               else { name = "Ki_Cost_Multi_"; minMode = racialKiCostMinMode; }
/*     */               
/* 301 */               defaultList[j] = "(" + name + "Flat) " + (minMode ? FM_CostMultiFlat : FM_CostMultiFlat2) + " (" + name + "PerLevel) " + (minMode ? FM_CostMultiPerLevel : FM_CostMultiPerLevel2) + " (" + name + "MinOrMax" + ") " + (minMode ? FM_CostMultiMin : FM_CostMultiMax2);
/*     */               break;
/*     */ 
/*     */             
/*     */             case 11:
/* 306 */               if ((race.equals("Saiyan") || race.equals("Half-Saiyan")) && form.equals(JRMCoreH.trans[raceID][11])) { name = "Timer_Multi_"; minMode = false; }
/* 307 */               else if (form.equals("Kaioken")) { name = "Strain_Timer_Temporary_Multi_"; minMode = true; }
/* 308 */               else if (form.equals("UltraInstict")) { name = "Pain_Timer_Multi_"; minMode = true; }
/* 309 */               else if (race.equals("Arcosian")) { name = "Power_Point_Cost_Multi_"; minMode = true; }
/* 310 */               else { name = "Ki_Cost_Multi_"; minMode = racialKiCostMinMode; }
/*     */               
/* 312 */               defaultList[j] = "(" + name + "Flat) " + (minMode ? FM_CostMultiFlat : FM_CostMultiFlat2) + " (" + name + "PerLevel) " + (minMode ? FM_CostMultiPerLevel : FM_CostMultiPerLevel2) + " (" + name + "MinOrMax" + ") " + (minMode ? FM_CostMultiMin : FM_CostMultiMax2);
/*     */               break;
/*     */ 
/*     */ 
/*     */             
/*     */             case 12:
/* 318 */               if ((race.equals("Saiyan") || race.equals("Half-Saiyan")) && form.equals(JRMCoreH.trans[raceID][11])) { name = "Strain_Timer_Multi_"; minMode = true; }
/* 319 */               else if (form.equals("Kaioken")) { name = "Strain_Timer_Active_Multi_"; minMode = false; }
/* 320 */               else if (form.equals("UltraInstict")) { name = "Health_Requirement_Multi_"; minMode = false; }
/* 321 */               else { name = "Ki_Cost_Multi_"; minMode = racialKiCostMinMode; }
/*     */               
/* 323 */               defaultList[j] = "(" + name + "Flat) " + (minMode ? FM_CostMultiFlat : FM_CostMultiFlat2) + " (" + name + "PerLevel) " + (minMode ? FM_CostMultiPerLevel : FM_CostMultiPerLevel2) + " (" + name + "MinOrMax" + ") " + (minMode ? FM_CostMultiMin : FM_CostMultiMax2);
/*     */               break;
/*     */ 
/*     */ 
/*     */             
/*     */             case 13:
/* 329 */               if (form.equals("Kaioken") && race.equals("Arcosian")) { name = "Power_Point_Cost_Multi_"; minMode = true; }
/* 330 */               else if (form.equals("UltraInstict") && race.equals("Arcosian")) { name = "Power_Point_Cost_Multi_"; minMode = true; }
/* 331 */               else { name = "Ki_Cost_Multi_"; minMode = racialKiCostMinMode; }
/*     */               
/* 333 */               defaultList[j] = "(" + name + "Flat) " + (minMode ? FM_CostMultiFlat : FM_CostMultiFlat2) + " (" + name + "PerLevel) " + (minMode ? FM_CostMultiPerLevel : FM_CostMultiPerLevel2) + " (" + name + "MinOrMax" + ") " + (minMode ? FM_CostMultiMin : FM_CostMultiMax2);
/*     */               break;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         } 
/* 341 */         String title = form;
/* 342 */         String desc = "Values for the Form's Mastery:";
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
/* 356 */         Property property = config.get(CATEGORY, title, defaultList, "Server Sided! " + desc);
/* 357 */         String[] list = property.getStringList();
/* 358 */         for (j = 0; j < list.length; j++) {
/*     */           
/* 360 */           String line = list[j];
/* 361 */           if (line == null || line.length() == 0) {
/* 362 */             line = defaultList[j];
/*     */           }
/*     */           
/* 365 */           boolean isString = (j == DATA_ID_AUTO_LEARN_ON_LEVEL || j == DATA_ID_REQUIRED_MASTERIES || j == DATA_ID_GAIN_TO_OTHER_MASTERIES);
/*     */           
/* 367 */           String[] arrayOfString = line.split(" ");
/* 368 */           if (isString) {
/* 369 */             formMastery.addData(new Object[] { (arrayOfString.length > 1) ? arrayOfString[1] : null });
/*     */           } else {
/*     */             
/* 372 */             int valueCount = 0;
/* 373 */             for (int k = 1; k < arrayOfString.length; ) { valueCount++; k += 2; }
/* 374 */              String[] arrayOfString1 = new String[valueCount];
/* 375 */             valueCount = 0;
/* 376 */             for (int i = 1; i < arrayOfString.length; i += 2) {
/* 377 */               double value = Double.parseDouble(arrayOfString[i]);
/*     */               
/* 379 */               if (value < min) { value = min; }
/* 380 */               else if (value > max) { value = max; }
/* 381 */                arrayOfString1[valueCount] = value + "";
/* 382 */               valueCount++;
/*     */             } 
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
/* 394 */             if (j == DATA_ID_DAMAGE_MULTI) {
/* 395 */               String[] arrayOfString2 = new String[valueCount];
/* 396 */               valueCount = 0;
/* 397 */               for (String o : arrayOfString1) {
/* 398 */                 arrayOfString2[valueCount] = o;
/* 399 */                 valueCount++;
/*     */               } 
/* 401 */               cformMastery.addData((Object[])arrayOfString2);
/*     */             } 
/* 403 */             formMastery.addData((Object[])arrayOfString1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\dbc\JGConfigDBCFormMastery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */