package net.minecraft.world.chunk;

import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public interface IChunkProvider {
  boolean func_73149_a(int paramInt1, int paramInt2);
  
  Chunk func_73154_d(int paramInt1, int paramInt2);
  
  Chunk func_73158_c(int paramInt1, int paramInt2);
  
  void func_73153_a(IChunkProvider paramIChunkProvider, int paramInt1, int paramInt2);
  
  boolean func_73151_a(boolean paramBoolean, IProgressUpdate paramIProgressUpdate);
  
  boolean func_73156_b();
  
  boolean func_73157_c();
  
  String func_73148_d();
  
  List func_73155_a(EnumCreatureType paramEnumCreatureType, int paramInt1, int paramInt2, int paramInt3);
  
  ChunkPosition func_147416_a(World paramWorld, String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  int func_73152_e();
  
  void func_82695_e(int paramInt1, int paramInt2);
  
  void func_104112_b();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\IChunkProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */