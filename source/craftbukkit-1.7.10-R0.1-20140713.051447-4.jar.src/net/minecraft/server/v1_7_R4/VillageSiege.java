/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*     */ 
/*     */ public class VillageSiege {
/*     */   private World world;
/*     */   private boolean b;
/*  10 */   private int c = -1;
/*     */   private int d;
/*     */   private int e;
/*     */   private Village f;
/*     */   private int g;
/*     */   private int h;
/*     */   private int i;
/*     */   
/*     */   public VillageSiege(World world) {
/*  19 */     this.world = world;
/*     */   }
/*     */   
/*     */   public void a() {
/*  23 */     boolean flag = false;
/*     */     
/*  25 */     if (flag) {
/*  26 */       if (this.c == 2) {
/*  27 */         this.d = 100;
/*     */         return;
/*     */       } 
/*     */     } else {
/*  31 */       if (this.world.w()) {
/*  32 */         this.c = 0;
/*     */         
/*     */         return;
/*     */       } 
/*  36 */       if (this.c == 2) {
/*     */         return;
/*     */       }
/*     */       
/*  40 */       if (this.c == 0) {
/*  41 */         float f = this.world.c(0.0F);
/*     */         
/*  43 */         if (f < 0.5D || f > 0.501D) {
/*     */           return;
/*     */         }
/*     */         
/*  47 */         this.c = (this.world.random.nextInt(10) == 0) ? 1 : 2;
/*  48 */         this.b = false;
/*  49 */         if (this.c == 2) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  55 */     if (!this.b) {
/*  56 */       if (!b()) {
/*     */         return;
/*     */       }
/*     */       
/*  60 */       this.b = true;
/*     */     } 
/*     */     
/*  63 */     if (this.e > 0) {
/*  64 */       this.e--;
/*     */     } else {
/*  66 */       this.e = 2;
/*  67 */       if (this.d > 0) {
/*  68 */         c();
/*  69 */         this.d--;
/*     */       } else {
/*  71 */         this.c = 2;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean b() {
/*  77 */     List list = this.world.players;
/*  78 */     Iterator<EntityHuman> iterator = list.iterator();
/*     */     
/*  80 */     while (iterator.hasNext()) {
/*  81 */       EntityHuman entityhuman = iterator.next();
/*     */       
/*  83 */       this.f = this.world.villages.getClosestVillage((int)entityhuman.locX, (int)entityhuman.locY, (int)entityhuman.locZ, 1);
/*  84 */       if (this.f != null && this.f.getDoorCount() >= 10 && this.f.d() >= 20 && this.f.getPopulationCount() >= 20) {
/*  85 */         ChunkCoordinates chunkcoordinates = this.f.getCenter();
/*  86 */         float f = this.f.getSize();
/*  87 */         boolean flag = false;
/*  88 */         int i = 0;
/*     */ 
/*     */         
/*  91 */         while (i < 10) {
/*  92 */           this.g = chunkcoordinates.x + (int)((MathHelper.cos(this.world.random.nextFloat() * 3.1415927F * 2.0F) * f) * 0.9D);
/*  93 */           this.h = chunkcoordinates.y;
/*  94 */           this.i = chunkcoordinates.z + (int)((MathHelper.sin(this.world.random.nextFloat() * 3.1415927F * 2.0F) * f) * 0.9D);
/*  95 */           flag = false;
/*  96 */           Iterator<Village> iterator1 = this.world.villages.getVillages().iterator();
/*     */           
/*  98 */           while (iterator1.hasNext()) {
/*  99 */             Village village = iterator1.next();
/*     */             
/* 101 */             if (village != this.f && village.a(this.g, this.h, this.i)) {
/* 102 */               flag = true;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 107 */           if (flag) {
/* 108 */             i++;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 113 */         if (flag) {
/* 114 */           return false;
/*     */         }
/*     */         
/* 117 */         Vec3D vec3d = a(this.g, this.h, this.i);
/*     */         
/* 119 */         if (vec3d != null) {
/* 120 */           this.e = 0;
/* 121 */           this.d = 20;
/* 122 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 129 */     return false;
/*     */   }
/*     */   private boolean c() {
/*     */     EntityZombie entityzombie;
/* 133 */     Vec3D vec3d = a(this.g, this.h, this.i);
/*     */     
/* 135 */     if (vec3d == null) {
/* 136 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 141 */       entityzombie = new EntityZombie(this.world);
/* 142 */       entityzombie.prepare((GroupDataEntity)null);
/* 143 */       entityzombie.setVillager(false);
/* 144 */     } catch (Exception exception) {
/* 145 */       exception.printStackTrace();
/* 146 */       return false;
/*     */     } 
/*     */     
/* 149 */     entityzombie.setPositionRotation(vec3d.a, vec3d.b, vec3d.c, this.world.random.nextFloat() * 360.0F, 0.0F);
/* 150 */     this.world.addEntity(entityzombie, CreatureSpawnEvent.SpawnReason.VILLAGE_INVASION);
/* 151 */     ChunkCoordinates chunkcoordinates = this.f.getCenter();
/*     */     
/* 153 */     entityzombie.a(chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z, this.f.getSize());
/* 154 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private Vec3D a(int i, int j, int k) {
/* 159 */     for (int l = 0; l < 10; l++) {
/* 160 */       int i1 = i + this.world.random.nextInt(16) - 8;
/* 161 */       int j1 = j + this.world.random.nextInt(6) - 3;
/* 162 */       int k1 = k + this.world.random.nextInt(16) - 8;
/*     */       
/* 164 */       if (this.f.a(i1, j1, k1) && SpawnerCreature.a(EnumCreatureType.MONSTER, this.world, i1, j1, k1))
/*     */       {
/* 166 */         return Vec3D.a(i1, j1, k1);
/*     */       }
/*     */     } 
/*     */     
/* 170 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\VillageSiege.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */