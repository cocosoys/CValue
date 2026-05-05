/*    */ package net.minecraft.client.network;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.network.EnumConnectionState;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.handshake.client.C00Handshake;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import org.apache.commons.lang3.Validate;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class NetHandlerHandshakeMemory implements INetHandlerHandshakeServer {
/*    */   private final MinecraftServer field_147385_a;
/*    */   
/*    */   public NetHandlerHandshakeMemory(MinecraftServer p_i45287_1_, NetworkManager p_i45287_2_) {
/* 16 */     this.field_147385_a = p_i45287_1_;
/* 17 */     this.field_147384_b = p_i45287_2_;
/*    */   }
/*    */   private final NetworkManager field_147384_b; private static final String __OBFID = "CL_00001445";
/*    */   
/*    */   public void func_147383_a(C00Handshake p_147383_1_) {
/* 22 */     this.field_147384_b.func_150723_a(p_147383_1_.func_149594_c());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147231_a(IChatComponent p_147231_1_) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147232_a(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_) {
/* 32 */     Validate.validState((p_147232_2_ == EnumConnectionState.LOGIN || p_147232_2_ == EnumConnectionState.STATUS), "Unexpected protocol " + p_147232_2_, new Object[0]);
/* 33 */     switch (SwitchEnumConnectionState.field_151263_a[p_147232_2_.ordinal()]) {
/*    */       case 1:
/* 35 */         this.field_147384_b.func_150719_a((INetHandler)new NetHandlerLoginServer(this.field_147385_a, this.field_147384_b));
/*    */         break;
/*    */       case 2:
/* 38 */         throw new UnsupportedOperationException("NYI");
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_147233_a() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\network\NetHandlerHandshakeMemory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */