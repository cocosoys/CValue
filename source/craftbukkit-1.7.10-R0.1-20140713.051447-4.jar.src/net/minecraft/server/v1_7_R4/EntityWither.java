/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.entity.EntityRegainHealthEvent;
/*     */ import org.bukkit.event.entity.ExplosionPrimeEvent;
/*     */ 
/*     */ public class EntityWither
/*     */   extends EntityMonster
/*     */   implements IRangedEntity {
/*  14 */   private float[] bp = new float[2];
/*  15 */   private float[] bq = new float[2];
/*  16 */   private float[] br = new float[2];
/*  17 */   private float[] bs = new float[2];
/*  18 */   private int[] bt = new int[2];
/*  19 */   private int[] bu = new int[2];
/*     */   private int bv;
/*  21 */   private static final IEntitySelector bw = new EntitySelectorNotUndead();
/*     */   
/*     */   public EntityWither(World world) {
/*  24 */     super(world);
/*  25 */     setHealth(getMaxHealth());
/*  26 */     a(0.9F, 4.0F);
/*  27 */     this.fireProof = true;
/*  28 */     getNavigation().e(true);
/*  29 */     this.goalSelector.a(0, new PathfinderGoalFloat(this));
/*  30 */     this.goalSelector.a(2, new PathfinderGoalArrowAttack(this, 1.0D, 40, 20.0F));
/*  31 */     this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 1.0D));
/*  32 */     this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
/*  33 */     this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
/*  34 */     this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false));
/*  35 */     this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityInsentient.class, 0, false, false, bw));
/*  36 */     this.b = 50;
/*     */   }
/*     */   
/*     */   protected void c() {
/*  40 */     super.c();
/*  41 */     this.datawatcher.a(17, new Integer(0));
/*  42 */     this.datawatcher.a(18, new Integer(0));
/*  43 */     this.datawatcher.a(19, new Integer(0));
/*  44 */     this.datawatcher.a(20, new Integer(0));
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/*  48 */     super.b(nbttagcompound);
/*  49 */     nbttagcompound.setInt("Invul", ca());
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/*  53 */     super.a(nbttagcompound);
/*  54 */     s(nbttagcompound.getInt("Invul"));
/*     */   }
/*     */   
/*     */   protected String t() {
/*  58 */     return "mob.wither.idle";
/*     */   }
/*     */   
/*     */   protected String aT() {
/*  62 */     return "mob.wither.hurt";
/*     */   }
/*     */   
/*     */   protected String aU() {
/*  66 */     return "mob.wither.death";
/*     */   }
/*     */   
/*     */   public void e() {
/*  70 */     this.motY *= 0.6000000238418579D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     if (!this.world.isStatic && t(0) > 0) {
/*  76 */       Entity entity = this.world.getEntity(t(0));
/*     */       
/*  78 */       if (entity != null) {
/*  79 */         if (this.locY < entity.locY || (!cb() && this.locY < entity.locY + 5.0D)) {
/*  80 */           if (this.motY < 0.0D) {
/*  81 */             this.motY = 0.0D;
/*     */           }
/*     */           
/*  84 */           this.motY += (0.5D - this.motY) * 0.6000000238418579D;
/*     */         } 
/*     */         
/*  87 */         double d3 = entity.locX - this.locX;
/*     */         
/*  89 */         double d0 = entity.locZ - this.locZ;
/*  90 */         double d1 = d3 * d3 + d0 * d0;
/*  91 */         if (d1 > 9.0D) {
/*  92 */           double d2 = MathHelper.sqrt(d1);
/*  93 */           this.motX += (d3 / d2 * 0.5D - this.motX) * 0.6000000238418579D;
/*  94 */           this.motZ += (d0 / d2 * 0.5D - this.motZ) * 0.6000000238418579D;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     if (this.motX * this.motX + this.motZ * this.motZ > 0.05000000074505806D) {
/* 100 */       this.yaw = (float)Math.atan2(this.motZ, this.motX) * 57.295776F - 90.0F;
/*     */     }
/*     */     
/* 103 */     super.e();
/*     */     
/*     */     int i;
/*     */     
/* 107 */     for (i = 0; i < 2; i++) {
/* 108 */       this.bs[i] = this.bq[i];
/* 109 */       this.br[i] = this.bp[i];
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 114 */     for (i = 0; i < 2; i++) {
/* 115 */       int k = t(i + 1);
/* 116 */       Entity entity1 = null;
/*     */       
/* 118 */       if (k > 0) {
/* 119 */         entity1 = this.world.getEntity(k);
/*     */       }
/*     */       
/* 122 */       if (entity1 != null) {
/* 123 */         double d0 = u(i + 1);
/* 124 */         double d1 = v(i + 1);
/* 125 */         double d2 = w(i + 1);
/* 126 */         double d4 = entity1.locX - d0;
/* 127 */         double d5 = entity1.locY + entity1.getHeadHeight() - d1;
/* 128 */         double d6 = entity1.locZ - d2;
/* 129 */         double d7 = MathHelper.sqrt(d4 * d4 + d6 * d6);
/* 130 */         float f = (float)(Math.atan2(d6, d4) * 180.0D / 3.1415927410125732D) - 90.0F;
/* 131 */         float f1 = (float)-(Math.atan2(d5, d7) * 180.0D / 3.1415927410125732D);
/*     */         
/* 133 */         this.bp[i] = b(this.bp[i], f1, 40.0F);
/* 134 */         this.bq[i] = b(this.bq[i], f, 10.0F);
/*     */       } else {
/* 136 */         this.bq[i] = b(this.bq[i], this.aM, 10.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     boolean flag = cb();
/*     */     int j;
/* 142 */     for (j = 0; j < 3; j++) {
/* 143 */       double d8 = u(j);
/* 144 */       double d9 = v(j);
/* 145 */       double d10 = w(j);
/*     */       
/* 147 */       this.world.addParticle("smoke", d8 + this.random.nextGaussian() * 0.30000001192092896D, d9 + this.random.nextGaussian() * 0.30000001192092896D, d10 + this.random.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D);
/* 148 */       if (flag && this.world.random.nextInt(4) == 0) {
/* 149 */         this.world.addParticle("mobSpell", d8 + this.random.nextGaussian() * 0.30000001192092896D, d9 + this.random.nextGaussian() * 0.30000001192092896D, d10 + this.random.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D);
/*     */       }
/*     */     } 
/*     */     
/* 153 */     if (ca() > 0) {
/* 154 */       for (j = 0; j < 3; j++) {
/* 155 */         this.world.addParticle("mobSpell", this.locX + this.random.nextGaussian() * 1.0D, this.locY + (this.random.nextFloat() * 3.3F), this.locZ + this.random.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void bn() {
/* 163 */     if (ca() > 0) {
/* 164 */       int i = ca() - 1;
/* 165 */       if (i <= 0) {
/*     */         
/* 167 */         ExplosionPrimeEvent event = new ExplosionPrimeEvent((Entity)getBukkitEntity(), 7.0F, false);
/* 168 */         this.world.getServer().getPluginManager().callEvent((Event)event);
/*     */         
/* 170 */         if (!event.isCancelled()) {
/* 171 */           this.world.createExplosion(this, this.locX, this.locY + getHeadHeight(), this.locZ, event.getRadius(), event.getFire(), this.world.getGameRules().getBoolean("mobGriefing"));
/*     */         }
/*     */ 
/*     */         
/* 175 */         this.world.createExplosion(this, this.locX, this.locY + getHeadHeight(), this.locZ, 7.0F, false, this.world.getGameRules().getBoolean("mobGriefing"));
/* 176 */         this.world.b(1013, (int)this.locX, (int)this.locY, (int)this.locZ, 0);
/*     */       } 
/*     */       
/* 179 */       s(i);
/* 180 */       if (this.ticksLived % 10 == 0) {
/* 181 */         heal(10.0F, EntityRegainHealthEvent.RegainReason.WITHER_SPAWN);
/*     */       }
/*     */     } else {
/* 184 */       super.bn();
/*     */       
/*     */       int i;
/*     */       
/* 188 */       for (i = 1; i < 3; i++) {
/* 189 */         if (this.ticksLived >= this.bt[i - 1]) {
/* 190 */           this.bt[i - 1] = this.ticksLived + 10 + this.random.nextInt(10);
/* 191 */           if (this.world.difficulty == EnumDifficulty.NORMAL || this.world.difficulty == EnumDifficulty.HARD) {
/* 192 */             int i1001 = i - 1;
/* 193 */             int i1003 = this.bu[i - 1];
/*     */             
/* 195 */             this.bu[i1001] = this.bu[i - 1] + 1;
/* 196 */             if (i1003 > 15) {
/* 197 */               float f = 10.0F;
/* 198 */               float f1 = 5.0F;
/* 199 */               double d0 = MathHelper.a(this.random, this.locX - f, this.locX + f);
/* 200 */               double d1 = MathHelper.a(this.random, this.locY - f1, this.locY + f1);
/* 201 */               double d2 = MathHelper.a(this.random, this.locZ - f, this.locZ + f);
/*     */               
/* 203 */               a(i + 1, d0, d1, d2, true);
/* 204 */               this.bu[i - 1] = 0;
/*     */             } 
/*     */           } 
/*     */           
/* 208 */           int j = t(i);
/* 209 */           if (j > 0) {
/* 210 */             Entity entity = this.world.getEntity(j);
/*     */             
/* 212 */             if (entity != null && entity.isAlive() && f(entity) <= 900.0D && hasLineOfSight(entity)) {
/* 213 */               a(i + 1, (EntityLiving)entity);
/* 214 */               this.bt[i - 1] = this.ticksLived + 40 + this.random.nextInt(20);
/* 215 */               this.bu[i - 1] = 0;
/*     */             } else {
/* 217 */               b(i, 0);
/*     */             } 
/*     */           } else {
/* 220 */             List<EntityLiving> list = this.world.a(EntityLiving.class, this.boundingBox.grow(20.0D, 8.0D, 20.0D), bw);
/*     */             
/* 222 */             for (int i1 = 0; i1 < 10 && !list.isEmpty(); i1++) {
/* 223 */               EntityLiving entityliving = list.get(this.random.nextInt(list.size()));
/*     */               
/* 225 */               if (entityliving != this && entityliving.isAlive() && hasLineOfSight(entityliving)) {
/* 226 */                 if (entityliving instanceof EntityHuman) {
/* 227 */                   if (!((EntityHuman)entityliving).abilities.isInvulnerable)
/* 228 */                     b(i, entityliving.getId()); 
/*     */                   break;
/*     */                 } 
/* 231 */                 b(i, entityliving.getId());
/*     */                 
/*     */                 break;
/*     */               } 
/*     */               
/* 236 */               list.remove(entityliving);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 242 */       if (getGoalTarget() != null) {
/* 243 */         b(0, getGoalTarget().getId());
/*     */       } else {
/* 245 */         b(0, 0);
/*     */       } 
/*     */       
/* 248 */       if (this.bv > 0) {
/* 249 */         this.bv--;
/* 250 */         if (this.bv == 0 && this.world.getGameRules().getBoolean("mobGriefing")) {
/* 251 */           i = MathHelper.floor(this.locY);
/* 252 */           int j = MathHelper.floor(this.locX);
/* 253 */           int j1 = MathHelper.floor(this.locZ);
/* 254 */           boolean flag = false;
/*     */           
/* 256 */           for (int k1 = -1; k1 <= 1; k1++) {
/* 257 */             for (int l1 = -1; l1 <= 1; l1++) {
/* 258 */               for (int i2 = 0; i2 <= 3; i2++) {
/* 259 */                 int j2 = j + k1;
/* 260 */                 int k2 = i + i2;
/* 261 */                 int l2 = j1 + l1;
/* 262 */                 Block block = this.world.getType(j2, k2, l2);
/*     */                 
/* 264 */                 if (block.getMaterial() != Material.AIR && block != Blocks.BEDROCK && block != Blocks.ENDER_PORTAL && block != Blocks.ENDER_PORTAL_FRAME && block != Blocks.COMMAND)
/*     */                 {
/* 266 */                   if (!CraftEventFactory.callEntityChangeBlockEvent(this, j2, k2, l2, Blocks.AIR, 0).isCancelled())
/*     */                   {
/*     */ 
/*     */ 
/*     */                     
/* 271 */                     flag = (this.world.setAir(j2, k2, l2, true) || flag);
/*     */                   }
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/* 277 */           if (flag) {
/* 278 */             this.world.a((EntityHuman)null, 1012, (int)this.locX, (int)this.locY, (int)this.locZ, 0);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 283 */       if (this.ticksLived % 20 == 0) {
/* 284 */         heal(1.0F, EntityRegainHealthEvent.RegainReason.REGEN);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void bZ() {
/* 290 */     s(220);
/* 291 */     setHealth(getMaxHealth() / 3.0F);
/*     */   }
/*     */   
/*     */   public void as() {}
/*     */   
/*     */   public int aV() {
/* 297 */     return 4;
/*     */   }
/*     */   
/*     */   private double u(int i) {
/* 301 */     if (i <= 0) {
/* 302 */       return this.locX;
/*     */     }
/* 304 */     float f = (this.aM + (180 * (i - 1))) / 180.0F * 3.1415927F;
/* 305 */     float f1 = MathHelper.cos(f);
/*     */     
/* 307 */     return this.locX + f1 * 1.3D;
/*     */   }
/*     */ 
/*     */   
/*     */   private double v(int i) {
/* 312 */     return (i <= 0) ? (this.locY + 3.0D) : (this.locY + 2.2D);
/*     */   }
/*     */   
/*     */   private double w(int i) {
/* 316 */     if (i <= 0) {
/* 317 */       return this.locZ;
/*     */     }
/* 319 */     float f = (this.aM + (180 * (i - 1))) / 180.0F * 3.1415927F;
/* 320 */     float f1 = MathHelper.sin(f);
/*     */     
/* 322 */     return this.locZ + f1 * 1.3D;
/*     */   }
/*     */ 
/*     */   
/*     */   private float b(float f, float f1, float f2) {
/* 327 */     float f3 = MathHelper.g(f1 - f);
/*     */     
/* 329 */     if (f3 > f2) {
/* 330 */       f3 = f2;
/*     */     }
/*     */     
/* 333 */     if (f3 < -f2) {
/* 334 */       f3 = -f2;
/*     */     }
/*     */     
/* 337 */     return f + f3;
/*     */   }
/*     */   
/*     */   private void a(int i, EntityLiving entityliving) {
/* 341 */     a(i, entityliving.locX, entityliving.locY + entityliving.getHeadHeight() * 0.5D, entityliving.locZ, (i == 0 && this.random.nextFloat() < 0.001F));
/*     */   }
/*     */   
/*     */   private void a(int i, double d0, double d1, double d2, boolean flag) {
/* 345 */     this.world.a((EntityHuman)null, 1014, (int)this.locX, (int)this.locY, (int)this.locZ, 0);
/* 346 */     double d3 = u(i);
/* 347 */     double d4 = v(i);
/* 348 */     double d5 = w(i);
/* 349 */     double d6 = d0 - d3;
/* 350 */     double d7 = d1 - d4;
/* 351 */     double d8 = d2 - d5;
/* 352 */     EntityWitherSkull entitywitherskull = new EntityWitherSkull(this.world, this, d6, d7, d8);
/*     */     
/* 354 */     if (flag) {
/* 355 */       entitywitherskull.setCharged(true);
/*     */     }
/*     */     
/* 358 */     entitywitherskull.locY = d4;
/* 359 */     entitywitherskull.locX = d3;
/* 360 */     entitywitherskull.locZ = d5;
/* 361 */     this.world.addEntity(entitywitherskull);
/*     */   }
/*     */   
/*     */   public void a(EntityLiving entityliving, float f) {
/* 365 */     a(0, entityliving);
/*     */   }
/*     */   
/*     */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 369 */     if (isInvulnerable())
/* 370 */       return false; 
/* 371 */     if (damagesource == DamageSource.DROWN)
/* 372 */       return false; 
/* 373 */     if (ca() > 0) {
/* 374 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 378 */     if (cb()) {
/* 379 */       Entity entity1 = damagesource.i();
/* 380 */       if (entity1 instanceof EntityArrow) {
/* 381 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 385 */     Entity entity = damagesource.getEntity();
/* 386 */     if (entity != null && !(entity instanceof EntityHuman) && entity instanceof EntityLiving && ((EntityLiving)entity).getMonsterType() == getMonsterType()) {
/* 387 */       return false;
/*     */     }
/* 389 */     if (this.bv <= 0) {
/* 390 */       this.bv = 20;
/*     */     }
/*     */     
/* 393 */     for (int i = 0; i < this.bu.length; i++) {
/* 394 */       this.bu[i] = this.bu[i] + 3;
/*     */     }
/*     */     
/* 397 */     return super.damageEntity(damagesource, f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropDeathLoot(boolean flag, int i) {
/* 403 */     a(Items.NETHER_STAR, 1);
/* 404 */     if (!this.world.isStatic) {
/* 405 */       Iterator<EntityHuman> iterator = this.world.a(EntityHuman.class, this.boundingBox.grow(50.0D, 100.0D, 50.0D)).iterator();
/*     */       
/* 407 */       while (iterator.hasNext()) {
/* 408 */         EntityHuman entityhuman = iterator.next();
/*     */         
/* 410 */         entityhuman.a(AchievementList.J);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void w() {
/* 416 */     this.aU = 0;
/*     */   }
/*     */   
/*     */   protected void b(float f) {}
/*     */   
/*     */   public void addEffect(MobEffect mobeffect) {}
/*     */   
/*     */   protected boolean bk() {
/* 424 */     return true;
/*     */   }
/*     */   
/*     */   protected void aD() {
/* 428 */     super.aD();
/* 429 */     getAttributeInstance(GenericAttributes.maxHealth).setValue(300.0D);
/* 430 */     getAttributeInstance(GenericAttributes.d).setValue(0.6000000238418579D);
/* 431 */     getAttributeInstance(GenericAttributes.b).setValue(40.0D);
/*     */   }
/*     */   
/*     */   public int ca() {
/* 435 */     return this.datawatcher.getInt(20);
/*     */   }
/*     */   
/*     */   public void s(int i) {
/* 439 */     this.datawatcher.watch(20, Integer.valueOf(i));
/*     */   }
/*     */   
/*     */   public int t(int i) {
/* 443 */     return this.datawatcher.getInt(17 + i);
/*     */   }
/*     */   
/*     */   public void b(int i, int j) {
/* 447 */     this.datawatcher.watch(17 + i, Integer.valueOf(j));
/*     */   }
/*     */   
/*     */   public boolean cb() {
/* 451 */     return (getHealth() <= getMaxHealth() / 2.0F);
/*     */   }
/*     */   
/*     */   public EnumMonsterType getMonsterType() {
/* 455 */     return EnumMonsterType.UNDEAD;
/*     */   }
/*     */   
/*     */   public void mount(Entity entity) {
/* 459 */     this.vehicle = null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityWither.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */