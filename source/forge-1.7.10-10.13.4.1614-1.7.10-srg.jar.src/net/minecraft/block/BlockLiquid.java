/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class BlockLiquid extends Block {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149806_a;
/*     */   private static final String __OBFID = "CL_00000265";
/*     */   
/*     */   protected BlockLiquid(Material p_i45413_1_) {
/*  23 */     super(p_i45413_1_);
/*  24 */     float f1 = 0.0F;
/*  25 */     float f2 = 0.0F;
/*     */     
/*  27 */     func_149676_a(0.0F + f2, 0.0F + f1, 0.0F + f2, 1.0F + f2, 1.0F + f1, 1.0F + f2);
/*  28 */     func_149675_a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  33 */     return (this.field_149764_J != Material.field_151587_i);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149635_D() {
/*  38 */     return 16777215;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/*  43 */     if (this.field_149764_J == Material.field_151586_h) {
/*  44 */       int i = 0;
/*  45 */       int j = 0;
/*  46 */       int k = 0;
/*     */       
/*  48 */       for (byte b = -1; b <= 1; b++) {
/*  49 */         for (byte b1 = -1; b1 <= 1; b1++) {
/*  50 */           int m = (p_149720_1_.func_72807_a(p_149720_2_ + b1, p_149720_4_ + b)).field_76759_H;
/*     */           
/*  52 */           i += (m & 0xFF0000) >> 16;
/*  53 */           j += (m & 0xFF00) >> 8;
/*  54 */           k += m & 0xFF;
/*     */         } 
/*     */       } 
/*     */       
/*  58 */       return (i / 9 & 0xFF) << 16 | (j / 9 & 0xFF) << 8 | k / 9 & 0xFF;
/*     */     } 
/*  60 */     return 16777215;
/*     */   }
/*     */   
/*     */   public static float func_149801_b(int p_149801_0_) {
/*  64 */     if (p_149801_0_ >= 8) p_149801_0_ = 0; 
/*  65 */     return (p_149801_0_ + 1) / 9.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  70 */     if (p_149691_1_ == 0 || p_149691_1_ == 1) {
/*  71 */       return this.field_149806_a[0];
/*     */     }
/*  73 */     return this.field_149806_a[1];
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_149804_e(World p_149804_1_, int p_149804_2_, int p_149804_3_, int p_149804_4_) {
/*  78 */     if (p_149804_1_.func_147439_a(p_149804_2_, p_149804_3_, p_149804_4_).func_149688_o() == this.field_149764_J) return p_149804_1_.func_72805_g(p_149804_2_, p_149804_3_, p_149804_4_); 
/*  79 */     return -1;
/*     */   }
/*     */   
/*     */   protected int func_149798_e(IBlockAccess p_149798_1_, int p_149798_2_, int p_149798_3_, int p_149798_4_) {
/*  83 */     if (p_149798_1_.func_147439_a(p_149798_2_, p_149798_3_, p_149798_4_).func_149688_o() != this.field_149764_J) return -1; 
/*  84 */     int i = p_149798_1_.func_72805_g(p_149798_2_, p_149798_3_, p_149798_4_);
/*  85 */     if (i >= 8) i = 0; 
/*  86 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149678_a(int p_149678_1_, boolean p_149678_2_) {
/* 101 */     return (p_149678_2_ && p_149678_1_ == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149747_d(IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_) {
/* 106 */     Material material = p_149747_1_.func_147439_a(p_149747_2_, p_149747_3_, p_149747_4_).func_149688_o();
/* 107 */     if (material == this.field_149764_J) return false; 
/* 108 */     if (p_149747_5_ == 1) return true; 
/* 109 */     if (material == Material.field_151588_w) return false; 
/* 110 */     return super.func_149747_d(p_149747_1_, p_149747_2_, p_149747_3_, p_149747_4_, p_149747_5_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 115 */     Material material = p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_).func_149688_o();
/* 116 */     if (material == this.field_149764_J) return false; 
/* 117 */     if (p_149646_5_ == 1) {
/* 118 */       return true;
/*     */     }
/* 120 */     return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 130 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 140 */     return 0;
/*     */   }
/*     */   
/*     */   private Vec3 func_149800_f(IBlockAccess p_149800_1_, int p_149800_2_, int p_149800_3_, int p_149800_4_) {
/* 144 */     Vec3 vec3 = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/* 145 */     int i = func_149798_e(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_); byte b;
/* 146 */     for (b = 0; b < 4; b++) {
/*     */       
/* 148 */       int j = p_149800_2_;
/* 149 */       int k = p_149800_3_;
/* 150 */       int m = p_149800_4_;
/*     */       
/* 152 */       if (b == 0) j--; 
/* 153 */       if (b == 1) m--; 
/* 154 */       if (b == 2) j++; 
/* 155 */       if (b == 3) m++;
/*     */       
/* 157 */       int n = func_149798_e(p_149800_1_, j, k, m);
/* 158 */       if (n < 0) {
/* 159 */         if (!p_149800_1_.func_147439_a(j, k, m).func_149688_o().func_76230_c()) {
/* 160 */           n = func_149798_e(p_149800_1_, j, k - 1, m);
/* 161 */           if (n >= 0) {
/* 162 */             int i1 = n - i - 8;
/* 163 */             vec3 = vec3.func_72441_c(((j - p_149800_2_) * i1), ((k - p_149800_3_) * i1), ((m - p_149800_4_) * i1));
/*     */           }
/*     */         
/*     */         } 
/* 167 */       } else if (n >= 0) {
/* 168 */         int i1 = n - i;
/* 169 */         vec3 = vec3.func_72441_c(((j - p_149800_2_) * i1), ((k - p_149800_3_) * i1), ((m - p_149800_4_) * i1));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 174 */     if (p_149800_1_.func_72805_g(p_149800_2_, p_149800_3_, p_149800_4_) >= 8) {
/* 175 */       b = 0;
/* 176 */       if (b != 0 || func_149747_d(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_ - 1, 2)) b = 1; 
/* 177 */       if (b != 0 || func_149747_d(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_ + 1, 3)) b = 1; 
/* 178 */       if (b != 0 || func_149747_d(p_149800_1_, p_149800_2_ - 1, p_149800_3_, p_149800_4_, 4)) b = 1; 
/* 179 */       if (b != 0 || func_149747_d(p_149800_1_, p_149800_2_ + 1, p_149800_3_, p_149800_4_, 5)) b = 1; 
/* 180 */       if (b != 0 || func_149747_d(p_149800_1_, p_149800_2_, p_149800_3_ + 1, p_149800_4_ - 1, 2)) b = 1; 
/* 181 */       if (b != 0 || func_149747_d(p_149800_1_, p_149800_2_, p_149800_3_ + 1, p_149800_4_ + 1, 3)) b = 1; 
/* 182 */       if (b != 0 || func_149747_d(p_149800_1_, p_149800_2_ - 1, p_149800_3_ + 1, p_149800_4_, 4)) b = 1; 
/* 183 */       if (b != 0 || func_149747_d(p_149800_1_, p_149800_2_ + 1, p_149800_3_ + 1, p_149800_4_, 5)) b = 1; 
/* 184 */       if (b != 0) vec3 = vec3.func_72432_b().func_72441_c(0.0D, -6.0D, 0.0D); 
/*     */     } 
/* 186 */     vec3 = vec3.func_72432_b();
/* 187 */     return vec3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149640_a(World p_149640_1_, int p_149640_2_, int p_149640_3_, int p_149640_4_, Entity p_149640_5_, Vec3 p_149640_6_) {
/* 192 */     Vec3 vec3 = func_149800_f((IBlockAccess)p_149640_1_, p_149640_2_, p_149640_3_, p_149640_4_);
/* 193 */     p_149640_6_.field_72450_a += vec3.field_72450_a;
/* 194 */     p_149640_6_.field_72448_b += vec3.field_72448_b;
/* 195 */     p_149640_6_.field_72449_c += vec3.field_72449_c;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/* 200 */     if (this.field_149764_J == Material.field_151586_h) return 5; 
/* 201 */     if (this.field_149764_J == Material.field_151587_i) {
/* 202 */       if (p_149738_1_.field_73011_w.field_76576_e) {
/* 203 */         return 10;
/*     */       }
/* 205 */       return 30;
/*     */     } 
/*     */     
/* 208 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149677_c(IBlockAccess p_149677_1_, int p_149677_2_, int p_149677_3_, int p_149677_4_) {
/* 213 */     int i = p_149677_1_.func_72802_i(p_149677_2_, p_149677_3_, p_149677_4_, 0);
/* 214 */     int j = p_149677_1_.func_72802_i(p_149677_2_, p_149677_3_ + 1, p_149677_4_, 0);
/*     */     
/* 216 */     int k = i & 0xFF;
/* 217 */     int m = j & 0xFF;
/* 218 */     int n = i >> 16 & 0xFF;
/* 219 */     int i1 = j >> 16 & 0xFF;
/*     */     
/* 221 */     return ((k > m) ? k : m) | ((n > i1) ? n : i1) << 16;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/* 226 */     return (this.field_149764_J == Material.field_151586_h) ? 1 : 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 231 */     if (this.field_149764_J == Material.field_151586_h) {
/* 232 */       if (p_149734_5_.nextInt(10) == 0) {
/* 233 */         int i = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
/* 234 */         if (i <= 0 || i >= 8) {
/* 235 */           p_149734_1_.func_72869_a("suspended", (p_149734_2_ + p_149734_5_.nextFloat()), (p_149734_3_ + p_149734_5_.nextFloat()), (p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
/*     */         }
/*     */       } 
/* 238 */       for (byte b = 0; b; b++) {
/*     */ 
/*     */         
/* 241 */         int i = p_149734_5_.nextInt(4);
/* 242 */         int j = p_149734_2_;
/* 243 */         int k = p_149734_4_;
/* 244 */         if (i == 0) j--; 
/* 245 */         if (i == 1) j++; 
/* 246 */         if (i == 2) k--; 
/* 247 */         if (i == 3) k++; 
/* 248 */         if (p_149734_1_.func_147439_a(j, p_149734_3_, k).func_149688_o() == Material.field_151579_a && (p_149734_1_.func_147439_a(j, p_149734_3_ - 1, k).func_149688_o().func_76230_c() || p_149734_1_.func_147439_a(j, p_149734_3_ - 1, k).func_149688_o().func_76224_d())) {
/* 249 */           float f = 0.0625F;
/* 250 */           double d1 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 251 */           double d2 = (p_149734_3_ + p_149734_5_.nextFloat());
/* 252 */           double d3 = (p_149734_4_ + p_149734_5_.nextFloat());
/* 253 */           if (i == 0) d1 = (p_149734_2_ - f); 
/* 254 */           if (i == 1) d1 = ((p_149734_2_ + 1) + f); 
/* 255 */           if (i == 2) d3 = (p_149734_4_ - f); 
/* 256 */           if (i == 3) d3 = ((p_149734_4_ + 1) + f);
/*     */           
/* 258 */           double d4 = 0.0D;
/* 259 */           double d5 = 0.0D;
/*     */           
/* 261 */           if (i == 0) d4 = -f; 
/* 262 */           if (i == 1) d4 = f; 
/* 263 */           if (i == 2) d5 = -f; 
/* 264 */           if (i == 3) d5 = f;
/*     */           
/* 266 */           p_149734_1_.func_72869_a("splash", d1, d2, d3, d4, 0.0D, d5);
/*     */         } 
/*     */       } 
/*     */     } 
/* 270 */     if (this.field_149764_J == Material.field_151586_h && p_149734_5_.nextInt(64) == 0) {
/* 271 */       int i = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
/* 272 */       if (i > 0 && i < 8) {
/* 273 */         p_149734_1_.func_72980_b((p_149734_2_ + 0.5F), (p_149734_3_ + 0.5F), (p_149734_4_ + 0.5F), "liquid.water", p_149734_5_.nextFloat() * 0.25F + 0.75F, p_149734_5_.nextFloat() * 1.0F + 0.5F, false);
/*     */       }
/*     */     } 
/* 276 */     if (this.field_149764_J == Material.field_151587_i && 
/* 277 */       p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ + 1, p_149734_4_).func_149688_o() == Material.field_151579_a && !p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ + 1, p_149734_4_).func_149662_c()) {
/* 278 */       if (p_149734_5_.nextInt(100) == 0) {
/* 279 */         double d1 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 280 */         double d2 = p_149734_3_ + this.field_149756_F;
/* 281 */         double d3 = (p_149734_4_ + p_149734_5_.nextFloat());
/* 282 */         p_149734_1_.func_72869_a("lava", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/* 283 */         p_149734_1_.func_72980_b(d1, d2, d3, "liquid.lavapop", 0.2F + p_149734_5_.nextFloat() * 0.2F, 0.9F + p_149734_5_.nextFloat() * 0.15F, false);
/*     */       } 
/* 285 */       if (p_149734_5_.nextInt(200) == 0) {
/* 286 */         p_149734_1_.func_72980_b(p_149734_2_, p_149734_3_, p_149734_4_, "liquid.lava", 0.2F + p_149734_5_.nextFloat() * 0.2F, 0.9F + p_149734_5_.nextFloat() * 0.15F, false);
/*     */       }
/*     */     } 
/*     */     
/* 290 */     if (p_149734_5_.nextInt(10) == 0 && 
/* 291 */       World.func_147466_a((IBlockAccess)p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && !p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ - 2, p_149734_4_).func_149688_o().func_76230_c()) {
/* 292 */       double d1 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 293 */       double d2 = p_149734_3_ - 1.05D;
/* 294 */       double d3 = (p_149734_4_ + p_149734_5_.nextFloat());
/*     */       
/* 296 */       if (this.field_149764_J == Material.field_151586_h) { p_149734_1_.func_72869_a("dripWater", d1, d2, d3, 0.0D, 0.0D, 0.0D); }
/* 297 */       else { p_149734_1_.func_72869_a("dripLava", d1, d2, d3, 0.0D, 0.0D, 0.0D); }
/*     */     
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static double func_149802_a(IBlockAccess p_149802_0_, int p_149802_1_, int p_149802_2_, int p_149802_3_, Material p_149802_4_) {
/* 303 */     Vec3 vec3 = null;
/* 304 */     if (p_149802_4_ == Material.field_151586_h) vec3 = Blocks.field_150358_i.func_149800_f(p_149802_0_, p_149802_1_, p_149802_2_, p_149802_3_); 
/* 305 */     if (p_149802_4_ == Material.field_151587_i) vec3 = Blocks.field_150356_k.func_149800_f(p_149802_0_, p_149802_1_, p_149802_2_, p_149802_3_); 
/* 306 */     if (vec3.field_72450_a == 0.0D && vec3.field_72449_c == 0.0D) return -1000.0D; 
/* 307 */     return Math.atan2(vec3.field_72449_c, vec3.field_72450_a) - 1.5707963267948966D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 312 */     func_149805_n(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 317 */     func_149805_n(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/*     */   }
/*     */   
/*     */   private void func_149805_n(World p_149805_1_, int p_149805_2_, int p_149805_3_, int p_149805_4_) {
/* 321 */     if (p_149805_1_.func_147439_a(p_149805_2_, p_149805_3_, p_149805_4_) != this)
/* 322 */       return;  if (this.field_149764_J == Material.field_151587_i) {
/* 323 */       boolean bool = false;
/* 324 */       if (bool || p_149805_1_.func_147439_a(p_149805_2_, p_149805_3_, p_149805_4_ - 1).func_149688_o() == Material.field_151586_h) bool = true; 
/* 325 */       if (bool || p_149805_1_.func_147439_a(p_149805_2_, p_149805_3_, p_149805_4_ + 1).func_149688_o() == Material.field_151586_h) bool = true; 
/* 326 */       if (bool || p_149805_1_.func_147439_a(p_149805_2_ - 1, p_149805_3_, p_149805_4_).func_149688_o() == Material.field_151586_h) bool = true; 
/* 327 */       if (bool || p_149805_1_.func_147439_a(p_149805_2_ + 1, p_149805_3_, p_149805_4_).func_149688_o() == Material.field_151586_h) bool = true; 
/* 328 */       if (bool || p_149805_1_.func_147439_a(p_149805_2_, p_149805_3_ + 1, p_149805_4_).func_149688_o() == Material.field_151586_h) bool = true; 
/* 329 */       if (bool) {
/* 330 */         int i = p_149805_1_.func_72805_g(p_149805_2_, p_149805_3_, p_149805_4_);
/* 331 */         if (i == 0) {
/* 332 */           p_149805_1_.func_147449_b(p_149805_2_, p_149805_3_, p_149805_4_, Blocks.field_150343_Z);
/* 333 */         } else if (i <= 4) {
/* 334 */           p_149805_1_.func_147449_b(p_149805_2_, p_149805_3_, p_149805_4_, Blocks.field_150347_e);
/*     */         } 
/* 336 */         func_149799_m(p_149805_1_, p_149805_2_, p_149805_3_, p_149805_4_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_149799_m(World p_149799_1_, int p_149799_2_, int p_149799_3_, int p_149799_4_) {
/* 342 */     p_149799_1_.func_72908_a((p_149799_2_ + 0.5F), (p_149799_3_ + 0.5F), (p_149799_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_149799_1_.field_73012_v.nextFloat() - p_149799_1_.field_73012_v.nextFloat()) * 0.8F);
/* 343 */     for (byte b = 0; b < 8; b++) {
/* 344 */       p_149799_1_.func_72869_a("largesmoke", p_149799_2_ + Math.random(), p_149799_3_ + 1.2D, p_149799_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 350 */     if (this.field_149764_J == Material.field_151587_i) {
/* 351 */       this.field_149806_a = new IIcon[] { p_149651_1_.func_94245_a("lava_still"), p_149651_1_.func_94245_a("lava_flow") };
/*     */     }
/*     */     else {
/*     */       
/* 355 */       this.field_149806_a = new IIcon[] { p_149651_1_.func_94245_a("water_still"), p_149651_1_.func_94245_a("water_flow") };
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static IIcon func_149803_e(String p_149803_0_) {
/* 362 */     if (p_149803_0_ == "water_still") return Blocks.field_150358_i.field_149806_a[0]; 
/* 363 */     if (p_149803_0_ == "water_flow") return Blocks.field_150358_i.field_149806_a[1]; 
/* 364 */     if (p_149803_0_ == "lava_still") return Blocks.field_150356_k.field_149806_a[0]; 
/* 365 */     if (p_149803_0_ == "lava_flow") return Blocks.field_150356_k.field_149806_a[1]; 
/* 366 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockLiquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */