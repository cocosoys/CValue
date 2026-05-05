/*    */ package JinRyuu.JRMCore.i;
/*    */ 
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SlotCustom
/*    */   extends Slot
/*    */ {
/*    */   public SlotCustom(IInventory inventory, int slotIndex, int x, int y) {
/* 15 */     super(inventory, slotIndex, x, y);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack stack) {
/* 25 */     if (getSlotIndex() == 0) {
/* 26 */       return stack.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemWeight;
/*    */     }
/* 28 */     if (getSlotIndex() == 1) {
/* 29 */       return stack.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemBodysuit;
/*    */     }
/* 31 */     if (getSlotIndex() == 2) {
/* 32 */       return stack.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemHeadwear;
/*    */     }
/* 34 */     if (getSlotIndex() >= 3 && getSlotIndex() <= 10) {
/* 35 */       return stack.func_77973_b() instanceof JinRyuu.JRMCore.items.ItemVanity;
/*    */     }
/* 37 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\i\SlotCustom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */