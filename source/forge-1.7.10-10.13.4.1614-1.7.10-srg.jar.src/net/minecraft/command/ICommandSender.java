package net.minecraft.command;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public interface ICommandSender {
  String func_70005_c_();
  
  IChatComponent func_145748_c_();
  
  void func_145747_a(IChatComponent paramIChatComponent);
  
  boolean func_70003_b(int paramInt, String paramString);
  
  ChunkCoordinates func_82114_b();
  
  World func_130014_f_();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\ICommandSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */