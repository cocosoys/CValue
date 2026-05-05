/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityOwnable;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.pathfinding.PathPoint;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AITarget
/*     */   extends EntityAIBase
/*     */ {
/*     */   protected EntityCreature taskOwner;
/*     */   protected boolean shouldCheckSight;
/*     */   private boolean nearbyOnly;
/*     */   private int targetSearchStatus;
/*     */   private int targetSearchDelay;
/*     */   private int field_75298_g;
/*     */   
/*     */   public AITarget(EntityCreature par1EntityCreature, boolean par2) {
/*  44 */     this(par1EntityCreature, par2, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public AITarget(EntityCreature par1EntityCreature, boolean par2, boolean par3) {
/*  49 */     this.taskOwner = par1EntityCreature;
/*  50 */     this.shouldCheckSight = par2;
/*  51 */     this.nearbyOnly = par3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  59 */     EntityLivingBase entitylivingbase = this.taskOwner.func_70638_az();
/*     */     
/*  61 */     if (entitylivingbase == null)
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     if (!entitylivingbase.func_70089_S())
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  71 */     double d0 = getTargetDistance();
/*     */     
/*  73 */     if (this.taskOwner.func_70068_e((Entity)entitylivingbase) > d0 * d0)
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  79 */     if (this.shouldCheckSight)
/*     */     {
/*  81 */       if (this.taskOwner.func_70635_at().func_75522_a((Entity)entitylivingbase)) {
/*     */         
/*  83 */         this.field_75298_g = 0;
/*     */       }
/*  85 */       else if (++this.field_75298_g > 60) {
/*     */         
/*  87 */         return false;
/*     */       } 
/*     */     }
/*     */     
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getTargetDistance() {
/*  98 */     IAttributeInstance attributeinstance = this.taskOwner.func_110148_a(SharedMonsterAttributes.field_111265_b);
/*  99 */     return (attributeinstance == null) ? 16.0D : attributeinstance.func_111126_e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/* 107 */     this.targetSearchStatus = 0;
/* 108 */     this.targetSearchDelay = 0;
/* 109 */     this.field_75298_g = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/* 117 */     this.taskOwner.func_70624_b((EntityLivingBase)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSuitableTarget(EntityLivingBase par1EntityLivingBase, boolean par2) {
/* 125 */     if (par1EntityLivingBase == null)
/*     */     {
/* 127 */       return false;
/*     */     }
/* 129 */     if (par1EntityLivingBase == this.taskOwner)
/*     */     {
/* 131 */       return false;
/*     */     }
/* 133 */     if (!par1EntityLivingBase.func_70089_S())
/*     */     {
/* 135 */       return false;
/*     */     }
/* 137 */     if (!this.taskOwner.func_70686_a(par1EntityLivingBase.getClass()))
/*     */     {
/* 139 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 143 */     if (this.taskOwner instanceof IEntityOwnable && StringUtils.isNotEmpty(((IEntityOwnable)this.taskOwner).func_152113_b())) {
/*     */       
/* 145 */       if (par1EntityLivingBase instanceof IEntityOwnable && ((IEntityOwnable)this.taskOwner).func_152113_b().equals(((IEntityOwnable)par1EntityLivingBase).func_152113_b()))
/*     */       {
/* 147 */         return false;
/*     */       }
/*     */       
/* 150 */       if (par1EntityLivingBase == ((IEntityOwnable)this.taskOwner).func_70902_q())
/*     */       {
/* 152 */         return false;
/*     */       }
/*     */     }
/* 155 */     else if (par1EntityLivingBase instanceof EntityPlayer && !par2 && ((EntityPlayer)par1EntityLivingBase).field_71075_bZ.field_75102_a) {
/*     */       
/* 157 */       return false;
/*     */     } 
/*     */     
/* 160 */     if (!this.taskOwner.func_110176_b(MathHelper.func_76128_c(par1EntityLivingBase.field_70165_t), MathHelper.func_76128_c(par1EntityLivingBase.field_70163_u), MathHelper.func_76128_c(par1EntityLivingBase.field_70161_v)))
/*     */     {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this.shouldCheckSight && !this.taskOwner.func_70635_at().func_75522_a((Entity)par1EntityLivingBase))
/*     */     {
/* 166 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 170 */     if (this.nearbyOnly) {
/*     */       
/* 172 */       if (--this.targetSearchDelay <= 0)
/*     */       {
/* 174 */         this.targetSearchStatus = 0;
/*     */       }
/*     */       
/* 177 */       if (this.targetSearchStatus == 0)
/*     */       {
/* 179 */         this.targetSearchStatus = canEasilyReach(par1EntityLivingBase) ? 1 : 2;
/*     */       }
/*     */       
/* 182 */       if (this.targetSearchStatus == 2)
/*     */       {
/* 184 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canEasilyReach(EntityLivingBase par1EntityLivingBase) {
/* 198 */     this.targetSearchDelay = 10 + this.taskOwner.func_70681_au().nextInt(5);
/* 199 */     PathEntity pathentity = this.taskOwner.func_70661_as().func_75494_a((Entity)par1EntityLivingBase);
/*     */     
/* 201 */     if (pathentity == null)
/*     */     {
/* 203 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 207 */     PathPoint pathpoint = pathentity.func_75870_c();
/*     */     
/* 209 */     if (pathpoint == null)
/*     */     {
/* 211 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 215 */     int i = pathpoint.field_75839_a - MathHelper.func_76128_c(par1EntityLivingBase.field_70165_t);
/* 216 */     int j = pathpoint.field_75838_c - MathHelper.func_76128_c(par1EntityLivingBase.field_70161_v);
/* 217 */     return ((i * i + j * j) <= 2.25D);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\AITarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */