/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class InventoryBasic
/*     */   implements IInventory
/*     */ {
/*     */   private String field_70483_a;
/*     */   private int field_70481_b;
/*     */   private ItemStack[] field_70482_c;
/*     */   
/*     */   public InventoryBasic(String p_i1561_1_, boolean p_i1561_2_, int p_i1561_3_) {
/*  16 */     this.field_70483_a = p_i1561_1_;
/*  17 */     this.field_94051_e = p_i1561_2_;
/*  18 */     this.field_70481_b = p_i1561_3_;
/*  19 */     this.field_70482_c = new ItemStack[p_i1561_3_];
/*     */   }
/*     */   private List field_70480_d; private boolean field_94051_e; private static final String __OBFID = "CL_00001514";
/*     */   public void func_110134_a(IInvBasic p_110134_1_) {
/*  23 */     if (this.field_70480_d == null) this.field_70480_d = new ArrayList(); 
/*  24 */     this.field_70480_d.add(p_110134_1_);
/*     */   }
/*     */   
/*     */   public void func_110132_b(IInvBasic p_110132_1_) {
/*  28 */     this.field_70480_d.remove(p_110132_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/*  33 */     if (p_70301_1_ < 0 || p_70301_1_ >= this.field_70482_c.length) {
/*  34 */       return null;
/*     */     }
/*  36 */     return this.field_70482_c[p_70301_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/*  41 */     if (this.field_70482_c[p_70298_1_] != null) {
/*  42 */       if ((this.field_70482_c[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*  43 */         ItemStack itemStack1 = this.field_70482_c[p_70298_1_];
/*  44 */         this.field_70482_c[p_70298_1_] = null;
/*  45 */         func_70296_d();
/*  46 */         return itemStack1;
/*     */       } 
/*  48 */       ItemStack itemStack = this.field_70482_c[p_70298_1_].func_77979_a(p_70298_2_);
/*  49 */       if ((this.field_70482_c[p_70298_1_]).field_77994_a == 0) this.field_70482_c[p_70298_1_] = null; 
/*  50 */       func_70296_d();
/*  51 */       return itemStack;
/*     */     } 
/*     */     
/*  54 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/*  59 */     if (this.field_70482_c[p_70304_1_] != null) {
/*  60 */       ItemStack itemStack = this.field_70482_c[p_70304_1_];
/*  61 */       this.field_70482_c[p_70304_1_] = null;
/*  62 */       return itemStack;
/*     */     } 
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/*  69 */     this.field_70482_c[p_70299_1_] = p_70299_2_;
/*  70 */     if (p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_()) p_70299_2_.field_77994_a = func_70297_j_(); 
/*  71 */     func_70296_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  76 */     return this.field_70481_b;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/*  81 */     return this.field_70483_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/*  86 */     return this.field_94051_e;
/*     */   }
/*     */   
/*     */   public void func_110133_a(String p_110133_1_) {
/*  90 */     this.field_94051_e = true;
/*  91 */     this.field_70483_a = p_110133_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/*  96 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70296_d() {
/* 101 */     if (this.field_70480_d != null) {
/* 102 */       for (byte b = 0; b < this.field_70480_d.size(); b++) {
/* 103 */         ((IInvBasic)this.field_70480_d.get(b)).func_76316_a(this);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 110 */     return true;
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
/* 123 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\InventoryBasic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */