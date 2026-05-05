/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ 
/*    */ public class EntityAIHurtByTarget extends EntityAITarget {
/*    */   boolean field_75312_a;
/*    */   private int field_142052_b;
/*    */   private static final String __OBFID = "CL_00001619";
/*    */   
/*    */   public EntityAIHurtByTarget(EntityCreature p_i1660_1_, boolean p_i1660_2_) {
/* 13 */     super(p_i1660_1_, false);
/* 14 */     this.field_75312_a = p_i1660_2_;
/* 15 */     func_75248_a(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 20 */     int i = this.field_75299_d.func_142015_aE();
/* 21 */     return (i != this.field_142052_b && func_75296_a(this.field_75299_d.func_70643_av(), false));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 26 */     this.field_75299_d.func_70624_b(this.field_75299_d.func_70643_av());
/* 27 */     this.field_142052_b = this.field_75299_d.func_142015_aE();
/*    */     
/* 29 */     if (this.field_75312_a) {
/* 30 */       double d = func_111175_f();
/* 31 */       List list = this.field_75299_d.field_70170_p.func_72872_a(this.field_75299_d.getClass(), AxisAlignedBB.func_72330_a(this.field_75299_d.field_70165_t, this.field_75299_d.field_70163_u, this.field_75299_d.field_70161_v, this.field_75299_d.field_70165_t + 1.0D, this.field_75299_d.field_70163_u + 1.0D, this.field_75299_d.field_70161_v + 1.0D).func_72314_b(d, 10.0D, d));
/* 32 */       for (EntityCreature entityCreature : list) {
/* 33 */         if (this.field_75299_d == entityCreature || 
/* 34 */           entityCreature.func_70638_az() != null || 
/* 35 */           entityCreature.func_142014_c(this.field_75299_d.func_70643_av()))
/* 36 */           continue;  entityCreature.func_70624_b(this.field_75299_d.func_70643_av());
/*    */       } 
/*    */     } 
/*    */     
/* 40 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIHurtByTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */