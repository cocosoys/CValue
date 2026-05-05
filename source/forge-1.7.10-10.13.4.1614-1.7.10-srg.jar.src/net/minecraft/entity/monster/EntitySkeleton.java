/*     */ package net.minecraft.entity.monster;
/*     */ import java.util.Calendar;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIArrowAttack;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIFleeSun;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySkeleton extends EntityMob implements IRangedAttackMob {
/*  30 */   private EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
/*  31 */   private EntityAIAttackOnCollide field_85038_e = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false); private static final String __OBFID = "CL_00001697";
/*     */   
/*     */   public EntitySkeleton(World p_i1741_1_) {
/*  34 */     super(p_i1741_1_);
/*     */     
/*  36 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  37 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIRestrictSun(this));
/*  38 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIFleeSun(this, 1.0D));
/*     */     
/*  40 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander(this, 1.0D));
/*  41 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  42 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  44 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget(this, false));
/*  45 */     this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
/*     */     
/*  47 */     if (p_i1741_1_ != null && !p_i1741_1_.field_72995_K) func_85036_m();
/*     */   
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  52 */     super.func_110147_ax();
/*     */     
/*  54 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  59 */     super.func_70088_a();
/*     */     
/*  61 */     this.field_70180_af.func_75682_a(13, new Byte((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  66 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  71 */     return "mob.skeleton.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  76 */     return "mob.skeleton.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  81 */     return "mob.skeleton.death";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/*  86 */     func_85030_a("mob.skeleton.step", 0.15F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity p_70652_1_) {
/*  91 */     if (super.func_70652_k(p_70652_1_)) {
/*  92 */       if (func_82202_m() == 1 && p_70652_1_ instanceof EntityLivingBase) {
/*  93 */         ((EntityLivingBase)p_70652_1_).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 200));
/*     */       }
/*  95 */       return true;
/*     */     } 
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumCreatureAttribute func_70668_bt() {
/* 102 */     return EnumCreatureAttribute.UNDEAD;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 107 */     if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
/* 108 */       float f = func_70013_c(1.0F);
/* 109 */       if (f > 0.5F && this.field_70146_Z.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))) {
/* 110 */         boolean bool = true;
/*     */         
/* 112 */         ItemStack itemStack = func_71124_b(4);
/* 113 */         if (itemStack != null) {
/* 114 */           if (itemStack.func_77984_f()) {
/* 115 */             itemStack.func_77964_b(itemStack.func_77952_i() + this.field_70146_Z.nextInt(2));
/* 116 */             if (itemStack.func_77952_i() >= itemStack.func_77958_k()) {
/* 117 */               func_70669_a(itemStack);
/* 118 */               func_70062_b(4, (ItemStack)null);
/*     */             } 
/*     */           } 
/*     */           
/* 122 */           bool = false;
/*     */         } 
/*     */         
/* 125 */         if (bool) {
/* 126 */           func_70015_d(8);
/*     */         }
/*     */       } 
/*     */     } 
/* 130 */     if (this.field_70170_p.field_72995_K && 
/* 131 */       func_82202_m() == 1) {
/* 132 */       func_70105_a(0.72F, 2.34F);
/*     */     }
/*     */ 
/*     */     
/* 136 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70098_U() {
/* 141 */     super.func_70098_U();
/*     */     
/* 143 */     if (this.field_70154_o instanceof EntityCreature) {
/* 144 */       EntityCreature entityCreature = (EntityCreature)this.field_70154_o;
/* 145 */       this.field_70761_aq = entityCreature.field_70761_aq;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource p_70645_1_) {
/* 152 */     super.func_70645_a(p_70645_1_);
/* 153 */     if (p_70645_1_.func_76364_f() instanceof EntityArrow && p_70645_1_.func_76346_g() instanceof EntityPlayer) {
/* 154 */       EntityPlayer entityPlayer = (EntityPlayer)p_70645_1_.func_76346_g();
/* 155 */       double d1 = entityPlayer.field_70165_t - this.field_70165_t;
/* 156 */       double d2 = entityPlayer.field_70161_v - this.field_70161_v;
/* 157 */       if (d1 * d1 + d2 * d2 >= 2500.0D) {
/* 158 */         entityPlayer.func_71029_a((StatBase)AchievementList.field_76020_v);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 165 */     return Items.field_151032_g;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 170 */     if (func_82202_m() == 1) {
/*     */       
/* 172 */       int j = this.field_70146_Z.nextInt(3 + p_70628_2_) - 1;
/* 173 */       for (byte b1 = 0; b1 < j; b1++) {
/* 174 */         func_145779_a(Items.field_151044_h, 1);
/*     */       }
/*     */     } else {
/*     */       
/* 178 */       int j = this.field_70146_Z.nextInt(3 + p_70628_2_);
/* 179 */       for (byte b1 = 0; b1 < j; b1++) {
/* 180 */         func_145779_a(Items.field_151032_g, 1);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 185 */     int i = this.field_70146_Z.nextInt(3 + p_70628_2_);
/* 186 */     for (byte b = 0; b < i; b++) {
/* 187 */       func_145779_a(Items.field_151103_aS, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70600_l(int p_70600_1_) {
/* 193 */     if (func_82202_m() == 1) {
/* 194 */       func_70099_a(new ItemStack(Items.field_151144_bL, 1, 1), 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_82164_bB() {
/* 200 */     super.func_82164_bB();
/*     */     
/* 202 */     func_70062_b(0, new ItemStack((Item)Items.field_151031_f));
/*     */   }
/*     */ 
/*     */   
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 207 */     p_110161_1_ = super.func_110161_a(p_110161_1_);
/*     */     
/* 209 */     if (this.field_70170_p.field_73011_w instanceof net.minecraft.world.WorldProviderHell && func_70681_au().nextInt(5) > 0) {
/* 210 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.field_85038_e);
/*     */       
/* 212 */       func_82201_a(1);
/* 213 */       func_70062_b(0, new ItemStack(Items.field_151052_q));
/* 214 */       func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0D);
/*     */     } else {
/* 216 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.field_85037_d);
/*     */       
/* 218 */       func_82164_bB();
/* 219 */       func_82162_bC();
/*     */     } 
/*     */     
/* 222 */     func_98053_h((this.field_70146_Z.nextFloat() < 0.55F * this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v)));
/*     */     
/* 224 */     if (func_71124_b(4) == null) {
/* 225 */       Calendar calendar = this.field_70170_p.func_83015_S();
/*     */       
/* 227 */       if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F) {
/*     */         
/* 229 */         func_70062_b(4, new ItemStack((this.field_70146_Z.nextFloat() < 0.1F) ? Blocks.field_150428_aP : Blocks.field_150423_aK));
/* 230 */         this.field_82174_bp[4] = 0.0F;
/*     */       } 
/*     */     } 
/* 233 */     return p_110161_1_;
/*     */   }
/*     */   
/*     */   public void func_85036_m() {
/* 237 */     this.field_70714_bg.func_85156_a((EntityAIBase)this.field_85038_e);
/* 238 */     this.field_70714_bg.func_85156_a((EntityAIBase)this.field_85037_d);
/*     */     
/* 240 */     ItemStack itemStack = func_70694_bm();
/*     */     
/* 242 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151031_f) {
/* 243 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.field_85037_d);
/*     */     } else {
/* 245 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.field_85038_e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
/* 251 */     EntityArrow entityArrow = new EntityArrow(this.field_70170_p, (EntityLivingBase)this, p_82196_1_, 1.6F, (14 - this.field_70170_p.field_73013_u.func_151525_a() * 4));
/* 252 */     int i = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, func_70694_bm());
/* 253 */     int j = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, func_70694_bm());
/*     */     
/* 255 */     entityArrow.func_70239_b((p_82196_2_ * 2.0F) + this.field_70146_Z.nextGaussian() * 0.25D + (this.field_70170_p.field_73013_u.func_151525_a() * 0.11F));
/*     */     
/* 257 */     if (i > 0) {
/* 258 */       entityArrow.func_70239_b(entityArrow.func_70242_d() + i * 0.5D + 0.5D);
/*     */     }
/* 260 */     if (j > 0) {
/* 261 */       entityArrow.func_70240_a(j);
/*     */     }
/* 263 */     if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, func_70694_bm()) > 0 || func_82202_m() == 1) {
/* 264 */       entityArrow.func_70015_d(100);
/*     */     }
/*     */     
/* 267 */     func_85030_a("random.bow", 1.0F, 1.0F / (func_70681_au().nextFloat() * 0.4F + 0.8F));
/* 268 */     this.field_70170_p.func_72838_d((Entity)entityArrow);
/*     */   }
/*     */   
/*     */   public int func_82202_m() {
/* 272 */     return this.field_70180_af.func_75683_a(13);
/*     */   }
/*     */   
/*     */   public void func_82201_a(int p_82201_1_) {
/* 276 */     this.field_70180_af.func_75692_b(13, Byte.valueOf((byte)p_82201_1_));
/*     */     
/* 278 */     this.field_70178_ae = (p_82201_1_ == 1);
/* 279 */     if (p_82201_1_ == 1) {
/* 280 */       func_70105_a(0.72F, 2.34F);
/*     */     } else {
/* 282 */       func_70105_a(0.6F, 1.8F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 288 */     super.func_70037_a(p_70037_1_);
/*     */     
/* 290 */     if (p_70037_1_.func_150297_b("SkeletonType", 99)) {
/* 291 */       byte b = p_70037_1_.func_74771_c("SkeletonType");
/* 292 */       func_82201_a(b);
/*     */     } 
/*     */     
/* 295 */     func_85036_m();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 300 */     super.func_70014_b(p_70014_1_);
/* 301 */     p_70014_1_.func_74774_a("SkeletonType", (byte)func_82202_m());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
/* 306 */     super.func_70062_b(p_70062_1_, p_70062_2_);
/*     */     
/* 308 */     if (!this.field_70170_p.field_72995_K && p_70062_1_ == 0) {
/* 309 */       func_85036_m();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_70033_W() {
/* 315 */     return super.func_70033_W() - 0.5D;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntitySkeleton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */