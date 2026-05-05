/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.Ds;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.enchantment.EnchantmentProtection;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityTNTPrimed;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExplosionJRMC
/*     */   extends Explosion
/*     */ {
/*     */   public boolean field_77286_a = false;
/*     */   public boolean field_82755_b = true;
/*  35 */   private int field_77289_h = JRMCoreConfig.eaei;
/*  36 */   private Random explosionRNG = new Random();
/*     */   
/*     */   private World worldObj;
/*     */   
/*     */   public double field_77284_b;
/*     */   
/*     */   public double field_77285_c;
/*     */   public double field_77282_d;
/*     */   public Entity field_77283_e;
/*     */   public float field_77280_f;
/*     */   public boolean ego;
/*     */   public double damage;
/*  48 */   public List field_77281_g = new ArrayList();
/*  49 */   private Map field_77288_k = new HashMap<Object, Object>();
/*     */   
/*     */   public Entity palyer;
/*     */   
/*     */   public byte type;
/*     */ 
/*     */   
/*     */   public ExplosionJRMC(World par1World, Entity par2Entity, double x, double y, double z, float size, boolean off, double dam, Entity origin, byte type) {
/*  57 */     super(par1World, par2Entity, x, y, z, size);
/*  58 */     this.worldObj = par1World;
/*  59 */     this.field_77283_e = par2Entity;
/*  60 */     this.field_77280_f = size;
/*  61 */     this.field_77284_b = x;
/*  62 */     this.field_77285_c = y;
/*  63 */     this.field_77282_d = z;
/*  64 */     this.ego = off;
/*  65 */     this.damage = dam;
/*  66 */     this.palyer = origin;
/*  67 */     this.type = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77278_a() {
/*  75 */     this.field_77289_h = (int)(this.field_77289_h * this.field_77280_f);
/*  76 */     float f = this.field_77280_f;
/*  77 */     HashSet<ChunkPosition> hashset = new HashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     if (!this.ego)
/*     */     {
/*  87 */       for (int m = 0; m < this.field_77289_h; m++) {
/*     */         
/*  89 */         for (int n = 0; n < this.field_77289_h; n++) {
/*     */           
/*  91 */           for (int i1 = 0; i1 < this.field_77289_h; i1++) {
/*     */             
/*  93 */             if (m == 0 || m == this.field_77289_h - 1 || n == 0 || n == this.field_77289_h - 1 || i1 == 0 || i1 == this.field_77289_h - 1) {
/*     */               
/*  95 */               double d3 = (m / (this.field_77289_h - 1.0F) * 2.0F - 1.0F);
/*  96 */               double d4 = (n / (this.field_77289_h - 1.0F) * 2.0F - 1.0F);
/*  97 */               double d5 = (i1 / (this.field_77289_h - 1.0F) * 2.0F - 1.0F);
/*  98 */               double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
/*  99 */               d3 /= d6;
/* 100 */               d4 /= d6;
/* 101 */               d5 /= d6;
/* 102 */               float f1 = this.field_77280_f * (0.7F + this.worldObj.field_73012_v.nextFloat() * 0.6F);
/* 103 */               double d0 = this.field_77284_b;
/* 104 */               double d1 = this.field_77285_c;
/* 105 */               double d2 = this.field_77282_d;
/*     */               
/* 107 */               for (float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F) {
/*     */                 
/* 109 */                 int l = MathHelper.func_76128_c(d0);
/* 110 */                 int i3 = MathHelper.func_76128_c(d1);
/* 111 */                 int j1 = MathHelper.func_76128_c(d2);
/* 112 */                 Block block = this.worldObj.func_147439_a(l, i3, j1);
/*     */                 
/* 114 */                 if (!this.ego && block.func_149688_o() != Material.field_151579_a) {
/*     */ 
/*     */                   
/* 117 */                   float f3 = (this.field_77283_e != null) ? (this.field_77283_e.func_145772_a(this, this.worldObj, l, i3, j1, block) * 0.2F) : (block.getExplosionResistance(this.field_77283_e, this.worldObj, l, i3, j1, this.field_77284_b, this.field_77285_c, this.field_77282_d) * 0.2F);
/* 118 */                   f1 -= (f3 + 0.3F) * f2;
/*     */                 } 
/*     */                 
/* 121 */                 if (!this.ego && f1 > 0.0F && (this.field_77283_e == null || this.field_77283_e.func_145774_a(this, this.worldObj, l, i3, j1, block, f1)))
/*     */                 {
/* 123 */                   hashset.add(new ChunkPosition(l, i3, j1));
/*     */                 }
/*     */                 
/* 126 */                 d0 += d3 * f2;
/* 127 */                 d1 += d4 * f2;
/* 128 */                 d2 += d5 * f2;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 136 */     this.field_77281_g.addAll(hashset);
/* 137 */     this.field_77280_f *= 2.0F;
/* 138 */     int i = MathHelper.func_76128_c(this.field_77284_b - this.field_77280_f - 1.0D);
/* 139 */     int j = MathHelper.func_76128_c(this.field_77284_b + this.field_77280_f + 1.0D);
/* 140 */     int k = MathHelper.func_76128_c(this.field_77285_c - this.field_77280_f - 1.0D);
/* 141 */     int l1 = MathHelper.func_76128_c(this.field_77285_c + this.field_77280_f + 1.0D);
/* 142 */     int i2 = MathHelper.func_76128_c(this.field_77282_d - this.field_77280_f - 1.0D);
/* 143 */     int j2 = MathHelper.func_76128_c(this.field_77282_d + this.field_77280_f + 1.0D);
/* 144 */     List<Entity> list = this.worldObj.func_72839_b(this.field_77283_e, AxisAlignedBB.func_72330_a(i, k, i2, j, l1, j2));
/* 145 */     Vec3 vec3 = Vec3.func_72443_a(this.field_77284_b, this.field_77285_c, this.field_77282_d);
/*     */     
/* 147 */     for (int k2 = 0; k2 < list.size(); k2++) {
/*     */       
/* 149 */       Entity entity = list.get(k2);
/* 150 */       double d7 = entity.func_70011_f(this.field_77284_b, this.field_77285_c, this.field_77282_d) / this.field_77280_f;
/*     */       
/* 152 */       if (d7 <= 1.0D) {
/*     */         
/* 154 */         double d0 = entity.field_70165_t - this.field_77284_b;
/* 155 */         double d1 = entity.field_70163_u + entity.func_70047_e() - this.field_77285_c;
/* 156 */         double d2 = entity.field_70161_v - this.field_77282_d;
/* 157 */         double d8 = MathHelper.func_76133_a(d0 * d0 + d1 * d1 + d2 * d2);
/*     */         
/* 159 */         if (d8 != 0.0D) {
/*     */           
/* 161 */           d0 /= d8;
/* 162 */           d1 /= d8;
/* 163 */           d2 /= d8;
/* 164 */           double d9 = this.worldObj.func_72842_a(vec3, entity.field_70121_D);
/* 165 */           double d10 = (1.0D - d7) * d9;
/* 166 */           int sdmg = (int)((1.0D - d7) * this.damage / 1.25D);
/*     */           
/* 168 */           if (this.palyer instanceof EntityPlayer || entity instanceof EntityPlayer)
/* 169 */             entity.func_70097_a(Ds.causeExplosion(this.palyer), sdmg); 
/* 170 */           double d11 = EnchantmentProtection.func_92092_a(entity, d10);
/* 171 */           entity.field_70159_w += d0 * d11;
/* 172 */           entity.field_70181_x += d1 * d11;
/* 173 */           entity.field_70179_y += d2 * d11;
/*     */           
/* 175 */           if (entity instanceof EntityPlayer)
/*     */           {
/* 177 */             this.field_77288_k.put((EntityPlayer)entity, Vec3.func_72443_a(d0 * d10, d1 * d10, d2 * d10));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     this.field_77280_f = f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77279_a(boolean par1) {
/* 191 */     String snd = "";
/* 192 */     if (this.palyer instanceof EntityPlayer) {
/* 193 */       byte p = JRMCoreH.getByte((EntityPlayer)this.palyer, "PowerType");
/* 194 */       snd = (p == 2) ? "jinryuunarutoc:NC1.Explosion" : "jinryuudragonbc:DBC.expl";
/*     */     } 
/* 196 */     if (this.type != 5) this.worldObj.func_72908_a(this.field_77284_b, this.field_77285_c, this.field_77282_d, snd, 4.0F, (1.0F + (this.worldObj.field_73012_v.nextFloat() - this.worldObj.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
/*     */     
/* 198 */     if (this.field_77280_f >= 2.0F && this.field_82755_b) {
/*     */       
/* 200 */       this.worldObj.func_72869_a("hugeexplosion", this.field_77284_b, this.field_77285_c, this.field_77282_d, 1.0D, 0.0D, 0.0D);
/*     */     }
/*     */     else {
/*     */       
/* 204 */       this.worldObj.func_72869_a("largeexplode", this.field_77284_b, this.field_77285_c, this.field_77282_d, 1.0D, 0.0D, 0.0D);
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
/* 215 */     if (this.field_82755_b) {
/*     */       
/* 217 */       Iterator<ChunkPosition> iterator = this.field_77281_g.iterator();
/*     */       
/* 219 */       while (iterator.hasNext()) {
/*     */         
/* 221 */         ChunkPosition chunkposition = iterator.next();
/* 222 */         int i = chunkposition.field_151329_a;
/* 223 */         int j = chunkposition.field_151327_b;
/* 224 */         int k = chunkposition.field_151328_c;
/* 225 */         Block block = this.worldObj.func_147439_a(i, j, k);
/*     */         
/* 227 */         if (par1) {
/*     */           
/* 229 */           double d0 = i;
/* 230 */           double d1 = j;
/* 231 */           double d2 = k;
/* 232 */           double d3 = d0 - this.field_77284_b;
/* 233 */           double d4 = d1 - this.field_77285_c;
/* 234 */           double d5 = d2 - this.field_77282_d;
/* 235 */           double d6 = MathHelper.func_76133_a(d3 * d3 + d4 * d4 + d5 * d5);
/* 236 */           d3 /= d6;
/* 237 */           d4 /= d6;
/* 238 */           d5 /= d6;
/* 239 */           double d7 = 0.5D / (d6 / this.field_77280_f + 0.1D);
/* 240 */           d7 *= (this.worldObj.field_73012_v.nextFloat() * this.worldObj.field_73012_v.nextFloat() + 0.3F);
/* 241 */           d3 *= d7;
/* 242 */           d4 *= d7;
/* 243 */           d5 *= d7;
/*     */         } 
/*     */         
/* 246 */         if (block.func_149688_o() != Material.field_151579_a) {
/*     */           
/* 248 */           this.worldObj.func_147468_f(i, j, k);
/* 249 */           block.func_149723_a(this.worldObj, i, j, k, this);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 254 */     if (this.field_77286_a) {
/*     */       
/* 256 */       Iterator<ChunkPosition> iterator = this.field_77281_g.iterator();
/*     */       
/* 258 */       while (iterator.hasNext()) {
/*     */         
/* 260 */         ChunkPosition chunkposition = iterator.next();
/* 261 */         int i = chunkposition.field_151329_a;
/* 262 */         int j = chunkposition.field_151327_b;
/* 263 */         int k = chunkposition.field_151328_c;
/* 264 */         Block block = this.worldObj.func_147439_a(i, j, k);
/* 265 */         Block block1 = this.worldObj.func_147439_a(i, j - 1, k);
/*     */         
/* 267 */         if (block.func_149688_o() != Material.field_151579_a || !block1.func_149730_j() || this.explosionRNG.nextInt(3) == 0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map func_77277_b() {
/* 277 */     return this.field_77288_k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLivingBase func_94613_c() {
/* 285 */     return (this.field_77283_e == null) ? null : ((this.field_77283_e instanceof EntityTNTPrimed) ? ((EntityTNTPrimed)this.field_77283_e).func_94083_c() : ((this.field_77283_e instanceof EntityLivingBase) ? (EntityLivingBase)this.field_77283_e : null));
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ExplosionJRMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */