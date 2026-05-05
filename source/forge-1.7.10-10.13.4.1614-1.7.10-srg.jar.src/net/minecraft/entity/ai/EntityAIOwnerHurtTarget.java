/*    */ package net.minecraft.entity.ai;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ 
/*    */ public class EntityAIOwnerHurtTarget extends EntityAITarget {
/*    */   EntityTameable field_75314_a;
/*    */   EntityLivingBase field_75313_b;
/*    */   
/*    */   public EntityAIOwnerHurtTarget(EntityTameable p_i1668_1_) {
/* 11 */     super((EntityCreature)p_i1668_1_, false);
/* 12 */     this.field_75314_a = p_i1668_1_;
/* 13 */     func_75248_a(1);
/*    */   }
/*    */   private int field_142050_e; private static final String __OBFID = "CL_00001625";
/*    */   
/*    */   public boolean func_75250_a() {
/* 18 */     if (!this.field_75314_a.func_70909_n()) return false; 
/* 19 */     EntityLivingBase entityLivingBase = this.field_75314_a.func_70902_q();
/* 20 */     if (entityLivingBase == null) return false; 
/* 21 */     this.field_75313_b = entityLivingBase.func_110144_aD();
/* 22 */     int i = entityLivingBase.func_142013_aG();
/* 23 */     return (i != this.field_142050_e && func_75296_a(this.field_75313_b, false) && this.field_75314_a.func_142018_a(this.field_75313_b, entityLivingBase));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 28 */     this.field_75299_d.func_70624_b(this.field_75313_b);
/*    */     
/* 30 */     EntityLivingBase entityLivingBase = this.field_75314_a.func_70902_q();
/* 31 */     if (entityLivingBase != null) {
/* 32 */       this.field_142050_e = entityLivingBase.func_142013_aG();
/*    */     }
/*    */     
/* 35 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIOwnerHurtTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */