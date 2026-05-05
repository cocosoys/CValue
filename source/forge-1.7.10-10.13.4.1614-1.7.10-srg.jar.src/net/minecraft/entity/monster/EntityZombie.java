/*     */ package net.minecraft.entity.monster;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIBreakDoor;
/*     */ import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttribute;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.passive.EntityChicken;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityZombie extends EntityMob {
/*  38 */   protected static final IAttribute field_110186_bp = (IAttribute)(new RangedAttribute("zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).func_111117_a("Spawn Reinforcements Chance");
/*  39 */   private static final UUID field_110187_bq = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
/*  40 */   private static final AttributeModifier field_110188_br = new AttributeModifier(field_110187_bq, "Baby speed boost", 0.5D, 1);
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
/*  53 */   private final EntityAIBreakDoor field_146075_bs = new EntityAIBreakDoor((EntityLiving)this);
/*     */   private int field_82234_d;
/*     */   private boolean field_146076_bu = false;
/*     */   private float field_146074_bv;
/*     */   private float field_146073_bw;
/*  58 */   private static final String __OBFID = "CL_00001702"; protected void func_110147_ax() { super.func_110147_ax(); func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D); func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D); func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D); func_110140_aT().func_111150_b(field_110186_bp).func_111128_a(this.field_70146_Z.nextDouble() * 0.10000000149011612D); } protected void func_70088_a() { super.func_70088_a(); func_70096_w().func_75682_a(12, Byte.valueOf((byte)0)); func_70096_w().func_75682_a(13, Byte.valueOf((byte)0)); func_70096_w().func_75682_a(14, Byte.valueOf((byte)0)); } public int func_70658_aO() { int i = super.func_70658_aO() + 2; if (i > 20) i = 20;  return i; } protected boolean func_70650_aV() { return true; } public boolean func_146072_bX() { return this.field_146076_bu; } public void func_146070_a(boolean p_146070_1_) { if (this.field_146076_bu != p_146070_1_) { this.field_146076_bu = p_146070_1_; if (p_146070_1_) { this.field_70714_bg.func_75776_a(1, (EntityAIBase)this.field_146075_bs); } else { this.field_70714_bg.func_85156_a((EntityAIBase)this.field_146075_bs); }  }  } public boolean func_70631_g_() { return (func_70096_w().func_75683_a(12) == 1); } protected int func_70693_a(EntityPlayer p_70693_1_) { if (func_70631_g_()) this.field_70728_aV = (int)(this.field_70728_aV * 2.5F);  return super.func_70693_a(p_70693_1_); } public void func_82227_f(boolean p_82227_1_) { func_70096_w().func_75692_b(12, Byte.valueOf((byte)(p_82227_1_ ? 1 : 0))); if (this.field_70170_p != null && !this.field_70170_p.field_72995_K) { IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d); iAttributeInstance.func_111124_b(field_110188_br); if (p_82227_1_) iAttributeInstance.func_111121_a(field_110188_br);  }  func_146071_k(p_82227_1_); } public EntityZombie(World p_i1745_1_) { super(p_i1745_1_);
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
/* 529 */     this.field_146074_bv = -1.0F; func_70661_as().func_75498_b(true); this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this)); this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false)); this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true)); this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIMoveTowardsRestriction(this, 1.0D)); this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMoveThroughVillage(this, 1.0D, false)); this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWander(this, 1.0D)); this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F)); this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget(this, true)); this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true)); this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false)); func_70105_a(0.6F, 1.8F); }
/*     */   public boolean func_82231_m() { return (func_70096_w().func_75683_a(13) == 1); }
/*     */   public void func_82229_g(boolean p_82229_1_) { func_70096_w().func_75692_b(13, Byte.valueOf((byte)(p_82229_1_ ? 1 : 0))); }
/*     */   public void func_70636_d() { if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && !func_70631_g_()) { float f = func_70013_c(1.0F); if (f > 0.5F && this.field_70146_Z.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))) { boolean bool = true; ItemStack itemStack = func_71124_b(4); if (itemStack != null) { if (itemStack.func_77984_f()) { itemStack.func_77964_b(itemStack.func_77952_i() + this.field_70146_Z.nextInt(2)); if (itemStack.func_77952_i() >= itemStack.func_77958_k()) { func_70669_a(itemStack); func_70062_b(4, null); }  }  bool = false; }  if (bool) func_70015_d(8);  }  }  if (func_70115_ae() && func_70638_az() != null && this.field_70154_o instanceof EntityChicken) ((EntityLiving)this.field_70154_o).func_70661_as().func_75484_a(func_70661_as().func_75505_d(), 1.5D);  super.func_70636_d(); }
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) { if (super.func_70097_a(p_70097_1_, p_70097_2_)) { EntityLivingBase entityLivingBase = func_70638_az(); if (entityLivingBase == null && func_70777_m() instanceof EntityLivingBase) entityLivingBase = (EntityLivingBase)func_70777_m();  if (entityLivingBase == null && p_70097_1_.func_76346_g() instanceof EntityLivingBase) entityLivingBase = (EntityLivingBase)p_70097_1_.func_76346_g();  if (entityLivingBase != null && this.field_70170_p.field_73013_u == EnumDifficulty.HARD && this.field_70146_Z.nextFloat() < func_110148_a(field_110186_bp).func_111126_e()) { int i = MathHelper.func_76128_c(this.field_70165_t); int j = MathHelper.func_76128_c(this.field_70163_u); int k = MathHelper.func_76128_c(this.field_70161_v); EntityZombie entityZombie = new EntityZombie(this.field_70170_p); for (byte b = 0; b < 50; b++) { int m = i + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1); int n = j + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1); int i1 = k + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1); if (World.func_147466_a((IBlockAccess)this.field_70170_p, m, n - 1, i1) && this.field_70170_p.func_72957_l(m, n, i1) < 10) { entityZombie.func_70107_b(m, n, i1); if (this.field_70170_p.func_72855_b(entityZombie.field_70121_D) && this.field_70170_p.func_72945_a((Entity)entityZombie, entityZombie.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(entityZombie.field_70121_D)) { this.field_70170_p.func_72838_d((Entity)entityZombie); entityZombie.func_70624_b(entityLivingBase); entityZombie.func_110161_a((IEntityLivingData)null); func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0)); entityZombie.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0)); break; }  }  }  }  return true; }  return false; }
/* 534 */   public void func_70071_h_() { if (!this.field_70170_p.field_72995_K && func_82230_o()) { int i = func_82233_q(); this.field_82234_d -= i; if (this.field_82234_d <= 0) func_82232_p();  }  super.func_70071_h_(); } public boolean func_70652_k(Entity p_70652_1_) { boolean bool = super.func_70652_k(p_70652_1_); if (bool) { int i = this.field_70170_p.field_73013_u.func_151525_a(); if (func_70694_bm() == null && func_70027_ad() && this.field_70146_Z.nextFloat() < i * 0.3F) p_70652_1_.func_70015_d(2 * i);  }  return bool; } protected String func_70639_aQ() { return "mob.zombie.say"; } protected String func_70621_aR() { return "mob.zombie.hurt"; } protected String func_70673_aS() { return "mob.zombie.death"; } protected final void func_70105_a(float p_70105_1_, float p_70105_2_) { boolean bool = (this.field_146074_bv > 0.0F && this.field_146073_bw > 0.0F) ? true : false;
/*     */     
/* 536 */     this.field_146074_bv = p_70105_1_;
/* 537 */     this.field_146073_bw = p_70105_2_;
/*     */     
/* 539 */     if (!bool)
/* 540 */       func_146069_a(1.0F);  } protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) { func_85030_a("mob.zombie.step", 0.15F, 1.0F); } protected Item func_146068_u() { return Items.field_151078_bh; } public EnumCreatureAttribute func_70668_bt() { return EnumCreatureAttribute.UNDEAD; } protected void func_70600_l(int p_70600_1_) { switch (this.field_70146_Z.nextInt(3)) { case 0: func_145779_a(Items.field_151042_j, 1); break;case 1: func_145779_a(Items.field_151172_bF, 1); break;case 2: func_145779_a(Items.field_151174_bG, 1); break; }  } protected void func_82164_bB() { super.func_82164_bB(); if (this.field_70146_Z.nextFloat() < ((this.field_70170_p.field_73013_u == EnumDifficulty.HARD) ? 0.05F : 0.01F)) { int i = this.field_70146_Z.nextInt(3); if (i == 0) { func_70062_b(0, new ItemStack(Items.field_151040_l)); } else { func_70062_b(0, new ItemStack(Items.field_151037_a)); }  }  }
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) { super.func_70014_b(p_70014_1_); if (func_70631_g_()) p_70014_1_.func_74757_a("IsBaby", true);  if (func_82231_m()) p_70014_1_.func_74757_a("IsVillager", true);  p_70014_1_.func_74768_a("ConversionTime", func_82230_o() ? this.field_82234_d : -1); p_70014_1_.func_74757_a("CanBreakDoors", func_146072_bX()); }
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) { super.func_70037_a(p_70037_1_); if (p_70037_1_.func_74767_n("IsBaby")) func_82227_f(true);  if (p_70037_1_.func_74767_n("IsVillager")) func_82229_g(true);  if (p_70037_1_.func_150297_b("ConversionTime", 99) && p_70037_1_.func_74762_e("ConversionTime") > -1) func_82228_a(p_70037_1_.func_74762_e("ConversionTime"));  func_146070_a(p_70037_1_.func_74767_n("CanBreakDoors")); }
/*     */   public void func_70074_a(EntityLivingBase p_70074_1_) { super.func_70074_a(p_70074_1_); if ((this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL || this.field_70170_p.field_73013_u == EnumDifficulty.HARD) && p_70074_1_ instanceof EntityVillager) { if (this.field_70170_p.field_73013_u != EnumDifficulty.HARD && this.field_70146_Z.nextBoolean()) return;  EntityZombie entityZombie = new EntityZombie(this.field_70170_p); entityZombie.func_82149_j((Entity)p_70074_1_); this.field_70170_p.func_72900_e((Entity)p_70074_1_); entityZombie.func_110161_a((IEntityLivingData)null); entityZombie.func_82229_g(true); if (p_70074_1_.func_70631_g_()) entityZombie.func_82227_f(true);  this.field_70170_p.func_72838_d((Entity)entityZombie); this.field_70170_p.func_72889_a(null, 1016, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0); }  }
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) { p_110161_1_ = super.func_110161_a(p_110161_1_); float f = this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v); func_98053_h((this.field_70146_Z.nextFloat() < 0.55F * f)); if (p_110161_1_ == null) p_110161_1_ = new GroupData((this.field_70170_p.field_73012_v.nextFloat() < 0.05F), (this.field_70170_p.field_73012_v.nextFloat() < 0.05F));  if (p_110161_1_ instanceof GroupData) { GroupData groupData = (GroupData)p_110161_1_; if (groupData.field_142046_b) func_82229_g(true);  if (groupData.field_142048_a) { func_82227_f(true); if (this.field_70170_p.field_73012_v.nextFloat() < 0.05D) { List<EntityChicken> list = this.field_70170_p.func_82733_a(EntityChicken.class, this.field_70121_D.func_72314_b(5.0D, 3.0D, 5.0D), IEntitySelector.field_152785_b); if (!list.isEmpty()) { EntityChicken entityChicken = list.get(0); entityChicken.func_152117_i(true); func_70078_a((Entity)entityChicken); }  } else if (this.field_70170_p.field_73012_v.nextFloat() < 0.05D) { EntityChicken entityChicken = new EntityChicken(this.field_70170_p); entityChicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F); entityChicken.func_110161_a(null); entityChicken.func_152117_i(true); this.field_70170_p.func_72838_d((Entity)entityChicken); func_70078_a((Entity)entityChicken); }  }  }  func_146070_a((this.field_70146_Z.nextFloat() < f * 0.1F)); func_82164_bB(); func_82162_bC(); if (func_71124_b(4) == null) { Calendar calendar = this.field_70170_p.func_83015_S(); if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F) { func_70062_b(4, new ItemStack((this.field_70146_Z.nextFloat() < 0.1F) ? Blocks.field_150428_aP : Blocks.field_150423_aK)); this.field_82174_bp[4] = 0.0F; }  }  func_110148_a(SharedMonsterAttributes.field_111266_c).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextDouble() * 0.05000000074505806D, 0)); double d = this.field_70146_Z.nextDouble() * 1.5D * this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v); if (d > 1.0D) func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random zombie-spawn bonus", d, 2));  if (this.field_70146_Z.nextFloat() < f * 0.05F) { func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Leader zombie bonus", this.field_70146_Z.nextDouble() * 0.25D + 0.5D, 0)); func_110148_a(SharedMonsterAttributes.field_111267_a).func_111121_a(new AttributeModifier("Leader zombie bonus", this.field_70146_Z.nextDouble() * 3.0D + 1.0D, 2)); func_146070_a(true); }  return p_110161_1_; }
/* 545 */   protected final void func_146069_a(float p_146069_1_) { super.func_70105_a(this.field_146074_bv * p_146069_1_, this.field_146073_bw * p_146069_1_); }
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/*     */     ItemStack itemStack = p_70085_1_.func_71045_bC();
/*     */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151153_ao && itemStack.func_77960_j() == 0 && func_82231_m() && func_70644_a(Potion.field_76437_t)) {
/*     */       if (!p_70085_1_.field_71075_bZ.field_75098_d)
/*     */         itemStack.field_77994_a--; 
/*     */       if (itemStack.field_77994_a <= 0)
/*     */         p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null); 
/*     */       if (!this.field_70170_p.field_72995_K)
/*     */         func_82228_a(this.field_70146_Z.nextInt(2401) + 3600); 
/*     */       return true;
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected void func_82228_a(int p_82228_1_) {
/*     */     this.field_82234_d = p_82228_1_;
/*     */     func_70096_w().func_75692_b(14, Byte.valueOf((byte)1));
/*     */     func_82170_o(Potion.field_76437_t.field_76415_H);
/*     */     func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, p_82228_1_, Math.min(this.field_70170_p.field_73013_u.func_151525_a() - 1, 0)));
/*     */     this.field_70170_p.func_72960_a((Entity)this, (byte)16);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/*     */     if (p_70103_1_ == 16) {
/*     */       this.field_70170_p.func_72980_b(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D, "mob.zombie.remedy", 1.0F + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7F + 0.3F, false);
/*     */     } else {
/*     */       super.func_70103_a(p_70103_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean func_70692_ba() {
/*     */     return !func_82230_o();
/*     */   }
/*     */   
/*     */   public boolean func_82230_o() {
/*     */     return (func_70096_w().func_75683_a(14) == 1);
/*     */   }
/*     */   
/*     */   protected void func_82232_p() {
/*     */     EntityVillager entityVillager = new EntityVillager(this.field_70170_p);
/*     */     entityVillager.func_82149_j((Entity)this);
/*     */     entityVillager.func_110161_a(null);
/*     */     entityVillager.func_82187_q();
/*     */     if (func_70631_g_())
/*     */       entityVillager.func_70873_a(-24000); 
/*     */     this.field_70170_p.func_72900_e((Entity)this);
/*     */     this.field_70170_p.func_72838_d((Entity)entityVillager);
/*     */     entityVillager.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 200, 0));
/*     */     this.field_70170_p.func_72889_a(null, 1017, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/*     */   }
/*     */   
/*     */   protected int func_82233_q() {
/*     */     byte b = 1;
/*     */     if (this.field_70146_Z.nextFloat() < 0.01F) {
/*     */       byte b1 = 0;
/*     */       for (int i = (int)this.field_70165_t - 4; i < (int)this.field_70165_t + 4 && b1 < 14; i++) {
/*     */         for (int j = (int)this.field_70163_u - 4; j < (int)this.field_70163_u + 4 && b1 < 14; j++) {
/*     */           for (int k = (int)this.field_70161_v - 4; k < (int)this.field_70161_v + 4 && b1 < 14; k++) {
/*     */             Block block = this.field_70170_p.func_147439_a(i, j, k);
/*     */             if (block == Blocks.field_150411_aY || block == Blocks.field_150324_C) {
/*     */               if (this.field_70146_Z.nextFloat() < 0.3F)
/*     */                 b++; 
/*     */               b1++;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     return b;
/*     */   }
/*     */   
/*     */   class GroupData implements IEntityLivingData {
/*     */     public boolean field_142048_a = false;
/*     */     public boolean field_142046_b = false;
/*     */     private static final String __OBFID = "CL_00001704";
/*     */     
/*     */     private GroupData(EntityZombie p_i2348_1_, boolean p_i2348_2_, boolean p_i2348_3_) {
/*     */       this.field_142048_a = p_i2348_2_;
/*     */       this.field_142046_b = p_i2348_3_;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_146071_k(boolean p_146071_1_) {
/*     */     func_146069_a(p_146071_1_ ? 0.5F : 1.0F);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityZombie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */