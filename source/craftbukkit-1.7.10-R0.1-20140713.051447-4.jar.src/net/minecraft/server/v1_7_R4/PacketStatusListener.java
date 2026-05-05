/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.net.InetSocketAddress;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftIconCache;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.server.ServerListPingEvent;
/*     */ import org.bukkit.util.CachedServerIcon;
/*     */ 
/*     */ public class PacketStatusListener
/*     */   implements PacketStatusInListener {
/*     */   private final MinecraftServer minecraftServer;
/*     */   private final NetworkManager networkManager;
/*     */   
/*     */   public PacketStatusListener(MinecraftServer minecraftserver, NetworkManager networkmanager) {
/*  22 */     this.minecraftServer = minecraftserver;
/*  23 */     this.networkManager = networkmanager;
/*     */   }
/*     */   
/*     */   public void a(IChatBaseComponent ichatbasecomponent) {}
/*     */   
/*     */   public void a(EnumProtocol enumprotocol, EnumProtocol enumprotocol1) {
/*  29 */     if (enumprotocol1 != EnumProtocol.STATUS) {
/*  30 */       throw new UnsupportedOperationException("Unexpected change in protocol to " + enumprotocol1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void a() {}
/*     */   
/*     */   public void a(PacketStatusInStart packetstatusinstart) {
/*  38 */     final Object[] players = (this.minecraftServer.getPlayerList()).players.toArray();
/*     */     class ServerListPingEvent extends ServerListPingEvent {
/*  40 */       CraftIconCache icon = PacketStatusListener.this.minecraftServer.server.getServerIcon();
/*     */       
/*     */       ServerListPingEvent() {
/*  43 */         super(((InetSocketAddress)PacketStatusListener.this.networkManager.getSocketAddress()).getAddress(), PacketStatusListener.this.minecraftServer.getMotd(), PacketStatusListener.this.minecraftServer.getPlayerList().getMaxPlayers());
/*     */       }
/*     */ 
/*     */       
/*     */       public void setServerIcon(CachedServerIcon icon) {
/*  48 */         if (!(icon instanceof CraftIconCache)) {
/*  49 */           throw new IllegalArgumentException(icon + " was not created by " + CraftServer.class);
/*     */         }
/*  51 */         this.icon = (CraftIconCache)icon;
/*     */       }
/*     */ 
/*     */       
/*     */       public Iterator<Player> iterator() throws UnsupportedOperationException {
/*  56 */         return new Iterator<Player>() {
/*     */             int i;
/*  58 */             int ret = Integer.MIN_VALUE;
/*     */             
/*     */             EntityPlayer player;
/*     */             
/*     */             public boolean hasNext() {
/*  63 */               if (this.player != null) {
/*  64 */                 return true;
/*     */               }
/*  66 */               Object[] currentPlayers = players;
/*  67 */               for (int length = currentPlayers.length, i = this.i; i < length; i++) {
/*  68 */                 EntityPlayer player = (EntityPlayer)currentPlayers[i];
/*  69 */                 if (player != null) {
/*  70 */                   this.i = i + 1;
/*  71 */                   this.player = player;
/*  72 */                   return true;
/*     */                 } 
/*     */               } 
/*  75 */               return false;
/*     */             }
/*     */ 
/*     */             
/*     */             public Player next() {
/*  80 */               if (!hasNext()) {
/*  81 */                 throw new NoSuchElementException();
/*     */               }
/*  83 */               EntityPlayer player = this.player;
/*  84 */               this.player = null;
/*  85 */               this.ret = this.i - 1;
/*  86 */               return (Player)player.getBukkitEntity();
/*     */             }
/*     */ 
/*     */             
/*     */             public void remove() {
/*  91 */               Object[] currentPlayers = players;
/*  92 */               int i = this.ret;
/*  93 */               if (i < 0 || currentPlayers[i] == null) {
/*  94 */                 throw new IllegalStateException();
/*     */               }
/*  96 */               currentPlayers[i] = null;
/*     */             }
/*     */           };
/*     */       }
/*     */     };
/*     */     
/* 102 */     ServerListPingEvent event = new ServerListPingEvent();
/* 103 */     this.minecraftServer.server.getPluginManager().callEvent((Event)event);
/*     */     
/* 105 */     List<GameProfile> profiles = new ArrayList<GameProfile>(players.length);
/* 106 */     for (Object player : players) {
/* 107 */       if (player != null) {
/* 108 */         profiles.add(((EntityPlayer)player).getProfile());
/*     */       }
/*     */     } 
/*     */     
/* 112 */     ServerPingPlayerSample playerSample = new ServerPingPlayerSample(event.getMaxPlayers(), profiles.size());
/* 113 */     playerSample.a(profiles.<GameProfile>toArray(new GameProfile[profiles.size()]));
/*     */     
/* 115 */     ServerPing ping = new ServerPing();
/* 116 */     ping.setFavicon(event.icon.value);
/* 117 */     ping.setMOTD(new ChatComponentText(event.getMotd()));
/* 118 */     ping.setPlayerSample(playerSample);
/* 119 */     ping.setServerInfo(new ServerPingServerData(this.minecraftServer.getServerModName() + " " + this.minecraftServer.getVersion(), 5));
/*     */     
/* 121 */     this.networkManager.handle(new PacketStatusOutServerInfo(ping), new net.minecraft.util.io.netty.util.concurrent.GenericFutureListener[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketStatusInPing packetstatusinping) {
/* 126 */     this.networkManager.handle(new PacketStatusOutPong(packetstatusinping.c()), new net.minecraft.util.io.netty.util.concurrent.GenericFutureListener[0]);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */