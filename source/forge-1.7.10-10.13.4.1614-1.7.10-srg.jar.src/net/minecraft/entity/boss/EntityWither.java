/*     */ package net.minecraft.entity.boss;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IRangedAttackMob;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIArrowAttack;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityWitherSkull;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityWither extends EntityMob implements IBossDisplayData, IRangedAttackMob {
/*  33 */   private float[] field_82220_d = new float[2];
/*  34 */   private float[] field_82221_e = new float[2];
/*  35 */   private float[] field_82217_f = new float[2];
/*  36 */   private float[] field_82218_g = new float[2];
/*  37 */   private int[] field_82223_h = new int[2];
/*  38 */   private int[] field_82224_i = new int[2];
/*     */   
/*     */   private int field_82222_j;
/*  41 */   private static final IEntitySelector field_82219_bJ = new IEntitySelector() { private static final String __OBFID = "CL_00001662";
/*     */       
/*     */       public boolean func_82704_a(Entity p_82704_1_) {
/*  44 */         return (p_82704_1_ instanceof EntityLivingBase && ((EntityLivingBase)p_82704_1_).func_70668_bt() != EnumCreatureAttribute.UNDEAD);
/*     */       } }
/*     */   ; private static final String __OBFID = "CL_00001661";
/*     */   
/*     */   public EntityWither(World p_i1701_1_) {
/*  49 */     super(p_i1701_1_);
/*     */     
/*  51 */     func_70606_j(func_110138_aP());
/*     */     
/*  53 */     func_70105_a(0.9F, 4.0F);
/*     */ 
/*     */     
/*  56 */     this.field_70178_ae = true;
/*     */ 
/*     */ 
/*     */     
/*  60 */     func_70661_as().func_75495_e(true);
/*     */     
/*  62 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  63 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIArrowAttack(this, 1.0D, 40, 20.0F));
/*     */     
/*  65 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  66 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  67 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  69 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  70 */     this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, false, false, field_82219_bJ));
/*     */     
/*  72 */     this.field_70728_aV = 50;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  77 */     super.func_70088_a();
/*     */     
/*  79 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  80 */     this.field_70180_af.func_75682_a(18, new Integer(0));
/*  81 */     this.field_70180_af.func_75682_a(19, new Integer(0));
/*  82 */     this.field_70180_af.func_75682_a(20, new Integer(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  87 */     super.func_70014_b(p_70014_1_);
/*     */     
/*  89 */     p_70014_1_.func_74768_a("Invul", func_82212_n());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  94 */     super.func_70037_a(p_70037_1_);
/*     */     
/*  96 */     func_82215_s(p_70037_1_.func_74762_e("Invul"));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 101 */     return this.field_70131_O / 8.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 106 */     return "mob.wither.idle";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 111 */     return "mob.wither.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 116 */     return "mob.wither.death";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 122 */     this.field_70181_x *= 0.6000000238418579D;
/*     */     
/* 124 */     if (!this.field_70170_p.field_72995_K && func_82203_t(0) > 0) {
/* 125 */       Entity entity = this.field_70170_p.func_73045_a(func_82203_t(0));
/* 126 */       if (entity != null) {
/* 127 */         if (this.field_70163_u < entity.field_70163_u || (!func_82205_o() && this.field_70163_u < entity.field_70163_u + 5.0D)) {
/* 128 */           if (this.field_70181_x < 0.0D) {
/* 129 */             this.field_70181_x = 0.0D;
/*     */           }
/* 131 */           this.field_70181_x += (0.5D - this.field_70181_x) * 0.6000000238418579D;
/*     */         } 
/*     */         
/* 134 */         double d1 = entity.field_70165_t - this.field_70165_t;
/* 135 */         double d2 = entity.field_70161_v - this.field_70161_v;
/* 136 */         double d3 = d1 * d1 + d2 * d2;
/* 137 */         if (d3 > 9.0D) {
/* 138 */           double d = MathHelper.func_76133_a(d3);
/* 139 */           this.field_70159_w += (d1 / d * 0.5D - this.field_70159_w) * 0.6000000238418579D;
/* 140 */           this.field_70179_y += (d2 / d * 0.5D - this.field_70179_y) * 0.6000000238418579D;
/*     */         } 
/*     */       } 
/*     */     } 
/* 144 */     if (this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.05000000074505806D) {
/* 145 */       this.field_70177_z = (float)Math.atan2(this.field_70179_y, this.field_70159_w) * 57.295776F - 90.0F;
/*     */     }
/* 147 */     super.func_70636_d();
/*     */     
/*     */     byte b1;
/* 150 */     for (b1 = 0; b1 < 2; b1++) {
/* 151 */       this.field_82218_g[b1] = this.field_82221_e[b1];
/* 152 */       this.field_82217_f[b1] = this.field_82220_d[b1];
/*     */     } 
/*     */     
/* 155 */     for (b1 = 0; b1 < 2; b1++) {
/* 156 */       int i = func_82203_t(b1 + 1);
/* 157 */       Entity entity = null;
/* 158 */       if (i > 0) {
/* 159 */         entity = this.field_70170_p.func_73045_a(i);
/*     */       }
/* 161 */       if (entity != null) {
/* 162 */         double d1 = func_82214_u(b1 + 1);
/* 163 */         double d2 = func_82208_v(b1 + 1);
/* 164 */         double d3 = func_82213_w(b1 + 1);
/*     */         
/* 166 */         double d4 = entity.field_70165_t - d1;
/* 167 */         double d5 = entity.field_70163_u + entity.func_70047_e() - d2;
/* 168 */         double d6 = entity.field_70161_v - d3;
/* 169 */         double d7 = MathHelper.func_76133_a(d4 * d4 + d6 * d6);
/*     */         
/* 171 */         float f1 = (float)(Math.atan2(d6, d4) * 180.0D / 3.1415927410125732D) - 90.0F;
/* 172 */         float f2 = (float)-(Math.atan2(d5, d7) * 180.0D / 3.1415927410125732D);
/* 173 */         this.field_82220_d[b1] = func_82204_b(this.field_82220_d[b1], f2, 40.0F);
/* 174 */         this.field_82221_e[b1] = func_82204_b(this.field_82221_e[b1], f1, 10.0F);
/*     */       }
/*     */       else {
/*     */         
/* 178 */         this.field_82221_e[b1] = func_82204_b(this.field_82221_e[b1], this.field_70761_aq, 10.0F);
/*     */       } 
/*     */     } 
/* 181 */     boolean bool = func_82205_o(); byte b2;
/* 182 */     for (b2 = 0; b2 < 3; b2++) {
/* 183 */       double d1 = func_82214_u(b2);
/* 184 */       double d2 = func_82208_v(b2);
/* 185 */       double d3 = func_82213_w(b2);
/*     */       
/* 187 */       this.field_70170_p.func_72869_a("smoke", d1 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, d2 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, d3 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D);
/* 188 */       if (bool && this.field_70170_p.field_73012_v.nextInt(4) == 0) {
/* 189 */         this.field_70170_p.func_72869_a("mobSpell", d1 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, d2 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, d3 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D);
/*     */       }
/*     */     } 
/* 192 */     if (func_82212_n() > 0) {
/* 193 */       for (b2 = 0; b2 < 3; b2++) {
/* 194 */         this.field_70170_p.func_72869_a("mobSpell", this.field_70165_t + this.field_70146_Z.nextGaussian() * 1.0D, this.field_70163_u + (this.field_70146_Z.nextFloat() * 3.3F), this.field_70161_v + this.field_70146_Z.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {
/* 201 */     if (func_82212_n() > 0) {
/* 202 */       int j = func_82212_n() - 1;
/*     */       
/* 204 */       if (j <= 0) {
/* 205 */         this.field_70170_p.func_72885_a((Entity)this, this.field_70165_t, this.field_70163_u + func_70047_e(), this.field_70161_v, 7.0F, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
/* 206 */         this.field_70170_p.func_82739_e(1013, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/*     */       } 
/*     */       
/* 209 */       func_82215_s(j);
/* 210 */       if (this.field_70173_aa % 10 == 0) {
/* 211 */         func_70691_i(10.0F);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 217 */     super.func_70619_bc();
/*     */     int i;
/* 219 */     for (i = 1; i < 3; i++) {
/* 220 */       if (this.field_70173_aa >= this.field_82223_h[i - 1]) {
/* 221 */         this.field_82223_h[i - 1] = this.field_70173_aa + 10 + this.field_70146_Z.nextInt(10);
/*     */         
/* 223 */         this.field_82224_i[i - 1] = this.field_82224_i[i - 1] + 1; if ((this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL || this.field_70170_p.field_73013_u == EnumDifficulty.HARD) && this.field_82224_i[i - 1] > 15) {
/* 224 */           float f1 = 10.0F;
/* 225 */           float f2 = 5.0F;
/* 226 */           double d1 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70165_t - f1, this.field_70165_t + f1);
/* 227 */           double d2 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70163_u - f2, this.field_70163_u + f2);
/* 228 */           double d3 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70161_v - f1, this.field_70161_v + f1);
/* 229 */           func_82209_a(i + 1, d1, d2, d3, true);
/* 230 */           this.field_82224_i[i - 1] = 0;
/*     */         } 
/*     */         
/* 233 */         int j = func_82203_t(i);
/* 234 */         if (j > 0) {
/* 235 */           Entity entity = this.field_70170_p.func_73045_a(j);
/* 236 */           if (entity == null || !entity.func_70089_S() || func_70068_e(entity) > 900.0D || !func_70685_l(entity)) {
/* 237 */             func_82211_c(i, 0);
/*     */           } else {
/* 239 */             func_82216_a(i + 1, (EntityLivingBase)entity);
/* 240 */             this.field_82223_h[i - 1] = this.field_70173_aa + 40 + this.field_70146_Z.nextInt(20);
/* 241 */             this.field_82224_i[i - 1] = 0;
/*     */           } 
/*     */         } else {
/* 244 */           List<EntityLivingBase> list = this.field_70170_p.func_82733_a(EntityLivingBase.class, this.field_70121_D.func_72314_b(20.0D, 8.0D, 20.0D), field_82219_bJ);
/*     */           
/* 246 */           for (byte b = 0; b < 10 && !list.isEmpty(); b++) {
/* 247 */             EntityLivingBase entityLivingBase = list.get(this.field_70146_Z.nextInt(list.size()));
/*     */             
/* 249 */             if (entityLivingBase != this && entityLivingBase.func_70089_S() && func_70685_l((Entity)entityLivingBase)) {
/* 250 */               if (entityLivingBase instanceof EntityPlayer) {
/* 251 */                 if (!((EntityPlayer)entityLivingBase).field_71075_bZ.field_75102_a) {
/* 252 */                   func_82211_c(i, entityLivingBase.func_145782_y());
/*     */                 }
/*     */                 break;
/*     */               } 
/* 256 */               func_82211_c(i, entityLivingBase.func_145782_y());
/*     */               
/*     */               break;
/*     */             } 
/*     */             
/* 261 */             list.remove(entityLivingBase);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 266 */     if (func_70638_az() != null) {
/* 267 */       func_82211_c(0, func_70638_az().func_145782_y());
/*     */     } else {
/* 269 */       func_82211_c(0, 0);
/*     */     } 
/*     */     
/* 272 */     if (this.field_82222_j > 0) {
/* 273 */       this.field_82222_j--;
/*     */       
/* 275 */       if (this.field_82222_j == 0 && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
/*     */ 
/*     */ 
/*     */         
/* 279 */         i = MathHelper.func_76128_c(this.field_70163_u);
/* 280 */         int j = MathHelper.func_76128_c(this.field_70165_t);
/* 281 */         int k = MathHelper.func_76128_c(this.field_70161_v);
/* 282 */         boolean bool = false;
/*     */         
/* 284 */         for (byte b = -1; b <= 1; b++) {
/* 285 */           for (byte b1 = -1; b1 <= 1; b1++) {
/* 286 */             for (byte b2 = 0; b2 <= 3; b2++) {
/* 287 */               int m = j + b;
/* 288 */               int n = i + b2;
/* 289 */               int i1 = k + b1;
/* 290 */               Block block = this.field_70170_p.func_147439_a(m, n, i1);
/* 291 */               if (block.func_149688_o() != Material.field_151579_a && block != Blocks.field_150357_h && block != Blocks.field_150384_bq && block != Blocks.field_150378_br && block != Blocks.field_150483_bI) {
/* 292 */                 bool = (this.field_70170_p.func_147480_a(m, n, i1, true) || bool) ? true : false;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/* 297 */         if (bool) {
/* 298 */           this.field_70170_p.func_72889_a(null, 1012, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 303 */     if (this.field_70173_aa % 20 == 0) {
/* 304 */       func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_82206_m() {
/* 309 */     func_82215_s(220);
/* 310 */     func_70606_j(func_110138_aP() / 3.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70110_aj() {}
/*     */ 
/*     */   
/*     */   public int func_70658_aO() {
/* 319 */     return 4;
/*     */   }
/*     */   
/*     */   private double func_82214_u(int p_82214_1_) {
/* 323 */     if (p_82214_1_ <= 0) {
/* 324 */       return this.field_70165_t;
/*     */     }
/* 326 */     float f1 = (this.field_70761_aq + (180 * (p_82214_1_ - 1))) / 180.0F * 3.1415927F;
/* 327 */     float f2 = MathHelper.func_76134_b(f1);
/* 328 */     return this.field_70165_t + f2 * 1.3D;
/*     */   }
/*     */   
/*     */   private double func_82208_v(int p_82208_1_) {
/* 332 */     if (p_82208_1_ <= 0) {
/* 333 */       return this.field_70163_u + 3.0D;
/*     */     }
/* 335 */     return this.field_70163_u + 2.2D;
/*     */   }
/*     */ 
/*     */   
/*     */   private double func_82213_w(int p_82213_1_) {
/* 340 */     if (p_82213_1_ <= 0) {
/* 341 */       return this.field_70161_v;
/*     */     }
/* 343 */     float f1 = (this.field_70761_aq + (180 * (p_82213_1_ - 1))) / 180.0F * 3.1415927F;
/* 344 */     float f2 = MathHelper.func_76126_a(f1);
/* 345 */     return this.field_70161_v + f2 * 1.3D;
/*     */   }
/*     */   
/*     */   private float func_82204_b(float p_82204_1_, float p_82204_2_, float p_82204_3_) {
/* 349 */     float f = MathHelper.func_76142_g(p_82204_2_ - p_82204_1_);
/* 350 */     if (f > p_82204_3_) {
/* 351 */       f = p_82204_3_;
/*     */     }
/* 353 */     if (f < -p_82204_3_) {
/* 354 */       f = -p_82204_3_;
/*     */     }
/* 356 */     return p_82204_1_ + f;
/*     */   }
/*     */   
/*     */   private void func_82216_a(int p_82216_1_, EntityLivingBase p_82216_2_) {
/* 360 */     func_82209_a(p_82216_1_, p_82216_2_.field_70165_t, p_82216_2_.field_70163_u + p_82216_2_.func_70047_e() * 0.5D, p_82216_2_.field_70161_v, (p_82216_1_ == 0 && this.field_70146_Z.nextFloat() < 0.001F));
/*     */   }
/*     */   
/*     */   private void func_82209_a(int p_82209_1_, double p_82209_2_, double p_82209_4_, double p_82209_6_, boolean p_82209_8_) {
/* 364 */     this.field_70170_p.func_72889_a(null, 1014, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/*     */     
/* 366 */     double d1 = func_82214_u(p_82209_1_);
/* 367 */     double d2 = func_82208_v(p_82209_1_);
/* 368 */     double d3 = func_82213_w(p_82209_1_);
/*     */     
/* 370 */     double d4 = p_82209_2_ - d1;
/* 371 */     double d5 = p_82209_4_ - d2;
/* 372 */     double d6 = p_82209_6_ - d3;
/*     */     
/* 374 */     EntityWitherSkull entityWitherSkull = new EntityWitherSkull(this.field_70170_p, (EntityLivingBase)this, d4, d5, d6);
/* 375 */     if (p_82209_8_) entityWitherSkull.func_82343_e(true); 
/* 376 */     entityWitherSkull.field_70163_u = d2;
/* 377 */     entityWitherSkull.field_70165_t = d1;
/* 378 */     entityWitherSkull.field_70161_v = d3;
/* 379 */     this.field_70170_p.func_72838_d((Entity)entityWitherSkull);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
/* 384 */     func_82216_a(0, p_82196_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 389 */     if (func_85032_ar()) return false; 
/* 390 */     if (p_70097_1_ == DamageSource.field_76369_e) return false; 
/* 391 */     if (func_82212_n() > 0) {
/* 392 */       return false;
/*     */     }
/*     */     
/* 395 */     if (func_82205_o()) {
/* 396 */       Entity entity1 = p_70097_1_.func_76364_f();
/* 397 */       if (entity1 instanceof net.minecraft.entity.projectile.EntityArrow) {
/* 398 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 402 */     Entity entity = p_70097_1_.func_76346_g();
/* 403 */     if (entity != null && 
/* 404 */       !(entity instanceof EntityPlayer) && 
/* 405 */       entity instanceof EntityLivingBase && ((EntityLivingBase)entity).func_70668_bt() == func_70668_bt())
/*     */     {
/* 407 */       return false;
/*     */     }
/*     */     
/* 410 */     if (this.field_82222_j <= 0) {
/* 411 */       this.field_82222_j = 20;
/*     */     }
/*     */     
/* 414 */     for (byte b = 0; b < this.field_82224_i.length; b++) {
/* 415 */       this.field_82224_i[b] = this.field_82224_i[b] + 3;
/*     */     }
/*     */     
/* 418 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 423 */     func_145779_a(Items.field_151156_bN, 1);
/*     */     
/* 425 */     if (!this.field_70170_p.field_72995_K) {
/* 426 */       for (EntityPlayer entityPlayer : this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(50.0D, 100.0D, 50.0D))) {
/* 427 */         entityPlayer.func_71029_a((StatBase)AchievementList.field_150964_J);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70623_bb() {
/* 434 */     this.field_70708_bq = 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/* 439 */     return 15728880;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70690_d(PotionEffect p_70690_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70650_aV() {
/* 453 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 458 */     super.func_110147_ax();
/*     */     
/* 460 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0D);
/* 461 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.6000000238418579D);
/* 462 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_82207_a(int p_82207_1_) {
/* 466 */     return this.field_82221_e[p_82207_1_];
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_82210_r(int p_82210_1_) {
/* 470 */     return this.field_82220_d[p_82210_1_];
/*     */   }
/*     */   
/*     */   public int func_82212_n() {
/* 474 */     return this.field_70180_af.func_75679_c(20);
/*     */   }
/*     */   
/*     */   public void func_82215_s(int p_82215_1_) {
/* 478 */     this.field_70180_af.func_75692_b(20, Integer.valueOf(p_82215_1_));
/*     */   }
/*     */   
/*     */   public int func_82203_t(int p_82203_1_) {
/* 482 */     return this.field_70180_af.func_75679_c(17 + p_82203_1_);
/*     */   }
/*     */   
/*     */   public void func_82211_c(int p_82211_1_, int p_82211_2_) {
/* 486 */     this.field_70180_af.func_75692_b(17 + p_82211_1_, Integer.valueOf(p_82211_2_));
/*     */   }
/*     */   
/*     */   public boolean func_82205_o() {
/* 490 */     return (func_110143_aJ() <= func_110138_aP() / 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumCreatureAttribute func_70668_bt() {
/* 495 */     return EnumCreatureAttribute.UNDEAD;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70078_a(Entity p_70078_1_) {
/* 500 */     this.field_70154_o = null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\boss\EntityWither.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */