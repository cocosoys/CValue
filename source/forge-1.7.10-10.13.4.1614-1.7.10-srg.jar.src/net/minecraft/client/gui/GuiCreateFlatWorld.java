/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.gen.FlatGeneratorInfo;
/*     */ import net.minecraft.world.gen.FlatLayerInfo;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiCreateFlatWorld
/*     */   extends GuiScreen {
/*  19 */   private static RenderItem field_146392_a = new RenderItem();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final GuiCreateWorld field_146385_f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   private FlatGeneratorInfo field_146387_g = FlatGeneratorInfo.func_82649_e();
/*     */   
/*     */   private String field_146393_h;
/*     */   
/*     */   private String field_146394_i;
/*     */   
/*     */   private String field_146391_r;
/*     */   private Details field_146390_s;
/*     */   
/*     */   public GuiCreateFlatWorld(GuiCreateWorld p_i1029_1_, String p_i1029_2_) {
/*  47 */     this.field_146385_f = p_i1029_1_;
/*     */     
/*  49 */     func_146383_a(p_i1029_2_);
/*     */   }
/*     */   private GuiButton field_146389_t; private GuiButton field_146388_u; private GuiButton field_146386_v; private static final String __OBFID = "CL_00000687";
/*     */   public String func_146384_e() {
/*  53 */     return this.field_146387_g.toString();
/*     */   }
/*     */   
/*     */   public void func_146383_a(String p_146383_1_) {
/*  57 */     this.field_146387_g = FlatGeneratorInfo.func_82651_a(p_146383_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  62 */     this.field_146292_n.clear();
/*     */     
/*  64 */     this.field_146393_h = I18n.func_135052_a("createWorld.customize.flat.title", new Object[0]);
/*  65 */     this.field_146394_i = I18n.func_135052_a("createWorld.customize.flat.tile", new Object[0]);
/*  66 */     this.field_146391_r = I18n.func_135052_a("createWorld.customize.flat.height", new Object[0]);
/*     */     
/*  68 */     this.field_146390_s = new Details(this);
/*     */     
/*  70 */     this.field_146292_n.add(this.field_146389_t = new GuiButton(2, this.field_146294_l / 2 - 154, this.field_146295_m - 52, 100, 20, I18n.func_135052_a("createWorld.customize.flat.addLayer", new Object[0]) + " (NYI)"));
/*  71 */     this.field_146292_n.add(this.field_146388_u = new GuiButton(3, this.field_146294_l / 2 - 50, this.field_146295_m - 52, 100, 20, I18n.func_135052_a("createWorld.customize.flat.editLayer", new Object[0]) + " (NYI)"));
/*  72 */     this.field_146292_n.add(this.field_146386_v = new GuiButton(4, this.field_146294_l / 2 - 155, this.field_146295_m - 52, 150, 20, I18n.func_135052_a("createWorld.customize.flat.removeLayer", new Object[0])));
/*     */     
/*  74 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 155, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*  75 */     this.field_146292_n.add(new GuiButton(5, this.field_146294_l / 2 + 5, this.field_146295_m - 52, 150, 20, I18n.func_135052_a("createWorld.customize.presets", new Object[0])));
/*  76 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 + 5, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */     
/*  78 */     this.field_146388_u.field_146125_m = false;
/*     */     
/*  80 */     this.field_146387_g.func_82645_d();
/*  81 */     func_146375_g();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  86 */     int i = this.field_146387_g.func_82650_c().size() - this.field_146390_s.field_148228_k - 1;
/*     */     
/*  88 */     if (p_146284_1_.field_146127_k == 1) {
/*  89 */       this.field_146297_k.func_147108_a(this.field_146385_f);
/*  90 */     } else if (p_146284_1_.field_146127_k == 0) {
/*  91 */       this.field_146385_f.field_146334_a = func_146384_e();
/*  92 */       this.field_146297_k.func_147108_a(this.field_146385_f);
/*  93 */     } else if (p_146284_1_.field_146127_k == 5) {
/*  94 */       this.field_146297_k.func_147108_a(new GuiFlatPresets(this));
/*  95 */     } else if (p_146284_1_.field_146127_k == 4 && func_146382_i()) {
/*  96 */       this.field_146387_g.func_82650_c().remove(i);
/*  97 */       this.field_146390_s.field_148228_k = Math.min(this.field_146390_s.field_148228_k, this.field_146387_g.func_82650_c().size() - 1);
/*     */     } 
/*     */     
/* 100 */     this.field_146387_g.func_82645_d();
/* 101 */     func_146375_g();
/*     */   }
/*     */   
/*     */   public void func_146375_g() {
/* 105 */     boolean bool = func_146382_i();
/* 106 */     this.field_146386_v.field_146124_l = bool;
/* 107 */     this.field_146388_u.field_146124_l = bool;
/*     */ 
/*     */     
/* 110 */     this.field_146388_u.field_146124_l = false;
/* 111 */     this.field_146389_t.field_146124_l = false;
/*     */   }
/*     */   
/*     */   private boolean func_146382_i() {
/* 115 */     return (this.field_146390_s.field_148228_k > -1 && this.field_146390_s.field_148228_k < this.field_146387_g.func_82650_c().size());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 120 */     func_146276_q_();
/*     */     
/* 122 */     this.field_146390_s.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/* 123 */     func_73732_a(this.field_146289_q, this.field_146393_h, this.field_146294_l / 2, 8, 16777215);
/*     */     
/* 125 */     int i = this.field_146294_l / 2 - 92 - 16;
/* 126 */     func_73731_b(this.field_146289_q, this.field_146394_i, i, 32, 16777215);
/* 127 */     func_73731_b(this.field_146289_q, this.field_146391_r, i + 2 + 213 - this.field_146289_q.func_78256_a(this.field_146391_r), 32, 16777215);
/*     */     
/* 129 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 133 */   class Details extends GuiSlot { public int field_148228_k = -1; private static final String __OBFID = "CL_00000688";
/*     */     
/*     */     public Details(GuiCreateFlatWorld p_i45019_1_) {
/* 136 */       super(p_i45019_1_.field_146297_k, p_i45019_1_.field_146294_l, p_i45019_1_.field_146295_m, 43, p_i45019_1_.field_146295_m - 60, 24);
/*     */     }
/*     */     
/*     */     private void func_148225_a(int p_148225_1_, int p_148225_2_, ItemStack p_148225_3_) {
/* 140 */       func_148226_e(p_148225_1_ + 1, p_148225_2_ + 1);
/*     */       
/* 142 */       GL11.glEnable(32826);
/*     */       
/* 144 */       if (p_148225_3_ != null) {
/* 145 */         RenderHelper.func_74520_c();
/* 146 */         GuiCreateFlatWorld.field_146392_a.func_77015_a(this.field_148227_l.field_146289_q, this.field_148227_l.field_146297_k.func_110434_K(), p_148225_3_, p_148225_1_ + 2, p_148225_2_ + 2);
/* 147 */         RenderHelper.func_74518_a();
/*     */       } 
/*     */       
/* 150 */       GL11.glDisable(32826);
/*     */     }
/*     */     
/*     */     private void func_148226_e(int p_148226_1_, int p_148226_2_) {
/* 154 */       func_148224_c(p_148226_1_, p_148226_2_, 0, 0);
/*     */     }
/*     */     
/*     */     private void func_148224_c(int p_148224_1_, int p_148224_2_, int p_148224_3_, int p_148224_4_) {
/* 158 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 159 */       this.field_148227_l.field_146297_k.func_110434_K().func_110577_a(Gui.field_110323_l);
/*     */       
/* 161 */       float f1 = 0.0078125F;
/* 162 */       float f2 = 0.0078125F;
/* 163 */       byte b1 = 18;
/* 164 */       byte b2 = 18;
/* 165 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 166 */       tessellator.func_78382_b();
/* 167 */       tessellator.func_78374_a((p_148224_1_ + 0), (p_148224_2_ + 18), this.field_148227_l.field_73735_i, ((p_148224_3_ + 0) * 0.0078125F), ((p_148224_4_ + 18) * 0.0078125F));
/* 168 */       tessellator.func_78374_a((p_148224_1_ + 18), (p_148224_2_ + 18), this.field_148227_l.field_73735_i, ((p_148224_3_ + 18) * 0.0078125F), ((p_148224_4_ + 18) * 0.0078125F));
/* 169 */       tessellator.func_78374_a((p_148224_1_ + 18), (p_148224_2_ + 0), this.field_148227_l.field_73735_i, ((p_148224_3_ + 18) * 0.0078125F), ((p_148224_4_ + 0) * 0.0078125F));
/* 170 */       tessellator.func_78374_a((p_148224_1_ + 0), (p_148224_2_ + 0), this.field_148227_l.field_73735_i, ((p_148224_3_ + 0) * 0.0078125F), ((p_148224_4_ + 0) * 0.0078125F));
/* 171 */       tessellator.func_78381_a();
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148127_b() {
/* 176 */       return this.field_148227_l.field_146387_g.func_82650_c().size();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
/* 181 */       this.field_148228_k = p_148144_1_;
/* 182 */       this.field_148227_l.func_146375_g();
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/* 187 */       return (p_148131_1_ == this.field_148228_k);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {}
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/*     */       String str2;
/* 196 */       FlatLayerInfo flatLayerInfo = this.field_148227_l.field_146387_g.func_82650_c().get(this.field_148227_l.field_146387_g.func_82650_c().size() - p_148126_1_ - 1);
/*     */ 
/*     */       
/* 199 */       Item item = Item.func_150898_a(flatLayerInfo.func_151536_b());
/* 200 */       ItemStack itemStack = (flatLayerInfo.func_151536_b() == Blocks.field_150350_a) ? null : new ItemStack(item, 1, flatLayerInfo.func_82658_c());
/* 201 */       String str1 = (itemStack == null || item == null) ? "Air" : item.func_77653_i(itemStack);
/*     */       
/* 203 */       func_148225_a(p_148126_2_, p_148126_3_, itemStack);
/* 204 */       this.field_148227_l.field_146289_q.func_78276_b(str1, p_148126_2_ + 18 + 5, p_148126_3_ + 3, 16777215);
/*     */ 
/*     */ 
/*     */       
/* 208 */       if (p_148126_1_ == 0) {
/* 209 */         str2 = I18n.func_135052_a("createWorld.customize.flat.layer.top", new Object[] { Integer.valueOf(flatLayerInfo.func_82657_a()) });
/* 210 */       } else if (p_148126_1_ == this.field_148227_l.field_146387_g.func_82650_c().size() - 1) {
/* 211 */         str2 = I18n.func_135052_a("createWorld.customize.flat.layer.bottom", new Object[] { Integer.valueOf(flatLayerInfo.func_82657_a()) });
/*     */       } else {
/* 213 */         str2 = I18n.func_135052_a("createWorld.customize.flat.layer", new Object[] { Integer.valueOf(flatLayerInfo.func_82657_a()) });
/*     */       } 
/*     */       
/* 216 */       this.field_148227_l.field_146289_q.func_78276_b(str2, p_148126_2_ + 2 + 213 - this.field_148227_l.field_146289_q.func_78256_a(str2), p_148126_3_ + 3, 16777215);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148137_d() {
/* 221 */       return this.field_148155_a - 70;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiCreateFlatWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */