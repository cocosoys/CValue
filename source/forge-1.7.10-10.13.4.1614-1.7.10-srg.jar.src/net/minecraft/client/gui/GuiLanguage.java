/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.resources.Language;
/*     */ import net.minecraft.client.resources.LanguageManager;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiLanguage
/*     */   extends GuiScreen
/*     */ {
/*     */   protected GuiScreen field_146453_a;
/*     */   private List field_146450_f;
/*     */   private final GameSettings field_146451_g;
/*     */   private final LanguageManager field_146454_h;
/*     */   private GuiOptionButton field_146455_i;
/*     */   private GuiOptionButton field_146452_r;
/*     */   private static final String __OBFID = "CL_00000698";
/*     */   
/*     */   public GuiLanguage(GuiScreen p_i1043_1_, GameSettings p_i1043_2_, LanguageManager p_i1043_3_) {
/*  28 */     this.field_146453_a = p_i1043_1_;
/*  29 */     this.field_146451_g = p_i1043_2_;
/*  30 */     this.field_146454_h = p_i1043_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  35 */     boolean bool = false;
/*  36 */     if (this.field_146455_i != null);
/*     */ 
/*     */     
/*  39 */     this.field_146292_n.add(this.field_146455_i = new GuiOptionButton(100, this.field_146294_l / 2 - 155, this.field_146295_m - 38, GameSettings.Options.FORCE_UNICODE_FONT, this.field_146451_g.func_74297_c(GameSettings.Options.FORCE_UNICODE_FONT)));
/*  40 */     this.field_146292_n.add(this.field_146452_r = new GuiOptionButton(6, this.field_146294_l / 2 - 155 + 160, this.field_146295_m - 38, I18n.func_135052_a("gui.done", new Object[0])));
/*     */ 
/*     */     
/*  43 */     this.field_146450_f = new List(this);
/*  44 */     this.field_146450_f.func_148134_d(7, 8);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  49 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  51 */     switch (p_146284_1_.field_146127_k) {
/*     */       case 100:
/*  53 */         if (p_146284_1_ instanceof GuiOptionButton) {
/*  54 */           this.field_146451_g.func_74306_a(((GuiOptionButton)p_146284_1_).func_146136_c(), 1);
/*  55 */           p_146284_1_.field_146126_j = this.field_146451_g.func_74297_c(GameSettings.Options.FORCE_UNICODE_FONT);
/*     */           
/*  57 */           ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/*  58 */           int i = scaledResolution.func_78326_a();
/*  59 */           int j = scaledResolution.func_78328_b();
/*  60 */           func_146280_a(this.field_146297_k, i, j);
/*     */         } 
/*     */       
/*     */       case 5:
/*     */         return;
/*     */       case 6:
/*  66 */         this.field_146297_k.func_147108_a(this.field_146453_a);
/*     */     } 
/*     */     
/*  69 */     this.field_146450_f.func_148147_a(p_146284_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  77 */     this.field_146450_f.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */     
/*  79 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("options.language", new Object[0]), this.field_146294_l / 2, 16, 16777215);
/*  80 */     func_73732_a(this.field_146289_q, "(" + I18n.func_135052_a("options.languageWarning", new Object[0]) + ")", this.field_146294_l / 2, this.field_146295_m - 56, 8421504);
/*     */     
/*  82 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  86 */   class List extends GuiSlot { private final java.util.List field_148176_l = Lists.newArrayList();
/*  87 */     private final Map field_148177_m = Maps.newHashMap(); private static final String __OBFID = "CL_00000699";
/*     */     
/*     */     public List(GuiLanguage p_i1042_1_) {
/*  90 */       super(p_i1042_1_.field_146297_k, p_i1042_1_.field_146294_l, p_i1042_1_.field_146295_m, 32, p_i1042_1_.field_146295_m - 65 + 4, 18);
/*     */       
/*  92 */       for (Language language : p_i1042_1_.field_146454_h.func_135040_d()) {
/*  93 */         this.field_148177_m.put(language.func_135034_a(), language);
/*  94 */         this.field_148176_l.add(language.func_135034_a());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148127_b() {
/* 100 */       return this.field_148176_l.size();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
/* 105 */       Language language = (Language)this.field_148177_m.get(this.field_148176_l.get(p_148144_1_));
/*     */       
/* 107 */       this.field_148178_k.field_146454_h.func_135045_a(language);
/* 108 */       this.field_148178_k.field_146451_g.field_74363_ab = language.func_135034_a();
/*     */       
/* 110 */       this.field_148178_k.field_146297_k.func_110436_a();
/*     */       
/* 112 */       this.field_148178_k.field_146289_q.func_78264_a((this.field_148178_k.field_146454_h.func_135042_a() || this.field_148178_k.field_146451_g.field_151455_aw));
/* 113 */       this.field_148178_k.field_146289_q.func_78275_b(this.field_148178_k.field_146454_h.func_135044_b());
/*     */       
/* 115 */       this.field_148178_k.field_146452_r.field_146126_j = I18n.func_135052_a("gui.done", new Object[0]);
/* 116 */       this.field_148178_k.field_146455_i.field_146126_j = this.field_148178_k.field_146451_g.func_74297_c(GameSettings.Options.FORCE_UNICODE_FONT);
/* 117 */       this.field_148178_k.field_146451_g.func_74303_b();
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/* 122 */       return ((String)this.field_148176_l.get(p_148131_1_)).equals(this.field_148178_k.field_146454_h.func_135041_c().func_135034_a());
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148138_e() {
/* 127 */       return func_148127_b() * 18;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {
/* 132 */       this.field_148178_k.func_146276_q_();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 137 */       this.field_148178_k.field_146289_q.func_78275_b(true);
/* 138 */       this.field_148178_k.func_73732_a(this.field_148178_k.field_146289_q, ((Language)this.field_148177_m.get(this.field_148176_l.get(p_148126_1_))).toString(), this.field_148155_a / 2, p_148126_3_ + 1, 16777215);
/* 139 */       this.field_148178_k.field_146289_q.func_78275_b(this.field_148178_k.field_146454_h.func_135041_c().func_135035_b());
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiLanguage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */