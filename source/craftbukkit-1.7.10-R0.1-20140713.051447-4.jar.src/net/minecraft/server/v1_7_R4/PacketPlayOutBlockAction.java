/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutBlockAction
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   private int e;
/*    */   private Block f;
/*    */   
/*    */   public PacketPlayOutBlockAction() {}
/*    */   
/*    */   public PacketPlayOutBlockAction(int paramInt1, int paramInt2, int paramInt3, Block paramBlock, int paramInt4, int paramInt5) {
/* 22 */     this.a = paramInt1;
/* 23 */     this.b = paramInt2;
/* 24 */     this.c = paramInt3;
/* 25 */     this.d = paramInt4;
/* 26 */     this.e = paramInt5;
/* 27 */     this.f = paramBlock;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 32 */     this.a = paramPacketDataSerializer.readInt();
/* 33 */     this.b = paramPacketDataSerializer.readShort();
/* 34 */     this.c = paramPacketDataSerializer.readInt();
/* 35 */     this.d = paramPacketDataSerializer.readUnsignedByte();
/* 36 */     this.e = paramPacketDataSerializer.readUnsignedByte();
/* 37 */     this.f = Block.getById(paramPacketDataSerializer.a() & 0xFFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 42 */     paramPacketDataSerializer.writeInt(this.a);
/* 43 */     paramPacketDataSerializer.writeShort(this.b);
/* 44 */     paramPacketDataSerializer.writeInt(this.c);
/* 45 */     paramPacketDataSerializer.writeByte(this.d);
/* 46 */     paramPacketDataSerializer.writeByte(this.e);
/* 47 */     paramPacketDataSerializer.b(Block.getId(this.f) & 0xFFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 52 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutBlockAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */