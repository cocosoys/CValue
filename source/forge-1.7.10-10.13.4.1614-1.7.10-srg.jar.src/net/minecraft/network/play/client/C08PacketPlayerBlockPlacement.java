/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ 
/*    */ public class C08PacketPlayerBlockPlacement
/*    */   extends Packet
/*    */ {
/*    */   private int field_149583_a;
/*    */   private int field_149581_b;
/*    */   private int field_149582_c;
/*    */   private int field_149579_d;
/*    */   private ItemStack field_149580_e;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C08PacketPlayerBlockPlacement(int p_i45265_1_, int p_i45265_2_, int p_i45265_3_, int p_i45265_4_, ItemStack p_i45265_5_, float p_i45265_6_, float p_i45265_7_, float p_i45265_8_) {
/* 24 */     this.field_149583_a = p_i45265_1_;
/* 25 */     this.field_149581_b = p_i45265_2_;
/* 26 */     this.field_149582_c = p_i45265_3_;
/* 27 */     this.field_149579_d = p_i45265_4_;
/* 28 */     this.field_149580_e = (p_i45265_5_ != null) ? p_i45265_5_.func_77946_l() : null;
/* 29 */     this.field_149577_f = p_i45265_6_;
/* 30 */     this.field_149578_g = p_i45265_7_;
/* 31 */     this.field_149584_h = p_i45265_8_;
/*    */   }
/*    */   private float field_149577_f; private float field_149578_g; private float field_149584_h; private static final String __OBFID = "CL_00001371";
/*    */   public C08PacketPlayerBlockPlacement() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 36 */     this.field_149583_a = p_148837_1_.readInt();
/* 37 */     this.field_149581_b = p_148837_1_.readUnsignedByte();
/* 38 */     this.field_149582_c = p_148837_1_.readInt();
/* 39 */     this.field_149579_d = p_148837_1_.readUnsignedByte();
/* 40 */     this.field_149580_e = p_148837_1_.func_150791_c();
/* 41 */     this.field_149577_f = p_148837_1_.readUnsignedByte() / 16.0F;
/* 42 */     this.field_149578_g = p_148837_1_.readUnsignedByte() / 16.0F;
/* 43 */     this.field_149584_h = p_148837_1_.readUnsignedByte() / 16.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 48 */     p_148840_1_.writeInt(this.field_149583_a);
/* 49 */     p_148840_1_.writeByte(this.field_149581_b);
/* 50 */     p_148840_1_.writeInt(this.field_149582_c);
/* 51 */     p_148840_1_.writeByte(this.field_149579_d);
/* 52 */     p_148840_1_.func_150788_a(this.field_149580_e);
/* 53 */     p_148840_1_.writeByte((int)(this.field_149577_f * 16.0F));
/* 54 */     p_148840_1_.writeByte((int)(this.field_149578_g * 16.0F));
/* 55 */     p_148840_1_.writeByte((int)(this.field_149584_h * 16.0F));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 60 */     p_148833_1_.func_147346_a(this);
/*    */   }
/*    */   
/*    */   public int func_149576_c() {
/* 64 */     return this.field_149583_a;
/*    */   }
/*    */   
/*    */   public int func_149571_d() {
/* 68 */     return this.field_149581_b;
/*    */   }
/*    */   
/*    */   public int func_149570_e() {
/* 72 */     return this.field_149582_c;
/*    */   }
/*    */   
/*    */   public int func_149568_f() {
/* 76 */     return this.field_149579_d;
/*    */   }
/*    */   
/*    */   public ItemStack func_149574_g() {
/* 80 */     return this.field_149580_e;
/*    */   }
/*    */   
/*    */   public float func_149573_h() {
/* 84 */     return this.field_149577_f;
/*    */   }
/*    */   
/*    */   public float func_149569_i() {
/* 88 */     return this.field_149578_g;
/*    */   }
/*    */   
/*    */   public float func_149575_j() {
/* 92 */     return this.field_149584_h;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C08PacketPlayerBlockPlacement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */