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
/*    */ public class PacketPlayInUseEntity
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private EnumEntityUseAction action;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 43 */     this.a = paramPacketDataSerializer.readInt();
/* 44 */     this.action = EnumEntityUseAction.a()[paramPacketDataSerializer.readByte() % (EnumEntityUseAction.a()).length];
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 49 */     paramPacketDataSerializer.writeInt(this.a);
/* 50 */     paramPacketDataSerializer.writeByte(EnumEntityUseAction.a(this.action));
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 55 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */   
/*    */   public Entity a(World paramWorld) {
/* 59 */     return paramWorld.getEntity(this.a);
/*    */   }
/*    */   
/*    */   public EnumEntityUseAction c() {
/* 63 */     return this.action;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInUseEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */