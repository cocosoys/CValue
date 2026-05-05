/*    */ package org.bukkit.event.inventory;
/*    */ 
/*    */ import org.bukkit.inventory.InventoryView;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryCreativeEvent
/*    */   extends InventoryClickEvent
/*    */ {
/*    */   private ItemStack item;
/*    */   
/*    */   public InventoryCreativeEvent(InventoryView what, InventoryType.SlotType type, int slot, ItemStack newItem) {
/* 16 */     super(what, type, slot, ClickType.CREATIVE, InventoryAction.PLACE_ALL);
/* 17 */     this.item = newItem;
/*    */   }
/*    */   
/*    */   public ItemStack getCursor() {
/* 21 */     return this.item;
/*    */   }
/*    */   
/*    */   public void setCursor(ItemStack item) {
/* 25 */     this.item = item;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\inventory\InventoryCreativeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */