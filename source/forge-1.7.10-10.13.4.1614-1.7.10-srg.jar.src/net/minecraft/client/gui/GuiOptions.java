/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.PositionedSoundRecord;
/*     */ import net.minecraft.client.audio.SoundCategory;
/*     */ import net.minecraft.client.audio.SoundEventAccessorComposite;
/*     */ import net.minecraft.client.audio.SoundHandler;
/*     */ import net.minecraft.client.gui.stream.GuiStreamOptions;
/*     */ import net.minecraft.client.gui.stream.GuiStreamUnavailable;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.client.stream.IStream;
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
/*     */ public class GuiOptions
/*     */   extends GuiScreen
/*     */   implements GuiYesNoCallback
/*     */ {
/*  29 */   private static final GameSettings.Options[] field_146440_f = new GameSettings.Options[] { GameSettings.Options.FOV, GameSettings.Options.DIFFICULTY };
/*     */   
/*     */   private final GuiScreen field_146441_g;
/*     */   
/*     */   private final GameSettings field_146443_h;
/*     */   
/*  35 */   protected String field_146442_a = "Options";
/*     */   
/*     */   public GuiOptions(GuiScreen p_i1046_1_, GameSettings p_i1046_2_) {
/*  38 */     this.field_146441_g = p_i1046_1_;
/*  39 */     this.field_146443_h = p_i1046_2_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000700";
/*     */   
/*     */   public void func_73866_w_() {
/*  44 */     byte b = 0;
/*  45 */     this.field_146442_a = I18n.func_135052_a("options.title", new Object[0]);
/*     */     
/*  47 */     for (GameSettings.Options options : field_146440_f) {
/*  48 */       if (options.func_74380_a()) {
/*  49 */         this.field_146292_n.add(new GuiOptionSlider(options.func_74381_c(), this.field_146294_l / 2 - 155 + b % 2 * 160, this.field_146295_m / 6 - 12 + 24 * (b >> 1), options));
/*     */       } else {
/*  51 */         GuiOptionButton guiOptionButton = new GuiOptionButton(options.func_74381_c(), this.field_146294_l / 2 - 155 + b % 2 * 160, this.field_146295_m / 6 - 12 + 24 * (b >> 1), options, this.field_146443_h.func_74297_c(options));
/*     */         
/*  53 */         if (options == GameSettings.Options.DIFFICULTY && this.field_146297_k.field_71441_e != null && this.field_146297_k.field_71441_e.func_72912_H().func_76093_s()) {
/*  54 */           guiOptionButton.field_146124_l = false;
/*  55 */           guiOptionButton.field_146126_j = I18n.func_135052_a("options.difficulty", new Object[0]) + ": " + I18n.func_135052_a("options.difficulty.hardcore", new Object[0]);
/*     */         } 
/*     */         
/*  58 */         this.field_146292_n.add(guiOptionButton);
/*     */       } 
/*     */       
/*  61 */       b++;
/*     */     } 
/*     */     
/*  64 */     this.field_146292_n.add(new GuiButton(this, 8675309, this.field_146294_l / 2 + 5, this.field_146295_m / 6 + 48 - 6, 150, 20, "Super Secret Settings...") { private static final String __OBFID = "CL_00000701";
/*     */           
/*     */           public void func_146113_a(SoundHandler p_146113_1_) {
/*  67 */             SoundEventAccessorComposite soundEventAccessorComposite = p_146113_1_.func_147686_a(new SoundCategory[] { SoundCategory.ANIMALS, SoundCategory.BLOCKS, SoundCategory.MOBS, SoundCategory.PLAYERS, SoundCategory.WEATHER });
/*  68 */             if (soundEventAccessorComposite != null) {
/*  69 */               p_146113_1_.func_147682_a((ISound)PositionedSoundRecord.func_147674_a(soundEventAccessorComposite.func_148729_c(), 0.5F));
/*     */             }
/*     */           } }
/*     */       );
/*     */     
/*  74 */     this.field_146292_n.add(new GuiButton(106, this.field_146294_l / 2 - 155, this.field_146295_m / 6 + 72 - 6, 150, 20, I18n.func_135052_a("options.sounds", new Object[0])));
/*  75 */     this.field_146292_n.add(new GuiButton(107, this.field_146294_l / 2 + 5, this.field_146295_m / 6 + 72 - 6, 150, 20, I18n.func_135052_a("options.stream", new Object[0])));
/*     */     
/*  77 */     this.field_146292_n.add(new GuiButton(101, this.field_146294_l / 2 - 155, this.field_146295_m / 6 + 96 - 6, 150, 20, I18n.func_135052_a("options.video", new Object[0])));
/*  78 */     this.field_146292_n.add(new GuiButton(100, this.field_146294_l / 2 + 5, this.field_146295_m / 6 + 96 - 6, 150, 20, I18n.func_135052_a("options.controls", new Object[0])));
/*     */     
/*  80 */     this.field_146292_n.add(new GuiButton(102, this.field_146294_l / 2 - 155, this.field_146295_m / 6 + 120 - 6, 150, 20, I18n.func_135052_a("options.language", new Object[0])));
/*  81 */     this.field_146292_n.add(new GuiButton(103, this.field_146294_l / 2 + 5, this.field_146295_m / 6 + 120 - 6, 150, 20, I18n.func_135052_a("options.multiplayer.title", new Object[0])));
/*     */     
/*  83 */     this.field_146292_n.add(new GuiButton(105, this.field_146294_l / 2 - 155, this.field_146295_m / 6 + 144 - 6, 150, 20, I18n.func_135052_a("options.resourcepack", new Object[0])));
/*  84 */     this.field_146292_n.add(new GuiButton(104, this.field_146294_l / 2 + 5, this.field_146295_m / 6 + 144 - 6, 150, 20, I18n.func_135052_a("options.snooper.view", new Object[0])));
/*     */     
/*  86 */     this.field_146292_n.add(new GuiButton(200, this.field_146294_l / 2 - 100, this.field_146295_m / 6 + 168, I18n.func_135052_a("gui.done", new Object[0])));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  91 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  93 */     if (p_146284_1_.field_146127_k < 100 && p_146284_1_ instanceof GuiOptionButton) {
/*  94 */       this.field_146443_h.func_74306_a(((GuiOptionButton)p_146284_1_).func_146136_c(), 1);
/*  95 */       p_146284_1_.field_146126_j = this.field_146443_h.func_74297_c(GameSettings.Options.func_74379_a(p_146284_1_.field_146127_k));
/*     */     } 
/*  97 */     if (p_146284_1_.field_146127_k == 8675309) {
/*  98 */       this.field_146297_k.field_71460_t.func_147705_c();
/*     */     }
/* 100 */     if (p_146284_1_.field_146127_k == 101) {
/* 101 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 102 */       this.field_146297_k.func_147108_a(new GuiVideoSettings(this, this.field_146443_h));
/*     */     } 
/* 104 */     if (p_146284_1_.field_146127_k == 100) {
/* 105 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 106 */       this.field_146297_k.func_147108_a(new GuiControls(this, this.field_146443_h));
/*     */     } 
/* 108 */     if (p_146284_1_.field_146127_k == 102) {
/* 109 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 110 */       this.field_146297_k.func_147108_a(new GuiLanguage(this, this.field_146443_h, this.field_146297_k.func_135016_M()));
/*     */     } 
/* 112 */     if (p_146284_1_.field_146127_k == 103) {
/* 113 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 114 */       this.field_146297_k.func_147108_a(new ScreenChatOptions(this, this.field_146443_h));
/*     */     } 
/* 116 */     if (p_146284_1_.field_146127_k == 104) {
/* 117 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 118 */       this.field_146297_k.func_147108_a(new GuiSnooper(this, this.field_146443_h));
/*     */     } 
/* 120 */     if (p_146284_1_.field_146127_k == 200) {
/* 121 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 122 */       this.field_146297_k.func_147108_a(this.field_146441_g);
/*     */     } 
/* 124 */     if (p_146284_1_.field_146127_k == 105) {
/* 125 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 126 */       this.field_146297_k.func_147108_a(new GuiScreenResourcePacks(this));
/*     */     } 
/* 128 */     if (p_146284_1_.field_146127_k == 106) {
/* 129 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 130 */       this.field_146297_k.func_147108_a(new GuiScreenOptionsSounds(this, this.field_146443_h));
/*     */     } 
/* 132 */     if (p_146284_1_.field_146127_k == 107) {
/* 133 */       this.field_146297_k.field_71474_y.func_74303_b();
/*     */       
/* 135 */       IStream iStream = this.field_146297_k.func_152346_Z();
/* 136 */       if (iStream.func_152936_l() && iStream.func_152928_D()) {
/* 137 */         this.field_146297_k.func_147108_a((GuiScreen)new GuiStreamOptions(this, this.field_146443_h));
/*     */       } else {
/* 139 */         GuiStreamUnavailable.func_152321_a(this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 146 */     func_146276_q_();
/* 147 */     func_73732_a(this.field_146289_q, this.field_146442_a, this.field_146294_l / 2, 15, 16777215);
/* 148 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */