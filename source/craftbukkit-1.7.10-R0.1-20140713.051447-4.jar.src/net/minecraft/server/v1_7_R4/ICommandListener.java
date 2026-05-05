package net.minecraft.server.v1_7_R4;

public interface ICommandListener {
  String getName();
  
  IChatBaseComponent getScoreboardDisplayName();
  
  void sendMessage(IChatBaseComponent paramIChatBaseComponent);
  
  boolean a(int paramInt, String paramString);
  
  ChunkCoordinates getChunkCoordinates();
  
  World getWorld();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ICommandListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */