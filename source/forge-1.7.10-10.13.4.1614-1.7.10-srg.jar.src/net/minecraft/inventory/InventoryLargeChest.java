/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class InventoryLargeChest implements IInventory {
/*    */   private String field_70479_a;
/*    */   private IInventory field_70477_b;
/*    */   
/*    */   public InventoryLargeChest(String p_i1559_1_, IInventory p_i1559_2_, IInventory p_i1559_3_) {
/* 11 */     this.field_70479_a = p_i1559_1_;
/* 12 */     if (p_i1559_2_ == null) p_i1559_2_ = p_i1559_3_; 
/* 13 */     if (p_i1559_3_ == null) p_i1559_3_ = p_i1559_2_; 
/* 14 */     this.field_70477_b = p_i1559_2_;
/* 15 */     this.field_70478_c = p_i1559_3_;
/*    */   }
/*    */   private IInventory field_70478_c; private static final String __OBFID = "CL_00001507";
/*    */   
/*    */   public int func_70302_i_() {
/* 20 */     return this.field_70477_b.func_70302_i_() + this.field_70478_c.func_70302_i_();
/*    */   }
/*    */   
/*    */   public boolean func_90010_a(IInventory p_90010_1_) {
/* 24 */     return (this.field_70477_b == p_90010_1_ || this.field_70478_c == p_90010_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_145825_b() {
/* 29 */     if (this.field_70477_b.func_145818_k_()) return this.field_70477_b.func_145825_b(); 
/* 30 */     if (this.field_70478_c.func_145818_k_()) return this.field_70478_c.func_145825_b(); 
/* 31 */     return this.field_70479_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_145818_k_() {
/* 36 */     return (this.field_70477_b.func_145818_k_() || this.field_70478_c.func_145818_k_());
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_70301_a(int p_70301_1_) {
/* 41 */     if (p_70301_1_ >= this.field_70477_b.func_70302_i_()) return this.field_70478_c.func_70301_a(p_70301_1_ - this.field_70477_b.func_70302_i_()); 
/* 42 */     return this.field_70477_b.func_70301_a(p_70301_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/* 47 */     if (p_70298_1_ >= this.field_70477_b.func_70302_i_()) return this.field_70478_c.func_70298_a(p_70298_1_ - this.field_70477_b.func_70302_i_(), p_70298_2_); 
/* 48 */     return this.field_70477_b.func_70298_a(p_70298_1_, p_70298_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_70304_b(int p_70304_1_) {
/* 53 */     if (p_70304_1_ >= this.field_70477_b.func_70302_i_()) return this.field_70478_c.func_70304_b(p_70304_1_ - this.field_70477_b.func_70302_i_()); 
/* 54 */     return this.field_70477_b.func_70304_b(p_70304_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/* 59 */     if (p_70299_1_ >= this.field_70477_b.func_70302_i_()) { this.field_70478_c.func_70299_a(p_70299_1_ - this.field_70477_b.func_70302_i_(), p_70299_2_); }
/* 60 */     else { this.field_70477_b.func_70299_a(p_70299_1_, p_70299_2_); }
/*    */   
/*    */   }
/*    */   
/*    */   public int func_70297_j_() {
/* 65 */     return this.field_70477_b.func_70297_j_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70296_d() {
/* 70 */     this.field_70477_b.func_70296_d();
/* 71 */     this.field_70478_c.func_70296_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 76 */     return (this.field_70477_b.func_70300_a(p_70300_1_) && this.field_70478_c.func_70300_a(p_70300_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70295_k_() {
/* 81 */     this.field_70477_b.func_70295_k_();
/* 82 */     this.field_70478_c.func_70295_k_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70305_f() {
/* 87 */     this.field_70477_b.func_70305_f();
/* 88 */     this.field_70478_c.func_70305_f();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\InventoryLargeChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */