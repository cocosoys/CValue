/*     */ package JinRyuu.JRMCore.client.notification;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGNotificationHandler
/*     */ {
/*  11 */   public static final byte[] CATEGORY_IDS_ALL = new byte[] { 0, 1, 2, 3, 4, 5 };
/*     */   
/*  13 */   public static final String[] CATEGORY_TEXTS_ALL = new String[] { "All", "Info", "Error", "Server", "Tutorial", "Other" };
/*     */ 
/*     */   
/*  16 */   public static final byte[] CATEGORY_IDS = new byte[] { 1, 2, 3, 4, 5 };
/*     */   
/*  18 */   public static final String[] CATEGORY_TEXTS = new String[] { "Info", "Error", "Server", "Tutorial", "Other" };
/*     */ 
/*     */   
/*  21 */   public static HashMap<String, JGNotification> notifications = new HashMap<String, JGNotification>();
/*  22 */   public static HashMap<Byte, Integer> notificationsCount = new HashMap<Byte, Integer>();
/*     */   
/*     */   public static boolean hasNewContent = false;
/*     */ 
/*     */   
/*     */   public static String getCategoryText(int category) {
/*  28 */     return CATEGORY_TEXTS[category];
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getCategoryID(String category) {
/*  33 */     int length = CATEGORY_TEXTS.length;
/*  34 */     for (int i = 0; i < length; i++) {
/*     */       
/*  36 */       if (category.toLowerCase().equals(CATEGORY_TEXTS[i].toLowerCase())) return i; 
/*     */     } 
/*  38 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getCategoryTextAll(int category) {
/*  43 */     return CATEGORY_TEXTS_ALL[category];
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getCategoryIDAll(String category) {
/*  48 */     int length = CATEGORY_TEXTS_ALL.length;
/*  49 */     for (int i = 0; i < length; i++) {
/*     */       
/*  51 */       if (category.toLowerCase().equals(CATEGORY_TEXTS_ALL[i].toLowerCase())) return i; 
/*     */     } 
/*  53 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList<String> getAllNotificationsArray() {
/*  58 */     ArrayList<String> list = new ArrayList<String>();
/*  59 */     for (byte currentCategory : CATEGORY_IDS) {
/*     */       
/*  61 */       if (notificationsCount.containsKey(Byte.valueOf(currentCategory))) {
/*     */         
/*  63 */         int size = ((Integer)notificationsCount.get(Byte.valueOf(currentCategory))).intValue();
/*  64 */         for (int i = 0; i < size; i++)
/*     */         {
/*  66 */           list.add(createKey(currentCategory, i + 1));
/*     */         }
/*     */       } 
/*     */     } 
/*  70 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList<String> getTimelineArray(boolean sortNewestToOldest) {
/*  75 */     ArrayList<String> timelineArray = new ArrayList<String>();
/*  76 */     ArrayList<String> all = getAllNotificationsArray();
/*  77 */     int length = all.size();
/*  78 */     String[] timeline = new String[length];
/*     */     int i;
/*  80 */     for (i = 0; i < length; i++)
/*     */     {
/*  82 */       timeline[i] = all.get(i);
/*     */     }
/*     */     
/*  85 */     for (i = 0; i < length; i++) {
/*     */       
/*  87 */       for (int j = 0; j < length; j++) {
/*     */         
/*  89 */         if (((JGNotification)notifications.get(timeline[i])).received.isBefore(((JGNotification)notifications.get(timeline[j])).received)) {
/*     */           
/*  91 */           String keyI = timeline[i];
/*  92 */           timeline[i] = timeline[j];
/*  93 */           timeline[j] = keyI;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     length = timeline.length;
/*  99 */     i = sortNewestToOldest ? (length - 1) : 0;
/* 100 */     while (sortNewestToOldest ? (i >= 0) : (i < length)) {
/*     */       
/* 102 */       timelineArray.add(timeline[i]);
/* 103 */       if (sortNewestToOldest) { i--; continue; }
/* 104 */        i++;
/*     */     } 
/*     */     
/* 107 */     return timelineArray;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList<String> getNotificationsArray(int category, boolean sortNewestToOldest) {
/* 112 */     byte categoryB = (byte)category;
/* 113 */     ArrayList<String> list = new ArrayList<String>();
/* 114 */     if (categoryB == 0)
/*     */     {
/* 116 */       return getTimelineArray(sortNewestToOldest);
/*     */     }
/*     */ 
/*     */     
/* 120 */     if (notificationsCount.containsKey(Byte.valueOf(categoryB))) {
/*     */       
/* 122 */       int size = ((Integer)notificationsCount.get(Byte.valueOf(categoryB))).intValue();
/* 123 */       int i = sortNewestToOldest ? (size - 1) : 0;
/* 124 */       while (sortNewestToOldest ? (i >= 0) : (i < size)) {
/*     */         
/* 126 */         list.add(createKey(categoryB, i + 1));
/* 127 */         if (sortNewestToOldest) { i--; continue; }
/* 128 */          i++;
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isRightCategory(JGNotification notification) {
/* 140 */     for (byte category : CATEGORY_IDS) {
/*     */       
/* 142 */       if (notification.category == category) return true; 
/*     */     } 
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addNotification(JGNotification notification) {
/* 152 */     JGNotificationHandlerC.addNotification(notification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeNotification(String removedKeyID) {
/* 160 */     if (removedKeyID.length() > 0 && !notifications.isEmpty() && notifications.containsKey(removedKeyID)) {
/*     */       
/* 162 */       String[] values = removedKeyID.split(":");
/* 163 */       byte keyCategory = Byte.parseByte(values[0]);
/* 164 */       int removedKeyNumber = Integer.parseInt(values[1]);
/*     */       
/* 166 */       notifications.remove(removedKeyID);
/*     */       
/* 168 */       int remainingKeys = ((Integer)notificationsCount.get(Byte.valueOf(keyCategory))).intValue() - 1;
/* 169 */       if (remainingKeys < 1) {
/*     */         
/* 171 */         notificationsCount.remove(Byte.valueOf(keyCategory));
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 176 */       notificationsCount.put(Byte.valueOf(keyCategory), Integer.valueOf(remainingKeys));
/*     */ 
/*     */       
/* 179 */       for (int i = removedKeyNumber + 1; i < remainingKeys + 2; i++) {
/*     */         
/* 181 */         JGNotification notification = new JGNotification(getNotification(keyCategory, i));
/* 182 */         notifications.remove(createKey(keyCategory, i));
/* 183 */         notifications.put(createKey(keyCategory, i - 1), notification);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearNotifications() {
/* 191 */     notifications.clear();
/* 192 */     notificationsCount.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public static JGNotification getNotification(int category, int id) {
/* 197 */     return notifications.get(createKey(category, id));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String createKey(int category, int id) {
/* 202 */     return category + ":" + id;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\notification\JGNotificationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */