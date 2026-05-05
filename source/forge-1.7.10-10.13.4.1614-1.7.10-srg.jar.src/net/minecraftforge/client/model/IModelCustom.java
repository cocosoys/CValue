package net.minecraftforge.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IModelCustom {
  String getType();
  
  @SideOnly(Side.CLIENT)
  void renderAll();
  
  @SideOnly(Side.CLIENT)
  void renderOnly(String... paramVarArgs);
  
  @SideOnly(Side.CLIENT)
  void renderPart(String paramString);
  
  @SideOnly(Side.CLIENT)
  void renderAllExcept(String... paramVarArgs);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\model\IModelCustom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */