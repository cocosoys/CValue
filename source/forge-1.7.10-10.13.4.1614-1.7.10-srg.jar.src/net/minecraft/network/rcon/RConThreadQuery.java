/*     */ package net.minecraft.network.rcon;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.DatagramSocket;
/*     */ import java.net.InetAddress;
/*     */ import java.net.SocketAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ @SideOnly(Side.SERVER)
/*     */ public class RConThreadQuery extends RConThreadBase {
/*     */   private long field_72629_g;
/*     */   private int field_72636_h;
/*     */   private int field_72637_i;
/*     */   private int field_72634_j;
/*     */   private String field_72635_k;
/*     */   private String field_72632_l;
/*     */   private DatagramSocket field_72633_m;
/*  25 */   private byte[] field_72630_n = new byte[1460];
/*     */   
/*     */   private DatagramPacket field_72631_o;
/*     */   private Map field_72644_p;
/*     */   private String field_72643_q;
/*     */   private String field_72642_r;
/*     */   private Map field_72641_s;
/*     */   private long field_72640_t;
/*     */   private RConOutputStream field_72639_u;
/*     */   private long field_72638_v;
/*     */   private static final String __OBFID = "CL_00001802";
/*     */   
/*     */   public RConThreadQuery(IServer p_i1536_1_) {
/*  38 */     super(p_i1536_1_, "Query Listener");
/*     */     
/*  40 */     this.field_72636_h = p_i1536_1_.func_71327_a("query.port", 0);
/*  41 */     this.field_72642_r = p_i1536_1_.func_71277_t();
/*  42 */     this.field_72637_i = p_i1536_1_.func_71234_u();
/*  43 */     this.field_72635_k = p_i1536_1_.func_71274_v();
/*  44 */     this.field_72634_j = p_i1536_1_.func_71275_y();
/*  45 */     this.field_72632_l = p_i1536_1_.func_71270_I();
/*     */ 
/*     */     
/*  48 */     this.field_72638_v = 0L;
/*     */     
/*  50 */     this.field_72643_q = "0.0.0.0";
/*     */ 
/*     */     
/*  53 */     if (0 == this.field_72642_r.length() || this.field_72643_q.equals(this.field_72642_r)) {
/*     */       
/*  55 */       this.field_72642_r = "0.0.0.0";
/*     */       try {
/*  57 */         InetAddress inetAddress = InetAddress.getLocalHost();
/*  58 */         this.field_72643_q = inetAddress.getHostAddress();
/*  59 */       } catch (UnknownHostException unknownHostException) {
/*  60 */         func_72606_c("Unable to determine local host IP, please set server-ip in '" + p_i1536_1_.func_71329_c() + "' : " + unknownHostException.getMessage());
/*     */       } 
/*     */     } else {
/*  63 */       this.field_72643_q = this.field_72642_r;
/*     */     } 
/*     */ 
/*     */     
/*  67 */     if (0 == this.field_72636_h) {
/*     */       
/*  69 */       this.field_72636_h = this.field_72637_i;
/*  70 */       func_72609_b("Setting default query port to " + this.field_72636_h);
/*  71 */       p_i1536_1_.func_71328_a("query.port", Integer.valueOf(this.field_72636_h));
/*  72 */       p_i1536_1_.func_71328_a("debug", Boolean.valueOf(false));
/*  73 */       p_i1536_1_.func_71326_a();
/*     */     } 
/*     */     
/*  76 */     this.field_72644_p = new HashMap<Object, Object>();
/*  77 */     this.field_72639_u = new RConOutputStream(1460);
/*  78 */     this.field_72641_s = new HashMap<Object, Object>();
/*  79 */     this.field_72640_t = (new Date()).getTime();
/*     */   }
/*     */   
/*     */   private void func_72620_a(byte[] p_72620_1_, DatagramPacket p_72620_2_) throws IOException {
/*  83 */     this.field_72633_m.send(new DatagramPacket(p_72620_1_, p_72620_1_.length, p_72620_2_.getSocketAddress()));
/*     */   }
/*     */   private boolean func_72621_a(DatagramPacket p_72621_1_) throws IOException {
/*     */     RConOutputStream rConOutputStream;
/*  87 */     byte[] arrayOfByte = p_72621_1_.getData();
/*  88 */     int i = p_72621_1_.getLength();
/*  89 */     SocketAddress socketAddress = p_72621_1_.getSocketAddress();
/*  90 */     func_72607_a("Packet len " + i + " [" + socketAddress + "]");
/*  91 */     if (3 > i || -2 != arrayOfByte[0] || -3 != arrayOfByte[1]) {
/*     */       
/*  93 */       func_72607_a("Invalid packet [" + socketAddress + "]");
/*  94 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  98 */     func_72607_a("Packet '" + RConUtils.func_72663_a(arrayOfByte[2]) + "' [" + socketAddress + "]");
/*  99 */     switch (arrayOfByte[2]) {
/*     */       
/*     */       case 9:
/* 102 */         func_72622_d(p_72621_1_);
/* 103 */         func_72607_a("Challenge [" + socketAddress + "]");
/* 104 */         return true;
/*     */ 
/*     */       
/*     */       case 0:
/* 108 */         if (!func_72627_c(p_72621_1_).booleanValue()) {
/* 109 */           func_72607_a("Invalid challenge [" + socketAddress + "]");
/* 110 */           return false;
/*     */         } 
/*     */         
/* 113 */         if (15 == i) {
/*     */           
/* 115 */           func_72620_a(func_72624_b(p_72621_1_), p_72621_1_);
/* 116 */           func_72607_a("Rules [" + socketAddress + "]");
/*     */           break;
/*     */         } 
/* 119 */         rConOutputStream = new RConOutputStream(1460);
/* 120 */         rConOutputStream.func_72667_a(0);
/* 121 */         rConOutputStream.func_72670_a(func_72625_a(p_72621_1_.getSocketAddress()));
/* 122 */         rConOutputStream.func_72671_a(this.field_72635_k);
/* 123 */         rConOutputStream.func_72671_a("SMP");
/* 124 */         rConOutputStream.func_72671_a(this.field_72632_l);
/* 125 */         rConOutputStream.func_72671_a(Integer.toString(func_72603_d()));
/* 126 */         rConOutputStream.func_72671_a(Integer.toString(this.field_72634_j));
/* 127 */         rConOutputStream.func_72668_a((short)this.field_72637_i);
/* 128 */         rConOutputStream.func_72671_a(this.field_72643_q);
/*     */         
/* 130 */         func_72620_a(rConOutputStream.func_72672_a(), p_72621_1_);
/* 131 */         func_72607_a("Status [" + socketAddress + "]");
/*     */         break;
/*     */     } 
/*     */     
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private byte[] func_72624_b(DatagramPacket p_72624_1_) throws IOException {
/* 139 */     long l = MinecraftServer.func_130071_aq();
/* 140 */     if (l < this.field_72638_v + 5000L) {
/*     */       
/* 142 */       byte[] arrayOfByte1 = this.field_72639_u.func_72672_a();
/* 143 */       byte[] arrayOfByte2 = func_72625_a(p_72624_1_.getSocketAddress());
/* 144 */       arrayOfByte1[1] = arrayOfByte2[0];
/* 145 */       arrayOfByte1[2] = arrayOfByte2[1];
/* 146 */       arrayOfByte1[3] = arrayOfByte2[2];
/* 147 */       arrayOfByte1[4] = arrayOfByte2[3];
/*     */       
/* 149 */       return arrayOfByte1;
/*     */     } 
/*     */     
/* 152 */     this.field_72638_v = l;
/*     */     
/* 154 */     this.field_72639_u.func_72669_b();
/* 155 */     this.field_72639_u.func_72667_a(0);
/* 156 */     this.field_72639_u.func_72670_a(func_72625_a(p_72624_1_.getSocketAddress()));
/* 157 */     this.field_72639_u.func_72671_a("splitnum");
/* 158 */     this.field_72639_u.func_72667_a(128);
/* 159 */     this.field_72639_u.func_72667_a(0);
/*     */ 
/*     */     
/* 162 */     this.field_72639_u.func_72671_a("hostname");
/* 163 */     this.field_72639_u.func_72671_a(this.field_72635_k);
/* 164 */     this.field_72639_u.func_72671_a("gametype");
/* 165 */     this.field_72639_u.func_72671_a("SMP");
/* 166 */     this.field_72639_u.func_72671_a("game_id");
/* 167 */     this.field_72639_u.func_72671_a("MINECRAFT");
/* 168 */     this.field_72639_u.func_72671_a("version");
/* 169 */     this.field_72639_u.func_72671_a(this.field_72617_b.func_71249_w());
/* 170 */     this.field_72639_u.func_72671_a("plugins");
/* 171 */     this.field_72639_u.func_72671_a(this.field_72617_b.func_71258_A());
/* 172 */     this.field_72639_u.func_72671_a("map");
/* 173 */     this.field_72639_u.func_72671_a(this.field_72632_l);
/* 174 */     this.field_72639_u.func_72671_a("numplayers");
/* 175 */     this.field_72639_u.func_72671_a("" + func_72603_d());
/* 176 */     this.field_72639_u.func_72671_a("maxplayers");
/* 177 */     this.field_72639_u.func_72671_a("" + this.field_72634_j);
/* 178 */     this.field_72639_u.func_72671_a("hostport");
/* 179 */     this.field_72639_u.func_72671_a("" + this.field_72637_i);
/* 180 */     this.field_72639_u.func_72671_a("hostip");
/* 181 */     this.field_72639_u.func_72671_a(this.field_72643_q);
/* 182 */     this.field_72639_u.func_72667_a(0);
/* 183 */     this.field_72639_u.func_72667_a(1);
/*     */ 
/*     */ 
/*     */     
/* 187 */     this.field_72639_u.func_72671_a("player_");
/* 188 */     this.field_72639_u.func_72667_a(0);
/*     */     
/* 190 */     String[] arrayOfString = this.field_72617_b.func_71213_z();
/* 191 */     for (String str : arrayOfString) {
/* 192 */       this.field_72639_u.func_72671_a(str);
/*     */     }
/* 194 */     this.field_72639_u.func_72667_a(0);
/*     */     
/* 196 */     return this.field_72639_u.func_72672_a();
/*     */   }
/*     */   
/*     */   private byte[] func_72625_a(SocketAddress p_72625_1_) {
/* 200 */     return ((Auth)this.field_72641_s.get(p_72625_1_)).func_72591_c();
/*     */   }
/*     */   
/*     */   private Boolean func_72627_c(DatagramPacket p_72627_1_) {
/* 204 */     SocketAddress socketAddress = p_72627_1_.getSocketAddress();
/* 205 */     if (!this.field_72641_s.containsKey(socketAddress))
/*     */     {
/* 207 */       return Boolean.valueOf(false);
/*     */     }
/*     */     
/* 210 */     byte[] arrayOfByte = p_72627_1_.getData();
/* 211 */     if (((Auth)this.field_72641_s.get(socketAddress)).func_72592_a() != RConUtils.func_72664_c(arrayOfByte, 7, p_72627_1_.getLength()))
/*     */     {
/* 213 */       return Boolean.valueOf(false);
/*     */     }
/*     */ 
/*     */     
/* 217 */     return Boolean.valueOf(true);
/*     */   }
/*     */   
/*     */   private void func_72622_d(DatagramPacket p_72622_1_) throws IOException {
/* 221 */     Auth auth = new Auth(this, p_72622_1_);
/* 222 */     this.field_72641_s.put(p_72622_1_.getSocketAddress(), auth);
/*     */     
/* 224 */     func_72620_a(auth.func_72594_b(), p_72622_1_);
/*     */   }
/*     */   
/*     */   private void func_72628_f() {
/* 228 */     if (!this.field_72619_a) {
/*     */       return;
/*     */     }
/*     */     
/* 232 */     long l = MinecraftServer.func_130071_aq();
/* 233 */     if (l < this.field_72629_g + 30000L) {
/*     */       return;
/*     */     }
/* 236 */     this.field_72629_g = l;
/*     */     
/* 238 */     Iterator<Map.Entry> iterator = this.field_72641_s.entrySet().iterator();
/* 239 */     while (iterator.hasNext()) {
/* 240 */       Map.Entry entry = iterator.next();
/* 241 */       if (((Auth)entry.getValue()).func_72593_a(l).booleanValue()) {
/* 242 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/* 249 */     func_72609_b("Query running on " + this.field_72642_r + ":" + this.field_72636_h);
/* 250 */     this.field_72629_g = MinecraftServer.func_130071_aq();
/* 251 */     this.field_72631_o = new DatagramPacket(this.field_72630_n, this.field_72630_n.length);
/*     */     
/*     */     try {
/* 254 */       while (this.field_72619_a) {
/*     */         try {
/* 256 */           this.field_72633_m.receive(this.field_72631_o);
/*     */ 
/*     */           
/* 259 */           func_72628_f();
/*     */ 
/*     */           
/* 262 */           func_72621_a(this.field_72631_o);
/* 263 */         } catch (SocketTimeoutException socketTimeoutException) {
/*     */           
/* 265 */           func_72628_f();
/* 266 */         } catch (PortUnreachableException portUnreachableException) {
/*     */         
/* 268 */         } catch (IOException iOException) {
/*     */           
/* 270 */           func_72623_a(iOException);
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 274 */       func_72611_e();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72602_a() {
/* 280 */     if (this.field_72619_a) {
/*     */       return;
/*     */     }
/*     */     
/* 284 */     if (0 >= this.field_72636_h || 65535 < this.field_72636_h) {
/* 285 */       func_72606_c("Invalid query port " + this.field_72636_h + " found in '" + this.field_72617_b.func_71329_c() + "' (queries disabled)");
/*     */       
/*     */       return;
/*     */     } 
/* 289 */     if (func_72626_g()) {
/* 290 */       super.func_72602_a();
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_72623_a(Exception p_72623_1_) {
/* 295 */     if (!this.field_72619_a) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 300 */     func_72606_c("Unexpected exception, buggy JRE? (" + p_72623_1_.toString() + ")");
/*     */ 
/*     */     
/* 303 */     if (!func_72626_g()) {
/* 304 */       func_72610_d("Failed to recover from buggy JRE, shutting down!");
/* 305 */       this.field_72619_a = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_72626_g() {
/*     */     try {
/* 311 */       this.field_72633_m = new DatagramSocket(this.field_72636_h, InetAddress.getByName(this.field_72642_r));
/* 312 */       func_72601_a(this.field_72633_m);
/* 313 */       this.field_72633_m.setSoTimeout(500);
/* 314 */       return true;
/* 315 */     } catch (SocketException socketException) {
/* 316 */       func_72606_c("Unable to initialise query system on " + this.field_72642_r + ":" + this.field_72636_h + " (Socket): " + socketException.getMessage());
/* 317 */     } catch (UnknownHostException unknownHostException) {
/* 318 */       func_72606_c("Unable to initialise query system on " + this.field_72642_r + ":" + this.field_72636_h + " (Unknown Host): " + unknownHostException.getMessage());
/* 319 */     } catch (Exception exception) {
/* 320 */       func_72606_c("Unable to initialise query system on " + this.field_72642_r + ":" + this.field_72636_h + " (E): " + exception.getMessage());
/*     */     } 
/*     */     
/* 323 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.SERVER)
/*     */   class Auth
/*     */   {
/* 334 */     private long field_72598_b = (new Date()).getTime(); private int field_72599_c; private byte[] field_72596_d; public Auth(RConThreadQuery p_i1535_1_, DatagramPacket p_i1535_2_) {
/* 335 */       byte[] arrayOfByte = p_i1535_2_.getData();
/* 336 */       this.field_72596_d = new byte[4];
/* 337 */       this.field_72596_d[0] = arrayOfByte[3];
/* 338 */       this.field_72596_d[1] = arrayOfByte[4];
/* 339 */       this.field_72596_d[2] = arrayOfByte[5];
/* 340 */       this.field_72596_d[3] = arrayOfByte[6];
/* 341 */       this.field_72595_f = new String(this.field_72596_d);
/* 342 */       this.field_72599_c = (new Random()).nextInt(16777216);
/* 343 */       this.field_72597_e = String.format("\t%s%d\000", new Object[] { this.field_72595_f, Integer.valueOf(this.field_72599_c) }).getBytes();
/*     */     }
/*     */     private byte[] field_72597_e; private String field_72595_f; private static final String __OBFID = "CL_00001803";
/*     */     public Boolean func_72593_a(long p_72593_1_) {
/* 347 */       return Boolean.valueOf((this.field_72598_b < p_72593_1_));
/*     */     }
/*     */     
/*     */     public int func_72592_a() {
/* 351 */       return this.field_72599_c;
/*     */     }
/*     */     
/*     */     public byte[] func_72594_b() {
/* 355 */       return this.field_72597_e;
/*     */     }
/*     */     
/*     */     public byte[] func_72591_c() {
/* 359 */       return this.field_72596_d;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\rcon\RConThreadQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */