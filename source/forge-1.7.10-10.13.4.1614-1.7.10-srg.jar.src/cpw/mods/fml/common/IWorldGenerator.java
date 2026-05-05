package cpw.mods.fml.common;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public interface IWorldGenerator {
  void generate(Random paramRandom, int paramInt1, int paramInt2, World paramWorld, IChunkProvider paramIChunkProvider1, IChunkProvider paramIChunkProvider2);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\IWorldGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */