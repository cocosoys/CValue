/*    */ package cpw.mods.fml.common.network.internal;
/*    */ 
/*    */ import com.google.common.base.Splitter;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
/*    */ import cpw.mods.fml.common.network.FMLNetworkException;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ 
/*    */ public class FMLRuntimeCodec
/*    */   extends FMLIndexedMessageToMessageCodec<FMLMessage> {
/*    */   public FMLRuntimeCodec() {
/* 14 */     addDiscriminator(0, FMLMessage.CompleteHandshake.class);
/* 15 */     addDiscriminator(1, FMLMessage.OpenGui.class);
/* 16 */     addDiscriminator(2, FMLMessage.EntitySpawnMessage.class);
/* 17 */     addDiscriminator(3, FMLMessage.EntityAdjustMessage.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void encodeInto(ChannelHandlerContext ctx, FMLMessage msg, ByteBuf target) throws Exception {
/* 22 */     msg.toBytes(target);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, FMLMessage msg) {
/* 28 */     msg.fromBytes(source);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void testMessageValidity(FMLProxyPacket msg) {
/* 34 */     if (msg.payload().getByte(0) == 0 && msg.payload().readableBytes() > 2) {
/*    */       
/* 36 */       FMLLog.severe("The connection appears to have sent an invalid FML packet of type 0, this is likely because it think's it's talking to 1.6.4 FML", new Object[0]);
/* 37 */       FMLLog.info("Bad data :", new Object[0]);
/* 38 */       for (String l : Splitter.on('\n').split(ByteBufUtils.getContentDump(msg.payload()))) {
/* 39 */         FMLLog.info("\t%s", new Object[] { l });
/*    */       } 
/* 41 */       throw new FMLNetworkException("Invalid FML packet");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\internal\FMLRuntimeCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */