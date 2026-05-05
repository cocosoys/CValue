/*    */ package net.minecraft.server.network;
/*    */ import net.minecraft.network.EnumConnectionState;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.handshake.INetHandlerHandshakeServer;
/*    */ import net.minecraft.network.handshake.client.C00Handshake;
/*    */ import net.minecraft.network.login.server.S00PacketDisconnect;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class NetHandlerHandshakeTCP implements INetHandlerHandshakeServer {
/*    */   private final MinecraftServer field_147387_a;
/*    */   
/*    */   public NetHandlerHandshakeTCP(MinecraftServer p_i45295_1_, NetworkManager p_i45295_2_) {
/* 17 */     this.field_147387_a = p_i45295_1_;
/* 18 */     this.field_147386_b = p_i45295_2_;
/*    */   }
/*    */   private final NetworkManager field_147386_b; private static final String __OBFID = "CL_00001456";
/*    */   
/*    */   public void func_147383_a(C00Handshake p_147383_1_) {
/* 23 */     switch (SwitchEnumConnectionState.field_151291_a[p_147383_1_.func_149594_c().ordinal()]) {
/*    */       case 1:
/* 25 */         this.field_147386_b.func_150723_a(EnumConnectionState.LOGIN);
/*    */         
/* 27 */         if (p_147383_1_.func_149595_d() > 5) {
/* 28 */           ChatComponentText chatComponentText = new ChatComponentText("Outdated server! I'm still on 1.7.10");
/* 29 */           this.field_147386_b.func_150725_a((Packet)new S00PacketDisconnect((IChatComponent)chatComponentText), new io.netty.util.concurrent.GenericFutureListener[0]);
/* 30 */           this.field_147386_b.func_150718_a((IChatComponent)chatComponentText);
/* 31 */         } else if (p_147383_1_.func_149595_d() < 5) {
/* 32 */           ChatComponentText chatComponentText = new ChatComponentText("Outdated client! Please use 1.7.10");
/* 33 */           this.field_147386_b.func_150725_a((Packet)new S00PacketDisconnect((IChatComponent)chatComponentText), new io.netty.util.concurrent.GenericFutureListener[0]);
/* 34 */           this.field_147386_b.func_150718_a((IChatComponent)chatComponentText);
/*    */         } else {
/* 36 */           this.field_147386_b.func_150719_a((INetHandler)new NetHandlerLoginServer(this.field_147387_a, this.field_147386_b));
/*    */         } 
/*    */         return;
/*    */       case 2:
/* 40 */         this.field_147386_b.func_150723_a(EnumConnectionState.STATUS);
/* 41 */         this.field_147386_b.func_150719_a((INetHandler)new NetHandlerStatusServer(this.field_147387_a, this.field_147386_b));
/*    */         return;
/*    */     } 
/* 44 */     throw new UnsupportedOperationException("Invalid intention " + p_147383_1_.func_149594_c());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147231_a(IChatComponent p_147231_1_) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147232_a(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_) {
/* 55 */     if (p_147232_2_ != EnumConnectionState.LOGIN && p_147232_2_ != EnumConnectionState.STATUS)
/* 56 */       throw new UnsupportedOperationException("Invalid state " + p_147232_2_); 
/*    */   }
/*    */   
/*    */   public void func_147233_a() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\network\NetHandlerHandshakeTCP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */