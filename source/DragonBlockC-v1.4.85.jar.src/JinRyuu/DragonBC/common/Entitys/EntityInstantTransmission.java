/*     */ package JinRyuu.DragonBC.common.Entitys;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
/*     */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
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
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityInstantTransmission
/*     */   extends Entity
/*     */   implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile
/*     */ {
/*     */   public static final float SOUND = 0.25F;
/*     */   public Entity shootingEntity;
/*  40 */   private int xTile = -1;
/*  41 */   private int yTile = -1;
/*  42 */   private int zTile = -1;
/*     */   private Block inTile;
/*  44 */   private int inData = 0;
/*     */   
/*     */   private boolean inGround = false;
/*     */   private int ticksInGround;
/*  48 */   private int ticksInAir = 0;
/*     */   
/*     */   private byte speed;
/*     */   
/*  52 */   private float size = 10.0F;
/*     */   
/*  54 */   public int getShrink() { return func_70096_w().func_75679_c(20); }
/*  55 */   public byte getSpe() { return this.speed; } public int getAirTicks() {
/*  56 */     return this.ticksInAir;
/*     */   } public void setAirTicks(int i) {
/*  58 */     this.ticksInAir = i;
/*     */   }
/*     */   
/*     */   private boolean teleported = false;
/*  62 */   private byte mode = 0;
/*  63 */   private byte skillLevel = 1;
/*  64 */   private byte shortTPMode = 0;
/*  65 */   private byte surroundMode = 0;
/*     */ 
/*     */   
/*     */   public EntityInstantTransmission(World world) {
/*  69 */     super(world);
/*  70 */     func_70105_a(this.size, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityInstantTransmission(EntityLivingBase userEntity) {
/*  76 */     super(userEntity.field_70170_p);
/*     */     
/*  78 */     this.speed = 20;
/*     */     
/*  80 */     this.size = 0.5F;
/*  81 */     this.shootingEntity = (Entity)userEntity;
/*  82 */     this.field_70155_l = 10.0D;
/*  83 */     func_70105_a(this.size, this.size);
/*  84 */     double d10 = 2.0D;
/*  85 */     double d8 = (userEntity.field_70130_N + 1.0F);
/*  86 */     double d9 = (userEntity.field_70131_O + 0.5F + this.size * 0.5F);
/*  87 */     Vec3 vec3 = userEntity.func_70040_Z();
/*  88 */     double x = userEntity.field_70165_t + vec3.field_72450_a * d8 - vec3.field_72450_a * 2.0D;
/*  89 */     double y = userEntity.field_70163_u + vec3.field_72448_b * d8 + (userEntity.field_70131_O * 0.55F) - vec3.field_72448_b * 2.0D;
/*  90 */     double z = userEntity.field_70161_v + vec3.field_72449_c * d8 - vec3.field_72449_c * 2.0D;
/*  91 */     this.field_70129_M = this.size * 0.5F;
/*     */     
/*  93 */     func_70012_b(x, y, z, userEntity.func_70079_am(), userEntity.field_70125_A);
/*     */     
/*  95 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/*  96 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/*  97 */     this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F);
/*  98 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.speed * 0.05F, 1.0F);
/*     */   }
/*     */   
/*     */   public void setData(int mode, int skillLevel, int shortTPMode, int surroundMode) {
/* 102 */     this.mode = (byte)mode;
/* 103 */     this.skillLevel = (byte)skillLevel;
/* 104 */     this.shortTPMode = (byte)shortTPMode;
/* 105 */     this.surroundMode = (byte)surroundMode;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 110 */     this.field_70180_af.func_75682_a(20, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {
/* 118 */     float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
/* 119 */     par1 /= var9;
/* 120 */     par3 /= var9;
/* 121 */     par5 /= var9;
/* 122 */     par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 123 */     par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 124 */     par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 125 */     par1 *= par7;
/* 126 */     par3 *= par7;
/* 127 */     par5 *= par7;
/* 128 */     this.field_70159_w = par1;
/* 129 */     this.field_70181_x = par3;
/* 130 */     this.field_70179_y = par5;
/* 131 */     float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 132 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 133 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI);
/* 134 */     this.ticksInGround = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 140 */     func_70107_b(par1, par3, par5);
/* 141 */     func_70101_b(par7, par8);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 147 */     this.field_70159_w = par1;
/* 148 */     this.field_70181_x = par3;
/* 149 */     this.field_70179_y = par5;
/*     */     
/* 151 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 153 */       float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 154 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 155 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / Math.PI);
/* 156 */       this.field_70127_C = this.field_70125_A;
/* 157 */       this.field_70126_B = this.field_70177_z;
/* 158 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 159 */       this.ticksInGround = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 165 */     if (!this.field_70170_p.field_72995_K && !JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[0]) {
/* 166 */       func_70106_y();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 172 */     onLand();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     if (!this.field_70170_p.field_72995_K && this.shootingEntity == null)
/*     */     {
/* 184 */       func_70106_y();
/*     */     }
/*     */     
/* 187 */     if (this.field_70163_u >= 250.0D) { this.field_70181_x = 0.0D; }
/*     */     
/*     */     else
/*     */     
/* 191 */     { this.size = 0.5F;
/* 192 */       func_70105_a(this.size, this.size); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     if (this.field_70173_aa == 1) {
/*     */       
/* 200 */       func_70105_a(this.size, this.size);
/* 201 */       this.field_70129_M = this.size * 0.5F;
/*     */     } 
/*     */ 
/*     */     
/* 205 */     super.func_70071_h_();
/*     */     
/* 207 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*     */       
/* 209 */       float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 210 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/* 211 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0D / Math.PI);
/*     */     } 
/*     */     
/* 214 */     Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/*     */     
/* 216 */     if (block.func_149688_o() != Material.field_151579_a) {
/*     */       
/* 218 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 219 */       AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 221 */       if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))
/*     */       {
/* 223 */         this.inGround = true;
/*     */       }
/*     */     } 
/*     */     
/* 227 */     if (this.inGround) {
/*     */       
/* 229 */       int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*     */       
/* 231 */       if (block == this.inTile && var19 == this.inData)
/*     */       {
/* 233 */         this.ticksInGround++;
/* 234 */         if (this.ticksInGround == 1);
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */         
/* 251 */         this.inGround = false;
/* 252 */         this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 253 */         this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 254 */         this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 255 */         this.ticksInGround = 0;
/* 256 */         this.ticksInAir = 0;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 261 */       this.ticksInAir++;
/* 262 */       Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 263 */       Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 264 */       MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
/* 265 */       var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 266 */       var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */ 
/*     */ 
/*     */       
/* 270 */       if (!this.field_70170_p.field_72995_K && this.ticksInAir >= 2000)
/*     */       {
/* 272 */         func_70106_y();
/*     */       }
/*     */       
/* 275 */       int t = this.ticksInAir / 10 * 10;
/*     */       
/* 277 */       if (this.ticksInAir == ((t == 0) ? 10 : t))
/*     */       {
/* 279 */         this.field_70170_p.func_72956_a(this, "jinryuudragonbc:" + JRMCoreH.techSnds(0, 2, 0), 1.0F, 1.0F);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 284 */       if (var4 != null)
/*     */       {
/* 286 */         var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 292 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 294 */         Entity var5 = null;
/* 295 */         List<Entity> var6 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
/* 296 */         double var7 = 0.0D;
/*     */         
/* 298 */         for (int var9 = 0; var9 < var6.size(); var9++) {
/*     */           
/* 300 */           Entity var10 = var6.get(var9);
/*     */           
/* 302 */           if (var10 instanceof EntityLivingBase && var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
/*     */             
/* 304 */             float var11 = 0.0F;
/* 305 */             AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(var11, var11, var11);
/* 306 */             MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
/*     */             
/* 308 */             if (var13 != null) {
/*     */               
/* 310 */               double var14 = var17.func_72438_d(var13.field_72307_f);
/*     */               
/* 312 */               if (var14 < var7 || var7 == 0.0D) {
/*     */                 
/* 314 */                 var5 = var10;
/* 315 */                 var7 = var14;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 321 */         if (var5 != null)
/*     */         {
/* 323 */           var4 = new MovingObjectPosition(var5);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 329 */       if (var4 != null) {
/*     */ 
/*     */         
/* 332 */         if (!this.field_70170_p.field_72995_K);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 338 */         this.xTile = var4.field_72311_b;
/* 339 */         this.yTile = var4.field_72312_c;
/* 340 */         this.zTile = var4.field_72309_d;
/* 341 */         this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/* 342 */         this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 343 */         this.inGround = true;
/*     */         
/* 345 */         if (this.inTile.func_149688_o() != Material.field_151579_a)
/*     */         {
/* 347 */           this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 355 */       while (this.field_70125_A - this.field_70127_C >= 180.0F)
/*     */       {
/* 357 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 360 */       while (this.field_70177_z - this.field_70126_B < -180.0F)
/*     */       {
/* 362 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 365 */       while (this.field_70177_z - this.field_70126_B >= 180.0F)
/*     */       {
/* 367 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 370 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 379 */     par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 380 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 381 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 382 */     par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 383 */     par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
/* 384 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 392 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 393 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 394 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 395 */     this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 396 */     this.inData = par1NBTTagCompound.func_74771_c("inData") & 0xFF;
/* 397 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
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
/*     */   protected boolean func_70041_e_() {
/* 410 */     return false;
/*     */   } @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 413 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 418 */     return false;
/*     */   }
/*     */   public boolean func_82704_a(Entity var1) {
/* 421 */     return false;
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 425 */     data.writeInt((this.shootingEntity == null) ? 0 : this.shootingEntity.func_145782_y());
/* 426 */     data.writeByte(this.speed);
/* 427 */     data.writeFloat(this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 433 */     int first = data.readInt();
/* 434 */     this.shootingEntity = (first == 0) ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
/* 435 */     this.speed = data.readByte();
/* 436 */     this.size = data.readFloat();
/*     */   }
/*     */   
/*     */   public Entity getThrower() {
/* 440 */     return null;
/*     */   }
/*     */   public void setThrower(Entity entity) {}
/*     */   @SideOnly(Side.CLIENT)
/* 444 */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) { return true; }
/*     */   @SideOnly(Side.CLIENT)
/* 446 */   public double getMaxRenderDistanceSquared() { return 65536.0D; } public boolean func_70112_a(double par1) {
/* 447 */     return true;
/*     */   } public float rad(float angle) {
/* 449 */     return angle * 3.1415927F / 180.0F;
/*     */   }
/*     */   
/*     */   public void onLand() {
/* 453 */     if (this.shootingEntity != null && !this.teleported && !this.field_70170_p.field_72995_K) {
/*     */       
/* 455 */       for (int j = 0; j < JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SHORT_MAX_RANGE[this.skillLevel - 1]; j++) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 465 */         this.field_70165_t += this.field_70159_w;
/* 466 */         this.field_70163_u += this.field_70181_x;
/* 467 */         this.field_70161_v += this.field_70179_y;
/*     */         
/* 469 */         func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */ 
/*     */         
/* 472 */         if (!JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SHORT_GO_THROUGH_BLOCKS_ENABLED) {
/* 473 */           Block block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*     */           
/* 475 */           if (block.func_149688_o() != Material.field_151579_a) {
/*     */             
/* 477 */             block.func_149719_a((IBlockAccess)this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 478 */             AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*     */             
/* 480 */             if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) {
/*     */ 
/*     */               
/* 483 */               String message = "Instant Transmission Failed! A block was in the way";
/* 484 */               ((EntityPlayer)this.shootingEntity).func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
/* 485 */               func_70106_y();
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 492 */         double r = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SHORT_TARGET_FINDER_RANGE;
/* 493 */         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_70165_t - r, this.field_70163_u - r, this.field_70161_v - r, this.field_70165_t + r, this.field_70163_u + r, this.field_70161_v + r);
/* 494 */         List<Entity> entityList = this.field_70170_p.func_72839_b(this, aabb);
/*     */         
/* 496 */         for (int i = 0; i < entityList.size(); i++) {
/*     */           
/* 498 */           Entity targetEntity = entityList.get(i);
/*     */           
/* 500 */           if (targetEntity != null && targetEntity instanceof EntityLivingBase && targetEntity.func_70089_S() && !targetEntity.equals(this.shootingEntity) && !JRMCoreH.isFusionSpectator(targetEntity)) {
/*     */             double x, y, z;
/* 502 */             if (targetEntity instanceof EntityPlayer && JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_RELEASE_SENSE_REQUIRED_ENABLED[0]) {
/*     */               
/* 504 */               JGPlayerMP targetMP = new JGPlayerMP((EntityPlayer)targetEntity);
/* 505 */               NBTTagCompound nbt2 = nbt((EntityPlayer)targetEntity, "pres");
/* 506 */               targetMP.setNBT(nbt2);
/* 507 */               byte targetRelease = targetMP.getRelease();
/* 508 */               boolean targetCanBeSensed = (targetRelease > 0);
/*     */               
/* 510 */               if (!targetCanBeSensed) {
/* 511 */                 String message = "Instant Transmission Failed! Target can not be sensed at 0% Release Level.";
/* 512 */                 ((EntityPlayer)this.shootingEntity).func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
/* 513 */                 func_70106_y();
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/* 518 */             EntityPlayer pl = (EntityPlayer)this.shootingEntity;
/* 519 */             int groupID = JRMCoreH.getInt(pl, "JRMCGID");
/*     */             
/* 521 */             ArrayList<EntityPlayer> teleportedEntities = new ArrayList<EntityPlayer>();
/* 522 */             teleportedEntities.add(pl);
/*     */             
/* 524 */             if (this.surroundMode != -1) {
/* 525 */               int surroundPlayerLimit = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL[0][this.skillLevel - 1];
/*     */               
/* 527 */               double r2 = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE;
/* 528 */               double r2Y = 1.0D;
/* 529 */               AxisAlignedBB aabb2 = AxisAlignedBB.func_72330_a(pl.field_70165_t - r2, pl.field_70163_u - 1.0D, pl.field_70161_v - r2, pl.field_70165_t + r2, pl.field_70163_u + 1.0D, pl.field_70161_v + r2);
/* 530 */               List<Entity> entityList2 = this.field_70170_p.func_72839_b(this, aabb2);
/*     */               
/* 532 */               for (int m = 0; m < entityList2.size(); m++) {
/* 533 */                 Entity nearbyEntity = entityList2.get(m);
/*     */ 
/*     */                 
/* 536 */                 if (nearbyEntity != null && nearbyEntity instanceof EntityPlayer && !((EntityPlayer)nearbyEntity).equals(targetEntity) && !((EntityPlayer)nearbyEntity).equals(pl) && nearbyEntity.func_70089_S()) {
/*     */ 
/*     */ 
/*     */                   
/* 540 */                   if (surroundPlayerLimit != -1 && teleportedEntities.size() - 1 > surroundPlayerLimit)
/* 541 */                     break;  boolean groupOnly = (this.surroundMode == 0);
/* 542 */                   if (groupOnly) {
/* 543 */                     int egid = JRMCoreH.getInt((EntityPlayer)nearbyEntity, "JRMCGID");
/* 544 */                     if (egid == groupID && groupID != 0)
/*     */                     {
/* 546 */                       teleportedEntities.add((EntityPlayer)nearbyEntity);
/*     */                     }
/*     */                   } else {
/*     */                     
/* 550 */                     teleportedEntities.add((EntityPlayer)nearbyEntity);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             
/* 556 */             JGPlayerMP jgPlayer = new JGPlayerMP(pl);
/* 557 */             NBTTagCompound nbt = nbt(pl, "pres");
/* 558 */             jgPlayer.setNBT(nbt);
/*     */             
/* 560 */             String ste = jgPlayer.getStatusEffects();
/* 561 */             boolean divine = JRMCoreH.StusEfcts(17, ste);
/*     */ 
/*     */             
/* 564 */             boolean creativeMode = JRMCoreH.isInCreativeMode((Entity)pl);
/*     */ 
/*     */             
/* 567 */             if (!creativeMode) {
/* 568 */               int[] playerAttributes = jgPlayer.getAttributes();
/* 569 */               byte race = jgPlayer.getRace();
/* 570 */               byte classID = jgPlayer.getClassID();
/* 571 */               byte powerType = jgPlayer.getPowerType();
/*     */               
/* 573 */               int curEnergy = jgPlayer.getEnergy();
/* 574 */               int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(pl, powerType));
/*     */               
/* 576 */               double FLAT_COST = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COST[0][0][this.skillLevel - 1];
/* 577 */               double PERCENTAGE_COST = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COST[0][1][this.skillLevel - 1];
/*     */               
/* 579 */               double costMulti = PERCENTAGE_COST / 100.0D;
/* 580 */               double energyCost = maxEnergy * costMulti + FLAT_COST;
/*     */ 
/*     */               
/* 583 */               if (teleportedEntities.size() > 1) {
/*     */                 
/* 585 */                 double costPerPlayerFlat = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[0][this.skillLevel - 1];
/* 586 */                 double costPerPlayerPerc = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[1][this.skillLevel - 1];
/* 587 */                 double costMultiPerPlayer = costPerPlayerPerc / 100.0D;
/* 588 */                 double energyCostDim = maxEnergy * costMultiPerPlayer + costPerPlayerFlat;
/*     */                 
/* 590 */                 energyCost += energyCostDim * (teleportedEntities.size() - 1);
/*     */               } 
/*     */               
/* 593 */               if (curEnergy < energyCost) {
/* 594 */                 String message = "Instant Transmission Failed! Not Enough Ki: " + (int)energyCost;
/* 595 */                 pl.func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
/* 596 */                 func_70106_y();
/*     */                 
/*     */                 return;
/*     */               } 
/*     */               
/* 601 */               int remainingEnergy = curEnergy - (int)energyCost;
/* 602 */               JRMCoreH.setInt(remainingEnergy, pl, "jrmcEnrgy");
/*     */             } 
/*     */             
/* 605 */             pl.field_70170_p.func_72956_a((Entity)pl, divine ? "jinryuudragonbc:DBC4.blacktp" : "jinryuudragonbc:DBC5.instant_transmission", 0.25F, pl.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 610 */             if (this.shortTPMode == -1) {
/* 611 */               x = targetEntity.field_70165_t;
/* 612 */               y = targetEntity.field_70163_u;
/* 613 */               z = targetEntity.field_70161_v;
/* 614 */               Block block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 615 */               if (block.func_149688_o() != Material.field_151579_a)
/*     */               {
/* 617 */                 y++;
/*     */               }
/*     */             }
/* 620 */             else if (this.shortTPMode == 0) {
/*     */ 
/*     */ 
/*     */               
/* 624 */               x = targetEntity.field_70165_t - this.field_70159_w * 2.0D;
/* 625 */               y = targetEntity.field_70163_u - this.field_70181_x * 2.0D;
/* 626 */               z = targetEntity.field_70161_v - this.field_70179_y * 2.0D;
/* 627 */               for (int m = 0; m < 3; m++) {
/* 628 */                 boolean found = false;
/* 629 */                 Block block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 630 */                 for (int l = 0; l < 3; l++) {
/* 631 */                   block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u + l, (int)this.field_70161_v);
/* 632 */                   if (block.func_149688_o() != Material.field_151579_a) {
/*     */                     
/* 634 */                     if (m == 2) { y++; break; }
/*     */                     
/* 636 */                     float value = (m == 0) ? 1.0F : 0.0F;
/* 637 */                     x = targetEntity.field_70165_t - this.field_70159_w * value;
/* 638 */                     y = targetEntity.field_70163_u - this.field_70181_x * value;
/* 639 */                     z = targetEntity.field_70161_v - this.field_70179_y * value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } else {
/* 650 */               x = targetEntity.field_70165_t + this.field_70159_w * 2.0D;
/* 651 */               y = targetEntity.field_70163_u + this.field_70181_x * 2.0D;
/* 652 */               z = targetEntity.field_70161_v + this.field_70179_y * 2.0D;
/* 653 */               for (int m = 0; m < 3; m++) {
/* 654 */                 boolean found = false;
/* 655 */                 Block block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 656 */                 for (int l = 0; l < 3; l++) {
/* 657 */                   block = this.shootingEntity.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u + l, (int)this.field_70161_v);
/* 658 */                   if (block.func_149688_o() != Material.field_151579_a) {
/*     */                     
/* 660 */                     if (m == 2) { y++; break; }
/*     */                     
/* 662 */                     float value = (m == 0) ? 1.0F : 0.0F;
/* 663 */                     x = targetEntity.field_70165_t + this.field_70159_w * value;
/* 664 */                     y = targetEntity.field_70163_u + this.field_70181_x * value;
/* 665 */                     z = targetEntity.field_70161_v + this.field_70179_y * value;
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             
/* 673 */             JRMCoreH.playerUsedInstantTransmission(pl);
/*     */             
/* 675 */             for (int k = teleportedEntities.size() - 1; k >= 0; k--) {
/* 676 */               EntityPlayer entity = teleportedEntities.get(k);
/*     */               
/* 678 */               double x2 = entity.field_70165_t - pl.field_70165_t;
/* 679 */               double y2 = 0.0D;
/* 680 */               double z2 = entity.field_70161_v - pl.field_70161_v;
/*     */               
/* 682 */               ((EntityPlayerMP)entity).func_70080_a(x + x2, y + y2 + 1.0D, z + z2, entity.field_70177_z - ((this.shortTPMode == 1) ? '´' : false), entity.field_70125_A * ((this.shortTPMode == 1) ? -1 : true));
/*     */               
/* 684 */               ((EntityPlayerMP)entity).field_71135_a.func_147364_a(x + x2, y + y2 + 1.0D, z + z2, entity.field_70177_z, entity.field_70125_A);
/*     */ 
/*     */               
/* 687 */               entity.func_71023_q(1);
/*     */             } 
/*     */             
/* 690 */             if (JRMCoreH.isFused((Entity)pl)) {
/*     */               
/* 692 */               String fusionMembers = nbt.func_74779_i("jrmcFuzion");
/* 693 */               if (fusionMembers.length() > 0 && !fusionMembers.equals(" ")) {
/*     */                 
/* 695 */                 String[] fusionParticipants = fusionMembers.split(",");
/* 696 */                 if (fusionParticipants.length == 3) {
/*     */                   
/* 698 */                   boolean isController = fusionParticipants[0].equalsIgnoreCase(pl.func_70005_c_());
/* 699 */                   if (isController) {
/* 700 */                     EntityPlayer fusedPlayerPartner = pl.field_70170_p.func_72924_a(fusionParticipants[1]);
/* 701 */                     if (fusedPlayerPartner != null) {
/* 702 */                       NBTTagCompound nbt2 = nbt(fusedPlayerPartner, "pres");
/* 703 */                       String fusionMembers2 = nbt2.func_74779_i("jrmcFuzion");
/* 704 */                       String[] fusionParticipants2 = fusionMembers2.split(",");
/*     */                       
/* 706 */                       if (fusionParticipants2.length == 3) {
/*     */                         
/* 708 */                         ((EntityPlayerMP)fusedPlayerPartner).field_71135_a.func_147364_a(x, y + 1.5D, z, fusedPlayerPartner.field_70177_z, fusedPlayerPartner.field_70125_A);
/* 709 */                         fusedPlayerPartner.func_71023_q(1);
/*     */                       } 
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             
/* 717 */             JRMCoreH.playerUsedInstantTransmission(pl);
/*     */             
/* 719 */             this.teleported = true;
/* 720 */             this.field_70159_w = 0.0D;
/* 721 */             this.field_70181_x = 0.0D;
/* 722 */             this.field_70179_y = 0.0D;
/*     */ 
/*     */ 
/*     */             
/* 726 */             pl.field_70170_p.func_72956_a((Entity)pl, divine ? "jinryuudragonbc:DBC4.blacktp" : "jinryuudragonbc:DBC5.instant_transmission", 0.25F, pl.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 731 */             if (nbt.func_74764_b("jrmcInstantTransmissionTimers")) {
/* 732 */               String instantTransmissionTimers = nbt.func_74779_i("jrmcInstantTransmissionTimers");
/* 733 */               String[] values = instantTransmissionTimers.split(";");
/* 734 */               int tpShort = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COOLDOWN[0][this.skillLevel - 1];
/* 735 */               int tpLong = Integer.parseInt(values[1]);
/* 736 */               JRMCoreH.setString(tpShort + ";" + tpLong, pl, "jrmcInstantTransmissionTimers");
/*     */             } else {
/*     */               
/* 739 */               String instantTransmissionTimers = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COOLDOWN[0][this.skillLevel - 1] + ";0";
/* 740 */               JRMCoreH.setString(instantTransmissionTimers, pl, "jrmcInstantTransmissionTimers");
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 745 */             func_70106_y();
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/* 751 */       if (!this.field_70128_L) {
/* 752 */         String message = "Instant Transmission didn't find any targets!";
/* 753 */         ((EntityPlayerMP)this.shootingEntity).func_145747_a((new ChatComponentText(message)).func_150255_a(DBCPacketHandlerServer.styleRed));
/* 754 */         func_70106_y();
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound nbt(EntityPlayer p, String s) {
/*     */     NBTTagCompound nbt;
/* 763 */     if (s.contains("pres")) {
/*     */       
/* 765 */       if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/* 766 */         nbt = new NBTTagCompound();
/* 767 */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */       } else {
/* 769 */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 774 */       nbt = p.getEntityData();
/*     */     } 
/*     */     
/* 777 */     return nbt;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Entitys\EntityInstantTransmission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */