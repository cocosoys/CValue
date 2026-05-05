/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftHumanEntity;
/*     */ import org.bukkit.entity.HumanEntity;
/*     */ import org.bukkit.inventory.InventoryHolder;
/*     */ 
/*     */ public abstract class EntityMinecartContainer
/*     */   extends EntityMinecartAbstract
/*     */   implements IInventory {
/*  13 */   private ItemStack[] items = new ItemStack[27];
/*     */   
/*     */   private boolean b = true;
/*     */   
/*  17 */   public List<HumanEntity> transaction = new ArrayList<HumanEntity>();
/*  18 */   private int maxStack = 64;
/*     */   
/*     */   public ItemStack[] getContents() {
/*  21 */     return this.items;
/*     */   }
/*     */   
/*     */   public void onOpen(CraftHumanEntity who) {
/*  25 */     this.transaction.add(who);
/*     */   }
/*     */   
/*     */   public void onClose(CraftHumanEntity who) {
/*  29 */     this.transaction.remove(who);
/*     */   }
/*     */   
/*     */   public List<HumanEntity> getViewers() {
/*  33 */     return this.transaction;
/*     */   }
/*     */   
/*     */   public InventoryHolder getOwner() {
/*  37 */     CraftEntity craftEntity = getBukkitEntity();
/*  38 */     if (craftEntity instanceof InventoryHolder) return (InventoryHolder)craftEntity; 
/*  39 */     return null;
/*     */   }
/*     */   
/*     */   public void setMaxStackSize(int size) {
/*  43 */     this.maxStack = size;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityMinecartContainer(World world) {
/*  48 */     super(world);
/*     */   }
/*     */   
/*     */   public EntityMinecartContainer(World world, double d0, double d1, double d2) {
/*  52 */     super(world, d0, d1, d2);
/*     */   }
/*     */   
/*     */   public void a(DamageSource damagesource) {
/*  56 */     super.a(damagesource);
/*     */     
/*  58 */     for (int i = 0; i < getSize(); i++) {
/*  59 */       ItemStack itemstack = getItem(i);
/*     */       
/*  61 */       if (itemstack != null) {
/*  62 */         float f = this.random.nextFloat() * 0.8F + 0.1F;
/*  63 */         float f1 = this.random.nextFloat() * 0.8F + 0.1F;
/*  64 */         float f2 = this.random.nextFloat() * 0.8F + 0.1F;
/*     */         
/*  66 */         while (itemstack.count > 0) {
/*  67 */           int j = this.random.nextInt(21) + 10;
/*     */           
/*  69 */           if (j > itemstack.count) {
/*  70 */             j = itemstack.count;
/*     */           }
/*     */           
/*  73 */           itemstack.count -= j;
/*  74 */           EntityItem entityitem = new EntityItem(this.world, this.locX + f, this.locY + f1, this.locZ + f2, new ItemStack(itemstack.getItem(), j, itemstack.getData()));
/*  75 */           float f3 = 0.05F;
/*     */           
/*  77 */           entityitem.motX = ((float)this.random.nextGaussian() * f3);
/*  78 */           entityitem.motY = ((float)this.random.nextGaussian() * f3 + 0.2F);
/*  79 */           entityitem.motZ = ((float)this.random.nextGaussian() * f3);
/*  80 */           this.world.addEntity(entityitem);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public ItemStack getItem(int i) {
/*  87 */     return this.items[i];
/*     */   }
/*     */   
/*     */   public ItemStack splitStack(int i, int j) {
/*  91 */     if (this.items[i] != null) {
/*     */ 
/*     */       
/*  94 */       if ((this.items[i]).count <= j) {
/*  95 */         ItemStack itemStack = this.items[i];
/*  96 */         this.items[i] = null;
/*  97 */         return itemStack;
/*     */       } 
/*  99 */       ItemStack itemstack = this.items[i].a(j);
/* 100 */       if ((this.items[i]).count == 0) {
/* 101 */         this.items[i] = null;
/*     */       }
/*     */       
/* 104 */       return itemstack;
/*     */     } 
/*     */     
/* 107 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack splitWithoutUpdate(int i) {
/* 112 */     if (this.items[i] != null) {
/* 113 */       ItemStack itemstack = this.items[i];
/*     */       
/* 115 */       this.items[i] = null;
/* 116 */       return itemstack;
/*     */     } 
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItem(int i, ItemStack itemstack) {
/* 123 */     this.items[i] = itemstack;
/* 124 */     if (itemstack != null && itemstack.count > getMaxStackSize()) {
/* 125 */       itemstack.count = getMaxStackSize();
/*     */     }
/*     */   }
/*     */   
/*     */   public void update() {}
/*     */   
/*     */   public boolean a(EntityHuman entityhuman) {
/* 132 */     return this.dead ? false : ((entityhuman.f(this) <= 64.0D));
/*     */   }
/*     */   
/*     */   public void startOpen() {}
/*     */   
/*     */   public void closeContainer() {}
/*     */   
/*     */   public boolean b(int i, ItemStack itemstack) {
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   public String getInventoryName() {
/* 144 */     return k_() ? u() : "container.minecart";
/*     */   }
/*     */   
/*     */   public int getMaxStackSize() {
/* 148 */     return this.maxStack;
/*     */   }
/*     */   
/*     */   public void b(int i) {
/* 152 */     this.b = false;
/* 153 */     super.b(i);
/*     */   }
/*     */   
/*     */   public void die() {
/* 157 */     if (this.b) {
/* 158 */       for (int i = 0; i < getSize(); i++) {
/* 159 */         ItemStack itemstack = getItem(i);
/*     */         
/* 161 */         if (itemstack != null) {
/* 162 */           float f = this.random.nextFloat() * 0.8F + 0.1F;
/* 163 */           float f1 = this.random.nextFloat() * 0.8F + 0.1F;
/* 164 */           float f2 = this.random.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 166 */           while (itemstack.count > 0) {
/* 167 */             int j = this.random.nextInt(21) + 10;
/*     */             
/* 169 */             if (j > itemstack.count) {
/* 170 */               j = itemstack.count;
/*     */             }
/*     */             
/* 173 */             itemstack.count -= j;
/* 174 */             EntityItem entityitem = new EntityItem(this.world, this.locX + f, this.locY + f1, this.locZ + f2, new ItemStack(itemstack.getItem(), j, itemstack.getData()));
/*     */             
/* 176 */             if (itemstack.hasTag()) {
/* 177 */               entityitem.getItemStack().setTag((NBTTagCompound)itemstack.getTag().clone());
/*     */             }
/*     */             
/* 180 */             float f3 = 0.05F;
/*     */             
/* 182 */             entityitem.motX = ((float)this.random.nextGaussian() * f3);
/* 183 */             entityitem.motY = ((float)this.random.nextGaussian() * f3 + 0.2F);
/* 184 */             entityitem.motZ = ((float)this.random.nextGaussian() * f3);
/* 185 */             this.world.addEntity(entityitem);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 191 */     super.die();
/*     */   }
/*     */   
/*     */   protected void b(NBTTagCompound nbttagcompound) {
/* 195 */     super.b(nbttagcompound);
/* 196 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/* 198 */     for (int i = 0; i < this.items.length; i++) {
/* 199 */       if (this.items[i] != null) {
/* 200 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*     */         
/* 202 */         nbttagcompound1.setByte("Slot", (byte)i);
/* 203 */         this.items[i].save(nbttagcompound1);
/* 204 */         nbttaglist.add(nbttagcompound1);
/*     */       } 
/*     */     } 
/*     */     
/* 208 */     nbttagcompound.set("Items", nbttaglist);
/*     */   }
/*     */   
/*     */   protected void a(NBTTagCompound nbttagcompound) {
/* 212 */     super.a(nbttagcompound);
/* 213 */     NBTTagList nbttaglist = nbttagcompound.getList("Items", 10);
/*     */     
/* 215 */     this.items = new ItemStack[getSize()];
/*     */     
/* 217 */     for (int i = 0; i < nbttaglist.size(); i++) {
/* 218 */       NBTTagCompound nbttagcompound1 = nbttaglist.get(i);
/* 219 */       int j = nbttagcompound1.getByte("Slot") & 0xFF;
/*     */       
/* 221 */       if (j >= 0 && j < this.items.length) {
/* 222 */         this.items[j] = ItemStack.createStack(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean c(EntityHuman entityhuman) {
/* 228 */     if (!this.world.isStatic) {
/* 229 */       entityhuman.openContainer(this);
/*     */     }
/*     */     
/* 232 */     return true;
/*     */   }
/*     */   
/*     */   protected void i() {
/* 236 */     int i = 15 - Container.b(this);
/* 237 */     float f = 0.98F + i * 0.001F;
/*     */     
/* 239 */     this.motX *= f;
/* 240 */     this.motY *= 0.0D;
/* 241 */     this.motZ *= f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityMinecartContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */