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
/*    */ public class PacketPlayInPosition
/*    */   extends PacketPlayInFlying
/*    */ {
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 80 */     this.x = paramPacketDataSerializer.readDouble();
/* 81 */     this.y = paramPacketDataSerializer.readDouble();
/* 82 */     this.stance = paramPacketDataSerializer.readDouble();
/* 83 */     this.z = paramPacketDataSerializer.readDouble();
/* 84 */     super.a(paramPacketDataSerializer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 89 */     paramPacketDataSerializer.writeDouble(this.x);
/* 90 */     paramPacketDataSerializer.writeDouble(this.y);
/* 91 */     paramPacketDataSerializer.writeDouble(this.stance);
/* 92 */     paramPacketDataSerializer.writeDouble(this.z);
/* 93 */     super.b(paramPacketDataSerializer);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */