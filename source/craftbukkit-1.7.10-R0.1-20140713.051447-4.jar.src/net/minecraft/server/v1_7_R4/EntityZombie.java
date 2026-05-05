/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftLivingEntity;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*     */ import org.bukkit.event.entity.EntityCombustByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityCombustEvent;
/*     */ import org.bukkit.event.entity.EntityTargetEvent;
/*     */ import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
/*     */ 
/*     */ public class EntityZombie
/*     */   extends EntityMonster {
/*  18 */   protected static final IAttribute bp = (new AttributeRanged("zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).a("Spawn Reinforcements Chance");
/*  19 */   private static final UUID bq = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
/*  20 */   private static final AttributeModifier br = new AttributeModifier(bq, "Baby speed boost", 0.5D, 1);
/*  21 */   private final PathfinderGoalBreakDoor bs = new PathfinderGoalBreakDoor(this);
/*     */   private int bt;
/*     */   private boolean bu = false;
/*  24 */   private float bv = -1.0F;
/*     */   private float bw;
/*  26 */   private int lastTick = MinecraftServer.currentTick;
/*     */   
/*     */   public EntityZombie(World world) {
/*  29 */     super(world);
/*  30 */     getNavigation().b(true);
/*  31 */     this.goalSelector.a(0, new PathfinderGoalFloat(this));
/*  32 */     this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, EntityHuman.class, 1.0D, false));
/*  33 */     this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntityVillager.class, 1.0D, true));
/*  34 */     this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
/*  35 */     this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
/*  36 */     this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
/*  37 */     this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
/*  38 */     this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
/*  39 */     this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true));
/*  40 */     this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 0, true));
/*  41 */     this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityVillager.class, 0, false));
/*  42 */     a(0.6F, 1.8F);
/*     */   }
/*     */   
/*     */   protected void aD() {
/*  46 */     super.aD();
/*  47 */     getAttributeInstance(GenericAttributes.b).setValue(40.0D);
/*  48 */     getAttributeInstance(GenericAttributes.d).setValue(0.23000000417232513D);
/*  49 */     getAttributeInstance(GenericAttributes.e).setValue(3.0D);
/*  50 */     getAttributeMap().b(bp).setValue(this.random.nextDouble() * 0.10000000149011612D);
/*     */   }
/*     */   
/*     */   protected void c() {
/*  54 */     super.c();
/*  55 */     getDataWatcher().a(12, Byte.valueOf((byte)0));
/*  56 */     getDataWatcher().a(13, Byte.valueOf((byte)0));
/*  57 */     getDataWatcher().a(14, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public int aV() {
/*  61 */     int i = super.aV() + 2;
/*     */     
/*  63 */     if (i > 20) {
/*  64 */       i = 20;
/*     */     }
/*     */     
/*  67 */     return i;
/*     */   }
/*     */   
/*     */   protected boolean bk() {
/*  71 */     return true;
/*     */   }
/*     */   
/*     */   public boolean bZ() {
/*  75 */     return this.bu;
/*     */   }
/*     */   
/*     */   public void a(boolean flag) {
/*  79 */     if (this.bu != flag) {
/*  80 */       this.bu = flag;
/*  81 */       if (flag) {
/*  82 */         this.goalSelector.a(1, this.bs);
/*     */       } else {
/*  84 */         this.goalSelector.a(this.bs);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isBaby() {
/*  90 */     return (getDataWatcher().getByte(12) == 1);
/*     */   }
/*     */   
/*     */   protected int getExpValue(EntityHuman entityhuman) {
/*  94 */     if (isBaby()) {
/*  95 */       this.b = (int)(this.b * 2.5F);
/*     */     }
/*     */     
/*  98 */     return super.getExpValue(entityhuman);
/*     */   }
/*     */   
/*     */   public void setBaby(boolean flag) {
/* 102 */     getDataWatcher().watch(12, Byte.valueOf((byte)(flag ? 1 : 0)));
/* 103 */     if (this.world != null && !this.world.isStatic) {
/* 104 */       AttributeInstance attributeinstance = getAttributeInstance(GenericAttributes.d);
/*     */       
/* 106 */       attributeinstance.b(br);
/* 107 */       if (flag) {
/* 108 */         attributeinstance.a(br);
/*     */       }
/*     */     } 
/*     */     
/* 112 */     k(flag);
/*     */   }
/*     */   
/*     */   public boolean isVillager() {
/* 116 */     return (getDataWatcher().getByte(13) == 1);
/*     */   }
/*     */   
/*     */   public void setVillager(boolean flag) {
/* 120 */     getDataWatcher().watch(13, Byte.valueOf((byte)(flag ? 1 : 0)));
/*     */   }
/*     */   
/*     */   public void e() {
/* 124 */     if (this.world.w() && !this.world.isStatic && !isBaby()) {
/* 125 */       float f = d(1.0F);
/*     */       
/* 127 */       if (f > 0.5F && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.world.i(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ))) {
/* 128 */         boolean flag = true;
/* 129 */         ItemStack itemstack = getEquipment(4);
/*     */         
/* 131 */         if (itemstack != null) {
/* 132 */           if (itemstack.g()) {
/* 133 */             itemstack.setData(itemstack.j() + this.random.nextInt(2));
/* 134 */             if (itemstack.j() >= itemstack.l()) {
/* 135 */               a(itemstack);
/* 136 */               setEquipment(4, (ItemStack)null);
/*     */             } 
/*     */           } 
/*     */           
/* 140 */           flag = false;
/*     */         } 
/*     */         
/* 143 */         if (flag) {
/*     */           
/* 145 */           EntityCombustEvent event = new EntityCombustEvent((Entity)getBukkitEntity(), 8);
/* 146 */           this.world.getServer().getPluginManager().callEvent((Event)event);
/*     */           
/* 148 */           if (!event.isCancelled()) {
/* 149 */             setOnFire(event.getDuration());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 156 */     if (am() && getGoalTarget() != null && this.vehicle instanceof EntityChicken) {
/* 157 */       ((EntityInsentient)this.vehicle).getNavigation().a(getNavigation().e(), 1.5D);
/*     */     }
/*     */     
/* 160 */     super.e();
/*     */   }
/*     */   
/*     */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 164 */     if (!super.damageEntity(damagesource, f)) {
/* 165 */       return false;
/*     */     }
/* 167 */     EntityLiving entityliving = getGoalTarget();
/*     */     
/* 169 */     if (entityliving == null && bT() instanceof EntityLiving) {
/* 170 */       entityliving = (EntityLiving)bT();
/*     */     }
/*     */     
/* 173 */     if (entityliving == null && damagesource.getEntity() instanceof EntityLiving) {
/* 174 */       entityliving = (EntityLiving)damagesource.getEntity();
/*     */     }
/*     */     
/* 177 */     if (entityliving != null && this.world.difficulty == EnumDifficulty.HARD && this.random.nextFloat() < getAttributeInstance(bp).getValue()) {
/* 178 */       int i = MathHelper.floor(this.locX);
/* 179 */       int j = MathHelper.floor(this.locY);
/* 180 */       int k = MathHelper.floor(this.locZ);
/* 181 */       EntityZombie entityzombie = new EntityZombie(this.world);
/*     */       
/* 183 */       for (int l = 0; l < 50; l++) {
/* 184 */         int i1 = i + MathHelper.nextInt(this.random, 7, 40) * MathHelper.nextInt(this.random, -1, 1);
/* 185 */         int j1 = j + MathHelper.nextInt(this.random, 7, 40) * MathHelper.nextInt(this.random, -1, 1);
/* 186 */         int k1 = k + MathHelper.nextInt(this.random, 7, 40) * MathHelper.nextInt(this.random, -1, 1);
/*     */         
/* 188 */         if (World.a(this.world, i1, j1 - 1, k1) && this.world.getLightLevel(i1, j1, k1) < 10) {
/* 189 */           entityzombie.setPosition(i1, j1, k1);
/* 190 */           if (this.world.b(entityzombie.boundingBox) && this.world.getCubes(entityzombie, entityzombie.boundingBox).isEmpty() && !this.world.containsLiquid(entityzombie.boundingBox)) {
/* 191 */             this.world.addEntity(entityzombie, CreatureSpawnEvent.SpawnReason.REINFORCEMENTS);
/*     */             
/* 193 */             EntityTargetLivingEntityEvent event = CraftEventFactory.callEntityTargetLivingEvent(entityzombie, entityliving, EntityTargetEvent.TargetReason.REINFORCEMENT_TARGET);
/* 194 */             if (!event.isCancelled()) {
/* 195 */               if (event.getTarget() == null) {
/* 196 */                 entityzombie.setGoalTarget((EntityLiving)null);
/*     */               } else {
/* 198 */                 entityzombie.setGoalTarget(((CraftLivingEntity)event.getTarget()).getHandle());
/*     */               } 
/*     */             }
/*     */             
/* 202 */             entityzombie.prepare((GroupDataEntity)null);
/* 203 */             getAttributeInstance(bp).a(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
/* 204 */             entityzombie.getAttributeInstance(bp).a(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void h() {
/* 216 */     if (!this.world.isStatic && cc()) {
/* 217 */       int i = ce();
/*     */ 
/*     */       
/* 220 */       int elapsedTicks = MinecraftServer.currentTick - this.lastTick;
/* 221 */       this.lastTick = MinecraftServer.currentTick;
/* 222 */       i *= elapsedTicks;
/*     */ 
/*     */       
/* 225 */       this.bt -= i;
/* 226 */       if (this.bt <= 0) {
/* 227 */         cd();
/*     */       }
/*     */     } 
/*     */     
/* 231 */     super.h();
/*     */   }
/*     */   
/*     */   public boolean n(Entity entity) {
/* 235 */     boolean flag = super.n(entity);
/*     */     
/* 237 */     if (flag) {
/* 238 */       int i = this.world.difficulty.a();
/*     */       
/* 240 */       if (be() == null && isBurning() && this.random.nextFloat() < i * 0.3F) {
/*     */         
/* 242 */         EntityCombustByEntityEvent event = new EntityCombustByEntityEvent((Entity)getBukkitEntity(), (Entity)entity.getBukkitEntity(), 2 * i);
/* 243 */         this.world.getServer().getPluginManager().callEvent((Event)event);
/*     */         
/* 245 */         if (!event.isCancelled()) {
/* 246 */           entity.setOnFire(event.getDuration());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 252 */     return flag;
/*     */   }
/*     */   
/*     */   protected String t() {
/* 256 */     return "mob.zombie.say";
/*     */   }
/*     */   
/*     */   protected String aT() {
/* 260 */     return "mob.zombie.hurt";
/*     */   }
/*     */   
/*     */   protected String aU() {
/* 264 */     return "mob.zombie.death";
/*     */   }
/*     */   
/*     */   protected void a(int i, int j, int k, Block block) {
/* 268 */     makeSound("mob.zombie.step", 0.15F, 1.0F);
/*     */   }
/*     */   
/*     */   protected Item getLoot() {
/* 272 */     return Items.ROTTEN_FLESH;
/*     */   }
/*     */   
/*     */   public EnumMonsterType getMonsterType() {
/* 276 */     return EnumMonsterType.UNDEAD;
/*     */   }
/*     */   
/*     */   protected void getRareDrop(int i) {
/* 280 */     switch (this.random.nextInt(3)) {
/*     */       case 0:
/* 282 */         a(Items.IRON_INGOT, 1);
/*     */         break;
/*     */       
/*     */       case 1:
/* 286 */         a(Items.CARROT, 1);
/*     */         break;
/*     */       
/*     */       case 2:
/* 290 */         a(Items.POTATO, 1);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   protected void bC() {
/* 295 */     super.bC();
/* 296 */     if (this.random.nextFloat() < ((this.world.difficulty == EnumDifficulty.HARD) ? 0.05F : 0.01F)) {
/* 297 */       int i = this.random.nextInt(3);
/*     */       
/* 299 */       if (i == 0) {
/* 300 */         setEquipment(0, new ItemStack(Items.IRON_SWORD));
/*     */       } else {
/* 302 */         setEquipment(0, new ItemStack(Items.IRON_SPADE));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/* 308 */     super.b(nbttagcompound);
/* 309 */     if (isBaby()) {
/* 310 */       nbttagcompound.setBoolean("IsBaby", true);
/*     */     }
/*     */     
/* 313 */     if (isVillager()) {
/* 314 */       nbttagcompound.setBoolean("IsVillager", true);
/*     */     }
/*     */     
/* 317 */     nbttagcompound.setInt("ConversionTime", cc() ? this.bt : -1);
/* 318 */     nbttagcompound.setBoolean("CanBreakDoors", bZ());
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 322 */     super.a(nbttagcompound);
/* 323 */     if (nbttagcompound.getBoolean("IsBaby")) {
/* 324 */       setBaby(true);
/*     */     }
/*     */     
/* 327 */     if (nbttagcompound.getBoolean("IsVillager")) {
/* 328 */       setVillager(true);
/*     */     }
/*     */     
/* 331 */     if (nbttagcompound.hasKeyOfType("ConversionTime", 99) && nbttagcompound.getInt("ConversionTime") > -1) {
/* 332 */       a(nbttagcompound.getInt("ConversionTime"));
/*     */     }
/*     */     
/* 335 */     a(nbttagcompound.getBoolean("CanBreakDoors"));
/*     */   }
/*     */   
/*     */   public void a(EntityLiving entityliving) {
/* 339 */     super.a(entityliving);
/* 340 */     if ((this.world.difficulty == EnumDifficulty.NORMAL || this.world.difficulty == EnumDifficulty.HARD) && entityliving instanceof EntityVillager) {
/* 341 */       if (this.world.difficulty != EnumDifficulty.HARD && this.random.nextBoolean()) {
/*     */         return;
/*     */       }
/*     */       
/* 345 */       EntityZombie entityzombie = new EntityZombie(this.world);
/*     */       
/* 347 */       entityzombie.k(entityliving);
/* 348 */       this.world.kill(entityliving);
/* 349 */       entityzombie.prepare((GroupDataEntity)null);
/* 350 */       entityzombie.setVillager(true);
/* 351 */       if (entityliving.isBaby()) {
/* 352 */         entityzombie.setBaby(true);
/*     */       }
/*     */       
/* 355 */       this.world.addEntity(entityzombie, CreatureSpawnEvent.SpawnReason.INFECTION);
/* 356 */       this.world.a((EntityHuman)null, 1016, (int)this.locX, (int)this.locY, (int)this.locZ, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public GroupDataEntity prepare(GroupDataEntity groupdataentity) {
/* 361 */     Object object = super.prepare(groupdataentity);
/* 362 */     float f = this.world.b(this.locX, this.locY, this.locZ);
/*     */     
/* 364 */     h((this.random.nextFloat() < 0.55F * f));
/* 365 */     if (object == null) {
/* 366 */       object = new GroupDataZombie(this, (this.world.random.nextFloat() < 0.05F), (this.world.random.nextFloat() < 0.05F), (EmptyClassZombie)null);
/*     */     }
/*     */     
/* 369 */     if (object instanceof GroupDataZombie) {
/* 370 */       GroupDataZombie groupdatazombie = (GroupDataZombie)object;
/*     */       
/* 372 */       if (groupdatazombie.b) {
/* 373 */         setVillager(true);
/*     */       }
/*     */       
/* 376 */       if (groupdatazombie.a) {
/* 377 */         setBaby(true);
/* 378 */         if (this.world.random.nextFloat() < 0.05D) {
/* 379 */           List<EntityChicken> list = this.world.a(EntityChicken.class, this.boundingBox.grow(5.0D, 3.0D, 5.0D), IEntitySelector.b);
/*     */           
/* 381 */           if (!list.isEmpty()) {
/* 382 */             EntityChicken entitychicken = list.get(0);
/*     */             
/* 384 */             entitychicken.i(true);
/* 385 */             mount(entitychicken);
/*     */           } 
/* 387 */         } else if (this.world.random.nextFloat() < 0.05D) {
/* 388 */           EntityChicken entitychicken1 = new EntityChicken(this.world);
/*     */           
/* 390 */           entitychicken1.setPositionRotation(this.locX, this.locY, this.locZ, this.yaw, 0.0F);
/* 391 */           entitychicken1.prepare((GroupDataEntity)null);
/* 392 */           entitychicken1.i(true);
/* 393 */           this.world.addEntity(entitychicken1, CreatureSpawnEvent.SpawnReason.MOUNT);
/* 394 */           mount(entitychicken1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 399 */     a((this.random.nextFloat() < f * 0.1F));
/* 400 */     bC();
/* 401 */     bD();
/* 402 */     if (getEquipment(4) == null) {
/* 403 */       Calendar calendar = this.world.V();
/*     */       
/* 405 */       if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.random.nextFloat() < 0.25F) {
/* 406 */         setEquipment(4, new ItemStack((this.random.nextFloat() < 0.1F) ? Blocks.JACK_O_LANTERN : Blocks.PUMPKIN));
/* 407 */         this.dropChances[4] = 0.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 411 */     getAttributeInstance(GenericAttributes.c).a(new AttributeModifier("Random spawn bonus", this.random.nextDouble() * 0.05000000074505806D, 0));
/* 412 */     double d0 = this.random.nextDouble() * 1.5D * this.world.b(this.locX, this.locY, this.locZ);
/*     */     
/* 414 */     if (d0 > 1.0D) {
/* 415 */       getAttributeInstance(GenericAttributes.b).a(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
/*     */     }
/*     */     
/* 418 */     if (this.random.nextFloat() < f * 0.05F) {
/* 419 */       getAttributeInstance(bp).a(new AttributeModifier("Leader zombie bonus", this.random.nextDouble() * 0.25D + 0.5D, 0));
/* 420 */       getAttributeInstance(GenericAttributes.maxHealth).a(new AttributeModifier("Leader zombie bonus", this.random.nextDouble() * 3.0D + 1.0D, 2));
/* 421 */       a(true);
/*     */     } 
/*     */     
/* 424 */     return (GroupDataEntity)object;
/*     */   }
/*     */   
/*     */   public boolean a(EntityHuman entityhuman) {
/* 428 */     ItemStack itemstack = entityhuman.bF();
/*     */     
/* 430 */     if (itemstack != null && itemstack.getItem() == Items.GOLDEN_APPLE && itemstack.getData() == 0 && isVillager() && hasEffect(MobEffectList.WEAKNESS)) {
/* 431 */       if (!entityhuman.abilities.canInstantlyBuild) {
/* 432 */         itemstack.count--;
/*     */       }
/*     */       
/* 435 */       if (itemstack.count <= 0) {
/* 436 */         entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack)null);
/*     */       }
/*     */       
/* 439 */       if (!this.world.isStatic) {
/* 440 */         a(this.random.nextInt(2401) + 3600);
/*     */       }
/*     */       
/* 443 */       return true;
/*     */     } 
/* 445 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(int i) {
/* 450 */     this.bt = i;
/* 451 */     getDataWatcher().watch(14, Byte.valueOf((byte)1));
/* 452 */     removeEffect(MobEffectList.WEAKNESS.id);
/* 453 */     addEffect(new MobEffect(MobEffectList.INCREASE_DAMAGE.id, i, Math.min(this.world.difficulty.a() - 1, 0)));
/* 454 */     this.world.broadcastEntityEffect(this, (byte)16);
/*     */   }
/*     */   
/*     */   protected boolean isTypeNotPersistent() {
/* 458 */     return !cc();
/*     */   }
/*     */   
/*     */   public boolean cc() {
/* 462 */     return (getDataWatcher().getByte(14) == 1);
/*     */   }
/*     */   
/*     */   protected void cd() {
/* 466 */     EntityVillager entityvillager = new EntityVillager(this.world);
/*     */     
/* 468 */     entityvillager.k(this);
/* 469 */     entityvillager.prepare((GroupDataEntity)null);
/* 470 */     entityvillager.cd();
/* 471 */     if (isBaby()) {
/* 472 */       entityvillager.setAge(-24000);
/*     */     }
/*     */     
/* 475 */     this.world.kill(this);
/* 476 */     this.world.addEntity(entityvillager, CreatureSpawnEvent.SpawnReason.CURED);
/* 477 */     entityvillager.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 200, 0));
/* 478 */     this.world.a((EntityHuman)null, 1017, (int)this.locX, (int)this.locY, (int)this.locZ, 0);
/*     */   }
/*     */   
/*     */   protected int ce() {
/* 482 */     int i = 1;
/*     */     
/* 484 */     if (this.random.nextFloat() < 0.01F) {
/* 485 */       int j = 0;
/*     */       
/* 487 */       for (int k = (int)this.locX - 4; k < (int)this.locX + 4 && j < 14; k++) {
/* 488 */         for (int l = (int)this.locY - 4; l < (int)this.locY + 4 && j < 14; l++) {
/* 489 */           for (int i1 = (int)this.locZ - 4; i1 < (int)this.locZ + 4 && j < 14; i1++) {
/* 490 */             Block block = this.world.getType(k, l, i1);
/*     */             
/* 492 */             if (block == Blocks.IRON_FENCE || block == Blocks.BED) {
/* 493 */               if (this.random.nextFloat() < 0.3F) {
/* 494 */                 i++;
/*     */               }
/*     */               
/* 497 */               j++;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 504 */     return i;
/*     */   }
/*     */   
/*     */   public void k(boolean flag) {
/* 508 */     a(flag ? 0.5F : 1.0F);
/*     */   }
/*     */   
/*     */   protected final void a(float f, float f1) {
/* 512 */     boolean flag = (this.bv > 0.0F && this.bw > 0.0F);
/*     */     
/* 514 */     this.bv = f;
/* 515 */     this.bw = f1;
/* 516 */     if (!flag) {
/* 517 */       a(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void a(float f) {
/* 522 */     super.a(this.bv * f, this.bw * f);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityZombie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */