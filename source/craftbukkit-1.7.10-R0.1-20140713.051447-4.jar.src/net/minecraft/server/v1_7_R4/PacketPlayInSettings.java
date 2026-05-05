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
/*    */ public class PacketPlayInSettings
/*    */   extends Packet
/*    */ {
/*    */   private String a;
/*    */   private int b;
/*    */   private EnumChatVisibility c;
/*    */   private boolean d;
/*    */   private EnumDifficulty e;
/*    */   private boolean f;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 35 */     this.a = paramPacketDataSerializer.c(7);
/* 36 */     this.b = paramPacketDataSerializer.readByte();
/*    */     
/* 38 */     this.c = EnumChatVisibility.a(paramPacketDataSerializer.readByte());
/* 39 */     this.d = paramPacketDataSerializer.readBoolean();
/*    */     
/* 41 */     this.e = EnumDifficulty.getById(paramPacketDataSerializer.readByte());
/* 42 */     this.f = paramPacketDataSerializer.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 47 */     paramPacketDataSerializer.a(this.a);
/* 48 */     paramPacketDataSerializer.writeByte(this.b);
/* 49 */     paramPacketDataSerializer.writeByte(this.c.a());
/* 50 */     paramPacketDataSerializer.writeBoolean(this.d);
/* 51 */     paramPacketDataSerializer.writeByte(this.e.a());
/* 52 */     paramPacketDataSerializer.writeBoolean(this.f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 57 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */   
/*    */   public String c() {
/* 61 */     return this.a;
/*    */   }
/*    */   
/*    */   public int d() {
/* 65 */     return this.b;
/*    */   }
/*    */   
/*    */   public EnumChatVisibility e() {
/* 69 */     return this.c;
/*    */   }
/*    */   
/*    */   public boolean f() {
/* 73 */     return this.d;
/*    */   }
/*    */   
/*    */   public EnumDifficulty g() {
/* 77 */     return this.e;
/*    */   }
/*    */   
/*    */   public boolean h() {
/* 81 */     return this.f;
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 86 */     return String.format("lang='%s', view=%d, chat=%s, col=%b, difficulty=%s, cape=%b", new Object[] { this.a, Integer.valueOf(this.b), this.c, Boolean.valueOf(this.d), this.e, Boolean.valueOf(this.f) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */