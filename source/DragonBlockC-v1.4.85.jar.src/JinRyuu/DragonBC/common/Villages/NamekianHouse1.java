/*     */ package JinRyuu.DragonBC.common.Villages;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityNamekian03;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NamekianHouse1
/*     */   extends WorldGenerator
/*     */ {
/*     */   public boolean func_76484_a(World world, Random rand, int i, int j, int k) {
/*  19 */     Block bID = BlocksDBC.BlockNamekGrass;
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
/*  89 */     if (world.func_147439_a(i, j, k) == bID && world
/*  90 */       .func_147439_a(i, j + 1, k).func_149688_o() == Material.field_151579_a && world
/*  91 */       .func_147439_a(i + 7, j, k) == bID && world
/*  92 */       .func_147439_a(i + 7, j, k + 7) == bID && world
/*  93 */       .func_147439_a(i, j, k + 7) == bID && world
/*  94 */       .func_147439_a(i + 7, j + 1, k).func_149688_o() == Material.field_151579_a && world
/*  95 */       .func_147439_a(i + 7, j + 1, k + 7).func_149688_o() == Material.field_151579_a && world
/*  96 */       .func_147439_a(i, j + 1, k + 7).func_149688_o() == Material.field_151579_a) {
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
/* 110 */       setBlock(world, i + 0, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 111 */       setBlock(world, i + 0, j + 0, k + 7, BlocksDBC.BlockNamekGrass);
/* 112 */       setBlock(world, i + 0, j + 0, k + 6, BlocksDBC.BlockNamekGrass);
/* 113 */       setBlock(world, i + 0, j + 0, k + 5, BlocksDBC.BlockNamekGrass);
/* 114 */       setBlock(world, i + 0, j + 0, k + 4, BlocksDBC.BlockNamekGrass);
/* 115 */       setBlock(world, i + 0, j + 0, k + 3, BlocksDBC.BlockNamekGrass);
/* 116 */       setBlock(world, i + 0, j + 0, k + 2, BlocksDBC.BlockNamekGrass);
/* 117 */       setBlock(world, i + 0, j + 0, k + 1, BlocksDBC.BlockNamekGrass);
/* 118 */       setBlock(world, i + 0, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 119 */       setBlock(world, i + 1, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 120 */       setBlock(world, i + 1, j + 0, k + 7, BlocksDBC.BlockNamekStone);
/* 121 */       setBlock(world, i + 1, j + 0, k + 6, BlocksDBC.BlockNamekStone);
/* 122 */       setBlock(world, i + 1, j + 0, k + 5, BlocksDBC.BlockNamekStone);
/* 123 */       setBlock(world, i + 1, j + 0, k + 4, BlocksDBC.BlockNamekStone);
/* 124 */       setBlock(world, i + 1, j + 0, k + 3, BlocksDBC.BlockNamekStone);
/* 125 */       setBlock(world, i + 1, j + 0, k + 2, BlocksDBC.BlockNamekStone);
/* 126 */       setBlock(world, i + 1, j + 0, k + 1, BlocksDBC.BlockNamekStone);
/* 127 */       setBlock(world, i + 1, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 128 */       setBlock(world, i + 2, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 129 */       setBlock(world, i + 2, j + 0, k + 7, BlocksDBC.BlockNamekStone);
/* 130 */       setBlock(world, i + 2, j + 0, k + 6, BlocksDBC.BlockNamekStone);
/* 131 */       setBlock(world, i + 2, j + 0, k + 5, BlocksDBC.BlockNamekStone);
/* 132 */       setBlock(world, i + 2, j + 0, k + 4, BlocksDBC.BlockNamekStone);
/* 133 */       setBlock(world, i + 2, j + 0, k + 3, BlocksDBC.BlockNamekStone);
/* 134 */       setBlock(world, i + 2, j + 0, k + 2, BlocksDBC.BlockNamekStone);
/* 135 */       setBlock(world, i + 2, j + 0, k + 1, BlocksDBC.BlockNamekStone);
/* 136 */       setBlock(world, i + 2, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 137 */       setBlock(world, i + 3, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 138 */       setBlock(world, i + 3, j + 0, k + 7, BlocksDBC.BlockNamekStone);
/* 139 */       setBlock(world, i + 3, j + 0, k + 6, BlocksDBC.BlockNamekStone);
/* 140 */       setBlock(world, i + 3, j + 0, k + 5, BlocksDBC.BlockNamekStone);
/* 141 */       setBlock(world, i + 3, j + 0, k + 4, BlocksDBC.BlockNamekStone);
/*     */       
/* 143 */       setBlock(world, i + 3, j + 0, k + 3, BlocksDBC.BlockNamekStone);
/* 144 */       setBlock(world, i + 3, j + 0, k + 2, BlocksDBC.BlockNamekStone);
/* 145 */       setBlock(world, i + 3, j + 0, k + 1, BlocksDBC.BlockNamekStone);
/* 146 */       setBlock(world, i + 3, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 147 */       setBlock(world, i + 4, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 148 */       setBlock(world, i + 4, j + 0, k + 7, BlocksDBC.BlockNamekStone);
/* 149 */       setBlock(world, i + 4, j + 0, k + 6, BlocksDBC.BlockNamekStone);
/* 150 */       setBlock(world, i + 4, j + 0, k + 5, BlocksDBC.BlockNamekStone);
/* 151 */       setBlock(world, i + 4, j + 0, k + 4, BlocksDBC.BlockNamekStone);
/* 152 */       setBlock(world, i + 4, j + 0, k + 3, BlocksDBC.BlockNamekStone);
/* 153 */       setBlock(world, i + 4, j + 0, k + 2, BlocksDBC.BlockNamekStone);
/* 154 */       setBlock(world, i + 4, j + 0, k + 1, BlocksDBC.BlockNamekStone);
/* 155 */       setBlock(world, i + 4, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 156 */       setBlock(world, i + 5, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 157 */       setBlock(world, i + 5, j + 0, k + 7, BlocksDBC.BlockNamekStone);
/* 158 */       setBlock(world, i + 5, j + 0, k + 6, BlocksDBC.BlockNamekStone);
/* 159 */       setBlock(world, i + 5, j + 0, k + 5, BlocksDBC.BlockNamekStone);
/* 160 */       setBlock(world, i + 5, j + 0, k + 4, BlocksDBC.BlockNamekStone);
/* 161 */       setBlock(world, i + 5, j + 0, k + 3, BlocksDBC.BlockNamekStone);
/* 162 */       setBlock(world, i + 5, j + 0, k + 2, BlocksDBC.BlockNamekStone);
/* 163 */       setBlock(world, i + 5, j + 0, k + 1, BlocksDBC.BlockNamekStone);
/* 164 */       setBlock(world, i + 5, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 165 */       setBlock(world, i + 6, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 166 */       setBlock(world, i + 6, j + 0, k + 7, BlocksDBC.BlockNamekStone);
/* 167 */       setBlock(world, i + 6, j + 0, k + 6, BlocksDBC.BlockNamekStone);
/* 168 */       setBlock(world, i + 6, j + 0, k + 5, BlocksDBC.BlockNamekStone);
/* 169 */       setBlock(world, i + 6, j + 0, k + 4, BlocksDBC.BlockNamekStone);
/* 170 */       setBlock(world, i + 6, j + 0, k + 3, BlocksDBC.BlockNamekStone);
/* 171 */       setBlock(world, i + 6, j + 0, k + 2, BlocksDBC.BlockNamekStone);
/* 172 */       setBlock(world, i + 6, j + 0, k + 1, BlocksDBC.BlockNamekStone);
/* 173 */       setBlock(world, i + 6, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 174 */       setBlock(world, i + 7, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 175 */       setBlock(world, i + 7, j + 0, k + 7, BlocksDBC.BlockNamekStone);
/* 176 */       setBlock(world, i + 7, j + 0, k + 6, BlocksDBC.BlockNamekStone);
/* 177 */       setBlock(world, i + 7, j + 0, k + 5, BlocksDBC.BlockNamekStone);
/* 178 */       setBlock(world, i + 7, j + 0, k + 4, BlocksDBC.BlockNamekStone);
/* 179 */       setBlock(world, i + 7, j + 0, k + 3, BlocksDBC.BlockNamekStone);
/* 180 */       setBlock(world, i + 7, j + 0, k + 2, BlocksDBC.BlockNamekStone);
/* 181 */       setBlock(world, i + 7, j + 0, k + 1, BlocksDBC.BlockNamekStone);
/* 182 */       setBlock(world, i + 7, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 183 */       setBlock(world, i + 8, j + 0, k + 8, BlocksDBC.BlockNamekGrass);
/* 184 */       setBlock(world, i + 8, j + 0, k + 7, BlocksDBC.BlockNamekGrass);
/* 185 */       setBlock(world, i + 8, j + 0, k + 6, BlocksDBC.BlockNamekGrass);
/* 186 */       setBlock(world, i + 8, j + 0, k + 5, BlocksDBC.BlockNamekGrass);
/* 187 */       setBlock(world, i + 8, j + 0, k + 4, BlocksDBC.BlockNamekGrass);
/* 188 */       setBlock(world, i + 8, j + 0, k + 3, BlocksDBC.BlockNamekGrass);
/* 189 */       setBlock(world, i + 8, j + 0, k + 2, BlocksDBC.BlockNamekGrass);
/* 190 */       setBlock(world, i + 8, j + 0, k + 1, BlocksDBC.BlockNamekGrass);
/* 191 */       setBlock(world, i + 8, j + 0, k + 0, BlocksDBC.BlockNamekGrass);
/* 192 */       setBlock(world, i + 0, j + 1, k + 6, BlocksDBC.BlockNamekStone);
/* 193 */       setBlock(world, i + 0, j + 1, k + 5, BlocksDBC.BlockNamekStone);
/* 194 */       setBlock(world, i + 0, j + 1, k + 4, BlocksDBC.BlockNamekStone);
/* 195 */       setBlock(world, i + 0, j + 1, k + 3, BlocksDBC.BlockNamekStone);
/* 196 */       setBlock(world, i + 0, j + 1, k + 2, BlocksDBC.BlockNamekStone);
/* 197 */       setBlock(world, i + 1, j + 1, k + 7, BlocksDBC.BlockNamekStone);
/* 198 */       setBlock(world, i + 1, j + 1, k + 1, BlocksDBC.BlockNamekStone);
/* 199 */       setBlock(world, i + 2, j + 1, k + 8, BlocksDBC.BlockNamekStone);
/* 200 */       setBlock(world, i + 2, j + 1, k + 0, BlocksDBC.BlockNamekStone);
/* 201 */       setBlock(world, i + 3, j + 1, k + 8, BlocksDBC.BlockNamekStone);
/* 202 */       setBlock(world, i + 3, j + 1, k + 0, BlocksDBC.BlockNamekStone);
/* 203 */       setBlock(world, i + 4, j + 1, k + 8, BlocksDBC.BlockNamekStone);
/* 204 */       setBlock(world, i + 5, j + 1, k + 8, BlocksDBC.BlockNamekStone);
/* 205 */       setBlock(world, i + 5, j + 1, k + 0, BlocksDBC.BlockNamekStone);
/* 206 */       setBlock(world, i + 6, j + 1, k + 8, BlocksDBC.BlockNamekStone);
/* 207 */       setBlock(world, i + 6, j + 1, k + 0, BlocksDBC.BlockNamekStone);
/* 208 */       setBlock(world, i + 7, j + 1, k + 7, BlocksDBC.BlockNamekStone);
/* 209 */       setBlock(world, i + 7, j + 1, k + 1, BlocksDBC.BlockNamekStone);
/* 210 */       setBlock(world, i + 8, j + 1, k + 6, BlocksDBC.BlockNamekStone);
/* 211 */       setBlock(world, i + 8, j + 1, k + 5, BlocksDBC.BlockNamekStone);
/* 212 */       setBlock(world, i + 8, j + 1, k + 4, BlocksDBC.BlockNamekStone);
/* 213 */       setBlock(world, i + 8, j + 1, k + 3, BlocksDBC.BlockNamekStone);
/* 214 */       setBlock(world, i + 8, j + 1, k + 2, BlocksDBC.BlockNamekStone);
/* 215 */       setBlock(world, i + 0, j + 2, k + 6, BlocksDBC.BlockNamekStone);
/* 216 */       setBlock(world, i + 0, j + 2, k + 5, BlocksDBC.BlockNamekStone);
/*     */       
/* 218 */       setBlock(world, i + 0, j + 2, k + 3, BlocksDBC.BlockNamekStone);
/* 219 */       setBlock(world, i + 0, j + 2, k + 2, BlocksDBC.BlockNamekStone);
/* 220 */       setBlock(world, i + 1, j + 2, k + 7, BlocksDBC.BlockNamekStone);
/* 221 */       setBlock(world, i + 1, j + 2, k + 1, BlocksDBC.BlockNamekStone);
/* 222 */       setBlock(world, i + 2, j + 2, k + 8, BlocksDBC.BlockNamekStone);
/* 223 */       setBlock(world, i + 2, j + 2, k + 0, BlocksDBC.BlockNamekStone);
/* 224 */       setBlock(world, i + 3, j + 2, k + 8, BlocksDBC.BlockNamekStone);
/* 225 */       setBlock(world, i + 3, j + 2, k + 0, BlocksDBC.BlockNamekStone);
/*     */       
/* 227 */       setBlock(world, i + 5, j + 2, k + 8, BlocksDBC.BlockNamekStone);
/* 228 */       setBlock(world, i + 5, j + 2, k + 0, BlocksDBC.BlockNamekStone);
/* 229 */       setBlock(world, i + 6, j + 2, k + 8, BlocksDBC.BlockNamekStone);
/* 230 */       setBlock(world, i + 6, j + 2, k + 0, BlocksDBC.BlockNamekStone);
/* 231 */       setBlock(world, i + 7, j + 2, k + 7, BlocksDBC.BlockNamekStone);
/* 232 */       setBlock(world, i + 7, j + 2, k + 1, BlocksDBC.BlockNamekStone);
/* 233 */       setBlock(world, i + 8, j + 2, k + 6, BlocksDBC.BlockNamekStone);
/* 234 */       setBlock(world, i + 8, j + 2, k + 5, BlocksDBC.BlockNamekStone);
/*     */       
/* 236 */       setBlock(world, i + 8, j + 2, k + 3, BlocksDBC.BlockNamekStone);
/* 237 */       setBlock(world, i + 8, j + 2, k + 2, BlocksDBC.BlockNamekStone);
/* 238 */       setBlock(world, i + 1, j + 3, k + 6, BlocksDBC.BlockNamekStone);
/* 239 */       setBlock(world, i + 1, j + 3, k + 5, BlocksDBC.BlockNamekStone);
/* 240 */       setBlock(world, i + 1, j + 3, k + 4, BlocksDBC.BlockNamekStone);
/* 241 */       setBlock(world, i + 1, j + 3, k + 3, BlocksDBC.BlockNamekStone);
/* 242 */       setBlock(world, i + 1, j + 3, k + 2, BlocksDBC.BlockNamekStone);
/* 243 */       setBlock(world, i + 2, j + 3, k + 7, BlocksDBC.BlockNamekStone);
/* 244 */       setBlock(world, i + 2, j + 3, k + 1, BlocksDBC.BlockNamekStone);
/* 245 */       setBlock(world, i + 3, j + 3, k + 7, BlocksDBC.BlockNamekStone);
/* 246 */       setBlock(world, i + 3, j + 3, k + 1, BlocksDBC.BlockNamekStone);
/* 247 */       setBlock(world, i + 4, j + 3, k + 7, BlocksDBC.BlockNamekStone);
/* 248 */       setBlock(world, i + 4, j + 3, k + 1, BlocksDBC.BlockNamekStone);
/* 249 */       setBlock(world, i + 5, j + 3, k + 7, BlocksDBC.BlockNamekStone);
/* 250 */       setBlock(world, i + 5, j + 3, k + 1, BlocksDBC.BlockNamekStone);
/* 251 */       setBlock(world, i + 6, j + 3, k + 7, BlocksDBC.BlockNamekStone);
/* 252 */       setBlock(world, i + 6, j + 3, k + 1, BlocksDBC.BlockNamekStone);
/* 253 */       setBlock(world, i + 7, j + 3, k + 6, BlocksDBC.BlockNamekStone);
/* 254 */       setBlock(world, i + 7, j + 3, k + 5, BlocksDBC.BlockNamekStone);
/* 255 */       setBlock(world, i + 7, j + 3, k + 4, BlocksDBC.BlockNamekStone);
/* 256 */       setBlock(world, i + 7, j + 3, k + 3, BlocksDBC.BlockNamekStone);
/* 257 */       setBlock(world, i + 7, j + 3, k + 2, BlocksDBC.BlockNamekStone);
/* 258 */       setBlock(world, i + 2, j + 4, k + 6, BlocksDBC.BlockNamekStone);
/* 259 */       setBlock(world, i + 2, j + 4, k + 5, BlocksDBC.BlockNamekStone);
/* 260 */       setBlock(world, i + 2, j + 4, k + 4, BlocksDBC.BlockNamekStone);
/* 261 */       setBlock(world, i + 2, j + 4, k + 3, BlocksDBC.BlockNamekStone);
/* 262 */       setBlock(world, i + 2, j + 4, k + 2, BlocksDBC.BlockNamekStone);
/* 263 */       setBlock(world, i + 3, j + 4, k + 6, BlocksDBC.BlockNamekStone);
/* 264 */       setBlock(world, i + 3, j + 4, k + 2, BlocksDBC.BlockNamekStone);
/* 265 */       setBlock(world, i + 4, j + 4, k + 6, BlocksDBC.BlockNamekStone);
/* 266 */       setBlock(world, i + 4, j + 4, k + 2, BlocksDBC.BlockNamekStone);
/* 267 */       setBlock(world, i + 5, j + 4, k + 6, BlocksDBC.BlockNamekStone);
/* 268 */       setBlock(world, i + 5, j + 4, k + 2, BlocksDBC.BlockNamekStone);
/* 269 */       setBlock(world, i + 6, j + 4, k + 6, BlocksDBC.BlockNamekStone);
/* 270 */       setBlock(world, i + 6, j + 4, k + 5, BlocksDBC.BlockNamekStone);
/* 271 */       setBlock(world, i + 6, j + 4, k + 4, BlocksDBC.BlockNamekStone);
/* 272 */       setBlock(world, i + 6, j + 4, k + 3, BlocksDBC.BlockNamekStone);
/* 273 */       setBlock(world, i + 6, j + 4, k + 2, BlocksDBC.BlockNamekStone);
/* 274 */       setBlock(world, i + 3, j + 5, k + 5, BlocksDBC.BlockNamekStone);
/* 275 */       setBlock(world, i + 3, j + 5, k + 4, BlocksDBC.BlockNamekStone);
/* 276 */       setBlock(world, i + 3, j + 5, k + 3, BlocksDBC.BlockNamekStone);
/* 277 */       setBlock(world, i + 4, j + 5, k + 5, BlocksDBC.BlockNamekStone);
/* 278 */       setBlock(world, i + 4, j + 5, k + 3, BlocksDBC.BlockNamekStone);
/* 279 */       setBlock(world, i + 5, j + 5, k + 5, BlocksDBC.BlockNamekStone);
/* 280 */       setBlock(world, i + 5, j + 5, k + 4, BlocksDBC.BlockNamekStone);
/* 281 */       setBlock(world, i + 5, j + 5, k + 3, BlocksDBC.BlockNamekStone);
/* 282 */       setBlock(world, i + 4, j + 5, k + 4, BlocksDBC.BlockNamekStone);
/*     */       
/* 284 */       EntityNamekian03 namekian03 = new EntityNamekian03(world);
/*     */ 
/*     */ 
/*     */       
/* 288 */       namekian03.initCreature();
/* 289 */       for (int t = 0; t < 3; t++) {
/* 290 */         EntityNamekian01 namekian01 = new EntityNamekian01(world);
/* 291 */         namekian01.func_70012_b(i - 4.0D + rand.nextInt(5) - rand.nextInt(5), (j + 2), k - 4.0D + rand.nextInt(5) - rand.nextInt(5), 0.0F, 0.0F);
/*     */         
/* 293 */         world.func_72838_d((Entity)namekian01);
/*     */       } 
/* 295 */       namekian03.func_70012_b(i + 4.0D, (j + 2), k + 4.0D, 0.0F, 0.0F);
/* 296 */       world.func_72838_d((Entity)namekian03);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 320 */     return true;
/*     */   }
/*     */   
/*     */   private void setBlock(World world, int i, int j, int k, Block b) {
/* 324 */     func_150516_a(world, i, j, k, b, 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Villages\NamekianHouse1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */