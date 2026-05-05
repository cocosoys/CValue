/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.projectiles.ProjectileSource;
/*     */ 
/*     */ public abstract class EntityFireball
/*     */   extends Entity {
/*   9 */   private int e = -1;
/*  10 */   private int f = -1;
/*  11 */   private int g = -1;
/*     */   private Block h;
/*     */   private boolean i;
/*     */   public EntityLiving shooter;
/*     */   private int at;
/*     */   private int au;
/*     */   public double dirX;
/*     */   public double dirY;
/*     */   public double dirZ;
/*  20 */   public float bukkitYield = 1.0F;
/*     */   public boolean isIncendiary = true;
/*     */   
/*     */   public EntityFireball(World world) {
/*  24 */     super(world);
/*  25 */     a(1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void c() {}
/*     */   
/*     */   public EntityFireball(World world, double d0, double d1, double d2, double d3, double d4, double d5) {
/*  31 */     super(world);
/*  32 */     a(1.0F, 1.0F);
/*  33 */     setPositionRotation(d0, d1, d2, this.yaw, this.pitch);
/*  34 */     setPosition(d0, d1, d2);
/*  35 */     double d6 = MathHelper.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
/*     */     
/*  37 */     this.dirX = d3 / d6 * 0.1D;
/*  38 */     this.dirY = d4 / d6 * 0.1D;
/*  39 */     this.dirZ = d5 / d6 * 0.1D;
/*     */   }
/*     */   
/*     */   public EntityFireball(World world, EntityLiving entityliving, double d0, double d1, double d2) {
/*  43 */     super(world);
/*  44 */     this.shooter = entityliving;
/*  45 */     this.projectileSource = (ProjectileSource)entityliving.getBukkitEntity();
/*  46 */     a(1.0F, 1.0F);
/*  47 */     setPositionRotation(entityliving.locX, entityliving.locY, entityliving.locZ, entityliving.yaw, entityliving.pitch);
/*  48 */     setPosition(this.locX, this.locY, this.locZ);
/*  49 */     this.height = 0.0F;
/*  50 */     this.motX = this.motY = this.motZ = 0.0D;
/*     */     
/*  52 */     setDirection(d0, d1, d2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDirection(double d0, double d1, double d2) {
/*  57 */     d0 += this.random.nextGaussian() * 0.4D;
/*  58 */     d1 += this.random.nextGaussian() * 0.4D;
/*  59 */     d2 += this.random.nextGaussian() * 0.4D;
/*  60 */     double d3 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
/*     */     
/*  62 */     this.dirX = d0 / d3 * 0.1D;
/*  63 */     this.dirY = d1 / d3 * 0.1D;
/*  64 */     this.dirZ = d2 / d3 * 0.1D;
/*     */   }
/*     */   
/*     */   public void h() {
/*  68 */     if (!this.world.isStatic && ((this.shooter != null && this.shooter.dead) || !this.world.isLoaded((int)this.locX, (int)this.locY, (int)this.locZ))) {
/*  69 */       die();
/*     */     } else {
/*  71 */       super.h();
/*  72 */       setOnFire(1);
/*  73 */       if (this.i) {
/*  74 */         if (this.world.getType(this.e, this.f, this.g) == this.h) {
/*  75 */           this.at++;
/*  76 */           if (this.at == 600) {
/*  77 */             die();
/*     */           }
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/*  83 */         this.i = false;
/*  84 */         this.motX *= (this.random.nextFloat() * 0.2F);
/*  85 */         this.motY *= (this.random.nextFloat() * 0.2F);
/*  86 */         this.motZ *= (this.random.nextFloat() * 0.2F);
/*  87 */         this.at = 0;
/*  88 */         this.au = 0;
/*     */       } else {
/*  90 */         this.au++;
/*     */       } 
/*     */       
/*  93 */       Vec3D vec3d = Vec3D.a(this.locX, this.locY, this.locZ);
/*  94 */       Vec3D vec3d1 = Vec3D.a(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
/*  95 */       MovingObjectPosition movingobjectposition = this.world.a(vec3d, vec3d1);
/*     */       
/*  97 */       vec3d = Vec3D.a(this.locX, this.locY, this.locZ);
/*  98 */       vec3d1 = Vec3D.a(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
/*  99 */       if (movingobjectposition != null) {
/* 100 */         vec3d1 = Vec3D.a(movingobjectposition.pos.a, movingobjectposition.pos.b, movingobjectposition.pos.c);
/*     */       }
/*     */       
/* 103 */       Entity entity = null;
/* 104 */       List<Entity> list = this.world.getEntities(this, this.boundingBox.a(this.motX, this.motY, this.motZ).grow(1.0D, 1.0D, 1.0D));
/* 105 */       double d0 = 0.0D;
/*     */       
/* 107 */       for (int i = 0; i < list.size(); i++) {
/* 108 */         Entity entity1 = list.get(i);
/*     */         
/* 110 */         if (entity1.R() && (!entity1.i(this.shooter) || this.au >= 25)) {
/* 111 */           float f = 0.3F;
/* 112 */           AxisAlignedBB axisalignedbb = entity1.boundingBox.grow(f, f, f);
/* 113 */           MovingObjectPosition movingobjectposition1 = axisalignedbb.a(vec3d, vec3d1);
/*     */           
/* 115 */           if (movingobjectposition1 != null) {
/* 116 */             double d1 = vec3d.distanceSquared(movingobjectposition1.pos);
/*     */             
/* 118 */             if (d1 < d0 || d0 == 0.0D) {
/* 119 */               entity = entity1;
/* 120 */               d0 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 126 */       if (entity != null) {
/* 127 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 130 */       if (movingobjectposition != null) {
/* 131 */         a(movingobjectposition);
/*     */ 
/*     */         
/* 134 */         if (this.dead) {
/* 135 */           CraftEventFactory.callProjectileHitEvent(this);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 140 */       this.locX += this.motX;
/* 141 */       this.locY += this.motY;
/* 142 */       this.locZ += this.motZ;
/* 143 */       float f1 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/*     */       
/* 145 */       this.yaw = (float)(Math.atan2(this.motZ, this.motX) * 180.0D / 3.1415927410125732D) + 90.0F;
/*     */       
/* 147 */       for (this.pitch = (float)(Math.atan2(f1, this.motY) * 180.0D / 3.1415927410125732D) - 90.0F; this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */       
/* 151 */       while (this.pitch - this.lastPitch >= 180.0F) {
/* 152 */         this.lastPitch += 360.0F;
/*     */       }
/*     */       
/* 155 */       while (this.yaw - this.lastYaw < -180.0F) {
/* 156 */         this.lastYaw -= 360.0F;
/*     */       }
/*     */       
/* 159 */       while (this.yaw - this.lastYaw >= 180.0F) {
/* 160 */         this.lastYaw += 360.0F;
/*     */       }
/*     */       
/* 163 */       this.pitch = this.lastPitch + (this.pitch - this.lastPitch) * 0.2F;
/* 164 */       this.yaw = this.lastYaw + (this.yaw - this.lastYaw) * 0.2F;
/* 165 */       float f2 = e();
/*     */       
/* 167 */       if (M()) {
/* 168 */         for (int j = 0; j < 4; j++) {
/* 169 */           float f3 = 0.25F;
/*     */           
/* 171 */           this.world.addParticle("bubble", this.locX - this.motX * f3, this.locY - this.motY * f3, this.locZ - this.motZ * f3, this.motX, this.motY, this.motZ);
/*     */         } 
/*     */         
/* 174 */         f2 = 0.8F;
/*     */       } 
/*     */       
/* 177 */       this.motX += this.dirX;
/* 178 */       this.motY += this.dirY;
/* 179 */       this.motZ += this.dirZ;
/* 180 */       this.motX *= f2;
/* 181 */       this.motY *= f2;
/* 182 */       this.motZ *= f2;
/* 183 */       this.world.addParticle("smoke", this.locX, this.locY + 0.5D, this.locZ, 0.0D, 0.0D, 0.0D);
/* 184 */       setPosition(this.locX, this.locY, this.locZ);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected float e() {
/* 189 */     return 0.95F;
/*     */   }
/*     */   
/*     */   protected abstract void a(MovingObjectPosition paramMovingObjectPosition);
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/* 195 */     nbttagcompound.setShort("xTile", (short)this.e);
/* 196 */     nbttagcompound.setShort("yTile", (short)this.f);
/* 197 */     nbttagcompound.setShort("zTile", (short)this.g);
/* 198 */     nbttagcompound.setByte("inTile", (byte)Block.getId(this.h));
/* 199 */     nbttagcompound.setByte("inGround", (byte)(this.i ? 1 : 0));
/*     */     
/* 201 */     nbttagcompound.set("power", a(new double[] { this.dirX, this.dirY, this.dirZ }));
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 205 */     this.e = nbttagcompound.getShort("xTile");
/* 206 */     this.f = nbttagcompound.getShort("yTile");
/* 207 */     this.g = nbttagcompound.getShort("zTile");
/* 208 */     this.h = Block.getById(nbttagcompound.getByte("inTile") & 0xFF);
/* 209 */     this.i = (nbttagcompound.getByte("inGround") == 1);
/*     */     
/* 211 */     if (nbttagcompound.hasKeyOfType("power", 9)) {
/* 212 */       NBTTagList nbttaglist = nbttagcompound.getList("power", 6);
/*     */       
/* 214 */       this.dirX = nbttaglist.d(0);
/* 215 */       this.dirY = nbttaglist.d(1);
/* 216 */       this.dirZ = nbttaglist.d(2);
/*     */     } else {
/*     */       
/* 219 */       die();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean R() {
/* 224 */     return true;
/*     */   }
/*     */   
/*     */   public float af() {
/* 228 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 232 */     if (isInvulnerable()) {
/* 233 */       return false;
/*     */     }
/* 235 */     Q();
/* 236 */     if (damagesource.getEntity() != null) {
/*     */       
/* 238 */       if (CraftEventFactory.handleNonLivingEntityDamageEvent(this, damagesource, f)) {
/* 239 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 243 */       Vec3D vec3d = damagesource.getEntity().ag();
/*     */       
/* 245 */       if (vec3d != null) {
/* 246 */         this.motX = vec3d.a;
/* 247 */         this.motY = vec3d.b;
/* 248 */         this.motZ = vec3d.c;
/* 249 */         this.dirX = this.motX * 0.1D;
/* 250 */         this.dirY = this.motY * 0.1D;
/* 251 */         this.dirZ = this.motZ * 0.1D;
/*     */       } 
/*     */       
/* 254 */       if (damagesource.getEntity() instanceof EntityLiving) {
/* 255 */         this.shooter = (EntityLiving)damagesource.getEntity();
/* 256 */         this.projectileSource = (ProjectileSource)this.shooter.getBukkitEntity();
/*     */       } 
/*     */       
/* 259 */       return true;
/*     */     } 
/* 261 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float d(float f) {
/* 267 */     return 1.0F;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityFireball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */