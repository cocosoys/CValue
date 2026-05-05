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
/*    */ public class PacketPlayInPositionLook
/*    */   extends PacketPlayInFlying
/*    */ {
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 41 */     this.x = paramPacketDataSerializer.readDouble();
/* 42 */     this.y = paramPacketDataSerializer.readDouble();
/* 43 */     this.stance = paramPacketDataSerializer.readDouble();
/* 44 */     this.z = paramPacketDataSerializer.readDouble();
/* 45 */     this.yaw = paramPacketDataSerializer.readFloat();
/* 46 */     this.pitch = paramPacketDataSerializer.readFloat();
/* 47 */     super.a(paramPacketDataSerializer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 52 */     paramPacketDataSerializer.writeDouble(this.x);
/* 53 */     paramPacketDataSerializer.writeDouble(this.y);
/* 54 */     paramPacketDataSerializer.writeDouble(this.stance);
/* 55 */     paramPacketDataSerializer.writeDouble(this.z);
/* 56 */     paramPacketDataSerializer.writeFloat(this.yaw);
/* 57 */     paramPacketDataSerializer.writeFloat(this.pitch);
/* 58 */     super.b(paramPacketDataSerializer);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInPositionLook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */