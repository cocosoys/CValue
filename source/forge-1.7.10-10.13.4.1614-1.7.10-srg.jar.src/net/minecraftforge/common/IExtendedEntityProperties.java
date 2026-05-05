package net.minecraftforge.common;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public interface IExtendedEntityProperties {
  void saveNBTData(NBTTagCompound paramNBTTagCompound);
  
  void loadNBTData(NBTTagCompound paramNBTTagCompound);
  
  void init(Entity paramEntity, World paramWorld);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\IExtendedEntityProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */