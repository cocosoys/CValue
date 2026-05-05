/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ 
/*    */ public class C14PacketTabComplete
/*    */   extends Packet
/*    */ {
/*    */   private String field_149420_a;
/*    */   
/*    */   public C14PacketTabComplete(String p_i45239_1_) {
/* 16 */     this.field_149420_a = p_i45239_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001346";
/*    */   public C14PacketTabComplete() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 21 */     this.field_149420_a = p_148837_1_.func_150789_c(32767);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 26 */     p_148840_1_.func_150785_a(StringUtils.substring(this.field_149420_a, 0, 32767));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 31 */     p_148833_1_.func_147341_a(this);
/*    */   }
/*    */   
/*    */   public String func_149419_c() {
/* 35 */     return this.field_149420_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 40 */     return String.format("message='%s'", new Object[] { this.field_149420_a });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C14PacketTabComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */