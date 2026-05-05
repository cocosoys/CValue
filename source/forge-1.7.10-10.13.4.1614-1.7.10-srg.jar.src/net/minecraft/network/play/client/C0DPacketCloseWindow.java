/*    */ package net.minecraft.network.play.client;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C0DPacketCloseWindow extends Packet {
/*    */   private int field_149556_a;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C0DPacketCloseWindow(int p_i45247_1_) {
/* 15 */     this.field_149556_a = p_i45247_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001354";
/*    */   public C0DPacketCloseWindow() {}
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 20 */     p_148833_1_.func_147356_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 25 */     this.field_149556_a = p_148837_1_.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 30 */     p_148840_1_.writeByte(this.field_149556_a);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C0DPacketCloseWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */