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
/*    */ public abstract class SocksResponse
/*    */   extends SocksMessage
/*    */ {
/*    */   private final SocksResponseType responseType;
/*    */   
/*    */   protected SocksResponse(SocksResponseType responseType) {
/* 31 */     super(SocksMessageType.RESPONSE);
/* 32 */     if (responseType == null) {
/* 33 */       throw new NullPointerException("responseType");
/*    */     }
/* 35 */     this.responseType = responseType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SocksResponseType responseType() {
/* 44 */     return this.responseType;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\socks\SocksResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */