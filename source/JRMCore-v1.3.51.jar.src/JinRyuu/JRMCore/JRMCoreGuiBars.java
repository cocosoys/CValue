/*      */ package JinRyuu.JRMCore;
/*      */ import JinRyuu.DragonBC.common.DBCClientTickHandler;
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.DragonBC.common.DBCH;
/*      */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import java.time.Duration;
/*      */ import java.time.Instant;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.gui.Gui;
/*      */ import net.minecraft.client.gui.ScaledResolution;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ public class JRMCoreGuiBars extends Gui {
/*   23 */   Minecraft mc = JRMCoreClient.mc;
/*      */   
/*      */   private int kihelp1;
/*      */   private int kihelp2;
/*      */   private short kihelp3;
/*      */   private float kihelp4;
/*      */   private float xSize_lo;
/*      */   private float ySize_lo;
/*      */   private long time_start;
/*      */   private boolean started = false;
/*      */   static String[][] HUD_Properties;
/*   34 */   private byte swoop_id = 0; static String[] HUD_Images;
/*      */   public int getClientHealth() {
/*   36 */     return JRMCoreH.curBody; } public int getClientMaxHealth() {
/*   37 */     return JRMCoreH.maxBody;
/*      */   }
/*   39 */   public int getClientEnergy() { return JRMCoreH.curEnergy; } public int getClientMaxEnergy() {
/*   40 */     return JRMCoreH.maxEnergy;
/*      */   }
/*   42 */   public int getClientStamina() { return JRMCoreH.curStamina; } public int getClientMaxStamina() {
/*   43 */     return JRMCoreH.maxStamina;
/*      */   } public int getSmoothReleaseLevel() {
/*   45 */     return (int)JRMCoreHC.smoothReleaseLevel;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderSafeZoneIndicator() {
/*   52 */     if (JGConfigClientSettings.safeZoneUIModeOn && JRMCoreEH.currentSafeZoneNames.size() > 0) {
/*      */       
/*   54 */       GL11.glPushMatrix();
/*   55 */       ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*   56 */       int var6 = var5.func_78326_a();
/*   57 */       int var7 = var5.func_78328_b();
/*   58 */       FontRenderer var8 = this.mc.field_71466_p;
/*      */       
/*   60 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */       
/*   62 */       int TEXTURE_SIZE = 24;
/*      */       
/*   64 */       String text = JRMCoreEH.currentSafeZoneNames.get(JRMCoreEH.currentSafeZoneNames.size() - 1);
/*   65 */       int x = var6 / 2 - var8.func_78256_a(text) / 2;
/*   66 */       int y = 28;
/*      */       
/*   68 */       var8.func_78276_b(text, x + 1, y, 0);
/*   69 */       var8.func_78276_b(text, x - 1, y, 0);
/*   70 */       var8.func_78276_b(text, x, y + 1, 0);
/*   71 */       var8.func_78276_b(text, x, y - 1, 0);
/*   72 */       var8.func_78276_b(text, x, y, 16574720);
/*      */ 
/*      */ 
/*      */       
/*   76 */       ResourceLocation tx = new ResourceLocation("jinryuumodscore:icons3.png");
/*   77 */       this.mc.field_71446_o.func_110577_a(tx);
/*   78 */       GL11.glPushMatrix();
/*      */       
/*   80 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);
/*   81 */       GL11.glEnable(3042);
/*   82 */       GL11.glBlendFunc(770, 771);
/*   83 */       func_73729_b(var6 / 2 - 8, 3, 192, 16, 24, 24);
/*   84 */       GL11.glDisable(3042);
/*   85 */       GL11.glPopMatrix();
/*   86 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */       
/*   88 */       GL11.glPopMatrix();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void swoop() {
/*   97 */     GL11.glPushMatrix();
/*   98 */     if (this.started && System.nanoTime() / 10000000L - this.time_start > 7L) {
/*   99 */       this.started = false;
/*      */     }
/*  101 */     if (!this.started) {
/*  102 */       this.started = true;
/*  103 */       this.time_start = System.nanoTime() / 10000000L;
/*  104 */       int last_id = this.swoop_id;
/*  105 */       for (; this.swoop_id == last_id; this.swoop_id = (byte)(int)(Math.random() * 4.0D));
/*      */     } 
/*  107 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  108 */     int x = (var5.func_78326_a() - 256) / 2;
/*  109 */     int y = (var5.func_78328_b() - 256) / 2;
/*      */     
/*  111 */     ResourceLocation tx2 = new ResourceLocation("jinryuudragonbc:sw" + this.swoop_id + ".png");
/*  112 */     this.mc.field_71446_o.func_110577_a(tx2);
/*  113 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  114 */     GL11.glScalef(var5.func_78326_a() / 256.0F, var5.func_78328_b() / 256.0F, 1.0F);
/*  115 */     GL11.glEnable(3042);
/*  116 */     GL11.glBlendFunc(770, 771);
/*  117 */     func_73729_b(0, 0, 0, 0, 256, 256);
/*  118 */     GL11.glDisable(3042);
/*  119 */     GL11.glScalef(1.0F, 1.0F, 1.0F);
/*  120 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  129 */   final int CH_Scale = 2;
/*  130 */   int CH_xMain = 0;
/*  131 */   int CH_yMain = 0;
/*  132 */   int id = 0;
/*      */   
/*  134 */   int barAnimation = 100;
/*  135 */   int max_barAnimation = 100;
/*      */ 
/*      */   
/*      */   private static boolean custom_hud_good = false;
/*      */ 
/*      */   
/*      */   public void renderCG(int mode) {
/*  142 */     this.barAnimation--;
/*  143 */     if (this.barAnimation < 0) this.barAnimation = this.max_barAnimation; 
/*  144 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*      */     
/*  146 */     int var6 = var5.func_78326_a() + JGConfigClientSettings.CLIENT_hud1x;
/*  147 */     int var7 = var5.func_78328_b() - JGConfigClientSettings.CLIENT_hud1y;
/*  148 */     this.CH_xMain = JGConfigClientSettings.CLIENT_hud0x;
/*  149 */     this.CH_yMain = JGConfigClientSettings.CLIENT_hud0y;
/*      */ 
/*      */ 
/*      */     
/*  153 */     FontRenderer var8 = this.mc.field_71466_p;
/*  154 */     this.mc.field_71460_t.func_78478_c();
/*      */ 
/*      */ 
/*      */     
/*  158 */     byte HUD_Number = 8;
/*  159 */     byte img_HUD = 6;
/*  160 */     byte[] HUD_Number2 = { 6, 14, 14, 14, 14, 14, 7, 6 };
/*      */ 
/*      */ 
/*      */     
/*  164 */     try { HUD_Properties = new String[8][];
/*      */       
/*  166 */       for (int i = 0; i < 8; i++) {
/*  167 */         HUD_Properties[i] = new String[HUD_Number2[i]];
/*  168 */         String data = JGConfigClientSettings.CLIENT_hud2_2.split(";")[i];
/*  169 */         for (int k = 0; k < HUD_Number2[i]; k++) {
/*  170 */           String data2 = data.split(",")[k];
/*  171 */           if (data2 != null && !data2.equals("")) {
/*  172 */             HUD_Properties[i][k] = data2;
/*      */           }
/*      */         } 
/*      */       } 
/*  176 */       HUD_Images = new String[6];
/*  177 */       int[] img_ids = { 5, 9, 9, 9, 9, 9 };
/*  178 */       for (int j = 0; j < 6; j++) {
/*  179 */         HUD_Images[j] = HUD_Properties[j][img_ids[j]];
/*      */       }
/*      */       
/*  182 */       custom_hud_good = true; }
/*  183 */     catch (Exception e) { custom_hud_good = false; }
/*      */ 
/*      */     
/*  186 */     if (custom_hud_good) {
/*      */ 
/*      */ 
/*      */       
/*  190 */       int X = 0, Y = 1, HUD_WIDTH = 2, HUD_HEIGHT = 3, HUD_DIRECTION = 5;
/*      */       
/*  192 */       for (int i = 0; i < 6; i++) {
/*  193 */         this.id = i;
/*      */         
/*  195 */         if (i == 0) {
/*  196 */           int w = 0, h = 0;
/*      */ 
/*      */           
/*  199 */           int j = get_Property(i, 0);
/*  200 */           int k = get_Property(i, 1);
/*      */           
/*  202 */           w = get_Property(i, 2);
/*  203 */           h = get_Property(i, 3);
/*      */           
/*  205 */           drawHUD(HUD_Images[i], j, k, 0, 0, w, h, 0, false);
/*      */         
/*      */         }
/*  208 */         else if (i > 0) {
/*  209 */           float max_barAnimation = 1.0F;
/*  210 */           float barAnimation = 0.0F;
/*      */           
/*  212 */           for (int j = 0; j < 2; j++) {
/*  213 */             float width = 1.0F, height = 1.0F;
/*  214 */             int posX1 = 0, posY1 = 0;
/*  215 */             int posX2 = 0, posY2 = 0;
/*  216 */             int i2 = 0, i3 = 0;
/*      */             
/*  218 */             int direction = get_Property(i, 5);
/*      */             
/*  220 */             if (j == 1) {
/*  221 */               if (i == 1) {
/*  222 */                 float ki = getClientHealth();
/*  223 */                 float maxki = getClientMaxHealth();
/*      */                 
/*  225 */                 float egy = maxki / 100.0F;
/*  226 */                 float curr = ki / egy;
/*  227 */                 max_barAnimation = 1.0F;
/*  228 */                 barAnimation = 1.0F - curr / 100.0F;
/*      */               }
/*  230 */               else if (i == 2) {
/*  231 */                 float ki = getClientEnergy();
/*  232 */                 float maxki = getClientMaxEnergy();
/*      */                 
/*  234 */                 float egy = maxki / 100.0F;
/*  235 */                 float curr = ki / egy;
/*  236 */                 max_barAnimation = 1.0F;
/*  237 */                 barAnimation = 1.0F - curr / 100.0F;
/*      */               }
/*  239 */               else if (i == 3) {
/*  240 */                 float ki = getClientStamina();
/*  241 */                 float maxki = getClientMaxStamina();
/*      */                 
/*  243 */                 float egy = maxki / 100.0F;
/*  244 */                 float curr = ki / egy;
/*  245 */                 max_barAnimation = 1.0F;
/*  246 */                 barAnimation = 1.0F - curr / 100.0F;
/*      */               }
/*  248 */               else if (i == 4) {
/*  249 */                 float ki = JRMCoreH.TransSaiCurRg;
/*  250 */                 float maxki = 100.0F;
/*      */                 
/*  252 */                 float egy = maxki / 100.0F;
/*  253 */                 float curr = ki / egy;
/*  254 */                 max_barAnimation = 1.0F;
/*  255 */                 barAnimation = 1.0F - curr / 100.0F;
/*      */               }
/*  257 */               else if (i == 5) {
/*  258 */                 float ki = getSmoothReleaseLevel();
/*  259 */                 float maxki = 100.0F;
/*      */                 
/*  261 */                 float egy = maxki / 100.0F;
/*  262 */                 float curr = ki / egy;
/*      */                 
/*  264 */                 max_barAnimation = 1.0F;
/*  265 */                 barAnimation = 1.0F - curr / 100.0F;
/*      */               } 
/*      */ 
/*      */               
/*  269 */               if (direction == 0) {
/*      */                 
/*  271 */                 width = (max_barAnimation - barAnimation) / max_barAnimation;
/*      */               }
/*  273 */               else if (direction == 1) {
/*      */                 
/*  275 */                 width = (max_barAnimation - barAnimation) / max_barAnimation;
/*  276 */                 posX1 = (int)(get_Property(i, 2) - get_Property(i, 2) * width);
/*  277 */                 posX2 = (int)(get_Property(i, 2) - get_Property(i, 2) * width);
/*      */               
/*      */               }
/*  280 */               else if (direction == 2) {
/*      */                 
/*  282 */                 height = (max_barAnimation - barAnimation) / max_barAnimation;
/*      */ 
/*      */               
/*      */               }
/*  286 */               else if (direction == 3) {
/*      */                 
/*  288 */                 height = (max_barAnimation - barAnimation) / max_barAnimation;
/*      */               } 
/*      */ 
/*      */               
/*  292 */               if (j == 1 && direction != 2) { posY2 = get_Property(i, 3); }
/*  293 */               else if (j == 1 && direction == 2) { posY2 = get_Property(i, 3) + (int)(get_Property(i, 3) * (1.0F - height)); }
/*      */             
/*      */             } 
/*  296 */             int i4 = get_Property(i, 0) + posX1;
/*  297 */             int i5 = get_Property(i, 1) + posY1;
/*  298 */             if (j == 1 && direction == 2) i5 += (int)(get_Property(i, 3) * (1.0F - height));
/*      */             
/*  300 */             i2 = (int)(get_Property(i, 2) * width);
/*  301 */             i3 = (int)(get_Property(i, 3) * height);
/*  302 */             if (j == 1) i3++;
/*      */ 
/*      */             
/*  305 */             drawHUD2(HUD_Images[i], i4, i5, posX2, posY2, i2, i3, j, false);
/*      */             
/*  307 */             if (i == 1 && j == 1) {
/*  308 */               float health = JRMCoreClient.mc.field_71439_g.func_110143_aJ();
/*  309 */               float healthmax = JRMCoreClient.mc.field_71439_g.func_110138_aP();
/*  310 */               float maxperc = healthmax / 100.0F;
/*  311 */               int var20 = (int)(health / maxperc);
/*  312 */               if (getClientHealth() <= 0) {
/*      */                 
/*  314 */                 max_barAnimation = 1.0F;
/*  315 */                 barAnimation = 1.0F - var20 / 100.0F;
/*      */ 
/*      */                 
/*  318 */                 if (direction == 0) {
/*      */                   
/*  320 */                   width = (max_barAnimation - barAnimation) / max_barAnimation;
/*      */                 }
/*  322 */                 else if (direction == 1) {
/*      */                   
/*  324 */                   width = (max_barAnimation - barAnimation) / max_barAnimation;
/*  325 */                   posX1 = (int)(get_Property(i, 2) - get_Property(i, 2) * width);
/*  326 */                   posX2 = (int)(get_Property(i, 2) - get_Property(i, 2) * width);
/*      */                 
/*      */                 }
/*  329 */                 else if (direction == 2) {
/*      */                   
/*  331 */                   height = (max_barAnimation - barAnimation) / max_barAnimation;
/*      */                 }
/*  333 */                 else if (direction == 3) {
/*      */                   
/*  335 */                   height = (max_barAnimation - barAnimation) / max_barAnimation;
/*      */                 } 
/*  337 */                 if (j == 1 && direction != 2) { posY2 = get_Property(i, 3); }
/*  338 */                 else if (j == 1 && direction == 2) { posY2 = get_Property(i, 3) + (int)(get_Property(i, 3) * (1.0F - height)); }
/*      */                 
/*  340 */                 i4 = get_Property(i, 0) + posX1;
/*  341 */                 i5 = get_Property(i, 1) + posY1;
/*  342 */                 if (j == 1 && direction == 2) i5 += (int)(get_Property(i, 3) * (1.0F - height));
/*      */                 
/*  344 */                 i2 = (int)(get_Property(i, 2) * width);
/*  345 */                 i3 = (int)(get_Property(i, 3) * height);
/*  346 */                 if (j == 1) i3++;
/*      */                 
/*  348 */                 drawHUD2(HUD_Images[i], i4, i5, posX2, posY2, i2, i3, j, true);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  355 */           int k = get_Property(i, 6);
/*  356 */           int m = get_Property(i, 7);
/*  357 */           int w = (get_Property(i, 2) == 1) ? 100 : 20, h = (get_Property(i, 2) == 1) ? 20 : 100;
/*  358 */           String str1 = "";
/*  359 */           String text2 = "";
/*  360 */           int n = get_Property(i, 8);
/*      */           
/*  362 */           int min = 1;
/*  363 */           int max = 1;
/*      */           
/*  365 */           if (i == 1) {
/*  366 */             float ki = getClientHealth();
/*  367 */             float maxki = getClientMaxHealth();
/*  368 */             min = (int)ki;
/*  369 */             max = (int)maxki;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  379 */           else if (i == 2) {
/*  380 */             float ki = getClientEnergy();
/*  381 */             float maxki = getClientMaxEnergy();
/*  382 */             min = (int)ki;
/*  383 */             max = (int)maxki;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  395 */           else if (i == 3) {
/*  396 */             float ki = getClientStamina();
/*  397 */             float maxki = getClientMaxStamina();
/*  398 */             min = (int)ki;
/*  399 */             max = (int)maxki;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  410 */           else if (i == 4) {
/*  411 */             float ki = JRMCoreH.TransSaiCurRg;
/*  412 */             float maxki = 100.0F;
/*  413 */             min = (int)ki;
/*  414 */             max = (int)maxki;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  425 */           else if (i == 5) {
/*  426 */             float ki = getSmoothReleaseLevel();
/*  427 */             float maxki = 100.0F;
/*  428 */             min = (int)ki;
/*  429 */             max = (int)maxki;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  440 */           if (JGConfigClientSettings.CLIENT_GR5) {
/*  441 */             float egy = max / 100.0F;
/*  442 */             float curr = min / egy;
/*      */             
/*  444 */             str1 = HUD_Properties[this.id][13];
/*  445 */             text2 = str1.replace("|", ":").replace("#amount", (int)curr + "").replace("#max", "").replace("/", "") + "%";
/*      */ 
/*      */           
/*      */           }
/*      */           else {
/*      */ 
/*      */             
/*  452 */             str1 = HUD_Properties[this.id][13];
/*  453 */             text2 = str1.replace("|", ":").replace("#amount", JRMCoreH.numSep(min) + "").replace("#max", JRMCoreH.numSep(max) + "");
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  459 */           int r = get_Property(i, 10), g = get_Property(i, 11), b = get_Property(i, 12);
/*  460 */           int i1 = r;
/*  461 */           i1 = (i1 << 8) + g;
/*  462 */           i1 = (i1 << 8) + b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  474 */           if (!HUD_Properties[this.id][13].contains("#empty")) {
/*  475 */             drawString2(var8, text2, k + this.CH_xMain, m + this.CH_yMain, n, false, i1);
/*      */           }
/*      */         } 
/*      */       } 
/*  479 */       this.id++;
/*      */       
/*  481 */       int x = get_Property(6, 0) + this.CH_xMain;
/*  482 */       int y = get_Property(6, 1) + this.CH_yMain - 10;
/*  483 */       showSE(x, y, get_Property(6, 3), get_Property(6, 2));
/*      */       
/*  485 */       this.id++;
/*      */       
/*  487 */       x = get_Property(7, 0);
/*  488 */       y = get_Property(7, 1);
/*  489 */       int border = get_Property(7, 2);
/*  490 */       String bc = "" + JRMCoreH.numSepShort(JRMCoreHC.BPC_ME);
/*      */ 
/*      */       
/*  493 */       String text = ((JRMCoreH.BPMode == 1) ? "f" : "") + "BP " + bc + " " + JRMCoreH.DifficultySNmes[JRMCoreH.Dffclty] + ((JRMCoreH.isRaceArcosian() && JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) > 0) ? (" (PP: " + JRMCoreH.getArcRsrv() + ")") : ((JRMCoreH.isRaceMajin() && JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) > 4) ? (" (Absorption: " + JRMCoreH.getMajinAbsorptionValue() + ")") : ""));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  500 */       int rgb = get_Property(7, 3);
/*  501 */       rgb = (rgb << 8) + get_Property(7, 4);
/*  502 */       rgb = (rgb << 8) + get_Property(7, 5);
/*      */       
/*  504 */       drawString2(var8, text, x + this.CH_xMain, y + this.CH_yMain, border, false, rgb);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawString2(FontRenderer fr, String s, int x, int y, int b, boolean sc, int clr) {
/*  515 */     if (custom_hud_good) {
/*  516 */       boolean doit = true;
/*      */ 
/*      */       
/*  519 */       String data = "";
/*  520 */       if (this.id > 0 && this.id < 6) {
/*  521 */         data = HUD_Properties[this.id][13];
/*  522 */         if (data.contains("#empty")) doit = false;
/*      */       
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  536 */       if (doit) {
/*  537 */         GL11.glPushMatrix();
/*  538 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  543 */         if (b > 0) {
/*  544 */           if (b > 1) {
/*  545 */             b = 1;
/*  546 */             fr.func_78276_b(s, x + b, y + b, 0);
/*  547 */             fr.func_78276_b(s, x - b, y - b, 0);
/*      */           } 
/*  549 */           fr.func_78276_b(s, x + b, y, 0);
/*  550 */           fr.func_78276_b(s, x - b, y, 0);
/*  551 */           fr.func_78276_b(s, x, y + b, 0);
/*  552 */           fr.func_78276_b(s, x, y - b, 0);
/*      */         } 
/*  554 */         int value = 0;
/*      */ 
/*      */         
/*  557 */         if (this.id > 0) {
/*  558 */           if (this.id < 6)
/*  559 */           { if (get_Property(this.id, 4) == 1) { value = plrClr(clr, 1); }
/*  560 */             else { value = clr; }
/*      */              }
/*  562 */           else { value = clr; }
/*      */         
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  577 */         fr.func_78276_b(s, x, y, value);
/*  578 */         GL11.glPopMatrix();
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  583 */       fr.func_78276_b(s, x, y, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int plrClr(int szin, int id) {
/*  591 */     byte pwr = JRMCoreH.Pwrtyp;
/*  592 */     int bc1 = 654591;
/*  593 */     boolean evl = JRMCoreH.Algnmnt_Evil(JRMCoreH.align);
/*  594 */     if (JRMCoreH.Algnmnt_Good(JRMCoreH.align)) { bc1 = 654591; }
/*  595 */     else if (JRMCoreH.Algnmnt_Neut(JRMCoreH.align)) { bc1 = 13478142; }
/*  596 */     else if (evl) { bc1 = 16522030; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  604 */     int s = bc1;
/*  605 */     if (JRMCoreH.DBC())
/*      */     {
/*  607 */       s = JRMCoreHDBC.getPlayerColor2(3, bc1, pwr, JRMCoreH.Race, JRMCoreH.State, JRMCoreH.StusEfctsMe(17), JRMCoreH.lgndb2(), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20));
/*      */     }
/*      */     
/*  610 */     if (id == 0 || id == 100) {
/*  611 */       float f1 = (s >> 16 & 0xFF) / 255.0F;
/*  612 */       float f2 = (s >> 8 & 0xFF) / 255.0F;
/*  613 */       float f3 = (s & 0xFF) / 255.0F;
/*  614 */       float f4 = 1.0F;
/*      */       
/*  616 */       float value = (id == 100) ? (szin / 100.0F) : 1.0F;
/*  617 */       GL11.glColor4f(f4 * f1, f4 * f2, f4 * f3, 1.0F * value);
/*  618 */       return -1;
/*      */     } 
/*      */     
/*  621 */     float h2 = (s >> 16 & 0xFF) / 255.0F;
/*  622 */     float h3 = (s >> 8 & 0xFF) / 255.0F;
/*  623 */     float h4 = (s & 0xFF) / 255.0F;
/*  624 */     float h1 = 1.0F;
/*      */     
/*  626 */     float r1 = h1 * h2;
/*  627 */     float g1 = h1 * h3;
/*  628 */     float b1 = h1 * h4;
/*      */     
/*  630 */     float h22 = (szin >> 16 & 0xFF) / 255.0F;
/*  631 */     float h32 = (szin >> 8 & 0xFF) / 255.0F;
/*  632 */     float h42 = (szin & 0xFF) / 255.0F;
/*  633 */     float r2 = h1 * h22;
/*  634 */     float g2 = h1 * h32;
/*  635 */     float b2 = h1 * h42;
/*      */     
/*  637 */     float r = (r1 + r2) / 2.0F;
/*  638 */     float g = (g1 + g2) / 2.0F;
/*  639 */     float b = (b1 + b2) / 2.0F;
/*  640 */     if (r > 1.0F) r = 1.0F; 
/*  641 */     if (g > 1.0F) g = 1.0F; 
/*  642 */     if (b > 1.0F) b = 1.0F;
/*      */     
/*  644 */     int rgb = (int)(r * 255.0F);
/*  645 */     rgb = (rgb << 8) + (int)(g * 255.0F);
/*  646 */     rgb = (rgb << 8) + (int)(b * 255.0F);
/*      */     
/*  648 */     return rgb;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawHUD(String img, int posX, int posY, int x, int y, int w, int h, int id, boolean on) {
/*  654 */     if (img != null && w > 0 && h > 0 && x > -1 && y > -1) {
/*  655 */       int img_width = 255, img_height = 255;
/*  656 */       if (w > 255) w = 255; 
/*  657 */       if (h > 255) h = 255; 
/*  658 */       if (x > 255) x = 255; 
/*  659 */       if (y > 255) y = 255; 
/*  660 */       if (y + id * h + h <= 255) {
/*  661 */         GL11.glPushMatrix();
/*  662 */         ResourceLocation tx2 = new ResourceLocation("jinryuumodscore:custom_hud/" + img + ".png");
/*  663 */         this.mc.field_71446_o.func_110577_a(tx2);
/*  664 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  665 */         GL11.glEnable(3042);
/*  666 */         GL11.glBlendFunc(770, 771);
/*      */         
/*  668 */         if (!on)
/*  669 */         { if (this.id > 0 && id == 1 && this.id < 6 && get_Property(this.id, 4) == 1) { plrClr(0, 0); }
/*  670 */           else if (this.id == 0 && get_Property(this.id, 4) == 1) { plrClr(0, 0); }  }
/*  671 */         else { GL11.glColor3f(0.85F, 0.15F, 0.3F); }
/*      */         
/*  673 */         func_73729_b(posX + this.CH_xMain, posY + this.CH_yMain, x, y + id * h, w, h);
/*  674 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawHUD2(String img, int posX, int posY, int x, int y, int w, int h, int id, boolean on) {
/*  684 */     if (img != null && w > 0 && h > 0 && x > -1 && y > -1) {
/*  685 */       int img_width = 255, img_height = 255;
/*  686 */       if (w > 255) w = 255; 
/*  687 */       if (h > 255) h = 255; 
/*  688 */       if (x > 255) x = 255; 
/*  689 */       if (y > 255) y = 255;
/*      */ 
/*      */       
/*  692 */       GL11.glPushMatrix();
/*  693 */       ResourceLocation tx2 = new ResourceLocation("jinryuumodscore:custom_hud/" + img + ".png");
/*  694 */       this.mc.field_71446_o.func_110577_a(tx2);
/*  695 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  696 */       GL11.glEnable(3042);
/*  697 */       GL11.glBlendFunc(770, 771);
/*      */       
/*  699 */       if (!on)
/*  700 */       { if (this.id > 0 && id == 1 && this.id < 6 && get_Property(this.id, 4) == 1) { plrClr(0, 0); }
/*  701 */         else if (this.id == 0 && get_Property(this.id, 4) == 1) { plrClr(0, 0); }  }
/*  702 */       else { GL11.glColor3f(1.0F, 0.3F, 0.4F); }
/*      */       
/*  704 */       func_73729_b(posX + this.CH_xMain, posY + this.CH_yMain, x, y, w, h);
/*      */       
/*  706 */       GL11.glPopMatrix();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int get_Property(int i, int j) {
/*  717 */     if (custom_hud_good) {
/*  718 */       if (HUD_Properties != null) return Integer.parseInt(HUD_Properties[i][j]); 
/*  719 */       return -1;
/*      */     } 
/*  721 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderBodyBar() {
/*      */     String var34;
/*  732 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  733 */     int var6 = var5.func_78326_a() + JGConfigClientSettings.CLIENT_hud1x;
/*      */     
/*  735 */     int var7 = var5.func_78328_b() - JGConfigClientSettings.CLIENT_hud1y;
/*  736 */     FontRenderer var8 = this.mc.field_71466_p;
/*  737 */     this.mc.field_71460_t.func_78478_c();
/*  738 */     float ki = getClientHealth();
/*  739 */     float maxki = getClientMaxHealth();
/*  740 */     float st = getClientStamina();
/*  741 */     float maxst = getClientMaxStamina();
/*      */ 
/*      */     
/*  744 */     int var61 = var7 / 2 + 25;
/*  745 */     int height = JGConfigClientSettings.get_hud_1_width();
/*  746 */     float max = maxki;
/*      */     
/*  748 */     float maxperc = height / max;
/*  749 */     float var22 = maxperc * ki;
/*  750 */     if (var22 > height) {
/*  751 */       var22 = height;
/*      */     }
/*  753 */     float maxstperc = height / maxst;
/*  754 */     float var22st = maxstperc * st;
/*  755 */     if (var22st > height) {
/*  756 */       var22st = height;
/*      */     }
/*      */     
/*  759 */     float health = JRMCoreClient.mc.field_71439_g.func_110143_aJ();
/*  760 */     float healthmax = JRMCoreClient.mc.field_71439_g.func_110138_aP();
/*  761 */     max = healthmax;
/*  762 */     maxperc = height / max;
/*  763 */     int var20 = (int)(maxperc * health);
/*  764 */     if (var20 > height) {
/*  765 */       var20 = height;
/*      */     }
/*      */     
/*  768 */     this.field_73735_i = -90.0F;
/*  769 */     ResourceLocation tx2 = new ResourceLocation("jinryuumodscore:health.png");
/*  770 */     this.mc.field_71446_o.func_110577_a(tx2);
/*  771 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  772 */     GL11.glEnable(3042);
/*  773 */     GL11.glBlendFunc(770, 771);
/*      */ 
/*      */ 
/*      */     
/*  777 */     int img_height = JGConfigClientSettings.get_hud_1_height();
/*  778 */     int guiLeft = var6 - JGConfigClientSettings.get_hud_1_height() + 2;
/*      */     
/*  780 */     GL11.glPushMatrix();
/*  781 */     GL11.glTranslatef(guiLeft, var61, 0.0F);
/*  782 */     if (JGConfigClientSettings.CLIENT_GR6) {
/*  783 */       GL11.glTranslatef(0.0F, JGConfigClientSettings.get_hud_1_height() * 2.8F, 0.0F);
/*  784 */       GL11.glRotatef(270.0F, 0.0F, 0.0F, 1.0F);
/*      */     } 
/*      */ 
/*      */     
/*  788 */     func_73729_b(0, 0, 
/*  789 */         JGConfigClientSettings.get_hud_1_pos(0), 0, 
/*  790 */         JGConfigClientSettings.get_hud_1_height(), JGConfigClientSettings.get_hud_1_width());
/*      */     
/*  792 */     if (var20 > 0)
/*  793 */       func_73729_b(0, 0, 
/*  794 */           JGConfigClientSettings.get_hud_1_pos(2), 0, 
/*  795 */           JGConfigClientSettings.get_hud_1_height(), var20); 
/*  796 */     if (var22 > 0.0F)
/*  797 */       func_73729_b(0, 0, 
/*  798 */           JGConfigClientSettings.get_hud_1_pos(1), 0, 
/*  799 */           JGConfigClientSettings.get_hud_1_width_hea(), (int)var22); 
/*  800 */     GL11.glTranslatef((JGConfigClientSettings.get_hud_1_width_st() + 2), 0.0F, 0.0F);
/*  801 */     if (var22st > 0.0F) {
/*  802 */       func_73729_b(0, 0, 
/*  803 */           JGConfigClientSettings.get_hud_1_pos_stam(), 0, 
/*  804 */           JGConfigClientSettings.get_hud_1_width_st(), (int)var22st);
/*      */     }
/*  806 */     GL11.glPopMatrix();
/*      */     
/*  808 */     GL11.glDisable(3042);
/*      */     
/*  810 */     if (JGConfigClientSettings.CLIENT_hud1x < 5) {
/*  811 */       int diff = JGConfigClientSettings.CLIENT_hud1x / 10;
/*  812 */       if (diff < -30) diff = -30; 
/*  813 */       guiLeft -= diff;
/*      */     } 
/*      */ 
/*      */     
/*  817 */     float one = maxki / 100.0F;
/*  818 */     if (JGConfigClientSettings.CLIENT_GR5) { var34 = "" + (int)(ki / one) + "%"; }
/*  819 */     else { var34 = "" + JRMCoreH.numSep((int)ki); }
/*      */     
/*  821 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  822 */     int var38 = guiLeft + 12 - var8.func_78256_a(var34);
/*  823 */     int var37 = var61 + 45;
/*      */     
/*  825 */     var8.func_78276_b(var34, var38 + 1, var37, 0);
/*  826 */     var8.func_78276_b(var34, var38 - 1, var37, 0);
/*  827 */     var8.func_78276_b(var34, var38, var37 + 1, 0);
/*  828 */     var8.func_78276_b(var34, var38, var37 - 1, 0);
/*  829 */     var8.func_78276_b(var34, var38, var37, 8388564);
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderSAOHealthBar() {
/*  834 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  835 */     int var6 = var5.func_78326_a();
/*  836 */     int var7 = var5.func_78328_b();
/*  837 */     FontRenderer var8 = this.mc.field_71466_p;
/*  838 */     this.mc.field_71460_t.func_78478_c();
/*  839 */     int ki = getClientHealth();
/*  840 */     int maxki = getClientMaxHealth();
/*  841 */     int lvl = JRMCoreH.sao_level;
/*  842 */     int var51 = 14;
/*  843 */     int var61 = 2;
/*  844 */     short var21 = 30;
/*  845 */     int width = 179;
/*  846 */     float max = maxki;
/*      */ 
/*      */ 
/*      */     
/*  850 */     float maxperc = width / max;
/*      */ 
/*      */ 
/*      */     
/*  854 */     maxperc = width / max;
/*  855 */     int var20 = (int)(maxperc * ki);
/*  856 */     if (var20 > width) {
/*  857 */       var20 = width;
/*      */     }
/*  859 */     float r = (var20 > 50) ? 0.58F : ((var20 > 25) ? 1.0F : 1.0F);
/*  860 */     float g = (var20 > 50) ? 0.83F : ((var20 > 25) ? 1.0F : 0.2F);
/*  861 */     float b = (var20 > 50) ? 0.23F : ((var20 > 25) ? 0.2F : 0.2F);
/*      */     
/*  863 */     GL11.glPushMatrix();
/*  864 */     this.field_73735_i = -90.0F;
/*  865 */     ResourceLocation tx2 = new ResourceLocation(JRMCoreH.tjsaoc + ":gui2.png");
/*  866 */     this.mc.field_71446_o.func_110577_a(tx2);
/*  867 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  868 */     GL11.glEnable(3042);
/*  869 */     GL11.glBlendFunc(770, 771);
/*  870 */     func_73729_b(var51, var61, 0, 0, 209, var21);
/*      */     
/*  872 */     if (var20 > 0) {
/*      */       
/*  874 */       GL11.glColor4f(r, g, b, 1.0F);
/*  875 */       func_73729_b(var51 + 18, var61 + 6, 0, 32, var20, 11);
/*      */     } 
/*  877 */     GL11.glDisable(3042);
/*      */     
/*  879 */     String var34 = "" + ki + "/" + maxki;
/*  880 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  881 */     int var38 = var51 + 170 - var8.func_78256_a(var34);
/*  882 */     int var37 = var61 + 15;
/*  883 */     float scale = 0.75F;
/*  884 */     GL11.glScalef(1.0F * scale, 1.0F * scale, 1.0F * scale);
/*  885 */     var8.func_78276_b(var34, var38 + 65, var37 + 15, JRMCoreH.techCol[1]);
/*  886 */     var8.func_78276_b("lv: " + lvl, var51 + var21 + 63, var37 + 15, JRMCoreH.techCol[1]);
/*      */     
/*  888 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderFace() {
/*  893 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  894 */     int width = var5.func_78326_a();
/*  895 */     int height = var5.func_78328_b();
/*  896 */     this.xSize_lo = width / 2.0F;
/*  897 */     this.ySize_lo = height / 2.0F;
/*  898 */     JRMCoreGuiScreen.head(20, 60, 60, 5.0F, 10.0F, (EntityLivingBase)this.mc.field_71439_g);
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderKiBar() {
/*  903 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  904 */     int var6 = var5.func_78326_a();
/*  905 */     int var7 = var5.func_78328_b();
/*  906 */     FontRenderer var8 = this.mc.field_71466_p;
/*  907 */     this.mc.field_71460_t.func_78478_c();
/*      */ 
/*      */     
/*  910 */     float ki = getClientEnergy();
/*  911 */     float maxki = getClientMaxEnergy();
/*  912 */     int var51 = 0;
/*  913 */     int var61 = 0;
/*  914 */     if (JRMCoreH.DBC()) {
/*  915 */       var51 = JRMCoreHDBC.DBCgetConfigcwfb() + 10;
/*  916 */       var61 = JRMCoreHDBC.DBCgetConfigchfb() + 10;
/*      */     } 
/*  918 */     short var21 = JGConfigClientSettings.get_hud_x();
/*  919 */     byte pwr = JRMCoreH.Pwrtyp;
/*  920 */     float width = (JRMCoreH.isPowerTypeKi(pwr) ? var21 : (JRMCoreH.isPowerTypeChakra(pwr) ? 85 : var21));
/*  921 */     float max = maxki;
/*  922 */     if (max < 1.0F) {
/*  923 */       max = 1.0F;
/*      */     }
/*  925 */     float maxperc = width / max;
/*      */     
/*  927 */     float var22 = maxperc * ki;
/*  928 */     if (var22 > width) {
/*  929 */       var22 = width;
/*      */     }
/*  931 */     this.kihelp1 = var51;
/*  932 */     this.kihelp2 = var61;
/*  933 */     this.kihelp3 = var21;
/*  934 */     this.kihelp4 = var22;
/*      */ 
/*      */ 
/*      */     
/*  938 */     int var38 = 0;
/*  939 */     int var37 = 0;
/*  940 */     boolean var11 = false;
/*  941 */     int var12 = var11 ? 16777215 : 8453920;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  947 */     String var34 = "" + JRMCoreH.numSep((int)ki) + ((JRMCoreH.isRaceArcosian() && JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) > 0) ? (" (PP: " + JRMCoreH.getArcRsrv() + ")") : ((JRMCoreH.isRaceMajin() && JRMCoreH.SklLvlX(1, JRMCoreH.PlyrSkillX) > 4) ? (" (Absorption: " + JRMCoreH.getMajinAbsorptionValue() + ")") : ""));
/*      */     
/*  949 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  950 */     if (JRMCoreH.isPowerTypeKi(pwr)) {
/*      */       
/*  952 */       var38 = JRMCoreHDBC.DBCgetConfigcwfn() + ((int)width - var8.func_78256_a(var34)) / 2 + this.kihelp1;
/*  953 */       var37 = JRMCoreHDBC.DBCgetConfigchfn() + 2;
/*      */     }
/*  955 */     else if (JRMCoreH.isPowerTypeChakra(pwr)) {
/*  956 */       var38 = (2 + var8.func_78256_a(var34)) / 2;
/*  957 */       var37 = 15;
/*      */     } 
/*      */     
/*  960 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  961 */     var8.func_78276_b(var34, var38 + 1 + JGConfigClientSettings.CLIENT_hud0x, var37 + JGConfigClientSettings.CLIENT_hud0y, 0);
/*  962 */     var8.func_78276_b(var34, var38 - 1 + JGConfigClientSettings.CLIENT_hud0x, var37 + JGConfigClientSettings.CLIENT_hud0y, 0);
/*  963 */     var8.func_78276_b(var34, var38 + JGConfigClientSettings.CLIENT_hud0x, var37 + 1 + JGConfigClientSettings.CLIENT_hud0y, 0);
/*  964 */     var8.func_78276_b(var34, var38 + JGConfigClientSettings.CLIENT_hud0x, var37 - 1 + JGConfigClientSettings.CLIENT_hud0y, 0);
/*  965 */     var8.func_78276_b(var34, var38 + JGConfigClientSettings.CLIENT_hud0x, var37 + JGConfigClientSettings.CLIENT_hud0y, 8388564);
/*  966 */     kiBarHelper(this.kihelp1 + JGConfigClientSettings.CLIENT_hud0x, this.kihelp2 + JGConfigClientSettings.CLIENT_hud0y, this.kihelp3, this.kihelp4);
/*      */   }
/*      */ 
/*      */   
/*  970 */   public static String icons = JRMCoreH.tjjrmc + ":"; public static final int icon_Blocking = 0; public String getIcons() {
/*  971 */     return icons + "icons4" + ((JRMCoreH.Pwrtyp == 2) ? "nc" : "") + ".png";
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int icon_Flying = 1;
/*      */   
/*      */   public static final int icon_Release = 2;
/*      */   public static final int icon_Turbo = 2;
/*      */   public static final int icon_Kaioken = 3;
/*      */   public static final int icon_Swoop = 4;
/*      */   public static final int icon_FullMoon = 0;
/*      */   public static final int icon_GodPower = 0;
/*      */   public static final int icon_Strained = 5;
/*      */   public static final int icon_StrainIn = 5;
/*      */   public static final int icon_Fatigue = 5;
/*      */   
/*      */   public void drawIcon(int var51, int var61, int resourceID, float r, float g, float b, float w) {
/*  988 */     this.mc.func_110434_K().func_110577_a(new ResourceLocation(getIcons()));
/*  989 */     GL11.glColor4f(r, g, b, 1.0F);
/*  990 */     int h = resourceID % 16;
/*  991 */     int v = resourceID / 16;
/*  992 */     w = (w > 100.0F) ? 100.0F : w;
/*  993 */     int w2 = (int)(0.16F * (100.0F - w));
/*  994 */     func_73729_b(var51 + 2 + ((JGConfigClientSettings.CLIENT_hud0 > 1) ? 50 : 0), var61 + w2 + 2, h * 16, v * 16 + w2, 16, 16 - w2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawIcon(int var51, int var61, int resourceID) {
/*  999 */     drawIcon(var51, var61, resourceID, 1.0F, 1.0F, 1.0F, 100.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawIconB(int var51, int var61, int resourceID, float r, float g, float b, float w) {
/* 1004 */     this.mc.func_110434_K().func_110577_a(new ResourceLocation(getIcons()));
/* 1005 */     GL11.glColor4f(r, g, b, 1.0F);
/* 1006 */     int h = resourceID % 16;
/* 1007 */     int v = resourceID / 16;
/* 1008 */     w = (w > 100.0F) ? 100.0F : w;
/* 1009 */     int w2 = (int)(0.16F * (100.0F - w));
/* 1010 */     func_73729_b(var51 + 2, var61 + w2 + 2, h * 16, v * 16 + w2, 16, 16 - w2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawIconB(int var51, int var61, int resourceID) {
/* 1016 */     drawIconB(var51, var61, resourceID, 1.0F, 1.0F, 1.0F, 100.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawIcon3rdFn(int var51, int var61) {
/* 1021 */     drawIconB(var51, var61, 22, 1.0F, 1.0F, 1.0F, 100.0F);
/*      */   }
/*      */   
/* 1024 */   public int getx1() { return JGConfigClientSettings.get_hud_start_x(); } public int gety1() {
/* 1025 */     return JGConfigClientSettings.get_hud_start_y();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void kiBarHelper(int var51, int var61, short var21, float var22) {
/* 1037 */     FontRenderer var8 = this.mc.field_71466_p;
/* 1038 */     byte pwr = JRMCoreH.Pwrtyp;
/* 1039 */     ResourceLocation tx = new ResourceLocation(((pwr == 1) ? "jinryuumodscore:" : ((pwr == 2) ? "jinryuunarutoc:" : "jinryuumodscore:")) + "energy.png");
/* 1040 */     this.mc.field_71446_o.func_110577_a(tx);
/* 1041 */     this.field_73735_i = -90.0F;
/*      */     
/* 1043 */     String bc = "" + JRMCoreH.numSepShort(JRMCoreHC.BPC_ME);
/* 1044 */     GL11.glEnable(3042);
/* 1045 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 1047 */     if (JRMCoreH.isPowerTypeKi(pwr)) {
/*      */       
/* 1049 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1056 */       func_73729_b(var51, var61, 0, 0 + 
/*      */ 
/*      */           
/* 1059 */           JGConfigClientSettings.get_hud_pos(0), var21 + 
/* 1060 */           getx1(), 
/* 1061 */           JGConfigClientSettings.get_hud_y() + gety1());
/*      */       
/* 1063 */       if (var22 > 0.0F) {
/*      */         
/* 1065 */         int bc1 = 654591;
/* 1066 */         boolean evl = JRMCoreH.Algnmnt_Evil(JRMCoreH.align);
/* 1067 */         if (JRMCoreH.Algnmnt_Good(JRMCoreH.align)) { bc1 = 654591; }
/* 1068 */         else if (JRMCoreH.Algnmnt_Neut(JRMCoreH.align)) { bc1 = 13478142; }
/* 1069 */         else if (evl) { bc1 = 16522030; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1077 */         int s = JRMCoreHDBC.getPlayerColor2(3, bc1, pwr, JRMCoreH.Race, JRMCoreH.State, JRMCoreH.StusEfctsMe(17), JRMCoreH.lgndb2(), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20));
/* 1078 */         float h2 = (s >> 16 & 0xFF) / 255.0F;
/* 1079 */         float h3 = (s >> 8 & 0xFF) / 255.0F;
/* 1080 */         float h4 = (s & 0xFF) / 255.0F;
/* 1081 */         float h1 = 1.0F;
/*      */         
/* 1083 */         GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, 1.0F);
/* 1084 */         func_73729_b(var51 + getx1(), var61, 0 + 
/*      */             
/* 1086 */             getx1(), 
/* 1087 */             JGConfigClientSettings.get_hud_pos(1) + gety1() + ((JGConfigClientSettings.CLIENT_hud0 > 1) ? -2 : 0), (int)var22, 
/*      */             
/* 1089 */             JGConfigClientSettings.get_hud_y());
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1094 */       if (JRMCoreH.curRelease >= 0) {
/* 1095 */         float var5 = var21 / 100.0F * getSmoothReleaseLevel();
/* 1096 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         
/* 1098 */         GL11.glPushMatrix();
/* 1099 */         GL11.glEnable(3042);
/* 1100 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1101 */         GL11.glBlendFunc(775, 769);
/* 1102 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         
/* 1104 */         func_73729_b(var51 - 3 + (int)var5 + getx1(), var61, 0 + 
/*      */             
/* 1106 */             getx1(), 0 + ((JGConfigClientSettings.CLIENT_hud0 > 1) ? (
/* 1107 */             JGConfigClientSettings.get_hud_pos(0) + JGConfigClientSettings.get_hud_height(2) - 6) : (JGConfigClientSettings.get_hud_pos(2) + gety1())), 6, 
/*      */             
/* 1109 */             JGConfigClientSettings.get_hud_y());
/* 1110 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1111 */         GL11.glDisable(3042);
/* 1112 */         GL11.glPopMatrix();
/*      */       } 
/*      */       
/* 1115 */       var8.func_78276_b(((JRMCoreH.BPMode == 1) ? "f" : "") + "BP " + bc + " §8" + JRMCoreH.DifficultySNmes[JRMCoreH.Dffclty] + " §0" + getSmoothReleaseLevel() + "%", var51 + 2 + ((JGConfigClientSettings.CLIENT_hud0 > 1) ? 55 : 10), var61 + 2 + ((JGConfigClientSettings.CLIENT_hud0 > 1) ? 5 : 0), 0);
/*      */ 
/*      */       
/* 1118 */       showSE(var51, var61, 0, 0);
/*      */     }
/* 1120 */     else if (JRMCoreH.isPowerTypeChakra(pwr)) {
/* 1121 */       var51 = 0;
/* 1122 */       var61 = 25;
/* 1123 */       var21 = 48;
/* 1124 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1125 */       GL11.glEnable(3042);
/* 1126 */       GL11.glBlendFunc(770, 771);
/* 1127 */       func_73729_b(var51 + JGConfigClientSettings.CLIENT_hud0x, var61 + JGConfigClientSettings.CLIENT_hud0y, 0, 86, var21, 85);
/*      */       
/* 1129 */       if (var22 > 0.0F) {
/*      */         
/* 1131 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1132 */         func_73729_b(var51 + JGConfigClientSettings.CLIENT_hud0x, var61 + 42 + JGConfigClientSettings.CLIENT_hud0y, 0, 42, var21, (int)var22 / 2 + 1);
/* 1133 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1134 */         func_73729_b(var51 + JGConfigClientSettings.CLIENT_hud0x, var61 + 42 - (int)var22 / 2 + JGConfigClientSettings.CLIENT_hud0y, 0, 42 - (int)var22 / 2, var21, (int)var22 / 2);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1144 */       GL11.glDisable(3042);
/* 1145 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1146 */       bc = "" + JRMCoreH.gkap(JRMCoreH.bpc((EntityPlayer)this.mc.field_71439_g, this.mc.field_71439_g.func_70005_c_(), JRMCoreH.Pwrtyp), "SL_ME");
/* 1147 */       var8.func_78276_b("SL " + bc + " §8" + JRMCoreH.DifficultySNmes[JRMCoreH.Dffclty], var51 + 5 + JGConfigClientSettings.CLIENT_hud0x, 5 + JGConfigClientSettings.CLIENT_hud0y, 0);
/* 1148 */       String s = " §0" + getSmoothReleaseLevel() + "%";
/* 1149 */       var8.func_78276_b(s, var21 / 2 - var8.func_78256_a(s) / 2 + JGConfigClientSettings.CLIENT_hud0x, 60 + JGConfigClientSettings.CLIENT_hud0y, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1160 */       showSE(var51 + 45 + JGConfigClientSettings.CLIENT_hud0x, var61 - 20 + JGConfigClientSettings.CLIENT_hud0y, 0, 0);
/*      */     }
/* 1162 */     else if (pwr == 3) {
/*      */       
/* 1164 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1165 */       func_73729_b(var51, var61, 0, 130, var21, 10);
/*      */       
/* 1167 */       if (var22 > 0.0F) {
/*      */         
/* 1169 */         int bc1 = 654591;
/* 1170 */         if (JRMCoreH.align > 66) { bc1 = 654591; }
/* 1171 */         else if (JRMCoreH.align <= 66 && JRMCoreH.align >= 33) { bc1 = 13478142; }
/* 1172 */         else if (JRMCoreH.align < 33) { bc1 = 16522030; }
/* 1173 */          int s = ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && JRMCoreH.State > 0) ? 16574610 : bc1;
/* 1174 */         float h2 = (s >> 16 & 0xFF) / 255.0F;
/* 1175 */         float h3 = (s >> 8 & 0xFF) / 255.0F;
/* 1176 */         float h4 = (s & 0xFF) / 255.0F;
/* 1177 */         float h1 = 1.0F;
/* 1178 */         GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, 1.0F);
/* 1179 */         func_73729_b(var51, var61, 0, 140, (int)var22, 10);
/*      */       } 
/* 1181 */       if (JRMCoreH.curRelease >= 0) {
/*      */         
/* 1183 */         float var5 = var21 / 100.0F * getSmoothReleaseLevel();
/* 1184 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1185 */         func_73729_b(var51 - 3 + (int)var5, var61, 0, 150, 6, 10);
/*      */       } 
/* 1187 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1188 */       var8.func_78276_b("BP " + bc + " §8" + JRMCoreH.DifficultySNmes[JRMCoreH.Dffclty] + " §0" + getSmoothReleaseLevel() + "%", var51 + 2, var61 + 2, 0);
/* 1189 */       EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/* 1190 */       ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)entityClientPlayerMP);
/* 1191 */       String block = (props.getBlocking() == 1) ? "Blocking " : "";
/* 1192 */       String fly = JRMCoreHDBC.DBCKiTechFly() ? "Flying " : "";
/* 1193 */       String aura = JRMCoreH.StusEfctsMe(4) ? "Releasing " : "";
/* 1194 */       String trbo = JRMCoreH.StusEfctsMe(3) ? "Turbo " : "";
/* 1195 */       String kken = JRMCoreH.StusEfctsMe(5) ? "Kaioken " : "";
/*      */ 
/*      */       
/* 1198 */       var8.func_78276_b(block + fly + aura + trbo + kken, var51 + 2, var61 + 12, 0);
/*      */     } 
/* 1200 */     GL11.glDisable(3042);
/*      */   }
/*      */ 
/*      */   
/*      */   public void showSE(int var51, int var61, int var71, int var81) {
/* 1205 */     GL11.glPushMatrix();
/* 1206 */     GL11.glEnable(3042);
/* 1207 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 1209 */     var61 += JGConfigClientSettings.get_hud_y();
/* 1210 */     FontRenderer var8 = this.mc.field_71466_p;
/* 1211 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1212 */     String[] d0 = JRMCoreH.data(0, "0;0").split(";");
/* 1213 */     String[] d18 = JRMCoreH.data(18, "0;0;0;0;0;0;0;0;0;0;0;0").split(";");
/* 1214 */     String[] d20 = JRMCoreH.dataP(20, "0;0;0;0;0;0;0;0;0;0;0;0").split(";");
/* 1215 */     int strn = Integer.parseInt(d20[4]);
/* 1216 */     int strnAct = Integer.parseInt(d20[5]);
/* 1217 */     int strnG = Integer.parseInt(d20[6]);
/* 1218 */     int pn = JRMCoreH.pnp;
/* 1219 */     int ko = Integer.parseInt(d20[9]);
/* 1220 */     int GP = Integer.parseInt(d0[1]);
/* 1221 */     String strnS = "(" + JRMCoreH.format_remTim(strn * 5) + ")";
/* 1222 */     String strnAS = "(" + JRMCoreH.format_remTim(strnAct * 5) + ")";
/* 1223 */     String strnGS = "(" + JRMCoreH.format_remTim(strnG * 5) + ")";
/* 1224 */     String GPS = "(" + JRMCoreH.format_remTim(GP * 5) + ")";
/* 1225 */     String pnS = "(" + JRMCoreH.format_remTim(pn * 5) + ")";
/* 1226 */     String koS = "(" + JRMCoreH.format_remTim(ko * 5) + ")";
/*      */     
/* 1228 */     String[] fuse = d18[2].split(",");
/* 1229 */     int fusel0 = (fuse.length == 3) ? Integer.parseInt(fuse[2]) : 0;
/* 1230 */     String fusel = "(" + JRMCoreH.format_remTim(fusel0 * 5) + ")";
/* 1231 */     fusel = (fusel0 > 0) ? ("Fused" + fusel + " ") : "";
/*      */     
/* 1233 */     int fuseo0 = (fuse.length == 1 && !fuse[0].equals(" ")) ? Integer.parseInt(fuse[0]) : 0;
/* 1234 */     String fuzeo = "(" + JRMCoreH.format_remTim(fuseo0 * 5) + ")";
/* 1235 */     fuzeo = (fuseo0 > 0) ? ("NoFuse" + fuzeo + " ") : "";
/*      */ 
/*      */     
/* 1238 */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/* 1239 */     ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)entityClientPlayerMP);
/* 1240 */     int resourceID = -1;
/* 1241 */     boolean block = (props.getBlocking() == 1);
/* 1242 */     boolean instantTransmission = (props.getBlocking() == 2);
/* 1243 */     boolean fly = (JRMCoreH.Pwrtyp == 1) ? JRMCoreHDBC.DBCKiTechFly() : false;
/* 1244 */     boolean aura = JRMCoreH.StusEfctsMe(4);
/* 1245 */     boolean trfm = JRMCoreH.StusEfctsMe(1);
/* 1246 */     boolean trbo = JRMCoreH.StusEfctsMe(3);
/* 1247 */     boolean kken = JRMCoreH.StusEfctsMe(5);
/* 1248 */     boolean swop = JRMCoreH.StusEfctsMe(7);
/* 1249 */     boolean flmn = JRMCoreH.StusEfctsMe(8);
/* 1250 */     boolean majn = JRMCoreH.StusEfctsMe(12);
/* 1251 */     boolean mstc = JRMCoreH.StusEfctsMe(13);
/* 1252 */     boolean lgnd = JRMCoreH.StusEfctsMe(14);
/* 1253 */     boolean vsna = JRMCoreH.StusEfctsMe(17);
/* 1254 */     boolean ulin = JRMCoreH.StusEfctsMe(19);
/* 1255 */     boolean god = JRMCoreH.StusEfctsMe(20);
/*      */ 
/*      */ 
/*      */     
/* 1259 */     String gp = (GP > 0) ? ("GodPower" + GPS + " ") : "";
/* 1260 */     String strnd = (strn > 0) ? ("Strained" + strnS + " ") : "";
/* 1261 */     String strndA = (strnAct > 0) ? ("StrainIn" + strnAS + " ") : "";
/* 1262 */     String strndG = (strnG > 0) ? ("Fatigue" + strnGS + " ") : "";
/* 1263 */     String pnd = (pn > 0) ? ("Pain" + pnS + " ") : "";
/* 1264 */     String kod = (ko > 0) ? ("KO" + koS + " ") : "";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1270 */     int[] f = { -1, 18, -1, 2, 2, 3, -1, 4, 7, -1, -1, -1, 9, 19, 10, 3, 11, 15, 16, 17, 23 };
/*      */     
/* 1272 */     this.mc.func_110434_K().func_110577_a(new ResourceLocation(getIcons()));
/* 1273 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1274 */     int i = 0;
/* 1275 */     int j = 0;
/*      */ 
/*      */     
/* 1278 */     int rgb = get_Property(6, 4);
/* 1279 */     rgb = (rgb << 8) + get_Property(6, 5);
/* 1280 */     rgb = (rgb << 8) + get_Property(6, 6);
/*      */ 
/*      */     
/* 1283 */     if (JRMCoreH.pwr_cha(JRMCoreH.Pwrtyp) && JRMCoreH.Class == 2 && JRMCoreH.State > 0) {
/* 1284 */       drawIcon(var51 + i, var61 + j, 13); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1286 */     }  if (JRMCoreH.pwr_cha(JRMCoreH.Pwrtyp) && JRMCoreH.Class == 1 && JRMCoreH.State > 0) {
/* 1287 */       drawIcon(var51 + i, var61 + j, 12); if (var71 == 0) { i += 18; } else { j += 18; }  if (var71 == 0) { if (var71 == 0) { i += 18; } else { j += 18; }  } else { j += 18; }
/*      */     
/* 1289 */     }  if (JRMCoreH.StusEfctsMe(16)) {
/* 1290 */       drawIcon(var51 + i, var61 + j, 11); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1292 */     }  if (vsna) {
/* 1293 */       drawIcon(var51 + i, var61 + j, f[17]); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1295 */     }  if (lgnd) {
/* 1296 */       drawIcon(var51 + i, var61 + j, 10); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1298 */     }  if (majn) {
/* 1299 */       drawIcon(var51 + i, var61 + j, 9); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1301 */     }  if (mstc) {
/* 1302 */       drawIcon(var51 + i, var61 + j, f[13]); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1304 */     }  if (ulin) {
/* 1305 */       drawIcon(var51 + i, var61 + j, f[19]); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1307 */     }  if (god) {
/* 1308 */       drawIcon(var51 + i, var61 + j, f[20]); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/*      */     } 
/*      */ 
/*      */     
/* 1313 */     if (block) {
/* 1314 */       drawIcon(var51 + i, var61 + j, 0); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1316 */     }  if (fly) {
/* 1317 */       drawIcon(var51 + i, var61 + j, 1); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1319 */     }  if (aura) {
/* 1320 */       drawIcon(var51 + i, var61 + j, 2); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1322 */     }  if (trbo) {
/* 1323 */       drawIcon(var51 + i, var61 + j, 2); drawIcon(var51 + i, var61 + j, 128); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1325 */     }  if (kken) {
/* 1326 */       drawIcon(var51 + i, var61 + j, 3); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1328 */     }  if (trfm) {
/* 1329 */       drawIcon(var51 + i, var61 + j, f[1]); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1331 */     }  if (JRMCoreH.Pwrtyp == 2 && JRMCoreH.State2 > 0) {
/* 1332 */       drawIcon(var51 + i, var61 + j, 3); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1334 */     }  if (swop) {
/* 1335 */       drawIcon(var51 + i, var61 + j, 4); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1337 */     }  if (flmn) {
/* 1338 */       drawIcon(var51 + i, var61 + j, 7); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/* 1340 */     }  if (kod.length() > 1) {
/* 1341 */       drawIcon(var51 + i, var61 + j, 20); if (var71 == 0) { i += 18; } else { j += 18; }
/* 1342 */        drawString2(var8, kod, var51 + 2 + i + ((!JGConfigClientSettings.CLIENT_hud2 && JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0) + ((var71 == 1) ? 19 : 0), var61 + j + 12, var81, false, JGConfigClientSettings.CLIENT_hud2 ? rgb : 0);
/* 1343 */       if (var71 == 0) i += var8.func_78256_a(kod); 
/*      */     } 
/* 1345 */     if (gp.length() > 1) {
/* 1346 */       drawIcon(var51 + i, var61 + j, 8); if (var71 == 0) { i += 18; } else { j += 18; }
/* 1347 */        drawString2(var8, gp, var51 + 2 + i + ((!JGConfigClientSettings.CLIENT_hud2 && JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0) + ((var71 == 1) ? 19 : 0), var61 + j + 12, var81, false, JGConfigClientSettings.CLIENT_hud2 ? rgb : 0);
/* 1348 */       if (var71 == 0) i += var8.func_78256_a(gp); 
/*      */     } 
/* 1350 */     if (strnd.length() > 1) {
/* 1351 */       drawIcon(var51 + i, var61 + j, 6); if (var71 == 0) { i += 18; } else { j += 18; }
/* 1352 */        drawString2(var8, strnd, var51 + 2 + i + ((!JGConfigClientSettings.CLIENT_hud2 && JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0) + ((var71 == 1) ? 19 : 0), var61 + j + 12, var81, false, JGConfigClientSettings.CLIENT_hud2 ? rgb : 0);
/* 1353 */       if (var71 == 0) i += var8.func_78256_a(strnd); 
/*      */     } 
/* 1355 */     if (pnd.length() > 1) {
/* 1356 */       drawIcon(var51 + i, var61 + j, f[18]); if (var71 == 0) { i += 18; } else { j += 18; }
/* 1357 */        drawString2(var8, pnd, var51 + 2 + i + ((!JGConfigClientSettings.CLIENT_hud2 && JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0) + ((var71 == 1) ? 19 : 0), var61 + j + 2, var81, false, JGConfigClientSettings.CLIENT_hud2 ? rgb : 0);
/* 1358 */       if (var71 == 0) i += var8.func_78256_a(pnd); 
/*      */     } 
/* 1360 */     if (strndA.length() > 1) {
/* 1361 */       drawIcon(var51 + i, var61 + j, 5);
/* 1362 */       drawIcon(var51 + i, var61 + j, 5, 1.0F, 0.5F, 0.5F, 30.0F + (24 - ((strnAct > 24) ? 24 : strnAct)) * 2.92F);
/* 1363 */       drawIcon(var51 + i, var61 + j, 129); if (var71 == 0) { i += 18; } else { j += 18; }
/* 1364 */        drawString2(var8, strndA, var51 + 2 + i + ((!JGConfigClientSettings.CLIENT_hud2 && JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0) + ((var71 == 1) ? 19 : 0), var61 + j + 12, var81, false, JGConfigClientSettings.CLIENT_hud2 ? rgb : 0);
/* 1365 */       if (var71 == 0) i += var8.func_78256_a(strndA); 
/*      */     } 
/* 1367 */     if (strndG.length() > 1) {
/* 1368 */       drawIcon(var51 + i, var61 + j, 8); drawIcon(var51 + i, var61 + j, 130); if (var71 == 0) { i += 18; } else { j += 18; }
/* 1369 */        drawString2(var8, strndG, var51 + 2 + i + ((!JGConfigClientSettings.CLIENT_hud2 && JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0) + ((var71 == 1) ? 19 : 0), var61 + j + 12, var81, false, JGConfigClientSettings.CLIENT_hud2 ? rgb : 0);
/* 1370 */       if (var71 == 0) i += var8.func_78256_a(strndG); 
/*      */     } 
/* 1372 */     if (fuzeo.length() > 1) {
/* 1373 */       drawIcon(var51 + i, var61 + j, 21); if (var71 == 0) { i += 18; } else { j += 18; }
/* 1374 */        drawString2(var8, fuzeo, var51 + 2 + i + ((!JGConfigClientSettings.CLIENT_hud2 && JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0) + ((var71 == 1) ? 19 : 0), var61 + j + 12, var81, false, JGConfigClientSettings.CLIENT_hud2 ? rgb : 0);
/* 1375 */       if (var71 == 0) i += var8.func_78256_a(fuzeo); 
/*      */     } 
/* 1377 */     if (fusel.length() > 1) {
/* 1378 */       drawIcon(var51 + i, var61 + j, 21); if (var71 == 0) { i += 18; } else { j += 18; }
/* 1379 */        drawString2(var8, fusel, var51 + 2 + i + ((!JGConfigClientSettings.CLIENT_hud2 && JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0) + ((var71 == 1) ? 19 : 0), var61 + j + 12, var81, false, JGConfigClientSettings.CLIENT_hud2 ? rgb : 0);
/* 1380 */       if (var71 == 0) i += var8.func_78256_a(fusel);
/*      */     
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1386 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 1387 */     int var6 = var5.func_78326_a();
/* 1388 */     int var7 = var5.func_78328_b();
/* 1389 */     i = 0;
/* 1390 */     if (isInstantTransmissionOn() || instantTransmission) {
/* 1391 */       int xDiff = 16;
/* 1392 */       int yDiff = 8;
/* 1393 */       drawIcon3rdFn(var6 / 2 + i - 9 + xDiff, var7 / 2 - 9 + yDiff);
/*      */       
/* 1395 */       if (getInstantTransmissionPress() != null) {
/* 1396 */         long timer = Duration.between(getInstantTransmissionPress(), Instant.now()).getSeconds();
/* 1397 */         JRMCoreGuiScreen.drawStringWithBorder(var8, timer + "s", var6 / 2 - 5 + xDiff, var7 / 2 - 20 + yDiff, 16777215);
/*      */       } 
/*      */ 
/*      */       
/* 1401 */       if (getInstantTransmissionPress() == null) {
/* 1402 */         drawIcon(var6 / 2 + i - 9 + xDiff, var7 / 2 - 9 + yDiff, 130);
/*      */       
/*      */       }
/*      */     }
/* 1406 */     else if (block) {
/* 1407 */       drawIconB(var6 / 2 + i - 9, var7 / 2 - 9, 14); if (var71 == 0) { i += 18; } else { j += 18; }
/*      */     
/*      */     } 
/* 1410 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   private boolean isInstantTransmissionOn() {
/* 1414 */     return JRMCoreH.DBC() ? DBCClientTickHandler.instantTransmissionOn : false;
/*      */   }
/*      */   private Instant getInstantTransmissionPress() {
/* 1417 */     return JRMCoreH.DBC() ? DBCClientTickHandler.instantTransmissionPress : null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderTrainGui() {
/* 1422 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 1423 */     int var6 = var5.func_78326_a();
/* 1424 */     int var7 = var5.func_78328_b();
/* 1425 */     FontRenderer var8 = this.mc.field_71466_p;
/* 1426 */     ResourceLocation tx = new ResourceLocation("jinryuumodscore:gui.png");
/* 1427 */     this.mc.field_71446_o.func_110577_a(tx);
/* 1428 */     int xSize = 140;
/* 1429 */     int ySize = 72;
/* 1430 */     int guiLeft = var6 - xSize - 5;
/* 1431 */     int guiTop = 5;
/* 1432 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
/* 1433 */     func_73729_b(guiLeft, guiTop, 0, 159, xSize, ySize);
/* 1434 */     String bc = "" + JRMCoreHC.BPC_ME;
/* 1435 */     if (bc.contains("Data")) {
/* 1436 */       bc = "0";
/*      */     }
/* 1438 */     long s = Long.parseLong(bc);
/* 1439 */     int train = 0;
/* 1440 */     if (JRMCoreH.dat20 != null) train = JRMCoreH.GTrnngCB; 
/* 1441 */     if (JRMCoreH.DBC()) {
/* 1442 */       int stlhv = DBCConfig.maxTrnExp - train;
/* 1443 */       if (stlhv < 0) stlhv = 0; 
/* 1444 */       var8.func_78276_b("§8Training Info", guiLeft + 5, guiTop + 5, 0);
/* 1445 */       if (stlhv > 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1451 */         short var21 = JGConfigClientSettings.get_hud_x();
/* 1452 */         int xSize1 = var21;
/* 1453 */         float maxperc = xSize1 * 0.01F;
/* 1454 */         int d = JRMCoreH.Dffclty;
/* 1455 */         float p = JRMCoreH.Perc(d);
/*      */         
/* 1457 */         float explmt = 10.0F * p;
/* 1458 */         int var22 = (int)(maxperc * 100.0F * JRMCoreH.curExp / explmt);
/* 1459 */         if (var22 > xSize1)
/* 1460 */           var22 = xSize1; 
/* 1461 */         var8.func_78276_b("TP: " + ((JRMCoreH.curTP < 100) ? ("§2" + JRMCoreH.numSep(JRMCoreH.curTP) + ", " + ((int)explmt - JRMCoreH.curExp) + " Exp till TP gain") : ("§4" + JRMCoreH.numSep(JRMCoreH.curTP) + ", be below 100")), guiLeft + 5, guiTop + 15, 0);
/* 1462 */         var8.func_78276_b("§0Health & Energy:", guiLeft + 5, guiTop + 25, 0);
/* 1463 */         var8.func_78276_b("" + ((getClientEnergy() > getClientMaxEnergy() / 2 && getClientHealth() > getClientMaxHealth() / 2) ? "§2OK" : "§4not OK! Be above 50%"), guiLeft + 5, guiTop + 35, 0);
/* 1464 */         var8.func_78276_b("Can still gain " + stlhv + " Exp", guiLeft + 5, guiTop + 45, 0);
/* 1465 */         var8.func_78276_b("" + ((DBCH.HTCtrain && DBCH.mvng()) ? "§2Conditions are met" : "§4Conditions are not met!"), guiLeft + 5, guiTop + 55, 0);
/* 1466 */         if (DBCH.cbge > 0) DBCH.cbge--;
/*      */         
/* 1468 */         if (DBCH.cbge > 0) { var8.func_78276_b("You have gained Exp!", guiLeft + 5 + ((DBCH.cbge < 100) ? (int)((100 - DBCH.cbge) * 1.5D) : ((DBCH.cbge > 450) ? ((DBCH.cbge - 450) * 3) : 0)), guiTop + 72, 0); }
/* 1469 */         else if (DBCH.HTCtrain) { var8.func_78276_b(((s / 1000L - DBCClientTickHandler.c) / 20L + 1L) + " secs till Exp gain", guiLeft + 5, guiTop + 72, 0); }
/*      */       
/*      */       } else {
/* 1472 */         int i = JRMCoreH.txt("You reached the servers training limit: " + DBCConfig.maxTrnExp, "§0", 0, true, guiLeft + 5, guiTop + 15, xSize - 4);
/*      */       } 
/*      */       
/* 1475 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderEnChrgBar() {
/* 1482 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 1483 */     int scaleW = var5.func_78326_a();
/* 1484 */     int scaleH = var5.func_78328_b();
/* 1485 */     FontRenderer fontRenderer = this.mc.field_71466_p;
/* 1486 */     ResourceLocation tx = new ResourceLocation("jinryuumodscore:icons.png");
/* 1487 */     this.mc.field_71446_o.func_110577_a(tx);
/*      */     
/* 1489 */     short charged = JRMCoreH.charged;
/* 1490 */     byte selected = JRMCoreH.EnAtSlct;
/* 1491 */     float charge = JRMCoreH.techDBCctWc(JRMCoreH.tech(selected), JRMCoreH.tech_statmods(JRMCoreH.tech(selected)[19]));
/* 1492 */     int posX = scaleW / 2 - 30;
/* 1493 */     int posY = scaleH / 2 + 60;
/* 1494 */     short width = 60;
/* 1495 */     float chargeMax = width * 1.0F / charge;
/* 1496 */     float chargeWidth = chargeMax * charged;
/* 1497 */     if (chargeWidth > width) chargeWidth = width;
/*      */     
/* 1499 */     float overchargeWidth = chargeMax * (charged - charge);
/* 1500 */     if (overchargeWidth > width) overchargeWidth = width;
/*      */     
/* 1502 */     GL11.glEnable(3042);
/* 1503 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 1505 */     this.field_73735_i = -90.0F;
/* 1506 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1507 */     func_73729_b(posX, posY, 0, 0, width, 10);
/*      */     
/* 1509 */     if (chargeWidth > 0.0F) {
/*      */       
/* 1511 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1512 */       func_73729_b(posX, posY, 0, 10, (int)chargeWidth, 10);
/*      */     } 
/*      */     
/* 1515 */     if (overchargeWidth > 0.0F) {
/*      */       
/* 1517 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1518 */       func_73729_b(posX, posY, 60, 10, (int)overchargeWidth, 10);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1523 */     if (JGConfigClientSettings.kiAttackChargePercentageOn) {
/*      */       
/* 1525 */       String percentage = JRMCoreH.chrgPrc + "%";
/* 1526 */       int i = fontRenderer.func_78256_a(percentage);
/* 1527 */       JRMCoreGuiScreen.drawStringWithBorder(fontRenderer, percentage, posX + 30 - i / 2, posY + 2 - 2, 8388564);
/*      */     } 
/*      */     
/* 1530 */     boolean isFused = JRMCoreH.isFused();
/*      */     
/* 1532 */     int WILo = JRMCoreH.PlyrAttrbts[3], WIL = WILo;
/* 1533 */     WIL = JRMCoreH.getPlayerAttribute((EntityPlayer)JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), JRMCoreH.StusEfctsMe(5), JRMCoreH.StusEfctsMe(13), JRMCoreH.StusEfctsMe(19), JRMCoreH.StusEfctsMe(20), 1, JRMCoreH.PlyrSkills, isFused, JRMCoreH.getMajinAbsorption());
/* 1534 */     int WIL2 = JRMCoreH.getPlayerAttribute((EntityPlayer)JRMCoreClient.mc.field_71439_g, JRMCoreH.PlyrAttrbts, 3, 0, 0, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv(), JRMCoreH.StusEfctsMe(14), JRMCoreH.StusEfctsMe(12), false, false, false, false, 1, JRMCoreH.PlyrSkills, isFused, JRMCoreH.getMajinAbsorption());
/*      */     
/* 1536 */     int stat = JRMCoreH.stat((Entity)this.mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, WIL, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
/* 1537 */     int stat2 = JRMCoreH.stat((Entity)this.mc.field_71439_g, 3, JRMCoreH.Pwrtyp, 4, WIL2, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
/*      */ 
/*      */     
/* 1540 */     boolean fakeMoon = JRMCoreH.tech(selected)[0].equals("KAFakeMoon");
/*      */     
/* 1542 */     if (charged > JRMCoreH.techDBCctWc(JRMCoreH.tech(selected), JRMCoreH.tech_statmods(JRMCoreH.tech(selected)[19])) / 2.0F && !fakeMoon) {
/*      */       
/* 1544 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */       
/* 1546 */       int damage = (int)(JRMCoreH.techDBCdmg(JRMCoreH.tech(selected), stat, JRMCoreH.tech_statmods(JRMCoreH.tech(selected)[19])) * JRMCoreH.chrgPrc * 0.019999999552965164D * JRMCoreH.curRelease * 0.009999999776482582D * JRMCoreConfig.dat5696[Integer.parseInt(JRMCoreH.tech(selected)[3])][1]);
/* 1547 */       String potDam = "" + JRMCoreH.numSep(damage) + " (DMG)";
/* 1548 */       int i = fontRenderer.func_78256_a(potDam);
/* 1549 */       JRMCoreGuiScreen.drawStringWithBorder(fontRenderer, potDam, posX + 30 - i / 2, posY - 13 + 2 - 3, JRMCoreH.techCol[8]);
/*      */     } 
/*      */     
/* 1552 */     float costKi = (float)(JRMCoreH.techDBCkic(JRMCoreH.tech(selected), stat2, JRMCoreH.tech_statmods(JRMCoreH.tech(selected)[19])) * JRMCoreH.chrgPrc * 0.019999999552965164D * JRMCoreH.curRelease * 0.009999999776482582D);
/*      */     
/* 1554 */     if (fakeMoon) {
/*      */       
/* 1556 */       int kacost = Integer.parseInt(JRMCoreH.tech(selected)[7]);
/* 1557 */       costKi = (kacost * JRMCoreH.chrgPrc) * 0.04F;
/* 1558 */       costKi = (costKi > kacost) ? kacost : costKi;
/*      */     } 
/* 1560 */     costKi *= (float)JRMCoreConfig.dat5696[Integer.parseInt(JRMCoreH.tech(selected)[3])][2];
/* 1561 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1562 */     String costki = "" + JRMCoreH.numSep((int)costKi) + " (KI)";
/* 1563 */     int textWidth = fontRenderer.func_78256_a(costki);
/*      */     
/* 1565 */     JRMCoreGuiScreen.drawStringWithBorder(fontRenderer, costki, posX + 30 - textWidth / 2, posY + 13 + 2, 8388564);
/*      */     
/* 1567 */     GL11.glDisable(3042);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderRageBar() {
/* 1573 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 1574 */     int var6 = var5.func_78326_a();
/* 1575 */     int var7 = var5.func_78328_b();
/* 1576 */     FontRenderer var8 = this.mc.field_71466_p;
/* 1577 */     ResourceLocation tx = new ResourceLocation("jinryuumodscore:icons.png");
/* 1578 */     this.mc.field_71446_o.func_110577_a(tx);
/*      */ 
/*      */     
/* 1581 */     short stt = JRMCoreH.TransSaiTre[JRMCoreH.State];
/* 1582 */     if (stt < 4) {
/* 1583 */       int var51 = JRMCoreHDBC.DBCgetConfigcwfb() + 10;
/* 1584 */       int var61 = JRMCoreHDBC.DBCgetConfigchfb() + 20;
/* 1585 */       short var21 = JGConfigClientSettings.get_hud_x();
/* 1586 */       short width = var21;
/* 1587 */       float maxperc = width * 1.0F / 100.0F;
/* 1588 */       float var22 = maxperc * JRMCoreH.TransSaiCurRg;
/* 1589 */       if (var22 > width) var22 = width;
/*      */       
/* 1591 */       byte rc = JRMCoreH.Race;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1597 */       if (var22 > 0.0F) {
/*      */         
/* 1599 */         GL11.glPushMatrix();
/* 1600 */         GL11.glEnable(3042);
/* 1601 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1602 */         GL11.glBlendFunc(775, 769);
/* 1603 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1604 */         func_73729_b(var51 + JGConfigClientSettings.CLIENT_hud0x + ((JGConfigClientSettings.CLIENT_hud0 > 1) ? 51 : 0), var61 - 10 + JGConfigClientSettings.CLIENT_hud0y + ((JGConfigClientSettings.CLIENT_hud0 > 1) ? 5 : 0), 0, 141, (int)var22, 2);
/* 1605 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1606 */         GL11.glDisable(3042);
/* 1607 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rendern() {
/* 1627 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 1628 */     int var6 = var5.func_78326_a();
/* 1629 */     int var7 = var5.func_78328_b();
/* 1630 */     FontRenderer var8 = this.mc.field_71466_p;
/* 1631 */     this.mc.field_71460_t.func_78478_c();
/* 1632 */     float val = JRMCoreH.curn;
/* 1633 */     int var51 = var6 - 24;
/* 1634 */     int var61 = var7 / 2 + 33;
/*      */     
/* 1636 */     int h = 41;
/*      */     
/* 1638 */     float mp = h / 100.0F;
/* 1639 */     float var2 = mp * val;
/* 1640 */     if (var2 > h) {
/* 1641 */       var2 = h;
/*      */     }
/*      */     
/* 1644 */     this.field_73735_i = -90.0F;
/* 1645 */     ResourceLocation tx2 = new ResourceLocation("jinryuumodscore:icons.png");
/* 1646 */     this.mc.field_71446_o.func_110577_a(tx2);
/* 1647 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1648 */     GL11.glEnable(3042);
/* 1649 */     GL11.glBlendFunc(770, 771);
/* 1650 */     func_73729_b(var51, var61, 121, 80, 11, h);
/*      */     
/* 1652 */     if (var2 > 0.0F)
/*      */     {
/* 1654 */       func_73729_b(var51, (int)((var61 + h) - var2), 132, (int)((80 + h) - var2), 11, (int)var2);
/*      */     }
/* 1656 */     GL11.glDisable(3042);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void rendera() {
/* 1662 */     if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
/*      */       float r, g, b;
/* 1664 */       ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 1665 */       int var6 = var5.func_78326_a();
/* 1666 */       int var7 = var5.func_78328_b();
/* 1667 */       FontRenderer var8 = this.mc.field_71466_p;
/* 1668 */       ResourceLocation tx = new ResourceLocation("jinryuumodscore:icons.png");
/* 1669 */       this.mc.field_71446_o.func_110577_a(tx);
/*      */       
/* 1671 */       int w = 180;
/*      */       
/* 1673 */       int charged_percentage = (int)JRMCoreH.getHeatPercentageClient();
/* 1674 */       int var51 = var6 / 2 - w / 2;
/* 1675 */       int var61 = var7 - 70;
/* 1676 */       float maxperc = w / 100.0F;
/* 1677 */       float var22 = maxperc * charged_percentage;
/* 1678 */       if (var22 > w) var22 = w;
/*      */       
/* 1680 */       GL11.glEnable(3042);
/* 1681 */       GL11.glBlendFunc(770, 771);
/*      */       
/* 1683 */       this.field_73735_i = -90.0F;
/*      */       
/* 1685 */       float colorFlash = 0.2F;
/*      */       
/* 1687 */       if (charged_percentage == 100) {
/* 1688 */         r = 0.8F;
/* 1689 */         g = 0.8F;
/* 1690 */         b = 0.8F;
/*      */       
/*      */       }
/* 1693 */       else if (JRMCoreH.align < 33) {
/* 1694 */         r = 1.0F;
/* 1695 */         g = 0.3F;
/* 1696 */         b = 0.3F;
/*      */       }
/* 1698 */       else if (JRMCoreH.align < 67) {
/* 1699 */         r = 0.9F;
/* 1700 */         g = 0.45F;
/* 1701 */         b = 1.0F;
/*      */       } else {
/*      */         
/* 1704 */         r = 0.45F;
/* 1705 */         g = 0.9F;
/* 1706 */         b = 1.0F;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1711 */       int playerTick = (JRMCoreClient.mc.field_71439_g != null) ? JRMCoreClient.mc.field_71439_g.field_70173_aa : 0;
/* 1712 */       float tick = MathHelper.func_76126_a(playerTick * 0.1F) * 0.2F;
/* 1713 */       if (tick < 0.0F) tick *= -1.0F; 
/* 1714 */       if (tick > 0.2F) tick = 0.2F; 
/* 1715 */       r += tick; if (r > 1.0F) r = 1.0F; 
/* 1716 */       g += tick; if (g > 1.0F) g = 1.0F; 
/* 1717 */       b += tick; if (b > 1.0F) b = 1.0F;
/*      */ 
/*      */       
/* 1720 */       GL11.glColor4f(r, g, b, 1.0F);
/* 1721 */       func_73729_b(var51, var61, 0, 64, w + 2, 5);
/* 1722 */       if (var22 > 0.0F) {
/*      */         
/* 1724 */         float x = JRMCoreH.round((float)(System.currentTimeMillis() / 100L % 3L) / 3.0F * var22, 2);
/* 1725 */         float y = var22 - x;
/*      */         
/* 1727 */         GL11.glColor4f(r, g, b, 1.0F);
/*      */         
/* 1729 */         func_73729_b(var51 + 1, var61, (int)(1.0F + x), 69, (int)y, 5);
/*      */         
/* 1731 */         func_73729_b((int)((var51 + 1) + y), var61, 1, 69, (int)x, 5);
/*      */       } 
/*      */       
/* 1734 */       GL11.glDisable(3042);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderEnSideBar() {
/* 1741 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 1742 */     int var6 = var5.func_78326_a();
/* 1743 */     int var7 = var5.func_78328_b();
/* 1744 */     FontRenderer var8 = this.mc.field_71466_p;
/*      */     
/* 1746 */     String ic = "jinryuumodscore:icons5.png";
/* 1747 */     String ic2 = "jinryuudragonbc:icons3.png";
/* 1748 */     int xSize = 11;
/* 1749 */     int ySize = 40;
/* 1750 */     int guiLeft = var6 - xSize + 2;
/* 1751 */     int guiTop = (var7 - ySize) / 2;
/* 1752 */     GL11.glPushMatrix();
/*      */     
/* 1754 */     GL11.glEnable(3042);
/* 1755 */     GL11.glBlendFunc(770, 771);
/* 1756 */     ResourceLocation tx = new ResourceLocation(ic);
/* 1757 */     ResourceLocation tx2 = new ResourceLocation(ic2);
/* 1758 */     this.mc.field_71446_o.func_110577_a(tx);
/* 1759 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1760 */     this.field_73735_i = -90.0F;
/* 1761 */     func_73729_b(guiLeft, guiTop, 245, 0, xSize, ySize + 1);
/* 1762 */     if (JRMCoreH.mrAtts) func_73729_b(guiLeft, guiTop - ySize, 245, 0, xSize, ySize); 
/* 1763 */     guiTop -= JRMCoreH.mrAtts ? ySize : 0;
/* 1764 */     JRMCoreH.mrAtts = false; byte i;
/* 1765 */     for (i = 0; i < 8; i = (byte)(i + 1)) {
/* 1766 */       if (JRMCoreH.tech(i) != null) {
/* 1767 */         if (i > 3) {
/* 1768 */           JRMCoreH.mrAtts = true;
/* 1769 */           this.mc.field_71446_o.func_110577_a(tx2);
/*      */         } else {
/*      */           
/* 1772 */           this.mc.field_71446_o.func_110577_a(tx);
/*      */         } 
/* 1774 */         String type = JRMCoreH.tech(i)[3];
/* 1775 */         String dam = JRMCoreH.tech(i)[5];
/* 1776 */         String effect = JRMCoreH.tech(i)[6];
/* 1777 */         String cd = JRMCoreH.tech(i)[9];
/* 1778 */         String color = JRMCoreH.tech(i)[10];
/* 1779 */         String den = JRMCoreH.tech(i)[11];
/* 1780 */         int size = (int)(Integer.parseInt(dam) * 0.1F / Integer.parseInt(den));
/*      */         
/* 1782 */         xSize = 9;
/* 1783 */         ySize = 9;
/* 1784 */         guiLeft = var6 - xSize + 3;
/*      */         
/* 1786 */         if (effect.contains("1")) {
/* 1787 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1788 */           func_73729_b(guiLeft, guiTop + 1 + i * 10, 178, 0, xSize, ySize);
/*      */         } 
/* 1790 */         int col = Integer.parseInt(color);
/*      */         
/* 1792 */         if (col == 0 && JRMCoreH.align > 66) col = 2; 
/* 1793 */         if (col == 0 && JRMCoreH.align <= 66 && JRMCoreH.align >= 33) col = 3; 
/* 1794 */         if (col == 0 && JRMCoreH.align < 33) col = 4;
/*      */         
/* 1796 */         col = JRMCoreH.techCol[col];
/*      */         
/* 1798 */         float h2 = (col >> 16 & 0xFF) / 255.0F;
/* 1799 */         float h3 = (col >> 8 & 0xFF) / 255.0F;
/* 1800 */         float h4 = (col & 0xFF) / 255.0F;
/*      */         
/* 1802 */         if (JRMCoreH.mrAtts) {
/* 1803 */           int ikon = Integer.parseInt(JRMCoreH.tech(i)[15]) - 1;
/* 1804 */           int ikonH = ikon / 16;
/* 1805 */           int ikonV = ikon - ikonH * 16;
/* 1806 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1807 */           func_73729_b(guiLeft, guiTop + 1 + i * 10, ikonV * xSize, ikonH * ySize, xSize, ySize);
/*      */         } else {
/* 1809 */           GL11.glColor4f(h2, h3, h4, 1.0F);
/* 1810 */           func_73729_b(guiLeft, guiTop + 1 + i * 10, 187 + size / 5 * xSize, Integer.parseInt(type) * ySize, xSize, ySize);
/*      */         } 
/*      */ 
/*      */         
/* 1814 */         if (JRMCoreH.techCD(i) != 0.0F) {
/* 1815 */           var8.func_78276_b(JRMCoreH.round(JRMCoreH.techCD(i) * 0.1F, 1) + "", guiLeft - 25, guiTop + 1 + i * 10, 0);
/*      */         }
/*      */       } 
/*      */     } 
/* 1819 */     if (JRMCoreH.EnAtSlct > (JRMCoreH.mrAtts ? 7 : 3)) JRMCoreH.EnAtSlct = 0;
/*      */ 
/*      */     
/* 1822 */     this.mc.field_71446_o.func_110577_a(tx);
/* 1823 */     byte selc = JRMCoreH.EnAtSlct;
/* 1824 */     int x = 13;
/* 1825 */     int y = 13;
/* 1826 */     int Left = var6 - x + 1;
/* 1827 */     int Top = guiTop - 1;
/* 1828 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1829 */     func_73729_b(Left, selc * 10 + Top, 232, 0, x, y);
/*      */     
/* 1831 */     GL11.glDisable(3042);
/* 1832 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderEnSideBarNC() {
/* 1838 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 1839 */     int var6 = var5.func_78326_a();
/* 1840 */     int var7 = var5.func_78328_b();
/* 1841 */     FontRenderer var8 = this.mc.field_71466_p;
/*      */     
/* 1843 */     String ic2 = JRMCoreH.tjnc + ":icons2.png";
/* 1844 */     int xSize = 11;
/* 1845 */     int ySize = 40;
/* 1846 */     int guiLeft = var6 - xSize + 2;
/* 1847 */     int guiTop = (var7 - ySize) / 2;
/* 1848 */     GL11.glPushMatrix();
/* 1849 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1850 */     GL11.glEnable(3042);
/* 1851 */     GL11.glBlendFunc(770, 771);
/* 1852 */     ResourceLocation tx2 = new ResourceLocation(ic2);
/* 1853 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1854 */     this.field_73735_i = -90.0F;
/*      */     
/* 1856 */     this.mc.field_71446_o.func_110577_a(tx2);
/*      */     
/* 1858 */     xSize = 16;
/* 1859 */     ySize = 16;
/* 1860 */     guiLeft = var6 - xSize + 3;
/*      */     
/* 1862 */     int ikon = JRMCoreHNC.iconInList();
/* 1863 */     int ikonH = ikon / 16;
/* 1864 */     int ikonV = ikon - ikonH * 16;
/* 1865 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1866 */     func_73729_b(guiLeft, guiTop + 1 + 10, ikonV * xSize, ikonH * ySize, xSize, ySize);
/*      */ 
/*      */     
/* 1869 */     GL11.glDisable(3042);
/* 1870 */     GL11.glPopMatrix();
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiBars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */