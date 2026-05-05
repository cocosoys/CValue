/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.util.Iterator;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.entity.Item;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.player.PlayerPickupItemEvent;
/*     */ 
/*     */ public class EntityItem extends Entity {
/*  12 */   private static final Logger d = LogManager.getLogger();
/*     */   public int age;
/*     */   public int pickupDelay;
/*     */   private int e;
/*     */   private String f;
/*     */   private String g;
/*     */   public float c;
/*  19 */   private int lastTick = MinecraftServer.currentTick;
/*     */   
/*     */   public EntityItem(World world, double d0, double d1, double d2) {
/*  22 */     super(world);
/*  23 */     this.e = 5;
/*  24 */     this.c = (float)(Math.random() * Math.PI * 2.0D);
/*  25 */     a(0.25F, 0.25F);
/*  26 */     this.height = this.length / 2.0F;
/*  27 */     setPosition(d0, d1, d2);
/*  28 */     this.yaw = (float)(Math.random() * 360.0D);
/*  29 */     this.motX = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D);
/*  30 */     this.motY = 0.20000000298023224D;
/*  31 */     this.motZ = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D);
/*     */   }
/*     */   
/*     */   public EntityItem(World world, double d0, double d1, double d2, ItemStack itemstack) {
/*  35 */     this(world, d0, d1, d2);
/*     */     
/*  37 */     if (itemstack == null || itemstack.getItem() == null) {
/*     */       return;
/*     */     }
/*     */     
/*  41 */     setItemStack(itemstack);
/*     */   }
/*     */   
/*     */   protected boolean g_() {
/*  45 */     return false;
/*     */   }
/*     */   
/*     */   public EntityItem(World world) {
/*  49 */     super(world);
/*  50 */     this.e = 5;
/*  51 */     this.c = (float)(Math.random() * Math.PI * 2.0D);
/*  52 */     a(0.25F, 0.25F);
/*  53 */     this.height = this.length / 2.0F;
/*     */   }
/*     */   
/*     */   protected void c() {
/*  57 */     getDataWatcher().add(10, 5);
/*     */   }
/*     */   
/*     */   public void h() {
/*  61 */     if (getItemStack() == null) {
/*  62 */       die();
/*     */     } else {
/*  64 */       super.h();
/*     */       
/*  66 */       int elapsedTicks = MinecraftServer.currentTick - this.lastTick;
/*  67 */       this.pickupDelay -= elapsedTicks;
/*  68 */       this.age += elapsedTicks;
/*  69 */       this.lastTick = MinecraftServer.currentTick;
/*     */ 
/*     */       
/*  72 */       this.lastX = this.locX;
/*  73 */       this.lastY = this.locY;
/*  74 */       this.lastZ = this.locZ;
/*  75 */       this.motY -= 0.03999999910593033D;
/*  76 */       this.X = j(this.locX, (this.boundingBox.b + this.boundingBox.e) / 2.0D, this.locZ);
/*  77 */       move(this.motX, this.motY, this.motZ);
/*  78 */       boolean flag = ((int)this.lastX != (int)this.locX || (int)this.lastY != (int)this.locY || (int)this.lastZ != (int)this.locZ);
/*     */       
/*  80 */       if (flag || this.ticksLived % 25 == 0) {
/*  81 */         if (this.world.getType(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ)).getMaterial() == Material.LAVA) {
/*  82 */           this.motY = 0.20000000298023224D;
/*  83 */           this.motX = ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
/*  84 */           this.motZ = ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
/*  85 */           makeSound("random.fizz", 0.4F, 2.0F + this.random.nextFloat() * 0.4F);
/*     */         } 
/*     */         
/*  88 */         if (!this.world.isStatic) {
/*  89 */           k();
/*     */         }
/*     */       } 
/*     */       
/*  93 */       float f = 0.98F;
/*     */       
/*  95 */       if (this.onGround) {
/*  96 */         f = (this.world.getType(MathHelper.floor(this.locX), MathHelper.floor(this.boundingBox.b) - 1, MathHelper.floor(this.locZ))).frictionFactor * 0.98F;
/*     */       }
/*     */       
/*  99 */       this.motX *= f;
/* 100 */       this.motY *= 0.9800000190734863D;
/* 101 */       this.motZ *= f;
/* 102 */       if (this.onGround) {
/* 103 */         this.motY *= -0.5D;
/*     */       }
/*     */ 
/*     */       
/* 107 */       if (!this.world.isStatic && this.age >= 6000) {
/*     */         
/* 109 */         if (CraftEventFactory.callItemDespawnEvent(this).isCancelled()) {
/* 110 */           this.age = 0;
/*     */           
/*     */           return;
/*     */         } 
/* 114 */         die();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void k() {
/* 120 */     Iterator<EntityItem> iterator = this.world.a(EntityItem.class, this.boundingBox.grow(0.5D, 0.0D, 0.5D)).iterator();
/*     */     
/* 122 */     while (iterator.hasNext()) {
/* 123 */       EntityItem entityitem = iterator.next();
/*     */       
/* 125 */       a(entityitem);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean a(EntityItem entityitem) {
/* 130 */     if (entityitem == this)
/* 131 */       return false; 
/* 132 */     if (entityitem.isAlive() && isAlive()) {
/* 133 */       ItemStack itemstack = getItemStack();
/* 134 */       ItemStack itemstack1 = entityitem.getItemStack();
/*     */       
/* 136 */       if (itemstack1.getItem() != itemstack.getItem())
/* 137 */         return false; 
/* 138 */       if ((itemstack1.hasTag() ^ itemstack.hasTag()) != 0)
/* 139 */         return false; 
/* 140 */       if (itemstack1.hasTag() && !itemstack1.getTag().equals(itemstack.getTag()))
/* 141 */         return false; 
/* 142 */       if (itemstack1.getItem() == null)
/* 143 */         return false; 
/* 144 */       if (itemstack1.getItem().n() && itemstack1.getData() != itemstack.getData())
/* 145 */         return false; 
/* 146 */       if (itemstack1.count < itemstack.count)
/* 147 */         return entityitem.a(this); 
/* 148 */       if (itemstack1.count + itemstack.count > itemstack1.getMaxStackSize()) {
/* 149 */         return false;
/*     */       }
/* 151 */       itemstack1.count += itemstack.count;
/* 152 */       entityitem.pickupDelay = Math.max(entityitem.pickupDelay, this.pickupDelay);
/* 153 */       entityitem.age = Math.min(entityitem.age, this.age);
/* 154 */       entityitem.setItemStack(itemstack1);
/* 155 */       die();
/* 156 */       return true;
/*     */     } 
/*     */     
/* 159 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void e() {
/* 164 */     this.age = 4800;
/*     */   }
/*     */   
/*     */   public boolean N() {
/* 168 */     return this.world.a(this.boundingBox, Material.WATER, this);
/*     */   }
/*     */   
/*     */   protected void burn(int i) {
/* 172 */     damageEntity(DamageSource.FIRE, i);
/*     */   }
/*     */   
/*     */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 176 */     if (isInvulnerable())
/* 177 */       return false; 
/* 178 */     if (getItemStack() != null && getItemStack().getItem() == Items.NETHER_STAR && damagesource.isExplosion()) {
/* 179 */       return false;
/*     */     }
/* 181 */     Q();
/* 182 */     this.e = (int)(this.e - f);
/* 183 */     if (this.e <= 0) {
/* 184 */       die();
/*     */     }
/*     */     
/* 187 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/* 192 */     nbttagcompound.setShort("Health", (short)(byte)this.e);
/* 193 */     nbttagcompound.setShort("Age", (short)this.age);
/* 194 */     if (j() != null) {
/* 195 */       nbttagcompound.setString("Thrower", this.f);
/*     */     }
/*     */     
/* 198 */     if (i() != null) {
/* 199 */       nbttagcompound.setString("Owner", this.g);
/*     */     }
/*     */     
/* 202 */     if (getItemStack() != null) {
/* 203 */       nbttagcompound.set("Item", getItemStack().save(new NBTTagCompound()));
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 208 */     this.e = nbttagcompound.getShort("Health") & 0xFF;
/* 209 */     this.age = nbttagcompound.getShort("Age");
/* 210 */     if (nbttagcompound.hasKey("Owner")) {
/* 211 */       this.g = nbttagcompound.getString("Owner");
/*     */     }
/*     */     
/* 214 */     if (nbttagcompound.hasKey("Thrower")) {
/* 215 */       this.f = nbttagcompound.getString("Thrower");
/*     */     }
/*     */     
/* 218 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompound("Item");
/*     */ 
/*     */     
/* 221 */     if (nbttagcompound1 != null) {
/* 222 */       ItemStack itemstack = ItemStack.createStack(nbttagcompound1);
/* 223 */       if (itemstack != null) {
/* 224 */         setItemStack(itemstack);
/*     */       } else {
/* 226 */         die();
/*     */       } 
/*     */     } else {
/* 229 */       die();
/*     */     } 
/*     */     
/* 232 */     if (getItemStack() == null) {
/* 233 */       die();
/*     */     }
/*     */   }
/*     */   
/*     */   public void b_(EntityHuman entityhuman) {
/* 238 */     if (!this.world.isStatic) {
/* 239 */       ItemStack itemstack = getItemStack();
/* 240 */       int i = itemstack.count;
/*     */ 
/*     */       
/* 243 */       int canHold = entityhuman.inventory.canHold(itemstack);
/* 244 */       int remaining = itemstack.count - canHold;
/*     */       
/* 246 */       if (this.pickupDelay <= 0 && canHold > 0) {
/* 247 */         itemstack.count = canHold;
/* 248 */         PlayerPickupItemEvent event = new PlayerPickupItemEvent((Player)entityhuman.getBukkitEntity(), (Item)getBukkitEntity(), remaining);
/*     */         
/* 250 */         this.world.getServer().getPluginManager().callEvent((Event)event);
/* 251 */         itemstack.count = canHold + remaining;
/*     */         
/* 253 */         if (event.isCancelled()) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/* 258 */         this.pickupDelay = 0;
/*     */       } 
/*     */ 
/*     */       
/* 262 */       if (this.pickupDelay == 0 && (this.g == null || 6000 - this.age <= 200 || this.g.equals(entityhuman.getName())) && entityhuman.inventory.pickup(itemstack)) {
/* 263 */         if (itemstack.getItem() == Item.getItemOf(Blocks.LOG)) {
/* 264 */           entityhuman.a(AchievementList.g);
/*     */         }
/*     */         
/* 267 */         if (itemstack.getItem() == Item.getItemOf(Blocks.LOG2)) {
/* 268 */           entityhuman.a(AchievementList.g);
/*     */         }
/*     */         
/* 271 */         if (itemstack.getItem() == Items.LEATHER) {
/* 272 */           entityhuman.a(AchievementList.t);
/*     */         }
/*     */         
/* 275 */         if (itemstack.getItem() == Items.DIAMOND) {
/* 276 */           entityhuman.a(AchievementList.w);
/*     */         }
/*     */         
/* 279 */         if (itemstack.getItem() == Items.BLAZE_ROD) {
/* 280 */           entityhuman.a(AchievementList.A);
/*     */         }
/*     */         
/* 283 */         if (itemstack.getItem() == Items.DIAMOND && j() != null) {
/* 284 */           EntityHuman entityhuman1 = this.world.a(j());
/*     */           
/* 286 */           if (entityhuman1 != null && entityhuman1 != entityhuman) {
/* 287 */             entityhuman1.a(AchievementList.x);
/*     */           }
/*     */         } 
/*     */         
/* 291 */         this.world.makeSound(entityhuman, "random.pop", 0.2F, ((this.random.nextFloat() - this.random.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 292 */         entityhuman.receive(this, i);
/* 293 */         if (itemstack.count <= 0) {
/* 294 */           die();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getName() {
/* 301 */     return LocaleI18n.get("item." + getItemStack().a());
/*     */   }
/*     */   
/*     */   public boolean av() {
/* 305 */     return false;
/*     */   }
/*     */   
/*     */   public void b(int i) {
/* 309 */     super.b(i);
/* 310 */     if (!this.world.isStatic) {
/* 311 */       k();
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack getItemStack() {
/* 316 */     ItemStack itemstack = getDataWatcher().getItemStack(10);
/*     */     
/* 318 */     return (itemstack == null) ? new ItemStack(Blocks.STONE) : itemstack;
/*     */   }
/*     */   
/*     */   public void setItemStack(ItemStack itemstack) {
/* 322 */     getDataWatcher().watch(10, itemstack);
/* 323 */     getDataWatcher().update(10);
/*     */   }
/*     */   
/*     */   public String i() {
/* 327 */     return this.g;
/*     */   }
/*     */   
/*     */   public void a(String s) {
/* 331 */     this.g = s;
/*     */   }
/*     */   
/*     */   public String j() {
/* 335 */     return this.f;
/*     */   }
/*     */   
/*     */   public void b(String s) {
/* 339 */     this.f = s;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */