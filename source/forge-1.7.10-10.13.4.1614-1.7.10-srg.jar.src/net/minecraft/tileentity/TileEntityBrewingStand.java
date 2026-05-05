/*     */ package net.minecraft.tileentity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemPotion;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.potion.PotionHelper;
/*     */ 
/*     */ public class TileEntityBrewingStand extends TileEntity implements ISidedInventory {
/*  16 */   private static final int[] field_145941_a = new int[] { 3 };
/*     */ 
/*     */   
/*  19 */   private static final int[] field_145947_i = new int[] { 0, 1, 2 };
/*     */ 
/*     */ 
/*     */   
/*  23 */   private ItemStack[] field_145945_j = new ItemStack[4];
/*     */   
/*     */   private int field_145946_k;
/*     */   private int field_145943_l;
/*     */   private Item field_145944_m;
/*     */   private String field_145942_n;
/*     */   private static final String __OBFID = "CL_00000345";
/*     */   
/*     */   public String func_145825_b() {
/*  32 */     return func_145818_k_() ? this.field_145942_n : "container.brewing";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/*  37 */     return (this.field_145942_n != null && this.field_145942_n.length() > 0);
/*     */   }
/*     */   
/*     */   public void func_145937_a(String p_145937_1_) {
/*  41 */     this.field_145942_n = p_145937_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  46 */     return this.field_145945_j.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  51 */     if (this.field_145946_k > 0) {
/*  52 */       this.field_145946_k--;
/*     */       
/*  54 */       if (this.field_145946_k == 0) {
/*     */         
/*  56 */         func_145940_l();
/*  57 */         func_70296_d();
/*  58 */       } else if (!func_145934_k()) {
/*  59 */         this.field_145946_k = 0;
/*  60 */         func_70296_d();
/*  61 */       } else if (this.field_145944_m != this.field_145945_j[3].func_77973_b()) {
/*  62 */         this.field_145946_k = 0;
/*  63 */         func_70296_d();
/*     */       } 
/*  65 */     } else if (func_145934_k()) {
/*  66 */       this.field_145946_k = 400;
/*  67 */       this.field_145944_m = this.field_145945_j[3].func_77973_b();
/*     */     } 
/*     */     
/*  70 */     int i = func_145939_j();
/*  71 */     if (i != this.field_145943_l) {
/*  72 */       this.field_145943_l = i;
/*  73 */       this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, i, 2);
/*     */     } 
/*     */     
/*  76 */     super.func_145845_h();
/*     */   }
/*     */   
/*     */   public int func_145935_i() {
/*  80 */     return this.field_145946_k;
/*     */   }
/*     */   
/*     */   private boolean func_145934_k() {
/*  84 */     if (this.field_145945_j[3] == null || (this.field_145945_j[3]).field_77994_a <= 0) {
/*  85 */       return false;
/*     */     }
/*  87 */     ItemStack itemStack = this.field_145945_j[3];
/*     */ 
/*     */     
/*  90 */     if (!itemStack.func_77973_b().func_150892_m(itemStack)) {
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     boolean bool = false;
/*  95 */     for (byte b = 0; b < 3; b++) {
/*  96 */       if (this.field_145945_j[b] != null && this.field_145945_j[b].func_77973_b() == Items.field_151068_bn) {
/*  97 */         int i = this.field_145945_j[b].func_77960_j();
/*  98 */         int j = func_145936_c(i, itemStack);
/*     */         
/* 100 */         if (!ItemPotion.func_77831_g(i) && ItemPotion.func_77831_g(j)) {
/* 101 */           bool = true;
/*     */           
/*     */           break;
/*     */         } 
/* 105 */         List list1 = Items.field_151068_bn.func_77834_f(i);
/* 106 */         List list2 = Items.field_151068_bn.func_77834_f(j);
/*     */         
/* 108 */         if ((i <= 0 || list1 != list2) && (list1 == null || (!list1.equals(list2) && list2 != null)))
/*     */         {
/* 110 */           if (i != j) {
/* 111 */             bool = true;
/*     */             break;
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 116 */     return bool;
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
/*     */   private void func_145940_l() {
/* 144 */     if (!func_145934_k()) {
/*     */       return;
/*     */     }
/*     */     
/* 148 */     ItemStack itemStack = this.field_145945_j[3];
/*     */ 
/*     */ 
/*     */     
/* 152 */     for (byte b = 0; b < 3; b++) {
/* 153 */       if (this.field_145945_j[b] != null && this.field_145945_j[b].func_77973_b() == Items.field_151068_bn) {
/* 154 */         int i = this.field_145945_j[b].func_77960_j();
/* 155 */         int j = func_145936_c(i, itemStack);
/*     */         
/* 157 */         List list1 = Items.field_151068_bn.func_77834_f(i);
/* 158 */         List list2 = Items.field_151068_bn.func_77834_f(j);
/*     */         
/* 160 */         if ((i > 0 && list1 == list2) || (list1 != null && (list1.equals(list2) || list2 == null))) {
/*     */           
/* 162 */           if (!ItemPotion.func_77831_g(i) && ItemPotion.func_77831_g(j)) {
/* 163 */             this.field_145945_j[b].func_77964_b(j);
/*     */           }
/*     */         }
/* 166 */         else if (i != j) {
/* 167 */           this.field_145945_j[b].func_77964_b(j);
/*     */         } 
/*     */       } 
/*     */     } 
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
/* 188 */     if (itemStack.func_77973_b().func_77634_r()) {
/* 189 */       this.field_145945_j[3] = new ItemStack(itemStack.func_77973_b().func_77668_q());
/*     */     } else {
/* 191 */       (this.field_145945_j[3]).field_77994_a--;
/* 192 */       if ((this.field_145945_j[3]).field_77994_a <= 0) {
/* 193 */         this.field_145945_j[3] = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private int func_145936_c(int p_145936_1_, ItemStack p_145936_2_) {
/* 199 */     if (p_145936_2_ == null) {
/* 200 */       return p_145936_1_;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 210 */     if (p_145936_2_.func_77973_b().func_150892_m(p_145936_2_)) {
/* 211 */       return PotionHelper.func_77913_a(p_145936_1_, p_145936_2_.func_77973_b().func_150896_i(p_145936_2_));
/*     */     }
/* 213 */     return p_145936_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 219 */     super.func_145839_a(p_145839_1_);
/*     */     
/* 221 */     NBTTagList nBTTagList = p_145839_1_.func_150295_c("Items", 10);
/* 222 */     this.field_145945_j = new ItemStack[func_70302_i_()];
/* 223 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 224 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/* 225 */       byte b1 = nBTTagCompound.func_74771_c("Slot");
/* 226 */       if (b1 >= 0 && b1 < this.field_145945_j.length) this.field_145945_j[b1] = ItemStack.func_77949_a(nBTTagCompound);
/*     */     
/*     */     } 
/* 229 */     this.field_145946_k = p_145839_1_.func_74765_d("BrewTime");
/* 230 */     if (p_145839_1_.func_150297_b("CustomName", 8)) this.field_145942_n = p_145839_1_.func_74779_i("CustomName");
/*     */   
/*     */   }
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 235 */     super.func_145841_b(p_145841_1_);
/*     */     
/* 237 */     p_145841_1_.func_74777_a("BrewTime", (short)this.field_145946_k);
/* 238 */     NBTTagList nBTTagList = new NBTTagList();
/*     */     
/* 240 */     for (byte b = 0; b < this.field_145945_j.length; b++) {
/* 241 */       if (this.field_145945_j[b] != null) {
/* 242 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 243 */         nBTTagCompound.func_74774_a("Slot", (byte)b);
/* 244 */         this.field_145945_j[b].func_77955_b(nBTTagCompound);
/* 245 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/*     */     } 
/* 248 */     p_145841_1_.func_74782_a("Items", (NBTBase)nBTTagList);
/* 249 */     if (func_145818_k_()) p_145841_1_.func_74778_a("CustomName", this.field_145942_n);
/*     */   
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/* 254 */     if (p_70301_1_ >= 0 && p_70301_1_ < this.field_145945_j.length) {
/* 255 */       return this.field_145945_j[p_70301_1_];
/*     */     }
/* 257 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/* 262 */     if (p_70298_1_ >= 0 && p_70298_1_ < this.field_145945_j.length) {
/* 263 */       ItemStack itemStack = this.field_145945_j[p_70298_1_];
/* 264 */       this.field_145945_j[p_70298_1_] = null;
/* 265 */       return itemStack;
/*     */     } 
/* 267 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/* 272 */     if (p_70304_1_ >= 0 && p_70304_1_ < this.field_145945_j.length) {
/* 273 */       ItemStack itemStack = this.field_145945_j[p_70304_1_];
/* 274 */       this.field_145945_j[p_70304_1_] = null;
/* 275 */       return itemStack;
/*     */     } 
/* 277 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/* 282 */     if (p_70299_1_ >= 0 && p_70299_1_ < this.field_145945_j.length) {
/* 283 */       this.field_145945_j[p_70299_1_] = p_70299_2_;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 290 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 295 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) return false; 
/* 296 */     if (p_70300_1_.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) > 64.0D) return false; 
/* 297 */     return true;
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
/* 310 */     if (p_94041_1_ == 3)
/*     */     {
/* 312 */       return p_94041_2_.func_77973_b().func_150892_m(p_94041_2_);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 318 */     return (p_94041_2_.func_77973_b() == Items.field_151068_bn || p_94041_2_.func_77973_b() == Items.field_151069_bo);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_145938_d(int p_145938_1_) {
/* 322 */     this.field_145946_k = p_145938_1_;
/*     */   }
/*     */   
/*     */   public int func_145939_j() {
/* 326 */     int i = 0;
/* 327 */     for (byte b = 0; b < 3; b++) {
/* 328 */       if (this.field_145945_j[b] != null) {
/* 329 */         i |= 1 << b;
/*     */       }
/*     */     } 
/* 332 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] func_94128_d(int p_94128_1_) {
/* 337 */     if (p_94128_1_ == 1) {
/* 338 */       return field_145941_a;
/*     */     }
/*     */     
/* 341 */     return field_145947_i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_102007_a(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
/* 346 */     return func_94041_b(p_102007_1_, p_102007_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_102008_b(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
/* 351 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityBrewingStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */