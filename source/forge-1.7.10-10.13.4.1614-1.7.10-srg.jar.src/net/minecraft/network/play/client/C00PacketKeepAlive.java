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
/*    */ public class C00PacketKeepAlive extends Packet {
/*    */   private int field_149461_a;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C00PacketKeepAlive(int p_i45252_1_) {
/* 16 */     this.field_149461_a = p_i45252_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001359";
/*    */   public C00PacketKeepAlive() {}
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 21 */     p_148833_1_.func_147353_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 26 */     this.field_149461_a = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 31 */     p_148840_1_.writeInt(this.field_149461_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public int func_149460_c() {
/* 40 */     return this.field_149461_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C00PacketKeepAlive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */