/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.multiplayer.GuiConnecting;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.multiplayer.ServerList;
/*     */ import net.minecraft.client.network.LanServerDetector;
/*     */ import net.minecraft.client.network.OldServerPinger;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiMultiplayer
/*     */   extends GuiScreen
/*     */   implements GuiYesNoCallback
/*     */ {
/*  23 */   private static final Logger field_146802_a = LogManager.getLogger();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   private final OldServerPinger field_146797_f = new OldServerPinger();
/*     */   private GuiScreen field_146798_g;
/*     */   private ServerSelectionList field_146803_h;
/*     */   private ServerList field_146804_i;
/*     */   private GuiButton field_146810_r;
/*     */   private GuiButton field_146809_s;
/*     */   private GuiButton field_146808_t;
/*     */   private boolean field_146807_u;
/*     */   private boolean field_146806_v;
/*     */   private boolean field_146805_w;
/*     */   private boolean field_146813_x;
/*     */   private String field_146812_y;
/*     */   private ServerData field_146811_z;
/*     */   private LanServerDetector.LanServerList field_146799_A;
/*     */   private LanServerDetector.ThreadLanServerFind field_146800_B;
/*     */   private boolean field_146801_C;
/*     */   private static final String __OBFID = "CL_00000814";
/*     */   
/*     */   public GuiMultiplayer(GuiScreen p_i1040_1_) {
/*  52 */     this.field_146798_g = p_i1040_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  57 */     Keyboard.enableRepeatEvents(true);
/*  58 */     this.field_146292_n.clear();
/*     */     
/*  60 */     if (!this.field_146801_C) {
/*  61 */       this.field_146801_C = true;
/*     */       
/*  63 */       this.field_146804_i = new ServerList(this.field_146297_k);
/*  64 */       this.field_146804_i.func_78853_a();
/*     */       
/*  66 */       this.field_146799_A = new LanServerDetector.LanServerList();
/*     */       try {
/*  68 */         this.field_146800_B = new LanServerDetector.ThreadLanServerFind(this.field_146799_A);
/*  69 */         this.field_146800_B.start();
/*  70 */       } catch (Exception exception) {
/*  71 */         field_146802_a.warn("Unable to start LAN server detection: " + exception.getMessage());
/*     */       } 
/*     */       
/*  74 */       this.field_146803_h = new ServerSelectionList(this, this.field_146297_k, this.field_146294_l, this.field_146295_m, 32, this.field_146295_m - 64, 36);
/*  75 */       this.field_146803_h.func_148195_a(this.field_146804_i);
/*     */     } else {
/*  77 */       this.field_146803_h.func_148122_a(this.field_146294_l, this.field_146295_m, 32, this.field_146295_m - 64);
/*     */     } 
/*     */     
/*  80 */     func_146794_g();
/*     */   }
/*     */   
/*     */   public void func_146794_g() {
/*  84 */     this.field_146292_n.add(this.field_146810_r = new GuiButton(7, this.field_146294_l / 2 - 154, this.field_146295_m - 28, 70, 20, I18n.func_135052_a("selectServer.edit", new Object[0])));
/*  85 */     this.field_146292_n.add(this.field_146808_t = new GuiButton(2, this.field_146294_l / 2 - 74, this.field_146295_m - 28, 70, 20, I18n.func_135052_a("selectServer.delete", new Object[0])));
/*     */     
/*  87 */     this.field_146292_n.add(this.field_146809_s = new GuiButton(1, this.field_146294_l / 2 - 154, this.field_146295_m - 52, 100, 20, I18n.func_135052_a("selectServer.select", new Object[0])));
/*  88 */     this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 - 50, this.field_146295_m - 52, 100, 20, I18n.func_135052_a("selectServer.direct", new Object[0])));
/*  89 */     this.field_146292_n.add(new GuiButton(3, this.field_146294_l / 2 + 4 + 50, this.field_146295_m - 52, 100, 20, I18n.func_135052_a("selectServer.add", new Object[0])));
/*     */     
/*  91 */     this.field_146292_n.add(new GuiButton(8, this.field_146294_l / 2 + 4, this.field_146295_m - 28, 70, 20, I18n.func_135052_a("selectServer.refresh", new Object[0])));
/*  92 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 + 4 + 76, this.field_146295_m - 28, 75, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */     
/*  94 */     func_146790_a(this.field_146803_h.func_148193_k());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  99 */     super.func_73876_c();
/*     */     
/* 101 */     if (this.field_146799_A.func_77553_a()) {
/* 102 */       List list = this.field_146799_A.func_77554_c();
/* 103 */       this.field_146799_A.func_77552_b();
/*     */       
/* 105 */       this.field_146803_h.func_148194_a(list);
/*     */     } 
/*     */     
/* 108 */     this.field_146797_f.func_147223_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 113 */     Keyboard.enableRepeatEvents(false);
/* 114 */     if (this.field_146800_B != null) {
/* 115 */       this.field_146800_B.interrupt();
/* 116 */       this.field_146800_B = null;
/*     */     } 
/* 118 */     this.field_146797_f.func_147226_b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 123 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/* 125 */     GuiListExtended.IGuiListEntry iGuiListEntry = (this.field_146803_h.func_148193_k() < 0) ? null : this.field_146803_h.func_148180_b(this.field_146803_h.func_148193_k());
/*     */     
/* 127 */     if (p_146284_1_.field_146127_k == 2 && iGuiListEntry instanceof ServerListEntryNormal) {
/* 128 */       String str = (((ServerListEntryNormal)iGuiListEntry).func_148296_a()).field_78847_a;
/* 129 */       if (str != null) {
/* 130 */         this.field_146807_u = true;
/*     */         
/* 132 */         String str1 = I18n.func_135052_a("selectServer.deleteQuestion", new Object[0]);
/* 133 */         String str2 = "'" + str + "' " + I18n.func_135052_a("selectServer.deleteWarning", new Object[0]);
/* 134 */         String str3 = I18n.func_135052_a("selectServer.deleteButton", new Object[0]);
/* 135 */         String str4 = I18n.func_135052_a("gui.cancel", new Object[0]);
/*     */         
/* 137 */         GuiYesNo guiYesNo = new GuiYesNo(this, str1, str2, str3, str4, this.field_146803_h.func_148193_k());
/* 138 */         this.field_146297_k.func_147108_a(guiYesNo);
/*     */       } 
/* 140 */     } else if (p_146284_1_.field_146127_k == 1) {
/* 141 */       func_146796_h();
/* 142 */     } else if (p_146284_1_.field_146127_k == 4) {
/* 143 */       this.field_146813_x = true;
/* 144 */       this.field_146297_k.func_147108_a(new GuiScreenServerList(this, this.field_146811_z = new ServerData(I18n.func_135052_a("selectServer.defaultName", new Object[0]), "")));
/* 145 */     } else if (p_146284_1_.field_146127_k == 3) {
/* 146 */       this.field_146806_v = true;
/* 147 */       this.field_146297_k.func_147108_a(new GuiScreenAddServer(this, this.field_146811_z = new ServerData(I18n.func_135052_a("selectServer.defaultName", new Object[0]), "")));
/* 148 */     } else if (p_146284_1_.field_146127_k == 7 && iGuiListEntry instanceof ServerListEntryNormal) {
/* 149 */       this.field_146805_w = true;
/* 150 */       ServerData serverData = ((ServerListEntryNormal)iGuiListEntry).func_148296_a();
/*     */       
/* 152 */       this.field_146811_z = new ServerData(serverData.field_78847_a, serverData.field_78845_b);
/* 153 */       this.field_146811_z.func_152583_a(serverData);
/*     */       
/* 155 */       this.field_146297_k.func_147108_a(new GuiScreenAddServer(this, this.field_146811_z));
/* 156 */     } else if (p_146284_1_.field_146127_k == 0) {
/* 157 */       this.field_146297_k.func_147108_a(this.field_146798_g);
/* 158 */     } else if (p_146284_1_.field_146127_k == 8) {
/* 159 */       func_146792_q();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146792_q() {
/* 164 */     this.field_146297_k.func_147108_a(new GuiMultiplayer(this.field_146798_g));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
/* 169 */     GuiListExtended.IGuiListEntry iGuiListEntry = (this.field_146803_h.func_148193_k() < 0) ? null : this.field_146803_h.func_148180_b(this.field_146803_h.func_148193_k());
/*     */     
/* 171 */     if (this.field_146807_u) {
/* 172 */       this.field_146807_u = false;
/* 173 */       if (p_73878_1_ && iGuiListEntry instanceof ServerListEntryNormal) {
/* 174 */         this.field_146804_i.func_78851_b(this.field_146803_h.func_148193_k());
/* 175 */         this.field_146804_i.func_78855_b();
/* 176 */         this.field_146803_h.func_148192_c(-1);
/* 177 */         this.field_146803_h.func_148195_a(this.field_146804_i);
/*     */       } 
/* 179 */       this.field_146297_k.func_147108_a(this);
/* 180 */     } else if (this.field_146813_x) {
/* 181 */       this.field_146813_x = false;
/* 182 */       if (p_73878_1_) {
/* 183 */         func_146791_a(this.field_146811_z);
/*     */       } else {
/* 185 */         this.field_146297_k.func_147108_a(this);
/*     */       } 
/* 187 */     } else if (this.field_146806_v) {
/* 188 */       this.field_146806_v = false;
/* 189 */       if (p_73878_1_) {
/* 190 */         this.field_146804_i.func_78849_a(this.field_146811_z);
/* 191 */         this.field_146804_i.func_78855_b();
/* 192 */         this.field_146803_h.func_148192_c(-1);
/* 193 */         this.field_146803_h.func_148195_a(this.field_146804_i);
/*     */       } 
/* 195 */       this.field_146297_k.func_147108_a(this);
/* 196 */     } else if (this.field_146805_w) {
/* 197 */       this.field_146805_w = false;
/* 198 */       if (p_73878_1_ && iGuiListEntry instanceof ServerListEntryNormal) {
/* 199 */         ServerData serverData = ((ServerListEntryNormal)iGuiListEntry).func_148296_a();
/* 200 */         serverData.field_78847_a = this.field_146811_z.field_78847_a;
/* 201 */         serverData.field_78845_b = this.field_146811_z.field_78845_b;
/* 202 */         serverData.func_152583_a(this.field_146811_z);
/* 203 */         this.field_146804_i.func_78855_b();
/* 204 */         this.field_146803_h.func_148195_a(this.field_146804_i);
/*     */       } 
/* 206 */       this.field_146297_k.func_147108_a(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 212 */     int i = this.field_146803_h.func_148193_k();
/* 213 */     GuiListExtended.IGuiListEntry iGuiListEntry = (i < 0) ? null : this.field_146803_h.func_148180_b(i);
/*     */     
/* 215 */     if (p_73869_2_ == 63) {
/* 216 */       func_146792_q();
/*     */       
/*     */       return;
/*     */     } 
/* 220 */     if (i >= 0) {
/* 221 */       if (p_73869_2_ == 200) {
/* 222 */         if (func_146272_n()) {
/* 223 */           if (i > 0 && iGuiListEntry instanceof ServerListEntryNormal) {
/* 224 */             this.field_146804_i.func_78857_a(i, i - 1);
/* 225 */             func_146790_a(this.field_146803_h.func_148193_k() - 1);
/* 226 */             this.field_146803_h.func_148145_f(-this.field_146803_h.func_148146_j());
/* 227 */             this.field_146803_h.func_148195_a(this.field_146804_i);
/*     */           } 
/* 229 */         } else if (i > 0) {
/* 230 */           func_146790_a(this.field_146803_h.func_148193_k() - 1);
/* 231 */           this.field_146803_h.func_148145_f(-this.field_146803_h.func_148146_j());
/*     */           
/* 233 */           if (this.field_146803_h.func_148180_b(this.field_146803_h.func_148193_k()) instanceof ServerListEntryLanScan) {
/* 234 */             if (this.field_146803_h.func_148193_k() > 0) {
/* 235 */               func_146790_a(this.field_146803_h.func_148127_b() - 1);
/* 236 */               this.field_146803_h.func_148145_f(-this.field_146803_h.func_148146_j());
/*     */             } else {
/* 238 */               func_146790_a(-1);
/*     */             } 
/*     */           }
/*     */         } else {
/* 242 */           func_146790_a(-1);
/*     */         } 
/* 244 */       } else if (p_73869_2_ == 208) {
/* 245 */         if (func_146272_n()) {
/* 246 */           if (i < this.field_146804_i.func_78856_c() - 1) {
/* 247 */             this.field_146804_i.func_78857_a(i, i + 1);
/* 248 */             func_146790_a(i + 1);
/* 249 */             this.field_146803_h.func_148145_f(this.field_146803_h.func_148146_j());
/* 250 */             this.field_146803_h.func_148195_a(this.field_146804_i);
/*     */           } 
/* 252 */         } else if (i < this.field_146803_h.func_148127_b()) {
/* 253 */           func_146790_a(this.field_146803_h.func_148193_k() + 1);
/* 254 */           this.field_146803_h.func_148145_f(this.field_146803_h.func_148146_j());
/*     */           
/* 256 */           if (this.field_146803_h.func_148180_b(this.field_146803_h.func_148193_k()) instanceof ServerListEntryLanScan) {
/* 257 */             if (this.field_146803_h.func_148193_k() < this.field_146803_h.func_148127_b() - 1) {
/* 258 */               func_146790_a(this.field_146803_h.func_148127_b() + 1);
/* 259 */               this.field_146803_h.func_148145_f(this.field_146803_h.func_148146_j());
/*     */             } else {
/* 261 */               func_146790_a(-1);
/*     */             } 
/*     */           }
/*     */         } else {
/* 265 */           func_146790_a(-1);
/*     */         } 
/* 267 */       } else if (p_73869_2_ == 28 || p_73869_2_ == 156) {
/* 268 */         func_146284_a(this.field_146292_n.get(2));
/*     */       } else {
/* 270 */         super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */       } 
/*     */     } else {
/* 273 */       super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 279 */     this.field_146812_y = null;
/*     */     
/* 281 */     func_146276_q_();
/*     */     
/* 283 */     this.field_146803_h.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/* 284 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("multiplayer.title", new Object[0]), this.field_146294_l / 2, 20, 16777215);
/*     */     
/* 286 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */     
/* 288 */     if (this.field_146812_y != null) {
/* 289 */       func_146283_a(Lists.newArrayList(Splitter.on("\n").split(this.field_146812_y)), p_73863_1_, p_73863_2_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_146796_h() {
/* 294 */     GuiListExtended.IGuiListEntry iGuiListEntry = (this.field_146803_h.func_148193_k() < 0) ? null : this.field_146803_h.func_148180_b(this.field_146803_h.func_148193_k());
/*     */     
/* 296 */     if (iGuiListEntry instanceof ServerListEntryNormal) {
/* 297 */       func_146791_a(((ServerListEntryNormal)iGuiListEntry).func_148296_a());
/* 298 */     } else if (iGuiListEntry instanceof ServerListEntryLanDetected) {
/* 299 */       LanServerDetector.LanServer lanServer = ((ServerListEntryLanDetected)iGuiListEntry).func_148289_a();
/* 300 */       func_146791_a(new ServerData(lanServer.func_77487_a(), lanServer.func_77488_b(), true));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146791_a(ServerData p_146791_1_) {
/* 305 */     this.field_146297_k.func_147108_a((GuiScreen)new GuiConnecting(this, this.field_146297_k, p_146791_1_));
/*     */   }
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
/*     */   public void func_146790_a(int p_146790_1_) {
/* 322 */     this.field_146803_h.func_148192_c(p_146790_1_);
/*     */     
/* 324 */     GuiListExtended.IGuiListEntry iGuiListEntry = (p_146790_1_ < 0) ? null : this.field_146803_h.func_148180_b(p_146790_1_);
/* 325 */     this.field_146809_s.field_146124_l = false;
/* 326 */     this.field_146810_r.field_146124_l = false;
/* 327 */     this.field_146808_t.field_146124_l = false;
/*     */     
/* 329 */     if (iGuiListEntry != null && !(iGuiListEntry instanceof ServerListEntryLanScan)) {
/* 330 */       this.field_146809_s.field_146124_l = true;
/* 331 */       if (iGuiListEntry instanceof ServerListEntryNormal) {
/* 332 */         this.field_146810_r.field_146124_l = true;
/* 333 */         this.field_146808_t.field_146124_l = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public OldServerPinger func_146789_i() {
/* 339 */     return this.field_146797_f;
/*     */   }
/*     */   
/*     */   public void func_146793_a(String p_146793_1_) {
/* 343 */     this.field_146812_y = p_146793_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 348 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 349 */     this.field_146803_h.func_148179_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
/* 354 */     super.func_146286_b(p_146286_1_, p_146286_2_, p_146286_3_);
/* 355 */     this.field_146803_h.func_148181_b(p_146286_1_, p_146286_2_, p_146286_3_);
/*     */   }
/*     */   
/*     */   public ServerList func_146795_p() {
/* 359 */     return this.field_146804_i;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiMultiplayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */