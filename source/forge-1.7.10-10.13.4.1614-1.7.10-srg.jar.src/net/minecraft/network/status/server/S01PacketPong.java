/*    */ package net.minecraft.network.status.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.status.INetHandlerStatusClient;
/*    */ 
/*    */ public class S01PacketPong
/*    */   extends Packet {
/*    */   private long field_149293_a;
/*    */   
/*    */   public S01PacketPong(long p_i45272_1_) {
/* 16 */     this.field_149293_a = p_i45272_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001383";
/*    */   public S01PacketPong() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 21 */     this.field_149293_a = p_148837_1_.readLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 26 */     p_148840_1_.writeLong(this.field_149293_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerStatusClient p_148833_1_) {
/* 31 */     p_148833_1_.func_147398_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 36 */     return true;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public long func_149292_c() {
/* 40 */     return this.field_149293_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\status\server\S01PacketPong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */