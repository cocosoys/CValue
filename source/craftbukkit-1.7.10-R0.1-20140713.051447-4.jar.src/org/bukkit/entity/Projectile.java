package org.bukkit.entity;

import org.bukkit.projectiles.ProjectileSource;

public interface Projectile extends Entity {
  @Deprecated
  LivingEntity getShooter();
  
  ProjectileSource getShooter();
  
  @Deprecated
  void setShooter(LivingEntity paramLivingEntity);
  
  void setShooter(ProjectileSource paramProjectileSource);
  
  boolean doesBounce();
  
  void setBounce(boolean paramBoolean);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Projectile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */