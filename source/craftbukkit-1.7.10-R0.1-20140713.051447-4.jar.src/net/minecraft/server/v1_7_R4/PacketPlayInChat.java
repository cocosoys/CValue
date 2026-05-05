/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class PacketPlayInChat
/*    */   extends Packet {
/*    */   private String message;
/*    */   
/*    */   public PacketPlayInChat() {}
/*    */   
/*    */   public PacketPlayInChat(String s) {
/* 12 */     if (s.length() > 100) {
/* 13 */       s = s.substring(0, 100);
/*    */     }
/*    */     
/* 16 */     this.message = s;
/*    */   }
/*    */   
/*    */   public void a(PacketDataSerializer packetdataserializer) throws IOException {
/* 20 */     this.message = packetdataserializer.c(100);
/*    */   }
/*    */   
/*    */   public void b(PacketDataSerializer packetdataserializer) throws IOException {
/* 24 */     packetdataserializer.a(this.message);
/*    */   }
/*    */   
/*    */   public void a(PacketPlayInListener packetplayinlistener) {
/* 28 */     packetplayinlistener.a(this);
/*    */   }
/*    */   
/*    */   public String b() {
/* 32 */     return String.format("message='%s'", new Object[] { this.message });
/*    */   }
/*    */   
/*    */   public String c() {
/* 36 */     return this.message;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 42 */     return !this.message.startsWith("/");
/*    */   }
/*    */ 
/*    */   
/*    */   public void handle(PacketListener packetlistener) {
/* 47 */     a((PacketPlayInListener)packetlistener);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */