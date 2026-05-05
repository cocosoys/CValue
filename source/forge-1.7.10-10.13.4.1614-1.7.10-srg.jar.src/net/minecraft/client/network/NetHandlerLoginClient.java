/*     */ package net.minecraft.client.network;
/*     */ import com.mojang.authlib.exceptions.AuthenticationException;
/*     */ import com.mojang.authlib.minecraft.MinecraftSessionService;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.util.concurrent.Future;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.math.BigInteger;
/*     */ import java.security.PublicKey;
/*     */ import javax.crypto.SecretKey;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiDisconnected;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.network.EnumConnectionState;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.login.client.C01PacketEncryptionResponse;
/*     */ import net.minecraft.network.login.server.S00PacketDisconnect;
/*     */ import net.minecraft.network.login.server.S01PacketEncryptionRequest;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.CryptManager;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class NetHandlerLoginClient implements INetHandlerLoginClient {
/*  28 */   private static final Logger field_147396_a = LogManager.getLogger(); private final Minecraft field_147394_b;
/*     */   private final GuiScreen field_147395_c;
/*     */   private final NetworkManager field_147393_d;
/*     */   private static final String __OBFID = "CL_00000876";
/*     */   
/*     */   public NetHandlerLoginClient(NetworkManager p_i45059_1_, Minecraft p_i45059_2_, GuiScreen p_i45059_3_) {
/*  34 */     this.field_147393_d = p_i45059_1_;
/*  35 */     this.field_147394_b = p_i45059_2_;
/*  36 */     this.field_147395_c = p_i45059_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147389_a(S01PacketEncryptionRequest p_147389_1_) {
/*  41 */     SecretKey secretKey = CryptManager.func_75890_a();
/*  42 */     String str1 = p_147389_1_.func_149609_c();
/*  43 */     PublicKey publicKey = p_147389_1_.func_149608_d();
/*  44 */     String str2 = (new BigInteger(CryptManager.func_75895_a(str1, publicKey, secretKey))).toString(16);
/*     */     
/*  46 */     boolean bool = (this.field_147394_b.func_147104_D() == null || !this.field_147394_b.func_147104_D().func_152585_d()) ? true : false;
/*     */     try {
/*  48 */       func_147391_c().joinServer(this.field_147394_b.func_110432_I().func_148256_e(), this.field_147394_b.func_110432_I().func_148254_d(), str2);
/*  49 */     } catch (AuthenticationUnavailableException authenticationUnavailableException) {
/*  50 */       if (bool) {
/*  51 */         this.field_147393_d.func_150718_a((IChatComponent)new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[] { new ChatComponentTranslation("disconnect.loginFailedInfo.serversUnavailable", new Object[0]) }));
/*     */         return;
/*     */       } 
/*  54 */     } catch (InvalidCredentialsException invalidCredentialsException) {
/*  55 */       if (bool) {
/*  56 */         this.field_147393_d.func_150718_a((IChatComponent)new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[] { new ChatComponentTranslation("disconnect.loginFailedInfo.invalidSession", new Object[0]) }));
/*     */         return;
/*     */       } 
/*  59 */     } catch (AuthenticationException authenticationException) {
/*  60 */       if (bool) {
/*  61 */         this.field_147393_d.func_150718_a((IChatComponent)new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[] { authenticationException.getMessage() }));
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  66 */     this.field_147393_d.func_150725_a((Packet)new C01PacketEncryptionResponse(secretKey, publicKey, p_147389_1_.func_149607_e()), new GenericFutureListener[] { new GenericFutureListener(this, secretKey) { private static final String __OBFID = "CL_00000877";
/*     */             
/*     */             public void operationComplete(Future p_operationComplete_1_) {
/*  69 */               this.field_147494_b.field_147393_d.func_150727_a(this.field_147495_a);
/*     */             } }
/*     */            });
/*     */   }
/*     */   
/*     */   private MinecraftSessionService func_147391_c() {
/*  75 */     return (new YggdrasilAuthenticationService(this.field_147394_b.func_110437_J(), UUID.randomUUID().toString())).createMinecraftSessionService();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147390_a(S02PacketLoginSuccess p_147390_1_) {
/*  80 */     this.field_147393_d.func_150723_a(EnumConnectionState.PLAY);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147231_a(IChatComponent p_147231_1_) {
/*  85 */     this.field_147394_b.func_147108_a((GuiScreen)new GuiDisconnected(this.field_147395_c, "connect.failed", p_147231_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147232_a(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_) {
/*  90 */     field_147396_a.debug("Switching protocol from " + p_147232_1_ + " to " + p_147232_2_);
/*  91 */     if (p_147232_2_ == EnumConnectionState.PLAY) {
/*  92 */       this.field_147393_d.func_150719_a((INetHandler)new NetHandlerPlayClient(this.field_147394_b, this.field_147395_c, this.field_147393_d));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147233_a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147388_a(S00PacketDisconnect p_147388_1_) {
/* 108 */     this.field_147393_d.func_150718_a(p_147388_1_.func_149603_c());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\network\NetHandlerLoginClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */