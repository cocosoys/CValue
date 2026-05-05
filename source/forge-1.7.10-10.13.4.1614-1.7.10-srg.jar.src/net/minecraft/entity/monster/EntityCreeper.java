/*     */ package net.minecraft.entity.monster;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAICreeperSwell;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.effect.EntityLightningBolt;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityCreeper extends EntityMob {
/*     */   private int field_70834_e;
/*  26 */   private int field_82225_f = 30; private int field_70833_d;
/*  27 */   private int field_82226_g = 3; private static final String __OBFID = "CL_00001684";
/*     */   
/*     */   public EntityCreeper(World p_i1733_1_) {
/*  30 */     super(p_i1733_1_);
/*     */     
/*  32 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  33 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAICreeperSwell(this));
/*  34 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
/*  35 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackOnCollide(this, 1.0D, false));
/*  36 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander(this, 0.8D));
/*  37 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  38 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  40 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
/*  41 */     this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIHurtByTarget(this, false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  46 */     super.func_110147_ax();
/*     */     
/*  48 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82143_as() {
/*  58 */     if (func_70638_az() == null) return 3;
/*     */     
/*  60 */     return 3 + (int)(func_110143_aJ() - 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {
/*  65 */     super.func_70069_a(p_70069_1_);
/*     */     
/*  67 */     this.field_70833_d = (int)(this.field_70833_d + p_70069_1_ * 1.5F);
/*  68 */     if (this.field_70833_d > this.field_82225_f - 5) this.field_70833_d = this.field_82225_f - 5;
/*     */   
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  73 */     super.func_70088_a();
/*     */     
/*  75 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)-1));
/*  76 */     this.field_70180_af.func_75682_a(17, Byte.valueOf((byte)0));
/*  77 */     this.field_70180_af.func_75682_a(18, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  82 */     super.func_70014_b(p_70014_1_);
/*  83 */     if (this.field_70180_af.func_75683_a(17) == 1) p_70014_1_.func_74757_a("powered", true); 
/*  84 */     p_70014_1_.func_74777_a("Fuse", (short)this.field_82225_f);
/*  85 */     p_70014_1_.func_74774_a("ExplosionRadius", (byte)this.field_82226_g);
/*  86 */     p_70014_1_.func_74757_a("ignited", func_146078_ca());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  91 */     super.func_70037_a(p_70037_1_);
/*  92 */     this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)(p_70037_1_.func_74767_n("powered") ? 1 : 0)));
/*  93 */     if (p_70037_1_.func_150297_b("Fuse", 99)) this.field_82225_f = p_70037_1_.func_74765_d("Fuse"); 
/*  94 */     if (p_70037_1_.func_150297_b("ExplosionRadius", 99)) this.field_82226_g = p_70037_1_.func_74771_c("ExplosionRadius"); 
/*  95 */     if (p_70037_1_.func_74767_n("ignited")) func_146079_cb();
/*     */   
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 100 */     if (func_70089_S()) {
/* 101 */       this.field_70834_e = this.field_70833_d;
/*     */ 
/*     */       
/* 104 */       if (func_146078_ca()) {
/* 105 */         func_70829_a(1);
/*     */       }
/*     */       
/* 108 */       int i = func_70832_p();
/* 109 */       if (i > 0 && this.field_70833_d == 0) {
/* 110 */         func_85030_a("creeper.primed", 1.0F, 0.5F);
/*     */       }
/* 112 */       this.field_70833_d += i;
/* 113 */       if (this.field_70833_d < 0) this.field_70833_d = 0; 
/* 114 */       if (this.field_70833_d >= this.field_82225_f) {
/* 115 */         this.field_70833_d = this.field_82225_f;
/* 116 */         func_146077_cc();
/*     */       } 
/*     */     } 
/* 119 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 124 */     return "mob.creeper.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 129 */     return "mob.creeper.death";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource p_70645_1_) {
/* 134 */     super.func_70645_a(p_70645_1_);
/*     */     
/* 136 */     if (p_70645_1_.func_76346_g() instanceof EntitySkeleton) {
/*     */       
/* 138 */       int i = Item.func_150891_b(Items.field_151096_cd);
/* 139 */       int j = Item.func_150891_b(Items.field_151084_co);
/* 140 */       int k = i + this.field_70146_Z.nextInt(j - i + 1);
/* 141 */       func_145779_a(Item.func_150899_d(k), 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity p_70652_1_) {
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_70830_n() {
/* 151 */     return (this.field_70180_af.func_75683_a(17) == 1);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70831_j(float p_70831_1_) {
/* 155 */     return (this.field_70834_e + (this.field_70833_d - this.field_70834_e) * p_70831_1_) / (this.field_82225_f - 2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 160 */     return Items.field_151016_H;
/*     */   }
/*     */   
/*     */   public int func_70832_p() {
/* 164 */     return this.field_70180_af.func_75683_a(16);
/*     */   }
/*     */   
/*     */   public void func_70829_a(int p_70829_1_) {
/* 168 */     this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)p_70829_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70077_a(EntityLightningBolt p_70077_1_) {
/* 173 */     super.func_70077_a(p_70077_1_);
/* 174 */     this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)1));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 179 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/* 180 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151033_d) {
/* 181 */       this.field_70170_p.func_72908_a(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D, "fire.ignite", 1.0F, this.field_70146_Z.nextFloat() * 0.4F + 0.8F);
/* 182 */       p_70085_1_.func_71038_i();
/* 183 */       if (!this.field_70170_p.field_72995_K) {
/* 184 */         func_146079_cb();
/* 185 */         itemStack.func_77972_a(1, (EntityLivingBase)p_70085_1_);
/* 186 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 190 */     return super.func_70085_c(p_70085_1_);
/*     */   }
/*     */   
/*     */   private void func_146077_cc() {
/* 194 */     if (!this.field_70170_p.field_72995_K) {
/* 195 */       boolean bool = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
/* 196 */       if (func_70830_n()) { this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, (this.field_82226_g * 2), bool); }
/* 197 */       else { this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_82226_g, bool); }
/* 198 */        func_70106_y();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_146078_ca() {
/* 203 */     return (this.field_70180_af.func_75683_a(18) != 0);
/*     */   }
/*     */   
/*     */   public void func_146079_cb() {
/* 207 */     this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)1));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityCreeper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */