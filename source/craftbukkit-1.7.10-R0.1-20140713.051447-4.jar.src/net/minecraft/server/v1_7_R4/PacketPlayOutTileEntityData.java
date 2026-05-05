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
/*    */ 
/*    */ public class PacketPlayOutTileEntityData
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   private NBTTagCompound e;
/*    */   
/*    */   public PacketPlayOutTileEntityData() {}
/*    */   
/*    */   public PacketPlayOutTileEntityData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, NBTTagCompound paramNBTTagCompound) {
/* 28 */     this.a = paramInt1;
/* 29 */     this.b = paramInt2;
/* 30 */     this.c = paramInt3;
/* 31 */     this.d = paramInt4;
/* 32 */     this.e = paramNBTTagCompound;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 37 */     this.a = paramPacketDataSerializer.readInt();
/* 38 */     this.b = paramPacketDataSerializer.readShort();
/* 39 */     this.c = paramPacketDataSerializer.readInt();
/* 40 */     this.d = paramPacketDataSerializer.readUnsignedByte();
/* 41 */     this.e = paramPacketDataSerializer.b();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 46 */     paramPacketDataSerializer.writeInt(this.a);
/* 47 */     paramPacketDataSerializer.writeShort(this.b);
/* 48 */     paramPacketDataSerializer.writeInt(this.c);
/* 49 */     paramPacketDataSerializer.writeByte((byte)this.d);
/* 50 */     paramPacketDataSerializer.a(this.e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 55 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutTileEntityData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */