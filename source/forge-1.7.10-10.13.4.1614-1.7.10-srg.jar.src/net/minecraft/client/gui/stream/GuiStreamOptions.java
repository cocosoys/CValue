/*     */ package net.minecraft.client.gui.stream;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiOptionButton;
/*     */ import net.minecraft.client.gui.GuiOptionSlider;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiStreamOptions extends GuiScreen {
/*  14 */   private static final GameSettings.Options[] field_152312_a = new GameSettings.Options[] { GameSettings.Options.STREAM_BYTES_PER_PIXEL, GameSettings.Options.STREAM_FPS, GameSettings.Options.STREAM_KBPS, GameSettings.Options.STREAM_SEND_METADATA, GameSettings.Options.STREAM_VOLUME_MIC, GameSettings.Options.STREAM_VOLUME_SYSTEM, GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR, GameSettings.Options.STREAM_COMPRESSION };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  19 */   private static final GameSettings.Options[] field_152316_f = new GameSettings.Options[] { GameSettings.Options.STREAM_CHAT_ENABLED, GameSettings.Options.STREAM_CHAT_USER_FILTER };
/*     */   
/*     */   private final GuiScreen field_152317_g;
/*     */   
/*     */   private final GameSettings field_152318_h;
/*     */   private String field_152319_i;
/*     */   private String field_152313_r;
/*     */   private int field_152314_s;
/*     */   private boolean field_152315_t = false;
/*     */   private static final String __OBFID = "CL_00001841";
/*     */   
/*     */   public GuiStreamOptions(GuiScreen p_i1073_1_, GameSettings p_i1073_2_) {
/*  31 */     this.field_152317_g = p_i1073_1_;
/*  32 */     this.field_152318_h = p_i1073_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  37 */     byte b = 0;
/*  38 */     this.field_152319_i = I18n.func_135052_a("options.stream.title", new Object[0]);
/*  39 */     this.field_152313_r = I18n.func_135052_a("options.stream.chat.title", new Object[0]);
/*     */     
/*  41 */     for (GameSettings.Options options : field_152312_a) {
/*  42 */       if (options.func_74380_a()) {
/*  43 */         this.field_146292_n.add(new GuiOptionSlider(options.func_74381_c(), this.field_146294_l / 2 - 155 + b % 2 * 160, this.field_146295_m / 6 + 24 * (b >> 1), options));
/*     */       } else {
/*  45 */         this.field_146292_n.add(new GuiOptionButton(options.func_74381_c(), this.field_146294_l / 2 - 155 + b % 2 * 160, this.field_146295_m / 6 + 24 * (b >> 1), options, this.field_152318_h.func_74297_c(options)));
/*     */       } 
/*     */       
/*  48 */       b++;
/*     */     } 
/*     */     
/*  51 */     if (b % 2 == 1) b++; 
/*  52 */     this.field_152314_s = this.field_146295_m / 6 + 24 * (b >> 1) + 6;
/*  53 */     b += 2;
/*     */     
/*  55 */     for (GameSettings.Options options : field_152316_f) {
/*  56 */       if (options.func_74380_a()) {
/*  57 */         this.field_146292_n.add(new GuiOptionSlider(options.func_74381_c(), this.field_146294_l / 2 - 155 + b % 2 * 160, this.field_146295_m / 6 + 24 * (b >> 1), options));
/*     */       } else {
/*  59 */         this.field_146292_n.add(new GuiOptionButton(options.func_74381_c(), this.field_146294_l / 2 - 155 + b % 2 * 160, this.field_146295_m / 6 + 24 * (b >> 1), options, this.field_152318_h.func_74297_c(options)));
/*     */       } 
/*     */       
/*  62 */       b++;
/*     */     } 
/*     */     
/*  65 */     this.field_146292_n.add(new GuiButton(200, this.field_146294_l / 2 - 155, this.field_146295_m / 6 + 168, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*  66 */     GuiButton guiButton = new GuiButton(201, this.field_146294_l / 2 + 5, this.field_146295_m / 6 + 168, 150, 20, I18n.func_135052_a("options.stream.ingestSelection", new Object[0]));
/*  67 */     guiButton.field_146124_l = ((this.field_146297_k.func_152346_Z().func_152924_m() && (this.field_146297_k.func_152346_Z().func_152925_v()).length > 0) || this.field_146297_k.func_152346_Z().func_152908_z());
/*  68 */     this.field_146292_n.add(guiButton);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  73 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  75 */     if (p_146284_1_.field_146127_k < 100 && p_146284_1_ instanceof GuiOptionButton) {
/*  76 */       GameSettings.Options options = ((GuiOptionButton)p_146284_1_).func_146136_c();
/*  77 */       this.field_152318_h.func_74306_a(options, 1);
/*  78 */       p_146284_1_.field_146126_j = this.field_152318_h.func_74297_c(GameSettings.Options.func_74379_a(p_146284_1_.field_146127_k));
/*     */       
/*  80 */       if (this.field_146297_k.func_152346_Z().func_152934_n() && options != GameSettings.Options.STREAM_CHAT_ENABLED && options != GameSettings.Options.STREAM_CHAT_USER_FILTER) {
/*  81 */         this.field_152315_t = true;
/*     */       }
/*  83 */     } else if (p_146284_1_ instanceof GuiOptionSlider) {
/*  84 */       if (p_146284_1_.field_146127_k == GameSettings.Options.STREAM_VOLUME_MIC.func_74381_c()) {
/*  85 */         this.field_146297_k.func_152346_Z().func_152915_s();
/*  86 */       } else if (p_146284_1_.field_146127_k == GameSettings.Options.STREAM_VOLUME_SYSTEM.func_74381_c()) {
/*  87 */         this.field_146297_k.func_152346_Z().func_152915_s();
/*  88 */       } else if (this.field_146297_k.func_152346_Z().func_152934_n()) {
/*  89 */         this.field_152315_t = true;
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     if (p_146284_1_.field_146127_k == 200) {
/*  94 */       this.field_146297_k.field_71474_y.func_74303_b();
/*  95 */       this.field_146297_k.func_147108_a(this.field_152317_g);
/*  96 */     } else if (p_146284_1_.field_146127_k == 201) {
/*  97 */       this.field_146297_k.field_71474_y.func_74303_b();
/*  98 */       this.field_146297_k.func_147108_a(new GuiIngestServers(this));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 104 */     func_146276_q_();
/* 105 */     func_73732_a(this.field_146289_q, this.field_152319_i, this.field_146294_l / 2, 20, 16777215);
/* 106 */     func_73732_a(this.field_146289_q, this.field_152313_r, this.field_146294_l / 2, this.field_152314_s, 16777215);
/*     */     
/* 108 */     if (this.field_152315_t) {
/* 109 */       func_73732_a(this.field_146289_q, EnumChatFormatting.RED + I18n.func_135052_a("options.stream.changes", new Object[0]), this.field_146294_l / 2, 20 + this.field_146289_q.field_78288_b, 16777215);
/*     */     }
/*     */     
/* 112 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\stream\GuiStreamOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */