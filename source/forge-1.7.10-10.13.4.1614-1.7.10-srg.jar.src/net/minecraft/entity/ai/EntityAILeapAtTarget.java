/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class EntityAILeapAtTarget extends EntityAIBase {
/*    */   EntityLiving field_75328_a;
/*    */   EntityLivingBase field_75326_b;
/*    */   
/*    */   public EntityAILeapAtTarget(EntityLiving p_i1630_1_, float p_i1630_2_) {
/* 13 */     this.field_75328_a = p_i1630_1_;
/* 14 */     this.field_75327_c = p_i1630_2_;
/* 15 */     func_75248_a(5);
/*    */   }
/*    */   float field_75327_c; private static final String __OBFID = "CL_00001591";
/*    */   
/*    */   public boolean func_75250_a() {
/* 20 */     this.field_75326_b = this.field_75328_a.func_70638_az();
/* 21 */     if (this.field_75326_b == null) return false; 
/* 22 */     double d = this.field_75328_a.func_70068_e((Entity)this.field_75326_b);
/* 23 */     if (d < 4.0D || d > 16.0D) return false; 
/* 24 */     if (!this.field_75328_a.field_70122_E) return false; 
/* 25 */     if (this.field_75328_a.func_70681_au().nextInt(5) != 0) return false; 
/* 26 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 31 */     return !this.field_75328_a.field_70122_E;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 37 */     double d1 = this.field_75326_b.field_70165_t - this.field_75328_a.field_70165_t;
/* 38 */     double d2 = this.field_75326_b.field_70161_v - this.field_75328_a.field_70161_v;
/* 39 */     float f = MathHelper.func_76133_a(d1 * d1 + d2 * d2);
/* 40 */     this.field_75328_a.field_70159_w += d1 / f * 0.5D * 0.800000011920929D + this.field_75328_a.field_70159_w * 0.20000000298023224D;
/* 41 */     this.field_75328_a.field_70179_y += d2 / f * 0.5D * 0.800000011920929D + this.field_75328_a.field_70179_y * 0.20000000298023224D;
/* 42 */     this.field_75328_a.field_70181_x = this.field_75327_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAILeapAtTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */