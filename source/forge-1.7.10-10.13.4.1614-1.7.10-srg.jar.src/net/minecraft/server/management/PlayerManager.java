/*     */ package net.minecraft.server.management;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S21PacketChunkData;
/*     */ import net.minecraft.network.play.server.S22PacketMultiBlockChange;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.LongHashMap;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class PlayerManager {
/*  17 */   private static final Logger field_152627_a = LogManager.getLogger();
/*     */   
/*     */   private final WorldServer field_72701_a;
/*     */ 
/*     */   
/*     */   class PlayerInstance
/*     */   {
/*  24 */     private final List field_73263_b = new ArrayList();
/*     */     
/*     */     private final ChunkCoordIntPair field_73264_c;
/*  27 */     private short[] field_151254_d = new short[64]; private int field_73262_e;
/*     */     private int field_73260_f;
/*     */     private long field_111198_g;
/*     */     private static final String __OBFID = "CL_00001435";
/*     */     
/*     */     public PlayerInstance(PlayerManager p_i1518_1_, int p_i1518_2_, int p_i1518_3_) {
/*  33 */       this.field_73264_c = new ChunkCoordIntPair(p_i1518_2_, p_i1518_3_);
/*  34 */       (p_i1518_1_.func_72688_a()).field_73059_b.func_73158_c(p_i1518_2_, p_i1518_3_);
/*     */     }
/*     */     
/*     */     public void func_73255_a(EntityPlayerMP p_73255_1_) {
/*  38 */       if (this.field_73263_b.contains(p_73255_1_)) {
/*  39 */         PlayerManager.field_152627_a.debug("Failed to add player. {} already is in chunk {}, {}", new Object[] { p_73255_1_, Integer.valueOf(this.field_73264_c.field_77276_a), Integer.valueOf(this.field_73264_c.field_77275_b) });
/*     */         
/*     */         return;
/*     */       } 
/*  43 */       if (this.field_73263_b.isEmpty()) {
/*  44 */         this.field_111198_g = this.field_73265_a.field_72701_a.func_82737_E();
/*     */       }
/*     */       
/*  47 */       this.field_73263_b.add(p_73255_1_);
/*  48 */       p_73255_1_.field_71129_f.add(this.field_73264_c);
/*     */     }
/*     */     
/*     */     public void func_73252_b(EntityPlayerMP p_73252_1_) {
/*  52 */       if (!this.field_73263_b.contains(p_73252_1_)) {
/*     */         return;
/*     */       }
/*     */       
/*  56 */       Chunk chunk = this.field_73265_a.field_72701_a.func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b);
/*  57 */       if (chunk.func_150802_k()) {
/*  58 */         p_73252_1_.field_71135_a.func_147359_a((Packet)new S21PacketChunkData(chunk, true, 0));
/*     */       }
/*  60 */       this.field_73263_b.remove(p_73252_1_);
/*  61 */       p_73252_1_.field_71129_f.remove(this.field_73264_c);
/*     */       
/*  63 */       if (this.field_73263_b.isEmpty()) {
/*  64 */         long l = this.field_73264_c.field_77276_a + 2147483647L | this.field_73264_c.field_77275_b + 2147483647L << 32L;
/*  65 */         func_111196_a(chunk);
/*  66 */         this.field_73265_a.field_72700_c.func_76159_d(l);
/*  67 */         this.field_73265_a.field_111193_e.remove(this);
/*  68 */         if (this.field_73262_e > 0) {
/*  69 */           this.field_73265_a.field_72697_d.remove(this);
/*     */         }
/*  71 */         (this.field_73265_a.func_72688_a()).field_73059_b.func_73241_b(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void func_111194_a() {
/*  76 */       func_111196_a(this.field_73265_a.field_72701_a.func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b));
/*     */     }
/*     */     
/*     */     private void func_111196_a(Chunk p_111196_1_) {
/*  80 */       p_111196_1_.field_111204_q += this.field_73265_a.field_72701_a.func_82737_E() - this.field_111198_g;
/*     */       
/*  82 */       this.field_111198_g = this.field_73265_a.field_72701_a.func_82737_E();
/*     */     }
/*     */     
/*     */     public void func_151253_a(int p_151253_1_, int p_151253_2_, int p_151253_3_) {
/*  86 */       if (this.field_73262_e == 0) {
/*  87 */         this.field_73265_a.field_72697_d.add(this);
/*     */       }
/*  89 */       this.field_73260_f |= 1 << p_151253_2_ >> 4;
/*     */       
/*  91 */       if (this.field_73262_e < 64) {
/*  92 */         short s = (short)(p_151253_1_ << 12 | p_151253_3_ << 8 | p_151253_2_);
/*     */         
/*  94 */         for (byte b = 0; b < this.field_73262_e; b++) {
/*  95 */           if (this.field_151254_d[b] == s)
/*     */             return; 
/*     */         } 
/*  98 */         this.field_151254_d[this.field_73262_e++] = s;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void func_151251_a(Packet p_151251_1_) {
/* 103 */       for (byte b = 0; b < this.field_73263_b.size(); b++) {
/* 104 */         EntityPlayerMP entityPlayerMP = this.field_73263_b.get(b);
/* 105 */         if (!entityPlayerMP.field_71129_f.contains(this.field_73264_c)) {
/* 106 */           entityPlayerMP.field_71135_a.func_147359_a(p_151251_1_);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     public void func_73254_a() {
/* 112 */       if (this.field_73262_e == 0)
/*     */         return; 
/* 114 */       if (this.field_73262_e == 1) {
/* 115 */         int i = this.field_73264_c.field_77276_a * 16 + (this.field_151254_d[0] >> 12 & 0xF);
/* 116 */         int j = this.field_151254_d[0] & 0xFF;
/* 117 */         int k = this.field_73264_c.field_77275_b * 16 + (this.field_151254_d[0] >> 8 & 0xF);
/*     */         
/* 119 */         func_151251_a((Packet)new S23PacketBlockChange(i, j, k, (World)this.field_73265_a.field_72701_a));
/* 120 */         if (this.field_73265_a.field_72701_a.func_147439_a(i, j, k).func_149716_u()) {
/* 121 */           func_151252_a(this.field_73265_a.field_72701_a.func_147438_o(i, j, k));
/*     */         }
/* 123 */       } else if (this.field_73262_e == 64) {
/* 124 */         int i = this.field_73264_c.field_77276_a * 16;
/* 125 */         int j = this.field_73264_c.field_77275_b * 16;
/*     */         
/* 127 */         func_151251_a((Packet)new S21PacketChunkData(this.field_73265_a.field_72701_a.func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b), false, this.field_73260_f));
/*     */         
/* 129 */         for (byte b = 0; b < 16; b++) {
/* 130 */           if ((this.field_73260_f & 1 << b) != 0) {
/* 131 */             int k = b << 4;
/* 132 */             List<TileEntity> list = this.field_73265_a.field_72701_a.func_147486_a(i, k, j, i + 16, k + 16, j + 16);
/* 133 */             for (byte b1 = 0; b1 < list.size(); b1++) {
/* 134 */               func_151252_a(list.get(b1));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } else {
/* 139 */         func_151251_a((Packet)new S22PacketMultiBlockChange(this.field_73262_e, this.field_151254_d, this.field_73265_a.field_72701_a.func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b)));
/*     */         
/* 141 */         for (byte b = 0; b < this.field_73262_e; b++) {
/* 142 */           int i = this.field_73264_c.field_77276_a * 16 + (this.field_151254_d[b] >> 12 & 0xF);
/* 143 */           int j = this.field_151254_d[b] & 0xFF;
/* 144 */           int k = this.field_73264_c.field_77275_b * 16 + (this.field_151254_d[b] >> 8 & 0xF);
/*     */           
/* 146 */           if (this.field_73265_a.field_72701_a.func_147439_a(i, j, k).func_149716_u()) {
/* 147 */             func_151252_a(this.field_73265_a.field_72701_a.func_147438_o(i, j, k));
/*     */           }
/*     */         } 
/*     */       } 
/* 151 */       this.field_73262_e = 0;
/* 152 */       this.field_73260_f = 0;
/*     */     }
/*     */     
/*     */     private void func_151252_a(TileEntity p_151252_1_) {
/* 156 */       if (p_151252_1_ != null) {
/* 157 */         Packet packet = p_151252_1_.func_145844_m();
/* 158 */         if (packet != null) {
/* 159 */           func_151251_a(packet);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 166 */   private final List field_72699_b = new ArrayList();
/* 167 */   private final LongHashMap field_72700_c = new LongHashMap();
/* 168 */   private final List field_72697_d = new ArrayList();
/* 169 */   private final List field_111193_e = new ArrayList();
/*     */   
/*     */   private int field_72698_e;
/*     */   
/*     */   private long field_111192_g;
/*     */   
/*     */   private final int[][] field_72696_f;
/*     */   
/*     */   private static final String __OBFID = "CL_00001434";
/*     */   
/*     */   public WorldServer func_72688_a() {
/* 180 */     return this.field_72701_a;
/*     */   }
/*     */   
/*     */   public void func_72693_b() {
/* 184 */     long l = this.field_72701_a.func_82737_E();
/*     */     
/* 186 */     if (l - this.field_111192_g > 8000L) {
/* 187 */       this.field_111192_g = l;
/*     */       
/* 189 */       for (byte b = 0; b < this.field_111193_e.size(); b++) {
/* 190 */         PlayerInstance playerInstance = this.field_111193_e.get(b);
/* 191 */         playerInstance.func_73254_a();
/* 192 */         playerInstance.func_111194_a();
/*     */       } 
/*     */     } else {
/* 195 */       for (byte b = 0; b < this.field_72697_d.size(); b++) {
/* 196 */         PlayerInstance playerInstance = this.field_72697_d.get(b);
/* 197 */         playerInstance.func_73254_a();
/*     */       } 
/*     */     } 
/*     */     
/* 201 */     this.field_72697_d.clear();
/*     */     
/* 203 */     if (this.field_72699_b.isEmpty()) {
/* 204 */       WorldProvider worldProvider = this.field_72701_a.field_73011_w;
/* 205 */       if (!worldProvider.func_76567_e()) {
/* 206 */         this.field_72701_a.field_73059_b.func_73240_a();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_152621_a(int p_152621_1_, int p_152621_2_) {
/* 212 */     long l = p_152621_1_ + 2147483647L | p_152621_2_ + 2147483647L << 32L;
/* 213 */     return (this.field_72700_c.func_76164_a(l) != null);
/*     */   }
/*     */   
/*     */   private PlayerInstance func_72690_a(int p_72690_1_, int p_72690_2_, boolean p_72690_3_) {
/* 217 */     long l = p_72690_1_ + 2147483647L | p_72690_2_ + 2147483647L << 32L;
/* 218 */     PlayerInstance playerInstance = (PlayerInstance)this.field_72700_c.func_76164_a(l);
/* 219 */     if (playerInstance == null && p_72690_3_) {
/* 220 */       playerInstance = new PlayerInstance(this, p_72690_1_, p_72690_2_);
/* 221 */       this.field_72700_c.func_76163_a(l, playerInstance);
/* 222 */       this.field_111193_e.add(playerInstance);
/*     */     } 
/* 224 */     return playerInstance;
/*     */   }
/*     */   
/*     */   public void func_151250_a(int p_151250_1_, int p_151250_2_, int p_151250_3_) {
/* 228 */     int i = p_151250_1_ >> 4;
/* 229 */     int j = p_151250_3_ >> 4;
/* 230 */     PlayerInstance playerInstance = func_72690_a(i, j, false);
/* 231 */     if (playerInstance != null)
/* 232 */       playerInstance.func_151253_a(p_151250_1_ & 0xF, p_151250_2_, p_151250_3_ & 0xF); 
/*     */   }
/*     */   
/*     */   public PlayerManager(WorldServer p_i1176_1_) {
/* 236 */     this.field_72696_f = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
/*     */     this.field_72701_a = p_i1176_1_;
/*     */     func_152622_a(p_i1176_1_.func_73046_m().func_71203_ab().func_72395_o());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_72683_a(EntityPlayerMP p_72683_1_) {
/* 249 */     int i = (int)p_72683_1_.field_70165_t >> 4;
/* 250 */     int j = (int)p_72683_1_.field_70161_v >> 4;
/*     */     
/* 252 */     p_72683_1_.field_71131_d = p_72683_1_.field_70165_t;
/* 253 */     p_72683_1_.field_71132_e = p_72683_1_.field_70161_v;
/*     */     
/* 255 */     for (int k = i - this.field_72698_e; k <= i + this.field_72698_e; k++) {
/* 256 */       for (int m = j - this.field_72698_e; m <= j + this.field_72698_e; m++) {
/* 257 */         func_72690_a(k, m, true).func_73255_a(p_72683_1_);
/*     */       }
/*     */     } 
/*     */     
/* 261 */     this.field_72699_b.add(p_72683_1_);
/* 262 */     func_72691_b(p_72683_1_);
/*     */   }
/*     */   
/*     */   public void func_72691_b(EntityPlayerMP p_72691_1_) {
/* 266 */     ArrayList arrayList = new ArrayList(p_72691_1_.field_71129_f);
/* 267 */     int i = 0;
/* 268 */     int j = this.field_72698_e;
/* 269 */     int k = (int)p_72691_1_.field_70165_t >> 4;
/* 270 */     int m = (int)p_72691_1_.field_70161_v >> 4;
/* 271 */     int n = 0;
/* 272 */     int i1 = 0;
/* 273 */     ChunkCoordIntPair chunkCoordIntPair = (func_72690_a(k, m, true)).field_73264_c;
/*     */     
/* 275 */     p_72691_1_.field_71129_f.clear();
/*     */ 
/*     */     
/* 278 */     if (arrayList.contains(chunkCoordIntPair)) {
/* 279 */       p_72691_1_.field_71129_f.add(chunkCoordIntPair);
/*     */     }
/*     */     
/*     */     byte b;
/* 283 */     for (b = 1; b <= j * 2; b++) {
/* 284 */       for (byte b1 = 0; b1 < 2; b1++) {
/* 285 */         int[] arrayOfInt = this.field_72696_f[i++ % 4];
/*     */         
/* 287 */         for (byte b2 = 0; b2 < b; b2++) {
/* 288 */           n += arrayOfInt[0];
/* 289 */           i1 += arrayOfInt[1];
/*     */           
/* 291 */           chunkCoordIntPair = (func_72690_a(k + n, m + i1, true)).field_73264_c;
/* 292 */           if (arrayList.contains(chunkCoordIntPair)) {
/* 293 */             p_72691_1_.field_71129_f.add(chunkCoordIntPair);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 300 */     i %= 4;
/* 301 */     for (b = 0; b < j * 2; b++) {
/* 302 */       n += this.field_72696_f[i][0];
/* 303 */       i1 += this.field_72696_f[i][1];
/*     */       
/* 305 */       chunkCoordIntPair = (func_72690_a(k + n, m + i1, true)).field_73264_c;
/* 306 */       if (arrayList.contains(chunkCoordIntPair)) {
/* 307 */         p_72691_1_.field_71129_f.add(chunkCoordIntPair);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_72695_c(EntityPlayerMP p_72695_1_) {
/* 313 */     int i = (int)p_72695_1_.field_71131_d >> 4;
/* 314 */     int j = (int)p_72695_1_.field_71132_e >> 4;
/*     */     
/* 316 */     for (int k = i - this.field_72698_e; k <= i + this.field_72698_e; k++) {
/* 317 */       for (int m = j - this.field_72698_e; m <= j + this.field_72698_e; m++) {
/* 318 */         PlayerInstance playerInstance = func_72690_a(k, m, false);
/* 319 */         if (playerInstance != null) playerInstance.func_73252_b(p_72695_1_);
/*     */       
/*     */       } 
/*     */     } 
/* 323 */     this.field_72699_b.remove(p_72695_1_);
/*     */   }
/*     */   
/*     */   private boolean func_72684_a(int p_72684_1_, int p_72684_2_, int p_72684_3_, int p_72684_4_, int p_72684_5_) {
/* 327 */     int i = p_72684_1_ - p_72684_3_;
/* 328 */     int j = p_72684_2_ - p_72684_4_;
/* 329 */     if (i < -p_72684_5_ || i > p_72684_5_) return false; 
/* 330 */     if (j < -p_72684_5_ || j > p_72684_5_) return false; 
/* 331 */     return true;
/*     */   }
/*     */   
/*     */   public void func_72685_d(EntityPlayerMP p_72685_1_) {
/* 335 */     int i = (int)p_72685_1_.field_70165_t >> 4;
/* 336 */     int j = (int)p_72685_1_.field_70161_v >> 4;
/*     */     
/* 338 */     double d1 = p_72685_1_.field_71131_d - p_72685_1_.field_70165_t;
/* 339 */     double d2 = p_72685_1_.field_71132_e - p_72685_1_.field_70161_v;
/* 340 */     double d3 = d1 * d1 + d2 * d2;
/* 341 */     if (d3 < 64.0D)
/*     */       return; 
/* 343 */     int k = (int)p_72685_1_.field_71131_d >> 4;
/* 344 */     int m = (int)p_72685_1_.field_71132_e >> 4;
/* 345 */     int n = this.field_72698_e;
/*     */     
/* 347 */     int i1 = i - k;
/* 348 */     int i2 = j - m;
/* 349 */     if (i1 == 0 && i2 == 0)
/*     */       return; 
/* 351 */     for (int i3 = i - n; i3 <= i + n; i3++) {
/* 352 */       for (int i4 = j - n; i4 <= j + n; i4++) {
/* 353 */         if (!func_72684_a(i3, i4, k, m, n)) {
/* 354 */           func_72690_a(i3, i4, true).func_73255_a(p_72685_1_);
/*     */         }
/* 356 */         if (!func_72684_a(i3 - i1, i4 - i2, i, j, n)) {
/* 357 */           PlayerInstance playerInstance = func_72690_a(i3 - i1, i4 - i2, false);
/* 358 */           if (playerInstance != null) playerInstance.func_73252_b(p_72685_1_);
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/* 363 */     func_72691_b(p_72685_1_);
/*     */     
/* 365 */     p_72685_1_.field_71131_d = p_72685_1_.field_70165_t;
/* 366 */     p_72685_1_.field_71132_e = p_72685_1_.field_70161_v;
/*     */   }
/*     */   
/*     */   public boolean func_72694_a(EntityPlayerMP p_72694_1_, int p_72694_2_, int p_72694_3_) {
/* 370 */     PlayerInstance playerInstance = func_72690_a(p_72694_2_, p_72694_3_, false);
/*     */     
/* 372 */     return (playerInstance != null && playerInstance.field_73263_b.contains(p_72694_1_) && !p_72694_1_.field_71129_f.contains(playerInstance.field_73264_c));
/*     */   }
/*     */   
/*     */   public void func_152622_a(int p_152622_1_) {
/* 376 */     p_152622_1_ = MathHelper.func_76125_a(p_152622_1_, 3, 20);
/* 377 */     if (p_152622_1_ == this.field_72698_e)
/* 378 */       return;  int i = p_152622_1_ - this.field_72698_e;
/*     */     
/* 380 */     for (EntityPlayerMP entityPlayerMP : this.field_72699_b) {
/* 381 */       int j = (int)entityPlayerMP.field_70165_t >> 4;
/* 382 */       int k = (int)entityPlayerMP.field_70161_v >> 4;
/*     */       
/* 384 */       if (i > 0) {
/* 385 */         for (int n = j - p_152622_1_; n <= j + p_152622_1_; n++) {
/* 386 */           for (int i1 = k - p_152622_1_; i1 <= k + p_152622_1_; i1++) {
/* 387 */             PlayerInstance playerInstance = func_72690_a(n, i1, true);
/*     */             
/* 389 */             if (!playerInstance.field_73263_b.contains(entityPlayerMP))
/* 390 */               playerInstance.func_73255_a(entityPlayerMP); 
/*     */           } 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 395 */       for (int m = j - this.field_72698_e; m <= j + this.field_72698_e; m++) {
/* 396 */         for (int n = k - this.field_72698_e; n <= k + this.field_72698_e; n++) {
/* 397 */           if (!func_72684_a(m, n, j, k, p_152622_1_)) {
/* 398 */             func_72690_a(m, n, true).func_73252_b(entityPlayerMP);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 405 */     this.field_72698_e = p_152622_1_;
/*     */   }
/*     */   
/*     */   public static int func_72686_a(int p_72686_0_) {
/* 409 */     return p_72686_0_ * 16 - 16;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\PlayerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */