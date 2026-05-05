/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiControls
/*     */   extends GuiScreen
/*     */ {
/*  17 */   private static final GameSettings.Options[] field_146492_g = new GameSettings.Options[] { GameSettings.Options.INVERT_MOUSE, GameSettings.Options.SENSITIVITY, GameSettings.Options.TOUCHSCREEN };
/*     */ 
/*     */   
/*     */   private GuiScreen field_146496_h;
/*     */   
/*  22 */   protected String field_146495_a = "Controls";
/*     */   private GameSettings field_146497_i;
/*  24 */   public KeyBinding field_146491_f = null;
/*     */   
/*     */   public long field_152177_g;
/*     */   private GuiKeyBindingList field_146494_r;
/*     */   
/*     */   public GuiControls(GuiScreen p_i1027_1_, GameSettings p_i1027_2_) {
/*  30 */     this.field_146496_h = p_i1027_1_;
/*  31 */     this.field_146497_i = p_i1027_2_;
/*     */   }
/*     */   private GuiButton field_146493_s; private static final String __OBFID = "CL_00000736";
/*     */   
/*     */   public void func_73866_w_() {
/*  36 */     this.field_146494_r = new GuiKeyBindingList(this, this.field_146297_k);
/*  37 */     this.field_146292_n.add(new GuiButton(200, this.field_146294_l / 2 - 155, this.field_146295_m - 29, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*  38 */     this.field_146292_n.add(this.field_146493_s = new GuiButton(201, this.field_146294_l / 2 - 155 + 160, this.field_146295_m - 29, 150, 20, I18n.func_135052_a("controls.resetAll", new Object[0])));
/*  39 */     this.field_146495_a = I18n.func_135052_a("controls.title", new Object[0]);
/*     */     
/*  41 */     byte b = 0;
/*  42 */     for (GameSettings.Options options : field_146492_g) {
/*  43 */       if (options.func_74380_a()) {
/*  44 */         this.field_146292_n.add(new GuiOptionSlider(options.func_74381_c(), this.field_146294_l / 2 - 155 + b % 2 * 160, 18 + 24 * (b >> 1), options));
/*     */       } else {
/*  46 */         this.field_146292_n.add(new GuiOptionButton(options.func_74381_c(), this.field_146294_l / 2 - 155 + b % 2 * 160, 18 + 24 * (b >> 1), options, this.field_146497_i.func_74297_c(options)));
/*     */       } 
/*     */       
/*  49 */       b++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  55 */     if (p_146284_1_.field_146127_k == 200) {
/*  56 */       this.field_146297_k.func_147108_a(this.field_146496_h);
/*  57 */     } else if (p_146284_1_.field_146127_k == 201) {
/*  58 */       for (KeyBinding keyBinding : this.field_146297_k.field_71474_y.field_74324_K) {
/*  59 */         keyBinding.func_151462_b(keyBinding.func_151469_h());
/*     */       }
/*  61 */       KeyBinding.func_74508_b();
/*  62 */     } else if (p_146284_1_.field_146127_k < 100 && p_146284_1_ instanceof GuiOptionButton) {
/*  63 */       this.field_146497_i.func_74306_a(((GuiOptionButton)p_146284_1_).func_146136_c(), 1);
/*  64 */       p_146284_1_.field_146126_j = this.field_146497_i.func_74297_c(GameSettings.Options.func_74379_a(p_146284_1_.field_146127_k));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/*  70 */     if (this.field_146491_f != null) {
/*  71 */       this.field_146497_i.func_151440_a(this.field_146491_f, -100 + p_73864_3_);
/*  72 */       this.field_146491_f = null;
/*  73 */       KeyBinding.func_74508_b();
/*  74 */     } else if (p_73864_3_ != 0 || !this.field_146494_r.func_148179_a(p_73864_1_, p_73864_2_, p_73864_3_)) {
/*  75 */       super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
/*  81 */     if (p_146286_3_ != 0 || !this.field_146494_r.func_148181_b(p_146286_1_, p_146286_2_, p_146286_3_)) {
/*  82 */       super.func_146286_b(p_146286_1_, p_146286_2_, p_146286_3_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  88 */     if (this.field_146491_f != null) {
/*  89 */       if (p_73869_2_ == 1) {
/*  90 */         this.field_146497_i.func_151440_a(this.field_146491_f, 0);
/*     */       } else {
/*  92 */         this.field_146497_i.func_151440_a(this.field_146491_f, p_73869_2_);
/*     */       } 
/*     */       
/*  95 */       this.field_146491_f = null;
/*  96 */       this.field_152177_g = Minecraft.func_71386_F();
/*  97 */       KeyBinding.func_74508_b();
/*     */     } else {
/*  99 */       super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 105 */     func_146276_q_();
/*     */     
/* 107 */     this.field_146494_r.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/* 108 */     func_73732_a(this.field_146289_q, this.field_146495_a, this.field_146294_l / 2, 8, 16777215);
/*     */     
/* 110 */     boolean bool = true;
/*     */     
/* 112 */     for (KeyBinding keyBinding : this.field_146497_i.field_74324_K) {
/* 113 */       if (keyBinding.func_151463_i() != keyBinding.func_151469_h()) {
/* 114 */         bool = false;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 119 */     this.field_146493_s.field_146124_l = !bool;
/*     */     
/* 121 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiControls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */