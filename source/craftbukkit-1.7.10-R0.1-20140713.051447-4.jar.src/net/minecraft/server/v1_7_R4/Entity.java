/*      */ package net.minecraft.server.v1_7_R4;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.Server;
/*      */ import org.bukkit.TravelAgent;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.block.Block;
/*      */ import org.bukkit.block.BlockFace;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftTravelAgent;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
/*      */ import org.bukkit.entity.Hanging;
/*      */ import org.bukkit.entity.LivingEntity;
/*      */ import org.bukkit.entity.Painting;
/*      */ import org.bukkit.entity.Vehicle;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.entity.EntityCombustByBlockEvent;
/*      */ import org.bukkit.event.entity.EntityCombustByEntityEvent;
/*      */ import org.bukkit.event.entity.EntityCombustEvent;
/*      */ import org.bukkit.event.entity.EntityPortalEvent;
/*      */ import org.bukkit.event.hanging.HangingBreakByEntityEvent;
/*      */ import org.bukkit.event.painting.PaintingBreakByEntityEvent;
/*      */ import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
/*      */ import org.bukkit.event.vehicle.VehicleEnterEvent;
/*      */ import org.bukkit.event.vehicle.VehicleExitEvent;
/*      */ import org.bukkit.plugin.PluginManager;
/*      */ import org.bukkit.projectiles.ProjectileSource;
/*      */ 
/*      */ public abstract class Entity {
/*      */   static boolean isLevelAtLeast(NBTTagCompound tag, int level) {
/*   38 */     return (tag.hasKey("Bukkit.updateLevel") && tag.getInt("Bukkit.updateLevel") >= level);
/*      */   }
/*      */   private static final int CURRENT_LEVEL = 2;
/*      */   private static int entityCount;
/*      */   private int id;
/*      */   public double j;
/*      */   public boolean k;
/*      */   public Entity passenger;
/*      */   public Entity vehicle;
/*      */   public boolean attachedToPlayer;
/*      */   public World world;
/*      */   public double lastX;
/*      */   public double lastY;
/*      */   public double lastZ;
/*      */   public double locX;
/*      */   public double locY;
/*      */   public double locZ;
/*      */   public double motX;
/*      */   public double motY;
/*      */   public double motZ;
/*      */   public float yaw;
/*      */   public float pitch;
/*      */   public float lastYaw;
/*      */   public float lastPitch;
/*      */   public final AxisAlignedBB boundingBox;
/*      */   public boolean onGround;
/*      */   public boolean positionChanged;
/*      */   public boolean F;
/*      */   public boolean G;
/*      */   public boolean velocityChanged;
/*      */   protected boolean I;
/*      */   public boolean J;
/*      */   public boolean dead;
/*      */   public float height;
/*      */   public float width;
/*      */   public float length;
/*      */   public float O;
/*      */   public float P;
/*      */   public float Q;
/*      */   public float fallDistance;
/*      */   private int d;
/*      */   public double S;
/*      */   public double T;
/*      */   public double U;
/*      */   public float V;
/*      */   public float W;
/*      */   public boolean X;
/*      */   public float Y;
/*      */   public float Z;
/*      */   protected Random random;
/*      */   public int ticksLived;
/*      */   public int maxFireTicks;
/*      */   public int fireTicks;
/*      */   protected boolean inWater;
/*      */   public int noDamageTicks;
/*      */   private boolean justCreated;
/*      */   protected boolean fireProof;
/*      */   protected DataWatcher datawatcher;
/*      */   private double g;
/*      */   private double h;
/*      */   public boolean ag;
/*      */   public int ah;
/*      */   public int ai;
/*      */   public int aj;
/*      */   public boolean ak;
/*      */   public boolean al;
/*      */   public int portalCooldown;
/*      */   protected boolean an;
/*      */   protected int ao;
/*      */   public int dimension;
/*      */   protected int aq;
/*      */   private boolean invulnerable;
/*      */   public UUID uniqueID;
/*      */   public EnumEntitySize as;
/*      */   public boolean valid;
/*      */   public ProjectileSource projectileSource;
/*      */   protected CraftEntity bukkitEntity;
/*      */   
/*      */   public int getId() {
/*  117 */     return this.id;
/*      */   }
/*      */   
/*      */   public void d(int i) {
/*  121 */     this.id = i;
/*      */   }
/*      */   
/*      */   public Entity(World world) {
/*  125 */     this.id = entityCount++;
/*  126 */     this.j = 1.0D;
/*  127 */     this.boundingBox = AxisAlignedBB.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/*  128 */     this.J = true;
/*  129 */     this.width = 0.6F;
/*  130 */     this.length = 1.8F;
/*  131 */     this.d = 1;
/*  132 */     this.random = new Random();
/*  133 */     this.maxFireTicks = 1;
/*  134 */     this.justCreated = true;
/*  135 */     this.uniqueID = UUID.randomUUID();
/*  136 */     this.as = EnumEntitySize.SIZE_2;
/*  137 */     this.world = world;
/*  138 */     setPosition(0.0D, 0.0D, 0.0D);
/*  139 */     if (world != null) {
/*  140 */       this.dimension = world.worldProvider.dimension;
/*      */     }
/*      */     
/*  143 */     this.datawatcher = new DataWatcher(this);
/*  144 */     this.datawatcher.a(0, Byte.valueOf((byte)0));
/*  145 */     this.datawatcher.a(1, Short.valueOf((short)300));
/*  146 */     c();
/*      */   }
/*      */   
/*      */   protected abstract void c();
/*      */   
/*      */   public DataWatcher getDataWatcher() {
/*  152 */     return this.datawatcher;
/*      */   }
/*      */   
/*      */   public boolean equals(Object object) {
/*  156 */     return (object instanceof Entity) ? ((((Entity)object).id == this.id)) : false;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/*  160 */     return this.id;
/*      */   }
/*      */   
/*      */   public void die() {
/*  164 */     this.dead = true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void a(float f, float f1) {
/*  170 */     if (f != this.width || f1 != this.length) {
/*  171 */       float f3 = this.width;
/*  172 */       this.width = f;
/*  173 */       this.length = f1;
/*  174 */       this.boundingBox.d = this.boundingBox.a + this.width;
/*  175 */       this.boundingBox.f = this.boundingBox.c + this.width;
/*  176 */       this.boundingBox.e = this.boundingBox.b + this.length;
/*  177 */       if (this.width > f3 && !this.justCreated && !this.world.isStatic) {
/*  178 */         move((f3 - this.width), 0.0D, (f3 - this.width));
/*      */       }
/*      */     } 
/*      */     
/*  182 */     float f2 = f % 2.0F;
/*  183 */     if (f2 < 0.375D) {
/*  184 */       this.as = EnumEntitySize.SIZE_1;
/*  185 */     } else if (f2 < 0.75D) {
/*  186 */       this.as = EnumEntitySize.SIZE_2;
/*  187 */     } else if (f2 < 1.0D) {
/*  188 */       this.as = EnumEntitySize.SIZE_3;
/*  189 */     } else if (f2 < 1.375D) {
/*  190 */       this.as = EnumEntitySize.SIZE_4;
/*  191 */     } else if (f2 < 1.75D) {
/*  192 */       this.as = EnumEntitySize.SIZE_5;
/*      */     } else {
/*  194 */       this.as = EnumEntitySize.SIZE_6;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void b(float f, float f1) {
/*  200 */     if (Float.isNaN(f)) {
/*  201 */       f = 0.0F;
/*      */     }
/*      */     
/*  204 */     if (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) {
/*  205 */       if (this instanceof EntityPlayer) {
/*  206 */         this.world.getServer().getLogger().warning(((CraftPlayer)getBukkitEntity()).getName() + " was caught trying to crash the server with an invalid yaw");
/*  207 */         ((CraftPlayer)getBukkitEntity()).kickPlayer("Nope");
/*      */       } 
/*  209 */       f = 0.0F;
/*      */     } 
/*      */ 
/*      */     
/*  213 */     if (Float.isNaN(f1)) {
/*  214 */       f1 = 0.0F;
/*      */     }
/*      */     
/*  217 */     if (f1 == Float.POSITIVE_INFINITY || f1 == Float.NEGATIVE_INFINITY) {
/*  218 */       if (this instanceof EntityPlayer) {
/*  219 */         this.world.getServer().getLogger().warning(((CraftPlayer)getBukkitEntity()).getName() + " was caught trying to crash the server with an invalid pitch");
/*  220 */         ((CraftPlayer)getBukkitEntity()).kickPlayer("Nope");
/*      */       } 
/*  222 */       f1 = 0.0F;
/*      */     } 
/*      */ 
/*      */     
/*  226 */     this.yaw = f % 360.0F;
/*  227 */     this.pitch = f1 % 360.0F;
/*      */   }
/*      */   
/*      */   public void setPosition(double d0, double d1, double d2) {
/*  231 */     this.locX = d0;
/*  232 */     this.locY = d1;
/*  233 */     this.locZ = d2;
/*  234 */     float f = this.width / 2.0F;
/*  235 */     float f1 = this.length;
/*      */     
/*  237 */     this.boundingBox.b(d0 - f, d1 - this.height + this.V, d2 - f, d0 + f, d1 - this.height + this.V + f1, d2 + f);
/*      */   }
/*      */   
/*      */   public void h() {
/*  241 */     C();
/*      */   }
/*      */   
/*      */   public void C() {
/*  245 */     this.world.methodProfiler.a("entityBaseTick");
/*  246 */     if (this.vehicle != null && this.vehicle.dead) {
/*  247 */       this.vehicle = null;
/*      */     }
/*      */     
/*  250 */     this.O = this.P;
/*  251 */     this.lastX = this.locX;
/*  252 */     this.lastY = this.locY;
/*  253 */     this.lastZ = this.locZ;
/*  254 */     this.lastPitch = this.pitch;
/*  255 */     this.lastYaw = this.yaw;
/*      */ 
/*      */     
/*  258 */     if (!this.world.isStatic && this.world instanceof WorldServer) {
/*  259 */       this.world.methodProfiler.a("portal");
/*  260 */       MinecraftServer minecraftserver = ((WorldServer)this.world).getMinecraftServer();
/*      */       
/*  262 */       int i = D();
/*  263 */       if (this.an) {
/*      */         
/*  265 */         if (this.vehicle == null && this.ao++ >= i) {
/*  266 */           byte b0; this.ao = i;
/*  267 */           this.portalCooldown = ai();
/*      */ 
/*      */           
/*  270 */           if (this.world.worldProvider.dimension == -1) {
/*  271 */             b0 = 0;
/*      */           } else {
/*  273 */             b0 = -1;
/*      */           } 
/*      */           
/*  276 */           b(b0);
/*      */         } 
/*      */         
/*  279 */         this.an = false;
/*      */       } else {
/*      */         
/*  282 */         if (this.ao > 0) {
/*  283 */           this.ao -= 4;
/*      */         }
/*      */         
/*  286 */         if (this.ao < 0) {
/*  287 */           this.ao = 0;
/*      */         }
/*      */       } 
/*      */       
/*  291 */       if (this.portalCooldown > 0) {
/*  292 */         this.portalCooldown--;
/*      */       }
/*      */       
/*  295 */       this.world.methodProfiler.b();
/*      */     } 
/*      */     
/*  298 */     if (isSprinting() && !M()) {
/*  299 */       int j = MathHelper.floor(this.locX);
/*      */       
/*  301 */       int i = MathHelper.floor(this.locY - 0.20000000298023224D - this.height);
/*  302 */       int k = MathHelper.floor(this.locZ);
/*  303 */       Block block = this.world.getType(j, i, k);
/*      */       
/*  305 */       if (block.getMaterial() != Material.AIR) {
/*  306 */         this.world.addParticle("blockcrack_" + Block.getId(block) + "_" + this.world.getData(j, i, k), this.locX + (this.random.nextFloat() - 0.5D) * this.width, this.boundingBox.b + 0.1D, this.locZ + (this.random.nextFloat() - 0.5D) * this.width, -this.motX * 4.0D, 1.5D, -this.motZ * 4.0D);
/*      */       }
/*      */     } 
/*      */     
/*  310 */     N();
/*  311 */     if (this.world.isStatic) {
/*  312 */       this.fireTicks = 0;
/*  313 */     } else if (this.fireTicks > 0) {
/*  314 */       if (this.fireProof) {
/*  315 */         this.fireTicks -= 4;
/*  316 */         if (this.fireTicks < 0) {
/*  317 */           this.fireTicks = 0;
/*      */         }
/*      */       } else {
/*  320 */         if (this.fireTicks % 20 == 0) {
/*  321 */           damageEntity(DamageSource.BURN, 1.0F);
/*      */         }
/*      */         
/*  324 */         this.fireTicks--;
/*      */       } 
/*      */     } 
/*      */     
/*  328 */     if (P()) {
/*  329 */       E();
/*  330 */       this.fallDistance *= 0.5F;
/*      */     } 
/*      */     
/*  333 */     if (this.locY < -64.0D) {
/*  334 */       G();
/*      */     }
/*      */     
/*  337 */     if (!this.world.isStatic) {
/*  338 */       a(0, (this.fireTicks > 0));
/*      */     }
/*      */     
/*  341 */     this.justCreated = false;
/*  342 */     this.world.methodProfiler.b();
/*      */   }
/*      */   
/*      */   public int D() {
/*  346 */     return 0;
/*      */   }
/*      */   
/*      */   protected void E() {
/*  350 */     if (!this.fireProof) {
/*  351 */       damageEntity(DamageSource.LAVA, 4.0F);
/*      */ 
/*      */       
/*  354 */       if (this instanceof EntityLiving) {
/*  355 */         if (this.fireTicks <= 0) {
/*      */ 
/*      */           
/*  358 */           Block damager = null;
/*  359 */           CraftEntity craftEntity = getBukkitEntity();
/*  360 */           EntityCombustByBlockEvent entityCombustByBlockEvent = new EntityCombustByBlockEvent(damager, (org.bukkit.entity.Entity)craftEntity, 15);
/*  361 */           this.world.getServer().getPluginManager().callEvent((Event)entityCombustByBlockEvent);
/*      */           
/*  363 */           if (!entityCombustByBlockEvent.isCancelled()) {
/*  364 */             setOnFire(entityCombustByBlockEvent.getDuration());
/*      */           }
/*      */         } else {
/*      */           
/*  368 */           setOnFire(15);
/*      */         } 
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  374 */       setOnFire(15);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setOnFire(int i) {
/*  379 */     int j = i * 20;
/*      */     
/*  381 */     j = EnchantmentProtection.a(this, j);
/*  382 */     if (this.fireTicks < j) {
/*  383 */       this.fireTicks = j;
/*      */     }
/*      */   }
/*      */   
/*      */   public void extinguish() {
/*  388 */     this.fireTicks = 0;
/*      */   }
/*      */   
/*      */   protected void G() {
/*  392 */     die();
/*      */   }
/*      */   
/*      */   public boolean c(double d0, double d1, double d2) {
/*  396 */     AxisAlignedBB axisalignedbb = this.boundingBox.c(d0, d1, d2);
/*  397 */     List list = this.world.getCubes(this, axisalignedbb);
/*      */     
/*  399 */     return !list.isEmpty() ? false : (!this.world.containsLiquid(axisalignedbb));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void move(double d0, double d1, double d2) {
/*      */     try {
/*  406 */       I();
/*  407 */     } catch (Throwable throwable) {
/*  408 */       CrashReport crashreport = CrashReport.a(throwable, "Checking entity block collision");
/*  409 */       CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Entity being checked for collision");
/*      */       
/*  411 */       a(crashreportsystemdetails);
/*  412 */       throw new ReportedException(crashreport);
/*      */     } 
/*      */     
/*  415 */     if (d0 == 0.0D && d1 == 0.0D && d2 == 0.0D && this.vehicle == null && this.passenger == null) {
/*      */       return;
/*      */     }
/*      */     
/*  419 */     if (this.X) {
/*  420 */       this.boundingBox.d(d0, d1, d2);
/*  421 */       this.locX = (this.boundingBox.a + this.boundingBox.d) / 2.0D;
/*  422 */       this.locY = this.boundingBox.b + this.height - this.V;
/*  423 */       this.locZ = (this.boundingBox.c + this.boundingBox.f) / 2.0D;
/*      */     } else {
/*  425 */       this.world.methodProfiler.a("move");
/*  426 */       this.V *= 0.4F;
/*  427 */       double d3 = this.locX;
/*  428 */       double d4 = this.locY;
/*  429 */       double d5 = this.locZ;
/*      */       
/*  431 */       if (this.I) {
/*  432 */         this.I = false;
/*  433 */         d0 *= 0.25D;
/*  434 */         d1 *= 0.05000000074505806D;
/*  435 */         d2 *= 0.25D;
/*  436 */         this.motX = 0.0D;
/*  437 */         this.motY = 0.0D;
/*  438 */         this.motZ = 0.0D;
/*      */       } 
/*      */       
/*  441 */       double d6 = d0;
/*  442 */       double d7 = d1;
/*  443 */       double d8 = d2;
/*  444 */       AxisAlignedBB axisalignedbb = this.boundingBox.clone();
/*  445 */       boolean flag = (this.onGround && isSneaking() && this instanceof EntityHuman);
/*      */       
/*  447 */       if (flag) {
/*      */         double d9;
/*      */         
/*  450 */         for (d9 = 0.05D; d0 != 0.0D && this.world.getCubes(this, this.boundingBox.c(d0, -1.0D, 0.0D)).isEmpty(); d6 = d0) {
/*  451 */           if (d0 < d9 && d0 >= -d9) {
/*  452 */             d0 = 0.0D;
/*  453 */           } else if (d0 > 0.0D) {
/*  454 */             d0 -= d9;
/*      */           } else {
/*  456 */             d0 += d9;
/*      */           } 
/*      */         } 
/*      */         
/*  460 */         for (; d2 != 0.0D && this.world.getCubes(this, this.boundingBox.c(0.0D, -1.0D, d2)).isEmpty(); d8 = d2) {
/*  461 */           if (d2 < d9 && d2 >= -d9) {
/*  462 */             d2 = 0.0D;
/*  463 */           } else if (d2 > 0.0D) {
/*  464 */             d2 -= d9;
/*      */           } else {
/*  466 */             d2 += d9;
/*      */           } 
/*      */         } 
/*      */         
/*  470 */         while (d0 != 0.0D && d2 != 0.0D && this.world.getCubes(this, this.boundingBox.c(d0, -1.0D, d2)).isEmpty()) {
/*  471 */           if (d0 < d9 && d0 >= -d9) {
/*  472 */             d0 = 0.0D;
/*  473 */           } else if (d0 > 0.0D) {
/*  474 */             d0 -= d9;
/*      */           } else {
/*  476 */             d0 += d9;
/*      */           } 
/*      */           
/*  479 */           if (d2 < d9 && d2 >= -d9) {
/*  480 */             d2 = 0.0D;
/*  481 */           } else if (d2 > 0.0D) {
/*  482 */             d2 -= d9;
/*      */           } else {
/*  484 */             d2 += d9;
/*      */           } 
/*      */           
/*  487 */           d6 = d0;
/*  488 */           d8 = d2;
/*      */         } 
/*      */       } 
/*      */       
/*  492 */       List<AxisAlignedBB> list = this.world.getCubes(this, this.boundingBox.a(d0, d1, d2));
/*      */       
/*  494 */       for (int i = 0; i < list.size(); i++) {
/*  495 */         d1 = ((AxisAlignedBB)list.get(i)).b(this.boundingBox, d1);
/*      */       }
/*      */       
/*  498 */       this.boundingBox.d(0.0D, d1, 0.0D);
/*  499 */       if (!this.J && d7 != d1) {
/*  500 */         d2 = 0.0D;
/*  501 */         d1 = 0.0D;
/*  502 */         d0 = 0.0D;
/*      */       } 
/*      */       
/*  505 */       boolean flag1 = (this.onGround || (d7 != d1 && d7 < 0.0D));
/*      */       
/*      */       int j;
/*      */       
/*  509 */       for (j = 0; j < list.size(); j++) {
/*  510 */         d0 = ((AxisAlignedBB)list.get(j)).a(this.boundingBox, d0);
/*      */       }
/*      */       
/*  513 */       this.boundingBox.d(d0, 0.0D, 0.0D);
/*  514 */       if (!this.J && d6 != d0) {
/*  515 */         d2 = 0.0D;
/*  516 */         d1 = 0.0D;
/*  517 */         d0 = 0.0D;
/*      */       } 
/*      */       
/*  520 */       for (j = 0; j < list.size(); j++) {
/*  521 */         d2 = ((AxisAlignedBB)list.get(j)).c(this.boundingBox, d2);
/*      */       }
/*      */       
/*  524 */       this.boundingBox.d(0.0D, 0.0D, d2);
/*  525 */       if (!this.J && d8 != d2) {
/*  526 */         d2 = 0.0D;
/*  527 */         d1 = 0.0D;
/*  528 */         d0 = 0.0D;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  536 */       if (this.W > 0.0F && flag1 && (flag || this.V < 0.05F) && (d6 != d0 || d8 != d2)) {
/*  537 */         double d9 = d0;
/*  538 */         double d13 = d1;
/*  539 */         double d14 = d2;
/*  540 */         d0 = d6;
/*  541 */         d1 = this.W;
/*  542 */         d2 = d8;
/*  543 */         AxisAlignedBB axisalignedbb1 = this.boundingBox.clone();
/*      */         
/*  545 */         this.boundingBox.d(axisalignedbb);
/*  546 */         list = this.world.getCubes(this, this.boundingBox.a(d6, d1, d8));
/*      */         int k;
/*  548 */         for (k = 0; k < list.size(); k++) {
/*  549 */           d1 = ((AxisAlignedBB)list.get(k)).b(this.boundingBox, d1);
/*      */         }
/*      */         
/*  552 */         this.boundingBox.d(0.0D, d1, 0.0D);
/*  553 */         if (!this.J && d7 != d1) {
/*  554 */           d2 = 0.0D;
/*  555 */           d1 = 0.0D;
/*  556 */           d0 = 0.0D;
/*      */         } 
/*      */         
/*  559 */         for (k = 0; k < list.size(); k++) {
/*  560 */           d0 = ((AxisAlignedBB)list.get(k)).a(this.boundingBox, d0);
/*      */         }
/*      */         
/*  563 */         this.boundingBox.d(d0, 0.0D, 0.0D);
/*  564 */         if (!this.J && d6 != d0) {
/*  565 */           d2 = 0.0D;
/*  566 */           d1 = 0.0D;
/*  567 */           d0 = 0.0D;
/*      */         } 
/*      */         
/*  570 */         for (k = 0; k < list.size(); k++) {
/*  571 */           d2 = ((AxisAlignedBB)list.get(k)).c(this.boundingBox, d2);
/*      */         }
/*      */         
/*  574 */         this.boundingBox.d(0.0D, 0.0D, d2);
/*  575 */         if (!this.J && d8 != d2) {
/*  576 */           d2 = 0.0D;
/*  577 */           d1 = 0.0D;
/*  578 */           d0 = 0.0D;
/*      */         } 
/*      */         
/*  581 */         if (!this.J && d7 != d1) {
/*  582 */           d2 = 0.0D;
/*  583 */           d1 = 0.0D;
/*  584 */           d0 = 0.0D;
/*      */         } else {
/*  586 */           d1 = -this.W;
/*      */           
/*  588 */           for (k = 0; k < list.size(); k++) {
/*  589 */             d1 = ((AxisAlignedBB)list.get(k)).b(this.boundingBox, d1);
/*      */           }
/*      */           
/*  592 */           this.boundingBox.d(0.0D, d1, 0.0D);
/*      */         } 
/*      */         
/*  595 */         if (d9 * d9 + d14 * d14 >= d0 * d0 + d2 * d2) {
/*  596 */           d0 = d9;
/*  597 */           d1 = d13;
/*  598 */           d2 = d14;
/*  599 */           this.boundingBox.d(axisalignedbb1);
/*      */         } 
/*      */       } 
/*      */       
/*  603 */       this.world.methodProfiler.b();
/*  604 */       this.world.methodProfiler.a("rest");
/*  605 */       this.locX = (this.boundingBox.a + this.boundingBox.d) / 2.0D;
/*  606 */       this.locY = this.boundingBox.b + this.height - this.V;
/*  607 */       this.locZ = (this.boundingBox.c + this.boundingBox.f) / 2.0D;
/*  608 */       this.positionChanged = (d6 != d0 || d8 != d2);
/*  609 */       this.F = (d7 != d1);
/*  610 */       this.onGround = (d7 != d1 && d7 < 0.0D);
/*  611 */       this.G = (this.positionChanged || this.F);
/*  612 */       a(d1, this.onGround);
/*  613 */       if (d6 != d0) {
/*  614 */         this.motX = 0.0D;
/*      */       }
/*      */       
/*  617 */       if (d7 != d1) {
/*  618 */         this.motY = 0.0D;
/*      */       }
/*      */       
/*  621 */       if (d8 != d2) {
/*  622 */         this.motZ = 0.0D;
/*      */       }
/*      */       
/*  625 */       double d10 = this.locX - d3;
/*  626 */       double d11 = this.locY - d4;
/*  627 */       double d12 = this.locZ - d5;
/*      */ 
/*      */       
/*  630 */       if (this.positionChanged && getBukkitEntity() instanceof Vehicle) {
/*  631 */         Vehicle vehicle = (Vehicle)getBukkitEntity();
/*  632 */         Block block = this.world.getWorld().getBlockAt(MathHelper.floor(this.locX), MathHelper.floor(this.locY - this.height), MathHelper.floor(this.locZ));
/*      */         
/*  634 */         if (d6 > d0) {
/*  635 */           block = block.getRelative(BlockFace.EAST);
/*  636 */         } else if (d6 < d0) {
/*  637 */           block = block.getRelative(BlockFace.WEST);
/*  638 */         } else if (d8 > d2) {
/*  639 */           block = block.getRelative(BlockFace.SOUTH);
/*  640 */         } else if (d8 < d2) {
/*  641 */           block = block.getRelative(BlockFace.NORTH);
/*      */         } 
/*      */         
/*  644 */         VehicleBlockCollisionEvent event = new VehicleBlockCollisionEvent(vehicle, block);
/*  645 */         this.world.getServer().getPluginManager().callEvent((Event)event);
/*      */       } 
/*      */ 
/*      */       
/*  649 */       if (g_() && !flag && this.vehicle == null) {
/*  650 */         int l = MathHelper.floor(this.locX);
/*      */         
/*  652 */         int k = MathHelper.floor(this.locY - 0.20000000298023224D - this.height);
/*  653 */         int i1 = MathHelper.floor(this.locZ);
/*  654 */         Block block = this.world.getType(l, k, i1);
/*  655 */         int j1 = this.world.getType(l, k - 1, i1).b();
/*      */         
/*  657 */         if (j1 == 11 || j1 == 32 || j1 == 21) {
/*  658 */           block = this.world.getType(l, k - 1, i1);
/*      */         }
/*      */         
/*  661 */         if (block != Blocks.LADDER) {
/*  662 */           d11 = 0.0D;
/*      */         }
/*      */         
/*  665 */         this.P = (float)(this.P + MathHelper.sqrt(d10 * d10 + d12 * d12) * 0.6D);
/*  666 */         this.Q = (float)(this.Q + MathHelper.sqrt(d10 * d10 + d11 * d11 + d12 * d12) * 0.6D);
/*  667 */         if (this.Q > this.d && block.getMaterial() != Material.AIR) {
/*  668 */           this.d = (int)this.Q + 1;
/*  669 */           if (M()) {
/*  670 */             float f = MathHelper.sqrt(this.motX * this.motX * 0.20000000298023224D + this.motY * this.motY + this.motZ * this.motZ * 0.20000000298023224D) * 0.35F;
/*      */             
/*  672 */             if (f > 1.0F) {
/*  673 */               f = 1.0F;
/*      */             }
/*      */             
/*  676 */             makeSound(H(), f, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
/*      */           } 
/*      */           
/*  679 */           a(l, k, i1, block);
/*  680 */           block.b(this.world, l, k, i1, this);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  697 */       boolean flag2 = L();
/*      */       
/*  699 */       if (this.world.e(this.boundingBox.shrink(0.001D, 0.001D, 0.001D))) {
/*  700 */         burn(1.0F);
/*  701 */         if (!flag2) {
/*  702 */           this.fireTicks++;
/*      */           
/*  704 */           if (this.fireTicks <= 0) {
/*  705 */             EntityCombustEvent event = new EntityCombustEvent((org.bukkit.entity.Entity)getBukkitEntity(), 8);
/*  706 */             this.world.getServer().getPluginManager().callEvent((Event)event);
/*      */             
/*  708 */             if (!event.isCancelled()) {
/*  709 */               setOnFire(event.getDuration());
/*      */             }
/*      */           } else {
/*      */             
/*  713 */             setOnFire(8);
/*      */           } 
/*      */         } 
/*  716 */       } else if (this.fireTicks <= 0) {
/*  717 */         this.fireTicks = -this.maxFireTicks;
/*      */       } 
/*      */       
/*  720 */       if (flag2 && this.fireTicks > 0) {
/*  721 */         makeSound("random.fizz", 0.7F, 1.6F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
/*  722 */         this.fireTicks = -this.maxFireTicks;
/*      */       } 
/*      */       
/*  725 */       this.world.methodProfiler.b();
/*      */     } 
/*      */   }
/*      */   
/*      */   protected String H() {
/*  730 */     return "game.neutral.swim";
/*      */   }
/*      */   
/*      */   protected void I() {
/*  734 */     int i = MathHelper.floor(this.boundingBox.a + 0.001D);
/*  735 */     int j = MathHelper.floor(this.boundingBox.b + 0.001D);
/*  736 */     int k = MathHelper.floor(this.boundingBox.c + 0.001D);
/*  737 */     int l = MathHelper.floor(this.boundingBox.d - 0.001D);
/*  738 */     int i1 = MathHelper.floor(this.boundingBox.e - 0.001D);
/*  739 */     int j1 = MathHelper.floor(this.boundingBox.f - 0.001D);
/*      */     
/*  741 */     if (this.world.b(i, j, k, l, i1, j1)) {
/*  742 */       for (int k1 = i; k1 <= l; k1++) {
/*  743 */         for (int l1 = j; l1 <= i1; l1++) {
/*  744 */           for (int i2 = k; i2 <= j1; i2++) {
/*  745 */             Block block = this.world.getType(k1, l1, i2);
/*      */             
/*      */             try {
/*  748 */               block.a(this.world, k1, l1, i2, this);
/*  749 */             } catch (Throwable throwable) {
/*  750 */               CrashReport crashreport = CrashReport.a(throwable, "Colliding entity with block");
/*  751 */               CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Block being collided with");
/*      */               
/*  753 */               CrashReportSystemDetails.a(crashreportsystemdetails, k1, l1, i2, block, this.world.getData(k1, l1, i2));
/*  754 */               throw new ReportedException(crashreport);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   protected void a(int i, int j, int k, Block block) {
/*  763 */     StepSound stepsound = block.stepSound;
/*      */     
/*  765 */     if (this.world.getType(i, j + 1, k) == Blocks.SNOW) {
/*  766 */       stepsound = Blocks.SNOW.stepSound;
/*  767 */       makeSound(stepsound.getStepSound(), stepsound.getVolume1() * 0.15F, stepsound.getVolume2());
/*  768 */     } else if (!block.getMaterial().isLiquid()) {
/*  769 */       makeSound(stepsound.getStepSound(), stepsound.getVolume1() * 0.15F, stepsound.getVolume2());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void makeSound(String s, float f, float f1) {
/*  774 */     this.world.makeSound(this, s, f, f1);
/*      */   }
/*      */   
/*      */   protected boolean g_() {
/*  778 */     return true;
/*      */   }
/*      */   
/*      */   protected void a(double d0, boolean flag) {
/*  782 */     if (flag) {
/*  783 */       if (this.fallDistance > 0.0F) {
/*  784 */         b(this.fallDistance);
/*  785 */         this.fallDistance = 0.0F;
/*      */       } 
/*  787 */     } else if (d0 < 0.0D) {
/*  788 */       this.fallDistance = (float)(this.fallDistance - d0);
/*      */     } 
/*      */   }
/*      */   
/*      */   public AxisAlignedBB J() {
/*  793 */     return null;
/*      */   }
/*      */   
/*      */   protected void burn(float i) {
/*  797 */     if (!this.fireProof) {
/*  798 */       damageEntity(DamageSource.FIRE, i);
/*      */     }
/*      */   }
/*      */   
/*      */   public final boolean isFireproof() {
/*  803 */     return this.fireProof;
/*      */   }
/*      */   
/*      */   protected void b(float f) {
/*  807 */     if (this.passenger != null) {
/*  808 */       this.passenger.b(f);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean L() {
/*  813 */     return (this.inWater || this.world.isRainingAt(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ)) || this.world.isRainingAt(MathHelper.floor(this.locX), MathHelper.floor(this.locY + this.length), MathHelper.floor(this.locZ)));
/*      */   }
/*      */   
/*      */   public boolean M() {
/*  817 */     return this.inWater;
/*      */   }
/*      */   
/*      */   public boolean N() {
/*  821 */     if (this.world.a(this.boundingBox.grow(0.0D, -0.4000000059604645D, 0.0D).shrink(0.001D, 0.001D, 0.001D), Material.WATER, this)) {
/*  822 */       if (!this.inWater && !this.justCreated) {
/*  823 */         float f = MathHelper.sqrt(this.motX * this.motX * 0.20000000298023224D + this.motY * this.motY + this.motZ * this.motZ * 0.20000000298023224D) * 0.2F;
/*      */         
/*  825 */         if (f > 1.0F) {
/*  826 */           f = 1.0F;
/*      */         }
/*      */         
/*  829 */         makeSound(O(), f, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
/*  830 */         float f1 = MathHelper.floor(this.boundingBox.b);
/*      */ 
/*      */         
/*      */         int i;
/*      */ 
/*      */         
/*  836 */         for (i = 0; i < 1.0F + this.width * 20.0F; i++) {
/*  837 */           float f2 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width;
/*  838 */           float f3 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width;
/*  839 */           this.world.addParticle("bubble", this.locX + f2, (f1 + 1.0F), this.locZ + f3, this.motX, this.motY - (this.random.nextFloat() * 0.2F), this.motZ);
/*      */         } 
/*      */         
/*  842 */         for (i = 0; i < 1.0F + this.width * 20.0F; i++) {
/*  843 */           float f2 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width;
/*  844 */           float f3 = (this.random.nextFloat() * 2.0F - 1.0F) * this.width;
/*  845 */           this.world.addParticle("splash", this.locX + f2, (f1 + 1.0F), this.locZ + f3, this.motX, this.motY, this.motZ);
/*      */         } 
/*      */       } 
/*      */       
/*  849 */       this.fallDistance = 0.0F;
/*  850 */       this.inWater = true;
/*  851 */       this.fireTicks = 0;
/*      */     } else {
/*  853 */       this.inWater = false;
/*      */     } 
/*      */     
/*  856 */     return this.inWater;
/*      */   }
/*      */   
/*      */   protected String O() {
/*  860 */     return "game.neutral.swim.splash";
/*      */   }
/*      */   
/*      */   public boolean a(Material material) {
/*  864 */     double d0 = this.locY + getHeadHeight();
/*  865 */     int i = MathHelper.floor(this.locX);
/*  866 */     int j = MathHelper.d(MathHelper.floor(d0));
/*  867 */     int k = MathHelper.floor(this.locZ);
/*  868 */     Block block = this.world.getType(i, j, k);
/*      */     
/*  870 */     if (block.getMaterial() == material) {
/*  871 */       float f = BlockFluids.b(this.world.getData(i, j, k)) - 0.11111111F;
/*  872 */       float f1 = (j + 1) - f;
/*      */       
/*  874 */       return (d0 < f1);
/*      */     } 
/*  876 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getHeadHeight() {
/*  881 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public boolean P() {
/*  885 */     return this.world.a(this.boundingBox.grow(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.LAVA);
/*      */   }
/*      */   
/*      */   public void a(float f, float f1, float f2) {
/*  889 */     float f3 = f * f + f1 * f1;
/*      */     
/*  891 */     if (f3 >= 1.0E-4F) {
/*  892 */       f3 = MathHelper.c(f3);
/*  893 */       if (f3 < 1.0F) {
/*  894 */         f3 = 1.0F;
/*      */       }
/*      */       
/*  897 */       f3 = f2 / f3;
/*  898 */       f *= f3;
/*  899 */       f1 *= f3;
/*  900 */       float f4 = MathHelper.sin(this.yaw * 3.1415927F / 180.0F);
/*  901 */       float f5 = MathHelper.cos(this.yaw * 3.1415927F / 180.0F);
/*      */       
/*  903 */       this.motX += (f * f5 - f1 * f4);
/*  904 */       this.motZ += (f1 * f5 + f * f4);
/*      */     } 
/*      */   }
/*      */   
/*      */   public float d(float f) {
/*  909 */     int i = MathHelper.floor(this.locX);
/*  910 */     int j = MathHelper.floor(this.locZ);
/*      */     
/*  912 */     if (this.world.isLoaded(i, 0, j)) {
/*  913 */       double d0 = (this.boundingBox.e - this.boundingBox.b) * 0.66D;
/*  914 */       int k = MathHelper.floor(this.locY - this.height + d0);
/*      */       
/*  916 */       return this.world.n(i, k, j);
/*      */     } 
/*  918 */     return 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void spawnIn(World world) {
/*  924 */     if (world == null) {
/*  925 */       die();
/*  926 */       this.world = ((CraftWorld)Bukkit.getServer().getWorlds().get(0)).getHandle();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  931 */     this.world = world;
/*      */   }
/*      */   
/*      */   public void setLocation(double d0, double d1, double d2, float f, float f1) {
/*  935 */     this.lastX = this.locX = d0;
/*  936 */     this.lastY = this.locY = d1;
/*  937 */     this.lastZ = this.locZ = d2;
/*  938 */     this.lastYaw = this.yaw = f;
/*  939 */     this.lastPitch = this.pitch = f1;
/*  940 */     this.V = 0.0F;
/*  941 */     double d3 = (this.lastYaw - f);
/*      */     
/*  943 */     if (d3 < -180.0D) {
/*  944 */       this.lastYaw += 360.0F;
/*      */     }
/*      */     
/*  947 */     if (d3 >= 180.0D) {
/*  948 */       this.lastYaw -= 360.0F;
/*      */     }
/*      */     
/*  951 */     setPosition(this.locX, this.locY, this.locZ);
/*  952 */     b(f, f1);
/*      */   }
/*      */   
/*      */   public void setPositionRotation(double d0, double d1, double d2, float f, float f1) {
/*  956 */     this.S = this.lastX = this.locX = d0;
/*  957 */     this.T = this.lastY = this.locY = d1 + this.height;
/*  958 */     this.U = this.lastZ = this.locZ = d2;
/*  959 */     this.yaw = f;
/*  960 */     this.pitch = f1;
/*  961 */     setPosition(this.locX, this.locY, this.locZ);
/*      */   }
/*      */   
/*      */   public float e(Entity entity) {
/*  965 */     float f = (float)(this.locX - entity.locX);
/*  966 */     float f1 = (float)(this.locY - entity.locY);
/*  967 */     float f2 = (float)(this.locZ - entity.locZ);
/*      */     
/*  969 */     return MathHelper.c(f * f + f1 * f1 + f2 * f2);
/*      */   }
/*      */   
/*      */   public double e(double d0, double d1, double d2) {
/*  973 */     double d3 = this.locX - d0;
/*  974 */     double d4 = this.locY - d1;
/*  975 */     double d5 = this.locZ - d2;
/*      */     
/*  977 */     return d3 * d3 + d4 * d4 + d5 * d5;
/*      */   }
/*      */   
/*      */   public double f(double d0, double d1, double d2) {
/*  981 */     double d3 = this.locX - d0;
/*  982 */     double d4 = this.locY - d1;
/*  983 */     double d5 = this.locZ - d2;
/*      */     
/*  985 */     return MathHelper.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
/*      */   }
/*      */   
/*      */   public double f(Entity entity) {
/*  989 */     double d0 = this.locX - entity.locX;
/*  990 */     double d1 = this.locY - entity.locY;
/*  991 */     double d2 = this.locZ - entity.locZ;
/*      */     
/*  993 */     return d0 * d0 + d1 * d1 + d2 * d2;
/*      */   }
/*      */   
/*      */   public void b_(EntityHuman entityhuman) {}
/*      */   
/*      */   public void collide(Entity entity) {
/*  999 */     if (entity.passenger != this && entity.vehicle != this) {
/* 1000 */       double d0 = entity.locX - this.locX;
/* 1001 */       double d1 = entity.locZ - this.locZ;
/* 1002 */       double d2 = MathHelper.a(d0, d1);
/*      */       
/* 1004 */       if (d2 >= 0.009999999776482582D) {
/* 1005 */         d2 = MathHelper.sqrt(d2);
/* 1006 */         d0 /= d2;
/* 1007 */         d1 /= d2;
/* 1008 */         double d3 = 1.0D / d2;
/*      */         
/* 1010 */         if (d3 > 1.0D) {
/* 1011 */           d3 = 1.0D;
/*      */         }
/*      */         
/* 1014 */         d0 *= d3;
/* 1015 */         d1 *= d3;
/* 1016 */         d0 *= 0.05000000074505806D;
/* 1017 */         d1 *= 0.05000000074505806D;
/* 1018 */         d0 *= (1.0F - this.Y);
/* 1019 */         d1 *= (1.0F - this.Y);
/* 1020 */         g(-d0, 0.0D, -d1);
/* 1021 */         entity.g(d0, 0.0D, d1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void g(double d0, double d1, double d2) {
/* 1027 */     this.motX += d0;
/* 1028 */     this.motY += d1;
/* 1029 */     this.motZ += d2;
/* 1030 */     this.al = true;
/*      */   }
/*      */   
/*      */   protected void Q() {
/* 1034 */     this.velocityChanged = true;
/*      */   }
/*      */   
/*      */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 1038 */     if (isInvulnerable()) {
/* 1039 */       return false;
/*      */     }
/* 1041 */     Q();
/* 1042 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean R() {
/* 1047 */     return false;
/*      */   }
/*      */   
/*      */   public boolean S() {
/* 1051 */     return false;
/*      */   }
/*      */   
/*      */   public void b(Entity entity, int i) {}
/*      */   
/*      */   public boolean c(NBTTagCompound nbttagcompound) {
/* 1057 */     String s = W();
/*      */     
/* 1059 */     if (!this.dead && s != null) {
/* 1060 */       nbttagcompound.setString("id", s);
/* 1061 */       e(nbttagcompound);
/* 1062 */       return true;
/*      */     } 
/* 1064 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean d(NBTTagCompound nbttagcompound) {
/* 1069 */     String s = W();
/*      */     
/* 1071 */     if (!this.dead && s != null && this.passenger == null) {
/* 1072 */       nbttagcompound.setString("id", s);
/* 1073 */       e(nbttagcompound);
/* 1074 */       return true;
/*      */     } 
/* 1076 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void e(NBTTagCompound nbttagcompound) {
/*      */     try {
/* 1082 */       nbttagcompound.set("Pos", a(new double[] { this.locX, this.locY + this.V, this.locZ }));
/* 1083 */       nbttagcompound.set("Motion", a(new double[] { this.motX, this.motY, this.motZ }));
/*      */ 
/*      */ 
/*      */       
/* 1087 */       if (Float.isNaN(this.yaw)) {
/* 1088 */         this.yaw = 0.0F;
/*      */       }
/*      */       
/* 1091 */       if (Float.isNaN(this.pitch)) {
/* 1092 */         this.pitch = 0.0F;
/*      */       }
/*      */ 
/*      */       
/* 1096 */       nbttagcompound.set("Rotation", a(new float[] { this.yaw, this.pitch }));
/* 1097 */       nbttagcompound.setFloat("FallDistance", this.fallDistance);
/* 1098 */       nbttagcompound.setShort("Fire", (short)this.fireTicks);
/* 1099 */       nbttagcompound.setShort("Air", (short)getAirTicks());
/* 1100 */       nbttagcompound.setBoolean("OnGround", this.onGround);
/* 1101 */       nbttagcompound.setInt("Dimension", this.dimension);
/* 1102 */       nbttagcompound.setBoolean("Invulnerable", this.invulnerable);
/* 1103 */       nbttagcompound.setInt("PortalCooldown", this.portalCooldown);
/* 1104 */       nbttagcompound.setLong("UUIDMost", getUniqueID().getMostSignificantBits());
/* 1105 */       nbttagcompound.setLong("UUIDLeast", getUniqueID().getLeastSignificantBits());
/*      */       
/* 1107 */       nbttagcompound.setLong("WorldUUIDLeast", this.world.getDataManager().getUUID().getLeastSignificantBits());
/* 1108 */       nbttagcompound.setLong("WorldUUIDMost", this.world.getDataManager().getUUID().getMostSignificantBits());
/* 1109 */       nbttagcompound.setInt("Bukkit.updateLevel", 2);
/*      */       
/* 1111 */       b(nbttagcompound);
/* 1112 */       if (this.vehicle != null) {
/* 1113 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*      */         
/* 1115 */         if (this.vehicle.c(nbttagcompound1)) {
/* 1116 */           nbttagcompound.set("Riding", nbttagcompound1);
/*      */         }
/*      */       } 
/* 1119 */     } catch (Throwable throwable) {
/* 1120 */       CrashReport crashreport = CrashReport.a(throwable, "Saving entity NBT");
/* 1121 */       CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Entity being saved");
/*      */       
/* 1123 */       a(crashreportsystemdetails);
/* 1124 */       throw new ReportedException(crashreport);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void f(NBTTagCompound nbttagcompound) {
/*      */     try {
/* 1130 */       NBTTagList nbttaglist = nbttagcompound.getList("Pos", 6);
/* 1131 */       NBTTagList nbttaglist1 = nbttagcompound.getList("Motion", 6);
/* 1132 */       NBTTagList nbttaglist2 = nbttagcompound.getList("Rotation", 5);
/*      */       
/* 1134 */       this.motX = nbttaglist1.d(0);
/* 1135 */       this.motY = nbttaglist1.d(1);
/* 1136 */       this.motZ = nbttaglist1.d(2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1151 */       this.lastX = this.S = this.locX = nbttaglist.d(0);
/* 1152 */       this.lastY = this.T = this.locY = nbttaglist.d(1);
/* 1153 */       this.lastZ = this.U = this.locZ = nbttaglist.d(2);
/* 1154 */       this.lastYaw = this.yaw = nbttaglist2.e(0);
/* 1155 */       this.lastPitch = this.pitch = nbttaglist2.e(1);
/* 1156 */       this.fallDistance = nbttagcompound.getFloat("FallDistance");
/* 1157 */       this.fireTicks = nbttagcompound.getShort("Fire");
/* 1158 */       setAirTicks(nbttagcompound.getShort("Air"));
/* 1159 */       this.onGround = nbttagcompound.getBoolean("OnGround");
/* 1160 */       this.dimension = nbttagcompound.getInt("Dimension");
/* 1161 */       this.invulnerable = nbttagcompound.getBoolean("Invulnerable");
/* 1162 */       this.portalCooldown = nbttagcompound.getInt("PortalCooldown");
/* 1163 */       if (nbttagcompound.hasKeyOfType("UUIDMost", 4) && nbttagcompound.hasKeyOfType("UUIDLeast", 4)) {
/* 1164 */         this.uniqueID = new UUID(nbttagcompound.getLong("UUIDMost"), nbttagcompound.getLong("UUIDLeast"));
/*      */       }
/*      */       
/* 1167 */       setPosition(this.locX, this.locY, this.locZ);
/* 1168 */       b(this.yaw, this.pitch);
/* 1169 */       a(nbttagcompound);
/* 1170 */       if (V()) {
/* 1171 */         setPosition(this.locX, this.locY, this.locZ);
/*      */       }
/*      */ 
/*      */       
/* 1175 */       if (this instanceof EntityLiving) {
/* 1176 */         EntityLiving entity = (EntityLiving)this;
/*      */ 
/*      */         
/* 1179 */         if (entity instanceof EntityTameableAnimal && !isLevelAtLeast(nbttagcompound, 2) && !nbttagcompound.getBoolean("PersistenceRequired")) {
/* 1180 */           EntityInsentient entityinsentient = (EntityInsentient)entity;
/* 1181 */           entityinsentient.persistent = !entityinsentient.isTypeNotPersistent();
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1187 */       if (!(getBukkitEntity() instanceof Vehicle)) {
/* 1188 */         if (Math.abs(this.motX) > 10.0D) {
/* 1189 */           this.motX = 0.0D;
/*      */         }
/*      */         
/* 1192 */         if (Math.abs(this.motY) > 10.0D) {
/* 1193 */           this.motY = 0.0D;
/*      */         }
/*      */         
/* 1196 */         if (Math.abs(this.motZ) > 10.0D) {
/* 1197 */           this.motZ = 0.0D;
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1203 */       if (this instanceof EntityPlayer) {
/* 1204 */         CraftWorld craftWorld; Server server = Bukkit.getServer();
/* 1205 */         World bworld = null;
/*      */ 
/*      */         
/* 1208 */         String worldName = nbttagcompound.getString("World");
/*      */         
/* 1210 */         if (nbttagcompound.hasKey("WorldUUIDMost") && nbttagcompound.hasKey("WorldUUIDLeast")) {
/* 1211 */           UUID uid = new UUID(nbttagcompound.getLong("WorldUUIDMost"), nbttagcompound.getLong("WorldUUIDLeast"));
/* 1212 */           bworld = server.getWorld(uid);
/*      */         } else {
/* 1214 */           bworld = server.getWorld(worldName);
/*      */         } 
/*      */         
/* 1217 */         if (bworld == null) {
/* 1218 */           EntityPlayer entityPlayer = (EntityPlayer)this;
/* 1219 */           craftWorld = ((CraftServer)server).getServer().getWorldServer(entityPlayer.dimension).getWorld();
/*      */         } 
/*      */         
/* 1222 */         spawnIn((craftWorld == null) ? null : craftWorld.getHandle());
/*      */       }
/*      */     
/* 1225 */     } catch (Throwable throwable) {
/* 1226 */       CrashReport crashreport = CrashReport.a(throwable, "Loading entity NBT");
/* 1227 */       CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Entity being loaded");
/*      */       
/* 1229 */       a(crashreportsystemdetails);
/* 1230 */       throw new ReportedException(crashreport);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected boolean V() {
/* 1235 */     return true;
/*      */   }
/*      */   
/*      */   protected final String W() {
/* 1239 */     return EntityTypes.b(this);
/*      */   }
/*      */   
/*      */   protected abstract void a(NBTTagCompound paramNBTTagCompound);
/*      */   
/*      */   protected abstract void b(NBTTagCompound paramNBTTagCompound);
/*      */   
/*      */   public void X() {}
/*      */   
/*      */   protected NBTTagList a(double... adouble) {
/* 1249 */     NBTTagList nbttaglist = new NBTTagList();
/* 1250 */     double[] adouble1 = adouble;
/* 1251 */     int i = adouble.length;
/*      */     
/* 1253 */     for (int j = 0; j < i; j++) {
/* 1254 */       double d0 = adouble1[j];
/*      */       
/* 1256 */       nbttaglist.add(new NBTTagDouble(d0));
/*      */     } 
/*      */     
/* 1259 */     return nbttaglist;
/*      */   }
/*      */   
/*      */   protected NBTTagList a(float... afloat) {
/* 1263 */     NBTTagList nbttaglist = new NBTTagList();
/* 1264 */     float[] afloat1 = afloat;
/* 1265 */     int i = afloat.length;
/*      */     
/* 1267 */     for (int j = 0; j < i; j++) {
/* 1268 */       float f = afloat1[j];
/*      */       
/* 1270 */       nbttaglist.add(new NBTTagFloat(f));
/*      */     } 
/*      */     
/* 1273 */     return nbttaglist;
/*      */   }
/*      */   
/*      */   public EntityItem a(Item item, int i) {
/* 1277 */     return a(item, i, 0.0F);
/*      */   }
/*      */   
/*      */   public EntityItem a(Item item, int i, float f) {
/* 1281 */     return a(new ItemStack(item, i, 0), f);
/*      */   }
/*      */   
/*      */   public EntityItem a(ItemStack itemstack, float f) {
/* 1285 */     if (itemstack.count != 0 && itemstack.getItem() != null) {
/*      */       
/* 1287 */       if (this instanceof EntityLiving && ((EntityLiving)this).drops != null) {
/* 1288 */         ((EntityLiving)this).drops.add(CraftItemStack.asBukkitCopy(itemstack));
/* 1289 */         return null;
/*      */       } 
/*      */ 
/*      */       
/* 1293 */       EntityItem entityitem = new EntityItem(this.world, this.locX, this.locY + f, this.locZ, itemstack);
/*      */       
/* 1295 */       entityitem.pickupDelay = 10;
/* 1296 */       this.world.addEntity(entityitem);
/* 1297 */       return entityitem;
/*      */     } 
/* 1299 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isAlive() {
/* 1304 */     return !this.dead;
/*      */   }
/*      */   
/*      */   public boolean inBlock() {
/* 1308 */     for (int i = 0; i < 8; i++) {
/* 1309 */       float f = (((i >> 0) % 2) - 0.5F) * this.width * 0.8F;
/* 1310 */       float f1 = (((i >> 1) % 2) - 0.5F) * 0.1F;
/* 1311 */       float f2 = (((i >> 2) % 2) - 0.5F) * this.width * 0.8F;
/* 1312 */       int j = MathHelper.floor(this.locX + f);
/* 1313 */       int k = MathHelper.floor(this.locY + getHeadHeight() + f1);
/* 1314 */       int l = MathHelper.floor(this.locZ + f2);
/*      */       
/* 1316 */       if (this.world.getType(j, k, l).r()) {
/* 1317 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 1321 */     return false;
/*      */   }
/*      */   
/*      */   public boolean c(EntityHuman entityhuman) {
/* 1325 */     return false;
/*      */   }
/*      */   
/*      */   public AxisAlignedBB h(Entity entity) {
/* 1329 */     return null;
/*      */   }
/*      */   
/*      */   public void ab() {
/* 1333 */     if (this.vehicle.dead) {
/* 1334 */       this.vehicle = null;
/*      */     } else {
/* 1336 */       this.motX = 0.0D;
/* 1337 */       this.motY = 0.0D;
/* 1338 */       this.motZ = 0.0D;
/* 1339 */       h();
/* 1340 */       if (this.vehicle != null) {
/* 1341 */         this.vehicle.ac();
/* 1342 */         this.h += (this.vehicle.yaw - this.vehicle.lastYaw);
/*      */         
/* 1344 */         for (this.g += (this.vehicle.pitch - this.vehicle.lastPitch); this.h >= 180.0D; this.h -= 360.0D);
/*      */ 
/*      */ 
/*      */         
/* 1348 */         while (this.h < -180.0D) {
/* 1349 */           this.h += 360.0D;
/*      */         }
/*      */         
/* 1352 */         while (this.g >= 180.0D) {
/* 1353 */           this.g -= 360.0D;
/*      */         }
/*      */         
/* 1356 */         while (this.g < -180.0D) {
/* 1357 */           this.g += 360.0D;
/*      */         }
/*      */         
/* 1360 */         double d0 = this.h * 0.5D;
/* 1361 */         double d1 = this.g * 0.5D;
/* 1362 */         float f = 10.0F;
/*      */         
/* 1364 */         if (d0 > f) {
/* 1365 */           d0 = f;
/*      */         }
/*      */         
/* 1368 */         if (d0 < -f) {
/* 1369 */           d0 = -f;
/*      */         }
/*      */         
/* 1372 */         if (d1 > f) {
/* 1373 */           d1 = f;
/*      */         }
/*      */         
/* 1376 */         if (d1 < -f) {
/* 1377 */           d1 = -f;
/*      */         }
/*      */         
/* 1380 */         this.h -= d0;
/* 1381 */         this.g -= d1;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void ac() {
/* 1387 */     if (this.passenger != null) {
/* 1388 */       this.passenger.setPosition(this.locX, this.locY + ad() + this.passenger.ad(), this.locZ);
/*      */     }
/*      */   }
/*      */   
/*      */   public double ad() {
/* 1393 */     return this.height;
/*      */   }
/*      */   
/*      */   public double ae() {
/* 1397 */     return this.length * 0.75D;
/*      */   }
/*      */ 
/*      */   
/*      */   public void mount(Entity entity) {
/* 1402 */     setPassengerOf(entity);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public CraftEntity getBukkitEntity() {
/* 1408 */     if (this.bukkitEntity == null) {
/* 1409 */       this.bukkitEntity = CraftEntity.getEntity(this.world.getServer(), this);
/*      */     }
/* 1411 */     return this.bukkitEntity;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPassengerOf(Entity entity) {
/* 1418 */     Entity originalVehicle = this.vehicle;
/* 1419 */     Entity originalPassenger = (this.vehicle == null) ? null : this.vehicle.passenger;
/* 1420 */     PluginManager pluginManager = Bukkit.getPluginManager();
/* 1421 */     getBukkitEntity();
/*      */     
/* 1423 */     this.g = 0.0D;
/* 1424 */     this.h = 0.0D;
/* 1425 */     if (entity == null) {
/* 1426 */       if (this.vehicle != null) {
/*      */         
/* 1428 */         if (this.bukkitEntity instanceof LivingEntity && this.vehicle.getBukkitEntity() instanceof Vehicle) {
/* 1429 */           VehicleExitEvent event = new VehicleExitEvent((Vehicle)this.vehicle.getBukkitEntity(), (LivingEntity)this.bukkitEntity);
/* 1430 */           pluginManager.callEvent((Event)event);
/*      */           
/* 1432 */           if (event.isCancelled() || this.vehicle != originalVehicle) {
/*      */             return;
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/* 1438 */         setPositionRotation(this.vehicle.locX, this.vehicle.boundingBox.b + this.vehicle.length, this.vehicle.locZ, this.yaw, this.pitch);
/* 1439 */         this.vehicle.passenger = null;
/*      */       } 
/*      */       
/* 1442 */       this.vehicle = null;
/*      */     } else {
/*      */       
/* 1445 */       if (this.bukkitEntity instanceof LivingEntity && entity.getBukkitEntity() instanceof Vehicle && entity.world.isChunkLoaded((int)entity.locX >> 4, (int)entity.locZ >> 4)) {
/*      */         
/* 1447 */         VehicleExitEvent exitEvent = null;
/* 1448 */         if (this.vehicle != null && this.vehicle.getBukkitEntity() instanceof Vehicle) {
/* 1449 */           exitEvent = new VehicleExitEvent((Vehicle)this.vehicle.getBukkitEntity(), (LivingEntity)this.bukkitEntity);
/* 1450 */           pluginManager.callEvent((Event)exitEvent);
/*      */           
/* 1452 */           if (exitEvent.isCancelled() || this.vehicle != originalVehicle || (this.vehicle != null && this.vehicle.passenger != originalPassenger)) {
/*      */             return;
/*      */           }
/*      */         } 
/*      */         
/* 1457 */         VehicleEnterEvent event = new VehicleEnterEvent((Vehicle)entity.getBukkitEntity(), (org.bukkit.entity.Entity)this.bukkitEntity);
/* 1458 */         pluginManager.callEvent((Event)event);
/*      */ 
/*      */         
/* 1461 */         if (event.isCancelled() || this.vehicle != originalVehicle || (this.vehicle != null && this.vehicle.passenger != originalPassenger)) {
/*      */           
/* 1463 */           if (exitEvent != null && this.vehicle == originalVehicle && this.vehicle != null && this.vehicle.passenger == originalPassenger) {
/* 1464 */             setPositionRotation(this.vehicle.locX, this.vehicle.boundingBox.b + this.vehicle.length, this.vehicle.locZ, this.yaw, this.pitch);
/* 1465 */             this.vehicle.passenger = null;
/* 1466 */             this.vehicle = null;
/*      */           } 
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/*      */       
/* 1473 */       if (this.vehicle != null) {
/* 1474 */         this.vehicle.passenger = null;
/*      */       }
/*      */       
/* 1477 */       if (entity != null) {
/* 1478 */         for (Entity entity1 = entity.vehicle; entity1 != null; entity1 = entity1.vehicle) {
/* 1479 */           if (entity1 == this) {
/*      */             return;
/*      */           }
/*      */         } 
/*      */       }
/*      */       
/* 1485 */       this.vehicle = entity;
/* 1486 */       entity.passenger = this;
/*      */     } 
/*      */   }
/*      */   
/*      */   public float af() {
/* 1491 */     return 0.1F;
/*      */   }
/*      */   
/*      */   public Vec3D ag() {
/* 1495 */     return null;
/*      */   }
/*      */   
/*      */   public void ah() {
/* 1499 */     if (this.portalCooldown > 0) {
/* 1500 */       this.portalCooldown = ai();
/*      */     } else {
/* 1502 */       double d0 = this.lastX - this.locX;
/* 1503 */       double d1 = this.lastZ - this.locZ;
/*      */       
/* 1505 */       if (!this.world.isStatic && !this.an) {
/* 1506 */         this.aq = Direction.a(d0, d1);
/*      */       }
/*      */       
/* 1509 */       this.an = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   public int ai() {
/* 1514 */     return 300;
/*      */   }
/*      */   
/*      */   public ItemStack[] getEquipment() {
/* 1518 */     return null;
/*      */   }
/*      */   
/*      */   public void setEquipment(int i, ItemStack itemstack) {}
/*      */   
/*      */   public boolean isBurning() {
/* 1524 */     boolean flag = (this.world != null && this.world.isStatic);
/*      */     
/* 1526 */     return (!this.fireProof && (this.fireTicks > 0 || (flag && g(0))));
/*      */   }
/*      */   
/*      */   public boolean am() {
/* 1530 */     return (this.vehicle != null);
/*      */   }
/*      */   
/*      */   public boolean isSneaking() {
/* 1534 */     return g(1);
/*      */   }
/*      */   
/*      */   public void setSneaking(boolean flag) {
/* 1538 */     a(1, flag);
/*      */   }
/*      */   
/*      */   public boolean isSprinting() {
/* 1542 */     return g(3);
/*      */   }
/*      */   
/*      */   public void setSprinting(boolean flag) {
/* 1546 */     a(3, flag);
/*      */   }
/*      */   
/*      */   public boolean isInvisible() {
/* 1550 */     return g(5);
/*      */   }
/*      */   
/*      */   public void setInvisible(boolean flag) {
/* 1554 */     a(5, flag);
/*      */   }
/*      */   
/*      */   public void e(boolean flag) {
/* 1558 */     a(4, flag);
/*      */   }
/*      */   
/*      */   protected boolean g(int i) {
/* 1562 */     return ((this.datawatcher.getByte(0) & 1 << i) != 0);
/*      */   }
/*      */   
/*      */   protected void a(int i, boolean flag) {
/* 1566 */     byte b0 = this.datawatcher.getByte(0);
/*      */     
/* 1568 */     if (flag) {
/* 1569 */       this.datawatcher.watch(0, Byte.valueOf((byte)(b0 | 1 << i)));
/*      */     } else {
/* 1571 */       this.datawatcher.watch(0, Byte.valueOf((byte)(b0 & (1 << i ^ 0xFFFFFFFF))));
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getAirTicks() {
/* 1576 */     return this.datawatcher.getShort(1);
/*      */   }
/*      */   
/*      */   public void setAirTicks(int i) {
/* 1580 */     this.datawatcher.watch(1, Short.valueOf((short)i));
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(EntityLightning entitylightning) {
/* 1585 */     CraftEntity craftEntity1 = getBukkitEntity();
/* 1586 */     CraftEntity craftEntity2 = entitylightning.getBukkitEntity();
/* 1587 */     PluginManager pluginManager = Bukkit.getPluginManager();
/*      */     
/* 1589 */     if (craftEntity1 instanceof Hanging) {
/* 1590 */       HangingBreakByEntityEvent hangingEvent = new HangingBreakByEntityEvent((Hanging)craftEntity1, (org.bukkit.entity.Entity)craftEntity2);
/* 1591 */       PaintingBreakByEntityEvent paintingEvent = null;
/*      */       
/* 1593 */       if (craftEntity1 instanceof Painting) {
/* 1594 */         paintingEvent = new PaintingBreakByEntityEvent((Painting)craftEntity1, (org.bukkit.entity.Entity)craftEntity2);
/*      */       }
/*      */       
/* 1597 */       pluginManager.callEvent((Event)hangingEvent);
/*      */       
/* 1599 */       if (paintingEvent != null) {
/* 1600 */         paintingEvent.setCancelled(hangingEvent.isCancelled());
/* 1601 */         pluginManager.callEvent((Event)paintingEvent);
/*      */       } 
/*      */       
/* 1604 */       if (hangingEvent.isCancelled() || (paintingEvent != null && paintingEvent.isCancelled())) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */     
/* 1609 */     if (this.fireProof) {
/*      */       return;
/*      */     }
/* 1612 */     CraftEventFactory.entityDamage = entitylightning;
/* 1613 */     if (!damageEntity(DamageSource.FIRE, 5.0F)) {
/* 1614 */       CraftEventFactory.entityDamage = null;
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1619 */     this.fireTicks++;
/* 1620 */     if (this.fireTicks == 0) {
/*      */       
/* 1622 */       EntityCombustByEntityEvent entityCombustEvent = new EntityCombustByEntityEvent((org.bukkit.entity.Entity)craftEntity2, (org.bukkit.entity.Entity)craftEntity1, 8);
/* 1623 */       pluginManager.callEvent((Event)entityCombustEvent);
/* 1624 */       if (!entityCombustEvent.isCancelled()) {
/* 1625 */         setOnFire(entityCombustEvent.getDuration());
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(EntityLiving entityliving) {}
/*      */   
/*      */   protected boolean j(double d0, double d1, double d2) {
/* 1634 */     int i = MathHelper.floor(d0);
/* 1635 */     int j = MathHelper.floor(d1);
/* 1636 */     int k = MathHelper.floor(d2);
/* 1637 */     double d3 = d0 - i;
/* 1638 */     double d4 = d1 - j;
/* 1639 */     double d5 = d2 - k;
/* 1640 */     List list = this.world.a(this.boundingBox);
/*      */     
/* 1642 */     if (list.isEmpty() && !this.world.q(i, j, k)) {
/* 1643 */       return false;
/*      */     }
/* 1645 */     boolean flag = !this.world.q(i - 1, j, k);
/* 1646 */     boolean flag1 = !this.world.q(i + 1, j, k);
/* 1647 */     boolean flag2 = !this.world.q(i, j - 1, k);
/* 1648 */     boolean flag3 = !this.world.q(i, j + 1, k);
/* 1649 */     boolean flag4 = !this.world.q(i, j, k - 1);
/* 1650 */     boolean flag5 = !this.world.q(i, j, k + 1);
/* 1651 */     byte b0 = 3;
/* 1652 */     double d6 = 9999.0D;
/*      */     
/* 1654 */     if (flag && d3 < d6) {
/* 1655 */       d6 = d3;
/* 1656 */       b0 = 0;
/*      */     } 
/*      */     
/* 1659 */     if (flag1 && 1.0D - d3 < d6) {
/* 1660 */       d6 = 1.0D - d3;
/* 1661 */       b0 = 1;
/*      */     } 
/*      */     
/* 1664 */     if (flag3 && 1.0D - d4 < d6) {
/* 1665 */       d6 = 1.0D - d4;
/* 1666 */       b0 = 3;
/*      */     } 
/*      */     
/* 1669 */     if (flag4 && d5 < d6) {
/* 1670 */       d6 = d5;
/* 1671 */       b0 = 4;
/*      */     } 
/*      */     
/* 1674 */     if (flag5 && 1.0D - d5 < d6) {
/* 1675 */       d6 = 1.0D - d5;
/* 1676 */       b0 = 5;
/*      */     } 
/*      */     
/* 1679 */     float f = this.random.nextFloat() * 0.2F + 0.1F;
/*      */     
/* 1681 */     if (b0 == 0) {
/* 1682 */       this.motX = -f;
/*      */     }
/*      */     
/* 1685 */     if (b0 == 1) {
/* 1686 */       this.motX = f;
/*      */     }
/*      */     
/* 1689 */     if (b0 == 2) {
/* 1690 */       this.motY = -f;
/*      */     }
/*      */     
/* 1693 */     if (b0 == 3) {
/* 1694 */       this.motY = f;
/*      */     }
/*      */     
/* 1697 */     if (b0 == 4) {
/* 1698 */       this.motZ = -f;
/*      */     }
/*      */     
/* 1701 */     if (b0 == 5) {
/* 1702 */       this.motZ = f;
/*      */     }
/*      */     
/* 1705 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void as() {
/* 1710 */     this.I = true;
/* 1711 */     this.fallDistance = 0.0F;
/*      */   }
/*      */   
/*      */   public String getName() {
/* 1715 */     String s = EntityTypes.b(this);
/*      */     
/* 1717 */     if (s == null) {
/* 1718 */       s = "generic";
/*      */     }
/*      */     
/* 1721 */     return LocaleI18n.get("entity." + s + ".name");
/*      */   }
/*      */   
/*      */   public Entity[] at() {
/* 1725 */     return null;
/*      */   }
/*      */   
/*      */   public boolean i(Entity entity) {
/* 1729 */     return (this == entity);
/*      */   }
/*      */   
/*      */   public float getHeadRotation() {
/* 1733 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public boolean av() {
/* 1737 */     return true;
/*      */   }
/*      */   
/*      */   public boolean j(Entity entity) {
/* 1741 */     return false;
/*      */   }
/*      */   
/*      */   public String toString() {
/* 1745 */     return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", new Object[] { getClass().getSimpleName(), getName(), Integer.valueOf(this.id), (this.world == null) ? "~NULL~" : this.world.getWorldData().getName(), Double.valueOf(this.locX), Double.valueOf(this.locY), Double.valueOf(this.locZ) });
/*      */   }
/*      */   
/*      */   public boolean isInvulnerable() {
/* 1749 */     return this.invulnerable;
/*      */   }
/*      */   
/*      */   public void k(Entity entity) {
/* 1753 */     setPositionRotation(entity.locX, entity.locY, entity.locZ, entity.yaw, entity.pitch);
/*      */   }
/*      */   
/*      */   public void a(Entity entity, boolean flag) {
/* 1757 */     NBTTagCompound nbttagcompound = new NBTTagCompound();
/*      */     
/* 1759 */     entity.e(nbttagcompound);
/* 1760 */     f(nbttagcompound);
/* 1761 */     this.portalCooldown = entity.portalCooldown;
/* 1762 */     this.aq = entity.aq;
/*      */   }
/*      */   
/*      */   public void b(int i) {
/* 1766 */     if (!this.world.isStatic && !this.dead) {
/* 1767 */       this.world.methodProfiler.a("changeDimension");
/* 1768 */       MinecraftServer minecraftserver = MinecraftServer.getServer();
/*      */ 
/*      */       
/* 1771 */       WorldServer exitWorld = null;
/* 1772 */       if (this.dimension < 10)
/*      */       {
/* 1774 */         for (WorldServer world : minecraftserver.worlds) {
/* 1775 */           if (world.dimension == i) {
/* 1776 */             exitWorld = world;
/*      */           }
/*      */         } 
/*      */       }
/*      */       
/* 1781 */       Location enter = getBukkitEntity().getLocation();
/* 1782 */       Location exit = (exitWorld != null) ? minecraftserver.getPlayerList().calculateTarget(enter, minecraftserver.getWorldServer(i)) : null;
/* 1783 */       boolean useTravelAgent = (exitWorld != null && (this.dimension != 1 || exitWorld.dimension != 1));
/*      */       
/* 1785 */       TravelAgent agent = (exit != null) ? (TravelAgent)((CraftWorld)exit.getWorld()).getHandle().getTravelAgent() : CraftTravelAgent.DEFAULT;
/* 1786 */       EntityPortalEvent event = new EntityPortalEvent((org.bukkit.entity.Entity)getBukkitEntity(), enter, exit, agent);
/* 1787 */       event.useTravelAgent(useTravelAgent);
/* 1788 */       event.getEntity().getServer().getPluginManager().callEvent((Event)event);
/* 1789 */       if (event.isCancelled() || event.getTo() == null || event.getTo().getWorld() == null || !isAlive()) {
/*      */         return;
/*      */       }
/* 1792 */       exit = event.useTravelAgent() ? event.getPortalTravelAgent().findOrCreate(event.getTo()) : event.getTo();
/* 1793 */       teleportTo(exit, true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void teleportTo(Location exit, boolean portal) {
/* 1799 */     WorldServer worldserver = ((CraftWorld)getBukkitEntity().getLocation().getWorld()).getHandle();
/* 1800 */     WorldServer worldserver1 = ((CraftWorld)exit.getWorld()).getHandle();
/* 1801 */     int i = worldserver1.dimension;
/*      */ 
/*      */     
/* 1804 */     this.dimension = i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1812 */     this.world.kill(this);
/* 1813 */     this.dead = false;
/* 1814 */     this.world.methodProfiler.a("reposition");
/*      */ 
/*      */     
/* 1817 */     boolean before = worldserver1.chunkProviderServer.forceChunkLoad;
/* 1818 */     worldserver1.chunkProviderServer.forceChunkLoad = true;
/* 1819 */     worldserver1.getMinecraftServer().getPlayerList().repositionEntity(this, exit, portal);
/* 1820 */     worldserver1.chunkProviderServer.forceChunkLoad = before;
/*      */     
/* 1822 */     this.world.methodProfiler.c("reloading");
/* 1823 */     Entity entity = EntityTypes.createEntityByName(EntityTypes.b(this), worldserver1);
/*      */     
/* 1825 */     if (entity != null) {
/* 1826 */       entity.a(this, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1835 */       worldserver1.addEntity(entity);
/*      */       
/* 1837 */       getBukkitEntity().setHandle(entity);
/* 1838 */       entity.bukkitEntity = getBukkitEntity();
/*      */     } 
/*      */ 
/*      */     
/* 1842 */     this.dead = true;
/* 1843 */     this.world.methodProfiler.b();
/* 1844 */     worldserver.i();
/* 1845 */     worldserver1.i();
/* 1846 */     this.world.methodProfiler.b();
/*      */   }
/*      */ 
/*      */   
/*      */   public float a(Explosion explosion, World world, int i, int j, int k, Block block) {
/* 1851 */     return block.a(this);
/*      */   }
/*      */   
/*      */   public boolean a(Explosion explosion, World world, int i, int j, int k, Block block, float f) {
/* 1855 */     return true;
/*      */   }
/*      */   
/*      */   public int ax() {
/* 1859 */     return 3;
/*      */   }
/*      */   
/*      */   public int ay() {
/* 1863 */     return this.aq;
/*      */   }
/*      */   
/*      */   public boolean az() {
/* 1867 */     return false;
/*      */   }
/*      */   
/*      */   public void a(CrashReportSystemDetails crashreportsystemdetails) {
/* 1871 */     crashreportsystemdetails.a("Entity Type", new CrashReportEntityType(this));
/* 1872 */     crashreportsystemdetails.a("Entity ID", Integer.valueOf(this.id));
/* 1873 */     crashreportsystemdetails.a("Entity Name", new CrashReportEntityName(this));
/* 1874 */     crashreportsystemdetails.a("Entity's Exact location", String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.locX), Double.valueOf(this.locY), Double.valueOf(this.locZ) }));
/* 1875 */     crashreportsystemdetails.a("Entity's Block location", CrashReportSystemDetails.a(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ)));
/* 1876 */     crashreportsystemdetails.a("Entity's Momentum", String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.motX), Double.valueOf(this.motY), Double.valueOf(this.motZ) }));
/*      */   }
/*      */   
/*      */   public UUID getUniqueID() {
/* 1880 */     return this.uniqueID;
/*      */   }
/*      */   
/*      */   public boolean aC() {
/* 1884 */     return true;
/*      */   }
/*      */   
/*      */   public IChatBaseComponent getScoreboardDisplayName() {
/* 1888 */     return new ChatComponentText(getName());
/*      */   }
/*      */   
/*      */   public void i(int i) {}
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\Entity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */