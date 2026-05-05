/*    */ package net.minecraft.network.handshake.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.EnumConnectionState;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.handshake.INetHandlerHandshakeServer;
/*    */ 
/*    */ public class C00Handshake
/*    */   extends Packet {
/*    */   private int field_149600_a;
/*    */   private String field_149598_b;
/*    */   private int field_149599_c;
/*    */   private EnumConnectionState field_149597_d;
/*    */   private static final String __OBFID = "CL_00001372";
/*    */   
/*    */   public C00Handshake() {}
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C00Handshake(int p_i45266_1_, String p_i45266_2_, int p_i45266_3_, EnumConnectionState p_i45266_4_) {
/* 24 */     this.field_149600_a = p_i45266_1_;
/* 25 */     this.field_149598_b = p_i45266_2_;
/* 26 */     this.field_149599_c = p_i45266_3_;
/* 27 */     this.field_149597_d = p_i45266_4_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 32 */     this.field_149600_a = p_148837_1_.func_150792_a();
/* 33 */     this.field_149598_b = p_148837_1_.func_150789_c(255);
/* 34 */     this.field_149599_c = p_148837_1_.readUnsignedShort();
/* 35 */     this.field_149597_d = EnumConnectionState.func_150760_a(p_148837_1_.func_150792_a());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 40 */     p_148840_1_.func_150787_b(this.field_149600_a);
/* 41 */     p_148840_1_.func_150785_a(this.field_149598_b);
/* 42 */     p_148840_1_.writeShort(this.field_149599_c);
/* 43 */     p_148840_1_.func_150787_b(this.field_149597_d.func_150759_c());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerHandshakeServer p_148833_1_) {
/* 48 */     p_148833_1_.func_147383_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public EnumConnectionState func_149594_c() {
/* 57 */     return this.field_149597_d;
/*    */   }
/*    */   
/*    */   public int func_149595_d() {
/* 61 */     return this.field_149600_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\handshake\client\C00Handshake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */