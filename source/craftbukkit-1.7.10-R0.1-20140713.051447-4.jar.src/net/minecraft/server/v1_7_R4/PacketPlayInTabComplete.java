/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import net.minecraft.util.org.apache.commons.lang3.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayInTabComplete
/*    */   extends Packet
/*    */ {
/*    */   private String a;
/*    */   
/*    */   public PacketPlayInTabComplete() {}
/*    */   
/*    */   public PacketPlayInTabComplete(String paramString) {
/* 16 */     this.a = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 21 */     this.a = paramPacketDataSerializer.c(32767);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 26 */     paramPacketDataSerializer.a(StringUtils.substring(this.a, 0, 32767));
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 31 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */   
/*    */   public String c() {
/* 35 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 40 */     return String.format("message='%s'", new Object[] { this.a });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInTabComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */