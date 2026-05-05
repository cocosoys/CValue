/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ 
/*     */ public class JRMCEnAttacks
/*     */ {
/*   9 */   public static int maxChrgLmt = 200;
/*  10 */   public static int maxChrgcnt = 20;
/*     */   
/*  12 */   public static double motX = 0.5D;
/*  13 */   public static double motY = 0.01D;
/*  14 */   public static double motZ = 0.5D;
/*     */ 
/*     */   
/*  17 */   public static int time2 = 2;
/*  18 */   public static int time40 = 40;
/*  19 */   public static int time50 = 50;
/*  20 */   public static int time70 = 70;
/*  21 */   public static int time100 = 120;
/*  22 */   public static int time120 = 200;
/*     */ 
/*     */ 
/*     */   
/*  26 */   public static int BigBangCosts = 20;
/*  27 */   public static String BigBangHeart = "7,5";
/*  28 */   public static double BigBangDam = 15.0D;
/*  29 */   public static float BigBangExpl = 5.0F;
/*  30 */   public static String BigBangExplSound = "jinryuudragonbc:DBC.expl";
/*  31 */   public static String BigBangAirSound = "jinryuudragonbc:DBC.hafire";
/*  32 */   public static String BigBangFired = "jinryuudragonbc:DBC2.bigbang_fire";
/*  33 */   public static String BigBangCharg = "jinryuudragonbc:DBC3.cbigbang";
/*     */ 
/*     */   
/*  36 */   public static int BurningAttCosts = 15;
/*  37 */   public static String BurningAttHeart = "7,5";
/*  38 */   public static double BurningAttDam = 13.0D;
/*  39 */   public static float BurningAttExpl = 3.0F;
/*  40 */   public static String BurningAttExplSound = "jinryuudragonbc:DBC.expl";
/*  41 */   public static String BurningAttAirSound = "jinryuudragonbc:DBC.hafire";
/*  42 */   public static String BurningAttFired = "jinryuudragonbc:DBC3.fburning";
/*  43 */   public static String BurningAttFired2 = "jinryuudragonbc:DBC3.ffburning";
/*  44 */   public static String BurningAttCharg = "jinryuudragonbc:DBC3.cburning";
/*     */ 
/*     */   
/*  47 */   public static int BlastCosts = 3;
/*  48 */   public static String BlastHeart = "1";
/*  49 */   public static double BlastDam = 2.0D;
/*  50 */   public static float BlastExpl = 0.0F;
/*  51 */   public static String BlastExplSound = "";
/*  52 */   public static String BlastAirSound = "jinryuudragonbc:DBC.hafire";
/*  53 */   public static String BlastFired = "jinryuudragonbc:DBC2.blast";
/*  54 */   public static String BlastCharg = "";
/*     */ 
/*     */   
/*  57 */   public static int DeathBeamCosts = 8;
/*  58 */   public static String DeathBeamHeart = "5,5";
/*  59 */   public static double DeathBeamDam = 5.0D;
/*  60 */   public static float DeathBeamExpl = 2.0F;
/*  61 */   public static String DeathBeamExplSound = "jinryuudragonbc:DBC.expl";
/*  62 */   public static String DeathBeamAirSound = "jinryuudragonbc:DBC.hafire";
/*  63 */   public static String DeathBeamFired = "jinryuudragonbc:DBC2.basicbeam_fire";
/*  64 */   public static String DeathBeamCharg = "";
/*     */ 
/*     */   
/*  67 */   public static int DodonCosts = 5;
/*  68 */   public static String DodonHeart = "2";
/*  69 */   public static double DodonDam = 4.0D;
/*  70 */   public static float DodonExpl = 0.0F;
/*  71 */   public static String DodonExplSound = "";
/*  72 */   public static String DodonAirSound = "";
/*  73 */   public static String DodonFired = "jinryuudragonbc:DBC2.kiball_release";
/*  74 */   public static String DodonCharg = "";
/*     */ 
/*     */   
/*  77 */   public static int EnergyDiskCosts = 10;
/*  78 */   public static String EnergyDiskHeart = "4";
/*  79 */   public static double EnergyDiskDam = 8.0D;
/*  80 */   public static float EnergyDiskExpl = 0.0F;
/*  81 */   public static String EnergyDiskExplSound = "";
/*  82 */   public static String EnergyDiskAirSound = "";
/*  83 */   public static String EnergyDiskFired = "jinryuudragonbc:DBC2.disc_fire";
/*  84 */   public static String EnergyDiskCharg = "jinryuudragonbc:DBC3.ckidisc";
/*     */ 
/*     */   
/*  87 */   public static int FinalFlashCosts = 16;
/*  88 */   public static String FinalFlashHeart = "9";
/*  89 */   public static double FinalFlashDam = 9.0D;
/*  90 */   public static float FinalFlashExpl = 7.0F;
/*  91 */   public static String FinalFlashExplSound = "jinryuudragonbc:DBC.expl";
/*  92 */   public static String FinalFlashAirSound = "jinryuudragonbc:DBC.hafire";
/*  93 */   public static String FinalFlashFired = "jinryuudragonbc:DBC3.ffinalflash";
/*  94 */   public static String FinalFlashCharg = "jinryuudragonbc:DBC2.finalflash_charge";
/*     */ 
/*     */   
/*  97 */   public static int FingerLeserCosts = 6;
/*  98 */   public static String FingerLeserHeart = "2,5";
/*  99 */   public static double FingerLeserDam = 5.0D;
/* 100 */   public static float FingerLeserExpl = 0.0F;
/* 101 */   public static String FingerLeserExplSound = "";
/* 102 */   public static String FingerLeserAirSound = "";
/* 103 */   public static String FingerLeserFired = "jinryuudragonbc:DBC3.fingerleser";
/* 104 */   public static String FingerLeserCharg = "";
/*     */ 
/*     */   
/* 107 */   public static int GalicGunCosts = 9;
/* 108 */   public static String GalicGunHeart = "6";
/* 109 */   public static double GalicGunDam = 6.0D;
/* 110 */   public static float GalicGunExpl = 5.0F;
/* 111 */   public static String GalicGunExplSound = "jinryuudragonbc:DBC.expl";
/* 112 */   public static String GalicGunAirSound = "jinryuudragonbc:DBC.hafire";
/* 113 */   public static String GalicGunFired = "jinryuudragonbc:DBC3.fgallitgun";
/* 114 */   public static String GalicGunCharg = "jinryuudragonbc:DBC3.cgallitgun";
/*     */ 
/*     */   
/* 117 */   public static int KameHameCosts = 8;
/* 118 */   public static String KameHameHeart = "5";
/* 119 */   public static double KameHameDam = 5.0D;
/* 120 */   public static float KameHameExpl = 4.0F;
/* 121 */   public static String KameHameExplSound = "jinryuudragonbc:DBC.expl";
/* 122 */   public static String KameHameAirSound = "jinryuudragonbc:DBC.hafire";
/* 123 */   public static String KameHameFired = "jinryuudragonbc:DBC.ha";
/* 124 */   public static String KameHameCharg = "jinryuudragonbc:DBC.hame";
/*     */ 
/*     */   
/* 127 */   public static int KameHame10xCosts = 19;
/* 128 */   public static String KameHame10xHeart = "12,5";
/* 129 */   public static double KameHame10xDam = 10.0D;
/* 130 */   public static float KameHame10xExpl = 10.0F;
/* 131 */   public static String KameHame10xExplSound = "jinryuudragonbc:DBC.expl";
/* 132 */   public static String KameHame10xAirSound = "jinryuudragonbc:DBC.hafire";
/* 133 */   public static String KameHame10xFired = "jinryuudragonbc:DBC.ha10x";
/* 134 */   public static String KameHame10xCharg = "jinryuudragonbc:DBC.hame";
/*     */ 
/*     */   
/* 137 */   public static int MakankoCosts = 11;
/* 138 */   public static String MakankoHeart = "7,5";
/* 139 */   public static double MakankoDam = 7.0D;
/* 140 */   public static float MakankoExpl = 4.0F;
/* 141 */   public static String MakankoExplSound = "jinryuudragonbc:DBC.expl";
/* 142 */   public static String MakankoAirSound = "jinryuudragonbc:DBC.hafire";
/* 143 */   public static String MakankoFired = "jinryuudragonbc:DBC3.fspecialbeamcannon";
/* 144 */   public static String MakankoCharg = "jinryuudragonbc:DBC3.cspecialbeamcannon";
/*     */ 
/*     */   
/* 147 */   public static int MasenkoCosts = 9;
/* 148 */   public static String MasenkoHeart = "5";
/* 149 */   public static double MasenkoDam = 5.0D;
/* 150 */   public static float MasenkoExpl = 2.0F;
/* 151 */   public static String MasenkoExplSound = "jinryuudragonbc:DBC.expl";
/* 152 */   public static String MasenkoAirSound = "jinryuudragonbc:DBC.hafire";
/* 153 */   public static String MasenkoFired = "jinryuudragonbc:DBC3.fmasenko";
/* 154 */   public static String MasenkoCharg = "jinryuudragonbc:DBC3.cmasenko";
/*     */ 
/*     */   
/* 157 */   public static int PlanetDestCosts = 100;
/* 158 */   public static String PlanetDestHeart = "25";
/* 159 */   public static double PlanetDestDam = 50.0D;
/* 160 */   public static float PlanetDestExpl = 17.0F;
/* 161 */   public static String PlanetDestExplSound = "jinryuudragonbc:DBC.expl";
/* 162 */   public static String PlanetDestAirSound = "";
/* 163 */   public static String PlanetDestFired = "jinryuudragonbc:DBC2.deathball_fire";
/* 164 */   public static String PlanetDestCharg = "jinryuudragonbc:DBC2.deathball_charge";
/*     */ 
/*     */   
/* 167 */   public static int SpiritBombCosts = 80;
/* 168 */   public static String SpiritBombHeart = "25";
/* 169 */   public static double SpiritBombDam = 50.0D;
/* 170 */   public static float SpiritBombExpl = 15.0F;
/* 171 */   public static String SpiritBombExplSound = "jinryuudragonbc:DBC.expl";
/* 172 */   public static String SpiritBombAirSound = "";
/* 173 */   public static String SpiritBombFired = "jinryuudragonbc:DBC3.fspiritbomb";
/* 174 */   public static String SpiritBombCharg = "jinryuudragonbc:DBC3.cspiritbomb";
/*     */ 
/*     */   
/* 177 */   public static int PunchCosts = 10;
/* 178 */   public static double PunchDam = 15.0D;
/* 179 */   public static float PunchExpl = 5.0F;
/* 180 */   public static String PunchExplSound = "jinryuudragonbc:DBC2.strongpunch";
/* 181 */   public static String PunchAirSound = "jinryuudragonbc:DBC2.hafire";
/* 182 */   public static String PunchFired = "jinryuudragonbc:DBC2.strongpunch";
/* 183 */   public static String PunchCharg = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double explosionX;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double explosionY;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double explosionZ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float explosionSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List chunkPositionRecords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float playerVelocityX;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float playerVelocityY;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float playerVelocityZ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void KASlct() {
/* 269 */     int selct = 1; if (JRMCoreH.KABigBang == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 270 */      selct = 2; if (JRMCoreH.KABlast == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 271 */      selct = 3; if (JRMCoreH.KABurningAtt == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 272 */      selct = 4; if (JRMCoreH.KADeathBeam == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 273 */      selct = 5; if (JRMCoreH.KADodon == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 274 */      selct = 6; if (JRMCoreH.KAEnergyDisk == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 275 */      selct = 7; if (JRMCoreH.KAFinalFlash == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 276 */      selct = 8; if (JRMCoreH.KAFingerLaser == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 277 */      selct = 9; if (JRMCoreH.KAGalicGun == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 278 */      selct = 10; if (JRMCoreH.KAKameHame == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 279 */      selct = 11; if (JRMCoreH.KAKameHame10x == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 280 */      selct = 12; if (JRMCoreH.KAMakanko == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 281 */      selct = 13; if (JRMCoreH.KAMasenko == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 282 */      selct = 14; if (JRMCoreH.KAPlanetDest == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 283 */      selct = 15; if (JRMCoreH.KASpiritBomb == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 284 */      selct = 16; if (JRMCoreH.KTKaioken == 1 && JRMCoreH.KASelected < selct) { JRMCoreH.KASelected = selct; return; }
/* 285 */      selct = 0; if (JRMCoreH.KASelected > selct) { JRMCoreH.KASelected = selct;
/*     */       return; }
/*     */   
/*     */   } public static boolean KAkiEn(EntityPlayer thePlayer) {
/* 289 */     int explevel = JRMCoreH.kiAscPow;
/* 290 */     if (JRMCoreH.armTypSS1On(thePlayer)) {
/* 291 */       explevel *= 2;
/*     */     }
/* 293 */     if (JRMCoreH.armTypSS2On(thePlayer)) {
/* 294 */       explevel *= 3;
/*     */     }
/* 296 */     if (JRMCoreH.armTypSS3On(thePlayer)) {
/* 297 */       explevel *= 4;
/*     */     }
/*     */ 
/*     */     
/* 301 */     int evil = JRMCoreH.dbcEvilness;
/* 302 */     double evl2 = (100 - evil) * 0.01D;
/* 303 */     double good2 = evil * 0.01D;
/* 304 */     double evl = evl2 + 0.2D;
/* 305 */     double good = good2 + 0.2D;
/* 306 */     double neu = 1.0D - ((good2 - evl2 < 0.0D) ? ((good2 - evl2) * -1.0D) : (good2 - evl2)) + 0.2D;
/* 307 */     double ret = 0.0D;
/*     */     
/* 309 */     int selct = JRMCoreH.KASelected;
/*     */     
/* 311 */     double cost = 0.0D;
/* 312 */     int maxki = JRMCoreH.kiMax;
/*     */     
/* 314 */     if (selct == 1) { cost = (int)(explevel * neu * BigBangCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 315 */      if (selct == 2) { cost = (explevel * BlastCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 316 */      if (selct == 3) { cost = (int)(explevel * good * BurningAttCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 317 */      if (selct == 4) { cost = (int)(explevel * evl * DeathBeamCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 318 */      if (selct == 5) { cost = (int)(explevel * neu * DodonCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 319 */      if (selct == 6) { cost = (explevel * EnergyDiskCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 320 */      if (selct == 7) { cost = (int)(explevel * neu * FinalFlashCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 321 */      if (selct == 8) { cost = (int)(explevel * evl * FingerLeserCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 322 */      if (selct == 9) { cost = (int)(explevel * neu * GalicGunCosts); if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false;  }
/* 323 */      if (selct == 10) cost = (int)(explevel * good * KameHameCosts);  if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false; 
/* 324 */     if (selct == 11) cost = (int)(explevel * good * KameHame10xCosts);  if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false; 
/* 325 */     if (selct == 12) cost = (int)(explevel * neu * MakankoCosts);  if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false; 
/* 326 */     if (selct == 13) cost = (int)(explevel * good * MasenkoCosts);  if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false; 
/* 327 */     if (selct == 14) cost = (int)(explevel * evl * PlanetDestCosts);  if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false; 
/* 328 */     if (selct == 15) cost = (int)(explevel * good * SpiritBombCosts);  if (JRMCoreH.kiAmount < (((int)cost > maxki) ? (int)(maxki * 0.9D) : (int)cost) + JRMCoreH.minKi) return false; 
/* 329 */     if (selct == 16 && JRMCoreH.kiAmount < 1) return false; 
/* 330 */     if (selct == 0) return false;
/*     */     
/* 332 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCEnAttacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */