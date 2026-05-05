/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCFlyingCharge;
/*     */ import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCGroundDash;
/*     */ import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCGroundJump;
/*     */ import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCKiAttackCharge;
/*     */ import JinRyuu.DragonBC.common.Npcs.aai.AAiDBCTeleport;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import JinRyuu.JRMCore.entity.EntityEnergyAtt;
/*     */ import JinRyuu.JRMCore.entity.aai.AAi;
/*     */ import JinRyuu.JRMCore.entity.aai.AAiSystem;
/*     */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCAAiDifficulty;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityDBC
/*     */   extends EntityCreature
/*     */   implements IMob
/*     */ {
/*     */   public static final double DISTANCE_LENGTH_MAX = 64.0D;
/*     */   public static final double DISTANCE_LENGTH_MIN = 4.0D;
/*     */   protected String texture;
/*  40 */   private double moveSpeed = DBCConfig.EnemyDefaultMoveSpeed;
/*  41 */   private int rang = 0;
/*     */   
/*     */   private boolean updtd = false;
/*  44 */   public int angerLevel = 0;
/*     */   
/*  46 */   private int aggroCooldown = 0;
/*  47 */   public int prevAttackCounter = 0;
/*  48 */   public int attackCounter = 0;
/*  49 */   private Entity targetedEntity = null;
/*     */ 
/*     */   
/*  52 */   private byte data1 = 1;
/*     */   public void setData1(int data) {
/*  54 */     this.data1 = (byte)data;
/*     */   }
/*  56 */   private byte data2 = 0;
/*     */   public void setData2(int data) {
/*  58 */     this.data2 = (byte)data;
/*     */   }
/*  60 */   private byte data3 = 0;
/*     */   public void setData3(int data) {
/*  62 */     this.data3 = (byte)data;
/*     */   }
/*  64 */   private byte data4 = 0;
/*     */   public void setData4(int data) {
/*  66 */     this.data4 = (byte)data;
/*     */   }
/*     */   private boolean blst = false;
/*     */   
/*     */   public boolean doBlst() {
/*  71 */     if (this.blst) { this.blst = false; return true; }  return false;
/*     */   }
/*     */   public boolean canFly = true;
/*  74 */   public int kiAttackTimer = 80; public boolean canFireKiAttacks = true; public boolean kiBarrageType0 = true; public int kiAttackTimerMin = 5;
/*     */   
/*     */   public boolean chargingKiAttack = false;
/*  77 */   public int chargingKiAttackTimer = 0;
/*  78 */   public int chargingKiAttackTimerMax = 0;
/*     */   
/*     */   public AAiSystem aaiSystem;
/*     */   
/*     */   public boolean hasAAiKiChargeSystem = false;
/*  83 */   public Entity lockedBy = null;
/*     */   
/*  85 */   public int difficultyID = 0; public boolean aggressive = true; public static final int STYLE_EASY = 0;
/*     */   public static final int STYLE_MEDIUM = 1;
/*     */   public static final int STYLE_HARD = 2;
/*     */   public static final int STYLE_INSANE = 3;
/*     */   
/*     */   public EntityDBC(World par1World) {
/*  91 */     super(par1World);
/*  92 */     this.field_70728_aV = 5;
/*  93 */     func_94058_c("");
/*  94 */     func_94061_f(false);
/*  95 */     this.moveSpeed = DBCConfig.EnemyDefaultMoveSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 106 */     return this.texture;
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/* 110 */     super.func_110147_ax();
/* 111 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
/* 112 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
/* 113 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(10.0D);
/* 114 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
/*     */   }
/*     */   
/* 117 */   protected void func_70088_a() { super.func_70088_a(); this.field_70180_af.func_75682_a(23, new Integer(0)); }
/* 118 */   protected boolean func_70650_aV() { return false; } protected boolean func_70692_ba() {
/* 119 */     return false;
/*     */   }
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 122 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 124 */     if (var3 instanceof EntityPlayer) {
/* 125 */       int e = 1;
/* 126 */       if (var3 instanceof EntityPlayer) {
/* 127 */         EntityPlayer player = (EntityPlayer)var3;
/* 128 */         JRMCoreH.expPls(player, e);
/*     */       } 
/*     */     } 
/* 131 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */   
/*     */   public int getAttackStrength(Entity par1Entity, int AttPow) {
/* 135 */     ItemStack var2 = func_70694_bm();
/* 136 */     int var3 = 0;
/* 137 */     int value = (int)((AttPow + 1) * 0.5F);
/* 138 */     int dbcA = AttPow - this.field_70146_Z.nextInt(value);
/* 139 */     if (dbcA < 0) dbcA = 0; 
/* 140 */     return dbcA;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/* 145 */     boolean doSuperActionUpdate = true;
/* 146 */     if (!(this instanceof EntityDBCWildlife))
/*     */     {
/* 148 */       if (this.angerLevel > 0) {
/*     */         
/* 150 */         doSuperActionUpdate = false;
/* 151 */         this.field_70143_R = 0.0F;
/*     */         
/* 153 */         this.prevAttackCounter = this.attackCounter;
/*     */         
/* 155 */         if (this.targetedEntity != null && this.targetedEntity.field_70128_L) {
/*     */           
/* 157 */           this.targetedEntity = null;
/* 158 */           this.field_70180_af.func_75692_b(23, Integer.valueOf(0));
/* 159 */           super.func_70626_be();
/*     */         } 
/*     */         
/* 162 */         if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
/*     */           
/* 164 */           this.targetedEntity = (Entity)this.field_70170_p.func_72856_b((Entity)this, 100.0D);
/* 165 */           super.func_70626_be();
/*     */           
/* 167 */           if (this.targetedEntity != null) {
/*     */             
/* 169 */             this.field_70180_af.func_75692_b(23, Integer.valueOf(this.targetedEntity.func_145782_y()));
/* 170 */             this.aggroCooldown = 20;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 175 */         float r = this.field_70130_N / 2.0F + 3.5F;
/* 176 */         if (this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d((Entity)this) < r) {
/*     */           
/* 178 */           AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_70165_t - r, this.field_70163_u - r, this.field_70161_v - r, this.field_70165_t + r, this.field_70163_u + r, this.field_70161_v + r);
/* 179 */           List<EntityPlayer> list = this.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/*     */           
/* 181 */           double distance = getXZDistanceToEntity(this.targetedEntity);
/*     */           
/* 183 */           if (this.field_70724_aR - ((!DBCConfig.AaiDisabled && distance < 0.5D) ? (DBCConfig.EnemyDefaultAttackTimer - DBCConfig.EnemyDefaultShortRangeAttackTimer) : 0) <= 0) {
/*     */ 
/*     */             
/* 186 */             for (int i = 0; i < list.size(); i++) {
/*     */               
/* 188 */               EntityPlayer player = list.get(i);
/* 189 */               func_70652_k((Entity)player);
/*     */             } 
/*     */             
/* 192 */             this.field_70724_aR = DBCConfig.EnemyDefaultAttackTimer;
/*     */             
/* 194 */             this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC3.force", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 200 */         if (this.targetedEntity != null && this.targetedEntity.func_70089_S() && this.targetedEntity
/* 201 */           .func_70068_e((Entity)this) < 4096.0D) {
/*     */ 
/*     */ 
/*     */           
/* 205 */           double distanceMulti = this.targetedEntity.func_70068_e((Entity)this) / 50.0D * 0.1D + 1.0D;
/* 206 */           double ogTimer = ((this.kiAttackTimer >= 10) ? this.kiAttackTimer : 80);
/* 207 */           int fireAttackRate = (int)(ogTimer / distanceMulti);
/* 208 */           if (fireAttackRate < this.kiAttackTimerMin) fireAttackRate = this.kiAttackTimerMin;
/*     */           
/* 210 */           double d5 = this.targetedEntity.field_70165_t - this.field_70165_t;
/* 211 */           double d6 = this.targetedEntity.field_70121_D.field_72338_b + (this.targetedEntity.field_70131_O / 2.0F) - this.field_70163_u + (this.field_70131_O / 2.0F);
/* 212 */           double d7 = this.targetedEntity.field_70161_v - this.field_70161_v;
/* 213 */           this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(d5, d7)) * 180.0F / 3.1415927F;
/*     */           
/* 215 */           if (this.canFireKiAttacks && func_70685_l(this.targetedEntity)) {
/*     */             
/* 217 */             if (!this.hasAAiKiChargeSystem || this.chargingKiAttack) {
/*     */               
/* 219 */               this.attackCounter++;
/*     */               
/* 221 */               if (this.attackCounter >= fireAttackRate) {
/*     */                 EntityEnergyAtt kiAttack;
/* 223 */                 this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC2.basicbeam_fire", 0.5F, 1.0F);
/* 224 */                 byte type = this.data1;
/* 225 */                 byte speed = 1;
/* 226 */                 byte effect = 1;
/* 227 */                 byte color = this.data2;
/* 228 */                 byte density = 1;
/* 229 */                 byte sincantation = 0;
/* 230 */                 byte sfire = 0;
/* 231 */                 byte smove = 0;
/* 232 */                 byte[] sts = JRMCoreH.techDBCstatsDefault;
/* 233 */                 int dmg = (int)(50.0F / ((this.data1 == 6) ? 5.0F : 1.0F));
/* 234 */                 int f = (int)func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/* 235 */                 int dmg1 = (int)(f * 1.2F / ((this.data1 == 6) ? 5.0F : 1.0F));
/* 236 */                 int cst = dmg1 / 2;
/*     */                 
/* 238 */                 if (this.data3 == 0) { kiAttack = new EntityEnergyAtt((EntityLivingBase)this, type, speed, dmg, effect, color, density, sincantation, sfire, smove, (byte)50, dmg1, cst, sts, (byte)0); }
/* 239 */                 else { kiAttack = new EntityEnergyAtt((EntityLivingBase)this, type, speed, dmg, effect, color, this.data4, density, sincantation, sfire, smove, (byte)50, dmg1, cst, sts, (byte)0); }
/* 240 */                  double d8 = this.field_70130_N + 0.5D;
/* 241 */                 Vec3 vec3 = func_70676_i(1.0F);
/* 242 */                 kiAttack.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
/* 243 */                 kiAttack.field_70163_u = this.field_70163_u + (this.field_70131_O / 2.0F) + 0.5D;
/* 244 */                 kiAttack.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
/* 245 */                 this.field_70170_p.func_72838_d((Entity)kiAttack);
/*     */                 
/* 247 */                 if (this.data1 != 6 || (int)(Math.random() * 8.0D) == 0)
/*     */                 {
/* 249 */                   this.attackCounter = -40;
/* 250 */                   this.blst = true;
/*     */                 }
/*     */                 else
/*     */                 {
/* 254 */                   this.attackCounter = this.kiBarrageType0 ? (fireAttackRate - 10) : fireAttackRate;
/* 255 */                   this.blst = false;
/*     */                 }
/*     */               
/*     */               } 
/*     */             } 
/* 260 */           } else if (this.attackCounter > 0) {
/*     */             
/* 262 */             this.attackCounter--;
/*     */           }
/*     */         
/* 265 */         } else if (this.attackCounter > 0) {
/*     */           
/* 267 */           this.attackCounter--;
/*     */         } 
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
/* 290 */     if (doSuperActionUpdate)
/*     */     {
/* 292 */       super.func_70626_be();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void lookForTarget() {
/* 299 */     if (this.angerLevel <= 0 && (this.targetedEntity == null || this.aggroCooldown-- <= 0)) {
/*     */       
/* 301 */       this.targetedEntity = (Entity)this.field_70170_p.func_72856_b((Entity)this, 100.0D);
/* 302 */       super.func_70626_be();
/*     */       
/* 304 */       if (this.targetedEntity != null) {
/*     */         
/* 306 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(this.targetedEntity.func_145782_y()));
/* 307 */         this.aggroCooldown = 20;
/* 308 */         becomeAngryAt(this.targetedEntity);
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int updateDataInt(int i) {
/* 364 */     return this.field_70180_af.func_75679_c(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 369 */     func_82168_bl();
/* 370 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
/* 371 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 376 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/* 378 */       this.rang++;
/*     */     }
/*     */ 
/*     */     
/* 382 */     if (this.field_70170_p.field_72995_K && this.rang > 100) {
/*     */       
/* 384 */       this.rang = 0;
/* 385 */       int i = updateDataInt(23);
/* 386 */       this.targetedEntity = (i > 0) ? this.field_70170_p.func_73045_a(i) : null;
/*     */     } 
/*     */     
/* 389 */     if (!this.field_70170_p.field_72995_K && !this.updtd)
/*     */     {
/* 391 */       this.updtd = true;
/*     */     }
/*     */     
/* 394 */     if (!(this instanceof EntityDBCWildlife))
/*     */     {
/* 396 */       if (this.targetedEntity != null && func_70685_l(this.targetedEntity) && this.canFly) {
/*     */         
/* 398 */         boolean client = this.targetedEntity.field_70170_p.field_72995_K;
/* 399 */         double posYTarget = this.targetedEntity.field_70163_u - (client ? (JGRenderHelper.isClientPlayer(this.targetedEntity) ? 1.6D : 0.0D) : 0.0D);
/*     */         
/* 401 */         if ((posYTarget - this.field_70163_u > 5.0D || !this.targetedEntity.field_70122_E) && !this.field_70703_bu) {
/*     */ 
/*     */           
/* 404 */           double yDistance = 0.0D;
/* 405 */           double posY = this.field_70163_u - (client ? (JGRenderHelper.isClientPlayer((Entity)this) ? 1.6D : 0.0D) : 0.0D);
/* 406 */           double d1 = posYTarget - posY; if (d1 < 0.0D) d1 *= -1.0D; 
/* 407 */           yDistance = d1;
/*     */           
/* 409 */           double clientPlayerPosDiff = (this.field_70170_p.field_72995_K ? (JGRenderHelper.isClientPlayer(this.targetedEntity) ? 1.6F : 0.0F) : 0.0F);
/* 410 */           double targetPos = this.targetedEntity.field_70163_u - clientPlayerPosDiff;
/*     */           
/* 412 */           this.field_70143_R = 0.0F;
/*     */           
/* 414 */           if (yDistance > 0.5D) {
/*     */             
/* 416 */             if (targetPos > this.field_70163_u - 0.5D)
/*     */             {
/* 418 */               this.field_70181_x += (yDistance > 0.1D) ? 0.1D : ((yDistance < -0.01D) ? -0.01D : yDistance);
/*     */             }
/*     */           }
/*     */           else {
/*     */             
/* 423 */             this.field_70181_x = 0.01D;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 429 */     if (this.aaiSystem != null) this.aaiSystem.update();
/*     */     
/* 431 */     if (this.lockedBy != null && !this.lockedBy.func_70089_S()) this.lockedBy = null;
/*     */     
/* 433 */     super.func_70071_h_();
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
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 457 */     EntityPlayer entityplayer = this.field_70170_p.func_72856_b((Entity)this, 16.0D);
/* 458 */     return (entityplayer != null && func_70685_l((Entity)entityplayer)) ? (Entity)entityplayer : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity entity) {
/* 463 */     if (!(entity instanceof EntityDBC)) {
/*     */       
/* 465 */       int f = (int)func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/*     */       
/* 467 */       f = getAttackStrength(entity, f);
/* 468 */       int i = 0;
/*     */       
/* 470 */       if (entity instanceof EntityLivingBase) {
/*     */         
/* 472 */         f = (int)(f + EnchantmentHelper.func_77512_a((EntityLivingBase)this, (EntityLivingBase)entity));
/* 473 */         i += EnchantmentHelper.func_77507_b((EntityLivingBase)this, (EntityLivingBase)entity);
/*     */       } 
/*     */       
/* 476 */       boolean flag = entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), f);
/*     */       
/* 478 */       if (flag) {
/*     */         
/* 480 */         if (i > 0) {
/*     */           
/* 482 */           entity.func_70024_g((-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F), 0.1D, (MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F));
/* 483 */           this.field_70159_w *= 0.6D;
/* 484 */           this.field_70179_y *= 0.6D;
/*     */         } 
/*     */         
/* 487 */         int j = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
/*     */         
/* 489 */         if (j > 0)
/*     */         {
/* 491 */           entity.func_70015_d(j * 4);
/*     */         }
/*     */         
/* 494 */         if (entity instanceof EntityLivingBase)
/*     */         {
/* 496 */           EnchantmentHelper.func_151384_a((EntityLivingBase)entity, (Entity)this);
/*     */         }
/*     */         
/* 499 */         EnchantmentHelper.func_151385_b((EntityLivingBase)this, entity);
/*     */       } 
/* 501 */       return flag;
/*     */     } 
/*     */     
/* 504 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity par1Entity, float par2) {
/* 512 */     if (this.field_70724_aR <= 0 && par2 < this.field_70130_N / 2.0F + 2.5F && par1Entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && par1Entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
/*     */       
/* 514 */       this.field_70724_aR = DBCConfig.EnemyDefaultAttackTimer;
/* 515 */       func_70652_k(par1Entity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70783_a(int par1, int par2, int par3) {
/* 525 */     return 0.5F - this.field_70170_p.func_72801_o(par1, par2, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidLightLevel() {
/* 533 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 534 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 535 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 537 */     if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, i, j, k) > this.field_70146_Z.nextInt(32))
/*     */     {
/* 539 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 543 */     int l = this.field_70170_p.func_72957_l(i, j, k);
/*     */     
/* 545 */     if (this.field_70170_p.func_72911_I()) {
/*     */       
/* 547 */       int i1 = this.field_70170_p.field_73008_k;
/* 548 */       this.field_70170_p.field_73008_k = 10;
/* 549 */       l = this.field_70170_p.func_72957_l(i, j, k);
/* 550 */       this.field_70170_p.field_73008_k = i1;
/*     */     } 
/*     */     
/* 553 */     return (l <= this.field_70146_Z.nextInt(8));
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi() {
/* 557 */     return true;
/* 558 */   } public Entity getTargetedEntity() { return this.targetedEntity; } public boolean getupdtd() {
/* 559 */     return this.updtd;
/*     */   }
/*     */   
/*     */   public void becomeAngryAtAPlayer() {
/* 563 */     List<Entity> list = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(16.0D, 16.0D, 16.0D));
/* 564 */     if (!list.isEmpty()) {
/*     */       
/* 566 */       Entity entity = list.get(0);
/* 567 */       becomeAngryAt(entity);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void becomeAngryAtAllPlayer() {
/* 573 */     List<Entity> list = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(16.0D, 16.0D, 16.0D));
/* 574 */     if (!list.isEmpty())
/*     */     {
/* 576 */       for (int i = 0; i < list.size(); i++) {
/* 577 */         Entity entity = list.get(i);
/* 578 */         becomeAngryAt(entity);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void becomeAngryAtClosestPlayer() {
/* 585 */     List<Entity> list = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(16.0D, 16.0D, 16.0D));
/* 586 */     if (!list.isEmpty()) {
/*     */       
/* 588 */       Entity entityClosest = null;
/* 589 */       int rangeClosest = -1;
/* 590 */       for (int i = 0; i < list.size(); i++) {
/*     */         
/* 592 */         Entity entity = list.get(i);
/* 593 */         int range = (int)((entity != null && entity.func_70089_S()) ? entity.func_70032_d((Entity)this) : 0.0F);
/* 594 */         if (range > rangeClosest) {
/*     */           
/* 596 */           entityClosest = entity;
/* 597 */           rangeClosest = range;
/*     */         } 
/*     */       } 
/* 600 */       if (entityClosest != null) becomeAngryAt(entityClosest);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void becomeAngryAt(Entity entity) {
/* 606 */     this.field_70789_a = entity;
/* 607 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void becomeAngryAt2(Entity entity) {
/* 613 */     becomeAngryAt(entity);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttributes(int damage, int health, int AttPow, int HePo) {
/* 618 */     if (damage != AttPow || health != HePo) {
/*     */       
/* 620 */       getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", damage);
/* 621 */       getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", health);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getXZDistanceToEntity(Entity targetEntity) {
/* 628 */     double d0 = targetEntity.field_70165_t - this.field_70165_t; if (d0 < 0.0D) d0 *= -1.0D; 
/* 629 */     double d2 = targetEntity.field_70161_v - this.field_70161_v; if (d2 < 0.0D) d2 *= -1.0D; 
/* 630 */     return d0 + d2;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getYDistanceToEntity(Entity targetEntity) {
/* 635 */     double d1 = targetEntity.field_70163_u - this.field_70163_u; if (d1 < 0.0D) d1 *= -1.0D; 
/* 636 */     return d1;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getYDistanceToEntityWithClientDiff(Entity targetEntity) {
/* 641 */     boolean client = targetEntity.field_70170_p.field_72995_K;
/* 642 */     double posYTarget = targetEntity.field_70163_u - (client ? (JGRenderHelper.isClientPlayer(targetEntity) ? 1.6D : 0.0D) : 0.0D);
/* 643 */     double posY = this.field_70163_u - (client ? (JGRenderHelper.isClientPlayer((Entity)this) ? 1.6D : 0.0D) : 0.0D);
/* 644 */     double d1 = posYTarget - posY; if (d1 < 0.0D) d1 *= -1.0D; 
/* 645 */     return d1;
/*     */   }
/*     */   
/* 648 */   public boolean isJumping() { return this.field_70703_bu; } public void useJump() {
/* 649 */     func_70664_aZ();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double[] values(double... values) {
/* 656 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBattleStyle(double movementSpeed, double[] highJump, double[] dash, double[] flyingDash, double[] backawayKiCharge) {
/* 661 */     if (!DBCConfig.AaiDisabled) {
/*     */       
/* 663 */       if (movementSpeed != -1.0D) this.moveSpeed *= movementSpeed;
/*     */       
/* 665 */       this.aaiSystem = new AAiSystem((Entity)this, new AAi[0]);
/*     */       
/* 667 */       if (highJump != null)
/*     */       {
/* 669 */         this.aaiSystem.addAAi((AAi)new AAiDBCGroundJump(highJump));
/*     */       }
/*     */       
/* 672 */       if (dash != null)
/*     */       {
/* 674 */         this.aaiSystem.addAAi((AAi)new AAiDBCGroundDash(dash));
/*     */       }
/*     */       
/* 677 */       if (flyingDash != null && this.canFly)
/*     */       {
/* 679 */         this.aaiSystem.addAAi((AAi)new AAiDBCFlyingCharge(flyingDash));
/*     */       }
/*     */       
/* 682 */       if (backawayKiCharge != null && this.canFireKiAttacks) {
/*     */         
/* 684 */         this.aaiSystem.addAAi((AAi)new AAiDBCKiAttackCharge(backawayKiCharge));
/* 685 */         this.hasAAiKiChargeSystem = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/* 690 */   public void setEasyDifficulty() { setDifficulty(0); }
/* 691 */   public void setMediumDifficulty() { setDifficulty(1); }
/* 692 */   public void setHardDifficulty() { setDifficulty(2); } public void setInsaneDifficulty() {
/* 693 */     setDifficulty(3);
/*     */   }
/*     */   
/*     */   public void setDifficulty(int difficulty) {
/* 697 */     if (this.aaiSystem != null) {
/*     */       
/* 699 */       this.aaiSystem.aais.clear();
/*     */     }
/*     */     else {
/*     */       
/* 703 */       this.aaiSystem = new AAiSystem((Entity)this, new AAi[0]);
/*     */     } 
/*     */     
/* 706 */     if (DBCConfig.AaiForceDifficulty != -1) difficulty = DBCConfig.AaiForceDifficulty; 
/* 707 */     this.difficultyID = difficulty;
/*     */     
/* 709 */     setBattleStyle(JGConfigDBCAAiDifficulty.SpeedMulti[this.difficultyID], 
/*     */         
/* 711 */         values(new double[] {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             JGConfigDBCAAiDifficulty.JumpMulti[this.difficultyID], JGConfigDBCAAiDifficulty.JumpRate[this.difficultyID], JGConfigDBCAAiDifficulty.JumpMulti2[this.difficultyID], JGConfigDBCAAiDifficulty.JumpLimit[this.difficultyID], JGConfigDBCAAiDifficulty.JumpLimit2[this.difficultyID]
/* 720 */           }, ), values(new double[] {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             JGConfigDBCAAiDifficulty.GroundDashSpeedMulti[this.difficultyID], 1.0D, JGConfigDBCAAiDifficulty.GroundDashSpeedMulti2[this.difficultyID], JGConfigDBCAAiDifficulty.GroundDashLimit[this.difficultyID]
/* 728 */           }, ), values(new double[] {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             JGConfigDBCAAiDifficulty.FlyingDashMulti[this.difficultyID], 1.0D, JGConfigDBCAAiDifficulty.FlyingDashLimit[this.difficultyID]
/* 735 */           }, ), values(new double[] { JGConfigDBCAAiDifficulty.KiAttackChargeMulti[this.difficultyID], 0.1D, JGConfigDBCAAiDifficulty.KiAttackChargeLimit[this.difficultyID] }));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKiUsage(boolean canFly, boolean canFireKiAttacks) {
/* 781 */     this.canFly = canFly;
/* 782 */     this.canFireKiAttacks = canFireKiAttacks;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKiUsageAndDifficulty(boolean canFly, boolean canFireKiAttacks) {
/* 787 */     setKiUsageAndDifficulty(canFly, canFireKiAttacks, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKiUsageAndDifficulty(boolean canFly, boolean canFireKiAttacks, int difficulty) {
/* 792 */     setKiUsage(canFly, canFireKiAttacks);
/* 793 */     if (difficulty != -1) setDifficulty(difficulty); 
/*     */   }
/*     */   public boolean isLocked() {
/* 796 */     return (this.lockedBy != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAAiTeleport(int rateMin, int rateMax, String sound) {
/* 803 */     if (this.aaiSystem == null) this.aaiSystem = new AAiSystem((Entity)this, new AAi[0]); 
/* 804 */     this.aaiSystem.addAAi((AAi)new AAiDBCTeleport(rateMin, rateMax, sound));
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAAiTeleport(int rateMin, int rateMax) {
/* 809 */     if (this.aaiSystem == null) this.aaiSystem = new AAiSystem((Entity)this, new AAi[0]); 
/* 810 */     this.aaiSystem.addAAi((AAi)new AAiDBCTeleport(new int[] { rateMin, rateMax }));
/*     */   }
/*     */   
/*     */   public void addAAiTeleport() {
/* 814 */     if (this.aaiSystem == null) this.aaiSystem = new AAiSystem((Entity)this, new AAi[0]); 
/* 815 */     this.aaiSystem.addAAi((AAi)new AAiDBCTeleport(new int[] { JGConfigDBCAAiDifficulty.TeleportRateMin[this.difficultyID], JGConfigDBCAAiDifficulty.TeleportRateMax[this.difficultyID] }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAAiTeleport(String sound) {
/* 822 */     if (this.aaiSystem == null) this.aaiSystem = new AAiSystem((Entity)this, new AAi[0]); 
/* 823 */     this.aaiSystem.addAAi((AAi)new AAiDBCTeleport(JGConfigDBCAAiDifficulty.TeleportRateMin[this.difficultyID], JGConfigDBCAAiDifficulty.TeleportRateMax[this.difficultyID], sound));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource ds, float f) {
/* 833 */     boolean ret = super.func_70097_a(ds, f);
/* 834 */     Entity target = ds.func_76346_g();
/* 835 */     if (target != null && target.func_70089_S())
/*     */     {
/* 837 */       if (this.targetedEntity == null) {
/* 838 */         lookForTarget();
/*     */       }
/*     */     }
/* 841 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */