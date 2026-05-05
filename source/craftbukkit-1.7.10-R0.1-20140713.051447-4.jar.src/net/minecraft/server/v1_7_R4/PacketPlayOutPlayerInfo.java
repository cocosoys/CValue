/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutPlayerInfo
/*    */   extends Packet
/*    */ {
/*    */   private String a;
/*    */   private boolean b;
/*    */   private int c;
/*    */   
/*    */   public PacketPlayOutPlayerInfo() {}
/*    */   
/*    */   public PacketPlayOutPlayerInfo(String paramString, boolean paramBoolean, int paramInt) {
/* 20 */     this.a = paramString;
/* 21 */     this.b = paramBoolean;
/* 22 */     this.c = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 27 */     this.a = paramPacketDataSerializer.c(16);
/* 28 */     this.b = paramPacketDataSerializer.readBoolean();
/* 29 */     this.c = paramPacketDataSerializer.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 34 */     paramPacketDataSerializer.a(this.a);
/* 35 */     paramPacketDataSerializer.writeBoolean(this.b);
/* 36 */     paramPacketDataSerializer.writeShort(this.c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 41 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutPlayerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */