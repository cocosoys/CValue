/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityMoveHelper
/*    */ {
/*    */   private EntityLiving field_75648_a;
/*    */   private double field_75646_b;
/*    */   private double field_75647_c;
/*    */   private double field_75644_d;
/*    */   private double field_75645_e;
/*    */   private boolean field_75643_f;
/*    */   private static final String __OBFID = "CL_00001573";
/*    */   
/*    */   public EntityMoveHelper(EntityLiving p_i1614_1_) {
/* 22 */     this.field_75648_a = p_i1614_1_;
/* 23 */     this.field_75646_b = p_i1614_1_.field_70165_t;
/* 24 */     this.field_75647_c = p_i1614_1_.field_70163_u;
/* 25 */     this.field_75644_d = p_i1614_1_.field_70161_v;
/*    */   }
/*    */   
/*    */   public boolean func_75640_a() {
/* 29 */     return this.field_75643_f;
/*    */   }
/*    */   
/*    */   public double func_75638_b() {
/* 33 */     return this.field_75645_e;
/*    */   }
/*    */   
/*    */   public void func_75642_a(double p_75642_1_, double p_75642_3_, double p_75642_5_, double p_75642_7_) {
/* 37 */     this.field_75646_b = p_75642_1_;
/* 38 */     this.field_75647_c = p_75642_3_;
/* 39 */     this.field_75644_d = p_75642_5_;
/* 40 */     this.field_75645_e = p_75642_7_;
/* 41 */     this.field_75643_f = true;
/*    */   }
/*    */   
/*    */   public void func_75641_c() {
/* 45 */     this.field_75648_a.func_70657_f(0.0F);
/* 46 */     if (!this.field_75643_f)
/* 47 */       return;  this.field_75643_f = false;
/*    */     
/* 49 */     int i = MathHelper.func_76128_c(this.field_75648_a.field_70121_D.field_72338_b + 0.5D);
/*    */     
/* 51 */     double d1 = this.field_75646_b - this.field_75648_a.field_70165_t;
/* 52 */     double d2 = this.field_75644_d - this.field_75648_a.field_70161_v;
/* 53 */     double d3 = this.field_75647_c - i;
/* 54 */     double d4 = d1 * d1 + d3 * d3 + d2 * d2;
/* 55 */     if (d4 < 2.500000277905201E-7D)
/*    */       return; 
/* 57 */     float f = (float)(Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
/*    */     
/* 59 */     this.field_75648_a.field_70177_z = func_75639_a(this.field_75648_a.field_70177_z, f, 30.0F);
/* 60 */     this.field_75648_a.func_70659_e((float)(this.field_75645_e * this.field_75648_a.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e()));
/*    */     
/* 62 */     if (d3 > 0.0D && d1 * d1 + d2 * d2 < 1.0D) this.field_75648_a.func_70683_ar().func_75660_a(); 
/*    */   }
/*    */   
/*    */   private float func_75639_a(float p_75639_1_, float p_75639_2_, float p_75639_3_) {
/* 66 */     float f = MathHelper.func_76142_g(p_75639_2_ - p_75639_1_);
/* 67 */     if (f > p_75639_3_) {
/* 68 */       f = p_75639_3_;
/*    */     }
/* 70 */     if (f < -p_75639_3_) {
/* 71 */       f = -p_75639_3_;
/*    */     }
/* 73 */     return p_75639_1_ + f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityMoveHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */