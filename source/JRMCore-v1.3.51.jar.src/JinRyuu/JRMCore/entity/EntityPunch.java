/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.Ds;
/*     */ import JinRyuu.JRMCore.JRMCEnAttacks;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityPunch
/*     */   extends EntityKiAttacksLight
/*     */   implements IEntityAdditionalSpawnData, IEntitySelector
/*     */ {
/*  34 */   private int xTile = -1;
/*  35 */   private int yTile = -1;
/*  36 */   private int zTile = -1;
/*     */   private Block inTile;
/*  38 */   private int inData = 0;
/*     */   
/*     */   private boolean inGround = false;
/*     */   
/*  42 */   public int canBePickedUp = 0;
/*     */ 
/*     */   
/*  45 */   public int arrowShake = 0;
/*     */   
/*     */   public Entity shootingEntity;
/*     */   
/*     */   private int ticksInGround;
/*  50 */   private int ticksInAir = 0;
/*  51 */   private double damage = 0.0D;
/*  52 */   private float size = 2.0F;
/*     */ 
/*     */   
/*     */   private int knockbackStrength;
/*     */ 
/*     */   
/*     */   private float explevel;
/*     */   
/*     */   private float prc;
/*     */ 
/*     */   
/*     */   public EntityPunch(World par1World) {
/*  64 */     super(par1World);
/*  65 */     func_70105_a(this.size, this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPunch(World par1World, double par2, double par4, double par6) {
/*  70 */     super(par1World);
/*  71 */     func_70105_a(this.size, this.size);
/*  72 */     func_70107_b(par2, par4, par6);
/*  73 */     this.field_70129_M = this.size / 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPunch(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
/*  78 */     super(par1World);
/*  79 */     this.shootingEntity = (Entity)par2EntityLivingBase;
/*     */     
/*  81 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/*  83 */       this.canBePickedUp = 0;
/*     */     }
/*     */     
/*  86 */     this.field_70163_u = par2EntityLivingBase.field_70163_u + par2EntityLivingBase.func_70047_e() - 0.10000000149011612D;
/*  87 */     double var6 = par3EntityLivingBase.field_70165_t - par2EntityLivingBase.field_70165_t;
/*  88 */     double var8 = par3EntityLivingBase.field_70163_u + par3EntityLivingBase.func_70047_e() - 0.699999988079071D - this.field_70163_u;
/*  89 */     double var10 = par3EntityLivingBase.field_70161_v - par2EntityLivingBase.field_70161_v;
/*  90 */     double var12 = MathHelper.func_76133_a(var6 * var6 + var10 * var10);
/*     */     
/*  92 */     if (var12 >= 1.0E-7D) {
/*     */       
/*  94 */       float var14 = (float)(Math.atan2(var10, var6) * 180.0D / Math.PI) - 90.0F;
/*  95 */       float var15 = (float)-(Math.atan2(var8, var12) * 180.0D / Math.PI);
/*  96 */       double var16 = var6 / var12;
/*  97 */       double var18 = var10 / var12;
/*  98 */       func_70012_b(par2EntityLivingBase.field_70165_t + var16, this.field_70163_u, par2EntityLivingBase.field_70161_v + var18, var14, var15);
/*  99 */       this.field_70129_M = this.size / 2.0F;
/* 100 */       float var20 = (float)var12 * 0.2F;
/* 101 */       setThrowableHeading(var6, var8 + var20, var10, par4, par5);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPunch(World par1World, EntityLivingBase par2EntityLivingBase, float par3, float prc, double dam) {
/* 107 */     super(par1World);
/* 108 */     this.damage = dam;
/* 109 */     this.shootingEntity = (Entity)par2EntityLivingBase;
/*     */     
/* 111 */     this.explevel = prc;
/* 112 */     this.prc = prc;
/*     */ 
/*     */     
/* 115 */     if (par2EntityLivingBase instanceof EntityPlayer)
/*     */     {
/* 117 */       this.canBePickedUp = 0;
/*     */     }
/*     */     
/* 120 */     func_70105_a(this.size, this.size);
/* 121 */     double d8 = par2EntityLivingBase.field_70130_N;
/* 122 */     double d9 = par2EntityLivingBase.field_70131_O;
/* 123 */     Vec3 vec3 = par2EntityLivingBase.func_70676_i(1.0F);
/* 124 */     double x = par2EntityLivingBase.field_70165_t + vec3.field_72450_a * d8;
/* 125 */     double y = par2EntityLivingBase.field_70163_u + vec3.field_72448_b * d8 + (par2EntityLivingBase.field_70131_O * 0.55F);
/* 126 */     double z = par2EntityLivingBase.field_70161_v + vec3.field_72449_c * d8;
/* 127 */     func_70012_b(x, y, z, par2EntityLivingBase.field_70177_z, par2EntityLivingBase.field_70125_A);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     this.field_70129_M = this.size * 0.5F;
/* 133 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 134 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 135 */     this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F);
/* 136 */     setThrowableHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, par3 * 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 141 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
/* 149 */     float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
/* 150 */     par1 /= var9;
/* 151 */     par3 /= var9;
/* 152 */     par5 /= var9;
/* 153 */     par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 154 */     par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 155 */     par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 156 */     par1 *= par7;
/* 157 */     par3 *= par7;
/* 158 */     par5 *= par7;
/* 159 */     this.field_70159_w = par1;
/* 160 */     this.field_70181_x = par3;
/* 161 */     this.field_70179_y = par5;
/* 162 */     float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 163 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 164 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI);
/* 165 */     this.ticksInGround = 0;
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
/* 176 */     func_70107_b(par1, par3, par5);
/* 177 */     func_70101_b(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 187 */     this.field_70159_w = par1;
/* 188 */     this.field_70181_x = par3;
/* 189 */     this.field_70179_y = par5;
/*     */     
/* 191 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 193 */       float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 194 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 195 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / Math.PI);
/* 196 */       this.field_70127_C = this.field_70125_A;
/* 197 */       this.field_70126_B = this.field_70177_z;
/* 198 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 199 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 208 */     super.func_70071_h_();
/* 209 */     if (this.field_70173_aa == 1) {
/* 210 */       func_70105_a(this.size, this.size);
/* 211 */       this.field_70129_M = this.size / 2.0F;
/*     */     } 
/* 213 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 215 */       float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 216 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/* 217 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 220 */     Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 222 */     if (block.func_149688_o() != Material.field_151579_a) {
/*     */       
/* 224 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 225 */       AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 227 */       if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))
/*     */       {
/* 229 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 233 */     if (this.arrowShake > 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     if (this.inGround) {
/*     */       
/* 240 */       int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 242 */       if (block == this.inTile && var19 == this.inData) {
/*     */         
/* 244 */         this.ticksInGround++;
/*     */         
/* 246 */         if (this.ticksInGround == 1)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 254 */           if (!this.field_70170_p.field_72995_K)
/*     */           {
/* 256 */             if (this.explevel == 2.0F);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 261 */           func_70106_y();
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 266 */         this.inGround = false;
/* 267 */         this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 268 */         this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 269 */         this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 270 */         this.ticksInGround = 0;
/* 271 */         this.ticksInAir = 0;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 276 */       this.ticksInAir++;
/* 277 */       Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 278 */       Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 279 */       MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
/* 280 */       var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 281 */       var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
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
/* 294 */       if (this.ticksInAir == 5) {
/* 295 */         func_70106_y();
/*     */       }
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
/* 331 */       if (var4 != null)
/*     */       {
/* 333 */         var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 336 */       Entity var5 = null;
/* 337 */       List<Entity> var6 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
/* 338 */       double var7 = 0.0D;
/*     */ 
/*     */ 
/*     */       
/* 342 */       for (int var9 = 0; var9 < var6.size(); var9++) {
/*     */         
/* 344 */         Entity var10 = var6.get(var9);
/*     */         
/* 346 */         if (var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */           
/* 348 */           float f = 0.0F;
/* 349 */           AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(f, f, f);
/* 350 */           MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
/*     */           
/* 352 */           if (var13 != null) {
/*     */             
/* 354 */             double var14 = var17.func_72438_d(var13.field_72307_f);
/*     */             
/* 356 */             if (var14 < var7 || var7 == 0.0D) {
/*     */               
/* 358 */               var5 = var10;
/* 359 */               var7 = var14;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 365 */       if (var5 != null)
/*     */       {
/* 367 */         var4 = new MovingObjectPosition(var5);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 372 */       if (var4 != null) {
/*     */ 
/*     */ 
/*     */         
/* 376 */         if (!this.field_70170_p.field_72995_K);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 385 */         if (var4.field_72308_g != null && var4.field_72308_g instanceof EntityLivingBase && var4.field_72308_g != this.shootingEntity && var4.field_72308_g.func_70089_S()) {
/*     */ 
/*     */           
/* 388 */           if (this.explevel == 2.0F) {
/* 389 */             this.damage *= 2.0D;
/*     */           }
/* 391 */           float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 392 */           int var23 = (int)this.damage;
/* 393 */           if (JRMCoreH.NC() && var4.field_72308_g instanceof EntityPlayer && JRMCoreH.clsTypOn((EntityPlayer)var4.field_72308_g) == 1 && JRMCoreH.getByte((EntityPlayer)var4.field_72308_g, "jrmcPwrtyp") == 2) JRMCoreH.jrmcEnergyDam(var4.field_72308_g, (int)(this.damage * this.prc), null);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 398 */           if (!this.field_70170_p.field_72995_K && (!JRMCoreH.DBC() || JRMCoreH.DGE(var4.field_72308_g)) && this.shootingEntity != null) JRMCoreH.jrmcExp(this.shootingEntity, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 405 */           DamageSource damagesource = null;
/*     */           
/* 407 */           if (this.shootingEntity == null) {
/*     */             
/* 409 */             damagesource = Ds.causeEntityPunchDamage(this, this);
/*     */           }
/*     */           else {
/*     */             
/* 413 */             damagesource = Ds.causeEntityPunchDamage(this, this.shootingEntity);
/*     */           } 
/*     */           
/* 416 */           if (func_70027_ad())
/*     */           {
/* 418 */             var4.field_72308_g.func_70015_d(5);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 424 */           if (var4.field_72308_g.func_70097_a(damagesource, var23))
/*     */           {
/*     */ 
/*     */             
/* 428 */             if (!this.field_70170_p.field_72995_K) {
/* 429 */               this.field_70170_p.func_72956_a(this, JRMCEnAttacks.PunchExplSound, 0.5F, 0.9F / (this.field_70146_Z.nextFloat() * 0.4F + 0.8F));
/*     */             }
/*     */             
/* 432 */             if (var4.field_72308_g instanceof EntityLivingBase) {
/*     */               
/* 434 */               if (!this.field_70170_p.field_72995_K) {
/*     */                 
/* 436 */                 EntityLivingBase var24 = (EntityLivingBase)var4.field_72308_g;
/* 437 */                 if (!this.field_70170_p.field_72995_K);
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 442 */               if (this.knockbackStrength > 0) {
/*     */                 
/* 444 */                 float var25 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */                 
/* 446 */                 if (var25 > 0.0F)
/*     */                 {
/* 448 */                   var4.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / var25, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / var25);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 460 */             func_70106_y();
/*     */           }
/*     */           else
/*     */           {
/* 464 */             this.field_70159_w *= -0.10000000149011612D;
/* 465 */             this.field_70181_x *= -0.10000000149011612D;
/* 466 */             this.field_70179_y *= -0.10000000149011612D;
/* 467 */             this.field_70177_z += 180.0F;
/* 468 */             this.field_70126_B += 180.0F; func_70106_y();
/* 469 */             this.ticksInAir = 0;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 474 */           this.xTile = var4.field_72311_b;
/* 475 */           this.yTile = var4.field_72312_c;
/* 476 */           this.zTile = var4.field_72309_d;
/* 477 */           this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/* 478 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 479 */           this.field_70159_w = (float)(var4.field_72307_f.field_72450_a - this.field_70165_t);
/* 480 */           this.field_70181_x = (float)(var4.field_72307_f.field_72448_b - this.field_70163_u);
/* 481 */           this.field_70179_y = (float)(var4.field_72307_f.field_72449_c - this.field_70161_v);
/* 482 */           float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 483 */           this.field_70165_t -= this.field_70159_w / f * 0.05000000074505806D;
/* 484 */           this.field_70163_u -= this.field_70181_x / f * 0.05000000074505806D;
/* 485 */           this.field_70161_v -= this.field_70179_y / f * 0.05000000074505806D;
/*     */           
/* 487 */           this.inGround = true;
/* 488 */           this.arrowShake = 0;
/* 489 */           setIsCritical(false);
/*     */           
/* 491 */           if (this.inTile.func_149688_o() != Material.field_151579_a)
/*     */           {
/* 493 */             this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 499 */       this.field_70165_t += this.field_70159_w;
/* 500 */       this.field_70163_u += this.field_70181_x;
/* 501 */       this.field_70161_v += this.field_70179_y;
/* 502 */       float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 503 */       this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/*     */       
/* 505 */       for (this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var20) * 180.0D / Math.PI); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 510 */       while (this.field_70125_A - this.field_70127_C >= 180.0F)
/*     */       {
/* 512 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 515 */       while (this.field_70177_z - this.field_70126_B < -180.0F)
/*     */       {
/* 517 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 520 */       while (this.field_70177_z - this.field_70126_B >= 180.0F)
/*     */       {
/* 522 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 527 */       float var22 = 0.99F;
/* 528 */       float var11 = 0.0F;
/*     */       
/* 530 */       if (func_70090_H()) {
/*     */         
/* 532 */         for (int var26 = 0; var26 < 4; var26++) {
/*     */           
/* 534 */           float var27 = 0.25F;
/* 535 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var27, this.field_70163_u - this.field_70181_x * var27, this.field_70161_v - this.field_70179_y * var27, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         } 
/*     */         
/* 538 */         var22 = 0.8F;
/*     */       } 
/*     */       
/* 541 */       this.field_70159_w *= var22;
/* 542 */       this.field_70181_x *= var22;
/* 543 */       this.field_70179_y *= var22;
/* 544 */       this.field_70181_x -= var11;
/* 545 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 546 */       doBlockCollisions();
/*     */     } 
/*     */   }
/*     */   private void doBlockCollisions() {
/* 550 */     func_145775_I();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2, EntityLivingBase e) {
/* 555 */     if (e.func_85032_ar())
/*     */     {
/* 557 */       return false;
/*     */     }
/* 559 */     if (e.field_70170_p.field_72995_K)
/*     */     {
/* 561 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 566 */     e.field_70721_aZ = 1.5F;
/* 567 */     boolean flag = true;
/*     */ 
/*     */     
/* 570 */     e.field_70735_aL = e.func_110143_aJ();
/*     */     
/* 572 */     damageEntity(par1DamageSource, par2, e);
/*     */ 
/*     */ 
/*     */     
/* 576 */     e.field_70739_aP = 0.0F;
/* 577 */     Entity entity = par1DamageSource.func_76346_g();
/*     */     
/* 579 */     if (entity != null)
/*     */     {
/* 581 */       if (entity instanceof EntityLivingBase)
/*     */       {
/* 583 */         e.func_70604_c((EntityLivingBase)entity);
/*     */       }
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
/* 603 */     if (flag) {
/*     */       
/* 605 */       e.field_70170_p.func_72960_a(this, (byte)2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 612 */       if (entity != null) {
/*     */         
/* 614 */         double d0 = entity.field_70165_t - e.field_70165_t;
/*     */         
/*     */         double d1;
/* 617 */         for (d1 = entity.field_70161_v - e.field_70161_v; d0 * d0 + d1 * d1 < 1.0E-4D; d1 = (Math.random() - Math.random()) * 0.01D)
/*     */         {
/* 619 */           d0 = (Math.random() - Math.random()) * 0.01D;
/*     */         }
/*     */         
/* 622 */         e.field_70739_aP = (float)(Math.atan2(d1, d0) * 180.0D / Math.PI) - e.field_70177_z;
/* 623 */         e.func_70653_a(entity, par2, d0, d1);
/*     */       }
/*     */       else {
/*     */         
/* 627 */         e.field_70739_aP = ((int)(Math.random() * 2.0D) * 180);
/*     */       } 
/*     */     } 
/*     */     
/* 631 */     if (e.func_110143_aJ() <= 0.0F) {
/*     */       
/* 633 */       if (flag);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 638 */       e.func_70645_a(par1DamageSource);
/*     */     }
/* 640 */     else if (flag) {
/*     */     
/*     */     } 
/*     */ 
/*     */     
/* 645 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void damageEntity(DamageSource par1DamageSource, float par2, EntityLivingBase e) {
/* 651 */     if (!func_85032_ar()) {
/*     */       
/* 653 */       par2 = ForgeHooks.onLivingHurt(e, par1DamageSource, par2);
/* 654 */       if (par2 <= 0.0F)
/* 655 */         return;  par2 = applyArmorCalculations(par1DamageSource, par2, e);
/* 656 */       par2 = applyPotionDamageCalculations(par1DamageSource, par2, e);
/* 657 */       float f1 = par2;
/* 658 */       par2 = Math.max(par2 - e.func_110139_bj(), 0.0F);
/* 659 */       e.func_110149_m(e.func_110139_bj() - f1 - par2);
/*     */       
/* 661 */       if (par2 != 0.0F) {
/*     */         
/* 663 */         float f2 = e.func_110143_aJ();
/* 664 */         e.func_70606_j(f2 - par2);
/* 665 */         e.func_110142_aN().func_94547_a(par1DamageSource, f2, par2);
/* 666 */         e.func_110149_m(e.func_110139_bj() - par2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected float applyArmorCalculations(DamageSource par1DamageSource, float par2, EntityLivingBase e) {
/* 672 */     if (!par1DamageSource.func_76363_c()) {
/*     */       
/* 674 */       int i = 25 - e.func_70658_aO();
/* 675 */       float f1 = par2 * i;
/* 676 */       damageArmor(par2, e);
/* 677 */       par2 = f1 / 25.0F;
/*     */     } 
/*     */     
/* 680 */     return par2;
/*     */   }
/*     */   
/*     */   protected void damageArmor(float par1, EntityLivingBase e) {
/* 684 */     if (e instanceof EntityPlayer) {
/* 685 */       ((EntityPlayer)e).field_71071_by.func_70449_g(par1);
/*     */     }
/*     */   }
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
/*     */   protected float applyPotionDamageCalculations(DamageSource par1DamageSource, float par2, EntityLivingBase e) {
/* 699 */     if (e.func_70644_a(Potion.field_76429_m) && par1DamageSource != DamageSource.field_76380_i) {
/*     */       
/* 701 */       int i = (e.func_70660_b(Potion.field_76429_m).func_76458_c() + 1) * 5;
/* 702 */       int j = 25 - i;
/* 703 */       float f1 = par2 * j;
/* 704 */       par2 = f1 / 25.0F;
/*     */     } 
/*     */     
/* 707 */     if (par2 <= 0.0F)
/*     */     {
/* 709 */       return 0.0F;
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
/* 727 */     return par2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 735 */     par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 736 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 737 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 738 */     par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 739 */     par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
/* 740 */     par1NBTTagCompound.func_74774_a("shake", (byte)this.arrowShake);
/* 741 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 742 */     par1NBTTagCompound.func_74774_a("pickup", (byte)this.canBePickedUp);
/* 743 */     par1NBTTagCompound.func_74780_a("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 751 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 752 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 753 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 754 */     this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 755 */     this.inData = par1NBTTagCompound.func_74771_c("inData") & 0xFF;
/* 756 */     this.arrowShake = par1NBTTagCompound.func_74771_c("shake") & 0xFF;
/* 757 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
/*     */     
/* 759 */     if (par1NBTTagCompound.func_74764_b("damage"))
/*     */     {
/* 761 */       this.damage = par1NBTTagCompound.func_74769_h("damage");
/*     */     }
/*     */     
/* 764 */     if (par1NBTTagCompound.func_74764_b("pickup")) {
/*     */       
/* 766 */       this.canBePickedUp = par1NBTTagCompound.func_74771_c("pickup");
/*     */     }
/* 768 */     else if (par1NBTTagCompound.func_74764_b("player")) {
/*     */       
/* 770 */       this.canBePickedUp = par1NBTTagCompound.func_74767_n("player") ? 1 : 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
/* 779 */     if (this.field_70170_p.field_72995_K || this.inGround);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 791 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 797 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDamage(double par1) {
/* 802 */     this.damage = par1;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDamage() {
/* 807 */     return this.damage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKnockbackStrength(int par1) {
/* 815 */     this.knockbackStrength = par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 823 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsCritical(boolean par1) {
/* 831 */     byte var2 = this.field_70180_af.func_75683_a(16);
/*     */     
/* 833 */     if (par1) {
/*     */       
/* 835 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 | 0x1)));
/*     */     }
/*     */     else {
/*     */       
/* 839 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getIsCritical() {
/* 848 */     byte var1 = this.field_70180_af.func_75683_a(16);
/* 849 */     return ((var1 & 0x1) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void explode() {
/* 854 */     float var1 = 2.0F;
/* 855 */     this.field_70170_p.func_72876_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, var1, this.inGround);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_82704_a(Entity var1) {
/* 865 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 870 */     data.writeInt((this.shootingEntity == null) ? 0 : this.shootingEntity.func_145782_y());
/* 871 */     data.writeDouble(this.damage);
/* 872 */     data.writeFloat(this.size);
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 876 */     int first = data.readInt();
/* 877 */     this.damage = data.readDouble();
/* 878 */     this.size = data.readFloat();
/* 879 */     this.shootingEntity = (first == 0) ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityPunch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */