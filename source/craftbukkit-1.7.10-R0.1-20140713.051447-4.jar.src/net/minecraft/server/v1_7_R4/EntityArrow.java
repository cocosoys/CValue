/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.entity.EntityCombustByEntityEvent;
/*     */ import org.bukkit.event.player.PlayerPickupItemEvent;
/*     */ import org.bukkit.projectiles.ProjectileSource;
/*     */ 
/*     */ public class EntityArrow extends Entity implements IProjectile {
/*  13 */   private int d = -1;
/*  14 */   private int e = -1;
/*  15 */   private int f = -1;
/*     */   private Block g;
/*     */   private int h;
/*     */   private boolean inGround;
/*     */   public int fromPlayer;
/*     */   public int shake;
/*     */   public Entity shooter;
/*     */   private int at;
/*     */   private int au;
/*  24 */   private double damage = 2.0D;
/*     */   public int knockbackStrength;
/*     */   
/*     */   public EntityArrow(World world) {
/*  28 */     super(world);
/*  29 */     this.j = 10.0D;
/*  30 */     a(0.5F, 0.5F);
/*     */   }
/*     */   
/*     */   public EntityArrow(World world, double d0, double d1, double d2) {
/*  34 */     super(world);
/*  35 */     this.j = 10.0D;
/*  36 */     a(0.5F, 0.5F);
/*  37 */     setPosition(d0, d1, d2);
/*  38 */     this.height = 0.0F;
/*     */   }
/*     */   
/*     */   public EntityArrow(World world, EntityLiving entityliving, EntityLiving entityliving1, float f, float f1) {
/*  42 */     super(world);
/*  43 */     this.j = 10.0D;
/*  44 */     this.shooter = entityliving;
/*  45 */     this.projectileSource = (ProjectileSource)entityliving.getBukkitEntity();
/*  46 */     if (entityliving instanceof EntityHuman) {
/*  47 */       this.fromPlayer = 1;
/*     */     }
/*     */     
/*  50 */     this.locY = entityliving.locY + entityliving.getHeadHeight() - 0.10000000149011612D;
/*  51 */     double d0 = entityliving1.locX - entityliving.locX;
/*  52 */     double d1 = entityliving1.boundingBox.b + (entityliving1.length / 3.0F) - this.locY;
/*  53 */     double d2 = entityliving1.locZ - entityliving.locZ;
/*  54 */     double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
/*     */     
/*  56 */     if (d3 >= 1.0E-7D) {
/*  57 */       float f2 = (float)(Math.atan2(d2, d0) * 180.0D / 3.1415927410125732D) - 90.0F;
/*  58 */       float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / 3.1415927410125732D);
/*  59 */       double d4 = d0 / d3;
/*  60 */       double d5 = d2 / d3;
/*     */       
/*  62 */       setPositionRotation(entityliving.locX + d4, this.locY, entityliving.locZ + d5, f2, f3);
/*  63 */       this.height = 0.0F;
/*  64 */       float f4 = (float)d3 * 0.2F;
/*     */       
/*  66 */       shoot(d0, d1 + f4, d2, f, f1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public EntityArrow(World world, EntityLiving entityliving, float f) {
/*  71 */     super(world);
/*  72 */     this.j = 10.0D;
/*  73 */     this.shooter = entityliving;
/*  74 */     this.projectileSource = (ProjectileSource)entityliving.getBukkitEntity();
/*  75 */     if (entityliving instanceof EntityHuman) {
/*  76 */       this.fromPlayer = 1;
/*     */     }
/*     */     
/*  79 */     a(0.5F, 0.5F);
/*  80 */     setPositionRotation(entityliving.locX, entityliving.locY + entityliving.getHeadHeight(), entityliving.locZ, entityliving.yaw, entityliving.pitch);
/*  81 */     this.locX -= (MathHelper.cos(this.yaw / 180.0F * 3.1415927F) * 0.16F);
/*  82 */     this.locY -= 0.10000000149011612D;
/*  83 */     this.locZ -= (MathHelper.sin(this.yaw / 180.0F * 3.1415927F) * 0.16F);
/*  84 */     setPosition(this.locX, this.locY, this.locZ);
/*  85 */     this.height = 0.0F;
/*  86 */     this.motX = (-MathHelper.sin(this.yaw / 180.0F * 3.1415927F) * MathHelper.cos(this.pitch / 180.0F * 3.1415927F));
/*  87 */     this.motZ = (MathHelper.cos(this.yaw / 180.0F * 3.1415927F) * MathHelper.cos(this.pitch / 180.0F * 3.1415927F));
/*  88 */     this.motY = -MathHelper.sin(this.pitch / 180.0F * 3.1415927F);
/*  89 */     shoot(this.motX, this.motY, this.motZ, f * 1.5F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void c() {
/*  93 */     this.datawatcher.a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public void shoot(double d0, double d1, double d2, float f, float f1) {
/*  97 */     float f2 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
/*     */     
/*  99 */     d0 /= f2;
/* 100 */     d1 /= f2;
/* 101 */     d2 /= f2;
/* 102 */     d0 += this.random.nextGaussian() * (this.random.nextBoolean() ? -1 : true) * 0.007499999832361937D * f1;
/* 103 */     d1 += this.random.nextGaussian() * (this.random.nextBoolean() ? -1 : true) * 0.007499999832361937D * f1;
/* 104 */     d2 += this.random.nextGaussian() * (this.random.nextBoolean() ? -1 : true) * 0.007499999832361937D * f1;
/* 105 */     d0 *= f;
/* 106 */     d1 *= f;
/* 107 */     d2 *= f;
/* 108 */     this.motX = d0;
/* 109 */     this.motY = d1;
/* 110 */     this.motZ = d2;
/* 111 */     float f3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
/*     */     
/* 113 */     this.lastYaw = this.yaw = (float)(Math.atan2(d0, d2) * 180.0D / 3.1415927410125732D);
/* 114 */     this.lastPitch = this.pitch = (float)(Math.atan2(d1, f3) * 180.0D / 3.1415927410125732D);
/* 115 */     this.at = 0;
/*     */   }
/*     */   
/*     */   public void h() {
/* 119 */     super.h();
/* 120 */     if (this.lastPitch == 0.0F && this.lastYaw == 0.0F) {
/* 121 */       float f = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/*     */       
/* 123 */       this.lastYaw = this.yaw = (float)(Math.atan2(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);
/* 124 */       this.lastPitch = this.pitch = (float)(Math.atan2(this.motY, f) * 180.0D / 3.1415927410125732D);
/*     */     } 
/*     */     
/* 127 */     Block block = this.world.getType(this.d, this.e, this.f);
/*     */     
/* 129 */     if (block.getMaterial() != Material.AIR) {
/* 130 */       block.updateShape(this.world, this.d, this.e, this.f);
/* 131 */       AxisAlignedBB axisalignedbb = block.a(this.world, this.d, this.e, this.f);
/*     */       
/* 133 */       if (axisalignedbb != null && axisalignedbb.a(Vec3D.a(this.locX, this.locY, this.locZ))) {
/* 134 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 138 */     if (this.shake > 0) {
/* 139 */       this.shake--;
/*     */     }
/*     */     
/* 142 */     if (this.inGround) {
/* 143 */       int i = this.world.getData(this.d, this.e, this.f);
/*     */       
/* 145 */       if (block == this.g && i == this.h) {
/* 146 */         this.at++;
/* 147 */         if (this.at == 1200) {
/* 148 */           die();
/*     */         }
/*     */       } else {
/* 151 */         this.inGround = false;
/* 152 */         this.motX *= (this.random.nextFloat() * 0.2F);
/* 153 */         this.motY *= (this.random.nextFloat() * 0.2F);
/* 154 */         this.motZ *= (this.random.nextFloat() * 0.2F);
/* 155 */         this.at = 0;
/* 156 */         this.au = 0;
/*     */       } 
/*     */     } else {
/* 159 */       this.au++;
/* 160 */       Vec3D vec3d = Vec3D.a(this.locX, this.locY, this.locZ);
/* 161 */       Vec3D vec3d1 = Vec3D.a(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
/* 162 */       MovingObjectPosition movingobjectposition = this.world.rayTrace(vec3d, vec3d1, false, true, false);
/*     */       
/* 164 */       vec3d = Vec3D.a(this.locX, this.locY, this.locZ);
/* 165 */       vec3d1 = Vec3D.a(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
/* 166 */       if (movingobjectposition != null) {
/* 167 */         vec3d1 = Vec3D.a(movingobjectposition.pos.a, movingobjectposition.pos.b, movingobjectposition.pos.c);
/*     */       }
/*     */       
/* 170 */       Entity entity = null;
/* 171 */       List<Entity> list = this.world.getEntities(this, this.boundingBox.a(this.motX, this.motY, this.motZ).grow(1.0D, 1.0D, 1.0D));
/* 172 */       double d0 = 0.0D;
/*     */ 
/*     */       
/*     */       int j;
/*     */       
/* 177 */       for (j = 0; j < list.size(); j++) {
/* 178 */         Entity entity1 = list.get(j);
/*     */         
/* 180 */         if (entity1.R() && (entity1 != this.shooter || this.au >= 5)) {
/* 181 */           float f = 0.3F;
/* 182 */           AxisAlignedBB axisalignedbb1 = entity1.boundingBox.grow(f, f, f);
/* 183 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.a(vec3d, vec3d1);
/*     */           
/* 185 */           if (movingobjectposition1 != null) {
/* 186 */             double d1 = vec3d.distanceSquared(movingobjectposition1.pos);
/*     */             
/* 188 */             if (d1 < d0 || d0 == 0.0D) {
/* 189 */               entity = entity1;
/* 190 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 196 */       if (entity != null) {
/* 197 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 200 */       if (movingobjectposition != null && movingobjectposition.entity != null && movingobjectposition.entity instanceof EntityHuman) {
/* 201 */         EntityHuman entityhuman = (EntityHuman)movingobjectposition.entity;
/*     */         
/* 203 */         if (entityhuman.abilities.isInvulnerable || (this.shooter instanceof EntityHuman && !((EntityHuman)this.shooter).a(entityhuman))) {
/* 204 */           movingobjectposition = null;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 211 */       if (movingobjectposition != null) {
/* 212 */         CraftEventFactory.callProjectileHitEvent(this);
/*     */         
/* 214 */         if (movingobjectposition.entity != null) {
/* 215 */           float f = MathHelper.sqrt(this.motX * this.motX + this.motY * this.motY + this.motZ * this.motZ);
/* 216 */           int k = MathHelper.f(f * this.damage);
/*     */           
/* 218 */           if (isCritical()) {
/* 219 */             k += this.random.nextInt(k / 2 + 2);
/*     */           }
/*     */           
/* 222 */           DamageSource damagesource = null;
/*     */           
/* 224 */           if (this.shooter == null) {
/* 225 */             damagesource = DamageSource.arrow(this, this);
/*     */           } else {
/* 227 */             damagesource = DamageSource.arrow(this, this.shooter);
/*     */           } 
/*     */ 
/*     */           
/* 231 */           if (movingobjectposition.entity.damageEntity(damagesource, k)) {
/* 232 */             if (isBurning() && !(movingobjectposition.entity instanceof EntityEnderman) && (!(movingobjectposition.entity instanceof EntityPlayer) || !(this.shooter instanceof EntityPlayer) || this.world.pvpMode)) {
/* 233 */               EntityCombustByEntityEvent combustEvent = new EntityCombustByEntityEvent((Entity)getBukkitEntity(), (Entity)entity.getBukkitEntity(), 5);
/* 234 */               Bukkit.getPluginManager().callEvent((Event)combustEvent);
/*     */               
/* 236 */               if (!combustEvent.isCancelled()) {
/* 237 */                 movingobjectposition.entity.setOnFire(combustEvent.getDuration());
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 243 */             if (movingobjectposition.entity instanceof EntityLiving) {
/* 244 */               EntityLiving entityliving = (EntityLiving)movingobjectposition.entity;
/*     */               
/* 246 */               if (!this.world.isStatic) {
/* 247 */                 entityliving.p(entityliving.aZ() + 1);
/*     */               }
/*     */               
/* 250 */               if (this.knockbackStrength > 0) {
/* 251 */                 float f3 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/* 252 */                 if (f3 > 0.0F) {
/* 253 */                   movingobjectposition.entity.g(this.motX * this.knockbackStrength * 0.6000000238418579D / f3, 0.1D, this.motZ * this.knockbackStrength * 0.6000000238418579D / f3);
/*     */                 }
/*     */               } 
/*     */               
/* 257 */               if (this.shooter != null && this.shooter instanceof EntityLiving) {
/* 258 */                 EnchantmentManager.a(entityliving, this.shooter);
/* 259 */                 EnchantmentManager.b((EntityLiving)this.shooter, entityliving);
/*     */               } 
/*     */               
/* 262 */               if (this.shooter != null && movingobjectposition.entity != this.shooter && movingobjectposition.entity instanceof EntityHuman && this.shooter instanceof EntityPlayer) {
/* 263 */                 ((EntityPlayer)this.shooter).playerConnection.sendPacket(new PacketPlayOutGameStateChange(6, 0.0F));
/*     */               }
/*     */             } 
/*     */             
/* 267 */             makeSound("random.bowhit", 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
/* 268 */             if (!(movingobjectposition.entity instanceof EntityEnderman)) {
/* 269 */               die();
/*     */             }
/*     */           } else {
/* 272 */             this.motX *= -0.10000000149011612D;
/* 273 */             this.motY *= -0.10000000149011612D;
/* 274 */             this.motZ *= -0.10000000149011612D;
/* 275 */             this.yaw += 180.0F;
/* 276 */             this.lastYaw += 180.0F;
/* 277 */             this.au = 0;
/*     */           } 
/*     */         } else {
/* 280 */           this.d = movingobjectposition.b;
/* 281 */           this.e = movingobjectposition.c;
/* 282 */           this.f = movingobjectposition.d;
/* 283 */           this.g = this.world.getType(this.d, this.e, this.f);
/* 284 */           this.h = this.world.getData(this.d, this.e, this.f);
/* 285 */           this.motX = (float)(movingobjectposition.pos.a - this.locX);
/* 286 */           this.motY = (float)(movingobjectposition.pos.b - this.locY);
/* 287 */           this.motZ = (float)(movingobjectposition.pos.c - this.locZ);
/* 288 */           float f = MathHelper.sqrt(this.motX * this.motX + this.motY * this.motY + this.motZ * this.motZ);
/* 289 */           this.locX -= this.motX / f * 0.05000000074505806D;
/* 290 */           this.locY -= this.motY / f * 0.05000000074505806D;
/* 291 */           this.locZ -= this.motZ / f * 0.05000000074505806D;
/* 292 */           makeSound("random.bowhit", 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
/* 293 */           this.inGround = true;
/* 294 */           this.shake = 7;
/* 295 */           setCritical(false);
/* 296 */           if (this.g.getMaterial() != Material.AIR) {
/* 297 */             this.g.a(this.world, this.d, this.e, this.f, this);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 302 */       if (isCritical()) {
/* 303 */         for (j = 0; j < 4; j++) {
/* 304 */           this.world.addParticle("crit", this.locX + this.motX * j / 4.0D, this.locY + this.motY * j / 4.0D, this.locZ + this.motZ * j / 4.0D, -this.motX, -this.motY + 0.2D, -this.motZ);
/*     */         }
/*     */       }
/*     */       
/* 308 */       this.locX += this.motX;
/* 309 */       this.locY += this.motY;
/* 310 */       this.locZ += this.motZ;
/* 311 */       float f2 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/* 312 */       this.yaw = (float)(Math.atan2(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);
/*     */       
/* 314 */       for (this.pitch = (float)(Math.atan2(this.motY, f2) * 180.0D / 3.1415927410125732D); this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */       
/* 318 */       while (this.pitch - this.lastPitch >= 180.0F) {
/* 319 */         this.lastPitch += 360.0F;
/*     */       }
/*     */       
/* 322 */       while (this.yaw - this.lastYaw < -180.0F) {
/* 323 */         this.lastYaw -= 360.0F;
/*     */       }
/*     */       
/* 326 */       while (this.yaw - this.lastYaw >= 180.0F) {
/* 327 */         this.lastYaw += 360.0F;
/*     */       }
/*     */       
/* 330 */       this.pitch = this.lastPitch + (this.pitch - this.lastPitch) * 0.2F;
/* 331 */       this.yaw = this.lastYaw + (this.yaw - this.lastYaw) * 0.2F;
/* 332 */       float f4 = 0.99F;
/*     */       
/* 334 */       float f1 = 0.05F;
/* 335 */       if (M()) {
/* 336 */         for (int l = 0; l < 4; l++) {
/* 337 */           float f3 = 0.25F;
/* 338 */           this.world.addParticle("bubble", this.locX - this.motX * f3, this.locY - this.motY * f3, this.locZ - this.motZ * f3, this.motX, this.motY, this.motZ);
/*     */         } 
/*     */         
/* 341 */         f4 = 0.8F;
/*     */       } 
/*     */       
/* 344 */       if (L()) {
/* 345 */         extinguish();
/*     */       }
/*     */       
/* 348 */       this.motX *= f4;
/* 349 */       this.motY *= f4;
/* 350 */       this.motZ *= f4;
/* 351 */       this.motY -= f1;
/* 352 */       setPosition(this.locX, this.locY, this.locZ);
/* 353 */       I();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/* 358 */     nbttagcompound.setShort("xTile", (short)this.d);
/* 359 */     nbttagcompound.setShort("yTile", (short)this.e);
/* 360 */     nbttagcompound.setShort("zTile", (short)this.f);
/* 361 */     nbttagcompound.setShort("life", (short)this.at);
/* 362 */     nbttagcompound.setByte("inTile", (byte)Block.getId(this.g));
/* 363 */     nbttagcompound.setByte("inData", (byte)this.h);
/* 364 */     nbttagcompound.setByte("shake", (byte)this.shake);
/* 365 */     nbttagcompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
/* 366 */     nbttagcompound.setByte("pickup", (byte)this.fromPlayer);
/* 367 */     nbttagcompound.setDouble("damage", this.damage);
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 371 */     this.d = nbttagcompound.getShort("xTile");
/* 372 */     this.e = nbttagcompound.getShort("yTile");
/* 373 */     this.f = nbttagcompound.getShort("zTile");
/* 374 */     this.at = nbttagcompound.getShort("life");
/* 375 */     this.g = Block.getById(nbttagcompound.getByte("inTile") & 0xFF);
/* 376 */     this.h = nbttagcompound.getByte("inData") & 0xFF;
/* 377 */     this.shake = nbttagcompound.getByte("shake") & 0xFF;
/* 378 */     this.inGround = (nbttagcompound.getByte("inGround") == 1);
/* 379 */     if (nbttagcompound.hasKeyOfType("damage", 99)) {
/* 380 */       this.damage = nbttagcompound.getDouble("damage");
/*     */     }
/*     */     
/* 383 */     if (nbttagcompound.hasKeyOfType("pickup", 99)) {
/* 384 */       this.fromPlayer = nbttagcompound.getByte("pickup");
/* 385 */     } else if (nbttagcompound.hasKeyOfType("player", 99)) {
/* 386 */       this.fromPlayer = nbttagcompound.getBoolean("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void b_(EntityHuman entityhuman) {
/* 391 */     if (!this.world.isStatic && this.inGround && this.shake <= 0) {
/*     */       
/* 393 */       ItemStack itemstack = new ItemStack(Items.ARROW);
/* 394 */       if (this.fromPlayer == 1 && entityhuman.inventory.canHold(itemstack) > 0) {
/* 395 */         EntityItem item = new EntityItem(this.world, this.locX, this.locY, this.locZ, itemstack);
/*     */         
/* 397 */         PlayerPickupItemEvent event = new PlayerPickupItemEvent((Player)entityhuman.getBukkitEntity(), (Item)new CraftItem(this.world.getServer(), this, item), 0);
/*     */         
/* 399 */         this.world.getServer().getPluginManager().callEvent((Event)event);
/*     */         
/* 401 */         if (event.isCancelled()) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 407 */       boolean flag = (this.fromPlayer == 1 || (this.fromPlayer == 2 && entityhuman.abilities.canInstantlyBuild));
/*     */       
/* 409 */       if (this.fromPlayer == 1 && !entityhuman.inventory.pickup(new ItemStack(Items.ARROW, 1))) {
/* 410 */         flag = false;
/*     */       }
/*     */       
/* 413 */       if (flag) {
/* 414 */         makeSound("random.pop", 0.2F, ((this.random.nextFloat() - this.random.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 415 */         entityhuman.receive(this, 1);
/* 416 */         die();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean g_() {
/* 422 */     return false;
/*     */   }
/*     */   
/*     */   public void b(double d0) {
/* 426 */     this.damage = d0;
/*     */   }
/*     */   
/*     */   public double e() {
/* 430 */     return this.damage;
/*     */   }
/*     */   
/*     */   public void setKnockbackStrength(int i) {
/* 434 */     this.knockbackStrength = i;
/*     */   }
/*     */   
/*     */   public boolean av() {
/* 438 */     return false;
/*     */   }
/*     */   
/*     */   public void setCritical(boolean flag) {
/* 442 */     byte b0 = this.datawatcher.getByte(16);
/*     */     
/* 444 */     if (flag) {
/* 445 */       this.datawatcher.watch(16, Byte.valueOf((byte)(b0 | 0x1)));
/*     */     } else {
/* 447 */       this.datawatcher.watch(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCritical() {
/* 452 */     byte b0 = this.datawatcher.getByte(16);
/*     */     
/* 454 */     return ((b0 & 0x1) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInGround() {
/* 459 */     return this.inGround;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */