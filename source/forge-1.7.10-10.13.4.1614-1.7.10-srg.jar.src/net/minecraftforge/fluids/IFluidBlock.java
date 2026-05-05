package net.minecraftforge.fluids;

import net.minecraft.world.World;

public interface IFluidBlock {
  Fluid getFluid();
  
  FluidStack drain(World paramWorld, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  boolean canDrain(World paramWorld, int paramInt1, int paramInt2, int paramInt3);
  
  float getFilledPercentage(World paramWorld, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\IFluidBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */