/*     */ package JinRyuu.JRMCore.client.helpmanager;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreKeyHandler;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HelpSystem
/*     */ {
/*     */   public static final int RED = 15602438;
/*     */   public static final int GREEN = 838686;
/*     */   public static final int YELLOW = 15445286;
/*  24 */   public static int helpTimerValue = 20;
/*     */   
/*     */   public static Instant helpTimer;
/*     */   
/*     */   public static boolean giveHelp = false;
/*     */   
/*     */   public static boolean createCharacter = false, chargeKi = false, extraInventory = false, skillsDBC = false, skillsNC = false, gainTP = false, fly = false;
/*     */   
/*     */   public static boolean checkedJBRA = false, transformFail = false;
/*     */   
/*     */   public static void update() {
/*  35 */     if (helpTimer == null && !giveHelp) { helpTimer = Instant.now(); }
/*  36 */     else if (helpTimer != null)
/*     */     
/*  38 */     { if (Duration.between(helpTimer, Instant.now()).toMillis() / 1000L > helpTimerValue) {
/*     */         
/*  40 */         if (helpTimerValue < 100) helpTimerValue *= 6; 
/*  41 */         giveHelp = true;
/*  42 */         helpTimer = null;
/*     */       }  }
/*     */ 
/*     */     
/*  46 */     byte renderLocation = 1;
/*     */     
/*  48 */     if (JGConfigClientSettings.errorNotificationsOn && !checkedJBRA) {
/*     */       
/*  50 */       checkedJBRA = true;
/*  51 */       if (!JRMCoreH.JBRA())
/*     */       {
/*  53 */         JRMCoreClient.phc.handleNotification("JBRA Mod Missing", "JinGames JBRA Mod is Missing! Our mods require this mod to render important content for the mod!\nVisit our site https://dl.jingames.net to download JBRA.", (byte)2, (byte)6, (byte)1, 15602438);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  59 */     if (JGConfigClientSettings.errorNotificationsOn && !transformFail && JRMCoreH.Pwrtyp != 0 && JRMCoreKeyHandler.KiAscend.func_151468_f() && JRMCoreH.curRelease == 0) {
/*     */       
/*  61 */       transformFail = true;
/*  62 */       JRMCoreClient.phc.handleNotification("Unable to Transform", "Hold " + 
/*     */           
/*  64 */           GameSettings.func_74298_c(JRMCoreKeyHandler.KiCharge.func_151463_i()) + " to charge your Energy, and increase your Release Level %, which can be found on the top-left side on your Energy bar.", (byte)2, (byte)6, (byte)1, 15602438);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  69 */     if (JGConfigClientSettings.tipNotificationsOn && giveHelp)
/*     */     {
/*  71 */       if (!createCharacter && JRMCoreH.Pwrtyp == 0) {
/*     */         
/*  73 */         createCharacter = true;
/*  74 */         giveHelp = false;
/*  75 */         JRMCoreClient.phc.handleNotification("Press " + 
/*  76 */             GameSettings.func_74298_c(JRMCoreKeyHandler.DS.func_151463_i()) + " to create a Character", "You must first create a character to fight!", (byte)4, (byte)21, (byte)1, 15445286);
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*  81 */       else if (!chargeKi && JRMCoreH.Pwrtyp != 0 && JRMCoreH.curRelease == 0) {
/*     */         
/*  83 */         chargeKi = true;
/*  84 */         giveHelp = false;
/*  85 */         JRMCoreClient.phc.handleNotification("Hold " + 
/*  86 */             GameSettings.func_74298_c(JRMCoreKeyHandler.KiCharge.func_151463_i()) + " to charge your Ki", "You must charge your Energy to use your powers!\nIncrease your Release Level %, which can be found on the top-left side on your Energy bar.", (byte)4, (byte)1, (byte)1, 15445286);
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*  91 */       else if (!fly && JRMCoreH.isPowerTypeKi()) {
/*     */ 
/*     */         
/*  94 */         boolean hasFly = false;
/*  95 */         if (JRMCoreH.PlyrSkills != null)
/*     */         {
/*  97 */           for (int i = 0; i < JRMCoreH.PlyrSkills.length; i++) {
/*     */             
/*  99 */             String currentSkill = JRMCoreH.PlyrSkills[i];
/* 100 */             if (JRMCoreH.PlyrSkills[i] != null && !currentSkill.contains("pty") && currentSkill.length() > 2)
/*     */             {
/* 102 */               if (currentSkill.substring(0, 2).equals("FL")) {
/*     */                 
/* 104 */                 hasFly = true;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/* 111 */         if (hasFly)
/*     */         {
/* 113 */           fly = true;
/* 114 */           giveHelp = false;
/* 115 */           JRMCoreClient.phc.handleNotification("Press F to Fly", "You can use Flight by pressing: " + 
/*     */               
/* 117 */               GameSettings.func_74298_c(JRMCoreKeyHandler.KiFlight.func_151463_i()), (byte)4, (byte)1, (byte)1, 15445286);
/*     */         }
/*     */       
/*     */       }
/* 121 */       else if (!extraInventory) {
/*     */         
/* 123 */         extraInventory = true;
/* 124 */         giveHelp = false;
/* 125 */         JRMCoreClient.phc.handleNotification("Extra Inventory", "Press 2nd Function Key (" + 
/*     */             
/* 127 */             GameSettings.func_74298_c(JRMCoreKeyHandler.Fn.func_151463_i()) + ") + Inventory Key (" + 
/*     */             
/* 129 */             GameSettings.func_74298_c((Minecraft.func_71410_x()).field_71474_y.field_151445_Q.func_151463_i()) + ") to open up your Extra Inventory slots.\nThere you can place Scouters, weights, Vanity, and other armor items.", (byte)4, (byte)1, (byte)1, 15445286);
/*     */ 
/*     */       
/*     */       }
/* 133 */       else if (!gainTP && JRMCoreH.Pwrtyp != 0) {
/*     */         
/* 135 */         gainTP = true;
/* 136 */         giveHelp = false;
/* 137 */         JRMCoreClient.phc.handleNotification("Punch to gain TP", "You can gain TP (Training Points) by punching creatures. Then you can use TP to level up your attribute points on your Data Sheet (" + 
/*     */             
/* 139 */             GameSettings.func_74298_c(JRMCoreKeyHandler.DS.func_151463_i()) + ")", (byte)4, (byte)1, (byte)1, 15445286);
/*     */ 
/*     */       
/*     */       }
/* 143 */       else if (!skillsDBC && JRMCoreH.isPowerTypeKi()) {
/*     */         
/* 145 */         skillsDBC = true;
/* 146 */         giveHelp = false;
/* 147 */         JRMCoreClient.phc.handleNotification("Learn Skills", "You can learn DBC skills from Masters all around the world to improve your abilities. Try visiting Kami at the coordinates X:0 Z:0!", (byte)4, (byte)1, (byte)1, 15445286);
/*     */ 
/*     */       
/*     */       }
/* 151 */       else if (!skillsNC && JRMCoreH.isPowerTypeChakra()) {
/*     */         
/* 153 */         skillsNC = true;
/* 154 */         giveHelp = false;
/* 155 */         JRMCoreClient.phc.handleNotification("Learn Skills", "You can learn Naruto C skills by opening your Data Sheet (" + 
/*     */             
/* 157 */             GameSettings.func_74298_c(JRMCoreKeyHandler.DS.func_151463_i()) + "), and click on Skills and Learn at the top right corner.", (byte)4, (byte)1, (byte)1, 15445286);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\helpmanager\HelpSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */