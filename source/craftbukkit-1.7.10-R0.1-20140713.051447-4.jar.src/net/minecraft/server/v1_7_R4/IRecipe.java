package net.minecraft.server.v1_7_R4;

import org.bukkit.inventory.Recipe;

public interface IRecipe {
  boolean a(InventoryCrafting paramInventoryCrafting, World paramWorld);
  
  ItemStack a(InventoryCrafting paramInventoryCrafting);
  
  int a();
  
  ItemStack b();
  
  Recipe toBukkitRecipe();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\IRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */