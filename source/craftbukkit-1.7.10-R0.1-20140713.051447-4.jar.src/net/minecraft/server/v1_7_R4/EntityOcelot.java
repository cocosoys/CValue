/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*     */ 
/*     */ public class EntityOcelot extends EntityTameableAnimal {
/*     */   public EntityOcelot(World world) {
/*   8 */     super(world);
/*   9 */     a(0.6F, 0.8F);
/*  10 */     getNavigation().a(true);
/*  11 */     this.goalSelector.a(1, new PathfinderGoalFloat(this));
/*  12 */     this.goalSelector.a(2, this.bp);
/*  13 */     this.goalSelector.a(3, this.bq = new PathfinderGoalTempt(this, 0.6D, Items.RAW_FISH, true));
/*  14 */     this.goalSelector.a(4, new PathfinderGoalAvoidPlayer(this, EntityHuman.class, 16.0F, 0.8D, 1.33D));
/*  15 */     this.goalSelector.a(5, new PathfinderGoalFollowOwner(this, 1.0D, 10.0F, 5.0F));
/*  16 */     this.goalSelector.a(6, new PathfinderGoalJumpOnBlock(this, 1.33D));
/*  17 */     this.goalSelector.a(7, new PathfinderGoalLeapAtTarget(this, 0.3F));
/*  18 */     this.goalSelector.a(8, new PathfinderGoalOcelotAttack(this));
/*  19 */     this.goalSelector.a(9, new PathfinderGoalBreed(this, 0.8D));
/*  20 */     this.goalSelector.a(10, new PathfinderGoalRandomStroll(this, 0.8D));
/*  21 */     this.goalSelector.a(11, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 10.0F));
/*  22 */     this.targetSelector.a(1, new PathfinderGoalRandomTargetNonTamed(this, EntityChicken.class, 750, false));
/*     */   }
/*     */   private PathfinderGoalTempt bq;
/*     */   protected void c() {
/*  26 */     super.c();
/*  27 */     this.datawatcher.a(18, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public void bp() {
/*  31 */     if (getControllerMove().a()) {
/*  32 */       double d0 = getControllerMove().b();
/*     */       
/*  34 */       if (d0 == 0.6D) {
/*  35 */         setSneaking(true);
/*  36 */         setSprinting(false);
/*  37 */       } else if (d0 == 1.33D) {
/*  38 */         setSneaking(false);
/*  39 */         setSprinting(true);
/*     */       } else {
/*  41 */         setSneaking(false);
/*  42 */         setSprinting(false);
/*     */       } 
/*     */     } else {
/*  45 */       setSneaking(false);
/*  46 */       setSprinting(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean isTypeNotPersistent() {
/*  51 */     return !isTamed();
/*     */   }
/*     */   
/*     */   public boolean bk() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   protected void aD() {
/*  59 */     super.aD();
/*  60 */     getAttributeInstance(GenericAttributes.maxHealth).setValue(10.0D);
/*  61 */     getAttributeInstance(GenericAttributes.d).setValue(0.30000001192092896D);
/*     */   }
/*     */   
/*     */   protected void b(float f) {}
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/*  67 */     super.b(nbttagcompound);
/*  68 */     nbttagcompound.setInt("CatType", getCatType());
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/*  72 */     super.a(nbttagcompound);
/*  73 */     setCatType(nbttagcompound.getInt("CatType"));
/*     */   }
/*     */   
/*     */   protected String t() {
/*  77 */     return isTamed() ? (ce() ? "mob.cat.purr" : ((this.random.nextInt(4) == 0) ? "mob.cat.purreow" : "mob.cat.meow")) : "";
/*     */   }
/*     */   
/*     */   protected String aT() {
/*  81 */     return "mob.cat.hitt";
/*     */   }
/*     */   
/*     */   protected String aU() {
/*  85 */     return "mob.cat.hitt";
/*     */   }
/*     */   
/*     */   protected float bf() {
/*  89 */     return 0.4F;
/*     */   }
/*     */   
/*     */   protected Item getLoot() {
/*  93 */     return Items.LEATHER;
/*     */   }
/*     */   
/*     */   public boolean n(Entity entity) {
/*  97 */     return entity.damageEntity(DamageSource.mobAttack(this), 3.0F);
/*     */   }
/*     */   
/*     */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 101 */     if (isInvulnerable()) {
/* 102 */       return false;
/*     */     }
/* 104 */     this.bp.setSitting(false);
/* 105 */     return super.damageEntity(damagesource, f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dropDeathLoot(boolean flag, int i) {}
/*     */   
/*     */   public boolean a(EntityHuman entityhuman) {
/* 112 */     ItemStack itemstack = entityhuman.inventory.getItemInHand();
/*     */     
/* 114 */     if (isTamed()) {
/* 115 */       if (e(entityhuman) && !this.world.isStatic && !c(itemstack)) {
/* 116 */         this.bp.setSitting(!isSitting());
/*     */       }
/* 118 */     } else if (this.bq.f() && itemstack != null && itemstack.getItem() == Items.RAW_FISH && entityhuman.f(this) < 9.0D) {
/* 119 */       if (!entityhuman.abilities.canInstantlyBuild) {
/* 120 */         itemstack.count--;
/*     */       }
/*     */       
/* 123 */       if (itemstack.count <= 0) {
/* 124 */         entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack)null);
/*     */       }
/*     */       
/* 127 */       if (!this.world.isStatic)
/*     */       {
/* 129 */         if (this.random.nextInt(3) == 0 && !CraftEventFactory.callEntityTameEvent(this, entityhuman).isCancelled()) {
/* 130 */           setTamed(true);
/* 131 */           setCatType(1 + this.world.random.nextInt(3));
/* 132 */           setOwnerUUID(entityhuman.getUniqueID().toString());
/* 133 */           i(true);
/* 134 */           this.bp.setSitting(true);
/* 135 */           this.world.broadcastEntityEffect(this, (byte)7);
/*     */         } else {
/* 137 */           i(false);
/* 138 */           this.world.broadcastEntityEffect(this, (byte)6);
/*     */         } 
/*     */       }
/*     */       
/* 142 */       return true;
/*     */     } 
/*     */     
/* 145 */     return super.a(entityhuman);
/*     */   }
/*     */   
/*     */   public EntityOcelot b(EntityAgeable entityageable) {
/* 149 */     EntityOcelot entityocelot = new EntityOcelot(this.world);
/*     */     
/* 151 */     if (isTamed()) {
/* 152 */       entityocelot.setOwnerUUID(getOwnerUUID());
/* 153 */       entityocelot.setTamed(true);
/* 154 */       entityocelot.setCatType(getCatType());
/*     */     } 
/*     */     
/* 157 */     return entityocelot;
/*     */   }
/*     */   
/*     */   public boolean c(ItemStack itemstack) {
/* 161 */     return (itemstack != null && itemstack.getItem() == Items.RAW_FISH);
/*     */   }
/*     */   
/*     */   public boolean mate(EntityAnimal entityanimal) {
/* 165 */     if (entityanimal == this)
/* 166 */       return false; 
/* 167 */     if (!isTamed())
/* 168 */       return false; 
/* 169 */     if (!(entityanimal instanceof EntityOcelot)) {
/* 170 */       return false;
/*     */     }
/* 172 */     EntityOcelot entityocelot = (EntityOcelot)entityanimal;
/*     */     
/* 174 */     return !entityocelot.isTamed() ? false : ((ce() && entityocelot.ce()));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCatType() {
/* 179 */     return this.datawatcher.getByte(18);
/*     */   }
/*     */   
/*     */   public void setCatType(int i) {
/* 183 */     this.datawatcher.watch(18, Byte.valueOf((byte)i));
/*     */   }
/*     */   
/*     */   public boolean canSpawn() {
/* 187 */     if (this.world.random.nextInt(3) == 0) {
/* 188 */       return false;
/*     */     }
/* 190 */     if (this.world.b(this.boundingBox) && this.world.getCubes(this, this.boundingBox).isEmpty() && !this.world.containsLiquid(this.boundingBox)) {
/* 191 */       int i = MathHelper.floor(this.locX);
/* 192 */       int j = MathHelper.floor(this.boundingBox.b);
/* 193 */       int k = MathHelper.floor(this.locZ);
/*     */       
/* 195 */       if (j < 63) {
/* 196 */         return false;
/*     */       }
/*     */       
/* 199 */       Block block = this.world.getType(i, j - 1, k);
/*     */       
/* 201 */       if (block == Blocks.GRASS || block.getMaterial() == Material.LEAVES) {
/* 202 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 211 */     return hasCustomName() ? getCustomName() : (isTamed() ? LocaleI18n.get("entity.Cat.name") : super.getName());
/*     */   }
/*     */   
/*     */   public GroupDataEntity prepare(GroupDataEntity groupdataentity) {
/* 215 */     groupdataentity = super.prepare(groupdataentity);
/* 216 */     if (this.world.random.nextInt(7) == 0) {
/* 217 */       for (int i = 0; i < 2; i++) {
/* 218 */         EntityOcelot entityocelot = new EntityOcelot(this.world);
/*     */         
/* 220 */         entityocelot.setPositionRotation(this.locX, this.locY, this.locZ, this.yaw, 0.0F);
/* 221 */         entityocelot.setAge(-24000);
/* 222 */         this.world.addEntity(entityocelot, CreatureSpawnEvent.SpawnReason.OCELOT_BABY);
/*     */       } 
/*     */     }
/*     */     
/* 226 */     return groupdataentity;
/*     */   }
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 230 */     return b(entityageable);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityOcelot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */