/*     */ package net.minecraft.util;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.entity.projectile.EntityFireball;
/*     */ import net.minecraft.world.Explosion;
/*     */ 
/*     */ 
/*     */ public class DamageSource
/*     */ {
/*  13 */   public static DamageSource field_76372_a = (new DamageSource("inFire")).func_76361_j();
/*  14 */   public static DamageSource field_76370_b = (new DamageSource("onFire")).func_76348_h().func_76361_j();
/*  15 */   public static DamageSource field_76371_c = (new DamageSource("lava")).func_76361_j();
/*  16 */   public static DamageSource field_76368_d = (new DamageSource("inWall")).func_76348_h();
/*  17 */   public static DamageSource field_76369_e = (new DamageSource("drown")).func_76348_h();
/*  18 */   public static DamageSource field_76366_f = (new DamageSource("starve")).func_76348_h().func_151518_m();
/*  19 */   public static DamageSource field_76367_g = new DamageSource("cactus");
/*  20 */   public static DamageSource field_76379_h = (new DamageSource("fall")).func_76348_h();
/*  21 */   public static DamageSource field_76380_i = (new DamageSource("outOfWorld")).func_76348_h().func_76359_i();
/*  22 */   public static DamageSource field_76377_j = (new DamageSource("generic")).func_76348_h();
/*  23 */   public static DamageSource field_76376_m = (new DamageSource("magic")).func_76348_h().func_82726_p();
/*  24 */   public static DamageSource field_82727_n = (new DamageSource("wither")).func_76348_h();
/*  25 */   public static DamageSource field_82728_o = new DamageSource("anvil");
/*  26 */   public static DamageSource field_82729_p = new DamageSource("fallingBlock"); private boolean field_76374_o;
/*     */   
/*     */   public static DamageSource func_76358_a(EntityLivingBase p_76358_0_) {
/*  29 */     return new EntityDamageSource("mob", (Entity)p_76358_0_);
/*     */   }
/*     */   private boolean field_76385_p; private boolean field_151520_r;
/*     */   public static DamageSource func_76365_a(EntityPlayer p_76365_0_) {
/*  33 */     return new EntityDamageSource("player", (Entity)p_76365_0_);
/*     */   }
/*     */   
/*     */   public static DamageSource func_76353_a(EntityArrow p_76353_0_, Entity p_76353_1_) {
/*  37 */     return (new EntityDamageSourceIndirect("arrow", (Entity)p_76353_0_, p_76353_1_)).func_76349_b();
/*     */   }
/*     */   
/*     */   public static DamageSource func_76362_a(EntityFireball p_76362_0_, Entity p_76362_1_) {
/*  41 */     if (p_76362_1_ == null) {
/*  42 */       return (new EntityDamageSourceIndirect("onFire", (Entity)p_76362_0_, (Entity)p_76362_0_)).func_76361_j().func_76349_b();
/*     */     }
/*  44 */     return (new EntityDamageSourceIndirect("fireball", (Entity)p_76362_0_, p_76362_1_)).func_76361_j().func_76349_b();
/*     */   }
/*     */   
/*     */   public static DamageSource func_76356_a(Entity p_76356_0_, Entity p_76356_1_) {
/*  48 */     return (new EntityDamageSourceIndirect("thrown", p_76356_0_, p_76356_1_)).func_76349_b();
/*     */   }
/*     */   
/*     */   public static DamageSource func_76354_b(Entity p_76354_0_, Entity p_76354_1_) {
/*  52 */     return (new EntityDamageSourceIndirect("indirectMagic", p_76354_0_, p_76354_1_)).func_76348_h().func_82726_p();
/*     */   }
/*     */   
/*     */   public static DamageSource func_92087_a(Entity p_92087_0_) {
/*  56 */     return (new EntityDamageSource("thorns", p_92087_0_)).func_82726_p();
/*     */   }
/*     */   
/*     */   public static DamageSource func_94539_a(Explosion p_94539_0_) {
/*  60 */     if (p_94539_0_ != null && p_94539_0_.func_94613_c() != null) {
/*  61 */       return (new EntityDamageSource("explosion.player", (Entity)p_94539_0_.func_94613_c())).func_76351_m().func_94540_d();
/*     */     }
/*  63 */     return (new DamageSource("explosion")).func_76351_m().func_94540_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private float field_76384_q = 0.3F; private boolean field_76383_r; private boolean field_76382_s;
/*     */   private boolean field_76381_t;
/*     */   private boolean field_82730_x;
/*     */   private boolean field_76378_k;
/*     */   public String field_76373_n;
/*     */   private static final String __OBFID = "CL_00001521";
/*     */   
/*     */   public boolean func_76352_a() {
/*  79 */     return this.field_76382_s;
/*     */   }
/*     */   
/*     */   public DamageSource func_76349_b() {
/*  83 */     this.field_76382_s = true;
/*  84 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_94541_c() {
/*  88 */     return this.field_76378_k;
/*     */   }
/*     */   
/*     */   public DamageSource func_94540_d() {
/*  92 */     this.field_76378_k = true;
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_76363_c() {
/*  97 */     return this.field_76374_o;
/*     */   }
/*     */   
/*     */   public float func_76345_d() {
/* 101 */     return this.field_76384_q;
/*     */   }
/*     */   
/*     */   public boolean func_76357_e() {
/* 105 */     return this.field_76385_p;
/*     */   }
/*     */   
/*     */   public boolean func_151517_h() {
/* 109 */     return this.field_151520_r;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DamageSource(String p_i1566_1_) {
/* 115 */     this.field_76373_n = p_i1566_1_;
/*     */   }
/*     */   
/*     */   public Entity func_76364_f() {
/* 119 */     return func_76346_g();
/*     */   }
/*     */   
/*     */   public Entity func_76346_g() {
/* 123 */     return null;
/*     */   }
/*     */   
/*     */   public DamageSource func_76348_h() {
/* 127 */     this.field_76374_o = true;
/*     */     
/* 129 */     this.field_76384_q = 0.0F;
/* 130 */     return this;
/*     */   }
/*     */   
/*     */   public DamageSource func_76359_i() {
/* 134 */     this.field_76385_p = true;
/* 135 */     return this;
/*     */   }
/*     */   
/*     */   public DamageSource func_151518_m() {
/* 139 */     this.field_151520_r = true;
/*     */     
/* 141 */     this.field_76384_q = 0.0F;
/* 142 */     return this;
/*     */   }
/*     */   
/*     */   public DamageSource func_76361_j() {
/* 146 */     this.field_76383_r = true;
/* 147 */     return this;
/*     */   }
/*     */   
/*     */   public IChatComponent func_151519_b(EntityLivingBase p_151519_1_) {
/* 151 */     EntityLivingBase entityLivingBase = p_151519_1_.func_94060_bK();
/* 152 */     String str1 = "death.attack." + this.field_76373_n;
/* 153 */     String str2 = str1 + ".player";
/*     */     
/* 155 */     if (entityLivingBase != null && StatCollector.func_94522_b(str2)) {
/* 156 */       return new ChatComponentTranslation(str2, new Object[] { p_151519_1_.func_145748_c_(), entityLivingBase.func_145748_c_() });
/*     */     }
/* 158 */     return new ChatComponentTranslation(str1, new Object[] { p_151519_1_.func_145748_c_() });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_76347_k() {
/* 163 */     return this.field_76383_r;
/*     */   }
/*     */   
/*     */   public String func_76355_l() {
/* 167 */     return this.field_76373_n;
/*     */   }
/*     */   
/*     */   public DamageSource func_76351_m() {
/* 171 */     this.field_76381_t = true;
/* 172 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_76350_n() {
/* 176 */     return this.field_76381_t;
/*     */   }
/*     */   
/*     */   public boolean func_82725_o() {
/* 180 */     return this.field_82730_x;
/*     */   }
/*     */   
/*     */   public DamageSource func_82726_p() {
/* 184 */     this.field_82730_x = true;
/* 185 */     return this;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\DamageSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */