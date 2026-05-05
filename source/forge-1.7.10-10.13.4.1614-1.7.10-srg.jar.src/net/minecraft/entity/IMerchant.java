package net.minecraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public interface IMerchant {
  void func_70932_a_(EntityPlayer paramEntityPlayer);
  
  EntityPlayer func_70931_l_();
  
  MerchantRecipeList func_70934_b(EntityPlayer paramEntityPlayer);
  
  @SideOnly(Side.CLIENT)
  void func_70930_a(MerchantRecipeList paramMerchantRecipeList);
  
  void func_70933_a(MerchantRecipe paramMerchantRecipe);
  
  void func_110297_a_(ItemStack paramItemStack);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\IMerchant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */