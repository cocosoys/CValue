/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ContainerChest extends Container {
/*    */   private IInventory field_75155_e;
/*    */   private int field_75154_f;
/*    */   private static final String __OBFID = "CL_00001742";
/*    */   
/*    */   public ContainerChest(IInventory p_i1806_1_, IInventory p_i1806_2_) {
/* 12 */     this.field_75155_e = p_i1806_2_;
/* 13 */     this.field_75154_f = p_i1806_2_.func_70302_i_() / 9;
/* 14 */     p_i1806_2_.func_70295_k_();
/*    */     
/* 16 */     int i = (this.field_75154_f - 4) * 18;
/*    */     byte b;
/* 18 */     for (b = 0; b < this.field_75154_f; b++) {
/* 19 */       for (byte b1 = 0; b1 < 9; b1++) {
/* 20 */         func_75146_a(new Slot(p_i1806_2_, b1 + b * 9, 8 + b1 * 18, 18 + b * 18));
/*    */       }
/*    */     } 
/*    */     
/* 24 */     for (b = 0; b < 3; b++) {
/* 25 */       for (byte b1 = 0; b1 < 9; b1++) {
/* 26 */         func_75146_a(new Slot(p_i1806_1_, b1 + b * 9 + 9, 8 + b1 * 18, 103 + b * 18 + i));
/*    */       }
/*    */     } 
/* 29 */     for (b = 0; b < 9; b++) {
/* 30 */       func_75146_a(new Slot(p_i1806_1_, b, 8 + b * 18, 161 + i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/* 36 */     return this.field_75155_e.func_70300_a(p_75145_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 41 */     ItemStack itemStack = null;
/* 42 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/* 43 */     if (slot != null && slot.func_75216_d()) {
/* 44 */       ItemStack itemStack1 = slot.func_75211_c();
/* 45 */       itemStack = itemStack1.func_77946_l();
/*    */       
/* 47 */       if (p_82846_2_ < this.field_75154_f * 9) {
/* 48 */         if (!func_75135_a(itemStack1, this.field_75154_f * 9, this.field_75151_b.size(), true)) {
/* 49 */           return null;
/*    */         }
/*    */       }
/* 52 */       else if (!func_75135_a(itemStack1, 0, this.field_75154_f * 9, false)) {
/* 53 */         return null;
/*    */       } 
/*    */       
/* 56 */       if (itemStack1.field_77994_a == 0) {
/* 57 */         slot.func_75215_d(null);
/*    */       } else {
/* 59 */         slot.func_75218_e();
/*    */       } 
/*    */     } 
/* 62 */     return itemStack;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75134_a(EntityPlayer p_75134_1_) {
/* 67 */     super.func_75134_a(p_75134_1_);
/* 68 */     this.field_75155_e.func_70305_f();
/*    */   }
/*    */   
/*    */   public IInventory func_85151_d() {
/* 72 */     return this.field_75155_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */