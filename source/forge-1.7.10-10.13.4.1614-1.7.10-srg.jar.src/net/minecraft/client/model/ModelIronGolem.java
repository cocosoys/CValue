/*    */ package net.minecraft.client.model;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityIronGolem;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelIronGolem extends ModelBase {
/*    */   public ModelRenderer field_78178_a;
/*    */   public ModelRenderer field_78176_b;
/*    */   public ModelRenderer field_78177_c;
/*    */   
/*    */   public ModelIronGolem() {
/* 13 */     this(0.0F);
/*    */   }
/*    */   public ModelRenderer field_78174_d; public ModelRenderer field_78175_e; public ModelRenderer field_78173_f; private static final String __OBFID = "CL_00000863";
/*    */   public ModelIronGolem(float p_i1161_1_) {
/* 17 */     this(p_i1161_1_, -7.0F);
/*    */   }
/*    */   
/*    */   public ModelIronGolem(float p_i1162_1_, float p_i1162_2_) {
/* 21 */     char c1 = '';
/* 22 */     char c2 = '';
/*    */     
/* 24 */     this.field_78178_a = (new ModelRenderer(this)).func_78787_b(c1, c2);
/* 25 */     this.field_78178_a.func_78793_a(0.0F, 0.0F + p_i1162_2_, -2.0F);
/* 26 */     this.field_78178_a.func_78784_a(0, 0).func_78790_a(-4.0F, -12.0F, -5.5F, 8, 10, 8, p_i1162_1_);
/* 27 */     this.field_78178_a.func_78784_a(24, 0).func_78790_a(-1.0F, -5.0F, -7.5F, 2, 4, 2, p_i1162_1_);
/*    */     
/* 29 */     this.field_78176_b = (new ModelRenderer(this)).func_78787_b(c1, c2);
/* 30 */     this.field_78176_b.func_78793_a(0.0F, 0.0F + p_i1162_2_, 0.0F);
/* 31 */     this.field_78176_b.func_78784_a(0, 40).func_78790_a(-9.0F, -2.0F, -6.0F, 18, 12, 11, p_i1162_1_);
/* 32 */     this.field_78176_b.func_78784_a(0, 70).func_78790_a(-4.5F, 10.0F, -3.0F, 9, 5, 6, p_i1162_1_ + 0.5F);
/*    */     
/* 34 */     this.field_78177_c = (new ModelRenderer(this)).func_78787_b(c1, c2);
/* 35 */     this.field_78177_c.func_78793_a(0.0F, -7.0F, 0.0F);
/* 36 */     this.field_78177_c.func_78784_a(60, 21).func_78790_a(-13.0F, -2.5F, -3.0F, 4, 30, 6, p_i1162_1_);
/*    */     
/* 38 */     this.field_78174_d = (new ModelRenderer(this)).func_78787_b(c1, c2);
/* 39 */     this.field_78174_d.func_78793_a(0.0F, -7.0F, 0.0F);
/* 40 */     this.field_78174_d.func_78784_a(60, 58).func_78790_a(9.0F, -2.5F, -3.0F, 4, 30, 6, p_i1162_1_);
/*    */     
/* 42 */     this.field_78175_e = (new ModelRenderer(this, 0, 22)).func_78787_b(c1, c2);
/* 43 */     this.field_78175_e.func_78793_a(-4.0F, 18.0F + p_i1162_2_, 0.0F);
/* 44 */     this.field_78175_e.func_78784_a(37, 0).func_78790_a(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i1162_1_);
/*    */     
/* 46 */     this.field_78173_f = (new ModelRenderer(this, 0, 22)).func_78787_b(c1, c2);
/* 47 */     this.field_78173_f.field_78809_i = true;
/* 48 */     this.field_78173_f.func_78784_a(60, 0).func_78793_a(5.0F, 18.0F + p_i1162_2_, 0.0F);
/* 49 */     this.field_78173_f.func_78790_a(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i1162_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 54 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 56 */     this.field_78178_a.func_78785_a(p_78088_7_);
/* 57 */     this.field_78176_b.func_78785_a(p_78088_7_);
/* 58 */     this.field_78175_e.func_78785_a(p_78088_7_);
/* 59 */     this.field_78173_f.func_78785_a(p_78088_7_);
/* 60 */     this.field_78177_c.func_78785_a(p_78088_7_);
/* 61 */     this.field_78174_d.func_78785_a(p_78088_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 66 */     this.field_78178_a.field_78796_g = p_78087_4_ / 57.295776F;
/* 67 */     this.field_78178_a.field_78795_f = p_78087_5_ / 57.295776F;
/*    */     
/* 69 */     this.field_78175_e.field_78795_f = -1.5F * func_78172_a(p_78087_1_, 13.0F) * p_78087_2_;
/* 70 */     this.field_78173_f.field_78795_f = 1.5F * func_78172_a(p_78087_1_, 13.0F) * p_78087_2_;
/* 71 */     this.field_78175_e.field_78796_g = 0.0F;
/* 72 */     this.field_78173_f.field_78796_g = 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 77 */     EntityIronGolem entityIronGolem = (EntityIronGolem)p_78086_1_;
/*    */     
/* 79 */     int i = entityIronGolem.func_70854_o();
/* 80 */     if (i > 0) {
/* 81 */       this.field_78177_c.field_78795_f = -2.0F + 1.5F * func_78172_a(i - p_78086_4_, 10.0F);
/* 82 */       this.field_78174_d.field_78795_f = -2.0F + 1.5F * func_78172_a(i - p_78086_4_, 10.0F);
/*    */     } else {
/* 84 */       int j = entityIronGolem.func_70853_p();
/* 85 */       if (j > 0) {
/* 86 */         this.field_78177_c.field_78795_f = -0.8F + 0.025F * func_78172_a(j, 70.0F);
/* 87 */         this.field_78174_d.field_78795_f = 0.0F;
/*    */       } else {
/* 89 */         this.field_78177_c.field_78795_f = (-0.2F + 1.5F * func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
/* 90 */         this.field_78174_d.field_78795_f = (-0.2F - 1.5F * func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private float func_78172_a(float p_78172_1_, float p_78172_2_) {
/* 96 */     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / p_78172_2_ * 0.25F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelIronGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */