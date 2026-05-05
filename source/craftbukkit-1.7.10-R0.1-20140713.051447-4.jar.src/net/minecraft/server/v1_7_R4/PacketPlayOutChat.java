/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutChat
/*    */   extends Packet
/*    */ {
/*    */   private IChatBaseComponent a;
/*    */   private boolean b = true;
/*    */   
/*    */   public PacketPlayOutChat(IChatBaseComponent paramIChatBaseComponent) {
/* 18 */     this(paramIChatBaseComponent, true);
/*    */   }
/*    */   
/*    */   public PacketPlayOutChat(IChatBaseComponent paramIChatBaseComponent, boolean paramBoolean) {
/* 22 */     this.a = paramIChatBaseComponent;
/* 23 */     this.b = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 28 */     this.a = ChatSerializer.a(paramPacketDataSerializer.c(32767));
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 33 */     paramPacketDataSerializer.a(ChatSerializer.a(this.a));
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 38 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 43 */     return String.format("message='%s'", new Object[] { this.a });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean d() {
/* 51 */     return this.b;
/*    */   }
/*    */   
/*    */   public PacketPlayOutChat() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */