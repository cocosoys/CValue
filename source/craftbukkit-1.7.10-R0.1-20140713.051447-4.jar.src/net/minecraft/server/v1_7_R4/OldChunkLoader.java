/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OldChunkLoader
/*     */ {
/*     */   public static OldChunk a(NBTTagCompound paramNBTTagCompound) {
/*  13 */     int i = paramNBTTagCompound.getInt("xPos");
/*  14 */     int j = paramNBTTagCompound.getInt("zPos");
/*     */     
/*  16 */     OldChunk oldChunk = new OldChunk(i, j);
/*  17 */     oldChunk.g = paramNBTTagCompound.getByteArray("Blocks");
/*  18 */     oldChunk.f = new OldNibbleArray(paramNBTTagCompound.getByteArray("Data"), 7);
/*  19 */     oldChunk.e = new OldNibbleArray(paramNBTTagCompound.getByteArray("SkyLight"), 7);
/*  20 */     oldChunk.d = new OldNibbleArray(paramNBTTagCompound.getByteArray("BlockLight"), 7);
/*  21 */     oldChunk.c = paramNBTTagCompound.getByteArray("HeightMap");
/*  22 */     oldChunk.b = paramNBTTagCompound.getBoolean("TerrainPopulated");
/*  23 */     oldChunk.h = paramNBTTagCompound.getList("Entities", 10);
/*  24 */     oldChunk.i = paramNBTTagCompound.getList("TileEntities", 10);
/*  25 */     oldChunk.j = paramNBTTagCompound.getList("TileTicks", 10);
/*     */ 
/*     */     
/*     */     try {
/*  29 */       oldChunk.a = paramNBTTagCompound.getLong("LastUpdate");
/*  30 */     } catch (ClassCastException classCastException) {
/*  31 */       oldChunk.a = paramNBTTagCompound.getInt("LastUpdate");
/*     */     } 
/*     */     
/*  34 */     return oldChunk;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void a(OldChunk paramOldChunk, NBTTagCompound paramNBTTagCompound, WorldChunkManager paramWorldChunkManager) {
/*  39 */     paramNBTTagCompound.setInt("xPos", paramOldChunk.k);
/*  40 */     paramNBTTagCompound.setInt("zPos", paramOldChunk.l);
/*  41 */     paramNBTTagCompound.setLong("LastUpdate", paramOldChunk.a);
/*  42 */     int[] arrayOfInt = new int[paramOldChunk.c.length];
/*  43 */     for (byte b1 = 0; b1 < paramOldChunk.c.length; b1++) {
/*  44 */       arrayOfInt[b1] = paramOldChunk.c[b1];
/*     */     }
/*  46 */     paramNBTTagCompound.setIntArray("HeightMap", arrayOfInt);
/*  47 */     paramNBTTagCompound.setBoolean("TerrainPopulated", paramOldChunk.b);
/*     */     
/*  49 */     NBTTagList nBTTagList = new NBTTagList();
/*  50 */     for (byte b2 = 0; b2 < 8; b2++) {
/*     */ 
/*     */       
/*  53 */       boolean bool = true;
/*  54 */       for (byte b = 0; b < 16 && bool; b++) {
/*  55 */         for (byte b4 = 0; b4 < 16 && bool; b4++) {
/*  56 */           for (byte b5 = 0; b5 < 16; b5++) {
/*  57 */             int i = b << 11 | b5 << 7 | b4 + (b2 << 4);
/*  58 */             byte b6 = paramOldChunk.g[i];
/*  59 */             if (b6 != 0) {
/*  60 */               bool = false;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*  67 */       if (!bool) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  72 */         byte[] arrayOfByte1 = new byte[4096];
/*  73 */         NibbleArray nibbleArray1 = new NibbleArray(arrayOfByte1.length, 4);
/*  74 */         NibbleArray nibbleArray2 = new NibbleArray(arrayOfByte1.length, 4);
/*  75 */         NibbleArray nibbleArray3 = new NibbleArray(arrayOfByte1.length, 4);
/*     */         
/*  77 */         for (byte b4 = 0; b4 < 16; b4++) {
/*  78 */           for (byte b5 = 0; b5 < 16; b5++) {
/*  79 */             for (byte b6 = 0; b6 < 16; b6++) {
/*  80 */               int i = b4 << 11 | b6 << 7 | b5 + (b2 << 4);
/*  81 */               byte b7 = paramOldChunk.g[i];
/*     */               
/*  83 */               arrayOfByte1[b5 << 8 | b6 << 4 | b4] = (byte)(b7 & 0xFF);
/*  84 */               nibbleArray1.a(b4, b5, b6, paramOldChunk.f.a(b4, b5 + (b2 << 4), b6));
/*  85 */               nibbleArray2.a(b4, b5, b6, paramOldChunk.e.a(b4, b5 + (b2 << 4), b6));
/*  86 */               nibbleArray3.a(b4, b5, b6, paramOldChunk.d.a(b4, b5 + (b2 << 4), b6));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*  91 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */         
/*  93 */         nBTTagCompound.setByte("Y", (byte)(b2 & 0xFF));
/*  94 */         nBTTagCompound.setByteArray("Blocks", arrayOfByte1);
/*  95 */         nBTTagCompound.setByteArray("Data", nibbleArray1.a);
/*  96 */         nBTTagCompound.setByteArray("SkyLight", nibbleArray2.a);
/*  97 */         nBTTagCompound.setByteArray("BlockLight", nibbleArray3.a);
/*     */         
/*  99 */         nBTTagList.add(nBTTagCompound);
/*     */       } 
/* 101 */     }  paramNBTTagCompound.set("Sections", nBTTagList);
/*     */ 
/*     */     
/* 104 */     byte[] arrayOfByte = new byte[256];
/* 105 */     for (byte b3 = 0; b3 < 16; b3++) {
/* 106 */       for (byte b = 0; b < 16; b++) {
/* 107 */         arrayOfByte[b << 4 | b3] = (byte)((paramWorldChunkManager.getBiome(paramOldChunk.k << 4 | b3, paramOldChunk.l << 4 | b)).id & 0xFF);
/*     */       }
/*     */     } 
/* 110 */     paramNBTTagCompound.setByteArray("Biomes", arrayOfByte);
/* 111 */     paramNBTTagCompound.set("Entities", paramOldChunk.h);
/* 112 */     paramNBTTagCompound.set("TileEntities", paramOldChunk.i);
/* 113 */     if (paramOldChunk.j != null)
/* 114 */       paramNBTTagCompound.set("TileTicks", paramOldChunk.j); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\OldChunkLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */