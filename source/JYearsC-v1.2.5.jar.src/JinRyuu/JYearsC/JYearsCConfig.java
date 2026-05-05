/*    */ package JinRyuu.JYearsC;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ import net.minecraftforge.common.config.Property;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JYearsCConfig
/*    */ {
/*    */   public static int ItemWatchID;
/*    */   public static int pls;
/*    */   public static int pgut;
/*    */   public static int cpls;
/*    */   public static int cpgut;
/*    */   
/*    */   public static void init(Configuration config) {
/* 20 */     config.load();
/*    */     
/* 22 */     ItemWatchID = config.get("item", "ItemWatchID", 9088).getInt();
/*    */     
/* 24 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*    */     
/* 26 */     Property ls = config.get("general", "Players Life Spawn in Minecraft Days", 450);
/* 27 */     ls.comment = "Server Sided! Players Life Spawn in Minecraft Days, where 1 MC Day is 20 minutes. Between 20 and 1000000";
/* 28 */     cpls = ls.getInt(450);
/* 29 */     cpls = (cpls < 20) ? 20 : ((cpls > 1000000) ? 1000000 : cpls);
/* 30 */     pls = cpls;
/* 31 */     Property GUT = config.get("general", "Players Grow up time in Minecraft Days", 52);
/* 32 */     GUT.comment = "Server Sided! Players Grow up time in Minecraft Days, where 1 MC Day is 20 minutes. Between 10 and 100000";
/* 33 */     cpgut = GUT.getInt(52);
/* 34 */     cpgut = (cpgut < 10) ? 10 : ((cpgut > 100000) ? 100000 : cpgut);
/* 35 */     pgut = cpgut;
/*    */     
/* 37 */     config.save();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsCConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */