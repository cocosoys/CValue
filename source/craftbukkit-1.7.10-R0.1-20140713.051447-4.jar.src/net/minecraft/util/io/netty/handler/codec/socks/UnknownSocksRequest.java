/*    */ package net.minecraft.util.io.netty.handler.codec.socks;
/*    */ 
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
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
/*    */ public final class UnknownSocksRequest
/*    */   extends SocksRequest
/*    */ {
/*    */   public UnknownSocksRequest() {
/* 30 */     super(SocksRequestType.UNKNOWN);
/*    */   }
/*    */   
/*    */   public void encodeAsByteBuf(ByteBuf byteBuf) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\socks\UnknownSocksRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */