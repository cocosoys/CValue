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
/*    */ public class S0DPacketCollectItem extends Packet {
/*    */   private int field_149357_a;
/*    */   private int field_149356_b;
/*    */   
/*    */   public S0DPacketCollectItem(int p_i45232_1_, int p_i45232_2_) {
/* 16 */     this.field_149357_a = p_i45232_1_;
/* 17 */     this.field_149356_b = p_i45232_2_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001339";
/*    */   public S0DPacketCollectItem() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 22 */     this.field_149357_a = p_148837_1_.readInt();
/* 23 */     this.field_149356_b = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 28 */     p_148840_1_.writeInt(this.field_149357_a);
/* 29 */     p_148840_1_.writeInt(this.field_149356_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 34 */     p_148833_1_.func_147246_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149354_c() {
/* 38 */     return this.field_149357_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149353_d() {
/* 42 */     return this.field_149356_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S0DPacketCollectItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */