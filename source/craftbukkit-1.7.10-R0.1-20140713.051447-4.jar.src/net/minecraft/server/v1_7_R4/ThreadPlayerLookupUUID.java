/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.math.BigInteger;
/*    */ import java.net.InetAddress;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.util.UUID;
/*    */ import java.util.logging.Level;
/*    */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*    */ import net.minecraft.util.com.mojang.authlib.exceptions.AuthenticationUnavailableException;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.util.Waitable;
/*    */ import org.bukkit.event.Event;
/*    */ import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
/*    */ import org.bukkit.event.player.PlayerPreLoginEvent;
/*    */ 
/*    */ class ThreadPlayerLookupUUID extends Thread {
/*    */   final LoginListener a;
/*    */   
/*    */   ThreadPlayerLookupUUID(LoginListener loginlistener, String s) {
/* 20 */     super(s);
/* 21 */     this.a = loginlistener;
/*    */   }
/*    */   
/*    */   public void run() {
/* 25 */     GameProfile gameprofile = LoginListener.a(this.a);
/*    */     
/*    */     try {
/* 28 */       String s = (new BigInteger(MinecraftEncryption.a(LoginListener.b(this.a), LoginListener.c(this.a).K().getPublic(), LoginListener.d(this.a)))).toString(16);
/*    */       
/* 30 */       LoginListener.a(this.a, LoginListener.c(this.a).av().hasJoinedServer(new GameProfile((UUID)null, gameprofile.getName()), s));
/* 31 */       if (LoginListener.a(this.a) != null) {
/*    */         
/* 33 */         if (!this.a.networkManager.isConnected()) {
/*    */           return;
/*    */         }
/*    */         
/* 37 */         String playerName = LoginListener.a(this.a).getName();
/* 38 */         InetAddress address = ((InetSocketAddress)this.a.networkManager.getSocketAddress()).getAddress();
/* 39 */         UUID uniqueId = LoginListener.a(this.a).getId();
/* 40 */         final CraftServer server = (LoginListener.c(this.a)).server;
/*    */         
/* 42 */         AsyncPlayerPreLoginEvent asyncEvent = new AsyncPlayerPreLoginEvent(playerName, address, uniqueId);
/* 43 */         server.getPluginManager().callEvent((Event)asyncEvent);
/*    */         
/* 45 */         if ((PlayerPreLoginEvent.getHandlerList().getRegisteredListeners()).length != 0) {
/* 46 */           final PlayerPreLoginEvent event = new PlayerPreLoginEvent(playerName, address, uniqueId);
/* 47 */           if (asyncEvent.getResult() != PlayerPreLoginEvent.Result.ALLOWED) {
/* 48 */             event.disallow(asyncEvent.getResult(), asyncEvent.getKickMessage());
/*    */           }
/* 50 */           Waitable<PlayerPreLoginEvent.Result> waitable = new Waitable<PlayerPreLoginEvent.Result>()
/*    */             {
/*    */               protected PlayerPreLoginEvent.Result evaluate() {
/* 53 */                 server.getPluginManager().callEvent((Event)event);
/* 54 */                 return event.getResult();
/*    */               }
/*    */             };
/* 57 */           (LoginListener.c(this.a)).processQueue.add(waitable);
/* 58 */           if (waitable.get() != PlayerPreLoginEvent.Result.ALLOWED) {
/* 59 */             this.a.disconnect(event.getKickMessage());
/*    */             
/*    */             return;
/*    */           } 
/* 63 */         } else if (asyncEvent.getLoginResult() != AsyncPlayerPreLoginEvent.Result.ALLOWED) {
/* 64 */           this.a.disconnect(asyncEvent.getKickMessage());
/*    */ 
/*    */           
/*    */           return;
/*    */         } 
/*    */         
/* 70 */         LoginListener.e().info("UUID of player " + LoginListener.a(this.a).getName() + " is " + LoginListener.a(this.a).getId());
/* 71 */         LoginListener.a(this.a, EnumProtocolState.READY_TO_ACCEPT);
/* 72 */       } else if (LoginListener.c(this.a).N()) {
/* 73 */         LoginListener.e().warn("Failed to verify username but will let them in anyway!");
/* 74 */         LoginListener.a(this.a, this.a.a(gameprofile));
/* 75 */         LoginListener.a(this.a, EnumProtocolState.READY_TO_ACCEPT);
/*    */       } else {
/* 77 */         this.a.disconnect("Failed to verify username!");
/* 78 */         LoginListener.e().error("Username '" + LoginListener.a(this.a).getName() + "' tried to join with an invalid session");
/*    */       } 
/* 80 */     } catch (AuthenticationUnavailableException authenticationunavailableexception) {
/* 81 */       if (LoginListener.c(this.a).N()) {
/* 82 */         LoginListener.e().warn("Authentication servers are down but will let them in anyway!");
/* 83 */         LoginListener.a(this.a, this.a.a(gameprofile));
/* 84 */         LoginListener.a(this.a, EnumProtocolState.READY_TO_ACCEPT);
/*    */       } else {
/* 86 */         this.a.disconnect("Authentication servers are down. Please try again later, sorry!");
/* 87 */         LoginListener.e().error("Couldn't verify username because servers are unavailable");
/*    */       }
/*    */     
/* 90 */     } catch (Exception exception) {
/* 91 */       this.a.disconnect("Failed to verify username!");
/* 92 */       (LoginListener.c(this.a)).server.getLogger().log(Level.WARNING, "Exception verifying " + LoginListener.a(this.a).getName(), exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ThreadPlayerLookupUUID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */