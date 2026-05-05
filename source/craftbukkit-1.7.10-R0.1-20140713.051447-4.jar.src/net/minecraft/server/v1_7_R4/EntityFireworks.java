/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ public class EntityFireworks
/*     */   extends Entity {
/*     */   private int ticksFlown;
/*     */   public int expectedLifespan;
/*     */   
/*     */   public EntityFireworks(World world) {
/*   9 */     super(world);
/*  10 */     a(0.25F, 0.25F);
/*     */   }
/*     */   
/*     */   protected void c() {
/*  14 */     this.datawatcher.add(8, 5);
/*     */   }
/*     */   
/*     */   public EntityFireworks(World world, double d0, double d1, double d2, ItemStack itemstack) {
/*  18 */     super(world);
/*  19 */     this.ticksFlown = 0;
/*  20 */     a(0.25F, 0.25F);
/*  21 */     setPosition(d0, d1, d2);
/*  22 */     this.height = 0.0F;
/*  23 */     int i = 1;
/*     */     
/*  25 */     if (itemstack != null && itemstack.hasTag()) {
/*  26 */       this.datawatcher.watch(8, itemstack);
/*  27 */       NBTTagCompound nbttagcompound = itemstack.getTag();
/*  28 */       NBTTagCompound nbttagcompound1 = nbttagcompound.getCompound("Fireworks");
/*     */       
/*  30 */       if (nbttagcompound1 != null) {
/*  31 */         i += nbttagcompound1.getByte("Flight");
/*     */       }
/*     */     } 
/*     */     
/*  35 */     this.motX = this.random.nextGaussian() * 0.001D;
/*  36 */     this.motZ = this.random.nextGaussian() * 0.001D;
/*  37 */     this.motY = 0.05D;
/*  38 */     this.expectedLifespan = 10 * i + this.random.nextInt(6) + this.random.nextInt(7);
/*     */   }
/*     */   
/*     */   public void h() {
/*  42 */     this.S = this.locX;
/*  43 */     this.T = this.locY;
/*  44 */     this.U = this.locZ;
/*  45 */     super.h();
/*  46 */     this.motX *= 1.15D;
/*  47 */     this.motZ *= 1.15D;
/*  48 */     this.motY += 0.04D;
/*  49 */     move(this.motX, this.motY, this.motZ);
/*  50 */     float f = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
/*     */     
/*  52 */     this.yaw = (float)(Math.atan2(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);
/*     */     
/*  54 */     for (this.pitch = (float)(Math.atan2(this.motY, f) * 180.0D / 3.1415927410125732D); this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F);
/*     */ 
/*     */ 
/*     */     
/*  58 */     while (this.pitch - this.lastPitch >= 180.0F) {
/*  59 */       this.lastPitch += 360.0F;
/*     */     }
/*     */     
/*  62 */     while (this.yaw - this.lastYaw < -180.0F) {
/*  63 */       this.lastYaw -= 360.0F;
/*     */     }
/*     */     
/*  66 */     while (this.yaw - this.lastYaw >= 180.0F) {
/*  67 */       this.lastYaw += 360.0F;
/*     */     }
/*     */     
/*  70 */     this.pitch = this.lastPitch + (this.pitch - this.lastPitch) * 0.2F;
/*  71 */     this.yaw = this.lastYaw + (this.yaw - this.lastYaw) * 0.2F;
/*  72 */     if (this.ticksFlown == 0) {
/*  73 */       this.world.makeSound(this, "fireworks.launch", 3.0F, 1.0F);
/*     */     }
/*     */     
/*  76 */     this.ticksFlown++;
/*  77 */     if (this.world.isStatic && this.ticksFlown % 2 < 2) {
/*  78 */       this.world.addParticle("fireworksSpark", this.locX, this.locY - 0.3D, this.locZ, this.random.nextGaussian() * 0.05D, -this.motY * 0.5D, this.random.nextGaussian() * 0.05D);
/*     */     }
/*     */     
/*  81 */     if (!this.world.isStatic && this.ticksFlown > this.expectedLifespan) {
/*  82 */       this.world.broadcastEntityEffect(this, (byte)17);
/*  83 */       die();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/*  88 */     nbttagcompound.setInt("Life", this.ticksFlown);
/*  89 */     nbttagcompound.setInt("LifeTime", this.expectedLifespan);
/*  90 */     ItemStack itemstack = this.datawatcher.getItemStack(8);
/*     */     
/*  92 */     if (itemstack != null) {
/*  93 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*     */       
/*  95 */       itemstack.save(nbttagcompound1);
/*  96 */       nbttagcompound.set("FireworksItem", nbttagcompound1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 101 */     this.ticksFlown = nbttagcompound.getInt("Life");
/* 102 */     this.expectedLifespan = nbttagcompound.getInt("LifeTime");
/* 103 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompound("FireworksItem");
/*     */     
/* 105 */     if (nbttagcompound1 != null) {
/* 106 */       ItemStack itemstack = ItemStack.createStack(nbttagcompound1);
/*     */       
/* 108 */       if (itemstack != null) {
/* 109 */         this.datawatcher.watch(8, itemstack);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public float d(float f) {
/* 115 */     return super.d(f);
/*     */   }
/*     */   
/*     */   public boolean au() {
/* 119 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityFireworks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */