/*    */ package net.minecraft.network.status.client;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.status.INetHandlerStatusServer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class C00PacketServerQuery
/*    */   extends Packet
/*    */ {
/*    */   private static final String __OBFID = "CL_00001393";
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {}
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {}
/*    */   
/*    */   public void func_148833_a(INetHandlerStatusServer p_148833_1_) {
/* 25 */     p_148833_1_.func_147312_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\status\client\C00PacketServerQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */