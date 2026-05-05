/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiSnooper extends GuiScreen {
/*     */   private final GuiScreen field_146608_a;
/*     */   private final GameSettings field_146603_f;
/*  16 */   private final java.util.List field_146604_g = new ArrayList();
/*  17 */   private final java.util.List field_146609_h = new ArrayList();
/*     */   
/*     */   private String field_146610_i;
/*     */   
/*     */   private String[] field_146607_r;
/*     */   
/*     */   public GuiSnooper(GuiScreen p_i1061_1_, GameSettings p_i1061_2_) {
/*  24 */     this.field_146608_a = p_i1061_1_;
/*  25 */     this.field_146603_f = p_i1061_2_;
/*     */   }
/*     */   private List field_146606_s; private GuiButton field_146605_t; private static final String __OBFID = "CL_00000714";
/*     */   
/*     */   public void func_73866_w_() {
/*  30 */     this.field_146610_i = I18n.func_135052_a("options.snooper.title", new Object[0]);
/*  31 */     String str = I18n.func_135052_a("options.snooper.desc", new Object[0]);
/*  32 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  34 */     for (String str1 : this.field_146289_q.func_78271_c(str, this.field_146294_l - 30)) {
/*  35 */       arrayList.add(str1);
/*     */     }
/*     */     
/*  38 */     this.field_146607_r = arrayList.<String>toArray(new String[0]);
/*     */     
/*  40 */     this.field_146604_g.clear();
/*  41 */     this.field_146609_h.clear();
/*     */     
/*  43 */     this.field_146292_n.add(this.field_146605_t = new GuiButton(1, this.field_146294_l / 2 - 152, this.field_146295_m - 30, 150, 20, this.field_146603_f.func_74297_c(GameSettings.Options.SNOOPER_ENABLED)));
/*  44 */     this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 + 2, this.field_146295_m - 30, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*     */     
/*  46 */     boolean bool = (this.field_146297_k.func_71401_C() != null && this.field_146297_k.func_71401_C().func_80003_ah() != null) ? true : false;
/*     */     
/*  48 */     for (Map.Entry<?, ?> entry : (new TreeMap<Object, Object>(this.field_146297_k.func_71378_E().func_76465_c())).entrySet()) {
/*  49 */       this.field_146604_g.add((bool ? "C " : "") + (String)entry.getKey());
/*  50 */       this.field_146609_h.add(this.field_146289_q.func_78269_a((String)entry.getValue(), this.field_146294_l - 220));
/*     */     } 
/*     */     
/*  53 */     if (bool) {
/*  54 */       for (Map.Entry<?, ?> entry : (new TreeMap<Object, Object>(this.field_146297_k.func_71401_C().func_80003_ah().func_76465_c())).entrySet()) {
/*  55 */         this.field_146604_g.add("S " + (String)entry.getKey());
/*  56 */         this.field_146609_h.add(this.field_146289_q.func_78269_a((String)entry.getValue(), this.field_146294_l - 220));
/*     */       } 
/*     */     }
/*     */     
/*  60 */     this.field_146606_s = new List(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  65 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  67 */     if (p_146284_1_.field_146127_k == 2) {
/*  68 */       this.field_146603_f.func_74303_b();
/*  69 */       this.field_146603_f.func_74303_b();
/*  70 */       this.field_146297_k.func_147108_a(this.field_146608_a);
/*     */     } 
/*     */     
/*  73 */     if (p_146284_1_.field_146127_k == 1) {
/*  74 */       this.field_146603_f.func_74306_a(GameSettings.Options.SNOOPER_ENABLED, 1);
/*  75 */       this.field_146605_t.field_146126_j = this.field_146603_f.func_74297_c(GameSettings.Options.SNOOPER_ENABLED);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  81 */     func_146276_q_();
/*     */     
/*  83 */     this.field_146606_s.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*  84 */     func_73732_a(this.field_146289_q, this.field_146610_i, this.field_146294_l / 2, 8, 16777215);
/*     */     
/*  86 */     int i = 22;
/*  87 */     for (String str : this.field_146607_r) {
/*  88 */       func_73732_a(this.field_146289_q, str, this.field_146294_l / 2, i, 8421504);
/*  89 */       i += this.field_146289_q.field_78288_b;
/*     */     } 
/*     */     
/*  92 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class List extends GuiSlot { public List(GuiSnooper p_i1060_1_) {
/*  97 */       super(p_i1060_1_.field_146297_k, p_i1060_1_.field_146294_l, p_i1060_1_.field_146295_m, 80, p_i1060_1_.field_146295_m - 40, p_i1060_1_.field_146289_q.field_78288_b + 1);
/*     */     }
/*     */     private static final String __OBFID = "CL_00000715";
/*     */     
/*     */     protected int func_148127_b() {
/* 102 */       return this.field_148206_k.field_146604_g.size();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {}
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/* 111 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {}
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 120 */       this.field_148206_k.field_146289_q.func_78276_b(this.field_148206_k.field_146604_g.get(p_148126_1_), 10, p_148126_3_, 16777215);
/*     */       
/* 122 */       this.field_148206_k.field_146289_q.func_78276_b(this.field_148206_k.field_146609_h.get(p_148126_1_), 230, p_148126_3_, 16777215);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148137_d() {
/* 127 */       return this.field_148155_a - 10;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiSnooper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */