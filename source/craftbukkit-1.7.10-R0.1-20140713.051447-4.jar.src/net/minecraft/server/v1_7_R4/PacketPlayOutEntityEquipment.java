/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutEntityEquipment
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private ItemStack c;
/*    */   
/*    */   public PacketPlayOutEntityEquipment() {}
/*    */   
/*    */   public PacketPlayOutEntityEquipment(int paramInt1, int paramInt2, ItemStack paramItemStack) {
/* 18 */     this.a = paramInt1;
/* 19 */     this.b = paramInt2;
/* 20 */     this.c = (paramItemStack == null) ? null : paramItemStack.cloneItemStack();
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 25 */     this.a = paramPacketDataSerializer.readInt();
/* 26 */     this.b = paramPacketDataSerializer.readShort();
/* 27 */     this.c = paramPacketDataSerializer.c();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 32 */     paramPacketDataSerializer.writeInt(this.a);
/* 33 */     paramPacketDataSerializer.writeShort(this.b);
/* 34 */     paramPacketDataSerializer.a(this.c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 39 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String b() {
/* 48 */     return String.format("entity=%d, slot=%d, item=%s", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), this.c });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutEntityEquipment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */