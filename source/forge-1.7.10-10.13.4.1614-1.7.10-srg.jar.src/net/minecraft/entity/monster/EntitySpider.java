/*     */ package net.minecraft.entity.monster;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySpider extends EntityMob {
/*     */   public EntitySpider(World p_i1743_1_) {
/*  19 */     super(p_i1743_1_);
/*  20 */     func_70105_a(1.4F, 0.9F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  25 */     super.func_70088_a();
/*     */     
/*  27 */     this.field_70180_af.func_75682_a(16, new Byte((byte)0));
/*     */   }
/*     */   private static final String __OBFID = "CL_00001699";
/*     */   
/*     */   public void func_70071_h_() {
/*  32 */     super.func_70071_h_();
/*     */     
/*  34 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/*     */       
/*  37 */       func_70839_e(this.field_70123_F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  43 */     super.func_110147_ax();
/*     */     
/*  45 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(16.0D);
/*  46 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.800000011920929D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/*  51 */     float f = func_70013_c(1.0F);
/*  52 */     if (f < 0.5F) {
/*  53 */       double d = 16.0D;
/*  54 */       return (Entity)this.field_70170_p.func_72856_b((Entity)this, d);
/*     */     } 
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  61 */     return "mob.spider.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  66 */     return "mob.spider.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  71 */     return "mob.spider.death";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/*  76 */     func_85030_a("mob.spider.step", 0.15F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
/*  81 */     float f = func_70013_c(1.0F);
/*  82 */     if (f > 0.5F && this.field_70146_Z.nextInt(100) == 0) {
/*  83 */       this.field_70789_a = null;
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     if (p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.field_70146_Z.nextInt(10) == 0) {
/*  88 */       if (this.field_70122_E) {
/*  89 */         double d1 = p_70785_1_.field_70165_t - this.field_70165_t;
/*  90 */         double d2 = p_70785_1_.field_70161_v - this.field_70161_v;
/*  91 */         float f1 = MathHelper.func_76133_a(d1 * d1 + d2 * d2);
/*  92 */         this.field_70159_w = d1 / f1 * 0.5D * 0.800000011920929D + this.field_70159_w * 0.20000000298023224D;
/*  93 */         this.field_70179_y = d2 / f1 * 0.5D * 0.800000011920929D + this.field_70179_y * 0.20000000298023224D;
/*  94 */         this.field_70181_x = 0.4000000059604645D;
/*     */       } 
/*     */     } else {
/*  97 */       super.func_70785_a(p_70785_1_, p_70785_2_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 103 */     return Items.field_151007_F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 108 */     super.func_70628_a(p_70628_1_, p_70628_2_);
/*     */     
/* 110 */     if (p_70628_1_ && (this.field_70146_Z.nextInt(3) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0)) {
/* 111 */       func_145779_a(Items.field_151070_bp, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70617_f_() {
/* 121 */     return func_70841_p();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70110_aj() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumCreatureAttribute func_70668_bt() {
/* 131 */     return EnumCreatureAttribute.ARTHROPOD;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70687_e(PotionEffect p_70687_1_) {
/* 136 */     if (p_70687_1_.func_76456_a() == Potion.field_76436_u.field_76415_H) {
/* 137 */       return false;
/*     */     }
/* 139 */     return super.func_70687_e(p_70687_1_);
/*     */   }
/*     */   
/*     */   public boolean func_70841_p() {
/* 143 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */   
/*     */   public void func_70839_e(boolean p_70839_1_) {
/* 147 */     byte b = this.field_70180_af.func_75683_a(16);
/* 148 */     if (p_70839_1_) {
/* 149 */       b = (byte)(b | 0x1);
/*     */     } else {
/* 151 */       b = (byte)(b & 0xFFFFFFFE);
/*     */     } 
/* 153 */     this.field_70180_af.func_75692_b(16, Byte.valueOf(b));
/*     */   }
/*     */ 
/*     */   
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 158 */     p_110161_1_ = super.func_110161_a(p_110161_1_);
/*     */     
/* 160 */     if (this.field_70170_p.field_73012_v.nextInt(100) == 0) {
/* 161 */       EntitySkeleton entitySkeleton = new EntitySkeleton(this.field_70170_p);
/* 162 */       entitySkeleton.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
/* 163 */       entitySkeleton.func_110161_a((IEntityLivingData)null);
/* 164 */       this.field_70170_p.func_72838_d((Entity)entitySkeleton);
/* 165 */       entitySkeleton.func_70078_a((Entity)this);
/*     */     } 
/*     */     
/* 168 */     if (p_110161_1_ == null) {
/* 169 */       p_110161_1_ = new GroupData();
/*     */       
/* 171 */       if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD && this.field_70170_p.field_73012_v.nextFloat() < 0.1F * this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v)) {
/* 172 */         ((GroupData)p_110161_1_).func_111104_a(this.field_70170_p.field_73012_v);
/*     */       }
/*     */     } 
/* 175 */     if (p_110161_1_ instanceof GroupData) {
/* 176 */       int i = ((GroupData)p_110161_1_).field_111105_a;
/* 177 */       if (i > 0 && Potion.field_76425_a[i] != null) {
/* 178 */         func_70690_d(new PotionEffect(i, 2147483647));
/*     */       }
/*     */     } 
/*     */     
/* 182 */     return p_110161_1_;
/*     */   }
/*     */   
/*     */   public static class GroupData
/*     */     implements IEntityLivingData {
/*     */     public int field_111105_a;
/*     */     private static final String __OBFID = "CL_00001700";
/*     */     
/*     */     public void func_111104_a(Random p_111104_1_) {
/* 191 */       int i = p_111104_1_.nextInt(5);
/* 192 */       if (i <= 1) {
/* 193 */         this.field_111105_a = Potion.field_76424_c.field_76415_H;
/* 194 */       } else if (i <= 2) {
/* 195 */         this.field_111105_a = Potion.field_76420_g.field_76415_H;
/* 196 */       } else if (i <= 3) {
/* 197 */         this.field_111105_a = Potion.field_76428_l.field_76415_H;
/* 198 */       } else if (i <= 4) {
/* 199 */         this.field_111105_a = Potion.field_76441_p.field_76415_H;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntitySpider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */