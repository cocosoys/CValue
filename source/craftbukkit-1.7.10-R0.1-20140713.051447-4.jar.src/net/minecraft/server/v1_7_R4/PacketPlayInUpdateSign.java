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
/*    */ public class PacketPlayInUpdateSign
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private String[] d;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 29 */     this.a = paramPacketDataSerializer.readInt();
/* 30 */     this.b = paramPacketDataSerializer.readShort();
/* 31 */     this.c = paramPacketDataSerializer.readInt();
/* 32 */     this.d = new String[4];
/* 33 */     for (byte b = 0; b < 4; b++) {
/* 34 */       this.d[b] = paramPacketDataSerializer.c(15);
/*    */     }
/*    */   }
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 39 */     paramPacketDataSerializer.writeInt(this.a);
/* 40 */     paramPacketDataSerializer.writeShort(this.b);
/* 41 */     paramPacketDataSerializer.writeInt(this.c);
/* 42 */     for (byte b = 0; b < 4; b++) {
/* 43 */       paramPacketDataSerializer.a(this.d[b]);
/*    */     }
/*    */   }
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 48 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */   
/*    */   public int c() {
/* 52 */     return this.a;
/*    */   }
/*    */   
/*    */   public int d() {
/* 56 */     return this.b;
/*    */   }
/*    */   
/*    */   public int e() {
/* 60 */     return this.c;
/*    */   }
/*    */   
/*    */   public String[] f() {
/* 64 */     return this.d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInUpdateSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */