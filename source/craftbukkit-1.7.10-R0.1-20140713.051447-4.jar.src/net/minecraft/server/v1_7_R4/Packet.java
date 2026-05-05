/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.util.com.google.common.collect.BiMap;
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public abstract class Packet
/*    */ {
/* 12 */   private static final Logger a = LogManager.getLogger();
/* 13 */   public final long timestamp = System.currentTimeMillis();
/*    */ 
/*    */ 
/*    */   
/*    */   public static Packet a(BiMap bimap, int i) {
/*    */     try {
/* 19 */       Class<Packet> oclass = (Class)bimap.get(Integer.valueOf(i));
/*    */       
/* 21 */       return (oclass == null) ? null : oclass.newInstance();
/* 22 */     } catch (Exception exception) {
/* 23 */       a.error("Couldn't create packet " + i, exception);
/* 24 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void a(ByteBuf bytebuf, byte[] abyte) {
/* 29 */     bytebuf.writeShort(abyte.length);
/* 30 */     bytebuf.writeBytes(abyte);
/*    */   }
/*    */   
/*    */   public static byte[] a(ByteBuf bytebuf) throws IOException {
/* 34 */     short short1 = bytebuf.readShort();
/*    */     
/* 36 */     if (short1 < 0) {
/* 37 */       throw new IOException("Key was smaller than nothing!  Weird key!");
/*    */     }
/* 39 */     byte[] abyte = new byte[short1];
/*    */     
/* 41 */     bytebuf.readBytes(abyte);
/* 42 */     return abyte;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void a(PacketDataSerializer paramPacketDataSerializer) throws IOException;
/*    */   
/*    */   public abstract void b(PacketDataSerializer paramPacketDataSerializer) throws IOException;
/*    */   
/*    */   public abstract void handle(PacketListener paramPacketListener);
/*    */   
/*    */   public boolean a() {
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     return getClass().getSimpleName();
/*    */   }
/*    */   
/*    */   public String b() {
/* 61 */     return "";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\Packet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */