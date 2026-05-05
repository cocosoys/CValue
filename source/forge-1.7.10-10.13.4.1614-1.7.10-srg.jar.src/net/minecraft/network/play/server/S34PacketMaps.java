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
/*    */ public class S34PacketMaps
/*    */   extends Packet
/*    */ {
/*    */   private int field_149191_a;
/*    */   private byte[] field_149190_b;
/*    */   
/*    */   public S34PacketMaps(int p_i45202_1_, byte[] p_i45202_2_) {
/* 18 */     this.field_149191_a = p_i45202_1_;
/* 19 */     this.field_149190_b = p_i45202_2_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001311";
/*    */   public S34PacketMaps() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 24 */     this.field_149191_a = p_148837_1_.func_150792_a();
/* 25 */     this.field_149190_b = new byte[p_148837_1_.readUnsignedShort()];
/* 26 */     p_148837_1_.readBytes(this.field_149190_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 31 */     p_148840_1_.func_150787_b(this.field_149191_a);
/* 32 */     p_148840_1_.writeShort(this.field_149190_b.length);
/* 33 */     p_148840_1_.writeBytes(this.field_149190_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 38 */     p_148833_1_.func_147264_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 43 */     return String.format("id=%d, length=%d", new Object[] { Integer.valueOf(this.field_149191_a), Integer.valueOf(this.field_149190_b.length) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149188_c() {
/* 47 */     return this.field_149191_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public byte[] func_149187_d() {
/* 51 */     return this.field_149190_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S34PacketMaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */