/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.storage.ISaveFormat;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiCreateWorld extends GuiScreen {
/*     */   private GuiScreen field_146332_f;
/*     */   private GuiTextField field_146333_g;
/*     */   private GuiTextField field_146335_h;
/*     */   private String field_146336_i;
/*  21 */   private String field_146342_r = "survival";
/*     */   
/*     */   private boolean field_146341_s = true;
/*     */   
/*     */   private boolean field_146340_t;
/*     */   
/*     */   private boolean field_146339_u;
/*     */   
/*     */   private boolean field_146338_v;
/*     */   
/*     */   private boolean field_146337_w;
/*     */   
/*     */   private boolean field_146345_x;
/*     */   
/*     */   private boolean field_146344_y;
/*     */   
/*     */   private GuiButton field_146343_z;
/*     */   
/*     */   private GuiButton field_146324_A;
/*     */   
/*     */   private GuiButton field_146325_B;
/*     */   
/*     */   private GuiButton field_146326_C;
/*     */   
/*     */   private GuiButton field_146320_D;
/*     */   private GuiButton field_146321_E;
/*     */   private GuiButton field_146322_F;
/*     */   private String field_146323_G;
/*     */   private String field_146328_H;
/*     */   private String field_146329_I;
/*     */   private String field_146330_J;
/*     */   private int field_146331_K;
/*  53 */   public String field_146334_a = "";
/*     */   
/*     */   public GuiCreateWorld(GuiScreen p_i1030_1_) {
/*  56 */     this.field_146332_f = p_i1030_1_;
/*     */     
/*  58 */     this.field_146329_I = "";
/*  59 */     this.field_146330_J = I18n.func_135052_a("selectWorld.newWorld", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  64 */     this.field_146333_g.func_146178_a();
/*  65 */     this.field_146335_h.func_146178_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  71 */     Keyboard.enableRepeatEvents(true);
/*  72 */     this.field_146292_n.clear();
/*  73 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 155, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("selectWorld.create", new Object[0])));
/*  74 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 + 5, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */     
/*  76 */     this.field_146292_n.add(this.field_146343_z = new GuiButton(2, this.field_146294_l / 2 - 75, 115, 150, 20, I18n.func_135052_a("selectWorld.gameMode", new Object[0])));
/*  77 */     this.field_146292_n.add(this.field_146324_A = new GuiButton(3, this.field_146294_l / 2 - 75, 187, 150, 20, I18n.func_135052_a("selectWorld.moreWorldOptions", new Object[0])));
/*     */     
/*  79 */     this.field_146292_n.add(this.field_146325_B = new GuiButton(4, this.field_146294_l / 2 - 155, 100, 150, 20, I18n.func_135052_a("selectWorld.mapFeatures", new Object[0])));
/*  80 */     this.field_146325_B.field_146125_m = false;
/*  81 */     this.field_146292_n.add(this.field_146326_C = new GuiButton(7, this.field_146294_l / 2 + 5, 151, 150, 20, I18n.func_135052_a("selectWorld.bonusItems", new Object[0])));
/*  82 */     this.field_146326_C.field_146125_m = false;
/*  83 */     this.field_146292_n.add(this.field_146320_D = new GuiButton(5, this.field_146294_l / 2 + 5, 100, 150, 20, I18n.func_135052_a("selectWorld.mapType", new Object[0])));
/*  84 */     this.field_146320_D.field_146125_m = false;
/*  85 */     this.field_146292_n.add(this.field_146321_E = new GuiButton(6, this.field_146294_l / 2 - 155, 151, 150, 20, I18n.func_135052_a("selectWorld.allowCommands", new Object[0])));
/*  86 */     this.field_146321_E.field_146125_m = false;
/*  87 */     this.field_146292_n.add(this.field_146322_F = new GuiButton(8, this.field_146294_l / 2 + 5, 120, 150, 20, I18n.func_135052_a("selectWorld.customizeType", new Object[0])));
/*  88 */     this.field_146322_F.field_146125_m = false;
/*     */     
/*  90 */     this.field_146333_g = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 100, 60, 200, 20);
/*  91 */     this.field_146333_g.func_146195_b(true);
/*  92 */     this.field_146333_g.func_146180_a(this.field_146330_J);
/*     */     
/*  94 */     this.field_146335_h = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 100, 60, 200, 20);
/*  95 */     this.field_146335_h.func_146180_a(this.field_146329_I);
/*     */     
/*  97 */     func_146316_a(this.field_146344_y);
/*     */     
/*  99 */     func_146314_g();
/* 100 */     func_146319_h();
/*     */   }
/*     */   
/*     */   private void func_146314_g() {
/* 104 */     this.field_146336_i = this.field_146333_g.func_146179_b().trim();
/*     */     
/* 106 */     for (char c : ChatAllowedCharacters.field_71567_b) {
/* 107 */       this.field_146336_i = this.field_146336_i.replace(c, '_');
/*     */     }
/*     */     
/* 110 */     if (MathHelper.func_76139_a(this.field_146336_i)) {
/* 111 */       this.field_146336_i = "World";
/*     */     }
/* 113 */     this.field_146336_i = func_146317_a(this.field_146297_k.func_71359_d(), this.field_146336_i);
/*     */   }
/*     */   
/*     */   private void func_146319_h() {
/* 117 */     this.field_146343_z.field_146126_j = I18n.func_135052_a("selectWorld.gameMode", new Object[0]) + " " + I18n.func_135052_a("selectWorld.gameMode." + this.field_146342_r, new Object[0]);
/* 118 */     this.field_146323_G = I18n.func_135052_a("selectWorld.gameMode." + this.field_146342_r + ".line1", new Object[0]);
/* 119 */     this.field_146328_H = I18n.func_135052_a("selectWorld.gameMode." + this.field_146342_r + ".line2", new Object[0]);
/*     */     
/* 121 */     this.field_146325_B.field_146126_j = I18n.func_135052_a("selectWorld.mapFeatures", new Object[0]) + " ";
/* 122 */     if (this.field_146341_s) {
/* 123 */       this.field_146325_B.field_146126_j += I18n.func_135052_a("options.on", new Object[0]);
/*     */     } else {
/* 125 */       this.field_146325_B.field_146126_j += I18n.func_135052_a("options.off", new Object[0]);
/*     */     } 
/* 127 */     this.field_146326_C.field_146126_j = I18n.func_135052_a("selectWorld.bonusItems", new Object[0]) + " ";
/* 128 */     if (this.field_146338_v && !this.field_146337_w) {
/* 129 */       this.field_146326_C.field_146126_j += I18n.func_135052_a("options.on", new Object[0]);
/*     */     } else {
/* 131 */       this.field_146326_C.field_146126_j += I18n.func_135052_a("options.off", new Object[0]);
/*     */     } 
/* 133 */     this.field_146320_D.field_146126_j = I18n.func_135052_a("selectWorld.mapType", new Object[0]) + " " + I18n.func_135052_a(WorldType.field_77139_a[this.field_146331_K].func_77128_b(), new Object[0]);
/*     */     
/* 135 */     this.field_146321_E.field_146126_j = I18n.func_135052_a("selectWorld.allowCommands", new Object[0]) + " ";
/* 136 */     if (this.field_146340_t && !this.field_146337_w) {
/* 137 */       this.field_146321_E.field_146126_j += I18n.func_135052_a("options.on", new Object[0]);
/*     */     } else {
/* 139 */       this.field_146321_E.field_146126_j += I18n.func_135052_a("options.off", new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/* 143 */   private static final String[] field_146327_L = new String[] { "CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9" };
/*     */   
/*     */   private static final String __OBFID = "CL_00000689";
/*     */   
/*     */   public static String func_146317_a(ISaveFormat p_146317_0_, String p_146317_1_) {
/* 148 */     p_146317_1_ = p_146317_1_.replaceAll("[\\./\"]", "_");
/* 149 */     for (String str : field_146327_L) {
/* 150 */       if (p_146317_1_.equalsIgnoreCase(str)) {
/* 151 */         p_146317_1_ = "_" + p_146317_1_ + "_";
/*     */       }
/*     */     } 
/* 154 */     while (p_146317_0_.func_75803_c(p_146317_1_) != null) {
/* 155 */       p_146317_1_ = p_146317_1_ + "-";
/*     */     }
/* 157 */     return p_146317_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 162 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 167 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/* 169 */     if (p_146284_1_.field_146127_k == 1) {
/* 170 */       this.field_146297_k.func_147108_a(this.field_146332_f);
/* 171 */     } else if (p_146284_1_.field_146127_k == 0) {
/*     */       
/* 173 */       this.field_146297_k.func_147108_a(null);
/* 174 */       if (this.field_146345_x)
/* 175 */         return;  this.field_146345_x = true;
/*     */       
/* 177 */       long l = (new Random()).nextLong();
/* 178 */       String str = this.field_146335_h.func_146179_b();
/*     */       
/* 180 */       if (!MathHelper.func_76139_a(str)) {
/*     */         
/*     */         try {
/* 183 */           long l1 = Long.parseLong(str);
/* 184 */           if (l1 != 0L) {
/* 185 */             l = l1;
/*     */           }
/* 187 */         } catch (NumberFormatException numberFormatException) {
/*     */           
/* 189 */           l = str.hashCode();
/*     */         } 
/*     */       }
/*     */       
/* 193 */       WorldSettings.GameType gameType = WorldSettings.GameType.func_77142_a(this.field_146342_r);
/* 194 */       WorldSettings worldSettings = new WorldSettings(l, gameType, this.field_146341_s, this.field_146337_w, WorldType.field_77139_a[this.field_146331_K]);
/* 195 */       worldSettings.func_82750_a(this.field_146334_a);
/* 196 */       if (this.field_146338_v && !this.field_146337_w) {
/* 197 */         worldSettings.func_77159_a();
/*     */       }
/* 199 */       if (this.field_146340_t && !this.field_146337_w) {
/* 200 */         worldSettings.func_77166_b();
/*     */       }
/* 202 */       this.field_146297_k.func_71371_a(this.field_146336_i, this.field_146333_g.func_146179_b().trim(), worldSettings);
/* 203 */     } else if (p_146284_1_.field_146127_k == 3) {
/* 204 */       func_146315_i();
/* 205 */     } else if (p_146284_1_.field_146127_k == 2) {
/* 206 */       if (this.field_146342_r.equals("survival")) {
/* 207 */         if (!this.field_146339_u) this.field_146340_t = false; 
/* 208 */         this.field_146337_w = false;
/* 209 */         this.field_146342_r = "hardcore";
/* 210 */         this.field_146337_w = true;
/* 211 */         this.field_146321_E.field_146124_l = false;
/* 212 */         this.field_146326_C.field_146124_l = false;
/* 213 */         func_146319_h();
/* 214 */       } else if (this.field_146342_r.equals("hardcore")) {
/* 215 */         if (!this.field_146339_u) this.field_146340_t = true; 
/* 216 */         this.field_146337_w = false;
/* 217 */         this.field_146342_r = "creative";
/* 218 */         func_146319_h();
/* 219 */         this.field_146337_w = false;
/* 220 */         this.field_146321_E.field_146124_l = true;
/* 221 */         this.field_146326_C.field_146124_l = true;
/*     */       } else {
/* 223 */         if (!this.field_146339_u) this.field_146340_t = false; 
/* 224 */         this.field_146342_r = "survival";
/* 225 */         func_146319_h();
/* 226 */         this.field_146321_E.field_146124_l = true;
/* 227 */         this.field_146326_C.field_146124_l = true;
/* 228 */         this.field_146337_w = false;
/*     */       } 
/* 230 */       func_146319_h();
/* 231 */     } else if (p_146284_1_.field_146127_k == 4) {
/* 232 */       this.field_146341_s = !this.field_146341_s;
/* 233 */       func_146319_h();
/* 234 */     } else if (p_146284_1_.field_146127_k == 7) {
/* 235 */       this.field_146338_v = !this.field_146338_v;
/* 236 */       func_146319_h();
/* 237 */     } else if (p_146284_1_.field_146127_k == 5) {
/* 238 */       this.field_146331_K++;
/* 239 */       if (this.field_146331_K >= WorldType.field_77139_a.length) {
/* 240 */         this.field_146331_K = 0;
/*     */       }
/* 242 */       while (WorldType.field_77139_a[this.field_146331_K] == null || !WorldType.field_77139_a[this.field_146331_K].func_77126_d()) {
/* 243 */         this.field_146331_K++;
/* 244 */         if (this.field_146331_K >= WorldType.field_77139_a.length) {
/* 245 */           this.field_146331_K = 0;
/*     */         }
/*     */       } 
/* 248 */       this.field_146334_a = "";
/* 249 */       func_146319_h();
/* 250 */       func_146316_a(this.field_146344_y);
/* 251 */     } else if (p_146284_1_.field_146127_k == 6) {
/* 252 */       this.field_146339_u = true;
/* 253 */       this.field_146340_t = !this.field_146340_t;
/* 254 */       func_146319_h();
/* 255 */     } else if (p_146284_1_.field_146127_k == 8) {
/* 256 */       this.field_146297_k.func_147108_a(new GuiCreateFlatWorld(this, this.field_146334_a));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146315_i() {
/* 261 */     func_146316_a(!this.field_146344_y);
/*     */   }
/*     */   
/*     */   private void func_146316_a(boolean p_146316_1_) {
/* 265 */     this.field_146344_y = p_146316_1_;
/*     */     
/* 267 */     this.field_146343_z.field_146125_m = !this.field_146344_y;
/* 268 */     this.field_146325_B.field_146125_m = this.field_146344_y;
/* 269 */     this.field_146326_C.field_146125_m = this.field_146344_y;
/* 270 */     this.field_146320_D.field_146125_m = this.field_146344_y;
/* 271 */     this.field_146321_E.field_146125_m = this.field_146344_y;
/* 272 */     this.field_146322_F.field_146125_m = (this.field_146344_y && WorldType.field_77139_a[this.field_146331_K] == WorldType.field_77138_c);
/*     */     
/* 274 */     if (this.field_146344_y) {
/* 275 */       this.field_146324_A.field_146126_j = I18n.func_135052_a("gui.done", new Object[0]);
/*     */     } else {
/* 277 */       this.field_146324_A.field_146126_j = I18n.func_135052_a("selectWorld.moreWorldOptions", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 283 */     if (this.field_146333_g.func_146206_l() && !this.field_146344_y) {
/* 284 */       this.field_146333_g.func_146201_a(p_73869_1_, p_73869_2_);
/* 285 */       this.field_146330_J = this.field_146333_g.func_146179_b();
/* 286 */     } else if (this.field_146335_h.func_146206_l() && this.field_146344_y) {
/* 287 */       this.field_146335_h.func_146201_a(p_73869_1_, p_73869_2_);
/* 288 */       this.field_146329_I = this.field_146335_h.func_146179_b();
/*     */     } 
/*     */     
/* 291 */     if (p_73869_2_ == 28 || p_73869_2_ == 156) {
/* 292 */       func_146284_a(this.field_146292_n.get(0));
/*     */     }
/* 294 */     ((GuiButton)this.field_146292_n.get(0)).field_146124_l = (this.field_146333_g.func_146179_b().length() > 0);
/*     */     
/* 296 */     func_146314_g();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 301 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */     
/* 303 */     if (this.field_146344_y) {
/* 304 */       this.field_146335_h.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */     } else {
/* 306 */       this.field_146333_g.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 312 */     func_146276_q_();
/*     */     
/* 314 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("selectWorld.create", new Object[0]), this.field_146294_l / 2, 20, -1);
/* 315 */     if (this.field_146344_y) {
/* 316 */       func_73731_b(this.field_146289_q, I18n.func_135052_a("selectWorld.enterSeed", new Object[0]), this.field_146294_l / 2 - 100, 47, -6250336);
/* 317 */       func_73731_b(this.field_146289_q, I18n.func_135052_a("selectWorld.seedInfo", new Object[0]), this.field_146294_l / 2 - 100, 85, -6250336);
/* 318 */       func_73731_b(this.field_146289_q, I18n.func_135052_a("selectWorld.mapFeatures.info", new Object[0]), this.field_146294_l / 2 - 150, 122, -6250336);
/* 319 */       func_73731_b(this.field_146289_q, I18n.func_135052_a("selectWorld.allowCommands.info", new Object[0]), this.field_146294_l / 2 - 150, 172, -6250336);
/* 320 */       this.field_146335_h.func_146194_f();
/*     */       
/* 322 */       if (WorldType.field_77139_a[this.field_146331_K].func_151357_h()) {
/* 323 */         this.field_146289_q.func_78279_b(I18n.func_135052_a(WorldType.field_77139_a[this.field_146331_K].func_151359_c(), new Object[0]), this.field_146320_D.field_146128_h + 2, this.field_146320_D.field_146129_i + 22, this.field_146320_D.func_146117_b(), 10526880);
/*     */       }
/*     */     } else {
/* 326 */       func_73731_b(this.field_146289_q, I18n.func_135052_a("selectWorld.enterName", new Object[0]), this.field_146294_l / 2 - 100, 47, -6250336);
/* 327 */       func_73731_b(this.field_146289_q, I18n.func_135052_a("selectWorld.resultFolder", new Object[0]) + " " + this.field_146336_i, this.field_146294_l / 2 - 100, 85, -6250336);
/* 328 */       this.field_146333_g.func_146194_f();
/*     */       
/* 330 */       func_73731_b(this.field_146289_q, this.field_146323_G, this.field_146294_l / 2 - 100, 137, -6250336);
/* 331 */       func_73731_b(this.field_146289_q, this.field_146328_H, this.field_146294_l / 2 - 100, 149, -6250336);
/*     */     } 
/*     */     
/* 334 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   
/*     */   public void func_146318_a(WorldInfo p_146318_1_) {
/* 338 */     this.field_146330_J = I18n.func_135052_a("selectWorld.newWorld.copyOf", new Object[] { p_146318_1_.func_76065_j() });
/* 339 */     this.field_146329_I = p_146318_1_.func_76063_b() + "";
/* 340 */     this.field_146331_K = p_146318_1_.func_76067_t().func_82747_f();
/* 341 */     this.field_146334_a = p_146318_1_.func_82571_y();
/* 342 */     this.field_146341_s = p_146318_1_.func_76089_r();
/* 343 */     this.field_146340_t = p_146318_1_.func_76086_u();
/*     */     
/* 345 */     if (p_146318_1_.func_76093_s()) {
/* 346 */       this.field_146342_r = "hardcore";
/* 347 */     } else if (p_146318_1_.func_76077_q().func_77144_e()) {
/* 348 */       this.field_146342_r = "survival";
/* 349 */     } else if (p_146318_1_.func_76077_q().func_77145_d()) {
/* 350 */       this.field_146342_r = "creative";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiCreateWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */