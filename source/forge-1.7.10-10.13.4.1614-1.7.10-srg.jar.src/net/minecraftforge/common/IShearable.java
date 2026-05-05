package net.minecraftforge.common;

import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

public interface IShearable {
  boolean isShearable(ItemStack paramItemStack, IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3);
  
  ArrayList<ItemStack> onSheared(ItemStack paramItemStack, IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\IShearable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */