/*     */ package net.minecraft.world.gen.structure;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemDoor;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.tileentity.TileEntityDispenser;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.World;
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
/*     */ public abstract class StructureComponent
/*     */ {
/*     */   protected StructureBoundingBox field_74887_e;
/*     */   protected int field_74885_f;
/*     */   protected int field_74886_g;
/*     */   private static final String __OBFID = "CL_00000511";
/*     */   
/*     */   public StructureComponent() {}
/*     */   
/*     */   protected StructureComponent(int p_i2091_1_) {
/*  52 */     this.field_74886_g = p_i2091_1_;
/*  53 */     this.field_74885_f = -1;
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_143010_b() {
/*  57 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */     
/*  59 */     nBTTagCompound.func_74778_a("id", MapGenStructureIO.func_143036_a(this));
/*  60 */     nBTTagCompound.func_74782_a("BB", (NBTBase)this.field_74887_e.func_151535_h());
/*  61 */     nBTTagCompound.func_74768_a("O", this.field_74885_f);
/*  62 */     nBTTagCompound.func_74768_a("GD", this.field_74886_g);
/*     */     
/*  64 */     func_143012_a(nBTTagCompound);
/*     */     
/*  66 */     return nBTTagCompound;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void func_143012_a(NBTTagCompound paramNBTTagCompound);
/*     */   
/*     */   public void func_143009_a(World p_143009_1_, NBTTagCompound p_143009_2_) {
/*  73 */     if (p_143009_2_.func_74764_b("BB")) {
/*  74 */       this.field_74887_e = new StructureBoundingBox(p_143009_2_.func_74759_k("BB"));
/*     */     }
/*  76 */     this.field_74885_f = p_143009_2_.func_74762_e("O");
/*  77 */     this.field_74886_g = p_143009_2_.func_74762_e("GD");
/*     */     
/*  79 */     func_143011_b(p_143009_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void func_143011_b(NBTTagCompound paramNBTTagCompound);
/*     */ 
/*     */   
/*     */   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {}
/*     */   
/*     */   public abstract boolean func_74875_a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox);
/*     */   
/*     */   public StructureBoundingBox func_74874_b() {
/*  91 */     return this.field_74887_e;
/*     */   }
/*     */   
/*     */   public int func_74877_c() {
/*  95 */     return this.field_74886_g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StructureComponent func_74883_a(List p_74883_0_, StructureBoundingBox p_74883_1_) {
/* 106 */     for (StructureComponent structureComponent : p_74883_0_) {
/* 107 */       if (structureComponent.func_74874_b() != null && structureComponent.func_74874_b().func_78884_a(p_74883_1_)) {
/* 108 */         return structureComponent;
/*     */       }
/*     */     } 
/* 111 */     return null;
/*     */   }
/*     */   
/*     */   public ChunkPosition func_151553_a() {
/* 115 */     return new ChunkPosition(this.field_74887_e.func_78881_e(), this.field_74887_e.func_78879_f(), this.field_74887_e.func_78891_g());
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_74860_a(World p_74860_1_, StructureBoundingBox p_74860_2_) {
/* 120 */     int i = Math.max(this.field_74887_e.field_78897_a - 1, p_74860_2_.field_78897_a);
/* 121 */     int j = Math.max(this.field_74887_e.field_78895_b - 1, p_74860_2_.field_78895_b);
/* 122 */     int k = Math.max(this.field_74887_e.field_78896_c - 1, p_74860_2_.field_78896_c);
/* 123 */     int m = Math.min(this.field_74887_e.field_78893_d + 1, p_74860_2_.field_78893_d);
/* 124 */     int n = Math.min(this.field_74887_e.field_78894_e + 1, p_74860_2_.field_78894_e);
/* 125 */     int i1 = Math.min(this.field_74887_e.field_78892_f + 1, p_74860_2_.field_78892_f);
/*     */     
/*     */     int i2;
/* 128 */     for (i2 = i; i2 <= m; i2++) {
/* 129 */       for (int i3 = k; i3 <= i1; i3++) {
/* 130 */         if (p_74860_1_.func_147439_a(i2, j, i3).func_149688_o().func_76224_d()) {
/* 131 */           return true;
/*     */         }
/* 133 */         if (p_74860_1_.func_147439_a(i2, n, i3).func_149688_o().func_76224_d()) {
/* 134 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     for (i2 = i; i2 <= m; i2++) {
/* 140 */       for (int i3 = j; i3 <= n; i3++) {
/* 141 */         if (p_74860_1_.func_147439_a(i2, i3, k).func_149688_o().func_76224_d()) {
/* 142 */           return true;
/*     */         }
/* 144 */         if (p_74860_1_.func_147439_a(i2, i3, i1).func_149688_o().func_76224_d()) {
/* 145 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 150 */     for (i2 = k; i2 <= i1; i2++) {
/* 151 */       for (int i3 = j; i3 <= n; i3++) {
/* 152 */         if (p_74860_1_.func_147439_a(i, i3, i2).func_149688_o().func_76224_d()) {
/* 153 */           return true;
/*     */         }
/* 155 */         if (p_74860_1_.func_147439_a(m, i3, i2).func_149688_o().func_76224_d()) {
/* 156 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 160 */     return false;
/*     */   }
/*     */   
/*     */   protected int func_74865_a(int p_74865_1_, int p_74865_2_) {
/* 164 */     switch (this.field_74885_f) {
/*     */       case 0:
/*     */       case 2:
/* 167 */         return this.field_74887_e.field_78897_a + p_74865_1_;
/*     */       case 1:
/* 169 */         return this.field_74887_e.field_78893_d - p_74865_2_;
/*     */       case 3:
/* 171 */         return this.field_74887_e.field_78897_a + p_74865_2_;
/*     */     } 
/* 173 */     return p_74865_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_74862_a(int p_74862_1_) {
/* 178 */     if (this.field_74885_f == -1) {
/* 179 */       return p_74862_1_;
/*     */     }
/* 181 */     return p_74862_1_ + this.field_74887_e.field_78895_b;
/*     */   }
/*     */   
/*     */   protected int func_74873_b(int p_74873_1_, int p_74873_2_) {
/* 185 */     switch (this.field_74885_f) {
/*     */       case 2:
/* 187 */         return this.field_74887_e.field_78892_f - p_74873_2_;
/*     */       case 0:
/* 189 */         return this.field_74887_e.field_78896_c + p_74873_2_;
/*     */       case 1:
/*     */       case 3:
/* 192 */         return this.field_74887_e.field_78896_c + p_74873_1_;
/*     */     } 
/* 194 */     return p_74873_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_151555_a(Block p_151555_1_, int p_151555_2_) {
/* 199 */     if (p_151555_1_ == Blocks.field_150448_aq) {
/* 200 */       if (this.field_74885_f == 1 || this.field_74885_f == 3) {
/* 201 */         if (p_151555_2_ == 1) {
/* 202 */           return 0;
/*     */         }
/* 204 */         return 1;
/*     */       }
/*     */     
/* 207 */     } else if (p_151555_1_ == Blocks.field_150466_ao || p_151555_1_ == Blocks.field_150454_av) {
/* 208 */       if (this.field_74885_f == 0) {
/* 209 */         if (p_151555_2_ == 0) {
/* 210 */           return 2;
/*     */         }
/* 212 */         if (p_151555_2_ == 2)
/* 213 */           return 0; 
/*     */       } else {
/* 215 */         if (this.field_74885_f == 1)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 220 */           return p_151555_2_ + 1 & 0x3; } 
/* 221 */         if (this.field_74885_f == 3)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 226 */           return p_151555_2_ + 3 & 0x3; } 
/*     */       } 
/* 228 */     } else if (p_151555_1_ == Blocks.field_150446_ar || p_151555_1_ == Blocks.field_150476_ad || p_151555_1_ == Blocks.field_150387_bl || p_151555_1_ == Blocks.field_150390_bg || p_151555_1_ == Blocks.field_150372_bz) {
/* 229 */       if (this.field_74885_f == 0) {
/* 230 */         if (p_151555_2_ == 2) {
/* 231 */           return 3;
/*     */         }
/* 233 */         if (p_151555_2_ == 3) {
/* 234 */           return 2;
/*     */         }
/* 236 */       } else if (this.field_74885_f == 1) {
/* 237 */         if (p_151555_2_ == 0) {
/* 238 */           return 2;
/*     */         }
/* 240 */         if (p_151555_2_ == 1) {
/* 241 */           return 3;
/*     */         }
/* 243 */         if (p_151555_2_ == 2) {
/* 244 */           return 0;
/*     */         }
/* 246 */         if (p_151555_2_ == 3) {
/* 247 */           return 1;
/*     */         }
/* 249 */       } else if (this.field_74885_f == 3) {
/* 250 */         if (p_151555_2_ == 0) {
/* 251 */           return 2;
/*     */         }
/* 253 */         if (p_151555_2_ == 1) {
/* 254 */           return 3;
/*     */         }
/* 256 */         if (p_151555_2_ == 2) {
/* 257 */           return 1;
/*     */         }
/* 259 */         if (p_151555_2_ == 3) {
/* 260 */           return 0;
/*     */         }
/*     */       } 
/* 263 */     } else if (p_151555_1_ == Blocks.field_150468_ap) {
/* 264 */       if (this.field_74885_f == 0) {
/* 265 */         if (p_151555_2_ == 2) {
/* 266 */           return 3;
/*     */         }
/* 268 */         if (p_151555_2_ == 3) {
/* 269 */           return 2;
/*     */         }
/* 271 */       } else if (this.field_74885_f == 1) {
/* 272 */         if (p_151555_2_ == 2) {
/* 273 */           return 4;
/*     */         }
/* 275 */         if (p_151555_2_ == 3) {
/* 276 */           return 5;
/*     */         }
/* 278 */         if (p_151555_2_ == 4) {
/* 279 */           return 2;
/*     */         }
/* 281 */         if (p_151555_2_ == 5) {
/* 282 */           return 3;
/*     */         }
/* 284 */       } else if (this.field_74885_f == 3) {
/* 285 */         if (p_151555_2_ == 2) {
/* 286 */           return 5;
/*     */         }
/* 288 */         if (p_151555_2_ == 3) {
/* 289 */           return 4;
/*     */         }
/* 291 */         if (p_151555_2_ == 4) {
/* 292 */           return 2;
/*     */         }
/* 294 */         if (p_151555_2_ == 5) {
/* 295 */           return 3;
/*     */         }
/*     */       }
/*     */     
/* 299 */     } else if (p_151555_1_ == Blocks.field_150430_aB) {
/* 300 */       if (this.field_74885_f == 0) {
/* 301 */         if (p_151555_2_ == 3) {
/* 302 */           return 4;
/*     */         }
/* 304 */         if (p_151555_2_ == 4) {
/* 305 */           return 3;
/*     */         }
/* 307 */       } else if (this.field_74885_f == 1) {
/* 308 */         if (p_151555_2_ == 3) {
/* 309 */           return 1;
/*     */         }
/* 311 */         if (p_151555_2_ == 4) {
/* 312 */           return 2;
/*     */         }
/* 314 */         if (p_151555_2_ == 2) {
/* 315 */           return 3;
/*     */         }
/* 317 */         if (p_151555_2_ == 1) {
/* 318 */           return 4;
/*     */         }
/* 320 */       } else if (this.field_74885_f == 3) {
/* 321 */         if (p_151555_2_ == 3) {
/* 322 */           return 2;
/*     */         }
/* 324 */         if (p_151555_2_ == 4) {
/* 325 */           return 1;
/*     */         }
/* 327 */         if (p_151555_2_ == 2) {
/* 328 */           return 3;
/*     */         }
/* 330 */         if (p_151555_2_ == 1) {
/* 331 */           return 4;
/*     */         }
/*     */       } 
/* 334 */     } else if (p_151555_1_ == Blocks.field_150479_bC || p_151555_1_ instanceof net.minecraft.block.BlockDirectional) {
/* 335 */       if (this.field_74885_f == 0) {
/* 336 */         if (p_151555_2_ == 0 || p_151555_2_ == 2) {
/* 337 */           return Direction.field_71580_e[p_151555_2_];
/*     */         }
/* 339 */       } else if (this.field_74885_f == 1) {
/* 340 */         if (p_151555_2_ == 2) {
/* 341 */           return 1;
/*     */         }
/* 343 */         if (p_151555_2_ == 0) {
/* 344 */           return 3;
/*     */         }
/* 346 */         if (p_151555_2_ == 1) {
/* 347 */           return 2;
/*     */         }
/* 349 */         if (p_151555_2_ == 3) {
/* 350 */           return 0;
/*     */         }
/* 352 */       } else if (this.field_74885_f == 3) {
/* 353 */         if (p_151555_2_ == 2) {
/* 354 */           return 3;
/*     */         }
/* 356 */         if (p_151555_2_ == 0) {
/* 357 */           return 1;
/*     */         }
/* 359 */         if (p_151555_2_ == 1) {
/* 360 */           return 2;
/*     */         }
/* 362 */         if (p_151555_2_ == 3) {
/* 363 */           return 0;
/*     */         }
/*     */       } 
/* 366 */     } else if (p_151555_1_ == Blocks.field_150331_J || p_151555_1_ == Blocks.field_150320_F || p_151555_1_ == Blocks.field_150442_at || p_151555_1_ == Blocks.field_150367_z) {
/* 367 */       if (this.field_74885_f == 0) {
/* 368 */         if (p_151555_2_ == 2 || p_151555_2_ == 3) {
/* 369 */           return Facing.field_71588_a[p_151555_2_];
/*     */         }
/* 371 */       } else if (this.field_74885_f == 1) {
/* 372 */         if (p_151555_2_ == 2) {
/* 373 */           return 4;
/*     */         }
/* 375 */         if (p_151555_2_ == 3) {
/* 376 */           return 5;
/*     */         }
/* 378 */         if (p_151555_2_ == 4) {
/* 379 */           return 2;
/*     */         }
/* 381 */         if (p_151555_2_ == 5) {
/* 382 */           return 3;
/*     */         }
/* 384 */       } else if (this.field_74885_f == 3) {
/* 385 */         if (p_151555_2_ == 2) {
/* 386 */           return 5;
/*     */         }
/* 388 */         if (p_151555_2_ == 3) {
/* 389 */           return 4;
/*     */         }
/* 391 */         if (p_151555_2_ == 4) {
/* 392 */           return 2;
/*     */         }
/* 394 */         if (p_151555_2_ == 5) {
/* 395 */           return 3;
/*     */         }
/*     */       } 
/*     */     } 
/* 399 */     return p_151555_2_;
/*     */   }
/*     */   
/*     */   protected void func_151550_a(World p_151550_1_, Block p_151550_2_, int p_151550_3_, int p_151550_4_, int p_151550_5_, int p_151550_6_, StructureBoundingBox p_151550_7_) {
/* 403 */     int i = func_74865_a(p_151550_4_, p_151550_6_);
/* 404 */     int j = func_74862_a(p_151550_5_);
/* 405 */     int k = func_74873_b(p_151550_4_, p_151550_6_);
/*     */     
/* 407 */     if (!p_151550_7_.func_78890_b(i, j, k)) {
/*     */       return;
/*     */     }
/*     */     
/* 411 */     p_151550_1_.func_147465_d(i, j, k, p_151550_2_, p_151550_3_, 2);
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
/*     */   protected Block func_151548_a(World p_151548_1_, int p_151548_2_, int p_151548_3_, int p_151548_4_, StructureBoundingBox p_151548_5_) {
/* 428 */     int i = func_74865_a(p_151548_2_, p_151548_4_);
/* 429 */     int j = func_74862_a(p_151548_3_);
/* 430 */     int k = func_74873_b(p_151548_2_, p_151548_4_);
/*     */     
/* 432 */     if (!p_151548_5_.func_78890_b(i, j, k)) {
/* 433 */       return Blocks.field_150350_a;
/*     */     }
/*     */     
/* 436 */     return p_151548_1_.func_147439_a(i, j, k);
/*     */   }
/*     */   
/*     */   protected void func_74878_a(World p_74878_1_, StructureBoundingBox p_74878_2_, int p_74878_3_, int p_74878_4_, int p_74878_5_, int p_74878_6_, int p_74878_7_, int p_74878_8_) {
/* 440 */     for (int i = p_74878_4_; i <= p_74878_7_; i++) {
/* 441 */       for (int j = p_74878_3_; j <= p_74878_6_; j++) {
/* 442 */         for (int k = p_74878_5_; k <= p_74878_8_; k++) {
/* 443 */           func_151550_a(p_74878_1_, Blocks.field_150350_a, 0, j, i, k, p_74878_2_);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_151549_a(World p_151549_1_, StructureBoundingBox p_151549_2_, int p_151549_3_, int p_151549_4_, int p_151549_5_, int p_151549_6_, int p_151549_7_, int p_151549_8_, Block p_151549_9_, Block p_151549_10_, boolean p_151549_11_) {
/* 450 */     for (int i = p_151549_4_; i <= p_151549_7_; i++) {
/* 451 */       for (int j = p_151549_3_; j <= p_151549_6_; j++) {
/* 452 */         for (int k = p_151549_5_; k <= p_151549_8_; k++) {
/*     */           
/* 454 */           if (!p_151549_11_ || func_151548_a(p_151549_1_, j, i, k, p_151549_2_).func_149688_o() != Material.field_151579_a)
/*     */           {
/*     */             
/* 457 */             if (i == p_151549_4_ || i == p_151549_7_ || j == p_151549_3_ || j == p_151549_6_ || k == p_151549_5_ || k == p_151549_8_) {
/* 458 */               func_151550_a(p_151549_1_, p_151549_9_, 0, j, i, k, p_151549_2_);
/*     */             } else {
/* 460 */               func_151550_a(p_151549_1_, p_151549_10_, 0, j, i, k, p_151549_2_);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_151556_a(World p_151556_1_, StructureBoundingBox p_151556_2_, int p_151556_3_, int p_151556_4_, int p_151556_5_, int p_151556_6_, int p_151556_7_, int p_151556_8_, Block p_151556_9_, int p_151556_10_, Block p_151556_11_, int p_151556_12_, boolean p_151556_13_) {
/* 469 */     for (int i = p_151556_4_; i <= p_151556_7_; i++) {
/* 470 */       for (int j = p_151556_3_; j <= p_151556_6_; j++) {
/* 471 */         for (int k = p_151556_5_; k <= p_151556_8_; k++) {
/*     */           
/* 473 */           if (!p_151556_13_ || func_151548_a(p_151556_1_, j, i, k, p_151556_2_).func_149688_o() != Material.field_151579_a)
/*     */           {
/*     */             
/* 476 */             if (i == p_151556_4_ || i == p_151556_7_ || j == p_151556_3_ || j == p_151556_6_ || k == p_151556_5_ || k == p_151556_8_) {
/* 477 */               func_151550_a(p_151556_1_, p_151556_9_, p_151556_10_, j, i, k, p_151556_2_);
/*     */             } else {
/* 479 */               func_151550_a(p_151556_1_, p_151556_11_, p_151556_12_, j, i, k, p_151556_2_);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_74882_a(World p_74882_1_, StructureBoundingBox p_74882_2_, int p_74882_3_, int p_74882_4_, int p_74882_5_, int p_74882_6_, int p_74882_7_, int p_74882_8_, boolean p_74882_9_, Random p_74882_10_, BlockSelector p_74882_11_) {
/* 492 */     for (int i = p_74882_4_; i <= p_74882_7_; i++) {
/* 493 */       for (int j = p_74882_3_; j <= p_74882_6_; j++) {
/* 494 */         for (int k = p_74882_5_; k <= p_74882_8_; k++) {
/*     */           
/* 496 */           if (!p_74882_9_ || func_151548_a(p_74882_1_, j, i, k, p_74882_2_).func_149688_o() != Material.field_151579_a) {
/*     */ 
/*     */             
/* 499 */             p_74882_11_.func_75062_a(p_74882_10_, j, i, k, (i == p_74882_4_ || i == p_74882_7_ || j == p_74882_3_ || j == p_74882_6_ || k == p_74882_5_ || k == p_74882_8_));
/* 500 */             func_151550_a(p_74882_1_, p_74882_11_.func_151561_a(), p_74882_11_.func_75064_b(), j, i, k, p_74882_2_);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_151551_a(World p_151551_1_, StructureBoundingBox p_151551_2_, Random p_151551_3_, float p_151551_4_, int p_151551_5_, int p_151551_6_, int p_151551_7_, int p_151551_8_, int p_151551_9_, int p_151551_10_, Block p_151551_11_, Block p_151551_12_, boolean p_151551_13_) {
/* 512 */     for (int i = p_151551_6_; i <= p_151551_9_; i++) {
/* 513 */       for (int j = p_151551_5_; j <= p_151551_8_; j++) {
/* 514 */         for (int k = p_151551_7_; k <= p_151551_10_; k++) {
/*     */           
/* 516 */           if (p_151551_3_.nextFloat() <= p_151551_4_)
/*     */           {
/*     */             
/* 519 */             if (!p_151551_13_ || func_151548_a(p_151551_1_, j, i, k, p_151551_2_).func_149688_o() != Material.field_151579_a)
/*     */             {
/*     */               
/* 522 */               if (i == p_151551_6_ || i == p_151551_9_ || j == p_151551_5_ || j == p_151551_8_ || k == p_151551_7_ || k == p_151551_10_) {
/* 523 */                 func_151550_a(p_151551_1_, p_151551_11_, 0, j, i, k, p_151551_2_);
/*     */               } else {
/* 525 */                 func_151550_a(p_151551_1_, p_151551_12_, 0, j, i, k, p_151551_2_);
/*     */               }  } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_151552_a(World p_151552_1_, StructureBoundingBox p_151552_2_, Random p_151552_3_, float p_151552_4_, int p_151552_5_, int p_151552_6_, int p_151552_7_, Block p_151552_8_, int p_151552_9_) {
/* 534 */     if (p_151552_3_.nextFloat() < p_151552_4_) {
/* 535 */       func_151550_a(p_151552_1_, p_151552_8_, p_151552_9_, p_151552_5_, p_151552_6_, p_151552_7_, p_151552_2_);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_151547_a(World p_151547_1_, StructureBoundingBox p_151547_2_, int p_151547_3_, int p_151547_4_, int p_151547_5_, int p_151547_6_, int p_151547_7_, int p_151547_8_, Block p_151547_9_, boolean p_151547_10_) {
/* 540 */     float f1 = (p_151547_6_ - p_151547_3_ + 1);
/* 541 */     float f2 = (p_151547_7_ - p_151547_4_ + 1);
/* 542 */     float f3 = (p_151547_8_ - p_151547_5_ + 1);
/* 543 */     float f4 = p_151547_3_ + f1 / 2.0F;
/* 544 */     float f5 = p_151547_5_ + f3 / 2.0F;
/*     */     
/* 546 */     for (int i = p_151547_4_; i <= p_151547_7_; i++) {
/* 547 */       float f = (i - p_151547_4_) / f2;
/*     */       
/* 549 */       for (int j = p_151547_3_; j <= p_151547_6_; j++) {
/* 550 */         float f6 = (j - f4) / f1 * 0.5F;
/*     */         
/* 552 */         for (int k = p_151547_5_; k <= p_151547_8_; k++) {
/* 553 */           float f7 = (k - f5) / f3 * 0.5F;
/*     */           
/* 555 */           if (!p_151547_10_ || func_151548_a(p_151547_1_, j, i, k, p_151547_2_).func_149688_o() != Material.field_151579_a) {
/*     */ 
/*     */ 
/*     */             
/* 559 */             float f8 = f6 * f6 + f * f + f7 * f7;
/*     */             
/* 561 */             if (f8 <= 1.05F) {
/* 562 */               func_151550_a(p_151547_1_, p_151547_9_, 0, j, i, k, p_151547_2_);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_74871_b(World p_74871_1_, int p_74871_2_, int p_74871_3_, int p_74871_4_, StructureBoundingBox p_74871_5_) {
/* 572 */     int i = func_74865_a(p_74871_2_, p_74871_4_);
/* 573 */     int j = func_74862_a(p_74871_3_);
/* 574 */     int k = func_74873_b(p_74871_2_, p_74871_4_);
/*     */     
/* 576 */     if (!p_74871_5_.func_78890_b(i, j, k)) {
/*     */       return;
/*     */     }
/*     */     
/* 580 */     while (!p_74871_1_.func_147437_c(i, j, k) && j < 255) {
/* 581 */       p_74871_1_.func_147465_d(i, j, k, Blocks.field_150350_a, 0, 2);
/* 582 */       j++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_151554_b(World p_151554_1_, Block p_151554_2_, int p_151554_3_, int p_151554_4_, int p_151554_5_, int p_151554_6_, StructureBoundingBox p_151554_7_) {
/* 588 */     int i = func_74865_a(p_151554_4_, p_151554_6_);
/* 589 */     int j = func_74862_a(p_151554_5_);
/* 590 */     int k = func_74873_b(p_151554_4_, p_151554_6_);
/*     */     
/* 592 */     if (!p_151554_7_.func_78890_b(i, j, k)) {
/*     */       return;
/*     */     }
/*     */     
/* 596 */     while ((p_151554_1_.func_147437_c(i, j, k) || p_151554_1_.func_147439_a(i, j, k).func_149688_o().func_76224_d()) && j > 1) {
/* 597 */       p_151554_1_.func_147465_d(i, j, k, p_151554_2_, p_151554_3_, 2);
/* 598 */       j--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_74879_a(World p_74879_1_, StructureBoundingBox p_74879_2_, Random p_74879_3_, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent[] p_74879_7_, int p_74879_8_) {
/* 604 */     int i = func_74865_a(p_74879_4_, p_74879_6_);
/* 605 */     int j = func_74862_a(p_74879_5_);
/* 606 */     int k = func_74873_b(p_74879_4_, p_74879_6_);
/*     */     
/* 608 */     if (p_74879_2_.func_78890_b(i, j, k) && 
/* 609 */       p_74879_1_.func_147439_a(i, j, k) != Blocks.field_150486_ae) {
/* 610 */       p_74879_1_.func_147465_d(i, j, k, (Block)Blocks.field_150486_ae, 0, 2);
/* 611 */       TileEntityChest tileEntityChest = (TileEntityChest)p_74879_1_.func_147438_o(i, j, k);
/* 612 */       if (tileEntityChest != null) WeightedRandomChestContent.func_76293_a(p_74879_3_, p_74879_7_, (IInventory)tileEntityChest, p_74879_8_); 
/* 613 */       return true;
/*     */     } 
/*     */     
/* 616 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_74869_a(World p_74869_1_, StructureBoundingBox p_74869_2_, Random p_74869_3_, int p_74869_4_, int p_74869_5_, int p_74869_6_, int p_74869_7_, WeightedRandomChestContent[] p_74869_8_, int p_74869_9_) {
/* 621 */     int i = func_74865_a(p_74869_4_, p_74869_6_);
/* 622 */     int j = func_74862_a(p_74869_5_);
/* 623 */     int k = func_74873_b(p_74869_4_, p_74869_6_);
/*     */     
/* 625 */     if (p_74869_2_.func_78890_b(i, j, k) && 
/* 626 */       p_74869_1_.func_147439_a(i, j, k) != Blocks.field_150367_z) {
/* 627 */       p_74869_1_.func_147465_d(i, j, k, Blocks.field_150367_z, func_151555_a(Blocks.field_150367_z, p_74869_7_), 2);
/* 628 */       TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)p_74869_1_.func_147438_o(i, j, k);
/* 629 */       if (tileEntityDispenser != null) WeightedRandomChestContent.func_150706_a(p_74869_3_, p_74869_8_, tileEntityDispenser, p_74869_9_); 
/* 630 */       return true;
/*     */     } 
/*     */     
/* 633 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_74881_a(World p_74881_1_, StructureBoundingBox p_74881_2_, Random p_74881_3_, int p_74881_4_, int p_74881_5_, int p_74881_6_, int p_74881_7_) {
/* 638 */     int i = func_74865_a(p_74881_4_, p_74881_6_);
/* 639 */     int j = func_74862_a(p_74881_5_);
/* 640 */     int k = func_74873_b(p_74881_4_, p_74881_6_);
/*     */     
/* 642 */     if (p_74881_2_.func_78890_b(i, j, k)) {
/* 643 */       ItemDoor.func_150924_a(p_74881_1_, i, j, k, p_74881_7_, Blocks.field_150466_ao);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class BlockSelector
/*     */   {
/* 649 */     protected Block field_151562_a = Blocks.field_150350_a; protected int field_75065_b;
/*     */     private static final String __OBFID = "CL_00000512";
/*     */     
/*     */     public abstract void func_75062_a(Random param1Random, int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean);
/*     */     
/*     */     public Block func_151561_a() {
/* 655 */       return this.field_151562_a;
/*     */     }
/*     */     
/*     */     public int func_75064_b() {
/* 659 */       return this.field_75065_b;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\StructureComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */