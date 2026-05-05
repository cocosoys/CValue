/*    */ package JinRyuu.JRMCore.client.notification;
/*    */ 
/*    */ import java.time.Instant;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JGNotification
/*    */ {
/*    */   public static final byte CATEGORY_ID_ALL = 0;
/*    */   public static final byte CATEGORY_ID_INFO = 1;
/*    */   public static final byte CATEGORY_ID_ERROR = 2;
/*    */   public static final byte CATEGORY_ID_SERVER = 3;
/*    */   public static final byte CATEGORY_ID_TUTORIAL = 4;
/*    */   public static final byte CATEGORY_ID_OTHER = 5;
/*    */   public static final String CATEGORY_TEXT_ALL = "All";
/*    */   public static final String CATEGORY_TEXT_INFO = "Info";
/*    */   public static final String CATEGORY_TEXT_ERROR = "Error";
/*    */   public static final String CATEGORY_TEXT_SERVER = "Server";
/*    */   public static final String CATEGORY_TEXT_TUTORIAL = "Tutorial";
/*    */   
/*    */   public JGNotification(String title, String description, int category, int icon, int renderLocation, int iconColor) {
/* 25 */     this.title = title;
/* 26 */     this.description = description;
/* 27 */     this.category = (byte)category;
/* 28 */     this.icon = (byte)icon;
/* 29 */     this.renderLocation = (byte)renderLocation;
/* 30 */     this.iconColor = iconColor;
/* 31 */     this.received = Instant.now();
/*    */   }
/*    */   public static final String CATEGORY_TEXT_OTHER = "Other"; public static final byte ICON_DEFAULT = 0; public static final byte BACKGROUND_DEFAULT = 0; public static final byte RENDER_TOP_RIGHT = 0; public String title; public String description; public byte category; public byte icon; public byte renderLocation; public int iconColor; public Instant received;
/*    */   
/*    */   public JGNotification(JGNotification notification) {
/* 36 */     this.title = notification.title;
/* 37 */     this.category = notification.category;
/* 38 */     this.description = notification.description;
/* 39 */     this.icon = notification.icon;
/* 40 */     this.renderLocation = notification.renderLocation;
/* 41 */     this.iconColor = notification.iconColor;
/* 42 */     Date date = Date.from(notification.received);
/* 43 */     this.received = date.toInstant();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\notification\JGNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */