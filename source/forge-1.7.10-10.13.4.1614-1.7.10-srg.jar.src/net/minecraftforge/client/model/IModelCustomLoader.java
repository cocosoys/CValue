package net.minecraftforge.client.model;

import net.minecraft.util.ResourceLocation;

public interface IModelCustomLoader {
  String getType();
  
  String[] getSuffixes();
  
  IModelCustom loadInstance(ResourceLocation paramResourceLocation) throws ModelFormatException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\model\IModelCustomLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */