/*     */ package net.minecraft.tileentity;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class TileEntityDispenser extends TileEntity implements IInventory {
/*  12 */   private ItemStack[] field_146022_i = new ItemStack[9];
/*  13 */   private Random field_146021_j = new Random();
/*     */   protected String field_146020_a;
/*     */   private static final String __OBFID = "CL_00000352";
/*     */   
/*     */   public int func_70302_i_() {
/*  18 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/*  23 */     return this.field_146022_i[p_70301_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/*  28 */     if (this.field_146022_i[p_70298_1_] != null) {
/*  29 */       if ((this.field_146022_i[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*  30 */         ItemStack itemStack1 = this.field_146022_i[p_70298_1_];
/*  31 */         this.field_146022_i[p_70298_1_] = null;
/*  32 */         func_70296_d();
/*  33 */         return itemStack1;
/*     */       } 
/*  35 */       ItemStack itemStack = this.field_146022_i[p_70298_1_].func_77979_a(p_70298_2_);
/*  36 */       if ((this.field_146022_i[p_70298_1_]).field_77994_a == 0) this.field_146022_i[p_70298_1_] = null; 
/*  37 */       func_70296_d();
/*  38 */       return itemStack;
/*     */     } 
/*     */     
/*  41 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/*  46 */     if (this.field_146022_i[p_70304_1_] != null) {
/*  47 */       ItemStack itemStack = this.field_146022_i[p_70304_1_];
/*  48 */       this.field_146022_i[p_70304_1_] = null;
/*  49 */       return itemStack;
/*     */     } 
/*  51 */     return null;
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
/*     */   public int func_146017_i() {
/*  71 */     byte b = -1;
/*  72 */     byte b1 = 1;
/*     */     
/*  74 */     for (byte b2 = 0; b2 < this.field_146022_i.length; b2++) {
/*  75 */       if (this.field_146022_i[b2] != null && this.field_146021_j.nextInt(b1++) == 0) {
/*  76 */         b = b2;
/*     */       }
/*     */     } 
/*     */     
/*  80 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/*  85 */     this.field_146022_i[p_70299_1_] = p_70299_2_;
/*  86 */     if (p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_()) p_70299_2_.field_77994_a = func_70297_j_(); 
/*  87 */     func_70296_d();
/*     */   }
/*     */   
/*     */   public int func_146019_a(ItemStack p_146019_1_) {
/*  91 */     for (byte b = 0; b < this.field_146022_i.length; b++) {
/*  92 */       if (this.field_146022_i[b] == null || this.field_146022_i[b].func_77973_b() == null) {
/*  93 */         func_70299_a(b, p_146019_1_);
/*  94 */         return b;
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 103 */     return func_145818_k_() ? this.field_146020_a : "container.dispenser";
/*     */   }
/*     */   
/*     */   public void func_146018_a(String p_146018_1_) {
/* 107 */     this.field_146020_a = p_146018_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 112 */     return (this.field_146020_a != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 118 */     super.func_145839_a(p_145839_1_);
/* 119 */     NBTTagList nBTTagList = p_145839_1_.func_150295_c("Items", 10);
/* 120 */     this.field_146022_i = new ItemStack[func_70302_i_()];
/* 121 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 122 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/* 123 */       int i = nBTTagCompound.func_74771_c("Slot") & 0xFF;
/* 124 */       if (i >= 0 && i < this.field_146022_i.length) this.field_146022_i[i] = ItemStack.func_77949_a(nBTTagCompound); 
/*     */     } 
/* 126 */     if (p_145839_1_.func_150297_b("CustomName", 8)) this.field_146020_a = p_145839_1_.func_74779_i("CustomName");
/*     */   
/*     */   }
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 131 */     super.func_145841_b(p_145841_1_);
/* 132 */     NBTTagList nBTTagList = new NBTTagList();
/*     */     
/* 134 */     for (byte b = 0; b < this.field_146022_i.length; b++) {
/* 135 */       if (this.field_146022_i[b] != null) {
/* 136 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 137 */         nBTTagCompound.func_74774_a("Slot", (byte)b);
/* 138 */         this.field_146022_i[b].func_77955_b(nBTTagCompound);
/* 139 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/*     */     } 
/* 142 */     p_145841_1_.func_74782_a("Items", (NBTBase)nBTTagList);
/* 143 */     if (func_145818_k_()) p_145841_1_.func_74778_a("CustomName", this.field_146020_a);
/*     */   
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 148 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 153 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) return false; 
/* 154 */     if (p_70300_1_.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) > 64.0D) return false; 
/* 155 */     return true;
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
/* 168 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityDispenser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */