/*    */ package JinRyuu.JRMCore.p.NC;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.p.PD;
/*    */ import JinRyuu.NarutoC.common.NCTech;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NCPacketHandlerClient
/*    */ {
/*    */   public void handleJRNC(int c, String d, EntityPlayer Player) {
/*    */     String[] s2;
/* 66 */     if (d.equalsIgnoreCase("copy")) {
/* 67 */       d = JRMCoreH.jutsu + ";" + JRMCoreH.hsp;
/* 68 */       PD.sendToServer(new NCPData2(c, d));
/*    */     }
/*    */     else {
/*    */       
/* 72 */       NCTech.BLcopy = d;
/*    */     } 
/* 74 */     switch (c) {
/*    */       case 0:
/* 76 */         s2 = d.contains(";") ? d.toString().split(";") : null;
/* 77 */         JRMCoreH.inIll = s2;
/*    */         break;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void handleNCdou(byte b, EntityPlayer Player) {}
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\NC\NCPacketHandlerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */