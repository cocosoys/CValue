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
/*    */ public class PacketPlayInArmAnimation
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 31 */     this.a = paramPacketDataSerializer.readInt();
/* 32 */     this.b = paramPacketDataSerializer.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 37 */     paramPacketDataSerializer.writeInt(this.a);
/* 38 */     paramPacketDataSerializer.writeByte(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 43 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 48 */     return String.format("id=%d, type=%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int d() {
/* 56 */     return this.b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInArmAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */