/*     */ package net.minecraft.entity.passive;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIControlledByPlayer;
/*     */ import net.minecraft.entity.monster.EntityPigZombie;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityPig extends EntityAnimal {
/*     */   private final EntityAIControlledByPlayer field_82184_d;
/*     */   
/*     */   public EntityPig(World p_i1689_1_) {
/*  20 */     super(p_i1689_1_);
/*  21 */     func_70105_a(0.9F, 0.9F);
/*     */     
/*  23 */     func_70661_as().func_75491_a(true);
/*  24 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  25 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.25D));
/*  26 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)(this.field_82184_d = new EntityAIControlledByPlayer((EntityLiving)this, 0.3F)));
/*  27 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  28 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2D, Items.field_151146_bM, false));
/*  29 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2D, Items.field_151172_bF, false));
/*  30 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIFollowParent(this, 1.1D));
/*  31 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  32 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  33 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */   private static final String __OBFID = "CL_00001647";
/*     */   
/*     */   public boolean func_70650_aV() {
/*  38 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  43 */     super.func_110147_ax();
/*     */     
/*  45 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
/*  46 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {
/*  51 */     super.func_70619_bc();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82171_bF() {
/*  56 */     ItemStack itemStack = ((EntityPlayer)this.field_70153_n).func_70694_bm();
/*     */     
/*  58 */     return (itemStack != null && itemStack.func_77973_b() == Items.field_151146_bM);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  63 */     super.func_70088_a();
/*  64 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  69 */     super.func_70014_b(p_70014_1_);
/*  70 */     p_70014_1_.func_74757_a("Saddle", func_70901_n());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  75 */     super.func_70037_a(p_70037_1_);
/*  76 */     func_70900_e(p_70037_1_.func_74767_n("Saddle"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  81 */     return "mob.pig.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  86 */     return "mob.pig.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  91 */     return "mob.pig.death";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/*  96 */     func_85030_a("mob.pig.step", 0.15F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 101 */     if (!super.func_70085_c(p_70085_1_)) {
/* 102 */       if (func_70901_n() && !this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == p_70085_1_)) {
/* 103 */         p_70085_1_.func_70078_a((Entity)this);
/* 104 */         return true;
/*     */       } 
/* 106 */       return false;
/*     */     } 
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 113 */     if (func_70027_ad()) return Items.field_151157_am; 
/* 114 */     return Items.field_151147_al;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 119 */     int i = this.field_70146_Z.nextInt(3) + 1 + this.field_70146_Z.nextInt(1 + p_70628_2_);
/*     */     
/* 121 */     for (byte b = 0; b < i; b++) {
/* 122 */       if (func_70027_ad()) {
/* 123 */         func_145779_a(Items.field_151157_am, 1);
/*     */       } else {
/* 125 */         func_145779_a(Items.field_151147_al, 1);
/*     */       } 
/*     */     } 
/*     */     
/* 129 */     if (func_70901_n()) func_145779_a(Items.field_151141_av, 1); 
/*     */   }
/*     */   
/*     */   public boolean func_70901_n() {
/* 133 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */   
/*     */   public void func_70900_e(boolean p_70900_1_) {
/* 137 */     if (p_70900_1_) {
/* 138 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)1));
/*     */     } else {
/* 140 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)0));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70077_a(EntityLightningBolt p_70077_1_) {
/* 146 */     if (this.field_70170_p.field_72995_K)
/*     */       return; 
/* 148 */     EntityPigZombie entityPigZombie = new EntityPigZombie(this.field_70170_p);
/* 149 */     entityPigZombie.func_70062_b(0, new ItemStack(Items.field_151010_B));
/* 150 */     entityPigZombie.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 151 */     this.field_70170_p.func_72838_d((Entity)entityPigZombie);
/* 152 */     func_70106_y();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {
/* 157 */     super.func_70069_a(p_70069_1_);
/*     */     
/* 159 */     if (p_70069_1_ > 5.0F && this.field_70153_n instanceof EntityPlayer) {
/* 160 */       ((EntityPlayer)this.field_70153_n).func_71029_a((StatBase)AchievementList.field_76021_u);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPig func_90011_a(EntityAgeable p_90011_1_) {
/* 166 */     return new EntityPig(this.field_70170_p);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack p_70877_1_) {
/* 171 */     return (p_70877_1_ != null && p_70877_1_.func_77973_b() == Items.field_151172_bF);
/*     */   }
/*     */   
/*     */   public EntityAIControlledByPlayer func_82183_n() {
/* 175 */     return this.field_82184_d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityPig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */