package net.minecraft.world.storage;

import java.io.File;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;

public interface ISaveHandler {
  WorldInfo func_75757_d();
  
  void func_75762_c() throws MinecraftException;
  
  IChunkLoader func_75763_a(WorldProvider paramWorldProvider);
  
  void func_75755_a(WorldInfo paramWorldInfo, NBTTagCompound paramNBTTagCompound);
  
  void func_75761_a(WorldInfo paramWorldInfo);
  
  IPlayerFileData func_75756_e();
  
  void func_75759_a();
  
  File func_75765_b();
  
  File func_75758_b(String paramString);
  
  String func_75760_g();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\ISaveHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */