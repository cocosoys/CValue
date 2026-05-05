/*    */ package JinRyuu.JRMCore.server;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JGPlayerClientServerHelper
/*    */ {
/*    */   public static float clientPlayerPositioner(Entity entity) {
/* 11 */     return (entity instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\JGPlayerClientServerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */