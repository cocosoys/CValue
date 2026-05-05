/*     */ package net.minecraft.client.multiplayer;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiDisconnected;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiConnecting extends GuiScreen {
/*  19 */   private static final AtomicInteger field_146372_a = new AtomicInteger(0);
/*  20 */   private static final Logger field_146370_f = LogManager.getLogger();
/*     */   private NetworkManager field_146371_g;
/*     */   private boolean field_146373_h;
/*     */   private final GuiScreen field_146374_i;
/*     */   private static final String __OBFID = "CL_00000685";
/*     */   
/*     */   public GuiConnecting(GuiScreen p_i1181_1_, Minecraft p_i1181_2_, ServerData p_i1181_3_) {
/*  27 */     this.field_146297_k = p_i1181_2_;
/*  28 */     this.field_146374_i = p_i1181_1_;
/*  29 */     ServerAddress serverAddress = ServerAddress.func_78860_a(p_i1181_3_.field_78845_b);
/*     */     
/*  31 */     p_i1181_2_.func_71403_a(null);
/*  32 */     p_i1181_2_.func_71351_a(p_i1181_3_);
/*  33 */     func_146367_a(serverAddress.func_78861_a(), serverAddress.func_78864_b());
/*     */   }
/*     */   
/*     */   public GuiConnecting(GuiScreen p_i1182_1_, Minecraft p_i1182_2_, String p_i1182_3_, int p_i1182_4_) {
/*  37 */     this.field_146297_k = p_i1182_2_;
/*  38 */     this.field_146374_i = p_i1182_1_;
/*  39 */     p_i1182_2_.func_71403_a(null);
/*  40 */     func_146367_a(p_i1182_3_, p_i1182_4_);
/*     */   }
/*     */   
/*     */   private void func_146367_a(String p_146367_1_, int p_146367_2_) {
/*  44 */     field_146370_f.info("Connecting to " + p_146367_1_ + ", " + p_146367_2_);
/*  45 */     (new Thread(this, "Server Connector #" + field_146372_a.incrementAndGet(), p_146367_1_, p_146367_2_) { private static final String __OBFID = "CL_00000686";
/*     */         
/*     */         public void run() {
/*  48 */           InetAddress inetAddress = null;
/*     */           try {
/*  50 */             if (this.field_148230_c.field_146373_h)
/*  51 */               return;  inetAddress = InetAddress.getByName(this.field_148231_a);
/*  52 */             this.field_148230_c.field_146371_g = NetworkManager.func_150726_a(inetAddress, this.field_148229_b);
/*  53 */             this.field_148230_c.field_146371_g.func_150719_a((INetHandler)new NetHandlerLoginClient(this.field_148230_c.field_146371_g, this.field_148230_c.field_146297_k, this.field_148230_c.field_146374_i));
/*  54 */             this.field_148230_c.field_146371_g.func_150725_a((Packet)new C00Handshake(5, this.field_148231_a, this.field_148229_b, EnumConnectionState.LOGIN), new io.netty.util.concurrent.GenericFutureListener[0]);
/*  55 */             this.field_148230_c.field_146371_g.func_150725_a((Packet)new C00PacketLoginStart(this.field_148230_c.field_146297_k.func_110432_I().func_148256_e()), new io.netty.util.concurrent.GenericFutureListener[0]);
/*  56 */           } catch (UnknownHostException unknownHostException) {
/*  57 */             if (this.field_148230_c.field_146373_h)
/*  58 */               return;  GuiConnecting.field_146370_f.error("Couldn't connect to server", unknownHostException);
/*  59 */             this.field_148230_c.field_146297_k.func_147108_a((GuiScreen)new GuiDisconnected(this.field_148230_c.field_146374_i, "connect.failed", (IChatComponent)new ChatComponentTranslation("disconnect.genericReason", new Object[] { "Unknown host" })));
/*  60 */           } catch (Exception exception) {
/*  61 */             if (this.field_148230_c.field_146373_h)
/*  62 */               return;  GuiConnecting.field_146370_f.error("Couldn't connect to server", exception);
/*  63 */             String str = exception.toString();
/*  64 */             if (inetAddress != null) {
/*  65 */               String str1 = inetAddress.toString() + ":" + this.field_148229_b;
/*  66 */               str = str.replaceAll(str1, "");
/*     */             } 
/*  68 */             this.field_148230_c.field_146297_k.func_147108_a((GuiScreen)new GuiDisconnected(this.field_148230_c.field_146374_i, "connect.failed", (IChatComponent)new ChatComponentTranslation("disconnect.genericReason", new Object[] { str })));
/*     */           } 
/*     */         } }
/*     */       ).start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  76 */     if (this.field_146371_g != null) {
/*  77 */       if (this.field_146371_g.func_150724_d()) {
/*  78 */         this.field_146371_g.func_74428_b();
/*  79 */       } else if (this.field_146371_g.func_150730_f() != null) {
/*  80 */         this.field_146371_g.func_150729_e().func_147231_a(this.field_146371_g.func_150730_f());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  92 */     this.field_146292_n.clear();
/*  93 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 2 + 50, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  98 */     if (p_146284_1_.field_146127_k == 0) {
/*  99 */       this.field_146373_h = true;
/* 100 */       if (this.field_146371_g != null) this.field_146371_g.func_150718_a((IChatComponent)new ChatComponentText("Aborted")); 
/* 101 */       this.field_146297_k.func_147108_a(this.field_146374_i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 107 */     func_146276_q_();
/*     */     
/* 109 */     if (this.field_146371_g == null) {
/* 110 */       func_73732_a(this.field_146289_q, I18n.func_135052_a("connect.connecting", new Object[0]), this.field_146294_l / 2, this.field_146295_m / 2 - 50, 16777215);
/*     */     } else {
/* 112 */       func_73732_a(this.field_146289_q, I18n.func_135052_a("connect.authorizing", new Object[0]), this.field_146294_l / 2, this.field_146295_m / 2 - 50, 16777215);
/*     */     } 
/*     */     
/* 115 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\multiplayer\GuiConnecting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */