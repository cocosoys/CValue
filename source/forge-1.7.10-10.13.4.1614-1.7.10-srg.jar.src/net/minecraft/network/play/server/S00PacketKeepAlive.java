/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ public class S00PacketKeepAlive
/*    */   extends Packet {
/*    */   private int field_149136_a;
/*    */   
/*    */   public S00PacketKeepAlive(int p_i45195_1_) {
/* 16 */     this.field_149136_a = p_i45195_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001303";
/*    */   public S00PacketKeepAlive() {}
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 21 */     p_148833_1_.func_147272_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 26 */     this.field_149136_a = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 31 */     p_148840_1_.writeInt(this.field_149136_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 36 */     return true;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149134_c() {
/* 40 */     return this.field_149136_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S00PacketKeepAlive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */