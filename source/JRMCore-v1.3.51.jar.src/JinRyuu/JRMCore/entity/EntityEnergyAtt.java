/*      */ package JinRyuu.JRMCore.entity;public class EntityEnergyAtt extends EntityEnAttacks implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile { private int xTile; private int yTile; private int zTile; private Block inTile; private int inData; private boolean inGround; private int ticksInGround; private int ticksInAir; private double damage; private double damageOriginal; private int damageTaken; private int knockbackStrength; private float explevel;
/*      */   private float Expl;
/*      */   private String ExplSound;
/*      */   private String AirSound;
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
/*      */   private short effect;
/*      */   private int color;
/*      */   private int color2;
/*      */   private byte density;
/*      */   private short sincantation;
/*      */   private short sfire;
/*      */   private short smove;
/*      */   private byte[] sts;
/*      */   private byte technum;
/*      */   private byte align;
/*      */   private float size;
/*      */   private int conn;
/*      */   private int waveCount;
/*      */   private byte wave;
/*      */   private Entity target;
/*      */   private int cost;
/*      */   private int originDmg;
/*      */   private boolean shrink;
/*      */   private byte relFired;
/*      */   public boolean givenExp;
/*      */   public double motionXStart;
/*      */   public double motionYStart;
/*      */   public double motionZStart;
/*      */   public boolean givenTP;
/*      */   public boolean destroyer;
/*      */   public float DAMAGE_REDUCTION;
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
/*      */   public float minScale;
/*      */   public float maxScale;
/*      */   public float maxDamage;
/*      */   private boolean run;
/*      */   private int cb;
/*      */   private boolean kiClashed;
/*      */   private List kiClashedList;
/*      */   public float startRotationPitch;
/*      */   public float startRotationYaw;
/*      */   private final byte REACTION_DEAD = 1;
/*      */   private final byte REACTION_KILL = 2;
/*      */   private final byte REACTION_KILL_EFFECT = 3;
/*      */   private final byte REACTION_DAMAGE = 4;
/*      */   private final byte REACTION_DAMAGE_EFFECT = 5;
/*      */   
/*   73 */   public float strtX() { return this.strtX; }
/*   74 */   public float strtY() { return this.strtY; }
/*   75 */   public float strtZ() { return this.strtZ; }
/*   76 */   public float trgtX() { return this.trgtX; }
/*   77 */   public float trgtY() { return this.trgtY; } public float trgtZ() {
/*   78 */     return this.trgtZ;
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
/*      */   public int getShrink() {
/*  110 */     return func_70096_w().func_75679_c(20);
/*  111 */   } public byte getType() { return this.type; }
/*  112 */   public int getCol() { return this.color; }
/*  113 */   public int getCol2() { return this.color2; }
/*  114 */   public byte getSpe() { return this.speed; }
/*  115 */   public int getDam() { return this.dam; }
/*  116 */   public byte getDen() { return this.density; }
/*  117 */   public byte getPerc() { return this.perc; }
/*  118 */   public int getAirTicks() { return this.ticksInAir; } public byte[] getSts() {
/*  119 */     return this.sts;
/*      */   } public void setAirTicks(int i) {
/*  121 */     this.ticksInAir = i;
/*      */   } public short getEff() {
/*  123 */     return this.effect;
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
/*      */   public float getSize() {
/*  146 */     return this.size;
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
/*      */   public float getScale() {
/*  184 */     float damage = this.originDmg;
/*  185 */     byte perc = getPerc();
/*  186 */     byte[] sts = getSts();
/*  187 */     byte den = getDen();
/*      */     
/*  189 */     float scale = JRMCoreH.calculateEnergyScale(damage, this.maxDamage, perc, sts, den, this.minScale, this.maxScale);
/*  190 */     return scale;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setScales() {
/*  195 */     this.minScale = (float)JRMCoreConfig.KiSizeMin[getType()];
/*  196 */     this.maxScale = (float)JRMCoreConfig.KiSizeMax[getType()];
/*  197 */     this.maxDamage = JRMCoreH.getMaxEnergyDamage();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float setScalesPost() {
/*  203 */     if (isWave()) return 100.0F; 
/*  204 */     if (isBlast()) return 5.0F; 
/*  205 */     if (isDisk()) return 5.0F; 
/*  206 */     if (isLaser()) return 5.0F; 
/*  207 */     if (isLargeBlast()) return 10000.0F; 
/*  208 */     if (isSpiral()) return 5.0F; 
/*  209 */     if (isBarrage()) return 5.0F; 
/*  210 */     if (isShield()) return 5.0F; 
/*  211 */     if (isExplosion()) return 20.0F; 
/*  212 */     return 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityEnergyAtt(World par1World)
/*      */   {
/*  221 */     super(par1World);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.damageOriginal = 1.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.damageTaken = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.Expl = 4.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.ExplSound = "jinryuudragonbc:DBC.expl";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.AirSound = "jinryuudragonbc:DBC.hafire";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.relFired = 100;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.givenTP = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.destroyer = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.DAMAGE_REDUCTION = JGConfigDBCGoD.CONFIG_GOD_ENERGY_DAMAGE_MULTI;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.added = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_speed = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_start = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_id = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_id_Max = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_random_Max = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_random = new ArrayList<Integer>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.render_scale = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.render_scale_max = 2.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.dist = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.hadTarget = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.added2 = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.animation_start2 = 0L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.waveScale = 1.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.finalDist = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.lastSegments = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     this.run = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  612 */     this.cb = 50;
/*      */     
/*  614 */     this.kiClashedList = new ArrayList();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  621 */     this.startRotationPitch = 0.0F;
/*  622 */     this.startRotationYaw = 0.0F;
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
/* 1898 */     this.REACTION_DEAD = 1; this.REACTION_KILL = 2; this.REACTION_KILL_EFFECT = 3; this.REACTION_DAMAGE = 4; this.REACTION_DAMAGE_EFFECT = 5; func_70105_a(this.size, this.size); } public EntityEnergyAtt(EntityLivingBase entityLiving, byte type, byte speed, int dam, byte effect, byte color, byte density, byte sincantation, byte sfire, byte smove, byte perc, int dam1, int cost, byte[] sts, byte technum) { this(entityLiving, type, speed, dam, effect, color, density, sincantation, sfire, smove, perc, dam1, cost, sts, technum, (byte)-100, (byte)-100); } public EntityEnergyAtt(EntityLivingBase entityLiving, byte type, byte speed, int dam, byte effect, byte color, byte density, byte sincantation, byte sfire, byte smove, byte perc, int dam1, int cost, byte[] sts, byte technum, byte release, byte align) { super(entityLiving.field_70170_p); double x, y, z; this.xTile = -1; this.yTile = -1; this.zTile = -1; this.inData = 0; this.inGround = false; this.ticksInAir = 0; this.damage = 1.0D; this.damageOriginal = 1.0D; this.damageTaken = 1; this.Expl = 4.0F; this.ExplSound = "jinryuudragonbc:DBC.expl"; this.AirSound = "jinryuudragonbc:DBC.hafire"; this.trgtX = 0.0F; this.trgtY = 0.0F; this.trgtZ = 0.0F; this.waveCount = 20; this.wave = 0; this.shrink = false; this.relFired = 100; this.givenExp = false; this.givenTP = false; this.destroyer = false; this.DAMAGE_REDUCTION = JGConfigDBCGoD.CONFIG_GOD_ENERGY_DAMAGE_MULTI; this.added = false; this.animation_speed = 0; this.animation_start = 0L; this.animation_id = 0; this.animation_id_Max = 0; this.animation_random_Max = 0; this.animation_random = new ArrayList<Integer>(); this.render_scale = 0.0F; this.render_scale_max = 2.0F; this.dist = 0.0D; this.hadTarget = false; this.added2 = false; this.animation_start2 = 0L; this.waveScale = 1.0F; this.finalDist = 0.0D; this.lastSegments = 0; this.run = true; this.cb = 50; this.kiClashedList = new ArrayList(); this.startRotationPitch = 0.0F; this.startRotationYaw = 0.0F; this.REACTION_DEAD = 1; this.REACTION_KILL = 2; this.REACTION_KILL_EFFECT = 3; this.REACTION_DAMAGE = 4; this.REACTION_DAMAGE_EFFECT = 5; this.type = type; this.shooterHolds = isContinuesWave(); this.speed = (byte)(int)(((speed + 1) * 10 + ((type == 2) ? 10 : 0) + ((density == 2) ? 40 : 0)) * (1.0F + JRMCoreH.tech_statmod(sts, 0))); this.dam = dam; this.perc = perc; this.effect = (short)effect; this.color = color; this.color2 = -1; this.density = (byte)(sts[5] + 1); this.sincantation = (short)sincantation; this.sfire = (short)sfire; this.smove = (short)smove; this.sts = sts; this.technum = technum; this.cost = cost; this.originDmg = dam1; if (entityLiving instanceof EntityPlayer) { EntityPlayer player = (EntityPlayer)entityLiving; this.relFired = (release != -100) ? release : JRMCoreH.getByte(player, "jrmcRelease"); this.align = (align != -100) ? align : JRMCoreH.getByte(player, "jrmcAlign"); if (color == 0) if (this.align > 66) { this.color = 2; } else if (this.align <= 66 && this.align >= 33) { this.color = 3; } else if (this.align < 33) { this.color = 4; }   } else if (color == 0) { this.color = 3; }  this.damage = dam1 * this.relFired * 0.009999999776482582D * perc * 0.019999999552965164D * JRMCoreConfig.dat5696[type][1]; this.damageOriginal = this.damage; if (!isShield() && !isExplosion()) { setScales(); float size1 = getScale(); this.size = 0.5F + size1; } else { this.minScale = 0.001F; this.maxScale = 0.1F; this.maxDamage = JRMCoreH.getMaxEnergyDamage(); }  this.shootingEntity = (Entity)entityLiving; if (!isShield() && !isExplosion()) { this.explevel = this.size * (float)JRMCoreConfig.eaes; } else { this.explevel = 0.0F; }  this.field_70155_l = 10.0D; if (JRMCoreConfig.eaesl > 0 && this.size > JRMCoreConfig.eaesl) this.size = JRMCoreConfig.eaesl;  if (JRMCoreConfig.ExplosionSizeLimit > 0.0D && this.explevel > JRMCoreConfig.ExplosionSizeLimit) this.explevel = (float)JRMCoreConfig.ExplosionSizeLimit;  if (isLargeBlast()) { this.size *= JRMCoreConfig.ealbm; this.explevel *= JRMCoreConfig.ealbm; }  if (JRMCoreConfig.KiAttackScalesWithUser) { float extraScale = (this.shootingEntity == null) ? 1.0F : (this.shootingEntity.field_70131_O / 1.8F); this.size *= extraScale; this.explevel *= extraScale; }  func_70105_a(this.size, this.size); if (!isShield() && !isExplosion()) { Vec3 vec3; double d8 = (entityLiving.field_70130_N + 1.0F + 1.0F); double d9 = (entityLiving.field_70131_O + 0.2F); if (this.shootingEntity instanceof EntityPlayer) { vec3 = this.shootingEntity.func_70040_Z(); } else { float rotationYaw = this.shootingEntity.func_70079_am(), rotationPitch = this.shootingEntity.field_70125_A; float vx = -MathHelper.func_76126_a(rad(rotationYaw)) * MathHelper.func_76134_b(rad(rotationPitch)); float vz = MathHelper.func_76134_b(rad(rotationYaw)) * MathHelper.func_76134_b(rad(rotationPitch)); float vy = -MathHelper.func_76126_a(rad(rotationPitch)); vec3 = Vec3.func_72443_a(vx, vy, vz); }  x = entityLiving.field_70165_t + vec3.field_72450_a * d8; y = entityLiving.field_70163_u + vec3.field_72448_b * d8 + (entityLiving.field_70131_O * 0.7F); z = entityLiving.field_70161_v + vec3.field_72449_c * d8; func_70012_b(x, y, z, entityLiving.func_70079_am(), entityLiving.field_70125_A); this.field_70129_M = this.size * 0.5F; this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F)); this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F)); this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F); func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, (float)((this.speed * 0.05F) * JRMCoreConfig.dat5696[type][0]), 1.0F); } else { this.size = this.shootingEntity.field_70131_O * 3.0F * (!isExplosion() ? 1.0F : 2.0F); func_70105_a(this.size, this.size); x = entityLiving.field_70165_t; y = entityLiving.field_70163_u + (entityLiving.field_70131_O * 0.55F); z = entityLiving.field_70161_v; func_70012_b(x, y, z, entityLiving.field_70177_z, entityLiving.field_70125_A); this.field_70129_M = this.size * 0.5F; this.field_70159_w = 0.0D; this.field_70179_y = 0.0D; this.field_70181_x = 0.0D; }  this.strtX = (float)x; this.strtY = (float)y; this.strtZ = (float)z; this.motionXStart = this.field_70159_w; this.motionYStart = this.field_70181_x; this.motionZStart = this.field_70179_y; } public EntityEnergyAtt(EntityLivingBase entityLiving, byte type, byte speed, int dam, byte effect, byte color, byte color2, byte density, byte sincantation, byte sfire, byte smove, byte perc, int dam1, int cost, byte[] sts, byte technum) { this(entityLiving, type, speed, dam, effect, color, color2, density, sincantation, sfire, smove, perc, dam1, cost, sts, technum, (byte)-100, (byte)-100); } public EntityEnergyAtt(EntityLivingBase entityLiving, byte type, byte speed, int dam, byte effect, byte color, byte color2, byte density, byte sincantation, byte sfire, byte smove, byte perc, int dam1, int cost, byte[] sts, byte technum, byte release, byte align) { super(entityLiving.field_70170_p); double x, y, z; this.xTile = -1; this.yTile = -1; this.zTile = -1; this.inData = 0; this.inGround = false; this.ticksInAir = 0; this.damage = 1.0D; this.damageOriginal = 1.0D; this.damageTaken = 1; this.Expl = 4.0F; this.ExplSound = "jinryuudragonbc:DBC.expl"; this.AirSound = "jinryuudragonbc:DBC.hafire"; this.trgtX = 0.0F; this.trgtY = 0.0F; this.trgtZ = 0.0F; this.waveCount = 20; this.wave = 0; this.shrink = false; this.relFired = 100; this.givenExp = false; this.givenTP = false; this.destroyer = false; this.DAMAGE_REDUCTION = JGConfigDBCGoD.CONFIG_GOD_ENERGY_DAMAGE_MULTI; this.added = false; this.animation_speed = 0; this.animation_start = 0L; this.animation_id = 0; this.animation_id_Max = 0; this.animation_random_Max = 0; this.animation_random = new ArrayList<Integer>(); this.render_scale = 0.0F; this.render_scale_max = 2.0F; this.dist = 0.0D; this.hadTarget = false; this.added2 = false; this.animation_start2 = 0L; this.waveScale = 1.0F; this.finalDist = 0.0D; this.lastSegments = 0; this.run = true; this.cb = 50; this.kiClashedList = new ArrayList(); this.startRotationPitch = 0.0F; this.startRotationYaw = 0.0F; this.REACTION_DEAD = 1; this.REACTION_KILL = 2; this.REACTION_KILL_EFFECT = 3; this.REACTION_DAMAGE = 4; this.REACTION_DAMAGE_EFFECT = 5; this.type = type; this.shooterHolds = isContinuesWave(); this.speed = (byte)(int)(((speed + 1) * 10 + ((type == 2) ? 10 : 0) + ((density == 2) ? 40 : 0)) * (1.0F + JRMCoreH.tech_statmod(sts, 0))); this.dam = dam; this.perc = perc; this.effect = (short)effect; this.color = color; this.color2 = color2; this.density = (byte)(sts[5] + 1); this.sincantation = (short)sincantation; this.sfire = (short)sfire; this.smove = (short)smove; this.sts = sts; this.technum = technum; this.cost = cost; this.originDmg = dam1; if (entityLiving instanceof EntityPlayer) { EntityPlayer player = (EntityPlayer)entityLiving; this.relFired = (release != -100) ? release : JRMCoreH.getByte(player, "jrmcRelease"); this.align = (align != -100) ? align : JRMCoreH.getByte(player, "jrmcAlign"); if (color == 0) if (this.align > 66) { this.color = 2; } else if (this.align <= 66 && this.align >= 33) { this.color = 3; } else if (this.align < 33) { this.color = 4; }   if (color2 == 0) if (this.align > 66) { this.color2 = 2; } else if (this.align <= 66 && this.align >= 33) { this.color2 = 3; } else if (this.align < 33) { this.color2 = 4; }   } else { if (color == 0) this.color = 3;  if (color2 == 0) this.color2 = 3;  }  this.damage = dam1 * this.relFired * 0.009999999776482582D * perc * 0.019999999552965164D * JRMCoreConfig.dat5696[type][1]; this.damageOriginal = this.damage; if (!isShield() && !isExplosion()) { setScales(); float size1 = getScale(); this.size = 0.5F + size1; } else { this.minScale = 0.001F; this.maxScale = 0.1F; this.maxDamage = JRMCoreH.getMaxEnergyDamage(); }  this.shootingEntity = (Entity)entityLiving; if (!isShield() && !isExplosion()) { this.explevel = this.size * (float)JRMCoreConfig.eaes; } else { this.explevel = 0.0F; }  this.field_70155_l = 10.0D; if (JRMCoreConfig.eaesl > 0 && this.size > JRMCoreConfig.eaesl) this.size = JRMCoreConfig.eaesl;  if (JRMCoreConfig.ExplosionSizeLimit > 0.0D && this.explevel > JRMCoreConfig.ExplosionSizeLimit)
/*      */       this.explevel = (float)JRMCoreConfig.ExplosionSizeLimit;  if (isLargeBlast()) { this.size *= JRMCoreConfig.ealbm; this.explevel *= JRMCoreConfig.ealbm; }  if (JRMCoreConfig.KiAttackScalesWithUser) { float extraScale = (this.shootingEntity == null) ? 1.0F : (this.shootingEntity.field_70131_O / 1.8F); this.size *= extraScale; this.explevel *= extraScale; }  func_70105_a(this.size, this.size); if (!isShield() && !isExplosion()) { Vec3 vec3; double d8 = (entityLiving.field_70130_N + 1.0F + 1.0F); double d9 = (entityLiving.field_70131_O + 0.2F); if (this.shootingEntity instanceof EntityPlayer) { vec3 = this.shootingEntity.func_70040_Z(); } else { float rotationYaw = this.shootingEntity.func_70079_am(), rotationPitch = this.shootingEntity.field_70125_A; float vx = -MathHelper.func_76126_a(rad(rotationYaw)) * MathHelper.func_76134_b(rad(rotationPitch)); float vz = MathHelper.func_76134_b(rad(rotationYaw)) * MathHelper.func_76134_b(rad(rotationPitch)); float vy = -MathHelper.func_76126_a(rad(rotationPitch)); vec3 = Vec3.func_72443_a(vx, vy, vz); }  x = entityLiving.field_70165_t + vec3.field_72450_a * d8; y = entityLiving.field_70163_u + vec3.field_72448_b * d8 + (entityLiving.field_70131_O * 0.7F); z = entityLiving.field_70161_v + vec3.field_72449_c * d8; func_70012_b(x, y, z, entityLiving.func_70079_am(), entityLiving.field_70125_A); this.field_70129_M = this.size * 0.5F; this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F)); this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F)); this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F); func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, (float)((this.speed * 0.05F) * JRMCoreConfig.dat5696[type][0]), 1.0F); } else { this.size = this.shootingEntity.field_70131_O * 3.0F * (!isExplosion() ? 1.0F : 2.0F); func_70105_a(this.size, this.size); x = entityLiving.field_70165_t; y = entityLiving.field_70163_u + (entityLiving.field_70131_O * 0.55F); z = entityLiving.field_70161_v; func_70012_b(x, y, z, entityLiving.field_70177_z, entityLiving.field_70125_A); this.field_70129_M = this.size * 0.5F; this.field_70159_w = 0.0D; this.field_70179_y = 0.0D; this.field_70181_x = 0.0D; }  this.strtX = (float)x; this.strtY = (float)y; this.strtZ = (float)z; this.motionXStart = this.field_70159_w; this.motionYStart = this.field_70181_x; this.motionZStart = this.field_70179_y; }
/*      */   protected void func_70088_a() { this.field_70180_af.func_75682_a(20, Integer.valueOf(0)); }
/*      */   public void func_70186_c(double par1, double par3, double par5, float par7, float par8) { float var9 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5); par1 /= var9; par3 /= var9; par5 /= var9; par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8; par1 *= par7; par3 *= par7; par5 *= par7; this.field_70159_w = par1; this.field_70181_x = par3; this.field_70179_y = par5; float var10 = MathHelper.func_76133_a(par1 * par1 + par5 * par5); this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI); this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var10) * 180.0D / Math.PI); this.ticksInGround = 0; }
/* 1902 */   @SideOnly(Side.CLIENT) public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) { func_70107_b(par1, par3, par5); func_70101_b(par7, par8); } private byte checkReaction(Entity entity, boolean react) { String nev = EntityList.func_75621_b(entity);
/*      */     
/* 1904 */     if (JRMCoreConfig.dat5704)
/*      */     {
/* 1906 */       JRMCoreH.log("[JRMC CONSOLE] Name of Entity that was hit by a Ki Blast: " + nev + " | (Can be used for Reaction Config!)");
/*      */     }
/*      */     
/* 1909 */     byte data = 0;
/*      */     
/* 1911 */     if (entity instanceof EntityEnergyAtt) nev = nev + "!" + ((EntityEnergyAtt)entity).getType();
/*      */     
/* 1913 */     if (JRMCoreConfig.dat5702.get(nev) != null) {
/*      */       
/* 1915 */       data = ((Byte)JRMCoreConfig.dat5702.get(nev)).byteValue();
/* 1916 */       if (react) checkReacts(entity, data);
/*      */     
/*      */     } 
/* 1919 */     if (JRMCoreConfig.dat5703.get(getType() + "." + nev) != null) {
/*      */       
/* 1921 */       data = ((Byte)JRMCoreConfig.dat5703.get(getType() + "." + nev)).byteValue();
/* 1922 */       if (react) checkReacts(entity, data); 
/*      */     } 
/* 1924 */     return data; }
/*      */   @SideOnly(Side.CLIENT) public void func_70016_h(double par1, double par3, double par5) { this.field_70159_w = par1; this.field_70181_x = par3; this.field_70179_y = par5; if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) { float var7 = MathHelper.func_76133_a(par1 * par1 + par5 * par5); this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI); this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, var7) * 180.0D / Math.PI); this.field_70127_C = this.field_70125_A; this.field_70126_B = this.field_70177_z; func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A); this.ticksInGround = 0; }  }
/*      */   public boolean isContinuesWave() { return (getType() >= JRMCoreConfig.ContinuesKiAttacks.length) ? false : JRMCoreConfig.ContinuesKiAttacks[getType()]; }
/*      */   public void func_70071_h_() { if ((JGConfigClientSettings.configsChanged || this.run) && this.field_70170_p.field_72995_K && !this.field_70128_L) this.field_70158_ak = JGConfigClientSettings.renderEnergyOutsideView;  if (!isShield() && !isExplosion()) { int color = JRMCoreH.techCol[getCol()]; int color2 = (getCol2() == -1) ? JRMCoreH.techCol2[getCol()] : JRMCoreH.techCol3[getCol2()]; if (isContinuesWave() && this.shooterHolds) generateParticles(this, this.shootingEntity, color, color2, true);  generateParticles(this, this, color, color2, false); }  if (!this.run) { if (this.field_70125_A != this.startRotationPitch) this.field_70125_A = this.startRotationPitch;  if (this.field_70177_z != this.startRotationYaw) this.field_70177_z = this.startRotationYaw;  }  boolean ROTATION_RELATED = true; if (this.run) { this.startRotationPitch = this.field_70125_A; this.startRotationYaw = this.field_70177_z; this.shooterHolds = isContinuesWave(); if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) { EntityPlayer player = (EntityPlayer)this.shootingEntity; ExtendedPlayer.get(player).setAnimKiShootOn(0); }  if (!this.field_70170_p.field_72995_K && !JRMCoreConfig.dat5695[this.type] && !this.field_70128_L) func_70106_y();  if (!this.field_70170_p.field_72995_K && !JRMCoreConfig.dat5709[this.type] && hasEffect()) this.effect = 0;  this.run = false; }  if (!this.field_70170_p.field_72995_K && isContinuesWave() && !isShield() && !isExplosion() && this.target != null && !this.target.field_70128_L && !this.shooterHolds && JGMathHelper.isMotionSmallerThanN(this, 0.001D)) func_70106_y();  if (JRMCoreConfig.WavesShrinkOnceLetGo) { if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && isContinuesWave() && this.shooterHolds) { double d8 = (((EntityLivingBase)this.shootingEntity).field_70130_N + 1.0F + 1.0F); double d9 = (((EntityLivingBase)this.shootingEntity).field_70131_O + 0.2F); Vec3 vec3 = this.shootingEntity.func_70040_Z(); double x = this.shootingEntity.field_70165_t + vec3.field_72450_a * d8; double y = this.shootingEntity.field_70163_u + vec3.field_72448_b * d8 + (this.shootingEntity.field_70131_O * 0.7F) + (this.field_70170_p.field_72995_K ? JGPlayerClientServerHelper.clientPlayerPositioner(this.shootingEntity) : 0.0F); double z = this.shootingEntity.field_70161_v + vec3.field_72449_c * d8; if (x < 0.0D) x *= -1.0D;  if (y < 0.0D) y *= -1.0D;  if (z < 0.0D) z *= -1.0D;  double kiX = this.strtX; if (kiX < 0.0D) kiX *= -1.0D;  double kiY = this.strtY; if (kiY < 0.0D) kiY *= -1.0D;  double kiZ = this.strtZ; if (kiZ < 0.0D) kiZ *= -1.0D;  double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D;  double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D;  double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;  float DEAD_DIFFERENCE = 0.2F; float DEAD_DIFFERENCE2 = 1.0F; if (kulx > 0.20000000298023224D || kuly > 1.0D || kulz > 0.20000000298023224D) { this.shooterHolds = false; EntityPlayer player = (EntityPlayer)this.shootingEntity; ExtendedPlayer.get(player).setAnimKiShoot(0); if (!this.field_70170_p.field_72995_K) { JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng"); shrinkWave(); } else { DBCClientTickHandler.nuller(); JRMCoreH.isShtng = false; }  }  }  } else if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && isContinuesWave() && this.shooterHolds) { double x = this.strtX; double y = this.strtY; double z = this.strtZ; if (x < 0.0D) x *= -1.0D;  if (y < 0.0D) y *= -1.0D;  if (z < 0.0D) z *= -1.0D;  double kiX = this.shootingEntity.field_70165_t; if (kiX < 0.0D) kiX *= -1.0D;  double kiY = this.shootingEntity.field_70163_u + (this.field_70170_p.field_72995_K ? JGPlayerClientServerHelper.clientPlayerPositioner(this.shootingEntity) : 0.0F); if (kiY < 0.0D) kiY *= -1.0D;  double kiZ = this.shootingEntity.field_70161_v; if (kiZ < 0.0D) kiZ *= -1.0D;  double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D;  double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D;  double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;  float DEAD_DIFFERENCE = 3.0F; if (kulx > 3.0D || kuly > 3.0D || kulz > 3.0D) { this.shooterHolds = false; EntityPlayer player = (EntityPlayer)this.shootingEntity; ExtendedPlayer.get(player).setAnimKiShoot(0); if (!this.field_70170_p.field_72995_K) { JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng"); } else { DBCClientTickHandler.nuller(); JRMCoreH.isShtng = false; }  }  }  if (!this.field_70170_p.field_72995_K && isContinuesWave() && JRMCoreConfig.ContinuesEnergyAttackEnemyLock && this.target != null && !this.target.field_70128_L && this.shooterHolds) { double x = this.field_70165_t; double y = this.field_70163_u; double z = this.field_70161_v; if (x < 0.0D) x *= -1.0D;  if (y < 0.0D) y *= -1.0D;  if (z < 0.0D) z *= -1.0D;  double kiX = this.target.field_70165_t; if (kiX < 0.0D) kiX *= -1.0D;  double kiY = this.target.field_70163_u; if (kiY < 0.0D) kiY *= -1.0D;  double kiZ = this.target.field_70161_v; if (kiZ < 0.0D) kiZ *= -1.0D;  double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D;  double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D;  double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;  float DEAD_DIFFERENCE = 0.5F; if (kulx > 0.5D || kuly > 0.5D || kulz > 0.5D) { this.target.field_70165_t = x; this.target.field_70163_u = y; this.target.field_70161_v = z; this.target.field_70165_t = this.field_70165_t; this.target.field_70163_u = this.field_70163_u; this.target.field_70161_v = this.field_70161_v; this.target.field_70159_w = this.field_70159_w; this.target.field_70181_x = this.field_70181_x; this.target.field_70179_y = this.field_70179_y; }  if (JRMCoreH.DBC() && this.target instanceof EntityDBC) ((EntityDBC)this.target).lockedBy = this;  }  if (!this.field_70170_p.field_72995_K && isContinuesWave() && JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown && JRMCoreConfig.ContinuesEnergyAttackMoveOnLostTarget && this.target != null && !this.target.field_70128_L && this.shooterHolds && JGMathHelper.isMotionSmallerThanN(this, 0.001D)) { double x = this.field_70165_t; double y = this.field_70163_u; double z = this.field_70161_v; if (x < 0.0D) x *= -1.0D;  if (y < 0.0D) y *= -1.0D;  if (z < 0.0D) z *= -1.0D;  double kiX = this.target.field_70165_t; if (kiX < 0.0D) kiX *= -1.0D;  double kiY = this.target.field_70163_u; if (kiY < 0.0D) kiY *= -1.0D;  double kiZ = this.target.field_70161_v; if (kiZ < 0.0D) kiZ *= -1.0D;  double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D;  double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D;  double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;  float DEAD_DIFFERENCE = this.size + 1.0F; if (kulx > DEAD_DIFFERENCE || kuly > DEAD_DIFFERENCE || kulz > DEAD_DIFFERENCE) { this.target = null; this.hadTarget = false; this.field_70159_w = this.motionXStart; this.field_70181_x = this.motionYStart; this.field_70179_y = this.motionZStart; }  }  if (!this.field_70170_p.field_72995_K && JRMCoreConfig.WavesDieWhenTargetAway && this.shootingEntity != null && this.target != null && this.shootingEntity instanceof EntityPlayer && isContinuesWave()) { double x = this.field_70165_t; double y = this.field_70163_u; double z = this.field_70161_v; if (x < 0.0D) x *= -1.0D;  if (y < 0.0D) y *= -1.0D;  if (z < 0.0D) z *= -1.0D;  double kiX = this.target.field_70165_t; if (kiX < 0.0D) kiX *= -1.0D;  double kiY = this.target.field_70163_u; if (kiY < 0.0D) kiY *= -1.0D;  double kiZ = this.target.field_70161_v; if (kiZ < 0.0D) kiZ *= -1.0D;  double kulx = x - kiX; if (kulx < 0.0D) kulx *= -1.0D;  double kuly = y - kiY; if (kuly < 0.0D) kuly *= -1.0D;  double kulz = z - kiZ; if (kulz < 0.0D) kulz *= -1.0D;  float DEAD_DIFFERENCE = this.size + 1.0F; if (kulx > DEAD_DIFFERENCE || kuly > DEAD_DIFFERENCE || kulz > DEAD_DIFFERENCE) { if (hasEffect() && !isShield() && !isExplosion()) createExplosion(2);  func_70106_y(); }  }  if (this.shootingEntity != null && isExplosion() && hasEffect()) { double kulx = this.shootingEntity.field_70165_t - this.field_70165_t; if (kulx < 0.0D) kulx *= -1.0D;  double kuly = this.shootingEntity.field_70163_u - this.field_70163_u; if (kuly < 0.0D) kuly *= -1.0D;  double kulz = this.shootingEntity.field_70161_v - this.field_70161_v; if (kulz < 0.0D) kulz *= -1.0D;  if (kulx > 1.0D || kuly > 1.0D || kulz > 1.0D) this.shootingEntity.func_70107_b(this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v);  }  if (!this.field_70170_p.field_72995_K && this.shootingEntity == null) func_70106_y();  if (!this.field_70170_p.field_72995_K && this.shootingEntity != null && !this.field_70128_L) if (isShield()) { if (JRMCoreConfig.ShieldsMoveWithUser) { this.field_70165_t = this.shootingEntity.field_70165_t; this.field_70163_u = this.shootingEntity.field_70163_u + (this.shootingEntity.field_70131_O * 0.55F); this.field_70161_v = this.shootingEntity.field_70161_v; } else { int diff = (int)(this.field_70165_t - this.shootingEntity.field_70165_t); diff *= (diff > 0) ? 1 : -1; if (diff > 3) func_70106_y();  diff = (int)(this.field_70163_u - this.shootingEntity.field_70163_u); diff *= (diff > 0) ? 1 : -1; if (diff > 3) func_70106_y();  diff = (int)(this.field_70161_v - this.shootingEntity.field_70161_v); diff *= (diff > 0) ? 1 : -1; if (diff > 3) func_70106_y();  }  } else if (isExplosion()) { if (JRMCoreConfig.ExplosionsMoveWithUser) { this.field_70165_t = this.shootingEntity.field_70165_t; this.field_70163_u = this.shootingEntity.field_70163_u + (this.shootingEntity.field_70131_O * 0.55F); this.field_70161_v = this.shootingEntity.field_70161_v; }  }   if (!this.field_70170_p.field_72995_K && this.shootingEntity != null && JRMCoreConfig.dat5710 && (isShield() || isExplosion())) { int curBody = Integer.parseInt(JRMCoreH.data(this.shootingEntity.func_70005_c_(), 8, "200")); if (curBody == 0) func_70106_y();  }  if (!this.field_70170_p.field_72995_K && isContinuesWave() && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) { byte b = JRMCoreH.getByte((EntityPlayer)this.shootingEntity, "jrmcFrng"); if (b == 0 && !this.shrink && JRMCoreConfig.WavesShrinkOnceLetGo) shrink();  }  if (!this.field_70170_p.field_72995_K && isContinuesWave() && this.hadTarget && (this.target == null || this.target.field_70128_L)) func_70106_y();  if (!this.field_70170_p.field_72995_K && isExplosion() && this.field_70173_aa >= JRMCoreConfig.dat5697) func_70106_y();  if (isContinuesWave() && this.target != null) if (JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown) { this.field_70159_w *= 0.05000000074505806D; this.field_70181_x *= 0.05000000074505806D; this.field_70179_y *= 0.05000000074505806D; this.target.field_70159_w *= 0.05000000074505806D; this.target.field_70181_x *= 0.05000000074505806D; this.target.field_70179_y *= 0.05000000074505806D; } else { this.target.field_70159_w = this.field_70159_w; this.target.field_70181_x = this.field_70181_x; this.target.field_70179_y = this.field_70179_y; this.target.field_70165_t = this.field_70165_t; this.target.field_70163_u = this.field_70163_u; this.target.field_70161_v = this.field_70161_v; }   if (this.field_70173_aa == 1) { func_70105_a(this.size, this.size); this.field_70129_M = this.size * 0.5F; }  super.func_70071_h_(); if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) { float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y); this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI); this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, var1) * 180.0D / Math.PI); }  Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile); if (block.func_149688_o() != Material.field_151579_a) { block.func_149719_a((IBlockAccess)this.field_70170_p, this.xTile, this.yTile, this.zTile); AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile); if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) this.inGround = true;  }  if (this.inGround && !isShield() && !isExplosion()) { int var19 = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile); if (!this.field_70170_p.field_72995_K) if (block == this.inTile && var19 == this.inData) { this.ticksInGround++; if (this.ticksInGround == 1) { func_70106_y(); if (!this.field_70170_p.field_72995_K) { if (hasEffect()) createExplosion(1);  playSoundAtEntity(this, (JGConfigDBCGoD.CONFIG_GOD_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && this.destroyer) ? "jinryuudragonbc:DBC5.hakai" : this.ExplSound, 1.0F, 1.0F); }  }  } else { this.inGround = false; this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F); this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F); this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F); this.ticksInGround = 0; this.ticksInAir = 0; }   } else { this.ticksInAir++; Vec3 var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v); Vec3 var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y); MovingObjectPosition movingObject = this.field_70170_p.func_147447_a(var17, var3, false, true, false); var17 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v); var3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y); if (!this.field_70170_p.field_72995_K && (this.ticksInAir >= JRMCoreConfig.EnergyAttackMaxLifeTickPercMulti * this.perc * 0.02F || this.ticksInAir >= JRMCoreConfig.EnergyAttackMaxLifeTick)) func_70106_y();  int t = this.ticksInAir / 10 * 10; if (this.ticksInAir == ((t == 0) ? 10 : t)) playSoundAtEntity(this, "jinryuudragonbc:" + JRMCoreH.techSnds(this.type, 2, this.smove), isBarrage() ? 0.5F : 1.0F, 1.0F);  if (movingObject != null) var3 = Vec3.func_72443_a(movingObject.field_72307_f.field_72450_a, movingObject.field_72307_f.field_72448_b, movingObject.field_72307_f.field_72449_c);  if (!this.field_70170_p.field_72995_K) { List<Entity> entityList; Entity lastEntity = null; byte MODE_OLD = 0, MODE_ONE = 1, MODE_TWO = 2, MODE_THREE = 3, MODE_FOUR = 4, MODE_OFF = 5; byte mode = JRMCoreConfig.KiClosestEntityCheckSize; if (mode == 4) { AxisAlignedBB aabb = this.field_70121_D.func_72329_c(); entityList = this.field_70170_p.func_72839_b(this, aabb); } else if (mode == 3) { AxisAlignedBB aabb = this.field_70121_D.func_72329_c(); entityList = this.field_70170_p.func_72839_b(this, aabb.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y)); } else if (mode == 2) { AxisAlignedBB aabb = this.field_70121_D.func_72329_c(); entityList = this.field_70170_p.func_72839_b(this, aabb.func_72314_b(0.5D, 0.5D, 0.5D)); } else if (mode == 1) { entityList = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y)); } else { entityList = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(0.5D, 0.5D, 0.5D)); }  if (mode != 5) { double lastDistance = 0.0D; for (int n = 0; n < entityList.size(); n++) { Entity entity = entityList.get(n); if (entity instanceof EntityLivingBase && entity.func_70067_L() && (entity != this.shootingEntity || this.ticksInAir >= 5)) { float f = 0.0F; AxisAlignedBB entityHitbox = entity.field_70121_D.func_72314_b(f, f, f); MovingObjectPosition movingObject2 = entityHitbox.func_72327_a(var17, var3); if (movingObject2 != null) { double distance = var17.func_72438_d(movingObject2.field_72307_f); if (distance < lastDistance || lastDistance == 0.0D) { lastEntity = entity; lastDistance = distance; }  }  }  }  if (lastEntity != null) movingObject = new MovingObjectPosition(lastEntity);  }  }  if (this.field_70159_w <= 0.01D && this.field_70181_x <= 0.01D && this.field_70179_y <= 0.01D && this.field_70159_w >= -0.01D && this.field_70181_x >= -0.01D && this.field_70179_y >= -0.01D) if (!this.shrink && !isContinuesWave()) shrink();   if (!this.field_70170_p.field_72995_K) { List<Entity> entityList = checkForEntitiesInside(); int n; for (n = 0; n < entityList.size(); n++) { Entity entity = entityList.get(n); if (entity != null && entity != this.shootingEntity && !entity.field_70128_L) if (entity instanceof EntityEnergyAtt) { EntityEnergyAtt entityKi = (EntityEnergyAtt)entity; if (entityKi.isShield() || entityKi.isExplosion()) handleKiaiClash(entityKi);  } else if (JRMCoreH.NC() && entity instanceof EntityEnergyAttJ3) { EntityEnergyAttJ3 entityShield = (EntityEnergyAttJ3)entity; handleJutsuWallClash(entityShield); }   }  for (n = 0; n < entityList.size(); n++) { Entity entity = entityList.get(n); if (entity != this.shootingEntity) { byte reaction = checkReaction(entity, true); EntityEnergyAtt entityKi = null; if (entity != null) { if (entity instanceof EntityEnergyAtt) entityKi = (EntityEnergyAtt)entity;  if (entity instanceof EntityLivingBase) { if (movingObject == null) movingObject = new MovingObjectPosition(entity);  if (this.target == null && !JRMCoreH.isFusionSpectator(entity)) setTarget(entity);  } else if (isContinuesWave() && this.wave > 0 && this.shootingEntity instanceof EntityPlayer) { shrinkWave(); } else if (!(entity instanceof EntityEnAttacks) && entity != this.shootingEntity && !isShield() && !isExplosion()) { if (hasEffect() && (reaction <= 0 || reaction >= 6) && entity instanceof EntityLivingBase) createExplosion(2);  } else if (entityKi != null && !(entityKi.shootingEntity instanceof EntityDBC) && !this.kiClashedList.contains(entity)) { if (!isShield() && !isExplosion()) { boolean doit = true; byte result = 0; if (JGConfigDBCGoD.CONFIG_GOD_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && this.destroyer) if (this.damage * this.DAMAGE_REDUCTION / 2.0D > entityKi.damage / 2.0D) { entityKi.func_70106_y(); continue; }   if (JRMCoreConfig.dat5705 != 1.0D) if (!entityKi.isShield() && !entityKi.isExplosion()) if (!this.field_70128_L && !entityKi.field_70128_L) result = killWeakerAttack(this, entityKi);    if (result == 0) { if (entityKi != null && !entityKi.field_70128_L && (entityKi.isShield() || entityKi.isExplosion())) doit = false;  if (entityKi != null && !entityKi.field_70128_L && !this.field_70128_L) { this.kiClashed = true; this.kiClashedList.add(entity); if (doit && entityKi.shootingEntity != this.shootingEntity) { float dam = (float)(((EntityEnergyAtt)entity).getDamage() / 2.0D); float spe = ((EntityEnergyAtt)entity).getSpe() * 2.0F; float den = ((EntityEnergyAtt)entity).getDen() * 10.0F; float damt = (float)(this.damage / 2.0D); float spet = this.speed * 2.0F; float dent = this.density * 10.0F; long power = getPower(entityKi); if (power >= 0L) { float res = ((damt - dam) / damt + (spe - spet) / spe + (dent - den) / dent) / 3.0F; this.field_70159_w *= res; this.field_70181_x *= res; this.field_70179_y *= res; if (JGConfigDBCGoD.CONFIG_GOD_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && ((EntityEnergyAtt)entity).destroyer && ((EntityEnergyAtt)entity).damage * this.DAMAGE_REDUCTION / 2.0D <= this.damage / 2.0D) { ((EntityEnergyAtt)entity).field_70159_w = this.field_70159_w; ((EntityEnergyAtt)entity).field_70181_x = this.field_70181_x; ((EntityEnergyAtt)entity).field_70179_y = this.field_70179_y; }  if (((EntityEnergyAtt)entity).getAirTicks() < this.ticksInAir) this.ticksInAir = ((EntityEnergyAtt)entity).getAirTicks();  }  this.conn = 2; }  }  }  } else if (isShield()) { if (!this.field_70170_p.field_72995_K) { boolean doit = true; if ((int)(Math.random() * 3.0D) == 0) doit = false;  if (doit && this.shootingEntity instanceof EntityPlayer) { boolean qckmth = (!entityKi.isShield() && !entityKi.isExplosion()); if (qckmth) { String s2 = JRMCoreH.getString((EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]); JRMCoreH.setString(JRMCoreH.tech_expgiv(s2, JRMCoreH.DBC() ? JRMCoreHDBC.DBCgetConfigTechExpRate() : 1), (EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]); }  }  }  }  }  }  }  if (isExplosion() && (hasEffect() || !entity.equals(this.shootingEntity))) { EntityEnergyAtt energyEntity = null; if (entity instanceof EntityEnergyAtt) energyEntity = (EntityEnergyAtt)entity;  if (entity instanceof EntityLivingBase) { if (movingObject == null) movingObject = new MovingObjectPosition(entity);  if (this.target == null) if (JRMCoreH.isFusionSpectator((movingObject == null) ? null : movingObject.field_72308_g)) this.target = entity;   }  if ((energyEntity == null || energyEntity.shootingEntity instanceof EntityDBC || this.kiClashedList.contains(entity)) && entity != null) { float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y); int var23 = (int)(this.damage * (hasEffect() ? 3.0F : 1.0F) * (entity.equals(this.shootingEntity) ? (JRMCoreConfig.dat5701 / 100.0D) : 1.0D)); giveExperience(entity, 1); DamageSource damagesource = null; if (this.shootingEntity == null || (this.shootingEntity instanceof EntityDBC && entity instanceof EntityDBC)) { func_70106_y(); return; }  damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity); if (func_70027_ad()) entity.func_70015_d(5);  double motX = entity.field_70159_w; double motY = entity.field_70181_x; double motZ = entity.field_70179_y; if (!JRMCoreH.isFusionSpectator((movingObject == null) ? null : movingObject.field_72308_g) && entity.func_70097_a(damagesource, var23)) { if (this.type < 7 && JRMCoreConfig.dat5706[this.type]) { entity.field_70159_w = motX; entity.field_70181_x = motY; entity.field_70179_y = motZ; }  if (entity instanceof EntityLivingBase) { if (!this.field_70170_p.field_72995_K) if (this.shootingEntity instanceof EntityPlayer) { String s2 = JRMCoreH.getString((EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]); JRMCoreH.setString(JRMCoreH.tech_expgiv(s2, JRMCoreH.DBC() ? JRMCoreHDBC.DBCgetConfigTechExpRate() : 1), (EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]); }   if (this.knockbackStrength > 0 && !entity.equals(this.shootingEntity) && (this.type >= 7 || JRMCoreConfig.dat5706[this.type])) { float var25 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y); if (var25 > 0.0F) entity.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / var25, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / var25);  }  }  }  }  }  continue; }  }  if (!isShield()) if (movingObject != null && movingObject.field_72308_g != this.shootingEntity) { if (!this.field_70170_p.field_72995_K && !isExplosion()) if (!JRMCoreH.isFusionSpectator((movingObject == null) ? null : movingObject.field_72308_g) && canSpiralNotGoThrough()) playSoundAtEntity(this, (JGConfigDBCGoD.CONFIG_GOD_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && this.destroyer) ? "jinryuudragonbc:DBC5.hakai" : this.ExplSound, 1.0F, 1.0F);   if (movingObject.field_72308_g != null && (this.shootingEntity instanceof EntityPlayer || movingObject.field_72308_g instanceof EntityPlayer) && isContinuesWave() && this.shooterHolds) { if (this.shootingEntity instanceof EntityPlayer) { this.trgtX = (float)this.field_70165_t; this.trgtY = (float)this.field_70163_u; this.trgtZ = (float)this.field_70161_v; byte b = JRMCoreH.getByte((EntityPlayer)this.shootingEntity, "jrmcFrng"); if (b == 1) { if (this.target != null) { if (this.waveCount == 20) { this.wave = (byte)(this.wave + 1); if (JRMCoreConfig.ContinuesEnergyAttackTimer == 0 && this.wave > 2) this.wave = 2;  if (!this.field_70170_p.field_72995_K) { EntityPlayer Player = (EntityPlayer)this.shootingEntity; byte curRel = JRMCoreH.getByte(Player, "jrmcRelease"); int curEn = JRMCoreH.getInt(Player, "jrmcEnrgy"); float cost2 = (float)(this.cost * curRel * 0.009999999776482582D * (this.perc * 0.02F) * JRMCoreConfig.dat5696[this.type][2]); if (curEn - cost2 <= 0.0F) func_70106_y();  if (cost2 < curEn) { if (!JRMCoreH.isInCreativeMode(this.shootingEntity)) JRMCoreH.setInt(curEn - cost2, Player, "jrmcEnrgy");  this.damage = this.originDmg * curRel * 0.009999999776482582D * this.perc * 0.019999999552965164D * JRMCoreConfig.dat5696[this.type][1]; } else { func_70106_y(); }  }  if (this.wave == 1 && movingObject.field_72308_g instanceof EntityLivingBase) if (!this.field_70170_p.field_72995_K) { EntityLivingBase var24 = (EntityLivingBase)movingObject.field_72308_g; if (this.shootingEntity instanceof EntityPlayer) { String s2 = JRMCoreH.getString((EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]); JRMCoreH.setString(JRMCoreH.tech_expgiv(s2, JRMCoreH.DBC() ? JRMCoreHDBC.DBCgetConfigTechExpRate() : 1), (EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]); }  }   int var23 = (int)this.damage; DamageSource damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity); if (!JRMCoreH.isFusionSpectator((movingObject == null) ? null : movingObject.field_72308_g) && this.target.func_70097_a(damagesource, var23)) weakenSpiral();  if (JRMCoreConfig.ContinuesEnergyAttackTargetSlowdown) { this.field_70159_w *= 0.05000000074505806D; this.field_70181_x *= 0.05000000074505806D; this.field_70179_y *= 0.05000000074505806D; this.target.field_70159_w *= 0.05000000074505806D; this.target.field_70181_x *= 0.05000000074505806D; this.target.field_70179_y *= 0.05000000074505806D; } else { this.target.field_70159_w = this.field_70159_w; this.target.field_70181_x = this.field_70181_x; this.target.field_70179_y = this.field_70179_y; this.target.field_70165_t = this.field_70165_t; this.target.field_70163_u = this.field_70163_u; this.target.field_70161_v = this.field_70161_v; }  }  this.target.field_70159_w = this.field_70159_w; this.target.field_70181_x = this.field_70181_x; this.target.field_70179_y = this.field_70179_y; }  this.waveCount--; if (this.waveCount <= 0) this.waveCount = 20;  if (JRMCoreConfig.ContinuesEnergyAttackTimer > 0) if (this.wave >= JRMCoreConfig.ContinuesEnergyAttackTimer) { if (hasEffect() && !isShield() && !isExplosion()) createExplosion(2);  func_70106_y(); }   } else { shrinkWave(); }  }  if (movingObject.field_72308_g instanceof EntityLivingBase) { if (!JRMCoreH.isFusionSpectator((movingObject == null) ? null : movingObject.field_72308_g)) setTarget(movingObject.field_72308_g);  } else { shrinkWave(); }  } else if (movingObject.field_72308_g != null && (this.shootingEntity instanceof EntityPlayer || movingObject.field_72308_g instanceof EntityPlayer)) { float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y); int var23 = (int)this.damage; giveExperience(movingObject.field_72308_g, 1); DamageSource damagesource = null; if (this.shootingEntity == null || (this.shootingEntity instanceof EntityDBC && movingObject.field_72308_g instanceof EntityDBC)) { func_70106_y(); return; }  damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity); if (func_70027_ad()) movingObject.field_72308_g.func_70015_d(5);  double motX = movingObject.field_72308_g.field_70159_w; double motY = movingObject.field_72308_g.field_70181_x; double motZ = movingObject.field_72308_g.field_70179_y; if (!JRMCoreH.isFusionSpectator((movingObject == null) ? null : movingObject.field_72308_g)) if (movingObject.field_72308_g.func_70097_a(damagesource, var23)) { weakenSpiral(); if (this.type < 7 && !JRMCoreConfig.dat5706[this.type]) { movingObject.field_72308_g.field_70159_w = motX; movingObject.field_72308_g.field_70181_x = motY; movingObject.field_72308_g.field_70179_y = motZ; }  if (movingObject.field_72308_g instanceof EntityLivingBase) { if (!this.field_70170_p.field_72995_K) if (this.shootingEntity instanceof EntityPlayer) { boolean doit = true; if (isBarrage() || isExplosion()) if ((int)(Math.random() * 6.0D) == 0) doit = false;   if (doit) { String s2 = JRMCoreH.getString((EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]); JRMCoreH.setString(JRMCoreH.tech_expgiv(s2, JRMCoreH.DBC() ? JRMCoreHDBC.DBCgetConfigTechExpRate() : 1), (EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]); }  }   if (this.knockbackStrength > 0 && (this.type >= 7 || JRMCoreConfig.dat5706[this.type])) { float var25 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y); if (var25 > 0.0F) movingObject.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / var25, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / var25);  }  }  if (canSpiralNotGoThrough() && !isShield() && !isExplosion()) { if (hasEffect()) createExplosion(2);  func_70106_y(); }  } else if (movingObject.field_72308_g.func_70089_S() && !DBCConfig.KiAttackGoThroughInvulnerableEnemies && !isShield() && !isExplosion() && canSpiralNotGoThrough()) { this.field_70159_w *= -0.10000000149011612D; this.field_70181_x *= -0.10000000149011612D; this.field_70179_y *= -0.10000000149011612D; this.field_70177_z += 180.0F; this.field_70126_B += 180.0F; func_70106_y(); this.ticksInAir = 0; }   } else { this.xTile = movingObject.field_72311_b; this.yTile = movingObject.field_72312_c; this.zTile = movingObject.field_72309_d; this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile); this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile); this.inGround = true; if (this.inTile.func_149688_o() != Material.field_151579_a) this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);  if (movingObject.field_72308_g != null && this.shootingEntity != null) { float var20 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y); int var23 = (int)this.damage; DamageSource damagesource = null; if (this.shootingEntity == null || (this.shootingEntity instanceof EntityDBC && movingObject.field_72308_g instanceof EntityDBC)) { func_70106_y(); return; }  damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity); if (func_70027_ad()) movingObject.field_72308_g.func_70015_d(5);  double motX = movingObject.field_72308_g.field_70159_w; double motY = movingObject.field_72308_g.field_70181_x; double motZ = movingObject.field_72308_g.field_70179_y; if (!JRMCoreH.isFusionSpectator((movingObject == null) ? null : movingObject.field_72308_g)) if (movingObject.field_72308_g.func_70097_a(damagesource, var23)) { weakenSpiral(); if (this.type < 7 && !JRMCoreConfig.dat5706[this.type]) { movingObject.field_72308_g.field_70159_w = motX; movingObject.field_72308_g.field_70181_x = motY; movingObject.field_72308_g.field_70179_y = motZ; }  if (movingObject.field_72308_g instanceof EntityLivingBase) if (this.knockbackStrength > 0 && (this.type >= 7 || JRMCoreConfig.dat5706[this.type])) { float var25 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y); if (var25 > 0.0F) movingObject.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / var25, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / var25);  }   if (hasEffect() && !isShield() && !isExplosion()) createExplosion(2);  func_70106_y(); } else if (!isShield() && !isExplosion()) { this.field_70159_w *= -0.10000000149011612D; this.field_70181_x *= -0.10000000149011612D; this.field_70179_y *= -0.10000000149011612D; this.field_70177_z += 180.0F; this.field_70126_B += 180.0F; func_70106_y(); this.ticksInAir = 0; }   }  }  } else if ((this.wave > 0 || this.waveCount < 20) && this.target != null && this.target.field_70128_L) { shrinkWave(); }   if (!isShield() && !isExplosion()) { this.field_70165_t += this.field_70159_w; this.field_70163_u += this.field_70181_x; this.field_70161_v += this.field_70179_y; }  ShieldPushAwayEntities(); if ((this.field_70125_A - this.field_70127_C) >= 180.0D) this.field_70127_C += 360.0F;  if (this.field_70177_z - this.field_70126_B < -180.0F) this.field_70126_B -= 360.0F;  if (this.field_70177_z - this.field_70126_B >= 180.0F) this.field_70126_B += 360.0F;  float var22 = 1.0F; float var11 = 0.0F; if (func_70090_H()) { for (int var26 = 0; var26 < 4; var26++) { float var27 = 0.25F; this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var27, this.field_70163_u - this.field_70181_x * var27, this.field_70161_v - this.field_70179_y * var27, this.field_70159_w, this.field_70181_x, this.field_70179_y); }  var22 = 1.0F; }  if (!isShield() && !isExplosion()) { this.field_70159_w *= var22; this.field_70181_x *= var22; this.field_70179_y *= var22; this.field_70181_x -= var11; }  func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v); }  if (this.field_70170_p.field_72995_K && this.field_70128_L && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && this.shooterHolds) { EntityPlayer player = (EntityPlayer)this.shootingEntity; ExtendedPlayer.get(player).setAnimKiShoot(0); shrinkWave(); }  }
/*      */   public void func_70106_y() { super.func_70106_y(); if (this.field_70170_p.field_72995_K)
/* 1929 */       if (this.field_70170_p.field_72995_K && this.field_70128_L && this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer && this.shooterHolds) { EntityPlayer player = (EntityPlayer)this.shootingEntity; ExtendedPlayer.get(player).setAnimKiShoot(0); shrinkWave(); DBCClientTickHandler.nuller(); JRMCoreH.isShtng = false; }   } private void checkReacts(Entity entity, byte data) { int var23; DamageSource damagesource; double motX; double motY; double motZ; switch (data) {
/*      */       
/*      */       case 1:
/* 1932 */         func_70106_y();
/*      */         break;
/*      */       case 2:
/* 1935 */         if (!entity.field_70128_L) entity.func_70106_y(); 
/*      */         break;
/*      */       case 3:
/* 1938 */         if (this.effect == 1 && !entity.field_70128_L) entity.func_70106_y(); 
/*      */         break;
/*      */       case 4:
/* 1941 */         var23 = (int)this.damage;
/* 1942 */         damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity);
/* 1943 */         motX = entity.field_70159_w;
/* 1944 */         motY = entity.field_70181_x;
/* 1945 */         motZ = entity.field_70179_y;
/*      */         
/* 1947 */         if (!JRMCoreH.isFusionSpectator(entity) && 
/* 1948 */           entity.func_70097_a(damagesource, var23)) {
/*      */           
/* 1950 */           weakenSpiral();
/* 1951 */           if (this.type < 7 && !JRMCoreConfig.dat5706[this.type]) {
/*      */             
/* 1953 */             entity.field_70159_w = motX;
/* 1954 */             entity.field_70181_x = motY;
/* 1955 */             entity.field_70179_y = motZ;
/*      */           } 
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 5:
/* 1961 */         if (this.effect == 1) {
/*      */           
/* 1963 */           var23 = (int)this.damage;
/* 1964 */           damagesource = Ds.causeEntityEnergyAttDamage(this, this.shootingEntity);
/* 1965 */           motX = entity.field_70159_w;
/* 1966 */           motY = entity.field_70181_x;
/* 1967 */           motZ = entity.field_70179_y;
/*      */ 
/*      */           
/* 1970 */           if (!JRMCoreH.isFusionSpectator(entity) && 
/* 1971 */             entity.func_70097_a(damagesource, var23)) {
/*      */             
/* 1973 */             weakenSpiral();
/* 1974 */             if (this.type < 7 && !JRMCoreConfig.dat5706[this.type]) {
/*      */               
/* 1976 */               entity.field_70159_w = motX;
/* 1977 */               entity.field_70181_x = motY;
/* 1978 */               entity.field_70179_y = motZ;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         break;
/*      */     }  }
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
/*      */   public long getPower(Entity entity) {
/* 1995 */     String powerFormula = JRMCoreConfig.KiAttackPowerFormula;
/*      */     
/* 1997 */     long Power = 0L;
/*      */     
/* 1999 */     long damage = (long)((EntityEnergyAtt)entity).getDamage(), speed = ((EntityEnergyAtt)entity).getSpe(), density = ((EntityEnergyAtt)entity).getDen();
/* 2000 */     String[] Formula = powerFormula.toLowerCase().replace(" ", "").replace("(", "").replace("damage", damage + "").replace("speed", speed + "").replace("density", density + "").split("\\)");
/*      */     
/* 2002 */     for (int i = 0; i < Formula.length; i++) {
/*      */       
/* 2004 */       String formulaSegment = (i == 0) ? Formula[i] : Formula[i].substring(1);
/* 2005 */       String method = formulaSegment.contains("+") ? "+" : (formulaSegment.contains("-") ? "-" : (formulaSegment.contains("*") ? "*" : (formulaSegment.contains("/") ? "/" : (formulaSegment.contains("%") ? "%" : "null"))));
/*      */       
/* 2007 */       long value1 = Long.parseLong(formulaSegment.split("\\" + method)[0]);
/* 2008 */       long value2 = 1L;
/* 2009 */       long result = value1;
/* 2010 */       if (!method.equals("null")) {
/*      */         
/* 2012 */         value2 = Long.parseLong(formulaSegment.split("\\" + method)[1]);
/* 2013 */         result = JGMathHelper.StringMethod(method, value1, value2);
/*      */       } 
/*      */       
/* 2016 */       if (i > 0) {
/*      */         
/* 2018 */         String method2 = Formula[i].substring(0, 1);
/* 2019 */         Power = JGMathHelper.StringMethod(method2, Power, result);
/*      */       }
/*      */       else {
/*      */         
/* 2023 */         Power = result;
/*      */       } 
/*      */     } 
/*      */     
/* 2027 */     return Power;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean canSpiralNotGoThrough() {
/* 2032 */     return isSpiral() ? (!JRMCoreConfig.dat5708[this.effect]) : true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void createExplosion(int type) {
/* 2038 */     if (JGConfigDBCGoD.CONFIG_GOD_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && this.destroyer) type = 10; 
/* 2039 */     JRMCoreH.newExpl(this.field_70170_p, this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.explevel, false, this.damage, this.shootingEntity, (byte)type);
/*      */   }
/*      */ 
/*      */   
/*      */   private List checkForEntitiesInside() {
/* 2044 */     AxisAlignedBB aabb = this.field_70121_D.func_72329_c();
/* 2045 */     List entityList = this.field_70170_p.func_72839_b(this, aabb);
/* 2046 */     return entityList;
/*      */   }
/*      */ 
/*      */   
/*      */   private void giveExperience(Entity entity, int amount) {
/* 2051 */     if (JRMCoreH.DGE(entity) && !this.givenExp) {
/*      */       
/* 2053 */       JRMCoreH.jrmcExp(this.shootingEntity, amount, getType());
/* 2054 */       this.givenExp = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void playSoundAtEntity(Entity entity, String s, float f, float f1) {
/* 2060 */     this.field_70170_p.func_72956_a(entity, s, f, f1);
/* 2061 */     if (isWave() && this.shooterHolds) this.field_70170_p.func_72908_a(strtX(), strtY(), strtZ(), s, f, f1);
/*      */   
/*      */   }
/*      */   
/*      */   private void shrinkWave() {
/* 2066 */     JRMCoreH.setByte(0, (EntityPlayer)this.shootingEntity, "jrmcFrng");
/* 2067 */     if (!this.shrink)
/*      */     {
/* 2069 */       shrink();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void shrink() {
/* 2075 */     this.shrink = true;
/* 2076 */     func_70096_w().func_75692_b(20, Integer.valueOf(1));
/*      */   }
/*      */ 
/*      */   
/*      */   private void setTarget(Entity entity) {
/* 2081 */     this.target = entity;
/* 2082 */     this.hadTarget = true;
/*      */   }
/*      */ 
/*      */   
/*      */   private byte killWeakerAttack(EntityEnergyAtt attack1, EntityEnergyAtt attack2) {
/* 2087 */     long power1 = getPower(attack1);
/* 2088 */     long power2 = getPower(attack2);
/* 2089 */     boolean amIStronger = (power1 > power2);
/*      */     
/* 2091 */     if (power1 != power2) {
/* 2092 */       if (amIStronger) {
/*      */         
/* 2094 */         if (power1 / JRMCoreConfig.dat5705 >= power2)
/*      */         {
/*      */           
/* 2097 */           return 2;
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 2102 */       else if (power2 / JRMCoreConfig.dat5705 >= power1) {
/*      */         
/* 2104 */         func_70106_y();
/* 2105 */         return 1;
/*      */       } 
/*      */     }
/*      */     
/* 2109 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   private void handleJutsuWallClash(EntityEnergyAttJ3 shield) {
/* 2114 */     if (JRMCoreH.NC() && shield != this.shootingEntity && shield instanceof EntityEnAttacks) {
/*      */       
/* 2116 */       long shieldPower = shield.getPower(shield);
/* 2117 */       long kiPower = getPower(this);
/* 2118 */       double kiDamage = getDamage();
/*      */ 
/*      */       
/* 2121 */       if (JGConfigDBCGoD.CONFIG_GOD_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && this.destroyer && 
/* 2122 */         kiPower > shieldPower) {
/* 2123 */         shield.func_70106_y();
/*      */ 
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */ 
/*      */       
/* 2131 */       if (kiPower > shieldPower) {
/*      */         
/* 2133 */         setDamage(((float)getDamage() - (float)shield.getDamage()));
/* 2134 */         shield.func_70106_y();
/*      */       
/*      */       }
/* 2137 */       else if (kiPower < shieldPower) {
/*      */         
/* 2139 */         shield.setDamage(((float)shield.getDamage() - (float)kiDamage));
/* 2140 */         func_70106_y();
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 2145 */         shield.func_70106_y();
/* 2146 */         func_70106_y();
/*      */       } 
/*      */       
/* 2149 */       shield.field_70159_w = 0.0D;
/* 2150 */       shield.field_70181_x = 0.0D;
/* 2151 */       shield.field_70179_y = 0.0D;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void handleKiaiClash(EntityEnergyAtt attack) {
/* 2157 */     float dam = (float)attack.getDamage();
/*      */     
/* 2159 */     if (JGConfigDBCGoD.CONFIG_GOD_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && this.destroyer && 
/* 2160 */       this.damage * this.DAMAGE_REDUCTION / 2.0D > dam) {
/* 2161 */       attack.func_70106_y();
/* 2162 */       String s2 = JRMCoreH.getString((EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]);
/* 2163 */       JRMCoreH.setString(JRMCoreH.tech_expgiv(s2, JRMCoreH.DBC() ? JRMCoreHDBC.DBCgetConfigTechExpRate() : 1), (EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 2169 */     if (this.damage / 2.0D > dam) {
/*      */       
/* 2171 */       setDamage(getDamage() - dam);
/* 2172 */       attack.func_70106_y();
/*      */     
/*      */     }
/* 2175 */     else if (this.damage / 2.0D < dam) {
/*      */       
/* 2177 */       attack.setDamage(dam - this.damage / 2.0D);
/*      */       
/* 2179 */       if (this.shootingEntity instanceof EntityPlayer) {
/*      */         
/* 2181 */         boolean doit2 = false;
/*      */         
/* 2183 */         if (JRMCoreConfig.dat5707 != 0)
/*      */         {
/*      */           
/* 2186 */           if ((int)(Math.random() * 100.0D) < JRMCoreConfig.dat5707) doit2 = true;
/*      */         
/*      */         }
/* 2189 */         if (doit2) {
/*      */           
/* 2191 */           String s2 = JRMCoreH.getString((EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]);
/* 2192 */           JRMCoreH.setString(JRMCoreH.tech_expgiv(s2, JRMCoreH.DBC() ? JRMCoreHDBC.DBCgetConfigTechExpRate() : 1), (EntityPlayer)this.shootingEntity, JRMCoreH.techNbt[this.technum]);
/*      */         } 
/*      */       } 
/*      */       
/* 2196 */       func_70106_y();
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 2201 */       func_70106_y();
/* 2202 */       attack.func_70106_y();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isWave() {
/* 2207 */     return (getType() == 0);
/* 2208 */   } public boolean isBlast() { return (getType() == 1); }
/* 2209 */   public boolean isDisk() { return (getType() == 2); }
/* 2210 */   public boolean isLaser() { return (getType() == 3); }
/* 2211 */   public boolean isLargeBlast() { return (getType() == 5); }
/* 2212 */   public boolean isSpiral() { return (getType() == 4); }
/* 2213 */   public boolean isBarrage() { return (getType() == 6); }
/* 2214 */   public boolean isShield() { return (getType() == 7); } public boolean isExplosion() {
/* 2215 */     return (getType() == 8);
/*      */   } private boolean hasEffect() {
/* 2217 */     return (this.effect == 1);
/*      */   }
/*      */ 
/*      */   
/*      */   private void ShieldPushAwayEntities() {
/* 2222 */     if (!this.field_70170_p.field_72995_K && isShield() && hasEffect()) {
/*      */       
/* 2224 */       Entity var5 = null;
/* 2225 */       List<Entity> var6 = checkForEntitiesInside();
/*      */       
/* 2227 */       for (int var9 = 0; var9 < var6.size(); var9++) {
/*      */         
/* 2229 */         var5 = var6.get(var9);
/* 2230 */         if (!var5.equals(this.shootingEntity))
/*      */         {
/* 2232 */           if (var5 instanceof EntityLivingBase) {
/*      */             
/* 2234 */             float res = 0.5F;
/* 2235 */             var5.field_70159_w = (res - var5.field_70165_t - this.field_70165_t) * -1.0D;
/* 2236 */             var5.field_70181_x = (res - var5.field_70163_u - this.field_70163_u) * -1.0D;
/* 2237 */             var5.field_70179_y = (res - var5.field_70161_v - this.field_70161_v) * -1.0D;
/* 2238 */             var5.field_70133_I = true;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
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
/*      */   public void func_70014_b(NBTTagCompound nbt) {
/* 2256 */     nbt.func_74777_a("xTile", (short)this.xTile);
/* 2257 */     nbt.func_74777_a("yTile", (short)this.yTile);
/* 2258 */     nbt.func_74777_a("zTile", (short)this.zTile);
/* 2259 */     nbt.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 2260 */     nbt.func_74774_a("inData", (byte)this.inData);
/* 2261 */     nbt.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 2262 */     nbt.func_74780_a("damage", this.damage);
/* 2263 */     nbt.func_74776_a("size", this.size);
/* 2264 */     nbt.func_74757_a("destroyer", this.destroyer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound nbt) {
/* 2274 */     this.xTile = nbt.func_74765_d("xTile");
/* 2275 */     this.yTile = nbt.func_74765_d("yTile");
/* 2276 */     this.zTile = nbt.func_74765_d("zTile");
/* 2277 */     this.inTile = Block.func_149729_e(nbt.func_74771_c("inTile") & 0xFF);
/* 2278 */     this.inData = nbt.func_74771_c("inData") & 0xFF;
/* 2279 */     this.inGround = (nbt.func_74771_c("inGround") == 1);
/*      */     
/* 2281 */     if (nbt.func_74764_b("damage")) this.damage = nbt.func_74769_h("damage"); 
/* 2282 */     if (nbt.func_74764_b("size")) this.size = nbt.func_74760_g("size"); 
/* 2283 */     if (nbt.func_74764_b("destroyer")) this.destroyer = nbt.func_74767_n("destroyer");
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70100_b_(EntityPlayer par1EntityPlayer) {}
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean func_70041_e_() {
/* 2295 */     return false;
/*      */   } @SideOnly(Side.CLIENT)
/*      */   public float func_70053_R() {
/* 2298 */     return 0.0F;
/*      */   } public void setDamage(double par1) {
/* 2300 */     this.damage = par1;
/*      */   } public double getDamage() {
/* 2302 */     return this.damage * ((JGConfigDBCGoD.CONFIG_GOD_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && this.destroyer) ? this.DAMAGE_REDUCTION : 1.0F);
/*      */   }
/*      */   public void setKnockbackStrength(int par1) {
/* 2305 */     this.knockbackStrength = par1;
/*      */   } public boolean func_70075_an() {
/* 2307 */     return false;
/*      */   }
/*      */   public boolean func_82704_a(Entity var1) {
/* 2310 */     return false;
/*      */   }
/*      */   
/*      */   public void writeSpawnData(ByteBuf data) {
/* 2314 */     data.writeInt((this.shootingEntity == null) ? 0 : this.shootingEntity.func_145782_y());
/* 2315 */     data.writeInt((this.target == null) ? 0 : this.target.func_145782_y());
/* 2316 */     data.writeByte(this.perc);
/* 2317 */     data.writeByte(this.type);
/* 2318 */     data.writeByte(this.speed);
/* 2319 */     data.writeByte(this.perc);
/* 2320 */     data.writeByte(this.effect);
/* 2321 */     data.writeInt(this.color);
/* 2322 */     data.writeInt(this.dam);
/* 2323 */     data.writeByte(this.density);
/* 2324 */     data.writeShort(this.sincantation);
/*      */ 
/*      */     
/* 2327 */     String se = "";
/* 2328 */     if (this.sts != null) {
/* 2329 */       for (int i = 0; i < this.sts.length; ) { se = se + "," + this.sts[i]; i++; }
/* 2330 */        se = se.substring(1);
/*      */     } 
/* 2332 */     ByteBufUtils.writeUTF8String(data, se);
/*      */     
/* 2334 */     data.writeByte(this.technum);
/* 2335 */     data.writeShort(this.sfire);
/* 2336 */     data.writeShort(this.smove);
/* 2337 */     data.writeFloat(this.strtX);
/* 2338 */     data.writeFloat(this.strtY);
/* 2339 */     data.writeFloat(this.strtZ);
/* 2340 */     data.writeFloat(this.size);
/* 2341 */     data.writeFloat(this.trgtX);
/* 2342 */     data.writeFloat(this.trgtY);
/* 2343 */     data.writeFloat(this.trgtZ);
/* 2344 */     data.writeByte(this.shrink ? 1 : 0);
/* 2345 */     data.writeFloat(this.explevel);
/* 2346 */     data.writeInt(this.color2);
/* 2347 */     data.writeDouble(this.damage);
/* 2348 */     data.writeDouble(this.damageOriginal);
/* 2349 */     data.writeInt(this.damageTaken);
/* 2350 */     data.writeBoolean(this.destroyer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readSpawnData(ByteBuf data) {
/* 2358 */     int first = data.readInt();
/* 2359 */     this.shootingEntity = (first == 0) ? this.shootingEntity : this.field_70170_p.func_73045_a(first);
/* 2360 */     int second = data.readInt();
/* 2361 */     this.target = (first == 0) ? this.target : this.field_70170_p.func_73045_a(second);
/* 2362 */     this.perc = data.readByte();
/* 2363 */     this.type = data.readByte();
/* 2364 */     this.speed = data.readByte();
/* 2365 */     this.perc = data.readByte();
/* 2366 */     this.effect = (short)data.readByte();
/* 2367 */     this.color = data.readInt();
/* 2368 */     this.dam = data.readInt();
/* 2369 */     this.density = data.readByte();
/* 2370 */     this.sincantation = data.readShort();
/*      */     
/* 2372 */     String[] se = ByteBufUtils.readUTF8String(data).split(",");
/* 2373 */     if (se.length < 3) {
/* 2374 */       byte[] sts2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
/* 2375 */       this.sts = sts2;
/*      */     } else {
/* 2377 */       byte[] sts2 = new byte[se.length];
/* 2378 */       for (int i = 0; i < se.length; ) { sts2[i] = Byte.parseByte(se[i]); i++; }
/* 2379 */        this.sts = sts2;
/*      */     } 
/*      */     
/* 2382 */     this.technum = data.readByte();
/* 2383 */     this.sfire = data.readShort();
/* 2384 */     this.smove = data.readShort();
/* 2385 */     this.strtX = data.readFloat();
/* 2386 */     this.strtY = data.readFloat();
/* 2387 */     this.strtZ = data.readFloat();
/* 2388 */     this.size = data.readFloat();
/* 2389 */     this.trgtX = data.readFloat();
/* 2390 */     this.trgtY = data.readFloat();
/* 2391 */     this.trgtZ = data.readFloat();
/* 2392 */     this.shrink = (data.readByte() == 1);
/* 2393 */     this.explevel = data.readFloat();
/* 2394 */     this.color2 = data.readInt();
/* 2395 */     this.damage = data.readDouble();
/*      */ 
/*      */     
/* 2398 */     this.damageOriginal = data.readDouble();
/* 2399 */     this.damageTaken = data.readInt();
/* 2400 */     this.destroyer = data.readBoolean();
/*      */   }
/*      */   
/*      */   public Entity getThrower() {
/* 2404 */     return null;
/*      */   }
/*      */   public void setThrower(Entity entity) {}
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/* 2409 */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) { return true; }
/*      */   @SideOnly(Side.CLIENT)
/* 2411 */   public double getMaxRenderDistanceSquared() { return 65536.0D; } public boolean func_70112_a(double par1) {
/* 2412 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void generateParticles(EntityEnergyAtt entityBlast, Entity entity, int color, int color2, boolean startSpawn) {
/* 2418 */     if (entityBlast != null && entity != null && entityBlast.field_70170_p.field_72995_K)
/*      */     {
/* 2420 */       for (int i = 0; i < 3; i++) {
/* 2421 */         for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*      */           double x2, y2, z2;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2427 */           float colorFixer = 0.7F;
/*      */           
/* 2429 */           float red = (color >> 16 & 0xFF) / 255.0F;
/* 2430 */           float green = (color >> 8 & 0xFF) / 255.0F;
/* 2431 */           float blue = (color & 0xFF) / 255.0F;
/* 2432 */           red *= 0.7F; green *= 0.7F; blue *= 0.7F;
/*      */ 
/*      */ 
/*      */           
/* 2436 */           float red2 = (color2 >> 16 & 0xFF) / 255.0F;
/* 2437 */           float green2 = (color2 >> 8 & 0xFF) / 255.0F;
/* 2438 */           float blue2 = (color2 & 0xFF) / 255.0F;
/*      */ 
/*      */           
/* 2441 */           float alpha = 1.0F;
/*      */           
/* 2443 */           float out = 1.0F, in = 1.5F;
/* 2444 */           float life = 0.4F * entity.field_70131_O;
/* 2445 */           float extra_scale = 0.3F;
/* 2446 */           int dea = 30;
/*      */           
/* 2448 */           float target_fullsize_one1 = 0.32F;
/* 2449 */           float targetsizeMin = entity.field_70131_O * 8.0F / target_fullsize_one1 * 0.01F;
/*      */           
/* 2451 */           float target_fullsize_one2 = 0.32F;
/* 2452 */           float targetsizeMax = entity.field_70131_O * 26.0F / target_fullsize_one2 * 0.01F;
/*      */ 
/*      */           
/* 2455 */           double x = (Math.random() * (entity.field_70131_O * 2.0F) - entity.field_70131_O) * 0.800000011920929D;
/* 2456 */           double y = (Math.random() * (entity.field_70131_O * 2.0F) - entity.field_70131_O) * 0.800000011920929D;
/* 2457 */           double z = (Math.random() * (entity.field_70131_O * 2.0F) - entity.field_70131_O) * 0.800000011920929D;
/*      */ 
/*      */ 
/*      */           
/* 2461 */           Vec3 vec3 = entity.func_70040_Z();
/*      */ 
/*      */           
/* 2464 */           double d8 = (entity.field_70130_N + (startSpawn ? 0.0F : 1.5F));
/* 2465 */           double d9 = entity.field_70131_O;
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
/* 2481 */           if (startSpawn) {
/*      */             
/* 2483 */             x2 = entityBlast.strtX();
/* 2484 */             y2 = entityBlast.strtY();
/* 2485 */             z2 = entityBlast.strtZ();
/* 2486 */             x2 += vec3.field_72450_a * d8;
/* 2487 */             y2 += vec3.field_72448_b * d9 + (entity.field_70131_O * 0.4F);
/* 2488 */             z2 += vec3.field_72449_c * d8;
/*      */           }
/*      */           else {
/*      */             
/* 2492 */             x2 = entityBlast.field_70165_t;
/* 2493 */             y2 = entityBlast.field_70163_u;
/* 2494 */             z2 = entityBlast.field_70161_v;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2504 */           x2 += x;
/* 2505 */           y2 += y;
/* 2506 */           z2 += z;
/*      */           
/* 2508 */           float rotationYaw = -entityBlast.field_70177_z, rotationPitch = -entityBlast.field_70125_A;
/* 2509 */           double motionX = (-MathHelper.func_76126_a(rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(rotationPitch / 180.0F * 3.1415927F));
/* 2510 */           double motionZ = (MathHelper.func_76134_b(rotationYaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(rotationPitch / 180.0F * 3.1415927F));
/* 2511 */           double motionY = -MathHelper.func_76126_a(rotationPitch / 180.0F * 3.1415927F);
/*      */           
/* 2513 */           if (startSpawn) {
/*      */             
/* 2515 */             x2 += -motionX * 3.0D;
/* 2516 */             y2 += -motionY * 3.0D;
/* 2517 */             y2 -= entityBlast.field_70131_O * 0.25D;
/* 2518 */             z2 += -motionZ * 3.0D;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2524 */           motionX *= 0.5D;
/* 2525 */           motionY *= 0.5D;
/* 2526 */           motionY += ((float)(Math.random() * 0.10000000149011612D) - 0.05F);
/* 2527 */           motionZ *= 0.5D;
/*      */           
/* 2529 */           if (startSpawn) {
/*      */             
/* 2531 */             motionX *= -1.0D;
/* 2532 */             motionY *= -1.0D;
/* 2533 */             motionZ *= -1.0D;
/*      */           } 
/*      */           
/* 2536 */           float scaleStart = ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.3F;
/* 2537 */           float scaleEnd = ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.3F;
/* 2538 */           float scaleSpeed = 0.2F * life * 0.3F;
/*      */           
/* 2540 */           int textureID = (int)(Math.random() * 3.0D) + 8;
/*      */           
/* 2542 */           Entity particle = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.field_70170_p, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart, scaleEnd, scaleStart, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F, 0.0F, 0.9F, 0.95F, 0.06F, false, -1, true, null);
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
/* 2555 */           entity.field_70170_p.func_72838_d(particle);
/*      */           
/* 2557 */           Entity particle2 = new EntityCusPar("jinryuumodscore:bens_particles.png", entity.field_70170_p, 0.2F, 0.2F, x2, y2, z2, 0.0D, 0.0D, 0.0D, -motionX, -motionY, -motionZ, 0.0F, textureID, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, scaleStart * 0.8F, scaleEnd * 0.8F, scaleStart * 0.8F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.6F, 0.0F, 0.9F, 0.95F, 0.06F, false, -1, true, null);
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
/* 2570 */           entity.field_70170_p.func_72838_d(particle2);
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void weakenSpiral() {
/* 2577 */     if (isSpiral() && !canSpiralNotGoThrough() && JRMCoreConfig.SpiralWeakensAfterHit > 0) {
/*      */       
/* 2579 */       double minusDamage = JRMCoreConfig.SpiralWeakensAfterHit / 100.0D;
/* 2580 */       if (JRMCoreConfig.SpiralWeakensBasedOnStartDamage) {
/*      */         
/* 2582 */         if ((1.0D - minusDamage) * this.damageTaken > this.damage || this.damage <= 0.0D) {
/*      */           
/* 2584 */           func_70106_y();
/*      */         } else {
/* 2586 */           this.damage = this.damageOriginal * (1.0D - minusDamage * this.damageTaken);
/* 2587 */         }  this.damageTaken++;
/*      */ 
/*      */       
/*      */       }
/* 2591 */       else if (this.damage <= 0.0D) {
/*      */         
/* 2593 */         func_70106_y();
/*      */       } else {
/* 2595 */         this.damage *= minusDamage;
/*      */       } 
/* 2597 */       if (this.damage < 0.0D) {
/*      */         
/* 2599 */         this.damage = 0.0D;
/* 2600 */         func_70106_y();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public float rad(float angle) {
/* 2606 */     return angle * 3.1415927F / 180.0F;
/*      */   } }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityEnergyAtt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */