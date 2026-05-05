/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.zip.DataFormatException;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.Inflater;
/*     */ 
/*     */ public class PacketPlayOutMapChunkBulk
/*     */   extends Packet {
/*     */   private int[] a;
/*     */   private int[] b;
/*     */   private int[] c;
/*     */   private int[] d;
/*     */   private byte[] buffer;
/*     */   private byte[][] inflatedBuffers;
/*     */   private int size;
/*     */   private boolean h;
/*  19 */   private byte[] buildBuffer = new byte[0];
/*     */   
/*  21 */   static final ThreadLocal<Deflater> localDeflater = new ThreadLocal<Deflater>()
/*     */     {
/*     */       protected Deflater initialValue()
/*     */       {
/*  25 */         return new Deflater(6);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public PacketPlayOutMapChunkBulk() {}
/*     */   
/*     */   public PacketPlayOutMapChunkBulk(List<Chunk> list) {
/*  33 */     int i = list.size();
/*     */     
/*  35 */     this.a = new int[i];
/*  36 */     this.b = new int[i];
/*  37 */     this.c = new int[i];
/*  38 */     this.d = new int[i];
/*  39 */     this.inflatedBuffers = new byte[i][];
/*  40 */     this.h = (!list.isEmpty() && !((Chunk)list.get(0)).world.worldProvider.g);
/*  41 */     int j = 0;
/*     */     
/*  43 */     for (int k = 0; k < i; k++) {
/*  44 */       Chunk chunk = list.get(k);
/*  45 */       ChunkMap chunkmap = PacketPlayOutMapChunk.a(chunk, true, 65535);
/*     */       
/*  47 */       if (this.buildBuffer.length < j + chunkmap.a.length) {
/*  48 */         byte[] abyte = new byte[j + chunkmap.a.length];
/*     */         
/*  50 */         System.arraycopy(this.buildBuffer, 0, abyte, 0, this.buildBuffer.length);
/*  51 */         this.buildBuffer = abyte;
/*     */       } 
/*     */       
/*  54 */       System.arraycopy(chunkmap.a, 0, this.buildBuffer, j, chunkmap.a.length);
/*  55 */       j += chunkmap.a.length;
/*  56 */       this.a[k] = chunk.locX;
/*  57 */       this.b[k] = chunk.locZ;
/*  58 */       this.c[k] = chunkmap.b;
/*  59 */       this.d[k] = chunkmap.c;
/*  60 */       this.inflatedBuffers[k] = chunkmap.a;
/*     */     } 
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
/*     */   public void compress() {
/*  79 */     if (this.buffer != null) {
/*     */       return;
/*     */     }
/*     */     
/*  83 */     Deflater deflater = localDeflater.get();
/*  84 */     deflater.reset();
/*  85 */     deflater.setInput(this.buildBuffer);
/*  86 */     deflater.finish();
/*     */     
/*  88 */     this.buffer = new byte[this.buildBuffer.length + 100];
/*  89 */     this.size = deflater.deflate(this.buffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int c() {
/*  94 */     return 5;
/*     */   }
/*     */   
/*     */   public void a(PacketDataSerializer packetdataserializer) throws IOException {
/*  98 */     short short1 = packetdataserializer.readShort();
/*     */     
/* 100 */     this.size = packetdataserializer.readInt();
/* 101 */     this.h = packetdataserializer.readBoolean();
/* 102 */     this.a = new int[short1];
/* 103 */     this.b = new int[short1];
/* 104 */     this.c = new int[short1];
/* 105 */     this.d = new int[short1];
/* 106 */     this.inflatedBuffers = new byte[short1][];
/* 107 */     if (this.buildBuffer.length < this.size) {
/* 108 */       this.buildBuffer = new byte[this.size];
/*     */     }
/*     */     
/* 111 */     packetdataserializer.readBytes(this.buildBuffer, 0, this.size);
/* 112 */     byte[] abyte = new byte[PacketPlayOutMapChunk.c() * short1];
/* 113 */     Inflater inflater = new Inflater();
/*     */     
/* 115 */     inflater.setInput(this.buildBuffer, 0, this.size);
/*     */     
/*     */     try {
/* 118 */       inflater.inflate(abyte);
/* 119 */     } catch (DataFormatException dataformatexception) {
/* 120 */       throw new IOException("Bad compressed data format");
/*     */     } finally {
/* 122 */       inflater.end();
/*     */     } 
/*     */     
/* 125 */     int i = 0;
/*     */     
/* 127 */     for (int j = 0; j < short1; j++) {
/* 128 */       this.a[j] = packetdataserializer.readInt();
/* 129 */       this.b[j] = packetdataserializer.readInt();
/* 130 */       this.c[j] = packetdataserializer.readShort();
/* 131 */       this.d[j] = packetdataserializer.readShort();
/* 132 */       int k = 0;
/* 133 */       int l = 0;
/*     */       
/*     */       int i1;
/*     */       
/* 137 */       for (i1 = 0; i1 < 16; i1++) {
/* 138 */         k += this.c[j] >> i1 & 0x1;
/* 139 */         l += this.d[j] >> i1 & 0x1;
/*     */       } 
/*     */       
/* 142 */       i1 = 8192 * k + 256;
/* 143 */       i1 += 2048 * l;
/* 144 */       if (this.h) {
/* 145 */         i1 += 2048 * k;
/*     */       }
/*     */       
/* 148 */       this.inflatedBuffers[j] = new byte[i1];
/* 149 */       System.arraycopy(abyte, i, this.inflatedBuffers[j], 0, i1);
/* 150 */       i += i1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void b(PacketDataSerializer packetdataserializer) throws IOException {
/* 155 */     compress();
/* 156 */     packetdataserializer.writeShort(this.a.length);
/* 157 */     packetdataserializer.writeInt(this.size);
/* 158 */     packetdataserializer.writeBoolean(this.h);
/* 159 */     packetdataserializer.writeBytes(this.buffer, 0, this.size);
/*     */     
/* 161 */     for (int i = 0; i < this.a.length; i++) {
/* 162 */       packetdataserializer.writeInt(this.a[i]);
/* 163 */       packetdataserializer.writeInt(this.b[i]);
/* 164 */       packetdataserializer.writeShort((short)(this.c[i] & 0xFFFF));
/* 165 */       packetdataserializer.writeShort((short)(this.d[i] & 0xFFFF));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(PacketPlayOutListener packetplayoutlistener) {
/* 170 */     packetplayoutlistener.a(this);
/*     */   }
/*     */   
/*     */   public String b() {
/* 174 */     StringBuilder stringbuilder = new StringBuilder();
/*     */     
/* 176 */     for (int i = 0; i < this.a.length; i++) {
/* 177 */       if (i > 0) {
/* 178 */         stringbuilder.append(", ");
/*     */       }
/*     */       
/* 181 */       stringbuilder.append(String.format("{x=%d, z=%d, sections=%d, adds=%d, data=%d}", new Object[] { Integer.valueOf(this.a[i]), Integer.valueOf(this.b[i]), Integer.valueOf(this.c[i]), Integer.valueOf(this.d[i]), Integer.valueOf((this.inflatedBuffers[i]).length) }));
/*     */     } 
/*     */     
/* 184 */     return String.format("size=%d, chunks=%d[%s]", new Object[] { Integer.valueOf(this.size), Integer.valueOf(this.a.length), stringbuilder });
/*     */   }
/*     */   
/*     */   public void handle(PacketListener packetlistener) {
/* 188 */     a((PacketPlayOutListener)packetlistener);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutMapChunkBulk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */