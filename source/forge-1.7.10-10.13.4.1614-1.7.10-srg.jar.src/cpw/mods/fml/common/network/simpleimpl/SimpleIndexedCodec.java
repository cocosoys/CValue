/*    */ package cpw.mods.fml.common.network.simpleimpl;
/*    */ 
/*    */ import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ 
/*    */ public class SimpleIndexedCodec
/*    */   extends FMLIndexedMessageToMessageCodec<IMessage>
/*    */ {
/*    */   public void encodeInto(ChannelHandlerContext ctx, IMessage msg, ByteBuf target) throws Exception {
/* 11 */     msg.toBytes(target);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, IMessage msg) {
/* 17 */     msg.fromBytes(source);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\simpleimpl\SimpleIndexedCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */