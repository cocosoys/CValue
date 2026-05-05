/*     */ package net.minecraft.tileentity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class TileEntityFurnace extends TileEntity implements ISidedInventory {
/*  16 */   private static final int[] field_145962_k = new int[] { 0 };
/*     */ 
/*     */   
/*  19 */   private static final int[] field_145959_l = new int[] { 2, 1 };
/*     */ 
/*     */   
/*  22 */   private static final int[] field_145960_m = new int[] { 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  28 */   private ItemStack[] field_145957_n = new ItemStack[3];
/*     */   public int field_145956_a;
/*     */   public int field_145963_i;
/*     */   public int field_145961_j;
/*     */   private String field_145958_o;
/*     */   private static final String __OBFID = "CL_00000357";
/*     */   
/*     */   public int func_70302_i_() {
/*  36 */     return this.field_145957_n.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/*  41 */     return this.field_145957_n[p_70301_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/*  46 */     if (this.field_145957_n[p_70298_1_] != null) {
/*  47 */       if ((this.field_145957_n[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*  48 */         ItemStack itemStack1 = this.field_145957_n[p_70298_1_];
/*  49 */         this.field_145957_n[p_70298_1_] = null;
/*  50 */         return itemStack1;
/*     */       } 
/*  52 */       ItemStack itemStack = this.field_145957_n[p_70298_1_].func_77979_a(p_70298_2_);
/*  53 */       if ((this.field_145957_n[p_70298_1_]).field_77994_a == 0) this.field_145957_n[p_70298_1_] = null; 
/*  54 */       return itemStack;
/*     */     } 
/*     */     
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/*  62 */     if (this.field_145957_n[p_70304_1_] != null) {
/*  63 */       ItemStack itemStack = this.field_145957_n[p_70304_1_];
/*  64 */       this.field_145957_n[p_70304_1_] = null;
/*  65 */       return itemStack;
/*     */     } 
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/*  72 */     this.field_145957_n[p_70299_1_] = p_70299_2_;
/*  73 */     if (p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_()) p_70299_2_.field_77994_a = func_70297_j_();
/*     */   
/*     */   }
/*     */   
/*     */   public String func_145825_b() {
/*  78 */     return func_145818_k_() ? this.field_145958_o : "container.furnace";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/*  83 */     return (this.field_145958_o != null && this.field_145958_o.length() > 0);
/*     */   }
/*     */   
/*     */   public void func_145951_a(String p_145951_1_) {
/*  87 */     this.field_145958_o = p_145951_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/*  93 */     super.func_145839_a(p_145839_1_);
/*  94 */     NBTTagList nBTTagList = p_145839_1_.func_150295_c("Items", 10);
/*  95 */     this.field_145957_n = new ItemStack[func_70302_i_()];
/*  96 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  97 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/*  98 */       byte b1 = nBTTagCompound.func_74771_c("Slot");
/*  99 */       if (b1 >= 0 && b1 < this.field_145957_n.length) this.field_145957_n[b1] = ItemStack.func_77949_a(nBTTagCompound);
/*     */     
/*     */     } 
/* 102 */     this.field_145956_a = p_145839_1_.func_74765_d("BurnTime");
/* 103 */     this.field_145961_j = p_145839_1_.func_74765_d("CookTime");
/* 104 */     this.field_145963_i = func_145952_a(this.field_145957_n[1]);
/* 105 */     if (p_145839_1_.func_150297_b("CustomName", 8)) this.field_145958_o = p_145839_1_.func_74779_i("CustomName");
/*     */   
/*     */   }
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 110 */     super.func_145841_b(p_145841_1_);
/* 111 */     p_145841_1_.func_74777_a("BurnTime", (short)this.field_145956_a);
/* 112 */     p_145841_1_.func_74777_a("CookTime", (short)this.field_145961_j);
/* 113 */     NBTTagList nBTTagList = new NBTTagList();
/*     */     
/* 115 */     for (byte b = 0; b < this.field_145957_n.length; b++) {
/* 116 */       if (this.field_145957_n[b] != null) {
/* 117 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 118 */         nBTTagCompound.func_74774_a("Slot", (byte)b);
/* 119 */         this.field_145957_n[b].func_77955_b(nBTTagCompound);
/* 120 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/*     */     } 
/* 123 */     p_145841_1_.func_74782_a("Items", (NBTBase)nBTTagList);
/* 124 */     if (func_145818_k_()) p_145841_1_.func_74778_a("CustomName", this.field_145958_o);
/*     */   
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 129 */     return 64;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_145953_d(int p_145953_1_) {
/* 133 */     return this.field_145961_j * p_145953_1_ / 200;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_145955_e(int p_145955_1_) {
/* 137 */     if (this.field_145963_i == 0) this.field_145963_i = 200; 
/* 138 */     return this.field_145956_a * p_145955_1_ / this.field_145963_i;
/*     */   }
/*     */   
/*     */   public boolean func_145950_i() {
/* 142 */     return (this.field_145956_a > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 147 */     boolean bool1 = (this.field_145956_a > 0) ? true : false;
/* 148 */     boolean bool2 = false;
/* 149 */     if (this.field_145956_a > 0) {
/* 150 */       this.field_145956_a--;
/*     */     }
/*     */     
/* 153 */     if (!this.field_145850_b.field_72995_K) {
/* 154 */       if (this.field_145956_a != 0 || (this.field_145957_n[1] != null && this.field_145957_n[0] != null)) {
/* 155 */         if (this.field_145956_a == 0 && func_145948_k()) {
/* 156 */           this.field_145963_i = this.field_145956_a = func_145952_a(this.field_145957_n[1]);
/* 157 */           if (this.field_145956_a > 0) {
/* 158 */             bool2 = true;
/* 159 */             if (this.field_145957_n[1] != null) {
/* 160 */               (this.field_145957_n[1]).field_77994_a--;
/* 161 */               if ((this.field_145957_n[1]).field_77994_a == 0) {
/* 162 */                 Item item = this.field_145957_n[1].func_77973_b().func_77668_q();
/* 163 */                 this.field_145957_n[1] = (item != null) ? new ItemStack(item) : null;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 169 */         if (func_145950_i() && func_145948_k()) {
/* 170 */           this.field_145961_j++;
/* 171 */           if (this.field_145961_j == 200) {
/* 172 */             this.field_145961_j = 0;
/* 173 */             func_145949_j();
/* 174 */             bool2 = true;
/*     */           } 
/*     */         } else {
/* 177 */           this.field_145961_j = 0;
/*     */         } 
/*     */       } 
/*     */       
/* 181 */       if (bool1 != ((this.field_145956_a > 0) ? true : false)) {
/* 182 */         bool2 = true;
/* 183 */         BlockFurnace.func_149931_a((this.field_145956_a > 0), this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     if (bool2) func_70296_d(); 
/*     */   }
/*     */   
/*     */   private boolean func_145948_k() {
/* 191 */     if (this.field_145957_n[0] == null) return false; 
/* 192 */     ItemStack itemStack = FurnaceRecipes.func_77602_a().func_151395_a(this.field_145957_n[0]);
/* 193 */     if (itemStack == null) return false; 
/* 194 */     if (this.field_145957_n[2] == null) return true; 
/* 195 */     if (!this.field_145957_n[2].func_77969_a(itemStack)) return false; 
/* 196 */     if ((this.field_145957_n[2]).field_77994_a < func_70297_j_() && (this.field_145957_n[2]).field_77994_a < this.field_145957_n[2].func_77976_d()) return true; 
/* 197 */     if ((this.field_145957_n[2]).field_77994_a < itemStack.func_77976_d()) return true; 
/* 198 */     return false;
/*     */   }
/*     */   
/*     */   public void func_145949_j() {
/* 202 */     if (!func_145948_k())
/*     */       return; 
/* 204 */     ItemStack itemStack = FurnaceRecipes.func_77602_a().func_151395_a(this.field_145957_n[0]);
/* 205 */     if (this.field_145957_n[2] == null) { this.field_145957_n[2] = itemStack.func_77946_l(); }
/* 206 */     else if (this.field_145957_n[2].func_77973_b() == itemStack.func_77973_b()) { (this.field_145957_n[2]).field_77994_a++; }
/*     */     
/* 208 */     (this.field_145957_n[0]).field_77994_a--;
/* 209 */     if ((this.field_145957_n[0]).field_77994_a <= 0) this.field_145957_n[0] = null; 
/*     */   }
/*     */   
/*     */   public static int func_145952_a(ItemStack p_145952_0_) {
/* 213 */     if (p_145952_0_ == null) return 0; 
/* 214 */     Item item = p_145952_0_.func_77973_b();
/*     */ 
/*     */     
/* 217 */     if (item instanceof net.minecraft.item.ItemBlock && Block.func_149634_a(item) != Blocks.field_150350_a) {
/* 218 */       Block block = Block.func_149634_a(item);
/*     */       
/* 220 */       if (block == Blocks.field_150376_bx) {
/* 221 */         return 150;
/*     */       }
/*     */       
/* 224 */       if (block.func_149688_o() == Material.field_151575_d) {
/* 225 */         return 300;
/*     */       }
/*     */       
/* 228 */       if (block == Blocks.field_150402_ci) {
/* 229 */         return 16000;
/*     */       }
/*     */     } 
/*     */     
/* 233 */     if (item instanceof ItemTool && ((ItemTool)item).func_77861_e().equals("WOOD"))
/* 234 */       return 200; 
/* 235 */     if (item instanceof ItemSword && ((ItemSword)item).func_150932_j().equals("WOOD"))
/* 236 */       return 200; 
/* 237 */     if (item instanceof ItemHoe && ((ItemHoe)item).func_77842_f().equals("WOOD")) {
/* 238 */       return 200;
/*     */     }
/*     */     
/* 241 */     if (item == Items.field_151055_y) {
/* 242 */       return 100;
/*     */     }
/*     */     
/* 245 */     if (item == Items.field_151044_h) return 1600;
/*     */     
/* 247 */     if (item == Items.field_151129_at) return 20000;
/*     */     
/* 249 */     if (item == Item.func_150898_a(Blocks.field_150345_g)) return 100;
/*     */     
/* 251 */     if (item == Items.field_151072_bj) return 2400;
/*     */     
/* 253 */     return 0;
/*     */   }
/*     */   
/*     */   public static boolean func_145954_b(ItemStack p_145954_0_) {
/* 257 */     return (func_145952_a(p_145954_0_) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 262 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) return false; 
/* 263 */     if (p_70300_1_.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) > 64.0D) return false; 
/* 264 */     return true;
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
/* 277 */     if (p_94041_1_ == 2) return false; 
/* 278 */     if (p_94041_1_ == 1) return func_145954_b(p_94041_2_); 
/* 279 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] func_94128_d(int p_94128_1_) {
/* 284 */     if (p_94128_1_ == 0)
/* 285 */       return field_145959_l; 
/* 286 */     if (p_94128_1_ == 1) {
/* 287 */       return field_145962_k;
/*     */     }
/* 289 */     return field_145960_m;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_102007_a(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
/* 295 */     return func_94041_b(p_102007_1_, p_102007_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_102008_b(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
/* 301 */     if (p_102008_3_ == 0 && p_102008_1_ == 1 && 
/* 302 */       p_102008_2_.func_77973_b() != Items.field_151133_ar) return false;
/*     */ 
/*     */     
/* 305 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */