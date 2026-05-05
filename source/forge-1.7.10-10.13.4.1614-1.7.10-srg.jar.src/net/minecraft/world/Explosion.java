/*     */ package net.minecraft.world;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.enchantment.EnchantmentProtection;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ public class Explosion {
/*     */   public boolean field_77286_a;
/*  20 */   private int field_77289_h = 16; public boolean field_82755_b = true;
/*  21 */   private Random field_77290_i = new Random(); private World field_77287_j; public double field_77284_b;
/*     */   public double field_77285_c;
/*     */   public double field_77282_d;
/*     */   public Entity field_77283_e;
/*     */   public float field_77280_f;
/*  26 */   public List field_77281_g = new ArrayList();
/*  27 */   private Map field_77288_k = new HashMap<Object, Object>(); private static final String __OBFID = "CL_00000134";
/*     */   
/*     */   public Explosion(World p_i1948_1_, Entity p_i1948_2_, double p_i1948_3_, double p_i1948_5_, double p_i1948_7_, float p_i1948_9_) {
/*  30 */     this.field_77287_j = p_i1948_1_;
/*  31 */     this.field_77283_e = p_i1948_2_;
/*  32 */     this.field_77280_f = p_i1948_9_;
/*  33 */     this.field_77284_b = p_i1948_3_;
/*  34 */     this.field_77285_c = p_i1948_5_;
/*  35 */     this.field_77282_d = p_i1948_7_;
/*     */   }
/*     */   
/*     */   public void func_77278_a() {
/*  39 */     float f = this.field_77280_f;
/*     */     
/*  41 */     HashSet<ChunkPosition> hashSet = new HashSet();
/*     */     int i;
/*  43 */     for (i = 0; i < this.field_77289_h; i++) {
/*  44 */       for (byte b1 = 0; b1 < this.field_77289_h; b1++) {
/*  45 */         for (byte b2 = 0; b2 < this.field_77289_h; b2++) {
/*  46 */           if (i == 0 || i == this.field_77289_h - 1 || b1 == 0 || b1 == this.field_77289_h - 1 || b2 == 0 || b2 == this.field_77289_h - 1) {
/*     */             
/*  48 */             double d1 = (i / (this.field_77289_h - 1.0F) * 2.0F - 1.0F);
/*  49 */             double d2 = (b1 / (this.field_77289_h - 1.0F) * 2.0F - 1.0F);
/*  50 */             double d3 = (b2 / (this.field_77289_h - 1.0F) * 2.0F - 1.0F);
/*  51 */             double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
/*     */             
/*  53 */             d1 /= d4;
/*  54 */             d2 /= d4;
/*  55 */             d3 /= d4;
/*     */             
/*  57 */             float f1 = this.field_77280_f * (0.7F + this.field_77287_j.field_73012_v.nextFloat() * 0.6F);
/*  58 */             double d5 = this.field_77284_b;
/*  59 */             double d6 = this.field_77285_c;
/*  60 */             double d7 = this.field_77282_d;
/*     */             
/*  62 */             float f2 = 0.3F;
/*  63 */             while (f1 > 0.0F) {
/*  64 */               int i2 = MathHelper.func_76128_c(d5);
/*  65 */               int i3 = MathHelper.func_76128_c(d6);
/*  66 */               int i4 = MathHelper.func_76128_c(d7);
/*     */               
/*  68 */               Block block = this.field_77287_j.func_147439_a(i2, i3, i4);
/*  69 */               if (block.func_149688_o() != Material.field_151579_a) {
/*  70 */                 float f3 = (this.field_77283_e != null) ? this.field_77283_e.func_145772_a(this, this.field_77287_j, i2, i3, i4, block) : block.func_149638_a(this.field_77283_e);
/*  71 */                 f1 -= (f3 + 0.3F) * f2;
/*     */               } 
/*     */               
/*  74 */               if (f1 > 0.0F && (this.field_77283_e == null || this.field_77283_e.func_145774_a(this, this.field_77287_j, i2, i3, i4, block, f1))) {
/*  75 */                 hashSet.add(new ChunkPosition(i2, i3, i4));
/*     */               }
/*     */               
/*  78 */               d5 += d1 * f2;
/*  79 */               d6 += d2 * f2;
/*  80 */               d7 += d3 * f2;
/*  81 */               f1 -= f2 * 0.75F;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  87 */     this.field_77281_g.addAll(hashSet);
/*     */     
/*  89 */     this.field_77280_f *= 2.0F;
/*  90 */     i = MathHelper.func_76128_c(this.field_77284_b - this.field_77280_f - 1.0D);
/*  91 */     int j = MathHelper.func_76128_c(this.field_77284_b + this.field_77280_f + 1.0D);
/*  92 */     int k = MathHelper.func_76128_c(this.field_77285_c - this.field_77280_f - 1.0D);
/*  93 */     int m = MathHelper.func_76128_c(this.field_77285_c + this.field_77280_f + 1.0D);
/*  94 */     int n = MathHelper.func_76128_c(this.field_77282_d - this.field_77280_f - 1.0D);
/*  95 */     int i1 = MathHelper.func_76128_c(this.field_77282_d + this.field_77280_f + 1.0D);
/*  96 */     List<Entity> list = this.field_77287_j.func_72839_b(this.field_77283_e, AxisAlignedBB.func_72330_a(i, k, n, j, m, i1));
/*  97 */     Vec3 vec3 = Vec3.func_72443_a(this.field_77284_b, this.field_77285_c, this.field_77282_d);
/*     */     
/*  99 */     for (byte b = 0; b < list.size(); b++) {
/* 100 */       Entity entity = list.get(b);
/* 101 */       double d = entity.func_70011_f(this.field_77284_b, this.field_77285_c, this.field_77282_d) / this.field_77280_f;
/*     */       
/* 103 */       if (d <= 1.0D) {
/* 104 */         double d1 = entity.field_70165_t - this.field_77284_b;
/* 105 */         double d2 = entity.field_70163_u + entity.func_70047_e() - this.field_77285_c;
/* 106 */         double d3 = entity.field_70161_v - this.field_77282_d;
/*     */         
/* 108 */         double d4 = MathHelper.func_76133_a(d1 * d1 + d2 * d2 + d3 * d3);
/* 109 */         if (d4 != 0.0D) {
/*     */           
/* 111 */           d1 /= d4;
/* 112 */           d2 /= d4;
/* 113 */           d3 /= d4;
/*     */           
/* 115 */           double d5 = this.field_77287_j.func_72842_a(vec3, entity.field_70121_D);
/* 116 */           double d6 = (1.0D - d) * d5;
/* 117 */           entity.func_70097_a(DamageSource.func_94539_a(this), (int)((d6 * d6 + d6) / 2.0D * 8.0D * this.field_77280_f + 1.0D));
/*     */           
/* 119 */           double d7 = EnchantmentProtection.func_92092_a(entity, d6);
/* 120 */           entity.field_70159_w += d1 * d7;
/* 121 */           entity.field_70181_x += d2 * d7;
/* 122 */           entity.field_70179_y += d3 * d7;
/*     */           
/* 124 */           if (entity instanceof EntityPlayer) {
/* 125 */             this.field_77288_k.put((EntityPlayer)entity, Vec3.func_72443_a(d1 * d6, d2 * d6, d3 * d6));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 130 */     this.field_77280_f = f;
/*     */   }
/*     */   
/*     */   public void func_77279_a(boolean p_77279_1_) {
/* 134 */     this.field_77287_j.func_72908_a(this.field_77284_b, this.field_77285_c, this.field_77282_d, "random.explode", 4.0F, (1.0F + (this.field_77287_j.field_73012_v.nextFloat() - this.field_77287_j.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
/* 135 */     if (this.field_77280_f < 2.0F || !this.field_82755_b) {
/* 136 */       this.field_77287_j.func_72869_a("largeexplode", this.field_77284_b, this.field_77285_c, this.field_77282_d, 1.0D, 0.0D, 0.0D);
/*     */     } else {
/* 138 */       this.field_77287_j.func_72869_a("hugeexplosion", this.field_77284_b, this.field_77285_c, this.field_77282_d, 1.0D, 0.0D, 0.0D);
/*     */     } 
/*     */     
/* 141 */     if (this.field_82755_b) {
/* 142 */       for (ChunkPosition chunkPosition : this.field_77281_g) {
/* 143 */         int i = chunkPosition.field_151329_a;
/* 144 */         int j = chunkPosition.field_151327_b;
/* 145 */         int k = chunkPosition.field_151328_c;
/*     */         
/* 147 */         Block block = this.field_77287_j.func_147439_a(i, j, k);
/*     */         
/* 149 */         if (p_77279_1_) {
/* 150 */           double d1 = (i + this.field_77287_j.field_73012_v.nextFloat());
/* 151 */           double d2 = (j + this.field_77287_j.field_73012_v.nextFloat());
/* 152 */           double d3 = (k + this.field_77287_j.field_73012_v.nextFloat());
/*     */           
/* 154 */           double d4 = d1 - this.field_77284_b;
/* 155 */           double d5 = d2 - this.field_77285_c;
/* 156 */           double d6 = d3 - this.field_77282_d;
/*     */           
/* 158 */           double d7 = MathHelper.func_76133_a(d4 * d4 + d5 * d5 + d6 * d6);
/*     */           
/* 160 */           d4 /= d7;
/* 161 */           d5 /= d7;
/* 162 */           d6 /= d7;
/*     */           
/* 164 */           double d8 = 0.5D / (d7 / this.field_77280_f + 0.1D);
/* 165 */           d8 *= (this.field_77287_j.field_73012_v.nextFloat() * this.field_77287_j.field_73012_v.nextFloat() + 0.3F);
/* 166 */           d4 *= d8;
/* 167 */           d5 *= d8;
/* 168 */           d6 *= d8;
/*     */           
/* 170 */           this.field_77287_j.func_72869_a("explode", (d1 + this.field_77284_b * 1.0D) / 2.0D, (d2 + this.field_77285_c * 1.0D) / 2.0D, (d3 + this.field_77282_d * 1.0D) / 2.0D, d4, d5, d6);
/* 171 */           this.field_77287_j.func_72869_a("smoke", d1, d2, d3, d4, d5, d6);
/*     */         } 
/*     */         
/* 174 */         if (block.func_149688_o() != Material.field_151579_a) {
/* 175 */           if (block.func_149659_a(this)) {
/* 176 */             block.func_149690_a(this.field_77287_j, i, j, k, this.field_77287_j.func_72805_g(i, j, k), 1.0F / this.field_77280_f, 0);
/*     */           }
/* 178 */           this.field_77287_j.func_147465_d(i, j, k, Blocks.field_150350_a, 0, 3);
/* 179 */           block.func_149723_a(this.field_77287_j, i, j, k, this);
/*     */         } 
/*     */       } 
/*     */     }
/* 183 */     if (this.field_77286_a) {
/* 184 */       for (ChunkPosition chunkPosition : this.field_77281_g) {
/* 185 */         int i = chunkPosition.field_151329_a;
/* 186 */         int j = chunkPosition.field_151327_b;
/* 187 */         int k = chunkPosition.field_151328_c;
/*     */         
/* 189 */         Block block1 = this.field_77287_j.func_147439_a(i, j, k);
/* 190 */         Block block2 = this.field_77287_j.func_147439_a(i, j - 1, k);
/* 191 */         if (block1.func_149688_o() == Material.field_151579_a && block2.func_149730_j() && this.field_77290_i.nextInt(3) == 0) {
/* 192 */           this.field_77287_j.func_147449_b(i, j, k, (Block)Blocks.field_150480_ab);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public Map func_77277_b() {
/* 199 */     return this.field_77288_k;
/*     */   }
/*     */   
/*     */   public EntityLivingBase func_94613_c() {
/* 203 */     if (this.field_77283_e == null) return null; 
/* 204 */     if (this.field_77283_e instanceof EntityTNTPrimed) return ((EntityTNTPrimed)this.field_77283_e).func_94083_c(); 
/* 205 */     if (this.field_77283_e instanceof EntityLivingBase) return (EntityLivingBase)this.field_77283_e; 
/* 206 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\Explosion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */