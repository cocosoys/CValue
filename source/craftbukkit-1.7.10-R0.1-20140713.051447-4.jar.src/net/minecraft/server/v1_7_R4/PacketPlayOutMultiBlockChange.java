/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutMultiBlockChange
/*    */   extends Packet
/*    */ {
/* 18 */   private static final Logger a = LogManager.getLogger();
/*    */   
/*    */   private ChunkCoordIntPair b;
/*    */   
/*    */   private byte[] c;
/*    */   
/*    */   private int d;
/*    */   
/*    */   public PacketPlayOutMultiBlockChange() {}
/*    */   
/*    */   public PacketPlayOutMultiBlockChange(int paramInt, short[] paramArrayOfshort, Chunk paramChunk) {
/* 29 */     this.b = new ChunkCoordIntPair(paramChunk.locX, paramChunk.locZ);
/* 30 */     this.d = paramInt;
/*    */     
/* 32 */     int i = 4 * paramInt;
/*    */     
/*    */     try {
/* 35 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
/* 36 */       DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*    */       
/* 38 */       for (byte b = 0; b < paramInt; b++) {
/* 39 */         int j = paramArrayOfshort[b] >> 12 & 0xF;
/* 40 */         int k = paramArrayOfshort[b] >> 8 & 0xF;
/* 41 */         int m = paramArrayOfshort[b] & 0xFF;
/*    */         
/* 43 */         dataOutputStream.writeShort(paramArrayOfshort[b]);
/* 44 */         dataOutputStream.writeShort((short)((Block.getId(paramChunk.getType(j, m, k)) & 0xFFF) << 4 | paramChunk.getData(j, m, k) & 0xF));
/*    */       } 
/*    */       
/* 47 */       this.c = byteArrayOutputStream.toByteArray();
/* 48 */       if (this.c.length != i) {
/* 49 */         throw new RuntimeException("Expected length " + i + " doesn't match received length " + this.c.length);
/*    */       }
/* 51 */     } catch (IOException iOException) {
/* 52 */       a.error("Couldn't create bulk block update packet", iOException);
/* 53 */       this.c = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 59 */     this.b = new ChunkCoordIntPair(paramPacketDataSerializer.readInt(), paramPacketDataSerializer.readInt());
/* 60 */     this.d = paramPacketDataSerializer.readShort() & 0xFFFF;
/* 61 */     int i = paramPacketDataSerializer.readInt();
/* 62 */     if (i > 0) {
/* 63 */       this.c = new byte[i];
/* 64 */       paramPacketDataSerializer.readBytes(this.c);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 70 */     paramPacketDataSerializer.writeInt(this.b.x);
/* 71 */     paramPacketDataSerializer.writeInt(this.b.z);
/* 72 */     paramPacketDataSerializer.writeShort((short)this.d);
/* 73 */     if (this.c != null) {
/* 74 */       paramPacketDataSerializer.writeInt(this.c.length);
/* 75 */       paramPacketDataSerializer.writeBytes(this.c);
/*    */     } else {
/* 77 */       paramPacketDataSerializer.writeInt(0);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 83 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 88 */     return String.format("xc=%d, zc=%d, count=%d", new Object[] { Integer.valueOf(this.b.x), Integer.valueOf(this.b.z), Integer.valueOf(this.d) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutMultiBlockChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */