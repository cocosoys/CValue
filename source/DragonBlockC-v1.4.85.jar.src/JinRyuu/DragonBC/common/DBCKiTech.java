/*      */ package JinRyuu.DragonBC.common;
/*      */ 
/*      */ import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityAura2;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityAuraRing;
/*      */ import JinRyuu.JRMCore.JRMCoreCliTicH;
/*      */ import JinRyuu.JRMCore.JRMCoreClient;
/*      */ import JinRyuu.JRMCore.JRMCoreConfig;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*      */ import JinRyuu.JRMCore.JRMCoreKeyHandler;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPascend;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPascendsound;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPchargesound;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPdescend;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPdescendsound;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPduo;
/*      */ import JinRyuu.JRMCore.p.DBC.DBCPenergy;
/*      */ import JinRyuu.JRMCore.p.JRMCorePTri;
/*      */ import JinRyuu.JRMCore.p.PD;
/*      */ import JinRyuu.JRMCore.server.JGMathHelper;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*      */ import java.time.Duration;
/*      */ import java.time.Instant;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.client.multiplayer.WorldClient;
/*      */ import net.minecraft.client.settings.KeyBinding;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DBCKiTech
/*      */ {
/*   46 */   public static int ascend = 0;
/*   47 */   public static int pup = 0;
/*   48 */   public static int pup2 = 0;
/*   49 */   public static int ptime = 0;
/*   50 */   public static int inSuperTime = 0;
/*      */   
/*   52 */   private static int time = 0;
/*   53 */   private static int time2 = 0;
/*   54 */   private static int time3 = 0;
/*   55 */   private static int partnorm = 0;
/*   56 */   private static int power = 0;
/*      */   
/*      */   private static int jump;
/*      */   
/*      */   public static boolean jumping = false;
/*      */   
/*      */   public static boolean jumpRel = false;
/*      */   
/*      */   public static boolean floating = false;
/*      */   public static boolean releasing = false;
/*      */   public static boolean ascending = false;
/*      */   public static boolean ascendingK = false;
/*   68 */   private static float sec = 0.0F;
/*      */   
/*      */   private static boolean jumpToFly = false;
/*      */   
/*      */   private static Instant quickTransformTimer;
/*   73 */   private static int quickTransformCount = 0;
/*      */   
/*      */   private static boolean quickTransformAdded = false;
/*      */   private static Instant singleDescendTimer;
/*   77 */   private static int singleDescendCount = 0;
/*      */ 
/*      */   
/*      */   private static boolean singleDescendAdded = false;
/*      */   
/*      */   private static Instant holdingTransformTimer;
/*      */   
/*      */   private static boolean holdingForTransform = false;
/*      */   
/*      */   private static boolean sentAbsorption = false;
/*      */ 
/*      */   
/*      */   public static void ChargeKi() {
/*   90 */     partnorm++;
/*   91 */     if (partnorm >= 5) {
/*   92 */       partnorm = 0;
/*   93 */       chargePart(false);
/*      */     } 
/*   95 */     power++;
/*   96 */     if (power >= (int)((JRMCoreH.State == 10 && JRMCoreH.State2 > 0) ? (JRMCoreCliTicH.counterValue * 3.0F) : (JRMCoreCliTicH.counterValue * 2.5F))) {
/*   97 */       power = 0;
/*   98 */       chargePart(true);
/*      */     } 
/*      */ 
/*      */     
/*  102 */     boolean b = (isPressed(JRMCoreKeyHandler.KiCharge) && !isPressed(JRMCoreKeyHandler.KiAscend) && !JRMCoreH.StusEfctsMe(11));
/*      */ 
/*      */     
/*  105 */     if (b)
/*      */     
/*  107 */     { if (!releasing) { releasing = true; JRMCoreH.Skll((byte)5, (byte)0, (byte)4);
/*      */          }
/*      */       
/*      */        }
/*      */     
/*  112 */     else if (releasing) { releasing = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)4); }
/*      */ 
/*      */ 
/*      */     
/*  116 */     if (b) {
/*      */ 
/*      */       
/*  119 */       time++;
/*  120 */       time2++;
/*  121 */       time3++;
/*  122 */       if (isPressed(JRMCoreKeyHandler.Fn) && ((JRMCoreH.Race != 0 && JRMCoreH.Race != 3) || JRMCoreH.State <= 0))
/*  123 */       { if (time3 >= 10) {
/*  124 */           time3 = 0;
/*  125 */           JRMCoreH.Rls((byte)2);
/*      */         }
/*      */          }
/*  128 */       else if (JRMCoreH.curRelease < 50 + JRMCoreH.SklLvl(5, (byte)1) * 5) { if (time >= ((JRMCoreH.curRelease >= 50) ? (turbo ? 15 : 30) : (turbo ? 5 : 10))) {
/*  129 */           time = 0;
/*  130 */           float en = 100.0F / JRMCoreH.maxEnergy * JRMCoreH.curEnergy;
/*  131 */           float re = JRMCoreH.curRelease;
/*  132 */           en = (en > 75.0F) ? 75.0F : en;
/*  133 */           if ((re >= 50.0F) ? (re - 50.0F < (en - 50.0F) * 2.0F) : (re < ((en <= 10.0F) ? (en * 5.0F) : 50.0F))) {
/*  134 */             JRMCoreH.Rls((byte)1);
/*      */           }
/*      */         }  }
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void JumpKi(KeyBinding keyBindJump) {
/*  142 */     EntityClientPlayerMP entityClientPlayerMP = DBCClient.mc.field_71439_g;
/*  143 */     float t = turbo ? 1.0F : 0.8F;
/*  144 */     float n = JRMCoreH.SklLvl(1, (byte)1);
/*      */     
/*  146 */     float max = 0.22F;
/*  147 */     float prc = 0.3F + 0.05F * n + (JRMCoreH.PlyrAttrbts(null)[1] / gYZc2f()) * 0.2F;
/*  148 */     float rel = JRMCoreH.curRelease * 0.01F;
/*      */ 
/*      */     
/*  151 */     float add = max * prc * t * rel;
/*      */ 
/*      */     
/*  154 */     int cost = 1 + (int)(add * 30.0F);
/*  155 */     boolean able = true;
/*      */     
/*  157 */     if (JRMCoreH.curEnergy < cost) {
/*  158 */       able = false;
/*      */     }
/*      */     
/*  161 */     boolean relStp = JRMCoreConfig.releaseStop ? (!releasing) : true;
/*  162 */     if (isPressed(keyBindJump) && !relStp) {
/*  163 */       KeyBinding.func_74510_a(keyBindJump.func_151463_i(), false);
/*  164 */       if (JRMCoreClient.mc.field_71439_g.field_70181_x > 0.0D) {
/*  165 */         JRMCoreClient.mc.field_71439_g.field_70181_x = 0.0D;
/*      */       }
/*      */     } 
/*  168 */     if (isPressed(keyBindJump) && relStp && !jumpRel && able) {
/*  169 */       jumping = true;
/*  170 */       if (jump >= 10) {
/*  171 */         jumping = false;
/*      */       }
/*  173 */       if (jump >= 1 && jump < 10 && jump / 5 * 5 == jump) {
/*  174 */         JRMCoreH.Cost(cost);
/*      */       }
/*  176 */       if (jumping)
/*  177 */         DBCClient.mc.field_71439_g.field_70181_x += 0.05D + add; 
/*      */     } else {
/*  179 */       jumpRel = true;
/*  180 */     }  if (!jumpRel && !floating) {
/*  181 */       jump++;
/*  182 */       if (jump == 4) {
/*  183 */         JRMCoreH.KAsounds((Entity)entityClientPlayerMP, 0);
/*      */       }
/*      */     } 
/*  186 */     if (((EntityPlayer)entityClientPlayerMP).field_70122_E) {
/*  187 */       jump = 0;
/*  188 */       jumpRel = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*  193 */   public static float flyY = 0.0F;
/*  194 */   public static int floatTime = 0;
/*      */   public static boolean floatMultAdded = false; private static boolean dodge_forwDash_STE; private static float sent; public static final int SWOOP_FORWARD = 0; public static final int SWOOP_LEFT = 1;
/*      */   public static final int SWOOP_BACK = 2;
/*      */   public static final int SWOOP_RIGHT = 3;
/*      */   
/*  199 */   public static long dtap1() { return System.currentTimeMillis() + 50L; } public static long dtap4() {
/*  200 */     return System.currentTimeMillis() + 250L;
/*      */   }
/*      */   
/*  203 */   public static int swoopDirection = -1;
/*      */ 
/*      */ 
/*      */   
/*      */   public static void FloatKi(KeyBinding kiFlight, KeyBinding keyBindJump, KeyBinding keyBindSneak) {
/*  208 */     EntityClientPlayerMP entityClientPlayerMP = DBCClient.mc.field_71439_g;
/*      */     
/*  210 */     int n = JRMCoreH.SklLvl(3, (byte)1);
/*      */ 
/*      */ 
/*      */     
/*  214 */     int st = JRMCoreH.StusEfctsMe(13) ? (JRMCoreH.rc_sai(JRMCoreH.Race) ? JRMCoreH.mstc_sai(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) - 1) : (JRMCoreH.rc_arc(JRMCoreH.Race) ? JRMCoreH.mstc_arc() : (JRMCoreH.rc_humNam(JRMCoreH.Race) ? JRMCoreH.mstc_humnam() : 1))) : JRMCoreH.State;
/*  215 */     float inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 11, 100, JRMCoreH.Race, JRMCoreH.Class, 0.0F) * 0.01F;
/*  216 */     float add = JRMCoreH.spdFrm(JRMCoreH.PlyrAttrbts(null)[4], n, JRMCoreH.curRelease, turbo, true, st, JRMCoreH.State2, inc);
/*      */ 
/*      */     
/*  219 */     boolean pressingRightClick = isPressed(JRMCoreClient.mc.field_71474_y.field_74313_G);
/*  220 */     boolean pressingForward = isPressed(JRMCoreClient.mc.field_71474_y.field_74351_w);
/*  221 */     boolean pressingLeft = isPressed(JRMCoreClient.mc.field_71474_y.field_74370_x);
/*  222 */     boolean pressingBack = isPressed(JRMCoreClient.mc.field_71474_y.field_74368_y);
/*  223 */     boolean pressingRight = isPressed(JRMCoreClient.mc.field_71474_y.field_74366_z);
/*      */ 
/*      */     
/*  226 */     boolean isAnyDirectionKeyPressing = (!JRMCoreH.StusEfctsMe(4) && !pressingRightClick && (pressingForward || pressingLeft || pressingBack || pressingRight));
/*      */     
/*  228 */     boolean forw = (isAnyDirectionKeyPressing && isPressed(JRMCoreKeyHandler.Fn));
/*      */ 
/*      */     
/*  231 */     if (dodge_forwSwTm == 0 && isPressed(JRMCoreKeyHandler.Fn) && 
/*  232 */       !isPressed(JRMCoreClient.mc.field_71474_y.field_74313_G) && 
/*  233 */       !isPressed(JRMCoreKeyHandler.KiCharge) && 
/*  234 */       !isPressed(JRMCoreKeyHandler.KiAscend))
/*      */     {
/*  236 */       dodge_forwSwTm = forw ? 1 : 0;
/*      */     }
/*      */ 
/*      */     
/*  240 */     if (dodge_forwSwTm > 0 && isAnyDirectionKeyPressing && !JRMCoreClient.mc.field_71439_g.field_70122_E) {
/*      */       
/*  242 */       dodge_forwHold = true;
/*  243 */       dodge_forwSwTm++;
/*      */     }
/*      */     else {
/*      */       
/*  247 */       dodge_forwHold = false;
/*  248 */       dodge_forwSwTm = 0;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  253 */     int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts();
/*  254 */     byte pwr = JRMCoreH.Pwrtyp;
/*  255 */     byte rce = JRMCoreH.Race;
/*  256 */     byte cls = JRMCoreH.Class;
/*  257 */     int maxEnergy = JRMCoreH.stat((Entity)entityClientPlayerMP, 5, pwr, 5, PlyrAttrbts[5], rce, cls, 0.0F);
/*  258 */     int ce2 = JRMCoreH.curEnergy;
/*  259 */     int cst2 = (int)(maxEnergy * 0.1F - n * 0.005F);
/*  260 */     int maxStam = JRMCoreH.stat((Entity)entityClientPlayerMP, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
/*  261 */     int ce = JRMCoreH.curStamina;
/*  262 */     int cst = (int)(maxStam * (0.2F - n * 0.005F));
/*  263 */     boolean dodge = !JRMCoreH.PlyrSettingsB(2);
/*      */     
/*  265 */     if (ce > cst && n > 0 && dodge && ce2 > cst2 && !entityClientPlayerMP.func_70115_ae()) {
/*      */       
/*  267 */       if (dodge_forwHold && !((EntityPlayer)entityClientPlayerMP).field_70122_E && dodge_forwHold) {
/*      */         
/*  269 */         if (!dodge_forwDash_STE) dodge_forwDash_STE = true; 
/*  270 */         if (floating) floating = false; 
/*  271 */         float s = add * 1.5F;
/*  272 */         float w = JRMCoreH.weightPerc(1);
/*  273 */         s *= w;
/*  274 */         double motionX = 0.0D;
/*  275 */         double motionY = 0.0D;
/*  276 */         double motionZ = 0.0D;
/*      */         
/*  278 */         float yaw = ((EntityPlayer)entityClientPlayerMP).field_70177_z;
/*  279 */         float pitch = ((EntityPlayer)entityClientPlayerMP).field_70125_A;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  284 */         if (pressingLeft) {
/*      */           
/*  286 */           yaw -= 90.0F / ((pressingForward || pressingBack) ? 2.0F : 1.0F) * (pressingBack ? -1.0F : 1.0F);
/*  287 */           pitch = 0.0F;
/*      */         }
/*  289 */         else if (pressingRight) {
/*      */           
/*  291 */           yaw += 90.0F / ((pressingForward || pressingBack) ? 2.0F : 1.0F) * (pressingBack ? -1.0F : 1.0F);
/*  292 */           pitch = 0.0F;
/*      */         } 
/*      */         
/*  295 */         if (pressingForward) {
/*      */           
/*  297 */           pitch = ((EntityPlayer)entityClientPlayerMP).field_70125_A;
/*      */         }
/*  299 */         else if (pressingBack) {
/*      */           
/*  301 */           yaw -= 180.0F;
/*  302 */           pitch = ((EntityPlayer)entityClientPlayerMP).field_70125_A * -1.0F;
/*      */         } 
/*      */         
/*  305 */         motionX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/*  306 */         motionZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/*  307 */         motionY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/*      */         
/*  309 */         setThrowableHeading((Entity)entityClientPlayerMP, motionX, motionY, motionZ, s * (float)JRMCoreConfig.Flngspd, 0.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  330 */         if (sec <= 0.0F || dodge_forwSwTm == 2) {
/*      */           
/*  332 */           sec = 10.0F;
/*  333 */           triForce(4, 0, (dodge_forwSwTm == 2) ? 5 : 4);
/*  334 */           chargePart(false);
/*      */         } 
/*      */ 
/*      */         
/*  338 */         if (dodge_forwSwTm == 2)
/*      */         {
/*  340 */           KeyBinding.func_74510_a(JRMCoreKeyHandler.Fn.func_151463_i(), false);
/*      */         }
/*      */       } 
/*      */       
/*  344 */       if (dodge_forwDash_STE && !dodge_forwHold) { dodge_forwDash_STE = false; floating = true; dodge_forwSwTm = 0; KeyBinding.func_74510_a(JRMCoreKeyHandler.Fn.func_151463_i(), false); }
/*      */     
/*  346 */     } else if (dodge_forwHold) {
/*      */       
/*  348 */       if (dodge_forwDash_STE) { dodge_forwDash_STE = false; floating = true; dodge_forwSwTm = 0; KeyBinding.func_74510_a(JRMCoreKeyHandler.Fn.func_151463_i(), false); }
/*      */     
/*      */     } 
/*  351 */     if (sec > 0.0F)
/*      */     {
/*  353 */       sec--;
/*      */     }
/*      */     
/*  356 */     boolean isSwooping = JRMCoreH.StusEfctsMe(7);
/*      */     
/*  358 */     if (isSwooping && !dodge_forwDash_STE && sent <= 0.0F) {
/*      */       
/*  360 */       sent = JRMCoreCliTicH.counterValue * 0.5F;
/*  361 */       JRMCoreH.Skll((byte)5, (byte)1, (byte)7);
/*      */     }
/*  363 */     else if (!isSwooping && dodge_forwDash_STE && sent <= 0.0F) {
/*      */       
/*  365 */       sent = JRMCoreCliTicH.counterValue * 0.5F;
/*  366 */       JRMCoreH.Skll((byte)5, (byte)0, (byte)7);
/*      */     }
/*  368 */     else if (sent > 0.0F && sent <= 1.0F && !isSwooping && !dodge_forwDash_STE) {
/*      */       
/*  370 */       sent = 0.0F;
/*      */     }
/*  372 */     else if (sent > 0.0F && sent <= 1.0F && isSwooping && dodge_forwDash_STE) {
/*      */       
/*  374 */       sent = 0.0F;
/*      */     } 
/*      */     
/*  377 */     if (sent > 0.0F) sent--;
/*      */     
/*  379 */     int cost = (int)(1.0F + add);
/*      */     
/*  381 */     boolean able = true;
/*  382 */     boolean b = (n == 0);
/*  383 */     if (DBCConfig.flyAnyLvl) b = false;
/*      */     
/*  385 */     if (JRMCoreH.curEnergy < cost || b)
/*      */     {
/*  387 */       able = false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  393 */     if (DBCConfig.oldFly) {
/*      */       
/*  395 */       if (isPressed(kiFlight) || (isPressed(JRMCoreKeyHandler.Fn) && isPressed(kiFlight) && able))
/*      */       {
/*  397 */         floatTime++;
/*  398 */         if (floatTime >= 20) {
/*  399 */           JRMCoreH.Cost(cost);
/*  400 */           floatTime = 0;
/*      */         } 
/*      */         
/*  403 */         if (isPressed(JRMCoreKeyHandler.Fn)) {
/*      */           
/*  405 */           DBCClient.mc.field_71439_g.field_70181_x /= 15.15D;
/*      */         }
/*      */         else {
/*      */           
/*  409 */           DBCClient.mc.field_71439_g.field_70181_x = (0.6F * add * (float)JRMCoreConfig.Flngspd);
/*      */         } 
/*      */         
/*  412 */         float par1 = ((EntityPlayer)entityClientPlayerMP).field_70702_br;
/*  413 */         float par2 = ((EntityPlayer)entityClientPlayerMP).field_70701_bs;
/*  414 */         if (isPressed(DBCClient.mc.field_71474_y.field_74351_w) || 
/*  415 */           isPressed(DBCClient.mc.field_71474_y.field_74368_y) || 
/*  416 */           isPressed(DBCClient.mc.field_71474_y.field_74370_x) || 
/*  417 */           isPressed(DBCClient.mc.field_71474_y.field_74366_z)) {
/*      */           
/*  419 */           mv(par1, par2, (EntityPlayer)entityClientPlayerMP, add);
/*  420 */           floatMultAdded = true;
/*      */         } else {
/*  422 */           ((EntityPlayer)entityClientPlayerMP).field_70159_w = 0.0D;
/*  423 */           ((EntityPlayer)entityClientPlayerMP).field_70179_y = 0.0D;
/*  424 */           floatMultAdded = false;
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  433 */       if (isPressed(kiFlight)) {
/*      */         
/*  435 */         KeyBinding.func_74510_a(kiFlight.func_151463_i(), false);
/*      */         
/*  437 */         if (able) {
/*      */           
/*  439 */           if (!floating) {
/*      */             
/*  441 */             if (((EntityPlayer)entityClientPlayerMP).field_70122_E)
/*      */             {
/*  443 */               DBCClient.mc.field_71439_g.field_70181_x = 0.5D;
/*  444 */               jumpToFly = true;
/*      */             }
/*      */           
/*      */           } else {
/*      */             
/*  449 */             floatMultAdded = false;
/*      */           } 
/*      */           
/*  452 */           floating = !floating;
/*      */         } 
/*      */       } 
/*      */       
/*  456 */       if (floating && able)
/*      */       {
/*  458 */         if (!((EntityPlayer)entityClientPlayerMP).field_70122_E) {
/*      */           
/*  460 */           floatTime++;
/*  461 */           if (floatTime >= 20) {
/*      */             
/*  463 */             JRMCoreH.Cost(cost);
/*  464 */             floatTime = 0;
/*      */           } 
/*      */           
/*  467 */           if (isPressed(keyBindJump)) {
/*      */             
/*  469 */             jumpRel = true;
/*  470 */             DBCClient.mc.field_71439_g.field_70181_x = (0.25F * add * (float)JRMCoreConfig.Flngspd);
/*      */           }
/*  472 */           else if (isPressed(keyBindSneak)) {
/*  473 */             if (DBCClient.mc.field_71439_g.field_70181_x > -(0.25F * add)) {
/*  474 */               DBCClient.mc.field_71439_g.field_70181_x = (-(0.25F * add) * (float)JRMCoreConfig.Flngspd);
/*      */             }
/*  476 */           } else if (((EntityPlayer)entityClientPlayerMP).field_70181_x < 0.0D) {
/*  477 */             DBCClient.mc.field_71439_g.field_70181_x /= (JRMCoreH.isShtng || !JRMCoreConfig.PlayerFlyingDragDownOn) ? 150.15D : 15.15D;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  482 */           float par1 = ((EntityPlayer)entityClientPlayerMP).field_70702_br;
/*  483 */           float par2 = ((EntityPlayer)entityClientPlayerMP).field_70701_bs;
/*      */           
/*  485 */           if (isPressed(DBCClient.mc.field_71474_y.field_74351_w) || 
/*  486 */             isPressed(DBCClient.mc.field_71474_y.field_74368_y) || 
/*  487 */             isPressed(DBCClient.mc.field_71474_y.field_74370_x) || 
/*  488 */             isPressed(DBCClient.mc.field_71474_y.field_74366_z)) {
/*      */             
/*  490 */             if (JRMCoreH.StusEfctsMe(9) && !JRMCoreH.StusEfctsMe(4) && 
/*  491 */               !isPressed(DBCClient.mc.field_71474_y.field_74368_y) && 
/*  492 */               !isPressed(DBCClient.mc.field_71474_y.field_74370_x) && 
/*  493 */               !isPressed(DBCClient.mc.field_71474_y.field_74366_z)) {
/*      */               
/*  495 */               float s = add;
/*  496 */               float wei = JRMCoreH.weightPerc(1);
/*  497 */               s *= wei;
/*  498 */               int back = 0;
/*  499 */               int right = 0;
/*  500 */               int left = 0;
/*  501 */               double motionX = (-MathHelper.func_76126_a((((EntityPlayer)entityClientPlayerMP).field_70177_z + back + left + right) / 180.0F * 3.1415927F) * MathHelper.func_76134_b(((EntityPlayer)entityClientPlayerMP).field_70125_A / 180.0F * 3.1415927F));
/*  502 */               double motionZ = (MathHelper.func_76134_b((((EntityPlayer)entityClientPlayerMP).field_70177_z + back + left + right) / 180.0F * 3.1415927F) * MathHelper.func_76134_b(((EntityPlayer)entityClientPlayerMP).field_70125_A / 180.0F * 3.1415927F));
/*  503 */               double motionY = -MathHelper.func_76126_a((((EntityPlayer)entityClientPlayerMP).field_70125_A + back) / 180.0F * 3.1415927F);
/*      */               
/*  505 */               setThrowableHeading((Entity)entityClientPlayerMP, motionX, motionY, motionZ, s * (float)JRMCoreConfig.Flngspd, 0.0F);
/*      */             }
/*      */             else {
/*      */               
/*  509 */               mv(par1, par2, (EntityPlayer)entityClientPlayerMP, add * (float)JRMCoreConfig.Flngspd);
/*      */             } 
/*      */             
/*  512 */             floatMultAdded = true;
/*      */           }
/*      */           else {
/*      */             
/*  516 */             ((EntityPlayer)entityClientPlayerMP).field_70159_w = 0.0D;
/*  517 */             ((EntityPlayer)entityClientPlayerMP).field_70179_y = 0.0D;
/*  518 */             floatMultAdded = false;
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/*  523 */       if (floating && ((EntityPlayer)entityClientPlayerMP).field_70122_E)
/*      */       {
/*  525 */         if (jumpToFly) {
/*      */ 
/*      */           
/*  528 */           jumpToFly = false;
/*      */         }
/*      */         else {
/*      */           
/*  532 */           floating = false;
/*  533 */           floatMultAdded = false;
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void mv(float strafe, float frward, EntityPlayer var4, float add) {
/*  542 */     float f3 = strafe * strafe + frward * frward;
/*  543 */     if (f3 >= 1.0E-4F) {
/*      */       
/*  545 */       f3 = MathHelper.func_76129_c(f3);
/*      */       
/*  547 */       if (f3 < 1.0F)
/*      */       {
/*  549 */         f3 = 1.0F;
/*      */       }
/*      */       
/*  552 */       f3 = add / f3;
/*      */ 
/*      */       
/*  555 */       float f4 = MathHelper.func_76126_a(var4.field_70177_z * 3.1415927F / 180.0F);
/*  556 */       float f5 = MathHelper.func_76134_b(var4.field_70177_z * 3.1415927F / 180.0F);
/*  557 */       float pitch = MathHelper.func_76126_a(var4.field_70125_A * 3.1415927F / 180.0F);
/*  558 */       float speedY = 1.0F - ((pitch < 0.0F) ? -pitch : pitch);
/*      */       
/*  560 */       strafe *= f3;
/*  561 */       frward *= f3;
/*      */       
/*  563 */       float speed = var4.field_70122_E ? 0.25F : 0.25F;
/*      */       
/*  565 */       var4.field_70159_w = ((strafe * f5 - frward * f4) * speed);
/*  566 */       var4.field_70179_y = ((frward * f5 + strafe * f4) * speed);
/*      */     } 
/*      */   }
/*      */   
/*  570 */   public static int tickTime = 0;
/*  571 */   public static int prevTickTime = 0;
/*  572 */   public static int dash = 0;
/*      */   
/*      */   public static int dodge_per;
/*      */   
/*      */   public static long dodge_recently;
/*      */   public static boolean dodge_forwHold;
/*      */   public static int dodge_forwSwTm;
/*      */   
/*      */   public static void DashKi(boolean sprint) {
/*  581 */     EntityClientPlayerMP entityClientPlayerMP = DBCClient.mc.field_71439_g;
/*  582 */     WorldClient worldClient = DBCClient.mc.field_71441_e;
/*      */     
/*  584 */     int n = JRMCoreH.SklLvl(2, (byte)1);
/*      */ 
/*      */ 
/*      */     
/*  588 */     int st = JRMCoreH.StusEfctsMe(13) ? (JRMCoreH.rc_sai(JRMCoreH.Race) ? JRMCoreH.mstc_sai(JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) - 1) : (JRMCoreH.rc_arc(JRMCoreH.Race) ? JRMCoreH.mstc_arc() : (JRMCoreH.rc_humNam(JRMCoreH.Race) ? JRMCoreH.mstc_humnam() : 1))) : JRMCoreH.State;
/*  589 */     float inc = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 7, 100, JRMCoreH.Race, JRMCoreH.Class, 0.0F) * 0.01F;
/*  590 */     float add = JRMCoreH.spdFrm(JRMCoreH.PlyrAttrbts(null)[1], n, JRMCoreH.curRelease, turbo, false, st, JRMCoreH.State2, inc);
/*      */     
/*  592 */     int cost = (int)(1.0F + add);
/*      */ 
/*      */ 
/*      */     
/*  596 */     int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts();
/*  597 */     byte pwr = JRMCoreH.Pwrtyp;
/*  598 */     byte rce = JRMCoreH.Race;
/*  599 */     byte cls = JRMCoreH.Class;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  607 */     int maxStam = JRMCoreH.stat((Entity)entityClientPlayerMP, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
/*  608 */     int ce = JRMCoreH.curStamina;
/*  609 */     int cst = (int)(maxStam * 0.2F - n * 0.01F);
/*  610 */     boolean left = JRMCoreClient.mc.field_71474_y.field_74370_x.func_151468_f();
/*  611 */     boolean right = JRMCoreClient.mc.field_71474_y.field_74366_z.func_151468_f();
/*  612 */     boolean back = JRMCoreClient.mc.field_71474_y.field_74368_y.func_151468_f();
/*      */ 
/*      */ 
/*      */     
/*  616 */     boolean dodge = !JRMCoreH.PlyrSettingsB(2);
/*  617 */     long ctm = System.currentTimeMillis() / 1000L;
/*  618 */     if (dodge_per == 0 && dodge_recently != ctm && isPressed(JRMCoreKeyHandler.Fn) && 
/*  619 */       !isPressed(JRMCoreClient.mc.field_71474_y.field_74313_G) && 
/*  620 */       !isPressed(JRMCoreKeyHandler.KiCharge) && 
/*  621 */       !isPressed(JRMCoreKeyHandler.KiAscend)) {
/*      */       
/*  623 */       dodge_per = (left || right || back) ? 1 : 0;
/*      */     }
/*  625 */     else if (dodge_recently == ctm) {
/*      */       
/*  627 */       dodge_per = 0;
/*      */     } 
/*      */     
/*  630 */     if (dodge_per > 0 && dodge_recently != ctm && ce > cst && n > 0 && dodge && JRMCoreH.curRelease > 0) {
/*  631 */       int y = JRMCoreClient.mc.field_71439_g.field_70122_E ? 2 : 1;
/*  632 */       if (left) {
/*      */         
/*  634 */         dodge_recently = ctm;
/*  635 */         double e = Math.cos((JRMCoreClient.mc.field_71439_g.field_70177_z - 90.0F) * Math.PI / 180.0D) * 1.5D * y;
/*  636 */         double r = Math.sin((JRMCoreClient.mc.field_71439_g.field_70177_z - 90.0F) * Math.PI / 180.0D) * -1.5D * y;
/*  637 */         JRMCoreClient.mc.field_71439_g.field_70179_y = e;
/*  638 */         JRMCoreClient.mc.field_71439_g.field_70159_w = r;
/*  639 */         triForce(4, 0, 0);
/*      */       } 
/*      */       
/*  642 */       if (right) {
/*      */         
/*  644 */         dodge_recently = ctm;
/*  645 */         double e = Math.cos((JRMCoreClient.mc.field_71439_g.field_70177_z + 90.0F) * Math.PI / 180.0D) * 1.5D * y;
/*  646 */         double r = Math.sin((JRMCoreClient.mc.field_71439_g.field_70177_z + 90.0F) * Math.PI / 180.0D) * -1.5D * y;
/*  647 */         JRMCoreClient.mc.field_71439_g.field_70179_y = e;
/*  648 */         JRMCoreClient.mc.field_71439_g.field_70159_w = r;
/*  649 */         triForce(4, 0, 1);
/*      */       } 
/*      */       
/*  652 */       if (back) {
/*      */         
/*  654 */         dodge_recently = ctm;
/*  655 */         double e = Math.cos(JRMCoreClient.mc.field_71439_g.field_70177_z * Math.PI / 180.0D) * -1.0D * y;
/*  656 */         double r = Math.sin(JRMCoreClient.mc.field_71439_g.field_70177_z * Math.PI / 180.0D) * 1.0D * y;
/*  657 */         JRMCoreClient.mc.field_71439_g.field_70179_y = e;
/*  658 */         JRMCoreClient.mc.field_71439_g.field_70159_w = r;
/*  659 */         triForce(4, 0, 3);
/*      */       } 
/*  661 */       dodge_per = 0;
/*  662 */       KeyBinding.func_74510_a(JRMCoreKeyHandler.Fn.func_151463_i(), false);
/*      */     } 
/*      */     
/*  665 */     boolean able = true;
/*  666 */     if (JRMCoreH.curEnergy < cost || dodge_forwHold)
/*      */     {
/*  668 */       able = false;
/*      */     }
/*      */     
/*  671 */     if (able && sprint && !floating && JRMCoreH.curRelease > 0) {
/*      */       
/*  673 */       dash++;
/*  674 */       if (dash >= 20) {
/*  675 */         JRMCoreH.Cost(cost);
/*  676 */         dash = 0;
/*      */       } 
/*  678 */       double par12 = ((EntityPlayer)entityClientPlayerMP).field_70165_t;
/*  679 */       double par22 = ((EntityPlayer)entityClientPlayerMP).field_70163_u;
/*  680 */       double par32 = ((EntityPlayer)entityClientPlayerMP).field_70161_v;
/*      */       
/*  682 */       if (worldClient.func_147439_a((int)par12, (int)par22 - 2, (int)par32) != Blocks.field_150432_aD) {
/*      */ 
/*      */ 
/*      */         
/*  686 */         float par1 = ((EntityPlayer)entityClientPlayerMP).field_70702_br;
/*  687 */         float par2 = ((EntityPlayer)entityClientPlayerMP).field_70701_bs;
/*  688 */         if (isPressed(DBCClient.mc.field_71474_y.field_74351_w) || 
/*  689 */           isPressed(DBCClient.mc.field_71474_y.field_74368_y) || 
/*  690 */           isPressed(DBCClient.mc.field_71474_y.field_74370_x) || 
/*  691 */           isPressed(DBCClient.mc.field_71474_y.field_74366_z)) {
/*      */           
/*  693 */           mv(par1, par2, (EntityPlayer)entityClientPlayerMP, add);
/*  694 */           floatMultAdded = true;
/*      */         } else {
/*  696 */           ((EntityPlayer)entityClientPlayerMP).field_70159_w = 0.0D;
/*  697 */           ((EntityPlayer)entityClientPlayerMP).field_70179_y = 0.0D;
/*  698 */           floatMultAdded = false;
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
/*      */   public static void setThrowableHeading(Entity e, double par1, double par3, double par5, float par7, float par8) {
/*  712 */     Random rand = e.field_70170_p.field_73012_v;
/*  713 */     par1 *= par7;
/*  714 */     par3 *= par7;
/*  715 */     par5 *= par7;
/*  716 */     float s = e.field_70122_E ? 0.25F : 0.25F;
/*  717 */     e.field_70159_w = par1 * s;
/*  718 */     e.field_70181_x = par3 * s;
/*  719 */     e.field_70179_y = par5 * s;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean turbo = false;
/*  724 */   public static int ton = 0;
/*      */ 
/*      */   
/*      */   public static void TurboMode(KeyBinding key) {
/*  728 */     EntityClientPlayerMP entityClientPlayerMP = DBCClient.mc.field_71439_g;
/*  729 */     if (isPressed(key)) {
/*  730 */       KeyBinding.func_74510_a(key.func_151463_i(), false);
/*  731 */       if (!turbo) { turbo = true; JRMCoreH.Skll((byte)5, (byte)0, (byte)3); JRMCoreH.jrmct(3); }
/*  732 */       else if (turbo) { turbo = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)3); JRMCoreH.jrmct(3); }
/*      */     
/*  734 */     }  if (JRMCoreH.curEnergy <= 0) { turbo = false; ton++; if (ton > 10) { JRMCoreH.Skll((byte)5, (byte)1, (byte)3); JRMCoreH.jrmct(3); ton = 0; }
/*      */        }
/*      */   
/*      */   } public static void EnAt(byte selc) {
/*  738 */     PD.sendToServer((IMessage)new DBCPenergy(selc, (byte)0));
/*      */   } public static void EnAt(byte selc, byte p) {
/*  740 */     PD.sendToServer((IMessage)new DBCPenergy(selc, p));
/*      */   }
/*      */   public static void EnAtSlct(byte b) {
/*  743 */     byte selct = JRMCoreH.EnAtSlct;
/*  744 */     JRMCoreH.EnAtSlct = (byte)(selct + ((b == 1) ? -1 : 1));
/*  745 */     if (JRMCoreH.EnAtSlct > (JRMCoreH.mrAtts ? 7 : 3)) { JRMCoreH.EnAtSlct = 0; } else if (JRMCoreH.EnAtSlct < 0) { JRMCoreH.EnAtSlct = (byte)(JRMCoreH.mrAtts ? 7 : 3); }
/*      */   
/*      */   }
/*      */   
/*      */   public static boolean KAkiEn(byte s, byte r, byte p) {
/*  750 */     String[] tech = JRMCoreH.tech(s);
/*  751 */     short cost = (short)(JRMCoreH.maxEnergy + 1);
/*  752 */     if (tech != null) {
/*  753 */       if (s < 4) { cost = (short)(int)((JRMCoreH.costEnAt(tech) * r) * 0.02F * p * 0.02F); }
/*  754 */       else { cost = (short)(int)((Short.parseShort(tech[7]) * r) * 0.02F * p * 0.02F * (JRMCoreH.State + 1)); }
/*  755 */        if (JRMCoreH.curEnergy >= cost) return (JRMCoreH.curEnergy >= cost);
/*      */       
/*  757 */       DBCClientTickHandler.nuller();
/*      */       
/*  759 */       KeyBinding.func_74510_a(DBCClient.mc.field_71474_y.field_74313_G.func_151463_i(), false);
/*      */     } 
/*      */     
/*  762 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean isPressed(KeyBinding k) {
/*  766 */     return k.func_151470_d();
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
/*      */   public static boolean wasTransformPressed = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void Ascend(KeyBinding k) {
/*  793 */     boolean useOozaru = false;
/*  794 */     boolean rotPit = (DBCClient.mc.field_71439_g.field_70125_A <= -90.0F);
/*  795 */     boolean canUseQuickTransform = false;
/*  796 */     if (!isPressed(k)) wasTransformPressed = false;
/*      */ 
/*      */ 
/*      */     
/*  800 */     if (rotPit) {
/*      */       
/*  802 */       int n = 200;
/*  803 */       EntityClientPlayerMP entityClientPlayerMP = DBCClient.mc.field_71439_g;
/*  804 */       AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(((EntityPlayer)entityClientPlayerMP).field_70165_t - n, 200.0D, ((EntityPlayer)entityClientPlayerMP).field_70161_v - n, ((EntityPlayer)entityClientPlayerMP).field_70165_t + n, 255.0D, ((EntityPlayer)entityClientPlayerMP).field_70161_v + n);
/*  805 */       List l = ((EntityPlayer)entityClientPlayerMP).field_70170_p.func_72872_a(EntityEnergyFM.class, aabb);
/*  806 */       boolean pwbl = !l.isEmpty();
/*      */       
/*  808 */       boolean night = (JRMCoreH.StusEfctsMe(8) || pwbl);
/*  809 */       boolean tm = JRMCoreH.tailHas(JRMCoreH.TlMd);
/*  810 */       boolean sky = false;
/*  811 */       for (int i = (int)((EntityPlayer)entityClientPlayerMP).field_70163_u; i < 256; i++) {
/*  812 */         int x = (int)((EntityPlayer)entityClientPlayerMP).field_70165_t;
/*  813 */         int z = (int)((EntityPlayer)entityClientPlayerMP).field_70161_v;
/*  814 */         sky = DBCClient.mc.field_71441_e.func_147437_c((x < 0) ? (x - 1) : x, i, (z < 0) ? (z - 1) : z);
/*  815 */         if (!sky)
/*      */           break; 
/*  817 */       }  useOozaru = (sky && tm && JRMCoreH.State == 0 && JRMCoreH.rSai() && night && rotPit);
/*      */     } 
/*      */     
/*  820 */     boolean isTransformKeyPressed = useOozaru ? true : isPressed(k);
/*      */     
/*  822 */     boolean useKaioken = (JRMCoreH.PlyrSettingsB(0) && JRMCoreH.SklLvl(8) > 0);
/*      */ 
/*      */     
/*  825 */     boolean isInUltraInstinct = (JRMCoreH.StusEfctsMe(19) && JRMCoreH.SklLvl(16) < JRMCoreH.State2 && JRMCoreH.State2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS);
/*  826 */     boolean useUltraInstinct2 = (JRMCoreH.SklLvl(16) > JRMCoreH.State2 && JRMCoreH.State2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS);
/*  827 */     boolean useGodOfDestruction = (JRMCoreH.SklLvl(18) > 0);
/*      */     
/*  829 */     boolean playerSettingsBlueOn = (JRMCoreH.PlyrSettingsI(1, 2) && JRMCoreH.State == 0);
/*      */     
/*  831 */     boolean playerSettingsBlueOnInBlue = (JRMCoreH.PlyrSettingsI(1, 2) && (JRMCoreH.State == 10 || JRMCoreH.State == 9));
/*      */     
/*  833 */     boolean playerSettingsGodOn = (JRMCoreH.PlyrSettingsI(1, 1) && (JRMCoreH.State == 9 || JRMCoreH.State == 10));
/*      */     
/*  835 */     int godSkillLevel = JRMCoreH.SklLvl(9);
/*      */     
/*  837 */     boolean isInKaioken = JRMCoreH.StusEfctsMe(5);
/*  838 */     boolean isInMystic = JRMCoreH.StusEfctsMe(13);
/*  839 */     boolean isInGoD = JRMCoreH.StusEfctsMe(20);
/*  840 */     boolean isInUI = JRMCoreH.StusEfctsMe(19);
/*  841 */     boolean isInBase = (JRMCoreH.State == (JRMCoreH.isRaceArcosian() ? 4 : 0));
/*  842 */     boolean isMajinAbsorptionModeOn = JRMCoreH.StusEfctsMe(21);
/*      */     
/*  844 */     boolean ascended = false;
/*      */     
/*  846 */     boolean useMajinAbsorption = (JGConfigRaces.CONFIG_MAJIN_ENABLED && JRMCoreH.isRaceMajin() && isMajinAbsorptionModeOn);
/*      */ 
/*      */ 
/*      */     
/*  850 */     if (isTransformKeyPressed) {
/*      */       
/*  852 */       if (!holdingForTransform)
/*      */       {
/*  854 */         if (holdingTransformTimer == null)
/*      */         {
/*  856 */           holdingTransformTimer = Instant.now();
/*      */         }
/*  858 */         else if (Duration.between(holdingTransformTimer, Instant.now()).toMillis() > 200L)
/*      */         {
/*  860 */           holdingForTransform = true;
/*      */         }
/*      */       
/*      */       }
/*      */     } else {
/*      */       
/*  866 */       holdingTransformTimer = null;
/*  867 */       holdingForTransform = false;
/*  868 */       sentAbsorption = false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  874 */     if (useMajinAbsorption || !isPressed(k) || ((!isInMystic || (DBCConfig.MysticKaiokenOn && useKaioken)) && !isInGoD))
/*      */     {
/*      */ 
/*      */       
/*  878 */       if (!useMajinAbsorption && isPressed(k) && JRMCoreH.PlyrSettingsB(6) && !JRMCoreH.StusEfctsMe(13)) {
/*      */         
/*  880 */         if (!DBCConfig.MysticKaiokenOn && (JRMCoreH.StusEfctsMe(5) || JRMCoreH.State2 != 0))
/*      */           return; 
/*  882 */         if (DBCConfig.IsInstantTransformEnabled[2]) canUseQuickTransform = true;
/*      */         
/*  884 */         if (holdingForTransform)
/*      */         {
/*  886 */           ptime++;
/*  887 */           int p = 12;
/*  888 */           if (ptime >= p) {
/*  889 */             ptime = 0;
/*  890 */             JRMCoreH.Cost(1);
/*  891 */             int ic = 10;
/*  892 */             ic = (ic > 100) ? 100 : ic;
/*  893 */             triForce(1, 0, ic);
/*      */           } 
/*  895 */           time++;
/*  896 */           if (JRMCoreH.curRelease < 50 && time >= 10) {
/*  897 */             time = 0;
/*  898 */             float en = 100.0F / JRMCoreH.maxEnergy * JRMCoreH.curEnergy;
/*  899 */             float re = JRMCoreH.curRelease;
/*  900 */             en = (en > 75.0F) ? 75.0F : en;
/*  901 */             if ((re >= 50.0F) ? (re - 50.0F < (en - 50.0F) * 2.0F) : (re < ((en <= 10.0F) ? (en * 5.0F) : 50.0F))) {
/*  902 */               JRMCoreH.Rls((byte)1);
/*      */             }
/*      */           } 
/*  905 */           pup++;
/*  906 */           pup2++;
/*  907 */           if (pup >= 33 || pup2 == 1) {
/*  908 */             String ar = "jinryuudragonbc:DBC.aura";
/*  909 */             soundAsc(ar);
/*  910 */             pup = 0;
/*      */           } 
/*      */           
/*  913 */           ascend++;
/*  914 */           int s = 10;
/*  915 */           if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
/*  916 */             Ascndng();
/*  917 */             JRMCoreH.Rls((byte)1);
/*  918 */             soundAsc(4);
/*  919 */             ascend = 0;
/*  920 */             ptime = 0;
/*  921 */             partnorm = 0;
/*  922 */             pup = 0;
/*  923 */             pup2 = 0;
/*      */           } 
/*      */           
/*  926 */           ascended = true;
/*  927 */           if (ascended) {
/*      */             
/*  929 */             if (!ascending)
/*      */             {
/*  931 */               ascending = true; JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
/*      */             }
/*      */           
/*  934 */           } else if (ascending) {
/*      */             
/*  936 */             ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/*  942 */       else if (!useMajinAbsorption && isPressed(k) && JRMCoreH.PlyrSettingsB(16) && !JRMCoreH.StusEfctsMe(20)) {
/*      */         
/*  944 */         if (isClientMoving()) {
/*      */           
/*  946 */           if (JRMCoreH.StusEfctsMe(1)) {
/*      */             
/*  948 */             ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */           } 
/*      */           
/*      */           return;
/*      */         } 
/*      */         
/*  954 */         boolean canTurnGoD = (isInBase && useGodOfDestruction && !isInMystic && !isInUI && !isInKaioken && JRMCoreH.SklLvl(9) > (JRMCoreH.rSai(JRMCoreH.Race) ? 1 : 0));
/*      */         
/*  956 */         if (canTurnGoD) {
/*      */           
/*  958 */           if (DBCConfig.IsInstantTransformEnabled[3]) canUseQuickTransform = true;
/*      */           
/*  960 */           if (holdingForTransform) {
/*      */             
/*  962 */             ptime++;
/*  963 */             int p = 10;
/*      */ 
/*      */             
/*  966 */             if (ptime >= p) {
/*      */               
/*  968 */               ptime = 0;
/*  969 */               JRMCoreH.Cost(1);
/*  970 */               int ic = 10;
/*  971 */               ic = (ic > 100) ? 100 : ic;
/*  972 */               triForce(1, 0, ic);
/*      */             } 
/*      */ 
/*      */             
/*  976 */             ascend++;
/*  977 */             int s = 10;
/*  978 */             if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
/*  979 */               Ascndng();
/*  980 */               JRMCoreH.Rls((byte)1);
/*  981 */               soundAsc(4);
/*  982 */               ascend = 0;
/*  983 */               ptime = 0;
/*  984 */               partnorm = 0;
/*  985 */               pup = 0;
/*  986 */               pup2 = 0;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  991 */         if (holdingForTransform)
/*      */         {
/*  993 */           ascended = true;
/*      */           
/*  995 */           if (ascended) {
/*      */             
/*  997 */             if (!ascending)
/*      */             {
/*  999 */               ascending = true; JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
/*      */             }
/*      */           
/* 1002 */           } else if (ascending) {
/*      */             
/* 1004 */             ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 1010 */       else if (!useMajinAbsorption && isPressed(k) && JRMCoreH.PlyrSettingsB(11) && !isInUltraInstinct) {
/*      */         
/* 1012 */         if (isClientMoving()) {
/*      */           
/* 1014 */           if (JRMCoreH.StusEfctsMe(1)) {
/*      */             
/* 1016 */             ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */           } 
/*      */           
/*      */           return;
/*      */         } 
/*      */         
/* 1022 */         boolean canTurnUI = (isInBase && !isInMystic && !JRMCoreH.StusEfctsMe(12) && !JRMCoreH.StusEfctsMe(5) && !JRMCoreH.pnh && !JRMCoreH.StusEfctsMe(18) && JRMCoreH.SklLvl(9) > (JRMCoreH.rSai(JRMCoreH.Race) ? 1 : 0) && useUltraInstinct2);
/*      */ 
/*      */         
/* 1025 */         if (canTurnUI) {
/*      */           
/* 1027 */           if (DBCConfig.IsInstantTransformEnabled[1]) canUseQuickTransform = true;
/*      */           
/* 1029 */           if (holdingForTransform) {
/*      */             
/* 1031 */             ptime++;
/* 1032 */             int p = 10;
/*      */ 
/*      */             
/* 1035 */             if (ptime >= p) {
/*      */               
/* 1037 */               ptime = 0;
/* 1038 */               JRMCoreH.Cost(1);
/* 1039 */               int ic = 10;
/* 1040 */               ic = (ic > 100) ? 100 : ic;
/* 1041 */               triForce(1, 0, ic);
/* 1042 */               triForce(5, 0, 0);
/*      */             } 
/*      */             
/* 1045 */             ascend++;
/* 1046 */             int s = 10;
/* 1047 */             if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
/* 1048 */               Ascndng();
/* 1049 */               JRMCoreH.Rls((byte)1);
/* 1050 */               soundAsc(4);
/* 1051 */               ascend = 0;
/* 1052 */               ptime = 0;
/* 1053 */               partnorm = 0;
/* 1054 */               pup = 0;
/* 1055 */               pup2 = 0;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 1060 */         if (holdingForTransform)
/*      */         {
/* 1062 */           ascended = true;
/*      */           
/* 1064 */           if (ascended) {
/*      */             
/* 1066 */             if (!ascending)
/*      */             {
/* 1068 */               ascending = true; JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
/*      */             }
/*      */           
/* 1071 */           } else if (ascending) {
/*      */             
/* 1073 */             ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 1079 */       else if (!useMajinAbsorption && isPressed(k) && JRMCoreH.PlyrSettingsB(4) && !JRMCoreH.StusEfctsMe(10) && !JRMCoreH.StusEfctsMe(11)) {
/*      */         
/* 1081 */         if (!wasTransformPressed) {
/*      */           
/* 1083 */           if (JRMCoreH.PlyrSettingsB(4)) {
/* 1084 */             String ar = "jinryuudragonbc:DBC.fusestrt";
/* 1085 */             soundAsc(ar);
/*      */           } 
/* 1087 */           wasTransformPressed = true;
/*      */         } 
/*      */         
/* 1090 */         ptime++;
/* 1091 */         int p = 12;
/* 1092 */         if (ptime >= p) {
/* 1093 */           ptime = 0;
/* 1094 */           JRMCoreH.Cost(1);
/* 1095 */           int ic = 10;
/* 1096 */           ic = (ic > 100) ? 100 : ic;
/* 1097 */           triForce(1, 0, ic);
/*      */         } 
/* 1099 */         ascend++;
/* 1100 */         int s = 10;
/* 1101 */         if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
/* 1102 */           Ascndng();
/* 1103 */           JRMCoreH.Rls((byte)1);
/* 1104 */           ascend = 0;
/* 1105 */           ptime = 0;
/* 1106 */           partnorm = 0;
/* 1107 */           pup = 0;
/* 1108 */           pup2 = 0;
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 1113 */       else if (!useKaioken || useOozaru) {
/*      */ 
/*      */ 
/*      */         
/* 1117 */         if (isTransformKeyPressed && JRMCoreH.isRaceArcosian() && canAttemptTransformation() && !JRMCoreH.isInState(5) && !JRMCoreH.isInState(6)) {
/*      */           
/* 1119 */           if (hasRacialSkillLevel()) {
/*      */             
/* 1121 */             int racialSkillLvl = getClientRacialSkillLevel();
/*      */ 
/*      */             
/* 1124 */             if (JRMCoreH.State < 4 || (racialSkillLvl >= 3 && JRMCoreH.State == 4))
/*      */             {
/* 1126 */               if (isClientMoving()) {
/*      */                 
/* 1128 */                 if (JRMCoreH.StusEfctsMe(1)) {
/*      */                   
/* 1130 */                   ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */                 } 
/*      */                 return;
/*      */               } 
/* 1134 */               canUseQuickTransform = true;
/*      */               
/* 1136 */               if (holdingForTransform)
/*      */               {
/* 1138 */                 ascended = true;
/* 1139 */                 time++;
/* 1140 */                 if (JRMCoreH.curRelease < 50 && time >= 10) {
/*      */                   
/* 1142 */                   time = 0;
/* 1143 */                   float en = 100.0F / JRMCoreH.maxEnergy * JRMCoreH.curEnergy;
/* 1144 */                   float re = JRMCoreH.curRelease;
/* 1145 */                   en = (en > 75.0F) ? 75.0F : en;
/* 1146 */                   if ((re >= 50.0F) ? (re - 50.0F < (en - 50.0F) * 2.0F) : (re < ((en <= 10.0F) ? (en * 5.0F) : 50.0F)))
/*      */                   {
/* 1148 */                     JRMCoreH.Rls((byte)1);
/*      */                   }
/*      */                 } 
/* 1151 */                 pup++;
/* 1152 */                 pup2++;
/* 1153 */                 if (pup >= 33 || pup2 == 1) {
/* 1154 */                   soundAsc(2);
/* 1155 */                   pup = 0;
/*      */                 } 
/* 1157 */                 ptime++;
/*      */                 
/* 1159 */                 int p = (racialSkillLvl >= 3) ? 10 : ((racialSkillLvl >= 2) ? 13 : 15);
/*      */ 
/*      */                 
/* 1162 */                 if (ptime >= p) {
/* 1163 */                   ptime = 0;
/* 1164 */                   JRMCoreH.Cost(1);
/* 1165 */                   int ic = ((racialSkillLvl >= 3) ? 15 : ((racialSkillLvl >= 2) ? 10 : 5)) * ((JRMCoreH.State > 3) ? 1 : 4);
/* 1166 */                   ic = (ic > 100) ? 100 : ic;
/* 1167 */                   triForce(1, 0, ic);
/*      */                 } 
/*      */                 
/* 1170 */                 ascend++;
/* 1171 */                 int s = 10;
/* 1172 */                 if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
/* 1173 */                   Ascndng();
/* 1174 */                   soundAsc(4);
/* 1175 */                   ascended = true;
/* 1176 */                   ascend = 0;
/* 1177 */                   ptime = 0;
/* 1178 */                   partnorm = 0;
/* 1179 */                   pup = 0;
/* 1180 */                   pup2 = 0;
/*      */                   
/* 1182 */                   JRMCoreH.kiInSuper = (racialSkillLvl >= 2) ? 2 : 1;
/*      */                 }
/*      */               
/*      */               }
/*      */             
/*      */             }
/*      */           
/*      */           } 
/* 1190 */         } else if (isTransformKeyPressed && JRMCoreH.isRaceSaiyan() && canAttemptTransformation() && 
/* 1191 */           !JRMCoreH.isInState(3) && !JRMCoreH.isInState(6) && !JRMCoreH.isInState(13) && ((godSkillLevel > 2) ? 
/*      */           
/* 1193 */           !JRMCoreH.isInState(15) : ((godSkillLevel > 1) ? 
/* 1194 */           !JRMCoreH.isInState(10) : !JRMCoreH.isInState(9)))) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1199 */           if (hasRacialSkillLevel())
/*      */           {
/* 1201 */             int racialSkillLvl = getClientRacialSkillLevel();
/* 1202 */             boolean isOozaru = (racialSkillLvl >= 1 && JRMCoreH.isInState(7));
/* 1203 */             boolean isSuperOozaru = (racialSkillLvl >= 6 && JRMCoreH.isInState(8));
/* 1204 */             boolean isBlue = (JRMCoreH.isInState(10) && godSkillLevel > 2 && racialSkillLvl >= 6);
/*      */ 
/*      */             
/* 1207 */             if (useOozaru || isOozaru || isSuperOozaru || isBlue || (racialSkillLvl >= 1 && (JRMCoreH.State < racialSkillLvl || (1 < racialSkillLvl && playerSettingsGodOn) || (1 < racialSkillLvl && playerSettingsBlueOnInBlue) || (
/*      */               
/* 1209 */               JRMCoreH.isInState(4) && 1 < racialSkillLvl))))
/*      */             {
/* 1211 */               if (isClientMoving()) {
/*      */                 
/* 1213 */                 if (JRMCoreH.StusEfctsMe(1)) {
/*      */                   
/* 1215 */                   ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */                 } 
/*      */                 return;
/*      */               } 
/* 1219 */               canUseQuickTransform = true;
/*      */               
/* 1221 */               if (holdingForTransform)
/*      */               {
/* 1223 */                 ascended = true;
/*      */ 
/*      */                 
/* 1226 */                 time++;
/* 1227 */                 if (JRMCoreH.curRelease < 50 && time >= 10) {
/*      */                   
/* 1229 */                   time = 0;
/*      */                   
/* 1231 */                   float en = 100.0F / JRMCoreH.maxEnergy * JRMCoreH.curEnergy;
/* 1232 */                   float re = JRMCoreH.curRelease;
/* 1233 */                   en = (en > 75.0F) ? 75.0F : en;
/* 1234 */                   if ((re >= 50.0F) ? (re - 50.0F < (en - 50.0F) * 2.0F) : (re < ((en <= 10.0F) ? (en * 5.0F) : 50.0F))) {
/* 1235 */                     JRMCoreH.Rls((byte)1);
/*      */                   }
/*      */                 } 
/*      */                 
/* 1239 */                 pup++;
/* 1240 */                 pup2++;
/* 1241 */                 if (pup >= 33 || pup2 == 1) {
/* 1242 */                   String ar = "jinryuudragonbc:DBC.aura";
/* 1243 */                   if (!useOozaru && JRMCoreH.StusEfctsMe(14)) {
/*      */                     
/* 1245 */                     ar = "jinryuudragonbc:DBC.aura";
/*      */                   }
/* 1247 */                   else if (!useOozaru && (playerSettingsGodOn || playerSettingsBlueOn || playerSettingsBlueOnInBlue)) {
/*      */                     
/* 1249 */                     ar = "jinryuudragonbc:1610.aurab";
/*      */                   }
/* 1251 */                   else if (useOozaru) {
/*      */                     
/* 1253 */                     ar = "jinryuudragonbc:1610.oozt";
/*      */                   } 
/* 1255 */                   soundAsc(ar);
/* 1256 */                   pup = 0;
/*      */                 } 
/*      */                 
/* 1259 */                 ptime++;
/* 1260 */                 int p = useOozaru ? 15 : ((racialSkillLvl >= 3) ? 5 : ((racialSkillLvl >= 2) ? 7 : 10));
/*      */ 
/*      */                 
/* 1263 */                 if (ptime >= p) {
/* 1264 */                   ptime = 0;
/* 1265 */                   JRMCoreH.Cost(1);
/* 1266 */                   int ic = useOozaru ? 15 : (isOozaru ? 5 : ((racialSkillLvl >= 4) ? 15 : ((racialSkillLvl >= 2) ? 10 : 5)));
/* 1267 */                   ic = (ic > 100) ? 100 : ic;
/* 1268 */                   triForce(1, 0, ic);
/*      */                 } 
/*      */ 
/*      */                 
/* 1272 */                 ascend++;
/*      */                 
/* 1274 */                 int s = 10;
/* 1275 */                 if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
/* 1276 */                   Ascndng();
/* 1277 */                   String ar = "jinryuudragonbc:DBC.ascend";
/*      */                   
/* 1279 */                   if (useOozaru) {
/* 1280 */                     ar = "jinryuudragonbc:DBC3.force";
/*      */                   } else {
/* 1282 */                     ar = "jinryuudragonbc:1610.sss";
/*      */                   } 
/* 1284 */                   soundAsc(ar);
/*      */                   
/* 1286 */                   ascended = true;
/* 1287 */                   ascend = 0;
/* 1288 */                   ptime = 0;
/* 1289 */                   partnorm = 0;
/* 1290 */                   pup = 0;
/* 1291 */                   pup2 = 0;
/*      */                   
/* 1293 */                   JRMCoreH.kiInSuper = (racialSkillLvl >= 2) ? 2 : 1;
/*      */                 }
/*      */               
/*      */               }
/*      */             
/*      */             }
/*      */           
/*      */           }
/*      */         
/* 1302 */         } else if (isTransformKeyPressed && JRMCoreH.isRaceMajin() && canAttemptTransformation() && (JRMCoreH.State < ((godSkillLevel > 0) ? 4 : 3) || isMajinAbsorptionModeOn)) {
/*      */           
/* 1304 */           if (JGConfigRaces.CONFIG_MAJIN_ENABLED && hasRacialSkillLevel())
/*      */           {
/* 1306 */             int racialSkillLvl = getClientRacialSkillLevel();
/* 1307 */             boolean isAbsorption = (JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED && racialSkillLvl >= 4 && isMajinAbsorptionModeOn);
/* 1308 */             boolean isPureSelected = JRMCoreH.PlyrSettingsI(1, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1315 */             boolean canAttempt = isMajinAbsorptionModeOn ? ((isAbsorption && !sentAbsorption)) : (JRMCoreH.isInState(0) ? (playerSettingsGodOn ? ((godSkillLevel > 0 && JRMCoreHDBC.hasMajinGodRacialRequirement(racialSkillLvl))) : ((racialSkillLvl >= (isPureSelected ? 5 : 2)))) : (isPureSelected ? false : ((racialSkillLvl >= 3 && !JRMCoreH.isInState(2)))));
/*      */ 
/*      */ 
/*      */             
/* 1319 */             if (canAttempt)
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1327 */               canUseQuickTransform = !isAbsorption;
/* 1328 */               if (isClientMoving()) {
/*      */                 
/* 1330 */                 if (JRMCoreH.StusEfctsMe(1)) {
/*      */                   
/* 1332 */                   ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */                 } 
/*      */                 
/*      */                 return;
/*      */               } 
/* 1337 */               if (holdingForTransform)
/*      */               {
/* 1339 */                 if (!isAbsorption) ascended = true;
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 1344 */                 time++;
/* 1345 */                 if (time >= 7) {
/* 1346 */                   time = 0;
/* 1347 */                   float en = 100.0F / JRMCoreH.maxEnergy * JRMCoreH.curEnergy;
/* 1348 */                   float re = JRMCoreH.curRelease;
/* 1349 */                   en = (en > 75.0F) ? 75.0F : en;
/* 1350 */                   if (!isAbsorption && ((re >= 50.0F) ? (re - 50.0F < (en - 50.0F) * 2.0F) : (re < ((en <= 10.0F) ? (en * 5.0F) : 50.0F)))) {
/* 1351 */                     JRMCoreH.Rls((byte)1);
/*      */                   }
/*      */                 } 
/* 1354 */                 pup++;
/* 1355 */                 pup2++;
/* 1356 */                 if (pup >= 33 || pup2 == 1) {
/* 1357 */                   if (!isAbsorption) soundAsc(2); 
/* 1358 */                   pup = 0;
/*      */                 } 
/*      */                 
/* 1361 */                 ptime++;
/* 1362 */                 int p = ((racialSkillLvl >= 3) ? 5 : ((racialSkillLvl >= 2) ? 7 : 10)) * (isAbsorption ? 3 : 1);
/*      */ 
/*      */                 
/* 1365 */                 if (ptime >= p) {
/* 1366 */                   ptime = 0;
/* 1367 */                   if (!isAbsorption) JRMCoreH.Cost(1); 
/* 1368 */                   int ic = ((racialSkillLvl >= 3) ? 15 : ((racialSkillLvl >= 2) ? 10 : 5)) * 2;
/* 1369 */                   ic = (ic > 100) ? 100 : ic;
/* 1370 */                   triForce(1, 0, ic);
/*      */                 } 
/*      */                 
/* 1373 */                 ascend++;
/*      */                 
/* 1375 */                 int s = 10;
/* 1376 */                 if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
/* 1377 */                   if (isAbsorption) {
/* 1378 */                     EnAt(DBCPacketHandlerServer.MAJIN_ABSORPTION, (byte)0);
/* 1379 */                     sentAbsorption = true;
/*      */                   } else {
/*      */                     
/* 1382 */                     Ascndng();
/* 1383 */                     soundAsc(4);
/*      */                   } 
/* 1385 */                   ascended = true;
/* 1386 */                   ascend = 0;
/* 1387 */                   ptime = 0;
/* 1388 */                   partnorm = 0;
/* 1389 */                   pup = 0;
/* 1390 */                   pup2 = 0;
/*      */                 }
/*      */               
/*      */               }
/*      */             
/*      */             }
/*      */           
/*      */           }
/*      */         
/* 1399 */         } else if (isTransformKeyPressed && JRMCoreH.isRaceHumanOrNamekian() && canAttemptTransformation() && JRMCoreH.isInState(0)) {
/*      */           
/* 1401 */           if (hasRacialSkillLevel()) {
/*      */             
/* 1403 */             int racialSkillLvl = getClientRacialSkillLevel();
/*      */ 
/*      */             
/* 1406 */             if (racialSkillLvl != 0)
/*      */             {
/*      */               
/* 1409 */               if (racialSkillLvl >= 1) {
/*      */                 
/* 1411 */                 canUseQuickTransform = true;
/* 1412 */                 if (isClientMoving()) {
/*      */                   
/* 1414 */                   if (JRMCoreH.StusEfctsMe(1)) {
/*      */                     
/* 1416 */                     ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */                   } 
/*      */                   
/*      */                   return;
/*      */                 } 
/* 1421 */                 if (holdingForTransform)
/*      */                 {
/* 1423 */                   ascended = true;
/*      */ 
/*      */ 
/*      */                   
/* 1427 */                   time++;
/* 1428 */                   if (time >= 7) {
/* 1429 */                     time = 0;
/* 1430 */                     float en = 100.0F / JRMCoreH.maxEnergy * JRMCoreH.curEnergy;
/* 1431 */                     float re = JRMCoreH.curRelease;
/* 1432 */                     en = (en > 75.0F) ? 75.0F : en;
/* 1433 */                     if ((re >= 50.0F) ? (re - 50.0F < (en - 50.0F) * 2.0F) : (re < ((en <= 10.0F) ? (en * 5.0F) : 50.0F))) {
/* 1434 */                       JRMCoreH.Rls((byte)1);
/*      */                     }
/*      */                   } 
/* 1437 */                   pup++;
/* 1438 */                   pup2++;
/* 1439 */                   if (pup >= 33 || pup2 == 1) {
/* 1440 */                     soundAsc(2);
/* 1441 */                     pup = 0;
/*      */                   } 
/*      */                   
/* 1444 */                   ptime++;
/* 1445 */                   int p = (racialSkillLvl >= 3) ? 5 : ((racialSkillLvl >= 2) ? 7 : 10);
/*      */ 
/*      */                   
/* 1448 */                   if (ptime >= p) {
/* 1449 */                     ptime = 0;
/* 1450 */                     JRMCoreH.Cost(1);
/* 1451 */                     int ic = ((racialSkillLvl >= 3) ? 15 : ((racialSkillLvl >= 2) ? 10 : 5)) * 2;
/* 1452 */                     ic = (ic > 100) ? 100 : ic;
/* 1453 */                     triForce(1, 0, ic);
/*      */                   } 
/*      */                   
/* 1456 */                   ascend++;
/*      */                   
/* 1458 */                   int s = 10;
/* 1459 */                   if (ascend >= s && JRMCoreH.TransSaiCurRg >= 100) {
/* 1460 */                     Ascndng();
/* 1461 */                     soundAsc(4);
/* 1462 */                     ascended = true;
/* 1463 */                     ascend = 0;
/* 1464 */                     ptime = 0;
/* 1465 */                     partnorm = 0;
/* 1466 */                     pup = 0;
/* 1467 */                     pup2 = 0;
/*      */                   }
/*      */                 
/*      */                 }
/*      */               
/*      */               } 
/*      */             }
/*      */           } 
/* 1475 */         } else if (JRMCoreH.TransSaiCurRg > 0) {
/*      */           
/* 1477 */           ptime++;
/* 1478 */           if (ptime >= 40) {
/*      */             
/* 1480 */             triForce(1, 1, 100);
/* 1481 */             ptime = 0;
/*      */           } 
/*      */         } 
/*      */         
/* 1485 */         if (ascended) {
/*      */           
/* 1487 */           if (!ascending)
/*      */           {
/* 1489 */             ascending = true; JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
/*      */           }
/*      */         
/* 1492 */         } else if (ascending) {
/*      */           
/* 1494 */           ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */         }
/* 1496 */         else if (ascendingK) {
/*      */           
/* 1498 */           ascendingK = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)5);
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1505 */         ascended = (isTransformKeyPressed && JRMCoreH.curBody > JRMCoreH.maxBody * 0.05F && JRMCoreH.SklLvl(8) > JRMCoreH.State2 && JRMCoreH.State2 < JRMCoreH.TransKaiDmg.length - 1);
/*      */         
/* 1507 */         if (ascended) {
/*      */           
/* 1509 */           if (!ascendingK)
/*      */           {
/* 1511 */             ascendingK = true; JRMCoreH.Skll((byte)5, (byte)0, (byte)5);
/*      */           }
/*      */         
/* 1514 */         } else if (ascendingK) {
/*      */           
/* 1516 */           ascendingK = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)5);
/*      */         }
/* 1518 */         else if (ascending) {
/*      */           
/* 1520 */           ascending = false; JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
/*      */         } 
/*      */         
/* 1523 */         if (ascended) {
/*      */           
/* 1525 */           if (DBCConfig.IsInstantTransformEnabled[0]) canUseQuickTransform = true;
/*      */           
/* 1527 */           if (holdingForTransform) {
/*      */             
/* 1529 */             pup++;
/* 1530 */             pup2++;
/* 1531 */             if (pup >= 33 || pup2 == 1) {
/* 1532 */               soundAsc(2);
/* 1533 */               pup = 0;
/*      */             } 
/*      */             
/* 1536 */             ascend++;
/* 1537 */             int s = 10;
/*      */             
/* 1539 */             if (ascend >= 20 + (10 - JRMCoreH.SklLvl(8)) * 10)
/*      */             {
/* 1541 */               Ascndng();
/* 1542 */               boolean kk = (JRMCoreH.State2 > 0 && JRMCoreH.StusEfctsMe(5));
/* 1543 */               String ar = "jinryuudragonbc:DBC3.force";
/* 1544 */               if (kk && JRMCoreH.rc_sai(JRMCoreH.Race) && JRMCoreH.State == 10)
/*      */               {
/* 1546 */                 ar = "jinryuudragonbc:1610.aurabks";
/*      */               }
/* 1548 */               soundAsc(ar);
/*      */               
/* 1550 */               ascend = 0;
/* 1551 */               ptime = 0;
/* 1552 */               partnorm = 0;
/* 1553 */               pup = 0;
/* 1554 */               pup2 = 0;
/*      */             }
/*      */           
/*      */           } 
/* 1558 */         } else if (!isTransformKeyPressed) {
/* 1559 */           ascend = 0;
/*      */         } 
/*      */       } 
/*      */     }
/* 1563 */     if (JRMCoreH.State2 > 0)
/*      */     {
/* 1565 */       if (!ascendingK) {
/*      */         
/* 1567 */         ascendingK = true;
/* 1568 */         if (!JRMCoreH.StusEfctsMe(19))
/*      */         {
/* 1570 */           JRMCoreH.Skll((byte)5, (byte)0, (byte)5);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1578 */     if (DBCConfig.InstantTransformOn)
/*      */     {
/*      */       
/* 1581 */       if (isTransformKeyPressed) {
/*      */         
/* 1583 */         if (canUseQuickTransform && !quickTransformAdded) {
/*      */           
/* 1585 */           quickTransformAdded = true;
/*      */           
/* 1587 */           if (quickTransformTimer == null)
/*      */           {
/* 1589 */             quickTransformTimer = Instant.now();
/*      */           }
/* 1591 */           else if (Duration.between(quickTransformTimer, Instant.now()).toMillis() < 700L)
/*      */           {
/* 1593 */             quickTransformCount++;
/* 1594 */             quickTransformTimer = Instant.now();
/*      */             
/* 1596 */             if (quickTransformCount >= 1)
/*      */             {
/* 1598 */               quickTransformTimer = null;
/* 1599 */               quickTransformCount = 0;
/* 1600 */               quickTransform();
/*      */             }
/*      */           
/*      */           }
/*      */         
/*      */         } 
/*      */       } else {
/*      */         
/* 1608 */         quickTransformAdded = false;
/*      */         
/* 1610 */         if ((quickTransformTimer != null || quickTransformCount > 0) && Duration.between(quickTransformTimer, Instant.now()).toMillis() > 1000L) {
/*      */           
/* 1612 */           quickTransformTimer = null;
/* 1613 */           quickTransformCount = 0;
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void quickTransform() {
/* 1623 */     if (DBCConfig.InstantTransformOn) {
/*      */       
/* 1625 */       ascend = 0;
/* 1626 */       ptime = 0;
/* 1627 */       partnorm = 0;
/* 1628 */       pup = 0;
/* 1629 */       pup2 = 0;
/*      */       
/* 1631 */       String ar = "jinryuudragonbc:DBC3.force";
/* 1632 */       soundAsc(ar);
/*      */ 
/*      */ 
/*      */       
/* 1636 */       int dbcascend = -1;
/* 1637 */       PD.sendToServer((IMessage)new DBCPascend((byte)-1));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void ssj2() {
/* 1644 */     pup++;
/* 1645 */     JRMCoreH.kiInSuper = 2;
/* 1646 */     if (pup == 50)
/*      */     {
/* 1648 */       pup = 0;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void Descend(KeyBinding key) {
/* 1655 */     boolean isDescendingKeyPressed = isPressed(key);
/* 1656 */     boolean fullDescending = false;
/* 1657 */     boolean singleDescend = false;
/*      */ 
/*      */     
/* 1660 */     if (isDescendingKeyPressed && DBCConfig.SingleFormDescendOn) {
/*      */ 
/*      */       
/* 1663 */       if (!singleDescendAdded) {
/*      */         
/* 1665 */         singleDescendAdded = true;
/*      */         
/* 1667 */         if (singleDescendTimer == null) {
/*      */           
/* 1669 */           singleDescendTimer = Instant.now();
/*      */         }
/* 1671 */         else if (Duration.between(singleDescendTimer, Instant.now()).toMillis() < 700L) {
/*      */           
/* 1673 */           singleDescendCount++;
/* 1674 */           singleDescendTimer = Instant.now();
/*      */           
/* 1676 */           if (singleDescendCount >= 1) {
/*      */ 
/*      */             
/* 1679 */             singleDescendTimer = null;
/* 1680 */             singleDescendCount = 0;
/*      */             
/* 1682 */             singleDescend = true;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1689 */       if (singleDescendTimer != null)
/*      */       {
/* 1691 */         if (!singleDescend && Duration.between(singleDescendTimer, Instant.now()).toMillis() > 1000L)
/*      */         {
/* 1693 */           fullDescending = true;
/* 1694 */           singleDescendCount = 0;
/* 1695 */           singleDescendAdded = true;
/* 1696 */           singleDescendTimer = null;
/*      */         }
/*      */       
/*      */       }
/*      */     } else {
/*      */       
/* 1702 */       singleDescendAdded = false;
/*      */       
/* 1704 */       if ((singleDescendTimer != null || singleDescendCount > 0) && Duration.between(singleDescendTimer, Instant.now()).toMillis() > 1000L) {
/*      */         
/* 1706 */         singleDescendTimer = null;
/* 1707 */         singleDescendCount = 0;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1712 */     if (isDescendingKeyPressed && (!DBCConfig.SingleFormDescendOn || ((fullDescending || singleDescend) && singleDescendAdded))) {
/*      */       
/* 1714 */       singleDescendTimer = null;
/* 1715 */       singleDescendCount = 0;
/* 1716 */       singleDescendAdded = false;
/*      */ 
/*      */ 
/*      */       
/* 1720 */       if (!JRMCoreH.StusEfctsMe(13) && !JRMCoreH.StusEfctsMe(20) && !JRMCoreH.StusEfctsMe(19) && ((JRMCoreH.State2 == 0 && JRMCoreH.State == 0) || (JRMCoreH.State2 == 0 && JRMCoreH.Race == 4 && JRMCoreH.State <= 4)))
/*      */       {
/*      */         
/* 1723 */         JRMCoreH.Rls((byte)0);
/*      */       }
/*      */       
/* 1726 */       JRMCoreH.kiInSuper = 0;
/* 1727 */       ascend = 0;
/* 1728 */       ptime = 0;
/* 1729 */       partnorm = 0;
/* 1730 */       pup = 0;
/*      */       
/* 1732 */       if (JRMCoreH.State2 > 0 || JRMCoreH.State == 7) {
/*      */         
/* 1734 */         soundAsc(3);
/* 1735 */         Dscndng(singleDescend ? -1 : 1);
/*      */       }
/* 1737 */       else if (JRMCoreH.StusEfctsMe(13) || JRMCoreH.StusEfctsMe(20) || JRMCoreH.StusEfctsMe(19)) {
/*      */ 
/*      */         
/* 1740 */         String ar = "jinryuudragonbc:DBC.descend";
/* 1741 */         soundAsc(ar);
/* 1742 */         Dscndng(3);
/*      */       
/*      */       }
/* 1745 */       else if ((JRMCoreH.Race != 4 || (JRMCoreH.Race == 4 && JRMCoreH.State > 4)) && JRMCoreH.PlyrSkillX != null) {
/*      */         
/* 1747 */         if (hasRacialSkillLevel()) {
/*      */           
/* 1749 */           int racialSkillLevel = getClientRacialSkillLevel();
/* 1750 */           if (racialSkillLevel != 0) {
/*      */ 
/*      */             
/* 1753 */             String ar = "jinryuudragonbc:DBC.descend";
/* 1754 */             if (JRMCoreH.rc_sai(JRMCoreH.Race))
/*      */             {
/* 1756 */               ar = "jinryuudragonbc:1610.sse";
/*      */             }
/* 1758 */             soundAsc(ar);
/* 1759 */             Dscndng(singleDescend ? -1 : 1);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   } public static int Vqfj3D(String l) {
/*      */     String w;
/*      */     int a;
/*      */     int i;
/* 1768 */     for (w = "0123456789ABCDEF", l = l.toUpperCase(), a = 0, i = 0; i < l.length(); ) { char c = l.charAt(i); int d = w.indexOf(c); a = 16 * a + d; i++; }  return a;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int gYZc2f() {
/* 1773 */     int b = JRMCoreConfig.tmx; String r = "64", k = "3B9ACA00"; return (b > Vqfj3D(k)) ? Vqfj3D(k) : ((b < Vqfj3D(r)) ? 0 : b);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void triForce(int i, int j, int k) {
/* 1778 */     PD.sendToServer((IMessage)new JRMCorePTri((byte)i, (byte)j, (byte)k));
/*      */   }
/*      */   private static void Ascndng() {
/* 1781 */     int dbcascend = 1;
/* 1782 */     PD.sendToServer((IMessage)new DBCPascend((byte)1));
/*      */   }
/*      */   public static void Dscndng(int i) {
/* 1785 */     PD.sendToServer((IMessage)new DBCPdescend((byte)i));
/*      */   }
/*      */   public static void Dscndng() {
/* 1788 */     int dbcascend = 1;
/* 1789 */     Dscndng(1);
/*      */   }
/*      */   
/* 1792 */   public static void soundAsc(String s) { int e = DBCClient.mc.field_71439_g.func_145782_y();
/* 1793 */     PD.sendToServer((IMessage)new DBCPchargesound(e, s)); } public static void soundAsc(int i) { DBCPascendsound dBCPascendsound; DBCPchargesound dBCPchargesound; DBCPdescendsound dBCPdescendsound2;
/*      */     DBCPduo dBCPduo;
/*      */     DBCPdescendsound dBCPdescendsound1;
/* 1796 */     int dbcascendsound = DBCClient.mc.field_71439_g.func_145782_y();
/*      */     
/* 1798 */     switch (i) {
/*      */       case 1:
/* 1800 */         dBCPascendsound = new DBCPascendsound(dbcascendsound);
/*      */         break;
/*      */       case 2:
/* 1803 */         dBCPchargesound = new DBCPchargesound(dbcascendsound, "jinryuudragonbc:DBC.aura");
/*      */         break;
/*      */       case 3:
/* 1806 */         dBCPdescendsound2 = new DBCPdescendsound(dbcascendsound);
/*      */         break;
/*      */       case 4:
/* 1809 */         dBCPduo = new DBCPduo(300, dbcascendsound);
/*      */         break;
/*      */       default:
/* 1812 */         dBCPdescendsound1 = new DBCPdescendsound(dbcascendsound);
/*      */         break;
/*      */     } 
/*      */     
/* 1816 */     PD.sendToServer((IMessage)dBCPdescendsound1); }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void chargePart(boolean b) {
/* 1822 */     if (JRMCoreClient.mc.func_147113_T())
/*      */       return; 
/* 1824 */     World w = DBCClient.mc.field_71439_g.field_70170_p;
/* 1825 */     for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/* 1826 */       if (JRMCoreH.dnn(19) && JRMCoreH.dnn(2) && JRMCoreH.dnn(1) && JRMCoreH.dnn(5)) {
/* 1827 */         String s = JRMCoreH.StusEfctsClient(pl);
/* 1828 */         String[] st = JRMCoreH.data2[pl].split(";");
/* 1829 */         int k = Integer.parseInt(st[1]);
/* 1830 */         if (s.contains(JRMCoreH.StusEfcts[4]) || s
/* 1831 */           .contains(JRMCoreH.StusEfcts[1]) || s
/* 1832 */           .contains(JRMCoreH.StusEfcts[3]) || s
/* 1833 */           .contains(JRMCoreH.StusEfcts[5]) || s
/* 1834 */           .contains(JRMCoreH.StusEfcts[7])) {
/*      */           
/* 1836 */           EntityPlayer entityPlayer = w.func_72924_a(JRMCoreH.plyrs[pl]);
/* 1837 */           if (entityPlayer instanceof EntityPlayer) {
/*      */             
/* 1839 */             String[] a = JRMCoreH.data1[pl].split(";");
/* 1840 */             int r = Integer.parseInt(a[0]);
/* 1841 */             String[] dat5 = JRMCoreH.data5[pl].split(";");
/* 1842 */             int al = Integer.parseInt(dat5[0]);
/* 1843 */             int kc = Integer.parseInt(dat5[1]);
/* 1844 */             chargePart(entityPlayer, r, al, kc, Integer.parseInt(st[0]), k, b, s);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public static void chargePart(EntityPlayer p, int r, int a, int c, int s, int k, boolean b, String se) {
/* 1851 */     int dbcchargepart = 0;
/* 1852 */     boolean kk = (k > 0 || JRMCoreH.StusEfcts(5, se));
/* 1853 */     boolean l = (JRMCoreH.rc_sai(r) && JRMCoreH.StusEfcts(14, se));
/*      */     
/* 1855 */     boolean ma = JRMCoreH.StusEfcts(12, se);
/* 1856 */     boolean ui = JRMCoreH.StusEfcts(19, se);
/* 1857 */     boolean gd = JRMCoreH.StusEfcts(20, se);
/* 1858 */     boolean auraOn = JRMCoreH.StusEfcts(4, se);
/* 1859 */     boolean auraTransformOn = JRMCoreH.StusEfcts(1, se);
/* 1860 */     boolean turbo = JRMCoreH.StusEfcts(3, se);
/* 1861 */     boolean swoop = JRMCoreH.StusEfcts(7, se);
/*      */     
/* 1863 */     if (!b) {
/*      */       
/* 1865 */       partnorm = 0;
/*      */       
/* 1867 */       if (kk && JRMCoreH.rc_sai(r) && (s == 10 || s == 15)) {
/* 1868 */         dbcchargepart = 9;
/*      */       }
/* 1870 */       else if (kk) {
/* 1871 */         dbcchargepart = 4;
/*      */       }
/* 1873 */       else if ((s > 0 && JRMCoreH.rc_sai(r) && s != 7) || JRMCoreHDBC.godKiUser(r, s)) {
/* 1874 */         dbcchargepart = 2;
/*      */       } else {
/*      */         
/* 1877 */         dbcchargepart = 1;
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1884 */       String ar = "jinryuudragonbc:DBC.aura";
/* 1885 */       if (JRMCoreH.rc_sai(r) && (s == 10 || s == 15)) ar = "jinryuudragonbc:1610.aurab"; 
/* 1886 */       if (JRMCoreH.rc_sai(r) && s != 10 && s != 15 && JRMCoreHDBC.godKiUser(r, s)) ar = "jinryuudragonbc:1610.aurag"; 
/* 1887 */       if (kk && JRMCoreH.rc_sai(r) && (s == 10 || s == 15)) ar = "jinryuudragonbc:1610.aurabk"; 
/* 1888 */       if (gd) ar = "jinryuudragonbc:DBC5.aura_destroyer"; 
/* 1889 */       if (ui) ar = "jinryuudragonbc:DBC5.aura_ui"; 
/* 1890 */       if (JRMCoreH.isRaceMajin(r) && !swoop) {
/* 1891 */         if (!turbo && (auraOn || auraTransformOn)) { ar = "jinryuudragonbc:DBC5.majin_cattle"; }
/* 1892 */         else if (turbo && auraOn && !auraTransformOn)
/* 1893 */         { soundAsc("jinryuudragonbc:DBC5.majin_cattle"); }
/*      */       
/*      */       }
/* 1896 */       soundAsc(ar);
/*      */       
/* 1898 */       if (!JRMCoreH.StusEfcts(3, se) && !JRMCoreH.StusEfcts(7, se))
/*      */       {
/* 1900 */         if (k > 0) {
/* 1901 */           dbcchargepart = 8;
/*      */         }
/* 1903 */         else if (s <= 0 || !JRMCoreH.rc_sai(r) || s != 7 || JRMCoreHDBC.godKiUser(r, s)) {
/* 1904 */           dbcchargepart = 6;
/*      */         } else {
/*      */           
/* 1907 */           dbcchargepart = 5;
/*      */         } 
/*      */       }
/*      */       
/* 1911 */       power = 0;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1916 */     if (dbcchargepart > 0) {
/*      */       EntityAura2 entityAura21, entityAura22;
/* 1918 */       String dbcCharger = p.func_70005_c_();
/* 1919 */       double dbcChargerY = p.field_70163_u;
/* 1920 */       EntityPlayer entityPlayer = p.field_70170_p.func_72924_a(dbcCharger);
/* 1921 */       Random rand = new Random();
/* 1922 */       Entity aura = null;
/* 1923 */       Entity aura2 = null;
/* 1924 */       float state = 0.0F;
/* 1925 */       float state2 = 0.0F;
/* 1926 */       int cr = 0;
/* 1927 */       if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && 
/* 1928 */         JRMCoreH.dnn(2) && 
/* 1929 */         JRMCoreH.dnn(10)) {
/* 1930 */         for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/* 1931 */           if (JRMCoreH.plyrs[pl].equals(dbcCharger)) {
/*      */             
/* 1933 */             String[] states = JRMCoreH.data2[pl].split(";");
/* 1934 */             state = Integer.parseInt(states[0]);
/* 1935 */             state2 = Integer.parseInt(states[1]);
/* 1936 */             cr = Integer.parseInt(JRMCoreH.dat10[pl].split(";")[0]);
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1942 */       c = (c > 0) ? c : JRMCoreH.Algnmnt_rc(a);
/*      */ 
/*      */ 
/*      */       
/* 1946 */       boolean w = (JRMCoreH.StusEfcts(7, se) || (JRMCoreH.StusEfcts(9, se) && JRMCoreH.data(dbcCharger, 3, "0").contains("1") && !JRMCoreH.StusEfctsMe(4)));
/*      */ 
/*      */ 
/*      */       
/* 1950 */       boolean ssg = JRMCoreHDBC.godKiUserBase(r, s);
/* 1951 */       boolean ssb = (JRMCoreH.rc_sai(r) && s == 10);
/* 1952 */       boolean ssbs = (JRMCoreH.rc_sai(r) && s == 15);
/* 1953 */       boolean auf = (JRMCoreH.rc_arc(r) && s == 6);
/*      */ 
/*      */       
/* 1956 */       boolean v = JRMCoreH.StusEfcts(17, se);
/* 1957 */       boolean lsa = JRMCoreH.lgndb(se, r, s);
/*      */ 
/*      */       
/* 1960 */       int sacol = JRMCoreHDBC.getPlayerColor2(2, c, 1, r, s, v, lsa, ui, gd);
/* 1961 */       state = (ssg || ssb) ? 0.0F : state;
/* 1962 */       state = ssbs ? 3.0F : state;
/* 1963 */       boolean oozar = (JRMCoreH.rc_sai(r) && (state == 7.0F || state == 8.0F));
/* 1964 */       state = oozar ? (state * 3.0F) : state;
/* 1965 */       state = (JRMCoreH.rc_nam(r) && state == 2.0F) ? 22.0F : state;
/*      */ 
/*      */       
/* 1968 */       boolean plyrSP = (DBCClient.mc.field_71439_g.func_70005_c_().equals(dbcCharger) && DBCClient.mc.field_71474_y.field_74320_O == 0);
/*      */       
/* 1970 */       if (dbcchargepart >= 1 && dbcchargepart <= 4) entityAura21 = new EntityAura2(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : sacol, state, state2, cr, w); 
/* 1971 */       if (dbcchargepart >= 5 && dbcchargepart <= 8 && !ui && !gd) EntityAuraRing entityAuraRing = new EntityAuraRing(p.field_70170_p, dbcCharger, (state2 > 0.0F) ? 16646144 : sacol, state, state2, cr); 
/* 1972 */       if (dbcchargepart == 9) { entityAura21 = new EntityAura2(p.field_70170_p, dbcCharger, sacol, 0.0F, 0.0F, cr, w);
/* 1973 */         if (state2 > 0.0F) entityAura22 = new EntityAura2(p.field_70170_p, dbcCharger, 16646144, 2.0F + state, state2 * 1.5F, cr, w);  }
/*      */       
/* 1975 */       if (entityAura21 != null && entityPlayer != null) {
/*      */         
/* 1977 */         if (entityAura21 instanceof EntityAura2)
/*      */         {
/* 1979 */           if (ssg) {
/*      */             
/* 1981 */             entityAura21.setAlp(plyrSP ? 0.05F : 0.2F);
/* 1982 */             entityAura21.setTex("aurai");
/* 1983 */             entityAura21.setTexL2("aurai2");
/* 1984 */             entityAura21.setColL2(16747301);
/*      */           }
/* 1986 */           else if (ssbs && v) {
/* 1987 */             entityAura21.setSpd(30);
/* 1988 */             entityAura21.setAlp(plyrSP ? 0.05F : 0.2F);
/* 1989 */             entityAura21.setTex("aurai");
/* 1990 */             entityAura21.setTexL2("aurai2");
/* 1991 */             entityAura21.setColL2(8592109);
/*      */           }
/* 1993 */           else if (ssbs) {
/* 1994 */             entityAura21.setSpd(40);
/* 1995 */             entityAura21.setAlp(plyrSP ? 0.05F : 0.5F);
/* 1996 */             entityAura21.setTex("aurag");
/* 1997 */             entityAura21.setColL3(12310271);
/* 1998 */             entityAura21.setTexL3("auragb");
/*      */           }
/* 2000 */           else if (ssb && v) {
/* 2001 */             entityAura21.setSpd(30);
/* 2002 */             entityAura21.setAlp(plyrSP ? 0.05F : 0.2F);
/* 2003 */             entityAura21.setTex("aurai");
/* 2004 */             entityAura21.setTexL2("aurai2");
/* 2005 */             entityAura21.setColL2(7872713);
/*      */           }
/* 2007 */           else if (ssb) {
/* 2008 */             entityAura21.setSpd(40);
/* 2009 */             entityAura21.setAlp(plyrSP ? 0.05F : 0.5F);
/* 2010 */             entityAura21.setTex("aurag");
/* 2011 */             entityAura21.setColL3(15727354);
/* 2012 */             entityAura21.setTexL3("auragb");
/*      */           }
/* 2014 */           else if (auf) {
/*      */             
/* 2016 */             entityAura21.setAlp(plyrSP ? 0.05F : 0.5F);
/* 2017 */             entityAura21.setTex("aurau");
/* 2018 */             entityAura21.setTexL2("aurau2");
/* 2019 */             entityAura21.setColL2(16776724);
/*      */           }
/* 2021 */           else if (ui) {
/* 2022 */             entityAura21.setSpd(100);
/* 2023 */             entityAura21.setAlp(plyrSP ? 0.005F : 0.15F);
/* 2024 */             entityAura21.setTex("auras");
/* 2025 */             entityAura21.setCol(15790320);
/* 2026 */             entityAura21.setColL3(4746495);
/* 2027 */             entityAura21.setTexL3("auragb");
/*      */           }
/* 2029 */           else if (gd) {
/* 2030 */             entityAura21.setSpd(30);
/* 2031 */             entityAura21.setAlp(plyrSP ? 0.05F : 0.2F);
/* 2032 */             entityAura21.setTex("aurag");
/* 2033 */             entityAura21.setTexL3("auragb");
/* 2034 */             entityAura21.setColL2(12464847);
/*      */           } else {
/*      */             
/* 2037 */             entityAura21.setAlp(plyrSP ? 0.05F : 0.2F);
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/* 2042 */         if (entityAura21 != null && entityAura21 instanceof EntityAura2) {
/*      */           
/* 2044 */           entityAura21.setBol(JRMCoreH.StusEfcts(1, se));
/* 2045 */           entityAura21.setBol2(JRMCoreH.StusEfcts(4, se));
/* 2046 */           entityAura21.setBol3(JRMCoreH.StusEfcts(3, se));
/*      */           
/* 2048 */           entityAura21.setBol4((ui && !gd));
/* 2049 */           boolean Bol4a = (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) ? JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[JRMCoreH.state2UltraInstinct(!ui, (byte)(int)state2)] : false;
/* 2050 */           entityAura21.setBol4a(Bol4a);
/*      */ 
/*      */           
/* 2053 */           int bol6 = gd ? 6 : (ssg ? 0 : ((v && ssb) ? 3 : ((v && ssbs) ? 5 : (ssb ? 1 : (ssbs ? 2 : (auf ? 4 : -1))))));
/*      */           
/* 2055 */           if (ui) bol6 = 0; 
/* 2056 */           entityAura21.setBol6(bol6);
/*      */           
/* 2058 */           entityAura21.setBol7((ma || kk));
/* 2059 */           entityAura21.kettleMode = (byte)((JRMCoreH.isRaceMajin(r) && (auraOn || auraTransformOn) && !swoop) ? ((turbo || auraTransformOn || kk) ? 2 : 1) : 0);
/*      */         } 
/*      */ 
/*      */         
/* 2063 */         p.field_70170_p.func_72838_d((Entity)entityAura21);
/*      */       } 
/*      */       
/* 2066 */       if (entityAura22 != null && entityPlayer != null) {
/*      */         
/* 2068 */         if (entityAura22 instanceof EntityAura2) {
/* 2069 */           entityAura22.setSpd(40);
/* 2070 */           entityAura22.setAlp(plyrSP ? 0.025F : 0.3F);
/* 2071 */           entityAura22.setTex("aurak");
/* 2072 */           entityAura22.setInner(false);
/* 2073 */           entityAura22.setRendPass(0);
/*      */         } 
/* 2075 */         entityAura22.func_70012_b(((Entity)entityPlayer).field_70165_t - 0.0D, ((Entity)entityPlayer).field_70163_u - 2.0D + rand.nextInt(5) * 0.03D, ((Entity)entityPlayer).field_70161_v - 0.0D, rand.nextFloat(), 0.0F);
/* 2076 */         p.field_70170_p.func_72838_d((Entity)entityAura22);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/* 2081 */   public static HashMap<String, EntityAura2> ra = new HashMap<String, EntityAura2>();
/*      */ 
/*      */   
/*      */   private static int getClientRacialSkillLevel() {
/* 2085 */     return Integer.parseInt(JRMCoreH.PlyrSkillX.replaceAll("TR", ""));
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean canAttemptTransformation() {
/* 2090 */     return (JRMCoreH.PlyrSkillX != null && JRMCoreH.curEnergy > 1);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean hasRacialSkillLevel() {
/* 2095 */     return JRMCoreH.PlyrSkillX.contains("TR");
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean isClientMoving() {
/* 2100 */     if (holdingForTransform)
/*      */     {
/* 2102 */       return DBCConfig.MoveWhileTransforming ? false : (!JGMathHelper.isMotionSmallerThanN((Entity)DBCClient.mc.field_71439_g, 0.05D, true, false, true, true));
/*      */     }
/*      */ 
/*      */     
/* 2106 */     return DBCConfig.MoveWhileInstantTransforming ? false : (!JGMathHelper.isMotionSmallerThanN((Entity)DBCClient.mc.field_71439_g, 0.05D, true, false, true, true));
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCKiTech.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */