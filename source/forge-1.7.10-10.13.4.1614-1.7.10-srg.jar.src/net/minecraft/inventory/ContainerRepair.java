/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class ContainerRepair
/*     */   extends Container
/*     */ {
/*  22 */   private static final Logger field_148326_f = LogManager.getLogger();
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
/*  35 */   private IInventory field_82852_f = new InventoryCraftResult();
/*  36 */   private IInventory field_82853_g = new InventoryBasic(this, "Repair", true, 2)
/*     */     {
/*     */       public void func_70296_d() {
/*  39 */         super.func_70296_d();
/*  40 */         this.field_135010_a.func_75130_a(this);
/*     */       }
/*     */       private static final String __OBFID = "CL_00001733";
/*     */     };
/*     */   private World field_82860_h; private int field_82861_i; private int field_82858_j;
/*     */   private int field_82859_k;
/*     */   public int field_82854_e;
/*     */   public int field_82856_l;
/*     */   private String field_82857_m;
/*     */   private final EntityPlayer field_82855_n;
/*     */   private static final String __OBFID = "CL_00001732";
/*     */   
/*     */   public ContainerRepair(InventoryPlayer p_i1800_1_, World p_i1800_2_, int p_i1800_3_, int p_i1800_4_, int p_i1800_5_, EntityPlayer p_i1800_6_) {
/*  53 */     this.field_82860_h = p_i1800_2_;
/*  54 */     this.field_82861_i = p_i1800_3_;
/*  55 */     this.field_82858_j = p_i1800_4_;
/*  56 */     this.field_82859_k = p_i1800_5_;
/*  57 */     this.field_82855_n = p_i1800_6_;
/*     */     
/*  59 */     func_75146_a(new Slot(this.field_82853_g, 0, 27, 47));
/*  60 */     func_75146_a(new Slot(this.field_82853_g, 1, 76, 47));
/*  61 */     func_75146_a(new Slot(this, this.field_82852_f, 2, 134, 47, p_i1800_2_, p_i1800_3_, p_i1800_4_, p_i1800_5_) { private static final String __OBFID = "CL_00001734";
/*     */           
/*     */           public boolean func_75214_a(ItemStack p_75214_1_) {
/*  64 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean func_82869_a(EntityPlayer p_82869_1_) {
/*  69 */             return ((p_82869_1_.field_71075_bZ.field_75098_d || p_82869_1_.field_71068_ca >= this.field_135068_e.field_82854_e) && this.field_135068_e.field_82854_e > 0 && func_75216_d());
/*     */           }
/*     */ 
/*     */           
/*     */           public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
/*  74 */             if (!p_82870_1_.field_71075_bZ.field_75098_d) p_82870_1_.func_82242_a(-this.field_135068_e.field_82854_e); 
/*  75 */             this.field_135068_e.field_82853_g.func_70299_a(0, null);
/*  76 */             if (this.field_135068_e.field_82856_l > 0) {
/*  77 */               ItemStack itemStack = this.field_135068_e.field_82853_g.func_70301_a(1);
/*  78 */               if (itemStack != null && itemStack.field_77994_a > this.field_135068_e.field_82856_l) {
/*  79 */                 itemStack.field_77994_a -= this.field_135068_e.field_82856_l;
/*  80 */                 this.field_135068_e.field_82853_g.func_70299_a(1, itemStack);
/*     */               } else {
/*  82 */                 this.field_135068_e.field_82853_g.func_70299_a(1, null);
/*     */               } 
/*     */             } else {
/*  85 */               this.field_135068_e.field_82853_g.func_70299_a(1, null);
/*     */             } 
/*  87 */             this.field_135068_e.field_82854_e = 0;
/*     */             
/*  89 */             if (!p_82870_1_.field_71075_bZ.field_75098_d && !this.field_135071_a.field_72995_K && this.field_135071_a.func_147439_a(this.field_135069_b, this.field_135070_c, this.field_135067_d) == Blocks.field_150467_bQ && p_82870_1_.func_70681_au().nextFloat() < 0.12F) {
/*  90 */               int i = this.field_135071_a.func_72805_g(this.field_135069_b, this.field_135070_c, this.field_135067_d);
/*  91 */               int j = i & 0x3;
/*  92 */               int k = i >> 2;
/*     */               
/*  94 */               if (++k > 2) {
/*  95 */                 this.field_135071_a.func_147468_f(this.field_135069_b, this.field_135070_c, this.field_135067_d);
/*  96 */                 this.field_135071_a.func_72926_e(1020, this.field_135069_b, this.field_135070_c, this.field_135067_d, 0);
/*     */               } else {
/*  98 */                 this.field_135071_a.func_72921_c(this.field_135069_b, this.field_135070_c, this.field_135067_d, j | k << 2, 2);
/*  99 */                 this.field_135071_a.func_72926_e(1021, this.field_135069_b, this.field_135070_c, this.field_135067_d, 0);
/*     */               } 
/* 101 */             } else if (!this.field_135071_a.field_72995_K) {
/* 102 */               this.field_135071_a.func_72926_e(1021, this.field_135069_b, this.field_135070_c, this.field_135067_d, 0);
/*     */             } 
/*     */           } }
/*     */       );
/*     */     byte b;
/* 107 */     for (b = 0; b < 3; b++) {
/* 108 */       for (byte b1 = 0; b1 < 9; b1++) {
/* 109 */         func_75146_a(new Slot((IInventory)p_i1800_1_, b1 + b * 9 + 9, 8 + b1 * 18, 84 + b * 18));
/*     */       }
/*     */     } 
/* 112 */     for (b = 0; b < 9; b++) {
/* 113 */       func_75146_a(new Slot((IInventory)p_i1800_1_, b, 8 + b * 18, 142));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75130_a(IInventory p_75130_1_) {
/* 119 */     super.func_75130_a(p_75130_1_);
/*     */     
/* 121 */     if (p_75130_1_ == this.field_82853_g) func_82848_d(); 
/*     */   }
/*     */   
/*     */   public void func_82848_d() {
/* 125 */     ItemStack itemStack1 = this.field_82853_g.func_70301_a(0);
/* 126 */     this.field_82854_e = 0;
/* 127 */     int i = 0;
/* 128 */     int j = 0;
/* 129 */     byte b1 = 0;
/*     */ 
/*     */ 
/*     */     
/* 133 */     if (itemStack1 == null) {
/* 134 */       this.field_82852_f.func_70299_a(0, null);
/* 135 */       this.field_82854_e = 0;
/*     */       return;
/*     */     } 
/* 138 */     ItemStack itemStack2 = itemStack1.func_77946_l();
/* 139 */     ItemStack itemStack3 = this.field_82853_g.func_70301_a(1);
/* 140 */     Map<Integer, Integer> map = EnchantmentHelper.func_82781_a(itemStack2);
/* 141 */     boolean bool = false;
/*     */     
/* 143 */     j += itemStack1.func_82838_A() + ((itemStack3 == null) ? 0 : itemStack3.func_82838_A());
/*     */ 
/*     */ 
/*     */     
/* 147 */     this.field_82856_l = 0;
/*     */     
/* 149 */     if (itemStack3 != null) {
/* 150 */       bool = (itemStack3.func_77973_b() == Items.field_151134_bR && Items.field_151134_bR.func_92110_g(itemStack3).func_74745_c() > 0) ? true : false;
/*     */       
/* 152 */       if (itemStack2.func_77984_f() && itemStack2.func_77973_b().func_82789_a(itemStack1, itemStack3)) {
/* 153 */         int k = Math.min(itemStack2.func_77952_i(), itemStack2.func_77958_k() / 4);
/* 154 */         if (k <= 0) {
/* 155 */           this.field_82852_f.func_70299_a(0, null);
/* 156 */           this.field_82854_e = 0;
/*     */           return;
/*     */         } 
/* 159 */         byte b = 0;
/* 160 */         while (k > 0 && b < itemStack3.field_77994_a) {
/* 161 */           int m = itemStack2.func_77952_i() - k;
/* 162 */           itemStack2.func_77964_b(m);
/* 163 */           i += Math.max(1, k / 100) + map.size();
/*     */           
/* 165 */           k = Math.min(itemStack2.func_77952_i(), itemStack2.func_77958_k() / 4);
/* 166 */           b++;
/*     */         } 
/* 168 */         this.field_82856_l = b;
/*     */       } else {
/* 170 */         if (!bool && (itemStack2.func_77973_b() != itemStack3.func_77973_b() || !itemStack2.func_77984_f())) {
/* 171 */           this.field_82852_f.func_70299_a(0, null);
/* 172 */           this.field_82854_e = 0;
/*     */           return;
/*     */         } 
/* 175 */         if (itemStack2.func_77984_f() && !bool) {
/* 176 */           int k = itemStack1.func_77958_k() - itemStack1.func_77952_i();
/* 177 */           int m = itemStack3.func_77958_k() - itemStack3.func_77952_i();
/* 178 */           int n = m + itemStack2.func_77958_k() * 12 / 100;
/* 179 */           int i1 = k + n;
/* 180 */           int i2 = itemStack2.func_77958_k() - i1;
/* 181 */           if (i2 < 0) i2 = 0;
/*     */           
/* 183 */           if (i2 < itemStack2.func_77960_j()) {
/* 184 */             itemStack2.func_77964_b(i2);
/* 185 */             i += Math.max(1, n / 100);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 191 */         Map map1 = EnchantmentHelper.func_82781_a(itemStack3);
/*     */         
/* 193 */         for (Iterator<Integer> iterator1 = map1.keySet().iterator(); iterator1.hasNext(); ) { int k = ((Integer)iterator1.next()).intValue();
/* 194 */           Enchantment enchantment = Enchantment.field_77331_b[k];
/* 195 */           int m = map.containsKey(Integer.valueOf(k)) ? ((Integer)map.get(Integer.valueOf(k))).intValue() : 0;
/* 196 */           int n = ((Integer)map1.get(Integer.valueOf(k))).intValue();
/* 197 */           n = (m == n) ? ++n : Math.max(n, m);
/* 198 */           int i1 = n - m;
/* 199 */           boolean bool1 = enchantment.func_92089_a(itemStack1);
/*     */           
/* 201 */           if (this.field_82855_n.field_71075_bZ.field_75098_d || itemStack1.func_77973_b() == Items.field_151134_bR) bool1 = true;
/*     */           
/* 203 */           for (Iterator<Integer> iterator2 = map.keySet().iterator(); iterator2.hasNext(); ) { int i3 = ((Integer)iterator2.next()).intValue();
/* 204 */             if (i3 != k && !enchantment.func_77326_a(Enchantment.field_77331_b[i3])) {
/* 205 */               bool1 = false;
/*     */               
/* 207 */               i += i1;
/*     */             }  }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 213 */           if (!bool1)
/* 214 */             continue;  if (n > enchantment.func_77325_b()) n = enchantment.func_77325_b(); 
/* 215 */           map.put(Integer.valueOf(k), Integer.valueOf(n));
/* 216 */           int i2 = 0;
/*     */           
/* 218 */           switch (enchantment.func_77324_c()) {
/*     */             case 10:
/* 220 */               i2 = 1;
/*     */               break;
/*     */             case 5:
/* 223 */               i2 = 2;
/*     */               break;
/*     */             case 2:
/* 226 */               i2 = 4;
/*     */               break;
/*     */             case 1:
/* 229 */               i2 = 8;
/*     */               break;
/*     */           } 
/*     */           
/* 233 */           if (bool) i2 = Math.max(1, i2 / 2);
/*     */           
/* 235 */           i += i2 * i1; }
/*     */       
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 242 */     if (StringUtils.isBlank(this.field_82857_m)) {
/* 243 */       if (itemStack1.func_82837_s()) {
/* 244 */         b1 = itemStack1.func_77984_f() ? 7 : (itemStack1.field_77994_a * 5);
/*     */         
/* 246 */         i += b1;
/*     */ 
/*     */ 
/*     */         
/* 250 */         itemStack2.func_135074_t();
/*     */       } 
/* 252 */     } else if (!this.field_82857_m.equals(itemStack1.func_82833_r())) {
/* 253 */       b1 = itemStack1.func_77984_f() ? 7 : (itemStack1.field_77994_a * 5);
/*     */       
/* 255 */       i += b1;
/*     */ 
/*     */       
/* 258 */       if (itemStack1.func_82837_s()) {
/* 259 */         j += b1 / 2;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 265 */       itemStack2.func_151001_c(this.field_82857_m);
/*     */     } 
/*     */     
/* 268 */     byte b2 = 0;
/* 269 */     for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext(); ) { int k = ((Integer)iterator.next()).intValue();
/* 270 */       Enchantment enchantment = Enchantment.field_77331_b[k];
/* 271 */       int m = ((Integer)map.get(Integer.valueOf(k))).intValue();
/* 272 */       int n = 0;
/*     */       
/* 274 */       b2++;
/*     */       
/* 276 */       switch (enchantment.func_77324_c()) {
/*     */         case 10:
/* 278 */           n = 1;
/*     */           break;
/*     */         case 5:
/* 281 */           n = 2;
/*     */           break;
/*     */         case 2:
/* 284 */           n = 4;
/*     */           break;
/*     */         case 1:
/* 287 */           n = 8;
/*     */           break;
/*     */       } 
/*     */       
/* 291 */       if (bool) n = Math.max(1, n / 2);
/*     */       
/* 293 */       j += b2 + m * n; }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 298 */     if (bool) j = Math.max(1, j / 2);
/*     */     
/* 300 */     this.field_82854_e = j + i;
/* 301 */     if (i <= 0)
/*     */     {
/* 303 */       itemStack2 = null;
/*     */     }
/* 305 */     if (b1 == i && b1 > 0 && this.field_82854_e >= 40)
/*     */     {
/*     */       
/* 308 */       this.field_82854_e = 39;
/*     */     }
/* 310 */     if (this.field_82854_e >= 40 && !this.field_82855_n.field_71075_bZ.field_75098_d)
/*     */     {
/* 312 */       itemStack2 = null;
/*     */     }
/*     */     
/* 315 */     if (itemStack2 != null) {
/* 316 */       int k = itemStack2.func_82838_A();
/* 317 */       if (itemStack3 != null && k < itemStack3.func_82838_A()) k = itemStack3.func_82838_A(); 
/* 318 */       if (itemStack2.func_82837_s()) k -= 9; 
/* 319 */       if (k < 0) k = 0; 
/* 320 */       k += 2;
/*     */       
/* 322 */       itemStack2.func_82841_c(k);
/* 323 */       EnchantmentHelper.func_82782_a(map, itemStack2);
/*     */     } 
/*     */     
/* 326 */     this.field_82852_f.func_70299_a(0, itemStack2);
/*     */ 
/*     */     
/* 329 */     func_75142_b();
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
/*     */   public void func_75132_a(ICrafting p_75132_1_) {
/* 347 */     super.func_75132_a(p_75132_1_);
/* 348 */     p_75132_1_.func_71112_a(this, 0, this.field_82854_e);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
/* 353 */     if (p_75137_1_ == 0) this.field_82854_e = p_75137_2_;
/*     */   
/*     */   }
/*     */   
/*     */   public void func_75134_a(EntityPlayer p_75134_1_) {
/* 358 */     super.func_75134_a(p_75134_1_);
/* 359 */     if (this.field_82860_h.field_72995_K)
/*     */       return; 
/* 361 */     for (byte b = 0; b < this.field_82853_g.func_70302_i_(); b++) {
/* 362 */       ItemStack itemStack = this.field_82853_g.func_70304_b(b);
/* 363 */       if (itemStack != null) {
/* 364 */         p_75134_1_.func_71019_a(itemStack, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/* 371 */     if (this.field_82860_h.func_147439_a(this.field_82861_i, this.field_82858_j, this.field_82859_k) != Blocks.field_150467_bQ) return false; 
/* 372 */     if (p_75145_1_.func_70092_e(this.field_82861_i + 0.5D, this.field_82858_j + 0.5D, this.field_82859_k + 0.5D) > 64.0D) return false; 
/* 373 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 378 */     ItemStack itemStack = null;
/* 379 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/* 380 */     if (slot != null && slot.func_75216_d()) {
/* 381 */       ItemStack itemStack1 = slot.func_75211_c();
/* 382 */       itemStack = itemStack1.func_77946_l();
/*     */       
/* 384 */       if (p_82846_2_ == 2) {
/* 385 */         if (!func_75135_a(itemStack1, 3, 39, true)) {
/* 386 */           return null;
/*     */         }
/* 388 */         slot.func_75220_a(itemStack1, itemStack);
/* 389 */       } else if (p_82846_2_ == 0 || p_82846_2_ == 1) {
/* 390 */         if (!func_75135_a(itemStack1, 3, 39, false)) {
/* 391 */           return null;
/*     */         }
/* 393 */       } else if (p_82846_2_ >= 3 && p_82846_2_ < 39 && 
/* 394 */         !func_75135_a(itemStack1, 0, 2, false)) {
/* 395 */         return null;
/*     */       } 
/*     */       
/* 398 */       if (itemStack1.field_77994_a == 0) {
/* 399 */         slot.func_75215_d(null);
/*     */       } else {
/* 401 */         slot.func_75218_e();
/*     */       } 
/* 403 */       if (itemStack1.field_77994_a == itemStack.field_77994_a) {
/* 404 */         return null;
/*     */       }
/* 406 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*     */     } 
/*     */     
/* 409 */     return itemStack;
/*     */   }
/*     */   
/*     */   public void func_82850_a(String p_82850_1_) {
/* 413 */     this.field_82857_m = p_82850_1_;
/*     */     
/* 415 */     if (func_75139_a(2).func_75216_d()) {
/* 416 */       ItemStack itemStack = func_75139_a(2).func_75211_c();
/*     */       
/* 418 */       if (StringUtils.isBlank(p_82850_1_)) {
/* 419 */         itemStack.func_135074_t();
/*     */       } else {
/* 421 */         itemStack.func_151001_c(this.field_82857_m);
/*     */       } 
/*     */     } 
/*     */     
/* 425 */     func_82848_d();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerRepair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */