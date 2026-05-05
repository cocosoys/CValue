package org.bukkit.projectiles;

import org.bukkit.util.Vector;

public interface ProjectileSource {
  <T extends org.bukkit.entity.Projectile> T launchProjectile(Class<? extends T> paramClass);
  
  <T extends org.bukkit.entity.Projectile> T launchProjectile(Class<? extends T> paramClass, Vector paramVector);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\projectiles\ProjectileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */