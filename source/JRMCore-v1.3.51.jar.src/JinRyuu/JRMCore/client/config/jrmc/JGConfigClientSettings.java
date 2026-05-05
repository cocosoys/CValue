/*     */ package JinRyuu.JRMCore.client.config.jrmc;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.notification.JGNotificationGUI;
/*     */ import JinRyuu.JRMCore.client.notification.JGNotificationHandler;
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
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
/*     */ public class JGConfigClientSettings
/*     */   extends JGConfigBase
/*     */ {
/*     */   public static final String CATEGORY_NAME_CLIENTSIDED = "Client Settings";
/*     */   public static final String CATEGORY_NAME_NOTIFICATIONS = "Notifications";
/*     */   public static final String CLIENT_hud2_3 = "0,0,154,55,0,background,;45,12,104,8,0,0,55,12,2,health,30,150,30,#amount/#max,;49,23,85,11,1,0,55,25,2,energy,0,0,0,#amount/#max,;44,37,59,7,0,0,50,35,2,stamina,255,200,0,#empty,;1,8,10,39,0,2,0,22,2,transform,255,0,255,#empty,;6,6,43,43,0,2,21,22,2,release,255,0,0,#amount,;50,50,2,0,150,50,50,;75,0,2,25,150,255,;";
/*     */   public static boolean configsChanged = false;
/*     */   public static boolean tipNotificationsOn = true;
/*     */   public static boolean errorNotificationsOn = true;
/*     */   public static int CLIENT_hud0x;
/*     */   public static int CLIENT_hud0y;
/*     */   public static int CLIENT_hud0;
/*     */   public static int CLIENT_lockon;
/*     */   public static int CLIENT_hud1x;
/*     */   public static int CLIENT_hud1y;
/*     */   public static int CLIENT_hud1;
/*     */   public static boolean CLIENT_GR0 = true;
/*     */   public static boolean CLIENT_GR1 = true;
/*     */   public static boolean CLIENT_GR2 = true;
/*     */   public static boolean CLIENT_GR3 = true;
/*     */   public static boolean CLIENT_GR4 = true;
/*     */   public static boolean CLIENT_GR5 = false;
/*     */   public static boolean CLIENT_GR6 = false;
/*     */   public static boolean CLIENT_GR7 = false;
/*     */   public static boolean CLIENT_GR8 = false;
/*     */   public static boolean CLIENT_GR9 = false;
/*     */   public static boolean CLIENT_GR10 = false;
/*     */   public static boolean CLIENT_GR11 = false;
/*     */   public static boolean CLIENT_GR12 = false;
/*     */   public static boolean CLIENT_GR13 = false;
/*     */   public static int CLIENT_DA1;
/*     */   public static int CLIENT_DA2;
/*     */   
/*     */   public static int get_da1() {
/*  80 */     return 1 + CLIENT_DA1;
/*     */   }
/*     */   public static float get_da2() {
/*  83 */     return 1.0F + CLIENT_DA2 * 0.01F;
/*     */   }
/*     */   
/*  86 */   public static int CLIENT_DA3 = 2;
/*     */   
/*     */   public static boolean CLIENT_DA4 = true;
/*     */   
/*     */   public static boolean CLIENT_DA5 = true;
/*     */   
/*     */   public static boolean CLIENT_DA6 = true;
/*     */   
/*     */   public static boolean CLIENT_DA7 = true;
/*     */   
/*     */   public static boolean CLIENT_DA8 = true;
/*     */   
/*     */   public static boolean CLIENT_DA9 = true;
/*     */   
/*     */   public static boolean CLIENT_DA10 = true;
/*     */   
/*     */   public static boolean CLIENT_DA11 = false;
/*     */   
/*     */   public static boolean CLIENT_DA12 = true;
/*     */   
/*     */   public static boolean CLIENT_DA13 = true;
/*     */   
/*     */   public static boolean CLIENT_DA14 = true;
/*     */   
/*     */   public static boolean CLIENT_DA15 = true;
/*     */   
/*     */   public static boolean CLIENT_DA16 = true;
/*     */   
/*     */   public static boolean CLIENT_hud2 = false;
/*     */   
/* 116 */   public static String CLIENT_hud2_2 = "0,0,154,55,0,background,;45,12,104,8,0,0,55,12,2,health,30,150,30,#amount/#max,;49,23,85,11,1,0,55,25,2,energy,0,0,0,#amount/#max,;44,37,59,7,0,0,50,35,2,stamina,255,200,0,#empty,;1,8,10,39,0,2,0,22,2,transform,255,0,255,#empty,;6,6,43,43,0,2,21,22,2,release,255,0,0,#amount,;50,50,2,0,150,50,50,;75,0,2,25,150,255,;";
/*     */   
/*     */   public static boolean CLIENT_DA17 = false;
/*     */   
/*     */   public static boolean CLIENT_DA18 = false;
/*     */   
/*     */   public static boolean CLIENT_DA19 = true;
/*     */   
/*     */   public static boolean CLIENT_DA20 = true;
/*     */   
/* 126 */   public static int CLIENT_DA21 = 10;
/*     */   
/*     */   public static boolean CLIENT_DA22 = true;
/* 129 */   public static byte CLIENT_Ki_Visibility = 10;
/* 130 */   public static int CLIENT_Ki_Scale = 10;
/* 131 */   public static byte CLIENT_Ki_Charge_Visibility = 10;
/* 132 */   public static int CLIENT_Ki_Charge_Scale = 10;
/* 133 */   public static byte CLIENT_Jutsu_Visibility = 10;
/* 134 */   public static int CLIENT_Jutsu_Scale = 10;
/* 135 */   public static boolean[] CLIENT_Ki_3d = new boolean[9];
/* 136 */   public static boolean[] CLIENT_Ki_Charge_3d = new boolean[9];
/* 137 */   public static boolean[] CLIENT_Jutsu_3d = new boolean[3];
/*     */ 
/*     */   
/*     */   public static boolean renderEnergyOutsideView = true;
/*     */   
/* 142 */   public static int addMore = 1;
/*     */   
/*     */   public static boolean concentrationAnimatedTexturesOn = true;
/*     */   
/*     */   public static boolean concentrationAnimatedColorOn = true;
/*     */   public static boolean airboxing3DCharacterOn = true;
/*     */   public static boolean airboxing3DAuraOn = true;
/*     */   public static boolean airboxingAnimatedColorOn = true;
/* 150 */   public static int renderdistanceMultiplierBarrierBlock = 1; public static int renderdistanceMultiplierParticles = 1; public static int renderdistanceMultiplierKiAttackCharge = 1; public static int renderdistanceMultiplierAuras = 1;
/*     */ 
/*     */   
/*     */   public static boolean kiAttackChargePercentageOn = true;
/*     */ 
/*     */   
/*     */   public static boolean dbcFastFusionSpectatorCameraFollowOn = true;
/*     */   
/*     */   public static boolean safeZoneUIModeOn = true;
/*     */   
/*     */   public static boolean instantTransmissionParticles = true;
/*     */   
/*     */   public static boolean instantTransmissionFirstPerson = true;
/*     */ 
/*     */   
/*     */   public static void init(Configuration config) {
/* 166 */     config.load();
/*     */     
/* 168 */     init_client(config, true, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initNotifications(Configuration config) {
/* 174 */     config.load();
/* 175 */     init_notifications(config, true, false);
/*     */   }
/*     */ 
/*     */   
/* 179 */   public static final short[] BENS_CONFIG_HUD_SIZES_X = new short[] { 182, 242, 143 };
/* 180 */   public static final short[] BENS_CONFIG_HUD_SIZES_Y = new short[] { 10, 25, 16 };
/* 181 */   public static final short[] BENS_CONFIG_HUD_SIZES_POS = new short[] { 0, 30, 105 };
/* 182 */   public static final short[] BENS_CONFIG_HUD_SIZES_extra_POS_X = new short[] { 0, 0, 51 };
/* 183 */   public static final short[] BENS_CONFIG_HUD_SIZES_extra_POS_Y = new short[] { 0, 0, 36 };
/* 184 */   public static final short[] BENS_CONFIG_HUD_SIZES_extra_height = new short[] { 0, 0, 50 };
/*     */   public static final short BENS_CONFIG_HUD_LOCKON = 6;
/* 186 */   public static final short[] BENS_CONFIG_HUD_1_SIZES_POS = new short[] { 0, 33, 78, 117 };
/* 187 */   public static final short[] BENS_CONFIG_HUD_1_SIZES_POS_STAM = new short[] { 17, 56, 98, 137 };
/* 188 */   public static final short[] BENS_CONFIG_HUD_1_SIZES_HEALTH_WIDTH = new short[] { 6, 7, 6, 6 };
/* 189 */   public static final short[] BENS_CONFIG_HUD_1_SIZES_STAMINA_WIDTH = new short[] { 4, 6, 5, 5 };
/* 190 */   public static final short[] BENS_CONFIG_HUD_1_SIZES_X = new short[] { 41, 133, 105, 105 };
/* 191 */   public static final short[] BENS_CONFIG_HUD_1_SIZES_Y = new short[] { 11, 15, 13, 13 };
/*     */   
/*     */   public static short get_hud_x() {
/* 194 */     return BENS_CONFIG_HUD_SIZES_X[CLIENT_hud0];
/*     */   }
/*     */   
/*     */   public static int get_hud_start_x() {
/* 198 */     return BENS_CONFIG_HUD_SIZES_extra_POS_X[CLIENT_hud0];
/*     */   }
/*     */   
/*     */   public static int get_hud_start_y() {
/* 202 */     return BENS_CONFIG_HUD_SIZES_extra_POS_Y[CLIENT_hud0];
/*     */   }
/*     */   
/*     */   public static int get_hud_height(int i) {
/* 206 */     int id = BENS_CONFIG_HUD_SIZES_extra_height[CLIENT_hud0] * i;
/* 207 */     return id;
/*     */   }
/*     */   
/*     */   public static int get_hud_y() {
/* 211 */     return BENS_CONFIG_HUD_SIZES_Y[CLIENT_hud0];
/*     */   }
/*     */   
/*     */   public static int get_hud_pos(int i) {
/* 215 */     int id = i * BENS_CONFIG_HUD_SIZES_Y[CLIENT_hud0];
/* 216 */     return BENS_CONFIG_HUD_SIZES_POS[CLIENT_hud0] + id;
/*     */   }
/*     */   
/* 219 */   public static int get_hud_lockon() { return CLIENT_lockon + 1; }
/* 220 */   public static void hud_lockon_add() { if (CLIENT_lockon + 1 < 6) CLIENT_lockon++;  } public static void hud_lockon_take() {
/* 221 */     if (CLIENT_lockon > 0) CLIENT_lockon--; 
/*     */   }
/*     */   
/*     */   public static short get_hud_1_pos(int n) {
/* 225 */     int num = 0;
/* 226 */     if (CLIENT_hud1 > 0) num = BENS_CONFIG_HUD_1_SIZES_POS[CLIENT_hud1]; 
/* 227 */     num += n * get_hud_1_height();
/* 228 */     return (short)num;
/*     */   }
/*     */   
/*     */   public static short get_hud_1_pos_stam() {
/* 232 */     return BENS_CONFIG_HUD_1_SIZES_POS_STAM[CLIENT_hud1];
/* 233 */   } public static short get_hud_1_width_hea() { return BENS_CONFIG_HUD_1_SIZES_HEALTH_WIDTH[CLIENT_hud1]; }
/* 234 */   public static short get_hud_1_width_st() { return BENS_CONFIG_HUD_1_SIZES_STAMINA_WIDTH[CLIENT_hud1]; }
/* 235 */   public static short get_hud_1_width() { return BENS_CONFIG_HUD_1_SIZES_X[CLIENT_hud1]; } public static short get_hud_1_height() {
/* 236 */     return BENS_CONFIG_HUD_1_SIZES_Y[CLIENT_hud1];
/*     */   }
/*     */   
/*     */   public static void settings_addmore() {
/* 240 */     if (addMore < 1000) { addMore *= 10; }
/* 241 */     else { addMore = 1; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init_client(Configuration config, boolean firstRun, boolean reset) {
/* 249 */     configsChanged = !firstRun;
/*     */ 
/*     */     
/* 252 */     String name = "";
/* 253 */     String CATEGORY = "Client Settings";
/* 254 */     String client = "Client Sided!";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     int min = -10000, max = 10000000;
/* 261 */     Property property = config.get(CATEGORY, name + " Player Energy (Ki/Chakra) HUD X Position", 0);
/* 262 */     property.comment = "Client Sided! " + name + " Player Energy (Ki/Chakra) HUD X Position (from left to right)" + getDefault("" + min, "" + max);
/* 263 */     if (firstRun) { CLIENT_hud0x = checkValue(property.getInt(), min, max); }
/* 264 */     else if (reset)
/* 265 */     { property.setValue(0);
/* 266 */       CLIENT_hud0x = 0; }
/*     */     else
/* 268 */     { property.setValue(CLIENT_hud0x); }
/*     */     
/* 270 */     min = -10000; max = 10000000;
/* 271 */     property = config.get(CATEGORY, name + " Player Energy (Ki/Chakra) HUD Y Position", 0);
/* 272 */     property.comment = "Client Sided! " + name + " Player Energy (Ki/Chakra) HUD Y Position (from top to bottom)" + getDefault("" + min, "" + max);
/* 273 */     if (firstRun) { CLIENT_hud0y = checkValue(property.getInt(), min, max); }
/* 274 */     else if (reset)
/* 275 */     { property.setValue(0);
/* 276 */       CLIENT_hud0y = 0; }
/*     */     else
/* 278 */     { property.setValue(CLIENT_hud0y); }
/*     */     
/* 280 */     min = 0; max = 2;
/* 281 */     property = config.get(CATEGORY, name + " Player Energy (Ki/Chakra) HUD Style", 0);
/* 282 */     property.comment = "Client Sided! " + name + " Player Energy (Ki/Chakra) HUD Style" + getDefault("" + min, "" + max);
/* 283 */     if (firstRun) { CLIENT_hud0 = checkValue(property.getInt(), min, max); }
/* 284 */     else if (reset)
/* 285 */     { property.setValue(0);
/* 286 */       CLIENT_hud0 = 0; }
/*     */     else
/* 288 */     { property.setValue(CLIENT_hud0); }
/*     */     
/* 290 */     min = 0; max = 5;
/* 291 */     property = config.get(CATEGORY, name + " Player Lock on Style", 0);
/* 292 */     property.comment = "Client Sided! " + name + " Player Lock on Style" + getDefault("" + min, "" + max);
/* 293 */     if (firstRun) { CLIENT_lockon = checkValue(property.getInt(), min, max); }
/* 294 */     else if (reset)
/* 295 */     { property.setValue(0);
/* 296 */       CLIENT_lockon = 0; }
/*     */     else
/* 298 */     { property.setValue(CLIENT_lockon); }
/*     */     
/* 300 */     min = -10000; max = 10000000;
/* 301 */     property = config.get(CATEGORY, name + " Player Health and Action HUD X Position", 0);
/* 302 */     property.comment = "Client Sided! " + name + " Player Health and Action HUD X Position (from left to right)" + getDefault("" + min, "" + max);
/* 303 */     if (firstRun) { CLIENT_hud1x = checkValue(property.getInt(), min, max); }
/* 304 */     else if (reset)
/* 305 */     { property.setValue(0);
/* 306 */       CLIENT_hud1x = 0; }
/*     */     else
/* 308 */     { property.setValue(CLIENT_hud1x); }
/*     */     
/* 310 */     min = -10000; max = 10000000;
/* 311 */     property = config.get(CATEGORY, name + " Player Health and Action HUD Y Position", 0);
/* 312 */     property.comment = "Client Sided! " + name + " Player Health and Action HUD Y Position (from top to bottom)" + getDefault("" + min, "" + max);
/* 313 */     if (firstRun) { CLIENT_hud1y = checkValue(property.getInt(), min, max); }
/* 314 */     else if (reset)
/* 315 */     { property.setValue(0);
/* 316 */       CLIENT_hud1y = 0; }
/*     */     else
/* 318 */     { property.setValue(CLIENT_hud1y); }
/*     */     
/* 320 */     min = 0; max = 2;
/* 321 */     property = config.get(CATEGORY, name + " Player Health and Action HUD Style", 0);
/* 322 */     property.comment = "Client Sided! " + name + " Player Health and Action HUD Style" + getDefault("" + min, "" + max);
/* 323 */     if (firstRun) { CLIENT_hud1 = checkValue(property.getInt(), min, max); }
/* 324 */     else if (reset)
/* 325 */     { property.setValue(0);
/* 326 */       CLIENT_hud1 = 0; }
/*     */     else
/* 328 */     { property.setValue(CLIENT_hud1); }
/*     */     
/* 330 */     property = config.get(CATEGORY, name + " God Aura Particles On", true);
/* 331 */     property.comment = "Client Sided! " + name + " God Aura Particles On";
/* 332 */     if (firstRun) { CLIENT_GR0 = property.getBoolean(); }
/* 333 */     else if (reset)
/* 334 */     { property.setValue(true);
/* 335 */       CLIENT_GR0 = true; }
/*     */     else
/* 337 */     { property.setValue(CLIENT_GR0); }
/*     */     
/* 339 */     property = config.get(CATEGORY, name + " Stone Aura Particles On", true);
/* 340 */     property.comment = "Client Sided! " + name + " Stone Aura Particles On";
/* 341 */     if (firstRun) { CLIENT_GR1 = property.getBoolean(); }
/* 342 */     else if (reset)
/* 343 */     { property.setValue(true);
/* 344 */       CLIENT_GR1 = true; }
/*     */     else
/* 346 */     { property.setValue(CLIENT_GR1); }
/*     */     
/* 348 */     property = config.get(CATEGORY, name + " Swoop image effect On", true);
/* 349 */     property.comment = "Client Sided! " + name + " Swoop image effect On";
/* 350 */     if (firstRun) { CLIENT_GR2 = property.getBoolean(); }
/* 351 */     else if (reset)
/* 352 */     { property.setValue(true);
/* 353 */       CLIENT_GR2 = true; }
/*     */     else
/* 355 */     { property.setValue(CLIENT_GR2); }
/*     */     
/* 357 */     property = config.get(CATEGORY, name + " Fireball Particles On", true);
/* 358 */     property.comment = "Client Sided! " + name + " Fireball Particles On";
/* 359 */     if (firstRun) { CLIENT_GR3 = property.getBoolean(); }
/* 360 */     else if (reset)
/* 361 */     { property.setValue(true);
/* 362 */       CLIENT_GR3 = true; }
/*     */     else
/* 364 */     { property.setValue(CLIENT_GR3); }
/*     */     
/* 366 */     property = config.get(CATEGORY, name + " Explosion Particles On", true);
/* 367 */     property.comment = "Client Sided! " + name + " Explosion Particles On";
/* 368 */     if (firstRun) { CLIENT_GR4 = property.getBoolean(); }
/* 369 */     else if (reset)
/* 370 */     { property.setValue(true);
/* 371 */       CLIENT_GR4 = true; }
/*     */     else
/* 373 */     { property.setValue(CLIENT_GR4); }
/*     */     
/* 375 */     property = config.get(CATEGORY, name + " Percentage Text for Health bars", false);
/* 376 */     property.comment = "Client Sided! " + name + " Percentage Text for Health bars";
/* 377 */     if (firstRun) { CLIENT_GR5 = property.getBoolean(); }
/* 378 */     else if (reset)
/* 379 */     { property.setValue(false);
/* 380 */       CLIENT_GR5 = false; }
/*     */     else
/* 382 */     { property.setValue(CLIENT_GR5); }
/*     */     
/* 384 */     property = config.get(CATEGORY, name + " Rotated Health Bar On", false);
/* 385 */     property.comment = "Client Sided! " + name + " Rotated Health Bar On";
/* 386 */     if (firstRun) { CLIENT_GR6 = property.getBoolean(); }
/* 387 */     else if (reset)
/* 388 */     { property.setValue(false);
/* 389 */       CLIENT_GR6 = false; }
/*     */     else
/* 391 */     { property.setValue(CLIENT_GR6); }
/*     */     
/* 393 */     property = config.get(CATEGORY, name + " Ultra Instinct Aura Particles On", true);
/* 394 */     property.comment = "Client Sided! " + name + " Ultra Instinct Aura Particles On";
/* 395 */     if (firstRun) { CLIENT_GR7 = property.getBoolean(); }
/* 396 */     else if (reset)
/* 397 */     { property.setValue(true);
/* 398 */       CLIENT_GR7 = true; }
/*     */     else
/* 400 */     { property.setValue(CLIENT_GR7); }
/*     */     
/* 402 */     property = config.get(CATEGORY, name + " Grass Aura Particles On", true);
/* 403 */     property.comment = "Client Sided! " + name + " Grass Aura Particles On";
/* 404 */     if (firstRun) { CLIENT_GR8 = property.getBoolean(); }
/* 405 */     else if (reset)
/* 406 */     { property.setValue(true);
/* 407 */       CLIENT_GR8 = true; }
/*     */     else
/* 409 */     { property.setValue(CLIENT_GR8); }
/*     */     
/* 411 */     property = config.get(CATEGORY, name + " Dust Aura Particles On", true);
/* 412 */     property.comment = "Client Sided! " + name + " Dust Aura Particles On";
/* 413 */     if (firstRun) { CLIENT_GR9 = property.getBoolean(); }
/* 414 */     else if (reset)
/* 415 */     { property.setValue(true);
/* 416 */       CLIENT_GR9 = true; }
/*     */     else
/* 418 */     { property.setValue(CLIENT_GR9); }
/*     */     
/* 420 */     property = config.get(CATEGORY, name + " 3D Stone Aura Particles On", false);
/* 421 */     property.comment = "Client Sided! " + name + " 3D Stone Aura Particles On";
/* 422 */     if (firstRun) { CLIENT_GR10 = property.getBoolean(); }
/* 423 */     else if (reset)
/* 424 */     { property.setValue(false);
/* 425 */       CLIENT_GR10 = false; }
/*     */     else
/* 427 */     { property.setValue(CLIENT_GR10); }
/*     */     
/* 429 */     property = config.get(CATEGORY, name + " 3D Grass Aura Particles On", false);
/* 430 */     property.comment = "Client Sided! " + name + " 3D Grass Aura Particles On";
/* 431 */     if (firstRun) { CLIENT_GR11 = property.getBoolean(); }
/* 432 */     else if (reset)
/* 433 */     { property.setValue(false);
/* 434 */       CLIENT_GR11 = false; }
/*     */     else
/* 436 */     { property.setValue(CLIENT_GR11); }
/*     */     
/* 438 */     min = -1; max = 1000;
/* 439 */     property = config.get(CATEGORY, name + "Particles amount multiplier", 0);
/* 440 */     property.comment = "Client Sided! " + name + " Particles amount multiplier" + getDefault("" + min, "" + max);
/* 441 */     if (firstRun) { CLIENT_DA1 = checkValue(property.getInt(), min, max); }
/* 442 */     else if (reset)
/* 443 */     { property.setValue(0);
/* 444 */       CLIENT_DA1 = 0; }
/*     */     else
/* 446 */     { property.setValue(CLIENT_DA1); }
/*     */     
/* 448 */     min = 0; max = 10000;
/* 449 */     property = config.get(CATEGORY, name + "Particles speed multiplier", 0);
/* 450 */     property.comment = "Client Sided! " + name + " Particles speed multiplier" + getDefault("" + min, "" + max);
/* 451 */     if (firstRun) { CLIENT_DA2 = checkValue(property.getInt(), min, max); }
/* 452 */     else if (reset)
/* 453 */     { property.setValue(0);
/* 454 */       CLIENT_DA2 = 0; }
/*     */     else
/* 456 */     { property.setValue(CLIENT_DA2); }
/*     */     
/* 458 */     min = 0; max = 10;
/* 459 */     property = config.get(CATEGORY, name + "Particle invisible from first person", 2);
/* 460 */     property.comment = "Client Sided! " + name + " Particle invisible from first person" + getDefault("" + min, "" + max);
/* 461 */     if (firstRun) { CLIENT_DA3 = checkValue(property.getInt(), min, max); }
/* 462 */     else if (reset)
/* 463 */     { property.setValue(2);
/* 464 */       CLIENT_DA3 = 2; }
/*     */     else
/* 466 */     { property.setValue(CLIENT_DA3); }
/*     */     
/* 468 */     property = config.get(CATEGORY, name + "New first person animations On", true);
/* 469 */     property.comment = "Client Sided! " + name + " New first person animations On";
/* 470 */     if (firstRun) { CLIENT_DA4 = property.getBoolean(); }
/* 471 */     else if (reset)
/* 472 */     { property.setValue(true);
/* 473 */       CLIENT_DA4 = true; }
/*     */     else
/* 475 */     { property.setValue(CLIENT_DA4); }
/*     */     
/* 477 */     property = config.get(CATEGORY, name + "New 3D Explosion On", true);
/* 478 */     property.comment = "Client Sided! " + name + " New 3D Explosion On";
/* 479 */     if (firstRun) { CLIENT_DA5 = property.getBoolean(); }
/* 480 */     else if (reset)
/* 481 */     { property.setValue(true);
/* 482 */       CLIENT_DA5 = true; }
/*     */     else
/* 484 */     { property.setValue(CLIENT_DA5); }
/*     */     
/* 486 */     property = config.get(CATEGORY, name + "New 2D Explosion On", true);
/* 487 */     property.comment = "Client Sided! " + name + " New 2D Explosion On";
/* 488 */     if (firstRun) { CLIENT_DA6 = property.getBoolean(); }
/* 489 */     else if (reset)
/* 490 */     { property.setValue(true);
/* 491 */       CLIENT_DA6 = true; }
/*     */     else
/* 493 */     { property.setValue(CLIENT_DA6); }
/*     */     
/* 495 */     property = config.get(CATEGORY, name + "Explosion 3D On", true);
/* 496 */     property.comment = "Client Sided! " + name + " Explosion 3D On";
/* 497 */     if (firstRun) { CLIENT_DA7 = property.getBoolean(); }
/* 498 */     else if (reset)
/* 499 */     { property.setValue(true);
/* 500 */       CLIENT_DA7 = true; }
/*     */     else
/* 502 */     { property.setValue(CLIENT_DA7); }
/*     */     
/* 504 */     property = config.get(CATEGORY, name + "NPC aura On", true);
/* 505 */     property.comment = "Client Sided! " + name + " NPC aura On";
/* 506 */     if (firstRun) { CLIENT_DA8 = property.getBoolean(); }
/* 507 */     else if (reset)
/* 508 */     { property.setValue(true);
/* 509 */       CLIENT_DA8 = true; }
/*     */     else
/* 511 */     { property.setValue(CLIENT_DA8); }
/*     */     
/* 513 */     property = config.get(CATEGORY, name + "Double ki blast color On", true);
/* 514 */     property.comment = "CLIENT_DA9" + name + " Double ki blast color On";
/* 515 */     if (firstRun) { CLIENT_DA9 = property.getBoolean(); }
/* 516 */     else if (reset)
/* 517 */     { property.setValue(true);
/* 518 */       CLIENT_DA9 = true; }
/*     */     else
/* 520 */     { property.setValue(CLIENT_DA9); }
/*     */     
/* 522 */     property = config.get(CATEGORY, name + "Ki blast charge animation On", true);
/* 523 */     property.comment = "Client Sided! " + name + " Ki blast charge animation On";
/* 524 */     if (firstRun) { CLIENT_DA10 = property.getBoolean(); }
/* 525 */     else if (reset)
/* 526 */     { property.setValue(true);
/* 527 */       CLIENT_DA10 = true; }
/*     */     else
/* 529 */     { property.setValue(CLIENT_DA10); }
/*     */     
/* 531 */     property = config.get(CATEGORY, name + "Flying trail On", false);
/* 532 */     property.comment = "Client Sided! " + name + " Flying trail On";
/* 533 */     if (firstRun) { CLIENT_DA11 = property.getBoolean(); }
/* 534 */     else if (reset)
/* 535 */     { property.setValue(false);
/* 536 */       CLIENT_DA11 = false; }
/*     */     else
/* 538 */     { property.setValue(CLIENT_DA11); }
/*     */     
/* 540 */     property = config.get(CATEGORY, name + "Aura lightning On", true);
/* 541 */     property.comment = "Client Sided! " + name + " Aura lightning On";
/* 542 */     if (firstRun) { CLIENT_DA12 = property.getBoolean(); }
/* 543 */     else if (reset)
/* 544 */     { property.setValue(true);
/* 545 */       CLIENT_DA12 = true; }
/*     */     else
/* 547 */     { property.setValue(CLIENT_DA12); }
/*     */     
/* 549 */     property = config.get(CATEGORY, name + "2D player aura animation On", true);
/* 550 */     property.comment = "Client Sided! " + name + " 2D player aura animation On";
/* 551 */     if (firstRun) { CLIENT_DA13 = property.getBoolean(); }
/* 552 */     else if (reset)
/* 553 */     { property.setValue(true);
/* 554 */       CLIENT_DA13 = true; }
/*     */     else
/* 556 */     { property.setValue(CLIENT_DA13); }
/*     */     
/* 558 */     property = config.get(CATEGORY, name + "3D player aura animation On", true);
/* 559 */     property.comment = "Client Sided! " + name + " 3D player aura animation On";
/* 560 */     if (firstRun) { CLIENT_DA14 = property.getBoolean(); }
/* 561 */     else if (reset)
/* 562 */     { property.setValue(true);
/* 563 */       CLIENT_DA14 = true; }
/*     */     else
/* 565 */     { property.setValue(CLIENT_DA14); }
/*     */     
/* 567 */     property = config.get(CATEGORY, name + "Hitting clash effect On", true);
/* 568 */     property.comment = "Client Sided! " + name + " Hitting clash effect On";
/* 569 */     if (firstRun) { CLIENT_DA15 = property.getBoolean(); }
/* 570 */     else if (reset)
/* 571 */     { property.setValue(true);
/* 572 */       CLIENT_DA15 = true; }
/*     */     else
/* 574 */     { property.setValue(CLIENT_DA15); }
/*     */     
/* 576 */     property = config.get(CATEGORY, name + "Spawn Other particles On", true);
/* 577 */     property.comment = "Client Sided! " + name + " Spawn Other particles On";
/* 578 */     if (firstRun) { CLIENT_DA16 = property.getBoolean(); }
/* 579 */     else if (reset)
/* 580 */     { property.setValue(true);
/* 581 */       CLIENT_DA16 = true; }
/*     */     else
/* 583 */     { property.setValue(CLIENT_DA16); }
/*     */     
/* 585 */     property = config.get(CATEGORY, name + "Custom HUD On", false);
/* 586 */     property.comment = "Client Sided! " + name + " Custom HUD On";
/* 587 */     if (firstRun) { CLIENT_hud2 = property.getBoolean(); }
/* 588 */     else if (reset)
/* 589 */     { property.setValue(false);
/* 590 */       CLIENT_hud2 = false; }
/*     */     else
/* 592 */     { property.setValue(CLIENT_hud2); }
/*     */     
/* 594 */     property = config.get(CATEGORY, name + "Custom HUD Properties", "0,0,154,55,0,background,;45,12,104,8,0,0,55,12,2,health,30,150,30,#amount/#max,;49,23,85,11,1,0,55,25,2,energy,0,0,0,#amount/#max,;44,37,59,7,0,0,50,35,2,stamina,255,200,0,#empty,;1,8,10,39,0,2,0,22,2,transform,255,0,255,#empty,;6,6,43,43,0,2,21,22,2,release,255,0,0,#amount,;50,50,2,0,150,50,50,;75,0,2,25,150,255,;");
/* 595 */     property.comment = "Client Sided! " + name + " Custom HUD Properties" + getDefault("0,0,154,55,0,background,;45,12,104,8,0,0,55,12,2,health,30,150,30,#amount/#max,;49,23,85,11,1,0,55,25,2,energy,0,0,0,#amount/#max,;44,37,59,7,0,0,50,35,2,stamina,255,200,0,#empty,;1,8,10,39,0,2,0,22,2,transform,255,0,255,#empty,;6,6,43,43,0,2,21,22,2,release,255,0,0,#amount,;50,50,2,0,150,50,50,;75,0,2,25,150,255,;");
/* 596 */     if (firstRun) { CLIENT_hud2_2 = property.getString(); }
/* 597 */     else if (reset)
/* 598 */     { property.setValue("0,0,154,55,0,background,;45,12,104,8,0,0,55,12,2,health,30,150,30,#amount/#max,;49,23,85,11,1,0,55,25,2,energy,0,0,0,#amount/#max,;44,37,59,7,0,0,50,35,2,stamina,255,200,0,#empty,;1,8,10,39,0,2,0,22,2,transform,255,0,255,#empty,;6,6,43,43,0,2,21,22,2,release,255,0,0,#amount,;50,50,2,0,150,50,50,;75,0,2,25,150,255,;");
/* 599 */       CLIENT_hud2_2 = "0,0,154,55,0,background,;45,12,104,8,0,0,55,12,2,health,30,150,30,#amount/#max,;49,23,85,11,1,0,55,25,2,energy,0,0,0,#amount/#max,;44,37,59,7,0,0,50,35,2,stamina,255,200,0,#empty,;1,8,10,39,0,2,0,22,2,transform,255,0,255,#empty,;6,6,43,43,0,2,21,22,2,release,255,0,0,#amount,;50,50,2,0,150,50,50,;75,0,2,25,150,255,;"; }
/*     */     else
/* 601 */     { property.setValue(CLIENT_hud2_2); }
/*     */     
/* 603 */     property = config.get(CATEGORY, name + "April fools mode On", false);
/* 604 */     property.comment = "Client Sided! " + name + " April fools mode On";
/* 605 */     if (firstRun) { CLIENT_DA17 = property.getBoolean(); }
/* 606 */     else if (reset)
/* 607 */     { property.setValue(false);
/* 608 */       CLIENT_DA17 = false; }
/*     */     else
/* 610 */     { property.setValue(CLIENT_DA17); }
/*     */     
/* 612 */     property = config.get(CATEGORY, name + "First Person Blocking animation On", false);
/* 613 */     property.comment = "Client Sided! " + name + " First Person Blocking animation On";
/* 614 */     if (firstRun) { CLIENT_DA18 = property.getBoolean(); }
/* 615 */     else if (reset)
/* 616 */     { property.setValue(false);
/* 617 */       CLIENT_DA18 = false; }
/*     */     else
/* 619 */     { property.setValue(CLIENT_DA18); }
/*     */     
/* 621 */     property = config.get(CATEGORY, name + "Player Bruises On", true);
/* 622 */     property.comment = "Client Sided! " + name + " Player Bruises On";
/* 623 */     if (firstRun) { CLIENT_DA19 = property.getBoolean(); }
/* 624 */     else if (reset)
/* 625 */     { property.setValue(true);
/* 626 */       CLIENT_DA19 = true; }
/*     */     else
/* 628 */     { property.setValue(CLIENT_DA19); }
/*     */     
/* 630 */     property = config.get(CATEGORY, name + "3D Aura, 2D God On", true);
/* 631 */     property.comment = "Client Sided! " + name + " 3D Aura, 2D God On";
/* 632 */     if (firstRun) { CLIENT_DA20 = property.getBoolean(); }
/* 633 */     else if (reset)
/* 634 */     { property.setValue(true);
/* 635 */       CLIENT_DA20 = true; }
/*     */     else
/* 637 */     { property.setValue(CLIENT_DA20); }
/*     */     
/* 639 */     min = 0; max = 10;
/* 640 */     property = config.get(CATEGORY, name + " 3D Aura Invisibility", 10);
/* 641 */     property.comment = "Client Sided! " + name + " 3D Aura Invisibility" + getDefault("" + min, "" + max);
/* 642 */     if (firstRun) { CLIENT_DA21 = checkValue(property.getInt(), min, max); }
/* 643 */     else if (reset)
/* 644 */     { property.setValue(10);
/* 645 */       CLIENT_DA21 = 10; }
/*     */     else
/* 647 */     { property.setValue(CLIENT_DA21); }
/*     */     
/* 649 */     property = config.get(CATEGORY, name + "Action Menu Text Type On", false);
/* 650 */     property.comment = "Client Sided! " + name + " Action Menu Text Type On";
/* 651 */     if (firstRun) { CLIENT_GR12 = property.getBoolean(); }
/* 652 */     else if (reset)
/* 653 */     { property.setValue(false);
/* 654 */       CLIENT_GR12 = false; }
/*     */     else
/* 656 */     { property.setValue(CLIENT_GR12); }
/*     */     
/* 658 */     property = config.get(CATEGORY, name + "Action Menu Text White On", false);
/* 659 */     property.comment = "Client Sided! " + name + " Action Menu Text White On";
/* 660 */     if (firstRun) { CLIENT_GR13 = property.getBoolean(); }
/* 661 */     else if (reset)
/* 662 */     { property.setValue(false);
/* 663 */       CLIENT_GR13 = false; }
/*     */     else
/* 665 */     { property.setValue(CLIENT_GR13); }
/*     */     
/* 667 */     property = config.get(CATEGORY, name + "Enma Desk On", true);
/* 668 */     property.comment = "Client Sided! " + name + " Enma Desk On";
/* 669 */     if (firstRun) { CLIENT_DA22 = property.getBoolean(); }
/* 670 */     else if (reset)
/* 671 */     { property.setValue(true);
/* 672 */       CLIENT_DA22 = true; }
/*     */     else
/* 674 */     { property.setValue(CLIENT_DA22); }
/*     */ 
/*     */ 
/*     */     
/* 678 */     min = 0; max = 10;
/* 679 */     property = config.get(CATEGORY, name + " Ki Attack Visibility", 10);
/* 680 */     property.comment = "Client Sided! " + name + " Ki Attack Visibility" + getDefault("" + min, "" + max);
/* 681 */     if (firstRun) { CLIENT_Ki_Visibility = (byte)checkValue(property.getInt(), min, max); }
/* 682 */     else if (reset)
/* 683 */     { property.setValue(10);
/* 684 */       CLIENT_Ki_Visibility = 10; }
/*     */     else
/* 686 */     { property.setValue(CLIENT_Ki_Visibility); }
/*     */     
/* 688 */     min = 0; max = 100000;
/* 689 */     property = config.get(CATEGORY, name + " Ki Attack Scale", 10);
/* 690 */     property.comment = "Client Sided! " + name + " Ki Attack Scale" + getDefault("" + min, "" + max);
/* 691 */     if (firstRun) { CLIENT_Ki_Scale = checkValue(property.getInt(), min, max); }
/* 692 */     else if (reset)
/* 693 */     { property.setValue(10);
/* 694 */       CLIENT_Ki_Scale = 10; }
/*     */     else
/* 696 */     { property.setValue(CLIENT_Ki_Scale); }
/*     */     
/* 698 */     min = 0; max = 10;
/* 699 */     property = config.get(CATEGORY, name + " Ki Charge Visibility", 10);
/* 700 */     property.comment = "Client Sided! " + name + " Ki Charge Visibility" + getDefault("" + min, "" + max);
/* 701 */     if (firstRun) { CLIENT_Ki_Charge_Visibility = (byte)checkValue(property.getInt(), min, max); }
/* 702 */     else if (reset)
/* 703 */     { property.setValue(10);
/* 704 */       CLIENT_Ki_Charge_Visibility = 10; }
/*     */     else
/* 706 */     { property.setValue(CLIENT_Ki_Charge_Visibility); }
/*     */     
/* 708 */     min = 0; max = 100000;
/* 709 */     property = config.get(CATEGORY, name + " Ki Charge Scale", 10);
/* 710 */     property.comment = "Client Sided! " + name + " Ki Charge Scale" + getDefault("" + min, "" + max);
/* 711 */     if (firstRun) { CLIENT_Ki_Charge_Scale = checkValue(property.getInt(), min, max); }
/* 712 */     else if (reset)
/* 713 */     { property.setValue(10);
/* 714 */       CLIENT_Ki_Charge_Scale = 10; }
/*     */     else
/* 716 */     { property.setValue(CLIENT_Ki_Charge_Scale); }
/*     */     
/* 718 */     min = 0; max = 10;
/* 719 */     property = config.get(CATEGORY, name + " Jutsu Visibility", 10);
/* 720 */     property.comment = "Client Sided! " + name + " Jutsu Visibility" + getDefault("" + min, "" + max);
/* 721 */     if (firstRun) { CLIENT_Jutsu_Visibility = (byte)checkValue(property.getInt(), min, max); }
/* 722 */     else if (reset)
/* 723 */     { property.setValue(10);
/* 724 */       CLIENT_Jutsu_Visibility = 10; }
/*     */     else
/* 726 */     { property.setValue(CLIENT_Jutsu_Visibility); }
/*     */     
/* 728 */     min = 0; max = 100000;
/* 729 */     property = config.get(CATEGORY, name + " Jutsu Scale", 10);
/* 730 */     property.comment = "Client Sided! " + name + " Jutsu Scale" + getDefault("" + min, "" + max);
/* 731 */     if (firstRun) { CLIENT_Jutsu_Scale = checkValue(property.getInt(), min, max); }
/* 732 */     else if (reset)
/* 733 */     { property.setValue(10);
/* 734 */       CLIENT_Jutsu_Scale = 10; }
/*     */     else
/* 736 */     { property.setValue(CLIENT_Jutsu_Scale); }
/*     */ 
/*     */ 
/*     */     
/* 740 */     String[] names2 = { "Wave", "Blast", "Disk", "Laser", "Spiral", "BigBlast", "Barrage", "Shield", "Explosion" }; int j;
/* 741 */     for (j = 0; j < names2.length; j++) {
/*     */       
/* 743 */       property = config.get(CATEGORY, name + " 3D Ki Attack Effect [" + names2[j] + "] On", false);
/* 744 */       property.comment = "Client Sided! " + name + " 3D Ki Attack Effect [" + names2[j] + "] On";
/* 745 */       if (firstRun) { CLIENT_Ki_3d[j] = property.getBoolean(); }
/* 746 */       else if (reset)
/* 747 */       { property.setValue(false);
/* 748 */         CLIENT_Ki_3d[j] = false; }
/*     */       else
/* 750 */       { property.setValue(CLIENT_Ki_3d[j]); }
/*     */     
/* 752 */     }  for (j = 0; j < names2.length; j++) {
/*     */       
/* 754 */       property = config.get(CATEGORY, name + " 3D Ki Attack Charge Effect [" + names2[j] + "] On", false);
/* 755 */       property.comment = "Client Sided! " + name + " 3D Ki Attack Charge Effect [" + names2[j] + "] On";
/* 756 */       if (firstRun) { CLIENT_Ki_Charge_3d[j] = property.getBoolean(); }
/* 757 */       else if (reset)
/* 758 */       { property.setValue(false);
/* 759 */         CLIENT_Ki_Charge_3d[j] = false; }
/*     */       else
/* 761 */       { property.setValue(CLIENT_Ki_Charge_3d[j]); }
/*     */     
/* 763 */     }  for (j = 0; j < 3; j++) {
/*     */       
/* 765 */       property = config.get(CATEGORY, name + " 3D Jutsu Attack Effect [" + names2[j] + "] On", false);
/* 766 */       property.comment = "Client Sided! " + name + " 3D Jutsu Attack Effect [" + names2[j] + "] On";
/* 767 */       if (firstRun) { CLIENT_Jutsu_3d[j] = property.getBoolean(); }
/* 768 */       else if (reset)
/* 769 */       { property.setValue(false);
/* 770 */         CLIENT_Jutsu_3d[j] = false; }
/*     */       else
/* 772 */       { property.setValue(CLIENT_Jutsu_3d[j]); }
/*     */     
/*     */     } 
/*     */     
/* 776 */     property = config.get(CATEGORY, name + "Render Energy Outside View", true);
/* 777 */     property.comment = "Client Sided! " + name + " Render Energy Outside View";
/* 778 */     if (firstRun) { renderEnergyOutsideView = property.getBoolean(); }
/* 779 */     else if (reset)
/* 780 */     { property.setValue(true);
/* 781 */       renderEnergyOutsideView = true; }
/*     */     else
/* 783 */     { property.setValue(renderEnergyOutsideView); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 793 */     name = "Minigame Concentration Animated Textures On";
/* 794 */     property = config.get(CATEGORY, name, true);
/* 795 */     property.comment = "Client Sided! " + name;
/* 796 */     if (firstRun) { concentrationAnimatedTexturesOn = property.getBoolean(); }
/* 797 */     else if (reset)
/* 798 */     { property.setValue(true);
/* 799 */       concentrationAnimatedTexturesOn = true; }
/*     */     else
/* 801 */     { property.setValue(concentrationAnimatedTexturesOn); }
/*     */     
/* 803 */     name = "Minigame Concentration Animated Color On";
/* 804 */     property = config.get(CATEGORY, name, true);
/* 805 */     property.comment = "Client Sided! " + name;
/* 806 */     if (firstRun) { concentrationAnimatedColorOn = property.getBoolean(); }
/* 807 */     else if (reset)
/* 808 */     { property.setValue(true);
/* 809 */       concentrationAnimatedColorOn = true; }
/*     */     else
/* 811 */     { property.setValue(concentrationAnimatedColorOn); }
/*     */     
/* 813 */     name = "Minigame Airboxing 3D Character On";
/* 814 */     property = config.get(CATEGORY, name, true);
/* 815 */     property.comment = "Client Sided! " + name;
/* 816 */     if (firstRun) { airboxing3DCharacterOn = property.getBoolean(); }
/* 817 */     else if (reset)
/* 818 */     { property.setValue(true);
/* 819 */       airboxing3DCharacterOn = true; }
/*     */     else
/* 821 */     { property.setValue(airboxing3DCharacterOn); }
/*     */     
/* 823 */     name = "Minigame Airboxing 3D Aura On";
/* 824 */     property = config.get(CATEGORY, name, true);
/* 825 */     property.comment = "Client Sided! " + name;
/* 826 */     if (firstRun) { airboxing3DAuraOn = property.getBoolean(); }
/* 827 */     else if (reset)
/* 828 */     { property.setValue(true);
/* 829 */       airboxing3DAuraOn = true; }
/*     */     else
/* 831 */     { property.setValue(airboxing3DAuraOn); }
/*     */     
/* 833 */     name = "Minigame Airboxing Animated Color On";
/* 834 */     property = config.get(CATEGORY, name, true);
/* 835 */     property.comment = "Client Sided! " + name;
/* 836 */     if (firstRun) { airboxingAnimatedColorOn = property.getBoolean(); }
/* 837 */     else if (reset)
/* 838 */     { property.setValue(true);
/* 839 */       airboxingAnimatedColorOn = true; }
/*     */     else
/* 841 */     { property.setValue(airboxingAnimatedColorOn); }
/*     */ 
/*     */     
/* 844 */     min = 0; max = 100;
/* 845 */     name = "Render Distance Multiplier - Barrier Block";
/* 846 */     property = config.get(CATEGORY, name, 100);
/* 847 */     property.comment = "Client Sided! " + name + getDefault("" + min, "" + max);
/* 848 */     if (firstRun) { renderdistanceMultiplierBarrierBlock = checkValue(property.getInt(), min, max); }
/* 849 */     else if (reset)
/* 850 */     { property.setValue(100);
/* 851 */       renderdistanceMultiplierBarrierBlock = 100; }
/*     */     else
/* 853 */     { property.setValue(renderdistanceMultiplierBarrierBlock); }
/*     */     
/* 855 */     min = 0; max = 10000;
/* 856 */     name = "Render Distance Multiplier - Particles";
/* 857 */     property = config.get(CATEGORY, name, 100);
/* 858 */     property.comment = "Client Sided! " + name + getDefault("" + min, "" + max);
/* 859 */     if (firstRun) { renderdistanceMultiplierParticles = checkValue(property.getInt(), min, max); }
/* 860 */     else if (reset)
/* 861 */     { property.setValue(100);
/* 862 */       renderdistanceMultiplierParticles = 100; }
/*     */     else
/* 864 */     { property.setValue(renderdistanceMultiplierParticles); }
/*     */     
/* 866 */     min = 0; max = 10000;
/* 867 */     name = "Render Distance Multiplier - Auras";
/* 868 */     property = config.get(CATEGORY, name, 100);
/* 869 */     property.comment = "Client Sided! " + name + getDefault("" + min, "" + max);
/* 870 */     if (firstRun) { renderdistanceMultiplierAuras = checkValue(property.getInt(), min, max); }
/* 871 */     else if (reset)
/* 872 */     { property.setValue(100);
/* 873 */       renderdistanceMultiplierAuras = 100; }
/*     */     else
/* 875 */     { property.setValue(renderdistanceMultiplierAuras); }
/*     */     
/* 877 */     min = 0; max = 10000;
/* 878 */     name = "Render Distance Multiplier - Ki Attack Charge";
/* 879 */     property = config.get(CATEGORY, name, 100);
/* 880 */     property.comment = "Client Sided! " + name + getDefault("" + min, "" + max);
/* 881 */     if (firstRun) { renderdistanceMultiplierKiAttackCharge = checkValue(property.getInt(), min, max); }
/* 882 */     else if (reset)
/* 883 */     { property.setValue(100);
/* 884 */       renderdistanceMultiplierKiAttackCharge = 100; }
/*     */     else
/* 886 */     { property.setValue(renderdistanceMultiplierKiAttackCharge); }
/*     */     
/* 888 */     name = "Ki Attack Charge Percentage On";
/* 889 */     property = config.get(CATEGORY, name, true);
/* 890 */     property.comment = "Client Sided! " + name;
/* 891 */     if (firstRun) { kiAttackChargePercentageOn = property.getBoolean(); }
/* 892 */     else if (reset)
/* 893 */     { property.setValue(true);
/* 894 */       kiAttackChargePercentageOn = true; }
/*     */     else
/* 896 */     { property.setValue(kiAttackChargePercentageOn); }
/*     */     
/* 898 */     name = "Tip Notifications On";
/* 899 */     property = config.get(CATEGORY, name, true);
/* 900 */     property.comment = "Client Sided! " + name;
/* 901 */     if (firstRun) { tipNotificationsOn = property.getBoolean(); }
/* 902 */     else if (reset)
/* 903 */     { property.setValue(true);
/* 904 */       tipNotificationsOn = true; }
/*     */     else
/* 906 */     { property.setValue(tipNotificationsOn); }
/*     */     
/* 908 */     name = "Error Notifications On";
/* 909 */     property = config.get(CATEGORY, name, true);
/* 910 */     property.comment = "Client Sided! " + name;
/* 911 */     if (firstRun) { errorNotificationsOn = property.getBoolean(); }
/* 912 */     else if (reset)
/* 913 */     { property.setValue(true);
/* 914 */       errorNotificationsOn = true; }
/*     */     else
/* 916 */     { property.setValue(errorNotificationsOn); }
/*     */     
/* 918 */     name = "DBCFast Fusion Spectator Camera Follow";
/* 919 */     property = config.get(CATEGORY, name, true);
/* 920 */     property.comment = "Client Sided! " + name;
/* 921 */     if (firstRun) { dbcFastFusionSpectatorCameraFollowOn = property.getBoolean(); }
/* 922 */     else if (reset)
/* 923 */     { property.setValue(true);
/* 924 */       dbcFastFusionSpectatorCameraFollowOn = true; }
/*     */     else
/* 926 */     { property.setValue(dbcFastFusionSpectatorCameraFollowOn); }
/*     */     
/* 928 */     name = "Safe Zone UI Mode On";
/* 929 */     property = config.get(CATEGORY, name, true);
/* 930 */     property.comment = "Client Sided! " + name;
/* 931 */     if (firstRun) { safeZoneUIModeOn = property.getBoolean(); }
/* 932 */     else if (reset)
/* 933 */     { property.setValue(true);
/* 934 */       safeZoneUIModeOn = true; }
/*     */     else
/* 936 */     { property.setValue(safeZoneUIModeOn); }
/*     */     
/* 938 */     name = "Instant Transmission First Person On";
/* 939 */     property = config.get(CATEGORY, name, true);
/* 940 */     property.comment = "Client Sided! " + name;
/* 941 */     if (firstRun) { instantTransmissionFirstPerson = property.getBoolean(); }
/* 942 */     else if (reset)
/* 943 */     { property.setValue(true);
/* 944 */       instantTransmissionFirstPerson = true; }
/*     */     else
/* 946 */     { property.setValue(instantTransmissionFirstPerson); }
/*     */     
/* 948 */     name = "Instant Transmission Particles On";
/* 949 */     property = config.get(CATEGORY, name, true);
/* 950 */     property.comment = "Client Sided! " + name;
/* 951 */     if (firstRun) { instantTransmissionParticles = property.getBoolean(); }
/* 952 */     else if (reset)
/* 953 */     { property.setValue(true);
/* 954 */       instantTransmissionParticles = true; }
/*     */     else
/* 956 */     { property.setValue(instantTransmissionParticles); }
/*     */ 
/*     */     
/* 959 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init_notifications(Configuration config, boolean firstRun, boolean reset) {
/* 966 */     String name = "";
/* 967 */     String CATEGORY = "Notifications";
/* 968 */     String client = "Client Sided!";
/*     */ 
/*     */ 
/*     */     
/* 972 */     for (int i = 0; i < JGNotificationGUI.categoryState.length; i++) {
/*     */       
/* 974 */       int min = 0, max = 2;
/* 975 */       name = "Category State " + JGNotificationHandler.CATEGORY_TEXTS_ALL[i];
/* 976 */       Property property = config.get(CATEGORY, name, 0);
/* 977 */       property.comment = "Client Sided! " + name + getDefault("" + min, "" + max);
/* 978 */       if (firstRun) { JGNotificationGUI.categoryState[i] = checkValue(property.getInt(), min, max); }
/* 979 */       else if (reset)
/* 980 */       { property.setValue(0);
/* 981 */         JGNotificationGUI.categoryState[i] = 0; }
/*     */       else
/* 983 */       { property.setValue(JGNotificationGUI.categoryState[i]); }
/*     */     
/*     */     } 
/* 986 */     config.save();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\config\jrmc\JGConfigClientSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */