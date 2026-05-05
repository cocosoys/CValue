/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.LongHash;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.LongObjectHashMap;
/*     */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SpawnerCreature
/*     */ {
/*  17 */   private LongObjectHashMap<Boolean> a = new LongObjectHashMap();
/*     */ 
/*     */ 
/*     */   
/*     */   protected static ChunkPosition getRandomPosition(World world, int i, int j) {
/*  22 */     Chunk chunk = world.getChunkAt(i, j);
/*  23 */     int k = i * 16 + world.random.nextInt(16);
/*  24 */     int l = j * 16 + world.random.nextInt(16);
/*  25 */     int i1 = world.random.nextInt((chunk == null) ? world.S() : (chunk.h() + 16 - 1));
/*     */     
/*  27 */     return new ChunkPosition(k, i1, l);
/*     */   }
/*     */   
/*     */   public int spawnEntities(WorldServer worldserver, boolean flag, boolean flag1, boolean flag2) {
/*  31 */     if (!flag && !flag1) {
/*  32 */       return 0;
/*     */     }
/*  34 */     this.a.clear();
/*     */ 
/*     */     
/*     */     int i;
/*     */     
/*  39 */     for (i = 0; i < worldserver.players.size(); i++) {
/*  40 */       EntityHuman entityhuman = worldserver.players.get(i);
/*  41 */       int k = MathHelper.floor(entityhuman.locX / 16.0D);
/*     */       
/*  43 */       int m = MathHelper.floor(entityhuman.locZ / 16.0D);
/*  44 */       byte b0 = 8;
/*     */       
/*  46 */       for (int l = -b0; l <= b0; l++) {
/*  47 */         for (int i1 = -b0; i1 <= b0; i1++) {
/*  48 */           boolean flag3 = (l == -b0 || l == b0 || i1 == -b0 || i1 == b0);
/*     */ 
/*     */           
/*  51 */           long chunkCoords = LongHash.toLong(l + k, i1 + m);
/*     */           
/*  53 */           if (!flag3) {
/*  54 */             this.a.put(chunkCoords, Boolean.valueOf(false));
/*  55 */           } else if (!this.a.containsKey(chunkCoords)) {
/*  56 */             this.a.put(chunkCoords, Boolean.valueOf(true));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  63 */     i = 0;
/*  64 */     ChunkCoordinates chunkcoordinates = worldserver.getSpawn();
/*  65 */     EnumCreatureType[] aenumcreaturetype = EnumCreatureType.values();
/*     */     
/*  67 */     int j = aenumcreaturetype.length;
/*     */     
/*  69 */     for (int j1 = 0; j1 < j; j1++) {
/*  70 */       EnumCreatureType enumcreaturetype = aenumcreaturetype[j1];
/*     */ 
/*     */       
/*  73 */       int limit = enumcreaturetype.b();
/*  74 */       switch (enumcreaturetype) {
/*     */         case MONSTER:
/*  76 */           limit = worldserver.getWorld().getMonsterSpawnLimit();
/*     */           break;
/*     */         case CREATURE:
/*  79 */           limit = worldserver.getWorld().getAnimalSpawnLimit();
/*     */           break;
/*     */         case WATER_CREATURE:
/*  82 */           limit = worldserver.getWorld().getWaterAnimalSpawnLimit();
/*     */           break;
/*     */         case AMBIENT:
/*  85 */           limit = worldserver.getWorld().getAmbientSpawnLimit();
/*     */           break;
/*     */       } 
/*     */       
/*  89 */       if (limit != 0)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*  94 */         if ((!enumcreaturetype.d() || flag1) && (enumcreaturetype.d() || flag) && (!enumcreaturetype.e() || flag2) && worldserver.a(enumcreaturetype.a()) <= limit * this.a.size() / 256) {
/*  95 */           Iterator<Long> iterator = this.a.keySet().iterator();
/*     */ 
/*     */           
/*  98 */           label93: while (iterator.hasNext()) {
/*     */             
/* 100 */             long key = ((Long)iterator.next()).longValue();
/*     */             
/* 102 */             if (!((Boolean)this.a.get(key)).booleanValue()) {
/* 103 */               ChunkPosition chunkposition = getRandomPosition(worldserver, LongHash.msw(key), LongHash.lsw(key));
/*     */               
/* 105 */               int k1 = chunkposition.x;
/* 106 */               int l1 = chunkposition.y;
/* 107 */               int i2 = chunkposition.z;
/*     */               
/* 109 */               if (!worldserver.getType(k1, l1, i2).r() && worldserver.getType(k1, l1, i2).getMaterial() == enumcreaturetype.c()) {
/* 110 */                 int j2 = 0;
/* 111 */                 int k2 = 0;
/*     */                 
/* 113 */                 while (k2 < 3) {
/* 114 */                   int l2 = k1;
/* 115 */                   int i3 = l1;
/* 116 */                   int j3 = i2;
/* 117 */                   byte b1 = 6;
/* 118 */                   BiomeMeta biomemeta = null;
/* 119 */                   GroupDataEntity groupdataentity = null;
/* 120 */                   int k3 = 0;
/*     */ 
/*     */                   
/* 123 */                   while (k3 < 4) {
/*     */                     
/* 125 */                     l2 += worldserver.random.nextInt(b1) - worldserver.random.nextInt(b1);
/* 126 */                     i3 += worldserver.random.nextInt(1) - worldserver.random.nextInt(1);
/* 127 */                     j3 += worldserver.random.nextInt(b1) - worldserver.random.nextInt(b1);
/* 128 */                     if (a(enumcreaturetype, worldserver, l2, i3, j3)) {
/* 129 */                       float f = l2 + 0.5F;
/* 130 */                       float f1 = i3;
/* 131 */                       float f2 = j3 + 0.5F;
/*     */                       
/* 133 */                       if (worldserver.findNearbyPlayer(f, f1, f2, 24.0D) == null) {
/* 134 */                         float f3 = f - chunkcoordinates.x;
/* 135 */                         float f4 = f1 - chunkcoordinates.y;
/* 136 */                         float f5 = f2 - chunkcoordinates.z;
/* 137 */                         float f6 = f3 * f3 + f4 * f4 + f5 * f5;
/*     */                         
/* 139 */                         if (f6 >= 576.0F) {
/* 140 */                           EntityInsentient entityinsentient; if (biomemeta == null) {
/* 141 */                             biomemeta = worldserver.a(enumcreaturetype, l2, i3, j3);
/* 142 */                             if (biomemeta == null) {
/*     */                               break;
/*     */                             }
/*     */                           } 
/*     */ 
/*     */ 
/*     */                           
/*     */                           try {
/* 150 */                             entityinsentient = biomemeta.b.getConstructor(new Class[] { World.class }).newInstance(new Object[] { worldserver });
/* 151 */                           } catch (Exception exception) {
/* 152 */                             exception.printStackTrace();
/* 153 */                             return i;
/*     */                           } 
/*     */                           
/* 156 */                           entityinsentient.setPositionRotation(f, f1, f2, worldserver.random.nextFloat() * 360.0F, 0.0F);
/* 157 */                           if (entityinsentient.canSpawn()) {
/* 158 */                             j2++;
/*     */                             
/* 160 */                             groupdataentity = entityinsentient.prepare(groupdataentity);
/* 161 */                             worldserver.addEntity(entityinsentient, CreatureSpawnEvent.SpawnReason.NATURAL);
/*     */                             
/* 163 */                             if (j2 >= entityinsentient.bB()) {
/*     */                               continue label93;
/*     */                             }
/*     */                           } 
/*     */                           
/* 168 */                           i += j2;
/*     */                         } 
/*     */                       } 
/*     */                     } 
/*     */                     
/* 173 */                     k3++;
/*     */                   } 
/*     */ 
/*     */ 
/*     */                   
/* 178 */                   k2++;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 188 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean a(EnumCreatureType enumcreaturetype, World world, int i, int j, int k) {
/* 193 */     if (enumcreaturetype.c() == Material.WATER)
/* 194 */       return (world.getType(i, j, k).getMaterial().isLiquid() && world.getType(i, j - 1, k).getMaterial().isLiquid() && !world.getType(i, j + 1, k).r()); 
/* 195 */     if (!World.a(world, i, j - 1, k)) {
/* 196 */       return false;
/*     */     }
/* 198 */     Block block = world.getType(i, j - 1, k);
/*     */     
/* 200 */     return (block != Blocks.BEDROCK && !world.getType(i, j, k).r() && !world.getType(i, j, k).getMaterial().isLiquid() && !world.getType(i, j + 1, k).r());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void a(World world, BiomeBase biomebase, int i, int j, int k, int l, Random random) {
/* 205 */     List list = biomebase.getMobs(EnumCreatureType.CREATURE);
/*     */     
/* 207 */     if (!list.isEmpty())
/* 208 */       while (random.nextFloat() < biomebase.g()) {
/* 209 */         BiomeMeta biomemeta = (BiomeMeta)WeightedRandom.a(world.random, list);
/* 210 */         GroupDataEntity groupdataentity = null;
/* 211 */         int i1 = biomemeta.c + random.nextInt(1 + biomemeta.d - biomemeta.c);
/* 212 */         int j1 = i + random.nextInt(k);
/* 213 */         int k1 = j + random.nextInt(l);
/* 214 */         int l1 = j1;
/* 215 */         int i2 = k1;
/*     */         
/* 217 */         for (int j2 = 0; j2 < i1; j2++) {
/* 218 */           boolean flag = false;
/*     */           
/* 220 */           for (int k2 = 0; !flag && k2 < 4; k2++) {
/* 221 */             int l2 = world.i(j1, k1);
/*     */             
/* 223 */             if (a(EnumCreatureType.CREATURE, world, j1, l2, k1)) {
/* 224 */               EntityInsentient entityinsentient; float f = j1 + 0.5F;
/* 225 */               float f1 = l2;
/* 226 */               float f2 = k1 + 0.5F;
/*     */ 
/*     */ 
/*     */               
/*     */               try {
/* 231 */                 entityinsentient = biomemeta.b.getConstructor(new Class[] { World.class }).newInstance(new Object[] { world });
/* 232 */               } catch (Exception exception) {
/* 233 */                 exception.printStackTrace();
/*     */               } 
/*     */ 
/*     */               
/* 237 */               entityinsentient.setPositionRotation(f, f1, f2, random.nextFloat() * 360.0F, 0.0F);
/*     */               
/* 239 */               groupdataentity = entityinsentient.prepare(groupdataentity);
/* 240 */               world.addEntity(entityinsentient, CreatureSpawnEvent.SpawnReason.CHUNK_GEN);
/*     */               
/* 242 */               flag = true;
/*     */             } 
/*     */             
/* 245 */             j1 += random.nextInt(5) - random.nextInt(5);
/*     */             
/* 247 */             for (k1 += random.nextInt(5) - random.nextInt(5); j1 < i || j1 >= i + k || k1 < j || k1 >= j + k; k1 = i2 + random.nextInt(5) - random.nextInt(5))
/* 248 */               j1 = l1 + random.nextInt(5) - random.nextInt(5); 
/*     */           } 
/*     */         } 
/*     */       }  
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\SpawnerCreature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */