/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class StructureGenerator
/*     */   extends WorldGenBase
/*     */ {
/*     */   private PersistentStructure e;
/*  15 */   protected Map d = new HashMap<Object, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String a();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Block[] paramArrayOfBlock) {
/*  26 */     a(paramWorld);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  32 */     if (this.d.containsKey(Long.valueOf(ChunkCoordIntPair.a(paramInt1, paramInt2)))) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  37 */     this.b.nextInt();
/*     */     
/*     */     try {
/*  40 */       if (a(paramInt1, paramInt2)) {
/*     */         
/*  42 */         StructureStart structureStart = b(paramInt1, paramInt2);
/*  43 */         this.d.put(Long.valueOf(ChunkCoordIntPair.a(paramInt1, paramInt2)), structureStart);
/*  44 */         a(paramInt1, paramInt2, structureStart);
/*     */       } 
/*  46 */     } catch (Throwable throwable) {
/*  47 */       CrashReport crashReport = CrashReport.a(throwable, "Exception preparing structure feature");
/*  48 */       CrashReportSystemDetails crashReportSystemDetails = crashReport.a("Feature being prepared");
/*     */       
/*  50 */       crashReportSystemDetails.a("Is feature chunk", new CrashReportIsFeatureChunk(this, paramInt1, paramInt2));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  57 */       crashReportSystemDetails.a("Chunk location", String.format("%d,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/*  59 */       crashReportSystemDetails.a("Chunk pos hash", new CrashReportChunkPosHash(this, paramInt1, paramInt2));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  66 */       crashReportSystemDetails.a("Structure type", new CrashReportStructureType(this));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  73 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2) {
/*  79 */     a(paramWorld);
/*     */     
/*  81 */     int i = (paramInt1 << 4) + 8;
/*  82 */     int j = (paramInt2 << 4) + 8;
/*     */     
/*  84 */     boolean bool = false;
/*  85 */     for (StructureStart structureStart : this.d.values()) {
/*  86 */       if (structureStart.d() && 
/*  87 */         structureStart.a().a(i, j, i + 15, j + 15)) {
/*  88 */         structureStart.a(paramWorld, paramRandom, new StructureBoundingBox(i, j, i + 15, j + 15));
/*  89 */         bool = true;
/*     */ 
/*     */         
/*  92 */         a(structureStart.e(), structureStart.f(), structureStart);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  97 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean b(int paramInt1, int paramInt2, int paramInt3) {
/* 131 */     a(this.c);
/* 132 */     return (c(paramInt1, paramInt2, paramInt3) != null);
/*     */   }
/*     */   
/*     */   protected StructureStart c(int paramInt1, int paramInt2, int paramInt3) {
/* 136 */     for (StructureStart structureStart : this.d.values()) {
/* 137 */       if (structureStart.d() && 
/* 138 */         structureStart.a().a(paramInt1, paramInt3, paramInt1, paramInt3)) {
/*     */         
/* 140 */         Iterator<StructurePiece> iterator = structureStart.b().iterator();
/* 141 */         while (iterator.hasNext()) {
/* 142 */           StructurePiece structurePiece = iterator.next();
/* 143 */           if (structurePiece.c().b(paramInt1, paramInt2, paramInt3)) {
/* 144 */             return structureStart;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 150 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean d(int paramInt1, int paramInt2, int paramInt3) {
/* 164 */     a(this.c);
/*     */     
/* 166 */     for (StructureStart structureStart : this.d.values()) {
/* 167 */       if (structureStart.d()) {
/* 168 */         return structureStart.a().a(paramInt1, paramInt3, paramInt1, paramInt3);
/*     */       }
/*     */     } 
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkPosition getNearestGeneratedFeature(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 178 */     this.c = paramWorld;
/*     */     
/* 180 */     a(paramWorld);
/*     */     
/* 182 */     this.b.setSeed(paramWorld.getSeed());
/* 183 */     long l1 = this.b.nextLong();
/* 184 */     long l2 = this.b.nextLong();
/* 185 */     long l3 = (paramInt1 >> 4) * l1;
/* 186 */     long l4 = (paramInt3 >> 4) * l2;
/* 187 */     this.b.setSeed(l3 ^ l4 ^ paramWorld.getSeed());
/*     */     
/* 189 */     a(paramWorld, paramInt1 >> 4, paramInt3 >> 4, 0, 0, (Block[])null);
/*     */     
/* 191 */     double d = Double.MAX_VALUE;
/* 192 */     ChunkPosition chunkPosition = null;
/*     */     
/* 194 */     for (StructureStart structureStart : this.d.values()) {
/* 195 */       if (structureStart.d()) {
/*     */         
/* 197 */         StructurePiece structurePiece = structureStart.b().get(0);
/* 198 */         ChunkPosition chunkPosition1 = structurePiece.a();
/*     */         
/* 200 */         int i = chunkPosition1.x - paramInt1;
/* 201 */         int j = chunkPosition1.y - paramInt2;
/* 202 */         int k = chunkPosition1.z - paramInt3;
/* 203 */         double d1 = (i * i + j * j + k * k);
/*     */         
/* 205 */         if (d1 < d) {
/* 206 */           d = d1;
/* 207 */           chunkPosition = chunkPosition1;
/*     */         } 
/*     */       } 
/*     */     } 
/* 211 */     if (chunkPosition != null) {
/* 212 */       return chunkPosition;
/*     */     }
/* 214 */     List list = o_();
/* 215 */     if (list != null) {
/* 216 */       ChunkPosition chunkPosition1 = null;
/* 217 */       for (ChunkPosition chunkPosition2 : list) {
/*     */         
/* 219 */         int i = chunkPosition2.x - paramInt1;
/* 220 */         int j = chunkPosition2.y - paramInt2;
/* 221 */         int k = chunkPosition2.z - paramInt3;
/* 222 */         double d1 = (i * i + j * j + k * k);
/*     */         
/* 224 */         if (d1 < d) {
/* 225 */           d = d1;
/* 226 */           chunkPosition1 = chunkPosition2;
/*     */         } 
/*     */       } 
/* 229 */       return chunkPosition1;
/*     */     } 
/*     */     
/* 232 */     return null;
/*     */   }
/*     */   
/*     */   protected List o_() {
/* 236 */     return null;
/*     */   }
/*     */   
/*     */   private void a(World paramWorld) {
/* 240 */     if (this.e == null) {
/* 241 */       this.e = (PersistentStructure)paramWorld.a(PersistentStructure.class, a());
/*     */       
/* 243 */       if (this.e == null) {
/* 244 */         this.e = new PersistentStructure(a());
/* 245 */         paramWorld.a(a(), this.e);
/*     */       } else {
/* 247 */         NBTTagCompound nBTTagCompound = this.e.a();
/*     */         
/* 249 */         for (String str : nBTTagCompound.c()) {
/* 250 */           NBTBase nBTBase = nBTTagCompound.get(str);
/* 251 */           if (nBTBase.getTypeId() == 10) {
/* 252 */             NBTTagCompound nBTTagCompound1 = (NBTTagCompound)nBTBase;
/*     */             
/* 254 */             if (nBTTagCompound1.hasKey("ChunkX") && nBTTagCompound1.hasKey("ChunkZ")) {
/* 255 */               int i = nBTTagCompound1.getInt("ChunkX");
/* 256 */               int j = nBTTagCompound1.getInt("ChunkZ");
/*     */               
/* 258 */               StructureStart structureStart = WorldGenFactory.a(nBTTagCompound1, paramWorld);
/* 259 */               if (structureStart != null) {
/* 260 */                 this.d.put(Long.valueOf(ChunkCoordIntPair.a(i, j)), structureStart);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(int paramInt1, int paramInt2, StructureStart paramStructureStart) {
/* 270 */     this.e.a(paramStructureStart.a(paramInt1, paramInt2), paramInt1, paramInt2);
/* 271 */     this.e.c();
/*     */   }
/*     */   
/*     */   protected abstract boolean a(int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract StructureStart b(int paramInt1, int paramInt2);
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\StructureGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */