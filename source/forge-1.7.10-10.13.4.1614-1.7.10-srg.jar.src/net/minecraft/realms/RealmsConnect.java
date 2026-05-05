/*    */ package net.minecraft.realms;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.net.InetAddress;
/*    */ import java.net.UnknownHostException;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.network.NetHandlerLoginClient;
/*    */ import net.minecraft.network.EnumConnectionState;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.login.client.C00PacketLoginStart;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RealmsConnect {
/* 19 */   private static final Logger LOGGER = LogManager.getLogger();
/*    */   private final RealmsScreen onlineScreen;
/*    */   private volatile boolean aborted = false;
/*    */   private NetworkManager connection;
/*    */   private static final String __OBFID = "CL_00001844";
/*    */   
/*    */   public RealmsConnect(RealmsScreen p_i1079_1_) {
/* 26 */     this.onlineScreen = p_i1079_1_;
/*    */   }
/*    */   
/*    */   public void connect(String p_connect_1_, int p_connect_2_) {
/* 30 */     (new Thread(this, "Realms-connect-task", p_connect_1_, p_connect_2_) { private static final String __OBFID = "CL_00001808";
/*    */         
/*    */         public void run() {
/* 33 */           InetAddress inetAddress = null;
/*    */           try {
/* 35 */             inetAddress = InetAddress.getByName(this.field_154355_a);
/* 36 */             if (this.field_154357_c.aborted)
/* 37 */               return;  this.field_154357_c.connection = NetworkManager.func_150726_a(inetAddress, this.field_154356_b);
/* 38 */             if (this.field_154357_c.aborted)
/* 39 */               return;  this.field_154357_c.connection.func_150719_a((INetHandler)new NetHandlerLoginClient(this.field_154357_c.connection, Minecraft.func_71410_x(), (GuiScreen)this.field_154357_c.onlineScreen.getProxy()));
/* 40 */             if (this.field_154357_c.aborted)
/* 41 */               return;  this.field_154357_c.connection.func_150725_a((Packet)new C00Handshake(5, this.field_154355_a, this.field_154356_b, EnumConnectionState.LOGIN), new io.netty.util.concurrent.GenericFutureListener[0]);
/* 42 */             if (this.field_154357_c.aborted)
/* 43 */               return;  this.field_154357_c.connection.func_150725_a((Packet)new C00PacketLoginStart(Minecraft.func_71410_x().func_110432_I().func_148256_e()), new io.netty.util.concurrent.GenericFutureListener[0]);
/* 44 */           } catch (UnknownHostException unknownHostException) {
/* 45 */             if (this.field_154357_c.aborted)
/* 46 */               return;  RealmsConnect.LOGGER.error("Couldn't connect to world", unknownHostException);
/* 47 */             Realms.setScreen(new DisconnectedOnlineScreen(this.field_154357_c.onlineScreen, "connect.failed", (IChatComponent)new ChatComponentTranslation("disconnect.genericReason", new Object[] { "Unknown host '" + this.field_154355_a + "'" })));
/* 48 */           } catch (Exception exception) {
/* 49 */             if (this.field_154357_c.aborted)
/* 50 */               return;  RealmsConnect.LOGGER.error("Couldn't connect to world", exception);
/* 51 */             String str = exception.toString();
/* 52 */             if (inetAddress != null) {
/* 53 */               String str1 = inetAddress.toString() + ":" + this.field_154356_b;
/* 54 */               str = str.replaceAll(str1, "");
/*    */             } 
/* 56 */             Realms.setScreen(new DisconnectedOnlineScreen(this.field_154357_c.onlineScreen, "connect.failed", (IChatComponent)new ChatComponentTranslation("disconnect.genericReason", new Object[] { str })));
/*    */           } 
/*    */         } }
/*    */       ).start();
/*    */   }
/*    */   
/*    */   public void abort() {
/* 63 */     this.aborted = true;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 67 */     if (this.connection != null)
/* 68 */       if (this.connection.func_150724_d()) {
/* 69 */         this.connection.func_74428_b();
/* 70 */       } else if (this.connection.func_150730_f() != null) {
/* 71 */         this.connection.func_150729_e().func_147231_a(this.connection.func_150730_f());
/*    */       }  
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsConnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */