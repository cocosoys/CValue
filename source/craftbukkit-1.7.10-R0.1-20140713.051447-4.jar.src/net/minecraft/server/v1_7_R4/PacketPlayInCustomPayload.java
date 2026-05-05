/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ public class PacketPlayInCustomPayload
/*    */   extends Packet
/*    */ {
/*    */   private String tag;
/*    */   public int length;
/*    */   private byte[] data;
/*    */   
/*    */   public void a(PacketDataSerializer packetdataserializer) throws IOException {
/* 14 */     this.tag = packetdataserializer.c(20);
/* 15 */     this.length = packetdataserializer.readShort();
/* 16 */     if (this.length > 0 && this.length < 32767) {
/* 17 */       this.data = new byte[this.length];
/* 18 */       packetdataserializer.readBytes(this.data);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void b(PacketDataSerializer packetdataserializer) throws IOException {
/* 23 */     packetdataserializer.a(this.tag);
/* 24 */     packetdataserializer.writeShort((short)this.length);
/* 25 */     if (this.data != null) {
/* 26 */       packetdataserializer.writeBytes(this.data);
/*    */     }
/*    */   }
/*    */   
/*    */   public void a(PacketPlayInListener packetplayinlistener) {
/* 31 */     packetplayinlistener.a(this);
/*    */   }
/*    */   
/*    */   public String c() {
/* 35 */     return this.tag;
/*    */   }
/*    */   
/*    */   public byte[] e() {
/* 39 */     return this.data;
/*    */   }
/*    */   
/*    */   public void handle(PacketListener packetlistener) {
/* 43 */     a((PacketPlayInListener)packetlistener);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInCustomPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */