/*      */ package JinRyuu.JRMCore;
/*      */ import JinRyuu.JRMCore.entity.EntityNPCshadow;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.p.JRMCorePQuad;
/*      */ import JinRyuu.JRMCore.p.PD;
/*      */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*      */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
/*      */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*      */ import java.io.BufferedReader;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.URL;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.command.server.CommandBlockLogic;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.tileentity.TileEntityCommandBlock;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChatComponentTranslation;
/*      */ import net.minecraft.util.ChatStyle;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ 
/*      */ public class JRMCorePacHanS {
/*      */   public static final int HALF_RELEASE = 50;
/*      */   public static final int MAX_RELEASE = 100;
/*      */   public static final int RELEASE_PER_POTENTIAL_UNLOCK = 5;
/*      */   public static final int DATA_TYPE_SOUND = 1;
/*      */   public static final int MISSION_DATA = 2;
/*      */   public static final int GROUP_DATA = 3;
/*      */   public static final int TRAINING = 10;
/*      */   public static final int FAMILYC_FAMILY_DATA = 200;
/*      */   public static final int FORM_GROUP = 1;
/*      */   public static final int ACCEPT_GROUP = 2;
/*      */   public static final int DECLINE_GROUP = 3;
/*      */   public static final int DISBAND_GROUP = 4;
/*      */   public static final int LEAVE_GROUP = 5;
/*      */   public static final int INVITE_TO_GROUP = 6;
/*      */   public static final int SET_LEADER_GROUP = 7;
/*      */   public static final int KICK_FROM_GROUP = 8;
/*      */   public static final int SPAWN_DUMMY = 0;
/*      */   public static final int MINIGAME_CONCENTRATION = 1;
/*      */   public static final int MINIGAME_AIRBOXING = 2;
/*      */   public static final int TP_LIMIT_CHECK_REQUEST = -1;
/*   60 */   public static final ChatStyle chatStyle = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW); public static final int MINIGAME_TP_COST = 0; public static final int MINIGAME_COLLECT_TP_REWARD = 1; public static final int RAGE_GAIN = 1; public static final int BLOCKING = 2; public static final int KI_CHARGE_EFFECT = 3; public static final int TECHNIQUE = 4; public static final int HEAT_GAIN = 5;
/*      */   public static final int SKILL_ADD = 1;
/*      */   public static final int SKILL_DELETE = 2;
/*      */   public static final int SKILL_INCREASE = 3;
/*      */   public static final int SKILL_DECREASE = 4;
/*      */   public static final int STATUS_EFFECT = 5;
/*      */   public static final int PLAYER_SETTINGS_ONOFF = 6;
/*      */   public static final int PLAYER_SETTINGS_SET = 8;
/*      */   public static final int STATUS_EFFECT_ON = 0;
/*      */   public static final int STATUS_EFFECT_OFF = 1;
/*   70 */   public static int RAGE_GAIN_PLUS = 0; public static int RAGE_GAIN_MINUS = 1;
/*      */   
/*      */   public double explosionX;
/*      */   
/*      */   public double explosionY;
/*      */   
/*      */   public double explosionZ;
/*      */   
/*      */   public float explosionSize;
/*      */   
/*      */   public List chunkPositionRecords;
/*      */   
/*      */   public float playerVelocityX;
/*      */   
/*      */   public float playerVelocityY;
/*      */   
/*      */   public float playerVelocityZ;
/*      */   
/*      */   public boolean expGriOff;
/*      */   public double expDam;
/*      */   public Entity origin;
/*      */   public byte type;
/*      */   
/*      */   public void handleExpl(double explosionX, double explosionY, double explosionZ, float explosionSize, boolean expGriOff, double expDam, Entity origin, List chunkPositionRecords, float playerVelocityX, float playerVelocityY, float playerVelocityZ, EntityPlayer p, byte type) {
/*   94 */     this.explosionX = explosionX;
/*   95 */     this.explosionY = explosionY;
/*   96 */     this.explosionZ = explosionZ;
/*   97 */     this.explosionSize = explosionSize;
/*   98 */     this.expGriOff = expGriOff;
/*   99 */     this.expDam = expDam;
/*  100 */     this.chunkPositionRecords = chunkPositionRecords;
/*  101 */     int var3 = (int)this.explosionX;
/*  102 */     int var4 = (int)this.explosionY;
/*  103 */     int var5 = (int)this.explosionZ;
/*      */     
/*  105 */     this.playerVelocityX = playerVelocityX;
/*  106 */     this.playerVelocityY = playerVelocityY;
/*  107 */     this.playerVelocityZ = playerVelocityZ;
/*  108 */     this.type = type;
/*  109 */     PD.sendToDimension((IMessage)new JRMCorePExpl(explosionX, explosionY, explosionZ, explosionSize, expGriOff, expDam, origin, chunkPositionRecords, playerVelocityX, playerVelocityY, playerVelocityZ, type), origin.field_71093_bK);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleData(int c, String d, EntityPlayer p) {
/*  118 */     if (c == 0) {
/*      */       
/*  120 */       byte acc = JRMCoreH.getByte(p, Acc);
/*      */       
/*  122 */       if (acc == 0) {
/*  123 */         int race = JRMCoreH.getByte(p, R);
/*  124 */         if (JRMCoreH.isRaceMajin(race)) {
/*  125 */           int hc = JRMCoreH.dnsHairC(d);
/*  126 */           int bodyColor = JRMCoreH.dnsBodyCM(d);
/*  127 */           if (hc != bodyColor) {
/*  128 */             hc = bodyColor;
/*  129 */             d = JRMCoreH.dnsHairCSet(d, hc);
/*      */           } 
/*      */         } 
/*      */         
/*  133 */         JRMCoreH.setString(d, p, "jrmcDNS");
/*      */       }
/*      */       else {
/*      */         
/*  137 */         String dnsCur = JRMCoreH.getString(p, "jrmcDNS");
/*  138 */         String dnsTemp = d;
/*  139 */         int hb = JRMCoreH.dnsHairB(dnsCur);
/*  140 */         int hf = JRMCoreH.dnsHairF(dnsCur);
/*  141 */         int hc = JRMCoreH.dnsHairC(dnsCur);
/*      */         
/*  143 */         int race = JRMCoreH.getByte(p, R);
/*  144 */         if (JRMCoreH.isRaceMajin(race)) {
/*  145 */           int bodyColor = JRMCoreH.dnsBodyCM(dnsCur);
/*  146 */           if (hc != bodyColor) hc = bodyColor;
/*      */         
/*      */         } 
/*  149 */         dnsTemp = JRMCoreH.dnsHairBSet(dnsTemp, hb);
/*  150 */         dnsTemp = JRMCoreH.dnsHairFSet(dnsTemp, hf);
/*  151 */         dnsTemp = JRMCoreH.dnsHairCSet(dnsTemp, hc);
/*  152 */         if (dnsCur.equals(dnsTemp)) JRMCoreH.setString(d, p, "jrmcDNS");
/*      */       
/*      */       } 
/*      */     } 
/*      */     
/*  157 */     if (c == 1) {
/*      */       
/*  159 */       byte acc = JRMCoreH.getByte(p, Acc);
/*  160 */       JRMCoreH.setString(d, p, "jrmcDNSH");
/*      */     } 
/*      */     
/*  163 */     if (c == 2)
/*      */     {
/*  165 */       JRMCoreH.setInt(Integer.parseInt(d), p, "jrmcAuraColor");
/*      */     }
/*      */ 
/*      */     
/*  169 */     if (c == 3) {
/*      */       
/*  171 */       byte acc = JRMCoreH.getByte(p, Acc);
/*  172 */       int rc = JRMCoreH.getByte(p, R);
/*  173 */       String dnsau = JRMCoreH.getString(p, "jrmcDNSAU");
/*  174 */       if (acc == 1 && JRMCoreH.rc_arc(rc) && JRMCoreHDBC.auc(JRMCoreH.SklLvlX(p)) && !dnsau.contains(";")) {
/*  175 */         JRMCoreH.setString(d, p, "jrmcDNSAU");
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  180 */     if (c == 4) {
/*      */       
/*  182 */       byte acc = JRMCoreH.getByte(p, Acc);
/*  183 */       int rc = JRMCoreH.getByte(p, R);
/*  184 */       String dnsau = JRMCoreH.getString(p, "jrmcDNSAU");
/*  185 */       if (acc == 1 && JRMCoreH.rc_arc(rc) && JRMCoreHDBC.auc(JRMCoreH.SklLvlX(p)) && !dnsau.contains(";")) {
/*  186 */         JRMCoreH.setString(";" + d, p, "jrmcDNSAU");
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  191 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  192 */     String SenderName = server.func_71266_T() ? (p.func_146103_bH().getId() + ";" + p.func_70005_c_()) : p.func_70005_c_();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  197 */     NBTTagCompound nbt = nbt(p, "pres");
/*  198 */     if (c == 80 && JRMCoreConfig.ssurl.contains("http://")) {
/*      */       
/*  200 */       String[] ssurl = JRMCoreConfig.ssurl.split(",");
/*  201 */       String o = getUrlContents(ssurl[0] + ssurl[1] + SenderName);
/*  202 */       if (d.contains("q"))
/*  203 */         JRMCoreH.jrmcDataToP(c, o, p); 
/*  204 */       if (d.contains("r") && !o.equalsIgnoreCase("error")) {
/*      */         
/*  206 */         String o1 = o.isEmpty() ? "0" : o;
/*  207 */         int q = Integer.parseInt(o1);
/*  208 */         int r = Integer.parseInt(d.substring(1));
/*      */         
/*  210 */         String ssc = JRMCoreConfig.ssc;
/*  211 */         if (ssc.contains("http://")) ssc = getUrlContents(ssc); 
/*  212 */         String[] s1 = ssc.split(";");
/*      */ 
/*      */         
/*  215 */         String uid = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
/*  216 */         mod_JRMCore.logger.info("PWSPlog: Phase1! " + p.func_70005_c_() + " issued purchase for localID " + (r + 1) + "! UniqueID=" + uid);
/*  217 */         SenderName = SenderName + ";" + uid;
/*      */         
/*  219 */         if (ssc.contains("=")) {
/*      */           
/*  221 */           String[] sn = new String[s1.length];
/*  222 */           String[] sc = new String[s1.length];
/*  223 */           for (int i = 0; i < s1.length; i++) {
/*  224 */             String[] s2 = s1[i].split("=");
/*  225 */             sn[i] = s2[0];
/*  226 */             sc[i] = s2[1];
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  232 */           int curcost = Integer.parseInt(sc[r]);
/*  233 */           int a = q - curcost;
/*  234 */           mod_JRMCore.logger.info("PWSPlog: Phase2!");
/*  235 */           if (a >= 0) {
/*      */             
/*  237 */             String cost = getUrlContents(ssurl[0] + ssurl[1] + SenderName + ssurl[2] + curcost + ssurl[3] + (r + 1) + ssurl[4]);
/*  238 */             mod_JRMCore.logger.info("PWSPlog: Phase3!");
/*  239 */             if (cost.contains("has used up")) {
/*  240 */               mod_JRMCore.logger.info("PWSPlog: Begin!");
/*  241 */               if (sn[r].substring(0, 2).contains("TP")) {
/*  242 */                 int curtp = nbt.func_74762_e("jrmcTpint");
/*  243 */                 int addtp = Integer.parseInt(sn[r].substring(2));
/*  244 */                 int tp = curtp + addtp;
/*  245 */                 int wast = 0;
/*  246 */                 if (tp > JRMCoreH.getMaxTP()) {
/*      */                   
/*  248 */                   wast = tp - JRMCoreH.getMaxTP();
/*  249 */                   tp = JRMCoreH.getMaxTP();
/*      */                 } 
/*  251 */                 nbt.func_74768_a("jrmcTpint", tp);
/*  252 */                 JRMCoreH.jrmcDataToP(c, a + "", p);
/*  253 */                 mod_JRMCore.logger.info("PWSPlog: " + p.func_70005_c_() + " successfully bought " + addtp + " TP and now has " + tp + ((wast > 0) ? (" and " + wast + " has gone wasted!") : "."));
/*  254 */                 p.func_145747_a((new ChatComponentText("You have successfully bought " + addtp + " TP and now has " + tp + ((wast > 0) ? (" and " + wast + " has gone wasted!") : "."))).func_150255_a(chatStyle));
/*      */               }
/*  256 */               else if (sn[r].substring(0, 2).contains("CM")) {
/*  257 */                 String it = "";
/*  258 */                 if (sn[r].contains("||")) {
/*  259 */                   String[] ssa = sn[r].split("\\|\\|");
/*  260 */                   it = ssa[0].substring(2);
/*  261 */                   for (int j = 1; j < ssa.length; j++) {
/*  262 */                     String nam = ssa[j];
/*  263 */                     String name = nam.split("!")[0].substring(2);
/*  264 */                     String com = nam.split("!")[1];
/*      */ 
/*      */                     
/*  267 */                     String s = String.format(com.replace("@p", "%s"), new Object[] { p.func_70005_c_() });
/*      */ 
/*      */ 
/*      */                     
/*  271 */                     p.field_70170_p.func_147449_b(0, 254, 0, Blocks.field_150483_bI);
/*  272 */                     TileEntity tileentity = p.field_70170_p.func_147438_o(0, 254, 0);
/*  273 */                     CommandBlockLogic commandblocklogic = ((TileEntityCommandBlock)tileentity).func_145993_a();
/*  274 */                     commandblocklogic.func_145752_a(s);
/*      */                     
/*  276 */                     commandblocklogic.func_145755_a(p.field_70170_p);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  281 */                     p.field_70170_p.func_147468_f(0, 254, 0);
/*      */                   } 
/*  283 */                   p.func_145747_a((new ChatComponentText("You have successfully bought " + it + "!")).func_150255_a(chatStyle));
/*  284 */                   mod_JRMCore.logger.info("PWSPlog: " + p.func_70005_c_() + " successfully bought " + it + "!");
/*      */                 } else {
/*  286 */                   String name = sn[r].split("!")[0].substring(2);
/*  287 */                   String com = sn[r].split("!")[1];
/*      */ 
/*      */                   
/*  290 */                   String s = String.format(com.replace("@p", "%s"), new Object[] { p.func_70005_c_() });
/*      */                   
/*  292 */                   p.func_145747_a((new ChatComponentText("You have successfully bought " + name + "!")).func_150255_a(chatStyle));
/*  293 */                   mod_JRMCore.logger.info("PWSPlog: " + p.func_70005_c_() + " successfully bought " + name + "!");
/*      */ 
/*      */                   
/*  296 */                   p.field_70170_p.func_147449_b(0, 254, 0, Blocks.field_150483_bI);
/*  297 */                   TileEntity tileentity = p.field_70170_p.func_147438_o(0, 254, 0);
/*  298 */                   CommandBlockLogic commandblocklogic = ((TileEntityCommandBlock)tileentity).func_145993_a();
/*  299 */                   commandblocklogic.func_145752_a(s);
/*      */                   
/*  301 */                   commandblocklogic.func_145755_a(p.field_70170_p);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  306 */                   p.field_70170_p.func_147468_f(0, 254, 0);
/*      */                 }
/*      */               
/*  309 */               } else if (sn[r].substring(0, 2).contains("IT")) {
/*  310 */                 String it = "";
/*  311 */                 if (sn[r].contains("||")) {
/*  312 */                   String[] ssa = sn[r].split("\\|\\|");
/*  313 */                   it = ssa[0].substring(2);
/*  314 */                   for (int j = 1; j < ssa.length; j++) {
/*  315 */                     String nam = ssa[j];
/*  316 */                     String n1 = "";
/*  317 */                     int n2 = 1;
/*  318 */                     int n3 = 0;
/*  319 */                     if (j > 0) {
/*  320 */                       String[] s2 = nam.split(",");
/*  321 */                       if (s2.length > 1) {
/*  322 */                         n2 = Integer.parseInt(s2[1]);
/*      */                       }
/*  324 */                       if (s2[0].contains("::")) {
/*  325 */                         String[] s3 = s2[0].split("::");
/*  326 */                         n1 = s3[0];
/*  327 */                         n3 = Integer.parseInt(s3[1]);
/*      */                       } else {
/*  329 */                         n1 = s2[0];
/*      */                       } 
/*  331 */                       Item item = JRMCoreH.getItemByText(n1);
/*  332 */                       if (item != null) {
/*  333 */                         ItemStack itemstack = new ItemStack(item, n2, n3);
/*  334 */                         EntityItem entityitem = p.func_71019_a(itemstack, false);
/*  335 */                         entityitem.field_145804_b = 0;
/*      */                       } 
/*      */                     } else {
/*  338 */                       it = nam.substring(2);
/*      */                     }
/*      */                   
/*      */                   } 
/*      */                 } else {
/*      */                   
/*  344 */                   String n1 = "";
/*  345 */                   int n2 = 1;
/*  346 */                   int n3 = 0;
/*  347 */                   String[] s2 = sn[r].split(",");
/*  348 */                   if (s2.length > 1) {
/*  349 */                     n2 = Integer.parseInt(s2[1]);
/*      */                   }
/*  351 */                   if (s2[0].contains("::")) {
/*  352 */                     String[] s3 = s2[0].split("::");
/*  353 */                     n1 = s3[0].substring(2);
/*  354 */                     n3 = Integer.parseInt(s3[1]);
/*      */                   } else {
/*  356 */                     n1 = s2[0].substring(2);
/*      */                   } 
/*      */                   
/*  359 */                   Item item = JRMCoreH.getItemByText(n1);
/*  360 */                   if (item != null) {
/*  361 */                     ItemStack itemstack = new ItemStack(item, n2, n3);
/*  362 */                     EntityItem entityitem = p.func_71019_a(itemstack, false);
/*  363 */                     entityitem.field_145804_b = 0;
/*  364 */                     it = itemstack.func_82833_r();
/*      */                   } 
/*      */                 } 
/*  367 */                 mod_JRMCore.logger.info("PWSPlog: " + p.func_70005_c_() + " successfully bought " + it);
/*  368 */                 p.func_145747_a((new ChatComponentText("You have successfully bought " + it)).func_150255_a(chatStyle));
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } else {
/*  373 */           mod_JRMCore.logger.info("PWSPlog: " + p.func_70005_c_() + " something went wrong!");
/*  374 */           p.func_145747_a((new ChatComponentText("something went wrong, get in contact with an admin!")).func_150255_a(chatStyle));
/*      */         } 
/*  376 */         mod_JRMCore.logger.info("PWSPlog: END");
/*      */       } 
/*  378 */     } else if (c == 80) {
/*  379 */       mod_JRMCore.logger.info("PWSPlog: " + p.func_70005_c_() + " something terribly went wrong!");
/*  380 */       p.func_145747_a((new ChatComponentText("something terribly went wrong, get in contact with an admin!")).func_150255_a(chatStyle));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void spawcha(EntityPlayer p, World w, String n, String h, String a, String m, String pr, double x, double y, double z, int g) {
/*  389 */     JGEntityHelper.spawcha(p, w, n, h, a, m, pr, x, y, z, g);
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleData2(String c, String d, EntityPlayer p) {
/*  394 */     if (c.length() <= 1 && d.length() <= 1) {
/*      */       
/*  396 */       NBTTagCompound nbt = nbt(p, "pres");
/*      */       
/*  398 */       String msd = nbt.func_74779_i("JRMCmissionSync");
/*  399 */       String msdV = nbt.func_74779_i("JRMCmissionSyncVers");
/*  400 */       String msdO = msd;
/*  401 */       String msdVO = msdV;
/*  402 */       HashMap<String, Integer> h = new HashMap<String, Integer>();
/*  403 */       if (msd.length() > 3) {
/*  404 */         for (int i = 0; i < JRMCoreM.getSydaAmount(msd); i++) {
/*  405 */           int mid = JRMCoreM.getMda_Mission(msd, i);
/*  406 */           String sid = JRMCoreM.getMda_Series(msd, i);
/*  407 */           h.put(sid, Integer.valueOf(mid));
/*      */         } 
/*      */       }
/*  410 */       int pw = nbt.func_74771_c(P);
/*  411 */       int rc = nbt.func_74771_c(R);
/*  412 */       int cl = nbt.func_74771_c(Cl);
/*  413 */       for (Iterator<String> iterator = JRMCoreM.missions.keySet().iterator(); iterator.hasNext(); ) {
/*      */         
/*  415 */         String seriesID = iterator.next();
/*  416 */         JRMCoreMsnBundle M = JRMCoreM.missions.get(seriesID);
/*  417 */         if (M != null) {
/*      */           
/*  419 */           List<JRMCoreMsn> msnl = M.getMissions();
/*      */           
/*  421 */           boolean unlocked = true;
/*  422 */           if (M.getSettings().getUnlock().length() > 0) {
/*      */             
/*  424 */             String[] sidd = M.getSettings().getUnlock().split(",");
/*  425 */             for (int i = 0; i < sidd.length; i++) {
/*      */ 
/*      */ 
/*      */               
/*  429 */               unlocked = JRMCoreM.isUnlocked(sidd[i], msd, msdV);
/*  430 */               if (!unlocked)
/*      */                 break; 
/*      */             } 
/*      */           } 
/*  434 */           boolean reset = true;
/*  435 */           String[] sydaV = JRMCoreM.getMda(msdV, seriesID);
/*  436 */           String rp = JRMCoreM.getSydaV(sydaV, 2);
/*  437 */           boolean canRepeat = rp.equals("0");
/*      */           
/*  439 */           if (sydaV.length > 1) {
/*  440 */             reset = !M.getVersion().equalsIgnoreCase(sydaV[1]);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  447 */           rp = reset ? "0" : rp;
/*  448 */           String cc = JRMCoreM.getSydaV(sydaV, 3);
/*  449 */           String ccv = reset ? "0" : JRMCoreM.getSydaV(sydaV, 4);
/*  450 */           msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, ccv);
/*      */           
/*  452 */           int msnToSendID = 0;
/*  453 */           boolean hasSyda = false;
/*  454 */           if (h.containsKey(seriesID)) {
/*  455 */             if (!reset) msnToSendID = ((Integer)h.get(seriesID)).intValue(); 
/*  456 */             hasSyda = true;
/*      */           } 
/*  458 */           for (int j = 0; j < msnl.size(); j++) {
/*  459 */             JRMCoreMsn msn = msnl.get(j);
/*  460 */             if (hasSyda && reset) {
/*  461 */               JRMCoreM.resetMsnBndl(hasSyda, reset, msn, msnToSendID, pw, rc, cl, msd, msdV, msdO, msdVO, seriesID, nbt, M, p);
/*      */             }
/*  463 */             else if (msn.getId() == msnToSendID) {
/*  464 */               ArrayList<String> o = msn.getObjectives(pw, rc, cl);
/*  465 */               int size = o.size();
/*  466 */               if (hasSyda) {
/*  467 */                 if (JRMCoreM.getMda_Con(JRMCoreM.getMda(msd, seriesID), size - 1).equals("") || reset) {
/*  468 */                   String[] ar = { "0" };
/*  469 */                   ar = new String[size];
/*  470 */                   for (int i = 0; i < size; i++) {
/*  471 */                     ar[i] = "0";
/*      */                   }
/*  473 */                   msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, ar);
/*      */                   
/*  475 */                   rp = reset ? "0" : rp;
/*  476 */                   cc = JRMCoreM.getSydaV(sydaV, 3);
/*  477 */                   ccv = reset ? "0" : JRMCoreM.getSydaV(sydaV, 4);
/*  478 */                   msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, ccv);
/*      */                   
/*  480 */                   if (!msd.equalsIgnoreCase(msdO))
/*  481 */                     nbt.func_74778_a("JRMCmissionSync", msd); 
/*  482 */                   if (!msdV.equalsIgnoreCase(msdVO)) {
/*  483 */                     nbt.func_74778_a("JRMCmissionSyncVers", msdV);
/*      */                   }
/*      */                 } 
/*      */               } else {
/*  487 */                 String[] ar = new String[size];
/*  488 */                 for (int i = 0; i < ar.length; i++) {
/*  489 */                   ar[i] = "0";
/*      */                 }
/*  491 */                 msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, ar);
/*      */                 
/*  493 */                 rp = reset ? "0" : rp;
/*  494 */                 cc = JRMCoreM.getSydaV(sydaV, 3);
/*  495 */                 ccv = reset ? "0" : JRMCoreM.getSydaV(sydaV, 4);
/*  496 */                 msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, ccv);
/*      */                 
/*  498 */                 if (!msd.equalsIgnoreCase(msdO))
/*  499 */                   nbt.func_74778_a("JRMCmissionSync", msd); 
/*  500 */                 if (!msdV.equalsIgnoreCase(msdVO)) {
/*  501 */                   nbt.func_74778_a("JRMCmissionSyncVers", msdV);
/*      */                 }
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  515 */               PD.sendTo((IMessage)new JRMCorePData2(seriesID + ";" + M.getName() + ";" + M.getDesc() + ";" + M.getAuthor() + ";" + M.getVersion() + ";" + M.getMods() + ";" + M.settings.repeat + ";" + M.settings.unlock, (new Gson()).toJson(msn, JRMCoreM.JSN_TYPE_MSN)), (EntityPlayerMP)p);
/*      */ 
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*  524 */       NBTTagCompound nbt = nbt(p, "pres");
/*  525 */       if (c.length() > 0) {
/*  526 */         String msd = nbt.func_74779_i("JRMCmissionSync");
/*  527 */         String msdV = nbt.func_74779_i("JRMCmissionSyncVers");
/*      */         
/*  529 */         String msdVO = msdV;
/*      */         
/*  531 */         HashMap<String, Integer> h = new HashMap<String, Integer>();
/*  532 */         if (msd.length() > 3) {
/*  533 */           for (int i = 0; i < JRMCoreM.getSydaAmount(msd); i++) {
/*  534 */             String sid = JRMCoreM.getMda_Series(msd, i);
/*  535 */             int mid = JRMCoreM.getMda_Mission(msd, i);
/*  536 */             h.put(sid, Integer.valueOf(mid));
/*      */           } 
/*      */         }
/*  539 */         int pw = nbt.func_74771_c(P);
/*  540 */         int rc = nbt.func_74771_c(R);
/*  541 */         int cl = nbt.func_74771_c(Cl);
/*  542 */         int al = nbt.func_74771_c("jrmcAlign");
/*      */         
/*  544 */         ArrayList<EntityPlayer> gp = JRMCoreM.prog(p, true);
/*  545 */         int g = gp.size();
/*      */         
/*  547 */         String seriesID = c;
/*  548 */         JRMCoreMsnBundle M = JRMCoreM.missions.get(seriesID);
/*  549 */         List<JRMCoreMsn> msnl = M.getMissions();
/*      */ 
/*      */         
/*  552 */         boolean unlocked = true;
/*  553 */         if (M.getSettings().getUnlock().length() > 0) {
/*  554 */           String[] sidd = M.getSettings().getUnlock().split(",");
/*  555 */           for (int i = 0; i < sidd.length; i++) {
/*      */ 
/*      */ 
/*      */             
/*  559 */             unlocked = JRMCoreM.isUnlocked(sidd[i], msd, msdV);
/*  560 */             if (!unlocked)
/*      */               break; 
/*      */           } 
/*      */         } 
/*  564 */         String[] sydaV = JRMCoreM.getMda(msdV, seriesID);
/*  565 */         String rp = JRMCoreM.getSydaV(sydaV, 2);
/*  566 */         boolean canRepeat = rp.equals("0");
/*      */ 
/*      */         
/*  569 */         int msnToSendID = 0;
/*  570 */         if (h.containsKey(seriesID)) {
/*  571 */           msnToSendID = ((Integer)h.get(seriesID)).intValue();
/*      */         }
/*      */         
/*  574 */         if (canRepeat && unlocked) {
/*  575 */           for (int j = 0; j < msnl.size(); j++) {
/*  576 */             JRMCoreMsn msn = msnl.get(j);
/*  577 */             if (msn.getId() == msnToSendID) {
/*  578 */               gp = JRMCoreM.prog(p, true, c, msnToSendID);
/*      */               
/*  580 */               ArrayList<String> o = msn.getObjectives(pw, rc, cl);
/*  581 */               int size = o.size();
/*  582 */               boolean start = false;
/*  583 */               String ps = msn.getProps().get(0);
/*      */               
/*      */               int i;
/*  586 */               for (i = 0; i < o.size(); i++) {
/*  587 */                 String os = o.get(i);
/*  588 */                 String t = JRMCoreM.getMCo_type(os);
/*  589 */                 String d1 = JRMCoreM.getMCo_data(os, "N");
/*  590 */                 if (t.equalsIgnoreCase("item")) {
/*  591 */                   String[] d2 = d1.split("::");
/*  592 */                   Item im = JRMCoreH.getItemByText((d2.length > 1) ? d2[0] : d1);
/*  593 */                   if (im != null) {  } else {  }  ItemStack is = null;
/*  594 */                   String en = (is != null) ? is.func_77977_a() : "ERROR";
/*      */                   
/*  596 */                   int cnt = 0;
/*  597 */                   for (EntityPlayer p1 : gp) {
/*      */ 
/*      */                     
/*  600 */                     for (int l = 0; l < p1.field_71071_by.field_70462_a.length; l++) {
/*  601 */                       if (p1.field_71071_by.field_70462_a[l] != null && p1.field_71071_by.field_70462_a[l].func_77977_a().equalsIgnoreCase(en)) {
/*  602 */                         cnt += (p1.field_71071_by.field_70462_a[l]).field_77994_a;
/*      */                       }
/*      */                     } 
/*      */                   } 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  610 */                   JRMCoreM.prog(p, seriesID, msnToSendID, size, i, "" + cnt);
/*  611 */                   msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, i, "" + cnt);
/*      */                 } 
/*      */               } 
/*      */               
/*  615 */               if (JRMCoreM.getMda_ObjComp_all(o, JRMCoreM.getMda(msd, seriesID), g)) {
/*      */                 
/*  617 */                 for (i = 0; i < o.size(); i++) {
/*  618 */                   String os = o.get(i);
/*  619 */                   String t = JRMCoreM.getMCo_type(os);
/*  620 */                   String d1 = JRMCoreM.getMCo_data(os, "N");
/*  621 */                   if (t.equalsIgnoreCase("item")) {
/*  622 */                     int da = (int)(JRMCoreM.getMCo_dataI(os, "M") * JRMCoreM.gm(g));
/*      */                     
/*  624 */                     String[] d2 = d1.split("::");
/*  625 */                     Item im = JRMCoreH.getItemByText((d2.length > 1) ? d2[0] : d1);
/*  626 */                     if (im != null) {  } else {  }  ItemStack is = null;
/*  627 */                     String en = (is != null) ? is.func_77977_a() : "ERROR";
/*      */                     
/*  629 */                     int cnt = da;
/*  630 */                     for (EntityPlayer p1 : gp) {
/*      */ 
/*      */                       
/*  633 */                       for (int l = 0; l < p1.field_71071_by.field_70462_a.length; l++) {
/*  634 */                         if (cnt > 0 && p1.field_71071_by.field_70462_a[l] != null && p1.field_71071_by.field_70462_a[l].func_77977_a().equalsIgnoreCase(en)) {
/*  635 */                           int ss = (p1.field_71071_by.field_70462_a[l]).field_77994_a;
/*  636 */                           if (cnt < ss) {
/*  637 */                             (p1.field_71071_by.field_70462_a[l]).field_77994_a = ss - cnt;
/*  638 */                             cnt -= ss;
/*  639 */                           } else if (cnt >= ss) {
/*  640 */                             p1.field_71071_by.field_70462_a[l] = null;
/*  641 */                             cnt -= ss;
/*      */                           } 
/*      */                         } 
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*      */                 } 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  652 */                 ArrayList<String> r = msn.getRewards(pw, rc, cl);
/*  653 */                 int btnID = Integer.parseInt(d);
/*  654 */                 if (btnID >= 0) {
/*  655 */                   if (ps.equalsIgnoreCase("randrew"))
/*  656 */                     btnID = (new Random()).nextInt(r.size()); 
/*  657 */                   String[] rw = ((String)r.get(btnID)).split(";");
/*  658 */                   String[] rws = rw[0].split("\\|\\|");
/*  659 */                   for (EntityPlayer p1 : gp) {
/*      */ 
/*      */                     
/*  662 */                     for (int k = 0; k < rws.length; k++) {
/*  663 */                       String[] srw = rws[k].split("!");
/*  664 */                       if (srw[0].equalsIgnoreCase("tp")) {
/*  665 */                         String tptype = srw[1];
/*  666 */                         double tpamount = Double.parseDouble(srw[2]);
/*  667 */                         if (tptype.equals("fix")) {
/*  668 */                           JRMCoreH.tpalgn(p1, (int)tpamount, al);
/*      */                         }
/*  670 */                         else if (tptype.equalsIgnoreCase("lvl")) {
/*  671 */                           int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p1);
/*  672 */                           JRMCoreH.tpalgn(p1, (int)(tpamount * JRMCoreH.getPlayerLevel(PlyrAttrbts)), 0);
/*      */                         }
/*  674 */                         else if (tptype.equalsIgnoreCase("align")) {
/*  675 */                           int at = JRMCoreH.Algnmnt(al);
/*  676 */                           int ma = JRMCoreM.getMAlgnmnt_Num(msn.getAlign(pw, rc, cl));
/*  677 */                           double tpres = (ma == at) ? tpamount : ((ma == at + 1 || ma == at - 1) ? (tpamount / 2.0D) : 0.0D);
/*  678 */                           JRMCoreH.tpalgn(p1, (int)tpres, al);
/*      */                         }
/*  680 */                         else if (tptype.equalsIgnoreCase("lvlalign")) {
/*  681 */                           int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p1);
/*  682 */                           int lvl = JRMCoreH.getPlayerLevel(PlyrAttrbts);
/*  683 */                           int at = JRMCoreH.Algnmnt(al);
/*  684 */                           int ma = JRMCoreM.getMAlgnmnt_Num(msn.getAlign(pw, rc, cl));
/*  685 */                           double tpres = (ma == at) ? tpamount : ((ma == at + 1 || ma == at - 1) ? (tpamount / 2.0D) : 0.0D);
/*  686 */                           JRMCoreH.tpalgn(p1, (int)(tpres * lvl), al);
/*      */                         } 
/*  688 */                       } else if (srw[0].equalsIgnoreCase("align")) {
/*  689 */                         int alamount = Integer.parseInt(srw[1]);
/*  690 */                         int b = (al + alamount < 0) ? 0 : ((al + alamount > 100) ? 100 : (al + alamount));
/*  691 */                         if (alamount == 0) {
/*  692 */                           if (al >= 55) {
/*  693 */                             b = (al - 10 < 0) ? 0 : (al - 10);
/*  694 */                           } else if (al <= 45) {
/*  695 */                             b = (al + 10 > 100) ? 100 : (al + 10);
/*      */                           } else {
/*  697 */                             b = 50;
/*      */                           } 
/*      */                         }
/*  700 */                         JRMCoreH.tpalgn(p1, 0, b);
/*  701 */                       } else if (srw[0].equalsIgnoreCase("item")) {
/*  702 */                         String nam = srw[1];
/*  703 */                         String n1 = "";
/*  704 */                         int n2 = 1;
/*  705 */                         int n3 = 0;
/*      */                         
/*  707 */                         String[] s2 = nam.split(",");
/*  708 */                         if (s2.length > 1) {
/*  709 */                           n2 = Integer.parseInt(s2[1]);
/*      */                         }
/*  711 */                         if (s2[0].contains("::")) {
/*  712 */                           String[] s3 = s2[0].split("::");
/*  713 */                           n1 = s3[0];
/*  714 */                           n3 = Integer.parseInt(s3[1]);
/*      */                         } else {
/*  716 */                           n1 = s2[0];
/*      */                         } 
/*  718 */                         Item item = JRMCoreH.getItemByText(n1);
/*  719 */                         if (item != null) {
/*  720 */                           ItemStack itemstack = new ItemStack(item, n2, n3);
/*  721 */                           EntityItem entityitem = p1.func_71019_a(itemstack, false);
/*  722 */                           entityitem.field_145804_b = 0;
/*      */                         } 
/*  724 */                       } else if (srw[0].equalsIgnoreCase("com")) {
/*  725 */                         String com = srw[1];
/*  726 */                         com = com.replace("@p", "%s");
/*  727 */                         String s = String.format(com, new Object[] { p1.func_70005_c_() });
/*      */                         
/*  729 */                         p1.field_70170_p.func_147449_b(0, 254, 0, Blocks.field_150483_bI);
/*  730 */                         TileEntity tileentity = p1.field_70170_p.func_147438_o(0, 254, 0);
/*  731 */                         CommandBlockLogic commandblocklogic = ((TileEntityCommandBlock)tileentity).func_145993_a();
/*  732 */                         commandblocklogic.func_145752_a(s);
/*  733 */                         commandblocklogic.func_145755_a(p1.field_70170_p);
/*      */                         
/*  735 */                         p1.field_70170_p.func_147468_f(0, 254, 0);
/*  736 */                         mod_JRMCore.logger.info("MSNlog: " + p1.func_70005_c_() + " successfully earned reward for quest " + seriesID + "/" + msn.getId() + "!");
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*      */                   
/*  741 */                   msd = JRMCoreM.setToNextMsn(msd, rw[2], msnl, seriesID, pw, rc, cl);
/*  742 */                   JRMCoreM.prog(p, M, msn, rw[2], msnl, seriesID, pw, rc, cl);
/*      */                 } 
/*      */               } else {
/*      */                 
/*  746 */                 String ft = JRMCoreM.getMCo_type(o.get(0));
/*  747 */                 String fd1 = JRMCoreM.getMCo_data(o.get(0), "N");
/*  748 */                 boolean db = d.equals("-3");
/*  749 */                 if (size == 1) {
/*  750 */                   msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, new String[] { "1" });
/*      */                 }
/*  752 */                 if (JRMCoreM.getMda(msd, seriesID)[2].equals("0")) {
/*  753 */                   for (int k = 0; k < o.size(); k++) {
/*  754 */                     String os = o.get(k);
/*  755 */                     String t = JRMCoreM.getMCo_type(os);
/*  756 */                     String d1 = JRMCoreM.getMCo_data(os, "N");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  783 */                     if (t.equalsIgnoreCase("kill")) {
/*  784 */                       boolean spwn = JRMCoreM.getMCo_data(os, "P").equalsIgnoreCase("spwn");
/*  785 */                       if (!spwn) {
/*  786 */                         float angle = p.field_70177_z;
/*  787 */                         double rtx = Math.sin((angle / 57.295776F));
/*  788 */                         double rty = Math.cos((angle / 57.295776F));
/*  789 */                         int Y = p.field_70170_p.func_72976_f((int)(p.field_70165_t - 3.0D * rtx), (int)(p.field_70161_v + 3.0D * rty));
/*  790 */                         String dtr = JRMCoreM.getMCo_data(os, "T");
/*      */                         
/*  792 */                         spawcha(p, p.field_70170_p, JRMCoreM.getMCo_data(os, "N"), 
/*  793 */                             JRMCoreM.getMCo_data(os, "H"), JRMCoreM.getMCo_data(os, "A"), dtr, seriesID + ";" + msnToSendID + ";" + p.func_70005_c_(), p.field_70165_t - 3.0D * rtx, Y, p.field_70161_v + 3.0D * rty, g);
/*      */                         
/*  795 */                         JRMCoreM.prog(p, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "1");
/*  796 */                         msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "1");
/*  797 */                         String md = JRMCoreM.getMCo_data(os, "S");
/*  798 */                         List<EntityPlayer> pl = p.field_70170_p.func_72872_a(EntityPlayer.class, p.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*  799 */                         if (pl.size() > 0 && md.length() > 1)
/*  800 */                           for (int v = 0; v < pl.size(); v++) {
/*      */                             
/*  802 */                             EntityPlayer va = pl.get(v);
/*  803 */                             ChatComponentTranslation chat = new ChatComponentTranslation(md, new Object[0]);
/*  804 */                             if (chat.func_150260_c().length() > 0)
/*      */                             {
/*  806 */                               va.func_145747_a(chat.func_150255_a(JRMCoreH2.styl_wht));
/*      */                             }
/*      */ 
/*      */ 
/*      */                             
/*  811 */                             String dsnS = JRMCoreM.getMCo_data(os, "O");
/*  812 */                             if (dsnS.length() > 1) {
/*  813 */                               if (dsnS.contains(",")) {
/*  814 */                                 String[] dsnSa = dsnS.split(",");
/*  815 */                                 va.field_70170_p.func_72956_a((Entity)va, dsnSa[0], Float.parseFloat(dsnSa[1]), 1.0F);
/*      */                               } else {
/*  817 */                                 va.field_70170_p.func_72956_a((Entity)va, dsnS, 1.0F, 1.0F);
/*      */                               } 
/*      */                             }
/*      */                           }  
/*      */                       } 
/*  822 */                     } else if (t.equalsIgnoreCase("killsame")) {
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  827 */                       boolean spwn = JRMCoreM.getMCo_data(os, "P").equalsIgnoreCase("spwn");
/*  828 */                       if (!spwn) {
/*  829 */                         String dtr = JRMCoreM.getMCo_data(os, "T");
/*  830 */                         for (int i1 = 0; i1 < (int)(JRMCoreM.getMCo_dataI(os, "M") * JRMCoreM.gm(g)); i1++) {
/*  831 */                           float angle = p.field_70177_z;
/*  832 */                           double rtx = Math.sin((angle / 57.295776F));
/*  833 */                           double rty = Math.cos((angle / 57.295776F));
/*  834 */                           int Y = p.field_70170_p.func_72976_f((int)(p.field_70165_t - 3.0D * rtx), (int)(p.field_70161_v + 3.0D * rty));
/*      */                           
/*  836 */                           spawcha(p, p.field_70170_p, JRMCoreM.getMCo_data(os, "N"), 
/*  837 */                               JRMCoreM.getMCo_data(os, "H"), JRMCoreM.getMCo_data(os, "A"), dtr, seriesID + ";" + msnToSendID + ";" + p.func_70005_c_(), p.field_70165_t - 3.0D * rtx, Y, p.field_70161_v + 3.0D * rty, 1);
/*      */                         } 
/*  839 */                         JRMCoreM.prog(p, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "1");
/*  840 */                         msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "1");
/*  841 */                         String md = JRMCoreM.getMCo_data(os, "S");
/*  842 */                         List<EntityPlayer> pl = p.field_70170_p.func_72872_a(EntityPlayer.class, p.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*  843 */                         if (pl.size() > 0 && md.length() > 1) {
/*  844 */                           for (int v = 0; v < pl.size(); v++) {
/*      */                             
/*  846 */                             EntityPlayer va = pl.get(v);
/*      */                             
/*  848 */                             ChatComponentTranslation chat = new ChatComponentTranslation(md, new Object[0]);
/*  849 */                             if (chat.func_150254_d().length() > 0)
/*      */                             {
/*  851 */                               va.func_145747_a(chat.func_150255_a(JRMCoreH2.styl_wht));
/*      */                             }
/*      */ 
/*      */ 
/*      */                             
/*  856 */                             String dsnS = JRMCoreM.getMCo_data(os, "O");
/*  857 */                             if (dsnS.length() > 1) {
/*  858 */                               if (dsnS.contains(",")) {
/*  859 */                                 String[] dsnSa = dsnS.split(",");
/*  860 */                                 va.field_70170_p.func_72956_a((Entity)va, dsnSa[0], Float.parseFloat(dsnSa[1]), 1.0F);
/*      */                               } else {
/*  862 */                                 va.field_70170_p.func_72956_a((Entity)va, dsnS, 1.0F, 1.0F);
/*      */                               } 
/*      */                             }
/*      */                           } 
/*      */                         }
/*      */                       } 
/*  868 */                     } else if (t.equalsIgnoreCase("talk") && db) {
/*  869 */                       JRMCoreM.prog(p, seriesID, msnToSendID, size, k, "1");
/*  870 */                       msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, k, "1");
/*      */                     }
/*  872 */                     else if (t.equalsIgnoreCase("skip")) {
/*  873 */                       ArrayList<String> r = msn.getRewards(pw, rc, cl);
/*  874 */                       String[] rw = ((String)r.get(0)).split(";");
/*  875 */                       msd = JRMCoreM.setToNextMsn(msd, rw[2], msnl, seriesID, pw, rc, cl);
/*  876 */                       JRMCoreM.prog(p, M, msn, rw[2], msnl, seriesID, pw, rc, cl);
/*      */                     }
/*  878 */                     else if (t.equalsIgnoreCase("restart")) {
/*  879 */                       rp = M.getSettings().getRepeat().contains("-") ? "-1" : ("" + (Integer.parseInt(M.getSettings().getRepeat()) * 12));
/*  880 */                       String cc = "" + (Integer.parseInt(JRMCoreM.getSydaV(sydaV, 3)) + 1);
/*  881 */                       String ccv = "" + (Integer.parseInt(JRMCoreM.getSydaV(sydaV, 4)) + 1);
/*  882 */                       msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, ccv);
/*  883 */                       JRMCoreM.prog(p, seriesID, M.getVersion(), rp, cc, ccv);
/*      */                       
/*  885 */                       ArrayList<String> r = msn.getRewards(pw, rc, cl);
/*  886 */                       String[] rw = ((String)r.get(0)).split(";");
/*  887 */                       msd = JRMCoreM.setToNextMsn(msd, "0", msnl, seriesID, pw, rc, cl);
/*  888 */                       JRMCoreM.prog(p, M, msn, "0", msnl, seriesID, pw, rc, cl);
/*      */                     } 
/*      */                   } 
/*  891 */                 } else if (JRMCoreM.getMda(msd, seriesID)[2].equals("1")) {
/*  892 */                   String os = o.get(0);
/*  893 */                   String t = JRMCoreM.getMCo_type(os);
/*  894 */                   if (t.equalsIgnoreCase("skip")) {
/*  895 */                     ArrayList<String> r = msn.getRewards(pw, rc, cl);
/*  896 */                     String[] rw = ((String)r.get(0)).split(";");
/*  897 */                     msd = JRMCoreM.setToNextMsn(msd, rw[2], msnl, seriesID, pw, rc, cl);
/*  898 */                     JRMCoreM.prog(p, M, msn, rw[2], msnl, seriesID, pw, rc, cl);
/*      */                   }
/*  900 */                   else if (t.equalsIgnoreCase("restart")) {
/*  901 */                     rp = M.getSettings().getRepeat().contains("-") ? "-1" : ("" + (Integer.parseInt(M.getSettings().getRepeat()) * 12));
/*  902 */                     String cc = "" + (Integer.parseInt(JRMCoreM.getSydaV(sydaV, 3)) + 1);
/*  903 */                     String ccv = "" + (Integer.parseInt(JRMCoreM.getSydaV(sydaV, 4)) + 1);
/*  904 */                     msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), rp, cc, ccv);
/*  905 */                     JRMCoreM.prog(p, seriesID, M.getVersion(), rp, cc, ccv);
/*      */                     
/*  907 */                     ArrayList<String> r = msn.getRewards(pw, rc, cl);
/*  908 */                     String[] rw = ((String)r.get(0)).split(";");
/*  909 */                     msd = JRMCoreM.setToNextMsn(msd, "0", msnl, seriesID, pw, rc, cl);
/*  910 */                     JRMCoreM.prog(p, M, msn, "0", msnl, seriesID, pw, rc, cl);
/*      */                   } 
/*      */                 } 
/*      */               } 
/*  914 */               nbt.func_74778_a("JRMCmissionSync", msd);
/*  915 */               if (!msdV.equalsIgnoreCase(msdVO))
/*  916 */                 nbt.func_74778_a("JRMCmissionSyncVers", msdV); 
/*  917 */               PD.sendTo((IMessage)new JRMCorePData2(seriesID + ";" + M.getName() + ";" + M.getDesc() + ";" + M.getAuthor() + ";" + M.getVersion() + ";" + M.getMods() + ";" + M.settings.repeat + ";" + M.settings.unlock, (new Gson()).toJson(msn, JRMCoreM.JSN_TYPE_MSN)), (EntityPlayerMP)p);
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*  927 */   public static HashMap<String, Long> ckr = new HashMap<String, Long>();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getUrlContents(String theUrl) {
/*  933 */     StringBuilder content = new StringBuilder();
/*      */     
/*      */     try {
/*  936 */       URL url = new URL(theUrl);
/*  937 */       URLConnection urlConnection = url.openConnection();
/*  938 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
/*      */       String line;
/*  940 */       while ((line = bufferedReader.readLine()) != null)
/*      */       {
/*  942 */         content.append(line);
/*      */       }
/*  944 */       bufferedReader.close();
/*      */     }
/*  946 */     catch (Exception e) {
/*      */       
/*  948 */       e.printStackTrace();
/*      */     } 
/*  950 */     return content.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean respc(String theUrl) {
/*  958 */     long ct = System.currentTimeMillis() / 1000L;
/*  959 */     if (ckr.get("guc") == null || ct > ((Long)ckr.get("guc")).longValue()) {
/*      */       try {
/*  961 */         URL url = new URL(theUrl);
/*  962 */         HttpURLConnection connect = (HttpURLConnection)url.openConnection();
/*  963 */         connect.setConnectTimeout(10000);
/*  964 */         connect.setReadTimeout(10000);
/*  965 */         connect.setDoOutput(true);
/*  966 */         connect.setInstanceFollowRedirects(false);
/*  967 */         connect.setRequestMethod("HEAD");
/*  968 */         connect.setUseCaches(false);
/*      */         try {
/*  970 */           int responseCode = connect.getResponseCode();
/*  971 */           if (responseCode == 200) {
/*  972 */             ckr.remove("guc");
/*  973 */             return true;
/*      */           }
/*      */         
/*  976 */         } catch (SocketTimeoutException socketTimeoutException) {}
/*      */         
/*  978 */         connect.disconnect();
/*  979 */       } catch (IOException iOException) {}
/*      */       
/*  981 */       ckr.put("guc", Long.valueOf(ct + 10L));
/*      */     } 
/*  983 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static String update() {
/*  988 */     String s = "nothing";
/*      */     try {
/*  990 */       String[] ssurl = JRMCoreConfig.ssurl.split(",");
/*  991 */       URL url = new URL(ssurl[0]);
/*  992 */       HttpURLConnection connect = (HttpURLConnection)url.openConnection();
/*  993 */       connect.setConnectTimeout(10000);
/*  994 */       connect.setReadTimeout(10000);
/*  995 */       connect.setDoOutput(true);
/*  996 */       connect.setInstanceFollowRedirects(false);
/*  997 */       connect.setRequestMethod("HEAD");
/*  998 */       connect.setUseCaches(false);
/*      */       try {
/* 1000 */         int responseCode = connect.getResponseCode();
/* 1001 */         if (responseCode == 200) {
/* 1002 */           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
/* 1003 */           String str = bufferedReader.readLine();
/*      */         }
/*      */       
/*      */       }
/* 1007 */       catch (SocketTimeoutException socketTimeoutException) {}
/*      */     }
/* 1009 */     catch (IOException iOException) {}
/*      */     
/* 1011 */     return s;
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleQuadI(byte b1, int b2, int b3, int b4) {}
/*      */ 
/*      */   
/*      */   public void handleQuad(int b1, int b2, int b3, int b4, EntityPlayer player) {
/* 1019 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 1020 */     if (b1 == 1)
/*      */     {
/*      */       
/* 1023 */       player.field_70170_p.func_72956_a((Entity)player, "jinryuudragonbc:" + JRMCoreH.techSnds(b2, b3, b4), 1.0F, 1.0F);
/*      */     }
/*      */     
/* 1026 */     if (b1 == 2)
/*      */     {
/* 1028 */       if (JRMCoreConfig.DebugInfo) {
/*      */         
/* 1030 */         String info = "JRMC has found Potential hacking at ID:01 by player: %s";
/* 1031 */         mod_JRMCore.logger.info(String.format(info, new Object[] { player.func_70005_c_() }));
/* 1032 */         CommandBase.func_152373_a((ICommandSender)player, null, info, new Object[] { player.func_70005_c_() });
/*      */       } 
/*      */     }
/* 1035 */     if (b1 == 3) {
/*      */       
/* 1037 */       if (b2 == 1) {
/*      */         
/* 1039 */         Random ran = new Random();
/* 1040 */         int r = ran.nextInt(1000000);
/* 1041 */         JRMCoreH.setInt(r, player, "JRMCGID");
/* 1042 */         JRMCoreH.setString(player.func_70005_c_(), player, "JRMCGLIDs");
/*      */       }
/* 1044 */       else if (b2 == 2) {
/*      */         
/* 1046 */         String l = JRMCoreH.getString(player, "JRMCGIDis");
/* 1047 */         EntityPlayerMP entityPlayerMP = JRMCoreH.getPlayerForUsername(server, l);
/* 1048 */         if (entityPlayerMP != null) {
/* 1049 */           int gid = JRMCoreH.getInt((EntityPlayer)entityPlayerMP, "JRMCGID");
/* 1050 */           String lsl = JRMCoreH.getString((EntityPlayer)entityPlayerMP, "JRMCGLIDs");
/* 1051 */           int gmn = 0;
/* 1052 */           if (server.func_71213_z() != null && (server.func_71213_z()).length > 0)
/* 1053 */             for (int pl = 0; pl < (server.func_71213_z()).length; pl++) {
/* 1054 */               EntityPlayerMP e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 1055 */               int egid = JRMCoreH.getInt((EntityPlayer)e, "JRMCGID");
/* 1056 */               if (egid == gid) gmn++; 
/* 1057 */             }   if (lsl.equalsIgnoreCase(l) && gmn < 10) {
/*      */ 
/*      */             
/* 1060 */             JRMCoreH.setString(l, player, "JRMCGLIDs");
/* 1061 */             JRMCoreH.setInt(gid, player, "JRMCGID");
/* 1062 */             JRMCoreH.setString(" ", player, "JRMCGIDis");
/*      */           } else {
/* 1064 */             JRMCoreH.setString(" ", player, "JRMCGLIDs");
/* 1065 */             JRMCoreH.setInt(0, player, "JRMCGID");
/* 1066 */             JRMCoreH.setString(" ", player, "JRMCGIDis");
/*      */           } 
/*      */         } else {
/* 1069 */           JRMCoreH.setString(" ", player, "JRMCGIDis");
/*      */         }
/*      */       
/* 1072 */       } else if (b2 == 3) {
/*      */         
/* 1074 */         JRMCoreH.setString(" ", player, "JRMCGIDis");
/*      */       }
/* 1076 */       else if (b2 == 4) {
/*      */         
/* 1078 */         int gid = JRMCoreH.getInt(player, "JRMCGID");
/* 1079 */         String lid = JRMCoreH.getString(player, "JRMCGLIDs");
/* 1080 */         if (player.func_70005_c_().equalsIgnoreCase(lid) && 
/* 1081 */           server.func_71213_z() != null && (server.func_71213_z()).length > 0) {
/* 1082 */           for (int pl = 0; pl < (server.func_71213_z()).length; pl++) {
/* 1083 */             EntityPlayerMP e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 1084 */             int egid = JRMCoreH.getInt((EntityPlayer)e, "JRMCGID");
/* 1085 */             if (egid == gid) {
/* 1086 */               JRMCoreH.setString(" ", (EntityPlayer)e, "JRMCGLIDs");
/* 1087 */               JRMCoreH.setInt(0, (EntityPlayer)e, "JRMCGID");
/* 1088 */               JRMCoreH.setString(" ", (EntityPlayer)e, "JRMCGIDis");
/*      */             }
/*      */           
/*      */           }
/*      */         
/*      */         }
/* 1094 */       } else if (b2 == 5) {
/* 1095 */         int gid = JRMCoreH.getInt(player, "JRMCGID");
/* 1096 */         String lid = JRMCoreH.getString(player, "JRMCGLIDs");
/* 1097 */         if (player.func_70005_c_().equalsIgnoreCase(lid)) {
/* 1098 */           String i = " ";
/* 1099 */           if (server.func_71213_z() != null && (server.func_71213_z()).length > 0) {
/* 1100 */             int pl; for (pl = 0; pl < (server.func_71213_z()).length; pl++) {
/* 1101 */               EntityPlayerMP e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 1102 */               int egid = JRMCoreH.getInt((EntityPlayer)e, "JRMCGID");
/*      */               
/* 1104 */               if (gid == egid && player.func_145782_y() != e.func_145782_y()) {
/* 1105 */                 i = e.func_70005_c_();
/*      */                 break;
/*      */               } 
/*      */             } 
/* 1109 */             for (pl = 0; pl < (server.func_71213_z()).length; pl++) {
/* 1110 */               EntityPlayerMP e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 1111 */               int egid = JRMCoreH.getInt((EntityPlayer)e, "JRMCGID");
/*      */               
/* 1113 */               if (egid == gid && i.length() > 2) {
/* 1114 */                 JRMCoreH.setString(i, (EntityPlayer)e, "JRMCGLIDs");
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/* 1119 */         JRMCoreH.setString(" ", player, "JRMCGLIDs");
/* 1120 */         JRMCoreH.setInt(0, player, "JRMCGID");
/* 1121 */         JRMCoreH.setString(" ", player, "JRMCGIDis");
/*      */       }
/* 1123 */       else if (b2 == 6) {
/*      */         
/* 1125 */         EntityPlayerMP inv = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[b3 * 100 + b4]);
/* 1126 */         if (inv != null && 
/* 1127 */           JRMCoreH.getInt((EntityPlayer)inv, "JRMCGID") == 0)
/*      */         {
/* 1129 */           JRMCoreH.setString(player.func_70005_c_(), (EntityPlayer)inv, "JRMCGIDis");
/*      */         
/*      */         }
/*      */       }
/* 1133 */       else if (b2 == 7) {
/*      */         
/* 1135 */         int gid = JRMCoreH.getInt(player, "JRMCGID");
/* 1136 */         if (server.func_71213_z() != null && (server.func_71213_z()).length > 0) {
/* 1137 */           EntityPlayerMP entityPlayerMP; int i = 0;
/* 1138 */           Entity nl = null; int pl;
/* 1139 */           for (pl = 0; pl < (server.func_71213_z()).length; pl++) {
/* 1140 */             EntityPlayerMP e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 1141 */             int egid = JRMCoreH.getInt((EntityPlayer)e, "JRMCGID");
/*      */             
/* 1143 */             if (egid == gid) {
/* 1144 */               if (i == b3) {
/* 1145 */                 entityPlayerMP = e;
/*      */               }
/* 1147 */               i++;
/*      */             } 
/*      */           } 
/* 1150 */           for (pl = 0; pl < (server.func_71213_z()).length; pl++) {
/* 1151 */             EntityPlayerMP e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 1152 */             int egid = JRMCoreH.getInt((EntityPlayer)e, "JRMCGID");
/*      */             
/* 1154 */             if (egid == gid) {
/* 1155 */               JRMCoreH.setString(entityPlayerMP.func_70005_c_(), (EntityPlayer)e, "JRMCGLIDs");
/*      */             }
/*      */           }
/*      */         
/*      */         } 
/* 1160 */       } else if (b2 == 8) {
/*      */         
/* 1162 */         int gid = JRMCoreH.getInt(player, "JRMCGID");
/* 1163 */         int i = 0;
/* 1164 */         if (server.func_71213_z() != null && (server.func_71213_z()).length > 0) {
/* 1165 */           for (int pl = 0; pl < (server.func_71213_z()).length; pl++) {
/* 1166 */             EntityPlayerMP e = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[pl]);
/* 1167 */             int egid = JRMCoreH.getInt((EntityPlayer)e, "JRMCGID");
/* 1168 */             if (egid == gid) {
/* 1169 */               if (i == b3 && !e.func_70005_c_().equalsIgnoreCase(player.func_70005_c_())) {
/* 1170 */                 JRMCoreH.setString(" ", (EntityPlayer)e, "JRMCGLIDs");
/* 1171 */                 JRMCoreH.setInt(0, (EntityPlayer)e, "JRMCGID");
/*      */               } 
/* 1173 */               i++;
/*      */             }
/*      */           
/*      */           } 
/*      */         }
/*      */       } 
/* 1179 */     } else if (b1 == 10) {
/*      */       
/* 1181 */       NBTTagCompound nbt = nbt(player, "pres");
/* 1182 */       int tp = nbt.func_74762_e("jrmcTpint");
/*      */       
/* 1184 */       if (b2 == 0) {
/*      */         
/* 1186 */         if (!JRMCoreH.isFusionSpectator((Entity)player))
/*      */         {
/* 1188 */           if (tp > 0)
/*      */           {
/* 1190 */             nbt.func_74768_a("jrmcTpint", tp - 1);
/* 1191 */             byte acc = nbt.func_74771_c(Acc);
/* 1192 */             byte pwrtyp = nbt.func_74771_c(P);
/* 1193 */             byte rce = nbt.func_74771_c(R);
/* 1194 */             byte cls = nbt.func_74771_c(Cl);
/* 1195 */             byte st = nbt.func_74771_c(St);
/* 1196 */             int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
/* 1197 */             int melee = JRMCoreH.stat((Entity)player, 0, pwrtyp, 0, PlyrAttrbts[0], rce, cls, 0.0F);
/* 1198 */             int maxBody = JRMCoreH.stat((Entity)player, 2, pwrtyp, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/*      */ 
/*      */             
/* 1201 */             EntityNPCshadow var8 = new EntityNPCshadow(player.field_70170_p, player, maxBody, melee, (EntityLivingBase)player);
/* 1202 */             var8.func_70012_b(player.field_70165_t - 0.0D, player.field_70163_u + 1.5D, player.field_70161_v - 0.0D, player.field_70177_z, player.field_70125_A);
/* 1203 */             player.field_70170_p.func_72838_d((Entity)var8);
/*      */           }
/*      */           else
/*      */           {
/* 1207 */             player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "You need more TP to Start training"));
/*      */           }
/*      */         
/*      */         }
/* 1211 */       } else if (b2 == 1) {
/*      */         
/* 1213 */         if (JGConfigMiniGameConcentration.TPGainOn)
/*      */         {
/* 1215 */           if (b3 == -1)
/*      */           {
/* 1217 */             PD.sendTo((IMessage)new JRMCorePQuad(b1, b2, 0, nbt.func_74762_e("jrmcTPlimit")), (EntityPlayerMP)player);
/*      */           }
/* 1219 */           else if (b3 == 0)
/*      */           {
/* 1221 */             nbt.func_74768_a("jrmcTpint", tp - 1);
/*      */           }
/* 1223 */           else if (b3 == 1)
/*      */           {
/* 1225 */             int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
/* 1226 */             int possibleReward = (int)(b4 * JGConfigMiniGameConcentration.TPMultiplier);
/*      */             
/* 1228 */             int dailyLimit = (int)(JGConfigMiniGameConcentration.TPDailyLimit * ((JGConfigMiniGameConcentration.TPlimitIncreasesWithPlayerLevel > 0.0F) ? (JRMCoreH.getPlayerLevel(PlyrAttrbts) * JGConfigMiniGameConcentration.TPlimitIncreasesWithPlayerLevel) : 1.0F));
/* 1229 */             int limitAlreadyReached = nbt.func_74762_e("jrmcTPlimit");
/* 1230 */             int actualReward = limitAlreadyReached + possibleReward;
/* 1231 */             int reward = possibleReward;
/* 1232 */             if (dailyLimit < actualReward) {
/*      */               
/* 1234 */               reward = possibleReward - actualReward - dailyLimit;
/* 1235 */               actualReward = dailyLimit;
/*      */             } 
/* 1237 */             if (reward > 0) {
/*      */               
/* 1239 */               int result = tp + reward;
/* 1240 */               if (result > JRMCoreH.getMaxTP()) result = JRMCoreH.getMaxTP(); 
/* 1241 */               nbt.func_74768_a("jrmcTpint", result);
/*      */               
/* 1243 */               nbt.func_74768_a("jrmcTPlimit", actualReward);
/* 1244 */               player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "Reward from Minigame " + reward + " TP"));
/*      */               
/* 1246 */               String info = "JRMC given reward of %sTP from minigame at ID:02 by player: %s";
/* 1247 */               if (JRMCoreConfig.DebugInfo)
/*      */               {
/* 1249 */                 mod_JRMCore.logger.info(String.format(info, new Object[] { Integer.valueOf(reward), player.func_70005_c_() }));
/*      */               }
/*      */             } 
/* 1252 */             PD.sendTo((IMessage)new JRMCorePQuad(b1, b2, b3, nbt.func_74762_e("jrmcTPlimit")), (EntityPlayerMP)player);
/*      */           }
/*      */         
/*      */         }
/* 1256 */       } else if (b2 == 2) {
/*      */         
/* 1258 */         if (JGConfigMiniGameAirBoxing.TPGainOn)
/*      */         {
/* 1260 */           if (b3 == -1) {
/*      */             
/* 1262 */             PD.sendTo((IMessage)new JRMCorePQuad(b1, b2, 1, nbt.func_74762_e("jrmcTPlimit2")), (EntityPlayerMP)player);
/*      */           }
/* 1264 */           else if (b3 == 0) {
/*      */             
/* 1266 */             nbt.func_74768_a("jrmcTpint", tp - 1);
/*      */           }
/* 1268 */           else if (b3 == 1) {
/*      */             
/* 1270 */             int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
/* 1271 */             int possibleReward = (int)(b4 * JGConfigMiniGameAirBoxing.TPMultiplier);
/*      */             
/* 1273 */             int dailyLimit = (int)(JGConfigMiniGameAirBoxing.TPDailyLimit * ((JGConfigMiniGameAirBoxing.TPlimitIncreasesWithPlayerLevel > 0.0F) ? (JRMCoreH.getPlayerLevel(PlyrAttrbts) * JGConfigMiniGameAirBoxing.TPlimitIncreasesWithPlayerLevel) : 1.0F));
/* 1274 */             int limitAlreadyReached = nbt.func_74762_e("jrmcTPlimit2");
/* 1275 */             int actualReward = limitAlreadyReached + possibleReward;
/* 1276 */             int reward = possibleReward;
/* 1277 */             if (dailyLimit < actualReward) {
/*      */               
/* 1279 */               reward = possibleReward - actualReward - dailyLimit;
/* 1280 */               actualReward = dailyLimit;
/*      */             } 
/* 1282 */             if (reward > 0) {
/*      */               
/* 1284 */               int result = tp + reward;
/* 1285 */               if (result > JRMCoreH.getMaxTP()) result = JRMCoreH.getMaxTP(); 
/* 1286 */               nbt.func_74768_a("jrmcTpint", result);
/* 1287 */               nbt.func_74768_a("jrmcTPlimit2", actualReward);
/* 1288 */               player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "Reward from Minigame " + reward + " TP"));
/*      */               
/* 1290 */               String info = "JRMC given reward of %sTP from minigame at ID:02 by player: %s";
/* 1291 */               if (JRMCoreConfig.DebugInfo)
/*      */               {
/* 1293 */                 mod_JRMCore.logger.info(String.format(info, new Object[] { Integer.valueOf(reward), player.func_70005_c_() }));
/*      */               }
/*      */             } 
/* 1296 */             PD.sendTo((IMessage)new JRMCorePQuad(b1, b2, b3, nbt.func_74762_e("jrmcTPlimit2")), (EntityPlayerMP)player);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleFall(byte b, EntityPlayer p) {
/* 1307 */     if (b == 1 || b == 2) JRMCoreH.setByte((b == 1) ? 1 : 0, p, "jrmcStnd");
/*      */   
/*      */   }
/*      */   
/*      */   public void handleTech(byte b, String s, EntityPlayer p) {
/* 1312 */     if (JRMCoreConfig.osbic > 0 && ((Integer)JRMCoreH.osbic.get(p.func_70005_c_())).intValue() < JRMCoreConfig.osbic * 20) {
/*      */       
/* 1314 */       p.func_145747_a((new ChatComponentTranslation("Offline Protection: " + (
/* 1315 */             (int)((JRMCoreConfig.osbic * 20 - ((Integer)JRMCoreH.osbic.get(p.func_70005_c_())).intValue()) * 0.05F) + 1) + "s left", new Object[0])).func_150255_a(chatStyle));
/*      */       
/*      */       return;
/*      */     } 
/* 1319 */     int pwrtyp = JRMCoreH.getByte(p, P);
/* 1320 */     String te = "te;;;";
/* 1321 */     String ug = "ug;;;";
/* 1322 */     String up = "up;;;";
/* 1323 */     String dn = "dn;;;";
/* 1324 */     if (s.contains(dn) || s.contains(up)) {
/* 1325 */       int b2 = s.contains(up) ? ((b - 1 < ((b > 3) ? 4 : 0)) ? ((b > 3) ? 7 : 3) : (b - 1)) : ((b + 1 > ((b > 3) ? 7 : 3)) ? ((b > 3) ? 4 : 0) : (b + 1));
/* 1326 */       String s1 = JRMCoreH.getString(p, JRMCoreH.techNbt[b]);
/* 1327 */       String s2 = JRMCoreH.getString(p, JRMCoreH.techNbt[b2]);
/* 1328 */       JRMCoreH.setString(s1, p, JRMCoreH.techNbt[b2]);
/* 1329 */       JRMCoreH.setString(s2, p, JRMCoreH.techNbt[b]);
/*      */     }
/* 1331 */     else if (s.contains(ug)) {
/* 1332 */       if (b >= 0 && b <= 3) {
/* 1333 */         int id = Integer.parseInt(s.replaceAll(ug, ""));
/* 1334 */         String s1 = JRMCoreH.getString(p, JRMCoreH.techNbt[b]);
/* 1335 */         JRMCoreH.setString(JRMCoreH.tech_upgrd(s1, id), p, JRMCoreH.techNbt[b]);
/*      */       }
/*      */     
/* 1338 */     } else if (s.contains(te)) {
/* 1339 */       if (b >= 0 && b <= 3) {
/* 1340 */         EntityPlayer va = JRMCoreH.getClosestPlayerToEntity((Entity)p, 8.0D);
/* 1341 */         if (va != null) {
/* 1342 */           String toteach = JRMCoreH.tech_teach(JRMCoreH.getString(p, JRMCoreH.techNbt[b]));
/* 1343 */           String[] tn = JRMCoreH.tech_conv(toteach.split(";"));
/* 1344 */           int costTp = JRMCoreH.techDBCtpc(tn, true) * 2;
/* 1345 */           va.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "teachingOffer"), new Object[] { p.func_70005_c_(), tn[0], Integer.valueOf(costTp) })).func_150255_a(JRMCoreH2.styl_ylw));
/* 1346 */           JRMCoreH.setString(toteach + ";:;" + p.func_70005_c_(), va, "jrmcTechLearn");
/*      */         } else {
/* 1348 */           p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "noOneToTeach"), new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*      */         }
/*      */       
/*      */       } 
/* 1352 */     } else if (b >= 0 && b <= 7) {
/* 1353 */       if (!s.contains(";") && s.length() > 0) {
/* 1354 */         if (s.equals(" ")) {
/* 1355 */           String s1 = JRMCoreH.getString(p, JRMCoreH.techNbt[b]);
/* 1356 */           if (!s1.equals(" ") && !s1.equals("") && 
/* 1357 */             pwrtyp == 1) {
/* 1358 */             if (b >= 4) {
/* 1359 */               int s2 = Integer.parseInt(s1);
/* 1360 */               String[][] PMA = JRMCoreH.pmdbc;
/* 1361 */               int costTp = (int)(JRMCoreH.techDBCtpc(PMA[s2], false) * 0.9F) / 2;
/* 1362 */               int tp = JRMCoreH.getInt(p, "jrmcTpint");
/* 1363 */               JRMCoreH.setInt(tp + costTp, p, "jrmcTpint");
/* 1364 */             } else if (s1.contains(";")) {
/* 1365 */               String[] s2 = s1.toString().split(";");
/* 1366 */               int costTp = JRMCoreH.techDBCtpc(s2, false) / 2;
/* 1367 */               int tp = JRMCoreH.getInt(p, "jrmcTpint");
/* 1368 */               JRMCoreH.setInt(tp + costTp, p, "jrmcTpint");
/*      */             } 
/*      */           }
/*      */           
/* 1372 */           JRMCoreH.setString(" ", p, JRMCoreH.techNbt[b]);
/*      */         } else {
/* 1374 */           int s2 = Integer.parseInt(s);
/* 1375 */           String[][] PMA = (String[][])null;
/* 1376 */           if (pwrtyp == 2) {
/* 1377 */             PMA = JRMCoreH.pmj;
/* 1378 */             int costP = JRMCoreH.techNCCostP[Integer.parseInt(PMA[s2][7])];
/* 1379 */             float cost1000 = costP * 0.01F * 1000.0F;
/* 1380 */             int sped = Integer.parseInt(PMA[s2][4]);
/* 1381 */             int type = Integer.parseInt(PMA[s2][3]);
/* 1382 */             int dmg1000 = (int)(cost1000 - cost1000 * 0.25F * sped + ((type == 0) ? (cost1000 * 0.2F) : 0.0F));
/* 1383 */             int costTp = (int)(20.0F + cost1000 / 2.0F);
/* 1384 */             int cost = (int)(costTp * 1.5F);
/* 1385 */             int tp = JRMCoreH.getInt(p, "jrmcTpint");
/* 1386 */             if (tp - cost >= 0) {
/* 1387 */               JRMCoreH.setInt(tp - cost, p, "jrmcTpint");
/* 1388 */               JRMCoreH.setString("" + s2, p, JRMCoreH.techNbt[b]);
/*      */               
/* 1390 */               p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("nc", "LearnedJutsu"), new Object[0])).func_150255_a(chatStyle));
/*      */             } 
/*      */           } else {
/* 1393 */             boolean may = false;
/* 1394 */             if (b == 4)
/* 1395 */               for (int i = 0; i < 4; i++) {
/* 1396 */                 String s1 = JRMCoreH.getString(p, JRMCoreH.techNbt[4 + i]);
/* 1397 */                 if (NumberUtils.isNumber(s1) || s1.contains(",")) {
/* 1398 */                   may = false;
/*      */                 } else {
/* 1400 */                   b = (byte)(4 + i); may = true;
/*      */                   break;
/*      */                 } 
/*      */               }  
/* 1404 */             PMA = JRMCoreH.pmdbc;
/* 1405 */             int costTp = (int)(JRMCoreH.techDBCtpc(PMA[s2], false) * 0.9F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1412 */             int cost = costTp;
/* 1413 */             int tp = JRMCoreH.getInt(p, "jrmcTpint");
/* 1414 */             if (tp - cost >= 0 && may) {
/* 1415 */               JRMCoreH.setInt(tp - cost, p, "jrmcTpint");
/* 1416 */               JRMCoreH.setString("" + s2, p, JRMCoreH.techNbt[b]);
/*      */             } else {
/*      */               
/* 1419 */               p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "noslotleft"), new Object[0])).func_150255_a(chatStyle));
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } else {
/* 1424 */         String[] s2 = s.contains(";") ? s.toString().split(";") : null;
/* 1425 */         if (s2 == null) {
/* 1426 */           JRMCoreH.setString(" ", p, JRMCoreH.techNbt[b]);
/*      */         } else {
/*      */           
/* 1429 */           int costTp = JRMCoreH.techDBCtpc(s2, false);
/*      */ 
/*      */           
/* 1432 */           int tp = JRMCoreH.getInt(p, "jrmcTpint");
/* 1433 */           if (tp - costTp >= 0) {
/* 1434 */             JRMCoreH.setInt(tp - costTp, p, "jrmcTpint");
/* 1435 */             JRMCoreH.setString(s, p, JRMCoreH.techNbt[b]);
/* 1436 */             JRMCoreH.Tech(p, b, s);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleAttck(byte b, EntityPlayer p) {}
/*      */   
/*      */   public void handleCost(short s, EntityPlayer p) {
/* 1447 */     NBTTagCompound nbt = nbt(p, "pres");
/*      */     
/* 1449 */     int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
/* 1450 */     byte pwr = nbt.func_74771_c(P);
/* 1451 */     byte rce = nbt.func_74771_c(R);
/* 1452 */     byte cls = nbt.func_74771_c(Cl);
/*      */     
/* 1454 */     int maxBody = JRMCoreH.stat((Entity)p, 2, pwr, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/* 1455 */     int curBody = JRMCoreH.getInt(p, "jrmcBdy");
/*      */     
/* 1457 */     int maxEnergy = JRMCoreH.stat((Entity)p, 5, pwr, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(p, pwr));
/* 1458 */     int curEnergy = JRMCoreH.getInt(p, "jrmcEnrgy");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1463 */     int fc = curEnergy - s;
/* 1464 */     if (fc > 0)
/*      */     {
/* 1466 */       if (!JRMCoreH.isInCreativeMode((Entity)p)) JRMCoreH.setInt(fc, p, "jrmcEnrgy"); 
/*      */     }
/* 1468 */     if (fc <= 0) {
/*      */       
/* 1470 */       JRMCoreH.setInt(0, p, "jrmcEnrgy");
/* 1471 */       JRMCoreH.setByte(0, p, "jrmcRelease");
/* 1472 */       JRMCoreH.setInt(curBody + fc, p, "jrmcBdy");
/*      */     } 
/*      */     
/* 1475 */     curBody = JRMCoreH.getInt(p, "jrmcBdy");
/* 1476 */     if (curBody < 0)
/*      */     {
/* 1478 */       JRMCoreH.setInt(0, p, "jrmcBdy");
/*      */     }
/*      */     
/* 1481 */     JRMCoreH.Stats(p, nbt.func_74762_e("jrmcBdy"), nbt.func_74762_e("jrmcEnrgy"), nbt.func_74762_e("jrmcStamina"), nbt.func_74771_c("jrmcRelease"), nbt.func_74771_c("jrmcSaiRg"));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleRls(byte b, EntityPlayer p) {
/* 1487 */     NBTTagCompound nbt = nbt(p, "pres");
/*      */     
/* 1489 */     int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
/* 1490 */     String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
/*      */     
/* 1492 */     byte pwr = nbt.func_74771_c(P);
/* 1493 */     byte rce = nbt.func_74771_c(R);
/* 1494 */     byte cls = nbt.func_74771_c(Cl);
/* 1495 */     byte rls = JRMCoreH.getByte(p, "jrmcRelease");
/* 1496 */     byte st2 = nbt.func_74771_c("jrmcState2");
/*      */     
/* 1498 */     if (!JRMCoreConfig.release) {
/*      */       
/* 1500 */       JRMCoreH.setByte(50, p, "jrmcRelease");
/*      */     }
/*      */     else {
/*      */       
/* 1504 */       int mr = JRMCoreH.SklLvl((pwr == 1) ? 5 : ((pwr == 2) ? 10 : 0), pwr, PlyrSkills) * 5;
/* 1505 */       if (b == 0 && st2 <= 0)
/*      */       {
/* 1507 */         JRMCoreH.setByte(0, p, "jrmcRelease");
/*      */       }
/*      */       
/* 1510 */       if (b == 1 && rls < 100) {
/*      */         
/* 1512 */         int relmax = 50 + mr;
/* 1513 */         rls = (byte)((rls + 5 > 100) ? 100 : (rls + 5));
/* 1514 */         rls = (byte)((rls > relmax) ? relmax : rls);
/* 1515 */         JRMCoreH.setByte(rls, p, "jrmcRelease");
/*      */       } 
/*      */       
/* 1518 */       if (b == 2 && rls > 0 && st2 <= 0)
/*      */       {
/* 1520 */         JRMCoreH.setByte((rls - 5 < 0) ? 0 : (rls - 5), p, "jrmcRelease");
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleTri(byte b, byte b2, byte b3, EntityPlayer p) {
/* 1530 */     NBTTagCompound nbt = nbt(p, "pres");
/*      */     
/* 1532 */     if (b == 1) {
/*      */       
/* 1534 */       if (b2 == RAGE_GAIN_MINUS) {
/*      */         
/* 1536 */         int rg = nbt.func_74771_c("jrmcSaiRg") - b3;
/* 1537 */         nbt.func_74774_a("jrmcSaiRg", (rg < 0) ? 0 : (byte)rg);
/*      */       } 
/* 1539 */       if (b2 == RAGE_GAIN_PLUS) {
/*      */         
/* 1541 */         int rg = nbt.func_74771_c("jrmcSaiRg") + b3;
/* 1542 */         nbt.func_74774_a("jrmcSaiRg", (rg > 100) ? 100 : (byte)rg);
/*      */       } 
/*      */     } 
/*      */     
/* 1546 */     if (b == 2) {
/*      */       
/* 1548 */       ExtendedPlayer props = ExtendedPlayer.get(p);
/* 1549 */       props.setBlocking(b2);
/*      */     } 
/*      */     
/* 1552 */     if (b == 3) {
/*      */       
/* 1554 */       ExtendedPlayer props = ExtendedPlayer.get(p);
/* 1555 */       props.setAnimKiShoot(b2);
/* 1556 */       props.setAnimKiShootOn(1);
/* 1557 */       int color = 0;
/* 1558 */       int align = 0;
/* 1559 */       String StE = nbt.func_74779_i("jrmcStatusEff");
/* 1560 */       boolean setGoDOn = JRMCoreH.StusEfcts(20, StE);
/* 1561 */       float density = 1.0F;
/* 1562 */       float dam = 1.0F;
/* 1563 */       int part = 0;
/* 1564 */       String data = "";
/*      */       
/* 1566 */       byte[] sts = new byte[0];
/* 1567 */       byte perc = 100;
/* 1568 */       int dam1 = 1;
/* 1569 */       boolean isCustomAttack = false;
/*      */ 
/*      */       
/*      */       try {
/* 1573 */         String s1 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[b3]));
/*      */         
/* 1575 */         if ((s1.split(";")).length > 1) {
/*      */           
/* 1577 */           isCustomAttack = true;
/* 1578 */           color = Integer.parseInt(s1.split(";")[10]);
/*      */           
/* 1580 */           density = Float.parseFloat(s1.split(";")[11]);
/* 1581 */           dam = Float.parseFloat(s1.split(";")[5]);
/* 1582 */           data = s1.split(";")[0];
/* 1583 */           sts = new byte[0];
/* 1584 */           sts = JRMCoreH.tech_statmods(s1.split(";")[19]);
/* 1585 */           perc = 100;
/*      */         
/*      */         }
/* 1588 */         else if (!s1.equals(" ") && s1 != null) {
/*      */           
/* 1590 */           color = Integer.parseInt(JRMCoreH.pmdbc[Integer.parseInt(s1)][10]);
/* 1591 */           density = Float.parseFloat(JRMCoreH.pmdbc[Integer.parseInt(s1)][11]);
/* 1592 */           dam = Float.parseFloat(JRMCoreH.pmdbc[Integer.parseInt(s1)][5]);
/* 1593 */           data = JRMCoreH.pmdbc[Integer.parseInt(s1)][0];
/*      */         } 
/* 1595 */         dam1 = JRMCoreH.getEnegyDamage(p, s1.split(";"), sts);
/* 1596 */         align = JRMCoreH.getByte(p, "jrmcAlign");
/*      */       }
/* 1598 */       catch (Exception exception) {}
/*      */       
/* 1600 */       if (color == 0) {
/*      */         
/* 1602 */         if (align > 66) color = 2; 
/* 1603 */         if (align <= 66 && align >= 33) color = 3; 
/* 1604 */         if (align < 33) color = 4; 
/*      */       } 
/* 1606 */       props.setGoDOn((setGoDOn && isCustomAttack && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENABLED) ? 1 : 0);
/* 1607 */       props.setKiShotCol(color);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1612 */       float size = JRMCoreH.calculateEnergyScale(dam1, JRMCoreH.getMaxEnergyDamage(), perc, sts, (byte)(int)density, 0.01F, 0.1F);
/*      */ 
/*      */       
/* 1615 */       props.setKiShotSiz(size);
/* 1616 */       if (data.toLowerCase().contains("spiritbomb") || data.toLowerCase().contains("spirit bomb")) { part = 1; }
/* 1617 */       else if (data.toLowerCase().contains("kahame") || data.toLowerCase().contains("kamehame") || data.toLowerCase().contains("kame hame")) { part = 2; }
/* 1618 */       else if (data.toLowerCase().contains("galic")) { part = 4; }
/*      */       else
/*      */       
/*      */       { 
/*      */         try {
/* 1623 */           String s1 = JRMCoreH.tech_conv(nbt.func_74779_i(JRMCoreH.techNbt[b3]));
/* 1624 */           if ((s1.split(";")).length > 1)
/*      */           
/*      */           { 
/*      */             
/* 1628 */             if (s1 != null && 
/* 1629 */               Integer.parseInt(s1.split(";")[3]) == 8 && 
/* 1630 */               Integer.parseInt(s1.split(";")[6]) == 1) part = 3;
/*      */              }
/*      */           
/* 1633 */           else if (!s1.equals(" ") && JRMCoreH.pmdbc[Integer.parseInt(s1)] != null && 
/* 1634 */             Integer.parseInt(JRMCoreH.pmdbc[Integer.parseInt(s1)][3]) == 8 && 
/* 1635 */             Integer.parseInt(JRMCoreH.pmdbc[Integer.parseInt(s1)][6]) == 1) { part = 3; }
/*      */         
/* 1637 */         } catch (Exception exception) {} }
/*      */       
/* 1639 */       props.setKiShotPart(part);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1644 */     if (b == 4) {
/*      */       
/* 1646 */       int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
/* 1647 */       byte pwr = JRMCoreH.getByte(p, "jrmcPwrtyp");
/* 1648 */       byte rce = JRMCoreH.getByte(p, "jrmcRace");
/* 1649 */       byte cls = JRMCoreH.getByte(p, "jrmcClass");
/*      */ 
/*      */       
/* 1652 */       int maxEnergy = JRMCoreH.stat((Entity)p, 5, pwr, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(p, pwr));
/* 1653 */       int ce = JRMCoreH.getInt(p, "jrmcEnrgy");
/* 1654 */       int maxStam = JRMCoreH.stat((Entity)p, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
/* 1655 */       int cs = JRMCoreH.getInt(p, "jrmcStamina");
/*      */ 
/*      */       
/* 1658 */       int n = (b3 >= 4) ? JRMCoreH.SklLvl(3, p) : JRMCoreH.SklLvl(2, p);
/*      */       
/* 1660 */       int cst = (int)((maxStam * ((b3 == 5) ? (0.1F - 0.005F * n) : (0.2F - ((b == 4) ? 0.005F : 0.01F) * n))) * DBCConfig.cnfFlncst);
/* 1661 */       if (cs > cst) {
/* 1662 */         if (!JRMCoreH.isInCreativeMode((Entity)p)) JRMCoreH.setInt(cs - cst, p, "jrmcStamina"); 
/* 1663 */         if (b3 != 4) p.field_70170_p.func_72956_a((Entity)p, (b3 == 5) ? "jinryuudragonbc:DBC2.swoop" : "jinryuudragonbc:DBC2.tp", 0.25F, p.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F); 
/*      */       } 
/* 1665 */       if (b3 >= 4) {
/*      */         
/* 1667 */         cst = (int)((12 - n) * DBCConfig.cnfFlnck);
/* 1668 */         if (ce > cst)
/*      */         {
/* 1670 */           if (!JRMCoreH.isInCreativeMode((Entity)p)) JRMCoreH.setInt(ce - cst, p, "jrmcEnrgy");
/*      */         
/*      */         }
/*      */       } 
/*      */     } 
/* 1675 */     if (b == 5)
/*      */     {
/* 1677 */       if (b2 == 0)
/*      */       {
/* 1679 */         if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */           
/* 1681 */           byte st2 = nbt.func_74771_c("jrmcState2");
/* 1682 */           if (JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[(st2 > 0) ? (st2 - 1) : 0] > 0) {
/*      */             
/* 1684 */             int heat = nbt.func_74762_e("jrmcEf8slc");
/* 1685 */             double heatD = nbt.func_74769_h("jrmcEf8slcD");
/*      */             
/* 1687 */             int heatGain = 1;
/* 1688 */             if (JGConfigDBCFormMastery.FM_Enabled) {
/* 1689 */               JGPlayerMP jgPlayer = new JGPlayerMP(p);
/* 1690 */               jgPlayer.setNBT(nbt);
/* 1691 */               int race = jgPlayer.getRace();
/* 1692 */               int formID = JRMCoreH.getFormID("UltraInstict", race);
/* 1693 */               double masteryLevel = JRMCoreH.getFormMasteryValue(p, formID);
/*      */               
/* 1695 */               float costMulti = (float)JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_UI_HEAT_MULTI);
/*      */               
/* 1697 */               heatGain = (int)(heatGain * costMulti);
/*      */             } 
/*      */             
/* 1700 */             heatD += heatGain;
/* 1701 */             heat += (int)heatD;
/* 1702 */             heatD -= (int)heatD;
/* 1703 */             nbt.func_74780_a("jrmcEf8slcD", heatD);
/*      */ 
/*      */             
/* 1706 */             int heat_max = JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[(st2 > 0) ? (st2 - 1) : 0];
/* 1707 */             nbt.func_74768_a("jrmcEf8slc", (heat > heat_max) ? heat_max : heat);
/*      */           } 
/*      */         }  }  } 
/*      */   }
/*      */   public void handleStats3(byte b, byte b2, byte b3, EntityPlayer p) {
/*      */     int[][] rSklsLvl;
/*      */     String[] cSkls;
/*      */     int[][] cSklsLvl;
/*      */     String[] skls;
/*      */     int sklsUps[], sklsLvl[][], sklsMR[][];
/* 1717 */     if (JRMCoreConfig.osbic > 0 && ((Integer)JRMCoreH.osbic.get(p.func_70005_c_())).intValue() < JRMCoreConfig.osbic * 20) {
/*      */       
/* 1719 */       p.func_145747_a((new ChatComponentTranslation("Offline Protection: " + ((int)((JRMCoreConfig.osbic * 20 - ((Integer)JRMCoreH.osbic.get(p.func_70005_c_())).intValue()) * 0.05F) + 1) + "s left", new Object[0])).func_150255_a(chatStyle));
/*      */       
/*      */       return;
/*      */     } 
/* 1723 */     NBTTagCompound nbt = nbt(p, "pres");
/* 1724 */     JGPlayerMP jgPlayer = new JGPlayerMP(p);
/* 1725 */     jgPlayer.setNBT(nbt);
/* 1726 */     byte powerType = jgPlayer.getPowerType();
/*      */     
/* 1728 */     if (JRMCoreH.isPowerTypeKi(powerType) && (b == 1 || b == 2 || b == 3 || b == 4) && 
/* 1729 */       JRMCoreH.isFused((Entity)p)) {
/*      */       
/* 1731 */       p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc", "cantupgradef"), new Object[0])).func_150255_a(chatStyle));
/*      */       
/*      */       return;
/*      */     } 
/* 1735 */     int[] playerAttributes = jgPlayer.getAttributes();
/* 1736 */     String[] playerSkills = jgPlayer.getSkills();
/* 1737 */     byte race = jgPlayer.getRace();
/* 1738 */     int playerSkillsCount = playerSkills.length;
/* 1739 */     String PlyrSkillX = jgPlayer.getSkillsX();
/* 1740 */     String PlyrSkillY = jgPlayer.getSkillsY();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1746 */     int[][] rSklsMR = (int[][])null;
/*      */ 
/*      */ 
/*      */     
/* 1750 */     int[][] cSklsMR = (int[][])null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1758 */     if (JRMCoreH.isPowerTypeChakra(powerType)) {
/*      */       
/* 1760 */       String[] rSkls = JRMCoreH.ncRSkls;
/* 1761 */       rSklsLvl = JRMCoreH.ncRSklsLvl;
/* 1762 */       String[] rSklsNms = JRMCoreH.ncRSklsNms;
/*      */       
/* 1764 */       cSkls = JRMCoreH.ncCSkls;
/* 1765 */       cSklsLvl = JRMCoreH.NCRacialSkillTPCost;
/* 1766 */       String[] cSklsNms = JRMCoreH.NCRacialSkillAbilityNames;
/* 1767 */       cSklsMR = JRMCoreH.NCRacialSkillMindCost;
/* 1768 */       skls = JRMCoreH.NCSkillIDs;
/* 1769 */       sklsUps = JRMCoreH.ncSklsUps;
/* 1770 */       sklsLvl = JRMCoreH.NCSkillTPCost;
/* 1771 */       String[] sklsNms = JRMCoreH.NCSkillNames;
/* 1772 */       sklsMR = JRMCoreH.NCSkillMindCost;
/* 1773 */       String mod = "nc";
/*      */     }
/*      */     else {
/*      */       
/* 1777 */       String[] rSkls = JRMCoreH.vlblRSkls;
/* 1778 */       rSklsLvl = JRMCoreH.DBCRacialSkillTPCost;
/* 1779 */       String[] rSklsNms = JRMCoreH.vlblRSklsNms;
/* 1780 */       rSklsMR = JRMCoreH.DBCRacialSkillMindCost;
/* 1781 */       cSkls = JRMCoreH.vlblCSkls;
/* 1782 */       cSklsLvl = JRMCoreH.vlblCSklsLvl;
/* 1783 */       String[] cSklsNms = JRMCoreH.vlblCSklsNms;
/*      */       
/* 1785 */       skls = JRMCoreH.DBCSkillsIDs;
/* 1786 */       sklsUps = JRMCoreH.vlblSklsUps;
/* 1787 */       sklsLvl = JRMCoreH.DBCSkillTPCost;
/* 1788 */       String[] sklsNms = JRMCoreH.DBCSkillNames;
/* 1789 */       sklsMR = JRMCoreH.DBCSkillMindCost;
/* 1790 */       String mod = "dbc";
/*      */     } 
/*      */     
/* 1793 */     int skillLevels = JRMCoreH.skillSlot_SpentMindRequirement(playerSkills, skls, sklsMR) + JRMCoreH.skillSlot_SpentMindRequirement_X(PlyrSkillX, race, rSklsMR) + JRMCoreH.skillSlot_SpentMindRequirement(PlyrSkillY, cSkls, cSklsMR);
/* 1794 */     boolean SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], skillLevels);
/*      */ 
/*      */     
/* 1797 */     if (b == 1) {
/*      */       
/* 1799 */       boolean doit = true;
/* 1800 */       if (b2 == 16 && JGConfigUltraInstinct.CONFIG_UI_LEVELS == 0) doit = false;
/*      */       
/* 1802 */       if (doit) {
/*      */         
/* 1804 */         int currentTP = nbt.func_74762_e("jrmcTpint");
/* 1805 */         int tpCost = JRMCoreH.getSkillTPCost(b2, 0, JRMCoreH.isPowerTypeKi(powerType));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1822 */         boolean bln = true;
/* 1823 */         boolean tc = false;
/*      */         
/* 1825 */         if (JRMCoreH.isPowerTypeKi(powerType) && b2 == 10) {
/*      */           
/* 1827 */           bln = false;
/* 1828 */           tc = (currentTP >= tpCost);
/*      */         } 
/*      */ 
/*      */         
/* 1832 */         if ((bln && tpCost != -1 && currentTP >= tpCost) || (!bln && tc))
/*      */         {
/* 1834 */           boolean saiNotMxdSkl = (JRMCoreH.isPowerTypeKi(powerType) && b2 == 9) ? ((JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godKiAble(race, JRMCoreH.SklLvlX(p)))) : true;
/* 1835 */           if (!saiNotMxdSkl) {
/*      */             
/* 1837 */             p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", JRMCoreH.rc_sai(race) ? "needRacialSkillMax" : "cantLearnThis"), new Object[0])).func_150255_a(chatStyle));
/*      */             return;
/*      */           } 
/* 1840 */           boolean stop = false;
/*      */           
/* 1842 */           int haveSkills = 0; byte i;
/* 1843 */           for (i = 0; i < playerSkillsCount; i = (byte)(i + 1)) {
/*      */             
/* 1845 */             if (playerSkills[i].contains(skls[b2]))
/*      */             {
/* 1847 */               stop = true;
/*      */             }
/* 1849 */             if (playerSkills[i].length() > 2)
/*      */             {
/* 1851 */               haveSkills++;
/*      */             }
/*      */           } 
/*      */           
/* 1855 */           int mindRequirement = JRMCoreH.skillMindRequirement(skls[b2], skls, sklsMR);
/* 1856 */           int mindRequirementResult = skillLevels + mindRequirement;
/* 1857 */           SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], mindRequirementResult);
/*      */           
/* 1859 */           String StE = nbt.func_74779_i("jrmcStatusEff");
/* 1860 */           boolean isFused = JRMCoreH.isFused((Entity)p);
/*      */           
/* 1862 */           if (isFused)
/*      */           {
/* 1864 */             p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc", "cantupgradef"), new Object[0])).func_150255_a(chatStyle));
/*      */           }
/* 1866 */           else if (JRMCoreH.isPowerTypeKi(powerType) && b2 == 0 && !JRMCoreConfig.fuzn)
/*      */           {
/* 1868 */             p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "skilldisabled"), new Object[0])).func_150255_a(chatStyle));
/*      */           }
/* 1870 */           else if (stop)
/*      */           {
/* 1872 */             p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "alreadyhaveskill"), new Object[0])).func_150255_a(chatStyle));
/*      */           }
/* 1874 */           else if (!SklSlt)
/*      */           {
/* 1876 */             p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "nomindleft"), new Object[0])).func_150255_a(chatStyle));
/*      */           }
/*      */           else
/*      */           {
/* 1880 */             nbt.func_74778_a("jrmcSSlts", JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts") + "," + skls[b2] + "0"));
/*      */             
/* 1882 */             int tpResult = currentTP - tpCost;
/* 1883 */             nbt.func_74768_a("jrmcTpint", tpResult);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       } 
/* 1889 */     } else if (b == 2) {
/*      */       
/* 1891 */       if (playerSkills[b2].contains(skls[8]))
/*      */       {
/* 1893 */         JRMCoreH.PlyrSettingsRem(p, 0);
/*      */       }
/* 1895 */       String sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(playerSkills[b2], ""));
/* 1896 */       nbt.func_74778_a("jrmcSSlts", (sn2.length() < 3) ? "," : sn2);
/*      */     
/*      */     }
/* 1899 */     else if (b == 3) {
/*      */       
/* 1901 */       boolean doit = true;
/* 1902 */       String StE = nbt.func_74779_i("jrmcStatusEff");
/* 1903 */       boolean f = (JRMCoreH.StusEfcts(10, StE) || JRMCoreH.StusEfcts(11, StE));
/* 1904 */       if (f) {
/* 1905 */         p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc", "cantupgradef"), new Object[0])).func_150255_a(chatStyle));
/*      */         return;
/*      */       } 
/* 1908 */       String skill = (b2 == 100) ? "jrmcSSltX" : ((b2 == 101) ? "jrmcSSltY" : ((b2 == 102) ? "jrmcSSltZ" : "jrmcSSlts"));
/* 1909 */       String sklnm = nbt.func_74779_i(skill);
/* 1910 */       if (skill.equals("jrmcSSlts")) {
/*      */         
/* 1912 */         int mindRequirement = JRMCoreH.skillMindRequirement(playerSkills[b2], skls, sklsMR);
/* 1913 */         int mindRequirementResult = skillLevels + mindRequirement;
/* 1914 */         SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], mindRequirementResult);
/*      */         
/* 1916 */         sklnm = playerSkills[b2];
/* 1917 */         if (!SklSlt) {
/* 1918 */           p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "nomindleft"), new Object[0])).func_150255_a(chatStyle));
/*      */         }
/*      */       }
/* 1921 */       else if (b2 == 100) {
/*      */         
/* 1923 */         int mindRequirement = JRMCoreH.skillMindRequirement_X(sklnm, race, rSklsMR);
/* 1924 */         int mindRequirementResult = skillLevels + mindRequirement;
/* 1925 */         SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], mindRequirementResult);
/* 1926 */         doit = JRMCoreConfig.dat5711;
/*      */       }
/* 1928 */       else if (b2 == 101) {
/*      */         
/* 1930 */         int mindRequirement = JRMCoreH.skillMindRequirement(sklnm, cSkls, cSklsMR);
/* 1931 */         int mindRequirementResult = skillLevels + mindRequirement;
/* 1932 */         SklSlt = JRMCoreH.canAffordSkill(playerAttributes[4], mindRequirementResult);
/* 1933 */         doit = JRMCoreConfig.dat5711;
/*      */       } 
/*      */       
/* 1936 */       if (!sklnm.equals("pty") && doit) {
/*      */         
/* 1938 */         int skillLvl = Integer.parseInt(sklnm.substring(2)) + 1;
/*      */ 
/*      */         
/* 1941 */         int d = (JRMCoreH.pwr_ki(powerType) && !JRMCoreH.rSai(race) && sklnm.contains(skls[9])) ? -1 : JRMCoreH.SklInit(sklnm, skls, sklsUps);
/* 1942 */         if (skillLvl - 1 <= d) {
/*      */           
/* 1944 */           if (b3 == 1) {
/*      */             
/* 1946 */             int tpCost = 0;
/*      */             
/* 1948 */             if (b2 == 100) {
/*      */               
/* 1950 */               tpCost = JRMCoreH.skillTPCost_X(PlyrSkillX, race, rSklsLvl);
/*      */             }
/* 1952 */             else if (b2 == 101) {
/*      */               
/* 1954 */               tpCost = JRMCoreH.skillTPCost_X(PlyrSkillY, race, cSklsLvl);
/*      */             }
/*      */             else {
/*      */               
/* 1958 */               tpCost = JRMCoreH.skillTPCost(sklnm, skls, sklsLvl);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1992 */             int currentTP = nbt.func_74762_e("jrmcTpint");
/*      */             
/* 1994 */             if (JRMCoreH.rSai(race) && b2 == 100) { skillLvl = (skillLvl > 7) ? 7 : skillLvl; }
/* 1995 */             else if (race == 4 && b2 == 100) { skillLvl = (skillLvl > 6) ? 6 : skillLvl; }
/* 1996 */             else if (race != 4 && b2 == 100) { skillLvl = (skillLvl > 5) ? 5 : skillLvl; }
/* 1997 */             else if (JRMCoreH.isPowerTypeKi(powerType) && b2 < 100 && sklnm.contains(skls[9]) && skillLvl > d + 1) { skillLvl = (skillLvl > d + 1) ? (d + 1) : skillLvl; }
/*      */             
/* 1999 */             if (tpCost != -1 && currentTP >= tpCost && SklSlt)
/*      */             {
/* 2001 */               String nskl = sklnm.substring(0, 2) + ((skillLvl >= 10) ? 9 : skillLvl);
/* 2002 */               if (skill.equals("jrmcSSlts")) {
/*      */                 
/* 2004 */                 String sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(sklnm, nskl));
/* 2005 */                 nbt.func_74778_a(skill, sn2);
/*      */               }
/*      */               else {
/*      */                 
/* 2009 */                 nbt.func_74778_a(skill, nskl);
/*      */               } 
/* 2011 */               if (!sklnm.equalsIgnoreCase(nskl))
/*      */               {
/* 2013 */                 nbt.func_74768_a("jrmcTpint", currentTP - tpCost);
/*      */               
/*      */               }
/*      */             }
/*      */           
/*      */           }
/* 2019 */           else if (JRMCoreConfig.DebugInfo) {
/*      */             
/* 2021 */             String info = "JRMC has found Potential hacking at ID:05 by player: %s";
/* 2022 */             mod_JRMCore.logger.info(String.format(info, new Object[] { p.func_70005_c_() }));
/* 2023 */             CommandBase.func_152373_a((ICommandSender)p, null, info, new Object[] { p.func_70005_c_() });
/*      */           } 
/*      */         } else {
/*      */           
/* 2027 */           String info = "JRMC has blocked an action at ID:10 by player: %s for: %s";
/* 2028 */           mod_JRMCore.logger.info(String.format(info, new Object[] { p.func_70005_c_(), sklnm }));
/*      */         }
/*      */       
/* 2031 */       } else if (!sklnm.equals("pty") && !doit) {
/* 2032 */         String info = "JRMC has found Potential hacking at ID:15 by player: %s";
/* 2033 */         mod_JRMCore.logger.info(String.format(info, new Object[] { p.func_70005_c_(), sklnm }));
/*      */       }
/*      */     
/* 2036 */     } else if (b == 4) {
/*      */       
/* 2038 */       String skl = (b2 == 100) ? "jrmcSSltX" : ((b2 == 101) ? "jrmcSSltY" : "jrmcSSlts");
/* 2039 */       String sklnm = nbt.func_74779_i(skl);
/* 2040 */       if (skl.equals("jrmcSSlts"))
/* 2041 */         sklnm = playerSkills[b2]; 
/* 2042 */       int n = Integer.parseInt(sklnm.substring(2)) - 1;
/*      */       
/* 2044 */       String nskl = sklnm.substring(0, 2) + ((n <= -1) ? 0 : n);
/* 2045 */       if (skl.equals("jrmcSSlts")) {
/* 2046 */         String sn2 = JRMCoreH.cleanUpCommas(nbt.func_74779_i("jrmcSSlts").replaceAll(sklnm, nskl));
/* 2047 */         nbt.func_74778_a(skl, sn2);
/*      */       } else {
/* 2049 */         nbt.func_74778_a(skl, nskl);
/*      */       }
/*      */     
/*      */     }
/* 2053 */     else if (b == 5) {
/*      */       
/* 2055 */       String StE = nbt.func_74779_i("jrmcStatusEff");
/* 2056 */       String bns = JRMCoreH.StusEfcts[b3];
/* 2057 */       if (b2 == 0) nbt.func_74778_a("jrmcStatusEff", StE.contains(bns) ? StE : (StE + bns)); 
/* 2058 */       if (b2 == 1) nbt.func_74778_a("jrmcStatusEff", StE.contains(bns) ? StE.replace(bns, "") : StE);
/*      */ 
/*      */       
/* 2061 */       if (b3 == 3 && b2 == 0 && !JRMCoreH.isInCreativeMode((Entity)p)) {
/* 2062 */         boolean hasGoD = jgPlayer.hasStatusEffect(20, StE);
/* 2063 */         if (hasGoD && JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED && JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA && JGConfigDBCGoD.CONFIG_GOD_ENABLED) {
/* 2064 */           int curEnergy = jgPlayer.getEnergy();
/* 2065 */           byte classID = jgPlayer.getClassID();
/* 2066 */           int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(playerSkills, powerType));
/*      */           
/* 2068 */           float cost = JGConfigDBCGoD.CONFIG_GOD_AURA_KI_COST[1] * maxEnergy;
/* 2069 */           cost += JGConfigDBCGoD.CONFIG_GOD_AURA_KI_COST[0];
/*      */           
/* 2071 */           if (curEnergy > (int)cost) {
/* 2072 */             curEnergy -= (int)cost;
/*      */           } else {
/*      */             
/* 2075 */             StE = JRMCoreH.StusEfcts(3, StE, nbt, false);
/*      */           } 
/* 2077 */           JRMCoreH.setInt(curEnergy, p, "jrmcEnrgy");
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/* 2083 */     else if (b == 6) {
/*      */       
/* 2085 */       if (b3 == 0) JRMCoreH.PlyrSettingsOn(p, b2); 
/* 2086 */       if (b3 == 1) JRMCoreH.PlyrSettingsRem(p, b2);
/*      */     
/* 2088 */     } else if (b == 8) {
/*      */       
/* 2090 */       JRMCoreH.PlyrSettingsSet(nbt, b2, b3);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleStats2(int curTP, int curExp, byte align, int[] PlyrAttrbts) {}
/*      */   
/*      */   public void handleStats(int curBody, int curEnergy, byte curRelease, byte b) {}
/*      */   
/*      */   public void handleUpgrade(byte b, EntityPlayer p) {
/* 2100 */     if (JRMCoreConfig.osbic > 0 && ((Integer)JRMCoreH.osbic.get(p.func_70005_c_())).intValue() < JRMCoreConfig.osbic * 20) {
/*      */       
/* 2102 */       p.func_145747_a((new ChatComponentTranslation("Offline Protection: " + ((int)((JRMCoreConfig.osbic * 20 - ((Integer)JRMCoreH.osbic.get(p.func_70005_c_())).intValue()) * 0.05F) + 1) + "s left", new Object[0])).func_150255_a(chatStyle));
/*      */       
/*      */       return;
/*      */     } 
/* 2106 */     NBTTagCompound nbt = nbt(p, "pres");
/* 2107 */     JGPlayerMP jgPlayer = new JGPlayerMP(p);
/* 2108 */     jgPlayer.setNBT(nbt);
/* 2109 */     byte powerType = jgPlayer.getPowerType();
/*      */     
/* 2111 */     if (JRMCoreH.isPowerTypeKi(powerType) && JRMCoreH.isFused((Entity)p)) {
/*      */       
/* 2113 */       p.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc", "cantupgradef"), new Object[0])).func_150255_a(chatStyle));
/*      */       
/*      */       return;
/*      */     } 
/* 2117 */     int[] playerAttributes = jgPlayer.getAttributes();
/* 2118 */     String[] playerSkills = jgPlayer.getSkills();
/* 2119 */     byte race = jgPlayer.getRace();
/* 2120 */     byte classID = jgPlayer.getClassID();
/*      */     
/* 2122 */     int curBody = jgPlayer.getHealth();
/* 2123 */     int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
/*      */     
/* 2125 */     int curEnergy = jgPlayer.getEnergy();
/* 2126 */     int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(playerSkills, powerType));
/*      */     
/* 2128 */     int curStam = jgPlayer.getStamina();
/* 2129 */     int maxStam = jgPlayer.getStaminaMax(race, classID, powerType, playerAttributes);
/*      */     
/* 2131 */     if (JRMCoreH.isPowerTypeKi(powerType) || JRMCoreH.isPowerTypeChakra(powerType)) {
/*      */       
/* 2133 */       int ma = b / 6;
/* 2134 */       int cost = JRMCoreH.attrCst(playerAttributes, ma);
/*      */       
/* 2136 */       if (cost > 0 && nbt.func_74762_e("jrmcTpint") >= cost && nbt.func_74762_e(JRMCoreH.AttrbtNbtI[b % 6]) < hdN7rK())
/*      */       {
/* 2138 */         int pr = nbt.func_74762_e(JRMCoreH.AttrbtNbtI[b % 6]);
/* 2139 */         pr = (pr < 1) ? ((pr + 32768) / 2 + 32768) : pr;
/* 2140 */         int to = pr + 1 * JRMCoreH.attributeMultiplier(ma);
/* 2141 */         if (to > JRMCoreConfig.tmx)
/* 2142 */           return;  nbt.func_74768_a("jrmcTpint", nbt.func_74762_e("jrmcTpint") - cost);
/* 2143 */         nbt.func_74768_a(JRMCoreH.AttrbtNbtI[b % 6], v2tBFN(to));
/*      */         
/* 2145 */         double incBody = JRMCoreH.statInc(powerType, 2, 1, race, classID, 0.0F);
/* 2146 */         JRMCoreH.setInt((int)((curBody + incBody > maxBody) ? maxBody : (curBody + incBody)), p, "jrmcBdy");
/* 2147 */         double incEnergy = JRMCoreH.statInc(powerType, 5, 1, race, classID, JRMCoreH.SklLvl_KiBs(playerSkills, powerType));
/* 2148 */         JRMCoreH.setInt((int)((curEnergy + incEnergy > maxEnergy) ? maxEnergy : (curEnergy + incEnergy)), p, "jrmcEnrgy");
/* 2149 */         double incStam = JRMCoreH.statInc(powerType, 3, 1, race, classID, 0.0F);
/* 2150 */         JRMCoreH.setInt((int)((curStam + incStam > maxStam) ? maxStam : (curStam + incStam)), p, "jrmcStamina");
/*      */       }
/*      */     
/* 2153 */     } else if (JRMCoreH.isPowerTypeSAO(powerType)) {
/*      */       
/* 2155 */       int ap = nbt.func_74762_e("saocAp");
/* 2156 */       if (ap > 0) {
/*      */         
/* 2158 */         nbt.func_74768_a(JRMCoreH.AttrbtNbtI[b], (short)(nbt.func_74762_e(JRMCoreH.AttrbtNbtI[b]) + 1));
/* 2159 */         nbt.func_74768_a("saocAp", nbt.func_74762_e("saocAp") - 1);
/* 2160 */         if (b == 2) {
/*      */           
/* 2162 */           playerAttributes = JRMCoreH.PlyrAttrbts(p);
/* 2163 */           maxBody = JRMCoreH.stat((Entity)p, 2, powerType, 2, playerAttributes[2], race, classID, 0.0F);
/* 2164 */           double incBody = JRMCoreH.statInc(powerType, 2, 1, race, classID, 0.0F);
/* 2165 */           JRMCoreH.setInt((int)((curBody + incBody > maxBody) ? maxBody : (curBody + incBody)), p, "jrmcBdy");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2170 */     JRMCoreH.Stats2(p, nbt.func_74762_e("jrmcTpint"), nbt.func_74771_c("jrmcExp"), nbt.func_74771_c("jrmcAlign"), playerAttributes);
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleChar(byte b, int b2, EntityPlayer p) {
/* 2175 */     NBTTagCompound nbt = nbt(p, "pres");
/* 2176 */     int i = 20;
/* 2177 */     byte acc = nbt.func_74771_c(Acc);
/* 2178 */     byte pwrtyp = nbt.func_74771_c(P);
/* 2179 */     byte rce = nbt.func_74771_c(R);
/* 2180 */     byte cls = nbt.func_74771_c(Cl);
/* 2181 */     byte st = nbt.func_74771_c(St);
/* 2182 */     if (acc == 0 && b == b(0)) { nbt.func_74774_a(R, (byte)b2); nbt.func_74774_a(St, (byte)((rce == 4) ? 4 : 0)); }
/* 2183 */      if (acc == 0 && b == 106) {
/* 2184 */       nbt.func_74774_a(St, (byte)((rce == 4) ? b2 : 0));
/*      */     }
/* 2186 */     if (acc == 0 && b == b(7)) nbt.func_74776_a("JRYCAge", JRMCoreH.YearsD[b2]);
/*      */ 
/*      */ 
/*      */     
/* 2190 */     if (acc == 0 && b == b(2)) nbt.func_74774_a(P, (byte)b2); 
/* 2191 */     if (acc == 0 && b == b(3)) nbt.func_74774_a(Cl, (byte)b2); 
/* 2192 */     if (acc == 0 && b == b(4)) {
/*      */       
/* 2194 */       boolean doit = true;
/*      */       
/* 2196 */       if (JRMCoreH.DBC())
/*      */       {
/* 2198 */         doit = !JRMCoreH.isFused((Entity)p);
/*      */       }
/*      */       
/* 2201 */       if (doit) {
/*      */         int[] PlyrAttrbts;
/* 2203 */         nbt.func_74774_a(Acc, (byte)b2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2209 */         if (pwrtyp == 1 || pwrtyp == 2) {
/*      */           
/* 2211 */           nbt.func_74774_a(St, (byte)((rce == 4) ? 4 : 0));
/* 2212 */           int r = JRMCoreH.getInt(p, "jrmcRencrnt");
/* 2213 */           if (r == 1) {
/* 2214 */             JRMCoreH.setInt(0, p, "jrmcRencrnt");
/* 2215 */             for (int j = 0; j < 6; j++) {
/* 2216 */               int a = JRMCoreH.getInt(p, JRMCoreH.AttrbtNbtR[j]);
/* 2217 */               int s = JRMCoreH.attributeStart(pwrtyp, j, rce, cls);
/* 2218 */               nbt.func_74768_a(JRMCoreH.AttrbtNbtI[j], (a > s) ? a : s);
/* 2219 */               JRMCoreH.setInt(0, p, JRMCoreH.AttrbtNbtR[j]);
/*      */             } 
/*      */           } else {
/* 2222 */             for (int j = 0; j < 6; j++) {
/* 2223 */               nbt.func_74768_a(JRMCoreH.AttrbtNbtI[j], JRMCoreH.attributeStart(pwrtyp, j, rce, cls));
/*      */             }
/*      */           } 
/* 2226 */           PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
/* 2227 */           int maxBody = JRMCoreH.stat((Entity)p, 2, pwrtyp, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/* 2228 */           JRMCoreH.setInt(maxBody, p, "jrmcBdy");
/* 2229 */           int maxEnergy = JRMCoreH.stat((Entity)p, 5, pwrtyp, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(p, pwrtyp));
/* 2230 */           JRMCoreH.setInt(maxEnergy, p, "jrmcEnrgy");
/*      */         }
/*      */         else {
/*      */           
/* 2234 */           for (int j = 0; j < 3; j++) {
/* 2235 */             nbt.func_74768_a(JRMCoreH.AttrbtNbtI[j], JRMCoreH.attributeStart(pwrtyp, j, rce, cls));
/*      */           }
/* 2237 */           PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
/* 2238 */           int maxBody = JRMCoreH.stat((Entity)p, 2, pwrtyp, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/* 2239 */           JRMCoreH.setInt(maxBody, p, "jrmcBdy");
/*      */         } 
/*      */         
/* 2242 */         JRMCoreH.Stats2(p, nbt.func_74762_e("jrmcTpint"), nbt.func_74771_c("jrmcExp"), nbt.func_74771_c("jrmcAlign"), PlyrAttrbts);
/*      */         
/* 2244 */         nbt.func_74778_a("jrmcSSltX", JRMCoreH.SklGveX(nbt.func_74771_c(R), nbt.func_74771_c(Cl), pwrtyp));
/* 2245 */         nbt.func_74778_a("jrmcSSltY", JRMCoreH.SklGveY(nbt.func_74771_c(R), nbt.func_74771_c(Cl), pwrtyp));
/* 2246 */         nbt.func_74768_a("jrmcArcRsrv", 0);
/* 2247 */         nbt.func_74778_a("jrmcMajinAbsorptionData", "0,0,0+0");
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2252 */     if (b == b(5) && nbt.func_74771_c(Diff) < b2) nbt.func_74774_a(Diff, (byte)b2); 
/* 2253 */     if (b == b(6)) nbt.func_74774_a(Ptch, (byte)b2); 
/* 2254 */     if (b == 100 && 
/* 2255 */       !JRMCoreH.isFused((Entity)p)) {
/*      */       
/* 2257 */       JRMCoreH.resetDedSer();
/* 2258 */       JRMCoreH.resetChar(p);
/*      */     } 
/*      */     
/* 2261 */     if (b == 101 && 
/* 2262 */       nbt.func_74771_c(Diff) >= 1 && nbt.func_74762_e("jrmcDiffRed") <= 1) nbt.func_74768_a("jrmcDiffRed", 2400 * nbt.func_74771_c(Diff));
/*      */     
/* 2264 */     if (b == 102)
/* 2265 */       if (nbt.func_74771_c("jrmcTlmd") == 0 || nbt.func_74771_c("jrmcTlmd") == -1) { nbt.func_74774_a("jrmcTlmd", (byte)1); }
/* 2266 */       else if (nbt.func_74771_c("jrmcTlmd") == 1) { nbt.func_74774_a("jrmcTlmd", (byte)0); }
/*      */        
/* 2268 */     if (acc == 0 && b == 103) {
/* 2269 */       if (b2 == 0) nbt.func_74774_a("jrmcTlmd", (byte)2); 
/* 2270 */       if (b2 == 1) nbt.func_74774_a("jrmcTlmd", (byte)0); 
/*      */     } 
/* 2272 */     if (b == 104) {
/* 2273 */       if (nbt.func_74771_c("jrmcTlmd") == 0 || nbt.func_74771_c("jrmcTlmd") == -1 || nbt.func_74771_c("jrmcTlmd") == 1) nbt.func_74774_a("jrmcTlmd", (byte)3); 
/* 2274 */       int state = JRMCoreH.getByte(p, "jrmcState");
/* 2275 */       if (state == 7 || state == 8 || state == 14)
/* 2276 */         JRMCoreH.setByte(0, p, "jrmcState"); 
/*      */     } 
/* 2278 */     if (b == 105) {
/* 2279 */       int tp = nbt.func_74762_e("jrmcTpint");
/* 2280 */       int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
/* 2281 */       int maxBody = JRMCoreH.stat((Entity)p, 2, pwrtyp, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/* 2282 */       if ((nbt.func_74771_c("jrmcTlmd") == 3 || nbt.func_74771_c("jrmcTlmd") == 4) && tp >= 20) {
/* 2283 */         nbt.func_74768_a("jrmcTpint", tp - 20);
/* 2284 */         JRMCoreH.jrmcDam((Entity)p, (int)(maxBody * 0.1F), null);
/* 2285 */         nbt.func_74774_a("jrmcTlmd", (byte)0);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleCol(int i, byte b, EntityPlayer p) {
/* 2292 */     NBTTagCompound nbt = nbt(p, "pres");
/*      */   }
/*      */   
/*      */   public void handleTick(int jrmcpg, String jrmcp, EntityPlayer p)
/*      */   {
/* 2297 */     NBTTagCompound nbt = nbt(p, "pres");
/*      */     
/* 2299 */     if (jrmcpg == 1) {
/* 2300 */       if (nbt.func_74781_a("jrmcAlign") == null) nbt.func_74774_a("jrmcAlign", (byte)67); 
/* 2301 */       if (nbt.func_74771_c("jrmcAlign") > 100) nbt.func_74774_a("jrmcAlign", (byte)100); 
/* 2302 */       if (nbt.func_74771_c("jrmcAlign") < 0) nbt.func_74774_a("jrmcAlign", (byte)0);
/*      */       
/* 2304 */       int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(p);
/* 2305 */       String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(","); byte i;
/* 2306 */       for (i = 0; i < JRMCoreH.AttrbtNbtI.length; ) { if (nbt.func_74781_a(JRMCoreH.AttrbtNbtI[i]) == null) nbt.func_74768_a(JRMCoreH.AttrbtNbtI[i], 1);  PlyrAttrbts[i] = nbt.func_74762_e(JRMCoreH.AttrbtNbtI[i]); i = (byte)(i + 1); }
/* 2307 */        JRMCoreH.Stats2(p, nbt.func_74762_e("jrmcTpint"), nbt.func_74771_c("jrmcExp"), nbt.func_74771_c("jrmcAlign"), PlyrAttrbts);
/*      */     } 
/* 2309 */     if (jrmcpg == 3) {
/* 2310 */       if (nbt.func_74781_a("jrmcSSltX") == null) nbt.func_74778_a("jrmcSSltX", "pty"); 
/* 2311 */       if (nbt.func_74781_a("jrmcSSltY") == null) nbt.func_74778_a("jrmcSSltY", "pty");
/*      */ 
/*      */       
/* 2314 */       nbt.func_74778_a("jrmcSSltX", JRMCoreH.SklGveX(nbt.func_74771_c(R), nbt.func_74771_c(Cl), nbt.func_74771_c(P)));
/* 2315 */       nbt.func_74778_a("jrmcSSltY", JRMCoreH.SklGveY(nbt.func_74771_c(R), nbt.func_74771_c(Cl), nbt.func_74771_c(P)));
/*      */ 
/*      */       
/* 2318 */       JRMCoreH.Stats3(p, nbt.func_74779_i("jrmcSSlts"), nbt.func_74779_i("jrmcSSltX"), nbt.func_74779_i("jrmcSSltY"), nbt.func_74779_i("jrmcSSltZ"));
/*      */     } 
/* 2320 */     if (jrmcpg == -1) {
/* 2321 */       byte i; for (i = 0; i < 4; ) { String s = JRMCoreH.getString(p, JRMCoreH.techNbt[i]); JRMCoreH.Tech(p, i, s); i = (byte)(i + 1); }
/*      */     
/*      */     }  } int calc1(int j, int l) { int i;
/*      */     int k;
/* 2325 */     for (i = 0, k = 0; k < j; ) { i += i + l; k++; }  return i; } int calc2(int j, int l) { int i; int k;
/* 2326 */     for (i = 0, k = 0; k < j / l; ) { int z = (k * l / 50 <= 0) ? 1 : (k * l / 50); i += z; k++; }  return i; }
/*      */ 
/*      */   
/* 2329 */   public static String R = "jrmcRace";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2334 */   public static String P = "jrmcPwrtyp";
/* 2335 */   public static String Cl = "jrmcClass";
/* 2336 */   public static String Acc = "jrmcAccept";
/* 2337 */   public static String St = "jrmcState";
/* 2338 */   public static String Diff = "jrmcDiff";
/* 2339 */   public static String Ptch = "jrmcPtch"; public static int dS9XgQ(String l) { String w;
/*      */     int a;
/*      */     int i;
/* 2342 */     for (w = "0123456789ABCDEF", l = l.toUpperCase(), a = 0, i = 0; i < l.length(); ) { char c = l.charAt(i); int d = w.indexOf(c); a = 16 * a + d; i++; }  return a; }
/*      */ 
/*      */   
/*      */   public static int hdN7rK()
/*      */   {
/* 2347 */     int b = JRMCoreConfig.tmx; String r = "64", k = "3B9ACA00"; return (b > dS9XgQ(k)) ? dS9XgQ(k) : ((b < dS9XgQ(r)) ? 0 : b); } public static int v2tBFN(int b) {
/* 2348 */     String k = "3B9ACA00"; return (b > dS9XgQ(k)) ? dS9XgQ(k) : b;
/*      */   }
/*      */   public byte b(int n) {
/* 2351 */     return (byte)n;
/*      */   }
/*      */   
/*      */   public NBTTagCompound nbt(EntityPlayer p, String s) {
/* 2355 */     return JRMCoreH.nbt((Entity)p, s);
/*      */   }
/*      */   public void jrmct(int tick, String s, EntityPlayer p) {
/* 2358 */     JRMCoreH.jrmct(tick, s, p);
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCorePacHanS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */