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
/*    */ public class S33PacketUpdateSign
/*    */   extends Packet
/*    */ {
/*    */   private int field_149352_a;
/*    */   private int field_149350_b;
/*    */   private int field_149351_c;
/*    */   
/*    */   public S33PacketUpdateSign(int p_i45231_1_, int p_i45231_2_, int p_i45231_3_, String[] p_i45231_4_) {
/* 19 */     this.field_149352_a = p_i45231_1_;
/* 20 */     this.field_149350_b = p_i45231_2_;
/* 21 */     this.field_149351_c = p_i45231_3_;
/* 22 */     this.field_149349_d = new String[] { p_i45231_4_[0], p_i45231_4_[1], p_i45231_4_[2], p_i45231_4_[3] };
/*    */   }
/*    */   private String[] field_149349_d; private static final String __OBFID = "CL_00001338";
/*    */   
/*    */   public S33PacketUpdateSign() {}
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 29 */     this.field_149352_a = p_148837_1_.readInt();
/* 30 */     this.field_149350_b = p_148837_1_.readShort();
/* 31 */     this.field_149351_c = p_148837_1_.readInt();
/* 32 */     this.field_149349_d = new String[4];
/* 33 */     for (byte b = 0; b < 4; b++) {
/* 34 */       this.field_149349_d[b] = p_148837_1_.func_150789_c(15);
/*    */     }
/*    */   }
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 39 */     p_148840_1_.writeInt(this.field_149352_a);
/* 40 */     p_148840_1_.writeShort(this.field_149350_b);
/* 41 */     p_148840_1_.writeInt(this.field_149351_c);
/* 42 */     for (byte b = 0; b < 4; b++) {
/* 43 */       p_148840_1_.func_150785_a(this.field_149349_d[b]);
/*    */     }
/*    */   }
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 48 */     p_148833_1_.func_147248_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149346_c() {
/* 52 */     return this.field_149352_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149345_d() {
/* 56 */     return this.field_149350_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149344_e() {
/* 60 */     return this.field_149351_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String[] func_149347_f() {
/* 64 */     return this.field_149349_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S33PacketUpdateSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */