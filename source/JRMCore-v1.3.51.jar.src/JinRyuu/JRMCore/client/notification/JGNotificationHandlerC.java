/*    */ package JinRyuu.JRMCore.client.notification;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreCliTicH;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.client.audio.PositionedSoundRecord;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JGNotificationHandlerC
/*    */ {
/*    */   public static void addNotification(JGNotification notification) {
/* 15 */     if (notification != null && JGNotificationHandler.isRightCategory(notification)) {
/*    */       
/* 17 */       int count = 1;
/* 18 */       if (JGNotificationHandler.notificationsCount.containsKey(Byte.valueOf(notification.category))) {
/*    */         
/* 20 */         count = ((Integer)JGNotificationHandler.notificationsCount.get(Byte.valueOf(notification.category))).intValue() + 1;
/* 21 */         JGNotificationHandler.notificationsCount.put(Byte.valueOf(notification.category), Integer.valueOf(count));
/*    */       }
/*    */       else {
/*    */         
/* 25 */         JGNotificationHandler.notificationsCount.put(Byte.valueOf(notification.category), Integer.valueOf(count));
/*    */       } 
/* 27 */       JGNotificationHandler.notifications.put(JGNotificationHandler.createKey(notification.category, count), notification);
/* 28 */       if (JGNotificationGUI.categoryState[notification.category] != 1 && JGNotificationGUI.categoryState[0] != 1) {
/*    */         
/* 30 */         JRMCoreClient.mc.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 2.0F));
/* 31 */         JRMCoreCliTicH.notificationPings.add(notification);
/* 32 */         JGNotificationHandler.hasNewContent = true;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\notification\JGNotificationHandlerC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */