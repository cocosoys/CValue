/*     */ package net.minecraft.entity.monster;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityPotion;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityWitch extends EntityMob implements IRangedAttackMob {
/*  23 */   private static final UUID field_110184_bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
/*  24 */   private static final AttributeModifier field_110185_bq = (new AttributeModifier(field_110184_bp, "Drinking speed penalty", -0.25D, 0)).func_111168_a(false);
/*     */ 
/*     */   
/*  27 */   private static final Item[] field_82199_d = new Item[] { Items.field_151114_aO, Items.field_151102_aT, Items.field_151137_ax, Items.field_151070_bp, Items.field_151069_bo, Items.field_151016_H, Items.field_151055_y, Items.field_151055_y };
/*     */   
/*     */   private int field_82200_e;
/*     */   
/*     */   private static final String __OBFID = "CL_00001701";
/*     */ 
/*     */   
/*     */   public EntityWitch(World p_i1744_1_) {
/*  35 */     super(p_i1744_1_);
/*     */     
/*  37 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  38 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
/*  39 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander(this, 1.0D));
/*  40 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  41 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  43 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget(this, false));
/*  44 */     this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  49 */     super.func_70088_a();
/*     */     
/*  51 */     func_70096_w().func_75682_a(21, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  56 */     return "mob.witch.idle";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  61 */     return "mob.witch.hurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  66 */     return "mob.witch.death";
/*     */   }
/*     */   
/*     */   public void func_82197_f(boolean p_82197_1_) {
/*  70 */     func_70096_w().func_75692_b(21, Byte.valueOf(p_82197_1_ ? 1 : 0));
/*     */   }
/*     */   
/*     */   public boolean func_82198_m() {
/*  74 */     return (func_70096_w().func_75683_a(21) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  79 */     super.func_110147_ax();
/*     */     
/*  81 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(26.0D);
/*  82 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  92 */     if (!this.field_70170_p.field_72995_K) {
/*  93 */       if (func_82198_m()) {
/*  94 */         if (this.field_82200_e-- <= 0) {
/*  95 */           func_82197_f(false);
/*  96 */           ItemStack itemStack = func_70694_bm();
/*  97 */           func_70062_b(0, null);
/*     */           
/*  99 */           if (itemStack != null && itemStack.func_77973_b() == Items.field_151068_bn) {
/* 100 */             List list = Items.field_151068_bn.func_77832_l(itemStack);
/* 101 */             if (list != null) {
/* 102 */               for (PotionEffect potionEffect : list) {
/* 103 */                 func_70690_d(new PotionEffect(potionEffect));
/*     */               }
/*     */             }
/*     */           } 
/*     */           
/* 108 */           func_110148_a(SharedMonsterAttributes.field_111263_d).func_111124_b(field_110185_bq);
/*     */         } 
/*     */       } else {
/* 111 */         short s = -1;
/*     */         
/* 113 */         if (this.field_70146_Z.nextFloat() < 0.15F && func_70055_a(Material.field_151586_h) && !func_70644_a(Potion.field_76427_o)) {
/* 114 */           s = 8237;
/* 115 */         } else if (this.field_70146_Z.nextFloat() < 0.15F && func_70027_ad() && !func_70644_a(Potion.field_76426_n)) {
/* 116 */           s = 16307;
/* 117 */         } else if (this.field_70146_Z.nextFloat() < 0.05F && func_110143_aJ() < func_110138_aP()) {
/* 118 */           s = 16341;
/* 119 */         } else if (this.field_70146_Z.nextFloat() < 0.25F && func_70638_az() != null && !func_70644_a(Potion.field_76424_c) && func_70638_az().func_70068_e((Entity)this) > 121.0D) {
/* 120 */           s = 16274;
/* 121 */         } else if (this.field_70146_Z.nextFloat() < 0.25F && func_70638_az() != null && !func_70644_a(Potion.field_76424_c) && func_70638_az().func_70068_e((Entity)this) > 121.0D) {
/* 122 */           s = 16274;
/*     */         } 
/*     */         
/* 125 */         if (s > -1) {
/* 126 */           func_70062_b(0, new ItemStack((Item)Items.field_151068_bn, 1, s));
/* 127 */           this.field_82200_e = func_70694_bm().func_77988_m();
/* 128 */           func_82197_f(true);
/* 129 */           IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/* 130 */           iAttributeInstance.func_111124_b(field_110185_bq);
/* 131 */           iAttributeInstance.func_111121_a(field_110185_bq);
/*     */         } 
/*     */       } 
/*     */       
/* 135 */       if (this.field_70146_Z.nextFloat() < 7.5E-4F) {
/* 136 */         this.field_70170_p.func_72960_a((Entity)this, (byte)15);
/*     */       }
/*     */     } 
/*     */     
/* 140 */     super.func_70636_d();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/* 145 */     if (p_70103_1_ == 15) {
/* 146 */       for (byte b = 0; b < this.field_70146_Z.nextInt(35) + 10; b++) {
/* 147 */         this.field_70170_p.func_72869_a("witchMagic", this.field_70165_t + this.field_70146_Z.nextGaussian() * 0.12999999523162842D, this.field_70121_D.field_72337_e + 0.5D + this.field_70146_Z.nextGaussian() * 0.12999999523162842D, this.field_70161_v + this.field_70146_Z.nextGaussian() * 0.12999999523162842D, 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */     } else {
/* 150 */       super.func_70103_a(p_70103_1_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70672_c(DamageSource p_70672_1_, float p_70672_2_) {
/* 156 */     p_70672_2_ = super.func_70672_c(p_70672_1_, p_70672_2_);
/*     */     
/* 158 */     if (p_70672_1_.func_76346_g() == this) p_70672_2_ = 0.0F; 
/* 159 */     if (p_70672_1_.func_82725_o()) p_70672_2_ = (float)(p_70672_2_ * 0.15D);
/*     */     
/* 161 */     return p_70672_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 166 */     int i = this.field_70146_Z.nextInt(3) + 1;
/* 167 */     for (byte b = 0; b < i; b++) {
/* 168 */       int j = this.field_70146_Z.nextInt(3);
/* 169 */       Item item = field_82199_d[this.field_70146_Z.nextInt(field_82199_d.length)];
/* 170 */       if (p_70628_2_ > 0) j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
/*     */       
/* 172 */       for (byte b1 = 0; b1 < j; b1++) {
/* 173 */         func_145779_a(item, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
/* 180 */     if (func_82198_m())
/*     */       return; 
/* 182 */     EntityPotion entityPotion = new EntityPotion(this.field_70170_p, (EntityLivingBase)this, 32732);
/* 183 */     entityPotion.field_70125_A -= -20.0F;
/* 184 */     double d1 = p_82196_1_.field_70165_t + p_82196_1_.field_70159_w - this.field_70165_t;
/* 185 */     double d2 = p_82196_1_.field_70163_u + p_82196_1_.func_70047_e() - 1.100000023841858D - this.field_70163_u;
/* 186 */     double d3 = p_82196_1_.field_70161_v + p_82196_1_.field_70179_y - this.field_70161_v;
/* 187 */     float f = MathHelper.func_76133_a(d1 * d1 + d3 * d3);
/*     */     
/* 189 */     if (f >= 8.0F && !p_82196_1_.func_70644_a(Potion.field_76421_d)) {
/* 190 */       entityPotion.func_82340_a(32698);
/* 191 */     } else if (p_82196_1_.func_110143_aJ() >= 8.0F && !p_82196_1_.func_70644_a(Potion.field_76436_u)) {
/* 192 */       entityPotion.func_82340_a(32660);
/* 193 */     } else if (f <= 3.0F && !p_82196_1_.func_70644_a(Potion.field_76437_t) && this.field_70146_Z.nextFloat() < 0.25F) {
/* 194 */       entityPotion.func_82340_a(32696);
/*     */     } 
/*     */     
/* 197 */     entityPotion.func_70186_c(d1, d2 + (f * 0.2F), d3, 0.75F, 8.0F);
/*     */     
/* 199 */     this.field_70170_p.func_72838_d((Entity)entityPotion);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityWitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */