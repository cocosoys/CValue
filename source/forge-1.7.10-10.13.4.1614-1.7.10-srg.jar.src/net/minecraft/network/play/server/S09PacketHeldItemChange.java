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
/*    */ public class S09PacketHeldItemChange
/*    */   extends Packet
/*    */ {
/*    */   private int field_149387_a;
/*    */   
/*    */   public S09PacketHeldItemChange(int p_i45215_1_) {
/* 17 */     this.field_149387_a = p_i45215_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001324";
/*    */   public S09PacketHeldItemChange() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 22 */     this.field_149387_a = p_148837_1_.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 27 */     p_148840_1_.writeByte(this.field_149387_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 32 */     p_148833_1_.func_147257_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149385_c() {
/* 36 */     return this.field_149387_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S09PacketHeldItemChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */