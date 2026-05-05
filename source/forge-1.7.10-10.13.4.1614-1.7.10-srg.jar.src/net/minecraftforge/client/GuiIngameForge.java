/*     */ package net.minecraftforge.client;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiIngame;
/*     */ import net.minecraft.client.gui.GuiPlayerInfo;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.scoreboard.Score;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiIngameForge
/*     */   extends GuiIngame
/*     */ {
/*  53 */   private static final ResourceLocation WIDGITS = new ResourceLocation("textures/gui/widgets.png");
/*     */   
/*     */   private static final int WHITE = 16777215;
/*     */   
/*     */   public static boolean renderHelmet = true;
/*     */   
/*     */   public static boolean renderPortal = true;
/*     */   
/*     */   public static boolean renderHotbar = true;
/*     */   
/*     */   public static boolean renderCrosshairs = true;
/*     */   
/*     */   public static boolean renderBossHealth = true;
/*     */   
/*     */   public static boolean renderHealth = true;
/*     */   public static boolean renderArmor = true;
/*     */   public static boolean renderFood = true;
/*     */   public static boolean renderHealthMount = true;
/*     */   public static boolean renderAir = true;
/*     */   public static boolean renderExperiance = true;
/*     */   public static boolean renderJumpBar = true;
/*     */   public static boolean renderObjective = true;
/*  75 */   public static int left_height = 39;
/*  76 */   public static int right_height = 39;
/*     */   
/*  78 */   private ScaledResolution res = null;
/*  79 */   private FontRenderer fontrenderer = null;
/*     */   
/*     */   private RenderGameOverlayEvent eventParent;
/*     */   private static final String MC_VERSION = "1.7.10";
/*     */   
/*     */   public GuiIngameForge(Minecraft mc) {
/*  85 */     super(mc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderGameOverlay(float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
/*  94 */     this.res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
/*  95 */     this.eventParent = new RenderGameOverlayEvent(partialTicks, this.res, mouseX, mouseY);
/*  96 */     int width = this.res.getScaledWidth();
/*  97 */     int height = this.res.getScaledHeight();
/*  98 */     renderHealthMount = this.mc.thePlayer.ridingEntity instanceof EntityLivingBase;
/*  99 */     renderFood = (this.mc.thePlayer.ridingEntity == null);
/* 100 */     renderJumpBar = this.mc.thePlayer.isRidingHorse();
/*     */     
/* 102 */     right_height = 39;
/* 103 */     left_height = 39;
/*     */     
/* 105 */     if (pre(RenderGameOverlayEvent.ElementType.ALL))
/*     */       return; 
/* 107 */     this.fontrenderer = this.mc.fontRenderer;
/* 108 */     this.mc.entityRenderer.setupOverlayRendering();
/* 109 */     GL11.glEnable(3042);
/*     */     
/* 111 */     if (Minecraft.isFancyGraphicsEnabled()) {
/*     */       
/* 113 */       renderVignette(this.mc.thePlayer.getBrightness(partialTicks), width, height);
/*     */     }
/*     */     else {
/*     */       
/* 117 */       OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/*     */     } 
/*     */     
/* 120 */     if (renderHelmet) renderHelmet(this.res, partialTicks, hasScreen, mouseX, mouseY);
/*     */     
/* 122 */     if (renderPortal && !this.mc.thePlayer.isPotionActive(Potion.confusion))
/*     */     {
/* 124 */       renderPortal(width, height, partialTicks);
/*     */     }
/*     */     
/* 127 */     if (!this.mc.playerController.enableEverythingIsScrewedUpMode()) {
/*     */       
/* 129 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 130 */       this.zLevel = -90.0F;
/* 131 */       this.rand.setSeed((this.updateCounter * 312871));
/*     */       
/* 133 */       if (renderCrosshairs) renderCrosshairs(width, height); 
/* 134 */       if (renderBossHealth) renderBossHealth();
/*     */       
/* 136 */       if (this.mc.playerController.shouldDrawHUD()) {
/*     */         
/* 138 */         if (renderHealth) renderHealth(width, height); 
/* 139 */         if (renderArmor) renderArmor(width, height); 
/* 140 */         if (renderFood) renderFood(width, height); 
/* 141 */         if (renderHealthMount) renderHealthMount(width, height); 
/* 142 */         if (renderAir) renderAir(width, height); 
/*     */       } 
/* 144 */       if (renderHotbar) renderHotbar(width, height, partialTicks);
/*     */     
/*     */     } 
/* 147 */     if (renderJumpBar) {
/*     */       
/* 149 */       renderJumpBar(width, height);
/*     */     }
/* 151 */     else if (renderExperiance) {
/*     */       
/* 153 */       renderExperience(width, height);
/*     */     } 
/*     */     
/* 156 */     renderSleepFade(width, height);
/* 157 */     renderToolHightlight(width, height);
/* 158 */     renderHUDText(width, height);
/* 159 */     renderRecordOverlay(width, height, partialTicks);
/*     */     
/* 161 */     ScoreObjective objective = this.mc.theWorld.getScoreboard().func_96539_a(1);
/* 162 */     if (renderObjective && objective != null)
/*     */     {
/* 164 */       func_96136_a(objective, height, width, this.fontrenderer);
/*     */     }
/*     */     
/* 167 */     GL11.glEnable(3042);
/* 168 */     OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 169 */     GL11.glDisable(3008);
/*     */     
/* 171 */     renderChat(width, height);
/*     */     
/* 173 */     renderPlayerList(width, height);
/*     */     
/* 175 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 176 */     GL11.glDisable(2896);
/* 177 */     GL11.glEnable(3008);
/*     */     
/* 179 */     post(RenderGameOverlayEvent.ElementType.ALL);
/*     */   }
/*     */ 
/*     */   
/*     */   public ScaledResolution getResolution() {
/* 184 */     return this.res;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderHotbar(int width, int height, float partialTicks) {
/* 189 */     if (pre(RenderGameOverlayEvent.ElementType.HOTBAR))
/* 190 */       return;  this.mc.mcProfiler.startSection("actionBar");
/*     */     
/* 192 */     GL11.glEnable(3042);
/* 193 */     GL11.glBlendFunc(770, 771);
/* 194 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 195 */     this.mc.renderEngine.bindTexture(WIDGITS);
/*     */     
/* 197 */     InventoryPlayer inv = this.mc.thePlayer.inventory;
/* 198 */     drawTexturedModalRect(width / 2 - 91, height - 22, 0, 0, 182, 22);
/* 199 */     drawTexturedModalRect(width / 2 - 91 - 1 + inv.currentItem * 20, height - 22 - 1, 0, 22, 24, 22);
/*     */     
/* 201 */     GL11.glDisable(3042);
/* 202 */     GL11.glEnable(32826);
/* 203 */     RenderHelper.enableGUIStandardItemLighting();
/*     */     
/* 205 */     for (int i = 0; i < 9; i++) {
/*     */       
/* 207 */       int x = width / 2 - 90 + i * 20 + 2;
/* 208 */       int z = height - 16 - 3;
/* 209 */       renderInventorySlot(i, x, z, partialTicks);
/*     */     } 
/*     */     
/* 212 */     RenderHelper.disableStandardItemLighting();
/* 213 */     GL11.glDisable(32826);
/* 214 */     this.mc.mcProfiler.endSection();
/* 215 */     post(RenderGameOverlayEvent.ElementType.HOTBAR);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderCrosshairs(int width, int height) {
/* 220 */     if (pre(RenderGameOverlayEvent.ElementType.CROSSHAIRS))
/* 221 */       return;  bind(Gui.icons);
/* 222 */     GL11.glEnable(3042);
/* 223 */     OpenGlHelper.glBlendFunc(775, 769, 1, 0);
/* 224 */     drawTexturedModalRect(width / 2 - 7, height / 2 - 7, 0, 0, 16, 16);
/* 225 */     OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 226 */     GL11.glDisable(3042);
/* 227 */     post(RenderGameOverlayEvent.ElementType.CROSSHAIRS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderBossHealth() {
/* 236 */     if (pre(RenderGameOverlayEvent.ElementType.BOSSHEALTH))
/* 237 */       return;  this.mc.mcProfiler.startSection("bossHealth");
/* 238 */     GL11.glEnable(3042);
/* 239 */     super.renderBossHealth();
/* 240 */     GL11.glDisable(3042);
/* 241 */     this.mc.mcProfiler.endSection();
/* 242 */     post(RenderGameOverlayEvent.ElementType.BOSSHEALTH);
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderHelmet(ScaledResolution res, float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
/* 247 */     if (pre(RenderGameOverlayEvent.ElementType.HELMET))
/*     */       return; 
/* 249 */     ItemStack itemstack = this.mc.thePlayer.inventory.armorItemInSlot(3);
/*     */     
/* 251 */     if (this.mc.gameSettings.thirdPersonView == 0 && itemstack != null && itemstack.getItem() != null)
/*     */     {
/* 253 */       if (itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
/*     */         
/* 255 */         renderPumpkinBlur(res.getScaledWidth(), res.getScaledHeight());
/*     */       }
/*     */       else {
/*     */         
/* 259 */         itemstack.getItem().renderHelmetOverlay(itemstack, (EntityPlayer)this.mc.thePlayer, res, partialTicks, hasScreen, mouseX, mouseY);
/*     */       } 
/*     */     }
/*     */     
/* 263 */     post(RenderGameOverlayEvent.ElementType.HELMET);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderArmor(int width, int height) {
/* 268 */     if (pre(RenderGameOverlayEvent.ElementType.ARMOR))
/* 269 */       return;  this.mc.mcProfiler.startSection("armor");
/*     */     
/* 271 */     GL11.glEnable(3042);
/* 272 */     int left = width / 2 - 91;
/* 273 */     int top = height - left_height;
/*     */     
/* 275 */     int level = ForgeHooks.getTotalArmorValue((EntityPlayer)this.mc.thePlayer);
/* 276 */     for (int i = 1; level > 0 && i < 20; i += 2) {
/*     */       
/* 278 */       if (i < level) {
/*     */         
/* 280 */         drawTexturedModalRect(left, top, 34, 9, 9, 9);
/*     */       }
/* 282 */       else if (i == level) {
/*     */         
/* 284 */         drawTexturedModalRect(left, top, 25, 9, 9, 9);
/*     */       }
/* 286 */       else if (i > level) {
/*     */         
/* 288 */         drawTexturedModalRect(left, top, 16, 9, 9, 9);
/*     */       } 
/* 290 */       left += 8;
/*     */     } 
/* 292 */     left_height += 10;
/*     */     
/* 294 */     GL11.glDisable(3042);
/* 295 */     this.mc.mcProfiler.endSection();
/* 296 */     post(RenderGameOverlayEvent.ElementType.ARMOR);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderPortal(int width, int height, float partialTicks) {
/* 301 */     if (pre(RenderGameOverlayEvent.ElementType.PORTAL))
/*     */       return; 
/* 303 */     float f1 = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * partialTicks;
/*     */     
/* 305 */     if (f1 > 0.0F)
/*     */     {
/* 307 */       func_130015_b(f1, width, height);
/*     */     }
/*     */     
/* 310 */     post(RenderGameOverlayEvent.ElementType.PORTAL);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderAir(int width, int height) {
/* 315 */     if (pre(RenderGameOverlayEvent.ElementType.AIR))
/* 316 */       return;  this.mc.mcProfiler.startSection("air");
/* 317 */     GL11.glEnable(3042);
/* 318 */     int left = width / 2 + 91;
/* 319 */     int top = height - right_height;
/*     */     
/* 321 */     if (this.mc.thePlayer.isInsideOfMaterial(Material.water)) {
/*     */       
/* 323 */       int air = this.mc.thePlayer.getAir();
/* 324 */       int full = MathHelper.ceiling_double_int((air - 2) * 10.0D / 300.0D);
/* 325 */       int partial = MathHelper.ceiling_double_int(air * 10.0D / 300.0D) - full;
/*     */       
/* 327 */       for (int i = 0; i < full + partial; i++)
/*     */       {
/* 329 */         drawTexturedModalRect(left - i * 8 - 9, top, (i < full) ? 16 : 25, 18, 9, 9);
/*     */       }
/* 331 */       right_height += 10;
/*     */     } 
/*     */     
/* 334 */     GL11.glDisable(3042);
/* 335 */     this.mc.mcProfiler.endSection();
/* 336 */     post(RenderGameOverlayEvent.ElementType.AIR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderHealth(int width, int height) {
/* 341 */     bind(icons);
/* 342 */     if (pre(RenderGameOverlayEvent.ElementType.HEALTH))
/* 343 */       return;  this.mc.mcProfiler.startSection("health");
/* 344 */     GL11.glEnable(3042);
/*     */     
/* 346 */     boolean highlight = (this.mc.thePlayer.hurtResistantTime / 3 % 2 == 1);
/*     */     
/* 348 */     if (this.mc.thePlayer.hurtResistantTime < 10)
/*     */     {
/* 350 */       highlight = false;
/*     */     }
/*     */     
/* 353 */     IAttributeInstance attrMaxHealth = this.mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth);
/* 354 */     int health = MathHelper.ceiling_float_int(this.mc.thePlayer.getHealth());
/* 355 */     int healthLast = MathHelper.ceiling_float_int(this.mc.thePlayer.prevHealth);
/* 356 */     float healthMax = (float)attrMaxHealth.getAttributeValue();
/* 357 */     float absorb = this.mc.thePlayer.getAbsorptionAmount();
/*     */     
/* 359 */     int healthRows = MathHelper.ceiling_float_int((healthMax + absorb) / 2.0F / 10.0F);
/* 360 */     int rowHeight = Math.max(10 - healthRows - 2, 3);
/*     */     
/* 362 */     this.rand.setSeed((this.updateCounter * 312871));
/*     */     
/* 364 */     int left = width / 2 - 91;
/* 365 */     int top = height - left_height;
/* 366 */     left_height += healthRows * rowHeight;
/* 367 */     if (rowHeight != 10) left_height += 10 - rowHeight;
/*     */     
/* 369 */     int regen = -1;
/* 370 */     if (this.mc.thePlayer.isPotionActive(Potion.regeneration))
/*     */     {
/* 372 */       regen = this.updateCounter % 25;
/*     */     }
/*     */     
/* 375 */     int TOP = 9 * (this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled() ? 5 : 0);
/* 376 */     int BACKGROUND = highlight ? 25 : 16;
/* 377 */     int MARGIN = 16;
/* 378 */     if (this.mc.thePlayer.isPotionActive(Potion.poison)) { MARGIN += 36; }
/* 379 */     else if (this.mc.thePlayer.isPotionActive(Potion.wither)) { MARGIN += 72; }
/* 380 */      float absorbRemaining = absorb;
/*     */     
/* 382 */     for (int i = MathHelper.ceiling_float_int((healthMax + absorb) / 2.0F) - 1; i >= 0; i--) {
/*     */ 
/*     */       
/* 385 */       int row = MathHelper.ceiling_float_int((i + 1) / 10.0F) - 1;
/* 386 */       int x = left + i % 10 * 8;
/* 387 */       int y = top - row * rowHeight;
/*     */       
/* 389 */       if (health <= 4) y += this.rand.nextInt(2); 
/* 390 */       if (i == regen) y -= 2;
/*     */       
/* 392 */       drawTexturedModalRect(x, y, BACKGROUND, TOP, 9, 9);
/*     */       
/* 394 */       if (highlight)
/*     */       {
/* 396 */         if (i * 2 + 1 < healthLast) {
/* 397 */           drawTexturedModalRect(x, y, MARGIN + 54, TOP, 9, 9);
/* 398 */         } else if (i * 2 + 1 == healthLast) {
/* 399 */           drawTexturedModalRect(x, y, MARGIN + 63, TOP, 9, 9);
/*     */         } 
/*     */       }
/* 402 */       if (absorbRemaining > 0.0F) {
/*     */         
/* 404 */         if (absorbRemaining == absorb && absorb % 2.0F == 1.0F) {
/* 405 */           drawTexturedModalRect(x, y, MARGIN + 153, TOP, 9, 9);
/*     */         } else {
/* 407 */           drawTexturedModalRect(x, y, MARGIN + 144, TOP, 9, 9);
/* 408 */         }  absorbRemaining -= 2.0F;
/*     */ 
/*     */       
/*     */       }
/* 412 */       else if (i * 2 + 1 < health) {
/* 413 */         drawTexturedModalRect(x, y, MARGIN + 36, TOP, 9, 9);
/* 414 */       } else if (i * 2 + 1 == health) {
/* 415 */         drawTexturedModalRect(x, y, MARGIN + 45, TOP, 9, 9);
/*     */       } 
/*     */     } 
/*     */     
/* 419 */     GL11.glDisable(3042);
/* 420 */     this.mc.mcProfiler.endSection();
/* 421 */     post(RenderGameOverlayEvent.ElementType.HEALTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderFood(int width, int height) {
/* 426 */     if (pre(RenderGameOverlayEvent.ElementType.FOOD))
/* 427 */       return;  this.mc.mcProfiler.startSection("food");
/*     */     
/* 429 */     GL11.glEnable(3042);
/* 430 */     int left = width / 2 + 91;
/* 431 */     int top = height - right_height;
/* 432 */     right_height += 10;
/* 433 */     boolean unused = false;
/*     */     
/* 435 */     FoodStats stats = this.mc.thePlayer.getFoodStats();
/* 436 */     int level = stats.getFoodLevel();
/* 437 */     int levelLast = stats.getPrevFoodLevel();
/*     */     
/* 439 */     for (int i = 0; i < 10; i++) {
/*     */       
/* 441 */       int idx = i * 2 + 1;
/* 442 */       int x = left - i * 8 - 9;
/* 443 */       int y = top;
/* 444 */       int icon = 16;
/* 445 */       byte backgound = 0;
/*     */       
/* 447 */       if (this.mc.thePlayer.isPotionActive(Potion.hunger)) {
/*     */         
/* 449 */         icon += 36;
/* 450 */         backgound = 13;
/*     */       } 
/* 452 */       if (unused) backgound = 1;
/*     */       
/* 454 */       if (this.mc.thePlayer.getFoodStats().getSaturationLevel() <= 0.0F && this.updateCounter % (level * 3 + 1) == 0)
/*     */       {
/* 456 */         y = top + this.rand.nextInt(3) - 1;
/*     */       }
/*     */       
/* 459 */       drawTexturedModalRect(x, y, 16 + backgound * 9, 27, 9, 9);
/*     */       
/* 461 */       if (unused)
/*     */       {
/* 463 */         if (idx < levelLast) {
/* 464 */           drawTexturedModalRect(x, y, icon + 54, 27, 9, 9);
/* 465 */         } else if (idx == levelLast) {
/* 466 */           drawTexturedModalRect(x, y, icon + 63, 27, 9, 9);
/*     */         } 
/*     */       }
/* 469 */       if (idx < level) {
/* 470 */         drawTexturedModalRect(x, y, icon + 36, 27, 9, 9);
/* 471 */       } else if (idx == level) {
/* 472 */         drawTexturedModalRect(x, y, icon + 45, 27, 9, 9);
/*     */       } 
/* 474 */     }  GL11.glDisable(3042);
/* 475 */     this.mc.mcProfiler.endSection();
/* 476 */     post(RenderGameOverlayEvent.ElementType.FOOD);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderSleepFade(int width, int height) {
/* 481 */     if (this.mc.thePlayer.getSleepTimer() > 0) {
/*     */       
/* 483 */       this.mc.mcProfiler.startSection("sleep");
/* 484 */       GL11.glDisable(2929);
/* 485 */       GL11.glDisable(3008);
/* 486 */       int sleepTime = this.mc.thePlayer.getSleepTimer();
/* 487 */       float opacity = sleepTime / 100.0F;
/*     */       
/* 489 */       if (opacity > 1.0F)
/*     */       {
/* 491 */         opacity = 1.0F - (sleepTime - 100) / 10.0F;
/*     */       }
/*     */       
/* 494 */       int color = (int)(220.0F * opacity) << 24 | 0x101020;
/* 495 */       drawRect(0, 0, width, height, color);
/* 496 */       GL11.glEnable(3008);
/* 497 */       GL11.glEnable(2929);
/* 498 */       this.mc.mcProfiler.endSection();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderExperience(int width, int height) {
/* 504 */     bind(icons);
/* 505 */     if (pre(RenderGameOverlayEvent.ElementType.EXPERIENCE))
/* 506 */       return;  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 507 */     GL11.glDisable(3042);
/*     */     
/* 509 */     if (this.mc.playerController.gameIsSurvivalOrAdventure()) {
/*     */       
/* 511 */       this.mc.mcProfiler.startSection("expBar");
/* 512 */       int cap = this.mc.thePlayer.xpBarCap();
/* 513 */       int left = width / 2 - 91;
/*     */       
/* 515 */       if (cap > 0) {
/*     */         
/* 517 */         short barWidth = 182;
/* 518 */         int filled = (int)(this.mc.thePlayer.experience * (barWidth + 1));
/* 519 */         int top = height - 32 + 3;
/* 520 */         drawTexturedModalRect(left, top, 0, 64, barWidth, 5);
/*     */         
/* 522 */         if (filled > 0)
/*     */         {
/* 524 */           drawTexturedModalRect(left, top, 0, 69, filled, 5);
/*     */         }
/*     */       } 
/*     */       
/* 528 */       this.mc.mcProfiler.endSection();
/*     */ 
/*     */       
/* 531 */       if (this.mc.playerController.gameIsSurvivalOrAdventure() && this.mc.thePlayer.experienceLevel > 0) {
/*     */         
/* 533 */         this.mc.mcProfiler.startSection("expLevel");
/* 534 */         boolean flag1 = false;
/* 535 */         int color = flag1 ? 16777215 : 8453920;
/* 536 */         String text = "" + this.mc.thePlayer.experienceLevel;
/* 537 */         int x = (width - this.fontrenderer.getStringWidth(text)) / 2;
/* 538 */         int y = height - 31 - 4;
/* 539 */         this.fontrenderer.drawString(text, x + 1, y, 0);
/* 540 */         this.fontrenderer.drawString(text, x - 1, y, 0);
/* 541 */         this.fontrenderer.drawString(text, x, y + 1, 0);
/* 542 */         this.fontrenderer.drawString(text, x, y - 1, 0);
/* 543 */         this.fontrenderer.drawString(text, x, y, color);
/* 544 */         this.mc.mcProfiler.endSection();
/*     */       } 
/*     */     } 
/* 547 */     GL11.glEnable(3042);
/* 548 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 550 */     post(RenderGameOverlayEvent.ElementType.EXPERIENCE);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderJumpBar(int width, int height) {
/* 555 */     bind(icons);
/* 556 */     if (pre(RenderGameOverlayEvent.ElementType.JUMPBAR))
/* 557 */       return;  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 558 */     GL11.glDisable(3042);
/*     */     
/* 560 */     this.mc.mcProfiler.startSection("jumpBar");
/* 561 */     float charge = this.mc.thePlayer.getHorseJumpPower();
/* 562 */     int barWidth = 182;
/* 563 */     int x = width / 2 - 91;
/* 564 */     int filled = (int)(charge * 183.0F);
/* 565 */     int top = height - 32 + 3;
/*     */     
/* 567 */     drawTexturedModalRect(x, top, 0, 84, 182, 5);
/*     */     
/* 569 */     if (filled > 0)
/*     */     {
/* 571 */       drawTexturedModalRect(x, top, 0, 89, filled, 5);
/*     */     }
/*     */     
/* 574 */     GL11.glEnable(3042);
/* 575 */     this.mc.mcProfiler.endSection();
/* 576 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 578 */     post(RenderGameOverlayEvent.ElementType.JUMPBAR);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderToolHightlight(int width, int height) {
/* 583 */     if (this.mc.gameSettings.heldItemTooltips) {
/*     */       
/* 585 */       this.mc.mcProfiler.startSection("toolHighlight");
/*     */       
/* 587 */       if (this.remainingHighlightTicks > 0 && this.highlightingItemStack != null) {
/*     */         
/* 589 */         String name = this.highlightingItemStack.getDisplayName();
/*     */         
/* 591 */         int opacity = (int)(this.remainingHighlightTicks * 256.0F / 10.0F);
/* 592 */         if (opacity > 255) opacity = 255;
/*     */         
/* 594 */         if (opacity > 0) {
/*     */           
/* 596 */           int y = height - 59;
/* 597 */           if (!this.mc.playerController.shouldDrawHUD()) y += 14;
/*     */           
/* 599 */           GL11.glPushMatrix();
/* 600 */           GL11.glEnable(3042);
/* 601 */           OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 602 */           FontRenderer font = this.highlightingItemStack.getItem().getFontRenderer(this.highlightingItemStack);
/* 603 */           if (font != null) {
/*     */             
/* 605 */             int x = (width - font.getStringWidth(name)) / 2;
/* 606 */             font.drawStringWithShadow(name, x, y, 0xFFFFFF | opacity << 24);
/*     */           }
/*     */           else {
/*     */             
/* 610 */             int x = (width - this.fontrenderer.getStringWidth(name)) / 2;
/* 611 */             this.fontrenderer.drawStringWithShadow(name, x, y, 0xFFFFFF | opacity << 24);
/*     */           } 
/* 613 */           GL11.glDisable(3042);
/* 614 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/*     */       
/* 618 */       this.mc.mcProfiler.endSection();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderHUDText(int width, int height) {
/* 624 */     this.mc.mcProfiler.startSection("forgeHudText");
/* 625 */     OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 626 */     ArrayList<String> left = new ArrayList<String>();
/* 627 */     ArrayList<String> right = new ArrayList<String>();
/*     */     
/* 629 */     if (this.mc.isDemo()) {
/*     */       
/* 631 */       long time = this.mc.theWorld.getTotalWorldTime();
/* 632 */       if (time >= 120500L) {
/*     */         
/* 634 */         right.add(I18n.format("demo.demoExpired", new Object[0]));
/*     */       }
/*     */       else {
/*     */         
/* 638 */         right.add(I18n.format("demo.remainingTime", new Object[] { StringUtils.ticksToElapsedTime((int)(120500L - time)) }));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 643 */     if (this.mc.gameSettings.showDebugInfo && !pre(RenderGameOverlayEvent.ElementType.DEBUG)) {
/*     */       
/* 645 */       this.mc.mcProfiler.startSection("debug");
/* 646 */       GL11.glPushMatrix();
/* 647 */       left.add("Minecraft 1.7.10 (" + this.mc.debug + ")");
/* 648 */       left.add(this.mc.debugInfoRenders());
/* 649 */       left.add(this.mc.getEntityDebug());
/* 650 */       left.add(this.mc.debugInfoEntities());
/* 651 */       left.add(this.mc.getWorldProviderName());
/* 652 */       left.add(null);
/*     */       
/* 654 */       long max = Runtime.getRuntime().maxMemory();
/* 655 */       long total = Runtime.getRuntime().totalMemory();
/* 656 */       long free = Runtime.getRuntime().freeMemory();
/* 657 */       long used = total - free;
/*     */       
/* 659 */       right.add("Used memory: " + (used * 100L / max) + "% (" + (used / 1024L / 1024L) + "MB) of " + (max / 1024L / 1024L) + "MB");
/* 660 */       right.add("Allocated memory: " + (total * 100L / max) + "% (" + (total / 1024L / 1024L) + "MB)");
/*     */       
/* 662 */       int x = MathHelper.floor_double(this.mc.thePlayer.posX);
/* 663 */       int y = MathHelper.floor_double(this.mc.thePlayer.posY);
/* 664 */       int z = MathHelper.floor_double(this.mc.thePlayer.posZ);
/* 665 */       float yaw = this.mc.thePlayer.rotationYaw;
/* 666 */       int heading = MathHelper.floor_double((this.mc.thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
/*     */       
/* 668 */       left.add(String.format("x: %.5f (%d) // c: %d (%d)", new Object[] { Double.valueOf(this.mc.thePlayer.posX), Integer.valueOf(x), Integer.valueOf(x >> 4), Integer.valueOf(x & 0xF) }));
/* 669 */       left.add(String.format("y: %.3f (feet pos, %.3f eyes pos)", new Object[] { Double.valueOf(this.mc.thePlayer.boundingBox.minY), Double.valueOf(this.mc.thePlayer.posY) }));
/* 670 */       left.add(String.format("z: %.5f (%d) // c: %d (%d)", new Object[] { Double.valueOf(this.mc.thePlayer.posZ), Integer.valueOf(z), Integer.valueOf(z >> 4), Integer.valueOf(z & 0xF) }));
/* 671 */       left.add(String.format("f: %d (%s) / %f", new Object[] { Integer.valueOf(heading), Direction.directions[heading], Float.valueOf(MathHelper.wrapAngleTo180_float(yaw)) }));
/*     */       
/* 673 */       if (this.mc.theWorld != null && this.mc.theWorld.blockExists(x, y, z)) {
/*     */         
/* 675 */         Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(x, z);
/* 676 */         left.add(String.format("lc: %d b: %s bl: %d sl: %d rl: %d", new Object[] {
/* 677 */                 Integer.valueOf(chunk.getTopFilledSegment() + 15), 
/* 678 */                 (chunk.getBiomeGenForWorldCoords(x & 0xF, z & 0xF, this.mc.theWorld.getWorldChunkManager())).biomeName, 
/* 679 */                 Integer.valueOf(chunk.getSavedLightValue(EnumSkyBlock.Block, x & 0xF, y, z & 0xF)), 
/* 680 */                 Integer.valueOf(chunk.getSavedLightValue(EnumSkyBlock.Sky, x & 0xF, y, z & 0xF)), 
/* 681 */                 Integer.valueOf(chunk.getBlockLightValue(x & 0xF, y, z & 0xF, 0))
/*     */               }));
/*     */       } else {
/*     */         
/* 685 */         left.add(null);
/*     */       } 
/*     */       
/* 688 */       left.add(String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", new Object[] { Float.valueOf(this.mc.thePlayer.capabilities.getWalkSpeed()), Float.valueOf(this.mc.thePlayer.capabilities.getFlySpeed()), Boolean.valueOf(this.mc.thePlayer.onGround), Integer.valueOf(this.mc.theWorld.getHeightValue(x, z)) }));
/* 689 */       if (this.mc.entityRenderer != null && this.mc.entityRenderer.isShaderActive())
/*     */       {
/* 691 */         left.add(String.format("shader: %s", new Object[] { this.mc.entityRenderer.getShaderGroup().getShaderGroupName() }));
/*     */       }
/*     */       
/* 694 */       right.add(null);
/* 695 */       for (String brand : FMLCommonHandler.instance().getBrandings(false))
/*     */       {
/* 697 */         right.add(brand);
/*     */       }
/* 699 */       GL11.glPopMatrix();
/* 700 */       this.mc.mcProfiler.endSection();
/* 701 */       post(RenderGameOverlayEvent.ElementType.DEBUG);
/*     */     } 
/*     */     
/* 704 */     RenderGameOverlayEvent.Text event = new RenderGameOverlayEvent.Text(this.eventParent, left, right);
/* 705 */     if (!MinecraftForge.EVENT_BUS.post((Event)event)) {
/*     */       int x;
/* 707 */       for (x = 0; x < left.size(); x++) {
/*     */         
/* 709 */         String msg = left.get(x);
/* 710 */         if (msg != null) {
/* 711 */           this.fontrenderer.drawStringWithShadow(msg, 2, 2 + x * 10, 16777215);
/*     */         }
/*     */       } 
/* 714 */       for (x = 0; x < right.size(); x++) {
/*     */         
/* 716 */         String msg = right.get(x);
/* 717 */         if (msg != null) {
/* 718 */           int w = this.fontrenderer.getStringWidth(msg);
/* 719 */           this.fontrenderer.drawStringWithShadow(msg, width - w - 10, 2 + x * 10, 16777215);
/*     */         } 
/*     */       } 
/*     */     } 
/* 723 */     this.mc.mcProfiler.endSection();
/* 724 */     post(RenderGameOverlayEvent.ElementType.TEXT);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderRecordOverlay(int width, int height, float partialTicks) {
/* 729 */     if (this.recordPlayingUpFor > 0) {
/*     */       
/* 731 */       this.mc.mcProfiler.startSection("overlayMessage");
/* 732 */       float hue = this.recordPlayingUpFor - partialTicks;
/* 733 */       int opacity = (int)(hue * 256.0F / 20.0F);
/* 734 */       if (opacity > 255) opacity = 255;
/*     */       
/* 736 */       if (opacity > 0) {
/*     */         
/* 738 */         GL11.glPushMatrix();
/* 739 */         GL11.glTranslatef((width / 2), (height - 48), 0.0F);
/* 740 */         GL11.glEnable(3042);
/* 741 */         OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 742 */         int color = this.recordIsPlaying ? (Color.HSBtoRGB(hue / 50.0F, 0.7F, 0.6F) & 0xFFFFFF) : 16777215;
/* 743 */         this.fontrenderer.drawString(this.recordPlaying, -this.fontrenderer.getStringWidth(this.recordPlaying) / 2, -4, color | opacity << 24);
/* 744 */         GL11.glDisable(3042);
/* 745 */         GL11.glPopMatrix();
/*     */       } 
/*     */       
/* 748 */       this.mc.mcProfiler.endSection();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderChat(int width, int height) {
/* 754 */     this.mc.mcProfiler.startSection("chat");
/*     */     
/* 756 */     RenderGameOverlayEvent.Chat event = new RenderGameOverlayEvent.Chat(this.eventParent, 0, height - 48);
/* 757 */     if (MinecraftForge.EVENT_BUS.post((Event)event))
/*     */       return; 
/* 759 */     GL11.glPushMatrix();
/* 760 */     GL11.glTranslatef(event.posX, event.posY, 0.0F);
/* 761 */     this.persistantChatGUI.drawChat(this.updateCounter);
/* 762 */     GL11.glPopMatrix();
/*     */     
/* 764 */     post(RenderGameOverlayEvent.ElementType.CHAT);
/*     */     
/* 766 */     this.mc.mcProfiler.endSection();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderPlayerList(int width, int height) {
/* 772 */     ScoreObjective scoreobjective = this.mc.theWorld.getScoreboard().func_96539_a(0);
/* 773 */     NetHandlerPlayClient handler = this.mc.thePlayer.sendQueue;
/*     */     
/* 775 */     if (this.mc.gameSettings.keyBindPlayerList.getIsKeyPressed() && (!this.mc.isIntegratedServerRunning() || handler.playerInfoList.size() > 1 || scoreobjective != null)) {
/*     */       
/* 777 */       if (pre(RenderGameOverlayEvent.ElementType.PLAYER_LIST))
/* 778 */         return;  this.mc.mcProfiler.startSection("playerList");
/* 779 */       List<GuiPlayerInfo> players = handler.playerInfoList;
/* 780 */       int maxPlayers = handler.currentServerMaxPlayers;
/* 781 */       int rows = maxPlayers;
/* 782 */       int columns = 1;
/*     */       
/* 784 */       for (columns = 1; rows > 20; rows = (maxPlayers + columns - 1) / columns)
/*     */       {
/* 786 */         columns++;
/*     */       }
/*     */       
/* 789 */       int columnWidth = 300 / columns;
/*     */       
/* 791 */       if (columnWidth > 150)
/*     */       {
/* 793 */         columnWidth = 150;
/*     */       }
/*     */       
/* 796 */       int left = (width - columns * columnWidth) / 2;
/* 797 */       byte border = 10;
/* 798 */       drawRect(left - 1, border - 1, left + columnWidth * columns, border + 9 * rows, -2147483648);
/*     */       
/* 800 */       for (int i = 0; i < maxPlayers; i++) {
/*     */         
/* 802 */         int xPos = left + i % columns * columnWidth;
/* 803 */         int yPos = border + i / columns * 9;
/* 804 */         drawRect(xPos, yPos, xPos + columnWidth - 1, yPos + 8, 553648127);
/* 805 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 806 */         GL11.glEnable(3008);
/*     */         
/* 808 */         if (i < players.size()) {
/*     */           
/* 810 */           GuiPlayerInfo player = players.get(i);
/* 811 */           ScorePlayerTeam team = this.mc.theWorld.getScoreboard().getPlayersTeam(player.name);
/* 812 */           String displayName = ScorePlayerTeam.formatPlayerName((Team)team, player.name);
/* 813 */           this.fontrenderer.drawStringWithShadow(displayName, xPos, yPos, 16777215);
/*     */           
/* 815 */           if (scoreobjective != null) {
/*     */             
/* 817 */             int endX = xPos + this.fontrenderer.getStringWidth(displayName) + 5;
/* 818 */             int maxX = xPos + columnWidth - 12 - 5;
/*     */             
/* 820 */             if (maxX - endX > 5) {
/*     */               
/* 822 */               Score score = scoreobjective.getScoreboard().func_96529_a(player.name, scoreobjective);
/* 823 */               String scoreDisplay = EnumChatFormatting.YELLOW + "" + score.getScorePoints();
/* 824 */               this.fontrenderer.drawStringWithShadow(scoreDisplay, maxX - this.fontrenderer.getStringWidth(scoreDisplay), yPos, 16777215);
/*     */             } 
/*     */           } 
/*     */           
/* 828 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */           
/* 830 */           this.mc.getTextureManager().bindTexture(Gui.icons);
/* 831 */           int pingIndex = 4;
/* 832 */           int ping = player.responseTime;
/* 833 */           if (ping < 0) { pingIndex = 5; }
/* 834 */           else if (ping < 150) { pingIndex = 0; }
/* 835 */           else if (ping < 300) { pingIndex = 1; }
/* 836 */           else if (ping < 600) { pingIndex = 2; }
/* 837 */           else if (ping < 1000) { pingIndex = 3; }
/*     */           
/* 839 */           this.zLevel += 100.0F;
/* 840 */           drawTexturedModalRect(xPos + columnWidth - 12, yPos, 0, 176 + pingIndex * 8, 10, 8);
/* 841 */           this.zLevel -= 100.0F;
/*     */         } 
/*     */       } 
/* 844 */       post(RenderGameOverlayEvent.ElementType.PLAYER_LIST);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderHealthMount(int width, int height) {
/* 850 */     Entity tmp = this.mc.thePlayer.ridingEntity;
/* 851 */     if (!(tmp instanceof EntityLivingBase))
/*     */       return; 
/* 853 */     bind(icons);
/*     */     
/* 855 */     if (pre(RenderGameOverlayEvent.ElementType.HEALTHMOUNT))
/*     */       return; 
/* 857 */     boolean unused = false;
/* 858 */     int left_align = width / 2 + 91;
/*     */     
/* 860 */     this.mc.mcProfiler.endStartSection("mountHealth");
/* 861 */     GL11.glEnable(3042);
/* 862 */     EntityLivingBase mount = (EntityLivingBase)tmp;
/* 863 */     int health = (int)Math.ceil(mount.getHealth());
/* 864 */     float healthMax = mount.getMaxHealth();
/* 865 */     int hearts = (int)(healthMax + 0.5F) / 2;
/*     */     
/* 867 */     if (hearts > 30) hearts = 30;
/*     */     
/* 869 */     int MARGIN = 52;
/* 870 */     int BACKGROUND = 52 + (unused ? 1 : 0);
/* 871 */     int HALF = 97;
/* 872 */     int FULL = 88;
/*     */     
/* 874 */     for (int heart = 0; hearts > 0; heart += 20) {
/*     */       
/* 876 */       int top = height - right_height;
/*     */       
/* 878 */       int rowCount = Math.min(hearts, 10);
/* 879 */       hearts -= rowCount;
/*     */       
/* 881 */       for (int i = 0; i < rowCount; i++) {
/*     */         
/* 883 */         int x = left_align - i * 8 - 9;
/* 884 */         drawTexturedModalRect(x, top, BACKGROUND, 9, 9, 9);
/*     */         
/* 886 */         if (i * 2 + 1 + heart < health) {
/* 887 */           drawTexturedModalRect(x, top, 88, 9, 9, 9);
/* 888 */         } else if (i * 2 + 1 + heart == health) {
/* 889 */           drawTexturedModalRect(x, top, 97, 9, 9, 9);
/*     */         } 
/*     */       } 
/* 892 */       right_height += 10;
/*     */     } 
/* 894 */     GL11.glDisable(3042);
/* 895 */     post(RenderGameOverlayEvent.ElementType.HEALTHMOUNT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean pre(RenderGameOverlayEvent.ElementType type) {
/* 901 */     return MinecraftForge.EVENT_BUS.post((Event)new RenderGameOverlayEvent.Pre(this.eventParent, type));
/*     */   }
/*     */   
/*     */   private void post(RenderGameOverlayEvent.ElementType type) {
/* 905 */     MinecraftForge.EVENT_BUS.post((Event)new RenderGameOverlayEvent.Post(this.eventParent, type));
/*     */   }
/*     */   
/*     */   private void bind(ResourceLocation res) {
/* 909 */     this.mc.getTextureManager().bindTexture(res);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\GuiIngameForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */