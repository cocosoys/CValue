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
/*    */ public class PacketPlayOutEntityDestroy
/*    */   extends Packet
/*    */ {
/*    */   private int[] a;
/*    */   
/*    */   public PacketPlayOutEntityDestroy() {}
/*    */   
/*    */   public PacketPlayOutEntityDestroy(int... paramVarArgs) {
/* 19 */     this.a = paramVarArgs;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 24 */     this.a = new int[paramPacketDataSerializer.readByte()];
/*    */     
/* 26 */     for (byte b = 0; b < this.a.length; b++) {
/* 27 */       this.a[b] = paramPacketDataSerializer.readInt();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 33 */     paramPacketDataSerializer.writeByte(this.a.length);
/*    */     
/* 35 */     for (byte b = 0; b < this.a.length; b++) {
/* 36 */       paramPacketDataSerializer.writeInt(this.a[b]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 42 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 47 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 49 */     for (byte b = 0; b < this.a.length; b++) {
/* 50 */       if (b > 0) stringBuilder.append(", "); 
/* 51 */       stringBuilder.append(this.a[b]);
/*    */     } 
/*    */     
/* 54 */     return String.format("entities=%d[%s]", new Object[] { Integer.valueOf(this.a.length), stringBuilder });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutEntityDestroy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */