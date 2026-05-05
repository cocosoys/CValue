/*     */ package net.minecraft.entity.player;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class InventoryPlayer implements IInventory {
/*  17 */   public ItemStack[] field_70462_a = new ItemStack[36];
/*  18 */   public ItemStack[] field_70460_b = new ItemStack[4]; public int field_70461_c;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ItemStack field_70456_f;
/*     */   public EntityPlayer field_70458_d;
/*     */   private ItemStack field_70457_g;
/*     */   public boolean field_70459_e;
/*     */   private static final String __OBFID = "CL_00001709";
/*     */   
/*     */   public InventoryPlayer(EntityPlayer p_i1750_1_) {
/*  27 */     this.field_70458_d = p_i1750_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70448_g() {
/*  32 */     if (this.field_70461_c < 9 && this.field_70461_c >= 0) {
/*  33 */       return this.field_70462_a[this.field_70461_c];
/*     */     }
/*  35 */     return null;
/*     */   }
/*     */   
/*     */   public static int func_70451_h() {
/*  39 */     return 9;
/*     */   }
/*     */   
/*     */   private int func_146029_c(Item p_146029_1_) {
/*  43 */     for (byte b = 0; b < this.field_70462_a.length; b++) {
/*  44 */       if (this.field_70462_a[b] != null && this.field_70462_a[b].func_77973_b() == p_146029_1_) return b; 
/*     */     } 
/*  46 */     return -1;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   private int func_146024_c(Item p_146024_1_, int p_146024_2_) {
/*  50 */     for (byte b = 0; b < this.field_70462_a.length; b++) {
/*  51 */       if (this.field_70462_a[b] != null && this.field_70462_a[b].func_77973_b() == p_146024_1_ && this.field_70462_a[b].func_77960_j() == p_146024_2_) return b; 
/*     */     } 
/*  53 */     return -1;
/*     */   }
/*     */   
/*     */   private int func_70432_d(ItemStack p_70432_1_) {
/*  57 */     for (byte b = 0; b < this.field_70462_a.length; b++) {
/*  58 */       if (this.field_70462_a[b] != null && this.field_70462_a[b].func_77973_b() == p_70432_1_.func_77973_b() && this.field_70462_a[b].func_77985_e() && (this.field_70462_a[b]).field_77994_a < this.field_70462_a[b].func_77976_d() && (this.field_70462_a[b]).field_77994_a < func_70297_j_() && (!this.field_70462_a[b].func_77981_g() || this.field_70462_a[b].func_77960_j() == p_70432_1_.func_77960_j()) && ItemStack.func_77970_a(this.field_70462_a[b], p_70432_1_))
/*     */       {
/*  60 */         return b;
/*     */       }
/*     */     } 
/*  63 */     return -1;
/*     */   }
/*     */   
/*     */   public int func_70447_i() {
/*  67 */     for (byte b = 0; b < this.field_70462_a.length; b++) {
/*  68 */       if (this.field_70462_a[b] == null) return b; 
/*     */     } 
/*  70 */     return -1;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_146030_a(Item p_146030_1_, int p_146030_2_, boolean p_146030_3_, boolean p_146030_4_) {
/*  74 */     int i = -1;
/*  75 */     this.field_70456_f = func_70448_g();
/*  76 */     if (p_146030_3_) {
/*  77 */       i = func_146024_c(p_146030_1_, p_146030_2_);
/*     */     } else {
/*  79 */       i = func_146029_c(p_146030_1_);
/*     */     } 
/*  81 */     if (i >= 0 && i < 9) {
/*  82 */       this.field_70461_c = i;
/*     */       
/*     */       return;
/*     */     } 
/*  86 */     if (p_146030_4_ && 
/*  87 */       p_146030_1_ != null) {
/*  88 */       int j = func_70447_i();
/*  89 */       if (j >= 0 && j < 9) {
/*  90 */         this.field_70461_c = j;
/*     */       }
/*     */       
/*  93 */       func_70439_a(p_146030_1_, p_146030_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70453_c(int p_70453_1_) {
/*  99 */     if (p_70453_1_ > 0) p_70453_1_ = 1; 
/* 100 */     if (p_70453_1_ < 0) p_70453_1_ = -1;
/*     */     
/* 102 */     this.field_70461_c -= p_70453_1_;
/*     */     
/* 104 */     while (this.field_70461_c < 0)
/* 105 */       this.field_70461_c += 9; 
/* 106 */     while (this.field_70461_c >= 9)
/* 107 */       this.field_70461_c -= 9; 
/*     */   }
/*     */   
/*     */   public int func_146027_a(Item p_146027_1_, int p_146027_2_) {
/* 111 */     int i = 0; byte b;
/* 112 */     for (b = 0; b < this.field_70462_a.length; b++) {
/* 113 */       ItemStack itemStack = this.field_70462_a[b];
/* 114 */       if (itemStack != null && (
/* 115 */         p_146027_1_ == null || itemStack.func_77973_b() == p_146027_1_) && (
/* 116 */         p_146027_2_ <= -1 || itemStack.func_77960_j() == p_146027_2_)) {
/*     */         
/* 118 */         i += itemStack.field_77994_a;
/* 119 */         this.field_70462_a[b] = null;
/*     */       } 
/* 121 */     }  for (b = 0; b < this.field_70460_b.length; b++) {
/* 122 */       ItemStack itemStack = this.field_70460_b[b];
/* 123 */       if (itemStack != null && (
/* 124 */         p_146027_1_ == null || itemStack.func_77973_b() == p_146027_1_) && (
/* 125 */         p_146027_2_ <= -1 || itemStack.func_77960_j() == p_146027_2_)) {
/*     */         
/* 127 */         i += itemStack.field_77994_a;
/* 128 */         this.field_70460_b[b] = null;
/*     */       } 
/*     */     } 
/* 131 */     if (this.field_70457_g != null) {
/* 132 */       if (p_146027_1_ != null && this.field_70457_g.func_77973_b() != p_146027_1_) return i; 
/* 133 */       if (p_146027_2_ > -1 && this.field_70457_g.func_77960_j() != p_146027_2_) return i;
/*     */       
/* 135 */       i += this.field_70457_g.field_77994_a;
/* 136 */       func_70437_b(null);
/*     */     } 
/*     */     
/* 139 */     return i;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70439_a(Item p_70439_1_, int p_70439_2_) {
/* 143 */     if (p_70439_1_ != null) {
/*     */       
/* 145 */       if (this.field_70456_f != null && this.field_70456_f.func_77956_u() && func_146024_c(this.field_70456_f.func_77973_b(), this.field_70456_f.func_77952_i()) == this.field_70461_c) {
/*     */         return;
/*     */       }
/*     */       
/* 149 */       int i = func_146024_c(p_70439_1_, p_70439_2_);
/* 150 */       if (i >= 0) {
/* 151 */         int j = (this.field_70462_a[i]).field_77994_a;
/* 152 */         this.field_70462_a[i] = this.field_70462_a[this.field_70461_c];
/* 153 */         this.field_70462_a[this.field_70461_c] = new ItemStack(p_70439_1_, j, p_70439_2_);
/*     */       } else {
/* 155 */         this.field_70462_a[this.field_70461_c] = new ItemStack(p_70439_1_, 1, p_70439_2_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private int func_70452_e(ItemStack p_70452_1_) {
/* 161 */     Item item = p_70452_1_.func_77973_b();
/* 162 */     int i = p_70452_1_.field_77994_a;
/*     */     
/* 164 */     if (p_70452_1_.func_77976_d() == 1) {
/* 165 */       int m = func_70447_i();
/* 166 */       if (m < 0) return i; 
/* 167 */       if (this.field_70462_a[m] == null) {
/* 168 */         this.field_70462_a[m] = ItemStack.func_77944_b(p_70452_1_);
/*     */       }
/* 170 */       return 0;
/*     */     } 
/*     */     
/* 173 */     int j = func_70432_d(p_70452_1_);
/* 174 */     if (j < 0) j = func_70447_i(); 
/* 175 */     if (j < 0) return i; 
/* 176 */     if (this.field_70462_a[j] == null) {
/* 177 */       this.field_70462_a[j] = new ItemStack(item, 0, p_70452_1_.func_77960_j());
/* 178 */       if (p_70452_1_.func_77942_o()) {
/* 179 */         this.field_70462_a[j].func_77982_d((NBTTagCompound)p_70452_1_.func_77978_p().func_74737_b());
/*     */       }
/*     */     } 
/*     */     
/* 183 */     int k = i;
/* 184 */     if (k > this.field_70462_a[j].func_77976_d() - (this.field_70462_a[j]).field_77994_a) {
/* 185 */       k = this.field_70462_a[j].func_77976_d() - (this.field_70462_a[j]).field_77994_a;
/*     */     }
/* 187 */     if (k > func_70297_j_() - (this.field_70462_a[j]).field_77994_a) {
/* 188 */       k = func_70297_j_() - (this.field_70462_a[j]).field_77994_a;
/*     */     }
/*     */     
/* 191 */     if (k == 0) return i;
/*     */     
/* 193 */     i -= k;
/* 194 */     (this.field_70462_a[j]).field_77994_a += k;
/* 195 */     (this.field_70462_a[j]).field_77992_b = 5;
/*     */     
/* 197 */     return i;
/*     */   }
/*     */   
/*     */   public void func_70429_k() {
/* 201 */     for (byte b = 0; b < this.field_70462_a.length; b++) {
/* 202 */       if (this.field_70462_a[b] != null) {
/* 203 */         this.field_70462_a[b].func_77945_a(this.field_70458_d.field_70170_p, (Entity)this.field_70458_d, b, (this.field_70461_c == b));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_146026_a(Item p_146026_1_) {
/* 209 */     int i = func_146029_c(p_146026_1_);
/* 210 */     if (i < 0) return false; 
/* 211 */     if (--(this.field_70462_a[i]).field_77994_a <= 0) this.field_70462_a[i] = null;
/*     */     
/* 213 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_146028_b(Item p_146028_1_) {
/* 217 */     int i = func_146029_c(p_146028_1_);
/* 218 */     if (i < 0) return false;
/*     */     
/* 220 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70441_a(ItemStack p_70441_1_) {
/* 230 */     if (p_70441_1_ == null || p_70441_1_.field_77994_a == 0 || p_70441_1_.func_77973_b() == null) return false;
/*     */     
/*     */     try {
/* 233 */       if (!p_70441_1_.func_77951_h()) {
/*     */         int j;
/*     */         do {
/* 236 */           j = p_70441_1_.field_77994_a;
/* 237 */           p_70441_1_.field_77994_a = func_70452_e(p_70441_1_);
/* 238 */         } while (p_70441_1_.field_77994_a > 0 && p_70441_1_.field_77994_a < j);
/* 239 */         if (p_70441_1_.field_77994_a == j && this.field_70458_d.field_71075_bZ.field_75098_d) {
/*     */           
/* 241 */           p_70441_1_.field_77994_a = 0;
/* 242 */           return true;
/*     */         } 
/* 244 */         return (p_70441_1_.field_77994_a < j);
/*     */       } 
/*     */       
/* 247 */       int i = func_70447_i();
/* 248 */       if (i >= 0) {
/* 249 */         this.field_70462_a[i] = ItemStack.func_77944_b(p_70441_1_);
/* 250 */         (this.field_70462_a[i]).field_77992_b = 5;
/* 251 */         p_70441_1_.field_77994_a = 0;
/* 252 */         return true;
/* 253 */       }  if (this.field_70458_d.field_71075_bZ.field_75098_d) {
/*     */         
/* 255 */         p_70441_1_.field_77994_a = 0;
/* 256 */         return true;
/*     */       } 
/* 258 */       return false;
/* 259 */     } catch (Throwable throwable) {
/* 260 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Adding item to inventory");
/* 261 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Item being added");
/*     */       
/* 263 */       crashReportCategory.func_71507_a("Item ID", Integer.valueOf(Item.func_150891_b(p_70441_1_.func_77973_b())));
/* 264 */       crashReportCategory.func_71507_a("Item data", Integer.valueOf(p_70441_1_.func_77960_j()));
/* 265 */       crashReportCategory.func_71500_a("Item name", new Callable(this, p_70441_1_) { private static final String __OBFID = "CL_00001710";
/*     */             
/*     */             public String call() {
/* 268 */               return this.field_96634_a.func_82833_r();
/*     */             } }
/*     */         );
/*     */       
/* 272 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/* 278 */     ItemStack[] arrayOfItemStack = this.field_70462_a;
/* 279 */     if (p_70298_1_ >= this.field_70462_a.length) {
/* 280 */       arrayOfItemStack = this.field_70460_b;
/* 281 */       p_70298_1_ -= this.field_70462_a.length;
/*     */     } 
/*     */     
/* 284 */     if (arrayOfItemStack[p_70298_1_] != null) {
/* 285 */       if ((arrayOfItemStack[p_70298_1_]).field_77994_a <= p_70298_2_) {
/* 286 */         ItemStack itemStack1 = arrayOfItemStack[p_70298_1_];
/* 287 */         arrayOfItemStack[p_70298_1_] = null;
/* 288 */         return itemStack1;
/*     */       } 
/* 290 */       ItemStack itemStack = arrayOfItemStack[p_70298_1_].func_77979_a(p_70298_2_);
/* 291 */       if ((arrayOfItemStack[p_70298_1_]).field_77994_a == 0) arrayOfItemStack[p_70298_1_] = null; 
/* 292 */       return itemStack;
/*     */     } 
/*     */     
/* 295 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/* 300 */     ItemStack[] arrayOfItemStack = this.field_70462_a;
/* 301 */     if (p_70304_1_ >= this.field_70462_a.length) {
/* 302 */       arrayOfItemStack = this.field_70460_b;
/* 303 */       p_70304_1_ -= this.field_70462_a.length;
/*     */     } 
/*     */     
/* 306 */     if (arrayOfItemStack[p_70304_1_] != null) {
/* 307 */       ItemStack itemStack = arrayOfItemStack[p_70304_1_];
/* 308 */       arrayOfItemStack[p_70304_1_] = null;
/* 309 */       return itemStack;
/*     */     } 
/* 311 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/* 316 */     ItemStack[] arrayOfItemStack = this.field_70462_a;
/* 317 */     if (p_70299_1_ >= arrayOfItemStack.length) {
/* 318 */       p_70299_1_ -= arrayOfItemStack.length;
/* 319 */       arrayOfItemStack = this.field_70460_b;
/*     */     } 
/*     */     
/* 322 */     arrayOfItemStack[p_70299_1_] = p_70299_2_;
/*     */   }
/*     */   
/*     */   public float func_146023_a(Block p_146023_1_) {
/* 326 */     float f = 1.0F;
/* 327 */     if (this.field_70462_a[this.field_70461_c] != null) f *= this.field_70462_a[this.field_70461_c].func_150997_a(p_146023_1_); 
/* 328 */     return f;
/*     */   }
/*     */   public NBTTagList func_70442_a(NBTTagList p_70442_1_) {
/*     */     byte b;
/* 332 */     for (b = 0; b < this.field_70462_a.length; b++) {
/* 333 */       if (this.field_70462_a[b] != null) {
/* 334 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 335 */         nBTTagCompound.func_74774_a("Slot", (byte)b);
/* 336 */         this.field_70462_a[b].func_77955_b(nBTTagCompound);
/* 337 */         p_70442_1_.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/*     */     } 
/* 340 */     for (b = 0; b < this.field_70460_b.length; b++) {
/* 341 */       if (this.field_70460_b[b] != null) {
/* 342 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 343 */         nBTTagCompound.func_74774_a("Slot", (byte)(b + 100));
/* 344 */         this.field_70460_b[b].func_77955_b(nBTTagCompound);
/* 345 */         p_70442_1_.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/*     */     } 
/* 348 */     return p_70442_1_;
/*     */   }
/*     */   
/*     */   public void func_70443_b(NBTTagList p_70443_1_) {
/* 352 */     this.field_70462_a = new ItemStack[36];
/* 353 */     this.field_70460_b = new ItemStack[4];
/* 354 */     for (byte b = 0; b < p_70443_1_.func_74745_c(); b++) {
/* 355 */       NBTTagCompound nBTTagCompound = p_70443_1_.func_150305_b(b);
/* 356 */       int i = nBTTagCompound.func_74771_c("Slot") & 0xFF;
/* 357 */       ItemStack itemStack = ItemStack.func_77949_a(nBTTagCompound);
/* 358 */       if (itemStack != null) {
/* 359 */         if (i >= 0 && i < this.field_70462_a.length) this.field_70462_a[i] = itemStack; 
/* 360 */         if (i >= 100 && i < this.field_70460_b.length + 100) this.field_70460_b[i - 100] = itemStack;
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_70302_i_() {
/* 367 */     return this.field_70462_a.length + 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/* 372 */     ItemStack[] arrayOfItemStack = this.field_70462_a;
/* 373 */     if (p_70301_1_ >= arrayOfItemStack.length) {
/* 374 */       p_70301_1_ -= arrayOfItemStack.length;
/* 375 */       arrayOfItemStack = this.field_70460_b;
/*     */     } 
/*     */     
/* 378 */     return arrayOfItemStack[p_70301_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 383 */     return "container.inventory";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 388 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 393 */     return 64;
/*     */   }
/*     */   
/*     */   public boolean func_146025_b(Block p_146025_1_) {
/* 397 */     if (p_146025_1_.func_149688_o().func_76229_l()) return true;
/*     */     
/* 399 */     ItemStack itemStack = func_70301_a(this.field_70461_c);
/* 400 */     if (itemStack != null) return itemStack.func_150998_b(p_146025_1_); 
/* 401 */     return false;
/*     */   }
/*     */   
/*     */   public ItemStack func_70440_f(int p_70440_1_) {
/* 405 */     return this.field_70460_b[p_70440_1_];
/*     */   }
/*     */   
/*     */   public int func_70430_l() {
/* 409 */     int i = 0;
/* 410 */     for (byte b = 0; b < this.field_70460_b.length; b++) {
/* 411 */       if (this.field_70460_b[b] != null && this.field_70460_b[b].func_77973_b() instanceof ItemArmor) {
/* 412 */         int j = ((ItemArmor)this.field_70460_b[b].func_77973_b()).field_77879_b;
/* 413 */         i += j;
/*     */       } 
/*     */     } 
/* 416 */     return i;
/*     */   }
/*     */   
/*     */   public void func_70449_g(float p_70449_1_) {
/* 420 */     p_70449_1_ /= 4.0F;
/* 421 */     if (p_70449_1_ < 1.0F) {
/* 422 */       p_70449_1_ = 1.0F;
/*     */     }
/* 424 */     for (byte b = 0; b < this.field_70460_b.length; b++) {
/* 425 */       if (this.field_70460_b[b] != null && this.field_70460_b[b].func_77973_b() instanceof ItemArmor) {
/* 426 */         this.field_70460_b[b].func_77972_a((int)p_70449_1_, this.field_70458_d);
/* 427 */         if ((this.field_70460_b[b]).field_77994_a == 0)
/* 428 */           this.field_70460_b[b] = null; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_70436_m() {
/*     */     byte b;
/* 435 */     for (b = 0; b < this.field_70462_a.length; b++) {
/* 436 */       if (this.field_70462_a[b] != null) {
/* 437 */         this.field_70458_d.func_146097_a(this.field_70462_a[b], true, false);
/* 438 */         this.field_70462_a[b] = null;
/*     */       } 
/*     */     } 
/* 441 */     for (b = 0; b < this.field_70460_b.length; b++) {
/* 442 */       if (this.field_70460_b[b] != null) {
/* 443 */         this.field_70458_d.func_146097_a(this.field_70460_b[b], true, false);
/* 444 */         this.field_70460_b[b] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70296_d() {
/* 451 */     this.field_70459_e = true;
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
/*     */   public void func_70437_b(ItemStack p_70437_1_) {
/* 483 */     this.field_70457_g = p_70437_1_;
/*     */   }
/*     */   
/*     */   public ItemStack func_70445_o() {
/* 487 */     return this.field_70457_g;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 492 */     if (this.field_70458_d.field_70128_L) return false; 
/* 493 */     if (p_70300_1_.func_70068_e((Entity)this.field_70458_d) > 64.0D) return false; 
/* 494 */     return true;
/*     */   }
/*     */   public boolean func_70431_c(ItemStack p_70431_1_) {
/*     */     byte b;
/* 498 */     for (b = 0; b < this.field_70460_b.length; b++) {
/* 499 */       if (this.field_70460_b[b] != null && this.field_70460_b[b].func_77969_a(p_70431_1_)) return true; 
/*     */     } 
/* 501 */     for (b = 0; b < this.field_70462_a.length; b++) {
/* 502 */       if (this.field_70462_a[b] != null && this.field_70462_a[b].func_77969_a(p_70431_1_)) return true; 
/*     */     } 
/* 504 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
/* 517 */     return true;
/*     */   }
/*     */   public void func_70455_b(InventoryPlayer p_70455_1_) {
/*     */     byte b;
/* 521 */     for (b = 0; b < this.field_70462_a.length; b++) {
/* 522 */       this.field_70462_a[b] = ItemStack.func_77944_b(p_70455_1_.field_70462_a[b]);
/*     */     }
/* 524 */     for (b = 0; b < this.field_70460_b.length; b++) {
/* 525 */       this.field_70460_b[b] = ItemStack.func_77944_b(p_70455_1_.field_70460_b[b]);
/*     */     }
/* 527 */     this.field_70461_c = p_70455_1_.field_70461_c;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\player\InventoryPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */