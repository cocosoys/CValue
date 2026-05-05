/*     */ package net.minecraft.entity.monster;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.projectile.EntitySmallFireball;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityBlaze extends EntityMob {
/*  14 */   private float field_70847_d = 0.5F;
/*     */   
/*     */   private int field_70848_e;
/*     */   private int field_70846_g;
/*     */   private static final String __OBFID = "CL_00001682";
/*     */   
/*     */   public EntityBlaze(World p_i1731_1_) {
/*  21 */     super(p_i1731_1_);
/*     */     
/*  23 */     this.field_70178_ae = true;
/*  24 */     this.field_70728_aV = 10;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  29 */     super.func_110147_ax();
/*  30 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  35 */     super.func_70088_a();
/*     */     
/*  37 */     this.field_70180_af.func_75682_a(16, new Byte((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  42 */     return "mob.blaze.breathe";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  47 */     return "mob.blaze.hit";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  52 */     return "mob.blaze.death";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/*  57 */     return 15728880;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70013_c(float p_70013_1_) {
/*  62 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  67 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/*  69 */       if (func_70026_G()) {
/*  70 */         func_70097_a(DamageSource.field_76369_e, 1.0F);
/*     */       }
/*     */       
/*  73 */       this.field_70848_e--;
/*  74 */       if (this.field_70848_e <= 0) {
/*  75 */         this.field_70848_e = 100;
/*  76 */         this.field_70847_d = 0.5F + (float)this.field_70146_Z.nextGaussian() * 3.0F;
/*     */       } 
/*     */       
/*  79 */       if (func_70777_m() != null && (func_70777_m()).field_70163_u + func_70777_m().func_70047_e() > this.field_70163_u + func_70047_e() + this.field_70847_d) {
/*  80 */         this.field_70181_x += (0.30000001192092896D - this.field_70181_x) * 0.30000001192092896D;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  85 */     if (this.field_70146_Z.nextInt(24) == 0) {
/*  86 */       this.field_70170_p.func_72908_a(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D, "fire.fire", 1.0F + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7F + 0.3F);
/*     */     }
/*     */ 
/*     */     
/*  90 */     if (!this.field_70122_E && this.field_70181_x < 0.0D) {
/*  91 */       this.field_70181_x *= 0.6D;
/*     */     }
/*     */     
/*  94 */     for (byte b = 0; b < 2; b++) {
/*  95 */       this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N, 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */     
/*  98 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
/* 103 */     if (this.field_70724_aR <= 0 && p_70785_2_ < 2.0F && p_70785_1_.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
/* 104 */       this.field_70724_aR = 20;
/* 105 */       func_70652_k(p_70785_1_);
/* 106 */     } else if (p_70785_2_ < 30.0F) {
/* 107 */       double d1 = p_70785_1_.field_70165_t - this.field_70165_t;
/* 108 */       double d2 = p_70785_1_.field_70121_D.field_72338_b + (p_70785_1_.field_70131_O / 2.0F) - this.field_70163_u + (this.field_70131_O / 2.0F);
/* 109 */       double d3 = p_70785_1_.field_70161_v - this.field_70161_v;
/*     */       
/* 111 */       if (this.field_70724_aR == 0) {
/* 112 */         this.field_70846_g++;
/* 113 */         if (this.field_70846_g == 1) {
/* 114 */           this.field_70724_aR = 60;
/* 115 */           func_70844_e(true);
/* 116 */         } else if (this.field_70846_g <= 4) {
/* 117 */           this.field_70724_aR = 6;
/*     */         } else {
/* 119 */           this.field_70724_aR = 100;
/* 120 */           this.field_70846_g = 0;
/* 121 */           func_70844_e(false);
/*     */         } 
/*     */         
/* 124 */         if (this.field_70846_g > 1) {
/* 125 */           float f = MathHelper.func_76129_c(p_70785_2_) * 0.5F;
/*     */           
/* 127 */           this.field_70170_p.func_72889_a(null, 1009, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/* 128 */           for (byte b = 0; b < 1; b++) {
/* 129 */             EntitySmallFireball entitySmallFireball = new EntitySmallFireball(this.field_70170_p, (EntityLivingBase)this, d1 + this.field_70146_Z.nextGaussian() * f, d2, d3 + this.field_70146_Z.nextGaussian() * f);
/* 130 */             entitySmallFireball.field_70163_u = this.field_70163_u + (this.field_70131_O / 2.0F) + 0.5D;
/* 131 */             this.field_70170_p.func_72838_d((Entity)entitySmallFireball);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 136 */       this.field_70177_z = (float)(Math.atan2(d3, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
/*     */       
/* 138 */       this.field_70787_b = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {}
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 148 */     return Items.field_151072_bj;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70027_ad() {
/* 153 */     return func_70845_n();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 158 */     if (p_70628_1_) {
/* 159 */       int i = this.field_70146_Z.nextInt(2 + p_70628_2_);
/* 160 */       for (byte b = 0; b < i; b++) {
/* 161 */         func_145779_a(Items.field_151072_bj, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_70845_n() {
/* 167 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */   
/*     */   public void func_70844_e(boolean p_70844_1_) {
/* 171 */     byte b = this.field_70180_af.func_75683_a(16);
/* 172 */     if (p_70844_1_) {
/* 173 */       b = (byte)(b | 0x1);
/*     */     } else {
/* 175 */       b = (byte)(b & 0xFFFFFFFE);
/*     */     } 
/* 177 */     this.field_70180_af.func_75692_b(16, Byte.valueOf(b));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70814_o() {
/* 182 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityBlaze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */