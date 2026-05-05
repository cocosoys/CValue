/*     */ package JinRyuu.DragonBC.common.m;
/*     */ import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ 
/*     */ public class WorldGenMapleTree extends WorldGenAbstractTree {
/*     */   public boolean b;
/*     */   
/*     */   public WorldGenMapleTree() {
/*  14 */     super(false);
/*     */ 
/*     */ 
/*     */     
/*  18 */     this.b = false;
/*     */     this.b = false;
/*     */   } public WorldGenMapleTree(boolean b) {
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
/*  46 */     if (world.func_147437_c(x, y, z))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     int baselength = 0 + random.nextInt(1);
/*  52 */     int branches = 1;
/*     */     
/*  54 */     int h = 1;
/*     */     
/*  56 */     block.onPlantGrow(world, x, y, z, x, y, z);
/*     */     
/*  58 */     for (int i = 0; i < baselength; i++) {
/*  59 */       buildBlock(world, x, y + h, z, ModdedBlocks.SakuraLogs, 2);
/*  60 */       h++;
/*     */     } 
/*     */     
/*  63 */     int dec = random.nextInt(2);
/*  64 */     if (dec == 0) {
/*  65 */       int c = 1;
/*     */       
/*  67 */       for (int j = 0; j < branches; j++) {
/*  68 */         generateTreeOne(world, random, x, y + h, z, c);
/*  69 */         c++;
/*  70 */         h += 2;
/*     */       }
/*     */     
/*  73 */     } else if (dec == 1) {
/*     */       
/*  75 */       int c = 1;
/*     */       
/*  77 */       for (int j = 0; j < branches; j++) {
/*  78 */         generateTreeTwo(world, random, x, y + h, z, c);
/*  79 */         c++;
/*  80 */         h += 2;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  85 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateTreeTwo(World world, Random random, int i, int j, int k, int c) {
/*  92 */     buildBlock(world, i - 4, j + 6, k - 4, ModdedBlocks.MapleLeafs, 0);
/*  93 */     buildBlock(world, i - 4, j + 6, k - 3, ModdedBlocks.MapleLeafs, 0);
/*  94 */     buildBlock(world, i - 4, j + 7, k - 4, ModdedBlocks.MapleLeafs, 0);
/*  95 */     buildBlock(world, i - 3, j + 4, k - 3, ModdedBlocks.MapleLeafs, 0);
/*  96 */     buildBlock(world, i - 3, j + 4, k - 1, ModdedBlocks.MapleLeafs, 0);
/*  97 */     buildBlock(world, i - 3, j + 5, k - 4, ModdedBlocks.MapleLeafs, 0);
/*  98 */     buildBlock(world, i - 3, j + 5, k - 3, ModdedBlocks.MapleLeafs, 0);
/*  99 */     buildBlock(world, i - 3, j + 5, k - 2, ModdedBlocks.MapleLeafs, 0);
/*     */     
/* 101 */     buildBlock(world, i - 3, j + 6, k - 5, ModdedBlocks.MapleLeafs, 0);
/*     */     
/* 103 */     buildBlock(world, i - 3, j + 6, k - 4, ModdedBlocks.SakuraLogs, 2);
/* 104 */     buildBlock(world, i - 3, j + 6, k - 3, ModdedBlocks.SakuraLogs, 2);
/* 105 */     buildBlock(world, i - 3, j + 6, k - 2, ModdedBlocks.MapleLeafs, 0);
/*     */     
/* 107 */     buildBlock(world, i - 3, j + 7, k - 5, ModdedBlocks.MapleLeafs, 0);
/*     */     
/* 109 */     buildBlock(world, i - 3, j + 7, k - 4, ModdedBlocks.SakuraLogs, 2);
/* 110 */     buildBlock(world, i - 3, j + 7, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 111 */     buildBlock(world, i - 3, j + 8, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 112 */     buildBlock(world, i - 2, j + 2, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 113 */     buildBlock(world, i - 2, j + 3, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 114 */     buildBlock(world, i - 2, j + 3, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 115 */     buildBlock(world, i - 2, j + 4, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 116 */     buildBlock(world, i - 2, j + 4, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 117 */     buildBlock(world, i - 2, j + 4, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 118 */     buildBlock(world, i - 2, j + 4, k, ModdedBlocks.MapleLeafs, 0);
/* 119 */     buildBlock(world, i - 2, j + 5, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 120 */     buildBlock(world, i - 2, j + 5, k - 3, ModdedBlocks.SakuraLogs, 2);
/* 121 */     buildBlock(world, i - 2, j + 5, k - 2, ModdedBlocks.SakuraLogs, 2);
/* 122 */     buildBlock(world, i - 2, j + 5, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 123 */     buildBlock(world, i - 2, j + 5, k, ModdedBlocks.MapleLeafs, 0);
/* 124 */     buildBlock(world, i - 2, j + 6, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 125 */     buildBlock(world, i - 2, j + 6, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 126 */     buildBlock(world, i - 2, j + 6, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 127 */     buildBlock(world, i - 2, j + 6, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 128 */     buildBlock(world, i - 2, j + 7, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 129 */     buildBlock(world, i - 2, j + 7, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 130 */     buildBlock(world, i - 2, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 131 */     buildBlock(world, i - 2, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 132 */     buildBlock(world, i - 2, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 133 */     buildBlock(world, i - 1, j + 3, k - 1, ModdedBlocks.SakuraLogs, 2);
/* 134 */     buildBlock(world, i - 1, j + 3, k, ModdedBlocks.MapleLeafs, 0);
/* 135 */     buildBlock(world, i - 1, j + 4, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 136 */     buildBlock(world, i - 1, j + 4, k - 1, ModdedBlocks.SakuraLogs, 2);
/* 137 */     buildBlock(world, i - 1, j + 4, k, ModdedBlocks.MapleLeafs, 0);
/* 138 */     buildBlock(world, i - 1, j + 4, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 139 */     buildBlock(world, i - 1, j + 5, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 140 */     buildBlock(world, i - 1, j + 5, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 141 */     buildBlock(world, i - 1, j + 5, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 142 */     buildBlock(world, i - 1, j + 5, k, ModdedBlocks.MapleLeafs, 0);
/* 143 */     buildBlock(world, i - 1, j + 5, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 144 */     buildBlock(world, i - 1, j + 6, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 145 */     buildBlock(world, i - 1, j + 6, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 146 */     buildBlock(world, i - 1, j + 6, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 147 */     buildBlock(world, i - 1, j + 6, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 148 */     buildBlock(world, i - 1, j + 6, k, ModdedBlocks.MapleLeafs, 0);
/* 149 */     buildBlock(world, i - 1, j + 7, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 150 */     buildBlock(world, i - 1, j + 7, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 151 */     buildBlock(world, i - 1, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 152 */     buildBlock(world, i - 1, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 153 */     buildBlock(world, i - 1, j + 8, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 154 */     buildBlock(world, i - 1, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 155 */     buildBlock(world, i, j + 0, k, ModdedBlocks.SakuraLogs, 2);
/* 156 */     buildBlock(world, i, j + 1, k, ModdedBlocks.SakuraLogs, 2);
/* 157 */     buildBlock(world, i, j + 2, k, ModdedBlocks.SakuraLogs, 2);
/* 158 */     buildBlock(world, i, j + 2, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 159 */     buildBlock(world, i, j + 3, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 160 */     buildBlock(world, i, j + 3, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 161 */     buildBlock(world, i, j + 3, k - 1, ModdedBlocks.SakuraLogs, 2);
/* 162 */     buildBlock(world, i, j + 3, k, ModdedBlocks.MapleLeafs, 0);
/* 163 */     buildBlock(world, i, j + 3, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 164 */     buildBlock(world, i, j + 4, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 165 */     buildBlock(world, i, j + 4, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 166 */     buildBlock(world, i, j + 4, k, ModdedBlocks.MapleLeafs, 0);
/* 167 */     buildBlock(world, i, j + 4, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 168 */     buildBlock(world, i, j + 5, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 169 */     buildBlock(world, i, j + 5, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 170 */     buildBlock(world, i, j + 5, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 171 */     buildBlock(world, i, j + 5, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 172 */     buildBlock(world, i, j + 5, k, ModdedBlocks.MapleLeafs, 0);
/* 173 */     buildBlock(world, i, j + 5, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 174 */     buildBlock(world, i, j + 5, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 175 */     buildBlock(world, i, j + 6, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 176 */     buildBlock(world, i, j + 6, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 177 */     buildBlock(world, i, j + 6, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 178 */     buildBlock(world, i, j + 6, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 179 */     buildBlock(world, i, j + 6, k, ModdedBlocks.MapleLeafs, 0);
/* 180 */     buildBlock(world, i, j + 6, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 181 */     buildBlock(world, i, j + 6, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 182 */     buildBlock(world, i, j + 7, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 183 */     buildBlock(world, i, j + 7, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 184 */     buildBlock(world, i, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 185 */     buildBlock(world, i, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 186 */     buildBlock(world, i, j + 8, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 187 */     buildBlock(world, i, j + 8, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 188 */     buildBlock(world, i, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 189 */     buildBlock(world, i + 1, j + 2, k, ModdedBlocks.SakuraLogs, 2);
/* 190 */     buildBlock(world, i + 1, j + 3, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 191 */     buildBlock(world, i + 1, j + 3, k, ModdedBlocks.SakuraLogs, 2);
/* 192 */     buildBlock(world, i + 1, j + 4, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 193 */     buildBlock(world, i + 1, j + 4, k, ModdedBlocks.MapleLeafs, 0);
/* 194 */     buildBlock(world, i + 1, j + 5, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 195 */     buildBlock(world, i + 1, j + 5, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 196 */     buildBlock(world, i + 1, j + 5, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 197 */     buildBlock(world, i + 1, j + 5, k, ModdedBlocks.MapleLeafs, 0);
/* 198 */     buildBlock(world, i + 1, j + 5, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 199 */     buildBlock(world, i + 1, j + 6, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 200 */     buildBlock(world, i + 1, j + 6, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 201 */     buildBlock(world, i + 1, j + 6, k, ModdedBlocks.MapleLeafs, 0);
/* 202 */     buildBlock(world, i + 1, j + 7, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 203 */     buildBlock(world, i + 1, j + 7, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 204 */     buildBlock(world, i + 1, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 205 */     buildBlock(world, i + 1, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 206 */     buildBlock(world, i + 1, j + 7, k, ModdedBlocks.MapleLeafs, 0);
/* 207 */     buildBlock(world, i + 1, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 208 */     buildBlock(world, i + 1, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 209 */     buildBlock(world, i + 1, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 210 */     buildBlock(world, i + 2, j + 2, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 211 */     buildBlock(world, i + 2, j + 3, k, ModdedBlocks.MapleLeafs, 0);
/* 212 */     buildBlock(world, i + 2, j + 3, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 213 */     buildBlock(world, i + 2, j + 3, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 214 */     buildBlock(world, i + 2, j + 4, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 215 */     buildBlock(world, i + 2, j + 4, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 216 */     buildBlock(world, i + 2, j + 4, k, ModdedBlocks.SakuraLogs, 2);
/* 217 */     buildBlock(world, i + 2, j + 4, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 218 */     buildBlock(world, i + 2, j + 5, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 219 */     buildBlock(world, i + 2, j + 5, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 220 */     buildBlock(world, i + 2, j + 5, k, ModdedBlocks.SakuraLogs, 2);
/* 221 */     buildBlock(world, i + 2, j + 5, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 222 */     buildBlock(world, i + 2, j + 6, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 223 */     buildBlock(world, i + 2, j + 6, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 224 */     buildBlock(world, i + 2, j + 6, k, ModdedBlocks.MapleLeafs, 0);
/* 225 */     buildBlock(world, i + 2, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 226 */     buildBlock(world, i + 2, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 227 */     buildBlock(world, i + 2, j + 7, k, ModdedBlocks.MapleLeafs, 0);
/* 228 */     buildBlock(world, i + 2, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 229 */     buildBlock(world, i + 3, j + 4, k, ModdedBlocks.MapleLeafs, 0);
/* 230 */     buildBlock(world, i + 3, j + 4, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 231 */     buildBlock(world, i + 3, j + 5, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 232 */     buildBlock(world, i + 3, j + 5, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 233 */     buildBlock(world, i + 3, j + 5, k, ModdedBlocks.SakuraLogs, 2);
/* 234 */     buildBlock(world, i + 3, j + 5, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 235 */     buildBlock(world, i + 3, j + 6, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 236 */     buildBlock(world, i + 3, j + 6, k, ModdedBlocks.SakuraLogs, 2);
/* 237 */     buildBlock(world, i + 3, j + 6, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 238 */     buildBlock(world, i + 3, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 239 */     buildBlock(world, i + 3, j + 7, k, ModdedBlocks.SakuraLogs, 2);
/* 240 */     buildBlock(world, i + 3, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 241 */     buildBlock(world, i + 3, j + 8, k, ModdedBlocks.MapleLeafs, 0);
/* 242 */     buildBlock(world, i + 4, j + 3, k, ModdedBlocks.MapleLeafs, 0);
/* 243 */     buildBlock(world, i + 4, j + 3, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 244 */     buildBlock(world, i + 4, j + 4, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 245 */     buildBlock(world, i + 4, j + 4, k, ModdedBlocks.MapleLeafs, 0);
/* 246 */     buildBlock(world, i + 4, j + 5, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 247 */     buildBlock(world, i + 4, j + 5, k, ModdedBlocks.MapleLeafs, 0);
/* 248 */     buildBlock(world, i + 4, j + 5, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 249 */     buildBlock(world, i + 4, j + 6, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 250 */     buildBlock(world, i + 4, j + 6, k, ModdedBlocks.MapleLeafs, 0);
/* 251 */     buildBlock(world, i + 4, j + 7, k, ModdedBlocks.MapleLeafs, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateTreeOne(World world, Random random, int i, int j, int k, int c) {
/* 257 */     buildBlock(world, i - 5, j + 6, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 258 */     buildBlock(world, i - 5, j + 7, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 259 */     buildBlock(world, i - 5, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 260 */     buildBlock(world, i - 5, j + 8, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 261 */     buildBlock(world, i - 5, j + 9, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 262 */     buildBlock(world, i - 5, j + 10, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 263 */     buildBlock(world, i - 4, j + 5, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 264 */     buildBlock(world, i - 4, j + 6, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 265 */     buildBlock(world, i - 4, j + 6, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 266 */     buildBlock(world, i - 4, j + 7, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 267 */     buildBlock(world, i - 4, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 268 */     buildBlock(world, i - 4, j + 7, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 269 */     buildBlock(world, i - 4, j + 8, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 270 */     buildBlock(world, i - 4, j + 8, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 271 */     buildBlock(world, i - 4, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 272 */     buildBlock(world, i - 4, j + 9, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 273 */     buildBlock(world, i - 4, j + 9, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 274 */     buildBlock(world, i - 4, j + 9, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 275 */     buildBlock(world, i - 4, j + 9, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 276 */     buildBlock(world, i - 4, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 277 */     buildBlock(world, i - 4, j + 10, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 278 */     buildBlock(world, i - 4, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 279 */     buildBlock(world, i - 4, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 280 */     buildBlock(world, i - 3, j + 6, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 281 */     buildBlock(world, i - 3, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 282 */     buildBlock(world, i - 3, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 283 */     buildBlock(world, i - 3, j + 7, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 284 */     buildBlock(world, i - 3, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 285 */     buildBlock(world, i - 3, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 286 */     buildBlock(world, i - 3, j + 8, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 287 */     buildBlock(world, i - 3, j + 8, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 288 */     buildBlock(world, i - 3, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 289 */     buildBlock(world, i - 3, j + 9, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 290 */     buildBlock(world, i - 3, j + 9, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 291 */     buildBlock(world, i - 3, j + 9, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 292 */     buildBlock(world, i - 3, j + 9, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 293 */     buildBlock(world, i - 3, j + 10, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 294 */     buildBlock(world, i - 3, j + 10, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 295 */     buildBlock(world, i - 3, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 296 */     buildBlock(world, i - 3, j + 10, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 297 */     buildBlock(world, i - 3, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 298 */     buildBlock(world, i - 3, j + 11, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 299 */     buildBlock(world, i - 3, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 300 */     buildBlock(world, i - 2, j + 5, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 301 */     buildBlock(world, i - 2, j + 6, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 302 */     buildBlock(world, i - 2, j + 6, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 303 */     buildBlock(world, i - 2, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 304 */     buildBlock(world, i - 2, j + 7, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 305 */     buildBlock(world, i - 2, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 306 */     buildBlock(world, i - 2, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 307 */     buildBlock(world, i - 2, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 308 */     buildBlock(world, i - 2, j + 8, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 309 */     buildBlock(world, i - 2, j + 8, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 310 */     buildBlock(world, i - 2, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 311 */     buildBlock(world, i - 2, j + 9, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 312 */     buildBlock(world, i - 2, j + 9, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 313 */     buildBlock(world, i - 2, j + 9, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 314 */     buildBlock(world, i - 2, j + 9, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 315 */     buildBlock(world, i - 2, j + 9, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 316 */     buildBlock(world, i - 2, j + 9, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 317 */     buildBlock(world, i - 2, j + 9, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 318 */     buildBlock(world, i - 2, j + 10, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 319 */     buildBlock(world, i - 2, j + 10, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 320 */     buildBlock(world, i - 2, j + 10, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 321 */     buildBlock(world, i - 2, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 322 */     buildBlock(world, i - 2, j + 10, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 323 */     buildBlock(world, i - 2, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 324 */     buildBlock(world, i - 2, j + 11, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 325 */     buildBlock(world, i - 2, j + 11, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 326 */     buildBlock(world, i - 2, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 327 */     buildBlock(world, i - 2, j + 11, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 328 */     buildBlock(world, i - 2, j + 12, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 329 */     buildBlock(world, i - 1, j + 3, k - 7, ModdedBlocks.MapleLeafs, 0);
/* 330 */     buildBlock(world, i - 1, j + 4, k - 7, ModdedBlocks.MapleLeafs, 0);
/* 331 */     buildBlock(world, i - 1, j + 4, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 332 */     buildBlock(world, i - 1, j + 4, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 333 */     buildBlock(world, i - 1, j + 4, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 334 */     buildBlock(world, i - 1, j + 5, k - 7, ModdedBlocks.MapleLeafs, 0);
/* 335 */     buildBlock(world, i - 1, j + 5, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 336 */     buildBlock(world, i - 1, j + 5, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 337 */     buildBlock(world, i - 1, j + 6, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 338 */     buildBlock(world, i - 1, j + 6, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 339 */     buildBlock(world, i - 1, j + 6, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 340 */     buildBlock(world, i - 1, j + 6, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 341 */     buildBlock(world, i - 1, j + 6, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 342 */     buildBlock(world, i - 1, j + 7, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 343 */     buildBlock(world, i - 1, j + 7, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 344 */     buildBlock(world, i - 1, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 345 */     buildBlock(world, i - 1, j + 7, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 346 */     buildBlock(world, i - 1, j + 8, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 347 */     buildBlock(world, i - 1, j + 8, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 348 */     buildBlock(world, i - 1, j + 8, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 349 */     buildBlock(world, i - 1, j + 8, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 350 */     buildBlock(world, i - 1, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 351 */     buildBlock(world, i - 1, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 352 */     buildBlock(world, i - 1, j + 8, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 353 */     buildBlock(world, i - 1, j + 8, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 354 */     buildBlock(world, i - 1, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 355 */     buildBlock(world, i - 1, j + 9, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 356 */     buildBlock(world, i - 1, j + 9, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 357 */     buildBlock(world, i - 1, j + 9, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 358 */     buildBlock(world, i - 1, j + 9, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 359 */     buildBlock(world, i - 1, j + 9, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 360 */     buildBlock(world, i - 1, j + 9, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 361 */     buildBlock(world, i - 1, j + 9, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 362 */     buildBlock(world, i - 1, j + 9, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 363 */     buildBlock(world, i - 1, j + 10, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 364 */     buildBlock(world, i - 1, j + 10, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 365 */     buildBlock(world, i - 1, j + 10, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 366 */     buildBlock(world, i - 1, j + 10, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 367 */     buildBlock(world, i - 1, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 368 */     buildBlock(world, i - 1, j + 10, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 369 */     buildBlock(world, i - 1, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 370 */     buildBlock(world, i - 1, j + 11, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 371 */     buildBlock(world, i - 1, j + 11, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 372 */     buildBlock(world, i - 1, j + 11, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 373 */     buildBlock(world, i - 1, j + 11, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 374 */     buildBlock(world, i - 1, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 375 */     buildBlock(world, i - 1, j + 12, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 376 */     buildBlock(world, i - 1, j + 12, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 377 */     buildBlock(world, i - 1, j + 13, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 378 */     buildBlock(world, i + 0, j + 0, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 379 */     buildBlock(world, i + 0, j + 1, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 380 */     buildBlock(world, i + 0, j + 2, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 381 */     buildBlock(world, i + 0, j + 2, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 382 */     buildBlock(world, i + 0, j + 3, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 383 */     buildBlock(world, i + 0, j + 3, k - 3, ModdedBlocks.SakuraLogs, 2);
/* 384 */     buildBlock(world, i + 0, j + 3, k - 2, ModdedBlocks.SakuraLogs, 2);
/* 385 */     buildBlock(world, i + 0, j + 3, k - 1, ModdedBlocks.SakuraLogs, 2);
/* 386 */     buildBlock(world, i + 0, j + 3, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 387 */     buildBlock(world, i + 0, j + 4, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 388 */     buildBlock(world, i + 0, j + 4, k - 4, ModdedBlocks.SakuraLogs, 2);
/* 389 */     buildBlock(world, i + 0, j + 4, k - 3, ModdedBlocks.SakuraLogs, 2);
/* 390 */     buildBlock(world, i + 0, j + 4, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 391 */     buildBlock(world, i + 0, j + 4, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 392 */     buildBlock(world, i + 0, j + 5, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 393 */     buildBlock(world, i + 0, j + 5, k - 5, ModdedBlocks.SakuraLogs, 2);
/* 394 */     buildBlock(world, i + 0, j + 5, k - 4, ModdedBlocks.SakuraLogs, 2);
/* 395 */     buildBlock(world, i + 0, j + 5, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 396 */     buildBlock(world, i + 0, j + 5, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 397 */     buildBlock(world, i + 0, j + 6, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 398 */     buildBlock(world, i + 0, j + 6, k - 5, ModdedBlocks.SakuraLogs, 2);
/* 399 */     buildBlock(world, i + 0, j + 6, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 400 */     buildBlock(world, i + 0, j + 6, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 401 */     buildBlock(world, i + 0, j + 6, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 402 */     buildBlock(world, i + 0, j + 6, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 403 */     buildBlock(world, i + 0, j + 7, k - 7, ModdedBlocks.MapleLeafs, 0);
/* 404 */     buildBlock(world, i + 0, j + 7, k - 6, ModdedBlocks.SakuraLogs, 2);
/* 405 */     buildBlock(world, i + 0, j + 7, k - 5, ModdedBlocks.SakuraLogs, 2);
/* 406 */     buildBlock(world, i + 0, j + 7, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 407 */     buildBlock(world, i + 0, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 408 */     buildBlock(world, i + 0, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 409 */     buildBlock(world, i + 0, j + 7, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 410 */     buildBlock(world, i + 0, j + 7, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 411 */     buildBlock(world, i + 0, j + 7, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 412 */     buildBlock(world, i + 0, j + 8, k - 7, ModdedBlocks.MapleLeafs, 0);
/* 413 */     buildBlock(world, i + 0, j + 8, k - 6, ModdedBlocks.SakuraLogs, 2);
/* 414 */     buildBlock(world, i + 0, j + 8, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 415 */     buildBlock(world, i + 0, j + 8, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 416 */     buildBlock(world, i + 0, j + 8, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 417 */     buildBlock(world, i + 0, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 418 */     buildBlock(world, i + 0, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 419 */     buildBlock(world, i + 0, j + 8, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 420 */     buildBlock(world, i + 0, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 421 */     buildBlock(world, i + 0, j + 9, k - 7, ModdedBlocks.MapleLeafs, 0);
/* 422 */     buildBlock(world, i + 0, j + 9, k - 6, ModdedBlocks.SakuraLogs, 2);
/* 423 */     buildBlock(world, i + 0, j + 9, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 424 */     buildBlock(world, i + 0, j + 9, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 425 */     buildBlock(world, i + 0, j + 9, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 426 */     buildBlock(world, i + 0, j + 9, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 427 */     buildBlock(world, i + 0, j + 9, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 428 */     buildBlock(world, i + 0, j + 9, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 429 */     buildBlock(world, i + 0, j + 9, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 430 */     buildBlock(world, i + 0, j + 9, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 431 */     buildBlock(world, i + 0, j + 10, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 432 */     buildBlock(world, i + 0, j + 10, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 433 */     buildBlock(world, i + 0, j + 10, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 434 */     buildBlock(world, i + 0, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 435 */     buildBlock(world, i + 0, j + 10, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 436 */     buildBlock(world, i + 0, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 437 */     buildBlock(world, i + 0, j + 11, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 438 */     buildBlock(world, i + 0, j + 11, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 439 */     buildBlock(world, i + 0, j + 11, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 440 */     buildBlock(world, i + 0, j + 11, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 441 */     buildBlock(world, i + 0, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 442 */     buildBlock(world, i + 0, j + 11, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 443 */     buildBlock(world, i + 0, j + 12, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 444 */     buildBlock(world, i + 0, j + 12, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 445 */     buildBlock(world, i + 0, j + 12, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 446 */     buildBlock(world, i + 0, j + 13, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 447 */     buildBlock(world, i + 1, j + 3, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 448 */     buildBlock(world, i + 1, j + 4, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 449 */     buildBlock(world, i + 1, j + 4, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 450 */     buildBlock(world, i + 1, j + 4, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 451 */     buildBlock(world, i + 1, j + 5, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 452 */     buildBlock(world, i + 1, j + 5, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 453 */     buildBlock(world, i + 1, j + 5, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 454 */     buildBlock(world, i + 1, j + 6, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 455 */     buildBlock(world, i + 1, j + 6, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 456 */     buildBlock(world, i + 1, j + 6, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 457 */     buildBlock(world, i + 1, j + 7, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 458 */     buildBlock(world, i + 1, j + 7, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 459 */     buildBlock(world, i + 1, j + 7, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 460 */     buildBlock(world, i + 1, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 461 */     buildBlock(world, i + 1, j + 7, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 462 */     buildBlock(world, i + 1, j + 8, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 463 */     buildBlock(world, i + 1, j + 8, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 464 */     buildBlock(world, i + 1, j + 8, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 465 */     buildBlock(world, i + 1, j + 8, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 466 */     buildBlock(world, i + 1, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 467 */     buildBlock(world, i + 1, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 468 */     buildBlock(world, i + 1, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 469 */     buildBlock(world, i + 1, j + 8, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 470 */     buildBlock(world, i + 1, j + 9, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 471 */     buildBlock(world, i + 1, j + 9, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 472 */     buildBlock(world, i + 1, j + 9, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 473 */     buildBlock(world, i + 1, j + 9, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 474 */     buildBlock(world, i + 1, j + 9, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 475 */     buildBlock(world, i + 1, j + 9, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 476 */     buildBlock(world, i + 1, j + 9, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 477 */     buildBlock(world, i + 1, j + 10, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 478 */     buildBlock(world, i + 1, j + 10, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 479 */     buildBlock(world, i + 1, j + 10, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 480 */     buildBlock(world, i + 1, j + 10, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 481 */     buildBlock(world, i + 1, j + 10, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 482 */     buildBlock(world, i + 1, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 483 */     buildBlock(world, i + 1, j + 10, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 484 */     buildBlock(world, i + 1, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 485 */     buildBlock(world, i + 1, j + 10, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 486 */     buildBlock(world, i + 1, j + 11, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 487 */     buildBlock(world, i + 1, j + 11, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 488 */     buildBlock(world, i + 1, j + 11, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 489 */     buildBlock(world, i + 1, j + 11, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 490 */     buildBlock(world, i + 1, j + 11, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 491 */     buildBlock(world, i + 1, j + 11, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 492 */     buildBlock(world, i + 1, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 493 */     buildBlock(world, i + 1, j + 11, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 494 */     buildBlock(world, i + 2, j + 3, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 495 */     buildBlock(world, i + 2, j + 4, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 496 */     buildBlock(world, i + 2, j + 5, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 497 */     buildBlock(world, i + 2, j + 5, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 498 */     buildBlock(world, i + 2, j + 6, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 499 */     buildBlock(world, i + 2, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 500 */     buildBlock(world, i + 2, j + 7, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 501 */     buildBlock(world, i + 2, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 502 */     buildBlock(world, i + 2, j + 7, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 503 */     buildBlock(world, i + 2, j + 7, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 504 */     buildBlock(world, i + 2, j + 8, k - 6, ModdedBlocks.MapleLeafs, 0);
/* 505 */     buildBlock(world, i + 2, j + 8, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 506 */     buildBlock(world, i + 2, j + 8, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 507 */     buildBlock(world, i + 2, j + 8, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 508 */     buildBlock(world, i + 2, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 509 */     buildBlock(world, i + 2, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 510 */     buildBlock(world, i + 2, j + 8, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 511 */     buildBlock(world, i + 2, j + 8, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 512 */     buildBlock(world, i + 2, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 513 */     buildBlock(world, i + 2, j + 8, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 514 */     buildBlock(world, i + 2, j + 9, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 515 */     buildBlock(world, i + 2, j + 9, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 516 */     buildBlock(world, i + 2, j + 9, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 517 */     buildBlock(world, i + 2, j + 9, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 518 */     buildBlock(world, i + 2, j + 9, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 519 */     buildBlock(world, i + 2, j + 9, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 520 */     buildBlock(world, i + 2, j + 9, k + 1, ModdedBlocks.SakuraLogs, 2);
/* 521 */     buildBlock(world, i + 2, j + 9, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 522 */     buildBlock(world, i + 2, j + 9, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 523 */     buildBlock(world, i + 2, j + 10, k - 5, ModdedBlocks.MapleLeafs, 0);
/* 524 */     buildBlock(world, i + 2, j + 10, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 525 */     buildBlock(world, i + 2, j + 10, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 526 */     buildBlock(world, i + 2, j + 10, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 527 */     buildBlock(world, i + 2, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 528 */     buildBlock(world, i + 2, j + 10, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 529 */     buildBlock(world, i + 2, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 530 */     buildBlock(world, i + 2, j + 10, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 531 */     buildBlock(world, i + 2, j + 10, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 532 */     buildBlock(world, i + 2, j + 11, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 533 */     buildBlock(world, i + 2, j + 11, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 534 */     buildBlock(world, i + 2, j + 11, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 535 */     buildBlock(world, i + 2, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 536 */     buildBlock(world, i + 2, j + 11, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 537 */     buildBlock(world, i + 2, j + 11, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 538 */     buildBlock(world, i + 2, j + 12, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 539 */     buildBlock(world, i + 2, j + 12, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 540 */     buildBlock(world, i + 3, j + 6, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 541 */     buildBlock(world, i + 3, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 542 */     buildBlock(world, i + 3, j + 7, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 543 */     buildBlock(world, i + 3, j + 7, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 544 */     buildBlock(world, i + 3, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 545 */     buildBlock(world, i + 3, j + 8, k - 4, ModdedBlocks.MapleLeafs, 0);
/* 546 */     buildBlock(world, i + 3, j + 8, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 547 */     buildBlock(world, i + 3, j + 8, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 548 */     buildBlock(world, i + 3, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 549 */     buildBlock(world, i + 3, j + 8, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 550 */     buildBlock(world, i + 3, j + 8, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 551 */     buildBlock(world, i + 3, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 552 */     buildBlock(world, i + 3, j + 8, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 553 */     buildBlock(world, i + 3, j + 9, k - 3, ModdedBlocks.MapleLeafs, 0);
/* 554 */     buildBlock(world, i + 3, j + 9, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 555 */     buildBlock(world, i + 3, j + 9, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 556 */     buildBlock(world, i + 3, j + 9, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 557 */     buildBlock(world, i + 3, j + 9, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 558 */     buildBlock(world, i + 3, j + 9, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 559 */     buildBlock(world, i + 3, j + 9, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 560 */     buildBlock(world, i + 3, j + 10, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 561 */     buildBlock(world, i + 3, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 562 */     buildBlock(world, i + 3, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 563 */     buildBlock(world, i + 3, j + 10, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 564 */     buildBlock(world, i + 3, j + 10, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 565 */     buildBlock(world, i + 3, j + 11, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 566 */     buildBlock(world, i + 3, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 567 */     buildBlock(world, i + 3, j + 11, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 568 */     buildBlock(world, i + 3, j + 11, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 569 */     buildBlock(world, i + 3, j + 12, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 570 */     buildBlock(world, i + 3, j + 12, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 571 */     buildBlock(world, i + 4, j + 6, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 572 */     buildBlock(world, i + 4, j + 7, k - 2, ModdedBlocks.MapleLeafs, 0);
/* 573 */     buildBlock(world, i + 4, j + 7, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 574 */     buildBlock(world, i + 4, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 575 */     buildBlock(world, i + 4, j + 7, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 576 */     buildBlock(world, i + 4, j + 8, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 577 */     buildBlock(world, i + 4, j + 8, k + 0, ModdedBlocks.SakuraLogs, 2);
/* 578 */     buildBlock(world, i + 4, j + 8, k + 1, ModdedBlocks.SakuraLogs, 2);
/* 579 */     buildBlock(world, i + 4, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 580 */     buildBlock(world, i + 4, j + 8, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 581 */     buildBlock(world, i + 4, j + 9, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 582 */     buildBlock(world, i + 4, j + 9, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 583 */     buildBlock(world, i + 4, j + 9, k + 1, ModdedBlocks.SakuraLogs, 2);
/* 584 */     buildBlock(world, i + 4, j + 9, k + 2, ModdedBlocks.SakuraLogs, 2);
/* 585 */     buildBlock(world, i + 4, j + 9, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 586 */     buildBlock(world, i + 4, j + 10, k - 1, ModdedBlocks.MapleLeafs, 0);
/* 587 */     buildBlock(world, i + 4, j + 10, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 588 */     buildBlock(world, i + 4, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 589 */     buildBlock(world, i + 4, j + 10, k + 2, ModdedBlocks.SakuraLogs, 2);
/* 590 */     buildBlock(world, i + 4, j + 10, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 591 */     buildBlock(world, i + 4, j + 11, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 592 */     buildBlock(world, i + 4, j + 11, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 593 */     buildBlock(world, i + 4, j + 11, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 594 */     buildBlock(world, i + 4, j + 11, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 595 */     buildBlock(world, i + 4, j + 12, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 596 */     buildBlock(world, i + 4, j + 12, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 597 */     buildBlock(world, i + 4, j + 12, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 598 */     buildBlock(world, i + 4, j + 13, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 599 */     buildBlock(world, i + 4, j + 13, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 600 */     buildBlock(world, i + 5, j + 6, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 601 */     buildBlock(world, i + 5, j + 7, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 602 */     buildBlock(world, i + 5, j + 7, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 603 */     buildBlock(world, i + 5, j + 7, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 604 */     buildBlock(world, i + 5, j + 7, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 605 */     buildBlock(world, i + 5, j + 8, k + 0, ModdedBlocks.MapleLeafs, 0);
/* 606 */     buildBlock(world, i + 5, j + 8, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 607 */     buildBlock(world, i + 5, j + 8, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 608 */     buildBlock(world, i + 5, j + 9, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 609 */     buildBlock(world, i + 5, j + 9, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 610 */     buildBlock(world, i + 5, j + 9, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 611 */     buildBlock(world, i + 5, j + 10, k + 1, ModdedBlocks.MapleLeafs, 0);
/* 612 */     buildBlock(world, i + 5, j + 10, k + 2, ModdedBlocks.SakuraLogs, 2);
/* 613 */     buildBlock(world, i + 5, j + 10, k + 3, ModdedBlocks.SakuraLogs, 2);
/* 614 */     buildBlock(world, i + 5, j + 10, k + 4, ModdedBlocks.MapleLeafs, 0);
/* 615 */     buildBlock(world, i + 5, j + 11, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 616 */     buildBlock(world, i + 5, j + 11, k + 3, ModdedBlocks.SakuraLogs, 2);
/* 617 */     buildBlock(world, i + 5, j + 11, k + 4, ModdedBlocks.MapleLeafs, 0);
/* 618 */     buildBlock(world, i + 5, j + 12, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 619 */     buildBlock(world, i + 5, j + 12, k + 3, ModdedBlocks.SakuraLogs, 2);
/* 620 */     buildBlock(world, i + 5, j + 12, k + 4, ModdedBlocks.MapleLeafs, 0);
/* 621 */     buildBlock(world, i + 5, j + 13, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 622 */     buildBlock(world, i + 6, j + 10, k + 2, ModdedBlocks.MapleLeafs, 0);
/* 623 */     buildBlock(world, i + 6, j + 10, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 624 */     buildBlock(world, i + 6, j + 11, k + 3, ModdedBlocks.MapleLeafs, 0);
/* 625 */     buildBlock(world, i + 6, j + 11, k + 4, ModdedBlocks.MapleLeafs, 0);
/* 626 */     buildBlock(world, i + 6, j + 12, k + 3, ModdedBlocks.MapleLeafs, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
/* 631 */     if (world.func_147437_c(x, y, z) || world.func_147439_a(x, y, z).isLeaves((IBlockAccess)world, x, y, z))
/*     */     {
/* 633 */       world.func_147465_d(x, y, z, block, meta, 2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\m\WorldGenMapleTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */