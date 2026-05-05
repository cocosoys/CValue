package cpw.mods.fml.common.registry;

import io.netty.buffer.ByteBuf;

public interface IEntityAdditionalSpawnData {
  void writeSpawnData(ByteBuf paramByteBuf);
  
  void readSpawnData(ByteBuf paramByteBuf);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\IEntityAdditionalSpawnData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */