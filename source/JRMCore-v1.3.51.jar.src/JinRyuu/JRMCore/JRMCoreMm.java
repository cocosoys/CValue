/*      */ package JinRyuu.JRMCore;
/*      */ 
/*      */ import com.google.common.collect.Lists;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JRMCoreMm
/*      */ {
/*      */   public static final int MISSION_TP_REWARD_ID_MULTI = 15;
/*      */   public static final int MISSION_TP_REWARD_LEVEL_MULTI = 10;
/*      */   public static final String MISSION_CONDS_TYPE = "0";
/*      */   public static final String MISSION_CONDS_Name = "N";
/*      */   public static final String MISSION_CONDS_Health = "H";
/*      */   public static final String MISSION_CONDS_Attack = "A";
/*      */   public static final String MISSION_CONDS_Amount = "M";
/*      */   public static final String MISSION_CONDS_MsgSpawn = "S";
/*      */   public static final String MISSION_CONDS_MsgDeath = "D";
/*      */   public static final String MISSION_CONDS_Message = "G";
/*      */   public static final String MISSION_CONDS_MsgBtn = "B";
/*      */   public static final String MISSION_CONDS_Protect = "P";
/*      */   public static final String MISSION_TalkTo_Series = "series";
/*      */   public static final String MISSION_TalkTo_translated = "translated";
/*      */   public static final String MISSION_CONDS_Transformations = "T";
/*      */   public static final String MISSION_CONDS_MsgSpawnSnd = "O";
/*      */   public static final String MISSION_CONDS_MsgDeathSnd = "U";
/*      */   public static final int MISSION_INFO_SeID = 0;
/*      */   public static final int MISSION_INFO_Name = 1;
/*      */   public static final int MISSION_INFO_Desc = 2;
/*      */   public static final int MISSION_INFO_Auth = 3;
/*      */   public static final int MISSION_INFO_Vers = 4;
/*      */   public static final int MISSION_INFO_Mods = 5;
/*      */   public static final int MISSION_INFO_Rept = 6;
/*      */   public static final int MISSION_INFO_Unlo = 7;
/*      */   public static final String MISSION_PROP_Default = "default";
/*      */   public static final String MISSION_PROP_RandomReward = "randrew";
/*      */   public static final String SERIES_DBC_MainID = "mainDBC";
/*      */   public static final String SERIES_NC_MainID = "mainNC";
/*      */   public static final String MISSION_TYPE_Kill = "kill";
/*      */   public static final String MISSION_TYPE_KillMoreOfSamekind = "killsame";
/*      */   public static final String MISSION_TYPE_GoToBiome = "biome";
/*      */   public static final String MISSION_TYPE_GoToDim = "dim";
/*      */   public static final String MISSION_TYPE_ClickNext = "next";
/*      */   public static final String MISSION_TYPE_ClickStart = "start";
/*      */   public static final String MISSION_TYPE_ClickSkip = "skip";
/*      */   public static final String MISSION_TYPE_ClickRestart = "restart";
/*      */   public static final String MISSION_TYPE_GatherItem = "item";
/*      */   public static final String MISSION_TYPE_TalkTo = "talk";
/*      */   public static final String MISSION_TYPE_StateIn = "state";
/*      */   public static final String MISSION_TYPE_BeInBiome = "biome2";
/*      */   public static final String MISSION_TYPE_BeInDim = "dim2";
/*      */   public static final String MISSION_TYPE_Lvl = "lvl";
/*      */   public static final String REWARD_TYPE_NOTHING = "nothing";
/*      */   public static final String REWARD_TYPE_Item = "item";
/*      */   public static final String REWARD_TYPE_TP = "tp";
/*      */   public static final String REWARD_TYPE_Alignment = "align";
/*      */   public static final String REWARD_TYPE_Command = "com";
/*      */   public static final String REWARD_TYPE_TP_FIX = "fix";
/*      */   public static final String REWARD_TYPE_TP_ALIGN = "align";
/*      */   public static final String REWARD_TYPE_TP_LVL = "lvl";
/*      */   public static final String REWARD_TYPE_TP_LVLALIGN = "lvlalign";
/*      */   static final float POWER_MULTI = 1.5F;
/*      */   
/*      */   public static ArrayList<String> missionReset() {
/*   84 */     return Lists.newArrayList();
/*   85 */   } public static void missionRestart(ArrayList<String> l) { l.add("restart"); }
/*   86 */   public static void missionClickNext(ArrayList<String> l) { l.add("next"); } public static void missionClickStart(ArrayList<String> l) {
/*   87 */     l.add("start");
/*      */   } public static void missionKill(ArrayList<String> l, String enemy, float damage, float health, String startLine, String endLine) {
/*   89 */     l.add("kill;N" + enemy + ";" + "H" + (int)health + ";" + "A" + (int)damage + ";" + "S" + startLine + ";" + "D" + endLine);
/*      */   }
/*      */   
/*      */   public static void missionKillMoreOfSame(ArrayList<String> l, String enemy, int count, float damage, float health) {
/*   93 */     l.add("killsame;N" + enemy + ";" + "M" + count + ";" + "H" + (int)damage + ";" + "A" + (int)health);
/*      */   }
/*      */   public static int missionRewardNothingRestart(ArrayList<String> l, int i) {
/*   96 */     i++;
/*   97 */     l.add("nothing;jinryuujrmcore.Restart;" + i);
/*   98 */     return i;
/*      */   }
/*      */   public static int missionRewardNothingSkip(ArrayList<String> l, int i) {
/*  101 */     i++;
/*  102 */     l.add("nothing;jinryuujrmcore.Skip;" + i);
/*  103 */     return i;
/*      */   }
/*      */   public static int missionRewardNothing(ArrayList<String> l, int i) {
/*  106 */     i++;
/*  107 */     l.add("nothing;jinryuujrmcore.Next;" + i);
/*  108 */     return i;
/*      */   }
/*      */   public static int missionRewardTPLevelAligned(ArrayList<String> l, int i) {
/*  111 */     return missionRewardTPLevelAligned2(l, i, 10.0D);
/*      */   }
/*      */   public static int missionRewardTPLevelAligned2(ArrayList<String> l, int i, double multi) {
/*  114 */     l.add("tp!lvlalign!" + multi + "||" + "align" + "!+10;jinryuujrmcore.missionSys.Protect;" + (i + 1));
/*  115 */     l.add("tp!lvlalign!" + multi + "||" + "align" + "!0;jinryuujrmcore.missionSys.Myself;" + (i + 1));
/*  116 */     l.add("tp!lvlalign!" + multi + "||" + "align" + "!-10;jinryuujrmcore.missionSys.Evil;" + (i + 1));
/*  117 */     return i + 1;
/*      */   }
/*      */   public static int missionRewardTP(ArrayList<String> l, int i) {
/*  120 */     return missionRewardTP2(l, i, 15);
/*      */   }
/*      */   public static int missionRewardTP2(ArrayList<String> l, int i, int multi) {
/*  123 */     l.add("tp!fix!" + (multi * i) + "||" + "align" + "!+10;jinryuujrmcore.missionSys.Protect;" + (i + 1));
/*  124 */     l.add("tp!fix!" + (multi * i) + "||" + "align" + "!0;jinryuujrmcore.missionSys.Myself;" + (i + 1));
/*  125 */     l.add("tp!fix!" + (multi * i) + "||" + "align" + "!-10;jinryuujrmcore.missionSys.Evil;" + (i + 1));
/*  126 */     return i + 1;
/*      */   }
/*      */   public static int missionRewardTP(ArrayList<String> l, int i, int tpReward) {
/*  129 */     l.add("tp!fix!" + tpReward + "||" + "align" + "!+10;jinryuujrmcore.missionSys.Protect;" + (i + 1));
/*  130 */     l.add("tp!fix!" + tpReward + "||" + "align" + "!0;jinryuujrmcore.missionSys.Myself;" + (i + 1));
/*  131 */     l.add("tp!fix!" + tpReward + "||" + "align" + "!-10;jinryuujrmcore.missionSys.Evil;" + (i + 1));
/*  132 */     return i + 1;
/*      */   }
/*      */   public static int missionRewardItem(ArrayList<String> l, int i, String item, int itemCount) {
/*  135 */     return missionRewardItem(l, i, item, itemCount, 15);
/*      */   }
/*      */   public static int missionRewardItem(ArrayList<String> l, int i, String item, int itemCount, int multi) {
/*  138 */     l.add("item!" + item + "," + itemCount + "||" + "tp" + "!" + "fix" + "!" + (multi * i) + "||" + "align" + "!+10;jinryuujrmcore.missionSys.Protect;" + (i + 1));
/*  139 */     l.add("item!" + item + "," + itemCount + "||" + "tp" + "!" + "fix" + "!" + (multi * i) + "||" + "align" + "!0;jinryuujrmcore.missionSys.Myself;" + (i + 1));
/*  140 */     l.add("item!" + item + "," + itemCount + "||" + "tp" + "!" + "fix" + "!" + (multi * i) + "||" + "align" + "!-10;jinryuujrmcore.missionSys.Evil;" + (i + 1));
/*  141 */     return i + 1;
/*      */   }
/*      */   public static int missionRewardItems(ArrayList<String> l, int i, String[] items, int[] itemCounts) {
/*  144 */     return missionRewardItems(l, i, items, itemCounts, 15);
/*      */   }
/*      */   public static int missionRewardItems(ArrayList<String> l, int i, String[] items, int[] itemCounts, int multi) {
/*  147 */     String result = "";
/*  148 */     int id = 0;
/*  149 */     for (String item : items) {
/*  150 */       result = result + "item!" + item + "," + itemCounts[id] + "||";
/*  151 */       id++;
/*      */     } 
/*  153 */     l.add(result + "tp" + "!" + "fix" + "!" + (10 * i) + "||" + "align" + "!+10;jinryuujrmcore.missionSys.Protect;" + (i + 1));
/*  154 */     l.add(result + "tp" + "!" + "fix" + "!" + (10 * i) + "||" + "align" + "!0;jinryuujrmcore.missionSys.Myself;" + (i + 1));
/*  155 */     l.add(result + "tp" + "!" + "fix" + "!" + (10 * i) + "||" + "align" + "!-10;jinryuujrmcore.missionSys.Evil;" + (i + 1));
/*  156 */     return i + 1;
/*      */   }
/*      */   public static int missionRewardItem(ArrayList<String> l, int i, String itemGood, String itemNeutral, String itemEvil, int itemCount) {
/*  159 */     return missionRewardItem(l, i, itemGood, itemNeutral, itemEvil, itemCount, 15);
/*      */   }
/*      */   public static int missionRewardItem(ArrayList<String> l, int i, String itemGood, String itemNeutral, String itemEvil, int itemCount, int multi) {
/*  162 */     l.add("item!" + itemGood + "," + itemCount + "||" + "tp" + "!" + "fix" + "!" + (multi * i) + "||" + "align" + "!+10;jinryuujrmcore.missionSys.Protect;" + (i + 1));
/*  163 */     l.add("item!" + itemNeutral + "," + itemCount + "||" + "tp" + "!" + "fix" + "!" + (multi * i) + "||" + "align" + "!0;jinryuujrmcore.missionSys.Myself;" + (i + 1));
/*  164 */     l.add("item!" + itemEvil + "," + itemCount + "||" + "tp" + "!" + "fix" + "!" + (multi * i) + "||" + "align" + "!-10;jinryuujrmcore.missionSys.Evil;" + (i + 1));
/*  165 */     return i + 1;
/*      */   }
/*  167 */   public static void missionGoToDimension(ArrayList<String> l, String dimension) { l.add("dim;N" + dimension); }
/*  168 */   public static void missionBeInDimension(ArrayList<String> l, String dimension) { l.add("dim2;N" + dimension); }
/*  169 */   public static void missionBeInBiome(ArrayList<String> l, String biome) { l.add("biome2;N" + biome); } public static void missionGatherItem(ArrayList<String> l, String item, int count) {
/*  170 */     l.add("item;N" + item + ";" + "M" + count);
/*      */   } public static void missionTalkTo(ArrayList<String> l, String master, String text, String text2) {
/*  172 */     l.add("talk;N" + master + ";" + "G" + text + ";" + "B" + text2);
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
/*  183 */   static int allMsn = 0;
/*      */   
/*      */   static HashMap<Integer, ArrayList<String>> DBCmainSagaObjs;
/*      */   static HashMap<Integer, ArrayList<String>> DBCmainSagaRwrds;
/*      */   static HashMap<Integer, ArrayList<String>> DBCmainSagaObjs1;
/*      */   static HashMap<Integer, ArrayList<String>> DBCmainSagaRwrds1;
/*      */   static HashMap<Integer, ArrayList<String>> DBCmainSagaObjs2;
/*      */   static HashMap<Integer, ArrayList<String>> DBCmainSagaRwrds2;
/*      */   
/*      */   public static void init() {
/*  193 */     DBCmainSagaObjs = new HashMap<Integer, ArrayList<String>>();
/*  194 */     DBCmainSagaRwrds = new HashMap<Integer, ArrayList<String>>();
/*  195 */     DBCmainSagaObjs1 = new HashMap<Integer, ArrayList<String>>();
/*  196 */     DBCmainSagaRwrds1 = new HashMap<Integer, ArrayList<String>>();
/*  197 */     DBCmainSagaObjs2 = new HashMap<Integer, ArrayList<String>>();
/*  198 */     DBCmainSagaRwrds2 = new HashMap<Integer, ArrayList<String>>();
/*  199 */     ArrayList<String> l = Lists.newArrayList();
/*      */ 
/*      */     
/*  202 */     int i = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  211 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  212 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  215 */     missionClickNext(l);
/*  216 */     missionTalkTo(l, "jinryuudragonblockc.roshi", "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */     
/*  218 */     missionRewardItem(l, i, "jinryuudragonblockc:KintounItem", "jinryuudragonblockc:KintounItem", "jinryuudragonblockc:KintounBlackItem", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  220 */     missionClickStart(l);
/*  221 */     missionBeInDimension(l, "Overworld");
/*  222 */     missionKill(l, "jinryuudragonblockc.Yamcha", 45.0F, 150.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  223 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  228 */     missionClickStart(l);
/*  229 */     missionBeInDimension(l, "Overworld");
/*  230 */     missionKill(l, "jinryuudragonblockc.DBMai", 15.0F, 45.0F, "dbc.sagasdb." + i + ".3", "dbc.sagasdb." + i + ".d3");
/*  231 */     missionKill(l, "jinryuudragonblockc.DBShu", 7.5F, 45.0F, "dbc.sagasdb." + i + ".2", "dbc.sagasdb." + i + ".d2");
/*  232 */     missionKill(l, "jinryuudragonblockc.DBPilaf", 7.5F, 30.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  233 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  235 */     missionClickStart(l);
/*  236 */     missionBeInDimension(l, "Overworld");
/*  237 */     missionKill(l, "jinryuudragonblockc.DBMaiMecha", 45.0F, 165.0F, "dbc.sagasdb." + i + ".3", "dbc.sagasdb." + i + ".d3");
/*  238 */     missionKill(l, "jinryuudragonblockc.DBShuMecha", 45.0F, 150.0F, "dbc.sagasdb." + i + ".2", "dbc.sagasdb." + i + ".d2");
/*  239 */     missionKill(l, "jinryuudragonblockc.DBPilafMecha", 30.0F, 120.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  240 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  242 */     missionClickStart(l);
/*  243 */     missionBeInDimension(l, "Overworld");
/*  244 */     missionKill(l, "jinryuudragonblockc.DBPilafMechaCombined", 60.0F, 225.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */ 
/*      */     
/*  247 */     missionRewardItems(l, i, new String[] { "jinryuudragonblockc:ItemDragonBlock", "jinryuudragonblockc:GiFighterTorso1", "jinryuudragonblockc:GiFighterLeg1", "jinryuudragonblockc:GiFighterBoots1" }, new int[] { 1, 1, 1, 1 }); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */     
/*  251 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  252 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  254 */     missionClickStart(l);
/*  255 */     missionBeInDimension(l, "Overworld");
/*  256 */     missionKill(l, "jinryuudragonblockc.Bacterian", 22.5F, 150.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  257 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  259 */     missionClickStart(l);
/*  260 */     missionBeInDimension(l, "Overworld");
/*  261 */     missionKill(l, "jinryuudragonblockc.Yamcha2", 75.0F, 255.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  262 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  264 */     missionClickStart(l);
/*  265 */     missionBeInDimension(l, "Overworld");
/*  266 */     missionKill(l, "jinryuudragonblockc.JackieChun", 105.0F, 270.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  267 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  269 */     missionClickStart(l);
/*  270 */     missionBeInDimension(l, "Overworld");
/*  271 */     missionKill(l, "jinryuudragonblockc.JackieChun2", 135.0F, 300.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  272 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */     
/*  276 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  277 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  279 */     missionClickStart(l);
/*  280 */     missionBeInDimension(l, "Overworld");
/*  281 */     missionKill(l, "jinryuudragonblockc.ColonelSilver", 45.0F, 225.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  282 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  284 */     missionClickStart(l);
/*  285 */     missionBeInDimension(l, "Overworld");
/*  286 */     missionKill(l, "jinryuudragonblockc.MajorMetallitron", 75.0F, 300.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  287 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  289 */     missionClickStart(l);
/*  290 */     missionBeInDimension(l, "Overworld");
/*  291 */     missionKill(l, "jinryuudragonblockc.NinjaMurasaki", 45.0F, 300.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */     
/*  293 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemKatana", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  295 */     missionClickStart(l);
/*  296 */     missionBeInDimension(l, "Overworld");
/*  297 */     missionKill(l, "jinryuudragonblockc.Android8", 75.0F, 300.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  298 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  300 */     missionClickStart(l);
/*  301 */     missionBeInDimension(l, "Overworld");
/*  302 */     missionKill(l, "jinryuudragonblockc.Buyon", 135.0F, 450.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  303 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  305 */     missionClickStart(l);
/*  306 */     missionBeInDimension(l, "Overworld");
/*  307 */     missionKill(l, "jinryuudragonblockc.GeneralWhite", 45.0F, 300.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */     
/*  309 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemDragonBlock", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  312 */     missionClickStart(l);
/*  313 */     missionBeInDimension(l, "Overworld");
/*  314 */     missionKill(l, "jinryuudragonblockc.GeneralBlue", 165.0F, 525.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  315 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  317 */     missionClickStart(l);
/*  318 */     missionBeInDimension(l, "Overworld");
/*  319 */     missionKill(l, "jinryuudragonblockc.MercenaryTao", 225.0F, 675.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  320 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  322 */     missionClickStart(l);
/*  323 */     missionBeInDimension(l, "Overworld");
/*  324 */     int count = 2;
/*  325 */     missionKillMoreOfSame(l, "jinryuudragonblockc.RedRibbonSoldier", 2, 22.5F, 120.0F);
/*  326 */     missionKillMoreOfSame(l, "jinryuudragonblockc.RedRibbonSoldier2", 2, 30.0F, 120.0F);
/*  327 */     missionKillMoreOfSame(l, "jinryuudragonblockc.RedRibbonSoldier3", 2, 60.0F, 120.0F);
/*  328 */     missionKillMoreOfSame(l, "jinryuudragonblockc.RedRibbonSoldierB", 2, 22.5F, 120.0F);
/*  329 */     missionKillMoreOfSame(l, "jinryuudragonblockc.RedRibbonSoldierB2", 2, 30.0F, 120.0F);
/*  330 */     missionKillMoreOfSame(l, "jinryuudragonblockc.RedRibbonSoldierB3", 2, 60.0F, 120.0F); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  331 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  333 */     missionClickStart(l);
/*  334 */     missionBeInDimension(l, "Overworld");
/*  335 */     missionKill(l, "jinryuudragonblockc.OfficerBlack3", 255.0F, 720.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */     
/*  337 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemDragonBlock", 2); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */     
/*  341 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  342 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  344 */     missionClickStart(l);
/*  345 */     missionBeInDimension(l, "Overworld");
/*  346 */     missionKill(l, "jinryuudragonblockc.FangsTheVampire", 165.0F, 525.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  347 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  349 */     missionClickStart(l);
/*  350 */     missionBeInDimension(l, "Overworld");
/*  351 */     missionKill(l, "jinryuudragonblockc.SeeThroughTheInvisibleMan", 165.0F, 525.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  352 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  354 */     missionClickStart(l);
/*  355 */     missionBeInDimension(l, "Overworld");
/*  356 */     missionKill(l, "jinryuudragonblockc.BandagesTheMummy", 225.0F, 675.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  357 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  359 */     missionClickStart(l);
/*  360 */     missionBeInDimension(l, "Overworld");
/*  361 */     missionKill(l, "jinryuudragonblockc.SpikeTheDevil", 255.0F, 720.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  362 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  364 */     missionClickStart(l);
/*  365 */     missionBeInDimension(l, "Overworld");
/*  366 */     missionKill(l, "jinryuudragonblockc.GrandpaGohan2", 270.0F, 825.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */     
/*  368 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemPP", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  373 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  374 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  376 */     missionClickStart(l);
/*  377 */     missionBeInDimension(l, "Overworld");
/*  378 */     missionKill(l, "jinryuudragonblockc.Yamcha3", 255.0F, 525.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  379 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  381 */     missionClickStart(l);
/*  382 */     missionBeInDimension(l, "Overworld");
/*  383 */     missionKill(l, "jinryuudragonblockc.Chiaotzu", 75.0F, 225.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  384 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  386 */     missionClickStart(l);
/*  387 */     missionBeInDimension(l, "Overworld");
/*  388 */     missionKill(l, "jinryuudragonblockc.Krillin", 300.0F, 675.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  389 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  391 */     missionClickStart(l);
/*  392 */     missionBeInDimension(l, "Overworld");
/*  393 */     missionKill(l, "jinryuudragonblockc.TienShinhan", 375.0F, 1050.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  394 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */     
/*  398 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  399 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  401 */     missionClickStart(l);
/*  402 */     missionBeInDimension(l, "Overworld");
/*  403 */     missionKill(l, "jinryuudragonblockc.Tambourine", 420.0F, 1110.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  404 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  406 */     missionClickStart(l);
/*  407 */     missionBeInDimension(l, "Overworld");
/*  408 */     missionKill(l, "jinryuudragonblockc.Cymbal", 120.0F, 450.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  409 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  411 */     missionClickStart(l);
/*  412 */     missionBeInDimension(l, "Overworld");
/*  413 */     missionKill(l, "jinryuudragonblockc.Tambourine", 435.0F, 1170.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */     
/*  415 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemDragonBlock", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  417 */     missionClickStart(l);
/*  418 */     missionBeInDimension(l, "Overworld");
/*  419 */     missionKill(l, "jinryuudragonblockc.KingPiccolo", 450.0F, 1260.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  420 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  422 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  423 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  425 */     missionClickStart(l);
/*  426 */     missionBeInDimension(l, "Overworld");
/*  427 */     missionKill(l, "jinryuudragonblockc.Drum", 405.0F, 1200.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  428 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  430 */     missionClickStart(l);
/*  431 */     missionBeInDimension(l, "Overworld");
/*  432 */     missionKill(l, "jinryuudragonblockc.KingPiccolo2", 495.0F, 1500.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  433 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemDragonBlock", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  438 */     missionClickNext(l);
/*  439 */     missionTalkTo(l, "jinryuudragonblockc.kami", "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */ 
/*      */ 
/*      */     
/*  443 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  445 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  446 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  448 */     missionClickStart(l);
/*  449 */     missionBeInDimension(l, "Overworld");
/*  450 */     missionKill(l, "jinryuudragonblockc.MercenaryTao2", 420.0F, 1125.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  451 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  453 */     missionClickStart(l);
/*  454 */     missionBeInDimension(l, "Overworld");
/*  455 */     missionKill(l, "jinryuudragonblockc.TienShinhan3", 525.0F, 1800.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  456 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  458 */     missionClickStart(l);
/*  459 */     missionBeInDimension(l, "Overworld");
/*  460 */     missionKill(l, "jinryuudragonblockc.Piccolo", 600.0F, 2250.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  461 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  463 */     missionClickStart(l);
/*  464 */     missionBeInDimension(l, "Overworld");
/*  465 */     missionKill(l, "jinryuudragonblockc.Piccolo2", 750.0F, 2400.0F, "dbc.sagasdb." + i + ".1", "dbc.sagasdb." + i + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  466 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  469 */     missionClickNext(l); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = missionReset();
/*  470 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  477 */     l.add("start");
/*  478 */     l.add("dim2;NOverworld");
/*  479 */     l.add("killsame;Njinryuudragonblockc.Saibaiman;M6;H1500;A300"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  482 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  484 */     l.add("start");
/*  485 */     l.add("dim2;NOverworld");
/*  486 */     l.add("kill;Njinryuudragonblockc.Raditz;H3000;A900;Sdbc.itemSaiySagaRad.line1;Ddbc.itemSaiySagaRad.d.line1"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  489 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  491 */     l.add("start");
/*  492 */     l.add("dim2;NOverworld");
/*  493 */     l.add("biome2;NDirty Stony");
/*  494 */     l.add("item;Njinryuudragonblockc:ItemDinoMeatCooked;M10");
/*  495 */     l.add("killsame;Njinryuudragonblockc.Saibaiman;M12;H1500;A300"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  498 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  500 */     l.add("start");
/*  501 */     l.add("dim2;NOverworld");
/*  502 */     l.add("biome2;NDirty Stony");
/*  503 */     l.add("kill;Njinryuudragonblockc.Nappa;H3750;A975;Sdbc.itemSaiySagaVeg.line1;Ddbc.itemSaiySagaVeg.d.line2");
/*  504 */     l.add("kill;Njinryuudragonblockc.Vegeta;H4500;A1050;Sdbc.itemSaiySagaVeg.line2;Ddbc.itemSaiySagaVeg.d.line1"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  507 */     missionRewardItem(l, i, "jinryuudragonblockc:SpacePod01Item", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  509 */     l.add("start");
/*  510 */     l.add("dim;NNamek"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  513 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  515 */     l.add("start");
/*  516 */     l.add("dim2;NNamek");
/*  517 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier1;M3;H2250;A450");
/*  518 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier2;M3;H2250;A450");
/*  519 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier3;M3;H2250;A450"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  522 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  524 */     l.add("start");
/*  525 */     l.add("dim2;NNamek");
/*  526 */     l.add("kill;Njinryuudragonblockc.Kiwi;H4800;A1095"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  529 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  531 */     l.add("start");
/*  532 */     l.add("dim2;NNamek");
/*  533 */     l.add("kill;Njinryuudragonblockc.Dodoria;H5250;A1125"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */     
/*  535 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemNamekDragonBlock", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  538 */     l.add("start");
/*  539 */     l.add("dim2;NNamek");
/*  540 */     l.add("kill;Njinryuudragonblockc.Zarbon;H5700;A1200"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */     
/*  542 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemDragonRadar", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  545 */     l.add("start");
/*  546 */     l.add("dim2;NNamek");
/*  547 */     l.add("kill;Njinryuudragonblockc.Guldo;H2250;A900;Sdbc.itemFreeSagaGin.4.line1");
/*  548 */     l.add("kill;Njinryuudragonblockc.Recoome;H7200;A1500;Sdbc.itemFreeSagaGin.1.line1;Ddbc.itemFreeSagaGin.d.1.line1");
/*  549 */     l.add("kill;Njinryuudragonblockc.Barta;H6300;A1275;Sdbc.itemFreeSagaGin.2.line1");
/*  550 */     l.add("kill;Njinryuudragonblockc.Jeice;H6300;A1350;Sdbc.itemFreeSagaGin.3.line1");
/*  551 */     l.add("kill;Njinryuudragonblockc.Ginyu;H7800;A1800;Sdbc.itemFreeSagaGin.5.line1;Ddbc.itemFreeSagaGin.d.5.line1"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */     
/*  553 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemNamekDragonBlock", 2); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  556 */     l.add("start");
/*  557 */     l.add("dim2;NNamek");
/*  558 */     l.add("kill;Njinryuudragonblockc.Freeza1;H9000;A2250;Tjinryuudragonblockc.Freeza2|300|1.1||jinryuudragonblockc.Freeza3|300|1.1||jinryuudragonblockc.Freeza4|300|1.1||jinryuudragonblockc.Freeza5|300|1.1||jinryuudragonblockc.Freeza6|600|1.2");
/*  559 */     DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */     
/*  561 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemNamekDragonBlock", 2); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  564 */     l.add("start");
/*  565 */     l.add("dim;NOverworld"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  568 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  570 */     l.add("start");
/*  571 */     l.add("dim2;NOverworld");
/*  572 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  573 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  575 */     l.add("start");
/*  576 */     l.add("dim2;NOverworld");
/*  577 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier1;M3;H2700;A525");
/*  578 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier2;M3;H2700;A525");
/*  579 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier3;M3;H2700;A525"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  582 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  584 */     l.add("start");
/*  585 */     l.add("dim2;NOverworld");
/*  586 */     l.add("kill;Njinryuudragonblockc.MechaFreeza;H15000;A4500");
/*  587 */     l.add("kill;Njinryuudragonblockc.KingCold;H12000;A3000"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  590 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  592 */     l.add("skip"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  593 */     missionRewardNothingSkip(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i), l); l = missionReset();
/*  594 */     l.add("next");
/*  595 */     l.add("state;NSS"); DBCmainSagaObjs1.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  596 */     missionRewardNothing(l, i); DBCmainSagaRwrds1.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  598 */     l.add("next");
/*  599 */     l.add("talk;Njinryuudragonblockc.kami;Gdbc.MainSaga.17.m;Bdbc.MainSaga.17.b"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  600 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  610 */     l.add("start");
/*  611 */     l.add("dim2;NOverworld");
/*  612 */     l.add("biome;NDirty Stony"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  613 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  615 */     l.add("start");
/*  616 */     l.add("dim2;NOverworld");
/*  617 */     l.add("kill;Njinryuudragonblockc.Cyborg19;H18000;A4950");
/*  618 */     l.add("kill;Njinryuudragonblockc.Cyborg20;H19500;A5250"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  621 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  623 */     l.add("start");
/*  624 */     l.add("dim;NTimeChamber"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  625 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  627 */     l.add("start");
/*  628 */     l.add("dim2;NOverworld");
/*  629 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  630 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  632 */     l.add("start");
/*  633 */     l.add("dim2;NOverworld");
/*  634 */     l.add("kill;Njinryuudragonblockc.Cyborg18;H21750;A5700"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  637 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  639 */     l.add("start");
/*  640 */     l.add("dim2;NOverworld");
/*  641 */     l.add("kill;Njinryuudragonblockc.Cell1;H24000;A6300;Tjinryuudragonblockc.Cell2|400|1.1"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  644 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  646 */     l.add("start");
/*  647 */     l.add("dim2;NOverworld");
/*  648 */     l.add("biome;NDirty Stony"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  649 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  651 */     l.add("start");
/*  652 */     l.add("dim2;NOverworld");
/*  653 */     l.add("kill;Njinryuudragonblockc.Cyborg16;H27000;A6900");
/*  654 */     l.add("kill;Njinryuudragonblockc.Cyborg17;H25500;A6450"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  657 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  659 */     l.add("start");
/*  660 */     l.add("dim2;NOverworld");
/*  661 */     l.add("kill;Njinryuudragonblockc.Cell2;H27000;A7200;Tjinryuudragonblockc.Cell3|300|1.1"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  664 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  666 */     l.add("skip"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  667 */     missionRewardNothingSkip(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i), l); l = missionReset();
/*  668 */     l.add("next");
/*  669 */     l.add("state;NSS2"); DBCmainSagaObjs1.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  670 */     missionRewardNothing(l, i); DBCmainSagaRwrds1.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  672 */     l.add("start");
/*  673 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  674 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  676 */     l.add("start");
/*  677 */     l.add("dim2;NOverworld");
/*  678 */     l.add("killsame;Njinryuudragonblockc.CellJr;M7;H10500;A2250;"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  681 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  684 */     l.add("start");
/*  685 */     l.add("dim2;NOverworld");
/*  686 */     l.add("kill;Njinryuudragonblockc.Cell3;H33000;A7350;Tjinryuudragonblockc.Cell4|400|1.2"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  689 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  691 */     l.add("next");
/*  692 */     l.add("talk;Njinryuudragonblockc.masterbabidi;Gdbc.MainSaga." + (i - 47) + ".m;" + "B" + "dbc.MainSaga." + (i - 47) + ".b"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  693 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  695 */     l.add("start");
/*  696 */     l.add("dim2;NOverworld");
/*  697 */     l.add("kill;Njinryuudragonblockc.Puipui;H22500;A1500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  700 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  702 */     l.add("start");
/*  703 */     l.add("dim2;NOverworld");
/*  704 */     l.add("kill;Njinryuudragonblockc.Yakon;H27000;A4500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  707 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  709 */     l.add("start");
/*  710 */     l.add("dim2;NOverworld");
/*  711 */     l.add("kill;Njinryuudragonblockc.Darbura;H27000;A5250;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  714 */     missionRewardItem(l, i, "jinryuudragonblockc:ItemEvilSpear", 1); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  716 */     l.add("start");
/*  717 */     l.add("dim2;NOverworld");
/*  718 */     l.add("kill;Njinryuudragonblockc.BuuFat;H39000;A7500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  721 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  723 */     l.add("skip"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  724 */     missionRewardNothingSkip(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i), l); l = missionReset();
/*  725 */     l.add("start");
/*  726 */     l.add("state;NSS3"); DBCmainSagaObjs1.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  727 */     missionRewardNothing(l, i); DBCmainSagaRwrds1.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  729 */     l.add("start");
/*  730 */     l.add("dim2;NOverworld");
/*  731 */     l.add("kill;Njinryuudragonblockc.BuuFat;H48000;A7950;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  734 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  736 */     l.add("start");
/*  737 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  738 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  740 */     l.add("start");
/*  741 */     l.add("dim2;NOverworld");
/*  742 */     l.add("kill;Njinryuudragonblockc.BuuSuper;H51000;A8250;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  747 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */     
/*  751 */     l.add("start");
/*  752 */     l.add("dim2;NOverworld");
/*  753 */     l.add("kill;Njinryuudragonblockc.BuuFusion;H57000;A9000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  756 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  758 */     l.add("start");
/*  759 */     l.add("dim2;NOverworld");
/*  760 */     l.add("kill;Njinryuudragonblockc.BuuPiccolo;H52500;A8250;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  763 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  766 */     l.add("start");
/*  767 */     l.add("dim2;NOverworld");
/*  768 */     l.add("kill;Njinryuudragonblockc.BuuUltimate;H63000;A9750;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  771 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  773 */     l.add("start");
/*  774 */     l.add("dim2;NOverworld");
/*  775 */     l.add("kill;Njinryuudragonblockc.BuuKid;H67500;A11250;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  778 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/*  781 */     l.add("start");
/*  782 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  783 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  793 */     l.add("start");
/*  794 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  795 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  797 */     l.add("start");
/*  798 */     l.add("dim2;NOverworld");
/*  799 */     l.add("kill;Njinryuudragonblockc.Beerus;H75000;A12000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  802 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  804 */     l.add("skip"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  805 */     missionRewardNothingSkip(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i), l); l = missionReset();
/*  806 */     l.add("start");
/*  807 */     l.add("state;NSSGod"); DBCmainSagaObjs1.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  808 */     missionRewardNothing(l, i); DBCmainSagaRwrds1.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  810 */     l.add("start");
/*  811 */     l.add("dim2;NOverworld");
/*  812 */     l.add("kill;Njinryuudragonblockc.Beerus;H78000;A12450;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  815 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  821 */     l.add("start");
/*  822 */     l.add("dim2;NOverworld");
/*  823 */     l.add("kill;Njinryuudragonblockc.Whis;H82500;A12750;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  826 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  828 */     l.add("start");
/*  829 */     l.add("dim2;NOverworld");
/*  830 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier1;M10;H7500;A2700");
/*  831 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier2;M10;H7500;A2700");
/*  832 */     l.add("killsame;Njinryuudragonblockc.FreezaSoldier3;M10;H7500;A2700"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  835 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  837 */     l.add("start");
/*  838 */     l.add("dim2;NOverworld");
/*  839 */     l.add("kill;Njinryuudragonblockc.Shisami;H18000;A4500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  842 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  844 */     l.add("start");
/*  845 */     l.add("dim2;NOverworld");
/*  846 */     l.add("kill;Njinryuudragonblockc.Tagoma;H45000;A9000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  849 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  859 */     l.add("start");
/*  860 */     l.add("dim2;NOverworld");
/*  861 */     l.add("kill;Njinryuudragonblockc.Freeza6;H87000;A13500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  864 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  866 */     l.add("skip"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  867 */     missionRewardNothingSkip(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i), l); l = missionReset();
/*  868 */     l.add("start");
/*  869 */     l.add("state;NSSB"); DBCmainSagaObjs1.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  870 */     missionRewardNothing(l, i); DBCmainSagaRwrds1.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  872 */     l.add("start");
/*  873 */     l.add("dim2;NOverworld");
/*  874 */     l.add("kill;Njinryuudragonblockc.FreezaGolden;H93000;A14250;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  877 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  883 */     l.add("start");
/*  884 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  885 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  887 */     l.add("start");
/*  888 */     l.add("dim2;NOverworld");
/*  889 */     l.add("kill;Njinryuudragonblockc.Botamo;H33000;A1500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  892 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  894 */     l.add("start");
/*  895 */     l.add("dim2;NOverworld");
/*  896 */     l.add("kill;Njinryuudragonblockc.Frost1;H30000;A7500;Tjinryuudragonblockc.Frost3|150|1.1||jinryuudragonblockc.Frost4|150|1.1");
/*  897 */     DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */ 
/*      */     
/*  901 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  903 */     l.add("start");
/*  904 */     l.add("dim2;NOverworld");
/*  905 */     l.add("kill;Njinryuudragonblockc.Magetta;H97500;A13500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  908 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  910 */     l.add("start");
/*  911 */     l.add("dim2;NOverworld");
/*  912 */     l.add("kill;Njinryuudragonblockc.Cabba;H30000;A9000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  915 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  917 */     l.add("start");
/*  918 */     l.add("dim2;NOverworld");
/*  919 */     l.add("kill;Njinryuudragonblockc.CabbaSSJ;H42000;A10500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  922 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  932 */     l.add("start");
/*  933 */     l.add("dim2;NOverworld");
/*  934 */     l.add("kill;Njinryuudragonblockc.Hit;H105000;A14250;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  937 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  939 */     l.add("start");
/*  940 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  941 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  947 */     l.add("start");
/*  948 */     l.add("dim2;NOverworld");
/*  949 */     l.add("kill;Njinryuudragonblockc.BeerusMonaka;H112500;A14700;Tjinryuudragonblockc.BeerusMonaka2|3000|1.2||jinryuudragonblockc.BeerusMonaka3|3000|1.2");
/*  950 */     DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  953 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  963 */     l.add("start");
/*  964 */     l.add("dim2;NOverworld");
/*  965 */     l.add("kill;Njinryuudragonblockc.VegetaCopy;H115500;A15000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  968 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  970 */     l.add("start");
/*  971 */     l.add("dim2;NOverworld");
/*  972 */     l.add("kill;Njinryuudragonblockc.VegetaCopyBlue;H120000;A18000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/*  975 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  993 */     l.add("start");
/*  994 */     l.add("biome;NPlains"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*  995 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/*  997 */     l.add("start");
/*  998 */     l.add("dim2;NOverworld");
/*  999 */     l.add("kill;Njinryuudragonblockc.GokuBlack;H121500;A18750;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1002 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1004 */     l.add("start");
/* 1005 */     l.add("dim2;NOverworld"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1006 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1008 */     l.add("start");
/* 1009 */     l.add("dim2;NOverworld");
/* 1010 */     l.add("kill;Njinryuudragonblockc.Zamasu;H45000;A6750;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1013 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1015 */     l.add("start");
/* 1016 */     l.add("dim2;NOverworld");
/* 1017 */     l.add("kill;Njinryuudragonblockc.GokuBlack;H123000;A19200;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1020 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1022 */     l.add("start");
/* 1023 */     l.add("dim2;NOverworld");
/* 1024 */     l.add("kill;Njinryuudragonblockc.GokuBlackRose;H126000;A19500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1027 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1029 */     l.add("start");
/* 1030 */     l.add("dim2;NOverworld"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1031 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/* 1034 */     l.add("start");
/* 1035 */     l.add("dim2;NOverworld"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1036 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1038 */     l.add("start");
/* 1039 */     l.add("dim2;NOverworld");
/* 1040 */     l.add("kill;Njinryuudragonblockc.Zamasu;H45000;A6750;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d");
/* 1041 */     l.add("kill;Njinryuudragonblockc.GokuBlackRose;H126000;A19500;Sdbc.MainSaga." + (i - 47) + ".2;" + "D" + "dbc.MainSaga." + (i - 47) + ".2d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1044 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1046 */     l.add("start");
/* 1047 */     l.add("dim2;NOverworld"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1048 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1050 */     l.add("start");
/* 1051 */     l.add("dim2;NOverworld");
/* 1052 */     l.add("kill;Njinryuudragonblockc.Zamasu_fused;H129000;A22500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1055 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1057 */     l.add("start");
/* 1058 */     l.add("dim2;NOverworld");
/* 1059 */     l.add("kill;Njinryuudragonblockc.Zamasu_fused2;H130500;A23250;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1062 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1064 */     l.add("start");
/* 1065 */     l.add("dim2;NOverworld");
/* 1066 */     l.add("kill;Njinryuudragonblockc.Zamasu_fused3;H132000;A24000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1069 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1071 */     l.add("start");
/* 1072 */     l.add("dim2;NOverworld"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1073 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1075 */     l.add("start");
/* 1076 */     l.add("dim2;NOverworld");
/* 1077 */     l.add("kill;Njinryuudragonblockc.Hit;H105000;A25500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1080 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */     
/* 1084 */     l.add("start");
/* 1085 */     l.add("dim2;NNull Realm"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1086 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1088 */     l.add("start");
/* 1089 */     l.add("dim2;NNull Realm");
/* 1090 */     l.add("kill;Njinryuudragonblockc.Basil;H97500;A21000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1093 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1095 */     l.add("start");
/* 1096 */     l.add("dim2;NNull Realm");
/* 1097 */     l.add("kill;Njinryuudragonblockc.Lavender;H99000;A22500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1100 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1102 */     l.add("start");
/* 1103 */     l.add("dim2;NNull Realm");
/* 1104 */     l.add("kill;Njinryuudragonblockc.Bergamo;H112500;A27000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1107 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1109 */     l.add("start");
/* 1110 */     l.add("dim2;NNull Realm");
/* 1111 */     l.add("kill;Njinryuudragonblockc.Toppo;H135000;A30000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1114 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/* 1117 */     l.add("start");
/* 1118 */     l.add("dim2;NOverworld"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1119 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/* 1122 */     l.add("start");
/* 1123 */     l.add("dim2;NOverworld");
/* 1124 */     l.add("kill;Njinryuudragonblockc.Gohan_enemy2_1;H120000;A33000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1127 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1129 */     l.add("start");
/* 1130 */     l.add("dim2;NOverworld");
/* 1131 */     l.add("kill;Njinryuudragonblockc.Krillin;H67500;A24000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1134 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/* 1137 */     l.add("start");
/* 1138 */     l.add("dim2;NNull Realm"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1139 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/* 1142 */     l.add("start");
/* 1143 */     l.add("dim2;NNull Realm");
/* 1144 */     l.add("kill;Njinryuudragonblockc.Basil;H97500;A21000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d");
/* 1145 */     l.add("kill;Njinryuudragonblockc.Lavender;H99000;A22500;Sdbc.MainSaga." + (i - 47) + ".2;" + "D" + "dbc.MainSaga." + (i - 47) + ".2d");
/* 1146 */     l.add("kill;Njinryuudragonblockc.Bergamo;H112500;A27000;Sdbc.MainSaga." + (i - 47) + ".3;" + "D" + "dbc.MainSaga." + (i - 47) + ".3d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1149 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/* 1152 */     l.add("start");
/* 1153 */     l.add("dim2;NNull Realm");
/* 1154 */     l.add("kill;Njinryuudragonblockc.Caulifla;H117000;A27750;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d");
/* 1155 */     l.add("kill;Njinryuudragonblockc.Kale;H97500;A25500;Sdbc.MainSaga." + (i - 47) + ".2;" + "D" + "dbc.MainSaga." + (i - 47) + ".2d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1158 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1160 */     l.add("start");
/* 1161 */     l.add("dim2;NNull Realm");
/* 1162 */     l.add("kill;Njinryuudragonblockc.Caulifla2;H127500;A36000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1165 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1167 */     l.add("start");
/* 1168 */     l.add("dim2;NNull Realm");
/* 1169 */     l.add("kill;Njinryuudragonblockc.Kale2;H142500;A45000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1172 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1174 */     l.add("start");
/* 1175 */     l.add("dim2;NNull Realm");
/* 1176 */     l.add("kill;Njinryuudragonblockc.Brianne;H97500;A30000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1179 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/* 1182 */     l.add("start");
/* 1183 */     l.add("dim2;NNull Realm");
/* 1184 */     l.add("kill;Njinryuudragonblockc.Dyspo;H165000;A48000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1187 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1189 */     l.add("start");
/* 1190 */     l.add("dim2;NNull Realm");
/* 1191 */     l.add("kill;Njinryuudragonblockc.Toppo;H210000;A51000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1194 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1196 */     l.add("start");
/* 1197 */     l.add("dim2;NNull Realm");
/* 1198 */     l.add("kill;Njinryuudragonblockc.Jiren;H240000;A54000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1201 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1203 */     l.add("start");
/* 1204 */     l.add("dim2;NNull Realm");
/* 1205 */     l.add("kill;Njinryuudragonblockc.Kefla;H270000;A57000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1208 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1210 */     l.add("start");
/* 1211 */     l.add("dim2;NNull Realm");
/* 1212 */     l.add("kill;Njinryuudragonblockc.Kefla2;H330000;A60000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1215 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1217 */     l.add("start");
/* 1218 */     l.add("dim2;NNull Realm");
/* 1219 */     l.add("kill;Njinryuudragonblockc.Toppo2;H360000;A64500;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1222 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1224 */     l.add("start");
/* 1225 */     l.add("dim2;NNull Realm");
/* 1226 */     l.add("kill;Njinryuudragonblockc.Jiren;H405000;A69000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1229 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1231 */     l.add("start");
/* 1232 */     l.add("dim2;NNull Realm");
/* 1233 */     l.add("kill;Njinryuudragonblockc.Jiren2;H480000;A75000;Sdbc.MainSaga." + (i - 47) + ".1;" + "D" + "dbc.MainSaga." + (i - 47) + ".d"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/*      */ 
/*      */     
/* 1236 */     missionRewardTP(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1238 */     l.add("start");
/* 1239 */     l.add("dim2;NNull Realm"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1240 */     missionRewardNothing(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1249 */     l.add("restart"); DBCmainSagaObjs.put(Integer.valueOf(i), l); l = Lists.newArrayList();
/* 1250 */     missionRewardNothingRestart(l, i); DBCmainSagaRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */     
/* 1253 */     allMsn = i + 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1260 */   static int allMissionsDBSBroly = 0; static HashMap<Integer, ArrayList<String>> DBCDBSBrolyObjs; static HashMap<Integer, ArrayList<String>> DBCDBSBrolyRwrds; static HashMap<Integer, ArrayList<String>> DBCDBSBrolyObjs1; static HashMap<Integer, ArrayList<String>> DBCDBSBrolyRwrds1;
/*      */   static HashMap<Integer, ArrayList<String>> DBCDBSBrolyObjs2;
/*      */   static HashMap<Integer, ArrayList<String>> DBCDBSBrolyRwrds2;
/*      */   
/*      */   public static void initDBCDBSBroly() {
/* 1265 */     DBCDBSBrolyObjs = new HashMap<Integer, ArrayList<String>>();
/* 1266 */     DBCDBSBrolyRwrds = new HashMap<Integer, ArrayList<String>>();
/* 1267 */     DBCDBSBrolyObjs1 = new HashMap<Integer, ArrayList<String>>();
/* 1268 */     DBCDBSBrolyRwrds1 = new HashMap<Integer, ArrayList<String>>();
/* 1269 */     DBCDBSBrolyObjs2 = new HashMap<Integer, ArrayList<String>>();
/* 1270 */     DBCDBSBrolyRwrds2 = new HashMap<Integer, ArrayList<String>>();
/* 1271 */     ArrayList<String> l = Lists.newArrayList();
/*      */     
/* 1273 */     int i = 0;
/* 1274 */     missionClickNext(l); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/* 1275 */     missionRewardNothing(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1280 */     missionClickStart(l);
/*      */ 
/*      */     
/* 1283 */     missionKill(l, "jinryuudragonblockc.Vegeta_enemy", 28500.0F, 285000.0F, "dbc.sagadbsbroly." + i + ".1", "dbc.sagadbsbroly." + i + ".d"); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/*      */     
/* 1285 */     missionRewardTPLevelAligned(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1287 */     missionClickStart(l);
/* 1288 */     missionBeInDimension(l, "Overworld");
/* 1289 */     missionKill(l, "jinryuudragonblockc.Goku_enemy", 30000.0F, 300000.0F, "dbc.sagadbsbroly." + i + ".1", "dbc.sagadbsbroly." + i + ".d"); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/* 1290 */     missionRewardTPLevelAligned(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1292 */     missionClickStart(l);
/* 1293 */     missionBeInDimension(l, "Overworld");
/* 1294 */     missionKill(l, "jinryuudragonblockc.DBSBroly4", 15000.0F, 225000.0F, "dbc.sagadbsbroly." + i + ".1", "dbc.sagadbsbroly." + i + ".d"); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/* 1295 */     missionRewardTPLevelAligned(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1297 */     missionClickStart(l);
/* 1298 */     missionBeInDimension(l, "Overworld");
/* 1299 */     missionKill(l, "jinryuudragonblockc.DBSBrolyBuff", 45000.0F, 375000.0F, "dbc.sagadbsbroly." + i + ".1", "dbc.sagadbsbroly." + i + ".d"); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/* 1300 */     missionRewardTPLevelAligned(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1302 */     missionClickStart(l);
/* 1303 */     missionBeInDimension(l, "Overworld");
/* 1304 */     missionKill(l, "jinryuudragonblockc.DBSBrolyBuffSSJ", 90000.0F, 825000.0F, "dbc.sagadbsbroly." + i + ".1", "dbc.sagadbsbroly." + i + ".d"); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/* 1305 */     missionRewardTPLevelAligned(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1307 */     missionClickStart(l);
/* 1308 */     missionBeInDimension(l, "Overworld");
/* 1309 */     missionKill(l, "jinryuudragonblockc.DBSBrolyLegendary", 105000.0F, 975000.0F, "dbc.sagadbsbroly." + i + ".1", "dbc.sagadbsbroly." + i + ".d"); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/* 1310 */     missionRewardTPLevelAligned(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1312 */     missionClickNext(l); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/* 1313 */     missionRewardNothing(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1318 */     missionRestart(l); DBCDBSBrolyObjs.put(Integer.valueOf(i), l); l = missionReset();
/* 1319 */     missionRewardNothingRestart(l, i); DBCDBSBrolyRwrds.put(Integer.valueOf(i++), l); l = missionReset();
/*      */     
/* 1321 */     allMissionsDBSBroly = i + 1;
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
/* 1332 */   static int allMsnNC = 0;
/*      */   
/*      */   static HashMap<Integer, ArrayList<String>> NCmainSagaObjs;
/*      */   static HashMap<Integer, ArrayList<String>> NCmainSagaRwrds;
/*      */   static HashMap<Integer, String> NCmainSagaProps;
/*      */   static HashMap<Integer, String> NCmainSagaArcs;
/*      */   static HashMap<Integer, ArrayList<String>> NCmainSagaObjs1;
/*      */   static HashMap<Integer, ArrayList<String>> NCmainSagaRwrds1;
/*      */   static HashMap<Integer, ArrayList<String>> NCmainSagaObjs2;
/*      */   static HashMap<Integer, ArrayList<String>> NCmainSagaRwrds2;
/*      */   static final int DB_END = 47;
/*      */   
/*      */   public static void initNC() {
/* 1345 */     NCmainSagaObjs = new HashMap<Integer, ArrayList<String>>();
/* 1346 */     NCmainSagaRwrds = new HashMap<Integer, ArrayList<String>>();
/* 1347 */     NCmainSagaProps = new HashMap<Integer, String>();
/* 1348 */     NCmainSagaArcs = new HashMap<Integer, String>();
/*      */     
/* 1350 */     NCmainSagaObjs1 = new HashMap<Integer, ArrayList<String>>();
/* 1351 */     NCmainSagaRwrds1 = new HashMap<Integer, ArrayList<String>>();
/* 1352 */     NCmainSagaObjs2 = new HashMap<Integer, ArrayList<String>>();
/* 1353 */     NCmainSagaRwrds2 = new HashMap<Integer, ArrayList<String>>();
/*      */ 
/*      */     
/* 1356 */     String arc = "nc.sagasystem.about";
/* 1357 */     int id = 0;
/* 1358 */     objs(id, new String[] { "start" });
/* 1359 */     rews(id, new String[] { rew("jinryuujrmcore.Next", id + 1, new String[] { r(new String[] { "nothing" }) }) });
/* 1360 */     othrs(id, arc, "default");
/*      */ 
/*      */ 
/*      */     
/* 1364 */     arc = "nc.sagasystem.prologue";
/* 1365 */     id = 1;
/* 1366 */     objs(id, new String[] { "start", 
/* 1367 */           obj(new String[] { "biome2", "NPlains"
/* 1368 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilIruka", "H400", "A100" }) });
/* 1369 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1370 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1371 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1372 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1375 */     id = 2;
/* 1376 */     objs(id, new String[] { "start", 
/* 1377 */           obj(new String[] { "biome2", "NRoofed Forest"
/* 1378 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilMizuki1", "H600", "A120" }) });
/* 1379 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1380 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1381 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1382 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1385 */     id = 3;
/* 1386 */     objs(id, new String[] { "next" });
/* 1387 */     rews(id, new String[] { rew("jinryuujrmcore.Next", id + 1, new String[] { r(new String[] { "item", JRMCoreH.tjnc + ":ItemScrollOfSeals,1" }) }) });
/* 1388 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1391 */     id = 4;
/* 1392 */     objs(id, new String[] { "next" });
/* 1393 */     rews(id, new String[] { rew("jinryuujrmcore.Next", id + 1, new String[] { r(new String[] { "nothing" }) }) });
/* 1394 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1397 */     id = 5;
/* 1398 */     objs(id, new String[] { "start", 
/* 1399 */           obj(new String[] { "killsame", "NOzelot", "M6", "H100", "A20" }) });
/* 1400 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1401 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1402 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1403 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1406 */     id = 6;
/* 1407 */     objs(id, new String[] { "next", 
/* 1408 */           obj(new String[] { "item", "Nwheat_seeds", "M48" }) });
/* 1409 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1410 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1411 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1412 */     othrs(id, arc, "default");
/*      */     
/* 1414 */     id = 7;
/* 1415 */     objs(id, new String[] { "next", 
/* 1416 */           obj(new String[] { "item", "Nyellow_flower", "M10"
/* 1417 */             }), obj(new String[] { "item", "Nred_flower", "M12"
/* 1418 */             }), obj(new String[] { "item", "Nred_flower::1", "M4" }) });
/* 1419 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1420 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1421 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1422 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1425 */     id = 8;
/* 1426 */     objs(id, new String[] { "start", 
/* 1427 */           obj(new String[] { "biome2", "NRoofed Forest" }) });
/* 1428 */     rews(id, new String[] { rew("jinryuujrmcore.Next", id + 1, new String[] { r(new String[] { "nothing" }) }) });
/* 1429 */     othrs(id, arc, "default");
/*      */     
/* 1431 */     id = 9;
/* 1432 */     objs(id, new String[] { "start", 
/* 1433 */           obj(new String[] { "biome2", "NRoofed Forest"
/* 1434 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilZabuza1", "H1200", "A240"
/* 1435 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilHaku1", "H1000", "A200" }) });
/* 1436 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1437 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1438 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1439 */     othrs(id, arc, "default");
/*      */     
/* 1441 */     id = 10;
/* 1442 */     objs(id, new String[] { "start", 
/* 1443 */           obj(new String[] { "biome2", "NRoofed Forest"
/* 1444 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilZabuza2", "H1600", "A300" }) });
/* 1445 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1446 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1447 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1448 */     othrs(id, arc, "default");
/*      */     
/* 1450 */     id = 11;
/* 1451 */     objs(id, new String[] { "next" });
/* 1452 */     rews(id, new String[] { rew("jinryuujrmcore.Next", id + 1, new String[] { r(new String[] { "nothing" }) }) });
/* 1453 */     othrs(id, arc, "default");
/*      */     
/* 1455 */     arc = "nc.sagasystem.chuuninexams";
/* 1456 */     id = 12;
/* 1457 */     objs(id, new String[] { "next" });
/* 1458 */     rews(id, new String[] { rew("jinryuujrmcore.Next", id + 1, new String[] { r(new String[] { "nothing" }) }) });
/* 1459 */     othrs(id, arc, "default");
/*      */     
/* 1461 */     id = 13;
/* 1462 */     objs(id, new String[] { "start", 
/* 1463 */           obj(new String[] { "biome2", "NNinja Forest"
/* 1464 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilShiroe", "H1800", "A320" }) });
/* 1465 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1466 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1467 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1468 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1471 */     id = 14;
/* 1472 */     objs(id, new String[] { "next", 
/* 1473 */           obj(new String[] { "biome2", "NPlains" }) });
/* 1474 */     rews(id, new String[] { rew("jinryuujrmcore.Continue", 14, new String[] { r(new String[] { "nothing"
/* 1475 */                 }) }), rew("emty", 15, new String[] { r(new String[] { "nothing"
/* 1476 */                 }) }), rew("emty", 16, new String[] { r(new String[] { "nothing"
/* 1477 */                 }) }), rew("emty", 17, new String[] { r(new String[] { "nothing"
/* 1478 */                 }) }), rew("emty", 18, new String[] { r(new String[] { "nothing"
/* 1479 */                 }) }), rew("emty", 19, new String[] { r(new String[] { "nothing"
/* 1480 */                 }) }), rew("emty", 20, new String[] { r(new String[] { "nothing"
/* 1481 */                 }) }), rew("emty", 21, new String[] { r(new String[] { "nothing"
/* 1482 */                 }) }), rew("emty", 22, new String[] { r(new String[] { "nothing"
/* 1483 */                 }) }), rew("emty", 23, new String[] { r(new String[] { "nothing" }) }), 
/* 1484 */           rew("emty", 24, new String[] { r(new String[] { "nothing"
/* 1485 */                 }) }), rew("emty", 25, new String[] { r(new String[] { "nothing"
/* 1486 */                 }) }), rew("emty", 26, new String[] { r(new String[] { "nothing"
/* 1487 */                 }) }), rew("emty", 27, new String[] { r(new String[] { "nothing" }) }) });
/* 1488 */     othrs(id, arc, "randrew");
/*      */     
/* 1490 */     id = 15;
/* 1491 */     objs(id, new String[] { "start", 
/* 1492 */           obj(new String[] { "biome2", "NPlains"
/* 1493 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilSasuke1", "H2400", "A350" }) });
/* 1494 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1495 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1496 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1497 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1500 */     id = 16;
/* 1501 */     objs(id, new String[] { "start", 
/* 1502 */           obj(new String[] { "biome2", "NPlains"
/* 1503 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilSakura1", "H2000", "A300" }) });
/* 1504 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1505 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1506 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1507 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1510 */     id = 17;
/* 1511 */     objs(id, new String[] { "start", 
/* 1512 */           obj(new String[] { "biome2", "NPlains"
/* 1513 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilIno1", "H2000", "A300" }) });
/* 1514 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1515 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1516 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1517 */     othrs(id, arc, "default");
/*      */     
/* 1519 */     id = 18;
/* 1520 */     objs(id, new String[] { "start", 
/* 1521 */           obj(new String[] { "biome2", "NPlains"
/* 1522 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilShika1", "H2000", "A300" }) });
/* 1523 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1524 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1525 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1526 */     othrs(id, arc, "default");
/*      */     
/* 1528 */     id = 19;
/* 1529 */     objs(id, new String[] { "start", 
/* 1530 */           obj(new String[] { "biome2", "NPlains"
/* 1531 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilChoji1", "H2000", "A300" }) });
/* 1532 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1533 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1534 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1535 */     othrs(id, arc, "default");
/*      */     
/* 1537 */     id = 20;
/* 1538 */     objs(id, new String[] { "start", 
/* 1539 */           obj(new String[] { "biome2", "NPlains"
/* 1540 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilHinata1", "H2000", "A300" }) });
/* 1541 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1542 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1543 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1544 */     othrs(id, arc, "default");
/*      */     
/* 1546 */     id = 21;
/* 1547 */     objs(id, new String[] { "start", 
/* 1548 */           obj(new String[] { "biome2", "NPlains"
/* 1549 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilKiba1", "H2000", "A300" }) });
/* 1550 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1551 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1552 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1553 */     othrs(id, arc, "default");
/*      */     
/* 1555 */     id = 22;
/* 1556 */     objs(id, new String[] { "start", 
/* 1557 */           obj(new String[] { "biome2", "NPlains"
/* 1558 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilShino1", "H2000", "A300" }) });
/* 1559 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1560 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1561 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1562 */     othrs(id, arc, "default");
/*      */     
/* 1564 */     id = 23;
/* 1565 */     objs(id, new String[] { "start", 
/* 1566 */           obj(new String[] { "biome2", "NPlains"
/* 1567 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilNeji1", "H2500", "A360" }) });
/* 1568 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1569 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1570 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1571 */     othrs(id, arc, "default");
/*      */     
/* 1573 */     id = 24;
/* 1574 */     objs(id, new String[] { "start", 
/* 1575 */           obj(new String[] { "biome2", "NPlains"
/* 1576 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilTenten1", "H2000", "A300" }) });
/* 1577 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1578 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1579 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1580 */     othrs(id, arc, "default");
/*      */     
/* 1582 */     id = 25;
/* 1583 */     objs(id, new String[] { "start", 
/* 1584 */           obj(new String[] { "biome2", "NPlains"
/* 1585 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilLee1", "H2500", "A360" }) });
/* 1586 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1587 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1588 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1589 */     othrs(id, arc, "default");
/*      */     
/* 1591 */     id = 26;
/* 1592 */     objs(id, new String[] { "start", 
/* 1593 */           obj(new String[] { "biome2", "NPlains"
/* 1594 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilTemari1", "H2000", "A300" }) });
/* 1595 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1596 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1597 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1598 */     othrs(id, arc, "default");
/*      */     
/* 1600 */     id = 27;
/* 1601 */     objs(id, new String[] { "start", 
/* 1602 */           obj(new String[] { "biome2", "NPlains"
/* 1603 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilKankuro1", "H2000", "A300" }) });
/* 1604 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1605 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1606 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", 28, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1607 */     othrs(id, arc, "default");
/*      */ 
/*      */ 
/*      */     
/* 1611 */     id = 28;
/* 1612 */     objs(id, new String[] { "next", 
/* 1613 */           obj(new String[] { "biome2", "NPlains" }) });
/* 1614 */     rews(id, new String[] { rew("jinryuujrmcore.Next", id + 1, new String[] { r(new String[] { "nothing" }) }) });
/* 1615 */     othrs(id, arc, "default");
/*      */     
/* 1617 */     id = 29;
/* 1618 */     objs(id, new String[] { "start", 
/* 1619 */           obj(new String[] { "biome2", "NPlains"
/* 1620 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilNaruto1", "H2200", "A280" }) });
/* 1621 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1622 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1623 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1624 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1627 */     id = 30;
/* 1628 */     objs(id, new String[] { "start", 
/* 1629 */           obj(new String[] { "biome2", "NPlains"
/* 1630 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilNaruto2", "H3000", "A400" }) });
/* 1631 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1632 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1633 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1634 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1637 */     id = 31;
/* 1638 */     objs(id, new String[] { "start", 
/* 1639 */           obj(new String[] { "biome2", "NPlains"
/* 1640 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilGaara1", "H3000", "A500" }) });
/* 1641 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1642 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1643 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1644 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1647 */     id = 32;
/* 1648 */     objs(id, new String[] { "start", 
/* 1649 */           obj(new String[] { "biome2", "NPlains"
/* 1650 */             }), obj(new String[] { "kill", "Njinryuunarutoc.EntityNCEvilShukaku", "H5000", "A1000" }) });
/* 1651 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Protect", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "+10"
/* 1652 */                 }) }), rew("jinryuujrmcore.missionSys.Myself", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "0"
/* 1653 */                 }) }), rew("jinryuujrmcore.missionSys.Evil", id + 1, new String[] { r(new String[] { "tp", "fix", "" + (10 * id) }), r(new String[] { "align", "-10" }) }) });
/* 1654 */     othrs(id, arc, "default");
/*      */ 
/*      */     
/* 1657 */     id = 33;
/* 1658 */     objs(id, new String[] { "next" });
/* 1659 */     rews(id, new String[] { rew("jinryuujrmcore.Next", id + 1, new String[] { r(new String[] { "nothing" }) }) });
/* 1660 */     othrs(id, arc, "default");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1666 */     arc = "nc.sagasystem.credits";
/* 1667 */     id = 34;
/* 1668 */     objs(id, new String[] { "restart" });
/* 1669 */     rews(id, new String[] { rew("jinryuujrmcore.missionSys.Next", id + 1, new String[] { r(new String[] { "nothing" }) }) });
/* 1670 */     othrs(id, arc, "default");
/*      */ 
/*      */ 
/*      */     
/* 1674 */     allMsnNC = id + 1;
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
/*      */   public static String obj(String... arg) {
/* 1686 */     int k = 4;
/* 1687 */     int m = 6;
/* 1688 */     k = m + (m = k) - k;
/* 1689 */     String s = "";
/* 1690 */     for (int i = 0; i < arg.length; ) { s = s + ";" + arg[i]; i++; }
/* 1691 */      return s.substring(1);
/*      */   }
/*      */   public static void objs(int id, String... o) {
/* 1694 */     ArrayList<String> l = Lists.newArrayList();
/* 1695 */     for (int i = 0; i < o.length; i++) {
/* 1696 */       l.add(o[i]);
/* 1697 */       NCmainSagaObjs.put(Integer.valueOf(id), l);
/*      */     } 
/*      */   }
/*      */   public static void othrs(int id, String a, String p) {
/* 1701 */     NCmainSagaArcs.put(Integer.valueOf(id), a);
/* 1702 */     NCmainSagaProps.put(Integer.valueOf(id), p);
/*      */   }
/*      */   
/*      */   public static void rews(int id, String... o) {
/* 1706 */     ArrayList<String> l = Lists.newArrayList();
/* 1707 */     for (int i = 0; i < o.length; i++) {
/* 1708 */       l.add(o[i]);
/* 1709 */       NCmainSagaRwrds.put(Integer.valueOf(id), l);
/*      */     } 
/*      */   }
/*      */   public static String rew(String buttonName, int nextMissionID, String... reward) {
/* 1713 */     String s = "";
/* 1714 */     for (int i = 0; i < reward.length; i++) {
/* 1715 */       s = s + "||" + reward[i];
/*      */     }
/* 1717 */     return ((s.length() > 2) ? s.substring(2) : s) + ";" + buttonName + ";" + nextMissionID;
/*      */   }
/*      */   public static String r(String... r) {
/* 1720 */     if (r.length == 3 && r[0].equalsIgnoreCase("tp"))
/* 1721 */       return r[0] + "!" + r[1] + "!" + r[2]; 
/* 1722 */     if (r.length == 1 && r[0].equalsIgnoreCase("nothing")) {
/* 1723 */       return r[0];
/*      */     }
/* 1725 */     return r[0] + "!" + r[1];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String sagaTitle(int i) {
/* 1734 */     if (i <= 5) return "dbc.sagasystem.emperorpilaf"; 
/* 1735 */     if (i <= 10) return "dbc.sagasystem.dbtournament"; 
/* 1736 */     if (i <= 21) return "dbc.sagasystem.redribbon"; 
/* 1737 */     if (i <= 27) return "dbc.sagasystem.fortunetellerbaba"; 
/* 1738 */     if (i <= 32) return "dbc.sagasystem.tienshinhan"; 
/* 1739 */     if (i <= 40) return "dbc.sagasystem.kingpiccolo"; 
/* 1740 */     if (i <= 47) return "dbc.sagasystem.piccolojr";
/*      */     
/* 1742 */     if (i <= 52) return "dbc.sagasystem.saiyan"; 
/* 1743 */     if (i <= 59) return "dbc.sagasystem.freeza"; 
/* 1744 */     if (i <= 77) return "dbc.sagasystem.android"; 
/* 1745 */     if (i <= 91) return "dbc.sagasystem.buu";
/*      */     
/* 1747 */     if (i <= 95) return "dbc.sagasystem.beerus"; 
/* 1748 */     if (i <= 102) return "dbc.sagasystem.gfreeza"; 
/* 1749 */     if (i <= 110) return "dbc.sagasystem.universe6"; 
/* 1750 */     if (i <= 113) return "dbc.sagasystem.cvegeta"; 
/* 1751 */     if (i <= 128) return "dbc.sagasystem.dbsftrunks"; 
/* 1752 */     if (i <= 151) return "dbc.sagasystem.dbsuniversesurvival";
/*      */     
/* 1754 */     return "dbc.sagasystem.credits";
/*      */   }
/*      */   public static ArrayList<String> al(String... s) { ArrayList<String> l;
/*      */     int i;
/* 1758 */     for (l = Lists.newArrayList(), i = 0; i < s.length; ) { l.add(s[i]); i++; }  return l; } public static ArrayList<ArrayList<String>> al(ArrayList<String>... s) { ArrayList<ArrayList<String>> l; int i;
/* 1759 */     for (l = Lists.newArrayList(), i = 0; i < s.length; ) { l.add(s[i]); i++; }  return l; }
/*      */ 
/*      */   
/*      */   public static JRMCoreMsnBundle msnGen() {
/* 1763 */     init();
/* 1764 */     int DBCmainSagaLength = allMsn;
/* 1765 */     JRMCoreMsnBundle mb = new JRMCoreMsnBundle();
/*      */     
/* 1767 */     mb.setName("Dragon Block C Main Saga");
/* 1768 */     mb.setDesc("An alternate story for the DBC mod based off on the Dragon Ball series.");
/* 1769 */     mb.setAuthor("JinRyuu, Ben");
/* 1770 */     mb.setVersion("1.4");
/* 1771 */     mb.setMods("DBC");
/* 1772 */     mb.settings.repeat = "0";
/* 1773 */     mb.settings.unlock = "";
/* 1774 */     mb.settings.vars = "";
/* 1775 */     ArrayList<JRMCoreMsn> ml = new ArrayList<JRMCoreMsn>();
/* 1776 */     JRMCoreMsn m = new JRMCoreMsn();
/*      */     
/* 1778 */     for (int i = 0; i < DBCmainSagaLength; i++) {
/*      */       
/* 1780 */       m = new JRMCoreMsn();
/* 1781 */       m.setId(i);
/* 1782 */       m.setTranslated(true);
/* 1783 */       ArrayList<String> l = Lists.newArrayList();
/*      */       
/* 1785 */       String key = (i > 47) ? "dbc.sagasystem." : "dbc.sagasdb.";
/* 1786 */       int keyID = (i > 47) ? (i - 47) : i;
/*      */       
/* 1788 */       if (i == 63 || i == 74 || i == 83 || i == 94 || i == 101) {
/* 1789 */         m.setProps(al(new String[] { "default", "saiyan" }));
/* 1790 */         m.setAlign(al(new String[] { "neutral", "neutral" }));
/* 1791 */         m.setTitle(al(new String[] { sagaTitle(i), sagaTitle(i) }));
/* 1792 */         m.setSubtitle(al(new String[] { key + keyID + ".title", key + keyID + ".title" }));
/* 1793 */         m.setDescription(al(new String[] { key + keyID + ".desc", key + keyID + ".desc" }));
/* 1794 */         m.setObjectives(al((ArrayList<String>[])new ArrayList[] { DBCmainSagaObjs.get(Integer.valueOf(i)), DBCmainSagaObjs1.get(Integer.valueOf(i)) }));
/* 1795 */         m.setRewards(al((ArrayList<String>[])new ArrayList[] { DBCmainSagaRwrds.get(Integer.valueOf(i)), DBCmainSagaRwrds1.get(Integer.valueOf(i)) }));
/*      */       } else {
/*      */         
/* 1798 */         m.setProps(al(new String[] { "default" }));
/* 1799 */         m.setAlign(al(new String[] { "neutral" }));
/* 1800 */         m.setTitle(al(new String[] { sagaTitle(i) }));
/* 1801 */         m.setSubtitle(al(new String[] { key + keyID + ".title" }));
/* 1802 */         m.setDescription(al(new String[] { key + keyID + ".desc" }));
/* 1803 */         m.setObjectives(al((ArrayList<String>[])new ArrayList[] { DBCmainSagaObjs.get(Integer.valueOf(i)) }));
/* 1804 */         m.setRewards(al((ArrayList<String>[])new ArrayList[] { DBCmainSagaRwrds.get(Integer.valueOf(i)) }));
/*      */       } 
/* 1806 */       ml.add(m);
/*      */     } 
/* 1808 */     mb.setMissions(ml);
/*      */     
/* 1810 */     return mb;
/*      */   }
/*      */ 
/*      */   
/*      */   public static JRMCoreMsnBundle msnGenNC() {
/* 1815 */     initNC();
/* 1816 */     int NCmainSagaLength = allMsnNC;
/* 1817 */     JRMCoreMsnBundle mb = new JRMCoreMsnBundle();
/*      */     
/* 1819 */     mb.setName("Naruto C Main Saga");
/* 1820 */     mb.setDesc("An alternate story for the Naruto C mod based off on the Naruto series.");
/* 1821 */     mb.setAuthor("JinRyuu, Ben");
/* 1822 */     mb.setVersion("0.5");
/* 1823 */     mb.setMods("NC");
/* 1824 */     mb.settings.repeat = "0";
/* 1825 */     mb.settings.unlock = "";
/* 1826 */     mb.settings.vars = "";
/* 1827 */     ArrayList<JRMCoreMsn> ml = new ArrayList<JRMCoreMsn>();
/* 1828 */     JRMCoreMsn m = new JRMCoreMsn();
/* 1829 */     for (int i = 0; i < NCmainSagaLength; i++) {
/*      */       
/* 1831 */       m = new JRMCoreMsn();
/* 1832 */       m.setId(i);
/* 1833 */       m.setTranslated(true);
/* 1834 */       ArrayList<String> l = Lists.newArrayList();
/*      */       
/* 1836 */       m.setProps(al(new String[] { NCmainSagaProps.get(Integer.valueOf(i)) }));
/* 1837 */       m.setAlign(al(new String[] { "neutral" }));
/* 1838 */       m.setTitle(al(new String[] { NCmainSagaArcs.get(Integer.valueOf(i)) }));
/* 1839 */       m.setSubtitle(al(new String[] { "nc.sagasystem." + i + ".title" }));
/* 1840 */       m.setDescription(al(new String[] { "nc.sagasystem." + i + ".desc" }));
/* 1841 */       m.setObjectives(al((ArrayList<String>[])new ArrayList[] { NCmainSagaObjs.get(Integer.valueOf(i)) }));
/* 1842 */       m.setRewards(al((ArrayList<String>[])new ArrayList[] { NCmainSagaRwrds.get(Integer.valueOf(i)) }));
/*      */       
/* 1844 */       ml.add(m);
/*      */     } 
/* 1846 */     mb.setMissions(ml);
/*      */     
/* 1848 */     return mb;
/*      */   }
/*      */ 
/*      */   
/*      */   public static JRMCoreMsnBundle missionSideDBSBroly() {
/* 1853 */     initDBCDBSBroly();
/* 1854 */     int missionsLength = allMissionsDBSBroly;
/* 1855 */     JRMCoreMsnBundle mb = new JRMCoreMsnBundle();
/* 1856 */     mb.setName("Dragon Block C - DBS Broly Movie");
/* 1857 */     mb.setDesc("An alternate story for the DBC mod based off on the Dragon Ball Super Broly movie.");
/* 1858 */     mb.setAuthor("Ben");
/* 1859 */     mb.setVersion("1.0");
/* 1860 */     mb.setMods("DBC");
/* 1861 */     mb.settings.repeat = "0";
/* 1862 */     mb.settings.unlock = "";
/* 1863 */     mb.settings.vars = "";
/* 1864 */     ArrayList<JRMCoreMsn> ml = new ArrayList<JRMCoreMsn>();
/* 1865 */     JRMCoreMsn m = new JRMCoreMsn();
/*      */     
/* 1867 */     for (int i = 0; i < missionsLength; i++) {
/*      */       
/* 1869 */       m = new JRMCoreMsn();
/* 1870 */       m.setId(i);
/* 1871 */       m.setTranslated(true);
/*      */ 
/*      */       
/* 1874 */       m.setProps(al(new String[] { "default" }));
/* 1875 */       m.setAlign(al(new String[] { "neutral" }));
/* 1876 */       m.setTitle(al(new String[] { "dbc.sagadbsbroly.dbsbroly" }));
/* 1877 */       m.setSubtitle(al(new String[] { "dbc.sagadbsbroly." + i + ".title" }));
/* 1878 */       m.setDescription(al(new String[] { "dbc.sagadbsbroly." + i + ".desc" }));
/* 1879 */       m.setObjectives(al((ArrayList<String>[])new ArrayList[] { DBCDBSBrolyObjs.get(Integer.valueOf(i)) }));
/* 1880 */       m.setRewards(al((ArrayList<String>[])new ArrayList[] { DBCDBSBrolyRwrds.get(Integer.valueOf(i)) }));
/*      */       
/* 1882 */       ml.add(m);
/*      */     } 
/* 1884 */     mb.setMissions(ml);
/*      */     
/* 1886 */     return mb;
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreMm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */