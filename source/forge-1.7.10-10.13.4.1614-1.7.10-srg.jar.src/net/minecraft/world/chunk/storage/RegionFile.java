/*     */ package net.minecraft.world.chunk.storage;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.util.ArrayList;
/*     */ import java.util.zip.DeflaterOutputStream;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import java.util.zip.InflaterInputStream;
/*     */ import net.minecraft.server.MinecraftServer;
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
/*     */ public class RegionFile
/*     */ {
/*  76 */   private static final byte[] field_76720_a = new byte[4096];
/*     */   private final File field_76718_b;
/*     */   private RandomAccessFile field_76719_c;
/*     */   private final int[] field_76716_d;
/*     */   private final int[] field_76717_e;
/*     */   private ArrayList field_76714_f;
/*     */   private int field_76715_g;
/*     */   private long field_76721_h;
/*     */   private static final String __OBFID = "CL_00000381";
/*     */   
/*     */   public RegionFile(File p_i2001_1_) {
/*  87 */     this.field_76716_d = new int[1024];
/*  88 */     this.field_76717_e = new int[1024];
/*     */     
/*  90 */     this.field_76718_b = p_i2001_1_;
/*     */     
/*  92 */     this.field_76715_g = 0;
/*     */     
/*     */     try {
/*  95 */       if (p_i2001_1_.exists()) {
/*  96 */         this.field_76721_h = p_i2001_1_.lastModified();
/*     */       }
/*     */       
/*  99 */       this.field_76719_c = new RandomAccessFile(p_i2001_1_, "rw");
/*     */       
/* 101 */       if (this.field_76719_c.length() < 4096L) {
/*     */         byte b1;
/* 103 */         for (b1 = 0; b1 < 'Ѐ'; b1++) {
/* 104 */           this.field_76719_c.writeInt(0);
/*     */         }
/*     */         
/* 107 */         for (b1 = 0; b1 < 'Ѐ'; b1++) {
/* 108 */           this.field_76719_c.writeInt(0);
/*     */         }
/*     */         
/* 111 */         this.field_76715_g += 8192;
/*     */       } 
/*     */       
/* 114 */       if ((this.field_76719_c.length() & 0xFFFL) != 0L)
/*     */       {
/* 116 */         for (byte b1 = 0; b1 < (this.field_76719_c.length() & 0xFFFL); b1++) {
/* 117 */           this.field_76719_c.write(0);
/*     */         }
/*     */       }
/*     */ 
/*     */       
/* 122 */       int i = (int)this.field_76719_c.length() / 4096;
/* 123 */       this.field_76714_f = new ArrayList(i);
/*     */       byte b;
/* 125 */       for (b = 0; b < i; b++) {
/* 126 */         this.field_76714_f.add(Boolean.valueOf(true));
/*     */       }
/*     */       
/* 129 */       this.field_76714_f.set(0, Boolean.valueOf(false));
/* 130 */       this.field_76714_f.set(1, Boolean.valueOf(false));
/*     */       
/* 132 */       this.field_76719_c.seek(0L);
/* 133 */       for (b = 0; b < 'Ѐ'; b++) {
/* 134 */         int j = this.field_76719_c.readInt();
/* 135 */         this.field_76716_d[b] = j;
/* 136 */         if (j != 0 && (j >> 8) + (j & 0xFF) <= this.field_76714_f.size()) {
/* 137 */           for (byte b1 = 0; b1 < (j & 0xFF); b1++) {
/* 138 */             this.field_76714_f.set((j >> 8) + b1, Boolean.valueOf(false));
/*     */           }
/*     */         }
/*     */       } 
/* 142 */       for (b = 0; b < 'Ѐ'; b++) {
/* 143 */         int j = this.field_76719_c.readInt();
/* 144 */         this.field_76717_e[b] = j;
/*     */       } 
/* 146 */     } catch (IOException iOException) {
/* 147 */       iOException.printStackTrace();
/*     */     } 
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
/*     */   public synchronized DataInputStream func_76704_a(int p_76704_1_, int p_76704_2_) {
/* 168 */     if (func_76705_d(p_76704_1_, p_76704_2_)) {
/* 169 */       return null;
/*     */     }
/*     */     
/*     */     try {
/* 173 */       int i = func_76707_e(p_76704_1_, p_76704_2_);
/* 174 */       if (i == 0) {
/* 175 */         return null;
/*     */       }
/*     */       
/* 178 */       int j = i >> 8;
/* 179 */       int k = i & 0xFF;
/*     */       
/* 181 */       if (j + k > this.field_76714_f.size()) {
/* 182 */         return null;
/*     */       }
/*     */       
/* 185 */       this.field_76719_c.seek((j * 4096));
/* 186 */       int m = this.field_76719_c.readInt();
/*     */       
/* 188 */       if (m > 4096 * k)
/* 189 */         return null; 
/* 190 */       if (m <= 0) {
/* 191 */         return null;
/*     */       }
/*     */       
/* 194 */       byte b = this.field_76719_c.readByte();
/* 195 */       if (b == 1) {
/* 196 */         byte[] arrayOfByte = new byte[m - 1];
/* 197 */         this.field_76719_c.read(arrayOfByte);
/* 198 */         return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(arrayOfByte))));
/* 199 */       }  if (b == 2) {
/* 200 */         byte[] arrayOfByte = new byte[m - 1];
/* 201 */         this.field_76719_c.read(arrayOfByte);
/* 202 */         return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(arrayOfByte))));
/*     */       } 
/*     */       
/* 205 */       return null;
/* 206 */     } catch (IOException iOException) {
/* 207 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public DataOutputStream func_76710_b(int p_76710_1_, int p_76710_2_) {
/* 212 */     if (func_76705_d(p_76710_1_, p_76710_2_)) return null;
/*     */     
/* 214 */     return new DataOutputStream(new DeflaterOutputStream(new ChunkBuffer(this, p_76710_1_, p_76710_2_)));
/*     */   }
/*     */   
/*     */   class ChunkBuffer
/*     */     extends ByteArrayOutputStream
/*     */   {
/*     */     private int field_76722_b;
/*     */     private int field_76723_c;
/*     */     private static final String __OBFID = "CL_00000382";
/*     */     
/*     */     public ChunkBuffer(RegionFile p_i2000_1_, int p_i2000_2_, int p_i2000_3_) {
/* 225 */       super(8096);
/* 226 */       this.field_76722_b = p_i2000_2_;
/* 227 */       this.field_76723_c = p_i2000_3_;
/*     */     }
/*     */ 
/*     */     
/*     */     public void close() throws IOException {
/* 232 */       this.field_76724_a.func_76706_a(this.field_76722_b, this.field_76723_c, this.buf, this.count);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected synchronized void func_76706_a(int p_76706_1_, int p_76706_2_, byte[] p_76706_3_, int p_76706_4_) {
/*     */     try {
/* 239 */       int i = func_76707_e(p_76706_1_, p_76706_2_);
/* 240 */       int j = i >> 8;
/* 241 */       int k = i & 0xFF;
/* 242 */       int m = (p_76706_4_ + 5) / 4096 + 1;
/*     */ 
/*     */       
/* 245 */       if (m >= 256) {
/*     */         return;
/*     */       }
/*     */       
/* 249 */       if (j != 0 && k == m) {
/*     */         
/* 251 */         func_76712_a(j, p_76706_3_, p_76706_4_);
/*     */       } else {
/*     */         int n;
/*     */ 
/*     */         
/* 256 */         for (n = 0; n < k; n++) {
/* 257 */           this.field_76714_f.set(j + n, Boolean.valueOf(true));
/*     */         }
/*     */ 
/*     */         
/* 261 */         n = this.field_76714_f.indexOf(Boolean.valueOf(true));
/* 262 */         byte b = 0;
/* 263 */         if (n != -1) {
/* 264 */           for (int i1 = n; i1 < this.field_76714_f.size(); i1++) {
/* 265 */             if (b) {
/* 266 */               if (((Boolean)this.field_76714_f.get(i1)).booleanValue()) { b++; }
/* 267 */               else { b = 0; } 
/* 268 */             } else if (((Boolean)this.field_76714_f.get(i1)).booleanValue()) {
/* 269 */               n = i1;
/* 270 */               b = 1;
/*     */             } 
/* 272 */             if (b >= m) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         }
/*     */         
/* 278 */         if (b >= m) {
/*     */           
/* 280 */           j = n;
/* 281 */           func_76711_a(p_76706_1_, p_76706_2_, j << 8 | m);
/* 282 */           for (byte b1 = 0; b1 < m; b1++) {
/* 283 */             this.field_76714_f.set(j + b1, Boolean.valueOf(false));
/*     */           }
/* 285 */           func_76712_a(j, p_76706_3_, p_76706_4_);
/*     */         } else {
/*     */           
/* 288 */           this.field_76719_c.seek(this.field_76719_c.length());
/* 289 */           j = this.field_76714_f.size();
/* 290 */           for (byte b1 = 0; b1 < m; b1++) {
/* 291 */             this.field_76719_c.write(field_76720_a);
/* 292 */             this.field_76714_f.add(Boolean.valueOf(false));
/*     */           } 
/* 294 */           this.field_76715_g += 4096 * m;
/*     */           
/* 296 */           func_76712_a(j, p_76706_3_, p_76706_4_);
/* 297 */           func_76711_a(p_76706_1_, p_76706_2_, j << 8 | m);
/*     */         } 
/*     */       } 
/* 300 */       func_76713_b(p_76706_1_, p_76706_2_, (int)(MinecraftServer.func_130071_aq() / 1000L));
/* 301 */     } catch (IOException iOException) {
/* 302 */       iOException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_76712_a(int p_76712_1_, byte[] p_76712_2_, int p_76712_3_) throws IOException {
/* 308 */     this.field_76719_c.seek((p_76712_1_ * 4096));
/* 309 */     this.field_76719_c.writeInt(p_76712_3_ + 1);
/* 310 */     this.field_76719_c.writeByte(2);
/* 311 */     this.field_76719_c.write(p_76712_2_, 0, p_76712_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_76705_d(int p_76705_1_, int p_76705_2_) {
/* 316 */     return (p_76705_1_ < 0 || p_76705_1_ >= 32 || p_76705_2_ < 0 || p_76705_2_ >= 32);
/*     */   }
/*     */   
/*     */   private int func_76707_e(int p_76707_1_, int p_76707_2_) {
/* 320 */     return this.field_76716_d[p_76707_1_ + p_76707_2_ * 32];
/*     */   }
/*     */   
/*     */   public boolean func_76709_c(int p_76709_1_, int p_76709_2_) {
/* 324 */     return (func_76707_e(p_76709_1_, p_76709_2_) != 0);
/*     */   }
/*     */   
/*     */   private void func_76711_a(int p_76711_1_, int p_76711_2_, int p_76711_3_) throws IOException {
/* 328 */     this.field_76716_d[p_76711_1_ + p_76711_2_ * 32] = p_76711_3_;
/* 329 */     this.field_76719_c.seek(((p_76711_1_ + p_76711_2_ * 32) * 4));
/* 330 */     this.field_76719_c.writeInt(p_76711_3_);
/*     */   }
/*     */   
/*     */   private void func_76713_b(int p_76713_1_, int p_76713_2_, int p_76713_3_) throws IOException {
/* 334 */     this.field_76717_e[p_76713_1_ + p_76713_2_ * 32] = p_76713_3_;
/* 335 */     this.field_76719_c.seek((4096 + (p_76713_1_ + p_76713_2_ * 32) * 4));
/* 336 */     this.field_76719_c.writeInt(p_76713_3_);
/*     */   }
/*     */   
/*     */   public void func_76708_c() throws IOException {
/* 340 */     if (this.field_76719_c != null) this.field_76719_c.close(); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\RegionFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */