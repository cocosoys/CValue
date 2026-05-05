/*     */ package cpw.mods.fml.common.network.handshake;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.internal.FMLMessage;
/*     */ import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
/*     */ import cpw.mods.fml.common.registry.GameData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import io.netty.channel.ChannelFutureListener;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ enum FMLHandshakeClientState
/*     */   implements IHandshakeState<FMLHandshakeClientState>
/*     */ {
/*  29 */   START
/*     */   {
/*     */     
/*     */     public FMLHandshakeClientState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*     */     {
/*  34 */       NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/*  35 */       dispatcher.clientListenForServerHandshake();
/*  36 */       return HELLO;
/*     */     }
/*     */   },
/*  39 */   HELLO
/*     */   {
/*     */ 
/*     */     
/*     */     public FMLHandshakeClientState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*     */     {
/*  45 */       ctx.writeAndFlush(FMLHandshakeMessage.makeCustomChannelRegistration(NetworkRegistry.INSTANCE.channelNamesFor(Side.CLIENT)));
/*  46 */       if (msg == null) {
/*     */         
/*  48 */         NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/*  49 */         dispatcher.abortClientHandshake("VANILLA");
/*     */         
/*  51 */         return DONE;
/*     */       } 
/*     */       
/*  54 */       FMLHandshakeMessage.ServerHello serverHelloPacket = (FMLHandshakeMessage.ServerHello)msg;
/*  55 */       FMLLog.info("Server protocol version %x", new Object[] { Byte.valueOf(serverHelloPacket.protocolVersion()) });
/*  56 */       if (serverHelloPacket.protocolVersion() > 1) {
/*     */ 
/*     */         
/*  59 */         NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/*  60 */         dispatcher.setOverrideDimension(serverHelloPacket.overrideDim());
/*     */       } 
/*  62 */       ctx.writeAndFlush(new FMLHandshakeMessage.ClientHello()).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*  63 */       ctx.writeAndFlush(new FMLHandshakeMessage.ModList(Loader.instance().getActiveModList())).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*  64 */       return WAITINGSERVERDATA;
/*     */     }
/*     */   },
/*     */   
/*  68 */   WAITINGSERVERDATA
/*     */   {
/*     */     
/*     */     public FMLHandshakeClientState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*     */     {
/*  73 */       String result = FMLNetworkHandler.checkModList((FMLHandshakeMessage.ModList)msg, Side.SERVER);
/*  74 */       if (result != null) {
/*     */         
/*  76 */         NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/*  77 */         dispatcher.rejectHandshake(result);
/*  78 */         return ERROR;
/*     */       } 
/*  80 */       ctx.writeAndFlush(new FMLHandshakeMessage.HandshakeAck(ordinal())).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*  81 */       if (!((Boolean)ctx.channel().attr(NetworkDispatcher.IS_LOCAL).get()).booleanValue())
/*     */       {
/*  83 */         return WAITINGSERVERCOMPLETE;
/*     */       }
/*     */ 
/*     */       
/*  87 */       return PENDINGCOMPLETE;
/*     */     }
/*     */   },
/*     */   
/*  91 */   WAITINGSERVERCOMPLETE
/*     */   {
/*     */     
/*     */     public FMLHandshakeClientState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*     */     {
/*  96 */       FMLHandshakeMessage.ModIdData modIds = (FMLHandshakeMessage.ModIdData)msg;
/*  97 */       List<String> locallyMissing = GameData.injectWorldIDMap(modIds.dataList(), modIds.blockSubstitutions(), modIds.itemSubstitutions(), false, false);
/*  98 */       if (!locallyMissing.isEmpty()) {
/*     */         
/* 100 */         NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/* 101 */         dispatcher.rejectHandshake("Fatally missing blocks and items");
/* 102 */         FMLLog.severe("Failed to connect to server: there are %d missing blocks and items", new Object[] { Integer.valueOf(locallyMissing.size()) });
/* 103 */         FMLLog.fine("Missing list: %s", new Object[] { locallyMissing });
/* 104 */         return ERROR;
/*     */       } 
/* 106 */       ctx.writeAndFlush(new FMLHandshakeMessage.HandshakeAck(ordinal())).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/* 107 */       return PENDINGCOMPLETE;
/*     */     }
/*     */   },
/* 110 */   PENDINGCOMPLETE
/*     */   {
/*     */     
/*     */     public FMLHandshakeClientState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*     */     {
/* 115 */       ctx.writeAndFlush(new FMLHandshakeMessage.HandshakeAck(ordinal())).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/* 116 */       return COMPLETE;
/*     */     }
/*     */   },
/* 119 */   COMPLETE
/*     */   {
/*     */     
/*     */     public FMLHandshakeClientState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*     */     {
/* 124 */       NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/* 125 */       dispatcher.completeClientHandshake();
/* 126 */       FMLMessage.CompleteHandshake complete = new FMLMessage.CompleteHandshake(Side.CLIENT);
/* 127 */       ctx.fireChannelRead(complete);
/* 128 */       ctx.writeAndFlush(new FMLHandshakeMessage.HandshakeAck(ordinal())).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/* 129 */       return DONE;
/*     */     }
/*     */   },
/* 132 */   DONE
/*     */   {
/*     */     
/*     */     public FMLHandshakeClientState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*     */     {
/* 137 */       if (msg instanceof FMLHandshakeMessage.HandshakeReset) {
/*     */         
/* 139 */         GameData.revertToFrozen();
/* 140 */         return HELLO;
/*     */       } 
/* 142 */       return this;
/*     */     }
/*     */   },
/* 145 */   ERROR
/*     */   {
/*     */     
/*     */     public FMLHandshakeClientState accept(ChannelHandlerContext ctx, FMLHandshakeMessage msg)
/*     */     {
/* 150 */       return this;
/*     */     }
/*     */   };
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\FMLHandshakeClientState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */