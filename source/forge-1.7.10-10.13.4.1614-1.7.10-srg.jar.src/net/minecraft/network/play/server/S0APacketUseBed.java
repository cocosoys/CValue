/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class S0APacketUseBed extends Packet {
/*    */   private int field_149097_a;
/*    */   private int field_149095_b;
/*    */   private int field_149096_c;
/*    */   private int field_149094_d;
/*    */   private static final String __OBFID = "CL_00001319";
/*    */   
/*    */   public S0APacketUseBed() {}
/*    */   
/*    */   public S0APacketUseBed(EntityPlayer p_i45210_1_, int p_i45210_2_, int p_i45210_3_, int p_i45210_4_) {
/* 23 */     this.field_149095_b = p_i45210_2_;
/* 24 */     this.field_149096_c = p_i45210_3_;
/* 25 */     this.field_149094_d = p_i45210_4_;
/* 26 */     this.field_149097_a = p_i45210_1_.func_145782_y();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 31 */     this.field_149097_a = p_148837_1_.readInt();
/* 32 */     this.field_149095_b = p_148837_1_.readInt();
/* 33 */     this.field_149096_c = p_148837_1_.readByte();
/* 34 */     this.field_149094_d = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 39 */     p_148840_1_.writeInt(this.field_149097_a);
/* 40 */     p_148840_1_.writeInt(this.field_149095_b);
/* 41 */     p_148840_1_.writeByte(this.field_149096_c);
/* 42 */     p_148840_1_.writeInt(this.field_149094_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 47 */     p_148833_1_.func_147278_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EntityPlayer func_149091_a(World p_149091_1_) {
/* 51 */     return (EntityPlayer)p_149091_1_.func_73045_a(this.field_149097_a);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149092_c() {
/* 55 */     return this.field_149095_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149090_d() {
/* 59 */     return this.field_149096_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149089_e() {
/* 63 */     return this.field_149094_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S0APacketUseBed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */