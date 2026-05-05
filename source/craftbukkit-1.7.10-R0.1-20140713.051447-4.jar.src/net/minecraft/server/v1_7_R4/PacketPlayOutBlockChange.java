/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class PacketPlayOutBlockChange
/*    */   extends Packet {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   public Block block;
/*    */   public int data;
/*    */   
/*    */   public PacketPlayOutBlockChange() {}
/*    */   
/*    */   public PacketPlayOutBlockChange(int i, int j, int k, World world) {
/* 14 */     this.a = i;
/* 15 */     this.b = j;
/* 16 */     this.c = k;
/* 17 */     this.block = world.getType(i, j, k);
/* 18 */     this.data = world.getData(i, j, k);
/*    */   }
/*    */   
/*    */   public void a(PacketDataSerializer packetdataserializer) {
/* 22 */     this.a = packetdataserializer.readInt();
/* 23 */     this.b = packetdataserializer.readUnsignedByte();
/* 24 */     this.c = packetdataserializer.readInt();
/* 25 */     this.block = Block.getById(packetdataserializer.a());
/* 26 */     this.data = packetdataserializer.readUnsignedByte();
/*    */   }
/*    */   
/*    */   public void b(PacketDataSerializer packetdataserializer) {
/* 30 */     packetdataserializer.writeInt(this.a);
/* 31 */     packetdataserializer.writeByte(this.b);
/* 32 */     packetdataserializer.writeInt(this.c);
/* 33 */     packetdataserializer.b(Block.getId(this.block));
/* 34 */     packetdataserializer.writeByte(this.data);
/*    */   }
/*    */   
/*    */   public void a(PacketPlayOutListener packetplayoutlistener) {
/* 38 */     packetplayoutlistener.a(this);
/*    */   }
/*    */   
/*    */   public String b() {
/* 42 */     return String.format("type=%d, data=%d, x=%d, y=%d, z=%d", new Object[] { Integer.valueOf(Block.getId(this.block)), Integer.valueOf(this.data), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c) });
/*    */   }
/*    */   
/*    */   public void handle(PacketListener packetlistener) {
/* 46 */     a((PacketPlayOutListener)packetlistener);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutBlockChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */