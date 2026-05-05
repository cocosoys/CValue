/*     */ package net.minecraft.entity.ai;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityOwnable;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.pathfinding.PathPoint;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class EntityAITarget
/*     */   extends EntityAIBase
/*     */ {
/*     */   protected EntityCreature field_75299_d;
/*     */   protected boolean field_75297_f;
/*     */   private boolean field_75303_a;
/*     */   private int field_75301_b;
/*     */   private int field_75302_c;
/*     */   private int field_75298_g;
/*     */   private static final String __OBFID = "CL_00001626";
/*     */   
/*     */   public EntityAITarget(EntityCreature p_i1669_1_, boolean p_i1669_2_) {
/*  30 */     this(p_i1669_1_, p_i1669_2_, false);
/*     */   }
/*     */   
/*     */   public EntityAITarget(EntityCreature p_i1670_1_, boolean p_i1670_2_, boolean p_i1670_3_) {
/*  34 */     this.field_75299_d = p_i1670_1_;
/*  35 */     this.field_75297_f = p_i1670_2_;
/*  36 */     this.field_75303_a = p_i1670_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  41 */     EntityLivingBase entityLivingBase = this.field_75299_d.func_70638_az();
/*  42 */     if (entityLivingBase == null) return false; 
/*  43 */     if (!entityLivingBase.func_70089_S()) return false;
/*     */     
/*  45 */     double d = func_111175_f();
/*  46 */     if (this.field_75299_d.func_70068_e((Entity)entityLivingBase) > d * d) return false; 
/*  47 */     if (this.field_75297_f) {
/*  48 */       if (this.field_75299_d.func_70635_at().func_75522_a((Entity)entityLivingBase))
/*  49 */       { this.field_75298_g = 0; }
/*     */       
/*  51 */       else if (++this.field_75298_g > 60) { return false; }
/*     */     
/*     */     }
/*  54 */     if (entityLivingBase instanceof EntityPlayerMP && 
/*  55 */       ((EntityPlayerMP)entityLivingBase).field_71134_c.func_73083_d()) {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   protected double func_111175_f() {
/*  63 */     IAttributeInstance iAttributeInstance = this.field_75299_d.func_110148_a(SharedMonsterAttributes.field_111265_b);
/*  64 */     return (iAttributeInstance == null) ? 16.0D : iAttributeInstance.func_111126_e();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/*  69 */     this.field_75301_b = 0;
/*  70 */     this.field_75302_c = 0;
/*  71 */     this.field_75298_g = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  76 */     this.field_75299_d.func_70624_b(null);
/*     */   }
/*     */   
/*     */   protected boolean func_75296_a(EntityLivingBase p_75296_1_, boolean p_75296_2_) {
/*  80 */     if (p_75296_1_ == null) return false; 
/*  81 */     if (p_75296_1_ == this.field_75299_d) return false; 
/*  82 */     if (!p_75296_1_.func_70089_S()) return false; 
/*  83 */     if (!this.field_75299_d.func_70686_a(p_75296_1_.getClass())) return false;
/*     */     
/*  85 */     if (this.field_75299_d instanceof IEntityOwnable && StringUtils.isNotEmpty(((IEntityOwnable)this.field_75299_d).func_152113_b()))
/*  86 */     { if (p_75296_1_ instanceof IEntityOwnable && ((IEntityOwnable)this.field_75299_d).func_152113_b().equals(((IEntityOwnable)p_75296_1_).func_152113_b()))
/*     */       {
/*  88 */         return false;
/*     */       }
/*     */       
/*  91 */       if (p_75296_1_ == ((IEntityOwnable)this.field_75299_d).func_70902_q())
/*     */       {
/*  93 */         return false;
/*     */       } }
/*  95 */     else if (p_75296_1_ instanceof EntityPlayer && 
/*  96 */       !p_75296_2_ && ((EntityPlayer)p_75296_1_).field_71075_bZ.field_75102_a) { return false; }
/*     */ 
/*     */     
/*  99 */     if (!this.field_75299_d.func_110176_b(MathHelper.func_76128_c(p_75296_1_.field_70165_t), MathHelper.func_76128_c(p_75296_1_.field_70163_u), MathHelper.func_76128_c(p_75296_1_.field_70161_v))) return false;
/*     */     
/* 101 */     if (this.field_75297_f && !this.field_75299_d.func_70635_at().func_75522_a((Entity)p_75296_1_)) return false;
/*     */     
/* 103 */     if (this.field_75303_a) {
/* 104 */       if (--this.field_75302_c <= 0) this.field_75301_b = 0; 
/* 105 */       if (this.field_75301_b == 0) this.field_75301_b = func_75295_a(p_75296_1_) ? 1 : 2; 
/* 106 */       if (this.field_75301_b == 2) return false;
/*     */     
/*     */     } 
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private boolean func_75295_a(EntityLivingBase p_75295_1_) {
/* 113 */     this.field_75302_c = 10 + this.field_75299_d.func_70681_au().nextInt(5);
/* 114 */     PathEntity pathEntity = this.field_75299_d.func_70661_as().func_75494_a((Entity)p_75295_1_);
/* 115 */     if (pathEntity == null) return false; 
/* 116 */     PathPoint pathPoint = pathEntity.func_75870_c();
/* 117 */     if (pathPoint == null) return false; 
/* 118 */     int i = pathPoint.field_75839_a - MathHelper.func_76128_c(p_75295_1_.field_70165_t);
/* 119 */     int j = pathPoint.field_75838_c - MathHelper.func_76128_c(p_75295_1_.field_70161_v);
/* 120 */     return ((i * i + j * j) <= 2.25D);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAITarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */