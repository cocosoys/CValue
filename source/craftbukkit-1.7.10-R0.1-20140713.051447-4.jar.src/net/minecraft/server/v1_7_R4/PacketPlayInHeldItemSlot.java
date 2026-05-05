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
/*    */ public class PacketPlayInHeldItemSlot
/*    */   extends Packet
/*    */ {
/*    */   private int itemInHandIndex;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 20 */     this.itemInHandIndex = paramPacketDataSerializer.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 25 */     paramPacketDataSerializer.writeShort(this.itemInHandIndex);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 30 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */   
/*    */   public int c() {
/* 34 */     return this.itemInHandIndex;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInHeldItemSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */