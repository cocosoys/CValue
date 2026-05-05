package net.minecraftforge.common;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public interface IPlantable {
  EnumPlantType getPlantType(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3);
  
  Block getPlant(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3);
  
  int getPlantMetadata(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\IPlantable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */