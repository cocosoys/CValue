package org.bukkit;

import java.util.List;
import org.bukkit.inventory.ItemStack;

@Deprecated
public interface UnsafeValues {
  Material getMaterialFromInternalName(String paramString);
  
  List<String> tabCompleteInternalMaterialName(String paramString, List<String> paramList);
  
  ItemStack modifyItemStack(ItemStack paramItemStack, String paramString);
  
  Statistic getStatisticFromInternalName(String paramString);
  
  Achievement getAchievementFromInternalName(String paramString);
  
  List<String> tabCompleteInternalStatisticOrAchievementName(String paramString, List<String> paramList);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\UnsafeValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */