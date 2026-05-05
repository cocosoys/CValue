/*     */ package net.minecraft.tileentity;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockChest;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryLargeChest;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class TileEntityChest extends TileEntity implements IInventory {
/*  15 */   private ItemStack[] field_145985_p = new ItemStack[36];
/*     */   
/*     */   public boolean field_145984_a;
/*     */   public TileEntityChest field_145992_i;
/*     */   public TileEntityChest field_145990_j;
/*     */   public TileEntityChest field_145991_k;
/*     */   public TileEntityChest field_145988_l;
/*     */   public float field_145989_m;
/*     */   public float field_145986_n;
/*     */   public int field_145987_o;
/*     */   private int field_145983_q;
/*     */   private int field_145982_r;
/*     */   private String field_145981_s;
/*     */   private static final String __OBFID = "CL_00000346";
/*     */   
/*     */   public TileEntityChest() {
/*  31 */     this.field_145982_r = -1;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public TileEntityChest(int p_i2350_1_) {
/*  36 */     this.field_145982_r = p_i2350_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  41 */     return 27;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/*  46 */     return this.field_145985_p[p_70301_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/*  51 */     if (this.field_145985_p[p_70298_1_] != null) {
/*  52 */       if ((this.field_145985_p[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*  53 */         ItemStack itemStack1 = this.field_145985_p[p_70298_1_];
/*  54 */         this.field_145985_p[p_70298_1_] = null;
/*  55 */         func_70296_d();
/*  56 */         return itemStack1;
/*     */       } 
/*  58 */       ItemStack itemStack = this.field_145985_p[p_70298_1_].func_77979_a(p_70298_2_);
/*  59 */       if ((this.field_145985_p[p_70298_1_]).field_77994_a == 0) this.field_145985_p[p_70298_1_] = null; 
/*  60 */       func_70296_d();
/*  61 */       return itemStack;
/*     */     } 
/*     */     
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/*  69 */     if (this.field_145985_p[p_70304_1_] != null) {
/*  70 */       ItemStack itemStack = this.field_145985_p[p_70304_1_];
/*  71 */       this.field_145985_p[p_70304_1_] = null;
/*  72 */       return itemStack;
/*     */     } 
/*  74 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/*  79 */     this.field_145985_p[p_70299_1_] = p_70299_2_;
/*  80 */     if (p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_()) p_70299_2_.field_77994_a = func_70297_j_(); 
/*  81 */     func_70296_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/*  86 */     return func_145818_k_() ? this.field_145981_s : "container.chest";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/*  91 */     return (this.field_145981_s != null && this.field_145981_s.length() > 0);
/*     */   }
/*     */   
/*     */   public void func_145976_a(String p_145976_1_) {
/*  95 */     this.field_145981_s = p_145976_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 101 */     super.func_145839_a(p_145839_1_);
/* 102 */     NBTTagList nBTTagList = p_145839_1_.func_150295_c("Items", 10);
/* 103 */     this.field_145985_p = new ItemStack[func_70302_i_()];
/* 104 */     if (p_145839_1_.func_150297_b("CustomName", 8)) this.field_145981_s = p_145839_1_.func_74779_i("CustomName"); 
/* 105 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 106 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/* 107 */       int i = nBTTagCompound.func_74771_c("Slot") & 0xFF;
/* 108 */       if (i >= 0 && i < this.field_145985_p.length) this.field_145985_p[i] = ItemStack.func_77949_a(nBTTagCompound);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 114 */     super.func_145841_b(p_145841_1_);
/* 115 */     NBTTagList nBTTagList = new NBTTagList();
/*     */     
/* 117 */     for (byte b = 0; b < this.field_145985_p.length; b++) {
/* 118 */       if (this.field_145985_p[b] != null) {
/* 119 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 120 */         nBTTagCompound.func_74774_a("Slot", (byte)b);
/* 121 */         this.field_145985_p[b].func_77955_b(nBTTagCompound);
/* 122 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/*     */     } 
/* 125 */     p_145841_1_.func_74782_a("Items", (NBTBase)nBTTagList);
/* 126 */     if (func_145818_k_()) p_145841_1_.func_74778_a("CustomName", this.field_145981_s);
/*     */   
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 131 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 136 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) return false; 
/* 137 */     if (p_70300_1_.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) > 64.0D) return false; 
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145836_u() {
/* 143 */     super.func_145836_u();
/* 144 */     this.field_145984_a = false;
/*     */   }
/*     */   
/*     */   private void func_145978_a(TileEntityChest p_145978_1_, int p_145978_2_) {
/* 148 */     if (p_145978_1_.func_145837_r()) {
/* 149 */       this.field_145984_a = false;
/* 150 */     } else if (this.field_145984_a) {
/* 151 */       switch (p_145978_2_) {
/*     */         case 2:
/* 153 */           if (this.field_145992_i != p_145978_1_) this.field_145984_a = false; 
/*     */           break;
/*     */         case 0:
/* 156 */           if (this.field_145988_l != p_145978_1_) this.field_145984_a = false; 
/*     */           break;
/*     */         case 3:
/* 159 */           if (this.field_145990_j != p_145978_1_) this.field_145984_a = false; 
/*     */           break;
/*     */         case 1:
/* 162 */           if (this.field_145991_k != p_145978_1_) this.field_145984_a = false; 
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_145979_i() {
/* 169 */     if (this.field_145984_a)
/*     */       return; 
/* 171 */     this.field_145984_a = true;
/* 172 */     this.field_145992_i = null;
/* 173 */     this.field_145990_j = null;
/* 174 */     this.field_145991_k = null;
/* 175 */     this.field_145988_l = null;
/*     */     
/* 177 */     if (func_145977_a(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e)) {
/* 178 */       this.field_145991_k = (TileEntityChest)this.field_145850_b.func_147438_o(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
/*     */     }
/* 180 */     if (func_145977_a(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e)) {
/* 181 */       this.field_145990_j = (TileEntityChest)this.field_145850_b.func_147438_o(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/*     */     }
/* 183 */     if (func_145977_a(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1)) {
/* 184 */       this.field_145992_i = (TileEntityChest)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
/*     */     }
/* 186 */     if (func_145977_a(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1)) {
/* 187 */       this.field_145988_l = (TileEntityChest)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/*     */     }
/*     */     
/* 190 */     if (this.field_145992_i != null) this.field_145992_i.func_145978_a(this, 0); 
/* 191 */     if (this.field_145988_l != null) this.field_145988_l.func_145978_a(this, 2); 
/* 192 */     if (this.field_145990_j != null) this.field_145990_j.func_145978_a(this, 1); 
/* 193 */     if (this.field_145991_k != null) this.field_145991_k.func_145978_a(this, 3); 
/*     */   }
/*     */   
/*     */   private boolean func_145977_a(int p_145977_1_, int p_145977_2_, int p_145977_3_) {
/* 197 */     if (this.field_145850_b == null) {
/* 198 */       return false;
/*     */     }
/* 200 */     Block block = this.field_145850_b.func_147439_a(p_145977_1_, p_145977_2_, p_145977_3_);
/* 201 */     return (block instanceof BlockChest && ((BlockChest)block).field_149956_a == func_145980_j());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 206 */     super.func_145845_h();
/* 207 */     func_145979_i();
/*     */     
/* 209 */     this.field_145983_q++;
/* 210 */     if (!this.field_145850_b.field_72995_K && this.field_145987_o != 0 && (this.field_145983_q + this.field_145851_c + this.field_145848_d + this.field_145849_e) % 200 == 0) {
/*     */       
/* 212 */       this.field_145987_o = 0;
/*     */       
/* 214 */       float f1 = 5.0F;
/* 215 */       List list = this.field_145850_b.func_72872_a(EntityPlayer.class, AxisAlignedBB.func_72330_a((this.field_145851_c - f1), (this.field_145848_d - f1), (this.field_145849_e - f1), ((this.field_145851_c + 1) + f1), ((this.field_145848_d + 1) + f1), ((this.field_145849_e + 1) + f1)));
/* 216 */       for (EntityPlayer entityPlayer : list) {
/* 217 */         if (entityPlayer.field_71070_bA instanceof ContainerChest) {
/* 218 */           IInventory iInventory = ((ContainerChest)entityPlayer.field_71070_bA).func_85151_d();
/* 219 */           if (iInventory == this || (iInventory instanceof InventoryLargeChest && ((InventoryLargeChest)iInventory).func_90010_a(this))) {
/* 220 */             this.field_145987_o++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 226 */     this.field_145986_n = this.field_145989_m;
/*     */     
/* 228 */     float f = 0.1F;
/* 229 */     if (this.field_145987_o > 0 && this.field_145989_m == 0.0F && 
/* 230 */       this.field_145992_i == null && this.field_145991_k == null) {
/* 231 */       double d1 = this.field_145851_c + 0.5D;
/* 232 */       double d2 = this.field_145849_e + 0.5D;
/* 233 */       if (this.field_145988_l != null) d2 += 0.5D; 
/* 234 */       if (this.field_145990_j != null) d1 += 0.5D;
/*     */       
/* 236 */       this.field_145850_b.func_72908_a(d1, this.field_145848_d + 0.5D, d2, "random.chestopen", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */     } 
/*     */     
/* 239 */     if ((this.field_145987_o == 0 && this.field_145989_m > 0.0F) || (this.field_145987_o > 0 && this.field_145989_m < 1.0F)) {
/* 240 */       float f1 = this.field_145989_m;
/* 241 */       if (this.field_145987_o > 0) { this.field_145989_m += f; }
/* 242 */       else { this.field_145989_m -= f; }
/* 243 */        if (this.field_145989_m > 1.0F) {
/* 244 */         this.field_145989_m = 1.0F;
/*     */       }
/* 246 */       float f2 = 0.5F;
/* 247 */       if (this.field_145989_m < f2 && f1 >= f2 && 
/* 248 */         this.field_145992_i == null && this.field_145991_k == null) {
/* 249 */         double d1 = this.field_145851_c + 0.5D;
/* 250 */         double d2 = this.field_145849_e + 0.5D;
/* 251 */         if (this.field_145988_l != null) d2 += 0.5D; 
/* 252 */         if (this.field_145990_j != null) d1 += 0.5D;
/*     */         
/* 254 */         this.field_145850_b.func_72908_a(d1, this.field_145848_d + 0.5D, d2, "random.chestclosed", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/*     */       
/* 257 */       if (this.field_145989_m < 0.0F) {
/* 258 */         this.field_145989_m = 0.0F;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
/* 265 */     if (p_145842_1_ == 1) {
/* 266 */       this.field_145987_o = p_145842_2_;
/* 267 */       return true;
/*     */     } 
/* 269 */     return super.func_145842_c(p_145842_1_, p_145842_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {
/* 274 */     if (this.field_145987_o < 0) {
/* 275 */       this.field_145987_o = 0;
/*     */     }
/* 277 */     this.field_145987_o++;
/* 278 */     this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, func_145838_q(), 1, this.field_145987_o);
/* 279 */     this.field_145850_b.func_147459_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, func_145838_q());
/* 280 */     this.field_145850_b.func_147459_d(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e, func_145838_q());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70305_f() {
/* 285 */     if (func_145838_q() instanceof BlockChest) {
/* 286 */       this.field_145987_o--;
/* 287 */       this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, func_145838_q(), 1, this.field_145987_o);
/* 288 */       this.field_145850_b.func_147459_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, func_145838_q());
/* 289 */       this.field_145850_b.func_147459_d(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e, func_145838_q());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
/* 295 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145843_s() {
/* 300 */     super.func_145843_s();
/* 301 */     func_145836_u();
/* 302 */     func_145979_i();
/*     */   }
/*     */   
/*     */   public int func_145980_j() {
/* 306 */     if (this.field_145982_r == -1) {
/* 307 */       if (this.field_145850_b != null && func_145838_q() instanceof BlockChest) {
/* 308 */         this.field_145982_r = ((BlockChest)func_145838_q()).field_149956_a;
/*     */       } else {
/* 310 */         return 0;
/*     */       } 
/*     */     }
/*     */     
/* 314 */     return this.field_145982_r;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */