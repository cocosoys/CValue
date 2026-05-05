/*     */ package net.minecraft.world;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.LongHashMap;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class Teleporter {
/*     */   private final WorldServer field_85192_a;
/*  15 */   private final LongHashMap field_85191_c = new LongHashMap(); private final Random field_77187_a;
/*  16 */   private final List field_85190_d = new ArrayList(); private static final String __OBFID = "CL_00000153";
/*     */   
/*     */   public Teleporter(WorldServer p_i1963_1_) {
/*  19 */     this.field_85192_a = p_i1963_1_;
/*  20 */     this.field_77187_a = new Random(p_i1963_1_.func_72905_C());
/*     */   }
/*     */   
/*     */   public void func_77185_a(Entity p_77185_1_, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_) {
/*  24 */     if (this.field_85192_a.field_73011_w.field_76574_g == 1) {
/*  25 */       int i = MathHelper.func_76128_c(p_77185_1_.field_70165_t);
/*  26 */       int j = MathHelper.func_76128_c(p_77185_1_.field_70163_u) - 1;
/*  27 */       int k = MathHelper.func_76128_c(p_77185_1_.field_70161_v);
/*     */       
/*  29 */       byte b1 = 1;
/*  30 */       byte b2 = 0;
/*  31 */       for (byte b = -2; b <= 2; b++) {
/*  32 */         for (byte b3 = -2; b3 <= 2; b3++) {
/*  33 */           for (byte b4 = -1; b4 < 3; b4++) {
/*  34 */             int m = i + b3 * b1 + b * b2;
/*  35 */             int n = j + b4;
/*  36 */             int i1 = k + b3 * b2 - b * b1;
/*     */             
/*  38 */             boolean bool = (b4 < 0) ? true : false;
/*     */             
/*  40 */             this.field_85192_a.func_147449_b(m, n, i1, bool ? Blocks.field_150343_Z : Blocks.field_150350_a);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  45 */       p_77185_1_.func_70012_b(i, j, k, p_77185_1_.field_70177_z, 0.0F);
/*  46 */       p_77185_1_.field_70159_w = p_77185_1_.field_70181_x = p_77185_1_.field_70179_y = 0.0D;
/*     */       
/*     */       return;
/*     */     } 
/*  50 */     if (func_77184_b(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_)) {
/*     */       return;
/*     */     }
/*     */     
/*  54 */     func_85188_a(p_77185_1_);
/*  55 */     func_77184_b(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_);
/*     */   }
/*     */   
/*     */   public boolean func_77184_b(Entity p_77184_1_, double p_77184_2_, double p_77184_4_, double p_77184_6_, float p_77184_8_) {
/*  59 */     char c = '';
/*  60 */     double d = -1.0D;
/*  61 */     int i = 0;
/*  62 */     int j = 0;
/*  63 */     int k = 0;
/*     */     
/*  65 */     int m = MathHelper.func_76128_c(p_77184_1_.field_70165_t);
/*  66 */     int n = MathHelper.func_76128_c(p_77184_1_.field_70161_v);
/*  67 */     long l = ChunkCoordIntPair.func_77272_a(m, n);
/*  68 */     boolean bool = true;
/*     */     
/*  70 */     if (this.field_85191_c.func_76161_b(l)) {
/*  71 */       PortalPosition portalPosition = (PortalPosition)this.field_85191_c.func_76164_a(l);
/*     */       
/*  73 */       d = 0.0D;
/*  74 */       i = portalPosition.field_71574_a;
/*  75 */       j = portalPosition.field_71572_b;
/*  76 */       k = portalPosition.field_71573_c;
/*  77 */       portalPosition.field_85087_d = this.field_85192_a.func_82737_E();
/*  78 */       bool = false;
/*     */     } else {
/*  80 */       for (int i1 = m - c; i1 <= m + c; i1++) {
/*  81 */         double d1 = i1 + 0.5D - p_77184_1_.field_70165_t;
/*  82 */         for (int i2 = n - c; i2 <= n + c; i2++) {
/*  83 */           double d2 = i2 + 0.5D - p_77184_1_.field_70161_v;
/*  84 */           for (int i3 = this.field_85192_a.func_72940_L() - 1; i3 >= 0; i3--) {
/*  85 */             if (this.field_85192_a.func_147439_a(i1, i3, i2) == Blocks.field_150427_aO) {
/*  86 */               while (this.field_85192_a.func_147439_a(i1, i3 - 1, i2) == Blocks.field_150427_aO) {
/*  87 */                 i3--;
/*     */               }
/*     */               
/*  90 */               double d3 = i3 + 0.5D - p_77184_1_.field_70163_u;
/*  91 */               double d4 = d1 * d1 + d3 * d3 + d2 * d2;
/*  92 */               if (d < 0.0D || d4 < d) {
/*  93 */                 d = d4;
/*  94 */                 i = i1;
/*  95 */                 j = i3;
/*  96 */                 k = i2;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 104 */     if (d >= 0.0D) {
/* 105 */       int i1 = i;
/* 106 */       int i2 = j;
/* 107 */       int i3 = k;
/*     */       
/* 109 */       if (bool) {
/* 110 */         this.field_85191_c.func_76163_a(l, new PortalPosition(this, i1, i2, i3, this.field_85192_a.func_82737_E()));
/* 111 */         this.field_85190_d.add(Long.valueOf(l));
/*     */       } 
/*     */       
/* 114 */       double d1 = i1 + 0.5D;
/* 115 */       double d2 = i2 + 0.5D;
/* 116 */       double d3 = i3 + 0.5D;
/* 117 */       int i4 = -1;
/*     */       
/* 119 */       if (this.field_85192_a.func_147439_a(i1 - 1, i2, i3) == Blocks.field_150427_aO) i4 = 2; 
/* 120 */       if (this.field_85192_a.func_147439_a(i1 + 1, i2, i3) == Blocks.field_150427_aO) i4 = 0; 
/* 121 */       if (this.field_85192_a.func_147439_a(i1, i2, i3 - 1) == Blocks.field_150427_aO) i4 = 3; 
/* 122 */       if (this.field_85192_a.func_147439_a(i1, i2, i3 + 1) == Blocks.field_150427_aO) i4 = 1;
/*     */       
/* 124 */       int i5 = p_77184_1_.func_82148_at();
/*     */       
/* 126 */       if (i4 > -1) {
/* 127 */         int i6 = Direction.field_71578_g[i4];
/* 128 */         int i7 = Direction.field_71583_a[i4];
/* 129 */         int i8 = Direction.field_71581_b[i4];
/* 130 */         int i9 = Direction.field_71583_a[i6];
/* 131 */         int i10 = Direction.field_71581_b[i6];
/*     */         
/* 133 */         boolean bool1 = (!this.field_85192_a.func_147437_c(i1 + i7 + i9, i2, i3 + i8 + i10) || !this.field_85192_a.func_147437_c(i1 + i7 + i9, i2 + 1, i3 + i8 + i10)) ? true : false;
/* 134 */         boolean bool2 = (!this.field_85192_a.func_147437_c(i1 + i7, i2, i3 + i8) || !this.field_85192_a.func_147437_c(i1 + i7, i2 + 1, i3 + i8)) ? true : false;
/*     */         
/* 136 */         if (bool1 && bool2) {
/* 137 */           i4 = Direction.field_71580_e[i4];
/* 138 */           i6 = Direction.field_71580_e[i6];
/* 139 */           i7 = Direction.field_71583_a[i4];
/* 140 */           i8 = Direction.field_71581_b[i4];
/* 141 */           i9 = Direction.field_71583_a[i6];
/* 142 */           i10 = Direction.field_71581_b[i6];
/*     */           
/* 144 */           i1 -= i9;
/* 145 */           d1 -= i9;
/* 146 */           i3 -= i10;
/* 147 */           d3 -= i10;
/* 148 */           bool1 = (!this.field_85192_a.func_147437_c(i1 + i7 + i9, i2, i3 + i8 + i10) || !this.field_85192_a.func_147437_c(i1 + i7 + i9, i2 + 1, i3 + i8 + i10)) ? true : false;
/* 149 */           bool2 = (!this.field_85192_a.func_147437_c(i1 + i7, i2, i3 + i8) || !this.field_85192_a.func_147437_c(i1 + i7, i2 + 1, i3 + i8)) ? true : false;
/*     */         } 
/*     */         
/* 152 */         float f1 = 0.5F;
/* 153 */         float f2 = 0.5F;
/*     */         
/* 155 */         if (!bool1 && bool2) {
/* 156 */           f1 = 1.0F;
/* 157 */         } else if (bool1 && !bool2) {
/* 158 */           f1 = 0.0F;
/* 159 */         } else if (bool1 && bool2) {
/* 160 */           f2 = 0.0F;
/*     */         } 
/*     */ 
/*     */         
/* 164 */         d1 += (i9 * f1 + f2 * i7);
/* 165 */         d3 += (i10 * f1 + f2 * i8);
/*     */         
/* 167 */         float f3 = 0.0F;
/* 168 */         float f4 = 0.0F;
/* 169 */         float f5 = 0.0F;
/* 170 */         float f6 = 0.0F;
/*     */         
/* 172 */         if (i4 == i5) {
/* 173 */           f3 = 1.0F;
/* 174 */           f4 = 1.0F;
/* 175 */         } else if (i4 == Direction.field_71580_e[i5]) {
/* 176 */           f3 = -1.0F;
/* 177 */           f4 = -1.0F;
/* 178 */         } else if (i4 == Direction.field_71577_f[i5]) {
/* 179 */           f5 = 1.0F;
/* 180 */           f6 = -1.0F;
/*     */         } else {
/* 182 */           f5 = -1.0F;
/* 183 */           f6 = 1.0F;
/*     */         } 
/*     */         
/* 186 */         double d4 = p_77184_1_.field_70159_w;
/* 187 */         double d5 = p_77184_1_.field_70179_y;
/* 188 */         p_77184_1_.field_70159_w = d4 * f3 + d5 * f6;
/* 189 */         p_77184_1_.field_70179_y = d4 * f5 + d5 * f4;
/* 190 */         p_77184_1_.field_70177_z = p_77184_8_ - (i5 * 90) + (i4 * 90);
/*     */       } else {
/* 192 */         p_77184_1_.field_70159_w = p_77184_1_.field_70181_x = p_77184_1_.field_70179_y = 0.0D;
/*     */       } 
/*     */       
/* 195 */       p_77184_1_.func_70012_b(d1, d2, d3, p_77184_1_.field_70177_z, p_77184_1_.field_70125_A);
/* 196 */       return true;
/*     */     } 
/*     */     
/* 199 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_85188_a(Entity p_85188_1_) {
/* 203 */     byte b1 = 16;
/* 204 */     double d = -1.0D;
/*     */     
/* 206 */     int i = MathHelper.func_76128_c(p_85188_1_.field_70165_t);
/* 207 */     int j = MathHelper.func_76128_c(p_85188_1_.field_70163_u);
/* 208 */     int k = MathHelper.func_76128_c(p_85188_1_.field_70161_v);
/*     */     
/* 210 */     int m = i;
/* 211 */     int n = j;
/* 212 */     int i1 = k;
/* 213 */     int i2 = 0;
/*     */     
/* 215 */     int i3 = this.field_77187_a.nextInt(4);
/*     */     int i4;
/* 217 */     for (i4 = i - b1; i4 <= i + b1; i4++) {
/* 218 */       double d1 = i4 + 0.5D - p_85188_1_.field_70165_t;
/* 219 */       for (int i10 = k - b1; i10 <= k + b1; i10++) {
/* 220 */         double d2 = i10 + 0.5D - p_85188_1_.field_70161_v; int i11;
/* 221 */         label175: for (i11 = this.field_85192_a.func_72940_L() - 1; i11 >= 0; i11--) {
/* 222 */           if (this.field_85192_a.func_147437_c(i4, i11, i10)) {
/* 223 */             while (i11 > 0 && this.field_85192_a.func_147437_c(i4, i11 - 1, i10)) {
/* 224 */               i11--;
/*     */             }
/*     */             
/* 227 */             for (int i12 = i3; i12 < i3 + 4; i12++) {
/* 228 */               int i13 = i12 % 2;
/* 229 */               int i14 = 1 - i13;
/*     */               
/* 231 */               if (i12 % 4 >= 2) {
/* 232 */                 i13 = -i13;
/* 233 */                 i14 = -i14;
/*     */               } 
/*     */               
/* 236 */               for (byte b = 0; b < 3; b++) {
/* 237 */                 for (byte b3 = 0; b3 < 4; b3++) {
/* 238 */                   for (byte b4 = -1; b4 < 4; b4++) {
/* 239 */                     int i15 = i4 + (b3 - 1) * i13 + b * i14;
/* 240 */                     int i16 = i11 + b4;
/* 241 */                     int i17 = i10 + (b3 - 1) * i14 - b * i13;
/*     */                     
/* 243 */                     if (b4 < 0 && !this.field_85192_a.func_147439_a(i15, i16, i17).func_149688_o().func_76220_a())
/* 244 */                       continue label175;  if (b4 >= 0 && !this.field_85192_a.func_147437_c(i15, i16, i17))
/*     */                       continue label175; 
/*     */                   } 
/*     */                 } 
/*     */               } 
/* 249 */               double d3 = i11 + 0.5D - p_85188_1_.field_70163_u;
/* 250 */               double d4 = d1 * d1 + d3 * d3 + d2 * d2;
/* 251 */               if (d < 0.0D || d4 < d) {
/* 252 */                 d = d4;
/* 253 */                 m = i4;
/* 254 */                 n = i11;
/* 255 */                 i1 = i10;
/* 256 */                 i2 = i12 % 4;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 263 */     if (d < 0.0D) {
/* 264 */       for (i4 = i - b1; i4 <= i + b1; i4++) {
/* 265 */         double d1 = i4 + 0.5D - p_85188_1_.field_70165_t;
/* 266 */         for (int i10 = k - b1; i10 <= k + b1; i10++) {
/* 267 */           double d2 = i10 + 0.5D - p_85188_1_.field_70161_v; int i11;
/* 268 */           label172: for (i11 = this.field_85192_a.func_72940_L() - 1; i11 >= 0; i11--) {
/* 269 */             if (this.field_85192_a.func_147437_c(i4, i11, i10)) {
/* 270 */               while (i11 > 0 && this.field_85192_a.func_147437_c(i4, i11 - 1, i10)) {
/* 271 */                 i11--;
/*     */               }
/*     */               
/* 274 */               for (int i12 = i3; i12 < i3 + 2; i12++) {
/* 275 */                 int i13 = i12 % 2;
/* 276 */                 int i14 = 1 - i13;
/* 277 */                 for (byte b = 0; b < 4; b++) {
/* 278 */                   for (byte b3 = -1; b3 < 4; b3++) {
/* 279 */                     int i15 = i4 + (b - 1) * i13;
/* 280 */                     int i16 = i11 + b3;
/* 281 */                     int i17 = i10 + (b - 1) * i14;
/*     */                     
/* 283 */                     if (b3 < 0 && !this.field_85192_a.func_147439_a(i15, i16, i17).func_149688_o().func_76220_a())
/* 284 */                       continue label172;  if (b3 >= 0 && !this.field_85192_a.func_147437_c(i15, i16, i17))
/*     */                       continue label172; 
/*     */                   } 
/*     */                 } 
/* 288 */                 double d3 = i11 + 0.5D - p_85188_1_.field_70163_u;
/* 289 */                 double d4 = d1 * d1 + d3 * d3 + d2 * d2;
/* 290 */                 if (d < 0.0D || d4 < d) {
/* 291 */                   d = d4;
/* 292 */                   m = i4;
/* 293 */                   n = i11;
/* 294 */                   i1 = i10;
/* 295 */                   i2 = i12 % 2;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 304 */     i4 = i2;
/*     */     
/* 306 */     int i5 = m;
/* 307 */     int i6 = n;
/* 308 */     int i7 = i1;
/*     */     
/* 310 */     int i8 = i4 % 2;
/* 311 */     int i9 = 1 - i8;
/*     */     
/* 313 */     if (i4 % 4 >= 2) {
/* 314 */       i8 = -i8;
/* 315 */       i9 = -i9;
/*     */     } 
/*     */     
/* 318 */     if (d < 0.0D) {
/* 319 */       if (n < 70) n = 70; 
/* 320 */       if (n > this.field_85192_a.func_72940_L() - 10) n = this.field_85192_a.func_72940_L() - 10; 
/* 321 */       i6 = n;
/*     */       
/* 323 */       for (byte b = -1; b <= 1; b++) {
/* 324 */         for (byte b3 = 1; b3 < 3; b3++) {
/* 325 */           for (byte b4 = -1; b4 < 3; b4++) {
/* 326 */             int i10 = i5 + (b3 - 1) * i8 + b * i9;
/* 327 */             int i11 = i6 + b4;
/* 328 */             int i12 = i7 + (b3 - 1) * i9 - b * i8;
/*     */             
/* 330 */             boolean bool = (b4 < 0) ? true : false;
/*     */             
/* 332 */             this.field_85192_a.func_147449_b(i10, i11, i12, bool ? Blocks.field_150343_Z : Blocks.field_150350_a);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 338 */     for (byte b2 = 0; b2 < 4; b2++) {
/* 339 */       byte b; for (b = 0; b < 4; b++) {
/* 340 */         for (byte b3 = -1; b3 < 4; b3++) {
/* 341 */           int i10 = i5 + (b - 1) * i8;
/* 342 */           int i11 = i6 + b3;
/* 343 */           int i12 = i7 + (b - 1) * i9;
/*     */           
/* 345 */           boolean bool = (b == 0 || b == 3 || b3 == -1 || b3 == 3) ? true : false;
/* 346 */           this.field_85192_a.func_147465_d(i10, i11, i12, bool ? Blocks.field_150343_Z : (Block)Blocks.field_150427_aO, 0, 2);
/*     */         } 
/*     */       } 
/*     */       
/* 350 */       for (b = 0; b < 4; b++) {
/* 351 */         for (byte b3 = -1; b3 < 4; b3++) {
/* 352 */           int i10 = i5 + (b - 1) * i8;
/* 353 */           int i11 = i6 + b3;
/* 354 */           int i12 = i7 + (b - 1) * i9;
/*     */           
/* 356 */           this.field_85192_a.func_147459_d(i10, i11, i12, this.field_85192_a.func_147439_a(i10, i11, i12));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 361 */     return true;
/*     */   }
/*     */   
/*     */   public void func_85189_a(long p_85189_1_) {
/* 365 */     if (p_85189_1_ % 100L == 0L) {
/* 366 */       Iterator<Long> iterator = this.field_85190_d.iterator();
/* 367 */       long l = p_85189_1_ - 600L;
/*     */       
/* 369 */       while (iterator.hasNext()) {
/* 370 */         Long long_ = iterator.next();
/* 371 */         PortalPosition portalPosition = (PortalPosition)this.field_85191_c.func_76164_a(long_.longValue());
/*     */         
/* 373 */         if (portalPosition == null || portalPosition.field_85087_d < l) {
/* 374 */           iterator.remove();
/* 375 */           this.field_85191_c.func_76159_d(long_.longValue());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public class PortalPosition extends ChunkCoordinates { public long field_85087_d;
/*     */     private static final String __OBFID = "CL_00000154";
/*     */     
/*     */     public PortalPosition(Teleporter p_i1962_1_, int p_i1962_2_, int p_i1962_3_, int p_i1962_4_, long p_i1962_5_) {
/* 385 */       super(p_i1962_2_, p_i1962_3_, p_i1962_4_);
/* 386 */       this.field_85087_d = p_i1962_5_;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\Teleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */