/*      */ package net.minecraft.server.v1_7_R4;
/*      */ 
/*      */ import com.google.common.base.Function;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.TrigMath;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*      */ import org.bukkit.entity.Entity;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.entity.EntityDamageEvent;
/*      */ import org.bukkit.event.entity.EntityRegainHealthEvent;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ 
/*      */ public abstract class EntityLiving extends Entity {
/*   21 */   private static final UUID b = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
/*   22 */   private static final AttributeModifier c = (new AttributeModifier(b, "Sprinting speed boost", 0.30000001192092896D, 2)).a(false);
/*      */   private AttributeMapBase d;
/*   24 */   public CombatTracker combatTracker = new CombatTracker(this);
/*   25 */   public final HashMap effects = new HashMap<Object, Object>();
/*   26 */   private final ItemStack[] g = new ItemStack[5];
/*      */   public boolean at;
/*      */   public int au;
/*      */   public int av;
/*      */   public float aw;
/*      */   public int hurtTicks;
/*      */   public int ay;
/*      */   public float az;
/*      */   public int deathTicks;
/*      */   public int attackTicks;
/*      */   public float aC;
/*      */   public float aD;
/*      */   public float aE;
/*      */   public float aF;
/*      */   public float aG;
/*   41 */   public int maxNoDamageTicks = 20;
/*      */   public float aI;
/*      */   public float aJ;
/*      */   public float aK;
/*      */   public float aL;
/*      */   public float aM;
/*      */   public float aN;
/*      */   public float aO;
/*      */   public float aP;
/*   50 */   public float aQ = 0.02F;
/*      */   
/*      */   public EntityHuman killer;
/*      */   protected int lastDamageByPlayerTime;
/*      */   protected boolean aT;
/*      */   protected int aU;
/*      */   protected float aV;
/*      */   protected float aW;
/*      */   protected float aX;
/*      */   protected float aY;
/*      */   protected float aZ;
/*      */   protected int ba;
/*      */   public float lastDamage;
/*      */   protected boolean bc;
/*      */   public float bd;
/*      */   public float be;
/*      */   protected float bf;
/*      */   protected int bg;
/*      */   protected double bh;
/*      */   protected double bi;
/*      */   protected double bj;
/*      */   protected double bk;
/*      */   protected double bl;
/*      */   public boolean updateEffects = true;
/*      */   public EntityLiving lastDamager;
/*      */   private int bm;
/*      */   private EntityLiving bn;
/*      */   private int bo;
/*      */   private float bp;
/*      */   private int bq;
/*      */   private float br;
/*      */   public int expToDrop;
/*   82 */   public int maxAirTicks = 300;
/*   83 */   ArrayList<ItemStack> drops = null;
/*      */ 
/*      */   
/*      */   public EntityLiving(World world) {
/*   87 */     super(world);
/*   88 */     aD();
/*      */     
/*   90 */     this.datawatcher.watch(6, Float.valueOf((float)getAttributeInstance(GenericAttributes.maxHealth).getValue()));
/*   91 */     this.k = true;
/*   92 */     this.aL = (float)(Math.random() + 1.0D) * 0.01F;
/*   93 */     setPosition(this.locX, this.locY, this.locZ);
/*   94 */     this.aK = (float)Math.random() * 12398.0F;
/*   95 */     this.yaw = (float)(Math.random() * 3.1415927410125732D * 2.0D);
/*   96 */     this.aO = this.yaw;
/*   97 */     this.W = 0.5F;
/*      */   }
/*      */   
/*      */   protected void c() {
/*  101 */     this.datawatcher.a(7, Integer.valueOf(0));
/*  102 */     this.datawatcher.a(8, Byte.valueOf((byte)0));
/*  103 */     this.datawatcher.a(9, Byte.valueOf((byte)0));
/*  104 */     this.datawatcher.a(6, Float.valueOf(1.0F));
/*      */   }
/*      */   
/*      */   protected void aD() {
/*  108 */     getAttributeMap().b(GenericAttributes.maxHealth);
/*  109 */     getAttributeMap().b(GenericAttributes.c);
/*  110 */     getAttributeMap().b(GenericAttributes.d);
/*  111 */     if (!bk()) {
/*  112 */       getAttributeInstance(GenericAttributes.d).setValue(0.10000000149011612D);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void a(double d0, boolean flag) {
/*  117 */     if (!M()) {
/*  118 */       N();
/*      */     }
/*      */     
/*  121 */     if (flag && this.fallDistance > 0.0F) {
/*  122 */       int i = MathHelper.floor(this.locX);
/*  123 */       int j = MathHelper.floor(this.locY - 0.20000000298023224D - this.height);
/*  124 */       int k = MathHelper.floor(this.locZ);
/*  125 */       Block block = this.world.getType(i, j, k);
/*      */       
/*  127 */       if (block.getMaterial() == Material.AIR) {
/*  128 */         int l = this.world.getType(i, j - 1, k).b();
/*      */         
/*  130 */         if (l == 11 || l == 32 || l == 21) {
/*  131 */           block = this.world.getType(i, j - 1, k);
/*      */         }
/*  133 */       } else if (!this.world.isStatic && this.fallDistance > 3.0F) {
/*      */         
/*  135 */         if (this instanceof EntityPlayer) {
/*  136 */           this.world.a((EntityHuman)this, 2006, i, j, k, MathHelper.f(this.fallDistance - 3.0F));
/*  137 */           ((EntityPlayer)this).playerConnection.sendPacket(new PacketPlayOutWorldEvent(2006, i, j, k, MathHelper.f(this.fallDistance - 3.0F), false));
/*      */         } else {
/*  139 */           this.world.triggerEffect(2006, i, j, k, MathHelper.f(this.fallDistance - 3.0F));
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  144 */       block.a(this.world, i, j, k, this, this.fallDistance);
/*      */     } 
/*      */     
/*  147 */     super.a(d0, flag);
/*      */   }
/*      */   
/*      */   public boolean aE() {
/*  151 */     return false;
/*      */   }
/*      */   
/*      */   public void C() {
/*  155 */     this.aC = this.aD;
/*  156 */     super.C();
/*  157 */     this.world.methodProfiler.a("livingEntityBaseTick");
/*  158 */     if (isAlive() && inBlock()) {
/*  159 */       damageEntity(DamageSource.STUCK, 1.0F);
/*      */     }
/*      */     
/*  162 */     if (isFireproof() || this.world.isStatic) {
/*  163 */       extinguish();
/*      */     }
/*      */     
/*  166 */     boolean flag = (this instanceof EntityHuman && ((EntityHuman)this).abilities.isInvulnerable);
/*      */     
/*  168 */     if (isAlive() && a(Material.WATER)) {
/*  169 */       if (!aE() && !hasEffect(MobEffectList.WATER_BREATHING.id) && !flag) {
/*  170 */         setAirTicks(j(getAirTicks()));
/*  171 */         if (getAirTicks() == -20) {
/*  172 */           setAirTicks(0);
/*      */           
/*  174 */           for (int i = 0; i < 8; i++) {
/*  175 */             float f = this.random.nextFloat() - this.random.nextFloat();
/*  176 */             float f1 = this.random.nextFloat() - this.random.nextFloat();
/*  177 */             float f2 = this.random.nextFloat() - this.random.nextFloat();
/*      */             
/*  179 */             this.world.addParticle("bubble", this.locX + f, this.locY + f1, this.locZ + f2, this.motX, this.motY, this.motZ);
/*      */           } 
/*      */           
/*  182 */           damageEntity(DamageSource.DROWN, 2.0F);
/*      */         } 
/*      */       } 
/*      */       
/*  186 */       if (!this.world.isStatic && am() && this.vehicle instanceof EntityLiving) {
/*  187 */         mount((Entity)null);
/*      */       
/*      */       }
/*      */     }
/*  191 */     else if (getAirTicks() != 300) {
/*  192 */       setAirTicks(this.maxAirTicks);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  197 */     if (isAlive() && L()) {
/*  198 */       extinguish();
/*      */     }
/*      */     
/*  201 */     this.aI = this.aJ;
/*  202 */     if (this.attackTicks > 0) {
/*  203 */       this.attackTicks--;
/*      */     }
/*      */     
/*  206 */     if (this.hurtTicks > 0) {
/*  207 */       this.hurtTicks--;
/*      */     }
/*      */     
/*  210 */     if (this.noDamageTicks > 0 && !(this instanceof EntityPlayer)) {
/*  211 */       this.noDamageTicks--;
/*      */     }
/*      */     
/*  214 */     if (getHealth() <= 0.0F) {
/*  215 */       aF();
/*      */     }
/*      */     
/*  218 */     if (this.lastDamageByPlayerTime > 0) {
/*  219 */       this.lastDamageByPlayerTime--;
/*      */     } else {
/*  221 */       this.killer = null;
/*      */     } 
/*      */     
/*  224 */     if (this.bn != null && !this.bn.isAlive()) {
/*  225 */       this.bn = null;
/*      */     }
/*      */     
/*  228 */     if (this.lastDamager != null) {
/*  229 */       if (!this.lastDamager.isAlive()) {
/*  230 */         b((EntityLiving)null);
/*  231 */       } else if (this.ticksLived - this.bm > 100) {
/*  232 */         b((EntityLiving)null);
/*      */       } 
/*      */     }
/*      */     
/*  236 */     aO();
/*  237 */     this.aY = this.aX;
/*  238 */     this.aN = this.aM;
/*  239 */     this.aP = this.aO;
/*  240 */     this.lastYaw = this.yaw;
/*  241 */     this.lastPitch = this.pitch;
/*  242 */     this.world.methodProfiler.b();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getExpReward() {
/*  247 */     int exp = getExpValue(this.killer);
/*      */     
/*  249 */     if (!this.world.isStatic && (this.lastDamageByPlayerTime > 0 || alwaysGivesExp()) && aG() && this.world.getGameRules().getBoolean("doMobLoot")) {
/*  250 */       return exp;
/*      */     }
/*  252 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBaby() {
/*  258 */     return false;
/*      */   }
/*      */   
/*      */   protected void aF() {
/*  262 */     this.deathTicks++;
/*  263 */     if (this.deathTicks >= 20 && !this.dead) {
/*      */ 
/*      */ 
/*      */       
/*  267 */       int i = this.expToDrop;
/*  268 */       while (i > 0) {
/*  269 */         int j = EntityExperienceOrb.getOrbValue(i);
/*      */         
/*  271 */         i -= j;
/*  272 */         this.world.addEntity(new EntityExperienceOrb(this.world, this.locX, this.locY, this.locZ, j));
/*      */       } 
/*  274 */       this.expToDrop = 0;
/*      */ 
/*      */       
/*  277 */       die();
/*      */       
/*  279 */       for (i = 0; i < 20; i++) {
/*  280 */         double d0 = this.random.nextGaussian() * 0.02D;
/*  281 */         double d1 = this.random.nextGaussian() * 0.02D;
/*  282 */         double d2 = this.random.nextGaussian() * 0.02D;
/*      */         
/*  284 */         this.world.addParticle("explode", this.locX + (this.random.nextFloat() * this.width * 2.0F) - this.width, this.locY + (this.random.nextFloat() * this.length), this.locZ + (this.random.nextFloat() * this.width * 2.0F) - this.width, d0, d1, d2);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected boolean aG() {
/*  290 */     return !isBaby();
/*      */   }
/*      */   
/*      */   protected int j(int i) {
/*  294 */     int j = EnchantmentManager.getOxygenEnchantmentLevel(this);
/*      */     
/*  296 */     return (j > 0 && this.random.nextInt(j + 1) > 0) ? i : (i - 1);
/*      */   }
/*      */   
/*      */   protected int getExpValue(EntityHuman entityhuman) {
/*  300 */     return 0;
/*      */   }
/*      */   
/*      */   protected boolean alwaysGivesExp() {
/*  304 */     return false;
/*      */   }
/*      */   
/*      */   public Random aI() {
/*  308 */     return this.random;
/*      */   }
/*      */   
/*      */   public EntityLiving getLastDamager() {
/*  312 */     return this.lastDamager;
/*      */   }
/*      */   
/*      */   public int aK() {
/*  316 */     return this.bm;
/*      */   }
/*      */   
/*      */   public void b(EntityLiving entityliving) {
/*  320 */     this.lastDamager = entityliving;
/*  321 */     this.bm = this.ticksLived;
/*      */   }
/*      */   
/*      */   public EntityLiving aL() {
/*  325 */     return this.bn;
/*      */   }
/*      */   
/*      */   public int aM() {
/*  329 */     return this.bo;
/*      */   }
/*      */   
/*      */   public void l(Entity entity) {
/*  333 */     if (entity instanceof EntityLiving) {
/*  334 */       this.bn = (EntityLiving)entity;
/*      */     } else {
/*  336 */       this.bn = null;
/*      */     } 
/*      */     
/*  339 */     this.bo = this.ticksLived;
/*      */   }
/*      */   
/*      */   public int aN() {
/*  343 */     return this.aU;
/*      */   }
/*      */   
/*      */   public void b(NBTTagCompound nbttagcompound) {
/*  347 */     nbttagcompound.setFloat("HealF", getHealth());
/*  348 */     nbttagcompound.setShort("Health", (short)(int)Math.ceil(getHealth()));
/*  349 */     nbttagcompound.setShort("HurtTime", (short)this.hurtTicks);
/*  350 */     nbttagcompound.setShort("DeathTime", (short)this.deathTicks);
/*  351 */     nbttagcompound.setShort("AttackTime", (short)this.attackTicks);
/*  352 */     nbttagcompound.setFloat("AbsorptionAmount", getAbsorptionHearts());
/*  353 */     ItemStack[] aitemstack = getEquipment();
/*  354 */     int i = aitemstack.length;
/*      */ 
/*      */     
/*      */     int j;
/*      */     
/*  359 */     for (j = 0; j < i; j++) {
/*  360 */       ItemStack itemstack = aitemstack[j];
/*  361 */       if (itemstack != null) {
/*  362 */         this.d.a(itemstack.D());
/*      */       }
/*      */     } 
/*      */     
/*  366 */     nbttagcompound.set("Attributes", GenericAttributes.a(getAttributeMap()));
/*  367 */     aitemstack = getEquipment();
/*  368 */     i = aitemstack.length;
/*      */     
/*  370 */     for (j = 0; j < i; j++) {
/*  371 */       ItemStack itemstack = aitemstack[j];
/*  372 */       if (itemstack != null) {
/*  373 */         this.d.b(itemstack.D());
/*      */       }
/*      */     } 
/*      */     
/*  377 */     if (!this.effects.isEmpty()) {
/*  378 */       NBTTagList nbttaglist = new NBTTagList();
/*  379 */       Iterator<MobEffect> iterator = this.effects.values().iterator();
/*      */       
/*  381 */       while (iterator.hasNext()) {
/*  382 */         MobEffect mobeffect = iterator.next();
/*      */         
/*  384 */         nbttaglist.add(mobeffect.a(new NBTTagCompound()));
/*      */       } 
/*      */       
/*  387 */       nbttagcompound.set("ActiveEffects", nbttaglist);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(NBTTagCompound nbttagcompound) {
/*  392 */     setAbsorptionHearts(nbttagcompound.getFloat("AbsorptionAmount"));
/*  393 */     if (nbttagcompound.hasKeyOfType("Attributes", 9) && this.world != null && !this.world.isStatic) {
/*  394 */       GenericAttributes.a(getAttributeMap(), nbttagcompound.getList("Attributes", 10));
/*      */     }
/*      */     
/*  397 */     if (nbttagcompound.hasKeyOfType("ActiveEffects", 9)) {
/*  398 */       NBTTagList nbttaglist = nbttagcompound.getList("ActiveEffects", 10);
/*      */       
/*  400 */       for (int i = 0; i < nbttaglist.size(); i++) {
/*  401 */         NBTTagCompound nbttagcompound1 = nbttaglist.get(i);
/*  402 */         MobEffect mobeffect = MobEffect.b(nbttagcompound1);
/*      */         
/*  404 */         if (mobeffect != null) {
/*  405 */           this.effects.put(Integer.valueOf(mobeffect.getEffectId()), mobeffect);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  411 */     if (nbttagcompound.hasKey("Bukkit.MaxHealth")) {
/*  412 */       NBTBase nbtbase = nbttagcompound.get("Bukkit.MaxHealth");
/*  413 */       if (nbtbase.getTypeId() == 5) {
/*  414 */         getAttributeInstance(GenericAttributes.maxHealth).setValue(((NBTTagFloat)nbtbase).c());
/*  415 */       } else if (nbtbase.getTypeId() == 3) {
/*  416 */         getAttributeInstance(GenericAttributes.maxHealth).setValue(((NBTTagInt)nbtbase).d());
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  421 */     if (nbttagcompound.hasKeyOfType("HealF", 99)) {
/*  422 */       setHealth(nbttagcompound.getFloat("HealF"));
/*      */     } else {
/*  424 */       NBTBase nbtbase = nbttagcompound.get("Health");
/*      */       
/*  426 */       if (nbtbase == null) {
/*  427 */         setHealth(getMaxHealth());
/*  428 */       } else if (nbtbase.getTypeId() == 5) {
/*  429 */         setHealth(((NBTTagFloat)nbtbase).h());
/*  430 */       } else if (nbtbase.getTypeId() == 2) {
/*  431 */         setHealth(((NBTTagShort)nbtbase).e());
/*      */       } 
/*      */     } 
/*      */     
/*  435 */     this.hurtTicks = nbttagcompound.getShort("HurtTime");
/*  436 */     this.deathTicks = nbttagcompound.getShort("DeathTime");
/*  437 */     this.attackTicks = nbttagcompound.getShort("AttackTime");
/*      */   }
/*      */   
/*      */   protected void aO() {
/*  441 */     Iterator<Integer> iterator = this.effects.keySet().iterator();
/*      */     
/*  443 */     while (iterator.hasNext()) {
/*  444 */       Integer integer = iterator.next();
/*  445 */       MobEffect mobeffect = (MobEffect)this.effects.get(integer);
/*      */       
/*  447 */       if (!mobeffect.tick(this)) {
/*  448 */         if (!this.world.isStatic) {
/*  449 */           iterator.remove();
/*  450 */           b(mobeffect);
/*      */         }  continue;
/*  452 */       }  if (mobeffect.getDuration() % 600 == 0) {
/*  453 */         a(mobeffect, false);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  459 */     if (this.updateEffects) {
/*  460 */       if (!this.world.isStatic) {
/*  461 */         if (this.effects.isEmpty()) {
/*  462 */           this.datawatcher.watch(8, Byte.valueOf((byte)0));
/*  463 */           this.datawatcher.watch(7, Integer.valueOf(0));
/*  464 */           setInvisible(false);
/*      */         } else {
/*  466 */           int j = PotionBrewer.a(this.effects.values());
/*  467 */           this.datawatcher.watch(8, Byte.valueOf((byte)(PotionBrewer.b(this.effects.values()) ? 1 : 0)));
/*  468 */           this.datawatcher.watch(7, Integer.valueOf(j));
/*  469 */           setInvisible(hasEffect(MobEffectList.INVISIBILITY.id));
/*      */         } 
/*      */       }
/*      */       
/*  473 */       this.updateEffects = false;
/*      */     } 
/*      */     
/*  476 */     int i = this.datawatcher.getInt(7);
/*  477 */     boolean flag = (this.datawatcher.getByte(8) > 0);
/*      */     
/*  479 */     if (i > 0) {
/*  480 */       int j; boolean flag1 = false;
/*      */       
/*  482 */       if (!isInvisible()) {
/*  483 */         flag1 = this.random.nextBoolean();
/*      */       } else {
/*  485 */         flag1 = (this.random.nextInt(15) == 0);
/*      */       } 
/*      */       
/*  488 */       if (flag) {
/*  489 */         j = flag1 & ((this.random.nextInt(5) == 0) ? 1 : 0);
/*      */       }
/*      */       
/*  492 */       if (j != 0 && i > 0) {
/*  493 */         double d0 = (i >> 16 & 0xFF) / 255.0D;
/*  494 */         double d1 = (i >> 8 & 0xFF) / 255.0D;
/*  495 */         double d2 = (i >> 0 & 0xFF) / 255.0D;
/*      */         
/*  497 */         this.world.addParticle(flag ? "mobSpellAmbient" : "mobSpell", this.locX + (this.random.nextDouble() - 0.5D) * this.width, this.locY + this.random.nextDouble() * this.length - this.height, this.locZ + (this.random.nextDouble() - 0.5D) * this.width, d0, d1, d2);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void removeAllEffects() {
/*  503 */     Iterator<Integer> iterator = this.effects.keySet().iterator();
/*      */     
/*  505 */     while (iterator.hasNext()) {
/*  506 */       Integer integer = iterator.next();
/*  507 */       MobEffect mobeffect = (MobEffect)this.effects.get(integer);
/*      */       
/*  509 */       if (!this.world.isStatic) {
/*  510 */         iterator.remove();
/*  511 */         b(mobeffect);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Collection getEffects() {
/*  517 */     return this.effects.values();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasEffect(int i) {
/*  522 */     return (this.effects.size() != 0 && this.effects.containsKey(Integer.valueOf(i)));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasEffect(MobEffectList mobeffectlist) {
/*  527 */     return (this.effects.size() != 0 && this.effects.containsKey(Integer.valueOf(mobeffectlist.id)));
/*      */   }
/*      */   
/*      */   public MobEffect getEffect(MobEffectList mobeffectlist) {
/*  531 */     return (MobEffect)this.effects.get(Integer.valueOf(mobeffectlist.id));
/*      */   }
/*      */   
/*      */   public void addEffect(MobEffect mobeffect) {
/*  535 */     if (d(mobeffect)) {
/*  536 */       if (this.effects.containsKey(Integer.valueOf(mobeffect.getEffectId()))) {
/*  537 */         ((MobEffect)this.effects.get(Integer.valueOf(mobeffect.getEffectId()))).a(mobeffect);
/*  538 */         a((MobEffect)this.effects.get(Integer.valueOf(mobeffect.getEffectId())), true);
/*      */       } else {
/*  540 */         this.effects.put(Integer.valueOf(mobeffect.getEffectId()), mobeffect);
/*  541 */         a(mobeffect);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean d(MobEffect mobeffect) {
/*  547 */     if (getMonsterType() == EnumMonsterType.UNDEAD) {
/*  548 */       int i = mobeffect.getEffectId();
/*      */       
/*  550 */       if (i == MobEffectList.REGENERATION.id || i == MobEffectList.POISON.id) {
/*  551 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  555 */     return true;
/*      */   }
/*      */   
/*      */   public boolean aR() {
/*  559 */     return (getMonsterType() == EnumMonsterType.UNDEAD);
/*      */   }
/*      */   
/*      */   public void removeEffect(int i) {
/*  563 */     MobEffect mobeffect = (MobEffect)this.effects.remove(Integer.valueOf(i));
/*      */     
/*  565 */     if (mobeffect != null) {
/*  566 */       b(mobeffect);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void a(MobEffect mobeffect) {
/*  571 */     this.updateEffects = true;
/*  572 */     if (!this.world.isStatic) {
/*  573 */       MobEffectList.byId[mobeffect.getEffectId()].b(this, getAttributeMap(), mobeffect.getAmplifier());
/*      */     }
/*      */   }
/*      */   
/*      */   protected void a(MobEffect mobeffect, boolean flag) {
/*  578 */     this.updateEffects = true;
/*  579 */     if (flag && !this.world.isStatic) {
/*  580 */       MobEffectList.byId[mobeffect.getEffectId()].a(this, getAttributeMap(), mobeffect.getAmplifier());
/*  581 */       MobEffectList.byId[mobeffect.getEffectId()].b(this, getAttributeMap(), mobeffect.getAmplifier());
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void b(MobEffect mobeffect) {
/*  586 */     this.updateEffects = true;
/*  587 */     if (!this.world.isStatic) {
/*  588 */       MobEffectList.byId[mobeffect.getEffectId()].a(this, getAttributeMap(), mobeffect.getAmplifier());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void heal(float f) {
/*  594 */     heal(f, EntityRegainHealthEvent.RegainReason.CUSTOM);
/*      */   }
/*      */   
/*      */   public void heal(float f, EntityRegainHealthEvent.RegainReason regainReason) {
/*  598 */     float f1 = getHealth();
/*      */     
/*  600 */     if (f1 > 0.0F) {
/*  601 */       EntityRegainHealthEvent event = new EntityRegainHealthEvent((Entity)getBukkitEntity(), f, regainReason);
/*  602 */       this.world.getServer().getPluginManager().callEvent((Event)event);
/*      */       
/*  604 */       if (!event.isCancelled()) {
/*  605 */         setHealth((float)(getHealth() + event.getAmount()));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final float getHealth() {
/*  612 */     if (this instanceof EntityPlayer) {
/*  613 */       return (float)((EntityPlayer)this).getBukkitEntity().getHealth();
/*      */     }
/*      */     
/*  616 */     return this.datawatcher.getFloat(6);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setHealth(float f) {
/*  621 */     if (this instanceof EntityPlayer) {
/*  622 */       CraftPlayer player = ((EntityPlayer)this).getBukkitEntity();
/*      */       
/*  624 */       if (f < 0.0F) {
/*  625 */         player.setRealHealth(0.0D);
/*  626 */       } else if (f > player.getMaxHealth()) {
/*  627 */         player.setRealHealth(player.getMaxHealth());
/*      */       } else {
/*  629 */         player.setRealHealth(f);
/*      */       } 
/*      */       
/*  632 */       this.datawatcher.watch(6, Float.valueOf(player.getScaledHealth()));
/*      */       
/*      */       return;
/*      */     } 
/*  636 */     this.datawatcher.watch(6, Float.valueOf(MathHelper.a(f, 0.0F, getMaxHealth())));
/*      */   }
/*      */   
/*      */   public boolean damageEntity(DamageSource damagesource, float f) {
/*  640 */     if (isInvulnerable())
/*  641 */       return false; 
/*  642 */     if (this.world.isStatic) {
/*  643 */       return false;
/*      */     }
/*  645 */     this.aU = 0;
/*  646 */     if (getHealth() <= 0.0F)
/*  647 */       return false; 
/*  648 */     if (damagesource.o() && hasEffect(MobEffectList.FIRE_RESISTANCE)) {
/*  649 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  657 */     this.aF = 1.5F;
/*  658 */     boolean flag = true;
/*      */     
/*  660 */     if (this.noDamageTicks > this.maxNoDamageTicks / 2.0F) {
/*  661 */       if (f <= this.lastDamage) {
/*  662 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  666 */       if (!d(damagesource, f - this.lastDamage)) {
/*  667 */         return false;
/*      */       }
/*      */       
/*  670 */       this.lastDamage = f;
/*  671 */       flag = false;
/*      */     } else {
/*      */       
/*  674 */       float previousHealth = getHealth();
/*  675 */       if (!d(damagesource, f)) {
/*  676 */         return false;
/*      */       }
/*  678 */       this.lastDamage = f;
/*  679 */       this.aw = previousHealth;
/*  680 */       this.noDamageTicks = this.maxNoDamageTicks;
/*      */       
/*  682 */       this.hurtTicks = this.ay = 10;
/*      */     } 
/*      */     
/*  685 */     this.az = 0.0F;
/*  686 */     Entity entity = damagesource.getEntity();
/*      */     
/*  688 */     if (entity != null) {
/*  689 */       if (entity instanceof EntityLiving) {
/*  690 */         b((EntityLiving)entity);
/*      */       }
/*      */       
/*  693 */       if (entity instanceof EntityHuman) {
/*  694 */         this.lastDamageByPlayerTime = 100;
/*  695 */         this.killer = (EntityHuman)entity;
/*  696 */       } else if (entity instanceof EntityWolf) {
/*  697 */         EntityWolf entitywolf = (EntityWolf)entity;
/*      */         
/*  699 */         if (entitywolf.isTamed()) {
/*  700 */           this.lastDamageByPlayerTime = 100;
/*  701 */           this.killer = null;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  706 */     if (flag) {
/*  707 */       this.world.broadcastEntityEffect(this, (byte)2);
/*  708 */       if (damagesource != DamageSource.DROWN) {
/*  709 */         Q();
/*      */       }
/*      */       
/*  712 */       if (entity != null) {
/*  713 */         double d0 = entity.locX - this.locX;
/*      */         
/*      */         double d1;
/*      */         
/*  717 */         for (d1 = entity.locZ - this.locZ; d0 * d0 + d1 * d1 < 1.0E-4D; d1 = (Math.random() - Math.random()) * 0.01D) {
/*  718 */           d0 = (Math.random() - Math.random()) * 0.01D;
/*      */         }
/*      */         
/*  721 */         this.az = (float)(Math.atan2(d1, d0) * 180.0D / 3.1415927410125732D) - this.yaw;
/*  722 */         a(entity, f, d0, d1);
/*      */       } else {
/*  724 */         this.az = ((int)(Math.random() * 2.0D) * 180);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  730 */     if (getHealth() <= 0.0F) {
/*  731 */       String s = aU();
/*  732 */       if (flag && s != null) {
/*  733 */         makeSound(s, bf(), bg());
/*      */       }
/*      */       
/*  736 */       die(damagesource);
/*      */     } else {
/*  738 */       String s = aT();
/*  739 */       if (flag && s != null) {
/*  740 */         makeSound(s, bf(), bg());
/*      */       }
/*      */     } 
/*      */     
/*  744 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(ItemStack itemstack) {
/*  750 */     makeSound("random.break", 0.8F, 0.8F + this.world.random.nextFloat() * 0.4F);
/*      */     
/*  752 */     for (int i = 0; i < 5; i++) {
/*  753 */       Vec3D vec3d = Vec3D.a((this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
/*      */       
/*  755 */       vec3d.a(-this.pitch * 3.1415927F / 180.0F);
/*  756 */       vec3d.b(-this.yaw * 3.1415927F / 180.0F);
/*  757 */       Vec3D vec3d1 = Vec3D.a((this.random.nextFloat() - 0.5D) * 0.3D, -this.random.nextFloat() * 0.6D - 0.3D, 0.6D);
/*      */       
/*  759 */       vec3d1.a(-this.pitch * 3.1415927F / 180.0F);
/*  760 */       vec3d1.b(-this.yaw * 3.1415927F / 180.0F);
/*  761 */       vec3d1 = vec3d1.add(this.locX, this.locY + getHeadHeight(), this.locZ);
/*  762 */       this.world.addParticle("iconcrack_" + Item.getId(itemstack.getItem()), vec3d1.a, vec3d1.b, vec3d1.c, vec3d.a, vec3d.b + 0.05D, vec3d.c);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void die(DamageSource damagesource) {
/*  767 */     Entity entity = damagesource.getEntity();
/*  768 */     EntityLiving entityliving = aX();
/*      */     
/*  770 */     if (this.ba >= 0 && entityliving != null) {
/*  771 */       entityliving.b(this, this.ba);
/*      */     }
/*      */     
/*  774 */     if (entity != null) {
/*  775 */       entity.a(this);
/*      */     }
/*      */     
/*  778 */     this.aT = true;
/*  779 */     aW().g();
/*  780 */     if (!this.world.isStatic) {
/*  781 */       int i = 0;
/*      */       
/*  783 */       if (entity instanceof EntityHuman) {
/*  784 */         i = EnchantmentManager.getBonusMonsterLootEnchantmentLevel((EntityLiving)entity);
/*      */       }
/*      */       
/*  787 */       if (aG() && this.world.getGameRules().getBoolean("doMobLoot")) {
/*  788 */         this.drops = new ArrayList<ItemStack>();
/*      */         
/*  790 */         dropDeathLoot((this.lastDamageByPlayerTime > 0), i);
/*  791 */         dropEquipment((this.lastDamageByPlayerTime > 0), i);
/*  792 */         if (this.lastDamageByPlayerTime > 0) {
/*  793 */           int j = this.random.nextInt(200) - i;
/*      */           
/*  795 */           if (j < 5) {
/*  796 */             getRareDrop((j <= 0) ? 1 : 0);
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  801 */         CraftEventFactory.callEntityDeathEvent(this, this.drops);
/*  802 */         this.drops = null;
/*      */       } else {
/*  804 */         CraftEventFactory.callEntityDeathEvent(this);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  809 */     this.world.broadcastEntityEffect(this, (byte)3);
/*      */   }
/*      */   
/*      */   protected void dropEquipment(boolean flag, int i) {}
/*      */   
/*      */   public void a(Entity entity, float f, double d0, double d1) {
/*  815 */     if (this.random.nextDouble() >= getAttributeInstance(GenericAttributes.c).getValue()) {
/*  816 */       this.al = true;
/*  817 */       float f1 = MathHelper.sqrt(d0 * d0 + d1 * d1);
/*  818 */       float f2 = 0.4F;
/*      */       
/*  820 */       this.motX /= 2.0D;
/*  821 */       this.motY /= 2.0D;
/*  822 */       this.motZ /= 2.0D;
/*  823 */       this.motX -= d0 / f1 * f2;
/*  824 */       this.motY += f2;
/*  825 */       this.motZ -= d1 / f1 * f2;
/*  826 */       if (this.motY > 0.4000000059604645D) {
/*  827 */         this.motY = 0.4000000059604645D;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected String aT() {
/*  833 */     return "game.neutral.hurt";
/*      */   }
/*      */   
/*      */   protected String aU() {
/*  837 */     return "game.neutral.die";
/*      */   }
/*      */   
/*      */   protected void getRareDrop(int i) {}
/*      */   
/*      */   protected void dropDeathLoot(boolean flag, int i) {}
/*      */   
/*      */   public boolean h_() {
/*  845 */     int i = MathHelper.floor(this.locX);
/*  846 */     int j = MathHelper.floor(this.boundingBox.b);
/*  847 */     int k = MathHelper.floor(this.locZ);
/*  848 */     Block block = this.world.getType(i, j, k);
/*      */     
/*  850 */     return (block == Blocks.LADDER || block == Blocks.VINE);
/*      */   }
/*      */   
/*      */   public boolean isAlive() {
/*  854 */     return (!this.dead && getHealth() > 0.0F);
/*      */   }
/*      */   
/*      */   protected void b(float f) {
/*  858 */     super.b(f);
/*  859 */     MobEffect mobeffect = getEffect(MobEffectList.JUMP);
/*  860 */     float f1 = (mobeffect != null) ? (mobeffect.getAmplifier() + 1) : 0.0F;
/*  861 */     int i = MathHelper.f(f - 3.0F - f1);
/*      */     
/*  863 */     if (i > 0) {
/*      */       
/*  865 */       if (!damageEntity(DamageSource.FALL, i)) {
/*      */         return;
/*      */       }
/*      */       
/*  869 */       makeSound(o(i), 1.0F, 1.0F);
/*      */       
/*  871 */       int j = MathHelper.floor(this.locX);
/*  872 */       int k = MathHelper.floor(this.locY - 0.20000000298023224D - this.height);
/*  873 */       int l = MathHelper.floor(this.locZ);
/*  874 */       Block block = this.world.getType(j, k, l);
/*      */       
/*  876 */       if (block.getMaterial() != Material.AIR) {
/*  877 */         StepSound stepsound = block.stepSound;
/*      */         
/*  879 */         makeSound(stepsound.getStepSound(), stepsound.getVolume1() * 0.5F, stepsound.getVolume2() * 0.75F);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected String o(int i) {
/*  885 */     return (i > 4) ? "game.neutral.hurt.fall.big" : "game.neutral.hurt.fall.small";
/*      */   }
/*      */   
/*      */   public int aV() {
/*  889 */     int i = 0;
/*  890 */     ItemStack[] aitemstack = getEquipment();
/*  891 */     int j = aitemstack.length;
/*      */     
/*  893 */     for (int k = 0; k < j; k++) {
/*  894 */       ItemStack itemstack = aitemstack[k];
/*      */       
/*  896 */       if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
/*  897 */         int l = ((ItemArmor)itemstack.getItem()).c;
/*      */         
/*  899 */         i += l;
/*      */       } 
/*      */     } 
/*      */     
/*  903 */     return i;
/*      */   }
/*      */   
/*      */   protected void damageArmor(float f) {}
/*      */   
/*      */   protected float applyArmorModifier(DamageSource damagesource, float f) {
/*  909 */     if (!damagesource.ignoresArmor()) {
/*  910 */       int i = 25 - aV();
/*  911 */       float f1 = f * i;
/*      */ 
/*      */       
/*  914 */       f = f1 / 25.0F;
/*      */     } 
/*      */     
/*  917 */     return f;
/*      */   }
/*      */   
/*      */   protected float applyMagicModifier(DamageSource damagesource, float f) {
/*  921 */     if (damagesource.isStarvation()) {
/*  922 */       return f;
/*      */     }
/*  924 */     if (this instanceof EntityZombie) {
/*  925 */       f = f;
/*      */     }
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
/*  940 */     if (f <= 0.0F) {
/*  941 */       return 0.0F;
/*      */     }
/*  943 */     int i = EnchantmentManager.a(getEquipment(), damagesource);
/*  944 */     if (i > 20) {
/*  945 */       i = 20;
/*      */     }
/*      */     
/*  948 */     if (i > 0 && i <= 20) {
/*  949 */       int j = 25 - i;
/*  950 */       float f1 = f * j;
/*  951 */       f = f1 / 25.0F;
/*      */     } 
/*      */     
/*  954 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean d(final DamageSource damagesource, float f) {
/*  961 */     if (!isInvulnerable()) {
/*  962 */       final boolean human = this instanceof EntityHuman;
/*  963 */       float originalDamage = f;
/*  964 */       Function<Double, Double> hardHat = new Function<Double, Double>()
/*      */         {
/*      */           public Double apply(Double f) {
/*  967 */             if ((damagesource == DamageSource.ANVIL || damagesource == DamageSource.FALLING_BLOCK) && EntityLiving.this.getEquipment(4) != null) {
/*  968 */               return Double.valueOf(-(f.doubleValue() - f.doubleValue() * 0.75D));
/*      */             }
/*  970 */             return Double.valueOf(-0.0D);
/*      */           }
/*      */         };
/*  973 */       float hardHatModifier = ((Double)hardHat.apply(Double.valueOf(f))).floatValue();
/*  974 */       f += hardHatModifier;
/*      */       
/*  976 */       Function<Double, Double> blocking = new Function<Double, Double>()
/*      */         {
/*      */           public Double apply(Double f) {
/*  979 */             if (human && 
/*  980 */               !damagesource.ignoresArmor() && ((EntityHuman)EntityLiving.this).isBlocking() && f.doubleValue() > 0.0D) {
/*  981 */               return Double.valueOf(-(f.doubleValue() - (1.0D + f.doubleValue()) * 0.5D));
/*      */             }
/*      */             
/*  984 */             return Double.valueOf(-0.0D);
/*      */           }
/*      */         };
/*  987 */       float blockingModifier = ((Double)blocking.apply(Double.valueOf(f))).floatValue();
/*  988 */       f += blockingModifier;
/*      */       
/*  990 */       Function<Double, Double> armor = new Function<Double, Double>()
/*      */         {
/*      */           public Double apply(Double f) {
/*  993 */             return Double.valueOf(-(f.doubleValue() - EntityLiving.this.applyArmorModifier(damagesource, f.floatValue())));
/*      */           }
/*      */         };
/*  996 */       float armorModifier = ((Double)armor.apply(Double.valueOf(f))).floatValue();
/*  997 */       f += armorModifier;
/*      */       
/*  999 */       Function<Double, Double> resistance = new Function<Double, Double>()
/*      */         {
/*      */           public Double apply(Double f) {
/* 1002 */             if (!damagesource.isStarvation() && EntityLiving.this.hasEffect(MobEffectList.RESISTANCE) && damagesource != DamageSource.OUT_OF_WORLD) {
/* 1003 */               int i = (EntityLiving.this.getEffect(MobEffectList.RESISTANCE).getAmplifier() + 1) * 5;
/* 1004 */               int j = 25 - i;
/* 1005 */               float f1 = f.floatValue() * j;
/* 1006 */               return Double.valueOf(-(f.doubleValue() - (f1 / 25.0F)));
/*      */             } 
/* 1008 */             return Double.valueOf(-0.0D);
/*      */           }
/*      */         };
/* 1011 */       float resistanceModifier = ((Double)resistance.apply(Double.valueOf(f))).floatValue();
/* 1012 */       f += resistanceModifier;
/*      */       
/* 1014 */       Function<Double, Double> magic = new Function<Double, Double>()
/*      */         {
/*      */           public Double apply(Double f) {
/* 1017 */             return Double.valueOf(-(f.doubleValue() - EntityLiving.this.applyMagicModifier(damagesource, f.floatValue())));
/*      */           }
/*      */         };
/* 1020 */       float magicModifier = ((Double)magic.apply(Double.valueOf(f))).floatValue();
/* 1021 */       f += magicModifier;
/*      */       
/* 1023 */       Function<Double, Double> absorption = new Function<Double, Double>()
/*      */         {
/*      */           public Double apply(Double f) {
/* 1026 */             return Double.valueOf(-Math.max(f.doubleValue() - Math.max(f.doubleValue() - EntityLiving.this.getAbsorptionHearts(), 0.0D), 0.0D));
/*      */           }
/*      */         };
/* 1029 */       float absorptionModifier = ((Double)absorption.apply(Double.valueOf(f))).floatValue();
/*      */       
/* 1031 */       EntityDamageEvent event = CraftEventFactory.handleLivingEntityDamageEvent(this, damagesource, originalDamage, hardHatModifier, blockingModifier, armorModifier, resistanceModifier, magicModifier, absorptionModifier, hardHat, blocking, armor, resistance, magic, absorption);
/* 1032 */       if (event.isCancelled()) {
/* 1033 */         return false;
/*      */       }
/*      */       
/* 1036 */       f = (float)event.getFinalDamage();
/*      */ 
/*      */       
/* 1039 */       if ((damagesource == DamageSource.ANVIL || damagesource == DamageSource.FALLING_BLOCK) && getEquipment(4) != null) {
/* 1040 */         getEquipment(4).damage((int)(event.getDamage() * 4.0D + this.random.nextFloat() * event.getDamage() * 2.0D), this);
/*      */       }
/*      */ 
/*      */       
/* 1044 */       if (!damagesource.ignoresArmor()) {
/* 1045 */         float armorDamage = (float)(event.getDamage() + event.getDamage(EntityDamageEvent.DamageModifier.BLOCKING) + event.getDamage(EntityDamageEvent.DamageModifier.HARD_HAT));
/* 1046 */         damageArmor(armorDamage);
/*      */       } 
/*      */       
/* 1049 */       absorptionModifier = (float)-event.getDamage(EntityDamageEvent.DamageModifier.ABSORPTION);
/* 1050 */       setAbsorptionHearts(Math.max(getAbsorptionHearts() - absorptionModifier, 0.0F));
/* 1051 */       if (f != 0.0F) {
/* 1052 */         if (human) {
/* 1053 */           ((EntityHuman)this).applyExhaustion(damagesource.getExhaustionCost());
/*      */         }
/*      */         
/* 1056 */         float f2 = getHealth();
/*      */         
/* 1058 */         setHealth(f2 - f);
/* 1059 */         aW().a(damagesource, f2, f);
/*      */         
/* 1061 */         if (human) {
/* 1062 */           return true;
/*      */         }
/*      */         
/* 1065 */         setAbsorptionHearts(getAbsorptionHearts() - f);
/*      */       } 
/* 1067 */       return true;
/*      */     } 
/* 1069 */     return false;
/*      */   }
/*      */   
/*      */   public CombatTracker aW() {
/* 1073 */     return this.combatTracker;
/*      */   }
/*      */   
/*      */   public EntityLiving aX() {
/* 1077 */     return (this.combatTracker.c() != null) ? this.combatTracker.c() : ((this.killer != null) ? this.killer : ((this.lastDamager != null) ? this.lastDamager : null));
/*      */   }
/*      */   
/*      */   public final float getMaxHealth() {
/* 1081 */     return (float)getAttributeInstance(GenericAttributes.maxHealth).getValue();
/*      */   }
/*      */   
/*      */   public final int aZ() {
/* 1085 */     return this.datawatcher.getByte(9);
/*      */   }
/*      */   
/*      */   public final void p(int i) {
/* 1089 */     this.datawatcher.watch(9, Byte.valueOf((byte)i));
/*      */   }
/*      */   
/*      */   private int j() {
/* 1093 */     return hasEffect(MobEffectList.FASTER_DIG) ? (6 - (1 + getEffect(MobEffectList.FASTER_DIG).getAmplifier()) * 1) : (hasEffect(MobEffectList.SLOWER_DIG) ? (6 + (1 + getEffect(MobEffectList.SLOWER_DIG).getAmplifier()) * 2) : 6);
/*      */   }
/*      */   
/*      */   public void ba() {
/* 1097 */     if (!this.at || this.au >= j() / 2 || this.au < 0) {
/* 1098 */       this.au = -1;
/* 1099 */       this.at = true;
/* 1100 */       if (this.world instanceof WorldServer) {
/* 1101 */         ((WorldServer)this.world).getTracker().a(this, new PacketPlayOutAnimation(this, 0));
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void G() {
/* 1107 */     damageEntity(DamageSource.OUT_OF_WORLD, 4.0F);
/*      */   }
/*      */   
/*      */   protected void bb() {
/* 1111 */     int i = j();
/*      */     
/* 1113 */     if (this.at) {
/* 1114 */       this.au++;
/* 1115 */       if (this.au >= i) {
/* 1116 */         this.au = 0;
/* 1117 */         this.at = false;
/*      */       } 
/*      */     } else {
/* 1120 */       this.au = 0;
/*      */     } 
/*      */     
/* 1123 */     this.aD = this.au / i;
/*      */   }
/*      */   
/*      */   public AttributeInstance getAttributeInstance(IAttribute iattribute) {
/* 1127 */     return getAttributeMap().a(iattribute);
/*      */   }
/*      */   
/*      */   public AttributeMapBase getAttributeMap() {
/* 1131 */     if (this.d == null) {
/* 1132 */       this.d = new AttributeMapServer();
/*      */     }
/*      */     
/* 1135 */     return this.d;
/*      */   }
/*      */   
/*      */   public EnumMonsterType getMonsterType() {
/* 1139 */     return EnumMonsterType.UNDEFINED;
/*      */   }
/*      */   
/*      */   public abstract ItemStack be();
/*      */   
/*      */   public abstract ItemStack getEquipment(int paramInt);
/*      */   
/*      */   public abstract void setEquipment(int paramInt, ItemStack paramItemStack);
/*      */   
/*      */   public void setSprinting(boolean flag) {
/* 1149 */     super.setSprinting(flag);
/* 1150 */     AttributeInstance attributeinstance = getAttributeInstance(GenericAttributes.d);
/*      */     
/* 1152 */     if (attributeinstance.a(b) != null) {
/* 1153 */       attributeinstance.b(c);
/*      */     }
/*      */     
/* 1156 */     if (flag) {
/* 1157 */       attributeinstance.a(c);
/*      */     }
/*      */   }
/*      */   
/*      */   public abstract ItemStack[] getEquipment();
/*      */   
/*      */   protected float bf() {
/* 1164 */     return 1.0F;
/*      */   }
/*      */   
/*      */   protected float bg() {
/* 1168 */     return isBaby() ? ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.5F) : ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
/*      */   }
/*      */   
/*      */   protected boolean bh() {
/* 1172 */     return (getHealth() <= 0.0F);
/*      */   }
/*      */   
/*      */   public void enderTeleportTo(double d0, double d1, double d2) {
/* 1176 */     setPositionRotation(d0, d1, d2, this.yaw, this.pitch);
/*      */   }
/*      */   
/*      */   public void m(Entity entity) {
/* 1180 */     double d0 = entity.locX;
/* 1181 */     double d1 = entity.boundingBox.b + entity.length;
/* 1182 */     double d2 = entity.locZ;
/* 1183 */     byte b0 = 1;
/*      */     
/* 1185 */     for (int i = -b0; i <= b0; i++) {
/* 1186 */       for (int j = -b0; j < b0; j++) {
/* 1187 */         if (i != 0 || j != 0) {
/* 1188 */           int k = (int)(this.locX + i);
/* 1189 */           int l = (int)(this.locZ + j);
/* 1190 */           AxisAlignedBB axisalignedbb = this.boundingBox.c(i, 1.0D, j);
/*      */           
/* 1192 */           if (this.world.a(axisalignedbb).isEmpty()) {
/* 1193 */             if (World.a(this.world, k, (int)this.locY, l)) {
/* 1194 */               enderTeleportTo(this.locX + i, this.locY + 1.0D, this.locZ + j);
/*      */               
/*      */               return;
/*      */             } 
/* 1198 */             if (World.a(this.world, k, (int)this.locY - 1, l) || this.world.getType(k, (int)this.locY - 1, l).getMaterial() == Material.WATER) {
/* 1199 */               d0 = this.locX + i;
/* 1200 */               d1 = this.locY + 1.0D;
/* 1201 */               d2 = this.locZ + j;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1208 */     enderTeleportTo(d0, d1, d2);
/*      */   }
/*      */   
/*      */   protected void bj() {
/* 1212 */     this.motY = 0.41999998688697815D;
/* 1213 */     if (hasEffect(MobEffectList.JUMP)) {
/* 1214 */       this.motY += ((getEffect(MobEffectList.JUMP).getAmplifier() + 1) * 0.1F);
/*      */     }
/*      */     
/* 1217 */     if (isSprinting()) {
/* 1218 */       float f = this.yaw * 0.017453292F;
/*      */       
/* 1220 */       this.motX -= (MathHelper.sin(f) * 0.2F);
/* 1221 */       this.motZ += (MathHelper.cos(f) * 0.2F);
/*      */     } 
/*      */     
/* 1224 */     this.al = true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void e(float f, float f1) {
/* 1230 */     if (M() && (!(this instanceof EntityHuman) || !((EntityHuman)this).abilities.isFlying)) {
/* 1231 */       double d = this.locY;
/* 1232 */       a(f, f1, bk() ? 0.04F : 0.02F);
/* 1233 */       move(this.motX, this.motY, this.motZ);
/* 1234 */       this.motX *= 0.800000011920929D;
/* 1235 */       this.motY *= 0.800000011920929D;
/* 1236 */       this.motZ *= 0.800000011920929D;
/* 1237 */       this.motY -= 0.02D;
/* 1238 */       if (this.positionChanged && c(this.motX, this.motY + 0.6000000238418579D - this.locY + d, this.motZ)) {
/* 1239 */         this.motY = 0.30000001192092896D;
/*      */       }
/* 1241 */     } else if (P() && (!(this instanceof EntityHuman) || !((EntityHuman)this).abilities.isFlying)) {
/* 1242 */       double d = this.locY;
/* 1243 */       a(f, f1, 0.02F);
/* 1244 */       move(this.motX, this.motY, this.motZ);
/* 1245 */       this.motX *= 0.5D;
/* 1246 */       this.motY *= 0.5D;
/* 1247 */       this.motZ *= 0.5D;
/* 1248 */       this.motY -= 0.02D;
/* 1249 */       if (this.positionChanged && c(this.motX, this.motY + 0.6000000238418579D - this.locY + d, this.motZ)) {
/* 1250 */         this.motY = 0.30000001192092896D;
/*      */       }
/*      */     } else {
/* 1253 */       float f4, f2 = 0.91F;
/*      */       
/* 1255 */       if (this.onGround) {
/* 1256 */         f2 = (this.world.getType(MathHelper.floor(this.locX), MathHelper.floor(this.boundingBox.b) - 1, MathHelper.floor(this.locZ))).frictionFactor * 0.91F;
/*      */       }
/*      */       
/* 1259 */       float f3 = 0.16277136F / f2 * f2 * f2;
/*      */ 
/*      */       
/* 1262 */       if (this.onGround) {
/* 1263 */         f4 = bl() * f3;
/*      */       } else {
/* 1265 */         f4 = this.aQ;
/*      */       } 
/*      */       
/* 1268 */       a(f, f1, f4);
/* 1269 */       f2 = 0.91F;
/* 1270 */       if (this.onGround) {
/* 1271 */         f2 = (this.world.getType(MathHelper.floor(this.locX), MathHelper.floor(this.boundingBox.b) - 1, MathHelper.floor(this.locZ))).frictionFactor * 0.91F;
/*      */       }
/*      */       
/* 1274 */       if (h_()) {
/* 1275 */         float f5 = 0.15F;
/*      */         
/* 1277 */         if (this.motX < -f5) {
/* 1278 */           this.motX = -f5;
/*      */         }
/*      */         
/* 1281 */         if (this.motX > f5) {
/* 1282 */           this.motX = f5;
/*      */         }
/*      */         
/* 1285 */         if (this.motZ < -f5) {
/* 1286 */           this.motZ = -f5;
/*      */         }
/*      */         
/* 1289 */         if (this.motZ > f5) {
/* 1290 */           this.motZ = f5;
/*      */         }
/*      */         
/* 1293 */         this.fallDistance = 0.0F;
/* 1294 */         if (this.motY < -0.15D) {
/* 1295 */           this.motY = -0.15D;
/*      */         }
/*      */         
/* 1298 */         boolean flag = (isSneaking() && this instanceof EntityHuman);
/*      */         
/* 1300 */         if (flag && this.motY < 0.0D) {
/* 1301 */           this.motY = 0.0D;
/*      */         }
/*      */       } 
/*      */       
/* 1305 */       move(this.motX, this.motY, this.motZ);
/* 1306 */       if (this.positionChanged && h_()) {
/* 1307 */         this.motY = 0.2D;
/*      */       }
/*      */       
/* 1310 */       if (this.world.isStatic && (!this.world.isLoaded((int)this.locX, 0, (int)this.locZ) || !(this.world.getChunkAtWorldCoords((int)this.locX, (int)this.locZ)).d)) {
/* 1311 */         if (this.locY > 0.0D) {
/* 1312 */           this.motY = -0.1D;
/*      */         } else {
/* 1314 */           this.motY = 0.0D;
/*      */         } 
/*      */       } else {
/* 1317 */         this.motY -= 0.08D;
/*      */       } 
/*      */       
/* 1320 */       this.motY *= 0.9800000190734863D;
/* 1321 */       this.motX *= f2;
/* 1322 */       this.motZ *= f2;
/*      */     } 
/*      */     
/* 1325 */     this.aE = this.aF;
/* 1326 */     double d0 = this.locX - this.lastX;
/* 1327 */     double d1 = this.locZ - this.lastZ;
/* 1328 */     float f6 = MathHelper.sqrt(d0 * d0 + d1 * d1) * 4.0F;
/*      */     
/* 1330 */     if (f6 > 1.0F) {
/* 1331 */       f6 = 1.0F;
/*      */     }
/*      */     
/* 1334 */     this.aF += (f6 - this.aF) * 0.4F;
/* 1335 */     this.aG += this.aF;
/*      */   }
/*      */   
/*      */   protected boolean bk() {
/* 1339 */     return false;
/*      */   }
/*      */   
/*      */   public float bl() {
/* 1343 */     return bk() ? this.bp : 0.1F;
/*      */   }
/*      */   
/*      */   public void i(float f) {
/* 1347 */     this.bp = f;
/*      */   }
/*      */   
/*      */   public boolean n(Entity entity) {
/* 1351 */     l(entity);
/* 1352 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isSleeping() {
/* 1356 */     return false;
/*      */   }
/*      */   
/*      */   public void h() {
/* 1360 */     super.h();
/* 1361 */     if (!this.world.isStatic) {
/* 1362 */       int i = aZ();
/*      */       
/* 1364 */       if (i > 0) {
/* 1365 */         if (this.av <= 0) {
/* 1366 */           this.av = 20 * (30 - i);
/*      */         }
/*      */         
/* 1369 */         this.av--;
/* 1370 */         if (this.av <= 0) {
/* 1371 */           p(i - 1);
/*      */         }
/*      */       } 
/*      */       
/* 1375 */       for (int j = 0; j < 5; j++) {
/* 1376 */         ItemStack itemstack = this.g[j];
/* 1377 */         ItemStack itemstack1 = getEquipment(j);
/*      */         
/* 1379 */         if (!ItemStack.matches(itemstack1, itemstack)) {
/* 1380 */           ((WorldServer)this.world).getTracker().a(this, new PacketPlayOutEntityEquipment(getId(), j, itemstack1));
/* 1381 */           if (itemstack != null) {
/* 1382 */             this.d.a(itemstack.D());
/*      */           }
/*      */           
/* 1385 */           if (itemstack1 != null) {
/* 1386 */             this.d.b(itemstack1.D());
/*      */           }
/*      */           
/* 1389 */           this.g[j] = (itemstack1 == null) ? null : itemstack1.cloneItemStack();
/*      */         } 
/*      */       } 
/*      */       
/* 1393 */       if (this.ticksLived % 20 == 0) {
/* 1394 */         aW().g();
/*      */       }
/*      */     } 
/*      */     
/* 1398 */     e();
/* 1399 */     double d0 = this.locX - this.lastX;
/* 1400 */     double d1 = this.locZ - this.lastZ;
/* 1401 */     float f = (float)(d0 * d0 + d1 * d1);
/* 1402 */     float f1 = this.aM;
/* 1403 */     float f2 = 0.0F;
/*      */     
/* 1405 */     this.aV = this.aW;
/* 1406 */     float f3 = 0.0F;
/*      */     
/* 1408 */     if (f > 0.0025000002F) {
/* 1409 */       f3 = 1.0F;
/* 1410 */       f2 = (float)Math.sqrt(f) * 3.0F;
/*      */       
/* 1412 */       f1 = (float)TrigMath.atan2(d1, d0) * 180.0F / 3.1415927F - 90.0F;
/*      */     } 
/*      */     
/* 1415 */     if (this.aD > 0.0F) {
/* 1416 */       f1 = this.yaw;
/*      */     }
/*      */     
/* 1419 */     if (!this.onGround) {
/* 1420 */       f3 = 0.0F;
/*      */     }
/*      */     
/* 1423 */     this.aW += (f3 - this.aW) * 0.3F;
/* 1424 */     this.world.methodProfiler.a("headTurn");
/* 1425 */     f2 = f(f1, f2);
/* 1426 */     this.world.methodProfiler.b();
/* 1427 */     this.world.methodProfiler.a("rangeChecks");
/*      */     
/* 1429 */     while (this.yaw - this.lastYaw < -180.0F) {
/* 1430 */       this.lastYaw -= 360.0F;
/*      */     }
/*      */     
/* 1433 */     while (this.yaw - this.lastYaw >= 180.0F) {
/* 1434 */       this.lastYaw += 360.0F;
/*      */     }
/*      */     
/* 1437 */     while (this.aM - this.aN < -180.0F) {
/* 1438 */       this.aN -= 360.0F;
/*      */     }
/*      */     
/* 1441 */     while (this.aM - this.aN >= 180.0F) {
/* 1442 */       this.aN += 360.0F;
/*      */     }
/*      */     
/* 1445 */     while (this.pitch - this.lastPitch < -180.0F) {
/* 1446 */       this.lastPitch -= 360.0F;
/*      */     }
/*      */     
/* 1449 */     while (this.pitch - this.lastPitch >= 180.0F) {
/* 1450 */       this.lastPitch += 360.0F;
/*      */     }
/*      */     
/* 1453 */     while (this.aO - this.aP < -180.0F) {
/* 1454 */       this.aP -= 360.0F;
/*      */     }
/*      */     
/* 1457 */     while (this.aO - this.aP >= 180.0F) {
/* 1458 */       this.aP += 360.0F;
/*      */     }
/*      */     
/* 1461 */     this.world.methodProfiler.b();
/* 1462 */     this.aX += f2;
/*      */   }
/*      */   
/*      */   protected float f(float f, float f1) {
/* 1466 */     float f2 = MathHelper.g(f - this.aM);
/*      */     
/* 1468 */     this.aM += f2 * 0.3F;
/* 1469 */     float f3 = MathHelper.g(this.yaw - this.aM);
/* 1470 */     boolean flag = (f3 < -90.0F || f3 >= 90.0F);
/*      */     
/* 1472 */     if (f3 < -75.0F) {
/* 1473 */       f3 = -75.0F;
/*      */     }
/*      */     
/* 1476 */     if (f3 >= 75.0F) {
/* 1477 */       f3 = 75.0F;
/*      */     }
/*      */     
/* 1480 */     this.aM = this.yaw - f3;
/* 1481 */     if (f3 * f3 > 2500.0F) {
/* 1482 */       this.aM += f3 * 0.2F;
/*      */     }
/*      */     
/* 1485 */     if (flag) {
/* 1486 */       f1 *= -1.0F;
/*      */     }
/*      */     
/* 1489 */     return f1;
/*      */   }
/*      */   
/*      */   public void e() {
/* 1493 */     if (this.bq > 0) {
/* 1494 */       this.bq--;
/*      */     }
/*      */     
/* 1497 */     if (this.bg > 0) {
/* 1498 */       double d0 = this.locX + (this.bh - this.locX) / this.bg;
/* 1499 */       double d1 = this.locY + (this.bi - this.locY) / this.bg;
/* 1500 */       double d2 = this.locZ + (this.bj - this.locZ) / this.bg;
/* 1501 */       double d3 = MathHelper.g(this.bk - this.yaw);
/*      */       
/* 1503 */       this.yaw = (float)(this.yaw + d3 / this.bg);
/* 1504 */       this.pitch = (float)(this.pitch + (this.bl - this.pitch) / this.bg);
/* 1505 */       this.bg--;
/* 1506 */       setPosition(d0, d1, d2);
/* 1507 */       b(this.yaw, this.pitch);
/* 1508 */     } else if (!br()) {
/* 1509 */       this.motX *= 0.98D;
/* 1510 */       this.motY *= 0.98D;
/* 1511 */       this.motZ *= 0.98D;
/*      */     } 
/*      */     
/* 1514 */     if (Math.abs(this.motX) < 0.005D) {
/* 1515 */       this.motX = 0.0D;
/*      */     }
/*      */     
/* 1518 */     if (Math.abs(this.motY) < 0.005D) {
/* 1519 */       this.motY = 0.0D;
/*      */     }
/*      */     
/* 1522 */     if (Math.abs(this.motZ) < 0.005D) {
/* 1523 */       this.motZ = 0.0D;
/*      */     }
/*      */     
/* 1526 */     this.world.methodProfiler.a("ai");
/* 1527 */     if (bh()) {
/* 1528 */       this.bc = false;
/* 1529 */       this.bd = 0.0F;
/* 1530 */       this.be = 0.0F;
/* 1531 */       this.bf = 0.0F;
/* 1532 */     } else if (br()) {
/* 1533 */       if (bk()) {
/* 1534 */         this.world.methodProfiler.a("newAi");
/* 1535 */         bn();
/* 1536 */         this.world.methodProfiler.b();
/*      */       } else {
/* 1538 */         this.world.methodProfiler.a("oldAi");
/* 1539 */         bq();
/* 1540 */         this.world.methodProfiler.b();
/* 1541 */         this.aO = this.yaw;
/*      */       } 
/*      */     } 
/*      */     
/* 1545 */     this.world.methodProfiler.b();
/* 1546 */     this.world.methodProfiler.a("jump");
/* 1547 */     if (this.bc) {
/* 1548 */       if (!M() && !P()) {
/* 1549 */         if (this.onGround && this.bq == 0) {
/* 1550 */           bj();
/* 1551 */           this.bq = 10;
/*      */         } 
/*      */       } else {
/* 1554 */         this.motY += 0.03999999910593033D;
/*      */       } 
/*      */     } else {
/* 1557 */       this.bq = 0;
/*      */     } 
/*      */     
/* 1560 */     this.world.methodProfiler.b();
/* 1561 */     this.world.methodProfiler.a("travel");
/* 1562 */     this.bd *= 0.98F;
/* 1563 */     this.be *= 0.98F;
/* 1564 */     this.bf *= 0.9F;
/* 1565 */     e(this.bd, this.be);
/* 1566 */     this.world.methodProfiler.b();
/* 1567 */     this.world.methodProfiler.a("push");
/* 1568 */     if (!this.world.isStatic) {
/* 1569 */       bo();
/*      */     }
/*      */     
/* 1572 */     this.world.methodProfiler.b();
/*      */   }
/*      */   
/*      */   protected void bn() {}
/*      */   
/*      */   protected void bo() {
/* 1578 */     List<Entity> list = this.world.getEntities(this, this.boundingBox.grow(0.20000000298023224D, 0.0D, 0.20000000298023224D));
/*      */     
/* 1580 */     if (list != null && !list.isEmpty())
/* 1581 */       for (int i = 0; i < list.size(); i++) {
/* 1582 */         Entity entity = list.get(i);
/*      */ 
/*      */ 
/*      */         
/* 1586 */         if (!(entity instanceof EntityLiving) || this instanceof EntityPlayer || this.ticksLived % 2 != 0)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1591 */           if (entity.S()) {
/* 1592 */             o(entity);
/*      */           }
/*      */         }
/*      */       }  
/*      */   }
/*      */   
/*      */   protected void o(Entity entity) {
/* 1599 */     entity.collide(this);
/*      */   }
/*      */   
/*      */   public void ab() {
/* 1603 */     super.ab();
/* 1604 */     this.aV = this.aW;
/* 1605 */     this.aW = 0.0F;
/* 1606 */     this.fallDistance = 0.0F;
/*      */   }
/*      */   
/*      */   protected void bp() {}
/*      */   
/*      */   protected void bq() {
/* 1612 */     this.aU++;
/*      */   }
/*      */   
/*      */   public void f(boolean flag) {
/* 1616 */     this.bc = flag;
/*      */   }
/*      */   
/*      */   public void receive(Entity entity, int i) {
/* 1620 */     if (!entity.dead && !this.world.isStatic) {
/* 1621 */       EntityTracker entitytracker = ((WorldServer)this.world).getTracker();
/*      */       
/* 1623 */       if (entity instanceof EntityItem) {
/* 1624 */         entitytracker.a(entity, new PacketPlayOutCollect(entity.getId(), getId()));
/*      */       }
/*      */       
/* 1627 */       if (entity instanceof EntityArrow) {
/* 1628 */         entitytracker.a(entity, new PacketPlayOutCollect(entity.getId(), getId()));
/*      */       }
/*      */       
/* 1631 */       if (entity instanceof EntityExperienceOrb) {
/* 1632 */         entitytracker.a(entity, new PacketPlayOutCollect(entity.getId(), getId()));
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean hasLineOfSight(Entity entity) {
/* 1638 */     return (this.world.a(Vec3D.a(this.locX, this.locY + getHeadHeight(), this.locZ), Vec3D.a(entity.locX, entity.locY + entity.getHeadHeight(), entity.locZ)) == null);
/*      */   }
/*      */   
/*      */   public Vec3D ag() {
/* 1642 */     return j(1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Vec3D j(float f) {
/* 1651 */     if (f == 1.0F) {
/* 1652 */       float f7 = MathHelper.cos(-this.yaw * 0.017453292F - 3.1415927F);
/* 1653 */       float f8 = MathHelper.sin(-this.yaw * 0.017453292F - 3.1415927F);
/* 1654 */       float f9 = -MathHelper.cos(-this.pitch * 0.017453292F);
/* 1655 */       float f10 = MathHelper.sin(-this.pitch * 0.017453292F);
/* 1656 */       return Vec3D.a((f8 * f9), f10, (f7 * f9));
/*      */     } 
/* 1658 */     float f1 = this.lastPitch + (this.pitch - this.lastPitch) * f;
/* 1659 */     float f2 = this.lastYaw + (this.yaw - this.lastYaw) * f;
/* 1660 */     float f3 = MathHelper.cos(-f2 * 0.017453292F - 3.1415927F);
/* 1661 */     float f4 = MathHelper.sin(-f2 * 0.017453292F - 3.1415927F);
/* 1662 */     float f5 = -MathHelper.cos(-f1 * 0.017453292F);
/* 1663 */     float f6 = MathHelper.sin(-f1 * 0.017453292F);
/*      */     
/* 1665 */     return Vec3D.a((f4 * f5), f6, (f3 * f5));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean br() {
/* 1670 */     return !this.world.isStatic;
/*      */   }
/*      */   
/*      */   public boolean R() {
/* 1674 */     return !this.dead;
/*      */   }
/*      */   
/*      */   public boolean S() {
/* 1678 */     return !this.dead;
/*      */   }
/*      */   
/*      */   public float getHeadHeight() {
/* 1682 */     return this.length * 0.85F;
/*      */   }
/*      */   
/*      */   protected void Q() {
/* 1686 */     this.velocityChanged = (this.random.nextDouble() >= getAttributeInstance(GenericAttributes.c).getValue());
/*      */   }
/*      */   
/*      */   public float getHeadRotation() {
/* 1690 */     return this.aO;
/*      */   }
/*      */   
/*      */   public float getAbsorptionHearts() {
/* 1694 */     return this.br;
/*      */   }
/*      */   
/*      */   public void setAbsorptionHearts(float f) {
/* 1698 */     if (f < 0.0F) {
/* 1699 */       f = 0.0F;
/*      */     }
/*      */     
/* 1702 */     this.br = f;
/*      */   }
/*      */   
/*      */   public ScoreboardTeamBase getScoreboardTeam() {
/* 1706 */     return null;
/*      */   }
/*      */   
/*      */   public boolean c(EntityLiving entityliving) {
/* 1710 */     return a(entityliving.getScoreboardTeam());
/*      */   }
/*      */   
/*      */   public boolean a(ScoreboardTeamBase scoreboardteambase) {
/* 1714 */     return (getScoreboardTeam() != null) ? getScoreboardTeam().isAlly(scoreboardteambase) : false;
/*      */   }
/*      */   
/*      */   public void bu() {}
/*      */   
/*      */   public void bv() {}
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityLiving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */