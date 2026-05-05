package net.minecraft.client.resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public interface IResourcePack {
  InputStream func_110590_a(ResourceLocation paramResourceLocation) throws IOException;
  
  boolean func_110589_b(ResourceLocation paramResourceLocation);
  
  Set func_110587_b();
  
  IMetadataSection func_135058_a(IMetadataSerializer paramIMetadataSerializer, String paramString) throws IOException;
  
  BufferedImage func_110586_a() throws IOException;
  
  String func_130077_b();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\IResourcePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */