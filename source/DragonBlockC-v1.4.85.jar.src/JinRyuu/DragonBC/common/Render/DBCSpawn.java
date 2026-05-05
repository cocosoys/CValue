/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public abstract class DBCSpawn
/*     */ {
/*  18 */   public int spawnDelay = 100;
/*  19 */   private String mobID = "Saibaman";
/*     */   
/*     */   public double field_98287_c;
/*  22 */   public double field_98284_d = 0.0D;
/*  23 */   private int minSpawnDelay = 200;
/*  24 */   private int maxSpawnDelay = 800;
/*     */ 
/*     */   
/*  27 */   private int spawnCount = 1;
/*     */   private Entity field_98291_j;
/*  29 */   private int maxNearbyEntities = 1;
/*     */ 
/*     */   
/*  32 */   private int activatingRangeFromPlayer = 8;
/*     */ 
/*     */   
/*  35 */   private int spawnRange = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEntityNameToSpawn() {
/*  42 */     return this.mobID;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMobID(String par1Str) {
/*  47 */     this.mobID = par1Str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canRun() {
/*  55 */     return (getSpawnerWorld().func_72977_a(getSpawnerX() + 0.5D, getSpawnerY() + 0.5D, getSpawnerZ() + 0.5D, this.activatingRangeFromPlayer) != null);
/*     */   }
/*     */   
/*     */   public void updateSpawner() {
/*  59 */     int n = 4;
/*  60 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(getSpawnerX() - n, getSpawnerY() - n, getSpawnerZ() - n, getSpawnerX() + n, getSpawnerY() + n, getSpawnerZ() + n);
/*     */     
/*  62 */     int p = getSpawnerWorld().func_72872_a(EntityPlayer.class, aabb).size();
/*     */     
/*  64 */     if (canRun() && p != 0)
/*     */     {
/*     */ 
/*     */       
/*  68 */       if ((getSpawnerWorld()).field_72995_K) {
/*     */         
/*  70 */         double d1 = (getSpawnerX() + (getSpawnerWorld()).field_73012_v.nextFloat());
/*  71 */         double d2 = (getSpawnerY() + (getSpawnerWorld()).field_73012_v.nextFloat());
/*  72 */         double d0 = (getSpawnerZ() + (getSpawnerWorld()).field_73012_v.nextFloat());
/*     */ 
/*     */ 
/*     */         
/*  76 */         if (this.spawnDelay > 0)
/*     */         {
/*  78 */           this.spawnDelay--;
/*     */         }
/*     */         
/*  81 */         this.field_98284_d = this.field_98287_c;
/*  82 */         this.field_98287_c = (this.field_98287_c + (1000.0F / (this.spawnDelay + 200.0F))) % 360.0D;
/*     */       }
/*     */       else {
/*     */         
/*  86 */         if (this.spawnDelay == -1)
/*     */         {
/*  88 */           func_98273_j();
/*     */         }
/*     */         
/*  91 */         if (this.spawnDelay > 0) {
/*     */           
/*  93 */           this.spawnDelay--;
/*     */           
/*     */           return;
/*     */         } 
/*  97 */         boolean flag = false;
/*     */         
/*  99 */         for (int i = 0; i < this.spawnCount; i++) {
/*     */ 
/*     */           
/* 102 */           EntitySaibaiman entitySaibaiman = new EntitySaibaiman(getSpawnerWorld());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 108 */           n = 16;
/* 109 */           aabb = AxisAlignedBB.func_72330_a(getSpawnerX() - n, getSpawnerY() - n, getSpawnerZ() - n, getSpawnerX() + n, getSpawnerY() + n, getSpawnerZ() + n);
/*     */           
/* 111 */           int j = getSpawnerWorld().func_72872_a(EntityDBC.class, aabb).size();
/*     */           
/* 113 */           if (j >= 1) {
/*     */             
/* 115 */             func_98273_j();
/*     */             
/*     */             return;
/*     */           } 
/* 119 */           double d0 = getSpawnerX() + ((getSpawnerWorld()).field_73012_v.nextDouble() - (getSpawnerWorld()).field_73012_v.nextDouble()) * this.spawnRange;
/* 120 */           double d3 = (getSpawnerY() + (getSpawnerWorld()).field_73012_v.nextInt(3) - 1);
/* 121 */           double d4 = getSpawnerZ() + ((getSpawnerWorld()).field_73012_v.nextDouble() - (getSpawnerWorld()).field_73012_v.nextDouble()) * this.spawnRange;
/* 122 */           EntityLiving entityliving = (entitySaibaiman instanceof EntityLiving) ? (EntityLiving)entitySaibaiman : null;
/* 123 */           entitySaibaiman.func_70012_b(d0, d3, d4, (getSpawnerWorld()).field_73012_v.nextFloat() * 360.0F, 0.0F);
/*     */           
/* 125 */           if (entityliving == null || entityliving.func_70601_bi()) {
/*     */             
/* 127 */             func_98265_a((Entity)entitySaibaiman);
/* 128 */             getSpawnerWorld().func_72926_e(2004, getSpawnerX(), getSpawnerY(), getSpawnerZ(), 0);
/*     */             
/* 130 */             if (entityliving != null)
/*     */             {
/* 132 */               entityliving.func_70656_aK();
/*     */             }
/*     */             
/* 135 */             flag = true;
/*     */           } 
/*     */         } 
/*     */         
/* 139 */         if (flag)
/*     */         {
/* 141 */           func_98273_j();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Entity func_98265_a(Entity par1Entity) {
/* 149 */     if (par1Entity instanceof EntityLiving && par1Entity.field_70170_p != null)
/*     */     {
/*     */       
/* 152 */       getSpawnerWorld().func_72838_d(par1Entity);
/*     */     }
/*     */     
/* 155 */     return par1Entity;
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_98273_j() {
/* 160 */     if (this.maxSpawnDelay <= this.minSpawnDelay) {
/*     */       
/* 162 */       this.spawnDelay = this.minSpawnDelay;
/*     */     }
/*     */     else {
/*     */       
/* 166 */       int i = this.maxSpawnDelay - this.minSpawnDelay;
/* 167 */       this.spawnDelay = this.minSpawnDelay + (getSpawnerWorld()).field_73012_v.nextInt(i);
/*     */     } 
/*     */     
/* 170 */     func_98267_a(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 175 */     this.mobID = par1NBTTagCompound.func_74779_i("EntityId");
/* 176 */     this.spawnDelay = par1NBTTagCompound.func_74765_d("Delay");
/*     */ 
/*     */     
/* 179 */     if (par1NBTTagCompound.func_74764_b("MinSpawnDelay")) {
/*     */       
/* 181 */       this.minSpawnDelay = par1NBTTagCompound.func_74765_d("MinSpawnDelay");
/* 182 */       this.maxSpawnDelay = par1NBTTagCompound.func_74765_d("MaxSpawnDelay");
/* 183 */       this.spawnCount = par1NBTTagCompound.func_74765_d("SpawnCount");
/*     */     } 
/*     */     
/* 186 */     if (par1NBTTagCompound.func_74764_b("MaxNearbyEntities")) {
/*     */       
/* 188 */       this.maxNearbyEntities = par1NBTTagCompound.func_74765_d("MaxNearbyEntities");
/* 189 */       this.activatingRangeFromPlayer = par1NBTTagCompound.func_74765_d("RequiredPlayerRange");
/*     */     } 
/*     */     
/* 192 */     if (par1NBTTagCompound.func_74764_b("SpawnRange"))
/*     */     {
/* 194 */       this.spawnRange = par1NBTTagCompound.func_74765_d("SpawnRange");
/*     */     }
/*     */     
/* 197 */     if (getSpawnerWorld() != null && (getSpawnerWorld()).field_72995_K)
/*     */     {
/* 199 */       this.field_98291_j = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
/* 205 */     par1NBTTagCompound.func_74778_a("EntityId", getEntityNameToSpawn());
/* 206 */     par1NBTTagCompound.func_74777_a("Delay", (short)this.spawnDelay);
/* 207 */     par1NBTTagCompound.func_74777_a("MinSpawnDelay", (short)this.minSpawnDelay);
/* 208 */     par1NBTTagCompound.func_74777_a("MaxSpawnDelay", (short)this.maxSpawnDelay);
/* 209 */     par1NBTTagCompound.func_74777_a("SpawnCount", (short)this.spawnCount);
/* 210 */     par1NBTTagCompound.func_74777_a("MaxNearbyEntities", (short)this.maxNearbyEntities);
/* 211 */     par1NBTTagCompound.func_74777_a("RequiredPlayerRange", (short)this.activatingRangeFromPlayer);
/* 212 */     par1NBTTagCompound.func_74777_a("SpawnRange", (short)this.spawnRange);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDelayToMin(int par1) {
/* 221 */     if (par1 == 1 && (getSpawnerWorld()).field_72995_K) {
/*     */       
/* 223 */       this.spawnDelay = this.minSpawnDelay;
/* 224 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 228 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Entity func_98281_h() {
/* 235 */     if (this.field_98291_j == null) {
/*     */       
/* 237 */       Entity entity = EntityList.func_75620_a(getEntityNameToSpawn(), (World)null);
/* 238 */       entity = func_98265_a(entity);
/* 239 */       this.field_98291_j = entity;
/*     */     } 
/*     */     
/* 242 */     return this.field_98291_j;
/*     */   }
/*     */   
/*     */   public abstract void func_98267_a(int paramInt);
/*     */   
/*     */   public abstract World getSpawnerWorld();
/*     */   
/*     */   public abstract int getSpawnerX();
/*     */   
/*     */   public abstract int getSpawnerY();
/*     */   
/*     */   public abstract int getSpawnerZ();
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DBCSpawn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */