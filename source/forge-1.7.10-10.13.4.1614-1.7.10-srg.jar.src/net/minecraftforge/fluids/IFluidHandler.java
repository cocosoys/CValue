package net.minecraftforge.fluids;

import net.minecraftforge.common.util.ForgeDirection;

public interface IFluidHandler {
  int fill(ForgeDirection paramForgeDirection, FluidStack paramFluidStack, boolean paramBoolean);
  
  FluidStack drain(ForgeDirection paramForgeDirection, FluidStack paramFluidStack, boolean paramBoolean);
  
  FluidStack drain(ForgeDirection paramForgeDirection, int paramInt, boolean paramBoolean);
  
  boolean canFill(ForgeDirection paramForgeDirection, Fluid paramFluid);
  
  boolean canDrain(ForgeDirection paramForgeDirection, Fluid paramFluid);
  
  FluidTankInfo[] getTankInfo(ForgeDirection paramForgeDirection);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\IFluidHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */