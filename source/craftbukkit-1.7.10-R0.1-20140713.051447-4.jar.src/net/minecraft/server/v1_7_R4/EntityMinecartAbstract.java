/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.util.List;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Vehicle;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.vehicle.VehicleDamageEvent;
/*     */ import org.bukkit.event.vehicle.VehicleDestroyEvent;
/*     */ import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
/*     */ import org.bukkit.event.vehicle.VehicleMoveEvent;
/*     */ import org.bukkit.event.vehicle.VehicleUpdateEvent;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public abstract class EntityMinecartAbstract extends Entity {
/*  18 */   private static final int[][][] matrix = new int[][][] { { { 0, 0, -1 }, { 0, 0, 1 } }, { { -1, 0, 0 }, { 1, 0, 0 } }, { { -1, -1, 0 }, { 1, 0, 0 } }, { { -1, 0, 0 }, { 1, -1, 0 } }, { { 0, 0, -1 }, { 0, -1, 1 } }, { { 0, -1, -1 }, { 0, 0, 1 } }, { { 0, 0, 1 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { 1, 0, 0 } } };
/*     */   private boolean a;
/*     */   private String b;
/*     */   private int d;
/*     */   private double e;
/*     */   private double f;
/*     */   private double g;
/*     */   private double h;
/*     */   private double i;
/*     */   public boolean slowWhenEmpty = true;
/*  28 */   private double derailedX = 0.5D;
/*  29 */   private double derailedY = 0.5D;
/*  30 */   private double derailedZ = 0.5D;
/*  31 */   private double flyingX = 0.95D;
/*  32 */   private double flyingY = 0.95D;
/*  33 */   private double flyingZ = 0.95D;
/*  34 */   public double maxSpeed = 0.4D;
/*     */ 
/*     */   
/*     */   public EntityMinecartAbstract(World world) {
/*  38 */     super(world);
/*  39 */     this.k = true;
/*  40 */     a(0.98F, 0.7F);
/*  41 */     this.height = this.length / 2.0F;
/*     */   }
/*     */   
/*     */   public static EntityMinecartAbstract a(World world, double d0, double d1, double d2, int i) {
/*  45 */     switch (i) {
/*     */       case 1:
/*  47 */         return new EntityMinecartChest(world, d0, d1, d2);
/*     */       
/*     */       case 2:
/*  50 */         return new EntityMinecartFurnace(world, d0, d1, d2);
/*     */       
/*     */       case 3:
/*  53 */         return new EntityMinecartTNT(world, d0, d1, d2);
/*     */       
/*     */       case 4:
/*  56 */         return new EntityMinecartMobSpawner(world, d0, d1, d2);
/*     */       
/*     */       case 5:
/*  59 */         return new EntityMinecartHopper(world, d0, d1, d2);
/*     */       
/*     */       case 6:
/*  62 */         return new EntityMinecartCommandBlock(world, d0, d1, d2);
/*     */     } 
/*     */     
/*  65 */     return new EntityMinecartRideable(world, d0, d1, d2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean g_() {
/*  70 */     return false;
/*     */   }
/*     */   
/*     */   protected void c() {
/*  74 */     this.datawatcher.a(17, new Integer(0));
/*  75 */     this.datawatcher.a(18, new Integer(1));
/*  76 */     this.datawatcher.a(19, new Float(0.0F));
/*  77 */     this.datawatcher.a(20, new Integer(0));
/*  78 */     this.datawatcher.a(21, new Integer(6));
/*  79 */     this.datawatcher.a(22, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public AxisAlignedBB h(Entity entity) {
/*  83 */     return entity.S() ? entity.boundingBox : null;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB J() {
/*  87 */     return null;
/*     */   }
/*     */   
/*     */   public boolean S() {
/*  91 */     return true;
/*     */   }
/*     */   
/*     */   public EntityMinecartAbstract(World world, double d0, double d1, double d2) {
/*  95 */     this(world);
/*  96 */     setPosition(d0, d1, d2);
/*  97 */     this.motX = 0.0D;
/*  98 */     this.motY = 0.0D;
/*  99 */     this.motZ = 0.0D;
/* 100 */     this.lastX = d0;
/* 101 */     this.lastY = d1;
/* 102 */     this.lastZ = d2;
/*     */     
/* 104 */     this.world.getServer().getPluginManager().callEvent((Event)new VehicleCreateEvent((Vehicle)getBukkitEntity()));
/*     */   }
/*     */   
/*     */   public double ae() {
/* 108 */     return this.length * 0.0D - 0.30000001192092896D;
/*     */   }
/*     */   
/*     */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 112 */     if (!this.world.isStatic && !this.dead) {
/* 113 */       if (isInvulnerable()) {
/* 114 */         return false;
/*     */       }
/*     */       
/* 117 */       Vehicle vehicle = (Vehicle)getBukkitEntity();
/* 118 */       CraftEntity craftEntity = (damagesource.getEntity() == null) ? null : damagesource.getEntity().getBukkitEntity();
/*     */       
/* 120 */       VehicleDamageEvent event = new VehicleDamageEvent(vehicle, (Entity)craftEntity, f);
/* 121 */       this.world.getServer().getPluginManager().callEvent((Event)event);
/*     */       
/* 123 */       if (event.isCancelled()) {
/* 124 */         return true;
/*     */       }
/*     */       
/* 127 */       f = (float)event.getDamage();
/*     */ 
/*     */       
/* 130 */       j(-l());
/* 131 */       c(10);
/* 132 */       Q();
/* 133 */       setDamage(getDamage() + f * 10.0F);
/* 134 */       boolean flag = (damagesource.getEntity() instanceof EntityHuman && ((EntityHuman)damagesource.getEntity()).abilities.canInstantlyBuild);
/*     */       
/* 136 */       if (flag || getDamage() > 40.0F) {
/* 137 */         if (this.passenger != null) {
/* 138 */           this.passenger.mount(this);
/*     */         }
/*     */ 
/*     */         
/* 142 */         VehicleDestroyEvent destroyEvent = new VehicleDestroyEvent(vehicle, (Entity)craftEntity);
/* 143 */         this.world.getServer().getPluginManager().callEvent((Event)destroyEvent);
/*     */         
/* 145 */         if (destroyEvent.isCancelled()) {
/* 146 */           setDamage(40.0F);
/* 147 */           return true;
/*     */         } 
/*     */ 
/*     */         
/* 151 */         if (flag && !k_()) {
/* 152 */           die();
/*     */         } else {
/* 154 */           a(damagesource);
/*     */         } 
/*     */       } 
/*     */       
/* 158 */       return true;
/*     */     } 
/*     */     
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(DamageSource damagesource) {
/* 166 */     die();
/* 167 */     ItemStack itemstack = new ItemStack(Items.MINECART, 1);
/*     */     
/* 169 */     if (this.b != null) {
/* 170 */       itemstack.c(this.b);
/*     */     }
/*     */     
/* 173 */     a(itemstack, 0.0F);
/*     */   }
/*     */   
/*     */   public boolean R() {
/* 177 */     return !this.dead;
/*     */   }
/*     */   
/*     */   public void die() {
/* 181 */     super.die();
/*     */   }
/*     */ 
/*     */   
/*     */   public void h() {
/* 186 */     double prevX = this.locX;
/* 187 */     double prevY = this.locY;
/* 188 */     double prevZ = this.locZ;
/* 189 */     float prevYaw = this.yaw;
/* 190 */     float prevPitch = this.pitch;
/*     */ 
/*     */     
/* 193 */     if (getType() > 0) {
/* 194 */       c(getType() - 1);
/*     */     }
/*     */     
/* 197 */     if (getDamage() > 0.0F) {
/* 198 */       setDamage(getDamage() - 1.0F);
/*     */     }
/*     */     
/* 201 */     if (this.locY < -64.0D) {
/* 202 */       G();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 207 */     if (!this.world.isStatic && this.world instanceof WorldServer) {
/* 208 */       this.world.methodProfiler.a("portal");
/* 209 */       MinecraftServer minecraftserver = ((WorldServer)this.world).getMinecraftServer();
/*     */       
/* 211 */       int i = D();
/* 212 */       if (this.an) {
/*     */         
/* 214 */         if (this.vehicle == null && this.ao++ >= i) {
/* 215 */           byte b0; this.ao = i;
/* 216 */           this.portalCooldown = ai();
/*     */ 
/*     */           
/* 219 */           if (this.world.worldProvider.dimension == -1) {
/* 220 */             b0 = 0;
/*     */           } else {
/* 222 */             b0 = -1;
/*     */           } 
/*     */           
/* 225 */           b(b0);
/*     */         } 
/*     */         
/* 228 */         this.an = false;
/*     */       } else {
/*     */         
/* 231 */         if (this.ao > 0) {
/* 232 */           this.ao -= 4;
/*     */         }
/*     */         
/* 235 */         if (this.ao < 0) {
/* 236 */           this.ao = 0;
/*     */         }
/*     */       } 
/*     */       
/* 240 */       if (this.portalCooldown > 0) {
/* 241 */         this.portalCooldown--;
/*     */       }
/*     */       
/* 244 */       this.world.methodProfiler.b();
/*     */     } 
/*     */     
/* 247 */     if (this.world.isStatic) {
/* 248 */       if (this.d > 0) {
/* 249 */         double d0 = this.locX + (this.e - this.locX) / this.d;
/* 250 */         double d1 = this.locY + (this.f - this.locY) / this.d;
/* 251 */         double d2 = this.locZ + (this.g - this.locZ) / this.d;
/* 252 */         double d3 = MathHelper.g(this.h - this.yaw);
/*     */         
/* 254 */         this.yaw = (float)(this.yaw + d3 / this.d);
/* 255 */         this.pitch = (float)(this.pitch + (this.i - this.pitch) / this.d);
/* 256 */         this.d--;
/* 257 */         setPosition(d0, d1, d2);
/* 258 */         b(this.yaw, this.pitch);
/*     */       } else {
/* 260 */         setPosition(this.locX, this.locY, this.locZ);
/* 261 */         b(this.yaw, this.pitch);
/*     */       } 
/*     */     } else {
/* 264 */       this.lastX = this.locX;
/* 265 */       this.lastY = this.locY;
/* 266 */       this.lastZ = this.locZ;
/* 267 */       this.motY -= 0.03999999910593033D;
/* 268 */       int j = MathHelper.floor(this.locX);
/*     */       
/* 270 */       int i = MathHelper.floor(this.locY);
/* 271 */       int k = MathHelper.floor(this.locZ);
/*     */       
/* 273 */       if (BlockMinecartTrackAbstract.b_(this.world, j, i - 1, k)) {
/* 274 */         i--;
/*     */       }
/*     */       
/* 277 */       double d4 = this.maxSpeed;
/* 278 */       double d5 = 0.0078125D;
/* 279 */       Block block = this.world.getType(j, i, k);
/*     */       
/* 281 */       if (BlockMinecartTrackAbstract.a(block)) {
/* 282 */         int l = this.world.getData(j, i, k);
/*     */         
/* 284 */         a(j, i, k, d4, d5, block, l);
/* 285 */         if (block == Blocks.ACTIVATOR_RAIL) {
/* 286 */           a(j, i, k, ((l & 0x8) != 0));
/*     */         }
/*     */       } else {
/* 289 */         b(d4);
/*     */       } 
/*     */       
/* 292 */       I();
/* 293 */       this.pitch = 0.0F;
/* 294 */       double d6 = this.lastX - this.locX;
/* 295 */       double d7 = this.lastZ - this.locZ;
/*     */       
/* 297 */       if (d6 * d6 + d7 * d7 > 0.001D) {
/* 298 */         this.yaw = (float)(Math.atan2(d7, d6) * 180.0D / Math.PI);
/* 299 */         if (this.a) {
/* 300 */           this.yaw += 180.0F;
/*     */         }
/*     */       } 
/*     */       
/* 304 */       double d8 = MathHelper.g(this.yaw - this.lastYaw);
/*     */       
/* 306 */       if (d8 < -170.0D || d8 >= 170.0D) {
/* 307 */         this.yaw += 180.0F;
/* 308 */         this.a = !this.a;
/*     */       } 
/*     */       
/* 311 */       b(this.yaw, this.pitch);
/*     */ 
/*     */       
/* 314 */       CraftWorld craftWorld = this.world.getWorld();
/* 315 */       Location from = new Location((World)craftWorld, prevX, prevY, prevZ, prevYaw, prevPitch);
/* 316 */       Location to = new Location((World)craftWorld, this.locX, this.locY, this.locZ, this.yaw, this.pitch);
/* 317 */       Vehicle vehicle = (Vehicle)getBukkitEntity();
/*     */       
/* 319 */       this.world.getServer().getPluginManager().callEvent((Event)new VehicleUpdateEvent(vehicle));
/*     */       
/* 321 */       if (!from.equals(to)) {
/* 322 */         this.world.getServer().getPluginManager().callEvent((Event)new VehicleMoveEvent(vehicle, from, to));
/*     */       }
/*     */ 
/*     */       
/* 326 */       List<Entity> list = this.world.getEntities(this, this.boundingBox.grow(0.20000000298023224D, 0.0D, 0.20000000298023224D));
/*     */       
/* 328 */       if (list != null && !list.isEmpty()) {
/* 329 */         for (int i1 = 0; i1 < list.size(); i1++) {
/* 330 */           Entity entity = list.get(i1);
/*     */           
/* 332 */           if (entity != this.passenger && entity.S() && entity instanceof EntityMinecartAbstract) {
/* 333 */             entity.collide(this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 338 */       if (this.passenger != null && this.passenger.dead) {
/* 339 */         if (this.passenger.vehicle == this) {
/* 340 */           this.passenger.vehicle = null;
/*     */         }
/*     */         
/* 343 */         this.passenger = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(int i, int j, int k, boolean flag) {}
/*     */   
/*     */   protected void b(double d0) {
/* 351 */     if (this.motX < -d0) {
/* 352 */       this.motX = -d0;
/*     */     }
/*     */     
/* 355 */     if (this.motX > d0) {
/* 356 */       this.motX = d0;
/*     */     }
/*     */     
/* 359 */     if (this.motZ < -d0) {
/* 360 */       this.motZ = -d0;
/*     */     }
/*     */     
/* 363 */     if (this.motZ > d0) {
/* 364 */       this.motZ = d0;
/*     */     }
/*     */     
/* 367 */     if (this.onGround) {
/*     */       
/* 369 */       this.motX *= this.derailedX;
/* 370 */       this.motY *= this.derailedY;
/* 371 */       this.motZ *= this.derailedZ;
/*     */     } 
/*     */ 
/*     */     
/* 375 */     move(this.motX, this.motY, this.motZ);
/* 376 */     if (!this.onGround) {
/*     */       
/* 378 */       this.motX *= this.flyingX;
/* 379 */       this.motY *= this.flyingY;
/* 380 */       this.motZ *= this.flyingZ;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(int i, int j, int k, double d0, double d1, Block block, int l) {
/* 386 */     this.fallDistance = 0.0F;
/* 387 */     Vec3D vec3d = a(this.locX, this.locY, this.locZ);
/*     */     
/* 389 */     this.locY = j;
/* 390 */     boolean flag = false;
/* 391 */     boolean flag1 = false;
/*     */     
/* 393 */     if (block == Blocks.GOLDEN_RAIL) {
/* 394 */       flag = ((l & 0x8) != 0);
/* 395 */       flag1 = !flag;
/*     */     } 
/*     */     
/* 398 */     if (((BlockMinecartTrackAbstract)block).e()) {
/* 399 */       l &= 0x7;
/*     */     }
/*     */     
/* 402 */     if (l >= 2 && l <= 5) {
/* 403 */       this.locY = (j + 1);
/*     */     }
/*     */     
/* 406 */     if (l == 2) {
/* 407 */       this.motX -= d1;
/*     */     }
/*     */     
/* 410 */     if (l == 3) {
/* 411 */       this.motX += d1;
/*     */     }
/*     */     
/* 414 */     if (l == 4) {
/* 415 */       this.motZ += d1;
/*     */     }
/*     */     
/* 418 */     if (l == 5) {
/* 419 */       this.motZ -= d1;
/*     */     }
/*     */     
/* 422 */     int[][] aint = matrix[l];
/* 423 */     double d2 = (aint[1][0] - aint[0][0]);
/* 424 */     double d3 = (aint[1][2] - aint[0][2]);
/* 425 */     double d4 = Math.sqrt(d2 * d2 + d3 * d3);
/* 426 */     double d5 = this.motX * d2 + this.motZ * d3;
/*     */     
/* 428 */     if (d5 < 0.0D) {
/* 429 */       d2 = -d2;
/* 430 */       d3 = -d3;
/*     */     } 
/*     */     
/* 433 */     double d6 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/*     */     
/* 435 */     if (d6 > 2.0D) {
/* 436 */       d6 = 2.0D;
/*     */     }
/*     */     
/* 439 */     this.motX = d6 * d2 / d4;
/* 440 */     this.motZ = d6 * d3 / d4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 446 */     if (this.passenger != null && this.passenger instanceof EntityLiving) {
/* 447 */       double d = ((EntityLiving)this.passenger).be;
/* 448 */       if (d > 0.0D) {
/* 449 */         double d14 = -Math.sin((this.passenger.yaw * 3.1415927F / 180.0F));
/* 450 */         double d15 = Math.cos((this.passenger.yaw * 3.1415927F / 180.0F));
/* 451 */         double d16 = this.motX * this.motX + this.motZ * this.motZ;
/* 452 */         if (d16 < 0.01D) {
/* 453 */           this.motX += d14 * 0.1D;
/* 454 */           this.motZ += d15 * 0.1D;
/* 455 */           flag1 = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 460 */     if (flag1) {
/* 461 */       double d = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/* 462 */       if (d < 0.03D) {
/* 463 */         this.motX *= 0.0D;
/* 464 */         this.motY *= 0.0D;
/* 465 */         this.motZ *= 0.0D;
/*     */       } else {
/* 467 */         this.motX *= 0.5D;
/* 468 */         this.motY *= 0.0D;
/* 469 */         this.motZ *= 0.5D;
/*     */       } 
/*     */     } 
/*     */     
/* 473 */     double d7 = 0.0D;
/* 474 */     double d8 = i + 0.5D + aint[0][0] * 0.5D;
/* 475 */     double d9 = k + 0.5D + aint[0][2] * 0.5D;
/* 476 */     double d10 = i + 0.5D + aint[1][0] * 0.5D;
/* 477 */     double d11 = k + 0.5D + aint[1][2] * 0.5D;
/*     */     
/* 479 */     d2 = d10 - d8;
/* 480 */     d3 = d11 - d9;
/*     */ 
/*     */ 
/*     */     
/* 484 */     if (d2 == 0.0D) {
/* 485 */       this.locX = i + 0.5D;
/* 486 */       d7 = this.locZ - k;
/* 487 */     } else if (d3 == 0.0D) {
/* 488 */       this.locZ = k + 0.5D;
/* 489 */       d7 = this.locX - i;
/*     */     } else {
/* 491 */       double d14 = this.locX - d8;
/* 492 */       double d15 = this.locZ - d9;
/* 493 */       d7 = (d14 * d2 + d15 * d3) * 2.0D;
/*     */     } 
/*     */     
/* 496 */     this.locX = d8 + d2 * d7;
/* 497 */     this.locZ = d9 + d3 * d7;
/* 498 */     setPosition(this.locX, this.locY + this.height, this.locZ);
/* 499 */     double d12 = this.motX;
/* 500 */     double d13 = this.motZ;
/* 501 */     if (this.passenger != null) {
/* 502 */       d12 *= 0.75D;
/* 503 */       d13 *= 0.75D;
/*     */     } 
/*     */     
/* 506 */     if (d12 < -d0) {
/* 507 */       d12 = -d0;
/*     */     }
/*     */     
/* 510 */     if (d12 > d0) {
/* 511 */       d12 = d0;
/*     */     }
/*     */     
/* 514 */     if (d13 < -d0) {
/* 515 */       d13 = -d0;
/*     */     }
/*     */     
/* 518 */     if (d13 > d0) {
/* 519 */       d13 = d0;
/*     */     }
/*     */     
/* 522 */     move(d12, 0.0D, d13);
/* 523 */     if (aint[0][1] != 0 && MathHelper.floor(this.locX) - i == aint[0][0] && MathHelper.floor(this.locZ) - k == aint[0][2]) {
/* 524 */       setPosition(this.locX, this.locY + aint[0][1], this.locZ);
/* 525 */     } else if (aint[1][1] != 0 && MathHelper.floor(this.locX) - i == aint[1][0] && MathHelper.floor(this.locZ) - k == aint[1][2]) {
/* 526 */       setPosition(this.locX, this.locY + aint[1][1], this.locZ);
/*     */     } 
/*     */     
/* 529 */     i();
/* 530 */     Vec3D vec3d1 = a(this.locX, this.locY, this.locZ);
/*     */     
/* 532 */     if (vec3d1 != null && vec3d != null) {
/* 533 */       double d14 = (vec3d.b - vec3d1.b) * 0.05D;
/*     */       
/* 535 */       d6 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/* 536 */       if (d6 > 0.0D) {
/* 537 */         this.motX = this.motX / d6 * (d6 + d14);
/* 538 */         this.motZ = this.motZ / d6 * (d6 + d14);
/*     */       } 
/*     */       
/* 541 */       setPosition(this.locX, vec3d1.b, this.locZ);
/*     */     } 
/*     */     
/* 544 */     int i1 = MathHelper.floor(this.locX);
/* 545 */     int j1 = MathHelper.floor(this.locZ);
/*     */     
/* 547 */     if (i1 != i || j1 != k) {
/* 548 */       d6 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/* 549 */       this.motX = d6 * (i1 - i);
/* 550 */       this.motZ = d6 * (j1 - k);
/*     */     } 
/*     */     
/* 553 */     if (flag) {
/* 554 */       double d15 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/*     */       
/* 556 */       if (d15 > 0.01D) {
/* 557 */         double d16 = 0.06D;
/*     */         
/* 559 */         this.motX += this.motX / d15 * d16;
/* 560 */         this.motZ += this.motZ / d15 * d16;
/* 561 */       } else if (l == 1) {
/* 562 */         if (this.world.getType(i - 1, j, k).r()) {
/* 563 */           this.motX = 0.02D;
/* 564 */         } else if (this.world.getType(i + 1, j, k).r()) {
/* 565 */           this.motX = -0.02D;
/*     */         } 
/* 567 */       } else if (l == 0) {
/* 568 */         if (this.world.getType(i, j, k - 1).r()) {
/* 569 */           this.motZ = 0.02D;
/* 570 */         } else if (this.world.getType(i, j, k + 1).r()) {
/* 571 */           this.motZ = -0.02D;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void i() {
/* 578 */     if (this.passenger != null || !this.slowWhenEmpty) {
/* 579 */       this.motX *= 0.996999979019165D;
/* 580 */       this.motY *= 0.0D;
/* 581 */       this.motZ *= 0.996999979019165D;
/*     */     } else {
/* 583 */       this.motX *= 0.9599999785423279D;
/* 584 */       this.motY *= 0.0D;
/* 585 */       this.motZ *= 0.9599999785423279D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Vec3D a(double d0, double d1, double d2) {
/* 590 */     int i = MathHelper.floor(d0);
/* 591 */     int j = MathHelper.floor(d1);
/* 592 */     int k = MathHelper.floor(d2);
/*     */     
/* 594 */     if (BlockMinecartTrackAbstract.b_(this.world, i, j - 1, k)) {
/* 595 */       j--;
/*     */     }
/*     */     
/* 598 */     Block block = this.world.getType(i, j, k);
/*     */     
/* 600 */     if (BlockMinecartTrackAbstract.a(block)) {
/* 601 */       int l = this.world.getData(i, j, k);
/*     */       
/* 603 */       d1 = j;
/* 604 */       if (((BlockMinecartTrackAbstract)block).e()) {
/* 605 */         l &= 0x7;
/*     */       }
/*     */       
/* 608 */       if (l >= 2 && l <= 5) {
/* 609 */         d1 = (j + 1);
/*     */       }
/*     */       
/* 612 */       int[][] aint = matrix[l];
/* 613 */       double d3 = 0.0D;
/* 614 */       double d4 = i + 0.5D + aint[0][0] * 0.5D;
/* 615 */       double d5 = j + 0.5D + aint[0][1] * 0.5D;
/* 616 */       double d6 = k + 0.5D + aint[0][2] * 0.5D;
/* 617 */       double d7 = i + 0.5D + aint[1][0] * 0.5D;
/* 618 */       double d8 = j + 0.5D + aint[1][1] * 0.5D;
/* 619 */       double d9 = k + 0.5D + aint[1][2] * 0.5D;
/* 620 */       double d10 = d7 - d4;
/* 621 */       double d11 = (d8 - d5) * 2.0D;
/* 622 */       double d12 = d9 - d6;
/*     */       
/* 624 */       if (d10 == 0.0D) {
/* 625 */         d0 = i + 0.5D;
/* 626 */         d3 = d2 - k;
/* 627 */       } else if (d12 == 0.0D) {
/* 628 */         d2 = k + 0.5D;
/* 629 */         d3 = d0 - i;
/*     */       } else {
/* 631 */         double d13 = d0 - d4;
/* 632 */         double d14 = d2 - d6;
/*     */         
/* 634 */         d3 = (d13 * d10 + d14 * d12) * 2.0D;
/*     */       } 
/*     */       
/* 637 */       d0 = d4 + d10 * d3;
/* 638 */       d1 = d5 + d11 * d3;
/* 639 */       d2 = d6 + d12 * d3;
/* 640 */       if (d11 < 0.0D) {
/* 641 */         d1++;
/*     */       }
/*     */       
/* 644 */       if (d11 > 0.0D) {
/* 645 */         d1 += 0.5D;
/*     */       }
/*     */       
/* 648 */       return Vec3D.a(d0, d1, d2);
/*     */     } 
/* 650 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(NBTTagCompound nbttagcompound) {
/* 655 */     if (nbttagcompound.getBoolean("CustomDisplayTile")) {
/* 656 */       k(nbttagcompound.getInt("DisplayTile"));
/* 657 */       l(nbttagcompound.getInt("DisplayData"));
/* 658 */       m(nbttagcompound.getInt("DisplayOffset"));
/*     */     } 
/*     */     
/* 661 */     if (nbttagcompound.hasKeyOfType("CustomName", 8) && nbttagcompound.getString("CustomName").length() > 0) {
/* 662 */       this.b = nbttagcompound.getString("CustomName");
/*     */     }
/*     */   }
/*     */   
/*     */   protected void b(NBTTagCompound nbttagcompound) {
/* 667 */     if (t()) {
/* 668 */       nbttagcompound.setBoolean("CustomDisplayTile", true);
/* 669 */       nbttagcompound.setInt("DisplayTile", (n().getMaterial() == Material.AIR) ? 0 : Block.getId(n()));
/* 670 */       nbttagcompound.setInt("DisplayData", p());
/* 671 */       nbttagcompound.setInt("DisplayOffset", r());
/*     */     } 
/*     */     
/* 674 */     if (this.b != null && this.b.length() > 0) {
/* 675 */       nbttagcompound.setString("CustomName", this.b);
/*     */     }
/*     */   }
/*     */   
/*     */   public void collide(Entity entity) {
/* 680 */     if (!this.world.isStatic && 
/* 681 */       entity != this.passenger) {
/*     */       
/* 683 */       Vehicle vehicle = (Vehicle)getBukkitEntity();
/* 684 */       CraftEntity craftEntity = (entity == null) ? null : entity.getBukkitEntity();
/*     */       
/* 686 */       VehicleEntityCollisionEvent collisionEvent = new VehicleEntityCollisionEvent(vehicle, (Entity)craftEntity);
/* 687 */       this.world.getServer().getPluginManager().callEvent((Event)collisionEvent);
/*     */       
/* 689 */       if (collisionEvent.isCancelled()) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 694 */       if (entity instanceof EntityLiving && !(entity instanceof EntityHuman) && !(entity instanceof EntityIronGolem) && m() == 0 && this.motX * this.motX + this.motZ * this.motZ > 0.01D && this.passenger == null && entity.vehicle == null) {
/* 695 */         entity.mount(this);
/*     */       }
/*     */       
/* 698 */       double d0 = entity.locX - this.locX;
/* 699 */       double d1 = entity.locZ - this.locZ;
/* 700 */       double d2 = d0 * d0 + d1 * d1;
/*     */ 
/*     */       
/* 703 */       if (d2 >= 9.999999747378752E-5D && !collisionEvent.isCollisionCancelled()) {
/* 704 */         d2 = MathHelper.sqrt(d2);
/* 705 */         d0 /= d2;
/* 706 */         d1 /= d2;
/* 707 */         double d3 = 1.0D / d2;
/*     */         
/* 709 */         if (d3 > 1.0D) {
/* 710 */           d3 = 1.0D;
/*     */         }
/*     */         
/* 713 */         d0 *= d3;
/* 714 */         d1 *= d3;
/* 715 */         d0 *= 0.10000000149011612D;
/* 716 */         d1 *= 0.10000000149011612D;
/* 717 */         d0 *= (1.0F - this.Y);
/* 718 */         d1 *= (1.0F - this.Y);
/* 719 */         d0 *= 0.5D;
/* 720 */         d1 *= 0.5D;
/* 721 */         if (entity instanceof EntityMinecartAbstract) {
/* 722 */           double d4 = entity.locX - this.locX;
/* 723 */           double d5 = entity.locZ - this.locZ;
/* 724 */           Vec3D vec3d = Vec3D.a(d4, 0.0D, d5).a();
/* 725 */           Vec3D vec3d1 = Vec3D.a(MathHelper.cos(this.yaw * 3.1415927F / 180.0F), 0.0D, MathHelper.sin(this.yaw * 3.1415927F / 180.0F)).a();
/* 726 */           double d6 = Math.abs(vec3d.b(vec3d1));
/*     */           
/* 728 */           if (d6 < 0.800000011920929D) {
/*     */             return;
/*     */           }
/*     */           
/* 732 */           double d7 = entity.motX + this.motX;
/* 733 */           double d8 = entity.motZ + this.motZ;
/*     */           
/* 735 */           if (((EntityMinecartAbstract)entity).m() == 2 && m() != 2) {
/* 736 */             this.motX *= 0.20000000298023224D;
/* 737 */             this.motZ *= 0.20000000298023224D;
/* 738 */             g(entity.motX - d0, 0.0D, entity.motZ - d1);
/* 739 */             entity.motX *= 0.949999988079071D;
/* 740 */             entity.motZ *= 0.949999988079071D;
/* 741 */           } else if (((EntityMinecartAbstract)entity).m() != 2 && m() == 2) {
/* 742 */             entity.motX *= 0.20000000298023224D;
/* 743 */             entity.motZ *= 0.20000000298023224D;
/* 744 */             entity.g(this.motX + d0, 0.0D, this.motZ + d1);
/* 745 */             this.motX *= 0.949999988079071D;
/* 746 */             this.motZ *= 0.949999988079071D;
/*     */           } else {
/* 748 */             d7 /= 2.0D;
/* 749 */             d8 /= 2.0D;
/* 750 */             this.motX *= 0.20000000298023224D;
/* 751 */             this.motZ *= 0.20000000298023224D;
/* 752 */             g(d7 - d0, 0.0D, d8 - d1);
/* 753 */             entity.motX *= 0.20000000298023224D;
/* 754 */             entity.motZ *= 0.20000000298023224D;
/* 755 */             entity.g(d7 + d0, 0.0D, d8 + d1);
/*     */           } 
/*     */         } else {
/* 758 */           g(-d0, 0.0D, -d1);
/* 759 */           entity.g(d0 / 4.0D, 0.0D, d1 / 4.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDamage(float f) {
/* 767 */     this.datawatcher.watch(19, Float.valueOf(f));
/*     */   }
/*     */   
/*     */   public float getDamage() {
/* 771 */     return this.datawatcher.getFloat(19);
/*     */   }
/*     */   
/*     */   public void c(int i) {
/* 775 */     this.datawatcher.watch(17, Integer.valueOf(i));
/*     */   }
/*     */   
/*     */   public int getType() {
/* 779 */     return this.datawatcher.getInt(17);
/*     */   }
/*     */   
/*     */   public void j(int i) {
/* 783 */     this.datawatcher.watch(18, Integer.valueOf(i));
/*     */   }
/*     */   
/*     */   public int l() {
/* 787 */     return this.datawatcher.getInt(18);
/*     */   }
/*     */   
/*     */   public abstract int m();
/*     */   
/*     */   public Block n() {
/* 793 */     if (!t()) {
/* 794 */       return o();
/*     */     }
/* 796 */     int i = getDataWatcher().getInt(20) & 0xFFFF;
/*     */     
/* 798 */     return Block.getById(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public Block o() {
/* 803 */     return Blocks.AIR;
/*     */   }
/*     */   
/*     */   public int p() {
/* 807 */     return !t() ? q() : (getDataWatcher().getInt(20) >> 16);
/*     */   }
/*     */   
/*     */   public int q() {
/* 811 */     return 0;
/*     */   }
/*     */   
/*     */   public int r() {
/* 815 */     return !t() ? s() : getDataWatcher().getInt(21);
/*     */   }
/*     */   
/*     */   public int s() {
/* 819 */     return 6;
/*     */   }
/*     */   
/*     */   public void k(int i) {
/* 823 */     getDataWatcher().watch(20, Integer.valueOf(i & 0xFFFF | p() << 16));
/* 824 */     a(true);
/*     */   }
/*     */   
/*     */   public void l(int i) {
/* 828 */     getDataWatcher().watch(20, Integer.valueOf(Block.getId(n()) & 0xFFFF | i << 16));
/* 829 */     a(true);
/*     */   }
/*     */   
/*     */   public void m(int i) {
/* 833 */     getDataWatcher().watch(21, Integer.valueOf(i));
/* 834 */     a(true);
/*     */   }
/*     */   
/*     */   public boolean t() {
/* 838 */     return (getDataWatcher().getByte(22) == 1);
/*     */   }
/*     */   
/*     */   public void a(boolean flag) {
/* 842 */     getDataWatcher().watch(22, Byte.valueOf((byte)(flag ? 1 : 0)));
/*     */   }
/*     */   
/*     */   public void a(String s) {
/* 846 */     this.b = s;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 850 */     return (this.b != null) ? this.b : super.getName();
/*     */   }
/*     */   
/*     */   public boolean k_() {
/* 854 */     return (this.b != null);
/*     */   }
/*     */   
/*     */   public String u() {
/* 858 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector getFlyingVelocityMod() {
/* 863 */     return new Vector(this.flyingX, this.flyingY, this.flyingZ);
/*     */   }
/*     */   
/*     */   public void setFlyingVelocityMod(Vector flying) {
/* 867 */     this.flyingX = flying.getX();
/* 868 */     this.flyingY = flying.getY();
/* 869 */     this.flyingZ = flying.getZ();
/*     */   }
/*     */   
/*     */   public Vector getDerailedVelocityMod() {
/* 873 */     return new Vector(this.derailedX, this.derailedY, this.derailedZ);
/*     */   }
/*     */   
/*     */   public void setDerailedVelocityMod(Vector derailed) {
/* 877 */     this.derailedX = derailed.getX();
/* 878 */     this.derailedY = derailed.getY();
/* 879 */     this.derailedZ = derailed.getZ();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityMinecartAbstract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */