/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class FamilyCDataThread
/*    */   extends Thread {
/*    */   public boolean run = true;
/*    */   
/*    */   public void run() {
/* 10 */     while (this.run) {
/* 11 */       MinecraftServer server = JRMCoreComTickH.server;
/* 12 */       if (server != null && server.func_71278_l()) {
/* 13 */         if (!JRMCoreH.paused) {
/* 14 */           FamilyCH.familyCNBT = FamilyCH.readFamilyInfoFromNBT(server);
/* 15 */           FamilyCH.lastUpdateTick = 0;
/*    */           
/*    */           try {
/* 18 */             this; sleep((JRMCoreConfig.serverPlayerUpdateTick_DataFamilyC * 1000));
/* 19 */           } catch (InterruptedException interruptedException) {}
/*    */           continue;
/*    */         } 
/* 22 */         FamilyCH.lastUpdateTick = 0;
/*    */         try {
/* 24 */           this; sleep(1000L);
/* 25 */         } catch (InterruptedException interruptedException) {}
/*    */         
/*    */         continue;
/*    */       } 
/* 29 */       FamilyCH.lastUpdateTick = 0;
/* 30 */       this.run = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\FamilyCDataThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */