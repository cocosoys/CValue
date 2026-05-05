/*      */ package JinRyuu.JRMCore;
/*      */ 
/*      */ import java.util.HashMap;
/*      */ import net.minecraftforge.common.config.Configuration;
/*      */ import net.minecraftforge.common.config.Property;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JRMCoreConfig
/*      */ {
/*      */   public static final String CATEGORY_SERVERSIDED = "general";
/*      */   public static final String CATEGORY_CLIENTSIDED = "Client Sided Configs";
/*      */   public static final String CATEGORY_JBRA = "JBRA Configs";
/*      */   public static final String CATEGORY_DBC_SERVERSIDED = "DBC Server Sided Configs";
/*      */   public static final String CATEGORY_DBC_KIATTACK_SERVERSIDED = "DBC Ki Attack Server Sided Configs";
/*      */   public static final String CATEGORY_NC_JUTSU_SERVERSIDED = "NC Jutsu Server Sided Configs";
/*      */   public static final String CATEGORY_COMMAND = "Command Configs";
/*      */   public static final String CATEGORY_ENERGYATTACKS = "Energy Attack Configs";
/*      */   public static final String CATEGORY_NC_SERVERSIDED = "NarutoC Server Sided Configs";
/*      */   public static final String CATEGORY_CONSOLE = "Console Configs";
/*      */   public static final String CATEGORY_FOOD = "Food Configs";
/*      */   public static final int ACTIVE = 0;
/*      */   public static final int PASSVIE = 1;
/*      */   public static boolean regen;
/*      */   public static boolean hregen;
/*      */   public static boolean release;
/*      */   public static int tpgn;
/*   37 */   public static int tmx = 500;
/*      */   
/*      */   public static String regenRate;
/*      */   
/*      */   public static int rgnRt;
/*      */   
/*      */   public static String hRegenRate;
/*      */   
/*      */   public static int hRgnRt;
/*      */   
/*      */   public static int playerCount;
/*      */   public static boolean sizes;
/*      */   public static String ssurl;
/*      */   public static String ssurl2;
/*      */   public static String ssc;
/*      */   public static boolean sfzns;
/*      */   public static int eaei;
/*      */   public static double eaes;
/*      */   public static int eaesl;
/*      */   public static float eadm;
/*      */   public static float ealbm;
/*   58 */   public static int buildingSpawnAreaSize = 100;
/*      */   
/*      */   public static boolean NPCSpawnCheck = true;
/*      */   
/*      */   public static boolean BuildingSpawnCheck = true;
/*   63 */   public static int RegnTime = 10;
/*      */   
/*      */   public static boolean KillAlgnmntChnge;
/*      */   
/*      */   public static boolean expGriOff = false;
/*      */   
/*      */   public static boolean cexpGriOff = false;
/*      */   
/*      */   public static boolean cregen;
/*      */   
/*      */   public static boolean chregen;
/*      */   
/*      */   public static boolean crelease;
/*      */   
/*      */   public static int ctpgn;
/*      */   
/*      */   public static int ctmx;
/*      */   
/*      */   public static String cregenRate;
/*      */   
/*      */   public static int crgnRt;
/*      */   public static String chRegenRate;
/*      */   public static int chRgnRt;
/*      */   public static int cplayerCount;
/*      */   public static boolean csizes;
/*      */   public static String cssurl;
/*      */   public static String cssurl2;
/*      */   public static String cssc;
/*      */   public static boolean csfzns;
/*      */   public static int ceaei;
/*      */   public static double ceaes;
/*      */   public static int ceaesl;
/*      */   public static float ceadm;
/*      */   public static float cealbm;
/*   97 */   public static int cbuildingSpawnAreaSize = 100;
/*      */   
/*      */   public static boolean cNPCSpawnCheck = true;
/*      */   
/*      */   public static boolean cBuildingSpawnCheck = true;
/*      */   
/*      */   public static int cRegnTime;
/*      */   
/*      */   public static boolean cKillAlgnmntChnge;
/*      */   
/*      */   public static boolean HHWHO;
/*      */   
/*      */   public static boolean OverAtrLimit = false;
/*      */   
/*      */   public static boolean OverAtrLimitO = false;
/*      */   
/*      */   public static boolean forceJBRA;
/*      */   
/*      */   public static String[] sfzna;
/*      */   
/*      */   public static String[] csfzna;
/*      */   
/*      */   public static int cSklMedCat;
/*      */   
/*      */   public static int SklMedCat;
/*      */   
/*      */   public static float cSklMedRate;
/*      */   
/*      */   public static float SklMedRate;
/*      */   
/*      */   public static boolean creleaseStop;
/*      */   
/*      */   public static boolean releaseStop;
/*      */   
/*      */   public static float cTpgnRt;
/*      */   
/*      */   public static float TpgnRt;
/*      */   
/*      */   public static boolean csskai;
/*      */   
/*      */   public static boolean sskai;
/*      */   
/*      */   public static int cStatPasDef;
/*      */   
/*      */   public static int StatPasDef;
/*      */   
/*      */   public static boolean cfuzn;
/*      */   
/*      */   public static boolean fuzn;
/*      */   
/*      */   public static int cmjn;
/*      */   
/*      */   public static int mjn;
/*      */   
/*      */   public static int cselgnd;
/*      */   
/*      */   public static int selgnd;
/*      */   
/*      */   public static int cselgndc;
/*      */   
/*      */   public static int selgndc;
/*      */   
/*      */   public static int cselgndc2;
/*      */   
/*      */   public static int selgndc2;
/*      */   
/*      */   public static int cosbic;
/*      */   
/*      */   public static int osbic;
/*      */   
/*      */   public static int clgnd;
/*      */   
/*      */   public static int lgnd;
/*      */   
/*      */   public static String clgndb;
/*      */   
/*      */   public static String lgndb;
/*      */   
/*      */   public static double cappm;
/*      */   
/*      */   public static double appm;
/*      */   
/*      */   public static double catcm;
/*      */   
/*      */   public static double atcm;
/*      */   public static int chedp;
/*      */   public static int hedp;
/*      */   public static boolean clockon;
/*      */   public static boolean lockon;
/*      */   public static boolean cComHealNAS;
/*      */   public static boolean ComHealNAS;
/*      */   public static boolean cComHealNAC;
/*      */   public static boolean ComHealNAC;
/*      */   public static boolean cComHealNAO;
/*      */   public static boolean ComHealNAO;
/*      */   public static boolean cComTPNAS;
/*      */   public static boolean ComTPNAS;
/*      */   public static boolean cComTPNAC;
/*      */   public static boolean ComTPNAC;
/*      */   public static boolean cComTPNAO;
/*      */   public static boolean ComTPNAO;
/*      */   public static boolean cComANAS;
/*      */   public static boolean ComANAS;
/*      */   public static boolean cComANAC;
/*      */   public static boolean ComANAC;
/*      */   public static boolean cComANAO;
/*      */   public static boolean ComANAO;
/*      */   public static boolean cComSENAS;
/*      */   public static boolean ComSENAS;
/*      */   public static boolean cComSENAC;
/*      */   public static boolean cComSENAO;
/*      */   public static boolean ComSENAC;
/*      */   public static boolean ComSENAO;
/*      */   public static boolean cComMNAS;
/*      */   public static boolean ComMNAS;
/*      */   public static boolean cComMNAC;
/*      */   public static boolean cComMNAO;
/*      */   public static boolean ComMNAC;
/*      */   public static boolean ComMNAO;
/*      */   public static boolean cComRSNAS;
/*      */   public static boolean ComRSNAS;
/*      */   public static boolean cComRSNAC;
/*      */   public static boolean ComRSNAC;
/*      */   public static boolean cComRSNAO;
/*      */   public static boolean ComRSNAO;
/*      */   public static int FznTime;
/*      */   public static int FznOverTime;
/*      */   public static int cuilr;
/*      */   public static int uilr;
/*      */   public static int cuidr;
/*      */   public static int uidr;
/*      */   public static int cuipd;
/*      */   public static int uipd;
/*      */   public static int cuirlr;
/*      */   public static int uirlr;
/*      */   public static double cnfPnchc;
/*      */   public static double ccnfPnchc;
/*      */   static final int attack_types = 9;
/*  235 */   public static boolean[] cdat5695 = new boolean[9];
/*  236 */   public static boolean[] dat5695 = new boolean[9];
/*      */   static final int attack_datas = 3;
/*      */   public static final int ATTACK_SPEED = 0;
/*      */   public static final int ATTACK_DAMAGE = 1;
/*      */   public static final int ATTACK_COST = 2;
/*  241 */   public static double[][] cdat5696 = new double[9][3];
/*  242 */   public static double[][] dat5696 = new double[9][3];
/*      */   
/*      */   public static int cdat5697;
/*      */   
/*      */   public static int dat5697;
/*      */   
/*      */   public static double cdat5698;
/*      */   
/*      */   public static double dat5698;
/*      */   
/*      */   public static double cdat5699;
/*      */   
/*      */   public static double dat5699;
/*      */   
/*      */   public static double cdat5700;
/*      */   
/*      */   public static double dat5700;
/*      */   public static double cdat5701;
/*      */   public static double dat5701;
/*  261 */   public static HashMap<String, Byte> dat5702 = new HashMap<String, Byte>();
/*      */   
/*  263 */   public static HashMap<String, Byte> dat5703 = new HashMap<String, Byte>();
/*      */   
/*      */   public static boolean cdat5704;
/*      */   
/*      */   public static boolean dat5704;
/*      */   
/*      */   public static double cdat5705;
/*      */   public static double dat5705;
/*  271 */   public static boolean[] cdat5706 = new boolean[7];
/*  272 */   public static boolean[] dat5706 = new boolean[7];
/*      */   
/*      */   public static byte cdat5707;
/*      */   
/*      */   public static byte dat5707;
/*      */   
/*  278 */   public static boolean[] cdat5708 = new boolean[2];
/*  279 */   public static boolean[] dat5708 = new boolean[2];
/*      */   
/*      */   public static boolean cdat5710;
/*      */   
/*      */   public static boolean dat5710;
/*  284 */   public static boolean[] cdat5709 = new boolean[9];
/*  285 */   public static boolean[] dat5709 = new boolean[9];
/*      */   
/*      */   public static boolean cdat5711;
/*      */   
/*      */   public static boolean dat5711;
/*      */   
/*      */   public static double cMystTim;
/*      */   
/*      */   public static double MystTim;
/*      */   
/*      */   public static double cFlngspd;
/*      */   
/*      */   public static double Flngspd;
/*      */   
/*      */   public static byte cExtendedPlayerBlockID;
/*      */   public static byte cExtendedPlayerOtherID;
/*      */   public static byte cExtendedPlayerHairID;
/*      */   public static byte ExtendedPlayerBlockID;
/*      */   public static byte ExtendedPlayerOtherID;
/*      */   public static byte ExtendedPlayerHairID;
/*  305 */   public static double[] cKiSizeMin = new double[7], cKiSizeMax = new double[7];
/*  306 */   public static double[] cJutsuSizeMin = new double[3]; public static double[] cJutsuSizeMax = new double[3];
/*  307 */   public static boolean[] cContinuesKiAttacks = new boolean[6]; public static boolean[] cContinuesJutsuAttacks = new boolean[3]; public static boolean cWavesDieWhenTargetAway;
/*      */   public static boolean cWavesShrinkOnceLetGo;
/*      */   public static boolean cKiAttackScalesWithUser;
/*      */   public static boolean cJutsuScalesWithUser;
/*      */   public static String cKiAttackPowerFormula;
/*  312 */   public static double[] KiSizeMin = new double[7], KiSizeMax = new double[7];
/*  313 */   public static double[] JutsuSizeMin = new double[3]; public static double[] JutsuSizeMax = new double[3];
/*  314 */   public static boolean[] ContinuesKiAttacks = new boolean[6]; public static boolean[] ContinuesJutsuAttacks = new boolean[3];
/*      */   public static boolean WavesDieWhenTargetAway;
/*      */   public static boolean WavesShrinkOnceLetGo;
/*      */   public static String KiAttackPowerFormula;
/*      */   public static boolean KiAttackScalesWithUser;
/*      */   public static boolean JutsuScalesWithUser;
/*  320 */   public static int[] cTPGainEnergy = new int[8];
/*  321 */   public static int[] TPGainEnergy = new int[8]; public static int getTPGainEnergy(int type) {
/*  322 */     return (type == 7) ? 1 : ((type == 8) ? TPGainEnergy[type - 1] : TPGainEnergy[type]);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int cContinuesEnergyAttackTimer;
/*      */   public static boolean cContinuesEnergyAttackMoveOnLostTarget;
/*      */   public static boolean cContinuesEnergyAttackEnemyLock;
/*      */   public static int ContinuesEnergyAttackTimer;
/*      */   public static boolean ContinuesEnergyAttackMoveOnLostTarget;
/*      */   public static boolean ContinuesEnergyAttackEnemyLock;
/*      */   public static int cEnergyAttackMaxLifeTick;
/*      */   public static int cEnergyAttackMaxLifeTickPercMulti;
/*      */   public static int EnergyAttackMaxLifeTick;
/*      */   public static int EnergyAttackMaxLifeTickPercMulti;
/*      */   public static boolean cContinuesEnergyAttackTargetSlowdown;
/*      */   public static boolean ContinuesEnergyAttackTargetSlowdown;
/*      */   public static boolean cShieldsMoveWithUser;
/*      */   public static boolean cExplosionsMoveWithUser;
/*      */   public static boolean ShieldsMoveWithUser;
/*      */   public static boolean ExplosionsMoveWithUser;
/*      */   public static int plUpd;
/*      */   public static int cplUpd;
/*      */   public static boolean cPlayerFlyingDragDownOn;
/*      */   public static boolean PlayerFlyingDragDownOn;
/*      */   public static double cExplosionSizeLimit;
/*      */   public static double ExplosionSizeLimit;
/*      */   public static byte KiClosestEntityCheckSize;
/*      */   public static byte cKiClosestEntityCheckSize;
/*      */   public static boolean cCommandNotifyAdminJRMCABonusSelf;
/*      */   public static boolean CommandNotifyAdminJRMCABonusSelf;
/*      */   public static boolean cCommandNotifyAdminJRMCABonusConsole;
/*      */   public static boolean CommandNotifyAdminJRMCABonusConsole;
/*      */   public static boolean cCommandNotifyAdminJRMCABonusOthers;
/*      */   public static boolean CommandNotifyAdminJRMCABonusOthers;
/*      */   public static boolean cJRMCABonusOn;
/*      */   public static boolean JRMCABonusOn;
/*      */   public static boolean cJRMCABonusCheckOnOthersWithoutOP;
/*      */   public static boolean JRMCABonusCheckOnOthersWithoutOP;
/*      */   public static boolean cJRMCCheckOnOthersWithoutOP;
/*      */   public static boolean JRMCCheckOnOthersWithoutOP;
/*      */   public static boolean cShadowDummyScaleToTarget;
/*      */   public static boolean ShadowDummyScaleToTarget;
/*      */   public static byte cSpiralWeakensAfterHit;
/*      */   public static byte SpiralWeakensAfterHit;
/*      */   public static boolean cSpiralWeakensBasedOnStartDamage;
/*      */   public static boolean SpiralWeakensBasedOnStartDamage;
/*      */   public static boolean cCanEatWhileKOd;
/*      */   public static boolean CanEatWhileKOd;
/*      */   public static boolean cCanUseSenzuWhileKOd;
/*      */   public static boolean CanUseSenzuWhileKOd;
/*      */   public static float cGlobalFoodHealMultiHealth;
/*      */   public static float GlobalFoodHealMultiHealth;
/*      */   public static float cGlobalFoodHealMultiEnergy;
/*      */   public static float GlobalFoodHealMultiEnergy;
/*  376 */   public static HashMap<String, float[]> cFoodHealMulti = (HashMap)new HashMap<String, float>(); public static HashMap<String, float[]> FoodHealMulti = (HashMap)new HashMap<String, float>(); public static boolean cBuildingBlocksRenderAsNormalBlock; public static boolean BuildingBlocksRenderAsNormalBlock;
/*      */   public static boolean NCExplosionTagTickTimerExplode;
/*      */   public static boolean cNCExplosionTagTickTimerExplode;
/*      */   public static int NCExplosionTagTickTimer;
/*      */   public static int cNCExplosionTagTickTimer;
/*      */   public static float NCExplosionTagDetectionRange;
/*      */   public static float cNCExplosionTagDetectionRange;
/*      */   public static float NCExplosionTagExplosionSize;
/*      */   public static float cNCExplosionTagExplosionSize;
/*  385 */   public static float[] MysticDamMulti = new float[JRMCoreH.Races.length];
/*  386 */   public static float[] cMysticDamMulti = new float[JRMCoreH.Races.length];
/*      */   
/*  388 */   public static int[] ArcosianPPMax = new int[JRMCoreH.ArcRsrvMaxSkll.length];
/*  389 */   public static int[] cArcosianPPMax = new int[JRMCoreH.ArcRsrvMaxSkll.length];
/*      */   
/*  391 */   public static int[] ArcosianPPGrowth = new int[(JRMCoreH.trans[4]).length + JRMCoreH.transNonRacial.length - 1];
/*  392 */   public static int[] cArcosianPPGrowth = new int[(JRMCoreH.trans[4]).length + JRMCoreH.transNonRacial.length - 1];
/*      */   
/*  394 */   public static int[] ArcosianPPCost = new int[(JRMCoreH.trans[4]).length + JRMCoreH.transNonRacial.length - 1];
/*  395 */   public static int[] cArcosianPPCost = new int[(JRMCoreH.trans[4]).length + JRMCoreH.transNonRacial.length - 1];
/*      */   
/*  397 */   public static float[] ArcosianPPDamMulti = new float[(JRMCoreH.trans[4]).length + JRMCoreH.transNonRacial.length - 1];
/*  398 */   public static float[] cArcosianPPDamMulti = new float[(JRMCoreH.trans[4]).length + JRMCoreH.transNonRacial.length - 1];
/*      */   
/*  400 */   public static float[] ArcosianPPDamMultiPoint = new float[(JRMCoreH.trans[4]).length + JRMCoreH.transNonRacial.length - 1];
/*  401 */   public static float[] cArcosianPPDamMultiPoint = new float[(JRMCoreH.trans[4]).length + JRMCoreH.transNonRacial.length - 1];
/*      */ 
/*      */ 
/*      */   
/*      */   public static int ArcosianPPDamMultiHighest;
/*      */ 
/*      */ 
/*      */   
/*      */   public static int cArcosianPPDamMultiHighest;
/*      */ 
/*      */   
/*  412 */   public static HashMap<String, Boolean> SafeZoneEntityBlacklist = new HashMap<String, Boolean>();
/*  413 */   public static HashMap<String, Boolean> SafeZoneEntityWhitelist = new HashMap<String, Boolean>();
/*      */ 
/*      */   
/*  416 */   public static float[] TPGainRateRace = new float[JRMCoreH.Races.length];
/*  417 */   public static float[] cTPGainRateRace = new float[JRMCoreH.Races.length];
/*  418 */   public static float[] TPGainRace = new float[JRMCoreH.Races.length];
/*  419 */   public static float[] cTPGainRace = new float[JRMCoreH.Races.length];
/*      */ 
/*      */   
/*  422 */   public static final String[] NON_RACIAL_FORMS = new String[] { "Mystic" };
/*      */ 
/*      */   
/*  425 */   public static float[][] KaiokenFormHealthCost = new float[JRMCoreH.Races.length][JRMCoreH.trans.length + NON_RACIAL_FORMS.length];
/*      */   
/*  427 */   public static float[][] cKaiokenFormHealthCost = new float[JRMCoreH.Races.length][JRMCoreH.trans.length + NON_RACIAL_FORMS.length];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  433 */   public static int cAttributeUpgradeCost_StartMinus = 140;
/*  434 */   public static int AttributeUpgradeCost_StartMinus = 140;
/*  435 */   public static int cAttributeUpgradeCost_Min = 16;
/*  436 */   public static int AttributeUpgradeCost_Min = 16;
/*      */   public static final double ATTR_COST_MULTI_D = 0.75D;
/*      */   public static final float ATTR_COST_MULTI_F = 0.75F;
/*  439 */   public static float[] cAttributeUpgradeCost_AttributeMulti = new float[] { 0.75F, 0.75F, 0.75F, 0.75F, 0.75F, 0.75F };
/*  440 */   public static float[] AttributeUpgradeCost_AttributeMulti = new float[] { 0.75F, 0.75F, 0.75F, 0.75F, 0.75F, 0.75F };
/*      */   
/*  442 */   public static float[][] AttibuteBonusPerRacialSkill = new float[JRMCoreH.Races.length][];
/*  443 */   public static float[][] cAttibuteBonusPerRacialSkill = new float[JRMCoreH.Races.length][];
/*      */   
/*      */   public static final int serverPlayerUpdateTick = 100;
/*      */   
/*      */   public static final int serverPlayerUpdateTick_Meditation = 50;
/*      */   
/*      */   public static final int serverPlayerUpdateTick_Data = 10;
/*  450 */   public static int serverPlayerUpdateTick_DataFamilyC = 100;
/*      */   public static boolean runFamilyCDataUpdateAsThread = true;
/*      */   public static final int fusionAttributeMulti = 100;
/*      */   public static final float FUSION_ATTR_MULTI = 2.0F;
/*  454 */   public static final float[] fusionAttributeMultis = new float[] { 2.0F, 2.0F, 2.0F, 2.0F, 2.0F, 2.0F };
/*      */ 
/*      */   
/*      */   public static final float FUSION_MASTERY_MULTI = 1.0F;
/*      */   
/*      */   public static final int regenerationStartTimer = 30;
/*      */ 
/*      */   
/*      */   public static void init(Configuration config) {
/*  463 */     config.load();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  468 */     Property property = config.get("JBRA Configs", "Force JBRA", true);
/*  469 */     property.comment = "Client Sided! If 'true' it will force JBRA over other mods, if 'false' then not.";
/*  470 */     forceJBRA = property.getBoolean(true);
/*      */     
/*  472 */     property = config.get("general", "NPC Spawn Check", true);
/*  473 */     property.comment = "Server Sided! If 'true' NPCs will go through a Check for every player, to make sure they spawned, if 'false' then no check.  (may reduce lag if false)";
/*  474 */     cNPCSpawnCheck = property.getBoolean(true);
/*  475 */     NPCSpawnCheck = cNPCSpawnCheck;
/*      */     
/*  477 */     property = config.get("general", "Building Spawn Check", true);
/*  478 */     property.comment = "Server Sided! If 'true' Buildings will spawn, if 'false' then they will never spawn.  (may reduce lag if false)";
/*  479 */     cBuildingSpawnCheck = property.getBoolean(true);
/*  480 */     BuildingSpawnCheck = cBuildingSpawnCheck;
/*      */     
/*  482 */     Property BuildingSpawnAreaSize = config.get("general", "Blocks Between Random Buildings", 100);
/*  483 */     BuildingSpawnAreaSize.comment = "Server Sided! Size of the Spawn area between random buildings. From default 100 blocks between each other and can be reduced till 20 for more frequent spawns! (from 100 to 20)";
/*  484 */     cbuildingSpawnAreaSize = BuildingSpawnAreaSize.getInt(100);
/*  485 */     if (cbuildingSpawnAreaSize < 20) cbuildingSpawnAreaSize = 20; 
/*  486 */     if (cbuildingSpawnAreaSize > 100) cbuildingSpawnAreaSize = 100; 
/*  487 */     buildingSpawnAreaSize = cbuildingSpawnAreaSize;
/*      */ 
/*      */     
/*  490 */     Property expGriOff1 = config.get("general", "Explosion Griefing Off", false);
/*  491 */     expGriOff1.comment = "Server Sided! If 'false' then Explosion Griefing is on, If 'true' then its off. (may reduce lag if true)";
/*  492 */     cexpGriOff = expGriOff1.getBoolean(false);
/*  493 */     expGriOff = cexpGriOff;
/*      */ 
/*      */     
/*  496 */     Property re = config.get("general", "Energy Regen", true);
/*  497 */     re.comment = "Server Sided! If 'true' then the current Energy Regeneration Over Time will be used, If 'false' then no Energy Regenartion will be made. (may reduce lag if false)";
/*  498 */     cregen = re.getBoolean(true);
/*  499 */     regen = cregen;
/*  500 */     Property hre = config.get("general", "Health Regen", true);
/*  501 */     hre.comment = "Server Sided! If 'true' then the current Health Regeneration Over Time will be used, If 'false' then no Health Regenartion will be made. (may reduce lag if false)";
/*  502 */     hregen = hre.getBoolean(true);
/*  503 */     chregen = hregen;
/*  504 */     Property rer = config.get("general", "Energy Regen Rate", "normal");
/*  505 */     rer.comment = "Server Sided! Energy Rate can be, 'normal', 'slow', 'fast','faster'.";
/*  506 */     cregenRate = rer.getString();
/*  507 */     regenRate = cregenRate;
/*  508 */     rgnRt = cregenRate.equals("slow") ? 1 : (cregenRate.equals("fast") ? 4 : (cregenRate.equals("faster") ? 8 : 2));
/*  509 */     crgnRt = rgnRt;
/*  510 */     Property hrr = config.get("general", "Health Regen Rate", "normal");
/*  511 */     hrr.comment = "Server Sided! Health Regen can be, 'normal', 'slow', 'fast','faster'.";
/*  512 */     chRegenRate = hrr.getString();
/*  513 */     hRegenRate = chRegenRate;
/*  514 */     hRgnRt = chRegenRate.equals("slow") ? 1 : (chRegenRate.equals("fast") ? 4 : (chRegenRate.equals("faster") ? 8 : 2));
/*  515 */     chRgnRt = hRgnRt;
/*  516 */     Property rs = config.get("general", "Power Release", true);
/*  517 */     rs.comment = "Server Sided! If 'true' then the current Power Release will be used with percetage from 0-100%, If 'false' then the power will be always at 50%. (may reduce lag if false)";
/*  518 */     crelease = rs.getBoolean(true);
/*  519 */     release = crelease;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  524 */     Property ac = config.get("general", "Attribute Maximum", 10000);
/*  525 */     ac.comment = "Server Sided! Maximum Attribute a player can have. Maximum Attribute can be set between 100 and 1000000000. USING BIG NUMBERS CAN CAUSE ISSUES.";
/*  526 */     ctmx = ac.getInt();
/*      */ 
/*      */     
/*  529 */     ctmx = (ctmx < 100) ? 100 : ((ctmx > 1000000000) ? 1000000000 : ctmx);
/*  530 */     tmx = ctmx;
/*      */     
/*  532 */     Property hs = config.get("general", "Player Size Change", true);
/*  533 */     hs.comment = "Server Sided! If 'true' then the size of the players will change depending on the attributs as planned, If 'false' then the size of the players will remain the Minecraft default (2 block height and 1 block width)";
/*  534 */     csizes = hs.getBoolean(true);
/*  535 */     sizes = csizes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  541 */     Property ssu = config.get("general", "SSURL", "empty");
/*  542 */     ssu.comment = "Server Sided! Function not available yet, Don't Change!";
/*  543 */     cssurl = ssu.getString();
/*  544 */     ssurl = cssurl;
/*  545 */     Property ssu2 = config.get("general", "SSURL2", "empty");
/*  546 */     ssu2.comment = "Server Sided! Function not available yet, Don't Change!";
/*  547 */     cssurl2 = ssu2.getString();
/*  548 */     ssurl2 = cssurl2;
/*  549 */     Property ssco = config.get("general", "SSC", "empty");
/*  550 */     ssco.comment = "Server Sided! Function not available yet, Don't Change!";
/*  551 */     cssc = ssco.getString();
/*  552 */     ssc = cssc;
/*      */     
/*  554 */     Property sze = config.get("general", "Safe Zones Enabled", true);
/*  555 */     sze.comment = "Server Sided! If 'true' then Safe Zones around main NPCs will be enabled, If 'false' then Safe Zones will be disabled. (may reduce lag if false)";
/*  556 */     csfzns = sze.getBoolean(true);
/*  557 */     sfzns = csfzns;
/*  558 */     String[] da = { "wooden_door", "jinryuudragonblockc:tile.BlockHealingPodDoor", "crafting_table", "lever", "stone_button", "wooden_button" };
/*  559 */     sze = config.get("general", "Safe Zone RightClick Access", da);
/*  560 */     sze.comment = "Server Sided! List the Block names you want to be allowed to right click in Safe Zones. (may reduce lag if empty)";
/*  561 */     csfzna = sze.getStringList();
/*  562 */     sfzna = csfzna;
/*      */     
/*  564 */     Property kiadp = config.get("Energy Attack Configs", "Energy Attack Explosion Intensity", 4);
/*  565 */     kiadp.comment = "Server Sided! Energy Attacks like Ki or Ninjutsu. From 1 to 10 (default: 4) where 1 will get players less lag but ugly explosions and 10 will get players probably the best look but with the most lagg. (lower number will reduce lag)";
/*  566 */     ceaei = kiadp.getInt(4);
/*  567 */     if (ceaei < 1) ceaei = 1; 
/*  568 */     if (ceaei > 10) ceaei = 10; 
/*  569 */     eaei = ceaei;
/*  570 */     kiadp = config.get("Energy Attack Configs", "Energy Attack Explosion Size", 4);
/*  571 */     kiadp.comment = "Server Sided! Energy Attacks like Ki or Ninjutsu. From 0 to 100 (default: 4.0) where 1 will get players less lag but very small explosions and higher number will result in a very large explosion but with the most lagg, use it with caution! (lower number will reduce lag)";
/*  572 */     ceaes = kiadp.getDouble(4.0D);
/*  573 */     if (ceaes < 0.0D) ceaes = 0.0D; 
/*  574 */     if (ceaes > 100.0D) ceaes = 100.0D; 
/*  575 */     eaes = ceaes;
/*  576 */     kiadp = config.get("Energy Attack Configs", "Energy Attack Size Limit", 5);
/*  577 */     kiadp.comment = "Server Sided! Energy Attacks like Ki or Ninjutsu. From 0 to 100 (default: 5). The higher number the larger explosions allowed, the more lagg will happen. 0 means No Limit, use it with caution!";
/*  578 */     ceaesl = kiadp.getInt(5);
/*  579 */     if (ceaesl < 0) ceaesl = 0; 
/*  580 */     if (ceaesl > 100) ceaesl = 100; 
/*  581 */     eaesl = ceaesl;
/*  582 */     kiadp = config.get("Energy Attack Configs", "Energy Attack Density Modifier", 5.0D);
/*  583 */     kiadp.comment = "Server Sided! Energy Attacks like Ki. From 0.0 to 10.0 (default: 5.0). Explosions size with increased density stat will be affected by this modifier! Lower will reduce the explosion size while Higher numbers will increase the size based on density stat. 0 will disable explosions getting large! (lower number will reduce lag)";
/*  584 */     ceadm = (float)kiadp.getDouble(5.0D);
/*  585 */     if (ceadm < 0.0F) ceadm = 0.0F; 
/*  586 */     if (ceadm > 10.0F) ceadm = 10.0F; 
/*  587 */     eadm = ceadm;
/*  588 */     kiadp = config.get("Energy Attack Configs", "Energy Attack Large Blast Size Modifier", 3.0D);
/*  589 */     kiadp.comment = "Server Sided! Energy Attacks like Ki. From 1.0 to 10.0 (default: 3.0). Large Blasts are regular Blasts that have increased Size! Change this modifier to change the Large Blasts Size. (lower number will reduce lag)";
/*  590 */     cealbm = (float)kiadp.getDouble(3.0D);
/*  591 */     if (cealbm < 1.0F) cealbm = 1.0F; 
/*  592 */     if (cealbm > 10.0F) cealbm = 10.0F; 
/*  593 */     ealbm = cealbm;
/*      */     
/*  595 */     Property DebugInfo = config.get("general", "Debug Info", false);
/*  596 */     DebugInfo.comment = "Server Sided! If 'true' the server will print informations like how much TP gained the players and so you will be able to search hackers or rule breakers";
/*  597 */     cDebugInfo = DebugInfo.getBoolean(false);
/*  598 */     JRMCoreConfig.DebugInfo = cDebugInfo;
/*      */     
/*  600 */     DebugInfo = config.get("general", "Player Kill Alignment Changing", true);
/*  601 */     DebugInfo.comment = "Server Sided! If 'true'(default) the PKer will suffer from alignment change depending on the one who was killed what alignment had at the time.";
/*  602 */     cKillAlgnmntChnge = DebugInfo.getBoolean(true);
/*  603 */     KillAlgnmntChnge = cKillAlgnmntChnge;
/*      */     
/*  605 */     DebugInfo = config.get("JBRA Configs", "Hide Hair When Helmet On", true);
/*  606 */     DebugInfo.comment = "Client Sided! If 'true' the you wont see hairs when someone wears a helmet, if 'false' you will always see everyones hair, regarless of helmet. (default: true)";
/*  607 */     HHWHO = DebugInfo.getBoolean(false);
/*      */     
/*  609 */     property = config.get("DBC Server Sided Configs", "Attributes Over Limit", true, "Server Sided! Allow Attributes Over Max Attribute limit with powerups");
/*  610 */     OverAtrLimit = property.getBoolean(true);
/*  611 */     OverAtrLimitO = property.getBoolean(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  625 */     String[] l = { "x2", "x3", "x4", "x5", "x10", "x20" };
/*  626 */     property = config.get("DBC Server Sided Configs", "Skill Kaioken - Name Changer", l, "Server Sided! Change only to your own responsibility!");
/*  627 */     String[] fls = new String[l.length + 1]; fls[0] = "1";
/*  628 */     String[] sa = new String[l.length];
/*  629 */     int len = (property.getStringList()).length;
/*  630 */     String[] s = new String[l.length]; int j;
/*  631 */     for (j = 0; j < l.length; j++) {
/*  632 */       s[j] = l[j];
/*      */     }
/*  634 */     for (j = 0; j < l.length; j++) {
/*  635 */       String str = (len > j) ? property.getStringList()[j] : l[j];
/*  636 */       sa[j] = str;
/*  637 */       fls[j + 1] = str;
/*      */     } 
/*  639 */     JRMCoreH.TransKaiNms = fls;
/*  640 */     JRMCoreH.TransKaiNmsO = fls;
/*  641 */     property.set(sa);
/*      */ 
/*      */     
/*  644 */     int[] i = { 100, 110, 120, 130, 140, 150, 160 };
/*  645 */     s = new String[i.length];
/*  646 */     for (j = 0; j < s.length; j++) {
/*  647 */       s[j] = JRMCoreH.TransKaiNms[j] + " " + i[j];
/*      */     }
/*  649 */     property = config.get("DBC Server Sided Configs", "Skill Kaioken - Damage multiplier", s, "Server Sided! The numbers are meant to be in percetage with the minimum at 10% and maximum at 10000%. Change only to your own responsibility! Having too high multiplier will cause glitches!");
/*      */     
/*  651 */     float[] flt = new float[i.length];
/*  652 */     sa = new String[i.length];
/*  653 */     len = (property.getStringList()).length;
/*  654 */     for (j = 0; j < i.length; j++) {
/*  655 */       int i9 = (len > j) ? Integer.parseInt(property.getStringList()[j].split(" ")[1]) : i[j]; i9 = (i9 < 10) ? 10 : ((i9 > 10000) ? 10000 : i9); i[j] = i9;
/*  656 */       flt[j] = i9 * 0.01F;
/*  657 */       sa[j] = s[j].split(" ")[0] + " " + ((len > j) ? property.getStringList()[j].split(" ")[1] : (String)Integer.valueOf(i[j]));
/*      */     } 
/*  659 */     JRMCoreH.TransKaiDmg = flt;
/*  660 */     JRMCoreH.TransKaiDmgO = flt;
/*  661 */     property.set(sa);
/*      */ 
/*      */ 
/*      */     
/*  665 */     i = new int[] { 100, 100, 100, 100, 100, 100 };
/*  666 */     s = new String[i.length];
/*  667 */     for (j = 0; j < s.length; j++) {
/*  668 */       s[j] = JRMCoreH.Races[j] + " " + i[j];
/*      */     }
/*  670 */     property = config.get("DBC Server Sided Configs", "Skill Kaioken - Race Health Drain multiplier", s, "Server Sided! The numbers are meant to be in percentage. (From 0.0 to 10000.0)%.");
/*  671 */     flt = new float[i.length];
/*  672 */     sa = new String[i.length];
/*  673 */     len = (property.getStringList()).length;
/*  674 */     for (j = 0; j < i.length; j++) {
/*  675 */       int i9 = (len > j) ? Integer.parseInt(property.getStringList()[j].split(" ")[1]) : i[j]; i9 = (i9 < 0) ? 0 : ((i9 > 10000) ? 10000 : i9); i[j] = i9;
/*  676 */       flt[j] = i9 * 0.01F;
/*  677 */       sa[j] = s[j].split(" ")[0] + " " + ((len > j) ? property.getStringList()[j].split(" ")[1] : (String)Integer.valueOf(i[j]));
/*      */     } 
/*  679 */     JRMCoreH.TransKaiDrainRace = flt;
/*  680 */     JRMCoreH.TransKaiDrainORace = flt;
/*  681 */     property.set(sa);
/*      */ 
/*      */ 
/*      */     
/*  685 */     i = new int[] { 50, 50, 50, 50, 50, 50, 50 };
/*  686 */     s = new String[i.length];
/*  687 */     for (j = 0; j < s.length; j++) {
/*  688 */       s[j] = "" + i[j];
/*      */     }
/*  690 */     property = config.get("DBC Server Sided Configs", "Skill Kaioken - Level Health Drain multiplier", s, "Server Sided! The numbers are meant to be in percentage. (From 0.0 to 10000.0)%.");
/*  691 */     flt = new float[i.length];
/*      */     
/*  693 */     len = (property.getStringList()).length;
/*  694 */     for (j = 0; j < i.length; j++) {
/*  695 */       int i9 = (len > j) ? Integer.parseInt(property.getStringList()[j]) : i[j]; i9 = (i9 < 0) ? 0 : ((i9 > 10000) ? 10000 : i9); i[j] = i9;
/*  696 */       flt[j] = i9 * 0.01F;
/*      */     } 
/*      */     
/*  699 */     JRMCoreH.TransKaiDrainLevel = flt;
/*  700 */     JRMCoreH.TransKaiDrainOLevel = flt;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  705 */     i = new int[] { -1, -1, -1, -1, -1, -1 };
/*  706 */     s = new String[i.length];
/*  707 */     for (j = 0; j < s.length; j++) {
/*  708 */       s[j] = JRMCoreH.Races[j] + " " + i[j];
/*      */     }
/*  710 */     property = config.get("DBC Server Sided Configs", "Skill OldKaiUnlock damage multiplier", s, "Server Sided! Mystic Form damage multiplier. -1 = Use old System (Power based off on Racial Skill level and power). The numbers are meant to be in percentage. (From 10.0 to 10000.0)%.");
/*      */     
/*  712 */     flt = new float[i.length];
/*  713 */     sa = new String[i.length];
/*  714 */     len = (property.getStringList()).length;
/*  715 */     for (j = 0; j < i.length; j++) {
/*  716 */       int i9 = (len > j) ? Integer.parseInt(property.getStringList()[j].split(" ")[1]) : i[j]; i9 = (i9 < 10 && i9 != -1) ? 10 : ((i9 > 10000) ? 10000 : i9); i[j] = i9;
/*  717 */       flt[j] = i9 * ((i9 == -1) ? 1.0F : 0.01F);
/*  718 */       sa[j] = s[j].split(" ")[0] + " " + ((len > j) ? property.getStringList()[j].split(" ")[1] : (String)Integer.valueOf(i[j]));
/*      */     } 
/*  720 */     MysticDamMulti = flt;
/*  721 */     cMysticDamMulti = flt;
/*  722 */     property.set(sa);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  729 */     i = JRMCoreH.ArcRsrvMaxSkll;
/*  730 */     s = new String[i.length];
/*  731 */     for (j = 0; j < s.length; j++) {
/*  732 */       s[j] = "" + i[j];
/*      */     }
/*  734 */     property = config.get("DBC Server Sided Configs", "Racial Skill Arcosian - Power Point Max", s, "Server Sided! Arcosian Power Reserver Max. (From 0 to 1000000000).");
/*      */     
/*  736 */     int[] flt3 = new int[i.length];
/*  737 */     len = (property.getStringList()).length;
/*  738 */     int highest = 0;
/*  739 */     cArcosianPPDamMultiHighest = 0; int m;
/*  740 */     for (m = 0; m < i.length; m++) {
/*  741 */       int value = (len > m) ? Integer.parseInt(property.getStringList()[m]) : i[m];
/*  742 */       value = (value < 0) ? 0 : ((value > 1000000000) ? 1000000000 : value);
/*  743 */       flt3[m] = value;
/*  744 */       if (value > highest) {
/*  745 */         highest = value;
/*  746 */         cArcosianPPDamMultiHighest = m;
/*      */       } 
/*      */     } 
/*  749 */     ArcosianPPMax = flt3;
/*  750 */     cArcosianPPMax = flt3;
/*  751 */     ArcosianPPDamMultiHighest = cArcosianPPDamMultiHighest;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  756 */     i = JRMCoreH.ArcRsrvGrowth;
/*  757 */     s = new String[i.length];
/*  758 */     for (m = 0; m < s.length; m++) {
/*  759 */       int forms = (JRMCoreH.trans[4]).length;
/*  760 */       s[m] = ((m - forms + 1 > 0) ? JRMCoreH.transNonRacial[m - forms + 1] : JRMCoreH.trans[4][m]) + " " + i[m];
/*      */     } 
/*  762 */     property = config.get("DBC Server Sided Configs", "Racial Skill Arcosian - Power Point Growth (for Build 1.131 and above)", s, "Server Sided! Arcosian Power Reserver Gain. (0 = Disabled) (From 0 to 1000000000).");
/*      */     
/*  764 */     flt3 = new int[i.length];
/*  765 */     len = (property.getStringList()).length;
/*  766 */     for (m = 0; m < i.length; m++) {
/*  767 */       int value = (len > m) ? Integer.parseInt(property.getStringList()[m].split(" ")[1]) : i[m];
/*  768 */       value = (value < 0) ? 0 : ((value > 1000000000) ? 1000000000 : value);
/*  769 */       flt3[m] = value;
/*      */     } 
/*  771 */     ArcosianPPGrowth = flt3;
/*  772 */     cArcosianPPGrowth = flt3;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  777 */     i = JRMCoreH.ArcRsrvPowCst;
/*  778 */     s = new String[i.length];
/*  779 */     for (m = 0; m < s.length; m++) {
/*  780 */       int forms = (JRMCoreH.trans[4]).length;
/*  781 */       s[m] = ((m - forms + 1 > 0) ? JRMCoreH.transNonRacial[m - forms + 1] : JRMCoreH.trans[4][m]) + " " + i[m];
/*      */     } 
/*  783 */     property = config.get("DBC Server Sided Configs", "Racial Skill Arcosian - Power Point Cost (for Build 1.131 and above)", s, "Server Sided! Arcosian Power Reserver Cost. (0 = Disabled). (From 0 to 1000000000).");
/*      */     
/*  785 */     flt3 = new int[i.length];
/*  786 */     len = (property.getStringList()).length;
/*  787 */     for (m = 0; m < i.length; m++) {
/*  788 */       int value = (len > m) ? Integer.parseInt(property.getStringList()[m].split(" ")[1]) : i[m];
/*  789 */       value = (value < 0) ? 0 : ((value > 1000000000) ? 1000000000 : value);
/*  790 */       flt3[m] = value;
/*      */     } 
/*  792 */     ArcosianPPCost = flt3;
/*  793 */     cArcosianPPCost = flt3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  799 */     double[] i2 = { 1.0D, 1.0D, 1.0D, 1.0D, 1.15D, 1.15D, 1.15D, 1.15D, 1.15D, 1.15D, 1.15D };
/*  800 */     s = new String[i2.length];
/*  801 */     for (m = 0; m < s.length; m++) {
/*  802 */       int forms = (JRMCoreH.trans[4]).length;
/*  803 */       s[m] = ((m - forms + 1 > 0) ? JRMCoreH.transNonRacial[m - forms + 1] : JRMCoreH.trans[4][m]) + " " + i2[m];
/*      */     } 
/*  805 */     property = config.get("DBC Server Sided Configs", "Racial Skill Arcosian - Power Point damage multiplier (for Build 1.131 and above)", s, "Server Sided! Arcosian Power Reserver Damage Multiplier (From 0 to 1000000).");
/*      */     
/*  807 */     flt = new float[i2.length];
/*  808 */     len = (property.getStringList()).length;
/*  809 */     for (m = 0; m < i2.length; m++) {
/*  810 */       float value = (float)((len > m) ? Float.parseFloat(property.getStringList()[m].split(" ")[1]) : i2[m]);
/*  811 */       value = (value < 0.0F) ? 0.0F : ((value > 1000000.0F) ? 1000000.0F : value);
/*  812 */       flt[m] = value;
/*      */     } 
/*  814 */     ArcosianPPDamMulti = flt;
/*  815 */     cArcosianPPDamMulti = flt;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  821 */     i2 = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D };
/*  822 */     s = new String[i2.length];
/*  823 */     for (m = 0; m < s.length; m++) {
/*  824 */       int forms = (JRMCoreH.trans[4]).length;
/*  825 */       s[m] = ((m - forms + 1 > 0) ? JRMCoreH.transNonRacial[m - forms + 1] : JRMCoreH.trans[4][m]) + " " + i2[m];
/*      */     } 
/*  827 */     property = config.get("DBC Server Sided Configs", "Racial Skill Arcosian - Power Point damage multiplier from Points (for Build 1.131 and above)", s, "Server Sided! Arcosian Power Reserver Damage Multiplier based off on Points (-1 = Disabled)\nDefault Example: (0 Points = (1 + 0) * 1.15, max Points (2500) = This Config's Value (1 + 1) * 1.15) (From 0 to 1000000).");
/*      */ 
/*      */     
/*  830 */     flt = new float[i2.length];
/*  831 */     len = (property.getStringList()).length;
/*  832 */     for (m = 0; m < i2.length; m++) {
/*  833 */       float value = (float)((len > m) ? Float.parseFloat(property.getStringList()[m].split(" ")[1]) : i2[m]);
/*  834 */       value = (value < 0.0F && value != -1.0F) ? 0.0F : ((value > 1000000.0F) ? 1000000.0F : value);
/*  835 */       flt[m] = value;
/*      */     } 
/*  837 */     ArcosianPPDamMultiPoint = flt;
/*  838 */     cArcosianPPDamMultiPoint = flt;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  884 */     double[][] AttibuteBonusPerRacialSkillFinals = { { 0.0D, 0.1D, 0.1D, 0.0D, 0.1D }, { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { 0.0D, 0.1D, 0.1D, 0.0D, 0.12D }, { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.01D, 0.01D, 0.0D, 0.02D }, { 0.0D, 0.075D, 0.075D, 0.075D, 0.0D, 0.12D } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  894 */     for (int raceID = 0; raceID < JRMCoreH.Races.length; raceID++) {
/*      */       
/*  896 */       int nonRacialForms = NON_RACIAL_FORMS.length;
/*  897 */       int racialForms = (JRMCoreH.trans[raceID]).length;
/*  898 */       i2 = new double[racialForms + nonRacialForms]; int i9;
/*  899 */       for (i9 = 0; i9 < i2.length; i9++) {
/*  900 */         i2[i9] = 100.0D;
/*      */       }
/*  902 */       s = new String[i2.length];
/*  903 */       for (i9 = 0; i9 < s.length; i9++) {
/*  904 */         s[i9] = ((i9 < racialForms) ? JRMCoreH.trans[raceID][i9] : NON_RACIAL_FORMS[i9 - racialForms]) + " " + (int)i2[i9];
/*      */       }
/*  906 */       property = config.get("DBC Server Sided Configs", "Skill Kaioken - " + JRMCoreH.Races[raceID] + " Race Form Health Drain multiplier", s, "Server Sided! The numbers are meant to be in percentage. (From 0.0 to 1000000.0)%.");
/*  907 */       flt = new float[i2.length];
/*  908 */       sa = new String[i2.length];
/*  909 */       len = (property.getStringList()).length;
/*  910 */       for (i9 = 0; i9 < i2.length; i9++) {
/*  911 */         float value = (float)((len > i9) ? Double.parseDouble(property.getStringList()[i9].split(" ")[1]) : i2[i9]);
/*  912 */         value = (value < 0.0F) ? 0.0F : ((value > 1000000.0F) ? 1000000.0F : value);
/*  913 */         i2[i9] = value;
/*  914 */         flt[i9] = value * 0.01F;
/*  915 */         sa[i9] = s[i9].split(" ")[0] + " " + ((len > i9) ? property.getStringList()[i9].split(" ")[1] : (String)Double.valueOf(i2[i9]));
/*      */       } 
/*  917 */       KaiokenFormHealthCost[raceID] = flt;
/*  918 */       cKaiokenFormHealthCost[raceID] = flt;
/*  919 */       property.set(sa);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  928 */       i2 = new double[racialForms + NON_RACIAL_FORMS.length];
/*  929 */       for (i9 = 0; i9 < i2.length; i9++) {
/*  930 */         i2[i9] = AttibuteBonusPerRacialSkillFinals[raceID][i9];
/*      */       }
/*  932 */       s = new String[i2.length];
/*  933 */       for (i9 = 0; i9 < s.length; i9++) {
/*  934 */         int forms = (JRMCoreH.trans[raceID]).length;
/*  935 */         s[i9] = ((i9 - forms >= 0) ? NON_RACIAL_FORMS[i9 - forms] : JRMCoreH.trans[raceID][i9]) + " " + i2[i9];
/*      */       } 
/*  937 */       property = config.get("DBC Server Sided Configs", JRMCoreH.Races[raceID] + " Race Bonus Attribute Multiplier Per Racial Skill Level", s, "Server Sided! This System was originally only for Humans, Namekians and Majins to balance their Form Attribute multipliers with Saiyans due to only having a few Forms (From 0.0 to 1000000).");
/*      */       
/*  939 */       flt = new float[i2.length];
/*  940 */       len = (property.getStringList()).length;
/*  941 */       for (i9 = 0; i9 < i2.length; i9++) {
/*  942 */         float value = (float)((len > i9) ? Double.parseDouble(property.getStringList()[i9].split(" ")[1]) : i2[i9]);
/*  943 */         value = (value < 0.0F) ? 0.0F : ((value > 1000000.0F) ? 1000000.0F : value);
/*  944 */         i2[i9] = value;
/*  945 */         flt[i9] = value;
/*      */       } 
/*  947 */       AttibuteBonusPerRacialSkill[raceID] = flt;
/*  948 */       cAttibuteBonusPerRacialSkill[raceID] = flt;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  955 */     String[] TransKaiNms = { "UI" };
/*  956 */     i = new int[] { 300 };
/*  957 */     s = new String[i.length]; int n;
/*  958 */     for (n = 0; n < s.length; n++) {
/*  959 */       s[n] = TransKaiNms[n] + " " + i[n];
/*      */     }
/*  961 */     property = config.get("DBC Server Sided Configs", "Skill Ultra Instinct - Attribute multiplier", s, "(UNUSED!) Server Sided! The numbers are meant to be in percetage with the minimum at 10% and maximum at 100000%. Change only to your own responsibility! Having too high multiplier will cause glitches!");
/*      */     
/*  963 */     flt = new float[i.length];
/*  964 */     sa = new String[i.length];
/*  965 */     len = (property.getStringList()).length;
/*  966 */     for (n = 0; n < i.length; n++) {
/*  967 */       int i9 = (len > n) ? Integer.parseInt(property.getStringList()[n].split(" ")[1]) : i[n]; i9 = (i9 < 10) ? 10 : ((i9 > 100000) ? 100000 : i9); i[n] = i9;
/*  968 */       flt[n] = i9 * 0.01F;
/*  969 */       sa[n] = s[n].split(" ")[0] + " " + ((len > n) ? property.getStringList()[n].split(" ")[1] : (String)Integer.valueOf(i[n]));
/*      */     } 
/*  971 */     JRMCoreH.TransMngDmg = flt;
/*  972 */     JRMCoreH.TransMngDmgO = flt;
/*  973 */     property.set(sa);
/*      */ 
/*      */     
/*  976 */     i = new int[] { 100, 180, 220, 240, 200, 270, 300, 130, 210, 320, 360, 330, 220, 270, 330, 380 };
/*  977 */     s = new String[i.length];
/*  978 */     for (n = 0; n < s.length; n++) {
/*  979 */       s[n] = JRMCoreH.trans[1][n] + " " + i[n];
/*      */     }
/*  981 */     property = config.get("DBC Server Sided Configs", "Racial Skill Saiyan - Damage multiplier", s, "Server Sided! The numbers are meant to be in percetage with the minimum at 10% and maximum at 100,000%. Change only to your own responsibility! Having too high multiplier will cause glitches!");
/*      */     
/*  983 */     float[][] flt2 = new float[i.length][6];
/*  984 */     sa = new String[i.length];
/*  985 */     len = (property.getStringList()).length; int i1;
/*  986 */     for (i1 = 0; i1 < i.length; i1++) {
/*  987 */       for (int j2 = 0; j2 < 6; j2++) {
/*  988 */         int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < 10) ? 10 : ((i9 > 100000) ? 100000 : i9); i[i1] = i9;
/*  989 */         flt2[i1][j2] = i9 * ((i1 == 3 && j2 == 1) ? 0.88F : 1.0F) * 0.01F;
/*      */         
/*  991 */         sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */       } 
/*      */     } 
/*  994 */     JRMCoreH.TransSaiStBnP = flt2;
/*  995 */     JRMCoreH.TransSaiStBnPO = flt2;
/*  996 */     property.set(sa);
/*      */ 
/*      */     
/*  999 */     i = new int[] { 100, 180, 220, 240, 200, 270, 300, 130, 210, 320, 360, 330, 220, 270, 330, 380 };
/* 1000 */     s = new String[i.length];
/* 1001 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1002 */       s[i1] = JRMCoreH.trans[1][i1] + " " + i[i1];
/*      */     }
/* 1004 */     property = config.get("DBC Server Sided Configs", "Racial Skill Half-Saiyan - Damage multiplier", s, "Server Sided! The numbers are meant to be in percetage with the minimum at 10% and maximum at 100,000%. Change only to your own responsibility! Having too high multiplier will cause glitches!");
/*      */     
/* 1006 */     flt2 = new float[i.length][6];
/* 1007 */     sa = new String[i.length];
/* 1008 */     len = (property.getStringList()).length;
/* 1009 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1010 */       for (int j2 = 0; j2 < 6; j2++) {
/* 1011 */         int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < 10) ? 10 : ((i9 > 100000) ? 100000 : i9); i[i1] = i9;
/* 1012 */         flt2[i1][j2] = i9 * ((i1 == 3 && j2 == 1) ? 0.88F : 1.0F) * 0.01F;
/*      */         
/* 1014 */         sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */       } 
/*      */     } 
/* 1017 */     JRMCoreH.TransHalfSaiStBnP = flt2;
/* 1018 */     JRMCoreH.TransHalfSaiStBnPO = flt2;
/* 1019 */     property.set(sa);
/*      */ 
/*      */     
/* 1022 */     i = new int[] { 30, 40, 60, 80, 100, 220, 270, 360 };
/* 1023 */     s = new String[i.length];
/* 1024 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1025 */       s[i1] = JRMCoreH.trans[4][i1] + " " + i[i1];
/*      */     }
/* 1027 */     property = config.get("DBC Server Sided Configs", "Racial Skill Arcosian - Damage multiplier", s, "Server Sided! The numbers are meant to be in percetage with the minimum at 10% and maximum at 100,000%. Change only to your own responsibility! Having too high multiplier will cause glitches!");
/*      */     
/* 1029 */     flt2 = new float[i.length][6];
/* 1030 */     sa = new String[i.length];
/* 1031 */     len = (property.getStringList()).length;
/* 1032 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1033 */       for (int j2 = 0; j2 < 6; j2++) {
/* 1034 */         int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < 10) ? 10 : ((i9 > 100000) ? 100000 : i9); i[i1] = i9;
/* 1035 */         flt2[i1][j2] = i9 * ((i1 == 3 && j2 == 1) ? 0.88F : 1.0F) * 0.01F;
/* 1036 */         sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */       } 
/*      */     } 
/* 1039 */     JRMCoreH.TransFrStBnP = flt2;
/* 1040 */     JRMCoreH.TransFrStBnPO = flt2;
/* 1041 */     property.set(sa);
/*      */     
/* 1043 */     i = new int[] { 100, 170, 200, 310 };
/* 1044 */     s = new String[i.length];
/* 1045 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1046 */       s[i1] = JRMCoreH.trans[0][i1] + " " + i[i1];
/*      */     }
/* 1048 */     property = config.get("DBC Server Sided Configs", "Racial Skill Human - Damage multiplier", s, "Server Sided! The numbers are meant to be in percetage with the minimum at 10% and maximum at 100,000%. Change only to your own responsibility! Having too high multiplier will cause glitches!");
/*      */     
/* 1050 */     flt2 = new float[i.length][6];
/* 1051 */     sa = new String[i.length];
/* 1052 */     len = (property.getStringList()).length;
/* 1053 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1054 */       for (int j2 = 0; j2 < 6; j2++) {
/* 1055 */         int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < 10) ? 10 : ((i9 > 100000) ? 100000 : i9); i[i1] = i9;
/* 1056 */         float sc = 1.0F;
/* 1057 */         if (i1 == 2 && j2 == 1) { sc = 0.8F; }
/* 1058 */         else if (i1 != 0 && j2 == 1) { sc = 1.131F; }
/*      */         
/* 1060 */         flt2[i1][j2] = i9 * sc * 0.01F;
/* 1061 */         sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */       } 
/*      */     } 
/* 1064 */     JRMCoreH.TransHmStBnP = flt2;
/* 1065 */     JRMCoreH.TransHmStBnPO = flt2;
/* 1066 */     property.set(sa);
/*      */     
/* 1068 */     i = new int[] { 100, 170, 200, 310 };
/* 1069 */     s = new String[i.length];
/* 1070 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1071 */       s[i1] = JRMCoreH.trans[3][i1] + " " + i[i1];
/*      */     }
/* 1073 */     property = config.get("DBC Server Sided Configs", "Racial Skill Namekian - Damage multiplier", s, "Server Sided! The numbers are meant to be in percetage with the minimum at 10% and maximum at 100,000%. Change only to your own responsibility! Having too high multiplier will cause glitches!");
/*      */     
/* 1075 */     flt2 = new float[i.length][6];
/* 1076 */     sa = new String[i.length];
/* 1077 */     len = (property.getStringList()).length;
/* 1078 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1079 */       for (int j2 = 0; j2 < 6; j2++) {
/* 1080 */         int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < 10) ? 10 : ((i9 > 100000) ? 100000 : i9); i[i1] = i9;
/* 1081 */         float sc = 1.0F;
/* 1082 */         if (i1 == 2 && j2 == 1) { sc = 0.8F; }
/* 1083 */         else if (i1 == 2 && j2 == 3) { sc = 1.0F; }
/* 1084 */         else if (i1 != 0 && j2 == 3) { sc = 1.131F; }
/*      */         
/* 1086 */         flt2[i1][j2] = i9 * sc * 0.01F;
/* 1087 */         sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */       } 
/*      */     } 
/* 1090 */     JRMCoreH.TransNaStBnP = flt2;
/* 1091 */     JRMCoreH.TransNaStBnPO = flt2;
/* 1092 */     property.set(sa);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1097 */     i = new int[] { 100, 160, 200, 175, 280 };
/* 1098 */     s = new String[i.length];
/* 1099 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1100 */       s[i1] = JRMCoreH.trans[5][i1] + " " + i[i1];
/*      */     }
/* 1102 */     property = config.get("DBC Server Sided Configs", "Racial Skill Majin - Damage multiplier", s, "Server Sided! The numbers are meant to be in percetage with the minimum at 10% and maximum at 100,000%. Change only to your own responsibility! Having too high multiplier will cause glitches!");
/*      */     
/* 1104 */     flt2 = new float[i.length][6];
/* 1105 */     sa = new String[i.length];
/* 1106 */     len = (property.getStringList()).length;
/* 1107 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1108 */       for (int j2 = 0; j2 < 6; j2++) {
/* 1109 */         int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < 10) ? 10 : ((i9 > 100000) ? 100000 : i9); i[i1] = i9;
/* 1110 */         float sc = 1.0F;
/*      */ 
/*      */ 
/*      */         
/* 1114 */         flt2[i1][j2] = i9 * sc * 0.01F;
/* 1115 */         sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1131 */     JRMCoreH.TransMaStBnP = flt2;
/* 1132 */     JRMCoreH.TransMaStBnPO = flt2;
/* 1133 */     property.set(sa);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1138 */     i = new int[] { 100, -20, -30, -40, -5, -20, -100, -10, -40, -20, -40, -30, -20, -20, -50, -40 };
/* 1139 */     s = new String[i.length];
/* 1140 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1141 */       s[i1] = JRMCoreH.trans[1][i1] + " " + i[i1];
/*      */     }
/* 1143 */     property = config.get("DBC Server Sided Configs", "Racial Skill Saiyan - Ki Regeneration multipliers", s, "Server Sided! The numbers are meant to be in percetage with the minimum at -1000% and maximum at 1000%. The negatives mean those are the transformation ki costs! Also percentages are still based on Power bonus amount.");
/*      */ 
/*      */ 
/*      */     
/* 1147 */     flt = new float[i.length];
/* 1148 */     sa = new String[i.length];
/* 1149 */     len = (property.getStringList()).length;
/* 1150 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1151 */       int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < -1000) ? -1000 : ((i9 > 1000) ? 1000 : i9); i[i1] = i9; flt[i1] = i9 * 0.01F;
/* 1152 */       sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */     } 
/* 1154 */     JRMCoreH.TransSaiRgn = flt;
/* 1155 */     JRMCoreH.TransSaiRgnO = flt;
/* 1156 */     property.set(sa);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1161 */     i = new int[] { 100, -20, -30, -40, -5, -20, -100, -10, -40, -20, -40, -30, -20, -20, -50, -40 };
/* 1162 */     s = new String[i.length];
/* 1163 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1164 */       s[i1] = JRMCoreH.trans[1][i1] + " " + i[i1];
/*      */     }
/* 1166 */     property = config.get("DBC Server Sided Configs", "Racial Skill Half-Saiyan - Ki Regeneration multipliers", s, "Server Sided! The numbers are meant to be in percetage with the minimum at -1000% and maximum at 1000%. The negatives mean those are the transformation ki costs! Also percentages are still based on Power bonus amount.");
/*      */ 
/*      */ 
/*      */     
/* 1170 */     flt = new float[i.length];
/* 1171 */     sa = new String[i.length];
/* 1172 */     len = (property.getStringList()).length;
/* 1173 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1174 */       int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < -1000) ? -1000 : ((i9 > 1000) ? 1000 : i9); i[i1] = i9; flt[i1] = i9 * 0.01F;
/* 1175 */       sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */     } 
/* 1177 */     JRMCoreH.TransHalfSaiRgn = flt;
/* 1178 */     JRMCoreH.TransHalfSaiRgnO = flt;
/* 1179 */     property.set(sa);
/*      */ 
/*      */     
/* 1182 */     i = new int[] { 300, 250, 200, 150, 100, -50, -100, -40 };
/* 1183 */     s = new String[i.length];
/* 1184 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1185 */       s[i1] = JRMCoreH.trans[4][i1] + " " + i[i1];
/*      */     }
/* 1187 */     property = config.get("DBC Server Sided Configs", "Racial Skill Arcosian - Ki Regeneration multipliers", s, "Server Sided! The numbers are meant to be in percetage with the minimum at -1000% and maximum at 1000% The negatives mean those are the transformation ki costs! Also percentages are still based on Power bonus amount.");
/*      */ 
/*      */ 
/*      */     
/* 1191 */     flt = new float[i.length];
/* 1192 */     sa = new String[i.length];
/* 1193 */     len = (property.getStringList()).length;
/* 1194 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1195 */       int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < -1000) ? -1000 : ((i9 > 1000) ? 1000 : i9); i[i1] = i9;
/* 1196 */       flt[i1] = i9 * 0.01F;
/* 1197 */       sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */     } 
/* 1199 */     JRMCoreH.TransFrRgn = flt;
/* 1200 */     JRMCoreH.TransFrRgnO = flt;
/* 1201 */     property.set(sa);
/*      */     
/* 1203 */     i = new int[] { 100, -50, -25, -20 };
/* 1204 */     s = new String[i.length];
/* 1205 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1206 */       s[i1] = JRMCoreH.trans[0][i1] + " " + i[i1];
/*      */     }
/* 1208 */     property = config.get("DBC Server Sided Configs", "Racial Skill Human - Ki Regeneration multipliers", s, "Server Sided! The numbers are meant to be in percetage with the minimum at -1000% and maximum at 1000% The negatives mean those are the transformation ki costs! Also percentages are still based on Power bonus amount.");
/*      */ 
/*      */ 
/*      */     
/* 1212 */     flt = new float[i.length];
/* 1213 */     sa = new String[i.length];
/* 1214 */     len = (property.getStringList()).length;
/* 1215 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1216 */       int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < -1000) ? -1000 : ((i9 > 1000) ? 1000 : i9); i[i1] = i9;
/* 1217 */       flt[i1] = i9 * 0.01F;
/* 1218 */       sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */     } 
/* 1220 */     JRMCoreH.TransHmRgn = flt;
/* 1221 */     JRMCoreH.TransHmRgnO = flt;
/* 1222 */     property.set(sa);
/*      */     
/* 1224 */     i = new int[] { 100, -50, -25, -20 };
/* 1225 */     s = new String[i.length];
/* 1226 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1227 */       s[i1] = JRMCoreH.trans[3][i1] + " " + i[i1];
/*      */     }
/* 1229 */     property = config.get("DBC Server Sided Configs", "Racial Skill Namekian - Ki Regeneration multipliers", s, "Server Sided! The numbers are meant to be in percetage with the minimum at -1000% and maximum at 1000% The negatives mean those are the transformation ki costs! Also percentages are still based on Power bonus amount.");
/*      */ 
/*      */ 
/*      */     
/* 1233 */     flt = new float[i.length];
/* 1234 */     sa = new String[i.length];
/* 1235 */     len = (property.getStringList()).length;
/* 1236 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1237 */       int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < -1000) ? -1000 : ((i9 > 1000) ? 1000 : i9); i[i1] = i9;
/* 1238 */       flt[i1] = i9 * 0.01F;
/* 1239 */       sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */     } 
/* 1241 */     JRMCoreH.TransNaRgn = flt;
/* 1242 */     JRMCoreH.TransNaRgnO = flt;
/* 1243 */     property.set(sa);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1248 */     i = new int[] { 100, 0, 0, 50, -20 };
/* 1249 */     s = new String[i.length];
/* 1250 */     for (i1 = 0; i1 < s.length; i1++) {
/* 1251 */       s[i1] = JRMCoreH.trans[5][i1] + " " + i[i1];
/*      */     }
/* 1253 */     property = config.get("DBC Server Sided Configs", "Racial Skill Majin - Ki Regeneration multipliers", s, "Server Sided! The numbers are meant to be in percetage with the minimum at -1000% and maximum at 1000% The negatives mean those are the transformation ki costs! Also percentages are still based on Power bonus amount.");
/*      */ 
/*      */ 
/*      */     
/* 1257 */     flt = new float[i.length];
/* 1258 */     sa = new String[i.length];
/* 1259 */     len = (property.getStringList()).length;
/* 1260 */     for (i1 = 0; i1 < i.length; i1++) {
/* 1261 */       int i9 = (len > i1) ? Integer.parseInt(property.getStringList()[i1].split(" ")[1]) : i[i1]; i9 = (i9 < -1000) ? -1000 : ((i9 > 1000) ? 1000 : i9); i[i1] = i9;
/* 1262 */       flt[i1] = i9 * 0.01F;
/* 1263 */       sa[i1] = s[i1].split(" ")[0] + " " + ((len > i1) ? property.getStringList()[i1].split(" ")[1] : (String)Integer.valueOf(i[i1]));
/*      */     } 
/* 1265 */     JRMCoreH.TransMaRgn = flt;
/* 1266 */     JRMCoreH.TransMaRgnO = flt;
/* 1267 */     property.set(sa);
/*      */ 
/*      */ 
/*      */     
/* 1271 */     property = config.get("general", "Skill Meditation - category", "active");
/* 1272 */     property.comment = "Server Sided! It can be either 'passive' or 'active'. If it is 'passive' upgrading this skill will increase the regen rate for Body, Energy and Stamina (Survival Oriented). If it is 'active' upgrading this skill will only work if Release key is pressed and basicly functions as an energy recharge (Fighter/Console Oriented)";
/*      */ 
/*      */     
/* 1275 */     String tempcSklMedCat = property.getString();
/* 1276 */     cSklMedCat = tempcSklMedCat.equals("active") ? 0 : 1;
/* 1277 */     SklMedCat = cSklMedCat;
/*      */     
/* 1279 */     property = config.get("general", "Skill Meditation - max rate at lvl 10", 75);
/* 1280 */     property.comment = "Server Sided! The maximum rate at skill level 10 in percentage. Rate can be from 0 to 500 (default: 75) It will increase the regen or recharge with the max rate devided by 10 multiplied with skill level. (default 50% max rate at lvl 1 will become 5%)";
/*      */     
/* 1282 */     cSklMedRate = property.getInt() * 0.01F;
/* 1283 */     if (cSklMedRate < 0.0F) cSklMedRate = 0.0F; 
/* 1284 */     if (cSklMedRate > 5.0F) cSklMedRate = 5.0F; 
/* 1285 */     SklMedRate = cSklMedRate;
/*      */     
/* 1287 */     property = config.get("general", "Power Release - Still Stand", true);
/* 1288 */     property.comment = "Server Sided! If 'true' then people wont be able to move while Releasing, If 'false' then players can move while Releasing";
/* 1289 */     creleaseStop = property.getBoolean(true);
/* 1290 */     releaseStop = creleaseStop;
/*      */     
/* 1292 */     property = config.get("general", "Training Point Gain - TP amount gained", 2);
/* 1293 */     property.comment = "Server Sided! Tp gain can be, from 1 to 100. (default: 2)";
/* 1294 */     ctpgn = property.getInt();
/* 1295 */     if (ctpgn < 0) ctpgn = 0; 
/* 1296 */     if (ctpgn > 100) ctpgn = 100; 
/* 1297 */     tpgn = ctpgn;
/*      */     
/* 1299 */     property = config.get("general", "Training Point Gain - 'TP gain / melee' rate", 5);
/* 1300 */     property.comment = "Server Sided! Based on Mind Attribute increase. With every 'configured amount' in Mind attribute the TP gain will increase by 1 OR with the amount configured at 'Training Point Gain - TP amount gained'. Rate can be from 1 to 10000 (default: 5) ";
/* 1301 */     cTpgnRt = property.getInt();
/* 1302 */     if (cTpgnRt < 1.0F) cTpgnRt = 1.0F; 
/* 1303 */     if (cTpgnRt > 10000.0F) cTpgnRt = 10000.0F; 
/* 1304 */     TpgnRt = cTpgnRt;
/*      */     
/* 1306 */     property = config.get("DBC Server Sided Configs", "Kaioken - Sustainable Super", false);
/* 1307 */     property.comment = "Server Sided! If 'true' then the Kaioken will be sustainable in any transformation, If 'false' then Kaioken will be hard to maintain with every transformation. (This WILL make the game more unbalanced. default: false)";
/* 1308 */     csskai = property.getBoolean(false);
/* 1309 */     sskai = csskai;
/*      */     
/* 1311 */     property = config.get("DBC Server Sided Configs", "Fusion - Dance fusion", true);
/* 1312 */     property.comment = "Server Sided! If 'true' then Fusion will be available to use, If 'false' then Fusion wont be usable. (For balancing reasons default: true)";
/* 1313 */     cfuzn = property.getBoolean(true);
/* 1314 */     fuzn = cfuzn;
/*      */     
/* 1316 */     property = config.get("DBC Server Sided Configs", "Fusion - Dance fusion - NoFuse Time", 10);
/* 1317 */     property.comment = "Server Sided! You can change the duration in minutes after a fusion has ended, how long one can't perform fustion again. Time in minutes can be from 1 to 1000 (default: 10) ";
/* 1318 */     int tm = property.getInt();
/* 1319 */     if (tm < 1) { tm = 1; }
/* 1320 */     else if (tm > 1000) { tm = 1000; }
/* 1321 */      FznOverTime = property.getInt() * 12;
/*      */     
/* 1323 */     property = config.get("DBC Server Sided Configs", "Fusion - Dance fusion - Fuse Time", 5);
/* 1324 */     property.comment = "Server Sided! You can change the duration in minutes that a fusion can last. Time in minutes can be from 1 to 30 (default: 5) ";
/* 1325 */     tm = property.getInt();
/* 1326 */     if (tm < 1) { tm = 1; }
/* 1327 */     else if (tm > 30) { tm = 30; }
/* 1328 */      FznTime = property.getInt() * 12;
/*      */ 
/*      */     
/* 1331 */     property = config.get("DBC Server Sided Configs", "Lock On", true);
/* 1332 */     property.comment = "Server Sided! If 'true' then Locking On is enabled, If 'false' then Locking On is disabled. (default: true)";
/* 1333 */     clockon = property.getBoolean(true);
/* 1334 */     lockon = clockon;
/*      */     
/* 1336 */     property = config.get("general", "Stat Defense - Passive output", 20);
/* 1337 */     property.comment = "Server Sided! With this you can change the passive defense output to an extend, numbers are meant to be in percentage. Rate can be from 0 to 50 (default: 20) ";
/* 1338 */     cStatPasDef = property.getInt();
/* 1339 */     if (cStatPasDef < 0) cStatPasDef = 0; 
/* 1340 */     if (cStatPasDef > 50) cStatPasDef = 50; 
/* 1341 */     StatPasDef = cStatPasDef;
/*      */     
/* 1343 */     property = config.get("DBC Server Sided Configs", "Status Effect - Majin", 10);
/* 1344 */     property.comment = "Server Sided! With this you can change the bonus power percentage for the Majin seal status effect. Rate can be from 1 to 100000 (default: 10) ";
/* 1345 */     cmjn = property.getInt();
/* 1346 */     if (cmjn < 1) cmjn = 1; 
/* 1347 */     if (cmjn > 100000) cmjn = 100000; 
/* 1348 */     mjn = cmjn;
/*      */     
/* 1350 */     property = config.get("DBC Server Sided Configs", "Status Effect - Legendary - Transformation Boost", 20);
/* 1351 */     property.comment = "Server Sided! With this you can change the bonus power percentage for the Legendary status effect. Only applied when transformed! Rate can be from 1 to 100000 (default: 20) ";
/* 1352 */     clgnd = property.getInt();
/* 1353 */     if (clgnd < 1) clgnd = 1; 
/* 1354 */     if (clgnd > 100000) clgnd = 100000; 
/* 1355 */     lgnd = clgnd;
/*      */     
/* 1357 */     String legendaryForms = "SS,SSG2,SSG3,SSFullPow,SS2,SS3,Golden,SS4,Full,Buffed,Giant,Form5,Ultimate,Evil,Pure";
/* 1358 */     property = config.get("DBC Server Sided Configs", "Status Effect - Legendary - Boosted Transformations", "SS,SSG2,SSG3,SSFullPow,SS2,SS3,Golden,SS4,Full,Buffed,Giant,Form5,Ultimate,Evil,Pure");
/* 1359 */     property.comment = "Server Sided! The listed transformation initials given the Legendary Boost only! (default: SS,SSG2,SSG3,SSFullPow,SS2,SS3,Golden,SS4,Full,Buffed,Giant,Form5,Ultimate,Evil,Pure)";
/* 1360 */     clgndb = property.getString();
/* 1361 */     lgndb = clgndb;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1370 */     property = config.get("DBC Server Sided Configs", "Status Effect - Legendary - Server limit", 1);
/* 1371 */     property.comment = "Server Sided! With this you can change how many players may use this state. Can be from 0 to 1000 (default: 1) ";
/* 1372 */     cselgnd = property.getInt();
/* 1373 */     if (cselgnd < 0) cselgnd = 0; 
/* 1374 */     if (cselgnd > 1000) cselgnd = 1000; 
/* 1375 */     selgnd = cselgnd;
/*      */     
/* 1377 */     property = config.get("DBC Server Sided Configs", "Status Effect - Legendary - Chance to get it", 10);
/* 1378 */     property.comment = "Server Sided! The chance (in percentage) for a player to receive the Legendary Status Effect every 20-30 mins, regardless of race. Can be from 0 to 100 (default: 10) and 0 will result in close to never. (This config will only be enabled if the 'For every day a Lucky player' config conditions are not met, furthermore setting this to 100 will result in the same effect as the 'For every day a Lucky player' config)";
/*      */ 
/*      */     
/* 1381 */     cselgndc = property.getInt();
/* 1382 */     if (cselgndc < 0) cselgndc = 0; 
/* 1383 */     if (cselgndc > 100) cselgndc = 100; 
/* 1384 */     selgndc = cselgndc;
/*      */     
/* 1386 */     property = config.get("DBC Server Sided Configs", "Status Effect - Legendary - For every day a Lucky player", 20);
/* 1387 */     property.comment = "Server Sided! Above this amount a player will be always selected to receive the Legendary status effect, regardless of race. Can be from 0 to 500 (default: 20) and 0 will result in always a player to receive it every 20-30 mins. (Setting this to 0 will disable the 'Chance to get it' config.)";
/*      */     
/* 1389 */     cselgndc2 = property.getInt();
/* 1390 */     if (cselgndc2 < 0) cselgndc2 = 0; 
/* 1391 */     if (cselgndc2 > 500) cselgndc2 = 500; 
/* 1392 */     selgndc2 = cselgndc2;
/*      */     
/* 1394 */     property = config.get("general", "Offline Server Protector", 0);
/* 1395 */     property.comment = "Server Sided! This will prevent some gui interactions like attribute, skill upgrades or deleting or tech stuff for a configured time. The time is in seconds! Can be from 0 to 300 (default: 0) !For normal servers this should never be used!";
/*      */     
/* 1397 */     cosbic = property.getInt();
/* 1398 */     if (cosbic < 0) cosbic = 0; 
/* 1399 */     if (cosbic > 300) cosbic = 300; 
/* 1400 */     osbic = cosbic;
/*      */     
/* 1402 */     property = config.get("DBC Server Sided Configs", "Racial Skill Arcosian - Power Point multiplier", 1.0D);
/* 1403 */     property.comment = "Server Sided! You can multiply the base PP generation for the Arcosian Power Reserves. Can be from 0.5 to 50.0 (default: 1.0)";
/*      */     
/* 1405 */     cappm = property.getDouble();
/* 1406 */     if (cappm < 0.5D) cappm = 0.5D; 
/* 1407 */     if (cappm > 50.0D) cappm = 50.0D; 
/* 1408 */     appm = cappm;
/*      */     
/* 1410 */     property = config.get("general", "Core System - Attribute Cost mulipier", 0.5D);
/* 1411 */     property.comment = "Server Sided! Attribute's TP cost mulipier. The higher amount the higher will be the increase after each upgrade.Can be from 0 to 1000.0 (default: 0.5)";
/*      */     
/* 1413 */     catcm = property.getDouble();
/* 1414 */     if (catcm < 0.0D) catcm = 0.0D; 
/* 1415 */     if (catcm > 1000.0D) catcm = 1000.0D; 
/* 1416 */     atcm = catcm;
/*      */     
/* 1418 */     property = config.get("NarutoC Server Sided Configs", "Clan Skill Hyuuga - Energy Damage percentage", 10);
/* 1419 */     property.comment = "Server Sided! Energy Damage percentage, multiplied with each Hyuuha clan skill level! So if Hyuuga clan skill level is 3 and the this config is 10, the energy damage will be 30% of the player melee damage.Can be from 1 to 100 (default: 10)";
/*      */     
/* 1421 */     chedp = property.getInt(10);
/* 1422 */     if (chedp < 1) chedp = 1; 
/* 1423 */     if (chedp > 100) chedp = 100; 
/* 1424 */     hedp = chedp;
/*      */ 
/*      */ 
/*      */     
/* 1428 */     property = config.get("general", "Player Punch stamina cost multiplier", 1.0D);
/* 1429 */     property.comment = "Server Sided! Player Punch stamina cost multiplier value from 0 to 30. (default: 1.00)";
/* 1430 */     ccnfPnchc = property.getDouble(1.0D);
/* 1431 */     if (ccnfPnchc < 0.0D) ccnfPnchc = 0.0D;  if (ccnfPnchc > 30.0D) ccnfPnchc = 30.0D; 
/* 1432 */     cnfPnchc = ccnfPnchc;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1437 */     s = new String[9]; int i3;
/* 1438 */     for (i3 = 0; i3 < s.length; ) { s[i3] = "true"; i3++; }
/* 1439 */      property = config.get("DBC Ki Attack Server Sided Configs", "Enabled Ki Attack Types (Wave, Ball, Disk, Laser, Spiral, Large Ball, Barrage, Shield, Explosion)", s, "Server Sided! Disabled ki attack types will make them instantly die when spawned.");
/* 1440 */     for (i3 = 0; i3 < s.length; i3++) {
/* 1441 */       cdat5695[i3] = Boolean.parseBoolean(property.getStringList()[i3]);
/* 1442 */       dat5695[i3] = cdat5695[i3];
/*      */     } 
/*      */ 
/*      */     
/* 1446 */     String[] names = { "Wave", "Ball", "Disk", "Laser", "Spiral", "Large Ball", "Barrage", "Shield", "Explosion" };
/* 1447 */     String[] names2 = { "Wave", "Ball", "Disk", "Laser", "Spiral", "Large_Ball", "Barrage", "Shield", "Explosion" };
/* 1448 */     for (int k = 0; k < names.length; k++) {
/* 1449 */       s = new String[3]; int i9;
/* 1450 */       for (i9 = 0; i9 < s.length; ) { s[i9] = "1.0"; i9++; }
/* 1451 */        property = config.get("DBC Ki Attack Server Sided Configs", "Ki Attack stat multipliers for (" + names[k] + ") (Speed, Damage, Cost) value from 0 to 1000 (defaults: 1.00).", s, "Server Sided! Stats are multiplied after attack is created.");
/* 1452 */       for (i9 = 0; i9 < s.length; i9++) {
/* 1453 */         cdat5696[k][i9] = Double.parseDouble(property.getStringList()[i9]);
/* 1454 */         if (cdat5696[k][i9] < 0.0D) cdat5696[k][i9] = 0.0D; 
/* 1455 */         if (cdat5696[k][i9] > 1000.0D) cdat5696[k][i9] = 1000.0D; 
/* 1456 */         dat5696[k][i9] = cdat5696[k][i9];
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1463 */     String[] data = { "Snowball 2", "Arrow 2", "SmallFireball 2", "Fireball 2" };
/* 1464 */     property = config.get("DBC Ki Attack Server Sided Configs", "List of Entities EVERY Ki Attacks react to. (Name, Reaction)(Reactions: Ki Attack will... 1 = Die from it | 2 = Destroy it | 3 = Destroy it IF effect is on | 4 = Damage it | 5 = Damage it IF effect is on)", data, "Server Sided! Ki Attacks React to these Entities.");
/*      */     
/* 1466 */     String[] datasListNames = property.getStringList(); int i4;
/* 1467 */     for (i4 = 0; i4 < datasListNames.length; i4++) {
/* 1468 */       if ((datasListNames[i4].split(" ")).length > 1)
/*      */       {
/* 1470 */         dat5702.put(datasListNames[i4].split(" ")[0], Byte.valueOf(Byte.parseByte(datasListNames[i4].split(" ")[1])));
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1476 */     for (i4 = 0; i4 < names.length; i4++) {
/* 1477 */       String[] datas2 = { "" };
/* 1478 */       property = config.get("DBC Ki Attack Server Sided Configs", "List of Entities '" + names[i4] + "' Ki Attacks react to. (Name, Reaction)(Reactions: Ki Attack will... 1 = Die from it | 2 = Destroy it | 3 = Destroy it IF effect is on | 4 = Damage it | 5 = Damage it IF effect is on)", datas2, "Server Sided! Ki Attacks React to these Entities.");
/*      */       
/* 1480 */       String[] arrayOfString1 = property.getStringList();
/*      */       
/* 1482 */       for (int i9 = 0; i9 < arrayOfString1.length; i9++) {
/* 1483 */         if ((arrayOfString1[i9].split(" ")).length > 1)
/*      */         {
/* 1485 */           dat5703.put(i4 + "." + arrayOfString1[i9].split(" ")[0], Byte.valueOf(Byte.parseByte(arrayOfString1[i9].split(" ")[1])));
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1491 */     property = config.get("Console Configs", "Entity Hit by Ki Attack Console message", false);
/* 1492 */     property.comment = "Server Sided! If true it will type in the Names of Entities that got hit by a Ki Attack and can be used for the 'List of Entities Ki Attacks react to' config. (default: false)";
/* 1493 */     cdat5704 = property.getBoolean();
/* 1494 */     dat5704 = cdat5704;
/*      */ 
/*      */ 
/*      */     
/* 1498 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Clash Destroy weaker one", 50.0D);
/* 1499 */     property.comment = "Server Sided! When Ki Attacks clash if one is x (config amount) times weaker than the other one destroy it. Value from 1 to 1000. IF value is 1 then the config is off. (default: 50.00)";
/* 1500 */     cdat5705 = property.getDouble(50.0D);
/* 1501 */     if (cdat5705 < 1.0D) cdat5705 = 1.0D;  if (cdat5705 > 1000.0D) cdat5705 = 1000.0D; 
/* 1502 */     dat5705 = cdat5705;
/*      */ 
/*      */     
/* 1505 */     data = new String[names.length - 2];
/* 1506 */     for (i4 = 0; i4 < names.length - 2; i4++) {
/* 1507 */       if (i4 == 6) { data[i4] = names2[i4] + " false"; }
/* 1508 */       else { data[i4] = names2[i4] + " true"; }
/*      */     
/* 1510 */     }  property = config.get("DBC Ki Attack Server Sided Configs", "Ki Attack knockback", data, "Server Sided! If true Ki Attacks will knockback hit targets as normal.");
/* 1511 */     data = property.getStringList();
/* 1512 */     for (i4 = 0; i4 < names.length - 2; i4++) {
/* 1513 */       cdat5706[i4] = Boolean.parseBoolean(data[i4].split(" ")[1]);
/* 1514 */       dat5706[i4] = cdat5706[i4];
/*      */     } 
/*      */ 
/*      */     
/* 1518 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Shields and Explosions give Ki Tech experience percentage", 0);
/* 1519 */     property.comment = "Server Sided! Ki Shields and Explosions give Ki Tech experience percentage. Value from 0 to 100. IF value is 0 then the config is off. (default: 0)";
/* 1520 */     cdat5707 = (byte)property.getInt(0);
/* 1521 */     if (cdat5707 < 0) cdat5707 = 0;  if (cdat5707 > 100) cdat5707 = 100; 
/* 1522 */     dat5707 = cdat5707;
/*      */ 
/*      */ 
/*      */     
/* 1526 */     String[] finalDatas = { "EFFECT_OFF true", "EFFECT_ON true" };
/* 1527 */     property = config.get("DBC Ki Attack Server Sided Configs", "Spirals go through entities", finalDatas);
/* 1528 */     property.comment = "Server Sided! If true Spirals will go through entities.";
/* 1529 */     String[] datasListNames2 = property.getStringList();
/* 1530 */     cdat5708[0] = Boolean.parseBoolean(datasListNames2[0].split(" ")[1]);
/* 1531 */     cdat5708[1] = Boolean.parseBoolean(datasListNames2[1].split(" ")[1]);
/* 1532 */     dat5708[0] = cdat5708[0];
/* 1533 */     dat5708[1] = cdat5708[1];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1538 */     property = config.get("DBC Ki Attack Server Sided Configs", "Final explosion vanish on death", true);
/* 1539 */     property.comment = "Server Sided! If true Final explosion will vanish if the user is dead. (default: true)";
/* 1540 */     cdat5710 = property.getBoolean();
/* 1541 */     dat5710 = cdat5710;
/*      */ 
/*      */ 
/*      */     
/* 1545 */     data = new String[names.length]; int i5;
/* 1546 */     for (i5 = 0; i5 < names.length; i5++) {
/* 1547 */       data[i5] = names2[i5] + " true";
/*      */     }
/* 1549 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Attack Effect can be used", data, "Server Sided! If true Ki Attack Effect can be used.");
/* 1550 */     data = property.getStringList();
/* 1551 */     for (i5 = 0; i5 < names.length; i5++) {
/* 1552 */       cdat5709[i5] = Boolean.parseBoolean(data[i5].split(" ")[1]);
/* 1553 */       dat5709[i5] = cdat5709[i5];
/*      */     } 
/*      */ 
/*      */     
/* 1557 */     property = config.get("general", "Racial Skill from tp", true);
/* 1558 */     property.comment = "Server Sided! If true Racial Skill can be leveled up using tp. (default: true)";
/* 1559 */     cdat5711 = property.getBoolean();
/* 1560 */     dat5711 = cdat5711;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1567 */     property = config.get("DBC Ki Attack Server Sided Configs", "Explosion Max Age Ticks", 60);
/* 1568 */     property.comment = "Server Sided! Explosion Max Age Ticks value from 0 to 1000. (default: 60)";
/* 1569 */     cdat5697 = property.getInt(60);
/* 1570 */     if (cdat5697 < 0) cdat5697 = 0;  if (cdat5697 > 1000) cdat5697 = 1000; 
/* 1571 */     dat5697 = cdat5697;
/*      */ 
/*      */     
/* 1574 */     property = config.get("DBC Ki Attack Server Sided Configs", "Explosion Self Harm Damage Percentage", 25);
/* 1575 */     property.comment = "Server Sided! Explosion Self Harm Damage Percentage value from 0 to 100. (default: 25)";
/* 1576 */     cdat5701 = property.getInt(25);
/* 1577 */     if (cdat5701 < 0.0D) cdat5701 = 0.0D;  if (cdat5701 > 100.0D) cdat5701 = 100.0D; 
/* 1578 */     dat5701 = cdat5701;
/*      */ 
/*      */     
/* 1581 */     property = config.get("general", "Meditation Stamina Drain multiplier", 0.1D);
/* 1582 */     property.comment = "Server Sided! Meditation Stamina Drain multiplier value from 0 to 10000. (default: 0.1)";
/* 1583 */     cdat5698 = property.getDouble(0.1D);
/* 1584 */     if (cdat5698 < 0.0D) cdat5698 = 0.0D;  if (cdat5698 > 10000.0D) cdat5698 = 10000.0D; 
/* 1585 */     dat5698 = cdat5698;
/*      */ 
/*      */     
/* 1588 */     property = config.get("general", "Ki Blade and Scythe Ki Fist Damage multiplier", 1.0D);
/* 1589 */     property.comment = "Server Sided! Ki Blade and Scythe Ki Fist Damage multiplier value from 0 to 100. (default: 1.00)";
/* 1590 */     cdat5699 = property.getDouble(1.0D);
/* 1591 */     if (cdat5699 < 0.0D) cdat5699 = 0.0D;  if (cdat5699 > 100.0D) cdat5699 = 100.0D; 
/* 1592 */     dat5699 = cdat5699;
/*      */ 
/*      */     
/* 1595 */     property = config.get("general", "Ki Blade and Scythe Ki Infuse Damage multiplier", 1.0D);
/* 1596 */     property.comment = "Server Sided! Ki Blade and Scythe Ki Infuse Damage multiplier value from 0 to 100. (default: 1.00)";
/* 1597 */     cdat5700 = property.getDouble(1.0D);
/* 1598 */     if (cdat5700 < 0.0D) cdat5700 = 0.0D;  if (cdat5700 > 100.0D) cdat5700 = 100.0D; 
/* 1599 */     dat5700 = cdat5700;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1604 */     property = config.get("general", "Mystic Form Level Loss Timer multiplier", 2.0D);
/* 1605 */     property.comment = "Server Sided! Mystic Form Level Loss Timer multiplier value from 0 to 100 (0 = timer disabled). (default: 2.00)";
/* 1606 */     cMystTim = property.getDouble(2.0D);
/* 1607 */     if (cMystTim < 0.0D) cMystTim = 0.0D;  if (cMystTim > 100.0D) cMystTim = 100.0D; 
/* 1608 */     MystTim = cMystTim;
/*      */     
/* 1610 */     property = config.get("general", "Player Flying Speed multiplier", 2.0D);
/* 1611 */     property.comment = "Server Sided! Player Flying Speed multiplier value from 0 to 100. (default: 2.0)";
/* 1612 */     cFlngspd = property.getDouble(2.0D);
/* 1613 */     if (cFlngspd < 0.0D) cFlngspd = 0.0D;  if (cFlngspd > 100.0D) cFlngspd = 100.0D; 
/* 1614 */     Flngspd = cFlngspd;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1620 */     property = config.get("general", "Player Update Timer (Tick)", 100);
/* 1621 */     property.comment = "Server Sided! Player Update Timer (for things like receiving missions from Server, and entering the teleporter blocks for the Hyperbolic Time Chamber) value from 1 to 10000. (Lower number can cause more lag) (default: 100)";
/* 1622 */     cplUpd = property.getInt(100);
/* 1623 */     if (cplUpd < 1) cplUpd = 1;  if (cplUpd > 10000) cplUpd = 10000; 
/* 1624 */     plUpd = cplUpd;
/*      */ 
/*      */ 
/*      */     
/* 1628 */     property = config.get("general", "ExtendedPlayer - Blocking Variable ID", 20);
/* 1629 */     property.comment = "Server Sided! ExtendedPlayer - Blocking Variable. Has possibility of causing issues once changed. (default: 20)";
/*      */     
/* 1631 */     cExtendedPlayerBlockID = (byte)property.getInt(20);
/* 1632 */     if (cExtendedPlayerBlockID < 0) cExtendedPlayerBlockID = 0;  if (cExtendedPlayerBlockID > 100) cExtendedPlayerBlockID = 100; 
/* 1633 */     ExtendedPlayerBlockID = cExtendedPlayerBlockID;
/*      */     
/* 1635 */     property = config.get("general", "ExtendedPlayer - Othercode Variable ID", 21);
/* 1636 */     property.comment = "Server Sided! ExtendedPlayer - Othercode Variable. Has possibility of causing issues once changed. (default: 21)";
/* 1637 */     cExtendedPlayerOtherID = (byte)property.getInt(21);
/* 1638 */     if (cExtendedPlayerOtherID < 0) cExtendedPlayerOtherID = 0;  if (cExtendedPlayerOtherID > 100) cExtendedPlayerOtherID = 100; 
/* 1639 */     ExtendedPlayerOtherID = cExtendedPlayerOtherID;
/*      */     
/* 1641 */     property = config.get("general", "ExtendedPlayer - Haircode Variable ID", 22);
/* 1642 */     property.comment = "Server Sided! ExtendedPlayer - Haircode Variable. Has possibility of causing issues once changed. (default: 22)";
/* 1643 */     cExtendedPlayerHairID = (byte)property.getInt(22);
/* 1644 */     if (cExtendedPlayerHairID < 0) cExtendedPlayerHairID = 0;  if (cExtendedPlayerHairID > 100) cExtendedPlayerHairID = 100; 
/* 1645 */     ExtendedPlayerHairID = cExtendedPlayerHairID;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1650 */     data = new String[names.length - 2];
/* 1651 */     for (i5 = 0; i5 < names.length - 2; ) { data[i5] = names2[i5] + " 0.01 0.1"; i5++; }
/* 1652 */      property = config.get("DBC Ki Attack Server Sided Configs", "Ki Attack Sizes (Min Max)", data, "Server Sided! Ki Attack Hitbox and Render Sizes (Min Max) (default: 0.01 0.1).");
/* 1653 */     data = property.getStringList();
/* 1654 */     for (i5 = 0; i5 < names.length - 2; i5++) {
/*      */       
/* 1656 */       String[] line = data[i5].split(" ");
/* 1657 */       cKiSizeMin[i5] = Double.parseDouble(line[1]);
/* 1658 */       if (cKiSizeMin[i5] < 0.0D) cKiSizeMin[i5] = 0.0D;  if (cKiSizeMin[i5] > 10000.0D) cKiSizeMin[i5] = 10000.0D; 
/* 1659 */       KiSizeMin[i5] = cKiSizeMin[i5];
/* 1660 */       cKiSizeMax[i5] = Double.parseDouble(line[2]);
/* 1661 */       if (cKiSizeMax[i5] < 0.0D) cKiSizeMax[i5] = 0.0D;  if (cKiSizeMax[i5] > 10000.0D) cKiSizeMax[i5] = 10000.0D; 
/* 1662 */       KiSizeMax[i5] = cKiSizeMax[i5];
/*      */     } 
/*      */     
/* 1665 */     data = new String[3];
/* 1666 */     for (i5 = 0; i5 < 3; ) { data[i5] = names2[i5] + " 0.03 0.1"; i5++; }
/* 1667 */      property = config.get("NC Jutsu Server Sided Configs", "Jutsu Attack Sizes (Min Max)", data, "Server Sided! Jutsu Attack Hitbox and Render Sizes (Min Max) (default: 0.01 0.1).");
/* 1668 */     data = property.getStringList();
/* 1669 */     for (i5 = 0; i5 < 3; i5++) {
/*      */       
/* 1671 */       String[] line = data[i5].split(" ");
/* 1672 */       cJutsuSizeMin[i5] = Double.parseDouble(line[1]);
/* 1673 */       if (cJutsuSizeMin[i5] < 0.0D) cJutsuSizeMin[i5] = 0.0D;  if (cJutsuSizeMin[i5] > 10000.0D) cJutsuSizeMin[i5] = 10000.0D; 
/* 1674 */       JutsuSizeMin[i5] = cJutsuSizeMin[i5];
/* 1675 */       cJutsuSizeMax[i5] = Double.parseDouble(line[2]);
/* 1676 */       if (cJutsuSizeMax[i5] < 0.0D) cJutsuSizeMax[i5] = 0.0D;  if (cJutsuSizeMax[i5] > 10000.0D) cJutsuSizeMax[i5] = 10000.0D; 
/* 1677 */       JutsuSizeMax[i5] = cJutsuSizeMax[i5];
/*      */     } 
/*      */ 
/*      */     
/* 1681 */     data = new String[names.length - 3];
/* 1682 */     for (i5 = 0; i5 < names.length - 3; ) { data[i5] = names2[i5] + " " + ((i5 == 0) ? "true" : "false"); i5++; }
/* 1683 */      property = config.get("DBC Ki Attack Server Sided Configs", "Continues Ki Attacks. User must look forward to hold an attack or it will hit entities once.", data, "Server Sided! Continues Ki Attacks.");
/* 1684 */     data = property.getStringList();
/* 1685 */     for (i5 = 0; i5 < names.length - 3; i5++) {
/*      */       
/* 1687 */       String[] line = data[i5].split(" ");
/* 1688 */       cContinuesKiAttacks[i5] = Boolean.parseBoolean(line[1]);
/* 1689 */       ContinuesKiAttacks[i5] = cContinuesKiAttacks[i5];
/*      */     } 
/*      */     
/* 1692 */     data = new String[3];
/* 1693 */     for (i5 = 0; i5 < 3; ) { data[i5] = names2[i5] + " " + ((i5 == 0) ? "true" : "false"); i5++; }
/* 1694 */      property = config.get("NC Jutsu Server Sided Configs", "Continues Jutsu Attacks.  User must look forward to hold an attack or it will hit entities once.", data, "Server Sided! Continues Jutsu Attacks.");
/* 1695 */     data = property.getStringList();
/* 1696 */     for (i5 = 0; i5 < 3; i5++) {
/*      */       
/* 1698 */       String[] line = data[i5].split(" ");
/* 1699 */       cContinuesJutsuAttacks[i5] = Boolean.parseBoolean(line[1]);
/* 1700 */       ContinuesJutsuAttacks[i5] = cContinuesJutsuAttacks[i5];
/*      */     } 
/*      */     
/* 1703 */     property = config.get("Energy Attack Configs", "Continues Energy Attacks Die if Target Moves Away", false);
/* 1704 */     property.comment = "Server Sided! Continues Energy Attacks Die if Target Moves Away. (default: false)";
/* 1705 */     cWavesDieWhenTargetAway = property.getBoolean(false);
/* 1706 */     WavesDieWhenTargetAway = cWavesDieWhenTargetAway;
/*      */     
/* 1708 */     property = config.get("Energy Attack Configs", "Continues Energy Attacks Shrink if User Moves or Looks Away", true);
/* 1709 */     property.comment = "Server Sided! Continues Energy Attacks Shrink if User Moves or Looks Away. (default: true)";
/* 1710 */     cWavesShrinkOnceLetGo = property.getBoolean(true);
/* 1711 */     WavesShrinkOnceLetGo = cWavesShrinkOnceLetGo;
/*      */ 
/*      */     
/* 1714 */     String powerFormula = "(Damage/2)+(Speed*2)+(Density*10)+(1)";
/* 1715 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Attack Power Formula", "(Damage/2)+(Speed*2)+(Density*10)+(1)");
/* 1716 */     property.comment = "Server Sided! Ki Attack Power Formula. Used to calculate an attack's power when clashing with another ki attack (default: (Damage/2)+(Speed*2)+(Density*10)+(1))";
/* 1717 */     cKiAttackPowerFormula = property.getString();
/* 1718 */     KiAttackPowerFormula = cKiAttackPowerFormula;
/*      */ 
/*      */ 
/*      */     
/* 1722 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Attacks scale with user's height", true);
/* 1723 */     property.comment = "Server Sided! Ki Attacks scale with user's height. (default: true)";
/* 1724 */     cKiAttackScalesWithUser = property.getBoolean(true);
/* 1725 */     KiAttackScalesWithUser = cKiAttackScalesWithUser;
/*      */     
/* 1727 */     property = config.get("NC Jutsu Server Sided Configs", "Jutsus scale with user's height", true);
/* 1728 */     property.comment = "Server Sided! Jutsus scale with user's height. (default: true)";
/* 1729 */     cJutsuScalesWithUser = property.getBoolean(true);
/* 1730 */     JutsuScalesWithUser = cJutsuScalesWithUser;
/*      */ 
/*      */ 
/*      */     
/* 1734 */     String[] names3 = { "Wave", "Ball", "Disk", "Laser", "Spiral", "Large_Ball", "Barrage", "Explosion" };
/* 1735 */     data = new String[names3.length]; int i6;
/* 1736 */     for (i6 = 0; i6 < names3.length; ) { data[i6] = names3[i6] + " " + ((i6 == 6) ? '\001' : ((i6 > 4) ? 3 : 2)); i6++; }
/* 1737 */      property = config.get("Energy Attack Configs", "Training Point Gain - TP amount gained from Energy Attacks.", data, "Server Sided! Tp gain can be, from 1 to 100. (default: 2 2 2 2 2 3 1 3).");
/* 1738 */     data = property.getStringList();
/* 1739 */     for (i6 = 0; i6 < names3.length; i6++) {
/*      */       
/* 1741 */       String[] line = data[i6].split(" ");
/* 1742 */       cTPGainEnergy[i6] = Integer.parseInt(line[1]);
/* 1743 */       if (cTPGainEnergy[i6] < 0) cTPGainEnergy[i6] = 0; 
/* 1744 */       if (cTPGainEnergy[i6] > 100) cTPGainEnergy[i6] = 100; 
/* 1745 */       TPGainEnergy[i6] = cTPGainEnergy[i6];
/*      */     } 
/*      */ 
/*      */     
/* 1749 */     property = config.get("Energy Attack Configs", "Continues Energy Attack Lock Timer", 5);
/* 1750 */     property.comment = "Server Sided! Continues Energy Attack Lock Timer. Setting it to 0 makes it lock the Enemy while the user has Ki. (default: 5)";
/* 1751 */     cContinuesEnergyAttackTimer = property.getInt(5);
/* 1752 */     ContinuesEnergyAttackTimer = cContinuesEnergyAttackTimer;
/*      */     
/* 1754 */     property = config.get("Energy Attack Configs", "Continues Energy Attacks Move On Lost Target", true);
/* 1755 */     property.comment = "Server Sided! Continues Energy Attacks start to move forward once hit entity moves away. (default: true)";
/* 1756 */     cContinuesEnergyAttackMoveOnLostTarget = property.getBoolean(true);
/* 1757 */     ContinuesEnergyAttackMoveOnLostTarget = cContinuesEnergyAttackMoveOnLostTarget;
/*      */     
/* 1759 */     property = config.get("Energy Attack Configs", "Continues Energy Attacks Lock Target", false);
/* 1760 */     property.comment = "Server Sided! Continues Energy Attacks Lock the hit entity. (default: false)";
/* 1761 */     cContinuesEnergyAttackEnemyLock = property.getBoolean(false);
/* 1762 */     ContinuesEnergyAttackEnemyLock = cContinuesEnergyAttackEnemyLock;
/*      */ 
/*      */ 
/*      */     
/* 1766 */     property = config.get("Energy Attack Configs", "Energy Attack Max Life Tick 1", 2000);
/* 1767 */     property.comment = "Server Sided! Energy Attack Max Life Tick 1. Setting it to 0 makes it infinite. (default: 2000)";
/* 1768 */     cEnergyAttackMaxLifeTick = property.getInt(2000);
/* 1769 */     EnergyAttackMaxLifeTick = cEnergyAttackMaxLifeTick;
/*      */     
/* 1771 */     property = config.get("Energy Attack Configs", "Energy Attack Max Life Tick 2 - Percentage Multiplier", 500);
/* 1772 */     property.comment = "Server Sided! Energy Attack Max Life Tick 2 - Percentage Multiplier (formula: config*attack charge percentage*0.02). Setting it to 0 makes it infinite. (default: 500)";
/* 1773 */     cEnergyAttackMaxLifeTickPercMulti = property.getInt(500);
/* 1774 */     EnergyAttackMaxLifeTickPercMulti = cEnergyAttackMaxLifeTickPercMulti;
/*      */ 
/*      */     
/* 1777 */     property = config.get("Energy Attack Configs", "Continues Energy Attacks Slow Down with a Target", true);
/* 1778 */     property.comment = "Server Sided! Continues Energy Attacks Slow Down once it hits an entity. (default: true)";
/* 1779 */     cContinuesEnergyAttackTargetSlowdown = property.getBoolean(true);
/* 1780 */     ContinuesEnergyAttackTargetSlowdown = cContinuesEnergyAttackTargetSlowdown;
/*      */ 
/*      */     
/* 1783 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Shields move with the user", false);
/* 1784 */     property.comment = "Server Sided! Ki Shields move with the user. (default: false)";
/* 1785 */     cShieldsMoveWithUser = property.getBoolean(false);
/* 1786 */     ShieldsMoveWithUser = cShieldsMoveWithUser;
/*      */     
/* 1788 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Explosions move with the user", false);
/* 1789 */     property.comment = "Server Sided! Ki Explosions move with the user. (default: false)";
/* 1790 */     cExplosionsMoveWithUser = property.getBoolean(false);
/* 1791 */     ExplosionsMoveWithUser = cExplosionsMoveWithUser;
/*      */ 
/*      */     
/* 1794 */     property = config.get("DBC Ki Attack Server Sided Configs", "Spirals Weaken going through enemies by x Percentage", 30);
/* 1795 */     property.comment = "Server Sided! Spirals Damage weakens after going through targets. Value is a Percentage, for example 30 will be 30% minus power after each hit. Setting to 0 will disable the config. From 0 to 100. (default: 30)";
/* 1796 */     cSpiralWeakensAfterHit = (byte)property.getInt(30);
/* 1797 */     if (cSpiralWeakensAfterHit > 100) { cSpiralWeakensAfterHit = 100; }
/* 1798 */     else if (cSpiralWeakensAfterHit < 0) { cSpiralWeakensAfterHit = 0; }
/* 1799 */      SpiralWeakensAfterHit = cSpiralWeakensAfterHit;
/*      */     
/* 1801 */     property = config.get("DBC Ki Attack Server Sided Configs", "Spirals Weaken going through enemies based off on their Start Damage", true);
/* 1802 */     property.comment = "Server Sided! Spirals Weaken going through enemies based off on their Start Damage (true) OR their new divided damage (false). (default: true)";
/* 1803 */     cSpiralWeakensBasedOnStartDamage = property.getBoolean(true);
/* 1804 */     SpiralWeakensBasedOnStartDamage = cSpiralWeakensBasedOnStartDamage;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1817 */     property = config.get("DBC Server Sided Configs", "Player Fly mode descending On", true);
/* 1818 */     property.comment = "Server Sided! Players in Fly mode will slowly move downwards constantly. (default: true)";
/* 1819 */     cPlayerFlyingDragDownOn = property.getBoolean(false);
/* 1820 */     PlayerFlyingDragDownOn = cPlayerFlyingDragDownOn;
/*      */ 
/*      */     
/* 1823 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Attack Explosion Size Limit", 15);
/* 1824 */     property.comment = "Server Sided! Setting it to 0 will disable limits. From 0 to 10000 (default: 15.0) (lower number will reduce lag)";
/* 1825 */     cExplosionSizeLimit = property.getDouble(15.0D);
/* 1826 */     if (cExplosionSizeLimit < 0.0D) cExplosionSizeLimit = 0.0D; 
/* 1827 */     if (cExplosionSizeLimit > 10000.0D) cExplosionSizeLimit = 10000.0D; 
/* 1828 */     ExplosionSizeLimit = cExplosionSizeLimit;
/*      */ 
/*      */ 
/*      */     
/* 1832 */     property = config.get("DBC Ki Attack Server Sided Configs", "Ki Attack Closest Entity Check Size Mode", 4);
/* 1833 */     property.comment = "Server Sided! Changes what the size of the bounding box is in which it can detect entities. The higher values may be less likely to Freeze the game.\n\tFrom 0 to 5 (default: 4).\n\tMode 0 = Old, (Size + Motion + Extra 0.5 Blocks)\n\tMode 1 = (Size + Motion)\n\tMode 2 = (Size + Extra 0.5 Blocks)\n\tMode 3 = (Size + Motion Version 2)\n\tMode 4 = (Size)\n\tMode 5 = (DISABLED! Doesn't check what entity is closest in it.";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1841 */     cKiClosestEntityCheckSize = (byte)property.getInt(4);
/* 1842 */     if (cKiClosestEntityCheckSize < 0) cKiClosestEntityCheckSize = 0; 
/* 1843 */     if (cKiClosestEntityCheckSize > 5) cKiClosestEntityCheckSize = 5; 
/* 1844 */     KiClosestEntityCheckSize = cKiClosestEntityCheckSize;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1849 */     property = config.get("general", "Bonus Attributes On", false);
/* 1850 */     property.comment = "Server Sided! Bonus Attributes are enabled from the 'jrmcabonus' command. (default: false)";
/* 1851 */     cJRMCABonusOn = property.getBoolean();
/* 1852 */     JRMCABonusOn = cJRMCABonusOn;
/*      */     
/* 1854 */     property = config.get("general", "Shadow Dummy Scales to the Summoner On", true);
/* 1855 */     property.comment = "Server Sided! Shadow Dummy's size becomes the same as the Summoner's. (default: true)";
/* 1856 */     cShadowDummyScaleToTarget = property.getBoolean();
/* 1857 */     ShadowDummyScaleToTarget = cShadowDummyScaleToTarget;
/*      */ 
/*      */     
/* 1860 */     property = config.get("general", "Server - Family C Player Data Update Timer in Seconds", 5);
/* 1861 */     property.comment = "Server Sided! Change how often the Server updates each Players' Family Data. Family C data can become laggy on servers with hundreds or thousands of Families. (From 1 to 1000000) Lower numbers equals more lag. (default: 5)";
/*      */     
/* 1863 */     serverPlayerUpdateTick_DataFamilyC = property.getInt(5);
/* 1864 */     if (serverPlayerUpdateTick_DataFamilyC < 1) serverPlayerUpdateTick_DataFamilyC = 1; 
/* 1865 */     if (serverPlayerUpdateTick_DataFamilyC > 1000000) serverPlayerUpdateTick_DataFamilyC = 1000000;
/*      */     
/* 1867 */     property = config.get("general", "Server - Family C Player Data Updater Run as Java Thread On", true);
/* 1868 */     property.comment = "Server Sided! Family C player data updates are made in a new Thread, potentially increasing server performace, but also causing unexpected minor bugs. ('true' or 'false') (default: true)";
/* 1869 */     runFamilyCDataUpdateAsThread = property.getBoolean();
/*      */ 
/*      */ 
/*      */     
/* 1873 */     property = config.get("Food Configs", "Can Eat While KOd On", false);
/* 1874 */     property.comment = "Server Sided! Player can eat items while under the KO status effect. (default: false)";
/* 1875 */     cCanEatWhileKOd = property.getBoolean();
/* 1876 */     CanEatWhileKOd = cCanEatWhileKOd;
/*      */     
/* 1878 */     property = config.get("Food Configs", "Can Eat Senzu While KOd On", false);
/* 1879 */     property.comment = "Server Sided! Player can eat senzu beans while under the KO status effect. (default: false)";
/* 1880 */     cCanUseSenzuWhileKOd = property.getBoolean();
/* 1881 */     CanUseSenzuWhileKOd = cCanUseSenzuWhileKOd;
/*      */     
/* 1883 */     property = config.get("Food Configs", "Global Food Health Heal Multiplier", 0.03D);
/* 1884 */     property.comment = "Server Sided! Formula: (Global Multi * Max Body * Food Heal Amount * Unique Multiplier). From 0 to 10000. (default: 0.03)";
/* 1885 */     cGlobalFoodHealMultiHealth = (float)property.getDouble(0.03D);
/* 1886 */     if (cGlobalFoodHealMultiHealth < 0.0F) cGlobalFoodHealMultiHealth = 0.0F; 
/* 1887 */     if (cGlobalFoodHealMultiHealth > 10000.0F) cGlobalFoodHealMultiHealth = 10000.0F; 
/* 1888 */     GlobalFoodHealMultiHealth = cGlobalFoodHealMultiHealth;
/*      */     
/* 1890 */     property = config.get("Food Configs", "Global Food Energy Heal Multiplier", 0.0175D);
/* 1891 */     property.comment = "Server Sided! Formula: (Global Multi * Max Energy * Food Heal Amount * Unique Multiplier). From 0 to 10000. (default: 0.175)";
/* 1892 */     cGlobalFoodHealMultiEnergy = (float)property.getDouble(0.0175D);
/* 1893 */     if (cGlobalFoodHealMultiEnergy < 0.0F) cGlobalFoodHealMultiEnergy = 0.0F; 
/* 1894 */     if (cGlobalFoodHealMultiEnergy > 10000.0F) cGlobalFoodHealMultiEnergy = 10000.0F; 
/* 1895 */     GlobalFoodHealMultiEnergy = cGlobalFoodHealMultiEnergy;
/*      */ 
/*      */     
/* 1898 */     String[] names4 = { "item.ItemDinoMeatCooked 0.95 0.95", "item.ItemDinoMeatCookedBig 0.95 0.95" };
/* 1899 */     property = config.get("Food Configs", "Unique Food Heal Multiplier", names4, "Server Sided! Food items in this list receive a unique heal multiplier. From 0 to 10000. (default: item.ItemDinoMeatCooked 0.95 0.95 item.ItemDinoMeatCooked 0.95 0.95).\nEach line should contain: (itemName) (healthHeal) (energyHeal)");
/*      */ 
/*      */     
/* 1902 */     data = property.getStringList();
/* 1903 */     for (String line : data) {
/*      */       
/* 1905 */       String[] lineContent = line.split(" ");
/* 1906 */       float valueHealth = Float.parseFloat(lineContent[1]);
/* 1907 */       if (valueHealth < 0.0F) valueHealth = 0.0F; 
/* 1908 */       if (valueHealth > 10000.0F) valueHealth = 10000.0F; 
/* 1909 */       float valueEnergy = Float.parseFloat(lineContent[2]);
/* 1910 */       if (valueEnergy < 0.0F) valueEnergy = 0.0F; 
/* 1911 */       if (valueEnergy > 10000.0F) valueEnergy = 10000.0F; 
/* 1912 */       cFoodHealMulti.put(lineContent[0], new float[] { valueHealth, valueEnergy });
/* 1913 */       FoodHealMulti.put(lineContent[0], new float[] { valueHealth, valueEnergy });
/*      */     } 
/*      */     
/* 1916 */     property = config.get("general", "Render Building Blocks as Normal Block On", false);
/* 1917 */     property.comment = "Server Sided! If enabled then you can place blocks (for example levers) on the Building Blocks, but they will create shadows and could cause more lagg. (default: false)";
/* 1918 */     cBuildingBlocksRenderAsNormalBlock = property.getBoolean();
/* 1919 */     BuildingBlocksRenderAsNormalBlock = cBuildingBlocksRenderAsNormalBlock;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1925 */     property = config.get("NarutoC Server Sided Configs", "Explosion Tags Explode when Tick Timer is Over On", false);
/* 1926 */     property.comment = "Server Sided! Naruto C Explosion Tags Explode when Tick Timer is Over On. (default: false)";
/* 1927 */     cNCExplosionTagTickTimerExplode = property.getBoolean();
/* 1928 */     NCExplosionTagTickTimerExplode = cNCExplosionTagTickTimerExplode;
/*      */     
/* 1930 */     property = config.get("NarutoC Server Sided Configs", "Explosion Tag Tick Timer", 10000);
/* 1931 */     property.comment = "Server Sided! Naruto C Exploding Tags explode after x Minecraft Ticks. 0 = disabled. From 0 to 1000000. (default: 1000000)";
/* 1932 */     cNCExplosionTagTickTimer = property.getInt(10000);
/* 1933 */     if (cNCExplosionTagTickTimer < 0) cNCExplosionTagTickTimer = 0; 
/* 1934 */     if (cNCExplosionTagTickTimer > 1000000) cNCExplosionTagTickTimer = 1000000; 
/* 1935 */     NCExplosionTagTickTimer = cNCExplosionTagTickTimer;
/*      */     
/* 1937 */     property = config.get("NarutoC Server Sided Configs", "Explosion Tag Detection Range Multiplier", 1.0D);
/* 1938 */     property.comment = "Server Sided! Naruto C Exploding Tags Detection Range multiplier to explode if someone is near it. (Bigger numbers can cause more lagg). From 0 to 100. (default: 1.0)";
/* 1939 */     cNCExplosionTagDetectionRange = (float)property.getDouble(1.0D);
/* 1940 */     if (cNCExplosionTagDetectionRange < 0.0F) cNCExplosionTagDetectionRange = 0.0F; 
/* 1941 */     if (cNCExplosionTagDetectionRange > 100.0F) cNCExplosionTagDetectionRange = 100.0F; 
/* 1942 */     NCExplosionTagDetectionRange = cNCExplosionTagDetectionRange;
/*      */     
/* 1944 */     property = config.get("NarutoC Server Sided Configs", "Explosion Tag Explosion Size Multiplier", 1.0D);
/* 1945 */     property.comment = "Server Sided! Naruto C Exploding Tags Explosion Size multiplier. (Bigger numbers can cause more lagg). From 0 to 15. (default: 1.0)";
/* 1946 */     cNCExplosionTagExplosionSize = (float)property.getDouble(1.0D);
/* 1947 */     if (cNCExplosionTagExplosionSize < 0.0F) cNCExplosionTagExplosionSize = 0.0F; 
/* 1948 */     if (cNCExplosionTagExplosionSize > 15.0F) cNCExplosionTagExplosionSize = 15.0F; 
/* 1949 */     NCExplosionTagExplosionSize = cNCExplosionTagExplosionSize;
/*      */ 
/*      */     
/* 1952 */     String[] defSafeZone = { "net.minecraft.entity.monster.EntityMob", "net.minecraft.entity.IProjectile", "net.minecraft.entity.EntityFlying", "net.minecraft.entity.passive.EntityBat", "JinRyuu.DragonBC.common.Npcs.EntityDBCNeut", "JinRyuu.DragonBC.common.Npcs.EntityDBCEvil", "JinRyuu.DragonBC.common.Npcs.EntityDBCWildlife", "JinRyuu.NarutoC.common.Npcs.EntityNCEvil" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1966 */     property = config.get("general", "Safe Zone Entity Blacklist", defSafeZone, "Server Sided! List down the Class paths and name of the Entities.");
/*      */     
/* 1968 */     data = property.getStringList();
/* 1969 */     for (String line : data)
/*      */     {
/* 1971 */       SafeZoneEntityBlacklist.put(line, Boolean.valueOf(true));
/*      */     }
/*      */ 
/*      */     
/* 1975 */     String[] defSafeZone2 = { "JinRyuu.DragonBC.common.Entitys.EntityInstantTransmission" };
/*      */ 
/*      */     
/* 1978 */     property = config.get("general", "Safe Zone Entity Whitelist", defSafeZone2, "Server Sided! List down the Class paths and name of the Entities.");
/*      */     
/* 1980 */     data = property.getStringList();
/* 1981 */     for (String line : data)
/*      */     {
/* 1983 */       SafeZoneEntityWhitelist.put(line, Boolean.valueOf(true));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1996 */     i = new int[] { 1, 1, 1, 1, 1, 1 };
/* 1997 */     s = new String[i.length]; int i7;
/* 1998 */     for (i7 = 0; i7 < s.length; i7++) {
/* 1999 */       s[i7] = JRMCoreH.Races[i7] + " " + i[i7];
/*      */     }
/* 2001 */     property = config.get("DBC Server Sided Configs", "Training Points Gain per Race - 'TP gain / melee' rate", s, "Server Sided! Multiplies the Default 'Training Points Gain - 'TP gain / melee' rate' Config by this values depending on the Player's race (From 0 to 10000).");
/*      */     
/* 2003 */     flt = new float[i.length];
/* 2004 */     sa = new String[i.length];
/* 2005 */     len = (property.getStringList()).length;
/* 2006 */     for (i7 = 0; i7 < i.length; i7++) {
/* 2007 */       int value = (len > i7) ? Integer.parseInt(property.getStringList()[i7].split(" ")[1]) : i[i7];
/* 2008 */       value = (value < 0) ? 0 : ((value > 10000) ? 10000 : value);
/* 2009 */       i[i7] = value;
/* 2010 */       flt[i7] = value;
/* 2011 */       sa[i7] = s[i7].split(" ")[0] + " " + ((len > i7) ? property.getStringList()[i7].split(" ")[1] : (String)Integer.valueOf(i[i7]));
/*      */     } 
/* 2013 */     TPGainRateRace = flt;
/* 2014 */     cTPGainRateRace = flt;
/* 2015 */     property.set(sa);
/*      */ 
/*      */ 
/*      */     
/* 2019 */     i = new int[] { 1, 1, 1, 1, 1, 1 };
/* 2020 */     s = new String[i.length];
/* 2021 */     for (i7 = 0; i7 < s.length; i7++) {
/* 2022 */       s[i7] = JRMCoreH.Races[i7] + " " + i[i7];
/*      */     }
/* 2024 */     property = config.get("DBC Server Sided Configs", "Training Point Gain per Race - TP amount gained", s, "Server Sided! Multiplies the Default 'Training Point Gain - TP amount gained' Config by this values depending on the Player's race (From 0 to 10000).");
/*      */     
/* 2026 */     flt = new float[i.length];
/* 2027 */     sa = new String[i.length];
/* 2028 */     len = (property.getStringList()).length;
/* 2029 */     for (i7 = 0; i7 < i.length; i7++) {
/* 2030 */       int value = (len > i7) ? Integer.parseInt(property.getStringList()[i7].split(" ")[1]) : i[i7];
/* 2031 */       value = (value < 0) ? 0 : ((value > 10000) ? 10000 : value);
/* 2032 */       i[i7] = value;
/* 2033 */       flt[i7] = value;
/* 2034 */       sa[i7] = s[i7].split(" ")[0] + " " + ((len > i7) ? property.getStringList()[i7].split(" ")[1] : (String)Integer.valueOf(i[i7]));
/*      */     } 
/* 2036 */     TPGainRace = flt;
/* 2037 */     cTPGainRace = flt;
/* 2038 */     property.set(sa);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2047 */     property = config.get("general", "Attribute Upgrade Cost - Start Minus", 140);
/* 2048 */     property.comment = "Server Sided! Divides Attribute Upgrade Costs (UC) by this value. If result is below Minimum value then use that instead. From 0 to 1000000000. (default: 140)";
/* 2049 */     cAttributeUpgradeCost_StartMinus = property.getInt();
/* 2050 */     if (cAttributeUpgradeCost_StartMinus < 0) cAttributeUpgradeCost_StartMinus = 0; 
/* 2051 */     if (cAttributeUpgradeCost_StartMinus > 1000000000) cAttributeUpgradeCost_StartMinus = 1000000000; 
/* 2052 */     AttributeUpgradeCost_StartMinus = cAttributeUpgradeCost_StartMinus;
/*      */     
/* 2054 */     property = config.get("general", "Attribute Upgrade Cost - Minimum value", 16);
/* 2055 */     property.comment = "Server Sided! Minimum value for Attribute Upgrade Costs (UC). From 0 to 1000000000. (default: 16)";
/* 2056 */     cAttributeUpgradeCost_Min = property.getInt();
/* 2057 */     if (cAttributeUpgradeCost_Min < 0) cAttributeUpgradeCost_Min = 0; 
/* 2058 */     if (cAttributeUpgradeCost_Min > 1000000000) cAttributeUpgradeCost_Min = 1000000000; 
/* 2059 */     AttributeUpgradeCost_Min = cAttributeUpgradeCost_Min;
/*      */     
/* 2061 */     double[] DEF_AttributeUpgradeCost_AttributeMulti = { 0.75D, 0.75D, 0.75D, 0.75D, 0.75D, 0.75D };
/* 2062 */     property = config.get("general", "Attribute Upgrade Cost - Attribute Multiplier", DEF_AttributeUpgradeCost_AttributeMulti);
/* 2063 */     property.comment = "Server Sided! Multiplies your Attributes by this value when calculating the Attribute Upgrade Costs (UC). From 0 to 1000000000. (default: 0.75 0.75 0.75 0.75 0.75 0.75)";
/*      */     
/* 2065 */     double[] dList = property.getDoubleList();
/* 2066 */     for (int i8 = 0; i8 < cAttributeUpgradeCost_AttributeMulti.length; i8++) {
/* 2067 */       cAttributeUpgradeCost_AttributeMulti[i8] = (float)((dList.length <= i8) ? cAttributeUpgradeCost_AttributeMulti[i8] : dList[i8]);
/* 2068 */       if (cAttributeUpgradeCost_AttributeMulti[i8] < 0.0F) cAttributeUpgradeCost_AttributeMulti[i8] = 0.0F; 
/* 2069 */       if (cAttributeUpgradeCost_AttributeMulti[i8] > 1000000.0F) cAttributeUpgradeCost_AttributeMulti[i8] = 1000000.0F; 
/* 2070 */       AttributeUpgradeCost_AttributeMulti[i8] = cAttributeUpgradeCost_AttributeMulti[i8];
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2080 */     property = config.get("Command Configs", "jrmcheal - Notify admins if used on Self", true);
/* 2081 */     property.comment = "Server Sided! Means notify ops when command is used on self. (default: true)";
/* 2082 */     cComHealNAS = property.getBoolean();
/* 2083 */     ComHealNAS = cComHealNAS;
/* 2084 */     property = config.get("Command Configs", "jrmcheal - Notify admins if used by Console", true);
/* 2085 */     property.comment = "Server Sided! Means notify ops when command is used by console. (default: true)";
/* 2086 */     cComHealNAC = property.getBoolean();
/* 2087 */     ComHealNAC = cComHealNAC;
/* 2088 */     property = config.get("Command Configs", "jrmcheal - Notify admins if used by Others", true);
/* 2089 */     property.comment = "Server Sided! Means notify ops when command is used by someone on someone else. (default: true)";
/* 2090 */     cComHealNAO = property.getBoolean();
/* 2091 */     ComHealNAO = cComHealNAO;
/*      */     
/* 2093 */     property = config.get("Command Configs", "jrmctp - Notify admins if used on Self", true);
/* 2094 */     property.comment = "Server Sided! Means notify ops when command is used on self. (default: true)";
/* 2095 */     cComTPNAS = property.getBoolean();
/* 2096 */     ComTPNAS = cComTPNAS;
/* 2097 */     property = config.get("Command Configs", "jrmctp - Notify admins if used by Console", true);
/* 2098 */     property.comment = "Server Sided! Means notify ops when command is used by console. (default: true)";
/* 2099 */     cComTPNAC = property.getBoolean();
/* 2100 */     ComTPNAC = cComTPNAC;
/* 2101 */     property = config.get("Command Configs", "jrmctp - Notify admins if used by Others", true);
/* 2102 */     property.comment = "Server Sided! Means notify ops when command is used by someone on someone else. (default: true)";
/* 2103 */     cComTPNAO = property.getBoolean();
/* 2104 */     ComTPNAO = cComTPNAO;
/*      */     
/* 2106 */     property = config.get("Command Configs", "jrmca - Notify admins if used on Self", true);
/* 2107 */     property.comment = "Server Sided! Means notify ops when command is used on self. (default: true)";
/* 2108 */     cComANAS = property.getBoolean();
/* 2109 */     ComANAS = cComANAS;
/* 2110 */     property = config.get("Command Configs", "jrmca - Notify admins if used by Console", true);
/* 2111 */     property.comment = "Server Sided! Means notify ops when command is used by console. (default: true)";
/* 2112 */     cComANAC = property.getBoolean();
/* 2113 */     ComANAC = cComANAC;
/* 2114 */     property = config.get("Command Configs", "jrmca - Notify admins if used by Others", true);
/* 2115 */     property.comment = "Server Sided! Means notify ops when command is used by someone on someone else. (default: true)";
/* 2116 */     cComANAO = property.getBoolean();
/* 2117 */     ComANAO = cComANAO;
/*      */     
/* 2119 */     property = config.get("Command Configs", "jrmcse - Notify admins if used on Self", true);
/* 2120 */     property.comment = "Server Sided! Means notify ops when command is used on self. (default: true)";
/* 2121 */     cComSENAS = property.getBoolean();
/* 2122 */     ComSENAS = cComSENAS;
/* 2123 */     property = config.get("Command Configs", "jrmcse - Notify admins if used by Console", true);
/* 2124 */     property.comment = "Server Sided! Means notify ops when command is used by console. (default: true)";
/* 2125 */     cComSENAC = property.getBoolean();
/* 2126 */     ComSENAC = cComSENAC;
/* 2127 */     property = config.get("Command Configs", "jrmcse - Notify admins if used by Others", true);
/* 2128 */     property.comment = "Server Sided! Means notify ops when command is used by someone on someone else. (default: true)";
/* 2129 */     cComSENAO = property.getBoolean();
/* 2130 */     ComSENAO = cComSENAO;
/*      */     
/* 2132 */     property = config.get("Command Configs", "jrmcm - Notify admins if used on Self", true);
/* 2133 */     property.comment = "Server Sided! Means notify ops when command is used on self. (default: true)";
/* 2134 */     cComMNAS = property.getBoolean();
/* 2135 */     ComMNAS = cComMNAS;
/* 2136 */     property = config.get("Command Configs", "jrmcm - Notify admins if used by Console", true);
/* 2137 */     property.comment = "Server Sided! Means notify ops when command is used by console. (default: true)";
/* 2138 */     cComSENAC = property.getBoolean();
/* 2139 */     ComMNAC = cComMNAC;
/* 2140 */     property = config.get("Command Configs", "jrmcm - Notify admins if used by Others", true);
/* 2141 */     property.comment = "Server Sided! Means notify ops when command is used by someone on someone else. (default: true)";
/* 2142 */     cComMNAO = property.getBoolean();
/* 2143 */     ComMNAO = cComMNAO;
/*      */     
/* 2145 */     property = config.get("Command Configs", "jrmcracialskill - Notify admins if used on Self", true);
/* 2146 */     property.comment = "Server Sided! Means notify ops when command is used on self. (default: true)";
/* 2147 */     cComRSNAS = property.getBoolean();
/* 2148 */     ComRSNAS = cComRSNAS;
/* 2149 */     property = config.get("Command Configs", "jrmcracialskill - Notify admins if used by Console", true);
/* 2150 */     property.comment = "Server Sided! Means notify ops when command is used by console. (default: true)";
/* 2151 */     cComRSNAC = property.getBoolean();
/* 2152 */     ComRSNAC = cComRSNAC;
/* 2153 */     property = config.get("Command Configs", "jrmcracialskill - Notify admins if used by Others", true);
/* 2154 */     property.comment = "Server Sided! Means notify ops when command is used by someone on someone else. (default: true)";
/* 2155 */     cComRSNAO = property.getBoolean();
/* 2156 */     ComRSNAO = cComRSNAO;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2162 */     property = config.get("Command Configs", "jrmcabonus - Notify admins if used on Self", true);
/* 2163 */     property.comment = "Server Sided! Means notify ops when command is used on self. (default: true)";
/* 2164 */     cCommandNotifyAdminJRMCABonusSelf = property.getBoolean();
/* 2165 */     CommandNotifyAdminJRMCABonusSelf = cCommandNotifyAdminJRMCABonusSelf;
/*      */     
/* 2167 */     property = config.get("Command Configs", "jrmcabonus - Notify admins if used by Console", true);
/* 2168 */     property.comment = "Server Sided! Means notify ops when command is used by console. (default: true)";
/* 2169 */     cCommandNotifyAdminJRMCABonusConsole = property.getBoolean();
/* 2170 */     CommandNotifyAdminJRMCABonusConsole = cCommandNotifyAdminJRMCABonusConsole;
/*      */     
/* 2172 */     property = config.get("Command Configs", "jrmcabonus - Notify admins if used by Others", true);
/* 2173 */     property.comment = "Server Sided! Means notify ops when command is used by someone on someone else. (default: true)";
/* 2174 */     cCommandNotifyAdminJRMCABonusOthers = property.getBoolean();
/* 2175 */     CommandNotifyAdminJRMCABonusOthers = cCommandNotifyAdminJRMCABonusOthers;
/*      */ 
/*      */ 
/*      */     
/* 2179 */     property = config.get("Command Configs", "jrmcabonuscheck - Check other player's sheet without OP On", true);
/* 2180 */     property.comment = "Server Sided! jrmcabonuscheck - Allows non OP Players to check other player's sheet. (default: true)";
/* 2181 */     cJRMCABonusCheckOnOthersWithoutOP = property.getBoolean();
/* 2182 */     JRMCABonusCheckOnOthersWithoutOP = cJRMCABonusCheckOnOthersWithoutOP;
/*      */     
/* 2184 */     property = config.get("Command Configs", "jrmccheck - Check other player's sheet without OP On", true);
/* 2185 */     property.comment = "Server Sided! jrmccheck - Allows non OP Players to check other player's sheet. (default: true)";
/* 2186 */     cJRMCCheckOnOthersWithoutOP = property.getBoolean();
/* 2187 */     JRMCCheckOnOthersWithoutOP = cJRMCCheckOnOthersWithoutOP;
/*      */ 
/*      */     
/* 2190 */     config.save();
/*      */   }
/*      */   
/*      */   public static boolean cDebugInfo = true;
/*      */   public static boolean DebugInfo = true;
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */