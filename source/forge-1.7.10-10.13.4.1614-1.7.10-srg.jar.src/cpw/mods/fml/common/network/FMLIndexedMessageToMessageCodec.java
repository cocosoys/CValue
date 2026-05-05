/*    */ package cpw.mods.fml.common.network;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*    */ import gnu.trove.map.hash.TByteObjectHashMap;
/*    */ import gnu.trove.map.hash.TObjectByteHashMap;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.buffer.Unpooled;
/*    */ import io.netty.channel.ChannelHandler.Sharable;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.MessageToMessageCodec;
/*    */ import io.netty.util.AttributeKey;
/*    */ import java.lang.ref.WeakReference;
/*    */ import java.util.List;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ @Sharable
/*    */ public abstract class FMLIndexedMessageToMessageCodec<A> extends MessageToMessageCodec<FMLProxyPacket, A> {
/* 19 */   private TByteObjectHashMap<Class<? extends A>> discriminators = new TByteObjectHashMap();
/* 20 */   private TObjectByteHashMap<Class<? extends A>> types = new TObjectByteHashMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 26 */   public static final AttributeKey<ThreadLocal<WeakReference<FMLProxyPacket>>> INBOUNDPACKETTRACKER = new AttributeKey("fml:inboundpacket");
/*    */ 
/*    */ 
/*    */   
/*    */   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
/* 31 */     super.handlerAdded(ctx);
/* 32 */     ctx.attr(INBOUNDPACKETTRACKER).set(new ThreadLocal());
/*    */   }
/*    */ 
/*    */   
/*    */   public FMLIndexedMessageToMessageCodec<A> addDiscriminator(int discriminator, Class<? extends A> type) {
/* 37 */     this.discriminators.put((byte)discriminator, type);
/* 38 */     this.types.put(type, (byte)discriminator);
/* 39 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void encode(ChannelHandlerContext ctx, A msg, List<Object> out) throws Exception {
/* 46 */     ByteBuf buffer = Unpooled.buffer();
/*    */     
/* 48 */     Class<? extends A> clazz = (Class)msg.getClass();
/* 49 */     byte discriminator = this.types.get(clazz);
/* 50 */     buffer.writeByte(discriminator);
/* 51 */     encodeInto(ctx, msg, buffer);
/* 52 */     FMLProxyPacket proxy = new FMLProxyPacket(buffer.copy(), (String)ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
/* 53 */     WeakReference<FMLProxyPacket> ref = ((ThreadLocal<WeakReference<FMLProxyPacket>>)ctx.attr(INBOUNDPACKETTRACKER).get()).get();
/* 54 */     FMLProxyPacket old = (ref == null) ? null : ref.get();
/* 55 */     if (old != null)
/*    */     {
/* 57 */       proxy.setDispatcher(old.getDispatcher());
/*    */     }
/* 59 */     out.add(proxy);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception {
/* 67 */     testMessageValidity(msg);
/* 68 */     ByteBuf payload = msg.payload();
/* 69 */     byte discriminator = payload.readByte();
/* 70 */     Class<? extends A> clazz = (Class<? extends A>)this.discriminators.get(discriminator);
/* 71 */     if (clazz == null)
/*    */     {
/* 73 */       throw new NullPointerException("Undefined message for discriminator " + discriminator + " in channel " + msg.channel());
/*    */     }
/* 75 */     A newMsg = clazz.newInstance();
/* 76 */     ((ThreadLocal)ctx.attr(INBOUNDPACKETTRACKER).get()).set(new WeakReference<FMLProxyPacket>(msg));
/* 77 */     decodeInto(ctx, payload.slice(), newMsg);
/* 78 */     out.add(newMsg);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void testMessageValidity(FMLProxyPacket msg) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 93 */     FMLLog.log(Level.ERROR, cause, "FMLIndexedMessageCodec exception caught", new Object[0]);
/* 94 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */   
/*    */   public abstract void encodeInto(ChannelHandlerContext paramChannelHandlerContext, A paramA, ByteBuf paramByteBuf) throws Exception;
/*    */   
/*    */   public abstract void decodeInto(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, A paramA);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\FMLIndexedMessageToMessageCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */