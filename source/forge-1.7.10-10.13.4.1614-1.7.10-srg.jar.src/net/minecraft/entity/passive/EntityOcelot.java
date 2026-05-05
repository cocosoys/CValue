/*     */ package net.minecraft.entity.passive;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIFollowOwner;
/*     */ import net.minecraft.entity.ai.EntityAILeapAtTarget;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIOcelotAttack;
/*     */ import net.minecraft.entity.ai.EntityAIOcelotSit;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITargetNonTamed;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityOcelot extends EntityTameable {
/*     */   private EntityAITempt field_70914_e;
/*     */   
/*     */   public EntityOcelot(World p_i1688_1_) {
/*  37 */     super(p_i1688_1_);
/*  38 */     func_70105_a(0.6F, 0.8F);
/*     */     
/*  40 */     func_70661_as().func_75491_a(true);
/*  41 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  42 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)this.field_70911_d);
/*  43 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)(this.field_70914_e = new EntityAITempt((EntityCreature)this, 0.6D, Items.field_151115_aP, true)));
/*  44 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 16.0F, 0.8D, 1.33D));
/*  45 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
/*  46 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIOcelotSit(this, 1.33D));
/*  47 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.3F));
/*  48 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIOcelotAttack((EntityLiving)this));
/*  49 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIMate(this, 0.8D));
/*  50 */     this.field_70714_bg.func_75776_a(10, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.8D));
/*  51 */     this.field_70714_bg.func_75776_a(11, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*     */     
/*  53 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAITargetNonTamed(this, EntityChicken.class, 750, false));
/*     */   }
/*     */   private static final String __OBFID = "CL_00001646";
/*     */   
/*     */   protected void func_70088_a() {
/*  58 */     super.func_70088_a();
/*     */     
/*  60 */     this.field_70180_af.func_75682_a(18, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70629_bd() {
/*  65 */     if (func_70605_aq().func_75640_a()) {
/*  66 */       double d = func_70605_aq().func_75638_b();
/*  67 */       if (d == 0.6D) {
/*  68 */         func_70095_a(true);
/*  69 */         func_70031_b(false);
/*  70 */       } else if (d == 1.33D) {
/*  71 */         func_70095_a(false);
/*  72 */         func_70031_b(true);
/*     */       } else {
/*  74 */         func_70095_a(false);
/*  75 */         func_70031_b(false);
/*     */       } 
/*     */     } else {
/*  78 */       func_70095_a(false);
/*  79 */       func_70031_b(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/*  85 */     return (!func_70909_n() && this.field_70173_aa > 2400);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  95 */     super.func_110147_ax();
/*     */     
/*  97 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
/*  98 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30000001192092896D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 108 */     super.func_70014_b(p_70014_1_);
/* 109 */     p_70014_1_.func_74768_a("CatType", func_70913_u());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 114 */     super.func_70037_a(p_70037_1_);
/* 115 */     func_70912_b(p_70037_1_.func_74762_e("CatType"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 120 */     if (func_70909_n()) {
/* 121 */       if (func_70880_s()) {
/* 122 */         return "mob.cat.purr";
/*     */       }
/* 124 */       if (this.field_70146_Z.nextInt(4) == 0) {
/* 125 */         return "mob.cat.purreow";
/*     */       }
/* 127 */       return "mob.cat.meow";
/*     */     } 
/*     */     
/* 130 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 135 */     return "mob.cat.hitt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 140 */     return "mob.cat.hitt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 145 */     return 0.4F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 150 */     return Items.field_151116_aA;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity p_70652_1_) {
/* 155 */     return p_70652_1_.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 3.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 160 */     if (func_85032_ar()) return false; 
/* 161 */     this.field_70911_d.func_75270_a(false);
/* 162 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {}
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 171 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/* 172 */     if (func_70909_n()) {
/* 173 */       if (func_152114_e((EntityLivingBase)p_70085_1_) && 
/* 174 */         !this.field_70170_p.field_72995_K && !func_70877_b(itemStack)) {
/* 175 */         this.field_70911_d.func_75270_a(!func_70906_o());
/*     */       
/*     */       }
/*     */     }
/* 179 */     else if (this.field_70914_e.func_75277_f() && itemStack != null && itemStack.func_77973_b() == Items.field_151115_aP && p_70085_1_.func_70068_e((Entity)this) < 9.0D) {
/* 180 */       if (!p_70085_1_.field_71075_bZ.field_75098_d) itemStack.field_77994_a--; 
/* 181 */       if (itemStack.field_77994_a <= 0) {
/* 182 */         p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
/*     */       }
/*     */       
/* 185 */       if (!this.field_70170_p.field_72995_K) {
/* 186 */         if (this.field_70146_Z.nextInt(3) == 0) {
/* 187 */           func_70903_f(true);
/* 188 */           func_70912_b(1 + this.field_70170_p.field_73012_v.nextInt(3));
/* 189 */           func_152115_b(p_70085_1_.func_110124_au().toString());
/* 190 */           func_70908_e(true);
/* 191 */           this.field_70911_d.func_75270_a(true);
/* 192 */           this.field_70170_p.func_72960_a((Entity)this, (byte)7);
/*     */         } else {
/* 194 */           func_70908_e(false);
/* 195 */           this.field_70170_p.func_72960_a((Entity)this, (byte)6);
/*     */         } 
/*     */       }
/* 198 */       return true;
/*     */     } 
/*     */     
/* 201 */     return super.func_70085_c(p_70085_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityOcelot func_90011_a(EntityAgeable p_90011_1_) {
/* 206 */     EntityOcelot entityOcelot = new EntityOcelot(this.field_70170_p);
/* 207 */     if (func_70909_n()) {
/* 208 */       entityOcelot.func_152115_b(func_152113_b());
/* 209 */       entityOcelot.func_70903_f(true);
/* 210 */       entityOcelot.func_70912_b(func_70913_u());
/*     */     } 
/* 212 */     return entityOcelot;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack p_70877_1_) {
/* 217 */     return (p_70877_1_ != null && p_70877_1_.func_77973_b() == Items.field_151115_aP);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70878_b(EntityAnimal p_70878_1_) {
/* 222 */     if (p_70878_1_ == this) return false; 
/* 223 */     if (!func_70909_n()) return false; 
/* 224 */     if (!(p_70878_1_ instanceof EntityOcelot)) return false;
/*     */     
/* 226 */     EntityOcelot entityOcelot = (EntityOcelot)p_70878_1_;
/* 227 */     if (!entityOcelot.func_70909_n()) return false;
/*     */     
/* 229 */     return (func_70880_s() && entityOcelot.func_70880_s());
/*     */   }
/*     */   
/*     */   public int func_70913_u() {
/* 233 */     return this.field_70180_af.func_75683_a(18);
/*     */   }
/*     */   
/*     */   public void func_70912_b(int p_70912_1_) {
/* 237 */     this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)p_70912_1_));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 243 */     if (this.field_70170_p.field_73012_v.nextInt(3) == 0) {
/* 244 */       return false;
/*     */     }
/* 246 */     if (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
/* 247 */       int i = MathHelper.func_76128_c(this.field_70165_t);
/* 248 */       int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 249 */       int k = MathHelper.func_76128_c(this.field_70161_v);
/* 250 */       if (j < 63) {
/* 251 */         return false;
/*     */       }
/*     */       
/* 254 */       Block block = this.field_70170_p.func_147439_a(i, j - 1, k);
/* 255 */       if (block == Blocks.field_150349_c || block.func_149688_o() == Material.field_151584_j) {
/* 256 */         return true;
/*     */       }
/*     */     } 
/* 259 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_70005_c_() {
/* 265 */     if (func_94056_bM()) return func_94057_bL(); 
/* 266 */     if (func_70909_n()) {
/* 267 */       return StatCollector.func_74838_a("entity.Cat.name");
/*     */     }
/* 269 */     return super.func_70005_c_();
/*     */   }
/*     */ 
/*     */   
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 274 */     p_110161_1_ = super.func_110161_a(p_110161_1_);
/*     */     
/* 276 */     if (this.field_70170_p.field_73012_v.nextInt(7) == 0) {
/* 277 */       for (byte b = 0; b < 2; b++) {
/* 278 */         EntityOcelot entityOcelot = new EntityOcelot(this.field_70170_p);
/* 279 */         entityOcelot.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
/* 280 */         entityOcelot.func_70873_a(-24000);
/* 281 */         this.field_70170_p.func_72838_d((Entity)entityOcelot);
/*     */       } 
/*     */     }
/* 284 */     return p_110161_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityOcelot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */