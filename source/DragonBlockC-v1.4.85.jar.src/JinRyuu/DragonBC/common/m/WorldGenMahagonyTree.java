/*     */ package JinRyuu.DragonBC.common.m;
/*     */ import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ 
/*     */ public class WorldGenMahagonyTree extends WorldGenAbstractTree {
/*     */   public boolean b;
/*     */   
/*     */   public WorldGenMahagonyTree() {
/*  14 */     super(false);
/*     */ 
/*     */ 
/*     */     
/*  18 */     this.b = false;
/*     */     this.b = false;
/*     */   } public WorldGenMahagonyTree(boolean b) {
/*  21 */     super(false); this.b = false;
/*  22 */     this.b = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random random, int x, int y, int z) {
/*  27 */     if (this.b) {
/*  28 */       while (world.func_147437_c(x, y, z) && y > 2)
/*     */       {
/*  30 */         y--;
/*     */       }
/*     */     } else {
/*  33 */       y--;
/*     */     } 
/*  35 */     Block block = world.func_147439_a(x, y, z);
/*  36 */     if (block != Blocks.field_150349_c && block != Blocks.field_150346_d)
/*     */     {
/*  38 */       return false;
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
/*     */ 
/*     */ 
/*     */     
/*  53 */     if (world.func_147437_c(x, y, z) && !world.func_147437_c(x, y + 2, z))
/*     */     {
/*     */       
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     int baselength = 3 + random.nextInt(4);
/*  60 */     int singlebranches = 1;
/*  61 */     int multibranches = 1 + random.nextInt(2);
/*     */     
/*  63 */     int treeTwoTop = 0;
/*  64 */     if (multibranches == 1) {
/*     */       
/*  66 */       treeTwoTop = 3;
/*     */     }
/*  68 */     else if (multibranches == 2) {
/*     */       
/*  70 */       treeTwoTop = 6;
/*     */     } 
/*     */ 
/*     */     
/*  74 */     int h = 1;
/*     */     
/*  76 */     block.onPlantGrow(world, x, y, z, x, y, z);
/*     */     
/*  78 */     if (world.func_72904_c(x - 8, y, z - 8, x + 10, y + 8, z + 8)) {
/*     */       
/*  80 */       for (int i = 0; i < baselength; i++) {
/*  81 */         buildBlock(world, x, y + h, z, ModdedBlocks.SakuraLogs, 1);
/*  82 */         h++;
/*     */       } 
/*     */       
/*  85 */       int dec = random.nextInt(5);
/*     */ 
/*     */ 
/*     */       
/*  89 */       if (dec == 0 || dec == 4) {
/*     */         
/*  91 */         int c = 1;
/*     */         
/*  93 */         int Br2 = random.nextInt(2);
/*  94 */         int Br3 = random.nextInt(2);
/*  95 */         int Br4 = random.nextInt(2);
/*     */ 
/*     */         
/*  98 */         for (int j = 0; j < singlebranches; j++) {
/*  99 */           generateTreeOneBranchOne(world, random, x, y + h, z, c);
/*     */           
/* 101 */           if (Br2 == 1) {
/* 102 */             generateTreeOneBranchTwo(world, random, x, y + h, z, c);
/*     */           }
/* 104 */           if (Br3 == 1) {
/* 105 */             generateTreeOneBranchThree(world, random, x, y + h, z, c);
/*     */           }
/* 107 */           if (Br4 == 1) {
/* 108 */             generateTreeOneBranchFour(world, random, x, y + h, z, c);
/*     */           }
/* 110 */           c++;
/* 111 */           h += 2;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 116 */       else if (dec == 1) {
/*     */         
/* 118 */         int c = 1;
/* 119 */         int Br1 = random.nextInt(2);
/* 120 */         int Br2 = random.nextInt(2);
/* 121 */         int Br3 = random.nextInt(2);
/* 122 */         int Br4 = random.nextInt(2);
/* 123 */         int Br5 = random.nextInt(2);
/* 124 */         int Br6 = random.nextInt(2);
/*     */         
/* 126 */         for (int j = 0; j < multibranches; j++) {
/*     */ 
/*     */           
/* 129 */           if (j == 0) {
/* 130 */             generateTreeTwoTrunk(world, random, x, y + h, z, c);
/*     */             
/* 132 */             if (Br1 == 1) {
/* 133 */               generateTreeTwoBranchOne(world, random, x, y + h, z, c);
/*     */             }
/* 135 */             if (Br2 == 1) {
/* 136 */               generateTreeTwoBranchTwo(world, random, x, y + h, z, c);
/*     */             }
/* 138 */             if (Br3 == 1) {
/* 139 */               generateTreeTwoBranchThree(world, random, x, y + h, z, c);
/*     */             }
/* 141 */             if (Br4 == 1) {
/* 142 */               generateTreeTwoBranchFour(world, random, x, y + h, z, c);
/*     */             }
/* 144 */             if (Br5 == 1) {
/* 145 */               generateTreeTwoBranchFive(world, random, x, y + h, z, c);
/*     */             }
/* 147 */             if (Br6 == 1) {
/* 148 */               generateTreeTwoBranchSix(world, random, x, y + h, z, c);
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 154 */           Br1 = random.nextInt(2);
/* 155 */           Br2 = random.nextInt(2);
/* 156 */           Br3 = random.nextInt(2);
/* 157 */           Br4 = random.nextInt(2);
/* 158 */           Br5 = random.nextInt(2);
/* 159 */           Br6 = random.nextInt(2);
/*     */           
/* 161 */           c++;
/* 162 */           h += 2;
/* 163 */           if (j == 1) {
/* 164 */             generateTreeTwoTrunk(world, random, x, y + 1 + h, z, c);
/*     */             
/* 166 */             if (Br1 == 1) {
/* 167 */               generateTreeTwoBranchOne(world, random, x, y + 1 + h, z, c);
/*     */             }
/* 169 */             if (Br2 == 1) {
/* 170 */               generateTreeTwoBranchTwo(world, random, x, y + 1 + h, z, c);
/*     */             }
/* 172 */             if (Br3 == 1) {
/* 173 */               generateTreeTwoBranchThree(world, random, x, y + 1 + h, z, c);
/*     */             }
/* 175 */             if (Br4 == 1) {
/* 176 */               generateTreeTwoBranchFour(world, random, x, y + 1 + h, z, c);
/*     */             }
/* 178 */             if (Br5 == 1) {
/* 179 */               generateTreeTwoBranchFive(world, random, x, y + 1 + h, z, c);
/*     */             }
/* 181 */             if (Br6 == 1) {
/* 182 */               generateTreeTwoBranchSix(world, random, x, y + 1 + h, z, c);
/*     */             }
/*     */           } 
/*     */         } 
/* 186 */         generateTreeTwoTop(world, random, x, y + treeTwoTop + h, z, c);
/*     */       
/*     */       }
/* 189 */       else if (dec == 2 || dec == 3) {
/*     */         
/* 191 */         int c = 1;
/* 192 */         for (int j = 0; j < multibranches; j++) {
/* 193 */           generateTreeThree(world, random, x, y + h, z, c);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 198 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateTreeOneBranchOne(World world, Random random, int x, int y, int z, int p) {
/* 207 */     buildBlock(world, x, y, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 208 */     buildBlock(world, x - 1, y, z + 2, ModdedBlocks.SakuraLogs, 1);
/* 209 */     buildBlock(world, x - 2, y, z + 2, ModdedBlocks.SakuraLogs, 1);
/* 210 */     buildBlock(world, x - 2, y + 1, z + 3, ModdedBlocks.SakuraLogs, 1);
/* 211 */     buildBlock(world, x - 3, y + 1, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 212 */     buildBlock(world, x - 3, y + 1, z, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 214 */     buildBlock(world, x - 2, y + 2, z + 3, ModdedBlocks.SakuraLogs, 1);
/* 215 */     buildBlock(world, x - 4, y + 2, z, ModdedBlocks.SakuraLogs, 1);
/* 216 */     buildBlock(world, x - 4, y + 2, z - 1, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 218 */     buildBlock(world, x - 3, y + 3, z + 4, ModdedBlocks.SakuraLogs, 1);
/* 219 */     buildBlock(world, x - 4, y + 3, z - 1, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 221 */     buildBlock(world, x - 1, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 222 */     buildBlock(world, x - 3, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 223 */     buildBlock(world, x - 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 224 */     buildBlock(world, x - 5, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 225 */     buildBlock(world, x - 1, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 226 */     buildBlock(world, x - 2, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 227 */     buildBlock(world, x - 3, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 228 */     buildBlock(world, x - 4, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 229 */     buildBlock(world, x - 5, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 230 */     buildBlock(world, x - 6, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 231 */     buildBlock(world, x - 2, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 232 */     buildBlock(world, x - 3, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 233 */     buildBlock(world, x - 4, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 234 */     buildBlock(world, x - 5, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 235 */     buildBlock(world, x - 2, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 236 */     buildBlock(world, x - 3, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 237 */     buildBlock(world, x - 4, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 238 */     buildBlock(world, x - 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 239 */     buildBlock(world, x - 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 240 */     buildBlock(world, x - 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 241 */     buildBlock(world, x - 4, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 242 */     buildBlock(world, x - 5, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 243 */     buildBlock(world, x - 6, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 244 */     buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 245 */     buildBlock(world, x - 3, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 246 */     buildBlock(world, x - 5, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 247 */     buildBlock(world, x - 6, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 248 */     buildBlock(world, x - 7, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 249 */     buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 250 */     buildBlock(world, x - 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 251 */     buildBlock(world, x - 5, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 252 */     buildBlock(world, x - 6, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 253 */     buildBlock(world, x - 7, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 254 */     buildBlock(world, x - 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 255 */     buildBlock(world, x - 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 256 */     buildBlock(world, x - 4, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 257 */     buildBlock(world, x - 5, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 258 */     buildBlock(world, x - 6, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 259 */     buildBlock(world, x - 7, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 260 */     buildBlock(world, x - 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 261 */     buildBlock(world, x - 5, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 262 */     buildBlock(world, x - 6, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 264 */     buildBlock(world, x - 2, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 265 */     buildBlock(world, x - 3, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 266 */     buildBlock(world, x - 4, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 267 */     buildBlock(world, x - 2, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 268 */     buildBlock(world, x - 4, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 269 */     buildBlock(world, x - 5, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 270 */     buildBlock(world, x - 2, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 271 */     buildBlock(world, x - 3, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 272 */     buildBlock(world, x - 4, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 273 */     buildBlock(world, x - 3, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 274 */     buildBlock(world, x - 4, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 275 */     buildBlock(world, x - 5, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 276 */     buildBlock(world, x - 6, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 277 */     buildBlock(world, x - 3, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 278 */     buildBlock(world, x - 5, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 279 */     buildBlock(world, x - 6, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 280 */     buildBlock(world, x - 4, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 281 */     buildBlock(world, x - 5, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 283 */     buildBlock(world, x - 4, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 284 */     buildBlock(world, x - 2, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 285 */     buildBlock(world, x - 3, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 286 */     buildBlock(world, x - 4, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 287 */     buildBlock(world, x - 3, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 288 */     buildBlock(world, x - 4, y + 4, z, ModdedBlocks.SakuraLeaves, 1);
/* 289 */     buildBlock(world, x - 5, y + 4, z, ModdedBlocks.SakuraLeaves, 1);
/* 290 */     buildBlock(world, x - 4, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 291 */     buildBlock(world, x - 5, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 292 */     buildBlock(world, x - 5, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeOneBranchTwo(World world, Random random, int x, int y, int z, int p) {
/* 297 */     buildBlock(world, x, y, z - 1, ModdedBlocks.SakuraLogs, 1);
/* 298 */     buildBlock(world, x + 1, y, z - 2, ModdedBlocks.SakuraLogs, 1);
/* 299 */     buildBlock(world, x + 2, y, z - 2, ModdedBlocks.SakuraLogs, 1);
/* 300 */     buildBlock(world, x + 2, y + 1, z - 3, ModdedBlocks.SakuraLogs, 1);
/* 301 */     buildBlock(world, x + 3, y + 1, z - 1, ModdedBlocks.SakuraLogs, 1);
/* 302 */     buildBlock(world, x + 3, y + 1, z, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 304 */     buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLogs, 1);
/* 305 */     buildBlock(world, x + 4, y + 2, z, ModdedBlocks.SakuraLogs, 1);
/* 306 */     buildBlock(world, x + 4, y + 2, z + 1, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 308 */     buildBlock(world, x + 3, y + 3, z - 4, ModdedBlocks.SakuraLogs, 1);
/* 309 */     buildBlock(world, x + 4, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 311 */     buildBlock(world, x + 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 312 */     buildBlock(world, x + 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 313 */     buildBlock(world, x + 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 314 */     buildBlock(world, x + 5, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 315 */     buildBlock(world, x + 1, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 316 */     buildBlock(world, x + 2, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 317 */     buildBlock(world, x + 3, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 318 */     buildBlock(world, x + 4, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 319 */     buildBlock(world, x + 5, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 320 */     buildBlock(world, x + 6, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 321 */     buildBlock(world, x + 2, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 322 */     buildBlock(world, x + 3, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 323 */     buildBlock(world, x + 4, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 324 */     buildBlock(world, x + 5, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 325 */     buildBlock(world, x + 2, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 326 */     buildBlock(world, x + 3, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 327 */     buildBlock(world, x + 4, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 328 */     buildBlock(world, x + 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 329 */     buildBlock(world, x + 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 330 */     buildBlock(world, x + 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 331 */     buildBlock(world, x + 4, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 332 */     buildBlock(world, x + 5, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 333 */     buildBlock(world, x + 6, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 334 */     buildBlock(world, x + 2, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 335 */     buildBlock(world, x + 3, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 336 */     buildBlock(world, x + 5, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 337 */     buildBlock(world, x + 6, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 338 */     buildBlock(world, x + 7, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 339 */     buildBlock(world, x + 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 340 */     buildBlock(world, x + 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 341 */     buildBlock(world, x + 5, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 342 */     buildBlock(world, x + 6, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 343 */     buildBlock(world, x + 7, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 344 */     buildBlock(world, x + 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 345 */     buildBlock(world, x + 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 346 */     buildBlock(world, x + 4, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 347 */     buildBlock(world, x + 5, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 348 */     buildBlock(world, x + 6, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 349 */     buildBlock(world, x + 7, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 350 */     buildBlock(world, x + 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 351 */     buildBlock(world, x + 5, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 352 */     buildBlock(world, x + 6, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 354 */     buildBlock(world, x + 2, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 355 */     buildBlock(world, x + 3, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 356 */     buildBlock(world, x + 4, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 357 */     buildBlock(world, x + 2, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 358 */     buildBlock(world, x + 4, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 359 */     buildBlock(world, x + 5, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 360 */     buildBlock(world, x + 2, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 361 */     buildBlock(world, x + 3, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 362 */     buildBlock(world, x + 4, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 363 */     buildBlock(world, x + 3, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 364 */     buildBlock(world, x + 4, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 365 */     buildBlock(world, x + 5, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 366 */     buildBlock(world, x + 6, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 367 */     buildBlock(world, x + 3, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 368 */     buildBlock(world, x + 5, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 369 */     buildBlock(world, x + 6, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 370 */     buildBlock(world, x + 4, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 371 */     buildBlock(world, x + 5, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 373 */     buildBlock(world, x + 4, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 374 */     buildBlock(world, x + 2, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 375 */     buildBlock(world, x + 3, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 376 */     buildBlock(world, x + 4, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 377 */     buildBlock(world, x + 3, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 378 */     buildBlock(world, x + 4, y + 4, z, ModdedBlocks.SakuraLeaves, 1);
/* 379 */     buildBlock(world, x + 5, y + 4, z, ModdedBlocks.SakuraLeaves, 1);
/* 380 */     buildBlock(world, x + 4, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 381 */     buildBlock(world, x + 5, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 382 */     buildBlock(world, x + 5, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeOneBranchThree(World world, Random random, int x, int y, int z, int p) {
/* 387 */     buildBlock(world, x, y, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 388 */     buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLogs, 1);
/* 389 */     buildBlock(world, x + 1, y + 1, z + 3, ModdedBlocks.SakuraLogs, 1);
/* 390 */     buildBlock(world, x + 2, y + 1, z + 4, ModdedBlocks.SakuraLogs, 1);
/* 391 */     buildBlock(world, x + 3, y + 2, z + 5, ModdedBlocks.SakuraLogs, 1);
/* 392 */     buildBlock(world, x + 3, y + 3, z + 6, ModdedBlocks.SakuraLogs, 1);
/* 393 */     buildBlock(world, x + 4, y + 3, z + 5, ModdedBlocks.SakuraLogs, 1);
/*     */ 
/*     */     
/* 396 */     buildBlock(world, x + 2, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 397 */     buildBlock(world, x + 3, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 398 */     buildBlock(world, x + 1, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 399 */     buildBlock(world, x + 2, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 400 */     buildBlock(world, x + 3, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 401 */     buildBlock(world, x + 4, y + 2, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 402 */     buildBlock(world, x + 1, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 403 */     buildBlock(world, x + 2, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 404 */     buildBlock(world, x + 4, y + 2, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 405 */     buildBlock(world, x + 1, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 406 */     buildBlock(world, x + 2, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 407 */     buildBlock(world, x + 3, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 408 */     buildBlock(world, x + 4, y + 2, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 409 */     buildBlock(world, x + 2, y + 2, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 410 */     buildBlock(world, x + 3, y + 2, z + 7, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 412 */     buildBlock(world, x + 4, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 413 */     buildBlock(world, x + 5, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 414 */     buildBlock(world, x + 2, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 415 */     buildBlock(world, x + 3, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 416 */     buildBlock(world, x + 5, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 417 */     buildBlock(world, x + 6, y + 3, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 418 */     buildBlock(world, x + 1, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 419 */     buildBlock(world, x + 2, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 420 */     buildBlock(world, x + 4, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 421 */     buildBlock(world, x + 5, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 422 */     buildBlock(world, x + 6, y + 3, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 423 */     buildBlock(world, x + 1, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 424 */     buildBlock(world, x + 2, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 425 */     buildBlock(world, x + 3, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 426 */     buildBlock(world, x + 4, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 427 */     buildBlock(world, x + 5, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 428 */     buildBlock(world, x + 6, y + 3, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 429 */     buildBlock(world, x + 2, y + 3, z + 8, ModdedBlocks.SakuraLeaves, 1);
/* 430 */     buildBlock(world, x + 3, y + 3, z + 8, ModdedBlocks.SakuraLeaves, 1);
/* 431 */     buildBlock(world, x + 4, y + 3, z + 8, ModdedBlocks.SakuraLeaves, 1);
/* 432 */     buildBlock(world, x + 5, y + 3, z + 8, ModdedBlocks.SakuraLeaves, 1);
/* 433 */     buildBlock(world, x + 3, y + 3, z + 9, ModdedBlocks.SakuraLeaves, 1);
/* 434 */     buildBlock(world, x + 4, y + 3, z + 9, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 436 */     buildBlock(world, x + 3, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 437 */     buildBlock(world, x + 4, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 438 */     buildBlock(world, x + 5, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 439 */     buildBlock(world, x + 2, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 440 */     buildBlock(world, x + 3, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 441 */     buildBlock(world, x + 4, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 442 */     buildBlock(world, x + 5, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 443 */     buildBlock(world, x + 2, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 444 */     buildBlock(world, x + 3, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 445 */     buildBlock(world, x + 4, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 446 */     buildBlock(world, x + 5, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 447 */     buildBlock(world, x + 2, y + 4, z + 8, ModdedBlocks.SakuraLeaves, 1);
/* 448 */     buildBlock(world, x + 3, y + 4, z + 8, ModdedBlocks.SakuraLeaves, 1);
/* 449 */     buildBlock(world, x + 4, y + 4, z + 8, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeOneBranchFour(World world, Random random, int x, int y, int z, int p) {
/* 454 */     buildBlock(world, x, y, z - 1, ModdedBlocks.SakuraLogs, 1);
/* 455 */     buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLogs, 1);
/* 456 */     buildBlock(world, x - 1, y + 1, z - 3, ModdedBlocks.SakuraLogs, 1);
/* 457 */     buildBlock(world, x - 2, y + 1, z - 4, ModdedBlocks.SakuraLogs, 1);
/* 458 */     buildBlock(world, x - 3, y + 2, z - 5, ModdedBlocks.SakuraLogs, 1);
/* 459 */     buildBlock(world, x - 3, y + 3, z - 6, ModdedBlocks.SakuraLogs, 1);
/* 460 */     buildBlock(world, x - 4, y + 3, z - 5, ModdedBlocks.SakuraLogs, 1);
/*     */ 
/*     */     
/* 463 */     buildBlock(world, x - 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 464 */     buildBlock(world, x - 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 465 */     buildBlock(world, x - 1, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 466 */     buildBlock(world, x - 2, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 467 */     buildBlock(world, x - 3, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 468 */     buildBlock(world, x - 4, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 469 */     buildBlock(world, x - 1, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 470 */     buildBlock(world, x - 2, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 471 */     buildBlock(world, x - 4, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 472 */     buildBlock(world, x - 1, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 473 */     buildBlock(world, x - 2, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 474 */     buildBlock(world, x - 3, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 475 */     buildBlock(world, x - 4, y + 2, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 476 */     buildBlock(world, x - 2, y + 2, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 477 */     buildBlock(world, x - 3, y + 2, z - 7, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 479 */     buildBlock(world, x - 4, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 480 */     buildBlock(world, x - 5, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 481 */     buildBlock(world, x - 2, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 482 */     buildBlock(world, x - 3, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 483 */     buildBlock(world, x - 5, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 484 */     buildBlock(world, x - 6, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 485 */     buildBlock(world, x - 1, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 486 */     buildBlock(world, x - 2, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 487 */     buildBlock(world, x - 4, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 488 */     buildBlock(world, x - 5, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 489 */     buildBlock(world, x - 6, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 490 */     buildBlock(world, x - 1, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 491 */     buildBlock(world, x - 2, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 492 */     buildBlock(world, x - 3, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 493 */     buildBlock(world, x - 4, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 494 */     buildBlock(world, x - 5, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 495 */     buildBlock(world, x - 6, y + 3, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 496 */     buildBlock(world, x - 2, y + 3, z - 8, ModdedBlocks.SakuraLeaves, 1);
/* 497 */     buildBlock(world, x - 3, y + 3, z - 8, ModdedBlocks.SakuraLeaves, 1);
/* 498 */     buildBlock(world, x - 4, y + 3, z - 8, ModdedBlocks.SakuraLeaves, 1);
/* 499 */     buildBlock(world, x - 5, y + 3, z - 8, ModdedBlocks.SakuraLeaves, 1);
/* 500 */     buildBlock(world, x - 3, y + 3, z - 9, ModdedBlocks.SakuraLeaves, 1);
/* 501 */     buildBlock(world, x - 4, y + 3, z - 9, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 503 */     buildBlock(world, x - 3, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 504 */     buildBlock(world, x - 4, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 505 */     buildBlock(world, x - 5, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 506 */     buildBlock(world, x - 2, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 507 */     buildBlock(world, x - 3, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 508 */     buildBlock(world, x - 4, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 509 */     buildBlock(world, x - 5, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 510 */     buildBlock(world, x - 2, y + 4, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 511 */     buildBlock(world, x - 3, y + 4, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 512 */     buildBlock(world, x - 4, y + 4, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 513 */     buildBlock(world, x - 5, y + 4, z - 7, ModdedBlocks.SakuraLeaves, 1);
/* 514 */     buildBlock(world, x - 2, y + 4, z - 8, ModdedBlocks.SakuraLeaves, 1);
/* 515 */     buildBlock(world, x - 3, y + 4, z - 8, ModdedBlocks.SakuraLeaves, 1);
/* 516 */     buildBlock(world, x - 4, y + 4, z - 8, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateTreeTwoTrunk(World world, Random random, int x, int y, int z, int p) {
/* 522 */     for (int i = 0; i < 5; i++) {
/* 523 */       buildBlock(world, x, y + i, z, ModdedBlocks.SakuraLogs, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeTwoBranchOne(World world, Random random, int x, int y, int z, int p) {
/* 529 */     buildBlock(world, x + 1, y, z, ModdedBlocks.SakuraLogs, 1);
/* 530 */     buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLogs, 1);
/* 531 */     buildBlock(world, x + 3, y + 1, z, ModdedBlocks.SakuraLogs, 1);
/* 532 */     buildBlock(world, x + 4, y + 2, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 533 */     buildBlock(world, x + 5, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 534 */     buildBlock(world, x + 4, y + 3, z + 2, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 536 */     buildBlock(world, x + 3, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 537 */     buildBlock(world, x + 4, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 538 */     buildBlock(world, x + 5, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 539 */     buildBlock(world, x + 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 540 */     buildBlock(world, x + 5, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 541 */     buildBlock(world, x + 6, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 542 */     buildBlock(world, x + 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 543 */     buildBlock(world, x + 4, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 544 */     buildBlock(world, x + 5, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 545 */     buildBlock(world, x + 6, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 546 */     buildBlock(world, x + 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 547 */     buildBlock(world, x + 5, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 549 */     buildBlock(world, x + 4, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 550 */     buildBlock(world, x + 5, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 551 */     buildBlock(world, x + 3, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 552 */     buildBlock(world, x + 4, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 553 */     buildBlock(world, x + 6, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 554 */     buildBlock(world, x + 7, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 555 */     buildBlock(world, x + 3, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 556 */     buildBlock(world, x + 5, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 557 */     buildBlock(world, x + 6, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 558 */     buildBlock(world, x + 7, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 559 */     buildBlock(world, x + 4, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 560 */     buildBlock(world, x + 5, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 561 */     buildBlock(world, x + 6, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 562 */     buildBlock(world, x + 4, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 563 */     buildBlock(world, x + 5, y + 3, z + 4, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 565 */     buildBlock(world, x + 4, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 566 */     buildBlock(world, x + 5, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 567 */     buildBlock(world, x + 4, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 568 */     buildBlock(world, x + 5, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 569 */     buildBlock(world, x + 6, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 570 */     buildBlock(world, x + 4, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeTwoBranchTwo(World world, Random random, int x, int y, int z, int p) {
/* 575 */     buildBlock(world, x + 1, y, z, ModdedBlocks.SakuraLogs, 1);
/* 576 */     buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLogs, 1);
/* 577 */     buildBlock(world, x + 2, y + 1, z - 1, ModdedBlocks.SakuraLogs, 1);
/* 578 */     buildBlock(world, x + 2, y + 2, z - 2, ModdedBlocks.SakuraLogs, 1);
/* 579 */     buildBlock(world, x + 2, y + 3, z - 3, ModdedBlocks.SakuraLogs, 1);
/* 580 */     buildBlock(world, x + 3, y + 3, z - 2, ModdedBlocks.SakuraLogs, 1);
/* 581 */     buildBlock(world, x + 3, y + 3, z - 3, ModdedBlocks.SakuraLogs, 1);
/* 582 */     buildBlock(world, x + 4, y + 4, z - 4, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 584 */     buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 585 */     buildBlock(world, x + 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 586 */     buildBlock(world, x + 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 587 */     buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 588 */     buildBlock(world, x + 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 589 */     buildBlock(world, x + 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 590 */     buildBlock(world, x + 3, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 591 */     buildBlock(world, x + 4, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 593 */     buildBlock(world, x + 3, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 594 */     buildBlock(world, x + 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 595 */     buildBlock(world, x + 2, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 596 */     buildBlock(world, x + 4, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 597 */     buildBlock(world, x + 1, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 598 */     buildBlock(world, x + 4, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 599 */     buildBlock(world, x + 5, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 600 */     buildBlock(world, x + 2, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 601 */     buildBlock(world, x + 3, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 602 */     buildBlock(world, x + 4, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 603 */     buildBlock(world, x + 5, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 604 */     buildBlock(world, x + 2, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 605 */     buildBlock(world, x + 3, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 606 */     buildBlock(world, x + 4, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 608 */     buildBlock(world, x + 4, y + 4, z - 6, ModdedBlocks.SakuraLeaves, 1);
/* 609 */     buildBlock(world, x + 3, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 610 */     buildBlock(world, x + 4, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 611 */     buildBlock(world, x + 5, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 612 */     buildBlock(world, x + 2, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 613 */     buildBlock(world, x + 3, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 614 */     buildBlock(world, x + 5, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 615 */     buildBlock(world, x + 2, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 616 */     buildBlock(world, x + 3, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 617 */     buildBlock(world, x + 4, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 618 */     buildBlock(world, x + 5, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 619 */     buildBlock(world, x + 2, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 620 */     buildBlock(world, x + 3, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 622 */     buildBlock(world, x + 4, y + 5, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 623 */     buildBlock(world, x + 3, y + 5, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 624 */     buildBlock(world, x + 4, y + 5, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 625 */     buildBlock(world, x + 5, y + 5, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 626 */     buildBlock(world, x + 3, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeTwoBranchThree(World world, Random random, int x, int y, int z, int p) {
/* 631 */     buildBlock(world, x - 1, y + 2, z, ModdedBlocks.SakuraLogs, 1);
/* 632 */     buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLogs, 1);
/* 633 */     buildBlock(world, x - 2, y + 3, z - 1, ModdedBlocks.SakuraLogs, 1);
/* 634 */     buildBlock(world, x - 3, y + 3, z - 1, ModdedBlocks.SakuraLogs, 1);
/* 635 */     buildBlock(world, x - 3, y + 3, z - 2, ModdedBlocks.SakuraLogs, 1);
/* 636 */     buildBlock(world, x - 4, y + 4, z - 3, ModdedBlocks.SakuraLogs, 1);
/* 637 */     buildBlock(world, x - 5, y + 4, z - 4, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 639 */     buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 640 */     buildBlock(world, x - 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 641 */     buildBlock(world, x - 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 642 */     buildBlock(world, x - 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 643 */     buildBlock(world, x - 4, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 644 */     buildBlock(world, x - 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 645 */     buildBlock(world, x - 4, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 646 */     buildBlock(world, x - 5, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 647 */     buildBlock(world, x - 5, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 648 */     buildBlock(world, x - 5, y + 2, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 649 */     buildBlock(world, x - 6, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 651 */     buildBlock(world, x - 2, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 652 */     buildBlock(world, x - 3, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 653 */     buildBlock(world, x - 1, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 654 */     buildBlock(world, x - 4, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 655 */     buildBlock(world, x - 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 656 */     buildBlock(world, x - 2, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 657 */     buildBlock(world, x - 4, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 658 */     buildBlock(world, x - 5, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 659 */     buildBlock(world, x - 2, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 660 */     buildBlock(world, x - 3, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 661 */     buildBlock(world, x - 4, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 662 */     buildBlock(world, x - 5, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 663 */     buildBlock(world, x - 6, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 664 */     buildBlock(world, x - 7, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 665 */     buildBlock(world, x - 3, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 666 */     buildBlock(world, x - 4, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 667 */     buildBlock(world, x - 5, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 668 */     buildBlock(world, x - 6, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 669 */     buildBlock(world, x - 3, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 670 */     buildBlock(world, x - 4, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 671 */     buildBlock(world, x - 5, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 672 */     buildBlock(world, x - 6, y + 3, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 673 */     buildBlock(world, x - 4, y + 3, z - 6, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 675 */     buildBlock(world, x - 2, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 676 */     buildBlock(world, x - 3, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 677 */     buildBlock(world, x - 2, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 678 */     buildBlock(world, x - 3, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 679 */     buildBlock(world, x - 4, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 680 */     buildBlock(world, x - 5, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 681 */     buildBlock(world, x - 2, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 682 */     buildBlock(world, x - 3, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 683 */     buildBlock(world, x - 5, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 684 */     buildBlock(world, x - 6, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 685 */     buildBlock(world, x - 3, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 686 */     buildBlock(world, x - 4, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 687 */     buildBlock(world, x - 6, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 1);
/* 688 */     buildBlock(world, x - 4, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/* 689 */     buildBlock(world, x - 5, y + 4, z - 5, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 691 */     buildBlock(world, x - 4, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 692 */     buildBlock(world, x - 3, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 693 */     buildBlock(world, x - 4, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 694 */     buildBlock(world, x - 5, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 695 */     buildBlock(world, x - 5, y + 5, z - 4, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeTwoBranchFour(World world, Random random, int x, int y, int z, int p) {
/* 700 */     buildBlock(world, x - 1, y + 2, z, ModdedBlocks.SakuraLogs, 1);
/* 701 */     buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLogs, 1);
/* 702 */     buildBlock(world, x - 2, y + 1, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 703 */     buildBlock(world, x - 3, y + 1, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 704 */     buildBlock(world, x - 3, y + 1, z + 2, ModdedBlocks.SakuraLogs, 1);
/* 705 */     buildBlock(world, x - 4, y + 2, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 706 */     buildBlock(world, x - 5, y + 2, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 707 */     buildBlock(world, x - 6, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 709 */     buildBlock(world, x - 3, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
/* 710 */     buildBlock(world, x - 4, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
/* 711 */     buildBlock(world, x - 5, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
/* 712 */     buildBlock(world, x - 6, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 713 */     buildBlock(world, x - 5, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 714 */     buildBlock(world, x - 4, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 715 */     buildBlock(world, x - 5, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 716 */     buildBlock(world, x - 4, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 717 */     buildBlock(world, x - 5, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 718 */     buildBlock(world, x - 4, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 719 */     buildBlock(world, x - 3, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 721 */     buildBlock(world, x - 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 722 */     buildBlock(world, x - 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 723 */     buildBlock(world, x - 3, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 724 */     buildBlock(world, x - 4, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 725 */     buildBlock(world, x - 4, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 726 */     buildBlock(world, x - 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 727 */     buildBlock(world, x - 5, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 728 */     buildBlock(world, x - 5, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 729 */     buildBlock(world, x - 6, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 730 */     buildBlock(world, x - 6, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 731 */     buildBlock(world, x - 6, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 732 */     buildBlock(world, x - 6, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 733 */     buildBlock(world, x - 6, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 734 */     buildBlock(world, x - 7, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 735 */     buildBlock(world, x - 7, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 736 */     buildBlock(world, x - 8, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 738 */     buildBlock(world, x - 4, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 739 */     buildBlock(world, x - 4, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 740 */     buildBlock(world, x - 5, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 741 */     buildBlock(world, x - 5, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 742 */     buildBlock(world, x - 5, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 743 */     buildBlock(world, x - 6, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 744 */     buildBlock(world, x - 6, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 745 */     buildBlock(world, x - 7, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 746 */     buildBlock(world, x - 7, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 748 */     buildBlock(world, x - 5, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 749 */     buildBlock(world, x - 6, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeTwoBranchFive(World world, Random random, int x, int y, int z, int p) {
/* 754 */     buildBlock(world, x, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 755 */     buildBlock(world, x, y + 3, z + 2, ModdedBlocks.SakuraLogs, 1);
/* 756 */     buildBlock(world, x + 1, y + 4, z + 3, ModdedBlocks.SakuraLogs, 1);
/* 757 */     buildBlock(world, x + 1, y + 4, z + 4, ModdedBlocks.SakuraLogs, 1);
/* 758 */     buildBlock(world, x + 1, y + 5, z + 5, ModdedBlocks.SakuraLogs, 1);
/* 759 */     buildBlock(world, x + 2, y + 5, z + 5, ModdedBlocks.SakuraLogs, 1);
/* 760 */     buildBlock(world, x + 3, y + 5, z + 6, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 762 */     buildBlock(world, x, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 763 */     buildBlock(world, x + 1, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 764 */     buildBlock(world, x, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 765 */     buildBlock(world, x + 2, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 766 */     buildBlock(world, x, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 767 */     buildBlock(world, x + 2, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 768 */     buildBlock(world, x + 1, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 769 */     buildBlock(world, x + 2, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 770 */     buildBlock(world, x + 3, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 771 */     buildBlock(world, x + 4, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 772 */     buildBlock(world, x + 1, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 773 */     buildBlock(world, x + 2, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 774 */     buildBlock(world, x + 3, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 775 */     buildBlock(world, x + 4, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 776 */     buildBlock(world, x + 2, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 777 */     buildBlock(world, x + 3, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 779 */     buildBlock(world, x + 1, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 780 */     buildBlock(world, x, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 781 */     buildBlock(world, x + 1, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 782 */     buildBlock(world, x + 2, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 783 */     buildBlock(world, x + 3, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 784 */     buildBlock(world, x, y + 5, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 785 */     buildBlock(world, x + 3, y + 5, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 786 */     buildBlock(world, x, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 787 */     buildBlock(world, x + 1, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 788 */     buildBlock(world, x + 2, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 789 */     buildBlock(world, x + 4, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 790 */     buildBlock(world, x + 1, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 791 */     buildBlock(world, x + 2, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 792 */     buildBlock(world, x + 3, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 793 */     buildBlock(world, x + 4, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 794 */     buildBlock(world, x + 2, y + 5, z + 8, ModdedBlocks.SakuraLeaves, 1);
/* 795 */     buildBlock(world, x + 3, y + 5, z + 8, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 797 */     buildBlock(world, x + 1, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 798 */     buildBlock(world, x + 2, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 799 */     buildBlock(world, x + 1, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 800 */     buildBlock(world, x + 2, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 801 */     buildBlock(world, x + 3, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 802 */     buildBlock(world, x + 4, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 803 */     buildBlock(world, x + 3, y + 6, z + 7, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeTwoBranchSix(World world, Random random, int x, int y, int z, int p) {
/* 808 */     buildBlock(world, x, y + 3, z + 1, ModdedBlocks.SakuraLogs, 1);
/* 809 */     buildBlock(world, x, y + 3, z + 2, ModdedBlocks.SakuraLogs, 1);
/* 810 */     buildBlock(world, x - 1, y + 3, z + 2, ModdedBlocks.SakuraLogs, 1);
/* 811 */     buildBlock(world, x - 2, y + 4, z + 3, ModdedBlocks.SakuraLogs, 1);
/* 812 */     buildBlock(world, x - 3, y + 4, z + 4, ModdedBlocks.SakuraLogs, 1);
/* 813 */     buildBlock(world, x - 4, y + 5, z + 4, ModdedBlocks.SakuraLogs, 1);
/* 814 */     buildBlock(world, x - 4, y + 5, z + 5, ModdedBlocks.SakuraLogs, 1);
/* 815 */     buildBlock(world, x - 5, y + 5, z + 5, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 817 */     buildBlock(world, x - 1, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 818 */     buildBlock(world, x - 1, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 819 */     buildBlock(world, x - 1, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 820 */     buildBlock(world, x - 2, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 821 */     buildBlock(world, x - 2, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 822 */     buildBlock(world, x - 2, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 823 */     buildBlock(world, x - 3, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 824 */     buildBlock(world, x - 3, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 825 */     buildBlock(world, x - 3, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 826 */     buildBlock(world, x - 3, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 827 */     buildBlock(world, x - 4, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 828 */     buildBlock(world, x - 4, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 829 */     buildBlock(world, x - 4, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 830 */     buildBlock(world, x - 4, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 831 */     buildBlock(world, x - 4, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 832 */     buildBlock(world, x - 5, y + 4, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 833 */     buildBlock(world, x - 5, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 834 */     buildBlock(world, x - 5, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 835 */     buildBlock(world, x - 6, y + 4, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 836 */     buildBlock(world, x - 6, y + 4, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 837 */     buildBlock(world, x - 6, y + 4, z + 7, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 839 */     buildBlock(world, x - 2, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 840 */     buildBlock(world, x - 2, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 841 */     buildBlock(world, x - 3, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 842 */     buildBlock(world, x - 3, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 843 */     buildBlock(world, x - 3, y + 5, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 844 */     buildBlock(world, x - 3, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 845 */     buildBlock(world, x - 4, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 846 */     buildBlock(world, x - 4, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 847 */     buildBlock(world, x - 4, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 848 */     buildBlock(world, x - 5, y + 5, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 849 */     buildBlock(world, x - 5, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 850 */     buildBlock(world, x - 5, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 851 */     buildBlock(world, x - 5, y + 5, z + 7, ModdedBlocks.SakuraLeaves, 1);
/* 852 */     buildBlock(world, x - 6, y + 5, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 853 */     buildBlock(world, x - 6, y + 5, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 854 */     buildBlock(world, x - 6, y + 5, z + 6, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 856 */     buildBlock(world, x - 3, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 857 */     buildBlock(world, x - 4, y + 6, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 858 */     buildBlock(world, x - 4, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 859 */     buildBlock(world, x - 4, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 860 */     buildBlock(world, x - 5, y + 6, z + 4, ModdedBlocks.SakuraLeaves, 1);
/* 861 */     buildBlock(world, x - 5, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
/* 862 */     buildBlock(world, x - 5, y + 6, z + 6, ModdedBlocks.SakuraLeaves, 1);
/* 863 */     buildBlock(world, x - 6, y + 6, z + 5, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */   
/*     */   public void generateTreeTwoTop(World world, Random random, int x, int y, int z, int p) {
/* 867 */     for (int h = 1; h < 3; h++) {
/*     */       
/* 869 */       for (int i = -1; i < 2; i++) {
/*     */         
/* 871 */         for (int j = -1; j < 2; j++)
/*     */         {
/* 873 */           buildBlock(world, x + i, y + h, z + j, ModdedBlocks.SakuraLeaves, 1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 879 */     buildBlock(world, x, y, z, ModdedBlocks.SakuraLogs, 1);
/* 880 */     buildBlock(world, x, y + 1, z, ModdedBlocks.SakuraLogs, 1);
/* 881 */     buildBlock(world, x, y + 2, z, ModdedBlocks.SakuraLogs, 1);
/*     */     
/* 883 */     buildBlock(world, x, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 884 */     buildBlock(world, x, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 885 */     buildBlock(world, x + 1, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 887 */     buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 888 */     buildBlock(world, x - 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 889 */     buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 891 */     buildBlock(world, x, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 892 */     buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 893 */     buildBlock(world, x + 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 894 */     buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
/* 895 */     buildBlock(world, x + 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 896 */     buildBlock(world, x + 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 897 */     buildBlock(world, x, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 898 */     buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 899 */     buildBlock(world, x - 2, y + 1, z, ModdedBlocks.SakuraLeaves, 1);
/* 900 */     buildBlock(world, x - 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateTreeThree(World world, Random random, int x, int y, int z, int p) {
/* 905 */     for (int h = 2; h < 5; h++) {
/*     */       
/* 907 */       for (int j = -1; j < 2; j++) {
/*     */         
/* 909 */         for (int k = -1; k < 2; k++)
/*     */         {
/* 911 */           buildBlock(world, x + 1 + j, y + h, z + k, ModdedBlocks.SakuraLeaves, 1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     int i;
/* 916 */     for (i = 0; i < 4; i++) {
/* 917 */       buildBlock(world, x + 1, y + i, z, ModdedBlocks.SakuraLogs, 1);
/*     */     }
/* 919 */     for (i = -2; i < 3; i++) {
/*     */       
/* 921 */       for (int j = -2; j < 3; j++)
/*     */       {
/* 923 */         buildBlock(world, x + 1 + i, y + 2, z + j, ModdedBlocks.SakuraLeaves, 1);
/*     */       }
/*     */     } 
/*     */     
/* 927 */     buildBlock(world, x, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 928 */     buildBlock(world, x + 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 929 */     buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 1);
/* 930 */     buildBlock(world, x + 4, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 931 */     buildBlock(world, x + 4, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 932 */     buildBlock(world, x + 4, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 933 */     buildBlock(world, x, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 934 */     buildBlock(world, x + 1, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 935 */     buildBlock(world, x + 2, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 1);
/* 936 */     buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 937 */     buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLeaves, 1);
/* 938 */     buildBlock(world, x - 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 1);
/*     */     
/* 940 */     buildBlock(world, x, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 941 */     buildBlock(world, x + 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 942 */     buildBlock(world, x + 2, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 1);
/* 943 */     buildBlock(world, x + 3, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 944 */     buildBlock(world, x + 3, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 945 */     buildBlock(world, x + 3, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/* 946 */     buildBlock(world, x, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 947 */     buildBlock(world, x + 1, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 948 */     buildBlock(world, x + 2, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 1);
/* 949 */     buildBlock(world, x - 1, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 1);
/* 950 */     buildBlock(world, x - 1, y + 3, z, ModdedBlocks.SakuraLeaves, 1);
/* 951 */     buildBlock(world, x - 1, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
/* 956 */     if (world.func_147437_c(x, y, z) || world.func_147439_a(x, y, z).isLeaves((IBlockAccess)world, x, y, z))
/* 957 */       func_150516_a(world, x, y, z, block, meta); 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\m\WorldGenMahagonyTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */