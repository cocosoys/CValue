/*     */ package cpw.mods.fml.common.network.internal;
/*     */ 
/*     */ import com.google.common.collect.ConcurrentHashMultiset;
/*     */ import com.google.common.collect.Multiset;
/*     */ import com.google.common.collect.Multisets;
/*     */ import com.google.common.collect.UnmodifiableIterator;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.network.FMLEmbeddedChannel;
/*     */ import cpw.mods.fml.common.network.FMLNetworkException;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.handshake.NetworkDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.client.C17PacketCustomPayload;
/*     */ import net.minecraft.network.play.server.S3FPacketCustomPayload;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.core.helpers.Integers;
/*     */ 
/*     */ public class FMLProxyPacket extends Packet {
/*     */   final String channel;
/*     */   private Side target;
/*     */   private final ByteBuf payload;
/*     */   private INetHandler netHandler;
/*     */   private NetworkDispatcher dispatcher;
/*  31 */   private static Multiset<String> badPackets = (Multiset<String>)ConcurrentHashMultiset.create();
/*  32 */   private static int packetCountWarning = Integers.parseInt(System.getProperty("fml.badPacketCounter", "100"), 100);
/*     */   
/*     */   private FMLProxyPacket(byte[] payload, String channel) {
/*  35 */     this(Unpooled.wrappedBuffer(payload), channel);
/*     */   }
/*     */ 
/*     */   
/*     */   public FMLProxyPacket(S3FPacketCustomPayload original) {
/*  40 */     this(original.func_149168_d(), original.func_149169_c());
/*  41 */     this.target = Side.CLIENT;
/*     */   }
/*     */ 
/*     */   
/*     */   public FMLProxyPacket(C17PacketCustomPayload original) {
/*  46 */     this(original.func_149558_e(), original.func_149559_c());
/*  47 */     this.target = Side.SERVER;
/*     */   }
/*     */ 
/*     */   
/*     */   public FMLProxyPacket(ByteBuf payload, String channel) {
/*  52 */     this.channel = channel;
/*  53 */     this.payload = payload;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readPacketData(PacketBuffer packetbuffer) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writePacketData(PacketBuffer packetbuffer) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processPacket(INetHandler inethandler) {
/*  79 */     this.netHandler = inethandler;
/*  80 */     FMLEmbeddedChannel fMLEmbeddedChannel = NetworkRegistry.INSTANCE.getChannel(this.channel, this.target);
/*  81 */     if (fMLEmbeddedChannel != null) {
/*     */       
/*  83 */       fMLEmbeddedChannel.attr(NetworkRegistry.NET_HANDLER).set(this.netHandler);
/*     */       
/*     */       try {
/*  86 */         if (fMLEmbeddedChannel.writeInbound(new Object[] { this })) {
/*     */           
/*  88 */           badPackets.add(this.channel);
/*  89 */           if (badPackets.size() % packetCountWarning == 0) {
/*     */             
/*  91 */             FMLLog.severe("Detected ongoing potential memory leak. %d packets have leaked. Top offenders", new Object[] { Integer.valueOf(badPackets.size()) });
/*  92 */             int i = 0;
/*  93 */             for (UnmodifiableIterator<Multiset.Entry<String>> unmodifiableIterator = Multisets.copyHighestCountFirst(badPackets).entrySet().iterator(); unmodifiableIterator.hasNext(); ) { Multiset.Entry<String> s = unmodifiableIterator.next();
/*     */               
/*  95 */               if (i++ > 10)
/*  96 */                 break;  FMLLog.severe("\t %s : %d", new Object[] { s.getElement(), Integer.valueOf(s.getCount()) }); }
/*     */           
/*     */           } 
/*     */         } 
/* 100 */         fMLEmbeddedChannel.inboundMessages().clear();
/*     */       }
/* 102 */       catch (FMLNetworkException ne) {
/*     */         
/* 104 */         FMLLog.log(Level.ERROR, (Throwable)ne, "There was a network exception handling a packet on channel %s", new Object[] { this.channel });
/* 105 */         this.dispatcher.rejectHandshake(ne.getMessage());
/*     */       }
/* 107 */       catch (Throwable t) {
/*     */         
/* 109 */         FMLLog.log(Level.ERROR, t, "There was a critical exception handling a packet on channel %s", new Object[] { this.channel });
/* 110 */         this.dispatcher.rejectHandshake("A fatal error has occured, this connection is terminated");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String channel() {
/* 117 */     return this.channel;
/*     */   }
/*     */   
/*     */   public ByteBuf payload() {
/* 121 */     return this.payload;
/*     */   }
/*     */   
/*     */   public INetHandler handler() {
/* 125 */     return this.netHandler;
/*     */   }
/*     */   
/*     */   public Packet toC17Packet() {
/* 129 */     return (Packet)new C17PacketCustomPayload(this.channel, this.payload.array());
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet toS3FPacket() {
/* 134 */     return (Packet)new S3FPacketCustomPayload(this.channel, this.payload.array());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTarget(Side target) {
/* 139 */     this.target = target;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDispatcher(NetworkDispatcher networkDispatcher) {
/* 144 */     this.dispatcher = networkDispatcher;
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkManager getOrigin() {
/* 149 */     return (this.dispatcher != null) ? this.dispatcher.manager : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkDispatcher getDispatcher() {
/* 154 */     return this.dispatcher;
/*     */   }
/*     */ 
/*     */   
/*     */   public Side getTarget() {
/* 159 */     return this.target;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\internal\FMLProxyPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */