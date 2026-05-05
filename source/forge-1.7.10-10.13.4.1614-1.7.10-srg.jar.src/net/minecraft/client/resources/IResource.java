package net.minecraft.client.resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.InputStream;
import net.minecraft.client.resources.data.IMetadataSection;

@SideOnly(Side.CLIENT)
public interface IResource {
  InputStream func_110527_b();
  
  boolean func_110528_c();
  
  IMetadataSection func_110526_a(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\IResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */