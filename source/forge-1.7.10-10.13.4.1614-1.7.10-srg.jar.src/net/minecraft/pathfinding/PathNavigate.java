/*     */ package net.minecraft.pathfinding;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class PathNavigate
/*     */ {
/*     */   private EntityLiving field_75515_a;
/*     */   private World field_75513_b;
/*     */   private PathEntity field_75514_c;
/*     */   private double field_75511_d;
/*     */   private IAttributeInstance field_75512_e;
/*     */   private boolean field_75509_f;
/*     */   private int field_75510_g;
/*     */   private int field_75520_h;
/*  26 */   private Vec3 field_75521_i = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*     */   private boolean field_75518_j = true;
/*     */   private boolean field_75519_k;
/*     */   private boolean field_75516_l;
/*     */   private boolean field_75517_m;
/*     */   private static final String __OBFID = "CL_00001627";
/*     */   
/*     */   public PathNavigate(EntityLiving p_i1671_1_, World p_i1671_2_) {
/*  34 */     this.field_75515_a = p_i1671_1_;
/*  35 */     this.field_75513_b = p_i1671_2_;
/*  36 */     this.field_75512_e = p_i1671_1_.func_110148_a(SharedMonsterAttributes.field_111265_b);
/*     */   }
/*     */   
/*     */   public void func_75491_a(boolean p_75491_1_) {
/*  40 */     this.field_75516_l = p_75491_1_;
/*     */   }
/*     */   
/*     */   public boolean func_75486_a() {
/*  44 */     return this.field_75516_l;
/*     */   }
/*     */   
/*     */   public void func_75498_b(boolean p_75498_1_) {
/*  48 */     this.field_75519_k = p_75498_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75490_c(boolean p_75490_1_) {
/*  56 */     this.field_75518_j = p_75490_1_;
/*     */   }
/*     */   
/*     */   public boolean func_75507_c() {
/*  60 */     return this.field_75519_k;
/*     */   }
/*     */   
/*     */   public void func_75504_d(boolean p_75504_1_) {
/*  64 */     this.field_75509_f = p_75504_1_;
/*     */   }
/*     */   
/*     */   public void func_75489_a(double p_75489_1_) {
/*  68 */     this.field_75511_d = p_75489_1_;
/*     */   }
/*     */   
/*     */   public void func_75495_e(boolean p_75495_1_) {
/*  72 */     this.field_75517_m = p_75495_1_;
/*     */   }
/*     */   
/*     */   public float func_111269_d() {
/*  76 */     return (float)this.field_75512_e.func_111126_e();
/*     */   }
/*     */   
/*     */   public PathEntity func_75488_a(double p_75488_1_, double p_75488_3_, double p_75488_5_) {
/*  80 */     if (!func_75485_k()) return null; 
/*  81 */     return this.field_75513_b.func_72844_a((Entity)this.field_75515_a, MathHelper.func_76128_c(p_75488_1_), (int)p_75488_3_, MathHelper.func_76128_c(p_75488_5_), func_111269_d(), this.field_75518_j, this.field_75519_k, this.field_75516_l, this.field_75517_m);
/*     */   }
/*     */   
/*     */   public boolean func_75492_a(double p_75492_1_, double p_75492_3_, double p_75492_5_, double p_75492_7_) {
/*  85 */     PathEntity pathEntity = func_75488_a(MathHelper.func_76128_c(p_75492_1_), (int)p_75492_3_, MathHelper.func_76128_c(p_75492_5_));
/*  86 */     return func_75484_a(pathEntity, p_75492_7_);
/*     */   }
/*     */   
/*     */   public PathEntity func_75494_a(Entity p_75494_1_) {
/*  90 */     if (!func_75485_k()) return null; 
/*  91 */     return this.field_75513_b.func_72865_a((Entity)this.field_75515_a, p_75494_1_, func_111269_d(), this.field_75518_j, this.field_75519_k, this.field_75516_l, this.field_75517_m);
/*     */   }
/*     */   
/*     */   public boolean func_75497_a(Entity p_75497_1_, double p_75497_2_) {
/*  95 */     PathEntity pathEntity = func_75494_a(p_75497_1_);
/*  96 */     if (pathEntity != null) return func_75484_a(pathEntity, p_75497_2_); 
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75484_a(PathEntity p_75484_1_, double p_75484_2_) {
/* 102 */     if (p_75484_1_ == null) {
/* 103 */       this.field_75514_c = null;
/* 104 */       return false;
/*     */     } 
/* 106 */     if (!p_75484_1_.func_75876_a(this.field_75514_c)) this.field_75514_c = p_75484_1_; 
/* 107 */     if (this.field_75509_f) func_75487_m(); 
/* 108 */     if (this.field_75514_c.func_75874_d() == 0) return false;
/*     */     
/* 110 */     this.field_75511_d = p_75484_2_;
/* 111 */     Vec3 vec3 = func_75502_i();
/* 112 */     this.field_75520_h = this.field_75510_g;
/* 113 */     this.field_75521_i.field_72450_a = vec3.field_72450_a;
/* 114 */     this.field_75521_i.field_72448_b = vec3.field_72448_b;
/* 115 */     this.field_75521_i.field_72449_c = vec3.field_72449_c;
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   public PathEntity func_75505_d() {
/* 120 */     return this.field_75514_c;
/*     */   }
/*     */   
/*     */   public void func_75501_e() {
/* 124 */     this.field_75510_g++;
/* 125 */     if (func_75500_f())
/*     */       return; 
/* 127 */     if (func_75485_k()) func_75508_h();
/*     */     
/* 129 */     if (func_75500_f())
/* 130 */       return;  Vec3 vec3 = this.field_75514_c.func_75878_a((Entity)this.field_75515_a);
/* 131 */     if (vec3 == null)
/*     */       return; 
/* 133 */     this.field_75515_a.func_70605_aq().func_75642_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, this.field_75511_d);
/*     */   }
/*     */   
/*     */   private void func_75508_h() {
/* 137 */     Vec3 vec3 = func_75502_i();
/*     */ 
/*     */     
/* 140 */     int i = this.field_75514_c.func_75874_d();
/* 141 */     for (int j = this.field_75514_c.func_75873_e(); j < this.field_75514_c.func_75874_d(); j++) {
/* 142 */       if ((this.field_75514_c.func_75877_a(j)).field_75837_b != (int)vec3.field_72448_b) {
/* 143 */         i = j;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 149 */     float f = this.field_75515_a.field_70130_N * this.field_75515_a.field_70130_N; int k;
/* 150 */     for (k = this.field_75514_c.func_75873_e(); k < i; k++) {
/* 151 */       if (vec3.func_72436_e(this.field_75514_c.func_75881_a((Entity)this.field_75515_a, k)) < f) {
/* 152 */         this.field_75514_c.func_75872_c(k + 1);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 157 */     k = MathHelper.func_76123_f(this.field_75515_a.field_70130_N);
/* 158 */     int m = (int)this.field_75515_a.field_70131_O + 1;
/* 159 */     int n = k;
/* 160 */     for (int i1 = i - 1; i1 >= this.field_75514_c.func_75873_e(); i1--) {
/* 161 */       if (func_75493_a(vec3, this.field_75514_c.func_75881_a((Entity)this.field_75515_a, i1), k, m, n)) {
/* 162 */         this.field_75514_c.func_75872_c(i1);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     if (this.field_75510_g - this.field_75520_h > 100) {
/* 169 */       if (vec3.func_72436_e(this.field_75521_i) < 2.25D) func_75499_g(); 
/* 170 */       this.field_75520_h = this.field_75510_g;
/* 171 */       this.field_75521_i.field_72450_a = vec3.field_72450_a;
/* 172 */       this.field_75521_i.field_72448_b = vec3.field_72448_b;
/* 173 */       this.field_75521_i.field_72449_c = vec3.field_72449_c;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_75500_f() {
/* 178 */     return (this.field_75514_c == null || this.field_75514_c.func_75879_b());
/*     */   }
/*     */   
/*     */   public void func_75499_g() {
/* 182 */     this.field_75514_c = null;
/*     */   }
/*     */   
/*     */   private Vec3 func_75502_i() {
/* 186 */     return Vec3.func_72443_a(this.field_75515_a.field_70165_t, func_75503_j(), this.field_75515_a.field_70161_v);
/*     */   }
/*     */   
/*     */   private int func_75503_j() {
/* 190 */     if (!this.field_75515_a.func_70090_H() || !this.field_75517_m) return (int)(this.field_75515_a.field_70121_D.field_72338_b + 0.5D);
/*     */     
/* 192 */     int i = (int)this.field_75515_a.field_70121_D.field_72338_b;
/* 193 */     Block block = this.field_75513_b.func_147439_a(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), i, MathHelper.func_76128_c(this.field_75515_a.field_70161_v));
/* 194 */     byte b = 0;
/* 195 */     while (block == Blocks.field_150358_i || block == Blocks.field_150355_j) {
/* 196 */       i++;
/* 197 */       block = this.field_75513_b.func_147439_a(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), i, MathHelper.func_76128_c(this.field_75515_a.field_70161_v));
/* 198 */       if (++b > 16) return (int)this.field_75515_a.field_70121_D.field_72338_b; 
/*     */     } 
/* 200 */     return i;
/*     */   }
/*     */   
/*     */   private boolean func_75485_k() {
/* 204 */     return (this.field_75515_a.field_70122_E || (this.field_75517_m && func_75506_l()) || (this.field_75515_a.func_70115_ae() && this.field_75515_a instanceof net.minecraft.entity.monster.EntityZombie && this.field_75515_a.field_70154_o instanceof net.minecraft.entity.passive.EntityChicken));
/*     */   }
/*     */   
/*     */   private boolean func_75506_l() {
/* 208 */     return (this.field_75515_a.func_70090_H() || this.field_75515_a.func_70058_J());
/*     */   }
/*     */   
/*     */   private void func_75487_m() {
/* 212 */     if (this.field_75513_b.func_72937_j(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), (int)(this.field_75515_a.field_70121_D.field_72338_b + 0.5D), MathHelper.func_76128_c(this.field_75515_a.field_70161_v)))
/*     */       return; 
/* 214 */     for (byte b = 0; b < this.field_75514_c.func_75874_d(); b++) {
/* 215 */       PathPoint pathPoint = this.field_75514_c.func_75877_a(b);
/* 216 */       if (this.field_75513_b.func_72937_j(pathPoint.field_75839_a, pathPoint.field_75837_b, pathPoint.field_75838_c)) {
/* 217 */         this.field_75514_c.func_75871_b(b - 1);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_75493_a(Vec3 p_75493_1_, Vec3 p_75493_2_, int p_75493_3_, int p_75493_4_, int p_75493_5_) {
/* 225 */     int i = MathHelper.func_76128_c(p_75493_1_.field_72450_a);
/* 226 */     int j = MathHelper.func_76128_c(p_75493_1_.field_72449_c);
/*     */     
/* 228 */     double d1 = p_75493_2_.field_72450_a - p_75493_1_.field_72450_a;
/* 229 */     double d2 = p_75493_2_.field_72449_c - p_75493_1_.field_72449_c;
/* 230 */     double d3 = d1 * d1 + d2 * d2;
/* 231 */     if (d3 < 1.0E-8D) return false;
/*     */     
/* 233 */     double d4 = 1.0D / Math.sqrt(d3);
/* 234 */     d1 *= d4;
/* 235 */     d2 *= d4;
/*     */     
/* 237 */     p_75493_3_ += 2;
/* 238 */     p_75493_5_ += 2;
/* 239 */     if (!func_75483_a(i, (int)p_75493_1_.field_72448_b, j, p_75493_3_, p_75493_4_, p_75493_5_, p_75493_1_, d1, d2)) return false; 
/* 240 */     p_75493_3_ -= 2;
/* 241 */     p_75493_5_ -= 2;
/*     */     
/* 243 */     double d5 = 1.0D / Math.abs(d1);
/* 244 */     double d6 = 1.0D / Math.abs(d2);
/*     */     
/* 246 */     double d7 = (i * 1) - p_75493_1_.field_72450_a;
/* 247 */     double d8 = (j * 1) - p_75493_1_.field_72449_c;
/* 248 */     if (d1 >= 0.0D) d7++; 
/* 249 */     if (d2 >= 0.0D) d8++; 
/* 250 */     d7 /= d1;
/* 251 */     d8 /= d2;
/*     */     
/* 253 */     byte b1 = (d1 < 0.0D) ? -1 : 1;
/* 254 */     byte b2 = (d2 < 0.0D) ? -1 : 1;
/* 255 */     int k = MathHelper.func_76128_c(p_75493_2_.field_72450_a);
/* 256 */     int m = MathHelper.func_76128_c(p_75493_2_.field_72449_c);
/* 257 */     int n = k - i;
/* 258 */     int i1 = m - j;
/* 259 */     while (n * b1 > 0 || i1 * b2 > 0) {
/* 260 */       if (d7 < d8) {
/* 261 */         d7 += d5;
/* 262 */         i += b1;
/* 263 */         n = k - i;
/*     */       } else {
/* 265 */         d8 += d6;
/* 266 */         j += b2;
/* 267 */         i1 = m - j;
/*     */       } 
/*     */       
/* 270 */       if (!func_75483_a(i, (int)p_75493_1_.field_72448_b, j, p_75493_3_, p_75493_4_, p_75493_5_, p_75493_1_, d1, d2)) return false; 
/*     */     } 
/* 272 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_75483_a(int p_75483_1_, int p_75483_2_, int p_75483_3_, int p_75483_4_, int p_75483_5_, int p_75483_6_, Vec3 p_75483_7_, double p_75483_8_, double p_75483_10_) {
/* 277 */     int i = p_75483_1_ - p_75483_4_ / 2;
/* 278 */     int j = p_75483_3_ - p_75483_6_ / 2;
/*     */     
/* 280 */     if (!func_75496_b(i, p_75483_2_, j, p_75483_4_, p_75483_5_, p_75483_6_, p_75483_7_, p_75483_8_, p_75483_10_)) return false;
/*     */ 
/*     */     
/* 283 */     for (int k = i; k < i + p_75483_4_; k++) {
/* 284 */       for (int m = j; m < j + p_75483_6_; m++) {
/* 285 */         double d1 = k + 0.5D - p_75483_7_.field_72450_a;
/* 286 */         double d2 = m + 0.5D - p_75483_7_.field_72449_c;
/* 287 */         if (d1 * p_75483_8_ + d2 * p_75483_10_ >= 0.0D) {
/* 288 */           Block block = this.field_75513_b.func_147439_a(k, p_75483_2_ - 1, m);
/* 289 */           Material material = block.func_149688_o();
/* 290 */           if (material == Material.field_151579_a) return false; 
/* 291 */           if (material == Material.field_151586_h && !this.field_75515_a.func_70090_H()) return false; 
/* 292 */           if (material == Material.field_151587_i) return false; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 296 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_75496_b(int p_75496_1_, int p_75496_2_, int p_75496_3_, int p_75496_4_, int p_75496_5_, int p_75496_6_, Vec3 p_75496_7_, double p_75496_8_, double p_75496_10_) {
/* 301 */     for (int i = p_75496_1_; i < p_75496_1_ + p_75496_4_; i++) {
/* 302 */       for (int j = p_75496_2_; j < p_75496_2_ + p_75496_5_; j++) {
/* 303 */         for (int k = p_75496_3_; k < p_75496_3_ + p_75496_6_; k++) {
/*     */           
/* 305 */           double d1 = i + 0.5D - p_75496_7_.field_72450_a;
/* 306 */           double d2 = k + 0.5D - p_75496_7_.field_72449_c;
/* 307 */           if (d1 * p_75496_8_ + d2 * p_75496_10_ >= 0.0D) {
/* 308 */             Block block = this.field_75513_b.func_147439_a(i, j, k);
/* 309 */             if (!block.func_149655_b((IBlockAccess)this.field_75513_b, i, j, k)) return false; 
/*     */           } 
/*     */         } 
/*     */       } 
/* 313 */     }  return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\pathfinding\PathNavigate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */