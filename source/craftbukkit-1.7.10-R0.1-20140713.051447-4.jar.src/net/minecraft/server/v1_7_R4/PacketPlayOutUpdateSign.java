/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutUpdateSign
/*    */   extends Packet
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int z;
/*    */   private String[] lines;
/*    */   
/*    */   public PacketPlayOutUpdateSign() {}
/*    */   
/*    */   public PacketPlayOutUpdateSign(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString) {
/* 19 */     this.x = paramInt1;
/* 20 */     this.y = paramInt2;
/* 21 */     this.z = paramInt3;
/* 22 */     this.lines = new String[] { paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3] };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 29 */     this.x = paramPacketDataSerializer.readInt();
/* 30 */     this.y = paramPacketDataSerializer.readShort();
/* 31 */     this.z = paramPacketDataSerializer.readInt();
/* 32 */     this.lines = new String[4];
/* 33 */     for (byte b = 0; b < 4; b++) {
/* 34 */       this.lines[b] = paramPacketDataSerializer.c(15);
/*    */     }
/*    */   }
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 39 */     paramPacketDataSerializer.writeInt(this.x);
/* 40 */     paramPacketDataSerializer.writeShort(this.y);
/* 41 */     paramPacketDataSerializer.writeInt(this.z);
/* 42 */     for (byte b = 0; b < 4; b++) {
/* 43 */       paramPacketDataSerializer.a(this.lines[b]);
/*    */     }
/*    */   }
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 48 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutUpdateSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */