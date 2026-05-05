package net.minecraft.world.chunk.storage;

import java.io.IOException;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public interface IChunkLoader {
  Chunk func_75815_a(World paramWorld, int paramInt1, int paramInt2) throws IOException;
  
  void func_75816_a(World paramWorld, Chunk paramChunk) throws MinecraftException, IOException;
  
  void func_75819_b(World paramWorld, Chunk paramChunk);
  
  void func_75817_a();
  
  void func_75818_b();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\IChunkLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */