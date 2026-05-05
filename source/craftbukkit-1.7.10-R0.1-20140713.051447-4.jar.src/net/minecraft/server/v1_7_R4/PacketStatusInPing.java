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
/*    */ public class PacketStatusInPing
/*    */   extends Packet
/*    */ {
/*    */   private long a;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 21 */     this.a = paramPacketDataSerializer.readLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 26 */     paramPacketDataSerializer.writeLong(this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketStatusInListener paramPacketStatusInListener) {
/* 31 */     paramPacketStatusInListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public long c() {
/* 40 */     return this.a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketStatusInPing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */