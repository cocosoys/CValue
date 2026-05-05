/*    */ package net.minecraft.client.model;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelCreeper extends ModelBase {
/*    */   public ModelRenderer field_78135_a;
/*    */   public ModelRenderer field_78133_b;
/*    */   public ModelRenderer field_78134_c;
/*    */   public ModelRenderer field_78131_d;
/*    */   
/*    */   public ModelCreeper() {
/* 11 */     this(0.0F);
/*    */   }
/*    */   public ModelRenderer field_78132_e; public ModelRenderer field_78129_f; public ModelRenderer field_78130_g; private static final String __OBFID = "CL_00000837";
/*    */   public ModelCreeper(float p_i1147_1_) {
/* 15 */     byte b = 4;
/*    */     
/* 17 */     this.field_78135_a = new ModelRenderer(this, 0, 0);
/* 18 */     this.field_78135_a.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i1147_1_);
/* 19 */     this.field_78135_a.func_78793_a(0.0F, b, 0.0F);
/*    */     
/* 21 */     this.field_78133_b = new ModelRenderer(this, 32, 0);
/* 22 */     this.field_78133_b.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i1147_1_ + 0.5F);
/* 23 */     this.field_78133_b.func_78793_a(0.0F, b, 0.0F);
/*    */     
/* 25 */     this.field_78134_c = new ModelRenderer(this, 16, 16);
/* 26 */     this.field_78134_c.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, p_i1147_1_);
/* 27 */     this.field_78134_c.func_78793_a(0.0F, b, 0.0F);
/*    */     
/* 29 */     this.field_78131_d = new ModelRenderer(this, 0, 16);
/* 30 */     this.field_78131_d.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, p_i1147_1_);
/* 31 */     this.field_78131_d.func_78793_a(-2.0F, (12 + b), 4.0F);
/*    */     
/* 33 */     this.field_78132_e = new ModelRenderer(this, 0, 16);
/* 34 */     this.field_78132_e.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, p_i1147_1_);
/* 35 */     this.field_78132_e.func_78793_a(2.0F, (12 + b), 4.0F);
/*    */     
/* 37 */     this.field_78129_f = new ModelRenderer(this, 0, 16);
/* 38 */     this.field_78129_f.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, p_i1147_1_);
/* 39 */     this.field_78129_f.func_78793_a(-2.0F, (12 + b), -4.0F);
/*    */     
/* 41 */     this.field_78130_g = new ModelRenderer(this, 0, 16);
/* 42 */     this.field_78130_g.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, p_i1147_1_);
/* 43 */     this.field_78130_g.func_78793_a(2.0F, (12 + b), -4.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 48 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 50 */     this.field_78135_a.func_78785_a(p_78088_7_);
/* 51 */     this.field_78134_c.func_78785_a(p_78088_7_);
/* 52 */     this.field_78131_d.func_78785_a(p_78088_7_);
/* 53 */     this.field_78132_e.func_78785_a(p_78088_7_);
/* 54 */     this.field_78129_f.func_78785_a(p_78088_7_);
/* 55 */     this.field_78130_g.func_78785_a(p_78088_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 60 */     this.field_78135_a.field_78796_g = p_78087_4_ / 57.295776F;
/* 61 */     this.field_78135_a.field_78795_f = p_78087_5_ / 57.295776F;
/*    */     
/* 63 */     this.field_78131_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
/* 64 */     this.field_78132_e.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
/* 65 */     this.field_78129_f.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
/* 66 */     this.field_78130_g.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelCreeper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */