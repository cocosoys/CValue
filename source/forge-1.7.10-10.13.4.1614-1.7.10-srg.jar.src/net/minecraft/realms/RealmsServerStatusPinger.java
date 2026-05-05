/*     */ package net.minecraft.realms;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.network.EnumConnectionState;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.ServerStatusResponse;
/*     */ import net.minecraft.network.status.INetHandlerStatusClient;
/*     */ import net.minecraft.network.status.client.C01PacketPing;
/*     */ import net.minecraft.network.status.server.S00PacketServerInfo;
/*     */ import net.minecraft.network.status.server.S01PacketPong;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RealmsServerStatusPinger {
/*  21 */   private static final Logger LOGGER = LogManager.getLogger();
/*     */   
/*  23 */   private final List connections = Collections.synchronizedList(new ArrayList()); private static final String __OBFID = "CL_00001854";
/*     */   
/*     */   public void pingServer(String p_pingServer_1_, ServerPing p_pingServer_2_) throws IOException {
/*  26 */     if (p_pingServer_1_ == null || p_pingServer_1_.startsWith("0.0.0.0") || p_pingServer_1_.isEmpty())
/*     */       return; 
/*  28 */     RealmsServerAddress realmsServerAddress = RealmsServerAddress.parseString(p_pingServer_1_);
/*  29 */     NetworkManager networkManager = NetworkManager.func_150726_a(InetAddress.getByName(realmsServerAddress.getHost()), realmsServerAddress.getPort());
/*     */     
/*  31 */     this.connections.add(networkManager);
/*     */     
/*  33 */     networkManager.func_150719_a((INetHandler)new INetHandlerStatusClient(this, p_pingServer_2_, networkManager, p_pingServer_1_) { private boolean field_154345_e = false;
/*     */           private static final String __OBFID = "CL_00001807";
/*     */           
/*     */           public void func_147397_a(S00PacketServerInfo p_147397_1_) {
/*  37 */             ServerStatusResponse serverStatusResponse = p_147397_1_.func_149294_c();
/*     */             
/*  39 */             if (serverStatusResponse.func_151318_b() != null) {
/*  40 */               this.field_154341_a.nrOfPlayers = String.valueOf(serverStatusResponse.func_151318_b().func_151333_b());
/*     */             }
/*     */             
/*  43 */             this.field_154342_b.func_150725_a((Packet)new C01PacketPing(Realms.currentTimeMillis()), new io.netty.util.concurrent.GenericFutureListener[0]);
/*  44 */             this.field_154345_e = true;
/*     */           }
/*     */ 
/*     */           
/*     */           public void func_147398_a(S01PacketPong p_147398_1_) {
/*  49 */             this.field_154342_b.func_150718_a((IChatComponent)new ChatComponentText("Finished"));
/*     */           }
/*     */ 
/*     */           
/*     */           public void func_147231_a(IChatComponent p_147231_1_) {
/*  54 */             if (!this.field_154345_e) {
/*  55 */               RealmsServerStatusPinger.LOGGER.error("Can't ping " + this.field_154343_c + ": " + p_147231_1_.func_150260_c());
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public void func_147232_a(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_) {
/*  61 */             if (p_147232_2_ != EnumConnectionState.STATUS) {
/*  62 */               throw new UnsupportedOperationException("Unexpected change in protocol to " + p_147232_2_);
/*     */             }
/*     */           }
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
/*     */           public void func_147233_a() {} }
/*     */       );
/*     */     try {
/*  78 */       networkManager.func_150725_a((Packet)new C00Handshake(RealmsSharedConstants.NETWORK_PROTOCOL_VERSION, realmsServerAddress.getHost(), realmsServerAddress.getPort(), EnumConnectionState.STATUS), new io.netty.util.concurrent.GenericFutureListener[0]);
/*  79 */       networkManager.func_150725_a((Packet)new C00PacketServerQuery(), new io.netty.util.concurrent.GenericFutureListener[0]);
/*  80 */     } catch (Throwable throwable) {
/*  81 */       LOGGER.error(throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  86 */     synchronized (this.connections) {
/*  87 */       Iterator<NetworkManager> iterator = this.connections.iterator();
/*  88 */       while (iterator.hasNext()) {
/*  89 */         NetworkManager networkManager = iterator.next();
/*     */         
/*  91 */         if (networkManager.func_150724_d()) {
/*  92 */           networkManager.func_74428_b(); continue;
/*     */         } 
/*  94 */         iterator.remove();
/*  95 */         if (networkManager.func_150730_f() != null) {
/*  96 */           networkManager.func_150729_e().func_147231_a(networkManager.func_150730_f());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAll() {
/* 104 */     synchronized (this.connections) {
/* 105 */       Iterator<NetworkManager> iterator = this.connections.iterator();
/* 106 */       while (iterator.hasNext()) {
/* 107 */         NetworkManager networkManager = iterator.next();
/*     */         
/* 109 */         if (networkManager.func_150724_d()) {
/* 110 */           iterator.remove();
/* 111 */           networkManager.func_150718_a((IChatComponent)new ChatComponentText("Cancelled"));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsServerStatusPinger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */