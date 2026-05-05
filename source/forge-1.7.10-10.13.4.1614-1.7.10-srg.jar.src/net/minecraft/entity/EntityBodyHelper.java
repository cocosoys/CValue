/*    */ package net.minecraft.entity;
/*    */ 
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ 
/*    */ public class EntityBodyHelper
/*    */ {
/*    */   private EntityLivingBase field_75668_a;
/*    */   private int field_75666_b;
/*    */   private float field_75667_c;
/*    */   private static final String __OBFID = "CL_00001570";
/*    */   
/*    */   public EntityBodyHelper(EntityLivingBase p_i1611_1_) {
/* 14 */     this.field_75668_a = p_i1611_1_;
/*    */   }
/*    */   
/*    */   public void func_75664_a() {
/* 18 */     double d1 = this.field_75668_a.field_70165_t - this.field_75668_a.field_70169_q;
/* 19 */     double d2 = this.field_75668_a.field_70161_v - this.field_75668_a.field_70166_s;
/*    */     
/* 21 */     if (d1 * d1 + d2 * d2 > 2.500000277905201E-7D) {
/*    */       
/* 23 */       this.field_75668_a.field_70761_aq = this.field_75668_a.field_70177_z;
/* 24 */       this.field_75668_a.field_70759_as = func_75665_a(this.field_75668_a.field_70761_aq, this.field_75668_a.field_70759_as, 75.0F);
/* 25 */       this.field_75667_c = this.field_75668_a.field_70759_as;
/* 26 */       this.field_75666_b = 0;
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 31 */     float f = 75.0F;
/* 32 */     if (Math.abs(this.field_75668_a.field_70759_as - this.field_75667_c) > 15.0F) {
/* 33 */       this.field_75666_b = 0;
/* 34 */       this.field_75667_c = this.field_75668_a.field_70759_as;
/*    */     } else {
/* 36 */       this.field_75666_b++;
/* 37 */       byte b = 10;
/* 38 */       if (this.field_75666_b > 10) f = Math.max(1.0F - (this.field_75666_b - 10) / 10.0F, 0.0F) * 75.0F;
/*    */     
/*    */     } 
/* 41 */     this.field_75668_a.field_70761_aq = func_75665_a(this.field_75668_a.field_70759_as, this.field_75668_a.field_70761_aq, f);
/*    */   }
/*    */   
/*    */   private float func_75665_a(float p_75665_1_, float p_75665_2_, float p_75665_3_) {
/* 45 */     float f = MathHelper.func_76142_g(p_75665_1_ - p_75665_2_);
/* 46 */     if (f < -p_75665_3_) f = -p_75665_3_; 
/* 47 */     if (f >= p_75665_3_) f = p_75665_3_; 
/* 48 */     return p_75665_1_ - f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityBodyHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */