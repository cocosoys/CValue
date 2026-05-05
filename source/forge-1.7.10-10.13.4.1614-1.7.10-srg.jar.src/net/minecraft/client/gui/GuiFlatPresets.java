/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.gen.FlatGeneratorInfo;
/*     */ import net.minecraft.world.gen.FlatLayerInfo;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiFlatPresets
/*     */   extends GuiScreen
/*     */ {
/*  40 */   private static RenderItem field_146437_a = new RenderItem();
/*  41 */   private static final List field_146431_f = new ArrayList();
/*     */   private final GuiCreateFlatWorld field_146432_g;
/*     */   private String field_146438_h;
/*     */   private String field_146439_i;
/*     */   private String field_146436_r;
/*     */   private ListSlot field_146435_s;
/*     */   private GuiButton field_146434_t;
/*     */   private GuiTextField field_146433_u;
/*     */   private static final String __OBFID = "CL_00000704";
/*     */   
/*     */   static {
/*  52 */     func_146421_a("Classic Flat", Item.func_150898_a((Block)Blocks.field_150349_c), BiomeGenBase.field_76772_c, Arrays.asList(new String[] { "village" }, ), new FlatLayerInfo[] { new FlatLayerInfo(1, (Block)Blocks.field_150349_c), new FlatLayerInfo(2, Blocks.field_150346_d), new FlatLayerInfo(1, Blocks.field_150357_h) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     func_146421_a("Tunnelers' Dream", Item.func_150898_a(Blocks.field_150348_b), BiomeGenBase.field_76770_e, Arrays.asList(new String[] { "biome_1", "dungeon", "decoration", "stronghold", "mineshaft" }, ), new FlatLayerInfo[] { new FlatLayerInfo(1, (Block)Blocks.field_150349_c), new FlatLayerInfo(5, Blocks.field_150346_d), new FlatLayerInfo(230, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h) });
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
/*  70 */     func_146421_a("Water World", Item.func_150898_a((Block)Blocks.field_150358_i), BiomeGenBase.field_76772_c, Arrays.asList(new String[] { "village", "biome_1" }, ), new FlatLayerInfo[] { new FlatLayerInfo(90, Blocks.field_150355_j), new FlatLayerInfo(5, (Block)Blocks.field_150354_m), new FlatLayerInfo(5, Blocks.field_150346_d), new FlatLayerInfo(5, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     func_146421_a("Overworld", Item.func_150898_a((Block)Blocks.field_150329_H), BiomeGenBase.field_76772_c, Arrays.asList(new String[] { "village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake" }, ), new FlatLayerInfo[] { new FlatLayerInfo(1, (Block)Blocks.field_150349_c), new FlatLayerInfo(3, Blocks.field_150346_d), new FlatLayerInfo(59, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h) });
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
/*  90 */     func_146421_a("Snowy Kingdom", Item.func_150898_a(Blocks.field_150431_aC), BiomeGenBase.field_76774_n, Arrays.asList(new String[] { "village", "biome_1" }, ), new FlatLayerInfo[] { new FlatLayerInfo(1, Blocks.field_150431_aC), new FlatLayerInfo(1, (Block)Blocks.field_150349_c), new FlatLayerInfo(3, Blocks.field_150346_d), new FlatLayerInfo(59, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     func_146421_a("Bottomless Pit", Items.field_151008_G, BiomeGenBase.field_76772_c, Arrays.asList(new String[] { "village", "biome_1" }, ), new FlatLayerInfo[] { new FlatLayerInfo(1, (Block)Blocks.field_150349_c), new FlatLayerInfo(3, Blocks.field_150346_d), new FlatLayerInfo(2, Blocks.field_150347_e) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     func_146421_a("Desert", Item.func_150898_a((Block)Blocks.field_150354_m), BiomeGenBase.field_76769_d, Arrays.asList(new String[] { "village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon" }, ), new FlatLayerInfo[] { new FlatLayerInfo(8, (Block)Blocks.field_150354_m), new FlatLayerInfo(52, Blocks.field_150322_A), new FlatLayerInfo(3, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     func_146425_a("Redstone Ready", Items.field_151137_ax, BiomeGenBase.field_76769_d, new FlatLayerInfo[] { new FlatLayerInfo(52, Blocks.field_150322_A), new FlatLayerInfo(3, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiFlatPresets(GuiCreateFlatWorld p_i1049_1_) {
/* 124 */     this.field_146432_g = p_i1049_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 129 */     this.field_146292_n.clear();
/* 130 */     Keyboard.enableRepeatEvents(true);
/*     */     
/* 132 */     this.field_146438_h = I18n.func_135052_a("createWorld.customize.presets.title", new Object[0]);
/* 133 */     this.field_146439_i = I18n.func_135052_a("createWorld.customize.presets.share", new Object[0]);
/* 134 */     this.field_146436_r = I18n.func_135052_a("createWorld.customize.presets.list", new Object[0]);
/* 135 */     this.field_146433_u = new GuiTextField(this.field_146289_q, 50, 40, this.field_146294_l - 100, 20);
/* 136 */     this.field_146435_s = new ListSlot(this);
/*     */     
/* 138 */     this.field_146433_u.func_146203_f(1230);
/* 139 */     this.field_146433_u.func_146180_a(this.field_146432_g.func_146384_e());
/*     */     
/* 141 */     this.field_146292_n.add(this.field_146434_t = new GuiButton(0, this.field_146294_l / 2 - 155, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("createWorld.customize.presets.select", new Object[0])));
/* 142 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 + 5, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */     
/* 144 */     func_146426_g();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 149 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 154 */     this.field_146433_u.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 155 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 160 */     if (!this.field_146433_u.func_146201_a(p_73869_1_, p_73869_2_)) {
/* 161 */       super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 167 */     if (p_146284_1_.field_146127_k == 0 && func_146430_p()) {
/* 168 */       this.field_146432_g.func_146383_a(this.field_146433_u.func_146179_b());
/* 169 */       this.field_146297_k.func_147108_a(this.field_146432_g);
/* 170 */     } else if (p_146284_1_.field_146127_k == 1) {
/* 171 */       this.field_146297_k.func_147108_a(this.field_146432_g);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 177 */     func_146276_q_();
/*     */     
/* 179 */     this.field_146435_s.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/* 180 */     func_73732_a(this.field_146289_q, this.field_146438_h, this.field_146294_l / 2, 8, 16777215);
/* 181 */     func_73731_b(this.field_146289_q, this.field_146439_i, 50, 30, 10526880);
/* 182 */     func_73731_b(this.field_146289_q, this.field_146436_r, 50, 70, 10526880);
/*     */     
/* 184 */     this.field_146433_u.func_146194_f();
/* 185 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 190 */     this.field_146433_u.func_146178_a();
/* 191 */     super.func_73876_c();
/*     */   }
/*     */   
/*     */   public void func_146426_g() {
/* 195 */     boolean bool = func_146430_p();
/* 196 */     this.field_146434_t.field_146124_l = bool;
/*     */   }
/*     */   
/*     */   private boolean func_146430_p() {
/* 200 */     return ((this.field_146435_s.field_148175_k > -1 && this.field_146435_s.field_148175_k < field_146431_f.size()) || this.field_146433_u.func_146179_b().length() > 1);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 204 */   class ListSlot extends GuiSlot { public int field_148175_k = -1; private static final String __OBFID = "CL_00000706";
/*     */     
/*     */     public ListSlot(GuiFlatPresets p_i1048_1_) {
/* 207 */       super(p_i1048_1_.field_146297_k, p_i1048_1_.field_146294_l, p_i1048_1_.field_146295_m, 80, p_i1048_1_.field_146295_m - 37, 24);
/*     */     }
/*     */     
/*     */     private void func_148172_a(int p_148172_1_, int p_148172_2_, Item p_148172_3_) {
/* 211 */       func_148173_e(p_148172_1_ + 1, p_148172_2_ + 1);
/*     */       
/* 213 */       GL11.glEnable(32826);
/*     */       
/* 215 */       RenderHelper.func_74520_c();
/*     */       
/* 217 */       GuiFlatPresets.field_146437_a.func_77015_a(this.field_148174_l.field_146289_q, this.field_148174_l.field_146297_k.func_110434_K(), new ItemStack(p_148172_3_, 1, 0), p_148172_1_ + 2, p_148172_2_ + 2);
/* 218 */       RenderHelper.func_74518_a();
/*     */       
/* 220 */       GL11.glDisable(32826);
/*     */     }
/*     */     
/*     */     private void func_148173_e(int p_148173_1_, int p_148173_2_) {
/* 224 */       func_148171_c(p_148173_1_, p_148173_2_, 0, 0);
/*     */     }
/*     */     
/*     */     private void func_148171_c(int p_148171_1_, int p_148171_2_, int p_148171_3_, int p_148171_4_) {
/* 228 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 229 */       this.field_148174_l.field_146297_k.func_110434_K().func_110577_a(Gui.field_110323_l);
/*     */       
/* 231 */       float f1 = 0.0078125F;
/* 232 */       float f2 = 0.0078125F;
/* 233 */       byte b1 = 18;
/* 234 */       byte b2 = 18;
/* 235 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 236 */       tessellator.func_78382_b();
/* 237 */       tessellator.func_78374_a((p_148171_1_ + 0), (p_148171_2_ + 18), this.field_148174_l.field_73735_i, ((p_148171_3_ + 0) * 0.0078125F), ((p_148171_4_ + 18) * 0.0078125F));
/* 238 */       tessellator.func_78374_a((p_148171_1_ + 18), (p_148171_2_ + 18), this.field_148174_l.field_73735_i, ((p_148171_3_ + 18) * 0.0078125F), ((p_148171_4_ + 18) * 0.0078125F));
/* 239 */       tessellator.func_78374_a((p_148171_1_ + 18), (p_148171_2_ + 0), this.field_148174_l.field_73735_i, ((p_148171_3_ + 18) * 0.0078125F), ((p_148171_4_ + 0) * 0.0078125F));
/* 240 */       tessellator.func_78374_a((p_148171_1_ + 0), (p_148171_2_ + 0), this.field_148174_l.field_73735_i, ((p_148171_3_ + 0) * 0.0078125F), ((p_148171_4_ + 0) * 0.0078125F));
/* 241 */       tessellator.func_78381_a();
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148127_b() {
/* 246 */       return GuiFlatPresets.field_146431_f.size();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
/* 251 */       this.field_148175_k = p_148144_1_;
/* 252 */       this.field_148174_l.func_146426_g();
/* 253 */       this.field_148174_l.field_146433_u.func_146180_a(((GuiFlatPresets.LayerItem)GuiFlatPresets.field_146431_f.get(this.field_148174_l.field_146435_s.field_148175_k)).field_148233_c);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/* 258 */       return (p_148131_1_ == this.field_148175_k);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {}
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 267 */       GuiFlatPresets.LayerItem layerItem = GuiFlatPresets.field_146431_f.get(p_148126_1_);
/* 268 */       func_148172_a(p_148126_2_, p_148126_3_, layerItem.field_148234_a);
/* 269 */       this.field_148174_l.field_146289_q.func_78276_b(layerItem.field_148232_b, p_148126_2_ + 18 + 5, p_148126_3_ + 6, 16777215);
/*     */     } }
/*     */ 
/*     */   
/*     */   private static void func_146425_a(String p_146425_0_, Item p_146425_1_, BiomeGenBase p_146425_2_, FlatLayerInfo... p_146425_3_) {
/* 274 */     func_146421_a(p_146425_0_, p_146425_1_, p_146425_2_, (List)null, p_146425_3_);
/*     */   }
/*     */   
/*     */   private static void func_146421_a(String p_146421_0_, Item p_146421_1_, BiomeGenBase p_146421_2_, List p_146421_3_, FlatLayerInfo... p_146421_4_) {
/* 278 */     FlatGeneratorInfo flatGeneratorInfo = new FlatGeneratorInfo();
/*     */     
/* 280 */     for (int i = p_146421_4_.length - 1; i >= 0; i--) {
/* 281 */       flatGeneratorInfo.func_82650_c().add(p_146421_4_[i]);
/*     */     }
/*     */     
/* 284 */     flatGeneratorInfo.func_82647_a(p_146421_2_.field_76756_M);
/* 285 */     flatGeneratorInfo.func_82645_d();
/*     */     
/* 287 */     if (p_146421_3_ != null) {
/* 288 */       for (String str : p_146421_3_) {
/* 289 */         flatGeneratorInfo.func_82644_b().put(str, new HashMap<Object, Object>());
/*     */       }
/*     */     }
/*     */     
/* 293 */     field_146431_f.add(new LayerItem(p_146421_1_, p_146421_0_, flatGeneratorInfo.toString()));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   static class LayerItem {
/*     */     public Item field_148234_a;
/*     */     public String field_148232_b;
/*     */     
/*     */     public LayerItem(Item p_i45022_1_, String p_i45022_2_, String p_i45022_3_) {
/* 302 */       this.field_148234_a = p_i45022_1_;
/* 303 */       this.field_148232_b = p_i45022_2_;
/* 304 */       this.field_148233_c = p_i45022_3_;
/*     */     }
/*     */     
/*     */     public String field_148233_c;
/*     */     private static final String __OBFID = "CL_00000705";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiFlatPresets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */