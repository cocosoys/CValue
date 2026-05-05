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
/*    */ public class PacketPlayOutEntityEffect
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private byte b;
/*    */   private byte c;
/*    */   private short d;
/*    */   
/*    */   public PacketPlayOutEntityEffect() {}
/*    */   
/*    */   public PacketPlayOutEntityEffect(int paramInt, MobEffect paramMobEffect) {
/* 22 */     this.a = paramInt;
/* 23 */     this.b = (byte)(paramMobEffect.getEffectId() & 0xFF);
/* 24 */     this.c = (byte)(paramMobEffect.getAmplifier() & 0xFF);
/* 25 */     if (paramMobEffect.getDuration() > 32767) {
/* 26 */       this.d = Short.MAX_VALUE;
/*    */     } else {
/*    */       
/* 29 */       this.d = (short)paramMobEffect.getDuration();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 35 */     this.a = paramPacketDataSerializer.readInt();
/* 36 */     this.b = paramPacketDataSerializer.readByte();
/* 37 */     this.c = paramPacketDataSerializer.readByte();
/* 38 */     this.d = paramPacketDataSerializer.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 43 */     paramPacketDataSerializer.writeInt(this.a);
/* 44 */     paramPacketDataSerializer.writeByte(this.b);
/* 45 */     paramPacketDataSerializer.writeByte(this.c);
/* 46 */     paramPacketDataSerializer.writeShort(this.d);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 55 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutEntityEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */