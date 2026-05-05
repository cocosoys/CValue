/*     */ package net.minecraft.client.gui;
/*     */ import java.awt.Color;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.boss.BossStatus;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.scoreboard.Score;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.scoreboard.Scoreboard;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiIngame extends Gui {
/*  38 */   protected static final ResourceLocation field_110329_b = new ResourceLocation("textures/misc/vignette.png");
/*  39 */   protected static final ResourceLocation field_110330_c = new ResourceLocation("textures/gui/widgets.png");
/*  40 */   protected static final ResourceLocation field_110328_d = new ResourceLocation("textures/misc/pumpkinblur.png");
/*     */   
/*  42 */   protected static final RenderItem field_73841_b = new RenderItem();
/*     */   
/*  44 */   protected final Random field_73842_c = new Random();
/*     */   
/*     */   protected final Minecraft field_73839_d;
/*     */   protected final GuiNewChat field_73840_e;
/*     */   protected final GuiStreamIndicator field_152127_m;
/*     */   protected int field_73837_f;
/*  50 */   protected String field_73838_g = "";
/*     */   
/*     */   protected int field_73845_h;
/*     */   protected boolean field_73844_j;
/*  54 */   public float field_73843_a = 1.0F; protected int field_92017_k;
/*     */   protected ItemStack field_92016_l;
/*     */   private static final String __OBFID = "CL_00000661";
/*     */   
/*     */   public GuiIngame(Minecraft p_i1036_1_) {
/*  59 */     this.field_73839_d = p_i1036_1_;
/*  60 */     this.field_73840_e = new GuiNewChat(p_i1036_1_);
/*  61 */     this.field_152127_m = new GuiStreamIndicator(this.field_73839_d);
/*     */   }
/*     */   
/*     */   public void func_73830_a(float p_73830_1_, boolean p_73830_2_, int p_73830_3_, int p_73830_4_) {
/*  65 */     ScaledResolution scaledResolution = new ScaledResolution(this.field_73839_d, this.field_73839_d.field_71443_c, this.field_73839_d.field_71440_d);
/*  66 */     int i = scaledResolution.func_78326_a();
/*  67 */     int j = scaledResolution.func_78328_b();
/*     */     
/*  69 */     FontRenderer fontRenderer = this.field_73839_d.field_71466_p;
/*  70 */     this.field_73839_d.field_71460_t.func_78478_c();
/*     */     
/*  72 */     GL11.glEnable(3042);
/*     */     
/*  74 */     if (Minecraft.func_71375_t()) {
/*  75 */       func_73829_a(this.field_73839_d.field_71439_g.func_70013_c(p_73830_1_), i, j);
/*     */     } else {
/*     */       
/*  78 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     } 
/*     */ 
/*     */     
/*  82 */     ItemStack itemStack = this.field_73839_d.field_71439_g.field_71071_by.func_70440_f(3);
/*  83 */     if (this.field_73839_d.field_71474_y.field_74320_O == 0 && itemStack != null && itemStack.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK)) func_73836_a(i, j);
/*     */     
/*  85 */     if (!this.field_73839_d.field_71439_g.func_70644_a(Potion.field_76431_k)) {
/*  86 */       float f = this.field_73839_d.field_71439_g.field_71080_cy + (this.field_73839_d.field_71439_g.field_71086_bY - this.field_73839_d.field_71439_g.field_71080_cy) * p_73830_1_;
/*  87 */       if (f > 0.0F) {
/*  88 */         func_130015_b(f, i, j);
/*     */       }
/*     */     } 
/*     */     
/*  92 */     if (!this.field_73839_d.field_71442_b.func_78747_a()) {
/*  93 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  94 */       this.field_73839_d.func_110434_K().func_110577_a(field_110330_c);
/*     */       
/*  96 */       InventoryPlayer inventoryPlayer = this.field_73839_d.field_71439_g.field_71071_by;
/*     */       
/*  98 */       this.field_73735_i = -90.0F;
/*  99 */       func_73729_b(i / 2 - 91, j - 22, 0, 0, 182, 22);
/* 100 */       func_73729_b(i / 2 - 91 - 1 + inventoryPlayer.field_70461_c * 20, j - 22 - 1, 0, 22, 24, 22);
/*     */       
/* 102 */       this.field_73839_d.func_110434_K().func_110577_a(field_110324_m);
/* 103 */       GL11.glEnable(3042);
/* 104 */       OpenGlHelper.func_148821_a(775, 769, 1, 0);
/* 105 */       func_73729_b(i / 2 - 7, j / 2 - 7, 0, 0, 16, 16);
/*     */       
/* 107 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 108 */       this.field_73839_d.field_71424_I.func_76320_a("bossHealth");
/* 109 */       func_73828_d();
/* 110 */       this.field_73839_d.field_71424_I.func_76319_b();
/*     */       
/* 112 */       if (this.field_73839_d.field_71442_b.func_78755_b()) {
/* 113 */         func_110327_a(i, j);
/*     */       }
/*     */       
/* 116 */       this.field_73839_d.field_71424_I.func_76320_a("actionBar");
/* 117 */       GL11.glEnable(32826);
/* 118 */       RenderHelper.func_74520_c();
/*     */       
/* 120 */       for (byte b = 0; b < 9; b++) {
/* 121 */         int n = i / 2 - 90 + b * 20 + 2;
/* 122 */         int i1 = j - 16 - 3;
/* 123 */         func_73832_a(b, n, i1, p_73830_1_);
/*     */       } 
/* 125 */       RenderHelper.func_74518_a();
/* 126 */       GL11.glDisable(32826);
/* 127 */       this.field_73839_d.field_71424_I.func_76319_b();
/*     */       
/* 129 */       GL11.glDisable(3042);
/*     */     } 
/*     */ 
/*     */     
/* 133 */     if (this.field_73839_d.field_71439_g.func_71060_bI() > 0) {
/* 134 */       this.field_73839_d.field_71424_I.func_76320_a("sleep");
/* 135 */       GL11.glDisable(2929);
/* 136 */       GL11.glDisable(3008);
/*     */       
/* 138 */       int n = this.field_73839_d.field_71439_g.func_71060_bI();
/* 139 */       float f = n / 100.0F;
/* 140 */       if (f > 1.0F)
/*     */       {
/* 142 */         f = 1.0F - (n - 100) / 10.0F;
/*     */       }
/*     */       
/* 145 */       int i1 = (int)(220.0F * f) << 24 | 0x101020;
/* 146 */       func_73734_a(0, 0, i, j, i1);
/* 147 */       GL11.glEnable(3008);
/* 148 */       GL11.glEnable(2929);
/* 149 */       this.field_73839_d.field_71424_I.func_76319_b();
/*     */     } 
/*     */     
/* 152 */     int k = 16777215;
/* 153 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 154 */     int m = i / 2 - 91;
/*     */     
/* 156 */     if (this.field_73839_d.field_71439_g.func_110317_t()) {
/*     */       
/* 158 */       this.field_73839_d.field_71424_I.func_76320_a("jumpBar");
/* 159 */       this.field_73839_d.func_110434_K().func_110577_a(Gui.field_110324_m);
/* 160 */       float f = this.field_73839_d.field_71439_g.func_110319_bJ();
/* 161 */       char c = '¶';
/*     */       
/* 163 */       int n = (int)(f * (c + 1));
/*     */       
/* 165 */       int i1 = j - 32 + 3;
/* 166 */       func_73729_b(m, i1, 0, 84, c, 5);
/* 167 */       if (n > 0) {
/* 168 */         func_73729_b(m, i1, 0, 89, n, 5);
/*     */       }
/* 170 */       this.field_73839_d.field_71424_I.func_76319_b();
/* 171 */     } else if (this.field_73839_d.field_71442_b.func_78763_f()) {
/*     */       
/* 173 */       this.field_73839_d.field_71424_I.func_76320_a("expBar");
/* 174 */       this.field_73839_d.func_110434_K().func_110577_a(Gui.field_110324_m);
/* 175 */       int n = this.field_73839_d.field_71439_g.func_71050_bK();
/* 176 */       if (n > 0) {
/* 177 */         char c = '¶';
/*     */         
/* 179 */         int i1 = (int)(this.field_73839_d.field_71439_g.field_71106_cc * (c + 1));
/*     */         
/* 181 */         int i2 = j - 32 + 3;
/* 182 */         func_73729_b(m, i2, 0, 64, c, 5);
/* 183 */         if (i1 > 0) {
/* 184 */           func_73729_b(m, i2, 0, 69, i1, 5);
/*     */         }
/*     */       } 
/* 187 */       this.field_73839_d.field_71424_I.func_76319_b();
/*     */       
/* 189 */       if (this.field_73839_d.field_71439_g.field_71068_ca > 0) {
/* 190 */         this.field_73839_d.field_71424_I.func_76320_a("expLevel");
/* 191 */         boolean bool1 = false;
/* 192 */         int i1 = bool1 ? 16777215 : 8453920;
/*     */         
/* 194 */         String str = "" + this.field_73839_d.field_71439_g.field_71068_ca;
/* 195 */         int i2 = (i - fontRenderer.func_78256_a(str)) / 2;
/* 196 */         int i3 = j - 31 - 4;
/*     */         
/* 198 */         boolean bool2 = false;
/* 199 */         fontRenderer.func_78276_b(str, i2 + 1, i3, 0);
/* 200 */         fontRenderer.func_78276_b(str, i2 - 1, i3, 0);
/* 201 */         fontRenderer.func_78276_b(str, i2, i3 + 1, 0);
/* 202 */         fontRenderer.func_78276_b(str, i2, i3 - 1, 0);
/* 203 */         fontRenderer.func_78276_b(str, i2, i3, i1);
/* 204 */         this.field_73839_d.field_71424_I.func_76319_b();
/*     */       } 
/*     */     } 
/*     */     
/* 208 */     if (this.field_73839_d.field_71474_y.field_92117_D) {
/* 209 */       this.field_73839_d.field_71424_I.func_76320_a("toolHighlight");
/*     */       
/* 211 */       if (this.field_92017_k > 0 && this.field_92016_l != null) {
/* 212 */         String str = this.field_92016_l.func_82833_r();
/* 213 */         int n = (i - fontRenderer.func_78256_a(str)) / 2;
/* 214 */         int i1 = j - 59;
/* 215 */         if (!this.field_73839_d.field_71442_b.func_78755_b())
/*     */         {
/* 217 */           i1 += 14;
/*     */         }
/*     */         
/* 220 */         int i2 = (int)(this.field_92017_k * 256.0F / 10.0F);
/* 221 */         if (i2 > 255) i2 = 255; 
/* 222 */         if (i2 > 0) {
/* 223 */           GL11.glPushMatrix();
/* 224 */           GL11.glEnable(3042);
/* 225 */           OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 226 */           fontRenderer.func_78261_a(str, n, i1, 16777215 + (i2 << 24));
/* 227 */           GL11.glDisable(3042);
/* 228 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/*     */       
/* 232 */       this.field_73839_d.field_71424_I.func_76319_b();
/*     */     } 
/*     */     
/* 235 */     if (this.field_73839_d.func_71355_q()) {
/* 236 */       this.field_73839_d.field_71424_I.func_76320_a("demo");
/* 237 */       String str = "";
/*     */       
/* 239 */       if (this.field_73839_d.field_71441_e.func_82737_E() >= 120500L) {
/* 240 */         str = I18n.func_135052_a("demo.demoExpired", new Object[0]);
/*     */       } else {
/* 242 */         str = I18n.func_135052_a("demo.remainingTime", new Object[] { StringUtils.func_76337_a((int)(120500L - this.field_73839_d.field_71441_e.func_82737_E())) });
/*     */       } 
/*     */       
/* 245 */       int n = fontRenderer.func_78256_a(str);
/* 246 */       fontRenderer.func_78261_a(str, i - n - 10, 5, 16777215);
/* 247 */       this.field_73839_d.field_71424_I.func_76319_b();
/*     */     } 
/*     */     
/* 250 */     if (this.field_73839_d.field_71474_y.field_74330_P) {
/* 251 */       this.field_73839_d.field_71424_I.func_76320_a("debug");
/* 252 */       GL11.glPushMatrix();
/*     */       
/* 254 */       fontRenderer.func_78261_a("Minecraft 1.7.10 (" + this.field_73839_d.field_71426_K + ")", 2, 2, 16777215);
/* 255 */       fontRenderer.func_78261_a(this.field_73839_d.func_71393_m(), 2, 12, 16777215);
/* 256 */       fontRenderer.func_78261_a(this.field_73839_d.func_71408_n(), 2, 22, 16777215);
/* 257 */       fontRenderer.func_78261_a(this.field_73839_d.func_71374_p(), 2, 32, 16777215);
/* 258 */       fontRenderer.func_78261_a(this.field_73839_d.func_71388_o(), 2, 42, 16777215);
/*     */       
/* 260 */       long l1 = Runtime.getRuntime().maxMemory();
/* 261 */       long l2 = Runtime.getRuntime().totalMemory();
/* 262 */       long l3 = Runtime.getRuntime().freeMemory();
/* 263 */       long l4 = l2 - l3;
/*     */       
/* 265 */       String str = "Used memory: " + (l4 * 100L / l1) + "% (" + (l4 / 1024L / 1024L) + "MB) of " + (l1 / 1024L / 1024L) + "MB";
/* 266 */       int n = 14737632;
/* 267 */       func_73731_b(fontRenderer, str, i - fontRenderer.func_78256_a(str) - 2, 2, 14737632);
/* 268 */       str = "Allocated memory: " + (l2 * 100L / l1) + "% (" + (l2 / 1024L / 1024L) + "MB)";
/* 269 */       func_73731_b(fontRenderer, str, i - fontRenderer.func_78256_a(str) - 2, 12, 14737632);
/*     */       
/* 271 */       int i1 = MathHelper.func_76128_c(this.field_73839_d.field_71439_g.field_70165_t);
/* 272 */       int i2 = MathHelper.func_76128_c(this.field_73839_d.field_71439_g.field_70163_u);
/* 273 */       int i3 = MathHelper.func_76128_c(this.field_73839_d.field_71439_g.field_70161_v);
/*     */       
/* 275 */       func_73731_b(fontRenderer, String.format("x: %.5f (%d) // c: %d (%d)", new Object[] { Double.valueOf(this.field_73839_d.field_71439_g.field_70165_t), Integer.valueOf(i1), Integer.valueOf(i1 >> 4), Integer.valueOf(i1 & 0xF) }), 2, 64, 14737632);
/* 276 */       func_73731_b(fontRenderer, String.format("y: %.3f (feet pos, %.3f eyes pos)", new Object[] { Double.valueOf(this.field_73839_d.field_71439_g.field_70121_D.field_72338_b), Double.valueOf(this.field_73839_d.field_71439_g.field_70163_u) }), 2, 72, 14737632);
/* 277 */       func_73731_b(fontRenderer, String.format("z: %.5f (%d) // c: %d (%d)", new Object[] { Double.valueOf(this.field_73839_d.field_71439_g.field_70161_v), Integer.valueOf(i3), Integer.valueOf(i3 >> 4), Integer.valueOf(i3 & 0xF) }), 2, 80, 14737632);
/*     */       
/* 279 */       int i4 = MathHelper.func_76128_c((this.field_73839_d.field_71439_g.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 280 */       func_73731_b(fontRenderer, "f: " + i4 + " (" + Direction.field_82373_c[i4] + ") / " + MathHelper.func_76142_g(this.field_73839_d.field_71439_g.field_70177_z), 2, 88, 14737632);
/*     */       
/* 282 */       if (this.field_73839_d.field_71441_e != null && this.field_73839_d.field_71441_e.func_72899_e(i1, i2, i3)) {
/* 283 */         Chunk chunk = this.field_73839_d.field_71441_e.func_72938_d(i1, i3);
/* 284 */         func_73731_b(fontRenderer, "lc: " + (chunk.func_76625_h() + 15) + " b: " + (chunk.func_76591_a(i1 & 0xF, i3 & 0xF, this.field_73839_d.field_71441_e.func_72959_q())).field_76791_y + " bl: " + chunk.func_76614_a(EnumSkyBlock.Block, i1 & 0xF, i2, i3 & 0xF) + " sl: " + chunk.func_76614_a(EnumSkyBlock.Sky, i1 & 0xF, i2, i3 & 0xF) + " rl: " + chunk.func_76629_c(i1 & 0xF, i2, i3 & 0xF, 0), 2, 96, 14737632);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 291 */       func_73731_b(fontRenderer, String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", new Object[] { Float.valueOf(this.field_73839_d.field_71439_g.field_71075_bZ.func_75094_b()), Float.valueOf(this.field_73839_d.field_71439_g.field_71075_bZ.func_75093_a()), Boolean.valueOf(this.field_73839_d.field_71439_g.field_70122_E), Integer.valueOf(this.field_73839_d.field_71441_e.func_72976_f(i1, i3)) }), 2, 104, 14737632);
/*     */ 
/*     */       
/* 294 */       if (this.field_73839_d.field_71460_t != null && this.field_73839_d.field_71460_t.func_147702_a()) {
/* 295 */         func_73731_b(fontRenderer, String.format("shader: %s", new Object[] { this.field_73839_d.field_71460_t.func_147706_e().func_148022_b() }), 2, 112, 14737632);
/*     */       }
/*     */       
/* 298 */       GL11.glPopMatrix();
/* 299 */       this.field_73839_d.field_71424_I.func_76319_b();
/*     */     } 
/*     */     
/* 302 */     if (this.field_73845_h > 0) {
/* 303 */       this.field_73839_d.field_71424_I.func_76320_a("overlayMessage");
/* 304 */       float f = this.field_73845_h - p_73830_1_;
/* 305 */       int n = (int)(f * 255.0F / 20.0F);
/* 306 */       if (n > 255) n = 255; 
/* 307 */       if (n > 8) {
/* 308 */         GL11.glPushMatrix();
/* 309 */         GL11.glTranslatef((i / 2), (j - 68), 0.0F);
/* 310 */         GL11.glEnable(3042);
/* 311 */         OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */         
/* 313 */         int i1 = 16777215;
/* 314 */         if (this.field_73844_j) {
/* 315 */           i1 = Color.HSBtoRGB(f / 50.0F, 0.7F, 0.6F) & 0xFFFFFF;
/*     */         }
/* 317 */         fontRenderer.func_78276_b(this.field_73838_g, -fontRenderer.func_78256_a(this.field_73838_g) / 2, -4, i1 + (n << 24 & 0xFF000000));
/* 318 */         GL11.glDisable(3042);
/* 319 */         GL11.glPopMatrix();
/*     */       } 
/* 321 */       this.field_73839_d.field_71424_I.func_76319_b();
/*     */     } 
/*     */     
/* 324 */     ScoreObjective scoreObjective = this.field_73839_d.field_71441_e.func_96441_U().func_96539_a(1);
/* 325 */     if (scoreObjective != null) {
/* 326 */       func_96136_a(scoreObjective, j, i, fontRenderer);
/*     */     }
/*     */     
/* 329 */     GL11.glEnable(3042);
/* 330 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 331 */     GL11.glDisable(3008);
/*     */     
/* 333 */     GL11.glPushMatrix();
/* 334 */     GL11.glTranslatef(0.0F, (j - 48), 0.0F);
/*     */     
/* 336 */     this.field_73839_d.field_71424_I.func_76320_a("chat");
/* 337 */     this.field_73840_e.func_146230_a(this.field_73837_f);
/* 338 */     this.field_73839_d.field_71424_I.func_76319_b();
/*     */     
/* 340 */     GL11.glPopMatrix();
/*     */     
/* 342 */     scoreObjective = this.field_73839_d.field_71441_e.func_96441_U().func_96539_a(0);
/* 343 */     if (this.field_73839_d.field_71474_y.field_74321_H.func_151470_d() && (!this.field_73839_d.func_71387_A() || this.field_73839_d.field_71439_g.field_71174_a.field_147303_b.size() > 1 || scoreObjective != null)) {
/* 344 */       this.field_73839_d.field_71424_I.func_76320_a("playerList");
/* 345 */       NetHandlerPlayClient netHandlerPlayClient = this.field_73839_d.field_71439_g.field_71174_a;
/* 346 */       List<GuiPlayerInfo> list = netHandlerPlayClient.field_147303_b;
/* 347 */       int n = netHandlerPlayClient.field_147304_c;
/*     */       
/* 349 */       int i1 = n;
/* 350 */       byte b1 = 1;
/* 351 */       while (i1 > 20) {
/* 352 */         b1++;
/* 353 */         i1 = (n + b1 - 1) / b1;
/*     */       } 
/*     */       
/* 356 */       int i2 = 300 / b1;
/* 357 */       if (i2 > 150) i2 = 150;
/*     */       
/* 359 */       int i3 = (i - b1 * i2) / 2;
/* 360 */       byte b2 = 10;
/* 361 */       func_73734_a(i3 - 1, b2 - 1, i3 + i2 * b1, b2 + 9 * i1, -2147483648);
/*     */       
/* 363 */       for (byte b3 = 0; b3 < n; b3++) {
/* 364 */         int i4 = i3 + b3 % b1 * i2;
/* 365 */         int i5 = b2 + b3 / b1 * 9;
/*     */         
/* 367 */         func_73734_a(i4, i5, i4 + i2 - 1, i5 + 8, 553648127);
/* 368 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 369 */         GL11.glEnable(3008);
/*     */         
/* 371 */         if (b3 < list.size()) {
/* 372 */           GuiPlayerInfo guiPlayerInfo = list.get(b3);
/* 373 */           ScorePlayerTeam scorePlayerTeam = this.field_73839_d.field_71441_e.func_96441_U().func_96509_i(guiPlayerInfo.field_78831_a);
/* 374 */           String str = ScorePlayerTeam.func_96667_a((Team)scorePlayerTeam, guiPlayerInfo.field_78831_a);
/*     */           
/* 376 */           fontRenderer.func_78261_a(str, i4, i5, 16777215);
/*     */           
/* 378 */           if (scoreObjective != null) {
/* 379 */             int i6 = i4 + fontRenderer.func_78256_a(str) + 5;
/* 380 */             int i7 = i4 + i2 - 12 - 5;
/*     */             
/* 382 */             if (i7 - i6 > 5) {
/* 383 */               Score score = scoreObjective.func_96682_a().func_96529_a(guiPlayerInfo.field_78831_a, scoreObjective);
/* 384 */               String str1 = EnumChatFormatting.YELLOW + "" + score.func_96652_c();
/*     */               
/* 386 */               fontRenderer.func_78261_a(str1, i7 - fontRenderer.func_78256_a(str1), i5, 16777215);
/*     */             } 
/*     */           } 
/*     */           
/* 390 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 391 */           this.field_73839_d.func_110434_K().func_110577_a(field_110324_m);
/* 392 */           byte b4 = 0;
/* 393 */           byte b5 = 0;
/*     */           
/* 395 */           if (guiPlayerInfo.field_78829_b < 0) { b5 = 5; }
/* 396 */           else if (guiPlayerInfo.field_78829_b < 150) { b5 = 0; }
/* 397 */           else if (guiPlayerInfo.field_78829_b < 300) { b5 = 1; }
/* 398 */           else if (guiPlayerInfo.field_78829_b < 600) { b5 = 2; }
/* 399 */           else if (guiPlayerInfo.field_78829_b < 1000) { b5 = 3; }
/* 400 */           else { b5 = 4; }
/*     */           
/* 402 */           this.field_73735_i += 100.0F;
/* 403 */           func_73729_b(i4 + i2 - 12, i5, 0 + b4 * 10, 176 + b5 * 8, 10, 8);
/* 404 */           this.field_73735_i -= 100.0F;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 409 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 410 */     GL11.glDisable(2896);
/* 411 */     GL11.glEnable(3008);
/*     */   }
/*     */   
/*     */   public void func_152126_a(float p_152126_1_, float p_152126_2_) {
/* 415 */     this.field_152127_m.func_152437_a((int)(p_152126_1_ - 10.0F), 10);
/*     */   }
/*     */   
/*     */   protected void func_96136_a(ScoreObjective p_96136_1_, int p_96136_2_, int p_96136_3_, FontRenderer p_96136_4_) {
/* 419 */     Scoreboard scoreboard = p_96136_1_.func_96682_a();
/* 420 */     Collection collection = scoreboard.func_96534_i(p_96136_1_);
/* 421 */     if (collection.size() > 15)
/*     */       return; 
/* 423 */     int i = p_96136_4_.func_78256_a(p_96136_1_.func_96678_d());
/* 424 */     for (Score score : collection) {
/* 425 */       ScorePlayerTeam scorePlayerTeam = scoreboard.func_96509_i(score.func_96653_e());
/* 426 */       String str = ScorePlayerTeam.func_96667_a((Team)scorePlayerTeam, score.func_96653_e()) + ": " + EnumChatFormatting.RED + score.func_96652_c();
/* 427 */       i = Math.max(i, p_96136_4_.func_78256_a(str));
/*     */     } 
/*     */     
/* 430 */     int j = collection.size() * p_96136_4_.field_78288_b;
/* 431 */     int k = p_96136_2_ / 2 + j / 3;
/* 432 */     byte b1 = 3;
/* 433 */     int m = p_96136_3_ - i - b1;
/* 434 */     byte b2 = 0;
/*     */     
/* 436 */     for (Score score : collection) {
/* 437 */       b2++;
/* 438 */       ScorePlayerTeam scorePlayerTeam = scoreboard.func_96509_i(score.func_96653_e());
/* 439 */       String str1 = ScorePlayerTeam.func_96667_a((Team)scorePlayerTeam, score.func_96653_e());
/* 440 */       String str2 = EnumChatFormatting.RED + "" + score.func_96652_c();
/* 441 */       int n = m;
/* 442 */       int i1 = k - b2 * p_96136_4_.field_78288_b;
/* 443 */       int i2 = p_96136_3_ - b1 + 2;
/*     */       
/* 445 */       func_73734_a(n - 2, i1, i2, i1 + p_96136_4_.field_78288_b, 1342177280);
/* 446 */       p_96136_4_.func_78276_b(str1, n, i1, 553648127);
/* 447 */       p_96136_4_.func_78276_b(str2, i2 - p_96136_4_.func_78256_a(str2), i1, 553648127);
/*     */       
/* 449 */       if (b2 == collection.size()) {
/* 450 */         String str = p_96136_1_.func_96678_d();
/* 451 */         func_73734_a(n - 2, i1 - p_96136_4_.field_78288_b - 1, i2, i1 - 1, 1610612736);
/* 452 */         func_73734_a(n - 2, i1 - 1, i2, i1, 1342177280);
/* 453 */         p_96136_4_.func_78276_b(str, n + i / 2 - p_96136_4_.func_78256_a(str) / 2, i1 - p_96136_4_.field_78288_b, 553648127);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_110327_a(int p_110327_1_, int p_110327_2_) {
/* 459 */     boolean bool1 = (this.field_73839_d.field_71439_g.field_70172_ad / 3 % 2 == 1) ? true : false;
/* 460 */     if (this.field_73839_d.field_71439_g.field_70172_ad < 10) bool1 = false; 
/* 461 */     int i = MathHelper.func_76123_f(this.field_73839_d.field_71439_g.func_110143_aJ());
/* 462 */     int j = MathHelper.func_76123_f(this.field_73839_d.field_71439_g.field_70735_aL);
/* 463 */     this.field_73842_c.setSeed((this.field_73837_f * 312871));
/*     */     
/* 465 */     boolean bool2 = false;
/* 466 */     FoodStats foodStats = this.field_73839_d.field_71439_g.func_71024_bL();
/* 467 */     int k = foodStats.func_75116_a();
/* 468 */     int m = foodStats.func_75120_b();
/* 469 */     IAttributeInstance iAttributeInstance = this.field_73839_d.field_71439_g.func_110148_a(SharedMonsterAttributes.field_111267_a);
/*     */     
/* 471 */     int n = p_110327_1_ / 2 - 91;
/* 472 */     int i1 = p_110327_1_ / 2 + 91;
/*     */     
/* 474 */     int i2 = p_110327_2_ - 39;
/* 475 */     float f1 = (float)iAttributeInstance.func_111126_e();
/* 476 */     float f2 = this.field_73839_d.field_71439_g.func_110139_bj();
/* 477 */     int i3 = MathHelper.func_76123_f((f1 + f2) / 2.0F / 10.0F);
/* 478 */     int i4 = Math.max(10 - i3 - 2, 3);
/* 479 */     int i5 = i2 - (i3 - 1) * i4 - 10;
/* 480 */     float f3 = f2;
/*     */     
/* 482 */     int i6 = this.field_73839_d.field_71439_g.func_70658_aO();
/* 483 */     int i7 = -1;
/* 484 */     if (this.field_73839_d.field_71439_g.func_70644_a(Potion.field_76428_l)) {
/* 485 */       i7 = this.field_73837_f % MathHelper.func_76123_f(f1 + 5.0F);
/*     */     }
/*     */ 
/*     */     
/* 489 */     this.field_73839_d.field_71424_I.func_76320_a("armor"); int i8;
/* 490 */     for (i8 = 0; i8 < 10; i8++) {
/* 491 */       if (i6 > 0) {
/* 492 */         int i9 = n + i8 * 8;
/* 493 */         if (i8 * 2 + 1 < i6) func_73729_b(i9, i5, 34, 9, 9, 9); 
/* 494 */         if (i8 * 2 + 1 == i6) func_73729_b(i9, i5, 25, 9, 9, 9); 
/* 495 */         if (i8 * 2 + 1 > i6) func_73729_b(i9, i5, 16, 9, 9, 9); 
/*     */       } 
/*     */     } 
/* 498 */     this.field_73839_d.field_71424_I.func_76318_c("health");
/* 499 */     for (i8 = MathHelper.func_76123_f((f1 + f2) / 2.0F) - 1; i8 >= 0; i8--) {
/* 500 */       byte b1 = 16;
/* 501 */       if (this.field_73839_d.field_71439_g.func_70644_a(Potion.field_76436_u)) {
/* 502 */         b1 += 36;
/* 503 */       } else if (this.field_73839_d.field_71439_g.func_70644_a(Potion.field_82731_v)) {
/* 504 */         b1 += 72;
/*     */       } 
/*     */       
/* 507 */       byte b2 = 0;
/* 508 */       if (bool1) b2 = 1; 
/* 509 */       int i9 = MathHelper.func_76123_f((i8 + 1) / 10.0F) - 1;
/* 510 */       int i10 = n + i8 % 10 * 8;
/* 511 */       int i11 = i2 - i9 * i4;
/* 512 */       if (i <= 4) {
/* 513 */         i11 += this.field_73842_c.nextInt(2);
/*     */       }
/*     */       
/* 516 */       if (i8 == i7) {
/* 517 */         i11 -= 2;
/*     */       }
/*     */       
/* 520 */       byte b3 = 0;
/* 521 */       if (this.field_73839_d.field_71441_e.func_72912_H().func_76093_s()) {
/* 522 */         b3 = 5;
/*     */       }
/*     */       
/* 525 */       func_73729_b(i10, i11, 16 + b2 * 9, 9 * b3, 9, 9);
/* 526 */       if (bool1) {
/* 527 */         if (i8 * 2 + 1 < j) func_73729_b(i10, i11, b1 + 54, 9 * b3, 9, 9); 
/* 528 */         if (i8 * 2 + 1 == j) func_73729_b(i10, i11, b1 + 63, 9 * b3, 9, 9);
/*     */       
/*     */       } 
/* 531 */       if (f3 > 0.0F) {
/* 532 */         if (f3 == f2 && f2 % 2.0F == 1.0F) {
/* 533 */           func_73729_b(i10, i11, b1 + 153, 9 * b3, 9, 9);
/*     */         } else {
/* 535 */           func_73729_b(i10, i11, b1 + 144, 9 * b3, 9, 9);
/*     */         } 
/* 537 */         f3 -= 2.0F;
/*     */       } else {
/* 539 */         if (i8 * 2 + 1 < i) func_73729_b(i10, i11, b1 + 36, 9 * b3, 9, 9); 
/* 540 */         if (i8 * 2 + 1 == i) func_73729_b(i10, i11, b1 + 45, 9 * b3, 9, 9);
/*     */       
/*     */       } 
/*     */     } 
/* 544 */     Entity entity = this.field_73839_d.field_71439_g.field_70154_o;
/* 545 */     if (entity == null) {
/*     */       
/* 547 */       this.field_73839_d.field_71424_I.func_76318_c("food");
/* 548 */       for (byte b = 0; b < 10; b++) {
/* 549 */         int i9 = i2;
/*     */         
/* 551 */         byte b1 = 16;
/* 552 */         byte b2 = 0;
/* 553 */         if (this.field_73839_d.field_71439_g.func_70644_a(Potion.field_76438_s)) {
/* 554 */           b1 += 36;
/* 555 */           b2 = 13;
/*     */         } 
/*     */         
/* 558 */         if (this.field_73839_d.field_71439_g.func_71024_bL().func_75115_e() <= 0.0F && 
/* 559 */           this.field_73837_f % (k * 3 + 1) == 0) {
/* 560 */           i9 += this.field_73842_c.nextInt(3) - 1;
/*     */         }
/*     */ 
/*     */         
/* 564 */         if (bool2) b2 = 1; 
/* 565 */         int i10 = i1 - b * 8 - 9;
/* 566 */         func_73729_b(i10, i9, 16 + b2 * 9, 27, 9, 9);
/* 567 */         if (bool2) {
/* 568 */           if (b * 2 + 1 < m) func_73729_b(i10, i9, b1 + 54, 27, 9, 9); 
/* 569 */           if (b * 2 + 1 == m) func_73729_b(i10, i9, b1 + 63, 27, 9, 9); 
/*     */         } 
/* 571 */         if (b * 2 + 1 < k) func_73729_b(i10, i9, b1 + 36, 27, 9, 9); 
/* 572 */         if (b * 2 + 1 == k) func_73729_b(i10, i9, b1 + 45, 27, 9, 9); 
/*     */       } 
/* 574 */     } else if (entity instanceof EntityLivingBase) {
/*     */       
/* 576 */       this.field_73839_d.field_71424_I.func_76318_c("mountHealth");
/*     */       
/* 578 */       EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
/* 579 */       int i9 = (int)Math.ceil(entityLivingBase.func_110143_aJ());
/* 580 */       float f = entityLivingBase.func_110138_aP();
/* 581 */       int i10 = (int)(f + 0.5F) / 2;
/* 582 */       if (i10 > 30) {
/* 583 */         i10 = 30;
/*     */       }
/*     */       
/* 586 */       int i11 = i2;
/* 587 */       byte b = 0;
/*     */       
/* 589 */       while (i10 > 0) {
/* 590 */         int i12 = Math.min(i10, 10);
/* 591 */         i10 -= i12;
/*     */         
/* 593 */         for (byte b1 = 0; b1 < i12; b1++) {
/*     */           
/* 595 */           byte b2 = 52;
/* 596 */           byte b3 = 0;
/*     */           
/* 598 */           if (bool2) b3 = 1; 
/* 599 */           int i13 = i1 - b1 * 8 - 9;
/* 600 */           func_73729_b(i13, i11, b2 + b3 * 9, 9, 9, 9);
/* 601 */           if (b1 * 2 + 1 + b < i9) func_73729_b(i13, i11, b2 + 36, 9, 9, 9); 
/* 602 */           if (b1 * 2 + 1 + b == i9) func_73729_b(i13, i11, b2 + 45, 9, 9, 9); 
/*     */         } 
/* 604 */         i11 -= 10;
/* 605 */         b += 20;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 610 */     this.field_73839_d.field_71424_I.func_76318_c("air");
/* 611 */     if (this.field_73839_d.field_71439_g.func_70055_a(Material.field_151586_h)) {
/* 612 */       int i9 = this.field_73839_d.field_71439_g.func_70086_ai();
/*     */       
/* 614 */       int i10 = MathHelper.func_76143_f((i9 - 2) * 10.0D / 300.0D);
/* 615 */       int i11 = MathHelper.func_76143_f(i9 * 10.0D / 300.0D) - i10;
/*     */       
/* 617 */       for (byte b = 0; b < i10 + i11; b++) {
/* 618 */         if (b < i10) { func_73729_b(i1 - b * 8 - 9, i5, 16, 18, 9, 9); }
/* 619 */         else { func_73729_b(i1 - b * 8 - 9, i5, 25, 18, 9, 9); }
/*     */       
/*     */       } 
/*     */     } 
/* 623 */     this.field_73839_d.field_71424_I.func_76319_b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73828_d() {
/* 628 */     if (BossStatus.field_82827_c == null || BossStatus.field_82826_b <= 0)
/* 629 */       return;  BossStatus.field_82826_b--;
/*     */     
/* 631 */     FontRenderer fontRenderer = this.field_73839_d.field_71466_p;
/*     */     
/* 633 */     ScaledResolution scaledResolution = new ScaledResolution(this.field_73839_d, this.field_73839_d.field_71443_c, this.field_73839_d.field_71440_d);
/* 634 */     int i = scaledResolution.func_78326_a();
/*     */     
/* 636 */     char c = '¶';
/* 637 */     int j = i / 2 - c / 2;
/*     */     
/* 639 */     int k = (int)(BossStatus.field_82828_a * (c + 1));
/*     */     
/* 641 */     byte b = 12;
/* 642 */     func_73729_b(j, b, 0, 74, c, 5);
/* 643 */     func_73729_b(j, b, 0, 74, c, 5);
/* 644 */     if (k > 0) {
/* 645 */       func_73729_b(j, b, 0, 79, k, 5);
/*     */     }
/* 647 */     String str = BossStatus.field_82827_c;
/* 648 */     fontRenderer.func_78261_a(str, i / 2 - fontRenderer.func_78256_a(str) / 2, b - 10, 16777215);
/* 649 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 650 */     this.field_73839_d.func_110434_K().func_110577_a(field_110324_m);
/*     */   }
/*     */   
/*     */   protected void func_73836_a(int p_73836_1_, int p_73836_2_) {
/* 654 */     GL11.glDisable(2929);
/* 655 */     GL11.glDepthMask(false);
/* 656 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 657 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 658 */     GL11.glDisable(3008);
/*     */     
/* 660 */     this.field_73839_d.func_110434_K().func_110577_a(field_110328_d);
/* 661 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 662 */     tessellator.func_78382_b();
/* 663 */     tessellator.func_78374_a(0.0D, p_73836_2_, -90.0D, 0.0D, 1.0D);
/* 664 */     tessellator.func_78374_a(p_73836_1_, p_73836_2_, -90.0D, 1.0D, 1.0D);
/* 665 */     tessellator.func_78374_a(p_73836_1_, 0.0D, -90.0D, 1.0D, 0.0D);
/* 666 */     tessellator.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
/* 667 */     tessellator.func_78381_a();
/* 668 */     GL11.glDepthMask(true);
/* 669 */     GL11.glEnable(2929);
/* 670 */     GL11.glEnable(3008);
/* 671 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_73829_a(float p_73829_1_, int p_73829_2_, int p_73829_3_) {
/* 675 */     p_73829_1_ = 1.0F - p_73829_1_;
/* 676 */     if (p_73829_1_ < 0.0F) p_73829_1_ = 0.0F; 
/* 677 */     if (p_73829_1_ > 1.0F) p_73829_1_ = 1.0F; 
/* 678 */     this.field_73843_a = (float)(this.field_73843_a + (p_73829_1_ - this.field_73843_a) * 0.01D);
/*     */     
/* 680 */     GL11.glDisable(2929);
/* 681 */     GL11.glDepthMask(false);
/* 682 */     OpenGlHelper.func_148821_a(0, 769, 1, 0);
/* 683 */     GL11.glColor4f(this.field_73843_a, this.field_73843_a, this.field_73843_a, 1.0F);
/* 684 */     this.field_73839_d.func_110434_K().func_110577_a(field_110329_b);
/* 685 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 686 */     tessellator.func_78382_b();
/* 687 */     tessellator.func_78374_a(0.0D, p_73829_3_, -90.0D, 0.0D, 1.0D);
/* 688 */     tessellator.func_78374_a(p_73829_2_, p_73829_3_, -90.0D, 1.0D, 1.0D);
/* 689 */     tessellator.func_78374_a(p_73829_2_, 0.0D, -90.0D, 1.0D, 0.0D);
/* 690 */     tessellator.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
/* 691 */     tessellator.func_78381_a();
/* 692 */     GL11.glDepthMask(true);
/* 693 */     GL11.glEnable(2929);
/* 694 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 695 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */   }
/*     */   
/*     */   protected void func_130015_b(float p_130015_1_, int p_130015_2_, int p_130015_3_) {
/* 699 */     if (p_130015_1_ < 1.0F) {
/* 700 */       p_130015_1_ *= p_130015_1_;
/* 701 */       p_130015_1_ *= p_130015_1_;
/* 702 */       p_130015_1_ = p_130015_1_ * 0.8F + 0.2F;
/*     */     } 
/*     */     
/* 705 */     GL11.glDisable(3008);
/* 706 */     GL11.glDisable(2929);
/* 707 */     GL11.glDepthMask(false);
/* 708 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 709 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, p_130015_1_);
/*     */     
/* 711 */     IIcon iIcon = Blocks.field_150427_aO.func_149733_h(1);
/* 712 */     this.field_73839_d.func_110434_K().func_110577_a(TextureMap.field_110575_b);
/*     */     
/* 714 */     float f1 = iIcon.func_94209_e();
/* 715 */     float f2 = iIcon.func_94206_g();
/* 716 */     float f3 = iIcon.func_94212_f();
/* 717 */     float f4 = iIcon.func_94210_h();
/* 718 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 719 */     tessellator.func_78382_b();
/* 720 */     tessellator.func_78374_a(0.0D, p_130015_3_, -90.0D, f1, f4);
/* 721 */     tessellator.func_78374_a(p_130015_2_, p_130015_3_, -90.0D, f3, f4);
/* 722 */     tessellator.func_78374_a(p_130015_2_, 0.0D, -90.0D, f3, f2);
/* 723 */     tessellator.func_78374_a(0.0D, 0.0D, -90.0D, f1, f2);
/* 724 */     tessellator.func_78381_a();
/* 725 */     GL11.glDepthMask(true);
/* 726 */     GL11.glEnable(2929);
/* 727 */     GL11.glEnable(3008);
/* 728 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_73832_a(int p_73832_1_, int p_73832_2_, int p_73832_3_, float p_73832_4_) {
/* 732 */     ItemStack itemStack = this.field_73839_d.field_71439_g.field_71071_by.field_70462_a[p_73832_1_];
/* 733 */     if (itemStack == null)
/*     */       return; 
/* 735 */     float f = itemStack.field_77992_b - p_73832_4_;
/* 736 */     if (f > 0.0F) {
/* 737 */       GL11.glPushMatrix();
/* 738 */       float f1 = 1.0F + f / 5.0F;
/* 739 */       GL11.glTranslatef((p_73832_2_ + 8), (p_73832_3_ + 12), 0.0F);
/* 740 */       GL11.glScalef(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
/* 741 */       GL11.glTranslatef(-(p_73832_2_ + 8), -(p_73832_3_ + 12), 0.0F);
/*     */     } 
/*     */     
/* 744 */     field_73841_b.func_82406_b(this.field_73839_d.field_71466_p, this.field_73839_d.func_110434_K(), itemStack, p_73832_2_, p_73832_3_);
/*     */     
/* 746 */     if (f > 0.0F) {
/* 747 */       GL11.glPopMatrix();
/*     */     }
/*     */     
/* 750 */     field_73841_b.func_77021_b(this.field_73839_d.field_71466_p, this.field_73839_d.func_110434_K(), itemStack, p_73832_2_, p_73832_3_);
/*     */   }
/*     */   
/*     */   public void func_73831_a() {
/* 754 */     if (this.field_73845_h > 0) this.field_73845_h--; 
/* 755 */     this.field_73837_f++;
/*     */     
/* 757 */     this.field_152127_m.func_152439_a();
/*     */     
/* 759 */     if (this.field_73839_d.field_71439_g != null) {
/* 760 */       ItemStack itemStack = this.field_73839_d.field_71439_g.field_71071_by.func_70448_g();
/*     */       
/* 762 */       if (itemStack == null) {
/* 763 */         this.field_92017_k = 0;
/* 764 */       } else if (this.field_92016_l == null || itemStack.func_77973_b() != this.field_92016_l.func_77973_b() || !ItemStack.func_77970_a(itemStack, this.field_92016_l) || (!itemStack.func_77984_f() && itemStack.func_77960_j() != this.field_92016_l.func_77960_j())) {
/*     */         
/* 766 */         this.field_92017_k = 40;
/* 767 */       } else if (this.field_92017_k > 0) {
/* 768 */         this.field_92017_k--;
/*     */       } 
/* 770 */       this.field_92016_l = itemStack;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73833_a(String p_73833_1_) {
/* 775 */     func_110326_a(I18n.func_135052_a("record.nowPlaying", new Object[] { p_73833_1_ }), true);
/*     */   }
/*     */   
/*     */   public void func_110326_a(String p_110326_1_, boolean p_110326_2_) {
/* 779 */     this.field_73838_g = p_110326_1_;
/* 780 */     this.field_73845_h = 60;
/* 781 */     this.field_73844_j = p_110326_2_;
/*     */   }
/*     */   
/*     */   public GuiNewChat func_146158_b() {
/* 785 */     return this.field_73840_e;
/*     */   }
/*     */   
/*     */   public int func_73834_c() {
/* 789 */     return this.field_73837_f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiIngame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */