/*      */ package JinRyuu.JRMCore;
/*      */ 
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.items.ItemBodysuit;
/*      */ import JinRyuu.JRMCore.items.ItemVanity;
/*      */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*      */ import JinRyuu.JRMCore.server.JGRaceHelper;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import com.google.gson.Gson;
/*      */ import com.google.gson.reflect.TypeToken;
/*      */ import com.google.gson.stream.JsonReader;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*      */ import cpw.mods.fml.common.gameevent.TickEvent;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileReader;
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.Random;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import org.apache.logging.log4j.Marker;
/*      */ import org.apache.logging.log4j.MarkerManager;
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
/*      */ public class JRMCoreComTickH
/*      */ {
/*      */   public static final int MAX_GROUP_MEMBER_LIMIT = 600;
/*   56 */   private static final Marker JRMCServer = MarkerManager.getMarker("JRMCServer");
/*      */   
/*      */   public static final String R = "jrmcRace";
/*      */   
/*      */   public static final String P = "jrmcPwrtyp";
/*      */   
/*      */   public static final String Cl = "jrmcClass";
/*      */   
/*      */   public static final String Acc = "jrmcAccept";
/*      */   
/*      */   public static final String St = "jrmcState";
/*      */   
/*      */   public static final String St2 = "jrmcState2";
/*      */   
/*      */   public static final String Diff = "jrmcDiff";
/*      */   public static final String Tm = "jrmcTlmd";
/*      */   public static final String DiffRed = "jrmcDiffRed";
/*      */   public static final String Ptch = "jrmcPtch";
/*   74 */   public static String[] names = null;
/*   75 */   public static String[] data0 = null;
/*   76 */   public static String[] data1 = null;
/*   77 */   public static String[] data2 = null;
/*   78 */   public static String[] data3 = null;
/*   79 */   public static String[] data4 = null;
/*   80 */   public static String[] data5 = null;
/*   81 */   public static String[] data6 = null;
/*   82 */   public static String[] data7 = null;
/*   83 */   public static String[] data8 = null;
/*   84 */   public static String[] data9 = null;
/*   85 */   public static String[] dat10 = null;
/*   86 */   public static String[] dat11 = null;
/*   87 */   public static String[] dat12 = null;
/*   88 */   public static String[] dat13 = null;
/*   89 */   public static String[] dat14 = null;
/*   90 */   public static String[] dat15 = null;
/*   91 */   public static String[] dat16 = null;
/*   92 */   public static String[] dat17 = null;
/*   93 */   public static String[] dat18 = null;
/*   94 */   public static String[] dat19 = null;
/*   95 */   public static String[] dat20 = null;
/*   96 */   public static String[] dat21 = null;
/*   97 */   public static String[] dat22 = null;
/*   98 */   public static String[] dat23 = null;
/*   99 */   public static String[] dat24 = null;
/*  100 */   public static String[] dat25 = null;
/*  101 */   public static String[] dat26 = null;
/*  102 */   public static String[] dat27 = null;
/*  103 */   public static String[] dat28 = null;
/*  104 */   public static String[] dat29 = null;
/*  105 */   public static String[] dat30 = null;
/*  106 */   public static String[] dat31 = null;
/*  107 */   public static String[] dat32 = null;
/*      */ 
/*      */   
/*  110 */   public static String sentNames = null;
/*  111 */   public static String sentData0 = null;
/*  112 */   public static String sentData1 = null;
/*  113 */   public static String sentData2 = null;
/*  114 */   public static String sentData3 = null;
/*  115 */   public static String sentData4 = null;
/*  116 */   public static String sentData5 = null;
/*  117 */   public static String sentData6 = null;
/*  118 */   public static String sentData7 = null;
/*  119 */   public static String sentData8 = null;
/*  120 */   public static String sentData9 = null;
/*  121 */   public static String sentDat10 = null;
/*  122 */   public static String sentDat11 = null;
/*  123 */   public static String sentDat12 = null;
/*  124 */   public static String sentDat13 = null;
/*  125 */   public static String sentDat14 = null;
/*  126 */   public static String sentDat15 = null;
/*  127 */   public static String sentDat16 = null;
/*  128 */   public static String sentDat17 = null;
/*  129 */   public static String sentDat18 = null;
/*  130 */   public static String sentDat19 = null;
/*  131 */   public static String sentDat20 = null;
/*  132 */   public static String sentDat21 = null;
/*  133 */   public static String sentDat22 = null;
/*  134 */   public static String sentDat23 = null;
/*  135 */   public static String sentDat24 = null;
/*  136 */   public static String sentDat25 = null;
/*  137 */   public static String sentDat26 = null;
/*  138 */   public static String sentDat27 = null;
/*  139 */   public static String sentDat28 = null;
/*  140 */   public static String sentDat29 = null;
/*  141 */   public static String sentDat30 = null;
/*  142 */   public static String sentDat31 = null;
/*  143 */   public static String sentDat32 = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  149 */   private String sentDataX = null;
/*      */ 
/*      */ 
/*      */   
/*  153 */   public String[] dataX = null;
/*      */ 
/*      */   
/*      */   public boolean all = false;
/*      */ 
/*      */ 
/*      */   
/*      */   private void newString(String[] s, int c) {
/*  161 */     if (s == null || s.length != c) s = new String[c];
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public String getLabel() {
/*  167 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static byte b(int n) {
/*  173 */     return (byte)n;
/*      */   }
/*      */ 
/*      */   
/*      */   private static NBTTagCompound nbt(EntityPlayer p, String s) {
/*  178 */     return JRMCoreH.nbt((Entity)p, s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void jrmcData(int d, String s) {
/*  186 */     JRMCoreH.jrmcData(d, s);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void jrmcDataToP(int d, String s, EntityPlayer p) {
/*  191 */     JRMCoreH.jrmcDataToP(d, s, p);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean charge = false;
/*  196 */   private static int tick = 0;
/*      */   
/*  198 */   boolean jfc = JRMCoreH.JFC();
/*  199 */   boolean dbc = JRMCoreH.DBC();
/*  200 */   boolean nc = JRMCoreH.NC();
/*  201 */   boolean sao = JRMCoreH.SAOC();
/*  202 */   boolean jyc = JRMCoreH.JYC();
/*      */   
/*      */   private boolean gen = true;
/*      */   private int genInt;
/*      */   public static boolean tna3fu;
/*      */   public static boolean start = true;
/*  208 */   public static int bldngsChecker = 300;
/*      */   public static boolean bldngChkr = true;
/*  210 */   public static String bs = "";
/*      */   
/*  212 */   public static LinkedHashMap<String, Boolean> lf = new LinkedHashMap<String, Boolean>();
/*      */   
/*  214 */   public static int cbl = 24000;
/*  215 */   public static int chsn = -1;
/*      */ 
/*      */   
/*      */   public static boolean op = false;
/*      */   
/*  220 */   private int c = 0;
/*      */   
/*  222 */   public static MinecraftServer server = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void onTick(TickEvent.ServerTickEvent event) {
/*  231 */     if (event.phase.equals(TickEvent.Phase.START))
/*      */     {
/*  233 */       onTickInGame();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void onTickInGame() {
/*  240 */     JRMCoreH.mld();
/*      */ 
/*      */     
/*  243 */     if (!JRMCoreH.paused) {
/*      */       
/*  245 */       server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  246 */       serverTick(server);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void serverTick(MinecraftServer server) {
/*  255 */     int playersCount = (server.func_71213_z()).length;
/*      */     
/*  257 */     countbackForLegendary(playersCount);
/*  258 */     serverStart(server);
/*  259 */     checkBuildingsSpawn(server);
/*      */     
/*  261 */     JRMCoreH.configToClient(server);
/*      */     
/*  263 */     savePlayerData(playersCount);
/*  264 */     nullifyPlayerData(playersCount);
/*  265 */     removeGroupMembers(server);
/*      */     
/*  267 */     this.c++;
/*      */     
/*  269 */     offlineProtector(server, playersCount);
/*      */     
/*  271 */     playersCount = (server.func_71213_z()).length;
/*      */     
/*  273 */     JRMCoreH.clearEmptyFamiliesNBTData(server);
/*      */     
/*  275 */     if (this.jfc) {
/*  276 */       if (JRMCoreConfig.runFamilyCDataUpdateAsThread) {
/*  277 */         if (FamilyCH.familyCDataThread == null) {
/*  278 */           FamilyCH.familyCDataThread = new FamilyCDataThread();
/*  279 */           FamilyCH.familyCDataThread.start();
/*      */         } 
/*  281 */         if (FamilyCH.familyCDataThread != null && !FamilyCH.familyCDataThread.run) {
/*  282 */           FamilyCH.familyCDataThread = null;
/*      */         }
/*      */       } else {
/*      */         
/*  286 */         if (FamilyCH.lastUpdateTick >= JRMCoreConfig.serverPlayerUpdateTick_DataFamilyC * 20 || (FamilyCH.familyCNBT == null && FamilyCH.lastUpdateTick >= 40)) {
/*  287 */           FamilyCH.familyCNBT = FamilyCH.readFamilyInfoFromNBT(server);
/*  288 */           FamilyCH.lastUpdateTick = 0;
/*      */         } 
/*  290 */         FamilyCH.lastUpdateTick++;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  295 */     for (int playerID = 0; playerID < playersCount; playerID++) {
/*      */       
/*  297 */       String usernames = server.func_71213_z()[playerID];
/*      */       
/*  299 */       if (op) {
/*      */         
/*  301 */         Integer os = JRMCoreH.osbic.get(usernames);
/*  302 */         if (os != null && os.intValue() < JRMCoreConfig.osbic * 20) {
/*      */           
/*  304 */           Integer integer1 = os, integer2 = os = Integer.valueOf(os.intValue() + 1); JRMCoreH.osbic.put(usernames, integer1);
/*      */         }
/*  306 */         else if (os == null) {
/*      */           
/*  308 */           JRMCoreH.osbic.put(usernames, Integer.valueOf(1));
/*      */         } 
/*      */       } 
/*      */       
/*  312 */       EntityPlayerMP player = JRMCoreH.getPlayerForUsername(server, usernames);
/*  313 */       JGPlayerMP jgPlayer = new JGPlayerMP(player);
/*  314 */       NBTTagCompound nbt = jgPlayer.connectBaseNBT();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  321 */       if (tick == (int)(100.0F / playersCount * playerID)) {
/*      */         
/*  323 */         byte powerType = nbt.func_74771_c("jrmcPwrtyp");
/*      */         
/*  325 */         if (JRMCoreH.isPowerTypeSAO(powerType)) {
/*      */           
/*  327 */           int sao_lvl = nbt.func_74762_e("saocLvl");
/*  328 */           sao_lvl = (sao_lvl < 1) ? 1 : sao_lvl;
/*      */         } 
/*      */         
/*  331 */         if (this.dbc || this.nc || this.sao) {
/*      */ 
/*      */           
/*  334 */           int[] playerAttributes = jgPlayer.getAttributes();
/*  335 */           String[] playerSkills = jgPlayer.getSkills();
/*  336 */           byte race = jgPlayer.getRace();
/*      */           
/*  338 */           if (!JGConfigRaces.CONFIG_MAJIN_ENABLED && JRMCoreH.isRaceMajin(race) && JRMCoreH.isPowerTypeKi(powerType)) {
/*  339 */             JRMCoreH.resetChar((EntityPlayer)player);
/*      */           }
/*      */           
/*  342 */           if (JRMCoreH.isPowerTypeKi(powerType)) {
/*  343 */             JRMCoreH.updateFormMasteryVersion(nbt);
/*      */           }
/*      */           
/*  346 */           powerType = nbt.func_74771_c("jrmcPwrtyp");
/*  347 */           race = jgPlayer.getRace();
/*      */           
/*  349 */           byte classID = jgPlayer.getClassID();
/*  350 */           byte state = jgPlayer.getState();
/*  351 */           byte state2 = jgPlayer.getState2();
/*      */           
/*  353 */           int curBody = jgPlayer.getHealth();
/*  354 */           int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
/*  355 */           float RRBody = jgPlayer.getHealthRegen(race, classID, powerType);
/*      */           
/*  357 */           int curEnergy = jgPlayer.getEnergy();
/*  358 */           int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(playerSkills, powerType));
/*  359 */           float RREnergy = jgPlayer.getEnergyRegen(race, classID, powerType);
/*      */           
/*  361 */           int curStam = jgPlayer.getStamina();
/*  362 */           int maxStam = jgPlayer.getStaminaMax(race, classID, powerType, playerAttributes);
/*  363 */           float RRStam = jgPlayer.getStaminaRegen(race, classID, powerType);
/*      */           
/*  365 */           int resrv = JRMCoreH.getInt((EntityPlayer)player, "jrmcArcRsrv");
/*  366 */           String absorption = JRMCoreH.getString((EntityPlayer)player, "jrmcMajinAbsorptionData");
/*      */           
/*  368 */           String SkillXNbt = nbt.func_74779_i("jrmcSSltX");
/*  369 */           String statusEffects = jgPlayer.getStatusEffects();
/*  370 */           int foodlvl = player.func_71024_bL().func_75116_a();
/*  371 */           boolean isFoodLevelNotNull = (foodlvl > 0);
/*  372 */           byte alive = nbt.func_74771_c("jrmcAlv");
/*  373 */           byte release = JRMCoreH.getByte((EntityPlayer)player, "jrmcRelease");
/*  374 */           int strainTemporary = nbt.func_74762_e("jrmcStrainTemp");
/*  375 */           int strainActive = nbt.func_74762_e("jrmcStrainActv");
/*  376 */           int strain = nbt.func_74762_e("jrmcStrain");
/*  377 */           int strainGod = nbt.func_74762_e("jrmcGodStrain");
/*  378 */           int strainPain = nbt.func_74762_e("jrmcGyJ7dp");
/*  379 */           int godPowerTimer = nbt.func_74762_e("jrmcGodPwr");
/*  380 */           int heat = nbt.func_74762_e("jrmcEf8slc");
/*  381 */           double heatD = nbt.func_74769_h("jrmcEf8slcD");
/*  382 */           int ko = nbt.func_74762_e("jrmcHar4va");
/*      */           
/*  384 */           if ((JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType)) && JGRaceHelper.isAboveMaxRacialSkill(nbt))
/*      */           {
/*  386 */             JGRaceHelper.setRacialSkillToMax(nbt);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  392 */           boolean kiWeaponID = (JRMCoreH.PlyrSettings((EntityPlayer)player, 13) > -1);
/*  393 */           int kiFistLevel = JRMCoreH.SklLvl(12, playerSkills);
/*  394 */           int kiInfuseLevel = JRMCoreH.SklLvl(15, playerSkills);
/*  395 */           if (kiWeaponID)
/*      */           {
/*  397 */             if (release > 0)
/*      */             
/*  399 */             { if (kiFistLevel <= 0 || kiInfuseLevel <= 0) { JRMCoreH.PlyrSettingsSet((EntityPlayer)player, 13, -1); }
/*  400 */               else { player.field_70170_p.func_72956_a((Entity)player, "jinryuudragonbc:DBC4.kiblade", 0.65F, 1.0F); }
/*      */                }
/*  402 */             else { JRMCoreH.PlyrSettingsSet((EntityPlayer)player, 13, -1); }
/*      */           
/*      */           }
/*      */ 
/*      */           
/*  407 */           if (alive == 1 && player.func_71024_bL().func_75121_c())
/*      */           {
/*  409 */             player.func_71024_bL().func_75122_a(2, 1.0F);
/*      */           }
/*      */           
/*  412 */           if (!JRMCoreConfig.release && release != 50)
/*      */           {
/*  414 */             JRMCoreH.setByte(50, (EntityPlayer)player, "jrmcRelease");
/*      */           }
/*      */           
/*  417 */           if (JRMCoreConfig.release && release == 0) {
/*      */             
/*  419 */             statusEffects = JRMCoreH.StusEfcts(3, statusEffects, nbt, false);
/*  420 */             statusEffects = JRMCoreH.StusEfcts(5, statusEffects, nbt, false);
/*  421 */             statusEffects = JRMCoreH.StusEfcts(16, statusEffects, nbt, false);
/*  422 */             statusEffects = JRMCoreH.StusEfcts(15, statusEffects, nbt, false);
/*      */           } 
/*      */           
/*  425 */           if (JRMCoreH.rc_sai(race) && player.field_71093_bK == 0 && player.field_70170_p.func_130001_d() == 1.0F && player.field_70170_p.func_72820_D() % 24000L > 12000L) {
/*      */             
/*  427 */             statusEffects = JRMCoreH.StusEfcts(8, statusEffects, nbt, true);
/*      */           }
/*      */           else {
/*      */             
/*  431 */             statusEffects = JRMCoreH.StusEfcts(8, statusEffects, nbt, false);
/*      */           } 
/*      */           
/*  434 */           if (chsn > -1 && chsn == playerID) {
/*      */             
/*  436 */             mod_JRMCore.logger.info(usernames + " received the Legendary status effect!");
/*  437 */             if (playersCount > JRMCoreConfig.selgndc2) {
/*      */               
/*  439 */               mod_JRMCore.logger.info("Legendary config effect - Lucky player: " + JRMCoreConfig.selgndc + " with " + playersCount + " being online");
/*      */             }
/*      */             else {
/*      */               
/*  443 */               mod_JRMCore.logger.info("Legendary config effect - Chance being: " + JRMCoreConfig.selgndc + "%");
/*      */             } 
/*  445 */             statusEffects = JRMCoreH.StusEfcts(14, statusEffects, nbt, true);
/*  446 */             chsn = -1;
/*      */           } 
/*      */           
/*  449 */           boolean isLegendaryOn = JRMCoreH.StusEfcts(14, statusEffects);
/*  450 */           boolean cont = lf.containsKey(usernames);
/*      */           
/*  452 */           if (isLegendaryOn && !cont) {
/*      */             
/*  454 */             lf.put(usernames, Boolean.valueOf(true));
/*      */           }
/*  456 */           else if (!isLegendaryOn && cont) {
/*      */             
/*  458 */             lf.remove(usernames);
/*      */           } 
/*      */           
/*  461 */           if (lf.size() > JRMCoreConfig.selgnd && lf.keySet().toArray()[lf.size() - 1].equals(usernames))
/*      */           {
/*  463 */             statusEffects = JRMCoreH.StusEfcts(14, statusEffects, nbt, false);
/*      */           }
/*      */ 
/*      */           
/*  467 */           if (powerType == 2) {
/*      */             
/*  469 */             if (state > 0 && JRMCoreH.StusEfcts(16, statusEffects)) {
/*  470 */               int WILL = JRMCoreH.stat((Entity)player, 3, powerType, 4, playerAttributes[3], race, classID, 0.0F);
/*  471 */               double tr = (0.25F * WILL * release * 0.01F);
/*  472 */               int curen = (int)((curEnergy - tr < 1.0D) ? 0.0D : (curEnergy - tr));
/*  473 */               if (!JRMCoreH.isInCreativeMode((Entity)player)) JRMCoreH.setInt(curEnergy = curen, (EntityPlayer)player, "jrmcEnrgy"); 
/*  474 */               if (curen <= tr) {
/*      */                 
/*  476 */                 statusEffects = JRMCoreH.StusEfcts(16, statusEffects, nbt, false);
/*  477 */                 JRMCoreH.setByte(0, (EntityPlayer)player, "jrmcRelease");
/*  478 */                 nbt.func_74774_a("jrmcState", (byte)0); state = 0;
/*      */               } 
/*      */             } 
/*  481 */             if (state == 0)
/*      */             {
/*  483 */               statusEffects = JRMCoreH.StusEfcts(16, statusEffects, nbt, false);
/*      */             }
/*      */           } 
/*      */ 
/*      */           
/*  488 */           int lastAttackedTimer = JRMCoreH.getInt((EntityPlayer)player, "jrmcAttackTimer");
/*  489 */           int epoch = (int)(System.currentTimeMillis() / 1000L);
/*      */           
/*  491 */           if (powerType == 3) {
/*      */             
/*  493 */             if (JRMCoreConfig.hregen && isFoodLevelNotNull && curBody < maxBody && epoch > lastAttackedTimer) {
/*      */               
/*  495 */               double add = maxBody * 0.05D * JRMCoreConfig.hRgnRt * 0.5D;
/*  496 */               if (add >= 0.0D)
/*      */               {
/*  498 */                 int all = (int)(curBody + add);
/*  499 */                 JRMCoreH.setInt((all > maxBody) ? maxBody : all, (EntityPlayer)player, "jrmcBdy");
/*      */               }
/*      */             
/*  502 */             } else if (!isFoodLevelNotNull) {
/*      */               
/*  504 */               int all = (int)(curBody - maxBody * 0.05D);
/*  505 */               JRMCoreH.setInt((all <= 0) ? 0 : all, (EntityPlayer)player, "jrmcBdy");
/*      */             }
/*      */           
/*      */           } else {
/*      */             
/*  510 */             int baseState = JRMCoreH.isRaceArcosian(race) ? 4 : 0;
/*  511 */             boolean isInBaseState = (state == baseState);
/*  512 */             int godSkillLevel = JRMCoreH.SklLvl(9, (EntityPlayer)player);
/*  513 */             boolean hasGodForm = (godSkillLevel > (JRMCoreH.isRaceSaiyan(race) ? 1 : 0));
/*      */             
/*  515 */             boolean statusEffectTurboSwoop = (JRMCoreH.StusEfcts(3, statusEffects) || JRMCoreH.StusEfcts(7, statusEffects));
/*  516 */             boolean isAuraNotOn = !statusEffects.contains(JRMCoreH.StusEfcts[4]);
/*  517 */             boolean isKaiokenOn = JRMCoreH.StusEfcts(5, statusEffects);
/*  518 */             boolean isUltraInstinctOn = JRMCoreH.StusEfcts(19, statusEffects);
/*      */             
/*  520 */             boolean isMedicationActive = (JRMCoreConfig.SklMedCat == 0);
/*      */             
/*  522 */             boolean isMajinOn = JRMCoreH.StusEfcts(12, statusEffects);
/*  523 */             int alignment = nbt.func_74771_c("jrmcAlign");
/*      */             
/*  525 */             boolean isMysticOn = JRMCoreH.StusEfcts(13, statusEffects);
/*  526 */             int mysticLevel = (powerType == 1) ? JRMCoreH.SklLvl(10, powerType, playerSkills) : 0;
/*  527 */             int mysticTimer = nbt.func_74762_e("jrmcUltmtTm");
/*  528 */             int majinAbsorptionTimer = nbt.func_74762_e("jrmcMajinAbsorptionTimer");
/*      */             
/*  530 */             boolean isGoDOn = JRMCoreH.StusEfcts(20, statusEffects);
/*  531 */             int GoDLevel = (powerType == 1) ? JRMCoreH.SklLvl(18, powerType, playerSkills) : 0;
/*      */             
/*  533 */             boolean isInZeroRelease = (release <= 0);
/*      */             
/*  535 */             if (JRMCoreH.isPowerTypeKi(powerType)) {
/*  536 */               boolean isPSettingOn_Mystic = JRMCoreH.PlyrSettingsB(nbt, 6);
/*  537 */               boolean isPSettingOn_UI = JRMCoreH.PlyrSettingsB(nbt, 11);
/*  538 */               boolean isPSettingOn_GoD = JRMCoreH.PlyrSettingsB(nbt, 16);
/*  539 */               boolean isPSettingOn_Kaioken = JRMCoreH.PlyrSettingsB(nbt, 0);
/*      */               
/*  541 */               byte enabled = 0;
/*      */               
/*  543 */               if (isPSettingOn_Mystic) enabled = (byte)(enabled + 1); 
/*  544 */               if (isPSettingOn_UI) enabled = (byte)(enabled + 1); 
/*  545 */               if (isPSettingOn_GoD) enabled = (byte)(enabled + 1); 
/*  546 */               if (isPSettingOn_Kaioken) enabled = (byte)(enabled + 1);
/*      */               
/*  548 */               if (enabled > 1) {
/*  549 */                 if (isPSettingOn_Mystic) JRMCoreH.PlyrSettingsRem(nbt, 6); 
/*  550 */                 if (isPSettingOn_UI) JRMCoreH.PlyrSettingsRem(nbt, 11); 
/*  551 */                 if (isPSettingOn_GoD) JRMCoreH.PlyrSettingsRem(nbt, 16); 
/*  552 */                 if (isPSettingOn_Kaioken) JRMCoreH.PlyrSettingsRem(nbt, 0);
/*      */               
/*      */               } 
/*      */               
/*  556 */               if (isPSettingOn_UI && JRMCoreH.SklLvl(16, powerType, playerSkills) == 0) JRMCoreH.PlyrSettingsRem(nbt, 11); 
/*  557 */               if (isPSettingOn_GoD && JRMCoreH.SklLvl(18, powerType, playerSkills) == 0) JRMCoreH.PlyrSettingsRem(nbt, 16);
/*      */             
/*      */             } 
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
/*  570 */             if (JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(powerType)) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  576 */               String masteryData = JRMCoreH.getFormMasteryData((EntityPlayer)player);
/*      */ 
/*      */               
/*  579 */               if (isKaiokenOn && !JRMCoreH.hasRequiredFormMasteries((EntityPlayer)player, masteryData, race, "Kaioken", false)) {
/*      */                 
/*  581 */                 JRMCoreH.setByte(state2 = 0, (EntityPlayer)player, "jrmcState2");
/*  582 */                 statusEffects = JRMCoreH.StusEfcts(5, statusEffects, nbt, isKaiokenOn = false);
/*      */               } 
/*      */ 
/*      */               
/*  586 */               if (isMysticOn && !JRMCoreH.hasRequiredFormMasteries((EntityPlayer)player, masteryData, race, "Mystic", false))
/*      */               {
/*      */                 
/*  589 */                 statusEffects = JRMCoreH.StusEfcts(13, statusEffects, nbt, isMysticOn = false);
/*      */               }
/*      */ 
/*      */               
/*  593 */               if (isUltraInstinctOn && !JRMCoreH.hasRequiredFormMasteries((EntityPlayer)player, masteryData, race, "UltraInstict", false)) {
/*      */                 
/*  595 */                 JRMCoreH.setByte(state2 = 0, (EntityPlayer)player, "jrmcState2");
/*  596 */                 statusEffects = JRMCoreH.StusEfcts(19, statusEffects, nbt, isUltraInstinctOn = false);
/*      */               } 
/*      */ 
/*      */               
/*  600 */               if (isGoDOn && !JRMCoreH.hasRequiredFormMasteries((EntityPlayer)player, masteryData, race, "GodOfDestruction", false))
/*      */               {
/*      */                 
/*  603 */                 statusEffects = JRMCoreH.StusEfcts(20, statusEffects, nbt, isGoDOn = false);
/*      */               }
/*      */ 
/*      */               
/*  607 */               if (state > 0 && !JRMCoreH.hasRequiredFormMasteries2((EntityPlayer)player, masteryData, race, state, state2, false, false, false, false)) {
/*      */                 
/*  609 */                 boolean canUse = false;
/*  610 */                 byte failSafe = 100;
/*  611 */                 while (!canUse && failSafe > 0) {
/*  612 */                   boolean hasFullPowerSSJ = false;
/*  613 */                   if (JRMCoreH.isRaceSaiyan(race)) {
/*  614 */                     hasFullPowerSSJ = JRMCoreH.isSaiyanSuperFullPower(nbt);
/*      */                   }
/*  616 */                   byte OGstate = JRMCoreH.transformationDescendToFormID[race][state];
/*  617 */                   state = JRMCoreH.getTransformationDescendToFormID(race, state, hasFullPowerSSJ);
/*  618 */                   JRMCoreH.setByte(state, (EntityPlayer)player, "jrmcState");
/*  619 */                   canUse = (state == 0 || JRMCoreH.hasRequiredFormMasteries2((EntityPlayer)player, masteryData, race, state, state2, false, false, false, false));
/*      */                   
/*  621 */                   failSafe = (byte)(failSafe - 1);
/*      */                 } 
/*      */               } 
/*      */               
/*  625 */               if (!isInZeroRelease) {
/*  626 */                 JRMCoreH.addToFormMasteriesValue((EntityPlayer)player, JGConfigDBCFormMastery.FM_GainPassive, JGConfigDBCFormMastery.FM_GainPassive, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn, 0);
/*      */               }
/*      */ 
/*      */ 
/*      */               
/*  631 */               JRMCoreH.autoLearnFormMastery((EntityPlayer)player, race);
/*      */             } 
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
/*  649 */             if (JRMCoreConfig.hregen && isFoodLevelNotNull && curBody < maxBody && ((state == 0 && race != 4) || (state <= 4 && race == 4)) && state2 == 0 && epoch > lastAttackedTimer && heat <= 0) {
/*      */               
/*  651 */               double add = JRMCoreH.regenRate(powerType, maxBody, RRBody) * (JRMCoreConfig.hRgnRt * 0.5F);
/*  652 */               if (JRMCoreH.isRaceArcosian(race))
/*      */               {
/*  654 */                 add = JRMCoreH.getKiRegenArcosian(playerAttributes, add, state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
/*      */               }
/*  656 */               add *= (release < 5) ? 1.0D : ((release < 10) ? 0.5D : ((release < 15) ? 0.25D : 0.0D));
/*  657 */               if (add >= 0.0D)
/*      */               {
/*  659 */                 add = (add < 1.0D) ? 1.0D : add;
/*  660 */                 if (!isMedicationActive && (JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType))) {
/*      */                   
/*  662 */                   int ta = JRMCoreH.SklLvl((powerType == 1) ? 7 : 11, powerType, playerSkills);
/*  663 */                   if (ta > 0)
/*      */                   {
/*  665 */                     add += (JRMCoreConfig.SklMedRate * ta * 0.1F) * add;
/*      */                   }
/*      */                 } 
/*  668 */                 int all = (int)(curBody + add);
/*  669 */                 JRMCoreH.setInt((all > maxBody) ? maxBody : all, (EntityPlayer)player, "jrmcBdy");
/*      */               }
/*      */             
/*  672 */             } else if (!isFoodLevelNotNull) {
/*      */               
/*  674 */               int all = (int)(curBody - maxBody * 0.05D);
/*  675 */               JRMCoreH.setInt((all <= 0) ? 0 : all, (EntityPlayer)player, "jrmcBdy");
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*  680 */             if (JGConfigRaces.CONFIG_MAJIN_ENABLED && JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_ENABLED && JRMCoreH.isPowerTypeKi(powerType) && JRMCoreH.isRaceMajin(race)) {
/*  681 */               if (!JRMCoreH.isInCreativeMode((Entity)player) && isFoodLevelNotNull && curBody < maxBody && !isAuraNotOn) {
/*  682 */                 byte racialLevel = JGRaceHelper.getRacialSkillLevel(nbt);
/*  683 */                 if (racialLevel > 0) {
/*  684 */                   int stateID = JRMCoreH.getMajinFormID(state, isMysticOn, isUltraInstinctOn, isGoDOn);
/*  685 */                   float[] healthGain = JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[stateID];
/*  686 */                   float[] kiCost = JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[stateID];
/*  687 */                   float[] staminaCost = JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[stateID];
/*      */                   
/*  689 */                   float healthGainFull = maxBody * healthGain[1] + healthGain[0];
/*  690 */                   float kiCostFull = maxEnergy * kiCost[1] + kiCost[0];
/*  691 */                   float staminaCostFull = maxStam * staminaCost[1] + staminaCost[0];
/*      */                   
/*  693 */                   int lvl = racialLevel - 1;
/*  694 */                   healthGainFull *= JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[lvl];
/*  695 */                   kiCostFull *= JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[lvl];
/*  696 */                   staminaCostFull *= JGConfigRaces.CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[lvl];
/*      */                   
/*  698 */                   if (curEnergy >= (int)kiCostFull && curStam >= (int)staminaCostFull) {
/*  699 */                     curEnergy -= (int)kiCostFull;
/*  700 */                     if (curEnergy > maxEnergy) { curEnergy = maxEnergy; } else if (curEnergy < 0) { curEnergy = 0; }
/*  701 */                      JRMCoreH.setInt(curEnergy, (EntityPlayer)player, "jrmcEnrgy");
/*      */                     
/*  703 */                     curStam -= (int)staminaCostFull;
/*  704 */                     if (curStam > maxStam) { curStam = maxStam; } else if (curStam < 0) { curStam = 0; }
/*  705 */                      JRMCoreH.setInt(curStam, (EntityPlayer)player, "jrmcStamina");
/*      */                     
/*  707 */                     curBody += (int)healthGainFull;
/*  708 */                     if (curBody > maxBody) { curBody = maxBody; } else if (curBody < 0) { curBody = 0; }
/*  709 */                      JRMCoreH.setInt(curBody, (EntityPlayer)player, "jrmcBdy");
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */               
/*  714 */               if (majinAbsorptionTimer > 0)
/*      */               {
/*  716 */                 nbt.func_74768_a("jrmcMajinAbsorptionTimer", --majinAbsorptionTimer);
/*      */               }
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  723 */             if (JRMCoreConfig.regen && isFoodLevelNotNull && curEnergy < maxEnergy && ((state == 0 && race != 4) || (state <= 4 && race == 4)) && state2 == 0 && epoch > lastAttackedTimer) {
/*      */               
/*  725 */               double add = JRMCoreH.regenRate(powerType, maxEnergy, RREnergy) * (JRMCoreConfig.rgnRt * 0.75F);
/*  726 */               if (JRMCoreH.isRaceArcosian(race))
/*      */               {
/*  728 */                 add = JRMCoreH.getKiRegenArcosian(playerAttributes, add, state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
/*      */               }
/*  730 */               add = add * (50 - release) * 0.019999999552965164D;
/*      */ 
/*      */               
/*  733 */               if (add >= 0.0D) {
/*      */                 
/*  735 */                 add = (add < 1.0D) ? 1.0D : add;
/*  736 */                 if (!isMedicationActive && (JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType))) {
/*      */                   
/*  738 */                   int meditationSkillLvl = JRMCoreH.SklLvl((powerType == 1) ? 7 : 11, powerType, playerSkills);
/*  739 */                   if (meditationSkillLvl > 0)
/*      */                   {
/*  741 */                     add += (JRMCoreConfig.SklMedRate * meditationSkillLvl * 0.1F) * add;
/*      */                   }
/*      */                 } 
/*      */                 
/*  745 */                 if (!statusEffectTurboSwoop || add <= 0.0D) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  751 */                   int all = (int)(curEnergy + add);
/*  752 */                   JRMCoreH.setInt((all > maxEnergy) ? maxEnergy : all, (EntityPlayer)player, "jrmcEnrgy");
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */ 
/*      */             
/*  758 */             if (isFoodLevelNotNull && curStam < maxStam && (!isMedicationActive || isAuraNotOn) && !JRMCoreH.StusEfcts(7, statusEffects)) {
/*      */               
/*  760 */               double add = JRMCoreH.regenRate(powerType, maxStam, RRStam) * 16.0D;
/*  761 */               int all = (int)(curStam + add);
/*  762 */               JRMCoreH.setInt((all > maxStam) ? maxStam : all, (EntityPlayer)player, "jrmcStamina");
/*      */             } 
/*      */ 
/*      */             
/*  766 */             if (((state > 0 && race != 4) || (race == 4 && state > 4)) && curEnergy >= 0) {
/*      */               
/*  768 */               double tr = ((powerType == 2) ? -0.1F : 1.0F);
/*      */               
/*  770 */               if (!JRMCoreH.isInCreativeMode((Entity)player))
/*      */               {
/*  772 */                 if (JRMCoreH.isRaceFullSaiyan(race)) {
/*      */                   
/*  774 */                   tr = JRMCoreH.getKiRegenSaiyan(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
/*      */                 }
/*  776 */                 else if (JRMCoreH.isRaceHalfSaiyan(race)) {
/*      */                   
/*  778 */                   tr = JRMCoreH.getKiRegenHalfSaiyan(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
/*      */                 }
/*  780 */                 else if (JRMCoreH.isRaceArcosian(race)) {
/*      */                   
/*  782 */                   tr = JRMCoreH.getKiRegenArcosian(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
/*      */                 }
/*  784 */                 else if (JRMCoreH.isPowerTypeKi(powerType) && JRMCoreH.isRaceNamekian(race)) {
/*      */                   
/*  786 */                   tr = JRMCoreH.getKiRegenNamekian(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
/*      */                 }
/*  788 */                 else if (JRMCoreH.isRaceMajin(race)) {
/*      */                   
/*  790 */                   tr = JRMCoreH.getKiRegenMajin(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
/*      */                 }
/*  792 */                 else if (JRMCoreH.isPowerTypeKi(powerType) && !JRMCoreH.isRaceArcosian(race)) {
/*      */                   
/*  794 */                   tr = JRMCoreH.getKiRegenHuman(playerAttributes, JRMCoreH.regenRate(powerType, maxEnergy, RREnergy), state, SkillXNbt, release, resrv, isUltraInstinctOn, isGoDOn);
/*      */                 } 
/*      */               }
/*      */               
/*  798 */               int r2 = (release < 5) ? 5 : release;
/*  799 */               tr *= ((powerType == 1) ? (r2 * 0.01F) : 1.0F);
/*      */               
/*  801 */               if (JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(powerType) && tr != 0.0D) {
/*      */                 
/*  803 */                 int formID = JRMCoreH.getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/*      */                 
/*  805 */                 double masteryLevel = JRMCoreH.getFormMasteryValue((EntityPlayer)player, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/*      */                 
/*  807 */                 float costMulti = (float)JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_COST_MULTI);
/*      */ 
/*      */                 
/*  810 */                 tr *= costMulti;
/*      */               } 
/*      */               
/*  813 */               int curen = (int)((curEnergy + tr < 0.0D) ? 0.0D : (curEnergy + tr));
/*  814 */               JRMCoreH.setInt((curen > maxEnergy) ? maxEnergy : curen, (EntityPlayer)player, "jrmcEnrgy");
/*  815 */               if (curen < 1) {
/*  816 */                 JRMCoreH.setByte(0, (EntityPlayer)player, "jrmcRelease");
/*  817 */                 nbt.func_74774_a("jrmcState", (byte)((race == 4) ? 4 : 0));
/*  818 */                 nbt.func_74774_a("jrmcState2", (byte)0);
/*  819 */                 JRMCoreH.setInt((int)(curBody + curEnergy + tr), (EntityPlayer)player, "jrmcBdy");
/*      */               } 
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*  825 */             if (JRMCoreH.isPowerTypeKi(powerType) && JGConfigDBCGoD.CONFIG_GOD_ENABLED && isGoDOn) {
/*      */ 
/*      */               
/*  828 */               if (alignment > JGConfigDBCGoD.CONFIG_GOD_MAX_ALIGNMENT && 
/*  829 */                 isGoDOn) statusEffects = JRMCoreH.StusEfcts(20, statusEffects, nbt, isGoDOn = false);
/*      */ 
/*      */               
/*  832 */               if (JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED && !JRMCoreH.isInCreativeMode((Entity)player)) {
/*  833 */                 boolean hasTurbo = JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA ? jgPlayer.hasStatusEffect(3, statusEffects) : true;
/*  834 */                 if (hasTurbo) {
/*  835 */                   float cost = JGConfigDBCGoD.CONFIG_GOD_AURA_KI_COST[1] * maxEnergy;
/*  836 */                   cost += JGConfigDBCGoD.CONFIG_GOD_AURA_KI_COST[0];
/*      */                   
/*  838 */                   if (JGConfigDBCFormMastery.FM_Enabled && cost != 0.0F) {
/*  839 */                     int formID = JRMCoreH.getFormID("GodOfDestruction", race);
/*  840 */                     double masteryLevel = JRMCoreH.getFormMasteryValue((EntityPlayer)player, formID);
/*      */ 
/*      */                     
/*  843 */                     float costMulti = (float)JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_GOD_AURA_COST_MULTI);
/*      */ 
/*      */                     
/*  846 */                     cost *= costMulti;
/*      */                   } 
/*      */                   
/*  849 */                   if (curEnergy > (int)cost) {
/*  850 */                     curEnergy -= (int)cost;
/*      */                   } else {
/*      */                     
/*  853 */                     if (JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA)
/*      */                     
/*  855 */                     { statusEffects = JRMCoreH.StusEfcts(3, statusEffects, nbt, false);
/*      */                       
/*      */                        }
/*      */                     
/*  859 */                     else if (isGoDOn) { statusEffects = JRMCoreH.StusEfcts(20, statusEffects, nbt, isGoDOn = false); }
/*      */                     
/*  861 */                     curEnergy = 0;
/*      */                   } 
/*  863 */                   JRMCoreH.setInt(curEnergy, (EntityPlayer)player, "jrmcEnrgy");
/*      */                 }
/*      */               
/*      */               } 
/*  867 */             } else if (!JGConfigDBCGoD.CONFIG_GOD_ENABLED && isGoDOn) {
/*  868 */               statusEffects = JRMCoreH.StusEfcts(20, statusEffects, nbt, isGoDOn = false);
/*      */             } 
/*      */ 
/*      */             
/*  872 */             if (JRMCoreH.isPowerTypeKi(powerType) && state2 > 0)
/*      */             
/*      */             { 
/*  875 */               if (isKaiokenOn) {
/*      */                 
/*  877 */                 if (!JRMCoreH.isInCreativeMode((Entity)player))
/*      */                 {
/*  879 */                   double kkCost = JRMCoreH.KaiKCost((EntityPlayer)player) * maxBody;
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  884 */                   int curHealth = (int)((curBody - kkCost < 1.0D) ? 1.0D : (curBody - kkCost));
/*  885 */                   JRMCoreH.setInt(curHealth, (EntityPlayer)player, "jrmcBdy");
/*      */                   
/*  887 */                   if (curHealth <= maxBody * 0.1F)
/*      */                   {
/*  889 */                     JRMCoreH.setByte(0, (EntityPlayer)player, "jrmcRelease");
/*  890 */                     nbt.func_74774_a("jrmcState", (byte)(JRMCoreH.rc_arc(race) ? 4 : 0));
/*  891 */                     nbt.func_74774_a("jrmcState2", (byte)0); state2 = 0;
/*  892 */                     JRMCoreH.setInt(curHealth, (EntityPlayer)player, "jrmcBdy");
/*      */                   }
/*      */                 
/*      */                 }
/*      */               
/*  897 */               } else if (isUltraInstinctOn) {
/*      */                 
/*  899 */                 int max1 = JGConfigUltraInstinct.CONFIG_UI_LEVELS;
/*  900 */                 int max2 = JRMCoreH.SklLvl(16, (EntityPlayer)player);
/*      */                 
/*  902 */                 if (max1 == 0 || max2 == 0) {
/*      */                   
/*  904 */                   JRMCoreH.setByte(state2 = 0, (EntityPlayer)player, "jrmcState2");
/*  905 */                   if (isUltraInstinctOn) statusEffects = JRMCoreH.StusEfcts(19, statusEffects, nbt, isUltraInstinctOn = false);
/*      */                 
/*  907 */                 } else if (state2 > max1) {
/*      */                   
/*  909 */                   JRMCoreH.setByte(max1, (EntityPlayer)player, "jrmcState2");
/*      */                 }
/*  911 */                 else if (state2 > max2) {
/*      */                   
/*  913 */                   JRMCoreH.setByte(max2, (EntityPlayer)player, "jrmcState2");
/*      */                 }
/*      */               
/*      */               }
/*      */                }
/*      */             
/*  919 */             else if (isKaiokenOn) { statusEffects = JRMCoreH.StusEfcts(5, statusEffects, nbt, false); }
/*  920 */             else if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0 && isUltraInstinctOn) { statusEffects = JRMCoreH.StusEfcts(19, statusEffects, nbt, false); }
/*      */ 
/*      */ 
/*      */             
/*  924 */             JRMCoreH.KaiKStrainAct((EntityPlayer)player, nbt, state2, strain, strainTemporary, strainActive);
/*      */             
/*  926 */             if (strainGod > 0)
/*      */             {
/*  928 */               nbt.func_74768_a("jrmcGodStrain", --strainGod);
/*      */             }
/*      */             
/*  931 */             if (strainPain > 0) {
/*      */               
/*  933 */               nbt.func_74768_a("jrmcGyJ7dp", --strainPain);
/*  934 */               if (!JRMCoreH.isInCreativeMode((Entity)player)) {
/*      */                 
/*  936 */                 curBody -= (int)(maxBody * 1.0E-4F);
/*  937 */                 if (curBody < 0) curBody = 0; 
/*  938 */                 JRMCoreH.setInt(curBody, (EntityPlayer)player, "jrmcBdy");
/*      */               } 
/*      */             } 
/*      */             
/*  942 */             if (godPowerTimer > 0) {
/*      */ 
/*      */ 
/*      */               
/*  946 */               nbt.func_74768_a("jrmcGodPwr", --godPowerTimer);
/*      */             }
/*  948 */             else if (state == 11) {
/*      */               
/*  950 */               nbt.func_74774_a("jrmcState", (byte)0);
/*      */             } 
/*      */             
/*  953 */             if (JRMCoreH.isPowerTypeKi(powerType))
/*      */             {
/*  955 */               if (nbt.func_74764_b("jrmcInstantTransmissionTimers")) {
/*  956 */                 String instantTransmissionTimers = nbt.func_74779_i("jrmcInstantTransmissionTimers");
/*  957 */                 String[] values = instantTransmissionTimers.split(";");
/*  958 */                 int tpShort = Integer.parseInt(values[0]); if (tpShort > 0) tpShort--; 
/*  959 */                 int tpLong = Integer.parseInt(values[1]); if (tpLong > 0) tpLong--; 
/*  960 */                 JRMCoreH.setString(tpShort + ";" + tpLong, (EntityPlayer)player, "jrmcInstantTransmissionTimers");
/*      */               } else {
/*      */                 
/*  963 */                 String instantTransmissionTimers = "0;0";
/*  964 */                 JRMCoreH.setString(instantTransmissionTimers, (EntityPlayer)player, "jrmcInstantTransmissionTimers");
/*      */               } 
/*      */             }
/*      */             
/*  968 */             if (JRMCoreH.isPowerTypeKi(powerType) && JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */               
/*  970 */               if (isUltraInstinctOn) {
/*      */                 
/*  972 */                 double reqMulti = 1.0D;
/*  973 */                 double masteryLevel = 0.0D;
/*  974 */                 int formID = 0;
/*      */                 
/*  976 */                 if (JGConfigDBCFormMastery.FM_Enabled) {
/*  977 */                   formID = JRMCoreH.getFormID("UltraInstict", race);
/*  978 */                   masteryLevel = JRMCoreH.getFormMasteryValue((EntityPlayer)player, formID);
/*      */                   
/*  980 */                   reqMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_UI_HEALTH_REQ_MULTI);
/*      */                 } 
/*      */                 
/*  983 */                 if (JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[JRMCoreH.state2UltraInstinct(isKaiokenOn, state2)] > 0) {
/*  984 */                   double heatGain = 1.0D;
/*  985 */                   if (JGConfigDBCFormMastery.FM_Enabled) {
/*      */ 
/*      */ 
/*      */                     
/*  989 */                     double costMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_UI_HEAT_MULTI);
/*      */                     
/*  991 */                     heatGain *= costMulti;
/*      */                   } 
/*  993 */                   heatD += heatGain;
/*  994 */                   heat += (int)heatD;
/*  995 */                   heatD -= (int)heatD;
/*  996 */                   nbt.func_74780_a("jrmcEf8slcD", heatD);
/*  997 */                   nbt.func_74768_a("jrmcEf8slc", heat);
/*      */                 } 
/*      */                 
/* 1000 */                 byte[] healthPercentage = JGConfigUltraInstinct.CONFIG_UI_HEALTH_PERCENTAGE;
/* 1001 */                 double healthRequirement = healthPercentage[JRMCoreH.state2UltraInstinct(isKaiokenOn, state2)] * reqMulti;
/*      */                 
/* 1003 */                 if ((maxBody > 0 && (curBody / maxBody / 100) > healthRequirement) || release <= 0)
/*      */                 {
/* 1005 */                   if (isUltraInstinctOn) statusEffects = JRMCoreH.StusEfcts(19, statusEffects, nbt, isUltraInstinctOn = false); 
/* 1006 */                   nbt.func_74774_a("jrmcState2", (byte)0);
/* 1007 */                   state2 = nbt.func_74771_c("jrmcState2");
/*      */                 }
/*      */               
/* 1010 */               } else if (heat > 0) {
/*      */                 
/* 1012 */                 if (heatD != 0.0D) {
/* 1013 */                   nbt.func_74780_a("jrmcEf8slcD", 0.0D);
/* 1014 */                   heatD = 0.0D;
/*      */                 } else {
/*      */                   
/* 1017 */                   nbt.func_74768_a("jrmcEf8slc", --heat);
/*      */                 } 
/*      */               } 
/*      */               
/* 1021 */               byte EXPERIENCE_PAIN_MODE = JGConfigUltraInstinct.CONFIG_UI_EXPERIENCE_PAIN_MODE;
/* 1022 */               byte WAS_IN_PAIN = nbt.func_74771_c("jrmcUIWasInPain");
/* 1023 */               if (EXPERIENCE_PAIN_MODE == 2 && WAS_IN_PAIN > 0) {
/*      */                 
/* 1025 */                 int duration = nbt.func_74762_e("jrmcUIWasInPainDuration");
/* 1026 */                 nbt.func_74768_a("jrmcUIWasInPainDuration", ++duration);
/*      */                 
/* 1028 */                 if (duration > JGConfigUltraInstinct.CONFIG_UI_EXPERIENCE_PAIN_RESET_DURATION)
/*      */                 {
/* 1030 */                   nbt.func_74768_a("jrmcUIWasInPainDuration", 0);
/* 1031 */                   nbt.func_74774_a("jrmcUIWasInPain", (byte)0);
/*      */                 }
/*      */               
/*      */               } else {
/*      */                 
/* 1036 */                 nbt.func_74768_a("jrmcUIWasInPainDuration", 0);
/*      */               } 
/*      */ 
/*      */ 
/*      */               
/* 1041 */               int state2UI = JRMCoreH.state2UltraInstinct(isKaiokenOn, state2);
/*      */               
/* 1043 */               if (JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[state2UI] > 0 && heat >= JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[state2UI]) {
/*      */                 
/* 1045 */                 nbt.func_74768_a("jrmcEf8slc", 0);
/* 1046 */                 nbt.func_74780_a("jrmcEf8slcD", 0.0D);
/* 1047 */                 nbt.func_74768_a("jrmcUIWasInPainDuration", 0);
/*      */                 
/* 1049 */                 byte UI_HighestStateReached = nbt.func_74771_c("jrmcUIStateReach");
/* 1050 */                 if (UI_HighestStateReached >= JGConfigUltraInstinct.CONFIG_UI_PAIN_DURATION.length) UI_HighestStateReached = (byte)(JGConfigUltraInstinct.CONFIG_UI_PAIN_DURATION.length - 1);
/*      */ 
/*      */                 
/* 1053 */                 int pain = JGConfigUltraInstinct.CONFIG_UI_PAIN_DURATION[UI_HighestStateReached] * 60 / 5;
/*      */                 
/* 1055 */                 if (JGConfigDBCFormMastery.FM_Enabled && pain != 0) {
/* 1056 */                   int formID = JRMCoreH.getFormID("UltraInstict", race);
/* 1057 */                   double masteryLevel = JRMCoreH.getFormMasteryValue((EntityPlayer)player, formID);
/*      */                   
/* 1059 */                   double costMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_UI_PAIN_MULTI);
/*      */                   
/* 1061 */                   pain = (int)(pain * costMulti);
/*      */                 } 
/*      */                 
/* 1064 */                 nbt.func_74768_a("jrmcGyJ7dp", pain);
/*      */                 
/* 1066 */                 nbt.func_74774_a("jrmcUIWasInPain", (byte)1);
/* 1067 */                 JRMCoreH.setByte(state2 = 0, (EntityPlayer)player, "jrmcState2");
/* 1068 */                 if (isUltraInstinctOn) statusEffects = JRMCoreH.StusEfcts(19, statusEffects, nbt, isUltraInstinctOn = false);
/*      */               
/*      */               } 
/*      */             } 
/*      */ 
/*      */             
/* 1074 */             if (ko > 0) {
/*      */               
/* 1076 */               nbt.func_74768_a("jrmcHar4va", --ko);
/* 1077 */               JRMCoreH.setByte(state = (race == 4) ? ((state < 4) ? state : 4) : 0, (EntityPlayer)player, "jrmcState");
/* 1078 */               JRMCoreH.setByte(state2 = 0, (EntityPlayer)player, "jrmcState2");
/* 1079 */               JRMCoreH.setByte(release = 0, (EntityPlayer)player, "jrmcRelease");
/* 1080 */               JRMCoreH.setInt(curStam = 0, (EntityPlayer)player, "jrmcStamina");
/* 1081 */               if (isUltraInstinctOn) statusEffects = JRMCoreH.StusEfcts(19, statusEffects, nbt, isUltraInstinctOn = false); 
/* 1082 */               if (isMysticOn) statusEffects = JRMCoreH.StusEfcts(13, statusEffects, nbt, isMysticOn = false); 
/* 1083 */               if (isGoDOn) statusEffects = JRMCoreH.StusEfcts(20, statusEffects, nbt, isGoDOn = false);
/*      */             
/*      */             } 
/*      */             
/* 1087 */             if (isMajinOn && alignment > 0)
/*      */             {
/* 1089 */               if (alignment > 99) {
/*      */                 
/* 1091 */                 JRMCoreH.StusEfcts(12, statusEffects, (EntityPlayer)player, false);
/*      */               } else {
/* 1093 */                 nbt.func_74774_a("jrmcAlign", (byte)0);
/*      */               } 
/*      */             }
/* 1096 */             if (JRMCoreH.isPowerTypeKi(powerType)) {
/*      */               
/* 1098 */               if (isKaiokenOn && strainPain > 0 && curBody > 0 && !JRMCoreH.isInCreativeMode((Entity)player)) {
/*      */                 
/* 1100 */                 curBody = (int)(curBody - maxBody * 0.8F);
/* 1101 */                 if (curBody < 0) curBody = 0; 
/* 1102 */                 JRMCoreH.setInt(curBody, (EntityPlayer)player, "jrmcBdy");
/*      */               } 
/*      */ 
/*      */ 
/*      */               
/* 1107 */               if ((isMysticOn && isUltraInstinctOn) || (isMysticOn && isGoDOn) || (isGoDOn && isUltraInstinctOn)) {
/*      */                 
/* 1109 */                 if (curBody > 0 && !JRMCoreH.isInCreativeMode((Entity)player)) {
/*      */                   
/* 1111 */                   curBody -= maxBody;
/* 1112 */                   if (curBody < 0) curBody = 0; 
/* 1113 */                   JRMCoreH.setInt(curBody, (EntityPlayer)player, "jrmcBdy");
/*      */                 } 
/* 1115 */                 if (isUltraInstinctOn) statusEffects = JRMCoreH.StusEfcts(19, statusEffects, nbt, isUltraInstinctOn = false); 
/* 1116 */                 if (isMysticOn) statusEffects = JRMCoreH.StusEfcts(13, statusEffects, nbt, isMysticOn = false); 
/* 1117 */                 if (isGoDOn) statusEffects = JRMCoreH.StusEfcts(20, statusEffects, nbt, isGoDOn = false);
/*      */               
/*      */               } 
/* 1120 */               if (isGoDOn && (GoDLevel <= 0 || !isInBaseState || !hasGodForm)) {
/* 1121 */                 statusEffects = JRMCoreH.StusEfcts(20, statusEffects, nbt, false);
/* 1122 */                 if (!hasGodForm) statusEffects = JRMCoreH.StusEfcts(19, statusEffects, nbt, false);
/*      */               
/*      */               } 
/*      */             } 
/* 1126 */             if (JRMCoreH.isPowerTypeKi(powerType) && mysticLevel > 0) {
/*      */               
/* 1128 */               if (JRMCoreConfig.MystTim > 0.0D) {
/*      */                 
/* 1130 */                 double lvlLoss = (float)(360.0D * JRMCoreConfig.MystTim);
/*      */                 
/* 1132 */                 if (JGConfigDBCFormMastery.FM_Enabled && lvlLoss != 0.0D) {
/* 1133 */                   int formID = JRMCoreH.getFormID("Mystic", race);
/* 1134 */                   double masteryLevel = JRMCoreH.getFormMasteryValue((EntityPlayer)player, formID);
/*      */                   
/* 1136 */                   double costMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_MYSTIC_TIMER_MULTI);
/*      */                   
/* 1138 */                   lvlLoss *= (float)costMulti;
/*      */                 } 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 1144 */                 if (mysticTimer > lvlLoss)
/*      */                 {
/* 1146 */                   JRMCoreH.SklLvl(10, JRMCoreH.DBCSkillsIDs, playerSkills, (EntityPlayer)player, -1);
/* 1147 */                   nbt.func_74768_a("jrmcUltmtTm", 0);
/*      */                 }
/*      */                 else
/*      */                 {
/* 1151 */                   nbt.func_74768_a("jrmcUltmtTm", ++mysticTimer);
/*      */                 }
/*      */               
/*      */               } 
/* 1155 */             } else if (isMysticOn) {
/*      */               
/* 1157 */               statusEffects = JRMCoreH.StusEfcts(13, statusEffects, nbt, isMysticOn = false);
/*      */             } 
/*      */           } 
/*      */           
/* 1161 */           if (curEnergy < 0) { JRMCoreH.setInt(0, (EntityPlayer)player, "jrmcEnrgy"); }
/* 1162 */           else if (curEnergy > maxEnergy) { JRMCoreH.setInt(maxEnergy, (EntityPlayer)player, "jrmcEnrgy"); }
/*      */           
/* 1164 */           if (curBody < 0) { JRMCoreH.setInt(0, (EntityPlayer)player, "jrmcBdy"); }
/* 1165 */           else if (curBody > maxBody) { JRMCoreH.setInt(maxBody, (EntityPlayer)player, "jrmcBdy"); }
/*      */           
/* 1167 */           if (curStam < 0) { JRMCoreH.setInt(0, (EntityPlayer)player, "jrmcStamina"); }
/* 1168 */           else if (curStam > maxStam) { JRMCoreH.setInt(maxStam, (EntityPlayer)player, "jrmcStamina"); }
/*      */ 
/*      */           
/* 1171 */           if (JRMCoreH.isInCreativeMode((Entity)player)) {
/*      */             
/* 1173 */             if (curBody < maxBody) JRMCoreH.setInt(maxBody, (EntityPlayer)player, "jrmcBdy"); 
/* 1174 */             if (curEnergy < maxEnergy) JRMCoreH.setInt(maxEnergy, (EntityPlayer)player, "jrmcEnrgy"); 
/* 1175 */             if (curStam < maxStam) JRMCoreH.setInt(maxStam, (EntityPlayer)player, "jrmcStamina");
/*      */           
/*      */           } 
/* 1178 */           if (JGConfigRaces.CONFIG_MAJIN_ENABLED && JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED) {
/* 1179 */             if (race == 5 && JRMCoreH.isPowerTypeKi(powerType)) {
/* 1180 */               if (absorption == null || absorption.length() == 0 || absorption.equals("0")) {
/* 1181 */                 nbt.func_74778_a("jrmcMajinAbsorptionData", "0,0,0+0");
/*      */               }
/* 1183 */               else if ((absorption.split(",")).length != 3) {
/*      */                 
/* 1185 */                 String[] prevAbs = jgPlayer.getAbsorption().split(",");
/* 1186 */                 String result = "";
/* 1187 */                 for (int i = 0; i < 3; i++) {
/* 1188 */                   result = result + ((prevAbs.length <= i) ? ((i == 2) ? "0+0" : "0") : prevAbs[i]) + ((i + 1 < 3) ? "," : "");
/*      */                 }
/*      */               } 
/*      */               
/* 1192 */               int level = Integer.parseInt(absorption.split(",")[0]);
/* 1193 */               if (level > JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_LEVEL) {
/* 1194 */                 for (int i = 0; i < absorption.length(); i++) {
/* 1195 */                   if (absorption.charAt(i) == ',') {
/* 1196 */                     String s = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_LEVEL + "" + absorption.substring(i);
/* 1197 */                     nbt.func_74778_a("jrmcMajinAbsorptionData", s);
/*      */                     
/*      */                     break;
/*      */                   } 
/*      */                 } 
/* 1202 */               } else if (level < 0) {
/* 1203 */                 nbt.func_74778_a("jrmcMajinAbsorptionData", "0,0,0+0");
/*      */               }
/*      */             
/* 1206 */             } else if (!absorption.equals("0,0,0+0")) {
/*      */               
/* 1208 */               nbt.func_74778_a("jrmcMajinAbsorptionData", "0,0,0+0");
/*      */             } 
/*      */           }
/*      */           
/* 1212 */           if (race == 4) {
/* 1213 */             boolean isUltraInstinctOn = JRMCoreH.StusEfcts(19, statusEffects);
/* 1214 */             boolean isMysticOn = JRMCoreH.StusEfcts(13, statusEffects);
/* 1215 */             boolean isGoDOn = JRMCoreH.StusEfcts(20, statusEffects);
/*      */             
/* 1217 */             int stateID = JRMCoreH.getArcosianFormID(state, isMysticOn, isUltraInstinctOn, isGoDOn);
/*      */ 
/*      */             
/* 1220 */             if (JRMCoreConfig.ArcosianPPGrowth[stateID] > 0 && release < 50) {
/* 1221 */               nbt.func_74768_a("jrmcArcRsrv", resrv = JRMCoreH.updateArcosianPowerPoints(resrv, SkillXNbt, state, stateID));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1227 */             if (release == 100 && JRMCoreConfig.ArcosianPPCost[stateID] > 0 && resrv > 0) {
/* 1228 */               int formID = JRMCoreH.getCurrentFormID(race, state, state2, false, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 1229 */               float ppCost = ((JRMCoreConfig.ArcosianPPCost[stateID] < 0) ? false : JRMCoreConfig.ArcosianPPCost[stateID]);
/*      */               
/* 1231 */               if (JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(powerType) && ppCost != 0.0F) {
/*      */                 
/* 1233 */                 double masteryLevel = JRMCoreH.getFormMasteryValue((EntityPlayer)player, formID);
/*      */                 
/* 1235 */                 int arcosianPPID = JGConfigDBCFormMastery.getDataID_ArcosianPPCostMulti(race, formID);
/* 1236 */                 double costMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, arcosianPPID);
/*      */                 
/* 1238 */                 ppCost *= (float)costMulti;
/*      */               } 
/*      */               
/* 1241 */               resrv -= (int)ppCost;
/*      */ 
/*      */               
/* 1244 */               nbt.func_74768_a("jrmcArcRsrv", resrv);
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1256 */           int reviveTimer = JRMCoreH.getInt((EntityPlayer)player, "jrmcReviveTmer");
/* 1257 */           boolean isDImensionNotOtherworld = true;
/*      */           
/* 1259 */           if (this.dbc) {
/*      */             
/* 1261 */             if (JRMCoreHDBC.FreeRev() && reviveTimer > 0)
/*      */             {
/* 1263 */               JRMCoreH.setInt(reviveTimer - 1, (EntityPlayer)player, "jrmcReviveTmer");
/*      */             }
/*      */             
/* 1266 */             isDImensionNotOtherworld = JRMCoreHDBC.DBCboolPlyrDimNotOtherworld(player);
/*      */           } 
/*      */           
/* 1269 */           int aliveCounter = nbt.func_74762_e("jrmcAlCntr");
/*      */           
/* 1271 */           if (isDImensionNotOtherworld && aliveCounter < 500000)
/*      */           {
/* 1273 */             nbt.func_74768_a("jrmcAlCntr", aliveCounter + 1);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1279 */           updateFusion(player, nbt, curBody, curEnergy, statusEffects);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1286 */       if (updateEveryXTick(50)) updateMeditation(player, jgPlayer, nbt);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1291 */       if (updateEveryXTick(10)) updatePlayersData(server, playerID, player, jgPlayer, nbt);
/*      */     
/*      */     } 
/* 1294 */     if (JRMCoreH.DBC()) JRMCoreHDBC.DBCCommonTickHandlerWorldGenBuildingsResetted(server); 
/* 1295 */     if (JRMCoreH.NC()) JRMCoreHNC.NCCommonTickHandlerWorldGenBuildingsResetted(server);
/*      */     
/* 1297 */     sendPlayerData(server, playersCount);
/*      */     
/* 1299 */     if (tick >= 100) {
/* 1300 */       tick = -1;
/*      */     }
/* 1302 */     tick++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean updateEveryXTick(int updateTick) {
/* 1313 */     this; return JRMCoreH.updateEveryXTick(tick, updateTick);
/*      */   }
/*      */ 
/*      */   
/* 1317 */   private static final Type JSN_TYPE_ss = (new TypeToken<JRMCss>() {  }).getType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void rd() {
/* 1324 */     File j = new File(JRMCore.configDir, "jingames.dat");
/* 1325 */     if (j.exists()) {
/*      */       try {
/* 1327 */         Gson gson = new Gson();
/* 1328 */         JsonReader reader = new JsonReader(new FileReader(j));
/* 1329 */         JRMCss data = (JRMCss)gson.fromJson(reader, JSN_TYPE_ss);
/* 1330 */         JRMCss stng = data;
/* 1331 */         JRMCoreConfig.ssc = JRMCoreConfig.cssc = stng.sc;
/* 1332 */         JRMCoreConfig.ssurl = JRMCoreConfig.cssurl = stng.su;
/* 1333 */         JRMCoreConfig.ssurl2 = JRMCoreConfig.cssurl2 = stng.su2;
/* 1334 */         mod_JRMCore.logger.info("Sloaded!");
/*      */         return;
/*      */       } catch (FileNotFoundException e) {
/* 1337 */         e.printStackTrace();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void send(String[] playerData, String finalSendData, int players, int dataID) {
/* 1350 */     if (playerData != null) {
/*      */       
/* 1352 */       String playerDatas = ":";
/*      */       
/* 1354 */       for (int i = 0; i < players; i++) {
/*      */         
/* 1356 */         if (playerData[i] != null)
/*      */         {
/* 1358 */           playerDatas = playerDatas + ":" + playerData[i];
/*      */         }
/*      */       } 
/*      */       
/* 1362 */       playerDatas = playerDatas.replaceAll("::", "");
/*      */       
/* 1364 */       if (!playerDatas.equals(finalSendData) && !playerDatas.equals(":")) {
/*      */         
/* 1366 */         if (dataID == 32) {
/*      */           
/* 1368 */           int dividePerPlayercount = JGConfigDBCFormMastery.FM_Data_Separation_Per_Player;
/*      */ 
/*      */           
/* 1371 */           if (players > dividePerPlayercount) {
/* 1372 */             int segments = players / dividePerPlayercount;
/* 1373 */             if (players / dividePerPlayercount % dividePerPlayercount != 0.0F) segments++; 
/* 1374 */             int iLastID = 0;
/* 1375 */             for (int j = 0; j < segments; j++)
/*      */             {
/* 1377 */               int startID = iLastID;
/* 1378 */               playerDatas = ":";
/* 1379 */               for (int k = 0; k < players / segments || (j == segments - 1 && iLastID < players); k++) {
/*      */                 
/* 1381 */                 if (playerData.length > iLastID)
/*      */                 {
/* 1383 */                   if (playerData[iLastID] != null) {
/* 1384 */                     playerDatas = playerDatas + ":" + playerData[iLastID];
/*      */                   }
/*      */                 }
/* 1387 */                 iLastID++;
/*      */               } 
/*      */               
/* 1390 */               playerDatas = playerDatas.replaceAll("::", "");
/*      */               
/* 1392 */               String segmentS = "::" + j + "/" + segments + "/" + players + "/" + startID + "::";
/* 1393 */               jrmcData(dataID, segmentS + playerDatas);
/*      */             }
/*      */           
/*      */           } else {
/*      */             
/* 1398 */             jrmcData(dataID, playerDatas);
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
/*      */           }
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
/*      */         }
/*      */         else {
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
/* 1452 */           jrmcData(dataID, playerDatas);
/*      */         } 
/* 1454 */         sdm(playerDatas, dataID);
/*      */       } 
/* 1456 */       adn(dataID);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void sendToP(String[] playerData, String finalSendData, int players, int dataID, MinecraftServer server) {
/* 1462 */     if (playerData != null) {
/*      */       
/* 1464 */       String playerDatas = ":";
/*      */       int i;
/* 1466 */       for (i = 0; i < players; i++) {
/*      */         
/* 1468 */         if (playerData[i] != null)
/*      */         {
/* 1470 */           playerDatas = playerDatas + ":" + playerData[i];
/*      */         }
/*      */       } 
/*      */       
/* 1474 */       playerDatas = playerDatas.replaceAll("::", "");
/*      */       
/* 1476 */       if (!playerDatas.equals(finalSendData) && !playerDatas.equals(":")) {
/*      */         
/* 1478 */         for (i = 0; i < players; i++) {
/*      */           
/* 1480 */           EntityPlayerMP player = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[i]);
/* 1481 */           String playerDataI = playerData[i];
/* 1482 */           String[] finalSendDatas = (finalSendData != null) ? finalSendData.split(":") : null;
/* 1483 */           if (playerData.length - 1 >= i)
/*      */           {
/* 1485 */             if (finalSendDatas == null || finalSendDatas.length <= i || !playerDataI.equals(finalSendDatas[i]))
/*      */             {
/* 1487 */               jrmcDataToP(dataID, playerDataI, (EntityPlayer)player);
/*      */             }
/*      */           }
/*      */         } 
/* 1491 */         sdm(playerDatas, dataID);
/*      */       } 
/* 1493 */       adn(dataID);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void sdm(String d, int dataID) {
/* 1502 */     if (dataID == 0) { sentData0 = d; }
/* 1503 */     else if (dataID == -1) { sentNames = d; }
/* 1504 */     else if (dataID == 1) { sentData1 = d; }
/* 1505 */     else if (dataID == 2) { sentData2 = d; }
/* 1506 */     else if (dataID == 3) { sentData3 = d; }
/* 1507 */     else if (dataID == 4) { sentData4 = d; }
/* 1508 */     else if (dataID == 5) { sentData5 = d; }
/* 1509 */     else if (dataID == 6) { sentData6 = d; }
/* 1510 */     else if (dataID == 7) { sentData7 = d; }
/* 1511 */     else if (dataID == 8) { sentData8 = d; }
/* 1512 */     else if (dataID == 9) { sentData9 = d; }
/* 1513 */     else if (dataID == 10) { sentDat10 = d; }
/* 1514 */     else if (dataID == 11) { sentDat11 = d; }
/* 1515 */     else if (dataID == 12) { sentDat12 = d; }
/* 1516 */     else if (dataID == 13) { sentDat13 = d; }
/* 1517 */     else if (dataID == 14) { sentDat14 = d; }
/* 1518 */     else if (dataID == 15) { sentDat15 = d; }
/* 1519 */     else if (dataID == 16) { sentDat16 = d; }
/* 1520 */     else if (dataID == 17) { sentDat17 = d; }
/* 1521 */     else if (dataID == 18) { sentDat18 = d; }
/* 1522 */     else if (dataID == 19) { sentDat19 = d; }
/* 1523 */     else if (dataID == 20) { sentDat20 = d; }
/* 1524 */     else if (dataID == 21) { sentDat21 = d; }
/* 1525 */     else if (dataID == 22) { sentDat22 = d; }
/* 1526 */     else if (dataID == 23) { sentDat23 = d; }
/* 1527 */     else if (dataID == 24) { sentDat24 = d; }
/* 1528 */     else if (dataID == 25) { sentDat25 = d; }
/* 1529 */     else if (dataID == 26) { sentDat26 = d; }
/* 1530 */     else if (dataID == 27) { sentDat27 = d; }
/* 1531 */     else if (dataID == 28) { sentDat28 = d; }
/* 1532 */     else if (dataID == 29) { sentDat29 = d; }
/* 1533 */     else if (dataID == 30) { sentDat30 = d; }
/* 1534 */     else if (dataID == 31) { sentDat31 = d; }
/* 1535 */     else if (dataID == 32) { sentDat32 = d; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void adn(int dataID) {
/* 1543 */     if (dataID == 0) { data0 = null; }
/* 1544 */     else if (dataID == -1) { names = null; }
/* 1545 */     else if (dataID == 1) { data1 = null; }
/* 1546 */     else if (dataID == 2) { data2 = null; }
/* 1547 */     else if (dataID == 3) { data3 = null; }
/* 1548 */     else if (dataID == 4) { data4 = null; }
/* 1549 */     else if (dataID == 5) { data5 = null; }
/* 1550 */     else if (dataID == 6) { data6 = null; }
/* 1551 */     else if (dataID == 7) { data7 = null; }
/* 1552 */     else if (dataID == 8) { data8 = null; }
/* 1553 */     else if (dataID == 9) { data9 = null; }
/* 1554 */     else if (dataID == 10) { dat10 = null; }
/* 1555 */     else if (dataID == 11) { dat11 = null; }
/* 1556 */     else if (dataID == 12) { dat12 = null; }
/* 1557 */     else if (dataID == 13) { dat13 = null; }
/* 1558 */     else if (dataID == 14) { dat14 = null; }
/* 1559 */     else if (dataID == 15) { dat15 = null; }
/* 1560 */     else if (dataID == 16) { dat16 = null; }
/* 1561 */     else if (dataID == 17) { dat17 = null; }
/* 1562 */     else if (dataID == 18) { dat18 = null; }
/* 1563 */     else if (dataID == 19) { dat19 = null; }
/* 1564 */     else if (dataID == 20) { dat20 = null; }
/* 1565 */     else if (dataID == 21) { dat21 = null; }
/* 1566 */     else if (dataID == 22) { dat22 = null; }
/* 1567 */     else if (dataID == 23) { dat23 = null; }
/* 1568 */     else if (dataID == 24) { dat24 = null; }
/* 1569 */     else if (dataID == 25) { dat25 = null; }
/* 1570 */     else if (dataID == 26) { dat26 = null; }
/* 1571 */     else if (dataID == 27) { dat27 = null; }
/* 1572 */     else if (dataID == 28) { dat28 = null; }
/* 1573 */     else if (dataID == 29) { dat29 = null; }
/* 1574 */     else if (dataID == 30) { dat30 = null; }
/* 1575 */     else if (dataID == 31) { dat31 = null; }
/* 1576 */     else if (dataID == 32) { dat32 = null; }
/*      */   
/*      */   }
/*      */   
/* 1580 */   protected static float width = 0.6F;
/* 1581 */   protected static float height = 1.8F;
/* 1582 */   static float serverHeight = height;
/* 1583 */   static float serverEyHeigClc = 0.18F;
/* 1584 */   static float serverDefEyHeig = serverHeight - serverEyHeigClc;
/* 1585 */   static float serveryOffset = height - serverHeight; public static int U5TBbT(String l) { String w;
/*      */     int a;
/*      */     int i;
/* 1588 */     for (w = "0123456789ABCDEF", l = l.toUpperCase(), a = 0, i = 0; i < l.length(); ) { char c = l.charAt(i); int d = w.indexOf(c); a = 16 * a + d; i++; }  return a; }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int T5yLLW(int b) {
/* 1593 */     String k = "3B9ACA00"; return (b > U5TBbT(k) * (h ? 2 : 1)) ? (U5TBbT(k) * (h ? 2 : 1)) : b;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean h = false;
/*      */   
/*      */   protected static void sS(EntityPlayer p, float par1, float par2) {
/* 1600 */     if (par1 != p.field_70130_N || par2 != p.field_70131_O) {
/*      */       
/* 1602 */       float f = p.field_70130_N;
/* 1603 */       p.field_70130_N = par1;
/* 1604 */       p.field_70131_O = par2;
/* 1605 */       p.field_70121_D.field_72336_d = p.field_70121_D.field_72340_a + p.field_70130_N;
/* 1606 */       p.field_70121_D.field_72334_f = p.field_70121_D.field_72339_c + p.field_70130_N;
/* 1607 */       p.field_70121_D.field_72337_e = p.field_70121_D.field_72338_b + p.field_70131_O;
/*      */     } 
/*      */     
/* 1610 */     float f2 = par1 % 2.0F;
/*      */     
/* 1612 */     if (f2 < 0.375D) {
/*      */       
/* 1614 */       p.field_70168_am = Entity.EnumEntitySize.SIZE_1;
/*      */     }
/* 1616 */     else if (f2 < 0.75D) {
/*      */       
/* 1618 */       p.field_70168_am = Entity.EnumEntitySize.SIZE_2;
/*      */     }
/* 1620 */     else if (f2 < 1.0D) {
/*      */       
/* 1622 */       p.field_70168_am = Entity.EnumEntitySize.SIZE_3;
/*      */     }
/* 1624 */     else if (f2 < 1.375D) {
/*      */       
/* 1626 */       p.field_70168_am = Entity.EnumEntitySize.SIZE_4;
/*      */     }
/* 1628 */     else if (f2 < 1.75D) {
/*      */       
/* 1630 */       p.field_70168_am = Entity.EnumEntitySize.SIZE_5;
/*      */     }
/*      */     else {
/*      */       
/* 1634 */       p.field_70168_am = Entity.EnumEntitySize.SIZE_6;
/*      */     } 
/*      */   }
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
/*      */   public void countbackForLegendary(int playersCount) {
/* 1651 */     if (this.dbc && playersCount > 0 && lf.size() < JRMCoreConfig.selgnd && JRMCoreConfig.selgndc2 > 0) {
/*      */       
/* 1653 */       cbl--;
/* 1654 */       if (cbl < 0) {
/*      */         
/* 1656 */         double random = Math.random();
/* 1657 */         if (playersCount > JRMCoreConfig.selgndc2 || random < (JRMCoreConfig.selgndc * 0.01F)) {
/*      */           
/* 1659 */           Random rnd = new Random();
/* 1660 */           chsn = rnd.nextInt(playersCount);
/*      */         } 
/* 1662 */         cbl = 24000;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void serverStart(MinecraftServer server) {
/* 1669 */     if (start) {
/*      */       
/* 1671 */       tna3fu = server.func_71266_T();
/*      */       
/* 1673 */       JRMCoreM.om(server);
/* 1674 */       rd();
/* 1675 */       bs = JRMCoreH.bsrwi(server);
/*      */       
/* 1677 */       if (this.nc) JRMCoreHNC.WorldGenBuildingsSpawnCheck(server); 
/* 1678 */       if (this.dbc) JRMCoreHDBC.WorldGenBuildingsSpawnCheck(server); 
/* 1679 */       start = false;
/* 1680 */       if (JRMCoreConfig.osbic > 0) {
/* 1681 */         op = true;
/* 1682 */         JRMCoreH.osbic = new HashMap<String, Integer>();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void checkBuildingsSpawn(MinecraftServer server) {
/* 1689 */     if (bldngChkr && JRMCoreConfig.BuildingSpawnCheck)
/*      */     {
/* 1691 */       if (this.dbc && bldngsChecker <= 0) {
/*      */         
/* 1693 */         JRMCoreHDBC.spawnBuilds(server);
/* 1694 */         if (this.nc) JRMCoreHNC.spawnBuilds(server);
/*      */         
/* 1696 */         bldngsChecker = 300;
/*      */       }
/*      */       else {
/*      */         
/* 1700 */         bldngsChecker--;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void savePlayerData(int playersCount) {
/* 1707 */     if (names == null || names.length != playersCount) names = new String[playersCount]; 
/* 1708 */     if (data0 == null || data0.length != playersCount) data0 = new String[playersCount]; 
/* 1709 */     if (data1 == null || data1.length != playersCount) data1 = new String[playersCount]; 
/* 1710 */     if (data2 == null || data2.length != playersCount) data2 = new String[playersCount]; 
/* 1711 */     if (data3 == null || data3.length != playersCount) data3 = new String[playersCount]; 
/* 1712 */     if (data4 == null || data4.length != playersCount) data4 = new String[playersCount];
/*      */     
/* 1714 */     if (this.dbc || this.nc || this.sao) {
/*      */       
/* 1716 */       if (data5 == null || data5.length != playersCount) data5 = new String[playersCount]; 
/* 1717 */       if (data6 == null || data6.length != playersCount) data6 = new String[playersCount]; 
/* 1718 */       if (data7 == null || data7.length != playersCount) data7 = new String[playersCount]; 
/* 1719 */       if (data8 == null || data8.length != playersCount) data8 = new String[playersCount]; 
/* 1720 */       if (data9 == null || data9.length != playersCount) data9 = new String[playersCount]; 
/* 1721 */       if (dat10 == null || dat10.length != playersCount) dat10 = new String[playersCount]; 
/* 1722 */       if (dat11 == null || dat11.length != playersCount) dat11 = new String[playersCount]; 
/* 1723 */       if (dat12 == null || dat12.length != playersCount) dat12 = new String[playersCount]; 
/* 1724 */       if (dat13 == null || dat13.length != playersCount) dat13 = new String[playersCount]; 
/* 1725 */       if (dat14 == null || dat14.length != playersCount) dat14 = new String[playersCount]; 
/* 1726 */       if (dat15 == null || dat15.length != playersCount) dat15 = new String[playersCount]; 
/* 1727 */       if (dat16 == null || dat16.length != playersCount) dat16 = new String[playersCount]; 
/* 1728 */       if (dat17 == null || dat17.length != playersCount) dat17 = new String[playersCount]; 
/* 1729 */       if (dat18 == null || dat18.length != playersCount) dat18 = new String[playersCount]; 
/* 1730 */       if (dat19 == null || dat19.length != playersCount) dat19 = new String[playersCount]; 
/* 1731 */       if (dat20 == null || dat20.length != playersCount) dat20 = new String[playersCount]; 
/* 1732 */       if (dat21 == null || dat21.length != playersCount) dat21 = new String[playersCount]; 
/* 1733 */       if (dat22 == null || dat22.length != playersCount) dat22 = new String[playersCount]; 
/* 1734 */       if (dat23 == null || dat23.length != playersCount) dat23 = new String[playersCount]; 
/* 1735 */       if (dat24 == null || dat24.length != playersCount) dat24 = new String[playersCount]; 
/* 1736 */       if (dat25 == null || dat25.length != playersCount) dat25 = new String[playersCount];
/*      */     
/*      */     } 
/* 1739 */     if (this.jfc) {
/*      */       
/* 1741 */       if (dat26 == null || dat26.length != playersCount) dat26 = new String[playersCount]; 
/* 1742 */       if (dat27 == null || dat27.length != playersCount) dat27 = new String[playersCount]; 
/* 1743 */       if (dat28 == null || dat28.length != playersCount) dat28 = new String[playersCount]; 
/* 1744 */       if (dat29 == null || dat29.length != playersCount) dat29 = new String[playersCount]; 
/* 1745 */       if (dat30 == null || dat30.length != playersCount) dat30 = new String[playersCount];
/*      */     
/*      */     } 
/* 1748 */     if (JRMCoreConfig.JRMCABonusOn)
/*      */     {
/* 1750 */       if (dat31 == null || dat31.length != playersCount) dat31 = new String[playersCount];
/*      */     
/*      */     }
/* 1753 */     if (JGConfigDBCFormMastery.FM_Enabled && this.dbc)
/*      */     {
/* 1755 */       if (dat32 == null || dat32.length != playersCount) dat32 = new String[playersCount];
/*      */     
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void nullifyPlayerData(int playersCount) {
/* 1763 */     if (playersCount == 0 && sentNames != null) {
/*      */       
/* 1765 */       sentNames = null; sentData0 = null; sentData1 = null; sentData2 = null; sentData3 = null; sentData4 = null; sentData5 = null; sentData6 = null; sentData7 = null; sentData8 = null;
/* 1766 */       sentData9 = null; sentDat10 = null; sentDat11 = null; sentDat12 = null; sentDat13 = null; sentDat14 = null; sentDat15 = null; sentDat16 = null; sentDat17 = null; sentDat18 = null;
/* 1767 */       sentDat19 = null; sentDat20 = null;
/* 1768 */       sentDat21 = null; sentDat22 = null; sentDat23 = null; sentDat24 = null; sentDat25 = null; sentDat26 = null; sentDat27 = null; sentDat28 = null; sentDat29 = null; sentDat30 = null;
/* 1769 */       sentDat31 = null; sentDat32 = null;
/*      */       
/* 1771 */       names = null; data0 = null; data1 = null; data2 = null; data3 = null; data4 = null; data5 = null; data6 = null; data7 = null; data8 = null;
/* 1772 */       data9 = null; dat10 = null; dat11 = null; dat12 = null; dat13 = null; dat14 = null; dat15 = null; dat16 = null; dat17 = null; dat18 = null;
/* 1773 */       dat19 = null; dat20 = null;
/* 1774 */       dat21 = null; dat22 = null; dat23 = null; dat24 = null; dat25 = null; dat26 = null; dat27 = null; dat28 = null; dat29 = null; dat30 = null;
/* 1775 */       dat31 = null; dat32 = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeGroupMembers(MinecraftServer server) {
/* 1781 */     if (this.c > 600) {
/*      */       
/* 1783 */       HashMap<EntityPlayer, Integer> playerSagaIDs = new HashMap<EntityPlayer, Integer>();
/*      */       
/* 1785 */       for (Object entityObject : (server.func_71203_ab()).field_72404_b) {
/*      */         
/* 1787 */         EntityPlayer player = (EntityPlayer)entityObject;
/* 1788 */         int sagaID = JRMCoreH.getInt(player, "JRMCGID");
/* 1789 */         playerSagaIDs.put(player, Integer.valueOf(JRMCoreH.getInt(player, "JRMCGID")));
/*      */       } 
/*      */       
/* 1792 */       for (EntityPlayer player : playerSagaIDs.keySet()) {
/*      */         
/* 1794 */         int id = 0;
/* 1795 */         EntityPlayer previousMember = null;
/* 1796 */         for (EntityPlayer player1 : playerSagaIDs.keySet()) {
/*      */           
/* 1798 */           if (((Integer)playerSagaIDs.get(player)).equals(playerSagaIDs.get(player1))) {
/*      */             
/* 1800 */             if (id > 10) {
/*      */               
/* 1802 */               String n = JRMCoreH.getString(player1, "JRMCGLIDs");
/* 1803 */               if (!n.equalsIgnoreCase(player1.func_70005_c_())) {
/*      */                 
/* 1805 */                 JRMCoreH.setString(" ", player1, "JRMCGLIDs");
/* 1806 */                 JRMCoreH.setInt(0, player1, "JRMCGID");
/*      */               }
/* 1808 */               else if (previousMember != null) {
/*      */                 
/* 1810 */                 JRMCoreH.setString(" ", previousMember, "JRMCGLIDs");
/* 1811 */                 JRMCoreH.setInt(0, previousMember, "JRMCGID");
/* 1812 */                 playerSagaIDs.put(previousMember, Integer.valueOf(0));
/*      */               } 
/*      */             } 
/* 1815 */             id++;
/*      */           } 
/* 1817 */           previousMember = player1;
/*      */         } 
/*      */       } 
/* 1820 */       this.c = 0;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void offlineProtector(MinecraftServer server, int playersCount) {
/* 1826 */     if (op) {
/*      */       
/* 1828 */       playersCount = (server.func_71213_z()).length;
/* 1829 */       HashMap<String, Integer> lo = new HashMap<String, Integer>();
/* 1830 */       for (int playerID = 0; playerID < playersCount; playerID++) {
/*      */         
/* 1832 */         String nm = server.func_71213_z()[playerID];
/* 1833 */         Integer os = JRMCoreH.osbic.get(nm);
/* 1834 */         if (os != null && os.intValue() >= JRMCoreConfig.osbic * 20) {
/*      */           
/* 1836 */           lo.put(nm, Integer.valueOf(JRMCoreConfig.osbic * 20));
/*      */         }
/* 1838 */         else if (os != null) {
/*      */           
/* 1840 */           lo.put(nm, os);
/*      */         } 
/*      */       } 
/* 1843 */       JRMCoreH.osbic = lo;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sendPlayerData(MinecraftServer server, int playersCount) {
/* 1852 */     send(names, sentNames, playersCount, -1);
/* 1853 */     send(data0, sentData0, playersCount, 0);
/* 1854 */     send(data1, sentData1, playersCount, 1);
/* 1855 */     send(data2, sentData2, playersCount, 2);
/* 1856 */     send(data3, sentData3, playersCount, 3);
/* 1857 */     send(data4, sentData4, playersCount, 4);
/*      */     
/* 1859 */     if (this.dbc || this.nc || this.sao) {
/*      */       
/* 1861 */       send(data5, sentData5, playersCount, 5);
/* 1862 */       send(data6, sentData6, playersCount, 6);
/* 1863 */       sendToP(data7, sentData7, playersCount, 7, server);
/* 1864 */       send(data8, sentData8, playersCount, 8);
/* 1865 */       send(data9, sentData9, playersCount, 9);
/* 1866 */       send(dat10, sentDat10, playersCount, 10);
/* 1867 */       send(dat11, sentDat11, playersCount, 11);
/* 1868 */       send(dat12, sentDat12, playersCount, 12);
/* 1869 */       send(dat13, sentDat13, playersCount, 13);
/* 1870 */       send(dat14, sentDat14, playersCount, 14);
/* 1871 */       sendToP(dat15, sentDat15, playersCount, 15, server);
/* 1872 */       send(dat16, sentDat16, playersCount, 16);
/* 1873 */       sendToP(dat17, sentDat17, playersCount, 17, server);
/* 1874 */       send(dat18, sentDat18, playersCount, 18);
/* 1875 */       send(dat19, sentDat19, playersCount, 19);
/* 1876 */       sendToP(dat20, sentDat20, playersCount, 20, server);
/* 1877 */       sendToP(dat21, sentDat21, playersCount, 21, server);
/* 1878 */       sendToP(dat22, sentDat22, playersCount, 22, server);
/* 1879 */       send(dat23, sentDat23, playersCount, 23);
/* 1880 */       sendToP(dat24, sentDat24, playersCount, 24, server);
/* 1881 */       sendToP(dat25, sentDat25, playersCount, 25, server);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1886 */     if (this.jfc) {
/*      */       
/* 1888 */       send(dat26, sentDat26, playersCount, 26);
/* 1889 */       sendToP(dat27, sentDat27, playersCount, 27, server);
/* 1890 */       sendToP(dat28, sentDat28, playersCount, 28, server);
/* 1891 */       sendToP(dat29, sentDat29, playersCount, 29, server);
/* 1892 */       send(dat30, sentDat30, playersCount, 30);
/*      */     } 
/*      */     
/* 1895 */     if (JRMCoreConfig.JRMCABonusOn)
/*      */     {
/* 1897 */       send(dat31, sentDat31, playersCount, 31);
/*      */     }
/*      */ 
/*      */     
/* 1901 */     if (JGConfigDBCFormMastery.FM_Enabled && this.dbc)
/*      */     {
/* 1903 */       send(dat32, sentDat32, playersCount, 32);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateFusion(EntityPlayerMP player, NBTTagCompound nbt, int curBody, int curEnergy, String statusEffects) {
/* 1909 */     String fusionMembers = nbt.func_74779_i("jrmcFuzion");
/*      */     
/* 1911 */     if (fusionMembers.length() == 0)
/*      */     {
/* 1913 */       nbt.func_74778_a("jrmcFuzion", fusionMembers = " ");
/*      */     }
/*      */     
/* 1916 */     if (!fusionMembers.equals(" ")) {
/*      */       
/* 1918 */       String[] fusionParticipants = fusionMembers.split(",");
/*      */       
/* 1920 */       if (fusionParticipants.length == 3) {
/*      */         
/* 1922 */         boolean isController = fusionParticipants[0].equalsIgnoreCase(player.func_70005_c_());
/* 1923 */         boolean isSpectator = fusionParticipants[1].equalsIgnoreCase(player.func_70005_c_());
/*      */         
/* 1925 */         if (isController || isSpectator)
/*      */         {
/* 1927 */           EntityPlayer fusedPlayer = player.field_70170_p.func_72924_a(fusionParticipants[isController ? 0 : 1]);
/* 1928 */           boolean isFusedPlayerNotNull = (fusedPlayer != null);
/* 1929 */           if (isFusedPlayerNotNull) {
/*      */             
/* 1931 */             EntityPlayer otherFusedPlayer = player.field_70170_p.func_72924_a(fusionParticipants[isController ? 1 : 0]);
/* 1932 */             boolean isOtherFusedPlayerNotNull = (otherFusedPlayer != null);
/* 1933 */             int fusionTime = Integer.parseInt(fusionParticipants[2]) - 1;
/*      */             
/* 1935 */             boolean fused = true;
/*      */             
/* 1937 */             if (isOtherFusedPlayerNotNull) {
/*      */               
/* 1939 */               NBTTagCompound nbt2 = JRMCoreH.nbt(otherFusedPlayer);
/* 1940 */               String fusionMembers2 = nbt2.func_74779_i("jrmcFuzion");
/* 1941 */               String[] fusionParticipants2 = fusionMembers2.split(",");
/*      */ 
/*      */ 
/*      */               
/* 1945 */               if (fusionParticipants2.length == 3)
/*      */               {
/* 1947 */                 if (isSpectator && fusionTime > 0 && player.func_70032_d((Entity)otherFusedPlayer) > 5.0F)
/*      */                 {
/* 1949 */                   player.func_70107_b(otherFusedPlayer.field_70165_t, otherFusedPlayer.field_70163_u, otherFusedPlayer.field_70161_v);
/*      */                 
/*      */                 }
/*      */               }
/* 1953 */               else if (fusionParticipants2.length == 1)
/*      */               {
/* 1955 */                 fused = false;
/* 1956 */                 nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
/* 1957 */                 JRMCoreH.StusEfcts(10, nbt, false);
/* 1958 */                 JRMCoreH.StusEfcts(11, nbt, false);
/*      */                 
/* 1960 */                 nbt2.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
/* 1961 */                 JRMCoreH.StusEfcts(10, nbt2, false);
/* 1962 */                 JRMCoreH.StusEfcts(11, nbt2, false);
/*      */               
/*      */               }
/*      */             
/*      */             }
/*      */             else {
/*      */               
/* 1969 */               nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
/* 1970 */               JRMCoreH.StusEfcts(10, nbt, false);
/* 1971 */               JRMCoreH.StusEfcts(11, nbt, false);
/* 1972 */               fused = false;
/*      */             } 
/*      */             
/* 1975 */             if (fused)
/*      */             {
/* 1977 */               if (fusionTime <= 0) {
/*      */                 
/* 1979 */                 nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
/* 1980 */                 JRMCoreH.StusEfcts(10, nbt, false);
/* 1981 */                 JRMCoreH.StusEfcts(11, nbt, false);
/*      */               }
/*      */               else {
/*      */                 
/* 1985 */                 if (fusedPlayer.field_71093_bK != player.field_71093_bK) fusionTime = 0;
/*      */ 
/*      */                 
/* 1988 */                 nbt.func_74778_a("jrmcFuzion", fusionMembers = fusionParticipants[0] + "," + fusionParticipants[1] + "," + fusionTime);
/*      */ 
/*      */                 
/* 1991 */                 if (isSpectator)
/*      */                 {
/* 1993 */                   nbt.func_74768_a("jrmcBdy", curBody);
/* 1994 */                   nbt.func_74768_a("jrmcEnrgy", curEnergy);
/*      */                 }
/*      */               
/*      */               } 
/*      */             }
/*      */           } else {
/*      */             
/* 2001 */             nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
/* 2002 */             JRMCoreH.StusEfcts(10, nbt, false);
/* 2003 */             JRMCoreH.StusEfcts(11, nbt, false);
/*      */           }
/*      */         
/*      */         }
/*      */       
/* 2008 */       } else if (fusionParticipants.length == 1) {
/*      */         
/* 2010 */         int fusionOverTime = Integer.parseInt(fusionParticipants[0]) - 1;
/*      */         
/* 2012 */         if (fusionOverTime <= 0)
/*      */         {
/* 2014 */           nbt.func_74778_a("jrmcFuzion", " ");
/*      */         }
/*      */         else
/*      */         {
/* 2018 */           nbt.func_74778_a("jrmcFuzion", "" + fusionOverTime);
/*      */         }
/*      */       
/*      */       } 
/*      */     } else {
/*      */       
/* 2024 */       if (JRMCoreH.StusEfcts(10, statusEffects)) JRMCoreH.StusEfcts(10, nbt, false); 
/* 2025 */       if (JRMCoreH.StusEfcts(11, statusEffects)) JRMCoreH.StusEfcts(11, nbt, false);
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public void updateMeditation(EntityPlayerMP player, JGPlayerMP jgPlayer, NBTTagCompound nbt) {
/* 2031 */     byte powerType = nbt.func_74771_c("jrmcPwrtyp");
/*      */     
/* 2033 */     if (JRMCoreConfig.SklMedCat == 0 && (JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType))) {
/*      */       
/* 2035 */       String statusEffects = nbt.func_74779_i("jrmcStatusEff");
/*      */       
/* 2037 */       if (statusEffects.contains(JRMCoreH.StusEfcts[4])) {
/*      */         
/* 2039 */         int foodLevel = player.func_71024_bL().func_75116_a();
/* 2040 */         boolean isFoodAboveZero = (foodLevel > 0);
/*      */         
/* 2042 */         if (isFoodAboveZero) {
/*      */           
/* 2044 */           byte race = jgPlayer.getRace();
/* 2045 */           byte classID = jgPlayer.getClassID();
/* 2046 */           int[] playerAttributes = jgPlayer.getAttributes();
/* 2047 */           String[] playerSkills = jgPlayer.getSkills();
/*      */           
/* 2049 */           int curEnergy = jgPlayer.getEnergy();
/* 2050 */           int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(playerSkills, powerType));
/*      */           
/* 2052 */           if (curEnergy < maxEnergy) {
/*      */             
/* 2054 */             byte release = JRMCoreH.getByte((EntityPlayer)player, "jrmcRelease");
/*      */             
/* 2056 */             float RREnergy = jgPlayer.getEnergyRegen(race, classID, powerType);
/*      */             
/* 2058 */             int curStam = jgPlayer.getStamina();
/* 2059 */             int maxStam = jgPlayer.getStaminaMax(race, classID, powerType, playerAttributes);
/* 2060 */             float RRStam = jgPlayer.getStaminaRegen(race, classID, powerType);
/*      */             
/* 2062 */             int meditationSkillLvl = JRMCoreH.SklLvl((powerType == 1) ? 7 : 11, powerType, playerSkills);
/* 2063 */             if (meditationSkillLvl > 0) {
/*      */               
/* 2065 */               double add = JRMCoreH.regenRate(powerType, maxEnergy, RREnergy) * (JRMCoreConfig.SklMedRate * 10.0F * meditationSkillLvl * 0.1F);
/* 2066 */               add = add * release * 0.009999999776482582D;
/* 2067 */               if (add >= 0.0D) {
/*      */                 
/* 2069 */                 add = (add < 1.0D) ? 1.0D : add;
/* 2070 */                 int all = (int)(curEnergy + add);
/* 2071 */                 if (curStam > add * 0.5D * JRMCoreConfig.dat5698) {
/*      */                   
/* 2073 */                   JRMCoreH.setInt((all > maxEnergy) ? maxEnergy : all, (EntityPlayer)player, "jrmcEnrgy");
/* 2074 */                   if (!JRMCoreH.isInCreativeMode((Entity)player)) JRMCoreH.setInt((int)(curStam - add * 0.5D * JRMCoreConfig.dat5698), (EntityPlayer)player, "jrmcStamina");
/*      */                 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updatePlayersData(MinecraftServer server, int playerID, EntityPlayerMP player, JGPlayerMP jgPlayer, NBTTagCompound nbt) {
/* 2090 */     byte powerType = nbt.func_74771_c("jrmcPwrtyp");
/* 2091 */     int sao_lvl = 0;
/* 2092 */     int sao_exp = 0;
/*      */     
/* 2094 */     if (powerType == 3) {
/*      */       
/* 2096 */       sao_lvl = nbt.func_74762_e("saocLvl"); sao_lvl = (sao_lvl < 1) ? 1 : sao_lvl;
/* 2097 */       sao_exp = nbt.func_74762_e("saocExp");
/*      */     } 
/*      */     
/* 2100 */     byte race = jgPlayer.getRace();
/* 2101 */     int[] playerAttributes = jgPlayer.getAttributes();
/*      */     
/* 2103 */     String dns = nbt.func_74779_i("jrmcDNS");
/* 2104 */     byte rage = nbt.func_74771_c("jrmcSaiRg");
/* 2105 */     int heat = nbt.func_74762_e("jrmcEf8slc");
/* 2106 */     byte release = JRMCoreH.getByte((EntityPlayer)player, "jrmcRelease");
/* 2107 */     byte alive = nbt.func_74771_c("jrmcAlv");
/* 2108 */     String statusEffects = nbt.func_74779_i("jrmcStatusEff");
/* 2109 */     int resrv = JRMCoreH.getInt((EntityPlayer)player, "jrmcArcRsrv");
/* 2110 */     String absorption = JRMCoreH.getString((EntityPlayer)player, "jrmcMajinAbsorptionData");
/* 2111 */     int strnAct = nbt.func_74762_e("jrmcStrainActv");
/* 2112 */     int ac = nbt.func_74762_e("jrmcAlCntr");
/* 2113 */     int strn = nbt.func_74762_e("jrmcStrain");
/* 2114 */     int strng = nbt.func_74762_e("jrmcGodStrain");
/* 2115 */     int strnp = nbt.func_74762_e("jrmcGyJ7dp");
/* 2116 */     int gp = nbt.func_74762_e("jrmcGodPwr");
/*      */     
/* 2118 */     int ko = nbt.func_74762_e("jrmcHar4va");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2123 */     boolean dead = (alive == 1);
/* 2124 */     if (this.dbc && dead && JRMCoreHDBC.DBCboolPlyrDimNotOtherworld(player))
/*      */     {
/* 2126 */       if (player.func_70089_S() && !player.field_71075_bZ.field_75098_d)
/*      */       {
/* 2128 */         if (player != null) {
/*      */           
/* 2130 */           byte alignmentID = 1;
/* 2131 */           if (nbt.func_74781_a("jrmcAlign") != null) {
/*      */             
/* 2133 */             byte align = nbt.func_74771_c("jrmcAlign");
/* 2134 */             if (align > 66) { alignmentID = 0; }
/* 2135 */             else if (align < 33) { alignmentID = 2; }
/*      */           
/*      */           } 
/* 2138 */           player.field_70154_o = null;
/* 2139 */           player.field_70153_n = null;
/* 2140 */           ChunkCoordinates chunkcoordinates = new ChunkCoordinates((int)DBCConfig.DeathDim[alignmentID][0], (int)DBCConfig.DeathDim[alignmentID][1], (int)DBCConfig.DeathDim[alignmentID][2]);
/* 2141 */           if (player.getBedLocation(JRMCoreHDBC.otherworld()) != chunkcoordinates)
/*      */           {
/* 2143 */             player.setSpawnChunk(chunkcoordinates, true, JRMCoreHDBC.otherworld());
/*      */           }
/* 2145 */           JRMCoreHDBC.WorldTper(server, player, JRMCoreHDBC.otherworld());
/* 2146 */           player.func_70634_a(DBCConfig.DeathDim[alignmentID][0], DBCConfig.DeathDim[alignmentID][1], DBCConfig.DeathDim[alignmentID][2]);
/* 2147 */           player.func_71023_q(1);
/* 2148 */           mod_JRMCore.logger.info(player.func_70005_c_() + " Has died and gone to Otherworld.");
/*      */         } 
/*      */       }
/*      */     }
/*      */     
/* 2153 */     if (!player.field_71075_bZ.field_75098_d && (this.dbc || this.nc || this.sao) && powerType > 0 && nbt.func_74762_e("jrmcBdy") <= 0)
/*      */     {
/* 2155 */       player.func_70097_a(DamageSource.field_76380_i, 6.0F);
/*      */     }
/*      */     
/* 2158 */     if (!player.func_70608_bn()) {
/*      */       
/* 2160 */       float f1 = 0.9375F;
/* 2161 */       float f2 = 1.0F;
/* 2162 */       float f3 = 1.0F;
/* 2163 */       boolean noC = !JRMCoreH.DBC();
/* 2164 */       if (JRMCoreH.dnsGender(JRMCoreH.dns) <= 1) f1 = 0.73F + (noC ? 0.27F : 0.0F); 
/* 2165 */       if (JRMCoreH.dnsGender(JRMCoreH.dns) >= 2) f1 = 0.7F + (noC ? 0.27F : 0.0F);
/*      */       
/* 2167 */       float yc = 1.0F;
/* 2168 */       if (JRMCoreH.JYC()) {
/* 2169 */         float A = nbt.func_74760_g("JRYCAge");
/* 2170 */         if (A <= 6.0F) yc = 0.5F; 
/* 2171 */         if (A > 6.0F && A <= 52.0F) yc = (3.0F - 1.0F + 1.0F - (A - 6.0F) / 46.0F) * 0.5F; 
/* 2172 */         if (A > 53.0F) yc = 1.0F; 
/* 2173 */         yc = (yc < 0.54347825F) ? 0.54347825F : yc;
/*      */       } 
/*      */       
/* 2176 */       if (JRMCoreH.DBC() && JRMCoreConfig.sizes) {
/* 2177 */         float f1r = f1;
/* 2178 */         byte state = nbt.func_74771_c("jrmcState");
/* 2179 */         f1 += JRMCoreHDBC.DBCsizeBasedOnCns(playerAttributes);
/* 2180 */         if (!JRMCoreH.isPowerTypeChakra(powerType)) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2186 */           boolean divine = (race == 3) ? jgPlayer.hasStatusEffect(17, jgPlayer.getStatusEffects()) : false;
/* 2187 */           f2 = JRMCoreHDBC.DBCsizeBasedOnRace(race, state, divine);
/* 2188 */           f3 = JRMCoreHDBC.DBCsizeBasedOnRace2(race, state, divine);
/*      */         } 
/* 2190 */         if (JRMCoreH.rSai(race) && (state == 7 || state == 8)) { release = 50; f1 = f1r; }
/* 2191 */          float f3a = (f3 - 1.0F) * release * 0.02F + 1.0F;
/* 2192 */         f3 = (f3a > f3) ? f3 : ((f3 > 1.0F) ? f3a : f3);
/* 2193 */         float f2a = (f2 - 1.0F) * release * 0.02F + 1.0F;
/* 2194 */         f2 = (f2 > 1.0F) ? f2a : f2;
/* 2195 */         float f1a1 = (f1 - f1r) * ((release <= 50) ? 0.25F : 0.5F);
/* 2196 */         float f1ac = f1a1 * release * 0.02F;
/* 2197 */         float f1ao = f1 - f1r - f1a1 + f1ac + f1r;
/* 2198 */         f1 = f1ao;
/* 2199 */         String str = nbt.func_74779_i("jrmcFuzion");
/* 2200 */         if (str.contains(",")) {
/* 2201 */           String[] FznA = str.split(",");
/* 2202 */           if (FznA.length == 3) {
/* 2203 */             boolean isp2 = FznA[1].equalsIgnoreCase(player.func_70005_c_());
/* 2204 */             if (isp2) {
/* 2205 */               f1 = 0.0F;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2211 */       float clientHght = height * f1 * f3 * yc;
/* 2212 */       float clientWdth2 = width * f1 * f2 * f3 * yc;
/* 2213 */       sS((EntityPlayer)player, clientWdth2, clientHght);
/* 2214 */       player.eyeHeight = player.getDefaultEyeHeight() * f1 * f3 * yc;
/*      */     } 
/*      */     
/* 2217 */     if (nbt.func_74781_a("jrmcAlign") == null) nbt.func_74774_a("jrmcAlign", (byte)67); 
/* 2218 */     if (nbt.func_74771_c("jrmcAlign") > 100) nbt.func_74774_a("jrmcAlign", (byte)100); 
/* 2219 */     if (nbt.func_74771_c("jrmcAlign") < 0) nbt.func_74774_a("jrmcAlign", (byte)0); 
/* 2220 */     if (nbt.func_74781_a("jrmcSSltX") == null) nbt.func_74778_a("jrmcSSltX", "pty"); 
/* 2221 */     if (nbt.func_74781_a("jrmcSSltY") == null) nbt.func_74778_a("jrmcSSltY", "pty"); 
/* 2222 */     if (nbt.func_74781_a("jrmcSSltZ") == null) nbt.func_74778_a("jrmcSSltZ", "pty"); 
/* 2223 */     if ((race == 1 || race == 2 || race == 4) && nbt.func_74779_i("jrmcSSltX").contains("pty"))
/* 2224 */       nbt.func_74778_a("jrmcSSltX", JRMCoreH.SklGveX(race, nbt.func_74771_c("jrmcClass"), nbt.func_74771_c("jrmcPwrtyp"))); 
/* 2225 */     if (nbt.func_74779_i("jrmcSSltY").contains("pty")) {
/* 2226 */       nbt.func_74778_a("jrmcSSltY", JRMCoreH.SklGveY(race, nbt.func_74771_c("jrmcClass"), nbt.func_74771_c("jrmcPwrtyp")));
/*      */     }
/* 2228 */     if (nbt.func_74781_a("jrmcSSlts") == null || nbt.func_74781_a(JRMCoreH.SkillsNbt[0]) != null) {
/*      */       
/* 2230 */       String sk = "";
/* 2231 */       mod_JRMCore.logger.info("The player " + player.func_70005_c_() + " has been converted to the new skill list!");
/* 2232 */       mod_JRMCore.logger.info("Old Skill list content"); byte b;
/* 2233 */       for (b = 0; b < JRMCoreH.SkillsNbt.length; b = (byte)(b + 1)) {
/*      */         
/* 2235 */         if (nbt.func_74781_a(JRMCoreH.SkillsNbt[b]) == null)
/*      */         {
/* 2237 */           nbt.func_74778_a(JRMCoreH.SkillsNbt[b], "pty");
/*      */         }
/* 2239 */         String skl = nbt.func_74779_i(JRMCoreH.SkillsNbt[b]);
/* 2240 */         if (!skl.equals("pty") && skl.length() > 2)
/*      */         {
/* 2242 */           mod_JRMCore.logger.info("Skill: " + JRMCoreH.SklName(skl, (powerType == 1) ? JRMCoreH.DBCSkillsIDs : JRMCoreH.NCSkillIDs, (powerType == 1) ? JRMCoreH.DBCSkillNames : JRMCoreH.NCSkillNames) + " lvl: " + (
/* 2243 */               Integer.parseInt(skl.substring(2)) + 1));
/*      */         }
/* 2245 */         sk = sk + skl + ",";
/*      */       } 
/*      */       
/* 2248 */       if (sk.length() == 0) {
/*      */         
/* 2250 */         nbt.func_74778_a("jrmcSSlts", ",");
/*      */       }
/*      */       else {
/*      */         
/* 2254 */         sk = JRMCoreH.cleanUpCommas(sk.replaceAll("pty", ""));
/* 2255 */         nbt.func_74778_a("jrmcSSlts", (sk.length() < 3) ? "," : sk);
/* 2256 */         for (b = 0; b < JRMCoreH.SkillsNbt.length; b = (byte)(b + 1)) {
/* 2257 */           nbt.func_82580_o(JRMCoreH.SkillsNbt[b]);
/*      */         }
/* 2259 */         mod_JRMCore.logger.info("New skill list: " + sk);
/* 2260 */         mod_JRMCore.logger.info("Converting ended in success!");
/*      */       } 
/*      */     } 
/*      */     
/* 2264 */     String k = nbt.func_74779_i("jrmcSSlts");
/*      */ 
/*      */     
/* 2267 */     String ts = ","; byte i;
/* 2268 */     for (i = 0; i < JRMCoreH.AttrbtNbtI.length; i = (byte)(i + 1))
/*      */     {
/* 2270 */       ts = ts + "," + T5yLLW(playerAttributes[i]);
/*      */     }
/* 2272 */     ts = ts.replaceAll(",,", "");
/*      */     
/* 2274 */     String t1 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[0]));
/* 2275 */     String t2 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[1]));
/* 2276 */     String t3 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[2]));
/* 2277 */     String t4 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[3]));
/*      */ 
/*      */     
/* 2280 */     String Techs5 = nbt.func_74779_i(JRMCoreH.techNbt[4]);
/* 2281 */     String Techs6 = nbt.func_74779_i(JRMCoreH.techNbt[5]);
/* 2282 */     String Techs7 = nbt.func_74779_i(JRMCoreH.techNbt[6]);
/* 2283 */     String Techs8 = nbt.func_74779_i(JRMCoreH.techNbt[7]);
/* 2284 */     String pm = Techs5 + "," + Techs6 + "," + Techs7 + "," + Techs8;
/*      */     
/* 2286 */     int dr = nbt.func_74762_e("jrmcDiffRed");
/* 2287 */     if (dr > 0) { nbt.func_74768_a("jrmcDiffRed", dr - 1); if (dr == 1) nbt.func_74774_a("jrmcDiff", (byte)0);  }
/* 2288 */      short htc = nbt.func_74765_d("jrmcHTCTmO");
/* 2289 */     if (htc > 0) nbt.func_74777_a("jrmcHTCTmO", (short)(htc - 1));
/*      */ 
/*      */     
/* 2292 */     String plyStn = nbt.func_74779_i("jrmcSettings");
/* 2293 */     if (plyStn.length() == 0 || !JRMCoreH.smnmlt(plyStn)) nbt.func_74778_a("jrmcSettings", plyStn = " "); 
/* 2294 */     if (statusEffects.length() == 0) nbt.func_74778_a("jrmcStatusEff", statusEffects = " ");
/*      */     
/* 2296 */     String Fzn = nbt.func_74779_i("jrmcFuzion");
/* 2297 */     if (Fzn.length() == 0 || Fzn.contains("."))
/*      */     {
/* 2299 */       nbt.func_74778_a("jrmcFuzion", Fzn = " ");
/*      */     }
/*      */     
/* 2302 */     if (nbt.func_74781_a("jrmcTpint") == null) {
/*      */       
/* 2304 */       int tp = nbt.func_74765_d("jrmcTp");
/* 2305 */       nbt.func_74768_a("jrmcTpint", tp);
/* 2306 */       nbt.func_74777_a("jrmcTp", (short)0);
/*      */     } 
/*      */     
/* 2309 */     if (nbt.func_74781_a("tpgbfokt") == null) {
/* 2310 */       int costTp = 0;
/* 2311 */       String[] s2 = t1.contains(";") ? t1.toString().split(";") : null;
/* 2312 */       if (s2 != null) { int cost = JRMCoreH.costEnAt(s2); costTp += 20 + cost / 2; }
/* 2313 */        s2 = t2.contains(";") ? t2.toString().split(";") : null;
/* 2314 */       if (s2 != null) { int cost = JRMCoreH.costEnAt(s2); costTp += 20 + cost / 2; }
/* 2315 */        s2 = t3.contains(";") ? t3.toString().split(";") : null;
/* 2316 */       if (s2 != null) { int cost = JRMCoreH.costEnAt(s2); costTp += 20 + cost / 2; }
/* 2317 */        s2 = t4.contains(";") ? t4.toString().split(";") : null;
/* 2318 */       if (s2 != null) { int cost = JRMCoreH.costEnAt(s2); costTp += 20 + cost / 2; }
/* 2319 */        int tp = nbt.func_74762_e("jrmcTpint") + costTp;
/* 2320 */       nbt.func_74768_a("jrmcTpint", tp);
/* 2321 */       nbt.func_74778_a(JRMCoreH.techNbt[0], " ");
/* 2322 */       nbt.func_74778_a(JRMCoreH.techNbt[1], " ");
/* 2323 */       nbt.func_74778_a(JRMCoreH.techNbt[2], " ");
/* 2324 */       nbt.func_74778_a(JRMCoreH.techNbt[3], " ");
/* 2325 */       t1 = nbt.func_74779_i(JRMCoreH.techNbt[0]);
/* 2326 */       t2 = nbt.func_74779_i(JRMCoreH.techNbt[1]);
/* 2327 */       t3 = nbt.func_74779_i(JRMCoreH.techNbt[2]);
/* 2328 */       t4 = nbt.func_74779_i(JRMCoreH.techNbt[3]);
/* 2329 */       nbt.func_74778_a("tpgbfokt", "done");
/*      */     } 
/*      */     
/* 2332 */     if (release == 0 && rage > 0) {
/*      */       
/* 2334 */       nbt.func_74774_a("jrmcSaiRg", (byte)0); rage = 0;
/*      */     } 
/*      */     
/* 2337 */     boolean nosao = (powerType != 3);
/* 2338 */     boolean issao = (powerType == 3);
/* 2339 */     float lastGravity = 1.0F;
/* 2340 */     float IWeight = 0.0F;
/*      */ 
/*      */     
/* 2343 */     ItemStack stackbody = null;
/* 2344 */     ItemStack stackhead = null;
/* 2345 */     ItemStack[] stack_vanities = new ItemStack[8];
/*      */ 
/*      */ 
/*      */     
/* 2349 */     boolean hasWatch = false;
/* 2350 */     int s4afg = 0;
/* 2351 */     if (this.dbc) {
/*      */       
/* 2353 */       int lastGravZoneTimer = JRMCoreH.getInt((EntityPlayer)player, "jrmcGravZoneLast");
/* 2354 */       lastGravity = JRMCoreH.getFloat((EntityPlayer)player, "jrmcGravForce");
/* 2355 */       int epoch = (int)(System.currentTimeMillis() / 1000L);
/* 2356 */       if (epoch > lastGravZoneTimer) {
/*      */         
/* 2358 */         lastGravity = 0.0F;
/* 2359 */         JRMCoreH.setFloat(0, (EntityPlayer)player, "jrmcGravForce");
/*      */       } 
/*      */       
/* 2362 */       lastGravity = JRMCoreHDBC.gravity((EntityPlayer)player, lastGravity);
/* 2363 */       IWeight = JRMCoreH.weightExtra(playerAttributes, lastGravity, (EntityPlayer)player);
/* 2364 */       stackbody = (ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70301_a(1);
/* 2365 */       stackhead = (ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70301_a(2);
/*      */       int m;
/* 2367 */       for (m = 0; m < 8; m++)
/*      */       {
/* 2369 */         stack_vanities[m] = (ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70301_a(3 + m);
/*      */       }
/*      */       
/* 2372 */       if (stackbody != null && stackbody.func_77958_k() - stackbody.func_77960_j() == 0)
/* 2373 */         (ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70299_a(1, null); 
/* 2374 */       if (stackhead != null && stackhead.func_77958_k() - stackhead.func_77960_j() == 0) {
/* 2375 */         (ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70299_a(2, null);
/*      */       }
/*      */       
/* 2378 */       for (m = 0; m < 8; m++) {
/*      */         
/* 2380 */         if (stack_vanities[m] != null && stack_vanities[m].func_77958_k() - stack_vanities[m].func_77960_j() == 0)
/*      */         {
/* 2382 */           (ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70299_a(3 + m, null);
/*      */         }
/*      */       } 
/*      */       
/* 2386 */       if (stackbody != null && !(stackbody.func_77973_b() instanceof ItemBodysuit)) stackbody = null; 
/* 2387 */       if (stackhead != null && !(stackhead.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemHeadwear)) stackhead = null;
/*      */       
/* 2389 */       for (m = 0; m < 8; m++) {
/*      */         
/* 2391 */         if (stack_vanities[m] != null && !(stack_vanities[m].func_77973_b() instanceof ItemVanity)) stack_vanities[m] = null;
/*      */       
/*      */       } 
/* 2394 */       s4afg = JRMCoreHDBC.DBCgetConfigDBGT() ? nbt.func_74762_e("jrmcAfGFtStFT") : 0;
/*      */     } 
/* 2396 */     if (this.jyc) hasWatch = player.field_71071_by.func_146028_b(JRMCoreHJYC.JYCgetItemWatch()); 
/* 2397 */     int kiWeaponID = 0;
/* 2398 */     if (this.dbc) kiWeaponID = JRMCoreH.PlyrSettings((EntityPlayer)player, 13);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2403 */     String w = this.dbc ? (JRMCoreH.ItemWeightOn((ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70301_a(0)) + "") : "-1,0";
/*      */     
/* 2405 */     if (nbt.func_74781_a("jrmcSsnoc") == null)
/*      */     {
/* 2407 */       nbt.func_74768_a("jrmcSsnoc", (int)(Math.random() * 1.6777215E7D));
/*      */     }
/*      */ 
/*      */     
/* 2411 */     String au = "";
/* 2412 */     String glid = nbt.func_74779_i("JRMCGLIDs");
/* 2413 */     String gidi = nbt.func_74779_i("JRMCGIDis");
/*      */ 
/*      */     
/* 2416 */     String stack_van = "";
/* 2417 */     for (int j = 0; j < 8; j++) {
/*      */       
/* 2419 */       if (this.dbc && stack_vanities[j] != null)
/* 2420 */       { stack_van = stack_van + Item.func_150891_b(stack_vanities[j].func_77973_b()) + "," + ((ItemVanity)stack_vanities[j].func_77973_b()).getColor(stack_vanities[j]) + ";"; }
/* 2421 */       else { stack_van = stack_van + "-1;"; }
/*      */     
/*      */     } 
/*      */     
/* 2425 */     names[playerID] = "" + player.func_70005_c_();
/* 2426 */     data0[playerID] = "" + ac + ";" + gp;
/* 2427 */     data1[playerID] = race + ";" + dns + ";" + nbt
/*      */       
/* 2429 */       .func_74771_c("jrmcPwrtyp") + ";" + nbt
/* 2430 */       .func_74771_c("jrmcClass") + ";" + nbt
/* 2431 */       .func_74771_c("jrmcAccept") + ";" + w + ";" + ((this.dbc && stackbody != null) ? (
/*      */       
/* 2433 */       Item.func_150891_b(stackbody.func_77973_b()) + "," + ((ItemBodysuit)stackbody.func_77973_b()).getColor(stackbody)) : (String)Integer.valueOf(-1)) + ";" + ((this.dbc && stackhead != null) ? 
/* 2434 */       Item.func_150891_b(stackhead.func_77973_b()) : -1) + ";" + stack_van + ((this.jyc && hasWatch) ? 1 : -1) + ";" + kiWeaponID + "; ";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2442 */     data3[playerID] = "" + nbt.func_74771_c("jrmcStnd");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2452 */     if (this.dbc || this.nc || this.sao) {
/*      */       
/* 2454 */       data2[playerID] = "" + nbt.func_74771_c("jrmcState") + ";" + nbt.func_74771_c("jrmcState2");
/* 2455 */       data4[playerID] = "" + rage + ";" + heat + ";" + ((ko > 0) ? 1 : 0);
/* 2456 */       data5[playerID] = "" + nbt.func_74771_c("jrmcAlign") + ";" + nbt.func_74762_e("jrmcAuraColor") + ";" + nbt.func_74762_e("jrmcSsnoc");
/* 2457 */       data6[playerID] = "" + k + ";" + nbt.func_74779_i("jrmcSSltX") + ";" + nbt.func_74779_i("jrmcSSltY") + ";" + nbt.func_74779_i("jrmcSSltZ") + ";" + pm;
/* 2458 */       if (nosao) data7[playerID] = "" + t1 + ";;" + t2 + ";;" + t3 + ";;" + t4; 
/* 2459 */       if (nosao) dat15[playerID] = ""; 
/* 2460 */       if (nosao) dat16[playerID] = "" + ((race == 4) ? (((au = nbt.func_74779_i("jrmcDNSAU")).length() > 6) ? au : " ") : " "); 
/* 2461 */       if (nosao) dat17[playerID] = ""; 
/* 2462 */       data8[playerID] = "" + nbt.func_74762_e("jrmcBdy");
/* 2463 */       data9[playerID] = "" + nbt.func_74762_e("jrmcEnrgy");
/* 2464 */       dat10[playerID] = "" + nbt.func_74771_c("jrmcRelease") + ";" + nbt.func_74762_e("jrmcStamina");
/* 2465 */       if (nosao) dat11[playerID] = "" + nbt.func_74762_e("jrmcTpint"); 
/* 2466 */       dat12[playerID] = "" + nbt.func_74771_c("jrmcExp");
/* 2467 */       dat13[playerID] = "" + alive + ";" + nbt.func_74779_i("jrmcSettings") + ";" + resrv + ";" + absorption;
/* 2468 */       dat14[playerID] = "" + ts;
/* 2469 */       dat18[playerID] = "" + nbt.func_74771_c("jrmcDiff") + ";" + nbt.func_74771_c("jrmcPtch") + ";" + Fzn;
/* 2470 */       dat19[playerID] = "" + nbt.func_74771_c("jrmcTlmd") + ";" + statusEffects;
/* 2471 */       if (nosao) dat20[playerID] = "" + nbt.func_74765_d("jrmcGTrnng") + ";" + nbt.func_74779_i("jrmcSettings") + ";" + lastGravity + ";" + IWeight + ";" + strn + ";" + strnAct + ";" + strng + ";" + s4afg + ";" + strnp + ";" + ko; 
/* 2472 */       if (nosao) dat21[playerID] = "" + nbt.func_74779_i("JRMCmissionSyncVers"); 
/* 2473 */       if (nosao) dat22[playerID] = "" + nbt.func_74779_i("JRMCmissionSync"); 
/* 2474 */       dat23[playerID] = "" + nbt.func_74762_e("JRMCGID");
/*      */       
/* 2476 */       if (nosao) dat24[playerID] = "" + ((glid.length() > 2) ? glid : " ") + ";" + ((gidi.length() > 2) ? gidi : " "); 
/* 2477 */       if (nosao) dat25[playerID] = "" + nbt.func_74779_i("JTCCBattleData"); 
/* 2478 */       if (issao) {
/*      */         
/* 2480 */         data7[playerID] = "" + nbt.func_74762_e("saocCol");
/* 2481 */         dat11[playerID] = "" + sao_lvl + ";" + nbt.func_74762_e("saocAp");
/* 2482 */         dat15[playerID] = "" + sao_exp;
/*      */       } 
/*      */     } 
/* 2485 */     if (this.jfc && FamilyCH.familyCNBT != null) {
/*      */       
/* 2487 */       String fid = JRMCoreH.getString((EntityPlayer)player, FamilyCH.FID);
/* 2488 */       String[] fida = fid.split(",");
/* 2489 */       String fn = fida[0];
/* 2490 */       String fnwp = "0";
/*      */       
/* 2492 */       String afm = "";
/* 2493 */       String mfd = JRMCoreH.getDataFromNBT(fn + ",0", FamilyCH.familyCNBT);
/* 2494 */       if (mfd.contains("!")) {
/* 2495 */         String[] mfD = mfd.split("!");
/* 2496 */         fnwp = mfD[0];
/* 2497 */         int mfDi = Integer.parseInt(mfD[2]);
/* 2498 */         for (int m = 0; m <= mfDi; m++) {
/* 2499 */           afm = afm + ";" + JRMCoreH.getDataFromNBT(fn + "," + m, FamilyCH.familyCNBT);
/*      */         }
/* 2501 */         afm = (afm.length() > 0) ? afm.substring(1) : afm;
/*      */       } else {
/* 2503 */         afm = "0";
/*      */       } 
/* 2505 */       afm = afm.replaceAll(":", "\\+");
/*      */       
/* 2507 */       String pr = nbt.func_74779_i(FamilyCH.prID);
/* 2508 */       String[] s = pr.split(";");
/* 2509 */       String prc = (s.length > 3) ? s[4] : s[0];
/* 2510 */       dat26[playerID] = fnwp;
/* 2511 */       dat27[playerID] = afm;
/* 2512 */       dat28[playerID] = ((fid.length() > 2) ? fid : (String)Integer.valueOf(0)) + ";" + nbt.func_74779_i(FamilyCH.FIDi) + ";" + nbt.func_74779_i(FamilyCH.FIDa);
/* 2513 */       dat29[playerID] = pr;
/* 2514 */       dat30[playerID] = prc;
/*      */     } 
/*      */     
/* 2517 */     if (JRMCoreConfig.JRMCABonusOn) {
/*      */       
/* 2519 */       String jrmcabonus = "";
/* 2520 */       String resultBonus = "";
/*      */       
/* 2522 */       for (int m = 0; m < (JRMCoreH.attrInit[1]).length; m++) {
/*      */         
/* 2524 */         String attributeTag = nbt.func_74779_i("jrmcAttrBonus" + ComJrmcaBonus.ATTRIBUTES_SHORT[m]);
/* 2525 */         if (attributeTag.length() == 0) attributeTag = "n"; 
/* 2526 */         jrmcabonus = jrmcabonus + attributeTag + "=";
/* 2527 */         resultBonus = resultBonus + attributeTag + "=";
/*      */       } 
/*      */       
/* 2530 */       if (jrmcabonus.contains("nbt_") || jrmcabonus.contains("NBT_")) {
/*      */         
/* 2532 */         String[] attributes = jrmcabonus.split("\\=");
/* 2533 */         for (int n = 0; n < (JRMCoreH.attrInit[1]).length; n++) {
/*      */           
/* 2535 */           boolean containedNBT = false;
/* 2536 */           String[] bonus = attributes[n].split("\\|");
/* 2537 */           String[][] bonusValues = new String[bonus.length][2];
/* 2538 */           if (attributes[n].contains("nbt_") || attributes[n].contains("NBT_"))
/*      */           {
/* 2540 */             if (bonus.length > 0 && bonus[0].length() > 0)
/*      */             {
/* 2542 */               for (int i1 = 0; i1 < bonus.length; i1++) {
/*      */                 
/* 2544 */                 String[] bonusValue = bonus[i1].split("\\;");
/* 2545 */                 bonusValues[i1][0] = bonusValue[0];
/* 2546 */                 bonusValues[i1][1] = bonusValue[1];
/* 2547 */                 if (bonusValues[i1][1].contains("nbt_") || bonusValues[i1][1].contains("NBT_")) {
/*      */                   
/* 2549 */                   containedNBT = true;
/* 2550 */                   String method = bonusValues[i1][1].substring(0, 1);
/*      */                   
/*      */                   try {
/* 2553 */                     String value = bonusValues[i1][1].substring("nbt_".length() + 1);
/* 2554 */                     double resultValue = nbt.func_74769_h(value);
/* 2555 */                     bonus[i1] = bonusValues[i1][0] + ";" + method + resultValue;
/*      */                   }
/* 2557 */                   catch (Exception exception) {}
/*      */                 } 
/*      */               } 
/*      */             }
/*      */           }
/*      */           
/* 2563 */           if (containedNBT) {
/*      */             
/* 2565 */             attributes[n] = ""; int i1;
/* 2566 */             for (i1 = 0; i1 < bonus.length; i1++)
/*      */             {
/* 2568 */               attributes[n] = attributes[n] + bonus[i1] + ((i1 == bonus.length - 1) ? "" : "|");
/*      */             }
/* 2570 */             resultBonus = "";
/* 2571 */             for (i1 = 0; i1 < attributes.length; i1++) {
/*      */               
/* 2573 */               if (attributes[i1].length() == 0) attributes[i1] = "null"; 
/* 2574 */               resultBonus = resultBonus + attributes[i1] + "=";
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 2579 */       dat31[playerID] = resultBonus;
/*      */     } 
/*      */     
/* 2582 */     if (this.dbc && JGConfigDBCFormMastery.FM_Enabled) {
/* 2583 */       String mastery = JRMCoreH.getFormMasteryData((EntityPlayer)player, "0.00");
/* 2584 */       dat32[playerID] = mastery;
/*      */     } 
/*      */     
/* 2587 */     this.genInt++;
/* 2588 */     if (this.genInt >= 120) { this.genInt = 0;
/* 2589 */       if (JRMCoreH.DBC()) JRMCoreHDBC.DBCCommonTickHandlerNPCSpawnCheck(player); 
/* 2590 */       if (JRMCoreH.NC()) JRMCoreHNC.NCCommonTickHandlerNPCSpawnCheck(player);  }
/*      */   
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreComTickH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */