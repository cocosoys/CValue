/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.UUID;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.entity.EntityTeleportEvent;
/*     */ 
/*     */ public class EntityEnderman extends EntityMonster {
/*  13 */   private static final UUID bp = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
/*  14 */   private static final AttributeModifier bq = (new AttributeModifier(bp, "Attacking speed boost", 6.199999809265137D, 0)).a(false);
/*  15 */   private static boolean[] br = new boolean[256];
/*     */   private int bs;
/*     */   private int bt;
/*     */   private Entity bu;
/*     */   private boolean bv;
/*     */   
/*     */   public EntityEnderman(World world) {
/*  22 */     super(world);
/*  23 */     a(0.6F, 2.9F);
/*  24 */     this.W = 1.0F;
/*     */   }
/*     */   
/*     */   protected void aD() {
/*  28 */     super.aD();
/*  29 */     getAttributeInstance(GenericAttributes.maxHealth).setValue(40.0D);
/*  30 */     getAttributeInstance(GenericAttributes.d).setValue(0.30000001192092896D);
/*  31 */     getAttributeInstance(GenericAttributes.e).setValue(7.0D);
/*     */   }
/*     */   
/*     */   protected void c() {
/*  35 */     super.c();
/*  36 */     this.datawatcher.a(16, new Byte((byte)0));
/*  37 */     this.datawatcher.a(17, new Byte((byte)0));
/*  38 */     this.datawatcher.a(18, new Byte((byte)0));
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/*  42 */     super.b(nbttagcompound);
/*  43 */     nbttagcompound.setShort("carried", (short)Block.getId(getCarried()));
/*  44 */     nbttagcompound.setShort("carriedData", (short)getCarriedData());
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/*  48 */     super.a(nbttagcompound);
/*  49 */     setCarried(Block.getById(nbttagcompound.getShort("carried")));
/*  50 */     setCarriedData(nbttagcompound.getShort("carriedData"));
/*     */   }
/*     */   
/*     */   protected Entity findTarget() {
/*  54 */     EntityHuman entityhuman = this.world.findNearbyVulnerablePlayer(this, 64.0D);
/*     */     
/*  56 */     if (entityhuman != null) {
/*  57 */       if (f(entityhuman)) {
/*  58 */         this.bv = true;
/*  59 */         if (this.bt == 0) {
/*  60 */           this.world.makeSound(entityhuman.locX, entityhuman.locY, entityhuman.locZ, "mob.endermen.stare", 1.0F, 1.0F);
/*     */         }
/*     */         
/*  63 */         if (this.bt++ == 5) {
/*  64 */           this.bt = 0;
/*  65 */           a(true);
/*  66 */           return entityhuman;
/*     */         } 
/*     */       } else {
/*  69 */         this.bt = 0;
/*     */       } 
/*     */     }
/*     */     
/*  73 */     return null;
/*     */   }
/*     */   
/*     */   private boolean f(EntityHuman entityhuman) {
/*  77 */     ItemStack itemstack = entityhuman.inventory.armor[3];
/*     */     
/*  79 */     if (itemstack != null && itemstack.getItem() == Item.getItemOf(Blocks.PUMPKIN)) {
/*  80 */       return false;
/*     */     }
/*  82 */     Vec3D vec3d = entityhuman.j(1.0F).a();
/*  83 */     Vec3D vec3d1 = Vec3D.a(this.locX - entityhuman.locX, this.boundingBox.b + (this.length / 2.0F) - entityhuman.locY + entityhuman.getHeadHeight(), this.locZ - entityhuman.locZ);
/*  84 */     double d0 = vec3d1.b();
/*     */     
/*  86 */     vec3d1 = vec3d1.a();
/*  87 */     double d1 = vec3d.b(vec3d1);
/*     */     
/*  89 */     return (d1 > 1.0D - 0.025D / d0 && entityhuman.hasLineOfSight(this));
/*     */   }
/*     */ 
/*     */   
/*     */   public void e() {
/*  94 */     if (L()) {
/*  95 */       damageEntity(DamageSource.DROWN, 1.0F);
/*     */     }
/*     */     
/*  98 */     if (this.bu != this.target) {
/*  99 */       AttributeInstance attributeinstance = getAttributeInstance(GenericAttributes.d);
/*     */       
/* 101 */       attributeinstance.b(bq);
/* 102 */       if (this.target != null) {
/* 103 */         attributeinstance.a(bq);
/*     */       }
/*     */     } 
/*     */     
/* 107 */     this.bu = this.target;
/*     */ 
/*     */     
/* 110 */     if (!this.world.isStatic && this.world.getGameRules().getBoolean("mobGriefing"))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 115 */       if (getCarried().getMaterial() == Material.AIR) {
/* 116 */         if (this.random.nextInt(20) == 0) {
/* 117 */           int m = MathHelper.floor(this.locX - 2.0D + this.random.nextDouble() * 4.0D);
/* 118 */           int j = MathHelper.floor(this.locY + this.random.nextDouble() * 3.0D);
/* 119 */           int k = MathHelper.floor(this.locZ - 2.0D + this.random.nextDouble() * 4.0D);
/* 120 */           Block block = this.world.getType(m, j, k);
/* 121 */           if (br[Block.getId(block)])
/*     */           {
/* 123 */             if (!CraftEventFactory.callEntityChangeBlockEvent(this, this.world.getWorld().getBlockAt(m, j, k), Material.AIR).isCancelled()) {
/* 124 */               setCarried(block);
/* 125 */               setCarriedData(this.world.getData(m, j, k));
/* 126 */               this.world.setTypeUpdate(m, j, k, Blocks.AIR);
/*     */             }
/*     */           
/*     */           }
/*     */         } 
/* 131 */       } else if (this.random.nextInt(2000) == 0) {
/* 132 */         int m = MathHelper.floor(this.locX - 1.0D + this.random.nextDouble() * 2.0D);
/* 133 */         int j = MathHelper.floor(this.locY + this.random.nextDouble() * 2.0D);
/* 134 */         int k = MathHelper.floor(this.locZ - 1.0D + this.random.nextDouble() * 2.0D);
/* 135 */         Block block = this.world.getType(m, j, k);
/* 136 */         Block block1 = this.world.getType(m, j - 1, k);
/*     */         
/* 138 */         if (block.getMaterial() == Material.AIR && block1.getMaterial() != Material.AIR && block1.d())
/*     */         {
/* 140 */           if (!CraftEventFactory.callEntityChangeBlockEvent(this, m, j, k, getCarried(), getCarriedData()).isCancelled()) {
/* 141 */             this.world.setTypeAndData(m, j, k, getCarried(), getCarriedData(), 3);
/* 142 */             setCarried(Blocks.AIR);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 149 */     for (int i = 0; i < 2; i++) {
/* 150 */       this.world.addParticle("portal", this.locX + (this.random.nextDouble() - 0.5D) * this.width, this.locY + this.random.nextDouble() * this.length - 0.25D, this.locZ + (this.random.nextDouble() - 0.5D) * this.width, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
/*     */     }
/*     */     
/* 153 */     if (this.world.w() && !this.world.isStatic) {
/* 154 */       float f = d(1.0F);
/*     */       
/* 156 */       if (f > 0.5F && this.world.i(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ)) && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
/* 157 */         this.target = null;
/* 158 */         a(false);
/* 159 */         this.bv = false;
/* 160 */         bZ();
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     if (L() || isBurning()) {
/* 165 */       this.target = null;
/* 166 */       a(false);
/* 167 */       this.bv = false;
/* 168 */       bZ();
/*     */     } 
/*     */     
/* 171 */     if (cd() && !this.bv && this.random.nextInt(100) == 0) {
/* 172 */       a(false);
/*     */     }
/*     */     
/* 175 */     this.bc = false;
/* 176 */     if (this.target != null) {
/* 177 */       a(this.target, 100.0F, 100.0F);
/*     */     }
/*     */     
/* 180 */     if (!this.world.isStatic && isAlive()) {
/* 181 */       if (this.target != null) {
/* 182 */         if (this.target instanceof EntityHuman && f((EntityHuman)this.target)) {
/* 183 */           if (this.target.f(this) < 16.0D) {
/* 184 */             bZ();
/*     */           }
/*     */           
/* 187 */           this.bs = 0;
/* 188 */         } else if (this.target.f(this) > 256.0D && this.bs++ >= 30 && c(this.target)) {
/* 189 */           this.bs = 0;
/*     */         } 
/*     */       } else {
/* 192 */         a(false);
/* 193 */         this.bs = 0;
/*     */       } 
/*     */     }
/*     */     
/* 197 */     super.e();
/*     */   }
/*     */   
/*     */   protected boolean bZ() {
/* 201 */     double d0 = this.locX + (this.random.nextDouble() - 0.5D) * 64.0D;
/* 202 */     double d1 = this.locY + (this.random.nextInt(64) - 32);
/* 203 */     double d2 = this.locZ + (this.random.nextDouble() - 0.5D) * 64.0D;
/*     */     
/* 205 */     return k(d0, d1, d2);
/*     */   }
/*     */   
/*     */   protected boolean c(Entity entity) {
/* 209 */     Vec3D vec3d = Vec3D.a(this.locX - entity.locX, this.boundingBox.b + (this.length / 2.0F) - entity.locY + entity.getHeadHeight(), this.locZ - entity.locZ);
/*     */     
/* 211 */     vec3d = vec3d.a();
/* 212 */     double d0 = 16.0D;
/* 213 */     double d1 = this.locX + (this.random.nextDouble() - 0.5D) * 8.0D - vec3d.a * d0;
/* 214 */     double d2 = this.locY + (this.random.nextInt(16) - 8) - vec3d.b * d0;
/* 215 */     double d3 = this.locZ + (this.random.nextDouble() - 0.5D) * 8.0D - vec3d.c * d0;
/*     */     
/* 217 */     return k(d1, d2, d3);
/*     */   }
/*     */   
/*     */   protected boolean k(double d0, double d1, double d2) {
/* 221 */     double d3 = this.locX;
/* 222 */     double d4 = this.locY;
/* 223 */     double d5 = this.locZ;
/*     */     
/* 225 */     this.locX = d0;
/* 226 */     this.locY = d1;
/* 227 */     this.locZ = d2;
/* 228 */     boolean flag = false;
/* 229 */     int i = MathHelper.floor(this.locX);
/* 230 */     int j = MathHelper.floor(this.locY);
/* 231 */     int k = MathHelper.floor(this.locZ);
/*     */     
/* 233 */     if (this.world.isLoaded(i, j, k)) {
/* 234 */       boolean flag1 = false;
/*     */       
/* 236 */       while (!flag1 && j > 0) {
/* 237 */         Block block = this.world.getType(i, j - 1, k);
/*     */         
/* 239 */         if (block.getMaterial().isSolid()) {
/* 240 */           flag1 = true; continue;
/*     */         } 
/* 242 */         this.locY--;
/* 243 */         j--;
/*     */       } 
/*     */ 
/*     */       
/* 247 */       if (flag1) {
/*     */         
/* 249 */         EntityTeleportEvent teleport = new EntityTeleportEvent((Entity)getBukkitEntity(), new Location((World)this.world.getWorld(), d3, d4, d5), new Location((World)this.world.getWorld(), this.locX, this.locY, this.locZ));
/* 250 */         this.world.getServer().getPluginManager().callEvent((Event)teleport);
/* 251 */         if (teleport.isCancelled()) {
/* 252 */           return false;
/*     */         }
/*     */         
/* 255 */         Location to = teleport.getTo();
/* 256 */         setPosition(to.getX(), to.getY(), to.getZ());
/*     */ 
/*     */         
/* 259 */         if (this.world.getCubes(this, this.boundingBox).isEmpty() && !this.world.containsLiquid(this.boundingBox)) {
/* 260 */           flag = true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 265 */     if (!flag) {
/* 266 */       setPosition(d3, d4, d5);
/* 267 */       return false;
/*     */     } 
/* 269 */     short short1 = 128;
/*     */     
/* 271 */     for (int l = 0; l < short1; l++) {
/* 272 */       double d6 = l / (short1 - 1.0D);
/* 273 */       float f = (this.random.nextFloat() - 0.5F) * 0.2F;
/* 274 */       float f1 = (this.random.nextFloat() - 0.5F) * 0.2F;
/* 275 */       float f2 = (this.random.nextFloat() - 0.5F) * 0.2F;
/* 276 */       double d7 = d3 + (this.locX - d3) * d6 + (this.random.nextDouble() - 0.5D) * this.width * 2.0D;
/* 277 */       double d8 = d4 + (this.locY - d4) * d6 + this.random.nextDouble() * this.length;
/* 278 */       double d9 = d5 + (this.locZ - d5) * d6 + (this.random.nextDouble() - 0.5D) * this.width * 2.0D;
/*     */       
/* 280 */       this.world.addParticle("portal", d7, d8, d9, f, f1, f2);
/*     */     } 
/*     */     
/* 283 */     this.world.makeSound(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
/* 284 */     makeSound("mob.endermen.portal", 1.0F, 1.0F);
/* 285 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String t() {
/* 290 */     return cd() ? "mob.endermen.scream" : "mob.endermen.idle";
/*     */   }
/*     */   
/*     */   protected String aT() {
/* 294 */     return "mob.endermen.hit";
/*     */   }
/*     */   
/*     */   protected String aU() {
/* 298 */     return "mob.endermen.death";
/*     */   }
/*     */   
/*     */   protected Item getLoot() {
/* 302 */     return Items.ENDER_PEARL;
/*     */   }
/*     */   
/*     */   protected void dropDeathLoot(boolean flag, int i) {
/* 306 */     Item item = getLoot();
/*     */     
/* 308 */     if (item != null) {
/* 309 */       int j = this.random.nextInt(2 + i);
/*     */       
/* 311 */       for (int k = 0; k < j; k++) {
/* 312 */         a(item, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCarried(Block block) {
/* 318 */     this.datawatcher.watch(16, Byte.valueOf((byte)(Block.getId(block) & 0xFF)));
/*     */   }
/*     */   
/*     */   public Block getCarried() {
/* 322 */     return Block.getById(this.datawatcher.getByte(16));
/*     */   }
/*     */   
/*     */   public void setCarriedData(int i) {
/* 326 */     this.datawatcher.watch(17, Byte.valueOf((byte)(i & 0xFF)));
/*     */   }
/*     */   
/*     */   public int getCarriedData() {
/* 330 */     return this.datawatcher.getByte(17);
/*     */   }
/*     */   
/*     */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 334 */     if (isInvulnerable()) {
/* 335 */       return false;
/*     */     }
/* 337 */     a(true);
/* 338 */     if (damagesource instanceof EntityDamageSource && damagesource.getEntity() instanceof EntityHuman) {
/* 339 */       this.bv = true;
/*     */     }
/*     */     
/* 342 */     if (damagesource instanceof EntityDamageSourceIndirect) {
/* 343 */       this.bv = false;
/*     */       
/* 345 */       for (int i = 0; i < 64; i++) {
/* 346 */         if (bZ()) {
/* 347 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 351 */       return false;
/*     */     } 
/* 353 */     return super.damageEntity(damagesource, f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean cd() {
/* 359 */     return (this.datawatcher.getByte(18) > 0);
/*     */   }
/*     */   
/*     */   public void a(boolean flag) {
/* 363 */     this.datawatcher.watch(18, Byte.valueOf((byte)(flag ? 1 : 0)));
/*     */   }
/*     */   
/*     */   static {
/* 367 */     br[Block.getId(Blocks.GRASS)] = true;
/* 368 */     br[Block.getId(Blocks.DIRT)] = true;
/* 369 */     br[Block.getId(Blocks.SAND)] = true;
/* 370 */     br[Block.getId(Blocks.GRAVEL)] = true;
/* 371 */     br[Block.getId(Blocks.YELLOW_FLOWER)] = true;
/* 372 */     br[Block.getId(Blocks.RED_ROSE)] = true;
/* 373 */     br[Block.getId(Blocks.BROWN_MUSHROOM)] = true;
/* 374 */     br[Block.getId(Blocks.RED_MUSHROOM)] = true;
/* 375 */     br[Block.getId(Blocks.TNT)] = true;
/* 376 */     br[Block.getId(Blocks.CACTUS)] = true;
/* 377 */     br[Block.getId(Blocks.CLAY)] = true;
/* 378 */     br[Block.getId(Blocks.PUMPKIN)] = true;
/* 379 */     br[Block.getId(Blocks.MELON)] = true;
/* 380 */     br[Block.getId(Blocks.MYCEL)] = true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityEnderman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */