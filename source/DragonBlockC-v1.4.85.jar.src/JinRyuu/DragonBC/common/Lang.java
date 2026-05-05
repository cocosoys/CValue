/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ public class Lang
/*    */ {
/*  7 */   public String BigBangName = StatCollector.func_74838_a("dbc.KABigBang.name");
/*  8 */   public String BlastName = StatCollector.func_74838_a("dbc.KABlast.name");
/*  9 */   public String BurningAttName = StatCollector.func_74838_a("dbc.KABurningAtt.name");
/* 10 */   public String DeathBeamName = StatCollector.func_74838_a("dbc.KADeathBeam.name");
/* 11 */   public String DodonName = StatCollector.func_74838_a("dbc.KADodon.name");
/* 12 */   public String EnergyDiskName = StatCollector.func_74838_a("dbc.KAEnergyDisk.name");
/* 13 */   public String FinalFlashName = StatCollector.func_74838_a("dbc.KAFinalFlash.name");
/* 14 */   public String FingerLeserName = StatCollector.func_74838_a("dbc.KAFingerLeser.name");
/* 15 */   public String GalicGunName = StatCollector.func_74838_a("dbc.KAGalicGun.name");
/* 16 */   public String HameName = StatCollector.func_74838_a("dbc.KAHame.name");
/* 17 */   public String Hame10xName = StatCollector.func_74838_a("dbc.KAHame10x.name");
/* 18 */   public String MakankoName = StatCollector.func_74838_a("dbc.KAMakanko.name");
/* 19 */   public String MasenkoName = StatCollector.func_74838_a("dbc.KAMasenko.name");
/* 20 */   public String PlanetDestName = StatCollector.func_74838_a("dbc.KAPlanetDest.name");
/* 21 */   public String SpiritbombName = StatCollector.func_74838_a("dbc.KASpiritbomb.name");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void init() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String KAName(int par1) {
/* 34 */     String ret = "";
/* 35 */     int selct = par1;
/* 36 */     if (selct == 1) ret = this.BigBangName; 
/* 37 */     if (selct == 2) ret = this.BlastName; 
/* 38 */     if (selct == 3) ret = this.BurningAttName; 
/* 39 */     if (selct == 4) ret = this.DeathBeamName; 
/* 40 */     if (selct == 5) ret = this.DodonName; 
/* 41 */     if (selct == 6) ret = this.EnergyDiskName; 
/* 42 */     if (selct == 7) ret = this.FinalFlashName; 
/* 43 */     if (selct == 8) ret = this.FingerLeserName; 
/* 44 */     if (selct == 9) ret = this.GalicGunName; 
/* 45 */     if (selct == 10) ret = this.HameName; 
/* 46 */     if (selct == 11) ret = this.Hame10xName; 
/* 47 */     if (selct == 12) ret = this.MakankoName; 
/* 48 */     if (selct == 13) ret = this.MasenkoName; 
/* 49 */     if (selct == 14) ret = this.PlanetDestName; 
/* 50 */     if (selct == 15) ret = this.SpiritbombName; 
/* 51 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Lang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */