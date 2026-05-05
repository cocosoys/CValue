/*     */ package JinRyuu.JRMCore.client.notification;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreGuiButtonEmpty;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiButtons00;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiButtonsA1;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiScreen;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiSliderX00;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigsClient;
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGNotificationGUI
/*     */ {
/*     */   public static final int NOTIFICATIONS_OPEN = 50011;
/*     */   public static final int NORMAL = 0;
/*     */   public static final int MUTED = 1;
/*     */   public static final int DISABLED = 2;
/*     */   public static final int TEXTURE_SIZE = 16;
/*     */   public static final int COLOR_WHITE = 16777215;
/*     */   public static final int COLOR_RED = 14828830;
/*  31 */   private static int listCount = 0; public static final int COLOR_GREEN = 2940958; public static final int COLOR_BLUE = 2898406; public static final int COLOR_BLACK = 0; private static final int MODE_LIST = 0; private static final int MODE_SELECTION = 1; private static final int BUTTON_ID_START_SELECT = 19000; private static final int LIST_COUNT = 5;
/*  32 */   private static int buttonIDStartDelete = 19000 + listCount, buttonIDEnd = buttonIDStartDelete + listCount;
/*  33 */   private static int buttonIDClearAll = buttonIDEnd + JGNotificationHandler.CATEGORY_IDS_ALL.length + 1, buttonIDSort = buttonIDClearAll + 1, buttonIDMute = buttonIDSort + 1;
/*  34 */   private static int buttonIDDisable = buttonIDMute + 1;
/*     */   
/*  36 */   private static ArrayList<JGNotification> notificationList = new ArrayList<JGNotification>();
/*  37 */   private static ArrayList<String> notificationKeyList = new ArrayList<String>();
/*  38 */   private static int mode = 0;
/*  39 */   public static byte currentCategory = 0;
/*     */ 
/*     */   
/*  42 */   public static int[] categoryState = new int[] { 0, 0, 0, 0, 0, 0 };
/*     */   
/*     */   private static Instant now;
/*     */   private static boolean sortNewestToOldest = true;
/*  46 */   private static int categoryScroll = 0;
/*     */ 
/*     */   
/*     */   public static JRMCoreGuiScreen getGUIInstance() {
/*  50 */     return JRMCoreGuiScreen.instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void checkButtons(int buttonID) {
/*  58 */     if (buttonID == 50011) {
/*     */       
/*  60 */       categoryScroll = 0;
/*  61 */       (getGUIInstance()).scroll = 0;
/*  62 */       mode = 0;
/*  63 */       currentCategory = 0;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     if (buttonID >= 19000 && buttonID < buttonIDEnd) {
/*     */       
/*  71 */       boolean remove = (buttonID >= buttonIDStartDelete);
/*  72 */       int id = buttonID - (remove ? buttonIDStartDelete : 19000) - (getGUIInstance()).scroll;
/*     */       
/*  74 */       if (!remove)
/*     */       {
/*  76 */         int size = notificationList.size();
/*  77 */         for (int i = size - 1; i >= 0; i--) {
/*     */           
/*  79 */           if (i != id) {
/*     */             
/*  81 */             notificationList.remove(i);
/*  82 */             notificationKeyList.remove(i);
/*     */           } 
/*     */         } 
/*  85 */         categoryScroll = (getGUIInstance()).scroll;
/*  86 */         (getGUIInstance()).scroll = 0;
/*  87 */         mode = 1;
/*     */ 
/*     */       
/*     */       }
/*  91 */       else if (currentCategory == 0)
/*     */       {
/*  93 */         JGNotificationHandler.removeNotification(notificationKeyList.get(id));
/*     */       }
/*     */       else
/*     */       {
/*  97 */         int scrollStart = 0;
/*  98 */         int selectedID = scrollStart + id + 1;
/*  99 */         JGNotificationHandler.removeNotification(notificationKeyList.get(id));
/*     */       }
/*     */     
/*     */     }
/* 103 */     else if (buttonID == buttonIDEnd) {
/*     */       
/* 105 */       (getGUIInstance()).scroll = categoryScroll;
/* 106 */       mode = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 111 */     else if (buttonID > buttonIDEnd && buttonID <= buttonIDEnd + JGNotificationHandler.CATEGORY_IDS_ALL.length) {
/*     */ 
/*     */       
/* 114 */       int id = buttonID - buttonIDEnd - 1;
/* 115 */       currentCategory = (byte)id;
/* 116 */       mode = 0;
/* 117 */       categoryScroll = 0;
/* 118 */       (getGUIInstance()).scroll = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 123 */     else if (buttonID == buttonIDClearAll) {
/*     */       
/* 125 */       if (currentCategory == 0)
/*     */       {
/* 127 */         JGNotificationHandler.clearNotifications();
/*     */       }
/* 129 */       else if (JGNotificationHandler.notificationsCount.containsKey(Byte.valueOf(currentCategory)))
/*     */       {
/* 131 */         int count = ((Integer)JGNotificationHandler.notificationsCount.get(Byte.valueOf(currentCategory))).intValue();
/* 132 */         for (int i = count - 1; i >= 0; i--)
/*     */         {
/* 134 */           JGNotificationHandler.removeNotification(JGNotificationHandler.createKey(currentCategory, i + 1));
/*     */         }
/* 136 */         JGNotificationHandler.notificationsCount.remove(Byte.valueOf(currentCategory));
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 142 */     else if (buttonID == buttonIDSort) {
/*     */       
/* 144 */       sortNewestToOldest = !sortNewestToOldest;
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 149 */     else if (buttonID == buttonIDMute) {
/*     */       
/* 151 */       int all = 0;
/* 152 */       if (currentCategory == 0) {
/*     */         
/* 154 */         for (int i = 0; i < categoryState.length; i++)
/*     */         {
/* 156 */           if (i == 0) all = (categoryState[currentCategory] == 1) ? 0 : 1; 
/* 157 */           categoryState[i] = all;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 162 */         categoryState[currentCategory] = (categoryState[currentCategory] == 1) ? 0 : 1;
/*     */       } 
/* 164 */       JGConfigClientSettings.init_notifications(JGConfigsClient.clientNotifications, false, false);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 169 */     else if (buttonID == buttonIDDisable) {
/*     */       
/* 171 */       int all = 0;
/* 172 */       if (currentCategory == 0) {
/*     */         
/* 174 */         for (int i = 0; i < categoryState.length; i++)
/*     */         {
/* 176 */           if (i == 0) all = (categoryState[currentCategory] == 2) ? 0 : 2; 
/* 177 */           categoryState[i] = all;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 182 */         categoryState[currentCategory] = (categoryState[currentCategory] == 2) ? 0 : 2;
/*     */       } 
/* 184 */       JGConfigClientSettings.init_notifications(JGConfigsClient.clientNotifications, false, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void update(List buttonList, int width, int height, int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
/* 191 */     if (JGNotificationHandler.hasNewContent)
/*     */     {
/* 193 */       JGNotificationHandler.hasNewContent = false;
/*     */     }
/*     */     
/* 196 */     draw(buttonList, width, height, posX, posY, var5, var6, var8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void draw(List<JRMCoreGuiButtons00> buttonList, int width, int height, int posX, int posY, ScaledResolution var5, int var6, FontRenderer var8) {
/* 202 */     int xPos = 0, yPos = 0;
/*     */     
/* 204 */     String text = "";
/* 205 */     int xSize = 256;
/* 206 */     int ySize = 159;
/* 207 */     int guiLeft = (width - xSize) / 2;
/* 208 */     int guiTop = (height - ySize) / 2;
/* 209 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 210 */     getGUIInstance(); ResourceLocation guiLocation = new ResourceLocation(JRMCoreGuiScreen.guiBG2);
/* 211 */     getGUIInstance(); JRMCoreGuiScreen.mc.field_71446_o.func_110577_a(guiLocation);
/* 212 */     getGUIInstance().func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */     
/* 214 */     String n = JRMCoreH.trl("jrmc", "Back");
/* 215 */     int nw = var8.func_78256_a(n) + 8;
/* 216 */     xPos = guiLeft; yPos = guiTop + 160;
/* 217 */     buttonList.add(new JRMCoreGuiButtons00((mode == 0) ? 100 : buttonIDEnd, xPos, yPos, nw, 20, n, 15051074));
/*     */     
/* 219 */     xPos = guiLeft + 10; yPos = guiTop + 4;
/* 220 */     text = JGNotificationHandler.getCategoryTextAll(currentCategory);
/* 221 */     getGUIInstance(); JRMCoreGuiScreen.drawStringWithBorder(var8, "Category: " + text.substring(0, 1).toUpperCase() + text.substring(1), xPos, yPos, 16777215);
/*     */     
/* 223 */     now = Instant.now();
/*     */     
/* 225 */     for (int i = 0; i < JGNotificationHandler.CATEGORY_IDS_ALL.length; i++) {
/*     */       
/* 227 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 228 */       xPos = guiLeft - 20; yPos = guiTop + 20 + i * 20;
/* 229 */       buttonList.add(new JRMCoreGuiButtonEmpty(false, (currentCategory == i) ? 1 : 0, i + 1, (categoryState != null) ? categoryState[i] : 0, buttonIDEnd + 1 + i, xPos, yPos, 16, 16, "", (categoryState[i] == 2) ? 12850949 : ((categoryState[i] == 1) ? 12871948 : 0)));
/*     */ 
/*     */ 
/*     */       
/* 233 */       byte category = JGNotificationHandler.CATEGORY_IDS_ALL[i];
/*     */       
/* 235 */       int count = (i == 0) ? JGNotificationHandler.notifications.size() : (JGNotificationHandler.notificationsCount.containsKey(Byte.valueOf(category)) ? ((Integer)JGNotificationHandler.notificationsCount.get(Byte.valueOf(category))).intValue() : 0);
/*     */       
/* 237 */       text = JGNotificationHandler.CATEGORY_TEXTS_ALL[i] + ": " + count;
/* 238 */       if (categoryState[i] != 0) {
/*     */         
/* 240 */         String state = "";
/* 241 */         if (categoryState[i] == 2) { state = JRMCoreH.trl("jrmc", "Disabled"); }
/* 242 */         else { state = JRMCoreH.trl("jrmc", "Muted"); }
/* 243 */          text = text + " (" + state + ")";
/*     */       } 
/* 245 */       getGUIInstance(); JRMCoreGuiScreen.drawDetails(JRMCoreH.cct(text, new Object[0]), xPos, yPos, 16, 16, (getGUIInstance()).x, (getGUIInstance()).y, var8);
/*     */     } 
/*     */ 
/*     */     
/* 249 */     if (mode == 0) {
/*     */       
/* 251 */       if (notificationList.size() != 0) {
/*     */         
/* 253 */         notificationList.clear();
/* 254 */         notificationKeyList.clear();
/*     */       } 
/*     */       
/* 257 */       ArrayList<String> notifications = JGNotificationHandler.getNotificationsArray(currentCategory, sortNewestToOldest);
/* 258 */       int count = notifications.size();
/* 259 */       int scrollCount = count;
/*     */       
/* 261 */       listCount = count;
/* 262 */       buttonIDStartDelete = 19000 + listCount; buttonIDEnd = buttonIDStartDelete + listCount;
/* 263 */       buttonIDClearAll = buttonIDEnd + JGNotificationHandler.CATEGORY_IDS_ALL.length + 1;
/* 264 */       buttonIDSort = buttonIDClearAll + 1; buttonIDMute = buttonIDSort + 1; buttonIDDisable = buttonIDMute + 1;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 269 */       float m2 = 5.0F;
/* 270 */       int sz = 5;
/* 271 */       (getGUIInstance()).scrollMouseJump = 1;
/* 272 */       if (scrollCount > sz) {
/*     */         
/* 274 */         if (scrollCount - m2 < (getGUIInstance()).scroll) {
/*     */           
/* 276 */           (getGUIInstance()).scroll = (int)(scrollCount - m2);
/*     */         }
/* 278 */         else if ((getGUIInstance()).scroll < 0) {
/*     */           
/* 280 */           (getGUIInstance()).scroll = 0;
/*     */         } 
/* 282 */         if ((getGUIInstance()).mousePressed && !JRMCoreGuiButtonsA1.clicked) {
/*     */           
/* 284 */           getGUIInstance(); (getGUIInstance()).scroll = (int)JRMCoreH.round((scrollCount - m2) * JRMCoreGuiScreen.scrollSide, 0);
/*     */         } else {
/*     */           
/* 287 */           getGUIInstance(); JRMCoreGuiScreen.scrollSide = JRMCoreGuiSliderX00.sliderValue = (getGUIInstance()).scroll / (scrollCount - m2);
/*     */         } 
/*     */       } else {
/*     */         
/* 291 */         (getGUIInstance()).scroll = 0;
/*     */       } 
/*     */       
/* 294 */       if (scrollCount > sz) {
/*     */         
/* 296 */         getGUIInstance(); if (JRMCoreGuiScreen.scrollSide > 0.0F) buttonList.add(new JRMCoreGuiButtonsA1(43, guiLeft + xSize / 2 + 110 - 1, guiTop + (ySize + 1) / 2 - 70, "i", false)); 
/* 297 */         getGUIInstance(); if (JRMCoreGuiScreen.scrollSide < 1.0F) buttonList.add(new JRMCoreGuiButtonsA1(44, guiLeft + xSize / 2 + 110 - 1, guiTop + (ySize + 1) / 2 + 60, "v", false)); 
/* 298 */         getGUIInstance(); buttonList.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110 - 1, guiTop + 25, (getGUIInstance()).mousePressed, JRMCoreGuiScreen.scrollSide, 1.0F, false));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 306 */       String[] buttons = { JRMCoreH.trl("jrmc", "Disable"), JRMCoreH.trl("jrmc", "Mute"), JRMCoreH.trl("jrmc", "Sort"), JRMCoreH.trl("jrmc", "RemoveAll") };
/* 307 */       int[] buttonIDs = { buttonIDDisable, buttonIDMute, buttonIDSort, buttonIDClearAll };
/* 308 */       int[] buttonIcons = { 18, 17, sortNewestToOldest ? 19 : 20, 18 };
/*     */       
/* 310 */       yPos = guiTop - 22;
/*     */       
/* 312 */       for (int m = 0; m < buttons.length; m++) {
/*     */         
/* 314 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 315 */         xPos = guiLeft + m * ((m < buttons.length - 1) ? 20 : 30);
/* 316 */         buttonList.add(new JRMCoreGuiButtonEmpty(false, 0, buttonIcons[m], 0, buttonIDs[m], xPos, yPos, 16, 16, "", 0));
/* 317 */         text = buttons[m];
/* 318 */         getGUIInstance(); JRMCoreGuiScreen.drawDetails(JRMCoreH.cct(text, new Object[0]), xPos, yPos, 16, 16, (getGUIInstance()).x, (getGUIInstance()).y, var8);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 325 */       int scrollStart = (getGUIInstance()).scroll;
/* 326 */       int scrollMax = 0;
/* 327 */       if (scrollStart + 5 > count) { scrollMax = count; }
/* 328 */       else { scrollMax = scrollStart + 5; }
/*     */       
/* 330 */       int j = scrollStart;
/* 331 */       int k = 0;
/*     */       
/* 333 */       for (int i1 = scrollStart; i1 < scrollMax; i1++) {
/*     */         
/* 335 */         String key = notifications.get(i1);
/* 336 */         if (JGNotificationHandler.notifications.containsKey(key)) {
/*     */           
/* 338 */           JGNotification note = JGNotificationHandler.notifications.get(key);
/*     */           
/* 340 */           xPos = guiLeft + 10; yPos = guiTop + 20 + k * 26;
/* 341 */           int[] BG_COLOR = { 0, 16763650, 16722690, 2993151, 3002773, 13815502 };
/*     */           
/* 343 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */           
/* 345 */           if (note.iconColor != 0)
/*     */           {
/* 347 */             color(note.iconColor);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 368 */           ResourceLocation gui = new ResourceLocation(JRMCoreH.tjjrmc + ":note_background.png");
/* 369 */           getGUIInstance(); JRMCoreGuiScreen.mc.field_71446_o.func_110577_a(gui);
/* 370 */           getGUIInstance().func_73729_b(xPos, yPos, 0, 0, 230, 26);
/*     */ 
/*     */           
/* 373 */           xPos = guiLeft + 12; yPos = guiTop + 10 + 13 + k * 26 + 2;
/* 374 */           gui = new ResourceLocation(JRMCoreH.tjjrmc + ":note_category_icons.png");
/* 375 */           getGUIInstance(); JRMCoreGuiScreen.mc.field_71446_o.func_110577_a(gui);
/* 376 */           int idY = note.icon * 16 / 256;
/* 377 */           int idX = note.icon * 16 - idY * 256;
/* 378 */           idY *= 16;
/* 379 */           getGUIInstance().func_73729_b(xPos, yPos, idX, idY, 16, 16);
/*     */ 
/*     */           
/* 382 */           notificationList.add(note);
/* 383 */           notificationKeyList.add(key);
/*     */ 
/*     */ 
/*     */           
/* 387 */           xPos = guiLeft + 35; yPos = guiTop + 22 + k * 26;
/* 388 */           getGUIInstance(); text = JRMCoreGuiScreen.getStringShortened(var8, 175, note.title + " (" + getTime(note.received, false, true) + ")");
/* 389 */           var8.func_78276_b(text, xPos, yPos, 16777215);
/*     */           
/* 391 */           xPos = guiLeft + 35; yPos = guiTop + 22 + k * 26;
/* 392 */           getGUIInstance(); text = JRMCoreGuiScreen.getStringShortened(var8, 165, note.description);
/* 393 */           var8.func_78276_b(text.replace("/n", ""), xPos, yPos + 13, 16777215);
/*     */ 
/*     */           
/* 396 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 397 */           xPos = guiLeft + 210; yPos = guiTop + 10 + 13 + k * 26 + 2;
/* 398 */           text = JRMCoreH.trl("jrmc", "Remove");
/*     */           
/* 400 */           buttonList.add(new JRMCoreGuiButtonEmpty(false, 0, 18, 0, buttonIDStartDelete + i1, xPos, yPos, 16, 16, "", 0));
/*     */           
/* 402 */           getGUIInstance(); JRMCoreGuiScreen.drawDetails(JRMCoreH.cct(text, new Object[0]), xPos, yPos, 16, 16, (getGUIInstance()).x, (getGUIInstance()).y, var8);
/*     */           
/* 404 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 405 */           xPos = guiLeft + 10; yPos = guiTop + 20 + k * 26;
/* 406 */           buttonList.add(new JRMCoreGuiButtonEmpty(19000 + i1, xPos, yPos, 195, 26, ""));
/* 407 */           j++;
/* 408 */           k++;
/*     */         } 
/*     */       } 
/* 411 */     } else if (mode == 1) {
/*     */       
/* 413 */       if (notificationList.size() != 1)
/* 414 */         return;  JGNotification note = notificationList.get(0);
/*     */       
/* 416 */       xPos = guiLeft + 12; yPos = guiTop + 20;
/* 417 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/* 419 */       if (note.iconColor != 0)
/*     */       {
/* 421 */         color(note.iconColor);
/*     */       }
/*     */       
/* 424 */       ResourceLocation gui = new ResourceLocation(JRMCoreH.tjjrmc + ":note_category_icons.png");
/* 425 */       getGUIInstance(); JRMCoreGuiScreen.mc.field_71446_o.func_110577_a(gui);
/* 426 */       int idY = note.icon * 16 / 256;
/* 427 */       int idX = note.icon * 16 - idY * 256;
/* 428 */       idY *= 16;
/* 429 */       getGUIInstance().func_73729_b(xPos, yPos, idX, idY, 16, 16);
/* 430 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/* 432 */       xPos = guiLeft + 35; yPos = guiTop + 22 - 2 + 3;
/* 433 */       getGUIInstance(); text = JRMCoreGuiScreen.getStringShortened(var8, 200, note.title);
/* 434 */       getGUIInstance(); JRMCoreGuiScreen.drawStringWithBorder(var8, text, xPos, yPos, 16777215);
/*     */       
/* 436 */       xPos = guiLeft + 45 - 30; yPos = guiTop + 45;
/* 437 */       text = note.description;
/* 438 */       String translatedLine = JRMCoreH.trl(text);
/*     */       
/* 440 */       int count = JRMCoreH.txt(translatedLine, "", 0, false, xPos, yPos, 215, 0, 0);
/* 441 */       int scrollCount = count;
/* 442 */       int textboxWidth = (count > 11) ? 215 : 230;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 447 */       float m2 = 11.0F;
/* 448 */       int sz = 11;
/* 449 */       (getGUIInstance()).scrollMouseJump = 2;
/* 450 */       if (scrollCount > sz) {
/*     */         
/* 452 */         if (scrollCount - m2 < (getGUIInstance()).scroll) {
/*     */           
/* 454 */           (getGUIInstance()).scroll = (int)(scrollCount - m2);
/*     */         }
/* 456 */         else if ((getGUIInstance()).scroll < 0) {
/*     */           
/* 458 */           (getGUIInstance()).scroll = 0;
/*     */         } 
/* 460 */         if ((getGUIInstance()).mousePressed && !JRMCoreGuiButtonsA1.clicked) {
/*     */           
/* 462 */           getGUIInstance(); (getGUIInstance()).scroll = (int)JRMCoreH.round((scrollCount - m2) * JRMCoreGuiScreen.scrollSide, 0);
/*     */         } else {
/*     */           
/* 465 */           getGUIInstance(); JRMCoreGuiScreen.scrollSide = JRMCoreGuiSliderX00.sliderValue = (getGUIInstance()).scroll / (scrollCount - m2);
/*     */         } 
/*     */       } else {
/*     */         
/* 469 */         (getGUIInstance()).scroll = 0;
/*     */       } 
/*     */       
/* 472 */       if (scrollCount > sz) {
/*     */         
/* 474 */         getGUIInstance(); if (JRMCoreGuiScreen.scrollSide > 0.0F) buttonList.add(new JRMCoreGuiButtonsA1(43, guiLeft + xSize / 2 + 110 - 1, guiTop + (ySize + 1) / 2 - 70, "i", false)); 
/* 475 */         getGUIInstance(); if (JRMCoreGuiScreen.scrollSide < 1.0F) buttonList.add(new JRMCoreGuiButtonsA1(44, guiLeft + xSize / 2 + 110 - 1, guiTop + (ySize + 1) / 2 + 60, "v", false)); 
/* 476 */         getGUIInstance(); buttonList.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110 - 1, guiTop + 25, (getGUIInstance()).mousePressed, JRMCoreGuiScreen.scrollSide, 1.0F, false));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 482 */       int max = count - 11 - (getGUIInstance()).scroll;
/* 483 */       if (max < 0) max = 0;
/*     */       
/* 485 */       JRMCoreH.txt(translatedLine, "", 0, true, xPos, yPos - 10 * (getGUIInstance()).scroll, textboxWidth, (getGUIInstance()).scroll, max);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getTime(Instant time, boolean longText, boolean showBiggest) {
/* 493 */     String text = "";
/* 494 */     Duration duration = Duration.between(time, now);
/*     */     
/* 496 */     if (duration.toDays() > 0L) {
/*     */       
/* 498 */       text = text + duration.toDays() + (longText ? (" Day" + ((duration.toDays() > 1L) ? "s" : "")) : "d");
/* 499 */       if (showBiggest) return text;
/*     */     
/*     */     } 
/* 502 */     if (duration.toHours() > 0L) {
/*     */       
/* 504 */       if (showBiggest) text = ""; 
/* 505 */       long timer = duration.toHours();
/* 506 */       text = text + ((duration.toDays() > 0L) ? " " : "") + ((timer >= 24L) ? (timer - timer / 24L * 24L) : timer) + (longText ? (" Hour" + ((timer > 1L) ? "s" : "")) : "h");
/* 507 */       if (showBiggest) return text;
/*     */     
/*     */     } 
/* 510 */     if (duration.toMinutes() > 0L) {
/*     */       
/* 512 */       if (showBiggest) text = ""; 
/* 513 */       long timer = duration.toMinutes();
/* 514 */       text = text + ((duration.toHours() > 0L) ? " " : "") + ((timer >= 60L) ? (timer - timer / 60L * 60L) : timer) + (longText ? (" Minute" + ((timer > 1L) ? "s" : "")) : "m");
/* 515 */       if (showBiggest) return text;
/*     */     
/*     */     } 
/* 518 */     if (duration.toMillis() > 0L) {
/*     */       
/* 520 */       if (showBiggest) text = ""; 
/* 521 */       long timer = duration.toMillis() / 1000L;
/* 522 */       text = text + ((duration.toMinutes() > 0L) ? " " : "") + ((timer >= 60L) ? (timer - timer / 60L * 60L) : timer) + (longText ? (" Second" + ((timer > 1L) ? "s" : "")) : "s");
/* 523 */       if (showBiggest) return text; 
/*     */     } 
/* 525 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void color(int color, float alpha) {
/* 530 */     float h2 = (color >> 16 & 0xFF) / 255.0F;
/* 531 */     float h3 = (color >> 8 & 0xFF) / 255.0F;
/* 532 */     float h4 = (color & 0xFF) / 255.0F;
/* 533 */     float h1 = 1.0F;
/*     */     
/* 535 */     int r = (int)(h2 * 254.0F);
/* 536 */     int g = (int)(h3 * 254.0F);
/* 537 */     int b = (int)(h4 * 254.0F);
/*     */     
/* 539 */     GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, alpha);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void color(int color) {
/* 544 */     float h2 = (color >> 16 & 0xFF) / 255.0F;
/* 545 */     float h3 = (color >> 8 & 0xFF) / 255.0F;
/* 546 */     float h4 = (color & 0xFF) / 255.0F;
/* 547 */     float h1 = 1.0F;
/*     */     
/* 549 */     int r = (int)(h2 * 254.0F);
/* 550 */     int g = (int)(h3 * 254.0F);
/* 551 */     int b = (int)(h4 * 254.0F);
/*     */     
/* 553 */     GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\notification\JGNotificationGUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */