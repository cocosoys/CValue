/*     */ package net.minecraft.entity.monster;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityFlying;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityLargeFireball;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityGhast extends EntityFlying implements IMob {
/*     */   public int field_70797_a;
/*     */   public double field_70795_b;
/*     */   public double field_70796_c;
/*     */   public double field_70793_d;
/*  28 */   private int field_92014_j = 1; private Entity field_70792_g; private int field_70798_h; public int field_70794_e; public int field_70791_f; private static final String __OBFID = "CL_00001689";
/*     */   
/*     */   public EntityGhast(World p_i1735_1_) {
/*  31 */     super(p_i1735_1_);
/*  32 */     func_70105_a(4.0F, 4.0F);
/*  33 */     this.field_70178_ae = true;
/*  34 */     this.field_70728_aV = 5;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_110182_bF() {
/*  38 */     return (this.field_70180_af.func_75683_a(16) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  43 */     if (func_85032_ar()) return false; 
/*  44 */     if ("fireball".equals(p_70097_1_.func_76355_l()) && 
/*  45 */       p_70097_1_.func_76346_g() instanceof EntityPlayer) {
/*     */       
/*  47 */       super.func_70097_a(p_70097_1_, 1000.0F);
/*  48 */       ((EntityPlayer)p_70097_1_.func_76346_g()).func_71029_a((StatBase)AchievementList.field_76028_y);
/*  49 */       return true;
/*     */     } 
/*     */ 
/*     */     
/*  53 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  58 */     super.func_70088_a();
/*     */     
/*  60 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  65 */     super.func_110147_ax();
/*     */     
/*  67 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/*  72 */     if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) func_70106_y(); 
/*  73 */     func_70623_bb();
/*     */     
/*  75 */     this.field_70794_e = this.field_70791_f;
/*  76 */     double d1 = this.field_70795_b - this.field_70165_t;
/*  77 */     double d2 = this.field_70796_c - this.field_70163_u;
/*  78 */     double d3 = this.field_70793_d - this.field_70161_v;
/*     */     
/*  80 */     double d4 = d1 * d1 + d2 * d2 + d3 * d3;
/*     */     
/*  82 */     if (d4 < 1.0D || d4 > 3600.0D) {
/*  83 */       this.field_70795_b = this.field_70165_t + ((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  84 */       this.field_70796_c = this.field_70163_u + ((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*  85 */       this.field_70793_d = this.field_70161_v + ((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
/*     */     } 
/*     */     
/*  88 */     if (this.field_70797_a-- <= 0) {
/*  89 */       this.field_70797_a += this.field_70146_Z.nextInt(5) + 2;
/*     */       
/*  91 */       d4 = MathHelper.func_76133_a(d4);
/*     */       
/*  93 */       if (func_70790_a(this.field_70795_b, this.field_70796_c, this.field_70793_d, d4)) {
/*  94 */         this.field_70159_w += d1 / d4 * 0.1D;
/*  95 */         this.field_70181_x += d2 / d4 * 0.1D;
/*  96 */         this.field_70179_y += d3 / d4 * 0.1D;
/*     */       } else {
/*  98 */         this.field_70795_b = this.field_70165_t;
/*  99 */         this.field_70796_c = this.field_70163_u;
/* 100 */         this.field_70793_d = this.field_70161_v;
/*     */       } 
/*     */     } 
/*     */     
/* 104 */     if (this.field_70792_g != null && this.field_70792_g.field_70128_L) this.field_70792_g = null; 
/* 105 */     if (this.field_70792_g == null || this.field_70798_h-- <= 0) {
/* 106 */       this.field_70792_g = (Entity)this.field_70170_p.func_72856_b((Entity)this, 100.0D);
/* 107 */       if (this.field_70792_g != null) {
/* 108 */         this.field_70798_h = 20;
/*     */       }
/*     */     } 
/*     */     
/* 112 */     double d5 = 64.0D;
/* 113 */     if (this.field_70792_g != null && this.field_70792_g.func_70068_e((Entity)this) < d5 * d5) {
/* 114 */       double d6 = this.field_70792_g.field_70165_t - this.field_70165_t;
/* 115 */       double d7 = this.field_70792_g.field_70121_D.field_72338_b + (this.field_70792_g.field_70131_O / 2.0F) - this.field_70163_u + (this.field_70131_O / 2.0F);
/* 116 */       double d8 = this.field_70792_g.field_70161_v - this.field_70161_v;
/* 117 */       this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(d6, d8)) * 180.0F / 3.1415927F;
/*     */       
/* 119 */       if (func_70685_l(this.field_70792_g))
/* 120 */       { if (this.field_70791_f == 10) {
/* 121 */           this.field_70170_p.func_72889_a(null, 1007, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/*     */         }
/* 123 */         this.field_70791_f++;
/* 124 */         if (this.field_70791_f == 20) {
/* 125 */           this.field_70170_p.func_72889_a(null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/* 126 */           EntityLargeFireball entityLargeFireball = new EntityLargeFireball(this.field_70170_p, (EntityLivingBase)this, d6, d7, d8);
/* 127 */           entityLargeFireball.field_92057_e = this.field_92014_j;
/* 128 */           double d = 4.0D;
/* 129 */           Vec3 vec3 = func_70676_i(1.0F);
/* 130 */           entityLargeFireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d;
/* 131 */           entityLargeFireball.field_70163_u = this.field_70163_u + (this.field_70131_O / 2.0F) + 0.5D;
/* 132 */           entityLargeFireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d;
/* 133 */           this.field_70170_p.func_72838_d((Entity)entityLargeFireball);
/* 134 */           this.field_70791_f = -40;
/*     */         }
/*     */          }
/* 137 */       else if (this.field_70791_f > 0) { this.field_70791_f--; }
/*     */     
/*     */     } else {
/* 140 */       this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(this.field_70159_w, this.field_70179_y)) * 180.0F / 3.1415927F;
/* 141 */       if (this.field_70791_f > 0) this.field_70791_f--;
/*     */     
/*     */     } 
/* 144 */     if (!this.field_70170_p.field_72995_K) {
/* 145 */       byte b1 = this.field_70180_af.func_75683_a(16);
/* 146 */       byte b2 = (byte)((this.field_70791_f > 10) ? 1 : 0);
/* 147 */       if (b1 != b2) {
/* 148 */         this.field_70180_af.func_75692_b(16, Byte.valueOf(b2));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_70790_a(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_) {
/* 154 */     double d1 = (this.field_70795_b - this.field_70165_t) / p_70790_7_;
/* 155 */     double d2 = (this.field_70796_c - this.field_70163_u) / p_70790_7_;
/* 156 */     double d3 = (this.field_70793_d - this.field_70161_v) / p_70790_7_;
/*     */     
/* 158 */     AxisAlignedBB axisAlignedBB = this.field_70121_D.func_72329_c();
/* 159 */     for (byte b = 1; b < p_70790_7_; b++) {
/* 160 */       axisAlignedBB.func_72317_d(d1, d2, d3);
/* 161 */       if (!this.field_70170_p.func_72945_a((Entity)this, axisAlignedBB).isEmpty()) return false;
/*     */     
/*     */     } 
/* 164 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 169 */     return "mob.ghast.moan";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 174 */     return "mob.ghast.scream";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 179 */     return "mob.ghast.death";
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 184 */     return Items.field_151016_H;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 189 */     int i = this.field_70146_Z.nextInt(2) + this.field_70146_Z.nextInt(1 + p_70628_2_); byte b;
/* 190 */     for (b = 0; b < i; b++) {
/* 191 */       func_145779_a(Items.field_151073_bk, 1);
/*     */     }
/* 193 */     i = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + p_70628_2_);
/* 194 */     for (b = 0; b < i; b++) {
/* 195 */       func_145779_a(Items.field_151016_H, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 201 */     return 10.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 206 */     return (this.field_70146_Z.nextInt(20) == 0 && super.func_70601_bi() && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70641_bl() {
/* 211 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 216 */     super.func_70014_b(p_70014_1_);
/* 217 */     p_70014_1_.func_74768_a("ExplosionPower", this.field_92014_j);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 222 */     super.func_70037_a(p_70037_1_);
/* 223 */     if (p_70037_1_.func_150297_b("ExplosionPower", 99)) this.field_92014_j = p_70037_1_.func_74762_e("ExplosionPower"); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityGhast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */