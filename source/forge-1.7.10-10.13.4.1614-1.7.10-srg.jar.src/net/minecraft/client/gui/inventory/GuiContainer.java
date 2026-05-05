/*     */ package net.minecraft.client.gui.inventory;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Set;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class GuiContainer extends GuiScreen {
/*  23 */   protected static final ResourceLocation field_147001_a = new ResourceLocation("textures/gui/container/inventory.png");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  29 */   protected int field_146999_f = 176;
/*  30 */   protected int field_147000_g = 166;
/*     */   
/*     */   public Container field_147002_h;
/*     */   protected int field_147003_i;
/*     */   protected int field_147009_r;
/*     */   private Slot field_147006_u;
/*     */   private Slot field_147005_v;
/*     */   private boolean field_147004_w;
/*     */   private ItemStack field_147012_x;
/*     */   private int field_147011_y;
/*     */   private int field_147010_z;
/*     */   private Slot field_146989_A;
/*     */   private long field_146990_B;
/*     */   private ItemStack field_146991_C;
/*     */   private Slot field_146985_D;
/*     */   private long field_146986_E;
/*  46 */   protected final Set field_147008_s = new HashSet(); protected boolean field_147007_t;
/*     */   private int field_146987_F;
/*     */   private int field_146988_G;
/*     */   private boolean field_146995_H;
/*     */   private int field_146996_I;
/*     */   private long field_146997_J;
/*     */   private Slot field_146998_K;
/*     */   private int field_146992_L;
/*     */   private boolean field_146993_M;
/*     */   private ItemStack field_146994_N;
/*     */   private static final String __OBFID = "CL_00000737";
/*     */   
/*     */   public GuiContainer(Container p_i1072_1_) {
/*  59 */     this.field_147002_h = p_i1072_1_;
/*  60 */     this.field_146995_H = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  65 */     super.func_73866_w_();
/*  66 */     this.field_146297_k.field_71439_g.field_71070_bA = this.field_147002_h;
/*     */     
/*  68 */     this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/*  69 */     this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  74 */     func_146276_q_();
/*  75 */     int i = this.field_147003_i;
/*  76 */     int j = this.field_147009_r;
/*     */     
/*  78 */     func_146976_a(p_73863_3_, p_73863_1_, p_73863_2_);
/*     */     
/*  80 */     GL11.glDisable(32826);
/*  81 */     RenderHelper.func_74518_a();
/*  82 */     GL11.glDisable(2896);
/*  83 */     GL11.glDisable(2929);
/*     */     
/*  85 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */     
/*  87 */     RenderHelper.func_74520_c();
/*     */     
/*  89 */     GL11.glPushMatrix();
/*  90 */     GL11.glTranslatef(i, j, 0.0F);
/*     */     
/*  92 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  93 */     GL11.glEnable(32826);
/*     */     
/*  95 */     this.field_147006_u = null;
/*     */     
/*  97 */     char c1 = 'ð';
/*  98 */     char c2 = 'ð';
/*  99 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, c1 / 1.0F, c2 / 1.0F);
/* 100 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 102 */     for (byte b = 0; b < this.field_147002_h.field_75151_b.size(); b++) {
/* 103 */       Slot slot = this.field_147002_h.field_75151_b.get(b);
/*     */       
/* 105 */       func_146977_a(slot);
/*     */       
/* 107 */       if (func_146981_a(slot, p_73863_1_, p_73863_2_) && slot.func_111238_b()) {
/* 108 */         this.field_147006_u = slot;
/*     */         
/* 110 */         GL11.glDisable(2896);
/* 111 */         GL11.glDisable(2929);
/*     */         
/* 113 */         int k = slot.field_75223_e;
/* 114 */         int m = slot.field_75221_f;
/* 115 */         GL11.glColorMask(true, true, true, false);
/* 116 */         func_73733_a(k, m, k + 16, m + 16, -2130706433, -2130706433);
/* 117 */         GL11.glColorMask(true, true, true, true);
/* 118 */         GL11.glEnable(2896);
/* 119 */         GL11.glEnable(2929);
/*     */       } 
/*     */     } 
/*     */     
/* 123 */     func_146979_b(p_73863_1_, p_73863_2_);
/*     */     
/* 125 */     InventoryPlayer inventoryPlayer = this.field_146297_k.field_71439_g.field_71071_by;
/* 126 */     ItemStack itemStack = (this.field_147012_x == null) ? inventoryPlayer.func_70445_o() : this.field_147012_x;
/*     */     
/* 128 */     if (itemStack != null) {
/* 129 */       byte b1 = 8;
/* 130 */       byte b2 = (this.field_147012_x == null) ? 8 : 16;
/* 131 */       String str = null;
/*     */       
/* 133 */       if (this.field_147012_x != null && this.field_147004_w) {
/* 134 */         itemStack = itemStack.func_77946_l();
/* 135 */         itemStack.field_77994_a = MathHelper.func_76123_f(itemStack.field_77994_a / 2.0F);
/* 136 */       } else if (this.field_147007_t && this.field_147008_s.size() > 1) {
/* 137 */         itemStack = itemStack.func_77946_l();
/* 138 */         itemStack.field_77994_a = this.field_146996_I;
/* 139 */         if (itemStack.field_77994_a == 0) {
/* 140 */           str = "" + EnumChatFormatting.YELLOW + "0";
/*     */         }
/*     */       } 
/* 143 */       func_146982_a(itemStack, p_73863_1_ - i - b1, p_73863_2_ - j - b2, str);
/*     */     } 
/*     */     
/* 146 */     if (this.field_146991_C != null) {
/* 147 */       float f = (float)(Minecraft.func_71386_F() - this.field_146990_B) / 100.0F;
/*     */       
/* 149 */       if (f >= 1.0F) {
/* 150 */         f = 1.0F;
/* 151 */         this.field_146991_C = null;
/*     */       } 
/*     */       
/* 154 */       int k = this.field_146989_A.field_75223_e - this.field_147011_y;
/* 155 */       int m = this.field_146989_A.field_75221_f - this.field_147010_z;
/* 156 */       int n = this.field_147011_y + (int)(k * f);
/* 157 */       int i1 = this.field_147010_z + (int)(m * f);
/*     */       
/* 159 */       func_146982_a(this.field_146991_C, n, i1, (String)null);
/*     */     } 
/*     */     
/* 162 */     GL11.glPopMatrix();
/*     */     
/* 164 */     if (inventoryPlayer.func_70445_o() == null && this.field_147006_u != null && this.field_147006_u.func_75216_d()) {
/* 165 */       ItemStack itemStack1 = this.field_147006_u.func_75211_c();
/* 166 */       func_146285_a(itemStack1, p_73863_1_, p_73863_2_);
/*     */     } 
/*     */     
/* 169 */     GL11.glEnable(2896);
/* 170 */     GL11.glEnable(2929);
/* 171 */     RenderHelper.func_74519_b();
/*     */   }
/*     */   
/*     */   private void func_146982_a(ItemStack p_146982_1_, int p_146982_2_, int p_146982_3_, String p_146982_4_) {
/* 175 */     GL11.glTranslatef(0.0F, 0.0F, 32.0F);
/* 176 */     this.field_73735_i = 200.0F;
/* 177 */     field_146296_j.field_77023_b = 200.0F;
/*     */     
/* 179 */     field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), p_146982_1_, p_146982_2_, p_146982_3_);
/* 180 */     field_146296_j.func_94148_a(this.field_146289_q, this.field_146297_k.func_110434_K(), p_146982_1_, p_146982_2_, p_146982_3_ - ((this.field_147012_x == null) ? 0 : 8), p_146982_4_);
/* 181 */     this.field_73735_i = 0.0F;
/* 182 */     field_146296_j.field_77023_b = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {}
/*     */   
/*     */   protected abstract void func_146976_a(float paramFloat, int paramInt1, int paramInt2);
/*     */   
/*     */   private void func_146977_a(Slot p_146977_1_) {
/* 191 */     int i = p_146977_1_.field_75223_e;
/* 192 */     int j = p_146977_1_.field_75221_f;
/* 193 */     ItemStack itemStack1 = p_146977_1_.func_75211_c();
/* 194 */     boolean bool1 = false;
/* 195 */     boolean bool2 = (p_146977_1_ == this.field_147005_v && this.field_147012_x != null && !this.field_147004_w) ? true : false;
/* 196 */     ItemStack itemStack2 = this.field_146297_k.field_71439_g.field_71071_by.func_70445_o();
/* 197 */     String str = null;
/*     */     
/* 199 */     if (p_146977_1_ == this.field_147005_v && this.field_147012_x != null && this.field_147004_w && itemStack1 != null) {
/* 200 */       itemStack1 = itemStack1.func_77946_l();
/* 201 */       itemStack1.field_77994_a /= 2;
/* 202 */     } else if (this.field_147007_t && this.field_147008_s.contains(p_146977_1_) && itemStack2 != null) {
/* 203 */       if (this.field_147008_s.size() == 1)
/* 204 */         return;  if (Container.func_94527_a(p_146977_1_, itemStack2, true) && this.field_147002_h.func_94531_b(p_146977_1_)) {
/* 205 */         itemStack1 = itemStack2.func_77946_l();
/* 206 */         bool1 = true;
/*     */         
/* 208 */         Container.func_94525_a(this.field_147008_s, this.field_146987_F, itemStack1, (p_146977_1_.func_75211_c() == null) ? 0 : (p_146977_1_.func_75211_c()).field_77994_a);
/*     */         
/* 210 */         if (itemStack1.field_77994_a > itemStack1.func_77976_d()) {
/* 211 */           str = EnumChatFormatting.YELLOW + "" + itemStack1.func_77976_d();
/* 212 */           itemStack1.field_77994_a = itemStack1.func_77976_d();
/*     */         } 
/* 214 */         if (itemStack1.field_77994_a > p_146977_1_.func_75219_a()) {
/* 215 */           str = EnumChatFormatting.YELLOW + "" + p_146977_1_.func_75219_a();
/* 216 */           itemStack1.field_77994_a = p_146977_1_.func_75219_a();
/*     */         } 
/*     */       } else {
/* 219 */         this.field_147008_s.remove(p_146977_1_);
/* 220 */         func_146980_g();
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     this.field_73735_i = 100.0F;
/* 225 */     field_146296_j.field_77023_b = 100.0F;
/* 226 */     if (itemStack1 == null) {
/* 227 */       IIcon iIcon = p_146977_1_.func_75212_b();
/* 228 */       if (iIcon != null) {
/* 229 */         GL11.glDisable(2896);
/* 230 */         this.field_146297_k.func_110434_K().func_110577_a(TextureMap.field_110576_c);
/* 231 */         func_94065_a(i, j, iIcon, 16, 16);
/* 232 */         GL11.glEnable(2896);
/* 233 */         bool2 = true;
/*     */       } 
/*     */     } 
/*     */     
/* 237 */     if (!bool2) {
/* 238 */       if (bool1) func_73734_a(i, j, i + 16, j + 16, -2130706433); 
/* 239 */       GL11.glEnable(2929);
/* 240 */       field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack1, i, j);
/* 241 */       field_146296_j.func_94148_a(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack1, i, j, str);
/*     */     } 
/* 243 */     field_146296_j.field_77023_b = 0.0F;
/* 244 */     this.field_73735_i = 0.0F;
/*     */   }
/*     */   
/*     */   private void func_146980_g() {
/* 248 */     ItemStack itemStack = this.field_146297_k.field_71439_g.field_71071_by.func_70445_o();
/* 249 */     if (itemStack == null || !this.field_147007_t)
/* 250 */       return;  this.field_146996_I = itemStack.field_77994_a;
/*     */     
/* 252 */     for (Slot slot : this.field_147008_s) {
/* 253 */       ItemStack itemStack1 = itemStack.func_77946_l();
/* 254 */       byte b = (slot.func_75211_c() == null) ? 0 : (slot.func_75211_c()).field_77994_a;
/* 255 */       Container.func_94525_a(this.field_147008_s, this.field_146987_F, itemStack1, b);
/* 256 */       if (itemStack1.field_77994_a > itemStack1.func_77976_d()) itemStack1.field_77994_a = itemStack1.func_77976_d(); 
/* 257 */       if (itemStack1.field_77994_a > slot.func_75219_a()) itemStack1.field_77994_a = slot.func_75219_a(); 
/* 258 */       this.field_146996_I -= itemStack1.field_77994_a - b;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Slot func_146975_c(int p_146975_1_, int p_146975_2_) {
/* 263 */     for (byte b = 0; b < this.field_147002_h.field_75151_b.size(); b++) {
/* 264 */       Slot slot = this.field_147002_h.field_75151_b.get(b);
/* 265 */       if (func_146981_a(slot, p_146975_1_, p_146975_2_)) return slot; 
/*     */     } 
/* 267 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 272 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 273 */     boolean bool = (p_73864_3_ == this.field_146297_k.field_71474_y.field_74322_I.func_151463_i() + 100) ? true : false;
/* 274 */     Slot slot = func_146975_c(p_73864_1_, p_73864_2_);
/* 275 */     long l = Minecraft.func_71386_F();
/* 276 */     this.field_146993_M = (this.field_146998_K == slot && l - this.field_146997_J < 250L && this.field_146992_L == p_73864_3_);
/* 277 */     this.field_146995_H = false;
/*     */     
/* 279 */     if (p_73864_3_ == 0 || p_73864_3_ == 1 || bool) {
/* 280 */       int i = this.field_147003_i;
/* 281 */       int j = this.field_147009_r;
/* 282 */       boolean bool1 = (p_73864_1_ < i || p_73864_2_ < j || p_73864_1_ >= i + this.field_146999_f || p_73864_2_ >= j + this.field_147000_g) ? true : false;
/*     */       
/* 284 */       int k = -1;
/* 285 */       if (slot != null) k = slot.field_75222_d;
/*     */       
/* 287 */       if (bool1) {
/* 288 */         k = -999;
/*     */       }
/*     */       
/* 291 */       if (this.field_146297_k.field_71474_y.field_85185_A && bool1 && this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() == null) {
/* 292 */         this.field_146297_k.func_147108_a(null);
/*     */         
/*     */         return;
/*     */       } 
/* 296 */       if (k != -1) {
/* 297 */         if (this.field_146297_k.field_71474_y.field_85185_A) {
/* 298 */           if (slot != null && slot.func_75216_d()) {
/* 299 */             this.field_147005_v = slot;
/* 300 */             this.field_147012_x = null;
/* 301 */             this.field_147004_w = (p_73864_3_ == 1);
/*     */           } else {
/* 303 */             this.field_147005_v = null;
/*     */           } 
/* 305 */         } else if (!this.field_147007_t) {
/* 306 */           if (this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() == null) {
/* 307 */             if (p_73864_3_ == this.field_146297_k.field_71474_y.field_74322_I.func_151463_i() + 100) {
/* 308 */               func_146984_a(slot, k, p_73864_3_, 3);
/*     */             } else {
/* 310 */               boolean bool2 = (k != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54))) ? true : false;
/* 311 */               byte b = 0;
/* 312 */               if (bool2) {
/* 313 */                 this.field_146994_N = (slot != null && slot.func_75216_d()) ? slot.func_75211_c() : null;
/* 314 */                 b = 1;
/* 315 */               } else if (k == -999) {
/* 316 */                 b = 4;
/*     */               } 
/* 318 */               func_146984_a(slot, k, p_73864_3_, b);
/*     */             } 
/* 320 */             this.field_146995_H = true;
/*     */           } else {
/* 322 */             this.field_147007_t = true;
/* 323 */             this.field_146988_G = p_73864_3_;
/* 324 */             this.field_147008_s.clear();
/*     */             
/* 326 */             if (p_73864_3_ == 0) {
/* 327 */               this.field_146987_F = 0;
/* 328 */             } else if (p_73864_3_ == 1) {
/* 329 */               this.field_146987_F = 1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 336 */     this.field_146998_K = slot;
/* 337 */     this.field_146997_J = l;
/* 338 */     this.field_146992_L = p_73864_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146273_a(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {
/* 343 */     Slot slot = func_146975_c(p_146273_1_, p_146273_2_);
/* 344 */     ItemStack itemStack = this.field_146297_k.field_71439_g.field_71071_by.func_70445_o();
/*     */     
/* 346 */     if (this.field_147005_v != null && this.field_146297_k.field_71474_y.field_85185_A) {
/* 347 */       if (p_146273_3_ == 0 || p_146273_3_ == 1) {
/* 348 */         if (this.field_147012_x == null) {
/* 349 */           if (slot != this.field_147005_v) this.field_147012_x = this.field_147005_v.func_75211_c().func_77946_l(); 
/* 350 */         } else if (this.field_147012_x.field_77994_a > 1 && slot != null && Container.func_94527_a(slot, this.field_147012_x, false)) {
/* 351 */           long l = Minecraft.func_71386_F();
/*     */           
/* 353 */           if (this.field_146985_D == slot) {
/* 354 */             if (l - this.field_146986_E > 500L) {
/* 355 */               func_146984_a(this.field_147005_v, this.field_147005_v.field_75222_d, 0, 0);
/* 356 */               func_146984_a(slot, slot.field_75222_d, 1, 0);
/* 357 */               func_146984_a(this.field_147005_v, this.field_147005_v.field_75222_d, 0, 0);
/* 358 */               this.field_146986_E = l + 750L;
/* 359 */               this.field_147012_x.field_77994_a--;
/*     */             } 
/*     */           } else {
/* 362 */             this.field_146985_D = slot;
/* 363 */             this.field_146986_E = l;
/*     */           } 
/*     */         } 
/*     */       }
/* 367 */     } else if (this.field_147007_t && slot != null && itemStack != null && itemStack.field_77994_a > this.field_147008_s.size() && Container.func_94527_a(slot, itemStack, true) && slot.func_75214_a(itemStack) && this.field_147002_h.func_94531_b(slot)) {
/*     */       
/* 369 */       this.field_147008_s.add(slot);
/* 370 */       func_146980_g();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
/* 376 */     Slot slot = func_146975_c(p_146286_1_, p_146286_2_);
/* 377 */     int i = this.field_147003_i;
/* 378 */     int j = this.field_147009_r;
/* 379 */     boolean bool = (p_146286_1_ < i || p_146286_2_ < j || p_146286_1_ >= i + this.field_146999_f || p_146286_2_ >= j + this.field_147000_g) ? true : false;
/*     */     
/* 381 */     int k = -1;
/* 382 */     if (slot != null) k = slot.field_75222_d;
/*     */     
/* 384 */     if (bool) {
/* 385 */       k = -999;
/*     */     }
/*     */     
/* 388 */     if (this.field_146993_M && slot != null && p_146286_3_ == 0 && this.field_147002_h.func_94530_a(null, slot)) {
/* 389 */       if (func_146272_n()) {
/* 390 */         if (slot != null && slot.field_75224_c != null && this.field_146994_N != null) {
/* 391 */           for (Slot slot1 : this.field_147002_h.field_75151_b) {
/* 392 */             if (slot1 != null && slot1.func_82869_a((EntityPlayer)this.field_146297_k.field_71439_g) && slot1.func_75216_d() && slot1.field_75224_c == slot.field_75224_c && Container.func_94527_a(slot1, this.field_146994_N, true))
/*     */             {
/* 394 */               func_146984_a(slot1, slot1.field_75222_d, p_146286_3_, 1);
/*     */             }
/*     */           } 
/*     */         }
/*     */       } else {
/* 399 */         func_146984_a(slot, k, p_146286_3_, 6);
/*     */       } 
/* 401 */       this.field_146993_M = false;
/* 402 */       this.field_146997_J = 0L;
/*     */     } else {
/* 404 */       if (this.field_147007_t && this.field_146988_G != p_146286_3_) {
/* 405 */         this.field_147007_t = false;
/* 406 */         this.field_147008_s.clear();
/* 407 */         this.field_146995_H = true; return;
/*     */       } 
/* 409 */       if (this.field_146995_H) {
/* 410 */         this.field_146995_H = false;
/*     */         
/*     */         return;
/*     */       } 
/* 414 */       if (this.field_147005_v != null && this.field_146297_k.field_71474_y.field_85185_A) {
/* 415 */         if (p_146286_3_ == 0 || p_146286_3_ == 1) {
/* 416 */           if (this.field_147012_x == null && slot != this.field_147005_v) {
/* 417 */             this.field_147012_x = this.field_147005_v.func_75211_c();
/*     */           }
/*     */           
/* 420 */           boolean bool1 = Container.func_94527_a(slot, this.field_147012_x, false);
/*     */           
/* 422 */           if (k != -1 && this.field_147012_x != null && bool1) {
/* 423 */             func_146984_a(this.field_147005_v, this.field_147005_v.field_75222_d, p_146286_3_, 0);
/* 424 */             func_146984_a(slot, k, 0, 0);
/*     */             
/* 426 */             if (this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() != null) {
/* 427 */               func_146984_a(this.field_147005_v, this.field_147005_v.field_75222_d, p_146286_3_, 0);
/* 428 */               this.field_147011_y = p_146286_1_ - i;
/* 429 */               this.field_147010_z = p_146286_2_ - j;
/* 430 */               this.field_146989_A = this.field_147005_v;
/* 431 */               this.field_146991_C = this.field_147012_x;
/* 432 */               this.field_146990_B = Minecraft.func_71386_F();
/*     */             } else {
/* 434 */               this.field_146991_C = null;
/*     */             } 
/* 436 */           } else if (this.field_147012_x != null) {
/* 437 */             this.field_147011_y = p_146286_1_ - i;
/* 438 */             this.field_147010_z = p_146286_2_ - j;
/* 439 */             this.field_146989_A = this.field_147005_v;
/* 440 */             this.field_146991_C = this.field_147012_x;
/* 441 */             this.field_146990_B = Minecraft.func_71386_F();
/*     */           } 
/*     */           
/* 444 */           this.field_147012_x = null;
/* 445 */           this.field_147005_v = null;
/*     */         } 
/* 447 */       } else if (this.field_147007_t && !this.field_147008_s.isEmpty()) {
/* 448 */         func_146984_a((Slot)null, -999, Container.func_94534_d(0, this.field_146987_F), 5);
/*     */ 
/*     */         
/* 451 */         for (Slot slot1 : this.field_147008_s) {
/* 452 */           func_146984_a(slot1, slot1.field_75222_d, Container.func_94534_d(1, this.field_146987_F), 5);
/*     */         }
/*     */         
/* 455 */         func_146984_a((Slot)null, -999, Container.func_94534_d(2, this.field_146987_F), 5);
/*     */       }
/* 457 */       else if (this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() != null) {
/* 458 */         if (p_146286_3_ == this.field_146297_k.field_71474_y.field_74322_I.func_151463_i() + 100) {
/* 459 */           func_146984_a(slot, k, p_146286_3_, 3);
/*     */         } else {
/* 461 */           boolean bool1 = (k != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54))) ? true : false;
/* 462 */           if (bool1) this.field_146994_N = (slot != null && slot.func_75216_d()) ? slot.func_75211_c() : null; 
/* 463 */           func_146984_a(slot, k, p_146286_3_, bool1 ? 1 : 0);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 468 */     if (this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() == null) {
/* 469 */       this.field_146997_J = 0L;
/*     */     }
/*     */     
/* 472 */     this.field_147007_t = false;
/*     */   }
/*     */   
/*     */   private boolean func_146981_a(Slot p_146981_1_, int p_146981_2_, int p_146981_3_) {
/* 476 */     return func_146978_c(p_146981_1_.field_75223_e, p_146981_1_.field_75221_f, 16, 16, p_146981_2_, p_146981_3_);
/*     */   }
/*     */   
/*     */   protected boolean func_146978_c(int p_146978_1_, int p_146978_2_, int p_146978_3_, int p_146978_4_, int p_146978_5_, int p_146978_6_) {
/* 480 */     int i = this.field_147003_i;
/* 481 */     int j = this.field_147009_r;
/* 482 */     p_146978_5_ -= i;
/* 483 */     p_146978_6_ -= j;
/*     */     
/* 485 */     return (p_146978_5_ >= p_146978_1_ - 1 && p_146978_5_ < p_146978_1_ + p_146978_3_ + 1 && p_146978_6_ >= p_146978_2_ - 1 && p_146978_6_ < p_146978_2_ + p_146978_4_ + 1);
/*     */   }
/*     */   
/*     */   protected void func_146984_a(Slot p_146984_1_, int p_146984_2_, int p_146984_3_, int p_146984_4_) {
/* 489 */     if (p_146984_1_ != null) p_146984_2_ = p_146984_1_.field_75222_d; 
/* 490 */     this.field_146297_k.field_71442_b.func_78753_a(this.field_147002_h.field_75152_c, p_146984_2_, p_146984_3_, p_146984_4_, (EntityPlayer)this.field_146297_k.field_71439_g);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 495 */     if (p_73869_2_ == 1 || p_73869_2_ == this.field_146297_k.field_71474_y.field_151445_Q.func_151463_i()) {
/* 496 */       this.field_146297_k.field_71439_g.func_71053_j();
/*     */     }
/*     */     
/* 499 */     func_146983_a(p_73869_2_);
/*     */     
/* 501 */     if (this.field_147006_u != null && this.field_147006_u.func_75216_d()) {
/* 502 */       if (p_73869_2_ == this.field_146297_k.field_71474_y.field_74322_I.func_151463_i()) {
/* 503 */         func_146984_a(this.field_147006_u, this.field_147006_u.field_75222_d, 0, 3);
/* 504 */       } else if (p_73869_2_ == this.field_146297_k.field_71474_y.field_74316_C.func_151463_i()) {
/* 505 */         func_146984_a(this.field_147006_u, this.field_147006_u.field_75222_d, func_146271_m() ? 1 : 0, 4);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean func_146983_a(int p_146983_1_) {
/* 511 */     if (this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() == null && this.field_147006_u != null) {
/* 512 */       for (byte b = 0; b < 9; b++) {
/* 513 */         if (p_146983_1_ == this.field_146297_k.field_71474_y.field_151456_ac[b].func_151463_i()) {
/* 514 */           func_146984_a(this.field_147006_u, this.field_147006_u.field_75222_d, b, 2);
/* 515 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 520 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 525 */     if (this.field_146297_k.field_71439_g == null)
/* 526 */       return;  this.field_147002_h.func_75134_a((EntityPlayer)this.field_146297_k.field_71439_g);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 531 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 536 */     super.func_73876_c();
/* 537 */     if (!this.field_146297_k.field_71439_g.func_70089_S() || this.field_146297_k.field_71439_g.field_70128_L) this.field_146297_k.field_71439_g.func_71053_j(); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */