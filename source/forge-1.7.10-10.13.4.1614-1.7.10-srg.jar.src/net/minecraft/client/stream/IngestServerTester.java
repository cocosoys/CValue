/*     */ package net.minecraft.client.stream;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import tv.twitch.ErrorCode;
/*     */ import tv.twitch.broadcast.AudioParams;
/*     */ import tv.twitch.broadcast.FrameBuffer;
/*     */ import tv.twitch.broadcast.IStreamCallbacks;
/*     */ import tv.twitch.broadcast.IngestList;
/*     */ import tv.twitch.broadcast.IngestServer;
/*     */ import tv.twitch.broadcast.RTMPState;
/*     */ import tv.twitch.broadcast.StatType;
/*     */ import tv.twitch.broadcast.Stream;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class IngestServerTester implements IStatCallbacks, IStreamCallbacks {
/*     */   @SideOnly(Side.CLIENT)
/*     */   public enum IngestTestState {
/*  18 */     Uninitalized,
/*  19 */     Starting,
/*  20 */     ConnectingToServer,
/*  21 */     TestingServer,
/*  22 */     DoneTestingServer,
/*  23 */     Finished,
/*  24 */     Cancelled,
/*  25 */     Failed;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final String __OBFID = "CL_00001814";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean field_153043_a = true;
/*     */ 
/*     */ 
/*     */   
/*  40 */   protected IngestTestListener field_153044_b = null;
/*     */   
/*  42 */   protected Stream field_153045_c = null;
/*  43 */   protected IngestList field_153046_d = null;
/*     */   
/*  45 */   protected IngestTestState field_153047_e = IngestTestState.Uninitalized;
/*  46 */   protected long field_153048_f = 8000L;
/*  47 */   protected long field_153049_g = 1000L;
/*  48 */   protected long field_153050_h = 0L;
/*  49 */   protected RTMPState field_153051_i = RTMPState.Invalid;
/*  50 */   protected VideoParams field_153052_j = null;
/*  51 */   protected AudioParams field_153053_k = null;
/*  52 */   protected long field_153054_l = 0L;
/*  53 */   protected List field_153055_m = null;
/*     */   protected boolean field_153056_n = false;
/*  55 */   protected IStreamCallbacks field_153057_o = null;
/*  56 */   protected IStatCallbacks field_153058_p = null;
/*  57 */   protected IngestServer field_153059_q = null;
/*     */   protected boolean field_153060_r = false;
/*     */   protected boolean field_153061_s = false;
/*  60 */   protected int field_153062_t = -1;
/*  61 */   protected int field_153063_u = 0;
/*  62 */   protected long field_153064_v = 0L;
/*  63 */   protected float field_153065_w = 0.0F;
/*  64 */   protected float field_153066_x = 0.0F;
/*     */   protected boolean field_153067_y = false;
/*     */   private static final String __OBFID = "CL_00001816";
/*     */   
/*     */   public void func_153042_a(IngestTestListener p_153042_1_) {
/*  69 */     this.field_153044_b = p_153042_1_;
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
/*     */   public IngestServer func_153040_c() {
/*  83 */     return this.field_153059_q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_153032_e() {
/*  93 */     return (this.field_153047_e == IngestTestState.Finished || this.field_153047_e == IngestTestState.Cancelled || this.field_153047_e == IngestTestState.Failed);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_153030_h() {
/* 120 */     return this.field_153066_x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void requestAuthTokenCallback(ErrorCode p_requestAuthTokenCallback_1_, AuthToken p_requestAuthTokenCallback_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void loginCallback(ErrorCode p_loginCallback_1_, ChannelInfo p_loginCallback_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void getIngestServersCallback(ErrorCode p_getIngestServersCallback_1_, IngestList p_getIngestServersCallback_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void getUserInfoCallback(ErrorCode p_getUserInfoCallback_1_, UserInfo p_getUserInfoCallback_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void getStreamInfoCallback(ErrorCode p_getStreamInfoCallback_1_, StreamInfo p_getStreamInfoCallback_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void getArchivingStateCallback(ErrorCode p_getArchivingStateCallback_1_, ArchivingState p_getArchivingStateCallback_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void runCommercialCallback(ErrorCode p_runCommercialCallback_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStreamInfoCallback(ErrorCode p_setStreamInfoCallback_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void getGameNameListCallback(ErrorCode p_getGameNameListCallback_1_, GameInfoList p_getGameNameListCallback_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void bufferUnlockCallback(long p_bufferUnlockCallback_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void startCallback(ErrorCode p_startCallback_1_) {
/* 167 */     this.field_153067_y = false;
/*     */ 
/*     */     
/* 170 */     if (ErrorCode.succeeded(p_startCallback_1_)) {
/*     */       
/* 172 */       func_153034_a(IngestTestState.ConnectingToServer);
/*     */       
/* 174 */       this.field_153054_l = System.currentTimeMillis();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 179 */       this.field_153056_n = false;
/* 180 */       func_153034_a(IngestTestState.DoneTestingServer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopCallback(ErrorCode p_stopCallback_1_) {
/* 186 */     this.field_153067_y = false;
/*     */     
/* 188 */     func_153034_a(IngestTestState.DoneTestingServer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendActionMetaDataCallback(ErrorCode p_sendActionMetaDataCallback_1_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendStartSpanMetaDataCallback(ErrorCode p_sendStartSpanMetaDataCallback_1_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendEndSpanMetaDataCallback(ErrorCode p_sendEndSpanMetaDataCallback_1_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void statCallback(StatType p_statCallback_1_, long p_statCallback_2_) {
/* 212 */     switch (SwitchStatType.field_153026_a[p_statCallback_1_.ordinal()]) {
/*     */       
/*     */       case 1:
/* 215 */         this.field_153051_i = RTMPState.lookupValue((int)p_statCallback_2_);
/*     */         break;
/*     */       
/*     */       case 2:
/* 219 */         this.field_153050_h = p_statCallback_2_;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IngestServerTester(Stream p_i1019_1_, IngestList p_i1019_2_) {
/* 229 */     this.field_153045_c = p_i1019_1_;
/* 230 */     this.field_153046_d = p_i1019_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 235 */     if (this.field_153059_q != null)
/*     */     {
/* 237 */       func_153035_b(this.field_153059_q);
/*     */     }
/*     */     
/* 240 */     func_153031_o();
/*     */     
/* 242 */     super.finalize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_153033_i() {
/* 251 */     if (this.field_153047_e != IngestTestState.Uninitalized) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 256 */     this.field_153062_t = 0;
/* 257 */     this.field_153060_r = false;
/* 258 */     this.field_153061_s = false;
/*     */     
/* 260 */     this.field_153058_p = this.field_153045_c.getStatCallbacks();
/* 261 */     this.field_153045_c.setStatCallbacks(this);
/*     */     
/* 263 */     this.field_153057_o = this.field_153045_c.getStreamCallbacks();
/* 264 */     this.field_153045_c.setStreamCallbacks(this);
/*     */     
/* 266 */     this.field_153052_j = new VideoParams();
/* 267 */     this.field_153052_j.targetFps = 60;
/* 268 */     this.field_153052_j.maxKbps = 3500;
/* 269 */     this.field_153052_j.outputWidth = 1280;
/* 270 */     this.field_153052_j.outputHeight = 720;
/* 271 */     this.field_153052_j.pixelFormat = PixelFormat.TTV_PF_BGRA;
/* 272 */     this.field_153052_j.encodingCpuUsage = EncodingCpuUsage.TTV_ECU_HIGH;
/* 273 */     this.field_153052_j.disableAdaptiveBitrate = true;
/* 274 */     this.field_153052_j.verticalFlip = false;
/*     */     
/* 276 */     this.field_153045_c.getDefaultParams(this.field_153052_j);
/*     */     
/* 278 */     this.field_153053_k = new AudioParams();
/* 279 */     this.field_153053_k.audioEnabled = false;
/*     */     
/* 281 */     this.field_153055_m = new ArrayList();
/*     */ 
/*     */     
/* 284 */     byte b1 = 3;
/*     */     
/* 286 */     for (byte b2 = 0; b2 < b1; b2++) {
/*     */       
/* 288 */       FrameBuffer frameBuffer = this.field_153045_c.allocateFrameBuffer(this.field_153052_j.outputWidth * this.field_153052_j.outputHeight * 4);
/* 289 */       if (!frameBuffer.getIsValid()) {
/*     */         
/* 291 */         func_153031_o();
/* 292 */         func_153034_a(IngestTestState.Failed);
/*     */         
/*     */         return;
/*     */       } 
/* 296 */       this.field_153055_m.add(frameBuffer);
/*     */       
/* 298 */       this.field_153045_c.randomizeFrameBuffer(frameBuffer);
/*     */     } 
/*     */     
/* 301 */     func_153034_a(IngestTestState.Starting);
/*     */     
/* 303 */     this.field_153054_l = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_153041_j() {
/* 311 */     if (func_153032_e() || this.field_153047_e == IngestTestState.Uninitalized) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 316 */     if (this.field_153067_y) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 321 */     if (this.field_153060_r)
/*     */     {
/* 323 */       func_153034_a(IngestTestState.Cancelled);
/*     */     }
/*     */     
/* 326 */     switch (SwitchStatType.field_153027_b[this.field_153047_e.ordinal()]) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/*     */       case 2:
/* 332 */         if (this.field_153059_q != null) {
/*     */           
/* 334 */           if (this.field_153061_s || !this.field_153056_n) {
/*     */             
/* 336 */             this.field_153059_q.bitrateKbps = 0.0F;
/* 337 */             this.field_153054_l = 0L;
/* 338 */             this.field_153067_y = false;
/*     */           }
/*     */           else {
/*     */             
/* 342 */             func_153035_b(this.field_153059_q);
/*     */           } 
/* 344 */           this.field_153059_q = null;
/*     */           break;
/*     */         } 
/* 347 */         if (!this.field_153067_y && func_153037_m() >= this.field_153049_g) {
/*     */ 
/*     */           
/* 350 */           this.field_153054_l = 0L;
/*     */           
/* 352 */           this.field_153061_s = false;
/* 353 */           this.field_153056_n = true;
/*     */           
/* 355 */           if (this.field_153047_e != IngestTestState.Starting)
/*     */           {
/* 357 */             this.field_153062_t++;
/*     */           }
/*     */ 
/*     */           
/* 361 */           if (this.field_153062_t < (this.field_153046_d.getServers()).length) {
/*     */             
/* 363 */             this.field_153059_q = this.field_153046_d.getServers()[this.field_153062_t];
/* 364 */             func_153036_a(this.field_153059_q);
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/* 369 */           func_153034_a(IngestTestState.Finished);
/*     */         } 
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/*     */       case 4:
/* 377 */         func_153029_c(this.field_153059_q);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 386 */     func_153038_n();
/*     */ 
/*     */     
/* 389 */     if (this.field_153047_e == IngestTestState.Cancelled || this.field_153047_e == IngestTestState.Finished) {
/*     */       
/* 391 */       if (this.field_153059_q != null) {
/*     */         
/* 393 */         if (this.field_153047_e == IngestTestState.Cancelled)
/*     */         {
/* 395 */           this.field_153059_q.bitrateKbps = 0.0F;
/*     */         }
/*     */         
/* 398 */         func_153035_b(this.field_153059_q);
/* 399 */         this.field_153059_q = null;
/*     */       } 
/*     */       
/* 402 */       if (this.field_153055_m != null)
/*     */       {
/* 404 */         func_153031_o();
/*     */       }
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static interface IngestTestListener
/*     */   {
/*     */     void func_152907_a(IngestServerTester param1IngestServerTester, IngestServerTester.IngestTestState param1IngestTestState);
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
/*     */   public void func_153039_l() {
/* 435 */     if (func_153032_e()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 440 */     this.field_153060_r = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_153036_a(IngestServer p_153036_1_) {
/* 446 */     this.field_153056_n = true;
/* 447 */     this.field_153050_h = 0L;
/* 448 */     this.field_153051_i = RTMPState.Idle;
/* 449 */     this.field_153059_q = p_153036_1_;
/*     */ 
/*     */     
/* 452 */     func_153034_a(IngestTestState.ConnectingToServer);
/* 453 */     this.field_153067_y = true;
/* 454 */     ErrorCode errorCode = this.field_153045_c.start(this.field_153052_j, this.field_153053_k, p_153036_1_, StartFlags.TTV_Start_BandwidthTest, true);
/* 455 */     if (ErrorCode.failed(errorCode)) {
/*     */       
/* 457 */       this.field_153056_n = false;
/* 458 */       func_153034_a(IngestTestState.DoneTestingServer);
/* 459 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 463 */     this.field_153064_v = this.field_153050_h;
/*     */     
/* 465 */     p_153036_1_.bitrateKbps = 0.0F;
/* 466 */     this.field_153063_u = 0;
/*     */     
/* 468 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_153035_b(IngestServer p_153035_1_) {
/* 473 */     this.field_153067_y = true;
/* 474 */     this.field_153045_c.stop(true);
/*     */     
/* 476 */     this.field_153045_c.pollStats();
/*     */   }
/*     */ 
/*     */   
/*     */   protected long func_153037_m() {
/* 481 */     return System.currentTimeMillis() - this.field_153054_l;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_153038_n() {
/* 486 */     float f = (float)func_153037_m();
/*     */     
/* 488 */     switch (SwitchStatType.field_153027_b[this.field_153047_e.ordinal()]) {
/*     */ 
/*     */       
/*     */       case 1:
/*     */       case 3:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 497 */         this.field_153066_x = 0.0F;
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/* 502 */         this.field_153066_x = 1.0F;
/*     */         break;
/*     */ 
/*     */       
/*     */       default:
/* 507 */         this.field_153066_x = f / (float)this.field_153048_f;
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 512 */     switch (SwitchStatType.field_153027_b[this.field_153047_e.ordinal()]) {
/*     */ 
/*     */       
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 518 */         this.field_153065_w = 1.0F;
/*     */         return;
/*     */     } 
/*     */ 
/*     */     
/* 523 */     this.field_153065_w = this.field_153062_t / (this.field_153046_d.getServers()).length;
/* 524 */     this.field_153065_w += this.field_153066_x / (this.field_153046_d.getServers()).length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_153029_c(IngestServer p_153029_1_) {
/* 532 */     if (this.field_153061_s || func_153037_m() >= this.field_153048_f) {
/*     */       
/* 534 */       func_153034_a(IngestTestState.DoneTestingServer);
/* 535 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 539 */     if (this.field_153067_y)
/*     */     {
/* 541 */       return true;
/*     */     }
/*     */     
/* 544 */     ErrorCode errorCode = this.field_153045_c.submitVideoFrame(this.field_153055_m.get(this.field_153063_u));
/* 545 */     if (ErrorCode.failed(errorCode)) {
/*     */       
/* 547 */       this.field_153056_n = false;
/* 548 */       func_153034_a(IngestTestState.DoneTestingServer);
/* 549 */       return false;
/*     */     } 
/*     */     
/* 552 */     this.field_153063_u = (this.field_153063_u + 1) % this.field_153055_m.size();
/*     */     
/* 554 */     this.field_153045_c.pollStats();
/*     */ 
/*     */     
/* 557 */     if (this.field_153051_i == RTMPState.SendVideo) {
/*     */       
/* 559 */       func_153034_a(IngestTestState.TestingServer);
/*     */       
/* 561 */       long l = func_153037_m();
/* 562 */       if (l > 0L && this.field_153050_h > this.field_153064_v) {
/*     */         
/* 564 */         p_153029_1_.bitrateKbps = (float)(this.field_153050_h * 8L) / (float)func_153037_m();
/* 565 */         this.field_153064_v = this.field_153050_h;
/*     */       } 
/*     */     } 
/*     */     
/* 569 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_153031_o() {
/* 574 */     this.field_153059_q = null;
/*     */ 
/*     */     
/* 577 */     if (this.field_153055_m != null) {
/*     */       
/* 579 */       for (byte b = 0; b < this.field_153055_m.size(); b++)
/*     */       {
/* 581 */         ((FrameBuffer)this.field_153055_m.get(b)).free();
/*     */       }
/*     */       
/* 584 */       this.field_153055_m = null;
/*     */     } 
/*     */     
/* 587 */     if (this.field_153045_c.getStatCallbacks() == this) {
/*     */       
/* 589 */       this.field_153045_c.setStatCallbacks(this.field_153058_p);
/* 590 */       this.field_153058_p = null;
/*     */     } 
/*     */     
/* 593 */     if (this.field_153045_c.getStreamCallbacks() == this) {
/*     */       
/* 595 */       this.field_153045_c.setStreamCallbacks(this.field_153057_o);
/* 596 */       this.field_153057_o = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_153034_a(IngestTestState p_153034_1_) {
/* 602 */     if (p_153034_1_ == this.field_153047_e) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 607 */     this.field_153047_e = p_153034_1_;
/*     */     
/* 609 */     if (this.field_153044_b != null)
/*     */     {
/* 611 */       this.field_153044_b.func_152907_a(this, p_153034_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_153028_p() {
/* 616 */     return this.field_153062_t;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\stream\IngestServerTester.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */