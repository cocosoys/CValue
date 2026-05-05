/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutUpdateAttributes
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/* 17 */   private final List b = new ArrayList();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PacketPlayOutUpdateAttributes(int paramInt, Collection paramCollection) {
/* 23 */     this.a = paramInt;
/*    */     
/* 25 */     for (AttributeInstance attributeInstance : paramCollection) {
/* 26 */       this.b.add(new AttributeSnapshot(this, attributeInstance.getAttribute().getName(), attributeInstance.b(), attributeInstance.c()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 32 */     this.a = paramPacketDataSerializer.readInt();
/*    */     
/* 34 */     int i = paramPacketDataSerializer.readInt();
/* 35 */     for (byte b = 0; b < i; b++) {
/* 36 */       String str = paramPacketDataSerializer.c(64);
/* 37 */       double d = paramPacketDataSerializer.readDouble();
/* 38 */       ArrayList<AttributeModifier> arrayList = new ArrayList();
/* 39 */       short s = paramPacketDataSerializer.readShort();
/*    */       
/* 41 */       for (byte b1 = 0; b1 < s; b1++) {
/* 42 */         UUID uUID = new UUID(paramPacketDataSerializer.readLong(), paramPacketDataSerializer.readLong());
/* 43 */         arrayList.add(new AttributeModifier(uUID, "Unknown synced attribute modifier", paramPacketDataSerializer.readDouble(), paramPacketDataSerializer.readByte()));
/*    */       } 
/*    */       
/* 46 */       this.b.add(new AttributeSnapshot(this, str, d, arrayList));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 52 */     paramPacketDataSerializer.writeInt(this.a);
/* 53 */     paramPacketDataSerializer.writeInt(this.b.size());
/*    */     
/* 55 */     for (AttributeSnapshot attributeSnapshot : this.b) {
/* 56 */       paramPacketDataSerializer.a(attributeSnapshot.a());
/* 57 */       paramPacketDataSerializer.writeDouble(attributeSnapshot.b());
/* 58 */       paramPacketDataSerializer.writeShort(attributeSnapshot.c().size());
/*    */       
/* 60 */       for (AttributeModifier attributeModifier : attributeSnapshot.c()) {
/* 61 */         paramPacketDataSerializer.writeLong(attributeModifier.a().getMostSignificantBits());
/* 62 */         paramPacketDataSerializer.writeLong(attributeModifier.a().getLeastSignificantBits());
/* 63 */         paramPacketDataSerializer.writeDouble(attributeModifier.d());
/* 64 */         paramPacketDataSerializer.writeByte(attributeModifier.c());
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 71 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */   
/*    */   public PacketPlayOutUpdateAttributes() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutUpdateAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */