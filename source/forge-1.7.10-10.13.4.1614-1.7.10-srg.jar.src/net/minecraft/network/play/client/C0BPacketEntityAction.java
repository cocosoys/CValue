/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class C0BPacketEntityAction
/*    */   extends Packet
/*    */ {
/*    */   private int field_149517_a;
/*    */   private int field_149515_b;
/*    */   private int field_149516_c;
/*    */   private static final String __OBFID = "CL_00001366";
/*    */   
/*    */   public C0BPacketEntityAction() {}
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C0BPacketEntityAction(Entity p_i45259_1_, int p_i45259_2_) {
/* 26 */     this(p_i45259_1_, p_i45259_2_, 0);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C0BPacketEntityAction(Entity p_i45260_1_, int p_i45260_2_, int p_i45260_3_) {
/* 30 */     this.field_149517_a = p_i45260_1_.func_145782_y();
/* 31 */     this.field_149515_b = p_i45260_2_;
/* 32 */     this.field_149516_c = p_i45260_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 37 */     this.field_149517_a = p_148837_1_.readInt();
/* 38 */     this.field_149515_b = p_148837_1_.readByte();
/* 39 */     this.field_149516_c = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 44 */     p_148840_1_.writeInt(this.field_149517_a);
/* 45 */     p_148840_1_.writeByte(this.field_149515_b);
/* 46 */     p_148840_1_.writeInt(this.field_149516_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 51 */     p_148833_1_.func_147357_a(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149513_d() {
/* 59 */     return this.field_149515_b;
/*    */   }
/*    */   
/*    */   public int func_149512_e() {
/* 63 */     return this.field_149516_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C0BPacketEntityAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */