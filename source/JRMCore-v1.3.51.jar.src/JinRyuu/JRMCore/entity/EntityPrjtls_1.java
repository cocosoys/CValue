/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityPrjtls_1 extends EntityArrow implements IEntityAdditionalSpawnData, IProjectile {
/*     */   public static final int MECHA_ROCKET1 = 0;
/*     */   public static final int MECHA_ROCKET2 = 1;
/*     */   public static final int MECHA_ROCKET3 = 2;
/*     */   public static final int GUN_SHOT1 = 3;
/*     */   public static final int GUN_SHOT2 = 4;
/*     */   public static final int BAZOOKA = 5;
/*     */   public static final int GUN_MAJOR = 6;
/*  36 */   public int[] damages = null;
/*     */   
/*  38 */   private int xTile = -1; private int yTile = -1; private int zTile = -1;
/*     */   private Block inTile;
/*  40 */   private int inData = 0;
/*     */   private boolean inGround = false;
/*     */   public Entity field_70250_c;
/*     */   private int ticksInGround;
/*     */   
/*     */   public int getTicksInGround() {
/*  46 */     return this.ticksInGround;
/*  47 */   } private int ticksInAir = 0;
/*  48 */   public double field_70255_ao = 0.0D;
/*     */   private int knockbackStrength;
/*     */   private float explevel;
/*  51 */   public int wpnTyp = -1;
/*     */   public int getWpnTyp() {
/*  53 */     return this.wpnTyp;
/*     */   }
/*     */   
/*     */   public EntityPrjtls_1(World world) {
/*  57 */     super(world);
/*  58 */     func_70105_a(0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPrjtls_1(World world, double par2, double par4, double par6) {
/*  63 */     super(world);
/*  64 */     func_70105_a(0.5F, 0.5F);
/*  65 */     func_70107_b(par2, par4, par6);
/*  66 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPrjtls_1(World world, Entity shootingEntity, Entity target, float par4, float par5, int id) {
/*  71 */     super(world);
/*  72 */     func_70105_a(0.5F, 0.5F);
/*  73 */     this.wpnTyp = id;
/*  74 */     this.field_70250_c = shootingEntity;
/*     */     
/*  76 */     this.field_70251_a = 0;
/*     */     
/*  78 */     this.field_70163_u = shootingEntity.field_70163_u + shootingEntity.func_70047_e() - 0.10000000149011612D - 1.0D;
/*  79 */     double var6 = target.field_70165_t - shootingEntity.field_70165_t;
/*  80 */     double var8 = target.field_70163_u + target.func_70047_e() - 0.699999988079071D - this.field_70163_u;
/*  81 */     double var10 = target.field_70161_v - shootingEntity.field_70161_v;
/*  82 */     double var12 = MathHelper.func_76133_a(var6 * var6 + var10 * var10) * ((shootingEntity instanceof JinRyuu.DragonBC.common.Npcs.EntityRRMecha) ? 1.0D : 2.0D);
/*     */     
/*  84 */     if (var12 >= 1.0E-7D) {
/*     */       
/*  86 */       float var14 = (float)(Math.atan2(var10, var6) * 180.0D / Math.PI) - 90.0F;
/*  87 */       float var15 = (float)-(Math.atan2(var8, var12) * 180.0D / Math.PI);
/*  88 */       double var16 = var6 / var12;
/*  89 */       double var18 = var10 / var12;
/*  90 */       func_70012_b(shootingEntity.field_70165_t + var16, this.field_70163_u, shootingEntity.field_70161_v + var18, var14, var15);
/*  91 */       this.field_70129_M = 0.0F;
/*  92 */       float var20 = (float)var12 * 0.2F;
/*  93 */       func_70186_c(var6, var8, var10, par4, par5);
/*     */     } 
/*     */     
/*  96 */     if (this.damages == null)
/*     */     {
/*  98 */       this.damages = new int[] { DBCConfig.NPC_RRMech1_Dam, DBCConfig.NPC_RRMech2_Dam, DBCConfig.NPC_RRMech3_Dam, DBCConfig.RRSoldierDAM, DBCConfig.RRSoldier2DAM, DBCConfig.RRSoldier3DAM, DBCConfig.RRMajorDAM };
/*     */     }
/*     */     
/* 101 */     this.field_70255_ao = (this.damages[id] / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPrjtls_1(World world, EntityLivingBase shootingEntity, EntityLivingBase target, float par4, float par5) {
/* 106 */     super(world);
/* 107 */     this.field_70250_c = (Entity)shootingEntity;
/*     */ 
/*     */ 
/*     */     
/* 111 */     this.field_70251_a = 0;
/*     */ 
/*     */     
/* 114 */     this.field_70163_u = shootingEntity.field_70163_u + shootingEntity.func_70047_e() - 0.10000000149011612D;
/* 115 */     double var6 = target.field_70165_t - shootingEntity.field_70165_t;
/* 116 */     double var8 = target.field_70163_u + target.func_70047_e() - 0.699999988079071D - this.field_70163_u;
/* 117 */     double var10 = target.field_70161_v - shootingEntity.field_70161_v;
/* 118 */     double var12 = MathHelper.func_76133_a(var6 * var6 + var10 * var10);
/*     */     
/* 120 */     if (var12 >= 1.0E-7D) {
/*     */       
/* 122 */       float var14 = (float)(Math.atan2(var10, var6) * 180.0D / Math.PI) - 90.0F;
/* 123 */       float var15 = (float)-(Math.atan2(var8, var12) * 180.0D / Math.PI);
/* 124 */       double var16 = var6 / var12;
/* 125 */       double var18 = var10 / var12;
/* 126 */       func_70012_b(shootingEntity.field_70165_t + var16, this.field_70163_u, shootingEntity.field_70161_v + var18, var14, var15);
/* 127 */       this.field_70129_M = 0.0F;
/* 128 */       float var20 = (float)var12 * 0.2F;
/* 129 */       func_70186_c(var6, var8 + var20, var10, par4, par5);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 135 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {
/* 143 */     float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
/* 144 */     par1 /= var9;
/* 145 */     par3 /= var9;
/* 146 */     par5 /= var9;
/* 147 */     par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 148 */     par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 149 */     par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 150 */     par1 *= par7;
/* 151 */     par3 *= par7;
/* 152 */     par5 *= par7;
/* 153 */     this.field_70159_w = par1;
/* 154 */     this.field_70181_x = par3;
/* 155 */     this.field_70179_y = par5;
/* 156 */     float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 157 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 158 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI);
/* 159 */     this.ticksInGround = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 170 */     func_70107_b(par1, par3, par5);
/* 171 */     func_70101_b(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 181 */     this.field_70159_w = par1;
/* 182 */     this.field_70181_x = par3;
/* 183 */     this.field_70179_y = par5;
/*     */     
/* 185 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 187 */       float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 188 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 189 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / Math.PI);
/* 190 */       this.field_70127_C = this.field_70125_A;
/* 191 */       this.field_70126_B = this.field_70177_z;
/* 192 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 193 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 202 */     if (this.field_70173_aa >= 400)
/*     */     {
/* 204 */       func_70106_y();
/*     */     }
/* 206 */     boolean isRocket = (this.wpnTyp != 3 && this.wpnTyp != 4 && this.wpnTyp != 6);
/*     */     
/* 208 */     if (isRocket && 
/* 209 */       !this.field_70170_p.field_72995_K && (
/* 210 */       this.field_70173_aa == 1 || this.field_70173_aa % 5 == 0))
/*     */     {
/* 212 */       this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC4.rocket_travel", 0.3F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 217 */     if (this.field_70170_p.field_72995_K) {
/*     */       
/* 219 */       float sizeMulti = isRocket ? 1.0F : 0.5F;
/* 220 */       for (int i = 0; i < (isRocket ? 5 : 2); i++) {
/* 221 */         mod_JRMCore.proxy.func_gcp((Entity)this, EntityCusPars.PART5, 
/* 222 */             Math.random() * 0.5D - 0.25D, 0.0D - (this.field_70131_O / 2.0F), 
/*     */             
/* 224 */             Math.random() * 0.5D - 0.25D, 
/* 225 */             Math.random() * 0.05D - 0.025D, 
/* 226 */             Math.random() * 0.1D + 0.05D, 
/* 227 */             Math.random() * 0.05D - 0.025D, 0.05F * sizeMulti, 0.05F * sizeMulti, 0.05F * sizeMulti);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 234 */     func_70030_z();
/*     */     
/* 236 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 238 */       float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 239 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/* 240 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 243 */     Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 245 */     if (block.func_149688_o() != Material.field_151579_a) {
/*     */       
/* 247 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 248 */       AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 250 */       if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))
/*     */       {
/* 252 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 256 */     if (this.inGround) {
/*     */       
/* 258 */       if (isRocket)
/*     */       {
/* 260 */         JRMCoreH.newExpl(this.field_70170_p, (Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.explevel, false, this.field_70255_ao, this.field_70250_c, (byte)5);
/*     */       }
/*     */       
/* 263 */       func_70106_y();
/*     */       
/* 265 */       int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 267 */       if (block == this.inTile && var19 == this.inData)
/*     */       {
/* 269 */         this.ticksInGround++;
/*     */       }
/*     */       else
/*     */       {
/* 273 */         this.inGround = false;
/* 274 */         this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 275 */         this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 276 */         this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 277 */         this.ticksInGround = 0;
/* 278 */         this.ticksInAir = 0;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 283 */       this.ticksInAir++;
/* 284 */       Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 285 */       Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 286 */       MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
/* 287 */       var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 288 */       var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 290 */       if (var4 != null) {
/* 291 */         var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 296 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 298 */         Entity var5 = null;
/* 299 */         List<Entity> var6 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 300 */         double var7 = 0.0D;
/*     */         
/* 302 */         for (int var9 = 0; var9 < var6.size(); var9++) {
/*     */           
/* 304 */           Entity var10 = var6.get(var9);
/*     */           
/* 306 */           if (var10.func_70067_L() && (var10 != this.field_70250_c || this.ticksInAir >= 5)) {
/*     */             
/* 308 */             float f = 0.3F;
/* 309 */             AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(f, f, f);
/* 310 */             MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
/*     */             
/* 312 */             if (var13 != null && isNotRedRibbon(var10)) {
/*     */               
/* 314 */               double var14 = var17.func_72438_d(var13.field_72307_f);
/*     */               
/* 316 */               if (var14 < var7 || var7 == 0.0D) {
/*     */                 
/* 318 */                 var5 = var10;
/* 319 */                 var7 = var14;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 325 */         if (var5 != null)
/*     */         {
/* 327 */           var4 = new MovingObjectPosition(var5);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 334 */       if (var4 != null)
/*     */       {
/* 336 */         if (var4.field_72308_g != null && isNotRedRibbon(var4.field_72308_g)) {
/*     */           
/* 338 */           float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 339 */           int var23 = MathHelper.func_76143_f(f * this.field_70255_ao);
/*     */           
/* 341 */           if (func_70241_g())
/*     */           {
/* 343 */             var23 += this.field_70146_Z.nextInt(var23 / 2 + 2);
/*     */           }
/*     */           
/* 346 */           DamageSource damagesource = null;
/*     */           
/* 348 */           if (this.field_70250_c == null) {
/* 349 */             damagesource = mod_DragonBC.causePrjctlsDamage(this, (Entity)this);
/*     */           } else {
/*     */             
/* 352 */             damagesource = mod_DragonBC.causePrjctlsDamage(this, this.field_70250_c);
/*     */           } 
/*     */           
/* 355 */           if (func_70027_ad())
/*     */           {
/* 357 */             var4.field_72308_g.func_70015_d(5);
/*     */           }
/*     */           
/* 360 */           if (var4.field_72308_g.func_70097_a(damagesource, var23))
/*     */           {
/* 362 */             if (var4.field_72308_g instanceof EntityLivingBase)
/*     */             {
/* 364 */               if (this.knockbackStrength > 0) {
/*     */                 
/* 366 */                 float var25 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */                 
/* 368 */                 if (var25 > 0.0F)
/*     */                 {
/* 370 */                   var4.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / var25, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / var25);
/*     */                 }
/*     */               } 
/*     */             }
/*     */             
/* 375 */             if (isRocket)
/*     */             {
/* 377 */               JRMCoreH.newExpl(this.field_70170_p, (Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.explevel, false, this.field_70255_ao, this.field_70250_c, (byte)5);
/*     */             }
/*     */             
/* 380 */             func_70106_y();
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 385 */           this.xTile = var4.field_72311_b;
/* 386 */           this.yTile = var4.field_72312_c;
/* 387 */           this.zTile = var4.field_72309_d;
/* 388 */           this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/* 389 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 390 */           this.field_70159_w = (float)(var4.field_72307_f.field_72450_a - this.field_70165_t);
/* 391 */           this.field_70181_x = (float)(var4.field_72307_f.field_72448_b - this.field_70163_u);
/* 392 */           this.field_70179_y = (float)(var4.field_72307_f.field_72449_c - this.field_70161_v);
/* 393 */           float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 394 */           this.field_70165_t -= this.field_70159_w / f * 0.05000000074505806D;
/* 395 */           this.field_70163_u -= this.field_70181_x / f * 0.05000000074505806D;
/* 396 */           this.field_70161_v -= this.field_70179_y / f * 0.05000000074505806D;
/*     */           
/* 398 */           this.inGround = true;
/*     */           
/* 400 */           func_70243_d(false);
/*     */           
/* 402 */           if (this.inTile.func_149688_o() != Material.field_151579_a)
/*     */           {
/* 404 */             this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, (Entity)this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 409 */       if (func_70241_g())
/*     */       {
/* 411 */         for (int var9 = 0; var9 < 4; var9++)
/*     */         {
/* 413 */           this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * var9 / 4.0D, this.field_70163_u + this.field_70181_x * var9 / 4.0D, this.field_70161_v + this.field_70179_y * var9 / 4.0D, -this.field_70159_w, -this.field_70181_x + 0.2D, -this.field_70179_y);
/*     */         }
/*     */       }
/*     */       
/* 417 */       this.field_70165_t += this.field_70159_w;
/* 418 */       this.field_70163_u += this.field_70181_x;
/* 419 */       this.field_70161_v += this.field_70179_y;
/* 420 */       float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 421 */       this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/*     */       
/* 423 */       for (this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var20) * 180.0D / Math.PI); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 428 */       while (this.field_70125_A - this.field_70127_C >= 180.0F)
/*     */       {
/* 430 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 433 */       while (this.field_70177_z - this.field_70126_B < -180.0F)
/*     */       {
/* 435 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 438 */       while (this.field_70177_z - this.field_70126_B >= 180.0F)
/*     */       {
/* 440 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 443 */       this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
/* 444 */       this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
/* 445 */       float var22 = 0.99F;
/* 446 */       float var11 = 0.05F;
/*     */       
/* 448 */       if (func_70090_H()) {
/*     */         
/* 450 */         for (int var26 = 0; var26 < 4; var26++) {
/*     */           
/* 452 */           float var27 = 0.25F;
/* 453 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var27, this.field_70163_u - this.field_70181_x * var27, this.field_70161_v - this.field_70179_y * var27, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         } 
/*     */         
/* 456 */         var22 = 0.8F;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 463 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 464 */       doBlockCollisions();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isNotRedRibbon(Entity entity) {
/* 470 */     return (!(entity instanceof JinRyuu.DragonBC.common.Npcs.EntityRRMecha) && !(entity instanceof JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbon) && !(entity instanceof JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbon2));
/*     */   }
/*     */ 
/*     */   
/*     */   private void doBlockCollisions() {
/* 475 */     func_145775_I();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 482 */     par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 483 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 484 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 485 */     par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 486 */     par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
/* 487 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/*     */     
/* 489 */     par1NBTTagCompound.func_74780_a("damage", this.field_70255_ao);
/* 490 */     par1NBTTagCompound.func_74768_a("wpnTyp", this.wpnTyp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 498 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 499 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 500 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 501 */     this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 502 */     this.inData = par1NBTTagCompound.func_74771_c("inData") & 0xFF;
/* 503 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
/*     */     
/* 505 */     if (par1NBTTagCompound.func_74764_b("damage"))
/*     */     {
/* 507 */       this.field_70255_ao = par1NBTTagCompound.func_74769_h("damage");
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
/* 519 */     this.wpnTyp = par1NBTTagCompound.func_74762_e("wpnTyp");
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 524 */     data.writeInt((this.field_70250_c == null) ? 0 : this.field_70250_c.func_145782_y());
/* 525 */     data.writeDouble((int)this.field_70255_ao);
/* 526 */     data.writeInt(this.wpnTyp);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 532 */     int first = data.readInt();
/* 533 */     this.field_70250_c = (first == 0) ? this.field_70250_c : this.field_70170_p.func_73045_a(first);
/* 534 */     this.field_70255_ao = data.readDouble();
/* 535 */     this.wpnTyp = data.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
/* 542 */     if (!this.field_70170_p.field_72995_K && this.inGround)
/*     */     {
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
/* 556 */       func_70106_y();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 567 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 573 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70239_b(double par1) {
/* 578 */     this.field_70255_ao = par1;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_70242_d() {
/* 583 */     return this.field_70255_ao;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70240_a(int par1) {
/* 591 */     this.knockbackStrength = par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 599 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70243_d(boolean par1) {
/* 607 */     byte var2 = this.field_70180_af.func_75683_a(16);
/*     */     
/* 609 */     if (par1) {
/*     */       
/* 611 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 | 0x1)));
/*     */     }
/*     */     else {
/*     */       
/* 615 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70241_g() {
/* 624 */     byte var1 = this.field_70180_af.func_75683_a(16);
/* 625 */     return ((var1 & 0x1) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void explode() {
/* 630 */     float var1 = 2.0F;
/* 631 */     this.field_70170_p.func_72876_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, var1, this.inGround);
/*     */   }
/*     */   
/*     */   protected void onImpact(MovingObjectPosition var4) {}
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityPrjtls_1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */