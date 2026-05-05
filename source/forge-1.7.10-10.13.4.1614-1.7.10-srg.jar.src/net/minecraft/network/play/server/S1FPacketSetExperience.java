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
/*    */ public class S1FPacketSetExperience
/*    */   extends Packet {
/*    */   private float field_149401_a;
/*    */   private int field_149399_b;
/*    */   
/*    */   public S1FPacketSetExperience(float p_i45222_1_, int p_i45222_2_, int p_i45222_3_) {
/* 17 */     this.field_149401_a = p_i45222_1_;
/* 18 */     this.field_149399_b = p_i45222_2_;
/* 19 */     this.field_149400_c = p_i45222_3_;
/*    */   }
/*    */   private int field_149400_c; private static final String __OBFID = "CL_00001331";
/*    */   public S1FPacketSetExperience() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 24 */     this.field_149401_a = p_148837_1_.readFloat();
/* 25 */     this.field_149400_c = p_148837_1_.readShort();
/* 26 */     this.field_149399_b = p_148837_1_.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 31 */     p_148840_1_.writeFloat(this.field_149401_a);
/* 32 */     p_148840_1_.writeShort(this.field_149400_c);
/* 33 */     p_148840_1_.writeShort(this.field_149399_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 38 */     p_148833_1_.func_147295_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_149397_c() {
/* 42 */     return this.field_149401_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149396_d() {
/* 46 */     return this.field_149399_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149395_e() {
/* 50 */     return this.field_149400_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S1FPacketSetExperience.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */