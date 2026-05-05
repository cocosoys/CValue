/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutRemoveEntityEffect
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   
/*    */   public PacketPlayOutRemoveEntityEffect() {}
/*    */   
/*    */   public PacketPlayOutRemoveEntityEffect(int paramInt, MobEffect paramMobEffect) {
/* 18 */     this.a = paramInt;
/* 19 */     this.b = paramMobEffect.getEffectId();
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 24 */     this.a = paramPacketDataSerializer.readInt();
/* 25 */     this.b = paramPacketDataSerializer.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 30 */     paramPacketDataSerializer.writeInt(this.a);
/* 31 */     paramPacketDataSerializer.writeByte(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 36 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutRemoveEntityEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */