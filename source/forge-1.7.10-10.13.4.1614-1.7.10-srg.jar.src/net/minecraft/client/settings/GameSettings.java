/*     */ package net.minecraft.client.settings;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.Gson;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.SoundCategory;
/*     */ import net.minecraft.client.gui.GuiNewChat;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.stream.TwitchStream;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GameSettings {
/*  30 */   private static final Logger field_151454_ax = LogManager.getLogger();
/*  31 */   private static final Gson field_151450_ay = new Gson();
/*  32 */   private static final ParameterizedType field_151449_az = new ParameterizedType() { private static final String __OBFID = "CL_00000651";
/*     */       
/*     */       public Type[] getActualTypeArguments() {
/*  35 */         return new Type[] { String.class };
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Type getRawType() {
/*  42 */         return List.class;
/*     */       }
/*     */ 
/*     */       
/*     */       public Type getOwnerType() {
/*  47 */         return null;
/*     */       } }
/*     */   ;
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public enum Options
/*     */   {
/*  79 */     INVERT_MOUSE("options.invertMouse", false, true),
/*  80 */     SENSITIVITY("options.sensitivity", true, false),
/*  81 */     FOV("options.fov", true, false, 30.0F, 110.0F, 1.0F),
/*  82 */     GAMMA("options.gamma", true, false),
/*  83 */     SATURATION("options.saturation", true, false),
/*  84 */     RENDER_DISTANCE("options.renderDistance", true, false, 2.0F, 16.0F, 1.0F),
/*  85 */     VIEW_BOBBING("options.viewBobbing", false, true),
/*  86 */     ANAGLYPH("options.anaglyph", false, true),
/*  87 */     ADVANCED_OPENGL("options.advancedOpengl", false, true),
/*  88 */     FRAMERATE_LIMIT("options.framerateLimit", true, false, 10.0F, 260.0F, 10.0F),
/*  89 */     FBO_ENABLE("options.fboEnable", false, true),
/*  90 */     DIFFICULTY("options.difficulty", false, false),
/*  91 */     GRAPHICS("options.graphics", false, false),
/*  92 */     AMBIENT_OCCLUSION("options.ao", false, false),
/*  93 */     GUI_SCALE("options.guiScale", false, false),
/*  94 */     RENDER_CLOUDS("options.renderClouds", false, true),
/*  95 */     PARTICLES("options.particles", false, false),
/*  96 */     CHAT_VISIBILITY("options.chat.visibility", false, false),
/*  97 */     CHAT_COLOR("options.chat.color", false, true),
/*  98 */     CHAT_LINKS("options.chat.links", false, true),
/*  99 */     CHAT_OPACITY("options.chat.opacity", true, false),
/* 100 */     CHAT_LINKS_PROMPT("options.chat.links.prompt", false, true),
/* 101 */     SNOOPER_ENABLED("options.snooper", false, true),
/* 102 */     USE_FULLSCREEN("options.fullscreen", false, true),
/* 103 */     ENABLE_VSYNC("options.vsync", false, true),
/* 104 */     SHOW_CAPE("options.showCape", false, true),
/* 105 */     TOUCHSCREEN("options.touchscreen", false, true),
/* 106 */     CHAT_SCALE("options.chat.scale", true, false),
/* 107 */     CHAT_WIDTH("options.chat.width", true, false),
/* 108 */     CHAT_HEIGHT_FOCUSED("options.chat.height.focused", true, false),
/* 109 */     CHAT_HEIGHT_UNFOCUSED("options.chat.height.unfocused", true, false),
/* 110 */     MIPMAP_LEVELS("options.mipmapLevels", true, false, 0.0F, 4.0F, 1.0F),
/* 111 */     ANISOTROPIC_FILTERING("options.anisotropicFiltering", true, false, 1.0F, 16.0F, 0.0F) { private static final String __OBFID = "CL_00000654";
/*     */       
/*     */       protected float func_148264_f(float p_148264_1_) {
/* 114 */         return MathHelper.func_151236_b((int)p_148264_1_);
/*     */       } }
/*     */     ,
/* 117 */     FORCE_UNICODE_FONT("options.forceUnicodeFont", false, true),
/* 118 */     STREAM_BYTES_PER_PIXEL("options.stream.bytesPerPixel", true, false),
/* 119 */     STREAM_VOLUME_MIC("options.stream.micVolumne", true, false),
/* 120 */     STREAM_VOLUME_SYSTEM("options.stream.systemVolume", true, false),
/* 121 */     STREAM_KBPS("options.stream.kbps", true, false),
/* 122 */     STREAM_FPS("options.stream.fps", true, false),
/* 123 */     STREAM_COMPRESSION("options.stream.compression", false, false),
/* 124 */     STREAM_SEND_METADATA("options.stream.sendMetadata", false, true),
/* 125 */     STREAM_CHAT_ENABLED("options.stream.chat.enabled", false, false),
/* 126 */     STREAM_CHAT_USER_FILTER("options.stream.chat.userFilter", false, false),
/* 127 */     STREAM_MIC_TOGGLE_BEHAVIOR("options.stream.micToggleBehavior", false, false);
/*     */     
/*     */     private final boolean field_74385_A;
/*     */     private final boolean field_74386_B;
/*     */     private final String field_74387_C;
/*     */     private final float field_148270_M;
/*     */     private float field_148271_N;
/*     */     private float field_148272_O;
/*     */     private static final String __OBFID = "CL_00000653";
/*     */     
/*     */     public static Options func_74379_a(int p_74379_0_) {
/* 138 */       for (Options options : values()) {
/* 139 */         if (options.func_74381_c() == p_74379_0_) {
/* 140 */           return options;
/*     */         }
/*     */       } 
/* 143 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Options(String p_i45004_3_, boolean p_i45004_4_, boolean p_i45004_5_, float p_i45004_6_, float p_i45004_7_, float p_i45004_8_) {
/* 151 */       this.field_74387_C = p_i45004_3_;
/* 152 */       this.field_74385_A = p_i45004_4_;
/* 153 */       this.field_74386_B = p_i45004_5_;
/* 154 */       this.field_148271_N = p_i45004_6_;
/* 155 */       this.field_148272_O = p_i45004_7_;
/* 156 */       this.field_148270_M = p_i45004_8_;
/*     */     }
/*     */     
/*     */     public boolean func_74380_a() {
/* 160 */       return this.field_74385_A;
/*     */     }
/*     */     
/*     */     public boolean func_74382_b() {
/* 164 */       return this.field_74386_B;
/*     */     }
/*     */     
/*     */     public int func_74381_c() {
/* 168 */       return ordinal();
/*     */     }
/*     */     
/*     */     public String func_74378_d() {
/* 172 */       return this.field_74387_C;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float func_148267_f() {
/* 180 */       return this.field_148272_O;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_148263_a(float p_148263_1_) {
/* 188 */       this.field_148272_O = p_148263_1_;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float func_148266_c(float p_148266_1_) {
/* 196 */       return MathHelper.func_76131_a((func_148268_e(p_148266_1_) - this.field_148271_N) / (this.field_148272_O - this.field_148271_N), 0.0F, 1.0F);
/*     */     }
/*     */     
/*     */     public float func_148262_d(float p_148262_1_) {
/* 200 */       return func_148268_e(this.field_148271_N + (this.field_148272_O - this.field_148271_N) * MathHelper.func_76131_a(p_148262_1_, 0.0F, 1.0F));
/*     */     }
/*     */     
/*     */     public float func_148268_e(float p_148268_1_) {
/* 204 */       p_148268_1_ = func_148264_f(p_148268_1_);
/* 205 */       return MathHelper.func_76131_a(p_148268_1_, this.field_148271_N, this.field_148272_O);
/*     */     }
/*     */     
/*     */     protected float func_148264_f(float p_148264_1_) {
/* 209 */       if (this.field_148270_M > 0.0F) {
/* 210 */         p_148264_1_ = this.field_148270_M * Math.round(p_148264_1_ / this.field_148270_M);
/*     */       }
/* 212 */       return p_148264_1_;
/*     */     }
/*     */   }
/*     */   
/* 216 */   private static final String[] field_74367_ae = new String[] { "options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large" };
/*     */ 
/*     */   
/* 219 */   private static final String[] field_74364_ag = new String[] { "options.particles.all", "options.particles.decreased", "options.particles.minimal" };
/*     */ 
/*     */   
/* 222 */   private static final String[] field_98303_au = new String[] { "options.ao.off", "options.ao.min", "options.ao.max" };
/*     */ 
/*     */   
/* 225 */   private static final String[] field_152391_aS = new String[] { "options.stream.compression.low", "options.stream.compression.medium", "options.stream.compression.high" };
/*     */ 
/*     */   
/* 228 */   private static final String[] field_152392_aT = new String[] { "options.stream.chat.enabled.streaming", "options.stream.chat.enabled.always", "options.stream.chat.enabled.never" };
/*     */ 
/*     */   
/* 231 */   private static final String[] field_152393_aU = new String[] { "options.stream.chat.userFilter.all", "options.stream.chat.userFilter.subs", "options.stream.chat.userFilter.mods" };
/*     */ 
/*     */   
/* 234 */   private static final String[] field_152394_aV = new String[] { "options.stream.mic_toggle.mute", "options.stream.mic_toggle.talk" };
/*     */ 
/*     */ 
/*     */   
/* 238 */   public float field_74341_c = 0.5F;
/*     */   public boolean field_74338_d;
/* 240 */   public int field_151451_c = -1;
/*     */   public boolean field_74336_f = true;
/*     */   public boolean field_74337_g;
/*     */   public boolean field_74349_h;
/*     */   public boolean field_151448_g = true;
/* 245 */   public int field_74350_i = 120;
/*     */   public boolean field_74347_j = true;
/* 247 */   public int field_74348_k = 2;
/*     */   public boolean field_74345_l = true;
/* 249 */   public List field_151453_l = new ArrayList();
/* 250 */   public EntityPlayer.EnumChatVisibility field_74343_n = EntityPlayer.EnumChatVisibility.FULL;
/*     */   public boolean field_74344_o = true;
/*     */   public boolean field_74359_p = true;
/*     */   public boolean field_74358_q = true;
/* 254 */   public float field_74357_r = 1.0F;
/*     */   public boolean field_74355_t = true;
/*     */   public boolean field_74353_u;
/*     */   public boolean field_74352_v = true;
/*     */   public boolean field_80005_w;
/*     */   public boolean field_82882_x;
/*     */   public boolean field_82881_y = true;
/*     */   public boolean field_82880_z = true;
/*     */   public boolean field_85185_A;
/*     */   public int field_92118_B;
/*     */   public int field_92119_C;
/*     */   public boolean field_92117_D = true;
/* 266 */   public float field_96691_E = 1.0F;
/* 267 */   public float field_96692_F = 1.0F;
/* 268 */   public float field_96693_G = 0.44366196F;
/* 269 */   public float field_96694_H = 1.0F;
/*     */   public boolean field_151441_H = true;
/* 271 */   public int field_151442_I = 4;
/* 272 */   public int field_151443_J = 1;
/* 273 */   private Map field_151446_aD = Maps.newEnumMap(SoundCategory.class);
/* 274 */   public float field_152400_J = 0.5F;
/* 275 */   public float field_152401_K = 1.0F;
/* 276 */   public float field_152402_L = 1.0F;
/* 277 */   public float field_152403_M = 0.5412844F;
/* 278 */   public float field_152404_N = 0.31690142F;
/* 279 */   public int field_152405_O = 1;
/*     */   public boolean field_152406_P = true;
/* 281 */   public String field_152407_Q = "";
/* 282 */   public int field_152408_R = 0;
/* 283 */   public int field_152409_S = 0;
/* 284 */   public int field_152410_T = 0;
/*     */   
/* 286 */   public KeyBinding field_74351_w = new KeyBinding("key.forward", 17, "key.categories.movement");
/* 287 */   public KeyBinding field_74370_x = new KeyBinding("key.left", 30, "key.categories.movement");
/* 288 */   public KeyBinding field_74368_y = new KeyBinding("key.back", 31, "key.categories.movement");
/* 289 */   public KeyBinding field_74366_z = new KeyBinding("key.right", 32, "key.categories.movement");
/* 290 */   public KeyBinding field_74314_A = new KeyBinding("key.jump", 57, "key.categories.movement");
/* 291 */   public KeyBinding field_74311_E = new KeyBinding("key.sneak", 42, "key.categories.movement");
/*     */   
/* 293 */   public KeyBinding field_151445_Q = new KeyBinding("key.inventory", 18, "key.categories.inventory");
/* 294 */   public KeyBinding field_74313_G = new KeyBinding("key.use", -99, "key.categories.gameplay");
/* 295 */   public KeyBinding field_74316_C = new KeyBinding("key.drop", 16, "key.categories.gameplay");
/* 296 */   public KeyBinding field_74312_F = new KeyBinding("key.attack", -100, "key.categories.gameplay");
/* 297 */   public KeyBinding field_74322_I = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
/* 298 */   public KeyBinding field_151444_V = new KeyBinding("key.sprint", 29, "key.categories.gameplay");
/*     */   
/* 300 */   public KeyBinding field_74310_D = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
/* 301 */   public KeyBinding field_74321_H = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
/* 302 */   public KeyBinding field_74323_J = new KeyBinding("key.command", 53, "key.categories.multiplayer");
/*     */   
/* 304 */   public KeyBinding field_151447_Z = new KeyBinding("key.screenshot", 60, "key.categories.misc");
/* 305 */   public KeyBinding field_151457_aa = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
/* 306 */   public KeyBinding field_151458_ab = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
/* 307 */   public KeyBinding field_152395_am = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
/*     */   
/* 309 */   public KeyBinding field_152396_an = new KeyBinding("key.streamStartStop", 64, "key.categories.stream");
/* 310 */   public KeyBinding field_152397_ao = new KeyBinding("key.streamPauseUnpause", 65, "key.categories.stream");
/* 311 */   public KeyBinding field_152398_ap = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
/* 312 */   public KeyBinding field_152399_aq = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
/*     */   
/* 314 */   public KeyBinding[] field_151456_ac = new KeyBinding[] { new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory") };
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
/* 326 */   public KeyBinding[] field_74324_K = (KeyBinding[])ArrayUtils.addAll((Object[])new KeyBinding[] { this.field_74312_F, this.field_74313_G, this.field_74351_w, this.field_74370_x, this.field_74368_y, this.field_74366_z, this.field_74314_A, this.field_74311_E, this.field_74316_C, this.field_151445_Q, this.field_74310_D, this.field_74321_H, this.field_74322_I, this.field_74323_J, this.field_151447_Z, this.field_151457_aa, this.field_151458_ab, this.field_151444_V, this.field_152396_an, this.field_152397_ao, this.field_152398_ap, this.field_152399_aq, this.field_152395_am }, (Object[])this.field_151456_ac);
/*     */ 
/*     */ 
/*     */   
/*     */   protected Minecraft field_74317_L;
/*     */ 
/*     */ 
/*     */   
/*     */   private File field_74354_ai;
/*     */ 
/*     */ 
/*     */   
/* 338 */   public EnumDifficulty field_74318_M = EnumDifficulty.NORMAL;
/*     */   public boolean field_74319_N;
/*     */   public int field_74320_O;
/*     */   public boolean field_74330_P;
/*     */   public boolean field_74329_Q;
/* 343 */   public String field_74332_R = "";
/*     */   
/*     */   public boolean field_74331_S;
/*     */   public boolean field_74326_T;
/*     */   public boolean field_74325_U;
/* 348 */   public float field_74328_V = 1.0F;
/* 349 */   public float field_74327_W = 1.0F;
/* 350 */   public float field_74334_X = 70.0F;
/*     */   public float field_74333_Y;
/*     */   public float field_151452_as;
/*     */   public int field_74335_Z;
/*     */   public int field_74362_aa;
/* 355 */   public String field_74363_ab = "en_US"; public boolean field_151455_aw = false;
/*     */   private static final String __OBFID = "CL_00000650";
/*     */   
/*     */   public GameSettings(Minecraft p_i1016_1_, File p_i1016_2_) {
/* 359 */     this.field_74317_L = p_i1016_1_;
/* 360 */     this.field_74354_ai = new File(p_i1016_2_, "options.txt");
/*     */     
/* 362 */     Options.RENDER_DISTANCE.func_148263_a(16.0F);
/* 363 */     this.field_151451_c = p_i1016_1_.func_147111_S() ? 12 : 8;
/*     */     
/* 365 */     func_74300_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GameSettings() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String func_74298_c(int p_74298_0_) {
/* 381 */     if (p_74298_0_ < 0) {
/* 382 */       return I18n.func_135052_a("key.mouseButton", new Object[] { Integer.valueOf(p_74298_0_ + 101) });
/*     */     }
/* 384 */     return Keyboard.getKeyName(p_74298_0_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean func_100015_a(KeyBinding p_100015_0_) {
/* 395 */     if (p_100015_0_.func_151463_i() == 0) return false; 
/* 396 */     if (p_100015_0_.func_151463_i() < 0) {
/* 397 */       return Mouse.isButtonDown(p_100015_0_.func_151463_i() + 100);
/*     */     }
/* 399 */     return Keyboard.isKeyDown(p_100015_0_.func_151463_i());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_151440_a(KeyBinding p_151440_1_, int p_151440_2_) {
/* 404 */     p_151440_1_.func_151462_b(p_151440_2_);
/* 405 */     func_74303_b();
/*     */   }
/*     */   
/*     */   public void func_74304_a(Options p_74304_1_, float p_74304_2_) {
/* 409 */     if (p_74304_1_ == Options.SENSITIVITY) {
/* 410 */       this.field_74341_c = p_74304_2_;
/*     */     }
/* 412 */     if (p_74304_1_ == Options.FOV) {
/* 413 */       this.field_74334_X = p_74304_2_;
/*     */     }
/* 415 */     if (p_74304_1_ == Options.GAMMA) {
/* 416 */       this.field_74333_Y = p_74304_2_;
/*     */     }
/* 418 */     if (p_74304_1_ == Options.FRAMERATE_LIMIT) {
/* 419 */       this.field_74350_i = (int)p_74304_2_;
/*     */     }
/* 421 */     if (p_74304_1_ == Options.CHAT_OPACITY) {
/* 422 */       this.field_74357_r = p_74304_2_;
/* 423 */       this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
/*     */     } 
/* 425 */     if (p_74304_1_ == Options.CHAT_HEIGHT_FOCUSED) {
/* 426 */       this.field_96694_H = p_74304_2_;
/* 427 */       this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
/*     */     } 
/* 429 */     if (p_74304_1_ == Options.CHAT_HEIGHT_UNFOCUSED) {
/* 430 */       this.field_96693_G = p_74304_2_;
/* 431 */       this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
/*     */     } 
/* 433 */     if (p_74304_1_ == Options.CHAT_WIDTH) {
/* 434 */       this.field_96692_F = p_74304_2_;
/* 435 */       this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
/*     */     } 
/* 437 */     if (p_74304_1_ == Options.CHAT_SCALE) {
/* 438 */       this.field_96691_E = p_74304_2_;
/* 439 */       this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
/*     */     } 
/* 441 */     if (p_74304_1_ == Options.ANISOTROPIC_FILTERING) {
/* 442 */       int i = this.field_151443_J;
/* 443 */       this.field_151443_J = (int)p_74304_2_;
/* 444 */       if (i != p_74304_2_) {
/* 445 */         this.field_74317_L.func_147117_R().func_147632_b(this.field_151443_J);
/* 446 */         this.field_74317_L.func_147106_B();
/*     */       } 
/*     */     } 
/* 449 */     if (p_74304_1_ == Options.MIPMAP_LEVELS) {
/* 450 */       int i = this.field_151442_I;
/* 451 */       this.field_151442_I = (int)p_74304_2_;
/* 452 */       if (i != p_74304_2_) {
/* 453 */         this.field_74317_L.func_147117_R().func_147633_a(this.field_151442_I);
/* 454 */         this.field_74317_L.func_147106_B();
/*     */       } 
/*     */     } 
/* 457 */     if (p_74304_1_ == Options.RENDER_DISTANCE) {
/* 458 */       this.field_151451_c = (int)p_74304_2_;
/*     */     }
/* 460 */     if (p_74304_1_ == Options.STREAM_BYTES_PER_PIXEL) {
/* 461 */       this.field_152400_J = p_74304_2_;
/*     */     }
/* 463 */     if (p_74304_1_ == Options.STREAM_VOLUME_MIC) {
/* 464 */       this.field_152401_K = p_74304_2_;
/* 465 */       this.field_74317_L.func_152346_Z().func_152915_s();
/*     */     } 
/* 467 */     if (p_74304_1_ == Options.STREAM_VOLUME_SYSTEM) {
/* 468 */       this.field_152402_L = p_74304_2_;
/* 469 */       this.field_74317_L.func_152346_Z().func_152915_s();
/*     */     } 
/* 471 */     if (p_74304_1_ == Options.STREAM_KBPS) {
/* 472 */       this.field_152403_M = p_74304_2_;
/*     */     }
/* 474 */     if (p_74304_1_ == Options.STREAM_FPS) {
/* 475 */       this.field_152404_N = p_74304_2_;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_74306_a(Options p_74306_1_, int p_74306_2_) {
/* 480 */     if (p_74306_1_ == Options.INVERT_MOUSE) this.field_74338_d = !this.field_74338_d; 
/* 481 */     if (p_74306_1_ == Options.GUI_SCALE) this.field_74335_Z = this.field_74335_Z + p_74306_2_ & 0x3; 
/* 482 */     if (p_74306_1_ == Options.PARTICLES) this.field_74362_aa = (this.field_74362_aa + p_74306_2_) % 3; 
/* 483 */     if (p_74306_1_ == Options.VIEW_BOBBING) this.field_74336_f = !this.field_74336_f; 
/* 484 */     if (p_74306_1_ == Options.RENDER_CLOUDS) this.field_74345_l = !this.field_74345_l; 
/* 485 */     if (p_74306_1_ == Options.FORCE_UNICODE_FONT) {
/* 486 */       this.field_151455_aw = !this.field_151455_aw;
/* 487 */       this.field_74317_L.field_71466_p.func_78264_a((this.field_74317_L.func_135016_M().func_135042_a() || this.field_151455_aw));
/*     */     } 
/* 489 */     if (p_74306_1_ == Options.ADVANCED_OPENGL) {
/* 490 */       this.field_74349_h = !this.field_74349_h;
/* 491 */       this.field_74317_L.field_71438_f.func_72712_a();
/*     */     } 
/* 493 */     if (p_74306_1_ == Options.FBO_ENABLE) {
/* 494 */       this.field_151448_g = !this.field_151448_g;
/*     */     }
/* 496 */     if (p_74306_1_ == Options.ANAGLYPH) {
/* 497 */       this.field_74337_g = !this.field_74337_g;
/* 498 */       this.field_74317_L.func_110436_a();
/*     */     } 
/* 500 */     if (p_74306_1_ == Options.DIFFICULTY) this.field_74318_M = EnumDifficulty.func_151523_a(this.field_74318_M.func_151525_a() + p_74306_2_ & 0x3); 
/* 501 */     if (p_74306_1_ == Options.GRAPHICS) {
/* 502 */       this.field_74347_j = !this.field_74347_j;
/* 503 */       this.field_74317_L.field_71438_f.func_72712_a();
/*     */     } 
/* 505 */     if (p_74306_1_ == Options.AMBIENT_OCCLUSION) {
/* 506 */       this.field_74348_k = (this.field_74348_k + p_74306_2_) % 3;
/* 507 */       this.field_74317_L.field_71438_f.func_72712_a();
/*     */     } 
/* 509 */     if (p_74306_1_ == Options.CHAT_VISIBILITY) this.field_74343_n = EntityPlayer.EnumChatVisibility.func_151426_a((this.field_74343_n.func_151428_a() + p_74306_2_) % 3); 
/* 510 */     if (p_74306_1_ == Options.STREAM_COMPRESSION) this.field_152405_O = (this.field_152405_O + p_74306_2_) % 3; 
/* 511 */     if (p_74306_1_ == Options.STREAM_SEND_METADATA) this.field_152406_P = !this.field_152406_P; 
/* 512 */     if (p_74306_1_ == Options.STREAM_CHAT_ENABLED) this.field_152408_R = (this.field_152408_R + p_74306_2_) % 3; 
/* 513 */     if (p_74306_1_ == Options.STREAM_CHAT_USER_FILTER) this.field_152409_S = (this.field_152409_S + p_74306_2_) % 3; 
/* 514 */     if (p_74306_1_ == Options.STREAM_MIC_TOGGLE_BEHAVIOR) this.field_152410_T = (this.field_152410_T + p_74306_2_) % 2; 
/* 515 */     if (p_74306_1_ == Options.CHAT_COLOR) this.field_74344_o = !this.field_74344_o; 
/* 516 */     if (p_74306_1_ == Options.CHAT_LINKS) this.field_74359_p = !this.field_74359_p; 
/* 517 */     if (p_74306_1_ == Options.CHAT_LINKS_PROMPT) this.field_74358_q = !this.field_74358_q; 
/* 518 */     if (p_74306_1_ == Options.SNOOPER_ENABLED) this.field_74355_t = !this.field_74355_t; 
/* 519 */     if (p_74306_1_ == Options.SHOW_CAPE) this.field_82880_z = !this.field_82880_z; 
/* 520 */     if (p_74306_1_ == Options.TOUCHSCREEN) this.field_85185_A = !this.field_85185_A; 
/* 521 */     if (p_74306_1_ == Options.USE_FULLSCREEN) {
/* 522 */       this.field_74353_u = !this.field_74353_u;
/* 523 */       if (this.field_74317_L.func_71372_G() != this.field_74353_u) this.field_74317_L.func_71352_k(); 
/*     */     } 
/* 525 */     if (p_74306_1_ == Options.ENABLE_VSYNC) {
/* 526 */       this.field_74352_v = !this.field_74352_v;
/* 527 */       Display.setVSyncEnabled(this.field_74352_v);
/*     */     } 
/* 529 */     func_74303_b();
/*     */   }
/*     */   
/*     */   public float func_74296_a(Options p_74296_1_) {
/* 533 */     if (p_74296_1_ == Options.FOV) return this.field_74334_X; 
/* 534 */     if (p_74296_1_ == Options.GAMMA) return this.field_74333_Y; 
/* 535 */     if (p_74296_1_ == Options.SATURATION) return this.field_151452_as; 
/* 536 */     if (p_74296_1_ == Options.SENSITIVITY) return this.field_74341_c; 
/* 537 */     if (p_74296_1_ == Options.CHAT_OPACITY) return this.field_74357_r; 
/* 538 */     if (p_74296_1_ == Options.CHAT_HEIGHT_FOCUSED) return this.field_96694_H; 
/* 539 */     if (p_74296_1_ == Options.CHAT_HEIGHT_UNFOCUSED) return this.field_96693_G; 
/* 540 */     if (p_74296_1_ == Options.CHAT_SCALE) return this.field_96691_E; 
/* 541 */     if (p_74296_1_ == Options.CHAT_WIDTH) return this.field_96692_F; 
/* 542 */     if (p_74296_1_ == Options.FRAMERATE_LIMIT) return this.field_74350_i; 
/* 543 */     if (p_74296_1_ == Options.ANISOTROPIC_FILTERING) return this.field_151443_J; 
/* 544 */     if (p_74296_1_ == Options.MIPMAP_LEVELS) return this.field_151442_I; 
/* 545 */     if (p_74296_1_ == Options.RENDER_DISTANCE) return this.field_151451_c; 
/* 546 */     if (p_74296_1_ == Options.STREAM_BYTES_PER_PIXEL) return this.field_152400_J; 
/* 547 */     if (p_74296_1_ == Options.STREAM_VOLUME_MIC) return this.field_152401_K; 
/* 548 */     if (p_74296_1_ == Options.STREAM_VOLUME_SYSTEM) return this.field_152402_L; 
/* 549 */     if (p_74296_1_ == Options.STREAM_KBPS) return this.field_152403_M; 
/* 550 */     if (p_74296_1_ == Options.STREAM_FPS) return this.field_152404_N; 
/* 551 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public boolean func_74308_b(Options p_74308_1_) {
/* 555 */     switch (SwitchOptions.field_151477_a[p_74308_1_.ordinal()]) {
/*     */       case 1:
/* 557 */         return this.field_74338_d;
/*     */       case 2:
/* 559 */         return this.field_74336_f;
/*     */       case 3:
/* 561 */         return this.field_74337_g;
/*     */       case 4:
/* 563 */         return this.field_74349_h;
/*     */       case 5:
/* 565 */         return this.field_151448_g;
/*     */       case 6:
/* 567 */         return this.field_74345_l;
/*     */       case 7:
/* 569 */         return this.field_74344_o;
/*     */       case 8:
/* 571 */         return this.field_74359_p;
/*     */       case 9:
/* 573 */         return this.field_74358_q;
/*     */       case 10:
/* 575 */         return this.field_74355_t;
/*     */       case 11:
/* 577 */         return this.field_74353_u;
/*     */       case 12:
/* 579 */         return this.field_74352_v;
/*     */       case 13:
/* 581 */         return this.field_82880_z;
/*     */       case 14:
/* 583 */         return this.field_85185_A;
/*     */       case 15:
/* 585 */         return this.field_152406_P;
/*     */       case 16:
/* 587 */         return this.field_151455_aw;
/*     */     } 
/* 589 */     return false;
/*     */   }
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
/*     */   private static String func_74299_a(String[] p_74299_0_, int p_74299_1_) {
/* 603 */     if (p_74299_1_ < 0 || p_74299_1_ >= p_74299_0_.length) {
/* 604 */       p_74299_1_ = 0;
/*     */     }
/*     */     
/* 607 */     return I18n.func_135052_a(p_74299_0_[p_74299_1_], new Object[0]);
/*     */   }
/*     */   
/*     */   public String func_74297_c(Options p_74297_1_) {
/* 611 */     String str = I18n.func_135052_a(p_74297_1_.func_74378_d(), new Object[0]) + ": ";
/*     */     
/* 613 */     if (p_74297_1_.func_74380_a()) {
/* 614 */       float f1 = func_74296_a(p_74297_1_);
/* 615 */       float f2 = p_74297_1_.func_148266_c(f1);
/*     */       
/* 617 */       if (p_74297_1_ == Options.SENSITIVITY) {
/* 618 */         if (f2 == 0.0F) {
/* 619 */           return str + I18n.func_135052_a("options.sensitivity.min", new Object[0]);
/*     */         }
/* 621 */         if (f2 == 1.0F) {
/* 622 */           return str + I18n.func_135052_a("options.sensitivity.max", new Object[0]);
/*     */         }
/* 624 */         return str + (int)(f2 * 200.0F) + "%";
/* 625 */       }  if (p_74297_1_ == Options.FOV) {
/* 626 */         if (f1 == 70.0F) {
/* 627 */           return str + I18n.func_135052_a("options.fov.min", new Object[0]);
/*     */         }
/* 629 */         if (f1 == 110.0F) {
/* 630 */           return str + I18n.func_135052_a("options.fov.max", new Object[0]);
/*     */         }
/* 632 */         return str + (int)f1;
/* 633 */       }  if (p_74297_1_ == Options.FRAMERATE_LIMIT) {
/* 634 */         if (f1 == p_74297_1_.field_148272_O) {
/* 635 */           return str + I18n.func_135052_a("options.framerateLimit.max", new Object[0]);
/*     */         }
/* 637 */         return str + (int)f1 + " fps";
/*     */       } 
/* 639 */       if (p_74297_1_ == Options.GAMMA) {
/* 640 */         if (f2 == 0.0F) {
/* 641 */           return str + I18n.func_135052_a("options.gamma.min", new Object[0]);
/*     */         }
/* 643 */         if (f2 == 1.0F) {
/* 644 */           return str + I18n.func_135052_a("options.gamma.max", new Object[0]);
/*     */         }
/* 646 */         return str + "+" + (int)(f2 * 100.0F) + "%";
/* 647 */       }  if (p_74297_1_ == Options.SATURATION)
/* 648 */         return str + (int)(f2 * 400.0F) + "%"; 
/* 649 */       if (p_74297_1_ == Options.CHAT_OPACITY)
/* 650 */         return str + (int)(f2 * 90.0F + 10.0F) + "%"; 
/* 651 */       if (p_74297_1_ == Options.CHAT_HEIGHT_UNFOCUSED)
/* 652 */         return str + GuiNewChat.func_146243_b(f2) + "px"; 
/* 653 */       if (p_74297_1_ == Options.CHAT_HEIGHT_FOCUSED)
/* 654 */         return str + GuiNewChat.func_146243_b(f2) + "px"; 
/* 655 */       if (p_74297_1_ == Options.CHAT_WIDTH)
/* 656 */         return str + GuiNewChat.func_146233_a(f2) + "px"; 
/* 657 */       if (p_74297_1_ == Options.RENDER_DISTANCE)
/* 658 */         return str + (int)f1 + " chunks"; 
/* 659 */       if (p_74297_1_ == Options.ANISOTROPIC_FILTERING) {
/* 660 */         if (f1 == 1.0F) {
/* 661 */           return str + I18n.func_135052_a("options.off", new Object[0]);
/*     */         }
/* 663 */         return str + (int)f1;
/* 664 */       }  if (p_74297_1_ == Options.MIPMAP_LEVELS) {
/* 665 */         if (f1 == 0.0F) {
/* 666 */           return str + I18n.func_135052_a("options.off", new Object[0]);
/*     */         }
/* 668 */         return str + (int)f1;
/* 669 */       }  if (p_74297_1_ == Options.STREAM_FPS)
/* 670 */         return str + TwitchStream.func_152948_a(f2) + " fps"; 
/* 671 */       if (p_74297_1_ == Options.STREAM_KBPS)
/* 672 */         return str + TwitchStream.func_152946_b(f2) + " Kbps"; 
/* 673 */       if (p_74297_1_ == Options.STREAM_BYTES_PER_PIXEL) {
/* 674 */         return str + String.format("%.3f bpp", new Object[] { Float.valueOf(TwitchStream.func_152947_c(f2)) });
/*     */       }
/* 676 */       if (f2 == 0.0F) {
/* 677 */         return str + I18n.func_135052_a("options.off", new Object[0]);
/*     */       }
/* 679 */       return str + (int)(f2 * 100.0F) + "%";
/*     */     } 
/* 681 */     if (p_74297_1_.func_74382_b()) {
/* 682 */       boolean bool = func_74308_b(p_74297_1_);
/* 683 */       if (bool) {
/* 684 */         return str + I18n.func_135052_a("options.on", new Object[0]);
/*     */       }
/* 686 */       return str + I18n.func_135052_a("options.off", new Object[0]);
/* 687 */     }  if (p_74297_1_ == Options.DIFFICULTY)
/* 688 */       return str + I18n.func_135052_a(this.field_74318_M.func_151526_b(), new Object[0]); 
/* 689 */     if (p_74297_1_ == Options.GUI_SCALE)
/* 690 */       return str + func_74299_a(field_74367_ae, this.field_74335_Z); 
/* 691 */     if (p_74297_1_ == Options.CHAT_VISIBILITY)
/* 692 */       return str + I18n.func_135052_a(this.field_74343_n.func_151429_b(), new Object[0]); 
/* 693 */     if (p_74297_1_ == Options.PARTICLES)
/* 694 */       return str + func_74299_a(field_74364_ag, this.field_74362_aa); 
/* 695 */     if (p_74297_1_ == Options.AMBIENT_OCCLUSION)
/* 696 */       return str + func_74299_a(field_98303_au, this.field_74348_k); 
/* 697 */     if (p_74297_1_ == Options.STREAM_COMPRESSION)
/* 698 */       return str + func_74299_a(field_152391_aS, this.field_152405_O); 
/* 699 */     if (p_74297_1_ == Options.STREAM_CHAT_ENABLED)
/* 700 */       return str + func_74299_a(field_152392_aT, this.field_152408_R); 
/* 701 */     if (p_74297_1_ == Options.STREAM_CHAT_USER_FILTER)
/* 702 */       return str + func_74299_a(field_152393_aU, this.field_152409_S); 
/* 703 */     if (p_74297_1_ == Options.STREAM_MIC_TOGGLE_BEHAVIOR)
/* 704 */       return str + func_74299_a(field_152394_aV, this.field_152410_T); 
/* 705 */     if (p_74297_1_ == Options.GRAPHICS) {
/* 706 */       if (this.field_74347_j) {
/* 707 */         return str + I18n.func_135052_a("options.graphics.fancy", new Object[0]);
/*     */       }
/* 709 */       String str1 = "options.graphics.fast";
/* 710 */       return str + I18n.func_135052_a("options.graphics.fast", new Object[0]);
/*     */     } 
/*     */     
/* 713 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_74300_a() {
/*     */     try {
/* 719 */       if (!this.field_74354_ai.exists())
/* 720 */         return;  BufferedReader bufferedReader = new BufferedReader(new FileReader(this.field_74354_ai));
/* 721 */       String str = "";
/* 722 */       this.field_151446_aD.clear();
/* 723 */       while ((str = bufferedReader.readLine()) != null) {
/*     */         try {
/* 725 */           String[] arrayOfString = str.split(":");
/* 726 */           if (arrayOfString[0].equals("mouseSensitivity")) this.field_74341_c = func_74305_a(arrayOfString[1]); 
/* 727 */           if (arrayOfString[0].equals("invertYMouse")) this.field_74338_d = arrayOfString[1].equals("true"); 
/* 728 */           if (arrayOfString[0].equals("fov")) this.field_74334_X = func_74305_a(arrayOfString[1]); 
/* 729 */           if (arrayOfString[0].equals("gamma")) this.field_74333_Y = func_74305_a(arrayOfString[1]); 
/* 730 */           if (arrayOfString[0].equals("saturation")) this.field_151452_as = func_74305_a(arrayOfString[1]); 
/* 731 */           if (arrayOfString[0].equals("fov")) this.field_74334_X = func_74305_a(arrayOfString[1]) * 40.0F + 70.0F; 
/* 732 */           if (arrayOfString[0].equals("renderDistance")) this.field_151451_c = Integer.parseInt(arrayOfString[1]); 
/* 733 */           if (arrayOfString[0].equals("guiScale")) this.field_74335_Z = Integer.parseInt(arrayOfString[1]); 
/* 734 */           if (arrayOfString[0].equals("particles")) this.field_74362_aa = Integer.parseInt(arrayOfString[1]); 
/* 735 */           if (arrayOfString[0].equals("bobView")) this.field_74336_f = arrayOfString[1].equals("true"); 
/* 736 */           if (arrayOfString[0].equals("anaglyph3d")) this.field_74337_g = arrayOfString[1].equals("true"); 
/* 737 */           if (arrayOfString[0].equals("advancedOpengl")) this.field_74349_h = arrayOfString[1].equals("true"); 
/* 738 */           if (arrayOfString[0].equals("maxFps")) this.field_74350_i = Integer.parseInt(arrayOfString[1]); 
/* 739 */           if (arrayOfString[0].equals("fboEnable")) this.field_151448_g = arrayOfString[1].equals("true"); 
/* 740 */           if (arrayOfString[0].equals("difficulty")) this.field_74318_M = EnumDifficulty.func_151523_a(Integer.parseInt(arrayOfString[1])); 
/* 741 */           if (arrayOfString[0].equals("fancyGraphics")) this.field_74347_j = arrayOfString[1].equals("true"); 
/* 742 */           if (arrayOfString[0].equals("ao")) {
/* 743 */             if (arrayOfString[1].equals("true")) {
/* 744 */               this.field_74348_k = 2;
/* 745 */             } else if (arrayOfString[1].equals("false")) {
/* 746 */               this.field_74348_k = 0;
/*     */             } else {
/* 748 */               this.field_74348_k = Integer.parseInt(arrayOfString[1]);
/*     */             } 
/*     */           }
/* 751 */           if (arrayOfString[0].equals("clouds")) this.field_74345_l = arrayOfString[1].equals("true"); 
/* 752 */           if (arrayOfString[0].equals("resourcePacks")) {
/* 753 */             this.field_151453_l = (List)field_151450_ay.fromJson(str.substring(str.indexOf(':') + 1), field_151449_az);
/* 754 */             if (this.field_151453_l == null) this.field_151453_l = new ArrayList(); 
/*     */           } 
/* 756 */           if (arrayOfString[0].equals("lastServer") && arrayOfString.length >= 2) this.field_74332_R = str.substring(str.indexOf(':') + 1); 
/* 757 */           if (arrayOfString[0].equals("lang") && arrayOfString.length >= 2) this.field_74363_ab = arrayOfString[1]; 
/* 758 */           if (arrayOfString[0].equals("chatVisibility")) this.field_74343_n = EntityPlayer.EnumChatVisibility.func_151426_a(Integer.parseInt(arrayOfString[1])); 
/* 759 */           if (arrayOfString[0].equals("chatColors")) this.field_74344_o = arrayOfString[1].equals("true"); 
/* 760 */           if (arrayOfString[0].equals("chatLinks")) this.field_74359_p = arrayOfString[1].equals("true"); 
/* 761 */           if (arrayOfString[0].equals("chatLinksPrompt")) this.field_74358_q = arrayOfString[1].equals("true"); 
/* 762 */           if (arrayOfString[0].equals("chatOpacity")) this.field_74357_r = func_74305_a(arrayOfString[1]); 
/* 763 */           if (arrayOfString[0].equals("snooperEnabled")) this.field_74355_t = arrayOfString[1].equals("true"); 
/* 764 */           if (arrayOfString[0].equals("fullscreen")) this.field_74353_u = arrayOfString[1].equals("true"); 
/* 765 */           if (arrayOfString[0].equals("enableVsync")) this.field_74352_v = arrayOfString[1].equals("true"); 
/* 766 */           if (arrayOfString[0].equals("hideServerAddress")) this.field_80005_w = arrayOfString[1].equals("true"); 
/* 767 */           if (arrayOfString[0].equals("advancedItemTooltips")) this.field_82882_x = arrayOfString[1].equals("true"); 
/* 768 */           if (arrayOfString[0].equals("pauseOnLostFocus")) this.field_82881_y = arrayOfString[1].equals("true"); 
/* 769 */           if (arrayOfString[0].equals("showCape")) this.field_82880_z = arrayOfString[1].equals("true"); 
/* 770 */           if (arrayOfString[0].equals("touchscreen")) this.field_85185_A = arrayOfString[1].equals("true"); 
/* 771 */           if (arrayOfString[0].equals("overrideHeight")) this.field_92119_C = Integer.parseInt(arrayOfString[1]); 
/* 772 */           if (arrayOfString[0].equals("overrideWidth")) this.field_92118_B = Integer.parseInt(arrayOfString[1]); 
/* 773 */           if (arrayOfString[0].equals("heldItemTooltips")) this.field_92117_D = arrayOfString[1].equals("true"); 
/* 774 */           if (arrayOfString[0].equals("chatHeightFocused")) this.field_96694_H = func_74305_a(arrayOfString[1]); 
/* 775 */           if (arrayOfString[0].equals("chatHeightUnfocused")) this.field_96693_G = func_74305_a(arrayOfString[1]); 
/* 776 */           if (arrayOfString[0].equals("chatScale")) this.field_96691_E = func_74305_a(arrayOfString[1]); 
/* 777 */           if (arrayOfString[0].equals("chatWidth")) this.field_96692_F = func_74305_a(arrayOfString[1]); 
/* 778 */           if (arrayOfString[0].equals("showInventoryAchievementHint")) this.field_151441_H = arrayOfString[1].equals("true"); 
/* 779 */           if (arrayOfString[0].equals("mipmapLevels")) this.field_151442_I = Integer.parseInt(arrayOfString[1]); 
/* 780 */           if (arrayOfString[0].equals("anisotropicFiltering")) this.field_151443_J = Integer.parseInt(arrayOfString[1]); 
/* 781 */           if (arrayOfString[0].equals("streamBytesPerPixel")) this.field_152400_J = func_74305_a(arrayOfString[1]); 
/* 782 */           if (arrayOfString[0].equals("streamMicVolume")) this.field_152401_K = func_74305_a(arrayOfString[1]); 
/* 783 */           if (arrayOfString[0].equals("streamSystemVolume")) this.field_152402_L = func_74305_a(arrayOfString[1]); 
/* 784 */           if (arrayOfString[0].equals("streamKbps")) this.field_152403_M = func_74305_a(arrayOfString[1]); 
/* 785 */           if (arrayOfString[0].equals("streamFps")) this.field_152404_N = func_74305_a(arrayOfString[1]); 
/* 786 */           if (arrayOfString[0].equals("streamCompression")) this.field_152405_O = Integer.parseInt(arrayOfString[1]); 
/* 787 */           if (arrayOfString[0].equals("streamSendMetadata")) this.field_152406_P = arrayOfString[1].equals("true"); 
/* 788 */           if (arrayOfString[0].equals("streamPreferredServer") && arrayOfString.length >= 2) this.field_152407_Q = str.substring(str.indexOf(':') + 1); 
/* 789 */           if (arrayOfString[0].equals("streamChatEnabled")) this.field_152408_R = Integer.parseInt(arrayOfString[1]); 
/* 790 */           if (arrayOfString[0].equals("streamChatUserFilter")) this.field_152409_S = Integer.parseInt(arrayOfString[1]); 
/* 791 */           if (arrayOfString[0].equals("streamMicToggleBehavior")) this.field_152410_T = Integer.parseInt(arrayOfString[1]); 
/* 792 */           if (arrayOfString[0].equals("forceUnicodeFont")) this.field_151455_aw = arrayOfString[1].equals("true");
/*     */           
/* 794 */           for (KeyBinding keyBinding : this.field_74324_K) {
/* 795 */             if (arrayOfString[0].equals("key_" + keyBinding.func_151464_g())) {
/* 796 */               keyBinding.func_151462_b(Integer.parseInt(arrayOfString[1]));
/*     */             }
/*     */           } 
/*     */           
/* 800 */           for (SoundCategory soundCategory : SoundCategory.values()) {
/* 801 */             if (arrayOfString[0].equals("soundCategory_" + soundCategory.func_147155_a())) {
/* 802 */               this.field_151446_aD.put(soundCategory, Float.valueOf(func_74305_a(arrayOfString[1])));
/*     */             }
/*     */           } 
/* 805 */         } catch (Exception exception) {
/* 806 */           field_151454_ax.warn("Skipping bad option: " + str);
/*     */         } 
/*     */       } 
/* 809 */       KeyBinding.func_74508_b();
/* 810 */       bufferedReader.close();
/* 811 */     } catch (Exception exception) {
/* 812 */       field_151454_ax.error("Failed to load options", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private float func_74305_a(String p_74305_1_) {
/* 817 */     if (p_74305_1_.equals("true")) return 1.0F; 
/* 818 */     if (p_74305_1_.equals("false")) return 0.0F; 
/* 819 */     return Float.parseFloat(p_74305_1_);
/*     */   }
/*     */   
/*     */   public void func_74303_b() {
/*     */     try {
/* 824 */       PrintWriter printWriter = new PrintWriter(new FileWriter(this.field_74354_ai));
/*     */       
/* 826 */       printWriter.println("invertYMouse:" + this.field_74338_d);
/* 827 */       printWriter.println("mouseSensitivity:" + this.field_74341_c);
/* 828 */       printWriter.println("fov:" + ((this.field_74334_X - 70.0F) / 40.0F));
/* 829 */       printWriter.println("gamma:" + this.field_74333_Y);
/* 830 */       printWriter.println("saturation:" + this.field_151452_as);
/* 831 */       printWriter.println("renderDistance:" + this.field_151451_c);
/* 832 */       printWriter.println("guiScale:" + this.field_74335_Z);
/* 833 */       printWriter.println("particles:" + this.field_74362_aa);
/* 834 */       printWriter.println("bobView:" + this.field_74336_f);
/* 835 */       printWriter.println("anaglyph3d:" + this.field_74337_g);
/* 836 */       printWriter.println("advancedOpengl:" + this.field_74349_h);
/* 837 */       printWriter.println("maxFps:" + this.field_74350_i);
/* 838 */       printWriter.println("fboEnable:" + this.field_151448_g);
/* 839 */       printWriter.println("difficulty:" + this.field_74318_M.func_151525_a());
/* 840 */       printWriter.println("fancyGraphics:" + this.field_74347_j);
/* 841 */       printWriter.println("ao:" + this.field_74348_k);
/* 842 */       printWriter.println("clouds:" + this.field_74345_l);
/* 843 */       printWriter.println("resourcePacks:" + field_151450_ay.toJson(this.field_151453_l));
/* 844 */       printWriter.println("lastServer:" + this.field_74332_R);
/* 845 */       printWriter.println("lang:" + this.field_74363_ab);
/* 846 */       printWriter.println("chatVisibility:" + this.field_74343_n.func_151428_a());
/* 847 */       printWriter.println("chatColors:" + this.field_74344_o);
/* 848 */       printWriter.println("chatLinks:" + this.field_74359_p);
/* 849 */       printWriter.println("chatLinksPrompt:" + this.field_74358_q);
/* 850 */       printWriter.println("chatOpacity:" + this.field_74357_r);
/* 851 */       printWriter.println("snooperEnabled:" + this.field_74355_t);
/* 852 */       printWriter.println("fullscreen:" + this.field_74353_u);
/* 853 */       printWriter.println("enableVsync:" + this.field_74352_v);
/* 854 */       printWriter.println("hideServerAddress:" + this.field_80005_w);
/* 855 */       printWriter.println("advancedItemTooltips:" + this.field_82882_x);
/* 856 */       printWriter.println("pauseOnLostFocus:" + this.field_82881_y);
/* 857 */       printWriter.println("showCape:" + this.field_82880_z);
/* 858 */       printWriter.println("touchscreen:" + this.field_85185_A);
/* 859 */       printWriter.println("overrideWidth:" + this.field_92118_B);
/* 860 */       printWriter.println("overrideHeight:" + this.field_92119_C);
/* 861 */       printWriter.println("heldItemTooltips:" + this.field_92117_D);
/* 862 */       printWriter.println("chatHeightFocused:" + this.field_96694_H);
/* 863 */       printWriter.println("chatHeightUnfocused:" + this.field_96693_G);
/* 864 */       printWriter.println("chatScale:" + this.field_96691_E);
/* 865 */       printWriter.println("chatWidth:" + this.field_96692_F);
/* 866 */       printWriter.println("showInventoryAchievementHint:" + this.field_151441_H);
/* 867 */       printWriter.println("mipmapLevels:" + this.field_151442_I);
/* 868 */       printWriter.println("anisotropicFiltering:" + this.field_151443_J);
/* 869 */       printWriter.println("streamBytesPerPixel:" + this.field_152400_J);
/* 870 */       printWriter.println("streamMicVolume:" + this.field_152401_K);
/* 871 */       printWriter.println("streamSystemVolume:" + this.field_152402_L);
/* 872 */       printWriter.println("streamKbps:" + this.field_152403_M);
/* 873 */       printWriter.println("streamFps:" + this.field_152404_N);
/* 874 */       printWriter.println("streamCompression:" + this.field_152405_O);
/* 875 */       printWriter.println("streamSendMetadata:" + this.field_152406_P);
/* 876 */       printWriter.println("streamPreferredServer:" + this.field_152407_Q);
/* 877 */       printWriter.println("streamChatEnabled:" + this.field_152408_R);
/* 878 */       printWriter.println("streamChatUserFilter:" + this.field_152409_S);
/* 879 */       printWriter.println("streamMicToggleBehavior:" + this.field_152410_T);
/* 880 */       printWriter.println("forceUnicodeFont:" + this.field_151455_aw);
/*     */       
/* 882 */       for (KeyBinding keyBinding : this.field_74324_K) {
/* 883 */         printWriter.println("key_" + keyBinding.func_151464_g() + ":" + keyBinding.func_151463_i());
/*     */       }
/*     */       
/* 886 */       for (SoundCategory soundCategory : SoundCategory.values()) {
/* 887 */         printWriter.println("soundCategory_" + soundCategory.func_147155_a() + ":" + func_151438_a(soundCategory));
/*     */       }
/*     */       
/* 890 */       printWriter.close();
/* 891 */     } catch (Exception exception) {
/* 892 */       field_151454_ax.error("Failed to save options", exception);
/*     */     } 
/*     */     
/* 895 */     func_82879_c();
/*     */   }
/*     */   
/*     */   public float func_151438_a(SoundCategory p_151438_1_) {
/* 899 */     if (this.field_151446_aD.containsKey(p_151438_1_)) {
/* 900 */       return ((Float)this.field_151446_aD.get(p_151438_1_)).floatValue();
/*     */     }
/*     */     
/* 903 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public void func_151439_a(SoundCategory p_151439_1_, float p_151439_2_) {
/* 907 */     this.field_74317_L.func_147118_V().func_147684_a(p_151439_1_, p_151439_2_);
/* 908 */     this.field_151446_aD.put(p_151439_1_, Float.valueOf(p_151439_2_));
/*     */   }
/*     */   
/*     */   public void func_82879_c() {
/* 912 */     if (this.field_74317_L.field_71439_g != null) {
/* 913 */       this.field_74317_L.field_71439_g.field_71174_a.func_147297_a((Packet)new C15PacketClientSettings(this.field_74363_ab, this.field_151451_c, this.field_74343_n, this.field_74344_o, this.field_74318_M, this.field_82880_z));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_74309_c() {
/* 918 */     return (this.field_151451_c >= 4 && this.field_74345_l);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\settings\GameSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */