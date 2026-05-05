/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.zip.DataFormatException;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.Inflater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PacketPlayOutMapChunk
/*     */   extends Packet
/*     */ {
/*     */   private int a;
/*     */   private int b;
/*     */   private int c;
/*     */   private int d;
/*     */   private byte[] e;
/*     */   private byte[] f;
/*     */   private boolean g;
/*     */   private int h;
/*  27 */   private static byte[] i = new byte[196864];
/*     */ 
/*     */   
/*     */   public PacketPlayOutMapChunk() {}
/*     */ 
/*     */   
/*     */   public PacketPlayOutMapChunk(Chunk paramChunk, boolean paramBoolean, int paramInt) {
/*  34 */     this.a = paramChunk.locX;
/*  35 */     this.b = paramChunk.locZ;
/*  36 */     this.g = paramBoolean;
/*     */     
/*  38 */     ChunkMap chunkMap = a(paramChunk, paramBoolean, paramInt);
/*  39 */     Deflater deflater = new Deflater(-1);
/*  40 */     this.d = chunkMap.c;
/*  41 */     this.c = chunkMap.b;
/*     */     
/*     */     try {
/*  44 */       this.f = chunkMap.a;
/*  45 */       deflater.setInput(chunkMap.a, 0, chunkMap.a.length);
/*  46 */       deflater.finish();
/*  47 */       this.e = new byte[chunkMap.a.length];
/*  48 */       this.h = deflater.deflate(this.e);
/*     */     } finally {
/*  50 */       deflater.end();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int c() {
/*  55 */     return 196864;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/*  60 */     this.a = paramPacketDataSerializer.readInt();
/*  61 */     this.b = paramPacketDataSerializer.readInt();
/*  62 */     this.g = paramPacketDataSerializer.readBoolean();
/*  63 */     this.c = paramPacketDataSerializer.readShort();
/*  64 */     this.d = paramPacketDataSerializer.readShort();
/*     */     
/*  66 */     this.h = paramPacketDataSerializer.readInt();
/*  67 */     if (i.length < this.h) {
/*  68 */       i = new byte[this.h];
/*     */     }
/*  70 */     paramPacketDataSerializer.readBytes(i, 0, this.h);
/*     */     
/*  72 */     int i = 0; int j;
/*  73 */     for (j = 0; j < 16; j++) {
/*  74 */       i += this.c >> j & 0x1;
/*     */     }
/*  76 */     j = 12288 * i;
/*  77 */     if (this.g) {
/*  78 */       j += 256;
/*     */     }
/*     */     
/*  81 */     this.f = new byte[j];
/*     */     
/*  83 */     Inflater inflater = new Inflater();
/*  84 */     inflater.setInput(i, 0, this.h);
/*     */     try {
/*  86 */       inflater.inflate(this.f);
/*  87 */     } catch (DataFormatException dataFormatException) {
/*  88 */       throw new IOException("Bad compressed data format");
/*     */     } finally {
/*  90 */       inflater.end();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/*  96 */     paramPacketDataSerializer.writeInt(this.a);
/*  97 */     paramPacketDataSerializer.writeInt(this.b);
/*  98 */     paramPacketDataSerializer.writeBoolean(this.g);
/*  99 */     paramPacketDataSerializer.writeShort((short)(this.c & 0xFFFF));
/* 100 */     paramPacketDataSerializer.writeShort((short)(this.d & 0xFFFF));
/*     */     
/* 102 */     paramPacketDataSerializer.writeInt(this.h);
/* 103 */     paramPacketDataSerializer.writeBytes(this.e, 0, this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 108 */     paramPacketPlayOutListener.a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String b() {
/* 113 */     return String.format("x=%d, z=%d, full=%b, sects=%d, add=%d, size=%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Boolean.valueOf(this.g), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.h) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ChunkMap a(Chunk paramChunk, boolean paramBoolean, int paramInt) {
/* 121 */     int i = 0;
/* 122 */     ChunkSection[] arrayOfChunkSection = paramChunk.getSections();
/* 123 */     byte b1 = 0;
/* 124 */     ChunkMap chunkMap = new ChunkMap();
/* 125 */     byte[] arrayOfByte = i;
/*     */     
/* 127 */     if (paramBoolean) {
/* 128 */       paramChunk.q = true;
/*     */     }
/*     */     byte b2;
/* 131 */     for (b2 = 0; b2 < arrayOfChunkSection.length; b2++) {
/* 132 */       if (arrayOfChunkSection[b2] != null && (!paramBoolean || !arrayOfChunkSection[b2].isEmpty()) && (paramInt & 1 << b2) != 0) {
/* 133 */         chunkMap.b |= 1 << b2;
/*     */         
/* 135 */         if (arrayOfChunkSection[b2].getExtendedIdArray() != null) {
/* 136 */           chunkMap.c |= 1 << b2;
/* 137 */           b1++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 144 */     for (b2 = 0; b2 < arrayOfChunkSection.length; b2++) {
/* 145 */       if (arrayOfChunkSection[b2] != null && (!paramBoolean || !arrayOfChunkSection[b2].isEmpty()) && (paramInt & 1 << b2) != 0) {
/* 146 */         byte[] arrayOfByte1 = arrayOfChunkSection[b2].getIdArray();
/* 147 */         System.arraycopy(arrayOfByte1, 0, arrayOfByte, i, arrayOfByte1.length);
/* 148 */         i += arrayOfByte1.length;
/*     */       } 
/*     */     } 
/* 151 */     for (b2 = 0; b2 < arrayOfChunkSection.length; b2++) {
/* 152 */       if (arrayOfChunkSection[b2] != null && (!paramBoolean || !arrayOfChunkSection[b2].isEmpty()) && (paramInt & 1 << b2) != 0) {
/* 153 */         NibbleArray nibbleArray = arrayOfChunkSection[b2].getDataArray();
/* 154 */         System.arraycopy(nibbleArray.a, 0, arrayOfByte, i, nibbleArray.a.length);
/* 155 */         i += nibbleArray.a.length;
/*     */       } 
/*     */     } 
/* 158 */     for (b2 = 0; b2 < arrayOfChunkSection.length; b2++) {
/* 159 */       if (arrayOfChunkSection[b2] != null && (!paramBoolean || !arrayOfChunkSection[b2].isEmpty()) && (paramInt & 1 << b2) != 0) {
/* 160 */         NibbleArray nibbleArray = arrayOfChunkSection[b2].getEmittedLightArray();
/* 161 */         System.arraycopy(nibbleArray.a, 0, arrayOfByte, i, nibbleArray.a.length);
/* 162 */         i += nibbleArray.a.length;
/*     */       } 
/*     */     } 
/* 165 */     if (!paramChunk.world.worldProvider.g) {
/* 166 */       for (b2 = 0; b2 < arrayOfChunkSection.length; b2++) {
/* 167 */         if (arrayOfChunkSection[b2] != null && (!paramBoolean || !arrayOfChunkSection[b2].isEmpty()) && (paramInt & 1 << b2) != 0) {
/* 168 */           NibbleArray nibbleArray = arrayOfChunkSection[b2].getSkyLightArray();
/* 169 */           System.arraycopy(nibbleArray.a, 0, arrayOfByte, i, nibbleArray.a.length);
/* 170 */           i += nibbleArray.a.length;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 175 */     if (b1 > 0) {
/* 176 */       for (b2 = 0; b2 < arrayOfChunkSection.length; b2++) {
/* 177 */         if (arrayOfChunkSection[b2] != null && (!paramBoolean || !arrayOfChunkSection[b2].isEmpty()) && arrayOfChunkSection[b2].getExtendedIdArray() != null && (paramInt & 1 << b2) != 0) {
/* 178 */           NibbleArray nibbleArray = arrayOfChunkSection[b2].getExtendedIdArray();
/* 179 */           System.arraycopy(nibbleArray.a, 0, arrayOfByte, i, nibbleArray.a.length);
/* 180 */           i += nibbleArray.a.length;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 185 */     if (paramBoolean) {
/* 186 */       byte[] arrayOfByte1 = paramChunk.m();
/* 187 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte, i, arrayOfByte1.length);
/* 188 */       i += arrayOfByte1.length;
/*     */     } 
/*     */     
/* 191 */     chunkMap.a = new byte[i];
/* 192 */     System.arraycopy(arrayOfByte, 0, chunkMap.a, 0, i);
/*     */     
/* 194 */     return chunkMap;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutMapChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */