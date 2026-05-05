/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutWindowItems
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private ItemStack[] b;
/*    */   
/*    */   public PacketPlayOutWindowItems() {}
/*    */   
/*    */   public PacketPlayOutWindowItems(int paramInt, List<ItemStack> paramList) {
/* 20 */     this.a = paramInt;
/* 21 */     this.b = new ItemStack[paramList.size()];
/* 22 */     for (byte b = 0; b < this.b.length; b++) {
/* 23 */       ItemStack itemStack = paramList.get(b);
/* 24 */       this.b[b] = (itemStack == null) ? null : itemStack.cloneItemStack();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 30 */     this.a = paramPacketDataSerializer.readUnsignedByte();
/* 31 */     short s = paramPacketDataSerializer.readShort();
/* 32 */     this.b = new ItemStack[s];
/* 33 */     for (byte b = 0; b < s; b++) {
/* 34 */       this.b[b] = paramPacketDataSerializer.c();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 40 */     paramPacketDataSerializer.writeByte(this.a);
/* 41 */     paramPacketDataSerializer.writeShort(this.b.length);
/* 42 */     for (ItemStack itemStack : this.b) {
/* 43 */       paramPacketDataSerializer.a(itemStack);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 49 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutWindowItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */