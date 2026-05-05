/*      */ package net.minecraft.server.v1_7_R4;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*      */ import org.bukkit.OfflinePlayer;
/*      */ import org.bukkit.block.Block;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftHumanEntity;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftItem;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
/*      */ import org.bukkit.entity.Entity;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.entity.EntityCombustByEntityEvent;
/*      */ import org.bukkit.event.player.PlayerBedEnterEvent;
/*      */ import org.bukkit.event.player.PlayerBedLeaveEvent;
/*      */ import org.bukkit.event.player.PlayerDropItemEvent;
/*      */ import org.bukkit.event.player.PlayerItemConsumeEvent;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.scoreboard.Team;
/*      */ 
/*      */ public abstract class EntityHuman extends EntityLiving implements ICommandListener {
/*   25 */   public PlayerInventory inventory = new PlayerInventory(this);
/*   26 */   private InventoryEnderChest enderChest = new InventoryEnderChest();
/*      */   public Container defaultContainer;
/*      */   public Container activeContainer;
/*   29 */   protected FoodMetaData foodData = new FoodMetaData(this);
/*      */   
/*      */   protected int bq;
/*      */   public float br;
/*      */   public float bs;
/*      */   public int bt;
/*      */   public double bu;
/*      */   public double bv;
/*      */   public double bw;
/*      */   public double bx;
/*      */   public double by;
/*      */   public double bz;
/*      */   public boolean sleeping;
/*      */   public boolean fauxSleeping;
/*   43 */   public String spawnWorld = ""; public ChunkCoordinates bB; public int sleepTicks; public float bC; public float bD; private ChunkCoordinates c; private boolean d;
/*      */   private ChunkCoordinates e;
/*      */   
/*      */   public CraftHumanEntity getBukkitEntity() {
/*   47 */     return (CraftHumanEntity)super.getBukkitEntity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   58 */   public PlayerAbilities abilities = new PlayerAbilities();
/*   59 */   public int oldLevel = -1;
/*      */   public int expLevel;
/*      */   public int expTotal;
/*      */   public float exp;
/*      */   private ItemStack f;
/*      */   private int g;
/*   65 */   protected float bI = 0.1F;
/*   66 */   protected float bJ = 0.02F;
/*      */   private int h;
/*      */   private final GameProfile i;
/*      */   public EntityFishingHook hookedFish;
/*      */   
/*      */   public EntityHuman(World world, GameProfile gameprofile) {
/*   72 */     super(world);
/*   73 */     this.uniqueID = a(gameprofile);
/*   74 */     this.i = gameprofile;
/*   75 */     this.defaultContainer = new ContainerPlayer(this.inventory, !world.isStatic, this);
/*   76 */     this.activeContainer = this.defaultContainer;
/*   77 */     this.height = 1.62F;
/*   78 */     ChunkCoordinates chunkcoordinates = world.getSpawn();
/*      */     
/*   80 */     setPositionRotation(chunkcoordinates.x + 0.5D, (chunkcoordinates.y + 1), chunkcoordinates.z + 0.5D, 0.0F, 0.0F);
/*   81 */     this.aZ = 180.0F;
/*   82 */     this.maxFireTicks = 20;
/*      */   }
/*      */   
/*      */   protected void aD() {
/*   86 */     super.aD();
/*   87 */     getAttributeMap().b(GenericAttributes.e).setValue(1.0D);
/*      */   }
/*      */   
/*      */   protected void c() {
/*   91 */     super.c();
/*   92 */     this.datawatcher.a(16, Byte.valueOf((byte)0));
/*   93 */     this.datawatcher.a(17, Float.valueOf(0.0F));
/*   94 */     this.datawatcher.a(18, Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   public boolean by() {
/*   98 */     return (this.f != null);
/*      */   }
/*      */   
/*      */   public void bA() {
/*  102 */     if (this.f != null) {
/*  103 */       this.f.b(this.world, this, this.g);
/*      */     }
/*      */     
/*  106 */     bB();
/*      */   }
/*      */   
/*      */   public void bB() {
/*  110 */     this.f = null;
/*  111 */     this.g = 0;
/*  112 */     if (!this.world.isStatic) {
/*  113 */       e(false);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isBlocking() {
/*  118 */     return (by() && this.f.getItem().d(this.f) == EnumAnimation.BLOCK);
/*      */   }
/*      */   
/*      */   public void h() {
/*  122 */     if (this.f != null) {
/*  123 */       ItemStack itemstack = this.inventory.getItemInHand();
/*      */       
/*  125 */       if (itemstack == this.f) {
/*  126 */         if (this.g <= 25 && this.g % 4 == 0) {
/*  127 */           c(itemstack, 5);
/*      */         }
/*      */         
/*  130 */         if (--this.g == 0 && !this.world.isStatic) {
/*  131 */           p();
/*      */         }
/*      */       } else {
/*  134 */         bB();
/*      */       } 
/*      */     } 
/*      */     
/*  138 */     if (this.bt > 0) {
/*  139 */       this.bt--;
/*      */     }
/*      */     
/*  142 */     if (isSleeping()) {
/*  143 */       this.sleepTicks++;
/*  144 */       if (this.sleepTicks > 100) {
/*  145 */         this.sleepTicks = 100;
/*      */       }
/*      */       
/*  148 */       if (!this.world.isStatic) {
/*  149 */         if (!j()) {
/*  150 */           a(true, true, false);
/*  151 */         } else if (this.world.w()) {
/*  152 */           a(false, true, true);
/*      */         } 
/*      */       }
/*  155 */     } else if (this.sleepTicks > 0) {
/*  156 */       this.sleepTicks++;
/*  157 */       if (this.sleepTicks >= 110) {
/*  158 */         this.sleepTicks = 0;
/*      */       }
/*      */     } 
/*      */     
/*  162 */     super.h();
/*  163 */     if (!this.world.isStatic && this.activeContainer != null && !this.activeContainer.a(this)) {
/*  164 */       closeInventory();
/*  165 */       this.activeContainer = this.defaultContainer;
/*      */     } 
/*      */     
/*  168 */     if (isBurning() && this.abilities.isInvulnerable) {
/*  169 */       extinguish();
/*      */     }
/*      */     
/*  172 */     this.bu = this.bx;
/*  173 */     this.bv = this.by;
/*  174 */     this.bw = this.bz;
/*  175 */     double d0 = this.locX - this.bx;
/*  176 */     double d1 = this.locY - this.by;
/*  177 */     double d2 = this.locZ - this.bz;
/*  178 */     double d3 = 10.0D;
/*      */     
/*  180 */     if (d0 > d3) {
/*  181 */       this.bu = this.bx = this.locX;
/*      */     }
/*      */     
/*  184 */     if (d2 > d3) {
/*  185 */       this.bw = this.bz = this.locZ;
/*      */     }
/*      */     
/*  188 */     if (d1 > d3) {
/*  189 */       this.bv = this.by = this.locY;
/*      */     }
/*      */     
/*  192 */     if (d0 < -d3) {
/*  193 */       this.bu = this.bx = this.locX;
/*      */     }
/*      */     
/*  196 */     if (d2 < -d3) {
/*  197 */       this.bw = this.bz = this.locZ;
/*      */     }
/*      */     
/*  200 */     if (d1 < -d3) {
/*  201 */       this.bv = this.by = this.locY;
/*      */     }
/*      */     
/*  204 */     this.bx += d0 * 0.25D;
/*  205 */     this.bz += d2 * 0.25D;
/*  206 */     this.by += d1 * 0.25D;
/*  207 */     if (this.vehicle == null) {
/*  208 */       this.e = null;
/*      */     }
/*      */     
/*  211 */     if (!this.world.isStatic) {
/*  212 */       this.foodData.a(this);
/*  213 */       a(StatisticList.g, 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int D() {
/*  218 */     return this.abilities.isInvulnerable ? 0 : 80;
/*      */   }
/*      */   
/*      */   protected String H() {
/*  222 */     return "game.player.swim";
/*      */   }
/*      */   
/*      */   protected String O() {
/*  226 */     return "game.player.swim.splash";
/*      */   }
/*      */   
/*      */   public int ai() {
/*  230 */     return 10;
/*      */   }
/*      */   
/*      */   public void makeSound(String s, float f, float f1) {
/*  234 */     this.world.a(this, s, f, f1);
/*      */   }
/*      */   
/*      */   protected void c(ItemStack itemstack, int i) {
/*  238 */     if (itemstack.o() == EnumAnimation.DRINK) {
/*  239 */       makeSound("random.drink", 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
/*      */     }
/*      */     
/*  242 */     if (itemstack.o() == EnumAnimation.EAT) {
/*  243 */       for (int j = 0; j < i; j++) {
/*  244 */         Vec3D vec3d = Vec3D.a((this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
/*      */         
/*  246 */         vec3d.a(-this.pitch * 3.1415927F / 180.0F);
/*  247 */         vec3d.b(-this.yaw * 3.1415927F / 180.0F);
/*  248 */         Vec3D vec3d1 = Vec3D.a((this.random.nextFloat() - 0.5D) * 0.3D, -this.random.nextFloat() * 0.6D - 0.3D, 0.6D);
/*      */         
/*  250 */         vec3d1.a(-this.pitch * 3.1415927F / 180.0F);
/*  251 */         vec3d1.b(-this.yaw * 3.1415927F / 180.0F);
/*  252 */         vec3d1 = vec3d1.add(this.locX, this.locY + getHeadHeight(), this.locZ);
/*  253 */         String s = "iconcrack_" + Item.getId(itemstack.getItem());
/*      */         
/*  255 */         if (itemstack.usesData()) {
/*  256 */           s = s + "_" + itemstack.getData();
/*      */         }
/*      */         
/*  259 */         this.world.addParticle(s, vec3d1.a, vec3d1.b, vec3d1.c, vec3d.a, vec3d.b + 0.05D, vec3d.c);
/*      */       } 
/*      */       
/*  262 */       makeSound("random.eat", 0.5F + 0.5F * this.random.nextInt(2), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void p() {
/*  267 */     if (this.f != null) {
/*  268 */       c(this.f, 16);
/*  269 */       int i = this.f.count;
/*      */ 
/*      */       
/*  272 */       ItemStack craftItem = CraftItemStack.asBukkitCopy(this.f);
/*  273 */       PlayerItemConsumeEvent event = new PlayerItemConsumeEvent((Player)getBukkitEntity(), craftItem);
/*  274 */       this.world.getServer().getPluginManager().callEvent((Event)event);
/*      */       
/*  276 */       if (event.isCancelled()) {
/*      */         
/*  278 */         if (this instanceof EntityPlayer) {
/*  279 */           ((EntityPlayer)this).playerConnection.sendPacket(new PacketPlayOutSetSlot(0, (this.activeContainer.getSlot(this.inventory, this.inventory.itemInHandIndex)).index, this.f));
/*      */         }
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  285 */       if (!craftItem.equals(event.getItem())) {
/*  286 */         CraftItemStack.asNMSCopy(event.getItem()).b(this.world, this);
/*      */ 
/*      */         
/*  289 */         if (this instanceof EntityPlayer) {
/*  290 */           ((EntityPlayer)this).playerConnection.sendPacket(new PacketPlayOutSetSlot(0, (this.activeContainer.getSlot(this.inventory, this.inventory.itemInHandIndex)).index, this.f));
/*      */         }
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  296 */       ItemStack itemstack = this.f.b(this.world, this);
/*      */       
/*  298 */       if (itemstack != this.f || (itemstack != null && itemstack.count != i)) {
/*  299 */         this.inventory.items[this.inventory.itemInHandIndex] = itemstack;
/*  300 */         if (itemstack.count == 0) {
/*  301 */           this.inventory.items[this.inventory.itemInHandIndex] = null;
/*      */         }
/*      */       } 
/*      */       
/*  305 */       bB();
/*      */     } 
/*      */   }
/*      */   
/*      */   protected boolean bh() {
/*  310 */     return (getHealth() <= 0.0F || isSleeping());
/*      */   }
/*      */ 
/*      */   
/*      */   public void closeInventory() {
/*  315 */     this.activeContainer = this.defaultContainer;
/*      */   }
/*      */ 
/*      */   
/*      */   public void mount(Entity entity) {
/*  320 */     setPassengerOf(entity);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPassengerOf(Entity entity) {
/*  325 */     if (this.vehicle != null && entity == null) {
/*      */       
/*  327 */       Entity originalVehicle = this.vehicle;
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
/*  340 */       super.setPassengerOf(entity);
/*  341 */       if (!this.world.isStatic && this.vehicle == null) {
/*  342 */         m(originalVehicle);
/*      */       }
/*      */     } else {
/*      */       
/*  346 */       super.setPassengerOf(entity);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void ab() {
/*  351 */     if (!this.world.isStatic && isSneaking()) {
/*  352 */       mount((Entity)null);
/*  353 */       setSneaking(false);
/*      */     } else {
/*  355 */       double d0 = this.locX;
/*  356 */       double d1 = this.locY;
/*  357 */       double d2 = this.locZ;
/*  358 */       float f = this.yaw;
/*  359 */       float f1 = this.pitch;
/*      */       
/*  361 */       super.ab();
/*  362 */       this.br = this.bs;
/*  363 */       this.bs = 0.0F;
/*  364 */       l(this.locX - d0, this.locY - d1, this.locZ - d2);
/*  365 */       if (this.vehicle instanceof EntityPig) {
/*  366 */         this.pitch = f1;
/*  367 */         this.yaw = f;
/*  368 */         this.aM = ((EntityPig)this.vehicle).aM;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void bq() {
/*  374 */     super.bq();
/*  375 */     bb();
/*      */   }
/*      */   
/*      */   public void e() {
/*  379 */     if (this.bq > 0) {
/*  380 */       this.bq--;
/*      */     }
/*      */     
/*  383 */     if (this.world.difficulty == EnumDifficulty.PEACEFUL && getHealth() < getMaxHealth() && this.world.getGameRules().getBoolean("naturalRegeneration") && this.ticksLived % 20 * 12 == 0)
/*      */     {
/*  385 */       heal(1.0F, EntityRegainHealthEvent.RegainReason.REGEN);
/*      */     }
/*      */     
/*  388 */     this.inventory.k();
/*  389 */     this.br = this.bs;
/*  390 */     super.e();
/*  391 */     AttributeInstance attributeinstance = getAttributeInstance(GenericAttributes.d);
/*      */     
/*  393 */     if (!this.world.isStatic) {
/*  394 */       attributeinstance.setValue(this.abilities.b());
/*      */     }
/*      */     
/*  397 */     this.aQ = this.bJ;
/*  398 */     if (isSprinting()) {
/*  399 */       this.aQ = (float)(this.aQ + this.bJ * 0.3D);
/*      */     }
/*      */     
/*  402 */     i((float)attributeinstance.getValue());
/*  403 */     float f = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/*      */     
/*  405 */     float f1 = (float)TrigMath.atan(-this.motY * 0.20000000298023224D) * 15.0F;
/*      */     
/*  407 */     if (f > 0.1F) {
/*  408 */       f = 0.1F;
/*      */     }
/*      */     
/*  411 */     if (!this.onGround || getHealth() <= 0.0F) {
/*  412 */       f = 0.0F;
/*      */     }
/*      */     
/*  415 */     if (this.onGround || getHealth() <= 0.0F) {
/*  416 */       f1 = 0.0F;
/*      */     }
/*      */     
/*  419 */     this.bs += (f - this.bs) * 0.4F;
/*  420 */     this.aJ += (f1 - this.aJ) * 0.8F;
/*  421 */     if (getHealth() > 0.0F) {
/*  422 */       AxisAlignedBB axisalignedbb = null;
/*      */       
/*  424 */       if (this.vehicle != null && !this.vehicle.dead) {
/*  425 */         axisalignedbb = this.boundingBox.a(this.vehicle.boundingBox).grow(1.0D, 0.0D, 1.0D);
/*      */       } else {
/*  427 */         axisalignedbb = this.boundingBox.grow(1.0D, 0.5D, 1.0D);
/*      */       } 
/*      */       
/*  430 */       List<Entity> list = this.world.getEntities(this, axisalignedbb);
/*      */       
/*  432 */       if (list != null) {
/*  433 */         for (int i = 0; i < list.size(); i++) {
/*  434 */           Entity entity = list.get(i);
/*      */           
/*  436 */           if (!entity.dead) {
/*  437 */             d(entity);
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d(Entity entity) {
/*  445 */     entity.b_(this);
/*      */   }
/*      */   
/*      */   public int getScore() {
/*  449 */     return this.datawatcher.getInt(18);
/*      */   }
/*      */   
/*      */   public void setScore(int i) {
/*  453 */     this.datawatcher.watch(18, Integer.valueOf(i));
/*      */   }
/*      */   
/*      */   public void addScore(int i) {
/*  457 */     int j = getScore();
/*      */     
/*  459 */     this.datawatcher.watch(18, Integer.valueOf(j + i));
/*      */   }
/*      */   
/*      */   public void die(DamageSource damagesource) {
/*  463 */     super.die(damagesource);
/*  464 */     a(0.2F, 0.2F);
/*  465 */     setPosition(this.locX, this.locY, this.locZ);
/*  466 */     this.motY = 0.10000000149011612D;
/*  467 */     if (getName().equals("Notch")) {
/*  468 */       a(new ItemStack(Items.APPLE, 1), true, false);
/*      */     }
/*      */     
/*  471 */     if (!this.world.getGameRules().getBoolean("keepInventory")) {
/*  472 */       this.inventory.m();
/*      */     }
/*      */     
/*  475 */     if (damagesource != null) {
/*  476 */       this.motX = (-MathHelper.cos((this.az + this.yaw) * 3.1415927F / 180.0F) * 0.1F);
/*  477 */       this.motZ = (-MathHelper.sin((this.az + this.yaw) * 3.1415927F / 180.0F) * 0.1F);
/*      */     } else {
/*  479 */       this.motX = this.motZ = 0.0D;
/*      */     } 
/*      */     
/*  482 */     this.height = 0.1F;
/*  483 */     a(StatisticList.v, 1);
/*      */   }
/*      */   
/*      */   protected String aT() {
/*  487 */     return "game.player.hurt";
/*      */   }
/*      */   
/*      */   protected String aU() {
/*  491 */     return "game.player.die";
/*      */   }
/*      */   
/*      */   public void b(Entity entity, int i) {
/*  495 */     addScore(i);
/*      */     
/*  497 */     Collection<ScoreboardScore> collection = this.world.getServer().getScoreboardManager().getScoreboardScores(IScoreboardCriteria.e, getName(), new ArrayList());
/*      */     
/*  499 */     if (entity instanceof EntityHuman) {
/*  500 */       a(StatisticList.y, 1);
/*      */       
/*  502 */       this.world.getServer().getScoreboardManager().getScoreboardScores(IScoreboardCriteria.d, getName(), collection);
/*      */     } else {
/*  504 */       a(StatisticList.w, 1);
/*      */     } 
/*      */     
/*  507 */     Iterator<ScoreboardScore> iterator = collection.iterator();
/*      */     
/*  509 */     while (iterator.hasNext()) {
/*  510 */       ScoreboardScore scoreboardscore = iterator.next();
/*      */       
/*  512 */       scoreboardscore.incrementScore();
/*      */     } 
/*      */   }
/*      */   
/*      */   public EntityItem a(boolean flag) {
/*  517 */     return a(this.inventory.splitStack(this.inventory.itemInHandIndex, (flag && this.inventory.getItemInHand() != null) ? (this.inventory.getItemInHand()).count : 1), false, true);
/*      */   }
/*      */   
/*      */   public EntityItem drop(ItemStack itemstack, boolean flag) {
/*  521 */     return a(itemstack, false, false);
/*      */   }
/*      */   
/*      */   public EntityItem a(ItemStack itemstack, boolean flag, boolean flag1) {
/*  525 */     if (itemstack == null)
/*  526 */       return null; 
/*  527 */     if (itemstack.count == 0) {
/*  528 */       return null;
/*      */     }
/*  530 */     EntityItem entityitem = new EntityItem(this.world, this.locX, this.locY - 0.30000001192092896D + getHeadHeight(), this.locZ, itemstack);
/*      */     
/*  532 */     entityitem.pickupDelay = 40;
/*  533 */     if (flag1) {
/*  534 */       entityitem.b(getName());
/*      */     }
/*      */     
/*  537 */     float f = 0.1F;
/*      */ 
/*      */     
/*  540 */     if (flag) {
/*  541 */       float f1 = this.random.nextFloat() * 0.5F;
/*  542 */       float f2 = this.random.nextFloat() * 3.1415927F * 2.0F;
/*      */       
/*  544 */       entityitem.motX = (-MathHelper.sin(f2) * f1);
/*  545 */       entityitem.motZ = (MathHelper.cos(f2) * f1);
/*  546 */       entityitem.motY = 0.20000000298023224D;
/*      */     } else {
/*  548 */       f = 0.3F;
/*  549 */       entityitem.motX = (-MathHelper.sin(this.yaw / 180.0F * 3.1415927F) * MathHelper.cos(this.pitch / 180.0F * 3.1415927F) * f);
/*  550 */       entityitem.motZ = (MathHelper.cos(this.yaw / 180.0F * 3.1415927F) * MathHelper.cos(this.pitch / 180.0F * 3.1415927F) * f);
/*  551 */       entityitem.motY = (-MathHelper.sin(this.pitch / 180.0F * 3.1415927F) * f + 0.1F);
/*  552 */       f = 0.02F;
/*  553 */       float f1 = this.random.nextFloat() * 3.1415927F * 2.0F;
/*  554 */       f *= this.random.nextFloat();
/*  555 */       entityitem.motX += Math.cos(f1) * f;
/*  556 */       entityitem.motY += ((this.random.nextFloat() - this.random.nextFloat()) * 0.1F);
/*  557 */       entityitem.motZ += Math.sin(f1) * f;
/*      */     } 
/*      */ 
/*      */     
/*  561 */     Player player = (Player)getBukkitEntity();
/*  562 */     CraftItem drop = new CraftItem(this.world.getServer(), entityitem);
/*      */     
/*  564 */     PlayerDropItemEvent event = new PlayerDropItemEvent(player, (Item)drop);
/*  565 */     this.world.getServer().getPluginManager().callEvent((Event)event);
/*      */     
/*  567 */     if (event.isCancelled()) {
/*  568 */       player.getInventory().addItem(new ItemStack[] { drop.getItemStack() });
/*  569 */       return null;
/*      */     } 
/*      */ 
/*      */     
/*  573 */     a(entityitem);
/*  574 */     a(StatisticList.s, 1);
/*  575 */     return entityitem;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void a(EntityItem entityitem) {
/*  580 */     this.world.addEntity(entityitem);
/*      */   }
/*      */   
/*      */   public float a(Block block, boolean flag) {
/*  584 */     float f = this.inventory.a(block);
/*      */     
/*  586 */     if (f > 1.0F) {
/*  587 */       int i = EnchantmentManager.getDigSpeedEnchantmentLevel(this);
/*  588 */       ItemStack itemstack = this.inventory.getItemInHand();
/*      */       
/*  590 */       if (i > 0 && itemstack != null) {
/*  591 */         float f1 = (i * i + 1);
/*      */         
/*  593 */         if (!itemstack.b(block) && f <= 1.0F) {
/*  594 */           f += f1 * 0.08F;
/*      */         } else {
/*  596 */           f += f1;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  601 */     if (hasEffect(MobEffectList.FASTER_DIG)) {
/*  602 */       f *= 1.0F + (getEffect(MobEffectList.FASTER_DIG).getAmplifier() + 1) * 0.2F;
/*      */     }
/*      */     
/*  605 */     if (hasEffect(MobEffectList.SLOWER_DIG)) {
/*  606 */       f *= 1.0F - (getEffect(MobEffectList.SLOWER_DIG).getAmplifier() + 1) * 0.2F;
/*      */     }
/*      */     
/*  609 */     if (a(Material.WATER) && !EnchantmentManager.hasWaterWorkerEnchantment(this)) {
/*  610 */       f /= 5.0F;
/*      */     }
/*      */     
/*  613 */     if (!this.onGround) {
/*  614 */       f /= 5.0F;
/*      */     }
/*      */     
/*  617 */     return f;
/*      */   }
/*      */   
/*      */   public boolean a(Block block) {
/*  621 */     return this.inventory.b(block);
/*      */   }
/*      */   
/*      */   public void a(NBTTagCompound nbttagcompound) {
/*  625 */     super.a(nbttagcompound);
/*  626 */     this.uniqueID = a(this.i);
/*  627 */     NBTTagList nbttaglist = nbttagcompound.getList("Inventory", 10);
/*      */     
/*  629 */     this.inventory.b(nbttaglist);
/*  630 */     this.inventory.itemInHandIndex = nbttagcompound.getInt("SelectedItemSlot");
/*  631 */     this.sleeping = nbttagcompound.getBoolean("Sleeping");
/*  632 */     this.sleepTicks = nbttagcompound.getShort("SleepTimer");
/*  633 */     this.exp = nbttagcompound.getFloat("XpP");
/*  634 */     this.expLevel = nbttagcompound.getInt("XpLevel");
/*  635 */     this.expTotal = nbttagcompound.getInt("XpTotal");
/*  636 */     setScore(nbttagcompound.getInt("Score"));
/*  637 */     if (this.sleeping) {
/*  638 */       this.bB = new ChunkCoordinates(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ));
/*  639 */       a(true, true, false);
/*      */     } 
/*      */ 
/*      */     
/*  643 */     this.spawnWorld = nbttagcompound.getString("SpawnWorld");
/*  644 */     if ("".equals(this.spawnWorld)) {
/*  645 */       this.spawnWorld = ((World)this.world.getServer().getWorlds().get(0)).getName();
/*      */     }
/*      */ 
/*      */     
/*  649 */     if (nbttagcompound.hasKeyOfType("SpawnX", 99) && nbttagcompound.hasKeyOfType("SpawnY", 99) && nbttagcompound.hasKeyOfType("SpawnZ", 99)) {
/*  650 */       this.c = new ChunkCoordinates(nbttagcompound.getInt("SpawnX"), nbttagcompound.getInt("SpawnY"), nbttagcompound.getInt("SpawnZ"));
/*  651 */       this.d = nbttagcompound.getBoolean("SpawnForced");
/*      */     } 
/*      */     
/*  654 */     this.foodData.a(nbttagcompound);
/*  655 */     this.abilities.b(nbttagcompound);
/*  656 */     if (nbttagcompound.hasKeyOfType("EnderItems", 9)) {
/*  657 */       NBTTagList nbttaglist1 = nbttagcompound.getList("EnderItems", 10);
/*      */       
/*  659 */       this.enderChest.a(nbttaglist1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(NBTTagCompound nbttagcompound) {
/*  664 */     super.b(nbttagcompound);
/*  665 */     nbttagcompound.set("Inventory", this.inventory.a(new NBTTagList()));
/*  666 */     nbttagcompound.setInt("SelectedItemSlot", this.inventory.itemInHandIndex);
/*  667 */     nbttagcompound.setBoolean("Sleeping", this.sleeping);
/*  668 */     nbttagcompound.setShort("SleepTimer", (short)this.sleepTicks);
/*  669 */     nbttagcompound.setFloat("XpP", this.exp);
/*  670 */     nbttagcompound.setInt("XpLevel", this.expLevel);
/*  671 */     nbttagcompound.setInt("XpTotal", this.expTotal);
/*  672 */     nbttagcompound.setInt("Score", getScore());
/*  673 */     if (this.c != null) {
/*  674 */       nbttagcompound.setInt("SpawnX", this.c.x);
/*  675 */       nbttagcompound.setInt("SpawnY", this.c.y);
/*  676 */       nbttagcompound.setInt("SpawnZ", this.c.z);
/*  677 */       nbttagcompound.setBoolean("SpawnForced", this.d);
/*  678 */       nbttagcompound.setString("SpawnWorld", this.spawnWorld);
/*      */     } 
/*      */     
/*  681 */     this.foodData.b(nbttagcompound);
/*  682 */     this.abilities.a(nbttagcompound);
/*  683 */     nbttagcompound.set("EnderItems", this.enderChest.h());
/*      */   }
/*      */   
/*      */   public void openContainer(IInventory iinventory) {}
/*      */   
/*      */   public void openHopper(TileEntityHopper tileentityhopper) {}
/*      */   
/*      */   public void openMinecartHopper(EntityMinecartHopper entityminecarthopper) {}
/*      */   
/*      */   public void openHorseInventory(EntityHorse entityhorse, IInventory iinventory) {}
/*      */   
/*      */   public void startEnchanting(int i, int j, int k, String s) {}
/*      */   
/*      */   public void openAnvil(int i, int j, int k) {}
/*      */   
/*      */   public void startCrafting(int i, int j, int k) {}
/*      */   
/*      */   public float getHeadHeight() {
/*  701 */     return 0.12F;
/*      */   }
/*      */   
/*      */   protected void e_() {
/*  705 */     this.height = 1.62F;
/*      */   }
/*      */   
/*      */   public boolean damageEntity(DamageSource damagesource, float f) {
/*  709 */     if (isInvulnerable())
/*  710 */       return false; 
/*  711 */     if (this.abilities.isInvulnerable && !damagesource.ignoresInvulnerability()) {
/*  712 */       return false;
/*      */     }
/*  714 */     this.aU = 0;
/*  715 */     if (getHealth() <= 0.0F) {
/*  716 */       return false;
/*      */     }
/*  718 */     if (isSleeping() && !this.world.isStatic) {
/*  719 */       a(true, true, false);
/*      */     }
/*      */     
/*  722 */     if (damagesource.r()) {
/*  723 */       if (this.world.difficulty == EnumDifficulty.PEACEFUL) {
/*  724 */         return false;
/*      */       }
/*      */       
/*  727 */       if (this.world.difficulty == EnumDifficulty.EASY) {
/*  728 */         f = f / 2.0F + 1.0F;
/*      */       }
/*      */       
/*  731 */       if (this.world.difficulty == EnumDifficulty.HARD) {
/*  732 */         f = f * 3.0F / 2.0F;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  739 */     Entity entity = damagesource.getEntity();
/*      */     
/*  741 */     if (entity instanceof EntityArrow && ((EntityArrow)entity).shooter != null) {
/*  742 */       entity = ((EntityArrow)entity).shooter;
/*      */     }
/*      */     
/*  745 */     a(StatisticList.u, Math.round(f * 10.0F));
/*  746 */     return super.damageEntity(damagesource, f);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(EntityHuman entityhuman) {
/*      */     Team team;
/*  756 */     if (entityhuman instanceof EntityPlayer) {
/*  757 */       EntityPlayer thatPlayer = (EntityPlayer)entityhuman;
/*  758 */       team = thatPlayer.getBukkitEntity().getScoreboard().getPlayerTeam((OfflinePlayer)thatPlayer.getBukkitEntity());
/*  759 */       if (team == null || team.allowFriendlyFire()) {
/*  760 */         return true;
/*      */       }
/*      */     } else {
/*      */       
/*  764 */       OfflinePlayer thisPlayer = entityhuman.world.getServer().getOfflinePlayer(entityhuman.getName());
/*  765 */       team = entityhuman.world.getServer().getScoreboardManager().getMainScoreboard().getPlayerTeam(thisPlayer);
/*  766 */       if (team == null || team.allowFriendlyFire()) {
/*  767 */         return true;
/*      */       }
/*      */     } 
/*      */     
/*  771 */     if (this instanceof EntityPlayer) {
/*  772 */       return !team.hasPlayer((OfflinePlayer)((EntityPlayer)this).getBukkitEntity());
/*      */     }
/*  774 */     return !team.hasPlayer(this.world.getServer().getOfflinePlayer(getName()));
/*      */   }
/*      */ 
/*      */   
/*      */   protected void damageArmor(float f) {
/*  779 */     this.inventory.a(f);
/*      */   }
/*      */   
/*      */   public int aV() {
/*  783 */     return this.inventory.l();
/*      */   }
/*      */   
/*      */   public float bE() {
/*  787 */     int i = 0;
/*  788 */     ItemStack[] aitemstack = this.inventory.armor;
/*  789 */     int j = aitemstack.length;
/*      */     
/*  791 */     for (int k = 0; k < j; k++) {
/*  792 */       ItemStack itemstack = aitemstack[k];
/*      */       
/*  794 */       if (itemstack != null) {
/*  795 */         i++;
/*      */       }
/*      */     } 
/*      */     
/*  799 */     return i / this.inventory.armor.length;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean d(DamageSource damagesource, float f) {
/*  805 */     return super.d(damagesource, f);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void openFurnace(TileEntityFurnace tileentityfurnace) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void openDispenser(TileEntityDispenser tileentitydispenser) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(TileEntity tileentity) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(CommandBlockListenerAbstract commandblocklistenerabstract) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void openBrewingStand(TileEntityBrewingStand tileentitybrewingstand) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void openBeacon(TileEntityBeacon tileentitybeacon) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void openTrade(IMerchant imerchant, String s) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(ItemStack itemstack) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean q(Entity entity) {
/*  847 */     ItemStack itemstack = bF();
/*  848 */     ItemStack itemstack1 = (itemstack != null) ? itemstack.cloneItemStack() : null;
/*      */     
/*  850 */     if (!entity.c(this)) {
/*  851 */       if (itemstack != null && entity instanceof EntityLiving) {
/*  852 */         if (this.abilities.canInstantlyBuild) {
/*  853 */           itemstack = itemstack1;
/*      */         }
/*      */         
/*  856 */         if (itemstack.a(this, (EntityLiving)entity)) {
/*      */           
/*  858 */           if (itemstack.count == 0 && !this.abilities.canInstantlyBuild) {
/*  859 */             bG();
/*      */           }
/*      */           
/*  862 */           return true;
/*      */         } 
/*      */       } 
/*      */       
/*  866 */       return false;
/*      */     } 
/*  868 */     if (itemstack != null && itemstack == bF()) {
/*  869 */       if (itemstack.count <= 0 && !this.abilities.canInstantlyBuild) {
/*  870 */         bG();
/*  871 */       } else if (itemstack.count < itemstack1.count && this.abilities.canInstantlyBuild) {
/*  872 */         itemstack.count = itemstack1.count;
/*      */       } 
/*      */     }
/*      */     
/*  876 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack bF() {
/*  881 */     return this.inventory.getItemInHand();
/*      */   }
/*      */   
/*      */   public void bG() {
/*  885 */     this.inventory.setItem(this.inventory.itemInHandIndex, (ItemStack)null);
/*      */   }
/*      */   
/*      */   public double ad() {
/*  889 */     return (this.height - 0.5F);
/*      */   }
/*      */   
/*      */   public void attack(Entity entity) {
/*  893 */     if (entity.av() && 
/*  894 */       !entity.j(this)) {
/*  895 */       float f = (float)getAttributeInstance(GenericAttributes.e).getValue();
/*  896 */       int i = 0;
/*  897 */       float f1 = 0.0F;
/*      */       
/*  899 */       if (entity instanceof EntityLiving) {
/*  900 */         f1 = EnchantmentManager.a(this, (EntityLiving)entity);
/*  901 */         i += EnchantmentManager.getKnockbackEnchantmentLevel(this, (EntityLiving)entity);
/*      */       } 
/*      */       
/*  904 */       if (isSprinting()) {
/*  905 */         i++;
/*      */       }
/*      */       
/*  908 */       if (f > 0.0F || f1 > 0.0F) {
/*  909 */         boolean flag = (this.fallDistance > 0.0F && !this.onGround && !h_() && !M() && !hasEffect(MobEffectList.BLINDNESS) && this.vehicle == null && entity instanceof EntityLiving);
/*      */         
/*  911 */         if (flag && f > 0.0F) {
/*  912 */           f *= 1.5F;
/*      */         }
/*      */         
/*  915 */         f += f1;
/*  916 */         boolean flag1 = false;
/*  917 */         int j = EnchantmentManager.getFireAspectEnchantmentLevel(this);
/*      */         
/*  919 */         if (entity instanceof EntityLiving && j > 0 && !entity.isBurning()) {
/*      */           
/*  921 */           EntityCombustByEntityEvent combustEvent = new EntityCombustByEntityEvent((Entity)getBukkitEntity(), (Entity)entity.getBukkitEntity(), 1);
/*  922 */           Bukkit.getPluginManager().callEvent((Event)combustEvent);
/*      */           
/*  924 */           if (!combustEvent.isCancelled()) {
/*  925 */             flag1 = true;
/*  926 */             entity.setOnFire(combustEvent.getDuration());
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  931 */         boolean flag2 = entity.damageEntity(DamageSource.playerAttack(this), f);
/*      */         
/*  933 */         if (flag2) {
/*  934 */           if (i > 0) {
/*  935 */             entity.g((-MathHelper.sin(this.yaw * 3.1415927F / 180.0F) * i * 0.5F), 0.1D, (MathHelper.cos(this.yaw * 3.1415927F / 180.0F) * i * 0.5F));
/*  936 */             this.motX *= 0.6D;
/*  937 */             this.motZ *= 0.6D;
/*  938 */             setSprinting(false);
/*      */           } 
/*      */           
/*  941 */           if (flag) {
/*  942 */             b(entity);
/*      */           }
/*      */           
/*  945 */           if (f1 > 0.0F) {
/*  946 */             c(entity);
/*      */           }
/*      */           
/*  949 */           if (f >= 18.0F) {
/*  950 */             a(AchievementList.F);
/*      */           }
/*      */           
/*  953 */           l(entity);
/*  954 */           if (entity instanceof EntityLiving) {
/*  955 */             EnchantmentManager.a((EntityLiving)entity, this);
/*      */           }
/*      */           
/*  958 */           EnchantmentManager.b(this, entity);
/*  959 */           ItemStack itemstack = bF();
/*  960 */           Object object = entity;
/*      */           
/*  962 */           if (entity instanceof EntityComplexPart) {
/*  963 */             IComplex icomplex = ((EntityComplexPart)entity).owner;
/*      */             
/*  965 */             if (icomplex != null && icomplex instanceof EntityLiving) {
/*  966 */               object = icomplex;
/*      */             }
/*      */           } 
/*      */           
/*  970 */           if (itemstack != null && object instanceof EntityLiving) {
/*  971 */             itemstack.a((EntityLiving)object, this);
/*      */             
/*  973 */             if (itemstack.count == 0) {
/*  974 */               bG();
/*      */             }
/*      */           } 
/*      */           
/*  978 */           if (entity instanceof EntityLiving) {
/*  979 */             a(StatisticList.t, Math.round(f * 10.0F));
/*  980 */             if (j > 0) {
/*      */               
/*  982 */               EntityCombustByEntityEvent combustEvent = new EntityCombustByEntityEvent((Entity)getBukkitEntity(), (Entity)entity.getBukkitEntity(), j * 4);
/*  983 */               Bukkit.getPluginManager().callEvent((Event)combustEvent);
/*      */               
/*  985 */               if (!combustEvent.isCancelled()) {
/*  986 */                 entity.setOnFire(combustEvent.getDuration());
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/*  992 */           applyExhaustion(0.3F);
/*  993 */         } else if (flag1) {
/*  994 */           entity.extinguish();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void b(Entity entity) {}
/*      */   
/*      */   public void c(Entity entity) {}
/*      */   
/*      */   public void die() {
/* 1006 */     super.die();
/* 1007 */     this.defaultContainer.b(this);
/* 1008 */     if (this.activeContainer != null) {
/* 1009 */       this.activeContainer.b(this);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean inBlock() {
/* 1014 */     return (!this.sleeping && super.inBlock());
/*      */   }
/*      */   
/*      */   public GameProfile getProfile() {
/* 1018 */     return this.i;
/*      */   }
/*      */   
/*      */   public EnumBedResult a(int i, int j, int k) {
/* 1022 */     if (!this.world.isStatic) {
/* 1023 */       if (isSleeping() || !isAlive()) {
/* 1024 */         return EnumBedResult.OTHER_PROBLEM;
/*      */       }
/*      */       
/* 1027 */       if (!this.world.worldProvider.d()) {
/* 1028 */         return EnumBedResult.NOT_POSSIBLE_HERE;
/*      */       }
/*      */       
/* 1031 */       if (this.world.w()) {
/* 1032 */         return EnumBedResult.NOT_POSSIBLE_NOW;
/*      */       }
/*      */       
/* 1035 */       if (Math.abs(this.locX - i) > 3.0D || Math.abs(this.locY - j) > 2.0D || Math.abs(this.locZ - k) > 3.0D) {
/* 1036 */         return EnumBedResult.TOO_FAR_AWAY;
/*      */       }
/*      */       
/* 1039 */       double d0 = 8.0D;
/* 1040 */       double d1 = 5.0D;
/* 1041 */       List list = this.world.a(EntityMonster.class, AxisAlignedBB.a(i - d0, j - d1, k - d0, i + d0, j + d1, k + d0));
/*      */       
/* 1043 */       if (!list.isEmpty()) {
/* 1044 */         return EnumBedResult.NOT_SAFE;
/*      */       }
/*      */     } 
/*      */     
/* 1048 */     if (am()) {
/* 1049 */       mount((Entity)null);
/*      */     }
/*      */ 
/*      */     
/* 1053 */     if (getBukkitEntity() instanceof Player) {
/* 1054 */       Player player = (Player)getBukkitEntity();
/* 1055 */       Block bed = this.world.getWorld().getBlockAt(i, j, k);
/*      */       
/* 1057 */       PlayerBedEnterEvent event = new PlayerBedEnterEvent(player, bed);
/* 1058 */       this.world.getServer().getPluginManager().callEvent((Event)event);
/*      */       
/* 1060 */       if (event.isCancelled()) {
/* 1061 */         return EnumBedResult.OTHER_PROBLEM;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1066 */     a(0.2F, 0.2F);
/* 1067 */     this.height = 0.2F;
/* 1068 */     if (this.world.isLoaded(i, j, k)) {
/* 1069 */       int l = this.world.getData(i, j, k);
/* 1070 */       int i1 = BlockBed.l(l);
/* 1071 */       float f = 0.5F;
/* 1072 */       float f1 = 0.5F;
/*      */       
/* 1074 */       switch (i1) {
/*      */         case 0:
/* 1076 */           f1 = 0.9F;
/*      */           break;
/*      */         
/*      */         case 1:
/* 1080 */           f = 0.1F;
/*      */           break;
/*      */         
/*      */         case 2:
/* 1084 */           f1 = 0.1F;
/*      */           break;
/*      */         
/*      */         case 3:
/* 1088 */           f = 0.9F;
/*      */           break;
/*      */       } 
/* 1091 */       w(i1);
/* 1092 */       setPosition((i + f), (j + 0.9375F), (k + f1));
/*      */     } else {
/* 1094 */       setPosition((i + 0.5F), (j + 0.9375F), (k + 0.5F));
/*      */     } 
/*      */     
/* 1097 */     this.sleeping = true;
/* 1098 */     this.sleepTicks = 0;
/* 1099 */     this.bB = new ChunkCoordinates(i, j, k);
/* 1100 */     this.motX = this.motZ = this.motY = 0.0D;
/* 1101 */     if (!this.world.isStatic) {
/* 1102 */       this.world.everyoneSleeping();
/*      */     }
/*      */     
/* 1105 */     return EnumBedResult.OK;
/*      */   }
/*      */   
/*      */   private void w(int i) {
/* 1109 */     this.bC = 0.0F;
/* 1110 */     this.bD = 0.0F;
/* 1111 */     switch (i) {
/*      */       case 0:
/* 1113 */         this.bD = -1.8F;
/*      */         break;
/*      */       
/*      */       case 1:
/* 1117 */         this.bC = 1.8F;
/*      */         break;
/*      */       
/*      */       case 2:
/* 1121 */         this.bD = 1.8F;
/*      */         break;
/*      */       
/*      */       case 3:
/* 1125 */         this.bC = -1.8F;
/*      */         break;
/*      */     } 
/*      */   }
/*      */   public void a(boolean flag, boolean flag1, boolean flag2) {
/* 1130 */     a(0.6F, 1.8F);
/* 1131 */     e_();
/* 1132 */     ChunkCoordinates chunkcoordinates = this.bB;
/* 1133 */     ChunkCoordinates chunkcoordinates1 = this.bB;
/*      */     
/* 1135 */     if (chunkcoordinates != null && this.world.getType(chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z) == Blocks.BED) {
/* 1136 */       BlockBed.a(this.world, chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z, false);
/* 1137 */       chunkcoordinates1 = BlockBed.a(this.world, chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z, 0);
/* 1138 */       if (chunkcoordinates1 == null) {
/* 1139 */         chunkcoordinates1 = new ChunkCoordinates(chunkcoordinates.x, chunkcoordinates.y + 1, chunkcoordinates.z);
/*      */       }
/*      */       
/* 1142 */       setPosition((chunkcoordinates1.x + 0.5F), (chunkcoordinates1.y + this.height + 0.1F), (chunkcoordinates1.z + 0.5F));
/*      */     } 
/*      */     
/* 1145 */     this.sleeping = false;
/* 1146 */     if (!this.world.isStatic && flag1) {
/* 1147 */       this.world.everyoneSleeping();
/*      */     }
/*      */ 
/*      */     
/* 1151 */     if (getBukkitEntity() instanceof Player) {
/* 1152 */       Block bed; Player player = (Player)getBukkitEntity();
/*      */ 
/*      */       
/* 1155 */       if (chunkcoordinates != null) {
/* 1156 */         bed = this.world.getWorld().getBlockAt(chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z);
/*      */       } else {
/* 1158 */         bed = this.world.getWorld().getBlockAt(player.getLocation());
/*      */       } 
/*      */       
/* 1161 */       PlayerBedLeaveEvent event = new PlayerBedLeaveEvent(player, bed);
/* 1162 */       this.world.getServer().getPluginManager().callEvent((Event)event);
/*      */     } 
/*      */ 
/*      */     
/* 1166 */     if (flag) {
/* 1167 */       this.sleepTicks = 0;
/*      */     } else {
/* 1169 */       this.sleepTicks = 100;
/*      */     } 
/*      */     
/* 1172 */     if (flag2) {
/* 1173 */       setRespawnPosition(this.bB, false);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean j() {
/* 1178 */     return (this.world.getType(this.bB.x, this.bB.y, this.bB.z) == Blocks.BED);
/*      */   }
/*      */   
/*      */   public static ChunkCoordinates getBed(World world, ChunkCoordinates chunkcoordinates, boolean flag) {
/* 1182 */     IChunkProvider ichunkprovider = world.L();
/*      */     
/* 1184 */     ichunkprovider.getChunkAt(chunkcoordinates.x - 3 >> 4, chunkcoordinates.z - 3 >> 4);
/* 1185 */     ichunkprovider.getChunkAt(chunkcoordinates.x + 3 >> 4, chunkcoordinates.z - 3 >> 4);
/* 1186 */     ichunkprovider.getChunkAt(chunkcoordinates.x - 3 >> 4, chunkcoordinates.z + 3 >> 4);
/* 1187 */     ichunkprovider.getChunkAt(chunkcoordinates.x + 3 >> 4, chunkcoordinates.z + 3 >> 4);
/* 1188 */     if (world.getType(chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z) == Blocks.BED) {
/* 1189 */       ChunkCoordinates chunkcoordinates1 = BlockBed.a(world, chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z, 0);
/*      */       
/* 1191 */       return chunkcoordinates1;
/*      */     } 
/* 1193 */     Material material = world.getType(chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z).getMaterial();
/* 1194 */     Material material1 = world.getType(chunkcoordinates.x, chunkcoordinates.y + 1, chunkcoordinates.z).getMaterial();
/* 1195 */     boolean flag1 = (!material.isBuildable() && !material.isLiquid());
/* 1196 */     boolean flag2 = (!material1.isBuildable() && !material1.isLiquid());
/*      */     
/* 1198 */     return (flag && flag1 && flag2) ? chunkcoordinates : null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSleeping() {
/* 1203 */     return this.sleeping;
/*      */   }
/*      */   
/*      */   public boolean isDeeplySleeping() {
/* 1207 */     return (this.sleeping && this.sleepTicks >= 100);
/*      */   }
/*      */   
/*      */   protected void b(int i, boolean flag) {
/* 1211 */     byte b0 = this.datawatcher.getByte(16);
/*      */     
/* 1213 */     if (flag) {
/* 1214 */       this.datawatcher.watch(16, Byte.valueOf((byte)(b0 | 1 << i)));
/*      */     } else {
/* 1216 */       this.datawatcher.watch(16, Byte.valueOf((byte)(b0 & (1 << i ^ 0xFFFFFFFF))));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(IChatBaseComponent ichatbasecomponent) {}
/*      */   
/*      */   public ChunkCoordinates getBed() {
/* 1223 */     return this.c;
/*      */   }
/*      */   
/*      */   public boolean isRespawnForced() {
/* 1227 */     return this.d;
/*      */   }
/*      */   
/*      */   public void setRespawnPosition(ChunkCoordinates chunkcoordinates, boolean flag) {
/* 1231 */     if (chunkcoordinates != null) {
/* 1232 */       this.c = new ChunkCoordinates(chunkcoordinates);
/* 1233 */       this.d = flag;
/* 1234 */       this.spawnWorld = this.world.worldData.getName();
/*      */     } else {
/* 1236 */       this.c = null;
/* 1237 */       this.d = false;
/* 1238 */       this.spawnWorld = "";
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(Statistic statistic) {
/* 1243 */     a(statistic, 1);
/*      */   }
/*      */   
/*      */   public void a(Statistic statistic, int i) {}
/*      */   
/*      */   public void bj() {
/* 1249 */     super.bj();
/* 1250 */     a(StatisticList.r, 1);
/* 1251 */     if (isSprinting()) {
/* 1252 */       applyExhaustion(0.8F);
/*      */     } else {
/* 1254 */       applyExhaustion(0.2F);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void e(float f, float f1) {
/* 1259 */     double d0 = this.locX;
/* 1260 */     double d1 = this.locY;
/* 1261 */     double d2 = this.locZ;
/*      */     
/* 1263 */     if (this.abilities.isFlying && this.vehicle == null) {
/* 1264 */       double d3 = this.motY;
/* 1265 */       float f2 = this.aQ;
/*      */       
/* 1267 */       this.aQ = this.abilities.a();
/* 1268 */       super.e(f, f1);
/* 1269 */       this.motY = d3 * 0.6D;
/* 1270 */       this.aQ = f2;
/*      */     } else {
/* 1272 */       super.e(f, f1);
/*      */     } 
/*      */     
/* 1275 */     checkMovement(this.locX - d0, this.locY - d1, this.locZ - d2);
/*      */   }
/*      */   
/*      */   public float bl() {
/* 1279 */     return (float)getAttributeInstance(GenericAttributes.d).getValue();
/*      */   }
/*      */   
/*      */   public void checkMovement(double d0, double d1, double d2) {
/* 1283 */     if (this.vehicle == null)
/*      */     {
/*      */       
/* 1286 */       if (a(Material.WATER)) {
/* 1287 */         int i = Math.round(MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2) * 100.0F);
/* 1288 */         if (i > 0) {
/* 1289 */           a(StatisticList.m, i);
/* 1290 */           applyExhaustion(0.015F * i * 0.01F);
/*      */         } 
/* 1292 */       } else if (M()) {
/* 1293 */         int i = Math.round(MathHelper.sqrt(d0 * d0 + d2 * d2) * 100.0F);
/* 1294 */         if (i > 0) {
/* 1295 */           a(StatisticList.i, i);
/* 1296 */           applyExhaustion(0.015F * i * 0.01F);
/*      */         } 
/* 1298 */       } else if (h_()) {
/* 1299 */         if (d1 > 0.0D) {
/* 1300 */           a(StatisticList.k, (int)Math.round(d1 * 100.0D));
/*      */         }
/* 1302 */       } else if (this.onGround) {
/* 1303 */         int i = Math.round(MathHelper.sqrt(d0 * d0 + d2 * d2) * 100.0F);
/* 1304 */         if (i > 0) {
/* 1305 */           a(StatisticList.h, i);
/* 1306 */           if (isSprinting()) {
/* 1307 */             applyExhaustion(0.099999994F * i * 0.01F);
/*      */           } else {
/* 1309 */             applyExhaustion(0.01F * i * 0.01F);
/*      */           } 
/*      */         } 
/*      */       } else {
/* 1313 */         int i = Math.round(MathHelper.sqrt(d0 * d0 + d2 * d2) * 100.0F);
/* 1314 */         if (i > 25) {
/* 1315 */           a(StatisticList.l, i);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void l(double d0, double d1, double d2) {
/* 1322 */     if (this.vehicle != null) {
/* 1323 */       int i = Math.round(MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2) * 100.0F);
/*      */       
/* 1325 */       if (i > 0) {
/* 1326 */         if (this.vehicle instanceof EntityMinecartAbstract) {
/* 1327 */           a(StatisticList.n, i);
/* 1328 */           if (this.e == null) {
/* 1329 */             this.e = new ChunkCoordinates(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ));
/* 1330 */           } else if (this.e.e(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ)) >= 1000000.0D) {
/* 1331 */             a(AchievementList.q, 1);
/*      */           } 
/* 1333 */         } else if (this.vehicle instanceof EntityBoat) {
/* 1334 */           a(StatisticList.o, i);
/* 1335 */         } else if (this.vehicle instanceof EntityPig) {
/* 1336 */           a(StatisticList.p, i);
/* 1337 */         } else if (this.vehicle instanceof EntityHorse) {
/* 1338 */           a(StatisticList.q, i);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void b(float f) {
/* 1345 */     if (!this.abilities.canFly) {
/* 1346 */       if (f >= 2.0F) {
/* 1347 */         a(StatisticList.j, (int)Math.round(f * 100.0D));
/*      */       }
/*      */       
/* 1350 */       super.b(f);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected String o(int i) {
/* 1355 */     return (i > 4) ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
/*      */   }
/*      */   
/*      */   public void a(EntityLiving entityliving) {
/* 1359 */     if (entityliving instanceof IMonster) {
/* 1360 */       a(AchievementList.s);
/*      */     }
/*      */     
/* 1363 */     int i = EntityTypes.a(entityliving);
/* 1364 */     MonsterEggInfo monsteregginfo = (MonsterEggInfo)EntityTypes.eggInfo.get(Integer.valueOf(i));
/*      */     
/* 1366 */     if (monsteregginfo != null) {
/* 1367 */       a(monsteregginfo.killEntityStatistic, 1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void as() {
/* 1372 */     if (!this.abilities.isFlying) {
/* 1373 */       super.as();
/*      */     }
/*      */   }
/*      */   
/*      */   public ItemStack r(int i) {
/* 1378 */     return this.inventory.d(i);
/*      */   }
/*      */   
/*      */   public void giveExp(int i) {
/* 1382 */     addScore(i);
/* 1383 */     int j = Integer.MAX_VALUE - this.expTotal;
/*      */     
/* 1385 */     if (i > j) {
/* 1386 */       i = j;
/*      */     }
/*      */     
/* 1389 */     this.exp += i / getExpToLevel();
/*      */     
/* 1391 */     for (this.expTotal += i; this.exp >= 1.0F; this.exp /= getExpToLevel()) {
/* 1392 */       this.exp = (this.exp - 1.0F) * getExpToLevel();
/* 1393 */       levelDown(1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void levelDown(int i) {
/* 1398 */     this.expLevel += i;
/* 1399 */     if (this.expLevel < 0) {
/* 1400 */       this.expLevel = 0;
/* 1401 */       this.exp = 0.0F;
/* 1402 */       this.expTotal = 0;
/*      */     } 
/*      */     
/* 1405 */     if (i > 0 && this.expLevel % 5 == 0 && this.h < this.ticksLived - 100.0F) {
/* 1406 */       float f = (this.expLevel > 30) ? 1.0F : (this.expLevel / 30.0F);
/*      */       
/* 1408 */       this.world.makeSound(this, "random.levelup", f * 0.75F, 1.0F);
/* 1409 */       this.h = this.ticksLived;
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getExpToLevel() {
/* 1414 */     return (this.expLevel >= 30) ? (62 + (this.expLevel - 30) * 7) : ((this.expLevel >= 15) ? (17 + (this.expLevel - 15) * 3) : 17);
/*      */   }
/*      */   
/*      */   public void applyExhaustion(float f) {
/* 1418 */     if (!this.abilities.isInvulnerable && 
/* 1419 */       !this.world.isStatic) {
/* 1420 */       this.foodData.a(f);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public FoodMetaData getFoodData() {
/* 1426 */     return this.foodData;
/*      */   }
/*      */   
/*      */   public boolean g(boolean flag) {
/* 1430 */     return ((flag || this.foodData.c()) && !this.abilities.isInvulnerable);
/*      */   }
/*      */   
/*      */   public boolean bR() {
/* 1434 */     return (getHealth() > 0.0F && getHealth() < getMaxHealth());
/*      */   }
/*      */   
/*      */   public void a(ItemStack itemstack, int i) {
/* 1438 */     if (itemstack != this.f) {
/* 1439 */       this.f = itemstack;
/* 1440 */       this.g = i;
/* 1441 */       if (!this.world.isStatic) {
/* 1442 */         e(true);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean d(int i, int j, int k) {
/* 1448 */     if (this.abilities.mayBuild) {
/* 1449 */       return true;
/*      */     }
/* 1451 */     Block block = this.world.getType(i, j, k);
/*      */     
/* 1453 */     if (block.getMaterial() != Material.AIR) {
/* 1454 */       if (block.getMaterial().q()) {
/* 1455 */         return true;
/*      */       }
/*      */       
/* 1458 */       if (bF() != null) {
/* 1459 */         ItemStack itemstack = bF();
/*      */         
/* 1461 */         if (itemstack.b(block) || itemstack.a(block) > 1.0F) {
/* 1462 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1467 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean a(int i, int j, int k, int l, ItemStack itemstack) {
/* 1472 */     return this.abilities.mayBuild ? true : ((itemstack != null) ? itemstack.z() : false);
/*      */   }
/*      */   
/*      */   protected int getExpValue(EntityHuman entityhuman) {
/* 1476 */     if (this.world.getGameRules().getBoolean("keepInventory")) {
/* 1477 */       return 0;
/*      */     }
/* 1479 */     int i = this.expLevel * 7;
/*      */     
/* 1481 */     return (i > 100) ? 100 : i;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean alwaysGivesExp() {
/* 1486 */     return true;
/*      */   }
/*      */   
/*      */   public void copyTo(EntityHuman entityhuman, boolean flag) {
/* 1490 */     if (flag) {
/* 1491 */       this.inventory.b(entityhuman.inventory);
/* 1492 */       setHealth(entityhuman.getHealth());
/* 1493 */       this.foodData = entityhuman.foodData;
/* 1494 */       this.expLevel = entityhuman.expLevel;
/* 1495 */       this.expTotal = entityhuman.expTotal;
/* 1496 */       this.exp = entityhuman.exp;
/* 1497 */       setScore(entityhuman.getScore());
/* 1498 */       this.aq = entityhuman.aq;
/* 1499 */     } else if (this.world.getGameRules().getBoolean("keepInventory")) {
/* 1500 */       this.inventory.b(entityhuman.inventory);
/* 1501 */       this.expLevel = entityhuman.expLevel;
/* 1502 */       this.expTotal = entityhuman.expTotal;
/* 1503 */       this.exp = entityhuman.exp;
/* 1504 */       setScore(entityhuman.getScore());
/*      */     } 
/*      */     
/* 1507 */     this.enderChest = entityhuman.enderChest;
/*      */   }
/*      */   
/*      */   protected boolean g_() {
/* 1511 */     return !this.abilities.isFlying;
/*      */   }
/*      */   
/*      */   public void updateAbilities() {}
/*      */   
/*      */   public void a(EnumGamemode enumgamemode) {}
/*      */   
/*      */   public String getName() {
/* 1519 */     return this.i.getName();
/*      */   }
/*      */   
/*      */   public World getWorld() {
/* 1523 */     return this.world;
/*      */   }
/*      */   
/*      */   public InventoryEnderChest getEnderChest() {
/* 1527 */     return this.enderChest;
/*      */   }
/*      */   
/*      */   public ItemStack getEquipment(int i) {
/* 1531 */     return (i == 0) ? this.inventory.getItemInHand() : this.inventory.armor[i - 1];
/*      */   }
/*      */   
/*      */   public ItemStack be() {
/* 1535 */     return this.inventory.getItemInHand();
/*      */   }
/*      */   
/*      */   public void setEquipment(int i, ItemStack itemstack) {
/* 1539 */     this.inventory.armor[i] = itemstack;
/*      */   }
/*      */   
/*      */   public ItemStack[] getEquipment() {
/* 1543 */     return this.inventory.armor;
/*      */   }
/*      */   
/*      */   public boolean aC() {
/* 1547 */     return !this.abilities.isFlying;
/*      */   }
/*      */   
/*      */   public Scoreboard getScoreboard() {
/* 1551 */     return this.world.getScoreboard();
/*      */   }
/*      */   
/*      */   public ScoreboardTeamBase getScoreboardTeam() {
/* 1555 */     return getScoreboard().getPlayerTeam(getName());
/*      */   }
/*      */ 
/*      */   
/*      */   public IChatBaseComponent getScoreboardDisplayName() {
/* 1560 */     ChatComponentText chatcomponenttext = new ChatComponentText(ScoreboardTeam.getPlayerDisplayName(getScoreboardTeam(), getName()));
/*      */     
/* 1562 */     chatcomponenttext.getChatModifier().setChatClickable(new ChatClickable(EnumClickAction.SUGGEST_COMMAND, "/msg " + getName() + " "));
/* 1563 */     return chatcomponenttext;
/*      */   }
/*      */   
/*      */   public void setAbsorptionHearts(float f) {
/* 1567 */     if (f < 0.0F) {
/* 1568 */       f = 0.0F;
/*      */     }
/*      */     
/* 1571 */     getDataWatcher().watch(17, Float.valueOf(f));
/*      */   }
/*      */   
/*      */   public float getAbsorptionHearts() {
/* 1575 */     return getDataWatcher().getFloat(17);
/*      */   }
/*      */   
/*      */   public static UUID a(GameProfile gameprofile) {
/* 1579 */     UUID uuid = gameprofile.getId();
/*      */     
/* 1581 */     if (uuid == null) {
/* 1582 */       uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + gameprofile.getName()).getBytes(Charsets.UTF_8));
/*      */     }
/*      */     
/* 1585 */     return uuid;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityHuman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */