/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class S40PacketDisconnect
/*    */   extends Packet {
/*    */   private IChatComponent field_149167_a;
/*    */   
/*    */   public S40PacketDisconnect(IChatComponent p_i45191_1_) {
/* 17 */     this.field_149167_a = p_i45191_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001298";
/*    */   public S40PacketDisconnect() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 22 */     this.field_149167_a = IChatComponent.Serializer.func_150699_a(p_148837_1_.func_150789_c(32767));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 27 */     p_148840_1_.func_150785_a(IChatComponent.Serializer.func_150696_a(this.field_149167_a));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 32 */     p_148833_1_.func_147253_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 37 */     return true;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IChatComponent func_149165_c() {
/* 41 */     return this.field_149167_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S40PacketDisconnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */