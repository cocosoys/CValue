/*    */ package net.minecraft.client.model;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelSnowMan extends ModelBase {
/*    */   public ModelRenderer field_78196_a;
/*    */   public ModelRenderer field_78194_b;
/*    */   public ModelRenderer field_78195_c;
/*    */   
/*    */   public ModelSnowMan() {
/* 12 */     float f1 = 4.0F;
/* 13 */     float f2 = 0.0F;
/*    */     
/* 15 */     this.field_78195_c = (new ModelRenderer(this, 0, 0)).func_78787_b(64, 64);
/* 16 */     this.field_78195_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, f2 - 0.5F);
/* 17 */     this.field_78195_c.func_78793_a(0.0F, 0.0F + f1, 0.0F);
/*    */     
/* 19 */     this.field_78192_d = (new ModelRenderer(this, 32, 0)).func_78787_b(64, 64);
/* 20 */     this.field_78192_d.func_78790_a(-1.0F, 0.0F, -1.0F, 12, 2, 2, f2 - 0.5F);
/* 21 */     this.field_78192_d.func_78793_a(0.0F, 0.0F + f1 + 9.0F - 7.0F, 0.0F);
/*    */     
/* 23 */     this.field_78193_e = (new ModelRenderer(this, 32, 0)).func_78787_b(64, 64);
/* 24 */     this.field_78193_e.func_78790_a(-1.0F, 0.0F, -1.0F, 12, 2, 2, f2 - 0.5F);
/* 25 */     this.field_78193_e.func_78793_a(0.0F, 0.0F + f1 + 9.0F - 7.0F, 0.0F);
/*    */     
/* 27 */     this.field_78196_a = (new ModelRenderer(this, 0, 16)).func_78787_b(64, 64);
/* 28 */     this.field_78196_a.func_78790_a(-5.0F, -10.0F, -5.0F, 10, 10, 10, f2 - 0.5F);
/* 29 */     this.field_78196_a.func_78793_a(0.0F, 0.0F + f1 + 9.0F, 0.0F);
/*    */     
/* 31 */     this.field_78194_b = (new ModelRenderer(this, 0, 36)).func_78787_b(64, 64);
/* 32 */     this.field_78194_b.func_78790_a(-6.0F, -12.0F, -6.0F, 12, 12, 12, f2 - 0.5F);
/* 33 */     this.field_78194_b.func_78793_a(0.0F, 0.0F + f1 + 20.0F, 0.0F);
/*    */   }
/*    */   public ModelRenderer field_78192_d; public ModelRenderer field_78193_e; private static final String __OBFID = "CL_00000859";
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 38 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/* 39 */     this.field_78195_c.field_78796_g = p_78087_4_ / 57.295776F;
/* 40 */     this.field_78195_c.field_78795_f = p_78087_5_ / 57.295776F;
/* 41 */     this.field_78196_a.field_78796_g = p_78087_4_ / 57.295776F * 0.25F;
/*    */     
/* 43 */     float f1 = MathHelper.func_76126_a(this.field_78196_a.field_78796_g);
/* 44 */     float f2 = MathHelper.func_76134_b(this.field_78196_a.field_78796_g);
/*    */     
/* 46 */     this.field_78192_d.field_78808_h = 1.0F;
/* 47 */     this.field_78193_e.field_78808_h = -1.0F;
/* 48 */     this.field_78192_d.field_78796_g = 0.0F + this.field_78196_a.field_78796_g;
/* 49 */     this.field_78193_e.field_78796_g = 3.1415927F + this.field_78196_a.field_78796_g;
/*    */     
/* 51 */     this.field_78192_d.field_78800_c = f2 * 5.0F;
/* 52 */     this.field_78192_d.field_78798_e = -f1 * 5.0F;
/*    */     
/* 54 */     this.field_78193_e.field_78800_c = -f2 * 5.0F;
/* 55 */     this.field_78193_e.field_78798_e = f1 * 5.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 60 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 62 */     this.field_78196_a.func_78785_a(p_78088_7_);
/* 63 */     this.field_78194_b.func_78785_a(p_78088_7_);
/* 64 */     this.field_78195_c.func_78785_a(p_78088_7_);
/* 65 */     this.field_78192_d.func_78785_a(p_78088_7_);
/* 66 */     this.field_78193_e.func_78785_a(p_78088_7_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSnowMan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */