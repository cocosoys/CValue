/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ public class S2EPacketCloseWindow
/*    */   extends Packet {
/*    */   private int field_148896_a;
/*    */   private static final String __OBFID = "CL_00001292";
/*    */   
/*    */   public S2EPacketCloseWindow() {}
/*    */   
/*    */   public S2EPacketCloseWindow(int p_i45183_1_) {
/* 17 */     this.field_148896_a = p_i45183_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 22 */     p_148833_1_.func_147276_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 27 */     this.field_148896_a = p_148837_1_.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 32 */     p_148840_1_.writeByte(this.field_148896_a);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S2EPacketCloseWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */