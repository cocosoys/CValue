/*    */ package JinRyuu.JRMCore.m;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class mEnergy6
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer Spine1;
/*    */   public ModelRenderer Spine2;
/*    */   public ModelRenderer Spine3;
/*    */   public ModelRenderer FootRubble2;
/*    */   public ModelRenderer FootRubble1;
/*    */   public ModelRenderer FootRubble2_1;
/*    */   public ModelRenderer FootRubble3;
/*    */   public ModelRenderer FootRubble2_2;
/*    */   public ModelRenderer FootRubble3_1;
/*    */   
/*    */   public mEnergy6() {
/* 23 */     this.field_78090_t = 128;
/* 24 */     this.field_78089_u = 128;
/* 25 */     this.FootRubble2 = new ModelRenderer(this, 0, 55);
/* 26 */     this.FootRubble2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 27 */     this.FootRubble2.func_78790_a(-2.1F, 4.5F, -2.9F, 7, 13, 4, 0.0F);
/* 28 */     setRotateAngle(this.FootRubble2, 0.13665928F, -0.091106184F, -0.045553092F);
/* 29 */     this.Spine2 = new ModelRenderer(this, 0, 0);
/* 30 */     this.Spine2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 31 */     this.Spine2.func_78790_a(5.3F, -14.2F, 0.0F, 14, 40, 6, 0.0F);
/* 32 */     setRotateAngle(this.Spine2, 0.0F, -0.11920599F, 0.0F);
/* 33 */     this.FootRubble1 = new ModelRenderer(this, 0, 10);
/* 34 */     this.FootRubble1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 35 */     this.FootRubble1.func_78790_a(-9.6F, 8.5F, -3.2F, 7, 17, 4, 0.0F);
/* 36 */     setRotateAngle(this.FootRubble1, 0.019198623F, 0.17104226F, 0.06632251F);
/* 37 */     this.Spine1 = new ModelRenderer(this, 0, 0);
/* 38 */     this.Spine1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 39 */     this.Spine1.func_78790_a(-7.4F, -18.8F, 0.0F, 14, 45, 7, 0.0F);
/* 40 */     this.FootRubble2_2 = new ModelRenderer(this, 0, 10);
/* 41 */     this.FootRubble2_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 42 */     this.FootRubble2_2.func_78790_a(10.4F, 14.0F, 1.0F, 7, 13, 4, 0.0F);
/* 43 */     setRotateAngle(this.FootRubble2_2, -0.18203785F, -0.091106184F, -0.045553092F);
/* 44 */     this.FootRubble3_1 = new ModelRenderer(this, 0, 16);
/* 45 */     this.FootRubble3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 46 */     this.FootRubble3_1.func_78790_a(-22.6F, 20.0F, -0.5F, 12, 5, 6, 0.0F);
/* 47 */     setRotateAngle(this.FootRubble3_1, -0.091106184F, 0.045553092F, -0.091106184F);
/* 48 */     this.FootRubble3 = new ModelRenderer(this, 0, 16);
/* 49 */     this.FootRubble3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 50 */     this.FootRubble3.func_78790_a(-3.5F, 19.3F, -4.3F, 12, 5, 6, 0.0F);
/* 51 */     setRotateAngle(this.FootRubble3, 0.08552113F, -0.17296213F, 0.0F);
/* 52 */     this.Spine3 = new ModelRenderer(this, 0, 0);
/* 53 */     this.Spine3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 54 */     this.Spine3.func_78790_a(-19.9F, -14.2F, 0.0F, 14, 40, 6, 0.0F);
/* 55 */     setRotateAngle(this.Spine3, 0.0F, 0.091106184F, 0.0F);
/* 56 */     this.FootRubble2_1 = new ModelRenderer(this, 0, 10);
/* 57 */     this.FootRubble2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 58 */     this.FootRubble2_1.func_78790_a(-2.1F, 4.5F, -2.9F, 7, 13, 4, 0.0F);
/* 59 */     setRotateAngle(this.FootRubble2_1, 0.13665928F, -0.091106184F, -0.045553092F);
/* 60 */     this.Spine1.func_78792_a(this.FootRubble1);
/* 61 */     this.Spine2.func_78792_a(this.FootRubble2_2);
/* 62 */     this.Spine3.func_78792_a(this.FootRubble3_1);
/* 63 */     this.Spine1.func_78792_a(this.FootRubble3);
/* 64 */     this.Spine1.func_78792_a(this.FootRubble2_1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 69 */     this.FootRubble2.func_78785_a(f5);
/* 70 */     this.Spine2.func_78785_a(f5);
/* 71 */     this.Spine1.func_78785_a(f5);
/* 72 */     this.Spine3.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 79 */     modelRenderer.field_78795_f = x;
/* 80 */     modelRenderer.field_78796_g = y;
/* 81 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\m\mEnergy6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */