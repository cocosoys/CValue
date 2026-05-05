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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class S2BPacketChangeGameState
/*    */   extends Packet
/*    */ {
/* 25 */   public static final String[] field_149142_a = new String[] { "tile.bed.notValid", null, null, "gameMode.changed" };
/*    */   
/*    */   private int field_149140_b;
/*    */   
/*    */   private float field_149141_c;
/*    */   
/*    */   private static final String __OBFID = "CL_00001301";
/*    */ 
/*    */   
/*    */   public S2BPacketChangeGameState() {}
/*    */   
/*    */   public S2BPacketChangeGameState(int p_i45194_1_, float p_i45194_2_) {
/* 37 */     this.field_149140_b = p_i45194_1_;
/* 38 */     this.field_149141_c = p_i45194_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 43 */     this.field_149140_b = p_148837_1_.readUnsignedByte();
/* 44 */     this.field_149141_c = p_148837_1_.readFloat();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 49 */     p_148840_1_.writeByte(this.field_149140_b);
/* 50 */     p_148840_1_.writeFloat(this.field_149141_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 55 */     p_148833_1_.func_147252_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149138_c() {
/* 59 */     return this.field_149140_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_149137_d() {
/* 63 */     return this.field_149141_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S2BPacketChangeGameState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */