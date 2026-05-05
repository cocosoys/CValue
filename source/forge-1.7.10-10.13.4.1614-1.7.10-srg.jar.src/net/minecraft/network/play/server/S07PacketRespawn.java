/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.world.EnumDifficulty;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ import net.minecraft.world.WorldType;
/*    */ 
/*    */ public class S07PacketRespawn extends Packet {
/*    */   private int field_149088_a;
/*    */   private EnumDifficulty field_149086_b;
/*    */   private WorldSettings.GameType field_149087_c;
/*    */   private WorldType field_149085_d;
/*    */   private static final String __OBFID = "CL_00001322";
/*    */   
/*    */   public S07PacketRespawn() {}
/*    */   
/*    */   public S07PacketRespawn(int p_i45213_1_, EnumDifficulty p_i45213_2_, WorldType p_i45213_3_, WorldSettings.GameType p_i45213_4_) {
/* 24 */     this.field_149088_a = p_i45213_1_;
/* 25 */     this.field_149086_b = p_i45213_2_;
/* 26 */     this.field_149087_c = p_i45213_4_;
/* 27 */     this.field_149085_d = p_i45213_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 32 */     p_148833_1_.func_147280_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 37 */     this.field_149088_a = p_148837_1_.readInt();
/* 38 */     this.field_149086_b = EnumDifficulty.func_151523_a(p_148837_1_.readUnsignedByte());
/* 39 */     this.field_149087_c = WorldSettings.GameType.func_77146_a(p_148837_1_.readUnsignedByte());
/* 40 */     this.field_149085_d = WorldType.func_77130_a(p_148837_1_.func_150789_c(16));
/* 41 */     if (this.field_149085_d == null) {
/* 42 */       this.field_149085_d = WorldType.field_77137_b;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 48 */     p_148840_1_.writeInt(this.field_149088_a);
/* 49 */     p_148840_1_.writeByte(this.field_149086_b.func_151525_a());
/* 50 */     p_148840_1_.writeByte(this.field_149087_c.func_77148_a());
/* 51 */     p_148840_1_.func_150785_a(this.field_149085_d.func_77127_a());
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149082_c() {
/* 55 */     return this.field_149088_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EnumDifficulty func_149081_d() {
/* 59 */     return this.field_149086_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public WorldSettings.GameType func_149083_e() {
/* 63 */     return this.field_149087_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public WorldType func_149080_f() {
/* 67 */     return this.field_149085_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S07PacketRespawn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */