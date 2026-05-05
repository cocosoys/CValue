/*     */ package JinRyuu.DragonBC.common.Entitys;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.common.registry.IThrowableEntity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityEnergyFM
/*     */   extends Entity
/*     */   implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile
/*     */ {
/*     */   public Entity shootingEntity;
/*  33 */   private int xTile = -1;
/*  34 */   private int yTile = -1;
/*  35 */   private int zTile = -1;
/*     */   private Block inTile;
/*  37 */   private int inData = 0;
/*     */   
/*     */   private boolean inGround = false;
/*     */   private int ticksInGround;
/*  41 */   private int ticksInAir = 0;
/*     */ 
/*     */   
/*  44 */   private float Expl = 4.0F;
/*  45 */   private String ExplSound = "jinryuudragonbc:DBC.expl";
/*  46 */   private String AirSound = "jinryuudragonbc:DBC.hafire";
/*     */   
/*     */   private float strtX;
/*     */   private float strtY;
/*     */   private float strtZ;
/*  51 */   private float trgtX = 0.0F;
/*  52 */   private float trgtY = 0.0F;
/*  53 */   private float trgtZ = 0.0F; private byte speed;
/*     */   
/*  55 */   public float strtX() { return this.strtX; }
/*  56 */   public float strtY() { return this.strtY; }
/*  57 */   public float strtZ() { return this.strtZ; }
/*  58 */   public float trgtX() { return this.trgtX; }
/*  59 */   public float trgtY() { return this.trgtY; } public float trgtZ() {
/*  60 */     return this.trgtZ;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean shrink = false;
/*     */   
/*  66 */   private byte relFired = 100;
/*     */   
/*  68 */   private float size = 10.0F; private int cb; private boolean kiClashed; private List kiClashedList;
/*     */   
/*  70 */   public int getShrink() { return func_70096_w().func_75679_c(20); }
/*  71 */   public byte getSpe() { return this.speed; } public int getAirTicks() {
/*  72 */     return this.ticksInAir;
/*     */   } public void setAirTicks(int i) {
/*  74 */     this.ticksInAir = i;
/*     */   }
/*     */   
/*     */   public EntityEnergyFM(World par1World) {
/*  78 */     super(par1World);
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
/* 193 */     this.cb = 50;
/*     */     
/* 195 */     this.kiClashedList = new ArrayList(); func_70105_a(this.size, this.size); } protected void func_70088_a() { this.field_70180_af.func_75682_a(20, Integer.valueOf(0)); } public EntityEnergyFM(EntityLivingBase par2EntityLivingBase) { super(par2EntityLivingBase.field_70170_p); this.cb = 50; this.kiClashedList = new ArrayList(); this.speed = 20; int sbh = (int)((this.field_70163_u > 65.0D) ? (this.field_70163_u - 65.0D) : 1.0D) * 4; this.size = 0.5F + (sbh / 5 * 100) * 0.02F / 8.0F; if (this.size > 10.0F)
/*     */       this.size = 10.0F;  this.shootingEntity = (Entity)par2EntityLivingBase; this.field_70155_l = 10.0D; func_70105_a(this.size, this.size); double d8 = (par2EntityLivingBase.field_70130_N + 1.0F); double d9 = (par2EntityLivingBase.field_70131_O + 0.5F + this.size * 0.5F); Vec3 vec3 = par2EntityLivingBase.func_70676_i(1.0F); double x = par2EntityLivingBase.field_70165_t + vec3.field_72450_a * d8; double y = par2EntityLivingBase.field_70163_u + vec3.field_72448_b * d8 + (par2EntityLivingBase.field_70131_O * 0.55F); double z = par2EntityLivingBase.field_70161_v + vec3.field_72449_c * d8; func_70012_b(x, y, z, 0.0F, 0.0F); this.field_70129_M = this.size * 0.5F; this.field_70159_w = 0.0D; this.field_70179_y = 0.0D; this.field_70181_x = 1.0D; func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.speed * 0.05F, 1.0F); this.strtX = (float)x; this.strtY = (float)y; this.strtZ = (float)z; }
/*     */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) { float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5); par1 /= var9; par3 /= var9; par5 /= var9; par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par1 *= par7; par3 *= par7; par5 *= par7; this.field_70159_w = par1; this.field_70181_x = par3; this.field_70179_y = par5; float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5); this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI); this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI);
/* 198 */     this.ticksInGround = 0; } public void func_70071_h_() { if (!this.field_70170_p.field_72995_K && this.shootingEntity == null) func_70106_y(); 
/* 199 */     if (this.field_70163_u >= 250.0D) { this.field_70181_x = 0.0D; }
/*     */     else
/* 201 */     { int sbh = (int)((this.field_70163_u > 80.0D) ? (this.field_70163_u - 80.0D) : 1.0D) * 4;
/* 202 */       this.size = 0.5F + (sbh / 5 * 100) * 0.02F / 8.0F;
/* 203 */       func_70105_a(this.size, this.size); }
/*     */     
/* 205 */     this.field_70159_w = 0.0D;
/* 206 */     this.field_70179_y = 0.0D;
/*     */     
/* 208 */     if (this.field_70173_aa == 1) {
/* 209 */       func_70105_a(this.size, this.size);
/* 210 */       this.field_70129_M = this.size * 0.5F;
/*     */     } 
/* 212 */     super.func_70071_h_();
/*     */     
/* 214 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 216 */       float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 217 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/* 218 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 221 */     Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 223 */     if (block.func_149688_o() != Material.field_151579_a) {
/*     */       
/* 225 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 226 */       AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 228 */       if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))
/*     */       {
/* 230 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 234 */     if (this.inGround) {
/*     */       
/* 236 */       int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 238 */       if (block == this.inTile && var19 == this.inData)
/*     */       {
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
/* 252 */         this.ticksInGround++;
/* 253 */         if (this.ticksInGround == 1)
/*     */         {
/* 255 */           func_70106_y();
/*     */           
/* 257 */           if (!this.field_70170_p.field_72995_K)
/*     */           {
/* 259 */             this.field_70170_p.func_72956_a(this, this.AirSound, 1.0F, 1.0F);
/*     */           }
/*     */         }
/*     */       
/*     */       }
/*     */       else
/*     */       {
/* 266 */         this.inGround = false;
/*     */         
/* 268 */         this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 269 */         this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 270 */         this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 271 */         this.ticksInGround = 0;
/* 272 */         this.ticksInAir = 0;
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
/*     */     }
/*     */     else {
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
/* 311 */       this.ticksInAir++;
/* 312 */       Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 313 */       Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 314 */       MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
/* 315 */       var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 316 */       var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 325 */       if (!this.field_70170_p.field_72995_K && this.ticksInAir >= 2000)
/*     */       {
/* 327 */         func_70106_y();
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
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 367 */       for (int var6 = 1; var6 < 3; var6++);
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
/* 379 */       int t = this.ticksInAir / 10 * 10;
/* 380 */       if (this.ticksInAir == ((t == 0) ? 10 : t)) {
/* 381 */         this.field_70170_p.func_72956_a(this, "jinryuudragonbc:" + JRMCoreH.techSnds(0, 2, 0), 1.0F, 1.0F);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 387 */       if (var4 != null)
/*     */       {
/* 389 */         var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 395 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 397 */         Entity var5 = null;
/* 398 */         List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
/* 399 */         double var7 = 0.0D;
/*     */ 
/*     */         
/* 402 */         for (int var9 = 0; var9 < list.size(); var9++) {
/*     */           
/* 404 */           Entity var10 = list.get(var9);
/*     */           
/* 406 */           if (var10 instanceof EntityLivingBase && var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */             
/* 408 */             float f = 0.0F;
/* 409 */             AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(f, f, f);
/* 410 */             MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
/*     */             
/* 412 */             if (var13 != null) {
/*     */               
/* 414 */               double var14 = var17.func_72438_d(var13.field_72307_f);
/*     */               
/* 416 */               if (var14 < var7 || var7 == 0.0D) {
/*     */                 
/* 418 */                 var5 = var10;
/* 419 */                 var7 = var14;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 425 */         if (var5 != null)
/*     */         {
/* 427 */           var4 = new MovingObjectPosition(var5);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 434 */       if (var4 != null) {
/*     */ 
/*     */ 
/*     */         
/* 438 */         if (!this.field_70170_p.field_72995_K)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 445 */           this.field_70170_p.func_72956_a(this, this.ExplSound, 1.0F, 1.0F);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 452 */         this.xTile = var4.field_72311_b;
/* 453 */         this.yTile = var4.field_72312_c;
/* 454 */         this.zTile = var4.field_72309_d;
/* 455 */         this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/* 456 */         this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 465 */         this.inGround = true;
/*     */ 
/*     */         
/* 468 */         if (this.inTile.func_149688_o() != Material.field_151579_a)
/*     */         {
/* 470 */           this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 477 */       this.field_70165_t += this.field_70159_w;
/* 478 */       this.field_70163_u += this.field_70181_x;
/* 479 */       this.field_70161_v += this.field_70179_y;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 488 */       while (this.field_70125_A - this.field_70127_C >= 180.0F)
/*     */       {
/* 490 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 493 */       while (this.field_70177_z - this.field_70126_B < -180.0F)
/*     */       {
/* 495 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 498 */       while (this.field_70177_z - this.field_70126_B >= 180.0F)
/*     */       {
/* 500 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 505 */       float var22 = 1.0F;
/* 506 */       float var11 = 0.0F;
/*     */       
/* 508 */       if (func_70090_H()) {
/*     */         
/* 510 */         for (int var26 = 0; var26 < 4; var26++) {
/*     */           
/* 512 */           float var27 = 0.25F;
/* 513 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var27, this.field_70163_u - this.field_70181_x * var27, this.field_70161_v - this.field_70179_y * var27, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         } 
/*     */         
/* 516 */         var22 = 1.0F;
/*     */       } 
/*     */       
/* 519 */       this.field_70159_w *= var22;
/* 520 */       this.field_70181_x *= var22;
/* 521 */       this.field_70179_y *= var22;
/* 522 */       this.field_70181_x -= var11;
/* 523 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     }  } @SideOnly(Side.CLIENT) public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) { func_70107_b(par1, par3, par5); func_70101_b(par7, par8); }
/*     */   @SideOnly(Side.CLIENT) public void func_70016_h(double par1, double par3, double par5) { this.field_70159_w = par1; this.field_70181_x = par3; this.field_70179_y = par5; if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5); this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/*     */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / Math.PI);
/*     */       this.field_70127_C = this.field_70125_A;
/*     */       this.field_70126_B = this.field_70177_z;
/*     */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/*     */       this.ticksInGround = 0;
/*     */     }  }
/* 533 */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) { par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 534 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 535 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 536 */     par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 537 */     par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
/* 538 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 546 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 547 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 548 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 549 */     this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 550 */     this.inData = par1NBTTagCompound.func_74771_c("inData") & 0xFF;
/* 551 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer par1EntityPlayer) {
/* 560 */     if (this.field_70170_p.field_72995_K || this.inGround);
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
/* 572 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 578 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 586 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_82704_a(Entity var1) {
/* 592 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 597 */     data.writeInt((this.shootingEntity == null) ? 0 : this.shootingEntity.func_145782_y());
/* 598 */     data.writeByte(this.speed);
/* 599 */     data.writeFloat(this.strtX);
/* 600 */     data.writeFloat(this.strtY);
/* 601 */     data.writeFloat(this.strtZ);
/* 602 */     data.writeFloat(this.size);
/* 603 */     data.writeFloat(this.trgtX);
/* 604 */     data.writeFloat(this.trgtY);
/* 605 */     data.writeFloat(this.trgtZ);
/* 606 */     data.writeByte(this.shrink ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 612 */     int first = data.readInt();
/* 613 */     this.shootingEntity = (first == 0) ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
/* 614 */     this.speed = data.readByte();
/* 615 */     this.strtX = data.readFloat();
/* 616 */     this.strtY = data.readFloat();
/* 617 */     this.strtZ = data.readFloat();
/* 618 */     this.size = data.readFloat();
/* 619 */     this.trgtX = data.readFloat();
/* 620 */     this.trgtY = data.readFloat();
/* 621 */     this.trgtZ = data.readFloat();
/* 622 */     this.shrink = (data.readByte() == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getThrower() {
/* 628 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrower(Entity entity) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) {
/* 642 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double getMaxRenderDistanceSquared() {
/* 647 */     return 65536.0D;
/*     */   }
/*     */   
/*     */   public boolean func_70112_a(double par1) {
/* 651 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Entitys\EntityEnergyFM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */