/*     */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.server.v1_7_R4.Entity;
/*     */ import net.minecraft.server.v1_7_R4.EntityArrow;
/*     */ import net.minecraft.server.v1_7_R4.EntityComplexPart;
/*     */ import net.minecraft.server.v1_7_R4.EntityMinecartCommandBlock;
/*     */ import net.minecraft.server.v1_7_R4.EntityMonster;
/*     */ import net.minecraft.server.v1_7_R4.EntityPainting;
/*     */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*     */ import net.minecraft.server.v1_7_R4.EntityPotion;
/*     */ import org.bukkit.EntityEffect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.player.PlayerTeleportEvent;
/*     */ import org.bukkit.metadata.MetadataValue;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public abstract class CraftEntity implements Entity {
/*     */   public CraftEntity(CraftServer server, Entity entity) {
/*  26 */     this.server = server;
/*  27 */     this.entity = entity;
/*     */   }
/*     */   protected final CraftServer server;
/*     */   protected Entity entity;
/*     */   private EntityDamageEvent lastDamageEvent;
/*     */   
/*     */   public static CraftEntity getEntity(CraftServer server, Entity entity) {
/*  34 */     if (entity instanceof EntityLiving)
/*     */     
/*  36 */     { if (entity instanceof EntityHuman) {
/*  37 */         if (entity instanceof EntityPlayer) return new CraftPlayer(server, (EntityPlayer)entity); 
/*  38 */         return new CraftHumanEntity(server, (EntityHuman)entity);
/*     */       } 
/*  40 */       if (entity instanceof EntityCreature)
/*     */       
/*  42 */       { if (entity instanceof EntityAnimal) {
/*  43 */           if (entity instanceof EntityChicken) return new CraftChicken(server, (EntityChicken)entity); 
/*  44 */           if (entity instanceof EntityCow) {
/*  45 */             if (entity instanceof EntityMushroomCow) return new CraftMushroomCow(server, (EntityMushroomCow)entity); 
/*  46 */             return new CraftCow(server, (EntityCow)entity);
/*     */           } 
/*  48 */           if (entity instanceof EntityPig) return new CraftPig(server, (EntityPig)entity); 
/*  49 */           if (entity instanceof net.minecraft.server.v1_7_R4.EntityTameableAnimal) {
/*  50 */             if (entity instanceof EntityWolf) return new CraftWolf(server, (EntityWolf)entity); 
/*  51 */             if (entity instanceof EntityOcelot) return new CraftOcelot(server, (EntityOcelot)entity); 
/*     */           } else {
/*  53 */             if (entity instanceof EntitySheep) return new CraftSheep(server, (EntitySheep)entity); 
/*  54 */             if (entity instanceof EntityHorse) return new CraftHorse(server, (EntityHorse)entity); 
/*  55 */             return new CraftAnimals(server, (EntityAnimal)entity);
/*     */           } 
/*     */         } else {
/*  58 */           if (entity instanceof EntityMonster) {
/*  59 */             if (entity instanceof EntityZombie) {
/*  60 */               if (entity instanceof EntityPigZombie) return new CraftPigZombie(server, (EntityPigZombie)entity); 
/*  61 */               return new CraftZombie(server, (EntityZombie)entity);
/*     */             } 
/*  63 */             if (entity instanceof EntityCreeper) return new CraftCreeper(server, (EntityCreeper)entity); 
/*  64 */             if (entity instanceof EntityEnderman) return new CraftEnderman(server, (EntityEnderman)entity); 
/*  65 */             if (entity instanceof EntitySilverfish) return new CraftSilverfish(server, (EntitySilverfish)entity); 
/*  66 */             if (entity instanceof EntityGiantZombie) return new CraftGiant(server, (EntityGiantZombie)entity); 
/*  67 */             if (entity instanceof EntitySkeleton) return new CraftSkeleton(server, (EntitySkeleton)entity); 
/*  68 */             if (entity instanceof EntityBlaze) return new CraftBlaze(server, (EntityBlaze)entity); 
/*  69 */             if (entity instanceof EntityWitch) return new CraftWitch(server, (EntityWitch)entity); 
/*  70 */             if (entity instanceof EntityWither) return new CraftWither(server, (EntityWither)entity); 
/*  71 */             if (entity instanceof EntitySpider) {
/*  72 */               if (entity instanceof EntityCaveSpider) return new CraftCaveSpider(server, (EntityCaveSpider)entity); 
/*  73 */               return new CraftSpider(server, (EntitySpider)entity);
/*     */             } 
/*     */             
/*  76 */             return new CraftMonster(server, (EntityMonster)entity);
/*     */           } 
/*     */           
/*  79 */           if (entity instanceof EntityWaterAnimal) {
/*  80 */             if (entity instanceof EntitySquid) return new CraftSquid(server, (EntitySquid)entity); 
/*  81 */             return new CraftWaterMob(server, (EntityWaterAnimal)entity);
/*     */           } 
/*  83 */           if (entity instanceof net.minecraft.server.v1_7_R4.EntityGolem) {
/*  84 */             if (entity instanceof EntitySnowman) return new CraftSnowman(server, (EntitySnowman)entity); 
/*  85 */             if (entity instanceof EntityIronGolem) return new CraftIronGolem(server, (EntityIronGolem)entity); 
/*     */           } else {
/*  87 */             if (entity instanceof EntityVillager) return new CraftVillager(server, (EntityVillager)entity); 
/*  88 */             return new CraftCreature(server, (EntityCreature)entity);
/*     */           } 
/*     */         }  }
/*  91 */       else { if (entity instanceof EntitySlime) {
/*  92 */           if (entity instanceof EntityMagmaCube) return new CraftMagmaCube(server, (EntityMagmaCube)entity); 
/*  93 */           return new CraftSlime(server, (EntitySlime)entity);
/*     */         } 
/*     */         
/*  96 */         if (entity instanceof EntityFlying) {
/*  97 */           if (entity instanceof EntityGhast) return new CraftGhast(server, (EntityGhast)entity); 
/*  98 */           return new CraftFlying(server, (EntityFlying)entity);
/*     */         } 
/* 100 */         if (entity instanceof EntityEnderDragon) {
/* 101 */           return new CraftEnderDragon(server, (EntityEnderDragon)entity);
/*     */         }
/*     */         
/* 104 */         if (entity instanceof EntityAmbient) {
/* 105 */           if (entity instanceof EntityBat) return new CraftBat(server, (EntityBat)entity); 
/* 106 */           return new CraftAmbient(server, (EntityAmbient)entity);
/*     */         } 
/* 108 */         return new CraftLivingEntity(server, (EntityLiving)entity); }
/*     */        }
/* 110 */     else { if (entity instanceof EntityComplexPart) {
/* 111 */         EntityComplexPart part = (EntityComplexPart)entity;
/* 112 */         if (part.owner instanceof EntityEnderDragon) return new CraftEnderDragonPart(server, (EntityComplexPart)entity); 
/* 113 */         return new CraftComplexPart(server, (EntityComplexPart)entity);
/*     */       } 
/* 115 */       if (entity instanceof EntityExperienceOrb) return new CraftExperienceOrb(server, (EntityExperienceOrb)entity); 
/* 116 */       if (entity instanceof EntityArrow) return new CraftArrow(server, (EntityArrow)entity); 
/* 117 */       if (entity instanceof EntityBoat) return new CraftBoat(server, (EntityBoat)entity); 
/* 118 */       if (entity instanceof net.minecraft.server.v1_7_R4.EntityProjectile) {
/* 119 */         if (entity instanceof EntityEgg) return new CraftEgg(server, (EntityEgg)entity); 
/* 120 */         if (entity instanceof EntitySnowball) return new CraftSnowball(server, (EntitySnowball)entity); 
/* 121 */         if (entity instanceof EntityPotion) return new CraftThrownPotion(server, (EntityPotion)entity); 
/* 122 */         if (entity instanceof EntityEnderPearl) return new CraftEnderPearl(server, (EntityEnderPearl)entity); 
/* 123 */         if (entity instanceof EntityThrownExpBottle) return new CraftThrownExpBottle(server, (EntityThrownExpBottle)entity); 
/*     */       } else {
/* 125 */         if (entity instanceof EntityFallingBlock) return new CraftFallingSand(server, (EntityFallingBlock)entity); 
/* 126 */         if (entity instanceof EntityFireball) {
/* 127 */           if (entity instanceof EntitySmallFireball) return new CraftSmallFireball(server, (EntitySmallFireball)entity); 
/* 128 */           if (entity instanceof EntityLargeFireball) return new CraftLargeFireball(server, (EntityLargeFireball)entity); 
/* 129 */           if (entity instanceof EntityWitherSkull) return new CraftWitherSkull(server, (EntityWitherSkull)entity); 
/* 130 */           return new CraftFireball(server, (EntityFireball)entity);
/*     */         } 
/* 132 */         if (entity instanceof EntityEnderSignal) return new CraftEnderSignal(server, (EntityEnderSignal)entity); 
/* 133 */         if (entity instanceof EntityEnderCrystal) return new CraftEnderCrystal(server, (EntityEnderCrystal)entity); 
/* 134 */         if (entity instanceof EntityFishingHook) return new CraftFish(server, (EntityFishingHook)entity); 
/* 135 */         if (entity instanceof EntityItem) return new CraftItem(server, (EntityItem)entity); 
/* 136 */         if (entity instanceof EntityWeather) {
/* 137 */           if (entity instanceof EntityLightning) return new CraftLightningStrike(server, (EntityLightning)entity); 
/* 138 */           return new CraftWeather(server, (EntityWeather)entity);
/*     */         } 
/* 140 */         if (entity instanceof EntityMinecartAbstract)
/* 141 */         { if (entity instanceof EntityMinecartFurnace) return new CraftMinecartFurnace(server, (EntityMinecartFurnace)entity); 
/* 142 */           if (entity instanceof EntityMinecartChest) return new CraftMinecartChest(server, (EntityMinecartChest)entity); 
/* 143 */           if (entity instanceof EntityMinecartTNT) return new CraftMinecartTNT(server, (EntityMinecartTNT)entity); 
/* 144 */           if (entity instanceof EntityMinecartHopper) return new CraftMinecartHopper(server, (EntityMinecartHopper)entity); 
/* 145 */           if (entity instanceof EntityMinecartMobSpawner) return new CraftMinecartMobSpawner(server, (EntityMinecartMobSpawner)entity); 
/* 146 */           if (entity instanceof net.minecraft.server.v1_7_R4.EntityMinecartRideable) return new CraftMinecartRideable(server, (EntityMinecartAbstract)entity); 
/* 147 */           if (entity instanceof EntityMinecartCommandBlock) return new CraftMinecartCommand(server, (EntityMinecartCommandBlock)entity);  }
/* 148 */         else { if (entity instanceof EntityHanging) {
/* 149 */             if (entity instanceof EntityPainting) return new CraftPainting(server, (EntityPainting)entity); 
/* 150 */             if (entity instanceof EntityItemFrame) return new CraftItemFrame(server, (EntityItemFrame)entity); 
/* 151 */             if (entity instanceof EntityLeash) return new CraftLeash(server, (EntityLeash)entity); 
/* 152 */             return new CraftHanging(server, (EntityHanging)entity);
/*     */           } 
/* 154 */           if (entity instanceof EntityTNTPrimed) return new CraftTNTPrimed(server, (EntityTNTPrimed)entity); 
/* 155 */           if (entity instanceof EntityFireworks) return new CraftFirework(server, (EntityFireworks)entity);  } 
/*     */       }  }
/* 157 */      throw new AssertionError(("Unknown entity " + entity == null) ? null : entity.getClass());
/*     */   }
/*     */   
/*     */   public Location getLocation() {
/* 161 */     return new Location(getWorld(), this.entity.locX, this.entity.locY, this.entity.locZ, this.entity.yaw, this.entity.pitch);
/*     */   }
/*     */   
/*     */   public Location getLocation(Location loc) {
/* 165 */     if (loc != null) {
/* 166 */       loc.setWorld(getWorld());
/* 167 */       loc.setX(this.entity.locX);
/* 168 */       loc.setY(this.entity.locY);
/* 169 */       loc.setZ(this.entity.locZ);
/* 170 */       loc.setYaw(this.entity.yaw);
/* 171 */       loc.setPitch(this.entity.pitch);
/*     */     } 
/*     */     
/* 174 */     return loc;
/*     */   }
/*     */   
/*     */   public Vector getVelocity() {
/* 178 */     return new Vector(this.entity.motX, this.entity.motY, this.entity.motZ);
/*     */   }
/*     */   
/*     */   public void setVelocity(Vector vel) {
/* 182 */     this.entity.motX = vel.getX();
/* 183 */     this.entity.motY = vel.getY();
/* 184 */     this.entity.motZ = vel.getZ();
/* 185 */     this.entity.velocityChanged = true;
/*     */   }
/*     */   
/*     */   public boolean isOnGround() {
/* 189 */     if (this.entity instanceof EntityArrow) {
/* 190 */       return ((EntityArrow)this.entity).isInGround();
/*     */     }
/* 192 */     return this.entity.onGround;
/*     */   }
/*     */   
/*     */   public World getWorld() {
/* 196 */     return (World)this.entity.world.getWorld();
/*     */   }
/*     */   
/*     */   public boolean teleport(Location location) {
/* 200 */     return teleport(location, PlayerTeleportEvent.TeleportCause.PLUGIN);
/*     */   }
/*     */   
/*     */   public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
/* 204 */     if (this.entity.vehicle != null || this.entity.passenger != null || this.entity.dead) {
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     this.entity.world = (World)((CraftWorld)location.getWorld()).getHandle();
/* 209 */     this.entity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
/*     */     
/* 211 */     return true;
/*     */   }
/*     */   
/*     */   public boolean teleport(Entity destination) {
/* 215 */     return teleport(destination.getLocation());
/*     */   }
/*     */   
/*     */   public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
/* 219 */     return teleport(destination.getLocation(), cause);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Entity> getNearbyEntities(double x, double y, double z) {
/* 224 */     List<Entity> notchEntityList = this.entity.world.getEntities(this.entity, this.entity.boundingBox.grow(x, y, z));
/* 225 */     List<Entity> bukkitEntityList = new ArrayList<Entity>(notchEntityList.size());
/*     */     
/* 227 */     for (Entity e : notchEntityList) {
/* 228 */       bukkitEntityList.add(e.getBukkitEntity());
/*     */     }
/* 230 */     return bukkitEntityList;
/*     */   }
/*     */   
/*     */   public int getEntityId() {
/* 234 */     return this.entity.getId();
/*     */   }
/*     */   
/*     */   public int getFireTicks() {
/* 238 */     return this.entity.fireTicks;
/*     */   }
/*     */   
/*     */   public int getMaxFireTicks() {
/* 242 */     return this.entity.maxFireTicks;
/*     */   }
/*     */   
/*     */   public void setFireTicks(int ticks) {
/* 246 */     this.entity.fireTicks = ticks;
/*     */   }
/*     */   
/*     */   public void remove() {
/* 250 */     this.entity.dead = true;
/*     */   }
/*     */   
/*     */   public boolean isDead() {
/* 254 */     return !this.entity.isAlive();
/*     */   }
/*     */   
/*     */   public boolean isValid() {
/* 258 */     return (this.entity.isAlive() && this.entity.valid);
/*     */   }
/*     */   
/*     */   public Server getServer() {
/* 262 */     return (Server)this.server;
/*     */   }
/*     */   
/*     */   public Vector getMomentum() {
/* 266 */     return getVelocity();
/*     */   }
/*     */   
/*     */   public void setMomentum(Vector value) {
/* 270 */     setVelocity(value);
/*     */   }
/*     */   
/*     */   public Entity getPassenger() {
/* 274 */     return isEmpty() ? null : (getHandle()).passenger.getBukkitEntity();
/*     */   }
/*     */   
/*     */   public boolean setPassenger(Entity passenger) {
/* 278 */     if (passenger instanceof CraftEntity) {
/* 279 */       ((CraftEntity)passenger).getHandle().setPassengerOf(getHandle());
/* 280 */       return true;
/*     */     } 
/* 282 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 287 */     return ((getHandle()).passenger == null);
/*     */   }
/*     */   
/*     */   public boolean eject() {
/* 291 */     if ((getHandle()).passenger == null) {
/* 292 */       return false;
/*     */     }
/*     */     
/* 295 */     (getHandle()).passenger.setPassengerOf(null);
/* 296 */     return true;
/*     */   }
/*     */   
/*     */   public float getFallDistance() {
/* 300 */     return (getHandle()).fallDistance;
/*     */   }
/*     */   
/*     */   public void setFallDistance(float distance) {
/* 304 */     (getHandle()).fallDistance = distance;
/*     */   }
/*     */   
/*     */   public void setLastDamageCause(EntityDamageEvent event) {
/* 308 */     this.lastDamageEvent = event;
/*     */   }
/*     */   
/*     */   public EntityDamageEvent getLastDamageCause() {
/* 312 */     return this.lastDamageEvent;
/*     */   }
/*     */   
/*     */   public UUID getUniqueId() {
/* 316 */     return (getHandle()).uniqueID;
/*     */   }
/*     */   
/*     */   public int getTicksLived() {
/* 320 */     return (getHandle()).ticksLived;
/*     */   }
/*     */   
/*     */   public void setTicksLived(int value) {
/* 324 */     if (value <= 0) {
/* 325 */       throw new IllegalArgumentException("Age must be at least 1 tick");
/*     */     }
/* 327 */     (getHandle()).ticksLived = value;
/*     */   }
/*     */   
/*     */   public Entity getHandle() {
/* 331 */     return this.entity;
/*     */   }
/*     */   
/*     */   public void playEffect(EntityEffect type) {
/* 335 */     (getHandle()).world.broadcastEntityEffect(getHandle(), type.getData());
/*     */   }
/*     */   
/*     */   public void setHandle(Entity entity) {
/* 339 */     this.entity = entity;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 344 */     return "CraftEntity{id=" + getEntityId() + '}';
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 349 */     if (obj == null) {
/* 350 */       return false;
/*     */     }
/* 352 */     if (getClass() != obj.getClass()) {
/* 353 */       return false;
/*     */     }
/* 355 */     CraftEntity other = (CraftEntity)obj;
/* 356 */     return (getEntityId() == other.getEntityId());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 361 */     int hash = 7;
/* 362 */     hash = 29 * hash + getEntityId();
/* 363 */     return hash;
/*     */   }
/*     */   
/*     */   public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
/* 367 */     this.server.getEntityMetadata().setMetadata(this, metadataKey, newMetadataValue);
/*     */   }
/*     */   
/*     */   public List<MetadataValue> getMetadata(String metadataKey) {
/* 371 */     return this.server.getEntityMetadata().getMetadata(this, metadataKey);
/*     */   }
/*     */   
/*     */   public boolean hasMetadata(String metadataKey) {
/* 375 */     return this.server.getEntityMetadata().hasMetadata(this, metadataKey);
/*     */   }
/*     */   
/*     */   public void removeMetadata(String metadataKey, Plugin owningPlugin) {
/* 379 */     this.server.getEntityMetadata().removeMetadata(this, metadataKey, owningPlugin);
/*     */   }
/*     */   
/*     */   public boolean isInsideVehicle() {
/* 383 */     return ((getHandle()).vehicle != null);
/*     */   }
/*     */   
/*     */   public boolean leaveVehicle() {
/* 387 */     if ((getHandle()).vehicle == null) {
/* 388 */       return false;
/*     */     }
/*     */     
/* 391 */     getHandle().setPassengerOf(null);
/* 392 */     return true;
/*     */   }
/*     */   
/*     */   public Entity getVehicle() {
/* 396 */     if ((getHandle()).vehicle == null) {
/* 397 */       return null;
/*     */     }
/*     */     
/* 400 */     return (getHandle()).vehicle.getBukkitEntity();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */