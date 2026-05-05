/*     */ package net.minecraft.client.gui.stream;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.stream.IStream;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import tv.twitch.chat.ChatUserInfo;
/*     */ import tv.twitch.chat.ChatUserMode;
/*     */ import tv.twitch.chat.ChatUserSubscription;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiTwitchUserMode
/*     */   extends GuiScreen
/*     */ {
/*  26 */   private static final EnumChatFormatting field_152331_a = EnumChatFormatting.DARK_GREEN;
/*  27 */   private static final EnumChatFormatting field_152335_f = EnumChatFormatting.RED;
/*  28 */   private static final EnumChatFormatting field_152336_g = EnumChatFormatting.DARK_PURPLE;
/*     */   
/*     */   private final ChatUserInfo field_152337_h;
/*     */   
/*     */   private final IChatComponent field_152338_i;
/*  33 */   private final List field_152332_r = Lists.newArrayList();
/*     */   
/*     */   private final IStream field_152333_s;
/*     */   
/*     */   public GuiTwitchUserMode(IStream p_i1064_1_, ChatUserInfo p_i1064_2_) {
/*  38 */     this.field_152333_s = p_i1064_1_;
/*  39 */     this.field_152337_h = p_i1064_2_;
/*     */     
/*  41 */     this.field_152338_i = (IChatComponent)new ChatComponentText(p_i1064_2_.displayName);
/*     */     
/*  43 */     this.field_152332_r.addAll(func_152328_a(p_i1064_2_.modes, p_i1064_2_.subscriptions, p_i1064_1_));
/*     */   }
/*     */   private int field_152334_t; private static final String __OBFID = "CL_00001837";
/*     */   public static List func_152328_a(Set p_152328_0_, Set p_152328_1_, IStream p_152328_2_) {
/*  47 */     String str = (p_152328_2_ == null) ? null : p_152328_2_.func_152921_C();
/*  48 */     boolean bool = (p_152328_2_ != null && p_152328_2_.func_152927_B()) ? true : false;
/*  49 */     ArrayList<ChatComponentText> arrayList = Lists.newArrayList();
/*     */     
/*  51 */     for (ChatUserMode chatUserMode : p_152328_0_) {
/*  52 */       IChatComponent iChatComponent = func_152329_a(chatUserMode, str, bool);
/*     */       
/*  54 */       if (iChatComponent != null) {
/*  55 */         ChatComponentText chatComponentText = new ChatComponentText("- ");
/*  56 */         chatComponentText.func_150257_a(iChatComponent);
/*  57 */         arrayList.add(chatComponentText);
/*     */       } 
/*     */     } 
/*     */     
/*  61 */     for (ChatUserSubscription chatUserSubscription : p_152328_1_) {
/*  62 */       IChatComponent iChatComponent = func_152330_a(chatUserSubscription, str, bool);
/*     */       
/*  64 */       if (iChatComponent != null) {
/*  65 */         ChatComponentText chatComponentText = new ChatComponentText("- ");
/*  66 */         chatComponentText.func_150257_a(iChatComponent);
/*  67 */         arrayList.add(chatComponentText);
/*     */       } 
/*     */     } 
/*     */     
/*  71 */     return arrayList;
/*     */   }
/*     */   
/*     */   public static IChatComponent func_152330_a(ChatUserSubscription p_152330_0_, String p_152330_1_, boolean p_152330_2_) {
/*  75 */     ChatComponentTranslation chatComponentTranslation = null;
/*     */     
/*  77 */     if (p_152330_0_ == ChatUserSubscription.TTV_CHAT_USERSUB_SUBSCRIBER) {
/*  78 */       if (p_152330_1_ == null) {
/*  79 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.subscription.subscriber", new Object[0]);
/*  80 */       } else if (p_152330_2_) {
/*  81 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.subscription.subscriber.self", new Object[0]);
/*     */       } else {
/*  83 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.subscription.subscriber.other", new Object[] { p_152330_1_ });
/*     */       } 
/*  85 */       chatComponentTranslation.func_150256_b().func_150238_a(field_152331_a);
/*  86 */     } else if (p_152330_0_ == ChatUserSubscription.TTV_CHAT_USERSUB_TURBO) {
/*  87 */       chatComponentTranslation = new ChatComponentTranslation("stream.user.subscription.turbo", new Object[0]);
/*  88 */       chatComponentTranslation.func_150256_b().func_150238_a(field_152336_g);
/*     */     } 
/*     */     
/*  91 */     return (IChatComponent)chatComponentTranslation;
/*     */   }
/*     */   
/*     */   public static IChatComponent func_152329_a(ChatUserMode p_152329_0_, String p_152329_1_, boolean p_152329_2_) {
/*  95 */     ChatComponentTranslation chatComponentTranslation = null;
/*     */     
/*  97 */     if (p_152329_0_ == ChatUserMode.TTV_CHAT_USERMODE_ADMINSTRATOR) {
/*  98 */       chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.administrator", new Object[0]);
/*  99 */       chatComponentTranslation.func_150256_b().func_150238_a(field_152336_g);
/* 100 */     } else if (p_152329_0_ == ChatUserMode.TTV_CHAT_USERMODE_BANNED) {
/* 101 */       if (p_152329_1_ == null) {
/* 102 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.banned", new Object[0]);
/* 103 */       } else if (p_152329_2_) {
/* 104 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.banned.self", new Object[0]);
/*     */       } else {
/* 106 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.banned.other", new Object[] { p_152329_1_ });
/*     */       } 
/* 108 */       chatComponentTranslation.func_150256_b().func_150238_a(field_152335_f);
/* 109 */     } else if (p_152329_0_ == ChatUserMode.TTV_CHAT_USERMODE_BROADCASTER) {
/* 110 */       if (p_152329_1_ == null) {
/* 111 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.broadcaster", new Object[0]);
/* 112 */       } else if (p_152329_2_) {
/* 113 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.broadcaster.self", new Object[0]);
/*     */       } else {
/* 115 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.broadcaster.other", new Object[0]);
/*     */       } 
/* 117 */       chatComponentTranslation.func_150256_b().func_150238_a(field_152331_a);
/* 118 */     } else if (p_152329_0_ == ChatUserMode.TTV_CHAT_USERMODE_MODERATOR) {
/* 119 */       if (p_152329_1_ == null) {
/* 120 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.moderator", new Object[0]);
/* 121 */       } else if (p_152329_2_) {
/* 122 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.moderator.self", new Object[0]);
/*     */       } else {
/* 124 */         chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.moderator.other", new Object[] { p_152329_1_ });
/*     */       } 
/* 126 */       chatComponentTranslation.func_150256_b().func_150238_a(field_152331_a);
/* 127 */     } else if (p_152329_0_ == ChatUserMode.TTV_CHAT_USERMODE_STAFF) {
/* 128 */       chatComponentTranslation = new ChatComponentTranslation("stream.user.mode.staff", new Object[0]);
/* 129 */       chatComponentTranslation.func_150256_b().func_150238_a(field_152336_g);
/*     */     } 
/*     */     
/* 132 */     return (IChatComponent)chatComponentTranslation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 138 */     int i = this.field_146294_l / 3;
/* 139 */     int j = i - 130;
/* 140 */     this.field_146292_n.add(new GuiButton(1, i * 0 + j / 2, this.field_146295_m - 70, 130, 20, I18n.func_135052_a("stream.userinfo.timeout", new Object[0])));
/* 141 */     this.field_146292_n.add(new GuiButton(0, i * 1 + j / 2, this.field_146295_m - 70, 130, 20, I18n.func_135052_a("stream.userinfo.ban", new Object[0])));
/* 142 */     this.field_146292_n.add(new GuiButton(2, i * 2 + j / 2, this.field_146295_m - 70, 130, 20, I18n.func_135052_a("stream.userinfo.mod", new Object[0])));
/*     */     
/* 144 */     this.field_146292_n.add(new GuiButton(5, i * 0 + j / 2, this.field_146295_m - 45, 130, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/* 145 */     this.field_146292_n.add(new GuiButton(3, i * 1 + j / 2, this.field_146295_m - 45, 130, 20, I18n.func_135052_a("stream.userinfo.unban", new Object[0])));
/* 146 */     this.field_146292_n.add(new GuiButton(4, i * 2 + j / 2, this.field_146295_m - 45, 130, 20, I18n.func_135052_a("stream.userinfo.unmod", new Object[0])));
/*     */     
/* 148 */     int k = 0;
/* 149 */     for (IChatComponent iChatComponent : this.field_152332_r) {
/* 150 */       k = Math.max(k, this.field_146289_q.func_78256_a(iChatComponent.func_150254_d()));
/*     */     }
/* 152 */     this.field_152334_t = this.field_146294_l / 2 - k / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 157 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/* 159 */     if (p_146284_1_.field_146127_k == 0) {
/* 160 */       this.field_152333_s.func_152917_b("/ban " + this.field_152337_h.displayName);
/* 161 */     } else if (p_146284_1_.field_146127_k == 3) {
/* 162 */       this.field_152333_s.func_152917_b("/unban " + this.field_152337_h.displayName);
/* 163 */     } else if (p_146284_1_.field_146127_k == 2) {
/* 164 */       this.field_152333_s.func_152917_b("/mod " + this.field_152337_h.displayName);
/* 165 */     } else if (p_146284_1_.field_146127_k == 4) {
/* 166 */       this.field_152333_s.func_152917_b("/unmod " + this.field_152337_h.displayName);
/* 167 */     } else if (p_146284_1_.field_146127_k == 1) {
/* 168 */       this.field_152333_s.func_152917_b("/timeout " + this.field_152337_h.displayName);
/*     */     } 
/*     */     
/* 171 */     this.field_146297_k.func_147108_a(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 176 */     func_146276_q_();
/*     */     
/* 178 */     func_73732_a(this.field_146289_q, this.field_152338_i.func_150260_c(), this.field_146294_l / 2, 70, 16777215);
/*     */     
/* 180 */     int i = 80;
/* 181 */     for (IChatComponent iChatComponent : this.field_152332_r) {
/* 182 */       func_73731_b(this.field_146289_q, iChatComponent.func_150254_d(), this.field_152334_t, i, 16777215);
/* 183 */       i += this.field_146289_q.field_78288_b;
/*     */     } 
/*     */     
/* 186 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\stream\GuiTwitchUserMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */