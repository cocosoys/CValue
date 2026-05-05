/*    */ package JinRyuu.JRMCore.entity.aai;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AAi
/*    */ {
/*    */   public AAiSystem aaiSystem;
/*    */   
/*    */   public void update() {}
/*    */   
/*    */   public boolean checkChanceToUse(double rate) {
/* 15 */     if (rate >= 1.0D) return true; 
/* 16 */     if (rate <= 0.0D) return false; 
/* 17 */     return ((new Random()).nextInt(100) < (int)(rate * 100.0D));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\aai\AAi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */