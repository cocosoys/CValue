/*     */ package net.minecraft.network.rcon;
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramSocket;
/*     */ import java.net.ServerSocket;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ 
/*     */ @SideOnly(Side.SERVER)
/*     */ public abstract class RConThreadBase implements Runnable {
/*  11 */   private static final AtomicInteger field_164004_h = new AtomicInteger(0);
/*     */   protected boolean field_72619_a;
/*     */   protected IServer field_72617_b;
/*     */   protected final String field_164003_c;
/*     */   protected Thread field_72618_c;
/*  16 */   protected int field_72615_d = 5;
/*  17 */   protected List field_72616_e = new ArrayList();
/*  18 */   protected List field_72614_f = new ArrayList(); private static final String __OBFID = "CL_00001801";
/*     */   
/*     */   protected RConThreadBase(IServer p_i45300_1_, String p_i45300_2_) {
/*  21 */     this.field_72617_b = p_i45300_1_;
/*  22 */     this.field_164003_c = p_i45300_2_;
/*  23 */     if (this.field_72617_b.func_71239_B()) {
/*  24 */       func_72606_c("Debugging is enabled, performance maybe reduced!");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void func_72602_a() {
/*  32 */     this.field_72618_c = new Thread(this, this.field_164003_c + " #" + field_164004_h.incrementAndGet());
/*  33 */     this.field_72618_c.start();
/*  34 */     this.field_72619_a = true;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_72613_c() {
/*  73 */     return this.field_72619_a;
/*     */   }
/*     */   
/*     */   protected void func_72607_a(String p_72607_1_) {
/*  77 */     this.field_72617_b.func_71198_k(p_72607_1_);
/*     */   }
/*     */   
/*     */   protected void func_72609_b(String p_72609_1_) {
/*  81 */     this.field_72617_b.func_71244_g(p_72609_1_);
/*     */   }
/*     */   
/*     */   protected void func_72606_c(String p_72606_1_) {
/*  85 */     this.field_72617_b.func_71236_h(p_72606_1_);
/*     */   }
/*     */   
/*     */   protected void func_72610_d(String p_72610_1_) {
/*  89 */     this.field_72617_b.func_71201_j(p_72610_1_);
/*     */   }
/*     */   
/*     */   protected int func_72603_d() {
/*  93 */     return this.field_72617_b.func_71233_x();
/*     */   }
/*     */   
/*     */   protected void func_72601_a(DatagramSocket p_72601_1_) {
/*  97 */     func_72607_a("registerSocket: " + p_72601_1_);
/*  98 */     this.field_72616_e.add(p_72601_1_);
/*     */   }
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
/*     */   protected boolean func_72604_a(DatagramSocket p_72604_1_, boolean p_72604_2_) {
/* 111 */     func_72607_a("closeSocket: " + p_72604_1_);
/* 112 */     if (null == p_72604_1_) {
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     boolean bool = false;
/* 117 */     if (!p_72604_1_.isClosed()) {
/* 118 */       p_72604_1_.close();
/* 119 */       bool = true;
/*     */     } 
/*     */     
/* 122 */     if (p_72604_2_) {
/* 123 */       this.field_72616_e.remove(p_72604_1_);
/*     */     }
/*     */     
/* 126 */     return bool;
/*     */   }
/*     */   
/*     */   protected boolean func_72608_b(ServerSocket p_72608_1_) {
/* 130 */     return func_72605_a(p_72608_1_, true);
/*     */   }
/*     */   
/*     */   protected boolean func_72605_a(ServerSocket p_72605_1_, boolean p_72605_2_) {
/* 134 */     func_72607_a("closeSocket: " + p_72605_1_);
/* 135 */     if (null == p_72605_1_) {
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     boolean bool = false;
/*     */     try {
/* 141 */       if (!p_72605_1_.isClosed()) {
/* 142 */         p_72605_1_.close();
/* 143 */         bool = true;
/*     */       } 
/* 145 */     } catch (IOException iOException) {
/* 146 */       func_72606_c("IO: " + iOException.getMessage());
/*     */     } 
/*     */     
/* 149 */     if (p_72605_2_) {
/* 150 */       this.field_72614_f.remove(p_72605_1_);
/*     */     }
/*     */     
/* 153 */     return bool;
/*     */   }
/*     */   
/*     */   protected void func_72611_e() {
/* 157 */     func_72612_a(false);
/*     */   }
/*     */   
/*     */   protected void func_72612_a(boolean p_72612_1_) {
/* 161 */     byte b = 0;
/* 162 */     for (DatagramSocket datagramSocket : this.field_72616_e) {
/* 163 */       if (func_72604_a(datagramSocket, false)) {
/* 164 */         b++;
/*     */       }
/*     */     } 
/* 167 */     this.field_72616_e.clear();
/*     */     
/* 169 */     for (ServerSocket serverSocket : this.field_72614_f) {
/* 170 */       if (func_72605_a(serverSocket, false)) {
/* 171 */         b++;
/*     */       }
/*     */     } 
/* 174 */     this.field_72614_f.clear();
/*     */     
/* 176 */     if (p_72612_1_ && 0 < b)
/* 177 */       func_72606_c("Force closed " + b + " sockets"); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\rcon\RConThreadBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */