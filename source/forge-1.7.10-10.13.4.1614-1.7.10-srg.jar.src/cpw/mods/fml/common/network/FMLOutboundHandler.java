/*     */ package cpw.mods.fml.common.network;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.handshake.NetworkDispatcher;
/*     */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.channel.ChannelOutboundHandlerAdapter;
/*     */ import io.netty.channel.ChannelPromise;
/*     */ import io.netty.util.AttributeKey;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ 
/*     */ public class FMLOutboundHandler
/*     */   extends ChannelOutboundHandlerAdapter
/*     */ {
/*  21 */   public static final AttributeKey<OutboundTarget> FML_MESSAGETARGET = new AttributeKey("fml:outboundTarget");
/*  22 */   public static final AttributeKey<Object> FML_MESSAGETARGETARGS = new AttributeKey("fml:outboundTargetArgs");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum OutboundTarget
/*     */   {
/*  30 */     NOWHERE((String)Sets.immutableEnumSet((Enum)Side.CLIENT, (Enum[])new Side[] { Side.SERVER }))
/*     */     {
/*     */       public void validateArgs(Object args) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<NetworkDispatcher> selectNetworks(Object args, ChannelHandlerContext context, FMLProxyPacket packet) {
/*  41 */         return null;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     DISPATCHER((String)Sets.immutableEnumSet((Enum)Side.SERVER, (Enum[])new Side[0]))
/*     */     {
/*     */       
/*     */       public void validateArgs(Object args)
/*     */       {
/*  56 */         if (!(args instanceof NetworkDispatcher))
/*     */         {
/*  58 */           throw new RuntimeException("DISPATCHER expects a NetworkDispatcher");
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public List<NetworkDispatcher> selectNetworks(Object args, ChannelHandlerContext context, FMLProxyPacket packet) {
/*  65 */         return (List<NetworkDispatcher>)ImmutableList.of(args);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     REPLY((String)Sets.immutableEnumSet((Enum)Side.SERVER, (Enum[])new Side[0]))
/*     */     {
/*     */       public void validateArgs(Object args) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<NetworkDispatcher> selectNetworks(Object args, ChannelHandlerContext context, FMLProxyPacket packet) {
/*  86 */         return (List<NetworkDispatcher>)ImmutableList.of(packet.getDispatcher());
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     PLAYER((String)Sets.immutableEnumSet((Enum)Side.SERVER, (Enum[])new Side[0]))
/*     */     {
/*     */       
/*     */       public void validateArgs(Object args)
/*     */       {
/* 100 */         if (!(args instanceof EntityPlayerMP))
/*     */         {
/* 102 */           throw new RuntimeException("PLAYER target expects a Player arg");
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public List<NetworkDispatcher> selectNetworks(Object args, ChannelHandlerContext context, FMLProxyPacket packet) {
/* 108 */         EntityPlayerMP player = (EntityPlayerMP)args;
/* 109 */         NetworkDispatcher dispatcher = (player == null) ? null : (NetworkDispatcher)player.playerNetServerHandler.netManager.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/* 110 */         return (dispatcher == null) ? (List<NetworkDispatcher>)ImmutableList.of() : (List<NetworkDispatcher>)ImmutableList.of(dispatcher);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     ALL((String)Sets.immutableEnumSet((Enum)Side.SERVER, (Enum[])new Side[0]))
/*     */     {
/*     */       public void validateArgs(Object args) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<NetworkDispatcher> selectNetworks(Object args, ChannelHandlerContext context, FMLProxyPacket packet) {
/* 128 */         ImmutableList.Builder<NetworkDispatcher> builder = ImmutableList.builder();
/* 129 */         for (EntityPlayerMP player : (FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager()).playerEntityList) {
/*     */           
/* 131 */           NetworkDispatcher dispatcher = (NetworkDispatcher)player.playerNetServerHandler.netManager.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/* 132 */           if (dispatcher != null) builder.add(dispatcher); 
/*     */         } 
/* 134 */         return (List<NetworkDispatcher>)builder.build();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 142 */     DIMENSION((String)Sets.immutableEnumSet((Enum)Side.SERVER, (Enum[])new Side[0]))
/*     */     {
/*     */       
/*     */       public void validateArgs(Object args)
/*     */       {
/* 147 */         if (!(args instanceof Integer))
/*     */         {
/* 149 */           throw new RuntimeException("DIMENSION expects an integer argument");
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public List<NetworkDispatcher> selectNetworks(Object args, ChannelHandlerContext context, FMLProxyPacket packet) {
/* 156 */         int dimension = ((Integer)args).intValue();
/* 157 */         ImmutableList.Builder<NetworkDispatcher> builder = ImmutableList.builder();
/* 158 */         for (EntityPlayerMP player : (FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager()).playerEntityList) {
/*     */           
/* 160 */           if (dimension == player.dimension) {
/*     */             
/* 162 */             NetworkDispatcher dispatcher = (NetworkDispatcher)player.playerNetServerHandler.netManager.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/*     */             
/* 164 */             if (dispatcher != null) builder.add(dispatcher); 
/*     */           } 
/*     */         } 
/* 167 */         return (List<NetworkDispatcher>)builder.build();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     ALLAROUNDPOINT((String)Sets.immutableEnumSet((Enum)Side.SERVER, (Enum[])new Side[0]))
/*     */     {
/*     */       
/*     */       public void validateArgs(Object args)
/*     */       {
/* 181 */         if (!(args instanceof NetworkRegistry.TargetPoint))
/*     */         {
/* 183 */           throw new RuntimeException("ALLAROUNDPOINT expects a TargetPoint argument");
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<NetworkDispatcher> selectNetworks(Object args, ChannelHandlerContext context, FMLProxyPacket packet) {
/* 191 */         NetworkRegistry.TargetPoint tp = (NetworkRegistry.TargetPoint)args;
/* 192 */         ImmutableList.Builder<NetworkDispatcher> builder = ImmutableList.builder();
/* 193 */         for (EntityPlayerMP player : (FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager()).playerEntityList) {
/*     */           
/* 195 */           if (player.dimension == tp.dimension) {
/*     */             
/* 197 */             double d4 = tp.x - player.posX;
/* 198 */             double d5 = tp.y - player.posY;
/* 199 */             double d6 = tp.z - player.posZ;
/*     */             
/* 201 */             if (d4 * d4 + d5 * d5 + d6 * d6 < tp.range * tp.range) {
/*     */               
/* 203 */               NetworkDispatcher dispatcher = (NetworkDispatcher)player.playerNetServerHandler.netManager.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/* 204 */               if (dispatcher != null) builder.add(dispatcher); 
/*     */             } 
/*     */           } 
/*     */         } 
/* 208 */         return (List<NetworkDispatcher>)builder.build();
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     TOSERVER((String)Sets.immutableEnumSet((Enum)Side.CLIENT, (Enum[])new Side[0]))
/*     */     {
/*     */       public void validateArgs(Object args) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<NetworkDispatcher> selectNetworks(Object args, ChannelHandlerContext context, FMLProxyPacket packet) {
/* 225 */         NetworkManager clientConnection = FMLCommonHandler.instance().getClientToServerNetworkManager();
/* 226 */         return (clientConnection == null || clientConnection.channel().attr(NetworkDispatcher.FML_DISPATCHER).get() == null) ? (List<NetworkDispatcher>)ImmutableList.of() : (List<NetworkDispatcher>)ImmutableList.of(clientConnection.channel().attr(NetworkDispatcher.FML_DISPATCHER).get());
/*     */       } };
/*     */     
/*     */     public final ImmutableSet<Side> allowed;
/*     */     
/*     */     OutboundTarget(ImmutableSet<Side> sides) {
/* 232 */       this.allowed = sides;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract void validateArgs(Object param1Object);
/*     */     
/*     */     public abstract List<NetworkDispatcher> selectNetworks(Object param1Object, ChannelHandlerContext param1ChannelHandlerContext, FMLProxyPacket param1FMLProxyPacket);
/*     */   }
/*     */   
/*     */   public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
/* 242 */     if (!(msg instanceof FMLProxyPacket)) {
/*     */       return;
/*     */     }
/*     */     
/* 246 */     FMLProxyPacket pkt = (FMLProxyPacket)msg;
/*     */     
/* 248 */     Object args = null;
/* 249 */     NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).get();
/*     */     
/* 251 */     if (dispatcher != null) {
/*     */       
/* 253 */       ctx.write(msg, promise);
/*     */       
/*     */       return;
/*     */     } 
/* 257 */     OutboundTarget outboundTarget = (OutboundTarget)ctx.channel().attr(FML_MESSAGETARGET).get();
/* 258 */     Side channelSide = (Side)ctx.channel().attr(NetworkRegistry.CHANNEL_SOURCE).get();
/* 259 */     if (outboundTarget != null && outboundTarget.allowed.contains(channelSide)) {
/*     */       
/* 261 */       args = ctx.channel().attr(FML_MESSAGETARGETARGS).get();
/* 262 */       outboundTarget.validateArgs(args);
/*     */     }
/* 264 */     else if (channelSide == Side.CLIENT) {
/*     */       
/* 266 */       outboundTarget = OutboundTarget.TOSERVER;
/*     */     }
/*     */     else {
/*     */       
/* 270 */       throw new FMLNetworkException("Packet arrived at the outbound handler without a valid target!");
/*     */     } 
/*     */     
/* 273 */     List<NetworkDispatcher> dispatchers = outboundTarget.selectNetworks(args, ctx, pkt);
/*     */ 
/*     */     
/* 276 */     if (dispatchers == null) {
/*     */       
/* 278 */       ctx.write(msg, promise);
/* 279 */       promise.setSuccess();
/*     */       return;
/*     */     } 
/* 282 */     for (NetworkDispatcher targetDispatcher : dispatchers)
/*     */     {
/* 284 */       targetDispatcher.sendProxy((FMLProxyPacket)msg);
/*     */     }
/* 286 */     promise.setSuccess();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\FMLOutboundHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */