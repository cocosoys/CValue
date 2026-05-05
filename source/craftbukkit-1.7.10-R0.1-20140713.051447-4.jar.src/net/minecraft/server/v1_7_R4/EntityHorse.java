/*      */ package net.minecraft.server.v1_7_R4;
/*      */ 
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*      */ import org.bukkit.event.entity.EntityRegainHealthEvent;
/*      */ import org.bukkit.event.entity.HorseJumpEvent;
/*      */ 
/*      */ public class EntityHorse extends EntityAnimal implements IInventoryListener {
/*   10 */   private static final IEntitySelector bu = new EntitySelectorHorse();
/*   11 */   public static final IAttribute attributeJumpStrength = (new AttributeRanged("horse.jumpStrength", 0.7D, 0.0D, 2.0D)).a("Jump Strength").a(true);
/*   12 */   private static final String[] bw = new String[] { null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png" };
/*   13 */   private static final String[] bx = new String[] { "", "meo", "goo", "dio" };
/*   14 */   private static final int[] by = new int[] { 0, 5, 7, 11 };
/*   15 */   private static final String[] bz = new String[] { "textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png" };
/*   16 */   private static final String[] bA = new String[] { "hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb" };
/*   17 */   private static final String[] bB = new String[] { null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png" };
/*   18 */   private static final String[] bC = new String[] { "", "wo_", "wmo", "wdo", "bdo" };
/*      */   private int bD;
/*      */   private int bE;
/*      */   private int bF;
/*      */   public int bp;
/*      */   public int bq;
/*      */   protected boolean br;
/*      */   public InventoryHorseChest inventoryChest;
/*      */   private boolean bH;
/*      */   protected int bs;
/*      */   protected float bt;
/*      */   private boolean bI;
/*      */   private float bJ;
/*      */   private float bK;
/*      */   private float bL;
/*      */   private float bM;
/*      */   private float bN;
/*      */   private float bO;
/*      */   private int bP;
/*      */   private String bQ;
/*   38 */   private String[] bR = new String[3];
/*   39 */   public int maxDomestication = 100;
/*      */   
/*      */   public EntityHorse(World world) {
/*   42 */     super(world);
/*   43 */     a(1.4F, 1.6F);
/*   44 */     this.fireProof = false;
/*   45 */     setHasChest(false);
/*   46 */     getNavigation().a(true);
/*   47 */     this.goalSelector.a(0, new PathfinderGoalFloat(this));
/*   48 */     this.goalSelector.a(1, new PathfinderGoalPanic(this, 1.2D));
/*   49 */     this.goalSelector.a(1, new PathfinderGoalTame(this, 1.2D));
/*   50 */     this.goalSelector.a(2, new PathfinderGoalBreed(this, 1.0D));
/*   51 */     this.goalSelector.a(4, new PathfinderGoalFollowParent(this, 1.0D));
/*   52 */     this.goalSelector.a(6, new PathfinderGoalRandomStroll(this, 0.7D));
/*   53 */     this.goalSelector.a(7, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
/*   54 */     this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
/*   55 */     loadChest();
/*      */   }
/*      */   
/*      */   protected void c() {
/*   59 */     super.c();
/*   60 */     this.datawatcher.a(16, Integer.valueOf(0));
/*   61 */     this.datawatcher.a(19, Byte.valueOf((byte)0));
/*   62 */     this.datawatcher.a(20, Integer.valueOf(0));
/*   63 */     this.datawatcher.a(21, String.valueOf(""));
/*   64 */     this.datawatcher.a(22, Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   public void setType(int i) {
/*   68 */     this.datawatcher.watch(19, Byte.valueOf((byte)i));
/*   69 */     cP();
/*      */   }
/*      */   
/*      */   public int getType() {
/*   73 */     return this.datawatcher.getByte(19);
/*      */   }
/*      */   
/*      */   public void setVariant(int i) {
/*   77 */     this.datawatcher.watch(20, Integer.valueOf(i));
/*   78 */     cP();
/*      */   }
/*      */   
/*      */   public int getVariant() {
/*   82 */     return this.datawatcher.getInt(20);
/*      */   }
/*      */   
/*      */   public String getName() {
/*   86 */     if (hasCustomName()) {
/*   87 */       return getCustomName();
/*      */     }
/*   89 */     int i = getType();
/*      */     
/*   91 */     switch (i) {
/*      */       
/*      */       default:
/*   94 */         return LocaleI18n.get("entity.horse.name");
/*      */       
/*      */       case 1:
/*   97 */         return LocaleI18n.get("entity.donkey.name");
/*      */       
/*      */       case 2:
/*  100 */         return LocaleI18n.get("entity.mule.name");
/*      */       
/*      */       case 3:
/*  103 */         return LocaleI18n.get("entity.zombiehorse.name");
/*      */       case 4:
/*      */         break;
/*  106 */     }  return LocaleI18n.get("entity.skeletonhorse.name");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean x(int i) {
/*  112 */     return ((this.datawatcher.getInt(16) & i) != 0);
/*      */   }
/*      */   
/*      */   private void b(int i, boolean flag) {
/*  116 */     int j = this.datawatcher.getInt(16);
/*      */     
/*  118 */     if (flag) {
/*  119 */       this.datawatcher.watch(16, Integer.valueOf(j | i));
/*      */     } else {
/*  121 */       this.datawatcher.watch(16, Integer.valueOf(j & (i ^ 0xFFFFFFFF)));
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean cb() {
/*  126 */     return !isBaby();
/*      */   }
/*      */   
/*      */   public boolean isTame() {
/*  130 */     return x(2);
/*      */   }
/*      */   
/*      */   public boolean cg() {
/*  134 */     return cb();
/*      */   }
/*      */   
/*      */   public String getOwnerUUID() {
/*  138 */     return this.datawatcher.getString(21);
/*      */   }
/*      */   
/*      */   public void setOwnerUUID(String s) {
/*  142 */     this.datawatcher.watch(21, s);
/*      */   }
/*      */   
/*      */   public float ci() {
/*  146 */     int i = getAge();
/*      */     
/*  148 */     return (i >= 0) ? 1.0F : (0.5F + (-24000 - i) / -24000.0F * 0.5F);
/*      */   }
/*      */   
/*      */   public void a(boolean flag) {
/*  152 */     if (flag) {
/*  153 */       a(ci());
/*      */     } else {
/*  155 */       a(1.0F);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean cj() {
/*  160 */     return this.br;
/*      */   }
/*      */   
/*      */   public void setTame(boolean flag) {
/*  164 */     b(2, flag);
/*      */   }
/*      */   
/*      */   public void j(boolean flag) {
/*  168 */     this.br = flag;
/*      */   }
/*      */   
/*      */   public boolean bM() {
/*  172 */     return (!cE() && super.bM());
/*      */   }
/*      */   
/*      */   protected void o(float f) {
/*  176 */     if (f > 6.0F && cm()) {
/*  177 */       o(false);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean hasChest() {
/*  182 */     return x(8);
/*      */   }
/*      */   
/*      */   public int cl() {
/*  186 */     return this.datawatcher.getInt(22);
/*      */   }
/*      */   
/*      */   private int e(ItemStack itemstack) {
/*  190 */     if (itemstack == null) {
/*  191 */       return 0;
/*      */     }
/*  193 */     Item item = itemstack.getItem();
/*      */     
/*  195 */     return (item == Items.HORSE_ARMOR_IRON) ? 1 : ((item == Items.HORSE_ARMOR_GOLD) ? 2 : ((item == Items.HORSE_ARMOR_DIAMOND) ? 3 : 0));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean cm() {
/*  200 */     return x(32);
/*      */   }
/*      */   
/*      */   public boolean cn() {
/*  204 */     return x(64);
/*      */   }
/*      */   
/*      */   public boolean co() {
/*  208 */     return x(16);
/*      */   }
/*      */   
/*      */   public boolean cp() {
/*  212 */     return this.bH;
/*      */   }
/*      */   
/*      */   public void d(ItemStack itemstack) {
/*  216 */     this.datawatcher.watch(22, Integer.valueOf(e(itemstack)));
/*  217 */     cP();
/*      */   }
/*      */   
/*      */   public void k(boolean flag) {
/*  221 */     b(16, flag);
/*      */   }
/*      */   
/*      */   public void setHasChest(boolean flag) {
/*  225 */     b(8, flag);
/*      */   }
/*      */   
/*      */   public void m(boolean flag) {
/*  229 */     this.bH = flag;
/*      */   }
/*      */   
/*      */   public void n(boolean flag) {
/*  233 */     b(4, flag);
/*      */   }
/*      */   
/*      */   public int getTemper() {
/*  237 */     return this.bs;
/*      */   }
/*      */   
/*      */   public void setTemper(int i) {
/*  241 */     this.bs = i;
/*      */   }
/*      */   
/*      */   public int v(int i) {
/*  245 */     int j = MathHelper.a(getTemper() + i, 0, getMaxDomestication());
/*      */     
/*  247 */     setTemper(j);
/*  248 */     return j;
/*      */   }
/*      */   
/*      */   public boolean damageEntity(DamageSource damagesource, float f) {
/*  252 */     Entity entity = damagesource.getEntity();
/*      */     
/*  254 */     return (this.passenger != null && this.passenger.equals(entity)) ? false : super.damageEntity(damagesource, f);
/*      */   }
/*      */   
/*      */   public int aV() {
/*  258 */     return by[cl()];
/*      */   }
/*      */   
/*      */   public boolean S() {
/*  262 */     return (this.passenger == null);
/*      */   }
/*      */   
/*      */   public boolean cr() {
/*  266 */     int i = MathHelper.floor(this.locX);
/*  267 */     int j = MathHelper.floor(this.locZ);
/*      */     
/*  269 */     this.world.getBiome(i, j);
/*  270 */     return true;
/*      */   }
/*      */   
/*      */   public void cs() {
/*  274 */     if (!this.world.isStatic && hasChest()) {
/*  275 */       a(Item.getItemOf(Blocks.CHEST), 1);
/*  276 */       setHasChest(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void cL() {
/*  281 */     cS();
/*  282 */     this.world.makeSound(this, "eating", 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
/*      */   }
/*      */   
/*      */   protected void b(float f) {
/*  286 */     if (f > 1.0F) {
/*  287 */       makeSound("mob.horse.land", 0.4F, 1.0F);
/*      */     }
/*      */     
/*  290 */     int i = MathHelper.f(f * 0.5F - 3.0F);
/*      */     
/*  292 */     if (i > 0) {
/*  293 */       damageEntity(DamageSource.FALL, i);
/*  294 */       if (this.passenger != null) {
/*  295 */         this.passenger.damageEntity(DamageSource.FALL, i);
/*      */       }
/*      */       
/*  298 */       Block block = this.world.getType(MathHelper.floor(this.locX), MathHelper.floor(this.locY - 0.2D - this.lastYaw), MathHelper.floor(this.locZ));
/*      */       
/*  300 */       if (block.getMaterial() != Material.AIR) {
/*  301 */         StepSound stepsound = block.stepSound;
/*      */         
/*  303 */         this.world.makeSound(this, stepsound.getStepSound(), stepsound.getVolume1() * 0.5F, stepsound.getVolume2() * 0.75F);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private int cM() {
/*  309 */     int i = getType();
/*      */     
/*  311 */     return hasChest() ? 17 : 2;
/*      */   }
/*      */   
/*      */   public void loadChest() {
/*  315 */     InventoryHorseChest inventoryhorsechest = this.inventoryChest;
/*      */     
/*  317 */     this.inventoryChest = new InventoryHorseChest("HorseChest", cM(), this);
/*  318 */     this.inventoryChest.a(getName());
/*  319 */     if (inventoryhorsechest != null) {
/*  320 */       inventoryhorsechest.b(this);
/*  321 */       int i = Math.min(inventoryhorsechest.getSize(), this.inventoryChest.getSize());
/*      */       
/*  323 */       for (int j = 0; j < i; j++) {
/*  324 */         ItemStack itemstack = inventoryhorsechest.getItem(j);
/*      */         
/*  326 */         if (itemstack != null) {
/*  327 */           this.inventoryChest.setItem(j, itemstack.cloneItemStack());
/*      */         }
/*      */       } 
/*      */       
/*  331 */       inventoryhorsechest = null;
/*      */     } 
/*      */     
/*  334 */     this.inventoryChest.a(this);
/*  335 */     cO();
/*      */   }
/*      */   
/*      */   private void cO() {
/*  339 */     if (!this.world.isStatic) {
/*  340 */       n((this.inventoryChest.getItem(0) != null));
/*  341 */       if (cB()) {
/*  342 */         d(this.inventoryChest.getItem(1));
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(InventorySubcontainer inventorysubcontainer) {
/*  348 */     int i = cl();
/*  349 */     boolean flag = cu();
/*      */     
/*  351 */     cO();
/*  352 */     if (this.ticksLived > 20) {
/*  353 */       if (i == 0 && i != cl()) {
/*  354 */         makeSound("mob.horse.armor", 0.5F, 1.0F);
/*  355 */       } else if (i != cl()) {
/*  356 */         makeSound("mob.horse.armor", 0.5F, 1.0F);
/*      */       } 
/*      */       
/*  359 */       if (!flag && cu()) {
/*  360 */         makeSound("mob.horse.leather", 0.5F, 1.0F);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean canSpawn() {
/*  366 */     cr();
/*  367 */     return super.canSpawn();
/*      */   }
/*      */   
/*      */   protected EntityHorse a(Entity entity, double d0) {
/*  371 */     double d1 = Double.MAX_VALUE;
/*  372 */     Entity entity1 = null;
/*  373 */     List list = this.world.getEntities(entity, entity.boundingBox.a(d0, d0, d0), bu);
/*  374 */     Iterator<Entity> iterator = list.iterator();
/*      */     
/*  376 */     while (iterator.hasNext()) {
/*  377 */       Entity entity2 = iterator.next();
/*  378 */       double d2 = entity2.e(entity.locX, entity.locY, entity.locZ);
/*      */       
/*  380 */       if (d2 < d1) {
/*  381 */         entity1 = entity2;
/*  382 */         d1 = d2;
/*      */       } 
/*      */     } 
/*      */     
/*  386 */     return (EntityHorse)entity1;
/*      */   }
/*      */   
/*      */   public double getJumpStrength() {
/*  390 */     return getAttributeInstance(attributeJumpStrength).getValue();
/*      */   }
/*      */   
/*      */   protected String aU() {
/*  394 */     cS();
/*  395 */     int i = getType();
/*      */     
/*  397 */     return (i == 3) ? "mob.horse.zombie.death" : ((i == 4) ? "mob.horse.skeleton.death" : ((i != 1 && i != 2) ? "mob.horse.death" : "mob.horse.donkey.death"));
/*      */   }
/*      */   
/*      */   protected Item getLoot() {
/*  401 */     boolean flag = (this.random.nextInt(4) == 0);
/*  402 */     int i = getType();
/*      */     
/*  404 */     return (i == 4) ? Items.BONE : ((i == 3) ? (flag ? Item.getById(0) : Items.ROTTEN_FLESH) : Items.LEATHER);
/*      */   }
/*      */   
/*      */   protected String aT() {
/*  408 */     cS();
/*  409 */     if (this.random.nextInt(3) == 0) {
/*  410 */       cU();
/*      */     }
/*      */     
/*  413 */     int i = getType();
/*      */     
/*  415 */     return (i == 3) ? "mob.horse.zombie.hit" : ((i == 4) ? "mob.horse.skeleton.hit" : ((i != 1 && i != 2) ? "mob.horse.hit" : "mob.horse.donkey.hit"));
/*      */   }
/*      */   
/*      */   public boolean cu() {
/*  419 */     return x(4);
/*      */   }
/*      */   
/*      */   protected String t() {
/*  423 */     cS();
/*  424 */     if (this.random.nextInt(10) == 0 && !bh()) {
/*  425 */       cU();
/*      */     }
/*      */     
/*  428 */     int i = getType();
/*      */     
/*  430 */     return (i == 3) ? "mob.horse.zombie.idle" : ((i == 4) ? "mob.horse.skeleton.idle" : ((i != 1 && i != 2) ? "mob.horse.idle" : "mob.horse.donkey.idle"));
/*      */   }
/*      */   
/*      */   protected String cv() {
/*  434 */     cS();
/*  435 */     cU();
/*  436 */     int i = getType();
/*      */     
/*  438 */     return (i != 3 && i != 4) ? ((i != 1 && i != 2) ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
/*      */   }
/*      */   
/*      */   protected void a(int i, int j, int k, Block block) {
/*  442 */     StepSound stepsound = block.stepSound;
/*      */     
/*  444 */     if (this.world.getType(i, j + 1, k) == Blocks.SNOW) {
/*  445 */       stepsound = Blocks.SNOW.stepSound;
/*      */     }
/*      */     
/*  448 */     if (!block.getMaterial().isLiquid()) {
/*  449 */       int l = getType();
/*      */       
/*  451 */       if (this.passenger != null && l != 1 && l != 2) {
/*  452 */         this.bP++;
/*  453 */         if (this.bP > 5 && this.bP % 3 == 0) {
/*  454 */           makeSound("mob.horse.gallop", stepsound.getVolume1() * 0.15F, stepsound.getVolume2());
/*  455 */           if (l == 0 && this.random.nextInt(10) == 0) {
/*  456 */             makeSound("mob.horse.breathe", stepsound.getVolume1() * 0.6F, stepsound.getVolume2());
/*      */           }
/*  458 */         } else if (this.bP <= 5) {
/*  459 */           makeSound("mob.horse.wood", stepsound.getVolume1() * 0.15F, stepsound.getVolume2());
/*      */         } 
/*  461 */       } else if (stepsound == Block.f) {
/*  462 */         makeSound("mob.horse.wood", stepsound.getVolume1() * 0.15F, stepsound.getVolume2());
/*      */       } else {
/*  464 */         makeSound("mob.horse.soft", stepsound.getVolume1() * 0.15F, stepsound.getVolume2());
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void aD() {
/*  470 */     super.aD();
/*  471 */     getAttributeMap().b(attributeJumpStrength);
/*  472 */     getAttributeInstance(GenericAttributes.maxHealth).setValue(53.0D);
/*  473 */     getAttributeInstance(GenericAttributes.d).setValue(0.22499999403953552D);
/*      */   }
/*      */   
/*      */   public int bB() {
/*  477 */     return 6;
/*      */   }
/*      */   
/*      */   public int getMaxDomestication() {
/*  481 */     return this.maxDomestication;
/*      */   }
/*      */   
/*      */   protected float bf() {
/*  485 */     return 0.8F;
/*      */   }
/*      */   
/*      */   public int q() {
/*  489 */     return 400;
/*      */   }
/*      */   
/*      */   private void cP() {
/*  493 */     this.bQ = null;
/*      */   }
/*      */   
/*      */   public void g(EntityHuman entityhuman) {
/*  497 */     if (!this.world.isStatic && (this.passenger == null || this.passenger == entityhuman) && isTame()) {
/*  498 */       this.inventoryChest.a(getName());
/*  499 */       entityhuman.openHorseInventory(this, this.inventoryChest);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean a(EntityHuman entityhuman) {
/*  504 */     ItemStack itemstack = entityhuman.inventory.getItemInHand();
/*      */     
/*  506 */     if (itemstack != null && itemstack.getItem() == Items.MONSTER_EGG)
/*  507 */       return super.a(entityhuman); 
/*  508 */     if (!isTame() && cE())
/*  509 */       return false; 
/*  510 */     if (isTame() && cb() && entityhuman.isSneaking()) {
/*  511 */       g(entityhuman);
/*  512 */       return true;
/*  513 */     }  if (cg() && this.passenger != null) {
/*  514 */       return super.a(entityhuman);
/*      */     }
/*  516 */     if (itemstack != null) {
/*  517 */       boolean flag = false;
/*      */       
/*  519 */       if (cB()) {
/*  520 */         byte b0 = -1;
/*      */         
/*  522 */         if (itemstack.getItem() == Items.HORSE_ARMOR_IRON) {
/*  523 */           b0 = 1;
/*  524 */         } else if (itemstack.getItem() == Items.HORSE_ARMOR_GOLD) {
/*  525 */           b0 = 2;
/*  526 */         } else if (itemstack.getItem() == Items.HORSE_ARMOR_DIAMOND) {
/*  527 */           b0 = 3;
/*      */         } 
/*      */         
/*  530 */         if (b0 >= 0) {
/*  531 */           if (!isTame()) {
/*  532 */             cJ();
/*  533 */             return true;
/*      */           } 
/*      */           
/*  536 */           g(entityhuman);
/*  537 */           return true;
/*      */         } 
/*      */       } 
/*      */       
/*  541 */       if (!flag && !cE()) {
/*  542 */         float f = 0.0F;
/*  543 */         short short1 = 0;
/*  544 */         byte b1 = 0;
/*      */         
/*  546 */         if (itemstack.getItem() == Items.WHEAT) {
/*  547 */           f = 2.0F;
/*  548 */           short1 = 60;
/*  549 */           b1 = 3;
/*  550 */         } else if (itemstack.getItem() == Items.SUGAR) {
/*  551 */           f = 1.0F;
/*  552 */           short1 = 30;
/*  553 */           b1 = 3;
/*  554 */         } else if (itemstack.getItem() == Items.BREAD) {
/*  555 */           f = 7.0F;
/*  556 */           short1 = 180;
/*  557 */           b1 = 3;
/*  558 */         } else if (Block.a(itemstack.getItem()) == Blocks.HAY_BLOCK) {
/*  559 */           f = 20.0F;
/*  560 */           short1 = 180;
/*  561 */         } else if (itemstack.getItem() == Items.APPLE) {
/*  562 */           f = 3.0F;
/*  563 */           short1 = 60;
/*  564 */           b1 = 3;
/*  565 */         } else if (itemstack.getItem() == Items.CARROT_GOLDEN) {
/*  566 */           f = 4.0F;
/*  567 */           short1 = 60;
/*  568 */           b1 = 5;
/*  569 */           if (isTame() && getAge() == 0) {
/*  570 */             flag = true;
/*  571 */             f(entityhuman);
/*      */           } 
/*  573 */         } else if (itemstack.getItem() == Items.GOLDEN_APPLE) {
/*  574 */           f = 10.0F;
/*  575 */           short1 = 240;
/*  576 */           b1 = 10;
/*  577 */           if (isTame() && getAge() == 0) {
/*  578 */             flag = true;
/*  579 */             f(entityhuman);
/*      */           } 
/*      */         } 
/*      */         
/*  583 */         if (getHealth() < getMaxHealth() && f > 0.0F) {
/*  584 */           heal(f, EntityRegainHealthEvent.RegainReason.EATING);
/*  585 */           flag = true;
/*      */         } 
/*      */         
/*  588 */         if (!cb() && short1 > 0) {
/*  589 */           a(short1);
/*  590 */           flag = true;
/*      */         } 
/*      */         
/*  593 */         if (b1 > 0 && (flag || !isTame()) && b1 < getMaxDomestication()) {
/*  594 */           flag = true;
/*  595 */           v(b1);
/*      */         } 
/*      */         
/*  598 */         if (flag) {
/*  599 */           cL();
/*      */         }
/*      */       } 
/*      */       
/*  603 */       if (!isTame() && !flag) {
/*  604 */         if (itemstack != null && itemstack.a(entityhuman, this)) {
/*  605 */           return true;
/*      */         }
/*      */         
/*  608 */         cJ();
/*  609 */         return true;
/*      */       } 
/*      */       
/*  612 */       if (!flag && cC() && !hasChest() && itemstack.getItem() == Item.getItemOf(Blocks.CHEST)) {
/*  613 */         setHasChest(true);
/*  614 */         makeSound("mob.chickenplop", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
/*  615 */         flag = true;
/*  616 */         loadChest();
/*      */       } 
/*      */       
/*  619 */       if (!flag && cg() && !cu() && itemstack.getItem() == Items.SADDLE) {
/*  620 */         g(entityhuman);
/*  621 */         return true;
/*      */       } 
/*      */       
/*  624 */       if (flag) {
/*  625 */         if (!entityhuman.abilities.canInstantlyBuild && --itemstack.count == 0) {
/*  626 */           entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack)null);
/*      */         }
/*      */         
/*  629 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/*  633 */     if (cg() && this.passenger == null) {
/*  634 */       if (itemstack != null && itemstack.a(entityhuman, this)) {
/*  635 */         return true;
/*      */       }
/*  637 */       i(entityhuman);
/*  638 */       return true;
/*      */     } 
/*      */     
/*  641 */     return super.a(entityhuman);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void i(EntityHuman entityhuman) {
/*  647 */     entityhuman.yaw = this.yaw;
/*  648 */     entityhuman.pitch = this.pitch;
/*  649 */     o(false);
/*  650 */     p(false);
/*  651 */     if (!this.world.isStatic) {
/*  652 */       entityhuman.mount(this);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean cB() {
/*  657 */     return (getType() == 0);
/*      */   }
/*      */   
/*      */   public boolean cC() {
/*  661 */     int i = getType();
/*      */     
/*  663 */     return (i == 2 || i == 1);
/*      */   }
/*      */   
/*      */   protected boolean bh() {
/*  667 */     return (this.passenger != null && cu()) ? true : ((cm() || cn()));
/*      */   }
/*      */   
/*      */   public boolean cE() {
/*  671 */     int i = getType();
/*      */     
/*  673 */     return (i == 3 || i == 4);
/*      */   }
/*      */   
/*      */   public boolean cF() {
/*  677 */     return (cE() || getType() == 2);
/*      */   }
/*      */   
/*      */   public boolean c(ItemStack itemstack) {
/*  681 */     return false;
/*      */   }
/*      */   
/*      */   private void cR() {
/*  685 */     this.bp = 1;
/*      */   }
/*      */   
/*      */   public void die(DamageSource damagesource) {
/*  689 */     super.die(damagesource);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropDeathLoot(boolean flag, int i) {
/*  699 */     super.dropDeathLoot(flag, i);
/*      */ 
/*      */     
/*  702 */     if (!this.world.isStatic) {
/*  703 */       dropChest();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void e() {
/*  709 */     if (this.random.nextInt(200) == 0) {
/*  710 */       cR();
/*      */     }
/*      */     
/*  713 */     super.e();
/*  714 */     if (!this.world.isStatic) {
/*  715 */       if (this.random.nextInt(900) == 0 && this.deathTicks == 0) {
/*  716 */         heal(1.0F, EntityRegainHealthEvent.RegainReason.REGEN);
/*      */       }
/*      */       
/*  719 */       if (!cm() && this.passenger == null && this.random.nextInt(300) == 0 && this.world.getType(MathHelper.floor(this.locX), MathHelper.floor(this.locY) - 1, MathHelper.floor(this.locZ)) == Blocks.GRASS) {
/*  720 */         o(true);
/*      */       }
/*      */       
/*  723 */       if (cm() && ++this.bD > 50) {
/*  724 */         this.bD = 0;
/*  725 */         o(false);
/*      */       } 
/*      */       
/*  728 */       if (co() && !cb() && !cm()) {
/*  729 */         EntityHorse entityhorse = a(this, 16.0D);
/*      */         
/*  731 */         if (entityhorse != null && f(entityhorse) > 4.0D) {
/*  732 */           PathEntity pathentity = this.world.findPath(this, entityhorse, 16.0F, true, false, false, true);
/*      */           
/*  734 */           setPathEntity(pathentity);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void h() {
/*  741 */     super.h();
/*  742 */     if (this.world.isStatic && this.datawatcher.a()) {
/*  743 */       this.datawatcher.e();
/*  744 */       cP();
/*      */     } 
/*      */     
/*  747 */     if (this.bE > 0 && ++this.bE > 30) {
/*  748 */       this.bE = 0;
/*  749 */       b(128, false);
/*      */     } 
/*      */     
/*  752 */     if (!this.world.isStatic && this.bF > 0 && ++this.bF > 20) {
/*  753 */       this.bF = 0;
/*  754 */       p(false);
/*      */     } 
/*      */     
/*  757 */     if (this.bp > 0 && ++this.bp > 8) {
/*  758 */       this.bp = 0;
/*      */     }
/*      */     
/*  761 */     if (this.bq > 0) {
/*  762 */       this.bq++;
/*  763 */       if (this.bq > 300) {
/*  764 */         this.bq = 0;
/*      */       }
/*      */     } 
/*      */     
/*  768 */     this.bK = this.bJ;
/*  769 */     if (cm()) {
/*  770 */       this.bJ += (1.0F - this.bJ) * 0.4F + 0.05F;
/*  771 */       if (this.bJ > 1.0F) {
/*  772 */         this.bJ = 1.0F;
/*      */       }
/*      */     } else {
/*  775 */       this.bJ += (0.0F - this.bJ) * 0.4F - 0.05F;
/*  776 */       if (this.bJ < 0.0F) {
/*  777 */         this.bJ = 0.0F;
/*      */       }
/*      */     } 
/*      */     
/*  781 */     this.bM = this.bL;
/*  782 */     if (cn()) {
/*  783 */       this.bK = this.bJ = 0.0F;
/*  784 */       this.bL += (1.0F - this.bL) * 0.4F + 0.05F;
/*  785 */       if (this.bL > 1.0F) {
/*  786 */         this.bL = 1.0F;
/*      */       }
/*      */     } else {
/*  789 */       this.bI = false;
/*  790 */       this.bL += (0.8F * this.bL * this.bL * this.bL - this.bL) * 0.6F - 0.05F;
/*  791 */       if (this.bL < 0.0F) {
/*  792 */         this.bL = 0.0F;
/*      */       }
/*      */     } 
/*      */     
/*  796 */     this.bO = this.bN;
/*  797 */     if (x(128)) {
/*  798 */       this.bN += (1.0F - this.bN) * 0.7F + 0.05F;
/*  799 */       if (this.bN > 1.0F) {
/*  800 */         this.bN = 1.0F;
/*      */       }
/*      */     } else {
/*  803 */       this.bN += (0.0F - this.bN) * 0.7F - 0.05F;
/*  804 */       if (this.bN < 0.0F) {
/*  805 */         this.bN = 0.0F;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void cS() {
/*  811 */     if (!this.world.isStatic) {
/*  812 */       this.bE = 1;
/*  813 */       b(128, true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean cT() {
/*  818 */     return (this.passenger == null && this.vehicle == null && isTame() && cb() && !cF() && getHealth() >= getMaxHealth());
/*      */   }
/*      */   
/*      */   public void e(boolean flag) {
/*  822 */     b(32, flag);
/*      */   }
/*      */   
/*      */   public void o(boolean flag) {
/*  826 */     e(flag);
/*      */   }
/*      */   
/*      */   public void p(boolean flag) {
/*  830 */     if (flag) {
/*  831 */       o(false);
/*      */     }
/*      */     
/*  834 */     b(64, flag);
/*      */   }
/*      */   
/*      */   private void cU() {
/*  838 */     if (!this.world.isStatic) {
/*  839 */       this.bF = 1;
/*  840 */       p(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cJ() {
/*  845 */     cU();
/*  846 */     String s = cv();
/*      */     
/*  848 */     if (s != null) {
/*  849 */       makeSound(s, bf(), bg());
/*      */     }
/*      */   }
/*      */   
/*      */   public void dropChest() {
/*  854 */     a(this, this.inventoryChest);
/*  855 */     cs();
/*      */   }
/*      */   
/*      */   private void a(Entity entity, InventoryHorseChest inventoryhorsechest) {
/*  859 */     if (inventoryhorsechest != null && !this.world.isStatic) {
/*  860 */       for (int i = 0; i < inventoryhorsechest.getSize(); i++) {
/*  861 */         ItemStack itemstack = inventoryhorsechest.getItem(i);
/*      */         
/*  863 */         if (itemstack != null) {
/*  864 */           a(itemstack, 0.0F);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean h(EntityHuman entityhuman) {
/*  871 */     setOwnerUUID(entityhuman.getUniqueID().toString());
/*  872 */     setTame(true);
/*  873 */     return true;
/*      */   }
/*      */   
/*      */   public void e(float f, float f1) {
/*  877 */     if (this.passenger != null && this.passenger instanceof EntityLiving && cu()) {
/*  878 */       this.lastYaw = this.yaw = this.passenger.yaw;
/*  879 */       this.pitch = this.passenger.pitch * 0.5F;
/*  880 */       b(this.yaw, this.pitch);
/*  881 */       this.aO = this.aM = this.yaw;
/*  882 */       f = ((EntityLiving)this.passenger).bd * 0.5F;
/*  883 */       f1 = ((EntityLiving)this.passenger).be;
/*  884 */       if (f1 <= 0.0F) {
/*  885 */         f1 *= 0.25F;
/*  886 */         this.bP = 0;
/*      */       } 
/*      */       
/*  889 */       if (this.onGround && this.bt == 0.0F && cn() && !this.bI) {
/*  890 */         f = 0.0F;
/*  891 */         f1 = 0.0F;
/*      */       } 
/*      */       
/*  894 */       if (this.bt > 0.0F && !cj() && this.onGround) {
/*  895 */         this.motY = getJumpStrength() * this.bt;
/*  896 */         if (hasEffect(MobEffectList.JUMP)) {
/*  897 */           this.motY += ((getEffect(MobEffectList.JUMP).getAmplifier() + 1) * 0.1F);
/*      */         }
/*      */         
/*  900 */         j(true);
/*  901 */         this.al = true;
/*  902 */         if (f1 > 0.0F) {
/*  903 */           float f2 = MathHelper.sin(this.yaw * 3.1415927F / 180.0F);
/*  904 */           float f3 = MathHelper.cos(this.yaw * 3.1415927F / 180.0F);
/*      */           
/*  906 */           this.motX += (-0.4F * f2 * this.bt);
/*  907 */           this.motZ += (0.4F * f3 * this.bt);
/*  908 */           makeSound("mob.horse.jump", 0.4F, 1.0F);
/*      */         } 
/*      */         
/*  911 */         this.bt = 0.0F;
/*      */       } 
/*      */       
/*  914 */       this.W = 1.0F;
/*  915 */       this.aQ = bl() * 0.1F;
/*  916 */       if (!this.world.isStatic) {
/*  917 */         i((float)getAttributeInstance(GenericAttributes.d).getValue());
/*  918 */         super.e(f, f1);
/*      */       } 
/*      */       
/*  921 */       if (this.onGround) {
/*  922 */         this.bt = 0.0F;
/*  923 */         j(false);
/*      */       } 
/*      */       
/*  926 */       this.aE = this.aF;
/*  927 */       double d0 = this.locX - this.lastX;
/*  928 */       double d1 = this.locZ - this.lastZ;
/*  929 */       float f4 = MathHelper.sqrt(d0 * d0 + d1 * d1) * 4.0F;
/*      */       
/*  931 */       if (f4 > 1.0F) {
/*  932 */         f4 = 1.0F;
/*      */       }
/*      */       
/*  935 */       this.aF += (f4 - this.aF) * 0.4F;
/*  936 */       this.aG += this.aF;
/*      */     } else {
/*  938 */       this.W = 0.5F;
/*  939 */       this.aQ = 0.02F;
/*  940 */       super.e(f, f1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(NBTTagCompound nbttagcompound) {
/*  945 */     super.b(nbttagcompound);
/*  946 */     nbttagcompound.setBoolean("EatingHaystack", cm());
/*  947 */     nbttagcompound.setBoolean("ChestedHorse", hasChest());
/*  948 */     nbttagcompound.setBoolean("HasReproduced", cp());
/*  949 */     nbttagcompound.setBoolean("Bred", co());
/*  950 */     nbttagcompound.setInt("Type", getType());
/*  951 */     nbttagcompound.setInt("Variant", getVariant());
/*  952 */     nbttagcompound.setInt("Temper", getTemper());
/*  953 */     nbttagcompound.setBoolean("Tame", isTame());
/*  954 */     nbttagcompound.setString("OwnerUUID", getOwnerUUID());
/*  955 */     nbttagcompound.setInt("Bukkit.MaxDomestication", this.maxDomestication);
/*  956 */     if (hasChest()) {
/*  957 */       NBTTagList nbttaglist = new NBTTagList();
/*      */       
/*  959 */       for (int i = 2; i < this.inventoryChest.getSize(); i++) {
/*  960 */         ItemStack itemstack = this.inventoryChest.getItem(i);
/*      */         
/*  962 */         if (itemstack != null) {
/*  963 */           NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*      */           
/*  965 */           nbttagcompound1.setByte("Slot", (byte)i);
/*  966 */           itemstack.save(nbttagcompound1);
/*  967 */           nbttaglist.add(nbttagcompound1);
/*      */         } 
/*      */       } 
/*      */       
/*  971 */       nbttagcompound.set("Items", nbttaglist);
/*      */     } 
/*      */     
/*  974 */     if (this.inventoryChest.getItem(1) != null) {
/*  975 */       nbttagcompound.set("ArmorItem", this.inventoryChest.getItem(1).save(new NBTTagCompound()));
/*      */     }
/*      */     
/*  978 */     if (this.inventoryChest.getItem(0) != null) {
/*  979 */       nbttagcompound.set("SaddleItem", this.inventoryChest.getItem(0).save(new NBTTagCompound()));
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(NBTTagCompound nbttagcompound) {
/*  984 */     super.a(nbttagcompound);
/*  985 */     o(nbttagcompound.getBoolean("EatingHaystack"));
/*  986 */     k(nbttagcompound.getBoolean("Bred"));
/*  987 */     setHasChest(nbttagcompound.getBoolean("ChestedHorse"));
/*  988 */     m(nbttagcompound.getBoolean("HasReproduced"));
/*  989 */     setType(nbttagcompound.getInt("Type"));
/*  990 */     setVariant(nbttagcompound.getInt("Variant"));
/*  991 */     setTemper(nbttagcompound.getInt("Temper"));
/*  992 */     setTame(nbttagcompound.getBoolean("Tame"));
/*  993 */     if (nbttagcompound.hasKeyOfType("OwnerUUID", 8)) {
/*  994 */       setOwnerUUID(nbttagcompound.getString("OwnerUUID"));
/*      */     }
/*      */     
/*  997 */     if (nbttagcompound.hasKey("Bukkit.MaxDomestication")) {
/*  998 */       this.maxDomestication = nbttagcompound.getInt("Bukkit.MaxDomestication");
/*      */     }
/*      */     
/* 1001 */     AttributeInstance attributeinstance = getAttributeMap().a("Speed");
/*      */     
/* 1003 */     if (attributeinstance != null) {
/* 1004 */       getAttributeInstance(GenericAttributes.d).setValue(attributeinstance.b() * 0.25D);
/*      */     }
/*      */     
/* 1007 */     if (hasChest()) {
/* 1008 */       NBTTagList nbttaglist = nbttagcompound.getList("Items", 10);
/*      */       
/* 1010 */       loadChest();
/*      */       
/* 1012 */       for (int i = 0; i < nbttaglist.size(); i++) {
/* 1013 */         NBTTagCompound nbttagcompound1 = nbttaglist.get(i);
/* 1014 */         int j = nbttagcompound1.getByte("Slot") & 0xFF;
/*      */         
/* 1016 */         if (j >= 2 && j < this.inventoryChest.getSize()) {
/* 1017 */           this.inventoryChest.setItem(j, ItemStack.createStack(nbttagcompound1));
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1024 */     if (nbttagcompound.hasKeyOfType("ArmorItem", 10)) {
/* 1025 */       ItemStack itemstack = ItemStack.createStack(nbttagcompound.getCompound("ArmorItem"));
/* 1026 */       if (itemstack != null && a(itemstack.getItem())) {
/* 1027 */         this.inventoryChest.setItem(1, itemstack);
/*      */       }
/*      */     } 
/*      */     
/* 1031 */     if (nbttagcompound.hasKeyOfType("SaddleItem", 10)) {
/* 1032 */       ItemStack itemstack = ItemStack.createStack(nbttagcompound.getCompound("SaddleItem"));
/* 1033 */       if (itemstack != null && itemstack.getItem() == Items.SADDLE) {
/* 1034 */         this.inventoryChest.setItem(0, itemstack);
/*      */       }
/* 1036 */     } else if (nbttagcompound.getBoolean("Saddle")) {
/* 1037 */       this.inventoryChest.setItem(0, new ItemStack(Items.SADDLE));
/*      */     } 
/*      */     
/* 1040 */     cO();
/*      */   }
/*      */   
/*      */   public boolean mate(EntityAnimal entityanimal) {
/* 1044 */     if (entityanimal == this)
/* 1045 */       return false; 
/* 1046 */     if (entityanimal.getClass() != getClass()) {
/* 1047 */       return false;
/*      */     }
/* 1049 */     EntityHorse entityhorse = (EntityHorse)entityanimal;
/*      */     
/* 1051 */     if (cT() && entityhorse.cT()) {
/* 1052 */       int i = getType();
/* 1053 */       int j = entityhorse.getType();
/*      */       
/* 1055 */       return (i == j || (i == 0 && j == 1) || (i == 1 && j == 0));
/*      */     } 
/* 1057 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 1063 */     EntityHorse entityhorse = (EntityHorse)entityageable;
/* 1064 */     EntityHorse entityhorse1 = new EntityHorse(this.world);
/* 1065 */     int i = getType();
/* 1066 */     int j = entityhorse.getType();
/* 1067 */     int k = 0;
/*      */     
/* 1069 */     if (i == j) {
/* 1070 */       k = i;
/* 1071 */     } else if ((i == 0 && j == 1) || (i == 1 && j == 0)) {
/* 1072 */       k = 2;
/*      */     } 
/*      */     
/* 1075 */     if (k == 0) {
/* 1076 */       int i1, l = this.random.nextInt(9);
/*      */ 
/*      */       
/* 1079 */       if (l < 4) {
/* 1080 */         i1 = getVariant() & 0xFF;
/* 1081 */       } else if (l < 8) {
/* 1082 */         i1 = entityhorse.getVariant() & 0xFF;
/*      */       } else {
/* 1084 */         i1 = this.random.nextInt(7);
/*      */       } 
/*      */       
/* 1087 */       int j1 = this.random.nextInt(5);
/*      */       
/* 1089 */       if (j1 < 2) {
/* 1090 */         i1 |= getVariant() & 0xFF00;
/* 1091 */       } else if (j1 < 4) {
/* 1092 */         i1 |= entityhorse.getVariant() & 0xFF00;
/*      */       } else {
/* 1094 */         i1 |= this.random.nextInt(5) << 8 & 0xFF00;
/*      */       } 
/*      */       
/* 1097 */       entityhorse1.setVariant(i1);
/*      */     } 
/*      */     
/* 1100 */     entityhorse1.setType(k);
/* 1101 */     double d0 = getAttributeInstance(GenericAttributes.maxHealth).b() + entityageable.getAttributeInstance(GenericAttributes.maxHealth).b() + cV();
/*      */     
/* 1103 */     entityhorse1.getAttributeInstance(GenericAttributes.maxHealth).setValue(d0 / 3.0D);
/* 1104 */     double d1 = getAttributeInstance(attributeJumpStrength).b() + entityageable.getAttributeInstance(attributeJumpStrength).b() + cW();
/*      */     
/* 1106 */     entityhorse1.getAttributeInstance(attributeJumpStrength).setValue(d1 / 3.0D);
/* 1107 */     double d2 = getAttributeInstance(GenericAttributes.d).b() + entityageable.getAttributeInstance(GenericAttributes.d).b() + cX();
/*      */     
/* 1109 */     entityhorse1.getAttributeInstance(GenericAttributes.d).setValue(d2 / 3.0D);
/* 1110 */     return entityhorse1;
/*      */   }
/*      */   public GroupDataEntity prepare(GroupDataEntity groupdataentity) {
/*      */     int j;
/* 1114 */     Object object = super.prepare(groupdataentity);
/* 1115 */     boolean flag = false;
/* 1116 */     int i = 0;
/*      */ 
/*      */     
/* 1119 */     if (object instanceof GroupDataHorse) {
/* 1120 */       j = ((GroupDataHorse)object).a;
/* 1121 */       i = ((GroupDataHorse)object).b & 0xFF | this.random.nextInt(5) << 8;
/*      */     } else {
/* 1123 */       if (this.random.nextInt(10) == 0) {
/* 1124 */         j = 1;
/*      */       } else {
/* 1126 */         int k = this.random.nextInt(7);
/* 1127 */         int l = this.random.nextInt(5);
/*      */         
/* 1129 */         j = 0;
/* 1130 */         i = k | l << 8;
/*      */       } 
/*      */       
/* 1133 */       object = new GroupDataHorse(j, i);
/*      */     } 
/*      */     
/* 1136 */     setType(j);
/* 1137 */     setVariant(i);
/* 1138 */     if (this.random.nextInt(5) == 0) {
/* 1139 */       setAge(-24000);
/*      */     }
/*      */     
/* 1142 */     if (j != 4 && j != 3) {
/* 1143 */       getAttributeInstance(GenericAttributes.maxHealth).setValue(cV());
/* 1144 */       if (j == 0) {
/* 1145 */         getAttributeInstance(GenericAttributes.d).setValue(cX());
/*      */       } else {
/* 1147 */         getAttributeInstance(GenericAttributes.d).setValue(0.17499999701976776D);
/*      */       } 
/*      */     } else {
/* 1150 */       getAttributeInstance(GenericAttributes.maxHealth).setValue(15.0D);
/* 1151 */       getAttributeInstance(GenericAttributes.d).setValue(0.20000000298023224D);
/*      */     } 
/*      */     
/* 1154 */     if (j != 2 && j != 1) {
/* 1155 */       getAttributeInstance(attributeJumpStrength).setValue(cW());
/*      */     } else {
/* 1157 */       getAttributeInstance(attributeJumpStrength).setValue(0.5D);
/*      */     } 
/*      */     
/* 1160 */     setHealth(getMaxHealth());
/* 1161 */     return (GroupDataEntity)object;
/*      */   }
/*      */   
/*      */   protected boolean bk() {
/* 1165 */     return true;
/*      */   }
/*      */   
/*      */   public void w(int i) {
/* 1169 */     if (cu()) {
/*      */       float power;
/* 1171 */       if (i < 0) {
/* 1172 */         i = 0;
/*      */       }
/*      */ 
/*      */       
/* 1176 */       if (i >= 90) {
/* 1177 */         power = 1.0F;
/*      */       } else {
/* 1179 */         power = 0.4F + 0.4F * i / 90.0F;
/*      */       } 
/*      */       
/* 1182 */       HorseJumpEvent event = CraftEventFactory.callHorseJumpEvent(this, power);
/* 1183 */       if (!event.isCancelled()) {
/* 1184 */         this.bI = true;
/* 1185 */         cU();
/* 1186 */         this.bt = event.getPower();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void ac() {
/* 1193 */     super.ac();
/* 1194 */     if (this.bM > 0.0F) {
/* 1195 */       float f = MathHelper.sin(this.aM * 3.1415927F / 180.0F);
/* 1196 */       float f1 = MathHelper.cos(this.aM * 3.1415927F / 180.0F);
/* 1197 */       float f2 = 0.7F * this.bM;
/* 1198 */       float f3 = 0.15F * this.bM;
/*      */       
/* 1200 */       this.passenger.setPosition(this.locX + (f2 * f), this.locY + ad() + this.passenger.ad() + f3, this.locZ - (f2 * f1));
/* 1201 */       if (this.passenger instanceof EntityLiving) {
/* 1202 */         ((EntityLiving)this.passenger).aM = this.aM;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private float cV() {
/* 1208 */     return 15.0F + this.random.nextInt(8) + this.random.nextInt(9);
/*      */   }
/*      */   
/*      */   private double cW() {
/* 1212 */     return 0.4000000059604645D + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D;
/*      */   }
/*      */   
/*      */   private double cX() {
/* 1216 */     return (0.44999998807907104D + this.random.nextDouble() * 0.3D + this.random.nextDouble() * 0.3D + this.random.nextDouble() * 0.3D) * 0.25D;
/*      */   }
/*      */   
/*      */   public static boolean a(Item item) {
/* 1220 */     return (item == Items.HORSE_ARMOR_IRON || item == Items.HORSE_ARMOR_GOLD || item == Items.HORSE_ARMOR_DIAMOND);
/*      */   }
/*      */   
/*      */   public boolean h_() {
/* 1224 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityHorse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */