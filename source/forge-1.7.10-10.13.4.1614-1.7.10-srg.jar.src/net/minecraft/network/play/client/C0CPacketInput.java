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
/*    */ public class C0CPacketInput extends Packet {
/*    */   private float field_149624_a;
/*    */   private float field_149622_b;
/*    */   private boolean field_149623_c;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C0CPacketInput(float p_i45261_1_, float p_i45261_2_, boolean p_i45261_3_, boolean p_i45261_4_) {
/* 18 */     this.field_149624_a = p_i45261_1_;
/* 19 */     this.field_149622_b = p_i45261_2_;
/* 20 */     this.field_149623_c = p_i45261_3_;
/* 21 */     this.field_149621_d = p_i45261_4_;
/*    */   }
/*    */   private boolean field_149621_d; private static final String __OBFID = "CL_00001367";
/*    */   public C0CPacketInput() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 26 */     this.field_149624_a = p_148837_1_.readFloat();
/* 27 */     this.field_149622_b = p_148837_1_.readFloat();
/* 28 */     this.field_149623_c = p_148837_1_.readBoolean();
/* 29 */     this.field_149621_d = p_148837_1_.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 34 */     p_148840_1_.writeFloat(this.field_149624_a);
/* 35 */     p_148840_1_.writeFloat(this.field_149622_b);
/* 36 */     p_148840_1_.writeBoolean(this.field_149623_c);
/* 37 */     p_148840_1_.writeBoolean(this.field_149621_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 42 */     p_148833_1_.func_147358_a(this);
/*    */   }
/*    */   
/*    */   public float func_149620_c() {
/* 46 */     return this.field_149624_a;
/*    */   }
/*    */   
/*    */   public float func_149616_d() {
/* 50 */     return this.field_149622_b;
/*    */   }
/*    */   
/*    */   public boolean func_149618_e() {
/* 54 */     return this.field_149623_c;
/*    */   }
/*    */   
/*    */   public boolean func_149617_f() {
/* 58 */     return this.field_149621_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C0CPacketInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */