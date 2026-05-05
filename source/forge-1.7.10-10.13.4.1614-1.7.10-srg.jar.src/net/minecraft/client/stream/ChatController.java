/*     */ package net.minecraft.client.stream;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import tv.twitch.AuthToken;
/*     */ import tv.twitch.ErrorCode;
/*     */ import tv.twitch.chat.Chat;
/*     */ import tv.twitch.chat.ChatAPI;
/*     */ import tv.twitch.chat.ChatChannelInfo;
/*     */ import tv.twitch.chat.ChatEvent;
/*     */ import tv.twitch.chat.ChatMessage;
/*     */ import tv.twitch.chat.ChatMessageList;
/*     */ import tv.twitch.chat.ChatTokenizedMessage;
/*     */ import tv.twitch.chat.ChatUserInfo;
/*     */ import tv.twitch.chat.ChatUserList;
/*     */ import tv.twitch.chat.IChatCallbacks;
/*     */ import tv.twitch.chat.StandardChatAPI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ChatController
/*     */   implements IChatCallbacks
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   public enum ChatState
/*     */   {
/*  39 */     Uninitialized,
/*  40 */     Initialized,
/*  41 */     Connecting,
/*  42 */     Connected,
/*  43 */     Disconnected;
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
/*     */     private static final String __OBFID = "CL_00001817";
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
/*     */ 
/*     */   
/*  99 */   private static final Logger field_153018_p = LogManager.getLogger();
/*     */ 
/*     */ 
/*     */   
/* 103 */   protected ChatListener field_153003_a = null;
/*     */   
/* 105 */   protected String field_153004_b = "";
/* 106 */   protected String field_153005_c = "";
/*     */   
/* 108 */   protected String field_153006_d = "";
/* 109 */   protected String field_153007_e = "";
/* 110 */   protected Chat field_153008_f = null;
/*     */   
/*     */   protected boolean field_153009_g = false;
/*     */   protected boolean field_153010_h = false;
/* 114 */   protected ChatState field_153011_i = ChatState.Uninitialized;
/* 115 */   protected AuthToken field_153012_j = new AuthToken();
/*     */   
/* 117 */   protected List field_153013_k = new ArrayList();
/* 118 */   protected LinkedList field_153014_l = new LinkedList();
/* 119 */   protected int field_153015_m = 128;
/*     */ 
/*     */   
/*     */   protected boolean field_153016_n = false;
/*     */ 
/*     */   
/*     */   protected boolean field_153017_o = false;
/*     */   
/*     */   private static final String __OBFID = "CL_00001819";
/*     */ 
/*     */   
/*     */   public void chatStatusCallback(ErrorCode p_chatStatusCallback_1_) {
/* 131 */     if (ErrorCode.succeeded(p_chatStatusCallback_1_)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 136 */     this.field_153011_i = ChatState.Disconnected;
/*     */   }
/*     */ 
/*     */   
/*     */   public void chatChannelMembershipCallback(ChatEvent p_chatChannelMembershipCallback_1_, ChatChannelInfo p_chatChannelMembershipCallback_2_) {
/* 141 */     switch (SwitchChatState.field_152982_a[p_chatChannelMembershipCallback_1_.ordinal()]) {
/*     */ 
/*     */       
/*     */       case 1:
/* 145 */         this.field_153011_i = ChatState.Connected;
/* 146 */         func_152999_p();
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/* 151 */         this.field_153011_i = ChatState.Disconnected;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void chatChannelUserChangeCallback(ChatUserList p_chatChannelUserChangeCallback_1_, ChatUserList p_chatChannelUserChangeCallback_2_, ChatUserList p_chatChannelUserChangeCallback_3_) {
/*     */     byte b;
/* 163 */     for (b = 0; b < p_chatChannelUserChangeCallback_2_.userList.length; b++) {
/*     */       
/* 165 */       int i = this.field_153013_k.indexOf(p_chatChannelUserChangeCallback_2_.userList[b]);
/* 166 */       if (i >= 0)
/*     */       {
/* 168 */         this.field_153013_k.remove(i);
/*     */       }
/*     */     } 
/*     */     
/* 172 */     for (b = 0; b < p_chatChannelUserChangeCallback_3_.userList.length; b++) {
/*     */ 
/*     */       
/* 175 */       int i = this.field_153013_k.indexOf(p_chatChannelUserChangeCallback_3_.userList[b]);
/* 176 */       if (i >= 0)
/*     */       {
/* 178 */         this.field_153013_k.remove(i);
/*     */       }
/*     */       
/* 181 */       this.field_153013_k.add(p_chatChannelUserChangeCallback_3_.userList[b]);
/*     */     } 
/*     */     
/* 184 */     for (b = 0; b < p_chatChannelUserChangeCallback_1_.userList.length; b++)
/*     */     {
/* 186 */       this.field_153013_k.add(p_chatChannelUserChangeCallback_1_.userList[b]);
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 191 */       if (this.field_153003_a != null)
/*     */       {
/* 193 */         this.field_153003_a.func_152904_a(p_chatChannelUserChangeCallback_1_.userList, p_chatChannelUserChangeCallback_2_.userList, p_chatChannelUserChangeCallback_3_.userList);
/*     */       }
/*     */     }
/* 196 */     catch (Exception exception) {
/*     */       
/* 198 */       func_152995_h(exception.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void chatQueryChannelUsersCallback(ChatUserList p_chatQueryChannelUsersCallback_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void chatChannelMessageCallback(ChatMessageList p_chatChannelMessageCallback_1_) {
/* 209 */     for (byte b = 0; b < p_chatChannelMessageCallback_1_.messageList.length; b++)
/*     */     {
/* 211 */       this.field_153014_l.addLast(p_chatChannelMessageCallback_1_.messageList[b]);
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
/*     */     
/*     */     try {
/* 245 */       if (this.field_153003_a != null)
/*     */       {
/* 247 */         this.field_153003_a.func_152903_a(p_chatChannelMessageCallback_1_.messageList);
/*     */       
/*     */       }
/*     */     }
/* 251 */     catch (Exception exception) {
/*     */       
/* 253 */       func_152995_h(exception.toString());
/*     */     } 
/*     */ 
/*     */     
/* 257 */     while (this.field_153014_l.size() > this.field_153015_m)
/*     */     {
/* 259 */       this.field_153014_l.removeFirst();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void chatClearCallback(String p_chatClearCallback_1_) {
/* 265 */     func_152987_o();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void emoticonDataDownloadCallback(ErrorCode p_emoticonDataDownloadCallback_1_) {
/* 271 */     if (ErrorCode.succeeded(p_emoticonDataDownloadCallback_1_))
/*     */     {
/* 273 */       func_152988_s();
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
/*     */   public void chatChannelTokenizedMessageCallback(ChatTokenizedMessage[] p_chatChannelTokenizedMessageCallback_1_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152990_a(ChatListener p_152990_1_) {
/* 293 */     this.field_153003_a = p_152990_1_;
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
/*     */   public boolean func_152991_c() {
/* 311 */     return (this.field_153011_i == ChatState.Connected);
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
/*     */   public void func_152994_a(AuthToken p_152994_1_) {
/* 337 */     this.field_153012_j = p_152994_1_;
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
/*     */   public void func_152984_a(String p_152984_1_) {
/* 354 */     this.field_153006_d = p_152984_1_;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152998_c(String p_152998_1_) {
/* 388 */     this.field_153004_b = p_152998_1_;
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
/*     */   public ChatState func_153000_j() {
/* 414 */     return this.field_153011_i;
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
/*     */   public ChatController() {
/* 441 */     this.field_153008_f = new Chat((ChatAPI)new StandardChatAPI());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_152986_d(String p_152986_1_) {
/* 451 */     func_153002_l();
/*     */     
/* 453 */     this.field_153010_h = false;
/* 454 */     this.field_153005_c = p_152986_1_;
/*     */     
/* 456 */     return func_152985_f(p_152986_1_);
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
/*     */   public boolean func_153002_l() {
/* 480 */     if (this.field_153011_i == ChatState.Connected || this.field_153011_i == ChatState.Connecting) {
/*     */ 
/*     */       
/* 483 */       ErrorCode errorCode = this.field_153008_f.disconnect();
/* 484 */       if (ErrorCode.failed(errorCode)) {
/*     */         
/* 486 */         String str = ErrorCode.getString(errorCode);
/* 487 */         func_152995_h(String.format("Error disconnecting: %s", new Object[] { str }));
/*     */         
/* 489 */         return false;
/*     */       } 
/*     */       
/* 492 */       func_152989_q();
/*     */     }
/* 494 */     else if (this.field_153011_i == ChatState.Disconnected) {
/*     */       
/* 496 */       func_152989_q();
/*     */     } 
/*     */     
/* 499 */     return func_152993_m();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_152985_f(String p_152985_1_) {
/* 504 */     if (this.field_153009_g)
/*     */     {
/* 506 */       return false;
/*     */     }
/*     */     
/* 509 */     ErrorCode errorCode = this.field_153008_f.initialize(p_152985_1_, false);
/* 510 */     if (ErrorCode.failed(errorCode)) {
/*     */       
/* 512 */       String str = ErrorCode.getString(errorCode);
/* 513 */       func_152995_h(String.format("Error initializing chat: %s", new Object[] { str }));
/*     */       
/* 515 */       func_152989_q();
/*     */       
/* 517 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 521 */     this.field_153009_g = true;
/* 522 */     this.field_153008_f.setChatCallbacks(this);
/* 523 */     this.field_153011_i = ChatState.Initialized;
/*     */     
/* 525 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_152993_m() {
/* 531 */     if (this.field_153009_g) {
/*     */       
/* 533 */       ErrorCode errorCode = this.field_153008_f.shutdown();
/* 534 */       if (ErrorCode.failed(errorCode)) {
/*     */         
/* 536 */         String str = ErrorCode.getString(errorCode);
/* 537 */         func_152995_h(String.format("Error shutting down chat: %s", new Object[] { str }));
/*     */         
/* 539 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 543 */     this.field_153011_i = ChatState.Uninitialized;
/* 544 */     this.field_153009_g = false;
/*     */     
/* 546 */     func_152996_t();
/*     */     
/* 548 */     this.field_153008_f.setChatCallbacks(null);
/*     */     
/* 550 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152997_n() {
/* 558 */     if (!this.field_153009_g) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 563 */     ErrorCode errorCode = this.field_153008_f.flushEvents();
/* 564 */     if (ErrorCode.failed(errorCode)) {
/*     */       
/* 566 */       String str = ErrorCode.getString(errorCode);
/* 567 */       func_152995_h(String.format("Error flushing chat events: %s", new Object[] { str }));
/*     */     } 
/*     */     
/* 570 */     switch (SwitchChatState.field_152983_b[this.field_153011_i.ordinal()]) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 579 */         if (this.field_153010_h) {
/*     */           
/* 581 */           errorCode = this.field_153008_f.connectAnonymous();
/*     */         }
/*     */         else {
/*     */           
/* 585 */           errorCode = this.field_153008_f.connect(this.field_153005_c, this.field_153012_j.data);
/*     */         } 
/*     */         
/* 588 */         if (ErrorCode.failed(errorCode)) {
/*     */           
/* 590 */           String str = ErrorCode.getString(errorCode);
/* 591 */           func_152995_h(String.format("Error connecting: %s", new Object[] { str }));
/*     */           
/* 593 */           func_152993_m();
/*     */           
/* 595 */           func_152989_q();
/*     */           
/*     */           break;
/*     */         } 
/* 599 */         this.field_153011_i = ChatState.Connecting;
/* 600 */         func_153001_r();
/*     */         break;
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
/*     */       case 5:
/* 615 */         func_153002_l();
/*     */         break;
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
/*     */   public boolean func_152992_g(String p_152992_1_) {
/* 628 */     if (this.field_153011_i != ChatState.Connected)
/*     */     {
/* 630 */       return false;
/*     */     }
/*     */     
/* 633 */     ErrorCode errorCode = this.field_153008_f.sendMessage(p_152992_1_);
/* 634 */     if (ErrorCode.failed(errorCode)) {
/*     */       
/* 636 */       String str = ErrorCode.getString(errorCode);
/* 637 */       func_152995_h(String.format("Error sending chat message: %s", new Object[] { str }));
/*     */       
/* 639 */       return false;
/*     */     } 
/*     */     
/* 642 */     return true;
/*     */   } @SideOnly(Side.CLIENT)
/*     */   public static interface ChatListener {
/*     */     void func_152903_a(ChatMessage[] param1ArrayOfChatMessage); void func_152904_a(ChatUserInfo[] param1ArrayOfChatUserInfo1, ChatUserInfo[] param1ArrayOfChatUserInfo2, ChatUserInfo[] param1ArrayOfChatUserInfo3);
/*     */     void func_152906_d();
/*     */     void func_152905_e();
/*     */     void func_152902_f(); }
/*     */   public void func_152987_o() {
/* 650 */     this.field_153014_l.clear();
/*     */ 
/*     */     
/*     */     try {
/* 654 */       if (this.field_153003_a != null)
/*     */       {
/* 656 */         this.field_153003_a.func_152902_f();
/*     */       }
/*     */     }
/* 659 */     catch (Exception exception) {
/*     */       
/* 661 */       func_152995_h(exception.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_152999_p() {
/*     */     try {
/* 671 */       if (this.field_153003_a != null)
/*     */       {
/* 673 */         this.field_153003_a.func_152906_d();
/*     */       }
/*     */     }
/* 676 */     catch (Exception exception) {
/*     */       
/* 678 */       func_152995_h(exception.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_152989_q() {
/*     */     try {
/* 686 */       if (this.field_153003_a != null)
/*     */       {
/* 688 */         this.field_153003_a.func_152905_e();
/*     */       }
/*     */     }
/* 691 */     catch (Exception exception) {
/*     */       
/* 693 */       func_152995_h(exception.toString());
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
/*     */   protected void func_153001_r() {}
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
/*     */   protected void func_152988_s() {}
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
/*     */   protected void func_152996_t() {}
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
/*     */   protected void func_152995_h(String p_152995_1_) {
/* 755 */     field_153018_p.error(TwitchStream.field_152949_a, "[Chat controller] {}", new Object[] { p_152995_1_ });
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\stream\ChatController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */