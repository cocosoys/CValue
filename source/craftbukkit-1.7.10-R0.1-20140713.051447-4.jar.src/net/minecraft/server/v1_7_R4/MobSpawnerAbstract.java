/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MobSpawnerAbstract
/*     */ {
/*  12 */   public int spawnDelay = 20;
/*  13 */   private String mobName = "Pig";
/*     */   private List mobs;
/*     */   private TileEntityMobSpawnerData spawnData;
/*     */   public double c;
/*     */   public double d;
/*  18 */   private int minSpawnDelay = 200;
/*  19 */   private int maxSpawnDelay = 800;
/*  20 */   private int spawnCount = 4;
/*     */   private Entity j;
/*  22 */   private int maxNearbyEntities = 6;
/*  23 */   private int requiredPlayerRange = 16;
/*  24 */   private int spawnRange = 4;
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMobName() {
/*  29 */     if (i() == null) {
/*  30 */       if (this.mobName.equals("Minecart")) {
/*  31 */         this.mobName = "MinecartRideable";
/*     */       }
/*     */       
/*  34 */       return this.mobName;
/*     */     } 
/*  36 */     return (i()).c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMobName(String s) {
/*  41 */     this.mobName = s;
/*     */   }
/*     */   
/*     */   public boolean f() {
/*  45 */     return (a().findNearbyPlayer(b() + 0.5D, c() + 0.5D, d() + 0.5D, this.requiredPlayerRange) != null);
/*     */   }
/*     */   
/*     */   public void g() {
/*  49 */     if (f())
/*     */     {
/*     */       
/*  52 */       if ((a()).isStatic) {
/*  53 */         double d1 = (b() + (a()).random.nextFloat());
/*  54 */         double d2 = (c() + (a()).random.nextFloat());
/*     */         
/*  56 */         double d0 = (d() + (a()).random.nextFloat());
/*  57 */         a().addParticle("smoke", d1, d2, d0, 0.0D, 0.0D, 0.0D);
/*  58 */         a().addParticle("flame", d1, d2, d0, 0.0D, 0.0D, 0.0D);
/*  59 */         if (this.spawnDelay > 0) {
/*  60 */           this.spawnDelay--;
/*     */         }
/*     */         
/*  63 */         this.d = this.c;
/*  64 */         this.c = (this.c + (1000.0F / (this.spawnDelay + 200.0F))) % 360.0D;
/*     */       } else {
/*  66 */         if (this.spawnDelay == -1) {
/*  67 */           j();
/*     */         }
/*     */         
/*  70 */         if (this.spawnDelay > 0) {
/*  71 */           this.spawnDelay--;
/*     */           
/*     */           return;
/*     */         } 
/*  75 */         boolean flag = false;
/*     */         
/*  77 */         for (int i = 0; i < this.spawnCount; i++) {
/*  78 */           Entity entity = EntityTypes.createEntityByName(getMobName(), a());
/*     */           
/*  80 */           if (entity == null) {
/*     */             return;
/*     */           }
/*     */           
/*  84 */           int j = a().a(entity.getClass(), AxisAlignedBB.a(b(), c(), d(), (b() + 1), (c() + 1), (d() + 1)).grow((this.spawnRange * 2), 4.0D, (this.spawnRange * 2))).size();
/*     */           
/*  86 */           if (j >= this.maxNearbyEntities) {
/*  87 */             j();
/*     */             
/*     */             return;
/*     */           } 
/*  91 */           double d0 = b() + ((a()).random.nextDouble() - (a()).random.nextDouble()) * this.spawnRange;
/*  92 */           double d3 = (c() + (a()).random.nextInt(3) - 1);
/*  93 */           double d4 = d() + ((a()).random.nextDouble() - (a()).random.nextDouble()) * this.spawnRange;
/*  94 */           EntityInsentient entityinsentient = (entity instanceof EntityInsentient) ? (EntityInsentient)entity : null;
/*     */           
/*  96 */           entity.setPositionRotation(d0, d3, d4, (a()).random.nextFloat() * 360.0F, 0.0F);
/*  97 */           if (entityinsentient == null || entityinsentient.canSpawn()) {
/*  98 */             a(entity);
/*  99 */             a().triggerEffect(2004, b(), c(), d(), 0);
/* 100 */             if (entityinsentient != null) {
/* 101 */               entityinsentient.s();
/*     */             }
/*     */             
/* 104 */             flag = true;
/*     */           } 
/*     */         } 
/*     */         
/* 108 */         if (flag) {
/* 109 */           j();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public Entity a(Entity entity) {
/* 116 */     if (i() != null) {
/* 117 */       NBTTagCompound nbttagcompound = new NBTTagCompound();
/*     */       
/* 119 */       entity.d(nbttagcompound);
/* 120 */       Iterator<String> iterator = (i()).b.c().iterator();
/*     */       
/* 122 */       while (iterator.hasNext()) {
/* 123 */         String s = iterator.next();
/* 124 */         NBTBase nbtbase = (i()).b.get(s);
/*     */         
/* 126 */         nbttagcompound.set(s, nbtbase.clone());
/*     */       } 
/*     */       
/* 129 */       entity.f(nbttagcompound);
/* 130 */       if (entity.world != null) {
/* 131 */         entity.world.addEntity(entity, CreatureSpawnEvent.SpawnReason.SPAWNER);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 136 */       for (Entity entity1 = entity; nbttagcompound.hasKeyOfType("Riding", 10); nbttagcompound = nbttagcompound1) {
/* 137 */         NBTTagCompound nbttagcompound1 = nbttagcompound.getCompound("Riding");
/* 138 */         Entity entity2 = EntityTypes.createEntityByName(nbttagcompound1.getString("id"), entity.world);
/*     */         
/* 140 */         if (entity2 != null) {
/* 141 */           NBTTagCompound nbttagcompound2 = new NBTTagCompound();
/*     */           
/* 143 */           entity2.d(nbttagcompound2);
/* 144 */           Iterator<String> iterator1 = nbttagcompound1.c().iterator();
/*     */           
/* 146 */           while (iterator1.hasNext()) {
/* 147 */             String s1 = iterator1.next();
/* 148 */             NBTBase nbtbase1 = nbttagcompound1.get(s1);
/*     */             
/* 150 */             nbttagcompound2.set(s1, nbtbase1.clone());
/*     */           } 
/*     */           
/* 153 */           entity2.f(nbttagcompound2);
/* 154 */           entity2.setPositionRotation(entity1.locX, entity1.locY, entity1.locZ, entity1.yaw, entity1.pitch);
/* 155 */           if (entity.world != null) {
/* 156 */             entity.world.addEntity(entity2, CreatureSpawnEvent.SpawnReason.SPAWNER);
/*     */           }
/*     */           
/* 159 */           entity1.mount(entity2);
/*     */         } 
/*     */         
/* 162 */         entity1 = entity2;
/*     */       } 
/* 164 */     } else if (entity instanceof EntityLiving && entity.world != null) {
/* 165 */       ((EntityInsentient)entity).prepare((GroupDataEntity)null);
/* 166 */       a().addEntity(entity, CreatureSpawnEvent.SpawnReason.SPAWNER);
/*     */     } 
/*     */     
/* 169 */     return entity;
/*     */   }
/*     */   
/*     */   private void j() {
/* 173 */     if (this.maxSpawnDelay <= this.minSpawnDelay) {
/* 174 */       this.spawnDelay = this.minSpawnDelay;
/*     */     } else {
/* 176 */       int i = this.maxSpawnDelay - this.minSpawnDelay;
/*     */       
/* 178 */       this.spawnDelay = this.minSpawnDelay + (a()).random.nextInt(i);
/*     */     } 
/*     */     
/* 181 */     if (this.mobs != null && this.mobs.size() > 0) {
/* 182 */       a((TileEntityMobSpawnerData)WeightedRandom.a((a()).random, this.mobs));
/*     */     }
/*     */     
/* 185 */     a(1);
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/* 189 */     this.mobName = nbttagcompound.getString("EntityId");
/* 190 */     this.spawnDelay = nbttagcompound.getShort("Delay");
/* 191 */     if (nbttagcompound.hasKeyOfType("SpawnPotentials", 9)) {
/* 192 */       this.mobs = new ArrayList();
/* 193 */       NBTTagList nbttaglist = nbttagcompound.getList("SpawnPotentials", 10);
/*     */       
/* 195 */       for (int i = 0; i < nbttaglist.size(); i++) {
/* 196 */         this.mobs.add(new TileEntityMobSpawnerData(this, nbttaglist.get(i)));
/*     */       }
/*     */     } else {
/* 199 */       this.mobs = null;
/*     */     } 
/*     */     
/* 202 */     if (nbttagcompound.hasKeyOfType("SpawnData", 10)) {
/* 203 */       a(new TileEntityMobSpawnerData(this, nbttagcompound.getCompound("SpawnData"), this.mobName));
/*     */     } else {
/* 205 */       a((TileEntityMobSpawnerData)null);
/*     */     } 
/*     */     
/* 208 */     if (nbttagcompound.hasKeyOfType("MinSpawnDelay", 99)) {
/* 209 */       this.minSpawnDelay = nbttagcompound.getShort("MinSpawnDelay");
/* 210 */       this.maxSpawnDelay = nbttagcompound.getShort("MaxSpawnDelay");
/* 211 */       this.spawnCount = nbttagcompound.getShort("SpawnCount");
/*     */     } 
/*     */     
/* 214 */     if (nbttagcompound.hasKeyOfType("MaxNearbyEntities", 99)) {
/* 215 */       this.maxNearbyEntities = nbttagcompound.getShort("MaxNearbyEntities");
/* 216 */       this.requiredPlayerRange = nbttagcompound.getShort("RequiredPlayerRange");
/*     */     } 
/*     */     
/* 219 */     if (nbttagcompound.hasKeyOfType("SpawnRange", 99)) {
/* 220 */       this.spawnRange = nbttagcompound.getShort("SpawnRange");
/*     */     }
/*     */     
/* 223 */     if (a() != null && (a()).isStatic) {
/* 224 */       this.j = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/* 229 */     nbttagcompound.setString("EntityId", getMobName());
/* 230 */     nbttagcompound.setShort("Delay", (short)this.spawnDelay);
/* 231 */     nbttagcompound.setShort("MinSpawnDelay", (short)this.minSpawnDelay);
/* 232 */     nbttagcompound.setShort("MaxSpawnDelay", (short)this.maxSpawnDelay);
/* 233 */     nbttagcompound.setShort("SpawnCount", (short)this.spawnCount);
/* 234 */     nbttagcompound.setShort("MaxNearbyEntities", (short)this.maxNearbyEntities);
/* 235 */     nbttagcompound.setShort("RequiredPlayerRange", (short)this.requiredPlayerRange);
/* 236 */     nbttagcompound.setShort("SpawnRange", (short)this.spawnRange);
/* 237 */     if (i() != null) {
/* 238 */       nbttagcompound.set("SpawnData", (i()).b.clone());
/*     */     }
/*     */     
/* 241 */     if (i() != null || (this.mobs != null && this.mobs.size() > 0)) {
/* 242 */       NBTTagList nbttaglist = new NBTTagList();
/*     */       
/* 244 */       if (this.mobs != null && this.mobs.size() > 0) {
/* 245 */         Iterator<TileEntityMobSpawnerData> iterator = this.mobs.iterator();
/*     */         
/* 247 */         while (iterator.hasNext()) {
/* 248 */           TileEntityMobSpawnerData tileentitymobspawnerdata = iterator.next();
/*     */           
/* 250 */           nbttaglist.add(tileentitymobspawnerdata.a());
/*     */         } 
/*     */       } else {
/* 253 */         nbttaglist.add(i().a());
/*     */       } 
/*     */       
/* 256 */       nbttagcompound.set("SpawnPotentials", nbttaglist);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean b(int i) {
/* 261 */     if (i == 1 && (a()).isStatic) {
/* 262 */       this.spawnDelay = this.minSpawnDelay;
/* 263 */       return true;
/*     */     } 
/* 265 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntityMobSpawnerData i() {
/* 270 */     return this.spawnData;
/*     */   }
/*     */   
/*     */   public void a(TileEntityMobSpawnerData tileentitymobspawnerdata) {
/* 274 */     this.spawnData = tileentitymobspawnerdata;
/*     */   }
/*     */   
/*     */   public abstract void a(int paramInt);
/*     */   
/*     */   public abstract World a();
/*     */   
/*     */   public abstract int b();
/*     */   
/*     */   public abstract int c();
/*     */   
/*     */   public abstract int d();
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\MobSpawnerAbstract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */