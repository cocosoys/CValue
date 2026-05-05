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
/*    */ public class S08PacketPlayerPosLook
/*    */   extends Packet
/*    */ {
/*    */   private double field_148940_a;
/*    */   private double field_148938_b;
/*    */   private double field_148939_c;
/*    */   private float field_148936_d;
/*    */   
/*    */   public S08PacketPlayerPosLook(double p_i45164_1_, double p_i45164_3_, double p_i45164_5_, float p_i45164_7_, float p_i45164_8_, boolean p_i45164_9_) {
/* 21 */     this.field_148940_a = p_i45164_1_;
/* 22 */     this.field_148938_b = p_i45164_3_;
/* 23 */     this.field_148939_c = p_i45164_5_;
/* 24 */     this.field_148936_d = p_i45164_7_;
/* 25 */     this.field_148937_e = p_i45164_8_;
/* 26 */     this.field_148935_f = p_i45164_9_;
/*    */   }
/*    */   private float field_148937_e; private boolean field_148935_f; private static final String __OBFID = "CL_00001273";
/*    */   public S08PacketPlayerPosLook() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 31 */     this.field_148940_a = p_148837_1_.readDouble();
/* 32 */     this.field_148938_b = p_148837_1_.readDouble();
/* 33 */     this.field_148939_c = p_148837_1_.readDouble();
/* 34 */     this.field_148936_d = p_148837_1_.readFloat();
/* 35 */     this.field_148937_e = p_148837_1_.readFloat();
/* 36 */     this.field_148935_f = p_148837_1_.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 41 */     p_148840_1_.writeDouble(this.field_148940_a);
/* 42 */     p_148840_1_.writeDouble(this.field_148938_b);
/* 43 */     p_148840_1_.writeDouble(this.field_148939_c);
/* 44 */     p_148840_1_.writeFloat(this.field_148936_d);
/* 45 */     p_148840_1_.writeFloat(this.field_148937_e);
/* 46 */     p_148840_1_.writeBoolean(this.field_148935_f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 51 */     p_148833_1_.func_147258_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public double func_148932_c() {
/* 55 */     return this.field_148940_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public double func_148928_d() {
/* 59 */     return this.field_148938_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public double func_148933_e() {
/* 63 */     return this.field_148939_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_148931_f() {
/* 67 */     return this.field_148936_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_148930_g() {
/* 71 */     return this.field_148937_e;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_148929_h() {
/* 75 */     return this.field_148935_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S08PacketPlayerPosLook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */