/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.Ds;
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import JinRyuu.NarutoC.common.NCJutsus;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.common.registry.IThrowableEntity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityEnergyAttJ2
/*     */   extends EntityEnAttacks
/*     */   implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile
/*     */ {
/*  40 */   private final byte[] explosion_id = new byte[] { 3, 4, 0, -1, -1, -1, -1 };
/*  41 */   private final byte[] explosion_size = new byte[] { 0, 0, 0, 0, 1, -1, -1 };
/*     */ 
/*     */   
/*  44 */   private int xTile = -1;
/*  45 */   private int yTile = -1;
/*  46 */   private int zTile = -1;
/*     */   private Block inTile;
/*  48 */   private int inData = 0;
/*     */   
/*     */   private boolean inGround = false;
/*     */   private int ticksInGround;
/*  52 */   private int ticksInAir = 0;
/*  53 */   private double damage = 1.0D;
/*     */ 
/*     */   
/*     */   private int knockbackStrength;
/*     */ 
/*     */   
/*     */   private float explevel;
/*     */   
/*  61 */   private String DBCExplSound = "jinryuudragonbc:DBC.expl";
/*  62 */   private String NCExplSound = "jinryuunarutoc:NC1.Explosion";
/*     */   
/*     */   private float strtX;
/*     */   
/*     */   private float strtY;
/*     */   private float strtZ;
/*  68 */   private float trgtX = 0.0F; private byte type; private float speed; private int dam; private byte perc;
/*  69 */   private float trgtY = 0.0F; private byte pmjID; private short effect; private int color;
/*  70 */   private float trgtZ = 0.0F; private byte density; private short sincantation; private short sfire; private short smove; private byte align; private int conn;
/*     */   public float strtX() {
/*  72 */     return this.strtX; }
/*  73 */   public float strtY() { return this.strtY; }
/*  74 */   public float strtZ() { return this.strtZ; }
/*  75 */   public float trgtX() { return this.trgtX; }
/*  76 */   public float trgtY() { return this.trgtY; } public float trgtZ() {
/*  77 */     return this.trgtZ;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   private int waveCount = 20;
/*  99 */   private byte wave = 0;
/*     */   private Entity target;
/*     */   private int cost;
/*     */   private int costPerc;
/*     */   private int originDmg;
/*     */   private boolean shrink = false;
/* 105 */   private int pwrtyp = 0;
/*     */   private String nameJutsu;
/*     */   
/* 108 */   public boolean getShrink() { return this.shrink; }
/* 109 */   public byte getType() { return this.type; }
/* 110 */   public int getCol() { return this.color; }
/* 111 */   public float getSpe() { return this.speed; }
/* 112 */   public int getDam() { return this.dam; }
/* 113 */   public byte getDen() { return this.density; }
/* 114 */   public byte getPerc() { return this.perc; }
/* 115 */   public float getSizePerc() { return this.size; }
/* 116 */   public int getAirTicks() { return this.ticksInAir; } public short getEff() {
/* 117 */     return this.effect;
/*     */   } public void setAirTicks(int i) {
/* 119 */     this.ticksInAir = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 125 */   public final float[] maxSizeGrowth = new float[] { 1.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F }; public final float[] maxSizeGrowthSpeed = new float[] { 0.3F, 0.3F, 1.2F, 0.0F, 0.0F, 1.0F };
/* 126 */   public float get_maxSizeGrowth() { return this.maxSizeGrowth[this.jtsre - 1]; } public float get_maxSizeGrowthSpeed() {
/* 127 */     return this.maxSizeGrowthSpeed[this.jtsre - 1];
/* 128 */   } public float size = 0.0F;
/*     */   
/*     */   private boolean s_a = false;
/*     */   private boolean s_d = false;
/* 132 */   private final int s_wait = 3;
/* 133 */   private long s_start = 0L;
/*     */   
/*     */   public boolean chakra_trail = true;
/*     */   private int health;
/*     */   private byte jtsre;
/*     */   private Vec3 fir_vec3;
/*     */   private double fir_d8;
/*     */   private double fir_d9;
/*     */   
/*     */   public byte getjtsre() {
/* 143 */     return this.jtsre;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityEnergyAttJ2(World par1World) {
/* 150 */     super(par1World);
/* 151 */     func_70105_a(this.size, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityEnergyAttJ2(byte var1, EntityLivingBase par2EntityLivingBase, byte type, float speed, int dam, byte effect, byte color, byte density, byte sincantation, byte sfire, byte smove, byte perc, int dam1, int cost, int costPerc) {
/* 158 */     super(par2EntityLivingBase.field_70170_p);
/* 159 */     this.jtsre = var1;
/*     */ 
/*     */     
/* 162 */     this.type = type;
/*     */     
/* 164 */     this.speed = speed;
/*     */ 
/*     */     
/* 167 */     this.dam = dam;
/* 168 */     this.perc = 50;
/* 169 */     this.effect = (short)effect;
/*     */     
/* 171 */     this.color = JRMCoreH.techNCCol[5];
/* 172 */     this.density = density;
/*     */     
/* 174 */     this.sincantation = (short)sincantation;
/* 175 */     this.sfire = (short)sfire;
/* 176 */     this.smove = (short)smove;
/*     */     
/* 178 */     this.cost = cost;
/* 179 */     this.costPerc = costPerc;
/* 180 */     this.originDmg = dam1;
/* 181 */     this.pmjID = perc;
/*     */     
/* 183 */     if (this.pmjID != -1) {
/* 184 */       this.nameJutsu = JRMCoreH.trl("nc", JRMCoreH.pmj[this.pmjID][0]);
/*     */     }
/*     */     
/* 187 */     this.damage = this.dam * this.perc * 0.019999999552965164D;
/*     */ 
/*     */ 
/*     */     
/* 191 */     this.size = 0.0F;
/* 192 */     this.shootingEntity = (Entity)par2EntityLivingBase;
/* 193 */     this.pwrtyp = 0;
/* 194 */     if (this.shootingEntity instanceof EntityPlayer) this.pwrtyp = JRMCoreH.PlyrPwr((EntityPlayer)this.shootingEntity);
/*     */     
/* 196 */     this.explevel = effect;
/* 197 */     this.field_70155_l = 10.0D;
/*     */     
/* 199 */     func_70105_a(this.size, this.size);
/* 200 */     double d8 = (par2EntityLivingBase.field_70130_N + 1.0F);
/* 201 */     double d9 = par2EntityLivingBase.field_70131_O;
/* 202 */     Vec3 vec3 = par2EntityLivingBase.func_70676_i(1.0F);
/*     */     
/* 204 */     double x = par2EntityLivingBase.field_70165_t + vec3.field_72450_a * d8;
/* 205 */     double y = par2EntityLivingBase.field_70163_u + vec3.field_72448_b * d8 + (par2EntityLivingBase.field_70131_O * 0.55F);
/* 206 */     double z = par2EntityLivingBase.field_70161_v + vec3.field_72449_c * d8;
/* 207 */     func_70012_b(x, y, z, par2EntityLivingBase.field_70177_z, par2EntityLivingBase.field_70125_A);
/*     */ 
/*     */     
/* 210 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 211 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 212 */     this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F);
/* 213 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.speed * ((getjtsre() == 6) ? 0.8F : 0.7F), 1.0F);
/*     */     
/* 215 */     this.strtX = (float)x;
/* 216 */     this.strtY = (float)y;
/* 217 */     this.strtZ = (float)z;
/*     */   }
/*     */   protected void func_70088_a() {
/* 220 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {
/* 227 */     float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
/* 228 */     par1 /= var9;
/* 229 */     par3 /= var9;
/* 230 */     par5 /= var9;
/* 231 */     par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 232 */     par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 233 */     par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 234 */     par1 *= par7;
/* 235 */     par3 *= par7;
/* 236 */     par5 *= par7;
/* 237 */     this.field_70159_w = par1;
/* 238 */     this.field_70181_x = par3;
/* 239 */     this.field_70179_y = par5;
/* 240 */     float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 241 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 242 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI);
/* 243 */     this.ticksInGround = 0;
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
/* 254 */     func_70107_b(par1, par3, par5);
/* 255 */     func_70101_b(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 265 */     this.field_70159_w = par1;
/* 266 */     this.field_70181_x = par3;
/* 267 */     this.field_70179_y = par5;
/*     */     
/* 269 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 271 */       float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 272 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 273 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / Math.PI);
/* 274 */       this.field_70127_C = this.field_70125_A;
/* 275 */       this.field_70126_B = this.field_70177_z;
/* 276 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 277 */       this.ticksInGround = 0;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 294 */     if (this.field_70170_p.field_72995_K && !JRMCoreClient.mc.func_147113_T() && 
/* 295 */       getjtsre() == 3 && JGConfigClientSettings.CLIENT_GR3) {
/* 296 */       mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART1, 
/* 297 */           Math.random() * 4.0D - 2.0D, 0.0D + 
/* 298 */           Math.random() * (this.field_70131_O * 0.25F) + (this.field_70131_O / 2.0F) - (this.field_70131_O * 0.25F), 
/* 299 */           Math.random() * 4.0D - 2.0D, 
/* 300 */           Math.random() * 0.05D - 0.025D, 
/* 301 */           Math.random() * 0.1D + 0.05D, 
/* 302 */           Math.random() * 0.05D - 0.025D, 0.3F + this.size / 10.0F, 0.3F + this.size / 10.0F, 0.3F + this.size / 10.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 308 */       mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART4, 
/* 309 */           Math.random() * 4.0D - 2.0D, 0.0D + (this.field_70131_O / 2.0F), 
/*     */           
/* 311 */           Math.random() * 4.0D - 2.0D, 
/* 312 */           Math.random() * 1.2D - 0.6D, 
/* 313 */           Math.random() * 0.2D + 0.1D, 
/* 314 */           Math.random() * 1.2D - 0.6D, 0.05F, 0.01F, 0.1F);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 323 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/*     */       
/* 326 */       if (!this.s_d) {
/* 327 */         if (!this.s_a) {
/* 328 */           func_70105_a(this.size, this.size);
/*     */ 
/*     */           
/* 331 */           this.size += get_maxSizeGrowthSpeed();
/* 332 */           this.s_start = System.nanoTime() / 100000000L;
/* 333 */           this.s_a = true;
/*     */         } 
/*     */         
/* 336 */         if (this.size >= get_maxSizeGrowth()) this.s_d = true; 
/* 337 */         if (System.nanoTime() / 100000000L - this.s_start > 3L) this.s_a = false;
/*     */       
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 344 */     if (!this.field_70170_p.field_72995_K && this.shootingEntity == null) func_70106_y();
/*     */     
/* 346 */     if (this.type == 0 && !this.field_70170_p.field_72995_K && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) {
/* 347 */       byte b = JRMCoreH.getByte((EntityPlayer)this.shootingEntity, "jrmcFrng");
/* 348 */       if (b == 0) this.shrink = true; 
/* 349 */       if (this.shrink) func_70106_y();
/*     */     
/*     */     } 
/* 352 */     if (this.field_70173_aa == 1)
/*     */     {
/* 354 */       func_70105_a(this.size, this.size);
/*     */     }
/*     */     
/* 357 */     super.func_70071_h_();
/*     */ 
/*     */     
/* 360 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 362 */       float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 363 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/* 364 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 367 */     Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 369 */     if (block.func_149688_o() != Material.field_151579_a) {
/*     */       
/* 371 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 372 */       AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 374 */       if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) this.inGround = true;
/*     */     
/*     */     } 
/* 377 */     if (this.inGround && getjtsre() > 2) {
/*     */       
/* 379 */       int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 381 */       if (block == this.inTile && var19 == this.inData) {
/*     */         
/* 383 */         this.ticksInGround++;
/* 384 */         if (this.ticksInGround == 1) {
/* 385 */           func_70106_y();
/*     */         }
/*     */       } else {
/*     */         
/* 389 */         this.inGround = false;
/* 390 */         this.ticksInGround = 0;
/* 391 */         this.ticksInAir = 0;
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 397 */       this.ticksInAir++;
/* 398 */       Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 399 */       Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 400 */       MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
/* 401 */       var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 402 */       var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 404 */       if (!this.field_70170_p.field_72995_K && this.ticksInAir == 500.0F * this.perc * 0.02F) func_70106_y();
/*     */       
/* 406 */       if (var4 != null) var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 413 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 415 */         Entity var5 = null;
/* 416 */         List<Entity> var6 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
/* 417 */         double var7 = 0.0D;
/*     */         
/* 419 */         for (int var9 = 0; var9 < var6.size(); var9++) {
/*     */           
/* 421 */           Entity var10 = var6.get(var9);
/*     */           
/* 423 */           if (var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */             
/* 425 */             float f = 0.0F;
/* 426 */             AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(f, f, f);
/* 427 */             MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
/*     */             
/* 429 */             if (var13 != null) {
/*     */               
/* 431 */               double var14 = var17.func_72438_d(var13.field_72307_f);
/*     */               
/* 433 */               if (var14 < var7 || var7 == 0.0D) {
/*     */                 
/* 435 */                 var5 = var10;
/* 436 */                 var7 = var14;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 442 */         if (var5 != null) var4 = new MovingObjectPosition(var5);
/*     */       
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 448 */       if (!this.field_70170_p.field_72995_K) {
/* 449 */         List<Entity> var6; double e = 1.0D;
/* 450 */         if (e < 1.0D) {
/* 451 */           e = 1.0D;
/*     */         }
/* 453 */         Entity var5 = null;
/*     */ 
/*     */         
/* 456 */         if (getjtsre() < 3) {
/* 457 */           var6 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/*     */         } else {
/*     */           
/* 460 */           AxisAlignedBB aabb = this.field_70121_D.func_72329_c();
/* 461 */           var6 = this.field_70170_p.func_72839_b(this, aabb);
/*     */         } 
/*     */         
/* 464 */         for (int var9 = 0; var9 < var6.size(); var9++) {
/* 465 */           Entity var10 = var6.get(var9);
/* 466 */           if (var10 != this.shootingEntity) {
/* 467 */             if (var10 instanceof EntityLivingBase) {
/* 468 */               if (var4 == null) {
/* 469 */                 var4 = new MovingObjectPosition(var10);
/*     */               }
/* 471 */               if (this.target == null) {
/* 472 */                 func_70106_y();
/* 473 */                 JRMCoreH.newExpl(this.field_70170_p, this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, false, this.damage, this.shootingEntity, this.explosion_id[getjtsre() - 1]);
/* 474 */                 this.target = var10;
/*     */               }
/*     */             
/* 477 */             } else if (this.type == 0 && this.wave > 0 && this.shootingEntity instanceof EntityPlayer) {
/* 478 */               JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
/* 479 */               this.shrink = true;
/*     */             }
/* 481 */             else if (!(var10 instanceof EntityEnAttacks) && var10 != this.shootingEntity && !(var10 instanceof EntityCusPar)) {
/* 482 */               if (this.type >= 0 && this.type < 2 && this.field_70131_O > 1.5F)
/*     */               {
/* 484 */                 JRMCoreH.newExpl(this.field_70170_p, this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, false, this.damage, this.shootingEntity, this.explosion_id[getjtsre() - 1]);
/* 485 */                 func_70106_y();
/*     */               }
/*     */             
/* 488 */             } else if (var10 instanceof EntityEnergyAttJ) {
/* 489 */               EntityEnergyAttJ t = (EntityEnergyAttJ)var10;
/* 490 */               int d = (int)t.getDamage();
/* 491 */               int eff = t.getEff();
/*     */               
/* 493 */               int ad = JRMCoreH.cbadmg(this.effect, this.dam, eff, d);
/* 494 */               int td = JRMCoreH.cbtdmg(this.effect, this.dam, eff, d);
/* 495 */               if (ad == td) func_70106_y(); 
/* 496 */               if (td == 0) { t.func_70106_y(); } else { t.setDamage(td); }
/*     */               
/* 498 */               float dam = (float)(t.getDamage() / 2.0D);
/* 499 */               float spe = t.getSpe() * 2.0F;
/* 500 */               float den = t.getDen() * 10.0F;
/* 501 */               float damt = (float)(this.damage / 2.0D);
/* 502 */               float spet = this.speed * 2.0F;
/* 503 */               float dent = this.density * 10.0F;
/*     */               
/* 505 */               float power = damt - dam + spe - spet + dent - den;
/* 506 */               float calc = 1.0F - power * 0.01F;
/* 507 */               if (this.conn == 0) this.conn++; 
/* 508 */               if (this.conn == 1) {
/* 509 */                 if (power > 0.0F) {
/* 510 */                   float res = ((damt - dam) / damt + (spe - spet) / spe + (dent - den) / dent) / 3.0F;
/* 511 */                   this.field_70159_w *= res;
/* 512 */                   this.field_70181_x *= res;
/* 513 */                   this.field_70179_y *= res;
/* 514 */                   t.field_70159_w = this.field_70159_w;
/* 515 */                   t.field_70181_x = this.field_70181_x;
/* 516 */                   t.field_70179_y = this.field_70179_y;
/* 517 */                   int exp = (t.getAirTicks() < this.ticksInAir) ? t.getAirTicks() : this.ticksInAir;
/* 518 */                   if (t.getAirTicks() < this.ticksInAir)
/* 519 */                     this.ticksInAir = t.getAirTicks(); 
/*     */                 } 
/* 521 */                 this.conn = 2;
/*     */               }
/*     */             
/* 524 */             } else if (var10 instanceof EntityEnergyAttJ2) {
/* 525 */               EntityEnergyAttJ2 t = (EntityEnergyAttJ2)var10;
/* 526 */               int d = (int)t.getDamage();
/* 527 */               int eff = t.getEff();
/*     */               
/* 529 */               int ad = JRMCoreH.cbadmg(this.effect, this.dam, eff, d);
/* 530 */               int td = JRMCoreH.cbtdmg(this.effect, this.dam, eff, d);
/* 531 */               if (ad == td) func_70106_y(); 
/* 532 */               if (td == 0) { t.func_70106_y(); } else { t.setDamage(td); }
/*     */ 
/*     */               
/* 535 */               float dam = (float)(t.getDamage() / 2.0D);
/* 536 */               float spe = t.getSpe() * 2.0F;
/* 537 */               float den = t.getDen() * 10.0F;
/* 538 */               float damt = (float)(this.damage / 2.0D);
/* 539 */               float spet = this.speed * 2.0F;
/* 540 */               float dent = this.density * 10.0F;
/*     */               
/* 542 */               float power = damt - dam + spe - spet + dent - den;
/* 543 */               float calc = 1.0F - power * 0.01F;
/* 544 */               if (this.conn == 0) this.conn++; 
/* 545 */               if (this.conn == 1) {
/* 546 */                 if (power > 0.0F) {
/* 547 */                   float res = ((damt - dam) / damt + (spe - spet) / spe + (dent - den) / dent) / 3.0F;
/* 548 */                   this.field_70159_w *= res;
/* 549 */                   this.field_70181_x *= res;
/* 550 */                   this.field_70179_y *= res;
/* 551 */                   t.field_70159_w = this.field_70159_w;
/* 552 */                   t.field_70181_x = this.field_70181_x;
/* 553 */                   t.field_70179_y = this.field_70179_y;
/* 554 */                   int exp = (t.getAirTicks() < this.ticksInAir) ? t.getAirTicks() : this.ticksInAir;
/* 555 */                   if (t.getAirTicks() < this.ticksInAir)
/* 556 */                     this.ticksInAir = t.getAirTicks(); 
/*     */                 } 
/* 558 */                 this.conn = 2;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 566 */       if (var4 != null)
/*     */       {
/*     */         
/* 569 */         if (this.target != null && this.shootingEntity instanceof EntityPlayer) {
/*     */           
/* 571 */           this.trgtX = (float)this.field_70165_t;
/* 572 */           this.trgtY = (float)this.field_70163_u;
/* 573 */           this.trgtZ = (float)this.field_70161_v;
/*     */           
/* 575 */           byte b = JRMCoreH.getByte((EntityPlayer)this.shootingEntity, "jrmcFrng");
/* 576 */           if (b == 1) {
/* 577 */             if (this.waveCount == 20) {
/* 578 */               this.wave = (byte)(this.wave + 1);
/* 579 */               if (!this.field_70170_p.field_72995_K) {
/*     */                 
/* 581 */                 EntityPlayer Player = (EntityPlayer)this.shootingEntity;
/* 582 */                 byte curRel = JRMCoreH.getByte(Player, "jrmcRelease");
/* 583 */                 int curEn = JRMCoreH.getInt(Player, "jrmcEnrgy");
/* 584 */                 float cost2 = (this.cost * curRel) * 0.02F;
/* 585 */                 if (curEn - cost2 * this.perc * 0.02F <= 0.0F) func_70106_y(); 
/* 586 */                 if (cost2 < 32000.0F) {
/* 587 */                   if (!JRMCoreH.isInCreativeMode(this.shootingEntity)) JRMCoreH.setInt(curEn - cost2 * this.perc * 0.02F, Player, "jrmcEnrgy"); 
/* 588 */                   this.damage = ((this.originDmg * curRel) * 0.02F);
/*     */                 } else {
/* 590 */                   func_70106_y();
/*     */                 } 
/* 592 */               }  int var23 = (int)this.damage;
/* 593 */               DamageSource damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity);
/* 594 */               if (this.target.func_70097_a(damagesource, var23));
/* 595 */               this.field_70159_w *= 0.05000000074505806D;
/* 596 */               this.field_70181_x *= 0.05000000074505806D;
/* 597 */               this.field_70179_y *= 0.05000000074505806D;
/* 598 */               this.target.field_70159_w *= 0.05000000074505806D;
/* 599 */               this.target.field_70181_x *= 0.05000000074505806D;
/* 600 */               this.target.field_70179_y *= 0.05000000074505806D;
/*     */             } 
/*     */             
/* 603 */             this.target.field_70159_w = this.field_70159_w;
/* 604 */             this.target.field_70181_x = this.field_70181_x;
/* 605 */             this.target.field_70179_y = this.field_70179_y;
/* 606 */             this.waveCount--;
/* 607 */             if (this.waveCount <= 0) this.waveCount = 20; 
/* 608 */             if (this.wave >= 5) func_70106_y(); 
/*     */           } else {
/* 610 */             JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
/* 611 */             this.shrink = true;
/*     */           
/*     */           }
/*     */         
/*     */         }
/* 616 */         else if (var4.field_72308_g != null && this.type == 0) {
/* 617 */           if (var4.field_72308_g instanceof EntityLivingBase) { this.target = var4.field_72308_g; }
/*     */           else
/* 619 */           { JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
/* 620 */             this.shrink = true;
/*     */              }
/*     */ 
/*     */         
/*     */         }
/* 625 */         else if (var4.field_72308_g != null) {
/*     */ 
/*     */           
/* 628 */           float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/*     */           
/* 630 */           int var23 = (int)this.damage;
/*     */           
/* 632 */           if (this.density == 2 && this.shootingEntity != null)
/* 633 */           { var23 = 0;
/* 634 */             if (!this.field_70170_p.field_72995_K && var4.field_72308_g instanceof EntityPlayer) {
/* 635 */               MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 636 */               EntityPlayer Player = (EntityPlayer)var4.field_72308_g;
/* 637 */               int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(Player);
/*     */               
/* 639 */               String[] PlyrSkills = JRMCoreH.getString(Player, "jrmcSSlts").split(",");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 648 */               int t = this.dam;
/* 649 */               int t2 = (t > 30) ? 30 : ((t < 1) ? 1 : t);
/*     */               
/* 651 */               NCJutsus.wgi(server, "1;" + this.pmjID + ";" + this.dam + ";" + t2 + ";" + t2, Player.func_70005_c_(), false);
/* 652 */               EntityPlayer shtr = (EntityPlayer)this.shootingEntity;
/* 653 */               shtr.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "Target " + Player.func_70005_c_() + " under the effect of " + this.nameJutsu));
/*     */             }
/*     */              }
/* 656 */           else if (this.density == 2) { func_70106_y(); }
/*     */ 
/*     */           
/* 659 */           if (JRMCoreH.DGE(var4.field_72308_g)) JRMCoreH.jrmcExp(this.shootingEntity, 1, getType());
/*     */           
/* 661 */           DamageSource damagesource = null;
/*     */           
/* 663 */           if (this.shootingEntity == null) { func_70106_y(); }
/*     */           else
/* 665 */           { damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity); }
/*     */ 
/*     */           
/* 668 */           if (func_70027_ad()) var4.field_72308_g.func_70015_d(5);
/*     */           
/* 670 */           if (this.density != 2 && var4.field_72308_g.func_70097_a(damagesource, var23))
/*     */           {
/*     */             
/* 673 */             if (var4.field_72308_g instanceof EntityLivingBase)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 683 */               if (this.knockbackStrength > 0) {
/*     */                 
/* 685 */                 float var25 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */                 
/* 687 */                 if (var25 > 0.0F)
/*     */                 {
/* 689 */                   var4.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / var25, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / var25);
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
/*     */ 
/*     */             
/* 703 */             if (this.type >= 0 && this.type <= 2 && this.field_70131_O > 1.5F)
/*     */             {
/* 705 */               JRMCoreH.newExpl(this.field_70170_p, this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, false, this.damage, this.shootingEntity, this.explosion_id[getjtsre() - 1]);
/*     */             }
/* 707 */             func_70106_y();
/*     */           }
/*     */           else
/*     */           {
/* 711 */             this.field_70159_w *= -0.10000000149011612D;
/* 712 */             this.field_70181_x *= -0.10000000149011612D;
/* 713 */             this.field_70179_y *= -0.10000000149011612D;
/* 714 */             this.field_70177_z += 180.0F;
/* 715 */             this.field_70126_B += 180.0F;
/* 716 */             func_70106_y();
/* 717 */             this.ticksInAir = 0;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 722 */           this.xTile = var4.field_72311_b;
/* 723 */           this.yTile = var4.field_72312_c;
/* 724 */           this.zTile = var4.field_72309_d;
/* 725 */           this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/* 726 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */ 
/*     */ 
/*     */           
/* 730 */           float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 731 */           this.field_70165_t -= this.field_70159_w / var20 * 0.05000000074505806D;
/* 732 */           this.field_70163_u -= this.field_70181_x / var20 * 0.05000000074505806D;
/* 733 */           this.field_70161_v -= this.field_70179_y / var20 * 0.05000000074505806D;
/*     */           
/* 735 */           this.inGround = true;
/*     */           
/* 737 */           if (this.inTile.func_149688_o() != Material.field_151579_a)
/*     */           {
/* 739 */             this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 745 */       this.field_70165_t += this.field_70159_w;
/* 746 */       this.field_70163_u += this.field_70181_x;
/* 747 */       this.field_70161_v += this.field_70179_y;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 756 */       for (; this.field_70125_A - this.field_70127_C >= 180.0F; this.field_70127_C += 360.0F);
/* 757 */       for (; this.field_70177_z - this.field_70126_B < -180.0F; this.field_70126_B -= 360.0F);
/* 758 */       for (; this.field_70177_z - this.field_70126_B >= 180.0F; this.field_70126_B += 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 764 */       float var11 = 0.0F;
/*     */       
/* 766 */       if (func_70090_H())
/*     */       {
/* 768 */         for (int var26 = 0; var26 < 4; var26++) {
/*     */           
/* 770 */           float var27 = 0.25F;
/* 771 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var27, this.field_70163_u - this.field_70181_x * var27, this.field_70161_v - this.field_70179_y * var27, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         } 
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
/* 784 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 785 */       doBlockCollisions();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPower(Entity entity) {
/* 792 */     return (long)(getDamage() / 2.0D);
/*     */   }
/*     */   private void doBlockCollisions() {
/* 795 */     func_145775_I();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 802 */     par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 803 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 804 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 805 */     par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 806 */     par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
/* 807 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 808 */     par1NBTTagCompound.func_74780_a("damage", this.damage);
/* 809 */     par1NBTTagCompound.func_74774_a("jtsre", this.jtsre);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 817 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 818 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 819 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 820 */     this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 821 */     this.inData = par1NBTTagCompound.func_74771_c("inData") & 0xFF;
/* 822 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
/*     */     
/* 824 */     if (par1NBTTagCompound.func_74764_b("damage")) this.damage = par1NBTTagCompound.func_74769_h("damage"); 
/* 825 */     this.jtsre = par1NBTTagCompound.func_74771_c("jtsre");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
/* 831 */     if (this.field_70170_p.field_72995_K || this.inGround);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 837 */     return false;
/*     */   } @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 840 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void setDamage(double par1) {
/* 844 */     this.damage = par1;
/*     */   }
/*     */   public double getDamage() {
/* 847 */     return this.damage;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKnockbackStrength(int par1) {
/* 852 */     this.knockbackStrength = par1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 857 */     return false;
/*     */   }
/*     */   public boolean func_82704_a(Entity var1) {
/* 860 */     return false;
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 864 */     data.writeInt((this.shootingEntity == null) ? 0 : this.shootingEntity.func_145782_y());
/* 865 */     data.writeInt((this.target == null) ? 0 : this.target.func_145782_y());
/* 866 */     data.writeByte(this.perc);
/* 867 */     data.writeByte(this.type);
/* 868 */     data.writeByte(this.jtsre);
/* 869 */     data.writeInt(this.color);
/* 870 */     data.writeInt(this.dam);
/* 871 */     data.writeByte(this.density);
/* 872 */     data.writeShort(this.sincantation);
/* 873 */     data.writeShort(this.sfire);
/* 874 */     data.writeShort(this.smove);
/* 875 */     data.writeFloat(this.strtX);
/* 876 */     data.writeFloat(this.strtY);
/* 877 */     data.writeFloat(this.strtZ);
/* 878 */     data.writeFloat(this.size);
/* 879 */     data.writeFloat(this.trgtX);
/* 880 */     data.writeFloat(this.trgtY);
/* 881 */     data.writeFloat(this.trgtZ);
/* 882 */     data.writeByte(this.shrink ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 889 */     int first = data.readInt();
/* 890 */     this.shootingEntity = (first == 0) ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
/* 891 */     int second = data.readInt();
/* 892 */     this.target = (first == 0) ? this.target : this.field_70170_p.func_73045_a(second);
/* 893 */     this.perc = data.readByte();
/* 894 */     this.type = data.readByte();
/* 895 */     this.jtsre = data.readByte();
/* 896 */     this.color = data.readInt();
/* 897 */     this.dam = data.readInt();
/* 898 */     this.density = data.readByte();
/* 899 */     this.sincantation = data.readShort();
/* 900 */     this.sfire = data.readShort();
/* 901 */     this.smove = data.readShort();
/* 902 */     this.strtX = data.readFloat();
/* 903 */     this.strtY = data.readFloat();
/* 904 */     this.strtZ = data.readFloat();
/* 905 */     this.size = data.readFloat();
/* 906 */     this.trgtX = data.readFloat();
/* 907 */     this.trgtY = data.readFloat();
/* 908 */     this.trgtZ = data.readFloat();
/* 909 */     this.shrink = (data.readByte() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Entity getThrower() {
/* 914 */     return null;
/*     */   }
/*     */   
/*     */   public void setThrower(Entity entity) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3)
/*     */   {
/* 922 */     return true;
/*     */   } @SideOnly(Side.CLIENT)
/* 924 */   public double getMaxRenderDistanceSquared() { return 65536.0D; } public boolean func_70112_a(double par1) {
/* 925 */     return true;
/*     */   } public void setJutsuName(String name) {
/* 927 */     this.nameJutsu = name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 935 */     this.field_70128_L = true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityEnergyAttJ2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */