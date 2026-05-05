/*     */ package net.minecraft.client.gui.achievement;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiOptionButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.IProgressMeter;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.C16PacketClientStatus;
/*     */ import net.minecraft.stats.Achievement;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatFileWriter;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Mouse;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiAchievements
/*     */   extends GuiScreen
/*     */   implements IProgressMeter
/*     */ {
/*  41 */   private static final int field_146572_y = AchievementList.field_76010_a * 24 - 112;
/*  42 */   private static final int field_146571_z = AchievementList.field_76008_b * 24 - 112;
/*  43 */   private static final int field_146559_A = AchievementList.field_76009_c * 24 - 77;
/*  44 */   private static final int field_146560_B = AchievementList.field_76006_d * 24 - 77;
/*     */ 
/*     */   
/*  47 */   private static final ResourceLocation field_146561_C = new ResourceLocation("textures/gui/achievement/achievement_background.png");
/*     */ 
/*     */   
/*     */   protected GuiScreen field_146562_a;
/*     */   
/*  52 */   protected int field_146555_f = 256;
/*  53 */   protected int field_146557_g = 202;
/*     */   protected int field_146563_h;
/*     */   protected int field_146564_i;
/*  56 */   protected float field_146570_r = 1.0F; protected double field_146569_s;
/*     */   protected double field_146568_t;
/*     */   protected double field_146567_u;
/*     */   protected double field_146566_v;
/*     */   protected double field_146565_w;
/*     */   protected double field_146573_x;
/*     */   private int field_146554_D;
/*     */   private StatFileWriter field_146556_E;
/*     */   private boolean field_146558_F = true;
/*     */   private static final String __OBFID = "CL_00000722";
/*     */   
/*     */   public GuiAchievements(GuiScreen p_i45026_1_, StatFileWriter p_i45026_2_) {
/*  68 */     this.field_146562_a = p_i45026_1_;
/*  69 */     this.field_146556_E = p_i45026_2_;
/*  70 */     char c1 = '';
/*  71 */     char c2 = '';
/*     */     
/*  73 */     this.field_146569_s = this.field_146567_u = this.field_146565_w = (AchievementList.field_76004_f.field_75993_a * 24 - c1 / 2 - 12);
/*  74 */     this.field_146568_t = this.field_146566_v = this.field_146573_x = (AchievementList.field_76004_f.field_75991_b * 24 - c2 / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  79 */     this.field_146297_k.func_147114_u().func_147297_a((Packet)new C16PacketClientStatus(C16PacketClientStatus.EnumState.REQUEST_STATS));
/*  80 */     this.field_146292_n.clear();
/*  81 */     this.field_146292_n.add(new GuiOptionButton(1, this.field_146294_l / 2 + 24, this.field_146295_m / 2 + 74, 80, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  86 */     if (this.field_146558_F)
/*  87 */       return;  if (p_146284_1_.field_146127_k == 1) {
/*  88 */       this.field_146297_k.func_147108_a(this.field_146562_a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  94 */     if (p_73869_2_ == this.field_146297_k.field_71474_y.field_151445_Q.func_151463_i()) {
/*  95 */       this.field_146297_k.func_147108_a(null);
/*  96 */       this.field_146297_k.func_71381_h();
/*     */     } else {
/*  98 */       super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 104 */     if (this.field_146558_F) {
/* 105 */       func_146276_q_();
/* 106 */       func_73732_a(this.field_146289_q, I18n.func_135052_a("multiplayer.downloadingStats", new Object[0]), this.field_146294_l / 2, this.field_146295_m / 2, 16777215);
/* 107 */       func_73732_a(this.field_146289_q, field_146510_b_[(int)(Minecraft.func_71386_F() / 150L % field_146510_b_.length)], this.field_146294_l / 2, this.field_146295_m / 2 + this.field_146289_q.field_78288_b * 2, 16777215);
/*     */     } else {
/* 109 */       if (Mouse.isButtonDown(0)) {
/* 110 */         int j = (this.field_146294_l - this.field_146555_f) / 2;
/* 111 */         int k = (this.field_146295_m - this.field_146557_g) / 2;
/*     */         
/* 113 */         int m = j + 8;
/* 114 */         int n = k + 17;
/*     */         
/* 116 */         if ((this.field_146554_D == 0 || this.field_146554_D == 1) && 
/* 117 */           p_73863_1_ >= m && p_73863_1_ < m + 224 && p_73863_2_ >= n && p_73863_2_ < n + 155) {
/* 118 */           if (this.field_146554_D == 0) {
/* 119 */             this.field_146554_D = 1;
/*     */           } else {
/* 121 */             this.field_146567_u -= ((p_73863_1_ - this.field_146563_h) * this.field_146570_r);
/* 122 */             this.field_146566_v -= ((p_73863_2_ - this.field_146564_i) * this.field_146570_r);
/* 123 */             this.field_146565_w = this.field_146569_s = this.field_146567_u;
/* 124 */             this.field_146573_x = this.field_146568_t = this.field_146566_v;
/*     */           } 
/* 126 */           this.field_146563_h = p_73863_1_;
/* 127 */           this.field_146564_i = p_73863_2_;
/*     */         } 
/*     */       } else {
/*     */         
/* 131 */         this.field_146554_D = 0;
/*     */       } 
/*     */       
/* 134 */       int i = Mouse.getDWheel();
/* 135 */       float f = this.field_146570_r;
/* 136 */       if (i < 0) {
/* 137 */         this.field_146570_r += 0.25F;
/* 138 */       } else if (i > 0) {
/* 139 */         this.field_146570_r -= 0.25F;
/*     */       } 
/*     */       
/* 142 */       this.field_146570_r = MathHelper.func_76131_a(this.field_146570_r, 1.0F, 2.0F);
/*     */       
/* 144 */       if (this.field_146570_r != f) {
/* 145 */         float f1 = f - this.field_146570_r;
/* 146 */         float f2 = f * this.field_146555_f;
/* 147 */         float f3 = f * this.field_146557_g;
/* 148 */         float f4 = this.field_146570_r * this.field_146555_f;
/* 149 */         float f5 = this.field_146570_r * this.field_146557_g;
/* 150 */         this.field_146567_u -= ((f4 - f2) * 0.5F);
/* 151 */         this.field_146566_v -= ((f5 - f3) * 0.5F);
/* 152 */         this.field_146565_w = this.field_146569_s = this.field_146567_u;
/* 153 */         this.field_146573_x = this.field_146568_t = this.field_146566_v;
/*     */       } 
/*     */ 
/*     */       
/* 157 */       if (this.field_146565_w < field_146572_y) this.field_146565_w = field_146572_y; 
/* 158 */       if (this.field_146573_x < field_146571_z) this.field_146573_x = field_146571_z; 
/* 159 */       if (this.field_146565_w >= field_146559_A) this.field_146565_w = (field_146559_A - 1); 
/* 160 */       if (this.field_146573_x >= field_146560_B) this.field_146573_x = (field_146560_B - 1);
/*     */       
/* 162 */       func_146276_q_();
/* 163 */       func_146552_b(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */       
/* 165 */       GL11.glDisable(2896);
/* 166 */       GL11.glDisable(2929);
/*     */       
/* 168 */       func_146553_h();
/*     */       
/* 170 */       GL11.glEnable(2896);
/* 171 */       GL11.glEnable(2929);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146509_g() {
/* 177 */     if (this.field_146558_F) {
/* 178 */       this.field_146558_F = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 184 */     if (this.field_146558_F)
/* 185 */       return;  this.field_146569_s = this.field_146567_u;
/* 186 */     this.field_146568_t = this.field_146566_v;
/*     */     
/* 188 */     double d1 = this.field_146565_w - this.field_146567_u;
/* 189 */     double d2 = this.field_146573_x - this.field_146566_v;
/* 190 */     if (d1 * d1 + d2 * d2 < 4.0D) {
/* 191 */       this.field_146567_u += d1;
/* 192 */       this.field_146566_v += d2;
/*     */     } else {
/* 194 */       this.field_146567_u += d1 * 0.85D;
/* 195 */       this.field_146566_v += d2 * 0.85D;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146553_h() {
/* 200 */     int i = (this.field_146294_l - this.field_146555_f) / 2;
/* 201 */     int j = (this.field_146295_m - this.field_146557_g) / 2;
/* 202 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("gui.achievements", new Object[0]), i + 15, j + 5, 4210752);
/*     */   }
/*     */   
/*     */   protected void func_146552_b(int p_146552_1_, int p_146552_2_, float p_146552_3_) {
/* 206 */     int i = MathHelper.func_76128_c(this.field_146569_s + (this.field_146567_u - this.field_146569_s) * p_146552_3_);
/* 207 */     int j = MathHelper.func_76128_c(this.field_146568_t + (this.field_146566_v - this.field_146568_t) * p_146552_3_);
/*     */     
/* 209 */     if (i < field_146572_y) i = field_146572_y; 
/* 210 */     if (j < field_146571_z) j = field_146571_z; 
/* 211 */     if (i >= field_146559_A) i = field_146559_A - 1; 
/* 212 */     if (j >= field_146560_B) j = field_146560_B - 1;
/*     */     
/* 214 */     int k = (this.field_146294_l - this.field_146555_f) / 2;
/* 215 */     int m = (this.field_146295_m - this.field_146557_g) / 2;
/*     */     
/* 217 */     int n = k + 16;
/* 218 */     int i1 = m + 17;
/*     */     
/* 220 */     this.field_73735_i = 0.0F;
/* 221 */     GL11.glDepthFunc(518);
/* 222 */     GL11.glPushMatrix();
/* 223 */     GL11.glTranslatef(n, i1, -200.0F);
/* 224 */     GL11.glScalef(1.0F / this.field_146570_r, 1.0F / this.field_146570_r, 0.0F);
/*     */     
/* 226 */     GL11.glEnable(3553);
/* 227 */     GL11.glDisable(2896);
/* 228 */     GL11.glEnable(32826);
/* 229 */     GL11.glEnable(2903);
/*     */     
/* 231 */     int i2 = i + 288 >> 4;
/* 232 */     int i3 = j + 288 >> 4;
/* 233 */     int i4 = (i + 288) % 16;
/* 234 */     int i5 = (j + 288) % 16;
/*     */     
/* 236 */     byte b1 = 4;
/* 237 */     byte b2 = 8;
/* 238 */     byte b3 = 10;
/* 239 */     byte b4 = 22;
/* 240 */     byte b5 = 37;
/*     */     
/* 242 */     Random random = new Random();
/* 243 */     float f1 = 16.0F / this.field_146570_r;
/* 244 */     float f2 = 16.0F / this.field_146570_r;
/*     */     byte b6;
/* 246 */     for (b6 = 0; b6 * f1 - i5 < 155.0F; b6++) {
/* 247 */       float f = 0.6F - (i3 + b6) / 25.0F * 0.3F;
/* 248 */       GL11.glColor4f(f, f, f, 1.0F);
/*     */       
/* 250 */       for (byte b = 0; b * f2 - i4 < 224.0F; b++) {
/* 251 */         random.setSeed((this.field_146297_k.func_110432_I().func_148255_b().hashCode() + i2 + b + (i3 + b6) * 16));
/* 252 */         int i6 = random.nextInt(1 + i3 + b6) + (i3 + b6) / 2;
/* 253 */         IIcon iIcon = Blocks.field_150354_m.func_149691_a(0, 0);
/*     */         
/* 255 */         if (i6 > 37 || i3 + b6 == 35) {
/* 256 */           iIcon = Blocks.field_150357_h.func_149691_a(0, 0);
/* 257 */         } else if (i6 == 22) {
/* 258 */           if (random.nextInt(2) == 0) {
/* 259 */             iIcon = Blocks.field_150482_ag.func_149691_a(0, 0);
/*     */           } else {
/* 261 */             iIcon = Blocks.field_150450_ax.func_149691_a(0, 0);
/*     */           } 
/* 263 */         } else if (i6 == 10) {
/* 264 */           iIcon = Blocks.field_150366_p.func_149691_a(0, 0);
/* 265 */         } else if (i6 == 8) {
/* 266 */           iIcon = Blocks.field_150365_q.func_149691_a(0, 0);
/* 267 */         } else if (i6 > 4) {
/* 268 */           iIcon = Blocks.field_150348_b.func_149691_a(0, 0);
/* 269 */         } else if (i6 > 0) {
/* 270 */           iIcon = Blocks.field_150346_d.func_149691_a(0, 0);
/*     */         } 
/*     */         
/* 273 */         this.field_146297_k.func_110434_K().func_110577_a(TextureMap.field_110575_b);
/*     */         
/* 275 */         func_94065_a(b * 16 - i4, b6 * 16 - i5, iIcon, 16, 16);
/*     */       } 
/*     */     } 
/*     */     
/* 279 */     GL11.glEnable(2929);
/* 280 */     GL11.glDepthFunc(515);
/* 281 */     this.field_146297_k.func_110434_K().func_110577_a(field_146561_C);
/*     */     
/* 283 */     for (b6 = 0; b6 < AchievementList.field_76007_e.size(); b6++) {
/* 284 */       Achievement achievement1 = AchievementList.field_76007_e.get(b6);
/* 285 */       if (achievement1.field_75992_c != null) {
/*     */         
/* 287 */         int i6 = achievement1.field_75993_a * 24 - i + 11;
/* 288 */         int i7 = achievement1.field_75991_b * 24 - j + 11;
/*     */         
/* 290 */         int i8 = achievement1.field_75992_c.field_75993_a * 24 - i + 11;
/* 291 */         int i9 = achievement1.field_75992_c.field_75991_b * 24 - j + 11;
/*     */         
/* 293 */         boolean bool1 = this.field_146556_E.func_77443_a(achievement1);
/* 294 */         boolean bool2 = this.field_146556_E.func_77442_b(achievement1);
/* 295 */         int i10 = this.field_146556_E.func_150874_c(achievement1);
/*     */         
/* 297 */         if (i10 <= 4) {
/*     */           
/* 299 */           int i11 = -16777216;
/* 300 */           if (bool1) { i11 = -6250336; }
/* 301 */           else if (bool2) { i11 = -16711936; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 307 */           func_73730_a(i6, i8, i7, i11);
/* 308 */           func_73728_b(i8, i7, i9, i11);
/*     */           
/* 310 */           if (i6 > i8) {
/*     */             
/* 312 */             func_73729_b(i6 - 11 - 7, i7 - 5, 114, 234, 7, 11);
/* 313 */           } else if (i6 < i8) {
/*     */             
/* 315 */             func_73729_b(i6 + 11, i7 - 5, 107, 234, 7, 11);
/* 316 */           } else if (i7 > i9) {
/*     */             
/* 318 */             func_73729_b(i6 - 5, i7 - 11 - 7, 96, 234, 11, 7);
/* 319 */           } else if (i7 < i9) {
/*     */             
/* 321 */             func_73729_b(i6 - 5, i7 + 11, 96, 241, 11, 7);
/*     */           } 
/*     */         } 
/*     */       } 
/* 325 */     }  Achievement achievement = null;
/* 326 */     RenderItem renderItem = new RenderItem();
/* 327 */     float f3 = (p_146552_1_ - n) * this.field_146570_r;
/* 328 */     float f4 = (p_146552_2_ - i1) * this.field_146570_r;
/*     */     
/* 330 */     RenderHelper.func_74520_c();
/* 331 */     GL11.glDisable(2896);
/* 332 */     GL11.glEnable(32826);
/* 333 */     GL11.glEnable(2903);
/*     */     
/* 335 */     for (byte b7 = 0; b7 < AchievementList.field_76007_e.size(); b7++) {
/* 336 */       Achievement achievement1 = AchievementList.field_76007_e.get(b7);
/*     */       
/* 338 */       int i6 = achievement1.field_75993_a * 24 - i;
/* 339 */       int i7 = achievement1.field_75991_b * 24 - j;
/*     */       
/* 341 */       if (i6 >= -24 && i7 >= -24 && i6 <= 224.0F * this.field_146570_r && i7 <= 155.0F * this.field_146570_r) {
/* 342 */         int i8 = this.field_146556_E.func_150874_c(achievement1);
/*     */         
/* 344 */         if (this.field_146556_E.func_77443_a(achievement1)) {
/* 345 */           float f = 0.75F;
/* 346 */           GL11.glColor4f(f, f, f, 1.0F);
/* 347 */         } else if (this.field_146556_E.func_77442_b(achievement1)) {
/* 348 */           float f = 1.0F;
/* 349 */           GL11.glColor4f(f, f, f, 1.0F);
/* 350 */         } else if (i8 < 3) {
/* 351 */           float f = 0.3F;
/* 352 */           GL11.glColor4f(f, f, f, 1.0F);
/* 353 */         } else if (i8 == 3) {
/* 354 */           float f = 0.2F;
/* 355 */           GL11.glColor4f(f, f, f, 1.0F);
/* 356 */         } else if (i8 == 4) {
/* 357 */           float f = 0.1F;
/* 358 */           GL11.glColor4f(f, f, f, 1.0F);
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 367 */         this.field_146297_k.func_110434_K().func_110577_a(field_146561_C);
/*     */         
/* 369 */         if (achievement1.func_75984_f()) {
/* 370 */           func_73729_b(i6 - 2, i7 - 2, 26, 202, 26, 26);
/*     */         } else {
/* 372 */           func_73729_b(i6 - 2, i7 - 2, 0, 202, 26, 26);
/*     */         } 
/*     */         
/* 375 */         if (!this.field_146556_E.func_77442_b(achievement1)) {
/* 376 */           float f = 0.1F;
/* 377 */           GL11.glColor4f(f, f, f, 1.0F);
/* 378 */           renderItem.field_77024_a = false;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 385 */         GL11.glEnable(2896);
/* 386 */         GL11.glEnable(2884);
/* 387 */         renderItem.func_82406_b(this.field_146297_k.field_71466_p, this.field_146297_k.func_110434_K(), achievement1.field_75990_d, i6 + 3, i7 + 3);
/* 388 */         GL11.glBlendFunc(770, 771);
/* 389 */         GL11.glDisable(2896);
/* 390 */         if (!this.field_146556_E.func_77442_b(achievement1)) {
/* 391 */           renderItem.field_77024_a = true;
/*     */         }
/* 393 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/* 395 */         if (f3 >= i6 && f3 <= (i6 + 22) && f4 >= i7 && f4 <= (i7 + 22)) {
/* 396 */           achievement = achievement1;
/*     */         }
/*     */       } 
/*     */       continue;
/*     */     } 
/* 401 */     GL11.glDisable(2929);
/* 402 */     GL11.glEnable(3042);
/*     */     
/* 404 */     GL11.glPopMatrix();
/* 405 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 406 */     this.field_146297_k.func_110434_K().func_110577_a(field_146561_C);
/* 407 */     func_73729_b(k, m, 0, 0, this.field_146555_f, this.field_146557_g);
/*     */     
/* 409 */     this.field_73735_i = 0.0F;
/* 410 */     GL11.glDepthFunc(515);
/*     */     
/* 412 */     GL11.glDisable(2929);
/* 413 */     GL11.glEnable(3553);
/* 414 */     super.func_73863_a(p_146552_1_, p_146552_2_, p_146552_3_);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 420 */     if (achievement != null) {
/* 421 */       String str1 = achievement.func_150951_e().func_150260_c();
/* 422 */       String str2 = achievement.func_75989_e();
/*     */       
/* 424 */       int i6 = p_146552_1_ + 12;
/* 425 */       int i7 = p_146552_2_ - 4;
/* 426 */       int i8 = this.field_146556_E.func_150874_c(achievement);
/*     */       
/* 428 */       if (!this.field_146556_E.func_77442_b(achievement))
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 440 */         if (i8 == 3)
/* 441 */         { str1 = I18n.func_135052_a("achievement.unknown", new Object[0]);
/* 442 */           int i9 = Math.max(this.field_146289_q.func_78256_a(str1), 120);
/* 443 */           String str = (new ChatComponentTranslation("achievement.requires", new Object[] { achievement.field_75992_c.func_150951_e() })).func_150260_c();
/* 444 */           int i10 = this.field_146289_q.func_78267_b(str, i9);
/* 445 */           func_73733_a(i6 - 3, i7 - 3, i6 + i9 + 3, i7 + i10 + 12 + 3, -1073741824, -1073741824);
/* 446 */           this.field_146289_q.func_78279_b(str, i6, i7 + 12, i9, -9416624); }
/* 447 */         else if (i8 < 3)
/* 448 */         { int i9 = Math.max(this.field_146289_q.func_78256_a(str1), 120);
/* 449 */           String str = (new ChatComponentTranslation("achievement.requires", new Object[] { achievement.field_75992_c.func_150951_e() })).func_150260_c();
/* 450 */           int i10 = this.field_146289_q.func_78267_b(str, i9);
/* 451 */           func_73733_a(i6 - 3, i7 - 3, i6 + i9 + 3, i7 + i10 + 12 + 3, -1073741824, -1073741824);
/* 452 */           this.field_146289_q.func_78279_b(str, i6, i7 + 12, i9, -9416624); }
/*     */         else
/* 454 */         { str1 = null; }  } else { int i9 = Math.max(this.field_146289_q.func_78256_a(str1), 120); int i10 = this.field_146289_q.func_78267_b(str2, i9); if (this.field_146556_E.func_77443_a(achievement))
/*     */           i10 += 12;  func_73733_a(i6 - 3, i7 - 3, i6 + i9 + 3, i7 + i10 + 3 + 12, -1073741824, -1073741824); this.field_146289_q.func_78279_b(str2, i6, i7 + 12, i9, -6250336); if (this.field_146556_E.func_77443_a(achievement))
/*     */           this.field_146289_q.func_78261_a(I18n.func_135052_a("achievement.taken", new Object[0]), i6, i7 + i10 + 4, -7302913);  }
/* 457 */        if (str1 != null) {
/* 458 */         this.field_146289_q.func_78261_a(str1, i6, i7, this.field_146556_E.func_77442_b(achievement) ? (achievement.func_75984_f() ? -128 : -1) : (achievement.func_75984_f() ? -8355776 : -8355712));
/*     */       }
/*     */     } 
/*     */     
/* 462 */     GL11.glEnable(2929);
/* 463 */     GL11.glEnable(2896);
/* 464 */     RenderHelper.func_74518_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 469 */     return !this.field_146558_F;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\achievement\GuiAchievements.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */