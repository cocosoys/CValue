/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public abstract class Container
/*     */ {
/*  29 */   public List field_75153_a = new ArrayList();
/*  30 */   public List field_75151_b = new ArrayList();
/*     */   public int field_75152_c;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private short field_75150_e;
/*  34 */   private int field_94535_f = -1;
/*     */   private int field_94536_g;
/*  36 */   private final Set field_94537_h = new HashSet();
/*     */   
/*  38 */   protected List field_75149_d = new ArrayList();
/*     */   
/*     */   protected Slot func_75146_a(Slot p_75146_1_) {
/*  41 */     p_75146_1_.field_75222_d = this.field_75151_b.size();
/*  42 */     this.field_75151_b.add(p_75146_1_);
/*  43 */     this.field_75153_a.add(null);
/*  44 */     return p_75146_1_;
/*     */   }
/*     */   
/*     */   public void func_75132_a(ICrafting p_75132_1_) {
/*  48 */     if (this.field_75149_d.contains(p_75132_1_)) {
/*  49 */       throw new IllegalArgumentException("Listener already listening");
/*     */     }
/*  51 */     this.field_75149_d.add(p_75132_1_);
/*     */     
/*  53 */     p_75132_1_.func_71110_a(this, func_75138_a());
/*  54 */     func_75142_b();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_82847_b(ICrafting p_82847_1_) {
/*  58 */     this.field_75149_d.remove(p_82847_1_);
/*     */   }
/*     */   
/*     */   public List func_75138_a() {
/*  62 */     ArrayList<ItemStack> arrayList = new ArrayList();
/*  63 */     for (byte b = 0; b < this.field_75151_b.size(); b++) {
/*  64 */       arrayList.add(((Slot)this.field_75151_b.get(b)).func_75211_c());
/*     */     }
/*  66 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  76 */     for (byte b = 0; b < this.field_75151_b.size(); b++) {
/*  77 */       ItemStack itemStack1 = ((Slot)this.field_75151_b.get(b)).func_75211_c();
/*  78 */       ItemStack itemStack2 = this.field_75153_a.get(b);
/*  79 */       if (!ItemStack.func_77989_b(itemStack2, itemStack1)) {
/*  80 */         itemStack2 = (itemStack1 == null) ? null : itemStack1.func_77946_l();
/*  81 */         this.field_75153_a.set(b, itemStack2);
/*  82 */         for (byte b1 = 0; b1 < this.field_75149_d.size(); b1++) {
/*  83 */           ((ICrafting)this.field_75149_d.get(b1)).func_71111_a(this, b, itemStack2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_75140_a(EntityPlayer p_75140_1_, int p_75140_2_) {
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public Slot func_75147_a(IInventory p_75147_1_, int p_75147_2_) {
/*  94 */     for (byte b = 0; b < this.field_75151_b.size(); b++) {
/*  95 */       Slot slot = this.field_75151_b.get(b);
/*  96 */       if (slot.func_75217_a(p_75147_1_, p_75147_2_)) {
/*  97 */         return slot;
/*     */       }
/*     */     } 
/* 100 */     return null;
/*     */   }
/*     */   
/*     */   public Slot func_75139_a(int p_75139_1_) {
/* 104 */     return this.field_75151_b.get(p_75139_1_);
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 108 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/* 109 */     if (slot != null) {
/* 110 */       return slot.func_75211_c();
/*     */     }
/* 112 */     return null;
/*     */   }
/*     */   
/*     */   public ItemStack func_75144_a(int p_75144_1_, int p_75144_2_, int p_75144_3_, EntityPlayer p_75144_4_) {
/* 116 */     ItemStack itemStack = null;
/* 117 */     InventoryPlayer inventoryPlayer = p_75144_4_.field_71071_by;
/*     */     
/* 119 */     if (p_75144_3_ == 5) {
/* 120 */       int i = this.field_94536_g;
/* 121 */       this.field_94536_g = func_94532_c(p_75144_2_);
/*     */       
/* 123 */       if ((i != 1 || this.field_94536_g != 2) && i != this.field_94536_g) {
/* 124 */         func_94533_d();
/* 125 */       } else if (inventoryPlayer.func_70445_o() == null) {
/* 126 */         func_94533_d();
/* 127 */       } else if (this.field_94536_g == 0) {
/* 128 */         this.field_94535_f = func_94529_b(p_75144_2_);
/*     */         
/* 130 */         if (func_94528_d(this.field_94535_f)) {
/* 131 */           this.field_94536_g = 1;
/* 132 */           this.field_94537_h.clear();
/*     */         } else {
/* 134 */           func_94533_d();
/*     */         } 
/* 136 */       } else if (this.field_94536_g == 1) {
/* 137 */         Slot slot = this.field_75151_b.get(p_75144_1_);
/*     */         
/* 139 */         if (slot != null && func_94527_a(slot, inventoryPlayer.func_70445_o(), true) && slot.func_75214_a(inventoryPlayer.func_70445_o()) && (inventoryPlayer.func_70445_o()).field_77994_a > this.field_94537_h.size() && func_94531_b(slot)) {
/* 140 */           this.field_94537_h.add(slot);
/*     */         }
/* 142 */       } else if (this.field_94536_g == 2) {
/* 143 */         if (!this.field_94537_h.isEmpty()) {
/* 144 */           ItemStack itemStack1 = inventoryPlayer.func_70445_o().func_77946_l();
/* 145 */           int j = (inventoryPlayer.func_70445_o()).field_77994_a;
/*     */           
/* 147 */           for (Slot slot : this.field_94537_h) {
/* 148 */             if (slot != null && func_94527_a(slot, inventoryPlayer.func_70445_o(), true) && slot.func_75214_a(inventoryPlayer.func_70445_o()) && (inventoryPlayer.func_70445_o()).field_77994_a >= this.field_94537_h.size() && func_94531_b(slot)) {
/* 149 */               ItemStack itemStack2 = itemStack1.func_77946_l();
/* 150 */               byte b = slot.func_75216_d() ? (slot.func_75211_c()).field_77994_a : 0;
/* 151 */               func_94525_a(this.field_94537_h, this.field_94535_f, itemStack2, b);
/*     */               
/* 153 */               if (itemStack2.field_77994_a > itemStack2.func_77976_d()) itemStack2.field_77994_a = itemStack2.func_77976_d(); 
/* 154 */               if (itemStack2.field_77994_a > slot.func_75219_a()) itemStack2.field_77994_a = slot.func_75219_a();
/*     */               
/* 156 */               j -= itemStack2.field_77994_a - b;
/* 157 */               slot.func_75215_d(itemStack2);
/*     */             } 
/*     */           } 
/*     */           
/* 161 */           itemStack1.field_77994_a = j;
/* 162 */           if (itemStack1.field_77994_a <= 0) {
/* 163 */             itemStack1 = null;
/*     */           }
/* 165 */           inventoryPlayer.func_70437_b(itemStack1);
/*     */         } 
/*     */         
/* 168 */         func_94533_d();
/*     */       } else {
/* 170 */         func_94533_d();
/*     */       } 
/* 172 */     } else if (this.field_94536_g != 0) {
/* 173 */       func_94533_d();
/* 174 */     } else if ((p_75144_3_ == 0 || p_75144_3_ == 1) && (p_75144_2_ == 0 || p_75144_2_ == 1)) {
/* 175 */       if (p_75144_1_ == -999) {
/* 176 */         if (inventoryPlayer.func_70445_o() != null && 
/* 177 */           p_75144_1_ == -999) {
/* 178 */           if (p_75144_2_ == 0) {
/* 179 */             p_75144_4_.func_71019_a(inventoryPlayer.func_70445_o(), true);
/* 180 */             inventoryPlayer.func_70437_b(null);
/*     */           } 
/* 182 */           if (p_75144_2_ == 1) {
/* 183 */             p_75144_4_.func_71019_a(inventoryPlayer.func_70445_o().func_77979_a(1), true);
/* 184 */             if ((inventoryPlayer.func_70445_o()).field_77994_a == 0) inventoryPlayer.func_70437_b(null);
/*     */           
/*     */           }
/*     */         
/*     */         } 
/* 189 */       } else if (p_75144_3_ == 1) {
/* 190 */         if (p_75144_1_ < 0) return null; 
/* 191 */         Slot slot = this.field_75151_b.get(p_75144_1_);
/* 192 */         if (slot != null && slot.func_82869_a(p_75144_4_)) {
/* 193 */           ItemStack itemStack1 = func_82846_b(p_75144_4_, p_75144_1_);
/* 194 */           if (itemStack1 != null) {
/* 195 */             Item item = itemStack1.func_77973_b();
/* 196 */             itemStack = itemStack1.func_77946_l();
/*     */             
/* 198 */             if (slot.func_75211_c() != null && slot.func_75211_c().func_77973_b() == item) {
/* 199 */               func_75133_b(p_75144_1_, p_75144_2_, true, p_75144_4_);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } else {
/* 204 */         if (p_75144_1_ < 0) return null;
/*     */         
/* 206 */         Slot slot = this.field_75151_b.get(p_75144_1_);
/* 207 */         if (slot != null) {
/* 208 */           ItemStack itemStack1 = slot.func_75211_c();
/* 209 */           ItemStack itemStack2 = inventoryPlayer.func_70445_o();
/*     */           
/* 211 */           if (itemStack1 != null) {
/* 212 */             itemStack = itemStack1.func_77946_l();
/*     */           }
/*     */           
/* 215 */           if (itemStack1 == null) {
/* 216 */             if (itemStack2 != null && slot.func_75214_a(itemStack2)) {
/* 217 */               int i = (p_75144_2_ == 0) ? itemStack2.field_77994_a : 1;
/* 218 */               if (i > slot.func_75219_a()) {
/* 219 */                 i = slot.func_75219_a();
/*     */               }
/* 221 */               if (itemStack2.field_77994_a >= i) {
/* 222 */                 slot.func_75215_d(itemStack2.func_77979_a(i));
/*     */               }
/* 224 */               if (itemStack2.field_77994_a == 0) {
/* 225 */                 inventoryPlayer.func_70437_b(null);
/*     */               }
/*     */             } 
/* 228 */           } else if (slot.func_82869_a(p_75144_4_)) {
/* 229 */             if (itemStack2 == null) {
/*     */               
/* 231 */               int i = (p_75144_2_ == 0) ? itemStack1.field_77994_a : ((itemStack1.field_77994_a + 1) / 2);
/* 232 */               ItemStack itemStack3 = slot.func_75209_a(i);
/*     */               
/* 234 */               inventoryPlayer.func_70437_b(itemStack3);
/* 235 */               if (itemStack1.field_77994_a == 0) {
/* 236 */                 slot.func_75215_d(null);
/*     */               }
/* 238 */               slot.func_82870_a(p_75144_4_, inventoryPlayer.func_70445_o());
/* 239 */             } else if (slot.func_75214_a(itemStack2)) {
/*     */               
/* 241 */               if (itemStack1.func_77973_b() != itemStack2.func_77973_b() || itemStack1.func_77960_j() != itemStack2.func_77960_j() || !ItemStack.func_77970_a(itemStack1, itemStack2)) {
/*     */                 
/* 243 */                 if (itemStack2.field_77994_a <= slot.func_75219_a()) {
/* 244 */                   slot.func_75215_d(itemStack2);
/* 245 */                   inventoryPlayer.func_70437_b(itemStack1);
/*     */                 } 
/*     */               } else {
/*     */                 
/* 249 */                 int i = (p_75144_2_ == 0) ? itemStack2.field_77994_a : 1;
/* 250 */                 if (i > slot.func_75219_a() - itemStack1.field_77994_a) {
/* 251 */                   i = slot.func_75219_a() - itemStack1.field_77994_a;
/*     */                 }
/* 253 */                 if (i > itemStack2.func_77976_d() - itemStack1.field_77994_a) {
/* 254 */                   i = itemStack2.func_77976_d() - itemStack1.field_77994_a;
/*     */                 }
/* 256 */                 itemStack2.func_77979_a(i);
/* 257 */                 if (itemStack2.field_77994_a == 0) {
/* 258 */                   inventoryPlayer.func_70437_b(null);
/*     */                 }
/* 260 */                 itemStack1.field_77994_a += i;
/*     */               }
/*     */             
/*     */             }
/* 264 */             else if (itemStack1.func_77973_b() == itemStack2.func_77973_b() && itemStack2.func_77976_d() > 1 && (!itemStack1.func_77981_g() || itemStack1.func_77960_j() == itemStack2.func_77960_j()) && ItemStack.func_77970_a(itemStack1, itemStack2)) {
/*     */               
/* 266 */               int i = itemStack1.field_77994_a;
/* 267 */               if (i > 0 && i + itemStack2.field_77994_a <= itemStack2.func_77976_d()) {
/* 268 */                 itemStack2.field_77994_a += i;
/* 269 */                 itemStack1 = slot.func_75209_a(i);
/* 270 */                 if (itemStack1.field_77994_a == 0) slot.func_75215_d(null); 
/* 271 */                 slot.func_82870_a(p_75144_4_, inventoryPlayer.func_70445_o());
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 277 */           slot.func_75218_e();
/*     */         } 
/*     */       } 
/* 280 */     } else if (p_75144_3_ == 2 && p_75144_2_ >= 0 && p_75144_2_ < 9) {
/* 281 */       Slot slot = this.field_75151_b.get(p_75144_1_);
/* 282 */       if (slot.func_82869_a(p_75144_4_)) {
/* 283 */         ItemStack itemStack1 = inventoryPlayer.func_70301_a(p_75144_2_);
/* 284 */         int i = (itemStack1 == null || (slot.field_75224_c == inventoryPlayer && slot.func_75214_a(itemStack1))) ? 1 : 0;
/* 285 */         int j = -1;
/*     */         
/* 287 */         if (!i) {
/* 288 */           j = inventoryPlayer.func_70447_i();
/* 289 */           i |= (j > -1) ? 1 : 0;
/*     */         } 
/*     */         
/* 292 */         if (slot.func_75216_d() && i != 0) {
/* 293 */           ItemStack itemStack2 = slot.func_75211_c();
/*     */           
/* 295 */           inventoryPlayer.func_70299_a(p_75144_2_, itemStack2.func_77946_l());
/*     */           
/* 297 */           if ((slot.field_75224_c == inventoryPlayer && slot.func_75214_a(itemStack1)) || itemStack1 == null) {
/* 298 */             slot.func_75209_a(itemStack2.field_77994_a);
/* 299 */             slot.func_75215_d(itemStack1);
/* 300 */             slot.func_82870_a(p_75144_4_, itemStack2);
/* 301 */           } else if (j > -1) {
/* 302 */             inventoryPlayer.func_70441_a(itemStack1);
/* 303 */             slot.func_75209_a(itemStack2.field_77994_a);
/* 304 */             slot.func_75215_d(null);
/* 305 */             slot.func_82870_a(p_75144_4_, itemStack2);
/*     */           } 
/* 307 */         } else if (!slot.func_75216_d() && itemStack1 != null && slot.func_75214_a(itemStack1)) {
/* 308 */           inventoryPlayer.func_70299_a(p_75144_2_, null);
/* 309 */           slot.func_75215_d(itemStack1);
/*     */         } 
/*     */       } 
/* 312 */     } else if (p_75144_3_ == 3 && p_75144_4_.field_71075_bZ.field_75098_d && inventoryPlayer.func_70445_o() == null && p_75144_1_ >= 0) {
/* 313 */       Slot slot = this.field_75151_b.get(p_75144_1_);
/* 314 */       if (slot != null && slot.func_75216_d()) {
/* 315 */         ItemStack itemStack1 = slot.func_75211_c().func_77946_l();
/* 316 */         itemStack1.field_77994_a = itemStack1.func_77976_d();
/* 317 */         inventoryPlayer.func_70437_b(itemStack1);
/*     */       } 
/* 319 */     } else if (p_75144_3_ == 4 && inventoryPlayer.func_70445_o() == null && p_75144_1_ >= 0) {
/* 320 */       Slot slot = this.field_75151_b.get(p_75144_1_);
/* 321 */       if (slot != null && slot.func_75216_d() && slot.func_82869_a(p_75144_4_)) {
/* 322 */         ItemStack itemStack1 = slot.func_75209_a((p_75144_2_ == 0) ? 1 : (slot.func_75211_c()).field_77994_a);
/* 323 */         slot.func_82870_a(p_75144_4_, itemStack1);
/* 324 */         p_75144_4_.func_71019_a(itemStack1, true);
/*     */       } 
/* 326 */     } else if (p_75144_3_ == 6 && p_75144_1_ >= 0) {
/* 327 */       Slot slot = this.field_75151_b.get(p_75144_1_);
/* 328 */       ItemStack itemStack1 = inventoryPlayer.func_70445_o();
/*     */       
/* 330 */       if (itemStack1 != null && (slot == null || !slot.func_75216_d() || !slot.func_82869_a(p_75144_4_))) {
/* 331 */         byte b1 = (p_75144_2_ == 0) ? 0 : (this.field_75151_b.size() - 1);
/* 332 */         byte b2 = (p_75144_2_ == 0) ? 1 : -1;
/*     */         
/* 334 */         for (byte b3 = 0; b3 < 2; b3++) {
/*     */           int i;
/* 336 */           for (i = b1; i && i < this.field_75151_b.size() && itemStack1.field_77994_a < itemStack1.func_77976_d(); i += b2) {
/* 337 */             Slot slot1 = this.field_75151_b.get(i);
/*     */             
/* 339 */             if (slot1.func_75216_d() && func_94527_a(slot1, itemStack1, true) && slot1.func_82869_a(p_75144_4_) && func_94530_a(itemStack1, slot1) && (
/* 340 */               b3 != 0 || (slot1.func_75211_c()).field_77994_a != slot1.func_75211_c().func_77976_d())) {
/* 341 */               int j = Math.min(itemStack1.func_77976_d() - itemStack1.field_77994_a, (slot1.func_75211_c()).field_77994_a);
/* 342 */               ItemStack itemStack2 = slot1.func_75209_a(j);
/* 343 */               itemStack1.field_77994_a += j;
/*     */               
/* 345 */               if (itemStack2.field_77994_a <= 0) {
/* 346 */                 slot1.func_75215_d(null);
/*     */               }
/* 348 */               slot1.func_82870_a(p_75144_4_, itemStack2);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 354 */       func_75142_b();
/*     */     } 
/*     */     
/* 357 */     return itemStack;
/*     */   }
/*     */   
/*     */   public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
/* 361 */     return true;
/*     */   }
/*     */   
/*     */   protected void func_75133_b(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {
/* 365 */     func_75144_a(p_75133_1_, p_75133_2_, 1, p_75133_4_);
/*     */   }
/*     */   
/*     */   public void func_75134_a(EntityPlayer p_75134_1_) {
/* 369 */     InventoryPlayer inventoryPlayer = p_75134_1_.field_71071_by;
/* 370 */     if (inventoryPlayer.func_70445_o() != null) {
/* 371 */       p_75134_1_.func_71019_a(inventoryPlayer.func_70445_o(), false);
/* 372 */       inventoryPlayer.func_70437_b(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_75130_a(IInventory p_75130_1_) {
/* 377 */     func_75142_b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75141_a(int p_75141_1_, ItemStack p_75141_2_) {
/* 385 */     func_75139_a(p_75141_1_).func_75215_d(p_75141_2_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75131_a(ItemStack[] p_75131_1_) {
/* 389 */     for (byte b = 0; b < p_75131_1_.length; b++)
/* 390 */       func_75139_a(b).func_75215_d(p_75131_1_[b]); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int p_75137_1_, int p_75137_2_) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public short func_75136_a(InventoryPlayer p_75136_1_) {
/* 398 */     this.field_75150_e = (short)(this.field_75150_e + 1);
/* 399 */     return this.field_75150_e;
/*     */   }
/*     */   
/* 402 */   private Set field_75148_f = new HashSet(); private static final String __OBFID = "CL_00001730";
/*     */   
/*     */   public boolean func_75129_b(EntityPlayer p_75129_1_) {
/* 405 */     return !this.field_75148_f.contains(p_75129_1_);
/*     */   }
/*     */   
/*     */   public void func_75128_a(EntityPlayer p_75128_1_, boolean p_75128_2_) {
/* 409 */     if (p_75128_2_) { this.field_75148_f.remove(p_75128_1_); }
/* 410 */     else { this.field_75148_f.add(p_75128_1_); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_75135_a(ItemStack p_75135_1_, int p_75135_2_, int p_75135_3_, boolean p_75135_4_) {
/* 416 */     boolean bool = false;
/*     */     
/* 418 */     int i = p_75135_2_;
/* 419 */     if (p_75135_4_) {
/* 420 */       i = p_75135_3_ - 1;
/*     */     }
/*     */ 
/*     */     
/* 424 */     if (p_75135_1_.func_77985_e()) {
/* 425 */       while (p_75135_1_.field_77994_a > 0 && ((!p_75135_4_ && i < p_75135_3_) || (p_75135_4_ && i >= p_75135_2_))) {
/*     */         
/* 427 */         Slot slot = this.field_75151_b.get(i);
/* 428 */         ItemStack itemStack = slot.func_75211_c();
/* 429 */         if (itemStack != null && itemStack.func_77973_b() == p_75135_1_.func_77973_b() && (!p_75135_1_.func_77981_g() || p_75135_1_.func_77960_j() == itemStack.func_77960_j()) && ItemStack.func_77970_a(p_75135_1_, itemStack)) {
/* 430 */           int j = itemStack.field_77994_a + p_75135_1_.field_77994_a;
/* 431 */           if (j <= p_75135_1_.func_77976_d()) {
/* 432 */             p_75135_1_.field_77994_a = 0;
/* 433 */             itemStack.field_77994_a = j;
/* 434 */             slot.func_75218_e();
/* 435 */             bool = true;
/* 436 */           } else if (itemStack.field_77994_a < p_75135_1_.func_77976_d()) {
/* 437 */             p_75135_1_.field_77994_a -= p_75135_1_.func_77976_d() - itemStack.field_77994_a;
/* 438 */             itemStack.field_77994_a = p_75135_1_.func_77976_d();
/* 439 */             slot.func_75218_e();
/* 440 */             bool = true;
/*     */           } 
/*     */         } 
/*     */         
/* 444 */         if (p_75135_4_) {
/* 445 */           i--; continue;
/*     */         } 
/* 447 */         i++;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 453 */     if (p_75135_1_.field_77994_a > 0) {
/* 454 */       if (p_75135_4_) {
/* 455 */         i = p_75135_3_ - 1;
/*     */       } else {
/* 457 */         i = p_75135_2_;
/*     */       } 
/* 459 */       while ((!p_75135_4_ && i < p_75135_3_) || (p_75135_4_ && i >= p_75135_2_)) {
/* 460 */         Slot slot = this.field_75151_b.get(i);
/* 461 */         ItemStack itemStack = slot.func_75211_c();
/*     */         
/* 463 */         if (itemStack == null) {
/* 464 */           slot.func_75215_d(p_75135_1_.func_77946_l());
/* 465 */           slot.func_75218_e();
/* 466 */           p_75135_1_.field_77994_a = 0;
/* 467 */           bool = true;
/*     */           
/*     */           break;
/*     */         } 
/* 471 */         if (p_75135_4_) {
/* 472 */           i--; continue;
/*     */         } 
/* 474 */         i++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 479 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int func_94529_b(int p_94529_0_) {
/* 487 */     return p_94529_0_ >> 2 & 0x3;
/*     */   }
/*     */   
/*     */   public static int func_94532_c(int p_94532_0_) {
/* 491 */     return p_94532_0_ & 0x3;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_94534_d(int p_94534_0_, int p_94534_1_) {
/* 495 */     return p_94534_0_ & 0x3 | (p_94534_1_ & 0x3) << 2;
/*     */   }
/*     */   
/*     */   public static boolean func_94528_d(int p_94528_0_) {
/* 499 */     return (p_94528_0_ == 0 || p_94528_0_ == 1);
/*     */   }
/*     */   
/*     */   protected void func_94533_d() {
/* 503 */     this.field_94536_g = 0;
/* 504 */     this.field_94537_h.clear();
/*     */   }
/*     */   
/*     */   public static boolean func_94527_a(Slot p_94527_0_, ItemStack p_94527_1_, boolean p_94527_2_) {
/* 508 */     int i = (p_94527_0_ == null || !p_94527_0_.func_75216_d()) ? 1 : 0;
/*     */     
/* 510 */     if (p_94527_0_ != null && p_94527_0_.func_75216_d() && p_94527_1_ != null && p_94527_1_.func_77969_a(p_94527_0_.func_75211_c()) && ItemStack.func_77970_a(p_94527_0_.func_75211_c(), p_94527_1_)) {
/* 511 */       i |= ((p_94527_0_.func_75211_c()).field_77994_a + (p_94527_2_ ? 0 : p_94527_1_.field_77994_a) <= p_94527_1_.func_77976_d()) ? 1 : 0;
/*     */     }
/*     */     
/* 514 */     return i;
/*     */   }
/*     */   
/*     */   public static void func_94525_a(Set p_94525_0_, int p_94525_1_, ItemStack p_94525_2_, int p_94525_3_) {
/* 518 */     switch (p_94525_1_) {
/*     */       case 0:
/* 520 */         p_94525_2_.field_77994_a = MathHelper.func_76141_d(p_94525_2_.field_77994_a / p_94525_0_.size());
/*     */         break;
/*     */       case 1:
/* 523 */         p_94525_2_.field_77994_a = 1;
/*     */         break;
/*     */     } 
/*     */     
/* 527 */     p_94525_2_.field_77994_a += p_94525_3_;
/*     */   }
/*     */   
/*     */   public boolean func_94531_b(Slot p_94531_1_) {
/* 531 */     return true;
/*     */   }
/*     */   
/*     */   public static int func_94526_b(IInventory p_94526_0_) {
/* 535 */     if (p_94526_0_ == null) return 0; 
/* 536 */     byte b1 = 0;
/* 537 */     float f = 0.0F;
/*     */     
/* 539 */     for (byte b2 = 0; b2 < p_94526_0_.func_70302_i_(); b2++) {
/* 540 */       ItemStack itemStack = p_94526_0_.func_70301_a(b2);
/*     */       
/* 542 */       if (itemStack != null) {
/* 543 */         f += itemStack.field_77994_a / Math.min(p_94526_0_.func_70297_j_(), itemStack.func_77976_d());
/* 544 */         b1++;
/*     */       } 
/*     */     } 
/*     */     
/* 548 */     f /= p_94526_0_.func_70302_i_();
/* 549 */     return MathHelper.func_76141_d(f * 14.0F) + ((b1 > 0) ? 1 : 0);
/*     */   }
/*     */   
/*     */   public abstract boolean func_75145_c(EntityPlayer paramEntityPlayer);
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */