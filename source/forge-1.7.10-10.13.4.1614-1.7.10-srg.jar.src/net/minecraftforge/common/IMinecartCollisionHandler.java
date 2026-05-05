package net.minecraftforge.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.AxisAlignedBB;

public interface IMinecartCollisionHandler {
  void onEntityCollision(EntityMinecart paramEntityMinecart, Entity paramEntity);
  
  AxisAlignedBB getCollisionBox(EntityMinecart paramEntityMinecart, Entity paramEntity);
  
  AxisAlignedBB getMinecartCollisionBox(EntityMinecart paramEntityMinecart);
  
  AxisAlignedBB getBoundingBox(EntityMinecart paramEntityMinecart);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\IMinecartCollisionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */