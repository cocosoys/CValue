package org.bukkit.entity;

import java.util.List;
import java.util.UUID;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.Metadatable;
import org.bukkit.util.Vector;

public interface Entity extends Metadatable {
  Location getLocation();
  
  Location getLocation(Location paramLocation);
  
  void setVelocity(Vector paramVector);
  
  Vector getVelocity();
  
  boolean isOnGround();
  
  World getWorld();
  
  boolean teleport(Location paramLocation);
  
  boolean teleport(Location paramLocation, PlayerTeleportEvent.TeleportCause paramTeleportCause);
  
  boolean teleport(Entity paramEntity);
  
  boolean teleport(Entity paramEntity, PlayerTeleportEvent.TeleportCause paramTeleportCause);
  
  List<Entity> getNearbyEntities(double paramDouble1, double paramDouble2, double paramDouble3);
  
  int getEntityId();
  
  int getFireTicks();
  
  int getMaxFireTicks();
  
  void setFireTicks(int paramInt);
  
  void remove();
  
  boolean isDead();
  
  boolean isValid();
  
  Server getServer();
  
  Entity getPassenger();
  
  boolean setPassenger(Entity paramEntity);
  
  boolean isEmpty();
  
  boolean eject();
  
  float getFallDistance();
  
  void setFallDistance(float paramFloat);
  
  void setLastDamageCause(EntityDamageEvent paramEntityDamageEvent);
  
  EntityDamageEvent getLastDamageCause();
  
  UUID getUniqueId();
  
  int getTicksLived();
  
  void setTicksLived(int paramInt);
  
  void playEffect(EntityEffect paramEntityEffect);
  
  EntityType getType();
  
  boolean isInsideVehicle();
  
  boolean leaveVehicle();
  
  Entity getVehicle();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Entity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */