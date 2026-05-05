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
/*    */ public class S32PacketConfirmTransaction
/*    */   extends Packet
/*    */ {
/*    */   private int field_148894_a;
/*    */   private short field_148892_b;
/*    */   
/*    */   public S32PacketConfirmTransaction(int p_i45182_1_, short p_i45182_2_, boolean p_i45182_3_) {
/* 19 */     this.field_148894_a = p_i45182_1_;
/* 20 */     this.field_148892_b = p_i45182_2_;
/* 21 */     this.field_148893_c = p_i45182_3_;
/*    */   }
/*    */   private boolean field_148893_c; private static final String __OBFID = "CL_00001291";
/*    */   public S32PacketConfirmTransaction() {}
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 26 */     p_148833_1_.func_147239_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 31 */     this.field_148894_a = p_148837_1_.readUnsignedByte();
/* 32 */     this.field_148892_b = p_148837_1_.readShort();
/* 33 */     this.field_148893_c = p_148837_1_.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 38 */     p_148840_1_.writeByte(this.field_148894_a);
/* 39 */     p_148840_1_.writeShort(this.field_148892_b);
/* 40 */     p_148840_1_.writeBoolean(this.field_148893_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 45 */     return String.format("id=%d, uid=%d, accepted=%b", new Object[] { Integer.valueOf(this.field_148894_a), Short.valueOf(this.field_148892_b), Boolean.valueOf(this.field_148893_c) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148889_c() {
/* 49 */     return this.field_148894_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public short func_148890_d() {
/* 53 */     return this.field_148892_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_148888_e() {
/* 57 */     return this.field_148893_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S32PacketConfirmTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */