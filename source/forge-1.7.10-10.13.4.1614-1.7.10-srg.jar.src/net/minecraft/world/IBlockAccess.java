package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;

public interface IBlockAccess {
  Block func_147439_a(int paramInt1, int paramInt2, int paramInt3);
  
  TileEntity func_147438_o(int paramInt1, int paramInt2, int paramInt3);
  
  @SideOnly(Side.CLIENT)
  int func_72802_i(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  int func_72805_g(int paramInt1, int paramInt2, int paramInt3);
  
  int func_72879_k(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @SideOnly(Side.CLIENT)
  boolean func_147437_c(int paramInt1, int paramInt2, int paramInt3);
  
  @SideOnly(Side.CLIENT)
  BiomeGenBase func_72807_a(int paramInt1, int paramInt2);
  
  @SideOnly(Side.CLIENT)
  int func_72800_K();
  
  @SideOnly(Side.CLIENT)
  boolean func_72806_N();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\IBlockAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */