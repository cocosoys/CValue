/*     */ package net.minecraft.entity.passive;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIFollowParent;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityChicken extends EntityAnimal {
/*     */   public float field_70886_e;
/*     */   public float field_70883_f;
/*  22 */   public float field_70889_i = 1.0F; public float field_70884_g; public float field_70888_h; public int field_70887_j;
/*     */   public boolean field_152118_bv;
/*     */   private static final String __OBFID = "CL_00001639";
/*     */   
/*     */   public EntityChicken(World p_i1682_1_) {
/*  27 */     super(p_i1682_1_);
/*  28 */     func_70105_a(0.3F, 0.7F);
/*  29 */     this.field_70887_j = this.field_70146_Z.nextInt(6000) + 6000;
/*     */     
/*  31 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  32 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4D));
/*  33 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  34 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.0D, Items.field_151014_N, false));
/*  35 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent(this, 1.1D));
/*  36 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  37 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  38 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  43 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  48 */     super.func_110147_ax();
/*     */     
/*  50 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4.0D);
/*  51 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  56 */     super.func_70636_d();
/*     */     
/*  58 */     this.field_70888_h = this.field_70886_e;
/*  59 */     this.field_70884_g = this.field_70883_f;
/*     */     
/*  61 */     this.field_70883_f = (float)(this.field_70883_f + (this.field_70122_E ? -1 : 4) * 0.3D);
/*  62 */     if (this.field_70883_f < 0.0F) this.field_70883_f = 0.0F; 
/*  63 */     if (this.field_70883_f > 1.0F) this.field_70883_f = 1.0F;
/*     */     
/*  65 */     if (!this.field_70122_E && this.field_70889_i < 1.0F) this.field_70889_i = 1.0F; 
/*  66 */     this.field_70889_i = (float)(this.field_70889_i * 0.9D);
/*     */     
/*  68 */     if (!this.field_70122_E && this.field_70181_x < 0.0D) {
/*  69 */       this.field_70181_x *= 0.6D;
/*     */     }
/*     */     
/*  72 */     this.field_70886_e += this.field_70889_i * 2.0F;
/*     */     
/*  74 */     if (!this.field_70170_p.field_72995_K && !func_70631_g_() && !func_152116_bZ() && --this.field_70887_j <= 0) {
/*  75 */       func_85030_a("mob.chicken.plop", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*  76 */       func_145779_a(Items.field_151110_aK, 1);
/*  77 */       this.field_70887_j = this.field_70146_Z.nextInt(6000) + 6000;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {}
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  87 */     return "mob.chicken.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  92 */     return "mob.chicken.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  97 */     return "mob.chicken.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/* 102 */     func_85030_a("mob.chicken.step", 0.15F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 107 */     return Items.field_151008_G;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 113 */     int i = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + p_70628_2_);
/* 114 */     for (byte b = 0; b < i; b++) {
/* 115 */       func_145779_a(Items.field_151008_G, 1);
/*     */     }
/*     */     
/* 118 */     if (func_70027_ad()) { func_145779_a(Items.field_151077_bg, 1); }
/*     */     else
/* 120 */     { func_145779_a(Items.field_151076_bf, 1); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityChicken func_90011_a(EntityAgeable p_90011_1_) {
/* 126 */     return new EntityChicken(this.field_70170_p);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack p_70877_1_) {
/* 131 */     return (p_70877_1_ != null && p_70877_1_.func_77973_b() instanceof net.minecraft.item.ItemSeeds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 136 */     super.func_70037_a(p_70037_1_);
/* 137 */     this.field_152118_bv = p_70037_1_.func_74767_n("IsChickenJockey");
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_70693_a(EntityPlayer p_70693_1_) {
/* 142 */     if (func_152116_bZ()) {
/* 143 */       return 10;
/*     */     }
/* 145 */     return super.func_70693_a(p_70693_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 150 */     super.func_70014_b(p_70014_1_);
/* 151 */     p_70014_1_.func_74757_a("IsChickenJockey", this.field_152118_bv);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 156 */     return (func_152116_bZ() && this.field_70153_n == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70043_V() {
/* 161 */     super.func_70043_V();
/* 162 */     float f1 = MathHelper.func_76126_a(this.field_70761_aq * 3.1415927F / 180.0F);
/* 163 */     float f2 = MathHelper.func_76134_b(this.field_70761_aq * 3.1415927F / 180.0F);
/* 164 */     float f3 = 0.1F;
/* 165 */     float f4 = 0.0F;
/*     */     
/* 167 */     this.field_70153_n.func_70107_b(this.field_70165_t + (f3 * f1), this.field_70163_u + (this.field_70131_O * 0.5F) + this.field_70153_n.func_70033_W() + f4, this.field_70161_v - (f3 * f2));
/* 168 */     if (this.field_70153_n instanceof EntityLivingBase) {
/* 169 */       ((EntityLivingBase)this.field_70153_n).field_70761_aq = this.field_70761_aq;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_152116_bZ() {
/* 174 */     return this.field_152118_bv;
/*     */   }
/*     */   
/*     */   public void func_152117_i(boolean p_152117_1_) {
/* 178 */     this.field_152118_bv = p_152117_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityChicken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */