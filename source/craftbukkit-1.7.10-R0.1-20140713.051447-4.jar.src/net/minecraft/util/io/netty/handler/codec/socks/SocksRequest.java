/*    */ package net.minecraft.util.io.netty.handler.codec.socks;
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
/*    */ public abstract class SocksRequest
/*    */   extends SocksMessage
/*    */ {
/*    */   private final SocksRequestType requestType;
/*    */   
/*    */   protected SocksRequest(SocksRequestType requestType) {
/* 31 */     super(SocksMessageType.REQUEST);
/* 32 */     if (requestType == null) {
/* 33 */       throw new NullPointerException("requestType");
/*    */     }
/* 35 */     this.requestType = requestType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SocksRequestType requestType() {
/* 44 */     return this.requestType;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\socks\SocksRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */