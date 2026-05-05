/*     */ package net.minecraft.entity.passive;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockColored;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityWolf extends EntityTameable {
/*     */   private float field_70926_e;
/*     */   private float field_70924_f;
/*     */   private boolean field_70925_g;
/*     */   
/*     */   public EntityWolf(World p_i1696_1_) {
/*  36 */     super(p_i1696_1_);
/*  37 */     func_70105_a(0.6F, 0.8F);
/*     */     
/*  39 */     func_70661_as().func_75491_a(true);
/*  40 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  41 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)this.field_70911_d);
/*  42 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.4F));
/*  43 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, true));
/*  44 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
/*  45 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMate(this, 1.0D));
/*  46 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  47 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIBeg(this, 8.0F));
/*  48 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  49 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  51 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIOwnerHurtByTarget(this));
/*  52 */     this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIOwnerHurtTarget(this));
/*  53 */     this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
/*  54 */     this.field_70715_bh.func_75776_a(4, (EntityAIBase)new EntityAITargetNonTamed(this, EntitySheep.class, 200, false));
/*     */     
/*  56 */     func_70903_f(false);
/*     */   }
/*     */   private boolean field_70928_h; private float field_70929_i; private float field_70927_j; private static final String __OBFID = "CL_00001654";
/*     */   
/*     */   protected void func_110147_ax() {
/*  61 */     super.func_110147_ax();
/*     */     
/*  63 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30000001192092896D);
/*     */     
/*  65 */     if (func_70909_n()) {
/*  66 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
/*     */     } else {
/*  68 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(8.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70624_b(EntityLivingBase p_70624_1_) {
/*  79 */     super.func_70624_b(p_70624_1_);
/*  80 */     if (p_70624_1_ == null) {
/*  81 */       func_70916_h(false);
/*  82 */     } else if (!func_70909_n()) {
/*  83 */       func_70916_h(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70629_bd() {
/*  89 */     this.field_70180_af.func_75692_b(18, Float.valueOf(func_110143_aJ()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  94 */     super.func_70088_a();
/*  95 */     this.field_70180_af.func_75682_a(18, new Float(func_110143_aJ()));
/*  96 */     this.field_70180_af.func_75682_a(19, new Byte((byte)0));
/*  97 */     this.field_70180_af.func_75682_a(20, new Byte((byte)BlockColored.func_150032_b(1)));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/* 102 */     func_85030_a("mob.wolf.step", 0.15F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 107 */     super.func_70014_b(p_70014_1_);
/*     */     
/* 109 */     p_70014_1_.func_74757_a("Angry", func_70919_bu());
/* 110 */     p_70014_1_.func_74774_a("CollarColor", (byte)func_82186_bH());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 115 */     super.func_70037_a(p_70037_1_);
/*     */     
/* 117 */     func_70916_h(p_70037_1_.func_74767_n("Angry"));
/* 118 */     if (p_70037_1_.func_150297_b("CollarColor", 99)) func_82185_r(p_70037_1_.func_74771_c("CollarColor"));
/*     */   
/*     */   }
/*     */   
/*     */   protected String func_70639_aQ() {
/* 123 */     if (func_70919_bu()) {
/* 124 */       return "mob.wolf.growl";
/*     */     }
/* 126 */     if (this.field_70146_Z.nextInt(3) == 0) {
/* 127 */       if (func_70909_n() && this.field_70180_af.func_111145_d(18) < 10.0F) {
/* 128 */         return "mob.wolf.whine";
/*     */       }
/* 130 */       return "mob.wolf.panting";
/*     */     } 
/* 132 */     return "mob.wolf.bark";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 137 */     return "mob.wolf.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 142 */     return "mob.wolf.death";
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 147 */     return 0.4F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 152 */     return Item.func_150899_d(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 157 */     super.func_70636_d();
/*     */     
/* 159 */     if (!this.field_70170_p.field_72995_K && this.field_70925_g && !this.field_70928_h && !func_70781_l() && this.field_70122_E) {
/* 160 */       this.field_70928_h = true;
/* 161 */       this.field_70929_i = 0.0F;
/* 162 */       this.field_70927_j = 0.0F;
/* 163 */       this.field_70170_p.func_72960_a((Entity)this, (byte)8);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 169 */     super.func_70071_h_();
/*     */     
/* 171 */     this.field_70924_f = this.field_70926_e;
/* 172 */     if (func_70922_bv()) {
/* 173 */       this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
/*     */     } else {
/* 175 */       this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
/*     */     } 
/* 177 */     if (func_70922_bv()) {
/* 178 */       this.field_70700_bx = 10;
/*     */     }
/*     */     
/* 181 */     if (func_70026_G()) {
/* 182 */       this.field_70925_g = true;
/* 183 */       this.field_70928_h = false;
/* 184 */       this.field_70929_i = 0.0F;
/* 185 */       this.field_70927_j = 0.0F;
/* 186 */     } else if ((this.field_70925_g || this.field_70928_h) && 
/* 187 */       this.field_70928_h) {
/*     */       
/* 189 */       if (this.field_70929_i == 0.0F) {
/* 190 */         func_85030_a("mob.wolf.shake", func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*     */       }
/*     */       
/* 193 */       this.field_70927_j = this.field_70929_i;
/* 194 */       this.field_70929_i += 0.05F;
/*     */       
/* 196 */       if (this.field_70927_j >= 2.0F) {
/* 197 */         this.field_70925_g = false;
/* 198 */         this.field_70928_h = false;
/* 199 */         this.field_70927_j = 0.0F;
/* 200 */         this.field_70929_i = 0.0F;
/*     */       } 
/*     */       
/* 203 */       if (this.field_70929_i > 0.4F) {
/* 204 */         float f = (float)this.field_70121_D.field_72338_b;
/* 205 */         int i = (int)(MathHelper.func_76126_a((this.field_70929_i - 0.4F) * 3.1415927F) * 7.0F);
/* 206 */         for (byte b = 0; b < i; b++) {
/* 207 */           float f1 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N * 0.5F;
/* 208 */           float f2 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N * 0.5F;
/* 209 */           this.field_70170_p.func_72869_a("splash", this.field_70165_t + f1, (f + 0.8F), this.field_70161_v + f2, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70921_u() {
/* 217 */     return this.field_70925_g;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70915_j(float p_70915_1_) {
/* 221 */     return 0.75F + (this.field_70927_j + (this.field_70929_i - this.field_70927_j) * p_70915_1_) / 2.0F * 0.25F;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70923_f(float p_70923_1_, float p_70923_2_) {
/* 225 */     float f = (this.field_70927_j + (this.field_70929_i - this.field_70927_j) * p_70923_1_ + p_70923_2_) / 1.8F;
/* 226 */     if (f < 0.0F) {
/* 227 */       f = 0.0F;
/* 228 */     } else if (f > 1.0F) {
/* 229 */       f = 1.0F;
/*     */     } 
/* 231 */     return MathHelper.func_76126_a(f * 3.1415927F) * MathHelper.func_76126_a(f * 3.1415927F * 11.0F) * 0.15F * 3.1415927F;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70917_k(float p_70917_1_) {
/* 235 */     return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * p_70917_1_) * 0.15F * 3.1415927F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70047_e() {
/* 240 */     return this.field_70131_O * 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70646_bf() {
/* 245 */     if (func_70906_o()) {
/* 246 */       return 20;
/*     */     }
/* 248 */     return super.func_70646_bf();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 253 */     if (func_85032_ar()) return false; 
/* 254 */     Entity entity = p_70097_1_.func_76346_g();
/* 255 */     this.field_70911_d.func_75270_a(false);
/*     */     
/* 257 */     if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof net.minecraft.entity.projectile.EntityArrow))
/*     */     {
/* 259 */       p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
/*     */     }
/* 261 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity p_70652_1_) {
/* 266 */     byte b = func_70909_n() ? 4 : 2;
/* 267 */     return p_70652_1_.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70903_f(boolean p_70903_1_) {
/* 272 */     super.func_70903_f(p_70903_1_);
/*     */     
/* 274 */     if (p_70903_1_) {
/* 275 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
/*     */     } else {
/* 277 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(8.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 283 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/*     */     
/* 285 */     if (func_70909_n()) {
/* 286 */       if (itemStack != null) {
/* 287 */         if (itemStack.func_77973_b() instanceof ItemFood) {
/* 288 */           ItemFood itemFood = (ItemFood)itemStack.func_77973_b();
/*     */           
/* 290 */           if (itemFood.func_77845_h() && this.field_70180_af.func_111145_d(18) < 20.0F) {
/* 291 */             if (!p_70085_1_.field_71075_bZ.field_75098_d) itemStack.field_77994_a--; 
/* 292 */             func_70691_i(itemFood.func_150905_g(itemStack));
/* 293 */             if (itemStack.field_77994_a <= 0) {
/* 294 */               p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
/*     */             }
/* 296 */             return true;
/*     */           } 
/* 298 */         } else if (itemStack.func_77973_b() == Items.field_151100_aR) {
/* 299 */           int i = BlockColored.func_150032_b(itemStack.func_77960_j());
/* 300 */           if (i != func_82186_bH()) {
/* 301 */             func_82185_r(i);
/*     */             
/* 303 */             if (!p_70085_1_.field_71075_bZ.field_75098_d && --itemStack.field_77994_a <= 0) {
/* 304 */               p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
/*     */             }
/*     */             
/* 307 */             return true;
/*     */           } 
/*     */         } 
/*     */       }
/* 311 */       if (func_152114_e((EntityLivingBase)p_70085_1_) && 
/* 312 */         !this.field_70170_p.field_72995_K && !func_70877_b(itemStack)) {
/* 313 */         this.field_70911_d.func_75270_a(!func_70906_o());
/* 314 */         this.field_70703_bu = false;
/* 315 */         func_70778_a(null);
/* 316 */         func_70784_b(null);
/* 317 */         func_70624_b((EntityLivingBase)null);
/*     */       }
/*     */     
/*     */     }
/* 321 */     else if (itemStack != null && itemStack.func_77973_b() == Items.field_151103_aS && !func_70919_bu()) {
/* 322 */       if (!p_70085_1_.field_71075_bZ.field_75098_d) itemStack.field_77994_a--; 
/* 323 */       if (itemStack.field_77994_a <= 0) {
/* 324 */         p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
/*     */       }
/* 326 */       if (!this.field_70170_p.field_72995_K) {
/* 327 */         if (this.field_70146_Z.nextInt(3) == 0) {
/* 328 */           func_70903_f(true);
/* 329 */           func_70778_a(null);
/* 330 */           func_70624_b((EntityLivingBase)null);
/* 331 */           this.field_70911_d.func_75270_a(true);
/* 332 */           func_70606_j(20.0F);
/* 333 */           func_152115_b(p_70085_1_.func_110124_au().toString());
/* 334 */           func_70908_e(true);
/* 335 */           this.field_70170_p.func_72960_a((Entity)this, (byte)7);
/*     */         } else {
/* 337 */           func_70908_e(false);
/* 338 */           this.field_70170_p.func_72960_a((Entity)this, (byte)6);
/*     */         } 
/*     */       }
/*     */       
/* 342 */       return true;
/*     */     } 
/*     */     
/* 345 */     return super.func_70085_c(p_70085_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/* 350 */     if (p_70103_1_ == 8) {
/* 351 */       this.field_70928_h = true;
/* 352 */       this.field_70929_i = 0.0F;
/* 353 */       this.field_70927_j = 0.0F;
/*     */     } else {
/* 355 */       super.func_70103_a(p_70103_1_);
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70920_v() {
/* 360 */     if (func_70919_bu())
/* 361 */       return 1.5393804F; 
/* 362 */     if (func_70909_n()) {
/* 363 */       return (0.55F - (20.0F - this.field_70180_af.func_111145_d(18)) * 0.02F) * 3.1415927F;
/*     */     }
/* 365 */     return 0.62831855F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack p_70877_1_) {
/* 370 */     if (p_70877_1_ == null) return false; 
/* 371 */     if (!(p_70877_1_.func_77973_b() instanceof ItemFood)) return false; 
/* 372 */     return ((ItemFood)p_70877_1_.func_77973_b()).func_77845_h();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70641_bl() {
/* 377 */     return 8;
/*     */   }
/*     */   
/*     */   public boolean func_70919_bu() {
/* 381 */     return ((this.field_70180_af.func_75683_a(16) & 0x2) != 0);
/*     */   }
/*     */   
/*     */   public void func_70916_h(boolean p_70916_1_) {
/* 385 */     byte b = this.field_70180_af.func_75683_a(16);
/* 386 */     if (p_70916_1_) {
/* 387 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b | 0x2)));
/*     */     } else {
/* 389 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & 0xFFFFFFFD)));
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_82186_bH() {
/* 394 */     return this.field_70180_af.func_75683_a(20) & 0xF;
/*     */   }
/*     */   
/*     */   public void func_82185_r(int p_82185_1_) {
/* 398 */     this.field_70180_af.func_75692_b(20, Byte.valueOf((byte)(p_82185_1_ & 0xF)));
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityWolf func_90011_a(EntityAgeable p_90011_1_) {
/* 403 */     EntityWolf entityWolf = new EntityWolf(this.field_70170_p);
/* 404 */     String str = func_152113_b();
/* 405 */     if (str != null && str.trim().length() > 0) {
/* 406 */       entityWolf.func_152115_b(str);
/* 407 */       entityWolf.func_70903_f(true);
/*     */     } 
/* 409 */     return entityWolf;
/*     */   }
/*     */   
/*     */   public void func_70918_i(boolean p_70918_1_) {
/* 413 */     if (p_70918_1_) {
/* 414 */       this.field_70180_af.func_75692_b(19, Byte.valueOf((byte)1));
/*     */     } else {
/* 416 */       this.field_70180_af.func_75692_b(19, Byte.valueOf((byte)0));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70878_b(EntityAnimal p_70878_1_) {
/* 422 */     if (p_70878_1_ == this) return false; 
/* 423 */     if (!func_70909_n()) return false; 
/* 424 */     if (!(p_70878_1_ instanceof EntityWolf)) return false;
/*     */     
/* 426 */     EntityWolf entityWolf = (EntityWolf)p_70878_1_;
/* 427 */     if (!entityWolf.func_70909_n()) return false; 
/* 428 */     if (entityWolf.func_70906_o()) return false;
/*     */     
/* 430 */     return (func_70880_s() && entityWolf.func_70880_s());
/*     */   }
/*     */   
/*     */   public boolean func_70922_bv() {
/* 434 */     return (this.field_70180_af.func_75683_a(19) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 439 */     return (!func_70909_n() && this.field_70173_aa > 2400);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
/* 445 */     if (p_142018_1_ instanceof net.minecraft.entity.monster.EntityCreeper || p_142018_1_ instanceof net.minecraft.entity.monster.EntityGhast) {
/* 446 */       return false;
/*     */     }
/*     */     
/* 449 */     if (p_142018_1_ instanceof EntityWolf) {
/* 450 */       EntityWolf entityWolf = (EntityWolf)p_142018_1_;
/* 451 */       if (entityWolf.func_70909_n() && entityWolf.func_70902_q() == p_142018_2_) {
/* 452 */         return false;
/*     */       }
/*     */     } 
/* 455 */     if (p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).func_96122_a((EntityPlayer)p_142018_1_))
/*     */     {
/* 457 */       return false;
/*     */     }
/*     */     
/* 460 */     if (p_142018_1_ instanceof EntityHorse && ((EntityHorse)p_142018_1_).func_110248_bS()) {
/* 461 */       return false;
/*     */     }
/* 463 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityWolf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */