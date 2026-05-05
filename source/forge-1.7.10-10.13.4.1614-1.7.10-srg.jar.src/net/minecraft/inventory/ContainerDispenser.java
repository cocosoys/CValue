/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntityDispenser;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerDispenser
/*    */   extends Container
/*    */ {
/*    */   private TileEntityDispenser field_75182_e;
/*    */   private static final String __OBFID = "CL_00001763";
/*    */   
/*    */   public ContainerDispenser(IInventory p_i1825_1_, TileEntityDispenser p_i1825_2_) {
/* 17 */     this.field_75182_e = p_i1825_2_;
/*    */     byte b;
/* 19 */     for (b = 0; b < 3; b++) {
/* 20 */       for (byte b1 = 0; b1 < 3; b1++) {
/* 21 */         func_75146_a(new Slot((IInventory)p_i1825_2_, b1 + b * 3, 62 + b1 * 18, 17 + b * 18));
/*    */       }
/*    */     } 
/*    */     
/* 25 */     for (b = 0; b < 3; b++) {
/* 26 */       for (byte b1 = 0; b1 < 9; b1++) {
/* 27 */         func_75146_a(new Slot(p_i1825_1_, b1 + b * 9 + 9, 8 + b1 * 18, 84 + b * 18));
/*    */       }
/*    */     } 
/* 30 */     for (b = 0; b < 9; b++) {
/* 31 */       func_75146_a(new Slot(p_i1825_1_, b, 8 + b * 18, 142));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/* 37 */     return this.field_75182_e.func_70300_a(p_75145_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 42 */     ItemStack itemStack = null;
/* 43 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/* 44 */     if (slot != null && slot.func_75216_d()) {
/* 45 */       ItemStack itemStack1 = slot.func_75211_c();
/* 46 */       itemStack = itemStack1.func_77946_l();
/*    */       
/* 48 */       if (p_82846_2_ < 9) {
/* 49 */         if (!func_75135_a(itemStack1, 9, 45, true)) {
/* 50 */           return null;
/*    */         }
/*    */       }
/* 53 */       else if (!func_75135_a(itemStack1, 0, 9, false)) {
/* 54 */         return null;
/*    */       } 
/*    */       
/* 57 */       if (itemStack1.field_77994_a == 0) {
/* 58 */         slot.func_75215_d(null);
/*    */       } else {
/* 60 */         slot.func_75218_e();
/*    */       } 
/* 62 */       if (itemStack1.field_77994_a == itemStack.field_77994_a)
/*    */       {
/* 64 */         return null;
/*    */       }
/* 66 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*    */     } 
/*    */     
/* 69 */     return itemStack;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerDispenser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */