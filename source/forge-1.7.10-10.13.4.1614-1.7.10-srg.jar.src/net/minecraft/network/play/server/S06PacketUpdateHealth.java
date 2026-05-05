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
/*    */ public class S06PacketUpdateHealth
/*    */   extends Packet {
/*    */   private float field_149336_a;
/*    */   private int field_149334_b;
/*    */   
/*    */   public S06PacketUpdateHealth(float p_i45223_1_, int p_i45223_2_, float p_i45223_3_) {
/* 17 */     this.field_149336_a = p_i45223_1_;
/* 18 */     this.field_149334_b = p_i45223_2_;
/* 19 */     this.field_149335_c = p_i45223_3_;
/*    */   }
/*    */   private float field_149335_c; private static final String __OBFID = "CL_00001332";
/*    */   public S06PacketUpdateHealth() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 24 */     this.field_149336_a = p_148837_1_.readFloat();
/* 25 */     this.field_149334_b = p_148837_1_.readShort();
/* 26 */     this.field_149335_c = p_148837_1_.readFloat();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 31 */     p_148840_1_.writeFloat(this.field_149336_a);
/* 32 */     p_148840_1_.writeShort(this.field_149334_b);
/* 33 */     p_148840_1_.writeFloat(this.field_149335_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 38 */     p_148833_1_.func_147249_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_149332_c() {
/* 42 */     return this.field_149336_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149330_d() {
/* 46 */     return this.field_149334_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_149331_e() {
/* 50 */     return this.field_149335_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S06PacketUpdateHealth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */