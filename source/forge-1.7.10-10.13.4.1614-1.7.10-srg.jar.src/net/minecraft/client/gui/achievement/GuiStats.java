/*     */ package net.minecraft.client.gui.achievement;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.PositionedSoundRecord;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiSlot;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.network.play.client.C16PacketClientStatus;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatCrafting;
/*     */ import net.minecraft.stats.StatFileWriter;
/*     */ import net.minecraft.stats.StatList;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiStats extends GuiScreen implements IProgressMeter {
/*  29 */   private static RenderItem field_146544_g = new RenderItem();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected GuiScreen field_146549_a;
/*     */ 
/*     */ 
/*     */   
/*  38 */   protected String field_146542_f = "Select world";
/*     */   private StatsGeneral field_146550_h;
/*     */   private StatsItem field_146551_i;
/*     */   private StatsBlock field_146548_r;
/*     */   private StatsMobsList field_146547_s;
/*     */   private StatFileWriter field_146546_t;
/*     */   private GuiSlot field_146545_u;
/*     */   private boolean field_146543_v = true;
/*     */   private static final String __OBFID = "CL_00000723";
/*     */   
/*     */   public GuiStats(GuiScreen p_i1071_1_, StatFileWriter p_i1071_2_) {
/*  49 */     this.field_146549_a = p_i1071_1_;
/*  50 */     this.field_146546_t = p_i1071_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  55 */     this.field_146542_f = I18n.func_135052_a("gui.stats", new Object[0]);
/*     */     
/*  57 */     this.field_146297_k.func_147114_u().func_147297_a((Packet)new C16PacketClientStatus(C16PacketClientStatus.EnumState.REQUEST_STATS));
/*     */   }
/*     */   
/*     */   public void func_146541_h() {
/*  61 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 + 4, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 160, this.field_146295_m - 52, 80, 20, I18n.func_135052_a("stat.generalButton", new Object[0]))); GuiButton guiButton1;
/*  68 */     this.field_146292_n.add(guiButton1 = new GuiButton(2, this.field_146294_l / 2 - 80, this.field_146295_m - 52, 80, 20, I18n.func_135052_a("stat.blocksButton", new Object[0]))); GuiButton guiButton2;
/*  69 */     this.field_146292_n.add(guiButton2 = new GuiButton(3, this.field_146294_l / 2, this.field_146295_m - 52, 80, 20, I18n.func_135052_a("stat.itemsButton", new Object[0]))); GuiButton guiButton3;
/*  70 */     this.field_146292_n.add(guiButton3 = new GuiButton(4, this.field_146294_l / 2 + 80, this.field_146295_m - 52, 80, 20, I18n.func_135052_a("stat.mobsButton", new Object[0])));
/*     */     
/*  72 */     if (this.field_146548_r.func_148127_b() == 0) {
/*  73 */       guiButton1.field_146124_l = false;
/*     */     }
/*  75 */     if (this.field_146551_i.func_148127_b() == 0) {
/*  76 */       guiButton2.field_146124_l = false;
/*     */     }
/*  78 */     if (this.field_146547_s.func_148127_b() == 0) {
/*  79 */       guiButton3.field_146124_l = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  85 */     if (!p_146284_1_.field_146124_l)
/*  86 */       return;  if (p_146284_1_.field_146127_k == 0) {
/*  87 */       this.field_146297_k.func_147108_a(this.field_146549_a);
/*  88 */     } else if (p_146284_1_.field_146127_k == 1) {
/*  89 */       this.field_146545_u = this.field_146550_h;
/*  90 */     } else if (p_146284_1_.field_146127_k == 3) {
/*  91 */       this.field_146545_u = this.field_146551_i;
/*  92 */     } else if (p_146284_1_.field_146127_k == 2) {
/*  93 */       this.field_146545_u = this.field_146548_r;
/*  94 */     } else if (p_146284_1_.field_146127_k == 4) {
/*  95 */       this.field_146545_u = this.field_146547_s;
/*     */     } else {
/*  97 */       this.field_146545_u.func_148147_a(p_146284_1_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 103 */     if (this.field_146543_v) {
/* 104 */       func_146276_q_();
/* 105 */       func_73732_a(this.field_146289_q, I18n.func_135052_a("multiplayer.downloadingStats", new Object[0]), this.field_146294_l / 2, this.field_146295_m / 2, 16777215);
/* 106 */       func_73732_a(this.field_146289_q, field_146510_b_[(int)(Minecraft.func_71386_F() / 150L % field_146510_b_.length)], this.field_146294_l / 2, this.field_146295_m / 2 + this.field_146289_q.field_78288_b * 2, 16777215);
/*     */     } else {
/* 108 */       this.field_146545_u.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/* 109 */       func_73732_a(this.field_146289_q, this.field_146542_f, this.field_146294_l / 2, 20, 16777215);
/* 110 */       super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146509_g() {
/* 116 */     if (this.field_146543_v) {
/* 117 */       this.field_146550_h = new StatsGeneral(this);
/* 118 */       this.field_146550_h.func_148134_d(1, 1);
/*     */       
/* 120 */       this.field_146551_i = new StatsItem(this);
/* 121 */       this.field_146551_i.func_148134_d(1, 1);
/*     */       
/* 123 */       this.field_146548_r = new StatsBlock(this);
/* 124 */       this.field_146548_r.func_148134_d(1, 1);
/*     */       
/* 126 */       this.field_146547_s = new StatsMobsList(this);
/* 127 */       this.field_146547_s.func_148134_d(1, 1);
/*     */       
/* 129 */       this.field_146545_u = this.field_146550_h;
/* 130 */       func_146541_h();
/* 131 */       this.field_146543_v = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 137 */     return !this.field_146543_v;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   class StatsGeneral extends GuiSlot { private static final String __OBFID = "CL_00000726";
/*     */     public StatsGeneral(GuiStats p_i1067_1_) {
/* 142 */       super(p_i1067_1_.field_146297_k, p_i1067_1_.field_146294_l, p_i1067_1_.field_146295_m, 32, p_i1067_1_.field_146295_m - 64, 10);
/*     */       
/* 144 */       func_148130_a(false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148127_b() {
/* 149 */       return StatList.field_75941_c.size();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {}
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/* 158 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148138_e() {
/* 163 */       return func_148127_b() * 10;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {
/* 168 */       this.field_148208_k.func_146276_q_();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 173 */       StatBase statBase = StatList.field_75941_c.get(p_148126_1_);
/* 174 */       this.field_148208_k.func_73731_b(this.field_148208_k.field_146289_q, statBase.func_150951_e().func_150260_c(), p_148126_2_ + 2, p_148126_3_ + 1, (p_148126_1_ % 2 == 0) ? 16777215 : 9474192);
/* 175 */       String str = statBase.func_75968_a(this.field_148208_k.field_146546_t.func_77444_a(statBase));
/* 176 */       this.field_148208_k.func_73731_b(this.field_148208_k.field_146289_q, str, p_148126_2_ + 2 + 213 - this.field_148208_k.field_146289_q.func_78256_a(str), p_148126_3_ + 1, (p_148126_1_ % 2 == 0) ? 16777215 : 9474192);
/*     */     } }
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
/*     */   private void func_146521_a(int p_146521_1_, int p_146521_2_, Item p_146521_3_) {
/* 198 */     func_146531_b(p_146521_1_ + 1, p_146521_2_ + 1);
/*     */     
/* 200 */     GL11.glEnable(32826);
/*     */     
/* 202 */     RenderHelper.func_74520_c();
/*     */     
/* 204 */     field_146544_g.func_77015_a(this.field_146289_q, this.field_146297_k.func_110434_K(), new ItemStack(p_146521_3_, 1, 0), p_146521_1_ + 2, p_146521_2_ + 2);
/* 205 */     RenderHelper.func_74518_a();
/*     */     
/* 207 */     GL11.glDisable(32826);
/*     */   }
/*     */   
/*     */   private void func_146531_b(int p_146531_1_, int p_146531_2_) {
/* 211 */     func_146527_c(p_146531_1_, p_146531_2_, 0, 0);
/*     */   }
/*     */   
/*     */   private void func_146527_c(int p_146527_1_, int p_146527_2_, int p_146527_3_, int p_146527_4_) {
/* 215 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 216 */     this.field_146297_k.func_110434_K().func_110577_a(field_110323_l);
/*     */     
/* 218 */     float f1 = 0.0078125F;
/* 219 */     float f2 = 0.0078125F;
/* 220 */     byte b1 = 18;
/* 221 */     byte b2 = 18;
/* 222 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 223 */     tessellator.func_78382_b();
/* 224 */     tessellator.func_78374_a((p_146527_1_ + 0), (p_146527_2_ + 18), this.field_73735_i, ((p_146527_3_ + 0) * 0.0078125F), ((p_146527_4_ + 18) * 0.0078125F));
/* 225 */     tessellator.func_78374_a((p_146527_1_ + 18), (p_146527_2_ + 18), this.field_73735_i, ((p_146527_3_ + 18) * 0.0078125F), ((p_146527_4_ + 18) * 0.0078125F));
/* 226 */     tessellator.func_78374_a((p_146527_1_ + 18), (p_146527_2_ + 0), this.field_73735_i, ((p_146527_3_ + 18) * 0.0078125F), ((p_146527_4_ + 0) * 0.0078125F));
/* 227 */     tessellator.func_78374_a((p_146527_1_ + 0), (p_146527_2_ + 0), this.field_73735_i, ((p_146527_3_ + 0) * 0.0078125F), ((p_146527_4_ + 0) * 0.0078125F));
/* 228 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   abstract class Stats extends GuiSlot {
/* 233 */     protected int field_148218_l = -1;
/*     */     
/*     */     protected List field_148219_m;
/*     */     protected Comparator field_148216_n;
/* 237 */     protected int field_148217_o = -1; protected int field_148215_p;
/*     */     private static final String __OBFID = "CL_00000730";
/*     */     
/*     */     protected Stats(GuiStats p_i1070_1_) {
/* 241 */       super(p_i1070_1_.field_146297_k, p_i1070_1_.field_146294_l, p_i1070_1_.field_146295_m, 32, p_i1070_1_.field_146295_m - 64, 20);
/*     */       
/* 243 */       func_148130_a(false);
/* 244 */       func_148133_a(true, 20);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {}
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/* 253 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {
/* 258 */       this.field_148214_q.func_146276_q_();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148129_a(int p_148129_1_, int p_148129_2_, Tessellator p_148129_3_) {
/* 264 */       if (!Mouse.isButtonDown(0)) {
/* 265 */         this.field_148218_l = -1;
/*     */       }
/*     */       
/* 268 */       if (this.field_148218_l == 0) {
/* 269 */         this.field_148214_q.func_146527_c(p_148129_1_ + 115 - 18, p_148129_2_ + 1, 0, 0);
/*     */       } else {
/* 271 */         this.field_148214_q.func_146527_c(p_148129_1_ + 115 - 18, p_148129_2_ + 1, 0, 18);
/*     */       } 
/*     */       
/* 274 */       if (this.field_148218_l == 1) {
/* 275 */         this.field_148214_q.func_146527_c(p_148129_1_ + 165 - 18, p_148129_2_ + 1, 0, 0);
/*     */       } else {
/* 277 */         this.field_148214_q.func_146527_c(p_148129_1_ + 165 - 18, p_148129_2_ + 1, 0, 18);
/*     */       } 
/*     */       
/* 280 */       if (this.field_148218_l == 2) {
/* 281 */         this.field_148214_q.func_146527_c(p_148129_1_ + 215 - 18, p_148129_2_ + 1, 0, 0);
/*     */       } else {
/* 283 */         this.field_148214_q.func_146527_c(p_148129_1_ + 215 - 18, p_148129_2_ + 1, 0, 18);
/*     */       } 
/*     */       
/* 286 */       if (this.field_148217_o != -1) {
/* 287 */         char c = 'O';
/* 288 */         byte b = 18;
/*     */         
/* 290 */         if (this.field_148217_o == 1) {
/* 291 */           c = '';
/* 292 */         } else if (this.field_148217_o == 2) {
/* 293 */           c = '³';
/*     */         } 
/*     */         
/* 296 */         if (this.field_148215_p == 1) {
/* 297 */           b = 36;
/*     */         }
/* 299 */         this.field_148214_q.func_146527_c(p_148129_1_ + c, p_148129_2_ + 1, b, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148132_a(int p_148132_1_, int p_148132_2_) {
/* 306 */       this.field_148218_l = -1;
/* 307 */       if (p_148132_1_ >= 79 && p_148132_1_ < 115) {
/* 308 */         this.field_148218_l = 0;
/* 309 */       } else if (p_148132_1_ >= 129 && p_148132_1_ < 165) {
/* 310 */         this.field_148218_l = 1;
/* 311 */       } else if (p_148132_1_ >= 179 && p_148132_1_ < 215) {
/* 312 */         this.field_148218_l = 2;
/*     */       } 
/*     */       
/* 315 */       if (this.field_148218_l >= 0) {
/* 316 */         func_148212_h(this.field_148218_l);
/* 317 */         this.field_148214_q.field_146297_k.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected final int func_148127_b() {
/* 323 */       return this.field_148219_m.size();
/*     */     }
/*     */     
/*     */     protected final StatCrafting func_148211_c(int p_148211_1_) {
/* 327 */       return this.field_148219_m.get(p_148211_1_);
/*     */     }
/*     */     
/*     */     protected abstract String func_148210_b(int param1Int);
/*     */     
/*     */     protected void func_148209_a(StatBase p_148209_1_, int p_148209_2_, int p_148209_3_, boolean p_148209_4_) {
/* 333 */       if (p_148209_1_ != null) {
/* 334 */         String str = p_148209_1_.func_75968_a(this.field_148214_q.field_146546_t.func_77444_a(p_148209_1_));
/* 335 */         this.field_148214_q.func_73731_b(this.field_148214_q.field_146289_q, str, p_148209_2_ - this.field_148214_q.field_146289_q.func_78256_a(str), p_148209_3_ + 5, p_148209_4_ ? 16777215 : 9474192);
/*     */       } else {
/* 337 */         String str = "-";
/* 338 */         this.field_148214_q.func_73731_b(this.field_148214_q.field_146289_q, str, p_148209_2_ - this.field_148214_q.field_146289_q.func_78256_a(str), p_148209_3_ + 5, p_148209_4_ ? 16777215 : 9474192);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148142_b(int p_148142_1_, int p_148142_2_) {
/* 345 */       if (p_148142_2_ < this.field_148153_b || p_148142_2_ > this.field_148154_c) {
/*     */         return;
/*     */       }
/*     */       
/* 349 */       int i = func_148124_c(p_148142_1_, p_148142_2_);
/* 350 */       int j = this.field_148155_a / 2 - 92 - 16;
/* 351 */       if (i >= 0) {
/* 352 */         if (p_148142_1_ < j + 40 || p_148142_1_ > j + 40 + 20) {
/*     */           return;
/*     */         }
/*     */         
/* 356 */         StatCrafting statCrafting = func_148211_c(i);
/* 357 */         func_148213_a(statCrafting, p_148142_1_, p_148142_2_);
/*     */       } else {
/* 359 */         String str = "";
/* 360 */         if (p_148142_1_ >= j + 115 - 18 && p_148142_1_ <= j + 115) {
/* 361 */           str = func_148210_b(0);
/* 362 */         } else if (p_148142_1_ >= j + 165 - 18 && p_148142_1_ <= j + 165) {
/* 363 */           str = func_148210_b(1);
/* 364 */         } else if (p_148142_1_ >= j + 215 - 18 && p_148142_1_ <= j + 215) {
/* 365 */           str = func_148210_b(2);
/*     */         } else {
/*     */           return;
/*     */         } 
/*     */         
/* 370 */         str = ("" + I18n.func_135052_a(str, new Object[0])).trim();
/*     */         
/* 372 */         if (str.length() > 0) {
/* 373 */           int k = p_148142_1_ + 12;
/* 374 */           int m = p_148142_2_ - 12;
/* 375 */           int n = this.field_148214_q.field_146289_q.func_78256_a(str);
/* 376 */           this.field_148214_q.func_73733_a(k - 3, m - 3, k + n + 3, m + 8 + 3, -1073741824, -1073741824);
/*     */           
/* 378 */           this.field_148214_q.field_146289_q.func_78261_a(str, k, m, -1);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148213_a(StatCrafting p_148213_1_, int p_148213_2_, int p_148213_3_) {
/* 385 */       if (p_148213_1_ == null) {
/*     */         return;
/*     */       }
/*     */       
/* 389 */       Item item = p_148213_1_.func_150959_a();
/*     */       
/* 391 */       String str = ("" + I18n.func_135052_a(item.func_77658_a() + ".name", new Object[0])).trim();
/*     */       
/* 393 */       if (str.length() > 0) {
/* 394 */         int i = p_148213_2_ + 12;
/* 395 */         int j = p_148213_3_ - 12;
/* 396 */         int k = this.field_148214_q.field_146289_q.func_78256_a(str);
/* 397 */         this.field_148214_q.func_73733_a(i - 3, j - 3, i + k + 3, j + 8 + 3, -1073741824, -1073741824);
/*     */         
/* 399 */         this.field_148214_q.field_146289_q.func_78261_a(str, i, j, -1);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148212_h(int p_148212_1_) {
/* 405 */       if (p_148212_1_ != this.field_148217_o) {
/* 406 */         this.field_148217_o = p_148212_1_;
/* 407 */         this.field_148215_p = -1;
/* 408 */       } else if (this.field_148215_p == -1) {
/* 409 */         this.field_148215_p = 1;
/*     */       } else {
/* 411 */         this.field_148217_o = -1;
/* 412 */         this.field_148215_p = 0;
/*     */       } 
/*     */       
/* 415 */       Collections.sort(this.field_148219_m, this.field_148216_n);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class StatsItem
/*     */     extends Stats
/*     */   {
/*     */     private static final String __OBFID = "CL_00000727";
/*     */     
/*     */     public StatsItem(GuiStats p_i1069_1_) {
/* 426 */       super(p_i1069_1_);
/*     */       
/* 428 */       this.field_148219_m = new ArrayList();
/* 429 */       for (StatCrafting statCrafting : StatList.field_75938_d) {
/* 430 */         boolean bool = false;
/* 431 */         int i = Item.func_150891_b(statCrafting.func_150959_a());
/*     */         
/* 433 */         if (p_i1069_1_.field_146546_t.func_77444_a((StatBase)statCrafting) > 0) {
/* 434 */           bool = true;
/* 435 */         } else if (StatList.field_75930_F[i] != null && p_i1069_1_.field_146546_t.func_77444_a(StatList.field_75930_F[i]) > 0) {
/* 436 */           bool = true;
/* 437 */         } else if (StatList.field_75928_D[i] != null && p_i1069_1_.field_146546_t.func_77444_a(StatList.field_75928_D[i]) > 0) {
/* 438 */           bool = true;
/*     */         } 
/* 440 */         if (bool) {
/* 441 */           this.field_148219_m.add(statCrafting);
/*     */         }
/*     */       } 
/*     */       
/* 445 */       this.field_148216_n = new Comparator(this, p_i1069_1_) { private static final String __OBFID = "CL_00000728";
/*     */           
/*     */           public int compare(StatCrafting p_compare_1_, StatCrafting p_compare_2_) {
/* 448 */             int i = Item.func_150891_b(p_compare_1_.func_150959_a());
/* 449 */             int j = Item.func_150891_b(p_compare_2_.func_150959_a());
/*     */             
/* 451 */             StatBase statBase1 = null;
/* 452 */             StatBase statBase2 = null;
/* 453 */             if (this.field_148343_b.field_148217_o == 0) {
/* 454 */               statBase1 = StatList.field_75930_F[i];
/* 455 */               statBase2 = StatList.field_75930_F[j];
/* 456 */             } else if (this.field_148343_b.field_148217_o == 1) {
/* 457 */               statBase1 = StatList.field_75928_D[i];
/* 458 */               statBase2 = StatList.field_75928_D[j];
/* 459 */             } else if (this.field_148343_b.field_148217_o == 2) {
/* 460 */               statBase1 = StatList.field_75929_E[i];
/* 461 */               statBase2 = StatList.field_75929_E[j];
/*     */             } 
/*     */             
/* 464 */             if (statBase1 != null || statBase2 != null) {
/* 465 */               if (statBase1 == null)
/* 466 */                 return 1; 
/* 467 */               if (statBase2 == null) {
/* 468 */                 return -1;
/*     */               }
/* 470 */               int k = this.field_148343_b.field_148220_k.field_146546_t.func_77444_a(statBase1);
/* 471 */               int m = this.field_148343_b.field_148220_k.field_146546_t.func_77444_a(statBase2);
/* 472 */               if (k != m) {
/* 473 */                 return (k - m) * this.field_148343_b.field_148215_p;
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 478 */             return i - j;
/*     */           } }
/*     */         ;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148129_a(int p_148129_1_, int p_148129_2_, Tessellator p_148129_3_) {
/* 486 */       super.func_148129_a(p_148129_1_, p_148129_2_, p_148129_3_);
/*     */       
/* 488 */       if (this.field_148218_l == 0) {
/* 489 */         this.field_148220_k.func_146527_c(p_148129_1_ + 115 - 18 + 1, p_148129_2_ + 1 + 1, 72, 18);
/*     */       } else {
/* 491 */         this.field_148220_k.func_146527_c(p_148129_1_ + 115 - 18, p_148129_2_ + 1, 72, 18);
/*     */       } 
/* 493 */       if (this.field_148218_l == 1) {
/* 494 */         this.field_148220_k.func_146527_c(p_148129_1_ + 165 - 18 + 1, p_148129_2_ + 1 + 1, 18, 18);
/*     */       } else {
/* 496 */         this.field_148220_k.func_146527_c(p_148129_1_ + 165 - 18, p_148129_2_ + 1, 18, 18);
/*     */       } 
/* 498 */       if (this.field_148218_l == 2) {
/* 499 */         this.field_148220_k.func_146527_c(p_148129_1_ + 215 - 18 + 1, p_148129_2_ + 1 + 1, 36, 18);
/*     */       } else {
/* 501 */         this.field_148220_k.func_146527_c(p_148129_1_ + 215 - 18, p_148129_2_ + 1, 36, 18);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 508 */       StatCrafting statCrafting = func_148211_c(p_148126_1_);
/*     */       
/* 510 */       Item item = statCrafting.func_150959_a();
/* 511 */       this.field_148220_k.func_146521_a(p_148126_2_ + 40, p_148126_3_, item);
/*     */       
/* 513 */       int i = Item.func_150891_b(item);
/* 514 */       func_148209_a(StatList.field_75930_F[i], p_148126_2_ + 115, p_148126_3_, (p_148126_1_ % 2 == 0));
/* 515 */       func_148209_a(StatList.field_75928_D[i], p_148126_2_ + 165, p_148126_3_, (p_148126_1_ % 2 == 0));
/* 516 */       func_148209_a((StatBase)statCrafting, p_148126_2_ + 215, p_148126_3_, (p_148126_1_ % 2 == 0));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected String func_148210_b(int p_148210_1_) {
/* 522 */       if (p_148210_1_ == 1)
/* 523 */         return "stat.crafted"; 
/* 524 */       if (p_148210_1_ == 2) {
/* 525 */         return "stat.used";
/*     */       }
/* 527 */       return "stat.depleted";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class StatsBlock
/*     */     extends Stats
/*     */   {
/*     */     private static final String __OBFID = "CL_00000724";
/*     */     
/*     */     public StatsBlock(GuiStats p_i1066_1_) {
/* 539 */       super(p_i1066_1_);
/*     */       
/* 541 */       this.field_148219_m = new ArrayList();
/* 542 */       for (StatCrafting statCrafting : StatList.field_75939_e) {
/* 543 */         boolean bool = false;
/* 544 */         int i = Item.func_150891_b(statCrafting.func_150959_a());
/*     */         
/* 546 */         if (p_i1066_1_.field_146546_t.func_77444_a((StatBase)statCrafting) > 0) {
/* 547 */           bool = true;
/* 548 */         } else if (StatList.field_75929_E[i] != null && p_i1066_1_.field_146546_t.func_77444_a(StatList.field_75929_E[i]) > 0) {
/* 549 */           bool = true;
/* 550 */         } else if (StatList.field_75928_D[i] != null && p_i1066_1_.field_146546_t.func_77444_a(StatList.field_75928_D[i]) > 0) {
/* 551 */           bool = true;
/*     */         } 
/* 553 */         if (bool) {
/* 554 */           this.field_148219_m.add(statCrafting);
/*     */         }
/*     */       } 
/*     */       
/* 558 */       this.field_148216_n = new Comparator(this, p_i1066_1_) { private static final String __OBFID = "CL_00000725";
/*     */           
/*     */           public int compare(StatCrafting p_compare_1_, StatCrafting p_compare_2_) {
/* 561 */             int i = Item.func_150891_b(p_compare_1_.func_150959_a());
/* 562 */             int j = Item.func_150891_b(p_compare_2_.func_150959_a());
/*     */             
/* 564 */             StatBase statBase1 = null;
/* 565 */             StatBase statBase2 = null;
/* 566 */             if (this.field_148340_b.field_148217_o == 2) {
/* 567 */               statBase1 = StatList.field_75934_C[i];
/* 568 */               statBase2 = StatList.field_75934_C[j];
/* 569 */             } else if (this.field_148340_b.field_148217_o == 0) {
/* 570 */               statBase1 = StatList.field_75928_D[i];
/* 571 */               statBase2 = StatList.field_75928_D[j];
/* 572 */             } else if (this.field_148340_b.field_148217_o == 1) {
/* 573 */               statBase1 = StatList.field_75929_E[i];
/* 574 */               statBase2 = StatList.field_75929_E[j];
/*     */             } 
/*     */             
/* 577 */             if (statBase1 != null || statBase2 != null) {
/* 578 */               if (statBase1 == null)
/* 579 */                 return 1; 
/* 580 */               if (statBase2 == null) {
/* 581 */                 return -1;
/*     */               }
/* 583 */               int k = this.field_148340_b.field_148221_k.field_146546_t.func_77444_a(statBase1);
/* 584 */               int m = this.field_148340_b.field_148221_k.field_146546_t.func_77444_a(statBase2);
/* 585 */               if (k != m) {
/* 586 */                 return (k - m) * this.field_148340_b.field_148215_p;
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 591 */             return i - j;
/*     */           } }
/*     */         ;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148129_a(int p_148129_1_, int p_148129_2_, Tessellator p_148129_3_) {
/* 599 */       super.func_148129_a(p_148129_1_, p_148129_2_, p_148129_3_);
/*     */       
/* 601 */       if (this.field_148218_l == 0) {
/* 602 */         this.field_148221_k.func_146527_c(p_148129_1_ + 115 - 18 + 1, p_148129_2_ + 1 + 1, 18, 18);
/*     */       } else {
/* 604 */         this.field_148221_k.func_146527_c(p_148129_1_ + 115 - 18, p_148129_2_ + 1, 18, 18);
/*     */       } 
/* 606 */       if (this.field_148218_l == 1) {
/* 607 */         this.field_148221_k.func_146527_c(p_148129_1_ + 165 - 18 + 1, p_148129_2_ + 1 + 1, 36, 18);
/*     */       } else {
/* 609 */         this.field_148221_k.func_146527_c(p_148129_1_ + 165 - 18, p_148129_2_ + 1, 36, 18);
/*     */       } 
/* 611 */       if (this.field_148218_l == 2) {
/* 612 */         this.field_148221_k.func_146527_c(p_148129_1_ + 215 - 18 + 1, p_148129_2_ + 1 + 1, 54, 18);
/*     */       } else {
/* 614 */         this.field_148221_k.func_146527_c(p_148129_1_ + 215 - 18, p_148129_2_ + 1, 54, 18);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 622 */       StatCrafting statCrafting = func_148211_c(p_148126_1_);
/* 623 */       Item item = statCrafting.func_150959_a();
/*     */       
/* 625 */       this.field_148221_k.func_146521_a(p_148126_2_ + 40, p_148126_3_, item);
/*     */       
/* 627 */       int i = Item.func_150891_b(item);
/* 628 */       func_148209_a(StatList.field_75928_D[i], p_148126_2_ + 115, p_148126_3_, (p_148126_1_ % 2 == 0));
/* 629 */       func_148209_a(StatList.field_75929_E[i], p_148126_2_ + 165, p_148126_3_, (p_148126_1_ % 2 == 0));
/* 630 */       func_148209_a((StatBase)statCrafting, p_148126_2_ + 215, p_148126_3_, (p_148126_1_ % 2 == 0));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected String func_148210_b(int p_148210_1_) {
/* 636 */       if (p_148210_1_ == 0)
/* 637 */         return "stat.crafted"; 
/* 638 */       if (p_148210_1_ == 1) {
/* 639 */         return "stat.used";
/*     */       }
/* 641 */       return "stat.mined";
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class StatsMobsList
/*     */     extends GuiSlot {
/* 648 */     private final List field_148222_l = new ArrayList(); private static final String __OBFID = "CL_00000729";
/*     */     
/*     */     public StatsMobsList(GuiStats p_i45027_1_) {
/* 651 */       super(p_i45027_1_.field_146297_k, p_i45027_1_.field_146294_l, p_i45027_1_.field_146295_m, 32, p_i45027_1_.field_146295_m - 64, p_i45027_1_.field_146289_q.field_78288_b * 4);
/*     */       
/* 653 */       func_148130_a(false);
/*     */       
/* 655 */       for (EntityList.EntityEggInfo entityEggInfo : EntityList.field_75627_a.values()) {
/* 656 */         if (p_i45027_1_.field_146546_t.func_77444_a(entityEggInfo.field_151512_d) > 0 || p_i45027_1_.field_146546_t.func_77444_a(entityEggInfo.field_151513_e) > 0) {
/* 657 */           this.field_148222_l.add(entityEggInfo);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148127_b() {
/* 664 */       return this.field_148222_l.size();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {}
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/* 673 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148138_e() {
/* 678 */       return func_148127_b() * this.field_148223_k.field_146289_q.field_78288_b * 4;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {
/* 683 */       this.field_148223_k.func_146276_q_();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 688 */       EntityList.EntityEggInfo entityEggInfo = this.field_148222_l.get(p_148126_1_);
/* 689 */       String str1 = I18n.func_135052_a("entity." + EntityList.func_75617_a(entityEggInfo.field_75613_a) + ".name", new Object[0]);
/* 690 */       int i = this.field_148223_k.field_146546_t.func_77444_a(entityEggInfo.field_151512_d);
/* 691 */       int j = this.field_148223_k.field_146546_t.func_77444_a(entityEggInfo.field_151513_e);
/* 692 */       String str2 = I18n.func_135052_a("stat.entityKills", new Object[] { Integer.valueOf(i), str1 });
/* 693 */       String str3 = I18n.func_135052_a("stat.entityKilledBy", new Object[] { str1, Integer.valueOf(j) });
/*     */       
/* 695 */       if (i == 0) str2 = I18n.func_135052_a("stat.entityKills.none", new Object[] { str1 }); 
/* 696 */       if (j == 0) str3 = I18n.func_135052_a("stat.entityKilledBy.none", new Object[] { str1 });
/*     */       
/* 698 */       this.field_148223_k.func_73731_b(this.field_148223_k.field_146289_q, str1, p_148126_2_ + 2 - 10, p_148126_3_ + 1, 16777215);
/*     */       
/* 700 */       this.field_148223_k.func_73731_b(this.field_148223_k.field_146289_q, str2, p_148126_2_ + 2, p_148126_3_ + 1 + this.field_148223_k.field_146289_q.field_78288_b, (i == 0) ? 6316128 : 9474192);
/* 701 */       this.field_148223_k.func_73731_b(this.field_148223_k.field_146289_q, str3, p_148126_2_ + 2, p_148126_3_ + 1 + this.field_148223_k.field_146289_q.field_78288_b * 2, (j == 0) ? 6316128 : 9474192);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\achievement\GuiStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */