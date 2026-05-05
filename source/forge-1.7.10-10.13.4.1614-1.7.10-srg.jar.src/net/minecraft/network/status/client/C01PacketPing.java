/*    */ package net.minecraft.network.status.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.status.INetHandlerStatusServer;
/*    */ 
/*    */ public class C01PacketPing extends Packet {
/*    */   private long field_149290_a;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C01PacketPing(long p_i45276_1_) {
/* 16 */     this.field_149290_a = p_i45276_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001392";
/*    */   public C01PacketPing() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 21 */     this.field_149290_a = p_148837_1_.readLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 26 */     p_148840_1_.writeLong(this.field_149290_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerStatusServer p_148833_1_) {
/* 31 */     p_148833_1_.func_147311_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public long func_149289_c() {
/* 40 */     return this.field_149290_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\status\client\C01PacketPing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */