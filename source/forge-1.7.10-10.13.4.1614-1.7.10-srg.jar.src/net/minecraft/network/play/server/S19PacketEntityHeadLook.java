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
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class S19PacketEntityHeadLook
/*    */   extends Packet
/*    */ {
/*    */   private int field_149384_a;
/*    */   private byte field_149383_b;
/*    */   
/*    */   public S19PacketEntityHeadLook(Entity p_i45214_1_, byte p_i45214_2_) {
/* 20 */     this.field_149384_a = p_i45214_1_.func_145782_y();
/* 21 */     this.field_149383_b = p_i45214_2_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001323";
/*    */   public S19PacketEntityHeadLook() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 26 */     this.field_149384_a = p_148837_1_.readInt();
/* 27 */     this.field_149383_b = p_148837_1_.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 32 */     p_148840_1_.writeInt(this.field_149384_a);
/* 33 */     p_148840_1_.writeByte(this.field_149383_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 38 */     p_148833_1_.func_147267_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 43 */     return String.format("id=%d, rot=%d", new Object[] { Integer.valueOf(this.field_149384_a), Byte.valueOf(this.field_149383_b) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Entity func_149381_a(World p_149381_1_) {
/* 47 */     return p_149381_1_.func_73045_a(this.field_149384_a);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public byte func_149380_c() {
/* 51 */     return this.field_149383_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S19PacketEntityHeadLook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */