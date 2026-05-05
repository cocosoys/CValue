/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PacketPlayOutEntity
/*     */   extends Packet
/*     */ {
/*     */   protected int a;
/*     */   protected byte b;
/*     */   protected byte c;
/*     */   protected byte d;
/*     */   protected byte e;
/*     */   protected byte f;
/*     */   protected boolean g;
/*     */   
/*     */   public PacketPlayOutEntity() {}
/*     */   
/*     */   public PacketPlayOutEntity(int paramInt) {
/* 133 */     this.a = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 138 */     this.a = paramPacketDataSerializer.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 143 */     paramPacketDataSerializer.writeInt(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 148 */     paramPacketPlayOutListener.a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String b() {
/* 153 */     return String.format("id=%d", new Object[] { Integer.valueOf(this.a) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 158 */     return "Entity_" + super.toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */