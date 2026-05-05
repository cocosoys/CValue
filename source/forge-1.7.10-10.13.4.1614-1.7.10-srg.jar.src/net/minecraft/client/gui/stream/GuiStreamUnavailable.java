/*     */ package net.minecraft.client.gui.stream;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.stream.IStream;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.Session;
/*     */ import net.minecraft.util.Util;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GLContext;
/*     */ import tv.twitch.ErrorCode;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiStreamUnavailable extends GuiScreen {
/*  25 */   private static final Logger field_152322_a = LogManager.getLogger();
/*     */ 
/*     */ 
/*     */   
/*  29 */   private final IChatComponent field_152324_f = (IChatComponent)new ChatComponentTranslation("stream.unavailable.title", new Object[0]);
/*     */   private final GuiScreen field_152325_g;
/*     */   private final Reason field_152326_h;
/*     */   private final List field_152327_i;
/*  33 */   private final List field_152323_r = Lists.newArrayList(); private static final String __OBFID = "CL_00001840";
/*     */   
/*     */   public GuiStreamUnavailable(GuiScreen p_i1070_1_, Reason p_i1070_2_) {
/*  36 */     this(p_i1070_1_, p_i1070_2_, (List)null);
/*     */   }
/*     */   
/*     */   public GuiStreamUnavailable(GuiScreen p_i1071_1_, Reason p_i1071_2_, List p_i1071_3_) {
/*  40 */     this.field_152325_g = p_i1071_1_;
/*  41 */     this.field_152326_h = p_i1071_2_;
/*  42 */     this.field_152327_i = p_i1071_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  47 */     if (this.field_152323_r.isEmpty()) {
/*  48 */       this.field_152323_r.addAll(this.field_146289_q.func_78271_c(this.field_152326_h.func_152561_a().func_150254_d(), (int)(this.field_146294_l * 0.75F)));
/*     */       
/*  50 */       if (this.field_152327_i != null) {
/*  51 */         this.field_152323_r.add("");
/*  52 */         for (ChatComponentTranslation chatComponentTranslation : this.field_152327_i) {
/*  53 */           this.field_152323_r.add(chatComponentTranslation.func_150261_e());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  58 */     if (this.field_152326_h.func_152559_b() != null) {
/*  59 */       this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 155, this.field_146295_m - 50, 150, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*  60 */       this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 155 + 160, this.field_146295_m - 50, 150, 20, I18n.func_135052_a(this.field_152326_h.func_152559_b().func_150254_d(), new Object[0])));
/*     */     } else {
/*  62 */       this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 75, this.field_146295_m - 50, 150, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146281_b() {}
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  72 */     func_146276_q_();
/*     */     
/*  74 */     int i = Math.max((int)(this.field_146295_m * 0.85D / 2.0D - ((this.field_152323_r.size() * this.field_146289_q.field_78288_b) / 2.0F)), 50);
/*  75 */     func_73732_a(this.field_146289_q, this.field_152324_f.func_150254_d(), this.field_146294_l / 2, i - this.field_146289_q.field_78288_b * 2, 16777215);
/*     */     
/*  77 */     for (String str : this.field_152323_r) {
/*  78 */       func_73732_a(this.field_146289_q, str, this.field_146294_l / 2, i, 10526880);
/*  79 */       i += this.field_146289_q.field_78288_b;
/*     */     } 
/*     */     
/*  82 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  87 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  89 */     if (p_146284_1_.field_146127_k == 1) {
/*  90 */       switch (SwitchReason.field_152577_a[this.field_152326_h.ordinal()]) {
/*     */         case 1:
/*     */         case 2:
/*  93 */           func_152320_a("https://account.mojang.com/me/settings");
/*     */           break;
/*     */         case 3:
/*  96 */           func_152320_a("https://account.mojang.com/migrate");
/*     */           break;
/*     */         case 4:
/*  99 */           func_152320_a("http://www.apple.com/osx/");
/*     */           break;
/*     */         case 5:
/*     */         case 6:
/*     */         case 7:
/* 104 */           func_152320_a("http://bugs.mojang.com/browse/MC");
/*     */           break;
/*     */       } 
/*     */     
/*     */     }
/* 109 */     this.field_146297_k.func_147108_a(this.field_152325_g);
/*     */   }
/*     */   
/*     */   private void func_152320_a(String p_152320_1_) {
/*     */     try {
/* 114 */       Class<?> clazz = Class.forName("java.awt.Desktop");
/* 115 */       Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
/* 116 */       clazz.getMethod("browse", new Class[] { URI.class }).invoke(object, new Object[] { new URI(p_152320_1_) });
/* 117 */     } catch (Throwable throwable) {
/* 118 */       field_152322_a.error("Couldn't open link", throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_152321_a(GuiScreen p_152321_0_) {
/* 123 */     Minecraft minecraft = Minecraft.func_71410_x();
/* 124 */     IStream iStream = minecraft.func_152346_Z();
/*     */     
/* 126 */     if (!OpenGlHelper.field_148823_f) {
/* 127 */       ArrayList<ChatComponentTranslation> arrayList = Lists.newArrayList();
/* 128 */       arrayList.add(new ChatComponentTranslation("stream.unavailable.no_fbo.version", new Object[] { GL11.glGetString(7938) }));
/* 129 */       arrayList.add(new ChatComponentTranslation("stream.unavailable.no_fbo.blend", new Object[] { Boolean.valueOf((GLContext.getCapabilities()).GL_EXT_blend_func_separate) }));
/* 130 */       arrayList.add(new ChatComponentTranslation("stream.unavailable.no_fbo.arb", new Object[] { Boolean.valueOf((GLContext.getCapabilities()).GL_ARB_framebuffer_object) }));
/* 131 */       arrayList.add(new ChatComponentTranslation("stream.unavailable.no_fbo.ext", new Object[] { Boolean.valueOf((GLContext.getCapabilities()).GL_EXT_framebuffer_object) }));
/*     */       
/* 133 */       minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.NO_FBO, arrayList));
/* 134 */     } else if (iStream instanceof NullStream) {
/* 135 */       if (((NullStream)iStream).func_152937_a().getMessage().contains("Can't load AMD 64-bit .dll on a IA 32-bit platform")) {
/* 136 */         minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.LIBRARY_ARCH_MISMATCH));
/*     */       } else {
/* 138 */         minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.LIBRARY_FAILURE));
/*     */       } 
/* 140 */     } else if (!iStream.func_152928_D() && iStream.func_152912_E() == ErrorCode.TTV_EC_OS_TOO_OLD) {
/* 141 */       switch (SwitchReason.field_152578_b[Util.func_110647_a().ordinal()]) {
/*     */         case 1:
/* 143 */           minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.UNSUPPORTED_OS_WINDOWS));
/*     */           return;
/*     */         case 2:
/* 146 */           minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.UNSUPPORTED_OS_MAC));
/*     */           return;
/*     */       } 
/* 149 */       minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.UNSUPPORTED_OS_OTHER));
/*     */     }
/* 151 */     else if (!minecraft.func_152341_N().containsKey("twitch_access_token")) {
/* 152 */       if (minecraft.func_110432_I().func_152428_f() == Session.Type.LEGACY) {
/* 153 */         minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.ACCOUNT_NOT_MIGRATED));
/*     */       } else {
/* 155 */         minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.ACCOUNT_NOT_BOUND));
/*     */       } 
/* 157 */     } else if (!iStream.func_152913_F()) {
/* 158 */       switch (SwitchReason.field_152579_c[iStream.func_152918_H().ordinal()]) {
/*     */         case 1:
/* 160 */           minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.FAILED_TWITCH_AUTH));
/*     */           return;
/*     */       } 
/*     */       
/* 164 */       minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.FAILED_TWITCH_AUTH_ERROR));
/*     */     }
/* 166 */     else if (iStream.func_152912_E() != null) {
/* 167 */       List<ChatComponentTranslation> list = Arrays.asList(new ChatComponentTranslation[] { new ChatComponentTranslation("stream.unavailable.initialization_failure.extra", new Object[] { ErrorCode.getString(iStream.func_152912_E()) }) });
/* 168 */       minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.INITIALIZATION_FAILURE, list));
/*     */     } else {
/* 170 */       minecraft.func_147108_a(new GuiStreamUnavailable(p_152321_0_, Reason.UNKNOWN));
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 175 */   public enum Reason { NO_FBO((String)new ChatComponentTranslation("stream.unavailable.no_fbo", new Object[0])),
/* 176 */     LIBRARY_ARCH_MISMATCH((String)new ChatComponentTranslation("stream.unavailable.library_arch_mismatch", new Object[0])),
/* 177 */     LIBRARY_FAILURE((String)new ChatComponentTranslation("stream.unavailable.library_failure", new Object[0]), new ChatComponentTranslation("stream.unavailable.report_to_mojang", new Object[0])),
/* 178 */     UNSUPPORTED_OS_WINDOWS((String)new ChatComponentTranslation("stream.unavailable.not_supported.windows", new Object[0])),
/* 179 */     UNSUPPORTED_OS_MAC((String)new ChatComponentTranslation("stream.unavailable.not_supported.mac", new Object[0]), new ChatComponentTranslation("stream.unavailable.not_supported.mac.okay", new Object[0])),
/* 180 */     UNSUPPORTED_OS_OTHER((String)new ChatComponentTranslation("stream.unavailable.not_supported.other", new Object[0])),
/* 181 */     ACCOUNT_NOT_MIGRATED((String)new ChatComponentTranslation("stream.unavailable.account_not_migrated", new Object[0]), new ChatComponentTranslation("stream.unavailable.account_not_migrated.okay", new Object[0])),
/* 182 */     ACCOUNT_NOT_BOUND((String)new ChatComponentTranslation("stream.unavailable.account_not_bound", new Object[0]), new ChatComponentTranslation("stream.unavailable.account_not_bound.okay", new Object[0])),
/* 183 */     FAILED_TWITCH_AUTH((String)new ChatComponentTranslation("stream.unavailable.failed_auth", new Object[0]), new ChatComponentTranslation("stream.unavailable.failed_auth.okay", new Object[0])),
/* 184 */     FAILED_TWITCH_AUTH_ERROR((String)new ChatComponentTranslation("stream.unavailable.failed_auth_error", new Object[0])),
/* 185 */     INITIALIZATION_FAILURE((String)new ChatComponentTranslation("stream.unavailable.initialization_failure", new Object[0]), new ChatComponentTranslation("stream.unavailable.report_to_mojang", new Object[0])),
/* 186 */     UNKNOWN((String)new ChatComponentTranslation("stream.unavailable.unknown", new Object[0]), new ChatComponentTranslation("stream.unavailable.report_to_mojang", new Object[0]));
/*     */ 
/*     */     
/*     */     private final IChatComponent field_152574_m;
/*     */     
/*     */     private final IChatComponent field_152575_n;
/*     */     
/*     */     private static final String __OBFID = "CL_00001838";
/*     */ 
/*     */     
/*     */     Reason(IChatComponent p_i1067_3_, IChatComponent p_i1067_4_) {
/* 197 */       this.field_152574_m = p_i1067_3_;
/* 198 */       this.field_152575_n = p_i1067_4_;
/*     */     }
/*     */     
/*     */     public IChatComponent func_152561_a() {
/* 202 */       return this.field_152574_m;
/*     */     }
/*     */     
/*     */     public IChatComponent func_152559_b() {
/* 206 */       return this.field_152575_n;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\stream\GuiStreamUnavailable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */