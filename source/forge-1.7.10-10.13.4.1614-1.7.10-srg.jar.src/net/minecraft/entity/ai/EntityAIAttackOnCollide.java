/*     */ package net.minecraft.entity.ai;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityAIAttackOnCollide
/*     */   extends EntityAIBase
/*     */ {
/*     */   World field_75443_a;
/*     */   EntityCreature field_75441_b;
/*     */   int field_75439_d;
/*     */   double field_75440_e;
/*     */   boolean field_75437_f;
/*     */   PathEntity field_75438_g;
/*     */   
/*     */   public EntityAIAttackOnCollide(EntityCreature p_i1635_1_, Class p_i1635_2_, double p_i1635_3_, boolean p_i1635_5_) {
/*  23 */     this(p_i1635_1_, p_i1635_3_, p_i1635_5_);
/*  24 */     this.field_75444_h = p_i1635_2_;
/*     */   }
/*     */   Class field_75444_h; private int field_75445_i; private double field_151497_i; private double field_151495_j; private double field_151496_k; private static final String __OBFID = "CL_00001595";
/*     */   public EntityAIAttackOnCollide(EntityCreature p_i1636_1_, double p_i1636_2_, boolean p_i1636_4_) {
/*  28 */     this.field_75441_b = p_i1636_1_;
/*  29 */     this.field_75443_a = p_i1636_1_.field_70170_p;
/*  30 */     this.field_75440_e = p_i1636_2_;
/*  31 */     this.field_75437_f = p_i1636_4_;
/*  32 */     func_75248_a(3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  37 */     EntityLivingBase entityLivingBase = this.field_75441_b.func_70638_az();
/*  38 */     if (entityLivingBase == null) return false; 
/*  39 */     if (!entityLivingBase.func_70089_S()) return false; 
/*  40 */     if (this.field_75444_h != null && !this.field_75444_h.isAssignableFrom(entityLivingBase.getClass())) return false; 
/*  41 */     this.field_75438_g = this.field_75441_b.func_70661_as().func_75494_a((Entity)entityLivingBase);
/*  42 */     return (this.field_75438_g != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  47 */     EntityLivingBase entityLivingBase = this.field_75441_b.func_70638_az();
/*  48 */     if (entityLivingBase == null) return false; 
/*  49 */     if (!entityLivingBase.func_70089_S()) return false; 
/*  50 */     if (!this.field_75437_f) return !this.field_75441_b.func_70661_as().func_75500_f(); 
/*  51 */     if (!this.field_75441_b.func_110176_b(MathHelper.func_76128_c(entityLivingBase.field_70165_t), MathHelper.func_76128_c(entityLivingBase.field_70163_u), MathHelper.func_76128_c(entityLivingBase.field_70161_v))) return false; 
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/*  57 */     this.field_75441_b.func_70661_as().func_75484_a(this.field_75438_g, this.field_75440_e);
/*  58 */     this.field_75445_i = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  63 */     this.field_75441_b.func_70661_as().func_75499_g();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  68 */     EntityLivingBase entityLivingBase = this.field_75441_b.func_70638_az();
/*  69 */     this.field_75441_b.func_70671_ap().func_75651_a((Entity)entityLivingBase, 30.0F, 30.0F);
/*  70 */     double d1 = this.field_75441_b.func_70092_e(entityLivingBase.field_70165_t, entityLivingBase.field_70121_D.field_72338_b, entityLivingBase.field_70161_v);
/*  71 */     double d2 = (this.field_75441_b.field_70130_N * 2.0F * this.field_75441_b.field_70130_N * 2.0F + entityLivingBase.field_70130_N);
/*  72 */     this.field_75445_i--;
/*     */     
/*  74 */     if ((this.field_75437_f || this.field_75441_b.func_70635_at().func_75522_a((Entity)entityLivingBase)) && 
/*  75 */       this.field_75445_i <= 0 && ((
/*  76 */       this.field_151497_i == 0.0D && this.field_151495_j == 0.0D && this.field_151496_k == 0.0D) || entityLivingBase.func_70092_e(this.field_151497_i, this.field_151495_j, this.field_151496_k) >= 1.0D || this.field_75441_b.func_70681_au().nextFloat() < 0.05F)) {
/*  77 */       this.field_151497_i = entityLivingBase.field_70165_t;
/*  78 */       this.field_151495_j = entityLivingBase.field_70121_D.field_72338_b;
/*  79 */       this.field_151496_k = entityLivingBase.field_70161_v;
/*  80 */       this.field_75445_i = 4 + this.field_75441_b.func_70681_au().nextInt(7);
/*     */       
/*  82 */       if (d1 > 1024.0D) {
/*  83 */         this.field_75445_i += 10;
/*  84 */       } else if (d1 > 256.0D) {
/*  85 */         this.field_75445_i += 5;
/*     */       } 
/*     */       
/*  88 */       if (!this.field_75441_b.func_70661_as().func_75497_a((Entity)entityLivingBase, this.field_75440_e)) {
/*  89 */         this.field_75445_i += 15;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  95 */     this.field_75439_d = Math.max(this.field_75439_d - 1, 0);
/*     */     
/*  97 */     if (d1 <= d2 && this.field_75439_d <= 20) {
/*  98 */       this.field_75439_d = 20;
/*  99 */       if (this.field_75441_b.func_70694_bm() != null) this.field_75441_b.func_71038_i(); 
/* 100 */       this.field_75441_b.func_70652_k((Entity)entityLivingBase);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIAttackOnCollide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */