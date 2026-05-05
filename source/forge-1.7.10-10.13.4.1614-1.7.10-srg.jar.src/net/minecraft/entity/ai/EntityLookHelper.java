/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class EntityLookHelper {
/*    */   private EntityLiving field_75659_a;
/*    */   private float field_75657_b;
/*    */   private float field_75658_c;
/*    */   private boolean field_75655_d;
/*    */   
/*    */   public EntityLookHelper(EntityLiving p_i1613_1_) {
/* 14 */     this.field_75659_a = p_i1613_1_;
/*    */   }
/*    */   private double field_75656_e; private double field_75653_f; private double field_75654_g; private static final String __OBFID = "CL_00001572";
/*    */   public void func_75651_a(Entity p_75651_1_, float p_75651_2_, float p_75651_3_) {
/* 18 */     this.field_75656_e = p_75651_1_.field_70165_t;
/* 19 */     if (p_75651_1_ instanceof net.minecraft.entity.EntityLivingBase) { this.field_75653_f = p_75651_1_.field_70163_u + p_75651_1_.func_70047_e(); }
/* 20 */     else { this.field_75653_f = (p_75651_1_.field_70121_D.field_72338_b + p_75651_1_.field_70121_D.field_72337_e) / 2.0D; }
/* 21 */      this.field_75654_g = p_75651_1_.field_70161_v;
/* 22 */     this.field_75657_b = p_75651_2_;
/* 23 */     this.field_75658_c = p_75651_3_;
/* 24 */     this.field_75655_d = true;
/*    */   }
/*    */   
/*    */   public void func_75650_a(double p_75650_1_, double p_75650_3_, double p_75650_5_, float p_75650_7_, float p_75650_8_) {
/* 28 */     this.field_75656_e = p_75650_1_;
/* 29 */     this.field_75653_f = p_75650_3_;
/* 30 */     this.field_75654_g = p_75650_5_;
/* 31 */     this.field_75657_b = p_75650_7_;
/* 32 */     this.field_75658_c = p_75650_8_;
/* 33 */     this.field_75655_d = true;
/*    */   }
/*    */   
/*    */   public void func_75649_a() {
/* 37 */     this.field_75659_a.field_70125_A = 0.0F;
/*    */     
/* 39 */     if (this.field_75655_d) {
/* 40 */       this.field_75655_d = false;
/*    */       
/* 42 */       double d1 = this.field_75656_e - this.field_75659_a.field_70165_t;
/* 43 */       double d2 = this.field_75653_f - this.field_75659_a.field_70163_u + this.field_75659_a.func_70047_e();
/* 44 */       double d3 = this.field_75654_g - this.field_75659_a.field_70161_v;
/* 45 */       double d4 = MathHelper.func_76133_a(d1 * d1 + d3 * d3);
/*    */       
/* 47 */       float f1 = (float)(Math.atan2(d3, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
/* 48 */       float f2 = (float)-(Math.atan2(d2, d4) * 180.0D / 3.1415927410125732D);
/* 49 */       this.field_75659_a.field_70125_A = func_75652_a(this.field_75659_a.field_70125_A, f2, this.field_75658_c);
/* 50 */       this.field_75659_a.field_70759_as = func_75652_a(this.field_75659_a.field_70759_as, f1, this.field_75657_b);
/*    */     } else {
/* 52 */       this.field_75659_a.field_70759_as = func_75652_a(this.field_75659_a.field_70759_as, this.field_75659_a.field_70761_aq, 10.0F);
/*    */     } 
/*    */     
/* 55 */     float f = MathHelper.func_76142_g(this.field_75659_a.field_70759_as - this.field_75659_a.field_70761_aq);
/*    */     
/* 57 */     if (!this.field_75659_a.func_70661_as().func_75500_f()) {
/*    */       
/* 59 */       if (f < -75.0F) this.field_75659_a.field_70759_as = this.field_75659_a.field_70761_aq - 75.0F; 
/* 60 */       if (f > 75.0F) this.field_75659_a.field_70759_as = this.field_75659_a.field_70761_aq + 75.0F; 
/*    */     } 
/*    */   }
/*    */   
/*    */   private float func_75652_a(float p_75652_1_, float p_75652_2_, float p_75652_3_) {
/* 65 */     float f = MathHelper.func_76142_g(p_75652_2_ - p_75652_1_);
/* 66 */     if (f > p_75652_3_) {
/* 67 */       f = p_75652_3_;
/*    */     }
/* 69 */     if (f < -p_75652_3_) {
/* 70 */       f = -p_75652_3_;
/*    */     }
/* 72 */     return p_75652_1_ + f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityLookHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */