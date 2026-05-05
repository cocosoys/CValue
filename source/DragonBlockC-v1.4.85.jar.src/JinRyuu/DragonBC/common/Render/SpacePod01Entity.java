/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPdri;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class SpacePod01Entity extends Entity {
/*     */   private boolean field_70279_a;
/*     */   private double speedMultiplier;
/*     */   private int boatPosRotationIncrements;
/*     */   
/*     */   public boolean shouldRenderInPass(int pass) {
/*  29 */     return (pass == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private double boatX;
/*     */   
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
/*     */   private float dS;
/*  47 */   private float T = 0.05F;
/*  48 */   private int emptyCounter = 0;
/*     */ 
/*     */   
/*     */   public SpacePod01Entity(World par1World) {
/*  52 */     super(par1World);
/*  53 */     this.field_70279_a = true;
/*  54 */     this.speedMultiplier = 0.07D;
/*  55 */     this.field_70156_m = true;
/*     */     
/*  57 */     func_70105_a(1.5F, 1.5F);
/*  58 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  72 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  73 */     this.field_70180_af.func_75682_a(18, new Integer(1));
/*  74 */     this.field_70180_af.func_75682_a(19, new Float(0.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  83 */     return par1Entity.field_70121_D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  91 */     return this.field_70121_D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpacePod01Entity(World par1World, double par2, double par4, double par6) {
/* 104 */     this(par1World);
/* 105 */     func_70107_b(par2, par4 + this.field_70129_M, par6);
/* 106 */     this.field_70159_w = 0.0D;
/* 107 */     this.field_70181_x = 0.0D;
/* 108 */     this.field_70179_y = 0.0D;
/* 109 */     this.field_70169_q = par2;
/* 110 */     this.field_70167_r = par4;
/* 111 */     this.field_70166_s = par6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double func_70042_X() {
/* 119 */     return this.field_70131_O * 0.0D - 0.30000001192092896D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 127 */     if (func_85032_ar())
/*     */     {
/* 129 */       return false;
/*     */     }
/* 131 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/*     */ 
/*     */       
/* 134 */       setTimeSinceHit(10);
/* 135 */       setDamageTaken(getDamageTaken() + par2 * 10.0F);
/* 136 */       func_70018_K();
/* 137 */       boolean flag = (par1DamageSource.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)par1DamageSource.func_76346_g()).field_71075_bZ.field_75098_d);
/*     */       
/* 139 */       if (flag || getDamageTaken() > 40.0F) {
/*     */         
/* 141 */         if (this.field_70153_n != null)
/*     */         {
/* 143 */           this.field_70153_n.func_70078_a(this);
/*     */         }
/* 145 */         func_145778_a(ItemsDBC.SpacePod01Item, 1, 0.0F);
/*     */ 
/*     */         
/* 148 */         if (!flag);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 153 */         func_70106_y();
/*     */       } 
/*     */       
/* 156 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 160 */     return true;
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
/* 172 */     setTimeSinceHit(10);
/* 173 */     setDamageTaken(getDamageTaken() * 11.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 181 */     return !this.field_70128_L;
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
/* 192 */     if (this.field_70279_a) {
/*     */       
/* 194 */       this.boatPosRotationIncrements = par9 + 5;
/*     */     }
/*     */     else {
/*     */       
/* 198 */       double d3 = par1 - this.field_70165_t;
/* 199 */       double d4 = par3 - this.field_70163_u;
/* 200 */       double d5 = par5 - this.field_70161_v;
/* 201 */       double d6 = d3 * d3 + d4 * d4 + d5 * d5;
/*     */       
/* 203 */       if (d6 <= 1.0D) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 208 */       this.boatPosRotationIncrements = 3;
/*     */     } 
/*     */     
/* 211 */     this.boatX = par1;
/* 212 */     this.boatY = par3;
/* 213 */     this.boatZ = par5;
/* 214 */     this.boatYaw = par7;
/* 215 */     this.boatPitch = par8;
/* 216 */     this.field_70159_w = this.velocityX;
/* 217 */     this.field_70181_x = this.velocityY;
/* 218 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 228 */     this.velocityX = this.field_70159_w = par1;
/* 229 */     this.velocityY = this.field_70181_x = par3;
/* 230 */     this.velocityZ = this.field_70179_y = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 238 */     if (!this.field_70170_p.field_72995_K && this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer) {
/*     */       
/* 240 */       NBTTagCompound tag = JRMCoreH.nbt(this.field_70153_n, "pres");
/* 241 */       boolean isKOd = (tag.func_74762_e("jrmcHar4va") > 0);
/* 242 */       if (isKOd)
/*     */       {
/* 244 */         this.field_70153_n.func_70078_a(null);
/*     */       }
/*     */     } 
/*     */     
/* 248 */     super.func_70071_h_();
/*     */     
/* 250 */     if (getTimeSinceHit() > 0)
/*     */     {
/* 252 */       setTimeSinceHit(getTimeSinceHit() - 1);
/*     */     }
/*     */     
/* 255 */     if (getDamageTaken() > 0.0F)
/*     */     {
/* 257 */       setDamageTaken(getDamageTaken() - 1.0F);
/*     */     }
/*     */     
/* 260 */     this.field_70169_q = this.field_70165_t;
/* 261 */     this.field_70167_r = this.field_70163_u;
/* 262 */     this.field_70166_s = this.field_70161_v;
/* 263 */     byte b0 = 5;
/* 264 */     double d0 = 0.0D;
/*     */     
/* 266 */     for (int i = 0; i < b0; i++) {
/*     */       
/* 268 */       double d1 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (i + 0) / b0 - 0.125D;
/* 269 */       double d2 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (i + 1) / b0 - 0.125D;
/* 270 */       AxisAlignedBB axisAlignedBB = AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, d1, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d2, this.field_70121_D.field_72334_f);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     double d3 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */ 
/*     */ 
/*     */     
/* 282 */     if (d3 > 0.26249999999999996D) {
/*     */       
/* 284 */       double d4 = Math.cos(this.field_70177_z * Math.PI / 180.0D);
/* 285 */       double d5 = Math.sin(this.field_70177_z * Math.PI / 180.0D);
/*     */       
/* 287 */       for (int j = 0; j < 1.0D + d3 * 60.0D; j++) {
/*     */         
/* 289 */         double d6 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
/* 290 */         double d1 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7D;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     if (this.field_70170_p.field_72995_K && this.field_70279_a) {
/*     */       
/* 301 */       if (this.boatPosRotationIncrements > 0)
/*     */       {
/* 303 */         double d4 = this.field_70165_t + (this.boatX - this.field_70165_t) / this.boatPosRotationIncrements;
/* 304 */         double d5 = this.field_70163_u + (this.boatY - this.field_70163_u) / this.boatPosRotationIncrements;
/* 305 */         double d11 = this.field_70161_v + (this.boatZ - this.field_70161_v) / this.boatPosRotationIncrements;
/* 306 */         double d10 = MathHelper.func_76138_g(this.boatYaw - this.field_70177_z);
/* 307 */         this.field_70177_z = (float)(this.field_70177_z + d10 / this.boatPosRotationIncrements);
/* 308 */         this.field_70125_A = (float)(this.field_70125_A + (this.boatPitch - this.field_70125_A) / this.boatPosRotationIncrements);
/* 309 */         this.boatPosRotationIncrements--;
/* 310 */         func_70107_b(d4, d5, d11);
/* 311 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       }
/*     */       else
/*     */       {
/* 315 */         double d4 = this.field_70165_t + this.field_70159_w;
/* 316 */         double d5 = this.field_70163_u + this.field_70181_x;
/* 317 */         double d11 = this.field_70161_v + this.field_70179_y;
/* 318 */         func_70107_b(d4, d5, d11);
/*     */         
/* 320 */         this.field_70159_w *= 0.9900000095367432D;
/* 321 */         this.field_70181_x *= 0.949999988079071D;
/* 322 */         this.field_70179_y *= 0.9900000095367432D;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 327 */       double S = 0.0D;
/* 328 */       if (this.field_70153_n != null) {
/*     */         
/* 330 */         if (this.field_70153_n instanceof EntityPlayer) {
/* 331 */           NBTTagCompound tag = JRMCoreH.nbt(this.field_70153_n, "");
/*     */           
/* 333 */           if (tag.func_74762_e("DBCdriF") == 1) { S = 0.55D; this.dS += this.T; tag.func_74768_a("DBCdriF", 0); }
/* 334 */           else if (tag.func_74762_e("DBCdriF") == 2) { S = -0.55D; this.dS -= this.T; tag.func_74768_a("DBCdriF", 0); }
/* 335 */           else { S = 0.0D; tag.func_74768_a("DBCdriF", 0); }
/*     */           
/* 337 */           if (tag.func_74762_e("DBCdriY") == 3) { this.field_70181_x += 0.5D; if (this.field_70181_x > 0.5D) this.field_70181_x = 0.5D;  tag.func_74768_a("DBCdriY", 0); }
/* 338 */           else if (tag.func_74762_e("DBCdriY") == 4) { if (this.field_70170_p.func_147439_a((int)this.field_70165_t + 0, (int)this.field_70163_u - 2, (int)this.field_70161_v + 0).func_149688_o() == Material.field_151579_a) { this.field_70181_x -= 0.5D; if (this.field_70181_x < -0.5D) this.field_70181_x = -0.5D;  tag.func_74768_a("DBCdriY", 0); }  }
/* 339 */           else { this.field_70181_x = 0.0D; tag.func_74768_a("DBCdriY", 0); }
/*     */           
/* 341 */           if (tag.func_74762_e("DBCdriS") == 5) { this.field_70177_z -= 4.0F; tag.func_74768_a("DBCdriS", 0); }
/* 342 */           else if (tag.func_74762_e("DBCdriS") == 6) { this.field_70177_z += 4.0F; tag.func_74768_a("DBCdriS", 0); }
/* 343 */           else { tag.func_74768_a("DBCdriS", 0); }
/*     */         
/* 345 */         }  if (this.dS > 0.5F) this.dS = 0.5F; 
/* 346 */         if (this.dS < -0.5F) this.dS = -0.5F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 355 */         double e = Math.cos(this.field_70177_z * Math.PI / 180.0D) * S;
/* 356 */         double r = Math.sin(this.field_70177_z * Math.PI / 180.0D) * -S;
/*     */ 
/*     */         
/* 359 */         this.field_70179_y = e;
/* 360 */         this.field_70159_w = r;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 366 */         this.field_70153_n.field_70143_R = 0.0F;
/* 367 */         this.field_70143_R = 0.0F;
/* 368 */         if (this.field_70154_o != null) this.field_70154_o.field_70143_R = 0.0F; 
/* 369 */         this.field_70153_n.field_70122_E = false;
/* 370 */         dri(10);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 375 */         S = 0.0D; this.dS = 0.0F;
/* 376 */       }  this.field_70143_R = 0.0F;
/*     */ 
/*     */ 
/*     */       
/* 380 */       if (this.field_70153_n == null) {
/*     */         
/* 382 */         this.field_70159_w *= 0.3900000095367432D;
/*     */         
/* 384 */         this.field_70179_y *= 0.3900000095367432D;
/*     */         
/* 386 */         if (DBCConfig.spdc > 0) {
/* 387 */           this.emptyCounter++;
/* 388 */           if (this.emptyCounter == 20 * DBCConfig.spdc) {
/* 389 */             func_145778_a(ItemsDBC.SpacePod01Item, 1, 0.0F);
/* 390 */             func_70106_y();
/*     */           } 
/*     */         } 
/*     */       } else {
/* 394 */         this.emptyCounter = 0;
/*     */       } 
/*     */       
/* 397 */       func_70091_d(this.field_70159_w * DBCConfig.cnfSpc, this.field_70181_x * DBCConfig.cnfSpc, this.field_70179_y * DBCConfig.cnfSpc);
/*     */       
/* 399 */       if (this.field_70123_F && d3 > 0.2D) {
/*     */         
/* 401 */         if (!this.field_70170_p.field_72995_K && !this.field_70128_L)
/*     */         {
/* 403 */           func_70106_y();
/*     */           
/* 405 */           func_145778_a(ItemsDBC.SpacePod01Item, 1, 0.0F);
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 410 */       else if (this.field_70153_n != null) {
/*     */         
/* 412 */         this.field_70159_w *= 0.3900000095367432D;
/* 413 */         this.field_70181_x *= 0.349999988079071D;
/* 414 */         this.field_70179_y *= 0.3900000095367432D;
/*     */       } 
/*     */ 
/*     */       
/* 418 */       this.field_70125_A = 0.0F;
/* 419 */       double d5 = this.field_70177_z;
/* 420 */       double d11 = this.field_70169_q - this.field_70165_t;
/* 421 */       double d10 = this.field_70166_s - this.field_70161_v;
/*     */       
/* 423 */       if (d11 * d11 + d10 * d10 > 0.001D)
/*     */       {
/* 425 */         d5 = (float)(Math.atan2(d10, d11) * 180.0D / Math.PI);
/*     */       }
/*     */       
/* 428 */       double d12 = MathHelper.func_76138_g(d5 - this.field_70177_z);
/*     */       
/* 430 */       if (d12 > 20.0D)
/*     */       {
/* 432 */         d12 = 20.0D;
/*     */       }
/*     */       
/* 435 */       if (d12 < -20.0D)
/*     */       {
/* 437 */         d12 = -20.0D;
/*     */       }
/*     */ 
/*     */       
/* 441 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       
/* 443 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 445 */         List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
/*     */ 
/*     */         
/* 448 */         if (list != null && !list.isEmpty())
/*     */         {
/* 450 */           for (int j = 0; j < list.size(); j++) {
/*     */             
/* 452 */             Entity entity = list.get(j);
/*     */             
/* 454 */             if (entity != this.field_70153_n && entity.func_70104_M() && entity instanceof SpacePod01Entity) {
/*     */ 
/*     */               
/* 457 */               this.field_70159_w = 0.0D;
/* 458 */               this.field_70181_x = 0.0D;
/* 459 */               this.field_70179_y = 0.0D;
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/* 464 */         for (int l = 0; l < 4; l++) {
/*     */           
/* 466 */           int i1 = MathHelper.func_76128_c(this.field_70165_t + ((l % 2) - 0.5D) * 0.8D);
/* 467 */           int j1 = MathHelper.func_76128_c(this.field_70161_v + ((l / 2) - 0.5D) * 0.8D);
/*     */           
/* 469 */           for (int k1 = 0; k1 < 2; k1++) {
/*     */             
/* 471 */             int l1 = MathHelper.func_76128_c(this.field_70163_u) + k1;
/* 472 */             Block i2 = this.field_70170_p.func_147439_a(i1, l1, j1);
/*     */             
/* 474 */             if (i2 == Blocks.field_150433_aE) {
/*     */               
/* 476 */               this.field_70170_p.func_147468_f(i1, l1, j1);
/*     */             }
/* 478 */             else if (i2 == Blocks.field_150392_bi) {
/*     */               
/* 480 */               this.field_70170_p.func_147443_d(i1, l1, j1, 0, 0);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 485 */         if (this.field_70153_n != null && this.field_70153_n.field_70128_L)
/*     */         {
/* 487 */           this.field_70153_n = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70043_V() {
/* 495 */     if (this.field_70153_n != null) {
/*     */       
/* 497 */       double d0 = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.4D;
/* 498 */       double d1 = Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.4D;
/* 499 */       this.field_70153_n.func_70107_b(this.field_70165_t + d0, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + d1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dri(int a) {
/* 505 */     float s = (this.field_70153_n != null) ? this.dS : 0.0F;
/* 506 */     PD.sendTo((IMessage)new DBCPdri((int)(s * 10.0F)), (EntityPlayerMP)this.field_70153_n);
/*     */   }
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
/* 521 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer par1EntityPlayer) {
/* 531 */     return interact(par1EntityPlayer);
/*     */   }
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 534 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != par1EntityPlayer)
/*     */     {
/* 536 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 540 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 542 */       par1EntityPlayer.func_70078_a(this);
/*     */     }
/*     */     
/* 545 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDamageTaken(float par1) {
/* 554 */     this.field_70180_af.func_75692_b(19, Float.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDamageTaken() {
/* 562 */     return this.field_70180_af.func_111145_d(19);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimeSinceHit(int par1) {
/* 570 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTimeSinceHit() {
/* 578 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForwardDirection(int par1) {
/* 586 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getForwardDirection() {
/* 594 */     return this.field_70180_af.func_75679_c(18);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70270_d(boolean par1) {
/* 600 */     this.field_70279_a = par1;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SpacePod01Entity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */