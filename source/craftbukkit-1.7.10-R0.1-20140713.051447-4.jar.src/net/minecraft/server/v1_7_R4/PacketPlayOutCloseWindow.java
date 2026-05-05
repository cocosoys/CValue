/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutCloseWindow
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   
/*    */   public PacketPlayOutCloseWindow() {}
/*    */   
/*    */   public PacketPlayOutCloseWindow(int paramInt) {
/* 17 */     this.a = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 22 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 27 */     this.a = paramPacketDataSerializer.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 32 */     paramPacketDataSerializer.writeByte(this.a);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutCloseWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */