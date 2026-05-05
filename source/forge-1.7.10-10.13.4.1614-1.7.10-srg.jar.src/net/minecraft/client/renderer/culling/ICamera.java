package net.minecraft.client.renderer.culling;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

@SideOnly(Side.CLIENT)
public interface ICamera {
  boolean func_78546_a(AxisAlignedBB paramAxisAlignedBB);
  
  void func_78547_a(double paramDouble1, double paramDouble2, double paramDouble3);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\culling\ICamera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */