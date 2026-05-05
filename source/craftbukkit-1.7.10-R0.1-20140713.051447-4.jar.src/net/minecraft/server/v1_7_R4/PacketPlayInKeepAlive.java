/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayInKeepAlive
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 21 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 26 */     this.a = paramPacketDataSerializer.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 31 */     paramPacketDataSerializer.writeInt(this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public int c() {
/* 40 */     return this.a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInKeepAlive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */