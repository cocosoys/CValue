/*      */ package JinRyuu.DragonBC.common;
/*      */ 
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import net.minecraftforge.common.config.Configuration;
/*      */ import net.minecraftforge.common.config.Property;
/*      */ 
/*      */ public class DBCConfig
/*      */ {
/*   10 */   public static int playerCount = 0;
/*   11 */   public static int planetEarth = 0;
/*   12 */   public static int planetNamek = 20;
/*   13 */   public static int planetVegeta = 21;
/*   14 */   public static int otherWorld = 22;
/*   15 */   public static int dimTimeChamber = 23;
/*   16 */   public static int dimNullRealm = 24;
/*      */   
/*      */   public static boolean oldDsh;
/*      */   
/*      */   public static boolean oldJmp;
/*      */   
/*      */   public static boolean oldFly;
/*      */   
/*      */   public static boolean plntVegeta;
/*      */   public static boolean flyAnyLvl;
/*   26 */   public static int eDBrate = 2;
/*   27 */   public static int nDBrate = 3;
/*   28 */   public static int maxTrnExp = 1000;
/*   29 */   public static int healingpodhealingrate = 100;
/*   30 */   public static int senzuFromKarin = 1;
/*   31 */   public static int senzuCool = 15;
/*      */   
/*      */   public static boolean coldDsh;
/*      */   
/*      */   public static boolean coldJmp;
/*      */   
/*      */   public static boolean coldFly;
/*      */   public static boolean cplntVegeta;
/*      */   public static boolean cflyAnyLvl;
/*   40 */   public static int ceDBrate = 2;
/*   41 */   public static int cnDBrate = 3;
/*   42 */   public static int cmaxTrnExp = 1000;
/*   43 */   public static int chealingpodhealingrate = 100;
/*   44 */   public static int csenzuFromKarin = 1;
/*   45 */   public static int csenzuCool = 15;
/*      */ 
/*      */   
/*      */   public static int spdc;
/*      */ 
/*      */   
/*      */   public static int mdal;
/*      */   
/*      */   public static int mdat;
/*      */   
/*   55 */   public static int NPCOgreHP = 2000; public static int cNPCOgreHP;
/*   56 */   public static int NPCOgreDam = 500;
/*      */   
/*      */   public static int cNPCOgreDam;
/*   59 */   public static int NPC_RRMech1_HP = 200; public static int cNPC_RRMech1_HP;
/*   60 */   public static int NPC_RRMech1_Dam = 20;
/*      */   public static int cNPC_RRMech1_Dam;
/*   62 */   public static int NPC_RRMech2_HP = 240; public static int cNPC_RRMech2_HP;
/*   63 */   public static int NPC_RRMech2_Dam = 35;
/*      */   public static int cNPC_RRMech2_Dam;
/*   65 */   public static int NPC_RRMech3_HP = 280; public static int cNPC_RRMech3_HP;
/*   66 */   public static int NPC_RRMech3_Dam = 50;
/*      */   
/*      */   public static int cNPC_RRMech3_Dam;
/*   69 */   public static int NPC_SaberT_HP = 150; public static int cNPC_SaberT_HP;
/*   70 */   public static int NPC_SaberT_Dam = 15;
/*      */   
/*      */   public static int cNPC_SaberT_Dam;
/*   73 */   public static int NPC_Dino1_HP = 1000; public static int cNPC_Dino1_HP;
/*   74 */   public static int NPC_Dino1_Dam = 120;
/*      */   public static int cNPC_Dino1_Dam;
/*   76 */   public static int NPC_Dino2_HP = 300; public static int cNPC_Dino2_HP;
/*   77 */   public static int NPC_Dino2_Dam = 40;
/*      */   public static int cNPC_Dino2_Dam;
/*   79 */   public static int NPC_Dino3_HP = 500; public static int cNPC_Dino3_HP;
/*   80 */   public static int NPC_Dino3_Dam = 40;
/*      */   
/*      */   public static int cNPC_Dino3_Dam;
/*      */   
/*      */   public static int BearThiefDAM;
/*      */   
/*      */   public static int cBearThiefDAM;
/*      */   
/*      */   public static int BearThiefHP;
/*      */   
/*      */   public static int cBearThiefHP;
/*      */   
/*      */   public static int TigerBanditDAM;
/*      */   
/*      */   public static int cTigerBanditDAM;
/*      */   
/*      */   public static int TigerBanditHP;
/*      */   
/*      */   public static int cTigerBanditHP;
/*      */   
/*      */   public static int RRMajorDAM;
/*      */   
/*      */   public static int cRRMajorDAM;
/*      */   
/*      */   public static int RRMajorHP;
/*      */   
/*      */   public static int cRRMajorHP;
/*      */   
/*      */   public static int RRSoldierDAM;
/*      */   
/*      */   public static int cRRSoldierDAM;
/*      */   
/*      */   public static int RRSoldierHP;
/*      */   
/*      */   public static int cRRSoldierHP;
/*      */   
/*      */   public static int RRSoldier2DAM;
/*      */   
/*      */   public static int cRRSoldier2DAM;
/*      */   
/*      */   public static int RRSoldier2HP;
/*      */   
/*      */   public static int cRRSoldier2HP;
/*      */   
/*      */   public static int RRSoldier3DAM;
/*      */   
/*      */   public static int cRRSoldier3DAM;
/*      */   
/*      */   public static int RRSoldier3HP;
/*      */   
/*      */   public static int cRRSoldier3HP;
/*      */   
/*      */   public static int spwnrt_ogre;
/*      */   
/*      */   public static int cspwnrt_ogre;
/*      */   
/*      */   public static int spwnrt_rrmech1;
/*      */   
/*      */   public static int cspwnrt_rrmech1;
/*      */   
/*      */   public static int spwnrt_sabert;
/*      */   
/*      */   public static int cspwnrt_sabert;
/*      */   
/*      */   public static int spwnrt_dino1;
/*      */   
/*      */   public static int cspwnrt_dino1;
/*      */   
/*      */   public static int spwnrt_dino2;
/*      */   
/*      */   public static int cspwnrt_dino2;
/*      */   
/*      */   public static int spwnrt_dino3;
/*      */   
/*      */   public static int cspwnrt_dino3;
/*      */   public static int spwnrt_frg;
/*      */   public static int cspwnrt_frg;
/*      */   public static int spwnrt_syn;
/*      */   public static int cspwnrt_syn;
/*  159 */   public static double[][] RevAng = new double[3][2]; public static int spwnrt_syn2; public static int cspwnrt_syn2; public static int SpawnrateBearThief; public static int cSpawnrateBearThief; public static int SpawnrateTigerBandit; public static int cSpawnrateTigerBandit; public static int SpawnrateRRMajor; public static int cSpawnrateRRMajor; public static int SpawnrateRRSoldiers; public static int cSpawnrateRRSoldiers; public static boolean DeadInv; public static boolean cDeadInv; public static boolean FreeRev; public static boolean cFreeRev; public static float Reinc; public static float cReinc; public static int RevTm; public static int cRevTm; public static double[] RevLocG; public static double[] cRevLocG; public static double[] RevLocN; public static double[] cRevLocN; public static double[] RevLocE; public static double[] cRevLocE; public static boolean Godform; public static boolean cGodform; public static boolean GodformCosm; public static boolean cGodformCosm; public static int StrainGod; public static int cStrainGod; public static int SSGHelp; public static int cSSGHelp; public static int TechExpRate; public static int cTechExpRate; public static int TechExpNeed; public static int cTechExpNeed; public static int TechCostMod; public static int cTechCostMod; public static boolean DsblO; public static boolean cDsblO; public static boolean cDBGT; public static boolean DBGT;
/*  160 */   public static double[][] cRevAng = new double[3][2];
/*      */ 
/*      */   
/*  163 */   public static int[] RevDim = new int[3];
/*  164 */   public static int[] cRevDim = new int[3];
/*      */ 
/*      */   
/*  167 */   public static double[][] DeathDim = new double[3][3];
/*  168 */   public static double[][] cDeathDim = new double[3][3];
/*      */ 
/*      */   
/*      */   public static double[] cWhisTeleportLocationBack;
/*      */ 
/*      */   
/*      */   public static double[] WhisTeleportLocationBack;
/*      */ 
/*      */   
/*      */   public static double[] cWhisTeleportLocationNull;
/*      */ 
/*      */   
/*      */   public static double[] WhisTeleportLocationNull;
/*      */ 
/*      */   
/*      */   public static boolean cCanWhisTeleport;
/*      */ 
/*      */   
/*      */   public static boolean CanWhisTeleport;
/*      */ 
/*      */   
/*      */   public static boolean cNullRealmBGColorNodeGreen;
/*      */ 
/*      */   
/*      */   public static boolean NullRealmBGColorNodeGreen;
/*      */ 
/*      */   
/*      */   public static final String CATEGORY_SERVERSIDED = "general";
/*      */ 
/*      */   
/*      */   public static final String CATEGORY_NPCCONFIGS = "NPC Configs";
/*      */ 
/*      */   
/*      */   public static final String CATEGORY_DEATHSYSTEM = "Death System Configs";
/*      */ 
/*      */   
/*      */   public static final String CATEGORY_TIMECHAMBER = "Hyperbolic Time Chamber Configs";
/*      */ 
/*      */   
/*      */   public static final String CATEGORY_CLIENTSIDED = "Client Sided Configs";
/*      */ 
/*      */   
/*      */   public static final String CATEGORY_TRANSFORMATIONS = "Transformation Configs";
/*      */   
/*      */   public static final String CATEGORY_TECHNIQUES = "Techniques Configs";
/*      */   
/*      */   public static final String CATEGORY_HEALTHPOD = "Health Pod Configs";
/*      */   
/*      */   public static double cnfKFd;
/*      */   
/*      */   public static double cnfKFc;
/*      */   
/*      */   public static double cnfKId;
/*      */   
/*      */   public static double cnfKIc;
/*      */   
/*      */   public static double cnfKDd;
/*      */   
/*      */   public static double cnfKDc;
/*      */   
/*      */   public static double cnfKBld;
/*      */   
/*      */   public static double cnfKBlc;
/*      */   
/*      */   public static double cnfKCsd;
/*      */   
/*      */   public static double cnfKCsc;
/*      */   
/*      */   public static double cnfSpc;
/*      */   
/*      */   public static double cnfFlnmb;
/*      */   
/*      */   public static double cnfFlncst;
/*      */   
/*      */   public static double cnfFlnck;
/*      */   
/*      */   public static int cnfDrt;
/*      */   
/*      */   public static double ccnfKFd;
/*      */   
/*      */   public static double ccnfKFc;
/*      */   
/*      */   public static double ccnfKId;
/*      */   
/*      */   public static double ccnfKIc;
/*      */   
/*      */   public static double ccnfKDd;
/*      */   
/*      */   public static double ccnfKDc;
/*      */   
/*      */   public static double ccnfKBld;
/*      */   
/*      */   public static double ccnfKBlc;
/*      */   
/*      */   public static double ccnfKCsd;
/*      */   
/*      */   public static double ccnfKCsc;
/*      */   
/*      */   public static double ccnfSpc;
/*      */   
/*      */   public static double ccnfFlnmb;
/*      */   
/*      */   public static double ccnfFlncst;
/*      */   
/*      */   public static double ccnfFlnck;
/*      */   
/*      */   public static int ccnfDrt;
/*      */   
/*      */   public static int hPodUpd;
/*      */   
/*      */   public static int chPodUpd;
/*      */   
/*  280 */   public static int[] hPodRate = new int[3];
/*      */   
/*  282 */   public static int[] chPodRate = new int[3];
/*      */   
/*  284 */   public static boolean[] hPodPerc = new boolean[3];
/*      */   
/*  286 */   public static boolean[] chPodPerc = new boolean[3];
/*      */   
/*      */   public static float cEnmaScale;
/*      */   
/*      */   public static float cGuruScale;
/*      */   
/*      */   public static float EnmaScale;
/*      */   
/*      */   public static float GuruScale;
/*      */   
/*      */   public static int cNullRealmMinimumHeight;
/*      */   
/*      */   public static int NullRealmMinimumHeight;
/*      */   
/*      */   public static int cAaiForceDifficulty;
/*      */   
/*      */   public static int AaiForceDifficulty;
/*      */   
/*      */   public static boolean cAaiDisabled;
/*      */   
/*      */   public static boolean AaiDisabled;
/*      */   
/*      */   public static int cEnemyDefaultAttackTimer;
/*      */   
/*      */   public static int EnemyDefaultAttackTimer;
/*      */   
/*      */   public static int cEnemyDefaultShortRangeAttackTimer;
/*      */   
/*      */   public static int EnemyDefaultShortRangeAttackTimer;
/*      */   public static double cEnemyDefaultMoveSpeed;
/*      */   public static double EnemyDefaultMoveSpeed;
/*      */   public static boolean cKiAttackGoThroughInvulnerableEnemies;
/*      */   public static boolean KiAttackGoThroughInvulnerableEnemies;
/*      */   public static int InstantTransformKiPercentageCost;
/*      */   public static int InstantTransformKiCost;
/*      */   public static boolean cInstantTransformOn;
/*      */   public static boolean InstantTransformOn;
/*      */   public static boolean cSingleFormDescendOn;
/*      */   public static boolean SingleFormDescendOn;
/*      */   public static final int INSTANT_KAIOKEN = 0;
/*      */   public static final int INSTANT_UI = 1;
/*      */   public static final int INSTANT_MYSTIC = 2;
/*      */   public static final int INSTANT_GOD = 3;
/*  329 */   public static boolean[] cIsInstantTransformEnabled = new boolean[4];
/*  330 */   public static boolean[] IsInstantTransformEnabled = new boolean[4];
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean cKaiokenSingleFormDescendOn;
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean KaiokenSingleFormDescendOn;
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean cMoveWhileTransforming;
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean MoveWhileTransforming;
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean cMoveWhileInstantTransforming;
/*      */ 
/*      */   
/*      */   public static boolean MoveWhileInstantTransforming;
/*      */ 
/*      */   
/*      */   public static boolean EnemyTeleportOutOfLock;
/*      */ 
/*      */   
/*      */   public static boolean cMysticKaiokenOn;
/*      */ 
/*      */   
/*      */   public static boolean MysticKaiokenOn;
/*      */ 
/*      */ 
/*      */   
/*      */   public static void init(Configuration config) {
/*  367 */     config.load();
/*      */     
/*  369 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  376 */     Property mtp = config.get("general", "Max Training Experience Limit", 1000);
/*  377 */     mtp.comment = "Server Sided! Max training experience limit can be set from 0-30000 (default: 1000). This is not TP this is Exp.";
/*  378 */     cmaxTrnExp = mtp.getInt(1000);
/*  379 */     if (cmaxTrnExp < 0) cmaxTrnExp = 0; 
/*  380 */     if (cmaxTrnExp > 30000) cmaxTrnExp = 30000; 
/*  381 */     maxTrnExp = cmaxTrnExp;
/*      */     
/*  383 */     Property pv = config.get("general", "Planet Vegeta", true);
/*  384 */     pv.comment = "Server Sided! If 'false' then Planet Vegeta wont appear, If 'true' then Planet Vegeta will be available.";
/*  385 */     cplntVegeta = pv.getBoolean(true);
/*  386 */     plntVegeta = cplntVegeta;
/*      */     
/*  388 */     Property edbsr = config.get("general", "Earth Dragon Block Spawn Rate", 2);
/*  389 */     edbsr.comment = "Server Sided! Spawn rate can only be from 1 (everyday 1 DB, around everyplayer somewhere) to 100 (extremly rare spawn, 100 days 1 DB) ";
/*  390 */     ceDBrate = edbsr.getInt(2);
/*  391 */     if (ceDBrate < 1) ceDBrate = 1; 
/*  392 */     if (ceDBrate > 100) ceDBrate = 100; 
/*  393 */     eDBrate = ceDBrate;
/*      */     
/*  395 */     Property ndbsr = config.get("general", "Namek Dragon Block Spawn Rate", 3);
/*  396 */     ndbsr.comment = "Server Sided! Spawn rate can only be from 1 (everyday 1 DB, around everyplayer somewhere) to 100 (extremly rare spawn, 100 days 1 DB) ";
/*  397 */     cnDBrate = ndbsr.getInt(3);
/*  398 */     if (cnDBrate < 1) cnDBrate = 1; 
/*  399 */     if (cnDBrate > 100) cnDBrate = 100; 
/*  400 */     nDBrate = cnDBrate;
/*      */     
/*  402 */     Property od = config.get("Client Sided Configs", "Old Dash", false);
/*  403 */     od.comment = "If 'false' then the current sprint dash will be used, If 'true' then the one key press and hold (R) dash will be available.";
/*  404 */     coldDsh = od.getBoolean(false);
/*  405 */     oldDsh = coldDsh;
/*  406 */     Property oj = config.get("Client Sided Configs", "Old Jump", false);
/*  407 */     oj.comment = "If 'false' then the current space jump will be used, If 'true' then the one key press and hold (X) jump will be available.";
/*  408 */     coldJmp = oj.getBoolean(false);
/*  409 */     oldJmp = coldJmp;
/*  410 */     Property of = config.get("Client Sided Configs", "Old Fly", false);
/*  411 */     of.comment = "If 'false' then the current turn on/off fly will be used, If 'true' then the one key press and hold (F) Fly and (Ctrl) for float will be available.";
/*  412 */     coldFly = of.getBoolean(false);
/*  413 */     oldFly = coldFly;
/*      */ 
/*      */     
/*  416 */     Property oc = config.get("general", "Fly with no Fly Skill", false);
/*  417 */     oc.comment = "Server Sided! If 'false' then one can only fly with Fly Skill, If 'true' then one will be able to Fly without Fly Skill.";
/*  418 */     cflyAnyLvl = oc.getBoolean(false);
/*  419 */     flyAnyLvl = cflyAnyLvl;
/*      */     
/*  421 */     Property p = config.get("general", "Spacepods drop timer", 60);
/*  422 */     p.comment = "Server Sided! Spacepods will drop after given seconds if not being ridden. If 0 they wont drop! (Default: 60)";
/*  423 */     spdc = p.getInt(60);
/*      */     
/*  425 */     p = config.get("general", "Saga mob despawn area limit", 100);
/*  426 */     p.comment = "Server Sided! Saga mobs will despawn if the mob spawner (a player) is not in the area in specified block radius after specific seconds that can be set in 'Saga mob despawn timer' config option. If 0 Saga mobs wont despawn! (Default: 100)";
/*  427 */     mdal = p.getInt(100);
/*      */     
/*  429 */     p = config.get("general", "Saga mob despawn timer", 120);
/*  430 */     p.comment = "Server Sided! Saga mob despawn timer in seconds, if spawner not near it. If 'Saga mob despawn area limit' config option is 0 this wont work! (Default: 120)";
/*  431 */     mdat = p.getInt(120);
/*  432 */     mdat = (mdat < 1) ? 1 : mdat;
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
/*  445 */     Property DeathSystemOff = config.get("Death System Configs", "Death System Off", false);
/*  446 */     DeathSystemOff.comment = "Server Sided! If 'false' then Death System is on, If 'true' then its off. (may reduce lag if true)";
/*  447 */     mod_DragonBC.cDeathSystemOff = DeathSystemOff.getBoolean(false);
/*  448 */     mod_DragonBC.DeathSystemOff = mod_DragonBC.cDeathSystemOff;
/*      */ 
/*      */     
/*  451 */     Property DBSpawnEnabled = config.get("general", "Dragon Blocks Spawn Enabled", true);
/*  452 */     DBSpawnEnabled.comment = "Server Sided! If 'true' Dragon Blocks will spawn, if 'false' then they wont spawn at all. (may reduce lag if false)";
/*  453 */     mod_DragonBC.cDBSpawnEnabled = DBSpawnEnabled.getBoolean(true);
/*  454 */     mod_DragonBC.DBSpawnEnabled = mod_DragonBC.cDBSpawnEnabled;
/*      */     
/*  456 */     Property DBSpawn = config.get("general", "Dragon Blocks Spawn Chance", 4);
/*  457 */     DBSpawn.comment = "Server Sided! The maximum number (default: 4) of Dragon Blocks spawned around the players, in a 64 block radius. (from 0 to 7)";
/*  458 */     mod_DragonBC.cDBSpawnChance = DBSpawn.getInt(4);
/*  459 */     mod_DragonBC.DBSpawnChance = mod_DragonBC.cDBSpawnChance;
/*      */ 
/*      */     
/*  462 */     Property DBSpawnTime = config.get("general", "Dragon Blocks Spawn Time", "midday");
/*  463 */     DBSpawnTime.comment = "Server Sided! The daytime when the Dragon Blocks will spawn. 3 states, 'morning', 'midday'(default), and 'evening'.";
/*  464 */     mod_DragonBC.cDBSpawnTime = DBSpawnTime.getString();
/*  465 */     mod_DragonBC.DBSpawnTime = mod_DragonBC.cDBSpawnTime;
/*      */     
/*  467 */     Property SagaSystemOn = config.get("general", "Saga System On", true);
/*  468 */     SagaSystemOn.comment = "Server Sided! If 'true' Saga System will work, if 'false' then no one will be able to progress in Saga System.  (may reduce lag if false)";
/*  469 */     mod_DragonBC.cSagaSystemOn = SagaSystemOn.getBoolean(true);
/*  470 */     mod_DragonBC.SagaSystemOn = mod_DragonBC.cSagaSystemOn;
/*      */ 
/*      */     
/*  473 */     Property SagaSysSpawnPods = config.get("general", "Saga System Spawn Spacepods", true);
/*  474 */     SagaSysSpawnPods.comment = "Server Sided! If 'true' Spacepods will spawn in the saga part where it can, if 'false' then Spacepods wont spawn.";
/*  475 */     mod_DragonBC.cSagaSysSpawnPods = SagaSysSpawnPods.getBoolean(true);
/*  476 */     mod_DragonBC.SagaSysSpawnPods = mod_DragonBC.cSagaSysSpawnPods;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  485 */     Property senzu = config.get("general", "Senzu from Korin", 1);
/*  486 */     senzu.comment = "Server Sided! Number of Senzu from Korin! (from 1 to 10)";
/*  487 */     csenzuFromKarin = senzu.getInt(1);
/*  488 */     if (csenzuFromKarin < 1) csenzuFromKarin = 1; 
/*  489 */     if (csenzuFromKarin > 10) csenzuFromKarin = 10; 
/*  490 */     senzuFromKarin = csenzuFromKarin;
/*      */     
/*  492 */     Property prop = config.get("general", "Senzu from Korin", 1);
/*  493 */     prop.comment = "Server Sided! Number of Senzu from Korin! (from 1 to 10)";
/*  494 */     csenzuFromKarin = prop.getInt(1);
/*  495 */     if (csenzuFromKarin < 1) csenzuFromKarin = 1; 
/*  496 */     if (csenzuFromKarin > 10) csenzuFromKarin = 10; 
/*  497 */     senzuFromKarin = csenzuFromKarin;
/*      */     
/*  499 */     prop = config.get("general", "Senzu Cooldown", 20);
/*  500 */     prop.comment = "Server Sided! Indicates how long senzu can not be used, In seconds! (from 0 to 1200)";
/*  501 */     csenzuCool = prop.getInt(20);
/*  502 */     if (csenzuCool < 0) csenzuCool = 0; 
/*  503 */     if (csenzuCool > 1200) csenzuCool = 1200; 
/*  504 */     senzuCool = csenzuCool;
/*      */ 
/*      */ 
/*      */     
/*  508 */     prop = config.get("general", "Ki Fist Damage per level", 2.5D);
/*  509 */     prop.comment = "Server Sided! Ki Fist Damage Percentage multiplier value from 0 to 30. (default: 2.50)";
/*  510 */     ccnfKFd = prop.getDouble(2.5D);
/*  511 */     if (ccnfKFd < 0.0D) ccnfKFd = 0.0D;  if (ccnfKFd > 30.0D) ccnfKFd = 30.0D; 
/*  512 */     cnfKFd = ccnfKFd;
/*      */     
/*  514 */     prop = config.get("general", "Ki Fist Cost per level", 1.0D);
/*  515 */     prop.comment = "Server Sided! Ki Fist Cost Percentage multiplier value from 0 to 30. (default: 1.00)";
/*  516 */     ccnfKFc = prop.getDouble(1.0D);
/*  517 */     if (ccnfKFc < 0.0D) ccnfKFc = 0.0D;  if (ccnfKFc > 30.0D) ccnfKFc = 30.0D; 
/*  518 */     cnfKFc = ccnfKFc;
/*      */ 
/*      */     
/*  521 */     prop = config.get("general", "Ki Infuse Damage per level", 2.5D);
/*  522 */     prop.comment = "Server Sided! Ki Infuse Damage Percentage multiplier value from 0 to 30. (default: 2.50)";
/*  523 */     ccnfKId = prop.getDouble(2.5D);
/*  524 */     if (ccnfKId < 0.0D) ccnfKId = 0.0D;  if (ccnfKId > 30.0D) ccnfKId = 30.0D; 
/*  525 */     cnfKId = ccnfKId;
/*      */     
/*  527 */     prop = config.get("general", "Ki Infuse Cost per level", 1.0D);
/*  528 */     prop.comment = "Server Sided! Ki Infuse Cost Percentage multiplier value from 0 to 30. (default: 1.00)";
/*  529 */     ccnfKIc = prop.getDouble(1.0D);
/*  530 */     if (ccnfKIc < 0.0D) ccnfKIc = 0.0D;  if (ccnfKIc > 30.0D) ccnfKIc = 30.0D; 
/*  531 */     cnfKIc = ccnfKIc;
/*      */ 
/*      */     
/*  534 */     prop = config.get("general", "Ki Protection Armor per level", 2.0D);
/*  535 */     prop.comment = "Server Sided! Ki Protection Armor Percentage multiplier value from 0 to 30. (default: 2.00)";
/*  536 */     ccnfKDd = prop.getDouble(2.0D);
/*  537 */     if (ccnfKDd < 0.0D) ccnfKDd = 0.0D;  if (ccnfKDd > 30.0D) ccnfKDd = 30.0D; 
/*  538 */     cnfKDd = ccnfKDd;
/*      */     
/*  540 */     prop = config.get("general", "Ki Protection Cost per level", 0.5D);
/*  541 */     prop.comment = "Server Sided! Ki Protection Cost Percentage multiplier value from 0 to 30. (default: 0.50)";
/*  542 */     ccnfKDc = prop.getDouble(0.5D);
/*  543 */     if (ccnfKDc < 0.0D) ccnfKDc = 0.0D;  if (ccnfKDc > 30.0D) ccnfKDc = 30.0D; 
/*  544 */     cnfKDc = ccnfKDc;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  553 */     prop = config.get("general", "Ki Blade Damage multiplier", 1.0D);
/*  554 */     prop.comment = "Server Sided! Ki Blade Damage multiplier value from 0 to 30. (default: 1.00)";
/*  555 */     ccnfKBld = prop.getDouble(1.0D);
/*  556 */     if (ccnfKBld < 0.0D) ccnfKBld = 0.0D;  if (ccnfKBld > 30.0D) ccnfKBld = 30.0D; 
/*  557 */     cnfKBld = ccnfKBld;
/*      */     
/*  559 */     prop = config.get("general", "Ki Blade Cost multiplier", 1.0D);
/*  560 */     prop.comment = "Server Sided! Ki Blade Cost multiplier value from 0 to 30. (default: 1.00)";
/*  561 */     ccnfKBlc = prop.getDouble(1.0D);
/*  562 */     if (ccnfKBlc < 0.0D) ccnfKBld = 0.0D;  if (ccnfKBlc > 30.0D) ccnfKBlc = 30.0D; 
/*  563 */     cnfKBlc = ccnfKBlc;
/*      */ 
/*      */     
/*  566 */     prop = config.get("general", "Ki Scythe Damage multiplier", 3.0D);
/*  567 */     prop.comment = "Server Sided! Ki Scythe Damage multiplier value from 0 to 30. (default: 3.00)";
/*  568 */     ccnfKCsd = prop.getDouble(3.0D);
/*  569 */     if (ccnfKCsd < 0.0D) ccnfKCsd = 0.0D;  if (ccnfKCsd > 30.0D) ccnfKCsd = 30.0D; 
/*  570 */     cnfKCsd = ccnfKCsd;
/*      */     
/*  572 */     prop = config.get("general", "Ki Scythe Cost multiplier", 3.0D);
/*  573 */     prop.comment = "Server Sided! Ki Scythe Cost multiplier value from 0 to 30. (default: 3.00)";
/*  574 */     ccnfKCsc = prop.getDouble(3.0D);
/*  575 */     if (ccnfKCsc < 0.0D) ccnfKCsc = 0.0D;  if (ccnfKCsc > 30.0D) ccnfKCsc = 30.0D; 
/*  576 */     cnfKCsc = ccnfKCsc;
/*      */ 
/*      */ 
/*      */     
/*  580 */     prop = config.get("general", "Space pod speed multiplier", 1.75D);
/*  581 */     prop.comment = "Server Sided! Space pod speed multiplier value from 0 to 30. (default: 1.75)";
/*  582 */     ccnfSpc = prop.getDouble(1.75D);
/*  583 */     if (ccnfSpc < 0.0D) ccnfSpc = 0.0D;  if (ccnfSpc > 30.0D) ccnfSpc = 30.0D; 
/*  584 */     cnfSpc = ccnfSpc;
/*      */     
/*  586 */     prop = config.get("general", "Flying Nimbus speed multiplier", 2.25D);
/*  587 */     prop.comment = "Server Sided! Flying Nimbus speed multiplier value from 0 to 30. (default: 2.25)";
/*  588 */     ccnfFlnmb = prop.getDouble(2.25D);
/*  589 */     if (ccnfFlnmb < 0.0D) ccnfFlnmb = 0.0D;  if (ccnfFlnmb > 30.0D) ccnfFlnmb = 30.0D; 
/*  590 */     cnfFlnmb = ccnfFlnmb;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  599 */     prop = config.get("general", "Player Flying, and dodging stamina cost multiplier", 0.1D);
/*  600 */     prop.comment = "Server Sided! Player Flying, and dodging stamina cost multiplier value from 0 to 30. (default: 0.1)";
/*  601 */     ccnfFlncst = prop.getDouble(0.1D);
/*  602 */     if (ccnfFlncst < 0.0D) ccnfFlncst = 0.0D;  if (ccnfFlncst > 30.0D) ccnfFlncst = 30.0D; 
/*  603 */     cnfFlncst = ccnfFlncst;
/*      */     
/*  605 */     prop = config.get("general", "Player Flying ki cost multiplier", 0.5D);
/*  606 */     prop.comment = "Server Sided! Player Flying ki cost multiplier value from 0 to 30. (default: 0.5)";
/*  607 */     ccnfFlnck = prop.getDouble(0.5D);
/*  608 */     if (ccnfFlnck < 0.0D) ccnfFlnck = 0.0D;  if (ccnfFlnck > 30.0D) ccnfFlnck = 30.0D; 
/*  609 */     cnfFlnck = ccnfFlnck;
/*      */ 
/*      */     
/*  612 */     prop = config.get("general", "Dirty Stone biome spawn rate", 15);
/*  613 */     prop.comment = "Server Sided! Dirty Stone biome spawn rate value from 0 to 30. (default: 15)";
/*  614 */     ccnfDrt = prop.getInt(15);
/*  615 */     if (ccnfDrt < 0) ccnfDrt = 0;  if (ccnfDrt > 30) ccnfDrt = 30; 
/*  616 */     cnfDrt = ccnfDrt;
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
/*  634 */     prop = config.get("NPC Configs", "NPC Otherworld Ogre Stat Health", 2000);
/*  635 */     prop.comment = "Server Sided! Otherworld Ogre NPCs Health amount from 10 to 100000. (default: 2000)";
/*  636 */     cNPCOgreHP = prop.getInt(2000);
/*  637 */     if (cNPCOgreHP < 10) cNPCOgreHP = 10; 
/*  638 */     if (cNPCOgreHP > 100000) cNPCOgreHP = 100000; 
/*  639 */     NPCOgreHP = cNPCOgreHP;
/*  640 */     prop = config.get("NPC Configs", "NPC Otherworld Ogre Stat Damage", 500);
/*  641 */     prop.comment = "Server Sided! Otherworld Ogre NPCs Damage amount from 10 to 100000. (default: 500)";
/*  642 */     cNPCOgreDam = prop.getInt(500);
/*  643 */     if (cNPCOgreDam < 10) cNPCOgreDam = 10; 
/*  644 */     if (cNPCOgreDam > 100000) cNPCOgreDam = 100000; 
/*  645 */     NPCOgreDam = cNPCOgreDam;
/*      */ 
/*      */     
/*  648 */     prop = config.get("NPC Configs", "NPC Red Ribbon Mecha 1 - Type 1 Stat Health", 200);
/*  649 */     prop.comment = "Server Sided! Red Ribbon Mecha 1 - Type 1 NPCs Health amount from 10 to 100000. (default: 200)";
/*  650 */     cNPC_RRMech1_HP = prop.getInt(200);
/*  651 */     if (cNPC_RRMech1_HP < 10) cNPC_RRMech1_HP = 10; 
/*  652 */     if (cNPC_RRMech1_HP > 100000) cNPC_RRMech1_HP = 100000; 
/*  653 */     NPC_RRMech1_HP = cNPC_RRMech1_HP;
/*  654 */     prop = config.get("NPC Configs", "NPC Red Ribbon Mecha 1 - Type 1 Stat Damage", 20);
/*  655 */     prop.comment = "Server Sided! Red Ribbon Mecha 1 - Type 1 NPCs Damage amount from 10 to 100000. (default: 20)";
/*  656 */     cNPC_RRMech1_Dam = prop.getInt(20);
/*  657 */     if (cNPC_RRMech1_Dam < 10) cNPC_RRMech1_Dam = 10; 
/*  658 */     if (cNPC_RRMech1_Dam > 100000) cNPC_RRMech1_Dam = 100000; 
/*  659 */     NPC_RRMech1_Dam = cNPC_RRMech1_Dam;
/*      */     
/*  661 */     prop = config.get("NPC Configs", "NPC Red Ribbon Mecha 1 - Type 2 Stat Health", 240);
/*  662 */     prop.comment = "Server Sided! Red Ribbon Mecha 1 - Type 2 NPCs Health amount from 10 to 100000. (default: 240)";
/*  663 */     cNPC_RRMech2_HP = prop.getInt(240);
/*  664 */     if (cNPC_RRMech2_HP < 10) cNPC_RRMech2_HP = 10; 
/*  665 */     if (cNPC_RRMech2_HP > 100000) cNPC_RRMech2_HP = 100000; 
/*  666 */     NPC_RRMech2_HP = cNPC_RRMech2_HP;
/*  667 */     prop = config.get("NPC Configs", "NPC Red Ribbon Mecha 1 - Type 2 Stat Damage", 35);
/*  668 */     prop.comment = "Server Sided! Red Ribbon Mecha 1 - Type 2 NPCs Damage amount from 10 to 100000. (default: 35)";
/*  669 */     cNPC_RRMech2_Dam = prop.getInt(35);
/*  670 */     if (cNPC_RRMech2_Dam < 10) cNPC_RRMech2_Dam = 10; 
/*  671 */     if (cNPC_RRMech2_Dam > 100000) cNPC_RRMech2_Dam = 100000; 
/*  672 */     NPC_RRMech2_Dam = cNPC_RRMech2_Dam;
/*      */     
/*  674 */     prop = config.get("NPC Configs", "NPC Red Ribbon Mecha 1 - Type 3 Stat Health", 280);
/*  675 */     prop.comment = "Server Sided! Red Ribbon Mecha 1 - Type 3 NPCs Health amount from 10 to 100000. (default: 280)";
/*  676 */     cNPC_RRMech3_HP = prop.getInt(280);
/*  677 */     if (cNPC_RRMech3_HP < 10) cNPC_RRMech3_HP = 10; 
/*  678 */     if (cNPC_RRMech3_HP > 100000) cNPC_RRMech3_HP = 100000; 
/*  679 */     NPC_RRMech3_HP = cNPC_RRMech3_HP;
/*  680 */     prop = config.get("NPC Configs", "NPC Red Ribbon Mecha 1 - Type 3 Stat Damage", 50);
/*  681 */     prop.comment = "Server Sided! Red Ribbon Mecha 1 - Type 3 NPCs Damage amount from 10 to 100000. (default: 50)";
/*  682 */     cNPC_RRMech3_Dam = prop.getInt(50);
/*  683 */     if (cNPC_RRMech3_Dam < 10) cNPC_RRMech3_Dam = 10; 
/*  684 */     if (cNPC_RRMech3_Dam > 100000) cNPC_RRMech3_Dam = 100000; 
/*  685 */     NPC_RRMech3_Dam = cNPC_RRMech3_Dam;
/*      */ 
/*      */ 
/*      */     
/*  689 */     prop = config.get("NPC Configs", "NPC Sabertooth Stat Health", 150);
/*  690 */     prop.comment = "Server Sided! Sabertooth NPCs Health amount from 10 to 100000. (default: 150)";
/*  691 */     cNPC_SaberT_HP = prop.getInt(150);
/*  692 */     if (cNPC_SaberT_HP < 10) cNPC_SaberT_HP = 10; 
/*  693 */     if (cNPC_SaberT_HP > 100000) cNPC_SaberT_HP = 100000; 
/*  694 */     NPC_SaberT_HP = cNPC_SaberT_HP;
/*  695 */     prop = config.get("NPC Configs", "NPC Sabertooth Stat Damage", 15);
/*  696 */     prop.comment = "Server Sided! Sabertooth NPCs Damage amount from 10 to 100000. (default: 15)";
/*  697 */     cNPC_SaberT_Dam = prop.getInt(15);
/*  698 */     if (cNPC_SaberT_Dam < 10) cNPC_SaberT_Dam = 10; 
/*  699 */     if (cNPC_SaberT_Dam > 100000) cNPC_SaberT_Dam = 100000; 
/*  700 */     NPC_SaberT_Dam = cNPC_SaberT_Dam;
/*      */ 
/*      */ 
/*      */     
/*  704 */     prop = config.get("NPC Configs", "NPC Dino 1 Stat Health", 1000);
/*  705 */     prop.comment = "Server Sided! Dino 1 NPCs Health amount from 10 to 100000. (default: 1000)";
/*  706 */     cNPC_Dino1_HP = prop.getInt(1000);
/*  707 */     if (cNPC_Dino1_HP < 10) cNPC_Dino1_HP = 10; 
/*  708 */     if (cNPC_Dino1_HP > 100000) cNPC_Dino1_HP = 100000; 
/*  709 */     NPC_Dino1_HP = cNPC_Dino1_HP;
/*  710 */     prop = config.get("NPC Configs", "NPC Dino 1 Stat Damage", 120);
/*  711 */     prop.comment = "Server Sided! Dino 1 NPCs Damage amount from 10 to 100000. (default: 120)";
/*  712 */     cNPC_Dino1_Dam = prop.getInt(120);
/*  713 */     if (cNPC_Dino1_Dam < 10) cNPC_Dino1_Dam = 10; 
/*  714 */     if (cNPC_Dino1_Dam > 100000) cNPC_Dino1_Dam = 100000; 
/*  715 */     NPC_Dino1_Dam = cNPC_Dino1_Dam;
/*      */     
/*  717 */     prop = config.get("NPC Configs", "NPC Dino 2 Stat Health", 300);
/*  718 */     prop.comment = "Server Sided! Dino 2 NPCs Health amount from 10 to 100000. (default: 300)";
/*  719 */     cNPC_Dino2_HP = prop.getInt(300);
/*  720 */     if (cNPC_Dino2_HP < 10) cNPC_Dino2_HP = 10; 
/*  721 */     if (cNPC_Dino2_HP > 100000) cNPC_Dino2_HP = 100000; 
/*  722 */     NPC_Dino2_HP = cNPC_Dino2_HP;
/*  723 */     prop = config.get("NPC Configs", "NPC Dino 2 Stat Damage", 40);
/*  724 */     prop.comment = "Server Sided! Dino 2 NPCs Damage amount from 10 to 100000. (default: 40)";
/*  725 */     cNPC_Dino2_Dam = prop.getInt(40);
/*  726 */     if (cNPC_Dino2_Dam < 10) cNPC_Dino2_Dam = 10; 
/*  727 */     if (cNPC_Dino2_Dam > 100000) cNPC_Dino2_Dam = 100000; 
/*  728 */     NPC_Dino2_Dam = cNPC_Dino2_Dam;
/*      */     
/*  730 */     prop = config.get("NPC Configs", "NPC Dino 3 Stat Health", 500);
/*  731 */     prop.comment = "Server Sided! Dino 3 NPCs Health amount from 10 to 100000. (default: 500)";
/*  732 */     cNPC_Dino3_HP = prop.getInt(500);
/*  733 */     if (cNPC_Dino3_HP < 10) cNPC_Dino3_HP = 10; 
/*  734 */     if (cNPC_Dino3_HP > 100000) cNPC_Dino3_HP = 100000; 
/*  735 */     NPC_Dino3_HP = cNPC_Dino3_HP;
/*  736 */     prop = config.get("NPC Configs", "NPC Dino 3 Stat Damage", 40);
/*  737 */     prop.comment = "Server Sided! Dino 3 NPCs Damage amount from 10 to 100000. (default: 40)";
/*  738 */     cNPC_Dino3_Dam = prop.getInt(40);
/*  739 */     if (cNPC_Dino3_Dam < 10) cNPC_Dino3_Dam = 10; 
/*  740 */     if (cNPC_Dino3_Dam > 100000) cNPC_Dino3_Dam = 100000; 
/*  741 */     NPC_Dino3_Dam = cNPC_Dino3_Dam;
/*      */ 
/*      */     
/*  744 */     int min = 10, max = 100000;
/*  745 */     int DAMDef = 0, HPDef = 0;
/*  746 */     String name = "";
/*      */ 
/*      */     
/*  749 */     DAMDef = 35; HPDef = 200;
/*  750 */     name = "Bear Thief";
/*  751 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Health", HPDef);
/*  752 */     prop.comment = "Server Sided! " + name + " NPCs Health amount from " + min + " to " + max + ". (default: " + HPDef + ")";
/*  753 */     cBearThiefHP = prop.getInt(HPDef);
/*  754 */     if (cBearThiefHP < min) cBearThiefHP = min; 
/*  755 */     if (cBearThiefHP > max) cBearThiefHP = max; 
/*  756 */     BearThiefHP = cBearThiefHP;
/*  757 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Damage", DAMDef);
/*  758 */     prop.comment = "Server Sided! " + name + " NPCs Damage amount from " + min + " to " + max + ". (default: " + DAMDef + ")";
/*  759 */     cBearThiefDAM = prop.getInt(DAMDef);
/*  760 */     if (cBearThiefDAM < min) cBearThiefDAM = min; 
/*  761 */     if (cBearThiefDAM > max) cBearThiefDAM = max; 
/*  762 */     BearThiefDAM = cBearThiefDAM;
/*      */     
/*  764 */     DAMDef = 30; HPDef = 200;
/*  765 */     name = "Tiger Bandit";
/*  766 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Health", HPDef);
/*  767 */     prop.comment = "Server Sided! " + name + " NPCs Health amount from " + min + " to " + max + ". (default: " + HPDef + ")";
/*  768 */     cTigerBanditHP = prop.getInt(HPDef);
/*  769 */     if (cTigerBanditHP < min) cTigerBanditHP = min; 
/*  770 */     if (cTigerBanditHP > max) cTigerBanditHP = max; 
/*  771 */     TigerBanditHP = cTigerBanditHP;
/*  772 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Damage", DAMDef);
/*  773 */     prop.comment = "Server Sided! " + name + " NPCs Damage amount from " + min + " to " + max + ". (default: " + DAMDef + ")";
/*  774 */     cTigerBanditDAM = prop.getInt(DAMDef);
/*  775 */     if (cTigerBanditDAM < min) cTigerBanditDAM = min; 
/*  776 */     if (cTigerBanditDAM > max) cTigerBanditDAM = max; 
/*  777 */     TigerBanditDAM = cTigerBanditDAM;
/*      */     
/*  779 */     DAMDef = 50; HPDef = 200;
/*  780 */     name = "Major Metallitron";
/*  781 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Health", HPDef);
/*  782 */     prop.comment = "Server Sided! " + name + " NPCs Health amount from " + min + " to " + max + ". (default: " + HPDef + ")";
/*  783 */     cRRMajorHP = prop.getInt(HPDef);
/*  784 */     if (cRRMajorHP < min) cRRMajorHP = min; 
/*  785 */     if (cRRMajorHP > max) cRRMajorHP = max; 
/*  786 */     RRMajorHP = cRRMajorHP;
/*  787 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Damage", DAMDef);
/*  788 */     prop.comment = "Server Sided! " + name + " NPCs Damage amount from " + min + " to " + max + ". (default: " + DAMDef + ")";
/*  789 */     cRRMajorDAM = prop.getInt(DAMDef);
/*  790 */     if (cRRMajorDAM < min) cRRMajorDAM = min; 
/*  791 */     if (cRRMajorDAM > max) cRRMajorDAM = max; 
/*  792 */     RRMajorDAM = cRRMajorDAM;
/*      */     
/*  794 */     DAMDef = 15; HPDef = 80;
/*  795 */     name = "Red Ribbon Soldier type 1";
/*  796 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Health", HPDef);
/*  797 */     prop.comment = "Server Sided! " + name + " NPCs Health amount from " + min + " to " + max + ". (default: " + HPDef + ")";
/*  798 */     cRRSoldierHP = prop.getInt(HPDef);
/*  799 */     if (cRRSoldierHP < min) cRRSoldierHP = min; 
/*  800 */     if (cRRSoldierHP > max) cRRSoldierHP = max; 
/*  801 */     RRSoldierHP = cRRSoldierHP;
/*  802 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Damage", DAMDef);
/*  803 */     prop.comment = "Server Sided! " + name + " NPCs Damage amount from " + min + " to " + max + ". (default: " + DAMDef + ")";
/*  804 */     cRRSoldierDAM = prop.getInt(DAMDef);
/*  805 */     if (cRRSoldierDAM < min) cRRSoldierDAM = min; 
/*  806 */     if (cRRSoldierDAM > max) cRRSoldierDAM = max; 
/*  807 */     RRSoldierDAM = cRRSoldierDAM;
/*      */     
/*  809 */     DAMDef = 20; HPDef = 80;
/*  810 */     name = "Red Ribbon Soldier type 2";
/*  811 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Health", HPDef);
/*  812 */     prop.comment = "Server Sided! " + name + " NPCs Health amount from " + min + " to " + max + ". (default: " + HPDef + ")";
/*  813 */     cRRSoldier2HP = prop.getInt(HPDef);
/*  814 */     if (cRRSoldier2HP < min) cRRSoldier2HP = min; 
/*  815 */     if (cRRSoldier2HP > max) cRRSoldier2HP = max; 
/*  816 */     RRSoldier2HP = cRRSoldier2HP;
/*  817 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Damage", DAMDef);
/*  818 */     prop.comment = "Server Sided! " + name + " NPCs Damage amount from " + min + " to " + max + ". (default: " + DAMDef + ")";
/*  819 */     cRRSoldier2DAM = prop.getInt(DAMDef);
/*  820 */     if (cRRSoldier2DAM < min) cRRSoldier2DAM = min; 
/*  821 */     if (cRRSoldier2DAM > max) cRRSoldier2DAM = max; 
/*  822 */     RRSoldier2DAM = cRRSoldier2DAM;
/*      */     
/*  824 */     DAMDef = 40; HPDef = 80;
/*  825 */     name = "Red Ribbon Soldier type 3";
/*  826 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Health", HPDef);
/*  827 */     prop.comment = "Server Sided! " + name + " NPCs Health amount from " + min + " to " + max + ". (default: " + HPDef + ")";
/*  828 */     cRRSoldier3HP = prop.getInt(HPDef);
/*  829 */     if (cRRSoldier3HP < min) cRRSoldier3HP = min; 
/*  830 */     if (cRRSoldier3HP > max) cRRSoldier3HP = max; 
/*  831 */     RRSoldier3HP = cRRSoldier3HP;
/*  832 */     prop = config.get("NPC Configs", "NPC " + name + " Stat Damage", DAMDef);
/*  833 */     prop.comment = "Server Sided! " + name + " NPCs Damage amount from " + min + " to " + max + ". (default: " + DAMDef + ")";
/*  834 */     cRRSoldier3DAM = prop.getInt(DAMDef);
/*  835 */     if (cRRSoldier3DAM < min) cRRSoldier3DAM = min; 
/*  836 */     if (cRRSoldier3DAM > max) cRRSoldier3DAM = max; 
/*  837 */     RRSoldier3DAM = cRRSoldier3DAM;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  845 */     prop = config.get("Health Pod Configs", "Health pod Update Timer (Tick)", 100);
/*  846 */     prop.comment = "Server Sided! Health pod Update Timer value from 1 to 10000. (Lower number can cause more lag) (default: 100)";
/*  847 */     chPodUpd = prop.getInt(100);
/*  848 */     if (chPodUpd < 1) chPodUpd = 1;  if (chPodUpd > 10000) chPodUpd = 10000; 
/*  849 */     hPodUpd = chPodUpd;
/*      */     
/*  851 */     boolean[] bo = { true, true, true };
/*  852 */     prop = config.get("Health Pod Configs", "Healing Pod Percentage healing (Health, Ki, Stamina)", bo, "Server Sided! Healing Pod Percentage healing. Sets whenever the 'Healing Pod Rate (Health, Ki, Stamina)' config heals by percentage amount, rather than a fix one. (default: true true true)");
/*  853 */     chPodPerc = prop.getBooleanList();
/*  854 */     hPodPerc = chPodPerc;
/*      */     
/*  856 */     int[] num = { 5, 5, 5 };
/*  857 */     prop = config.get("Health Pod Configs", "Healing Pod Rate (Health, Ki, Stamina) from 1 to 10000", num, "Server Sided! Healing Pod Rate. Sets the amount it will heal the Players. (default: 5 5 5)");
/*  858 */     chPodRate = prop.getIntList();
/*  859 */     hPodRate = chPodRate;
/*  860 */     for (int i = 0; i < num.length; i++) {
/*  861 */       if (hPodRate[i] < 1) { hPodRate[i] = 1; }
/*  862 */       else if (hPodRate[i] > 10000) { hPodRate[i] = 10000; }
/*      */ 
/*      */       
/*  865 */       if (hPodPerc[i] && hPodRate[i] > 100) hPodRate[i] = 100;
/*      */     
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
/*  878 */     prop = config.get("NPC Configs", "NPC Otherworld Ogre Spawn rate", 10);
/*  879 */     prop.comment = "Server Sided! Otherworld Ogre NPCs Spawn rate from 0 to 100. (default: 10)";
/*  880 */     cspwnrt_ogre = prop.getInt(10);
/*  881 */     if (cspwnrt_ogre < 0) cspwnrt_ogre = 0; 
/*  882 */     if (cspwnrt_ogre > 100) cspwnrt_ogre = 100; 
/*  883 */     spwnrt_ogre = cspwnrt_ogre;
/*      */ 
/*      */ 
/*      */     
/*  887 */     prop = config.get("NPC Configs", "NPC Red Ribbon Mecha 1 Spawn rate", 3);
/*  888 */     prop.comment = "Server Sided! Red Ribbon Mecha 1 NPCs Spawn rate from 0 to 100. (default: 3)";
/*  889 */     cspwnrt_rrmech1 = prop.getInt(3);
/*  890 */     if (cspwnrt_rrmech1 < 0) cspwnrt_rrmech1 = 0; 
/*  891 */     if (cspwnrt_rrmech1 > 100) cspwnrt_rrmech1 = 100; 
/*  892 */     spwnrt_rrmech1 = cspwnrt_rrmech1;
/*      */ 
/*      */ 
/*      */     
/*  896 */     prop = config.get("NPC Configs", "NPC Sabertooth Spawn rate", 2);
/*  897 */     prop.comment = "Server Sided! Sabertooth NPCs Spawn rate from 0 to 100. (default: 2)";
/*  898 */     cspwnrt_sabert = prop.getInt(2);
/*  899 */     if (cspwnrt_sabert < 0) cspwnrt_sabert = 0; 
/*  900 */     if (cspwnrt_sabert > 100) cspwnrt_sabert = 100; 
/*  901 */     spwnrt_sabert = cspwnrt_sabert;
/*      */ 
/*      */ 
/*      */     
/*  905 */     prop = config.get("NPC Configs", "NPC Dino 1 Spawn rate", 2);
/*  906 */     prop.comment = "Server Sided! Dino 1 NPCs Spawn rate from 0 to 100. (default: 2)";
/*  907 */     cspwnrt_dino1 = prop.getInt(2);
/*  908 */     if (cspwnrt_dino1 < 0) cspwnrt_dino1 = 0; 
/*  909 */     if (cspwnrt_dino1 > 100) cspwnrt_dino1 = 100; 
/*  910 */     spwnrt_dino1 = cspwnrt_dino1;
/*      */     
/*  912 */     prop = config.get("NPC Configs", "NPC Dino 2 Spawn rate", 10);
/*  913 */     prop.comment = "Server Sided! Dino 2 NPCs Spawn rate from 0 to 100. (default: 10)";
/*  914 */     cspwnrt_dino2 = prop.getInt(10);
/*  915 */     if (cspwnrt_dino2 < 0) cspwnrt_dino2 = 0; 
/*  916 */     if (cspwnrt_dino2 > 100) cspwnrt_dino2 = 100; 
/*  917 */     spwnrt_dino2 = cspwnrt_dino2;
/*      */     
/*  919 */     prop = config.get("NPC Configs", "NPC Dino 3 Spawn rate", 5);
/*  920 */     prop.comment = "Server Sided! Dino 3 NPCs Spawn rate from 0 to 100. (default: 5)";
/*  921 */     cspwnrt_dino3 = prop.getInt(5);
/*  922 */     if (cspwnrt_dino3 < 0) cspwnrt_dino3 = 0; 
/*  923 */     if (cspwnrt_dino3 > 100) cspwnrt_dino3 = 100; 
/*  924 */     spwnrt_dino3 = cspwnrt_dino3;
/*      */ 
/*      */ 
/*      */     
/*  928 */     prop = config.get("NPC Configs", "NPC Namekian Frog Spawn rate", 5);
/*  929 */     prop.comment = "Server Sided! Namekian Frog NPCs Spawn rate from 0 to 100. (default: 5)";
/*  930 */     cspwnrt_frg = prop.getInt(5);
/*  931 */     if (cspwnrt_frg < 0) cspwnrt_frg = 0; 
/*  932 */     if (cspwnrt_frg > 100) cspwnrt_frg = 100; 
/*  933 */     spwnrt_frg = cspwnrt_frg;
/*      */ 
/*      */ 
/*      */     
/*  937 */     prop = config.get("NPC Configs", "Planet Vegeta Saiyan 1 Spawn rate", 2);
/*  938 */     prop.comment = "Server Sided! Planet Vegeta Saiyan 1 Spawn rate from 0 to 100. (default: 2)";
/*  939 */     cspwnrt_syn = prop.getInt(2);
/*  940 */     if (cspwnrt_syn < 0) cspwnrt_syn = 0; 
/*  941 */     if (cspwnrt_syn > 100) cspwnrt_syn = 100; 
/*  942 */     spwnrt_syn = cspwnrt_syn;
/*      */     
/*  944 */     prop = config.get("NPC Configs", "Planet Vegeta Saiyan 1 Spawn rate", 4);
/*  945 */     prop.comment = "Server Sided! Planet Vegeta Saiyan 1 Spawn rate from 0 to 100. (default: 4)";
/*  946 */     cspwnrt_syn2 = prop.getInt(4);
/*  947 */     if (cspwnrt_syn2 < 0) cspwnrt_syn2 = 0; 
/*  948 */     if (cspwnrt_syn2 > 100) cspwnrt_syn2 = 100; 
/*  949 */     spwnrt_syn2 = cspwnrt_syn2;
/*      */ 
/*      */     
/*  952 */     int spawnrateDef = 0;
/*  953 */     min = 0; max = 100;
/*      */     
/*  955 */     spawnrateDef = 1;
/*  956 */     name = "Bear Thief";
/*  957 */     prop = config.get("NPC Configs", "NPC " + name + " Spawn rate", spawnrateDef);
/*  958 */     prop.comment = "Server Sided! " + name + " NPCs Spawn rate from " + min + " to " + max + ". (default: " + spawnrateDef + ")";
/*  959 */     cSpawnrateBearThief = prop.getInt(spawnrateDef);
/*  960 */     if (cSpawnrateBearThief < min) cSpawnrateBearThief = min; 
/*  961 */     if (cSpawnrateBearThief > max) cSpawnrateBearThief = max; 
/*  962 */     SpawnrateBearThief = cSpawnrateBearThief;
/*      */     
/*  964 */     spawnrateDef = 1;
/*  965 */     name = "Tiger Bandit";
/*  966 */     prop = config.get("NPC Configs", "NPC " + name + " Spawn rate", spawnrateDef);
/*  967 */     prop.comment = "Server Sided! " + name + " NPCs Spawn rate from " + min + " to " + max + ". (default: " + spawnrateDef + ")";
/*  968 */     cSpawnrateTigerBandit = prop.getInt(spawnrateDef);
/*  969 */     if (cSpawnrateTigerBandit < min) cSpawnrateTigerBandit = min; 
/*  970 */     if (cSpawnrateTigerBandit > max) cSpawnrateTigerBandit = max; 
/*  971 */     SpawnrateTigerBandit = cSpawnrateTigerBandit;
/*      */     
/*  973 */     spawnrateDef = 1;
/*  974 */     name = "Red Ribbon Major Metallitron";
/*  975 */     prop = config.get("NPC Configs", "NPC " + name + " Spawn rate", spawnrateDef);
/*  976 */     prop.comment = "Server Sided! " + name + " NPCs Spawn rate from " + min + " to " + max + ". (default: " + spawnrateDef + ")";
/*  977 */     cSpawnrateRRMajor = prop.getInt(spawnrateDef);
/*  978 */     if (cSpawnrateRRMajor < min) cSpawnrateRRMajor = min; 
/*  979 */     if (cSpawnrateRRMajor > max) cSpawnrateRRMajor = max; 
/*  980 */     SpawnrateRRMajor = cSpawnrateRRMajor;
/*      */     
/*  982 */     spawnrateDef = 1;
/*  983 */     name = "Red Ribbon Soldiers";
/*  984 */     prop = config.get("NPC Configs", "NPC " + name + " Spawn rate", spawnrateDef);
/*  985 */     prop.comment = "Server Sided! " + name + " NPCs Spawn rate from " + min + " to " + max + ". (default: " + spawnrateDef + ")";
/*  986 */     cSpawnrateRRSoldiers = prop.getInt(spawnrateDef);
/*  987 */     if (cSpawnrateRRSoldiers < min) cSpawnrateRRSoldiers = min; 
/*  988 */     if (cSpawnrateRRSoldiers > max) cSpawnrateRRSoldiers = max; 
/*  989 */     SpawnrateRRSoldiers = cSpawnrateRRSoldiers;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  994 */     prop = config.get("Death System Configs", "Death System - Switch Inventory", false);
/*  995 */     prop.comment = "Server Sided! If 'true' and keepInventory is On then players will have separate inventory for dead and living states (Creative switching while dead will cause issues). If 'false' then like it was before depending on keepInventory's state";
/*      */     
/*  997 */     cDeadInv = prop.getBoolean();
/*  998 */     DeadInv = cDeadInv;
/*      */     
/* 1000 */     prop = config.get("Death System Configs", "Death System - Free Revive", true);
/* 1001 */     prop.comment = "Server Sided! If 'true' players can revive for free, 'Revive Timer' config will be used to determine the revive interval.If 'false' then players wont be able to revive for free even after time, Only way to revive is to wish revival, by Reincarnation, or dbcrevive command.";
/*      */     
/* 1003 */     cFreeRev = prop.getBoolean();
/* 1004 */     FreeRev = cFreeRev;
/*      */     
/* 1006 */     prop = config.get("Death System Configs", "Death System - Revive Timer", 1);
/* 1007 */     prop.comment = "Server Sided! The time in minutes after a player can use 'Free Revive' if it is 'true'. The time can go from 1 min to 100000 mins (close to a week). (default: 1)";
/* 1008 */     cRevTm = prop.getInt() * 12;
/* 1009 */     if (cRevTm < 12) cRevTm = 12; 
/* 1010 */     if (cRevTm > 1200000) cRevTm = 1200000; 
/* 1011 */     RevTm = cRevTm;
/*      */     
/* 1013 */     prop = config.get("Death System Configs", "Death System - Reincarnation Penalty", 25);
/* 1014 */     prop.comment = "Server Sided! Reincarnation resets everything like starting new, but leaving a percentage of attributes left. Value can go from 0 to 100. (default: 25) #to disable it use 0!";
/* 1015 */     cReinc = prop.getInt() * 0.01001F;
/* 1016 */     if (cReinc < 0.0F) cReinc = 0.0F; 
/* 1017 */     if (cReinc > 1.0F) cReinc = 1.0F; 
/* 1018 */     Reinc = cReinc;
/*      */     
/* 1020 */     prop = config.get("Transformation Configs", "Transformation - SuperSaiyanGod Helpers needed", 5);
/* 1021 */     prop.comment = "Server Sided! The amount of Good Saiyans needed to preform the SSG ritual. The amount can go from 1 to 100. (default: 5)";
/* 1022 */     cSSGHelp = prop.getInt();
/* 1023 */     if (cSSGHelp < 1) cSSGHelp = 1; 
/* 1024 */     if (cSSGHelp > 100) cSSGHelp = 100; 
/* 1025 */     SSGHelp = cSSGHelp;
/*      */     
/* 1027 */     prop = config.get("Techniques Configs", "Ki Technique - Experience gain rate per hit", 1);
/* 1028 */     prop.comment = "Server Sided! Exp gain rate per living entity hit for ki techniques. The higher the more exp will be gained. The amount can go from 1 to 10000. (default: 1)";
/* 1029 */     cTechExpRate = prop.getInt();
/* 1030 */     if (cTechExpRate < 1) cTechExpRate = 1; 
/* 1031 */     if (cTechExpRate > 10000) cTechExpRate = 10000; 
/* 1032 */     TechExpRate = cTechExpRate;
/*      */     
/* 1034 */     prop = config.get("Techniques Configs", "Ki Technique - Experience needed to upgrade", 15);
/* 1035 */     prop.comment = "Server Sided! Exp amount needed to upgrade to first level, the other levels will multiplied with this amount. The higher the more exp will be needed to upgrade. The amount can go from 10 to 1000. (default: 15)";
/* 1036 */     cTechExpNeed = prop.getInt();
/* 1037 */     if (cTechExpNeed < 10) cTechExpNeed = 10; 
/* 1038 */     if (cTechExpNeed > 1000) cTechExpNeed = 1000; 
/* 1039 */     TechExpNeed = cTechExpNeed;
/*      */     
/* 1041 */     prop = config.get("Techniques Configs", "Ki Technique - Energy cost modifier", 50);
/* 1042 */     prop.comment = "Server Sided! Ki cost modifier, with this you can reduce in percentage the costs of ki attacks. So your Ki attacks can cost less or more Ki. The amount can go from 1 to 1000. (default: 100)";
/* 1043 */     cTechCostMod = prop.getInt();
/* 1044 */     if (cTechCostMod < 1) cTechCostMod = 1; 
/* 1045 */     if (cTechCostMod > 1000) cTechCostMod = 1000; 
/* 1046 */     TechCostMod = cTechCostMod;
/*      */     
/* 1048 */     prop = config.get("Transformation Configs", "Transformation - SuperSaiyanGod Helpers fatigue", 10);
/* 1049 */     prop.comment = "Server Sided! How long helper saiyans can't help in SSG ritual again. The time can go from 0 mins to 1000 mins. (default: 10)";
/* 1050 */     cStrainGod = prop.getInt() * 12;
/* 1051 */     if (cStrainGod < 0) cStrainGod = 0; 
/* 1052 */     if (cStrainGod > 12000) cStrainGod = 12000; 
/* 1053 */     StrainGod = cStrainGod;
/*      */ 
/*      */     
/* 1056 */     double[] d = { 75.0D, 220.0D, 55.0D };
/* 1057 */     prop = config.get("Death System Configs", "Death System - Good Revive Location", d, "Server Sided! Revive position for players with good alignment.");
/* 1058 */     cRevLocG = prop.getDoubleList();
/* 1059 */     RevLocG = cRevLocG;
/* 1060 */     d = new double[] { 58.0D, 220.0D, 7.0D };
/* 1061 */     prop = config.get("Death System Configs", "Death System - Neutral Revive Location", d, "Server Sided! Revive position for players with neutral alignment.");
/* 1062 */     cRevLocN = prop.getDoubleList();
/* 1063 */     RevLocN = cRevLocN;
/* 1064 */     d = new double[] { 96.0D, 230.0D, 7.0D };
/* 1065 */     prop = config.get("Death System Configs", "Death System - Evil Revive Location", d, "Server Sided! Revive position for players with evil alignment.");
/* 1066 */     cRevLocE = prop.getDoubleList();
/* 1067 */     RevLocE = cRevLocE;
/*      */ 
/*      */     
/* 1070 */     String[] datas = { "Good", "Neutral", "Evil" };
/* 1071 */     d = new double[] { 0.0D, 0.0D }; int j;
/* 1072 */     for (j = 0; j < datas.length; j++) {
/* 1073 */       prop = config.get("Death System Configs", "Death System - " + datas[j] + " Revive Rotation", d, "Server Sided! Revive rotation for players with " + datas[j] + " alignment.");
/* 1074 */       cRevAng[j] = prop.getDoubleList();
/* 1075 */       RevAng[j] = cRevAng[j];
/*      */     } 
/*      */     
/* 1078 */     for (j = 0; j < datas.length; j++) {
/* 1079 */       prop = config.get("Death System Configs", "Death System - " + datas[j] + " Revive Dimension", 0, "Server Sided! Revive dimension for players with " + datas[j] + " alignment.");
/* 1080 */       prop = config.get("Death System Configs", "Death System - " + datas[j] + " Revive Dimension", 0, "Server Sided! Revive dimension for players with " + datas[j] + " alignment.");
/* 1081 */       cRevDim[j] = prop.getInt();
/* 1082 */       RevDim[j] = cRevDim[j];
/*      */     } 
/*      */ 
/*      */     
/* 1086 */     d = new double[] { 75.0D, 92.0D, 127.0D };
/* 1087 */     for (j = 0; j < datas.length; j++) {
/* 1088 */       prop = config.get("Death System Configs", "Death System - " + datas[j] + " Death Location Otherworld", d, "Server Sided! Death location in the Otherworld for players with " + datas[j] + " alignment. (X, Y, Z)");
/*      */       
/* 1090 */       cDeathDim[j] = prop.getDoubleList();
/* 1091 */       DeathDim[j] = cDeathDim[j];
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
/* 1103 */     d = new double[] { 8.0D, 135.0D, 70.0D };
/* 1104 */     prop = config.get("NPC Configs", "Whis Teleportation Location in the Null Realm", d, "Server Sided! Whis Teleportation Location in the Null Realm.");
/* 1105 */     cWhisTeleportLocationNull = prop.getDoubleList();
/* 1106 */     WhisTeleportLocationNull = cWhisTeleportLocationNull;
/*      */     
/* 1108 */     d = new double[] { 71.0D, 217.0D, 60.0D };
/* 1109 */     prop = config.get("NPC Configs", "Whis Teleportation Location in the Overworld", d, "Server Sided! Whis Teleportation Location in the Overworld.");
/* 1110 */     cWhisTeleportLocationBack = prop.getDoubleList();
/* 1111 */     WhisTeleportLocationBack = cWhisTeleportLocationBack;
/*      */ 
/*      */     
/* 1114 */     prop = config.get("NPC Configs", "Whis Teleportation can be used", true, "Server Sided! Whis Teleportation can be used.");
/* 1115 */     cCanWhisTeleport = prop.getBoolean();
/* 1116 */     CanWhisTeleport = cCanWhisTeleport;
/*      */ 
/*      */     
/* 1119 */     prop = config.get("NPC Configs", "Enma Scale", 1.3D);
/* 1120 */     prop.comment = "Server Sided! Enma Scale. (default: 1.3)";
/* 1121 */     cEnmaScale = (float)prop.getDouble(1.3D);
/* 1122 */     if (cEnmaScale < 0.0F) cEnmaScale = 0.0F;  if (cEnmaScale > 10000.0F) cEnmaScale = 10000.0F; 
/* 1123 */     EnmaScale = cEnmaScale;
/*      */ 
/*      */     
/* 1126 */     prop = config.get("NPC Configs", "Guru Scale", 1.25D);
/* 1127 */     prop.comment = "Server Sided! Guru Scale. (default: 1.25)";
/* 1128 */     cGuruScale = (float)prop.getDouble(1.25D);
/* 1129 */     if (cGuruScale < 0.0F) cGuruScale = 0.0F;  if (cGuruScale > 10000.0F) cGuruScale = 10000.0F; 
/* 1130 */     GuruScale = cGuruScale;
/*      */ 
/*      */     
/* 1133 */     prop = config.get("general", "Null Realm Minimum Height", 20);
/* 1134 */     prop.comment = "Server Sided! Null Realm Minimum Height. Teleports people below this Y location to Whis. (default: 20)";
/* 1135 */     cNullRealmMinimumHeight = prop.getInt(20);
/* 1136 */     NullRealmMinimumHeight = cNullRealmMinimumHeight;
/*      */     
/* 1138 */     prop = config.get("general", "Null Realm Background Color Green", true, "Server Sided! Null Realm Background Color is Green (TRUE) or Purple (FALSE).");
/* 1139 */     cNullRealmBGColorNodeGreen = prop.getBoolean();
/* 1140 */     NullRealmBGColorNodeGreen = cNullRealmBGColorNodeGreen;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1146 */     prop = config.get("NPC Configs", "DBC Advanced AI Force Difficulty", -1);
/* 1147 */     prop.comment = "Server Sided! Forces a specific AI difficulty for DBC Entities using the AAi System. (default: -1)\n(-1 = Force Disabled | 0 = Easy | 1 = Medium | 2 = Hard | 3 = Insane)";
/*      */     
/* 1149 */     cAaiForceDifficulty = prop.getInt(-1);
/* 1150 */     if (cAaiForceDifficulty < -1) { cAaiForceDifficulty = -1; }
/* 1151 */     else if (cAaiForceDifficulty > 3) { cAaiForceDifficulty = 3; }
/* 1152 */      AaiForceDifficulty = cAaiForceDifficulty;
/*      */     
/* 1154 */     prop = config.get("NPC Configs", "DBC AAI Disabled", false, "Server Sided! is DBC Advanced AI System enabled. (true OR false) (default: false)");
/* 1155 */     cAaiDisabled = prop.getBoolean();
/* 1156 */     AaiDisabled = cAaiDisabled;
/*      */     
/* 1158 */     prop = config.get("NPC Configs", "DBC Enemy Default Attack Tick Timer", 35);
/* 1159 */     prop.comment = "Server Sided! Sets how often a DBC enemy/entity attacks when possible From 0 to 10000. (default: 35)";
/* 1160 */     cEnemyDefaultAttackTimer = prop.getInt(35);
/* 1161 */     if (cEnemyDefaultAttackTimer < 0) { cEnemyDefaultAttackTimer = 0; }
/* 1162 */     else if (cEnemyDefaultAttackTimer > 10000) { cEnemyDefaultAttackTimer = 10000; }
/* 1163 */      EnemyDefaultAttackTimer = cEnemyDefaultAttackTimer;
/*      */     
/* 1165 */     prop = config.get("NPC Configs", "DBC Enemy Default Short Range Attack Tick Timer", 15);
/* 1166 */     prop.comment = "Server Sided! Sets how often a DBC enemy/entity attacks when possible and close to the target From 0 to 10000.\n(Must be lower than the Default Attack Tick Timer) (default: 15)";
/*      */     
/* 1168 */     cEnemyDefaultShortRangeAttackTimer = prop.getInt(15);
/* 1169 */     if (cEnemyDefaultShortRangeAttackTimer < 0) { cEnemyDefaultShortRangeAttackTimer = 0; }
/* 1170 */     else if (cEnemyDefaultShortRangeAttackTimer > EnemyDefaultAttackTimer) { cEnemyDefaultShortRangeAttackTimer = EnemyDefaultAttackTimer; }
/* 1171 */      EnemyDefaultShortRangeAttackTimer = cEnemyDefaultShortRangeAttackTimer;
/*      */     
/* 1173 */     prop = config.get("NPC Configs", "DBC Enemy Default Movement Speed", 0.699D);
/* 1174 */     prop.comment = "Server Sided! From 0 to 100. (default: 0.699)";
/* 1175 */     cEnemyDefaultMoveSpeed = prop.getDouble(0.699D);
/* 1176 */     if (cEnemyDefaultMoveSpeed < 0.0D) { cEnemyDefaultMoveSpeed = 0.0D; }
/* 1177 */     else if (cEnemyDefaultMoveSpeed > 100.0D) { cEnemyDefaultMoveSpeed = 100.0D; }
/* 1178 */      EnemyDefaultMoveSpeed = cEnemyDefaultMoveSpeed;
/*      */     
/* 1180 */     prop = config.get("general", "Ki Attacks Go Through Invulnerable Enemies", false, "Server Sided! True = Go through Enemies they can't damage. False = Vanish when hitting Enemies they can't damage. (true OR false) (default: false)");
/*      */     
/* 1182 */     cKiAttackGoThroughInvulnerableEnemies = prop.getBoolean();
/* 1183 */     KiAttackGoThroughInvulnerableEnemies = cKiAttackGoThroughInvulnerableEnemies;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1188 */     prop = config.get("Transformation Configs", "Instant Transformation Percentage Ki Cost", 3);
/* 1189 */     prop.comment = "Server Sided! Instant Transformation Percentage Ki Cost. (default: 3)";
/* 1190 */     InstantTransformKiPercentageCost = prop.getInt(3);
/* 1191 */     if (InstantTransformKiPercentageCost < 0) { InstantTransformKiPercentageCost = 0; }
/* 1192 */     else if (InstantTransformKiPercentageCost > 100) { InstantTransformKiPercentageCost = 100; }
/*      */ 
/*      */     
/* 1195 */     prop = config.get("Transformation Configs", "Instant Transformation Ki Cost", 1000);
/* 1196 */     prop.comment = "Server Sided! Instant Transformation Ki Cost. (default: 1000)";
/* 1197 */     InstantTransformKiCost = prop.getInt(1000);
/* 1198 */     if (InstantTransformKiCost < 0) InstantTransformKiCost = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1203 */     prop = config.get("Transformation Configs", "Instant Transformation On", true, "Server Sided! True = Instant Transformation On. (true OR false) (default: true)");
/*      */     
/* 1205 */     cInstantTransformOn = prop.getBoolean();
/* 1206 */     InstantTransformOn = cInstantTransformOn;
/*      */     
/* 1208 */     prop = config.get("Transformation Configs", "Single Form Descend On", true, "Server Sided! True = Single Form Descend On. (true OR false) (default: true)");
/*      */     
/* 1210 */     cSingleFormDescendOn = prop.getBoolean();
/* 1211 */     SingleFormDescendOn = cSingleFormDescendOn;
/*      */ 
/*      */     
/* 1214 */     prop = config.get("Transformation Configs", "Kaioken Single Form Descend On", true, "Server Sided! True = Kaioken Single Form Descend On. (true OR false) (default: true)");
/*      */     
/* 1216 */     cKaiokenSingleFormDescendOn = prop.getBoolean();
/* 1217 */     KaiokenSingleFormDescendOn = cKaiokenSingleFormDescendOn;
/*      */ 
/*      */     
/* 1220 */     String[] stringList = { "Kaioken false", "UltraInstinct false", "Mystic false", "GodOfDestruction false" };
/* 1221 */     prop = config.get("Transformation Configs", "Other Enabled Instant Transformation Skills and Forms", stringList);
/* 1222 */     prop.comment = "Server Sided! A list of Skills and Forms that can be enabled (true) or disabled (false) if players can Instant Transform to them.";
/* 1223 */     String[] stringListValues = prop.getStringList();
/* 1224 */     for (int k = 0; k < IsInstantTransformEnabled.length; k++) {
/*      */       
/* 1226 */       String string = "";
/* 1227 */       if (stringListValues.length <= k) {
/* 1228 */         string = stringList[k];
/*      */       } else {
/*      */         
/* 1231 */         stringList[k] = stringListValues[k];
/* 1232 */         string = stringListValues[k];
/*      */       } 
/* 1234 */       cIsInstantTransformEnabled[k] = Boolean.parseBoolean(string.split(" ")[1]);
/* 1235 */       IsInstantTransformEnabled[k] = cIsInstantTransformEnabled[k];
/*      */     } 
/* 1237 */     prop.set(stringList);
/*      */ 
/*      */     
/* 1240 */     prop = config.get("Transformation Configs", "Players can Move while Transforming On", false, "Server Sided! True = Players can move while they are Transforming. (true OR false) (default: false)");
/*      */     
/* 1242 */     cMoveWhileTransforming = prop.getBoolean();
/* 1243 */     MoveWhileTransforming = cMoveWhileTransforming;
/*      */     
/* 1245 */     prop = config.get("Transformation Configs", "Players can Move while Instant Transforming On", true, "Server Sided! True = Players can move while they are Instant Transforming. (true OR false) (default: true)");
/*      */     
/* 1247 */     cMoveWhileInstantTransforming = prop.getBoolean();
/* 1248 */     MoveWhileInstantTransforming = cMoveWhileInstantTransforming;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1256 */     prop = config.get("Transformation Configs", "Mystic Kaioken Enabled", true, "Server Sided! True = Players can use Mystic form together with Kaioken. (true OR false) (default: true)");
/*      */     
/* 1258 */     cMysticKaiokenOn = prop.getBoolean();
/* 1259 */     MysticKaiokenOn = cMysticKaiokenOn;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1268 */     prop = config.get("NPC Configs", "Enemies can Teleport out of Ki Wave Locks On", true, "Server Sided! True = DBC Enemies can Teleport out of Continues Ki Wave Locks. (true OR false) (default: true)");
/*      */     
/* 1270 */     EnemyTeleportOutOfLock = prop.getBoolean();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1276 */     prop = config.get("Transformation Configs", "Transformations - God Form", true);
/* 1277 */     prop.comment = "Server Sided! If 'true' then God transformations will be enabled. If 'false' then god transformations will be disabled";
/*      */     
/* 1279 */     cGodform = prop.getBoolean();
/* 1280 */     Godform = cGodform;
/*      */     
/* 1282 */     prop = config.get("Transformation Configs", "Transformations - God Forms Cosmetics", true);
/* 1283 */     prop.comment = "Client Sided! If 'true' then God transformations will have SSG red eyes and SSG flaming aura. If 'false' then god transformations wont have any difference in eye and aura";
/*      */     
/* 1285 */     cGodformCosm = prop.getBoolean();
/* 1286 */     GodformCosm = cGodformCosm;
/*      */     
/* 1288 */     prop = config.get("NPC Configs", "NPC Otherworld Ogre Disable", false);
/* 1289 */     prop.comment = "Server Sided! If 'true' then Ogres in otherworld will get disabled. If 'false' Ogres are enabled. (default: false)";
/* 1290 */     cDsblO = prop.getBoolean();
/* 1291 */     DsblO = cDsblO;
/*      */     
/* 1293 */     prop = config.get("general", "DBGT mode", true);
/* 1294 */     prop.comment = "Server Sided! GT mode refers mainly to transformations for now, like the new saiyan form introduced in DBGT. (default: true)";
/* 1295 */     cDBGT = prop.getBoolean();
/* 1296 */     DBGT = cDBGT;
/*      */     
/* 1298 */     if (side == Side.CLIENT) {
/* 1299 */       mod_DragonBC.cwfb = config.get("Client Sided Configs", "Custom X pos for Ki Bar", 0).getInt(0);
/* 1300 */       mod_DragonBC.chfb = config.get("Client Sided Configs", "Custom Y pos for Ki Bar", 0).getInt(0);
/* 1301 */       mod_DragonBC.cwfn = config.get("Client Sided Configs", "Custom X pos for Ki Number", 0).getInt(0);
/* 1302 */       mod_DragonBC.chfn = config.get("Client Sided Configs", "Custom Y pos for Ki Number", 0).getInt(0);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1310 */     config.save();
/* 1311 */     DBCH.wishInit();
/* 1312 */     DBCH.plntNmsInit();
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */