/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketLoginOutSuccess
/*    */   extends Packet
/*    */ {
/*    */   private GameProfile a;
/*    */   
/*    */   public PacketLoginOutSuccess() {}
/*    */   
/*    */   public PacketLoginOutSuccess(GameProfile paramGameProfile) {
/* 19 */     this.a = paramGameProfile;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 24 */     String str1 = paramPacketDataSerializer.c(36);
/* 25 */     String str2 = paramPacketDataSerializer.c(16);
/* 26 */     UUID uUID = UUID.fromString(str1);
/* 27 */     this.a = new GameProfile(uUID, str2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 32 */     UUID uUID = this.a.getId();
/* 33 */     paramPacketDataSerializer.a((uUID == null) ? "" : uUID.toString());
/* 34 */     paramPacketDataSerializer.a(this.a.getName());
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketLoginOutListener paramPacketLoginOutListener) {
/* 39 */     paramPacketLoginOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketLoginOutSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */