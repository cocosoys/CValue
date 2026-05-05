/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityEnergyAttJ3
/*     */   extends EntityEnAttacks
/*     */   implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile
/*     */ {
/*  28 */   private int xTile = -1;
/*  29 */   private int yTile = -1;
/*  30 */   private int zTile = -1;
/*     */   private Block inTile;
/*  32 */   private int inData = 0;
/*     */   
/*     */   private boolean inGround = false;
/*     */   private int ticksInGround;
/*  36 */   private double damage = 1.0D;
/*     */   
/*  38 */   private String DBCExplSound = "jinryuudragonbc:DBC.expl";
/*  39 */   private String NCExplSound = "jinryuunarutoc:NC1.Explosion";
/*     */ 
/*     */   
/*     */   private byte type;
/*     */   
/*     */   private int dam;
/*     */   
/*     */   private byte perc;
/*     */   
/*     */   private byte pmjID;
/*     */   
/*     */   private int cost;
/*     */   
/*     */   private int costPerc;
/*     */   
/*     */   private int originDmg;
/*     */   
/*  56 */   private int pwrtyp = 0;
/*     */   private String nameJutsu;
/*     */   
/*  59 */   public byte getType() { return this.type; }
/*  60 */   public int getDam() { return this.dam; }
/*  61 */   public byte getPerc() { return this.perc; } public float getSizePerc() {
/*  62 */     return this.size;
/*     */   }
/*     */   
/*  65 */   public float size = 1.7F; private boolean used = false;
/*     */   private int health;
/*     */   private byte jtsre;
/*     */   private float rota;
/*     */   
/*     */   public byte getjtsre() {
/*  71 */     return this.jtsre;
/*     */   } public float getrota() {
/*  73 */     return this.rota;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityEnergyAttJ3(World par1World) {
/*  78 */     super(par1World);
/*  79 */     func_70105_a(this.size, this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityEnergyAttJ3(byte jtsre, EntityLivingBase entity, byte type, int dam, byte perc, int dam1, int cost, int costPerc) {
/*  84 */     super(entity.field_70170_p);
/*  85 */     this.jtsre = jtsre;
/*  86 */     this.type = type;
/*  87 */     this.dam = dam;
/*  88 */     this.perc = 50;
/*     */     
/*  90 */     this.cost = cost;
/*  91 */     this.costPerc = costPerc;
/*  92 */     this.originDmg = dam1;
/*  93 */     this.pmjID = perc;
/*     */     
/*  95 */     if (this.pmjID != -1) {
/*  96 */       this.nameJutsu = JRMCoreH.trl("nc", JRMCoreH.pmj[this.pmjID][0]);
/*     */     }
/*     */     
/*  99 */     this.damage = this.dam * this.perc * 0.019999999552965164D;
/* 100 */     this.shootingEntity = (Entity)entity;
/* 101 */     this.pwrtyp = 0;
/* 102 */     if (this.shootingEntity instanceof EntityPlayer) this.pwrtyp = JRMCoreH.PlyrPwr((EntityPlayer)this.shootingEntity); 
/* 103 */     this.field_70155_l = 10.0D;
/*     */     
/* 105 */     func_70105_a(this.size, this.size);
/* 106 */     double d8 = (entity.field_70130_N + 1.0F);
/* 107 */     double d9 = entity.field_70131_O;
/* 108 */     Vec3 vec3 = entity.func_70676_i(1.0F);
/*     */ 
/*     */     
/* 111 */     double x = entity.field_70165_t + vec3.field_72450_a * d8;
/* 112 */     double y = entity.field_70163_u + vec3.field_72448_b * d8 + (entity.field_70131_O * 0.55F);
/* 113 */     double z = entity.field_70161_v + vec3.field_72449_c * d8;
/*     */     
/* 115 */     int spot = -1;
/* 116 */     int checked = 0;
/* 117 */     for (int i = (int)y; spot == -1 && checked < 3; i--) {
/* 118 */       if (!entity.field_70170_p.func_147439_a((int)x, i, (int)z).func_149739_a().toLowerCase().contains("air")) {
/* 119 */         spot = i + 1;
/* 120 */         y = spot;
/*     */         break;
/*     */       } 
/* 123 */       checked++;
/*     */     } 
/*     */     
/* 126 */     func_70012_b(x, y, z, entity.field_70177_z, entity.field_70125_A);
/* 127 */     this.rota = entity.field_70177_z;
/*     */   }
/*     */   protected void func_70088_a() {
/* 130 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {}
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 142 */     func_70107_b(par1, par3, par5);
/* 143 */     func_70101_b(par7, par8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 158 */     if (!this.field_70170_p.field_72995_K && this.shootingEntity == null) func_70106_y();
/*     */     
/* 160 */     if (this.field_70173_aa == 1) func_70105_a(this.size, this.size); 
/* 161 */     if (this.field_70173_aa > 500) func_70106_y();
/*     */     
/* 163 */     super.func_70071_h_();
/* 164 */     if (!this.field_70170_p.field_72995_K && getDamage() <= 0.0D) func_70106_y();
/*     */     
/* 166 */     Block block = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*     */     
/* 168 */     if (block.func_149688_o() != Material.field_151579_a) {
/*     */       
/* 170 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
/* 171 */       AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*     */       
/* 173 */       if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) this.inGround = true;
/*     */     
/*     */     } 
/* 176 */     if (this.inGround) {
/*     */       
/* 178 */       int var19 = this.field_70170_p.func_72805_g((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*     */       
/* 180 */       if (block.func_149688_o() != Material.field_151579_a && !block.func_149739_a().toLowerCase().contains("air")) {
/*     */         
/* 182 */         this.ticksInGround++;
/* 183 */         this.field_70163_u += 0.10000000149011612D;
/*     */       }
/*     */       else {
/*     */         
/* 187 */         this.inGround = false;
/* 188 */         this.ticksInGround = 0;
/*     */       } 
/* 190 */       func_chins();
/*     */     }
/*     */     else {
/*     */       
/* 194 */       func_chins();
/*     */       
/* 196 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 197 */       doBlockCollisions();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPower(Entity entity) {
/* 204 */     return (long)(getDamage() / 2.0D);
/*     */   }
/*     */   private void doBlockCollisions() {
/* 207 */     func_145775_I();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 213 */     par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 214 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 215 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 216 */     par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 217 */     par1NBTTagCompound.func_74774_a("inData", (byte)this.inData);
/* 218 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 219 */     par1NBTTagCompound.func_74780_a("damage", this.damage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 227 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 228 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 229 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 230 */     this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 231 */     this.inData = par1NBTTagCompound.func_74771_c("inData") & 0xFF;
/* 232 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
/*     */     
/* 234 */     if (par1NBTTagCompound.func_74764_b("damage")) this.damage = par1NBTTagCompound.func_74769_h("damage");
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer e) {}
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 243 */     return false;
/*     */   } @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 246 */     return 0.0F;
/*     */   }
/* 248 */   public void setDamage(double par1) { this.damage = par1; } public double getDamage() {
/* 249 */     return this.damage;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKnockbackStrength(int par1) {}
/*     */ 
/*     */   
/*     */   public boolean func_82704_a(Entity var1) {
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 261 */     data.writeInt((this.shootingEntity == null) ? 0 : this.shootingEntity.func_145782_y());
/* 262 */     data.writeByte(this.perc);
/* 263 */     data.writeByte(this.type);
/* 264 */     data.writeByte(this.jtsre);
/* 265 */     data.writeInt(this.dam);
/* 266 */     data.writeFloat(this.size);
/* 267 */     data.writeFloat(this.rota);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 272 */     int first = data.readInt();
/* 273 */     this.shootingEntity = (first == 0) ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
/* 274 */     this.perc = data.readByte();
/* 275 */     this.type = data.readByte();
/* 276 */     this.jtsre = data.readByte();
/* 277 */     this.dam = data.readInt();
/* 278 */     this.size = data.readFloat();
/* 279 */     this.rota = data.readFloat();
/*     */   }
/*     */   
/*     */   public Entity getThrower() {
/* 283 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setThrower(Entity entity) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) {
/* 291 */     return true; }
/*     */   @SideOnly(Side.CLIENT)
/* 293 */   public double getMaxRenderDistanceSquared() { return 65536.0D; } public boolean func_70112_a(double par1) {
/* 294 */     return true;
/*     */   } public void setJutsuName(String name) {
/* 296 */     this.nameJutsu = name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 303 */     return true;
/*     */   } public float func_70111_Y() {
/* 305 */     return 0.1F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
/* 311 */     return func_70046_E();
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/* 316 */     return this.field_70121_D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_chins() {
/* 322 */     Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 323 */     Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 324 */     MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
/* 325 */     var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 326 */     var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */     
/* 328 */     if (var4 != null)
/*     */     {
/* 330 */       var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 335 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 337 */       Entity var5 = null;
/* 338 */       List<Entity> entityList = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
/* 339 */       double var7 = 0.0D;
/*     */       
/* 341 */       for (int n = 0; n < entityList.size(); n++) {
/*     */         
/* 343 */         Entity entity = entityList.get(n);
/*     */         
/* 345 */         if (entity.func_70067_L() && entity != this.shootingEntity) {
/* 346 */           float var11 = 0.0F;
/* 347 */           AxisAlignedBB var12 = entity.field_70121_D.func_72314_b(var11, var11, var11);
/* 348 */           MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
/*     */           
/* 350 */           if (var13 != null) {
/* 351 */             double var14 = var17.func_72438_d(var13.field_72307_f);
/*     */             
/* 353 */             if (var14 < var7 || var7 == 0.0D) {
/* 354 */               var5 = entity;
/* 355 */               var7 = var14;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 361 */       if (var5 != null) var4 = new MovingObjectPosition(var5);
/*     */     
/*     */     } 
/* 364 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 366 */       AxisAlignedBB aabb = this.field_70121_D.func_72329_c();
/* 367 */       List<Entity> entityList = this.field_70170_p.func_72839_b(this, aabb);
/*     */       
/* 369 */       for (int n = 0; n < entityList.size(); n++) {
/*     */         
/* 371 */         Entity entity = entityList.get(n);
/*     */         
/* 373 */         if (entity != this.shootingEntity && entity instanceof EntityEnAttacks) {
/*     */           
/* 375 */           long shieldPower = getPower(this);
/* 376 */           long targetPower = 0L;
/* 377 */           double targetDamage = 0.0D;
/*     */           
/* 379 */           if (entity instanceof EntityEnergyAttJ) {
/*     */             
/* 381 */             targetPower = ((EntityEnergyAttJ)entity).getPower(entity);
/* 382 */             targetDamage = ((EntityEnergyAttJ)entity).getDamage();
/*     */           }
/* 384 */           else if (entity instanceof EntityEnergyAttJ2) {
/*     */             
/* 386 */             targetPower = ((EntityEnergyAttJ2)entity).getPower(entity);
/* 387 */             targetDamage = ((EntityEnergyAttJ2)entity).getDamage();
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 395 */           if (targetPower > shieldPower) {
/*     */             
/* 397 */             if (entity instanceof EntityEnergyAttJ) {
/*     */               
/* 399 */               ((EntityEnergyAttJ)entity).setDamage(((float)targetDamage - (float)getDamage()));
/*     */             }
/* 401 */             else if (entity instanceof EntityEnergyAttJ2) {
/*     */               
/* 403 */               ((EntityEnergyAttJ2)entity).setDamage(((float)targetDamage - (float)getDamage()));
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 409 */             func_70106_y();
/*     */           
/*     */           }
/* 412 */           else if (targetPower < shieldPower) {
/*     */             
/* 414 */             setDamage(((float)getDamage() - (float)targetDamage));
/* 415 */             entity.func_70106_y();
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 420 */             entity.func_70106_y();
/* 421 */             func_70106_y();
/*     */           } 
/*     */           
/* 424 */           this.field_70159_w = 0.0D;
/* 425 */           this.field_70181_x = 0.0D;
/* 426 */           this.field_70179_y = 0.0D;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 436 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityEnergyAttJ3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */