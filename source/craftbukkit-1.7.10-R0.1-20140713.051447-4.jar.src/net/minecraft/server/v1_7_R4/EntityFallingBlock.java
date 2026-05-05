/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ 
/*     */ public class EntityFallingBlock
/*     */   extends Entity
/*     */ {
/*     */   public Block id;
/*     */   public int data;
/*     */   public int ticksLived;
/*     */   public boolean dropItem;
/*     */   private boolean f;
/*     */   private boolean hurtEntities;
/*     */   private int fallHurtMax;
/*     */   private float fallHurtAmount;
/*     */   public NBTTagCompound tileEntityData;
/*     */   
/*     */   public EntityFallingBlock(World world) {
/*  21 */     super(world);
/*  22 */     this.dropItem = true;
/*  23 */     this.fallHurtMax = 40;
/*  24 */     this.fallHurtAmount = 2.0F;
/*     */   }
/*     */   
/*     */   public EntityFallingBlock(World world, double d0, double d1, double d2, Block block) {
/*  28 */     this(world, d0, d1, d2, block, 0);
/*     */   }
/*     */   
/*     */   public EntityFallingBlock(World world, double d0, double d1, double d2, Block block, int i) {
/*  32 */     super(world);
/*  33 */     this.dropItem = true;
/*  34 */     this.fallHurtMax = 40;
/*  35 */     this.fallHurtAmount = 2.0F;
/*  36 */     this.id = block;
/*  37 */     this.data = i;
/*  38 */     this.k = true;
/*  39 */     a(0.98F, 0.98F);
/*  40 */     this.height = this.length / 2.0F;
/*  41 */     setPosition(d0, d1, d2);
/*  42 */     this.motX = 0.0D;
/*  43 */     this.motY = 0.0D;
/*  44 */     this.motZ = 0.0D;
/*  45 */     this.lastX = d0;
/*  46 */     this.lastY = d1;
/*  47 */     this.lastZ = d2;
/*     */   }
/*     */   
/*     */   protected boolean g_() {
/*  51 */     return false;
/*     */   }
/*     */   
/*     */   protected void c() {}
/*     */   
/*     */   public boolean R() {
/*  57 */     return !this.dead;
/*     */   }
/*     */   
/*     */   public void h() {
/*  61 */     if (this.id.getMaterial() == Material.AIR) {
/*  62 */       die();
/*     */     } else {
/*  64 */       this.lastX = this.locX;
/*  65 */       this.lastY = this.locY;
/*  66 */       this.lastZ = this.locZ;
/*  67 */       this.ticksLived++;
/*  68 */       this.motY -= 0.03999999910593033D;
/*  69 */       move(this.motX, this.motY, this.motZ);
/*  70 */       this.motX *= 0.9800000190734863D;
/*  71 */       this.motY *= 0.9800000190734863D;
/*  72 */       this.motZ *= 0.9800000190734863D;
/*  73 */       if (!this.world.isStatic) {
/*  74 */         int i = MathHelper.floor(this.locX);
/*  75 */         int j = MathHelper.floor(this.locY);
/*  76 */         int k = MathHelper.floor(this.locZ);
/*     */         
/*  78 */         if (this.ticksLived == 1) {
/*     */           
/*  80 */           if (this.ticksLived != 1 || this.world.getType(i, j, k) != this.id || this.world.getData(i, j, k) != this.data || CraftEventFactory.callEntityChangeBlockEvent(this, i, j, k, Blocks.AIR, 0).isCancelled()) {
/*  81 */             die();
/*     */             
/*     */             return;
/*     */           } 
/*  85 */           this.world.setAir(i, j, k);
/*     */         } 
/*     */         
/*  88 */         if (this.onGround) {
/*  89 */           this.motX *= 0.699999988079071D;
/*  90 */           this.motZ *= 0.699999988079071D;
/*  91 */           this.motY *= -0.5D;
/*  92 */           if (this.world.getType(i, j, k) != Blocks.PISTON_MOVING) {
/*  93 */             die();
/*     */             
/*  95 */             if (!this.f && this.world.mayPlace(this.id, i, j, k, true, 1, (Entity)null, (ItemStack)null) && !BlockFalling.canFall(this.world, i, j - 1, k) && i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000 && j > 0 && j < 256 && (this.world.getType(i, j, k) != this.id || this.world.getData(i, j, k) != this.data)) {
/*  96 */               if (CraftEventFactory.callEntityChangeBlockEvent(this, i, j, k, this.id, this.data).isCancelled()) {
/*     */                 return;
/*     */               }
/*  99 */               this.world.setTypeAndData(i, j, k, this.id, this.data, 3);
/*     */ 
/*     */               
/* 102 */               if (this.id instanceof BlockFalling) {
/* 103 */                 ((BlockFalling)this.id).a(this.world, i, j, k, this.data);
/*     */               }
/*     */               
/* 106 */               if (this.tileEntityData != null && this.id instanceof IContainer) {
/* 107 */                 TileEntity tileentity = this.world.getTileEntity(i, j, k);
/*     */                 
/* 109 */                 if (tileentity != null) {
/* 110 */                   NBTTagCompound nbttagcompound = new NBTTagCompound();
/*     */                   
/* 112 */                   tileentity.b(nbttagcompound);
/* 113 */                   Iterator<String> iterator = this.tileEntityData.c().iterator();
/*     */                   
/* 115 */                   while (iterator.hasNext()) {
/* 116 */                     String s = iterator.next();
/* 117 */                     NBTBase nbtbase = this.tileEntityData.get(s);
/*     */                     
/* 119 */                     if (!s.equals("x") && !s.equals("y") && !s.equals("z")) {
/* 120 */                       nbttagcompound.set(s, nbtbase.clone());
/*     */                     }
/*     */                   } 
/*     */                   
/* 124 */                   tileentity.a(nbttagcompound);
/* 125 */                   tileentity.update();
/*     */                 } 
/*     */               } 
/* 128 */             } else if (this.dropItem && !this.f) {
/* 129 */               a(new ItemStack(this.id, 1, this.id.getDropData(this.data)), 0.0F);
/*     */             } 
/*     */           } 
/* 132 */         } else if ((this.ticksLived > 100 && !this.world.isStatic && (j < 1 || j > 256)) || this.ticksLived > 600) {
/* 133 */           if (this.dropItem) {
/* 134 */             a(new ItemStack(this.id, 1, this.id.getDropData(this.data)), 0.0F);
/*     */           }
/*     */           
/* 137 */           die();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void b(float f) {
/* 144 */     if (this.hurtEntities) {
/* 145 */       int i = MathHelper.f(f - 1.0F);
/*     */       
/* 147 */       if (i > 0) {
/* 148 */         ArrayList arraylist = new ArrayList(this.world.getEntities(this, this.boundingBox));
/* 149 */         boolean flag = (this.id == Blocks.ANVIL);
/* 150 */         DamageSource damagesource = flag ? DamageSource.ANVIL : DamageSource.FALLING_BLOCK;
/* 151 */         Iterator<Entity> iterator = arraylist.iterator();
/*     */         
/* 153 */         while (iterator.hasNext()) {
/* 154 */           Entity entity = iterator.next();
/*     */           
/* 156 */           CraftEventFactory.entityDamage = this;
/* 157 */           entity.damageEntity(damagesource, Math.min(MathHelper.d(i * this.fallHurtAmount), this.fallHurtMax));
/* 158 */           CraftEventFactory.entityDamage = null;
/*     */         } 
/*     */         
/* 161 */         if (flag && this.random.nextFloat() < 0.05000000074505806D + i * 0.05D) {
/* 162 */           int j = this.data >> 2;
/* 163 */           int k = this.data & 0x3;
/*     */           
/* 165 */           j++;
/* 166 */           if (j > 2) {
/* 167 */             this.f = true;
/*     */           } else {
/* 169 */             this.data = k | j << 2;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void b(NBTTagCompound nbttagcompound) {
/* 177 */     nbttagcompound.setByte("Tile", (byte)Block.getId(this.id));
/* 178 */     nbttagcompound.setInt("TileID", Block.getId(this.id));
/* 179 */     nbttagcompound.setByte("Data", (byte)this.data);
/* 180 */     nbttagcompound.setByte("Time", (byte)this.ticksLived);
/* 181 */     nbttagcompound.setBoolean("DropItem", this.dropItem);
/* 182 */     nbttagcompound.setBoolean("HurtEntities", this.hurtEntities);
/* 183 */     nbttagcompound.setFloat("FallHurtAmount", this.fallHurtAmount);
/* 184 */     nbttagcompound.setInt("FallHurtMax", this.fallHurtMax);
/* 185 */     if (this.tileEntityData != null) {
/* 186 */       nbttagcompound.set("TileEntityData", this.tileEntityData);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void a(NBTTagCompound nbttagcompound) {
/* 191 */     if (nbttagcompound.hasKeyOfType("TileID", 99)) {
/* 192 */       this.id = Block.getById(nbttagcompound.getInt("TileID"));
/*     */     } else {
/* 194 */       this.id = Block.getById(nbttagcompound.getByte("Tile") & 0xFF);
/*     */     } 
/*     */     
/* 197 */     this.data = nbttagcompound.getByte("Data") & 0xFF;
/* 198 */     this.ticksLived = nbttagcompound.getByte("Time") & 0xFF;
/* 199 */     if (nbttagcompound.hasKeyOfType("HurtEntities", 99)) {
/* 200 */       this.hurtEntities = nbttagcompound.getBoolean("HurtEntities");
/* 201 */       this.fallHurtAmount = nbttagcompound.getFloat("FallHurtAmount");
/* 202 */       this.fallHurtMax = nbttagcompound.getInt("FallHurtMax");
/* 203 */     } else if (this.id == Blocks.ANVIL) {
/* 204 */       this.hurtEntities = true;
/*     */     } 
/*     */     
/* 207 */     if (nbttagcompound.hasKeyOfType("DropItem", 99)) {
/* 208 */       this.dropItem = nbttagcompound.getBoolean("DropItem");
/*     */     }
/*     */     
/* 211 */     if (nbttagcompound.hasKeyOfType("TileEntityData", 10)) {
/* 212 */       this.tileEntityData = nbttagcompound.getCompound("TileEntityData");
/*     */     }
/*     */     
/* 215 */     if (this.id.getMaterial() == Material.AIR) {
/* 216 */       this.id = Blocks.SAND;
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(boolean flag) {
/* 221 */     this.hurtEntities = flag;
/*     */   }
/*     */   
/*     */   public void a(CrashReportSystemDetails crashreportsystemdetails) {
/* 225 */     super.a(crashreportsystemdetails);
/* 226 */     crashreportsystemdetails.a("Immitating block ID", Integer.valueOf(Block.getId(this.id)));
/* 227 */     crashreportsystemdetails.a("Immitating block data", Integer.valueOf(this.data));
/*     */   }
/*     */   
/*     */   public Block f() {
/* 231 */     return this.id;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityFallingBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */