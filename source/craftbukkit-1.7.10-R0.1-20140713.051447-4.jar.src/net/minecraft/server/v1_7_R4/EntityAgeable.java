/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*     */ 
/*     */ public abstract class EntityAgeable extends EntityCreature {
/*   5 */   private float bp = -1.0F;
/*     */   private float bq;
/*     */   public boolean ageLocked = false;
/*     */   
/*     */   public EntityAgeable(World world) {
/*  10 */     super(world);
/*     */   }
/*     */   
/*     */   public abstract EntityAgeable createChild(EntityAgeable paramEntityAgeable);
/*     */   
/*     */   public boolean a(EntityHuman entityhuman) {
/*  16 */     ItemStack itemstack = entityhuman.inventory.getItemInHand();
/*     */     
/*  18 */     if (itemstack != null && itemstack.getItem() == Items.MONSTER_EGG) {
/*  19 */       if (!this.world.isStatic) {
/*  20 */         Class oclass = EntityTypes.a(itemstack.getData());
/*     */         
/*  22 */         if (oclass != null && oclass.isAssignableFrom(getClass())) {
/*  23 */           EntityAgeable entityageable = createChild(this);
/*     */           
/*  25 */           if (entityageable != null) {
/*  26 */             entityageable.setAge(-24000);
/*  27 */             entityageable.setPositionRotation(this.locX, this.locY, this.locZ, 0.0F, 0.0F);
/*  28 */             this.world.addEntity(entityageable, CreatureSpawnEvent.SpawnReason.SPAWNER_EGG);
/*  29 */             if (itemstack.hasName()) {
/*  30 */               entityageable.setCustomName(itemstack.getName());
/*     */             }
/*     */             
/*  33 */             if (!entityhuman.abilities.canInstantlyBuild) {
/*  34 */               itemstack.count--;
/*  35 */               if (itemstack.count == 0) {
/*  36 */                 entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack)null);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  43 */       return true;
/*     */     } 
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void c() {
/*  50 */     super.c();
/*  51 */     this.datawatcher.a(12, new Integer(0));
/*     */   }
/*     */   
/*     */   public int getAge() {
/*  55 */     return this.datawatcher.getInt(12);
/*     */   }
/*     */   
/*     */   public void a(int i) {
/*  59 */     int j = getAge();
/*     */     
/*  61 */     j += i * 20;
/*  62 */     if (j > 0) {
/*  63 */       j = 0;
/*     */     }
/*     */     
/*  66 */     setAge(j);
/*     */   }
/*     */   
/*     */   public void setAge(int i) {
/*  70 */     this.datawatcher.watch(12, Integer.valueOf(i));
/*  71 */     a(isBaby());
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/*  75 */     super.b(nbttagcompound);
/*  76 */     nbttagcompound.setInt("Age", getAge());
/*  77 */     nbttagcompound.setBoolean("AgeLocked", this.ageLocked);
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/*  81 */     super.a(nbttagcompound);
/*  82 */     setAge(nbttagcompound.getInt("Age"));
/*  83 */     this.ageLocked = nbttagcompound.getBoolean("AgeLocked");
/*     */   }
/*     */   
/*     */   public void e() {
/*  87 */     super.e();
/*  88 */     if (this.world.isStatic || this.ageLocked) {
/*  89 */       a(isBaby());
/*     */     } else {
/*  91 */       int i = getAge();
/*     */       
/*  93 */       if (i < 0) {
/*  94 */         i++;
/*  95 */         setAge(i);
/*  96 */       } else if (i > 0) {
/*  97 */         i--;
/*  98 */         setAge(i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isBaby() {
/* 104 */     return (getAge() < 0);
/*     */   }
/*     */   
/*     */   public void a(boolean flag) {
/* 108 */     a(flag ? 0.5F : 1.0F);
/*     */   }
/*     */   
/*     */   protected final void a(float f, float f1) {
/* 112 */     boolean flag = (this.bp > 0.0F);
/*     */     
/* 114 */     this.bp = f;
/* 115 */     this.bq = f1;
/* 116 */     if (!flag) {
/* 117 */       a(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void a(float f) {
/* 122 */     super.a(this.bp * f, this.bq * f);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityAgeable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */