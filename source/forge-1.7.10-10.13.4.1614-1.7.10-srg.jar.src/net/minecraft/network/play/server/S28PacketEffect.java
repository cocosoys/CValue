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
/*    */ public class S28PacketEffect
/*    */   extends Packet
/*    */ {
/*    */   private int field_149251_a;
/*    */   private int field_149249_b;
/*    */   private int field_149250_c;
/*    */   private int field_149247_d;
/*    */   
/*    */   public S28PacketEffect(int p_i45198_1_, int p_i45198_2_, int p_i45198_3_, int p_i45198_4_, int p_i45198_5_, boolean p_i45198_6_) {
/* 22 */     this.field_149251_a = p_i45198_1_;
/* 23 */     this.field_149250_c = p_i45198_2_;
/* 24 */     this.field_149247_d = p_i45198_3_;
/* 25 */     this.field_149248_e = p_i45198_4_;
/* 26 */     this.field_149249_b = p_i45198_5_;
/* 27 */     this.field_149246_f = p_i45198_6_;
/*    */   }
/*    */   private int field_149248_e; private boolean field_149246_f; private static final String __OBFID = "CL_00001307";
/*    */   public S28PacketEffect() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 32 */     this.field_149251_a = p_148837_1_.readInt();
/* 33 */     this.field_149250_c = p_148837_1_.readInt();
/* 34 */     this.field_149247_d = p_148837_1_.readByte() & 0xFF;
/* 35 */     this.field_149248_e = p_148837_1_.readInt();
/* 36 */     this.field_149249_b = p_148837_1_.readInt();
/* 37 */     this.field_149246_f = p_148837_1_.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 42 */     p_148840_1_.writeInt(this.field_149251_a);
/* 43 */     p_148840_1_.writeInt(this.field_149250_c);
/* 44 */     p_148840_1_.writeByte(this.field_149247_d & 0xFF);
/* 45 */     p_148840_1_.writeInt(this.field_149248_e);
/* 46 */     p_148840_1_.writeInt(this.field_149249_b);
/* 47 */     p_148840_1_.writeBoolean(this.field_149246_f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 52 */     p_148833_1_.func_147277_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_149244_c() {
/* 56 */     return this.field_149246_f;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149242_d() {
/* 60 */     return this.field_149251_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149241_e() {
/* 64 */     return this.field_149249_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149240_f() {
/* 68 */     return this.field_149250_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149243_g() {
/* 72 */     return this.field_149247_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149239_h() {
/* 76 */     return this.field_149248_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S28PacketEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */