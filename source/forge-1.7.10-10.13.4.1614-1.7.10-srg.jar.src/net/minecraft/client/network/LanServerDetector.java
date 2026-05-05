/*     */ package net.minecraft.client.network;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.InetAddress;
/*     */ import java.net.MulticastSocket;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class LanServerDetector {
/*  13 */   private static final AtomicInteger field_148551_a = new AtomicInteger(0);
/*  14 */   private static final Logger field_148550_b = LogManager.getLogger();
/*     */   private static final String __OBFID = "CL_00001133";
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  18 */   public static class LanServerList { private ArrayList field_77555_b = new ArrayList(); boolean field_77556_a;
/*     */     private static final String __OBFID = "CL_00001136";
/*     */     
/*     */     public synchronized boolean func_77553_a() {
/*  22 */       return this.field_77556_a;
/*     */     }
/*     */     
/*     */     public synchronized void func_77552_b() {
/*  26 */       this.field_77556_a = false;
/*     */     }
/*     */     
/*     */     public synchronized List func_77554_c() {
/*  30 */       return Collections.unmodifiableList(this.field_77555_b);
/*     */     }
/*     */     
/*     */     public synchronized void func_77551_a(String p_77551_1_, InetAddress p_77551_2_) {
/*  34 */       String str1 = ThreadLanServerPing.func_77524_a(p_77551_1_);
/*  35 */       String str2 = ThreadLanServerPing.func_77523_b(p_77551_1_);
/*  36 */       if (str2 == null) {
/*     */         return;
/*     */       }
/*     */       
/*  40 */       str2 = p_77551_2_.getHostAddress() + ":" + str2;
/*     */       
/*  42 */       boolean bool = false;
/*  43 */       for (LanServerDetector.LanServer lanServer : this.field_77555_b) {
/*  44 */         if (lanServer.func_77488_b().equals(str2)) {
/*  45 */           lanServer.func_77489_c();
/*  46 */           bool = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  51 */       if (!bool) {
/*  52 */         this.field_77555_b.add(new LanServerDetector.LanServer(str1, str2));
/*  53 */         this.field_77556_a = true;
/*     */       } 
/*     */     } }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static class LanServer { private String field_77492_a;
/*     */     private String field_77490_b;
/*     */     private long field_77491_c;
/*     */     private static final String __OBFID = "CL_00001134";
/*     */     
/*     */     public LanServer(String p_i1319_1_, String p_i1319_2_) {
/*  64 */       this.field_77492_a = p_i1319_1_;
/*  65 */       this.field_77490_b = p_i1319_2_;
/*  66 */       this.field_77491_c = Minecraft.func_71386_F();
/*     */     }
/*     */     
/*     */     public String func_77487_a() {
/*  70 */       return this.field_77492_a;
/*     */     }
/*     */     
/*     */     public String func_77488_b() {
/*  74 */       return this.field_77490_b;
/*     */     }
/*     */     
/*     */     public void func_77489_c() {
/*  78 */       this.field_77491_c = Minecraft.func_71386_F();
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static class ThreadLanServerFind
/*     */     extends Thread
/*     */   {
/*     */     private final LanServerDetector.LanServerList field_77500_a;
/*     */     private final InetAddress field_77498_b;
/*     */     private final MulticastSocket field_77499_c;
/*     */     private static final String __OBFID = "CL_00001135";
/*     */     
/*     */     public ThreadLanServerFind(LanServerDetector.LanServerList p_i1320_1_) throws IOException {
/*  93 */       super("LanServerDetector #" + LanServerDetector.field_148551_a.incrementAndGet());
/*  94 */       this.field_77500_a = p_i1320_1_;
/*  95 */       setDaemon(true);
/*     */       
/*  97 */       this.field_77499_c = new MulticastSocket(4445);
/*  98 */       this.field_77498_b = InetAddress.getByName("224.0.2.60");
/*  99 */       this.field_77499_c.setSoTimeout(5000);
/* 100 */       this.field_77499_c.joinGroup(this.field_77498_b);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 107 */       byte[] arrayOfByte = new byte[1024];
/*     */       
/* 109 */       while (!isInterrupted()) {
/*     */         
/* 111 */         DatagramPacket datagramPacket = new DatagramPacket(arrayOfByte, arrayOfByte.length);
/*     */         try {
/* 113 */           this.field_77499_c.receive(datagramPacket);
/* 114 */         } catch (SocketTimeoutException socketTimeoutException) {
/*     */           continue;
/* 116 */         } catch (IOException iOException) {
/* 117 */           LanServerDetector.field_148550_b.error("Couldn't ping server", iOException);
/*     */           
/*     */           break;
/*     */         } 
/* 121 */         String str = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());
/* 122 */         LanServerDetector.field_148550_b.debug(datagramPacket.getAddress() + ": " + str);
/* 123 */         this.field_77500_a.func_77551_a(str, datagramPacket.getAddress());
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 128 */         this.field_77499_c.leaveGroup(this.field_77498_b);
/* 129 */       } catch (IOException iOException) {}
/*     */       
/* 131 */       this.field_77499_c.close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\network\LanServerDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */