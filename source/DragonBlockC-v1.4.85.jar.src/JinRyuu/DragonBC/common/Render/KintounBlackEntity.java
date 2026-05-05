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
/*     */ public class KintounBlackEntity
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
/*     */   public KintounBlackEntity(World par1World) {
/*  45 */     super(par1World);
/*  46 */     this.field_70279_a = true;
/*  47 */     this.speedMultiplier = 0.08D;
/*  48 */     this.field_70156_m = true;
/*     */     
/*  50 */     func_70105_a(1.5F, 1.5F);
/*  51 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  52 */     setCloudColor(3355443);
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
/*  64 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  69 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  70 */     this.field_70180_af.func_75682_a(18, new Integer(1));
/*  71 */     this.field_70180_af.func_75682_a(19, new Float(0.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  80 */     return par1Entity.field_70121_D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  88 */     return this.field_70121_D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public KintounBlackEntity(World par1World, double par2, double par4, double par6) {
/* 101 */     this(par1World);
/* 102 */     func_70107_b(par2, par4 + this.field_70129_M, par6);
/* 103 */     this.field_70159_w = 0.0D;
/* 104 */     this.field_70181_x = 0.0D;
/* 105 */     this.field_70179_y = 0.0D;
/* 106 */     this.field_70169_q = par2;
/* 107 */     this.field_70167_r = par4;
/* 108 */     this.field_70166_s = par6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double func_70042_X() {
/* 116 */     return this.field_70131_O * 0.0D - 0.30000001192092896D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 124 */     if (func_85032_ar())
/*     */     {
/* 126 */       return false;
/*     */     }
/* 128 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/*     */ 
/*     */       
/* 131 */       setTimeSinceHit(10);
/* 132 */       setDamageTaken(getDamageTaken() + par2 * 10.0F);
/* 133 */       func_70018_K();
/* 134 */       boolean flag = (par1DamageSource.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)par1DamageSource.func_76346_g()).field_71075_bZ.field_75098_d);
/*     */       
/* 136 */       if (flag || getDamageTaken() > 1.0F) {
/*     */         
/* 138 */         if (this.field_70153_n != null)
/*     */         {
/* 140 */           this.field_70153_n.func_70078_a(this);
/*     */         }
/* 142 */         func_145778_a(ItemsDBC.KintounBlackItem, 1, 0.0F);
/*     */         
/* 144 */         if (!flag);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 149 */         func_70106_y();
/*     */       } 
/*     */       
/* 152 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 156 */     return true;
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
/* 168 */     setTimeSinceHit(10);
/* 169 */     setDamageTaken(getDamageTaken() * 11.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 177 */     return !this.field_70128_L;
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
/* 188 */     if (this.field_70279_a) {
/*     */       
/* 190 */       this.boatPosRotationIncrements = par9 + 5;
/*     */     }
/*     */     else {
/*     */       
/* 194 */       double d3 = par1 - this.field_70165_t;
/* 195 */       double d4 = par3 - this.field_70163_u;
/* 196 */       double d5 = par5 - this.field_70161_v;
/* 197 */       double d6 = d3 * d3 + d4 * d4 + d5 * d5;
/*     */       
/* 199 */       if (d6 <= 1.0D) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 204 */       this.boatPosRotationIncrements = 3;
/*     */     } 
/*     */     
/* 207 */     this.boatX = par1;
/* 208 */     this.boatY = par3;
/* 209 */     this.boatZ = par5;
/* 210 */     this.boatYaw = par7;
/* 211 */     this.boatPitch = par8;
/* 212 */     this.field_70159_w = this.velocityX;
/* 213 */     this.field_70181_x = this.velocityY;
/* 214 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 224 */     this.velocityX = this.field_70159_w = par1;
/* 225 */     this.velocityY = this.field_70181_x = par3;
/* 226 */     this.velocityZ = this.field_70179_y = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 234 */     super.func_70071_h_();
/*     */ 
/*     */     
/* 237 */     if (this.field_70170_p.field_72995_K && 
/* 238 */       JGConfigClientSettings.CLIENT_DA11) {
/* 239 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/* 240 */         if (this.field_70159_w != 0.0D || this.field_70179_y != 0.0D) {
/*     */           
/* 242 */           Entity pl = this;
/*     */           
/* 244 */           double x = 0.0D;
/* 245 */           double y = -1.2000000476837158D;
/* 246 */           double z = 0.0D;
/* 247 */           EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.0D, 0.0D, 0.0F, 10, 11, 1, 32, false, 0.0F, false, 0.0F, 1, "", 15, 2, 0.05F, 0.001F, -0.0045F, 0, 27.0F, 66.0F, 142.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3, 1.0F, 0.0F, 0.0F, 0.0F, -0.001F, false, -1, false, null);
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
/* 259 */           ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     if (getTimeSinceHit() > 0)
/*     */     {
/* 269 */       setTimeSinceHit(getTimeSinceHit() - 1);
/*     */     }
/*     */     
/* 272 */     if (getDamageTaken() > 0.0F)
/*     */     {
/* 274 */       setDamageTaken(getDamageTaken() - 1.0F);
/*     */     }
/*     */     
/* 277 */     this.field_70169_q = this.field_70165_t;
/* 278 */     this.field_70167_r = this.field_70163_u;
/* 279 */     this.field_70166_s = this.field_70161_v;
/* 280 */     byte b0 = 5;
/* 281 */     double d0 = 0.0D;
/*     */     
/* 283 */     for (int i = 0; i < b0; i++) {
/*     */       
/* 285 */       double d1 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (i + 0) / b0 - 0.125D;
/* 286 */       double d2 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (i + 1) / b0 - 0.125D;
/* 287 */       AxisAlignedBB axisAlignedBB = AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, d1, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d2, this.field_70121_D.field_72334_f);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     double d3 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */ 
/*     */ 
/*     */     
/* 299 */     if (d3 > 0.26249999999999996D) {
/*     */       
/* 301 */       double d4 = Math.cos(this.field_70177_z * Math.PI / 180.0D);
/* 302 */       double d5 = Math.sin(this.field_70177_z * Math.PI / 180.0D);
/*     */       
/* 304 */       for (int j = 0; j < 1.0D + d3 * 60.0D; j++) {
/*     */         
/* 306 */         double d6 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
/* 307 */         double d1 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7D;
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
/*     */ 
/*     */     
/* 329 */     if (this.field_70170_p.field_72995_K && this.field_70279_a) {
/*     */       
/* 331 */       if (this.boatPosRotationIncrements > 0)
/*     */       {
/* 333 */         double d4 = this.field_70165_t + (this.boatX - this.field_70165_t) / this.boatPosRotationIncrements;
/* 334 */         double d5 = this.field_70163_u + (this.boatY - this.field_70163_u) / this.boatPosRotationIncrements;
/* 335 */         double d11 = this.field_70161_v + (this.boatZ - this.field_70161_v) / this.boatPosRotationIncrements;
/* 336 */         double d10 = MathHelper.func_76138_g(this.boatYaw - this.field_70177_z);
/* 337 */         this.field_70177_z = (float)(this.field_70177_z + d10 / this.boatPosRotationIncrements);
/* 338 */         this.field_70125_A = (float)(this.field_70125_A + (this.boatPitch - this.field_70125_A) / this.boatPosRotationIncrements);
/* 339 */         this.boatPosRotationIncrements--;
/* 340 */         func_70107_b(d4, d5, d11);
/* 341 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       }
/*     */       else
/*     */       {
/* 345 */         double d4 = this.field_70165_t + this.field_70159_w;
/* 346 */         double d5 = this.field_70163_u + this.field_70181_x;
/* 347 */         double d11 = this.field_70161_v + this.field_70179_y;
/* 348 */         func_70107_b(d4, d5, d11);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 357 */         this.field_70159_w *= 0.9900000095367432D;
/* 358 */         this.field_70181_x *= 0.949999988079071D;
/* 359 */         this.field_70179_y *= 0.9900000095367432D;
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
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 379 */       double S = 0.0D;
/* 380 */       if (this.field_70153_n != null) {
/*     */         
/* 382 */         if (this.field_70153_n instanceof EntityPlayer) {
/* 383 */           NBTTagCompound tag = JRMCoreH.nbt(this.field_70153_n, "");
/*     */           
/* 385 */           if (tag.func_74762_e("DBCdriF") == 1) { S = 0.55D; this.dS += this.T; tag.func_74768_a("DBCdriF", 0); }
/* 386 */           else if (tag.func_74762_e("DBCdriF") == 2) { S = -0.55D; this.dS -= this.T; tag.func_74768_a("DBCdriF", 0); }
/* 387 */           else { S = 0.0D; tag.func_74768_a("DBCdriF", 0); }
/*     */           
/* 389 */           if (tag.func_74762_e("DBCdriY") == 3) { this.field_70181_x += 0.5D; if (this.field_70181_x > 0.5D) this.field_70181_x = 0.5D;  tag.func_74768_a("DBCdriY", 0); }
/* 390 */           else if (tag.func_74762_e("DBCdriY") == 4) { if (this.field_70170_p.func_147439_a((int)this.field_70165_t + 0, (int)this.field_70163_u - 2, (int)this.field_70161_v + 0).func_149688_o() == Material.field_151579_a) { this.field_70181_x -= 0.5D; if (this.field_70181_x < -0.5D) this.field_70181_x = -0.5D;  tag.func_74768_a("DBCdriY", 0); }  }
/* 391 */           else { this.field_70181_x = 0.0D; tag.func_74768_a("DBCdriY", 0); }
/*     */           
/* 393 */           if (tag.func_74762_e("DBCdriS") == 5) { this.field_70177_z -= 4.0F; tag.func_74768_a("DBCdriS", 0); }
/* 394 */           else if (tag.func_74762_e("DBCdriS") == 6) { this.field_70177_z += 4.0F; tag.func_74768_a("DBCdriS", 0); }
/* 395 */           else { tag.func_74768_a("DBCdriS", 0); }
/*     */         
/* 397 */         }  if (this.dS > 0.5F) this.dS = 0.5F; 
/* 398 */         if (this.dS < -0.5F) this.dS = -0.5F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 405 */         double e = Math.cos(this.field_70177_z * Math.PI / 180.0D) * S;
/* 406 */         double r = Math.sin(this.field_70177_z * Math.PI / 180.0D) * -S;
/* 407 */         this.field_70179_y = e;
/* 408 */         this.field_70159_w = r;
/*     */         
/* 410 */         this.dropcounter = 0;
/*     */         
/* 412 */         this.field_70153_n.field_70143_R = 0.0F;
/* 413 */         this.field_70143_R = 0.0F;
/* 414 */         if (this.field_70154_o != null) this.field_70154_o.field_70143_R = 0.0F; 
/* 415 */         this.field_70153_n.field_70122_E = false;
/*     */         
/* 417 */         int al = JRMCoreH.getByte((EntityPlayer)this.field_70153_n, "jrmcAlign");
/*     */ 
/*     */         
/* 420 */         if (al > 66) {
/* 421 */           this.field_70153_n.func_70078_a(null);
/* 422 */           func_70078_a(null);
/* 423 */           this.field_70153_n = null;
/*     */         } 
/*     */       } else {
/*     */         
/* 427 */         this.dropcounter++;
/* 428 */         if (this.dropcounter == 100) {
/* 429 */           this.dropcounter = 0;
/* 430 */           func_145778_a(ItemsDBC.KintounBlackItem, 1, 0.0F);
/*     */           
/* 432 */           func_70106_y();
/*     */         } 
/* 434 */         S = 0.0D; this.dS = 0.0F;
/*     */       } 
/* 436 */       this.field_70143_R = 0.0F;
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
/* 475 */       if (this.field_70153_n == null) {
/*     */         
/* 477 */         this.field_70159_w *= 0.3900000095367432D;
/*     */         
/* 479 */         this.field_70179_y *= 0.3900000095367432D;
/*     */       } 
/*     */       
/* 482 */       func_70091_d(this.field_70159_w * DBCConfig.cnfFlnmb, this.field_70181_x * DBCConfig.cnfFlnmb, this.field_70179_y * DBCConfig.cnfFlnmb);
/*     */       
/* 484 */       if (this.field_70123_F && d3 > 0.2D) {
/*     */         
/* 486 */         if (!this.field_70170_p.field_72995_K && !this.field_70128_L)
/*     */         {
/* 488 */           func_70106_y();
/*     */           
/* 490 */           func_145778_a(ItemsDBC.KintounBlackItem, 1, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 505 */       else if (this.field_70153_n != null) {
/*     */         
/* 507 */         this.field_70159_w *= 0.3900000095367432D;
/* 508 */         this.field_70181_x *= 0.349999988079071D;
/* 509 */         this.field_70179_y *= 0.3900000095367432D;
/*     */       } 
/*     */ 
/*     */       
/* 513 */       this.field_70125_A = 0.0F;
/* 514 */       double d5 = this.field_70177_z;
/* 515 */       double d11 = this.field_70169_q - this.field_70165_t;
/* 516 */       double d10 = this.field_70166_s - this.field_70161_v;
/*     */       
/* 518 */       if (d11 * d11 + d10 * d10 > 0.001D)
/*     */       {
/* 520 */         d5 = (float)(Math.atan2(d10, d11) * 180.0D / Math.PI);
/*     */       }
/*     */       
/* 523 */       double d12 = MathHelper.func_76138_g(d5 - this.field_70177_z);
/*     */       
/* 525 */       if (d12 > 20.0D)
/*     */       {
/* 527 */         d12 = 20.0D;
/*     */       }
/*     */       
/* 530 */       if (d12 < -20.0D)
/*     */       {
/* 532 */         d12 = -20.0D;
/*     */       }
/*     */ 
/*     */       
/* 536 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       
/* 538 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 540 */         List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
/*     */ 
/*     */         
/* 543 */         if (list != null && !list.isEmpty())
/*     */         {
/* 545 */           for (int j = 0; j < list.size(); j++) {
/*     */             
/* 547 */             Entity entity = list.get(j);
/*     */             
/* 549 */             if (entity != this.field_70153_n && entity.func_70104_M() && entity instanceof KintounBlackEntity) {
/*     */ 
/*     */               
/* 552 */               this.field_70159_w = 0.0D;
/* 553 */               this.field_70181_x = 0.0D;
/* 554 */               this.field_70179_y = 0.0D;
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/* 559 */         for (int l = 0; l < 4; l++) {
/*     */           
/* 561 */           int i1 = MathHelper.func_76128_c(this.field_70165_t + ((l % 2) - 0.5D) * 0.8D);
/* 562 */           int j1 = MathHelper.func_76128_c(this.field_70161_v + ((l / 2) - 0.5D) * 0.8D);
/*     */           
/* 564 */           for (int k1 = 0; k1 < 2; k1++) {
/*     */             
/* 566 */             int l1 = MathHelper.func_76128_c(this.field_70163_u) + k1;
/* 567 */             Block i2 = this.field_70170_p.func_147439_a(i1, l1, j1);
/*     */             
/* 569 */             if (i2 == Blocks.field_150433_aE) {
/*     */               
/* 571 */               this.field_70170_p.func_147468_f(i1, l1, j1);
/*     */             }
/* 573 */             else if (i2 == Blocks.field_150392_bi) {
/*     */               
/* 575 */               this.field_70170_p.func_147443_d(i1, l1, j1, 0, 0);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 580 */         if (this.field_70153_n != null && this.field_70153_n.field_70128_L)
/*     */         {
/* 582 */           this.field_70153_n = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70043_V() {
/* 590 */     if (this.field_70153_n != null) {
/*     */       
/* 592 */       double d0 = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.4D;
/* 593 */       double d1 = Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.4D;
/* 594 */       this.field_70153_n.func_70107_b(this.field_70165_t + d0, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + d1);
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
/* 611 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer par1EntityPlayer) {
/* 621 */     return interact(par1EntityPlayer);
/*     */   }
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 624 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != par1EntityPlayer)
/*     */     {
/* 626 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 630 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 632 */       par1EntityPlayer.func_70078_a(this);
/*     */     }
/*     */     
/* 635 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDamageTaken(float par1) {
/* 644 */     this.field_70180_af.func_75692_b(19, Float.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDamageTaken() {
/* 652 */     return this.field_70180_af.func_111145_d(19);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeSinceHit(int par1) {
/* 660 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTimeSinceHit() {
/* 668 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForwardDirection(int par1) {
/* 676 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getForwardDirection() {
/* 684 */     return this.field_70180_af.func_75679_c(18);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70270_d(boolean par1) {
/* 690 */     this.field_70279_a = par1;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\KintounBlackEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */