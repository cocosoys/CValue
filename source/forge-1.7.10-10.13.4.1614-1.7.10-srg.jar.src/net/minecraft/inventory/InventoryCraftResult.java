/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class InventoryCraftResult
/*    */   implements IInventory {
/*  8 */   private ItemStack[] field_70467_a = new ItemStack[1];
/*    */   private static final String __OBFID = "CL_00001760";
/*    */   
/*    */   public int func_70302_i_() {
/* 12 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_70301_a(int p_70301_1_) {
/* 17 */     return this.field_70467_a[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_145825_b() {
/* 22 */     return "Result";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_145818_k_() {
/* 27 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/* 32 */     if (this.field_70467_a[0] != null) {
/* 33 */       ItemStack itemStack = this.field_70467_a[0];
/* 34 */       this.field_70467_a[0] = null;
/* 35 */       return itemStack;
/*    */     } 
/* 37 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_70304_b(int p_70304_1_) {
/* 42 */     if (this.field_70467_a[0] != null) {
/* 43 */       ItemStack itemStack = this.field_70467_a[0];
/* 44 */       this.field_70467_a[0] = null;
/* 45 */       return itemStack;
/*    */     } 
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/* 52 */     this.field_70467_a[0] = p_70299_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70297_j_() {
/* 57 */     return 64;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70296_d() {}
/*    */ 
/*    */   
/*    */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70295_k_() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70305_f() {}
/*    */ 
/*    */   
/*    */   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\InventoryCraftResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */