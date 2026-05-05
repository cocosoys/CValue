/*     */ package net.minecraft.entity.monster;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ public class EntitySlime
/*     */   extends EntityLiving implements IMob {
/*     */   public float field_70813_a;
/*     */   public float field_70811_b;
/*     */   
/*     */   public EntitySlime(World p_i1742_1_) {
/*  25 */     super(p_i1742_1_);
/*  26 */     int i = 1 << this.field_70146_Z.nextInt(3);
/*  27 */     this.field_70129_M = 0.0F;
/*  28 */     this.field_70810_d = this.field_70146_Z.nextInt(20) + 10;
/*  29 */     func_70799_a(i);
/*     */   }
/*     */   public float field_70812_c; private int field_70810_d;
/*     */   private static final String __OBFID = "CL_00001698";
/*     */   
/*     */   protected void func_70088_a() {
/*  35 */     super.func_70088_a();
/*     */     
/*  37 */     this.field_70180_af.func_75682_a(16, new Byte((byte)1));
/*     */   }
/*     */   
/*     */   protected void func_70799_a(int p_70799_1_) {
/*  41 */     this.field_70180_af.func_75692_b(16, new Byte((byte)p_70799_1_));
/*  42 */     func_70105_a(0.6F * p_70799_1_, 0.6F * p_70799_1_);
/*  43 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  44 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((p_70799_1_ * p_70799_1_));
/*  45 */     func_70606_j(func_110138_aP());
/*  46 */     this.field_70728_aV = p_70799_1_;
/*     */   }
/*     */   
/*     */   public int func_70809_q() {
/*  50 */     return this.field_70180_af.func_75683_a(16);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  55 */     super.func_70014_b(p_70014_1_);
/*  56 */     p_70014_1_.func_74768_a("Size", func_70809_q() - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  61 */     super.func_70037_a(p_70037_1_);
/*  62 */     int i = p_70037_1_.func_74762_e("Size");
/*  63 */     if (i < 0) {
/*  64 */       i = 0;
/*     */     }
/*  66 */     func_70799_a(i + 1);
/*     */   }
/*     */   
/*     */   protected String func_70801_i() {
/*  70 */     return "slime";
/*     */   }
/*     */   
/*     */   protected String func_70803_o() {
/*  74 */     return "mob.slime." + ((func_70809_q() > 1) ? "big" : "small");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  79 */     if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL && func_70809_q() > 0) {
/*  80 */       this.field_70128_L = true;
/*     */     }
/*     */     
/*  83 */     this.field_70811_b += (this.field_70813_a - this.field_70811_b) * 0.5F;
/*  84 */     this.field_70812_c = this.field_70811_b;
/*  85 */     boolean bool = this.field_70122_E;
/*  86 */     super.func_70071_h_();
/*     */     
/*  88 */     if (this.field_70122_E && !bool) {
/*  89 */       int i = func_70809_q();
/*  90 */       for (byte b = 0; b < i * 8; b++) {
/*  91 */         float f1 = this.field_70146_Z.nextFloat() * 3.1415927F * 2.0F;
/*  92 */         float f2 = this.field_70146_Z.nextFloat() * 0.5F + 0.5F;
/*  93 */         float f3 = MathHelper.func_76126_a(f1) * i * 0.5F * f2;
/*  94 */         float f4 = MathHelper.func_76134_b(f1) * i * 0.5F * f2;
/*  95 */         this.field_70170_p.func_72869_a(func_70801_i(), this.field_70165_t + f3, this.field_70121_D.field_72338_b, this.field_70161_v + f4, 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */       
/*  98 */       if (func_70804_p()) {
/*  99 */         func_85030_a(func_70803_o(), func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) / 0.8F);
/*     */       }
/* 101 */       this.field_70813_a = -0.5F;
/* 102 */     } else if (!this.field_70122_E && bool) {
/* 103 */       this.field_70813_a = 1.0F;
/*     */     } 
/* 105 */     func_70808_l();
/*     */     
/* 107 */     if (this.field_70170_p.field_72995_K) {
/* 108 */       int i = func_70809_q();
/* 109 */       func_70105_a(0.6F * i, 0.6F * i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/* 115 */     func_70623_bb();
/* 116 */     EntityPlayer entityPlayer = this.field_70170_p.func_72856_b((Entity)this, 16.0D);
/* 117 */     if (entityPlayer != null) {
/* 118 */       func_70625_a((Entity)entityPlayer, 10.0F, 20.0F);
/*     */     }
/* 120 */     if (this.field_70122_E && this.field_70810_d-- <= 0) {
/* 121 */       this.field_70810_d = func_70806_k();
/* 122 */       if (entityPlayer != null) {
/* 123 */         this.field_70810_d /= 3;
/*     */       }
/* 125 */       this.field_70703_bu = true;
/* 126 */       if (func_70807_r()) {
/* 127 */         func_85030_a(func_70803_o(), func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) * 0.8F);
/*     */       }
/*     */       
/* 130 */       this.field_70702_br = 1.0F - this.field_70146_Z.nextFloat() * 2.0F;
/* 131 */       this.field_70701_bs = (1 * func_70809_q());
/*     */     } else {
/* 133 */       this.field_70703_bu = false;
/* 134 */       if (this.field_70122_E) {
/* 135 */         this.field_70702_br = this.field_70701_bs = 0.0F;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_70808_l() {
/* 141 */     this.field_70813_a *= 0.6F;
/*     */   }
/*     */   
/*     */   protected int func_70806_k() {
/* 145 */     return this.field_70146_Z.nextInt(20) + 10;
/*     */   }
/*     */   
/*     */   protected EntitySlime func_70802_j() {
/* 149 */     return new EntitySlime(this.field_70170_p);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 154 */     int i = func_70809_q();
/* 155 */     if (!this.field_70170_p.field_72995_K && i > 1 && func_110143_aJ() <= 0.0F) {
/* 156 */       int j = 2 + this.field_70146_Z.nextInt(3);
/* 157 */       for (byte b = 0; b < j; b++) {
/* 158 */         float f1 = ((b % 2) - 0.5F) * i / 4.0F;
/* 159 */         float f2 = ((b / 2) - 0.5F) * i / 4.0F;
/* 160 */         EntitySlime entitySlime = func_70802_j();
/* 161 */         entitySlime.func_70799_a(i / 2);
/* 162 */         entitySlime.func_70012_b(this.field_70165_t + f1, this.field_70163_u + 0.5D, this.field_70161_v + f2, this.field_70146_Z.nextFloat() * 360.0F, 0.0F);
/* 163 */         this.field_70170_p.func_72838_d((Entity)entitySlime);
/*     */       } 
/*     */     } 
/* 166 */     super.func_70106_y();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer p_70100_1_) {
/* 171 */     if (func_70800_m()) {
/* 172 */       int i = func_70809_q();
/* 173 */       if (func_70685_l((Entity)p_70100_1_) && func_70068_e((Entity)p_70100_1_) < 0.6D * i * 0.6D * i && 
/* 174 */         p_70100_1_.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), func_70805_n())) {
/* 175 */         func_85030_a("mob.attack", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70800_m() {
/* 182 */     return (func_70809_q() > 1);
/*     */   }
/*     */   
/*     */   protected int func_70805_n() {
/* 186 */     return func_70809_q();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 191 */     return "mob.slime." + ((func_70809_q() > 1) ? "big" : "small");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 196 */     return "mob.slime." + ((func_70809_q() > 1) ? "big" : "small");
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 201 */     if (func_70809_q() == 1) return Items.field_151123_aH; 
/* 202 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 207 */     Chunk chunk = this.field_70170_p.func_72938_d(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v));
/* 208 */     if (this.field_70170_p.func_72912_H().func_76067_t() == WorldType.field_77138_c && this.field_70146_Z.nextInt(4) != 1) {
/* 209 */       return false;
/*     */     }
/* 211 */     if (func_70809_q() == 1 || this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
/*     */       
/* 213 */       BiomeGenBase biomeGenBase = this.field_70170_p.func_72807_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v));
/*     */       
/* 215 */       if (biomeGenBase == BiomeGenBase.field_76780_h && this.field_70163_u > 50.0D && this.field_70163_u < 70.0D && this.field_70146_Z.nextFloat() < 0.5F && 
/* 216 */         this.field_70146_Z.nextFloat() < this.field_70170_p.func_130001_d() && this.field_70170_p.func_72957_l(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) <= this.field_70146_Z.nextInt(8)) {
/* 217 */         return super.func_70601_bi();
/*     */       }
/*     */       
/* 220 */       if (this.field_70146_Z.nextInt(10) == 0 && chunk.func_76617_a(987234911L).nextInt(10) == 0 && this.field_70163_u < 40.0D) {
/* 221 */         return super.func_70601_bi();
/*     */       }
/*     */     } 
/* 224 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 229 */     return 0.4F * func_70809_q();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70646_bf() {
/* 234 */     return 0;
/*     */   }
/*     */   
/*     */   protected boolean func_70807_r() {
/* 238 */     return (func_70809_q() > 0);
/*     */   }
/*     */   
/*     */   protected boolean func_70804_p() {
/* 242 */     return (func_70809_q() > 2);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntitySlime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */