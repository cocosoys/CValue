/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.FamilyC.EntityNPC;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class AIFollowOwner
/*     */   extends EntityAIBase {
/*     */   private EntityNPC thePet;
/*     */   private EntityLivingBase mom;
/*     */   private EntityLivingBase dad;
/*     */   private EntityLivingBase theOwner;
/*     */   World theWorld;
/*     */   private double field_75336_f;
/*     */   private PathNavigate petPathfinder;
/*     */   private int field_75343_h;
/*     */   float maxDist;
/*     */   float minDist;
/*     */   private boolean field_75344_i;
/*     */   
/*     */   public AIFollowOwner(EntityNPC par1EntityTameable, double par2, float par4, float par5) {
/*  28 */     this.thePet = par1EntityTameable;
/*  29 */     this.theWorld = par1EntityTameable.field_70170_p;
/*  30 */     this.field_75336_f = par2;
/*  31 */     this.petPathfinder = par1EntityTameable.func_70661_as();
/*  32 */     this.minDist = par4;
/*  33 */     this.maxDist = par5;
/*  34 */     func_75248_a(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*     */     EntityLivingBase entityLivingBase;
/*  42 */     EntityPlayer entityPlayer1 = this.thePet.field_70170_p.func_72924_a(this.thePet.getDad());
/*  43 */     EntityPlayer entityPlayer2 = this.thePet.field_70170_p.func_72924_a(this.thePet.getMom());
/*  44 */     Entity flwtrgt = this.thePet.field_70170_p.func_73045_a(this.thePet.getFollowTarget());
/*  45 */     int flw = this.thePet.getFollow();
/*     */     
/*  47 */     if (flw == 2 && entityPlayer2 != null) entityPlayer1 = entityPlayer2; 
/*  48 */     if (flw == 3 && flwtrgt != null && flwtrgt instanceof EntityPlayer) entityLivingBase = (EntityLivingBase)flwtrgt;
/*     */     
/*  50 */     if (entityLivingBase == null) { this.thePet.setFollow(0); return false; }
/*  51 */      if (this.thePet.stopMoving()) return false; 
/*  52 */     if (this.thePet.func_70068_e((Entity)entityLivingBase) < (this.minDist * this.minDist)) return false; 
/*  53 */     this.theOwner = entityLivingBase; return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  61 */     return (!this.petPathfinder.func_75500_f() && this.thePet.func_70068_e((Entity)this.theOwner) > (this.maxDist * this.maxDist) && !this.thePet.stopMoving());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/*  69 */     this.field_75343_h = 0;
/*  70 */     this.field_75344_i = this.thePet.func_70661_as().func_75486_a();
/*  71 */     this.thePet.func_70661_as().func_75491_a(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  79 */     this.theOwner = null;
/*  80 */     this.petPathfinder.func_75499_g();
/*  81 */     this.thePet.func_70661_as().func_75491_a(this.field_75344_i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  89 */     this.thePet.func_70671_ap().func_75651_a((Entity)this.theOwner, 10.0F, this.thePet.func_70646_bf());
/*     */     
/*  91 */     if (!this.thePet.stopMoving())
/*     */     {
/*  93 */       if (--this.field_75343_h <= 0) {
/*     */         
/*  95 */         this.field_75343_h = 10;
/*     */         
/*  97 */         if (!this.petPathfinder.func_75497_a((Entity)this.theOwner, this.field_75336_f))
/*     */         {
/*  99 */           if (!this.thePet.func_110167_bD())
/*     */           {
/* 101 */             if (this.thePet.func_70068_e((Entity)this.theOwner) >= 144.0D) {
/*     */               
/* 103 */               int i = MathHelper.func_76128_c(this.theOwner.field_70165_t) - 2;
/* 104 */               int j = MathHelper.func_76128_c(this.theOwner.field_70161_v) - 2;
/* 105 */               int k = MathHelper.func_76128_c(this.theOwner.field_70121_D.field_72338_b);
/*     */               
/* 107 */               for (int l = 0; l <= 4; l++) {
/*     */                 
/* 109 */                 for (int i1 = 0; i1 <= 4; i1++) {
/*     */                   
/* 111 */                   if (l < 1 || i1 < 1 || l > 3 || i1 > 3) if (World.func_147466_a((IBlockAccess)this.theWorld, i + l, k - 1, j + i1) && !this.theWorld.func_147445_c(i + l, k, j + i1, false) && !this.theWorld.func_147445_c(i + l, k + 1, j + i1, false)) {
/*     */                       
/* 113 */                       this.thePet.func_70012_b(((i + l) + 0.5F), k, ((j + i1) + 0.5F), this.thePet.field_70177_z, this.thePet.field_70125_A);
/* 114 */                       this.petPathfinder.func_75499_g();
/*     */                       return;
/*     */                     }  
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\AIFollowOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */