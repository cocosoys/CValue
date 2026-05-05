/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import net.minecraft.entity.IMerchant;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.village.MerchantRecipe;
/*     */ import net.minecraft.village.MerchantRecipeList;
/*     */ 
/*     */ public class InventoryMerchant implements IInventory {
/*     */   private final IMerchant field_70476_a;
/*  11 */   private ItemStack[] field_70474_b = new ItemStack[3];
/*     */   
/*     */   private final EntityPlayer field_70475_c;
/*     */   private MerchantRecipe field_70472_d;
/*     */   
/*     */   public InventoryMerchant(EntityPlayer p_i1820_1_, IMerchant p_i1820_2_) {
/*  17 */     this.field_70475_c = p_i1820_1_;
/*  18 */     this.field_70476_a = p_i1820_2_;
/*     */   }
/*     */   private int field_70473_e; private static final String __OBFID = "CL_00001756";
/*     */   
/*     */   public int func_70302_i_() {
/*  23 */     return this.field_70474_b.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/*  28 */     return this.field_70474_b[p_70301_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/*  33 */     if (this.field_70474_b[p_70298_1_] != null) {
/*  34 */       if (p_70298_1_ == 2) {
/*  35 */         ItemStack itemStack1 = this.field_70474_b[p_70298_1_];
/*  36 */         this.field_70474_b[p_70298_1_] = null;
/*  37 */         return itemStack1;
/*     */       } 
/*  39 */       if ((this.field_70474_b[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*  40 */         ItemStack itemStack1 = this.field_70474_b[p_70298_1_];
/*  41 */         this.field_70474_b[p_70298_1_] = null;
/*  42 */         if (func_70469_d(p_70298_1_)) {
/*  43 */           func_70470_g();
/*     */         }
/*  45 */         return itemStack1;
/*     */       } 
/*  47 */       ItemStack itemStack = this.field_70474_b[p_70298_1_].func_77979_a(p_70298_2_);
/*  48 */       if ((this.field_70474_b[p_70298_1_]).field_77994_a == 0) this.field_70474_b[p_70298_1_] = null; 
/*  49 */       if (func_70469_d(p_70298_1_)) {
/*  50 */         func_70470_g();
/*     */       }
/*  52 */       return itemStack;
/*     */     } 
/*     */     
/*  55 */     return null;
/*     */   }
/*     */   
/*     */   private boolean func_70469_d(int p_70469_1_) {
/*  59 */     return (p_70469_1_ == 0 || p_70469_1_ == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/*  64 */     if (this.field_70474_b[p_70304_1_] != null) {
/*  65 */       ItemStack itemStack = this.field_70474_b[p_70304_1_];
/*  66 */       this.field_70474_b[p_70304_1_] = null;
/*  67 */       return itemStack;
/*     */     } 
/*  69 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/*  74 */     this.field_70474_b[p_70299_1_] = p_70299_2_;
/*  75 */     if (p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_()) p_70299_2_.field_77994_a = func_70297_j_(); 
/*  76 */     if (func_70469_d(p_70299_1_)) {
/*  77 */       func_70470_g();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/*  83 */     return "mob.villager";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/*  93 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/*  98 */     return (this.field_70476_a.func_70931_l_() == p_70300_1_);
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
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70296_d() {
/* 116 */     func_70470_g();
/*     */   }
/*     */   
/*     */   public void func_70470_g() {
/* 120 */     this.field_70472_d = null;
/*     */     
/* 122 */     ItemStack itemStack1 = this.field_70474_b[0];
/* 123 */     ItemStack itemStack2 = this.field_70474_b[1];
/*     */     
/* 125 */     if (itemStack1 == null) {
/* 126 */       itemStack1 = itemStack2;
/* 127 */       itemStack2 = null;
/*     */     } 
/*     */     
/* 130 */     if (itemStack1 == null) {
/* 131 */       func_70299_a(2, null);
/*     */     } else {
/* 133 */       MerchantRecipeList merchantRecipeList = this.field_70476_a.func_70934_b(this.field_70475_c);
/* 134 */       if (merchantRecipeList != null) {
/* 135 */         MerchantRecipe merchantRecipe = merchantRecipeList.func_77203_a(itemStack1, itemStack2, this.field_70473_e);
/* 136 */         if (merchantRecipe != null && !merchantRecipe.func_82784_g()) {
/* 137 */           this.field_70472_d = merchantRecipe;
/* 138 */           func_70299_a(2, merchantRecipe.func_77397_d().func_77946_l());
/* 139 */         } else if (itemStack2 != null) {
/*     */           
/* 141 */           merchantRecipe = merchantRecipeList.func_77203_a(itemStack2, itemStack1, this.field_70473_e);
/* 142 */           if (merchantRecipe != null && !merchantRecipe.func_82784_g()) {
/* 143 */             this.field_70472_d = merchantRecipe;
/* 144 */             func_70299_a(2, merchantRecipe.func_77397_d().func_77946_l());
/*     */           } else {
/* 146 */             func_70299_a(2, null);
/*     */           } 
/*     */         } else {
/*     */           
/* 150 */           func_70299_a(2, null);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 155 */     this.field_70476_a.func_110297_a_(func_70301_a(2));
/*     */   }
/*     */   
/*     */   public MerchantRecipe func_70468_h() {
/* 159 */     return this.field_70472_d;
/*     */   }
/*     */   
/*     */   public void func_70471_c(int p_70471_1_) {
/* 163 */     this.field_70473_e = p_70471_1_;
/* 164 */     func_70470_g();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\InventoryMerchant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */