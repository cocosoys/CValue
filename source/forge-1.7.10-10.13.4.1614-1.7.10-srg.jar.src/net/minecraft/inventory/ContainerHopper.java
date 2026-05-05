/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ContainerHopper extends Container {
/*    */   private final IInventory field_94538_a;
/*    */   private static final String __OBFID = "CL_00001750";
/*    */   
/*    */   public ContainerHopper(InventoryPlayer p_i1814_1_, IInventory p_i1814_2_) {
/* 12 */     this.field_94538_a = p_i1814_2_;
/* 13 */     p_i1814_2_.func_70295_k_();
/* 14 */     byte b1 = 51;
/*    */     byte b2;
/* 16 */     for (b2 = 0; b2 < p_i1814_2_.func_70302_i_(); b2++) {
/* 17 */       func_75146_a(new Slot(p_i1814_2_, b2, 44 + b2 * 18, 20));
/*    */     }
/*    */     
/* 20 */     for (b2 = 0; b2 < 3; b2++) {
/* 21 */       for (byte b = 0; b < 9; b++) {
/* 22 */         func_75146_a(new Slot((IInventory)p_i1814_1_, b + b2 * 9 + 9, 8 + b * 18, b2 * 18 + b1));
/*    */       }
/*    */     } 
/* 25 */     for (b2 = 0; b2 < 9; b2++) {
/* 26 */       func_75146_a(new Slot((IInventory)p_i1814_1_, b2, 8 + b2 * 18, 58 + b1));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/* 32 */     return this.field_94538_a.func_70300_a(p_75145_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 37 */     ItemStack itemStack = null;
/* 38 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/* 39 */     if (slot != null && slot.func_75216_d()) {
/* 40 */       ItemStack itemStack1 = slot.func_75211_c();
/* 41 */       itemStack = itemStack1.func_77946_l();
/*    */       
/* 43 */       if (p_82846_2_ < this.field_94538_a.func_70302_i_()) {
/* 44 */         if (!func_75135_a(itemStack1, this.field_94538_a.func_70302_i_(), this.field_75151_b.size(), true)) {
/* 45 */           return null;
/*    */         }
/*    */       }
/* 48 */       else if (!func_75135_a(itemStack1, 0, this.field_94538_a.func_70302_i_(), false)) {
/* 49 */         return null;
/*    */       } 
/*    */       
/* 52 */       if (itemStack1.field_77994_a == 0) {
/* 53 */         slot.func_75215_d(null);
/*    */       } else {
/* 55 */         slot.func_75218_e();
/*    */       } 
/*    */     } 
/* 58 */     return itemStack;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75134_a(EntityPlayer p_75134_1_) {
/* 63 */     super.func_75134_a(p_75134_1_);
/* 64 */     this.field_94538_a.func_70305_f();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */