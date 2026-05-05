/*     */ package JinRyuu.JRMCore.client.minigame;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiScreen;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameAirBoxing;
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.PositionedSoundRecord;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MiniGameAirBoxing extends MiniGame {
/*     */   public final boolean DEBUG = false;
/*     */   public static final int KEY_FORWARD = 0;
/*     */   public static final int KEY_LEFT = 1;
/*     */   public static final int KEY_BACK = 2;
/*     */   public static final int KEY_RIGHT = 3;
/*     */   public static final int ANIMATION_HURT = 5;
/*     */   public static final int ANIMATION_VICTORY = 6;
/*     */   public static final int ANIMATION_DEFEAT = 7;
/*  26 */   private final int KEY_WIDTH = 17; private final int KEY_HEIGHT = 21;
/*     */ 
/*     */   
/*  29 */   private ArrayList<KeyData> keys = new ArrayList<KeyData>(); private boolean wasKeyPressed;
/*     */   private boolean wasKeyChecked;
/*     */   private int lastKeyPressed;
/*  32 */   public int comboCounter = 0;
/*     */   public Instant lastUpdate;
/*  34 */   public long lastUpdateMillis = 0L; public long spawnTimer = 0L;
/*     */   
/*     */   public float gameModelAge;
/*     */   
/*     */   public boolean gameModelAnimationChanged;
/*     */   public int gameModelAnimationID;
/*  40 */   private final byte RESULT_SUCCESS = 0; private final byte RESULT_FAIL = 1;
/*     */   
/*     */   private byte lastKeyResult;
/*     */   private Instant lastKeyResultTime;
/*  44 */   public ArrayList<Integer> airboxingResults = new ArrayList<Integer>();
/*  45 */   public ArrayList<Instant> airboxingResultsTime = new ArrayList<Instant>();
/*     */   
/*     */   public boolean endAnimation;
/*     */   public boolean endAnimationStart;
/*     */   private Instant endTimer;
/*     */   private Instant TPusedLimitCheckTimer;
/*  51 */   private int endTimerMillis = 0;
/*     */   
/*     */   private Instant modeTimer;
/*  54 */   public int currentMode = 0;
/*  55 */   private int modeLength = 0;
/*     */   
/*  57 */   private static final float[] mR = new float[] { 1.0F, 0.6F, 0.6F, 1.0F };
/*  58 */   private static final float[] mG = new float[] { 0.6F, 0.6F, 1.0F, 1.0F };
/*  59 */   private static final float[] mB = new float[] { 0.6F, 1.0F, 0.6F, 1.0F };
/*  60 */   private float r = 1.0F, g = 1.0F, b = 1.0F;
/*     */ 
/*     */   
/*     */   public void gameReset() {
/*  64 */     this.keys.clear();
/*  65 */     this.airboxingResults.clear();
/*  66 */     this.airboxingResultsTime.clear();
/*     */     
/*  68 */     this.lvl = 0;
/*  69 */     this.score = 0;
/*  70 */     this.comboCounter = 0;
/*  71 */     this.wasKeyPressed = false;
/*  72 */     this.wasKeyChecked = false;
/*  73 */     this.lastKeyPressed = -1;
/*  74 */     this.state = 1;
/*  75 */     this.lastUpdate = Instant.now();
/*  76 */     this.lastUpdateMillis = 0L;
/*  77 */     this.spawnTimer = 0L;
/*  78 */     playAnimation(0);
/*  79 */     this.lastKeyResult = -1;
/*  80 */     this.lastKeyResultTime = null;
/*  81 */     this.endAnimation = true;
/*  82 */     this.endAnimationStart = false;
/*  83 */     this.endTimer = null;
/*  84 */     this.endTimerMillis = 0;
/*  85 */     this.TPusedLimitCheckTimer = null;
/*  86 */     this.modeTimer = Instant.now();
/*  87 */     this.currentMode = (int)(Math.random() * 4.0D);
/*  88 */     this.modeLength = (int)(Math.random() * 5.0D) + 5;
/*  89 */     this.lives = JGConfigMiniGameAirBoxing.StartLife;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateStart() {
/*  95 */     if (Duration.between(this.lastUpdate, Instant.now()).toMillis() / 1000L >= 1L) {
/*     */       
/*  97 */       this.lastUpdate = Instant.now();
/*  98 */       this.state = 2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void chooseReward() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void stateManager(int guiLeft, int guiTop) {
/* 109 */     if (this.state != 0 && (this.TPusedLimitCheckTimer == null || Duration.between(this.TPusedLimitCheckTimer, Instant.now()).toMillis() / 1000L >= 10L)) {
/*     */       
/* 111 */       this.TPusedLimitCheckTimer = Instant.now();
/* 112 */       JRMCoreH.quad(10, 2, -1, 0);
/*     */     } 
/*     */     
/* 115 */     super.stateManager(guiLeft, guiTop);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(int guiLeft, int guiTop) {
/* 121 */     if (JGConfigClientSettings.airboxingAnimatedColorOn) {
/*     */       
/* 123 */       this.r = addDifference(this.r, mR[this.currentMode]);
/* 124 */       this.g = addDifference(this.g, mG[this.currentMode]);
/* 125 */       this.b = addDifference(this.b, mB[this.currentMode]);
/*     */     } else {
/*     */       
/* 128 */       this.r = 1.0F;
/* 129 */       this.g = 1.0F;
/* 130 */       this.b = 1.0F;
/*     */     } 
/*     */     
/* 133 */     updateTimers();
/*     */     
/* 135 */     if (this.lives <= 0 || this.endAnimationStart) {
/*     */       
/* 137 */       if (this.endAnimation) {
/* 138 */         if (this.endTimer != null) {
/* 139 */           this.endTimerMillis = (int)(this.endTimerMillis + Duration.between(this.endTimer, Instant.now()).toMillis());
/* 140 */           if (this.endTimerMillis >= 1000) {
/* 141 */             playAnimation((this.lives <= 0) ? 7 : 6);
/* 142 */             this.endAnimation = false;
/* 143 */             this.state = 3;
/* 144 */             this.endAnimationStart = false;
/*     */           } 
/*     */         } 
/* 147 */         this.endTimer = Instant.now();
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 152 */     String length = this.score + "";
/* 153 */     this.lvl = length.length();
/* 154 */     if (this.lvl > 100) this.lvl = 100;
/*     */     
/* 156 */     spawnKey();
/*     */     
/* 158 */     isKeyPressed();
/*     */     
/* 160 */     for (int i = this.keys.size() - 1; i >= 0; i--) {
/*     */       
/* 162 */       float speed = JGConfigMiniGameAirBoxing.KeySpeed[((KeyData)this.keys.get(i)).mode];
/* 163 */       KeyData keyData = this.keys.get(i); keyData.xProgress = keyData.xProgress - speed * (float)this.lastUpdateMillis;
/* 164 */       float xProgress = (this.keys.get(i)).xProgress;
/* 165 */       if (xProgress <= -134.0F) {
/*     */         
/* 167 */         if (!(this.keys.get(i)).catched) {
/*     */           
/* 169 */           this.lastKeyResultTime = null;
/* 170 */           if (!(this.keys.get(i)).missed) {
/* 171 */             this.lives -= JGConfigMiniGameAirBoxing.KeyLifeTaken[((KeyData)this.keys.get(i)).mode];
/* 172 */             this.lastKeyResult = 1;
/* 173 */             this.comboCounter = 0;
/* 174 */             playAnimation(5);
/* 175 */             this.airboxingResults.add(Integer.valueOf(1));
/* 176 */             this.airboxingResultsTime.add(Instant.now());
/*     */           } 
/*     */         } 
/* 179 */         this.keys.remove(i);
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     int MIN = -105, MAX = -122;
/* 184 */     if (!this.wasKeyChecked && this.keys.size() > 0 && this.wasKeyPressed) {
/*     */       
/* 186 */       for (KeyData key : this.keys) {
/*     */         
/* 188 */         if (!key.catched) {
/*     */           
/* 190 */           if (this.lastKeyPressed != key.id || key.xProgress > -105.0F || key.xProgress <= -122.0F) {
/*     */             
/* 192 */             key.missed = true;
/* 193 */             this.lives -= JGConfigMiniGameAirBoxing.KeyLifeTaken[key.mode];
/* 194 */             this.comboCounter = 0;
/* 195 */             playAnimation(5);
/* 196 */             this.lastKeyResult = 1;
/* 197 */             this.lastKeyResultTime = null;
/* 198 */             this.airboxingResults.add(Integer.valueOf(1));
/* 199 */             this.airboxingResultsTime.add(Instant.now()); continue;
/*     */           } 
/* 201 */           if (this.lastKeyPressed == key.id && key.xProgress <= -105.0F && key.xProgress > -122.0F && !key.missed) {
/*     */             
/* 203 */             this.comboCounter++;
/* 204 */             this.score += (this.comboCounter + 1) * (this.lvl + 1);
/* 205 */             key.catched = true;
/* 206 */             playAnimation(key.id + 1);
/* 207 */             this.lastKeyResult = 0;
/* 208 */             this.lastKeyResultTime = null;
/* 209 */             this.airboxingResults.add(Integer.valueOf(0));
/* 210 */             this.airboxingResultsTime.add(Instant.now());
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 215 */       this.wasKeyChecked = true;
/*     */     } 
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
/* 247 */     draw(guiLeft, guiTop);
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateTimers() {
/* 252 */     this.lastUpdateMillis = Duration.between(this.lastUpdate, Instant.now()).toMillis();
/* 253 */     this.lastUpdate = Instant.now();
/* 254 */     this.spawnTimer += this.lastUpdateMillis;
/*     */     
/* 256 */     if (Duration.between(this.modeTimer, Instant.now()).toMillis() / 1000L > this.modeLength) {
/* 257 */       int lastMode = this.currentMode;
/* 258 */       byte maxWhile = 0;
/* 259 */       while (this.currentMode == lastMode && maxWhile < 100) {
/*     */         
/* 261 */         this.currentMode = (int)(Math.random() * 4.0D);
/* 262 */         this.modeLength = (int)(Math.random() * 5.0D) + 5;
/* 263 */         maxWhile = (byte)(maxWhile + 1);
/*     */       } 
/* 265 */       this.modeTimer = Instant.now();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void spawnKey() {
/* 271 */     if ((float)this.spawnTimer / 1000.0F >= JGConfigMiniGameAirBoxing.KeySpawnSpeed[this.currentMode]) {
/*     */       
/* 273 */       this.spawnTimer = 0L;
/* 274 */       int id = (int)(Math.random() * (JGConfigMiniGameAirBoxing.KeyTypeIDs[this.currentMode]).length);
/* 275 */       int keyID = JGConfigMiniGameAirBoxing.KeyTypeIDs[this.currentMode][id];
/* 276 */       this.keys.add(new KeyData(this.currentMode, keyID, 0.0F));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float addDifference(float n, float n2) {
/* 283 */     if (n != n2) {
/* 284 */       boolean nSmaller = (n < n2);
/* 285 */       float diff = (nSmaller ? (n - n2) : (n2 - n)) / 10.0F;
/* 286 */       diff *= (float)Duration.between(this.lastUpdate, Instant.now()).toMillis() / 3.0F;
/* 287 */       boolean negativeDiff = (diff < 0.0F);
/*     */       
/* 289 */       if (negativeDiff) diff *= -1.0F; 
/* 290 */       if (diff < 0.05D) diff = 0.05F; 
/* 291 */       if (negativeDiff) diff *= -1.0F; 
/* 292 */       n += diff * (nSmaller ? -1 : true);
/*     */       
/* 294 */       if (nSmaller ? (n > n2) : (n < n2)) n = n2; 
/*     */     } 
/* 296 */     return n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void draw(int guiLeft, int guiTop) {
/* 305 */     int ey = guiTop;
/* 306 */     for (int i = 0; i < 4; i++) {
/* 307 */       int[] xPos = { 19, 0, 17, 34 };
/* 308 */       int[] yPos = { -22, 0, 0, 0 };
/* 309 */       int k = guiLeft + 70 + i + xPos[i]; ey = guiTop + 120 + yPos[i];
/* 310 */       drawKey(i, k, ey, (this.lastKeyPressed == i) ? -68 : 0, 0);
/*     */     } 
/*     */     
/* 313 */     GL11.glPushMatrix();
/* 314 */     GL11.glColor3f(this.r, this.g, this.b);
/* 315 */     int ex = guiLeft + 80 + 23; ey = guiTop + 2;
/* 316 */     getGUIInstance().func_73729_b(ex, ey, 23, 202, 122, 22);
/*     */ 
/*     */ 
/*     */     
/* 320 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 323 */     for (KeyData key : this.keys) {
/*     */       
/* 325 */       int id = key.id;
/* 326 */       float xProgress = key.xProgress;
/* 327 */       ex = (int)((guiLeft + 203) + xProgress); ey = guiTop + 1;
/*     */       
/* 329 */       float color = key.missed ? 0.5F : (key.catched ? 0.5F : 1.0F);
/* 330 */       float color2 = key.missed ? 1.0F : 0.5F;
/* 331 */       GL11.glPushMatrix();
/* 332 */       GL11.glColor3f(color2, color, color);
/* 333 */       drawKey(id, ex, ey, -68, 0);
/* 334 */       GL11.glPopMatrix();
/*     */     } 
/*     */ 
/*     */     
/* 338 */     ex = guiLeft + 80; ey = guiTop;
/* 339 */     GL11.glPushMatrix();
/* 340 */     GL11.glTranslatef(ex, ey, 0.0F);
/* 341 */     if (this.lastKeyResult != -1) {
/* 342 */       float timer = 0.0F;
/* 343 */       if (this.lastKeyResultTime == null) {
/* 344 */         this.lastKeyResultTime = Instant.now();
/*     */       } else {
/*     */         
/* 347 */         timer = (float)Duration.between(this.lastKeyResultTime, Instant.now()).toMillis() / 1000.0F;
/* 348 */         timer *= 5.0F;
/* 349 */         if (timer > 1.0F) timer = 1.0F;  if (timer < 0.0F) timer = 0.0F; 
/* 350 */         if (timer >= 2.0F) {
/* 351 */           this.lastKeyResult = -1;
/* 352 */           this.lastKeyResultTime = null;
/*     */         } 
/*     */       } 
/*     */       
/* 356 */       if (JGConfigClientSettings.airboxingAnimatedColorOn) {
/*     */         
/* 358 */         GL11.glColor4f(1.0F + ((this.lastKeyResult == 0) ? (-timer / 2.0F) : 0.0F), 1.0F + ((this.lastKeyResult == 0) ? 0.0F : (-timer / 2.0F)), 1.0F + ((this.lastKeyResult == 0) ? 0.0F : (-timer / 2.0F)), 1.0F);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 364 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       } 
/* 366 */       float scale = 1.0F + timer / 5.0F;
/*     */       
/* 368 */       GL11.glTranslatef((-scale * 23.0F + 23.0F) / 2.0F, (-scale * 26.0F + 26.0F) / 2.0F, 0.0F);
/* 369 */       GL11.glScalef(scale, scale, scale);
/*     */     } 
/* 371 */     getGUIInstance().func_73729_b(0, 0, 0, 200, 23, 26);
/*     */ 
/*     */ 
/*     */     
/* 375 */     GL11.glPopMatrix();
/*     */ 
/*     */ 
/*     */     
/* 379 */     int length = this.airboxingResults.size() - 1;
/* 380 */     for (int j = length; j >= 0; j--) {
/* 381 */       int result = ((Integer)this.airboxingResults.get(j)).intValue();
/* 382 */       boolean fail = (result == 1);
/* 383 */       String text = fail ? "Miss" : "Hit!";
/*     */       
/* 385 */       int timePassed = (int)(Duration.between(this.airboxingResultsTime.get(j), Instant.now()).toMillis() / 100L);
/*     */       
/* 387 */       getGUIInstance(); getGUIInstance(); JRMCoreGuiScreen.drawStringWithBorder(JRMCoreGuiScreen.mc.field_71466_p, text, guiLeft + 80, guiTop + 30 + timePassed, JRMCoreH.techNCCol[fail ? 0 : 4]);
/*     */ 
/*     */       
/* 390 */       if (timePassed > 30) {
/* 391 */         this.airboxingResults.remove(j);
/* 392 */         this.airboxingResultsTime.remove(j);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawKey(int id, int x, int y, int u, int v) {
/* 399 */     int[] uPos = { 0, 17, 34, 51 };
/* 400 */     getGUIInstance().func_73729_b(x, y, 174 + uPos[id] + u, 235 + v, 17, 21);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawKey(int id, int x, int y) {
/* 409 */     drawKey(id, x, y, 0, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void isKeyPressed() {
/* 414 */     int key = this.lastKeyPressed;
/* 415 */     this.lastKeyPressed = -1;
/* 416 */     if (GameSettings.func_100015_a(JRMCoreClient.mc.field_71474_y.field_74351_w)) {
/* 417 */       this.lastKeyPressed = 0;
/*     */     }
/* 419 */     else if (GameSettings.func_100015_a(JRMCoreClient.mc.field_71474_y.field_74370_x)) {
/* 420 */       this.lastKeyPressed = 1;
/*     */     }
/* 422 */     else if (GameSettings.func_100015_a(JRMCoreClient.mc.field_71474_y.field_74368_y)) {
/* 423 */       this.lastKeyPressed = 2;
/*     */     }
/* 425 */     else if (GameSettings.func_100015_a(JRMCoreClient.mc.field_71474_y.field_74366_z)) {
/* 426 */       this.lastKeyPressed = 3;
/*     */     } 
/* 428 */     this.wasKeyPressed = (this.lastKeyPressed != -1);
/* 429 */     if (this.lastKeyPressed != key) {
/* 430 */       this.wasKeyChecked = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playAnimation(int animationID) {
/* 439 */     this.gameModelAge = 0.0F;
/* 440 */     this.gameModelAnimationChanged = true;
/* 441 */     this.gameModelAnimationID = animationID;
/*     */     
/* 443 */     if (animationID > 0)
/* 444 */       if (animationID <= 4) {
/* 445 */         int id = (int)(Math.random() * 3.0D) + 1;
/* 446 */         JRMCoreClient.mc.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("jinryuudragonbc:DBC4.punch" + id), JRMCoreClient.mc.field_71439_g.field_70170_p.field_73012_v
/* 447 */               .nextFloat() * 0.4F + 0.8F));
/*     */       }
/* 449 */       else if (animationID == 5) {
/* 450 */         int id = (int)(Math.random() * 2.0D) + 1;
/* 451 */         JRMCoreClient.mc.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("jinryuudragonbc:DBC4.block" + id), JRMCoreClient.mc.field_71439_g.field_70170_p.field_73012_v
/* 452 */               .nextFloat() * 0.4F + 0.8F));
/*     */       }  
/*     */   }
/*     */   
/*     */   class KeyData {
/*     */     private int mode;
/*     */     private int id;
/*     */     private float xProgress;
/*     */     private boolean missed;
/*     */     private boolean catched;
/*     */     
/*     */     public KeyData(int mode, int id, float xProgress) {
/* 464 */       this.mode = mode;
/* 465 */       this.id = id;
/* 466 */       this.xProgress = xProgress;
/* 467 */       this.missed = false;
/* 468 */       this.catched = false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\minigame\MiniGameAirBoxing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */