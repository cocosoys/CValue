/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelPrjtls_1
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer Base;
/*    */   public ModelRenderer Front;
/*    */   public ModelRenderer Back;
/*    */   public ModelRenderer Front_1;
/*    */   public ModelRenderer Front_2;
/*    */   public ModelRenderer Back_1;
/*    */   public ModelRenderer Back_2;
/*    */   public ModelRenderer Back_3;
/*    */   public ModelRenderer Back_4;
/*    */   public ModelRenderer Back_5;
/*    */   
/*    */   public ModelPrjtls_1() {
/* 24 */     this.field_78090_t = 64;
/* 25 */     this.field_78089_u = 32;
/* 26 */     this.Back_1 = new ModelRenderer(this, 29, 22);
/* 27 */     this.Back_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 28 */     this.Back_1.func_78790_a(-2.0F, -2.25F, 12.7F, 4, 4, 5, 0.0F);
/* 29 */     this.Back_2 = new ModelRenderer(this, 25, 0);
/* 30 */     this.Back_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 31 */     this.Back_2.func_78790_a(-0.5F, -4.15F, 9.7F, 1, 2, 9, 0.0F);
/* 32 */     this.Front = new ModelRenderer(this, 48, 0);
/* 33 */     this.Front.func_78793_a(0.0F, 0.0F, 0.0F);
/* 34 */     this.Front.func_78790_a(-2.5F, -2.7F, -9.8F, 5, 5, 3, 0.0F);
/* 35 */     this.Front_2 = new ModelRenderer(this, 52, 17);
/* 36 */     this.Front_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 37 */     this.Front_2.func_78790_a(-1.5F, -1.7F, -15.6F, 3, 3, 3, 0.0F);
/* 38 */     this.Front_1 = new ModelRenderer(this, 50, 9);
/* 39 */     this.Front_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 40 */     this.Front_1.func_78790_a(-2.0F, -2.25F, -12.5F, 4, 4, 3, 0.0F);
/* 41 */     this.Back_5 = new ModelRenderer(this, 28, 11);
/* 42 */     this.Back_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 43 */     this.Back_5.func_78790_a(-3.7F, -0.7F, 9.7F, 2, 1, 9, 0.0F);
/* 44 */     this.Base = new ModelRenderer(this, 0, 0);
/* 45 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/* 46 */     this.Base.func_78790_a(-3.0F, -3.1F, -7.2F, 6, 6, 12, 0.0F);
/* 47 */     this.Back = new ModelRenderer(this, 0, 18);
/* 48 */     this.Back.func_78793_a(0.0F, 0.0F, 0.0F);
/* 49 */     this.Back.func_78790_a(-2.5F, -2.7F, 4.1F, 5, 5, 9, 0.0F);
/* 50 */     this.Back_3 = new ModelRenderer(this, 25, 0);
/* 51 */     this.Back_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 52 */     this.Back_3.func_78790_a(-0.5F, 1.55F, 9.7F, 1, 2, 9, 0.0F);
/* 53 */     this.Back_4 = new ModelRenderer(this, 28, 11);
/* 54 */     this.Back_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 55 */     this.Back_4.func_78790_a(1.8F, -0.7F, 9.7F, 2, 1, 9, 0.0F);
/* 56 */     this.Back.func_78792_a(this.Back_1);
/* 57 */     this.Back_1.func_78792_a(this.Back_2);
/* 58 */     this.Base.func_78792_a(this.Front);
/* 59 */     this.Front_1.func_78792_a(this.Front_2);
/* 60 */     this.Front.func_78792_a(this.Front_1);
/* 61 */     this.Back_1.func_78792_a(this.Back_5);
/* 62 */     this.Base.func_78792_a(this.Back);
/* 63 */     this.Back_1.func_78792_a(this.Back_3);
/* 64 */     this.Back_1.func_78792_a(this.Back_4);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 69 */     this.Base.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 76 */     modelRenderer.field_78795_f = x;
/* 77 */     modelRenderer.field_78796_g = y;
/* 78 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelPrjtls_1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */