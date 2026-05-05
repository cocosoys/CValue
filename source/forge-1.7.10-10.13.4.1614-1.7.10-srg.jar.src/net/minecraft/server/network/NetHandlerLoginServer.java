/*     */ package net.minecraft.server.network;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
/*     */ import java.math.BigInteger;
/*     */ import java.security.PrivateKey;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import javax.crypto.SecretKey;
/*     */ import net.minecraft.network.EnumConnectionState;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.login.INetHandlerLoginServer;
/*     */ import net.minecraft.network.login.client.C00PacketLoginStart;
/*     */ import net.minecraft.network.login.client.C01PacketEncryptionResponse;
/*     */ import net.minecraft.network.login.server.S00PacketDisconnect;
/*     */ import net.minecraft.network.login.server.S01PacketEncryptionRequest;
/*     */ import net.minecraft.network.login.server.S02PacketLoginSuccess;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.CryptManager;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class NetHandlerLoginServer implements INetHandlerLoginServer {
/*  29 */   private static final AtomicInteger field_147331_b = new AtomicInteger(0);
/*  30 */   private static final Logger field_147332_c = LogManager.getLogger();
/*     */   
/*  32 */   private static final Random field_147329_d = new Random();
/*     */   
/*  34 */   private final byte[] field_147330_e = new byte[4];
/*     */   private final MinecraftServer field_147327_f;
/*     */   public final NetworkManager field_147333_a;
/*  37 */   private LoginState field_147328_g = LoginState.HELLO;
/*     */   private int field_147336_h;
/*     */   private GameProfile field_147337_i;
/*  40 */   private String field_147334_j = ""; private SecretKey field_147335_k;
/*     */   private static final String __OBFID = "CL_00001458";
/*     */   
/*     */   public NetHandlerLoginServer(MinecraftServer p_i45298_1_, NetworkManager p_i45298_2_) {
/*  44 */     this.field_147327_f = p_i45298_1_;
/*  45 */     this.field_147333_a = p_i45298_2_;
/*  46 */     field_147329_d.nextBytes(this.field_147330_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147233_a() {
/*  51 */     if (this.field_147328_g == LoginState.READY_TO_ACCEPT) {
/*  52 */       func_147326_c();
/*     */     }
/*  54 */     if (this.field_147336_h++ == 600) {
/*  55 */       func_147322_a("Took too long to log in");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147322_a(String p_147322_1_) {
/*     */     try {
/*  66 */       field_147332_c.info("Disconnecting " + func_147317_d() + ": " + p_147322_1_);
/*  67 */       ChatComponentText chatComponentText = new ChatComponentText(p_147322_1_);
/*  68 */       this.field_147333_a.func_150725_a((Packet)new S00PacketDisconnect((IChatComponent)chatComponentText), new io.netty.util.concurrent.GenericFutureListener[0]);
/*  69 */       this.field_147333_a.func_150718_a((IChatComponent)chatComponentText);
/*  70 */     } catch (Exception exception) {
/*  71 */       field_147332_c.error("Error whilst disconnecting player", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147326_c() {
/*  76 */     if (!this.field_147337_i.isComplete()) {
/*  77 */       this.field_147337_i = func_152506_a(this.field_147337_i);
/*     */     }
/*     */     
/*  80 */     String str = this.field_147327_f.func_71203_ab().func_148542_a(this.field_147333_a.func_74430_c(), this.field_147337_i);
/*  81 */     if (str != null) {
/*  82 */       func_147322_a(str);
/*     */     } else {
/*  84 */       this.field_147328_g = LoginState.ACCEPTED;
/*  85 */       this.field_147333_a.func_150725_a((Packet)new S02PacketLoginSuccess(this.field_147337_i), new io.netty.util.concurrent.GenericFutureListener[0]);
/*  86 */       this.field_147327_f.func_71203_ab().func_72355_a(this.field_147333_a, this.field_147327_f.func_71203_ab().func_148545_a(this.field_147337_i));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147231_a(IChatComponent p_147231_1_) {
/*  92 */     field_147332_c.info(func_147317_d() + " lost connection: " + p_147231_1_.func_150260_c());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_147317_d() {
/* 100 */     if (this.field_147337_i != null) return this.field_147337_i.toString() + " (" + this.field_147333_a.func_74430_c().toString() + ")"; 
/* 101 */     return String.valueOf(this.field_147333_a.func_74430_c());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147232_a(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_) {
/* 106 */     Validate.validState((this.field_147328_g == LoginState.ACCEPTED || this.field_147328_g == LoginState.HELLO), "Unexpected change in protocol", new Object[0]);
/* 107 */     Validate.validState((p_147232_2_ == EnumConnectionState.PLAY || p_147232_2_ == EnumConnectionState.LOGIN), "Unexpected protocol " + p_147232_2_, new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147316_a(C00PacketLoginStart p_147316_1_) {
/* 112 */     Validate.validState((this.field_147328_g == LoginState.HELLO), "Unexpected hello packet", new Object[0]);
/* 113 */     this.field_147337_i = p_147316_1_.func_149304_c();
/*     */     
/* 115 */     if (this.field_147327_f.func_71266_T() && !this.field_147333_a.func_150731_c()) {
/* 116 */       this.field_147328_g = LoginState.KEY;
/* 117 */       this.field_147333_a.func_150725_a((Packet)new S01PacketEncryptionRequest(this.field_147334_j, this.field_147327_f.func_71250_E().getPublic(), this.field_147330_e), new io.netty.util.concurrent.GenericFutureListener[0]);
/*     */     } else {
/* 119 */       this.field_147328_g = LoginState.READY_TO_ACCEPT;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147315_a(C01PacketEncryptionResponse p_147315_1_) {
/* 125 */     Validate.validState((this.field_147328_g == LoginState.KEY), "Unexpected key packet", new Object[0]);
/* 126 */     PrivateKey privateKey = this.field_147327_f.func_71250_E().getPrivate();
/*     */     
/* 128 */     if (!Arrays.equals(this.field_147330_e, p_147315_1_.func_149299_b(privateKey))) {
/* 129 */       throw new IllegalStateException("Invalid nonce!");
/*     */     }
/*     */     
/* 132 */     this.field_147335_k = p_147315_1_.func_149300_a(privateKey);
/* 133 */     this.field_147328_g = LoginState.AUTHENTICATING;
/*     */     
/* 135 */     this.field_147333_a.func_150727_a(this.field_147335_k);
/*     */     
/* 137 */     (new Thread(this, "User Authenticator #" + field_147331_b.incrementAndGet()) { private static final String __OBFID = "CL_00001459";
/*     */         
/*     */         public void run() {
/* 140 */           GameProfile gameProfile = this.field_151292_a.field_147337_i;
/*     */           
/*     */           try {
/* 143 */             String str = (new BigInteger(CryptManager.func_75895_a(this.field_151292_a.field_147334_j, this.field_151292_a.field_147327_f.func_71250_E().getPublic(), this.field_151292_a.field_147335_k))).toString(16);
/* 144 */             this.field_151292_a.field_147337_i = this.field_151292_a.field_147327_f.func_147130_as().hasJoinedServer(new GameProfile(null, gameProfile.getName()), str);
/*     */             
/* 146 */             if (this.field_151292_a.field_147337_i != null) {
/* 147 */               NetHandlerLoginServer.field_147332_c.info("UUID of player " + this.field_151292_a.field_147337_i.getName() + " is " + this.field_151292_a.field_147337_i.getId());
/* 148 */               this.field_151292_a.field_147328_g = NetHandlerLoginServer.LoginState.READY_TO_ACCEPT;
/* 149 */             } else if (this.field_151292_a.field_147327_f.func_71264_H()) {
/* 150 */               NetHandlerLoginServer.field_147332_c.warn("Failed to verify username but will let them in anyway!");
/* 151 */               this.field_151292_a.field_147337_i = this.field_151292_a.func_152506_a(gameProfile);
/* 152 */               this.field_151292_a.field_147328_g = NetHandlerLoginServer.LoginState.READY_TO_ACCEPT;
/*     */             } else {
/* 154 */               this.field_151292_a.func_147322_a("Failed to verify username!");
/* 155 */               NetHandlerLoginServer.field_147332_c.error("Username '" + this.field_151292_a.field_147337_i.getName() + "' tried to join with an invalid session");
/*     */             } 
/* 157 */           } catch (AuthenticationUnavailableException authenticationUnavailableException) {
/* 158 */             if (this.field_151292_a.field_147327_f.func_71264_H()) {
/* 159 */               NetHandlerLoginServer.field_147332_c.warn("Authentication servers are down but will let them in anyway!");
/* 160 */               this.field_151292_a.field_147337_i = this.field_151292_a.func_152506_a(gameProfile);
/* 161 */               this.field_151292_a.field_147328_g = NetHandlerLoginServer.LoginState.READY_TO_ACCEPT;
/*     */             } else {
/* 163 */               this.field_151292_a.func_147322_a("Authentication servers are down. Please try again later, sorry!");
/* 164 */               NetHandlerLoginServer.field_147332_c.error("Couldn't verify username because servers are unavailable");
/*     */             } 
/*     */           } 
/*     */         } }
/*     */       ).start();
/*     */   }
/*     */   
/*     */   protected GameProfile func_152506_a(GameProfile p_152506_1_) {
/* 172 */     UUID uUID = UUID.nameUUIDFromBytes(("OfflinePlayer:" + p_152506_1_.getName()).getBytes(Charsets.UTF_8));
/* 173 */     return new GameProfile(uUID, p_152506_1_.getName());
/*     */   }
/*     */   
/*     */   enum LoginState {
/* 177 */     HELLO, KEY, AUTHENTICATING, READY_TO_ACCEPT, ACCEPTED;
/*     */     private static final String __OBFID = "CL_00001463";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\network\NetHandlerLoginServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */