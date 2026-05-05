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
/*    */ public class PacketPlayInEntityAction
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int animation;
/*    */   private int c;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 37 */     this.a = paramPacketDataSerializer.readInt();
/* 38 */     this.animation = paramPacketDataSerializer.readByte();
/* 39 */     this.c = paramPacketDataSerializer.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 44 */     paramPacketDataSerializer.writeInt(this.a);
/* 45 */     paramPacketDataSerializer.writeByte(this.animation);
/* 46 */     paramPacketDataSerializer.writeInt(this.c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 51 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int d() {
/* 59 */     return this.animation;
/*    */   }
/*    */   
/*    */   public int e() {
/* 63 */     return this.c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInEntityAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */