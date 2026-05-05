/*    */ package net.minecraft.network.play.client;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C09PacketHeldItemChange extends Packet {
/*    */   private int field_149615_a;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C09PacketHeldItemChange(int p_i45262_1_) {
/* 15 */     this.field_149615_a = p_i45262_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001368";
/*    */   public C09PacketHeldItemChange() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 20 */     this.field_149615_a = p_148837_1_.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 25 */     p_148840_1_.writeShort(this.field_149615_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 30 */     p_148833_1_.func_147355_a(this);
/*    */   }
/*    */   
/*    */   public int func_149614_c() {
/* 34 */     return this.field_149615_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C09PacketHeldItemChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */