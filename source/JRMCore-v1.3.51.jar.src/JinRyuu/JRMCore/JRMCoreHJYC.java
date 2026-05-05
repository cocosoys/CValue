/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import JinRyuu.JYearsC.JYearsCConfig;
/*    */ import JinRyuu.JYearsC.JYearsCItems;
/*    */ import JinRyuu.JYearsC.mod_JYearsC;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class JRMCoreHJYC {
/*    */   public static void openGui(int id, EntityPlayer pl) {
/* 11 */     pl.openGui(mod_JYearsC.instance, id, pl.field_70170_p, (int)pl.field_70165_t, (int)pl.field_70163_u, (int)pl.field_70161_v);
/*    */   }
/*    */   
/*    */   public static int JYCgetConfigcpgut() {
/* 15 */     return JYearsCConfig.cpgut;
/*    */   }
/*    */   public static float JYCAge(EntityPlayer plyr) {
/* 18 */     float yc = 100.0F;
/* 19 */     if (JYearsCH.p != null && 
/* 20 */       JYearsCH.p.length > 0) {
/* 21 */       int id = 0;
/* 22 */       for (String n : JYearsCH.p) {
/* 23 */         String[] m = n.split(";");
/* 24 */         if (plyr.func_70005_c_().equals(m[0])) {
/* 25 */           yc = Float.parseFloat(m[1]);
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 33 */         id++;
/*    */       } 
/*    */     } 
/*    */     
/* 37 */     return yc;
/*    */   }
/*    */   public static float JYCsizeBasedOnAge(EntityPlayer plyr) {
/* 40 */     float yc = 1.0F;
/* 41 */     if (JYearsCH.p != null && 
/* 42 */       JYearsCH.p.length > 0) {
/* 43 */       for (String n : JYearsCH.p) {
/* 44 */         String[] m = n.split(";");
/* 45 */         if (plyr.func_70005_c_().equals(m[0])) {
/* 46 */           float A = Float.parseFloat(m[1]);
/* 47 */           float gu = JYearsCConfig.pgut;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 53 */           if (A <= 5.0F) yc = 0.5F; 
/* 54 */           if (A > 5.0F && A <= gu) yc = 0.5F + (A - 5.0F) / (gu - 5.0F) * 0.5F; 
/* 55 */           if (A > gu) yc = 1.0F; 
/* 56 */           yc = (yc < 0.5531915F) ? 0.5531915F : yc;
/*    */         } 
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/* 62 */     String[] state = JRMCoreH.data(plyr.func_70005_c_(), 2, "0;0").split(";");
/* 63 */     String[] s = JRMCoreH.data(plyr.func_70005_c_(), 1, "0;0;0;0;0;0").split(";");
/* 64 */     int pwr = Integer.parseInt(s[2]);
/* 65 */     int race = Integer.parseInt(s[0]);
/* 66 */     int State = (pwr == 2 || race == 0) ? 0 : Integer.parseInt(state[0]);
/* 67 */     boolean saiOozar = JRMCoreH.rSai(race) ? ((State == 7 || State == 8)) : false;
/* 68 */     boolean ssj4 = JRMCoreH.rSai(race) ? ((State == 14)) : false;
/* 69 */     return ssj4 ? 1.0F : (saiOozar ? 1.0F : yc);
/*    */   }
/*    */   public static void JYCsetConfigpgut(int pgut) {
/* 72 */     JYearsCConfig.pgut = pgut;
/*    */   }
/*    */   public static Item JYCgetItemWatch() {
/* 75 */     return JYearsCItems.ItemWatch;
/*    */   }
/*    */   public static int JYCgetConfigpls() {
/* 78 */     return JYearsCConfig.pls;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreHJYC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */