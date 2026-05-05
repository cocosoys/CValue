/*      */ package JinRyuu.JRMCore;
/*      */ 
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*      */ import JinRyuu.JRMCore.client.notification.JGNotification;
/*      */ import JinRyuu.JRMCore.client.notification.JGNotificationGUI;
/*      */ import JinRyuu.JRMCore.client.notification.JGNotificationHandlerC;
/*      */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*      */ import JinRyuu.JRMCore.entity.EntityJRMCexpl;
/*      */ import JinRyuu.JRMCore.entity.ExplosionJRMC;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
/*      */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
/*      */ import JinRyuu.JRMCore.server.config.core.JGConfigSkills;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCAAiDifficulty;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import com.google.common.collect.Lists;
/*      */ import com.google.gson.Gson;
/*      */ import cpw.mods.fml.common.network.ByteBufUtils;
/*      */ import io.netty.buffer.ByteBuf;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JRMCorePacHanC
/*      */ {
/*      */   public double explosionX;
/*      */   public double explosionY;
/*      */   public double explosionZ;
/*      */   public float explosionSize;
/*      */   public List chunkPositionRecords;
/*      */   public float playerVelocityX;
/*      */   public float playerVelocityY;
/*      */   public float playerVelocityZ;
/*      */   public boolean expGriOff;
/*      */   public double expDam;
/*      */   public Entity origin;
/*      */   public byte type;
/*      */   
/*      */   public void handleExpl(double explosionX, double explosionY, double explosionZ, float explosionSize, boolean expGriOff, double expDam, Entity origin, List chunkPositionRecords, float playerVelocityX, float playerVelocityY, float playerVelocityZ, EntityPlayer p, byte type) {
/*   51 */     this.explosionX = explosionX;
/*   52 */     this.explosionY = explosionY;
/*   53 */     this.explosionZ = explosionZ;
/*   54 */     this.explosionSize = explosionSize;
/*   55 */     this.expGriOff = expGriOff;
/*   56 */     this.expDam = expDam;
/*   57 */     this.chunkPositionRecords = chunkPositionRecords;
/*   58 */     int var3 = (int)this.explosionX;
/*   59 */     int var4 = (int)this.explosionY;
/*   60 */     int var5 = (int)this.explosionZ;
/*      */     
/*   62 */     this.playerVelocityX = playerVelocityX;
/*   63 */     this.playerVelocityY = playerVelocityY;
/*   64 */     this.playerVelocityZ = playerVelocityZ;
/*      */     
/*   66 */     this.type = type;
/*   67 */     this.origin = origin;
/*      */     
/*   69 */     if (p != null && this.origin != null && 
/*   70 */       p.field_71093_bK == this.origin.field_71093_bK) {
/*   71 */       handleExplosion();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleExplosion() {
/*   78 */     ExplosionJRMC var2 = new ExplosionJRMC((World)JRMCoreClient.mc.field_71441_e, (Entity)null, this.explosionX, this.explosionY, this.explosionZ, this.explosionSize, this.expGriOff, this.expDam, this.origin, this.type);
/*   79 */     var2.field_77281_g = this.chunkPositionRecords;
/*   80 */     var2.func_77279_a(false);
/*   81 */     JRMCoreClient.mc.field_71439_g.field_70159_w += this.playerVelocityX;
/*   82 */     JRMCoreClient.mc.field_71439_g.field_70181_x += this.playerVelocityY;
/*   83 */     JRMCoreClient.mc.field_71439_g.field_70179_y += this.playerVelocityZ;
/*      */ 
/*      */     
/*   86 */     EntityJRMCexpl aura = new EntityJRMCexpl((World)JRMCoreClient.mc.field_71441_e, this.type);
/*   87 */     if (aura != null) {
/*   88 */       aura.func_70012_b(this.explosionX, this.explosionY, this.explosionZ, 0.0F, 0.0F);
/*   89 */       aura.explsiz = this.explosionSize;
/*   90 */       JRMCoreClient.mc.field_71441_e.func_72838_d((Entity)aura);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleQuadI(byte b1, int b2, int b3, int b4) {}
/*      */   
/*      */   public void handleQuad(int b1, int b2, int b3, int b4, EntityPlayer p) {
/*   98 */     if (b1 == 10)
/*      */     {
/*  100 */       if (b2 == 1 && b3 == 0) { JRMCoreH.trngTPlmt = b4; }
/*  101 */       else if (b2 == 2 && b3 == 1) { JRMCoreH.trngTPlmt2 = b4; }
/*      */     
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleData(int dataID, String d, EntityPlayer p) {
/*  110 */     if (dataID == 80) {
/*  111 */       String o = (d.isEmpty() || d.equalsIgnoreCase("error")) ? "0" : d;
/*  112 */       int i = Integer.parseInt(o);
/*  113 */       JRMCoreH.ServerPoints = i;
/*      */     } 
/*      */     
/*  116 */     if (dataID == 1) {
/*  117 */       if (d == "::") {
/*  118 */         JRMCoreH.plyrsArnd = null;
/*      */       } else {
/*  120 */         JRMCoreH.plyrsArnd = d.toString().replaceAll("::", "").split(":");
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  125 */     if (dataID >= -1 && dataID <= 40) {
/*  126 */       if (dataID != 32) {
/*  127 */         JRMCoreH.rdc(d.toString().replaceAll("::", "").split(":"), dataID);
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*  132 */       else if (d.startsWith("::")) {
/*  133 */         JRMCoreH.dat32 = null;
/*      */         
/*  135 */         String[] data = d.toString().substring(2).split("::");
/*  136 */         String[] segmentsS = data[0].split("/");
/*  137 */         int segmentID = Integer.parseInt(segmentsS[0]);
/*  138 */         int segments = Integer.parseInt(segmentsS[1]);
/*  139 */         int players = Integer.parseInt(segmentsS[2]);
/*  140 */         int startID = Integer.parseInt(segmentsS[3]);
/*      */         
/*  142 */         if (segmentID == 0) {
/*  143 */           JRMCoreH.dat32Segmented = new String[players];
/*      */         }
/*  145 */         String[] dataFinal = data[1].replaceAll("::", "").split(":");
/*      */         
/*  147 */         for (int i = 0; i < dataFinal.length; i++) {
/*  148 */           JRMCoreH.dat32Segmented[startID + i] = dataFinal[i];
/*      */         }
/*      */         
/*  151 */         if (segmentID == segments - 1) {
/*  152 */           JRMCoreH.dat32 = JRMCoreH.dat32Segmented;
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/*  157 */         JRMCoreH.rdc(d.toString().replaceAll("::", "").split(":"), dataID);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  162 */     if (dataID == -1) {
/*  163 */       JRMCoreH.plyrs = d.replaceAll("::", "").split(":");
/*      */     }
/*      */     
/*  166 */     if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreClient.mc.field_71439_g != null) {
/*  167 */       if (dataID == 1) {
/*  168 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  169 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  170 */             String[] s = JRMCoreH.data1[pl].split(";");
/*  171 */             JRMCoreH.Race = Byte.parseByte(s[0]);
/*  172 */             JRMCoreH.dns = s[1];
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  177 */             JRMCoreH.Pwrtyp = Byte.parseByte(s[2]);
/*  178 */             JRMCoreH.Class = Byte.parseByte(s[3]);
/*  179 */             JRMCoreH.Accepted = Byte.parseByte(s[4]);
/*      */             
/*  181 */             ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)JRMCoreClient.mc.field_71439_g);
/*  182 */             JRMCoreH.dnsH = props.getHairCode();
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  188 */       if (dataID == 2) {
/*  189 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  190 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  191 */             String[] s = JRMCoreH.data2[pl].split(";");
/*  192 */             JRMCoreH.State = Byte.parseByte(s[0]);
/*  193 */             JRMCoreH.State2 = Byte.parseByte(s[1]);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  198 */       if (dataID == 7) {
/*  199 */         String s = JRMCoreH.data7[0];
/*  200 */         if (JRMCoreH.Pwrtyp == 3 && JRMCoreH.Accepted == 1) {
/*  201 */           JRMCoreH.sao_col = Integer.parseInt(s);
/*      */         } else {
/*  203 */           String[] s3 = s.contains(";;") ? s.toString().split(";;") : null;
/*  204 */           if (s3 != null) {
/*  205 */             for (int i = 0; i < s3.length; i++) {
/*  206 */               String[] s2 = s3[i].contains(";") ? s3[i].toString().split(";") : null;
/*  207 */               switch (i) { case 0:
/*  208 */                   JRMCoreH.tech1 = s2; break;
/*  209 */                 case 1: JRMCoreH.tech2 = s2; break;
/*  210 */                 case 2: JRMCoreH.tech3 = s2; break;
/*  211 */                 case 3: JRMCoreH.tech4 = s2;
/*      */                   break; }
/*      */ 
/*      */             
/*      */             } 
/*      */           } else {
/*  217 */             JRMCoreH.tech1 = JRMCoreH.tech2 = JRMCoreH.tech3 = JRMCoreH.tech4 = null;
/*      */           } 
/*      */         } 
/*      */       } 
/*  221 */       if (dataID == 15) {
/*  222 */         String s = JRMCoreH.dat15[0];
/*  223 */         if (JRMCoreH.Pwrtyp == 3 && JRMCoreH.Accepted == 1) {
/*  224 */           JRMCoreH.sao_exp = Integer.parseInt(s);
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  232 */       if (dataID == 6) {
/*  233 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  234 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_()) && JRMCoreH.data6.length >= JRMCoreH.plyrs.length) {
/*      */             
/*  236 */             String[] s = JRMCoreH.data6[pl].split(";");
/*  237 */             JRMCoreH.PlyrSkillX = s[1];
/*  238 */             JRMCoreH.PlyrSkillY = s[2];
/*  239 */             JRMCoreH.PlyrSkillZ = s[3];
/*  240 */             String[] PlyrSkills = s[0].split(",");
/*  241 */             JRMCoreH.PlyrSkills = PlyrSkills;
/*  242 */             String[] si = s[4].split(",");
/*  243 */             int[] i = new int[si.length];
/*  244 */             for (int a = 0; a < si.length; a++) {
/*  245 */               i[a] = (si[a].length() > 0 && !si[a].equals(" ")) ? Integer.parseInt(si[a]) : -1;
/*      */             }
/*  247 */             JRMCoreH.techPM = i;
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  252 */       if (dataID == 8) {
/*  253 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  254 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  255 */             String s = JRMCoreH.data8[pl];
/*  256 */             JRMCoreH.curBody = Integer.parseInt(s);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  261 */       if (dataID == 9) {
/*  262 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  263 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  264 */             String s = JRMCoreH.data9[pl];
/*  265 */             JRMCoreH.curEnergy = Integer.parseInt(s);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  270 */       if (dataID == 10) {
/*  271 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  272 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  273 */             String[] s = JRMCoreH.dat10[pl].split(";");
/*  274 */             JRMCoreH.curRelease = Byte.parseByte(s[0]);
/*  275 */             JRMCoreH.curStamina = Integer.parseInt(s[1]);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  280 */       if (dataID == 4) {
/*  281 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  282 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  283 */             String[] s = JRMCoreH.data4[pl].split(";");
/*  284 */             JRMCoreH.TransSaiCurRg = Byte.parseByte(s[0]);
/*  285 */             JRMCoreH.cura = Integer.parseInt(s[1]);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  290 */       if (dataID == 5) {
/*  291 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  292 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*      */ 
/*      */ 
/*      */             
/*  296 */             String[] s = JRMCoreH.data5[pl].split(";");
/*  297 */             JRMCoreH.align = Byte.parseByte(s[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  319 */       if (dataID == 11) {
/*  320 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  321 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  322 */             String[] s = JRMCoreH.data1[pl].split(";");
/*  323 */             int pwr = Byte.parseByte(s[2]);
/*  324 */             int acc = Byte.parseByte(s[4]);
/*  325 */             if (pwr == 3 && acc == 1) {
/*  326 */               s = JRMCoreH.dat11[pl].split(";");
/*  327 */               JRMCoreH.sao_level = Integer.parseInt(s[0]);
/*  328 */               JRMCoreH.sao_ap = Integer.parseInt(s[1]); break;
/*      */             } 
/*  330 */             String st = JRMCoreH.dat11[pl];
/*  331 */             JRMCoreH.curTP = Integer.parseInt(st);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  337 */       if (dataID == 12) {
/*  338 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  339 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  340 */             String s1 = JRMCoreH.dat12[pl];
/*  341 */             JRMCoreH.curExp = Integer.parseInt(s1);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  346 */       if (dataID == 14) {
/*  347 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  348 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  349 */             String[] s = JRMCoreH.dat14[pl].split(",");
/*  350 */             int[] PlyrAttrbts = new int[JRMCoreH.PlyrAttrbts.length];
/*  351 */             for (int i = 0; i < PlyrAttrbts.length; ) { PlyrAttrbts[i] = Integer.parseInt(s[i]); i++; }
/*  352 */              JRMCoreH.PlyrAttrbts = PlyrAttrbts;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  365 */             byte pwr = JRMCoreH.Pwrtyp;
/*  366 */             byte rce = JRMCoreH.Race;
/*  367 */             byte cls = JRMCoreH.Class;
/*  368 */             JRMCoreH.maxBody = JRMCoreH.stat((Entity)p, 2, pwr, 2, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
/*  369 */             JRMCoreH.maxEnergy = JRMCoreH.stat((Entity)p, 5, pwr, 5, JRMCoreH.PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(pwr));
/*  370 */             JRMCoreH.maxStamina = JRMCoreH.stat((Entity)p, 2, pwr, 3, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  375 */       if (dataID == 18) {
/*  376 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  377 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  378 */             String s = JRMCoreH.dat18[pl];
/*  379 */             String[] a = s.split(";");
/*  380 */             JRMCoreH.Dffclty = Byte.parseByte(a[0]);
/*  381 */             JRMCoreH.PtchVc = Byte.parseByte(a[1]);
/*  382 */             JRMCoreH.FznDC = a[2];
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  387 */       if (dataID == 19) {
/*  388 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  389 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  390 */             String[] s = JRMCoreH.dat19[pl].split(";");
/*  391 */             JRMCoreH.TlMd = Byte.parseByte(s[0]);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*  397 */       if (dataID == 20) {
/*  398 */         String[] s = JRMCoreH.dat20[0].split(";");
/*  399 */         JRMCoreH.GTrnngCB = Integer.parseInt(s[0]);
/*  400 */         if (s.length > 1) JRMCoreH.PlyrSettings = s[1]; 
/*  401 */         JRMCoreH.GravZone = Float.parseFloat(s[2]);
/*  402 */         JRMCoreH.WeightOn = Float.parseFloat(s[3]);
/*  403 */         if (s.length > 7)
/*  404 */           JRMCoreH.s4ft = Integer.parseInt(s[7]); 
/*  405 */         if (s.length > 8)
/*  406 */           JRMCoreH.pnp = Integer.parseInt(s[8]); 
/*  407 */         if (s.length > 9)
/*  408 */           JRMCoreH.ko = Integer.parseInt(s[9]); 
/*  409 */         JRMCoreH.kob = (JRMCoreH.ko > 0);
/*  410 */         JRMCoreH.pnh = (JRMCoreH.pnp > 0);
/*      */       } 
/*  412 */       if (dataID == 21)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  420 */         JRMCoreH.MSDV = JRMCoreH.dat21[0];
/*      */       }
/*  422 */       if (dataID == 22)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  437 */         JRMCoreH.MSD = JRMCoreH.dat22[0];
/*      */       }
/*  439 */       if (dataID == 23) {
/*  440 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/*  441 */           if (JRMCoreH.plyrs[pl].equals(JRMCoreClient.mc.field_71439_g.func_70005_c_())) {
/*  442 */             String s = JRMCoreH.dat23[pl];
/*  443 */             JRMCoreH.GID = Integer.parseInt(s);
/*      */             break;
/*      */           } 
/*      */         } 
/*  447 */         int[] j = new int[JRMCoreH.dat23.length];
/*  448 */         for (int i = 0; i < JRMCoreH.dat23.length; i++) {
/*  449 */           j[i] = Integer.parseInt(JRMCoreH.dat23[i]);
/*      */         }
/*  451 */         JRMCoreH.GIDs = j;
/*  452 */         JRMCoreH.GMN = 0;
/*  453 */         if (JRMCoreH.GID > 0) {
/*  454 */           for (int k = 0; k < JRMCoreH.plyrs.length; k++) {
/*  455 */             if (JRMCoreH.GIDs[k] == JRMCoreH.GID) {
/*  456 */               JRMCoreH.GMN++;
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*  461 */       if (dataID == 24) {
/*  462 */         String[] s = JRMCoreH.dat24[0].split(";");
/*  463 */         JRMCoreH.GLID = s[0];
/*  464 */         JRMCoreH.GIDi = s[1];
/*      */       } 
/*  466 */       if (dataID == 25) {
/*  467 */         String s = JRMCoreH.dat25[0];
/*  468 */         JRMCoreH.GIDi = s;
/*      */       } 
/*      */ 
/*      */       
/*  472 */       if (JRMCoreH.JFC()) {
/*  473 */         if (dataID == 26) {
/*  474 */           String[] j = new String[JRMCoreH.dat26.length];
/*  475 */           for (int i = 0; i < JRMCoreH.dat26.length; i++) {
/*  476 */             j[i] = JRMCoreH.dat26[i];
/*      */           }
/*  478 */           FamilyCH.famNams = j;
/*      */         } 
/*  480 */         if (dataID == 27) {
/*  481 */           String s = JRMCoreH.dat27[0];
/*  482 */           s = s.replaceAll("\\+", ":");
/*  483 */           String[] s1 = { s };
/*  484 */           String[] s2 = s.contains(";") ? s.split(";") : s1;
/*  485 */           FamilyCH.famMem = s2;
/*      */         } 
/*      */         
/*  488 */         if (dataID == 28) {
/*  489 */           String s = JRMCoreH.dat28[0];
/*  490 */           String[] s2 = s.contains(";") ? s.toString().split(";") : null;
/*  491 */           if (s2 != null) {
/*  492 */             String[] s3 = (s2[0].length() < 2) ? null : s2[0].split(",");
/*  493 */             FamilyCH.FamP = (s3 != null) ? s3[1] : "";
/*  494 */             FamilyCH.FamID = (s2[0].length() < 2) ? 0 : 1;
/*  495 */             FamilyCH.prop = (s2.length >= 2) ? s2[1] : "";
/*  496 */             FamilyCH.adop = (s2.length >= 3) ? s2[2] : "";
/*      */           } 
/*      */         } 
/*  499 */         if (dataID == 29) {
/*  500 */           String s = JRMCoreH.dat29[0];
/*  501 */           JRMCoreH.proc = s;
/*      */         } 
/*  503 */         if (dataID == 30) {
/*  504 */           String[] k = new String[JRMCoreH.dat30.length];
/*  505 */           for (int i = 0; i < JRMCoreH.dat30.length; i++) {
/*  506 */             k[i] = JRMCoreH.dat30[i];
/*      */           }
/*  508 */           JRMCoreH.preg = k;
/*      */         } 
/*      */       } 
/*      */       
/*  512 */       if (dataID == 31 && JRMCoreConfig.JRMCABonusOn)
/*      */       {
/*  514 */         JRMCoreH.bonusAttributes = d;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleData2(String c, String d, EntityPlayer p) {
/*  525 */     String[] r = c.split(";");
/*  526 */     ArrayList<String> a = Lists.newArrayList();
/*  527 */     for (int i = 0; i < r.length; i++) {
/*  528 */       a.add(r[i]);
/*      */     }
/*  530 */     JRMCoreM.missionsC.put(r[0], (JRMCoreMsn)(new Gson()).fromJson(d, JRMCoreM.JSN_TYPE_MSN));
/*  531 */     JRMCoreM.missionsCD.put(r[0], a);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleTri(ByteBuf buffer) {
/*  539 */     boolean dPnlty = false;
/*  540 */     int maxTrnExp = 0;
/*  541 */     boolean plntVegeta = false;
/*  542 */     boolean flyAnyLvl = false;
/*      */     
/*  544 */     boolean expGriOff = false;
/*  545 */     boolean DeathSystemOff = false;
/*  546 */     boolean DBSpawnEnabled = false;
/*  547 */     String DBSpawnTime = "";
/*  548 */     boolean SagaSystemOn = false;
/*  549 */     boolean SagaSysSpawnPods = false;
/*  550 */     boolean NPCSpawnCheck = false;
/*  551 */     boolean BuildingSpawnCheck = false;
/*  552 */     int buildingSpawnAreaSize = 0;
/*  553 */     int pgut = 0;
/*  554 */     int pt = 0;
/*  555 */     int SklMedCat = 0;
/*  556 */     float SklMedRate = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  572 */     int senzuCool = 0;
/*  573 */     float Reinc = 0.0F;
/*  574 */     boolean GodForm = false;
/*  575 */     boolean FreeRev = false;
/*  576 */     int TechExpNeed = 0;
/*  577 */     int TechCostMod = 0;
/*      */ 
/*      */     
/*  580 */     String ncCSklsLvlO = "";
/*  581 */     String ncSklsLvlO = "";
/*  582 */     String TransGtsDmgO = "";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  617 */     boolean TPGainOn = true;
/*  618 */     float TPlimitIncreasesWithPlayerLevel = 0.5F;
/*  619 */     float TPMultiplier = 0.01F;
/*  620 */     int TPDailyLimit = 100;
/*  621 */     float ComboTimer = 3.0F;
/*  622 */     boolean ConstantClickOn = true;
/*  623 */     int RandomMovementSpeed = 1;
/*      */ 
/*      */     
/*  626 */     boolean TPGainOn2 = true;
/*  627 */     float TPlimitIncreasesWithPlayerLevel2 = 0.5F;
/*  628 */     float TPMultiplier2 = 0.01F;
/*  629 */     int TPDailyLimit2 = 100;
/*  630 */     int StartLife = 40;
/*      */     
/*  632 */     float[] KeySpawnSpeed = new float[4];
/*  633 */     float[] KeySpeed = new float[4];
/*  634 */     int[] KeyLifeTaken = new int[4];
/*  635 */     int count = 0;
/*  636 */     int[][] KeyTypeIDs = new int[4][];
/*      */ 
/*      */     
/*  639 */     int StatPasDef = 20;
/*  640 */     int mjn = 10;
/*  641 */     int lgnd = 10;
/*  642 */     String lgndb = "";
/*      */     
/*  644 */     double atcm = 1.6D;
/*  645 */     int AttributeUpgradeCost_StartMinus = 140;
/*  646 */     int AttributeUpgradeCost_Min = 16;
/*  647 */     float[] AttributeUpgradeCost_AttributeMulti = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  653 */     String s1 = "";
/*  654 */     String s2 = "";
/*  655 */     String s3 = "";
/*      */     
/*  657 */     boolean dat5711 = false;
/*      */ 
/*      */     
/*  660 */     String mods = ByteBufUtils.readUTF8String(buffer);
/*  661 */     HashMap<String, Boolean> dataH = new HashMap<String, Boolean>();
/*  662 */     JRMCoreH.modsC = (HashMap<String, Boolean>)(new Gson()).fromJson(mods, dataH.getClass());
/*  663 */     JRMCoreComTickH.tna3fu = buffer.readBoolean();
/*      */ 
/*      */     
/*  666 */     if (JRMCoreH.DBC()) {
/*      */ 
/*      */       
/*  669 */       maxTrnExp = buffer.readInt();
/*  670 */       plntVegeta = buffer.readBoolean();
/*  671 */       flyAnyLvl = buffer.readBoolean();
/*      */ 
/*      */       
/*  674 */       DeathSystemOff = buffer.readBoolean();
/*  675 */       DBSpawnEnabled = buffer.readBoolean();
/*  676 */       DBSpawnTime = ByteBufUtils.readUTF8String(buffer);
/*  677 */       SagaSystemOn = buffer.readBoolean();
/*  678 */       SagaSysSpawnPods = buffer.readBoolean();
/*  679 */       senzuCool = buffer.readInt();
/*  680 */       Reinc = buffer.readFloat();
/*  681 */       GodForm = buffer.readBoolean();
/*  682 */       FreeRev = buffer.readBoolean();
/*  683 */       TechExpNeed = buffer.readInt();
/*  684 */       TechCostMod = buffer.readInt();
/*      */     } 
/*  686 */     if (JRMCoreH.JYC())
/*      */     {
/*  688 */       pgut = buffer.readInt();
/*      */     }
/*  690 */     if (JRMCoreH.JFC())
/*      */     {
/*  692 */       pt = buffer.readInt();
/*      */     }
/*      */     
/*  695 */     if (JRMCoreH.NC()) {
/*      */       
/*  697 */       ncCSklsLvlO = ByteBufUtils.readUTF8String(buffer);
/*  698 */       ncSklsLvlO = ByteBufUtils.readUTF8String(buffer);
/*  699 */       TransGtsDmgO = ByteBufUtils.readUTF8String(buffer);
/*      */     } 
/*      */     
/*  702 */     String vlblRSklsLvlO = ByteBufUtils.readUTF8String(buffer);
/*  703 */     String vlblSklsLvlO = ByteBufUtils.readUTF8String(buffer);
/*  704 */     String TransKaiDmgO = ByteBufUtils.readUTF8String(buffer);
/*  705 */     String TransKaiDrainOLevel = ByteBufUtils.readUTF8String(buffer);
/*  706 */     String TransKaiDrainORace = ByteBufUtils.readUTF8String(buffer);
/*  707 */     String TransMngDmgO = ByteBufUtils.readUTF8String(buffer);
/*  708 */     String TransKaiNmsO = ByteBufUtils.readUTF8String(buffer);
/*  709 */     String TransSaiStBnPO = ByteBufUtils.readUTF8String(buffer);
/*  710 */     String TransHalfSaiStBnPO = ByteBufUtils.readUTF8String(buffer);
/*  711 */     String TransFrStBnPO = ByteBufUtils.readUTF8String(buffer);
/*  712 */     String TransHmStBnPO = ByteBufUtils.readUTF8String(buffer);
/*  713 */     String TransNaStBnPO = ByteBufUtils.readUTF8String(buffer);
/*  714 */     String TransMaStBnPO = ByteBufUtils.readUTF8String(buffer);
/*  715 */     String vlblRSklsMRO = ByteBufUtils.readUTF8String(buffer);
/*  716 */     String vlblSklsMRO = ByteBufUtils.readUTF8String(buffer);
/*  717 */     String ncCSklsMRO = ByteBufUtils.readUTF8String(buffer);
/*  718 */     String ncSklsMRO = ByteBufUtils.readUTF8String(buffer);
/*  719 */     boolean OverAtrLimitO = buffer.readBoolean();
/*  720 */     String MysticDamMulti = ByteBufUtils.readUTF8String(buffer);
/*  721 */     String ArcoPP = ByteBufUtils.readUTF8String(buffer);
/*  722 */     String ArcoPP2 = ByteBufUtils.readUTF8String(buffer);
/*  723 */     String ArcoPP3 = ByteBufUtils.readUTF8String(buffer);
/*  724 */     String ArcoPP4 = ByteBufUtils.readUTF8String(buffer);
/*  725 */     String ArcoPP5 = ByteBufUtils.readUTF8String(buffer);
/*  726 */     String AttrBonusPerRacialSkill = ByteBufUtils.readUTF8String(buffer);
/*  727 */     int ArcoPP6 = buffer.readInt();
/*      */     
/*  729 */     String tpGainRate = ByteBufUtils.readUTF8String(buffer);
/*  730 */     String tpGain = ByteBufUtils.readUTF8String(buffer);
/*      */ 
/*      */     
/*  733 */     expGriOff = buffer.readBoolean();
/*  734 */     SklMedCat = buffer.readInt();
/*  735 */     SklMedRate = buffer.readFloat();
/*  736 */     boolean SklMedStop = buffer.readBoolean();
/*  737 */     boolean regen = buffer.readBoolean();
/*  738 */     boolean release = buffer.readBoolean();
/*      */     
/*  740 */     int tpgn = buffer.readInt();
/*      */ 
/*      */ 
/*      */     
/*  744 */     int attrMx = buffer.readInt();
/*  745 */     String regenRate = ByteBufUtils.readUTF8String(buffer);
/*  746 */     String hRegenRate = ByteBufUtils.readUTF8String(buffer);
/*  747 */     boolean sizes = buffer.readBoolean();
/*  748 */     String ssurl = ByteBufUtils.readUTF8String(buffer);
/*  749 */     String ssurl2 = ByteBufUtils.readUTF8String(buffer);
/*  750 */     String ssc = ByteBufUtils.readUTF8String(buffer);
/*  751 */     boolean sfzns = buffer.readBoolean();
/*  752 */     NPCSpawnCheck = buffer.readBoolean();
/*  753 */     BuildingSpawnCheck = buffer.readBoolean();
/*  754 */     buildingSpawnAreaSize = buffer.readInt();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  760 */     TPGainOn = buffer.readBoolean();
/*  761 */     TPlimitIncreasesWithPlayerLevel = buffer.readFloat();
/*  762 */     TPMultiplier = buffer.readFloat();
/*  763 */     TPDailyLimit = buffer.readInt();
/*  764 */     ComboTimer = buffer.readFloat();
/*  765 */     ConstantClickOn = buffer.readBoolean();
/*  766 */     RandomMovementSpeed = buffer.readInt();
/*      */     
/*  768 */     TPGainOn2 = buffer.readBoolean();
/*  769 */     TPlimitIncreasesWithPlayerLevel2 = buffer.readFloat();
/*  770 */     TPMultiplier2 = buffer.readFloat();
/*  771 */     TPDailyLimit2 = buffer.readInt();
/*  772 */     StartLife = buffer.readInt(); int i;
/*  773 */     for (i = 0; i < 4; i++) {
/*  774 */       KeySpawnSpeed[i] = buffer.readFloat();
/*  775 */       KeySpeed[i] = buffer.readFloat();
/*  776 */       KeyLifeTaken[i] = buffer.readInt();
/*  777 */       count = buffer.readInt();
/*  778 */       KeyTypeIDs[i] = new int[count];
/*  779 */       for (int j = 0; j < count; j++) {
/*  780 */         KeyTypeIDs[i][j] = buffer.readInt();
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
/*  792 */     StatPasDef = buffer.readInt();
/*  793 */     mjn = buffer.readInt();
/*      */     
/*  795 */     atcm = buffer.readDouble();
/*  796 */     AttributeUpgradeCost_StartMinus = buffer.readInt();
/*  797 */     AttributeUpgradeCost_Min = buffer.readInt();
/*  798 */     for (i = 0; i < JRMCoreConfig.AttributeUpgradeCost_AttributeMulti.length; ) { AttributeUpgradeCost_AttributeMulti[i] = (float)buffer.readDouble(); i++; }
/*  799 */      lgnd = buffer.readInt();
/*  800 */     lgndb = ByteBufUtils.readUTF8String(buffer);
/*  801 */     boolean lockon = buffer.readBoolean();
/*      */     
/*  803 */     double Flngspd = buffer.readDouble();
/*      */     
/*  805 */     if (JRMCoreH.DBC()) {
/*      */       
/*  807 */       s1 = ByteBufUtils.readUTF8String(buffer);
/*  808 */       s2 = ByteBufUtils.readUTF8String(buffer);
/*  809 */       s3 = ByteBufUtils.readUTF8String(buffer);
/*      */     } 
/*      */     
/*  812 */     if (JRMCoreH.DBC() || JRMCoreH.NC())
/*      */     {
/*  814 */       dat5711 = buffer.readBoolean();
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
/*  827 */     if (JRMCoreH.DBC()) {
/*      */ 
/*      */       
/*  830 */       JRMCoreHDBC.DBCsetConfigmaxTrnExp(maxTrnExp);
/*  831 */       JRMCoreHDBC.DBCsetConfigplntVegeta(plntVegeta);
/*  832 */       JRMCoreHDBC.DBCsetConfigflyAnyLvl(flyAnyLvl);
/*      */ 
/*      */       
/*  835 */       JRMCoreHDBC.DBCsetConfigDeathSystemOff(DeathSystemOff);
/*  836 */       JRMCoreHDBC.DBCsetConfigDBSpawnEnabled(DBSpawnEnabled);
/*  837 */       JRMCoreHDBC.DBCsetConfigDBSpawnTime(DBSpawnTime);
/*  838 */       JRMCoreHDBC.DBCsetConfigDBSagaSystemOn(SagaSystemOn);
/*  839 */       JRMCoreHDBC.DBCsetConfigDBSagaSysSpawnPods(SagaSysSpawnPods);
/*  840 */       JRMCoreHDBC.DBCsetConfigsenzuCool(senzuCool);
/*  841 */       JRMCoreHDBC.DBCsetConfigReinc(Reinc);
/*  842 */       JRMCoreHDBC.DBCsetConfigGodform(GodForm);
/*  843 */       JRMCoreHDBC.FreeRevSet(FreeRev);
/*  844 */       JRMCoreHDBC.DBCsetConfigTechExpNeed(TechExpNeed);
/*  845 */       JRMCoreHDBC.DBCsetConfigTechCostMod(TechCostMod);
/*      */     } 
/*      */     
/*  848 */     if (JRMCoreH.JYC())
/*      */     {
/*  850 */       JRMCoreHJYC.JYCsetConfigpgut(pgut);
/*      */     }
/*  852 */     if (JRMCoreH.JFC())
/*      */     {
/*  854 */       JRMCoreHJFC.setConfigpt(pt);
/*      */     }
/*      */     
/*  857 */     int[][] data = new int[20][];
/*  858 */     float[] dataF = new float[80];
/*  859 */     float[][] dataFMatrix = new float[6][17];
/*  860 */     int[] dataI = new int[40];
/*  861 */     String[] dataS = new String[20];
/*  862 */     float[][] dataFF = new float[20][];
/*  863 */     double[][] dataDD = new double[20][];
/*      */     
/*  865 */     if (JRMCoreH.NC()) {
/*      */       
/*  867 */       JRMCoreH.NCRacialSkillTPCost = (int[][])(new Gson()).fromJson(ncCSklsLvlO, data.getClass());
/*  868 */       JRMCoreH.NCSkillTPCost = (int[][])(new Gson()).fromJson(ncSklsLvlO, data.getClass());
/*  869 */       JRMCoreH.TransGtsDmg = (float[])(new Gson()).fromJson(TransGtsDmgO, dataF.getClass());
/*      */     } 
/*      */     
/*  872 */     JRMCoreH.DBCRacialSkillTPCost = (int[][])(new Gson()).fromJson(vlblRSklsLvlO, data.getClass());
/*  873 */     JRMCoreH.DBCSkillTPCost = (int[][])(new Gson()).fromJson(vlblSklsLvlO, data.getClass());
/*  874 */     JRMCoreH.TransMngDmg = (float[])(new Gson()).fromJson(TransMngDmgO, dataF.getClass());
/*  875 */     JRMCoreH.TransKaiDmg = (float[])(new Gson()).fromJson(TransKaiDmgO, dataF.getClass());
/*  876 */     JRMCoreH.TransKaiDrainLevel = (float[])(new Gson()).fromJson(TransKaiDrainOLevel, dataF.getClass());
/*  877 */     JRMCoreH.TransKaiDrainRace = (float[])(new Gson()).fromJson(TransKaiDrainORace, dataF.getClass());
/*  878 */     JRMCoreH.TransKaiNms = (String[])(new Gson()).fromJson(TransKaiNmsO, dataS.getClass());
/*  879 */     JRMCoreH.TransSaiStBnP = (float[][])(new Gson()).fromJson(TransSaiStBnPO, dataFF.getClass());
/*  880 */     JRMCoreH.TransHalfSaiStBnP = (float[][])(new Gson()).fromJson(TransHalfSaiStBnPO, dataFF.getClass());
/*  881 */     JRMCoreH.TransFrStBnP = (float[][])(new Gson()).fromJson(TransFrStBnPO, dataFF.getClass());
/*  882 */     JRMCoreH.TransHmStBnP = (float[][])(new Gson()).fromJson(TransHmStBnPO, dataFF.getClass());
/*  883 */     JRMCoreH.TransNaStBnP = (float[][])(new Gson()).fromJson(TransNaStBnPO, dataFF.getClass());
/*  884 */     JRMCoreH.TransMaStBnP = (float[][])(new Gson()).fromJson(TransMaStBnPO, dataFF.getClass());
/*  885 */     JRMCoreH.DBCRacialSkillMindCost = (int[][])(new Gson()).fromJson(vlblRSklsMRO, data.getClass());
/*  886 */     JRMCoreH.DBCSkillMindCost = (int[][])(new Gson()).fromJson(vlblSklsMRO, data.getClass());
/*  887 */     JRMCoreH.NCRacialSkillMindCost = (int[][])(new Gson()).fromJson(ncCSklsMRO, data.getClass());
/*  888 */     JRMCoreH.NCSkillMindCost = (int[][])(new Gson()).fromJson(ncSklsMRO, data.getClass());
/*  889 */     JRMCoreConfig.OverAtrLimit = OverAtrLimitO;
/*  890 */     JRMCoreConfig.MysticDamMulti = (float[])(new Gson()).fromJson(MysticDamMulti, dataF.getClass());
/*      */     
/*  892 */     JRMCoreConfig.ArcosianPPMax = (int[])(new Gson()).fromJson(ArcoPP, dataI.getClass());
/*  893 */     JRMCoreConfig.ArcosianPPGrowth = (int[])(new Gson()).fromJson(ArcoPP2, dataI.getClass());
/*  894 */     JRMCoreConfig.ArcosianPPCost = (int[])(new Gson()).fromJson(ArcoPP3, dataI.getClass());
/*  895 */     JRMCoreConfig.ArcosianPPDamMulti = (float[])(new Gson()).fromJson(ArcoPP4, dataF.getClass());
/*  896 */     JRMCoreConfig.ArcosianPPDamMultiPoint = (float[])(new Gson()).fromJson(ArcoPP5, dataF.getClass());
/*  897 */     JRMCoreConfig.AttibuteBonusPerRacialSkill = (float[][])(new Gson()).fromJson(AttrBonusPerRacialSkill, dataFMatrix.getClass());
/*  898 */     JRMCoreConfig.ArcosianPPDamMultiHighest = ArcoPP6;
/*      */     
/*  900 */     JRMCoreConfig.TPGainRateRace = (float[])(new Gson()).fromJson(tpGainRate, dataF.getClass());
/*  901 */     JRMCoreConfig.TPGainRace = (float[])(new Gson()).fromJson(tpGain, dataF.getClass());
/*      */ 
/*      */     
/*  904 */     JRMCoreConfig.expGriOff = expGriOff;
/*  905 */     JRMCoreConfig.SklMedCat = SklMedCat;
/*  906 */     JRMCoreConfig.SklMedRate = SklMedRate;
/*  907 */     JRMCoreConfig.releaseStop = SklMedStop;
/*  908 */     JRMCoreConfig.regen = regen;
/*  909 */     JRMCoreConfig.release = release;
/*      */     
/*  911 */     JRMCoreConfig.tpgn = tpgn;
/*      */ 
/*      */     
/*  914 */     JRMCoreConfig.tmx = nQp65G(attrMx);
/*  915 */     JRMCoreConfig.regenRate = regenRate;
/*  916 */     JRMCoreConfig.hRegenRate = hRegenRate;
/*  917 */     JRMCoreConfig.sizes = sizes;
/*  918 */     JRMCoreConfig.ssurl = ssurl;
/*  919 */     JRMCoreConfig.ssurl2 = ssurl2;
/*  920 */     JRMCoreConfig.ssc = ssc;
/*  921 */     JRMCoreConfig.sfzns = sfzns;
/*  922 */     JRMCoreConfig.NPCSpawnCheck = NPCSpawnCheck;
/*  923 */     JRMCoreConfig.BuildingSpawnCheck = BuildingSpawnCheck;
/*  924 */     JRMCoreConfig.buildingSpawnAreaSize = buildingSpawnAreaSize;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  929 */     JGConfigMiniGameConcentration.TPGainOn = TPGainOn;
/*  930 */     JGConfigMiniGameConcentration.TPlimitIncreasesWithPlayerLevel = TPlimitIncreasesWithPlayerLevel;
/*  931 */     JGConfigMiniGameConcentration.TPMultiplier = TPMultiplier;
/*  932 */     JGConfigMiniGameConcentration.TPDailyLimit = TPDailyLimit;
/*  933 */     JGConfigMiniGameConcentration.ComboTimer = ComboTimer;
/*  934 */     JGConfigMiniGameConcentration.ConstantClickOn = ConstantClickOn;
/*  935 */     JGConfigMiniGameConcentration.RandomMovementSpeed = RandomMovementSpeed;
/*      */     
/*  937 */     JGConfigMiniGameAirBoxing.TPGainOn = TPGainOn2;
/*  938 */     JGConfigMiniGameAirBoxing.TPlimitIncreasesWithPlayerLevel = TPlimitIncreasesWithPlayerLevel2;
/*  939 */     JGConfigMiniGameAirBoxing.TPMultiplier = TPMultiplier2;
/*  940 */     JGConfigMiniGameAirBoxing.TPDailyLimit = TPDailyLimit2;
/*  941 */     JGConfigMiniGameAirBoxing.StartLife = StartLife;
/*  942 */     JGConfigMiniGameAirBoxing.KeySpawnSpeed = KeySpawnSpeed;
/*  943 */     JGConfigMiniGameAirBoxing.KeySpeed = KeySpeed;
/*  944 */     JGConfigMiniGameAirBoxing.KeyLifeTaken = KeyLifeTaken;
/*  945 */     JGConfigMiniGameAirBoxing.KeyTypeIDs = KeyTypeIDs;
/*      */ 
/*      */     
/*  948 */     JRMCoreConfig.StatPasDef = StatPasDef;
/*  949 */     JRMCoreConfig.mjn = mjn;
/*      */     
/*  951 */     JRMCoreConfig.atcm = atcm;
/*  952 */     JRMCoreConfig.AttributeUpgradeCost_StartMinus = AttributeUpgradeCost_StartMinus;
/*  953 */     JRMCoreConfig.AttributeUpgradeCost_Min = AttributeUpgradeCost_Min;
/*  954 */     JRMCoreConfig.AttributeUpgradeCost_AttributeMulti = AttributeUpgradeCost_AttributeMulti;
/*  955 */     JRMCoreConfig.lgnd = lgnd;
/*  956 */     JRMCoreConfig.lgndb = lgndb;
/*  957 */     JRMCoreConfig.lockon = lockon;
/*  958 */     JRMCoreConfig.Flngspd = Flngspd;
/*      */ 
/*      */     
/*  961 */     if (JRMCoreH.DBC()) {
/*      */ 
/*      */       
/*  964 */       String[] str = s1.split(" ");
/*  965 */       for (int j = 0; j < JRMCoreConfig.dat5695.length; j++) {
/*  966 */         JRMCoreConfig.dat5695[j] = Boolean.parseBoolean(str[j]);
/*      */       }
/*      */ 
/*      */       
/*  970 */       String[] str2 = s2.split(";"); int k;
/*  971 */       for (k = 0; k < JRMCoreConfig.dat5696.length; k++) {
/*  972 */         str = str2[k].split(" ");
/*  973 */         for (int m = 0; m < (JRMCoreConfig.dat5696[m]).length; m++) {
/*  974 */           JRMCoreConfig.dat5696[k][m] = Double.parseDouble(str[m]);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  979 */       str = s3.split(" ");
/*  980 */       for (k = 0; k < JRMCoreConfig.dat5709.length; k++) {
/*  981 */         JRMCoreConfig.dat5709[k] = Boolean.parseBoolean(str[k]);
/*      */       }
/*      */     } 
/*      */     
/*  985 */     if (JRMCoreH.DBC() || JRMCoreH.NC())
/*      */     {
/*  987 */       JRMCoreConfig.dat5711 = dat5711;
/*      */     }
/*      */ 
/*      */     
/*  991 */     if (JRMCoreH.DBC()) {
/*      */       
/*  993 */       byte levels = buffer.readByte();
/*  994 */       JGConfigUltraInstinct.CONFIG_UI_LEVELS = levels;
/*      */       
/*  996 */       JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION = new int[JGConfigUltraInstinct.CONFIG_UI_LEVELS];
/*  997 */       JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE = new boolean[JGConfigUltraInstinct.CONFIG_UI_LEVELS];
/*  998 */       JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI = new int[JGConfigUltraInstinct.CONFIG_UI_LEVELS];
/*  999 */       JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI_RACE = new float[JGConfigUltraInstinct.CONFIG_UI_LEVELS][JRMCoreH.Races.length];
/* 1000 */       JGConfigUltraInstinct.CONFIG_UI_DODGE_RATE = new byte[JGConfigUltraInstinct.CONFIG_UI_LEVELS][2];
/* 1001 */       JGConfigUltraInstinct.CONFIG_UI_ATTACK_RATE = new byte[JGConfigUltraInstinct.CONFIG_UI_LEVELS][2];
/*      */       
/* 1003 */       for (int j = 0; j < JGConfigUltraInstinct.CONFIG_UI_LEVELS; j++) {
/*      */         
/* 1005 */         int heat = buffer.readInt();
/* 1006 */         JGConfigUltraInstinct.CONFIG_UI_HEAT_DURATION[j] = heat;
/*      */         
/* 1008 */         boolean hair_white = buffer.readBoolean();
/* 1009 */         JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[j] = hair_white;
/*      */         
/* 1011 */         int attribute_multi = buffer.readInt();
/* 1012 */         JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI[j] = attribute_multi; int k;
/* 1013 */         for (k = 0; k < JRMCoreH.Races.length; k++) {
/* 1014 */           float attribute_multi2 = buffer.readFloat();
/* 1015 */           JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI_RACE[j][k] = attribute_multi2;
/*      */         } 
/*      */         
/* 1018 */         for (k = 0; k < 2; k++) {
/*      */           
/* 1020 */           byte dodge_rate = buffer.readByte();
/* 1021 */           JGConfigUltraInstinct.CONFIG_UI_DODGE_RATE[j][k] = dodge_rate;
/* 1022 */           byte attack_rate = buffer.readByte();
/* 1023 */           JGConfigUltraInstinct.CONFIG_UI_ATTACK_RATE[j][k] = attack_rate;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1030 */     byte extendedPlayerBlock = buffer.readByte();
/* 1031 */     byte extendedPlayerOther = buffer.readByte();
/* 1032 */     byte extendedPlayerHair = buffer.readByte();
/* 1033 */     JRMCoreConfig.ExtendedPlayerBlockID = extendedPlayerBlock;
/* 1034 */     JRMCoreConfig.ExtendedPlayerOtherID = extendedPlayerOther;
/* 1035 */     JRMCoreConfig.ExtendedPlayerHairID = extendedPlayerHair;
/*      */     
/* 1037 */     if (JRMCoreH.DBC()) {
/*      */ 
/*      */       
/* 1040 */       boolean canWhisTP = buffer.readBoolean();
/* 1041 */       DBCConfig.CanWhisTeleport = canWhisTP;
/*      */ 
/*      */       
/* 1044 */       float EnmaScale = buffer.readFloat();
/* 1045 */       DBCConfig.EnmaScale = EnmaScale;
/*      */       
/* 1047 */       float GuruScale = buffer.readFloat();
/* 1048 */       DBCConfig.GuruScale = GuruScale;
/*      */       
/* 1050 */       for (int j = 0; j < JRMCoreConfig.ContinuesKiAttacks.length; j++) {
/*      */ 
/*      */         
/* 1053 */         boolean continues = buffer.readBoolean();
/* 1054 */         JRMCoreConfig.ContinuesKiAttacks[j] = continues;
/*      */       } 
/*      */ 
/*      */       
/* 1058 */       boolean scaleW = buffer.readBoolean();
/* 1059 */       JRMCoreConfig.KiAttackScalesWithUser = scaleW;
/*      */     } 
/*      */     
/* 1062 */     if (JRMCoreH.NC()) {
/*      */       
/* 1064 */       for (int j = 0; j < JRMCoreConfig.ContinuesJutsuAttacks.length; j++) {
/*      */ 
/*      */         
/* 1067 */         boolean continues = buffer.readBoolean();
/* 1068 */         JRMCoreConfig.ContinuesJutsuAttacks[j] = continues;
/*      */       } 
/*      */       
/* 1071 */       boolean scaleW = buffer.readBoolean();
/* 1072 */       JRMCoreConfig.JutsuScalesWithUser = scaleW;
/*      */     } 
/*      */     
/* 1075 */     if (JRMCoreH.DBC() || JRMCoreH.NC()) {
/*      */ 
/*      */       
/* 1078 */       boolean letgo = buffer.readBoolean();
/* 1079 */       JRMCoreConfig.WavesShrinkOnceLetGo = letgo;
/*      */ 
/*      */       
/* 1082 */       boolean targetSlow = buffer.readBoolean();
/* 1083 */       JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown = targetSlow;
/*      */ 
/*      */       
/* 1086 */       int energyTimer = buffer.readInt();
/* 1087 */       JRMCoreConfig.ContinuesEnergyAttackTimer = energyTimer;
/*      */     } 
/*      */     
/* 1090 */     int ceaesl = buffer.readInt();
/* 1091 */     float cealbm = buffer.readFloat();
/* 1092 */     JRMCoreConfig.eaesl = ceaesl;
/* 1093 */     JRMCoreConfig.ealbm = cealbm;
/*      */     
/* 1095 */     if (JRMCoreH.DBC()) {
/*      */       
/* 1097 */       int nullRealmMin = buffer.readInt();
/* 1098 */       DBCConfig.NullRealmMinimumHeight = nullRealmMin;
/*      */       
/* 1100 */       for (int j = 0; j < 9; j++) {
/*      */         
/* 1102 */         double ContinuesCost = buffer.readDouble();
/* 1103 */         JRMCoreConfig.dat5696[j][2] = ContinuesCost;
/*      */       } 
/*      */ 
/*      */       
/* 1107 */       boolean NullRealmBGColorNodeGreen = buffer.readBoolean();
/* 1108 */       DBCConfig.NullRealmBGColorNodeGreen = NullRealmBGColorNodeGreen;
/*      */ 
/*      */       
/* 1111 */       boolean PlayerFlyingDragDownOn = buffer.readBoolean();
/* 1112 */       JRMCoreConfig.PlayerFlyingDragDownOn = PlayerFlyingDragDownOn;
/*      */     } 
/*      */     
/* 1115 */     if (JRMCoreH.DBC()) {
/*      */       
/* 1117 */       for (int k = 0; k < JRMCoreH.Races.length; k++) {
/*      */         
/* 1119 */         for (int m = 0; m < JRMCoreH.ClassesDBC.length; m++) {
/*      */           int n;
/* 1121 */           for (n = 0; n < (JRMCoreH.attrInit[1]).length; n++) {
/*      */ 
/*      */             
/* 1124 */             double d = buffer.readDouble();
/* 1125 */             JGConfigRaces.CONFIG_RACES_ATTRIBUTE_MULTI[k][m][n] = d;
/*      */             
/* 1127 */             int i1 = buffer.readInt();
/* 1128 */             JGConfigRaces.CONFIG_RACES_ATTRIBUTE_START[k][m][n] = i1;
/*      */           } 
/* 1130 */           for (n = 0; n < (JRMCoreH.statNames[1]).length; n++) {
/*      */ 
/*      */             
/* 1133 */             float f = buffer.readFloat();
/* 1134 */             JGConfigRaces.CONFIG_RACES_STATS_MULTI[k][m][n] = f;
/*      */             
/* 1136 */             int i1 = buffer.readInt();
/* 1137 */             JGConfigRaces.CONFIG_RACES_STAT_BONUS[k][m][n] = i1;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1142 */       boolean configValue = buffer.readBoolean();
/* 1143 */       JGConfigRaces.CONFIG_MAJIN_ENABLED = configValue;
/*      */ 
/*      */       
/* 1146 */       boolean configValue2 = buffer.readBoolean();
/* 1147 */       JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED = configValue2;
/* 1148 */       boolean configValue5 = buffer.readBoolean();
/* 1149 */       JGConfigRaces.CONFIG_MAJIN_PURE_PINK_SKIN = configValue5;
/* 1150 */       boolean configValue6 = buffer.readBoolean();
/* 1151 */       JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS = configValue6;
/* 1152 */       for (int j = 0; j < (JRMCoreH.TransNms[5]).length + 3; j++) {
/*      */         
/* 1154 */         float configValue3 = buffer.readFloat();
/* 1155 */         JGConfigRaces.CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[j] = configValue3;
/* 1156 */         float configValue4 = buffer.readFloat();
/* 1157 */         JGConfigRaces.CONFIG_MAJIN_ABSORPTON_SPEED_MULTI[j] = configValue4;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1201 */     boolean JRMCABonusOn = buffer.readBoolean();
/* 1202 */     JRMCoreConfig.JRMCABonusOn = JRMCABonusOn;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1207 */     boolean ShadowDummyScaleToTarget = buffer.readBoolean();
/* 1208 */     JRMCoreConfig.ShadowDummyScaleToTarget = ShadowDummyScaleToTarget;
/*      */ 
/*      */     
/* 1211 */     if (JRMCoreH.DBC()) {
/*      */ 
/*      */       
/* 1214 */       boolean CONFIG_UI_IGNORE_BASE_CONFIG = buffer.readBoolean();
/* 1215 */       JGConfigUltraInstinct.CONFIG_UI_IGNORE_BASE_CONFIG = CONFIG_UI_IGNORE_BASE_CONFIG;
/*      */ 
/*      */       
/* 1218 */       boolean CONFIG_GOD_IGNORE_BASE_CONFIG = buffer.readBoolean();
/* 1219 */       JGConfigDBCGoD.CONFIG_GOD_IGNORE_BASE_CONFIG = CONFIG_GOD_IGNORE_BASE_CONFIG;
/*      */ 
/*      */       
/* 1222 */       int k = buffer.readInt();
/*      */       
/* 1224 */       JGConfigDBCGoD.CONFIG_GOD_IGNORED_DAMAGE_SOURCES = new String[k]; int j;
/* 1225 */       for (j = 0; j < k; j++) {
/* 1226 */         String s = ByteBufUtils.readUTF8String(buffer);
/* 1227 */         JGConfigDBCGoD.CONFIG_GOD_IGNORED_DAMAGE_SOURCES[j] = s;
/*      */       } 
/* 1229 */       k = buffer.readInt();
/* 1230 */       JGConfigDBCGoD.CONFIG_GOD_IGNORED_ENTITIES = new String[k];
/* 1231 */       for (j = 0; j < k; j++) {
/* 1232 */         String s = ByteBufUtils.readUTF8String(buffer);
/* 1233 */         JGConfigDBCGoD.CONFIG_GOD_IGNORED_ENTITIES[j] = s;
/*      */       } 
/*      */ 
/*      */       
/* 1237 */       float f = buffer.readFloat();
/*      */ 
/*      */       
/* 1240 */       boolean b = buffer.readBoolean();
/*      */       
/* 1242 */       JGConfigDBCGoD.CONFIG_GOD_ENABLED = b = buffer.readBoolean();
/*      */       
/* 1244 */       JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED = b = buffer.readBoolean();
/*      */       
/* 1246 */       JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA = b = buffer.readBoolean();
/*      */       
/* 1248 */       JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED = b = buffer.readBoolean();
/*      */       
/* 1250 */       JGConfigDBCGoD.CONFIG_GOD_ENERGY_DAMAGE_MULTI = f = buffer.readFloat();
/*      */       
/* 1252 */       JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI = f = buffer.readFloat();
/*      */       
/* 1254 */       for (int m = 0; m < JRMCoreH.Races.length; m++) {
/* 1255 */         f = buffer.readFloat(); JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI_RACE[m] = f;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1262 */     JRMCoreConfig.BuildingBlocksRenderAsNormalBlock = buffer.readBoolean();
/*      */ 
/*      */     
/* 1265 */     JGConfigSkills.GlobalSkillTPMultiplier = buffer.readFloat();
/* 1266 */     JGConfigSkills.GlobalSkillMindMultiplier = buffer.readFloat();
/* 1267 */     JGConfigSkills.GlobalSkillTPMultiplierFirst = buffer.readFloat();
/* 1268 */     JGConfigSkills.GlobalSkillMindMultiplierFirst = buffer.readFloat();
/* 1269 */     JGConfigSkills.GlobalSkillTPMultiplierWithLevel = buffer.readBoolean();
/* 1270 */     JGConfigSkills.GlobalSkillMindMultiplierWithLevel = buffer.readBoolean();
/*      */     
/* 1272 */     if (JRMCoreH.NC())
/*      */     {
/* 1274 */       JRMCoreConfig.NCExplosionTagTickTimer = buffer.readInt();
/*      */     }
/*      */ 
/*      */     
/* 1278 */     if (JRMCoreH.DBC()) {
/*      */       
/* 1280 */       int aai1 = buffer.readInt();
/* 1281 */       boolean aai2 = buffer.readBoolean();
/* 1282 */       int aai3 = buffer.readInt();
/* 1283 */       int aai4 = buffer.readInt();
/* 1284 */       double aai5 = buffer.readDouble();
/* 1285 */       boolean aai6 = buffer.readBoolean();
/*      */       
/* 1287 */       boolean aai7 = buffer.readBoolean();
/* 1288 */       boolean aai8 = buffer.readBoolean();
/* 1289 */       for (int j = 0; j < DBCConfig.IsInstantTransformEnabled.length; j++) {
/*      */         
/* 1291 */         boolean aai9 = buffer.readBoolean(); DBCConfig.IsInstantTransformEnabled[j] = aai9;
/*      */       } 
/* 1293 */       boolean aai10 = buffer.readBoolean();
/* 1294 */       boolean aai11 = buffer.readBoolean();
/* 1295 */       boolean aai12 = buffer.readBoolean();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1301 */       for (int k = 0; k < JGConfigDBCAAiDifficulty.DIFFICULTIES.length; k++) {
/*      */         
/* 1303 */         double aai13 = buffer.readDouble(); JGConfigDBCAAiDifficulty.GroundDashSpeedMulti[k] = aai13;
/* 1304 */         double aai14 = buffer.readDouble(); JGConfigDBCAAiDifficulty.GroundDashSpeedMulti2[k] = aai14;
/* 1305 */         double aai15 = buffer.readDouble(); JGConfigDBCAAiDifficulty.GroundDashLimit[k] = aai15;
/*      */         
/* 1307 */         double aai16 = buffer.readDouble(); JGConfigDBCAAiDifficulty.JumpMulti[k] = aai16;
/* 1308 */         double aai17 = buffer.readDouble(); JGConfigDBCAAiDifficulty.JumpMulti2[k] = aai17;
/* 1309 */         double aai18 = buffer.readDouble(); JGConfigDBCAAiDifficulty.JumpLimit[k] = aai18;
/* 1310 */         double aai19 = buffer.readDouble(); JGConfigDBCAAiDifficulty.JumpLimit2[k] = aai19;
/* 1311 */         double d1 = buffer.readDouble(); JGConfigDBCAAiDifficulty.JumpRate[k] = d1;
/*      */         
/* 1313 */         double aai20 = buffer.readDouble(); JGConfigDBCAAiDifficulty.FlyingDashMulti[k] = aai20;
/* 1314 */         double aai21 = buffer.readDouble(); JGConfigDBCAAiDifficulty.FlyingDashLimit[k] = aai21;
/*      */         
/* 1316 */         double aai22 = buffer.readDouble(); JGConfigDBCAAiDifficulty.KiAttackChargeMulti[k] = aai22;
/* 1317 */         double aai23 = buffer.readDouble(); JGConfigDBCAAiDifficulty.KiAttackChargeLimit[k] = aai23;
/*      */         
/* 1319 */         int aai24 = buffer.readInt(); JGConfigDBCAAiDifficulty.TeleportRateMin[k] = aai24;
/* 1320 */         int aai25 = buffer.readInt(); JGConfigDBCAAiDifficulty.TeleportRateMax[k] = aai25;
/*      */         
/* 1322 */         double aai26 = buffer.readDouble(); JGConfigDBCAAiDifficulty.SpeedMulti[k] = aai26;
/*      */       } 
/*      */ 
/*      */       
/* 1326 */       boolean aai27 = buffer.readBoolean();
/*      */       
/*      */       int m;
/* 1329 */       for (m = 0; m < JRMCoreH.Races.length; m++) {
/*      */         
/* 1331 */         for (int n = 0; n < (JRMCoreConfig.KaiokenFormHealthCost[m]).length; n++) {
/*      */           
/* 1333 */           float f = buffer.readFloat(); JRMCoreConfig.KaiokenFormHealthCost[m][n] = f;
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1338 */       for (m = 0; m < 2; m++) {
/* 1339 */         boolean bool = buffer.readBoolean(); JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[m] = bool;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1348 */     boolean aai29 = buffer.readBoolean();
/* 1349 */     for (int raceID = 0; raceID < JRMCoreH.Races.length; raceID++) {
/*      */       
/* 1351 */       int racials = (JRMCoreH.trans[raceID]).length;
/* 1352 */       for (int formID = 0; formID < (JGConfigDBCFormMastery.FormMasteries[raceID]).length; formID++) {
/*      */         
/* 1354 */         boolean racial = (formID < racials);
/* 1355 */         String form = racial ? JRMCoreH.trans[raceID][formID] : JRMCoreH.transNonRacial[formID - racials];
/* 1356 */         if (!racial || !JRMCoreH.isRaceSaiyan(raceID) || (!form.equals(JRMCoreH.trans[raceID][12]) && !form.equals(JRMCoreH.trans[raceID][13])))
/*      */         {
/*      */           
/* 1359 */           for (int j = 0; j < 3; j++) {
/*      */             
/* 1361 */             double aai30 = buffer.readDouble();
/* 1362 */             ((Object[])(JGConfigDBCFormMastery.FormMasteries[raceID][formID]).data.get(JGConfigDBCFormMastery.DATA_ID_DAMAGE_MULTI))[j] = aai30 + "";
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleFall(byte b, EntityPlayer p) {}
/*      */   
/*      */   public void handleRls(byte b, EntityPlayer p) {}
/*      */   
/*      */   public void handleTech(byte b, String s, EntityPlayer p) {
/* 1375 */     if (b >= 0 && b <= 3) {
/* 1376 */       String[] s2 = s.contains(";") ? s.toString().split(";") : null;
/* 1377 */       if (b == 0) JRMCoreH.tech1 = s2; 
/* 1378 */       if (b == 1) JRMCoreH.tech2 = s2; 
/* 1379 */       if (b == 2) JRMCoreH.tech3 = s2; 
/* 1380 */       if (b == 3) JRMCoreH.tech4 = s2; 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void handleAttck(byte b, EntityPlayer p) {}
/*      */   
/*      */   public void handleCost(short s, EntityPlayer p) {}
/*      */   
/*      */   public void handleStats2(int curTP, int curExp, byte align, int[] plyrAttrbts, EntityPlayer p) {
/* 1389 */     JRMCoreH.curTP = curTP;
/* 1390 */     JRMCoreH.curExp = curExp;
/* 1391 */     JRMCoreH.align = align;
/* 1392 */     JRMCoreH.PlyrAttrbts = plyrAttrbts;
/*      */     
/* 1394 */     byte pwr = JRMCoreH.Pwrtyp;
/* 1395 */     byte rce = JRMCoreH.Race;
/* 1396 */     byte cls = JRMCoreH.Class;
/* 1397 */     JRMCoreH.maxBody = JRMCoreH.stat((Entity)p, 2, pwr, 2, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F);
/* 1398 */     JRMCoreH.maxEnergy = JRMCoreH.stat((Entity)p, 5, pwr, 5, JRMCoreH.PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(pwr));
/* 1399 */     JRMCoreH.maxStamina = JRMCoreH.stat((Entity)p, 2, pwr, 3, JRMCoreH.PlyrAttrbts[2], rce, cls, 0.0F); } public static int aqMWr(String l) { String w;
/*      */     int a;
/*      */     int i;
/* 1402 */     for (w = "0123456789ABCDEF", l = l.toUpperCase(), a = 0, i = 0; i < l.length(); ) { char c = l.charAt(i); int d = w.indexOf(c); a = 16 * a + d; i++; }  return a; }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nQp65G(int b) {
/* 1408 */     String r = "64", k = "3B9ACA00"; return (b > aqMWr(k)) ? aqMWr(k) : ((b < aqMWr(r)) ? 0 : b);
/*      */   }
/*      */   
/*      */   public void handleStats3(String PlyrSkills, String x, String y, String z, EntityPlayer p) {
/* 1412 */     JRMCoreH.PlyrSkillX = x;
/* 1413 */     JRMCoreH.PlyrSkillY = y;
/* 1414 */     JRMCoreH.PlyrSkillZ = z;
/* 1415 */     JRMCoreH.PlyrSkills = PlyrSkills.split(",");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleStats(int curBody, int curEnergy, int curStamina, byte curRelease, byte b) {
/* 1421 */     JRMCoreH.curBody = curBody;
/* 1422 */     JRMCoreH.curEnergy = curEnergy;
/* 1423 */     JRMCoreH.curStamina = curStamina;
/* 1424 */     JRMCoreH.curRelease = curRelease;
/* 1425 */     JRMCoreH.TransSaiCurRg = b;
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleUpgrade(byte b, EntityPlayer p) {}
/*      */ 
/*      */   
/*      */   public void handleCol(int i, byte b, EntityPlayer p) {}
/*      */ 
/*      */   
/*      */   public void handleChar(byte b, int b2, EntityPlayer p) {}
/*      */   
/*      */   public void handleTick(int jrmcpg, String jrmcp, EntityPlayer p) {
/* 1438 */     if (jrmcpg == 4) {
/* 1439 */       String[] s = jrmcp.split(";");
/* 1440 */       if (s.length > 2) {
/* 1441 */         Entity e = p.field_70170_p.func_73045_a(Integer.parseInt(s[0]));
/* 1442 */         if (e != null) {
/* 1443 */           if (JGConfigClientSettings.CLIENT_DA15) {
/*      */             
/* 1445 */             float a = 1.0F, h1 = 1.0F;
/* 1446 */             float scale = e.field_70173_aa * e.field_70131_O / 100.0F;
/*      */ 
/*      */             
/* 1449 */             Entity pl = e;
/*      */             
/* 1451 */             double x = 0.0D;
/* 1452 */             double y = (pl.field_70131_O * 0.6F);
/* 1453 */             double z = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1462 */             EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", e.field_70170_p, 0.4F, 0.4F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 4.0D) + 12, 12, 4, 32, true, (float)(Math.random() * 0.30000001192092896D) + 0.3F, false, 0.0F, 1, "", 35, 1, (float)(Math.random() * 0.019999999552965164D) + 0.04F, (float)(Math.random() * 0.029999999329447746D) + 0.06F, (float)(Math.random() * 0.003000000026077032D) + 0.001F, 0, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, null);
/*      */ 
/*      */ 
/*      */             
/* 1466 */             entityCusPar.setdata39((int)(Math.random() * 360.0D));
/* 1467 */             e.field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */             
/* 1469 */             int num = (int)(Math.random() * 4.0D) + 1;
/* 1470 */             for (int i = 0; i < num; i++) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1478 */               EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", e.field_70170_p, 0.4F, 0.4F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 4.0D) + 4, 4, 4, 64, true, (float)(Math.random() * 0.4000000059604645D) + 0.4F, false, 0.0F, 1, "", 22, 1, (float)(Math.random() * 0.019999999552965164D) + 0.03F, (float)(Math.random() * 0.029999999329447746D) + 0.05F, (float)(Math.random() * 0.0020000000949949026D) + 0.001F, 0, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.05F, false, -1, false, null);
/*      */ 
/*      */ 
/*      */               
/* 1482 */               entityCusPar1.setdata39((int)(Math.random() * 360.0D));
/* 1483 */               e.field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/* 1488 */           JRMCoreH.damInd.put(e.field_70165_t + ":" + (e.field_70163_u + e.field_70131_O) + ":" + e.field_70161_v, s[2] + ":100");
/*      */         }
/*      */       
/*      */       }
/*      */     
/* 1493 */     } else if (jrmcpg == 50) {
/* 1494 */       if (JGConfigClientSettings.instantTransmissionParticles) {
/* 1495 */         String[] s = jrmcp.split(";");
/* 1496 */         if (s.length > 3) {
/* 1497 */           Entity e = p.field_70170_p.func_73045_a(Integer.parseInt(s[0]));
/* 1498 */           if (e != null)
/*      */           {
/*      */             
/* 1501 */             float scale = 0.025F * e.field_70131_O;
/* 1502 */             float a = 0.25F;
/* 1503 */             Entity pl = e;
/*      */             
/* 1505 */             double x = 0.0D;
/* 1506 */             double y = (pl.field_70131_O * 0.5F);
/* 1507 */             double z = 0.0D;
/*      */             
/* 1509 */             double x2 = Double.parseDouble(s[1]);
/* 1510 */             double y2 = Double.parseDouble(s[2]);
/* 1511 */             double z2 = Double.parseDouble(s[3]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1518 */             EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles2.png", e.field_70170_p, 0.4F, 0.4F, x2, y2, z2, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, (int)(Math.random() * 3.0D), 0, 0, 64, false, 0.0F, false, 0.0F, 1, "", 10, 1, scale, scale / 50.0F, -scale / 20.0F, 0, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, a, 0.0F, 0.0F, 0.0F, a / 5.0F, false, -1, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1525 */             e.field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     
/* 1532 */     } else if (jrmcpg != 5) {
/*      */ 
/*      */       
/* 1535 */       if (jrmcpg == 20) {
/*      */         
/* 1537 */         p.openGui(mod_JRMCore.instance, 2, p.field_70170_p, (int)p.field_70165_t, (int)p.field_70163_u, (int)p.field_70161_v);
/* 1538 */         JRMCoreH.ask = jrmcp;
/*      */       }
/* 1540 */       else if (jrmcpg == 22) {
/*      */         
/* 1542 */         p.openGui(mod_JRMCore.instance, 3, p.field_70170_p, (int)p.field_70165_t, (int)p.field_70163_u, (int)p.field_70161_v);
/* 1543 */         JRMCoreH.ask = jrmcp;
/*      */       
/*      */       }
/* 1546 */       else if (jrmcpg == 1) {
/* 1547 */         if (jrmcp == "::") {
/* 1548 */           JRMCoreH.plyrsArnd = null;
/*      */         } else {
/* 1550 */           JRMCoreH.plyrsArnd = jrmcp.toString().replaceAll("::", "").split(":");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void handleNotification(EntityPlayer p, String title, String description, byte category, byte icon, byte renderLocation, int iconColor) {
/* 1557 */     handleNotification(title, description, category, icon, renderLocation, iconColor);
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleNotification(String title, String description, byte category, byte icon, byte renderLocation, int iconColor) {
/* 1562 */     if (JGNotificationGUI.categoryState[category] != 2 && JGNotificationGUI.categoryState[0] != 2)
/*      */     {
/* 1564 */       JGNotificationHandlerC.addNotification(new JGNotification(title, description, category, icon, renderLocation, iconColor));
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCorePacHanC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */