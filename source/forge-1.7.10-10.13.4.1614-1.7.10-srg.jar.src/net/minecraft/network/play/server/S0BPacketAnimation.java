/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class S0BPacketAnimation
/*    */   extends Packet
/*    */ {
/*    */   private int field_148981_a;
/*    */   private int field_148980_b;
/*    */   private static final String __OBFID = "CL_00001282";
/*    */   
/*    */   public S0BPacketAnimation() {}
/*    */   
/*    */   public S0BPacketAnimation(Entity p_i45172_1_, int p_i45172_2_) {
/* 26 */     this.field_148981_a = p_i45172_1_.func_145782_y();
/* 27 */     this.field_148980_b = p_i45172_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 32 */     this.field_148981_a = p_148837_1_.func_150792_a();
/* 33 */     this.field_148980_b = p_148837_1_.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 38 */     p_148840_1_.func_150787_b(this.field_148981_a);
/* 39 */     p_148840_1_.writeByte(this.field_148980_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 44 */     p_148833_1_.func_147279_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 49 */     return String.format("id=%d, type=%d", new Object[] { Integer.valueOf(this.field_148981_a), Integer.valueOf(this.field_148980_b) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148978_c() {
/* 53 */     return this.field_148981_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148977_d() {
/* 57 */     return this.field_148980_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S0BPacketAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */