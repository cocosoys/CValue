package cpw.mods.fml.common;

import java.util.Map;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.SaveHandler;
import net.minecraft.world.storage.WorldInfo;

public interface WorldAccessContainer {
  NBTTagCompound getDataForWriting(SaveHandler paramSaveHandler, WorldInfo paramWorldInfo);
  
  void readData(SaveHandler paramSaveHandler, WorldInfo paramWorldInfo, Map<String, NBTBase> paramMap, NBTTagCompound paramNBTTagCompound);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\WorldAccessContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */