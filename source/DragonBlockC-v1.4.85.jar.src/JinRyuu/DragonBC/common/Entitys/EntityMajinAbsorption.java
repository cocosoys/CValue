/*     */ package JinRyuu.DragonBC.common.Entitys;
/*     */ 
/*     */ import JinRyuu.JRMCore.Ds;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*     */ import JinRyuu.JRMCore.items.ItemVanity;
/*     */ import JinRyuu.JRMCore.server.JGMathHelper;
/*     */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.common.registry.IThrowableEntity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityMajinAbsorption
/*     */   extends Entity
/*     */   implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile
/*     */ {
/*     */   public static final float SOUND = 0.25F;
/*  42 */   public static final HashMap<Class, Boolean> absorptionListResults = new HashMap<Class<?>, Boolean>();
/*     */   
/*     */   public Entity shootingEntity;
/*     */   
/*     */   public Entity target;
/*  47 */   private int xTile = -1;
/*  48 */   private int yTile = -1;
/*  49 */   private int zTile = -1;
/*     */   private Block inTile;
/*  51 */   private int inData = 0;
/*     */   
/*     */   private boolean inGround = false;
/*     */   private int ticksInGround;
/*  55 */   private int ticksInAir = 0;
/*     */   
/*     */   private float speed;
/*     */   
/*  59 */   private float size = 2.0F;
/*     */   
/*  61 */   public int getShrink() { return func_70096_w().func_75679_c(20); }
/*  62 */   public float getSpe() { return this.speed; } public int getAirTicks() {
/*  63 */     return this.ticksInAir;
/*     */   } public void setAirTicks(int i) {
/*  65 */     this.ticksInAir = i;
/*     */   }
/*     */   
/*     */   private boolean teleported = false;
/*  69 */   private byte mode = 0;
/*  70 */   private byte skillLevel = 1;
/*  71 */   private int bodyColor = 0;
/*  72 */   private float userAttack = 1.0F;
/*  73 */   private float userPower = 1.0F;
/*  74 */   private int stateID = 0;
/*     */   
/*  76 */   public byte getSkillLevel() { return this.skillLevel; }
/*  77 */   public int getBodyColor() { return this.bodyColor; } public byte getMode() {
/*  78 */     return this.mode;
/*     */   }
/*  80 */   public float targetW = 0.0F;
/*  81 */   public float targetH = 0.0F;
/*     */   
/*  83 */   public double visualH = 0.0D;
/*  84 */   public double visualW = 0.0D;
/*     */   
/*  86 */   public double prevX = 0.0D;
/*  87 */   public double prevY = 0.0D;
/*  88 */   public double prevZ = 0.0D;
/*  89 */   public int prevCount = 0;
/*  90 */   public String absorptionData = "0,0,0+0";
/*     */ 
/*     */   
/*     */   public EntityMajinAbsorption(World world) {
/*  94 */     super(world);
/*  95 */     func_70105_a(this.size, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityMajinAbsorption(EntityLivingBase userEntity, int skillLevel, int bodyColor, float userPower, float userAttack, int stateID) {
/* 101 */     super(userEntity.field_70170_p);
/* 102 */     setData(skillLevel, bodyColor, userPower, userAttack, stateID);
/*     */     
/* 104 */     this.speed = 1.0F * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_SPEED_MULTI[stateID];
/*     */     
/* 106 */     this.size = 2.0F;
/* 107 */     this.shootingEntity = (Entity)userEntity;
/* 108 */     this.field_70155_l = 10.0D;
/* 109 */     func_70105_a(this.size, this.size);
/* 110 */     double d8 = (userEntity.field_70130_N + 1.0F);
/* 111 */     double d9 = (userEntity.field_70131_O + 0.5F + this.size * 0.5F);
/* 112 */     Vec3 vec3 = userEntity.func_70040_Z();
/* 113 */     double x = userEntity.field_70165_t + vec3.field_72450_a * d8;
/* 114 */     double y = userEntity.field_70163_u + vec3.field_72448_b * d8 + (userEntity.field_70131_O * 0.55F);
/* 115 */     double z = userEntity.field_70161_v + vec3.field_72449_c * d8;
/* 116 */     this.field_70129_M = this.size * 0.5F;
/*     */     
/* 118 */     func_70012_b(x, y, z, userEntity.func_70079_am(), userEntity.field_70125_A);
/*     */     
/* 120 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 121 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 122 */     this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F);
/* 123 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.speed, 1.0F);
/*     */     
/* 125 */     this.prevX = this.field_70165_t;
/* 126 */     this.prevY = this.field_70163_u;
/* 127 */     this.prevZ = this.field_70161_v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setData(int skillLevel, int bodyColor, float userPower, float userAttack, int stateID) {
/* 132 */     this.skillLevel = (byte)skillLevel;
/* 133 */     this.bodyColor = bodyColor;
/* 134 */     this.userPower = userPower;
/* 135 */     if (userPower < 1.0F) userPower = 1.0F; 
/* 136 */     this.userAttack = userAttack;
/* 137 */     if (userAttack < 1.0F) userAttack = 1.0F; 
/* 138 */     this.stateID = stateID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 145 */     this.field_70180_af.func_75682_a(20, Integer.valueOf(0));
/* 146 */     this.field_70180_af.func_75682_a(21, Float.valueOf(0.0F));
/* 147 */     this.field_70180_af.func_75682_a(22, Float.valueOf(0.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {
/* 155 */     float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
/* 156 */     par1 /= var9;
/* 157 */     par3 /= var9;
/* 158 */     par5 /= var9;
/* 159 */     par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 160 */     par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 161 */     par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 162 */     par1 *= par7;
/* 163 */     par3 *= par7;
/* 164 */     par5 *= par7;
/* 165 */     this.field_70159_w = par1;
/* 166 */     this.field_70181_x = par3;
/* 167 */     this.field_70179_y = par5;
/* 168 */     float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 169 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 170 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI);
/* 171 */     this.ticksInGround = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 177 */     func_70107_b(par1, par3, par5);
/* 178 */     func_70101_b(par7, par8);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 184 */     this.field_70159_w = par1;
/* 185 */     this.field_70181_x = par3;
/* 186 */     this.field_70179_y = par5;
/*     */     
/* 188 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 190 */       float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 191 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 192 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / Math.PI);
/* 193 */       this.field_70127_C = this.field_70125_A;
/* 194 */       this.field_70126_B = this.field_70177_z;
/* 195 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 196 */       this.ticksInGround = 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 219 */     if (!this.field_70170_p.field_72995_K && this.shootingEntity == null)
/*     */     {
/* 221 */       func_70106_y();
/*     */     }
/*     */     
/* 224 */     if (this.field_70163_u >= 250.0D) this.field_70181_x = 0.0D;
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
/* 235 */     if (this.field_70173_aa == 1) {
/*     */       
/* 237 */       func_70105_a(this.size, this.size);
/* 238 */       this.field_70129_M = this.size * 0.5F;
/*     */     } 
/*     */     
/* 241 */     super.func_70071_h_();
/*     */     
/* 243 */     if (!this.field_70170_p.field_72995_K && (this.field_70173_aa >= JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[this.stateID][0] || (this.prevX == this.field_70165_t && this.prevY == this.field_70163_u && this.prevZ == this.field_70161_v))) {
/* 244 */       this.prevCount++;
/* 245 */       if (this.prevCount >= JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[this.stateID][1]) func_70106_y(); 
/*     */     } else {
/* 247 */       this.prevCount = 0;
/*     */     } 
/* 249 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 251 */       float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 252 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/* 253 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 256 */     Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 258 */     if (block.func_149688_o() != Material.field_151579_a) {
/*     */       
/* 260 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 261 */       AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 263 */       if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))
/*     */       {
/* 265 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 269 */     if (this.inGround) {
/*     */       
/* 271 */       int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 273 */       if (block == this.inTile && var19 == this.inData)
/*     */       {
/* 275 */         this.ticksInGround++;
/*     */         
/* 277 */         int t = this.ticksInGround / 10 * 10;
/* 278 */         if (this.ticksInGround == ((t == 0) ? 10 : t))
/*     */         {
/* 280 */           this.field_70170_p.func_72956_a(this, "jinryuudragonbc:DBC5.majin_bodypart", 0.4F, 1.0F);
/*     */         }
/*     */         
/* 283 */         if (this.ticksInGround >= 1)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 289 */           this.field_70165_t -= this.field_70159_w;
/* 290 */           this.field_70163_u -= this.field_70181_x;
/* 291 */           this.field_70161_v -= this.field_70179_y;
/* 292 */           this.field_70159_w = 0.0D;
/* 293 */           this.field_70181_x = 0.0D;
/* 294 */           this.field_70179_y = 0.0D;
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 309 */         this.inGround = false;
/* 310 */         this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 311 */         this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 312 */         this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 313 */         this.ticksInGround = 0;
/* 314 */         this.ticksInAir = 0;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 319 */       this.ticksInAir++;
/* 320 */       Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 321 */       Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 322 */       MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
/* 323 */       var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 324 */       var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */ 
/*     */ 
/*     */       
/* 328 */       if (!this.field_70170_p.field_72995_K && this.ticksInAir >= 2000 && this.target == null && getMode() != 2)
/*     */       {
/* 330 */         func_70106_y();
/*     */       }
/*     */       
/* 333 */       int t = this.ticksInAir / 10 * 10;
/*     */       
/* 335 */       if (this.ticksInAir == ((t == 0) ? 10 : t))
/*     */       {
/* 337 */         this.field_70170_p.func_72956_a(this, "jinryuudragonbc:DBC5.majin_bodypart", 0.4F, 1.0F);
/*     */       }
/*     */       
/* 340 */       if (var4 != null)
/*     */       {
/* 342 */         var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 348 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 350 */         Entity var5 = null;
/* 351 */         double HITBOX = 2.0D;
/* 352 */         List<Entity> var6 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(2.0D, 2.0D, 2.0D));
/* 353 */         double var7 = 0.0D;
/*     */         
/* 355 */         for (int var9 = 0; var9 < var6.size(); var9++) {
/*     */           
/* 357 */           Entity var10 = var6.get(var9);
/*     */           
/* 359 */           if (var10 instanceof EntityLivingBase && var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */             
/* 361 */             float var11 = 0.0F;
/* 362 */             AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(var11, var11, var11);
/* 363 */             MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
/*     */             
/* 365 */             if (var13 != null) {
/*     */               
/* 367 */               double var14 = var17.func_72438_d(var13.field_72307_f);
/*     */               
/* 369 */               if (var14 < var7 || var7 == 0.0D) {
/*     */                 
/* 371 */                 var5 = var10;
/* 372 */                 var7 = var14;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 378 */         if (var5 != null)
/*     */         {
/* 380 */           var4 = new MovingObjectPosition(var5);
/*     */         }
/*     */       } 
/* 383 */       if (!this.field_70170_p.field_72995_K && this.target == null) {
/*     */         
/* 385 */         Entity var5 = null;
/* 386 */         double HITBOX = 4.0D;
/* 387 */         List<Entity> var6 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(4.0D, 4.0D, 4.0D));
/* 388 */         double var7 = 0.0D;
/*     */         
/* 390 */         for (int var9 = 0; var9 < var6.size(); var9++) {
/*     */           
/* 392 */           Entity var10 = var6.get(var9);
/*     */           
/* 394 */           if (var10 instanceof EntityLivingBase && var10 != null && ((EntityLivingBase)var10).func_70089_S() && var10 != this.shootingEntity && var10.func_70067_L())
/*     */           {
/*     */             
/* 397 */             if (!isEntityOnTheBlacklist(var10) && !JRMCoreH.isFusionSpectator(var10) && !JRMCoreH.isInCreativeMode(var10)) {
/* 398 */               if (this.target == null) {
/* 399 */                 this.target = var10;
/* 400 */                 this.mode = 1;
/* 401 */                 func_70096_w().func_75692_b(20, Integer.valueOf(1));
/* 402 */                 func_70096_w().func_75692_b(21, Float.valueOf(this.target.field_70130_N));
/* 403 */                 func_70096_w().func_75692_b(22, Float.valueOf(this.target.field_70131_O));
/*     */                 break;
/*     */               } 
/* 406 */               double distX = this.target.field_70165_t - this.field_70165_t; if (distX < 0.0D) distX *= -1.0D; 
/* 407 */               double distY = this.target.field_70163_u + (this.target.field_70131_O / 2.0F) - this.field_70163_u; if (distY < 0.0D) distY *= -1.0D; 
/* 408 */               double distZ = this.target.field_70161_v - this.field_70161_v; if (distZ < 0.0D) distZ *= -1.0D; 
/* 409 */               double dist = distX + distY + distZ;
/*     */ 
/*     */               
/* 412 */               double distX2 = var10.field_70165_t - this.field_70165_t; if (distX2 < 0.0D) distX2 *= -1.0D; 
/* 413 */               double distY2 = var10.field_70163_u - this.field_70163_u; if (distY2 < 0.0D) distY2 *= -1.0D; 
/* 414 */               double distZ2 = var10.field_70161_v - this.field_70161_v; if (distZ2 < 0.0D) distZ2 *= -1.0D; 
/* 415 */               double dist2 = distX2 + distY2 + distZ2;
/*     */               
/* 417 */               if (dist < dist2) {
/* 418 */                 this.target = var10;
/* 419 */                 this.mode = 1;
/* 420 */                 func_70096_w().func_75692_b(20, Integer.valueOf(1));
/* 421 */                 func_70096_w().func_75692_b(21, Float.valueOf(this.target.field_70130_N));
/* 422 */                 func_70096_w().func_75692_b(22, Float.valueOf(this.target.field_70131_O));
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/*     */               break;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 434 */       if (var4 != null && this.target == null && this.mode <= 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 443 */         if (!this.field_70170_p.func_147439_a(var4.field_72311_b, var4.field_72312_c, var4.field_72309_d).func_149739_a().equals("tile.bedrock")) {
/* 444 */           this.xTile = var4.field_72311_b;
/* 445 */           this.yTile = var4.field_72312_c;
/* 446 */           this.zTile = var4.field_72309_d;
/* 447 */           this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/* 448 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 449 */           this.inGround = true;
/*     */           
/* 451 */           if (this.inTile.func_149688_o() != Material.field_151579_a)
/*     */           {
/* 453 */             this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 458 */       Entity target = (getMode() == 1) ? this.target : ((getMode() == 2) ? this.shootingEntity : null);
/*     */       
/* 460 */       if (target != null) {
/* 461 */         double distX = target.field_70165_t - this.field_70165_t;
/* 462 */         double distY = target.field_70163_u + (target.field_70131_O / 2.0F) - this.field_70163_u;
/* 463 */         double distZ = target.field_70161_v - this.field_70161_v;
/*     */         
/* 465 */         double div = 20.0D;
/* 466 */         double MIN_SPEED = 0.1D;
/* 467 */         double HIT_DISTANCE = 0.3D;
/* 468 */         this.field_70159_w = distX / 20.0D; if (JGMathHelper.doubleSmallerThan(this.field_70159_w, MIN_SPEED)) this.field_70159_w = (this.field_70159_w < 0.0D) ? -MIN_SPEED : MIN_SPEED; 
/* 469 */         this.field_70181_x = distY / 20.0D; if (JGMathHelper.doubleSmallerThan(this.field_70181_x, MIN_SPEED)) this.field_70181_x = (this.field_70181_x < 0.0D) ? -MIN_SPEED : MIN_SPEED; 
/* 470 */         this.field_70179_y = distZ / 20.0D; if (JGMathHelper.doubleSmallerThan(this.field_70179_y, MIN_SPEED)) this.field_70179_y = (this.field_70179_y < 0.0D) ? -MIN_SPEED : MIN_SPEED;
/*     */         
/* 472 */         this.field_70165_t += this.field_70159_w;
/* 473 */         this.field_70163_u += this.field_70181_x;
/* 474 */         this.field_70161_v += this.field_70179_y;
/*     */         
/* 476 */         if (!this.field_70170_p.field_72995_K)
/*     */         {
/* 478 */           if (this.shootingEntity != null && this.shootingEntity.func_70089_S()) {
/* 479 */             if (JGMathHelper.doubleSmallerThan(distX, HIT_DISTANCE) && JGMathHelper.doubleSmallerThan(distY, HIT_DISTANCE) && JGMathHelper.doubleSmallerThan(distZ, HIT_DISTANCE))
/*     */             {
/* 481 */               if (getMode() == 2) {
/*     */                 
/* 483 */                 JGPlayerMP jgPlayer = new JGPlayerMP((EntityPlayer)this.shootingEntity);
/* 484 */                 jgPlayer.connectBaseNBT();
/* 485 */                 jgPlayer.setAbsorption(this.absorptionData);
/*     */ 
/*     */                 
/* 488 */                 this.field_70170_p.func_72956_a(this, "jinryuudragonbc:DBC5.majin_absorption2", 0.4F, 1.0F);
/* 489 */                 func_70106_y();
/*     */               }
/* 491 */               else if (this.target != null && ((EntityLivingBase)this.target).func_70089_S()) {
/*     */                 
/* 493 */                 JGPlayerMP jgPlayer = new JGPlayerMP((EntityPlayer)this.shootingEntity);
/* 494 */                 jgPlayer.connectBaseNBT();
/*     */                 
/* 496 */                 if (JRMCoreH.isPowerTypeKi(jgPlayer.getPowerType()) && JRMCoreH.isRaceMajin(jgPlayer.getRace())) {
/*     */                   
/* 498 */                   float attackTarget = 1.0F;
/* 499 */                   float healthTarget = 1.0F;
/* 500 */                   float kiPowerTarget = 1.0F;
/* 501 */                   if (this.target instanceof EntityPlayer) {
/* 502 */                     JGPlayerMP jgPlayerTarget = new JGPlayerMP((EntityPlayer)this.target);
/* 503 */                     jgPlayerTarget.connectBaseNBT();
/*     */                     
/* 505 */                     float release = jgPlayerTarget.getRelease() / 100.0F;
/*     */                     
/* 507 */                     int strength = jgPlayerTarget.getAttribute(0);
/* 508 */                     attackTarget = JRMCoreH.stat(0, (EntityPlayer)this.target, 0, strength, 0.0F);
/* 509 */                     attackTarget = (int)(attackTarget * release);
/*     */                     
/* 511 */                     healthTarget = jgPlayerTarget.getHealth();
/* 512 */                     kiPowerTarget = jgPlayerTarget.getEnergyPower();
/* 513 */                     kiPowerTarget = (int)(kiPowerTarget * release);
/*     */                   } else {
/*     */                     
/* 516 */                     if (((EntityLivingBase)this.target).func_110148_a(SharedMonsterAttributes.field_111264_e) != null) {
/* 517 */                       attackTarget = (float)((EntityLivingBase)this.target).func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/* 518 */                       kiPowerTarget = attackTarget / 2.0F;
/*     */                     } 
/* 520 */                     healthTarget = ((EntityLivingBase)this.target).func_110143_aJ();
/*     */                   } 
/*     */                   
/* 523 */                   float targetHealthOG = healthTarget;
/*     */                   
/* 525 */                   attackTarget = (int)(attackTarget * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[this.stateID][0]);
/* 526 */                   healthTarget = (int)(healthTarget * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[this.stateID][1]);
/* 527 */                   kiPowerTarget = (int)(kiPowerTarget * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[this.stateID][2]);
/* 528 */                   if (attackTarget < 1.0F) attackTarget = 1.0F;  if (healthTarget < 1.0F) healthTarget = 1.0F;  if (kiPowerTarget < 1.0F) kiPowerTarget = 1.0F; 
/* 529 */                   float powerTarget = attackTarget + kiPowerTarget + healthTarget;
/*     */                   
/* 531 */                   if (powerTarget <= this.userPower) {
/* 532 */                     String[] prevAbs = jgPlayer.getAbsorption().split(",");
/* 533 */                     this.absorptionData = "";
/* 534 */                     boolean isTargetPlayer = this.target instanceof EntityPlayer;
/* 535 */                     for (int i = 0; i < 3; i++) {
/*     */                       String data;
/* 537 */                       if (prevAbs.length <= i) {
/* 538 */                         data = (i == 2) ? "0+0" : "0";
/*     */                       }
/*     */                       else {
/*     */                         
/* 542 */                         data = prevAbs[i];
/*     */                         
/* 544 */                         if (i == 0) {
/* 545 */                           int prevValue = 0;
/* 546 */                           if (prevAbs[i].length() > 0) {
/* 547 */                             prevValue = Integer.parseInt(prevAbs[i]);
/*     */                           }
/*     */                           
/* 550 */                           int gain = (int)(powerTarget / this.userPower * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_GAIN_MULTI);
/* 551 */                           if (gain < JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MIN_GAIN) gain = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MIN_GAIN;
/*     */ 
/*     */                           
/* 554 */                           if (JGConfigRaces.CONFIG_MAJIN_ADD_GAIN_ENABLED) { prevValue += gain; }
/* 555 */                           else { prevValue = gain; }
/*     */                           
/* 557 */                           if (prevValue > JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_LEVEL) prevValue = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_MAX_LEVEL; 
/* 558 */                           data = "" + prevValue;
/*     */                         }
/* 560 */                         else if (isTargetPlayer) {
/*     */                           
/* 562 */                           if (i == 1) {
/* 563 */                             JGPlayerMP jgPlayerTarget = new JGPlayerMP((EntityPlayer)this.target);
/* 564 */                             jgPlayerTarget.connectBaseNBT();
/* 565 */                             data = "" + jgPlayerTarget.getRace();
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
/*     */                           }
/* 580 */                           else if (i == 2) {
/* 581 */                             data = "";
/*     */                             
/* 583 */                             ItemStack[] stack_vanities = new ItemStack[8];
/*     */                             
/* 585 */                             for (int j = 0; j < 8; j++) {
/*     */                               
/* 587 */                               stack_vanities[j] = (ExtendedPlayer.get((EntityPlayer)this.target)).inventory.func_70301_a(3 + j);
/* 588 */                               if (stack_vanities[j] != null && stack_vanities[j].func_77973_b() instanceof ItemVanity)
/*     */                               {
/* 590 */                                 data = data + ((data.length() > 0) ? "-" : "") + Item.func_150891_b(stack_vanities[j].func_77973_b()) + "+" + ((ItemVanity)stack_vanities[j].func_77973_b()).getColor(stack_vanities[j]);
/*     */                               }
/*     */                             } 
/* 593 */                             if (data.length() == 0) data = "0+0"; 
/*     */                           } 
/*     */                         } else {
/* 596 */                           data = (i == 2) ? "0+0" : "0";
/*     */                         } 
/* 598 */                       }  this.absorptionData += data + ((i + 1 < 3) ? "," : "");
/*     */                     } 
/* 600 */                     this.mode = 2;
/* 601 */                     func_70096_w().func_75692_b(20, Integer.valueOf(2));
/*     */                     
/* 603 */                     ((EntityLivingBase)this.target).func_70606_j(1.0F);
/* 604 */                     DamageSource damagesource = Ds.causeEntityMajinAbsorptionDamage(this, this.shootingEntity);
/* 605 */                     if (this.target.func_70097_a(damagesource, targetHealthOG)) {
/* 606 */                       this.field_70170_p.func_72956_a(this, "jinryuudragonbc:DBC5.majin_absorption", 0.3F, 1.0F);
/*     */                     } else {
/*     */                       
/* 609 */                       func_70106_y();
/*     */                     } 
/*     */                   } else {
/*     */                     
/* 613 */                     func_70106_y();
/*     */                   } 
/*     */                 } else {
/*     */                   
/* 617 */                   func_70106_y();
/*     */                 } 
/*     */               } else {
/*     */                 
/* 621 */                 func_70106_y();
/*     */               } 
/*     */             }
/*     */           } else {
/*     */             
/* 626 */             func_70106_y();
/*     */           } 
/*     */         }
/*     */       } else {
/*     */         
/* 631 */         this.field_70165_t += this.field_70159_w;
/* 632 */         this.field_70163_u += this.field_70181_x;
/* 633 */         this.field_70161_v += this.field_70179_y;
/*     */       } 
/*     */       
/* 636 */       this.mode = (byte)func_70096_w().func_75679_c(20);
/* 637 */       this.targetW = func_70096_w().func_111145_d(21);
/* 638 */       this.targetH = func_70096_w().func_111145_d(22);
/*     */ 
/*     */       
/* 641 */       while (this.field_70125_A - this.field_70127_C >= 180.0F)
/*     */       {
/* 643 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 646 */       while (this.field_70177_z - this.field_70126_B < -180.0F)
/*     */       {
/* 648 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 651 */       while (this.field_70177_z - this.field_70126_B >= 180.0F)
/*     */       {
/* 653 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 656 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 665 */     par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 666 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 667 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 668 */     par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 669 */     par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
/* 670 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 680 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 681 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 682 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 683 */     this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 684 */     this.inData = par1NBTTagCompound.func_74771_c("inData") & 0xFF;
/* 685 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer par1EntityPlayer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 699 */     return false;
/*     */   } @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 702 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 707 */     return false;
/*     */   }
/*     */   public boolean func_82704_a(Entity var1) {
/* 710 */     return false;
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 714 */     data.writeInt((this.shootingEntity == null) ? 0 : this.shootingEntity.func_145782_y());
/* 715 */     data.writeInt((this.target == null) ? 0 : this.target.func_145782_y());
/* 716 */     data.writeFloat(this.speed);
/* 717 */     data.writeFloat(this.size);
/*     */     
/* 719 */     data.writeInt(this.bodyColor);
/* 720 */     data.writeByte(this.skillLevel);
/* 721 */     data.writeFloat(this.userPower);
/* 722 */     data.writeByte(this.mode);
/* 723 */     data.writeFloat(this.targetW);
/* 724 */     data.writeFloat(this.targetH);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 730 */     int first = data.readInt();
/* 731 */     this.shootingEntity = (first == 0) ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
/* 732 */     int second = data.readInt();
/* 733 */     this.target = (second == 0) ? this.target : this.field_70170_p.func_73045_a(second);
/* 734 */     this.speed = data.readFloat();
/* 735 */     this.size = data.readFloat();
/*     */     
/* 737 */     this.bodyColor = data.readInt();
/* 738 */     this.skillLevel = data.readByte();
/* 739 */     this.userPower = data.readFloat();
/* 740 */     this.mode = data.readByte();
/* 741 */     this.targetW = data.readFloat();
/* 742 */     this.targetH = data.readFloat();
/*     */   }
/*     */   
/*     */   public Entity getThrower() {
/* 746 */     return null;
/*     */   }
/*     */   public void setThrower(Entity entity) {}
/*     */   @SideOnly(Side.CLIENT)
/* 750 */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) { return true; }
/*     */   @SideOnly(Side.CLIENT)
/* 752 */   public double getMaxRenderDistanceSquared() { return 65536.0D; } public boolean func_70112_a(double par1) {
/* 753 */     return true;
/*     */   } public float rad(float angle) {
/* 755 */     return angle * 3.1415927F / 180.0F;
/*     */   }
/*     */   
/*     */   public NBTTagCompound nbt(EntityPlayer p, String s) {
/*     */     NBTTagCompound nbt;
/* 760 */     if (s.contains("pres")) {
/*     */       
/* 762 */       if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/* 763 */         nbt = new NBTTagCompound();
/* 764 */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */       } else {
/* 766 */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 771 */       nbt = p.getEntityData();
/*     */     } 
/*     */     
/* 774 */     return nbt;
/*     */   }
/*     */   
/*     */   public boolean addInstance(Class cl, boolean b) {
/* 778 */     absorptionListResults.put(cl, Boolean.valueOf(b));
/* 779 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean instanceOf(Entity entity) {
/* 784 */     if (JGConfigRaces.CONFIG_MAJIN_ENTITY_BLACKLIST.size() == 0) return false;
/*     */     
/* 786 */     Class<?> entityClass = entity.getClass();
/* 787 */     if (absorptionListResults != null && absorptionListResults.size() > 0 && absorptionListResults.containsKey(entityClass)) {
/* 788 */       return ((Boolean)absorptionListResults.get(entityClass)).booleanValue();
/*     */     }
/*     */     
/* 791 */     String name = entityClass.toString();
/*     */     
/*     */     try {
/* 794 */       if (JGConfigRaces.CONFIG_MAJIN_ENTITY_BLACKLIST.containsKey(name))
/*     */       {
/* 796 */         return addInstance(entityClass, true);
/*     */       }
/*     */       
/* 799 */       for (String key : JGConfigRaces.CONFIG_MAJIN_ENTITY_BLACKLIST.keySet())
/*     */       {
/* 801 */         if ((!JRMCoreH.DBC() && key.startsWith("JinRyuu.DragonBC")) || (!JRMCoreH.NC() && key.startsWith("JinRyuu.NarutoC")))
/*     */           continue; 
/* 803 */         Class<?> cl = Class.forName(key);
/*     */         
/* 805 */         if (cl.isAssignableFrom(entityClass))
/*     */         {
/* 807 */           return addInstance(entityClass, true);
/*     */         }
/*     */       }
/*     */     
/* 811 */     } catch (Exception exception) {}
/*     */     
/* 813 */     return addInstance(entityClass, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEntityOnTheBlacklist(Entity entity) {
/* 819 */     return instanceOf(entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Entitys\EntityMajinAbsorption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */