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
/*    */ public class S25PacketBlockBreakAnim
/*    */   extends Packet
/*    */ {
/*    */   private int field_148852_a;
/*    */   private int field_148850_b;
/*    */   private int field_148851_c;
/*    */   
/*    */   public S25PacketBlockBreakAnim(int p_i45174_1_, int p_i45174_2_, int p_i45174_3_, int p_i45174_4_, int p_i45174_5_) {
/* 20 */     this.field_148852_a = p_i45174_1_;
/* 21 */     this.field_148850_b = p_i45174_2_;
/* 22 */     this.field_148851_c = p_i45174_3_;
/* 23 */     this.field_148848_d = p_i45174_4_;
/* 24 */     this.field_148849_e = p_i45174_5_;
/*    */   }
/*    */   private int field_148848_d; private int field_148849_e; private static final String __OBFID = "CL_00001284";
/*    */   public S25PacketBlockBreakAnim() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 29 */     this.field_148852_a = p_148837_1_.func_150792_a();
/* 30 */     this.field_148850_b = p_148837_1_.readInt();
/* 31 */     this.field_148851_c = p_148837_1_.readInt();
/* 32 */     this.field_148848_d = p_148837_1_.readInt();
/* 33 */     this.field_148849_e = p_148837_1_.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 38 */     p_148840_1_.func_150787_b(this.field_148852_a);
/* 39 */     p_148840_1_.writeInt(this.field_148850_b);
/* 40 */     p_148840_1_.writeInt(this.field_148851_c);
/* 41 */     p_148840_1_.writeInt(this.field_148848_d);
/* 42 */     p_148840_1_.writeByte(this.field_148849_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 47 */     p_148833_1_.func_147294_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148845_c() {
/* 51 */     return this.field_148852_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148844_d() {
/* 55 */     return this.field_148850_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148843_e() {
/* 59 */     return this.field_148851_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148842_f() {
/* 63 */     return this.field_148848_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148846_g() {
/* 67 */     return this.field_148849_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S25PacketBlockBreakAnim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */