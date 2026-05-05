package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.resources.IResourceManager;

@SideOnly(Side.CLIENT)
public interface ITextureObject {
  void func_110551_a(IResourceManager paramIResourceManager) throws IOException;
  
  int func_110552_b();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\ITextureObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */