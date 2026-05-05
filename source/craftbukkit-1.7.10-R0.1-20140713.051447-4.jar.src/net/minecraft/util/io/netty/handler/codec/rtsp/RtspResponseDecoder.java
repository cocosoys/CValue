/*    */ package net.minecraft.util.io.netty.handler.codec.rtsp;
/*    */ 
/*    */ import net.minecraft.util.io.netty.handler.codec.http.DefaultHttpResponse;
/*    */ import net.minecraft.util.io.netty.handler.codec.http.HttpMessage;
/*    */ import net.minecraft.util.io.netty.handler.codec.http.HttpResponseStatus;
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
/*    */ public class RtspResponseDecoder
/*    */   extends RtspObjectDecoder
/*    */ {
/* 54 */   private static final HttpResponseStatus UNKNOWN_STATUS = new HttpResponseStatus(999, "Unknown");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RtspResponseDecoder() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RtspResponseDecoder(int maxInitialLineLength, int maxHeaderSize, int maxContentLength) {
/* 69 */     super(maxInitialLineLength, maxHeaderSize, maxContentLength);
/*    */   }
/*    */ 
/*    */   
/*    */   protected HttpMessage createMessage(String[] initialLine) throws Exception {
/* 74 */     return (HttpMessage)new DefaultHttpResponse(RtspVersions.valueOf(initialLine[0]), new HttpResponseStatus(Integer.valueOf(initialLine[1]).intValue(), initialLine[2]));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected HttpMessage createInvalidMessage() {
/* 81 */     return (HttpMessage)new DefaultHttpResponse(RtspVersions.RTSP_1_0, UNKNOWN_STATUS);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isDecodingRequest() {
/* 86 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\rtsp\RtspResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */