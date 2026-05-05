/*     */ package net.minecraft.entity;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityCreature extends EntityLiving {
/*  16 */   public static final UUID field_110179_h = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
/*  17 */   public static final AttributeModifier field_110181_i = (new AttributeModifier(field_110179_h, "Fleeing speed bonus", 2.0D, 2)).func_111168_a(false); private PathEntity field_70786_d;
/*     */   protected Entity field_70789_a;
/*     */   protected boolean field_70787_b;
/*     */   protected int field_70788_c;
/*     */   
/*     */   public EntityCreature(World p_i1602_1_) {
/*  23 */     super(p_i1602_1_);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  33 */     this.field_70775_bC = new ChunkCoordinates(0, 0, 0);
/*  34 */     this.field_70772_bD = -1.0F;
/*     */     this.field_110178_bs = (EntityAIBase)new EntityAIMoveTowardsRestriction(this, 1.0D);
/*     */   }
/*     */   private ChunkCoordinates field_70775_bC; private float field_70772_bD; private EntityAIBase field_110178_bs; private boolean field_110180_bt; private static final String __OBFID = "CL_00001558";
/*     */   protected boolean func_70780_i() {
/*  39 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/*  44 */     this.field_70170_p.field_72984_F.func_76320_a("ai");
/*  45 */     if (this.field_70788_c > 0 && 
/*  46 */       --this.field_70788_c == 0) {
/*  47 */       IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/*  48 */       iAttributeInstance.func_111124_b(field_110181_i);
/*     */     } 
/*     */     
/*  51 */     this.field_70787_b = func_70780_i();
/*  52 */     float f = 16.0F;
/*     */     
/*  54 */     if (this.field_70789_a == null) {
/*  55 */       this.field_70789_a = func_70782_k();
/*  56 */       if (this.field_70789_a != null) {
/*  57 */         this.field_70786_d = this.field_70170_p.func_72865_a(this, this.field_70789_a, f, true, false, false, true);
/*     */       }
/*     */     }
/*  60 */     else if (this.field_70789_a.func_70089_S()) {
/*  61 */       float f1 = this.field_70789_a.func_70032_d(this);
/*  62 */       if (func_70685_l(this.field_70789_a)) {
/*  63 */         func_70785_a(this.field_70789_a, f1);
/*     */       }
/*     */     } else {
/*  66 */       this.field_70789_a = null;
/*     */     } 
/*     */     
/*  69 */     if (this.field_70789_a instanceof EntityPlayerMP && 
/*  70 */       ((EntityPlayerMP)this.field_70789_a).field_71134_c.func_73083_d()) {
/*  71 */       this.field_70789_a = null;
/*     */     }
/*     */     
/*  74 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */ 
/*     */     
/*  77 */     if (!this.field_70787_b && this.field_70789_a != null && (this.field_70786_d == null || this.field_70146_Z.nextInt(20) == 0)) {
/*  78 */       this.field_70786_d = this.field_70170_p.func_72865_a(this, this.field_70789_a, f, true, false, false, true);
/*  79 */     } else if (!this.field_70787_b && ((this.field_70786_d == null && this.field_70146_Z.nextInt(180) == 0) || this.field_70146_Z.nextInt(120) == 0 || this.field_70788_c > 0) && 
/*  80 */       this.field_70708_bq < 100) {
/*  81 */       func_70779_j();
/*     */     } 
/*     */ 
/*     */     
/*  85 */     int i = MathHelper.func_76128_c(this.field_70121_D.field_72338_b + 0.5D);
/*     */     
/*  87 */     boolean bool1 = func_70090_H();
/*  88 */     boolean bool2 = func_70058_J();
/*  89 */     this.field_70125_A = 0.0F;
/*  90 */     if (this.field_70786_d == null || this.field_70146_Z.nextInt(100) == 0) {
/*  91 */       super.func_70626_be();
/*  92 */       this.field_70786_d = null;
/*     */       
/*     */       return;
/*     */     } 
/*  96 */     this.field_70170_p.field_72984_F.func_76320_a("followpath");
/*  97 */     Vec3 vec3 = this.field_70786_d.func_75878_a(this);
/*  98 */     double d = (this.field_70130_N * 2.0F);
/*  99 */     while (vec3 != null && vec3.func_72445_d(this.field_70165_t, vec3.field_72448_b, this.field_70161_v) < d * d) {
/* 100 */       this.field_70786_d.func_75875_a();
/* 101 */       if (this.field_70786_d.func_75879_b()) {
/* 102 */         vec3 = null;
/* 103 */         this.field_70786_d = null; continue;
/* 104 */       }  vec3 = this.field_70786_d.func_75878_a(this);
/*     */     } 
/*     */     
/* 107 */     this.field_70703_bu = false;
/* 108 */     if (vec3 != null) {
/* 109 */       double d1 = vec3.field_72450_a - this.field_70165_t;
/* 110 */       double d2 = vec3.field_72449_c - this.field_70161_v;
/* 111 */       double d3 = vec3.field_72448_b - i;
/* 112 */       float f1 = (float)(Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
/* 113 */       float f2 = MathHelper.func_76142_g(f1 - this.field_70177_z);
/* 114 */       this.field_70701_bs = (float)func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e();
/* 115 */       if (f2 > 30.0F) {
/* 116 */         f2 = 30.0F;
/*     */       }
/* 118 */       if (f2 < -30.0F) {
/* 119 */         f2 = -30.0F;
/*     */       }
/* 121 */       this.field_70177_z += f2;
/*     */       
/* 123 */       if (this.field_70787_b && 
/* 124 */         this.field_70789_a != null) {
/* 125 */         double d4 = this.field_70789_a.field_70165_t - this.field_70165_t;
/* 126 */         double d5 = this.field_70789_a.field_70161_v - this.field_70161_v;
/*     */         
/* 128 */         float f3 = this.field_70177_z;
/* 129 */         this.field_70177_z = (float)(Math.atan2(d5, d4) * 180.0D / 3.1415927410125732D) - 90.0F;
/*     */         
/* 131 */         f2 = (f3 - this.field_70177_z + 90.0F) * 3.1415927F / 180.0F;
/* 132 */         this.field_70702_br = -MathHelper.func_76126_a(f2) * this.field_70701_bs * 1.0F;
/* 133 */         this.field_70701_bs = MathHelper.func_76134_b(f2) * this.field_70701_bs * 1.0F;
/*     */       } 
/*     */       
/* 136 */       if (d3 > 0.0D) {
/* 137 */         this.field_70703_bu = true;
/*     */       }
/*     */     } 
/*     */     
/* 141 */     if (this.field_70789_a != null) {
/* 142 */       func_70625_a(this.field_70789_a, 30.0F, 30.0F);
/*     */     }
/*     */     
/* 145 */     if (this.field_70123_F && !func_70781_l()) this.field_70703_bu = true; 
/* 146 */     if (this.field_70146_Z.nextFloat() < 0.8F && (bool1 || bool2)) this.field_70703_bu = true; 
/* 147 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */   }
/*     */   
/*     */   protected void func_70779_j() {
/* 151 */     this.field_70170_p.field_72984_F.func_76320_a("stroll");
/* 152 */     boolean bool = false;
/* 153 */     int i = -1;
/* 154 */     int j = -1;
/* 155 */     int k = -1;
/* 156 */     float f = -99999.0F;
/* 157 */     for (byte b = 0; b < 10; b++) {
/* 158 */       int m = MathHelper.func_76128_c(this.field_70165_t + this.field_70146_Z.nextInt(13) - 6.0D);
/* 159 */       int n = MathHelper.func_76128_c(this.field_70163_u + this.field_70146_Z.nextInt(7) - 3.0D);
/* 160 */       int i1 = MathHelper.func_76128_c(this.field_70161_v + this.field_70146_Z.nextInt(13) - 6.0D);
/* 161 */       float f1 = func_70783_a(m, n, i1);
/* 162 */       if (f1 > f) {
/* 163 */         f = f1;
/* 164 */         i = m;
/* 165 */         j = n;
/* 166 */         k = i1;
/* 167 */         bool = true;
/*     */       } 
/*     */     } 
/*     */     
/* 171 */     if (bool) {
/* 172 */       this.field_70786_d = this.field_70170_p.func_72844_a(this, i, j, k, 10.0F, true, false, false, true);
/*     */     }
/* 174 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {}
/*     */ 
/*     */   
/*     */   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
/* 182 */     return 0.0F;
/*     */   }
/*     */   
/*     */   protected Entity func_70782_k() {
/* 186 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 191 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 192 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 193 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/* 194 */     return (super.func_70601_bi() && func_70783_a(i, j, k) >= 0.0F);
/*     */   }
/*     */   
/*     */   public boolean func_70781_l() {
/* 198 */     return (this.field_70786_d != null);
/*     */   }
/*     */   
/*     */   public void func_70778_a(PathEntity p_70778_1_) {
/* 202 */     this.field_70786_d = p_70778_1_;
/*     */   }
/*     */   
/*     */   public Entity func_70777_m() {
/* 206 */     return this.field_70789_a;
/*     */   }
/*     */   
/*     */   public void func_70784_b(Entity p_70784_1_) {
/* 210 */     this.field_70789_a = p_70784_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_110173_bK() {
/* 215 */     return func_110176_b(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
/*     */   }
/*     */   
/*     */   public boolean func_110176_b(int p_110176_1_, int p_110176_2_, int p_110176_3_) {
/* 219 */     if (this.field_70772_bD == -1.0F) return true; 
/* 220 */     return (this.field_70775_bC.func_71569_e(p_110176_1_, p_110176_2_, p_110176_3_) < this.field_70772_bD * this.field_70772_bD);
/*     */   }
/*     */   
/*     */   public void func_110171_b(int p_110171_1_, int p_110171_2_, int p_110171_3_, int p_110171_4_) {
/* 224 */     this.field_70775_bC.func_71571_b(p_110171_1_, p_110171_2_, p_110171_3_);
/* 225 */     this.field_70772_bD = p_110171_4_;
/*     */   }
/*     */   
/*     */   public ChunkCoordinates func_110172_bL() {
/* 229 */     return this.field_70775_bC;
/*     */   }
/*     */   
/*     */   public float func_110174_bM() {
/* 233 */     return this.field_70772_bD;
/*     */   }
/*     */   
/*     */   public void func_110177_bN() {
/* 237 */     this.field_70772_bD = -1.0F;
/*     */   }
/*     */   
/*     */   public boolean func_110175_bO() {
/* 241 */     return (this.field_70772_bD != -1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110159_bB() {
/* 246 */     super.func_110159_bB();
/*     */     
/* 248 */     if (func_110167_bD() && func_110166_bE() != null && (func_110166_bE()).field_70170_p == this.field_70170_p) {
/*     */       
/* 250 */       Entity entity = func_110166_bE();
/* 251 */       func_110171_b((int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v, 5);
/*     */       
/* 253 */       float f = func_70032_d(entity);
/*     */       
/* 255 */       if (this instanceof EntityTameable && ((EntityTameable)this).func_70906_o()) {
/* 256 */         if (f > 10.0F) {
/* 257 */           func_110160_i(true, true);
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 262 */       if (!this.field_110180_bt) {
/* 263 */         this.field_70714_bg.func_75776_a(2, this.field_110178_bs);
/* 264 */         func_70661_as().func_75491_a(false);
/* 265 */         this.field_110180_bt = true;
/*     */       } 
/*     */       
/* 268 */       func_142017_o(f);
/*     */       
/* 270 */       if (f > 4.0F)
/*     */       {
/* 272 */         func_70661_as().func_75497_a(entity, 1.0D);
/*     */       }
/* 274 */       if (f > 6.0F) {
/*     */         
/* 276 */         double d1 = (entity.field_70165_t - this.field_70165_t) / f;
/* 277 */         double d2 = (entity.field_70163_u - this.field_70163_u) / f;
/* 278 */         double d3 = (entity.field_70161_v - this.field_70161_v) / f;
/*     */         
/* 280 */         this.field_70159_w += d1 * Math.abs(d1) * 0.4D;
/* 281 */         this.field_70181_x += d2 * Math.abs(d2) * 0.4D;
/* 282 */         this.field_70179_y += d3 * Math.abs(d3) * 0.4D;
/*     */       } 
/* 284 */       if (f > 10.0F) {
/* 285 */         func_110160_i(true, true);
/*     */       }
/*     */     }
/* 288 */     else if (!func_110167_bD() && this.field_110180_bt) {
/* 289 */       this.field_110180_bt = false;
/* 290 */       this.field_70714_bg.func_85156_a(this.field_110178_bs);
/* 291 */       func_70661_as().func_75491_a(true);
/* 292 */       func_110177_bN();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_142017_o(float p_142017_1_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityCreature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */