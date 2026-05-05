/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class EntityAIMoveTowardsTarget
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityCreature field_75431_a;
/*    */   private EntityLivingBase field_75429_b;
/*    */   private double field_75430_c;
/*    */   private double field_75427_d;
/*    */   
/*    */   public EntityAIMoveTowardsTarget(EntityCreature p_i1640_1_, double p_i1640_2_, float p_i1640_4_) {
/* 17 */     this.field_75431_a = p_i1640_1_;
/* 18 */     this.field_75425_f = p_i1640_2_;
/* 19 */     this.field_75426_g = p_i1640_4_;
/* 20 */     func_75248_a(1);
/*    */   }
/*    */   private double field_75428_e; private double field_75425_f; private float field_75426_g; private static final String __OBFID = "CL_00001599";
/*    */   
/*    */   public boolean func_75250_a() {
/* 25 */     this.field_75429_b = this.field_75431_a.func_70638_az();
/* 26 */     if (this.field_75429_b == null) return false; 
/* 27 */     if (this.field_75429_b.func_70068_e((Entity)this.field_75431_a) > (this.field_75426_g * this.field_75426_g)) return false; 
/* 28 */     Vec3 vec3 = RandomPositionGenerator.func_75464_a(this.field_75431_a, 16, 7, Vec3.func_72443_a(this.field_75429_b.field_70165_t, this.field_75429_b.field_70163_u, this.field_75429_b.field_70161_v));
/* 29 */     if (vec3 == null) return false; 
/* 30 */     this.field_75430_c = vec3.field_72450_a;
/* 31 */     this.field_75427_d = vec3.field_72448_b;
/* 32 */     this.field_75428_e = vec3.field_72449_c;
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 38 */     return (!this.field_75431_a.func_70661_as().func_75500_f() && this.field_75429_b.func_70089_S() && this.field_75429_b.func_70068_e((Entity)this.field_75431_a) < (this.field_75426_g * this.field_75426_g));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 43 */     this.field_75429_b = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 48 */     this.field_75431_a.func_70661_as().func_75492_a(this.field_75430_c, this.field_75427_d, this.field_75428_e, this.field_75425_f);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIMoveTowardsTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */