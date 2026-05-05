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
/*    */ public class PacketPlayOutLogin
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private boolean b;
/*    */   private EnumGamemode c;
/*    */   private int d;
/*    */   private EnumDifficulty e;
/*    */   private int f;
/*    */   private WorldType g;
/*    */   
/*    */   public PacketPlayOutLogin() {}
/*    */   
/*    */   public PacketPlayOutLogin(int paramInt1, EnumGamemode paramEnumGamemode, boolean paramBoolean, int paramInt2, EnumDifficulty paramEnumDifficulty, int paramInt3, WorldType paramWorldType) {
/* 29 */     this.a = paramInt1;
/* 30 */     this.d = paramInt2;
/* 31 */     this.e = paramEnumDifficulty;
/* 32 */     this.c = paramEnumGamemode;
/* 33 */     this.f = paramInt3;
/* 34 */     this.b = paramBoolean;
/* 35 */     this.g = paramWorldType;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 40 */     this.a = paramPacketDataSerializer.readInt();
/*    */     
/* 42 */     short s = paramPacketDataSerializer.readUnsignedByte();
/* 43 */     this.b = ((s & 0x8) == 8);
/* 44 */     int i = s & 0xFFFFFFF7;
/* 45 */     this.c = EnumGamemode.getById(i);
/*    */     
/* 47 */     this.d = paramPacketDataSerializer.readByte();
/* 48 */     this.e = EnumDifficulty.getById(paramPacketDataSerializer.readUnsignedByte());
/* 49 */     this.f = paramPacketDataSerializer.readUnsignedByte();
/* 50 */     this.g = WorldType.getType(paramPacketDataSerializer.c(16));
/* 51 */     if (this.g == null) {
/* 52 */       this.g = WorldType.NORMAL;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 58 */     paramPacketDataSerializer.writeInt(this.a);
/* 59 */     int i = this.c.getId();
/* 60 */     if (this.b) i |= 0x8; 
/* 61 */     paramPacketDataSerializer.writeByte(i);
/* 62 */     paramPacketDataSerializer.writeByte(this.d);
/* 63 */     paramPacketDataSerializer.writeByte(this.e.a());
/* 64 */     paramPacketDataSerializer.writeByte(this.f);
/* 65 */     paramPacketDataSerializer.a(this.g.name());
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 70 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 75 */     return String.format("eid=%d, gameType=%d, hardcore=%b, dimension=%d, difficulty=%s, maxplayers=%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.c.getId()), Boolean.valueOf(this.b), Integer.valueOf(this.d), this.e, Integer.valueOf(this.f) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */