/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ import net.minecraft.world.EnumDifficulty;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class C15PacketClientSettings
/*    */   extends Packet
/*    */ {
/*    */   private String field_149530_a;
/*    */   private int field_149528_b;
/*    */   private EntityPlayer.EnumChatVisibility field_149529_c;
/*    */   private boolean field_149526_d;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C15PacketClientSettings(String p_i45243_1_, int p_i45243_2_, EntityPlayer.EnumChatVisibility p_i45243_3_, boolean p_i45243_4_, EnumDifficulty p_i45243_5_, boolean p_i45243_6_) {
/* 25 */     this.field_149530_a = p_i45243_1_;
/* 26 */     this.field_149528_b = p_i45243_2_;
/* 27 */     this.field_149529_c = p_i45243_3_;
/* 28 */     this.field_149526_d = p_i45243_4_;
/* 29 */     this.field_149527_e = p_i45243_5_;
/* 30 */     this.field_149525_f = p_i45243_6_;
/*    */   }
/*    */   private EnumDifficulty field_149527_e; private boolean field_149525_f; private static final String __OBFID = "CL_00001350";
/*    */   public C15PacketClientSettings() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 35 */     this.field_149530_a = p_148837_1_.func_150789_c(7);
/* 36 */     this.field_149528_b = p_148837_1_.readByte();
/*    */     
/* 38 */     this.field_149529_c = EntityPlayer.EnumChatVisibility.func_151426_a(p_148837_1_.readByte());
/* 39 */     this.field_149526_d = p_148837_1_.readBoolean();
/*    */     
/* 41 */     this.field_149527_e = EnumDifficulty.func_151523_a(p_148837_1_.readByte());
/* 42 */     this.field_149525_f = p_148837_1_.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 47 */     p_148840_1_.func_150785_a(this.field_149530_a);
/* 48 */     p_148840_1_.writeByte(this.field_149528_b);
/* 49 */     p_148840_1_.writeByte(this.field_149529_c.func_151428_a());
/* 50 */     p_148840_1_.writeBoolean(this.field_149526_d);
/* 51 */     p_148840_1_.writeByte(this.field_149527_e.func_151525_a());
/* 52 */     p_148840_1_.writeBoolean(this.field_149525_f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 57 */     p_148833_1_.func_147352_a(this);
/*    */   }
/*    */   
/*    */   public String func_149524_c() {
/* 61 */     return this.field_149530_a;
/*    */   }
/*    */   
/*    */   public int func_149521_d() {
/* 65 */     return this.field_149528_b;
/*    */   }
/*    */   
/*    */   public EntityPlayer.EnumChatVisibility func_149523_e() {
/* 69 */     return this.field_149529_c;
/*    */   }
/*    */   
/*    */   public boolean func_149520_f() {
/* 73 */     return this.field_149526_d;
/*    */   }
/*    */   
/*    */   public EnumDifficulty func_149518_g() {
/* 77 */     return this.field_149527_e;
/*    */   }
/*    */   
/*    */   public boolean func_149519_h() {
/* 81 */     return this.field_149525_f;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 86 */     return String.format("lang='%s', view=%d, chat=%s, col=%b, difficulty=%s, cape=%b", new Object[] { this.field_149530_a, Integer.valueOf(this.field_149528_b), this.field_149529_c, Boolean.valueOf(this.field_149526_d), this.field_149527_e, Boolean.valueOf(this.field_149525_f) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C15PacketClientSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */