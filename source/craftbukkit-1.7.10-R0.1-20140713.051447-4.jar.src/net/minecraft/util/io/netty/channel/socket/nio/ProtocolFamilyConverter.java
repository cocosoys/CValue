/*    */ package net.minecraft.util.io.netty.channel.socket.nio;
/*    */ 
/*    */ import java.net.ProtocolFamily;
/*    */ import java.net.StandardProtocolFamily;
/*    */ import net.minecraft.util.io.netty.channel.socket.InternetProtocolFamily;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class ProtocolFamilyConverter
/*    */ {
/*    */   public static ProtocolFamily convert(InternetProtocolFamily family) {
/* 36 */     switch (family) {
/*    */       case IPv4:
/* 38 */         return StandardProtocolFamily.INET;
/*    */       case IPv6:
/* 40 */         return StandardProtocolFamily.INET6;
/*    */     } 
/* 42 */     throw new IllegalArgumentException();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\socket\nio\ProtocolFamilyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */