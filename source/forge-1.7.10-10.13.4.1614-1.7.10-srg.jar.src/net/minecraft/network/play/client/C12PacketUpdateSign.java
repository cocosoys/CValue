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
/*    */ public class C12PacketUpdateSign
/*    */   extends Packet {
/*    */   private int field_149593_a;
/*    */   private int field_149591_b;
/*    */   private int field_149592_c;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C12PacketUpdateSign(int p_i45264_1_, int p_i45264_2_, int p_i45264_3_, String[] p_i45264_4_) {
/* 19 */     this.field_149593_a = p_i45264_1_;
/* 20 */     this.field_149591_b = p_i45264_2_;
/* 21 */     this.field_149592_c = p_i45264_3_;
/* 22 */     this.field_149590_d = new String[] { p_i45264_4_[0], p_i45264_4_[1], p_i45264_4_[2], p_i45264_4_[3] };
/*    */   }
/*    */ 
/*    */   
/*    */   private String[] field_149590_d;
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 29 */     this.field_149593_a = p_148837_1_.readInt();
/* 30 */     this.field_149591_b = p_148837_1_.readShort();
/* 31 */     this.field_149592_c = p_148837_1_.readInt();
/* 32 */     this.field_149590_d = new String[4];
/* 33 */     for (byte b = 0; b < 4; b++)
/* 34 */       this.field_149590_d[b] = p_148837_1_.func_150789_c(15); 
/*    */   }
/*    */   private static final String __OBFID = "CL_00001370";
/*    */   public C12PacketUpdateSign() {}
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 39 */     p_148840_1_.writeInt(this.field_149593_a);
/* 40 */     p_148840_1_.writeShort(this.field_149591_b);
/* 41 */     p_148840_1_.writeInt(this.field_149592_c);
/* 42 */     for (byte b = 0; b < 4; b++) {
/* 43 */       p_148840_1_.func_150785_a(this.field_149590_d[b]);
/*    */     }
/*    */   }
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 48 */     p_148833_1_.func_147343_a(this);
/*    */   }
/*    */   
/*    */   public int func_149588_c() {
/* 52 */     return this.field_149593_a;
/*    */   }
/*    */   
/*    */   public int func_149586_d() {
/* 56 */     return this.field_149591_b;
/*    */   }
/*    */   
/*    */   public int func_149585_e() {
/* 60 */     return this.field_149592_c;
/*    */   }
/*    */   
/*    */   public String[] func_149589_f() {
/* 64 */     return this.field_149590_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C12PacketUpdateSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */