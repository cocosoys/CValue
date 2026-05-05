/*    */ package cpw.mods.fml.common.network.handshake;
/*    */ 
/*    */ import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ 
/*    */ public class FMLHandshakeCodec
/*    */   extends FMLIndexedMessageToMessageCodec<FMLHandshakeMessage> {
/*    */   public FMLHandshakeCodec() {
/* 10 */     addDiscriminator(0, FMLHandshakeMessage.ServerHello.class);
/* 11 */     addDiscriminator(1, FMLHandshakeMessage.ClientHello.class);
/* 12 */     addDiscriminator(2, FMLHandshakeMessage.ModList.class);
/* 13 */     addDiscriminator(3, FMLHandshakeMessage.ModIdData.class);
/* 14 */     addDiscriminator(-1, FMLHandshakeMessage.HandshakeAck.class);
/* 15 */     addDiscriminator(-2, FMLHandshakeMessage.HandshakeReset.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void encodeInto(ChannelHandlerContext ctx, FMLHandshakeMessage msg, ByteBuf target) throws Exception {
/* 20 */     msg.toBytes(target);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, FMLHandshakeMessage msg) {
/* 26 */     msg.fromBytes(source);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\FMLHandshakeCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */