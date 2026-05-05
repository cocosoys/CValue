/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class PacketPlayOutSpawnPosition
/*    */   extends Packet {
/*    */   public int x;
/*    */   public int y;
/*    */   public int z;
/*    */   
/*    */   public PacketPlayOutSpawnPosition() {}
/*    */   
/*    */   public PacketPlayOutSpawnPosition(int i, int j, int k) {
/* 12 */     this.x = i;
/* 13 */     this.y = j;
/* 14 */     this.z = k;
/*    */   }
/*    */   
/*    */   public void a(PacketDataSerializer packetdataserializer) {
/* 18 */     this.x = packetdataserializer.readInt();
/* 19 */     this.y = packetdataserializer.readInt();
/* 20 */     this.z = packetdataserializer.readInt();
/*    */   }
/*    */   
/*    */   public void b(PacketDataSerializer packetdataserializer) {
/* 24 */     packetdataserializer.writeInt(this.x);
/* 25 */     packetdataserializer.writeInt(this.y);
/* 26 */     packetdataserializer.writeInt(this.z);
/*    */   }
/*    */   
/*    */   public void a(PacketPlayOutListener packetplayoutlistener) {
/* 30 */     packetplayoutlistener.a(this);
/*    */   }
/*    */   
/*    */   public boolean a() {
/* 34 */     return false;
/*    */   }
/*    */   
/*    */   public String b() {
/* 38 */     return String.format("x=%d, y=%d, z=%d", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.z) });
/*    */   }
/*    */   
/*    */   public void handle(PacketListener packetlistener) {
/* 42 */     a((PacketPlayOutListener)packetlistener);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutSpawnPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */