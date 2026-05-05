/*    */ package JinRyuu.FamilyC;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ import net.minecraftforge.common.config.Property;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FamilyCConfig
/*    */ {
/*    */   public static int ItemWatchID;
/*    */   public static int cls;
/*    */   public static int gut;
/*    */   public static int pt;
/*    */   public static int mc;
/*    */   public static boolean dcr;
/*    */   public static int ccls;
/*    */   public static int cgut;
/*    */   public static int cpt;
/*    */   public static int cmc;
/*    */   public static boolean cdcr;
/*    */   
/*    */   public static void init(Configuration config) {
/* 28 */     config.load();
/*    */     
/* 30 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*    */     
/* 32 */     Property ls = config.get("general", "Child Life-span in Minecraft Days", 450);
/* 33 */     ls.comment = "Server Sided! Child Life-span in Minecraft Days, where 1 is for 1 MC Day that is 20 minutes. Between 20 and 1000000";
/* 34 */     ccls = ls.getInt(450);
/* 35 */     ccls = (ccls < 20) ? 20 : ((ccls > 1000000) ? 1000000 : ccls);
/* 36 */     cls = ccls;
/* 37 */     Property GUT = config.get("general", "Child Grow up time in Minecraft Days", 52);
/* 38 */     GUT.comment = "Server Sided! Child Grow up time in Minecraft Days, where 1 is for 1 MC Day that is 20 minutes. Between 10 and 100000";
/* 39 */     cgut = GUT.getInt(52);
/* 40 */     cgut = (cgut < 10) ? 10 : ((cgut > 100000) ? 100000 : cgut);
/* 41 */     gut = cgut;
/* 42 */     Property PT = config.get("general", "Pregnancy Time", 4);
/* 43 */     PT.comment = "Server Sided! Pregnancy time where 1 is for half MC Day that is 10 minutes. Between 1 and 50";
/* 44 */     cpt = PT.getInt(52);
/* 45 */     cpt = (cpt < 1) ? 1 : ((cpt > 50) ? 50 : cpt);
/* 46 */     pt = cpt;
/* 47 */     Property MC = config.get("general", "Max Children", 4);
/* 48 */     MC.comment = "Server Sided! Max children one can have, both for players and admins. Berween 0 and 10";
/* 49 */     cmc = MC.getInt(10);
/* 50 */     cmc = (cmc < 0) ? 0 : ((cmc > 10) ? 10 : cmc);
/* 51 */     mc = cmc;
/* 52 */     MC = config.get("general", "Disable & Remove Children", false);
/* 53 */     MC.comment = "Server Sided! 'true' means all children in the world will get removed and will disable procreation. By defeault this config is disabled (default: false)";
/* 54 */     cdcr = MC.getBoolean();
/* 55 */     dcr = cdcr;
/*    */     
/* 57 */     config.save();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyCConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */