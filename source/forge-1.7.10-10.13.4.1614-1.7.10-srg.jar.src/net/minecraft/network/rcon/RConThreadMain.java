/*     */ package net.minecraft.network.rcon;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.SERVER)
/*     */ public class RConThreadMain
/*     */   extends RConThreadBase
/*     */ {
/*     */   private int field_72647_g;
/*     */   private int field_72651_h;
/*     */   private String field_72652_i;
/*     */   
/*     */   public RConThreadMain(IServer p_i1538_1_) {
/*  24 */     super(p_i1538_1_, "RCON Listener");
/*  25 */     this.field_72647_g = p_i1538_1_.func_71327_a("rcon.port", 0);
/*  26 */     this.field_72650_k = p_i1538_1_.func_71330_a("rcon.password", "");
/*  27 */     this.field_72652_i = p_i1538_1_.func_71277_t();
/*  28 */     this.field_72651_h = p_i1538_1_.func_71234_u();
/*  29 */     if (0 == this.field_72647_g) {
/*     */       
/*  31 */       this.field_72647_g = this.field_72651_h + 10;
/*  32 */       func_72609_b("Setting default rcon port to " + this.field_72647_g);
/*  33 */       p_i1538_1_.func_71328_a("rcon.port", Integer.valueOf(this.field_72647_g));
/*  34 */       if (0 == this.field_72650_k.length()) {
/*  35 */         p_i1538_1_.func_71328_a("rcon.password", "");
/*     */       }
/*  37 */       p_i1538_1_.func_71326_a();
/*     */     } 
/*     */     
/*  40 */     if (0 == this.field_72652_i.length()) {
/*  41 */       this.field_72652_i = "0.0.0.0";
/*     */     }
/*     */     
/*  44 */     func_72646_f();
/*  45 */     this.field_72649_j = null;
/*     */   }
/*     */   private ServerSocket field_72649_j; private String field_72650_k; private Map field_72648_l; private static final String __OBFID = "CL_00001805";
/*     */   private void func_72646_f() {
/*  49 */     this.field_72648_l = new HashMap<Object, Object>();
/*     */   }
/*     */   
/*     */   private void func_72645_g() {
/*  53 */     Iterator<Map.Entry> iterator = this.field_72648_l.entrySet().iterator();
/*  54 */     while (iterator.hasNext()) {
/*  55 */       Map.Entry entry = iterator.next();
/*  56 */       if (!((RConThreadClient)entry.getValue()).func_72613_c()) {
/*  57 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  64 */     func_72609_b("RCON running on " + this.field_72652_i + ":" + this.field_72647_g);
/*     */     try {
/*  66 */       while (this.field_72619_a) {
/*     */         
/*     */         try {
/*  69 */           Socket socket = this.field_72649_j.accept();
/*  70 */           socket.setSoTimeout(500);
/*  71 */           RConThreadClient rConThreadClient = new RConThreadClient(this.field_72617_b, socket);
/*  72 */           rConThreadClient.func_72602_a();
/*  73 */           this.field_72648_l.put(socket.getRemoteSocketAddress(), rConThreadClient);
/*     */ 
/*     */           
/*  76 */           func_72645_g();
/*  77 */         } catch (SocketTimeoutException socketTimeoutException) {
/*     */           
/*  79 */           func_72645_g();
/*  80 */         } catch (IOException iOException) {
/*  81 */           if (this.field_72619_a) {
/*  82 */             func_72609_b("IO: " + iOException.getMessage());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } finally {
/*  87 */       func_72608_b(this.field_72649_j);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72602_a() {
/*  93 */     if (0 == this.field_72650_k.length()) {
/*  94 */       func_72606_c("No rcon password set in '" + this.field_72617_b.func_71329_c() + "', rcon disabled!");
/*     */       
/*     */       return;
/*     */     } 
/*  98 */     if (0 >= this.field_72647_g || 65535 < this.field_72647_g) {
/*  99 */       func_72606_c("Invalid rcon port " + this.field_72647_g + " found in '" + this.field_72617_b.func_71329_c() + "', rcon disabled!");
/*     */       
/*     */       return;
/*     */     } 
/* 103 */     if (this.field_72619_a) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 108 */       this.field_72649_j = new ServerSocket(this.field_72647_g, 0, InetAddress.getByName(this.field_72652_i));
/* 109 */       this.field_72649_j.setSoTimeout(500);
/* 110 */       super.func_72602_a();
/* 111 */     } catch (IOException iOException) {
/* 112 */       func_72606_c("Unable to initialise rcon on " + this.field_72652_i + ":" + this.field_72647_g + " : " + iOException.getMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\rcon\RConThreadMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */