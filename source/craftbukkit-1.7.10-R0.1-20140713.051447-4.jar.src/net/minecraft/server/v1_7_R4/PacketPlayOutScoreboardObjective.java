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
/*    */ public class PacketPlayOutScoreboardObjective
/*    */   extends Packet
/*    */ {
/*    */   private String a;
/*    */   private String b;
/*    */   private int c;
/*    */   
/*    */   public PacketPlayOutScoreboardObjective() {}
/*    */   
/*    */   public PacketPlayOutScoreboardObjective(ScoreboardObjective paramScoreboardObjective, int paramInt) {
/* 22 */     this.a = paramScoreboardObjective.getName();
/* 23 */     this.b = paramScoreboardObjective.getDisplayName();
/* 24 */     this.c = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 29 */     this.a = paramPacketDataSerializer.c(16);
/* 30 */     this.b = paramPacketDataSerializer.c(32);
/* 31 */     this.c = paramPacketDataSerializer.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 36 */     paramPacketDataSerializer.a(this.a);
/* 37 */     paramPacketDataSerializer.a(this.b);
/* 38 */     paramPacketDataSerializer.writeByte(this.c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 43 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutScoreboardObjective.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */