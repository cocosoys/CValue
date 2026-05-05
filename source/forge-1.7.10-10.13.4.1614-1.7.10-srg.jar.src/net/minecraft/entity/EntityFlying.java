/*    */ package net.minecraft.entity;
/*    */ 
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class EntityFlying extends EntityLiving {
/*    */   public EntityFlying(World p_i1587_1_) {
/*  8 */     super(p_i1587_1_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00001545";
/*    */ 
/*    */   
/*    */   protected void func_70069_a(float p_70069_1_) {}
/*    */ 
/*    */   
/*    */   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {}
/*    */ 
/*    */   
/*    */   public void func_70612_e(float p_70612_1_, float p_70612_2_) {
/* 23 */     if (func_70090_H()) {
/* 24 */       func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
/* 25 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*    */       
/* 27 */       this.field_70159_w *= 0.800000011920929D;
/* 28 */       this.field_70181_x *= 0.800000011920929D;
/* 29 */       this.field_70179_y *= 0.800000011920929D;
/* 30 */     } else if (func_70058_J()) {
/* 31 */       func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
/* 32 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 33 */       this.field_70159_w *= 0.5D;
/* 34 */       this.field_70181_x *= 0.5D;
/* 35 */       this.field_70179_y *= 0.5D;
/*    */     } else {
/* 37 */       float f1 = 0.91F;
/* 38 */       if (this.field_70122_E) {
/* 39 */         f1 = (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v))).field_149765_K * 0.91F;
/*    */       }
/*    */       
/* 42 */       float f2 = 0.16277136F / f1 * f1 * f1;
/* 43 */       func_70060_a(p_70612_1_, p_70612_2_, this.field_70122_E ? (0.1F * f2) : 0.02F);
/*    */       
/* 45 */       f1 = 0.91F;
/* 46 */       if (this.field_70122_E) {
/* 47 */         f1 = (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v))).field_149765_K * 0.91F;
/*    */       }
/*    */       
/* 50 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*    */       
/* 52 */       this.field_70159_w *= f1;
/* 53 */       this.field_70181_x *= f1;
/* 54 */       this.field_70179_y *= f1;
/*    */     } 
/* 56 */     this.field_70722_aY = this.field_70721_aZ;
/* 57 */     double d1 = this.field_70165_t - this.field_70169_q;
/* 58 */     double d2 = this.field_70161_v - this.field_70166_s;
/* 59 */     float f = MathHelper.func_76133_a(d1 * d1 + d2 * d2) * 4.0F;
/* 60 */     if (f > 1.0F) f = 1.0F; 
/* 61 */     this.field_70721_aZ += (f - this.field_70721_aZ) * 0.4F;
/* 62 */     this.field_70754_ba += this.field_70721_aZ;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70617_f_() {
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityFlying.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */