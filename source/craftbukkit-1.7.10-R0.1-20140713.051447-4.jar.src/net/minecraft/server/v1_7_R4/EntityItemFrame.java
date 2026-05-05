/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ 
/*     */ public class EntityItemFrame extends EntityHanging {
/*   5 */   private float e = 1.0F;
/*     */   
/*     */   public EntityItemFrame(World world) {
/*   8 */     super(world);
/*     */   }
/*     */   
/*     */   public EntityItemFrame(World world, int i, int j, int k, int l) {
/*  12 */     super(world, i, j, k, l);
/*  13 */     setDirection(l);
/*     */   }
/*     */   
/*     */   protected void c() {
/*  17 */     getDataWatcher().add(2, 5);
/*  18 */     getDataWatcher().a(3, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public boolean damageEntity(DamageSource damagesource, float f) {
/*  22 */     if (isInvulnerable())
/*  23 */       return false; 
/*  24 */     if (getItem() != null) {
/*  25 */       if (!this.world.isStatic) {
/*     */         
/*  27 */         if (CraftEventFactory.handleNonLivingEntityDamageEvent(this, damagesource, f) || this.dead) {
/*  28 */           return true;
/*     */         }
/*     */ 
/*     */         
/*  32 */         b(damagesource.getEntity(), false);
/*  33 */         setItem((ItemStack)null);
/*     */       } 
/*     */       
/*  36 */       return true;
/*     */     } 
/*  38 */     return super.damageEntity(damagesource, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public int f() {
/*  43 */     return 9;
/*     */   }
/*     */   
/*     */   public int i() {
/*  47 */     return 9;
/*     */   }
/*     */   
/*     */   public void b(Entity entity) {
/*  51 */     b(entity, true);
/*     */   }
/*     */   
/*     */   public void b(Entity entity, boolean flag) {
/*  55 */     ItemStack itemstack = getItem();
/*     */     
/*  57 */     if (entity instanceof EntityHuman) {
/*  58 */       EntityHuman entityhuman = (EntityHuman)entity;
/*     */       
/*  60 */       if (entityhuman.abilities.canInstantlyBuild) {
/*  61 */         b(itemstack);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  66 */     if (flag) {
/*  67 */       a(new ItemStack(Items.ITEM_FRAME), 0.0F);
/*     */     }
/*     */     
/*  70 */     if (itemstack != null && this.random.nextFloat() < this.e) {
/*  71 */       itemstack = itemstack.cloneItemStack();
/*  72 */       b(itemstack);
/*  73 */       a(itemstack, 0.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(ItemStack itemstack) {
/*  78 */     if (itemstack != null) {
/*  79 */       if (itemstack.getItem() == Items.MAP) {
/*  80 */         WorldMap worldmap = ((ItemWorldMap)itemstack.getItem()).getSavedMap(itemstack, this.world);
/*     */         
/*  82 */         worldmap.decorations.remove("frame-" + getId());
/*     */       } 
/*     */       
/*  85 */       itemstack.a((EntityItemFrame)null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ItemStack getItem() {
/*  90 */     return getDataWatcher().getItemStack(2);
/*     */   }
/*     */   
/*     */   public void setItem(ItemStack itemstack) {
/*  94 */     if (itemstack != null) {
/*  95 */       itemstack = itemstack.cloneItemStack();
/*  96 */       itemstack.count = 1;
/*  97 */       itemstack.a(this);
/*     */     } 
/*     */     
/* 100 */     getDataWatcher().watch(2, itemstack);
/* 101 */     getDataWatcher().update(2);
/*     */   }
/*     */   
/*     */   public int getRotation() {
/* 105 */     return getDataWatcher().getByte(3);
/*     */   }
/*     */   
/*     */   public void setRotation(int i) {
/* 109 */     getDataWatcher().watch(3, Byte.valueOf((byte)(i % 4)));
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/* 113 */     if (getItem() != null) {
/* 114 */       nbttagcompound.set("Item", getItem().save(new NBTTagCompound()));
/* 115 */       nbttagcompound.setByte("ItemRotation", (byte)getRotation());
/* 116 */       nbttagcompound.setFloat("ItemDropChance", this.e);
/*     */     } 
/*     */     
/* 119 */     super.b(nbttagcompound);
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 123 */     NBTTagCompound nbttagcompound1 = nbttagcompound.getCompound("Item");
/*     */     
/* 125 */     if (nbttagcompound1 != null && !nbttagcompound1.isEmpty()) {
/* 126 */       setItem(ItemStack.createStack(nbttagcompound1));
/* 127 */       setRotation(nbttagcompound.getByte("ItemRotation"));
/* 128 */       if (nbttagcompound.hasKeyOfType("ItemDropChance", 99)) {
/* 129 */         this.e = nbttagcompound.getFloat("ItemDropChance");
/*     */       }
/*     */     } 
/*     */     
/* 133 */     super.a(nbttagcompound);
/*     */   }
/*     */   
/*     */   public boolean c(EntityHuman entityhuman) {
/* 137 */     if (getItem() == null) {
/* 138 */       ItemStack itemstack = entityhuman.be();
/*     */       
/* 140 */       if (itemstack != null && !this.world.isStatic) {
/* 141 */         setItem(itemstack);
/* 142 */         if (!entityhuman.abilities.canInstantlyBuild && --itemstack.count <= 0) {
/* 143 */           entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack)null);
/*     */         }
/*     */       } 
/* 146 */     } else if (!this.world.isStatic) {
/* 147 */       setRotation(getRotation() + 1);
/*     */     } 
/*     */     
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityItemFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */