package net.minecraftforge.fluids;

import net.minecraft.item.ItemStack;

public interface IFluidContainerItem {
  FluidStack getFluid(ItemStack paramItemStack);
  
  int getCapacity(ItemStack paramItemStack);
  
  int fill(ItemStack paramItemStack, FluidStack paramFluidStack, boolean paramBoolean);
  
  FluidStack drain(ItemStack paramItemStack, int paramInt, boolean paramBoolean);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\IFluidContainerItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */