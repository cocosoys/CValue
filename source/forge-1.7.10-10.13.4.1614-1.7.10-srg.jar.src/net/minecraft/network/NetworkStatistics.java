/*     */ package net.minecraft.network;
/*     */ 
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.apache.logging.log4j.Marker;
/*     */ import org.apache.logging.log4j.MarkerManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NetworkStatistics
/*     */ {
/*  13 */   private static final Logger field_152478_a = LogManager.getLogger();
/*  14 */   private static final Marker field_152479_b = MarkerManager.getMarker("NETSTAT_MARKER", NetworkManager.field_152461_c);
/*     */ 
/*     */ 
/*     */   
/*  18 */   private Tracker field_152480_c = new Tracker();
/*  19 */   private Tracker field_152481_d = new Tracker();
/*     */   private static final String __OBFID = "CL_00001897";
/*     */   
/*     */   public void func_152469_a(int p_152469_1_, long p_152469_2_) {
/*  23 */     this.field_152480_c.func_152488_a(p_152469_1_, p_152469_2_);
/*     */   }
/*     */   
/*     */   public void func_152464_b(int p_152464_1_, long p_152464_2_) {
/*  27 */     this.field_152481_d.func_152488_a(p_152464_1_, p_152464_2_);
/*     */   }
/*     */   
/*     */   public long func_152465_a() {
/*  31 */     return this.field_152480_c.func_152485_a();
/*     */   }
/*     */   
/*     */   public long func_152471_b() {
/*  35 */     return this.field_152481_d.func_152485_a();
/*     */   }
/*     */   
/*     */   public long func_152472_c() {
/*  39 */     return this.field_152480_c.func_152489_b();
/*     */   }
/*     */   
/*     */   public long func_152473_d() {
/*  43 */     return this.field_152481_d.func_152489_b();
/*     */   }
/*     */   
/*     */   public PacketStat func_152477_e() {
/*  47 */     return this.field_152480_c.func_152484_c();
/*     */   }
/*     */   
/*     */   public PacketStat func_152467_f() {
/*  51 */     return this.field_152480_c.func_152486_d();
/*     */   }
/*     */   
/*     */   public PacketStat func_152475_g() {
/*  55 */     return this.field_152481_d.func_152484_c();
/*     */   }
/*     */   
/*     */   public PacketStat func_152470_h() {
/*  59 */     return this.field_152481_d.func_152486_d();
/*     */   }
/*     */   
/*     */   public PacketStat func_152466_a(int p_152466_1_) {
/*  63 */     return this.field_152480_c.func_152487_a(p_152466_1_);
/*     */   }
/*     */   
/*     */   public PacketStat func_152468_b(int p_152468_1_) {
/*  67 */     return this.field_152481_d.func_152487_a(p_152468_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class Tracker
/*     */   {
/*     */     private static final String __OBFID = "CL_00001894";
/*     */     
/*  76 */     private AtomicReference[] field_152490_a = new AtomicReference[100];
/*     */     
/*     */     public Tracker() {
/*  79 */       for (byte b = 0; b < 100; b++)
/*  80 */         this.field_152490_a[b] = new AtomicReference<NetworkStatistics.PacketStatData>(new NetworkStatistics.PacketStatData(0L, 0, 0.0D)); 
/*     */     }
/*     */     public void func_152488_a(int p_152488_1_, long p_152488_2_) {
/*     */       try {
/*     */         NetworkStatistics.PacketStatData packetStatData1;
/*     */         NetworkStatistics.PacketStatData packetStatData2;
/*  86 */         if (p_152488_1_ < 0 || p_152488_1_ >= 100) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/*     */         do {
/*  92 */           packetStatData1 = this.field_152490_a[p_152488_1_].get();
/*  93 */           packetStatData2 = packetStatData1.func_152494_a(p_152488_2_);
/*     */         }
/*  95 */         while (!this.field_152490_a[p_152488_1_].compareAndSet(packetStatData1, packetStatData2));
/*     */       }
/*  97 */       catch (Exception exception) {
/*  98 */         if (NetworkStatistics.field_152478_a.isDebugEnabled()) {
/*  99 */           NetworkStatistics.field_152478_a.debug(NetworkStatistics.field_152479_b, "NetStat failed with packetId: " + p_152488_1_, exception);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     public long func_152485_a() {
/* 105 */       long l = 0L;
/* 106 */       for (byte b = 0; b < 100; b++) {
/* 107 */         l += ((NetworkStatistics.PacketStatData)this.field_152490_a[b].get()).func_152493_a();
/*     */       }
/* 109 */       return l;
/*     */     }
/*     */     
/*     */     public long func_152489_b() {
/* 113 */       long l = 0L;
/* 114 */       for (byte b = 0; b < 100; b++) {
/* 115 */         l += ((NetworkStatistics.PacketStatData)this.field_152490_a[b].get()).func_152495_b();
/*     */       }
/* 117 */       return l;
/*     */     }
/*     */     
/*     */     public NetworkStatistics.PacketStat func_152484_c() {
/* 121 */       byte b = -1;
/* 122 */       NetworkStatistics.PacketStatData packetStatData = new NetworkStatistics.PacketStatData(-1L, -1, 0.0D);
/* 123 */       for (byte b1 = 0; b1 < 100; b1++) {
/* 124 */         NetworkStatistics.PacketStatData packetStatData1 = this.field_152490_a[b1].get();
/* 125 */         if (packetStatData1.field_152496_a > packetStatData.field_152496_a) {
/* 126 */           b = b1;
/* 127 */           packetStatData = packetStatData1;
/*     */         } 
/*     */       } 
/* 130 */       return new NetworkStatistics.PacketStat(b, packetStatData);
/*     */     }
/*     */     
/*     */     public NetworkStatistics.PacketStat func_152486_d() {
/* 134 */       byte b = -1;
/* 135 */       NetworkStatistics.PacketStatData packetStatData = new NetworkStatistics.PacketStatData(-1L, -1, 0.0D);
/* 136 */       for (byte b1 = 0; b1 < 100; b1++) {
/* 137 */         NetworkStatistics.PacketStatData packetStatData1 = this.field_152490_a[b1].get();
/* 138 */         if (packetStatData1.field_152497_b > packetStatData.field_152497_b) {
/* 139 */           b = b1;
/* 140 */           packetStatData = packetStatData1;
/*     */         } 
/*     */       } 
/* 143 */       return new NetworkStatistics.PacketStat(b, packetStatData);
/*     */     }
/*     */     
/*     */     public NetworkStatistics.PacketStat func_152487_a(int p_152487_1_) {
/* 147 */       if (p_152487_1_ < 0 || p_152487_1_ >= 100) {
/* 148 */         return null;
/*     */       }
/*     */       
/* 151 */       return new NetworkStatistics.PacketStat(p_152487_1_, this.field_152490_a[p_152487_1_].get());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class PacketStatData
/*     */   {
/*     */     private final long field_152496_a;
/*     */     
/*     */     private final int field_152497_b;
/*     */     private final double field_152498_c;
/*     */     private static final String __OBFID = "CL_00001893";
/*     */     
/*     */     private PacketStatData(long p_i1184_1_, int p_i1184_3_, double p_i1184_4_) {
/* 165 */       this.field_152496_a = p_i1184_1_;
/* 166 */       this.field_152497_b = p_i1184_3_;
/* 167 */       this.field_152498_c = p_i1184_4_;
/*     */     }
/*     */     
/*     */     public PacketStatData func_152494_a(long p_152494_1_) {
/* 171 */       return new PacketStatData(p_152494_1_ + this.field_152496_a, this.field_152497_b + 1, ((p_152494_1_ + this.field_152496_a) / (this.field_152497_b + 1)));
/*     */     }
/*     */     
/*     */     public long func_152493_a() {
/* 175 */       return this.field_152496_a;
/*     */     }
/*     */     
/*     */     public int func_152495_b() {
/* 179 */       return this.field_152497_b;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 188 */       return "{totalBytes=" + this.field_152496_a + ", count=" + this.field_152497_b + ", averageBytes=" + this.field_152498_c + '}';
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PacketStat
/*     */   {
/*     */     private final int field_152482_a;
/*     */     
/*     */     private final NetworkStatistics.PacketStatData field_152483_b;
/*     */     
/*     */     private static final String __OBFID = "CL_00001895";
/*     */ 
/*     */     
/*     */     public PacketStat(int p_i1188_1_, NetworkStatistics.PacketStatData p_i1188_2_) {
/* 204 */       this.field_152482_a = p_i1188_1_;
/* 205 */       this.field_152483_b = p_i1188_2_;
/*     */     }
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
/*     */     public String toString() {
/* 218 */       return "PacketStat(" + this.field_152482_a + ")" + this.field_152483_b;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\NetworkStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */