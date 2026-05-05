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
/*    */ public class S02PacketChat extends Packet {
/*    */   private IChatComponent field_148919_a;
/*    */   private boolean field_148918_b = true;
/*    */   private static final String __OBFID = "CL_00001289";
/*    */   
/*    */   public S02PacketChat(IChatComponent p_i45179_1_) {
/* 18 */     this(p_i45179_1_, true);
/*    */   }
/*    */   
/*    */   public S02PacketChat(IChatComponent p_i45180_1_, boolean p_i45180_2_) {
/* 22 */     this.field_148919_a = p_i45180_1_;
/* 23 */     this.field_148918_b = p_i45180_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 28 */     this.field_148919_a = IChatComponent.Serializer.func_150699_a(p_148837_1_.func_150789_c(32767));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 33 */     p_148840_1_.func_150785_a(IChatComponent.Serializer.func_150696_a(this.field_148919_a));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 38 */     p_148833_1_.func_147251_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 43 */     return String.format("message='%s'", new Object[] { this.field_148919_a });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IChatComponent func_148915_c() {
/* 47 */     return this.field_148919_a;
/*    */   }
/*    */   
/*    */   public boolean func_148916_d() {
/* 51 */     return this.field_148918_b;
/*    */   }
/*    */   
/*    */   public S02PacketChat() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S02PacketChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */