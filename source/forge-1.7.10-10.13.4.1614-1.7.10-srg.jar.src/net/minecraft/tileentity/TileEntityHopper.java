/*     */ package net.minecraft.tileentity;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockHopper;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TileEntityHopper extends TileEntity implements IHopper {
/*  20 */   private ItemStack[] field_145900_a = new ItemStack[5];
/*     */   private String field_145902_i;
/*  22 */   private int field_145901_j = -1;
/*     */   private static final String __OBFID = "CL_00000359";
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/*  26 */     super.func_145839_a(p_145839_1_);
/*     */ 
/*     */     
/*  29 */     NBTTagList nBTTagList = p_145839_1_.func_150295_c("Items", 10);
/*  30 */     this.field_145900_a = new ItemStack[func_70302_i_()];
/*  31 */     if (p_145839_1_.func_150297_b("CustomName", 8)) this.field_145902_i = p_145839_1_.func_74779_i("CustomName"); 
/*  32 */     this.field_145901_j = p_145839_1_.func_74762_e("TransferCooldown");
/*  33 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  34 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/*  35 */       byte b1 = nBTTagCompound.func_74771_c("Slot");
/*  36 */       if (b1 >= 0 && b1 < this.field_145900_a.length) this.field_145900_a[b1] = ItemStack.func_77949_a(nBTTagCompound);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/*  42 */     super.func_145841_b(p_145841_1_);
/*  43 */     NBTTagList nBTTagList = new NBTTagList();
/*     */     
/*  45 */     for (byte b = 0; b < this.field_145900_a.length; b++) {
/*  46 */       if (this.field_145900_a[b] != null) {
/*  47 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*  48 */         nBTTagCompound.func_74774_a("Slot", (byte)b);
/*  49 */         this.field_145900_a[b].func_77955_b(nBTTagCompound);
/*  50 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/*     */     } 
/*  53 */     p_145841_1_.func_74782_a("Items", (NBTBase)nBTTagList);
/*  54 */     p_145841_1_.func_74768_a("TransferCooldown", this.field_145901_j);
/*  55 */     if (func_145818_k_()) p_145841_1_.func_74778_a("CustomName", this.field_145902_i);
/*     */   
/*     */   }
/*     */   
/*     */   public void func_70296_d() {
/*  60 */     super.func_70296_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  65 */     return this.field_145900_a.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/*  70 */     return this.field_145900_a[p_70301_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/*  75 */     if (this.field_145900_a[p_70298_1_] != null) {
/*  76 */       if ((this.field_145900_a[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*  77 */         ItemStack itemStack1 = this.field_145900_a[p_70298_1_];
/*  78 */         this.field_145900_a[p_70298_1_] = null;
/*  79 */         return itemStack1;
/*     */       } 
/*  81 */       ItemStack itemStack = this.field_145900_a[p_70298_1_].func_77979_a(p_70298_2_);
/*  82 */       if ((this.field_145900_a[p_70298_1_]).field_77994_a == 0) this.field_145900_a[p_70298_1_] = null; 
/*  83 */       return itemStack;
/*     */     } 
/*     */     
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/*  91 */     if (this.field_145900_a[p_70304_1_] != null) {
/*  92 */       ItemStack itemStack = this.field_145900_a[p_70304_1_];
/*  93 */       this.field_145900_a[p_70304_1_] = null;
/*  94 */       return itemStack;
/*     */     } 
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/* 101 */     this.field_145900_a[p_70299_1_] = p_70299_2_;
/* 102 */     if (p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_()) p_70299_2_.field_77994_a = func_70297_j_();
/*     */   
/*     */   }
/*     */   
/*     */   public String func_145825_b() {
/* 107 */     return func_145818_k_() ? this.field_145902_i : "container.hopper";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 112 */     return (this.field_145902_i != null && this.field_145902_i.length() > 0);
/*     */   }
/*     */   
/*     */   public void func_145886_a(String p_145886_1_) {
/* 116 */     this.field_145902_i = p_145886_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 121 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 126 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) return false; 
/* 127 */     if (p_70300_1_.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) > 64.0D) return false; 
/* 128 */     return true;
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
/* 141 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 146 */     if (this.field_145850_b == null || this.field_145850_b.field_72995_K)
/*     */       return; 
/* 148 */     this.field_145901_j--;
/*     */     
/* 150 */     if (!func_145888_j()) {
/* 151 */       func_145896_c(0);
/* 152 */       func_145887_i();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_145887_i() {
/* 157 */     if (this.field_145850_b == null || this.field_145850_b.field_72995_K) return false;
/*     */     
/* 159 */     if (!func_145888_j() && BlockHopper.func_149917_c(func_145832_p())) {
/* 160 */       boolean bool = false;
/*     */       
/* 162 */       if (!func_152104_k()) {
/* 163 */         bool = func_145883_k();
/*     */       }
/* 165 */       if (!func_152105_l()) {
/* 166 */         bool = (func_145891_a(this) || bool);
/*     */       }
/*     */       
/* 169 */       if (bool) {
/* 170 */         func_145896_c(8);
/* 171 */         func_70296_d();
/* 172 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 176 */     return false;
/*     */   }
/*     */   
/*     */   private boolean func_152104_k() {
/* 180 */     for (ItemStack itemStack : this.field_145900_a) {
/* 181 */       if (itemStack != null) {
/* 182 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 186 */     return true;
/*     */   }
/*     */   
/*     */   private boolean func_152105_l() {
/* 190 */     for (ItemStack itemStack : this.field_145900_a) {
/* 191 */       if (itemStack == null || itemStack.field_77994_a != itemStack.func_77976_d()) {
/* 192 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 196 */     return true;
/*     */   }
/*     */   
/*     */   private boolean func_145883_k() {
/* 200 */     IInventory iInventory = func_145895_l();
/* 201 */     if (iInventory == null) {
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     int i = Facing.field_71588_a[BlockHopper.func_149918_b(func_145832_p())];
/* 206 */     if (func_152102_a(iInventory, i)) {
/* 207 */       return false;
/*     */     }
/*     */     
/* 210 */     for (byte b = 0; b < func_70302_i_(); b++) {
/* 211 */       if (func_70301_a(b) != null) {
/*     */         
/* 213 */         ItemStack itemStack1 = func_70301_a(b).func_77946_l();
/* 214 */         ItemStack itemStack2 = func_145889_a(iInventory, func_70298_a(b, 1), i);
/*     */         
/* 216 */         if (itemStack2 == null || itemStack2.field_77994_a == 0) {
/* 217 */           iInventory.func_70296_d();
/* 218 */           return true;
/*     */         } 
/* 220 */         func_70299_a(b, itemStack1);
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     return false;
/*     */   }
/*     */   
/*     */   private boolean func_152102_a(IInventory p_152102_1_, int p_152102_2_) {
/* 228 */     if (p_152102_1_ instanceof ISidedInventory && p_152102_2_ > -1) {
/* 229 */       ISidedInventory iSidedInventory = (ISidedInventory)p_152102_1_;
/* 230 */       int[] arrayOfInt = iSidedInventory.func_94128_d(p_152102_2_);
/*     */       
/* 232 */       for (byte b = 0; b < arrayOfInt.length; b++) {
/* 233 */         ItemStack itemStack = iSidedInventory.func_70301_a(arrayOfInt[b]);
/* 234 */         if (itemStack == null || itemStack.field_77994_a != itemStack.func_77976_d()) {
/* 235 */           return false;
/*     */         }
/*     */       } 
/*     */     } else {
/* 239 */       int i = p_152102_1_.func_70302_i_();
/* 240 */       for (byte b = 0; b < i; b++) {
/* 241 */         ItemStack itemStack = p_152102_1_.func_70301_a(b);
/* 242 */         if (itemStack == null || itemStack.field_77994_a != itemStack.func_77976_d()) {
/* 243 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 248 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean func_152103_b(IInventory p_152103_0_, int p_152103_1_) {
/* 253 */     if (p_152103_0_ instanceof ISidedInventory && p_152103_1_ > -1) {
/* 254 */       ISidedInventory iSidedInventory = (ISidedInventory)p_152103_0_;
/* 255 */       int[] arrayOfInt = iSidedInventory.func_94128_d(p_152103_1_);
/*     */       
/* 257 */       for (byte b = 0; b < arrayOfInt.length; b++) {
/* 258 */         if (iSidedInventory.func_70301_a(arrayOfInt[b]) != null) {
/* 259 */           return false;
/*     */         }
/*     */       } 
/*     */     } else {
/* 263 */       int i = p_152103_0_.func_70302_i_();
/* 264 */       for (byte b = 0; b < i; b++) {
/* 265 */         if (p_152103_0_.func_70301_a(b) != null) {
/* 266 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 270 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean func_145891_a(IHopper p_145891_0_) {
/* 274 */     IInventory iInventory = func_145884_b(p_145891_0_);
/*     */     
/* 276 */     if (iInventory != null) {
/* 277 */       byte b = 0;
/* 278 */       if (func_152103_b(iInventory, b)) {
/* 279 */         return false;
/*     */       }
/*     */       
/* 282 */       if (iInventory instanceof ISidedInventory && b > -1) {
/* 283 */         ISidedInventory iSidedInventory = (ISidedInventory)iInventory;
/* 284 */         int[] arrayOfInt = iSidedInventory.func_94128_d(b);
/*     */         
/* 286 */         for (byte b1 = 0; b1 < arrayOfInt.length; b1++) {
/* 287 */           if (func_145892_a(p_145891_0_, iInventory, arrayOfInt[b1], b)) return true; 
/*     */         } 
/*     */       } else {
/* 290 */         int i = iInventory.func_70302_i_();
/* 291 */         for (byte b1 = 0; b1 < i; b1++) {
/* 292 */           if (func_145892_a(p_145891_0_, iInventory, b1, b)) return true; 
/*     */         } 
/*     */       } 
/*     */     } else {
/* 296 */       EntityItem entityItem = func_145897_a(p_145891_0_.func_145831_w(), p_145891_0_.func_96107_aA(), p_145891_0_.func_96109_aB() + 1.0D, p_145891_0_.func_96108_aC());
/*     */       
/* 298 */       if (entityItem != null) {
/* 299 */         return func_145898_a(p_145891_0_, entityItem);
/*     */       }
/*     */     } 
/*     */     
/* 303 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean func_145892_a(IHopper p_145892_0_, IInventory p_145892_1_, int p_145892_2_, int p_145892_3_) {
/* 307 */     ItemStack itemStack = p_145892_1_.func_70301_a(p_145892_2_);
/*     */     
/* 309 */     if (itemStack != null && func_145890_b(p_145892_1_, itemStack, p_145892_2_, p_145892_3_)) {
/* 310 */       ItemStack itemStack1 = itemStack.func_77946_l();
/* 311 */       ItemStack itemStack2 = func_145889_a(p_145892_0_, p_145892_1_.func_70298_a(p_145892_2_, 1), -1);
/*     */       
/* 313 */       if (itemStack2 == null || itemStack2.field_77994_a == 0) {
/* 314 */         p_145892_1_.func_70296_d();
/* 315 */         return true;
/*     */       } 
/* 317 */       p_145892_1_.func_70299_a(p_145892_2_, itemStack1);
/*     */     } 
/*     */ 
/*     */     
/* 321 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean func_145898_a(IInventory p_145898_0_, EntityItem p_145898_1_) {
/* 325 */     boolean bool = false;
/* 326 */     if (p_145898_1_ == null) return false;
/*     */     
/* 328 */     ItemStack itemStack1 = p_145898_1_.func_92059_d().func_77946_l();
/* 329 */     ItemStack itemStack2 = func_145889_a(p_145898_0_, itemStack1, -1);
/*     */     
/* 331 */     if (itemStack2 == null || itemStack2.field_77994_a == 0) {
/* 332 */       bool = true;
/*     */       
/* 334 */       p_145898_1_.func_70106_y();
/*     */     } else {
/* 336 */       p_145898_1_.func_92058_a(itemStack2);
/*     */     } 
/*     */     
/* 339 */     return bool;
/*     */   }
/*     */   
/*     */   public static ItemStack func_145889_a(IInventory p_145889_0_, ItemStack p_145889_1_, int p_145889_2_) {
/* 343 */     if (p_145889_0_ instanceof ISidedInventory && p_145889_2_ > -1) {
/* 344 */       ISidedInventory iSidedInventory = (ISidedInventory)p_145889_0_;
/* 345 */       int[] arrayOfInt = iSidedInventory.func_94128_d(p_145889_2_);
/*     */       
/* 347 */       for (byte b = 0; b < arrayOfInt.length && p_145889_1_ != null && p_145889_1_.field_77994_a > 0; b++) {
/* 348 */         p_145889_1_ = func_145899_c(p_145889_0_, p_145889_1_, arrayOfInt[b], p_145889_2_);
/*     */       }
/*     */     } else {
/* 351 */       int i = p_145889_0_.func_70302_i_();
/* 352 */       for (byte b = 0; b < i && p_145889_1_ != null && p_145889_1_.field_77994_a > 0; b++) {
/* 353 */         p_145889_1_ = func_145899_c(p_145889_0_, p_145889_1_, b, p_145889_2_);
/*     */       }
/*     */     } 
/*     */     
/* 357 */     if (p_145889_1_ != null && p_145889_1_.field_77994_a == 0) {
/* 358 */       p_145889_1_ = null;
/*     */     }
/*     */     
/* 361 */     return p_145889_1_;
/*     */   }
/*     */   
/*     */   private static boolean func_145885_a(IInventory p_145885_0_, ItemStack p_145885_1_, int p_145885_2_, int p_145885_3_) {
/* 365 */     if (!p_145885_0_.func_94041_b(p_145885_2_, p_145885_1_)) return false; 
/* 366 */     if (p_145885_0_ instanceof ISidedInventory && !((ISidedInventory)p_145885_0_).func_102007_a(p_145885_2_, p_145885_1_, p_145885_3_)) return false; 
/* 367 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean func_145890_b(IInventory p_145890_0_, ItemStack p_145890_1_, int p_145890_2_, int p_145890_3_) {
/* 371 */     if (p_145890_0_ instanceof ISidedInventory && !((ISidedInventory)p_145890_0_).func_102008_b(p_145890_2_, p_145890_1_, p_145890_3_)) return false; 
/* 372 */     return true;
/*     */   }
/*     */   
/*     */   private static ItemStack func_145899_c(IInventory p_145899_0_, ItemStack p_145899_1_, int p_145899_2_, int p_145899_3_) {
/* 376 */     ItemStack itemStack = p_145899_0_.func_70301_a(p_145899_2_);
/*     */     
/* 378 */     if (func_145885_a(p_145899_0_, p_145899_1_, p_145899_2_, p_145899_3_)) {
/* 379 */       boolean bool = false;
/* 380 */       if (itemStack == null) {
/* 381 */         p_145899_0_.func_70299_a(p_145899_2_, p_145899_1_);
/* 382 */         p_145899_1_ = null;
/* 383 */         bool = true;
/* 384 */       } else if (func_145894_a(itemStack, p_145899_1_)) {
/* 385 */         int i = p_145899_1_.func_77976_d() - itemStack.field_77994_a;
/* 386 */         int j = Math.min(p_145899_1_.field_77994_a, i);
/*     */         
/* 388 */         p_145899_1_.field_77994_a -= j;
/* 389 */         itemStack.field_77994_a += j;
/* 390 */         bool = (j > 0) ? true : false;
/*     */       } 
/* 392 */       if (bool) {
/* 393 */         if (p_145899_0_ instanceof TileEntityHopper) {
/* 394 */           ((TileEntityHopper)p_145899_0_).func_145896_c(8);
/* 395 */           p_145899_0_.func_70296_d();
/*     */         } 
/* 397 */         p_145899_0_.func_70296_d();
/*     */       } 
/*     */     } 
/* 400 */     return p_145899_1_;
/*     */   }
/*     */   
/*     */   private IInventory func_145895_l() {
/* 404 */     int i = BlockHopper.func_149918_b(func_145832_p());
/* 405 */     return func_145893_b(func_145831_w(), (this.field_145851_c + Facing.field_71586_b[i]), (this.field_145848_d + Facing.field_71587_c[i]), (this.field_145849_e + Facing.field_71585_d[i]));
/*     */   }
/*     */   
/*     */   public static IInventory func_145884_b(IHopper p_145884_0_) {
/* 409 */     return func_145893_b(p_145884_0_.func_145831_w(), p_145884_0_.func_96107_aA(), p_145884_0_.func_96109_aB() + 1.0D, p_145884_0_.func_96108_aC());
/*     */   }
/*     */   
/*     */   public static EntityItem func_145897_a(World p_145897_0_, double p_145897_1_, double p_145897_3_, double p_145897_5_) {
/* 413 */     List<EntityItem> list = p_145897_0_.func_82733_a(EntityItem.class, AxisAlignedBB.func_72330_a(p_145897_1_, p_145897_3_, p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 1.0D, p_145897_5_ + 1.0D), IEntitySelector.field_94557_a);
/*     */     
/* 415 */     if (list.size() > 0) {
/* 416 */       return list.get(0);
/*     */     }
/* 418 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static IInventory func_145893_b(World p_145893_0_, double p_145893_1_, double p_145893_3_, double p_145893_5_) {
/* 423 */     IInventory iInventory = null;
/* 424 */     int i = MathHelper.func_76128_c(p_145893_1_);
/* 425 */     int j = MathHelper.func_76128_c(p_145893_3_);
/* 426 */     int k = MathHelper.func_76128_c(p_145893_5_);
/*     */     
/* 428 */     TileEntity tileEntity = p_145893_0_.func_147438_o(i, j, k);
/*     */     
/* 430 */     if (tileEntity != null && tileEntity instanceof IInventory) {
/* 431 */       iInventory = (IInventory)tileEntity;
/*     */       
/* 433 */       if (iInventory instanceof TileEntityChest) {
/* 434 */         Block block = p_145893_0_.func_147439_a(i, j, k);
/*     */         
/* 436 */         if (block instanceof BlockChest) {
/* 437 */           iInventory = ((BlockChest)block).func_149951_m(p_145893_0_, i, j, k);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 442 */     if (iInventory == null) {
/* 443 */       List<IInventory> list = p_145893_0_.func_94576_a(null, AxisAlignedBB.func_72330_a(p_145893_1_, p_145893_3_, p_145893_5_, p_145893_1_ + 1.0D, p_145893_3_ + 1.0D, p_145893_5_ + 1.0D), IEntitySelector.field_96566_b);
/*     */       
/* 445 */       if (list != null && list.size() > 0) {
/* 446 */         iInventory = list.get(p_145893_0_.field_73012_v.nextInt(list.size()));
/*     */       }
/*     */     } 
/*     */     
/* 450 */     return iInventory;
/*     */   }
/*     */   
/*     */   private static boolean func_145894_a(ItemStack p_145894_0_, ItemStack p_145894_1_) {
/* 454 */     if (p_145894_0_.func_77973_b() != p_145894_1_.func_77973_b()) return false; 
/* 455 */     if (p_145894_0_.func_77960_j() != p_145894_1_.func_77960_j()) return false; 
/* 456 */     if (p_145894_0_.field_77994_a > p_145894_0_.func_77976_d()) return false; 
/* 457 */     if (!ItemStack.func_77970_a(p_145894_0_, p_145894_1_)) return false; 
/* 458 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96107_aA() {
/* 463 */     return this.field_145851_c;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96109_aB() {
/* 468 */     return this.field_145848_d;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96108_aC() {
/* 473 */     return this.field_145849_e;
/*     */   }
/*     */   
/*     */   public void func_145896_c(int p_145896_1_) {
/* 477 */     this.field_145901_j = p_145896_1_;
/*     */   }
/*     */   
/*     */   public boolean func_145888_j() {
/* 481 */     return (this.field_145901_j > 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */