/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ 
/*    */ public class S1EPacketRemoveEntityEffect
/*    */   extends Packet {
/*    */   private int field_149079_a;
/*    */   private int field_149078_b;
/*    */   
/*    */   public S1EPacketRemoveEntityEffect(int p_i45212_1_, PotionEffect p_i45212_2_) {
/* 18 */     this.field_149079_a = p_i45212_1_;
/* 19 */     this.field_149078_b = p_i45212_2_.func_76456_a();
/*    */   }
/*    */   private static final String __OBFID = "CL_00001321";
/*    */   public S1EPacketRemoveEntityEffect() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 24 */     this.field_149079_a = p_148837_1_.readInt();
/* 25 */     this.field_149078_b = p_148837_1_.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 30 */     p_148840_1_.writeInt(this.field_149079_a);
/* 31 */     p_148840_1_.writeByte(this.field_149078_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 36 */     p_148833_1_.func_147262_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149076_c() {
/* 40 */     return this.field_149079_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149075_d() {
/* 44 */     return this.field_149078_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S1EPacketRemoveEntityEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */