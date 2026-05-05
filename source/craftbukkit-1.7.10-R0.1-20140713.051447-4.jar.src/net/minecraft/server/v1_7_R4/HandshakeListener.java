/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ 
/*    */ public class HandshakeListener
/*    */   implements PacketHandshakingInListener
/*    */ {
/* 13 */   private static final HashMap<InetAddress, Long> throttleTracker = new HashMap<InetAddress, Long>();
/* 14 */   private static int throttleCounter = 0;
/*    */   
/*    */   private final MinecraftServer a;
/*    */   
/*    */   private final NetworkManager b;
/*    */   
/*    */   public HandshakeListener(MinecraftServer minecraftserver, NetworkManager networkmanager) {
/* 21 */     this.a = minecraftserver;
/* 22 */     this.b = networkmanager;
/*    */   }
/*    */   
/*    */   public void a(PacketHandshakingInSetProtocol packethandshakinginsetprotocol) {
/* 26 */     switch (ProtocolOrdinalWrapper.a[packethandshakinginsetprotocol.c().ordinal()]) {
/*    */       case 1:
/* 28 */         this.b.a(EnumProtocol.LOGIN);
/*    */ 
/*    */ 
/*    */         
/*    */         try {
/* 33 */           long currentTime = System.currentTimeMillis();
/* 34 */           long connectionThrottle = (MinecraftServer.getServer()).server.getConnectionThrottle();
/* 35 */           InetAddress address = ((InetSocketAddress)this.b.getSocketAddress()).getAddress();
/*    */           
/* 37 */           synchronized (throttleTracker) {
/* 38 */             if (throttleTracker.containsKey(address) && !"127.0.0.1".equals(address.getHostAddress()) && currentTime - ((Long)throttleTracker.get(address)).longValue() < connectionThrottle) {
/* 39 */               throttleTracker.put(address, Long.valueOf(currentTime));
/* 40 */               ChatComponentText chatcomponenttext = new ChatComponentText("Connection throttled! Please wait before reconnecting.");
/* 41 */               this.b.handle(new PacketLoginOutDisconnect(chatcomponenttext), new net.minecraft.util.io.netty.util.concurrent.GenericFutureListener[0]);
/* 42 */               this.b.close(chatcomponenttext);
/*    */               
/*    */               return;
/*    */             } 
/* 46 */             throttleTracker.put(address, Long.valueOf(currentTime));
/* 47 */             throttleCounter++;
/* 48 */             if (throttleCounter > 200) {
/* 49 */               throttleCounter = 0;
/*    */ 
/*    */               
/* 52 */               Iterator<Map.Entry<InetAddress, Long>> iter = throttleTracker.entrySet().iterator();
/* 53 */               while (iter.hasNext()) {
/* 54 */                 Map.Entry<InetAddress, Long> entry = iter.next();
/* 55 */                 if (((Long)entry.getValue()).longValue() > connectionThrottle) {
/* 56 */                   iter.remove();
/*    */                 }
/*    */               } 
/*    */             } 
/*    */           } 
/* 61 */         } catch (Throwable t) {
/* 62 */           LogManager.getLogger().debug("Failed to check connection throttle", t);
/*    */         } 
/*    */ 
/*    */         
/* 66 */         if (packethandshakinginsetprotocol.d() > 5) {
/* 67 */           ChatComponentText chatcomponenttext = new ChatComponentText("Outdated server! I'm still on 1.7.10");
/* 68 */           this.b.handle(new PacketLoginOutDisconnect(chatcomponenttext), new net.minecraft.util.io.netty.util.concurrent.GenericFutureListener[0]);
/* 69 */           this.b.close(chatcomponenttext);
/* 70 */         } else if (packethandshakinginsetprotocol.d() < 5) {
/* 71 */           ChatComponentText chatcomponenttext = new ChatComponentText("Outdated client! Please use 1.7.10");
/* 72 */           this.b.handle(new PacketLoginOutDisconnect(chatcomponenttext), new net.minecraft.util.io.netty.util.concurrent.GenericFutureListener[0]);
/* 73 */           this.b.close(chatcomponenttext);
/*    */         } else {
/* 75 */           this.b.a(new LoginListener(this.a, this.b));
/* 76 */           ((LoginListener)this.b.getPacketListener()).hostname = packethandshakinginsetprotocol.b + ":" + packethandshakinginsetprotocol.c;
/*    */         } 
/*    */         return;
/*    */       
/*    */       case 2:
/* 81 */         this.b.a(EnumProtocol.STATUS);
/* 82 */         this.b.a(new PacketStatusListener(this.a, this.b));
/*    */         return;
/*    */     } 
/*    */     
/* 86 */     throw new UnsupportedOperationException("Invalid intention " + packethandshakinginsetprotocol.c());
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(IChatBaseComponent ichatbasecomponent) {}
/*    */   
/*    */   public void a(EnumProtocol enumprotocol, EnumProtocol enumprotocol1) {
/* 93 */     if (enumprotocol1 != EnumProtocol.LOGIN && enumprotocol1 != EnumProtocol.STATUS)
/* 94 */       throw new UnsupportedOperationException("Invalid state " + enumprotocol1); 
/*    */   }
/*    */   
/*    */   public void a() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\HandshakeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */