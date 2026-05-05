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
/*    */ public class PacketPlayOutScoreboardScore
/*    */   extends Packet
/*    */ {
/* 16 */   private String a = "";
/* 17 */   private String b = "";
/*    */   
/*    */   private int c;
/*    */   
/*    */   private int d;
/*    */ 
/*    */   
/*    */   public PacketPlayOutScoreboardScore(ScoreboardScore paramScoreboardScore, int paramInt) {
/* 25 */     this.a = paramScoreboardScore.getPlayerName();
/* 26 */     this.b = paramScoreboardScore.getObjective().getName();
/* 27 */     this.c = paramScoreboardScore.getScore();
/* 28 */     this.d = paramInt;
/*    */   }
/*    */   
/*    */   public PacketPlayOutScoreboardScore(String paramString) {
/* 32 */     this.a = paramString;
/* 33 */     this.b = "";
/* 34 */     this.c = 0;
/* 35 */     this.d = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 40 */     this.a = paramPacketDataSerializer.c(16);
/* 41 */     this.d = paramPacketDataSerializer.readByte();
/*    */     
/* 43 */     if (this.d != 1) {
/* 44 */       this.b = paramPacketDataSerializer.c(16);
/* 45 */       this.c = paramPacketDataSerializer.readInt();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 51 */     paramPacketDataSerializer.a(this.a);
/* 52 */     paramPacketDataSerializer.writeByte(this.d);
/*    */     
/* 54 */     if (this.d != 1) {
/* 55 */       paramPacketDataSerializer.a(this.b);
/* 56 */       paramPacketDataSerializer.writeInt(this.c);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 62 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */   
/*    */   public PacketPlayOutScoreboardScore() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutScoreboardScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */