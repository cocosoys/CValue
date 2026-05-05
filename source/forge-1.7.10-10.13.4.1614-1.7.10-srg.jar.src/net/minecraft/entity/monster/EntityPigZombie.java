/*     */ package net.minecraft.entity.monster;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityPigZombie
/*     */   extends EntityZombie {
/*  20 */   private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
/*  21 */   private static final AttributeModifier field_110190_br = (new AttributeModifier(field_110189_bq, "Attacking speed boost", 0.45D, 0)).func_111168_a(false);
/*     */   private int field_70837_d;
/*     */   private int field_70838_e;
/*     */   private Entity field_110191_bu;
/*     */   private static final String __OBFID = "CL_00001693";
/*     */   
/*     */   public EntityPigZombie(World p_i1739_1_) {
/*  28 */     super(p_i1739_1_);
/*  29 */     this.field_70178_ae = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  34 */     super.func_110147_ax();
/*     */     
/*  36 */     func_110148_a(field_110186_bp).func_111128_a(0.0D);
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70650_aV() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  48 */     if (this.field_110191_bu != this.field_70789_a && !this.field_70170_p.field_72995_K) {
/*  49 */       IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/*  50 */       iAttributeInstance.func_111124_b(field_110190_br);
/*     */       
/*  52 */       if (this.field_70789_a != null) {
/*  53 */         iAttributeInstance.func_111121_a(field_110190_br);
/*     */       }
/*     */     } 
/*  56 */     this.field_110191_bu = this.field_70789_a;
/*     */     
/*  58 */     if (this.field_70838_e > 0 && 
/*  59 */       --this.field_70838_e == 0) {
/*  60 */       func_85030_a("mob.zombiepig.zpigangry", func_70599_aP() * 2.0F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) * 1.8F);
/*     */     }
/*     */     
/*  63 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  68 */     return (this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  73 */     super.func_70014_b(p_70014_1_);
/*  74 */     p_70014_1_.func_74777_a("Anger", (short)this.field_70837_d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  79 */     super.func_70037_a(p_70037_1_);
/*  80 */     this.field_70837_d = p_70037_1_.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/*  85 */     if (this.field_70837_d == 0) return null; 
/*  86 */     return super.func_70782_k();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  91 */     if (func_85032_ar()) return false; 
/*  92 */     Entity entity = p_70097_1_.func_76346_g();
/*  93 */     if (entity instanceof EntityPlayer) {
/*  94 */       List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*  95 */       for (byte b = 0; b < list.size(); b++) {
/*  96 */         Entity entity1 = list.get(b);
/*  97 */         if (entity1 instanceof EntityPigZombie) {
/*  98 */           EntityPigZombie entityPigZombie = (EntityPigZombie)entity1;
/*  99 */           entityPigZombie.func_70835_c(entity);
/*     */         } 
/*     */       } 
/* 102 */       func_70835_c(entity);
/*     */     } 
/* 104 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */   
/*     */   private void func_70835_c(Entity p_70835_1_) {
/* 108 */     this.field_70789_a = p_70835_1_;
/* 109 */     this.field_70837_d = 400 + this.field_70146_Z.nextInt(400);
/* 110 */     this.field_70838_e = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 115 */     return "mob.zombiepig.zpig";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 120 */     return "mob.zombiepig.zpighurt";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 125 */     return "mob.zombiepig.zpigdeath";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 130 */     int i = this.field_70146_Z.nextInt(2 + p_70628_2_); byte b;
/* 131 */     for (b = 0; b < i; b++) {
/* 132 */       func_145779_a(Items.field_151078_bh, 1);
/*     */     }
/* 134 */     i = this.field_70146_Z.nextInt(2 + p_70628_2_);
/* 135 */     for (b = 0; b < i; b++) {
/* 136 */       func_145779_a(Items.field_151074_bl, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 142 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70600_l(int p_70600_1_) {
/* 147 */     func_145779_a(Items.field_151043_k, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_82164_bB() {
/* 152 */     func_70062_b(0, new ItemStack(Items.field_151010_B));
/*     */   }
/*     */ 
/*     */   
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 157 */     super.func_110161_a(p_110161_1_);
/* 158 */     func_82229_g(false);
/* 159 */     return p_110161_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityPigZombie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */