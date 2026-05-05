/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class KintounEntity
/*     */   extends KintounBaseEntity {
/*     */   private boolean field_70279_a;
/*     */   private double speedMultiplier;
/*     */   private int boatPosRotationIncrements;
/*     */   private double boatX;
/*     */   private double boatY;
/*     */   private double boatZ;
/*     */   private double boatYaw;
/*     */   private double boatPitch;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityX;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityY;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityZ;
/*     */   public String texture;
/*     */   private int dropcounter;
/*     */   private float dS;
/*  41 */   private float T = 0.05F;
/*     */ 
/*     */   
/*     */   public KintounEntity(World par1World) {
/*  45 */     super(par1World);
/*  46 */     this.field_70279_a = true;
/*  47 */     this.speedMultiplier = 0.08D;
/*  48 */     this.field_70156_m = true;
/*     */     
/*  50 */     func_70105_a(1.5F, 1.5F);
/*  51 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  52 */     setCloudColor(16774228);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  66 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  67 */     this.field_70180_af.func_75682_a(18, new Integer(1));
/*  68 */     this.field_70180_af.func_75682_a(19, new Float(0.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  77 */     return par1Entity.field_70121_D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  85 */     return this.field_70121_D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public KintounEntity(World par1World, double par2, double par4, double par6) {
/*  98 */     this(par1World);
/*  99 */     func_70107_b(par2, par4 + this.field_70129_M, par6);
/* 100 */     this.field_70159_w = 0.0D;
/* 101 */     this.field_70181_x = 0.0D;
/* 102 */     this.field_70179_y = 0.0D;
/* 103 */     this.field_70169_q = par2;
/* 104 */     this.field_70167_r = par4;
/* 105 */     this.field_70166_s = par6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double func_70042_X() {
/* 113 */     return this.field_70131_O * 0.0D - 0.30000001192092896D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 121 */     if (func_85032_ar())
/*     */     {
/* 123 */       return false;
/*     */     }
/* 125 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/*     */ 
/*     */       
/* 128 */       setTimeSinceHit(10);
/* 129 */       setDamageTaken(getDamageTaken() + par2 * 10.0F);
/* 130 */       func_70018_K();
/* 131 */       boolean flag = (par1DamageSource.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)par1DamageSource.func_76346_g()).field_71075_bZ.field_75098_d);
/*     */       
/* 133 */       if (flag || getDamageTaken() > 1.0F) {
/*     */         
/* 135 */         if (this.field_70153_n != null)
/*     */         {
/* 137 */           this.field_70153_n.func_70078_a(this);
/*     */         }
/* 139 */         func_145778_a(ItemsDBC.KintounItem, 1, 0.0F);
/*     */         
/* 141 */         if (!flag);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 146 */         func_70106_y();
/*     */       } 
/*     */       
/* 149 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70057_ab() {
/* 165 */     setTimeSinceHit(10);
/* 166 */     setDamageTaken(getDamageTaken() * 11.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 174 */     return !this.field_70128_L;
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
/* 185 */     if (this.field_70279_a) {
/*     */       
/* 187 */       this.boatPosRotationIncrements = par9 + 5;
/*     */     }
/*     */     else {
/*     */       
/* 191 */       double d3 = par1 - this.field_70165_t;
/* 192 */       double d4 = par3 - this.field_70163_u;
/* 193 */       double d5 = par5 - this.field_70161_v;
/* 194 */       double d6 = d3 * d3 + d4 * d4 + d5 * d5;
/*     */       
/* 196 */       if (d6 <= 1.0D) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 201 */       this.boatPosRotationIncrements = 3;
/*     */     } 
/*     */     
/* 204 */     this.boatX = par1;
/* 205 */     this.boatY = par3;
/* 206 */     this.boatZ = par5;
/* 207 */     this.boatYaw = par7;
/* 208 */     this.boatPitch = par8;
/* 209 */     this.field_70159_w = this.velocityX;
/* 210 */     this.field_70181_x = this.velocityY;
/* 211 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 221 */     this.velocityX = this.field_70159_w = par1;
/* 222 */     this.velocityY = this.field_70181_x = par3;
/* 223 */     this.velocityZ = this.field_70179_y = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 231 */     if (!this.field_70170_p.field_72995_K && this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer) {
/*     */       
/* 233 */       NBTTagCompound tag = JRMCoreH.nbt(this.field_70153_n, "pres");
/*     */       
/* 235 */       boolean isKOd = (tag.func_74762_e("jrmcHar4va") > 0);
/* 236 */       if (isKOd)
/*     */       {
/* 238 */         this.field_70153_n.func_70078_a(null);
/*     */       }
/*     */     } 
/*     */     
/* 242 */     super.func_70071_h_();
/*     */     
/* 244 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/* 246 */       if (JGConfigClientSettings.CLIENT_DA11)
/*     */       {
/* 248 */         for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/* 249 */           if (this.field_70159_w != 0.0D || this.field_70179_y != 0.0D) {
/*     */             
/* 251 */             Entity pl = this;
/*     */             
/* 253 */             double x = 0.0D;
/* 254 */             double y = -1.2000000476837158D;
/* 255 */             double z = 0.0D;
/* 256 */             EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, 10, 11, 1, 32, false, 0.0F, false, 0.0F, 1, "", 15, 2, 0.05F, 0.001F, -0.0045F, 2, 255.0F, 230.0F, 20.0F, 0.0F, 0.0F, 0.0F, 255.0F, 255.0F, 255.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.001F, false, -1, false, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 268 */             ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 275 */     if (getTimeSinceHit() > 0)
/*     */     {
/* 277 */       setTimeSinceHit(getTimeSinceHit() - 1);
/*     */     }
/*     */     
/* 280 */     if (getDamageTaken() > 0.0F)
/*     */     {
/* 282 */       setDamageTaken(getDamageTaken() - 1.0F);
/*     */     }
/*     */     
/* 285 */     this.field_70169_q = this.field_70165_t;
/* 286 */     this.field_70167_r = this.field_70163_u;
/* 287 */     this.field_70166_s = this.field_70161_v;
/* 288 */     byte b0 = 5;
/* 289 */     double d0 = 0.0D;
/*     */     
/* 291 */     for (int i = 0; i < b0; i++) {
/*     */       
/* 293 */       double d1 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (i + 0) / b0 - 0.125D;
/* 294 */       double d2 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (i + 1) / b0 - 0.125D;
/* 295 */       AxisAlignedBB axisAlignedBB = AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, d1, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d2, this.field_70121_D.field_72334_f);
/*     */     } 
/*     */     
/* 298 */     double d3 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */ 
/*     */ 
/*     */     
/* 302 */     if (d3 > 0.26249999999999996D) {
/*     */       
/* 304 */       double d4 = Math.cos(this.field_70177_z * Math.PI / 180.0D);
/* 305 */       double d5 = Math.sin(this.field_70177_z * Math.PI / 180.0D);
/*     */       
/* 307 */       for (int j = 0; j < 1.0D + d3 * 60.0D; j++) {
/*     */         
/* 309 */         double d6 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
/* 310 */         double d1 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7D;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     if (this.field_70170_p.field_72995_K && this.field_70279_a) {
/*     */       
/* 321 */       if (this.boatPosRotationIncrements > 0)
/*     */       {
/* 323 */         double d4 = this.field_70165_t + (this.boatX - this.field_70165_t) / this.boatPosRotationIncrements;
/* 324 */         double d5 = this.field_70163_u + (this.boatY - this.field_70163_u) / this.boatPosRotationIncrements;
/* 325 */         double d11 = this.field_70161_v + (this.boatZ - this.field_70161_v) / this.boatPosRotationIncrements;
/* 326 */         double d10 = MathHelper.func_76138_g(this.boatYaw - this.field_70177_z);
/* 327 */         this.field_70177_z = (float)(this.field_70177_z + d10 / this.boatPosRotationIncrements);
/* 328 */         this.field_70125_A = (float)(this.field_70125_A + (this.boatPitch - this.field_70125_A) / this.boatPosRotationIncrements);
/* 329 */         this.boatPosRotationIncrements--;
/* 330 */         func_70107_b(d4, d5, d11);
/* 331 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       }
/*     */       else
/*     */       {
/* 335 */         double d4 = this.field_70165_t + this.field_70159_w;
/* 336 */         double d5 = this.field_70163_u + this.field_70181_x;
/* 337 */         double d11 = this.field_70161_v + this.field_70179_y;
/* 338 */         func_70107_b(d4, d5, d11);
/*     */         
/* 340 */         this.field_70159_w *= 0.9900000095367432D;
/* 341 */         this.field_70181_x *= 0.949999988079071D;
/* 342 */         this.field_70179_y *= 0.9900000095367432D;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 347 */       double S = 0.0D;
/* 348 */       if (this.field_70153_n != null) {
/*     */         
/* 350 */         if (this.field_70153_n instanceof EntityPlayer) {
/*     */           
/* 352 */           NBTTagCompound tag = JRMCoreH.nbt(this.field_70153_n, "");
/*     */           
/* 354 */           if (tag.func_74762_e("DBCdriF") == 1) { S = 0.55D; this.dS += this.T; tag.func_74768_a("DBCdriF", 0); }
/* 355 */           else if (tag.func_74762_e("DBCdriF") == 2) { S = -0.55D; this.dS -= this.T; tag.func_74768_a("DBCdriF", 0); }
/* 356 */           else { S = 0.0D; tag.func_74768_a("DBCdriF", 0); }
/*     */           
/* 358 */           if (tag.func_74762_e("DBCdriY") == 3) { this.field_70181_x += 0.5D; if (this.field_70181_x > 0.5D) this.field_70181_x = 0.5D;  tag.func_74768_a("DBCdriY", 0); }
/* 359 */           else if (tag.func_74762_e("DBCdriY") == 4) { if (this.field_70170_p.func_147439_a((int)this.field_70165_t + 0, (int)this.field_70163_u - 2, (int)this.field_70161_v + 0).func_149688_o() == Material.field_151579_a) { this.field_70181_x -= 0.5D; if (this.field_70181_x < -0.5D) this.field_70181_x = -0.5D;  tag.func_74768_a("DBCdriY", 0); }  }
/* 360 */           else { this.field_70181_x = 0.0D; tag.func_74768_a("DBCdriY", 0); }
/*     */           
/* 362 */           if (tag.func_74762_e("DBCdriS") == 5) { this.field_70177_z -= 4.0F; tag.func_74768_a("DBCdriS", 0); }
/* 363 */           else if (tag.func_74762_e("DBCdriS") == 6) { this.field_70177_z += 4.0F; tag.func_74768_a("DBCdriS", 0); }
/* 364 */           else { tag.func_74768_a("DBCdriS", 0); }
/*     */         
/* 366 */         }  if (this.dS > 0.5F) this.dS = 0.5F; 
/* 367 */         if (this.dS < -0.5F) this.dS = -0.5F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 374 */         double e = Math.cos(this.field_70177_z * Math.PI / 180.0D) * S;
/* 375 */         double r = Math.sin(this.field_70177_z * Math.PI / 180.0D) * -S;
/* 376 */         this.field_70179_y = e;
/* 377 */         this.field_70159_w = r;
/*     */         
/* 379 */         this.dropcounter = 0;
/*     */         
/* 381 */         this.field_70153_n.field_70143_R = 0.0F;
/* 382 */         this.field_70143_R = 0.0F;
/* 383 */         if (this.field_70154_o != null) this.field_70154_o.field_70143_R = 0.0F; 
/* 384 */         this.field_70153_n.field_70122_E = false;
/*     */         
/* 386 */         int al = JRMCoreH.getByte((EntityPlayer)this.field_70153_n, "jrmcAlign");
/*     */ 
/*     */         
/* 389 */         if (al < 65) {
/* 390 */           this.field_70153_n.func_70078_a(null);
/* 391 */           func_70078_a(null);
/* 392 */           this.field_70153_n = null;
/*     */         } 
/*     */       } else {
/*     */         
/* 396 */         this.dropcounter++;
/* 397 */         if (this.dropcounter == 100) {
/* 398 */           this.dropcounter = 0;
/* 399 */           func_145778_a(ItemsDBC.KintounItem, 1, 0.0F);
/*     */           
/* 401 */           func_70106_y();
/*     */         } 
/* 403 */         S = 0.0D; this.dS = 0.0F;
/*     */       } 
/* 405 */       this.field_70143_R = 0.0F;
/*     */       
/* 407 */       if (this.field_70153_n == null) {
/*     */         
/* 409 */         this.field_70159_w *= 0.3900000095367432D;
/*     */         
/* 411 */         this.field_70179_y *= 0.3900000095367432D;
/*     */       } 
/*     */       
/* 414 */       func_70091_d(this.field_70159_w * DBCConfig.cnfFlnmb, this.field_70181_x * DBCConfig.cnfFlnmb, this.field_70179_y * DBCConfig.cnfFlnmb);
/*     */       
/* 416 */       if (this.field_70123_F && d3 > 0.2D) {
/*     */         
/* 418 */         if (!this.field_70170_p.field_72995_K && !this.field_70128_L)
/*     */         {
/* 420 */           func_70106_y();
/*     */           
/* 422 */           func_145778_a(ItemsDBC.KintounItem, 1, 0.0F);
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 427 */       else if (this.field_70153_n != null) {
/*     */         
/* 429 */         this.field_70159_w *= 0.3900000095367432D;
/* 430 */         this.field_70181_x *= 0.349999988079071D;
/* 431 */         this.field_70179_y *= 0.3900000095367432D;
/*     */       } 
/*     */ 
/*     */       
/* 435 */       this.field_70125_A = 0.0F;
/* 436 */       double d5 = this.field_70177_z;
/* 437 */       double d11 = this.field_70169_q - this.field_70165_t;
/* 438 */       double d10 = this.field_70166_s - this.field_70161_v;
/*     */       
/* 440 */       if (d11 * d11 + d10 * d10 > 0.001D)
/*     */       {
/* 442 */         d5 = (float)(Math.atan2(d10, d11) * 180.0D / Math.PI);
/*     */       }
/*     */       
/* 445 */       double d12 = MathHelper.func_76138_g(d5 - this.field_70177_z);
/*     */       
/* 447 */       if (d12 > 20.0D)
/*     */       {
/* 449 */         d12 = 20.0D;
/*     */       }
/*     */       
/* 452 */       if (d12 < -20.0D)
/*     */       {
/* 454 */         d12 = -20.0D;
/*     */       }
/*     */ 
/*     */       
/* 458 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       
/* 460 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 462 */         List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
/*     */ 
/*     */         
/* 465 */         if (list != null && !list.isEmpty())
/*     */         {
/* 467 */           for (int j = 0; j < list.size(); j++) {
/*     */             
/* 469 */             Entity entity = list.get(j);
/*     */             
/* 471 */             if (entity != this.field_70153_n && entity.func_70104_M() && entity instanceof KintounEntity) {
/*     */ 
/*     */               
/* 474 */               this.field_70159_w = 0.0D;
/* 475 */               this.field_70181_x = 0.0D;
/* 476 */               this.field_70179_y = 0.0D;
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/* 481 */         for (int l = 0; l < 4; l++) {
/*     */           
/* 483 */           int i1 = MathHelper.func_76128_c(this.field_70165_t + ((l % 2) - 0.5D) * 0.8D);
/* 484 */           int j1 = MathHelper.func_76128_c(this.field_70161_v + ((l / 2) - 0.5D) * 0.8D);
/*     */           
/* 486 */           for (int k1 = 0; k1 < 2; k1++) {
/*     */             
/* 488 */             int l1 = MathHelper.func_76128_c(this.field_70163_u) + k1;
/* 489 */             Block i2 = this.field_70170_p.func_147439_a(i1, l1, j1);
/*     */             
/* 491 */             if (i2 == Blocks.field_150433_aE) {
/*     */               
/* 493 */               this.field_70170_p.func_147468_f(i1, l1, j1);
/*     */             }
/* 495 */             else if (i2 == Blocks.field_150392_bi) {
/*     */               
/* 497 */               this.field_70170_p.func_147443_d(i1, l1, j1, 0, 0);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 502 */         if (this.field_70153_n != null && this.field_70153_n.field_70128_L)
/*     */         {
/* 504 */           this.field_70153_n = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70043_V() {
/* 512 */     if (this.field_70153_n != null) {
/*     */       
/* 514 */       double d0 = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.4D;
/* 515 */       double d1 = Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.4D;
/* 516 */       this.field_70153_n.func_70107_b(this.field_70165_t + d0, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + d1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {}
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 533 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer par1EntityPlayer) {
/* 543 */     return interact(par1EntityPlayer);
/*     */   }
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 546 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != par1EntityPlayer)
/*     */     {
/* 548 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 552 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 554 */       par1EntityPlayer.func_70078_a(this);
/*     */     }
/*     */     
/* 557 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDamageTaken(float par1) {
/* 566 */     this.field_70180_af.func_75692_b(19, Float.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDamageTaken() {
/* 574 */     return this.field_70180_af.func_111145_d(19);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeSinceHit(int par1) {
/* 582 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTimeSinceHit() {
/* 590 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForwardDirection(int par1) {
/* 598 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getForwardDirection() {
/* 606 */     return this.field_70180_af.func_75679_c(18);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70270_d(boolean par1) {
/* 612 */     this.field_70279_a = par1;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\KintounEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */