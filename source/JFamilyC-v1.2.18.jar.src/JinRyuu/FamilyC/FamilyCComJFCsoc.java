/*     */ package JinRyuu.FamilyC;
/*     */ import JinRyuu.JRMCore.FamilyCH;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import java.util.Random;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class FamilyCComJFCsoc extends CommandBase {
/*     */   private static int dnsRaceSlcted;
/*     */   private static int dnsGenderSlcted;
/*     */   private static int dnsHairSlcted;
/*     */   private static int dnsHair2Slcted;
/*     */   
/*     */   public String func_71517_b() {
/*  20 */     return "jfc";
/*     */   }
/*     */   private static int dnsColorSlcted; private static int dnsBreastSizeSlcted; private static int dnsBodyTypeSlcted; private static int dnsBodyColMainSlcted; private static int dnsBodyColSub1Slcted; private static int dnsBodyColSub2Slcted; private static int dnsBodyColSub3Slcted; private static int dnsFaceNoseSlcted; private static int dnsFaceMouthSlcted; private static int dnsEyesSlcted;
/*     */   private static int dnsEyeCol1Slcted;
/*     */   private static int dnsEyeCol2Slcted;
/*     */   private static String dns;
/*     */   
/*     */   public int func_82362_a() {
/*  28 */     return 2;
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*  33 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  35 */       throw new WrongUsageException("/jfc spawn child [childName]", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  39 */     String s = par2ArrayOfStr[0];
/*  40 */     boolean flag = (s.contains("single") || s.contains("Single") || s.contains("SINGLE"));
/*  41 */     boolean par = (s.contains("noParent") || s.contains("noparent") || s.contains("NOPARENT") || s.contains("Noparent") || s.contains("NoParent"));
/*  42 */     boolean chi = (s.contains("noChild") || s.contains("nochild") || s.contains("NOCHILD") || s.contains("Nochild") || s.contains("NoChild"));
/*  43 */     boolean spwn = (s.contains("spawn") || s.contains("SPAWN") || s.contains("Spawn"));
/*  44 */     boolean rem = s.toLowerCase().contains("remove");
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
/*  61 */     if (spwn && par2ArrayOfStr.length > 1) {
/*  62 */       String s1 = par2ArrayOfStr[1];
/*  63 */       boolean child = (s1.contains("child") || s.contains("Child") || s.contains("CHILD"));
/*  64 */       if (child) {
/*  65 */         String name; entityplayermp = func_71521_c(par1ICommandSender);
/*     */ 
/*     */         
/*  68 */         if (par2ArrayOfStr.length > 2) {
/*  69 */           name = par2ArrayOfStr[2];
/*     */         } else {
/*  71 */           name = FamilyCH.namGen();
/*     */         } 
/*  73 */         Random ran = new Random();
/*  74 */         int rid = ran.nextInt(5);
/*  75 */         byte r = (byte)rid;
/*  76 */         s1 = s1.toLowerCase(Locale.ENGLISH);
/*  77 */         if (JRMCoreH.DBC()) { r = s1.contains("human") ? 0 : (s1.contains("saiyan") ? 1 : (s1.contains("halfsaiyan") ? 2 : (s1.contains("namekian") ? 3 : (s1.contains("arcosian") ? 4 : (s1.contains("majin") ? 5 : r))))); }
/*  78 */         else { r = 0; }
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
/*  91 */         dnsRaceSlcted = r;
/*     */         
/*  93 */         dnsGenderSlcted = ran.nextInt(2);
/*     */ 
/*     */         
/*  96 */         dnsHairSlcted = 12;
/*     */         
/*  98 */         dnsHair2Slcted = 0;
/*     */         
/* 100 */         dnsColorSlcted = ran.nextInt(16777000);
/*     */         
/* 102 */         dnsBreastSizeSlcted = (dnsGenderSlcted == 1) ? ran.nextInt(9) : 0;
/*     */         
/* 104 */         dnsBodyTypeSlcted = ran.nextInt(JRMCoreH.customSknLimits[r][0]);
/*     */         
/* 106 */         int rid2 = ran.nextInt(JRMCoreH.customSknLimitsBCP[r]);
/* 107 */         int cls = (JRMCoreH.defbodycols[rid2][r]).length;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 113 */         rid = ran.nextInt(5);
/* 114 */         dnsBodyColMainSlcted = (cls < 1) ? 0 : ((rid < 4) ? JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][0] : ran.nextInt(16777000));
/* 115 */         if (JRMCoreH.isRaceMajin(r)) {
/* 116 */           dnsColorSlcted = dnsBodyColMainSlcted;
/*     */         }
/*     */         
/* 119 */         rid = ran.nextInt(5);
/* 120 */         dnsBodyColSub1Slcted = (cls < 2) ? 0 : ((rid < 4) ? JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][1] : ran.nextInt(16777000));
/* 121 */         rid = ran.nextInt(5);
/* 122 */         dnsBodyColSub2Slcted = (cls < 3) ? 0 : ((rid < 4) ? JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][2] : ran.nextInt(16777000));
/* 123 */         rid = ran.nextInt(5);
/* 124 */         dnsBodyColSub3Slcted = (cls < 4) ? 0 : ((rid < 4) ? JRMCoreH.defbodycols[ran.nextInt(JRMCoreH.customSknLimitsBCP[r])][r][3] : ran.nextInt(16777000));
/*     */         
/* 126 */         dnsFaceNoseSlcted = ran.nextInt(JRMCoreH.customSknLimits[r][2]);
/* 127 */         dnsFaceMouthSlcted = ran.nextInt(JRMCoreH.customSknLimits[r][3]);
/*     */         
/* 129 */         dnsEyesSlcted = ran.nextInt(JRMCoreH.customSknLimits[r][4]);
/* 130 */         rid = ran.nextInt(2);
/* 131 */         rid2 = ran.nextInt(5);
/* 132 */         dnsEyeCol1Slcted = (rid == 0) ? JRMCoreH.defeyecols[ran.nextInt(JRMCoreH.defeyecols.length)][r] : ran.nextInt(16777000);
/* 133 */         rid = ran.nextInt(2);
/* 134 */         dnsEyeCol2Slcted = (rid2 != 0) ? dnsEyeCol1Slcted : ((rid == 0) ? JRMCoreH.defeyecols[ran.nextInt(JRMCoreH.defeyecols.length)][r] : ran.nextInt(16777000));
/*     */         
/* 136 */         setdns();
/*     */         
/* 138 */         String dnsHdef = JRMCoreH.defHairPrsts[ran.nextInt(JRMCoreH.defHairPrsts.length)];
/* 139 */         String dnsHc = (dnsHairSlcted != 12) ? "0" : dnsHdef;
/*     */ 
/*     */         
/* 142 */         MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*     */         
/* 144 */         boolean bool = true;
/*     */ 
/*     */         
/* 147 */         String p2 = FamilyCH.rpfd(server, entityplayermp.func_70005_c_());
/* 148 */         if (p2.contains(";")) {
/* 149 */           String[] p2d = p2.split(";");
/* 150 */           if (p2d.length >= FamilyCConfig.mc || FamilyCConfig.dcr) {
/* 151 */             bool = false;
/* 152 */             if (FamilyCConfig.dcr) {
/* 153 */               notifyAdmins(par1ICommandSender, "Children are disabled!", new Object[0]);
/*     */             } else {
/* 155 */               notifyAdmins(par1ICommandSender, "You already reached your children limit of %s", new Object[] { Integer.valueOf(FamilyCConfig.mc), entityplayermp.func_70005_c_() });
/*     */             } 
/*     */           } 
/*     */         } 
/* 159 */         while (bool)
/*     */         {
/* 161 */           ran = new Random();
/* 162 */           rid = ran.nextInt(1000000);
/* 163 */           if (FamilyCH.rcfd(server, rid + "").length() < 2)
/*     */           {
/* 165 */             FamilyCH.wcfd(server, entityplayermp.func_70005_c_() + ":" + entityplayermp.func_70005_c_() + ":" + name, rid, false);
/* 166 */             String pm = FamilyCH.rpfd(server, entityplayermp.func_70005_c_());
/*     */             
/* 168 */             pm = ((pm.contains(";") || pm.length() > 2) ? (pm + ";") : "") + rid + ":" + entityplayermp.func_70005_c_();
/* 169 */             FamilyCH.wpfd(server, pm, entityplayermp.func_70005_c_(), false);
/*     */ 
/*     */             
/* 172 */             EntityNPC c = new EntityNPC(entityplayermp.field_70170_p, dns, entityplayermp.func_70005_c_(), entityplayermp.func_70005_c_(), name, rid, dnsHc);
/* 173 */             c.func_70012_b(entityplayermp.field_70165_t, entityplayermp.field_70163_u, entityplayermp.field_70161_v, 0.0F, 0.0F);
/* 174 */             c.setCnam((byte)1);
/* 175 */             c.setNPCAge(0.5F);
/* 176 */             entityplayermp.field_70170_p.func_72838_d((Entity)c);
/* 177 */             JRMCoreH.setString("b", (EntityPlayer)entityplayermp, FamilyCH.prID);
/*     */             
/* 179 */             notifyAdmins(par1ICommandSender, "Child Spawned named %s", new Object[] { name, entityplayermp.func_70005_c_() });
/* 180 */             bool = false;
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 187 */         entityplayermp = func_82359_c(par1ICommandSender, s1);
/*     */       } 
/* 189 */       String str1 = "";
/*     */     
/*     */     }
/* 192 */     else if (rem && par2ArrayOfStr.length > 1) {
/* 193 */       String childName = par2ArrayOfStr[1];
/*     */       
/* 195 */       if (par2ArrayOfStr.length > 2) {
/*     */         
/* 197 */         entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[2]);
/*     */       }
/*     */       else {
/*     */         
/* 201 */         entityplayermp = func_71521_c(par1ICommandSender);
/*     */       } 
/*     */       
/* 204 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*     */       
/* 206 */       boolean allow = true;
/* 207 */       String p1 = FamilyCH.rpfd(server, entityplayermp.func_70005_c_());
/* 208 */       String[] p1d = p1.split(";");
/* 209 */       String c = "";
/* 210 */       for (int i2 = 0; i2 < p1d.length; i2++) {
/* 211 */         String[] d = p1d[i2].split(":");
/* 212 */         String[] childFamilyData = FamilyCH.rcfd(server, d[0]).split(":");
/* 213 */         if (childFamilyData[2].equalsIgnoreCase(childName)) {
/* 214 */           int cid = Integer.parseInt(d[0]);
/* 215 */           String mom = childFamilyData[0];
/* 216 */           String dad = childFamilyData[1];
/* 217 */           String cd = FamilyCH.rcfd(server, cid + "");
/* 218 */           FamilyCH.wcfd(server, "d", cid, true);
/*     */           
/* 220 */           String pm = FamilyCH.rpfd(server, mom);
/* 221 */           String[] pmd = pm.split(";");
/* 222 */           String pmdn = "d";
/* 223 */           for (int i = 0; i < pmd.length; i++) {
/* 224 */             if (!pmd[i].equalsIgnoreCase(cid + ":" + dad)) {
/* 225 */               pmdn = pmdn + ";" + pmd[i];
/*     */             }
/*     */           } 
/* 228 */           pmdn = (pmdn.length() > 1) ? pmdn.substring(2) : pmdn;
/* 229 */           FamilyCH.wpfd(server, pmdn, mom, (pmdn.length() < 2 && pmdn.startsWith("d")));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 235 */           if (!mom.equalsIgnoreCase(dad)) {
/* 236 */             String pd = FamilyCH.rpfd(server, dad);
/* 237 */             String[] pdd = pm.split(";");
/* 238 */             String pddn = "d";
/* 239 */             for (int j = 0; j < pdd.length; j++) {
/* 240 */               if (!pdd[j].equalsIgnoreCase(cid + ":" + dad)) {
/* 241 */                 pddn = pddn + ";" + pdd[j];
/*     */               }
/*     */             } 
/* 244 */             pddn = (pddn.length() > 1) ? pddn.substring(2) : pddn;
/* 245 */             FamilyCH.wpfd(server, pddn, dad, (pddn.length() < 2 && pddn.startsWith("d")));
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 253 */         c = c + ";" + FamilyCH.rcfd(server, d[0]) + ":" + FamilyCH.rcpd(server, d[0]);
/*     */       } 
/* 255 */       c = c.substring(1);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 265 */       entityplayermp = func_71521_c(par1ICommandSender);
/* 266 */       throw new WrongUsageException("Child Spawned failed.", new Object[0]);
/*     */     } 
/*     */ 
/*     */     
/* 270 */     if (!entityplayermp.getEntityData().func_74764_b("PlayerPersisted")) {
/* 271 */       NBTTagCompound nbt = new NBTTagCompound();
/* 272 */       entityplayermp.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */     } else {
/* 274 */       NBTTagCompound nBTTagCompound = entityplayermp.getEntityData().func_74775_l("PlayerPersisted");
/*     */     } 
/*     */   }
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
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 302 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */   
/* 305 */   private static String ntl(int i) { return JRMCoreH.numToLet(i); } private static String ntl5(int i) {
/* 306 */     return JRMCoreH.numToLet5(i);
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 310 */     return "/jfc spawn child [childName]";
/*     */   }
/*     */   
/*     */   public static void setdns() {
/* 314 */     String R = ntl(dnsRaceSlcted);
/* 315 */     String G = dnsGenderSlcted + "";
/* 316 */     String H1 = ntl(dnsHairSlcted);
/* 317 */     String H2 = ntl(dnsHair2Slcted);
/* 318 */     String HC = ntl5(dnsColorSlcted);
/* 319 */     String BS = dnsBreastSizeSlcted + "";
/* 320 */     String ST = "1";
/* 321 */     String BT = ntl(dnsBodyTypeSlcted);
/* 322 */     String BCM = ntl5(dnsBodyColMainSlcted);
/* 323 */     String BC1 = ntl5(dnsBodyColSub1Slcted);
/* 324 */     String BC2 = ntl5(dnsBodyColSub2Slcted);
/* 325 */     String BC3 = ntl5(dnsBodyColSub3Slcted);
/* 326 */     String FN = ntl(dnsFaceNoseSlcted);
/* 327 */     String FM = ntl(dnsFaceMouthSlcted);
/* 328 */     String ET = ntl(dnsEyesSlcted);
/* 329 */     String EC1 = ntl5(dnsEyeCol1Slcted);
/* 330 */     String EC2 = ntl5(dnsEyeCol2Slcted);
/*     */ 
/*     */     
/* 333 */     dns = R + G + H1 + H2 + HC + BS + ST + BT + BCM + BC1 + BC2 + BC3 + FN + FM + ET + EC1 + EC2;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyCComJFCsoc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */