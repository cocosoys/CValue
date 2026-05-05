/*     */ package net.minecraft.client.stream;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.HashSet;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.stream.GuiTwitchUserMode;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.event.ClickEvent;
/*     */ import net.minecraft.event.HoverEvent;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.HttpUtil;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.JsonUtils;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Util;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.apache.logging.log4j.core.helpers.Strings;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import tv.twitch.AuthToken;
/*     */ import tv.twitch.ErrorCode;
/*     */ import tv.twitch.broadcast.EncodingCpuUsage;
/*     */ import tv.twitch.broadcast.FrameBuffer;
/*     */ import tv.twitch.broadcast.IngestServer;
/*     */ import tv.twitch.broadcast.StreamInfo;
/*     */ import tv.twitch.broadcast.VideoParams;
/*     */ import tv.twitch.chat.ChatMessage;
/*     */ import tv.twitch.chat.ChatUserInfo;
/*     */ import tv.twitch.chat.ChatUserMode;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TwitchStream implements BroadcastController.BroadcastListener, ChatController.ChatListener, IngestServerTester.IngestTestListener, IStream {
/*  42 */   private static final Logger field_152950_b = LogManager.getLogger();
/*  43 */   public static final Marker field_152949_a = MarkerManager.getMarker("STREAM");
/*     */   
/*     */   private final BroadcastController field_152951_c;
/*     */   
/*     */   private final ChatController field_152952_d;
/*     */   
/*     */   private final Minecraft field_152953_e;
/*     */   
/*  51 */   private final IChatComponent field_152954_f = (IChatComponent)new ChatComponentText("Twitch");
/*  52 */   private final Map field_152955_g = Maps.newHashMap();
/*     */   private Framebuffer field_152956_h;
/*     */   private boolean field_152957_i;
/*  55 */   private int field_152958_j = 30;
/*  56 */   private long field_152959_k = 0L;
/*     */   private boolean field_152960_l = false;
/*     */   private boolean field_152961_m;
/*     */   private boolean field_152962_n;
/*     */   private boolean field_152963_o;
/*  61 */   private IStream.AuthFailureReason field_152964_p = IStream.AuthFailureReason.ERROR; private static boolean field_152965_q; private static final String __OBFID = "CL_00001812";
/*     */   
/*     */   public TwitchStream(Minecraft p_i1012_1_, String p_i1012_2_) {
/*  64 */     this.field_152953_e = p_i1012_1_;
/*  65 */     this.field_152951_c = new BroadcastController();
/*  66 */     this.field_152952_d = new ChatController();
/*     */     
/*  68 */     this.field_152951_c.func_152841_a(this);
/*  69 */     this.field_152952_d.func_152990_a(this);
/*     */     
/*  71 */     this.field_152951_c.func_152842_a("nmt37qblda36pvonovdkbopzfzw3wlq");
/*  72 */     this.field_152952_d.func_152984_a("nmt37qblda36pvonovdkbopzfzw3wlq");
/*     */     
/*  74 */     this.field_152954_f.func_150256_b().func_150238_a(EnumChatFormatting.DARK_PURPLE);
/*     */     
/*  76 */     if (Strings.isNotEmpty(p_i1012_2_) && OpenGlHelper.field_148823_f) {
/*  77 */       Thread thread = new Thread(this, "Twitch authenticator", p_i1012_2_) { private static final String __OBFID = "CL_00001811";
/*     */           
/*     */           public void run() {
/*     */             try {
/*  81 */               URL uRL = new URL("https://api.twitch.tv/kraken?oauth_token=" + URLEncoder.encode(this.field_153083_a, "UTF-8"));
/*  82 */               String str = HttpUtil.func_152755_a(uRL);
/*  83 */               JsonObject jsonObject1 = JsonUtils.func_151210_l((new JsonParser()).parse(str), "Response");
/*  84 */               JsonObject jsonObject2 = JsonUtils.func_152754_s(jsonObject1, "token");
/*     */               
/*  86 */               if (JsonUtils.func_151212_i(jsonObject2, "valid")) {
/*  87 */                 String str1 = JsonUtils.func_151200_h(jsonObject2, "user_name");
/*  88 */                 TwitchStream.field_152950_b.debug(TwitchStream.field_152949_a, "Authenticated with twitch; username is {}", new Object[] { str1 });
/*  89 */                 AuthToken authToken = new AuthToken();
/*  90 */                 authToken.data = this.field_153083_a;
/*     */                 
/*  92 */                 this.field_153084_b.field_152951_c.func_152818_a(str1, authToken);
/*  93 */                 this.field_153084_b.field_152952_d.func_152998_c(str1);
/*  94 */                 this.field_153084_b.field_152952_d.func_152994_a(authToken);
/*     */                 
/*  96 */                 Runtime.getRuntime().addShutdownHook(new Thread(this, "Twitch shutdown hook") { private static final String __OBFID = "CL_00001810";
/*     */                       
/*     */                       public void run() {
/*  99 */                         this.field_153082_a.field_153084_b.func_152923_i();
/*     */                       } }
/*     */                   );
/* 102 */                 this.field_153084_b.field_152951_c.func_152817_A();
/*     */               } else {
/* 104 */                 this.field_153084_b.field_152964_p = IStream.AuthFailureReason.INVALID_TOKEN;
/* 105 */                 TwitchStream.field_152950_b.error(TwitchStream.field_152949_a, "Given twitch access token is invalid");
/*     */               } 
/* 107 */             } catch (IOException iOException) {
/* 108 */               this.field_153084_b.field_152964_p = IStream.AuthFailureReason.ERROR;
/* 109 */               TwitchStream.field_152950_b.error(TwitchStream.field_152949_a, "Could not authenticate with twitch", iOException);
/*     */             } 
/*     */           } }
/*     */         ;
/* 113 */       thread.setDaemon(true);
/* 114 */       thread.start();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/* 124 */       if (Util.func_110647_a() == Util.EnumOS.WINDOWS) {
/* 125 */         System.loadLibrary("avutil-ttv-51");
/* 126 */         System.loadLibrary("swresample-ttv-0");
/* 127 */         System.loadLibrary("libmp3lame-ttv");
/*     */         
/* 129 */         if (System.getProperty("os.arch").contains("64")) {
/* 130 */           System.loadLibrary("libmfxsw64");
/*     */         } else {
/* 132 */           System.loadLibrary("libmfxsw32");
/*     */         } 
/*     */       } 
/* 135 */       field_152965_q = true;
/* 136 */     } catch (Throwable throwable) {
/* 137 */       field_152965_q = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152923_i() {
/* 143 */     field_152950_b.debug(field_152949_a, "Shutdown streaming");
/* 144 */     this.field_152951_c.func_152851_B();
/* 145 */     this.field_152952_d.func_152993_m();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152935_j() {
/* 150 */     int i = this.field_152953_e.field_71474_y.field_152408_R;
/* 151 */     ChatController.ChatState chatState = this.field_152952_d.func_153000_j();
/*     */     
/* 153 */     if (i == 2) {
/* 154 */       if (chatState == ChatController.ChatState.Connected) {
/* 155 */         field_152950_b.debug(field_152949_a, "Disconnecting from twitch chat per user options");
/* 156 */         this.field_152952_d.func_153002_l();
/*     */       } 
/* 158 */     } else if (i == 1) {
/* 159 */       if ((chatState == ChatController.ChatState.Disconnected || chatState == ChatController.ChatState.Uninitialized) && this.field_152951_c.func_152849_q()) {
/* 160 */         field_152950_b.debug(field_152949_a, "Connecting to twitch chat per user options");
/* 161 */         func_152942_I();
/*     */       } 
/* 163 */     } else if (i == 0) {
/* 164 */       if ((chatState == ChatController.ChatState.Disconnected || chatState == ChatController.ChatState.Uninitialized) && func_152934_n()) {
/* 165 */         field_152950_b.debug(field_152949_a, "Connecting to twitch chat as user is streaming");
/* 166 */         func_152942_I();
/* 167 */       } else if (chatState == ChatController.ChatState.Connected && !func_152934_n()) {
/* 168 */         field_152950_b.debug(field_152949_a, "Disconnecting from twitch chat as user is no longer streaming");
/* 169 */         this.field_152952_d.func_153002_l();
/*     */       } 
/*     */     } 
/*     */     
/* 173 */     this.field_152951_c.func_152821_H();
/* 174 */     this.field_152952_d.func_152997_n();
/*     */   }
/*     */   
/*     */   protected void func_152942_I() {
/* 178 */     ChatController.ChatState chatState = this.field_152952_d.func_153000_j();
/* 179 */     String str = (this.field_152951_c.func_152843_l()).name;
/*     */     
/* 181 */     if (chatState == ChatController.ChatState.Uninitialized) {
/* 182 */       this.field_152952_d.func_152985_f(str);
/* 183 */       this.field_152952_d.field_153005_c = str;
/* 184 */     } else if (chatState == ChatController.ChatState.Disconnected) {
/* 185 */       this.field_152952_d.func_152986_d(str);
/*     */     } else {
/* 187 */       field_152950_b.warn("Invalid twitch chat state {}", new Object[] { chatState });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152922_k() {
/* 193 */     if (!this.field_152951_c.func_152850_m() || this.field_152951_c.func_152839_p()) {
/*     */       return;
/*     */     }
/*     */     
/* 197 */     long l1 = System.nanoTime();
/* 198 */     long l2 = (1000000000 / this.field_152958_j);
/*     */     
/* 200 */     long l3 = l1 - this.field_152959_k;
/* 201 */     boolean bool = (l3 >= l2) ? true : false;
/*     */     
/* 203 */     if (bool) {
/* 204 */       FrameBuffer frameBuffer = this.field_152951_c.func_152822_N();
/*     */       
/* 206 */       Framebuffer framebuffer = this.field_152953_e.func_147110_a();
/*     */       
/* 208 */       this.field_152956_h.func_147610_a(true);
/*     */       
/* 210 */       GL11.glMatrixMode(5889);
/* 211 */       GL11.glPushMatrix();
/* 212 */       GL11.glLoadIdentity();
/*     */       
/* 214 */       GL11.glOrtho(0.0D, this.field_152956_h.field_147621_c, this.field_152956_h.field_147618_d, 0.0D, 1000.0D, 3000.0D);
/* 215 */       GL11.glMatrixMode(5888);
/* 216 */       GL11.glPushMatrix();
/* 217 */       GL11.glLoadIdentity();
/*     */       
/* 219 */       GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
/* 220 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/* 222 */       GL11.glViewport(0, 0, this.field_152956_h.field_147621_c, this.field_152956_h.field_147618_d);
/*     */       
/* 224 */       GL11.glEnable(3553);
/* 225 */       GL11.glDisable(3008);
/* 226 */       GL11.glDisable(3042);
/*     */       
/* 228 */       float f1 = this.field_152956_h.field_147621_c;
/* 229 */       float f2 = this.field_152956_h.field_147618_d;
/* 230 */       float f3 = framebuffer.field_147621_c / framebuffer.field_147622_a;
/* 231 */       float f4 = framebuffer.field_147618_d / framebuffer.field_147620_b;
/*     */       
/* 233 */       framebuffer.func_147612_c();
/* 234 */       GL11.glTexParameterf(3553, 10241, 9729.0F);
/* 235 */       GL11.glTexParameterf(3553, 10240, 9729.0F);
/*     */       
/* 237 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 238 */       tessellator.func_78382_b();
/* 239 */       tessellator.func_78374_a(0.0D, f2, 0.0D, 0.0D, f4);
/* 240 */       tessellator.func_78374_a(f1, f2, 0.0D, f3, f4);
/* 241 */       tessellator.func_78374_a(f1, 0.0D, 0.0D, f3, 0.0D);
/* 242 */       tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 243 */       tessellator.func_78381_a();
/*     */       
/* 245 */       framebuffer.func_147606_d();
/*     */       
/* 247 */       GL11.glPopMatrix();
/* 248 */       GL11.glMatrixMode(5889);
/* 249 */       GL11.glPopMatrix();
/* 250 */       GL11.glMatrixMode(5888);
/*     */       
/* 252 */       this.field_152951_c.func_152846_a(frameBuffer);
/* 253 */       this.field_152956_h.func_147609_e();
/*     */       
/* 255 */       this.field_152951_c.func_152859_b(frameBuffer);
/* 256 */       this.field_152959_k = l1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152936_l() {
/* 262 */     return this.field_152951_c.func_152849_q();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152924_m() {
/* 267 */     return this.field_152951_c.func_152857_n();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152934_n() {
/* 272 */     return this.field_152951_c.func_152850_m();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152911_a(Metadata p_152911_1_, long p_152911_2_) {
/* 277 */     if (!func_152934_n() || !this.field_152957_i)
/* 278 */       return;  long l = this.field_152951_c.func_152844_x();
/*     */     
/* 280 */     if (!this.field_152951_c.func_152840_a(p_152911_1_.func_152810_c(), l + p_152911_2_, p_152911_1_.func_152809_a(), p_152911_1_.func_152806_b())) {
/* 281 */       field_152950_b.warn(field_152949_a, "Couldn't send stream metadata action at {}: {}", new Object[] { Long.valueOf(l + p_152911_2_), p_152911_1_ });
/*     */     } else {
/* 283 */       field_152950_b.debug(field_152949_a, "Sent stream metadata action at {}: {}", new Object[] { Long.valueOf(l + p_152911_2_), p_152911_1_ });
/*     */     } 
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
/*     */   public boolean func_152919_o() {
/* 308 */     return this.field_152951_c.func_152839_p();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152931_p() {
/* 313 */     if (this.field_152951_c.func_152830_D()) {
/* 314 */       field_152950_b.debug(field_152949_a, "Requested commercial from Twitch");
/*     */     } else {
/* 316 */       field_152950_b.warn(field_152949_a, "Could not request commercial from Twitch");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152916_q() {
/* 322 */     this.field_152951_c.func_152847_F();
/* 323 */     this.field_152962_n = true;
/*     */     
/* 325 */     func_152915_s();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152933_r() {
/* 330 */     this.field_152951_c.func_152854_G();
/* 331 */     this.field_152962_n = false;
/*     */     
/* 333 */     func_152915_s();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152915_s() {
/* 338 */     if (func_152934_n()) {
/* 339 */       float f = this.field_152953_e.field_71474_y.field_152402_L;
/* 340 */       boolean bool = (this.field_152962_n || f <= 0.0F) ? true : false;
/* 341 */       this.field_152951_c.func_152837_b(bool ? 0.0F : f);
/*     */       
/* 343 */       this.field_152951_c.func_152829_a(func_152929_G() ? 0.0F : this.field_152953_e.field_71474_y.field_152401_K);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152930_t() {
/* 349 */     GameSettings gameSettings = this.field_152953_e.field_71474_y;
/* 350 */     VideoParams videoParams = this.field_152951_c.func_152834_a(func_152946_b(gameSettings.field_152403_M), func_152948_a(gameSettings.field_152404_N), func_152947_c(gameSettings.field_152400_J), this.field_152953_e.field_71443_c / this.field_152953_e.field_71440_d);
/*     */     
/* 352 */     switch (gameSettings.field_152405_O) {
/*     */       case 2:
/* 354 */         videoParams.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
/*     */         break;
/*     */       case 1:
/* 357 */         videoParams.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_MEDIUM;
/*     */         break;
/*     */       case 0:
/* 360 */         videoParams.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_LOW;
/*     */         break;
/*     */     } 
/*     */     
/* 364 */     if (this.field_152956_h == null) {
/* 365 */       this.field_152956_h = new Framebuffer(videoParams.outputWidth, videoParams.outputHeight, false);
/*     */     } else {
/* 367 */       this.field_152956_h.func_147613_a(videoParams.outputWidth, videoParams.outputHeight);
/*     */     } 
/*     */     
/* 370 */     if (gameSettings.field_152407_Q != null && gameSettings.field_152407_Q.length() > 0) {
/* 371 */       for (IngestServer ingestServer : func_152925_v()) {
/* 372 */         if (ingestServer.serverUrl.equals(gameSettings.field_152407_Q)) {
/* 373 */           this.field_152951_c.func_152824_a(ingestServer);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 379 */     this.field_152958_j = videoParams.targetFps;
/* 380 */     this.field_152957_i = gameSettings.field_152406_P;
/* 381 */     this.field_152951_c.func_152836_a(videoParams);
/*     */     
/* 383 */     field_152950_b.info(field_152949_a, "Streaming at {}/{} at {} kbps to {}", new Object[] { Integer.valueOf(videoParams.outputWidth), Integer.valueOf(videoParams.outputHeight), Integer.valueOf(videoParams.maxKbps), (this.field_152951_c.func_152833_s()).serverUrl });
/* 384 */     this.field_152951_c.func_152828_a(null, "Minecraft", null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152914_u() {
/* 389 */     if (this.field_152951_c.func_152819_E()) {
/* 390 */       field_152950_b.info(field_152949_a, "Stopped streaming to Twitch");
/*     */     } else {
/* 392 */       field_152950_b.warn(field_152949_a, "Could not stop streaming to Twitch");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152900_a(ErrorCode p_152900_1_, AuthToken p_152900_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152897_a(ErrorCode p_152897_1_) {
/* 403 */     if (ErrorCode.succeeded(p_152897_1_)) {
/* 404 */       field_152950_b.debug(field_152949_a, "Login attempt successful");
/* 405 */       this.field_152961_m = true;
/*     */     } else {
/* 407 */       field_152950_b.warn(field_152949_a, "Login attempt unsuccessful: {} (error code {})", new Object[] { ErrorCode.getString(p_152897_1_), Integer.valueOf(p_152897_1_.getValue()) });
/* 408 */       this.field_152961_m = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152898_a(ErrorCode p_152898_1_, GameInfo[] p_152898_2_) {}
/*     */ 
/*     */   
/*     */   public void func_152891_a(BroadcastController.BroadcastState p_152891_1_) {
/* 418 */     field_152950_b.debug(field_152949_a, "Broadcast state changed to {}", new Object[] { p_152891_1_ });
/*     */     
/* 420 */     if (p_152891_1_ == BroadcastController.BroadcastState.Initialized) {
/* 421 */       this.field_152951_c.func_152827_a(BroadcastController.BroadcastState.Authenticated);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152895_a() {
/* 427 */     field_152950_b.info(field_152949_a, "Logged out of twitch");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152894_a(StreamInfo p_152894_1_) {
/* 432 */     field_152950_b.debug(field_152949_a, "Stream info updated; {} viewers on stream ID {}", new Object[] { Integer.valueOf(p_152894_1_.viewers), Long.valueOf(p_152894_1_.streamId) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152896_a(IngestList p_152896_1_) {}
/*     */ 
/*     */   
/*     */   public void func_152893_b(ErrorCode p_152893_1_) {
/* 441 */     field_152950_b.warn(field_152949_a, "Issue submitting frame: {} (Error code {})", new Object[] { ErrorCode.getString(p_152893_1_), Integer.valueOf(p_152893_1_.getValue()) });
/* 442 */     this.field_152953_e.field_71456_v.func_146158_b().func_146234_a((IChatComponent)new ChatComponentText("Issue streaming frame: " + p_152893_1_ + " (" + ErrorCode.getString(p_152893_1_) + ")"), 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152899_b() {
/* 447 */     func_152915_s();
/* 448 */     field_152950_b.info(field_152949_a, "Broadcast to Twitch has started");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152901_c() {
/* 453 */     field_152950_b.info(field_152949_a, "Broadcast to Twitch has stopped");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152892_c(ErrorCode p_152892_1_) {
/* 458 */     if (p_152892_1_ == ErrorCode.TTV_EC_SOUNDFLOWER_NOT_INSTALLED) {
/* 459 */       ChatComponentTranslation chatComponentTranslation1 = new ChatComponentTranslation("stream.unavailable.soundflower.chat.link", new Object[0]);
/* 460 */       chatComponentTranslation1.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://help.mojang.com/customer/portal/articles/1374877-configuring-soundflower-for-streaming-on-apple-computers"));
/* 461 */       chatComponentTranslation1.func_150256_b().func_150228_d(Boolean.valueOf(true));
/* 462 */       ChatComponentTranslation chatComponentTranslation2 = new ChatComponentTranslation("stream.unavailable.soundflower.chat", new Object[] { chatComponentTranslation1 });
/* 463 */       chatComponentTranslation2.func_150256_b().func_150238_a(EnumChatFormatting.DARK_RED);
/* 464 */       this.field_152953_e.field_71456_v.func_146158_b().func_146227_a((IChatComponent)chatComponentTranslation2);
/*     */     } else {
/* 466 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("stream.unavailable.unknown.chat", new Object[] { ErrorCode.getString(p_152892_1_) });
/* 467 */       chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.DARK_RED);
/* 468 */       this.field_152953_e.field_71456_v.func_146158_b().func_146227_a((IChatComponent)chatComponentTranslation);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152907_a(IngestServerTester p_152907_1_, IngestServerTester.IngestTestState p_152907_2_) {
/* 474 */     field_152950_b.debug(field_152949_a, "Ingest test state changed to {}", new Object[] { p_152907_2_ });
/* 475 */     if (p_152907_2_ == IngestServerTester.IngestTestState.Finished) {
/* 476 */       this.field_152960_l = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static int func_152948_a(float p_152948_0_) {
/* 481 */     return MathHelper.func_76141_d(10.0F + p_152948_0_ * 50.0F);
/*     */   }
/*     */   
/*     */   public static int func_152946_b(float p_152946_0_) {
/* 485 */     return MathHelper.func_76141_d(230.0F + p_152946_0_ * 3270.0F);
/*     */   }
/*     */   
/*     */   public static float func_152947_c(float p_152947_0_) {
/* 489 */     return 0.1F + p_152947_0_ * 0.1F;
/*     */   }
/*     */ 
/*     */   
/*     */   public IngestServer[] func_152925_v() {
/* 494 */     return this.field_152951_c.func_152855_t().getServers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152909_x() {
/* 504 */     IngestServerTester ingestServerTester = this.field_152951_c.func_152838_J();
/* 505 */     if (ingestServerTester != null) {
/* 506 */       ingestServerTester.func_153042_a(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IngestServerTester func_152932_y() {
/* 512 */     return this.field_152951_c.func_152856_w();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152908_z() {
/* 517 */     return this.field_152951_c.func_152825_o();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_152920_A() {
/* 522 */     return func_152934_n() ? (this.field_152951_c.func_152816_j()).viewers : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152903_a(ChatMessage[] p_152903_1_) {
/* 527 */     for (ChatMessage chatMessage : p_152903_1_) {
/* 528 */       func_152939_a(chatMessage.userName, chatMessage);
/*     */       
/* 530 */       if (func_152940_a(chatMessage.modes, chatMessage.subscriptions, this.field_152953_e.field_71474_y.field_152409_S)) {
/* 531 */         ChatComponentText chatComponentText1 = new ChatComponentText(chatMessage.userName);
/* 532 */         ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("chat.stream." + (chatMessage.action ? "emote" : "text"), new Object[] { this.field_152954_f, chatComponentText1, EnumChatFormatting.func_110646_a(chatMessage.message) });
/*     */         
/* 534 */         if (chatMessage.action) {
/* 535 */           chatComponentTranslation.func_150256_b().func_150217_b(Boolean.valueOf(true));
/*     */         }
/*     */         
/* 538 */         ChatComponentText chatComponentText2 = new ChatComponentText("");
/* 539 */         chatComponentText2.func_150257_a((IChatComponent)new ChatComponentTranslation("stream.userinfo.chatTooltip", new Object[0]));
/*     */         
/* 541 */         for (IChatComponent iChatComponent : GuiTwitchUserMode.func_152328_a(chatMessage.modes, chatMessage.subscriptions, null)) {
/* 542 */           chatComponentText2.func_150258_a("\n");
/* 543 */           chatComponentText2.func_150257_a(iChatComponent);
/*     */         } 
/*     */         
/* 546 */         chatComponentText1.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (IChatComponent)chatComponentText2));
/* 547 */         chatComponentText1.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.TWITCH_USER_INFO, chatMessage.userName));
/*     */         
/* 549 */         this.field_152953_e.field_71456_v.func_146158_b().func_146227_a((IChatComponent)chatComponentTranslation);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_152939_a(String p_152939_1_, ChatMessage p_152939_2_) {
/* 555 */     ChatUserInfo chatUserInfo = (ChatUserInfo)this.field_152955_g.get(p_152939_1_);
/*     */     
/* 557 */     if (chatUserInfo == null) {
/* 558 */       chatUserInfo = new ChatUserInfo();
/* 559 */       chatUserInfo.displayName = p_152939_1_;
/* 560 */       this.field_152955_g.put(p_152939_1_, chatUserInfo);
/*     */     } 
/*     */     
/* 563 */     chatUserInfo.subscriptions = p_152939_2_.subscriptions;
/* 564 */     chatUserInfo.modes = p_152939_2_.modes;
/* 565 */     chatUserInfo.emoticonSet = p_152939_2_.emoticonSet;
/* 566 */     chatUserInfo.nameColorARGB = p_152939_2_.nameColorARGB;
/*     */   }
/*     */   
/*     */   private boolean func_152940_a(HashSet p_152940_1_, HashSet p_152940_2_, int p_152940_3_) {
/* 570 */     if (p_152940_1_.contains(ChatUserMode.TTV_CHAT_USERMODE_BANNED)) return false; 
/* 571 */     if (p_152940_1_.contains(ChatUserMode.TTV_CHAT_USERMODE_ADMINSTRATOR)) return true; 
/* 572 */     if (p_152940_1_.contains(ChatUserMode.TTV_CHAT_USERMODE_MODERATOR)) return true; 
/* 573 */     if (p_152940_1_.contains(ChatUserMode.TTV_CHAT_USERMODE_STAFF)) return true;
/*     */     
/* 575 */     if (p_152940_3_ == 0)
/* 576 */       return true; 
/* 577 */     if (p_152940_3_ == 1) {
/* 578 */       return p_152940_2_.contains(ChatUserSubscription.TTV_CHAT_USERSUB_SUBSCRIBER);
/*     */     }
/*     */     
/* 581 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152904_a(ChatUserInfo[] p_152904_1_, ChatUserInfo[] p_152904_2_, ChatUserInfo[] p_152904_3_) {
/* 586 */     for (ChatUserInfo chatUserInfo : p_152904_2_) {
/* 587 */       this.field_152955_g.remove(chatUserInfo.displayName);
/*     */     }
/*     */     
/* 590 */     for (ChatUserInfo chatUserInfo : p_152904_3_) {
/* 591 */       this.field_152955_g.put(chatUserInfo.displayName, chatUserInfo);
/*     */     }
/*     */     
/* 594 */     for (ChatUserInfo chatUserInfo : p_152904_1_) {
/* 595 */       this.field_152955_g.put(chatUserInfo.displayName, chatUserInfo);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152906_d() {
/* 601 */     field_152950_b.debug(field_152949_a, "Chat connected");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152905_e() {
/* 606 */     field_152950_b.debug(field_152949_a, "Chat disconnected");
/* 607 */     this.field_152955_g.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152902_f() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_152927_B() {
/* 624 */     return (this.field_152952_d.func_152991_c() && this.field_152952_d.field_153005_c.equals((this.field_152951_c.func_152843_l()).name));
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_152921_C() {
/* 629 */     return this.field_152952_d.field_153005_c;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChatUserInfo func_152926_a(String p_152926_1_) {
/* 634 */     return (ChatUserInfo)this.field_152955_g.get(p_152926_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152917_b(String p_152917_1_) {
/* 639 */     this.field_152952_d.func_152992_g(p_152917_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152928_D() {
/* 644 */     return (field_152965_q && this.field_152951_c.func_152858_b());
/*     */   }
/*     */ 
/*     */   
/*     */   public ErrorCode func_152912_E() {
/* 649 */     if (!field_152965_q) {
/* 650 */       return ErrorCode.TTV_EC_OS_TOO_OLD;
/*     */     }
/*     */     
/* 653 */     return this.field_152951_c.func_152852_P();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152913_F() {
/* 658 */     return this.field_152961_m;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152910_a(boolean p_152910_1_) {
/* 663 */     this.field_152963_o = p_152910_1_;
/* 664 */     func_152915_s();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152929_G() {
/* 669 */     boolean bool = (this.field_152953_e.field_71474_y.field_152410_T == 1);
/*     */     
/* 671 */     return (this.field_152962_n || this.field_152953_e.field_71474_y.field_152401_K <= 0.0F || bool != this.field_152963_o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IStream.AuthFailureReason func_152918_H() {
/* 677 */     return this.field_152964_p;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\stream\TwitchStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */