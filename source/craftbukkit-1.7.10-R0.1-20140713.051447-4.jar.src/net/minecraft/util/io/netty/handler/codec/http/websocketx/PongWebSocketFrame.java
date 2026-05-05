/*    */ package net.minecraft.util.io.netty.handler.codec.http.websocketx;
/*    */ 
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.util.io.netty.buffer.ByteBufHolder;
/*    */ import net.minecraft.util.io.netty.buffer.Unpooled;
/*    */ import net.minecraft.util.io.netty.util.ReferenceCounted;
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
/*    */ public class PongWebSocketFrame
/*    */   extends WebSocketFrame
/*    */ {
/*    */   public PongWebSocketFrame() {
/* 30 */     super(Unpooled.buffer(0));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PongWebSocketFrame(ByteBuf binaryData) {
/* 40 */     super(binaryData);
/*    */   }
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
/*    */   public PongWebSocketFrame(boolean finalFragment, int rsv, ByteBuf binaryData) {
/* 54 */     super(finalFragment, rsv, binaryData);
/*    */   }
/*    */ 
/*    */   
/*    */   public PongWebSocketFrame copy() {
/* 59 */     return new PongWebSocketFrame(isFinalFragment(), rsv(), content().copy());
/*    */   }
/*    */ 
/*    */   
/*    */   public PongWebSocketFrame duplicate() {
/* 64 */     return new PongWebSocketFrame(isFinalFragment(), rsv(), content().duplicate());
/*    */   }
/*    */ 
/*    */   
/*    */   public PongWebSocketFrame retain() {
/* 69 */     super.retain();
/* 70 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public PongWebSocketFrame retain(int increment) {
/* 75 */     super.retain(increment);
/* 76 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\http\websocketx\PongWebSocketFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */