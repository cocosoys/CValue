/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class JRMCoreA
/*    */ {
/*  9 */   public static Map<Integer, Object> actions = new HashMap<Integer, Object>();
/* 10 */   public static Map<Integer, Object> actionsDBC = new HashMap<Integer, Object>();
/* 11 */   public static Map<Integer, Object> actionsNC = new HashMap<Integer, Object>();
/*    */   public static void actionInit() {
/* 13 */     if (JRMCoreH.DBC())
/*    */     {
/* 15 */       JRMCoreHDBC.actionInitDBC();
/*    */     }
/* 17 */     if (JRMCoreH.NC())
/*    */     {
/* 19 */       JRMCoreHNC.actionInit();
/*    */     }
/*    */   }
/*    */   
/*    */   public static boolean pwr_usrs(int p) {
/* 24 */     return (p == 1 || p == 2);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */