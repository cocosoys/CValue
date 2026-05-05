package net.minecraft.item.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IRecipe {
  boolean func_77569_a(InventoryCrafting paramInventoryCrafting, World paramWorld);
  
  ItemStack func_77572_b(InventoryCrafting paramInventoryCrafting);
  
  int func_77570_a();
  
  ItemStack func_77571_b();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\IRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */