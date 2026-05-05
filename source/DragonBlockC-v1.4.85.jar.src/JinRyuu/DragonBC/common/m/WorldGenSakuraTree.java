/*     */ package JinRyuu.DragonBC.common.m;
/*     */ import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ 
/*     */ public class WorldGenSakuraTree extends WorldGenAbstractTree {
/*     */   public boolean b;
/*     */   
/*     */   public WorldGenSakuraTree() {
/*  14 */     super(false);
/*     */ 
/*     */ 
/*     */     
/*  18 */     this.b = false;
/*     */     this.b = false;
/*     */   } public WorldGenSakuraTree(boolean b) {
/*  21 */     super(false); this.b = false;
/*  22 */     this.b = b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random random, int x, int y, int z) {
/*  30 */     if (this.b) {
/*  31 */       while (world.func_147437_c(x, y, z) && y > 2)
/*     */       {
/*  33 */         y--;
/*     */       }
/*     */     } else {
/*  36 */       y--;
/*     */     } 
/*     */     
/*  39 */     Block block = world.func_147439_a(x, y, z);
/*  40 */     if (block != Blocks.field_150349_c && block != Blocks.field_150346_d)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  46 */     if (world.func_147437_c(x, y, z) && !world.func_147437_c(x, y + 2, z))
/*     */     {
/*     */       
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     int baselength = 3 + random.nextInt(4);
/*  53 */     int branches = 1;
/*     */     
/*  55 */     int h = 1;
/*     */     
/*  57 */     block.onPlantGrow(world, x, y, z, x, y, z);
/*     */ 
/*     */     
/*  60 */     if (world.func_72904_c(x - 8, y, z - 8, x + 10, y + 8, z + 8)) {
/*     */       
/*  62 */       for (int i = 0; i < baselength; i++) {
/*  63 */         buildBlock(world, x, y + h, z, ModdedBlocks.SakuraLogs, 0);
/*  64 */         h++;
/*     */       } 
/*     */       
/*  67 */       int dec = random.nextInt(3);
/*  68 */       if (dec == 0) {
/*  69 */         int c = 1;
/*     */         
/*  71 */         for (int j = 0; j < branches; j++) {
/*  72 */           generateTreeOne(world, random, x, y + h, z, c);
/*  73 */           c++;
/*  74 */           h += 2;
/*     */         }
/*     */       
/*  77 */       } else if (dec == 1) {
/*     */         
/*  79 */         int c = 1;
/*     */         
/*  81 */         for (int j = 0; j < branches; j++) {
/*  82 */           generateTreeTwo(world, random, x, y + h, z, c);
/*  83 */           c++;
/*  84 */           h += 2;
/*     */         }
/*     */       
/*  87 */       } else if (dec == 2) {
/*     */         
/*  89 */         int c = 1;
/*     */         
/*  91 */         for (int j = 0; j < branches; j++) {
/*  92 */           generateTreeThree(world, random, x, y + h, z, c);
/*  93 */           c++;
/*  94 */           h += 2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateTreeTwo(World world, Random random, int x, int y, int z, int p) {
/* 107 */     for (int h = 0; h < 5; h++) {
/*     */       
/* 109 */       for (int i = -1; i < 2; i++) {
/*     */         
/* 111 */         for (int j = -1; j < 2; j++)
/*     */         {
/* 113 */           buildBlock(world, x + i, y + h, z + j, ModdedBlocks.SakuraLeaves, 0);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     buildBlock(world, x, y, z, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 123 */     buildBlock(world, x, y + 1, z, ModdedBlocks.SakuraLogs, 0);
/* 124 */     buildBlock(world, x - 1, y + 1, z, ModdedBlocks.SakuraLogs, 0);
/* 125 */     buildBlock(world, x, y + 1, z - 1, ModdedBlocks.SakuraLogs, 0);
/* 126 */     buildBlock(world, x, y + 1, z - 2, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 128 */     buildBlock(world, x, y + 2, z, ModdedBlocks.SakuraLogs, 0);
/* 129 */     buildBlock(world, x + 1, y + 2, z, ModdedBlocks.SakuraLogs, 0);
/* 130 */     buildBlock(world, x, y + 2, z + 1, ModdedBlocks.SakuraLogs, 0);
/* 131 */     buildBlock(world, x, y + 2, z + 2, ModdedBlocks.SakuraLogs, 0);
/* 132 */     buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 134 */     buildBlock(world, x, y + 3, z, ModdedBlocks.SakuraLogs, 0);
/* 135 */     buildBlock(world, x, y + 3, z - 1, ModdedBlocks.SakuraLogs, 0);
/*     */ 
/*     */     
/* 138 */     buildBlock(world, x, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 139 */     buildBlock(world, x + 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 140 */     buildBlock(world, x - 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 141 */     buildBlock(world, x - 2, y, z, ModdedBlocks.SakuraLeaves, 0);
/* 142 */     buildBlock(world, x - 2, y, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 143 */     buildBlock(world, x, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 144 */     buildBlock(world, x, y, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 145 */     buildBlock(world, x + 1, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 146 */     buildBlock(world, x - 1, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 148 */     buildBlock(world, x, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 149 */     buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 150 */     buildBlock(world, x - 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 151 */     buildBlock(world, x + 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 152 */     buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 153 */     buildBlock(world, x - 2, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 154 */     buildBlock(world, x, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 155 */     buildBlock(world, x + 1, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 156 */     buildBlock(world, x - 1, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 158 */     buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 159 */     buildBlock(world, x + 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 160 */     buildBlock(world, x + 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 162 */     buildBlock(world, x, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 0);
/* 163 */     buildBlock(world, x - 1, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 165 */     buildBlock(world, x - 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 166 */     buildBlock(world, x - 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 167 */     buildBlock(world, x - 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 168 */     buildBlock(world, x - 2, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 170 */     buildBlock(world, x - 3, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 171 */     buildBlock(world, x - 3, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 172 */     buildBlock(world, x - 3, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 173 */     buildBlock(world, x - 4, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 174 */     buildBlock(world, x - 4, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 175 */     buildBlock(world, x - 4, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 177 */     buildBlock(world, x + 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 178 */     buildBlock(world, x - 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 179 */     buildBlock(world, x + 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 180 */     buildBlock(world, x - 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 181 */     buildBlock(world, x - 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 182 */     buildBlock(world, x, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 183 */     buildBlock(world, x + 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 184 */     buildBlock(world, x - 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 186 */     buildBlock(world, x + 2, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 187 */     buildBlock(world, x + 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 188 */     buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 190 */     buildBlock(world, x, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
/* 191 */     buildBlock(world, x - 1, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
/*     */ 
/*     */     
/* 194 */     buildBlock(world, x - 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 195 */     buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 196 */     buildBlock(world, x - 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 197 */     buildBlock(world, x - 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 199 */     buildBlock(world, x - 3, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 200 */     buildBlock(world, x - 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 201 */     buildBlock(world, x - 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 202 */     buildBlock(world, x - 4, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 203 */     buildBlock(world, x - 4, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 204 */     buildBlock(world, x - 4, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 206 */     buildBlock(world, x, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 207 */     buildBlock(world, x + 2, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
/* 208 */     buildBlock(world, x - 2, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
/* 209 */     buildBlock(world, x - 2, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 210 */     buildBlock(world, x - 2, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 211 */     buildBlock(world, x - 3, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
/* 212 */     buildBlock(world, x - 3, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 213 */     buildBlock(world, x, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 214 */     buildBlock(world, x + 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 215 */     buildBlock(world, x - 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 217 */     buildBlock(world, x - 1, y + 4, z + 1, Blocks.field_150350_a, 0);
/* 218 */     buildBlock(world, x + 1, y + 4, z + 1, Blocks.field_150350_a, 0);
/* 219 */     buildBlock(world, x - 2, y + 4, z, ModdedBlocks.SakuraLeaves, 0);
/* 220 */     buildBlock(world, x, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 221 */     buildBlock(world, x - 1, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 222 */     buildBlock(world, x + 1, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateTreeOne(World world, Random random, int x, int y, int z, int p) {
/* 229 */     for (int i = -1; i < 2; i++) {
/*     */       
/* 231 */       for (int j = -1; j < 2; j++)
/*     */       {
/* 233 */         buildBlock(world, x + i, y, z + j, ModdedBlocks.SakuraLeaves, 0);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 238 */     buildBlock(world, x - 1, y, z, ModdedBlocks.SakuraLogs, 0);
/* 239 */     buildBlock(world, x + 1, y, z - 1, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 241 */     buildBlock(world, x + 2, y + 1, z - 1, ModdedBlocks.SakuraLogs, 0);
/* 242 */     buildBlock(world, x + 2, y + 1, z - 2, ModdedBlocks.SakuraLogs, 0);
/* 243 */     buildBlock(world, x - 1, y + 1, z, ModdedBlocks.SakuraLogs, 0);
/* 244 */     buildBlock(world, x - 1, y + 1, z + 1, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 246 */     buildBlock(world, x - 1, y + 2, z, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 248 */     buildBlock(world, x, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 249 */     buildBlock(world, x - 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 250 */     buildBlock(world, x + 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 252 */     buildBlock(world, x + 2, y, z, ModdedBlocks.SakuraLeaves, 0);
/* 253 */     buildBlock(world, x + 2, y, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 254 */     buildBlock(world, x + 2, y, z + 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 256 */     buildBlock(world, x - 2, y, z, ModdedBlocks.SakuraLeaves, 0);
/* 257 */     buildBlock(world, x - 2, y, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 258 */     buildBlock(world, x - 2, y, z + 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 260 */     buildBlock(world, x, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 261 */     buildBlock(world, x - 1, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 262 */     buildBlock(world, x + 2, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 263 */     buildBlock(world, x + 1, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 265 */     buildBlock(world, x, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 266 */     buildBlock(world, x, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 267 */     buildBlock(world, x, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 268 */     buildBlock(world, x + 1, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 269 */     buildBlock(world, x + 1, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 270 */     buildBlock(world, x + 1, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 271 */     buildBlock(world, x - 1, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 273 */     buildBlock(world, x, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 274 */     buildBlock(world, x - 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 275 */     buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 277 */     buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 278 */     buildBlock(world, x + 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 280 */     buildBlock(world, x - 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 281 */     buildBlock(world, x - 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 282 */     buildBlock(world, x - 2, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 284 */     buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 285 */     buildBlock(world, x, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 286 */     buildBlock(world, x + 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */ 
/*     */     
/* 289 */     buildBlock(world, x + 3, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 290 */     buildBlock(world, x + 3, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 291 */     buildBlock(world, x + 3, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 292 */     buildBlock(world, x + 3, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 293 */     buildBlock(world, x + 3, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 295 */     buildBlock(world, x + 2, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 296 */     buildBlock(world, x + 1, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 297 */     buildBlock(world, x, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 299 */     buildBlock(world, x, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 300 */     buildBlock(world, x, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 301 */     buildBlock(world, x, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 302 */     buildBlock(world, x + 1, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 303 */     buildBlock(world, x + 1, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 304 */     buildBlock(world, x + 1, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 305 */     buildBlock(world, x - 1, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 306 */     buildBlock(world, x - 1, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 308 */     buildBlock(world, x, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 309 */     buildBlock(world, x - 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 310 */     buildBlock(world, x + 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 311 */     buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/*     */ 
/*     */     
/* 314 */     buildBlock(world, x + 2, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 315 */     buildBlock(world, x + 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 316 */     buildBlock(world, x + 2, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 318 */     buildBlock(world, x - 2, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 319 */     buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 320 */     buildBlock(world, x - 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 321 */     buildBlock(world, x - 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 323 */     buildBlock(world, x, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */ 
/*     */     
/* 326 */     buildBlock(world, x + 3, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 327 */     buildBlock(world, x + 3, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 328 */     buildBlock(world, x + 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 330 */     buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 331 */     buildBlock(world, x + 1, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 333 */     buildBlock(world, x, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
/* 334 */     buildBlock(world, x, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 335 */     buildBlock(world, x + 1, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
/* 336 */     buildBlock(world, x + 1, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 337 */     buildBlock(world, x - 1, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 338 */     buildBlock(world, x - 1, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 339 */     buildBlock(world, x - 1, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
/* 340 */     buildBlock(world, x + 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 341 */     buildBlock(world, x + 2, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 342 */     buildBlock(world, x + 2, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateTreeThree(World world, Random random, int x, int y, int z, int p) {
/* 349 */     for (int h = 1; h < 8; h++) {
/*     */       
/* 351 */       for (int j = -1; j < 2; j++) {
/*     */         
/* 353 */         for (int k = -1; k < 2; k++)
/*     */         {
/* 355 */           buildBlock(world, x + j, y + h, z + k, ModdedBlocks.SakuraLeaves, 0);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 360 */     for (int i = 0; i < 7; i++) {
/* 361 */       buildBlock(world, x, y + i, z, ModdedBlocks.SakuraLogs, 0);
/*     */     }
/*     */     
/* 364 */     buildBlock(world, x + 1, y + 1, z, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 366 */     buildBlock(world, x + 1, y + 2, z, ModdedBlocks.SakuraLogs, 0);
/* 367 */     buildBlock(world, x + 1, y + 2, z + 1, ModdedBlocks.SakuraLogs, 0);
/* 368 */     buildBlock(world, x + 4, y + 2, z + 2, ModdedBlocks.SakuraLogs, 0);
/* 369 */     buildBlock(world, x - 3, y + 2, z + 2, ModdedBlocks.SakuraLogs, 0);
/* 370 */     buildBlock(world, x - 2, y + 2, z - 2, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 372 */     buildBlock(world, x - 2, y + 3, z + 2, ModdedBlocks.SakuraLogs, 0);
/* 373 */     buildBlock(world, x + 4, y + 3, z + 2, ModdedBlocks.SakuraLogs, 0);
/* 374 */     buildBlock(world, x + 2, y + 3, z, ModdedBlocks.SakuraLogs, 0);
/* 375 */     buildBlock(world, x + 3, y + 3, z - 3, ModdedBlocks.SakuraLogs, 0);
/* 376 */     buildBlock(world, x - 2, y + 3, z - 2, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 378 */     buildBlock(world, x + 2, y + 4, z, ModdedBlocks.SakuraLogs, 0);
/* 379 */     buildBlock(world, x + 3, y + 4, z - 3, ModdedBlocks.SakuraLogs, 0);
/* 380 */     buildBlock(world, x + 4, y + 4, z + 1, ModdedBlocks.SakuraLogs, 0);
/* 381 */     buildBlock(world, x - 2, y + 4, z - 2, ModdedBlocks.SakuraLogs, 0);
/* 382 */     buildBlock(world, x - 2, y + 4, z + 2, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 384 */     buildBlock(world, x - 1, y + 5, z + 1, ModdedBlocks.SakuraLogs, 0);
/* 385 */     buildBlock(world, x, y + 5, z, ModdedBlocks.SakuraLogs, 0);
/* 386 */     buildBlock(world, x + 4, y + 5, z + 1, ModdedBlocks.SakuraLogs, 0);
/* 387 */     buildBlock(world, x - 1, y + 5, z - 1, ModdedBlocks.SakuraLogs, 0);
/* 388 */     buildBlock(world, x + 3, y + 5, z, ModdedBlocks.SakuraLogs, 0);
/* 389 */     buildBlock(world, x + 3, y + 5, z - 1, ModdedBlocks.SakuraLogs, 0);
/* 390 */     buildBlock(world, x + 3, y + 5, z - 2, ModdedBlocks.SakuraLogs, 0);
/*     */     
/* 392 */     buildBlock(world, x + 3, y + 6, z, ModdedBlocks.SakuraLogs, 0);
/*     */ 
/*     */ 
/*     */     
/* 396 */     buildBlock(world, x - 3, y - 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 397 */     buildBlock(world, x - 2, y - 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 398 */     buildBlock(world, x + 1, y - 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 399 */     buildBlock(world, x + 2, y - 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 400 */     buildBlock(world, x + 4, y - 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 402 */     buildBlock(world, x - 3, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 403 */     buildBlock(world, x - 2, y, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 404 */     buildBlock(world, x + 1, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 405 */     buildBlock(world, x + 2, y, z, ModdedBlocks.SakuraLeaves, 0);
/* 406 */     buildBlock(world, x + 4, y, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 407 */     buildBlock(world, x + 3, y, z - 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 409 */     buildBlock(world, x - 3, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 410 */     buildBlock(world, x - 2, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 411 */     buildBlock(world, x + 1, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 412 */     buildBlock(world, x + 2, y + 1, z, ModdedBlocks.SakuraLeaves, 0);
/* 413 */     buildBlock(world, x + 4, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 414 */     buildBlock(world, x + 3, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 415 */     buildBlock(world, x - 2, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 416 */     buildBlock(world, x - 3, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 0);
/* 417 */     buildBlock(world, x - 3, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 418 */     buildBlock(world, x - 4, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 419 */     buildBlock(world, x - 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 420 */     buildBlock(world, x - 3, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 421 */     buildBlock(world, x - 2, y + 1, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 422 */     buildBlock(world, x - 1, y + 1, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 423 */     buildBlock(world, x - 2, y + 1, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 424 */     buildBlock(world, x + 3, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 425 */     buildBlock(world, x + 4, y + 1, z + 3, ModdedBlocks.SakuraLeaves, 0);
/* 426 */     buildBlock(world, x + 4, y + 1, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 427 */     buildBlock(world, x + 5, y + 1, z + 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 429 */     buildBlock(world, x + 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 430 */     buildBlock(world, x + 2, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 431 */     buildBlock(world, x + 1, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 432 */     buildBlock(world, x + 2, y + 2, z, ModdedBlocks.SakuraLeaves, 0);
/* 433 */     buildBlock(world, x + 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 434 */     buildBlock(world, x + 3, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 435 */     buildBlock(world, x + 3, y + 2, z - 4, ModdedBlocks.SakuraLeaves, 0);
/* 436 */     buildBlock(world, x + 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 437 */     buildBlock(world, x + 4, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 438 */     buildBlock(world, x - 2, y + 2, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 439 */     buildBlock(world, x - 1, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 440 */     buildBlock(world, x - 3, y + 2, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 441 */     buildBlock(world, x - 2, y + 2, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 442 */     buildBlock(world, x - 4, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 443 */     buildBlock(world, x - 3, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 444 */     buildBlock(world, x - 1, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 445 */     buildBlock(world, x - 2, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 446 */     buildBlock(world, x - 2, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
/* 447 */     buildBlock(world, x - 3, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
/* 448 */     buildBlock(world, x + 4, y + 2, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 449 */     buildBlock(world, x + 3, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 450 */     buildBlock(world, x + 5, y + 2, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 451 */     buildBlock(world, x + 4, y + 2, z + 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 453 */     buildBlock(world, x - 1, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 454 */     buildBlock(world, x - 3, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 455 */     buildBlock(world, x - 2, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 0);
/* 456 */     buildBlock(world, x - 2, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 457 */     buildBlock(world, x - 2, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 458 */     buildBlock(world, x - 2, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 459 */     buildBlock(world, x - 3, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 460 */     buildBlock(world, x - 1, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 461 */     buildBlock(world, x, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 462 */     buildBlock(world, x + 3, y + 3, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 463 */     buildBlock(world, x + 3, y + 3, z - 4, ModdedBlocks.SakuraLeaves, 0);
/* 464 */     buildBlock(world, x + 2, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 465 */     buildBlock(world, x + 4, y + 3, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 466 */     buildBlock(world, x + 2, y + 3, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 467 */     buildBlock(world, x + 3, y + 3, z, ModdedBlocks.SakuraLeaves, 0);
/* 468 */     buildBlock(world, x + 2, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 469 */     buildBlock(world, x + 4, y + 3, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 470 */     buildBlock(world, x + 3, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 471 */     buildBlock(world, x + 5, y + 3, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 472 */     buildBlock(world, x + 4, y + 3, z + 3, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 474 */     buildBlock(world, x - 2, y + 4, z + 3, ModdedBlocks.SakuraLeaves, 0);
/* 475 */     buildBlock(world, x - 3, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 476 */     buildBlock(world, x - 1, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 477 */     buildBlock(world, x - 2, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 478 */     buildBlock(world, x - 2, y + 4, z, ModdedBlocks.SakuraLeaves, 0);
/* 479 */     buildBlock(world, x - 2, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 480 */     buildBlock(world, x - 2, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 481 */     buildBlock(world, x - 3, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 482 */     buildBlock(world, x - 1, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 483 */     buildBlock(world, x, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 484 */     buildBlock(world, x + 1, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 485 */     buildBlock(world, x + 3, y + 4, z - 4, ModdedBlocks.SakuraLeaves, 0);
/* 486 */     buildBlock(world, x + 4, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 487 */     buildBlock(world, x + 2, y + 4, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 488 */     buildBlock(world, x + 3, y + 4, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 489 */     buildBlock(world, x + 2, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 490 */     buildBlock(world, x + 3, y + 4, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 491 */     buildBlock(world, x + 3, y + 4, z, ModdedBlocks.SakuraLeaves, 0);
/* 492 */     buildBlock(world, x + 4, y + 4, z, ModdedBlocks.SakuraLeaves, 0);
/* 493 */     buildBlock(world, x + 2, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 494 */     buildBlock(world, x + 3, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 495 */     buildBlock(world, x + 5, y + 4, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 496 */     buildBlock(world, x + 4, y + 4, z + 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 498 */     buildBlock(world, x - 1, y + 5, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 499 */     buildBlock(world, x - 2, y + 5, z + 2, ModdedBlocks.SakuraLeaves, 0);
/* 500 */     buildBlock(world, x - 2, y + 5, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 501 */     buildBlock(world, x - 2, y + 5, z, ModdedBlocks.SakuraLeaves, 0);
/* 502 */     buildBlock(world, x - 2, y + 5, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 503 */     buildBlock(world, x - 2, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 504 */     buildBlock(world, x - 1, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 505 */     buildBlock(world, x, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 506 */     buildBlock(world, x + 1, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 507 */     buildBlock(world, x + 2, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 508 */     buildBlock(world, x + 4, y + 5, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 509 */     buildBlock(world, x + 3, y + 5, z - 3, ModdedBlocks.SakuraLeaves, 0);
/* 510 */     buildBlock(world, x + 2, y + 5, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 511 */     buildBlock(world, x + 4, y + 5, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 512 */     buildBlock(world, x + 4, y + 5, z, ModdedBlocks.SakuraLeaves, 0);
/* 513 */     buildBlock(world, x + 2, y + 5, z, ModdedBlocks.SakuraLeaves, 0);
/* 514 */     buildBlock(world, x + 3, y + 5, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 515 */     buildBlock(world, x + 5, y + 5, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 516 */     buildBlock(world, x + 4, y + 5, z + 2, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 518 */     buildBlock(world, x - 2, y + 6, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 519 */     buildBlock(world, x - 2, y + 6, z, ModdedBlocks.SakuraLeaves, 0);
/* 520 */     buildBlock(world, x - 2, y + 6, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 521 */     buildBlock(world, x - 1, y + 6, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 522 */     buildBlock(world, x + 1, y + 6, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 523 */     buildBlock(world, x + 3, y + 6, z - 2, ModdedBlocks.SakuraLeaves, 0);
/* 524 */     buildBlock(world, x + 2, y + 6, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 525 */     buildBlock(world, x + 3, y + 6, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 526 */     buildBlock(world, x + 4, y + 6, z - 1, ModdedBlocks.SakuraLeaves, 0);
/* 527 */     buildBlock(world, x + 2, y + 6, z, ModdedBlocks.SakuraLeaves, 0);
/* 528 */     buildBlock(world, x + 4, y + 6, z, ModdedBlocks.SakuraLeaves, 0);
/* 529 */     buildBlock(world, x + 3, y + 6, z + 1, ModdedBlocks.SakuraLeaves, 0);
/* 530 */     buildBlock(world, x + 4, y + 6, z + 1, ModdedBlocks.SakuraLeaves, 0);
/*     */     
/* 532 */     buildBlock(world, x + 1, y + 7, z + 1, Blocks.field_150350_a, 0);
/* 533 */     buildBlock(world, x + 2, y + 7, z, ModdedBlocks.SakuraLeaves, 0);
/* 534 */     buildBlock(world, x + 3, y + 7, z, ModdedBlocks.SakuraLeaves, 0);
/* 535 */     buildBlock(world, x + 2, y + 7, z - 1, ModdedBlocks.SakuraLeaves, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
/* 543 */     if (world
/* 544 */       .func_147437_c(x, y, z) || world
/* 545 */       .func_147439_a(x, y, z).isLeaves((IBlockAccess)world, x, y, z))
/*     */     {
/* 547 */       func_150516_a(world, x, y, z, block, meta);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\m\WorldGenSakuraTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */