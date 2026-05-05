/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.IRangedAttackMob;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class EntityAIArrowAttack
/*    */   extends EntityAIBase {
/*    */   private final EntityLiving field_75322_b;
/* 12 */   private int field_75320_d = -1; private final IRangedAttackMob field_82641_b; private EntityLivingBase field_75323_c; private double field_75321_e;
/*    */   private int field_75318_f;
/*    */   private int field_96561_g;
/*    */   private int field_75325_h;
/*    */   private float field_96562_i;
/*    */   private float field_82642_h;
/*    */   private static final String __OBFID = "CL_00001609";
/*    */   
/*    */   public EntityAIArrowAttack(IRangedAttackMob p_i1649_1_, double p_i1649_2_, int p_i1649_4_, float p_i1649_5_) {
/* 21 */     this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_);
/*    */   }
/*    */   
/*    */   public EntityAIArrowAttack(IRangedAttackMob p_i1650_1_, double p_i1650_2_, int p_i1650_4_, int p_i1650_5_, float p_i1650_6_) {
/* 25 */     if (!(p_i1650_1_ instanceof EntityLivingBase)) {
/* 26 */       throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
/*    */     }
/* 28 */     this.field_82641_b = p_i1650_1_;
/* 29 */     this.field_75322_b = (EntityLiving)p_i1650_1_;
/* 30 */     this.field_75321_e = p_i1650_2_;
/* 31 */     this.field_96561_g = p_i1650_4_;
/* 32 */     this.field_75325_h = p_i1650_5_;
/* 33 */     this.field_96562_i = p_i1650_6_;
/* 34 */     this.field_82642_h = p_i1650_6_ * p_i1650_6_;
/* 35 */     func_75248_a(3);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 40 */     EntityLivingBase entityLivingBase = this.field_75322_b.func_70638_az();
/* 41 */     if (entityLivingBase == null) return false; 
/* 42 */     this.field_75323_c = entityLivingBase;
/* 43 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 48 */     return (func_75250_a() || !this.field_75322_b.func_70661_as().func_75500_f());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 53 */     this.field_75323_c = null;
/* 54 */     this.field_75318_f = 0;
/* 55 */     this.field_75320_d = -1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 60 */     double d = this.field_75322_b.func_70092_e(this.field_75323_c.field_70165_t, this.field_75323_c.field_70121_D.field_72338_b, this.field_75323_c.field_70161_v);
/* 61 */     boolean bool = this.field_75322_b.func_70635_at().func_75522_a((Entity)this.field_75323_c);
/*    */     
/* 63 */     if (bool) {
/* 64 */       this.field_75318_f++;
/*    */     } else {
/* 66 */       this.field_75318_f = 0;
/*    */     } 
/*    */     
/* 69 */     if (d > this.field_82642_h || this.field_75318_f < 20) {
/* 70 */       this.field_75322_b.func_70661_as().func_75497_a((Entity)this.field_75323_c, this.field_75321_e);
/*    */     } else {
/* 72 */       this.field_75322_b.func_70661_as().func_75499_g();
/*    */     } 
/*    */     
/* 75 */     this.field_75322_b.func_70671_ap().func_75651_a((Entity)this.field_75323_c, 30.0F, 30.0F);
/*    */     
/* 77 */     if (--this.field_75320_d == 0) {
/* 78 */       if (d > this.field_82642_h || !bool)
/*    */         return; 
/* 80 */       float f1 = MathHelper.func_76133_a(d) / this.field_96562_i;
/* 81 */       float f2 = f1;
/* 82 */       if (f2 < 0.1F) f2 = 0.1F; 
/* 83 */       if (f2 > 1.0F) f2 = 1.0F;
/*    */       
/* 85 */       this.field_82641_b.func_82196_d(this.field_75323_c, f2);
/* 86 */       this.field_75320_d = MathHelper.func_76141_d(f1 * (this.field_75325_h - this.field_96561_g) + this.field_96561_g);
/* 87 */     } else if (this.field_75320_d < 0) {
/* 88 */       float f = MathHelper.func_76133_a(d) / this.field_96562_i;
/* 89 */       this.field_75320_d = MathHelper.func_76141_d(f * (this.field_75325_h - this.field_96561_g) + this.field_96561_g);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIArrowAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */