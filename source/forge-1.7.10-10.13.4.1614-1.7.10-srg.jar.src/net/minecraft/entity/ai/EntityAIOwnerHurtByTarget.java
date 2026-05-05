/*    */ package net.minecraft.entity.ai;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ 
/*    */ public class EntityAIOwnerHurtByTarget extends EntityAITarget {
/*    */   EntityTameable field_75316_a;
/*    */   EntityLivingBase field_75315_b;
/*    */   
/*    */   public EntityAIOwnerHurtByTarget(EntityTameable p_i1667_1_) {
/* 11 */     super((EntityCreature)p_i1667_1_, false);
/* 12 */     this.field_75316_a = p_i1667_1_;
/* 13 */     func_75248_a(1);
/*    */   }
/*    */   private int field_142051_e; private static final String __OBFID = "CL_00001624";
/*    */   
/*    */   public boolean func_75250_a() {
/* 18 */     if (!this.field_75316_a.func_70909_n()) return false; 
/* 19 */     EntityLivingBase entityLivingBase = this.field_75316_a.func_70902_q();
/* 20 */     if (entityLivingBase == null) return false; 
/* 21 */     this.field_75315_b = entityLivingBase.func_70643_av();
/* 22 */     int i = entityLivingBase.func_142015_aE();
/* 23 */     return (i != this.field_142051_e && func_75296_a(this.field_75315_b, false) && this.field_75316_a.func_142018_a(this.field_75315_b, entityLivingBase));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 28 */     this.field_75299_d.func_70624_b(this.field_75315_b);
/*    */     
/* 30 */     EntityLivingBase entityLivingBase = this.field_75316_a.func_70902_q();
/* 31 */     if (entityLivingBase != null) {
/* 32 */       this.field_142051_e = entityLivingBase.func_142015_aE();
/*    */     }
/*    */     
/* 35 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIOwnerHurtByTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */