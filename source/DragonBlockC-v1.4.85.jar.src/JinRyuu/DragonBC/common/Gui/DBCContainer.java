/*    */ package JinRyuu.DragonBC.common.Gui;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Render.SpacePod01TileEntity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class DBCContainer extends Container {
/*    */   protected SpacePod01TileEntity tile_entity;
/*    */   
/*    */   public DBCContainer(SpacePod01TileEntity tile_entity, InventoryPlayer player_inventory) {
/* 15 */     this.tile_entity = tile_entity;
/* 16 */     int o = 0;
/* 17 */     for (int q = 0; q < 3; q++) {
/* 18 */       for (int p = 0; p < 9; p++) {
/*    */         
/* 20 */         func_75146_a(new Slot((IInventory)tile_entity, o, 9 + p * 18, 9 + q * 18));
/*    */ 
/*    */         
/* 23 */         o++;
/*    */       } 
/*    */     } 
/* 26 */     bindPlayerInventory(player_inventory);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer player) {
/* 31 */     return this.tile_entity.func_70300_a(player);
/*    */   }
/*    */   protected void bindPlayerInventory(InventoryPlayer player_inventory) {
/*    */     int i;
/* 35 */     for (i = 0; i < 3; i++) {
/* 36 */       for (int j = 0; j < 9; j++) {
/* 37 */         func_75146_a(new Slot((IInventory)player_inventory, j + i * 9 + 9, 9 + j * 18, 85 + i * 16));
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 43 */     for (i = 0; i < 9; i++) {
/* 44 */       func_75146_a(new Slot((IInventory)player_inventory, i, 6 + i * 16, 142));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack putStackInSlot(int slot_index) {
/* 50 */     ItemStack stack = null;
/* 51 */     Slot slot_object = this.field_75151_b.get(slot_index);
/*    */     
/* 53 */     if (slot_object != null && slot_object.func_75216_d()) {
/* 54 */       ItemStack stack_in_slot = slot_object.func_75211_c();
/* 55 */       stack = stack_in_slot.func_77946_l();
/*    */       
/* 57 */       if (slot_index == 0) {
/* 58 */         if (!func_75135_a(stack_in_slot, 1, this.field_75151_b.size(), true))
/*    */         {
/* 60 */           return null;
/*    */         }
/* 62 */       } else if (!func_75135_a(stack_in_slot, 0, 1, false)) {
/* 63 */         return null;
/*    */       } 
/*    */       
/* 66 */       if (stack_in_slot.field_77994_a == 0) {
/* 67 */         slot_object.func_75215_d(null);
/*    */       } else {
/* 69 */         slot_object.func_75218_e();
/*    */       } 
/*    */     } 
/*    */     
/* 73 */     return stack;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */