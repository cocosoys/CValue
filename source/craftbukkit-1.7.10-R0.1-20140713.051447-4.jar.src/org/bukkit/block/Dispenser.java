package org.bukkit.block;

import org.bukkit.projectiles.BlockProjectileSource;

public interface Dispenser extends BlockState, ContainerBlock {
  BlockProjectileSource getBlockProjectileSource();
  
  boolean dispense();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\block\Dispenser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */