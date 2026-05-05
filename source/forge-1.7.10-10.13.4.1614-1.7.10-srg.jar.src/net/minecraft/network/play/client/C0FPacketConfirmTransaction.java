/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C0FPacketConfirmTransaction extends Packet {
/*    */   private int field_149536_a;
/*    */   private short field_149534_b;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C0FPacketConfirmTransaction(int p_i45244_1_, short p_i45244_2_, boolean p_i45244_3_) {
/* 17 */     this.field_149536_a = p_i45244_1_;
/* 18 */     this.field_149534_b = p_i45244_2_;
/* 19 */     this.field_149535_c = p_i45244_3_;
/*    */   }
/*    */   private boolean field_149535_c; private static final String __OBFID = "CL_00001351";
/*    */   public C0FPacketConfirmTransaction() {}
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 24 */     p_148833_1_.func_147339_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 29 */     this.field_149536_a = p_148837_1_.readByte();
/* 30 */     this.field_149534_b = p_148837_1_.readShort();
/* 31 */     this.field_149535_c = (p_148837_1_.readByte() != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 36 */     p_148840_1_.writeByte(this.field_149536_a);
/* 37 */     p_148840_1_.writeShort(this.field_149534_b);
/* 38 */     p_148840_1_.writeByte(this.field_149535_c ? 1 : 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 43 */     return String.format("id=%d, uid=%d, accepted=%b", new Object[] { Integer.valueOf(this.field_149536_a), Short.valueOf(this.field_149534_b), Boolean.valueOf(this.field_149535_c) });
/*    */   }
/*    */   
/*    */   public int func_149532_c() {
/* 47 */     return this.field_149536_a;
/*    */   }
/*    */   
/*    */   public short func_149533_d() {
/* 51 */     return this.field_149534_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C0FPacketConfirmTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */