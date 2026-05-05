/*    */ package JinRyuu.JRMCore.server.config.dbc;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormMastery
/*    */ {
/*  9 */   public ArrayList<Object[]> data = new ArrayList();
/*    */ 
/*    */   
/*    */   public void addData(Object... data) {
/* 13 */     this.data.add(data);
/*    */   }
/*    */   
/*    */   public String getString(int arrayID, int dataID) {
/* 17 */     if (this.data.size() > arrayID && ((Object[])this.data.get(arrayID)).length > dataID) {
/* 18 */       return (String)((Object[])this.data.get(arrayID))[dataID];
/*    */     }
/* 20 */     return "";
/*    */   }
/*    */   
/*    */   public double getDouble(int arrayID, int dataID) {
/* 24 */     if (this.data.size() > arrayID && ((Object[])this.data.get(arrayID)).length > dataID) {
/* 25 */       String[] doubleData = (String[])this.data.get(arrayID);
/* 26 */       return Double.parseDouble(doubleData[dataID]);
/*    */     } 
/* 28 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\dbc\FormMastery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */