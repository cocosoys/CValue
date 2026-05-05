/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.entity.EntityUnleashEvent;
/*     */ 
/*     */ 
/*     */ public abstract class EntityInsentient
/*     */   extends EntityLiving
/*     */ {
/*     */   public int a_;
/*     */   protected int b;
/*     */   private ControllerLook lookController;
/*     */   private ControllerMove moveController;
/*     */   private ControllerJump bm;
/*     */   private EntityAIBodyControl bn;
/*     */   private Navigation navigation;
/*     */   protected final PathfinderGoalSelector goalSelector;
/*     */   protected final PathfinderGoalSelector targetSelector;
/*     */   private EntityLiving goalTarget;
/*     */   private EntitySenses bq;
/*  26 */   private ItemStack[] equipment = new ItemStack[5];
/*  27 */   public float[] dropChances = new float[5];
/*     */   public boolean canPickUpLoot;
/*  29 */   public boolean persistent = !isTypeNotPersistent();
/*     */   protected float f;
/*     */   private Entity bu;
/*     */   protected int g;
/*     */   private boolean bv;
/*     */   private Entity bw;
/*     */   private NBTTagCompound bx;
/*     */   
/*     */   public EntityInsentient(World world) {
/*  38 */     super(world);
/*  39 */     this.goalSelector = new PathfinderGoalSelector((world != null && world.methodProfiler != null) ? world.methodProfiler : null);
/*  40 */     this.targetSelector = new PathfinderGoalSelector((world != null && world.methodProfiler != null) ? world.methodProfiler : null);
/*  41 */     this.lookController = new ControllerLook(this);
/*  42 */     this.moveController = new ControllerMove(this);
/*  43 */     this.bm = new ControllerJump(this);
/*  44 */     this.bn = new EntityAIBodyControl(this);
/*  45 */     this.navigation = new Navigation(this, world);
/*  46 */     this.bq = new EntitySenses(this);
/*     */     
/*  48 */     for (int i = 0; i < this.dropChances.length; i++) {
/*  49 */       this.dropChances[i] = 0.085F;
/*     */     }
/*     */   }
/*     */   
/*     */   protected void aD() {
/*  54 */     super.aD();
/*  55 */     getAttributeMap().b(GenericAttributes.b).setValue(16.0D);
/*     */   }
/*     */   
/*     */   public ControllerLook getControllerLook() {
/*  59 */     return this.lookController;
/*     */   }
/*     */   
/*     */   public ControllerMove getControllerMove() {
/*  63 */     return this.moveController;
/*     */   }
/*     */   
/*     */   public ControllerJump getControllerJump() {
/*  67 */     return this.bm;
/*     */   }
/*     */   
/*     */   public Navigation getNavigation() {
/*  71 */     return this.navigation;
/*     */   }
/*     */   
/*     */   public EntitySenses getEntitySenses() {
/*  75 */     return this.bq;
/*     */   }
/*     */   
/*     */   public EntityLiving getGoalTarget() {
/*  79 */     return this.goalTarget;
/*     */   }
/*     */   
/*     */   public void setGoalTarget(EntityLiving entityliving) {
/*  83 */     this.goalTarget = entityliving;
/*     */   }
/*     */   
/*     */   public boolean a(Class<EntityCreeper> oclass) {
/*  87 */     return (EntityCreeper.class != oclass && EntityGhast.class != oclass);
/*     */   }
/*     */   
/*     */   public void p() {}
/*     */   
/*     */   protected void c() {
/*  93 */     super.c();
/*  94 */     this.datawatcher.a(11, Byte.valueOf((byte)0));
/*  95 */     this.datawatcher.a(10, "");
/*     */   }
/*     */   
/*     */   public int q() {
/*  99 */     return 80;
/*     */   }
/*     */   
/*     */   public void r() {
/* 103 */     String s = t();
/*     */     
/* 105 */     if (s != null) {
/* 106 */       makeSound(s, bf(), bg());
/*     */     }
/*     */   }
/*     */   
/*     */   public void C() {
/* 111 */     super.C();
/* 112 */     this.world.methodProfiler.a("mobBaseTick");
/* 113 */     if (isAlive() && this.random.nextInt(1000) < this.a_++) {
/* 114 */       this.a_ = -q();
/* 115 */       r();
/*     */     } 
/*     */     
/* 118 */     this.world.methodProfiler.b();
/*     */   }
/*     */   
/*     */   protected int getExpValue(EntityHuman entityhuman) {
/* 122 */     if (this.b > 0) {
/* 123 */       int i = this.b;
/* 124 */       ItemStack[] aitemstack = getEquipment();
/*     */       
/* 126 */       for (int j = 0; j < aitemstack.length; j++) {
/* 127 */         if (aitemstack[j] != null && this.dropChances[j] <= 1.0F) {
/* 128 */           i += 1 + this.random.nextInt(3);
/*     */         }
/*     */       } 
/*     */       
/* 132 */       return i;
/*     */     } 
/* 134 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void s() {
/* 139 */     for (int i = 0; i < 20; i++) {
/* 140 */       double d0 = this.random.nextGaussian() * 0.02D;
/* 141 */       double d1 = this.random.nextGaussian() * 0.02D;
/* 142 */       double d2 = this.random.nextGaussian() * 0.02D;
/* 143 */       double d3 = 10.0D;
/*     */       
/* 145 */       this.world.addParticle("explode", this.locX + (this.random.nextFloat() * this.width * 2.0F) - this.width - d0 * d3, this.locY + (this.random.nextFloat() * this.length) - d1 * d3, this.locZ + (this.random.nextFloat() * this.width * 2.0F) - this.width - d2 * d3, d0, d1, d2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void h() {
/* 150 */     super.h();
/* 151 */     if (!this.world.isStatic) {
/* 152 */       bL();
/*     */     }
/*     */   }
/*     */   
/*     */   protected float f(float f, float f1) {
/* 157 */     if (bk()) {
/* 158 */       this.bn.a();
/* 159 */       return f1;
/*     */     } 
/* 161 */     return super.f(f, f1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String t() {
/* 166 */     return null;
/*     */   }
/*     */   
/*     */   protected Item getLoot() {
/* 170 */     return Item.getById(0);
/*     */   }
/*     */   
/*     */   protected void dropDeathLoot(boolean flag, int i) {
/* 174 */     Item item = getLoot();
/*     */     
/* 176 */     if (item != null) {
/* 177 */       int j = this.random.nextInt(3);
/*     */       
/* 179 */       if (i > 0) {
/* 180 */         j += this.random.nextInt(i + 1);
/*     */       }
/*     */       
/* 183 */       for (int k = 0; k < j; k++) {
/* 184 */         a(item, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/* 190 */     super.b(nbttagcompound);
/* 191 */     nbttagcompound.setBoolean("CanPickUpLoot", bJ());
/* 192 */     nbttagcompound.setBoolean("PersistenceRequired", this.persistent);
/* 193 */     NBTTagList nbttaglist = new NBTTagList();
/*     */ 
/*     */ 
/*     */     
/* 197 */     for (int i = 0; i < this.equipment.length; i++) {
/* 198 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 199 */       if (this.equipment[i] != null) {
/* 200 */         this.equipment[i].save(nbttagcompound1);
/*     */       }
/*     */       
/* 203 */       nbttaglist.add(nbttagcompound1);
/*     */     } 
/*     */     
/* 206 */     nbttagcompound.set("Equipment", nbttaglist);
/* 207 */     NBTTagList nbttaglist1 = new NBTTagList();
/*     */     
/* 209 */     for (int j = 0; j < this.dropChances.length; j++) {
/* 210 */       nbttaglist1.add(new NBTTagFloat(this.dropChances[j]));
/*     */     }
/*     */     
/* 213 */     nbttagcompound.set("DropChances", nbttaglist1);
/* 214 */     nbttagcompound.setString("CustomName", getCustomName());
/* 215 */     nbttagcompound.setBoolean("CustomNameVisible", getCustomNameVisible());
/* 216 */     nbttagcompound.setBoolean("Leashed", this.bv);
/* 217 */     if (this.bw != null) {
/* 218 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 219 */       if (this.bw instanceof EntityLiving) {
/* 220 */         nbttagcompound1.setLong("UUIDMost", this.bw.getUniqueID().getMostSignificantBits());
/* 221 */         nbttagcompound1.setLong("UUIDLeast", this.bw.getUniqueID().getLeastSignificantBits());
/* 222 */       } else if (this.bw instanceof EntityHanging) {
/* 223 */         EntityHanging entityhanging = (EntityHanging)this.bw;
/*     */         
/* 225 */         nbttagcompound1.setInt("X", entityhanging.x);
/* 226 */         nbttagcompound1.setInt("Y", entityhanging.y);
/* 227 */         nbttagcompound1.setInt("Z", entityhanging.z);
/*     */       } 
/*     */       
/* 230 */       nbttagcompound.set("Leash", nbttagcompound1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 235 */     super.a(nbttagcompound);
/*     */ 
/*     */     
/* 238 */     boolean data = nbttagcompound.getBoolean("CanPickUpLoot");
/* 239 */     if (isLevelAtLeast(nbttagcompound, 1) || data) {
/* 240 */       this.canPickUpLoot = data;
/*     */     }
/*     */     
/* 243 */     data = nbttagcompound.getBoolean("PersistenceRequired");
/* 244 */     if (isLevelAtLeast(nbttagcompound, 1) || data) {
/* 245 */       this.persistent = data;
/*     */     }
/*     */ 
/*     */     
/* 249 */     if (nbttagcompound.hasKeyOfType("CustomName", 8) && nbttagcompound.getString("CustomName").length() > 0) {
/* 250 */       setCustomName(nbttagcompound.getString("CustomName"));
/*     */     }
/*     */     
/* 253 */     setCustomNameVisible(nbttagcompound.getBoolean("CustomNameVisible"));
/*     */ 
/*     */ 
/*     */     
/* 257 */     if (nbttagcompound.hasKeyOfType("Equipment", 9)) {
/* 258 */       NBTTagList nbttaglist = nbttagcompound.getList("Equipment", 10);
/*     */       
/* 260 */       for (int i = 0; i < this.equipment.length; i++) {
/* 261 */         this.equipment[i] = ItemStack.createStack(nbttaglist.get(i));
/*     */       }
/*     */     } 
/*     */     
/* 265 */     if (nbttagcompound.hasKeyOfType("DropChances", 9)) {
/* 266 */       NBTTagList nbttaglist = nbttagcompound.getList("DropChances", 5);
/*     */       
/* 268 */       for (int i = 0; i < nbttaglist.size(); i++) {
/* 269 */         this.dropChances[i] = nbttaglist.e(i);
/*     */       }
/*     */     } 
/*     */     
/* 273 */     this.bv = nbttagcompound.getBoolean("Leashed");
/* 274 */     if (this.bv && nbttagcompound.hasKeyOfType("Leash", 10)) {
/* 275 */       this.bx = nbttagcompound.getCompound("Leash");
/*     */     }
/*     */   }
/*     */   
/*     */   public void n(float f) {
/* 280 */     this.be = f;
/*     */   }
/*     */   
/*     */   public void i(float f) {
/* 284 */     super.i(f);
/* 285 */     n(f);
/*     */   }
/*     */   
/*     */   public void e() {
/* 289 */     super.e();
/* 290 */     this.world.methodProfiler.a("looting");
/* 291 */     if (!this.world.isStatic && bJ() && !this.aT && this.world.getGameRules().getBoolean("mobGriefing")) {
/* 292 */       List list = this.world.a(EntityItem.class, this.boundingBox.grow(1.0D, 0.0D, 1.0D));
/* 293 */       Iterator<EntityItem> iterator = list.iterator();
/*     */       
/* 295 */       while (iterator.hasNext()) {
/* 296 */         EntityItem entityitem = iterator.next();
/*     */         
/* 298 */         if (!entityitem.dead && entityitem.getItemStack() != null) {
/* 299 */           ItemStack itemstack = entityitem.getItemStack();
/* 300 */           int i = b(itemstack);
/*     */           
/* 302 */           if (i > -1) {
/* 303 */             boolean flag = true;
/* 304 */             ItemStack itemstack1 = getEquipment(i);
/*     */             
/* 306 */             if (itemstack1 != null) {
/* 307 */               if (i == 0) {
/* 308 */                 if (itemstack.getItem() instanceof ItemSword && !(itemstack1.getItem() instanceof ItemSword)) {
/* 309 */                   flag = true;
/* 310 */                 } else if (itemstack.getItem() instanceof ItemSword && itemstack1.getItem() instanceof ItemSword) {
/* 311 */                   ItemSword itemsword = (ItemSword)itemstack.getItem();
/* 312 */                   ItemSword itemsword1 = (ItemSword)itemstack1.getItem();
/*     */                   
/* 314 */                   if (itemsword.i() == itemsword1.i()) {
/* 315 */                     flag = (itemstack.getData() > itemstack1.getData() || (itemstack.hasTag() && !itemstack1.hasTag()));
/*     */                   } else {
/* 317 */                     flag = (itemsword.i() > itemsword1.i());
/*     */                   } 
/*     */                 } else {
/* 320 */                   flag = false;
/*     */                 } 
/* 322 */               } else if (itemstack.getItem() instanceof ItemArmor && !(itemstack1.getItem() instanceof ItemArmor)) {
/* 323 */                 flag = true;
/* 324 */               } else if (itemstack.getItem() instanceof ItemArmor && itemstack1.getItem() instanceof ItemArmor) {
/* 325 */                 ItemArmor itemarmor = (ItemArmor)itemstack.getItem();
/* 326 */                 ItemArmor itemarmor1 = (ItemArmor)itemstack1.getItem();
/*     */                 
/* 328 */                 if (itemarmor.c == itemarmor1.c) {
/* 329 */                   flag = (itemstack.getData() > itemstack1.getData() || (itemstack.hasTag() && !itemstack1.hasTag()));
/*     */                 } else {
/* 331 */                   flag = (itemarmor.c > itemarmor1.c);
/*     */                 } 
/*     */               } else {
/* 334 */                 flag = false;
/*     */               } 
/*     */             }
/*     */             
/* 338 */             if (flag) {
/* 339 */               if (itemstack1 != null && this.random.nextFloat() - 0.1F < this.dropChances[i]) {
/* 340 */                 a(itemstack1, 0.0F);
/*     */               }
/*     */               
/* 343 */               if (itemstack.getItem() == Items.DIAMOND && entityitem.j() != null) {
/* 344 */                 EntityHuman entityhuman = this.world.a(entityitem.j());
/*     */                 
/* 346 */                 if (entityhuman != null) {
/* 347 */                   entityhuman.a(AchievementList.x);
/*     */                 }
/*     */               } 
/*     */               
/* 351 */               setEquipment(i, itemstack);
/* 352 */               this.dropChances[i] = 2.0F;
/* 353 */               this.persistent = true;
/* 354 */               receive(entityitem, 1);
/* 355 */               entityitem.die();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 362 */     this.world.methodProfiler.b();
/*     */   }
/*     */   
/*     */   protected boolean bk() {
/* 366 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean isTypeNotPersistent() {
/* 370 */     return true;
/*     */   }
/*     */   
/*     */   protected void w() {
/* 374 */     if (this.persistent) {
/* 375 */       this.aU = 0;
/*     */     } else {
/* 377 */       EntityHuman entityhuman = this.world.findNearbyPlayer(this, -1.0D);
/*     */       
/* 379 */       if (entityhuman != null) {
/* 380 */         double d0 = entityhuman.locX - this.locX;
/* 381 */         double d1 = entityhuman.locY - this.locY;
/* 382 */         double d2 = entityhuman.locZ - this.locZ;
/* 383 */         double d3 = d0 * d0 + d1 * d1 + d2 * d2;
/*     */         
/* 385 */         if (d3 > 16384.0D) {
/* 386 */           die();
/*     */         }
/*     */         
/* 389 */         if (this.aU > 600 && this.random.nextInt(800) == 0 && d3 > 1024.0D) {
/* 390 */           die();
/* 391 */         } else if (d3 < 1024.0D) {
/* 392 */           this.aU = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void bn() {
/* 399 */     this.aU++;
/* 400 */     this.world.methodProfiler.a("checkDespawn");
/* 401 */     w();
/* 402 */     this.world.methodProfiler.b();
/* 403 */     this.world.methodProfiler.a("sensing");
/* 404 */     this.bq.a();
/* 405 */     this.world.methodProfiler.b();
/* 406 */     this.world.methodProfiler.a("targetSelector");
/* 407 */     this.targetSelector.a();
/* 408 */     this.world.methodProfiler.b();
/* 409 */     this.world.methodProfiler.a("goalSelector");
/* 410 */     this.goalSelector.a();
/* 411 */     this.world.methodProfiler.b();
/* 412 */     this.world.methodProfiler.a("navigation");
/* 413 */     this.navigation.f();
/* 414 */     this.world.methodProfiler.b();
/* 415 */     this.world.methodProfiler.a("mob tick");
/* 416 */     bp();
/* 417 */     this.world.methodProfiler.b();
/* 418 */     this.world.methodProfiler.a("controls");
/* 419 */     this.world.methodProfiler.a("move");
/* 420 */     this.moveController.c();
/* 421 */     this.world.methodProfiler.c("look");
/* 422 */     this.lookController.a();
/* 423 */     this.world.methodProfiler.c("jump");
/* 424 */     this.bm.b();
/* 425 */     this.world.methodProfiler.b();
/* 426 */     this.world.methodProfiler.b();
/*     */   }
/*     */   
/*     */   protected void bq() {
/* 430 */     super.bq();
/* 431 */     this.bd = 0.0F;
/* 432 */     this.be = 0.0F;
/* 433 */     w();
/* 434 */     float f = 8.0F;
/*     */     
/* 436 */     if (this.random.nextFloat() < 0.02F) {
/* 437 */       EntityHuman entityhuman = this.world.findNearbyPlayer(this, f);
/*     */       
/* 439 */       if (entityhuman != null) {
/* 440 */         this.bu = entityhuman;
/* 441 */         this.g = 10 + this.random.nextInt(20);
/*     */       } else {
/* 443 */         this.bf = (this.random.nextFloat() - 0.5F) * 20.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 447 */     if (this.bu != null) {
/* 448 */       a(this.bu, 10.0F, x());
/* 449 */       if (this.g-- <= 0 || this.bu.dead || this.bu.f(this) > (f * f)) {
/* 450 */         this.bu = null;
/*     */       }
/*     */     } else {
/* 453 */       if (this.random.nextFloat() < 0.05F) {
/* 454 */         this.bf = (this.random.nextFloat() - 0.5F) * 20.0F;
/*     */       }
/*     */       
/* 457 */       this.yaw += this.bf;
/* 458 */       this.pitch = this.f;
/*     */     } 
/*     */     
/* 461 */     boolean flag = M();
/* 462 */     boolean flag1 = P();
/*     */     
/* 464 */     if (flag || flag1) {
/* 465 */       this.bc = (this.random.nextFloat() < 0.8F);
/*     */     }
/*     */   }
/*     */   
/*     */   public int x() {
/* 470 */     return 40;
/*     */   }
/*     */   
/*     */   public void a(Entity entity, float f, float f1) {
/* 474 */     double d2, d0 = entity.locX - this.locX;
/* 475 */     double d1 = entity.locZ - this.locZ;
/*     */ 
/*     */     
/* 478 */     if (entity instanceof EntityLiving) {
/* 479 */       EntityLiving entityliving = (EntityLiving)entity;
/*     */       
/* 481 */       d2 = entityliving.locY + entityliving.getHeadHeight() - this.locY + getHeadHeight();
/*     */     } else {
/* 483 */       d2 = (entity.boundingBox.b + entity.boundingBox.e) / 2.0D - this.locY + getHeadHeight();
/*     */     } 
/*     */     
/* 486 */     double d3 = MathHelper.sqrt(d0 * d0 + d1 * d1);
/* 487 */     float f2 = (float)(Math.atan2(d1, d0) * 180.0D / 3.1415927410125732D) - 90.0F;
/* 488 */     float f3 = (float)-(Math.atan2(d2, d3) * 180.0D / 3.1415927410125732D);
/*     */     
/* 490 */     this.pitch = b(this.pitch, f3, f1);
/* 491 */     this.yaw = b(this.yaw, f2, f);
/*     */   }
/*     */   
/*     */   private float b(float f, float f1, float f2) {
/* 495 */     float f3 = MathHelper.g(f1 - f);
/*     */     
/* 497 */     if (f3 > f2) {
/* 498 */       f3 = f2;
/*     */     }
/*     */     
/* 501 */     if (f3 < -f2) {
/* 502 */       f3 = -f2;
/*     */     }
/*     */     
/* 505 */     return f + f3;
/*     */   }
/*     */   
/*     */   public boolean canSpawn() {
/* 509 */     return (this.world.b(this.boundingBox) && this.world.getCubes(this, this.boundingBox).isEmpty() && !this.world.containsLiquid(this.boundingBox));
/*     */   }
/*     */   
/*     */   public int bB() {
/* 513 */     return 4;
/*     */   }
/*     */   
/*     */   public int ax() {
/* 517 */     if (getGoalTarget() == null) {
/* 518 */       return 3;
/*     */     }
/* 520 */     int i = (int)(getHealth() - getMaxHealth() * 0.33F);
/*     */     
/* 522 */     i -= (3 - this.world.difficulty.a()) * 4;
/* 523 */     if (i < 0) {
/* 524 */       i = 0;
/*     */     }
/*     */     
/* 527 */     return i + 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack be() {
/* 532 */     return this.equipment[0];
/*     */   }
/*     */   
/*     */   public ItemStack getEquipment(int i) {
/* 536 */     return this.equipment[i];
/*     */   }
/*     */   
/*     */   public ItemStack r(int i) {
/* 540 */     return this.equipment[i + 1];
/*     */   }
/*     */   
/*     */   public void setEquipment(int i, ItemStack itemstack) {
/* 544 */     this.equipment[i] = itemstack;
/*     */   }
/*     */   
/*     */   public ItemStack[] getEquipment() {
/* 548 */     return this.equipment;
/*     */   }
/*     */   
/*     */   protected void dropEquipment(boolean flag, int i) {
/* 552 */     for (int j = 0; j < (getEquipment()).length; j++) {
/* 553 */       ItemStack itemstack = getEquipment(j);
/* 554 */       boolean flag1 = (this.dropChances[j] > 1.0F);
/*     */       
/* 556 */       if (itemstack != null && (flag || flag1) && this.random.nextFloat() - i * 0.01F < this.dropChances[j]) {
/* 557 */         if (!flag1 && itemstack.g()) {
/* 558 */           int k = Math.max(itemstack.l() - 25, 1);
/* 559 */           int l = itemstack.l() - this.random.nextInt(this.random.nextInt(k) + 1);
/*     */           
/* 561 */           if (l > k) {
/* 562 */             l = k;
/*     */           }
/*     */           
/* 565 */           if (l < 1) {
/* 566 */             l = 1;
/*     */           }
/*     */           
/* 569 */           itemstack.setData(l);
/*     */         } 
/*     */         
/* 572 */         a(itemstack, 0.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void bC() {
/* 578 */     if (this.random.nextFloat() < 0.15F * this.world.b(this.locX, this.locY, this.locZ)) {
/* 579 */       int i = this.random.nextInt(2);
/* 580 */       float f = (this.world.difficulty == EnumDifficulty.HARD) ? 0.1F : 0.25F;
/*     */       
/* 582 */       if (this.random.nextFloat() < 0.095F) {
/* 583 */         i++;
/*     */       }
/*     */       
/* 586 */       if (this.random.nextFloat() < 0.095F) {
/* 587 */         i++;
/*     */       }
/*     */       
/* 590 */       if (this.random.nextFloat() < 0.095F) {
/* 591 */         i++;
/*     */       }
/*     */       
/* 594 */       for (int j = 3; j >= 0; j--) {
/* 595 */         ItemStack itemstack = r(j);
/*     */         
/* 597 */         if (j < 3 && this.random.nextFloat() < f) {
/*     */           break;
/*     */         }
/*     */         
/* 601 */         if (itemstack == null) {
/* 602 */           Item item = a(j + 1, i);
/*     */           
/* 604 */           if (item != null) {
/* 605 */             setEquipment(j + 1, new ItemStack(item));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int b(ItemStack itemstack) {
/* 613 */     if (itemstack.getItem() != Item.getItemOf(Blocks.PUMPKIN) && itemstack.getItem() != Items.SKULL) {
/* 614 */       if (itemstack.getItem() instanceof ItemArmor) {
/* 615 */         switch (((ItemArmor)itemstack.getItem()).b) {
/*     */           case 0:
/* 617 */             return 4;
/*     */           
/*     */           case 1:
/* 620 */             return 3;
/*     */           
/*     */           case 2:
/* 623 */             return 2;
/*     */           
/*     */           case 3:
/* 626 */             return 1;
/*     */         } 
/*     */       
/*     */       }
/* 630 */       return 0;
/*     */     } 
/* 632 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Item a(int i, int j) {
/* 637 */     switch (i) {
/*     */       case 4:
/* 639 */         if (j == 0)
/* 640 */           return Items.LEATHER_HELMET; 
/* 641 */         if (j == 1)
/* 642 */           return Items.GOLD_HELMET; 
/* 643 */         if (j == 2)
/* 644 */           return Items.CHAINMAIL_HELMET; 
/* 645 */         if (j == 3)
/* 646 */           return Items.IRON_HELMET; 
/* 647 */         if (j == 4) {
/* 648 */           return Items.DIAMOND_HELMET;
/*     */         }
/*     */       
/*     */       case 3:
/* 652 */         if (j == 0)
/* 653 */           return Items.LEATHER_CHESTPLATE; 
/* 654 */         if (j == 1)
/* 655 */           return Items.GOLD_CHESTPLATE; 
/* 656 */         if (j == 2)
/* 657 */           return Items.CHAINMAIL_CHESTPLATE; 
/* 658 */         if (j == 3)
/* 659 */           return Items.IRON_CHESTPLATE; 
/* 660 */         if (j == 4) {
/* 661 */           return Items.DIAMOND_CHESTPLATE;
/*     */         }
/*     */       
/*     */       case 2:
/* 665 */         if (j == 0)
/* 666 */           return Items.LEATHER_LEGGINGS; 
/* 667 */         if (j == 1)
/* 668 */           return Items.GOLD_LEGGINGS; 
/* 669 */         if (j == 2)
/* 670 */           return Items.CHAINMAIL_LEGGINGS; 
/* 671 */         if (j == 3)
/* 672 */           return Items.IRON_LEGGINGS; 
/* 673 */         if (j == 4) {
/* 674 */           return Items.DIAMOND_LEGGINGS;
/*     */         }
/*     */       
/*     */       case 1:
/* 678 */         if (j == 0)
/* 679 */           return Items.LEATHER_BOOTS; 
/* 680 */         if (j == 1)
/* 681 */           return Items.GOLD_BOOTS; 
/* 682 */         if (j == 2)
/* 683 */           return Items.CHAINMAIL_BOOTS; 
/* 684 */         if (j == 3)
/* 685 */           return Items.IRON_BOOTS; 
/* 686 */         if (j == 4) {
/* 687 */           return Items.DIAMOND_BOOTS;
/*     */         }
/*     */         break;
/*     */     } 
/* 691 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void bD() {
/* 696 */     float f = this.world.b(this.locX, this.locY, this.locZ);
/*     */     
/* 698 */     if (be() != null && this.random.nextFloat() < 0.25F * f) {
/* 699 */       EnchantmentManager.a(this.random, be(), (int)(5.0F + f * this.random.nextInt(18)));
/*     */     }
/*     */     
/* 702 */     for (int i = 0; i < 4; i++) {
/* 703 */       ItemStack itemstack = r(i);
/*     */       
/* 705 */       if (itemstack != null && this.random.nextFloat() < 0.5F * f) {
/* 706 */         EnchantmentManager.a(this.random, itemstack, (int)(5.0F + f * this.random.nextInt(18)));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public GroupDataEntity prepare(GroupDataEntity groupdataentity) {
/* 712 */     getAttributeInstance(GenericAttributes.b).a(new AttributeModifier("Random spawn bonus", this.random.nextGaussian() * 0.05D, 1));
/* 713 */     return groupdataentity;
/*     */   }
/*     */   
/*     */   public boolean bE() {
/* 717 */     return false;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 721 */     return hasCustomName() ? getCustomName() : super.getName();
/*     */   }
/*     */   
/*     */   public void bF() {
/* 725 */     this.persistent = true;
/*     */   }
/*     */   
/*     */   public void setCustomName(String s) {
/* 729 */     this.datawatcher.watch(10, s);
/*     */   }
/*     */   
/*     */   public String getCustomName() {
/* 733 */     return this.datawatcher.getString(10);
/*     */   }
/*     */   
/*     */   public boolean hasCustomName() {
/* 737 */     return (this.datawatcher.getString(10).length() > 0);
/*     */   }
/*     */   
/*     */   public void setCustomNameVisible(boolean flag) {
/* 741 */     this.datawatcher.watch(11, Byte.valueOf((byte)(flag ? 1 : 0)));
/*     */   }
/*     */   
/*     */   public boolean getCustomNameVisible() {
/* 745 */     return (this.datawatcher.getByte(11) == 1);
/*     */   }
/*     */   
/*     */   public void a(int i, float f) {
/* 749 */     this.dropChances[i] = f;
/*     */   }
/*     */   
/*     */   public boolean bJ() {
/* 753 */     return this.canPickUpLoot;
/*     */   }
/*     */   
/*     */   public void h(boolean flag) {
/* 757 */     this.canPickUpLoot = flag;
/*     */   }
/*     */   
/*     */   public boolean isPersistent() {
/* 761 */     return this.persistent;
/*     */   }
/*     */   
/*     */   public final boolean c(EntityHuman entityhuman) {
/* 765 */     if (bN() && getLeashHolder() == entityhuman) {
/*     */       
/* 767 */       if (CraftEventFactory.callPlayerUnleashEntityEvent(this, entityhuman).isCancelled()) {
/* 768 */         ((EntityPlayer)entityhuman).playerConnection.sendPacket(new PacketPlayOutAttachEntity(1, this, getLeashHolder()));
/* 769 */         return false;
/*     */       } 
/*     */       
/* 772 */       unleash(true, !entityhuman.abilities.canInstantlyBuild);
/* 773 */       return true;
/*     */     } 
/* 775 */     ItemStack itemstack = entityhuman.inventory.getItemInHand();
/*     */     
/* 777 */     if (itemstack != null && itemstack.getItem() == Items.LEASH && bM()) {
/* 778 */       if (!(this instanceof EntityTameableAnimal) || !((EntityTameableAnimal)this).isTamed()) {
/*     */         
/* 780 */         if (CraftEventFactory.callPlayerLeashEntityEvent(this, entityhuman, entityhuman).isCancelled()) {
/* 781 */           ((EntityPlayer)entityhuman).playerConnection.sendPacket(new PacketPlayOutAttachEntity(1, this, getLeashHolder()));
/* 782 */           return false;
/*     */         } 
/*     */         
/* 785 */         setLeashHolder(entityhuman, true);
/* 786 */         itemstack.count--;
/* 787 */         return true;
/*     */       } 
/*     */       
/* 790 */       if (((EntityTameableAnimal)this).e(entityhuman)) {
/*     */         
/* 792 */         if (CraftEventFactory.callPlayerLeashEntityEvent(this, entityhuman, entityhuman).isCancelled()) {
/* 793 */           ((EntityPlayer)entityhuman).playerConnection.sendPacket(new PacketPlayOutAttachEntity(1, this, getLeashHolder()));
/* 794 */           return false;
/*     */         } 
/*     */         
/* 797 */         setLeashHolder(entityhuman, true);
/* 798 */         itemstack.count--;
/* 799 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 803 */     return a(entityhuman) ? true : super.c(entityhuman);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(EntityHuman entityhuman) {
/* 808 */     return false;
/*     */   }
/*     */   
/*     */   protected void bL() {
/* 812 */     if (this.bx != null) {
/* 813 */       bP();
/*     */     }
/*     */     
/* 816 */     if (this.bv && (
/* 817 */       this.bw == null || this.bw.dead)) {
/* 818 */       this.world.getServer().getPluginManager().callEvent((Event)new EntityUnleashEvent((Entity)getBukkitEntity(), EntityUnleashEvent.UnleashReason.HOLDER_GONE));
/* 819 */       unleash(true, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void unleash(boolean flag, boolean flag1) {
/* 825 */     if (this.bv) {
/* 826 */       this.bv = false;
/* 827 */       this.bw = null;
/* 828 */       if (!this.world.isStatic && flag1) {
/* 829 */         a(Items.LEASH, 1);
/*     */       }
/*     */       
/* 832 */       if (!this.world.isStatic && flag && this.world instanceof WorldServer) {
/* 833 */         ((WorldServer)this.world).getTracker().a(this, new PacketPlayOutAttachEntity(1, this, (Entity)null));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean bM() {
/* 839 */     return (!bN() && !(this instanceof IMonster));
/*     */   }
/*     */   
/*     */   public boolean bN() {
/* 843 */     return this.bv;
/*     */   }
/*     */   
/*     */   public Entity getLeashHolder() {
/* 847 */     return this.bw;
/*     */   }
/*     */   
/*     */   public void setLeashHolder(Entity entity, boolean flag) {
/* 851 */     this.bv = true;
/* 852 */     this.bw = entity;
/* 853 */     if (!this.world.isStatic && flag && this.world instanceof WorldServer) {
/* 854 */       ((WorldServer)this.world).getTracker().a(this, new PacketPlayOutAttachEntity(1, this, this.bw));
/*     */     }
/*     */   }
/*     */   
/*     */   private void bP() {
/* 859 */     if (this.bv && this.bx != null) {
/* 860 */       if (this.bx.hasKeyOfType("UUIDMost", 4) && this.bx.hasKeyOfType("UUIDLeast", 4)) {
/* 861 */         UUID uuid = new UUID(this.bx.getLong("UUIDMost"), this.bx.getLong("UUIDLeast"));
/* 862 */         List list = this.world.a(EntityLiving.class, this.boundingBox.grow(10.0D, 10.0D, 10.0D));
/* 863 */         Iterator<EntityLiving> iterator = list.iterator();
/*     */         
/* 865 */         while (iterator.hasNext()) {
/* 866 */           EntityLiving entityliving = iterator.next();
/*     */           
/* 868 */           if (entityliving.getUniqueID().equals(uuid)) {
/* 869 */             this.bw = entityliving;
/*     */             break;
/*     */           } 
/*     */         } 
/* 873 */       } else if (this.bx.hasKeyOfType("X", 99) && this.bx.hasKeyOfType("Y", 99) && this.bx.hasKeyOfType("Z", 99)) {
/* 874 */         int i = this.bx.getInt("X");
/* 875 */         int j = this.bx.getInt("Y");
/* 876 */         int k = this.bx.getInt("Z");
/* 877 */         EntityLeash entityleash = EntityLeash.b(this.world, i, j, k);
/*     */         
/* 879 */         if (entityleash == null) {
/* 880 */           entityleash = EntityLeash.a(this.world, i, j, k);
/*     */         }
/*     */         
/* 883 */         this.bw = entityleash;
/*     */       } else {
/* 885 */         this.world.getServer().getPluginManager().callEvent((Event)new EntityUnleashEvent((Entity)getBukkitEntity(), EntityUnleashEvent.UnleashReason.UNKNOWN));
/* 886 */         unleash(false, true);
/*     */       } 
/*     */     }
/*     */     
/* 890 */     this.bx = null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityInsentient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */