/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutOpenSignEditor
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   
/*    */   public PacketPlayOutOpenSignEditor() {}
/*    */   
/*    */   public PacketPlayOutOpenSignEditor(int paramInt1, int paramInt2, int paramInt3) {
/* 17 */     this.a = paramInt1;
/* 18 */     this.b = paramInt2;
/* 19 */     this.c = paramInt3;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 24 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 29 */     this.a = paramPacketDataSerializer.readInt();
/* 30 */     this.b = paramPacketDataSerializer.readInt();
/* 31 */     this.c = paramPacketDataSerializer.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 36 */     paramPacketDataSerializer.writeInt(this.a);
/* 37 */     paramPacketDataSerializer.writeInt(this.b);
/* 38 */     paramPacketDataSerializer.writeInt(this.c);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutOpenSignEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */