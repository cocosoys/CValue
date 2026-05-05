/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkSection
/*     */ {
/*     */   private int yPos;
/*     */   private int nonEmptyBlockCount;
/*     */   private int tickingBlockCount;
/*     */   private byte[] blockIds;
/*     */   private NibbleArray extBlockIds;
/*     */   private NibbleArray blockData;
/*     */   private NibbleArray emittedLight;
/*     */   private NibbleArray skyLight;
/*     */   private int compactId;
/*     */   private byte compactExtId;
/*     */   private byte compactData;
/*     */   private byte compactEmitted;
/*     */   private byte compactSky;
/*  23 */   private static NibbleArray[] compactPregen = new NibbleArray[16];
/*     */   static {
/*  25 */     for (int i = 0; i < 16; i++) {
/*  26 */       compactPregen[i] = expandCompactNibble((byte)i);
/*     */     }
/*     */   }
/*     */   
/*     */   private static NibbleArray expandCompactNibble(byte value) {
/*  31 */     byte[] data = new byte[2048];
/*  32 */     Arrays.fill(data, (byte)(value | value << 4));
/*  33 */     return new NibbleArray(data, 4);
/*     */   }
/*     */   
/*     */   private boolean canBeCompact(byte[] array) {
/*  37 */     byte value = array[0];
/*  38 */     for (int i = 1; i < array.length; i++) {
/*  39 */       if (value != array[i]) {
/*  40 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  44 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkSection(int i, boolean flag) {
/*  49 */     this.yPos = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     if (!flag) {
/*  59 */       this.compactSky = -1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkSection(int y, boolean flag, byte[] blkIds, byte[] extBlkIds) {
/*  66 */     this.yPos = y;
/*  67 */     setIdArray(blkIds);
/*  68 */     if (extBlkIds != null) {
/*  69 */       setExtendedIdArray(new NibbleArray(extBlkIds, 4));
/*     */     }
/*  71 */     if (!flag) {
/*  72 */       this.compactSky = -1;
/*     */     }
/*  74 */     recalcBlockCounts();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Block getTypeId(int i, int j, int k) {
/*  80 */     if (this.blockIds == null) {
/*  81 */       int id = this.compactId;
/*  82 */       if (this.extBlockIds == null) {
/*  83 */         id |= this.compactExtId << 8;
/*     */       } else {
/*  85 */         id |= this.extBlockIds.a(i, j, k) << 8;
/*     */       } 
/*     */       
/*  88 */       return Block.getById(id);
/*     */     } 
/*     */ 
/*     */     
/*  92 */     int l = this.blockIds[j << 8 | k << 4 | i] & 0xFF;
/*     */     
/*  94 */     if (this.extBlockIds != null) {
/*  95 */       l |= this.extBlockIds.a(i, j, k) << 8;
/*     */     }
/*     */     
/*  98 */     return Block.getById(l);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTypeId(int i, int j, int k, Block block) {
/* 103 */     Block block1 = getTypeId(i, j, k);
/* 104 */     if (block == block1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 109 */     if (block1 != Blocks.AIR) {
/* 110 */       this.nonEmptyBlockCount--;
/* 111 */       if (block1.isTicking()) {
/* 112 */         this.tickingBlockCount--;
/*     */       }
/*     */     } 
/*     */     
/* 116 */     if (block != Blocks.AIR) {
/* 117 */       this.nonEmptyBlockCount++;
/* 118 */       if (block.isTicking()) {
/* 119 */         this.tickingBlockCount++;
/*     */       }
/*     */     } 
/*     */     
/* 123 */     int i1 = Block.getId(block);
/*     */ 
/*     */     
/* 126 */     if (this.blockIds == null) {
/* 127 */       this.blockIds = new byte[4096];
/* 128 */       Arrays.fill(this.blockIds, (byte)(this.compactId & 0xFF));
/*     */     } 
/*     */ 
/*     */     
/* 132 */     this.blockIds[j << 8 | k << 4 | i] = (byte)(i1 & 0xFF);
/* 133 */     if (i1 > 255) {
/* 134 */       if (this.extBlockIds == null) {
/* 135 */         this.extBlockIds = expandCompactNibble(this.compactExtId);
/*     */       }
/*     */       
/* 138 */       this.extBlockIds.a(i, j, k, (i1 & 0xF00) >> 8);
/* 139 */     } else if (this.extBlockIds != null) {
/* 140 */       this.extBlockIds.a(i, j, k, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getData(int i, int j, int k) {
/* 146 */     if (this.blockData == null) {
/* 147 */       return this.compactData;
/*     */     }
/*     */     
/* 150 */     return this.blockData.a(i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setData(int i, int j, int k, int l) {
/* 155 */     if (this.blockData == null) {
/* 156 */       if (this.compactData == l) {
/*     */         return;
/*     */       }
/* 159 */       this.blockData = expandCompactNibble(this.compactData);
/*     */     } 
/*     */     
/* 162 */     this.blockData.a(i, j, k, l);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 166 */     return (this.nonEmptyBlockCount == 0);
/*     */   }
/*     */   
/*     */   public boolean shouldTick() {
/* 170 */     return (this.tickingBlockCount > 0);
/*     */   }
/*     */   
/*     */   public int getYPosition() {
/* 174 */     return this.yPos;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSkyLight(int i, int j, int k, int l) {
/* 179 */     if (this.skyLight == null) {
/* 180 */       if (this.compactSky == l) {
/*     */         return;
/*     */       }
/* 183 */       this.skyLight = expandCompactNibble(this.compactSky);
/*     */     } 
/*     */     
/* 186 */     this.skyLight.a(i, j, k, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSkyLight(int i, int j, int k) {
/* 191 */     if (this.skyLight == null) {
/* 192 */       return this.compactSky;
/*     */     }
/*     */     
/* 195 */     return this.skyLight.a(i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEmittedLight(int i, int j, int k, int l) {
/* 200 */     if (this.emittedLight == null) {
/* 201 */       if (this.compactEmitted == l) {
/*     */         return;
/*     */       }
/* 204 */       this.emittedLight = expandCompactNibble(this.compactEmitted);
/*     */     } 
/*     */     
/* 207 */     this.emittedLight.a(i, j, k, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getEmittedLight(int i, int j, int k) {
/* 212 */     if (this.emittedLight == null) {
/* 213 */       return this.compactEmitted;
/*     */     }
/*     */     
/* 216 */     return this.emittedLight.a(i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public void recalcBlockCounts() {
/* 221 */     int cntNonEmpty = 0;
/* 222 */     int cntTicking = 0;
/*     */     
/* 224 */     if (this.blockIds == null) {
/* 225 */       int id = this.compactId;
/* 226 */       if (this.extBlockIds == null) {
/* 227 */         id |= this.compactExtId << 8;
/* 228 */         if (id > 0) {
/* 229 */           Block block = Block.getById(id);
/* 230 */           if (block == null) {
/* 231 */             this.compactId = 0;
/* 232 */             this.compactExtId = 0;
/*     */           } else {
/* 234 */             cntNonEmpty = 4096;
/* 235 */             if (block.isTicking()) {
/* 236 */               cntTicking = 4096;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } else {
/* 241 */         byte[] ext = this.extBlockIds.a;
/* 242 */         for (int off = 0, off2 = 0; off < 4096; ) {
/* 243 */           byte extid = ext[off2];
/* 244 */           int l = id & 0xFF | (extid & 0xF) << 8;
/* 245 */           if (l > 0) {
/* 246 */             Block block = Block.getById(l);
/* 247 */             if (block == null) {
/* 248 */               this.compactId = 0;
/* 249 */               ext[off2] = (byte)(ext[off2] & 0xF0);
/*     */             } else {
/* 251 */               cntNonEmpty++;
/* 252 */               if (block.isTicking()) {
/* 253 */                 cntTicking++;
/*     */               }
/*     */             } 
/*     */           } 
/* 257 */           off++;
/* 258 */           l = id & 0xFF | (extid & 0xF0) << 4;
/* 259 */           if (l > 0) {
/* 260 */             Block block = Block.getById(l);
/* 261 */             if (block == null) {
/* 262 */               this.compactId = 0;
/* 263 */               ext[off2] = (byte)(ext[off2] & 0xF);
/*     */             } else {
/* 265 */               cntNonEmpty++;
/* 266 */               if (block.isTicking()) {
/* 267 */                 cntTicking++;
/*     */               }
/*     */             } 
/*     */           } 
/* 271 */           off++;
/* 272 */           off2++;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 276 */       byte[] blkIds = this.blockIds;
/* 277 */       if (this.extBlockIds == null) {
/* 278 */         for (int off = 0; off < blkIds.length; off++) {
/* 279 */           int l = blkIds[off] & 0xFF;
/* 280 */           if (l > 0) {
/* 281 */             if (Block.getById(l) == null) {
/* 282 */               blkIds[off] = 0;
/*     */             } else {
/* 284 */               cntNonEmpty++;
/* 285 */               if (Block.getById(l).isTicking()) {
/* 286 */                 cntTicking++;
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } else {
/* 292 */         byte[] ext = this.extBlockIds.a;
/* 293 */         for (int off = 0, off2 = 0; off < blkIds.length; ) {
/* 294 */           byte extid = ext[off2];
/* 295 */           int l = blkIds[off] & 0xFF | (extid & 0xF) << 8;
/* 296 */           if (l > 0) {
/* 297 */             if (Block.getById(l) == null) {
/* 298 */               blkIds[off] = 0;
/* 299 */               ext[off2] = (byte)(ext[off2] & 0xF0);
/*     */             } else {
/* 301 */               cntNonEmpty++;
/* 302 */               if (Block.getById(l).isTicking()) {
/* 303 */                 cntTicking++;
/*     */               }
/*     */             } 
/*     */           }
/* 307 */           off++;
/* 308 */           l = blkIds[off] & 0xFF | (extid & 0xF0) << 4;
/* 309 */           if (l > 0) {
/* 310 */             if (Block.getById(l) == null) {
/* 311 */               blkIds[off] = 0;
/* 312 */               ext[off2] = (byte)(ext[off2] & 0xF);
/*     */             } else {
/* 314 */               cntNonEmpty++;
/* 315 */               if (Block.getById(l).isTicking()) {
/* 316 */                 cntTicking++;
/*     */               }
/*     */             } 
/*     */           }
/* 320 */           off++;
/* 321 */           off2++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 325 */     this.nonEmptyBlockCount = cntNonEmpty;
/* 326 */     this.tickingBlockCount = cntTicking;
/*     */   }
/*     */ 
/*     */   
/*     */   public void old_recalcBlockCounts() {
/* 331 */     this.nonEmptyBlockCount = 0;
/* 332 */     this.tickingBlockCount = 0;
/*     */     
/* 334 */     for (int i = 0; i < 16; i++) {
/* 335 */       for (int j = 0; j < 16; j++) {
/* 336 */         for (int k = 0; k < 16; k++) {
/* 337 */           Block block = getTypeId(i, j, k);
/*     */           
/* 339 */           if (block != Blocks.AIR) {
/* 340 */             this.nonEmptyBlockCount++;
/* 341 */             if (block.isTicking()) {
/* 342 */               this.tickingBlockCount++;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getIdArray() {
/* 352 */     if (this.blockIds == null) {
/* 353 */       byte[] ids = new byte[4096];
/* 354 */       Arrays.fill(ids, (byte)(this.compactId & 0xFF));
/* 355 */       return ids;
/*     */     } 
/*     */     
/* 358 */     return this.blockIds;
/*     */   }
/*     */ 
/*     */   
/*     */   public NibbleArray getExtendedIdArray() {
/* 363 */     if (this.extBlockIds == null && this.compactExtId != 0) {
/* 364 */       return compactPregen[this.compactExtId];
/*     */     }
/*     */     
/* 367 */     return this.extBlockIds;
/*     */   }
/*     */ 
/*     */   
/*     */   public NibbleArray getDataArray() {
/* 372 */     if (this.blockData == null) {
/* 373 */       return compactPregen[this.compactData];
/*     */     }
/*     */     
/* 376 */     return this.blockData;
/*     */   }
/*     */ 
/*     */   
/*     */   public NibbleArray getEmittedLightArray() {
/* 381 */     if (this.emittedLight == null) {
/* 382 */       return compactPregen[this.compactEmitted];
/*     */     }
/*     */     
/* 385 */     return this.emittedLight;
/*     */   }
/*     */ 
/*     */   
/*     */   public NibbleArray getSkyLightArray() {
/* 390 */     if (this.skyLight == null && this.compactSky != -1) {
/* 391 */       return compactPregen[this.compactSky];
/*     */     }
/*     */     
/* 394 */     return this.skyLight;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIdArray(byte[] abyte) {
/* 399 */     if (abyte == null) {
/* 400 */       this.compactId = 0;
/* 401 */       this.blockIds = null; return;
/*     */     } 
/* 403 */     if (canBeCompact(abyte)) {
/* 404 */       this.compactId = abyte[0] & 0xFF;
/*     */       
/*     */       return;
/*     */     } 
/* 408 */     this.blockIds = validateByteArray(abyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setExtendedIdArray(NibbleArray nibblearray) {
/* 413 */     if (nibblearray == null) {
/* 414 */       this.compactExtId = 0;
/* 415 */       this.extBlockIds = null; return;
/*     */     } 
/* 417 */     if (canBeCompact(nibblearray.a)) {
/* 418 */       this.compactExtId = (byte)(nibblearray.a(0, 0, 0) & 0xF);
/*     */       
/*     */       return;
/*     */     } 
/* 422 */     this.extBlockIds = validateNibbleArray(nibblearray);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDataArray(NibbleArray nibblearray) {
/* 427 */     if (nibblearray == null) {
/* 428 */       this.compactData = 0;
/* 429 */       this.blockData = null; return;
/*     */     } 
/* 431 */     if (canBeCompact(nibblearray.a)) {
/* 432 */       this.compactData = (byte)(nibblearray.a(0, 0, 0) & 0xF);
/*     */       
/*     */       return;
/*     */     } 
/* 436 */     this.blockData = validateNibbleArray(nibblearray);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEmittedLightArray(NibbleArray nibblearray) {
/* 441 */     if (nibblearray == null) {
/* 442 */       this.compactEmitted = 0;
/* 443 */       this.emittedLight = null; return;
/*     */     } 
/* 445 */     if (canBeCompact(nibblearray.a)) {
/* 446 */       this.compactEmitted = (byte)(nibblearray.a(0, 0, 0) & 0xF);
/*     */       
/*     */       return;
/*     */     } 
/* 450 */     this.emittedLight = validateNibbleArray(nibblearray);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSkyLightArray(NibbleArray nibblearray) {
/* 455 */     if (nibblearray == null) {
/* 456 */       this.compactSky = -1;
/* 457 */       this.skyLight = null; return;
/*     */     } 
/* 459 */     if (canBeCompact(nibblearray.a)) {
/* 460 */       this.compactSky = (byte)(nibblearray.a(0, 0, 0) & 0xF);
/*     */       
/*     */       return;
/*     */     } 
/* 464 */     this.skyLight = validateNibbleArray(nibblearray);
/*     */   }
/*     */ 
/*     */   
/*     */   private NibbleArray validateNibbleArray(NibbleArray nibbleArray) {
/* 469 */     if (nibbleArray != null && nibbleArray.a.length < 2048) {
/* 470 */       byte[] newArray = new byte[2048];
/* 471 */       System.arraycopy(nibbleArray.a, 0, newArray, 0, nibbleArray.a.length);
/* 472 */       nibbleArray = new NibbleArray(newArray, 4);
/*     */     } 
/*     */     
/* 475 */     return nibbleArray;
/*     */   }
/*     */   
/*     */   private byte[] validateByteArray(byte[] byteArray) {
/* 479 */     if (byteArray != null && byteArray.length < 4096) {
/* 480 */       byte[] newArray = new byte[4096];
/* 481 */       System.arraycopy(byteArray, 0, newArray, 0, byteArray.length);
/* 482 */       byteArray = newArray;
/*     */     } 
/*     */     
/* 485 */     return byteArray;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ChunkSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */