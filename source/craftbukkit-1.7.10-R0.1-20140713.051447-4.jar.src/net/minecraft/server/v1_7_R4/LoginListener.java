/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.security.PrivateKey;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import javax.crypto.SecretKey;
/*     */ import net.minecraft.util.com.google.common.base.Charsets;
/*     */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*     */ import net.minecraft.util.org.apache.commons.lang3.Validate;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class LoginListener
/*     */   implements PacketLoginInListener
/*     */ {
/*  19 */   private static final AtomicInteger b = new AtomicInteger(0);
/*  20 */   private static final Logger c = LogManager.getLogger();
/*  21 */   private static final Random random = new Random();
/*  22 */   private final byte[] e = new byte[4];
/*     */   private final MinecraftServer server;
/*     */   public final NetworkManager networkManager;
/*     */   private EnumProtocolState g;
/*     */   private int h;
/*     */   private GameProfile i;
/*     */   private String j;
/*     */   private SecretKey loginKey;
/*  30 */   public String hostname = "";
/*     */   
/*     */   public LoginListener(MinecraftServer minecraftserver, NetworkManager networkmanager) {
/*  33 */     this.g = EnumProtocolState.HELLO;
/*  34 */     this.j = "";
/*  35 */     this.server = minecraftserver;
/*  36 */     this.networkManager = networkmanager;
/*  37 */     random.nextBytes(this.e);
/*     */   }
/*     */   
/*     */   public void a() {
/*  41 */     if (this.g == EnumProtocolState.READY_TO_ACCEPT) {
/*  42 */       c();
/*     */     }
/*     */     
/*  45 */     if (this.h++ == 600) {
/*  46 */       disconnect("Took too long to log in");
/*     */     }
/*     */   }
/*     */   
/*     */   public void disconnect(String s) {
/*     */     try {
/*  52 */       c.info("Disconnecting " + getName() + ": " + s);
/*  53 */       ChatComponentText chatcomponenttext = new ChatComponentText(s);
/*     */       
/*  55 */       this.networkManager.handle(new PacketLoginOutDisconnect(chatcomponenttext), new net.minecraft.util.io.netty.util.concurrent.GenericFutureListener[0]);
/*  56 */       this.networkManager.close(chatcomponenttext);
/*  57 */     } catch (Exception exception) {
/*  58 */       c.error("Error whilst disconnecting player", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void c() {
/*  63 */     if (!this.i.isComplete()) {
/*  64 */       this.i = a(this.i);
/*     */     }
/*     */ 
/*     */     
/*  68 */     EntityPlayer s = this.server.getPlayerList().attemptLogin(this, this.i, this.hostname);
/*     */     
/*  70 */     if (s != null) {
/*     */ 
/*     */ 
/*     */       
/*  74 */       this.g = EnumProtocolState.e;
/*  75 */       this.networkManager.handle(new PacketLoginOutSuccess(this.i), new net.minecraft.util.io.netty.util.concurrent.GenericFutureListener[0]);
/*  76 */       this.server.getPlayerList().a(this.networkManager, this.server.getPlayerList().processLogin(this.i, s));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(IChatBaseComponent ichatbasecomponent) {
/*  81 */     c.info(getName() + " lost connection: " + ichatbasecomponent.c());
/*     */   }
/*     */   
/*     */   public String getName() {
/*  85 */     return (this.i != null) ? (this.i.toString() + " (" + this.networkManager.getSocketAddress().toString() + ")") : String.valueOf(this.networkManager.getSocketAddress());
/*     */   }
/*     */   
/*     */   public void a(EnumProtocol enumprotocol, EnumProtocol enumprotocol1) {
/*  89 */     Validate.validState((this.g == EnumProtocolState.e || this.g == EnumProtocolState.HELLO), "Unexpected change in protocol", new Object[0]);
/*  90 */     Validate.validState((enumprotocol1 == EnumProtocol.PLAY || enumprotocol1 == EnumProtocol.LOGIN), "Unexpected protocol " + enumprotocol1, new Object[0]);
/*     */   }
/*     */   
/*     */   public void a(PacketLoginInStart packetlogininstart) {
/*  94 */     Validate.validState((this.g == EnumProtocolState.HELLO), "Unexpected hello packet", new Object[0]);
/*  95 */     this.i = packetlogininstart.c();
/*  96 */     if (this.server.getOnlineMode() && !this.networkManager.c()) {
/*  97 */       this.g = EnumProtocolState.KEY;
/*  98 */       this.networkManager.handle(new PacketLoginOutEncryptionBegin(this.j, this.server.K().getPublic(), this.e), new net.minecraft.util.io.netty.util.concurrent.GenericFutureListener[0]);
/*     */     } else {
/* 100 */       this.g = EnumProtocolState.READY_TO_ACCEPT;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(PacketLoginInEncryptionBegin packetlogininencryptionbegin) {
/* 105 */     Validate.validState((this.g == EnumProtocolState.KEY), "Unexpected key packet", new Object[0]);
/* 106 */     PrivateKey privatekey = this.server.K().getPrivate();
/*     */     
/* 108 */     if (!Arrays.equals(this.e, packetlogininencryptionbegin.b(privatekey))) {
/* 109 */       throw new IllegalStateException("Invalid nonce!");
/*     */     }
/* 111 */     this.loginKey = packetlogininencryptionbegin.a(privatekey);
/* 112 */     this.g = EnumProtocolState.AUTHENTICATING;
/* 113 */     this.networkManager.a(this.loginKey);
/* 114 */     (new ThreadPlayerLookupUUID(this, "User Authenticator #" + b.incrementAndGet())).start();
/*     */   }
/*     */ 
/*     */   
/*     */   protected GameProfile a(GameProfile gameprofile) {
/* 119 */     UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + gameprofile.getName()).getBytes(Charsets.UTF_8));
/*     */     
/* 121 */     return new GameProfile(uuid, gameprofile.getName());
/*     */   }
/*     */   
/*     */   static GameProfile a(LoginListener loginlistener) {
/* 125 */     return loginlistener.i;
/*     */   }
/*     */   
/*     */   static String b(LoginListener loginlistener) {
/* 129 */     return loginlistener.j;
/*     */   }
/*     */   
/*     */   static MinecraftServer c(LoginListener loginlistener) {
/* 133 */     return loginlistener.server;
/*     */   }
/*     */   
/*     */   static SecretKey d(LoginListener loginlistener) {
/* 137 */     return loginlistener.loginKey;
/*     */   }
/*     */   
/*     */   static GameProfile a(LoginListener loginlistener, GameProfile gameprofile) {
/* 141 */     return loginlistener.i = gameprofile;
/*     */   }
/*     */   
/*     */   static Logger e() {
/* 145 */     return c;
/*     */   }
/*     */   
/*     */   static EnumProtocolState a(LoginListener loginlistener, EnumProtocolState enumprotocolstate) {
/* 149 */     return loginlistener.g = enumprotocolstate;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\LoginListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */