/*      */ package JinRyuu.JRMCore;
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.DragonBC.common.DBCH;
/*      */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier1;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier2;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier3;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
/*      */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*      */ import JinRyuu.JRMCore.entity.EntitySafeZone;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*      */ 
/*      */ public class JRMCoreHDBC {
/*      */   public static final int Skl_GodFormLVLrequHN = 6;
/*      */   public static final int Skl_GodFormLVLrequA = 7;
/*      */   public static final int GodRacialRequirement = 6;
/*      */   public static final int Action_Kaioken = 1;
/*      */   public static final int Action_TransformType = 2;
/*      */   public static final int Action_GodForm = 3;
/*      */   public static final int Action_TailMode = 4;
/*      */   public static final int Action_ArcFace = 4;
/*      */   public static final int Action_Dodge = 5;
/*      */   public static final int Action_Descend = 6;
/*      */   public static final int Action_FlyMode = 7;
/*      */   
/*      */   public static int col_fe(int t, int d, int p, int r, int s, boolean v, boolean y, boolean ui) {
/*   41 */     return getPlayerColor(t, d, p, r, s, v, y, ui, false, false);
/*      */   } public static final int Action_EnergyInfusedProjectile = 8; public static final int Action_Fuzion = 9; public static final int Action_Mystic = 10; public static final int Action_KiFist = 11; public static final int Action_KiProtection = 12; public static final int Action_UltraInstinct = 13; public static final int Action_FriendlyFist = 14; public static final int Action_KiSword = 15; public static final int Action_InstantTransShortTPMode = 16; public static final int Action_InstantTransSurroundMode = 17; public static final int Action_GodOfDestruction = 18;
/*      */   public static int getPlayerColor2(int t, int d, int p, int r, int s, boolean v, boolean y, boolean ui, boolean gd) {
/*   44 */     return getPlayerColor(t, d, p, r, s, v, y, ui, false, gd);
/*      */   }
/*      */   public static int col_fe(int t, int d, int p, int r, int s, boolean v, boolean y, boolean ui, boolean ui2) {
/*   47 */     return getPlayerColor(t, d, p, r, s, v, y, ui, ui2, false);
/*      */   }
/*      */   
/*      */   public static int getPlayerColor(int type, int def, int p, int r, int s, boolean divine, boolean y, boolean ui, boolean ui2, boolean gd) {
/*   51 */     boolean ssb = (s == 10);
/*   52 */     boolean ssbs = (s == 15);
/*   53 */     boolean ss4 = (s == 14);
/*   54 */     boolean ssg = godKiUserBase(r, s);
/*   55 */     boolean ss = (s > 0 && s != 7);
/*      */     
/*   57 */     int clr = def;
/*   58 */     if (p == 1 && JRMCoreH.rc_sai(r)) {
/*   59 */       if (gd) { clr = (type == 0) ? 9446263 : ((type == 3) ? 12464847 : ((type == 1) ? 12976974 : 12464847)); }
/*   60 */       else if (ui2) { clr = (type == 15790320) ? 15790320 : ((type == 1) ? 13816530 : 15790320); }
/*   61 */       else if (ui) { clr = (type == 0) ? 15790320 : ((type == 1) ? 13816530 : 15790320); }
/*   62 */       else if (ssb && divine) { clr = (type == 0 || type == 3) ? 14985390 : ((type == 1) ? 11115418 : 7536661); }
/*   63 */       else if (ssbs && divine) { clr = (type == 0 || type == 3) ? 14184352 : ((type == 1) ? 9338493 : 14030412); }
/*   64 */       else if (ssb) { clr = (type == 0 || type == 3) ? 2805230 : ((type == 1) ? 2469062 : 2805230); }
/*   65 */       else if (ssbs) { clr = (type == 0 || type == 3) ? 32767 : ((type == 1) ? 23039 : 32767); }
/*   66 */       else if (ssg) { clr = (type == 0 || type == 3) ? 14028139 : ((type == 1) ? 14943270 : 16761125); }
/*   67 */       else if (ss4) { clr = (type == 0) ? def : ((type == 1) ? 15976455 : ((type == 3) ? (y ? 10092390 : 16574610) : (y ? 10092390 : 16701952))); }
/*   68 */       else if (ss) { clr = (type == 0 || type == 3) ? (y ? 10092390 : 16574610) : ((type == 1) ? 2988684 : (y ? 10092390 : 16701952)); }
/*      */     
/*   70 */     } else if (p == 1 && JRMCoreH.rc_hum(r) && ui2) {
/*   71 */       if (ui2) clr = (type == 15790320) ? 15790320 : ((type == 1) ? 13816530 : 15790320);
/*      */     
/*   73 */     } else if (p == 1 && JRMCoreH.rc_humNam(r)) {
/*   74 */       if (gd)
/*   75 */       { if (JRMCoreH.rc_hum(r)) {
/*   76 */           clr = (type == 0) ? 9446263 : ((type == 3) ? 12464847 : ((type == 1) ? 12976974 : 12464847));
/*      */         } else {
/*      */           
/*   79 */           clr = (type == 3) ? 12464847 : ((type == 1) ? 12976974 : 12464847);
/*      */         }
/*      */          }
/*   82 */       else if (ui) { clr = (type == 0) ? def : ((type == 1) ? 13816530 : 15790320); }
/*   83 */       else if (ssg) { clr = (type == 1) ? 14943270 : ((type == 2) ? 16761125 : clr); }
/*      */     
/*   85 */     } else if (p == 1 && JRMCoreH.rc_arc(r)) {
/*      */       
/*   87 */       if (gd) { clr = (type == 3) ? 12464847 : ((type == 1) ? 12976974 : 12464847); }
/*   88 */       else if (ui) { clr = (type == 0) ? def : ((type == 1) ? 13816530 : 15790320); }
/*   89 */       else if (ssg) { clr = (type == 1) ? 14943270 : ((type == 2) ? 16761125 : clr); }
/*   90 */       else if (s == 6) { clr = (type == 2) ? 16430355 : clr; }
/*      */     
/*   92 */     } else if (p == 1 && JRMCoreH.isRaceMajin(r)) {
/*   93 */       if (gd) { clr = (type == 3) ? 12464847 : ((type == 1) ? 12976974 : 12464847); }
/*   94 */       else if (ui) { clr = (type == 1) ? 13816530 : 15790320; }
/*   95 */       else if (ssg) { clr = (type == 1) ? 14943270 : ((type == 2) ? 16761125 : clr); }
/*   96 */       else if (s == 1) { clr = (type == 1) ? 16579836 : ((type == 3) ? 12561588 : clr); }
/*   97 */       else if (s == 2) { clr = (type == 3) ? 16024763 : clr; }
/*   98 */       else if (s == 3) { clr = (type == 3 || type == 2) ? 16756968 : clr; }
/*      */     
/*      */     } 
/*  101 */     return clr;
/*      */   }
/*      */   public static boolean godKiUser(int r, int s) {
/*  104 */     if (JRMCoreH.rc_sai(r))
/*  105 */       return (s == 10 || s == 9 || s == 11); 
/*  106 */     if (JRMCoreH.rc_humNam(r))
/*  107 */       return (s == 3); 
/*  108 */     if (JRMCoreH.isRaceMajin(r))
/*  109 */       return (s == 4); 
/*  110 */     if (JRMCoreH.rc_arc(r))
/*  111 */       return (s == 7); 
/*  112 */     return (s == 10 || s == 9 || s == 11);
/*      */   }
/*      */   
/*      */   public static boolean godKiUserBase(int r, int s) {
/*  116 */     if (JRMCoreH.rc_sai(r))
/*  117 */       return (s == 9 || s == 11); 
/*  118 */     if (DBCgetConfigGodformCosm() && JRMCoreH.rc_humNam(r))
/*  119 */       return (s == 3); 
/*  120 */     if (DBCgetConfigGodformCosm() && JRMCoreH.isRaceMajin(r))
/*  121 */       return (s == 4); 
/*  122 */     if (DBCgetConfigGodformCosm() && JRMCoreH.rc_arc(r))
/*  123 */       return (s == 7); 
/*  124 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean godformslr(int s) {
/*  130 */     return (s >= 6);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean godformslrHN(int s) {
/*  136 */     return (s >= 6);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean godformslrA(int s) {
/*  142 */     return (s >= 7);
/*      */   }
/*      */   
/*      */   public static boolean godKiAble() {
/*  146 */     if (JRMCoreH.rc_sai(JRMCoreH.Race) && godformslr(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX)))
/*  147 */       return true; 
/*  148 */     if (JRMCoreH.rc_humNam(JRMCoreH.Race) && godformslrHN(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX)))
/*  149 */       return true; 
/*  150 */     if (JRMCoreH.isRaceMajin(JRMCoreH.Race) && hasMajinGodRacialRequirement(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX)))
/*  151 */       return true; 
/*  152 */     if (JRMCoreH.rc_arc(JRMCoreH.Race) && godformslrA(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX)))
/*  153 */       return true; 
/*  154 */     return false;
/*      */   }
/*      */   public static boolean godKiAble(int r, int sklX) {
/*  157 */     if (JRMCoreH.rc_sai(r) && godformslr(sklX))
/*  158 */       return true; 
/*  159 */     if (JRMCoreH.rc_humNam(r) && godformslrHN(sklX))
/*  160 */       return true; 
/*  161 */     if (JRMCoreH.isRaceMajin(r) && hasMajinGodRacialRequirement(sklX))
/*  162 */       return true; 
/*  163 */     if (JRMCoreH.rc_arc(r) && godformslrA(sklX))
/*  164 */       return true; 
/*  165 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean auc(int sklX) {
/*  169 */     if (sklX >= 6)
/*  170 */       return true; 
/*  171 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean hasMajinGodRacialRequirement(int racialLvl) {
/*  176 */     return (racialLvl >= 6);
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
/*      */   public static void actionInitDBC()
/*      */   {
/*  199 */     JRMCoreA.actionsDBC.put(Integer.valueOf(0), Integer.valueOf(1));
/*  200 */     JRMCoreA.actionsDBC.put(Integer.valueOf(1), Integer.valueOf(2));
/*  201 */     JRMCoreA.actionsDBC.put(Integer.valueOf(2), Integer.valueOf(6));
/*  202 */     JRMCoreA.actionsDBC.put(Integer.valueOf(3), Integer.valueOf(5));
/*  203 */     JRMCoreA.actionsDBC.put(Integer.valueOf(5), Integer.valueOf(7));
/*  204 */     JRMCoreA.actionsDBC.put(Integer.valueOf(6), Integer.valueOf(9));
/*  205 */     JRMCoreA.actionsDBC.put(Integer.valueOf(7), Integer.valueOf(4));
/*  206 */     JRMCoreA.actionsDBC.put(Integer.valueOf(8), Integer.valueOf(10));
/*  207 */     JRMCoreA.actionsDBC.put(Integer.valueOf(9), Integer.valueOf(11));
/*  208 */     JRMCoreA.actionsDBC.put(Integer.valueOf(10), Integer.valueOf(12));
/*  209 */     JRMCoreA.actionsDBC.put(Integer.valueOf(11), Integer.valueOf(13));
/*  210 */     JRMCoreA.actionsDBC.put(Integer.valueOf(12), Integer.valueOf(14));
/*  211 */     JRMCoreA.actionsDBC.put(Integer.valueOf(14), Integer.valueOf(15));
/*  212 */     JRMCoreA.actionsDBC.put(Integer.valueOf(15), Integer.valueOf(16));
/*  213 */     JRMCoreA.actionsDBC.put(Integer.valueOf(16), Integer.valueOf(17));
/*  214 */     JRMCoreA.actionsDBC.put(Integer.valueOf(17), Integer.valueOf(18)); } public static String action(int d, boolean action, boolean black) { String skllName; int skillLvl;
/*      */     boolean ps;
/*      */     int skl_d, skl_f, sklX;
/*      */     boolean tt, ttg, ttb, tt4;
/*      */     int skl2, tlmd, skl_f2;
/*      */     boolean kwsw, kssc;
/*      */     int itLevel;
/*  221 */     String opt1 = JGConfigClientSettings.CLIENT_GR12 ? "Enable" : "Off";
/*  222 */     String opt2 = JGConfigClientSettings.CLIENT_GR12 ? "Disable" : "On";
/*      */     
/*  224 */     String clr1 = "§4";
/*  225 */     String clr2 = "§2";
/*      */     
/*  227 */     if (JGConfigClientSettings.CLIENT_GR13) black = true;
/*      */     
/*  229 */     int race = JRMCoreH.Race;
/*  230 */     int pwr = JRMCoreH.Pwrtyp;
/*  231 */     int state = JRMCoreH.State;
/*  232 */     int align = JRMCoreH.align;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  237 */     if (JRMCoreH.PlyrSettingsB(6) && JRMCoreH.SklLvl(10, JRMCoreH.Pwrtyp) < 1)
/*      */     {
/*  239 */       JRMCoreH.Skll((byte)6, (byte)6, (byte)1);
/*      */     }
/*      */     
/*  242 */     if (JRMCoreH.PlyrSettingsB(11) && JGConfigUltraInstinct.CONFIG_UI_LEVELS == 0)
/*      */     {
/*  244 */       JRMCoreH.Skll((byte)6, (byte)11, (byte)1);
/*      */     }
/*      */     
/*  247 */     switch (d) {
/*      */       case 1:
/*  249 */         skllName = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.DBCSkillsIDs[8], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames));
/*  250 */         skillLvl = JRMCoreH.SklLvl(8, JRMCoreH.Pwrtyp);
/*  251 */         ps = JRMCoreH.PlyrSettingsB(0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  263 */         if (!JRMCoreH.PlyrSettingsB(11) && !JRMCoreH.PlyrSettingsB(16) && !JRMCoreH.PlyrSettingsB(6)) {
/*      */           
/*  265 */           skllName = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.DBCSkillsIDs[8], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames));
/*  266 */           skillLvl = JRMCoreH.SklLvl(8, JRMCoreH.Pwrtyp);
/*  267 */           ps = JRMCoreH.PlyrSettingsB(0);
/*      */           
/*  269 */           if (skillLvl > 0)
/*      */           {
/*  271 */             if (action)
/*  272 */             { if (ps) { JRMCoreH.Skll((byte)6, (byte)0, (byte)1); }
/*  273 */               else { JRMCoreH.Skll((byte)6, (byte)0, (byte)0); }
/*      */                }
/*  275 */             else { String enable = JRMCoreH.trl("jrmc", opt1);
/*  276 */               String disable = JRMCoreH.trl("jrmc", opt2);
/*  277 */               return skllName + ": " + (ps ? ((black ? "" : "§2") + disable) : ((black ? "" : "§4") + enable)); }
/*      */           
/*      */           }
/*      */         } 
/*  281 */         if (skillLvl > 0 && !action) {
/*  282 */           return skllName + " is not useable, because " + (JRMCoreH.PlyrSettingsB(11) ? "Ultra instinct" : (
/*  283 */             JRMCoreH.PlyrSettingsB(16) ? "God of Destruction" : "Mystic form")) + " is enabled!";
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  290 */         return "";
/*      */       case 13:
/*  292 */         if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */           
/*  294 */           skllName = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.DBCSkillsIDs[16], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames));
/*  295 */           skillLvl = JRMCoreH.SklLvl(16, JRMCoreH.Pwrtyp);
/*  296 */           ps = JRMCoreH.PlyrSettingsB(11);
/*      */           
/*  298 */           if (!JRMCoreH.PlyrSettingsB(0) && !JRMCoreH.PlyrSettingsB(16) && !JRMCoreH.PlyrSettingsB(6) && 
/*  299 */             skillLvl > 0)
/*      */           {
/*  301 */             if (action) {
/*  302 */               if (ps) { JRMCoreH.Skll((byte)6, (byte)11, (byte)1);
/*      */ 
/*      */ 
/*      */                 
/*      */                  }
/*      */               
/*      */               else
/*      */               
/*      */               { 
/*      */ 
/*      */                 
/*  313 */                 JRMCoreH.Skll((byte)6, (byte)11, (byte)0); }
/*      */             
/*      */             } else {
/*  316 */               String enable = JRMCoreH.trl("jrmc", opt1);
/*  317 */               String disable = JRMCoreH.trl("jrmc", opt2);
/*  318 */               return skllName + ": " + (ps ? ((black ? "" : "§2") + disable) : ((black ? "" : "§4") + enable));
/*      */             } 
/*      */           }
/*      */           
/*  322 */           if (skillLvl > 0 && !action) {
/*  323 */             return skllName + " is not useable, because " + (JRMCoreH.PlyrSettingsB(0) ? "Kaioken" : (
/*  324 */               JRMCoreH.PlyrSettingsB(16) ? "God of Destruction" : "Mystic form")) + " is enabled!";
/*      */           }
/*  326 */           return "";
/*      */         } 
/*      */       case 10:
/*  329 */         skllName = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.DBCSkillsIDs[10], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames));
/*  330 */         skillLvl = JRMCoreH.SklLvl(10, JRMCoreH.Pwrtyp);
/*  331 */         ps = JRMCoreH.PlyrSettingsB(6);
/*      */         
/*  333 */         if (!JRMCoreH.PlyrSettingsB(0) && !JRMCoreH.PlyrSettingsB(16) && !JRMCoreH.PlyrSettingsB(11) && 
/*  334 */           skillLvl > 0) {
/*  335 */           if (action) {
/*  336 */             if (ps) { JRMCoreH.Skll((byte)6, (byte)6, (byte)1);
/*      */ 
/*      */               
/*      */                }
/*      */             
/*      */             else
/*      */             
/*      */             { 
/*      */ 
/*      */               
/*  346 */               JRMCoreH.Skll((byte)6, (byte)6, (byte)0); }
/*      */           
/*      */           } else {
/*  349 */             String enable = JRMCoreH.trl("jrmc", opt1);
/*  350 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*  351 */             return skllName + ": " + (ps ? ((black ? "" : "§2") + disable) : ((black ? "" : "§4") + enable));
/*      */           } 
/*      */         }
/*      */         
/*  355 */         if (skillLvl > 0 && !action) {
/*  356 */           return skllName + " is not useable, because " + (JRMCoreH.PlyrSettingsB(0) ? "Kaioken" : (
/*  357 */             JRMCoreH.PlyrSettingsB(16) ? "God of Destruction" : "Ultra instinct")) + " is enabled!";
/*      */         }
/*      */         
/*  360 */         return "";
/*      */       case 5:
/*  362 */         skllName = JRMCoreH.trl("dbc", "DodgeSwoop");
/*  363 */         skl_d = JRMCoreH.SklLvl(2, JRMCoreH.Pwrtyp);
/*  364 */         skl_f = JRMCoreH.SklLvl(3, JRMCoreH.Pwrtyp);
/*  365 */         ps = JRMCoreH.PlyrSettingsB(2);
/*  366 */         if (skl_d > 0 || skl_f > 0) {
/*  367 */           if (action)
/*  368 */           { if (ps) { JRMCoreH.Skll((byte)6, (byte)2, (byte)1); }
/*  369 */             else { JRMCoreH.Skll((byte)6, (byte)2, (byte)0); }
/*      */              }
/*  371 */           else { String enable = JRMCoreH.trl("jrmc", opt1);
/*  372 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*  373 */             return skllName + ": " + (ps ? ((black ? "" : "§4") + enable) : ((black ? "" : "§2") + disable)); }
/*      */         
/*      */         }
/*  376 */         return "";
/*      */       case 7:
/*  378 */         skllName = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.DBCSkillsIDs[3], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames));
/*  379 */         skillLvl = JRMCoreH.SklLvl(3, JRMCoreH.Pwrtyp);
/*  380 */         ps = JRMCoreH.StusEfctsMe(9);
/*  381 */         if (skillLvl > 0) {
/*  382 */           if (action)
/*  383 */           { if (ps) { JRMCoreH.Skll((byte)5, (byte)1, (byte)9); }
/*  384 */             else { JRMCoreH.Skll((byte)5, (byte)0, (byte)9); }
/*      */              }
/*  386 */           else { String enable = JRMCoreH.trl("jrmc", "OnSimple");
/*  387 */             String disable = JRMCoreH.trl("jrmc", "OnDynamic");
/*  388 */             return skllName + ": " + (ps ? ((black ? "" : "§2") + disable) : ((black ? "" : "§4") + enable)); }
/*      */         
/*      */         }
/*  391 */         return "";
/*      */       case 9:
/*  393 */         skllName = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.DBCSkillsIDs[0], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames));
/*  394 */         skillLvl = JRMCoreH.SklLvl(0, JRMCoreH.Pwrtyp);
/*  395 */         ps = JRMCoreH.PlyrSettingsB(4);
/*  396 */         if (skillLvl > 0) {
/*  397 */           if (action)
/*  398 */           { if (ps) { JRMCoreH.Skll((byte)6, (byte)4, (byte)1); }
/*  399 */             else { JRMCoreH.Skll((byte)6, (byte)4, (byte)0); }
/*      */              }
/*  401 */           else { String enable = JRMCoreH.trl("jrmc", opt1);
/*  402 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*  403 */             return skllName + ": " + (ps ? ((black ? "" : "§2") + disable) : ((black ? "" : "§4") + enable)); }
/*      */         
/*      */         }
/*  406 */         return "";
/*      */       
/*      */       case 6:
/*  409 */         if (JRMCoreH.isRaceMajin(race)) {
/*  410 */           int i = JRMCoreH.SklLvlX(pwr, JRMCoreH.PlyrSkillX);
/*  411 */           if (i > 4) {
/*  412 */             String TransNms = JRMCoreH.trl("jrmc", "MAbsorption");
/*  413 */             String name = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.PlyrSkillX, JRMCoreH.vlblRSkls, JRMCoreH.vlblRSklsNms, JRMCoreH.Race));
/*  414 */             name = name + "/n" + TransNms;
/*      */             
/*  416 */             if (action) {
/*  417 */               JRMCoreH.Skll((byte)5, (byte)(JRMCoreH.StusEfctsMe(21) ? 1 : 0), (byte)21);
/*      */             } else {
/*      */               
/*  420 */               boolean bo = JRMCoreH.StusEfctsMe(21);
/*  421 */               String enable = JRMCoreH.trl("jrmc", opt1);
/*  422 */               String disable = JRMCoreH.trl("jrmc", opt2);
/*  423 */               return TransNms + ": " + (!bo ? ((black ? "" : "§4") + enable) : ((black ? "" : "§2") + disable));
/*      */             } 
/*      */             
/*  426 */             return name;
/*      */           }
/*      */         
/*      */         }
/*  430 */         else if (JRMCoreH.isRaceArcosian(race) && state >= 1) {
/*  431 */           if (action) {
/*  432 */             Dscndng(4);
/*      */           } else {
/*  434 */             return JRMCoreH.trl("dbc", "Descend");
/*      */           } 
/*      */         } 
/*  437 */         return (race == 4) ? JRMCoreH.trl("dbc", "Descend") : "";
/*      */       case 2:
/*  439 */         sklX = JRMCoreH.SklLvlX(pwr, JRMCoreH.PlyrSkillX);
/*  440 */         tt = JRMCoreH.PlyrSettingsI(1, 0);
/*  441 */         ttg = JRMCoreH.PlyrSettingsI(1, 1);
/*  442 */         ttb = JRMCoreH.PlyrSettingsI(1, 2);
/*  443 */         tt4 = JRMCoreH.PlyrSettingsI(1, 3);
/*  444 */         skillLvl = JRMCoreH.SklLvl(9, JRMCoreH.Pwrtyp);
/*  445 */         skl2 = JRMCoreH.SklLvl(10, JRMCoreH.Pwrtyp);
/*      */         
/*  447 */         if (JRMCoreH.rc_sai(race) && sklX >= 6) {
/*  448 */           String TransNms = JRMCoreH.trl("jrmc", JRMCoreH.getTransformationName(race, ttb ? 10 : (ttg ? 9 : (tt ? 5 : (tt4 ? 14 : 2))), JRMCoreH.StusEfctsMe(17), false, false, false));
/*  449 */           String name = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.PlyrSkillX, JRMCoreH.vlblRSkls, JRMCoreH.vlblRSklsNms, JRMCoreH.Race));
/*  450 */           name = name + "/n" + TransNms;
/*      */           
/*  452 */           if (action)
/*  453 */           { boolean s4ap = (sklX >= 7 && JRMCoreH.s4ft > 0 && JRMCoreH.tailHas(JRMCoreH.TlMd));
/*  454 */             byte nag = (byte)((skillLvl > 1) ? 2 : ((skillLvl > 0) ? 1 : (s4ap ? 3 : -1)));
/*      */             
/*  456 */             if (ttb) { JRMCoreH.Skll((byte)8, (byte)1, (byte)1); }
/*      */             
/*  458 */             else if (ttg) { JRMCoreH.Skll((byte)8, (byte)1, (byte)(s4ap ? 3 : -1)); }
/*      */             
/*  460 */             else if (tt4) { JRMCoreH.Skll((byte)8, (byte)1, (byte)-1); }
/*      */             
/*  462 */             else if (tt) { JRMCoreH.Skll((byte)8, (byte)1, nag); }
/*      */             else
/*  464 */             { JRMCoreH.Skll((byte)8, (byte)1, (byte)0); }
/*      */              }
/*  466 */           else { return name; }
/*      */         
/*      */         } 
/*  469 */         if (JRMCoreH.rc_humNam(race) && sklX >= 3) {
/*  470 */           String TransNms = JRMCoreH.trl("jrmc", JRMCoreH.getTransformationName(race, ttg ? 3 : (tt ? 1 : 2), false, false, false, false));
/*  471 */           String name = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.PlyrSkillX, JRMCoreH.vlblRSkls, JRMCoreH.vlblRSklsNms, JRMCoreH.Race));
/*  472 */           name = name + "/n" + TransNms;
/*  473 */           if (action)
/*  474 */           { byte nag = (byte)((skillLvl > 0) ? 1 : -1);
/*      */             
/*  476 */             if (ttg) { JRMCoreH.Skll((byte)8, (byte)1, (byte)-1); }
/*      */             
/*  478 */             else if (tt) { JRMCoreH.Skll((byte)8, (byte)1, nag); }
/*      */             else
/*  480 */             { JRMCoreH.Skll((byte)8, (byte)1, (byte)0); }
/*      */              }
/*  482 */           else { return name; }
/*      */         
/*      */         } 
/*  485 */         if (JRMCoreH.isRaceMajin(race) && sklX >= 6) {
/*  486 */           String TransNms = JRMCoreH.trl("jrmc", JRMCoreH.getTransformationName(race, ttg ? 4 : (tt ? 3 : 1), false, false, false, false));
/*  487 */           String name = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.PlyrSkillX, JRMCoreH.vlblRSkls, JRMCoreH.vlblRSklsNms, JRMCoreH.Race));
/*  488 */           name = name + "/n" + TransNms;
/*  489 */           if (action)
/*  490 */           { byte nag = (byte)((skillLvl > 0) ? 1 : -1);
/*      */             
/*  492 */             if (ttg) { JRMCoreH.Skll((byte)8, (byte)1, (byte)-1); }
/*      */             
/*  494 */             else if (tt) { JRMCoreH.Skll((byte)8, (byte)1, nag); }
/*      */             else
/*  496 */             { JRMCoreH.Skll((byte)8, (byte)1, (byte)0); }
/*      */              }
/*  498 */           else { return name; }
/*      */         
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  520 */         if (JRMCoreH.rc_arc(race) && sklX >= 7) {
/*  521 */           String TransNms = JRMCoreH.trl("jrmc", JRMCoreH.getTransformationName(race, ttg ? 7 : (tt ? 6 : 5), false, false, false, false));
/*  522 */           String name = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.PlyrSkillX, JRMCoreH.vlblRSkls, JRMCoreH.vlblRSklsNms, JRMCoreH.Race));
/*  523 */           name = name + "/n" + TransNms;
/*  524 */           if (action)
/*  525 */           { byte nag = (byte)((skillLvl > 0) ? 1 : -1);
/*      */             
/*  527 */             if (ttg) { JRMCoreH.Skll((byte)8, (byte)1, (byte)-1); }
/*      */             
/*  529 */             else if (tt) { JRMCoreH.Skll((byte)8, (byte)1, nag); }
/*      */             else
/*  531 */             { JRMCoreH.Skll((byte)8, (byte)1, (byte)0); }
/*      */              }
/*  533 */           else { return name; }
/*      */         
/*      */         } 
/*  536 */         return "";
/*      */       case 4:
/*  538 */         tlmd = JRMCoreH.TlMd;
/*  539 */         if (action) {
/*  540 */           if ((race == 1 || race == 2) && (tlmd == 1 || tlmd == 0 || tlmd == -1)) JRMCoreH.Char((byte)102, (byte)0); 
/*  541 */           if (race == 4 && state == 5) JRMCoreH.Skll((byte)5, (byte)(JRMCoreH.StusEfctsMe(6) ? 1 : 0), (byte)6); 
/*      */         } else {
/*  543 */           if ((race == 1 || race == 2) && (tlmd == 1 || tlmd == 0 || tlmd == -1)) {
/*  544 */             String n = JRMCoreH.trl("jrmc", "TailMode");
/*      */             
/*  546 */             return n;
/*      */           } 
/*  548 */           if (race == 4 && state == 5) {
/*      */             
/*  550 */             String n = JRMCoreH.trl("jrmc", "ArcMask");
/*  551 */             boolean bo = JRMCoreH.StusEfctsMe(6);
/*  552 */             String enable = JRMCoreH.trl("jrmc", opt1);
/*  553 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*  554 */             return n + ": " + (!bo ? ((black ? "" : "§4") + enable) : ((black ? "" : "§2") + disable));
/*      */           } 
/*      */         } 
/*      */         
/*  558 */         return (race == 1 || race == 2) ? JRMCoreH.trl("jrmc", "TailMode") : ((race == 4) ? JRMCoreH.trl("jrmc", "ArcMask") : "");
/*      */       case 11:
/*  560 */         skllName = JRMCoreH.trl("dbc", "KiFist");
/*  561 */         skl_f = JRMCoreH.SklLvl(12, JRMCoreH.Pwrtyp);
/*  562 */         ps = JRMCoreH.PlyrSettingsB(9);
/*  563 */         if (skl_f > 0) {
/*  564 */           if (action)
/*  565 */           { if (ps) { JRMCoreH.Skll((byte)6, (byte)9, (byte)1); }
/*  566 */             else { JRMCoreH.Skll((byte)6, (byte)9, (byte)0); }
/*      */              }
/*  568 */           else { String enable = JRMCoreH.trl("jrmc", opt1);
/*  569 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*  570 */             return skllName + ": " + (ps ? ((black ? "" : "§4") + enable) : ((black ? "" : "§2") + disable)); }
/*      */         
/*      */         }
/*  573 */         return "";
/*      */       case 12:
/*  575 */         skllName = JRMCoreH.trl("dbc", "KiProtection");
/*  576 */         skl_f = JRMCoreH.SklLvl(11, JRMCoreH.Pwrtyp);
/*  577 */         ps = JRMCoreH.PlyrSettingsB(10);
/*  578 */         if (skl_f > 0) {
/*  579 */           if (action)
/*  580 */           { if (ps) { JRMCoreH.Skll((byte)6, (byte)10, (byte)1); }
/*  581 */             else { JRMCoreH.Skll((byte)6, (byte)10, (byte)0); }
/*      */              }
/*  583 */           else { String enable = JRMCoreH.trl("jrmc", opt1);
/*  584 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*  585 */             return skllName + ": " + (ps ? ((black ? "" : "§4") + enable) : ((black ? "" : "§2") + disable)); }
/*      */         
/*      */         }
/*  588 */         return "";
/*      */       case 14:
/*  590 */         skllName = JRMCoreH.trl("dbc", "FriendlyFist");
/*  591 */         skl_f = 1;
/*  592 */         ps = JRMCoreH.PlyrSettingsB(12);
/*  593 */         if (skl_f > 0) {
/*  594 */           if (action)
/*  595 */           { if (ps) { JRMCoreH.Skll((byte)6, (byte)12, (byte)1); }
/*  596 */             else { JRMCoreH.Skll((byte)6, (byte)12, (byte)0); }
/*      */              }
/*  598 */           else { String enable = JRMCoreH.trl("jrmc", opt1);
/*  599 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*  600 */             return skllName + ": " + (ps ? ((black ? "" : "§2") + disable) : ((black ? "" : "§4") + enable)); }
/*      */         
/*      */         }
/*  603 */         return "";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 15:
/*  621 */         skl_f = JRMCoreH.SklLvl(12, JRMCoreH.Pwrtyp);
/*  622 */         skl_f2 = JRMCoreH.SklLvl(15, JRMCoreH.Pwrtyp);
/*  623 */         kwsw = JRMCoreH.PlyrSettingsI(13, 0);
/*  624 */         kssc = JRMCoreH.PlyrSettingsI(13, 1);
/*      */         
/*  626 */         if (skl_f > 0 && skl_f2 > 0)
/*      */         {
/*      */           
/*  629 */           if (action) {
/*  630 */             if (kwsw) { JRMCoreH.Skll((byte)8, (byte)13, (byte)1); }
/*  631 */             else if (kssc) { JRMCoreH.Skll((byte)8, (byte)13, (byte)-1); }
/*  632 */             else { JRMCoreH.Skll((byte)8, (byte)13, (byte)0); }
/*      */           
/*      */           } else {
/*  635 */             String enable = JRMCoreH.trl("jrmc", opt1);
/*  636 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  641 */             String name = JRMCoreH.trl("dbc", "KiWeapon") + ": " + (kwsw ? ((black ? "" : "§2") + JRMCoreH.trl("dbc", "KiSword")) : (kssc ? ((black ? "" : "§2") + JRMCoreH.trl("dbc", "KiScythe")) : ((black ? "" : "§4") + JRMCoreH.trl("jrmc", "Off"))));
/*      */ 
/*      */             
/*  644 */             return name;
/*      */           } 
/*      */         }
/*  647 */         return "";
/*      */       case 16:
/*  649 */         itLevel = JRMCoreH.SklLvl(17, JRMCoreH.Pwrtyp);
/*  650 */         if (itLevel > 0) {
/*  651 */           if (action) {
/*  652 */             int id = JRMCoreH.PlyrSettings(14);
/*  653 */             id++;
/*  654 */             if (id > 1) id = -1; 
/*  655 */             JRMCoreH.Skll((byte)8, (byte)14, (byte)id);
/*      */           } else {
/*      */             
/*  658 */             int id = JRMCoreH.PlyrSettings(14);
/*  659 */             String ID = "InstantTransShortTPMode";
/*  660 */             String name = JRMCoreH.trl("dbc", "InstantTransShortTPMode") + ": " + (black ? "" : "§2") + JRMCoreH.trl("dbc", "InstantTransShortTPMode" + (id + 1));
/*  661 */             return name;
/*      */           } 
/*      */         }
/*  664 */         return "";
/*      */       case 17:
/*  666 */         itLevel = JRMCoreH.SklLvl(17, JRMCoreH.Pwrtyp);
/*  667 */         if (itLevel > 0) {
/*  668 */           if (action) {
/*  669 */             int id = JRMCoreH.PlyrSettings(15);
/*  670 */             id++;
/*  671 */             if (id > 1) id = -1; 
/*  672 */             JRMCoreH.Skll((byte)8, (byte)15, (byte)id);
/*      */           } else {
/*      */             
/*  675 */             int id = JRMCoreH.PlyrSettings(15);
/*  676 */             String ID = "InstantTransSurroundMode";
/*  677 */             String name = JRMCoreH.trl("dbc", "InstantTransSurroundMode") + ": " + (black ? "" : "§2") + JRMCoreH.trl("dbc", "InstantTransSurroundMode" + (id + 1));
/*  678 */             return name;
/*      */           } 
/*      */         }
/*  681 */         return "";
/*      */       case 18:
/*  683 */         skllName = JRMCoreH.trl("dbc", JRMCoreH.SklName(JRMCoreH.DBCSkillsIDs[18], JRMCoreH.DBCSkillsIDs, JRMCoreH.DBCSkillNames));
/*  684 */         skillLvl = JRMCoreH.SklLvl(18, JRMCoreH.Pwrtyp);
/*  685 */         ps = JRMCoreH.PlyrSettingsB(16);
/*      */         
/*  687 */         if (!JRMCoreH.PlyrSettingsB(0) && !JRMCoreH.PlyrSettingsB(6) && !JRMCoreH.PlyrSettingsB(11) && 
/*  688 */           skillLvl > 0) {
/*  689 */           if (action) {
/*  690 */             if (ps) { JRMCoreH.Skll((byte)6, (byte)16, (byte)1); }
/*      */             else
/*  692 */             { JRMCoreH.Skll((byte)6, (byte)16, (byte)0); }
/*      */           
/*      */           } else {
/*  695 */             String enable = JRMCoreH.trl("jrmc", opt1);
/*  696 */             String disable = JRMCoreH.trl("jrmc", opt2);
/*  697 */             return skllName + ": " + (ps ? ((black ? "" : "§2") + disable) : ((black ? "" : "§4") + enable));
/*      */           } 
/*      */         }
/*      */         
/*  701 */         if (skillLvl > 0 && !action) {
/*  702 */           return skllName + " is not useable, because " + (JRMCoreH.PlyrSettingsB(0) ? "Kaioken" : (
/*  703 */             JRMCoreH.PlyrSettingsB(6) ? "Mystic form" : "Ultra instinct")) + " is enabled!";
/*      */         }
/*  705 */         return "";
/*      */     } 
/*  707 */     return ""; }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int ItemWeightOn(ItemStack itemStack) {
/*  713 */     if (itemStack != null) {
/*  714 */       if (itemStack.func_77973_b() == ItemsDBC.ItemWeightShell) return 0; 
/*  715 */       if (itemStack.func_77973_b() == ItemsDBC.ItemWeightHandLeg) return 1; 
/*  716 */       if (itemStack.func_77973_b() == ItemsDBC.ItemWeightShirt) return 2; 
/*  717 */       if (itemStack.func_77973_b() == ItemsDBC.ItemWeightCape) return 3; 
/*  718 */       if (itemStack.func_77973_b() == ItemsDBC.ItemWeightHeavySuit) return 4; 
/*      */     } 
/*  720 */     return -1;
/*      */   }
/*      */   
/*  723 */   public static float gravityDev = 1.0F;
/*  724 */   public static float gravityDevCB = 0.0F;
/*      */ 
/*      */   
/*      */   public static float gravity(EntityPlayer player, float g) {
/*  728 */     float G = 1.0F;
/*  729 */     if (player.field_71093_bK == DBCConfig.otherWorld) {
/*  730 */       AxisAlignedBB ab = AxisAlignedBB.func_72330_a(DBCH.KPminX, DBCH.KPminY, DBCH.KPminZ, DBCH.KPmaxX, DBCH.KPmaxY, DBCH.KPmaxZ);
/*      */       
/*  732 */       if (ab.field_72336_d > player.field_70165_t && ab.field_72340_a < player.field_70165_t && ab.field_72337_e > player.field_70163_u && ab.field_72338_b < player.field_70163_u && ab.field_72334_f > player.field_70161_v && ab.field_72339_c < player.field_70161_v)
/*      */       {
/*  734 */         G = 10.0F;
/*      */       }
/*      */     } 
/*  737 */     if (player.field_71093_bK == DBCConfig.dimTimeChamber) {
/*  738 */       G = 10.0F;
/*      */     }
/*  740 */     G = (G < g) ? g : G;
/*  741 */     return G;
/*      */   }
/*      */   
/*      */   public static void openGui(int id, EntityPlayer pl) {
/*  745 */     pl.openGui(mod_DragonBC.instance, id, pl.field_70170_p, (int)pl.field_70165_t, (int)pl.field_70163_u, (int)pl.field_70161_v);
/*      */   }
/*      */   public static void onEventDrop(LivingDropsEvent event) {
/*  748 */     DBCH.onEventDrop(event);
/*      */   }
/*      */ 
/*      */   
/*  752 */   public static int dragonSum = 100;
/*      */   
/*      */   public static Block getMedBlock() {
/*  755 */     return BlocksDBC.BlockHealingPods;
/*      */   }
/*      */   public static void DBCDeath(EntityPlayer p) {
/*  758 */     DBCH.DBCDeath(p);
/*      */   }
/*      */   public static void DBSpawn(EntityPlayer p, long wt) {
/*  761 */     DBCH.DBSpawn(p, wt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void Dscndng(int i) {
/*  767 */     DBCKiTech.Dscndng(i);
/*      */   }
/*      */   public static void Dscndng() {
/*  770 */     DBCKiTech.Dscndng();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean DBCKiTechFly() {
/*  776 */     return DBCKiTech.floating;
/*      */   }
/*      */   
/*      */   public static void spawnSaibaimans(EntityPlayer player) {
/*  780 */     int i = MathHelper.func_76128_c(player.field_70165_t);
/*  781 */     int j = MathHelper.func_76128_c(player.field_70163_u);
/*  782 */     int k = MathHelper.func_76128_c(player.field_70161_v);
/*  783 */     int r = 30;
/*  784 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(i - r, 1.0D, k - r, i + r, 254.0D, k + r);
/*  785 */     List list = player.field_70170_p.func_72872_a(EntitySaibaiman.class, aabb);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  790 */     if (list.size() < 3) {
/*  791 */       EntitySaibaiman entitySaibaiman; Entity s = null;
/*  792 */       for (int l = 0; l < 3 - list.size(); l++) {
/*  793 */         for (int i1 = (j + 1 > 254) ? 254 : (j + 1); i1 > 50; i1--) {
/*  794 */           Random ran1 = new Random();
/*  795 */           int r1 = ran1.nextInt(10);
/*  796 */           Random ran2 = new Random();
/*  797 */           int r2 = ran1.nextInt(10);
/*  798 */           Block block = player.field_70170_p.func_147439_a(i - 5 + r1, i1, k - 5 + r2);
/*  799 */           if (block.func_149688_o() == Material.field_151579_a) {
/*  800 */             EntitySaibaiman sai1 = new EntitySaibaiman(player.field_70170_p);
/*  801 */             sai1.func_70012_b((i - 5 + r1), i1, (k - 5 + r2), 0.0F, 0.0F);
/*  802 */             sai1.setETA((Entity)player);
/*  803 */             sai1.settarget((Entity)player);
/*  804 */             sai1.setSpwner((Entity)player);
/*  805 */             player.field_70170_p.func_72838_d((Entity)sai1);
/*  806 */             entitySaibaiman = sai1;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*  812 */       if (entitySaibaiman != null) ((Entity)entitySaibaiman).field_70170_p.func_72956_a((Entity)player, "jinryuudragonbc:DBC3.teleport", 1.0F, 1.0F); 
/*      */     } 
/*      */   } public static void spawnFeezahenchmen(EntityPlayer player) {
/*  815 */     int i = MathHelper.func_76128_c(player.field_70165_t);
/*  816 */     int j = MathHelper.func_76128_c(player.field_70163_u);
/*  817 */     int k = MathHelper.func_76128_c(player.field_70161_v);
/*  818 */     int r = 30;
/*  819 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(i - r, 1.0D, k - r, i + r, 254.0D, k + r);
/*  820 */     List list = player.field_70170_p.func_72872_a(EntityFreezaSoldiers.class, aabb);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  825 */     if (list.size() < 2) {
/*  826 */       EntityFreezaSoldier1 entityFreezaSoldier1; Entity s = null;
/*      */       
/*  828 */       for (int i1 = (j + 1 > 254) ? 254 : (j + 1); i1 > 50; i1--) {
/*  829 */         Random ran1 = new Random();
/*  830 */         int r1 = ran1.nextInt(10);
/*  831 */         Random ran2 = new Random();
/*  832 */         int r2 = ran1.nextInt(10);
/*  833 */         Block block1 = player.field_70170_p.func_147439_a(i - 5 + r1, i1, k - 5 + r2);
/*  834 */         if (block1.func_149688_o() == Material.field_151579_a) {
/*  835 */           EntityFreezaSoldier1 men1 = new EntityFreezaSoldier1(player.field_70170_p);
/*  836 */           men1.func_70012_b((i - 5 + r1), i1, (k - 5 + r2), 0.0F, 0.0F);
/*  837 */           men1.func_70652_k((Entity)player);
/*  838 */           men1.setETA((Entity)player);
/*  839 */           men1.settarget((Entity)player);
/*  840 */           men1.setSpwner((Entity)player);
/*  841 */           player.field_70170_p.func_72838_d((Entity)men1);
/*  842 */           entityFreezaSoldier1 = men1;
/*      */         } 
/*      */         
/*  845 */         Block block2 = player.field_70170_p.func_147439_a(i - 5 + r1 + 1, i1, k - 5 + r2);
/*  846 */         if (block2.func_149688_o() == Material.field_151579_a) {
/*  847 */           EntityFreezaSoldier2 men2 = new EntityFreezaSoldier2(player.field_70170_p);
/*  848 */           men2.func_70012_b((i - 5 + r1 + 1), i1, (k - 5 + r2), 0.0F, 0.0F);
/*  849 */           men2.func_70652_k((Entity)player);
/*  850 */           men2.setETA((Entity)player);
/*  851 */           men2.settarget((Entity)player);
/*  852 */           men2.setSpwner((Entity)player);
/*  853 */           player.field_70170_p.func_72838_d((Entity)men2);
/*      */         } 
/*  855 */         Block block3 = player.field_70170_p.func_147439_a(i - 5 + r1 - 1, i1, k - 5 + r2);
/*  856 */         if (block3.func_149688_o() == Material.field_151579_a) {
/*  857 */           EntityFreezaSoldier3 men3 = new EntityFreezaSoldier3(player.field_70170_p);
/*  858 */           men3.func_70012_b((i - 5 + r1 - 1), i1, (k - 5 + r2), 0.0F, 0.0F);
/*  859 */           men3.func_70652_k((Entity)player);
/*  860 */           men3.setETA((Entity)player);
/*  861 */           men3.settarget((Entity)player);
/*  862 */           men3.setSpwner((Entity)player);
/*  863 */           player.field_70170_p.func_72838_d((Entity)men3);
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*  868 */       if (entityFreezaSoldier1 != null) ((Entity)entityFreezaSoldier1).field_70170_p.func_72956_a((Entity)player, "jinryuudragonbc:DBC3.teleport", 1.0F, 1.0F); 
/*      */     } 
/*      */   }
/*      */   public static List listEvilDBCnpcs(EntityPlayer player, AxisAlignedBB aabb) {
/*  872 */     return player.field_70170_p.func_72872_a(EntityDBCEvil.class, aabb);
/*      */   }
/*      */   
/*      */   public static void ifEvilDBCnpcs(Entity e, EntityPlayer p) {
/*  876 */     boolean b = e instanceof EntityDBCEvil;
/*  877 */     if (b) {
/*  878 */       e.func_70029_a(p.field_70170_p);
/*  879 */       ((EntityDBCEvil)e).setSpwner((Entity)p);
/*      */     } 
/*      */   }
/*      */   public static void ifEvilDBCnpcs(Entity e, Entity p) {
/*  883 */     boolean b = e instanceof EntityDBCEvil;
/*  884 */     boolean b2 = p instanceof EntityDBCEvil;
/*  885 */     if (b && b2) {
/*  886 */       e.func_70029_a(p.field_70170_p);
/*  887 */       ((EntityDBCEvil)e).setSpwner(((EntityDBCEvil)p).getSpwner());
/*  888 */       ((EntityDBCEvil)e).settarget(((EntityDBCEvil)p).gettarget());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean DBCTrainingArea(EntityPlayer thePlayer) {
/*  894 */     int nX = DBCH.KPminX, xX = DBCH.KPmaxX;
/*  895 */     int nY = DBCH.KPminY, xY = DBCH.KPmaxY;
/*  896 */     int nZ = DBCH.KPminZ, xZ = DBCH.KPmaxZ;
/*  897 */     int pX = (int)thePlayer.field_70165_t;
/*  898 */     int pY = (int)thePlayer.field_70163_u;
/*  899 */     int pZ = (int)thePlayer.field_70161_v;
/*  900 */     return (pX > nX && pX < xX && pY > nY && pY < xY && pZ > nZ && pZ < xZ);
/*      */   }
/*      */   public static void DBCreleaseZeroTurnOffTurbo() {
/*  903 */     if (JRMCoreH.curRelease == 0 && DBCKiTech.turbo) {
/*  904 */       DBCKiTech.turbo = false;
/*  905 */       JRMCoreH.Skll((byte)5, (byte)1, (byte)3);
/*      */     } 
/*      */   } public static float DBCsizeBasedOnCns(int[] plyrAttrbts) {
/*  908 */     float f1 = 0.0F;
/*  909 */     int c = plyrAttrbts[2], m = nRP9ea();
/*  910 */     if (mod_DragonBC.ConsSizeChangeOn) f1 += 0.192F * ((c > m) ? m : c) / m; 
/*  911 */     return f1;
/*      */   }
/*      */   public static float DBCsizeBasedOnCns2(int[] plyrAttrbts) {
/*  914 */     float f1 = 0.0F;
/*  915 */     int c = plyrAttrbts[2], m = nRP9ea();
/*  916 */     if (mod_DragonBC.ConsSizeChangeOn) { f1 += 0.192F * ((c > m) ? m : c) / m; } else { f1 += 0.2F; }
/*  917 */      return f1;
/*      */   } public static float DBCsizeBasedOnRace(int race, int state) {
/*  919 */     return DBCsizeBasedOnRace(race, state, false);
/*      */   } public static float DBCsizeBasedOnRace(int race, int state, boolean divine) {
/*  921 */     float f2 = 1.0F;
/*  922 */     if (JRMCoreH.rc_sai(race) && 
/*  923 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransSaiBlk.length > state) f2 = JRMCoreH.TransSaiBlk[state]; 
/*  924 */     if (JRMCoreH.rc_hum(race) && 
/*  925 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransHmBlk.length > state) f2 = JRMCoreH.TransHmBlk[state]; 
/*  926 */     if (JRMCoreH.rc_nam(race) && 
/*  927 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransNaBlk.length > state) {
/*  928 */       boolean ssg = godKiUserBase(race, state);
/*  929 */       if (ssg && divine) { f2 = 1.1F; }
/*  930 */       else { f2 = JRMCoreH.TransNaBlk[state]; }
/*      */     
/*      */     } 
/*  933 */     if (JRMCoreH.isRaceMajin(race) && 
/*  934 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransMaBulk.length > state) f2 = JRMCoreH.TransMaBulk[state]; 
/*  935 */     if (JRMCoreH.rc_arc(race) && 
/*  936 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransFrBlk.length > state) f2 = JRMCoreH.TransFrBlk[state]; 
/*  937 */     return f2;
/*      */   } public static float DBCsizeBasedOnRace2(int race, int state) {
/*  939 */     return DBCsizeBasedOnRace2(race, state, false);
/*      */   } public static float DBCsizeBasedOnRace2(int race, int state, boolean divine) {
/*  941 */     float f3 = 1.0F;
/*  942 */     if (JRMCoreH.rc_sai(race) && 
/*  943 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransSaiSz.length > state) f3 = JRMCoreH.TransSaiSz[state]; 
/*  944 */     if (JRMCoreH.rc_hum(race) && 
/*  945 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransHmSz.length > state) f3 = JRMCoreH.TransHmSz[state]; 
/*  946 */     if (JRMCoreH.rc_nam(race) && 
/*  947 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransNaSz.length > state) {
/*  948 */       boolean ssg = godKiUserBase(race, state);
/*  949 */       if (ssg && divine) { f3 = 1.5F; }
/*  950 */       else { f3 = JRMCoreH.TransNaSz[state]; }
/*      */     
/*      */     } 
/*  953 */     if (JRMCoreH.isRaceMajin(race) && 
/*  954 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransMaSize.length > state) f3 = JRMCoreH.TransMaSize[state]; 
/*  955 */     if (JRMCoreH.rc_arc(race) && 
/*  956 */       mod_DragonBC.TransSizeChangeOn && JRMCoreH.TransFrSz.length > state) f3 = JRMCoreH.TransFrSz[state]; 
/*  957 */     return f3;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean DBCboolPlyrDimNotOtherworld(EntityPlayerMP player) {
/*  962 */     return (player.field_71093_bK != otherworld());
/*      */   }
/*      */   public static boolean FreeRev() {
/*  965 */     return DBCConfig.FreeRev;
/*      */   }
/*      */   public static boolean FreeRevC() {
/*  968 */     return DBCConfig.cFreeRev;
/*      */   }
/*      */   public static void FreeRevSet(boolean i) {
/*  971 */     DBCConfig.FreeRev = i;
/*      */   }
/*      */   public static int otherworld() {
/*  974 */     return DBCConfig.otherWorld;
/*      */   }
/*      */   public static void WorldTper(MinecraftServer s, EntityPlayerMP p, int w) {
/*  977 */     s.func_71203_ab().transferPlayerToDimension(p, w, (Teleporter)WorldTper(s, w));
/*      */   }
/*      */   private static WorldTeleporterDBCTelep WorldTper(MinecraftServer s, int w) {
/*  980 */     return new WorldTeleporterDBCTelep(s.func_71218_a(w));
/*      */   }
/*      */   
/*      */   public static boolean isPlayerInNullRealmDimension(EntityPlayerMP player) {
/*  984 */     return (player.field_71093_bK == nullrealm());
/*      */   }
/*      */   public static int nullrealm() {
/*  987 */     return DBCConfig.dimNullRealm;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean DBCgetConfigGodformCosm() {
/*  992 */     return DBCConfig.GodformCosm;
/*      */   }
/*      */   public static boolean DBCgetConfigGodform() {
/*  995 */     return DBCConfig.Godform;
/*      */   }
/*      */   public static boolean DBCgetConfigcGodform() {
/*  998 */     return DBCConfig.cGodform;
/*      */   }
/*      */   public static void DBCsetConfigGodform(boolean i) {
/* 1001 */     DBCConfig.Godform = i;
/*      */   }
/*      */   public static int DBCgetConfigcsenzuCool() {
/* 1004 */     return DBCConfig.csenzuCool;
/*      */   }
/*      */   public static void DBCsetConfigsenzuCool(int i) {
/* 1007 */     DBCConfig.senzuCool = i;
/*      */   }
/*      */   public static int DBCgetConfigcmaxTrnExp() {
/* 1010 */     return DBCConfig.cmaxTrnExp;
/*      */   }
/*      */   public static boolean DBCgetConfigcplntVegeta() {
/* 1013 */     return DBCConfig.cplntVegeta;
/*      */   }
/*      */   public static boolean DBCgetConfigcflyAnyLvl() {
/* 1016 */     return DBCConfig.cflyAnyLvl;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean DBCgetConfigcDeathSystemOff() {
/* 1022 */     return mod_DragonBC.cDeathSystemOff;
/*      */   }
/*      */   public static boolean DBCgetConfigcDBSpawnEnabled() {
/* 1025 */     return mod_DragonBC.cDBSpawnEnabled;
/*      */   }
/*      */   public static String DBCgetConfigcDBSpawnTime() {
/* 1028 */     return mod_DragonBC.cDBSpawnTime;
/*      */   }
/*      */   public static boolean DBCgetConfigcSagaSystemOn() {
/* 1031 */     return mod_DragonBC.cSagaSystemOn;
/*      */   }
/*      */   public static boolean DBCgetConfigcSagaSysSpawnPods() {
/* 1034 */     return mod_DragonBC.cSagaSysSpawnPods;
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
/*      */   public static void DBCsetConfigmaxTrnExp(int maxTrnExp) {
/* 1046 */     DBCConfig.maxTrnExp = maxTrnExp;
/*      */   }
/*      */   public static void DBCsetConfigplntVegeta(boolean plntVegeta) {
/* 1049 */     DBCConfig.plntVegeta = plntVegeta;
/*      */   }
/*      */   public static void DBCsetConfigflyAnyLvl(boolean flyAnyLvl) {
/* 1052 */     DBCConfig.flyAnyLvl = flyAnyLvl;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void DBCsetConfigDeathSystemOff(boolean DeathSystemOff) {
/* 1058 */     mod_DragonBC.DeathSystemOff = DeathSystemOff;
/*      */   }
/*      */   public static void DBCsetConfigDBSpawnEnabled(boolean DBSpawnEnabled) {
/* 1061 */     mod_DragonBC.DBSpawnEnabled = DBSpawnEnabled;
/*      */   }
/*      */   public static void DBCsetConfigDBSpawnTime(String DBSpawnTime) {
/* 1064 */     mod_DragonBC.DBSpawnTime = DBSpawnTime;
/*      */   }
/*      */   public static void DBCsetConfigDBSagaSystemOn(boolean SagaSystemOn) {
/* 1067 */     mod_DragonBC.SagaSystemOn = SagaSystemOn;
/*      */   }
/*      */   public static void DBCsetConfigDBSagaSysSpawnPods(boolean SagaSysSpawnPods) {
/* 1070 */     mod_DragonBC.SagaSysSpawnPods = SagaSysSpawnPods;
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
/*      */   public static Block DBCgetBlockTCPort() {
/* 1082 */     return BlocksDBC.BlockTCPort;
/*      */   }
/*      */   public static boolean DBCgetSagaSystemOn() {
/* 1085 */     return mod_DragonBC.SagaSystemOn;
/*      */   }
/*      */   public static boolean DBCgetConfigplntVegeta() {
/* 1088 */     return DBCConfig.plntVegeta;
/*      */   }
/*      */   public static boolean DBCgetConfigflyAnyLvl() {
/* 1091 */     return DBCConfig.flyAnyLvl;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int DBCgetConfigeDBrate() {
/* 1097 */     return DBCConfig.eDBrate;
/*      */   }
/*      */   public static int DBCgetConfignDBrate() {
/* 1100 */     return DBCConfig.nDBrate;
/*      */   }
/*      */   public static boolean DBCgetConfigDeathSystemOff() {
/* 1103 */     return mod_DragonBC.DeathSystemOff;
/*      */   }
/*      */   public static boolean DBCgetConfigDBSpawnEnabled() {
/* 1106 */     return mod_DragonBC.DBSpawnEnabled;
/*      */   }
/*      */   public static String DBCgetConfigDBSpawnTime() {
/* 1109 */     return mod_DragonBC.DBSpawnTime;
/*      */   }
/*      */   public static boolean DBCgetConfigSagaSystemOn() {
/* 1112 */     return mod_DragonBC.SagaSystemOn;
/*      */   }
/*      */   public static boolean DBCgetConfigDeadInv() {
/* 1115 */     return DBCConfig.DeadInv;
/*      */   }
/*      */   public static void DBCsetConfigDeadInv(boolean i) {
/* 1118 */     DBCConfig.DeadInv = i;
/*      */   }
/*      */   public static float DBCgetConfigReinc() {
/* 1121 */     return DBCConfig.Reinc;
/*      */   }
/*      */   public static float DBCgetConfigcReinc() {
/* 1124 */     return DBCConfig.cReinc;
/*      */   }
/*      */   public static void DBCsetConfigReinc(float i) {
/* 1127 */     DBCConfig.Reinc = i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean DBCgetEntityDBC(Entity shootingEntity) {
/* 1137 */     return shootingEntity instanceof JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*      */   }
/*      */   public static int DBCgetConfigcwfb() {
/* 1140 */     return mod_DragonBC.cwfb;
/*      */   }
/*      */   public static int DBCgetConfigchfb() {
/* 1143 */     return mod_DragonBC.chfb;
/*      */   }
/*      */   public static int DBCgetConfigcwfn() {
/* 1146 */     return mod_DragonBC.cwfn;
/*      */   }
/*      */   public static int DBCgetConfigchfn() {
/* 1149 */     return mod_DragonBC.chfn;
/*      */   }
/*      */   public static int DBCgetConfighealingpodhealingrate() {
/* 1152 */     return DBCConfig.healingpodhealingrate;
/*      */   }
/*      */   public static boolean DBCgetConfigDBGT() {
/* 1155 */     return DBCConfig.DBGT;
/*      */   }
/*      */   
/*      */   public static int DBCgetConfighPodUpd()
/*      */   {
/* 1160 */     return DBCConfig.hPodUpd;
/* 1161 */   } public static int DBCgetConfighPodRate(int id) { return DBCConfig.hPodRate[id]; } public static boolean DBCgetConfighPodPerc(int id) {
/* 1162 */     return DBCConfig.hPodPerc[id];
/*      */   }
/*      */ 
/*      */   
/*      */   public static int[][] npc_ps() {
/* 1167 */     int[] Kmhs = new int[3]; if (DBCH.genKH.contains(";")) for (int i = 0; i < 3; ) { Kmhs[i] = Integer.parseInt(DBCH.genKH.split(";")[i]) + DBCH.genKHnpc1[i]; i++; }
/* 1168 */         int[] ClAr = new int[3]; if (DBCH.genCA.contains(";")) for (int i = 0; i < 3; ) { ClAr[i] = Integer.parseInt(DBCH.genCA.split(";")[i]) + DBCH.genCAnpc1[i]; i++; }
/* 1169 */         int[] Gkhs = new int[3]; if (DBCH.genGH.contains(";")) for (int i = 0; i < 3; ) { Gkhs[i] = Integer.parseInt(DBCH.genGH.split(";")[i]) + DBCH.genGHnpc1[i]; i++; }
/* 1170 */         int[] Gkhs2 = new int[3]; if (DBCH.genGH.contains(";")) for (int i = 0; i < 3; ) { Gkhs2[i] = Integer.parseInt(DBCH.genGH.split(";")[i]) + DBCH.genGHnpc2[i]; i++; }
/* 1171 */         int[] FzSp = new int[3]; if (DBCH.genFS.contains(";")) for (int i = 0; i < 3; ) { FzSp[i] = Integer.parseInt(DBCH.genFS.split(";")[i]) + DBCH.genFSnpc1[i]; i++; }
/* 1172 */         int[] BS = new int[3]; if (DBCH.genBS.contains(";")) for (int i = 0; i < 3; ) { BS[i] = Integer.parseInt(DBCH.genBS.split(";")[i]) + DBCH.genBSnpc1[i]; i++; }
/* 1173 */         int[] GURU = new int[3]; if (DBCH.genGuru.contains(";")) for (int i = 0; i < 3; ) { GURU[i] = Integer.parseInt(DBCH.genGuru.split(";")[i]) + DBCH.genGurunpc1[i]; i++; }
/*      */     
/*      */     
/* 1176 */     int[][] ps = new int[15][];
/* 1177 */     ps[0] = Kmhs;
/* 1178 */     ps[1] = DBCH.Kami;
/* 1179 */     ps[2] = DBCH.Karn;
/* 1180 */     ps[3] = DBCH.Enma;
/* 1181 */     ps[4] = DBCH.KaiO;
/* 1182 */     ps[5] = ClAr;
/* 1183 */     ps[6] = Gkhs;
/* 1184 */     ps[7] = Gkhs2;
/* 1185 */     ps[8] = FzSp;
/* 1186 */     ps[9] = BS;
/* 1187 */     ps[10] = DBCH.TrnksF;
/* 1188 */     ps[11] = DBCH.Jin;
/* 1189 */     ps[12] = GURU;
/* 1190 */     ps[13] = DBCH.Whis1;
/* 1191 */     ps[14] = DBCH.Whis2;
/* 1192 */     return ps;
/*      */   }
/*      */   public static EntityDBCKami[] npc_ent(World w) {
/* 1195 */     EntityDBCKami[] ent = { (EntityDBCKami)new EntityMasterRoshi(w), (EntityDBCKami)new EntityMasterKami(w), (EntityDBCKami)new EntityMasterKarin(w), (EntityDBCKami)new EntityMasterEnma(w), (EntityDBCKami)new EntityMasterKaio(w), (EntityDBCKami)new EntityMasterCell(w), (EntityDBCKami)new EntityMasterGoku(w), (EntityDBCKami)new EntityMasterGohan(w), (EntityDBCKami)new EntityMasterFreeza(w), (EntityDBCKami)new EntityMasterBabidi(w), (EntityDBCKami)new EntityMasterTrunksFuture(w), (EntityDBCKami)new EntityMasterJin(w), (EntityDBCKami)new EntityMasterGuru(w), (EntityDBCKami)new EntityMasterWhis(w), (EntityDBCKami)new EntityMasterWhis(w) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1212 */     return ent;
/*      */   }
/*      */   public static Class[] npc_entclss() {
/* 1215 */     Class[] entclss = { EntityMasterRoshi.class, EntityMasterKami.class, EntityMasterKarin.class, EntityMasterEnma.class, EntityMasterKaio.class, EntityMasterCell.class, EntityMasterGoku.class, EntityMasterGohan.class, EntityMasterFreeza.class, EntityMasterBabidi.class, EntityMasterTrunksFuture.class, EntityMasterJin.class, EntityMasterGuru.class, EntityMasterWhis.class, EntityMasterWhis.class };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1232 */     return entclss;
/*      */   }
/*      */   public static int[] npc_dims() {
/* 1235 */     int[] dims = { 0, 0, 0, DBCConfig.otherWorld, DBCConfig.otherWorld, 0, 0, 0, DBCConfig.planetNamek, 0, 0, DBCConfig.otherWorld, DBCConfig.planetNamek, 0, DBCConfig.dimNullRealm };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1252 */     return dims;
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
/*      */   public static boolean[] npc_spawn() {
/* 1268 */     boolean[] spawn = { DBCH.genKH.contains(";"), true, true, true, true, DBCH.genCA.contains(";"), DBCH.genGH.contains(";"), DBCH.genGH.contains(";"), DBCH.genFS.contains(";"), DBCH.genBS.contains(";"), true, true, DBCH.genGuru.contains(";"), true, true };
/*      */ 
/*      */ 
/*      */     
/* 1272 */     return spawn;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void DBCCommonTickHandlerNPCSpawnCheck(EntityPlayerMP player) {
/* 1278 */     if (JRMCoreConfig.NPCSpawnCheck) {
/* 1279 */       int[][] ps = npc_ps();
/* 1280 */       EntityDBCKami[] ent = npc_ent(player.field_70170_p);
/* 1281 */       Class[] entclss = npc_entclss();
/* 1282 */       int[] dims = npc_dims();
/* 1283 */       boolean[] spawn = npc_spawn();
/*      */       
/* 1285 */       for (int i = 0; i < ps.length; i++) {
/*      */         
/* 1287 */         int[] npc = ps[i];
/* 1288 */         if (dims[i] == player.field_71093_bK && 
/* 1289 */           npc.length > 2) {
/* 1290 */           int a = 2;
/* 1291 */           AxisAlignedBB ab = AxisAlignedBB.func_72330_a((npc[0] - a), (npc[1] - a), (npc[2] - a), (npc[0] + a), (npc[1] + a), (npc[2] + a));
/* 1292 */           List enma = player.field_70170_p.func_72872_a(entclss[i], ab);
/* 1293 */           if (enma.isEmpty() && spawn[i]) {
/* 1294 */             EntityDBCKami en = ent[i];
/* 1295 */             en.func_70012_b(npc[0], npc[1], npc[2], 0.0F, 0.0F);
/* 1296 */             player.field_70170_p.func_72838_d((Entity)en);
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
/*      */   public static void DBCCommonTickHandlerWorldGenBuildingsResetted(MinecraftServer server) {
/* 1310 */     if (JRMCoreH.DBCresetted) { JRMCoreH.DBCresetted = false;
/* 1311 */       WorldGenBuildingsSpawnCheck(server); }
/*      */   
/*      */   }
/*      */   public static void WorldGenBuildingsSpawnCheck(MinecraftServer server) {
/* 1315 */     DBCH.genKH = DBCH.khrwi(server);
/* 1316 */     DBCH.genCA = DBCH.carwi(server);
/* 1317 */     DBCH.genGH = DBCH.ghrwi(server);
/* 1318 */     DBCH.genFS = DBCH.fsrwi(server);
/* 1319 */     DBCH.genBS = DBCH.bsrwi(server);
/* 1320 */     DBCH.genGuru = DBCH.guruhrwi(server);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void spawnBuilds(MinecraftServer server) {
/* 1328 */     JRMCoreSafe safe = new JRMCoreSafe(server.func_130014_f_());
/* 1329 */     safe.saveSpawnList("false ", safe.OWDataDir, "edp.dbc");
/* 1330 */     safe.saveSpawnList("false ", safe.OWDataDir, "swk.dbc");
/* 1331 */     safe.saveSpawnList("false ", safe.dataDir, "kl.dbc");
/*      */     
/* 1333 */     WorldGenBuildingsSpawnCheck(server);
/*      */ 
/*      */     
/* 1336 */     int[] ClAr = new int[3]; if (DBCH.genCA.contains(";")) for (int j = 0; j < 3; ) { ClAr[j] = Integer.parseInt(DBCH.genCA.split(";")[j]); j++; }
/* 1337 */         int[] Gkhs = new int[3]; if (DBCH.genGH.contains(";")) for (int j = 0; j < 3; ) { Gkhs[j] = Integer.parseInt(DBCH.genGH.split(";")[j]); j++; }
/* 1338 */         int[] FzSp = new int[3]; if (DBCH.genFS.contains(";")) for (int j = 0; j < 3; ) { FzSp[j] = Integer.parseInt(DBCH.genFS.split(";")[j]); j++; }
/* 1339 */         int[] BS = new int[3]; if (DBCH.genBS.contains(";")) for (int j = 0; j < 3; ) { BS[j] = Integer.parseInt(DBCH.genBS.split(";")[j]); j++; }
/* 1340 */         int[] GURU = new int[3]; if (DBCH.genGuru.contains(";")) for (int j = 0; j < 3; ) { GURU[j] = Integer.parseInt(DBCH.genGuru.split(";")[j]); j++; }
/*      */        
/* 1342 */     int[][] ps = new int[5][];
/* 1343 */     ps[0] = ClAr;
/* 1344 */     ps[1] = Gkhs;
/* 1345 */     ps[2] = FzSp;
/* 1346 */     ps[3] = BS;
/* 1347 */     ps[4] = GURU;
/*      */     
/* 1349 */     for (int i = 0; i < ps.length; i++) {
/* 1350 */       int[] npc = ps[i];
/*      */       
/* 1352 */       if (!(server.func_71218_a(WorldGeneratorDB.DBbuildsdim[i])).field_72995_K && 
/* 1353 */         npc.length > 2) {
/* 1354 */         builds v = WorldGeneratorDB.DBbuilds[i];
/* 1355 */         WorldServer worldServer = server.func_71218_a(WorldGeneratorDB.DBbuildsdim[i]);
/* 1356 */         v.setWorld((World)worldServer);
/*      */         
/* 1358 */         if (npc[0] != 0 || npc[1] != 0 || npc[2] != 0)
/*      */         {
/* 1360 */           if (!JRMCoreComTickH.bs.contains(WorldGeneratorDB.DBbuildsNams2(i))) {
/* 1361 */             v.func_76484_a((World)worldServer, ((World)worldServer).field_73012_v, npc[0], npc[1], npc[2]);
/*      */           }
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static int d5keKm(String l) {
/*      */     String w;
/*      */     int a;
/*      */     int i;
/* 1372 */     for (w = "0123456789ABCDEF", l = l.toUpperCase(), a = 0, i = 0; i < l.length(); ) { char c = l.charAt(i); int d = w.indexOf(c); a = 16 * a + d; i++; }  return a;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int nRP9ea() {
/* 1377 */     int b = JRMCoreConfig.tmx; String r = "64", k = "3B9ACA00"; return (b > d5keKm(k)) ? d5keKm(k) : ((b < d5keKm(r)) ? 0 : b);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void JRMCoreEHonPlayerInteract(PlayerInteractEvent event) {
/* 1383 */     EntityPlayer p = event.entityPlayer;
/* 1384 */     int x = event.x;
/* 1385 */     int y = event.y;
/* 1386 */     int z = event.z;
/*      */     
/* 1388 */     int length = JRMCoreEH.allSafeZones.size();
/* 1389 */     for (int i = length - 1; i >= 0; i--) {
/* 1390 */       EntitySafeZone sz = JRMCoreEH.allSafeZones.get(i);
/* 1391 */       if (sz == null || sz.field_70128_L) {
/*      */         
/* 1393 */         JRMCoreEH.allSafeZones.remove(i);
/*      */       }
/* 1395 */       else if (sz.field_71093_bK == p.field_71093_bK) {
/*      */         
/* 1397 */         AxisAlignedBB ab = sz.createSafeZoneHitBox();
/*      */         
/* 1399 */         if (ab.field_72340_a < x && x < ab.field_72336_d && ab.field_72338_b < y && y < ab.field_72337_e && ab.field_72339_c < z && z < ab.field_72334_f) {
/* 1400 */           Block block = p.field_70170_p.func_147439_a(x, y, z);
/* 1401 */           boolean door = false;
/*      */           
/* 1403 */           if (JRMCoreConfig.sfzna != null) {
/* 1404 */             for (int j = 0; j < JRMCoreConfig.sfzna.length; j++) {
/* 1405 */               if (block == Block.func_149684_b(JRMCoreConfig.sfzna[j])) {
/* 1406 */                 door = true;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           }
/* 1412 */           if ((block != null && !door && event.isCancelable()) || (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK && block != null && door)) {
/* 1413 */             event.setCanceled(true);
/*      */             return;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean JRMCoreEHonLivingHurtSafeZone(EntityLivingBase targetEntity) {
/* 1455 */     if (targetEntity instanceof EntityPlayer) {
/*      */ 
/*      */ 
/*      */       
/* 1459 */       EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
/* 1460 */       int x = (int)targetEntity.field_70165_t;
/* 1461 */       int y = (int)targetEntity.field_70163_u;
/* 1462 */       int z = (int)targetEntity.field_70161_v;
/*      */       
/* 1464 */       int length = JRMCoreEH.allSafeZones.size();
/* 1465 */       for (int i = length - 1; i >= 0; i--) {
/* 1466 */         EntitySafeZone sz = JRMCoreEH.allSafeZones.get(i);
/* 1467 */         if (sz == null || sz.field_70128_L) {
/*      */           
/* 1469 */           JRMCoreEH.allSafeZones.remove(i);
/*      */         }
/* 1471 */         else if (sz.field_71093_bK == targetPlayer.field_71093_bK) {
/*      */           
/* 1473 */           AxisAlignedBB ab = sz.createSafeZoneHitBox();
/*      */           
/* 1475 */           if (ab.field_72340_a < x && x < ab.field_72336_d && ab.field_72338_b < y && y < ab.field_72337_e && ab.field_72339_c < z && z < ab.field_72334_f)
/*      */           {
/*      */ 
/*      */             
/* 1479 */             return true;
/*      */           }
/*      */         } 
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
/* 1510 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean checkForBuildsAound(World world, int RPX, int RPZ, int s) {
/* 1515 */     WorldGenBuildingsSpawnCheck(FMLCommonHandler.instance().getMinecraftServerInstance());
/*      */     
/* 1517 */     s = s + 50 + ((world.field_73011_w.field_76574_g == 22) ? 20 : 0);
/* 1518 */     boolean bo = true;
/*      */     
/* 1520 */     int[][] ps = npc_ps();
/* 1521 */     int[] dims = npc_dims();
/*      */     
/* 1523 */     for (int i = 0; i < ps.length; i++) {
/* 1524 */       int[] npc = ps[i];
/* 1525 */       if (dims[i] == world.field_73011_w.field_76574_g && 
/* 1526 */         npc.length > 2) {
/* 1527 */         double genX = npc[0];
/* 1528 */         double genY = npc[1];
/* 1529 */         double genZ = npc[2];
/* 1530 */         AxisAlignedBB ab = AxisAlignedBB.func_72330_a(RPX - s, 65.0D, RPZ - s, RPX + s, 100.0D, RPZ + s);
/* 1531 */         AxisAlignedBB ab2 = AxisAlignedBB.func_72330_a(genX - s, 65.0D, genZ - s, genX + s, 100.0D, genZ + s);
/* 1532 */         if (ab.func_72326_a(ab2)) bo = false;
/*      */       
/*      */       } 
/*      */     } 
/* 1536 */     return bo;
/*      */   }
/*      */   
/* 1539 */   public static boolean hasHalo(EntityPlayer p) { return (JRMCoreH.getByte(p, "jrmcAlv") == 1); } public static boolean isAlive(EntityPlayer p) {
/* 1540 */     return (JRMCoreH.getByte(p, "jrmcAlv") == 0);
/*      */   }
/* 1542 */   public static int DBCgetConfigTechExpRate() { return DBCConfig.TechExpRate; }
/* 1543 */   public static int DBCgetConfigTechExpNeed() { return DBCConfig.TechExpNeed; }
/* 1544 */   public static int DBCgetConfigTechCostMod() { return DBCConfig.TechCostMod; }
/* 1545 */   public static int DBCgetConfigcTechExpNeed() { return DBCConfig.cTechExpNeed; }
/* 1546 */   public static int DBCgetConfigcTechCostMod() { return DBCConfig.cTechCostMod; }
/* 1547 */   public static void DBCsetConfigTechExpNeed(int i) { DBCConfig.TechExpNeed = i; } public static void DBCsetConfigTechCostMod(int i) {
/* 1548 */     DBCConfig.TechCostMod = i;
/*      */   }
/*      */   
/*      */   public static void reincarnate(EntityPlayer p) {
/* 1552 */     if (!JRMCoreH.isFused((Entity)p)) {
/*      */       
/* 1554 */       JRMCoreH.setInt(1, p, "jrmcRencrnt");
/* 1555 */       for (int j = 0; j < 6; j++) {
/* 1556 */         int i = (int)(JRMCoreH.getInt(p, JRMCoreH.AttrbtNbtI[j]) * DBCConfig.Reinc);
/* 1557 */         JRMCoreH.setInt(i, p, JRMCoreH.AttrbtNbtR[j]);
/*      */       } 
/* 1559 */       JRMCoreH.resetChar(p);
/*      */       
/* 1561 */       if (DBCgetConfigDeadInv() && p.field_70170_p.func_82736_K().func_82766_b("keepInventory") && !p.field_71075_bZ.field_75098_d && 
/* 1562 */         JRMCoreH.getByte(p, "jrmcAlv") == 1) {
/* 1563 */         JRMCoreH.nbt(p).func_74782_a("InventoryDead", (NBTBase)p.field_71071_by.func_70442_a(new NBTTagList()));
/*      */         
/* 1565 */         p.field_71071_by.func_70443_b(JRMCoreH.nbt(p).func_150295_c("InventoryLiving", 10));
/* 1566 */         p.getEntityData().func_74782_a("Inventory", (NBTBase)p.field_71071_by.func_70442_a(new NBTTagList()));
/*      */       } 
/*      */ 
/*      */       
/* 1570 */       JRMCoreH.setByte(0, p, "jrmcAlv");
/* 1571 */       if (p.field_71093_bK != DBCConfig.planetEarth) {
/* 1572 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)p, DBCConfig.planetEarth, (Teleporter)new WorldTeleporterDBCTelep(FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(DBCConfig.planetEarth)));
/* 1573 */         p.func_71023_q(1);
/*      */         
/* 1575 */         double[] d = DBCConfig.RevLocG;
/* 1576 */         byte by = 0;
/* 1577 */         ((EntityPlayerMP)p).field_71135_a.func_147364_a(d[0], d[1], d[2], (float)DBCConfig.RevAng[0][0], (float)DBCConfig.RevAng[0][1]);
/* 1578 */         ((EntityPlayerMP)p).field_71135_a.func_147364_a(d[0], d[1] + 1.0D, d[2], (float)DBCConfig.RevAng[0][0], (float)DBCConfig.RevAng[0][1]);
/*      */       } 
/*      */     } 
/*      */   }
/* 1582 */   public static String[] ar = new String[] { "a", "i", "u", "e", "o" }; public static String f_namgen(String s1, String s2) {
/* 1583 */     return s1.substring(0, s1.length() / 2) + s2.substring(s2.length() / 2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void requestNullRealmKnockout() {
/* 1588 */     PD.sendToServer((IMessage)new DBCPwish(7, ""));
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreHDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */