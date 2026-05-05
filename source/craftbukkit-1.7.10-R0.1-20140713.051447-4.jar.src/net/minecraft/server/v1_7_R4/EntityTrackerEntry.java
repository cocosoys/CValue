/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.player.PlayerVelocityEvent;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class EntityTrackerEntry
/*     */ {
/*  19 */   private static final Logger p = LogManager.getLogger();
/*     */   public Entity tracker;
/*     */   public int b;
/*     */   public int c;
/*     */   public int xLoc;
/*     */   public int yLoc;
/*     */   public int zLoc;
/*     */   public int yRot;
/*     */   public int xRot;
/*     */   public int i;
/*     */   public double j;
/*     */   public double k;
/*     */   public double l;
/*     */   public int m;
/*     */   private double q;
/*     */   private double r;
/*     */   private double s;
/*     */   private boolean isMoving;
/*     */   private boolean u;
/*     */   private int v;
/*     */   private Entity w;
/*     */   private boolean x;
/*     */   public boolean n;
/*  42 */   public Set trackedPlayers = new HashSet();
/*     */   
/*     */   public EntityTrackerEntry(Entity entity, int i, int j, boolean flag) {
/*  45 */     this.tracker = entity;
/*  46 */     this.b = i;
/*  47 */     this.c = j;
/*  48 */     this.u = flag;
/*  49 */     this.xLoc = MathHelper.floor(entity.locX * 32.0D);
/*  50 */     this.yLoc = MathHelper.floor(entity.locY * 32.0D);
/*  51 */     this.zLoc = MathHelper.floor(entity.locZ * 32.0D);
/*  52 */     this.yRot = MathHelper.d(entity.yaw * 256.0F / 360.0F);
/*  53 */     this.xRot = MathHelper.d(entity.pitch * 256.0F / 360.0F);
/*  54 */     this.i = MathHelper.d(entity.getHeadRotation() * 256.0F / 360.0F);
/*     */   }
/*     */   
/*     */   public boolean equals(Object object) {
/*  58 */     return (object instanceof EntityTrackerEntry) ? ((((EntityTrackerEntry)object).tracker.getId() == this.tracker.getId())) : false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  62 */     return this.tracker.getId();
/*     */   }
/*     */   
/*     */   public void track(List list) {
/*  66 */     this.n = false;
/*  67 */     if (!this.isMoving || this.tracker.e(this.q, this.r, this.s) > 16.0D) {
/*  68 */       this.q = this.tracker.locX;
/*  69 */       this.r = this.tracker.locY;
/*  70 */       this.s = this.tracker.locZ;
/*  71 */       this.isMoving = true;
/*  72 */       this.n = true;
/*  73 */       scanPlayers(list);
/*     */     } 
/*     */     
/*  76 */     if (this.w != this.tracker.vehicle || (this.tracker.vehicle != null && this.m % 60 == 0)) {
/*  77 */       this.w = this.tracker.vehicle;
/*  78 */       broadcast(new PacketPlayOutAttachEntity(0, this.tracker, this.tracker.vehicle));
/*     */     } 
/*     */     
/*  81 */     if (this.tracker instanceof EntityItemFrame) {
/*  82 */       EntityItemFrame i3 = (EntityItemFrame)this.tracker;
/*  83 */       ItemStack i4 = i3.getItem();
/*     */       
/*  85 */       if (this.m % 10 == 0 && i4 != null && i4.getItem() instanceof ItemWorldMap) {
/*  86 */         WorldMap i6 = Items.MAP.getSavedMap(i4, this.tracker.world);
/*  87 */         Iterator<EntityHuman> i7 = this.trackedPlayers.iterator();
/*     */         
/*  89 */         while (i7.hasNext()) {
/*  90 */           EntityHuman i8 = i7.next();
/*  91 */           EntityPlayer i9 = (EntityPlayer)i8;
/*     */           
/*  93 */           i6.a(i9, i4);
/*  94 */           Packet j0 = Items.MAP.c(i4, this.tracker.world, i9);
/*     */           
/*  96 */           if (j0 != null) {
/*  97 */             i9.playerConnection.sendPacket(j0);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 102 */       b();
/* 103 */     } else if (this.m % this.c == 0 || this.tracker.al || this.tracker.getDataWatcher().a()) {
/*     */ 
/*     */ 
/*     */       
/* 107 */       if (this.tracker.vehicle == null) {
/* 108 */         this.v++;
/* 109 */         int m = this.tracker.as.a(this.tracker.locX);
/* 110 */         int j = MathHelper.floor(this.tracker.locY * 32.0D);
/* 111 */         int k = this.tracker.as.a(this.tracker.locZ);
/* 112 */         int l = MathHelper.d(this.tracker.yaw * 256.0F / 360.0F);
/* 113 */         int i1 = MathHelper.d(this.tracker.pitch * 256.0F / 360.0F);
/* 114 */         int j1 = m - this.xLoc;
/* 115 */         int k1 = j - this.yLoc;
/* 116 */         int l1 = k - this.zLoc;
/* 117 */         Object object = null;
/* 118 */         boolean flag = (Math.abs(j1) >= 4 || Math.abs(k1) >= 4 || Math.abs(l1) >= 4 || this.m % 60 == 0);
/* 119 */         boolean flag1 = (Math.abs(l - this.yRot) >= 4 || Math.abs(i1 - this.xRot) >= 4);
/*     */ 
/*     */         
/* 122 */         if (flag) {
/* 123 */           this.xLoc = m;
/* 124 */           this.yLoc = j;
/* 125 */           this.zLoc = k;
/*     */         } 
/*     */         
/* 128 */         if (flag1) {
/* 129 */           this.yRot = l;
/* 130 */           this.xRot = i1;
/*     */         } 
/*     */ 
/*     */         
/* 134 */         if (this.m > 0 || this.tracker instanceof EntityArrow) {
/* 135 */           if (j1 >= -128 && j1 < 128 && k1 >= -128 && k1 < 128 && l1 >= -128 && l1 < 128 && this.v <= 400 && !this.x) {
/* 136 */             if (flag && flag1) {
/* 137 */               object = new PacketPlayOutRelEntityMoveLook(this.tracker.getId(), (byte)j1, (byte)k1, (byte)l1, (byte)l, (byte)i1);
/* 138 */             } else if (flag) {
/* 139 */               object = new PacketPlayOutRelEntityMove(this.tracker.getId(), (byte)j1, (byte)k1, (byte)l1);
/* 140 */             } else if (flag1) {
/* 141 */               object = new PacketPlayOutEntityLook(this.tracker.getId(), (byte)l, (byte)i1);
/*     */             } 
/*     */           } else {
/* 144 */             this.v = 0;
/*     */             
/* 146 */             if (this.tracker instanceof EntityPlayer) {
/* 147 */               scanPlayers(new ArrayList(this.trackedPlayers));
/*     */             }
/*     */             
/* 150 */             object = new PacketPlayOutEntityTeleport(this.tracker.getId(), m, j, k, (byte)l, (byte)i1);
/*     */           } 
/*     */         }
/*     */         
/* 154 */         if (this.u) {
/* 155 */           double d0 = this.tracker.motX - this.j;
/* 156 */           double d1 = this.tracker.motY - this.k;
/* 157 */           double d2 = this.tracker.motZ - this.l;
/* 158 */           double d3 = 0.02D;
/* 159 */           double d4 = d0 * d0 + d1 * d1 + d2 * d2;
/*     */           
/* 161 */           if (d4 > d3 * d3 || (d4 > 0.0D && this.tracker.motX == 0.0D && this.tracker.motY == 0.0D && this.tracker.motZ == 0.0D)) {
/* 162 */             this.j = this.tracker.motX;
/* 163 */             this.k = this.tracker.motY;
/* 164 */             this.l = this.tracker.motZ;
/* 165 */             broadcast(new PacketPlayOutEntityVelocity(this.tracker.getId(), this.j, this.k, this.l));
/*     */           } 
/*     */         } 
/*     */         
/* 169 */         if (object != null) {
/* 170 */           broadcast((Packet)object);
/*     */         }
/*     */         
/* 173 */         b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 187 */         this.x = false;
/*     */       } else {
/* 189 */         int k = MathHelper.d(this.tracker.yaw * 256.0F / 360.0F);
/* 190 */         int j = MathHelper.d(this.tracker.pitch * 256.0F / 360.0F);
/* 191 */         boolean flag2 = (Math.abs(k - this.yRot) >= 4 || Math.abs(j - this.xRot) >= 4);
/*     */         
/* 193 */         if (flag2) {
/* 194 */           broadcast(new PacketPlayOutEntityLook(this.tracker.getId(), (byte)k, (byte)j));
/* 195 */           this.yRot = k;
/* 196 */           this.xRot = j;
/*     */         } 
/*     */         
/* 199 */         this.xLoc = this.tracker.as.a(this.tracker.locX);
/* 200 */         this.yLoc = MathHelper.floor(this.tracker.locY * 32.0D);
/* 201 */         this.zLoc = this.tracker.as.a(this.tracker.locZ);
/* 202 */         b();
/* 203 */         this.x = true;
/*     */       } 
/*     */       
/* 206 */       int i = MathHelper.d(this.tracker.getHeadRotation() * 256.0F / 360.0F);
/* 207 */       if (Math.abs(i - this.i) >= 4) {
/* 208 */         broadcast(new PacketPlayOutEntityHeadRotation(this.tracker, (byte)i));
/* 209 */         this.i = i;
/*     */       } 
/*     */       
/* 212 */       this.tracker.al = false;
/*     */     } 
/*     */     
/* 215 */     this.m++;
/* 216 */     if (this.tracker.velocityChanged) {
/*     */       
/* 218 */       boolean cancelled = false;
/*     */       
/* 220 */       if (this.tracker instanceof EntityPlayer) {
/* 221 */         Player player = (Player)this.tracker.getBukkitEntity();
/* 222 */         Vector velocity = player.getVelocity();
/*     */         
/* 224 */         PlayerVelocityEvent event = new PlayerVelocityEvent(player, velocity);
/* 225 */         this.tracker.world.getServer().getPluginManager().callEvent((Event)event);
/*     */         
/* 227 */         if (event.isCancelled()) {
/* 228 */           cancelled = true;
/* 229 */         } else if (!velocity.equals(event.getVelocity())) {
/* 230 */           player.setVelocity(velocity);
/*     */         } 
/*     */       } 
/*     */       
/* 234 */       if (!cancelled) {
/* 235 */         broadcastIncludingSelf(new PacketPlayOutEntityVelocity(this.tracker));
/*     */       }
/*     */ 
/*     */       
/* 239 */       this.tracker.velocityChanged = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b() {
/* 244 */     DataWatcher datawatcher = this.tracker.getDataWatcher();
/*     */     
/* 246 */     if (datawatcher.a()) {
/* 247 */       broadcastIncludingSelf(new PacketPlayOutEntityMetadata(this.tracker.getId(), datawatcher, false));
/*     */     }
/*     */     
/* 250 */     if (this.tracker instanceof EntityLiving) {
/* 251 */       AttributeMapServer attributemapserver = (AttributeMapServer)((EntityLiving)this.tracker).getAttributeMap();
/* 252 */       Set set = attributemapserver.getAttributes();
/*     */       
/* 254 */       if (!set.isEmpty()) {
/*     */         
/* 256 */         if (this.tracker instanceof EntityPlayer) {
/* 257 */           ((EntityPlayer)this.tracker).getBukkitEntity().injectScaledMaxHealth(set, false);
/*     */         }
/*     */         
/* 260 */         broadcastIncludingSelf(new PacketPlayOutUpdateAttributes(this.tracker.getId(), set));
/*     */       } 
/*     */       
/* 263 */       set.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void broadcast(Packet packet) {
/* 268 */     Iterator<EntityPlayer> iterator = this.trackedPlayers.iterator();
/*     */     
/* 270 */     while (iterator.hasNext()) {
/* 271 */       EntityPlayer entityplayer = iterator.next();
/*     */       
/* 273 */       entityplayer.playerConnection.sendPacket(packet);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void broadcastIncludingSelf(Packet packet) {
/* 278 */     broadcast(packet);
/* 279 */     if (this.tracker instanceof EntityPlayer) {
/* 280 */       ((EntityPlayer)this.tracker).playerConnection.sendPacket(packet);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a() {
/* 285 */     Iterator<EntityPlayer> iterator = this.trackedPlayers.iterator();
/*     */     
/* 287 */     while (iterator.hasNext()) {
/* 288 */       EntityPlayer entityplayer = iterator.next();
/*     */       
/* 290 */       entityplayer.d(this.tracker);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(EntityPlayer entityplayer) {
/* 295 */     if (this.trackedPlayers.contains(entityplayer)) {
/* 296 */       entityplayer.d(this.tracker);
/* 297 */       this.trackedPlayers.remove(entityplayer);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updatePlayer(EntityPlayer entityplayer) {
/* 302 */     if (entityplayer != this.tracker) {
/* 303 */       double d0 = entityplayer.locX - (this.xLoc / 32);
/* 304 */       double d1 = entityplayer.locZ - (this.zLoc / 32);
/*     */       
/* 306 */       if (d0 >= -this.b && d0 <= this.b && d1 >= -this.b && d1 <= this.b) {
/* 307 */         if (!this.trackedPlayers.contains(entityplayer) && (d(entityplayer) || this.tracker.attachedToPlayer)) {
/*     */           
/* 309 */           if (this.tracker instanceof EntityPlayer) {
/* 310 */             CraftPlayer craftPlayer = ((EntityPlayer)this.tracker).getBukkitEntity();
/* 311 */             if (!entityplayer.getBukkitEntity().canSee((Player)craftPlayer)) {
/*     */               return;
/*     */             }
/*     */           } 
/*     */           
/* 316 */           entityplayer.removeQueue.remove(Integer.valueOf(this.tracker.getId()));
/*     */ 
/*     */           
/* 319 */           this.trackedPlayers.add(entityplayer);
/* 320 */           Packet packet = c();
/*     */           
/* 322 */           entityplayer.playerConnection.sendPacket(packet);
/* 323 */           if (!this.tracker.getDataWatcher().d()) {
/* 324 */             entityplayer.playerConnection.sendPacket(new PacketPlayOutEntityMetadata(this.tracker.getId(), this.tracker.getDataWatcher(), true));
/*     */           }
/*     */           
/* 327 */           if (this.tracker instanceof EntityLiving) {
/* 328 */             AttributeMapServer attributemapserver = (AttributeMapServer)((EntityLiving)this.tracker).getAttributeMap();
/* 329 */             Collection collection = attributemapserver.c();
/*     */ 
/*     */             
/* 332 */             if (this.tracker.getId() == entityplayer.getId()) {
/* 333 */               ((EntityPlayer)this.tracker).getBukkitEntity().injectScaledMaxHealth(collection, false);
/*     */             }
/*     */             
/* 336 */             if (!collection.isEmpty()) {
/* 337 */               entityplayer.playerConnection.sendPacket(new PacketPlayOutUpdateAttributes(this.tracker.getId(), collection));
/*     */             }
/*     */           } 
/*     */           
/* 341 */           this.j = this.tracker.motX;
/* 342 */           this.k = this.tracker.motY;
/* 343 */           this.l = this.tracker.motZ;
/* 344 */           if (this.u && !(packet instanceof PacketPlayOutSpawnEntityLiving)) {
/* 345 */             entityplayer.playerConnection.sendPacket(new PacketPlayOutEntityVelocity(this.tracker.getId(), this.tracker.motX, this.tracker.motY, this.tracker.motZ));
/*     */           }
/*     */           
/* 348 */           if (this.tracker.vehicle != null) {
/* 349 */             entityplayer.playerConnection.sendPacket(new PacketPlayOutAttachEntity(0, this.tracker, this.tracker.vehicle));
/*     */           }
/*     */ 
/*     */           
/* 353 */           if (this.tracker.passenger != null) {
/* 354 */             entityplayer.playerConnection.sendPacket(new PacketPlayOutAttachEntity(0, this.tracker.passenger, this.tracker));
/*     */           }
/*     */ 
/*     */           
/* 358 */           if (this.tracker instanceof EntityInsentient && ((EntityInsentient)this.tracker).getLeashHolder() != null) {
/* 359 */             entityplayer.playerConnection.sendPacket(new PacketPlayOutAttachEntity(1, this.tracker, ((EntityInsentient)this.tracker).getLeashHolder()));
/*     */           }
/*     */           
/* 362 */           if (this.tracker instanceof EntityLiving) {
/* 363 */             for (int i = 0; i < 5; i++) {
/* 364 */               ItemStack itemstack = ((EntityLiving)this.tracker).getEquipment(i);
/*     */               
/* 366 */               if (itemstack != null) {
/* 367 */                 entityplayer.playerConnection.sendPacket(new PacketPlayOutEntityEquipment(this.tracker.getId(), i, itemstack));
/*     */               }
/*     */             } 
/*     */           }
/*     */           
/* 372 */           if (this.tracker instanceof EntityHuman) {
/* 373 */             EntityHuman entityhuman = (EntityHuman)this.tracker;
/*     */             
/* 375 */             if (entityhuman.isSleeping()) {
/* 376 */               entityplayer.playerConnection.sendPacket(new PacketPlayOutBed(entityhuman, MathHelper.floor(this.tracker.locX), MathHelper.floor(this.tracker.locY), MathHelper.floor(this.tracker.locZ)));
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 381 */           this.i = MathHelper.d(this.tracker.getHeadRotation() * 256.0F / 360.0F);
/* 382 */           broadcast(new PacketPlayOutEntityHeadRotation(this.tracker, (byte)this.i));
/*     */ 
/*     */           
/* 385 */           if (this.tracker instanceof EntityLiving) {
/* 386 */             EntityLiving entityliving = (EntityLiving)this.tracker;
/* 387 */             Iterator<MobEffect> iterator = entityliving.getEffects().iterator();
/*     */             
/* 389 */             while (iterator.hasNext()) {
/* 390 */               MobEffect mobeffect = iterator.next();
/*     */               
/* 392 */               entityplayer.playerConnection.sendPacket(new PacketPlayOutEntityEffect(this.tracker.getId(), mobeffect));
/*     */             } 
/*     */           } 
/*     */         } 
/* 396 */       } else if (this.trackedPlayers.contains(entityplayer)) {
/* 397 */         this.trackedPlayers.remove(entityplayer);
/* 398 */         entityplayer.d(this.tracker);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean d(EntityPlayer entityplayer) {
/* 404 */     return entityplayer.r().getPlayerChunkMap().a(entityplayer, this.tracker.ah, this.tracker.aj);
/*     */   }
/*     */   
/*     */   public void scanPlayers(List<EntityPlayer> list) {
/* 408 */     for (int i = 0; i < list.size(); i++) {
/* 409 */       updatePlayer(list.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private Packet c() {
/* 414 */     if (this.tracker.dead)
/*     */     {
/*     */       
/* 417 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 421 */     if (this.tracker instanceof EntityItem)
/* 422 */       return new PacketPlayOutSpawnEntity(this.tracker, 2, 1); 
/* 423 */     if (this.tracker instanceof EntityPlayer)
/* 424 */       return new PacketPlayOutNamedEntitySpawn((EntityHuman)this.tracker); 
/* 425 */     if (this.tracker instanceof EntityMinecartAbstract) {
/* 426 */       EntityMinecartAbstract entityminecartabstract = (EntityMinecartAbstract)this.tracker;
/*     */       
/* 428 */       return new PacketPlayOutSpawnEntity(this.tracker, 10, entityminecartabstract.m());
/* 429 */     }  if (this.tracker instanceof EntityBoat)
/* 430 */       return new PacketPlayOutSpawnEntity(this.tracker, 1); 
/* 431 */     if (!(this.tracker instanceof IAnimal) && !(this.tracker instanceof EntityEnderDragon)) {
/* 432 */       if (this.tracker instanceof EntityFishingHook) {
/* 433 */         EntityHuman entityhuman = ((EntityFishingHook)this.tracker).owner;
/*     */         
/* 435 */         return new PacketPlayOutSpawnEntity(this.tracker, 90, (entityhuman != null) ? entityhuman.getId() : this.tracker.getId());
/* 436 */       }  if (this.tracker instanceof EntityArrow) {
/* 437 */         Entity entity = ((EntityArrow)this.tracker).shooter;
/*     */         
/* 439 */         return new PacketPlayOutSpawnEntity(this.tracker, 60, (entity != null) ? entity.getId() : this.tracker.getId());
/* 440 */       }  if (this.tracker instanceof EntitySnowball)
/* 441 */         return new PacketPlayOutSpawnEntity(this.tracker, 61); 
/* 442 */       if (this.tracker instanceof EntityPotion)
/* 443 */         return new PacketPlayOutSpawnEntity(this.tracker, 73, ((EntityPotion)this.tracker).getPotionValue()); 
/* 444 */       if (this.tracker instanceof EntityThrownExpBottle)
/* 445 */         return new PacketPlayOutSpawnEntity(this.tracker, 75); 
/* 446 */       if (this.tracker instanceof EntityEnderPearl)
/* 447 */         return new PacketPlayOutSpawnEntity(this.tracker, 65); 
/* 448 */       if (this.tracker instanceof EntityEnderSignal)
/* 449 */         return new PacketPlayOutSpawnEntity(this.tracker, 72); 
/* 450 */       if (this.tracker instanceof EntityFireworks) {
/* 451 */         return new PacketPlayOutSpawnEntity(this.tracker, 76);
/*     */       }
/*     */ 
/*     */       
/* 455 */       if (this.tracker instanceof EntityFireball) {
/* 456 */         EntityFireball entityfireball = (EntityFireball)this.tracker;
/*     */         
/* 458 */         PacketPlayOutSpawnEntity packetplayoutspawnentity = null;
/* 459 */         byte b0 = 63;
/*     */         
/* 461 */         if (this.tracker instanceof EntitySmallFireball) {
/* 462 */           b0 = 64;
/* 463 */         } else if (this.tracker instanceof EntityWitherSkull) {
/* 464 */           b0 = 66;
/*     */         } 
/*     */         
/* 467 */         if (entityfireball.shooter != null) {
/* 468 */           packetplayoutspawnentity = new PacketPlayOutSpawnEntity(this.tracker, b0, ((EntityFireball)this.tracker).shooter.getId());
/*     */         } else {
/* 470 */           packetplayoutspawnentity = new PacketPlayOutSpawnEntity(this.tracker, b0, 0);
/*     */         } 
/*     */         
/* 473 */         packetplayoutspawnentity.d((int)(entityfireball.dirX * 8000.0D));
/* 474 */         packetplayoutspawnentity.e((int)(entityfireball.dirY * 8000.0D));
/* 475 */         packetplayoutspawnentity.f((int)(entityfireball.dirZ * 8000.0D));
/* 476 */         return packetplayoutspawnentity;
/* 477 */       }  if (this.tracker instanceof EntityEgg)
/* 478 */         return new PacketPlayOutSpawnEntity(this.tracker, 62); 
/* 479 */       if (this.tracker instanceof EntityTNTPrimed)
/* 480 */         return new PacketPlayOutSpawnEntity(this.tracker, 50); 
/* 481 */       if (this.tracker instanceof EntityEnderCrystal)
/* 482 */         return new PacketPlayOutSpawnEntity(this.tracker, 51); 
/* 483 */       if (this.tracker instanceof EntityFallingBlock) {
/* 484 */         EntityFallingBlock entityfallingblock = (EntityFallingBlock)this.tracker;
/*     */         
/* 486 */         return new PacketPlayOutSpawnEntity(this.tracker, 70, Block.getId(entityfallingblock.f()) | entityfallingblock.data << 16);
/* 487 */       }  if (this.tracker instanceof EntityPainting)
/* 488 */         return new PacketPlayOutSpawnEntityPainting((EntityPainting)this.tracker); 
/* 489 */       if (this.tracker instanceof EntityItemFrame) {
/* 490 */         EntityItemFrame entityitemframe = (EntityItemFrame)this.tracker;
/*     */         
/* 492 */         PacketPlayOutSpawnEntity packetplayoutspawnentity = new PacketPlayOutSpawnEntity(this.tracker, 71, entityitemframe.direction);
/* 493 */         packetplayoutspawnentity.a(MathHelper.d((entityitemframe.x * 32)));
/* 494 */         packetplayoutspawnentity.b(MathHelper.d((entityitemframe.y * 32)));
/* 495 */         packetplayoutspawnentity.c(MathHelper.d((entityitemframe.z * 32)));
/* 496 */         return packetplayoutspawnentity;
/* 497 */       }  if (this.tracker instanceof EntityLeash) {
/* 498 */         EntityLeash entityleash = (EntityLeash)this.tracker;
/*     */         
/* 500 */         PacketPlayOutSpawnEntity packetplayoutspawnentity = new PacketPlayOutSpawnEntity(this.tracker, 77);
/* 501 */         packetplayoutspawnentity.a(MathHelper.d((entityleash.x * 32)));
/* 502 */         packetplayoutspawnentity.b(MathHelper.d((entityleash.y * 32)));
/* 503 */         packetplayoutspawnentity.c(MathHelper.d((entityleash.z * 32)));
/* 504 */         return packetplayoutspawnentity;
/* 505 */       }  if (this.tracker instanceof EntityExperienceOrb) {
/* 506 */         return new PacketPlayOutSpawnEntityExperienceOrb((EntityExperienceOrb)this.tracker);
/*     */       }
/* 508 */       throw new IllegalArgumentException("Don't know how to add " + this.tracker.getClass() + "!");
/*     */     } 
/*     */ 
/*     */     
/* 512 */     this.i = MathHelper.d(this.tracker.getHeadRotation() * 256.0F / 360.0F);
/* 513 */     return new PacketPlayOutSpawnEntityLiving((EntityLiving)this.tracker);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear(EntityPlayer entityplayer) {
/* 518 */     if (this.trackedPlayers.contains(entityplayer)) {
/* 519 */       this.trackedPlayers.remove(entityplayer);
/* 520 */       entityplayer.d(this.tracker);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityTrackerEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */