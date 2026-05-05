/*    */ package cpw.mods.fml.common.network.handshake;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.Loader;
/*    */ import cpw.mods.fml.common.network.NetworkRegistry;
/*    */ import cpw.mods.fml.common.network.internal.FMLMessage;
/*    */ import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
/*    */ import cpw.mods.fml.common.registry.GameData;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import io.netty.channel.ChannelFutureListener;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.util.concurrent.GenericFutureListener;
/*    */ 
/*    */ enum FMLHandshakeServerState implements IHandshakeState<FMLHandshakeServerState> {
/* 15 */   START
/*    */   {
/*    */     
/*    */     public FMLHandshakeServerState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*    */     {
/* 20 */       NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/* 21 */       int overrideDim = dispatcher.serverInitiateHandshake();
/* 22 */       ctx.writeAndFlush(FMLHandshakeMessage.makeCustomChannelRegistration(NetworkRegistry.INSTANCE.channelNamesFor(Side.SERVER))).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/* 23 */       ctx.writeAndFlush(new FMLHandshakeMessage.ServerHello(overrideDim)).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/* 24 */       return HELLO;
/*    */     }
/*    */   },
/* 27 */   HELLO
/*    */   {
/*    */ 
/*    */     
/*    */     public FMLHandshakeServerState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*    */     {
/* 33 */       if (msg instanceof FMLHandshakeMessage.ClientHello) {
/*    */         
/* 35 */         FMLLog.info("Client protocol version %x", new Object[] { Byte.valueOf(((FMLHandshakeMessage.ClientHello)msg).protocolVersion()) });
/* 36 */         return this;
/*    */       } 
/*    */       
/* 39 */       FMLHandshakeMessage.ModList client = (FMLHandshakeMessage.ModList)msg;
/* 40 */       FMLLog.info("Client attempting to join with %d mods : %s", new Object[] { Integer.valueOf(client.modListSize()), client.modListAsString() });
/* 41 */       String result = FMLNetworkHandler.checkModList(client, Side.CLIENT);
/* 42 */       if (result != null) {
/*    */         
/* 44 */         NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/* 45 */         dispatcher.rejectHandshake(result);
/* 46 */         return ERROR;
/*    */       } 
/* 48 */       ctx.writeAndFlush(new FMLHandshakeMessage.ModList(Loader.instance().getActiveModList()));
/* 49 */       return WAITINGCACK;
/*    */     }
/*    */   },
/* 52 */   WAITINGCACK
/*    */   {
/*    */     
/*    */     public FMLHandshakeServerState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*    */     {
/* 57 */       if (!((Boolean)ctx.channel().attr(NetworkDispatcher.IS_LOCAL).get()).booleanValue())
/*    */       {
/* 59 */         ctx.writeAndFlush(new FMLHandshakeMessage.ModIdData(GameData.buildItemDataList())).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*    */       }
/* 61 */       ctx.writeAndFlush(new FMLHandshakeMessage.HandshakeAck(ordinal())).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/* 62 */       NetworkRegistry.INSTANCE.fireNetworkHandshake((NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get(), Side.SERVER);
/* 63 */       return COMPLETE;
/*    */     }
/*    */   },
/* 66 */   COMPLETE
/*    */   {
/*    */ 
/*    */     
/*    */     public FMLHandshakeServerState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*    */     {
/* 72 */       ctx.writeAndFlush(new FMLHandshakeMessage.HandshakeAck(ordinal())).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/* 73 */       FMLMessage.CompleteHandshake complete = new FMLMessage.CompleteHandshake(Side.SERVER);
/* 74 */       ctx.fireChannelRead(complete);
/* 75 */       return DONE;
/*    */     }
/*    */   },
/* 78 */   DONE
/*    */   {
/*    */     
/*    */     public FMLHandshakeServerState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*    */     {
/* 83 */       return this;
/*    */     }
/*    */   },
/* 86 */   ERROR
/*    */   {
/*    */     
/*    */     public FMLHandshakeServerState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*    */     {
/* 91 */       return this;
/*    */     }
/*    */   };
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\FMLHandshakeServerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */