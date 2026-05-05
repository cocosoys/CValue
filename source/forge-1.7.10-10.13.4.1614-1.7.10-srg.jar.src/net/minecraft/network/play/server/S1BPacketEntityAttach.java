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
/*    */ public class S1BPacketEntityAttach
/*    */   extends Packet {
/*    */   private int field_149408_a;
/*    */   private int field_149406_b;
/*    */   private int field_149407_c;
/*    */   private static final String __OBFID = "CL_00001327";
/*    */   
/*    */   public S1BPacketEntityAttach() {}
/*    */   
/*    */   public S1BPacketEntityAttach(int p_i45218_1_, Entity p_i45218_2_, Entity p_i45218_3_) {
/* 22 */     this.field_149408_a = p_i45218_1_;
/* 23 */     this.field_149406_b = p_i45218_2_.func_145782_y();
/* 24 */     this.field_149407_c = (p_i45218_3_ != null) ? p_i45218_3_.func_145782_y() : -1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 29 */     this.field_149406_b = p_148837_1_.readInt();
/* 30 */     this.field_149407_c = p_148837_1_.readInt();
/* 31 */     this.field_149408_a = p_148837_1_.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 36 */     p_148840_1_.writeInt(this.field_149406_b);
/* 37 */     p_148840_1_.writeInt(this.field_149407_c);
/* 38 */     p_148840_1_.writeByte(this.field_149408_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 43 */     p_148833_1_.func_147243_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149404_c() {
/* 47 */     return this.field_149408_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149403_d() {
/* 51 */     return this.field_149406_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149402_e() {
/* 55 */     return this.field_149407_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S1BPacketEntityAttach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */