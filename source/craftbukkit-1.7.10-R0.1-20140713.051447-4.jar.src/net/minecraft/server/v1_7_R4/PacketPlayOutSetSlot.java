/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutSetSlot
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private ItemStack c;
/*    */   
/*    */   public PacketPlayOutSetSlot() {}
/*    */   
/*    */   public PacketPlayOutSetSlot(int paramInt1, int paramInt2, ItemStack paramItemStack) {
/* 20 */     this.a = paramInt1;
/* 21 */     this.b = paramInt2;
/* 22 */     this.c = (paramItemStack == null) ? null : paramItemStack.cloneItemStack();
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 27 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 32 */     this.a = paramPacketDataSerializer.readByte();
/* 33 */     this.b = paramPacketDataSerializer.readShort();
/* 34 */     this.c = paramPacketDataSerializer.c();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 39 */     paramPacketDataSerializer.writeByte(this.a);
/* 40 */     paramPacketDataSerializer.writeShort(this.b);
/* 41 */     paramPacketDataSerializer.a(this.c);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutSetSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */