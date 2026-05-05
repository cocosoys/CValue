package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IInventory {
  int func_70302_i_();
  
  ItemStack func_70301_a(int paramInt);
  
  ItemStack func_70298_a(int paramInt1, int paramInt2);
  
  ItemStack func_70304_b(int paramInt);
  
  void func_70299_a(int paramInt, ItemStack paramItemStack);
  
  String func_145825_b();
  
  boolean func_145818_k_();
  
  int func_70297_j_();
  
  void func_70296_d();
  
  boolean func_70300_a(EntityPlayer paramEntityPlayer);
  
  void func_70295_k_();
  
  void func_70305_f();
  
  boolean func_94041_b(int paramInt, ItemStack paramItemStack);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\IInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */