/*      */ package net.minecraft.client.stream;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.crash.CrashReportCategory;
/*      */ import net.minecraft.util.ReportedException;
/*      */ import net.minecraft.util.ThreadSafeBoundList;
/*      */ import org.apache.logging.log4j.LogManager;
/*      */ import org.apache.logging.log4j.Logger;
/*      */ import tv.twitch.AuthToken;
/*      */ import tv.twitch.Core;
/*      */ import tv.twitch.CoreAPI;
/*      */ import tv.twitch.ErrorCode;
/*      */ import tv.twitch.MessageLevel;
/*      */ import tv.twitch.StandardCoreAPI;
/*      */ import tv.twitch.VideoEncoder;
/*      */ import tv.twitch.broadcast.ArchivingState;
/*      */ import tv.twitch.broadcast.AudioDeviceType;
/*      */ import tv.twitch.broadcast.AudioParams;
/*      */ import tv.twitch.broadcast.ChannelInfo;
/*      */ import tv.twitch.broadcast.DesktopStreamAPI;
/*      */ import tv.twitch.broadcast.EncodingCpuUsage;
/*      */ import tv.twitch.broadcast.FrameBuffer;
/*      */ import tv.twitch.broadcast.GameInfo;
/*      */ import tv.twitch.broadcast.GameInfoList;
/*      */ import tv.twitch.broadcast.IStatCallbacks;
/*      */ import tv.twitch.broadcast.IStreamCallbacks;
/*      */ import tv.twitch.broadcast.IngestList;
/*      */ import tv.twitch.broadcast.IngestServer;
/*      */ import tv.twitch.broadcast.PixelFormat;
/*      */ import tv.twitch.broadcast.StartFlags;
/*      */ import tv.twitch.broadcast.StatType;
/*      */ import tv.twitch.broadcast.Stream;
/*      */ import tv.twitch.broadcast.StreamAPI;
/*      */ import tv.twitch.broadcast.StreamInfo;
/*      */ import tv.twitch.broadcast.StreamInfoForSetting;
/*      */ import tv.twitch.broadcast.UserInfo;
/*      */ import tv.twitch.broadcast.VideoParams;
/*      */ 
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class BroadcastController
/*      */   implements IStatCallbacks, IStreamCallbacks
/*      */ {
/*      */   @SideOnly(Side.CLIENT)
/*      */   public enum BroadcastState
/*      */   {
/*   52 */     Uninitialized,
/*   53 */     Initialized,
/*   54 */     Authenticating,
/*   55 */     Authenticated,
/*   56 */     LoggingIn,
/*   57 */     LoggedIn,
/*   58 */     FindingIngestServer,
/*   59 */     ReceivedIngestServers,
/*   60 */     ReadyToBroadcast,
/*   61 */     Starting,
/*   62 */     Broadcasting,
/*   63 */     Stopping,
/*   64 */     Paused,
/*   65 */     IngestTesting;
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
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String __OBFID = "CL_00001820";
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  136 */   private static final Logger field_152861_B = LogManager.getLogger();
/*      */   
/*  138 */   protected final int field_152865_a = 30;
/*  139 */   protected final int field_152866_b = 3;
/*      */   
/*  141 */   private static final ThreadSafeBoundList field_152862_C = new ThreadSafeBoundList(String.class, 50);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  147 */   private String field_152863_D = null;
/*  148 */   protected BroadcastListener field_152867_c = null;
/*      */   
/*  150 */   protected String field_152868_d = "";
/*  151 */   protected String field_152869_e = "";
/*  152 */   protected String field_152870_f = "";
/*      */   
/*      */   protected boolean field_152871_g = true;
/*  155 */   protected Core field_152872_h = null;
/*  156 */   protected Stream field_152873_i = null;
/*  157 */   protected List field_152874_j = new ArrayList();
/*  158 */   protected List field_152875_k = new ArrayList();
/*      */   
/*      */   protected boolean field_152876_l = false;
/*      */   
/*      */   protected boolean field_152877_m = false;
/*      */   protected boolean field_152878_n = false;
/*  164 */   protected BroadcastState field_152879_o = BroadcastState.Uninitialized;
/*      */   
/*  166 */   protected String field_152880_p = null;
/*  167 */   protected VideoParams field_152881_q = null;
/*  168 */   protected AudioParams field_152882_r = null;
/*      */   
/*  170 */   protected IngestList field_152883_s = new IngestList(new IngestServer[0]);
/*  171 */   protected IngestServer field_152884_t = null;
/*  172 */   protected AuthToken field_152885_u = new AuthToken();
/*  173 */   protected ChannelInfo field_152886_v = new ChannelInfo();
/*  174 */   protected UserInfo field_152887_w = new UserInfo();
/*  175 */   protected StreamInfo field_152888_x = new StreamInfo();
/*  176 */   protected ArchivingState field_152889_y = new ArchivingState();
/*      */   
/*  178 */   protected long field_152890_z = 0L;
/*  179 */   protected IngestServerTester field_152860_A = null;
/*      */ 
/*      */   
/*      */   private ErrorCode field_152864_E;
/*      */ 
/*      */   
/*      */   private static final String __OBFID = "CL_00001822";
/*      */ 
/*      */   
/*      */   public void requestAuthTokenCallback(ErrorCode p_requestAuthTokenCallback_1_, AuthToken p_requestAuthTokenCallback_2_) {
/*  189 */     if (ErrorCode.succeeded(p_requestAuthTokenCallback_1_)) {
/*      */ 
/*      */       
/*  192 */       this.field_152885_u = p_requestAuthTokenCallback_2_;
/*  193 */       func_152827_a(BroadcastState.Authenticated);
/*      */     }
/*      */     else {
/*      */       
/*  197 */       this.field_152885_u.data = "";
/*  198 */       func_152827_a(BroadcastState.Initialized);
/*      */       
/*  200 */       String str = ErrorCode.getString(p_requestAuthTokenCallback_1_);
/*  201 */       func_152820_d(String.format("RequestAuthTokenDoneCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  206 */       if (this.field_152867_c != null)
/*      */       {
/*  208 */         this.field_152867_c.func_152900_a(p_requestAuthTokenCallback_1_, p_requestAuthTokenCallback_2_);
/*      */       }
/*      */     }
/*  211 */     catch (Exception exception) {
/*      */       
/*  213 */       func_152820_d(exception.toString());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void loginCallback(ErrorCode p_loginCallback_1_, ChannelInfo p_loginCallback_2_) {
/*  219 */     if (ErrorCode.succeeded(p_loginCallback_1_)) {
/*      */       
/*  221 */       this.field_152886_v = p_loginCallback_2_;
/*  222 */       func_152827_a(BroadcastState.LoggedIn);
/*  223 */       this.field_152877_m = true;
/*      */     }
/*      */     else {
/*      */       
/*  227 */       func_152827_a(BroadcastState.Initialized);
/*  228 */       this.field_152877_m = false;
/*      */       
/*  230 */       String str = ErrorCode.getString(p_loginCallback_1_);
/*  231 */       func_152820_d(String.format("LoginCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  236 */       if (this.field_152867_c != null)
/*      */       {
/*  238 */         this.field_152867_c.func_152897_a(p_loginCallback_1_);
/*      */       }
/*      */     }
/*  241 */     catch (Exception exception) {
/*      */       
/*  243 */       func_152820_d(exception.toString());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void getIngestServersCallback(ErrorCode p_getIngestServersCallback_1_, IngestList p_getIngestServersCallback_2_) {
/*  249 */     if (ErrorCode.succeeded(p_getIngestServersCallback_1_)) {
/*      */       
/*  251 */       this.field_152883_s = p_getIngestServersCallback_2_;
/*      */ 
/*      */       
/*  254 */       this.field_152884_t = this.field_152883_s.getDefaultServer();
/*      */       
/*  256 */       func_152827_a(BroadcastState.ReceivedIngestServers);
/*      */ 
/*      */       
/*      */       try {
/*  260 */         if (this.field_152867_c != null)
/*      */         {
/*  262 */           this.field_152867_c.func_152896_a(p_getIngestServersCallback_2_);
/*      */         }
/*      */       }
/*  265 */       catch (Exception exception) {
/*      */         
/*  267 */         func_152820_d(exception.toString());
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  272 */       String str = ErrorCode.getString(p_getIngestServersCallback_1_);
/*  273 */       func_152820_d(String.format("IngestListCallback got failure: %s", new Object[] { str }));
/*      */ 
/*      */       
/*  276 */       func_152827_a(BroadcastState.LoggingIn);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void getUserInfoCallback(ErrorCode p_getUserInfoCallback_1_, UserInfo p_getUserInfoCallback_2_) {
/*  282 */     this.field_152887_w = p_getUserInfoCallback_2_;
/*      */     
/*  284 */     if (ErrorCode.failed(p_getUserInfoCallback_1_)) {
/*      */       
/*  286 */       String str = ErrorCode.getString(p_getUserInfoCallback_1_);
/*  287 */       func_152820_d(String.format("UserInfoDoneCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void getStreamInfoCallback(ErrorCode p_getStreamInfoCallback_1_, StreamInfo p_getStreamInfoCallback_2_) {
/*  293 */     if (ErrorCode.succeeded(p_getStreamInfoCallback_1_)) {
/*      */       
/*  295 */       this.field_152888_x = p_getStreamInfoCallback_2_;
/*      */ 
/*      */       
/*      */       try {
/*  299 */         if (this.field_152867_c != null)
/*      */         {
/*  301 */           this.field_152867_c.func_152894_a(p_getStreamInfoCallback_2_);
/*      */         }
/*      */       }
/*  304 */       catch (Exception exception) {
/*      */         
/*  306 */         func_152820_d(exception.toString());
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  311 */       String str = ErrorCode.getString(p_getStreamInfoCallback_1_);
/*  312 */       func_152832_e(String.format("StreamInfoDoneCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void getArchivingStateCallback(ErrorCode p_getArchivingStateCallback_1_, ArchivingState p_getArchivingStateCallback_2_) {
/*  318 */     this.field_152889_y = p_getArchivingStateCallback_2_;
/*      */     
/*  320 */     if (ErrorCode.failed(p_getArchivingStateCallback_1_));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void runCommercialCallback(ErrorCode p_runCommercialCallback_1_) {
/*  329 */     if (ErrorCode.failed(p_runCommercialCallback_1_)) {
/*      */       
/*  331 */       String str = ErrorCode.getString(p_runCommercialCallback_1_);
/*  332 */       func_152832_e(String.format("RunCommercialCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setStreamInfoCallback(ErrorCode p_setStreamInfoCallback_1_) {
/*  338 */     if (ErrorCode.failed(p_setStreamInfoCallback_1_)) {
/*      */       
/*  340 */       String str = ErrorCode.getString(p_setStreamInfoCallback_1_);
/*  341 */       func_152832_e(String.format("SetStreamInfoCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void getGameNameListCallback(ErrorCode p_getGameNameListCallback_1_, GameInfoList p_getGameNameListCallback_2_) {
/*  347 */     if (ErrorCode.failed(p_getGameNameListCallback_1_)) {
/*      */       
/*  349 */       String str = ErrorCode.getString(p_getGameNameListCallback_1_);
/*  350 */       func_152820_d(String.format("GameNameListCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  355 */       if (this.field_152867_c != null)
/*      */       {
/*  357 */         this.field_152867_c.func_152898_a(p_getGameNameListCallback_1_, (p_getGameNameListCallback_2_ == null) ? new GameInfo[0] : p_getGameNameListCallback_2_.list);
/*      */       }
/*      */     }
/*  360 */     catch (Exception exception) {
/*      */       
/*  362 */       func_152820_d(exception.toString());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void bufferUnlockCallback(long p_bufferUnlockCallback_1_) {
/*  368 */     FrameBuffer frameBuffer = FrameBuffer.lookupBuffer(p_bufferUnlockCallback_1_);
/*      */ 
/*      */     
/*  371 */     this.field_152875_k.add(frameBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   public void startCallback(ErrorCode p_startCallback_1_) {
/*  376 */     if (ErrorCode.succeeded(p_startCallback_1_)) {
/*      */ 
/*      */       
/*      */       try {
/*  380 */         if (this.field_152867_c != null)
/*      */         {
/*  382 */           this.field_152867_c.func_152899_b();
/*      */         }
/*      */       }
/*  385 */       catch (Exception exception) {
/*      */         
/*  387 */         func_152820_d(exception.toString());
/*      */       } 
/*      */       
/*  390 */       func_152827_a(BroadcastState.Broadcasting);
/*      */     }
/*      */     else {
/*      */       
/*  394 */       this.field_152881_q = null;
/*  395 */       this.field_152882_r = null;
/*      */       
/*  397 */       func_152827_a(BroadcastState.ReadyToBroadcast);
/*      */       
/*  399 */       String str = ErrorCode.getString(p_startCallback_1_);
/*  400 */       this.field_152867_c.func_152892_c(p_startCallback_1_);
/*  401 */       func_152820_d(String.format("startCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void stopCallback(ErrorCode p_stopCallback_1_) {
/*  407 */     if (ErrorCode.succeeded(p_stopCallback_1_)) {
/*      */       
/*  409 */       this.field_152881_q = null;
/*  410 */       this.field_152882_r = null;
/*      */       
/*  412 */       func_152831_M();
/*      */ 
/*      */       
/*      */       try {
/*  416 */         if (this.field_152867_c != null)
/*      */         {
/*  418 */           this.field_152867_c.func_152901_c();
/*      */         }
/*      */       }
/*  421 */       catch (Exception exception) {
/*      */         
/*  423 */         func_152820_d(exception.toString());
/*      */       } 
/*      */       
/*  426 */       if (this.field_152877_m)
/*      */       {
/*  428 */         func_152827_a(BroadcastState.ReadyToBroadcast);
/*      */       }
/*      */       else
/*      */       {
/*  432 */         func_152827_a(BroadcastState.Initialized);
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  438 */       func_152827_a(BroadcastState.ReadyToBroadcast);
/*      */       
/*  440 */       String str = ErrorCode.getString(p_stopCallback_1_);
/*  441 */       func_152820_d(String.format("stopCallback got failure: %s", new Object[] { str }));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void sendActionMetaDataCallback(ErrorCode p_sendActionMetaDataCallback_1_) {
/*  448 */     if (ErrorCode.failed(p_sendActionMetaDataCallback_1_)) {
/*  449 */       func_152832_e("Failed sending action metadata: " + ErrorCode.getString(p_sendActionMetaDataCallback_1_));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendStartSpanMetaDataCallback(ErrorCode p_sendStartSpanMetaDataCallback_1_) {
/*  455 */     if (ErrorCode.failed(p_sendStartSpanMetaDataCallback_1_)) {
/*  456 */       func_152832_e("Failed sending span metadata start: " + ErrorCode.getString(p_sendStartSpanMetaDataCallback_1_));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendEndSpanMetaDataCallback(ErrorCode p_sendEndSpanMetaDataCallback_1_) {
/*  462 */     if (ErrorCode.failed(p_sendEndSpanMetaDataCallback_1_)) {
/*  463 */       func_152832_e("Failed sending span metadata end: " + ErrorCode.getString(p_sendEndSpanMetaDataCallback_1_));
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
/*      */   public void statCallback(StatType p_statCallback_1_, long p_statCallback_2_) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_152841_a(BroadcastListener p_152841_1_) {
/*  485 */     this.field_152867_c = p_152841_1_;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_152858_b() {
/*  490 */     return this.field_152876_l;
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
/*      */   public void func_152842_a(String p_152842_1_) {
/*  505 */     this.field_152868_d = p_152842_1_;
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
/*      */   public StreamInfo func_152816_j() {
/*  548 */     return this.field_152888_x;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ChannelInfo func_152843_l() {
/*  558 */     return this.field_152886_v;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_152850_m() {
/*  563 */     return (this.field_152879_o == BroadcastState.Broadcasting || this.field_152879_o == BroadcastState.Paused);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_152857_n() {
/*  568 */     return (this.field_152879_o == BroadcastState.ReadyToBroadcast);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_152825_o() {
/*  573 */     return (this.field_152879_o == BroadcastState.IngestTesting);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_152839_p() {
/*  578 */     return (this.field_152879_o == BroadcastState.Paused);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_152849_q() {
/*  583 */     return this.field_152877_m;
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
/*      */   public IngestServer func_152833_s() {
/*  597 */     return this.field_152884_t;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_152824_a(IngestServer p_152824_1_) {
/*  605 */     this.field_152884_t = p_152824_1_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IngestList func_152855_t() {
/*  614 */     return this.field_152883_s;
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
/*      */   public void func_152829_a(float p_152829_1_) {
/*  626 */     this.field_152873_i.setVolume(AudioDeviceType.TTV_RECORDER_DEVICE, p_152829_1_);
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
/*      */   public void func_152837_b(float p_152837_1_) {
/*  638 */     this.field_152873_i.setVolume(AudioDeviceType.TTV_PLAYBACK_DEVICE, p_152837_1_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IngestServerTester func_152856_w() {
/*  646 */     return this.field_152860_A;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long func_152844_x() {
/*  654 */     return this.field_152873_i.getStreamTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean func_152848_y() {
/*  664 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BroadcastController() {
/*  671 */     this.field_152872_h = new Core((CoreAPI)new StandardCoreAPI());
/*  672 */     this.field_152873_i = new Stream((StreamAPI)new DesktopStreamAPI());
/*      */   }
/*      */ 
/*      */   
/*      */   protected PixelFormat func_152826_z() {
/*  677 */     return PixelFormat.TTV_PF_RGBA;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_152817_A() {
/*  685 */     if (this.field_152876_l)
/*      */     {
/*  687 */       return false;
/*      */     }
/*      */     
/*  690 */     ErrorCode errorCode = this.field_152872_h.initialize(this.field_152868_d, VideoEncoder.TTV_VID_ENC_DEFAULT, System.getProperty("java.library.path"));
/*  691 */     if (!func_152853_a(errorCode)) {
/*      */       
/*  693 */       this.field_152864_E = errorCode;
/*  694 */       return false;
/*      */     } 
/*      */     
/*  697 */     this.field_152873_i.setStreamCallbacks(this);
/*      */     
/*  699 */     if (!func_152853_a(errorCode)) {
/*      */       
/*  701 */       this.field_152873_i.setStreamCallbacks(null);
/*  702 */       this.field_152864_E = errorCode;
/*  703 */       return false;
/*      */     } 
/*      */     
/*  706 */     errorCode = this.field_152872_h.setTraceLevel(MessageLevel.TTV_ML_ERROR);
/*  707 */     if (!func_152853_a(errorCode)) {
/*      */       
/*  709 */       this.field_152873_i.setStreamCallbacks(null);
/*  710 */       this.field_152864_E = errorCode;
/*  711 */       return false;
/*      */     } 
/*      */     
/*  714 */     if (ErrorCode.succeeded(errorCode)) {
/*      */       
/*  716 */       this.field_152876_l = true;
/*  717 */       func_152827_a(BroadcastState.Initialized);
/*  718 */       return true;
/*      */     } 
/*      */     
/*  721 */     this.field_152864_E = errorCode;
/*  722 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_152851_B() {
/*  730 */     if (!this.field_152876_l)
/*      */     {
/*  732 */       return true;
/*      */     }
/*  734 */     if (func_152825_o())
/*      */     {
/*  736 */       return false;
/*      */     }
/*      */     
/*  739 */     this.field_152878_n = true;
/*      */     
/*  741 */     func_152845_C();
/*      */     
/*  743 */     this.field_152873_i.setStreamCallbacks(null);
/*  744 */     this.field_152873_i.setStatCallbacks(null);
/*      */     
/*  746 */     ErrorCode errorCode = this.field_152872_h.shutdown();
/*  747 */     func_152853_a(errorCode);
/*      */     
/*  749 */     this.field_152876_l = false;
/*  750 */     this.field_152878_n = false;
/*  751 */     func_152827_a(BroadcastState.Uninitialized);
/*      */     
/*  753 */     return true;
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
/*      */   
/*      */   public boolean func_152818_a(String p_152818_1_, AuthToken p_152818_2_) {
/*  802 */     if (func_152825_o())
/*      */     {
/*  804 */       return false;
/*      */     }
/*      */     
/*  807 */     func_152845_C();
/*      */     
/*  809 */     if (p_152818_1_ == null || p_152818_1_.isEmpty()) {
/*      */       
/*  811 */       func_152820_d("Username must be valid");
/*  812 */       return false;
/*      */     } 
/*  814 */     if (p_152818_2_ == null || p_152818_2_.data == null || p_152818_2_.data.isEmpty()) {
/*      */       
/*  816 */       func_152820_d("Auth token must be valid");
/*  817 */       return false;
/*      */     } 
/*      */     
/*  820 */     this.field_152880_p = p_152818_1_;
/*  821 */     this.field_152885_u = p_152818_2_;
/*      */     
/*  823 */     if (func_152858_b())
/*      */     {
/*  825 */       func_152827_a(BroadcastState.Authenticated);
/*      */     }
/*      */     
/*  828 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_152845_C() {
/*  836 */     if (func_152825_o())
/*      */     {
/*  838 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  842 */     if (func_152850_m())
/*      */     {
/*  844 */       this.field_152873_i.stop(false);
/*      */     }
/*      */     
/*  847 */     this.field_152880_p = "";
/*  848 */     this.field_152885_u = new AuthToken();
/*      */     
/*  850 */     if (!this.field_152877_m)
/*      */     {
/*  852 */       return false;
/*      */     }
/*      */     
/*  855 */     this.field_152877_m = false;
/*      */ 
/*      */     
/*  858 */     if (!this.field_152878_n) {
/*      */       
/*      */       try {
/*      */         
/*  862 */         if (this.field_152867_c != null)
/*      */         {
/*  864 */           this.field_152867_c.func_152895_a();
/*      */         }
/*      */       }
/*  867 */       catch (Exception exception) {
/*      */         
/*  869 */         func_152820_d(exception.toString());
/*      */       } 
/*      */     }
/*      */     
/*  873 */     func_152827_a(BroadcastState.Initialized);
/*      */     
/*  875 */     return true;
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
/*      */   public boolean func_152828_a(String p_152828_1_, String p_152828_2_, String p_152828_3_) {
/*  887 */     if (!this.field_152877_m)
/*      */     {
/*  889 */       return false;
/*      */     }
/*      */     
/*  892 */     if (p_152828_1_ == null || p_152828_1_.equals(""))
/*      */     {
/*  894 */       p_152828_1_ = this.field_152880_p;
/*      */     }
/*      */     
/*  897 */     if (p_152828_2_ == null)
/*      */     {
/*  899 */       p_152828_2_ = "";
/*      */     }
/*      */     
/*  902 */     if (p_152828_3_ == null)
/*      */     {
/*  904 */       p_152828_3_ = "";
/*      */     }
/*      */     
/*  907 */     StreamInfoForSetting streamInfoForSetting = new StreamInfoForSetting();
/*  908 */     streamInfoForSetting.streamTitle = p_152828_3_;
/*  909 */     streamInfoForSetting.gameName = p_152828_2_;
/*      */     
/*  911 */     ErrorCode errorCode = this.field_152873_i.setStreamInfo(this.field_152885_u, p_152828_1_, streamInfoForSetting);
/*  912 */     func_152853_a(errorCode);
/*      */     
/*  914 */     return ErrorCode.succeeded(errorCode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_152830_D() {
/*  923 */     if (!func_152850_m())
/*      */     {
/*  925 */       return false;
/*      */     }
/*      */     
/*  928 */     ErrorCode errorCode = this.field_152873_i.runCommercial(this.field_152885_u);
/*  929 */     func_152853_a(errorCode);
/*      */     
/*  931 */     return ErrorCode.succeeded(errorCode);
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
/*      */   
/*      */   public VideoParams func_152834_a(int p_152834_1_, int p_152834_2_, float p_152834_3_, float p_152834_4_) {
/*  950 */     int[] arrayOfInt = this.field_152873_i.getMaxResolution(p_152834_1_, p_152834_2_, p_152834_3_, p_152834_4_);
/*      */     
/*  952 */     VideoParams videoParams = new VideoParams();
/*  953 */     videoParams.maxKbps = p_152834_1_;
/*  954 */     videoParams.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
/*  955 */     videoParams.pixelFormat = func_152826_z();
/*  956 */     videoParams.targetFps = p_152834_2_;
/*  957 */     videoParams.outputWidth = arrayOfInt[0];
/*  958 */     videoParams.outputHeight = arrayOfInt[1];
/*  959 */     videoParams.disableAdaptiveBitrate = false;
/*  960 */     videoParams.verticalFlip = false;
/*      */     
/*  962 */     return videoParams;
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
/*      */   public boolean func_152836_a(VideoParams p_152836_1_) {
/* 1005 */     if (p_152836_1_ == null || !func_152857_n())
/*      */     {
/* 1007 */       return false;
/*      */     }
/*      */     
/* 1010 */     this.field_152881_q = p_152836_1_.clone();
/*      */ 
/*      */     
/* 1013 */     this.field_152882_r = new AudioParams();
/* 1014 */     this.field_152882_r.audioEnabled = (this.field_152871_g && func_152848_y());
/*      */     
/* 1016 */     if (!func_152823_L()) {
/*      */       
/* 1018 */       this.field_152881_q = null;
/* 1019 */       this.field_152882_r = null;
/* 1020 */       return false;
/*      */     } 
/*      */     
/* 1023 */     ErrorCode errorCode = this.field_152873_i.start(p_152836_1_, this.field_152882_r, this.field_152884_t, StartFlags.None, true);
/* 1024 */     if (ErrorCode.failed(errorCode)) {
/*      */       
/* 1026 */       func_152831_M();
/*      */       
/* 1028 */       String str = ErrorCode.getString(errorCode);
/* 1029 */       func_152820_d(String.format("Error while starting to broadcast: %s", new Object[] { str }));
/*      */       
/* 1031 */       this.field_152881_q = null;
/* 1032 */       this.field_152882_r = null;
/*      */       
/* 1034 */       return false;
/*      */     } 
/*      */     
/* 1037 */     func_152827_a(BroadcastState.Starting);
/*      */     
/* 1039 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_152819_E() {
/* 1048 */     if (!func_152850_m())
/*      */     {
/* 1050 */       return false;
/*      */     }
/*      */     
/* 1053 */     ErrorCode errorCode = this.field_152873_i.stop(true);
/* 1054 */     if (ErrorCode.failed(errorCode)) {
/*      */       
/* 1056 */       String str = ErrorCode.getString(errorCode);
/* 1057 */       func_152820_d(String.format("Error while stopping the broadcast: %s", new Object[] { str }));
/* 1058 */       return false;
/*      */     } 
/*      */     
/* 1061 */     func_152827_a(BroadcastState.Stopping);
/*      */     
/* 1063 */     return ErrorCode.succeeded(errorCode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_152847_F() {
/* 1072 */     if (!func_152850_m())
/*      */     {
/* 1074 */       return false;
/*      */     }
/*      */     
/* 1077 */     ErrorCode errorCode = this.field_152873_i.pauseVideo();
/* 1078 */     if (ErrorCode.failed(errorCode)) {
/*      */ 
/*      */       
/* 1081 */       func_152819_E();
/*      */       
/* 1083 */       String str = ErrorCode.getString(errorCode);
/* 1084 */       func_152820_d(String.format("Error pausing stream: %s\n", new Object[] { str }));
/*      */     }
/*      */     else {
/*      */       
/* 1088 */       func_152827_a(BroadcastState.Paused);
/*      */     } 
/*      */     
/* 1091 */     return ErrorCode.succeeded(errorCode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_152854_G() {
/* 1100 */     if (!func_152839_p())
/*      */     {
/* 1102 */       return false;
/*      */     }
/*      */     
/* 1105 */     func_152827_a(BroadcastState.Broadcasting);
/*      */     
/* 1107 */     return true;
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
/*      */   public boolean func_152840_a(String p_152840_1_, long p_152840_2_, String p_152840_4_, String p_152840_5_) {
/* 1120 */     ErrorCode errorCode = this.field_152873_i.sendActionMetaData(this.field_152885_u, p_152840_1_, p_152840_2_, p_152840_4_, p_152840_5_);
/* 1121 */     if (ErrorCode.failed(errorCode)) {
/*      */       
/* 1123 */       String str = ErrorCode.getString(errorCode);
/* 1124 */       func_152820_d(String.format("Error while sending meta data: %s\n", new Object[] { str }));
/*      */       
/* 1126 */       return false;
/*      */     } 
/*      */     
/* 1129 */     return true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_152827_a(BroadcastState p_152827_1_) {
/* 1196 */     if (p_152827_1_ == this.field_152879_o) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1201 */     this.field_152879_o = p_152827_1_;
/*      */ 
/*      */     
/*      */     try {
/* 1205 */       if (this.field_152867_c != null)
/*      */       {
/* 1207 */         this.field_152867_c.func_152891_a(p_152827_1_);
/*      */       }
/*      */     }
/* 1210 */     catch (Exception exception) {
/*      */       
/* 1212 */       func_152820_d(exception.toString());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_152821_H() {
/* 1222 */     if (this.field_152873_i == null || !this.field_152876_l) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1227 */     ErrorCode errorCode = this.field_152873_i.pollTasks();
/* 1228 */     func_152853_a(errorCode);
/*      */ 
/*      */     
/* 1231 */     if (func_152825_o()) {
/*      */       
/* 1233 */       this.field_152860_A.func_153041_j();
/*      */ 
/*      */       
/* 1236 */       if (this.field_152860_A.func_153032_e()) {
/*      */         
/* 1238 */         this.field_152860_A = null;
/* 1239 */         func_152827_a(BroadcastState.ReadyToBroadcast);
/*      */       } 
/*      */     } 
/*      */     
/* 1243 */     switch (SwitchBroadcastState.field_152815_a[this.field_152879_o.ordinal()]) {
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/* 1248 */         func_152827_a(BroadcastState.LoggingIn);
/*      */         
/* 1250 */         errorCode = this.field_152873_i.login(this.field_152885_u);
/* 1251 */         if (ErrorCode.failed(errorCode)) {
/*      */           
/* 1253 */           String str = ErrorCode.getString(errorCode);
/* 1254 */           func_152820_d(String.format("Error in TTV_Login: %s\n", new Object[] { str }));
/*      */         } 
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/* 1261 */         func_152827_a(BroadcastState.FindingIngestServer);
/*      */         
/* 1263 */         errorCode = this.field_152873_i.getIngestServers(this.field_152885_u);
/* 1264 */         if (ErrorCode.failed(errorCode)) {
/*      */           
/* 1266 */           func_152827_a(BroadcastState.LoggedIn);
/*      */           
/* 1268 */           String str = ErrorCode.getString(errorCode);
/* 1269 */           func_152820_d(String.format("Error in TTV_GetIngestServers: %s\n", new Object[] { str }));
/*      */         } 
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 3:
/* 1276 */         func_152827_a(BroadcastState.ReadyToBroadcast);
/*      */ 
/*      */         
/* 1279 */         errorCode = this.field_152873_i.getUserInfo(this.field_152885_u);
/* 1280 */         if (ErrorCode.failed(errorCode)) {
/*      */           
/* 1282 */           String str = ErrorCode.getString(errorCode);
/* 1283 */           func_152820_d(String.format("Error in TTV_GetUserInfo: %s\n", new Object[] { str }));
/*      */         } 
/*      */         
/* 1286 */         func_152835_I();
/*      */         
/* 1288 */         errorCode = this.field_152873_i.getArchivingState(this.field_152885_u);
/* 1289 */         if (ErrorCode.failed(errorCode)) {
/*      */           
/* 1291 */           String str = ErrorCode.getString(errorCode);
/* 1292 */           func_152820_d(String.format("Error in TTV_GetArchivingState: %s\n", new Object[] { str }));
/*      */         } 
/*      */         break;
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
/*      */ 
/*      */ 
/*      */       
/*      */       case 11:
/*      */       case 12:
/* 1315 */         func_152835_I();
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_152835_I() {
/* 1327 */     long l1 = System.nanoTime();
/* 1328 */     long l2 = (l1 - this.field_152890_z) / 1000000000L;
/*      */ 
/*      */     
/* 1331 */     if (l2 < 30L) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1336 */     this.field_152890_z = l1;
/*      */     
/* 1338 */     ErrorCode errorCode = this.field_152873_i.getStreamInfo(this.field_152885_u, this.field_152880_p);
/* 1339 */     if (ErrorCode.failed(errorCode)) {
/*      */       
/* 1341 */       String str = ErrorCode.getString(errorCode);
/* 1342 */       func_152820_d(String.format("Error in TTV_GetStreamInfo: %s", new Object[] { str }));
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
/*      */   public IngestServerTester func_152838_J() {
/* 1355 */     if (!func_152857_n() || this.field_152883_s == null)
/*      */     {
/* 1357 */       return null;
/*      */     }
/*      */     
/* 1360 */     if (func_152825_o())
/*      */     {
/* 1362 */       return null;
/*      */     }
/*      */     
/* 1365 */     this.field_152860_A = new IngestServerTester(this.field_152873_i, this.field_152883_s);
/* 1366 */     this.field_152860_A.func_153033_i();
/*      */     
/* 1368 */     func_152827_a(BroadcastState.IngestTesting);
/*      */     
/* 1370 */     return this.field_152860_A;
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
/*      */ 
/*      */   
/*      */   protected boolean func_152823_L() {
/* 1390 */     for (byte b = 0; b < 3; b++) {
/*      */       
/* 1392 */       FrameBuffer frameBuffer = this.field_152873_i.allocateFrameBuffer(this.field_152881_q.outputWidth * this.field_152881_q.outputHeight * 4);
/* 1393 */       if (!frameBuffer.getIsValid()) {
/*      */         
/* 1395 */         func_152820_d(String.format("Error while allocating frame buffer", new Object[0]));
/* 1396 */         return false;
/*      */       } 
/*      */       
/* 1399 */       this.field_152874_j.add(frameBuffer);
/* 1400 */       this.field_152875_k.add(frameBuffer);
/*      */     } 
/*      */     
/* 1403 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_152831_M() {
/* 1409 */     for (byte b = 0; b < this.field_152874_j.size(); b++) {
/*      */       
/* 1411 */       FrameBuffer frameBuffer = this.field_152874_j.get(b);
/* 1412 */       frameBuffer.free();
/*      */     } 
/*      */     
/* 1415 */     this.field_152875_k.clear();
/* 1416 */     this.field_152874_j.clear();
/*      */   }
/*      */ 
/*      */   
/*      */   public FrameBuffer func_152822_N() {
/* 1421 */     if (this.field_152875_k.size() == 0) {
/*      */       
/* 1423 */       func_152820_d(String.format("Out of free buffers, this should never happen", new Object[0]));
/* 1424 */       return null;
/*      */     } 
/*      */     
/* 1427 */     FrameBuffer frameBuffer = this.field_152875_k.get(this.field_152875_k.size() - 1);
/* 1428 */     this.field_152875_k.remove(this.field_152875_k.size() - 1);
/*      */     
/* 1430 */     return frameBuffer;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_152846_a(FrameBuffer p_152846_1_) {
/*      */     try {
/* 1436 */       this.field_152873_i.captureFrameBuffer_ReadPixels(p_152846_1_);
/* 1437 */     } catch (Throwable throwable) {
/* 1438 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Trying to submit a frame to Twitch");
/* 1439 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Broadcast State");
/* 1440 */       crashReportCategory.func_71507_a("Last reported errors", Arrays.toString(field_152862_C.func_152756_c()));
/* 1441 */       crashReportCategory.func_71507_a("Buffer", p_152846_1_);
/* 1442 */       crashReportCategory.func_71507_a("Free buffer count", Integer.valueOf(this.field_152875_k.size()));
/* 1443 */       crashReportCategory.func_71507_a("Capture buffer count", Integer.valueOf(this.field_152874_j.size()));
/* 1444 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ErrorCode func_152859_b(FrameBuffer p_152859_1_) {
/* 1450 */     if (func_152839_p()) {
/*      */       
/* 1452 */       func_152854_G();
/*      */     }
/* 1454 */     else if (!func_152850_m()) {
/*      */       
/* 1456 */       return ErrorCode.TTV_EC_STREAM_NOT_STARTED;
/*      */     } 
/*      */     
/* 1459 */     ErrorCode errorCode = this.field_152873_i.submitVideoFrame(p_152859_1_);
/*      */ 
/*      */     
/* 1462 */     if (errorCode != ErrorCode.TTV_EC_SUCCESS) {
/*      */       
/* 1464 */       String str = ErrorCode.getString(errorCode);
/* 1465 */       if (ErrorCode.succeeded(errorCode)) {
/*      */         
/* 1467 */         func_152832_e(String.format("Warning in SubmitTexturePointer: %s\n", new Object[] { str }));
/*      */       }
/*      */       else {
/*      */         
/* 1471 */         func_152820_d(String.format("Error in SubmitTexturePointer: %s\n", new Object[] { str }));
/*      */ 
/*      */         
/* 1474 */         func_152819_E();
/*      */       } 
/*      */       
/* 1477 */       if (this.field_152867_c != null)
/*      */       {
/* 1479 */         this.field_152867_c.func_152893_b(errorCode);
/*      */       }
/*      */     } 
/*      */     
/* 1483 */     return errorCode;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean func_152853_a(ErrorCode p_152853_1_) {
/* 1488 */     if (ErrorCode.failed(p_152853_1_)) {
/*      */       
/* 1490 */       func_152820_d(ErrorCode.getString(p_152853_1_));
/* 1491 */       return false;
/*      */     } 
/*      */     
/* 1494 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_152820_d(String p_152820_1_) {
/* 1503 */     this.field_152863_D = p_152820_1_;
/* 1504 */     field_152862_C.func_152757_a("<Error> " + p_152820_1_);
/* 1505 */     field_152861_B.error(TwitchStream.field_152949_a, "[Broadcast controller] {}", new Object[] { p_152820_1_ });
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_152832_e(String p_152832_1_) {
/* 1510 */     field_152862_C.func_152757_a("<Warning> " + p_152832_1_);
/* 1511 */     field_152861_B.warn(TwitchStream.field_152949_a, "[Broadcast controller] {}", new Object[] { p_152832_1_ });
/*      */   }
/*      */   
/*      */   public ErrorCode func_152852_P() {
/* 1515 */     return this.field_152864_E;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public static interface BroadcastListener {
/*      */     void func_152900_a(ErrorCode param1ErrorCode, AuthToken param1AuthToken);
/*      */     
/*      */     void func_152897_a(ErrorCode param1ErrorCode);
/*      */     
/*      */     void func_152898_a(ErrorCode param1ErrorCode, GameInfo[] param1ArrayOfGameInfo);
/*      */     
/*      */     void func_152891_a(BroadcastController.BroadcastState param1BroadcastState);
/*      */     
/*      */     void func_152895_a();
/*      */     
/*      */     void func_152894_a(StreamInfo param1StreamInfo);
/*      */     
/*      */     void func_152896_a(IngestList param1IngestList);
/*      */     
/*      */     void func_152893_b(ErrorCode param1ErrorCode);
/*      */     
/*      */     void func_152899_b();
/*      */     
/*      */     void func_152901_c();
/*      */     
/*      */     void func_152892_c(ErrorCode param1ErrorCode);
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\stream\BroadcastController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */