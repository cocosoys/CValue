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
/*    */ public enum SocksProtocolVersion
/*    */ {
/* 20 */   SOCKS4a((byte)4),
/* 21 */   SOCKS5((byte)5),
/* 22 */   UNKNOWN((byte)-1);
/*    */   
/*    */   private final byte b;
/*    */   
/*    */   SocksProtocolVersion(byte b) {
/* 27 */     this.b = b;
/*    */   }
/*    */   
/*    */   public static SocksProtocolVersion fromByte(byte b) {
/* 31 */     for (SocksProtocolVersion code : values()) {
/* 32 */       if (code.b == b) {
/* 33 */         return code;
/*    */       }
/*    */     } 
/* 36 */     return UNKNOWN;
/*    */   }
/*    */   
/*    */   public byte byteValue() {
/* 40 */     return this.b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\socks\SocksProtocolVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */