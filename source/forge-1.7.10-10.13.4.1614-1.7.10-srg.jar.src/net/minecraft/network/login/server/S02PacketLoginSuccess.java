/*    */ package net.minecraft.network.login.server;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.io.IOException;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.login.INetHandlerLoginClient;
/*    */ 
/*    */ public class S02PacketLoginSuccess
/*    */   extends Packet {
/*    */   private GameProfile field_149602_a;
/*    */   private static final String __OBFID = "CL_00001375";
/*    */   
/*    */   public S02PacketLoginSuccess() {}
/*    */   
/*    */   public S02PacketLoginSuccess(GameProfile p_i45267_1_) {
/* 19 */     this.field_149602_a = p_i45267_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 24 */     String str1 = p_148837_1_.func_150789_c(36);
/* 25 */     String str2 = p_148837_1_.func_150789_c(16);
/* 26 */     UUID uUID = UUID.fromString(str1);
/* 27 */     this.field_149602_a = new GameProfile(uUID, str2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 32 */     UUID uUID = this.field_149602_a.getId();
/* 33 */     p_148840_1_.func_150785_a((uUID == null) ? "" : uUID.toString());
/* 34 */     p_148840_1_.func_150785_a(this.field_149602_a.getName());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerLoginClient p_148833_1_) {
/* 39 */     p_148833_1_.func_147390_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\login\server\S02PacketLoginSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */