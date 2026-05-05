/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class InventoryCrafting implements IInventory {
/*     */   private ItemStack[] field_70466_a;
/*     */   private int field_70464_b;
/*     */   private Container field_70465_c;
/*     */   private static final String __OBFID = "CL_00001743";
/*     */   
/*     */   public InventoryCrafting(Container p_i1807_1_, int p_i1807_2_, int p_i1807_3_) {
/*  13 */     int i = p_i1807_2_ * p_i1807_3_;
/*  14 */     this.field_70466_a = new ItemStack[i];
/*  15 */     this.field_70465_c = p_i1807_1_;
/*  16 */     this.field_70464_b = p_i1807_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  21 */     return this.field_70466_a.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/*  26 */     if (p_70301_1_ >= func_70302_i_()) {
/*  27 */       return null;
/*     */     }
/*  29 */     return this.field_70466_a[p_70301_1_];
/*     */   }
/*     */   
/*     */   public ItemStack func_70463_b(int p_70463_1_, int p_70463_2_) {
/*  33 */     if (p_70463_1_ < 0 || p_70463_1_ >= this.field_70464_b) {
/*  34 */       return null;
/*     */     }
/*  36 */     int i = p_70463_1_ + p_70463_2_ * this.field_70464_b;
/*  37 */     return func_70301_a(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/*  42 */     return "container.crafting";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/*  52 */     if (this.field_70466_a[p_70304_1_] != null) {
/*  53 */       ItemStack itemStack = this.field_70466_a[p_70304_1_];
/*  54 */       this.field_70466_a[p_70304_1_] = null;
/*  55 */       return itemStack;
/*     */     } 
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/*  62 */     if (this.field_70466_a[p_70298_1_] != null) {
/*  63 */       if ((this.field_70466_a[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*  64 */         ItemStack itemStack1 = this.field_70466_a[p_70298_1_];
/*  65 */         this.field_70466_a[p_70298_1_] = null;
/*  66 */         this.field_70465_c.func_75130_a(this);
/*  67 */         return itemStack1;
/*     */       } 
/*  69 */       ItemStack itemStack = this.field_70466_a[p_70298_1_].func_77979_a(p_70298_2_);
/*  70 */       if ((this.field_70466_a[p_70298_1_]).field_77994_a == 0) this.field_70466_a[p_70298_1_] = null; 
/*  71 */       this.field_70465_c.func_75130_a(this);
/*  72 */       return itemStack;
/*     */     } 
/*     */     
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/*  80 */     this.field_70466_a[p_70299_1_] = p_70299_2_;
/*  81 */     this.field_70465_c.func_75130_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/*  86 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70296_d() {}
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/*  95 */     return true;
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
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\InventoryCrafting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */