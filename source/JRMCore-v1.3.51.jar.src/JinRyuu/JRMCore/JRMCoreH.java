/*      */ package JinRyuu.JRMCore;
/*      */ import JinRyuu.DragonBC.common.DBCClientTickHandler;
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.DragonBC.common.DBCH;
/*      */ import JinRyuu.DragonBC.common.Worlds.WorldGeneratorDB;
/*      */ import JinRyuu.JRMCore.entity.ExplosionJRMC;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.items.ItemHeadwear;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPduo;
/*      */ import JinRyuu.JRMCore.p.JRMCorePChar;
/*      */ import JinRyuu.JRMCore.p.JRMCorePCost;
/*      */ import JinRyuu.JRMCore.p.JRMCorePData;
/*      */ import JinRyuu.JRMCore.p.JRMCorePExpl;
/*      */ import JinRyuu.JRMCore.p.JRMCorePQuad;
/*      */ import JinRyuu.JRMCore.p.JRMCorePRls;
/*      */ import JinRyuu.JRMCore.p.JRMCorePStats2;
/*      */ import JinRyuu.JRMCore.p.JRMCorePStats3;
/*      */ import JinRyuu.JRMCore.p.JRMCorePStats3b;
/*      */ import JinRyuu.JRMCore.p.JRMCorePTech;
/*      */ import JinRyuu.JRMCore.p.JRMCorePTick;
/*      */ import JinRyuu.JRMCore.p.JRMCorePTri;
/*      */ import JinRyuu.JRMCore.p.JRMCorePUpgrade;
/*      */ import JinRyuu.JRMCore.p.PD;
/*      */ import JinRyuu.JRMCore.server.JGMathHelper;
/*      */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*      */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
/*      */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
/*      */ import JinRyuu.JRMCore.server.config.core.JGConfigSkills;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCAAiDifficulty;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import JinRyuu.NarutoC.common.NCCommonTickHandler;
/*      */ import JinRyuu.NarutoC.common.Worlds.WorldGeneratorNC;
/*      */ import com.google.common.base.Joiner;
/*      */ import com.google.common.base.Splitter;
/*      */ import com.google.gson.Gson;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.common.Loader;
/*      */ import cpw.mods.fml.common.ModContainer;
/*      */ import cpw.mods.fml.common.network.ByteBufUtils;
/*      */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import io.netty.buffer.ByteBuf;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStreamReader;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.net.URL;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.DecimalFormatSymbols;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.TreeMap;
/*      */ import java.util.regex.Matcher;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.CompressedStreamTools;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChatComponentTranslation;
/*      */ import net.minecraft.util.ChatStyle;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.EnumChatFormatting;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class JRMCoreH {
/*      */   public static final byte RACE_HUMAN = 0;
/*      */   public static final byte RACE_SAIYAN = 1;
/*      */   public static final byte RACE_HALF_SAIYAN = 2;
/*      */   public static final byte RACE_NAMEKIAN = 3;
/*      */   public static final byte RACE_ARCOSIAN = 4;
/*      */   public static final byte RACE_MAJIN = 5;
/*      */   public static final byte RACE_BASE_HUMAN = 0;
/*      */   public static final byte RACE_BASE_SAIYAN = 0;
/*      */   public static final byte RACE_BASE_HALF_SAIYAN = 0;
/*      */   public static final byte RACE_BASE_NAMEKIAN = 0;
/*      */   public static final byte RACE_BASE_ARCOSIAN = 4;
/*      */   public static final byte RACE_BASE_MAJIN = 0;
/*  102 */   public static String tjnc = "jinryuunarutoc";
/*  103 */   public static String tjdbc = "jinryuudragonblockc";
/*  104 */   public static String tjdbcAssts = "jinryuudragonbc";
/*  105 */   public static String tjyc = "jinryuuyearsc";
/*  106 */   public static String tjycAssts = "jinryuujyearsc";
/*  107 */   public static String tjfc = "jinryuufamilyc";
/*  108 */   public static String tjrmc = "jinryuujrmcore";
/*  109 */   public static String tjsaoc = "jinryuusaoc";
/*  110 */   public static String tjjrmc = "jinryuumodscore";
/*  111 */   public static String tjbc = "jinryuubleachc";
/*      */   
/*  113 */   public static HashMap<String, Integer> osbic = new HashMap<String, Integer>();
/*  114 */   public static int pg = 0;
/*  115 */   public static String[] p = null;
/*  116 */   public static Entity targ = null;
/*  117 */   public static Entity targNPC = null;
/*  118 */   public static String ask = null;
/*      */   
/*      */   public static final String RACE_NAME_HUMAN = "Human";
/*      */   
/*      */   public static final String RACE_NAME_SAIYAN = "Saiyan";
/*      */   public static final String RACE_NAME_HALF_SAIYAN = "Half-Saiyan";
/*      */   public static final String RACE_NAME_NAMEKIAN = "Namekian";
/*      */   public static final String RACE_NAME_ARCOSIAN = "Arcosian";
/*      */   public static final String RACE_NAME_MAJIN = "Majin";
/*  127 */   public static final String[] Races = new String[] { "Human", "Saiyan", "Half-Saiyan", "Namekian", "Arcosian", "Majin" };
/*  128 */   public static final int RACES = Races.length;
/*  129 */   public static final String[] RaceAllow = new String[] { "All", "DBC", "DBC", "DBC", "DBC", "DBC", "HHC", "HHC", "HHC", "HHC", "HHC", "HHC", "HHC", "HHC" };
/*  130 */   public static final String[] RaceCanHaveHair = new String[] { "H", "H", "H", "A", "R", "H", "H", "H", "H", "H", "H", "H", "H", "H" };
/*  131 */   public static final String[] RaceCanHavePwr = new String[] { "0123", "012", "012", "012", "012", "012", "012", "012", "012", "012", "012", "012", "012", "012" };
/*  132 */   public static final int[] RaceCustomSkin = new int[] { 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2 };
/*  133 */   public static final int[] RaceHairColor = new int[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
/*  134 */   public static final int[] RaceGenders = new int[] { 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
/*      */   
/*  136 */   public static final int[] Specials = new int[] { 1, 4, 4, 3, 3, 5, 5, 4, 1, 3, 4, 4, 3, 1 };
/*      */   public static final String race = "Race";
/*      */   public static final String gender = "Gender";
/*      */   public static final String hair = "Hair";
/*  140 */   public static final String[] skinTyps = new String[] { "DefaultSkin", "CustomSkin" };
/*      */   
/*      */   public static final String bodytype = "BodyType";
/*  143 */   public static final int[][][] defbodycols = new int[][][] { { { 16297621, 6498048 }, { 16297621, 6498048 }, { 16297621, 6498048 }, { 5095183, 13796998, 12854822 }, { 15460342, 16111595, 8533141, 16550015 }, { 16757199, 15766205 } }, { { 15979704, 6498048 }, { 15979704, 6498048 }, { 15979704, 6498048 }, { 4566029, 14191242, 14363435 }, { 15460342, 15188457, 287340, 16550015 }, { 16752073, 16028862 } }, { { 13014656, 6498048 }, { 13014656, 6498048 }, { 13014656, 6498048 }, { 4896782, 12875121, 12920870 }, { 15460342, 10442657, 3625381, 13125463 }, { 16483508, 15825582 } }, { { 12622942, 6498048 }, { 12622942, 6498048 }, { 12622942, 6498048 }, { 0 }, { 0 }, { 14383492, 13987449 } }, { { 10112303, 6498048 }, { 10112303, 6498048 }, { 10112303, 6498048 }, { 0 }, { 0 }, { 11433702, 10776284 } }, { { 7225375, 6498048 }, { 7225375, 6498048 }, { 7225375, 6498048 }, { 0 }, { 0 }, { 7907292, 7578067 } }, { { 3677711, 6498048 }, { 3677711, 6498048 }, { 3677711, 6498048 }, { 0 }, { 0 }, { 7916929, 7652472 } } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  152 */   public static final int[][] defeyecols = new int[][] { { 1, 1, 1, 1, 14617612, 14551628 }, { 4896782, 1, 4896782, 4896782, 1, 8235495 }, { 14617612, 1, 14617612, 14617612, 4896782, 16777215 } };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  157 */   public static final int[][] customSknLimits = new int[][] { { 1, 1, 5, 5, 6, 2 }, { 1, 1, 5, 5, 6, 0 }, { 1, 2, 5, 5, 6, 2 }, { 3, 3, 5, 5, 3, 2 }, { 3, 4, 5, 6, 2, 2 }, { 1, 1, 5, 5, 6, 2 } };
/*  158 */   public static final int[] customSknLimitsBCP = new int[] { 7, 7, 7, 3, 3, 7 };
/*      */   
/*      */   public static final int hairLengthG2 = 786;
/*      */   
/*      */   public static final int hairLengthG1 = 392;
/*  163 */   public static final String[] defHairPrsts = new String[] { "345050555050801250505550501901505055505080235050455050803450505550508001505055505080015050555050802350505550508034505055505080125050555050800150505550508023505055505080015050555050800150505550506712505045505080015050455050800150504550508023505045505080345050455050801250504550508001505045505080235050455050800150504550508001505045505061015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050800155505050508001555050505080015550505050630155505050506701555050505061015550505050671170505050503814705050505041147050505050411770505050503817705050505041207050505050412070505050504117705050505041227050505050412570505050504125705050505041207050505050412070505050503225705050505041257050505050412270505050503420", "18080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080180808018080804808080180808018080801808080180808018080804808080180808018080801808080180808018080801808080180808018080801808080180808028080801808080180808018080801808080180808018080801808080180808018080801808080180808018080801808080", "33843554384754461805224154501455050143505014550501435050143505014350501435050050505505050550505055145505014350501455050145505014550501455050145505005050450505045050504515050501505050150505015050501475049147504914750501475050152505015250501525050152505005550501475050147505005550503631847363184726318522631850267194727218502701850270185027019501701850270185027018501505050150505015050501505050", "08080180181919019191901819190505055050505505050550505055050505505050550505055050505505050550505055050504505050450505045050504505050450505045050504505050450505045050504505550504785050478505005550500555050474505047450500555050055505047150504715050055505005550500555050055505005550500325050425505042550500345050030505042350504235050038505003450504215050421505003450500695050419505041950500285050", "225067556150391150675561502311503245615023205032456150361750505450507117505054505071175050545050711750505450507101505054505071025050545050710150505450507100505054505071005050545050710050505450507122505045505071225050455050722250504550507222505045505072015050455050720150504550507201505045505072005050455050720050504550507200505045505072225445505050712254475050507122545250505071225454505050710154455050507101544950505071015450505050710154545050507100545050505071005450505050710054505050507100545050505071005450505050710054505050507100545050505071005450505050712850505650507465505074801930655050251819303750504550507437505056505074685050748018326850502519183234505045505074345050565050746850507480183868505025181838345050455050743450505650507480505074801843805050251819433450504550507420", "025050545050210250505450501801505045505021025050475050180147507467503248505072675043255250726750360150505667501922475071675038255050716750380152507167503202475071675032025250716750300050507167503000505047655036205250276550362250502765503620475027655036225250306550363150503065503622475030655034015250276550250147502765503000505027655036175050505050803150505050508028505050505080225050505050801750505050508022505050505080255050505050801750505050508000505050505080005050505050800050505050508000505050505080005050505050800050505050508000505050505080005050505050803154508067504931545080615028285450766150472854506561506551525080675038655250806150786052507861503451525069615050625050806950528250508061503485505078615030625050696150585149508069506157495080615080624950786150805149506961504920" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String facenose = "Nose";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String facemouth = "Mouth";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String eyes = "Eyes";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String color = "Color";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String tail = "Tail";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String pwrtyp = "PowerType";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  210 */   public static final String[] Genders = new String[] { "Male", "Female" };
/*  211 */   public static final String[] GenderAllow = new String[] { "JRFC", "JRFC" };
/*  212 */   public static final String[] Years = new String[] { "Child", "Teen", "YoungAdult", "Adult", "MiddleAged", "Senior" };
/*  213 */   public static final int[] YearsD = new int[] { 0, 25, 40, 52 };
/*  214 */   public static final String[] Hairs = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "00" };
/*  215 */   public static final String[] HairsT = new String[] { "A", "B", "B", "C", "B", "C", "D", "B", "B", "A", "B", "A", "C", "C", "E", "C" };
/*  216 */   public static final String[] Hairs2 = new String[] { "01", "02", "03", "04", "05" };
/*  217 */   public static final String[] Hairs2T = new String[] { "A", "B", "B", "C", "B", "C", "D" };
/*  218 */   public static final String[] StateNames = new String[] { "Normal", "Super", "Super", "Super" };
/*  219 */   public static final String[] DifficultyNames = new String[] { "Normal", "Hard", "Insane" };
/*  220 */   public static final String[] DifficultySNmes = new String[] { "N", "H", "I" };
/*  221 */   public static final String[] DifficultyDesc = new String[] { "NormalDesc", "HardDesc", "InsaneDesc" };
/*      */ 
/*      */   
/*      */   public static final String KaioDiffRed = "KaioDiffRed";
/*      */   
/*  226 */   public static final String[] Pwrtyps = new String[] { "Natural", "Ki", "Chakra", "SwordArt" };
/*  227 */   public static final String[] PwrtypAllow = new String[] { "All", "DBC", "NC", "SAOC" };
/*  228 */   public static final String[] PwrtypDesc = new String[] { "NaturalDesc", "KiDesc", "ChakraDesc", "SwordartDesc" };
/*  229 */   public static final String[] Classes = new String[] { "Survival" };
/*  230 */   public static final String[] ClassesDesc = new String[] { "SurvivalDesc" };
/*  231 */   public static final String[] ClassesDBC = new String[] { "MartialArtist", "Spiritualist", "Warrior" };
/*  232 */   public static final String[] ClassesDBCDesc = new String[] { "MartialArtistDesc", "SpiritualistDesc", "WarriorDesc" };
/*  233 */   public static final String[] Clans = new String[] { "Clanless", "Hyuuga", "Uchiha" };
/*  234 */   public static final String[] ClansDesc = new String[] { "ClanlessDesc", "HyuugaDesc", "UchihaDesc" };
/*  235 */   public static final String[] ClassNames = new String[] { "Class", "Class", "Clan", "None" };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int BPMode;
/*      */ 
/*      */ 
/*      */   
/*  244 */   public static int kiAmount = 0;
/*  245 */   public static double kiMultip = 0.0D;
/*      */   
/*  247 */   public static int dbcHealthCur = 0;
/*  248 */   public static String[] dbcBP = null;
/*  249 */   public static int jrmcExp = 0;
/*  250 */   public static int dbcEvilness = 0;
/*  251 */   public static int dbcHealth = 0;
/*  252 */   public static int dbcTrainPoint = 0;
/*  253 */   public static int kiMax = 0;
/*  254 */   public static int kiChargRa = 0;
/*  255 */   public static int kiDash = 0;
/*  256 */   public static int kiPunch = 0;
/*  257 */   public static int kiJump = 0;
/*  258 */   public static int kiFly = 0;
/*  259 */   public static int kiAsclvl = 0;
/*  260 */   public static int kiAscPow = 0;
/*      */   
/*  262 */   public static int DSpeed = 0;
/*      */   
/*  264 */   public static int minKi = 1;
/*      */   
/*  266 */   public static String SEvil = "e.dbc";
/*  267 */   public static String SHealth = "h.dbc";
/*  268 */   public static String STrainPoint = "t.dbc";
/*  269 */   public static String SkiMax = "m.dbc";
/*  270 */   public static String SkiChargRa = "r.dbc";
/*  271 */   public static String SkiDash = "d.dbc";
/*  272 */   public static String SkiPunch = "p.dbc";
/*  273 */   public static String SkiJump = "j.dbc";
/*  274 */   public static String SkiFly = "f.dbc";
/*  275 */   public static String SkiAsclvl = "l.dbc";
/*  276 */   public static String SkiAscPow = "a.dbc";
/*      */   
/*  278 */   public static int kiKaioKen = 0, kiInSuper = 0;
/*      */   
/*  280 */   public static int KABigBang = 0, KABlast = 0, KABurningAtt = 0, KADeathBeam = 0, KADodon = 0, KAEnergyDisk = 0, KAFinalFlash = 0;
/*  281 */   public static int KAFingerLaser = 0, KAGalicGun = 0, KAKameHame = 0, KAKameHame10x = 0, KAMakanko = 0, KAMasenko = 0, KAPlanetDest = 0;
/*  282 */   public static int KASpiritBomb = 0, KTKaioken = 0;
/*      */   
/*  284 */   public static int KASelected = 0, KACharge = 0, KAFired = 0, KAFireStop = 0;
/*      */   
/*  286 */   public static int Senzu = 0;
/*      */   
/*      */   public static boolean driF = false, driB = false, driU = false, driD = false;
/*      */   
/*      */   public static boolean dbchalo = false;
/*      */   public static String[] dbcpd;
/*      */   public static String[] dbcSuperOn;
/*  293 */   public static String[] dbcLieDown = new String[] { "dbcLie", "dbcStand" };
/*      */ 
/*      */   
/*  296 */   public static String Har = "_A01";
/*  297 */   public static String Col = "_C0"; public static double forw; public static final String MOB_NBT_SPAWNINITIATED_CHP = "jrmcSpawnInitiatedCHP";
/*      */   public static final String MOB_NBT_SPAWNINITIATED_CAT = "jrmcSpawnInitiatedCAT";
/*      */   public static final String MOB_NBT_SPAWNINITIATED_CMT = "jrmcSpawnInitiatedCMT";
/*      */   public static final String MOB_NBT_SPAWNINITIATED_IMP = "jrmcSpawnInitiatedIMP";
/*      */   
/*      */   public static boolean DGE(Entity e) {
/*  303 */     return (DBC() && !(e instanceof JinRyuu.DragonBC.common.Npcs.EntityDBCKami) && !(e instanceof JinRyuu.DragonBC.common.Render.SpacePod01Entity) && !(e instanceof JinRyuu.DragonBC.common.Render.KintounEntity) && !(e instanceof JinRyuu.DragonBC.common.Npcs.EntityDragon) && !(e instanceof JinRyuu.DragonBC.common.Npcs.EntityPorunga));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int PlyrState2(EntityPlayer p) {
/*  311 */     int on = 0;
/*  312 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  313 */     if (side == Side.CLIENT && 
/*  314 */       plyrs != null && plyrs.length > 0 && dnn(2)) {
/*  315 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*  316 */         if (plyrs[pl].equals(p.func_70005_c_())) {
/*  317 */           String[] s2 = data2[pl].split(";");
/*  318 */           on = Integer.parseInt(s2[1]);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  324 */     if (side == Side.SERVER) {
/*  325 */       on = getByte(p, "jrmcState2");
/*      */     }
/*  327 */     return on;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte PlyrPwr(EntityPlayer p) {
/*  335 */     byte on = 0;
/*  336 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  337 */     if (side == Side.CLIENT)
/*      */     {
/*  339 */       if (plyrs != null && plyrs.length > 0 && dnn(1))
/*      */       {
/*  341 */         for (int pl = 0; pl < plyrs.length; pl++) {
/*      */           
/*  343 */           if (plyrs[pl].equals(p.func_70005_c_())) {
/*      */             
/*  345 */             String[] s = data1[pl].split(";");
/*  346 */             on = Byte.parseByte(s[2]);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*      */     }
/*  352 */     if (side == Side.SERVER) {
/*  353 */       NBTTagCompound aPlayer = nbt((Entity)p, "pres");
/*  354 */       on = aPlayer.func_74771_c("jrmcPwrtyp");
/*      */     } 
/*  356 */     return on;
/*      */   }
/*      */   public static byte clsTypOn(EntityPlayer par1EntityPlayer) {
/*  359 */     byte on = 0;
/*  360 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  361 */     if (side == Side.CLIENT && 
/*  362 */       plyrs != null && plyrs.length > 0 && dnn(1)) {
/*  363 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*  364 */         if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
/*  365 */           String[] s = data1[pl].split(";");
/*  366 */           on = Byte.parseByte(s[3]);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  372 */     if (side == Side.SERVER) {
/*  373 */       NBTTagCompound aPlayer = nbt((Entity)par1EntityPlayer, "pres");
/*  374 */       on = aPlayer.func_74771_c("jrmcClass");
/*      */     } 
/*  376 */     return on;
/*      */   }
/*      */   
/*      */   public static boolean HairExists(EntityPlayer par1EntityPlayer) {
/*  380 */     boolean on = false;
/*  381 */     on = armTypSaiyansOn(par1EntityPlayer);
/*  382 */     return on;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean saiyanBlood(String[] s) {
/*  387 */     return (s[4].contains("1") && userKi(s) && (s[0].contains("1") || s[0].contains("2")));
/*      */   }
/*  389 */   public static boolean userNatur(String[] s) { return s[2].contains("0"); }
/*  390 */   public static boolean userKi(String[] s) { return s[2].contains("1"); }
/*  391 */   public static boolean userChakra(String[] s) { return s[2].contains("2"); }
/*  392 */   public static boolean userSwordArt(String[] s) { return s[2].contains("3"); } public static boolean state(String s, int i) {
/*  393 */     return s.contains("" + i);
/*      */   }
/*      */   
/*      */   public static boolean saiyanBlood(NBTTagCompound nbt) {
/*  397 */     return (nbt.func_74771_c("jrmcAccept") == 1 && kiUser(nbt) && rc_sai(nbt.func_74771_c("jrmcRace")));
/*  398 */   } public static boolean NaturUser(NBTTagCompound nbt) { return (nbt.func_74771_c("jrmcPwrtyp") == 0); }
/*  399 */   public static boolean kiUser(NBTTagCompound nbt) { return (nbt.func_74771_c("jrmcPwrtyp") == 1); }
/*  400 */   public static boolean chakraUser(NBTTagCompound nbt) { return (nbt.func_74771_c("jrmcPwrtyp") == 2); } public static boolean state(NBTTagCompound nbt, int i) {
/*  401 */     return (nbt.func_74771_c("jrmcState") == (byte)i);
/*      */   }
/*      */   
/*      */   public static boolean isRaceSaiyan() {
/*  405 */     return (Race == 1 || Race == 2);
/*      */   } public static boolean isRaceNamekian() {
/*  407 */     return (Race == 3);
/*      */   } public static boolean isRaceHuman() {
/*  409 */     return (Race == 0);
/*      */   } public static boolean isRaceHumanOrNamekian() {
/*  411 */     return (isRaceHuman() || isRaceNamekian());
/*      */   } public static boolean isRaceArcosian() {
/*  413 */     return (Race == 4);
/*      */   } public static boolean isRaceMajin() {
/*  415 */     return (Race == 5);
/*      */   }
/*  417 */   public static boolean isRaceHalfSaiyan(int r) { return (r == 2); }
/*  418 */   public static boolean isRaceFullSaiyan(int r) { return (r == 1); }
/*  419 */   public static boolean isRaceSaiyan(int r) { return (r == 1 || r == 2); }
/*  420 */   public static boolean isRaceNamekian(int r) { return (r == 3); }
/*  421 */   public static boolean isRaceHuman(int r) { return (r == 0); }
/*  422 */   public static boolean isRaceHumanOrNamekian(int r) { return (isRaceHuman(r) || isRaceNamekian(r)); }
/*  423 */   public static boolean isRaceArcosian(int r) { return (r == 4); } public static boolean isRaceMajin(int r) {
/*  424 */     return (r == 5);
/*      */   }
/*  426 */   public static boolean rc_sai(int r) { return isRaceSaiyan(r); }
/*  427 */   public static boolean rc_humNam(int r) { return isRaceHumanOrNamekian(r); }
/*  428 */   public static boolean rc_hum(int r) { return isRaceHuman(r); }
/*  429 */   public static boolean rc_nam(int r) { return isRaceNamekian(r); }
/*  430 */   public static boolean rc_arc(int r) { return isRaceArcosian(r); } public static boolean rc_maj(int r) {
/*  431 */     return isRaceMajin(r);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isInState(int state) {
/*  437 */     return (State == (byte)state);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isInState(int currentState, int state) {
/*  442 */     return (currentState == state);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getBaseForm(int race) {
/*  447 */     return rc_arc(race) ? 4 : 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isInBaseForm(int race, int state) {
/*  452 */     return (state == getBaseForm(race));
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
/*      */   public static boolean rc_bs(int r, int s) {
/*  464 */     return isInBaseForm(r, s);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean rc_sai() {
/*  469 */     return (Race == 1 || Race == 2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean rc_humNam() {
/*  474 */     return (Race == 0 || Race == 3);
/*      */   }
/*      */   public static boolean rc_hum() {
/*  477 */     return (Race == 0);
/*      */   } public static boolean rc_nam() {
/*  479 */     return (Race == 3);
/*      */   } public static boolean rc_arc() {
/*  481 */     return (Race == 4);
/*      */   }
/*      */   
/*      */   public static boolean rc_bs() {
/*  485 */     return (State == (rc_arc() ? 4 : 0));
/*      */   }
/*      */   public static boolean race_match(int race, int race2) {
/*  488 */     return ((isRaceSaiyan(race) && isRaceSaiyan(race2)) || (
/*  489 */       isRaceHuman(race) && isRaceHuman(race2)) || (
/*  490 */       isRaceArcosian(race) && isRaceArcosian(race2)) || (
/*  491 */       isRaceNamekian(race) && isRaceNamekian(race2)) || (
/*  492 */       isRaceMajin(race) && isRaceMajin(race2)));
/*      */   }
/*      */   
/*      */   public static boolean isPowerTypeKi(int powerType) {
/*  496 */     return (powerType == 1);
/*  497 */   } public static boolean isPowerTypeChakra(int powerType) { return (powerType == 2); } public static boolean isPowerTypeSAO(int powerType) {
/*  498 */     return (powerType == 3);
/*      */   } public static boolean isPowerTypeKi() {
/*  500 */     return (Pwrtyp == 1);
/*      */   } public static boolean isPowerTypeChakra() {
/*  502 */     return (Pwrtyp == 2);
/*      */   } public static boolean isPowerTypeSAO() {
/*  504 */     return (Pwrtyp == 3);
/*      */   }
/*  506 */   public static boolean pwr_ki(int powerType) { return isPowerTypeKi(powerType); }
/*  507 */   public static boolean pwr_cha(int powerType) { return isPowerTypeChakra(powerType); } public static boolean pwr_sa(int powerType) {
/*  508 */     return isPowerTypeSAO(powerType);
/*      */   } public static boolean pwr_ki() {
/*  510 */     return isPowerTypeKi();
/*      */   } public static boolean pwr_cha() {
/*  512 */     return isPowerTypeChakra();
/*      */   } public static boolean pwr_sa() {
/*  514 */     return isPowerTypeSAO();
/*      */   }
/*      */   
/*      */   public static boolean armTypSaiyansOn(EntityPlayer par1EntityPlayer) {
/*  518 */     boolean on = false;
/*  519 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  520 */     if (side == Side.CLIENT && 
/*  521 */       plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
/*  522 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*  523 */         if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
/*  524 */           String[] s = data1[pl].split(";");
/*  525 */           String[] s2 = data2[pl].split(";");
/*  526 */           if (saiyanBlood(s)) { if (state(s2[0], 0)) kiInSuper = 0;  on = true; }
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  532 */     if (side == Side.SERVER) {
/*  533 */       NBTTagCompound aPlayer = nbt((Entity)par1EntityPlayer, "pres");
/*  534 */       on = saiyanBlood(aPlayer);
/*      */     } 
/*  536 */     return on;
/*      */   }
/*      */   public static boolean armTypNormOn(EntityPlayer par1EntityPlayer) {
/*  539 */     boolean on = false;
/*  540 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  541 */     if (side == Side.CLIENT && 
/*  542 */       plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
/*  543 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*  544 */         if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
/*  545 */           String[] s = data1[pl].split(";");
/*  546 */           String[] s2 = data2[pl].split(";");
/*  547 */           if (saiyanBlood(s) && state(s2[0], 0)) { kiInSuper = 0; on = true; }
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  553 */     if (side == Side.SERVER) {
/*  554 */       NBTTagCompound aPlayer = nbt((Entity)par1EntityPlayer, "pres");
/*  555 */       on = (saiyanBlood(aPlayer) && state(aPlayer, 0));
/*      */     } 
/*  557 */     return on;
/*      */   }
/*      */   public static boolean armTypSuperOn(EntityPlayer par1EntityPlayer) {
/*  560 */     boolean on = false;
/*  561 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  562 */     if (side == Side.CLIENT && 
/*  563 */       plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
/*  564 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*  565 */         if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
/*  566 */           String[] s = data1[pl].split(";");
/*  567 */           String[] s2 = data2[pl].split(";");
/*  568 */           if (saiyanBlood(s) && !state(s2[0], 0)) { kiInSuper = 0; on = true; }
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  574 */     if (side == Side.SERVER) {
/*  575 */       NBTTagCompound aPlayer = nbt((Entity)par1EntityPlayer, "pres");
/*  576 */       on = (saiyanBlood(aPlayer) && !state(aPlayer, 0));
/*      */     } 
/*  578 */     return on;
/*      */   }
/*      */   public static boolean armTypSS1On(EntityPlayer par1EntityPlayer) {
/*  581 */     boolean on = false;
/*  582 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  583 */     if (side == Side.CLIENT && 
/*  584 */       plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
/*  585 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*  586 */         if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
/*  587 */           String[] s = data1[pl].split(";");
/*  588 */           String[] s2 = data2[pl].split(";");
/*  589 */           if (saiyanBlood(s) && state(s2[0], 1)) on = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  595 */     if (side == Side.SERVER) {
/*  596 */       NBTTagCompound aPlayer = nbt((Entity)par1EntityPlayer, "pres");
/*  597 */       on = (saiyanBlood(aPlayer) && state(aPlayer, 1));
/*      */     } 
/*  599 */     return on;
/*      */   }
/*      */   public static boolean armTypSS2On(EntityPlayer par1EntityPlayer) {
/*  602 */     boolean on = false;
/*  603 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  604 */     if (side == Side.CLIENT && 
/*  605 */       plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
/*  606 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*  607 */         if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
/*  608 */           String[] s = data1[pl].split(";");
/*  609 */           String[] s2 = data2[pl].split(";");
/*  610 */           if (saiyanBlood(s) && state(s2[0], 2)) on = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  616 */     if (side == Side.SERVER) {
/*  617 */       NBTTagCompound aPlayer = nbt((Entity)par1EntityPlayer, "pres");
/*  618 */       on = (saiyanBlood(aPlayer) && state(aPlayer, 2));
/*      */     } 
/*  620 */     return on;
/*      */   }
/*      */   
/*      */   public static boolean armTypSS3On(EntityPlayer par1EntityPlayer) {
/*  624 */     boolean on = false;
/*  625 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*  626 */     if (side == Side.CLIENT && 
/*  627 */       plyrs != null && plyrs.length > 0 && dnn(1) && dnn(2)) {
/*  628 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*  629 */         if (plyrs[pl].equals(par1EntityPlayer.func_70005_c_())) {
/*  630 */           String[] s = data1[pl].split(";");
/*  631 */           String[] s2 = data2[pl].split(";");
/*  632 */           if (saiyanBlood(s) && state(s2[0], 3)) on = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*  638 */     if (side == Side.SERVER) {
/*  639 */       NBTTagCompound aPlayer = nbt((Entity)par1EntityPlayer, "pres");
/*  640 */       on = (saiyanBlood(aPlayer) && state(aPlayer, 3));
/*      */     } 
/*  642 */     return on;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean armTypScoutAllOn(ItemStack stackhead) {
/*  647 */     return stackhead.func_77973_b() instanceof ItemHeadwear;
/*      */   }
/*      */   
/*      */   public static boolean armTypScoutOn(ItemStack var9) {
/*  651 */     boolean on = false;
/*  652 */     on = (armTypScoutAllOn(var9) && ((ItemHeadwear)var9.func_77973_b()).getTier().equals("1"));
/*  653 */     return on;
/*      */   }
/*      */   
/*      */   public static boolean armTypScoutAOn(ItemStack var9) {
/*  657 */     boolean on = false;
/*  658 */     on = (armTypScoutAllOn(var9) && ((ItemHeadwear)var9.func_77973_b()).getTier().equals("2"));
/*  659 */     return on;
/*      */   }
/*      */   
/*      */   public static boolean armTypScoutBOn(ItemStack var9) {
/*  663 */     boolean on = false;
/*  664 */     on = (armTypScoutAllOn(var9) && ((ItemHeadwear)var9.func_77973_b()).getTier().equals("3"));
/*  665 */     return on;
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
/*      */   public static NBTTagCompound nbt(Entity entity) {
/*  677 */     return nbt(entity, "");
/*      */   }
/*      */   public static NBTTagCompound nbt(Entity entity, String s) {
/*  680 */     NBTTagCompound nbt = null;
/*  681 */     if (s.contains("pres") && entity instanceof EntityPlayer) {
/*  682 */       (EntityPlayer)entity; if (!entity.getEntityData().func_74764_b("PlayerPersisted")) {
/*  683 */         nbt = new NBTTagCompound();
/*  684 */         (EntityPlayer)entity; entity.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*      */       } else {
/*  686 */         (EntityPlayer)entity; nbt = entity.getEntityData().func_74775_l("PlayerPersisted");
/*      */       } 
/*  688 */     } else if (entity != null) {
/*  689 */       nbt = entity.getEntityData();
/*      */     } 
/*      */     
/*  692 */     return nbt;
/*      */   } public static NBTTagCompound nbt(EntityPlayer p) {
/*  694 */     return nbt((Entity)p, "pres");
/*      */   }
/*  696 */   public static short getShort(EntityPlayer Player, String string) { return nbt((Entity)Player, "pres").func_74765_d(string); }
/*  697 */   public static void setShort(int s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74777_a(string, (short)s); }
/*  698 */   public static void setShort(short s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74777_a(string, s); }
/*  699 */   public static void setShort(byte s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74777_a(string, (short)s); } public static void setShort(float s, EntityPlayer Player, String string) {
/*  700 */     nbt((Entity)Player, "pres").func_74777_a(string, (short)(int)s);
/*      */   }
/*  702 */   public static byte getByte(EntityPlayer Player, String string) { return nbt((Entity)Player, "pres").func_74771_c(string); }
/*  703 */   public static void setByte(int s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74774_a(string, (byte)s); }
/*  704 */   public static void setByte(short s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74774_a(string, (byte)s); }
/*  705 */   public static void setByte(byte s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74774_a(string, s); } public static void setByte(float s, EntityPlayer Player, String string) {
/*  706 */     nbt((Entity)Player, "pres").func_74774_a(string, (byte)(int)s);
/*      */   }
/*  708 */   public static int getInt(EntityPlayer Player, String string) { return nbt((Entity)Player, "pres").func_74762_e(string); }
/*  709 */   public static void setInt(int s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74768_a(string, s); }
/*  710 */   public static void setInt(short s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74768_a(string, s); }
/*  711 */   public static void setInt(byte s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74768_a(string, s); } public static void setInt(float s, EntityPlayer Player, String string) {
/*  712 */     nbt((Entity)Player, "pres").func_74768_a(string, (int)s);
/*      */   }
/*  714 */   public static float getFloat(EntityPlayer Player, String string) { return nbt((Entity)Player, "pres").func_74760_g(string); }
/*  715 */   public static void setFloat(int s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74776_a(string, s); }
/*  716 */   public static void setFloat(short s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74776_a(string, s); }
/*  717 */   public static void setFloat(byte s, EntityPlayer Player, String string) { nbt((Entity)Player, "pres").func_74776_a(string, s); } public static void setFloat(float s, EntityPlayer Player, String string) {
/*  718 */     nbt((Entity)Player, "pres").func_74776_a(string, s);
/*      */   }
/*  720 */   public static String getString(EntityPlayer Player, String string) { return nbt((Entity)Player, "pres").func_74779_i(string); } public static void setString(String s, EntityPlayer Player, String string) {
/*  721 */     nbt((Entity)Player, "pres").func_74778_a(string, s);
/*      */   }
/*  723 */   public static long getLong(EntityPlayer Player, String string) { return nbt((Entity)Player, "pres").func_74763_f(string); } public static void setLong(long s, EntityPlayer Player, String string) {
/*  724 */     nbt((Entity)Player, "pres").func_74772_a(string, (int)s);
/*      */   } public static NBTBase getTag(EntityPlayer Player, String string) {
/*  726 */     return nbt((Entity)Player, "pres").func_74781_a(string);
/*      */   } public static boolean inAir(EntityPlayer plyr) {
/*  728 */     return !plyr.field_70122_E;
/*      */   }
/*  730 */   public static byte parseByte(String i) { return Byte.parseByte(i); }
/*  731 */   public static short parseShort(String i) { return Short.parseShort(i); }
/*  732 */   public static int parseInt(String i) { return Integer.parseInt(i); }
/*  733 */   public static float parseFloat(String i) { return Float.parseFloat(i); } public static double parseDouble(String i) {
/*  734 */     return Double.parseDouble(i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAprilFoolsModeOn() {
/*  742 */     if (JGConfigClientSettings.CLIENT_DA17) return true; 
/*  743 */     boolean apr = false;
/*      */     try {
/*  745 */       Calendar cal = Calendar.getInstance();
/*  746 */       cal.setLenient(false);
/*  747 */       cal.getTime();
/*  748 */       String[] date = cal.getTime().toString().split(" ");
/*  749 */       if (date[1].equals("Apr") && date[2].equals("01")) apr = true; 
/*  750 */     } catch (Exception exception) {}
/*  751 */     return apr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float calculateEnergyScale(float damage, float maxDamage, float perc, byte[] sts, byte density, float minScale, float maxScale) {
/*  758 */     if (density < 1) density = 1; 
/*  759 */     if (damage > maxDamage) damage = maxDamage;
/*      */     
/*  761 */     float damEgy = maxDamage / 100.0F;
/*  762 */     float damPercentage = damage / damEgy;
/*      */     
/*  764 */     float scaleEgy = maxScale / 100.0F;
/*      */     
/*  766 */     float scaleDam = damPercentage * scaleEgy;
/*  767 */     float scale = minScale + scaleDam;
/*  768 */     scale /= density;
/*  769 */     scale *= perc;
/*  770 */     if (sts != null && sts.length > 0) {
/*  771 */       scale *= 1.0F + tech_statmod(sts, 6);
/*      */     }
/*  773 */     return scale;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getEnegyDamageC(String[] t, byte[] sts) {
/*  779 */     int[] PlyrAttrbts = PlyrAttrbts();
/*  780 */     byte pwr = Pwrtyp;
/*  781 */     byte rc = Race;
/*  782 */     byte cls = Class;
/*      */     
/*  784 */     byte curRel = curRelease;
/*  785 */     byte state = State;
/*  786 */     byte state2 = State2;
/*  787 */     String[] PlyrSkills = JRMCoreH.PlyrSkills;
/*  788 */     String sklx = PlyrSkillX;
/*  789 */     int resrv = getArcRsrv();
/*  790 */     String absorption = getMajinAbsorption();
/*  791 */     boolean mj = StusEfctsMe(12);
/*  792 */     boolean lg = StusEfctsMe(14);
/*  793 */     boolean kk = StusEfctsMe(5);
/*  794 */     boolean mc = StusEfctsMe(13);
/*  795 */     boolean mn = StusEfctsMe(19);
/*  796 */     boolean gd = StusEfctsMe(20);
/*  797 */     boolean v = (StusEfctsMe(10) || StusEfctsMe(11));
/*  798 */     int WIL = getPlayerAttribute(mod_JRMCore.proxy.getPlayerClient(), PlyrAttrbts, 3, state, state2, rc, sklx, curRel, resrv, lg, mj, kk, mc, mn, gd, pwr, PlyrSkills, v, absorption);
/*      */     
/*  800 */     int stat = stat((Entity)mod_JRMCore.proxy.getPlayerClient(), 3, pwr, 4, WIL, rc, cls, 0.0F);
/*      */     
/*  802 */     int dam1 = techDBCdmg(t, stat, sts);
/*  803 */     return dam1 / 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getEnegyDamage(EntityPlayer p, String[] t, byte[] sts) {
/*  810 */     int[] PlyrAttrbts = PlyrAttrbts(p);
/*  811 */     byte curRel = getByte(p, "jrmcRelease");
/*  812 */     String[] PlyrSkills = getString(p, "jrmcSSlts").split(",");
/*  813 */     byte pwr = getByte(p, "jrmcPwrtyp");
/*  814 */     byte rc = getByte(p, "jrmcRace");
/*  815 */     byte cls = getByte(p, "jrmcClass");
/*      */ 
/*      */     
/*  818 */     byte state = getByte(p, "jrmcState");
/*  819 */     byte state2 = getByte(p, "jrmcState2");
/*  820 */     String sklx = getString(p, "jrmcSSltX");
/*  821 */     int resrv = getInt(p, "jrmcArcRsrv");
/*  822 */     String absorption = getString(p, "jrmcMajinAbsorptionData");
/*      */     
/*  824 */     String ste = getString(p, "jrmcStatusEff");
/*  825 */     boolean mj = StusEfcts(12, ste);
/*  826 */     boolean lg = StusEfcts(14, ste);
/*  827 */     boolean kk = StusEfcts(5, ste);
/*  828 */     boolean mc = StusEfcts(13, ste);
/*  829 */     boolean mn = StusEfcts(19, ste);
/*  830 */     boolean gd = StusEfcts(20, ste);
/*  831 */     boolean v = (StusEfcts(10, ste) || StusEfcts(11, ste));
/*  832 */     int WIL = getPlayerAttribute(p, PlyrAttrbts, 3, state, state2, rc, sklx, curRel, resrv, lg, mj, kk, mc, mn, gd, pwr, PlyrSkills, v, absorption);
/*      */     
/*  834 */     int stat = stat((Entity)p, 3, pwr, 4, WIL, rc, cls, 0.0F);
/*      */     
/*  836 */     int dam1 = techDBCdmg(t, stat, sts);
/*  837 */     return dam1 / 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  844 */   public static int ChakraAmount = 0;
/*  845 */   public static double ChakraMultip = 0.0D;
/*      */ 
/*      */   
/*  848 */   public static String hsp = "";
/*  849 */   public static int jutsumode = 0;
/*  850 */   public static int handsealfailed = 0;
/*  851 */   public static int jutsu = 0;
/*  852 */   public static int jutsuinfo = 0;
/*      */ 
/*      */   
/*  855 */   public static String[] ncDou = null;
/*      */   
/*  857 */   public static int ncBodyCur = 0;
/*  858 */   public static int ncExp = 0;
/*  859 */   public static int ncEvil = 0;
/*  860 */   public static int ncBody = 0;
/*  861 */   public static int ncTP = 0;
/*  862 */   public static int ncChMax = 0;
/*  863 */   public static int ncChRa = 0;
/*  864 */   public static int ncSpe = 0;
/*  865 */   public static int ncTai = 0;
/*  866 */   public static int ncTaiJump = 0;
/*  867 */   public static int ncNinj = 0;
/*  868 */   public static int ncGenj = 0;
/*  869 */   public static int ncPow = 0;
/*      */   
/*  871 */   public static String Sbody = "h.dbc";
/*  872 */   public static String Stp = "t.dbc";
/*  873 */   public static String SchMax = "x.dbc";
/*  874 */   public static String SchRa = "c.dbc";
/*  875 */   public static String Sspe = "d.dbc";
/*  876 */   public static String Stai = "p.dbc";
/*  877 */   public static String StaiJump = "j.dbc";
/*  878 */   public static String SNinj = "n.dbc";
/*  879 */   public static String SGenj = "g.dbc";
/*  880 */   public static String SPow = "a.dbc";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  888 */   public static String[] plyrsArnd = null; public static final String JTCCBattleData = "JTCCBattleData"; public static final String JTCCBattleDataP1 = "JTCCBattleDataP1"; public static final String JTCCBattleDataP2 = "JTCCBattleDataP2"; public static final String JTCCBattleOps = "JTCCBattleOps"; public static final String JTCCCCD = "JTCCCCD"; public static final String JTCCDD = "JTCCDD"; public static final String MissionSyncData = "JRMCmissionSync"; public static final String MissionSyncDataVers = "JRMCmissionSyncVers";
/*      */   public static final String SagaSideDBC = "JRMCSideSaga";
/*      */   public static final String SagaSideTimesDBC = "JRMCSideSagaTimes";
/*      */   public static final String SagaMainDBC = "DBCSagaSys";
/*      */   public static final String SagaMainTimesDBC = "DBCSagaTimes";
/*      */   public static final String SagaGID = "JRMCGID";
/*      */   public static final String SagaGLID = "JRMCGLIDs";
/*      */   public static final String SagaGIDi = "JRMCGIDis";
/*      */   public static final String AttackTimer = "jrmcAttackTimer";
/*      */   public static final String AttackLstPlyrTm = "jrmcAttackLstPlyrTm";
/*      */   public static final String AttackLstPlyrNam = "jrmcAttackLstPlyrNam";
/*      */   public static final String SenzuCC = "jrmcSenzuCC";
/*      */   public static final String GravZoneLast = "jrmcGravZoneLast";
/*      */   public static final String GravZoneForce = "jrmcGravForce";
/*      */   public static final String Age = "JRYCAge";
/*      */   public static final String DNS = "jrmcDNS";
/*      */   public static final String DNSAU = "jrmcDNSAU";
/*      */   public static final String DNSH = "jrmcDNSH";
/*      */   public static final String R = "jrmcRace";
/*      */   public static final String P = "jrmcPwrtyp";
/*      */   public static final String Cl = "jrmcClass";
/*      */   public static final String Acc = "jrmcAccept";
/*      */   public static final String St = "jrmcState";
/*      */   public static final String St2 = "jrmcState2";
/*      */   public static final String StE = "jrmcStatusEff";
/*      */   public static final String senzu = "DBCSenzu";
/*      */   
/*      */   public static void a1t3(EntityPlayer e) {
/*  916 */     int epoch = (int)(System.currentTimeMillis() / 1000L) + 30;
/*  917 */     setInt(epoch, e, "jrmcAttackTimer");
/*      */   }
/*      */ 
/*      */   
/*      */   public static final String firing = "jrmcFrng";
/*      */   
/*      */   public static final String Diff = "jrmcDiff";
/*      */   
/*      */   public static final String Tm = "jrmcTlmd";
/*      */   
/*      */   public static final String master = "jrmcMaster";
/*      */   
/*      */   public static final String plyrSttngs = "jrmcSettings";
/*      */   
/*      */   public static final String AuraCol = "jrmcAuraColor";
/*      */   
/*      */   public static final String StrainTemp = "jrmcStrainTemp";
/*      */   
/*      */   public static final String Strain = "jrmcStrain";
/*      */   
/*      */   public static final String StrainActv = "jrmcStrainActv";
/*      */   
/*      */   public static final String GodStrain = "jrmcGodStrain";
/*      */   
/*      */   public static final String GodPwr = "jrmcGodPwr";
/*      */   
/*      */   public static final String S4afgft = "jrmcAfGFtStFT";
/*      */   
/*      */   public static final String Pain = "jrmcGyJ7dp";
/*      */   
/*      */   public static final String Heat = "jrmcEf8slc";
/*      */   
/*      */   public static final String KO = "jrmcHar4va";
/*      */   
/*      */   public static final String HeatD = "jrmcEf8slcD";
/*      */   
/*      */   public static final String SsnoCol = "jrmcSsnoc";
/*      */   
/*      */   public static final String DiffRed = "jrmcDiffRed";
/*      */   
/*      */   public static final String Ptch = "jrmcPtch";
/*      */   
/*      */   public static final String TrngTPlmt = "jrmcTPlimit";
/*      */   
/*      */   public static final String TrngTPlmt2 = "jrmcTPlimit2";
/*      */   
/*      */   public static final String SklSlt0 = "jrmcSSlt0";
/*      */   
/*      */   public static final String SklSlt1 = "jrmcSSlt1";
/*      */   public static final String SklSlt2 = "jrmcSSlt2";
/*      */   public static final String SklSlt3 = "jrmcSSlt3";
/*      */   public static final String SklSlt4 = "jrmcSSlt4";
/*      */   public static final String SklSlt5 = "jrmcSSlt5";
/*      */   public static final String SklSlt6 = "jrmcSSlt6";
/*      */   public static final String SklSlt7 = "jrmcSSlt7";
/*      */   public static final String SklSlt8 = "jrmcSSlt8";
/*      */   public static final String SklSlt9 = "jrmcSSlt9";
/*      */   public static final String SklSltX = "jrmcSSltX";
/*      */   public static final String SklSltY = "jrmcSSltY";
/*  976 */   public static final String[] AttrbtNbt = new String[] { "jrmcStr", "jrmcDex", "jrmcCns", "jrmcWil", "jrmcInt", "jrmcCnc" };
/*  977 */   public static final String[] AttrbtNbtI = new String[] { "jrmcStrI", "jrmcDexI", "jrmcCnsI", "jrmcWilI", "jrmcIntI", "jrmcCncI" };
/*  978 */   public static final String[] AttrbtNbtR = new String[] { "jrmcStrR", "jrmcDexR", "jrmcCnsR", "jrmcWilR", "jrmcIntR", "jrmcCncR" };
/*      */   public static final String SkillXNbt = "jrmcSSltX";
/*      */   public static final String SkillYNbt = "jrmcSSltY";
/*      */   public static final String SkillZNbt = "jrmcSSltZ";
/*  982 */   public static final String[] SkillsNbt = new String[] { "jrmcSSlt0", "jrmcSSlt1", "jrmcSSlt2", "jrmcSSlt3", "jrmcSSlt4", "jrmcSSlt5", "jrmcSSlt6", "jrmcSSlt7", "jrmcSSlt8", "jrmcSSlt9" };
/*      */   
/*      */   public static final String SkillsNbt2 = "jrmcSSlts";
/*      */   
/*      */   public static final String CurBody = "jrmcBdy";
/*      */   public static final String CurEnergy = "jrmcEnrgy";
/*      */   public static final String CurStamina = "jrmcStamina";
/*      */   public static final String CurRelease = "jrmcRelease";
/*      */   public static final String Align = "jrmcAlign";
/*      */   public static final String Karma = "jrmcKarma";
/*      */   public static final String KllCG = "jrmcKillCountGood";
/*      */   public static final String KllCN = "jrmcKillCountNeut";
/*      */   public static final String KllCE = "jrmcKillCountEvil";
/*      */   public static final String DiedTimes = "jrmcDiedTimes";
/*      */   public static final String GTrnng = "jrmcGTrnng";
/*      */   public static final String htcTmO = "jrmcHTCTmO";
/*      */   public static final String alCntr = "jrmcAlCntr";
/*      */   public static final String inventoryLiving = "InventoryLiving";
/*      */   public static final String inventoryDead = "InventoryDead";
/*      */   public static final String RevTmr = "jrmcReviveTmer";
/*      */   public static final String Rencrnt = "jrmcRencrnt";
/*      */   public static final String RevtpInit = "jrmcRevtpInit";
/*      */   public static final String LastDamageDealt = "jrmcLastDamageDealt";
/*      */   public static final String LastDamageReceived = "jrmcLastDamageReceived";
/*      */   public static final String LastAttacker = "jrmcLastAttacker";
/* 1007 */   public static final String[] FAttrbtNbt = new String[] { "jrmcStrF", "jrmcDexF", "jrmcCnsF", "jrmcWilF", "jrmcIntF", "jrmcCncF" };
/*      */   
/*      */   public static final String FAge = "JRYCAgeF";
/*      */   
/*      */   public static final String FDNS = "jrmcDNSF";
/*      */   
/*      */   public static final String FDNSH = "jrmcDNSHF";
/*      */   
/*      */   public static final String FTP = "jrmcTpF";
/*      */   
/*      */   public static final String FUSION = "jrmcFuzion";
/*      */   
/*      */   public static final String FUSION_DEATH = "jrmcFuzionDeath";
/*      */   
/*      */   public static final String Majin = "jrmcMajin";
/*      */   
/*      */   public static final String MysticTimer = "jrmcUltmtTm";
/*      */   
/*      */   public static final String alive = "jrmcAlv";
/*      */   
/*      */   public static final String stand = "jrmcStnd";
/*      */   
/*      */   public static final String Wishes = "jrmcWishes";
/*      */   
/*      */   public static final String Drgn = "jrmcDrgn";
/*      */   
/*      */   public static final String dj = "jrmcdj";
/*      */   
/*      */   public static final String NBT_UI_HighestStateReached = "jrmcUIStateReach";
/*      */   
/*      */   public static final String NBT_UI_WasInPain = "jrmcUIWasInPain";
/*      */   
/*      */   public static final String NBT_UI_WasInPainDuration = "jrmcUIWasInPainDuration";
/*      */   
/*      */   public static final String NBT_InstantTransmissionTimers = "jrmcInstantTransmissionTimers";
/*      */   
/*      */   public static final String NBT_FormMasteryRacial = "jrmcFormMasteryRacial";
/*      */   
/*      */   public static final String NBT_FormMasteryDefault = "Base,0";
/*      */   
/*      */   public static final String NBT_FormMasteryDefaultNonRacial = "Kaioken,0";
/*      */   
/*      */   public static final String NBT_FormMasteryNonRacial = "jrmcFormMasteryNonRacial";
/*      */   
/*      */   public static final String NBT_MajinAbsorptionData = "jrmcMajinAbsorptionData";
/*      */   public static final String NBT_MajinAbsorptionTimer = "jrmcMajinAbsorptionTimer";
/*      */   public static String bonusAttributes;
/* 1054 */   public static String FznDC = "";
/* 1055 */   public static int Master = 0;
/*      */ 
/*      */   
/* 1058 */   public static String MSD = "";
/* 1059 */   public static String MSDV = "";
/* 1060 */   public static int SagaProg = 0;
/* 1061 */   public static int SagaTimes = 0;
/* 1062 */   public static int SagaSideProg = 0;
/* 1063 */   public static int[] SagaSideTimes = null;
/*      */   
/* 1065 */   public static int GID = 0;
/*      */   
/* 1067 */   public static String GLID = " ";
/*      */   
/* 1069 */   public static int[] GIDs = null;
/*      */   
/* 1071 */   public static String GIDi = " ";
/*      */   
/* 1073 */   public static int GMN = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1078 */   public static HashMap<Integer, ArrayList<String>> nwl = new HashMap<Integer, ArrayList<String>>();
/*      */   
/* 1080 */   public static int ServerPoints = 0;
/*      */   
/* 1082 */   public static int trngTPlmt = 0, trngTPlmt2 = 0;
/* 1083 */   public static int revTmr = 0;
/* 1084 */   public static String revtpInit = "";
/* 1085 */   public static int wishes = 0;
/*      */   
/* 1087 */   public static byte Race = 0;
/* 1088 */   public static String dns = "0";
/* 1089 */   public static String dnsau = "0";
/* 1090 */   public static String dnsH = "0";
/* 1091 */   public static byte Pwrtyp = 0;
/* 1092 */   public static byte Class = 0;
/* 1093 */   public static byte Accepted = 0;
/* 1094 */   public static byte State = 0;
/* 1095 */   public static byte State2 = 0;
/* 1096 */   public static byte Dffclty = 0;
/*      */   
/* 1098 */   public static byte TlMd = 0;
/*      */   
/* 1100 */   public static byte PtchVc = 0;
/*      */   
/* 1102 */   public static int GTrnngCB = 0;
/*      */   
/* 1104 */   public static float WeightOn = 0.0F;
/* 1105 */   public static float GravZone = 1.0F;
/* 1106 */   public static int s4ft = 0;
/*      */   
/* 1108 */   public static float age = 0.0F;
/*      */   
/* 1110 */   public static int curBody = 0;
/* 1111 */   public static int curEnergy = 0;
/* 1112 */   public static int curStamina = 0;
/* 1113 */   public static int maxBody = 0;
/* 1114 */   public static int maxEnergy = 0;
/* 1115 */   public static int maxStamina = 0;
/*      */   
/* 1117 */   public static byte curRelease = 0;
/* 1118 */   public static int curTP = 0;
/* 1119 */   public static int curExp = 0;
/*      */   
/* 1121 */   public static int curn = 0;
/*      */   
/* 1123 */   public static int cura = 0;
/*      */   
/* 1125 */   public static int ko = 0;
/*      */   
/*      */   public static boolean kob = false;
/*      */   
/* 1129 */   public static int pnp = 0;
/*      */   
/*      */   public static boolean pnh = false;
/*      */   
/* 1133 */   public static short charged = 0;
/* 1134 */   public static byte chrgPrc = 0;
/* 1135 */   public static byte channel = 0;
/* 1136 */   public static byte wave = 0;
/*      */   public static boolean mrAtts = false;
/* 1138 */   public static byte EnAtSlct = 0;
/* 1139 */   public static float curTech1CD = 0.0F;
/* 1140 */   public static float curTech2CD = 0.0F;
/* 1141 */   public static float curTech3CD = 0.0F;
/* 1142 */   public static float curTech4CD = 0.0F;
/* 1143 */   public static float curTech5CD = 0.0F;
/* 1144 */   public static float curTech6CD = 0.0F;
/* 1145 */   public static float curTech7CD = 0.0F;
/* 1146 */   public static float curTech8CD = 0.0F;
/*      */   public static boolean isShtng = false;
/*      */   public static boolean isChrgng = false;
/* 1149 */   public static float cast = 0.0F;
/* 1150 */   public static byte align = 0;
/* 1151 */   public static int karma = 0;
/*      */ 
/*      */   
/* 1154 */   public static float[] techniqueCooldowns = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
/*      */ 
/*      */   
/* 1157 */   public static String PlyrSettings = "";
/* 1158 */   public static int[] PlyrAttrbts = new int[] { 0, 0, 0, 0, 0, 0 };
/* 1159 */   public static String PlyrSkillX = "";
/* 1160 */   public static String PlyrSkillY = "";
/* 1161 */   public static String PlyrSkillZ = "";
/* 1162 */   public static String[] PlyrSkills = new String[10];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1168 */   public static final String[] StusEfcts = new String[] { "F", "R", "T", "B", "A", "K", "M", "S", "O", "D", "Z", "I", "J", "C", "L", "E", "U", "V", "P", "N", "G", "H" };
/*      */ 
/*      */ 
/*      */   
/* 1172 */   private static final String[] PlyrSttngs = new String[] { "K", "R", "D", "G", "Z", "B", "M", "E", "O", "F", "P", "U", "I", "S", "A", "C", "H" };
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean aliveState(int pl) {
/* 1177 */     return dat13[pl].split(";")[0].contains("1");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean aliveState() {
/* 1183 */     if (plyrs != null && plyrs.length > 0 && dnn(13))
/* 1184 */       for (int pl = 0; pl < plyrs.length; pl++) {
/* 1185 */         if (plyrs[pl].equals(mod_JRMCore.proxy.getPlayerClient().func_70005_c_())) {
/* 1186 */           return aliveState(pl);
/*      */         }
/*      */       }  
/* 1189 */     return false;
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
/* 1200 */   public static final String[] vlblRSkls = new String[] { "TR" };
/*      */ 
/*      */   
/* 1203 */   public static int[][] DBCRacialSkillTPCost = new int[Races.length][], cDBCRacialSkillTPCost = new int[Races.length][];
/*      */   
/* 1205 */   public static int[][] DBCRacialSkillMindCost = new int[Races.length][]; public static int[][] cDBCRacialSkillMindCost = new int[Races.length][];
/*      */   
/* 1207 */   public static final String[] vlblRSklsNms = new String[] { "HiddenPotential", "SuperForm", "SuperForm", "PowerBoost", "Transformations", "Abilities" };
/* 1208 */   public static final String[] vlblCSkls = new String[] { "HL" };
/* 1209 */   public static final int[][] vlblCSklsLvl = new int[][] { { 10 } };
/* 1210 */   public static final String[] vlblCSklsNms = new String[] { "Heal" };
/* 1211 */   public static final String[] DBCSkillsIDs = new String[] { "FZ", "JP", "DS", "FL", "EN", "OC", "KS", "MD", "KK", "GF", "OK", "KP", "KF", "KB", "DF", "KI", "UI", "IT", "GD" };
/* 1212 */   public static final int[] vlblSklsUps = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 8, 8, -1, 8, -1 };
/*      */ 
/*      */   
/* 1215 */   public static int[][] DBCSkillTPCost = new int[DBCSkillsIDs.length][], cDBCSkillTPCost = new int[DBCSkillsIDs.length][];
/*      */   
/* 1217 */   public static int[][] DBCSkillMindCost = new int[DBCSkillsIDs.length][]; public static int[][] cDBCSkillMindCost = new int[DBCSkillsIDs.length][];
/*      */ 
/*      */   
/* 1220 */   public static final String[] DBCSkillNames = new String[] { "Fusion", "Jump", "Dash", "Fly", "Endurance", "PotentialUnlock", "KiSense", "Meditation", "Kaioken", "GodForm", "OldKaiUnlock", "KiProtection", "KiFist", "KiBoost", "DefensePenetration", "KiInfuse", "UltraInstinct", "InstantTransmission", "GodOfDestruction" };
/*      */ 
/*      */   
/*      */   public static final float SklLvl_KiBsM = 0.01F;
/*      */ 
/*      */   
/*      */   public static boolean plyrSttngsClient(int plytSttngs, int pl) {
/* 1227 */     if (dat13 != null && dat13.length > pl) {
/*      */       
/* 1229 */       String[] s = dat13[pl].split(";");
/* 1230 */       return s[1].contains(PlyrSttngs[plytSttngs]);
/*      */     } 
/* 1232 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static float SklLvl_KiBs(EntityPlayer p, int w) {
/* 1238 */     return (w == 1) ? (SklLvl(13, p) * 0.01F) : 0.0F;
/*      */   } public static float SklLvl_KiBs(int w) {
/* 1240 */     return (w == 1) ? (SklLvl(13) * 0.01F) : 0.0F;
/*      */   } public static float SklLvl_KiBs(String[] s, int w) {
/* 1242 */     return (w == 1) ? (SklLvl(13, s) * 0.01F) : 0.0F;
/*      */   }
/*      */   
/*      */   public static float SklLvl_Fd(EntityPlayer p, int w) {
/* 1246 */     float e = p.field_70143_R;
/* 1247 */     return e;
/*      */   }
/*      */   public static String StusEfctsClient2(String id) {
/* 1250 */     if (dnn(19)) {
/* 1251 */       for (int pl = 0; pl < plyrs.length; pl++) {
/* 1252 */         if (plyrs[pl].equals(id)) {
/* 1253 */           String[] s = dat19[pl].split(";");
/* 1254 */           return s[1];
/*      */         } 
/*      */       } 
/*      */     }
/* 1258 */     return "";
/*      */   }
/*      */   public static String StusEfctsClient(EntityPlayer p) {
/* 1261 */     return data(p.func_70005_c_(), 19, "0; ;");
/*      */   }
/*      */   public static String StusEfctsClient(int pl) {
/* 1264 */     if (dat19 != null && dat19.length > pl) {
/* 1265 */       String[] s = dat19[pl].split(";");
/* 1266 */       return s[1];
/*      */     } 
/* 1268 */     return "";
/*      */   }
/*      */   
/*      */   public static boolean StusEfcts(int ste, String se) {
/* 1272 */     return se.contains(StusEfcts[ste]);
/*      */   }
/*      */   
/*      */   public static boolean StusEfctsClient(int ste, EntityPlayer p) {
/* 1276 */     return StusEfctsClient(p).contains(StusEfcts[ste]);
/*      */   }
/*      */   public static boolean StusEfctsClient(int ste, int pl) {
/* 1279 */     return StusEfctsClient(pl).contains(StusEfcts[ste]);
/*      */   }
/*      */   public static String StusEfctsMe() {
/* 1282 */     return StusEfctsClient2(mod_JRMCore.proxy.getPlayerClient().func_70005_c_());
/*      */   }
/*      */   public static boolean StusEfctsMe(int ste) {
/* 1285 */     return StusEfctsMe().contains(StusEfcts[ste]);
/*      */   }
/*      */   
/*      */   public static void StusEfcts(int i, String s, EntityPlayer p, boolean b) {
/* 1289 */     String bns = StusEfcts[i];
/* 1290 */     if (!b && s.contains(bns)) {
/* 1291 */       s = s.contains(bns) ? s.replace(bns, "") : s;
/* 1292 */       setString(s, p, "jrmcStatusEff");
/*      */       return;
/*      */     } 
/* 1295 */     if (b) {
/* 1296 */       s = s + bns;
/* 1297 */       setString(s, p, "jrmcStatusEff");
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void StusEfcts(int i, EntityPlayer p, boolean b) {
/* 1302 */     String bns = StusEfcts[i];
/* 1303 */     String s = getString(p, "jrmcStatusEff");
/* 1304 */     if (!b && s.contains(bns)) {
/* 1305 */       s = s.contains(bns) ? s.replace(bns, "") : s;
/* 1306 */       setString(s, p, "jrmcStatusEff");
/*      */       return;
/*      */     } 
/* 1309 */     if (b) {
/* 1310 */       setString(s + bns, p, "jrmcStatusEff");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static String StusEfcts(int i, String s, NBTTagCompound nbt, boolean b) {
/* 1316 */     String bns = StusEfcts[i];
/* 1317 */     if (!b && s.contains(bns)) {
/* 1318 */       s = s.contains(bns) ? s.replace(bns, "") : s;
/* 1319 */       nbt.func_74778_a("jrmcStatusEff", s);
/* 1320 */       return s;
/*      */     } 
/* 1322 */     if (b) {
/* 1323 */       nbt.func_74778_a("jrmcStatusEff", s + bns);
/* 1324 */       return s + bns;
/*      */     } 
/* 1326 */     return s;
/*      */   }
/*      */   
/*      */   public static String StusEfcts(int i, NBTTagCompound nbt, boolean b) {
/* 1330 */     String bns = StusEfcts[i];
/* 1331 */     String s = nbt.func_74779_i("jrmcStatusEff");
/* 1332 */     if (!b && s.contains(bns)) {
/* 1333 */       s = s.contains(bns) ? s.replace(bns, "") : s;
/* 1334 */       nbt.func_74778_a("jrmcStatusEff", s);
/* 1335 */       return s;
/*      */     } 
/* 1337 */     if (b) {
/* 1338 */       nbt.func_74778_a("jrmcStatusEff", s + bns);
/* 1339 */       return s + bns;
/*      */     } 
/* 1341 */     return s;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFused() {
/* 1347 */     return (isPowerTypeKi() && (StusEfctsMe(10) || StusEfctsMe(11)));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isFused(Entity Player) {
/* 1352 */     NBTTagCompound nbt = nbt(Player, "pres");
/* 1353 */     byte powerType = nbt.func_74771_c("jrmcPwrtyp");
/*      */     
/* 1355 */     if (isPowerTypeKi(powerType)) {
/*      */       
/* 1357 */       String Fzn = nbt.func_74779_i("jrmcFuzion");
/*      */       
/* 1359 */       if (Fzn.contains(",") && (Fzn.split(",")).length == 3)
/*      */       {
/* 1361 */         return true;
/*      */       }
/*      */       
/* 1364 */       String StE = nbt.func_74779_i("jrmcStatusEff");
/* 1365 */       boolean fused = (StusEfcts(10, StE) || StusEfcts(11, StE));
/* 1366 */       return fused;
/*      */     } 
/* 1368 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isFusionSpectator(Entity Player) {
/* 1373 */     if (Player != null && Player instanceof EntityPlayer) {
/*      */       
/* 1375 */       NBTTagCompound nbt = nbt(Player, "pres");
/* 1376 */       byte powerType = nbt.func_74771_c("jrmcPwrtyp");
/*      */       
/* 1378 */       if (isPowerTypeKi(powerType)) {
/*      */         
/* 1380 */         String Fzn = nbt.func_74779_i("jrmcFuzion");
/*      */         
/* 1382 */         if (Fzn.contains(",")) {
/*      */           
/* 1384 */           String[] fusionMembers = Fzn.split(",");
/* 1385 */           if (fusionMembers.length == 3)
/*      */           {
/* 1387 */             return fusionMembers[1].equalsIgnoreCase(Player.func_70005_c_());
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/* 1392 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static EntityPlayer getFusionSpectatorPartnerC(EntityPlayer player) {
/* 1397 */     if (curRelease != 0 && StusEfctsMe(11) && !kob && isFused() && plyrs != null && plyrs.length > 0 && dnn(18))
/*      */     {
/* 1399 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*      */         
/* 1401 */         if (plyrs[pl].equals(player.func_70005_c_())) {
/*      */           
/* 1403 */           String[] fullFusionData = dat18[pl].split(";");
/* 1404 */           if (fullFusionData.length >= 3) {
/*      */             
/* 1406 */             String[] fusionData = fullFusionData[2].split(",");
/*      */             
/* 1408 */             if (fusionData.length == 3) {
/*      */               
/* 1410 */               EntityPlayer playerPartner = player.field_70170_p.func_72924_a(fusionData[0]);
/* 1411 */               if (player != null)
/*      */               {
/* 1413 */                 return playerPartner;
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1424 */     return null;
/*      */   }
/*      */   public static EntityPlayer isFusionSpectatorPartnerC(EntityPlayer player) {
/* 1427 */     return getFusionSpectatorPartnerC(player);
/*      */   }
/*      */   public static float SklInc(float j) {
/* 1430 */     return 60.0F / (60.0F + j) * j * 3.0F;
/*      */   } public static float SklInc100(float j) {
/* 1432 */     return 50.0F / (50.0F + j) * j * 3.0F;
/*      */   } public static float SklInc(float j, int m) {
/* 1434 */     float i = 100.0F / m;
/* 1435 */     j *= i;
/* 1436 */     return 50.0F / (50.0F + j) * j * 3.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int SklLvl(int sn) {
/* 1441 */     switch (Pwrtyp) { case 1:
/* 1442 */         return SklLvlC(sn, DBCSkillsIDs);
/* 1443 */       case 2: return SklLvlC(sn, NCSkillIDs); }
/*      */     
/* 1445 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int SklLvl(int sn, byte pwr) {
/* 1450 */     switch (pwr) { case 1:
/* 1451 */         return SklLvlC(sn, DBCSkillsIDs);
/* 1452 */       case 2: return SklLvlC(sn, NCSkillIDs); }
/*      */     
/* 1454 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SklLvlC(int sn, String[] s) {
/* 1460 */     if (s == null) return 0; 
/* 1461 */     int n = 0;
/* 1462 */     if (PlyrSkills != null)
/*      */     {
/* 1464 */       for (byte i = 0; i < PlyrSkills.length; i = (byte)(i + 1)) {
/*      */         
/* 1466 */         String curSkl = PlyrSkills[i];
/* 1467 */         if (curSkl != null && curSkl.length() > 2 && s.length > sn && curSkl.contains(s[sn]) && !curSkl.contains("pty")) {
/*      */           
/* 1469 */           n = 1 + Integer.parseInt(curSkl.substring(2));
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 1474 */     return n;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SklLvl(int sn, String[] ps) {
/* 1480 */     return SklLvl(sn, DBCSkillsIDs, ps);
/*      */   }
/*      */   
/*      */   public static int SklLvl(int sn, EntityPlayer p) {
/* 1484 */     return SklLvl(sn, (PlyrPwr(p) == 1) ? DBCSkillsIDs : NCSkillIDs, PlyrSkills(p));
/*      */   }
/*      */   public static int SklLvl(int sn, int pwr, String[] ps) {
/* 1487 */     return SklLvl(sn, (pwr == 1) ? DBCSkillsIDs : NCSkillIDs, ps);
/*      */   }
/*      */   public static int SklLvl(int sn, String[] s, String[] ps) {
/* 1490 */     if (ps == null || s == null) return 0;  int n = 0; byte i;
/* 1491 */     for (i = 0; i < ps.length; i = (byte)(i + 1)) {
/* 1492 */       if (ps[i] != null && s[sn] != null && 
/* 1493 */         ps[i].contains(s[sn]) && ps[i].length() > 2) {
/* 1494 */         n = Integer.parseInt(ps[i].replaceAll(s[sn], ""));
/* 1495 */         n = SklLvl_m(sn, s, n) + 1;
/* 1496 */         return n;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1501 */     return n;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SklLvl_m(int sn, String[] s, int n) {
/* 1508 */     if (s.equals(DBCSkillsIDs) && n - 1 > SklInit(s[sn], s, vlblSklsUps)) return SklInit(s[sn], s, vlblSklsUps) + 1; 
/* 1509 */     if (s.equals(NCSkillIDs) && n - 1 > SklInit(s[sn], s, ncSklsUps)) return SklInit(s[sn], s, ncSklsUps) + 1; 
/* 1510 */     return n;
/*      */   }
/*      */   public static int SklLvl_m(String sn, String[] s, int n) {
/* 1513 */     if (s.equals(DBCSkillsIDs) && n - 1 > SklInit(sn, s, vlblSklsUps)) return SklInit(sn, s, vlblSklsUps) + 1; 
/* 1514 */     if (s.equals(NCSkillIDs) && n - 1 > SklInit(sn, s, ncSklsUps)) return SklInit(sn, s, ncSklsUps) + 1; 
/* 1515 */     return n;
/*      */   }
/*      */   
/*      */   public static void SklLvl(int sn, String[] s, String[] ps, EntityPlayer p, int inc) {
/* 1519 */     if (ps == null || s == null) return;  int n = 0;
/* 1520 */     String psa = ""; int i;
/* 1521 */     for (i = 0; i < ps.length; i++) {
/* 1522 */       psa = psa + ps[i] + ",";
/*      */     }
/* 1524 */     for (i = 0; i < ps.length; i++) {
/* 1525 */       if (ps[i].contains(s[sn]) && ps[i].length() > 2) {
/* 1526 */         n = Integer.parseInt(ps[i].replaceAll(s[sn], "")) + inc;
/* 1527 */         if (n < 0) {
/* 1528 */           psa = psa.replace(ps[i] + ",", ""); break;
/*      */         } 
/* 1530 */         n = (n > 9) ? 9 : ((n < 0) ? 0 : n);
/* 1531 */         n = SklLvl_m(sn, s, n);
/* 1532 */         psa = psa.replace(ps[i] + ",", s[sn] + n + ",");
/*      */         break;
/*      */       } 
/*      */     } 
/* 1536 */     setString(psa, p, "jrmcSSlts");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SklLvlX(EntityPlayer player) {
/* 1542 */     return SklLvlX(getByte(player, "jrmcPwrtyp"), getString(player, "jrmcSSltX"));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SklLvlX(int powerType, String playerSkills) {
/* 1548 */     return SklLvl((powerType == 1) ? vlblRSkls : ncRSkls, playerSkills);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SklLvlY(int powerType, String playerSkills) {
/* 1554 */     return SklLvl((powerType == 1) ? vlblCSkls : ncCSkls, playerSkills);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SklLvl(String[] s, String ps) {
/* 1560 */     if (ps == null || s == null) return 0;
/*      */     
/* 1562 */     int n = 0;
/* 1563 */     if (ps.length() > 2 && !ps.contains("pty"))
/*      */     {
/* 1565 */       n = 1 + Integer.parseInt(ps.substring(2));
/*      */     }
/*      */     
/* 1568 */     return n;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SklInit(String curSkl, String[] s1, int[] s2) {
/* 1574 */     int s = 8;
/* 1575 */     for (int i = 0; i < s1.length; i++) {
/*      */       
/* 1577 */       if (curSkl.contains(s1[i]) && s1[i].length() > 0) {
/*      */         
/* 1579 */         s = (i == 16) ? (JGConfigUltraInstinct.CONFIG_UI_LEVELS - 2) : s2[i];
/*      */         break;
/*      */       } 
/*      */     } 
/* 1583 */     return s;
/*      */   }
/*      */   public static String SklName(String curSkl, String[] s1, String[] s2) {
/* 1586 */     String s = "error";
/* 1587 */     for (int i = 0; i < s1.length; i++) {
/* 1588 */       if (curSkl.contains(s1[i]) && s1[i].length() > 0) {
/* 1589 */         s = s2[i]; break;
/*      */       } 
/* 1591 */     }  return s;
/*      */   } public static String SklName(String curSkl, String[] s1, String[] s2, int r) {
/* 1593 */     String s = "error";
/* 1594 */     for (int i = 0; i < s1.length; i++) {
/* 1595 */       if (curSkl.contains(s1[i]) && s1[i].length() > 0) {
/* 1596 */         s = s2[r]; break;
/*      */       } 
/* 1598 */     }  return s;
/*      */   }
/*      */   
/*      */   public static int SklID(String skillName, String[] skills) {
/* 1602 */     if (skillName == null) return -1; 
/* 1603 */     if (skillName.length() > 1)
/* 1604 */       for (byte i = 0; i < skills.length; i = (byte)(i + 1)) {
/*      */         
/* 1606 */         if (skillName.length() > 1 && skills[i].contains(skillName.substring(0, 2)))
/*      */         {
/* 1608 */           return i;
/*      */         }
/*      */       }  
/* 1611 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static double[] frmt_d(double[] d, double i, double x) {
/* 1617 */     double[] n = new double[d.length];
/* 1618 */     for (int j = 0; j < d.length; j++)
/*      */     {
/* 1620 */       n[j] = (d[j] < i) ? i : ((d[j] > x) ? x : d[j]);
/*      */     }
/* 1622 */     return n;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int[] frmt_d(int[] d, int i, int x) {
/* 1627 */     int[] n = new int[d.length];
/* 1628 */     for (int j = 0; j < d.length; j++)
/*      */     {
/* 1630 */       n[j] = (d[j] < i) ? i : ((d[j] > x) ? x : d[j]);
/*      */     }
/* 1632 */     return n;
/*      */   }
/*      */ 
/*      */   
/* 1636 */   public static String[] inIll = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1643 */   public static final String[] ncRSkls = new String[] { "" };
/* 1644 */   public static final int[][] ncRSklsLvl = new int[][] { { 10, 25, 35, 30, 50, 100, 200, 500, 1000 } };
/* 1645 */   public static final String[] ncRSklsNms = new String[] { "" };
/* 1646 */   public static final String[] ncCSkls = new String[] { "", "BG", "SG" };
/* 1647 */   public static final String[] NCRacialSkillAbilityNames = new String[] { "", "Byakugan", "Sharingan" };
/*      */ 
/*      */   
/* 1650 */   public static int[][] NCRacialSkillTPCost = new int[Clans.length][], cNCRacialSkillTPCost = new int[Clans.length][];
/*      */   
/* 1652 */   public static int[][] NCRacialSkillMindCost = new int[Clans.length][]; public static int[][] cNCRacialSkillMindCost = new int[Clans.length][];
/*      */   
/* 1654 */   public static final String[] NCSkillIDs = new String[] { "TJ", "NJ", "GJ", "CC", "AF", "AD", "AL", "AE", "AW", "MN", "PU", "MD", "EG" };
/* 1655 */   public static final int[] ncSklsUps = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };
/*      */ 
/*      */ 
/*      */   
/* 1659 */   public static int[][] NCSkillTPCost = new int[NCSkillIDs.length][], cNCSkillTPCost = new int[NCSkillIDs.length][];
/*      */   
/* 1661 */   public static int[][] NCSkillMindCost = new int[NCSkillIDs.length][]; public static int[][] cNCSkillMindCost = new int[NCSkillIDs.length][];
/*      */   
/* 1663 */   public static final String[] NCSkillNames = new String[] { "Taijutsu", "Ninjutsu", "Genjutsu", "ChakraControl", "AffinityFire", "AffinityWind", "AffinityLightning", "AffinityEarth", "AffinityWater", "IryoNinjutsu", "PotentialUnlock", "Meditation", "EightGates" };
/*      */   
/* 1665 */   public static final String[] NCRankNames = new String[] { "", "Academy Student", "Genin", "Chunin", "Jonin", "Anbu", "Kage" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean SklSlt(int[] PlyrAttrbts, int h) {
/* 1674 */     return canAffordSkill(PlyrAttrbts[4], h);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String SklGveX(byte rc, byte cls, byte pwr) {
/* 1679 */     String ret = "pty";
/* 1680 */     if (pwr == 1) {
/* 1681 */       ret = vlblRSkls[0] + "0";
/* 1682 */     } else if (pwr == 2) {
/*      */     
/*      */     } 
/*      */     
/* 1686 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String SklGveY(byte rc, byte cls, byte pwr) {
/* 1691 */     String ret = "pty";
/* 1692 */     if (pwr == 1) {
/* 1693 */       if (rc == 1 || rc == 2) {
/* 1694 */         ret = "Sai";
/*      */       }
/*      */     }
/* 1697 */     else if (pwr == 2 && 
/* 1698 */       rc == 0 && ncCSkls[cls].length() > 0) {
/* 1699 */       ret = ncCSkls[cls] + "0";
/*      */     } 
/* 1701 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 1706 */   public static String[] tech1 = null;
/* 1707 */   public static String[] tech2 = null;
/* 1708 */   public static String[] tech3 = null;
/* 1709 */   public static String[] tech4 = null;
/* 1710 */   public static int[] techPM = null;
/*      */   
/*      */   public static String[] plyrs;
/*      */   
/* 1714 */   public static String[] data0 = null;
/* 1715 */   public static String[] data1 = null;
/* 1716 */   public static String[] data2 = null;
/* 1717 */   public static String[] data3 = null;
/* 1718 */   public static String[] data4 = null;
/* 1719 */   public static String[] data5 = null;
/* 1720 */   public static String[] data6 = null;
/* 1721 */   public static String[] data7 = null;
/* 1722 */   public static String[] data8 = null;
/* 1723 */   public static String[] data9 = null;
/* 1724 */   public static String[] dat10 = null;
/* 1725 */   public static String[] dat11 = null;
/* 1726 */   public static String[] dat12 = null;
/* 1727 */   public static String[] dat13 = null;
/* 1728 */   public static String[] dat14 = null;
/* 1729 */   public static String[] dat15 = null;
/* 1730 */   public static String[] dat16 = null;
/* 1731 */   public static String[] dat17 = null;
/* 1732 */   public static String[] dat18 = null;
/*      */   
/* 1734 */   public static String[] dat19 = null;
/* 1735 */   public static String[] dat20 = null;
/* 1736 */   public static String[] dat21 = null;
/* 1737 */   public static String[] dat22 = null;
/* 1738 */   public static String[] dat23 = null;
/* 1739 */   public static String[] dat24 = null;
/* 1740 */   public static String[] dat25 = null;
/* 1741 */   public static String[] dat26 = null;
/* 1742 */   public static String[] dat27 = null;
/* 1743 */   public static String[] dat28 = null;
/* 1744 */   public static String[] dat29 = null;
/* 1745 */   public static String[] dat30 = null;
/* 1746 */   public static String[] dat31 = null;
/* 1747 */   public static String[] dat32 = null;
/* 1748 */   public static String[] dat32Segmented = null; public static final int BPCH_Original = 0; public static final int BPCH_Previous = 1; public static final int BPCH_Current = 2; public static final int BPCH_ResetTime = 3;
/*      */   public static final int BPCH_TimeCurrent = 4;
/*      */   public static final int BPCH_TimePrevious = 5;
/*      */   
/*      */   public static String[] data(int i) {
/* 1753 */     switch (i) { case 0:
/* 1754 */         return data0;
/* 1755 */       case -1: return plyrs;
/* 1756 */       case 1: return data1;
/* 1757 */       case 2: return data2;
/* 1758 */       case 3: return data3;
/* 1759 */       case 4: return data4;
/* 1760 */       case 5: return data5;
/* 1761 */       case 6: return data6;
/* 1762 */       case 7: return data7;
/* 1763 */       case 8: return data8;
/* 1764 */       case 9: return data9;
/* 1765 */       case 10: return dat10;
/* 1766 */       case 11: return dat11;
/* 1767 */       case 12: return dat12;
/* 1768 */       case 13: return dat13;
/* 1769 */       case 14: return dat14;
/* 1770 */       case 15: return dat15;
/* 1771 */       case 16: return dat16;
/* 1772 */       case 17: return dat17;
/* 1773 */       case 18: return dat18;
/* 1774 */       case 19: return dat19;
/* 1775 */       case 20: return dat20;
/* 1776 */       case 21: return dat21;
/* 1777 */       case 22: return dat22;
/* 1778 */       case 23: return dat23;
/* 1779 */       case 24: return dat24;
/* 1780 */       case 25: return dat25;
/* 1781 */       case 26: return dat26;
/* 1782 */       case 27: return dat27;
/* 1783 */       case 28: return dat28;
/* 1784 */       case 29: return dat29;
/* 1785 */       case 30: return dat30;
/* 1786 */       case 31: return dat31;
/* 1787 */       case 32: return dat32; }
/* 1788 */      return plyrs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void rdc(String[] d, int c) {
/* 1797 */     if (c == 0) { data0 = d; }
/* 1798 */     else if (c == -1) { plyrs = d; }
/* 1799 */     else if (c == 1) { data1 = d; }
/* 1800 */     else if (c == 2) { data2 = d; }
/* 1801 */     else if (c == 3) { data3 = d; }
/* 1802 */     else if (c == 4) { data4 = d; }
/* 1803 */     else if (c == 5) { data5 = d; }
/* 1804 */     else if (c == 6) { data6 = d; }
/* 1805 */     else if (c == 7) { data7 = d; }
/* 1806 */     else if (c == 8) { data8 = d; }
/* 1807 */     else if (c == 9) { data9 = d; }
/* 1808 */     else if (c == 10) { dat10 = d; }
/* 1809 */     else if (c == 11) { dat11 = d; }
/* 1810 */     else if (c == 12) { dat12 = d; }
/* 1811 */     else if (c == 13) { dat13 = d; }
/* 1812 */     else if (c == 14) { dat14 = d; }
/* 1813 */     else if (c == 15) { dat15 = d; }
/* 1814 */     else if (c == 16) { dat16 = d; }
/* 1815 */     else if (c == 17) { dat17 = d; }
/* 1816 */     else if (c == 18) { dat18 = d; }
/* 1817 */     else if (c == 19) { dat19 = d; }
/* 1818 */     else if (c == 20) { dat20 = d; }
/* 1819 */     else if (c == 21) { dat21 = d; }
/* 1820 */     else if (c == 22) { dat22 = d; }
/* 1821 */     else if (c == 23) { dat23 = d; }
/* 1822 */     else if (c == 24) { dat24 = d; }
/* 1823 */     else if (c == 25) { dat25 = d; }
/* 1824 */     else if (c == 26) { dat26 = d; }
/* 1825 */     else if (c == 27) { dat27 = d; }
/* 1826 */     else if (c == 28) { dat28 = d; }
/* 1827 */     else if (c == 29) { dat29 = d; }
/* 1828 */     else if (c == 30) { dat30 = d; }
/* 1829 */     else if (c == 31) { dat31 = d; }
/* 1830 */     else if (c == 32) { dat32 = d; }
/*      */   
/*      */   }
/*      */   public static boolean dnn(int c) {
/* 1834 */     boolean b = false;
/* 1835 */     if (plyrs != null)
/* 1836 */       if (c == 0 && data0 != null && data0.length >= plyrs.length) { b = true; }
/* 1837 */       else if (c == -1 && plyrs != null) { b = true; }
/* 1838 */       else if (c == 1 && data1 != null && data1.length >= plyrs.length) { b = true; }
/* 1839 */       else if (c == 2 && data2 != null && data2.length >= plyrs.length) { b = true; }
/* 1840 */       else if (c == 3 && data3 != null && data3.length >= plyrs.length) { b = true; }
/* 1841 */       else if (c == 4 && data4 != null && data4.length >= plyrs.length) { b = true; }
/* 1842 */       else if (c == 5 && data5 != null && data5.length >= plyrs.length) { b = true; }
/* 1843 */       else if (c == 6 && data6 != null && data6.length >= plyrs.length) { b = true; }
/* 1844 */       else if (c == 7 && data7 != null && data7.length >= plyrs.length) { b = true; }
/* 1845 */       else if (c == 8 && data8 != null && data8.length >= plyrs.length) { b = true; }
/* 1846 */       else if (c == 9 && data9 != null && data9.length >= plyrs.length) { b = true; }
/* 1847 */       else if (c == 10 && dat10 != null && dat10.length >= plyrs.length) { b = true; }
/* 1848 */       else if (c == 11 && dat11 != null && dat11.length >= plyrs.length) { b = true; }
/* 1849 */       else if (c == 12 && dat12 != null && dat12.length >= plyrs.length) { b = true; }
/* 1850 */       else if (c == 13 && dat13 != null && dat13.length >= plyrs.length) { b = true; }
/* 1851 */       else if (c == 14 && dat14 != null && dat14.length >= plyrs.length) { b = true; }
/* 1852 */       else if (c == 15 && dat15 != null && dat15.length >= plyrs.length) { b = true; }
/* 1853 */       else if (c == 16 && dat16 != null && dat16.length >= plyrs.length) { b = true; }
/* 1854 */       else if (c == 17 && dat17 != null && dat17.length >= plyrs.length) { b = true; }
/* 1855 */       else if (c == 18 && dat18 != null && dat18.length >= plyrs.length) { b = true; }
/* 1856 */       else if (c == 19 && dat19 != null && dat19.length >= plyrs.length) { b = true; }
/* 1857 */       else if (c == 20 && dat20 != null && dat20.length >= plyrs.length) { b = true; }
/* 1858 */       else if (c == 21 && dat21 != null && dat21.length >= plyrs.length) { b = true; }
/* 1859 */       else if (c == 22 && dat22 != null && dat22.length >= plyrs.length) { b = true; }
/* 1860 */       else if (c == 23 && dat23 != null && dat23.length >= plyrs.length) { b = true; }
/* 1861 */       else if (c == 24 && dat24 != null && dat24.length >= plyrs.length) { b = true; }
/* 1862 */       else if (c == 25 && dat25 != null && dat25.length >= plyrs.length) { b = true; }
/* 1863 */       else if (c == 26 && dat26 != null && dat26.length >= plyrs.length) { b = true; }
/* 1864 */       else if (c == 27 && dat27 != null && dat27.length >= plyrs.length) { b = true; }
/* 1865 */       else if (c == 28 && dat28 != null && dat28.length >= plyrs.length) { b = true; }
/* 1866 */       else if (c == 29 && dat29 != null && dat29.length >= plyrs.length) { b = true; }
/* 1867 */       else if (c == 30 && dat30 != null && dat30.length >= plyrs.length) { b = true; }
/* 1868 */       else if (c == 31 && dat31 != null && dat31.length >= plyrs.length) { b = true; }
/* 1869 */       else if (c == 32 && dat32 != null && dat32.length >= plyrs.length) { b = true; }
/*      */        
/* 1871 */     return b;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String data(int i, String d) {
/* 1876 */     return data(mod_JRMCore.proxy.getPlayerClient().func_70005_c_(), i, d);
/*      */   }
/*      */   
/*      */   public static String data(String p, int i, String d) {
/* 1880 */     if (dnn(i)) {
/*      */       
/* 1882 */       HashMap<String, Integer> l = new HashMap<String, Integer>();
/* 1883 */       for (int j = 0; j < plyrs.length; j++) {
/* 1884 */         l.put(plyrs[j], Integer.valueOf(j));
/*      */       }
/* 1886 */       if (l.get(p) != null) return data(i)[((Integer)l.get(p)).intValue()];
/*      */     
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1893 */     return d;
/*      */   }
/*      */   
/*      */   public static String dataP(int i, String d) {
/* 1897 */     if (data(i) != null) {
/* 1898 */       return data(i)[0];
/*      */     }
/* 1900 */     return d;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String data(int p, int i, String d) {
/* 1905 */     if (dnn(i)) {
/* 1906 */       return data(i)[p];
/*      */     }
/* 1908 */     return d;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static long bpc(Entity e) {
/* 1914 */     if (e instanceof EntityCreature) {
/* 1915 */       int atr = (int)(((EntityCreature)e).func_110138_aP() / statInc(1, 2, 1, 0, 0, 0.0F));
/* 1916 */       long res = 1L;
/*      */       
/* 1918 */       res = (atr * 10 + atr * 4 + atr * 6 + atr * 10 + atr * 5);
/* 1919 */       res = (res < 2L) ? 2L : res;
/* 1920 */       if (BPMode == 1) {
/* 1921 */         res *= res / 2L;
/*      */       }
/* 1923 */       return (res < 1L) ? 1L : res;
/* 1924 */     }  if (e instanceof EntityPlayer) {
/* 1925 */       String[] s = data(e.func_70005_c_(), 0, "0;0;0").split(";");
/*      */ 
/*      */ 
/*      */       
/* 1929 */       long l = bpc((EntityPlayer)e, e.func_70005_c_());
/* 1930 */       return (l < 5L) ? 5L : l;
/*      */     } 
/* 1932 */     return 1L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long bpc(String p) {
/* 1939 */     return bpc(p, (byte)1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static long bpc(EntityPlayer player, String p) {
/* 1945 */     return bpc(player, p, (byte)1);
/*      */   }
/* 1947 */   public static long bpc(String p, byte pt) { return bpc(null, p, pt, -1); } public static long bpc(EntityPlayer player, String p, byte pt) {
/* 1948 */     return bpc(player, p, pt, -1);
/*      */   }
/*      */   public static long bpc(String playerID, byte powerType, int rl) {
/* 1951 */     return bpc(null, playerID, powerType, rl);
/*      */   }
/*      */   
/*      */   public static long bpc(EntityPlayer player, String playerID, byte powerType, int rl) {
/* 1955 */     long in = 1L;
/* 1956 */     if (dnn(1) && dnn(10) && dnn(2) && dnn(14) && dnn(6))
/*      */     {
/* 1958 */       for (int i = 0; i < plyrs.length; i++) {
/*      */         
/* 1960 */         if (playerID.equals(plyrs[i])) {
/*      */           
/* 1962 */           String[] d0 = data(playerID, 0, "0;0").split(";");
/* 1963 */           int alvc = Integer.parseInt(d0[0]);
/* 1964 */           int gp = Integer.parseInt(d0[1]);
/* 1965 */           String[] s = data1[i].split(";");
/* 1966 */           int pwr = Integer.parseInt(s[2]);
/* 1967 */           int race = Integer.parseInt(s[0]);
/*      */           
/* 1969 */           s = data6[i].split(";");
/* 1970 */           String sX = s[1];
/* 1971 */           String sY = s[2];
/* 1972 */           String sZ = s[3];
/* 1973 */           String[] PlyrSkills = s[0].split(",");
/*      */           
/* 1975 */           int cr = (rl >= 0) ? rl : Integer.parseInt(dat10[i].split(";")[0]);
/* 1976 */           int stam = Integer.parseInt(dat10[i].split(";")[1]);
/* 1977 */           int st = Integer.parseInt(data2[i].split(";")[0]);
/* 1978 */           int st2 = Integer.parseInt(data2[i].split(";")[1]);
/* 1979 */           int resrv = getArcRsrv(i);
/* 1980 */           String[] a = dat14[i].split(",");
/* 1981 */           int[] PlyrAttrbts = new int[a.length];
/* 1982 */           boolean mj = StusEfctsClient(12, i);
/* 1983 */           boolean lg = StusEfctsClient(14, i);
/* 1984 */           boolean kk = StusEfctsClient(5, i);
/* 1985 */           boolean mc = StusEfctsClient(13, i);
/* 1986 */           boolean vb = StusEfctsClient(17, i);
/* 1987 */           boolean mn = StusEfctsClient(19, i);
/* 1988 */           boolean gd = StusEfctsClient(20, i);
/* 1989 */           for (int i1 = 0; i1 < PlyrAttrbts.length; ) { PlyrAttrbts[i1] = Integer.parseInt(a[i1]); i1++; }
/* 1990 */            long sr = PlyrAttrbts[0];
/* 1991 */           long de = PlyrAttrbts[1];
/* 1992 */           long co = PlyrAttrbts[2];
/* 1993 */           long wi = PlyrAttrbts[3];
/* 1994 */           long mi = PlyrAttrbts[4];
/* 1995 */           long cc = PlyrAttrbts[5];
/* 1996 */           boolean c = (StusEfctsClient(10, i) || StusEfctsClient(11, i));
/* 1997 */           if (pwr == 1) {
/* 1998 */             boolean sgf = (SklLvl(9) > 0 || gp > 0 || vb);
/* 1999 */             if (JRMCoreHDBC.godKiUser(race, st) && !sgf) st = 0; 
/* 2000 */             String absorption = dnn(6) ? (getMajinAbsorptionValue(playerID) + "") : "0";
/*      */             
/* 2002 */             sr = getPlayerAttribute(player, PlyrAttrbts, 0, st, st2, race, sX, cr, resrv, lg, mj, kk, mc, mn, gd, 1, PlyrSkills, c, absorption);
/* 2003 */             de = getPlayerAttribute(player, PlyrAttrbts, 1, st, st2, race, sX, cr, resrv, lg, mj, kk, mc, mn, gd, 1, PlyrSkills, c, absorption);
/* 2004 */             wi = getPlayerAttribute(player, PlyrAttrbts, 3, st, st2, race, sX, cr, resrv, lg, mj, kk, mc, mn, gd, 1, PlyrSkills, c, absorption);
/*      */           } 
/* 2006 */           long f = sr + de + co;
/* 2007 */           long m = wi + mi + cc;
/* 2008 */           alvc++;
/* 2009 */           if (isPowerTypeKi(powerType)) {
/*      */             
/* 2011 */             long res = 0L;
/* 2012 */             res = sr * 10L + de * 4L + co * 6L + wi * 10L + cc * 5L;
/* 2013 */             res = (res < 2L) ? 2L : res;
/* 2014 */             if (BPMode == 1)
/* 2015 */               res = res / 2L * res / 100L * res / 100L; 
/* 2016 */             double re = cr * 0.01D;
/* 2017 */             res = (long)(res * re);
/* 2018 */             res = (res < 5L) ? 5L : res;
/*      */             
/* 2020 */             in = res;
/*      */             break;
/*      */           } 
/* 2023 */           if (isPowerTypeChakra(powerType)) {
/*      */             
/* 2025 */             int n = 0; byte b1;
/* 2026 */             for (b1 = 0; b1 < PlyrSkills.length; b1 = (byte)(b1 + 1)) {
/* 2027 */               String curSkl = PlyrSkills[b1];
/* 2028 */               if (curSkl.length() > 2 && !curSkl.contains("pty")) {
/* 2029 */                 n += Integer.parseInt(curSkl.substring(2)) * 5;
/*      */               }
/*      */             } 
/* 2032 */             float flt = 0.001388F;
/* 2033 */             int b = (int)(alvc * flt + (float)f + (float)m + n);
/* 2034 */             in = b;
/*      */           } 
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 2040 */     return in;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long time(double m) {
/* 2049 */     return (long)(System.currentTimeMillis() * 0.04D * m);
/*      */   }
/*      */   public static long gkap(long in, String p) {
/* 2052 */     return gkap(in, p, 40, 1.0D);
/*      */   }
/*      */   
/*      */   public static long gkap(long in, String p, int c, double m) {
/* 2056 */     Object[] ny = tacx.get(p);
/* 2057 */     if (ny != null) {
/* 2058 */       long bo = ((Long)ny[0]).longValue();
/* 2059 */       long bp = ((Long)ny[1]).longValue();
/* 2060 */       long bc = ((Long)ny[2]).longValue();
/* 2061 */       int br = ((Integer)ny[3]).intValue();
/* 2062 */       long btc = ((Long)ny[4]).longValue();
/* 2063 */       long btp = ((Long)ny[5]).longValue();
/* 2064 */       if (in != bo) {
/* 2065 */         bc = (bo - bp) / br;
/* 2066 */         long bt = btc - btp;
/* 2067 */         long bs = bt * bc + bp;
/* 2068 */         Object[] no = { Long.valueOf(in), Long.valueOf(bs), Long.valueOf(bc), Integer.valueOf(c), Long.valueOf(time(m)), Long.valueOf(time(m)) };
/* 2069 */         tacx.put(p, no);
/* 2070 */         return bs;
/*      */       } 
/* 2072 */       if (btp + br <= time(m)) {
/* 2073 */         Object[] no = { Long.valueOf(in), Long.valueOf(bo), Long.valueOf(in), Integer.valueOf(c), Long.valueOf(time(m)), Long.valueOf(time(m)) };
/* 2074 */         tacx.put(p, no);
/*      */       } else {
/* 2076 */         bc = (bo - bp) / br;
/* 2077 */         long bt = btc - btp;
/* 2078 */         long bs = bt * bc + bp;
/* 2079 */         Object[] no = { Long.valueOf(in), Long.valueOf(bp), Long.valueOf(bc), Integer.valueOf(c), Long.valueOf(time(m)), Long.valueOf(btp) };
/* 2080 */         tacx.put(p, no);
/* 2081 */         return bs;
/*      */       } 
/*      */     } else {
/* 2084 */       Object[] no = { Long.valueOf(in), Long.valueOf(in), Long.valueOf(in), Integer.valueOf(c), Long.valueOf(time(m)), Long.valueOf(time(m)) };
/* 2085 */       tacx.put(p, no);
/*      */     } 
/* 2087 */     return in;
/*      */   }
/*      */ 
/*      */   
/* 2091 */   private static HashMap<String, Object[]> tacx = (HashMap)new HashMap<String, Object>();
/* 2092 */   public static final String[] techNbt = new String[] { "jrmcTech1", "jrmcTech2", "jrmcTech3", "jrmcTech4", "jrmcTech5", "jrmcTech6", "jrmcTech7", "jrmcTech8", "jrmcTech9" };
/*      */ 
/*      */   
/*      */   public static final String techNbtLearn = "jrmcTechLearn";
/*      */   
/*      */   public static final short TransSaiMxRg = 100;
/*      */   
/*      */   public static final String TransSaiRgNbt = "jrmcSaiRg";
/*      */   
/*      */   public static final String ArcRsrvNbt = "jrmcArcRsrv";
/*      */   
/* 2103 */   public static final int[] ArcRsrvGrowth = new int[] { 6, 4, 2, 1, 0, 0, 0, 0, 0, 0, 0 };
/*      */   
/* 2105 */   public static final int[] ArcRsrvMaxSkll = new int[] { 0, 500, 1000, 1000, 1500, 2000, 2500 };
/*      */ 
/*      */   
/*      */   public static int updateArcosianPowerPoints(int resrv, String SklX, int st, int stateID) {
/* 2109 */     int skl = SklLvlX(1, SklX) - 1;
/* 2110 */     skl = (skl < 0) ? 0 : skl;
/* 2111 */     int arg = (int)(JRMCoreConfig.ArcosianPPGrowth[stateID] * JRMCoreConfig.appm);
/* 2112 */     return (resrv + arg > JRMCoreConfig.ArcosianPPMax[skl]) ? JRMCoreConfig.ArcosianPPMax[skl] : (resrv + arg);
/*      */   }
/*      */   
/*      */   public static int updateArcosianPowerPoints(int resrv, String SklX, int st, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 2116 */     int stateID = getArcosianFormID(st, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 2117 */     return updateArcosianPowerPoints(resrv, SklX, st, stateID);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int ArcRsrvMaxSkll(int resrv, String SklX, int st) {
/* 2122 */     return updateArcosianPowerPoints(resrv, SklX, st, st);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getArcRsrv(int pl) {
/* 2129 */     return (dnn(13) && dat13.length > pl) ? Integer.parseInt(dat13[pl].split(";")[2]) : 0;
/*      */   }
/*      */   public static int getArcRsrvID(String id) {
/* 2132 */     for (int pl = 0; pl < plyrs.length; pl++) {
/* 2133 */       if (plyrs[pl].equals(id) && dnn(13)) {
/* 2134 */         return Integer.parseInt(dat13[pl].split(";")[2]);
/*      */       }
/*      */     } 
/* 2137 */     return 0;
/*      */   }
/*      */   
/*      */   public static int getArcRsrv() {
/* 2141 */     return getArcRsrvID(mod_JRMCore.proxy.getPlayerClient().func_70005_c_());
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getArcosianPowerPointBoost(int curentPow, int state, int currentRelease, int currentReserv, int stateID) {
/* 2146 */     if (state > 3 && currentRelease == 100 && currentReserv > 0) {
/*      */       
/* 2148 */       boolean addPointValue = (JRMCoreConfig.ArcosianPPDamMultiPoint[stateID] != -1.0F);
/*      */       
/* 2150 */       int result = (int)(curentPow * JRMCoreConfig.ArcosianPPDamMulti[stateID] * (addPointValue ? (1.0F + getArcosianReserveMaxPointPercentage(currentReserv) * JRMCoreConfig.ArcosianPPDamMultiPoint[stateID]) : 1.0F));
/* 2151 */       return result;
/*      */     } 
/* 2153 */     return curentPow;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int ArcRsrvPowBst(int curentPow, int state, int currentRelease, int currentReserv) {
/* 2158 */     return getArcosianPowerPointBoost(curentPow, state, currentRelease, currentReserv, state);
/*      */   }
/*      */   
/*      */   public static float getArcosianReserveMaxPointPercentage(int currentReserv) {
/* 2162 */     float highest = JRMCoreConfig.ArcosianPPMax[JRMCoreConfig.ArcosianPPDamMultiHighest];
/* 2163 */     return currentReserv / highest;
/*      */   }
/* 2165 */   public static int[] ArcRsrvPowCst = new int[] { 0, 0, 0, 0, 20, 30, 60, 90, 70, 100, 100 };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMajinAbsorptionValueS(String absorptionData) {
/* 2171 */     String[] data = absorptionData.split(",");
/* 2172 */     String value = (data.length >= 3) ? data[0] : absorptionData;
/* 2173 */     return Integer.parseInt(value);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getMajinAbsorptionID(String playerName) {
/* 2179 */     if (dnn(13)) {
/* 2180 */       for (int pl = 0; pl < plyrs.length; pl++) {
/* 2181 */         if (plyrs.length > pl && plyrs[pl] != null && plyrs[pl].equals(playerName) && dat13.length > pl && dat13[pl] != null) {
/* 2182 */           String[] data = dat13[pl].split(";");
/* 2183 */           if (data.length > 3) {
/* 2184 */             return data[3];
/*      */           }
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 2190 */     return "0";
/*      */   }
/*      */   
/*      */   public static int getMajinAbsorptionValue(String playerName) {
/* 2194 */     String data = getMajinAbsorptionID(playerName);
/* 2195 */     return Integer.parseInt(data.split(",")[0]);
/*      */   }
/*      */   
/*      */   public static String getMajinAbsorption() {
/* 2199 */     return getMajinAbsorptionID(mod_JRMCore.proxy.getPlayerClient().func_70005_c_());
/*      */   }
/*      */   
/*      */   public static int getMajinAbsorptionValue() {
/* 2203 */     String data = getMajinAbsorptionID(mod_JRMCore.proxy.getPlayerClient().func_70005_c_());
/* 2204 */     return Integer.parseInt(data.split(",")[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2210 */   public static byte TransSaiCurRg = 0;
/*      */ 
/*      */   
/*      */   public static boolean rSai(int r) {
/* 2214 */     return isRaceSaiyan(r);
/*      */   }
/*      */   
/*      */   public static boolean rSai() {
/* 2218 */     if (Race == 1 || Race == 2) return true; 
/* 2219 */     return false;
/*      */   }
/*      */   public static boolean tailHas(int r) {
/* 2222 */     return (r != 2 && r != 3 && r != 4);
/*      */   }
/*      */ 
/*      */   
/* 2226 */   public static float[][] TransSaiStBnP = new float[11][];
/* 2227 */   public static float[][] TransSaiStBnPO = new float[11][];
/*      */ 
/*      */   
/* 2230 */   public static int[][] TransSaiStBnF = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 30, 30, 0, 30, 0, 0 }, { 50, 50, 0, 50, 0, 0 }, { 60, 45, 0, 60, 0, 0 }, { 45, 45, 0, 45, 0, 0 }, { 75, 75, 0, 75, 0, 0 }, { 100, 100, 0, 100, 0, 0 }, { 20, 20, 0, 20, 0, 0 }, { 50, 50, 0, 50, 0, 0 }, { 110, 110, 0, 110, 0, 0 }, { 150, 150, 0, 150, 0, 0 }, { 130, 130, 0, 130, 0, 0 }, { 80, 80, 0, 80, 0, 0 }, { 110, 110, 0, 110, 0, 0 }, { 115, 115, 0, 115, 0, 0 }, { 160, 160, 0, 160, 0, 0 } };
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
/* 2249 */   public static float[][] TransHalfSaiStBnP = new float[11][];
/* 2250 */   public static float[][] TransHalfSaiStBnPO = new float[11][];
/*      */ 
/*      */   
/* 2253 */   public static int[][] TransHalfSaiStBnF = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 30, 30, 0, 30, 0, 0 }, { 50, 50, 0, 50, 0, 0 }, { 60, 45, 0, 60, 0, 0 }, { 45, 45, 0, 45, 0, 0 }, { 75, 75, 0, 75, 0, 0 }, { 100, 100, 0, 100, 0, 0 }, { 20, 20, 0, 20, 0, 0 }, { 50, 50, 0, 50, 0, 0 }, { 110, 110, 0, 110, 0, 0 }, { 150, 150, 0, 150, 0, 0 }, { 130, 130, 0, 130, 0, 0 }, { 80, 80, 0, 80, 0, 0 }, { 110, 110, 0, 110, 0, 0 }, { 115, 115, 0, 115, 0, 0 }, { 160, 160, 0, 160, 0, 0 } };
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
/* 2272 */   public static float[][] TransFrStBnP = new float[10][];
/* 2273 */   public static float[][] TransFrStBnPO = new float[10][];
/*      */ 
/*      */   
/* 2276 */   public static int[][] TransFrStBnF = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 150, 150, 0, 150, 0, 0 } };
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
/* 2289 */   public static float[][] TransHmStBnP = new float[10][];
/* 2290 */   public static float[][] TransHmStBnPO = new float[10][];
/*      */ 
/*      */   
/* 2293 */   public static int[][] TransHmStBnF = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 120, 120, 0, 120, 0, 0 } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2302 */   public static float[][] TransNaStBnP = new float[10][];
/* 2303 */   public static float[][] TransNaStBnPO = new float[10][];
/*      */ 
/*      */   
/* 2306 */   public static int[][] TransNaStBnF = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 120, 120, 0, 120, 0, 0 } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2314 */   public static float[][] TransMaStBnP = new float[10][];
/* 2315 */   public static float[][] TransMaStBnPO = new float[10][];
/*      */ 
/*      */   
/* 2318 */   public static int[][] TransMaStBnF = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 120, 120, 0, 120, 0, 0 } };
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
/* 2348 */   public static float[][] DoujutsuPowerBonusMulti = new float[][] { { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F }, { 1.1F, 1.1F, 1.1F, 1.1F, 1.0F, 1.0F }, { 1.2F, 1.2F, 1.2F, 1.2F, 1.0F, 1.0F }, { 1.3F, 1.3F, 1.3F, 1.3F, 1.0F, 1.0F }, { 1.4F, 1.4F, 1.4F, 1.4F, 1.0F, 1.0F }, { 1.5F, 1.5F, 1.5F, 1.5F, 1.0F, 1.0F }, { 1.6F, 1.6F, 1.6F, 1.6F, 1.0F, 1.0F }, { 1.7F, 1.7F, 1.7F, 1.7F, 1.0F, 1.0F }, { 1.8F, 1.8F, 1.8F, 1.8F, 1.0F, 1.0F }, { 1.9F, 1.9F, 1.9F, 1.9F, 1.0F, 1.0F } };
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
/* 2360 */   public static int[][] DoujutsuPowerBonusFlat = new int[][] { { 1, 1, 0, 1, 0, 0 }, { 2, 3, 0, 2, 0, 0 }, { 3, 4, 0, 3, 0, 0 }, { 3, 5, 0, 3, 0, 0 }, { 4, 6, 0, 4, 0, 0 }, { 5, 8, 0, 5, 0, 0 }, { 6, 10, 0, 6, 0, 0 }, { 7, 11, 0, 7, 0, 0 }, { 8, 13, 0, 8, 0, 0 }, { 9, 15, 0, 9, 0, 0 } };
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
/*      */   public static final String TransNms(int i1, int i2, boolean v, boolean my, boolean ui) {
/* 2376 */     return getTransformationName(i1, i2, v, my, ui, false);
/*      */   }
/*      */   
/*      */   public static final String getTransformationName(int i1, int i2, boolean v, boolean my, boolean ui, boolean gd) {
/* 2380 */     if (my) return "PotUnleashed"; 
/* 2381 */     if (ui) return "UInstinct"; 
/* 2382 */     if (gd) return (rc_sai(i1) && isAprilFoolsModeOn()) ? "UltraEgo" : "GoDestruction";
/*      */     
/* 2384 */     if (rc_sai(i1) && i2 == 10 && v) return "SuperR";
/*      */     
/* 2386 */     if (rc_sai(i1) && i2 == 15 && v) return "SuperRS"; 
/* 2387 */     if (rc_sai(i1) && TransNms[i1][i2].equals("Super4") && isAprilFoolsModeOn()) return "Super5"; 
/* 2388 */     if (rc_sai(i1) && TransNms[i1][i2].equals("Super") && isAprilFoolsModeOn()) return "SuperFalse"; 
/* 2389 */     return TransNms[i1][i2];
/*      */   }
/*      */   
/* 2392 */   public static final String[][] TransNms = new String[][] { { "Base", "HForm1", "HForm2", "HFormG" }, { "Base", "Super", "SuperG2", "SuperG3", "SuperFP", "Super2", "Super3", "Oozaru", "OozaruS", "SuperG", "SuperB", "SuperGR", "SuperL", "SuperLB", "Super4", "SuperBS" }, { "Base", "Super", "SuperG2", "SuperG3", "SuperFP", "Super2", "Super3", "Oozaru", "OozaruS", "SuperG", "SuperB", "SuperGR", "SuperL", "SuperLB", "Super4", "SuperBS" }, { "Base", "NForm1", "NForm2", "NFormG" }, { "Form0", "Form1", "Form2", "Form3", "Base", "Form5", "Form6", "FormG" }, { "Base", "MForm1", "MForm2", "MForm3", "MFormG" } };
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
/* 2403 */   public static final String[][] trans = new String[][] { { "Base", "Full", "Buffed", "God" }, { "Base", "SS", "SSG2", "SSG3", "SSFullPow", "SS2", "SS3", "Oozaru", "Golden", "SSGod", "SSB", "SSGodR", "LSS", "LSS2", "SS4", "SSBE" }, { "Base", "SS", "SSG2", "SSG3", "SSFullPow", "SS2", "SS3", "Oozaru", "Golden", "SSGod", "SSB", "SSGodR", "LSS", "LSS2", "SS4", "SSBE" }, { "Base", "Full", "Giant", "God" }, { "Form0", "Form1", "Form2", "Form3", "Base", "Form5", "Ultimate", "God" }, { "Base", "Evil", "Full", "Pure", "God" } };
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
/* 2414 */   public static final String[][] TransNmsM = new String[][] { { "Base", "Full", "Buffed", "God" }, { "Base", "SS", "SSG2", "SSG3", "SS", "SS2", "SS3", "Oozaru", "Golden", "SSGod", "SSB", "SSGodR", "SS", "SS2", "SS4", "SSBE" }, { "Base", "SS", "SSG2", "SSG3", "SS", "SS2", "SS3", "Oozaru", "Golden", "SSGod", "SSB", "SSGodR", "SS", "SS2", "SS4", "SSBE" }, { "Base", "Full", "Giant", "God" }, { "Form0", "Form1", "Form2", "Form3", "Base", "Form5", "Ultimate", "God" }, { "Base", "Evil", "Full", "Pure", "God" } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2424 */   public static final byte[][] transformationDescendToFormID = new byte[][] { { 0, 0, 0, 0 }, { 0, 0, 1, 2, 0, 4, 5, 0, 0, 0, 9, 0, 0, 0, 0, 10 }, { 0, 0, 1, 1, 0, 1, 5, 0, 0, 0, 9, 0, 0, 0, 0, 10 }, { 0, 0, 0, 0 }, { 0, 0, 1, 2, 3, 4, 4, 4 }, { 0, 0, 0, 0, 0 } };
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
/*      */   public static byte getTransformationDescendToFormID(byte race, byte state, boolean hasFullPowerSSJ) {
/* 2449 */     byte result = transformationDescendToFormID[race][state];
/* 2450 */     if (isRaceSaiyan(race) && (result == 1 || result == 4)) {
/* 2451 */       result = (byte)(hasFullPowerSSJ ? 4 : 1);
/*      */     }
/* 2453 */     return result;
/*      */   }
/*      */   
/*      */   public static boolean isSaiyanSuperFullPower(NBTTagCompound nbt) {
/* 2457 */     String s1 = nbt.func_74779_i("jrmcSSltX");
/* 2458 */     int racialSkillLevel = SklLvlX(1, s1);
/* 2459 */     return (racialSkillLevel >= 5);
/*      */   }
/*      */ 
/*      */   
/* 2463 */   public static final String[] majinRacialSkillNames = new String[] { "SuperRegeneration", "Evil", "Full", "Absorption", "Pure" }; public static final String trans_KAIOKEN = "Kaioken";
/*      */   public static final String trans_MYSTIC = "Mystic";
/*      */   public static final String trans_ULTRA_INSTINCT = "UltraInstict";
/*      */   public static final String trans_GOD_OF_DESTRUCTION = "GodOfDestruction";
/*      */   public static final int trans_KAIOKEN_ID = 0;
/*      */   public static final int trans_MYSTIC_ID = 1;
/*      */   public static final int trans_UI_ID = 2;
/*      */   public static final int trans_GOD_ID = 3;
/* 2471 */   public static final String[] transNonRacial = new String[] { "Kaioken", "Mystic", "UltraInstict", "GodOfDestruction" };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getNBTFormMasteryRacialKey(int race) {
/* 2477 */     return "jrmcFormMasteryRacial_" + Races[race];
/*      */   } public static String[] getNBTFormMasteryRacialKeys(int race) {
/* 2479 */     String[] NBT = { getNBTFormMasteryRacialKey(race), "jrmcFormMasteryNonRacial" };
/* 2480 */     return NBT;
/*      */   }
/*      */   public static String getNBTFormMasteryRacialKey(boolean racial, int race) {
/* 2483 */     String[] NBT = { getNBTFormMasteryRacialKey(race), "jrmcFormMasteryNonRacial" };
/* 2484 */     return NBT[racial ? 0 : 1];
/*      */   }
/*      */   
/*      */   public static boolean hasNBTFormMasteryRacial(NBTTagCompound nbt) {
/* 2488 */     int race = nbt.func_74771_c("jrmcRace");
/* 2489 */     String nbtKey = getNBTFormMasteryRacialKey(race);
/* 2490 */     return (nbt.func_74764_b(nbtKey) || nbt.func_74779_i(nbtKey).equals("Base,0"));
/*      */   }
/*      */   public static boolean hasNBTFormMasteryNonRacial(NBTTagCompound nbt) {
/* 2493 */     return (nbt.func_74764_b("jrmcFormMasteryNonRacial") || nbt.func_74779_i("jrmcFormMasteryNonRacial").equals("Kaioken,0") || nbt
/* 2494 */       .func_74779_i("jrmcFormMasteryNonRacial").equals("Base,0"));
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getDefaultFormMasteryRacialText(int race) {
/* 2499 */     String mastery = "";
/* 2500 */     int length = (trans[race]).length;
/* 2501 */     for (int i = 0; i < length; i++) {
/* 2502 */       mastery = mastery + trans[race][i] + ",0" + ((i + 1 < length) ? ";" : "");
/*      */     }
/* 2504 */     return mastery;
/*      */   }
/*      */   
/*      */   public static String getDefaultFormMasteryNonRacialText() {
/* 2508 */     String mastery = "";
/* 2509 */     int length = transNonRacial.length;
/* 2510 */     for (int i = 0; i < length; i++) {
/* 2511 */       mastery = mastery + transNonRacial[i] + ",0" + ((i + 1 < length) ? ";" : "");
/*      */     }
/* 2513 */     return mastery;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getFormID(String formID, int race, boolean addRacials) {
/* 2518 */     int i = 0;
/* 2519 */     for (String form : transNonRacial) {
/* 2520 */       if (formID.equals(form)) return i + (addRacials ? (trans[race]).length : 0); 
/* 2521 */       i++;
/*      */     } 
/* 2523 */     i = 0;
/* 2524 */     for (String form : trans[race]) {
/* 2525 */       if (formID.equals(form)) return i; 
/* 2526 */       i++;
/*      */     } 
/* 2528 */     return 0;
/*      */   }
/*      */   
/*      */   public static int getFormID(String formID, int race) {
/* 2532 */     return getFormID(formID, race, true);
/*      */   }
/*      */   
/*      */   public static boolean isCurrentFormID(String checkedFormID, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 2536 */     if (state2 > 0) {
/* 2537 */       if (isKaiokenOn && checkedFormID.equals("Kaioken")) return true; 
/* 2538 */       if (isUltraInstinctOn && checkedFormID.equals("UltraInstict")) return true; 
/*      */     } 
/* 2540 */     if (isMysticOn && checkedFormID.equals("Mystic")) return true; 
/* 2541 */     if (isGoDOn && checkedFormID.equals("GodOfDestruction")) return true;
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
/* 2565 */     return false;
/*      */   }
/*      */   
/*      */   public static String getCurrentFormName(int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 2569 */     int baseState = isRaceArcosian(race) ? 4 : 0;
/* 2570 */     String currentFormID = "";
/*      */     
/* 2572 */     if (isMysticOn)
/* 2573 */     { currentFormID = transNonRacial[1]; }
/*      */     
/* 2575 */     else if (isGoDOn)
/* 2576 */     { currentFormID = transNonRacial[3]; }
/*      */     
/* 2578 */     else if (state == baseState && !isUltraInstinctOn) { currentFormID = "Base"; }
/* 2579 */     else if (state > baseState || (isRaceArcosian(race) && state < baseState && !isUltraInstinctOn))
/* 2580 */     { currentFormID = trans[race][state]; }
/*      */     
/* 2582 */     else if (state2 > 0)
/* 2583 */     { if (isKaiokenOn) {
/* 2584 */         currentFormID = transNonRacial[0];
/*      */       }
/* 2586 */       else if (isUltraInstinctOn) {
/* 2587 */         currentFormID = transNonRacial[2];
/*      */       } else {
/* 2589 */         currentFormID = trans[race][state];
/*      */       }  }
/*      */     
/* 2592 */     return currentFormID;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getCurrentFormID(int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 2597 */     int baseState = isRaceArcosian(race) ? 4 : 0;
/*      */     
/* 2599 */     int currentFormID = 0;
/*      */     
/* 2601 */     if (isMysticOn) {
/* 2602 */       currentFormID = (trans[race]).length + 1;
/*      */     }
/* 2604 */     else if (isGoDOn) {
/* 2605 */       currentFormID = (trans[race]).length + 3;
/*      */     }
/* 2607 */     else if (state == baseState && !isUltraInstinctOn) {
/* 2608 */       currentFormID = baseState;
/*      */     }
/* 2610 */     else if (state > baseState || (isRaceArcosian(race) && state < baseState && !isUltraInstinctOn)) {
/* 2611 */       currentFormID = state;
/*      */     }
/* 2613 */     else if (state2 > 0) {
/* 2614 */       if (isKaiokenOn) {
/* 2615 */         currentFormID = (trans[race]).length + 0;
/*      */       }
/* 2617 */       else if (isUltraInstinctOn) {
/* 2618 */         currentFormID = (trans[race]).length + 2;
/*      */       } else {
/*      */         
/* 2621 */         currentFormID = state;
/*      */       } 
/*      */     } 
/*      */     
/* 2625 */     return currentFormID;
/*      */   }
/*      */   
/*      */   public static boolean isCurrentFormRacial(int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 2629 */     int baseState = isRaceArcosian(race) ? 4 : 0;
/* 2630 */     if (isMysticOn || isGoDOn) return false; 
/* 2631 */     if (state2 > 0 && (isKaiokenOn || isUltraInstinctOn)) return false; 
/* 2632 */     if (state == baseState && !isUltraInstinctOn) return true; 
/* 2633 */     if (state > 0) return true; 
/* 2634 */     return true;
/*      */   }
/*      */   
/*      */   public static void updateFormMasteryVersion(NBTTagCompound nbt) {
/* 2638 */     if (nbt.func_74764_b("jrmcFormMasteryRacial")) {
/* 2639 */       String mastery = nbt.func_74779_i("jrmcFormMasteryRacial");
/* 2640 */       if (mastery != null && mastery.length() > 0) {
/*      */         
/* 2642 */         int oldMasteryRace = -1;
/* 2643 */         String[] masteryData = mastery.split(";");
/*      */         
/* 2645 */         int races = Races.length;
/* 2646 */         for (int raceID = 0; raceID < races; raceID++) {
/* 2647 */           int forms = (trans[raceID]).length;
/* 2648 */           if (forms == masteryData.length) {
/* 2649 */             boolean sameForms = true;
/* 2650 */             for (int formID = 0; formID < forms; formID++) {
/* 2651 */               String formName = masteryData[formID].split(",")[0];
/* 2652 */               if (!formName.equals(trans[raceID][formID])) {
/* 2653 */                 sameForms = false;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/* 2658 */             if (sameForms) {
/* 2659 */               nbt.func_74778_a(getNBTFormMasteryRacialKey(raceID), mastery);
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 2665 */       nbt.func_82580_o("jrmcFormMasteryRacial");
/*      */     } 
/*      */   }
/*      */   
/*      */   public static String convertFormMasteryToFormat(String formMastery, String decimalFormat) {
/* 2670 */     DecimalFormat format = new DecimalFormat(decimalFormat);
/* 2671 */     String[] data = formMastery.split(";");
/* 2672 */     String newFormMastery = "";
/* 2673 */     for (int i = 0; i < data.length; i++) {
/* 2674 */       String[] values = data[i].split(",");
/* 2675 */       double value = Double.parseDouble(format.format(Double.parseDouble(values[1])).replace(",", "."));
/* 2676 */       newFormMastery = newFormMastery + values[0] + "," + ((value == (int)value) ? ((int)value + "") : (String)Double.valueOf(value)) + ((i + 1 < data.length) ? ";" : "");
/*      */     } 
/*      */     
/* 2679 */     return newFormMastery;
/*      */   }
/*      */   
/*      */   public static String getFormMasteryData(EntityPlayer player) {
/* 2683 */     return getFormMasteryData(player, "");
/*      */   }
/*      */   public static String getFormMasteryData(EntityPlayer player, String decimalFormat) {
/* 2686 */     if (player != null && player.field_70170_p != null) {
/*      */       
/* 2688 */       if (!player.field_70170_p.field_72995_K) {
/* 2689 */         JGPlayerMP jgPlayer = new JGPlayerMP(player);
/* 2690 */         jgPlayer.connectBaseNBT();
/* 2691 */         String mastery = "";
/* 2692 */         updateFormMasteryVersion(jgPlayer.getNBT());
/*      */         
/* 2694 */         if (isFused((Entity)player)) {
/*      */           
/* 2696 */           String Fzn = jgPlayer.getNBT().func_74779_i("jrmcFuzion");
/*      */           
/* 2698 */           if (Fzn.contains(",")) {
/* 2699 */             String[] FznA = Fzn.split(",");
/*      */             
/* 2701 */             if (FznA.length == 3) {
/*      */               
/* 2703 */               MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 2704 */               EntityPlayerMP entityPlayerMP1 = getPlayerForUsername(server, FznA[0]);
/* 2705 */               EntityPlayerMP entityPlayerMP2 = getPlayerForUsername(server, FznA[1]);
/*      */               
/* 2707 */               if (entityPlayerMP1 != null && entityPlayerMP2 != null) {
/*      */ 
/*      */                 
/* 2710 */                 jgPlayer = new JGPlayerMP((EntityPlayer)entityPlayerMP1);
/* 2711 */                 jgPlayer.connectBaseNBT();
/* 2712 */                 if (!hasNBTFormMasteryRacial(jgPlayer.getNBT())) {
/* 2713 */                   mastery = mastery + getDefaultFormMasteryRacialText(jgPlayer.getRace());
/*      */                 } else {
/* 2715 */                   mastery = mastery + jgPlayer.getNBT().func_74779_i(getNBTFormMasteryRacialKey(jgPlayer.getRace()));
/*      */                 } 
/* 2717 */                 mastery = mastery + ";";
/*      */                 
/* 2719 */                 if (!hasNBTFormMasteryNonRacial(jgPlayer.getNBT())) {
/* 2720 */                   mastery = mastery + getDefaultFormMasteryNonRacialText();
/*      */                 } else {
/* 2722 */                   mastery = mastery + jgPlayer.getNBT().func_74779_i("jrmcFormMasteryNonRacial");
/*      */                 } 
/*      */ 
/*      */                 
/* 2726 */                 JGPlayerMP jgPlayerPartner = new JGPlayerMP((EntityPlayer)entityPlayerMP2);
/* 2727 */                 jgPlayerPartner.connectBaseNBT();
/* 2728 */                 if (jgPlayerPartner.getRace() == jgPlayer.getRace()) {
/*      */                   
/* 2730 */                   updateFormMasteryVersion(jgPlayerPartner.getNBT());
/*      */                   
/* 2732 */                   String masteryPartner = "";
/* 2733 */                   if (!hasNBTFormMasteryRacial(jgPlayerPartner.getNBT())) {
/* 2734 */                     masteryPartner = masteryPartner + getDefaultFormMasteryRacialText(jgPlayerPartner.getRace());
/*      */                   } else {
/* 2736 */                     masteryPartner = masteryPartner + jgPlayerPartner.getNBT().func_74779_i(getNBTFormMasteryRacialKey(jgPlayer.getRace()));
/*      */                   } 
/* 2738 */                   masteryPartner = masteryPartner + ";";
/*      */                   
/* 2740 */                   if (!hasNBTFormMasteryNonRacial(jgPlayerPartner.getNBT())) {
/* 2741 */                     masteryPartner = masteryPartner + getDefaultFormMasteryNonRacialText();
/*      */                   } else {
/* 2743 */                     masteryPartner = masteryPartner + jgPlayerPartner.getNBT().func_74779_i("jrmcFormMasteryNonRacial");
/*      */                   } 
/* 2745 */                   String[] p1Mastery = mastery.split(";");
/* 2746 */                   String[] p2Mastery = masteryPartner.split(";");
/* 2747 */                   mastery = "";
/* 2748 */                   int length = p1Mastery.length;
/* 2749 */                   int length2 = p2Mastery.length;
/* 2750 */                   if (length == length2) {
/* 2751 */                     for (int i = 0; i < length; i++) {
/* 2752 */                       String[] values = p1Mastery[i].split(",");
/* 2753 */                       String[] values2 = p2Mastery[i].split(",");
/*      */ 
/*      */                       
/* 2756 */                       double result = (Double.parseDouble(values[1]) + Double.parseDouble(values2[1])) * 1.0D;
/* 2757 */                       mastery = mastery + values[0] + "," + result + ((i + 1 < length) ? ";" : "");
/*      */                     } 
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2767 */         if (mastery == null || mastery.length() == 0) {
/* 2768 */           mastery = "";
/* 2769 */           if (!hasNBTFormMasteryRacial(jgPlayer.getNBT())) {
/* 2770 */             mastery = mastery + getDefaultFormMasteryRacialText(jgPlayer.getRace());
/*      */           } else {
/* 2772 */             mastery = mastery + jgPlayer.getNBT().func_74779_i(getNBTFormMasteryRacialKey(jgPlayer.getRace()));
/*      */           } 
/* 2774 */           mastery = mastery + ";";
/*      */           
/* 2776 */           if (!hasNBTFormMasteryRacial(jgPlayer.getNBT())) {
/* 2777 */             mastery = mastery + getDefaultFormMasteryNonRacialText();
/*      */           } else {
/* 2779 */             mastery = mastery + jgPlayer.getNBT().func_74779_i("jrmcFormMasteryNonRacial");
/*      */           } 
/*      */         } 
/* 2782 */         return (decimalFormat == null || decimalFormat.length() == 0) ? mastery : convertFormMasteryToFormat(mastery, decimalFormat);
/*      */       } 
/*      */       
/* 2785 */       if (dnn(32) && plyrs != null) {
/* 2786 */         String playerName = mod_JRMCore.proxy.getPlayerClient().func_70005_c_();
/* 2787 */         if (playerName == null || playerName.length() == 0) return "";
/*      */         
/* 2789 */         for (int pl = 0; pl < plyrs.length; pl++) {
/*      */ 
/*      */           
/* 2792 */           if (plyrs[pl] != null && plyrs[pl].equals(playerName)) {
/*      */             
/* 2794 */             if (dat32 != null && dat32.length > pl)
/*      */             {
/* 2796 */               return dat32[pl];
/*      */             }
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2804 */     return "Base,0";
/*      */   }
/*      */   
/*      */   public static String getFormMasteryData() {
/* 2808 */     String data = getFormMasteryData(mod_JRMCore.proxy.getPlayerClient());
/* 2809 */     if (data != null && data.length() > 0 && data.contains(";")) {
/* 2810 */       int race = Race;
/* 2811 */       int state = State;
/* 2812 */       int state2 = State2;
/* 2813 */       boolean isKaiokenOn = StusEfctsMe(5);
/* 2814 */       boolean isMysticOn = StusEfctsMe(13);
/* 2815 */       boolean isUltraInstinctOn = StusEfctsMe(19);
/* 2816 */       boolean isGoDOn = StusEfctsMe(20);
/* 2817 */       int formID = getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 2818 */       String[] dataArray = data.split(";");
/* 2819 */       if (dataArray.length > formID) return dataArray[formID]; 
/*      */     } 
/* 2821 */     return "Base,0";
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getFormMasteryData(EntityPlayer player, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 2826 */     String data = getFormMasteryData(player);
/* 2827 */     if (data != null && data.length() > 0 && data.contains(";")) {
/* 2828 */       int formID = getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 2829 */       String[] dataArray = data.split(";");
/* 2830 */       if (dataArray.length > formID) {
/* 2831 */         return dataArray[formID];
/*      */       }
/*      */     } 
/* 2834 */     return "";
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getFormMasteryNameFromData(String data) {
/* 2839 */     if (data != null && data.length() > 0 && data.contains(",")) {
/* 2840 */       String[] formData = data.split(",");
/*      */       
/* 2842 */       return formData[0];
/*      */     } 
/* 2844 */     return "";
/*      */   }
/*      */   
/*      */   public static double getFormMasteryValueFromData(String data) {
/* 2848 */     if (data != null && data.length() > 0 && data.contains(",")) {
/* 2849 */       String[] formData = data.split(",");
/* 2850 */       double currFormValue = Double.parseDouble(formData[1]);
/* 2851 */       return currFormValue;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2856 */     return 0.0D;
/*      */   }
/*      */   
/*      */   public static double getFormMasteryValue(EntityPlayer player, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 2860 */     String data = getFormMasteryData(player, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 2861 */     return getFormMasteryValueFromData(data);
/*      */   }
/*      */   
/*      */   public static double getFormMasteryValue(EntityPlayer player, int formID) {
/* 2865 */     String data = getFormMasteryData(player);
/* 2866 */     if (data != null && data.length() > 0 && data.contains(";")) {
/* 2867 */       String[] dataArray = data.split(";");
/* 2868 */       if (dataArray.length > formID) {
/* 2869 */         String[] formData = dataArray[formID].split(",");
/* 2870 */         double currFormValue = Double.parseDouble(formData[1]);
/* 2871 */         return currFormValue;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2877 */     return 0.0D;
/*      */   }
/*      */ 
/*      */   
/*      */   public static double getFormMasteryValue(EntityPlayer player) {
/* 2882 */     if (dnn(1) && dnn(2) && dnn(19) && dnn(32) && plyrs != null) {
/*      */       
/* 2884 */       if (player == null) return 0.0D;
/*      */       
/* 2886 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*      */         
/* 2888 */         if (plyrs[pl] != null && plyrs[pl].equals(player.func_70005_c_())) {
/*      */           
/* 2890 */           if (dat32 != null && dat32.length > pl) {
/*      */             
/* 2892 */             int race = Integer.parseInt(data1[pl].split(";")[0]);
/* 2893 */             int state = Integer.parseInt(data2[pl].split(";")[0]);
/* 2894 */             int state2 = Integer.parseInt(data2[pl].split(";")[1]);
/* 2895 */             String statusEffects = dat19[pl].split(";")[1];
/* 2896 */             boolean isKaiokenOn = StusEfcts(5, statusEffects);
/* 2897 */             boolean isMysticOn = StusEfcts(13, statusEffects);
/* 2898 */             boolean isUltraInstinctOn = StusEfcts(19, statusEffects);
/* 2899 */             boolean isGoDOn = StusEfcts(20, statusEffects);
/* 2900 */             return getFormMasteryValue(player, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/*      */           } 
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 2906 */     return 0.0D;
/*      */   }
/*      */   
/*      */   public static double getFormMasteryValue() {
/* 2910 */     int race = Race;
/* 2911 */     int state = State;
/* 2912 */     int state2 = State2;
/* 2913 */     boolean isKaiokenOn = StusEfctsMe(5);
/* 2914 */     boolean isMysticOn = StusEfctsMe(13);
/* 2915 */     boolean isUltraInstinctOn = StusEfctsMe(19);
/* 2916 */     boolean isGoDOn = StusEfctsMe(20);
/* 2917 */     return getFormMasteryValue(mod_JRMCore.proxy.getPlayerClient(), race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getFormIDFromName(int race, String formName) {
/* 2922 */     int formID = 0;
/* 2923 */     int length = (trans[race]).length; int i;
/* 2924 */     for (i = 0; i < length; i++) {
/* 2925 */       if (trans[race][i].equals(formName)) {
/* 2926 */         return i;
/*      */       }
/*      */     } 
/* 2929 */     length = transNonRacial.length;
/* 2930 */     for (i = 0; i < length; i++) {
/* 2931 */       if (transNonRacial[i].equals(formName)) {
/* 2932 */         return i + (trans[race]).length;
/*      */       }
/*      */     } 
/* 2935 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void changeFormMasteryValue(EntityPlayer player, double value, boolean add, int race, int formID, boolean racial, int gainMultiID) {
/* 2940 */     if (!JGConfigDBCFormMastery.FM_Enabled)
/* 2941 */       return;  if (isFused((Entity)player))
/*      */       return; 
/* 2943 */     JGPlayerMP jgPlayer = new JGPlayerMP(player);
/* 2944 */     NBTTagCompound nbt = jgPlayer.connectBaseNBT();
/*      */     
/* 2946 */     String nbtKey = getNBTFormMasteryRacialKey(racial, race);
/*      */     
/* 2948 */     String nbtKeyRacial = getNBTFormMasteryRacialKey(true, race);
/* 2949 */     String nbtKeyNonRacial = getNBTFormMasteryRacialKey(false, race);
/*      */     
/* 2951 */     boolean hasNBTRacial = (nbt.func_74764_b(nbtKeyRacial) && !nbt.func_74779_i(nbtKeyRacial).equals("Base,0") && !nbt.func_74779_i(nbtKeyRacial).equals("Kaioken,0") && nbt.func_74779_i(nbtKeyRacial).contains(","));
/*      */     
/* 2953 */     boolean hasNBTNonRacial = (nbt.func_74764_b(nbtKeyNonRacial) && !nbt.func_74779_i(nbtKeyNonRacial).equals("Kaioken,0") && !nbt.func_74779_i(nbtKeyNonRacial).equals("Base,0") && nbt.func_74779_i(nbtKeyNonRacial).contains(","));
/*      */     
/* 2955 */     if (!hasNBTRacial) {
/* 2956 */       String str = getDefaultFormMasteryRacialText(race);
/* 2957 */       nbt.func_74778_a(nbtKeyRacial, str);
/*      */     } 
/* 2959 */     if (!hasNBTNonRacial) {
/* 2960 */       String str = getDefaultFormMasteryNonRacialText();
/* 2961 */       nbt.func_74778_a(nbtKeyNonRacial, str);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2971 */     String addToOther = "";
/*      */     
/* 2973 */     String[] masteries = nbt.func_74779_i(nbtKey).split(";");
/* 2974 */     int length = masteries.length;
/* 2975 */     for (int i = 0; i < length; i++) {
/* 2976 */       if (i == formID - (racial ? 0 : (trans[race]).length)) {
/* 2977 */         String[] values = masteries[i].split(",");
/* 2978 */         if (values.length > 1) {
/* 2979 */           double result = value;
/* 2980 */           if (add) {
/* 2981 */             double prevLevel = Double.parseDouble(values[1]);
/* 2982 */             if (gainMultiID > -1) {
/* 2983 */               int gainID = JGConfigDBCFormMastery.DATA_ID_GAIN_PASSIVE + gainMultiID;
/* 2984 */               value = JGConfigDBCFormMastery.getDouble(race, formID, gainID, 0);
/* 2985 */               result = value;
/*      */ 
/*      */               
/* 2988 */               double multipliedGain = JGConfigDBCFormMastery.getMultipliedGain(prevLevel, result, gainID, race, formID);
/* 2989 */               int mind = jgPlayer.getAttributes()[4];
/* 2990 */               double mindMulti = JGConfigDBCFormMastery.getMindGainMulti(gainMultiID, mind, gainMultiID, race, formID);
/*      */               
/* 2992 */               result = multipliedGain * mindMulti;
/*      */             } 
/*      */ 
/*      */             
/* 2996 */             String FM_AddGainsToOtherMastery = JGConfigDBCFormMastery.getString(race, formID, JGConfigDBCFormMastery.DATA_ID_GAIN_TO_OTHER_MASTERIES, 0);
/*      */             
/* 2998 */             if (FM_AddGainsToOtherMastery != null && FM_AddGainsToOtherMastery.contains(",") && FM_AddGainsToOtherMastery.length() > 0) {
/* 2999 */               String[] masteryGainsOther = FM_AddGainsToOtherMastery.split(";");
/* 3000 */               int lengthOther = masteryGainsOther.length;
/* 3001 */               for (int k = 0; k < lengthOther; k++) {
/* 3002 */                 String[] valuesOther = masteryGainsOther[k].split(",");
/* 3003 */                 String nameOther = valuesOther[0];
/*      */ 
/*      */                 
/* 3006 */                 int id = 0;
/* 3007 */                 boolean found = false;
/*      */                 
/* 3009 */                 String[] allForms = getFormMasteryData(player).split(";");
/* 3010 */                 int lengthAll = allForms.length;
/* 3011 */                 for (int m = 0; m < lengthAll; m++) {
/* 3012 */                   String name = allForms[m].split(",")[0];
/* 3013 */                   if (name.equals(nameOther)) {
/* 3014 */                     id = m;
/* 3015 */                     found = true;
/*      */                     
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */                 
/* 3021 */                 if (found && id != -1 && id != formID) {
/* 3022 */                   double valueOther = Double.parseDouble(valuesOther[1]) * result;
/* 3023 */                   addToOther = addToOther + id + "," + valueOther + "," + ((id < (trans[race]).length) ? 1 : 0) + ((k + 1 < length) ? ";" : "");
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/* 3028 */             result += prevLevel;
/*      */           } 
/*      */           
/* 3031 */           double FM_LevelMax = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_MAX_LEVEL, 0);
/* 3032 */           if (result > FM_LevelMax) result = FM_LevelMax; 
/* 3033 */           masteries[i] = values[0] + "," + result;
/*      */         } 
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 3039 */     String mastery = "";
/* 3040 */     for (int j = 0; j < length; j++) {
/* 3041 */       mastery = mastery + masteries[j] + ((j + 1 < length) ? ";" : "");
/*      */     }
/*      */     
/* 3044 */     nbt.func_74778_a(nbtKey, mastery);
/*      */ 
/*      */     
/* 3047 */     if (addToOther.length() > 0) {
/* 3048 */       String[] otherData = addToOther.split(";");
/* 3049 */       int lengthOther = otherData.length;
/* 3050 */       for (int k = 0; k < lengthOther; k++) {
/* 3051 */         String[] otherDataValues = otherData[k].split(",");
/* 3052 */         boolean isRacialOther = Boolean.parseBoolean(otherDataValues[2]);
/*      */         
/* 3054 */         String nbtKeyOther = getNBTFormMasteryRacialKey(isRacialOther, race);
/* 3055 */         boolean hasNBTOther = (nbt.func_74764_b(nbtKey) && !nbt.func_74779_i(nbtKey).equals("Base,0") && !nbt.func_74779_i(nbtKey).equals("Kaioken,0"));
/*      */         
/* 3057 */         if (!hasNBTOther) {
/* 3058 */           mastery = isRacialOther ? getDefaultFormMasteryRacialText(race) : getDefaultFormMasteryNonRacialText();
/* 3059 */           nbt.func_74778_a(nbtKey, mastery);
/*      */         } 
/*      */         
/* 3062 */         int formIDOther = Integer.parseInt(otherDataValues[0]);
/* 3063 */         double multiOther = Double.parseDouble(otherDataValues[1]);
/*      */         
/* 3065 */         String[] masteryBefore = nbt.func_74779_i(nbtKeyOther).split(";");
/* 3066 */         length = masteryBefore.length;
/*      */         
/* 3068 */         mastery = "";
/* 3069 */         for (int m = 0; m < length; m++) {
/* 3070 */           String[] masteryValuesAfter = masteryBefore[m].split(",");
/* 3071 */           double masteryValueBefore = Double.parseDouble(masteryValuesAfter[1]);
/* 3072 */           double result = masteryValueBefore + ((m == formIDOther - (isRacialOther ? 0 : (trans[race]).length)) ? multiOther : 0.0D);
/*      */           
/* 3074 */           double FM_LevelMax = JGConfigDBCFormMastery.getDouble(race, m + (isRacialOther ? 0 : (trans[race]).length), JGConfigDBCFormMastery.DATA_ID_MAX_LEVEL, 0);
/* 3075 */           if (result > FM_LevelMax) result = FM_LevelMax;
/*      */           
/* 3077 */           mastery = mastery + masteryValuesAfter[0] + "," + result + ((m + 1 < length) ? ";" : "");
/*      */         } 
/*      */         
/* 3080 */         nbt.func_74778_a(nbtKeyOther, mastery);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void addToFormMasteryValue(EntityPlayer player, double value, int race, int FormID, boolean racial, int gainMultiID) {
/* 3086 */     changeFormMasteryValue(player, value, true, race, FormID, racial, gainMultiID);
/*      */   }
/*      */   
/*      */   public static void setFormMasteryValue(EntityPlayer player, double value, int race, int FormID, boolean racial) {
/* 3090 */     changeFormMasteryValue(player, value, false, race, FormID, racial, -1);
/*      */   }
/*      */   
/*      */   public static void addToFormMasteryValue(EntityPlayer player, double value, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn, int gainMultiID) {
/* 3094 */     int currentFormID = getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 3095 */     boolean racial = isCurrentFormRacial(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 3096 */     changeFormMasteryValue(player, value, true, race, currentFormID, racial, gainMultiID);
/*      */   }
/*      */   
/*      */   public static void setFormMasteryValue(EntityPlayer player, double value, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 3100 */     int currentFormID = getCurrentFormID(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 3101 */     boolean racial = isCurrentFormRacial(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 3102 */     changeFormMasteryValue(player, value, false, race, currentFormID, racial, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void changeFormMasteriesValue(EntityPlayer player, double value, double valueKK, boolean add, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn, int gainMultiID) {
/* 3112 */     if (add) { addToFormMasteryValue(player, value, race, state, state2, false, isMysticOn, isUltraInstinctOn, isGoDOn, gainMultiID); }
/* 3113 */     else { setFormMasteryValue(player, value, race, state, state2, false, isMysticOn, isUltraInstinctOn, isGoDOn); }
/*      */ 
/*      */ 
/*      */     
/* 3117 */     boolean isInKaioken = isCurrentFormID("Kaioken", race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 3118 */     if (isKaiokenOn && isInKaioken) {
/* 3119 */       int kaiokenID = getFormID("Kaioken", race);
/*      */       
/* 3121 */       if (add) { addToFormMasteryValue(player, valueKK, race, kaiokenID, false, gainMultiID); }
/* 3122 */       else { setFormMasteryValue(player, valueKK, race, kaiokenID, false); }
/*      */       
/* 3124 */       double d = getFormMasteryValue(player, kaiokenID);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addToFormMasteriesValue(EntityPlayer player, double value, double valueKK, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn, int gainMultiID) {
/* 3131 */     changeFormMasteriesValue(player, value, valueKK, true, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn, gainMultiID);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setFormMasteriesValue(EntityPlayer player, double value, double valueKK, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn, int gainMultiID) {
/* 3136 */     changeFormMasteriesValue(player, value, valueKK, false, race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn, gainMultiID);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, String requiredMastery, int formID, boolean sayChat) {
/* 3141 */     if (JGConfigDBCFormMastery.FM_Enabled && requiredMastery.contains(",") && requiredMastery.length() > 0) {
/*      */       
/* 3143 */       String[] formData = data.split(";");
/*      */       
/* 3145 */       String[] formDataR = requiredMastery.split(";");
/* 3146 */       int i = 0;
/* 3147 */       for (String s : formData) {
/* 3148 */         if (formID == -1 || formID == i) {
/* 3149 */           String[] formDataValues = s.split(",");
/* 3150 */           for (String sR : formDataR) {
/* 3151 */             String[] formDataValuesR = sR.split(",");
/* 3152 */             if (formDataValues[0].equals(formDataValuesR[0])) {
/* 3153 */               double formValue = Double.parseDouble(formDataValues[1]);
/* 3154 */               double formValueR = Double.parseDouble(formDataValuesR[1]);
/* 3155 */               if (formValue < formValueR) {
/* 3156 */                 if (sayChat) { player.func_145747_a((new ChatComponentText("Failed to Transform! Form Mastery Requirement needed: " + formDataValuesR[0] + " Lvl: " + formDataValuesR[1])).func_150255_a(DBCPacketHandlerServer.styleRed)); }
/*      */                 else
/* 3158 */                 { player.func_145747_a((new ChatComponentText("Failed to hold Form! Form Mastery Requirement needed: " + formDataValuesR[0] + " Lvl: " + formDataValuesR[1])).func_150255_a(DBCPacketHandlerServer.styleRed)); }
/*      */                 
/* 3160 */                 return false;
/*      */               } 
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/* 3166 */         i++;
/*      */       } 
/*      */     } 
/* 3169 */     return true;
/*      */   }
/*      */   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, String requiredMastery, int formID) {
/* 3172 */     return hasRequiredFormMasteries(player, data, requiredMastery, formID, true);
/*      */   }
/*      */   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, int race, String formName, boolean sayChat) {
/* 3175 */     int formID = getFormIDFromName(race, formName);
/* 3176 */     String FM_RequiredMastery = JGConfigDBCFormMastery.getString(race, formID, JGConfigDBCFormMastery.DATA_ID_REQUIRED_MASTERIES, 0);
/* 3177 */     if (FM_RequiredMastery == null) return true; 
/* 3178 */     return hasRequiredFormMasteries(player, data, FM_RequiredMastery, -1, sayChat);
/*      */   }
/*      */   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, int race, String formName) {
/* 3181 */     return hasRequiredFormMasteries(player, data, race, formName, true);
/*      */   }
/*      */   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, int race, int formID) {
/* 3184 */     String FM_RequiredMastery = JGConfigDBCFormMastery.getString(race, formID, JGConfigDBCFormMastery.DATA_ID_REQUIRED_MASTERIES, 0);
/* 3185 */     if (FM_RequiredMastery == null) return true; 
/* 3186 */     return hasRequiredFormMasteries(player, data, FM_RequiredMastery, -1);
/*      */   }
/*      */   public static boolean hasRequiredFormMasteries(EntityPlayer player, String data, String requiredMastery) {
/* 3189 */     return hasRequiredFormMasteries(player, data, requiredMastery, -1);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean hasRequiredFormMasteries2(EntityPlayer player, String data, int race, int state, int state2, boolean isKaiokenOn, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 3194 */     String formName = getCurrentFormName(race, state, state2, isKaiokenOn, isMysticOn, isUltraInstinctOn, isGoDOn);
/* 3195 */     return hasRequiredFormMasteries(player, data, race, formName, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void autoLearnFormMastery(EntityPlayer player, int race) {
/* 3204 */     if (!JGConfigDBCFormMastery.FM_Enabled)
/* 3205 */       return;  if (isFused((Entity)player))
/* 3206 */       return;  String[] data = getFormMasteryData(player).split(";");
/* 3207 */     int formID = 0;
/* 3208 */     for (String mastery : data) {
/* 3209 */       String[] values = mastery.split(",");
/*      */       
/* 3211 */       double value = Double.parseDouble(values[1]);
/*      */       
/* 3213 */       String FM_AutoLearnOnLevel = JGConfigDBCFormMastery.getString(race, formID, JGConfigDBCFormMastery.DATA_ID_AUTO_LEARN_ON_LEVEL, 0);
/*      */       
/* 3215 */       if (FM_AutoLearnOnLevel != null && FM_AutoLearnOnLevel.length() > 0 && FM_AutoLearnOnLevel.contains(",")) {
/*      */         
/* 3217 */         String[] autoUnlocks = FM_AutoLearnOnLevel.split(";");
/*      */         
/* 3219 */         for (String autoUnlock : autoUnlocks) {
/* 3220 */           String[] valuesUnlock = autoUnlock.split(",");
/* 3221 */           double valueUnlock = Double.parseDouble(valuesUnlock[2]);
/*      */           
/* 3223 */           if (value >= valueUnlock) {
/* 3224 */             String nameUnlock = valuesUnlock[0];
/* 3225 */             String nameUnlockID = nameUnlock;
/* 3226 */             int levelID = Integer.parseInt(valuesUnlock[1]);
/* 3227 */             if (levelID < 0) levelID = 0;
/*      */ 
/*      */             
/* 3230 */             JGPlayerMP jgPlayer = new JGPlayerMP(player);
/* 3231 */             jgPlayer.connectBaseNBT();
/* 3232 */             NBTTagCompound nbt = jgPlayer.getNBT();
/*      */ 
/*      */             
/* 3235 */             if (nameUnlockID.equals("Racial")) {
/* 3236 */               String s1 = nbt.func_74779_i("jrmcSSltX");
/*      */               
/* 3238 */               int racialSkillLevel = SklLvlX(1, s1);
/*      */               
/* 3240 */               int maxLevel = JGRaceHelper.getMaxRacialSkillLevel(DBC(), NC(), (byte)race);
/* 3241 */               if (levelID > maxLevel) levelID = maxLevel;
/*      */               
/* 3243 */               if (racialSkillLevel < levelID + 1 && s1.length() > 2 && !s1.contains("pty")) {
/* 3244 */                 String name = s1.substring(0, 2);
/* 3245 */                 nbt.func_74778_a("jrmcSSltX", name + levelID);
/* 3246 */                 player.func_145747_a((new ChatComponentText("Form Mastery: Auto Unlocked Racial Skill Level " + levelID)).func_150255_a(DBCPacketHandlerServer.styleYellow));
/*      */               }
/*      */             
/*      */             } else {
/*      */               
/* 3251 */               levelID--;
/* 3252 */               if (levelID < 0) levelID = 0; 
/* 3253 */               String nameFullUnlock = "";
/* 3254 */               int id = 0;
/* 3255 */               for (String ids : DBCSkillsIDs) {
/* 3256 */                 if (ids.equals(nameUnlockID)) {
/* 3257 */                   nameFullUnlock = DBCSkillNames[id];
/*      */                   break;
/*      */                 } 
/* 3260 */                 id++;
/*      */               } 
/* 3262 */               boolean isUI = (id == 16);
/* 3263 */               int maxLevel = isUI ? JGConfigUltraInstinct.CONFIG_UI_LEVELS : (vlblSklsUps[id] + 1);
/* 3264 */               if (levelID > maxLevel) levelID = maxLevel;
/*      */               
/* 3266 */               String[] s1 = nbt.func_74779_i("jrmcSSlts").split(",");
/* 3267 */               id = 0;
/*      */               
/* 3269 */               boolean foundSkill = false;
/* 3270 */               boolean learn = false;
/* 3271 */               for (String skill : s1) {
/* 3272 */                 if (skill.length() > 2) {
/* 3273 */                   String name = skill.substring(0, 2);
/* 3274 */                   if (name.equals(nameUnlockID)) {
/* 3275 */                     foundSkill = true;
/* 3276 */                     int skillLevel = Integer.parseInt(skill.substring(2, 3));
/* 3277 */                     if (skillLevel < levelID) {
/*      */                       
/* 3279 */                       s1[id] = name + levelID;
/* 3280 */                       player.func_145747_a((new ChatComponentText("Form Mastery: Auto Unlocked Skill " + nameFullUnlock + " Level " + (levelID + (isUI ? 0 : 1)))).func_150255_a(DBCPacketHandlerServer.styleYellow));
/* 3281 */                       learn = true;
/*      */                     } 
/*      */                   } 
/*      */                 } 
/* 3285 */                 id++;
/*      */               } 
/*      */ 
/*      */               
/* 3289 */               String skills = "";
/* 3290 */               for (String skill : s1) { if (s1.length > 0) skills = skills + skill + ",";  }
/* 3291 */                if (!foundSkill) {
/* 3292 */                 skills = skills + nameUnlockID + levelID + ",";
/* 3293 */                 player.func_145747_a((new ChatComponentText("Form Mastery: Auto Unlocked Skill " + nameFullUnlock + " Level " + (levelID + (isUI ? 0 : 1)))).func_150255_a(DBCPacketHandlerServer.styleYellow));
/* 3294 */                 learn = true;
/*      */               } 
/*      */               
/* 3297 */               if (learn) nbt.func_74778_a("jrmcSSlts", skills); 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 3302 */       formID++;
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
/* 3337 */   public static final String[] TransSaiUpNam = new String[] { "Need for Power", "Further Ascending Theory", "Not Enough", "Back to the Basics", "Even More Power", "The Real Power", "Everything Reached!" };
/* 3338 */   public static final short[] TransSaiTre = new short[] { 0, 1, 2, 3, 1, 2, 3, 1, 3, 1, 1, 3, 1, 1, 4, 2 };
/* 3339 */   public static final float[] TransSaiBlk = new float[] { 1.0F, 1.05F, 1.1F, 1.2F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 0.95F, 0.95F, 0.95F, 1.1F, 1.2F, 1.05F, 1.05F };
/*      */   
/* 3341 */   public static final float[] TransSaiSz = new float[] { 1.0F, 1.02F, 1.1F, 1.2F, 1.02F, 1.04F, 1.06F, 3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 1.1F, 1.2F, 1.04F, 1.02F };
/*      */   
/* 3343 */   public static float[] TransSaiRgnO = new float[] { 1.0F, -0.2F, -0.3F, -0.4F, -0.05F, -0.2F, -1.0F, -0.5F, -2.0F, -0.5F, -0.5F, -0.5F, -0.2F, -0.2F, -0.2F, -0.5F };
/* 3344 */   public static float[] TransSaiRgn = new float[] { 1.0F, -0.2F, -0.3F, -0.4F, -0.05F, -0.2F, -1.0F, -0.5F, -2.0F, -0.5F, -0.5F, -0.5F, -0.2F, -0.2F, -0.2F, -0.5F };
/* 3345 */   public static float[] TransHalfSaiRgnO = new float[] { 1.0F, -0.2F, -0.3F, -0.4F, -0.05F, -0.2F, -1.0F, -0.5F, -2.0F, -0.5F, -0.5F, -0.5F, -0.2F, -0.2F, -0.2F, -0.5F };
/* 3346 */   public static float[] TransHalfSaiRgn = new float[] { 1.0F, -0.2F, -0.3F, -0.4F, -0.05F, -0.2F, -1.0F, -0.5F, -2.0F, -0.5F, -0.5F, -0.5F, -0.2F, -0.2F, -0.2F, -0.5F };
/*      */   
/*      */   public static final float Kkm = 0.01F;
/*      */   
/* 3350 */   public static final short[] TransFrSkn = new short[] { 0, 0, 0, 0, 1, 2, 3, 1 };
/*      */   
/* 3352 */   public static final short[] TransFrSkn2 = new short[] { 0, 0, 0, 2, 1, 3, 1, 1 };
/* 3353 */   public static final short[] TransFrHrn = new short[] { 0, 0, 1, 2, 3, 4, 3, 3 };
/* 3354 */   public static final float[] TransFrBlk = new float[] { 1.0F, 1.0F, 1.0F, 1.1F, 1.0F, 1.1F, 1.05F, 0.95F };
/*      */   
/* 3356 */   public static final float[] TransFrSz = new float[] { 0.95F, 1.0F, 1.2F, 1.3F, 1.0F, 1.1F, 1.0F, 1.0F };
/*      */   
/* 3358 */   public static float[] TransFrRgnO = new float[] { 3.0F, 2.5F, 2.0F, 1.5F, 1.0F, -0.5F, -1.0F, -0.5F };
/* 3359 */   public static float[] TransFrRgn = new float[] { 3.0F, 2.5F, 2.0F, 1.5F, 1.0F, -0.5F, -1.0F, -0.5F };
/* 3360 */   public static float[] TransHmRgnO = new float[] { 1.0F, -0.5F, -0.25F, -0.5F };
/* 3361 */   public static float[] TransHmRgn = new float[] { 1.0F, -0.5F, -0.25F, -0.5F };
/* 3362 */   public static final float[] TransHmBlk = new float[] { 1.0F, 1.05F, 1.1F, 0.95F };
/* 3363 */   public static final float[] TransHmSz = new float[] { 1.0F, 1.05F, 1.2F, 1.0F };
/* 3364 */   public static float[] TransNaRgnO = new float[] { 1.0F, -0.5F, -0.25F, -0.5F };
/* 3365 */   public static float[] TransNaRgn = new float[] { 1.0F, -0.5F, -0.25F, -0.5F };
/* 3366 */   public static final float[] TransNaBlk = new float[] { 1.0F, 1.05F, 1.05F, 0.95F };
/* 3367 */   public static final float[] TransNaSz = new float[] { 1.0F, 1.05F, 3.0F, 1.0F };
/*      */   
/* 3369 */   public static final float[] TransMaBulk = new float[] { 1.0F, 0.95F, 1.02F, 1.0F, 0.95F };
/* 3370 */   public static final float[] TransMaSize = new float[] { 1.0F, 1.0F, 1.2F, 0.8F, 1.0F };
/* 3371 */   public static float[] TransMaRgnO = new float[] { 1.0F, -0.5F, -0.25F, -0.5F };
/* 3372 */   public static float[] TransMaRgn = new float[] { 1.0F, -0.5F, -0.25F, -0.5F };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int mstc_sai(int skl) {
/* 3381 */     int[] in = { 1, 1, 1, 4, 5, 6, 6, 6 };
/* 3382 */     return in[skl];
/*      */   }
/*      */   
/* 3385 */   public static int mstc_arc() { return 5; } public static int mstc_humnam() {
/* 3386 */     return 1;
/*      */   }
/*      */   public static double ev_oob(float[][] f, int a1, int a2) {
/* 3389 */     if (f.length <= a1) a1 = f.length - 1;  if ((f[a1]).length <= a2) a2 = (f[a1]).length - 1;  return f[a1][a2];
/*      */   } public static double ev_oob(int[][] f, int a1, int a2) {
/* 3391 */     if (f.length <= a1) a1 = f.length - 1;  if ((f[a1]).length <= a2) a2 = (f[a1]).length - 1;  return f[a1][a2];
/*      */   } public static String ev_oob(String[][] f, int a1, int a2) {
/* 3393 */     if (f.length <= a1) a1 = f.length - 1;  if ((f[a1]).length <= a2) a2 = (f[a1]).length - 1;  return f[a1][a2];
/*      */   }
/*      */   
/*      */   public static boolean inBaseForm(int race, int state) {
/* 3397 */     return (race == 4) ? ((state == 4)) : ((state == 0));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int TransSaiPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v) {
/* 3403 */     return getAttributeSaiyan(null, curAtr, atr, st, skl, mystic, mysticLvl, v, false, -1, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int TransSaiPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype) {
/* 3408 */     return getAttributeSaiyan(null, curAtr, atr, st, skl, mystic, mysticLvl, v, ultraInstinct, powertype, false);
/*      */   }
/*      */   
/*      */   public static int getAttributeSaiyan(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
/*      */     double secondaryMulti;
/* 3413 */     int race = 1;
/* 3414 */     boolean isPowerTypeKi = isPowerTypeKi(powertype);
/*      */     
/* 3416 */     double formMasteryMulti = (ultraInstinct || GoD) ? 1.0D : getFormMasteryAttributeMulti(player, st, 0, 1, false, mystic, ultraInstinct, GoD);
/*      */     
/* 3418 */     float[][] flatPercentage = isPowerTypeKi ? TransSaiStBnP : DoujutsuPowerBonusMulti;
/* 3419 */     int[][] flatBonus = isPowerTypeKi ? TransSaiStBnF : DoujutsuPowerBonusFlat;
/*      */     
/* 3421 */     double stateBonusPercentage = ev_oob(flatPercentage, st, atr) * formMasteryMulti;
/* 3422 */     double stateBonusFlat = ev_oob(flatBonus, st, atr);
/*      */     
/* 3424 */     if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(1, st)) { stateBonusPercentage = 1.0D; }
/* 3425 */     else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(1, st)) { stateBonusPercentage = 1.0D; }
/* 3426 */     else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[1] != -1.0F) { stateBonusPercentage = 1.0D * formMasteryMulti; }
/*      */     
/* 3428 */     int atrLimit = checkLimit();
/* 3429 */     atrLimit = (atrLimit > 1000) ? 1000 : atrLimit;
/*      */ 
/*      */ 
/*      */     
/* 3433 */     if (isPowerTypeKi) {
/* 3434 */       if (mysticLvl > 0 && mystic) {
/* 3435 */         float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[1][(trans[1]).length] * skl;
/*      */         
/* 3437 */         secondaryMulti = ((JRMCoreConfig.MysticDamMulti[1] == -1.0F) ? (flatPercentage[mstc_sai(skl)][atr] * (1.0F + AttibuteBonusPerRacialSkill)) : (JRMCoreConfig.MysticDamMulti[1] + AttibuteBonusPerRacialSkill));
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */         
/* 3445 */         int attributeBonusMaxID = (JRMCoreConfig.AttibuteBonusPerRacialSkill[1]).length - 1;
/* 3446 */         secondaryMulti = (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[1][Math.min(st, attributeBonusMaxID)] * skl);
/*      */       } 
/*      */     } else {
/* 3449 */       secondaryMulti = 1.0D;
/*      */     } 
/* 3451 */     int per = (int)(stateBonusPercentage * curAtr[atr] * secondaryMulti);
/*      */     
/* 3453 */     if (isPowerTypeKi && mysticLvl > 0 && mystic) {
/* 3454 */       flt = (int)(curAtr[atr] + flatBonus[mstc_sai(skl)][atr] * (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[1][(trans[1]).length] * skl) * atrLimit * 0.001F);
/*      */     } else {
/*      */       
/* 3457 */       flt = (int)(curAtr[atr] + stateBonusFlat * atrLimit * 0.0010000000474974513D);
/*      */     } 
/* 3459 */     int flt = (flt > checkLimit()) ? checkLimit() : flt;
/* 3460 */     per = (per > flt || stateBonusFlat == 0.0D || atr == 4) ? per : flt;
/* 3461 */     return per;
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
/*      */   public static int getAttributeHalfSaiyan(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
/*      */     double secondaryMulti;
/* 3489 */     int race = 2;
/* 3490 */     boolean isPowerTypeKi = isPowerTypeKi(powertype);
/*      */     
/* 3492 */     double formMasteryMulti = (ultraInstinct || GoD) ? 1.0D : getFormMasteryAttributeMulti(player, st, 0, 2, false, mystic, ultraInstinct, GoD);
/*      */     
/* 3494 */     float[][] flatPercentage = isPowerTypeKi ? TransHalfSaiStBnP : DoujutsuPowerBonusMulti;
/* 3495 */     int[][] flatBonus = isPowerTypeKi ? TransHalfSaiStBnF : DoujutsuPowerBonusFlat;
/*      */     
/* 3497 */     double stateBonusPercentage = ev_oob(flatPercentage, st, atr) * formMasteryMulti;
/* 3498 */     double stateBonusFlat = ev_oob(flatBonus, st, atr);
/*      */     
/* 3500 */     if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(2, st)) { stateBonusPercentage = 1.0D; }
/* 3501 */     else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(2, st)) { stateBonusPercentage = 1.0D; }
/* 3502 */     else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[2] != -1.0F) { stateBonusPercentage = 1.0D * formMasteryMulti; }
/*      */     
/* 3504 */     int atrLimit = checkLimit();
/* 3505 */     atrLimit = (atrLimit > 1000) ? 1000 : atrLimit;
/*      */ 
/*      */ 
/*      */     
/* 3509 */     if (isPowerTypeKi) {
/* 3510 */       if (mysticLvl > 0 && mystic) {
/* 3511 */         float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[2][(trans[2]).length] * skl;
/*      */         
/* 3513 */         secondaryMulti = ((JRMCoreConfig.MysticDamMulti[2] == -1.0F) ? (flatPercentage[mstc_sai(skl)][atr] * (1.0F + AttibuteBonusPerRacialSkill)) : (JRMCoreConfig.MysticDamMulti[2] + AttibuteBonusPerRacialSkill));
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */         
/* 3521 */         int attributeBonusMaxID = (JRMCoreConfig.AttibuteBonusPerRacialSkill[2]).length - 1;
/* 3522 */         secondaryMulti = (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[2][Math.min(st, attributeBonusMaxID)] * skl);
/*      */       } 
/*      */     } else {
/* 3525 */       secondaryMulti = 1.0D;
/*      */     } 
/* 3527 */     int per = (int)(stateBonusPercentage * curAtr[atr] * secondaryMulti);
/*      */     
/* 3529 */     if (isPowerTypeKi && mysticLvl > 0 && mystic) {
/* 3530 */       flt = (int)(curAtr[atr] + flatBonus[mstc_sai(skl)][atr] * (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[2][(trans[2]).length] * skl) * atrLimit * 0.001F);
/*      */     } else {
/*      */       
/* 3533 */       flt = (int)(curAtr[atr] + stateBonusFlat * atrLimit * 0.0010000000474974513D);
/*      */     } 
/* 3535 */     int flt = (flt > checkLimit()) ? checkLimit() : flt;
/* 3536 */     per = (per > flt || stateBonusFlat == 0.0D || atr == 4) ? per : flt;
/* 3537 */     return per;
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
/*      */   public static int TransFrPwr(int[] curAtr, int atr, int st, int rg, int e, int skl, boolean mystic, int mysticLvl, boolean v) {
/* 3568 */     return getAttributeArcosian(null, curAtr, atr, st, rg, e, skl, mystic, mysticLvl, v, false, -1, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int TransFrPwr(int[] curAtr, int atr, int st, int rg, int e, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype) {
/* 3573 */     return getAttributeArcosian(null, curAtr, atr, st, rg, e, skl, mystic, mysticLvl, v, ultraInstinct, powertype, false);
/*      */   }
/*      */   
/*      */   public static int getAttributeArcosian(EntityPlayer player, int[] curAtr, int atr, int st, int rg, int e, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
/*      */     double secondaryMulti;
/* 3578 */     int race = 4;
/* 3579 */     boolean isPowerTypeKi = isPowerTypeKi(powertype);
/*      */     
/* 3581 */     double formMasteryMulti = (ultraInstinct || GoD) ? 1.0D : getFormMasteryAttributeMulti(player, st, 0, 4, false, mystic, ultraInstinct, GoD);
/*      */     
/* 3583 */     float[][] flatPercentage = isPowerTypeKi ? TransFrStBnP : DoujutsuPowerBonusMulti;
/* 3584 */     int[][] flatBonus = isPowerTypeKi ? TransFrStBnF : DoujutsuPowerBonusFlat;
/*      */     
/* 3586 */     double stateBonusPercentage = ev_oob(flatPercentage, st, atr) * formMasteryMulti;
/* 3587 */     double stateBonusFlat = ev_oob(flatBonus, st, atr);
/*      */     
/* 3589 */     if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(4, st)) { stateBonusPercentage = 1.0D; }
/* 3590 */     else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(4, st)) { stateBonusPercentage = 1.0D; }
/* 3591 */     else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[4] != -1.0F) { stateBonusPercentage = 1.0D * formMasteryMulti; }
/*      */     
/* 3593 */     int atrLimit = checkLimit();
/* 3594 */     atrLimit = (atrLimit > 1000) ? 1000 : atrLimit;
/*      */ 
/*      */ 
/*      */     
/* 3598 */     if (isPowerTypeKi && mysticLvl > 0 && mystic) {
/* 3599 */       float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[4][(trans[4]).length] * skl;
/*      */       
/* 3601 */       secondaryMulti = ((JRMCoreConfig.MysticDamMulti[4] == -1.0F) ? (flatPercentage[mstc_arc()][atr] * (1.0F + AttibuteBonusPerRacialSkill)) : (JRMCoreConfig.MysticDamMulti[4] + AttibuteBonusPerRacialSkill));
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 3608 */       int attributeBonusMaxID = (JRMCoreConfig.AttibuteBonusPerRacialSkill[4]).length - 1;
/* 3609 */       secondaryMulti = (1.0F + (isPowerTypeKi ? (JRMCoreConfig.AttibuteBonusPerRacialSkill[4][Math.min(st, attributeBonusMaxID)] * skl) : 0.0F));
/*      */     } 
/*      */ 
/*      */     
/* 3613 */     int per = (int)(stateBonusPercentage * curAtr[atr] * secondaryMulti);
/*      */     
/* 3615 */     if (isPowerTypeKi && mysticLvl > 0 && mystic) {
/* 3616 */       flt = (int)(curAtr[atr] + flatBonus[mstc_arc()][atr] * (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[4][(trans[4]).length] * skl) * atrLimit * 0.001F);
/*      */     } else {
/*      */       
/* 3619 */       flt = (int)(curAtr[atr] + stateBonusFlat * atrLimit * 0.0010000000474974513D);
/*      */     } 
/* 3621 */     int flt = (flt > checkLimit()) ? checkLimit() : flt;
/* 3622 */     per = (per > flt || stateBonusFlat == 0.0D || atr == 4) ? per : flt;
/* 3623 */     per = getArcosianPowerPointBoost(per, st, rg, e, getArcosianFormID(st, mystic, ultraInstinct, GoD));
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
/* 3649 */     return per;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int TransHmPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v) {
/* 3655 */     return getAttributeHuman(null, curAtr, atr, st, skl, mystic, mysticLvl, v, false, -1, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int TransHmPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype) {
/* 3660 */     return getAttributeHuman(null, curAtr, atr, st, skl, mystic, mysticLvl, v, ultraInstinct, powertype, false);
/*      */   }
/*      */   
/*      */   public static int getAttributeHuman(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
/*      */     double secondaryMulti;
/* 3665 */     int race = 0;
/* 3666 */     boolean isPowerTypeKi = isPowerTypeKi(powertype);
/*      */     
/* 3668 */     double formMasteryMulti = (ultraInstinct || GoD) ? 1.0D : getFormMasteryAttributeMulti(player, st, 0, 0, false, mystic, ultraInstinct, GoD);
/*      */     
/* 3670 */     float[][] flatPercentage = isPowerTypeKi ? TransHmStBnP : DoujutsuPowerBonusMulti;
/* 3671 */     int[][] flatBonus = isPowerTypeKi ? TransHmStBnF : DoujutsuPowerBonusFlat;
/*      */     
/* 3673 */     double stateBonusPercentage = ev_oob(flatPercentage, (mysticLvl > 0 && mystic) ? 1 : st, atr) * formMasteryMulti;
/* 3674 */     double stateBonusFlat = ev_oob(flatBonus, (mysticLvl > 0 && mystic) ? 1 : st, atr);
/*      */     
/* 3676 */     if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(0, st)) { stateBonusPercentage = 1.0D; }
/* 3677 */     else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(0, st)) { stateBonusPercentage = 1.0D; }
/* 3678 */     else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[0] != -1.0F) { stateBonusPercentage = 1.0D * formMasteryMulti; }
/*      */     
/* 3680 */     int atrLimit = checkLimit();
/* 3681 */     atrLimit = (atrLimit > 1000) ? 1000 : atrLimit;
/*      */ 
/*      */ 
/*      */     
/* 3685 */     if (isPowerTypeKi) {
/* 3686 */       if (mysticLvl > 0 && mystic) {
/* 3687 */         float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[0][(trans[0]).length] * skl;
/* 3688 */         secondaryMulti = (((JRMCoreConfig.MysticDamMulti[0] == -1.0F) ? 1.0F : JRMCoreConfig.MysticDamMulti[0]) + AttibuteBonusPerRacialSkill);
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/* 3695 */         int attributeBonusMaxID = (JRMCoreConfig.AttibuteBonusPerRacialSkill[0]).length - 1;
/* 3696 */         secondaryMulti = (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[0][Math.min(st, attributeBonusMaxID)] * skl);
/*      */       } 
/*      */     } else {
/* 3699 */       secondaryMulti = 1.0D;
/*      */     } 
/* 3701 */     int per = (int)(stateBonusPercentage * curAtr[atr] * secondaryMulti);
/*      */     
/* 3703 */     int flt = (int)(curAtr[atr] + stateBonusFlat * atrLimit * 0.0010000000474974513D);
/* 3704 */     flt = (flt > checkLimit()) ? checkLimit() : flt;
/* 3705 */     per = (per > flt || stateBonusFlat == 0.0D || atr == 4) ? per : flt;
/* 3706 */     return per;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int TransNaPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v) {
/* 3712 */     return getAttributeNamekian(null, curAtr, atr, st, skl, mystic, mysticLvl, v, false, -1, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int TransNaPwr(int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype) {
/* 3717 */     return getAttributeNamekian(null, curAtr, atr, st, skl, mystic, mysticLvl, v, ultraInstinct, powertype, false);
/*      */   }
/*      */   
/*      */   public static int getAttributeNamekian(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
/*      */     double secondaryMulti;
/* 3722 */     int race = 3;
/* 3723 */     boolean isPowerTypeKi = isPowerTypeKi(powertype);
/*      */     
/* 3725 */     double formMasteryMulti = (ultraInstinct || GoD) ? 1.0D : getFormMasteryAttributeMulti(player, st, 0, 3, false, mystic, ultraInstinct, GoD);
/*      */     
/* 3727 */     float[][] flatPercentage = isPowerTypeKi ? TransNaStBnP : DoujutsuPowerBonusMulti;
/* 3728 */     int[][] flatBonus = isPowerTypeKi ? TransNaStBnF : DoujutsuPowerBonusFlat;
/*      */     
/* 3730 */     double stateBonusPercentage = ev_oob(flatPercentage, (mysticLvl > 0 && mystic) ? 1 : st, atr) * formMasteryMulti;
/* 3731 */     double stateBonusFlat = ev_oob(flatBonus, (mysticLvl > 0 && mystic) ? 1 : st, atr);
/*      */     
/* 3733 */     if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(3, st)) { stateBonusPercentage = 1.0D; }
/* 3734 */     else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(3, st)) { stateBonusPercentage = 1.0D; }
/* 3735 */     else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[3] != -1.0F) { stateBonusPercentage = 1.0D * formMasteryMulti; }
/*      */     
/* 3737 */     int atrLimit = checkLimit();
/* 3738 */     atrLimit = (atrLimit > 1000) ? 1000 : atrLimit;
/*      */ 
/*      */ 
/*      */     
/* 3742 */     if (isPowerTypeKi) {
/* 3743 */       if (mysticLvl > 0 && mystic) {
/* 3744 */         float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[3][(trans[3]).length] * skl;
/* 3745 */         secondaryMulti = (((JRMCoreConfig.MysticDamMulti[3] == -1.0F) ? 1.0F : JRMCoreConfig.MysticDamMulti[3]) + AttibuteBonusPerRacialSkill);
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */         
/* 3753 */         int attributeBonusMaxID = (JRMCoreConfig.AttibuteBonusPerRacialSkill[3]).length - 1;
/* 3754 */         secondaryMulti = (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[3][Math.min(st, attributeBonusMaxID)] * skl);
/*      */       } 
/*      */     } else {
/* 3757 */       secondaryMulti = 1.0D;
/*      */     } 
/* 3759 */     int per = (int)(stateBonusPercentage * curAtr[atr] * secondaryMulti);
/* 3760 */     int flt = (int)(curAtr[atr] + stateBonusFlat * atrLimit * 0.0010000000474974513D);
/* 3761 */     flt = (flt > checkLimit()) ? checkLimit() : flt;
/* 3762 */     per = (per > flt || stateBonusFlat == 0.0D || atr == 4) ? per : flt;
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
/* 3785 */     return per;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getAttributeMajin(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD) {
/* 3791 */     return getAttributeMajin(player, curAtr, atr, st, skl, mystic, mysticLvl, v, ultraInstinct, powertype, GoD, "");
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getAttributeMajin(EntityPlayer player, int[] curAtr, int atr, int st, int skl, boolean mystic, int mysticLvl, boolean v, boolean ultraInstinct, int powertype, boolean GoD, String majinAbs) {
/*      */     double secondaryMulti;
/* 3797 */     int race = 5;
/* 3798 */     boolean isPowerTypeKi = isPowerTypeKi(powertype);
/*      */     
/* 3800 */     double formMasteryMulti = (ultraInstinct || GoD) ? 1.0D : getFormMasteryAttributeMulti(player, st, 0, 5, false, mystic, ultraInstinct, GoD);
/*      */ 
/*      */     
/* 3803 */     if (isPowerTypeKi && majinAbs.length() > 0 && JGConfigRaces.CONFIG_MAJIN_ENABLED && JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED) {
/*      */       
/* 3805 */       int stateID = getMajinFormID(st, mystic, ultraInstinct, GoD);
/* 3806 */       float attributeMulti = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[stateID] * getMajinAbsorptionValueS(majinAbs);
/*      */       
/* 3808 */       if (JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS) {
/* 3809 */         formMasteryMulti *= 1.0D + attributeMulti;
/*      */       } else {
/*      */         
/* 3812 */         formMasteryMulti += attributeMulti;
/*      */       } 
/*      */     } 
/*      */     
/* 3816 */     float[][] flatPercentage = isPowerTypeKi ? TransMaStBnP : DoujutsuPowerBonusMulti;
/* 3817 */     int[][] flatBonus = isPowerTypeKi ? TransMaStBnF : DoujutsuPowerBonusFlat;
/*      */     
/* 3819 */     double stateBonusPercentage = ev_oob(flatPercentage, (mysticLvl > 0 && mystic) ? 1 : st, atr) * formMasteryMulti;
/* 3820 */     double stateBonusFlat = ev_oob(flatBonus, (mysticLvl > 0 && mystic) ? 1 : st, atr);
/*      */     
/* 3822 */     if (GoD && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG && inBaseForm(5, st)) { stateBonusPercentage = 1.0D; }
/* 3823 */     else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG && inBaseForm(5, st)) { stateBonusPercentage = 1.0D; }
/* 3824 */     else if (mysticLvl > 0 && mystic && JRMCoreConfig.MysticDamMulti[5] != -1.0F) { stateBonusPercentage = 1.0D * formMasteryMulti; }
/*      */     
/* 3826 */     int atrLimit = checkLimit();
/* 3827 */     atrLimit = (atrLimit > 1000) ? 1000 : atrLimit;
/*      */ 
/*      */ 
/*      */     
/* 3831 */     if (isPowerTypeKi) {
/* 3832 */       if (mysticLvl > 0 && mystic) {
/* 3833 */         float AttibuteBonusPerRacialSkill = JRMCoreConfig.AttibuteBonusPerRacialSkill[5][(trans[5]).length] * skl;
/* 3834 */         secondaryMulti = (((JRMCoreConfig.MysticDamMulti[5] == -1.0F) ? 1.0F : JRMCoreConfig.MysticDamMulti[5]) + AttibuteBonusPerRacialSkill);
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/* 3841 */         int attributeBonusMaxID = (JRMCoreConfig.AttibuteBonusPerRacialSkill[5]).length - 1;
/* 3842 */         secondaryMulti = (1.0F + JRMCoreConfig.AttibuteBonusPerRacialSkill[5][Math.min(st, attributeBonusMaxID)] * skl);
/*      */       } 
/*      */     } else {
/* 3845 */       secondaryMulti = 1.0D;
/*      */     } 
/* 3847 */     int per = (int)(stateBonusPercentage * curAtr[atr] * secondaryMulti);
/* 3848 */     int flt = (int)(curAtr[atr] + stateBonusFlat * atrLimit * 0.0010000000474974513D);
/* 3849 */     flt = (flt > checkLimit()) ? checkLimit() : flt;
/* 3850 */     per = (per > flt || stateBonusFlat == 0.0D || atr == 4) ? per : flt;
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
/* 3890 */     return per;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean lgndb(int r, int st) {
/* 3896 */     String[] b = JRMCoreConfig.lgndb.split(",");
/* 3897 */     for (int i = 0; i < b.length; i++) {
/* 3898 */       if (b[i].equalsIgnoreCase(ev_oob(trans, r, st))) return true; 
/*      */     } 
/* 3900 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean lgndb() {
/* 3904 */     return lgndb(Race, State);
/*      */   }
/*      */   public static boolean lgndb2() {
/* 3907 */     return (StusEfctsMe(14) && lgndb(Race, State));
/*      */   }
/*      */   
/*      */   public static boolean lgndb(String se, int r, int s) {
/* 3911 */     return (StusEfcts(14, se) && lgndb(r, s));
/*      */   }
/*      */   
/*      */   public static boolean lgndb(int p, int r, int s) {
/* 3915 */     return (StusEfctsClient(14, p) && lgndb(r, s));
/*      */   }
/*      */   
/*      */   public static boolean lgndb(EntityPlayer p, int r, int s) {
/* 3919 */     return (StusEfctsClient(14, p) && lgndb(r, s));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int TransPwrModAtr(int[] currAttributes, int attribute, int st, int st2, int race, String SklX, int currRelease, int arcRel, boolean legendOn, boolean majinOn, boolean mysticOn, int powerType, String[] Skls, boolean isFused) {
/* 3924 */     return getPlayerAttribute(null, currAttributes, attribute, st, st2, race, SklX, currRelease, arcRel, legendOn, majinOn, false, mysticOn, false, false, powerType, Skls, isFused, "0");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int TransPwrModAtr(int[] currAttributes, int attribute, int st, int st2, int race, String SklX, int currRelease, int arcRel, boolean legendOn, boolean majinOn, boolean mysticOn, boolean uiOn, int powerType, String[] Skls, boolean isFused) {
/* 3932 */     return getPlayerAttribute(null, currAttributes, attribute, st, st2, race, SklX, currRelease, arcRel, legendOn, majinOn, false, mysticOn, false, false, powerType, Skls, isFused, "0");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getPlayerAttribute(int[] currAttributes, int attribute, int st, int st2, int race, String SklX, int currRelease, int arcRel, boolean legendOn, boolean majinOn, boolean mysticOn, boolean uiOn, boolean GoDOn, int powerType, String[] Skls, boolean isFused) {
/* 3941 */     return getPlayerAttribute(null, currAttributes, attribute, st, st2, race, SklX, currRelease, arcRel, legendOn, majinOn, false, mysticOn, uiOn, GoDOn, powerType, Skls, isFused, "0");
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getPlayerAttribute(EntityPlayer player, int[] currAttributes, int attribute, int st, int st2, int race, String SklX, int currRelease, int arcRel, boolean legendOn, boolean majinOn, boolean kaiokenOn, boolean mysticOn, boolean uiOn, boolean GoDOn, int powerType, String[] Skls, boolean isFused, String majinAbs) {
/* 3961 */     int skillX = (powerType == 1) ? (SklLvlX(1, SklX) - 1) : 0;
/* 3962 */     int mysticLvl = (powerType == 1) ? SklLvl(10, 1, Skls) : 0;
/* 3963 */     int result = 0;
/*      */     
/* 3965 */     switch (race) {
/*      */       case 0:
/* 3967 */         result = getAttributeHuman(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn); break;
/*      */       case 1:
/* 3969 */         result = getAttributeSaiyan(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn); break;
/* 3970 */       case 2: result = getAttributeHalfSaiyan(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn); break;
/* 3971 */       case 3: result = getAttributeNamekian(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn); break;
/* 3972 */       case 4: result = getAttributeArcosian(player, currAttributes, attribute, st, currRelease, arcRel, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn); break;
/* 3973 */       case 5: result = getAttributeMajin(player, currAttributes, attribute, st, skillX, mysticOn, mysticLvl, isFused, uiOn, powerType, GoDOn, majinAbs); break;
/* 3974 */       default: result = currAttributes[attribute];
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3984 */     if (powerType == 1 && GoDOn) {
/* 3985 */       double formMasteryMulti = getFormMasteryAttributeMulti(player, "GodOfDestruction", st, st2, race, kaiokenOn, mysticOn, uiOn, GoDOn);
/* 3986 */       result = (int)(result * (float)((JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI * JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI_RACE[race]) * formMasteryMulti));
/*      */     } 
/* 3988 */     if (powerType == 1 && uiOn) {
/*      */ 
/*      */       
/* 3991 */       if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0)
/*      */       {
/* 3993 */         double formMasteryMulti = getFormMasteryAttributeMulti(player, "UltraInstict", st, st2, race, kaiokenOn, mysticOn, uiOn, GoDOn);
/*      */         
/* 3995 */         int uiLevel = state2UltraInstinct(false, (byte)st2);
/* 3996 */         result = (int)(result * (JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI[uiLevel] * 0.01F * JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI_RACE[uiLevel][race]) * 1.0D * formMasteryMulti);
/*      */       }
/*      */     
/*      */     }
/* 4000 */     else if (powerType == 1 && st2 < TransKaiDmg.length) {
/*      */       
/* 4002 */       double formMasteryMulti = 1.0D;
/* 4003 */       if (st2 > 0 && kaiokenOn) {
/* 4004 */         formMasteryMulti = getFormMasteryAttributeMulti(player, "Kaioken", st, st2, race, kaiokenOn, mysticOn, uiOn, GoDOn);
/*      */       }
/* 4006 */       result = (int)(result * TransKaiDmg[st2] * 1.0D * formMasteryMulti + (majinOn ? ((result * JRMCoreConfig.mjn) * 0.01F) : 0.0F) + ((legendOn && (lgndb(race, st) || mysticOn)) ? ((result * JRMCoreConfig.lgnd) * 0.01F) : 0.0F));
/*      */     } 
/*      */     
/* 4009 */     if (powerType == 2 && st2 < TransGtsDmg.length)
/*      */     {
/* 4011 */       result = (int)(result * TransGtsDmg[st2] * 1.0D);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4017 */     if (!JRMCoreConfig.OverAtrLimit) result = (result > checkLimit()) ? checkLimit() : result; 
/* 4018 */     result = (int)((result > Double.MAX_VALUE) ? Double.MAX_VALUE : result);
/* 4019 */     return result;
/*      */   }
/*      */   
/*      */   public static double getFormMasteryAttributeMulti(EntityPlayer player, int st, int st2, int race, boolean kaiokenOn, boolean mysticOn, boolean uiOn, boolean GoDOn) {
/* 4023 */     boolean hasFormMastery = (JGConfigDBCFormMastery.FM_Enabled && player != null);
/* 4024 */     double formMasteryMulti = 0.0D;
/* 4025 */     if (hasFormMastery) {
/* 4026 */       boolean isInKaioken = isCurrentFormID("Kaioken", race, st, st2, kaiokenOn, mysticOn, uiOn, GoDOn);
/*      */       
/* 4028 */       if (isInKaioken) {
/*      */         
/* 4030 */         int formIDKaioken = getFormIDFromName(race, isInKaioken ? "Kaioken" : "");
/* 4031 */         double d1 = JGConfigDBCFormMastery.getDouble(race, formIDKaioken, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 0);
/* 4032 */         double d2 = JGConfigDBCFormMastery.getDouble(race, formIDKaioken, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 1);
/* 4033 */         double d3 = JGConfigDBCFormMastery.getDouble(race, formIDKaioken, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 2);
/*      */         
/* 4035 */         double d4 = getFormMasteryValue(player, formIDKaioken);
/* 4036 */         double d5 = d2 * d4 + d1;
/*      */         
/* 4038 */         if (d5 > d3) d5 = d3; 
/* 4039 */         formMasteryMulti += d5;
/*      */       } 
/*      */       
/* 4042 */       int formID = getCurrentFormID(race, st, st2, kaiokenOn, mysticOn, uiOn, GoDOn);
/* 4043 */       double FM_DamageMultiFlat = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 0);
/* 4044 */       double FM_DamageMultiPerLevel = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 1);
/* 4045 */       double FM_DamageMultiMax = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 2);
/*      */ 
/*      */       
/* 4048 */       double masteryValue = getFormMasteryValue(player, race, st, st2, kaiokenOn, mysticOn, uiOn, GoDOn);
/* 4049 */       double masteryResult = FM_DamageMultiPerLevel * masteryValue + FM_DamageMultiFlat;
/* 4050 */       if (masteryResult > FM_DamageMultiMax) masteryResult = FM_DamageMultiMax; 
/* 4051 */       formMasteryMulti += masteryResult;
/*      */     } else {
/* 4053 */       return 1.0D;
/* 4054 */     }  return formMasteryMulti;
/*      */   }
/*      */   public static double getFormMasteryAttributeMulti(EntityPlayer player, String formName, int st, int st2, int race, boolean kaiokenOn, boolean mysticOn, boolean uiOn, boolean GoDOn) {
/* 4057 */     boolean hasFormMastery = (JGConfigDBCFormMastery.FM_Enabled && player != null && formName != null && formName.length() > 0);
/* 4058 */     double formMasteryMulti = 0.0D;
/* 4059 */     if (hasFormMastery) {
/* 4060 */       boolean isInForm = isCurrentFormID(formName, race, st, st2, kaiokenOn, mysticOn, uiOn, GoDOn);
/*      */       
/* 4062 */       if (isInForm) {
/*      */         
/* 4064 */         int formID = getFormIDFromName(race, isInForm ? formName : "");
/* 4065 */         double FM_DamageMultiFlat = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 0);
/* 4066 */         double FM_DamageMultiPerLevel = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 1);
/* 4067 */         double FM_DamageMultiMax = JGConfigDBCFormMastery.getDouble(race, formID, JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI, 2);
/*      */         
/* 4069 */         double masteryValue = getFormMasteryValue(player, formID);
/* 4070 */         double masteryResult = FM_DamageMultiPerLevel * masteryValue + FM_DamageMultiFlat;
/* 4071 */         if (masteryResult > FM_DamageMultiMax) masteryResult = FM_DamageMultiMax; 
/* 4072 */         formMasteryMulti += masteryResult;
/*      */       } 
/*      */     } else {
/* 4075 */       return 1.0D;
/* 4076 */     }  return formMasteryMulti;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int weightModifier(int[] curAtr, int atr, float weight) {
/* 4081 */     int i = (int)(curAtr[atr] - weight);
/* 4082 */     return (i < 0) ? 0 : i;
/*      */   }
/*      */   
/*      */   public static float weightPerc(int atr, EntityPlayer p) {
/* 4086 */     float lastGravity = getFloat(p, "jrmcGravForce");
/* 4087 */     lastGravity = JRMCoreHDBC.gravity(p, lastGravity);
/* 4088 */     int[] PlyrAttrbts = PlyrAttrbts(p);
/* 4089 */     float IWeight = weightExtra(PlyrAttrbts, lastGravity, p);
/* 4090 */     return 0.5F + weightPerc(PlyrAttrbts, atr, IWeight, p) * 0.5F;
/*      */   }
/*      */   
/*      */   public static float weightPerc(int atr) {
/* 4094 */     boolean c = (StusEfctsMe(10) || StusEfctsMe(11));
/* 4095 */     float f = (atr == 0) ? (0.5F + weightPerc(PlyrAttrbts, atr, WeightOn, c) * 0.5F) : weightPerc(PlyrAttrbts, atr, WeightOn, c);
/* 4096 */     return f;
/*      */   }
/*      */   public static float weightPerc(int atr, float weight) {
/* 4099 */     float w = atr - weight;
/* 4100 */     w /= atr;
/* 4101 */     return (w < 0.05F) ? 0.05F : ((w > 1.0F) ? 1.0F : w);
/*      */   }
/*      */   
/*      */   public static float weightPerc(int[] curAtr, int atr, float weight, EntityPlayer p) {
/* 4105 */     int pwr = getByte(p, "jrmcPwrtyp");
/* 4106 */     int rc = getByte(p, "jrmcRace");
/* 4107 */     int st = getByte(p, "jrmcState");
/* 4108 */     int st2 = getByte(p, "jrmcState2");
/* 4109 */     int rl = getByte(p, "jrmcRelease");
/* 4110 */     String sklx = getString(p, "jrmcSSltX");
/* 4111 */     int resrv = getInt(p, "jrmcArcRsrv");
/* 4112 */     String absorption = getString(p, "jrmcMajinAbsorptionData");
/*      */     
/* 4114 */     String ste = getString(p, "jrmcStatusEff");
/* 4115 */     boolean mj = StusEfcts(12, ste);
/* 4116 */     boolean lg = StusEfcts(14, ste);
/* 4117 */     boolean kk = StusEfcts(5, ste);
/* 4118 */     boolean mc = StusEfcts(13, ste);
/* 4119 */     boolean mn = StusEfcts(19, ste);
/* 4120 */     boolean gd = StusEfcts(20, ste);
/* 4121 */     int a = curAtr[atr];
/* 4122 */     if (pwr != 3 && pwr > 0) {
/* 4123 */       String s = getString(p, "jrmcStatusEff"); boolean c = (StusEfcts(10, s) || StusEfcts(11, s));
/* 4124 */       a = getPlayerAttribute(p, curAtr, atr, st, st2, rc, sklx, rl, resrv, lg, mj, kk, mc, mn, gd, pwr, PlyrSkills(p), c, absorption);
/*      */     } 
/* 4126 */     return weightPerc(a, weight);
/*      */   }
/*      */   
/*      */   public static float weightPerc(int[] curAtr, int atr, float weight, boolean b) {
/* 4130 */     int a = curAtr[atr];
/* 4131 */     if (Pwrtyp != 3 && Pwrtyp > 0) {
/* 4132 */       a = getPlayerAttribute(mod_JRMCore.proxy.getPlayerClient(), curAtr, atr, State, State2, Race, PlyrSkillX, curRelease, getArcRsrv(), StusEfctsMe(14), StusEfctsMe(12), StusEfctsMe(5), StusEfctsMe(13), StusEfctsMe(19), StusEfctsMe(20), Pwrtyp, PlyrSkills, b, getMajinAbsorption());
/*      */     }
/* 4134 */     return weightPerc(a, weight);
/*      */   }
/*      */   
/*      */   public static float weightOfPlayerBody(int[] curAtr, boolean g) {
/* 4138 */     float am = (1 / checkLimit());
/* 4139 */     float body = 1.0F + curAtr[2] * am * 100.0F + curAtr[0] * am * 50.0F + curAtr[1] * am * 25.0F;
/*      */ 
/*      */     
/* 4142 */     return body;
/*      */   }
/*      */   
/*      */   public static float weightExtra(int[] curAtr, float grav, EntityPlayer p) {
/* 4146 */     float weight = getItemWeight(p);
/* 4147 */     String s = getString(p, "jrmcStatusEff");
/* 4148 */     float body = weightOfPlayerBody(curAtr, (StusEfcts(10, s) || StusEfcts(11, s)));
/* 4149 */     return (body + weight) * grav - body;
/*      */   }
/*      */   
/*      */   public static float getItemWeight(EntityPlayer player) {
/* 4153 */     ExtendedPlayer p = ExtendedPlayer.get(player);
/* 4154 */     ItemStack is = p.inventory.func_70301_a(0);
/* 4155 */     if (is != null) {
/* 4156 */       NBTTagList nbttaglist = ItemWeightStatsNBTTag(is);
/* 4157 */       if (nbttaglist != null) {
/* 4158 */         int i = 0; if (i < nbttaglist.func_74745_c()) {
/* 4159 */           float weight = nbttaglist.func_150305_b(i).func_74760_g("weight");
/* 4160 */           return weight;
/*      */         } 
/*      */       } 
/*      */     } 
/* 4164 */     return 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public static double TransSaiRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv) {
/* 4169 */     return getKiRegenSaiyan(curAtr, r, st, SklX, cr, resrv, false, false);
/*      */   }
/*      */   
/*      */   public static double TransSaiRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct) {
/* 4173 */     return getKiRegenSaiyan(curAtr, r, st, SklX, cr, resrv, ultraInstinct, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static double getKiRegenSaiyan(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
/* 4178 */     double c = 0.0D;
/* 4179 */     if (st > 0) {
/*      */ 
/*      */ 
/*      */       
/* 4183 */       int might = (int)((getPlayerAttribute(curAtr, 0, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[0]) * 0.4F + (getPlayerAttribute(curAtr, 1, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[1]) * 0.25F + (getPlayerAttribute(curAtr, 3, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[3]) * 0.35F);
/* 4184 */       c = (might * TransSaiRgn[st]);
/*      */     } else {
/*      */       float regen;
/* 4187 */       if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(1, st)) { regen = 1.0F; }
/* 4188 */       else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(1, st)) { regen = 1.0F; }
/* 4189 */       else { regen = TransSaiRgn[st]; }
/* 4190 */        c = r * regen;
/*      */     } 
/*      */     
/* 4193 */     return c;
/*      */   }
/*      */ 
/*      */   
/*      */   public static double getKiRegenHalfSaiyan(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
/* 4198 */     double c = 0.0D;
/* 4199 */     if (st > 0) {
/*      */ 
/*      */ 
/*      */       
/* 4203 */       int might = (int)((getPlayerAttribute(curAtr, 0, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[0]) * 0.4F + (getPlayerAttribute(curAtr, 1, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[1]) * 0.25F + (getPlayerAttribute(curAtr, 3, st, 0, 1, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[3]) * 0.35F);
/* 4204 */       c = (might * TransHalfSaiRgn[st]);
/*      */     } else {
/*      */       float regen;
/* 4207 */       if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(2, st)) { regen = 1.0F; }
/* 4208 */       else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(2, st)) { regen = 1.0F; }
/* 4209 */       else { regen = TransHalfSaiRgn[st]; }
/* 4210 */        c = r * regen;
/*      */     } 
/*      */     
/* 4213 */     return c;
/*      */   }
/*      */ 
/*      */   
/*      */   public static double TransFrRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv) {
/* 4218 */     return getKiRegenArcosian(curAtr, r, st, SklX, cr, resrv, false, false);
/*      */   }
/*      */   
/*      */   public static double TransFrRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct) {
/* 4222 */     return getKiRegenArcosian(curAtr, r, st, SklX, cr, resrv, ultraInstinct, false);
/*      */   }
/*      */   
/*      */   public static double getKiRegenArcosian(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
/* 4226 */     double c = 0.0D;
/* 4227 */     if (st >= 5) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4232 */       int might = (int)((getPlayerAttribute(curAtr, 0, st, 0, 4, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[0]) * 0.4F + (getPlayerAttribute(curAtr, 1, st, 0, 4, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[1]) * 0.25F + (getPlayerAttribute(curAtr, 3, st, 0, 4, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[3]) * 0.35F);
/* 4233 */       int skl = SklLvlX(1, SklX);
/* 4234 */       if (skl != 0) {
/*      */         double m;
/* 4236 */         if (st == 6) {
/* 4237 */           m = (1.0F - 0.1F * (skl - 6.0F));
/*      */         } else {
/* 4239 */           m = (1.0F - 0.1F * (skl - 3.0F));
/*      */         } 
/* 4241 */         c = (might * TransFrRgn[st]) * m;
/*      */       } 
/*      */     } else {
/*      */       float regen;
/* 4245 */       if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(4, st)) { regen = 1.0F; }
/* 4246 */       else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(4, st)) { regen = 1.0F; }
/* 4247 */       else { regen = TransFrRgn[st]; }
/* 4248 */        c = r * regen;
/*      */     } 
/* 4250 */     return c;
/*      */   }
/*      */ 
/*      */   
/*      */   public static double TransHmRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv) {
/* 4255 */     return getKiRegenHuman(curAtr, r, st, SklX, cr, resrv, false, false);
/*      */   }
/*      */   
/*      */   public static double TransHmRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct) {
/* 4259 */     return getKiRegenHuman(curAtr, r, st, SklX, cr, resrv, ultraInstinct, false);
/*      */   }
/*      */   
/*      */   public static double getKiRegenHuman(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
/* 4263 */     double c = 0.0D;
/* 4264 */     if (st > 0) {
/*      */ 
/*      */ 
/*      */       
/* 4268 */       int might = (int)((getPlayerAttribute(curAtr, 0, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[0]) * 0.4F + (getPlayerAttribute(curAtr, 1, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[1]) * 0.25F + (getPlayerAttribute(curAtr, 3, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[3]) * 0.35F);
/* 4269 */       c = (might * TransHmRgn[st]);
/*      */     } else {
/*      */       float regen;
/* 4272 */       if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(0, st)) { regen = 1.0F; }
/* 4273 */       else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(0, st)) { regen = 1.0F; }
/* 4274 */       else { regen = TransHmRgn[st]; }
/* 4275 */        c = r * regen;
/*      */     } 
/*      */     
/* 4278 */     return c;
/*      */   }
/*      */ 
/*      */   
/*      */   public static double TransNaRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv) {
/* 4283 */     return getKiRegenNamekian(curAtr, r, st, SklX, cr, resrv, false, false);
/*      */   }
/*      */   
/*      */   public static double TransNaRegen(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct) {
/* 4287 */     return getKiRegenNamekian(curAtr, r, st, SklX, cr, resrv, ultraInstinct, false);
/*      */   }
/*      */   
/*      */   public static double getKiRegenNamekian(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
/* 4291 */     double c = 0.0D;
/* 4292 */     if (st > 0) {
/*      */ 
/*      */ 
/*      */       
/* 4296 */       int might = (int)((getPlayerAttribute(curAtr, 0, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[0]) * 0.4F + (getPlayerAttribute(curAtr, 1, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[1]) * 0.25F + (getPlayerAttribute(curAtr, 3, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[3]) * 0.35F);
/* 4297 */       c = (might * TransNaRgn[st]);
/*      */     } else {
/*      */       float regen;
/* 4300 */       if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(3, st)) { regen = 1.0F; }
/* 4301 */       else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(3, st)) { regen = 1.0F; }
/* 4302 */       else { regen = TransNaRgn[st]; }
/* 4303 */        c = r * regen;
/*      */     } 
/*      */     
/* 4306 */     return c;
/*      */   }
/*      */ 
/*      */   
/*      */   public static double getKiRegenMajin(int[] curAtr, double r, int st, String SklX, int cr, int resrv, boolean ultraInstinct, boolean godOfDestruction) {
/* 4311 */     double c = 0.0D;
/* 4312 */     if (st > 0) {
/*      */ 
/*      */ 
/*      */       
/* 4316 */       int might = (int)((getPlayerAttribute(curAtr, 0, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[0]) * 0.4F + (getPlayerAttribute(curAtr, 1, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[1]) * 0.25F + (getPlayerAttribute(curAtr, 3, st, 0, 0, SklX, cr, resrv, false, false, false, false, false, 1, null, false) - curAtr[3]) * 0.35F);
/* 4317 */       c = (might * TransMaRgn[st]);
/*      */     } else {
/*      */       float regen;
/* 4320 */       if (godOfDestruction && JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(5, st)) { regen = 1.0F; }
/* 4321 */       else if (ultraInstinct && JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_KI_REGEN_CONFIG && inBaseForm(5, st)) { regen = 1.0F; }
/* 4322 */       else { regen = TransMaRgn[st]; }
/* 4323 */        c = r * regen;
/*      */     } 
/*      */     
/* 4326 */     return c;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 4331 */   public static final String[] TransGtsNms = new String[] { "noGate", "Gate1", "Gate2", "Gate3", "Gate4", "Gate5", "Gate6", "Gate7", "Gate8" };
/* 4332 */   public static float[] TransGtsDmg = new float[] { 1.0F, 1.2F, 1.4F, 1.6F, 1.8F, 2.0F, 2.25F, 2.5F, 3.0F };
/* 4333 */   public static float[] TransGtsDmgO = new float[] { 1.0F, 1.2F, 1.4F, 1.6F, 1.8F, 2.0F, 2.25F, 2.5F, 3.0F };
/*      */ 
/*      */   
/*      */   public static double EGtsCost(EntityPlayer p) {
/* 4337 */     int[] a = PlyrAttrbts(p);
/*      */     
/* 4339 */     int skl = SklLvl(0, p);
/* 4340 */     int rc = getByte(p, "jrmcRace");
/* 4341 */     int st = getByte(p, "jrmcState");
/* 4342 */     int st2 = getByte(p, "jrmcState2");
/* 4343 */     int strnTmp = getInt(p, "jrmcStrainTemp");
/* 4344 */     int strn = getInt(p, "jrmcStrain");
/* 4345 */     int might = a[0] / 2 + a[3] / 2;
/* 4346 */     int cons = a[2];
/* 4347 */     double c = (10 - SklLvl(12, p) + st2) * 0.01D;
/*      */     
/* 4349 */     float kc = EGtsFBal(rc, st, st2, skl, strn);
/* 4350 */     c = (JRMCoreConfig.sskai ? 0.0F : kc) + c;
/* 4351 */     double r = 1.0D / cons * might * c;
/* 4352 */     return r;
/*      */   }
/*      */   
/*      */   public static float EGtsFBal(int rc, int st, int st2, int skl, int strn) {
/* 4356 */     float ret = st;
/* 4357 */     if (strn > 0) {
/* 4358 */       ret = (skl + st);
/* 4359 */       return ret * 0.75F;
/*      */     } 
/* 4361 */     return ret;
/*      */   }
/*      */   public static void EGtsStrainAct(NBTTagCompound nbt, int st2, int strn, int strnTmp, int strnAct) {
/* 4364 */     if (strnAct > 0) {
/* 4365 */       nbt.func_74768_a("jrmcStrainActv", --strnAct);
/*      */     }
/* 4367 */     if (st2 == 0 && strn > 0) {
/* 4368 */       nbt.func_74768_a("jrmcStrain", --strn);
/*      */     }
/* 4370 */     if (!JRMCoreConfig.sskai && (
/* 4371 */       st2 == 0 || strnAct <= 0) && strnTmp > 0) {
/* 4372 */       strn += strnTmp;
/* 4373 */       strn = (strn > 239) ? 239 : strn;
/* 4374 */       nbt.func_74768_a("jrmcStrainActv", strnAct = 0);
/* 4375 */       nbt.func_74768_a("jrmcStrain", strn);
/* 4376 */       nbt.func_74768_a("jrmcStrainTemp", 0);
/*      */     } 
/*      */   }
/*      */   public static double EGtsDmg(EntityPlayer p) {
/* 4380 */     return TransGtsDmg[PlyrState2(p)];
/*      */   } public static double EGtsDmg() {
/* 4382 */     return TransGtsDmg[State2];
/*      */   }
/*      */ 
/*      */   
/* 4386 */   public static String[] TransKaiNms = new String[] { "1", "x2", "x3", "x4", "x5", "x10", "x20" };
/* 4387 */   public static String[] TransKaiNmsO = TransKaiNms;
/* 4388 */   public static float[] TransKaiDmg = new float[TransKaiNms.length];
/* 4389 */   public static float[] TransKaiDmgO = new float[TransKaiNms.length];
/* 4390 */   public static float[] TransKaiDrainRace = new float[Races.length];
/* 4391 */   public static float[] TransKaiDrainORace = new float[Races.length];
/* 4392 */   public static float[] TransKaiDrainLevel = new float[TransKaiNms.length];
/* 4393 */   public static float[] TransKaiDrainOLevel = new float[TransKaiNms.length];
/* 4394 */   public static float[] TransMngDmg = new float[1];
/* 4395 */   public static float[] TransMngDmgO = new float[1];
/*      */   
/*      */   public static double KaiKCost(EntityPlayer p) {
/* 4398 */     int[] attributes = PlyrAttrbts(p);
/* 4399 */     int skl = SklLvlX(1, getString(p, "jrmcSSltX"));
/* 4400 */     int race = getByte(p, "jrmcRace");
/* 4401 */     int state = getByte(p, "jrmcState");
/* 4402 */     int state2 = getByte(p, "jrmcState2");
/* 4403 */     int strnTmp = getInt(p, "jrmcStrainTemp");
/* 4404 */     int strn = getInt(p, "jrmcStrain");
/* 4405 */     boolean mystic = StusEfcts(13, getString(p, "jrmcStatusEff"));
/* 4406 */     int might = attributes[0] / 2 + attributes[3] / 2;
/* 4407 */     int cons = attributes[2];
/* 4408 */     double c = (10 - SklLvl(8, p) + state2) * 0.01D;
/* 4409 */     float kc = KaiKFBal(race, state, state2, skl, strn);
/* 4410 */     c = (JRMCoreConfig.sskai ? 0.0F : kc) + c;
/* 4411 */     int kaiokenState = !DBC() ? 0 : (mystic ? ((JRMCoreConfig.KaiokenFormHealthCost[race]).length - 1) : state);
/*      */     
/* 4413 */     double cost = 1.0D / cons * might * c * TransKaiDrainRace[race] * TransKaiDrainLevel[state2] * (DBC() ? JRMCoreConfig.KaiokenFormHealthCost[race][kaiokenState] : 1.0F);
/*      */     
/* 4415 */     if (JGConfigDBCFormMastery.FM_Enabled) {
/* 4416 */       int kkID = getFormID("Kaioken", race);
/* 4417 */       double kkMasteryLevel = getFormMasteryValue(p, kkID);
/*      */       
/* 4419 */       float costMulti = (float)JGConfigDBCFormMastery.getCostMulti(kkMasteryLevel, race, kkID, JGConfigDBCFormMastery.DATA_ID_KAIOKEN_HEALTH_COST_MULTI);
/*      */       
/* 4421 */       cost *= costMulti;
/*      */     } 
/*      */     
/* 4424 */     return cost;
/*      */   }
/*      */   
/*      */   public static float KaiKFBal(int rc, int st, int st2, int skl, int strn) {
/* 4428 */     float ret = st;
/* 4429 */     if (strn > 0) {
/* 4430 */       if (rc_arc(rc)) {
/* 4431 */         st -= 4;
/* 4432 */         st = (st < 0) ? 0 : (st * 3);
/* 4433 */         ret = st;
/* 4434 */       } else if (rc_humNam(rc)) {
/* 4435 */         ret = (skl + st);
/*      */       } 
/* 4437 */       return ret * 0.75F;
/*      */     } 
/* 4439 */     if (rc_sai(rc)) {
/* 4440 */       if (st == 10 && st2 < 4) {
/* 4441 */         ret = 1.2F;
/*      */       } else {
/* 4443 */         ret = 0.6F * st;
/*      */       } 
/* 4445 */     } else if (rc_humNam(rc)) {
/* 4446 */       if (st == 3 && st2 < 4)
/* 4447 */       { ret = 0.9F; }
/* 4448 */       else if (st == 3)
/* 4449 */       { ret = st * 2.4F; }
/*      */       else
/* 4451 */       { ret = st; } 
/* 4452 */     } else if (isRaceMajin(rc)) {
/* 4453 */       if (st == 4 && st2 < 4)
/* 4454 */       { ret = 0.9F; }
/* 4455 */       else if (st == 4)
/* 4456 */       { ret = st * 2.4F; }
/*      */       else
/* 4458 */       { ret = st; } 
/* 4459 */     } else if (rc_arc(rc)) {
/* 4460 */       if (st == 7 && st2 < 4) {
/* 4461 */         ret = 1.35F;
/*      */       } else {
/* 4463 */         st -= 4;
/* 4464 */         st = (st < 0) ? 0 : (st * 3);
/* 4465 */         ret = 0.6F * st;
/*      */       } 
/*      */     } 
/* 4468 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void KaiKStrainAct(NBTTagCompound nbt, int st2, int strn, int strnTmp, int strnAct) {
/* 4474 */     KaiKStrainAct(null, nbt, st2, strn, strnTmp, strnAct);
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
/*      */   public static void KaiKStrainAct(EntityPlayer player, NBTTagCompound nbt, int st2, int strn, int strnTmp, int strnAct) {
/* 4486 */     if (strnAct > 0) {
/* 4487 */       nbt.func_74768_a("jrmcStrainActv", --strnAct);
/*      */     }
/*      */     
/* 4490 */     if (st2 == 0 && strn > 0) {
/* 4491 */       nbt.func_74768_a("jrmcStrain", --strn);
/*      */     }
/*      */     
/* 4494 */     if (!JRMCoreConfig.sskai && (
/* 4495 */       st2 == 0 || strnAct <= 0) && strnTmp > 0) {
/* 4496 */       strn += strnTmp;
/* 4497 */       strn = (strn > 239) ? 239 : strn;
/* 4498 */       nbt.func_74768_a("jrmcStrainActv", strnAct = 0);
/* 4499 */       nbt.func_74768_a("jrmcStrain", strn);
/* 4500 */       nbt.func_74768_a("jrmcStrainTemp", 0);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static double KaiKDmg(EntityPlayer p) {
/* 4505 */     return TransKaiDmg[PlyrState2(p)];
/*      */   } public static double KaiKDmg() {
/* 4507 */     return TransKaiDmg[State2];
/*      */   } public static double NngDmg(EntityPlayer p) {
/* 4509 */     return TransMngDmg[1];
/*      */   } public static double NmgDmg() {
/* 4511 */     return TransMngDmg[1];
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
/*      */   public static int Algnmnt(int a) {
/* 4523 */     if (a > 66) return 0; 
/* 4524 */     if (a <= 66 && a >= 33) return 1; 
/* 4525 */     return 2;
/* 4526 */   } public static final String[] AlgnmntNms = new String[] { "Good", "Neutral", "Evil" };
/* 4527 */   public static boolean Algnmnt_Good(int a) { return (Algnmnt(a) == 0); }
/* 4528 */   public static boolean Algnmnt_Neut(int a) { return (Algnmnt(a) == 1); } public static boolean Algnmnt_Evil(int a) {
/* 4529 */     return (Algnmnt(a) == 2);
/*      */   }
/*      */   public static int Algnmnt_rc(int a) {
/* 4532 */     return Algnmnt_Good(a) ? 11075583 : (Algnmnt_Evil(a) ? 16646144 : 14526719);
/*      */   }
/*      */   
/* 4535 */   public static final int[] techCol = new int[] { 0, 16777215, 53999, 13801198, 14812441, 328965, 5695066, 16706880, 16625664, 15294875, 11482731, 16752576, 3135190, 1477514, 8974316, 5263440, 11184810, 20414, 7455999, 9385113, 14859007, 8389913, 16677498, 4230966, 9829013, 12233002, 16776101, 16368896, 16762000, 6565897, 13007647 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4541 */   public static final int[] techCol2 = new int[] { 0, 16777215, 12575487, 16242687, 16736618, 328965, 10878885, 16775651, 16633177, 16350129, 13059966, 16757714, 3135190, 2928043, 11862015, 7105644, 12763842, 2063832, 9885951, 11094961, 15913983, 10032686, 16749714, 5940568, 11730862, 14009926, 16777156, 16766720, 16768171, 7750429, 13800511 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4547 */   public static final int[] techCol3 = new int[] { 0, 8224125, 2499671, 2559542, 4786450, 197379, 2505498, 3477505, 6170377, 10820956, 7539241, 15633325, 38807, 21844, 6077370, 2500134, 8553090, 10890, 4822478, 6753140, 12750553, 5308930, 13980735, 1206284, 6736224, 9793536, 15390586, 13146368, 13797206, 3739392, 9718786 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4553 */   public static final int[] techCol4 = new int[] { 0, 13619151, 38899, 9247404, 12851243, 328965, 2479675, 16437248, 15040768, 13128827, 10559571, 15633325, 1751735, 28782, 7394005, 4144959, 9868950, 15781, 6532069, 7806595, 14001385, 6816272, 15297119, 2848800, 8249721, 10915606, 15984268, 14725632, 15509107, 5315587, 11494929 };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4558 */   public static final String[] techColName = new String[] { "AlignmentBased", "white", "blue", "purple", "red", "black", "green", "yellow", "orange", "pink", "magenta", "lightPink", "cyan", "darkCyan", "lightCyan", "darkGray", "gray", "darkBlue", "lightBlue", "darkPurple", "lightPurple", "darkRed", "lightRed", "darkGreen", "lime", "darkYellow", "lightYellow", "gold", "lightOrange", "darkBrown", "lightBrown" };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte techMult = 20;
/*      */ 
/*      */ 
/*      */   
/* 4567 */   public static final int[] techBase = new int[] { 1, 0, 1, 1, 1, 10, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 };
/* 4568 */   public static final int[] techMin = new int[] { 1, 0, 1, 0, 0, 10, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 };
/* 4569 */   public static final int[] techMax = new int[] { 20, 1, 30, 8, 2, 100, 1, 0, 0, 0, 30, 3, 10, 10, 10, 100 };
/* 4570 */   public static final int[] techUpg = new int[] { 0, 0, 0, 1, 1, 10, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 };
/*      */   
/* 4572 */   public static final int[] techNCBase = new int[] { 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 };
/* 4573 */   public static final int[] techNCMin = new int[] { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 };
/* 4574 */   public static final int[] techNCMax = new int[] { 20, 1, 30, 2, 2, 1, 4, 24, 24, 10, 8, 10, 10, 10, 10, 100 };
/* 4575 */   public static final int[] techNCUpg = new int[] { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 };
/*      */ 
/*      */   
/*      */   public static final byte TECH_AMOUNT_CUSTOM = 4;
/*      */ 
/*      */   
/*      */   public static final byte TECH_AMOUNT_FIX = 4;
/*      */ 
/*      */   
/*      */   public static final byte TECH_AMOUNT = 8;
/*      */ 
/*      */   
/*      */   public static final int tech_statmod_sped = 0;
/*      */ 
/*      */   
/*      */   public static final int tech_statmod_damg = 1;
/*      */ 
/*      */   
/*      */   public static final int tech_statmod_cost = 2;
/*      */ 
/*      */   
/*      */   public static final int tech_statmod_cast = 3;
/*      */ 
/*      */   
/*      */   public static final int tech_statmod_cool = 4;
/*      */ 
/*      */   
/*      */   public static final int tech_statmod_dens = 5;
/*      */ 
/*      */   
/*      */   public static final int tech_statmod_size = 6;
/*      */ 
/*      */   
/* 4608 */   public static final String[] techDBCstatmods = new String[] { "SpeedInc", "DamageInc", "CostRed", "CastRed", "CoolRed", "DensityInc", "SizeInc" };
/*      */   
/*      */   public static byte[] tech_statmods(String s) {
/* 4611 */     String[] sp = s.split(",");
/* 4612 */     byte[] rs = new byte[sp.length];
/* 4613 */     for (int i = 0; i < sp.length; i++) {
/* 4614 */       rs[i] = Byte.parseByte(sp[i]);
/*      */     }
/* 4616 */     return rs;
/*      */   }
/*      */   public static String tech_statmods_Rev(String[] s) {
/* 4619 */     String sp = "";
/* 4620 */     for (int i = 0; i < s.length; i++) {
/* 4621 */       sp = sp + "," + s[i];
/*      */     }
/* 4623 */     return sp.substring(1);
/*      */   }
/*      */   
/* 4626 */   private static final byte[] tech_stats = new byte[] { 10, 18, 25, 31, 36, 40, 43, 45, 46, 47, 48 }; public static final int tech_type_wave = 0; public static final int tech_type_ball = 1; public static final int tech_type_disk = 2; public static final int tech_type_laser = 3; public static final int tech_type_spiral = 4; public static final int tech_type_large = 5; public static final int tech_type_barrage = 6; public static final int tech_type_defensive_kiai = 7; public static final int tech_type_offensive_kiai = 8;
/*      */   public static float tech_statmod(byte[] rs, int sm) {
/* 4628 */     switch (sm) {
/*      */       case 0:
/* 4630 */         return tech_stats[rs[sm]] * 0.02F;
/*      */       case 1:
/* 4632 */         return tech_stats[rs[sm]] * 0.01F;
/*      */       case 2:
/* 4634 */         return -tech_stats[rs[sm]] * 0.01F;
/*      */       case 3:
/* 4636 */         return -tech_stats[rs[sm]] * 0.01F;
/*      */       case 4:
/* 4638 */         return -tech_stats[rs[sm]] * 0.01F;
/*      */       case 5:
/* 4640 */         return rs[sm];
/*      */       case 6:
/* 4642 */         return tech_stats[rs[sm]] * 0.02F;
/*      */     } 
/* 4644 */     return 0.0F;
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
/* 4659 */   public static final String[] techDBCName = new String[] { "TName", "TAcquired", "TOwner", "TType", "TSpeed", "TDamage", "TEffect", "TEnergyCost", "TCasttime", "TCooldown", "TColor", "TDensity", "TIncantation", "TFire", "TMove", "", "TExp", "TLvl", "TUpg", "TStats" };
/* 4660 */   public static final String[] techDBCTypes = new String[] { "Wave", "Blast", "Disk", "Laser", "Spiral", "BigBlast", "Barrage", "Shield", "Explosion" };
/*      */   
/* 4662 */   public static final float[] techDBCaddTYCost = new float[] { 1.2F, 1.0F, 1.5F, 1.3F, 1.7F, 1.8F, 0.3F, 1.2F, 1.7F };
/* 4663 */   public static final float[] techDBCct = new float[] { 3.0F, 2.0F, 4.0F, 1.0F, 3.0F, 8.0F, 0.2F, 2.0F, 5.0F };
/* 4664 */   public static final float[] techDBCcd = new float[] { 20.0F, 10.0F, 5.0F, 3.0F, 15.0F, 60.0F, 0.2F, 15.0F, 45.0F };
/* 4665 */   public static final String[] techDBCEffects = new String[] { "No", "Yes" };
/* 4666 */   public static final String[] techDBCAcquired = new String[] { "Learned", "Selfmade" };
/* 4667 */   public static final String[] techDBCSpeed = new String[] { "Slow", "Average", "Fast", "VeryFast" };
/* 4668 */   public static final float[] techDBCaddSPCost = new float[] { 0.9F, 1.0F, 1.2F, 1.4F };
/* 4669 */   public static final byte[] techDBCstatsDefault = new byte[] { 0, 0, 0, 0, 0, 0, 0 };
/*      */   public static int techDBCty(String[] t) {
/* 4671 */     return Integer.parseInt(t[3]);
/*      */   }
/*      */   public static float techDBCct(String[] t, byte[] sts) {
/* 4674 */     int ty = Integer.parseInt(t[3]);
/*      */     
/* 4676 */     float ct = (ty == 6) ? techDBCct[ty] : (Integer.parseInt(t[5]) / 20.0F + techDBCct[ty]);
/* 4677 */     return ct + ct * tech_statmod(sts, 3);
/*      */   }
/*      */   public static float techDBCctWc(String[] t, byte[] sts) {
/* 4680 */     return techDBCct(t, sts) * 20.0F;
/*      */   }
/*      */   public static float techDBCcd(String[] t, byte[] sts) {
/* 4683 */     int ty = Integer.parseInt(t[3]);
/* 4684 */     return techDBCcd[ty] + techDBCcd[ty] * tech_statmod(sts, 4);
/*      */   }
/*      */   public static int techDBCdmg(String[] t, int w) {
/* 4687 */     return (int)(Integer.parseInt(t[5]) * 0.01D * w);
/*      */   }
/*      */   public static int techDBCdmg(String[] t, int w, byte[] sts) {
/* 4690 */     double dm = Integer.parseInt(t[5]) * 0.01D * w;
/* 4691 */     return (int)(dm + dm * tech_statmod(sts, 1));
/*      */   }
/*      */   public static int techDBCkic(String[] listOfAttacks, int playerStat, byte[] kiAttackStats) {
/* 4694 */     int ty = Integer.parseInt(listOfAttacks[3]);
/* 4695 */     int sp = Integer.parseInt(listOfAttacks[4]);
/* 4696 */     int ef = Integer.parseInt(listOfAttacks[6]) + 1;
/* 4697 */     double ct = techDBCdmg(listOfAttacks, playerStat) * techDBCaddTYCost[ty] * techDBCaddSPCost[sp] * ef;
/* 4698 */     int dm = (int)(ct + ct * tech_statmod(kiAttackStats, 2));
/* 4699 */     return (int)(dm * (DBC() ? JRMCoreHDBC.DBCgetConfigTechCostMod() : 100.0D) * 0.009999999776482582D);
/*      */   }
/*      */   public static int techDBCtpc(String[] t) {
/* 4702 */     return techDBCtpc(t, false);
/*      */   }
/*      */   public static int techDBCtpc(String[] t, boolean teach) {
/* 4705 */     int dm = Integer.parseInt(t[5]);
/* 4706 */     int ty = Integer.parseInt(t[3]);
/* 4707 */     int cl = Integer.parseInt(t[10]);
/* 4708 */     int sp = Integer.parseInt(t[4]);
/* 4709 */     int ef = Integer.parseInt(t[6]) + 1;
/* 4710 */     int lv = 1;
/* 4711 */     int up = 1;
/* 4712 */     if (t.length >= 17 && teach) {
/* 4713 */       lv += Integer.parseInt(t[17]);
/* 4714 */       up += Integer.parseInt(t[18]);
/*      */     } 
/* 4716 */     return (int)((dm * 10) * techDBCaddTYCost[ty] * techDBCaddSPCost[sp] * ef * lv * up + ((cl > 0) ? 100 : false));
/*      */   }
/*      */   
/* 4719 */   public static final String[] techName = new String[] { "Name", "Acquired", "Owner", "Type", "Speed", "Damage", "Effect", "Energy Cost", "Casttime", "Cooldown", "Color", "Density", "Incantation", "Fire", "Move" };
/* 4720 */   public static final String[] techTypes = new String[] { "Wave", "Blast", "Disk", "Laser", "Large", "Barrage", "Spiral", "Defensive Kiai", "Offensive Kiai" };
/* 4721 */   public static final String[] techEffects = new String[] { "Single", "Explosive", "AOE" };
/* 4722 */   public static final String[] techAcquired = new String[] { "Learned", "Selfmade" };
/* 4723 */   public static final String[] techSpeed = new String[] { "Very Slow", "Slow", "Average", "Fast", "Very Fast", "Extreme Fast" };
/* 4724 */   public static final String[] techSndIncBeam = new String[] { "cbeam1s", "cbeam2s", "cbeam3s", "cbeam4s", "cbeam5s", "cbeam6s", "cbeam7s" };
/* 4725 */   public static final String[] techSndFireBeam = new String[] { "fbeam1s", "fbeam2s", "fbeam3s", "fbeam4s", "fbeam5s", "fbeam6s", "fbeam7s", "fbeam8s", "fbeam9s", "fbeam10s", "fbeam11s", "fbeam12s", "fbeam13s" };
/* 4726 */   public static final String[] techSndMoveBeam = new String[] { "mbeam1s", "mbeam2s" };
/* 4727 */   public static final String[] techSndIncDisk = new String[] { "cdisk1s", "cdisk2s" };
/* 4728 */   public static final String[] techSndFireDisk = new String[] { "fdisk1s" };
/* 4729 */   public static final String[] techSndMoveDisk = new String[] { "mdisk1s" };
/* 4730 */   public static final String[] techSndFireLeser = new String[] { "fleser1s", "fleser2s" };
/* 4731 */   public static final String[] techSndPMInc = new String[] { "DBC.hame", "DBC3.cspiritbomb", "DBC3.ckidisc", "DBC3.cspecialbeamcannon", "DBC3.cmasenko", "DBC3.cbigbang", "DBC2.finalflash_charge", "DBC3.cgallitgun", "DBC3.cburning", "DBC2.deathball_charge", "1610.pwbl" };
/* 4732 */   public static final String[] techSndPMIncFire = new String[] { "DBC.ha", "DBC3.fspiritbomb", "DBC2.disc_fire", "DBC3.fspecialbeamcannon", "DBC3.fmasenko", "DBC2.bigbang_fire", "DBC3.ffinalflash", "DBC3.fgallitgun", "DBC3.fburning", "DBC2.deathball_fire" };
/* 4733 */   public static final String[] techSndPMFire = new String[] { "DBC.hamehafire", "DBC2.blast", "DBC2.kiball_release", "DBC2.basicbeam_fire" };
/* 4734 */   public static final String[] techSndPMMove = new String[] { "DBC4.mbeam1s", "DBC4.mbeam2s" };
/*      */   
/*      */   public static final String techTPCost = "TP Current/Cost";
/*      */   
/*      */   public static final int masterNone = 0;
/*      */   
/*      */   public static final int masterGeneral = 1;
/*      */   public static final int masterRoshi = 2;
/*      */   public static final int masterShen = 3;
/*      */   public static final int masterKorin = 4;
/*      */   public static final int masterKami = 5;
/*      */   public static final int masterKai = 6;
/*      */   public static final int masterKrillin = 7;
/*      */   public static final int masterPiccolo = 8;
/*      */   public static final int masterVegeta = 9;
/*      */   public static final int masterTrunks = 10;
/*      */   public static final int masterFreiza = 11;
/*      */   public static final int masterCell = 12;
/*      */   public static final int masterGoku = 13;
/*      */   public static final int masterGohan = 14;
/*      */   public static final int masterBabidi = 15;
/*      */   public static final int masterJin = 16;
/*      */   public static final int masterGuru = 17;
/*      */   public static final int masterWhis = 18;
/* 4758 */   public static final String[] Masters = new String[] { "None", "General", "Master Roshi", "Master Shen", "Korin", "Kami", "King Kai", "Krillin", "Piccolo", "Vegeta", "Trunks", "Freiza", "Master Cell", "Son Goku", "Son Gohan", "Babidi", "Jin", "Guru", "Whis" };
/* 4759 */   public static final String[][] pmdbc = new String[][] { { "KAHame", "0", "2", "0", "1", "55", "0", "0", "0", "0", "2", "1", "1", "1", "1", "10" }, { "KABlast", "0", "1", "1", "1", "15", "0", "0", "0", "0", "0", "1", "0", "2", "0", "2" }, { "KASpiritbomb", "0", "6", "5", "0", "95", "1", "0", "0", "0", "1", "1", "2", "0", "0", "15" }, { "KAEnergyDisk", "0", "7", "2", "2", "45", "0", "0", "0", "0", "7", "1", "3", "0", "0", "6" }, { "KAMakanko", "0", "8", "4", "1", "75", "0", "0", "0", "0", "7", "1", "4", "0", "1", "12" }, { "KAMasenko", "0", "8", "0", "1", "55", "0", "0", "0", "0", "8", "1", "5", "0", "1", "7" }, { "KABigBang", "0", "9", "1", "2", "65", "1", "0", "0", "0", "1", "1", "6", "0", "0", "1" }, { "KAFinalFlash", "0", "9", "0", "1", "85", "0", "0", "0", "0", "7", "1", "7", "0", "1", "13" }, { "KAGalicGun", "0", "9", "0", "1", "55", "0", "0", "0", "0", "3", "1", "8", "0", "1", "9" }, { "KABurningAtt", "0", "10", "1", "2", "65", "1", "0", "0", "0", "7", "1", "9", "0", "1", "3" }, { "KAPlanetDest", "0", "11", "5", "0", "95", "1", "0", "0", "0", "4", "1", "10", "0", "0", "14" }, { "KAFakeMoon", "0", "9", "1", "0", "30", "0", "300", "0", "0", "0", "0", "11", "0", "0", "18" } };
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int tech_element_fire = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int tech_element_wind = 1;
/*      */ 
/*      */   
/*      */   public static final int tech_element_lightning = 2;
/*      */ 
/*      */   
/*      */   public static final int tech_element_earth = 3;
/*      */ 
/*      */   
/*      */   public static final int tech_element_water = 4;
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] tech_conv(String[] t) {
/* 4781 */     if (t != null && t.length > 3) {
/* 4782 */       String[] tn = new String[20];
/* 4783 */       for (int i = 0; i < tn.length; i++) {
/* 4784 */         if (i >= t.length)
/* 4785 */         { if (i == 19) { tn[i] = "0,0,0,0,0,0,0"; }
/* 4786 */           else { tn[i] = "0"; }
/*      */            }
/* 4788 */         else { tn[i] = t[i]; }
/*      */       
/*      */       } 
/* 4791 */       return tn;
/*      */     } 
/* 4793 */     return t;
/*      */   }
/*      */   public static String tech_conv(String tr) {
/* 4796 */     String[] t = tech_conv(tr.split(";"));
/* 4797 */     String te = "";
/* 4798 */     for (int i = 0; i < t.length; i++) {
/* 4799 */       te = te + ";" + t[i];
/*      */     }
/* 4801 */     return te.substring(1);
/*      */   }
/*      */   public static String tech_teach(String[] t) {
/* 4804 */     String[] tn = tech_conv(t);
/* 4805 */     String te = "";
/* 4806 */     for (int i = 0; i < t.length; i++) {
/* 4807 */       if (i == 1) {
/* 4808 */         te = te + ";0";
/*      */       } else {
/* 4810 */         te = te + ";" + tn[i];
/*      */       } 
/* 4812 */     }  return te.substring(1);
/*      */   }
/*      */   public static String tech_teach(String tr) {
/* 4815 */     String[] t = tr.split(";");
/* 4816 */     return tech_teach(t);
/*      */   }
/*      */   public static String tech_upgrd(String[] t, int id) {
/* 4819 */     String[] tn = tech_conv(t);
/*      */     
/* 4821 */     int curap = Integer.parseInt(tn[18]);
/* 4822 */     byte[] sts = tech_statmods(tn[19]);
/* 4823 */     String[] stss = new String[sts.length];
/* 4824 */     if (curap > 0) {
/* 4825 */       curap--;
/* 4826 */       for (int j = 0; j < stss.length; j++) {
/* 4827 */         if (j == id) {
/* 4828 */           stss[j] = "" + (sts[j] + 1);
/*      */         } else {
/* 4830 */           stss[j] = "" + sts[j];
/*      */         } 
/*      */       } 
/* 4833 */       tn[18] = "" + curap;
/* 4834 */       tn[19] = "" + tech_statmods_Rev(stss);
/*      */     } 
/* 4836 */     String te = "";
/* 4837 */     for (int i = 0; i < t.length; i++) {
/* 4838 */       te = te + ";" + tn[i];
/*      */     }
/* 4840 */     return te.substring(1);
/*      */   }
/*      */   public static String tech_upgrd(String tr, int id) {
/* 4843 */     String[] t = tr.split(";");
/* 4844 */     return tech_upgrd(t, id);
/*      */   }
/*      */   public static String tech_expgiv(String[] t, int expgained) {
/* 4847 */     String[] tn = tech_conv(t);
/* 4848 */     if (tn.length > 3) {
/* 4849 */       int curexp = Integer.parseInt(tn[16]);
/* 4850 */       int curlvl = Integer.parseInt(tn[17]);
/* 4851 */       int curap = Integer.parseInt(tn[18]);
/* 4852 */       String curst = tn[19];
/* 4853 */       boolean b = true;
/* 4854 */       while (b && curlvl < 10) {
/* 4855 */         int expneed = tech_expNeeded(curlvl, curexp);
/* 4856 */         if (expgained >= expneed) {
/* 4857 */           expgained -= expneed;
/* 4858 */           curlvl++;
/* 4859 */           curap++;
/* 4860 */           curexp = 0;
/*      */           continue;
/*      */         } 
/* 4863 */         curexp += expgained;
/* 4864 */         b = false;
/*      */       } 
/*      */       
/* 4867 */       if (curlvl >= 10);
/*      */ 
/*      */       
/* 4870 */       tn[16] = "" + curexp;
/* 4871 */       tn[17] = "" + curlvl;
/* 4872 */       tn[18] = "" + curap;
/* 4873 */       tn[19] = "" + curst;
/*      */     } 
/* 4875 */     String te = "";
/* 4876 */     for (int i = 0; i < tn.length; i++) {
/* 4877 */       te = te + ";" + tn[i];
/*      */     }
/* 4879 */     return te.substring(1);
/*      */   }
/*      */   public static String tech_expgiv(String tr, int e) {
/* 4882 */     String[] t = tr.split(";");
/* 4883 */     return tech_expgiv(t, e);
/*      */   }
/*      */   public static int tech_getexpFor(int i) {
/* 4886 */     i++;
/* 4887 */     return i * i * (DBC() ? JRMCoreHDBC.DBCgetConfigTechExpNeed() : 15);
/*      */   } public static int tech_expNeeded(int lvl, int exp) {
/* 4889 */     return tech_getexpFor(lvl) - exp;
/*      */   }
/*      */   
/* 4892 */   public static int tech_getlvl(String[] t) { return (20 != t.length) ? 0 : Integer.parseInt(t[17]); }
/* 4893 */   public static int tech_getlvl(String tr) { String[] t = tr.split(";"); return tech_getlvl(t); }
/* 4894 */   public static int tech_getexp(String[] t) { return (20 != t.length) ? 0 : Integer.parseInt(t[16]); }
/* 4895 */   public static int tech_getexp(String tr) { String[] t = tr.split(";"); return tech_getexp(t); }
/* 4896 */   public static int tech_getupg(String[] t) { return (20 != t.length) ? 0 : Integer.parseInt(t[18]); } public static int tech_getupg(String tr) {
/* 4897 */     String[] t = tr.split(";"); return tech_getupg(t);
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
/* 4909 */   public static final String[] techNCName = new String[] { "Name", "Acquired", "Owner", "Type", "Speed", "Damage", "Effect", "Chakra", "Handseals", "Cooldown", "Color", "Density", "Incantation", "Fire", "Move" };
/* 4910 */   public static final String[] techNCTypes = new String[] { "Wave", "Ball", "Disk", "Support", "Offensive", "Taijutsu" };
/* 4911 */   public static final String[] techNCEffects = new String[] { "Fire", "Wind", "Lightning", "Earth", "Water", "Raw", "Yang", "Yin", "YinYang", "Nature" };
/*      */   
/* 4913 */   public static final String[] techNCAcquired = new String[] { "Learned", "Selfmade" };
/* 4914 */   public static final String[] techNCDam = new String[] { "Single", "Explosive" };
/* 4915 */   public static final String[] techNCClassn = new String[] { "Ninjutsu", "Genjutsu", "Taijutsu", "Bunshinjutsu", "IryoNinjutsu", "Kinjutsu", "Hiden", "Fuinjutsu ", "BloodlineLimit", "BloodlineSelection", "Kuchiyose" };
/* 4916 */   public static final String[] techNCSpeed = new String[] { "Slow", "Average", "Fast", "Very Fast" };
/* 4917 */   public static final String[] techNCBunshintyp = new String[] { "Fire", "Wind", "Lightning", "Earth", "Water", "Raw", "Yang", "Shadow", "Yin-Yang", "Nature" };
/*      */   
/* 4919 */   public static final String[] techNCSndIncAff = new String[] { "ka", "fuu", "rai", "do", "sui" };
/* 4920 */   public static final String[] techNCSndIncTyp = new String[] { "wave", "ball", "disk" };
/* 4921 */   public static final String[] techNCSndIncCls = new String[] { "pty", "", "gen", "", "bunshin" };
/* 4922 */   public static final String[] techNCSndIncSpec = new String[] { "kai", "", "", "", "", "", "", "kagebunshin" };
/* 4923 */   public static final String[] techNCSndIncBeam = new String[0];
/* 4924 */   public static final String[] techNCSndIncDisk = new String[0];
/* 4925 */   public static final String[] techNCSndFireBeam = new String[0];
/* 4926 */   public static final String[] techNCSndFireDisk = new String[0];
/* 4927 */   public static final String[] techNCSndMoveBeam = new String[0];
/* 4928 */   public static final String[] techNCSndMoveDisk = new String[0];
/* 4929 */   public static final String[] techNCSndIncPM = new String[] { "", "bunshin_say", "Chidori", "Katon_Gouk", "Katon_Hous", "Rasengan_Ready", "Fire", "Fuuton", "Lightning", "Earth", "Water", "Raw", "Yang", "Yin", "Yin-Yang", "Nature", "Earth_Wall", "Mud_Wall", "Water_Pistol" };
/* 4930 */   public static final String[] techNCSndHitPM = new String[] { "", "bunshin", "Chidori_Hit", "Explosion", "Rasengan_Hit" };
/* 4931 */   public static final String[] techNCSndFirePM = new String[] { "", "bunshin", "Hous_Shoot" };
/*      */   
/* 4933 */   public static final int[] techNCCol = new int[] { 16132352, 14745595, 16382459, 11898202, 5029102, 12379372, 15855792, 2363398, 1908620, 7456823 };
/*      */   
/* 4935 */   public static final int[] techNCCostP = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85 };
/* 4936 */   public static final String[] techNCEffHS = new String[] { "323", "132", "213", "312", "121", "313", "231", "131", "212", "133", "232" };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4941 */   public static final String[] techNCCCHS = new String[] { "1", "2", "3", "12", "13", "21", "23", "31", "32", "121", "122", "123", "131", "132", "133", "211", "212", "213", "231", "232", "233", "311", "312", "313", "321", "322", "323", "1211", "1212", "1213", "1231", "1232", "1233", "1311", "1312", "1313", "1321", "1322", "1323", "2121", "2122", "2123", "2131", "2132", "2133", "2311", "2312", "2313", "2321", "2322", "2323", "3121", "3122", "3123", "3131", "3132", "3133", "3211", "3212", "3213", "3231", "3232", "3233" };
/*      */   
/*      */   public static final int techNCCD = 100;
/*      */   
/*      */   public static final String hsF = "323";
/*      */   
/*      */   public static final String hsD = "132";
/*      */   
/*      */   public static final String hsL = "213";
/*      */   
/*      */   public static final String hsE = "312";
/*      */   
/*      */   public static final String hsW = "121";
/*      */   
/*      */   public static final String hsG = "231";
/*      */   public static final String hsY = "313";
/*      */   public static final String hsN = "131";
/*      */   public static final String hsT = "212";
/*      */   public static final String hsR = "133";
/*      */   public static final String hsH = "232";
/* 4961 */   public static String[] techNCPreMadeSeals = new String[] { "", "", "" };
/*      */   public static int techNCty(String[] t) {
/* 4963 */     return Integer.parseInt(t[3]);
/*      */   }
/*      */   public static String techNCHS(String[] t) {
/* 4966 */     if (t[8].length() == 5) return t[8]; 
/* 4967 */     int ef = Integer.parseInt(t[6]);
/*      */     
/* 4969 */     int ty = Integer.parseInt(t[3]) + 1;
/* 4970 */     int sp = Integer.parseInt(t[4]) + 1;
/* 4971 */     int cc = Integer.parseInt(t[7]);
/* 4972 */     String ctb = techNCCCHS[cc];
/* 4973 */     return techNCEffHS[ef] + sp + ty + ctb;
/*      */   }
/*      */   
/* 4976 */   public static final String[] NarutoNPCnames = new String[] { "", "Sarutobi", "Hiashi", "Fugaku" };
/* 4977 */   public static final int[] NarutoNPCclans = new int[] { 0, 0, 1, 2 };
/*      */   
/* 4979 */   public static final String[] MastersNC = new String[] { "None", "General", "Basic", "YondaimeHokage", "Sasuke", "Uchihaclan", "NidaimeHokage", "BasicMedical", "Hyuugaclan" };
/*      */ 
/*      */   
/* 4982 */   public static final String[][] pmj = new String[][] { { "Rasengan", "0", "3", "1", "1", "10", "5", "10", "13231", "100", "0", "1", "5", "0", "4" }, { "Chidori", "0", "4", "1", "1", "10", "2", "10", "21232", "100", "0", "1", "2", "0", "2" }, { "Housenka", "0", "5", "1", "1", "10", "0", "10", "32213", "100", "0", "1", "4", "0", "3" }, { "Bunshin", "0", "2", "3", "0", "1", "5", "2", "11322", "100", "0", "4", "1", "0", "1" }, { "IwaBunshin", "0", "1", "3", "0", "10", "3", "3", "11313", "100", "0", "4", "1", "0", "1" }, { "MizuBunshin", "0", "1", "3", "0", "10", "4", "3", "11312", "100", "0", "4", "1", "0", "1" }, { "KageBunshin", "0", "6", "3", "0", "20", "5", "5", "11323", "100", "0", "4", "1", "7", "1" }, { "Genjutsu", "0", "1", "3", "2", "5", "7", "5", "23121", "100", "0", "2", "1", "0", "1" }, { "Shousen", "0", "7", "3", "0", "10", "6", "10", "23211", "100", "0", "5", "2", "0", "2" }, { "Susanoo", "0", "5", "3", "0", "10", "6", "10", "0", "100", "0", "6", "2", "0", "2" }, { "Kaiten", "0", "8", "5", "0", "10", "6", "10", "0", "100", "0", "7", "2", "0", "2" }, { "EarthWall", "0", "2", "1", "0", "30", "3", "10", "32211", "100", "0", "1", "16", "0", "1" }, { "MudWall", "0", "2", "1", "0", "50", "3", "15", "32212", "100", "0", "1", "17", "0", "1" }, { "WaterPistol", "0", "2", "1", "2", "8", "4", "8", "31312", "100", "0", "1", "18", "0", "3" } };
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
/*      */   public static int cbtdmg(int ae, int ad, int te, int td) {
/* 5026 */     if ((te == ae + 1 && ae <= 4) || (te == 0 && ae == 4))
/* 5027 */       return td = (int)(td * 0.25F); 
/* 5028 */     if (te == ae)
/* 5029 */       return td = (td > ad) ? (td + ad) : 0; 
/* 5030 */     return td;
/*      */   } public static int cbadmg(int ae, int ad, int te, int td) {
/* 5032 */     if (te == ae)
/* 5033 */       return ad = (ad > td) ? (td + ad) : 0; 
/* 5034 */     return ad;
/*      */   }
/*      */   
/*      */   public static String[] techs(byte i) {
/* 5038 */     if (i < 4 && tech(i) != null) {
/* 5039 */       return tech(i);
/*      */     }
/* 5041 */     if (i >= 4 && techsPM(i - 4) >= 0) {
/* 5042 */       return (Pwrtyp == 2) ? pmj[techsPM(i - 4)] : ((Pwrtyp == 1) ? pmdbc[techsPM(i - 4)] : null);
/*      */     }
/* 5044 */     return null;
/*      */   }
/*      */   public static String techs(byte i, int f) {
/* 5047 */     if (i < 4 && tech(i) != null) {
/* 5048 */       return (f == 8) ? techNCHS(tech(i)) : tech(i)[f];
/*      */     }
/* 5050 */     if (i >= 4 && techsPM(i - 4) >= 0) {
/* 5051 */       return (Pwrtyp == 2) ? pmj[techsPM(i - 4)][f] : ((Pwrtyp == 1) ? pmdbc[techsPM(i - 4)][f] : "");
/*      */     }
/* 5053 */     return "";
/*      */   }
/*      */   public static int techsPM(int j) {
/* 5056 */     if (j >= 0 && techPM != null && techPM.length > j) {
/* 5057 */       return techPM[j];
/*      */     }
/* 5059 */     return -1;
/*      */   }
/*      */   
/*      */   public static boolean techOwnd(int i, byte pwr) {
/* 5063 */     return techOwnd(i, (pwr == 1) ? pmdbc : pmj);
/*      */   }
/*      */   public static boolean techOwnd(int i, String[][] s) {
/* 5066 */     for (byte it = 0; it < 4; it = (byte)(it + 1)) {
/* 5067 */       int pm = techsPM(it);
/* 5068 */       if (s.length > i && pm == i)
/* 5069 */         return true; 
/* 5070 */     }  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 5075 */   public static final String[] dmgMlTyps = new String[] { "Crushing", "Piercing", "Slashing" };
/*      */   
/*      */   public static final String EXP = "jrmcExp";
/*      */   public static final String TP = "jrmcTp";
/*      */   public static final String TPint = "jrmcTpint";
/*      */   public static final String tp = "Training Points";
/*      */   public static final String cost = "Cost";
/*      */   public static final String AP = "jrmcAp";
/*      */   public static final int MaxAttribute = 1000000000;
/*      */   public static final int MaxTP = 2000000000;
/*      */   
/*      */   public static int[] PlyrAttrbtsC(EntityPlayer p) {
/* 5087 */     String d = data(p.func_70005_c_(), 14, "10,10,10,10,10,10");
/* 5088 */     if (d != "") {
/* 5089 */       String[] a = d.split(",");
/* 5090 */       int[] PlyrAttrbts = new int[a.length];
/* 5091 */       for (int i1 = 0; i1 < PlyrAttrbts.length; ) { PlyrAttrbts[i1] = Integer.parseInt(a[i1]); i1++; }
/* 5092 */        return PlyrAttrbts;
/*      */     } 
/* 5094 */     return new int[] { 10, 10, 10, 10, 10, 10 };
/*      */   }
/* 5096 */   public static int[] PlyrAttrbts() { return PlyrAttrbts; } public static int[] PlyrAttrbts(EntityPlayer p) {
/* 5097 */     return PlyrAttrbts(p, true);
/*      */   } public static int[] PlyrAttrbts(EntityPlayer p, boolean fused) {
/* 5099 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 5100 */     if (side == Side.SERVER) {
/* 5101 */       NBTTagCompound nbt = nbt(p);
/*      */       
/* 5103 */       if (fused) {
/*      */         
/* 5105 */         String Fzn = nbt.func_74779_i("jrmcFuzion");
/*      */         
/* 5107 */         if (Fzn.contains(",")) {
/* 5108 */           String[] FznA = Fzn.split(",");
/*      */           
/* 5110 */           if (FznA.length == 3) {
/*      */             
/* 5112 */             MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 5113 */             EntityPlayerMP entityPlayerMP1 = getPlayerForUsername(server, FznA[0]);
/* 5114 */             EntityPlayerMP entityPlayerMP2 = getPlayerForUsername(server, FznA[1]);
/*      */             
/* 5116 */             if (entityPlayerMP1 != null && entityPlayerMP2 != null)
/*      */             {
/* 5118 */               return PlyrAttrbts((EntityPlayer)entityPlayerMP1, (EntityPlayer)entityPlayerMP2);
/*      */             }
/*      */ 
/*      */             
/* 5122 */             nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
/* 5123 */             if (entityPlayerMP1 != null) {
/*      */               
/* 5125 */               NBTTagCompound nbt1 = nbt((EntityPlayer)entityPlayerMP1);
/* 5126 */               StusEfcts(10, nbt1, false);
/* 5127 */               StusEfcts(11, nbt1, false);
/*      */             } 
/*      */             
/* 5130 */             if (entityPlayerMP2 != null) {
/*      */               
/* 5132 */               NBTTagCompound nbt2 = nbt((EntityPlayer)entityPlayerMP2);
/* 5133 */               StusEfcts(10, nbt2, false);
/* 5134 */               StusEfcts(11, nbt2, false);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 5143 */       int[] PlyrAttrbts = new int[JRMCoreH.PlyrAttrbts.length]; byte i;
/* 5144 */       for (i = 0; i < AttrbtNbt.length; i = (byte)(i + 1)) {
/*      */         
/* 5146 */         if ((((nbt.func_74781_a(AttrbtNbtI[i]) == null) ? 1 : 0) & ((nbt.func_74781_a(AttrbtNbt[i]) != null) ? 1 : 0)) != 0) {
/*      */           
/* 5148 */           nbt.func_74768_a(AttrbtNbtI[i], nbt.func_74765_d(AttrbtNbt[i]));
/* 5149 */           nbt.func_82580_o(AttrbtNbt[i]);
/*      */         }
/* 5151 */         else if (nbt.func_74781_a(AttrbtNbtI[i]) == null) {
/*      */           
/* 5153 */           nbt.func_74768_a(AttrbtNbtI[i], 1);
/*      */         } 
/* 5155 */         int r = etXq4V(nbt.func_74762_e(AttrbtNbtI[i]));
/* 5156 */         PlyrAttrbts[i] = r;
/*      */       } 
/* 5158 */       return PlyrAttrbts;
/*      */     } 
/* 5160 */     return JRMCoreH.PlyrAttrbts;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] PlyrSkills(EntityPlayer p) {
/* 5165 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 5166 */     if (side == Side.SERVER) {
/* 5167 */       NBTTagCompound nbt = nbt(p);
/* 5168 */       if (nbt.func_74781_a("jrmcSSlts") == null) nbt.func_74778_a("jrmcSSlts", ","); 
/* 5169 */       String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
/* 5170 */       return PlyrSkills;
/*      */     } 
/* 5172 */     return JRMCoreH.PlyrSkills;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean PlyrSettingsI(EntityPlayer p, int ps, int i) {
/* 5181 */     return (PlyrSettings(p, ps) == i);
/*      */   } public static boolean PlyrSettingsB(EntityPlayer p, int ps) {
/* 5183 */     return (PlyrSettings(p, ps) >= 0);
/*      */   }
/*      */   public static int PlyrSettings(EntityPlayer p, int ps) {
/* 5186 */     String n = getString(p, "jrmcSettings").trim();
/* 5187 */     for (int i = 0; i < n.length() / 2; i++) {
/* 5188 */       String c = sa(n, i * 2);
/* 5189 */       if (c.equals(PlyrSttngs[ps])) {
/* 5190 */         return saI(n, i * 2 + 1);
/*      */       }
/*      */     } 
/* 5193 */     return -1;
/*      */   }
/*      */   
/*      */   public static boolean PlyrSettingsI(NBTTagCompound nbt, int ps, int i) {
/* 5197 */     return (PlyrSettings(nbt, ps) == i);
/*      */   } public static boolean PlyrSettingsB(NBTTagCompound nbt, int ps) {
/* 5199 */     return (PlyrSettings(nbt, ps) >= 0);
/*      */   }
/*      */   public static int PlyrSettings(NBTTagCompound nbt, int ps) {
/* 5202 */     String n = nbt.func_74779_i("jrmcSettings").trim();
/* 5203 */     for (int i = 0; i < n.length() / 2; i++) {
/* 5204 */       String c = sa(n, i * 2);
/* 5205 */       if (c.equals(PlyrSttngs[ps])) {
/* 5206 */         return saI(n, i * 2 + 1);
/*      */       }
/*      */     } 
/* 5209 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void PlyrSettingsRem(EntityPlayer p, int ps) {
/* 5214 */     String n = getString(p, "jrmcSettings").trim();
/* 5215 */     for (int i = 0; i < n.length() / 2; i++) {
/* 5216 */       String c = sa(n, i * 2);
/* 5217 */       if (c.equals(PlyrSttngs[ps])) {
/* 5218 */         String x = sa(n, i * 2 + 1);
/* 5219 */         setString(n.replaceAll(c + x, ""), p, "jrmcSettings");
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void PlyrSettingsRem(NBTTagCompound nbt, int ps) {
/* 5226 */     String n = nbt.func_74779_i("jrmcSettings").trim();
/* 5227 */     for (int i = 0; i < n.length() / 2; i++) {
/* 5228 */       String c = sa(n, i * 2);
/* 5229 */       if (c.equals(PlyrSttngs[ps])) {
/* 5230 */         String x = sa(n, i * 2 + 1);
/* 5231 */         nbt.func_74778_a("jrmcSettings", n.replaceAll(c + x, ""));
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void PlyrSettingsSet(EntityPlayer p, int ps, int pi) {
/* 5238 */     if (pi == -1) { PlyrSettingsRem(p, ps); return; }
/* 5239 */      String n = getString(p, "jrmcSettings").trim();
/* 5240 */     for (int i = 0; i < n.length() / 2; i++) {
/* 5241 */       String c = sa(n, i * 2);
/* 5242 */       if (c.equals(PlyrSttngs[ps])) {
/* 5243 */         String x = sa(n, i * 2 + 1);
/* 5244 */         setString(n.replaceAll(c + x, c + pi), p, "jrmcSettings");
/*      */         return;
/*      */       } 
/*      */     } 
/* 5248 */     setString(n + PlyrSttngs[ps] + pi, p, "jrmcSettings");
/*      */   }
/*      */   
/*      */   public static void PlyrSettingsOn(EntityPlayer p, int ps) {
/* 5252 */     PlyrSettingsSet(p, ps, 0);
/*      */   }
/*      */   
/*      */   public static void PlyrSettingsSet(NBTTagCompound nbt, int ps, int pi) {
/* 5256 */     if (pi == -1) { PlyrSettingsRem(nbt, ps); return; }
/* 5257 */      String n = nbt.func_74779_i("jrmcSettings").trim();
/* 5258 */     for (int i = 0; i < n.length() / 2; i++) {
/* 5259 */       String c = sa(n, i * 2);
/* 5260 */       if (c.equals(PlyrSttngs[ps])) {
/* 5261 */         String x = sa(n, i * 2 + 1);
/* 5262 */         nbt.func_74778_a("jrmcSettings", n.replaceAll(c + x, c + pi));
/*      */         return;
/*      */       } 
/*      */     } 
/* 5266 */     nbt.func_74778_a("jrmcSettings", n + PlyrSttngs[ps] + pi);
/*      */   }
/*      */   
/*      */   public static void PlyrSettingsOn(NBTTagCompound nbt, int ps) {
/* 5270 */     PlyrSettingsSet(nbt, ps, 0);
/*      */   }
/*      */   
/*      */   public static boolean PlyrSettingsI(int ps, int i) {
/* 5274 */     return (PlyrSettings(ps) == i);
/*      */   }
/*      */   
/*      */   public static boolean PlyrSettingsB(int ps) {
/* 5278 */     return (PlyrSettings(ps) >= 0);
/*      */   }
/*      */   
/*      */   public static int PlyrSettings(int ps) {
/* 5282 */     String n = PlyrSettings;
/* 5283 */     for (int i = 0; i < n.length() / 2; i++) {
/* 5284 */       String c = sa(n, i * 2);
/* 5285 */       if (c.equals(PlyrSttngs[ps])) {
/* 5286 */         return saI(n, i * 2 + 1);
/*      */       }
/*      */     } 
/* 5289 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int[] PlyrAttrbts(EntityPlayer p, EntityPlayer p2) {
/* 5298 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 5299 */     if (side == Side.SERVER) {
/* 5300 */       NBTTagCompound nbt = nbt(p);
/* 5301 */       NBTTagCompound nbt2 = nbt(p2);
/* 5302 */       int[] PlyrAttrbts = PlyrAttrbts(p, false);
/* 5303 */       int[] PlyrAttrbts2 = PlyrAttrbts(p2, false);
/* 5304 */       int[] PlyrAttrbtsF = new int[JRMCoreH.PlyrAttrbts.length]; byte i;
/* 5305 */       for (i = 0; i < AttrbtNbt.length; i = (byte)(i + 1)) {
/* 5306 */         if (i != 4) {
/*      */           
/* 5308 */           float attributeMulti = JRMCoreConfig.fusionAttributeMultis[i];
/* 5309 */           PlyrAttrbtsF[i] = (PlyrAttrbts[i] < PlyrAttrbts2[i]) ? (int)(PlyrAttrbts[i] * attributeMulti) : (int)(PlyrAttrbts2[i] * attributeMulti);
/*      */         }
/*      */         else {
/*      */           
/* 5313 */           PlyrAttrbtsF[i] = (PlyrAttrbts[i] < PlyrAttrbts2[i]) ? PlyrAttrbts[i] : PlyrAttrbts2[i];
/*      */         } 
/*      */       } 
/* 5316 */       return PlyrAttrbtsF;
/*      */     } 
/* 5318 */     return JRMCoreH.PlyrAttrbts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int costEnAt(String[] tech) {
/* 5325 */     return costEnAt(tech, -1);
/*      */   }
/*      */   public static short costEnAt(String[] tech, int men) {
/* 5328 */     short cost = 0;
/* 5329 */     if (tech != null && men < 0) {
/* 5330 */       byte type = Byte.parseByte(tech[3]);
/* 5331 */       byte speed = Byte.parseByte(tech[4]);
/* 5332 */       short dam = Short.parseShort(tech[5]);
/* 5333 */       byte effect = Byte.parseByte(tech[6]);
/* 5334 */       short casttime = (short)(techBase[8] - Short.parseShort(tech[8]));
/* 5335 */       short cooldown = (short)(techBase[9] - Short.parseShort(tech[9]));
/* 5336 */       byte color = Byte.parseByte(tech[10]);
/* 5337 */       byte density = Byte.parseByte(tech[11]);
/* 5338 */       int costInt = (int)((1.0F + dam * 0.5F) * (effect + 1.0F) * (type + 1.0F) * speed * 0.1F * density + casttime + cooldown);
/* 5339 */       cost = (short)((costInt > getMaxTP()) ? getMaxTP() : costInt);
/*      */     }
/* 5341 */     else if (tech != null && tech.length > 12) {
/*      */       
/* 5343 */       byte tcost = Byte.parseByte(tech[7]);
/* 5344 */       byte density = Byte.parseByte(tech[11]);
/* 5345 */       int costInt = 1 + (int)(tcost * 0.01F * men * density);
/* 5346 */       cost = (short)((costInt > getMaxTP()) ? getMaxTP() : costInt);
/*      */     } 
/* 5348 */     return (cost <= 1) ? 1 : cost;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void swapCD(byte from, byte to) {
/* 5353 */     float CDFrom = techCD(from);
/* 5354 */     float CDTo = techCD(to);
/* 5355 */     setCDAt(from, CDTo);
/* 5356 */     setCDAt(to, CDFrom);
/* 5357 */     updateOldCooldownValue(from);
/* 5358 */     updateOldCooldownValue(to);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setCDAt(byte id, float cd) {
/* 5363 */     techniqueCooldowns[id] = cd;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean cDEnAt(byte id, float cd) {
/* 5369 */     if (DBC() && DBCClientTickHandler.isPlayerInCreativeMode()) return true;
/*      */     
/* 5371 */     cd *= 10.0F;
/* 5372 */     boolean cd1 = true;
/*      */     
/* 5374 */     if (techniqueCooldowns[id] == 0.0F) {
/*      */       
/* 5376 */       techniqueCooldowns[id] = cd;
/* 5377 */       updateOldCooldownValue(id);
/* 5378 */       cd1 = true;
/*      */     } 
/* 5380 */     return cd1;
/*      */   }
/*      */ 
/*      */   
/*      */   public static float curCDEnAt(byte id) {
/* 5385 */     return techCD(id);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] tech(int id) {
/* 5390 */     String[] tech = null;
/* 5391 */     if (id == 0 && tech1 != null) tech = tech1; 
/* 5392 */     if (id == 1 && tech2 != null) tech = tech2; 
/* 5393 */     if (id == 2 && tech3 != null) tech = tech3; 
/* 5394 */     if (id == 3 && tech4 != null) tech = tech4; 
/* 5395 */     if (id >= 4 && id < 8 && techPM != null && techsPM(id - 4) >= 0) tech = ((Pwrtyp == 1) ? pmdbc : ((Pwrtyp == 2) ? pmj : pmj))[techsPM(id - 4)]; 
/* 5396 */     return tech_conv(tech);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float techCD(byte id) {
/* 5401 */     return techniqueCooldowns[id];
/*      */   }
/*      */ 
/*      */   
/*      */   public static void resetCD(byte id) {
/* 5406 */     if (techniqueCooldowns[id] > 0.0F)
/*      */     {
/* 5408 */       techniqueCooldowns[id] = 0.0F;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static void updateAllOldCooldownValues() {
/* 5414 */     for (int i = 0; i < techniqueCooldowns.length; i++)
/*      */     {
/* 5416 */       updateOldCooldownValue(i);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static void updateOldCooldownValue(int id) {
/* 5422 */     if (id == 0) { curTech1CD = techniqueCooldowns[id]; }
/* 5423 */     else if (id == 1) { curTech2CD = techniqueCooldowns[id]; }
/* 5424 */     else if (id == 2) { curTech3CD = techniqueCooldowns[id]; }
/* 5425 */     else if (id == 3) { curTech4CD = techniqueCooldowns[id]; }
/* 5426 */     else if (id == 4) { curTech5CD = techniqueCooldowns[id]; }
/* 5427 */     else if (id == 5) { curTech6CD = techniqueCooldowns[id]; }
/* 5428 */     else if (id == 6) { curTech7CD = techniqueCooldowns[id]; }
/* 5429 */     else if (id == 7) { curTech8CD = techniqueCooldowns[id]; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMaxTP() {
/* 5440 */     return 2000000000;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5448 */   public static final String[][] statNames = new String[][] { { "Melee", "Defense", "Body" }, { "Melee", "Defense", "Body", "Stamina", "EnergyPower", "EnergyPool", "MaxSkills", "Speed", "RegenRateBody", "RegenRateStamina", "RegenRateEnergy", "FlySpeed" }, { "Melee", "Defense", "Body", "Stamina", "EnergyPower", "EnergyPool", "MaxSkills", "Speed", "RegenRateBody", "RegenRateStamina", "RegenRateEnergy" }, { "Melee", "Defense", "Body", "Stamina", "Speed", "RegenRateBody", "RegenRateStamina" } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5455 */   public static final String[][] attrInit = new String[][] { { "STR ", "DEX ", "CONS" }, { "STR ", "DEX ", "CONS", "WILL", "MIND", "SPI" }, { "STR ", "DEX ", "CONS", "WILL", "MIND", "SPI" }, { "STR", "AGI", "VIT" } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5462 */   public static final String[][] attrNms = new String[][] { { "Strength", "Dexterity", "Constitution" }, { "Strength", "Dexterity", "Constitution", "WillPower", "Mind", "Spirit" }, { "Strength", "Dexterity", "Constitution", "WillPower", "Mind", "Spirit" }, { "Strength", "Agility", "Vitality" } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String attrNms(int g, int a) {
/* 5470 */     return trl("jrmc", attrNms[g][a]);
/* 5471 */   } public static final String[][] attrDsc = new String[][] { { "StrMC", "DexMC", "ConMC" }, { "StrDB", "DexDB", "ConDB", "WilDB", "MndDB", "SpiDB" }, { "StrNC", "DexNC", "ConNC", "WilNC", "MndNC", "SpiNC" }, { "StrSA", "AgiSA", "VitSA" } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String attrDsc(int g, int a) {
/* 5478 */     return trl("jrmc", attrDsc[g][a]);
/*      */   }
/*      */ 
/*      */   
/* 5482 */   public static final String[][] attrStat = new String[][] { { "mleMC", "DefMC", "heltMC" }, { "mleDB", "DefDB", "BdDB", "StDB", "EnPwDB", "EnPlDB", "MxSkDB", "SpDB", "RBDB", "RSDB", "REDB", "FSDB" }, { "mleNC", "DefNC", "BdNC", "StNC", "EnPwNC", "EnPlNC", "MxSkNC", "SpNC", "RBNC", "RSNC", "RENC" }, { "mleSA", "DefSA", "BdSA", "StSA" } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String attrStat(int g, int a) {
/* 5489 */     return trl("jrmc", attrStat[g][a]);
/*      */   }
/*      */ 
/*      */   
/* 5493 */   public static final float[][] statInc = new float[][] { { 0.3F, 1.0F, 2.0F }, { 2.5F, 4.0F, 20.0F, 3.5F, 5.2F, 40.0F, 0.15F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F }, { 2.5F, 4.0F, 20.0F, 3.5F, 5.2F, 40.0F, 0.15F, 1.0F, 1.0F, 1.0F, 1.0F }, { 1.0F, 1.0F, 250.0F } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5501 */   public static final int[][][] attrStart = new int[][][] { { { 10 }, { 10 }, { 10 } }, { { 10, 15, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 5, 5, 15, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 7, 15, 8, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 15, 15, 10, 10, 7, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 5, 10, 15, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 5, 5, 18, 15, 10, 10, 10, 10, 10, 10, 10, 10, 10 } }, { { 10 }, { 10 }, { 10 }, { 10 }, { 10 }, { 10 } }, { { 1 }, { 1 }, { 1 } } };
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
/*      */   public static int attrStart(int powerType, int attribute, int race) {
/* 5533 */     return attributeStart(powerType, attribute, race, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int attributeStart(int powerType, int attribute, int race, int classID) {
/* 5539 */     if (powerType == 1) {
/*      */       
/* 5541 */       int[][][] arrayOfInt = JGConfigRaces.CONFIG_RACES_ATTRIBUTE_START;
/* 5542 */       attribute = ((arrayOfInt[race][classID]).length > attribute) ? attribute : ((arrayOfInt[race][classID]).length - 1);
/* 5543 */       race = (arrayOfInt.length > race) ? race : (arrayOfInt.length - 1);
/* 5544 */       return arrayOfInt[race][classID][attribute];
/*      */     } 
/*      */ 
/*      */     
/* 5548 */     int[][][] attributes = attrStart;
/* 5549 */     attribute = ((attributes[powerType]).length > attribute) ? attribute : ((attributes[powerType]).length - 1);
/* 5550 */     race = ((attributes[powerType][attribute]).length > race) ? race : ((attributes[powerType][attribute]).length - 1);
/* 5551 */     return attributes[powerType][attribute][race];
/*      */   }
/*      */ 
/*      */   
/*      */   public static float[] getStatIncreases(int powerType, int race, int classID) {
/* 5556 */     if (powerType == 1)
/*      */     {
/* 5558 */       return JGConfigRaces.CONFIG_RACES_STATS_MULTI[race][classID];
/*      */     }
/*      */ 
/*      */     
/* 5562 */     return statInc[powerType];
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getStatBonus(int powerType, int race, int classID, int stat, boolean classBonusOnly) {
/* 5567 */     if (powerType == 1) {
/*      */       
/* 5569 */       if (classBonusOnly) return 0; 
/* 5570 */       return JGConfigRaces.CONFIG_RACES_STAT_BONUS[race][classID][stat];
/*      */     } 
/*      */ 
/*      */     
/* 5574 */     if (classBonusOnly) return statIncBonusRaceDBC[stat][race]; 
/* 5575 */     return statIncBonusClass[powerType][stat][classID];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static double regenRate(int powerType, int maxStat, float race) {
/* 5581 */     if (powerType == 1 || powerType == 2)
/*      */     {
/* 5583 */       return 1.0D + maxStat * 0.01D * race * 0.01D;
/*      */     }
/* 5585 */     return 1.0D + maxStat * 0.02D * race * 0.01D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5593 */   static Splitter splitter = Splitter.on(',').omitEmptyStrings().trimResults();
/* 5594 */   static Joiner joiner = Joiner.on(',').skipNulls(); public static final int TP_COST_UPGRADE_LOCK = -1;
/*      */   public static final int maxCalculatableAttribute = 6000000;
/*      */   
/*      */   public static String cleanUpCommas(String string) {
/* 5598 */     return joiner.join(splitter.split(string));
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
/*      */   public static int skillSlot_MindUsed() {
/*      */     String[] cSkls, skls;
/* 5611 */     int[][] sklsMR, rSklsMR = (int[][])null;
/*      */ 
/*      */ 
/*      */     
/* 5615 */     int[][] cSklsMR = (int[][])null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5623 */     if (isPowerTypeChakra()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 5629 */       cSkls = ncCSkls;
/*      */ 
/*      */       
/* 5632 */       cSklsMR = NCRacialSkillMindCost;
/* 5633 */       skls = NCSkillIDs;
/*      */ 
/*      */ 
/*      */       
/* 5637 */       sklsMR = NCSkillMindCost;
/* 5638 */       String mod = "nc";
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 5645 */       rSklsMR = DBCRacialSkillMindCost;
/* 5646 */       cSkls = vlblCSkls;
/*      */ 
/*      */ 
/*      */       
/* 5650 */       skls = DBCSkillsIDs;
/*      */ 
/*      */ 
/*      */       
/* 5654 */       sklsMR = DBCSkillMindCost;
/* 5655 */       String mod = "dbc";
/*      */     } 
/*      */     
/* 5658 */     return skillSlot_SpentMindRequirement(PlyrSkills, skls, sklsMR) + 
/* 5659 */       skillSlot_SpentMindRequirement_X(PlyrSkillX, Race, rSklsMR) + 
/* 5660 */       skillSlot_SpentMindRequirement(PlyrSkillY, cSkls, cSklsMR);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int skillSlot_AvailableMindLeft() {
/* 5666 */     return PlyrAttrbts[4] - skillSlot_MindUsed();
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean skillSlot_EnoughMindLeft() {
/* 5671 */     return canAffordSkill(PlyrAttrbts[4], skillSlot_MindUsed());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int skillSlot_SpentMindRequirement(String playerSkills, String[] premadeSkills, int[][] mindRequirements) {
/* 5679 */     if (playerSkills == null || mindRequirements == null || premadeSkills == null || playerSkills == "" || playerSkills.equals("") || playerSkills.equals("pty")) return 0; 
/* 5680 */     return skillSlot_SpentMindRequirement(new String[] { playerSkills }, premadeSkills, mindRequirements, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int skillSlot_SpentMindRequirement(String[] playerSkills, String[] premadeSkills, int[][] mindRequirements) {
/* 5686 */     return skillSlot_SpentMindRequirement(playerSkills, premadeSkills, mindRequirements, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int skillSlot_SpentMindRequirement(String[] playerSkills, String[] premadeSkills, int[][] mindRequirements, boolean granted) {
/* 5691 */     int z = granted ? 1 : 0;
/* 5692 */     int haveSkillLvls = 0; byte i;
/* 5693 */     for (i = 0; i < playerSkills.length; i = (byte)(i + 1)) {
/*      */       
/* 5695 */       if (playerSkills[i].length() > 2) {
/*      */         
/* 5697 */         int l = Integer.parseInt(playerSkills[i].substring(2)) + z;
/* 5698 */         for (int j = 0; j < l; j++)
/*      */         {
/* 5700 */           haveSkillLvls += skillMindRequirement(playerSkills[i].substring(0, 2) + j, premadeSkills, mindRequirements, granted);
/*      */         }
/*      */       } 
/*      */     } 
/* 5704 */     return haveSkillLvls;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int skillSlot_SpentMindRequirement_X(String playerRacialSkill, int skills, int[][] mindRequirements) {
/* 5710 */     if (playerRacialSkill == null || mindRequirements == null || playerRacialSkill == "" || playerRacialSkill.equals("") || playerRacialSkill.equals("pty")) return 0; 
/* 5711 */     int haveSkillLvls = 0;
/* 5712 */     if (playerRacialSkill.length() > 2) {
/*      */       
/* 5714 */       int racialSkillLevel = Integer.parseInt(playerRacialSkill.substring(2));
/* 5715 */       for (int j = 0; j <= racialSkillLevel; j++)
/*      */       {
/* 5717 */         haveSkillLvls += skillMindRequirement_X(playerRacialSkill.substring(0, 2) + j, skills, mindRequirements, true);
/*      */       }
/*      */     } 
/* 5720 */     return haveSkillLvls;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int skillMindRequirement(String skill, String[] skills, int[][] mindRequirements) {
/* 5729 */     return skillMindRequirement(skill, skills, mindRequirements, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int skillMindRequirement(String skill, String[] skills, int[][] mindRequirements, boolean granted) {
/*      */     byte i;
/* 5735 */     for (i = 0; i < skills.length; i = (byte)(i + 1)) {
/*      */       
/* 5737 */       if (skill.contains(skills[i])) {
/*      */         
/* 5739 */         int z = !granted ? 1 : 0;
/* 5740 */         int lvl = (skill.length() > 2) ? (Integer.parseInt(skill.substring(2)) + z) : 0;
/* 5741 */         int a = SklID(skill, skills);
/* 5742 */         if (a >= 0) {
/*      */           float f;
/* 5744 */           int[] mindRequirement = mindRequirements[a];
/*      */           
/* 5746 */           if (mindRequirement.length - 1 > -1) {
/*      */             
/* 5748 */             f = ((mindRequirement.length > lvl) ? mindRequirement[lvl] : mindRequirement[mindRequirement.length - 1]);
/*      */           } else {
/* 5750 */             f = 1.0F;
/* 5751 */           }  float x = f * JGConfigSkills.GlobalSkillMindMultiplier * ((lvl == 0) ? JGConfigSkills.GlobalSkillMindMultiplierFirst : 1.0F) * (JGConfigSkills.GlobalSkillMindMultiplierWithLevel ? (lvl + 1) : true);
/*      */           
/* 5753 */           return (int)((x < z) ? z : x);
/*      */         }  break;
/*      */       } 
/*      */     } 
/* 5757 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int skillMindRequirement_X(String playerRacialSkill, int race, int[][] mindRequirements) {
/* 5763 */     return skillMindRequirement_X(playerRacialSkill, race, mindRequirements, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int skillMindRequirement_X(String playerRacialSkill, int race, int[][] mindRequirements, boolean granted) {
/* 5769 */     if (playerRacialSkill.length() > 1) {
/*      */       
/* 5771 */       int z = !granted ? 1 : 0;
/* 5772 */       int lvl = (playerRacialSkill.length() > 2) ? (Integer.parseInt(playerRacialSkill.substring(2)) + z) : 0;
/*      */       
/* 5774 */       if (race >= 0) {
/*      */         
/* 5776 */         int[] mindRequirement = mindRequirements[race];
/* 5777 */         if (lvl == 0) return 0; 
/* 5778 */         lvl--;
/* 5779 */         float f = ((mindRequirement.length > lvl) ? mindRequirement[lvl] : mindRequirement[mindRequirement.length - 1]);
/* 5780 */         float x = f * JGConfigSkills.GlobalSkillMindMultiplier * ((lvl == 0) ? JGConfigSkills.GlobalSkillMindMultiplierFirst : 1.0F) * (JGConfigSkills.GlobalSkillMindMultiplierWithLevel ? (lvl + 1) : true);
/*      */         
/* 5782 */         return (int)((x < z) ? z : x);
/*      */       } 
/*      */     } 
/* 5785 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int skillTPCost(String skill, String[] skills, int[][] tpCosts) {
/* 5793 */     return skillTPCost(skill, skills, tpCosts, false);
/*      */   }
/*      */   
/*      */   public static int skillTPCost(String skill, String[] skills, int[][] tpCosts, boolean granted) {
/*      */     byte i;
/* 5798 */     for (i = 0; i < skills.length; i = (byte)(i + 1)) {
/*      */       
/* 5800 */       if (skill.contains(skills[i])) {
/*      */         
/* 5802 */         int z = !granted ? 1 : 0;
/* 5803 */         int lvl = (skill.length() > 2) ? (Integer.parseInt(skill.substring(2)) + z) : 0;
/* 5804 */         int a = SklID(skill, skills);
/* 5805 */         if (a >= 0) {
/*      */           float f;
/* 5807 */           int[] tpCost = tpCosts[a];
/*      */           
/* 5809 */           if (tpCost.length - 1 > -1) {
/*      */             
/* 5811 */             f = ((tpCost.length > lvl) ? tpCost[lvl] : tpCost[tpCost.length - 1]);
/*      */           } else {
/* 5813 */             f = 1.0F;
/*      */           } 
/* 5815 */           float x = f * JGConfigSkills.GlobalSkillTPMultiplier * ((lvl == 0) ? JGConfigSkills.GlobalSkillTPMultiplierFirst : 1.0F) * (JGConfigSkills.GlobalSkillTPMultiplierWithLevel ? (lvl + 1) : true);
/*      */           
/* 5817 */           return (int)((x < -1.0F) ? -1.0F : x);
/*      */         }  break;
/*      */       } 
/*      */     } 
/* 5821 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int skillTPCost_X(String playerRacialSkill, int race, int[][] tpCosts) {
/* 5826 */     return skillTPCost_X(playerRacialSkill, race, tpCosts, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int skillTPCost_X(String playerRacialSkill, int race, int[][] tpCosts, boolean granted) {
/* 5831 */     if (playerRacialSkill.length() > 1) {
/*      */       
/* 5833 */       int z = !granted ? 1 : 0;
/* 5834 */       int lvl = (playerRacialSkill.length() > 2) ? (Integer.parseInt(playerRacialSkill.substring(2)) + z) : 0;
/*      */       
/* 5836 */       if (race >= 0) {
/*      */         
/* 5838 */         int[] tpCost = tpCosts[race];
/* 5839 */         if (lvl == 0) return 0; 
/* 5840 */         lvl--;
/* 5841 */         float f = ((tpCost.length > lvl) ? tpCost[lvl] : tpCost[tpCost.length - 1]);
/* 5842 */         float x = f * JGConfigSkills.GlobalSkillTPMultiplier * ((lvl == 0) ? JGConfigSkills.GlobalSkillTPMultiplierFirst : 1.0F) * (JGConfigSkills.GlobalSkillTPMultiplierWithLevel ? (lvl + 1) : true);
/*      */ 
/*      */         
/* 5845 */         return (int)((x < -1.0F) ? -1.0F : x);
/*      */       } 
/*      */     } 
/* 5848 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getSkillTPCost(int skillID, int lvl, boolean dbc) {
/* 5854 */     return dbc ? getDBCSkillTPCost(skillID, lvl) : getNCSkillTPCost(skillID, lvl);
/*      */   }
/*      */   public static int getDBCSkillTPCost(int skillID, int lvl) {
/* 5857 */     return (int)(DBCSkillTPCost[skillID][lvl] * JGConfigSkills.GlobalSkillTPMultiplier * ((lvl == 0) ? JGConfigSkills.GlobalSkillTPMultiplierFirst : 1.0F) * (JGConfigSkills.GlobalSkillTPMultiplierWithLevel ? (lvl + 1) : true));
/*      */   }
/*      */   
/*      */   public static int getNCSkillTPCost(int skillID, int lvl) {
/* 5861 */     return (int)(NCSkillTPCost[skillID][lvl] * JGConfigSkills.GlobalSkillTPMultiplier * ((lvl == 0) ? JGConfigSkills.GlobalSkillTPMultiplierFirst : 1.0F) * (JGConfigSkills.GlobalSkillTPMultiplierWithLevel ? (lvl + 1) : true));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getSkillMindCost(int skillID, int lvl, boolean dbc) {
/* 5868 */     return dbc ? getDBCSkillMindCost(skillID, lvl) : getNCSkillMindCost(skillID, lvl);
/*      */   }
/*      */   public static int getDBCSkillMindCost(int skillID, int lvl) {
/* 5871 */     return (int)(DBCSkillMindCost[skillID][lvl] * JGConfigSkills.GlobalSkillMindMultiplier * ((lvl == 0) ? JGConfigSkills.GlobalSkillMindMultiplierFirst : 1.0F) * (JGConfigSkills.GlobalSkillMindMultiplierWithLevel ? (lvl + 1) : true));
/*      */   }
/*      */   
/*      */   public static int getNCSkillMindCost(int skillID, int lvl) {
/* 5875 */     return (int)(NCSkillMindCost[skillID][lvl] * JGConfigSkills.GlobalSkillMindMultiplier * ((lvl == 0) ? JGConfigSkills.GlobalSkillMindMultiplierFirst : 1.0F) * (JGConfigSkills.GlobalSkillMindMultiplierWithLevel ? (lvl + 1) : true));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean skillSlots(int mindRequirement, int haveSkillLvls) {
/* 5885 */     return canAffordSkill(mindRequirement, haveSkillLvls);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean canAffordSkill(int mindAttribute, int haveSkillLvls) {
/* 5890 */     return (mindAttribute >= haveSkillLvls);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static HashMap<Integer, Long> attrCstH() {
/* 5900 */     HashMap<Integer, Long> attrCstH = new HashMap<Integer, Long>();
/* 5901 */     long res = 1L;
/* 5902 */     for (int i = 0; i <= 6000000; i++) {
/* 5903 */       attrCstH.put(Integer.valueOf(i), Long.valueOf(res += attrCst(i)));
/*      */     }
/* 5905 */     long res2 = 0L;
/* 5906 */     for (int j = 0; j < 60; j++) {
/* 5907 */       res2 += attrCst(j);
/*      */     }
/* 5909 */     attrCstH.put(Integer.valueOf(-1), Long.valueOf(res2));
/* 5910 */     return attrCstH;
/*      */   }
/* 5912 */   public static HashMap<Integer, Long> attrCstH = null;
/*      */   
/*      */   public static int attrCstO(int att) {
/* 5915 */     int am = (int)(att * JRMCoreConfig.atcm);
/* 5916 */     int dec = (JRMCoreConfig.AttributeUpgradeCost_StartMinus - att < 0) ? 0 : (JRMCoreConfig.AttributeUpgradeCost_StartMinus - att);
/* 5917 */     int c = am - dec;
/* 5918 */     return (c < JRMCoreConfig.AttributeUpgradeCost_Min) ? JRMCoreConfig.AttributeUpgradeCost_Min : ((c > getMaxTP()) ? getMaxTP() : c);
/*      */   }
/*      */ 
/*      */   
/*      */   public static long attrCstE(int att) {
/* 5923 */     if (att > 6000000) att = 6000000; 
/* 5924 */     return ((attrCstH != null) ? attrCstH.get(Integer.valueOf(att)) : (attrCstH = attrCstH()).get(Integer.valueOf(att))).longValue();
/*      */   }
/*      */   
/*      */   public static long attrCstEP(int att) {
/* 5928 */     if (att > 6000000) att = 6000000; 
/* 5929 */     return (attrCstH != null) ? (((Long)attrCstH.get(Integer.valueOf(att))).longValue() - ((Long)attrCstH.get(Integer.valueOf(-1))).longValue()) : (((Long)(attrCstH = attrCstH()).get(Integer.valueOf(att))).longValue() - ((Long)attrCstH.get(Integer.valueOf(-1))).longValue());
/*      */   }
/*      */   
/*      */   public static int am(int id) {
/* 5933 */     return attributeMultiplier(id);
/*      */   }
/*      */   public static int attributeMultiplier(int id) {
/* 5936 */     switch (id) {
/*      */       case 0:
/* 5938 */         return 1;
/* 5939 */       case 1: return 10;
/* 5940 */       case 2: return 100;
/* 5941 */       case 3: return 1000;
/*      */     } 
/* 5943 */     return 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int attrCst(int att, int count) {
/* 5948 */     int attributes = att;
/* 5949 */     if (attributes >= getMaxTP() || attributes <= 0) {
/*      */       
/* 5951 */       if (count == 0) return getMaxTP(); 
/* 5952 */       return 0;
/*      */     } 
/*      */     
/* 5955 */     int attributeCost = 0;
/* 5956 */     int attributeMultiplier = attributeMultiplier(count);
/* 5957 */     for (int j = 0; j < attributeMultiplier; j++) {
/*      */       
/* 5959 */       int ac = attrCst(attributes++);
/* 5960 */       attributeCost += ac;
/* 5961 */       if (ac == 0) return 0; 
/*      */     } 
/* 5963 */     if (attributeCost <= 0) return 0; 
/* 5964 */     if (attributeCost > getMaxTP()) return 0; 
/* 5965 */     return attributeCost;
/*      */   }
/*      */   
/*      */   public static int attrCst(int att) {
/* 5969 */     if (checkLimit() * 6 <= att) return 0; 
/* 5970 */     int am = (int)(att * JRMCoreConfig.atcm);
/* 5971 */     int dec = (JRMCoreConfig.AttributeUpgradeCost_StartMinus - att < 0) ? 0 : (JRMCoreConfig.AttributeUpgradeCost_StartMinus - att);
/* 5972 */     int c = am - dec;
/* 5973 */     int a = (c < JRMCoreConfig.AttributeUpgradeCost_Min) ? JRMCoreConfig.AttributeUpgradeCost_Min : ((c > getMaxTP()) ? getMaxTP() : c);
/* 5974 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean acm(int[] attrbts) {
/* 5980 */     int att = attrbts[0] + attrbts[1] + attrbts[2] + attrbts[3] + attrbts[4] + attrbts[5];
/* 5981 */     return (JRMCoreConfig.tmx * 6 <= att);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int attrCst(int[] attrbts, int count) {
/* 5986 */     int att = attributeCostAboveLimit(attrbts);
/* 5987 */     return attrCst(att, count);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int attributeCostAboveLimit(int[] attributes) {
/* 5994 */     float result = 0.0F;
/* 5995 */     for (int i = 0; i < 6; i++) {
/*      */       
/* 5997 */       if (JRMCoreConfig.AttributeUpgradeCost_AttributeMulti[i] > 0.0F) {
/*      */         
/* 5999 */         float attribute = attributes[i] * JRMCoreConfig.AttributeUpgradeCost_AttributeMulti[i];
/* 6000 */         result += attribute;
/* 6001 */         if (result >= getMaxTP() || result <= 0.0F) return getMaxTP(); 
/*      */       } 
/*      */     } 
/* 6004 */     return (int)result;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getPlayerLevel(int[] playerAttributes) {
/* 6010 */     return getPlayerLevel(playerAttributes[0] + playerAttributes[1] + playerAttributes[2] + playerAttributes[3] + playerAttributes[4] + playerAttributes[5]);
/*      */   }
/*      */   public static int attrLvl(int[] PlyrAttrbts) {
/* 6013 */     return getPlayerLevel(PlyrAttrbts);
/*      */   }
/*      */   
/*      */   public static int getPlayerLevel(int all) {
/* 6017 */     int i = all / 5 - 11;
/* 6018 */     return (i < 0) ? 0 : i;
/*      */   }
/*      */   public static int attrLvl(int all) {
/* 6021 */     return getPlayerLevel(all);
/*      */   }
/*      */   
/*      */   public static int attrLvlNext(int[] PlyrAttrbts) {
/* 6025 */     int all = PlyrAttrbts[0] + PlyrAttrbts[1] + PlyrAttrbts[2] + PlyrAttrbts[3] + PlyrAttrbts[4] + PlyrAttrbts[5];
/* 6026 */     return 5 - all - all / 5 * 5;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float spdFrm(int a, int s, float r, boolean t, boolean i, int st, int st2, float aa) {
/* 6037 */     float prc = 0.5F + (t ? 0.5F : 0.0F) + (0.075F * s + (a / checkLimit()) + st * 0.02F + st2 * 0.1F + 0.5F) * r * 0.01F;
/* 6038 */     return prc * aa;
/*      */   }
/*      */ 
/*      */   
/* 6042 */   public static final int[][] statIncBonusRaceDBC = new int[][] { { 0, 30, 15, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 30, 0, 15, 0, 10, 30, 0, 0, 0, 0, 0, 0, 0, 0 }, { 10, 20, 15, 30, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0 }, { 10, 0, 5, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 10, 0, 5, 0, 30, 10, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
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
/* 6071 */   public static final int[][][] statIncBonusClass = new int[][][] { { { 0, 10, -10 }, { 0, -10, 10 }, { 0, 0, 0 } }, { { 0, -10, 10 }, { 0, 10, -10 }, { 0, -10, 10 }, { 0, -10, 10 }, { 0, 10, -10 }, { 0, 10, -10 }, { 0, 0, 0 }, { 0, 10, -10 }, { 0, -10, 10 }, { 0, -10, 10 }, { 0, 10, -10 }, { 0, 10, -10 } }, { { 0, 5, 10 }, { 0, 5, 0 }, { 0, 5, -10 }, { 0, 5, 10 }, { 0, -5, 5 }, { 0, -10, -10 }, { 0, 0, 0 }, { 0, 5, 5 }, { 0, -10, -10 }, { 0, -10, -10 }, { 0, -10, -10 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } } };
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
/*      */   public static String[] cl(int pwr) {
/* 6112 */     String[] cl = PwrtypAllow[pwr].contains("DBC") ? ClassesDBC : (PwrtypAllow[pwr].contains("NC") ? Clans : Classes);
/* 6113 */     return cl;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int statMindC() {
/* 6119 */     double mind = PlyrAttrbts[4];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6124 */     return (int)mind;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getBonusAttributes(String player, int attributeID) {
/* 6129 */     if (plyrs != null) {
/*      */       
/* 6131 */       if (player == null || player.length() == 0) player = mod_JRMCore.proxy.getPlayerClient().func_70005_c_();
/*      */       
/* 6133 */       for (int pl = 0; pl < plyrs.length; pl++) {
/*      */         
/* 6135 */         if (plyrs[pl] != null && plyrs[pl].equals(player)) {
/*      */           
/* 6137 */           if (dat31 != null)
/*      */           {
/* 6139 */             if (dat31.length > pl)
/*      */             {
/* 6141 */               if ((dat31[pl].split("\\=")).length == 6)
/*      */               {
/* 6143 */                 return dat31[pl].split("\\=")[attributeID];
/*      */               }
/*      */             }
/*      */           }
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/* 6152 */     return "";
/*      */   }
/*      */   
/*      */   public static String getBonusAttributes(int attributeID) {
/* 6156 */     return getBonusAttributes(null, attributeID);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stat(Entity player, int attributeID, int powerType, int stat, int attribute, int race, int classID, float skillBonus) {
/* 6162 */     float[] attributes = getStatIncreases(powerType, race, classID);
/* 6163 */     stat = (attributes.length > stat) ? stat : (attributes.length - 1);
/* 6164 */     double bs = (attributes[stat] * attribute);
/*      */     
/* 6166 */     int value = (int)round(bs + 
/* 6167 */         getStatBonus(powerType, race, classID, stat, false) * 0.01D * bs + 
/* 6168 */         getStatBonus(powerType, race, classID, stat, true) * 0.01D * bs + bs * skillBonus, 0, 0);
/*      */ 
/*      */     
/* 6171 */     if (JRMCoreConfig.JRMCABonusOn && attributeID > -1 && attributeID <= 5 && player instanceof EntityPlayer) {
/*      */       
/* 6173 */       String nbtValue = "NONE";
/* 6174 */       if (!player.field_70170_p.field_72995_K) {
/*      */         
/* 6176 */         NBTTagCompound nbt = nbt(player, "pres");
/* 6177 */         nbtValue = nbt.func_74779_i("jrmcAttrBonus" + ComJrmcaBonus.ATTRIBUTES_SHORT[attributeID]);
/*      */       }
/*      */       else {
/*      */         
/* 6181 */         nbtValue = getBonusAttributes(player.func_70005_c_(), attributeID);
/*      */       } 
/*      */       
/* 6184 */       if (!nbtValue.equals("NONE") && !nbtValue.equals("n")) {
/*      */         
/* 6186 */         double bonusValueResult = value;
/* 6187 */         String[] bonus = nbtValue.split("\\|");
/* 6188 */         String[][] bonusValues = new String[bonus.length][2];
/* 6189 */         if (bonus.length > 0 && bonus[0].length() > 0)
/*      */         {
/* 6191 */           for (int i = 0; i < bonus.length; i++) {
/*      */             
/* 6193 */             if (bonus[i].length() > 1) {
/*      */               
/* 6195 */               String[] bonusValue = bonus[i].split("\\;");
/* 6196 */               bonusValues[i][1] = bonusValue[1];
/*      */ 
/*      */ 
/*      */               
/*      */               try {
/* 6201 */                 double value2 = Double.parseDouble(bonusValues[i][1].substring(1));
/* 6202 */                 bonusValueResult = JGMathHelper.StringMethod(bonusValues[i][1].substring(0, 1), bonusValueResult, value2);
/*      */               } catch (Exception e) {
/* 6204 */                 double d = 1.0D;
/*      */               } 
/*      */             } 
/*      */           }  } 
/* 6208 */         value = (int)bonusValueResult;
/*      */       } 
/*      */     } 
/*      */     
/* 6212 */     if (powerType == 1 && attributeID > -1 && attributeID <= 5) {
/*      */       
/* 6214 */       double multiplier = JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[race][classID][attributeID];
/* 6215 */       value = (int)(value * multiplier);
/*      */     } 
/*      */     
/* 6218 */     return value;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int stat(int attributeID, int g, int s, int a, int r, int c, float b) {
/* 6223 */     return stat(null, attributeID, g, s, a, r, c, b);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int stat(int g, int s, int a, int r, int c, float b) {
/* 6228 */     return stat(-1, g, s, a, r, c, b);
/*      */   }
/*      */   
/*      */   public static int stat(int attributeID, EntityPlayer en, int s, int a, float b) {
/* 6232 */     int g = getByte(en, "jrmcPwrtyp");
/* 6233 */     int r = getByte(en, "jrmcRace");
/* 6234 */     int c = getByte(en, "jrmcClass");
/*      */     
/* 6236 */     return stat(attributeID, g, s, a, r, c, b);
/*      */   }
/*      */   
/*      */   public static int stat(EntityPlayer en, int s, int a, float b) {
/* 6240 */     int g = getByte(en, "jrmcPwrtyp");
/* 6241 */     int r = getByte(en, "jrmcRace");
/* 6242 */     int c = getByte(en, "jrmcClass");
/*      */     
/* 6244 */     return stat(g, s, a, r, c, b);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static float statInc(int powerType, int stat, int attribute, int race, int classID, float skillBonus) {
/* 6250 */     float[] attributes = getStatIncreases(powerType, race, classID);
/* 6251 */     stat = (attributes.length > stat) ? stat : (attributes.length - 1);
/* 6252 */     float bs = attributes[stat] * attribute;
/* 6253 */     return round(bs + 
/* 6254 */         getStatBonus(powerType, race, classID, stat, false) * 0.01F * bs + 
/* 6255 */         getStatBonus(powerType, race, classID, stat, true) * 0.01F * bs + bs * skillBonus, 1, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String algnCur(byte align) {
/* 6262 */     String c = "";
/* 6263 */     if (align > 66) c = clbe; 
/* 6264 */     if (align <= 66 && align >= 33) c = cldp; 
/* 6265 */     if (align < 33) c = cldr; 
/* 6266 */     return trl(c + AlgnmntNms[Algnmnt(align)]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void sao_addlevel(int addlvl, EntityPlayer p) {
/* 6277 */     int curexp = getInt(p, "saocExp");
/* 6278 */     int curlvl = getInt(p, "saocLvl"); curlvl = (curlvl < 1) ? 1 : curlvl;
/* 6279 */     int curap = getInt(p, "saocAp");
/* 6280 */     int lvltoreach = curlvl + addlvl;
/* 6281 */     boolean b = true;
/* 6282 */     while (b) {
/* 6283 */       if (lvltoreach > curlvl + addlvl) {
/* 6284 */         curlvl++;
/* 6285 */         curap += 3;
/* 6286 */         curexp = 0; continue;
/*      */       } 
/* 6288 */       b = false;
/*      */     } 
/*      */     
/* 6291 */     setInt(curexp, p, "saocExp");
/* 6292 */     setInt(curlvl, p, "saocLvl");
/* 6293 */     setInt(curap, p, "saocAp");
/*      */   }
/*      */   public static void sao_expgain(int expgained, EntityPlayer p) {
/* 6296 */     int curexp = getInt(p, "saocExp");
/* 6297 */     int curlvl = getInt(p, "saocLvl"); curlvl = (curlvl < 1) ? 1 : curlvl;
/* 6298 */     int curap = getInt(p, "saocAp");
/* 6299 */     boolean b = true;
/* 6300 */     while (b && curlvl < 255) {
/* 6301 */       int expneed = SAOexpNeeded(curlvl, curexp);
/* 6302 */       if (expgained >= expneed) {
/* 6303 */         expgained -= expneed;
/* 6304 */         curlvl++;
/* 6305 */         curap += 3;
/* 6306 */         curexp = 0;
/* 6307 */         p.func_145747_a((new ChatComponentText("Congratulations!! LV UP! " + (curlvl - 1) + " > " + curlvl)).func_150255_a(JRMCoreEH.color)); continue;
/*      */       } 
/* 6309 */       curexp += expgained;
/* 6310 */       b = false;
/*      */     } 
/*      */     
/* 6313 */     if (curlvl >= 255) {
/* 6314 */       p.func_145747_a((new ChatComponentText("Congratulations!! You Reached Max Level!")).func_150255_a(JRMCoreEH.color));
/*      */     }
/* 6316 */     setInt(curexp, p, "saocExp");
/* 6317 */     setInt(curlvl, p, "saocLvl");
/* 6318 */     setInt(curap, p, "saocAp");
/*      */   }
/*      */   public static void sao_colgain(int colgained, EntityPlayer p) {
/* 6321 */     int curcol = getInt(p, "saocCol");
/* 6322 */     setInt(curcol + colgained, p, "saocCol");
/*      */   }
/*      */   
/* 6325 */   public static String[] sao_skillSlot = null;
/* 6326 */   public static String[] sao_skills = null;
/* 6327 */   public static int sao_level = 1;
/* 6328 */   public static int sao_exp = 0;
/* 6329 */   public static int sao_ap = 0;
/* 6330 */   public static int sao_sp = 0;
/* 6331 */   public static int sao_col = 0;
/*      */   
/*      */   public static final String SAO_EXP = "saocExp";
/*      */   
/*      */   public static final String SAO_LVL = "saocLvl";
/*      */   
/*      */   public static final String SAO_AP = "saocAp";
/*      */   
/*      */   public static final String SAO_SP = "saocSp";
/*      */   
/*      */   public static final String SAO_SS = "saocSklslt";
/*      */   
/*      */   public static final String SAO_SM = "saocSklmp";
/*      */   public static final String SAO_COL = "saocCol";
/*      */   public static final int SAO_MAXCHAR_LVL = 250;
/*      */   public static final float SAO_MAXSKILL_LVL = 1000.0F;
/*      */   
/*      */   public static int SAOCExpForLvl(int lvl) {
/* 6349 */     return (int)(Math.pow(lvl, 2.0D) * 20.0D);
/*      */   }
/*      */   public static int SAOmaxExpGain(int lvl) {
/* 6352 */     return 18 * lvl;
/*      */   }
/*      */   public static int SAOmaxColGain(int lvl) {
/* 6355 */     return 15 * lvl;
/*      */   }
/*      */   public static int SAOexpNeeded(int lvl, int exp) {
/* 6358 */     return SAOCExpForLvl(lvl) - exp;
/*      */   }
/*      */   
/*      */   public static int SAOCSklSlt(int lvl) {
/* 6362 */     return 2 + ((lvl > 5) ? 1 : 0) + ((lvl > 19) ? (lvl / 10 - 1) : 0);
/*      */   }
/*      */   
/* 6365 */   public static Map saoSkls = new HashMap<Object, Object>();
/*      */ 
/*      */   
/* 6368 */   public static final String[] SAO_SkillMap_Cats = new String[] { "weapons", "armors" };
/*      */ 
/*      */ 
/*      */   
/* 6372 */   public static final String[] SAO_SkillMap_Weapons = new String[] { "1sword", "1curved", "1dagger", "1rapier", "1axe", "1mace", "2sword", "2spear", "2axe", "2hammer", "2katana" };
/* 6373 */   public static final String[] SAO_SkillMap_WeaponTypes = new String[] { "slash", "slash", "pierce", "pierce", "slash", "crash", "slash", "pierce", "slash", "crash", "slash" };
/* 6374 */   public static final String[] SAO_Weapon_Cat_Sword = new String[] { "sword", "straight", "shortsword", "longsword" };
/* 6375 */   public static final String[] SAO_Weapon_Cat_Curved = new String[] { "curved", "scimitar" };
/* 6376 */   public static final String[] SAO_Weapon_Cat_Dagger = new String[] { "dagger", "knife" };
/* 6377 */   public static final String[] SAO_Weapon_Cat_Rapier = new String[] { "rapier" };
/* 6378 */   public static final String[] SAO_Weapon_Cat_Axe = new String[] { "axe" };
/* 6379 */   public static final String[] SAO_Weapon_Cat_Spear = new String[] { "spear" };
/* 6380 */   public static final String[] SAO_Weapon_Cat_BattleAxe = new String[] { "greataxe", "battleaxe" };
/* 6381 */   public static final String[] SAO_Weapon_Cat_WarHammer = new String[] { "mace", "blunt", "club" };
/* 6382 */   public static final String[] SAO_Weapon_Cat_Sword2 = new String[] { "sword", "greatsword", "twohandedsword", "zwei", "2sword", "twosword" };
/* 6383 */   public static final String[] SAO_Weapon_Cat_Katana = new String[] { "katana" };
/*      */ 
/*      */   
/* 6386 */   public static final String[] SAO_SkillMap_Armors = new String[] { "leather", "lightmetal", "heavymetal", "lightshield", "heavyshield", "parry" };
/*      */ 
/*      */ 
/*      */   
/*      */   public static int SAOSklMastery(String sklName, String[] sao_skillSlot) {
/* 6391 */     int m = 0;
/* 6392 */     for (int i = 0; i < sao_skillSlot.length; i++) {
/* 6393 */       if (sao_skillSlot[i].contains(sklName)) {
/* 6394 */         String[] skl = sao_skillSlot[i].split(":");
/* 6395 */         m = Integer.parseInt(skl[2]);
/*      */       } 
/*      */     } 
/* 6398 */     return m;
/*      */   }
/*      */   
/*      */   public static int SAOSklLvl(String sklName, String[] sao_skillSlot) {
/* 6402 */     int m = 0;
/* 6403 */     for (int i = 0; i < sao_skillSlot.length; i++) {
/* 6404 */       if (sao_skillSlot[i].contains(sklName)) {
/* 6405 */         String[] skl = sao_skillSlot[i].split(":");
/* 6406 */         m = Integer.parseInt(skl[1]);
/*      */       } 
/*      */     } 
/* 6409 */     return m;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6416 */   public static HashMap<String, String> damInd = new HashMap<String, String>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6423 */   public static final String[] TrnngOptns = new String[] { "shadowdummy", "concentration", "BPswap", "airBoxing" };
/*      */   public static String TrnngOptnsNam(int i) {
/* 6425 */     return trl("jrmc", TrnngOptns[i]);
/*      */   }
/*      */   public static String TrnngOptnsDesc(int i) {
/* 6428 */     return trl("jrmc", TrnngOptns[i] + "Desc");
/*      */   }
/*      */   
/*      */   public static String TeleportSound(int p) {
/* 6432 */     return (p == 1) ? "jinryuudragonbc:DBC2.tp" : ((p == 2) ? "jinryuunarutoc:NC1.bunshin" : "");
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
/*      */   public static boolean HairsT(int s, String t) {
/* 6444 */     return HairsT[s].equals(t);
/*      */   }
/*      */   
/*      */   public static boolean HairsT(int s, int s2) {
/* 6448 */     return HairsT[s].equals(HairsT[s2]);
/*      */   }
/*      */   
/*      */   public static boolean Allow(String allow) {
/* 6452 */     return (allow.contains("All") || (allow
/* 6453 */       .contains("DBC") && DBC()) || (allow
/* 6454 */       .contains("HHC") && HHC()) || (allow
/* 6455 */       .contains("JRFC") && JFC()) || (allow
/* 6456 */       .contains("NC") && NC()) || (allow
/* 6457 */       .contains("JYC") && JYC()) || (allow
/* 6458 */       .contains("JBRA") && JBRA()) || (allow
/* 6459 */       .contains("SAOC") && SAOC()) || (allow
/* 6460 */       .contains("RoNC") && RoNC()));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 6465 */   public static String[] jfcData0 = null;
/*      */   
/* 6467 */   public static String[] jfcaa = null;
/*      */   
/* 6469 */   public static String[] jfcms = null;
/*      */   
/* 6471 */   public static String[] jfcmt = null;
/*      */   
/* 6473 */   public static String[] jfccp = null;
/*      */   
/* 6475 */   public static String[] jfccs = null;
/*      */ 
/*      */   
/*      */   public static String proc;
/*      */ 
/*      */   
/*      */   public static String[] preg;
/*      */   
/* 6483 */   public static HashMap<String, Boolean> modsC = null;
/* 6484 */   public static HashMap<String, Boolean> modsS = null;
/*      */ 
/*      */ 
/*      */   
/*      */   public static void mld() {
/* 6489 */     if (modsS == null) {
/*      */       
/* 6491 */       modsS = new HashMap<String, Boolean>();
/* 6492 */       modsS.put(tjdbc, Boolean.valueOf(DBC()));
/* 6493 */       modsS.put(tjnc, Boolean.valueOf(NC()));
/* 6494 */       modsS.put(tjfc, Boolean.valueOf(JFC()));
/* 6495 */       modsS.put(tjyc, Boolean.valueOf(JYC()));
/* 6496 */       modsS.put(tjsaoc, Boolean.valueOf(SAOC()));
/* 6497 */       modsS.put(tjbc, Boolean.valueOf(BC()));
/* 6498 */       modsC = modsS;
/*      */     } 
/*      */   }
/*      */   
/*      */   public static boolean iml(String tj) {
/* 6503 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 6504 */     if (side == Side.CLIENT) {
/* 6505 */       if (modsC != null) return ((Boolean)modsC.get(tj)).booleanValue(); 
/* 6506 */       return Loader.isModLoaded(tj);
/*      */     } 
/*      */     
/* 6509 */     return Loader.isModLoaded(tj);
/*      */   }
/*      */   
/*      */   public static boolean DBC() {
/* 6513 */     return iml(tjdbc);
/* 6514 */   } public static boolean NC() { return iml(tjnc); }
/* 6515 */   public static boolean JFC() { return iml(tjfc); }
/* 6516 */   public static boolean JYC() { return iml(tjyc); }
/* 6517 */   public static boolean JBRA() { return Loader.isModLoaded("jinryuubetterrenderaddon"); }
/* 6518 */   public static boolean HHC() { return Loader.isModLoaded("jinryuuhalfbreedhumanc"); }
/* 6519 */   public static boolean JHDSE() { return Loader.isModLoaded("jinryuu_hdskins_extended"); }
/* 6520 */   public static boolean RoNC() { return Loader.isModLoaded("aoiandjinryuuronc"); }
/* 6521 */   public static boolean SAOC() { return iml(tjsaoc); } public static boolean BC() {
/* 6522 */     return iml(tjbc);
/*      */   }
/*      */   public static String Vers(String id) {
/* 6525 */     String c = "";
/* 6526 */     for (ModContainer mod : Loader.instance().getModList()) {
/* 6527 */       if (mod.getModId().equals(id)) { c = mod.getVersion(); break; }
/*      */     
/* 6529 */     }  return c;
/*      */   }
/*      */   public static String Nams(String id) {
/* 6532 */     String c = "";
/* 6533 */     if (id.equals("jinryuujrmcore")) c = "JinRyuu's JRMCore"; 
/* 6534 */     if (id.equals("jinryuudragonblockc")) c = DragonBCmodName(); 
/* 6535 */     if (id.equals("jinryuunarutoc")) c = NarutoCmodName(); 
/* 6536 */     if (id.equals("jinryuufamilyc")) c = FamilyCmodName(); 
/* 6537 */     if (id.equals("jinryuujyearsc")) c = JYearsCmodName(); 
/* 6538 */     if (id.equals("jinryuubetterrenderaddon")) c = JBRAmodName(); 
/* 6539 */     if (id.equals("jinryuuhdskinsextended")) c = JHDSkinsmodName(); 
/* 6540 */     if (id.equals("aoiandjinryuuronc")) c = RoNCmodName(); 
/* 6541 */     if (id.equals("jinryuusaoc")) c = SAOCmodName(); 
/* 6542 */     if (id.equals("jinryuubleachc")) c = BCmodName(); 
/* 6543 */     return c;
/*      */   }
/*      */   
/* 6546 */   public static final String DragonBCmodName() { return "Dragon Block C"; }
/* 6547 */   public static final String NarutoCmodName() { return "Naruto C"; }
/* 6548 */   public static final String FamilyCmodName() { return "JinRyuu's Family C"; }
/* 6549 */   public static final String JYearsCmodName() { return "JinRyuu's JYears C"; }
/* 6550 */   public static final String JBRAmodName() { return "JinRyuu's Better Render Addon"; }
/* 6551 */   public static final String JHDSkinsmodName() { return "JinRyuu's HD Skins"; }
/* 6552 */   public static final String RoNCmodName() { return "Rise of Nature C"; }
/* 6553 */   public static final String SAOCmodName() { return "Sword Art Online C"; } public static final String BCmodName() {
/* 6554 */     return "JinRyuu's Bleach C";
/*      */   }
/* 6556 */   public static final String DragonBCmodVer() { return "1.4.85"; }
/* 6557 */   public static final String NarutoCmodVer() { return "0.7.18"; }
/* 6558 */   public static final String FamilyCmodVer() { return "1.2.18"; }
/* 6559 */   public static final String JYearsCmodVer() { return "1.2.5"; }
/* 6560 */   public static final String JBRAmodVer() { return "1.6.52"; }
/* 6561 */   public static final String JHDSkinsmodVer() { return "1.3.1"; } public static final String SAOCmodVer() {
/* 6562 */     return "0.0.6";
/*      */   }
/*      */ 
/*      */   
/*      */   public static String format_leadingZero(int l, Object... args) {
/* 6567 */     return String.format("%0" + l + "d", args);
/*      */   }
/*      */   public static String format_lz2(Object... args) {
/* 6570 */     return String.format("%02d", args);
/*      */   }
/*      */   
/*      */   public static String format_remTim(int t) {
/* 6574 */     int s = t / 1 % 60;
/* 6575 */     int m = t / 60 % 60 + 1;
/* 6576 */     int h = t / 3600 % 24 + 1;
/* 6577 */     int d = t / 86400 + 1;
/* 6578 */     if (t < 60) return s + "s"; 
/* 6579 */     if (t < 3600) return m + "m"; 
/* 6580 */     if (t < 86400) return h + "h"; 
/* 6581 */     if (t < 86400) return d + "d"; 
/* 6582 */     return "";
/*      */   }
/*      */   public static float round(float d, int decimalPlace) {
/* 6585 */     return round(d, decimalPlace, 4);
/*      */   }
/*      */   public static float round(float d, int decimalPlace, int rm) {
/* 6588 */     BigDecimal bd = new BigDecimal(Float.toString(d));
/* 6589 */     bd = bd.setScale(decimalPlace, rm);
/* 6590 */     return bd.floatValue();
/*      */   }
/*      */   public static double round(double d, int decimalPlace) {
/* 6593 */     return round(d, decimalPlace, 4);
/*      */   }
/*      */   public static double round(double d, int decimalPlace, int rm) {
/* 6596 */     BigDecimal bd = new BigDecimal(Double.toString(d));
/* 6597 */     bd = bd.setScale(decimalPlace, rm);
/* 6598 */     return bd.doubleValue();
/*      */   }
/*      */   
/*      */   public static String[] jfcPDat(String i) {
/* 6602 */     String[] s = null;
/* 6603 */     if (plyrs != null && jfcData0 != null) {
/* 6604 */       for (int pl = 0; pl < plyrs.length; pl++) {
/* 6605 */         if (plyrs[pl].equals(i)) {
/* 6606 */           s = jfcData0[pl].toString().split(";");
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 6611 */     return s;
/*      */   }
/*      */   public static int jrmcPDta1(String i, int a) {
/* 6614 */     int g = 0;
/* 6615 */     if (plyrs != null && data1 != null) {
/* 6616 */       for (int pl = 0; pl < plyrs.length; pl++) {
/* 6617 */         if (plyrs[pl].equals(i)) {
/* 6618 */           String[] s = data1[pl].split(";");
/* 6619 */           g = Integer.parseInt(s[a]);
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 6624 */     return g;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String jrmcPDtaDNS(String i) {
/* 6629 */     if (plyrs != null && data1 != null) {
/* 6630 */       for (int pl = 0; pl < plyrs.length; pl++) {
/* 6631 */         if (plyrs[pl].equals(i)) {
/* 6632 */           String s = data1[pl].split(";")[1];
/* 6633 */           return s;
/*      */         } 
/*      */       } 
/*      */     }
/* 6637 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void configToClient(MinecraftServer server) {
/* 6647 */     if (JRMCoreConfig.playerCount != server.func_71233_x()) {
/*      */       
/* 6649 */       PD.sendToAll((IMessage)new JRMCorePTrib());
/* 6650 */       JRMCoreConfig.playerCount = server.func_71233_x();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void configToClient(ByteBuf b) {
/* 6657 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(modsS));
/* 6658 */     b.writeBoolean(JRMCoreComTickH.tna3fu);
/*      */     
/* 6660 */     if (DBC()) {
/*      */       
/* 6662 */       b.writeInt(JRMCoreHDBC.DBCgetConfigcmaxTrnExp());
/* 6663 */       b.writeBoolean(JRMCoreHDBC.DBCgetConfigcplntVegeta());
/* 6664 */       b.writeBoolean(JRMCoreHDBC.DBCgetConfigcflyAnyLvl());
/*      */       
/* 6666 */       b.writeBoolean(JRMCoreHDBC.DBCgetConfigcDeathSystemOff());
/* 6667 */       b.writeBoolean(JRMCoreHDBC.DBCgetConfigcDBSpawnEnabled());
/* 6668 */       ByteBufUtils.writeUTF8String(b, JRMCoreHDBC.DBCgetConfigcDBSpawnTime());
/* 6669 */       b.writeBoolean(JRMCoreHDBC.DBCgetConfigcSagaSystemOn());
/* 6670 */       b.writeBoolean(JRMCoreHDBC.DBCgetConfigcSagaSysSpawnPods());
/* 6671 */       b.writeInt(JRMCoreHDBC.DBCgetConfigcsenzuCool());
/* 6672 */       b.writeFloat(JRMCoreHDBC.DBCgetConfigcReinc());
/* 6673 */       b.writeBoolean(JRMCoreHDBC.DBCgetConfigcGodform());
/* 6674 */       b.writeBoolean(JRMCoreHDBC.FreeRevC());
/* 6675 */       b.writeInt(JRMCoreHDBC.DBCgetConfigcTechExpNeed());
/* 6676 */       b.writeInt(JRMCoreHDBC.DBCgetConfigcTechCostMod());
/*      */     } 
/*      */     
/* 6679 */     if (JYC())
/*      */     {
/* 6681 */       b.writeInt(JRMCoreHJYC.JYCgetConfigcpgut());
/*      */     }
/* 6683 */     if (JFC())
/*      */     {
/* 6685 */       b.writeInt(JRMCoreHJFC.getConfigcpt());
/*      */     }
/*      */     
/* 6688 */     if (NC()) {
/*      */       
/* 6690 */       ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cNCRacialSkillTPCost));
/* 6691 */       ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cNCSkillTPCost));
/* 6692 */       ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransGtsDmgO));
/*      */     } 
/*      */     
/* 6695 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cDBCRacialSkillTPCost));
/* 6696 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cDBCSkillTPCost));
/* 6697 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransKaiDmgO));
/* 6698 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransKaiDrainOLevel));
/* 6699 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransKaiDrainORace));
/* 6700 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransMngDmgO));
/* 6701 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransKaiNmsO));
/* 6702 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransSaiStBnPO));
/* 6703 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransHalfSaiStBnPO));
/* 6704 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransFrStBnPO));
/* 6705 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransHmStBnPO));
/* 6706 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransNaStBnPO));
/* 6707 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(TransMaStBnPO));
/*      */     
/* 6709 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cDBCRacialSkillMindCost));
/* 6710 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cDBCSkillMindCost));
/* 6711 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cNCRacialSkillMindCost));
/* 6712 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(cNCSkillMindCost));
/* 6713 */     b.writeBoolean(JRMCoreConfig.OverAtrLimitO);
/* 6714 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cMysticDamMulti));
/*      */     
/* 6716 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPMax));
/* 6717 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPGrowth));
/* 6718 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPCost));
/* 6719 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPDamMulti));
/* 6720 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cArcosianPPDamMultiPoint));
/* 6721 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cAttibuteBonusPerRacialSkill));
/* 6722 */     b.writeInt(JRMCoreConfig.cArcosianPPDamMultiHighest);
/*      */     
/* 6724 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cTPGainRateRace));
/* 6725 */     ByteBufUtils.writeUTF8String(b, (new Gson()).toJson(JRMCoreConfig.cTPGainRace));
/*      */ 
/*      */     
/* 6728 */     b.writeBoolean(JRMCoreConfig.cexpGriOff);
/* 6729 */     b.writeInt(JRMCoreConfig.cSklMedCat);
/* 6730 */     b.writeFloat(JRMCoreConfig.cSklMedRate);
/* 6731 */     b.writeBoolean(JRMCoreConfig.creleaseStop);
/* 6732 */     b.writeBoolean(JRMCoreConfig.cregen);
/* 6733 */     b.writeBoolean(JRMCoreConfig.crelease);
/* 6734 */     b.writeInt(JRMCoreConfig.ctpgn);
/* 6735 */     b.writeInt(etXq4V(JRMCoreConfig.ctmx));
/* 6736 */     ByteBufUtils.writeUTF8String(b, JRMCoreConfig.cregenRate);
/* 6737 */     ByteBufUtils.writeUTF8String(b, JRMCoreConfig.chRegenRate);
/* 6738 */     b.writeBoolean(JRMCoreConfig.csizes);
/* 6739 */     ByteBufUtils.writeUTF8String(b, JRMCoreConfig.cssurl);
/* 6740 */     ByteBufUtils.writeUTF8String(b, JRMCoreConfig.cssurl2);
/* 6741 */     ByteBufUtils.writeUTF8String(b, JRMCoreConfig.cssc);
/* 6742 */     b.writeBoolean(JRMCoreConfig.csfzns);
/* 6743 */     b.writeBoolean(JRMCoreConfig.cNPCSpawnCheck);
/* 6744 */     b.writeBoolean(JRMCoreConfig.cBuildingSpawnCheck);
/* 6745 */     b.writeInt(JRMCoreConfig.cbuildingSpawnAreaSize);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6750 */     b.writeBoolean(JGConfigMiniGameConcentration.cTPGainOn);
/* 6751 */     b.writeFloat(JGConfigMiniGameConcentration.cTPlimitIncreasesWithPlayerLevel);
/* 6752 */     b.writeFloat(JGConfigMiniGameConcentration.cTPMultiplier);
/* 6753 */     b.writeInt(JGConfigMiniGameConcentration.cTPDailyLimit);
/* 6754 */     b.writeFloat(JGConfigMiniGameConcentration.cComboTimer);
/* 6755 */     b.writeBoolean(JGConfigMiniGameConcentration.cConstantClickOn);
/* 6756 */     b.writeInt(JGConfigMiniGameConcentration.cRandomMovementSpeed);
/*      */     
/* 6758 */     b.writeBoolean(JGConfigMiniGameAirBoxing.cTPGainOn);
/* 6759 */     b.writeFloat(JGConfigMiniGameAirBoxing.cTPlimitIncreasesWithPlayerLevel);
/* 6760 */     b.writeFloat(JGConfigMiniGameAirBoxing.cTPMultiplier);
/* 6761 */     b.writeInt(JGConfigMiniGameAirBoxing.cTPDailyLimit);
/* 6762 */     b.writeInt(JGConfigMiniGameAirBoxing.cStartLife);
/* 6763 */     for (int i = 0; i < 4; i++) {
/* 6764 */       b.writeFloat(JGConfigMiniGameAirBoxing.cKeySpawnSpeed[i]);
/* 6765 */       b.writeFloat(JGConfigMiniGameAirBoxing.cKeySpeed[i]);
/* 6766 */       b.writeInt(JGConfigMiniGameAirBoxing.cKeyLifeTaken[i]);
/* 6767 */       int count = (JGConfigMiniGameAirBoxing.cKeyTypeIDs[i]).length;
/* 6768 */       b.writeInt(count);
/* 6769 */       for (int k = 0; k < count; k++) {
/* 6770 */         b.writeInt(JGConfigMiniGameAirBoxing.cKeyTypeIDs[i][k]);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 6775 */     b.writeInt(JRMCoreConfig.cStatPasDef);
/* 6776 */     b.writeInt(JRMCoreConfig.cmjn);
/*      */     
/* 6778 */     b.writeDouble(JRMCoreConfig.catcm);
/* 6779 */     b.writeInt(JRMCoreConfig.cAttributeUpgradeCost_StartMinus);
/* 6780 */     b.writeInt(JRMCoreConfig.cAttributeUpgradeCost_Min); float[] arrayOfFloat; int j; byte b1;
/* 6781 */     for (arrayOfFloat = JRMCoreConfig.cAttributeUpgradeCost_AttributeMulti, j = arrayOfFloat.length, b1 = 0; b1 < j; ) { double d = arrayOfFloat[b1]; b.writeDouble(d); b1++; }
/* 6782 */      b.writeInt(JRMCoreConfig.clgnd);
/* 6783 */     ByteBufUtils.writeUTF8String(b, JRMCoreConfig.clgndb);
/* 6784 */     b.writeBoolean(JRMCoreConfig.clockon);
/* 6785 */     b.writeDouble(JRMCoreConfig.cFlngspd);
/*      */ 
/*      */     
/* 6788 */     if (DBC()) {
/*      */ 
/*      */       
/* 6791 */       String s = ""; int k;
/* 6792 */       for (k = 0; k < JRMCoreConfig.cdat5695.length; k++) {
/* 6793 */         s = s + JRMCoreConfig.cdat5695[k];
/* 6794 */         if (k + 1 < JRMCoreConfig.cdat5695.length) s = s + " "; 
/*      */       } 
/* 6796 */       ByteBufUtils.writeUTF8String(b, s);
/*      */ 
/*      */       
/* 6799 */       s = "";
/* 6800 */       for (k = 0; k < JRMCoreConfig.cdat5696.length; k++) {
/* 6801 */         for (int m = 0; m < (JRMCoreConfig.cdat5696[m]).length; m++) {
/* 6802 */           s = s + JRMCoreConfig.cdat5696[k][m];
/* 6803 */           if (m + 1 < JRMCoreConfig.cdat5696.length) s = s + " "; 
/*      */         } 
/* 6805 */         if (k + 1 < JRMCoreConfig.cdat5696.length) s = s + ";"; 
/*      */       } 
/* 6807 */       ByteBufUtils.writeUTF8String(b, s);
/*      */ 
/*      */       
/* 6810 */       s = "";
/* 6811 */       for (k = 0; k < JRMCoreConfig.cdat5709.length; k++) {
/* 6812 */         s = s + JRMCoreConfig.cdat5709[k];
/* 6813 */         if (k + 1 < JRMCoreConfig.cdat5709.length) s = s + " "; 
/*      */       } 
/* 6815 */       ByteBufUtils.writeUTF8String(b, s);
/*      */     } 
/*      */ 
/*      */     
/* 6819 */     if (DBC() || NC())
/*      */     {
/* 6821 */       b.writeBoolean(JRMCoreConfig.cdat5711);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 6826 */     if (DBC()) {
/*      */       
/* 6828 */       b.writeByte(JGConfigUltraInstinct.cCONFIG_UI_LEVELS);
/*      */       
/* 6830 */       for (int k = 0; k < JGConfigUltraInstinct.cCONFIG_UI_LEVELS; k++) {
/*      */         
/* 6832 */         b.writeInt(JGConfigUltraInstinct.cCONFIG_UI_HEAT_DURATION[k]);
/* 6833 */         b.writeBoolean(JGConfigUltraInstinct.cCONFIG_UI_HAIR_WHITE[k]);
/* 6834 */         b.writeInt(JGConfigUltraInstinct.cCONFIG_UI_ATTRIBUTE_MULTI[k]);
/*      */         int m;
/* 6836 */         for (m = 0; m < Races.length; m++) {
/* 6837 */           b.writeFloat(JGConfigUltraInstinct.cCONFIG_UI_ATTRIBUTE_MULTI_RACE[k][m]);
/*      */         }
/*      */         
/* 6840 */         for (m = 0; m < 2; m++) {
/*      */           
/* 6842 */           b.writeByte(JGConfigUltraInstinct.cCONFIG_UI_DODGE_RATE[k][m]);
/* 6843 */           b.writeByte(JGConfigUltraInstinct.cCONFIG_UI_ATTACK_RATE[k][m]);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 6848 */     b.writeByte(JRMCoreConfig.cExtendedPlayerBlockID);
/* 6849 */     b.writeByte(JRMCoreConfig.cExtendedPlayerOtherID);
/* 6850 */     b.writeByte(JRMCoreConfig.cExtendedPlayerHairID);
/*      */     
/* 6852 */     if (DBC()) {
/*      */       
/* 6854 */       b.writeBoolean(DBCConfig.cCanWhisTeleport);
/* 6855 */       b.writeFloat(DBCConfig.cEnmaScale);
/* 6856 */       b.writeFloat(DBCConfig.cGuruScale);
/*      */       
/* 6858 */       for (int k = 0; k < JRMCoreConfig.cContinuesKiAttacks.length; k++)
/*      */       {
/* 6860 */         b.writeBoolean(JRMCoreConfig.cContinuesKiAttacks[k]);
/*      */       }
/*      */       
/* 6863 */       b.writeBoolean(JRMCoreConfig.cKiAttackScalesWithUser);
/*      */     } 
/*      */     
/* 6866 */     if (NC()) {
/*      */       
/* 6868 */       for (int k = 0; k < JRMCoreConfig.cContinuesJutsuAttacks.length; k++)
/*      */       {
/* 6870 */         b.writeBoolean(JRMCoreConfig.cContinuesJutsuAttacks[k]);
/*      */       }
/*      */       
/* 6873 */       b.writeBoolean(JRMCoreConfig.cJutsuScalesWithUser);
/*      */     } 
/*      */     
/* 6876 */     if (DBC() || NC()) {
/*      */       
/* 6878 */       b.writeBoolean(JRMCoreConfig.cWavesShrinkOnceLetGo);
/* 6879 */       b.writeBoolean(JRMCoreConfig.cContinuesEnergyAttackTargetSlowdown);
/* 6880 */       b.writeInt(JRMCoreConfig.cContinuesEnergyAttackTimer);
/*      */     } 
/*      */     
/* 6883 */     b.writeInt(JRMCoreConfig.ceaesl);
/* 6884 */     b.writeFloat(JRMCoreConfig.cealbm);
/*      */     
/* 6886 */     if (DBC()) {
/*      */       
/* 6888 */       b.writeInt(DBCConfig.cNullRealmMinimumHeight);
/* 6889 */       for (int k = 0; k < 9; k++)
/*      */       {
/* 6891 */         b.writeDouble(JRMCoreConfig.cdat5696[k][2]);
/*      */       }
/* 6893 */       b.writeBoolean(DBCConfig.cNullRealmBGColorNodeGreen);
/* 6894 */       b.writeBoolean(JRMCoreConfig.cPlayerFlyingDragDownOn);
/*      */     } 
/* 6896 */     if (DBC()) {
/*      */       
/* 6898 */       for (int k = 0; k < Races.length; k++) {
/*      */         
/* 6900 */         for (int n = 0; n < ClassesDBC.length; n++) {
/*      */           int i1;
/* 6902 */           for (i1 = 0; i1 < (attrInit[1]).length; i1++) {
/*      */             
/* 6904 */             b.writeDouble(JGConfigRaces.cCONFIG_RACES_ATTRIBUTE_MULTI[k][n][i1]);
/* 6905 */             b.writeInt(JGConfigRaces.cCONFIG_RACES_ATTRIBUTE_START[k][n][i1]);
/*      */           } 
/* 6907 */           for (i1 = 0; i1 < (statNames[1]).length; i1++) {
/*      */             
/* 6909 */             b.writeFloat(JGConfigRaces.cCONFIG_RACES_STATS_MULTI[k][n][i1]);
/* 6910 */             b.writeInt(JGConfigRaces.cCONFIG_RACES_STAT_BONUS[k][n][i1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 6915 */       b.writeBoolean(JGConfigRaces.cCONFIG_MAJIN_ENABLED);
/*      */ 
/*      */       
/* 6918 */       b.writeBoolean(JGConfigRaces.cCONFIG_MAJIN_ABSORPTION_ENABLED);
/* 6919 */       b.writeBoolean(JGConfigRaces.cCONFIG_MAJIN_PURE_PINK_SKIN);
/* 6920 */       b.writeBoolean(JGConfigRaces.cCONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS);
/* 6921 */       for (int m = 0; m < (TransNms[5]).length + 3; m++) {
/*      */         
/* 6923 */         b.writeFloat(JGConfigRaces.cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[m]);
/* 6924 */         b.writeFloat(JGConfigRaces.cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[m]);
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
/* 6958 */     b.writeBoolean(JRMCoreConfig.cJRMCABonusOn);
/* 6959 */     b.writeBoolean(JRMCoreConfig.cShadowDummyScaleToTarget);
/* 6960 */     if (DBC()) {
/*      */       
/* 6962 */       b.writeBoolean(JGConfigUltraInstinct.cCONFIG_UI_IGNORE_BASE_CONFIG);
/* 6963 */       b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_IGNORE_BASE_CONFIG);
/* 6964 */       b.writeInt(JGConfigDBCGoD.cCONFIG_GOD_IGNORED_DAMAGE_SOURCES.length); int k;
/* 6965 */       for (k = 0; k < JGConfigDBCGoD.cCONFIG_GOD_IGNORED_DAMAGE_SOURCES.length; k++) {
/* 6966 */         ByteBufUtils.writeUTF8String(b, JGConfigDBCGoD.cCONFIG_GOD_IGNORED_DAMAGE_SOURCES[k]);
/*      */       }
/* 6968 */       b.writeInt(JGConfigDBCGoD.cCONFIG_GOD_IGNORED_ENTITIES.length);
/* 6969 */       for (k = 0; k < JGConfigDBCGoD.cCONFIG_GOD_IGNORED_ENTITIES.length; k++) {
/* 6970 */         ByteBufUtils.writeUTF8String(b, JGConfigDBCGoD.cCONFIG_GOD_IGNORED_ENTITIES[k]);
/*      */       }
/* 6972 */       b.writeFloat(JGConfigDBCGoD.cCONFIG_GOD_IGNORE_DAMAGE_MULTI);
/* 6973 */       b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_IGNORE_PROJECTILES_ENABLED);
/* 6974 */       b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_ENABLED);
/* 6975 */       b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_AURA_ENABLED);
/* 6976 */       b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_AURA_ENABLED_WITH_AURA);
/* 6977 */       b.writeBoolean(JGConfigDBCGoD.cCONFIG_GOD_ENERGY_ENABLED);
/* 6978 */       b.writeFloat(JGConfigDBCGoD.cCONFIG_GOD_ENERGY_DAMAGE_MULTI);
/* 6979 */       b.writeFloat(JGConfigDBCGoD.cCONFIG_GOD_ATTRIBUTE_MULTI);
/* 6980 */       for (k = 0; k < Races.length; k++) {
/* 6981 */         b.writeFloat(JGConfigDBCGoD.cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[k]);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 6987 */     b.writeBoolean(JRMCoreConfig.cBuildingBlocksRenderAsNormalBlock);
/*      */ 
/*      */     
/* 6990 */     b.writeFloat(JGConfigSkills.cGlobalSkillTPMultiplier);
/* 6991 */     b.writeFloat(JGConfigSkills.cGlobalSkillMindMultiplier);
/* 6992 */     b.writeFloat(JGConfigSkills.cGlobalSkillTPMultiplierFirst);
/* 6993 */     b.writeFloat(JGConfigSkills.cGlobalSkillMindMultiplierFirst);
/* 6994 */     b.writeBoolean(JGConfigSkills.cGlobalSkillTPMultiplierWithLevel);
/* 6995 */     b.writeBoolean(JGConfigSkills.cGlobalSkillMindMultiplierWithLevel);
/*      */     
/* 6997 */     if (NC())
/*      */     {
/* 6999 */       b.writeInt(JRMCoreConfig.cNCExplosionTagTickTimer);
/*      */     }
/*      */     
/* 7002 */     if (DBC()) {
/*      */       
/* 7004 */       b.writeInt(DBCConfig.cAaiForceDifficulty);
/* 7005 */       b.writeBoolean(DBCConfig.cAaiDisabled);
/* 7006 */       b.writeInt(DBCConfig.cEnemyDefaultAttackTimer);
/* 7007 */       b.writeInt(DBCConfig.cEnemyDefaultShortRangeAttackTimer);
/* 7008 */       b.writeDouble(DBCConfig.cEnemyDefaultMoveSpeed);
/* 7009 */       b.writeBoolean(DBCConfig.cKiAttackGoThroughInvulnerableEnemies);
/*      */       
/* 7011 */       b.writeBoolean(DBCConfig.cInstantTransformOn);
/* 7012 */       b.writeBoolean(DBCConfig.cSingleFormDescendOn); int k;
/* 7013 */       for (k = 0; k < DBCConfig.cIsInstantTransformEnabled.length; k++)
/*      */       {
/* 7015 */         b.writeBoolean(DBCConfig.cIsInstantTransformEnabled[k]);
/*      */       }
/* 7017 */       b.writeBoolean(DBCConfig.cKaiokenSingleFormDescendOn);
/* 7018 */       b.writeBoolean(DBCConfig.cMoveWhileTransforming);
/* 7019 */       b.writeBoolean(DBCConfig.cMoveWhileInstantTransforming);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 7024 */       for (k = 0; k < JGConfigDBCAAiDifficulty.DIFFICULTIES.length; k++) {
/*      */         
/* 7026 */         b.writeDouble(JGConfigDBCAAiDifficulty.cGroundDashSpeedMulti[k]);
/* 7027 */         b.writeDouble(JGConfigDBCAAiDifficulty.cGroundDashSpeedMulti2[k]);
/* 7028 */         b.writeDouble(JGConfigDBCAAiDifficulty.cGroundDashLimit[k]);
/*      */         
/* 7030 */         b.writeDouble(JGConfigDBCAAiDifficulty.cJumpMulti[k]);
/* 7031 */         b.writeDouble(JGConfigDBCAAiDifficulty.cJumpMulti2[k]);
/* 7032 */         b.writeDouble(JGConfigDBCAAiDifficulty.cJumpLimit[k]);
/* 7033 */         b.writeDouble(JGConfigDBCAAiDifficulty.cJumpLimit2[k]);
/* 7034 */         b.writeDouble(JGConfigDBCAAiDifficulty.cJumpRate[k]);
/*      */         
/* 7036 */         b.writeDouble(JGConfigDBCAAiDifficulty.cFlyingDashMulti[k]);
/* 7037 */         b.writeDouble(JGConfigDBCAAiDifficulty.cFlyingDashLimit[k]);
/*      */         
/* 7039 */         b.writeDouble(JGConfigDBCAAiDifficulty.cKiAttackChargeMulti[k]);
/* 7040 */         b.writeDouble(JGConfigDBCAAiDifficulty.cKiAttackChargeLimit[k]);
/*      */         
/* 7042 */         b.writeInt(JGConfigDBCAAiDifficulty.cTeleportRateMin[k]);
/* 7043 */         b.writeInt(JGConfigDBCAAiDifficulty.cTeleportRateMax[k]);
/*      */         
/* 7045 */         b.writeDouble(JGConfigDBCAAiDifficulty.cSpeedMulti[k]);
/*      */       } 
/*      */ 
/*      */       
/* 7049 */       b.writeBoolean(DBCConfig.cMysticKaiokenOn);
/*      */ 
/*      */       
/* 7052 */       for (k = 0; k < Races.length; k++) {
/*      */         
/* 7054 */         for (int m = 0; m < (JRMCoreConfig.KaiokenFormHealthCost[k]).length; m++)
/*      */         {
/* 7056 */           b.writeFloat(JRMCoreConfig.cKaiokenFormHealthCost[k][m]);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 7061 */       for (k = 0; k < 2; k++) {
/* 7062 */         b.writeBoolean(JGConfigDBCInstantTransmission.CCONFIG_INSTANT_TRANSMISSION_ENABLED[k]);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7070 */     b.writeBoolean(JGConfigDBCFormMastery.cFM_Enabled);
/* 7071 */     for (int raceID = 0; raceID < Races.length; raceID++) {
/*      */       
/* 7073 */       int racials = (trans[raceID]).length;
/* 7074 */       for (int formID = 0; formID < (JGConfigDBCFormMastery.cFormMasteries[raceID]).length; formID++) {
/*      */         
/* 7076 */         boolean racial = (formID < racials);
/* 7077 */         String form = racial ? trans[raceID][formID] : transNonRacial[formID - racials];
/* 7078 */         if (!racial || !isRaceSaiyan(raceID) || (!form.equals(trans[raceID][12]) && !form.equals(trans[raceID][13])))
/*      */         {
/*      */           
/* 7081 */           for (int k = 0; k < 3; k++)
/*      */           {
/* 7083 */             b.writeDouble(JGConfigDBCFormMastery.cFormMasteries[raceID][formID].getDouble(0, k));
/*      */           }
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getMaxEnergyDamage() {
/* 7092 */     float max = JRMCoreConfig.tmx * 10.0F;
/* 7093 */     if (max < 0.0F) max = JRMCoreConfig.tmx; 
/* 7094 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int state2UltraInstinct(byte state2) {
/* 7100 */     return state2UltraInstinct(false, state2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int state2UltraInstinct(boolean kaioken, byte state2) {
/* 7105 */     return (kaioken || state2 == 0 || state2 > JGConfigUltraInstinct.CONFIG_UI_LEVELS) ? 0 : (state2 - 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getHeatPercentageClient() {
/* 7110 */     if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */       
/* 7112 */       int heat_current = cura;
/* 7113 */       int state2 = state2UltraInstinct(StusEfctsMe(5), State2);
/*      */       
/* 7115 */       int heat_max = JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[state2];
/* 7116 */       if (heat_max == 0) return 100.0F; 
/* 7117 */       float heat_one = heat_max / 100.0F;
/* 7118 */       float heat_current_percentage = heat_current / heat_one;
/* 7119 */       if (heat_current_percentage < 0.0F) heat_current_percentage *= -1.0F;
/*      */       
/* 7121 */       return heat_current_percentage;
/*      */     } 
/* 7123 */     return 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getHeatPercentage(EntityPlayer player, byte status2) {
/* 7128 */     if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */       
/* 7130 */       int heatCurrent = getByte(player, "jrmcEf8slc");
/* 7131 */       int heatMax = JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[status2];
/* 7132 */       if (heatMax == 0) return 100.0F; 
/* 7133 */       float heatOne = heatMax / 100.0F;
/* 7134 */       float heatPercentage = heatCurrent / heatOne;
/* 7135 */       if (heatPercentage < 0.0F) heatPercentage *= -1.0F;
/*      */       
/* 7137 */       return heatPercentage;
/*      */     } 
/* 7139 */     return 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public static byte getUltraInstinctRate(EntityPlayer player, byte status2, byte[][] rates) {
/* 7144 */     if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */       
/* 7146 */       byte max = rates[status2][1];
/* 7147 */       if (max == 0) return 0; 
/* 7148 */       byte min = rates[status2][0];
/* 7149 */       byte diff = (byte)(max - min);
/* 7150 */       if (diff == 0) return min;
/*      */       
/* 7152 */       float heatPercentage = getHeatPercentage(player, status2);
/*      */       
/* 7154 */       int current = (byte)(int)(diff * heatPercentage * 0.01F + diff);
/* 7155 */       if (current < 0) current *= -1; 
/* 7156 */       if (current > 100) current = 100; 
/* 7157 */       return (byte)current;
/*      */     } 
/* 7159 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static byte getUltraInstinctDodgeRate(EntityPlayer player, byte status2) {
/* 7164 */     return getUltraInstinctRate(player, status2, JGConfigUltraInstinct.CONFIG_UI_DODGE_RATE);
/*      */   }
/*      */ 
/*      */   
/*      */   public static byte getUltraInstinctCounterRate(EntityPlayer player, byte status2) {
/* 7169 */     return getUltraInstinctRate(player, status2, JGConfigUltraInstinct.CONFIG_UI_ATTACK_RATE);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean canUltraInstinctDodgeSource(DamageSource source) {
/* 7175 */     return !JGConfigUltraInstinct.CONFIG_UI_CANT_DODGE.contains(source.func_76355_l());
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean canUltraInstinctCounterSource(DamageSource source) {
/* 7180 */     return JGConfigUltraInstinct.CONFIG_UI_CAN_COUNTER.contains(source.func_76355_l());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 7185 */   public static float Perc10 = 0.9F;
/* 7186 */   public static float Perc15 = 0.85F;
/* 7187 */   public static float Perc20 = 0.8F; public static float Perc(int d) {
/* 7188 */     return (d == 1) ? Perc10 : ((d == 2) ? Perc15 : 1.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void expPls(EntityPlayer player, int value) {
/* 7193 */     int xpLimit = 10;
/* 7194 */     int tpGain = 1;
/* 7195 */     if (DBC()) {
/* 7196 */       int d = getByte(player, "jrmcDiff");
/*      */ 
/*      */ 
/*      */       
/* 7200 */       JGPlayerMP jgPlayer = new JGPlayerMP(player);
/* 7201 */       jgPlayer.connectBaseNBT();
/* 7202 */       int race = jgPlayer.getRace();
/* 7203 */       tpGain = (int)(JRMCoreConfig.tpgn * JRMCoreConfig.TPGainRace[race]);
/*      */     } 
/*      */     
/* 7206 */     int exp = getByte(player, "jrmcExp");
/* 7207 */     int tp = getInt(player, "jrmcTpint");
/* 7208 */     int add = value;
/* 7209 */     if (tp < getMaxTP()) {
/* 7210 */       if (exp + value >= xpLimit) {
/* 7211 */         for (int i = 0; i < (exp + value) / xpLimit; i++) {
/* 7212 */           if (i == (exp + value) / xpLimit - 1)
/*      */           {
/* 7214 */             setInt(tp + (i + 1) * tpGain, player, "jrmcTpint");
/*      */           }
/*      */         } 
/*      */       }
/* 7218 */       add = exp + value - (exp + value) / xpLimit * xpLimit;
/* 7219 */       setByte(add, player, "jrmcExp");
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void triForce(int i, int j, int k) {
/* 7224 */     PD.sendToServer((IMessage)new JRMCorePTri((byte)i, (byte)j, (byte)k));
/*      */   }
/*      */ 
/*      */   
/*      */   static void jrmct(int t, String s, EntityPlayer p) {
/* 7229 */     PD.sendTo((IMessage)new JRMCorePTick(t, s), (EntityPlayerMP)p);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void jrmct(int t) {}
/*      */   
/*      */   public static void jrmctAll(int t, String s) {
/* 7236 */     PD.sendToAll((IMessage)new JRMCorePTick(t, s));
/*      */   }
/* 7238 */   public static void jrmcDataFC(int c, String d) { PD.sendToServer((IMessage)new JRMCorePData(c, d)); }
/* 7239 */   public static void jrmcData(int c, String d) { PD.sendToAll((IMessage)new JRMCorePData(c, d)); } public static void jrmcDataToP(int c, String d, EntityPlayer p) {
/* 7240 */     PD.sendTo((IMessage)new JRMCorePData(c, d), (EntityPlayerMP)p);
/*      */   } public static void Char(byte b, byte b2) {
/* 7242 */     PD.sendToServer((IMessage)new JRMCorePChar(b, b2));
/*      */   } public static void Upg(byte b) {
/* 7244 */     PD.sendToServer((IMessage)new JRMCorePUpgrade(b));
/*      */   } public static void Attck(byte b) {
/* 7246 */     PD.sendToServer((IMessage)new JRMCorePAttck(b));
/*      */   } public static void Rls(byte b) {
/* 7248 */     PD.sendToServer((IMessage)new JRMCorePRls(b));
/*      */   } public static void Cost(int cost2) {
/* 7250 */     PD.sendToServer((IMessage)new JRMCorePCost((short)cost2));
/*      */   } public static void Stats(EntityPlayer p, int curBody, int curEnergy, int curStamina, byte curRelease, byte b) {
/* 7252 */     PD.sendTo((IMessage)new JRMCorePStats(curBody, curEnergy, curStamina, curRelease, b), (EntityPlayerMP)p);
/*      */   } public static void Stats2(EntityPlayer p, int curTP, int curExp, byte align, int[] plyrAttrbts2) {
/* 7254 */     PD.sendTo((IMessage)new JRMCorePStats2(curTP, curExp, align, plyrAttrbts2), (EntityPlayerMP)p);
/*      */   } public static void Stats3(EntityPlayer p, String PlyrSkills, String x, String y, String z) {
/* 7256 */     PD.sendTo((IMessage)new JRMCorePStats3b(PlyrSkills, x, y, z), (EntityPlayerMP)p);
/*      */   } public static void Tech(EntityPlayer p, byte n, String t) {
/* 7258 */     PD.sendTo((IMessage)new JRMCorePTech(n, t), (EntityPlayerMP)p);
/*      */   } public static void Tech(byte n, String t) {
/* 7260 */     PD.sendToServer((IMessage)new JRMCorePTech(n, t));
/*      */   } public static void Skll(byte op, byte id) {
/* 7262 */     PD.sendToServer((IMessage)new JRMCorePStats3(op, id, (byte)1));
/*      */   } public static void Skll(byte op, byte id, byte bn) {
/* 7264 */     PD.sendToServer((IMessage)new JRMCorePStats3(op, id, bn));
/*      */   } public static void Anim(int i) {
/* 7266 */     PD.sendToServer((IMessage)new JRMCorePFall((byte)i));
/*      */   }
/*      */   
/*      */   public static void resetDBCworldgen() {
/* 7270 */     WorldGeneratorDB.KiLtSpawn = true;
/* 7271 */     WorldGeneratorDB.KiLtTCSpawn = true;
/* 7272 */     WorldGeneratorDB.ChkInStSpawn = true;
/* 7273 */     WorldGeneratorDB.SnkWySpawn = true;
/* 7274 */     WorldGeneratorDB.TiChaSpawn = true;
/* 7275 */     WorldGeneratorDB.TiChaKLSpawn = true;
/* 7276 */     WorldGeneratorDB.KnTrSpawn = true;
/* 7277 */     WorldGeneratorDB.WorldGen_TOPArena_Done = true;
/* 7278 */     WorldGeneratorDB.WorldGen_TOPZeno_Done = true;
/* 7279 */     WorldGeneratorDB.WorldGen_Zeno_Done = true;
/* 7280 */     WorldGeneratorDB.KHSpawn = true;
/* 7281 */     WorldGeneratorDB.CASpawn = true;
/* 7282 */     WorldGeneratorDB.GHSpawn = true;
/* 7283 */     WorldGeneratorDB.FSSpawn = true;
/* 7284 */     WorldGeneratorDB.BSSpawn = true;
/* 7285 */     WorldGeneratorDB.WorldGen_GuruHouse_Done = true;
/* 7286 */     DBCH.genCA = "";
/* 7287 */     DBCH.genKH = "";
/* 7288 */     DBCH.genGH = "";
/* 7289 */     DBCH.genFS = "";
/* 7290 */     DBCH.genBS = "";
/* 7291 */     DBCH.genGuru = "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void resetNCworldgen() {
/* 7298 */     WorldGeneratorNC.KonohaSpawn = true;
/* 7299 */     NCH.genKnvl = "";
/*      */ 
/*      */     
/* 7302 */     NCCommonTickHandler.sentDatnc0 = null;
/* 7303 */     NCCommonTickHandler.sentDatnc1 = null;
/*      */   }
/*      */   
/*      */   public static boolean DBCresetted = true;
/*      */   public static boolean NCresetted = true;
/*      */   
/*      */   public static void resetDedSer() {
/* 7310 */     DBCresetted = true;
/* 7311 */     NCresetted = true;
/* 7312 */     if (DBC()) resetDBCworldgen(); 
/* 7313 */     if (NC()) resetNCworldgen(); 
/* 7314 */     JRMCoreComTickH.bldngChkr = true;
/* 7315 */     JRMCoreComTickH.start = true;
/* 7316 */     JRMCoreComTickH.bldngsChecker = 300;
/* 7317 */     JRMCoreComTickH.sentData0 = null;
/* 7318 */     JRMCoreComTickH.sentData1 = null;
/* 7319 */     JRMCoreComTickH.sentData2 = null;
/* 7320 */     JRMCoreComTickH.sentData3 = null;
/* 7321 */     JRMCoreComTickH.sentData4 = null;
/* 7322 */     JRMCoreComTickH.sentData5 = null;
/* 7323 */     JRMCoreComTickH.sentData6 = null;
/* 7324 */     JRMCoreComTickH.sentData7 = null;
/* 7325 */     JRMCoreComTickH.sentData8 = null;
/* 7326 */     JRMCoreComTickH.sentData9 = null;
/* 7327 */     JRMCoreComTickH.sentDat10 = null;
/* 7328 */     JRMCoreComTickH.sentDat11 = null;
/* 7329 */     JRMCoreComTickH.sentDat12 = null;
/* 7330 */     JRMCoreComTickH.sentDat13 = null;
/* 7331 */     JRMCoreComTickH.sentDat14 = null;
/* 7332 */     JRMCoreComTickH.sentDat15 = null;
/* 7333 */     JRMCoreComTickH.sentDat16 = null;
/* 7334 */     JRMCoreComTickH.sentDat17 = null;
/* 7335 */     JRMCoreComTickH.sentDat18 = null;
/* 7336 */     JRMCoreComTickH.sentDat19 = null;
/* 7337 */     JRMCoreComTickH.sentDat20 = null;
/* 7338 */     JRMCoreComTickH.sentDat21 = null;
/* 7339 */     JRMCoreComTickH.sentDat22 = null;
/* 7340 */     JRMCoreComTickH.sentDat23 = null;
/* 7341 */     JRMCoreComTickH.sentDat24 = null;
/* 7342 */     JRMCoreComTickH.sentDat25 = null;
/* 7343 */     JRMCoreComTickH.sentDat26 = null;
/* 7344 */     JRMCoreComTickH.sentDat27 = null;
/* 7345 */     JRMCoreComTickH.sentDat28 = null;
/* 7346 */     JRMCoreComTickH.sentDat29 = null;
/* 7347 */     JRMCoreComTickH.sentDat30 = null;
/* 7348 */     JRMCoreComTickH.sentDat31 = null;
/* 7349 */     JRMCoreComTickH.sentDat32 = null;
/* 7350 */     if (JFC());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void resetChar(EntityPlayer p) {
/* 7355 */     resetChar(p, false, false, false, 0.0F);
/*      */   }
/*      */   public static void resetChar(EntityPlayer p, boolean keepSkills, boolean keepTechs) {
/* 7358 */     resetChar(p, keepSkills, keepTechs, false, 0.0F);
/*      */   }
/*      */   public static void resetChar(EntityPlayer p, boolean keepSkills, boolean keepTechs, boolean keepMasteries, float perc) {
/* 7361 */     String nam = p.func_70005_c_();
/* 7362 */     String[] pw = { "NotSelected", "DBC", "NC", "SAO" };
/* 7363 */     int pwr = getByte(p, "jrmcPwrtyp");
/* 7364 */     mod_JRMCore.logger.info("Character reset for " + nam);
/* 7365 */     mod_JRMCore.logger.info("Power User: " + pw[pwr]);
/* 7366 */     mod_JRMCore.logger.info("Alignment: " + getByte(p, "jrmcAlign"));
/*      */     
/* 7368 */     mod_JRMCore.logger.info("Race: " + Races[getByte(p, "jrmcRace")]);
/* 7369 */     mod_JRMCore.logger.info("Class: " + cl(getByte(p, "jrmcPwrtyp"))[getByte(p, "jrmcClass")]);
/* 7370 */     for (int i = 0; i < (attrNms[pwr]).length; i++) {
/* 7371 */       mod_JRMCore.logger.info(attrNms(pwr, i) + ": " + getInt(p, AttrbtNbtI[i]));
/*      */     }
/*      */     
/* 7374 */     String[] PlyrSkills = getString(p, "jrmcSSlts").split(","); byte j;
/* 7375 */     for (j = 0; j < PlyrSkills.length; j = (byte)(j + 1)) {
/* 7376 */       String skl = PlyrSkills[j];
/* 7377 */       if (skl.length() > 2) {
/* 7378 */         mod_JRMCore.logger.info("Skill: " + SklName(skl, (pwr == 1) ? DBCSkillsIDs : NCSkillIDs, (pwr == 1) ? DBCSkillNames : NCSkillNames) + " lvl: " + (Integer.parseInt(skl.substring(2)) + 1));
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 7383 */     if (!keepMasteries) {
/* 7384 */       mod_JRMCore.logger.info("Form Masteries (Racial): " + getString(p, getNBTFormMasteryRacialKey(getByte(p, "jrmcRace"))));
/* 7385 */       mod_JRMCore.logger.info("Form Masteries (Non-Racial): " + getString(p, "jrmcFormMasteryNonRacial"));
/*      */     } 
/*      */     
/* 7388 */     setByte(67, p, "jrmcAlign");
/* 7389 */     setInt(0, p, "jrmcKarma");
/* 7390 */     setByte(0, p, "jrmcKillCountGood");
/* 7391 */     setByte(0, p, "jrmcKillCountNeut");
/* 7392 */     setByte(0, p, "jrmcKillCountEvil");
/* 7393 */     setByte(0, p, "jrmcDiedTimes");
/* 7394 */     setByte(0, p, "jrmcRelease");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7399 */     setByte(0, p, "jrmcPwrtyp");
/* 7400 */     setByte(0, p, "jrmcClass");
/* 7401 */     setInt(1, p, AttrbtNbtI[0]);
/* 7402 */     setInt(1, p, AttrbtNbtI[1]);
/* 7403 */     setInt(1, p, AttrbtNbtI[2]);
/* 7404 */     setInt(1, p, AttrbtNbtI[3]);
/* 7405 */     setInt(1, p, AttrbtNbtI[4]);
/* 7406 */     setInt(1, p, AttrbtNbtI[5]);
/* 7407 */     setByte(0, p, "jrmcState");
/* 7408 */     setByte(0, p, "jrmcState2");
/* 7409 */     setByte(0, p, "jrmcSaiRg");
/* 7410 */     setByte(-1, p, "jrmcTlmd");
/* 7411 */     setByte(0, p, "jrmcAccept");
/* 7412 */     setByte(0, p, "jrmcDiff");
/* 7413 */     setInt(99, p, "DBCSagaSys");
/* 7414 */     setString(" ", p, "jrmcStatusEff");
/* 7415 */     setString(" ", p, "jrmcSettings");
/* 7416 */     setString(" ", p, "JRMCmissionSync");
/* 7417 */     setString(" ", p, "JRMCmissionSyncVers");
/* 7418 */     setString(" ", p, "jrmcDNSAU");
/* 7419 */     setInt(0, p, "jrmcAfGFtStFT");
/*      */ 
/*      */     
/* 7422 */     if (getShort(p, "jrmcGTrnng") > 200) setShort(200, p, "jrmcGTrnng"); 
/* 7423 */     setString("pty", p, "jrmcSSltX");
/* 7424 */     setString("pty", p, "jrmcSSltY");
/* 7425 */     if (!keepSkills) {
/* 7426 */       setString(",", p, "jrmcSSlts");
/*      */     }
/* 7428 */     if (!keepTechs)
/* 7429 */       for (j = 0; j < techNbt.length; ) { setString(" ", p, techNbt[j]); j = (byte)(j + 1); }
/*      */        
/* 7431 */     if (!keepMasteries) {
/* 7432 */       setString("Base,0", p, getNBTFormMasteryRacialKey(getByte(p, "jrmcRace")));
/* 7433 */       setString("Kaioken,0", p, "jrmcFormMasteryNonRacial");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7455 */     setShort(0, p, "jrmcGTrnng");
/*      */     
/* 7457 */     setByte(0, p, "jrmcUIStateReach");
/* 7458 */     setByte(0, p, "jrmcUIWasInPain");
/* 7459 */     setByte(0, p, "jrmcUIWasInPainDuration");
/* 7460 */     setString("0;0", p, "jrmcInstantTransmissionTimers");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7467 */     setInt(0, p, "saocAp");
/* 7468 */     setInt(0, p, "saocCol");
/* 7469 */     setInt(0, p, "saocExp");
/* 7470 */     setInt(1, p, "saocLvl");
/*      */   }
/*      */   
/*      */   public static void resetChar() {
/* 7474 */     DBCresetted = true;
/*      */ 
/*      */ 
/*      */     
/* 7478 */     int[] att = { 0, 0, 0, 0, 0, 0 };
/* 7479 */     int[] stv = { 0, 0, 0, 0, 0, 0 };
/* 7480 */     PlyrAttrbts = att;
/*      */     
/* 7482 */     Race = 0;
/* 7483 */     dns = "0";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7488 */     Pwrtyp = 0;
/* 7489 */     Class = 0;
/* 7490 */     State = 0;
/* 7491 */     plyrsArnd = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7496 */     curBody = 0;
/* 7497 */     curEnergy = 0;
/* 7498 */     maxBody = 0;
/* 7499 */     maxEnergy = 0;
/* 7500 */     curRelease = 0;
/* 7501 */     curTP = 0;
/* 7502 */     curExp = 0;
/* 7503 */     State2 = 0;
/* 7504 */     Dffclty = 0;
/* 7505 */     TlMd = 0;
/* 7506 */     PtchVc = 0;
/* 7507 */     GTrnngCB = 0;
/* 7508 */     align = 0;
/* 7509 */     karma = 0;
/* 7510 */     WeightOn = 0.0F;
/* 7511 */     GravZone = 1.0F;
/*      */     
/* 7513 */     PlyrSettings = "";
/* 7514 */     PlyrSkillX = "";
/* 7515 */     PlyrSkillY = "";
/* 7516 */     PlyrSkillZ = "";
/* 7517 */     String[] str = { "", "", "", "", "", "", "", "", "", "" };
/* 7518 */     PlyrSkills = str;
/* 7519 */     tech1 = null;
/* 7520 */     tech2 = null;
/* 7521 */     tech3 = null;
/* 7522 */     tech4 = null;
/* 7523 */     techPM = null;
/*      */     
/* 7525 */     data0 = null;
/* 7526 */     data1 = null;
/* 7527 */     data2 = null;
/* 7528 */     data3 = null;
/* 7529 */     data4 = null;
/* 7530 */     data5 = null;
/* 7531 */     data6 = null;
/* 7532 */     data7 = null;
/* 7533 */     data8 = null;
/* 7534 */     data9 = null;
/* 7535 */     dat10 = null;
/* 7536 */     dat11 = null;
/* 7537 */     dat12 = null;
/* 7538 */     dat13 = null;
/* 7539 */     dat14 = null;
/* 7540 */     dat15 = null;
/* 7541 */     dat16 = null;
/* 7542 */     dat17 = null;
/* 7543 */     dat18 = null;
/* 7544 */     dat19 = null;
/* 7545 */     dat20 = null;
/* 7546 */     dat21 = null;
/* 7547 */     dat22 = null;
/* 7548 */     dat23 = null;
/* 7549 */     dat24 = null;
/* 7550 */     dat25 = null;
/* 7551 */     dat26 = null;
/* 7552 */     dat27 = null;
/* 7553 */     dat28 = null;
/* 7554 */     dat29 = null;
/* 7555 */     dat30 = null;
/* 7556 */     dat31 = null;
/* 7557 */     dat32 = null;
/* 7558 */     JRMCoreConfig.ssc = "empty";
/* 7559 */     JRMCoreConfig.ssurl = "empty";
/* 7560 */     JRMCoreConfig.ssurl2 = "empty";
/* 7561 */     JRMCoreConfig.sfzns = JRMCoreConfig.csfzns;
/* 7562 */     JRMCoreGuiScreen.CanRace = true;
/* 7563 */     JRMCoreGuiScreen.CanGender = true;
/* 7564 */     JRMCoreGuiScreen.CanHair = true;
/* 7565 */     JRMCoreGuiScreen.CanColor = true;
/* 7566 */     JRMCoreGuiScreen.CanSpecial = true;
/* 7567 */     JRMCoreGuiScreen.CanPwr = true;
/* 7568 */     JRMCoreGuiScreen.CanClass = true;
/* 7569 */     JRMCoreGuiScreen.RaceSlcted = 0;
/* 7570 */     JRMCoreGuiScreen.GenderSlcted = 0;
/* 7571 */     JRMCoreGuiScreen.HairSlcted = 10;
/* 7572 */     JRMCoreGuiScreen.ColorSlcted = 0;
/* 7573 */     JRMCoreGuiScreen.BrghtSlcted = 0.8F;
/* 7574 */     JRMCoreGuiScreen.BodyTypeSlcted = 0;
/* 7575 */     JRMCoreGuiScreen.PwrtypSlcted = 0;
/* 7576 */     JRMCoreGuiScreen.ClassSlcted = 0;
/* 7577 */     JRMCoreGuiScreen.tail = true;
/*      */     
/* 7579 */     JRMCoreM.missionsC = new HashMap<String, JRMCoreMsn>();
/* 7580 */     JRMCoreM.missionsCD = new HashMap<String, ArrayList<String>>();
/* 7581 */     MSD = "";
/* 7582 */     MSDV = "";
/*      */     
/* 7584 */     hsp = "";
/* 7585 */     jutsumode = 0;
/* 7586 */     handsealfailed = 0;
/* 7587 */     jutsu = 0;
/* 7588 */     jutsuinfo = 0;
/* 7589 */     ncDou = null;
/* 7590 */     SagaProg = 0;
/* 7591 */     SagaTimes = 0;
/* 7592 */     SagaSideProg = 0;
/* 7593 */     SagaSideTimes = null;
/* 7594 */     GID = 0;
/* 7595 */     GLID = " ";
/* 7596 */     GIDs = null;
/* 7597 */     GIDi = " ";
/* 7598 */     GMN = 0;
/* 7599 */     ServerPoints = 0;
/* 7600 */     PtchVc = 0;
/*      */     
/* 7602 */     if (JFC());
/*      */   }
/*      */   
/*      */   public static int jrmcEnergyDam(Entity Player, int dbcA, DamageSource s) {
/* 7606 */     if (!Player.field_70170_p.field_72995_K && 
/* 7607 */       Player instanceof EntityPlayer) {
/* 7608 */       EntityPlayer player = (EntityPlayer)Player;
/* 7609 */       ExtendedPlayer props = ExtendedPlayer.get(player);
/* 7610 */       boolean block = (props.getBlocking() == 1);
/* 7611 */       int[] PlyrAttrbts = PlyrAttrbts(player);
/* 7612 */       NBTTagCompound nbt = nbt((Entity)player, "pres");
/* 7613 */       byte st = nbt.func_74771_c("jrmcState");
/* 7614 */       int t = SklLvl(4, player);
/* 7615 */       byte rc = nbt.func_74771_c("jrmcRace");
/* 7616 */       byte pwr = nbt.func_74771_c("jrmcPwrtyp");
/* 7617 */       byte cls = nbt.func_74771_c("jrmcClass");
/* 7618 */       byte rls = getByte(player, "jrmcRelease");
/* 7619 */       int def = (int)(stat((Entity)player, 1, pwr, 1, PlyrAttrbts[1], rc, cls, 0.0F) * 0.5F);
/* 7620 */       def = block ? def : 0;
/*      */       
/* 7622 */       int ta = 0;
/* 7623 */       if (s != null && s.func_76346_g() instanceof EntityPlayer) {
/* 7624 */         String[] ops = PlyrSkills((EntityPlayer)s.func_76346_g());
/* 7625 */         ta = SklLvl(14, 1, ops);
/*      */       } 
/* 7627 */       int d = (int)((def * rls) * 0.01F);
/* 7628 */       int p = (int)((d * ta) * 0.01F);
/* 7629 */       dbcA = (int)((dbcA - d - p) * (1.0F - 0.03F * t));
/*      */ 
/*      */       
/* 7632 */       dbcA = (dbcA <= 0) ? 1 : dbcA;
/*      */       
/* 7634 */       int curBody = getInt(player, "jrmcEnrgy");
/* 7635 */       int all = curBody - dbcA;
/* 7636 */       setInt((all < 0) ? 0 : all, player, "jrmcEnrgy");
/*      */     } 
/*      */     
/* 7639 */     return dbcA;
/*      */   }
/*      */   
/*      */   public static int jrmcDam(Entity Player, int dbcA, DamageSource s, byte t) {
/* 7643 */     if (!Player.field_70170_p.field_72995_K && 
/* 7644 */       Player instanceof EntityPlayer && 
/* 7645 */       t == 2) {
/* 7646 */       Random ran = new Random();
/* 7647 */       int r = ran.nextInt(4);
/* 7648 */       if (r == 0) {
/* 7649 */         Player.field_70170_p.func_72956_a(Player, "jinryuudragonbc:DBC4.disckill", 1.0F, 1.0F);
/* 7650 */         setByte((byte)4, (EntityPlayer)Player, "jrmcTlmd");
/* 7651 */         int state = getByte((EntityPlayer)Player, "jrmcState");
/* 7652 */         if (state == 7 || state == 8 || state == 14) {
/* 7653 */           setByte(0, (EntityPlayer)Player, "jrmcState");
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 7658 */     return jrmcDam(Player, dbcA, s);
/*      */   }
/*      */   
/*      */   public static int jrmcDam(Entity Player, int dbcA, DamageSource s) {
/* 7662 */     if (!Player.field_70170_p.field_72995_K && 
/* 7663 */       Player instanceof EntityPlayer) {
/* 7664 */       EntityPlayer player = (EntityPlayer)Player;
/* 7665 */       boolean dse = (s != null && s.func_76346_g() != null && s.func_76346_g() instanceof EntityPlayer);
/* 7666 */       if (!player.field_71075_bZ.field_75098_d) {
/* 7667 */         ExtendedPlayer props = ExtendedPlayer.get(player);
/* 7668 */         boolean block = (props.getBlocking() == 1);
/* 7669 */         int[] PlyrAttrbts = PlyrAttrbts(player);
/* 7670 */         NBTTagCompound nbt = nbt((Entity)player, "pres");
/* 7671 */         byte state = nbt.func_74771_c("jrmcState");
/* 7672 */         byte state2 = nbt.func_74771_c("jrmcState2");
/* 7673 */         String sklx = getString(player, "jrmcSSltX");
/* 7674 */         int t = SklLvl(4, player);
/* 7675 */         byte race = nbt.func_74771_c("jrmcRace");
/* 7676 */         byte powerType = nbt.func_74771_c("jrmcPwrtyp");
/* 7677 */         byte classID = nbt.func_74771_c("jrmcClass");
/* 7678 */         byte release = getByte(player, "jrmcRelease");
/* 7679 */         int resrv = getInt(player, "jrmcArcRsrv");
/* 7680 */         String absorption = getString(player, "jrmcMajinAbsorptionData");
/* 7681 */         int currStamina = getInt(player, "jrmcStamina");
/* 7682 */         int currEnergy = getInt(player, "jrmcEnrgy");
/* 7683 */         String ste = getString(player, "jrmcStatusEff");
/* 7684 */         boolean mj = StusEfcts(12, ste);
/* 7685 */         boolean lg = StusEfcts(14, ste);
/* 7686 */         boolean mc = StusEfcts(13, ste);
/* 7687 */         boolean kk = StusEfcts(5, ste);
/* 7688 */         boolean mn = StusEfcts(19, ste);
/* 7689 */         boolean gd = StusEfcts(20, ste);
/*      */         
/* 7691 */         boolean lf = (s != null && s == DamageSource.field_76379_h);
/*      */         
/* 7693 */         int DEX = PlyrAttrbts[1];
/* 7694 */         int CON = PlyrAttrbts[2];
/* 7695 */         String[] ps = PlyrSkills(player);
/* 7696 */         double per = 1.0D;
/* 7697 */         int def = 0;
/* 7698 */         String x = getString(player, "jrmcStatusEff"); boolean c = (StusEfcts(10, x) || StusEfcts(11, x));
/* 7699 */         if (powerType != 3 && powerType > 0) {
/* 7700 */           DEX = getPlayerAttribute(player, PlyrAttrbts, 1, state, state2, race, sklx, release, resrv, lg, mj, kk, mc, mn, gd, powerType, ps, c, absorption);
/*      */         }
/*      */         
/* 7703 */         int kiProtection = 0;
/* 7704 */         int kiProtectionCost = 0;
/* 7705 */         boolean kiProtectOn = false;
/*      */         
/* 7707 */         if (pwr_ki(powerType)) {
/*      */ 
/*      */           
/* 7710 */           int maxCON = getPlayerAttribute(player, PlyrAttrbts, 2, state, state2, race, sklx, release, resrv, lg, mj, kk, mc, mn, gd, powerType, ps, c, absorption);
/*      */ 
/*      */           
/* 7713 */           per = ((maxCON > CON) ? maxCON : CON) / CON * 1.0D;
/* 7714 */           def = stat((Entity)player, 1, powerType, 1, DEX, race, classID, 0.0F);
/* 7715 */           int SPI = PlyrAttrbts[5];
/* 7716 */           int energyPool = stat((Entity)player, 5, powerType, 5, SPI, race, classID, SklLvl_KiBs(ps, powerType));
/* 7717 */           def = (int)(def * release * 0.01D * weightPerc(1, player));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7724 */           kiProtectOn = !PlyrSettingsB(player, 10);
/* 7725 */           int kiProtectLevel = SklLvl(11, ps);
/* 7726 */           if (kiProtectOn) {
/*      */ 
/*      */             
/* 7729 */             kiProtection = (int)(kiProtectLevel * 0.005D * energyPool * release * 0.01D);
/* 7730 */             if (kiProtection < 1) kiProtection = 1; 
/* 7731 */             kiProtection = (int)(kiProtection * DBCConfig.cnfKDd);
/*      */ 
/*      */             
/* 7734 */             float damage = dbcA / 3.0F / (dbcA + "").length(); if (damage < 1.0F) damage = 1.0F; 
/* 7735 */             kiProtectionCost = (int)(kiProtectLevel * release * 0.01D * damage);
/* 7736 */             if (kiProtectionCost < 1) kiProtectionCost = 1; 
/* 7737 */             kiProtectionCost = (int)(kiProtectionCost * DBCConfig.cnfKDc);
/*      */           } 
/*      */           
/* 7740 */           def += kiProtection;
/*      */         
/*      */         }
/* 7743 */         else if (pwr_cha(powerType)) {
/*      */           
/* 7745 */           int ta = SklLvl(0, 2, ps);
/* 7746 */           int cj = SklLvlY(2, getString(player, "jrmcSSltY"));
/* 7747 */           def = stat((Entity)player, 1, powerType, 1, DEX, race, classID, ta * 0.04F + state * 0.25F);
/* 7748 */           def = (int)((def * release) * 0.01D);
/* 7749 */           if (classID == 2) {
/* 7750 */             String StE = nbt.func_74779_i("jrmcStatusEff");
/* 7751 */             if (StusEfcts(16, StE)) {
/* 7752 */               int WIL = PlyrAttrbts[3];
/* 7753 */               int statWIL = stat((Entity)player, 3, powerType, 5, WIL, race, classID, 0.0F);
/* 7754 */               def += (int)(statWIL * 0.25D * release * 0.01D);
/*      */             }
/*      */           
/*      */           } 
/* 7758 */         } else if (pwr_sa(powerType)) {
/*      */           
/* 7760 */           def = 0;
/*      */         }
/*      */         else {
/*      */           
/* 7764 */           def = stat((Entity)player, 1, powerType, 1, DEX, race, classID, 0.0F);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 7769 */         int staminaCost = (int)((def - kiProtection) * 0.05F);
/*      */         
/* 7771 */         if (block && currStamina >= staminaCost) {
/*      */           
/* 7773 */           int id = (int)(Math.random() * 2.0D) + 1;
/* 7774 */           player.field_70170_p.func_72956_a((Entity)player, "jinryuudragonbc:DBC4.block" + id, 0.5F, 0.9F / (player.field_70170_p.field_73012_v.nextFloat() * 0.6F + 0.9F));
/*      */           
/* 7776 */           if (!isInCreativeMode((Entity)player)) setInt((currStamina - staminaCost < 0) ? 0 : (currStamina - staminaCost), player, "jrmcStamina");
/*      */         
/*      */         } else {
/*      */           
/* 7780 */           def = (int)(((def - kiProtection) * JRMCoreConfig.StatPasDef) * 0.01F) + kiProtection;
/*      */         } 
/*      */ 
/*      */         
/* 7784 */         if (currEnergy >= kiProtectionCost) {
/*      */           
/* 7786 */           if (!isInCreativeMode((Entity)player)) setInt((currEnergy - kiProtectionCost < 0) ? 0 : (currEnergy - kiProtectionCost), player, "jrmcEnrgy");
/*      */         
/*      */         } else {
/*      */           
/* 7790 */           def -= kiProtection;
/*      */         } 
/*      */         
/* 7793 */         if (JRMCoreConfig.DebugInfo || (difp.length() > 0 && player.func_70005_c_().equalsIgnoreCase(difp))) {
/* 7794 */           mod_JRMCore.logger.info(player.func_70005_c_() + " receives Damage: Original=" + dbcA);
/*      */         }
/* 7796 */         int defensePenetration = 0;
/* 7797 */         if (s != null && dse) {
/*      */           
/* 7799 */           String[] ops = PlyrSkills((EntityPlayer)s.func_76346_g());
/* 7800 */           defensePenetration = SklLvl(14, 1, ops);
/*      */         }
/* 7802 */         else if (s != null && s.func_76346_g() instanceof EntityLivingBase) {
/*      */           
/* 7804 */           defensePenetration = 10;
/*      */         } 
/*      */         
/* 7807 */         int dbcAO = dbcA;
/* 7808 */         int defense = lf ? 0 : def;
/* 7809 */         int defensePen2 = (int)((defense * defensePenetration) * 0.01F);
/* 7810 */         double e = (1.0F - 0.03F * t);
/* 7811 */         String ss = "A=" + defense + ((defensePen2 > 0) ? ("-" + defensePenetration + "%") : "") + ", SEM=" + (1.0F - 0.03F * t);
/* 7812 */         dbcA = (int)((dbcA - defense - defensePen2) * e);
/*      */ 
/*      */         
/* 7815 */         dbcA = (dbcA < 1) ? 1 : dbcA;
/* 7816 */         if (((dbcAO * defensePenetration) * 0.01F) * e > dbcA) dbcA = (int)(((dbcAO * defensePenetration) * 0.01F) * e);
/*      */         
/* 7818 */         dbcA = (int)(dbcA / per);
/*      */ 
/*      */         
/* 7821 */         if (JRMCoreConfig.DebugInfo || (difp.length() > 0 && player.func_70005_c_().equalsIgnoreCase(difp))) {
/* 7822 */           mod_JRMCore.logger.info(player.func_70005_c_() + " DM: A=" + dbcA + ", DF Div:" + per + ", " + ss);
/*      */         }
/* 7824 */         if (DBC()) {
/*      */           
/* 7826 */           ItemStack stackbody = (ExtendedPlayer.get(player)).inventory.func_70301_a(1);
/* 7827 */           ItemStack stackhead = (ExtendedPlayer.get(player)).inventory.func_70301_a(2);
/*      */ 
/*      */           
/* 7830 */           if (stackbody != null) stackbody.func_77972_a(1, (EntityLivingBase)player); 
/* 7831 */           if (stackhead != null) stackhead.func_77972_a(1, (EntityLivingBase)player);
/*      */         
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 7837 */         int curBody = getInt(player, "jrmcBdy");
/* 7838 */         int all = curBody - dbcA;
/* 7839 */         int set = (all < 0) ? 0 : all;
/* 7840 */         if (dse) {
/* 7841 */           boolean friendlyFist = PlyrSettingsB((EntityPlayer)s.func_76346_g(), 12);
/* 7842 */           if (friendlyFist && !s.func_76355_l().equals("MajinAbsorption"))
/*      */           {
/*      */             
/* 7845 */             if (!s.func_76346_g().equals(Player)) {
/* 7846 */               int ko = getInt(player, "jrmcHar4va");
/* 7847 */               set = (all < 20) ? 20 : all;
/* 7848 */               if (ko <= 0 && set == 20) {
/* 7849 */                 setInt(6, player, "jrmcHar4va");
/* 7850 */                 setByte((race == 4) ? ((state < 4) ? state : 4) : 0, player, "jrmcState");
/* 7851 */                 setByte(0, player, "jrmcState2");
/* 7852 */                 setByte(0, player, "jrmcRelease");
/* 7853 */                 setInt(0, player, "jrmcStamina");
/* 7854 */                 StusEfcts(19, ste, player, false);
/*      */               } 
/* 7856 */               dbcA -= all;
/*      */             } 
/*      */           }
/*      */         } 
/* 7860 */         if (!isInCreativeMode((Entity)player)) setInt(set, player, "jrmcBdy");
/*      */       
/*      */       } 
/*      */     } 
/* 7864 */     return dbcA;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7870 */   public static String difp = "";
/*      */   
/*      */   public static final int TP_GAIN_MODE = -1;
/*      */   
/*      */   public static void jrmcExp(Entity shootingEntity, int e) {
/* 7875 */     jrmcExp(shootingEntity, e, -1);
/*      */   }
/*      */   
/*      */   public static void jrmcExp(Entity shootingEntity, int e, int expGainMode) {
/* 7879 */     if (shootingEntity != null && !shootingEntity.field_70170_p.field_72995_K && shootingEntity instanceof EntityPlayer) {
/*      */       
/* 7881 */       EntityPlayer player = (EntityPlayer)shootingEntity;
/* 7882 */       Random rand = new Random();
/* 7883 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 7884 */       int groundID = getInt(player, "JRMCGID");
/*      */       
/* 7886 */       if (server.func_71213_z() != null && (server.func_71213_z()).length > 0) {
/*      */ 
/*      */         
/* 7889 */         int membersCount = 0;
/* 7890 */         for (int pl = 0; pl < (server.func_71213_z()).length; pl++) {
/*      */           
/* 7892 */           EntityPlayerMP en = getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 7893 */           int egid = getInt((EntityPlayer)en, "JRMCGID");
/* 7894 */           if (egid == groundID)
/*      */           {
/* 7896 */             membersCount++;
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/* 7901 */         JGPlayerMP jgPlayer = new JGPlayerMP(player);
/* 7902 */         jgPlayer.connectBaseNBT();
/* 7903 */         int race = jgPlayer.getRace();
/*      */         
/* 7905 */         int tpGain = (expGainMode == -1) ? JRMCoreConfig.tpgn : JRMCoreConfig.getTPGainEnergy(expGainMode);
/* 7906 */         tpGain = (int)(tpGain * JRMCoreConfig.TPGainRace[race]);
/*      */ 
/*      */         
/* 7909 */         if (membersCount > 0 && e >= membersCount && groundID != 0) {
/*      */           
/* 7911 */           int ei = e / membersCount;
/* 7912 */           for (int i = 0; i < (server.func_71213_z()).length; i++) {
/*      */             
/* 7914 */             EntityPlayerMP en = getPlayerForUsername(server, server.func_71213_z()[i]);
/* 7915 */             int egid = getInt((EntityPlayer)en, "JRMCGID");
/* 7916 */             String elid = getString((EntityPlayer)en, "JRMCGLIDs");
/* 7917 */             if (egid == groundID)
/*      */             {
/* 7919 */               int release = getByte((EntityPlayer)en, "jrmcRelease");
/* 7920 */               if (release >= 5)
/*      */               {
/* 7922 */                 int rc = getByte((EntityPlayer)en, "jrmcRace");
/* 7923 */                 int st = getByte((EntityPlayer)en, "jrmcState");
/* 7924 */                 int tp = getInt((EntityPlayer)en, "jrmcTpint");
/* 7925 */                 byte d = getByte((EntityPlayer)en, "jrmcDiff");
/* 7926 */                 int t = expgnrt(rc, st, d, (EntityPlayer)en);
/* 7927 */                 t = (int)(t - membersCount * 2.0F);
/* 7928 */                 int randomInt = rand.nextInt(100);
/* 7929 */                 if (randomInt < t) {
/*      */                   
/* 7931 */                   int result = tp + tpGain * e;
/* 7932 */                   if (result > getMaxTP()) result = getMaxTP(); 
/* 7933 */                   setInt(result, (EntityPlayer)en, "jrmcTpint");
/*      */                 } 
/* 7935 */                 if (elid.equalsIgnoreCase(en.func_70005_c_()));
/*      */               }
/*      */             
/*      */             }
/*      */           
/*      */           } 
/*      */         } else {
/*      */           
/* 7943 */           int release = getByte(player, "jrmcRelease");
/* 7944 */           if (release >= 5) {
/*      */             
/* 7946 */             int rc = getByte(player, "jrmcRace");
/* 7947 */             int st = getByte(player, "jrmcState");
/* 7948 */             int tp = getInt(player, "jrmcTpint");
/* 7949 */             byte d = getByte(player, "jrmcDiff");
/* 7950 */             int t = expgnrt(rc, st, d, player);
/* 7951 */             int randomInt = rand.nextInt(100);
/* 7952 */             if (randomInt < t) {
/*      */               
/* 7954 */               int result = tp + tpGain * e;
/* 7955 */               if (result > getMaxTP()) result = getMaxTP(); 
/* 7956 */               setInt(result, player, "jrmcTpint");
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static int expgnrt(int rc, int st, int d, EntityPlayer p) {
/* 7965 */     float w = 1.0F;
/*      */     
/* 7967 */     if (DBC()) {
/* 7968 */       Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 7969 */       if (side == Side.SERVER) {
/* 7970 */         float lastGravity = getFloat(p, "jrmcGravForce");
/* 7971 */         lastGravity = JRMCoreHDBC.gravity(p, lastGravity);
/* 7972 */         int[] PlyrAttrbts = PlyrAttrbts(p);
/* 7973 */         float IWeight = weightExtra(PlyrAttrbts, lastGravity, p);
/* 7974 */         w = weightPerc(PlyrAttrbts, 1, IWeight, p);
/*      */       } else {
/* 7976 */         boolean c = (StusEfctsMe(10) || StusEfctsMe(11));
/* 7977 */         w = weightPerc(JRMCoreH.PlyrAttrbts, 1, WeightOn, c);
/*      */       } 
/*      */     } 
/* 7980 */     int rt = ((rc == 0 || rc == 3) ? 25 : ((rc == 4 && st < 4) ? ((st + 1) * 4) : 20)) + d * 5;
/* 7981 */     return (int)(rt + 32.0F * (1.0F - w) * 0.5F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String techSnds(int t, int st, int sn) {
/* 7987 */     String s = "";
/*      */     try {
/* 7989 */       if (t == 0 || t == 1 || t == 5 || t == 4 || t == 6 || t == 7 || t == 8) {
/* 7990 */         if (st == 0) s = "DBC4." + techSndIncBeam[sn]; 
/* 7991 */         if (st == 1) s = "DBC4." + techSndFireBeam[sn]; 
/* 7992 */         if (st == 2) s = "DBC4." + techSndMoveBeam[sn]; 
/* 7993 */       }  if (t == 2) {
/* 7994 */         if (st == 0) s = "DBC4." + techSndIncDisk[sn]; 
/* 7995 */         if (st == 1) s = "DBC4." + techSndFireDisk[sn]; 
/* 7996 */         if (st == 2) s = "DBC4." + techSndMoveDisk[sn]; 
/* 7997 */       }  if (t == 3)
/*      */       {
/* 7999 */         if (st == 1) s = "DBC4." + techSndFireLeser[sn];
/*      */       
/*      */       }
/* 8002 */       if (t == 10) {
/* 8003 */         if (st == 0 && sn >= 0) s = techSndPMInc[sn]; 
/* 8004 */         if (st == 1 && sn >= 0) s = techSndPMFire[sn]; 
/* 8005 */         if (st == 2 && sn >= 0) s = techSndPMMove[sn]; 
/* 8006 */         if (st == 3 && sn >= 0) s = techSndPMIncFire[sn]; 
/*      */       } 
/* 8008 */     } catch (Exception e) {
/* 8009 */       if (t == 0 || t == 1 || t == 5 || t == 4 || t == 6 || t == 7 || t == 8) {
/* 8010 */         if (st == 0) s = "DBC4." + techSndIncBeam[0]; 
/* 8011 */         if (st == 1) s = "DBC4." + techSndFireBeam[0]; 
/* 8012 */         if (st == 2) s = "DBC4." + techSndMoveBeam[0]; 
/* 8013 */       }  if (t == 2) {
/* 8014 */         if (st == 0) s = "DBC4." + techSndIncDisk[0]; 
/* 8015 */         if (st == 1) s = "DBC4." + techSndFireDisk[0]; 
/* 8016 */         if (st == 2) s = "DBC4." + techSndMoveDisk[0]; 
/* 8017 */       }  if (t == 3)
/*      */       {
/* 8019 */         if (st == 1) s = "DBC4." + techSndFireLeser[0];
/*      */       
/*      */       }
/* 8022 */       if (t == 10) {
/* 8023 */         if (st == 0 && sn >= 0) s = techSndPMInc[0]; 
/* 8024 */         if (st == 1 && sn >= 0) s = techSndPMFire[0]; 
/* 8025 */         if (st == 2 && sn >= 0) s = techSndPMMove[0]; 
/* 8026 */         if (st == 3 && sn >= 0) s = techSndPMIncFire[0]; 
/*      */       } 
/*      */     } 
/* 8029 */     return s;
/*      */   }
/*      */   
/*      */   public static void KAsounds(Entity m, int selc) {
/* 8033 */     PD.sendToServer((IMessage)new DBCPduo(selc + 1, m.func_145782_y()));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void quad(int i, int j, int k, int l) {
/* 8038 */     PD.sendToServer((IMessage)new JRMCorePQuad(i, j, k, l));
/*      */   }
/*      */   public static void quadI(int i, int j, int k, int l) {
/* 8041 */     PD.sendToServer((IMessage)new JRMCorePQuadI((byte)i, j, k, l));
/*      */   }
/*      */ 
/*      */   
/*      */   public static String numSep(long c2, char s) {
/* 8046 */     DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
/* 8047 */     symbols.setGroupingSeparator(s);
/* 8048 */     DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
/* 8049 */     return formatter.format(c2);
/*      */   }
/*      */   
/*      */   public static String numSep(long c2) {
/* 8053 */     return numSep(c2, ',');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8061 */   private static final String[] NAMES = new String[] { "Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Quintillion", "Sextillion", "Septillion", "Octillion", "Nonillion", "Decillion", "Undecillion", "Duodecillion", "Tredecillion", "Quattuordecillion", "Quindecillion", "Sexdecillion", "Septendecillion", "Octodecillion", "Novemdecillion", "Vigintillion" };
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
/* 8085 */   private static final BigInteger THOUSAND = BigInteger.valueOf(1000L);
/*      */ 
/*      */ 
/*      */   
/* 8089 */   private static final NavigableMap<BigInteger, String> MAP = new TreeMap<BigInteger, String>(); static {
/* 8090 */     for (int i = 0; i < NAMES.length; i++)
/*      */     {
/* 8092 */       MAP.put(THOUSAND.pow(i + 1), NAMES[i]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static String createString(BigInteger number) {
/* 8098 */     Map.Entry<BigInteger, String> entry = MAP.floorEntry(number);
/* 8099 */     if (entry == null)
/*      */     {
/* 8101 */       return "Nearly nothing";
/*      */     }
/* 8103 */     BigInteger key = entry.getKey();
/* 8104 */     BigInteger d = key.divide(THOUSAND);
/* 8105 */     BigInteger m = number.divide(d);
/* 8106 */     float f = m.floatValue() / 1000.0F;
/* 8107 */     float rounded = (int)(f * 100.0D) / 100.0F;
/* 8108 */     if (rounded % 1.0F == 0.0F)
/*      */     {
/* 8110 */       return (int)rounded + " " + (String)entry.getValue();
/*      */     }
/* 8112 */     return rounded + " " + (String)entry.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void test(String numberString, String string) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public static String numSepShort(long c2) {
/* 8123 */     if (c2 > 100000000L) {
/* 8124 */       BigInteger n = new BigInteger(c2 + "");
/* 8125 */       return createString(n);
/*      */     } 
/* 8127 */     return numSep(c2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String numSepShort2(long c2) {
/* 8132 */     return String.format("%,8d", new Object[] { Long.valueOf(c2) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int txt(String s, String c, int i, boolean b, int l, int t, int c2) {
/* 8143 */     return txt(s, c, i, b, l, t, c2, 0, 0);
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
/*      */   public static int txt(String s, String c, int i, boolean b, int l, int t, int c2, int c3, int c4) {
/* 8155 */     if (c2 == 0) c2 = 245; 
/* 8156 */     s = s.replaceAll("/n", "\n");
/* 8157 */     FontRenderer var8 = JRMCoreClient.mc.field_71466_p;
/* 8158 */     List lt = var8.func_78271_c(s, c2);
/* 8159 */     Iterator<String> iterator = lt.iterator();
/* 8160 */     int i2 = 0;
/* 8161 */     int i3 = 0;
/* 8162 */     int j = 10;
/* 8163 */     while (iterator.hasNext()) {
/*      */       
/* 8165 */       String s1 = iterator.next();
/* 8166 */       if (b && c3 <= i2 && lt.size() - c4 > i2) {
/* 8167 */         if (i != 0 && i2 == 0) i3 = i; 
/* 8168 */         var8.func_78276_b(c + s1, l, t + i2 * j + i3, 0);
/*      */       } 
/* 8170 */       i2++;
/*      */     } 
/* 8172 */     i2 = (int)(i2 + round(i * 0.1F, 0));
/* 8173 */     return i2;
/*      */   }
/*      */   public static int txtH(String s, String c, int i, boolean b, int l, int t, int c2, List n) {
/* 8176 */     return txtH(s, c, i, b, l, t, c2, 0, 0, n);
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
/*      */   public static int txtH(String s, String c, int i, boolean b, int l, int t, int c2, int c3, int c4, List<JRMCoreGuiButtons01> n) {
/* 8188 */     if (c2 == 0) c2 = 245; 
/* 8189 */     s = s.replaceAll("/n", "\n");
/* 8190 */     FontRenderer var8 = JRMCoreClient.mc.field_71466_p;
/* 8191 */     List lt = var8.func_78271_c(s, c2);
/* 8192 */     Iterator<String> iterator = lt.iterator();
/* 8193 */     int i2 = 0;
/* 8194 */     int i3 = 0;
/* 8195 */     int j = 10;
/* 8196 */     while (iterator.hasNext()) {
/*      */       
/* 8198 */       String s1 = iterator.next();
/* 8199 */       if (b && c3 <= i2 && c4 > i2) {
/* 8200 */         if (i != 0 && i2 == 0) i3 = i; 
/* 8201 */         Matcher matcher = JRMCoreHC.paturl.matcher(s1);
/* 8202 */         if (matcher.find()) {
/* 8203 */           int matchStart = matcher.start(1);
/* 8204 */           int matchEnd = matcher.end();
/*      */           
/* 8206 */           JRMCoreGuiScreen.urlToOpen = matcher.group();
/* 8207 */           String j2 = s1; int jw = var8.func_78256_a(j2);
/*      */           
/* 8209 */           n.add(new JRMCoreGuiButtons01(198, l, t + i2 * j + i3, jw, j2, techCol[1]));
/*      */         } 
/* 8211 */         var8.func_78276_b(c + s1, l, t + i2 * j + i3, 0);
/*      */       } 
/* 8213 */       i2++;
/*      */     } 
/* 8215 */     i2 = (int)(i2 + round(i * 0.1F, 0));
/* 8216 */     return i2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void tpalgn(EntityPlayer Player, int tp, int algn) {
/* 8221 */     MinecraftServer server1 = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 8222 */     int gid = getInt(Player, "JRMCGID");
/* 8223 */     int saga = getInt(Player, "DBCSagaSys");
/* 8224 */     if (gid == 0) {
/* 8225 */       setByte(algn, Player, "jrmcAlign");
/* 8226 */       int tp1 = getInt(Player, "jrmcTpint") + tp;
/* 8227 */       setInt((tp1 > getMaxTP()) ? getMaxTP() : tp1, Player, "jrmcTpint");
/* 8228 */     } else if (server1.func_71213_z() != null && (server1.func_71213_z()).length > 0) {
/* 8229 */       int i = 0; int pl;
/* 8230 */       for (pl = 0; pl < (server1.func_71213_z()).length; pl++) {
/* 8231 */         EntityPlayerMP en = getPlayerForUsername(server1, server1.func_71213_z()[pl]);
/* 8232 */         int egid = getInt((EntityPlayer)en, "JRMCGID");
/* 8233 */         int esaga = getInt((EntityPlayer)en, "DBCSagaSys");
/* 8234 */         if (egid == gid && saga == esaga) {
/* 8235 */           i++;
/* 8236 */           int a = getByte((EntityPlayer)en, "jrmcAlign");
/* 8237 */           if (algn > a) setByte((a + 5 > 100) ? 100 : (a + 5), (EntityPlayer)en, "jrmcAlign"); 
/* 8238 */           if (algn < a) setByte((a - 5 < 0) ? 0 : (a - 5), (EntityPlayer)en, "jrmcAlign"); 
/* 8239 */           if (algn == a) setByte(a, (EntityPlayer)en, "jrmcAlign"); 
/*      */         } 
/*      */       } 
/* 8242 */       tp = (tp / i == 0) ? 1 : (tp / i);
/* 8243 */       for (pl = 0; pl < (server1.func_71213_z()).length; pl++) {
/* 8244 */         EntityPlayerMP en = getPlayerForUsername(server1, server1.func_71213_z()[pl]);
/* 8245 */         int egid = getInt((EntityPlayer)en, "JRMCGID");
/* 8246 */         int esaga = getInt((EntityPlayer)en, "DBCSagaSys");
/* 8247 */         if (egid == gid && saga == esaga) {
/* 8248 */           int tp1 = getInt((EntityPlayer)en, "jrmcTpint") + tp;
/* 8249 */           setInt((tp1 > getMaxTP()) ? getMaxTP() : tp1, (EntityPlayer)en, "jrmcTpint");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static int ctb(int num, int b) {
/* 8256 */     int iResult = num % b;
/* 8257 */     int iMultiplier = 10;
/* 8258 */     while ((num /= b) > 0) {
/* 8259 */       iResult = num % b * iMultiplier + iResult;
/* 8260 */       iMultiplier *= 10;
/*      */     } 
/* 8262 */     return iResult;
/*      */   }
/*      */   public static int cfb(int s, int b) {
/* 8265 */     int i = 0;
/* 8266 */     int s2 = 0;
/* 8267 */     while (s2 != s) {
/* 8268 */       s2 = ctb(i, b);
/* 8269 */       i++;
/*      */     } 
/* 8271 */     return i - 1;
/*      */   }
/*      */   
/* 8274 */   public static String[] ltnb = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }; public static int letToNum(String s1, String s2) { int i1;
/*      */     int i2;
/*      */     int f;
/* 8277 */     for (i1 = 0, i2 = 0, i = 0, f = 0; f < ltnb.length; ) { if (s1.equals(ltnb[f])) i1 = f;  if (s2.equals(ltnb[f])) i2 = f;  f++; }  return i1 * ltnb.length + i2; }
/*      */   
/*      */   public static String numToLet(int i) {
/* 8280 */     s = "00"; String s1 = "", s2 = ""; int i1 = i / ltnb.length, i2 = i1 * ltnb.length, i3 = i - i2;
/* 8281 */     for (int f = 0; f < ltnb.length; ) { if (i1 == f) s1 = ltnb[f];  if (i3 == f) s2 = ltnb[f];  f++; }  return s1 + s2;
/*      */   }
/*      */   public static int letToNum5(String s1, String s2, String s3, String s4, String s5) {
/* 8284 */     int i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i = 0;
/* 8285 */     for (int f = 0; f < ltnb.length; f++) {
/* 8286 */       if (s1.equals(ltnb[f])) i1 = f; 
/* 8287 */       if (s2.equals(ltnb[f])) i2 = f; 
/* 8288 */       if (s3.equals(ltnb[f])) i3 = f; 
/* 8289 */       if (s4.equals(ltnb[f])) i4 = f; 
/* 8290 */       if (s5.equals(ltnb[f])) i5 = f; 
/*      */     } 
/* 8292 */     i = (((i1 * ltnb.length + i2) * ltnb.length + i3) * ltnb.length + i4) * ltnb.length + i5;
/* 8293 */     return i;
/*      */   }
/*      */   public static String numToLet5(int i) {
/* 8296 */     String s = "00", s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
/* 8297 */     int i11 = i / ltnb.length;
/* 8298 */     int i12 = i11 * ltnb.length;
/* 8299 */     int i13 = i - i12;
/* 8300 */     int i21 = i11 / ltnb.length;
/* 8301 */     int i22 = i21 * ltnb.length;
/* 8302 */     int i23 = i11 - i22;
/* 8303 */     int i31 = i21 / ltnb.length;
/* 8304 */     int i32 = i31 * ltnb.length;
/* 8305 */     int i33 = i21 - i32;
/* 8306 */     int i41 = i31 / ltnb.length;
/* 8307 */     int i42 = i41 * ltnb.length;
/* 8308 */     int i43 = i31 - i42;
/* 8309 */     for (int f = 0; f < ltnb.length; f++) {
/* 8310 */       if (i41 == f) s1 = ltnb[f]; 
/* 8311 */       if (i43 == f) s2 = ltnb[f]; 
/* 8312 */       if (i33 == f) s3 = ltnb[f]; 
/* 8313 */       if (i23 == f) s4 = ltnb[f]; 
/* 8314 */       if (i13 == f) s5 = ltnb[f]; 
/*      */     } 
/* 8316 */     s = s1 + s2 + s3 + s4 + s5;
/* 8317 */     return s;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isn(String i) {
/* 8322 */     return i.matches(".*\\d+.*");
/*      */   }
/*      */   
/*      */   public static boolean smnmlt(String i) {
/* 8326 */     return (i.replaceAll("\\D+", "").length() == i.replaceAll("\\d", "").length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void wld(String stringValue, String nbtID, String fileName, boolean delete) {
/*      */     try {
/* 8335 */       File file = new File(JRMCore.configDir, fileName);
/* 8336 */       NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 8337 */       if (!file.exists()) {
/* 8338 */         file.createNewFile();
/*      */       } else {
/* 8340 */         nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
/*      */       } 
/* 8342 */       if (delete) {
/* 8343 */         nbttagcompound.func_82580_o(nbtID);
/*      */       } else {
/* 8345 */         nbttagcompound.func_74778_a(nbtID, stringValue);
/*      */       } 
/* 8347 */       CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
/*      */     }
/* 8349 */     catch (Exception exception) {
/*      */       
/* 8351 */       exception.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rld(String id, String f) {
/* 8358 */     String d = "";
/* 8359 */     File file = new File(JRMCore.configDir, f);
/*      */     try {
/* 8361 */       if (!file.exists()) {
/*      */         
/* 8363 */         file.createNewFile();
/* 8364 */         NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 8365 */         CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
/*      */       } 
/* 8367 */     } catch (IOException e) {
/* 8368 */       e.printStackTrace();
/*      */     } finally {
/*      */       try {
/* 8371 */         NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
/* 8372 */         if (nbttagcompound.func_74764_b(id)) {
/* 8373 */           d = nbttagcompound.func_74779_i(id);
/*      */         } else {
/* 8375 */           d = "0";
/*      */         } 
/* 8377 */       } catch (IOException e) {
/* 8378 */         e.printStackTrace();
/*      */       } 
/*      */     } 
/* 8381 */     return d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void wd(MinecraftServer server, String d, String id, String fd, String f, boolean b) {
/*      */     try {
/* 8390 */       File file = new File(server.func_71218_a(0).getChunkSaveLocation() + fd, f);
/* 8391 */       NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 8392 */       if (!file.exists()) {
/* 8393 */         file.createNewFile();
/*      */       } else {
/* 8395 */         nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
/*      */       } 
/* 8397 */       if (b) {
/* 8398 */         nbttagcompound.func_82580_o(id);
/*      */       } else {
/* 8400 */         nbttagcompound.func_74778_a(id, d);
/*      */       } 
/* 8402 */       CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
/*      */     }
/* 8404 */     catch (Exception exception) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void wd(MinecraftServer server, String fd, String f) {
/*      */     try {
/* 8415 */       File file = new File(server.func_71218_a(0).getChunkSaveLocation() + fd, f);
/* 8416 */       NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 8417 */       if (!file.exists()) {
/* 8418 */         file.createNewFile();
/*      */       }
/* 8420 */       CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
/*      */     }
/* 8422 */     catch (Exception exception) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rd(MinecraftServer server, String id, String fd, String f) {
/* 8432 */     String d = "";
/* 8433 */     if (server != null && server.field_71305_c.length > 0 && server
/*      */       
/* 8435 */       .func_71218_a(0) != null && server
/* 8436 */       .func_71218_a(0).getChunkSaveLocation() != null) {
/* 8437 */       File file = new File(server.func_71218_a(0).getChunkSaveLocation() + fd, f);
/*      */       
/* 8439 */       try { if (!file.exists()) {
/* 8440 */           file.createNewFile();
/* 8441 */           NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 8442 */           CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
/*      */         }  }
/* 8444 */       catch (IOException iOException)
/*      */       
/*      */       { 
/*      */         try {
/*      */           
/* 8449 */           NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
/* 8450 */           if (nbttagcompound.func_74764_b(id)) {
/* 8451 */             d = nbttagcompound.func_74779_i(id);
/*      */           } else {
/* 8453 */             d = "0";
/*      */           } 
/* 8455 */         } catch (IOException iOException1) {} } finally { try { NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file)); if (nbttagcompound.func_74764_b(id)) { d = nbttagcompound.func_74779_i(id); } else { d = "0"; }  } catch (IOException iOException) {} }
/*      */     
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 8461 */     return d;
/*      */   }
/*      */ 
/*      */   
/* 8465 */   public static String cldb = "§1";
/* 8466 */   public static String cldg = "§2";
/* 8467 */   public static String cla = "§3";
/* 8468 */   public static String cldr = "§4";
/* 8469 */   public static String cldp = "§5";
/* 8470 */   public static String clgd = "§6";
/* 8471 */   public static String clgy = "§7";
/* 8472 */   public static String cldgy = "§8";
/* 8473 */   public static String clbe = "§9";
/* 8474 */   public static String clb = "§0";
/* 8475 */   public static String cllg = "§a";
/* 8476 */   public static String cllb = "§b";
/* 8477 */   public static String cllr = "§c";
/* 8478 */   public static String clpr = "§d";
/* 8479 */   public static String cly = "§e";
/* 8480 */   public static String clw = "§f";
/*      */   
/* 8482 */   public static final ChatStyle CHAT_STYLE_YELLOW = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW); public static double explosionX; public static double explosionY; public static double explosionZ;
/*      */   public static float explosionSize;
/*      */   public static List chunkPositionRecords;
/*      */   private static float playerVelocityX;
/*      */   private static float playerVelocityY;
/*      */   private static float playerVelocityZ;
/*      */   public static double expDam;
/*      */   public static Entity origin1;
/*      */   public static byte extype;
/*      */   
/*      */   public static int lbs(String[] s, int i, FontRenderer fr, int gl, int gt) {
/* 8493 */     return lbs(s, i, fr, gl, gt, 245, "§0");
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
/*      */   public static int lbs(String[] s, int i, FontRenderer fr, int gl, int gt, int w, String c) {
/* 8505 */     for (int i1 = 0; i1 < s.length; i1++) {
/*      */       
/* 8507 */       Iterator<String> iterator = fr.func_78271_c(s[i1], 245).iterator();
/* 8508 */       while (iterator.hasNext()) {
/*      */         
/* 8510 */         String s1 = iterator.next();
/* 8511 */         fr.func_78276_b(c + s1, gl + 6, gt + 5 + i * 10, 0);
/* 8512 */         i++;
/*      */       } 
/*      */     } 
/* 8515 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ExplosionJRMC newExpl(World worldObj, Entity entity, double par2, double par4, double par6, float par8, boolean par9, double dam, Entity origin, byte type) {
/* 8522 */     ExplosionJRMC var10 = new ExplosionJRMC(worldObj, entity, par2, par4, par6, par8, JRMCoreConfig.expGriOff, dam, origin, type);
/* 8523 */     var10.field_77286_a = par9;
/*      */     
/* 8525 */     var10.func_77278_a();
/* 8526 */     var10.func_77279_a(true);
/* 8527 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 8528 */     if (side == Side.SERVER) {
/*      */       
/* 8530 */       Iterator<EntityPlayer> var12 = worldObj.field_73010_i.iterator();
/*      */       
/* 8532 */       while (var12.hasNext()) {
/* 8533 */         EntityPlayer var13 = var12.next();
/*      */         
/* 8535 */         if (var13.func_70092_e(par2, par4, par6) < 4096.0D)
/*      */         {
/* 8537 */           expCliPack((Entity)var13, par2, par4, par6, par8, var10.field_77281_g, (Vec3)var10.func_77277_b().get(var13), JRMCoreConfig.expGriOff, dam, origin, type);
/*      */         }
/*      */       } 
/*      */     } 
/* 8541 */     return var10;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int F5CsTH(String l) {
/*      */     String w;
/*      */     int a;
/*      */     int i;
/* 8553 */     for (w = "0123456789ABCDEF", l = l.toUpperCase(), a = 0, i = 0; i < l.length(); ) { char c = l.charAt(i); int d = w.indexOf(c); a = 16 * a + d; i++; }  return a;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int rtXq4V(boolean n) {
/* 8558 */     return checkLimit();
/*      */   } public static int checkLimit() {
/* 8560 */     int b = JRMCoreConfig.tmx;
/* 8561 */     String r = "64";
/* 8562 */     String k = "3B9ACA00";
/* 8563 */     return (b > F5CsTH(k)) ? F5CsTH(k) : ((b < F5CsTH(r)) ? 0 : b);
/*      */   } public static int etXq4V(int b) {
/* 8565 */     String k = "3B9ACA00"; return (b > F5CsTH(k)) ? F5CsTH(k) : b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void expCliPack(Entity player, double par1, double par3, double par5, float par7, List<?> par8List, Vec3 par9Vec3, boolean expGriOff, double dam, Entity origin, byte type) {
/* 8572 */     explosionX = par1;
/* 8573 */     explosionY = par3;
/* 8574 */     explosionZ = par5;
/* 8575 */     explosionSize = par7;
/* 8576 */     JRMCoreConfig.expGriOff = expGriOff;
/* 8577 */     expDam = dam;
/* 8578 */     origin1 = origin;
/* 8579 */     chunkPositionRecords = new ArrayList(par8List);
/*      */     
/* 8581 */     if (par9Vec3 != null) {
/*      */       
/* 8583 */       playerVelocityX = 0.0F;
/* 8584 */       playerVelocityY = 0.0F;
/* 8585 */       playerVelocityZ = 0.0F;
/*      */     } 
/* 8587 */     extype = type;
/* 8588 */     if (player != null && origin != null) {
/* 8589 */       PD.sendToDimension((IMessage)new JRMCorePExpl(explosionX, explosionY, explosionZ, explosionSize, JRMCoreConfig.expGriOff, expDam, origin, chunkPositionRecords, playerVelocityX, playerVelocityY, playerVelocityZ, type), origin.field_71093_bK);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trlai(String s1, String s2) {
/* 8596 */     s1 = modAssetIDs.get(s1);
/* 8597 */     return s1 + s2;
/*      */   }
/*      */   
/*      */   public static String trlai(String s1) {
/* 8601 */     return s1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trlws(String s1, String s2) {
/* 8607 */     s1 = modAssetIDs.get(s1);
/* 8608 */     return trl(s1 + s2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String trl(String s1, String s2) {
/* 8613 */     s1 = modAssetIDs.get(s1);
/* 8614 */     return trl(s1 + s2);
/*      */   }
/*      */   
/*      */   public static String trl(String s1) {
/* 8618 */     return StatCollector.func_74838_a(s1);
/*      */   }
/*      */   
/*      */   public static String trl(String s1, String s2, Object... args) {
/* 8622 */     return cct(trl(s1, s2), args);
/*      */   }
/*      */   public static String trl(String s1, Object... args) {
/* 8625 */     return cct(trl(s1), args);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String cct(String s1, Object... args) {
/* 8630 */     return (new ChatComponentTranslation(s1, args)).func_150260_c();
/*      */   }
/*      */ 
/*      */   
/*      */   public static EntityPlayerMP getPlayerForUsername(MinecraftServer server, String s) {
/* 8635 */     return server.func_71203_ab().func_152612_a(s);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Item getItemByText(String p_147179_1_) {
/* 8640 */     Item item = (Item)Item.field_150901_e.func_82594_a(p_147179_1_);
/* 8641 */     if (item == null) {
/*      */       
/*      */       try {
/*      */         
/* 8645 */         Item item1 = Item.func_150899_d(Integer.parseInt(p_147179_1_));
/*      */         
/* 8647 */         if (item1 != null) {
/*      */           
/* 8649 */           ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation("commands.generic.deprecatedId", new Object[] { Item.field_150901_e.func_148750_c(item1) });
/* 8650 */           chatcomponenttranslation.func_150256_b().func_150238_a(EnumChatFormatting.GRAY);
/*      */         } 
/*      */         
/* 8653 */         item = item1;
/*      */       }
/* 8655 */       catch (NumberFormatException numberFormatException) {}
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
/* 8666 */     return item;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int d(String s, int i) {
/* 8671 */     return (i == 3) ? ltn5(sa(s, 6), sa(s, 7), sa(s, 8), sa(s, 9), sa(s, 10)) : ltn(sa(s, (i == 0) ? 0 : ((i == 1) ? 2 : ((i == 2) ? 4 : 11))), sa(s, (i == 0) ? 1 : ((i == 1) ? 3 : ((i == 2) ? 5 : 12))));
/*      */   } public static String sa(String s1, int s2) {
/* 8673 */     return s1.charAt(s2) + "";
/*      */   }
/* 8675 */   public static int saI(String s1, int s2) { return Integer.parseInt(s1.charAt(s2) + ""); }
/* 8676 */   public static int ltn(String s1, String s2) { return letToNum(s1, s2); }
/* 8677 */   public static int ltn5(String s1, String s2, String s3, String s4, String s5) { return letToNum5(s1, s2, s3, s4, s5); }
/* 8678 */   private static String ntl(int i) { return numToLet(i); } private static String ntl5(int i) {
/* 8679 */     return numToLet5(i);
/*      */   }
/*      */   
/* 8682 */   public static int dnsRace(String s) { int i = 0; return (s != null && s.length() > i) ? ltn(sa(s, i), sa(s, i + 1)) : 0; }
/* 8683 */   public static int dnsGender(String s) { int i = 2; return (s != null && s.length() > i) ? Integer.parseInt(sa(s, i)) : 0; }
/* 8684 */   public static int dnsHairB(String s) { int i = 3; return (s != null && s.length() > i) ? ltn(sa(s, i), sa(s, i + 1)) : 10; }
/* 8685 */   public static int dnsHairF(String s) { int i = 5; return (s != null && s.length() > i) ? ltn(sa(s, i), sa(s, i + 1)) : 0; }
/* 8686 */   public static int dnsHairC(String s) { int i = 7; return (s != null && s.length() > i) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0; }
/* 8687 */   public static int dnsBreast(String s) { int i = 12; return (s != null && s.length() > i) ? Integer.parseInt(sa(s, i)) : 0; }
/* 8688 */   public static int dnsSkinT(String s) { int i = 13; return (s != null && s.length() > i) ? Integer.parseInt(sa(s, i)) : 0; }
/* 8689 */   public static int dnsBodyT(String s) { int i = 14; return (s != null && s.length() > i + 6) ? ltn(sa(s, i), sa(s, i + 1)) : 0; }
/* 8690 */   public static int dnsBodyCM(String s) { int i = 16; return (s != null && s.length() > i + 6) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0; }
/* 8691 */   public static int dnsBodyC1(String s) { int i = 21; return (s != null && s.length() > i + 6) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0; }
/* 8692 */   public static int dnsBodyC2(String s) { int i = 26; return (s != null && s.length() > i + 6) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0; }
/* 8693 */   public static int dnsBodyC3(String s) { int i = 31; return (s != null && s.length() > i + 6) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0; }
/* 8694 */   public static int dnsFaceN(String s) { int i = 36; return (s != null && s.length() > i) ? ltn(sa(s, i), sa(s, i + 1)) : 0; }
/* 8695 */   public static int dnsFaceM(String s) { int i = 38; return (s != null && s.length() > i) ? ltn(sa(s, i), sa(s, i + 1)) : 0; }
/* 8696 */   public static int dnsEyes(String s) { int i = 40; return (s != null && s.length() > i) ? ltn(sa(s, i), sa(s, i + 1)) : 0; }
/* 8697 */   public static int dnsEyeC1(String s) { int i = 42; return (s != null && s.length() > i) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0; } public static int dnsEyeC2(String s) {
/* 8698 */     int i = 47; return (s != null && s.length() > i) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
/*      */   } public static int dnsBodyC1_0(String s) {
/* 8700 */     int i = 14; return (s != null && s.length() > i) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 0;
/*      */   }
/*      */   
/*      */   public static String dnsGenderSet(String s, String w) {
/* 8704 */     int i = 2; return (s != null && s.length() > i) ? (s.substring(0, i) + w + s.substring(i + 1)) : "0";
/* 8705 */   } public static String dnsHairBSet(String s, int w) { int i = 3; return (s != null && s.length() > i) ? (s.substring(0, i) + ntl(w) + s.substring(i + 2)) : "0"; }
/* 8706 */   public static String dnsHairFSet(String s, int w) { int i = 5; return (s != null && s.length() > i) ? (s.substring(0, i) + ntl(w) + s.substring(i + 2)) : "0"; } public static String dnsHairCSet(String s, int w) {
/* 8707 */     int i = 7; return (s != null && s.length() > i) ? (s.substring(0, i) + ntl5(w) + s.substring(i + 5)) : "0";
/*      */   }
/*      */   public static int dnsHair1(String s, int n) {
/* 8710 */     if (s != null && s.length() > n - 1) {
/*      */       
/* 8712 */       int value = 0;
/*      */       
/*      */       try {
/* 8715 */         value = Integer.parseInt(sa(s, n));
/* 8716 */       } catch (Exception exception) {}
/* 8717 */       return value;
/*      */     } 
/* 8719 */     return 0;
/*      */   }
/*      */   
/*      */   public static int dnsHair2(String s, int n) {
/* 8723 */     if (s != null && s.length() > n) {
/*      */       
/* 8725 */       int value = 0;
/*      */       
/*      */       try {
/* 8728 */         value = Integer.parseInt(sa(s, n) + sa(s, n + 1));
/* 8729 */       } catch (Exception exception) {}
/* 8730 */       return value;
/*      */     } 
/* 8732 */     return 0;
/*      */   }
/*      */   
/* 8735 */   public static String dnsHair1set(String s, int n, String w) { return (s != null && s.length() > n - 1) ? (s.substring(0, n) + w + s.substring(n + 1)) : "0"; } public static String dnsHair2set(String s, int n, String w) {
/* 8736 */     return (s != null && s.length() > n) ? (s.substring(0, n) + w + s.substring(n + 2)) : "0";
/*      */   }
/*      */   
/*      */   public static float dnsHairG(String s) {
/* 8740 */     return ((s.length() == 786) ? Integer.parseInt(sa(s, 784) + sa(s, 785)) : ((s.length() == 392) ? 10 : false)) * 0.1F;
/*      */   }
/*      */   
/*      */   public static String dnsHairG1toG2(String s) {
/* 8744 */     String g2 = "";
/* 8745 */     if (s.length() == 392) {
/* 8746 */       for (int face = 0; face < 56; face++) {
/* 8747 */         int l = dnsHair1(s, face * 7) * 11 - 10; l = (l < 0) ? 0 : l;
/* 8748 */         int X = dnsHair2(s, face * 7 + 1);
/* 8749 */         int Y = dnsHair2(s, face * 7 + 3);
/* 8750 */         int Z = dnsHair2(s, face * 7 + 5);
/* 8751 */         String L = "" + ((l < 10) ? ("0" + l) : (String)Integer.valueOf(l));
/* 8752 */         g2 = g2 + L + "" + X + "" + Y + "" + Z + "505000";
/*      */       } 
/* 8754 */       g2 = g2 + "20";
/* 8755 */     } else if (s.length() == 784) {
/* 8756 */       g2 = s + "20";
/*      */     } else {
/* 8758 */       g2 = s;
/*      */     } 
/* 8760 */     return g2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int dnsauCM(String s) {
/* 8768 */     int i = 0; return (s != null && s.length() > i + 4) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 14208118;
/* 8769 */   } public static int dnsauC1(String s) { int i = 5; return (s != null && s.length() > i + 4) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 10317733; }
/* 8770 */   public static int dnsauC2(String s) { int i = 10; return (s != null && s.length() > i + 4) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 6966676; } public static int dnsauC3(String s) {
/* 8771 */     int i = 15; return (s != null && s.length() > i + 4) ? ltn5(sa(s, i), sa(s, i + 1), sa(s, i + 2), sa(s, i + 3), sa(s, i + 4)) : 11045420;
/*      */   }
/*      */ 
/*      */   
/* 8775 */   static String wi = "wi.jrmc";
/* 8776 */   public static void wwi(MinecraftServer server, String d, String rid, boolean b) { String wd = "/data"; wd(server, d, rid + "", wd, wi, b); } public static String rwi(MinecraftServer server, String id) {
/* 8777 */     String wd = "/data"; return rd(server, id + "", wd, wi);
/*      */   }
/* 8779 */   static String bs = "BuildingSpawns";
/* 8780 */   public static void bswwi(MinecraftServer server, String d, boolean b) { wwi(server, d, bs, b); } public static String bsrwi(MinecraftServer server) {
/* 8781 */     return rwi(server, bs);
/*      */   }
/* 8783 */   static String wip = "wip.jrmc";
/* 8784 */   public static void wwip(MinecraftServer server, String d, String rid, boolean b) { String wd = "/data"; wd(server, d, rid + "", wd, wip, b); } public static String rwip(MinecraftServer server, String id) {
/* 8785 */     String wd = "/data"; return rd(server, id + "", wd, wip);
/*      */   }
/* 8787 */   public static HashMap<String, String> modAssetIDs = new HashMap<String, String>();
/*      */   public static void init() {
/* 8789 */     modAssetIDs.put("nc", tjnc + ".");
/* 8790 */     modAssetIDs.put("dbc", tjdbc + ".");
/* 8791 */     modAssetIDs.put("fc", tjfc + ".");
/* 8792 */     modAssetIDs.put("yc", tjyc + ".");
/* 8793 */     modAssetIDs.put("jrmc", tjrmc + ".");
/* 8794 */     modAssetIDs.put("saoc", tjsaoc + ".");
/* 8795 */     modAssetIDs.put("bc", tjbc + ".");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean paused = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addItemWeightStats(ItemStack p_92115_1_, Object... args) {
/* 8807 */     NBTTagList nbttaglist = ItemWeightStatsNBTTag(p_92115_1_);
/*      */     
/* 8809 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*      */       
/* 8811 */       NBTTagCompound nbttagcompound = nbttaglist.func_150305_b(i);
/* 8812 */       if (nbttagcompound.func_74760_g("weight") == 0.0F) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 8818 */     NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 8819 */     nbttagcompound1.func_74776_a("weight", Float.parseFloat("" + args[0]));
/* 8820 */     nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*      */ 
/*      */     
/* 8823 */     if (!p_92115_1_.func_77942_o())
/*      */     {
/* 8825 */       p_92115_1_.func_77982_d(new NBTTagCompound());
/*      */     }
/*      */     
/* 8828 */     p_92115_1_.func_77978_p().func_74782_a("DBCItemWeightStats", (NBTBase)nbttaglist);
/*      */   }
/*      */ 
/*      */   
/*      */   public static NBTTagList ItemWeightStatsNBTTag(ItemStack p_92110_1_) {
/* 8833 */     return (p_92110_1_.field_77990_d != null && p_92110_1_.field_77990_d.func_74764_b("DBCItemWeightStats")) ? (NBTTagList)p_92110_1_.field_77990_d.func_74781_a("DBCItemWeightStats") : new NBTTagList();
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getItemWeight(ItemStack is) {
/* 8838 */     NBTTagList nbttaglist = ItemWeightStatsNBTTag(is);
/* 8839 */     if (nbttaglist != null) {
/* 8840 */       int i = 0; if (i < nbttaglist.func_74745_c()) {
/* 8841 */         float weight = nbttaglist.func_150305_b(i).func_74760_g("weight");
/* 8842 */         return weight;
/*      */       } 
/*      */     } 
/* 8845 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public static String ItemWeightOn(ItemStack itemStack) {
/* 8849 */     if (itemStack != null && 
/* 8850 */       DBC()) return JRMCoreHDBC.ItemWeightOn(itemStack) + "," + itemStack.func_77960_j();
/*      */ 
/*      */     
/* 8853 */     return "-1,0";
/*      */   }
/*      */   
/* 8856 */   public static void log(String d) { System.out.println(d); }
/* 8857 */   public static void log(int d) { log("" + d); }
/* 8858 */   public static void log(double d) { log("" + d); }
/* 8859 */   public static void log(long d) { log("" + d); }
/* 8860 */   public static void log(float d) { log("" + d); }
/* 8861 */   public static void log(short d) { log("" + d); } public static void log(byte d) {
/* 8862 */     log("" + d);
/*      */   }
/*      */   public static class Log { public static final boolean DEBUG = true;
/*      */     
/*      */     public static void log(String message) {
/* 8867 */       String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
/* 8868 */       String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
/* 8869 */       String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
/* 8870 */       int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
/* 8871 */       System.out.println(className + "." + methodName + ":" + lineNumber + ": " + message);
/*      */     } }
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
/*      */   public static EntityPlayer getClosestPlayerToEntity(Entity p_72890_1_, double p_72890_2_) {
/* 8884 */     return getClosestPlayer(p_72890_1_, p_72890_1_.field_70165_t, p_72890_1_.field_70163_u, p_72890_1_.field_70161_v, p_72890_2_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static EntityPlayer getClosestPlayer(Entity p_72890_1_, double p_72977_1_, double p_72977_3_, double p_72977_5_, double p_72977_7_) {
/* 8893 */     double d4 = -1.0D;
/* 8894 */     EntityPlayer entityplayer = null;
/*      */     
/* 8896 */     for (int i = 0; i < p_72890_1_.field_70170_p.field_73010_i.size(); i++) {
/*      */       
/* 8898 */       EntityPlayer entityplayer1 = p_72890_1_.field_70170_p.field_73010_i.get(i);
/* 8899 */       if (!p_72890_1_.equals(entityplayer1)) {
/* 8900 */         double d5 = entityplayer1.func_70092_e(p_72977_1_, p_72977_3_, p_72977_5_);
/*      */         
/* 8902 */         if ((p_72977_7_ < 0.0D || d5 < p_72977_7_ * p_72977_7_) && (d4 == -1.0D || d5 < d4)) {
/*      */           
/* 8904 */           d4 = d5;
/* 8905 */           entityplayer = entityplayer1;
/*      */         } 
/*      */       } 
/*      */     } 
/* 8909 */     return entityplayer;
/*      */   }
/*      */ 
/*      */   
/* 8913 */   public static HashMap<String, String> turih = new HashMap<String, String>();
/* 8914 */   public static long mem = 1000L;
/*      */   public static String turihr(String u) {
/* 8916 */     return (turih.get(u) != null) ? turih.get(u) : "";
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
/*      */   public static void tur(final String u) {
/* 8942 */     turih.put(u, "loading");
/* 8943 */     Thread one = new Thread() {
/*      */         public void run() {
/* 8945 */           String rvf = u;
/* 8946 */           String line = null;
/* 8947 */           String lines = "";
/* 8948 */           int empty = 0;
/* 8949 */           int count = 0;
/* 8950 */           StringBuilder content = new StringBuilder();
/*      */           try {
/* 8952 */             URL url = new URL(u);
/* 8953 */             InputStreamReader isr = new InputStreamReader(url.openStream());
/* 8954 */             BufferedReader reader = new BufferedReader(isr);
/* 8955 */             while ((line = reader.readLine()) != null) {
/* 8956 */               content.append(line);
/*      */             }
/* 8958 */             JRMCoreH.turih.put(u, content.toString());
/* 8959 */             reader.close();
/* 8960 */             isr.close();
/* 8961 */           } catch (Exception e) {
/*      */             
/* 8963 */             JRMCoreH.turih.put(u, "error");
/*      */           } 
/*      */           
/* 8966 */           interrupt();
/*      */         }
/*      */       };
/*      */     
/* 8970 */     one.start();
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean updateEveryXTick(int tick, int updateTick) {
/* 8975 */     if (updateTick == 1) return true; 
/* 8976 */     int tickMod = tick / updateTick * updateTick;
/* 8977 */     return (tick == ((tickMod == 0) ? updateTick : tickMod));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isInCreativeMode(Entity player) {
/* 8982 */     return (player instanceof EntityPlayer) ? ((EntityPlayer)player).field_71075_bZ.field_75098_d : false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void playerUsedInstantTransmission(EntityPlayer entity) {
/* 8988 */     if (entity != null) {
/* 8989 */       jrmctAll(50, entity.func_145782_y() + ";" + entity.field_70165_t + ";" + entity.field_70163_u + ";" + entity.field_70161_v);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getMajinFormID(int state, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 8995 */     return isMysticOn ? 5 : (isUltraInstinctOn ? 6 : (isGoDOn ? 7 : state));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getArcosianFormID(int state, boolean isMysticOn, boolean isUltraInstinctOn, boolean isGoDOn) {
/* 9000 */     return isMysticOn ? 8 : (isUltraInstinctOn ? 9 : (isGoDOn ? 10 : state));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean familyCEmptyFamiliesCleared = false;
/* 9005 */   public static String previousServerFolder = "";
/*      */   
/*      */   public static void clearEmptyFamiliesNBTData(MinecraftServer server) {
/* 9008 */     if (JFC())
/* 9009 */     { if (!familyCEmptyFamiliesCleared)
/* 9010 */       { String emptyFamily = ",0!l,e!0";
/* 9011 */         String emptyFamilyNew = "EMPTY";
/* 9012 */         String f = FamilyCH.fif;
/* 9013 */         String fd = "/data";
/*      */         
/* 9015 */         if (server != null && server.field_71305_c.length > 0 && server
/*      */           
/* 9017 */           .func_71218_a(0) != null && server
/* 9018 */           .func_71218_a(0).getChunkSaveLocation() != null) {
/* 9019 */           File file = new File(server.func_71218_a(0).getChunkSaveLocation() + "/data", f);
/*      */           
/* 9021 */           try { if (!file.exists()) {
/* 9022 */               file.createNewFile();
/* 9023 */               NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 9024 */               CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
/*      */             }  }
/* 9026 */           catch (IOException iOException)
/*      */           
/*      */           { try {
/* 9029 */               int deletedFamilies = 0;
/*      */               
/* 9031 */               NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
/* 9032 */               String content = nbttagcompound.toString().replace(":\"", "");
/* 9033 */               String[] families = content.split("\",");
/* 9034 */               if (families != null && families.length > 0) {
/* 9035 */                 int length = families.length;
/*      */                 
/* 9037 */                 families[0] = families[0].substring(1);
/* 9038 */                 families[length - 1] = families[length - 1].substring(families[length - 1].length()) + "";
/*      */                 
/* 9040 */                 for (int i = 0; i < length; i++) {
/* 9041 */                   families[i] = families[i].replace(",0!l,e!0", ",EMPTY");
/* 9042 */                   String[] familyValues = families[i].split(",");
/* 9043 */                   boolean hasIt = (familyValues != null && familyValues.length > 2 && familyValues[2].equals("EMPTY") && nbttagcompound.func_74764_b(familyValues[0] + ",0"));
/* 9044 */                   if (hasIt) {
/* 9045 */                     nbttagcompound.func_82580_o(familyValues[0] + ",0");
/* 9046 */                     deletedFamilies++;
/*      */                   } 
/*      */                 } 
/*      */               } 
/* 9050 */               familyCEmptyFamiliesCleared = true;
/* 9051 */               previousServerFolder = server.func_71270_I();
/* 9052 */               log("Family C Removed Empty Families: " + deletedFamilies);
/* 9053 */               if (deletedFamilies > 0) CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file)); 
/* 9054 */             } catch (IOException iOException1) {} } finally { try { int deletedFamilies = 0; NBTTagCompound nbttagcompound = CompressedStreamTools.func_74796_a(new FileInputStream(file)); String content = nbttagcompound.toString().replace(":\"", ""); String[] families = content.split("\","); if (families != null && families.length > 0) { int length = families.length; families[0] = families[0].substring(1); families[length - 1] = families[length - 1].substring(families[length - 1].length()) + ""; for (int i = 0; i < length; i++) { families[i] = families[i].replace(",0!l,e!0", ",EMPTY"); String[] familyValues = families[i].split(","); boolean hasIt = (familyValues != null && familyValues.length > 2 && familyValues[2].equals("EMPTY") && nbttagcompound.func_74764_b(familyValues[0] + ",0")); if (hasIt) { nbttagcompound.func_82580_o(familyValues[0] + ",0"); deletedFamilies++; }  }  }  familyCEmptyFamiliesCleared = true; previousServerFolder = server.func_71270_I(); log("Family C Removed Empty Families: " + deletedFamilies); if (deletedFamilies > 0) CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));  } catch (IOException iOException) {} }
/*      */ 
/*      */         
/*      */         }  }
/* 9058 */       else if (server != null && server.func_71270_I() != null && !server.func_71270_I().equals(previousServerFolder)) { familyCEmptyFamiliesCleared = false; }
/*      */        }
/* 9060 */     else { familyCEmptyFamiliesCleared = true; }
/*      */   
/*      */   }
/*      */   
/*      */   public static NBTTagCompound readNBTFile(MinecraftServer server, String fileDirectory, String fileName) {
/* 9065 */     if (server != null && server.field_71305_c.length > 0 && server
/*      */       
/* 9067 */       .func_71218_a(0) != null && server
/* 9068 */       .func_71218_a(0).getChunkSaveLocation() != null) {
/* 9069 */       File file = new File(server.func_71218_a(0).getChunkSaveLocation() + fileDirectory, fileName);
/*      */       
/* 9071 */       try { if (!file.exists()) {
/* 9072 */           file.createNewFile();
/* 9073 */           NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 9074 */           CompressedStreamTools.func_74799_a(nbttagcompound, new FileOutputStream(file));
/*      */         }  }
/* 9076 */       catch (IOException iOException)
/*      */       
/*      */       { 
/*      */         try {
/* 9080 */           return nbttagcompound;
/* 9081 */         } catch (IOException iOException1) {} }
/*      */       finally { Exception exception = null; }
/*      */     
/* 9084 */     }  return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getDataFromNBT(String id, NBTTagCompound nbttagcompound) {
/* 9089 */     if (nbttagcompound.func_74764_b(id)) return nbttagcompound.func_74779_i(id); 
/* 9090 */     return "0";
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */