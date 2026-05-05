/*   */ package org.bukkit.craftbukkit.v1_7_R4.inventory;
/*   */ import net.minecraft.server.v1_7_R4.IInventory;
/*   */ import net.minecraft.server.v1_7_R4.InventoryMerchant;
/*   */ import org.bukkit.inventory.MerchantInventory;
/*   */ 
/*   */ public class CraftInventoryMerchant extends CraftInventory implements MerchantInventory {
/*   */   public CraftInventoryMerchant(InventoryMerchant merchant) {
/* 8 */     super((IInventory)merchant);
/*   */   }
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\inventory\CraftInventoryMerchant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */