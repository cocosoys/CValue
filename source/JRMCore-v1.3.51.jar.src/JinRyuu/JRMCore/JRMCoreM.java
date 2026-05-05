/*      */ package JinRyuu.JRMCore;
/*      */ 
/*      */ import JinRyuu.JRMCore.p.JRMCorePData2;
/*      */ import JinRyuu.JRMCore.p.PD;
/*      */ import com.google.common.collect.Lists;
/*      */ import com.google.gson.Gson;
/*      */ import com.google.gson.GsonBuilder;
/*      */ import com.google.gson.reflect.TypeToken;
/*      */ import com.google.gson.stream.JsonReader;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileReader;
/*      */ import java.io.FileWriter;
/*      */ import java.io.IOException;
/*      */ import java.io.Writer;
/*      */ import java.lang.reflect.Type;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.world.WorldProvider;
/*      */ import net.minecraftforge.common.DimensionManager;
/*      */ import org.apache.commons.io.FileUtils;
/*      */ import org.apache.commons.lang3.math.NumberUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JRMCoreM
/*      */ {
/*   46 */   public static HashMap<String, JRMCoreMsnBundle> missions = new HashMap<String, JRMCoreMsnBundle>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   52 */   public static HashMap<String, JRMCoreMsn> missionsC = new HashMap<String, JRMCoreMsn>();
/*      */ 
/*      */   
/*   55 */   public static HashMap<String, ArrayList<String>> missionsCD = new HashMap<String, ArrayList<String>>();
/*      */   
/*      */   public static final int MISSION_INFO_SeID = 0;
/*      */   
/*      */   public static final int MISSION_INFO_Name = 1;
/*      */   
/*      */   public static final int MISSION_INFO_Desc = 2;
/*      */   
/*      */   public static final int MISSION_INFO_Auth = 3;
/*      */   
/*      */   public static final int MISSION_INFO_Vers = 4;
/*      */   
/*      */   public static final int MISSION_INFO_Mods = 5;
/*      */   
/*      */   public static final int MISSION_INFO_Rept = 6;
/*      */   
/*      */   public static final int MISSION_INFO_Unlo = 7;
/*      */   
/*      */   public static final String SERIES_DBC_MainID = "mainDBC";
/*      */   public static final String SERIES_DBC_DBSBrolyID = "dbcDBCBroly";
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
/*      */   public static final String MISSION_PROP_RandomReward = "randrew";
/*      */   public static final String REWARD_TYPE_NOTHING = "nothing";
/*      */   public static final String REWARD_TYPE_Item = "item";
/*      */   public static final String REWARD_TYPE_TP = "tp";
/*      */   public static final String REWARD_TYPE_Alignment = "align";
/*      */   public static final String REWARD_TYPE_Command = "com";
/*      */   public static final String REWARD_TYPE_TP_FIX = "fix";
/*      */   public static final String REWARD_TYPE_TP_ALIGN = "align";
/*      */   public static final String REWARD_TYPE_TP_LVL = "lvl";
/*      */   public static final String REWARD_TYPE_TP_LVLALIGN = "lvlalign";
/*      */   
/*      */   public static void msnGenWrt(File dbcMain, Object mb) {
/*      */     try {
/*  103 */       dbcMain.getParentFile().mkdirs();
/*  104 */       dbcMain.createNewFile();
/*  105 */       Writer writer = new FileWriter(dbcMain);
/*      */       
/*  107 */       Gson gson = (new GsonBuilder()).enableComplexMapKeySerialization().setPrettyPrinting().create();
/*      */       
/*  109 */       gson.toJson(mb, JSN_TYPE_MSNbndl, writer);
/*  110 */       writer.flush();
/*  111 */       writer.close();
/*  112 */     } catch (IOException e) {
/*  113 */       e.printStackTrace();
/*      */     } 
/*      */   }
/*      */   public static final int SYNC_DataVersion_ServerID = 0; public static final int SYNC_DataVersion_Version = 1; public static final int SYNC_DataVersion_Repeat = 2; public static final int SYNC_DataVersion_CompleteCounter = 3;
/*  117 */   public static final Type JSN_TYPE_MSNbndl = (new TypeToken<JRMCoreMsnBundle>() {  }).getType(); public static final int SYNC_DataVersion_CompleteCounterLatestVersionOnly = 4; public static final int SYNC_COND_SeriesID = 0;
/*      */   public static final int SYNC_COND_MissionID = 1;
/*  119 */   public static final Type JSN_TYPE_MSN = (new TypeToken<JRMCoreMsn>() {  }).getType(); public static final int SYNC_COND_Started = 2; public static final int SYNC_COND_data1 = 3; public static final int SYNC_COND_data2 = 4; public static final int SYNC_COND_data3 = 5;
/*      */   public static final int SYNC_COND_data4 = 6;
/*      */   public static final String MISSION_CONDS_TYPE = "0";
/*      */   public static final String MISSION_CONDS_Name = "N";
/*      */   
/*      */   public static JRMCoreMsnBundle rd(File file) {
/*      */     try {
/*  126 */       Gson gson = new Gson();
/*  127 */       JsonReader reader = new JsonReader(new FileReader(file));
/*  128 */       JRMCoreMsnBundle data = (JRMCoreMsnBundle)gson.fromJson(reader, JSN_TYPE_MSNbndl);
/*  129 */       return data;
/*      */     }
/*  131 */     catch (FileNotFoundException e) {
/*  132 */       e.printStackTrace();
/*      */       
/*  134 */       return null;
/*      */     } 
/*      */   }
/*      */   public static final String MISSION_CONDS_Health = "H"; public static final String MISSION_CONDS_Attack = "A"; public static final String MISSION_CONDS_Amount = "M"; public static final String MISSION_CONDS_MsgSpawn = "S"; public static final String MISSION_CONDS_MsgDeath = "D"; public static final String MISSION_CONDS_Message = "G";
/*      */   public static final String MISSION_CONDS_MsgBtn = "B";
/*      */   
/*      */   public static void om(MinecraftServer s) {
/*  141 */     if (s != null && s.field_71305_c.length > 0 && s
/*      */       
/*  143 */       .func_71218_a(0) != null && s
/*  144 */       .func_71218_a(0).getChunkSaveLocation() != null) {
/*  145 */       String pnt = s.func_71218_a(0).getChunkSaveLocation() + "/data/missions";
/*      */       
/*  147 */       File entitylist = new File(pnt, "EntityList.txt");
/*  148 */       entitylist.delete();
/*      */       try {
/*  150 */         ArrayList<String> ar = Lists.newArrayList();
/*  151 */         for (Iterator<String> iterator = EntityList.field_75625_b.keySet().iterator(); iterator.hasNext(); ) {
/*  152 */           String n = iterator.next();
/*  153 */           Class<?> c = (Class)EntityList.field_75625_b.get(n);
/*  154 */           if (EntityLivingBase.class.isAssignableFrom(c)) {
/*  155 */             ar.add(n);
/*      */           }
/*      */         } 
/*  158 */         Collections.sort(ar);
/*  159 */         String str = "";
/*  160 */         for (int i = 0; i < ar.size(); i++) {
/*  161 */           str = str + (String)ar.get(i) + "\n";
/*      */         }
/*  163 */         FileUtils.writeStringToFile(entitylist, str);
/*  164 */       } catch (IOException e1) {
/*  165 */         e1.printStackTrace();
/*      */       } 
/*      */ 
/*      */       
/*  169 */       File dbcMain = new File(pnt, "mainDBC.json");
/*  170 */       JRMCoreMsnBundle msb = JRMCoreMm.msnGen();
/*      */ 
/*      */       
/*  173 */       File dbcDBSBroly = new File(pnt, "dbcDBCBroly.json");
/*  174 */       JRMCoreMsnBundle missionSideDBSBroly = JRMCoreMm.missionSideDBSBroly();
/*      */ 
/*      */ 
/*      */       
/*  178 */       File ncMain = new File(pnt, "mainNC.json");
/*  179 */       JRMCoreMsnBundle msbNC = JRMCoreMm.msnGenNC();
/*      */ 
/*      */ 
/*      */       
/*  183 */       missions.clear();
/*  184 */       File dir = new File(pnt);
/*  185 */       File[] list = dir.listFiles();
/*      */       
/*  187 */       if (dir != null && list != null && list.length > 0) {
/*      */ 
/*      */         
/*  190 */         if (!dbcMain.exists()) {
/*  191 */           msnGenWrt(dbcMain, msb);
/*  192 */           missions.put("mainDBC", msb);
/*      */         } else {
/*  194 */           JRMCoreMsnBundle rms = rd(dbcMain);
/*  195 */           missions.put("mainDBC", msb.getVersion().equalsIgnoreCase(msb.getVersion()) ? rms : msb);
/*      */         } 
/*      */ 
/*      */         
/*  199 */         if (!dbcDBSBroly.exists()) {
/*  200 */           msnGenWrt(dbcDBSBroly, missionSideDBSBroly);
/*  201 */           missions.put("dbcDBCBroly", missionSideDBSBroly);
/*      */         } else {
/*  203 */           JRMCoreMsnBundle rms = rd(dbcDBSBroly);
/*  204 */           missions.put("dbcDBCBroly", missionSideDBSBroly.getVersion().equalsIgnoreCase(missionSideDBSBroly.getVersion()) ? rms : missionSideDBSBroly);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  209 */         if (!ncMain.exists()) {
/*  210 */           msnGenWrt(ncMain, msbNC);
/*  211 */           missions.put("mainNC", msbNC);
/*      */         } else {
/*  213 */           JRMCoreMsnBundle rms = rd(ncMain);
/*  214 */           missions.put("mainNC", msbNC.getVersion().equalsIgnoreCase(msbNC.getVersion()) ? rms : msbNC);
/*      */         } 
/*      */         
/*  217 */         for (int i = 0; i < list.length; i++) {
/*  218 */           String mss = list[i].getName();
/*  219 */           if (mss.endsWith(".json")) {
/*  220 */             mss = mss.replace(".json", "");
/*  221 */             if (!mss.equalsIgnoreCase("mainDBC") && !mss.equalsIgnoreCase("mainNC")) {
/*  222 */               missions.put(mss, rd(list[i]));
/*      */             }
/*      */           }
/*      */         
/*      */         } 
/*      */       } else {
/*      */         
/*  229 */         if (!dbcMain.exists()) {
/*  230 */           msnGenWrt(dbcMain, msb);
/*  231 */           missions.put("mainDBC", msb);
/*      */         } else {
/*  233 */           JRMCoreMsnBundle rms = rd(dbcMain);
/*  234 */           missions.put("mainDBC", msb.getVersion().equalsIgnoreCase(msb.getVersion()) ? rms : msb);
/*      */         } 
/*      */         
/*  237 */         if (!dbcDBSBroly.exists()) {
/*  238 */           msnGenWrt(dbcDBSBroly, missionSideDBSBroly);
/*  239 */           missions.put("dbcDBCBroly", missionSideDBSBroly);
/*      */         } else {
/*  241 */           JRMCoreMsnBundle rms = rd(dbcDBSBroly);
/*  242 */           missions.put("dbcDBCBroly", missionSideDBSBroly.getVersion().equalsIgnoreCase(missionSideDBSBroly.getVersion()) ? rms : missionSideDBSBroly);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  247 */         if (!ncMain.exists()) {
/*  248 */           msnGenWrt(ncMain, msbNC);
/*  249 */           missions.put("mainNC", msbNC);
/*      */         } else {
/*  251 */           JRMCoreMsnBundle rms = rd(ncMain);
/*  252 */           missions.put("mainNC", msbNC.getVersion().equalsIgnoreCase(msbNC.getVersion()) ? rms : msbNC);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public static final String MISSION_CONDS_Protect = "P"; public static final String MISSION_CONDS_NoSpawn = "W"; public static final String MISSION_TalkTo_Series = "series"; public static final String MISSION_TalkTo_translated = "translated"; public static final String MISSION_CONDS_Transformations = "T"; public static final String MISSION_CONDS_MsgSpawnSnd = "O";
/*      */   public static final String MISSION_CONDS_MsgDeathSnd = "U";
/*      */   
/*      */   public static String[] getSyda(String s) {
/*  261 */     return s.split(";");
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getSyda(String s, String sid) {
/*  266 */     String[] s1 = getSyda(s);
/*  267 */     for (int i = 0; i < s1.length; i++) {
/*  268 */       String[] sd = s1[i].split(",");
/*  269 */       if (sd[0].equalsIgnoreCase(sid)) {
/*  270 */         return s1[i];
/*      */       }
/*      */     } 
/*  273 */     return "";
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getSydaAmount(String s) {
/*  278 */     return (getSyda(s)).length;
/*      */   }
/*      */   public static int getSydaAmountFromData1(String s) {
/*  281 */     return (getSyda(s)).length - 3;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] getMda(String s, int i) {
/*  286 */     if (i >= 0) {
/*  287 */       return getSyda(s)[i].split(",");
/*      */     }
/*  289 */     return new String[] { "", "", "" };
/*      */   }
/*      */   
/*      */   public static String[] getMda(String s, String i) {
/*  293 */     return getSyda(s, i).split(",");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getMda_Con(String s, int i, int a) {
/*  299 */     String[] ar = getMda(s, i);
/*  300 */     if (ar.length > a) {
/*  301 */       return ar[a];
/*      */     }
/*  303 */     return "";
/*      */   }
/*      */   public static String getMda_Con(String[] ar, int a) {
/*  306 */     if (ar.length > a) {
/*  307 */       return ar[a];
/*      */     }
/*  309 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getMda_Series(String s, int i) {
/*  315 */     return getMda(s, i)[0];
/*      */   }
/*      */   
/*      */   public static int getMda_Mission(String s, int i) {
/*  319 */     return Integer.parseInt(getMda(s, i)[1]);
/*      */   }
/*      */   
/*      */   public static int getMda_Mission(String s, String i) {
/*  323 */     return Integer.parseInt(getMda(s, i)[1]);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isUnlocked(String sidd, String MSD, String MSDV) {
/*  328 */     if (sidd.contains(":")) {
/*  329 */       String[] nm = sidd.split(":");
/*  330 */       String[] arrayOfString1 = getMda(MSDV, nm[0]);
/*  331 */       String str = getSydaV(arrayOfString1, 4);
/*  332 */       int ps = getMda_Mission(MSD, nm[0]);
/*  333 */       return (!str.equals("0") || (str.equals("0") && ps > Integer.parseInt(nm[1])));
/*      */     } 
/*  335 */     String[] sydaV = getMda(MSDV, sidd);
/*  336 */     String ccv = getSydaV(sydaV, 4);
/*  337 */     return !ccv.equals("0");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String setSydaV(String msdv, String sid, String ver, String rep, String cc, String ccv) {
/*  348 */     String[] sda = getSyda(msdv);
/*  349 */     String tr = "";
/*  350 */     boolean hi = false;
/*      */     
/*  352 */     if (msdv.length() > 3) {
/*  353 */       for (int i = 0; i < sda.length; i++) {
/*  354 */         String[] ds = sda[i].split(",");
/*  355 */         if (sid.equalsIgnoreCase(ds[0])) {
/*  356 */           tr = tr + ";" + sid + "," + ver + "," + rep + "," + cc + "," + ccv;
/*  357 */           hi = true;
/*      */         }
/*  359 */         else if (ds.length > 3) {
/*  360 */           tr = tr + ";" + ds[0] + "," + ds[1] + "," + ds[2] + "," + ds[3] + "," + ds[4];
/*      */         } else {
/*  362 */           tr = tr + ";" + ds[0] + "," + ds[1] + "," + Character.MIN_VALUE + "," + Character.MIN_VALUE + "," + Character.MIN_VALUE;
/*      */         } 
/*      */       } 
/*      */     }
/*  366 */     if (!hi) tr = tr + ";" + sid + "," + ver + "," + Character.MIN_VALUE + "," + Character.MIN_VALUE + "," + Character.MIN_VALUE; 
/*  367 */     return tr.substring(1);
/*      */   }
/*      */   
/*      */   public static String setSyda(String msd, String sid, int mid, int sz, int dc, String ds) {
/*  371 */     String[] ar = new String[sz];
/*  372 */     boolean mk = false; int i;
/*  373 */     for (i = 0; i < ar.length; i++) {
/*  374 */       String[] mda = getMda(msd, sid);
/*  375 */       int scd = SYNC_COND_data(i);
/*  376 */       if (mda.length > scd) {
/*  377 */         ar[i] = (i == dc) ? ds : mda[scd];
/*      */       } else {
/*  379 */         mk = true;
/*      */         break;
/*      */       } 
/*      */     } 
/*  383 */     if (mk) {
/*  384 */       ar = new String[sz];
/*  385 */       for (i = 0; i < sz; i++) {
/*  386 */         ar[i] = "0";
/*      */       }
/*      */     } 
/*      */     
/*  390 */     return setSyda(msd, sid, mid, ar);
/*      */   }
/*      */   
/*      */   public static String setSyda(String sd, String sid, int mid, String... v) {
/*  394 */     String d = "";
/*  395 */     String[] sda = getSyda(sd);
/*  396 */     int asid = 0;
/*  397 */     int i = -1;
/*      */     int j;
/*  399 */     for (j = 0; j < sda.length; j++) {
/*  400 */       String csid = getMda_Series(sd, j);
/*      */       
/*  402 */       asid++;
/*  403 */       if (csid.equals(sid) && asid == 1) {
/*  404 */         i = j;
/*      */       }
/*      */     } 
/*      */     
/*  408 */     for (j = 0; j < sda.length; j++) {
/*  409 */       if (i == j) {
/*  410 */         d = d + ";" + parse_Mda(sid, mid, v);
/*  411 */       } else if (sda[j].length() > 3) {
/*  412 */         d = d + ";" + sda[j];
/*      */       } 
/*      */     } 
/*      */     
/*  416 */     if (i == -1) {
/*  417 */       d = d + ";" + parse_Mda(sid, mid, v);
/*      */     }
/*      */     
/*  420 */     sd = (d.length() > 3) ? d.substring(1, d.length()) : d;
/*      */     
/*  422 */     if (asid > 1) {
/*  423 */       d = "";
/*  424 */       sda = getSyda(sd);
/*  425 */       asid = 0;
/*  426 */       for (j = 0; j < sda.length; j++) {
/*  427 */         String csid = getMda_Series(sd, j);
/*  428 */         if (csid.equals(sid)) {
/*  429 */           asid++;
/*      */         }
/*  431 */         if (asid <= 1 && sda[j].length() > 3) {
/*  432 */           d = d + ";" + sda[j];
/*      */         }
/*      */       } 
/*  435 */       sd = (d.length() > 3) ? d.substring(1, d.length()) : d;
/*      */     } 
/*  437 */     return sd;
/*      */   }
/*      */   public static String parse_Mda(String sid, int mid, String... v) {
/*  440 */     String r = sid + "," + mid;
/*  441 */     for (int i = 0; i < v.length; i++) {
/*  442 */       r = r + "," + v[i];
/*      */     }
/*  444 */     return r;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMda_SeriesByID(String s, String i) {
/*  451 */     for (int j = 0; j < getSydaAmount(s); j++) {
/*  452 */       if (getMda(s, j)[0].equalsIgnoreCase(i)) {
/*  453 */         return j;
/*      */       }
/*      */     } 
/*  456 */     return -1;
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
/*      */   public static int SYNC_COND_data(int c) {
/*  468 */     return 2 + c;
/*      */   }
/*      */   
/*      */   public static int SYNC_COND_data_REV(int c) {
/*  472 */     return c - 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getSycoDaam(String s) {
/*  481 */     if (s.equalsIgnoreCase("kill")) return 1; 
/*  482 */     if (s.equalsIgnoreCase("killsame")) return 1; 
/*  483 */     if (s.equalsIgnoreCase("biome")) return 1; 
/*  484 */     if (s.equalsIgnoreCase("dim")) return 1; 
/*  485 */     if (s.equalsIgnoreCase("item")) return 1;
/*      */ 
/*      */     
/*  488 */     return 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String[] getMCo_parse(String s) {
/*  493 */     return s.split(";");
/*      */   }
/*      */   public static String getMCo_type(String s) {
/*  496 */     String[] p = getMCo_parse(s);
/*  497 */     return p[0];
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
/*      */   public static String getMCo_data(String s, String a) {
/*  522 */     String[] p = getMCo_parse(s);
/*  523 */     if (a.equals("0")) return p[0]; 
/*  524 */     for (int i = 0; i < p.length; i++) {
/*  525 */       if (p[i].toUpperCase().startsWith(a)) {
/*  526 */         return p[i].substring(1);
/*      */       }
/*      */     } 
/*  529 */     return "";
/*      */   }
/*      */   public static int getMCo_dataI(String s, String a) {
/*  532 */     String n = getMCo_data(s, a);
/*  533 */     if (NumberUtils.isNumber(n))
/*  534 */       return Integer.parseInt(n); 
/*  535 */     return 0;
/*      */   }
/*      */   public static double getMCo_dataD(String s, String a) {
/*  538 */     String n = getMCo_data(s, a);
/*  539 */     if (NumberUtils.isNumber(n))
/*  540 */       return Double.parseDouble(getMCo_data(s, n)); 
/*  541 */     return 0.0D;
/*      */   }
/*      */   
/*      */   public static String[] getMCo_TranSplit(String s) {
/*  545 */     return s.split("\\|\\|");
/*      */   }
/*      */   
/*      */   public static String getBtn(String s) {
/*  549 */     if (s.equalsIgnoreCase("next"))
/*  550 */       return JRMCoreH.trl("jrmc", "Next"); 
/*  551 */     if (s.equalsIgnoreCase("start"))
/*  552 */       return JRMCoreH.trl("jrmc", "start"); 
/*  553 */     if (s.equalsIgnoreCase("skip"))
/*  554 */       return JRMCoreH.trl("jrmc", "Skip"); 
/*  555 */     if (s.equalsIgnoreCase("restart"))
/*  556 */       return JRMCoreH.trl("jrmc", "Restart"); 
/*  557 */     return s;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean getMda_btn_Start(ArrayList<String> a, String[] s, int g) {
/*  563 */     int size = a.size();
/*  564 */     if (size == 1 && (((String)a.get(0)).equalsIgnoreCase("next") || ((String)a.get(0)).equalsIgnoreCase("start")))
/*  565 */       return s[2].equals("0"); 
/*  566 */     if (size == 1 && (((String)a.get(0)).equalsIgnoreCase("skip") || ((String)a.get(0)).equalsIgnoreCase("restart"))) {
/*  567 */       return true;
/*      */     }
/*  569 */     int inB = 0;
/*  570 */     int inD = 0;
/*  571 */     boolean all = false;
/*  572 */     boolean cont = true;
/*  573 */     int i = 1;
/*  574 */     for (int j = 1; j < a.size(); j++) {
/*  575 */       String os = a.get(j);
/*  576 */       String t = getMCo_type(os);
/*  577 */       if (cont && t.equalsIgnoreCase("kill")) {
/*  578 */         all = (s[2].equals("0") && s[SYNC_COND_data(i)].equals("0"));
/*  579 */         boolean spwn = getMCo_data(os, "P").equalsIgnoreCase("spwn");
/*  580 */         if (spwn) return false; 
/*  581 */         if (all) return all; 
/*  582 */       } else if (cont && t.equalsIgnoreCase("killsame")) {
/*  583 */         int da = (int)(getMCo_dataI(os, "M") * gm(g));
/*  584 */         all = (s[2].equals("0") && da > Integer.parseInt(s[SYNC_COND_data(i)]));
/*  585 */         boolean spwn = getMCo_data(os, "P").equalsIgnoreCase("spwn");
/*  586 */         if (spwn) return false; 
/*  587 */         if (all) return all; 
/*  588 */       } else if (t.equalsIgnoreCase("biome2")) {
/*  589 */         all = s[SYNC_COND_data(i)].equals("1");
/*  590 */         inB = all ? 1 : 2;
/*  591 */       } else if (t.equalsIgnoreCase("dim2")) {
/*  592 */         all = s[SYNC_COND_data(i)].equals("1");
/*  593 */         inD = all ? 1 : 2;
/*      */       } 
/*  595 */       cont = ((inB == 0 || inB == 1) && (inD == 0 || inD == 1));
/*  596 */       i++;
/*      */     } 
/*  598 */     return all;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String GetWorldNameFromCurDim(int i) {
/*  604 */     WorldProvider p = DimensionManager.createProviderFor(i);
/*  605 */     return (p != null) ? p.func_80007_l() : ("Id " + i);
/*      */   }
/*      */   
/*      */   public static HashMap<String, String> getMda_Obj_TalkTo() {
/*  609 */     HashMap<String, String> h = null;
/*      */     
/*  611 */     String msd = JRMCoreH.MSD;
/*  612 */     for (Iterator<String> iterator = missionsC.keySet().iterator(); iterator.hasNext(); ) {
/*  613 */       String seriesID = iterator.next();
/*      */       
/*  615 */       int MsnID = 0;
/*  616 */       if (msd.length() > 3) {
/*  617 */         MsnID = getMda_Mission(msd, seriesID);
/*      */       }
/*  619 */       JRMCoreMsn msn = missionsC.get(seriesID);
/*  620 */       int nr = 0;
/*  621 */       if (msn != null && msn.getId() == MsnID) {
/*  622 */         ArrayList<String> a = msn.getObjectives(JRMCoreH.Pwrtyp, JRMCoreH.Race, JRMCoreH.Class);
/*  623 */         String btnN = a.get(0);
/*  624 */         String[] syncMda = getMda(msd, seriesID);
/*  625 */         if (syncMda.length > 1) {
/*  626 */           int size = a.size();
/*  627 */           if (syncMda.length > 3) {
/*  628 */             for (int i = 1; i < a.size(); i++) {
/*  629 */               String os = a.get(i);
/*  630 */               String t = getMCo_type(os);
/*  631 */               if (os != null && t.equalsIgnoreCase("talk")) {
/*  632 */                 if (syncMda[SYNC_COND_data(i)].equals("1")) return null; 
/*  633 */                 h = new HashMap<String, String>();
/*  634 */                 h.put("N", getMCo_data(os, "N"));
/*  635 */                 h.put("G", getMCo_data(os, "G"));
/*  636 */                 h.put("B", getMCo_data(os, "B"));
/*  637 */                 h.put("translated", "" + msn.isTranslated());
/*  638 */                 h.put("series", seriesID);
/*  639 */                 return h;
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  646 */     return null;
/*      */   }
/*      */   
/*      */   public static float gm(int s) {
/*  650 */     return 1.0F + ((s > 0) ? (s * 0.5F - 0.5F) : 0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean getMda_ObjComp_all(ArrayList<String> a, String[] s, int g) {
/*  655 */     int size = a.size();
/*  656 */     if (size == 1 && (((String)a.get(0)).equalsIgnoreCase("next") || ((String)a.get(0)).equalsIgnoreCase("start")))
/*  657 */       return s[2].equals("1"); 
/*  658 */     if (size == 1 && ((String)a.get(0)).equalsIgnoreCase("skip"))
/*  659 */       return true; 
/*  660 */     if (s.length > 3) {
/*  661 */       boolean all = true;
/*  662 */       for (int i = 1; i < a.size(); i++) {
/*  663 */         String os = a.get(i);
/*  664 */         String t = getMCo_type(os);
/*  665 */         int scd = SYNC_COND_data(i);
/*  666 */         if (s.length <= scd) {
/*  667 */           all = true;
/*      */           break;
/*      */         } 
/*  670 */         if (t.equalsIgnoreCase("kill")) {
/*  671 */           all = s[scd].equals("1");
/*  672 */         } else if (t.equalsIgnoreCase("killsame")) {
/*  673 */           int d1 = (int)(getMCo_dataI(os, "M") * gm(g));
/*  674 */           all = (Integer.parseInt(s[scd]) >= d1);
/*  675 */         } else if (t.equalsIgnoreCase("item")) {
/*  676 */           int d1 = (int)(getMCo_dataI(os, "M") * gm(g));
/*  677 */           all = (Integer.parseInt(s[scd]) >= d1);
/*  678 */         } else if (t.equalsIgnoreCase("biome")) {
/*  679 */           all = s[scd].equals("1");
/*  680 */         } else if (t.equalsIgnoreCase("dim")) {
/*  681 */           all = s[scd].equals("1");
/*      */         }
/*  683 */         else if (t.equalsIgnoreCase("talk")) {
/*  684 */           all = s[scd].equals("1");
/*  685 */         } else if (t.equalsIgnoreCase("state")) {
/*  686 */           String d1 = getMCo_data(os, "N");
/*  687 */           all = s[scd].equalsIgnoreCase(d1);
/*  688 */         } else if (t.equalsIgnoreCase("biome2")) {
/*  689 */           all = s[scd].equals("1");
/*  690 */         } else if (t.equalsIgnoreCase("dim2")) {
/*  691 */           all = s[scd].equals("1");
/*  692 */         } else if (t.equalsIgnoreCase("lvl")) {
/*  693 */           int d1 = getMCo_dataI(os, "M");
/*  694 */           all = (Integer.parseInt(s[scd]) >= d1);
/*  695 */         } else if (t.equalsIgnoreCase("skip")) {
/*  696 */           all = true;
/*      */         } 
/*  698 */         if (!all)
/*      */           break; 
/*      */       } 
/*  701 */       return all;
/*      */     } 
/*  703 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getMCo_readable(String os, String nss, int g) {
/*  710 */     String t = getMCo_type(os).toLowerCase();
/*  711 */     String nm = getMCo_data(os, "N");
/*      */ 
/*      */     
/*  714 */     if (t.equalsIgnoreCase("kill")) {
/*  715 */       boolean any = getMCo_data(os, "P").equalsIgnoreCase("no");
/*  716 */       boolean spwn = getMCo_data(os, "P").equalsIgnoreCase("spwn");
/*  717 */       Entity e = EntityList.func_75620_a(nm, null);
/*  718 */       String en = (e != null) ? e.func_70005_c_() : "ERROR";
/*  719 */       String kld = nss.equals("1") ? JRMCoreH.trl("jrmc", "missionObjType.defeated") : ("" + ((gm(g) > 1.0F) ? (" (x" + gm(g) + ")") : ""));
/*  720 */       return JRMCoreH.trl("jrmc", "missionObjType." + t + (any ? "" : ""), new Object[] { en, kld }) + ((any || spwn) ? JRMCoreH.trl("jrmc", "missionObjType.anywilldo") : "");
/*  721 */     }  if (t.equalsIgnoreCase("killsame") && nss.length() > 0) {
/*  722 */       boolean any = getMCo_data(os, "P").equalsIgnoreCase("no");
/*  723 */       boolean spwn = getMCo_data(os, "P").equalsIgnoreCase("spwn");
/*  724 */       int am = (int)(getMCo_dataI(os, "M") * gm(g));
/*  725 */       Entity e = EntityList.func_75620_a(nm, null);
/*  726 */       String en = (e != null) ? e.func_70005_c_() : "ERROR";
/*  727 */       String kld = (Integer.parseInt(nss) >= am) ? JRMCoreH.trl("jrmc", "missionObjType.completed") : (" - " + nss + "/" + am + ((gm(g) > 1.0F) ? (" (x" + gm(g) + ")") : ""));
/*  728 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { en, kld }) + ((any || spwn) ? JRMCoreH.trl("jrmc", "missionObjType.anywilldo") : "");
/*  729 */     }  if (t.equalsIgnoreCase("item") && nss.length() > 0) {
/*  730 */       int am = (int)(getMCo_dataI(os, "M") * gm(g));
/*  731 */       String[] nm2 = nm.split("::");
/*  732 */       Item i = JRMCoreH.getItemByText((nm2.length > 1) ? nm2[0] : nm);
/*  733 */       if (i != null) {  } else {  }  ItemStack is = null;
/*  734 */       String en = (i != null) ? is.func_77977_a() : "ERROR";
/*  735 */       String kld = (Integer.parseInt(nss) >= am) ? JRMCoreH.trl("jrmc", "missionObjType.completed") : (" - " + nss + "/" + am + ((gm(g) > 1.0F) ? (" (x" + gm(g) + ")") : ""));
/*  736 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { JRMCoreH.trl(en + ".name"), kld });
/*  737 */     }  if (t.equalsIgnoreCase("biome")) {
/*  738 */       String kld = nss.equals("1") ? JRMCoreH.trl("jrmc", "missionObjType.completed") : "";
/*  739 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { nm, kld });
/*  740 */     }  if (t.equalsIgnoreCase("dim")) {
/*  741 */       if (NumberUtils.isNumber(nm)) nm = GetWorldNameFromCurDim(Integer.parseInt(nm)); 
/*  742 */       String kld = nss.equals("1") ? JRMCoreH.trl("jrmc", "missionObjType.completed") : "";
/*  743 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { nm, kld });
/*      */     } 
/*  745 */     if (t.equalsIgnoreCase("talk")) {
/*  746 */       String en = EntityList.func_75620_a(nm, null).func_70005_c_();
/*  747 */       String kld = nss.equals("1") ? JRMCoreH.trl("jrmc", "missionObjType.completed") : "";
/*  748 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { en, kld });
/*  749 */     }  if (t.equalsIgnoreCase("state")) {
/*  750 */       String kld = nss.equalsIgnoreCase(nm) ? JRMCoreH.trl("jrmc", "missionObjType.completed") : "";
/*  751 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { nm, kld });
/*  752 */     }  if (t.equalsIgnoreCase("biome2")) {
/*  753 */       String kld = nss.equals("1") ? JRMCoreH.trl("jrmc", "missionObjType.completed") : "";
/*  754 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { nm, kld });
/*  755 */     }  if (t.equalsIgnoreCase("dim2")) {
/*  756 */       if (NumberUtils.isNumber(nm)) nm = GetWorldNameFromCurDim(Integer.parseInt(nm)); 
/*  757 */       String kld = nss.equals("1") ? JRMCoreH.trl("jrmc", "missionObjType.completed") : "";
/*  758 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { nm, kld });
/*  759 */     }  if (t.equalsIgnoreCase("lvl") && nss.length() > 0) {
/*  760 */       int am = getMCo_dataI(os, "M");
/*  761 */       String kld = (Integer.parseInt(nss) >= am) ? JRMCoreH.trl("jrmc", "missionObjType.completed") : "";
/*  762 */       return JRMCoreH.trl("jrmc", "missionObjType." + t, new Object[] { Integer.valueOf(am), kld });
/*      */     } 
/*      */     
/*  765 */     return JRMCoreH.trl("jrmc", "missionObjType.nothing");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getMAlgnmnt_Num(String s) {
/*  771 */     for (int i = 0; i < JRMCoreH.AlgnmntNms.length; i++) {
/*  772 */       if (JRMCoreH.AlgnmntNms[i].equalsIgnoreCase(s)) {
/*  773 */         return i;
/*      */       }
/*      */     } 
/*  776 */     return 1;
/*      */   }
/*      */   
/*      */   public static double getMultFor(Entity f, Entity t) {
/*  780 */     String mt = f.getEntityData().func_74779_i("jrmcSpawnInitiatedCMT");
/*  781 */     String[] amt = mt.split("\\|\\|");
/*  782 */     for (int i = 0; i < amt.length; i++) {
/*  783 */       String[] aamt = amt[i].split("\\|");
/*  784 */       if (aamt.length > 1 && aamt[0].equalsIgnoreCase(EntityList.func_75621_b(t))) {
/*  785 */         return Double.parseDouble(aamt[2]);
/*      */       }
/*      */     } 
/*  788 */     return 0.0D;
/*      */   }
/*      */   
/*      */   public static String[] getMobTranNext(String cmt, EntityLivingBase e) {
/*  792 */     String es = EntityList.func_75621_b((Entity)e);
/*  793 */     String[] amt = cmt.split("\\|\\|");
/*  794 */     int inTRLst = -1;
/*  795 */     for (int i = 0; i < amt.length; i++) {
/*  796 */       String[] aamt = amt[i].split("\\|");
/*  797 */       if (aamt.length > 1 && aamt[0].equalsIgnoreCase(es)) {
/*  798 */         inTRLst = i; break;
/*      */       } 
/*      */     } 
/*  801 */     if (cmt.length() > 2 && amt.length > inTRLst + 1) {
/*  802 */       return amt[inTRLst + 1].split("\\|");
/*      */     }
/*  804 */     return null;
/*      */   }
/*      */   public static String[] getMobTranDat(String cmt, EntityLivingBase e) {
/*  807 */     String es = EntityList.func_75621_b((Entity)e);
/*  808 */     String[] amt = cmt.split("\\|\\|");
/*  809 */     int inTRLst = -1;
/*  810 */     for (int i = 0; i < amt.length; i++) {
/*  811 */       String[] aamt = amt[i].split("\\|");
/*  812 */       if (aamt.length > 1 && aamt[0].equalsIgnoreCase(es)) {
/*  813 */         inTRLst = i; break;
/*      */       } 
/*      */     } 
/*  816 */     if (cmt.length() > 2 && inTRLst >= 0 && amt.length > inTRLst) {
/*  817 */       return amt[inTRLst].split("\\|");
/*      */     }
/*  819 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void prog(EntityPlayer Player, String sid, String v, String rp, String cc, String ccv) {
/*  828 */     MinecraftServer server1 = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  829 */     int gid = JRMCoreH.getInt(Player, "JRMCGID");
/*      */     
/*  831 */     if (gid != 0 && 
/*  832 */       (server1.func_71203_ab()).field_72404_b != null && (server1.func_71203_ab()).field_72404_b.size() > 0) {
/*  833 */       for (Object n : (server1.func_71203_ab()).field_72404_b) {
/*  834 */         EntityPlayer en = (EntityPlayer)n;
/*  835 */         if (en != Player) {
/*  836 */           int egid = JRMCoreH.getInt(en, "JRMCGID");
/*      */ 
/*      */           
/*  839 */           if (egid == gid) {
/*  840 */             NBTTagCompound nbt = JRMCoreH.nbt((Entity)en, "pres");
/*  841 */             String msdV = nbt.func_74779_i("JRMCmissionSyncVers");
/*  842 */             msdV = setSydaV(msdV, sid, v, rp, cc, ccv);
/*  843 */             nbt.func_74778_a("JRMCmissionSyncVers", msdV);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean prog(String msd, String sid, int mid) {
/*  854 */     if (msd.length() > 3)
/*  855 */       for (int i = 0; i < getSydaAmount(msd); i++) {
/*  856 */         String s = getMda_Series(msd, i);
/*  857 */         int m = getMda_Mission(msd, i);
/*  858 */         if (s.equals(sid) && mid == m) return true;
/*      */       
/*      */       }  
/*  861 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean prog(EntityPlayer en, String sid, int mid) {
/*  868 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)en, "pres");
/*  869 */     String msd = nbt.func_74779_i("JRMCmissionSync");
/*  870 */     if (msd.length() > 3)
/*  871 */       for (int i = 0; i < getSydaAmount(msd); i++) {
/*  872 */         String s = getMda_Series(msd, i);
/*  873 */         int m = getMda_Mission(msd, i);
/*  874 */         if (s.equals(sid) && mid == m) return true;
/*      */       
/*      */       }  
/*  877 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void prog(EntityPlayer Player, JRMCoreMsnBundle M, JRMCoreMsn msn, String str, List<JRMCoreMsn> msnl, String sid, int pw, int rc, int cl) {
/*  885 */     MinecraftServer server1 = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  886 */     int gid = JRMCoreH.getInt(Player, "JRMCGID");
/*  887 */     if (gid != 0)
/*      */     {
/*      */ 
/*      */       
/*  891 */       if ((server1.func_71203_ab()).field_72404_b != null && (server1.func_71203_ab()).field_72404_b.size() > 0) {
/*  892 */         for (Object n : (server1.func_71203_ab()).field_72404_b) {
/*  893 */           EntityPlayer en = (EntityPlayer)n;
/*  894 */           if (en != Player) {
/*  895 */             int egid = JRMCoreH.getInt(en, "JRMCGID");
/*      */ 
/*      */             
/*  898 */             if (egid == gid) {
/*  899 */               NBTTagCompound nbt = JRMCoreH.nbt((Entity)en, "pres");
/*  900 */               String msd = nbt.func_74779_i("JRMCmissionSync");
/*      */               
/*  902 */               if (prog(msd, sid, msn.getId())) {
/*  903 */                 msd = setToNextMsn(msd, str, msnl, sid, pw, rc, cl);
/*  904 */                 nbt.func_74778_a("JRMCmissionSync", msd);
/*  905 */                 PD.sendTo((IMessage)new JRMCorePData2(sid + ";" + M.getName() + ";" + M.getDesc() + ";" + M.getAuthor() + ";" + M.getVersion() + ";" + M.getMods() + ";" + M.settings.repeat + ";" + M.settings.unlock, (new Gson()).toJson(msn, JSN_TYPE_MSN)), (EntityPlayerMP)en);
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
/*      */ 
/*      */   
/*      */   public static ArrayList<EntityPlayer> prog(EntityPlayer m, boolean b) {
/*  921 */     MinecraftServer server1 = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  922 */     ArrayList<EntityPlayer> ns = new ArrayList<EntityPlayer>();
/*  923 */     int gid = JRMCoreH.getInt(m, "JRMCGID");
/*  924 */     if (gid != 0 && (server1.func_71203_ab()).field_72404_b != null && (server1.func_71203_ab()).field_72404_b.size() > 0) {
/*  925 */       for (Object n : (server1.func_71203_ab()).field_72404_b) {
/*  926 */         EntityPlayer en = (EntityPlayer)n;
/*      */         
/*  928 */         int egid = JRMCoreH.getInt(en, "JRMCGID");
/*  929 */         if (egid == gid && (b || en != m)) {
/*  930 */           ns.add(en);
/*      */         }
/*      */       } 
/*      */       
/*  934 */       return ns;
/*      */     } 
/*  936 */     if (b)
/*  937 */       ns.add(m); 
/*  938 */     return ns;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ArrayList<EntityPlayer> prog(EntityPlayer k, boolean b, String sid, int mid) {
/*  947 */     MinecraftServer server1 = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  948 */     ArrayList<EntityPlayer> ns = new ArrayList<EntityPlayer>();
/*  949 */     int gid = JRMCoreH.getInt(k, "JRMCGID");
/*  950 */     if (gid != 0 && (server1.func_71203_ab()).field_72404_b != null && (server1.func_71203_ab()).field_72404_b.size() > 0) {
/*  951 */       for (Object n : (server1.func_71203_ab()).field_72404_b) {
/*  952 */         EntityPlayer en = (EntityPlayer)n;
/*      */         
/*  954 */         int egid = JRMCoreH.getInt(en, "JRMCGID");
/*  955 */         if (egid == gid && (b || en != k) && prog(en, sid, mid)) {
/*  956 */           ns.add(en);
/*      */         }
/*      */       } 
/*      */       
/*  960 */       return ns;
/*      */     } 
/*  962 */     if (b)
/*  963 */       ns.add(k); 
/*  964 */     return ns;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void prog(EntityPlayer p, String sid, int mid, int sz, int dc, String ds) {
/*  973 */     for (EntityPlayer en : prog(p, false)) {
/*      */       
/*  975 */       NBTTagCompound nbt = JRMCoreH.nbt((Entity)en, "pres");
/*  976 */       String msd = nbt.func_74779_i("JRMCmissionSync");
/*      */       
/*  978 */       if (prog(msd, sid, mid)) {
/*  979 */         msd = setSyda(msd, sid, mid, sz, dc, ds);
/*  980 */         nbt.func_74778_a("JRMCmissionSync", msd);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static String setToNextMsn(String msd, String str, List<JRMCoreMsn> msnl, String sid, int pw, int rc, int cl) {
/*  987 */     int nID = Integer.parseInt(str);
/*  988 */     boolean available = false;
/*      */     
/*  990 */     for (int n = 0; n < msnl.size(); n++) {
/*  991 */       JRMCoreMsn msn2 = msnl.get(n);
/*  992 */       if (msn2.getId() == nID) {
/*  993 */         available = true;
/*      */         break;
/*      */       } 
/*      */     } 
/*  997 */     if (!available) nID = 0;
/*      */     
/*  999 */     String[] ar = { "0" };
/* 1000 */     for (int j1 = 0; j1 < msnl.size(); j1++) {
/* 1001 */       JRMCoreMsn msn2 = msnl.get(j1);
/* 1002 */       if (msn2.getId() == nID) {
/* 1003 */         ArrayList<String> o2 = msn2.getObjectives(pw, rc, cl);
/* 1004 */         int size2 = o2.size();
/* 1005 */         ar = new String[size2];
/* 1006 */         for (int i = 0; i < ar.length; i++) {
/* 1007 */           ar[i] = "0";
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1012 */     return setSyda(msd, sid, nID, ar);
/*      */   }
/*      */   
/*      */   public static String getSydaV(String[] s, int i) {
/* 1016 */     return (s.length > 3) ? s[i] : "0";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean resetMsnBndl(boolean hasSyda, boolean reset, JRMCoreMsn msn, int msnToSendID, int pw, int rc, int cl, String msd, String msdV, String msdO, String msdVO, String seriesID, NBTTagCompound nbt, JRMCoreMsnBundle M, EntityPlayer p) {
/* 1022 */     if (hasSyda && reset && 
/* 1023 */       msn.getId() == msnToSendID) {
/* 1024 */       ArrayList<String> o = msn.getObjectives(pw, rc, cl);
/* 1025 */       int size = o.size();
/*      */       
/* 1027 */       String[] ar = { "0" };
/* 1028 */       ar = new String[size];
/* 1029 */       for (int i = 0; i < size; i++) {
/* 1030 */         ar[i] = "0";
/*      */       }
/* 1032 */       msd = setSyda(msd, seriesID, msnToSendID, ar);
/*      */       
/* 1034 */       String[] sydaV = getMda(msdV, seriesID);
/* 1035 */       msdV = setSydaV(msdV, seriesID, M.getVersion(), "0", getSydaV(sydaV, 3), "0");
/* 1036 */       if (!msd.equals(msdO))
/* 1037 */         nbt.func_74778_a("JRMCmissionSync", msd); 
/* 1038 */       if (!msdV.equals(msdVO)) {
/* 1039 */         nbt.func_74778_a("JRMCmissionSyncVers", msdV);
/*      */       }
/* 1041 */       PD.sendTo((IMessage)new JRMCorePData2(seriesID + ";" + M.getName() + ";" + M.getDesc() + ";" + M.getAuthor() + ";" + M.getVersion() + ";" + M.getMods() + ";" + M.settings.repeat + ";" + M.settings.unlock, (new Gson()).toJson(msn, JSN_TYPE_MSN)), (EntityPlayerMP)p);
/* 1042 */       return true;
/*      */     } 
/*      */     
/* 1045 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */