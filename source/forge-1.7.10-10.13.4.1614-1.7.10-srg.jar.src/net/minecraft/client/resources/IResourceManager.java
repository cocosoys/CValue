package net.minecraft.client.resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public interface IResourceManager {
  Set func_135055_a();
  
  IResource func_110536_a(ResourceLocation paramResourceLocation) throws IOException;
  
  List func_135056_b(ResourceLocation paramResourceLocation) throws IOException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\IResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */