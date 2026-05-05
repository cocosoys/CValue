/*      */ package JinRyuu.JRMCore.entity;public class EntityEnergyAttJ extends EntityEnAttacks implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile { private int xTile; private int yTile; private int zTile; private Block inTile; private int inData;
/*      */   private boolean inGround;
/*      */   private int ticksInGround;
/*      */   private int ticksInAir;
/*      */   private double damage;
/*      */   private int knockbackStrength;
/*      */   private float explevel;
/*      */   private String DBCExplSound;
/*      */   private String NCExplSound;
/*      */   private float strtX;
/*      */   private float strtY;
/*      */   private float strtZ;
/*      */   private float trgtX;
/*      */   private float trgtY;
/*      */   private float trgtZ;
/*      */   private byte type;
/*      */   private byte speed;
/*      */   private int dam;
/*      */   private byte perc;
/*      */   private byte pmjID;
/*      */   private short effect;
/*      */   private int color;
/*      */   private byte density;
/*      */   private short sincantation;
/*      */   private short sfire;
/*      */   private short smove;
/*      */   private byte align;
/*      */   private float size;
/*      */   private int conn;
/*      */   private int waveCount;
/*      */   private byte wave;
/*      */   private Entity target;
/*      */   private int cost;
/*      */   private int costPerc;
/*      */   private int originDmg;
/*      */   public boolean shrink;
/*      */   private int pwrtyp;
/*      */   private String nameJutsu;
/*      */   private boolean givenExp;
/*      */   public double motionXStart;
/*      */   public double motionYStart;
/*      */   public double motionZStart;
/*      */   public float minScale;
/*      */   public float maxScale;
/*      */   public float maxDamage;
/*      */   public boolean added;
/*      */   public int animation_speed;
/*      */   public long animation_start;
/*      */   public int animation_id;
/*      */   public int animation_id_Max;
/*      */   public int animation_random_Max;
/*      */   public ArrayList<Integer> animation_random;
/*      */   public float render_scale;
/*      */   public float render_scale_max;
/*      */   public double dist;
/*      */   public boolean shooterHolds;
/*      */   public boolean hadTarget;
/*      */   public boolean added2;
/*      */   public long animation_start2;
/*      */   public float waveScale;
/*      */   public double finalDist;
/*      */   public int lastSegments;
/*      */   private boolean run;
/*      */   public float startRotationPitch;
/*      */   public float startRotationYaw;
/*      */   
/*   67 */   public float strtX() { return this.strtX; }
/*   68 */   public float strtY() { return this.strtY; }
/*   69 */   public float strtZ() { return this.strtZ; }
/*   70 */   public float trgtX() { return this.trgtX; }
/*   71 */   public float trgtY() { return this.trgtY; } public float trgtZ() {
/*   72 */     return this.trgtZ;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getScale() {
/*  117 */     float damage = this.originDmg;
/*  118 */     byte perc = getPerc();
/*  119 */     byte den = getDen();
/*      */ 
/*      */     
/*  122 */     float scale = JRMCoreH.calculateEnergyScale(damage, this.maxDamage, perc, null, den, this.minScale, this.maxScale);
/*  123 */     return scale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setScales() {
/*  130 */     this.minScale = (float)JRMCoreConfig.JutsuSizeMin[getType()];
/*  131 */     this.maxScale = (float)JRMCoreConfig.JutsuSizeMax[getType()];
/*  132 */     this.maxDamage = JRMCoreH.getMaxEnergyDamage();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float setScalesPost() {
/*  138 */     if (isWave()) return 100.0F; 
/*  139 */     if (isBlast()) return 5.0F; 
/*  140 */     if (isDisk()) return 5.0F; 
/*  141 */     return 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSize() {
/*  159 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void shrinkWave() {
/*  171 */     JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
/*  172 */     if (!this.shrink)
/*      */     {
/*  174 */       shrink();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void shrink() {
/*  180 */     this.shrink = true;
/*  181 */     func_70096_w().func_75692_b(20, Integer.valueOf(1));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isContinuesWave() {
/*  186 */     return (getType() >= JRMCoreConfig.ContinuesJutsuAttacks.length) ? false : JRMCoreConfig.ContinuesJutsuAttacks[getType()];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getShrink() {
/*  193 */     return func_70096_w().func_75679_c(20);
/*  194 */   } public byte getType() { return this.type; }
/*  195 */   public int getCol() { return this.color; }
/*  196 */   public byte getSpe() { return this.speed; }
/*  197 */   public int getDam() { return this.dam; }
/*  198 */   public byte getDen() { return this.density; }
/*  199 */   public byte getPerc() { return this.perc; }
/*  200 */   public float getSizePerc() { return this.size; }
/*  201 */   public int getAirTicks() { return this.ticksInAir; } public short getEff() {
/*  202 */     return this.effect;
/*      */   } public void setAirTicks(int i) {
/*  204 */     this.ticksInAir = i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityEnergyAttJ(World par1World)
/*      */   {
/*  211 */     super(par1World);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.xTile = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.yTile = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.zTile = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.inData = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.inGround = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.ticksInAir = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.damage = 1.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.DBCExplSound = "jinryuudragonbc:DBC.expl";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.NCExplSound = "jinryuunarutoc:NC1.Explosion";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.trgtX = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.trgtY = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.trgtZ = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.waveCount = 20;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.wave = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.shrink = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.pwrtyp = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.givenExp = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.added = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_speed = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_start = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_id = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_id_Max = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_random_Max = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_random = new ArrayList<Integer>();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.render_scale = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.render_scale_max = 2.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.dist = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.hadTarget = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.added2 = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_start2 = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.waveScale = 1.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.finalDist = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.lastSegments = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.run = true;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  403 */     this.startRotationPitch = 0.0F;
/*  404 */     this.startRotationYaw = 0.0F; func_70105_a(this.size, this.size); } public EntityEnergyAttJ(EntityLivingBase par2EntityLivingBase, byte type, float speed, int dam, byte effect, byte color, byte density, byte sincantation, byte sfire, byte smove, byte perc, int dam1, int cost, int costPerc) { super(par2EntityLivingBase.field_70170_p); float size1; Vec3 vec3; this.xTile = -1; this.yTile = -1; this.zTile = -1; this.inData = 0; this.inGround = false; this.ticksInAir = 0; this.damage = 1.0D; this.DBCExplSound = "jinryuudragonbc:DBC.expl"; this.NCExplSound = "jinryuunarutoc:NC1.Explosion"; this.trgtX = 0.0F; this.trgtY = 0.0F; this.trgtZ = 0.0F; this.waveCount = 20; this.wave = 0; this.shrink = false; this.pwrtyp = 0; this.givenExp = false; this.added = false; this.animation_speed = 0; this.animation_start = 0L; this.animation_id = 0; this.animation_id_Max = 0; this.animation_random_Max = 0; this.animation_random = new ArrayList<Integer>(); this.render_scale = 0.0F; this.render_scale_max = 2.0F; this.dist = 0.0D; this.hadTarget = false; this.added2 = false; this.animation_start2 = 0L; this.waveScale = 1.0F; this.finalDist = 0.0D; this.lastSegments = 0; this.run = true; this.startRotationPitch = 0.0F; this.startRotationYaw = 0.0F; this.type = type; this.shooterHolds = isContinuesWave(); this.speed = (byte)(int)((speed + 1.0F) * 10.0F + ((type == 2) ? 10 : false) + ((density == 2) ? 40 : false)); this.dam = dam; this.perc = 50; this.effect = (short)effect; this.color = JRMCoreH.techNCCol[effect]; this.density = density; this.sincantation = (short)sincantation; this.sfire = (short)sfire; this.smove = (short)smove; this.cost = cost; this.costPerc = costPerc; this.originDmg = dam1; this.pmjID = perc; if (this.pmjID != -1)
/*      */       this.nameJutsu = JRMCoreH.trl("nc", JRMCoreH.pmj[this.pmjID][0]);  this.damage = this.dam * this.perc * 0.019999999552965164D; if (getType() < 3) { setScales(); size1 = getScale(); } else { size1 = 1.0F; }  this.size = 0.5F + size1; if (JRMCoreConfig.JutsuScalesWithUser)
/*      */       this.size *= (this.shootingEntity == null) ? 1.0F : (this.shootingEntity.field_70131_O / 1.8F);  this.shootingEntity = (Entity)par2EntityLivingBase; this.pwrtyp = 0; if (this.shootingEntity instanceof EntityPlayer)
/*      */       this.pwrtyp = JRMCoreH.PlyrPwr((EntityPlayer)this.shootingEntity);  this.explevel = effect; this.field_70155_l = 10.0D; func_70105_a(this.size, this.size); double d8 = (par2EntityLivingBase.field_70130_N + 1.0F + 0.3F); double d9 = (((EntityLivingBase)this.shootingEntity).field_70131_O + ((EntityLivingBase)this.shootingEntity).field_70131_O * 0.2F); if (this.shootingEntity instanceof EntityPlayer) { vec3 = this.shootingEntity.func_70040_Z(); } else { float rotationYaw = this.shootingEntity.func_70079_am(), rotationPitch = this.shootingEntity.field_70125_A; float vx = -MathHelper.func_76126_a(rad(rotationYaw)) * MathHelper.func_76134_b(rad(rotationPitch)); float vz = MathHelper.func_76134_b(rad(rotationYaw)) * MathHelper.func_76134_b(rad(rotationPitch)); float vy = -MathHelper.func_76126_a(rad(rotationPitch)); vec3 = Vec3.func_72443_a(vx, vy, vz); }
/*      */      double x = par2EntityLivingBase.field_70165_t + vec3.field_72450_a * d8; double y = par2EntityLivingBase.field_70163_u + vec3.field_72448_b * d8 + (par2EntityLivingBase.field_70131_O * 0.7F); double z = par2EntityLivingBase.field_70161_v + vec3.field_72449_c * d8; func_70012_b(x, y, z, par2EntityLivingBase.field_70177_z, par2EntityLivingBase.field_70125_A); this.field_70129_M = this.size * 0.5F; this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F)); this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F)); this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F); func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.speed * 0.05F, 1.0F); this.strtX = (float)x; this.strtY = (float)y; this.strtZ = (float)z; this.motionXStart = this.field_70159_w; this.motionYStart = this.field_70181_x; this.motionZStart = this.field_70179_y; }
/*  409 */   protected void func_70088_a() { this.field_70180_af.func_75682_a(20, Integer.valueOf(0)); } public void func_70071_h_() { if ((JGConfigClientSettings.configsChanged || this.run) && this.field_70170_p.field_72995_K && !this.field_70128_L) this.field_70158_ak = JGConfigClientSettings.renderEnergyOutsideView;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  416 */     if (isContinuesWave() && this.shooterHolds)
/*      */     {
/*  418 */       generateParticles(this, this.shootingEntity, this.color, true);
/*      */     }
/*  420 */     generateParticles(this, this, this.color, false);
/*      */ 
/*      */ 
/*      */     
/*  424 */     if (!this.run) {
/*      */       
/*  426 */       if (this.field_70125_A != this.startRotationPitch) this.field_70125_A = this.startRotationPitch; 
/*  427 */       if (this.field_70177_z != this.startRotationYaw) this.field_70177_z = this.startRotationYaw;
/*      */     
/*      */     } 
/*      */     
/*  431 */     boolean ROTATION_RELATED = true;
/*      */ 
/*      */     
/*  434 */     if (this.run) {
/*      */       
/*  436 */       this.startRotationPitch = this.field_70125_A;
/*  437 */       this.startRotationYaw = this.field_70177_z;
/*  438 */       this.shooterHolds = isContinuesWave();
/*  439 */       if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) {
/*      */         
/*  441 */         EntityPlayer player = (EntityPlayer)this.shootingEntity;
/*  442 */         ExtendedPlayer.get(player).setAnimKiShootOn(0);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  448 */       this.run = false;
/*      */     } 
/*      */ 
/*      */     
/*  452 */     if (!this.field_70170_p.field_72995_K && isContinuesWave() && this.target != null && !this.target.field_70128_L && !this.shooterHolds && 
/*  453 */       JGMathHelper.isMotionSmallerThanN(this, 0.001D))
/*      */     {
/*  455 */       func_70106_y();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  461 */     if (JRMCoreConfig.WavesShrinkOnceLetGo) {
/*      */       
/*  463 */       if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && isContinuesWave() && this.shooterHolds)
/*      */       {
/*  465 */         double d8 = (((EntityLivingBase)this.shootingEntity).field_70130_N + 1.0F + 0.3F);
/*  466 */         double d9 = (((EntityLivingBase)this.shootingEntity).field_70131_O + ((EntityLivingBase)this.shootingEntity).field_70131_O * 0.2F);
/*  467 */         Vec3 vec3 = this.shootingEntity.func_70040_Z();
/*      */         
/*  469 */         double x = this.shootingEntity.field_70165_t + vec3.field_72450_a * d8;
/*      */         
/*  471 */         double y = this.shootingEntity.field_70163_u + vec3.field_72448_b * d8 + (this.shootingEntity.field_70131_O * 0.7F) + (this.field_70170_p.field_72995_K ? JGPlayerClientServerHelper.clientPlayerPositioner(this.shootingEntity) : 0.0F);
/*      */         
/*  473 */         double z = this.shootingEntity.field_70161_v + vec3.field_72449_c * d8;
/*      */         
/*  475 */         if (x < 0.0D) x *= -1.0D; 
/*  476 */         if (y < 0.0D) y *= -1.0D; 
/*  477 */         if (z < 0.0D) z *= -1.0D;
/*      */         
/*  479 */         double kiX = this.strtX; if (kiX < 0.0D) kiX *= -1.0D; 
/*  480 */         double kiY = this.strtY; if (kiY < 0.0D) kiY *= -1.0D; 
/*  481 */         double kiZ = this.strtZ; if (kiZ < 0.0D) kiZ *= -1.0D;
/*      */ 
/*      */         
/*  484 */         double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D; 
/*  485 */         double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D; 
/*  486 */         double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;
/*      */         
/*  488 */         float DEAD_DIFFERENCE = 0.2F;
/*  489 */         float DEAD_DIFFERENCE2 = 1.0F;
/*      */         
/*  491 */         if (kulx > 0.20000000298023224D || kuly > 1.0D || kulz > 0.20000000298023224D)
/*      */         {
/*  493 */           this.shooterHolds = false;
/*  494 */           EntityPlayer player = (EntityPlayer)this.shootingEntity;
/*  495 */           ExtendedPlayer.get(player).setAnimKiShoot(0);
/*  496 */           if (!this.field_70170_p.field_72995_K)
/*      */           {
/*  498 */             JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
/*  499 */             shrinkWave();
/*      */           
/*      */           }
/*      */           else
/*      */           {
/*  504 */             JRMCoreH.isShtng = false;
/*      */           
/*      */           }
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  515 */     else if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && isContinuesWave() && this.shooterHolds) {
/*      */       
/*  517 */       double x = this.strtX;
/*  518 */       double y = this.strtY;
/*  519 */       double z = this.strtZ;
/*      */       
/*  521 */       if (x < 0.0D) x *= -1.0D; 
/*  522 */       if (y < 0.0D) y *= -1.0D; 
/*  523 */       if (z < 0.0D) z *= -1.0D;
/*      */       
/*  525 */       double kiX = this.shootingEntity.field_70165_t; if (kiX < 0.0D) kiX *= -1.0D;
/*      */       
/*  527 */       double kiY = this.shootingEntity.field_70163_u + (this.field_70170_p.field_72995_K ? JGPlayerClientServerHelper.clientPlayerPositioner(this.shootingEntity) : 0.0F); if (kiY < 0.0D) kiY *= -1.0D; 
/*  528 */       double kiZ = this.shootingEntity.field_70161_v; if (kiZ < 0.0D) kiZ *= -1.0D;
/*      */ 
/*      */       
/*  531 */       double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D; 
/*  532 */       double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D; 
/*  533 */       double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;
/*      */       
/*  535 */       float DEAD_DIFFERENCE = 3.0F;
/*      */ 
/*      */       
/*  538 */       if (kulx > 3.0D || kuly > 3.0D || kulz > 3.0D) {
/*      */         
/*  540 */         this.shooterHolds = false;
/*  541 */         EntityPlayer player = (EntityPlayer)this.shootingEntity;
/*  542 */         ExtendedPlayer.get(player).setAnimKiShoot(0);
/*  543 */         if (!this.field_70170_p.field_72995_K) {
/*      */           
/*  545 */           JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */           
/*  551 */           JRMCoreH.isShtng = false;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  561 */     if (!this.field_70170_p.field_72995_K && isContinuesWave() && JRMCoreConfig.ContinuesEnergyAttackEnemyLock && this.target != null && !this.target.field_70128_L && this.shooterHolds) {
/*      */       
/*  563 */       double x = this.field_70165_t;
/*  564 */       double y = this.field_70163_u;
/*  565 */       double z = this.field_70161_v;
/*      */       
/*  567 */       if (x < 0.0D) x *= -1.0D; 
/*  568 */       if (y < 0.0D) y *= -1.0D; 
/*  569 */       if (z < 0.0D) z *= -1.0D;
/*      */       
/*  571 */       double kiX = this.target.field_70165_t; if (kiX < 0.0D) kiX *= -1.0D; 
/*  572 */       double kiY = this.target.field_70163_u; if (kiY < 0.0D) kiY *= -1.0D; 
/*  573 */       double kiZ = this.target.field_70161_v; if (kiZ < 0.0D) kiZ *= -1.0D;
/*      */ 
/*      */       
/*  576 */       double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D; 
/*  577 */       double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D; 
/*  578 */       double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;
/*      */       
/*  580 */       float DEAD_DIFFERENCE = 0.5F;
/*      */ 
/*      */       
/*  583 */       if (kulx > 0.5D || kuly > 0.5D || kulz > 0.5D) {
/*      */ 
/*      */         
/*  586 */         this.target.field_70165_t = x;
/*  587 */         this.target.field_70163_u = y;
/*  588 */         this.target.field_70161_v = z;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  593 */         this.target.field_70165_t = this.field_70165_t;
/*  594 */         this.target.field_70163_u = this.field_70163_u;
/*  595 */         this.target.field_70161_v = this.field_70161_v;
/*      */         
/*  597 */         this.target.field_70159_w = this.field_70159_w;
/*  598 */         this.target.field_70181_x = this.field_70181_x;
/*  599 */         this.target.field_70179_y = this.field_70179_y;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  605 */     if (!this.field_70170_p.field_72995_K && isContinuesWave() && JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown && JRMCoreConfig.ContinuesEnergyAttackMoveOnLostTarget && this.target != null && !this.target.field_70128_L && this.shooterHolds && 
/*  606 */       JGMathHelper.isMotionSmallerThanN(this, 0.001D)) {
/*      */       
/*  608 */       double x = this.field_70165_t;
/*  609 */       double y = this.field_70163_u;
/*  610 */       double z = this.field_70161_v;
/*      */       
/*  612 */       if (x < 0.0D) x *= -1.0D; 
/*  613 */       if (y < 0.0D) y *= -1.0D; 
/*  614 */       if (z < 0.0D) z *= -1.0D;
/*      */       
/*  616 */       double kiX = this.target.field_70165_t; if (kiX < 0.0D) kiX *= -1.0D; 
/*  617 */       double kiY = this.target.field_70163_u; if (kiY < 0.0D) kiY *= -1.0D; 
/*  618 */       double kiZ = this.target.field_70161_v; if (kiZ < 0.0D) kiZ *= -1.0D;
/*      */ 
/*      */       
/*  621 */       double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D; 
/*  622 */       double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D; 
/*  623 */       double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;
/*      */       
/*  625 */       float DEAD_DIFFERENCE = this.size + 1.0F;
/*      */ 
/*      */       
/*  628 */       if (kulx > DEAD_DIFFERENCE || kuly > DEAD_DIFFERENCE || kulz > DEAD_DIFFERENCE) {
/*      */         
/*  630 */         this.target = null;
/*  631 */         this.hadTarget = false;
/*      */         
/*  633 */         this.field_70159_w = this.motionXStart;
/*  634 */         this.field_70181_x = this.motionYStart;
/*  635 */         this.field_70179_y = this.motionZStart;
/*      */       } 
/*      */     } 
/*      */     
/*  639 */     if (!this.field_70170_p.field_72995_K && JRMCoreConfig.WavesDieWhenTargetAway && this.shootingEntity != null && this.target != null && this.shootingEntity instanceof EntityPlayer && isContinuesWave()) {
/*      */       
/*  641 */       double x = this.field_70165_t;
/*  642 */       double y = this.field_70163_u;
/*  643 */       double z = this.field_70161_v;
/*      */ 
/*      */ 
/*      */       
/*  647 */       if (x < 0.0D) x *= -1.0D; 
/*  648 */       if (y < 0.0D) y *= -1.0D; 
/*  649 */       if (z < 0.0D) z *= -1.0D;
/*      */       
/*  651 */       double kiX = this.target.field_70165_t; if (kiX < 0.0D) kiX *= -1.0D; 
/*  652 */       double kiY = this.target.field_70163_u; if (kiY < 0.0D) kiY *= -1.0D; 
/*  653 */       double kiZ = this.target.field_70161_v; if (kiZ < 0.0D) kiZ *= -1.0D;
/*      */ 
/*      */       
/*  656 */       double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D; 
/*  657 */       double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D; 
/*  658 */       double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;
/*      */       
/*  660 */       float DEAD_DIFFERENCE = this.size + 1.0F;
/*      */ 
/*      */       
/*  663 */       if (kulx > DEAD_DIFFERENCE || kuly > DEAD_DIFFERENCE || kulz > DEAD_DIFFERENCE) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  671 */         if (this.type >= 0 && this.type < 2) {
/*  672 */           if (this.field_70131_O > 1.5F)
/*      */           {
/*  674 */             createExplosion(0);
/*      */           }
/*  676 */           this.field_70170_p.func_72956_a(this, (this.pwrtyp == 1) ? this.DBCExplSound : ((this.pwrtyp == 2) ? this.NCExplSound : ""), 1.0F, 1.0F);
/*      */         } 
/*      */ 
/*      */         
/*  680 */         func_70106_y();
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  701 */     if (!this.field_70170_p.field_72995_K && this.shootingEntity == null)
/*      */     {
/*      */       
/*  704 */       func_70106_y();
/*      */     }
/*      */     
/*  707 */     if (!this.field_70170_p.field_72995_K && this.shootingEntity == null) func_70106_y();
/*      */     
/*  709 */     if (!this.field_70170_p.field_72995_K && isContinuesWave() && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) {
/*      */       
/*  711 */       byte b = JRMCoreH.getByte((EntityPlayer)this.shootingEntity, "jrmcFrng");
/*      */       
/*  713 */       if (b == 0 && !this.shrink && JRMCoreConfig.WavesShrinkOnceLetGo)
/*      */       {
/*  715 */         shrink();
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  725 */     if (!this.field_70170_p.field_72995_K && isContinuesWave() && this.hadTarget && (this.target == null || this.target.field_70128_L))
/*      */     {
/*  727 */       func_70106_y();
/*      */     }
/*      */     
/*  730 */     if (isContinuesWave() && this.target != null)
/*      */     {
/*  732 */       if (JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown) {
/*      */         
/*  734 */         this.field_70159_w *= 0.05000000074505806D;
/*  735 */         this.field_70181_x *= 0.05000000074505806D;
/*  736 */         this.field_70179_y *= 0.05000000074505806D;
/*      */         
/*  738 */         this.target.field_70159_w *= 0.05000000074505806D;
/*  739 */         this.target.field_70181_x *= 0.05000000074505806D;
/*  740 */         this.target.field_70179_y *= 0.05000000074505806D;
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */         
/*  748 */         this.target.field_70159_w = this.field_70159_w;
/*  749 */         this.target.field_70181_x = this.field_70181_x;
/*  750 */         this.target.field_70179_y = this.field_70179_y;
/*      */         
/*  752 */         this.target.field_70165_t = this.field_70165_t;
/*  753 */         this.target.field_70163_u = this.field_70163_u;
/*  754 */         this.target.field_70161_v = this.field_70161_v;
/*      */       } 
/*      */     }
/*      */     
/*  758 */     if (this.field_70173_aa == 1) {
/*      */       
/*  760 */       func_70105_a(this.size, this.size);
/*  761 */       this.field_70129_M = this.size * 0.5F;
/*      */     } 
/*      */     
/*  764 */     super.func_70071_h_();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  769 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*      */       
/*  771 */       float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  772 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/*  773 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0D / Math.PI);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  780 */     Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/*      */     
/*  782 */     if (block.func_149688_o() != Material.field_151579_a) {
/*      */       
/*  784 */       block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*  785 */       AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
/*      */       
/*  787 */       if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)))
/*      */       {
/*  789 */         this.inGround = true;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  796 */     if (this.inGround) {
/*      */       
/*  798 */       int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/*      */       
/*  800 */       if (block == this.inTile && var19 == this.inData) {
/*      */         
/*  802 */         this.ticksInGround++;
/*  803 */         if (this.ticksInGround == 1) {
/*      */           
/*  805 */           func_70106_y();
/*      */           
/*  807 */           if (!this.field_70170_p.field_72995_K) {
/*      */             
/*  809 */             if (this.type >= 0 && this.type < 2) {
/*  810 */               if (this.field_70131_O > 1.5F)
/*      */               {
/*  812 */                 createExplosion(0);
/*      */               }
/*      */               
/*  815 */               this.field_70170_p.func_72956_a(this, (this.pwrtyp == 1) ? this.DBCExplSound : ((this.pwrtyp == 2) ? this.NCExplSound : ""), 1.0F, 1.0F);
/*      */             } 
/*  817 */             if (this.density == 2) {
/*  818 */               EntityPlayer shtr = (EntityPlayer)this.shootingEntity;
/*  819 */               shtr.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + this.nameJutsu + " failed!"));
/*      */             }
/*      */           
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/*  826 */         this.inGround = false;
/*  827 */         this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/*  828 */         this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/*  829 */         this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/*  830 */         this.ticksInGround = 0;
/*  831 */         this.ticksInAir = 0;
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  837 */       this.ticksInAir++;
/*  838 */       Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  839 */       Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*  840 */       MovingObjectPosition var4 = this.field_70170_p.func_147447_a(var17, var3, false, true, false);
/*  841 */       var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  842 */       var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*      */ 
/*      */ 
/*      */       
/*  846 */       if (!this.field_70170_p.field_72995_K && (this.ticksInAir >= JRMCoreConfig.EnergyAttackMaxLifeTickPercMulti * this.perc * 0.02F || this.ticksInAir >= JRMCoreConfig.EnergyAttackMaxLifeTick))
/*      */       {
/*      */ 
/*      */ 
/*      */         
/*  851 */         func_70106_y();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  858 */       if (var4 != null)
/*      */       {
/*  860 */         var3 = Vec3.func_72443_a(var4.field_72307_f.field_72450_a, var4.field_72307_f.field_72448_b, var4.field_72307_f.field_72449_c);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  866 */       if (!this.field_70170_p.field_72995_K) {
/*      */         
/*  868 */         Entity var5 = null;
/*  869 */         List<Entity> var6 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D));
/*  870 */         double var7 = 0.0D;
/*      */ 
/*      */         
/*  873 */         for (int var9 = 0; var9 < var6.size(); var9++) {
/*      */           
/*  875 */           Entity var10 = var6.get(var9);
/*      */           
/*  877 */           if (var10.func_70067_L() && (var10 != this.shootingEntity || this.ticksInAir >= 5)) {
/*      */             
/*  879 */             float f = 0.0F;
/*  880 */             AxisAlignedBB var12 = var10.field_70121_D.func_72314_b(f, f, f);
/*  881 */             MovingObjectPosition var13 = var12.func_72327_a(var17, var3);
/*      */             
/*  883 */             if (var13 != null) {
/*      */               
/*  885 */               double var14 = var17.func_72438_d(var13.field_72307_f);
/*      */               
/*  887 */               if (var14 < var7 || var7 == 0.0D) {
/*      */                 
/*  889 */                 var5 = var10;
/*  890 */                 var7 = var14;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  896 */         if (var5 != null)
/*      */         {
/*  898 */           var4 = new MovingObjectPosition(var5);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  903 */       if (this.field_70159_w <= 0.01D && this.field_70181_x <= 0.01D && this.field_70179_y <= 0.01D && this.field_70159_w >= -0.01D && this.field_70181_x >= -0.01D && this.field_70179_y >= -0.01D)
/*      */       {
/*  905 */         if (!this.shrink && !isContinuesWave())
/*      */         {
/*  907 */           shrink();
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  914 */       if (!this.field_70170_p.field_72995_K) {
/*      */         
/*  916 */         Entity var5 = null;
/*  917 */         AxisAlignedBB aabb = this.field_70121_D.func_72329_c();
/*  918 */         List<Entity> var6 = this.field_70170_p.func_72839_b(this, aabb);
/*      */         
/*  920 */         for (int var9 = 0; var9 < var6.size(); var9++) {
/*      */           
/*  922 */           Entity var10 = var6.get(var9);
/*  923 */           if (var10 != this.shootingEntity)
/*      */           {
/*  925 */             if (isContinuesWave() && var10 instanceof EntityLivingBase) {
/*      */               
/*  927 */               if (var4 == null)
/*      */               {
/*  929 */                 var4 = new MovingObjectPosition(var10);
/*      */               }
/*  931 */               if (this.target == null)
/*      */               {
/*  933 */                 this.target = var10;
/*      */               
/*      */               }
/*      */             }
/*  937 */             else if (isContinuesWave() && this.wave > 0 && this.shootingEntity instanceof EntityPlayer) {
/*      */               
/*  939 */               shrinkWave();
/*      */ 
/*      */ 
/*      */             
/*      */             }
/*  944 */             else if (!(var10 instanceof EntityEnAttacks) && var10 != this.shootingEntity) {
/*      */               
/*  946 */               if (this.type >= 0 && this.type < 2 && this.field_70131_O > 1.5F)
/*      */               {
/*  948 */                 createExplosion(0);
/*  949 */                 func_70106_y();
/*      */               }
/*      */             
/*  952 */             } else if (var10 instanceof EntityEnergyAttJ) {
/*  953 */               EntityEnergyAttJ t = (EntityEnergyAttJ)var10;
/*  954 */               int d = (int)t.getDamage();
/*  955 */               int eff = t.getEff();
/*      */               
/*  957 */               int ad = JRMCoreH.cbadmg(this.effect, this.dam, eff, d);
/*  958 */               int td = JRMCoreH.cbtdmg(this.effect, this.dam, eff, d);
/*  959 */               if (ad == td) func_70106_y(); 
/*  960 */               if (td == 0) { t.func_70106_y(); } else { t.setDamage(td); }
/*      */               
/*  962 */               float dam = (float)(t.getDamage() / 2.0D);
/*  963 */               float spe = t.getSpe() * 2.0F;
/*  964 */               float den = t.getDen() * 10.0F;
/*  965 */               float damt = (float)(this.damage / 2.0D);
/*  966 */               float spet = this.speed * 2.0F;
/*  967 */               float dent = this.density * 10.0F;
/*      */               
/*  969 */               float power = damt - dam + spe - spet + dent - den;
/*  970 */               float calc = 1.0F - power * 0.01F;
/*  971 */               if (this.conn == 0) this.conn++; 
/*  972 */               if (this.conn == 1) {
/*  973 */                 if (power > 0.0F) {
/*  974 */                   float res = ((damt - dam) / damt + (spe - spet) / spe + (dent - den) / dent) / 3.0F;
/*  975 */                   this.field_70159_w *= res;
/*  976 */                   this.field_70181_x *= res;
/*  977 */                   this.field_70179_y *= res;
/*  978 */                   t.field_70159_w = this.field_70159_w;
/*  979 */                   t.field_70181_x = this.field_70181_x;
/*  980 */                   t.field_70179_y = this.field_70179_y;
/*  981 */                   int exp = (t.getAirTicks() < this.ticksInAir) ? t.getAirTicks() : this.ticksInAir;
/*  982 */                   if (t.getAirTicks() < this.ticksInAir)
/*  983 */                     this.ticksInAir = t.getAirTicks(); 
/*      */                 } 
/*  985 */                 this.conn = 2;
/*      */               }
/*      */             
/*      */             }
/*  989 */             else if (var10 instanceof EntityEnergyAttJ2) {
/*  990 */               EntityEnergyAttJ2 t = (EntityEnergyAttJ2)var10;
/*  991 */               int d = (int)t.getDamage();
/*  992 */               int eff = t.getEff();
/*      */               
/*  994 */               int ad = JRMCoreH.cbadmg(this.effect, this.dam, eff, d);
/*  995 */               int td = JRMCoreH.cbtdmg(this.effect, this.dam, eff, d);
/*  996 */               if (ad == td) func_70106_y(); 
/*  997 */               if (td == 0) { t.func_70106_y(); } else { t.setDamage(td); }
/*      */ 
/*      */               
/* 1000 */               float dam = (float)(t.getDamage() / 2.0D);
/* 1001 */               float spe = t.getSpe() * 2.0F;
/* 1002 */               float den = t.getDen() * 10.0F;
/* 1003 */               float damt = (float)(this.damage / 2.0D);
/* 1004 */               float spet = this.speed * 2.0F;
/* 1005 */               float dent = this.density * 10.0F;
/*      */               
/* 1007 */               float power = damt - dam + spe - spet + dent - den;
/* 1008 */               float calc = 1.0F - power * 0.01F;
/* 1009 */               if (this.conn == 0) this.conn++; 
/* 1010 */               if (this.conn == 1) {
/* 1011 */                 if (power > 0.0F) {
/* 1012 */                   float res = ((damt - dam) / damt + (spe - spet) / spe + (dent - den) / dent) / 3.0F;
/* 1013 */                   this.field_70159_w *= res;
/* 1014 */                   this.field_70181_x *= res;
/* 1015 */                   this.field_70179_y *= res;
/* 1016 */                   t.field_70159_w = this.field_70159_w;
/* 1017 */                   t.field_70181_x = this.field_70181_x;
/* 1018 */                   t.field_70179_y = this.field_70179_y;
/* 1019 */                   int exp = (t.getAirTicks() < this.ticksInAir) ? t.getAirTicks() : this.ticksInAir;
/* 1020 */                   if (t.getAirTicks() < this.ticksInAir)
/* 1021 */                     this.ticksInAir = t.getAirTicks(); 
/*      */                 } 
/* 1023 */                 this.conn = 2;
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1030 */       if (var4 != null && var4.field_72308_g != this.shootingEntity)
/*      */       {
/*      */         
/* 1033 */         if (var4.field_72308_g != null && (this.shootingEntity instanceof EntityPlayer || var4.field_72308_g instanceof EntityPlayer) && isContinuesWave() && this.shooterHolds) {
/*      */           
/* 1035 */           if (this.shootingEntity instanceof EntityPlayer) {
/*      */             
/* 1037 */             this.trgtX = (float)this.field_70165_t;
/* 1038 */             this.trgtY = (float)this.field_70163_u;
/* 1039 */             this.trgtZ = (float)this.field_70161_v;
/*      */             
/* 1041 */             byte b = JRMCoreH.getByte((EntityPlayer)this.shootingEntity, "jrmcFrng");
/* 1042 */             if (b == 1) {
/*      */               
/* 1044 */               if (this.target != null) {
/*      */                 
/* 1046 */                 if (this.waveCount == 20) {
/*      */                   
/* 1048 */                   this.wave = (byte)(this.wave + 1);
/* 1049 */                   if (JRMCoreConfig.ContinuesEnergyAttackTimer == 0 && this.wave > 2) this.wave = 2; 
/* 1050 */                   if (!this.field_70170_p.field_72995_K) {
/*      */                     
/* 1052 */                     EntityPlayer Player = (EntityPlayer)this.shootingEntity;
/* 1053 */                     byte curRel = JRMCoreH.getByte(Player, "jrmcRelease");
/* 1054 */                     int curEn = JRMCoreH.getInt(Player, "jrmcEnrgy");
/* 1055 */                     float cost2 = (float)(this.cost * curRel * 0.009999999776482582D * (this.perc * 0.02F));
/* 1056 */                     if (curEn - cost2 <= 0.0F)
/*      */                     {
/*      */                       
/* 1059 */                       func_70106_y();
/*      */                     }
/* 1061 */                     if (cost2 < curEn) {
/*      */                       
/* 1063 */                       if (!JRMCoreH.isInCreativeMode(this.shootingEntity)) JRMCoreH.setInt(curEn - cost2, Player, "jrmcEnrgy"); 
/* 1064 */                       this.damage = this.originDmg * curRel * 0.009999999776482582D * this.perc * 0.019999999552965164D * JRMCoreConfig.dat5696[this.type][1];
/*      */                     
/*      */                     }
/*      */                     else {
/*      */                       
/* 1069 */                       func_70106_y();
/*      */                     } 
/*      */                   } 
/*      */                   
/* 1073 */                   int var23 = (int)this.damage;
/* 1074 */                   DamageSource damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity);
/*      */                   
/* 1076 */                   if (this.target.func_70097_a(damagesource, var23));
/*      */ 
/*      */                   
/* 1079 */                   if (JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown) {
/*      */                     
/* 1081 */                     this.field_70159_w *= 0.05000000074505806D;
/* 1082 */                     this.field_70181_x *= 0.05000000074505806D;
/* 1083 */                     this.field_70179_y *= 0.05000000074505806D;
/*      */                     
/* 1085 */                     this.target.field_70159_w *= 0.05000000074505806D;
/* 1086 */                     this.target.field_70181_x *= 0.05000000074505806D;
/* 1087 */                     this.target.field_70179_y *= 0.05000000074505806D;
/*      */                   }
/*      */                   else {
/*      */                     
/* 1091 */                     this.target.field_70159_w = this.field_70159_w;
/* 1092 */                     this.target.field_70181_x = this.field_70181_x;
/* 1093 */                     this.target.field_70179_y = this.field_70179_y;
/*      */                     
/* 1095 */                     this.target.field_70165_t = this.field_70165_t;
/* 1096 */                     this.target.field_70163_u = this.field_70163_u;
/* 1097 */                     this.target.field_70161_v = this.field_70161_v;
/*      */                   } 
/*      */                 } 
/*      */                 
/* 1101 */                 this.target.field_70159_w = this.field_70159_w;
/* 1102 */                 this.target.field_70181_x = this.field_70181_x;
/* 1103 */                 this.target.field_70179_y = this.field_70179_y;
/*      */               } 
/*      */               
/* 1106 */               this.waveCount--;
/*      */               
/* 1108 */               if (this.waveCount <= 0)
/*      */               {
/* 1110 */                 this.waveCount = 20;
/*      */               }
/*      */               
/* 1113 */               if (JRMCoreConfig.ContinuesEnergyAttackTimer > 0)
/*      */               {
/* 1115 */                 if (this.wave >= JRMCoreConfig.ContinuesEnergyAttackTimer)
/*      */                 {
/*      */                   
/* 1118 */                   func_70106_y();
/*      */                 }
/*      */               }
/*      */             }
/*      */             else {
/*      */               
/* 1124 */               shrinkWave();
/*      */             } 
/*      */           } 
/*      */           
/* 1128 */           if (var4.field_72308_g instanceof EntityLivingBase)
/*      */           {
/* 1130 */             setTarget(var4.field_72308_g);
/*      */           }
/*      */           else
/*      */           {
/* 1134 */             shrinkWave();
/*      */           
/*      */           }
/*      */ 
/*      */         
/*      */         }
/* 1140 */         else if (var4.field_72308_g != null && isContinuesWave()) {
/*      */           
/* 1142 */           if (var4.field_72308_g instanceof EntityLivingBase) {
/* 1143 */             this.target = var4.field_72308_g;
/*      */           } else {
/*      */             
/* 1146 */             shrinkWave();
/*      */           
/*      */           }
/*      */         
/*      */         }
/* 1151 */         else if (var4.field_72308_g != null) {
/*      */           
/* 1153 */           float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/*      */           
/* 1155 */           int var23 = (int)this.damage;
/*      */           
/* 1157 */           if (this.density == 2 && this.shootingEntity != null) {
/* 1158 */             var23 = 0;
/* 1159 */             if (!this.field_70170_p.field_72995_K && var4.field_72308_g instanceof EntityPlayer) {
/* 1160 */               MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 1161 */               EntityPlayer Player = (EntityPlayer)var4.field_72308_g;
/* 1162 */               int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(Player);
/*      */               
/* 1164 */               String[] PlyrSkills = JRMCoreH.getString(Player, "jrmcSSlts").split(",");
/*      */               
/* 1166 */               int t = this.dam;
/* 1167 */               int t2 = (t > 30) ? 30 : ((t < 1) ? 1 : t);
/* 1168 */               NCJutsus.wgi(server, "1;" + this.pmjID + ";" + this.dam + ";" + t2 + ";" + t2, Player.func_70005_c_(), false);
/* 1169 */               EntityPlayer shtr = (EntityPlayer)this.shootingEntity;
/* 1170 */               shtr.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + "Target " + Player.func_70005_c_() + " under the effect of " + this.nameJutsu));
/*      */             } 
/* 1172 */           } else if (this.density == 2) {
/* 1173 */             func_70106_y();
/*      */           } 
/*      */           
/* 1176 */           if (JRMCoreH.DGE(var4.field_72308_g) && !this.givenExp) { JRMCoreH.jrmcExp(this.shootingEntity, 1, getType()); this.givenExp = true; }
/*      */ 
/*      */           
/* 1179 */           DamageSource damagesource = null;
/*      */           
/* 1181 */           if (this.shootingEntity == null) {
/*      */             
/* 1183 */             func_70106_y();
/*      */           }
/*      */           else {
/*      */             
/* 1187 */             damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity);
/*      */           } 
/*      */           
/* 1190 */           if (func_70027_ad())
/*      */           {
/* 1192 */             var4.field_72308_g.func_70015_d(5);
/*      */           }
/* 1194 */           if (this.density != 2 && var4.field_72308_g.func_70097_a(damagesource, var23))
/*      */           {
/*      */             
/* 1197 */             if (var4.field_72308_g instanceof EntityLivingBase) {
/*      */               
/* 1199 */               if (!this.field_70170_p.field_72995_K) {
/*      */                 
/* 1201 */                 EntityLivingBase var24 = (EntityLivingBase)var4.field_72308_g;
/* 1202 */                 if (!this.field_70170_p.field_72995_K);
/*      */               } 
/*      */ 
/*      */ 
/*      */               
/* 1207 */               if (this.knockbackStrength > 0) {
/*      */                 
/* 1209 */                 float var25 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*      */                 
/* 1211 */                 if (var25 > 0.0F)
/*      */                 {
/* 1213 */                   var4.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / var25, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / var25);
/*      */                 }
/*      */               } 
/*      */             } 
/*      */ 
/*      */             
/* 1219 */             if (this.type >= 0 && this.type <= 2 && this.field_70131_O > 1.5F)
/*      */             {
/* 1221 */               createExplosion(0);
/*      */             }
/* 1223 */             func_70106_y();
/*      */           }
/*      */           else
/*      */           {
/* 1227 */             this.field_70159_w *= -0.10000000149011612D;
/* 1228 */             this.field_70181_x *= -0.10000000149011612D;
/* 1229 */             this.field_70179_y *= -0.10000000149011612D;
/* 1230 */             this.field_70177_z += 180.0F;
/* 1231 */             this.field_70126_B += 180.0F;
/* 1232 */             func_70106_y();
/* 1233 */             this.ticksInAir = 0;
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/* 1238 */           this.xTile = var4.field_72311_b;
/* 1239 */           this.yTile = var4.field_72312_c;
/* 1240 */           this.zTile = var4.field_72309_d;
/* 1241 */           this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
/* 1242 */           this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
/* 1243 */           float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 1244 */           this.field_70165_t -= this.field_70159_w / var20 * 0.05000000074505806D;
/* 1245 */           this.field_70163_u -= this.field_70181_x / var20 * 0.05000000074505806D;
/* 1246 */           this.field_70161_v -= this.field_70179_y / var20 * 0.05000000074505806D;
/* 1247 */           this.inGround = true;
/*      */           
/* 1249 */           if (this.inTile.func_149688_o() != Material.field_151579_a)
/*      */           {
/* 1251 */             this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1257 */       this.field_70165_t += this.field_70159_w;
/* 1258 */       this.field_70163_u += this.field_70181_x;
/* 1259 */       this.field_70161_v += this.field_70179_y;
/*      */ 
/*      */       
/* 1262 */       int test = 0;
/* 1263 */       while (this.field_70125_A - this.field_70127_C >= 180.0F && test < 20) {
/*      */         
/* 1265 */         this.field_70127_C += 360.0F;
/* 1266 */         test++;
/*      */       } 
/* 1268 */       test = 0;
/* 1269 */       while (this.field_70177_z - this.field_70126_B < -180.0F && test < 20) {
/*      */         
/* 1271 */         this.field_70126_B -= 360.0F;
/* 1272 */         test++;
/*      */       } 
/* 1274 */       test = 0;
/* 1275 */       while (this.field_70177_z - this.field_70126_B >= 180.0F && test < 20) {
/*      */         
/* 1277 */         this.field_70126_B += 360.0F;
/* 1278 */         test++;
/*      */       } 
/*      */ 
/*      */       
/* 1282 */       float var22 = 1.0F;
/* 1283 */       float var11 = 0.0F;
/*      */       
/* 1285 */       if (func_70090_H()) {
/*      */         
/* 1287 */         for (int var26 = 0; var26 < 4; var26++) {
/*      */           
/* 1289 */           float var27 = 0.25F;
/* 1290 */           this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var27, this.field_70163_u - this.field_70181_x * var27, this.field_70161_v - this.field_70179_y * var27, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*      */         } 
/*      */         
/* 1293 */         var22 = 1.0F;
/*      */       } 
/*      */       
/* 1296 */       this.field_70159_w *= var22;
/* 1297 */       this.field_70181_x *= var22;
/* 1298 */       this.field_70179_y *= var22;
/* 1299 */       this.field_70181_x -= var11;
/* 1300 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 1301 */       doBlockCollisions();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1306 */     if (this.field_70170_p.field_72995_K && this.field_70128_L && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && this.shooterHolds) {
/*      */       
/* 1308 */       EntityPlayer player = (EntityPlayer)this.shootingEntity;
/* 1309 */       ExtendedPlayer.get(player).setAnimKiShoot(0);
/* 1310 */       shrinkWave();
/*      */     }  }
/*      */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) { float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5); par1 /= var9; par3 /= var9; par5 /= var9; par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par1 *= par7; par3 *= par7; par5 *= par7; this.field_70159_w = par1; this.field_70181_x = par3; this.field_70179_y = par5; float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5); this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI); this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI); this.ticksInGround = 0; }
/*      */   @SideOnly(Side.CLIENT) public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) { func_70107_b(par1, par3, par5); func_70101_b(par7, par8); }
/*      */   @SideOnly(Side.CLIENT) public void func_70016_h(double par1, double par3, double par5) { this.field_70159_w = par1; this.field_70181_x = par3; this.field_70179_y = par5; if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*      */       float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5); this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI); this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / Math.PI); this.field_70127_C = this.field_70125_A; this.field_70126_B = this.field_70177_z;
/*      */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/*      */       this.ticksInGround = 0;
/* 1318 */     }  } public void func_70106_y() { super.func_70106_y();
/* 1319 */     if (this.field_70170_p.field_72995_K)
/*      */     {
/* 1321 */       if (this.field_70170_p.field_72995_K && this.field_70128_L && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && this.shooterHolds) {
/*      */         
/* 1323 */         EntityPlayer player = (EntityPlayer)this.shootingEntity;
/* 1324 */         ExtendedPlayer.get(player).setAnimKiShoot(0);
/* 1325 */         shrinkWave();
/*      */ 
/*      */         
/* 1328 */         JRMCoreH.isShtng = false;
/*      */       } 
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPower(Entity entity) {
/* 1337 */     return (long)(getDamage() / 2.0D);
/*      */   }
/*      */   
/*      */   private void doBlockCollisions() {
/* 1341 */     func_145775_I();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70014_b(NBTTagCompound nbt) {
/* 1347 */     nbt.func_74777_a("xTile", (short)this.xTile);
/* 1348 */     nbt.func_74777_a("yTile", (short)this.yTile);
/* 1349 */     nbt.func_74777_a("zTile", (short)this.zTile);
/* 1350 */     nbt.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 1351 */     nbt.func_74774_a("inData", (byte)this.inData);
/* 1352 */     nbt.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 1353 */     nbt.func_74780_a("damage", this.damage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound nbt) {
/* 1361 */     this.xTile = nbt.func_74765_d("xTile");
/* 1362 */     this.yTile = nbt.func_74765_d("yTile");
/* 1363 */     this.zTile = nbt.func_74765_d("zTile");
/* 1364 */     this.inTile = Block.func_149729_e(nbt.func_74771_c("inTile") & 0xFF);
/* 1365 */     this.inData = nbt.func_74771_c("inData") & 0xFF;
/* 1366 */     this.inGround = (nbt.func_74771_c("inGround") == 1);
/* 1367 */     if (nbt.func_74764_b("damage")) this.damage = nbt.func_74769_h("damage");
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70100_b_(EntityPlayer par1EntityPlayer) {}
/*      */ 
/*      */   
/*      */   protected boolean func_70041_e_() {
/* 1377 */     return false;
/*      */   } @SideOnly(Side.CLIENT)
/*      */   public float func_70053_R() {
/* 1380 */     return 0.0F;
/*      */   } public void setDamage(double par1) {
/* 1382 */     this.damage = par1;
/*      */   } public double getDamage() {
/* 1384 */     return this.damage;
/*      */   }
/*      */   public void setKnockbackStrength(int par1) {
/* 1387 */     this.knockbackStrength = par1;
/*      */   }
/*      */   public boolean func_70075_an() {
/* 1390 */     return false;
/*      */   }
/*      */   public boolean func_82704_a(Entity var1) {
/* 1393 */     return false;
/*      */   }
/*      */   
/*      */   public void writeSpawnData(ByteBuf data) {
/* 1397 */     data.writeInt((this.shootingEntity == null) ? 0 : this.shootingEntity.func_145782_y());
/* 1398 */     data.writeInt((this.target == null) ? 0 : this.target.func_145782_y());
/* 1399 */     data.writeByte(this.perc);
/* 1400 */     data.writeByte(this.type);
/* 1401 */     data.writeInt(this.color);
/* 1402 */     data.writeInt(this.dam);
/* 1403 */     data.writeByte(this.density);
/* 1404 */     data.writeShort(this.sincantation);
/* 1405 */     data.writeShort(this.sfire);
/* 1406 */     data.writeShort(this.smove);
/* 1407 */     data.writeFloat(this.strtX);
/* 1408 */     data.writeFloat(this.strtY);
/* 1409 */     data.writeFloat(this.strtZ);
/* 1410 */     data.writeFloat(this.size);
/* 1411 */     data.writeFloat(this.trgtX);
/* 1412 */     data.writeFloat(this.trgtY);
/* 1413 */     data.writeFloat(this.trgtZ);
/* 1414 */     data.writeByte(this.shrink ? 1 : 0);
/* 1415 */     data.writeShort(this.effect);
/* 1416 */     data.writeDouble(this.damage);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readSpawnData(ByteBuf data) {
/* 1424 */     int first = data.readInt();
/* 1425 */     this.shootingEntity = (first == 0) ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
/* 1426 */     int second = data.readInt();
/* 1427 */     this.target = (first == 0) ? this.target : this.field_70170_p.func_73045_a(second);
/* 1428 */     this.perc = data.readByte();
/* 1429 */     this.type = data.readByte();
/* 1430 */     this.color = data.readInt();
/* 1431 */     this.dam = data.readInt();
/* 1432 */     this.density = data.readByte();
/* 1433 */     this.sincantation = data.readShort();
/* 1434 */     this.sfire = data.readShort();
/* 1435 */     this.smove = data.readShort();
/* 1436 */     this.strtX = data.readFloat();
/* 1437 */     this.strtY = data.readFloat();
/* 1438 */     this.strtZ = data.readFloat();
/* 1439 */     this.size = data.readFloat();
/* 1440 */     this.trgtX = data.readFloat();
/* 1441 */     this.trgtY = data.readFloat();
/* 1442 */     this.trgtZ = data.readFloat();
/* 1443 */     this.shrink = (data.readByte() == 1);
/* 1444 */     this.effect = data.readShort();
/* 1445 */     this.damage = data.readDouble();
/*      */   }
/*      */   
/*      */   public boolean isWave()
/*      */   {
/* 1450 */     return (getType() == 0);
/* 1451 */   } public boolean isBlast() { return (getType() == 1); } public boolean isDisk() {
/* 1452 */     return (getType() == 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFireElement() {
/* 1460 */     return (getEff() == 0);
/* 1461 */   } public boolean isWindElement() { return (getEff() == 1); }
/* 1462 */   public boolean isLightningElement() { return (getEff() == 2); }
/* 1463 */   public boolean isEarthElement() { return (getEff() == 3); } public boolean isWaterElement() {
/* 1464 */     return (getEff() == 4);
/*      */   }
/*      */   
/*      */   private void createExplosion(int type) {
/* 1468 */     JRMCoreH.newExpl(this.field_70170_p, this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.size, false, this.damage, this.shootingEntity, (byte)type);
/*      */   }
/*      */ 
/*      */   
/*      */   private void setTarget(Entity entity) {
/* 1473 */     this.target = entity;
/* 1474 */     this.hadTarget = true;
/*      */   }
/*      */   
/*      */   public Entity getThrower() {
/* 1478 */     return null;
/*      */   }
/*      */   public void setThrower(Entity entity) {}
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/* 1483 */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) { return true; }
/*      */   @SideOnly(Side.CLIENT)
/* 1485 */   public double getMaxRenderDistanceSquared() { return 65536.0D; }
/* 1486 */   public boolean func_70112_a(double par1) { return true; } public void setJutsuName(String name) {
/* 1487 */     this.nameJutsu = name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void generateParticles(EntityEnergyAttJ entityBlast, Entity entity, int color, boolean startSpawn) {
/* 1495 */     if (entityBlast != null && entity != null && entityBlast.field_70170_p.field_72995_K)
/*      */     {
/* 1497 */       for (int i = 0; i < 3; i++) {
/* 1498 */         for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*      */           double x2, y2, z2;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1504 */           float colorFixer = 0.7F;
/*      */           
/* 1506 */           float red = (color >> 16 & 0xFF) / 255.0F;
/* 1507 */           float green = (color >> 8 & 0xFF) / 255.0F;
/* 1508 */           float blue = (color & 0xFF) / 255.0F;
/* 1509 */           red *= 0.7F; green *= 0.7F; blue *= 0.7F;
/*      */ 
/*      */ 
/*      */           
/* 1513 */           float red2 = red * 2.0F; if (red2 > 1.0F) red2 = 1.0F; 
/* 1514 */           float blue2 = blue * 2.0F; if (blue2 > 1.0F) blue2 = 1.0F; 
/* 1515 */           float green2 = green * 2.0F; if (green2 > 1.0F) green2 = 1.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1521 */           float alpha = 1.0F;
/*      */           
/* 1523 */           float out = 1.0F, in = 1.5F;
/* 1524 */           float life = 0.4F * entity.field_70131_O;
/* 1525 */           float extra_scale = 0.3F;
/* 1526 */           int dea = 30;
/*      */           
/* 1528 */           float target_fullsize_one1 = 0.32F;
/* 1529 */           float targetsizeMin = entity.field_70131_O * 8.0F / target_fullsize_one1 * 0.01F;
/*      */           
/* 1531 */           float target_fullsize_one2 = 0.32F;
/* 1532 */           float targetsizeMax = entity.field_70131_O * 26.0F / target_fullsize_one2 * 0.01F;
/*      */ 
/*      */           
/* 1535 */           double x = (Math.random() * (entity.field_70131_O * 2.0F) - entity.field_70131_O) * 0.800000011920929D;
/* 1536 */           double y = (Math.random() * (entity.field_70131_O * 2.0F) - entity.field_70131_O) * 0.800000011920929D;
/* 1537 */           double z = (Math.random() * (entity.field_70131_O * 2.0F) - entity.field_70131_O) * 0.800000011920929D;
/*      */ 
/*      */ 
/*      */           
/* 1541 */           Vec3 vec3 = entity.func_70040_Z();
/*      */ 
/*      */           
/* 1544 */           double d8 = (entity.field_70130_N + (startSpawn ? 0.0F : 1.5F));
/* 1545 */           double d9 = entity.field_70131_O;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1561 */           if (startSpawn) {
/*      */             
/* 1563 */             x2 = entityBlast.strtX();
/* 1564 */             y2 = entityBlast.strtY();
/* 1565 */             z2 = entityBlast.strtZ();
/*      */             
/* 1567 */             x2 += vec3.field_72450_a * d8;
/* 1568 */             y2 += vec3.field_72448_b * d9 + (entity.field_70131_O * 0.4F);
/* 1569 */             z2 += vec3.field_72449_c * d8;
/*      */           }
/*      */           else {
/*      */             
/* 1573 */             x2 = entityBlast.field_70165_t;
/* 1574 */             y2 = entityBlast.field_70163_u;
/* 1575 */             z2 = entityBlast.field_70161_v;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1585 */           x2 += x;
/* 1586 */           y2 += y;
/* 1587 */           z2 += z;
/*      */ 
/*      */           
/* 1590 */           float rotationYaw = -entityBlast.field_70177_z, rotationPitch = -entityBlast.field_70125_A;
/* 1591 */           double motionX = (-MathHelper.func_76126_a(rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(rotationPitch / 180.0F * 3.1415927F));
/* 1592 */           double motionZ = (MathHelper.func_76134_b(rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(rotationPitch / 180.0F * 3.1415927F));
/* 1593 */           double motionY = -MathHelper.func_76126_a(rotationPitch / 180.0F * 3.1415927F);
/*      */           
/* 1595 */           if (startSpawn) {
/*      */             
/* 1597 */             x2 += -motionX * 3.0D;
/* 1598 */             y2 += -motionY * 3.0D;
/* 1599 */             y2 -= entityBlast.field_70131_O * 0.25D;
/* 1600 */             z2 += -motionZ * 3.0D;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1607 */           motionX *= 0.5D;
/* 1608 */           motionY *= 0.5D;
/* 1609 */           motionY += ((float)(Math.random() * 0.10000000149011612D) - 0.05F);
/* 1610 */           motionZ *= 0.5D;
/*      */           
/* 1612 */           if (startSpawn) {
/*      */             
/* 1614 */             motionX *= -1.0D;
/* 1615 */             motionY *= -1.0D;
/* 1616 */             motionZ *= -1.0D;
/*      */           } 
/*      */           
/* 1619 */           float scaleStart = ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.3F;
/* 1620 */           float scaleEnd = ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.3F;
/* 1621 */           float scaleSpeed = 0.2F * life * 0.3F;
/*      */           
/* 1623 */           int textureID = (int)(Math.random() * 3.0D) + 8;
/*      */           
/* 1625 */           Entity particle = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.field_70170_p, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart, scaleEnd, scaleStart, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F, 0.0F, 0.9F, 0.95F, 0.06F, false, -1, true, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1638 */           entity.field_70170_p.func_72838_d(particle);
/*      */           
/* 1640 */           Entity particle2 = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.field_70170_p, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart * 0.8F, scaleEnd * 0.8F, scaleStart * 0.8F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F, 0.0F, 0.9F, 0.95F, 0.06F, false, -1, true, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1653 */           entity.field_70170_p.func_72838_d(particle2);
/*      */         } 
/*      */       }  } 
/*      */   }
/*      */   
/*      */   public float rad(float angle) {
/* 1659 */     return angle * 3.1415927F / 180.0F;
/*      */   } }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityEnergyAttJ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */