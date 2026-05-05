/*     */ package net.minecraft.client.multiplayer;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.DatagramSocket;
/*     */ import java.net.InetAddress;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ThreadLanServerPing extends Thread {
/*  14 */   private static final AtomicInteger field_148658_a = new AtomicInteger(0);
/*  15 */   private static final Logger field_148657_b = LogManager.getLogger();
/*     */   
/*     */   private final String field_77528_b;
/*     */   
/*     */   private final DatagramSocket field_77529_c;
/*     */   
/*     */   private boolean field_77526_d = true;
/*     */   
/*     */   private final String field_77527_e;
/*     */   private static final String __OBFID = "CL_00001137";
/*     */   
/*     */   public ThreadLanServerPing(String p_i1321_1_, String p_i1321_2_) throws IOException {
/*  27 */     super("LanServerPinger #" + field_148658_a.incrementAndGet());
/*  28 */     this.field_77528_b = p_i1321_1_;
/*  29 */     this.field_77527_e = p_i1321_2_;
/*  30 */     setDaemon(true);
/*     */     
/*  32 */     this.field_77529_c = new DatagramSocket();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  38 */     String str = func_77525_a(this.field_77528_b, this.field_77527_e);
/*  39 */     byte[] arrayOfByte = str.getBytes();
/*     */     
/*  41 */     while (!isInterrupted() && this.field_77526_d) {
/*     */       
/*     */       try {
/*  44 */         InetAddress inetAddress = InetAddress.getByName("224.0.2.60");
/*     */         
/*  46 */         DatagramPacket datagramPacket = new DatagramPacket(arrayOfByte, arrayOfByte.length, inetAddress, 4445);
/*  47 */         this.field_77529_c.send(datagramPacket);
/*  48 */       } catch (IOException iOException) {
/*  49 */         field_148657_b.warn("LanServerPinger: " + iOException.getMessage());
/*     */         
/*     */         break;
/*     */       } 
/*     */       try {
/*  54 */         sleep(1500L);
/*  55 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void interrupt() {
/*  62 */     super.interrupt();
/*     */ 
/*     */     
/*  65 */     this.field_77526_d = false;
/*     */   }
/*     */   
/*     */   public static String func_77525_a(String p_77525_0_, String p_77525_1_) {
/*  69 */     return "[MOTD]" + p_77525_0_ + "[/MOTD][AD]" + p_77525_1_ + "[/AD]";
/*     */   }
/*     */   
/*     */   public static String func_77524_a(String p_77524_0_) {
/*  73 */     int i = p_77524_0_.indexOf("[MOTD]");
/*  74 */     if (i < 0) {
/*  75 */       return "missing no";
/*     */     }
/*  77 */     int j = p_77524_0_.indexOf("[/MOTD]", i + "[MOTD]".length());
/*  78 */     if (j < i) {
/*  79 */       return "missing no";
/*     */     }
/*  81 */     return p_77524_0_.substring(i + "[MOTD]".length(), j);
/*     */   }
/*     */   
/*     */   public static String func_77523_b(String p_77523_0_) {
/*  85 */     int i = p_77523_0_.indexOf("[/MOTD]");
/*  86 */     if (i < 0) {
/*  87 */       return null;
/*     */     }
/*     */     
/*  90 */     int j = p_77523_0_.indexOf("[/MOTD]", i + "[/MOTD]".length());
/*  91 */     if (j >= 0)
/*     */     {
/*  93 */       return null;
/*     */     }
/*     */     
/*  96 */     int k = p_77523_0_.indexOf("[AD]", i + "[/MOTD]".length());
/*  97 */     if (k < 0) {
/*  98 */       return null;
/*     */     }
/* 100 */     int m = p_77523_0_.indexOf("[/AD]", k + "[AD]".length());
/* 101 */     if (m < k) {
/* 102 */       return null;
/*     */     }
/* 104 */     return p_77523_0_.substring(k + "[AD]".length(), m);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\multiplayer\ThreadLanServerPing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */