/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C01PacketChatMessage
/*    */   extends Packet
/*    */ {
/*    */   private String field_149440_a;
/*    */   private static final String __OBFID = "CL_00001347";
/*    */   
/*    */   public C01PacketChatMessage() {}
/*    */   
/*    */   public C01PacketChatMessage(String p_i45240_1_) {
/* 18 */     if (p_i45240_1_.length() > 100) {
/* 19 */       p_i45240_1_ = p_i45240_1_.substring(0, 100);
/*    */     }
/*    */     
/* 22 */     this.field_149440_a = p_i45240_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 27 */     this.field_149440_a = p_148837_1_.func_150789_c(100);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 32 */     p_148840_1_.func_150785_a(this.field_149440_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 37 */     p_148833_1_.func_147354_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 42 */     return String.format("message='%s'", new Object[] { this.field_149440_a });
/*    */   }
/*    */   
/*    */   public String func_149439_c() {
/* 46 */     return this.field_149440_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C01PacketChatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */