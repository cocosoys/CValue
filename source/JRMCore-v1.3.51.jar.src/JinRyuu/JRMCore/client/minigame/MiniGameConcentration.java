/*     */ package JinRyuu.JRMCore.client.minigame;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiButtonsMG0;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.PositionedSoundRecord;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MiniGameConcentration
/*     */   extends MiniGame
/*     */ {
/*     */   public static final int XYPOS = 0;
/*     */   public static final int TYPE = 1;
/*     */   public static final int VALUE = 2;
/*     */   public static final int REMOVED_TIMER = 3;
/*     */   public static final int IS_REMOVED = 4;
/*     */   public static final int ENTITY_BAD = 0;
/*     */   public static final int ENTITY_GOOD = 1;
/*     */   public static final int ENTITY_VIRUS = 2;
/*  33 */   public HashMap<Integer, Object[]> energyBalls = (HashMap)new HashMap<Integer, Object>();
/*  34 */   public ArrayList<Integer> removeList = new ArrayList<Integer>();
/*  35 */   public int comboCounter = 0;
/*  36 */   public String temporaryMessage = "";
/*  37 */   public int tempMessageVisibility = 0;
/*     */   
/*  39 */   private Instant colorAnimation = Instant.now();
/*  40 */   private Instant textureAnimation = Instant.now();
/*  41 */   private Instant movementTimer = Instant.now();
/*  42 */   private float animationTimer = 0.0F;
/*  43 */   private int animationID = 0;
/*     */   
/*     */   private Instant comboTimer;
/*     */   
/*     */   private Instant TPusedLimitCheckTimer;
/*     */   private boolean update = false;
/*     */   
/*     */   public void gameReset() {
/*  51 */     this.lvl = 0;
/*  52 */     this.score = 0;
/*  53 */     this.lives = 3;
/*  54 */     this.energyBalls.clear();
/*  55 */     this.state = 1;
/*  56 */     this.comboTimer = null;
/*  57 */     this.TPusedLimitCheckTimer = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateStart() {
/*  62 */     generateEntities(0);
/*  63 */     this.state = 2;
/*     */   }
/*     */   
/*     */   public void generateNextLevel() {
/*  67 */     this.energyBalls.clear();
/*  68 */     generateEntities(this.lvl);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void chooseReward() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void stateManager(int guiLeft, int guiTop) {
/*  78 */     if (this.comboTimer != null) {
/*  79 */       long timeElapsedCombo = Duration.between(this.comboTimer, Instant.now()).toMillis() / 1000L;
/*  80 */       if ((float)timeElapsedCombo >= JGConfigMiniGameConcentration.ComboTimer) {
/*     */         
/*  82 */         if (this.tempMessageVisibility > 0) this.tempMessageVisibility--; 
/*  83 */         this.comboTimer = null;
/*     */       } 
/*     */     } 
/*     */     
/*  87 */     if (this.tempMessageVisibility <= 0 && this.temporaryMessage.length() > 0) this.temporaryMessage = "";
/*     */     
/*  89 */     if (this.state != 0 && (this.TPusedLimitCheckTimer == null || Duration.between(this.TPusedLimitCheckTimer, Instant.now()).toMillis() / 1000L >= 10L)) {
/*     */       
/*  91 */       this.TPusedLimitCheckTimer = Instant.now();
/*  92 */       JRMCoreH.quad(10, 1, -1, 0);
/*     */     } 
/*     */     
/*  95 */     if (JGConfigMiniGameConcentration.RandomMovementSpeed > 0 && this.update) {
/*     */       
/*  97 */       Random r = new Random();
/*  98 */       for (Iterator<Integer> iterator = this.energyBalls.keySet().iterator(); iterator.hasNext(); ) {
/*  99 */         int id = ((Integer)iterator.next()).intValue();
/* 100 */         Object[] object = this.energyBalls.get(Integer.valueOf(id));
/* 101 */         int[] xypos = (int[])object[0];
/* 102 */         int timer = (int)(Duration.between(this.movementTimer, Instant.now()).toMillis() / 10L);
/* 103 */         int randomMovementValue = (int)(JGConfigMiniGameConcentration.RandomMovementSpeed * ((timer > 3) ? (timer / 3.0F) : 1.0F));
/* 104 */         int x = xypos[0] + r.nextInt(1 + randomMovementValue * 2) - randomMovementValue;
/* 105 */         if (x < 5) x = 5;  if (x > 144) x = 144; 
/* 106 */         int y = xypos[1] + r.nextInt(1 + randomMovementValue * 2) - randomMovementValue;
/* 107 */         if (y < 5) y = 5;  if (y > 144) y = 144; 
/* 108 */         this.energyBalls.put(Integer.valueOf(id), new Object[] { { x, y }, object[1], object[2], object[3], object[4] });
/*     */       } 
/*     */       
/* 111 */       this.update = false;
/*     */     } 
/*     */     
/* 114 */     super.stateManager(guiLeft, guiTop);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(int guiLeft, int guiTop) {
/* 119 */     if (this.tempMessageVisibility <= 0) {
/* 120 */       this.comboCounter = 0;
/* 121 */       this.comboTimer = null;
/*     */     } 
/*     */     
/* 124 */     for (Iterator<Integer> iterator1 = this.energyBalls.keySet().iterator(); iterator1.hasNext(); ) {
/* 125 */       int key = ((Integer)iterator1.next()).intValue();
/* 126 */       Object[] object = this.energyBalls.get(Integer.valueOf(key));
/* 127 */       int[] xypos = (int[])object[0];
/* 128 */       entityUpdate(key, guiLeft + xypos[0] - 5, guiTop + xypos[1] - 5, ((Integer)object[1])
/* 129 */           .intValue(), ((Integer)object[2]).intValue(), (Instant)object[3], ((Boolean)object[4])
/* 130 */           .booleanValue());
/* 131 */       if (((Boolean)object[4]).booleanValue() && Duration.between((Instant)object[3], Instant.now()).toMillis() > 200L)
/*     */       {
/* 133 */         this.removeList.add(Integer.valueOf(key));
/*     */       }
/*     */     } 
/*     */     
/* 137 */     for (Iterator<Integer> iterator = this.removeList.iterator(); iterator.hasNext(); ) {
/* 138 */       int remove = ((Integer)iterator.next()).intValue();
/* 139 */       this.energyBalls.remove(Integer.valueOf(remove));
/*     */     } 
/* 141 */     this.removeList.clear();
/*     */     
/* 143 */     boolean levelup = true;
/* 144 */     for (Iterator<Integer> iterator2 = this.energyBalls.keySet().iterator(); iterator2.hasNext(); ) {
/* 145 */       int key = ((Integer)iterator2.next()).intValue();
/* 146 */       Object[] object = this.energyBalls.get(Integer.valueOf(key));
/* 147 */       if (((Integer)object[1]).intValue() == 1) {
/* 148 */         levelup = false;
/*     */       }
/*     */     } 
/* 151 */     if (levelup) {
/* 152 */       this.lvl++;
/* 153 */       generateNextLevel();
/*     */     } 
/*     */     
/* 156 */     if (this.lives <= 0 || this.score < 0) {
/* 157 */       this.state = 3;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateEntities(int lvl) {
/* 163 */     this.colorAnimation = Instant.now();
/* 164 */     this.textureAnimation = Instant.now();
/* 165 */     if (JGConfigMiniGameConcentration.RandomMovementSpeed > 0) this.movementTimer = Instant.now(); 
/* 166 */     this.animationTimer = 0.0F;
/* 167 */     this.animationID = 0;
/* 168 */     Random r = new Random();
/* 169 */     for (int i = 0; i < 10 + lvl; i++) {
/* 170 */       this.energyBalls.put(Integer.valueOf(r.nextInt(1000000)), new Object[] { { 5 + r
/* 171 */               .nextInt(140), 5 + r.nextInt(140)
/* 172 */             }, Integer.valueOf(r.nextInt(3)), 
/* 173 */             Integer.valueOf(r.nextInt(10)), null, 
/*     */             
/* 175 */             Boolean.valueOf(false) });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void entityUpdate(int id, int ex, int ey, int type, int value, Instant timer, boolean removed) {
/* 181 */     float cos = 1.0F;
/* 182 */     if (JGConfigClientSettings.concentrationAnimatedColorOn) {
/*     */       
/* 184 */       long timeElapsed = Duration.between(this.colorAnimation, Instant.now()).toMillis();
/* 185 */       cos = MathHelper.func_76134_b((float)timeElapsed * 0.001F) * 0.2F;
/* 186 */       if (cos < 0.0F) cos *= -1.0F; 
/* 187 */       cos += 0.8F;
/*     */     } 
/*     */     
/* 190 */     if (JGConfigClientSettings.concentrationAnimatedTexturesOn) {
/*     */       
/* 192 */       if (this.textureAnimation == null) {
/*     */         
/* 194 */         this.textureAnimation = Instant.now();
/*     */       }
/*     */       else {
/*     */         
/* 198 */         long timeElapsed2 = Duration.between(this.textureAnimation, Instant.now()).toMillis() / 10L;
/* 199 */         if (timeElapsed2 > 10L)
/*     */         {
/* 201 */           this.animationID++;
/* 202 */           this.textureAnimation = Instant.now();
/* 203 */           if (this.animationID > 5)
/*     */           {
/* 205 */             this.animationID = 0;
/*     */           }
/*     */         }
/*     */       
/*     */       } 
/* 210 */     } else if (this.textureAnimation != null) {
/*     */       
/* 212 */       this.textureAnimation = null;
/* 213 */       this.animationID = 0;
/*     */     } 
/*     */     
/* 216 */     if (JGConfigMiniGameConcentration.RandomMovementSpeed > 0) {
/*     */       
/* 218 */       long timeElapsed3 = Duration.between(this.movementTimer, Instant.now()).toMillis() / 10L;
/* 219 */       if (timeElapsed3 > 3L) {
/*     */         
/* 221 */         this.update = true;
/* 222 */         this.movementTimer = Instant.now();
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     if (JRMCoreGuiButtonsMG0.clicked && (getGUIInstance()).x - 10 < ex && (getGUIInstance()).x > ex && 
/* 227 */       (getGUIInstance()).y - 10 < ey && (getGUIInstance()).y > ey && !removed) {
/*     */ 
/*     */       
/* 230 */       switch (type) {
/*     */         case 0:
/* 232 */           this.score -= value * (this.comboCounter + 1) * (this.lvl + 1);
/*     */           break;
/*     */         case 1:
/* 235 */           this.comboCounter++;
/* 236 */           if (this.comboCounter > 0) {
/* 237 */             this.tempMessageVisibility = 1;
/* 238 */             this.comboTimer = Instant.now();
/* 239 */             if (this.comboCounter > 1)
/*     */             {
/* 241 */               this.temporaryMessage = this.comboCounter + "x combo";
/*     */             }
/*     */           } 
/* 244 */           this.score += value * this.comboCounter;
/*     */           break;
/*     */         case 2:
/* 247 */           this.score -= value * (this.comboCounter + 1) * (this.lvl + 1);
/* 248 */           this.lives--;
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 254 */       float rand = JRMCoreClient.mc.field_71439_g.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F;
/* 255 */       if (type != 1) {
/* 256 */         rand /= ((type == 0) ? 2 : ((type == 2) ? 3 : true));
/* 257 */         JRMCoreClient.mc.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("jinryuumodscore:MINIGAME.blast_bad"), rand));
/*     */       } 
/* 259 */       JRMCoreClient.mc.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("jinryuumodscore:MINIGAME.blast"), rand));
/*     */       
/* 261 */       Object[] object = this.energyBalls.get(Integer.valueOf(id));
/* 262 */       this.energyBalls.put(Integer.valueOf(id), new Object[] { object[0], object[1], object[2], Instant.now(), Boolean.valueOf(true) });
/*     */     } 
/*     */     
/* 265 */     float scale = 1.0F;
/* 266 */     if (removed) {
/*     */       
/* 268 */       float timerScale = (float)Duration.between(timer, Instant.now()).toMillis() / 200.0F;
/* 269 */       if (timerScale > 1.0F) timerScale = 1.0F;  if (timerScale < 0.0F) timerScale = 0.0F; 
/* 270 */       scale = 1.0F + timerScale;
/*     */     } 
/*     */     
/* 273 */     GL11.glPushMatrix();
/* 274 */     int x = ex - 2, y = ey - 2;
/* 275 */     GL11.glTranslatef(x, y, 0.0F);
/* 276 */     if (scale != 1.0F) GL11.glTranslatef((-scale * 14.0F + 14.0F) / 2.0F, (-scale * 14.0F + 14.0F) / 2.0F, 0.0F); 
/* 277 */     GL11.glScalef(scale, scale, scale);
/*     */     
/* 279 */     if (JGConfigClientSettings.concentrationAnimatedColorOn) { GL11.glColor4f(1.0F, 1.0F, 1.0F, cos * (1.0F - scale - 1.0F)); }
/* 280 */     else { GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F - scale - 1.0F); }
/* 281 */      getGUIInstance().func_73729_b(0, 0, 242, 214 + type * 14, 14, 14);
/* 282 */     GL11.glPopMatrix();
/*     */     
/* 284 */     GL11.glPushMatrix();
/* 285 */     GL11.glTranslatef((x + 2), (y + 2), 0.0F);
/* 286 */     if (scale != 1.0F) GL11.glTranslatef((-scale * 10.0F + 10.0F) / 2.0F, (-scale * 10.0F + 10.0F) / 2.0F, 0.0F); 
/* 287 */     GL11.glScalef(scale, scale, scale);
/* 288 */     if (JGConfigClientSettings.concentrationAnimatedColorOn) { GL11.glColor4f(cos, cos, cos, 1.0F - scale - 1.0F); }
/* 289 */     else { GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F - scale - 1.0F); }
/* 290 */      getGUIInstance().func_73729_b(0, 0, this.animationID * 10, 226 + type * 10, 10, 10);
/*     */     
/* 292 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\minigame\MiniGameConcentration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */