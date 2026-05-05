/*     */ package org.bukkit.event.entity;
/*     */ 
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.entity.CreatureType;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.LivingEntity;
/*     */ import org.bukkit.event.Cancellable;
/*     */ import org.bukkit.event.HandlerList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreatureSpawnEvent
/*     */   extends EntityEvent
/*     */   implements Cancellable
/*     */ {
/*  16 */   private static final HandlerList handlers = new HandlerList();
/*     */   private boolean canceled;
/*     */   private final SpawnReason spawnReason;
/*     */   
/*     */   public CreatureSpawnEvent(LivingEntity spawnee, SpawnReason spawnReason) {
/*  21 */     super((Entity)spawnee);
/*  22 */     this.spawnReason = spawnReason;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public CreatureSpawnEvent(Entity spawnee, CreatureType type, Location loc, SpawnReason reason) {
/*  27 */     super(spawnee);
/*  28 */     this.spawnReason = reason;
/*     */   }
/*     */   
/*     */   public boolean isCancelled() {
/*  32 */     return this.canceled;
/*     */   }
/*     */   
/*     */   public void setCancelled(boolean cancel) {
/*  36 */     this.canceled = cancel;
/*     */   }
/*     */ 
/*     */   
/*     */   public LivingEntity getEntity() {
/*  41 */     return (LivingEntity)this.entity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Location getLocation() {
/*  50 */     return getEntity().getLocation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public CreatureType getCreatureType() {
/*  62 */     return CreatureType.fromEntityType(getEntityType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SpawnReason getSpawnReason() {
/*  72 */     return this.spawnReason;
/*     */   }
/*     */ 
/*     */   
/*     */   public HandlerList getHandlers() {
/*  77 */     return handlers;
/*     */   }
/*     */   
/*     */   public static HandlerList getHandlerList() {
/*  81 */     return handlers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum SpawnReason
/*     */   {
/*  92 */     NATURAL,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     JOCKEY,
/*     */ 
/*     */ 
/*     */     
/* 101 */     CHUNK_GEN,
/*     */ 
/*     */ 
/*     */     
/* 105 */     SPAWNER,
/*     */ 
/*     */ 
/*     */     
/* 109 */     EGG,
/*     */ 
/*     */ 
/*     */     
/* 113 */     SPAWNER_EGG,
/*     */ 
/*     */ 
/*     */     
/* 117 */     LIGHTNING,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     BED,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     BUILD_SNOWMAN,
/*     */ 
/*     */ 
/*     */     
/* 132 */     BUILD_IRONGOLEM,
/*     */ 
/*     */ 
/*     */     
/* 136 */     BUILD_WITHER,
/*     */ 
/*     */ 
/*     */     
/* 140 */     VILLAGE_DEFENSE,
/*     */ 
/*     */ 
/*     */     
/* 144 */     VILLAGE_INVASION,
/*     */ 
/*     */ 
/*     */     
/* 148 */     BREEDING,
/*     */ 
/*     */ 
/*     */     
/* 152 */     SLIME_SPLIT,
/*     */ 
/*     */ 
/*     */     
/* 156 */     REINFORCEMENTS,
/*     */ 
/*     */ 
/*     */     
/* 160 */     NETHER_PORTAL,
/*     */ 
/*     */ 
/*     */     
/* 164 */     DISPENSE_EGG,
/*     */ 
/*     */ 
/*     */     
/* 168 */     INFECTION,
/*     */ 
/*     */ 
/*     */     
/* 172 */     CURED,
/*     */ 
/*     */ 
/*     */     
/* 176 */     OCELOT_BABY,
/*     */ 
/*     */ 
/*     */     
/* 180 */     SILVERFISH_BLOCK,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     MOUNT,
/*     */ 
/*     */ 
/*     */     
/* 189 */     CUSTOM,
/*     */ 
/*     */ 
/*     */     
/* 193 */     DEFAULT;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\entity\CreatureSpawnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */