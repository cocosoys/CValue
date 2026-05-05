/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelPrjtls_2
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
/*    */   public ModelRenderer Back_6;
/*    */   public ModelRenderer Back_7;
/*    */   public ModelRenderer Back_8;
/*    */   public ModelRenderer Back_9;
/*    */   
/*    */   public ModelPrjtls_2() {
/* 28 */     this.field_78090_t = 64;
/* 29 */     this.field_78089_u = 32;
/* 30 */     this.Front_2 = new ModelRenderer(this, 56, 13);
/* 31 */     this.Front_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 32 */     this.Front_2.func_78790_a(-1.5F, -1.7F, -9.7F, 3, 3, 1, 0.0F);
/* 33 */     this.Back_2 = new ModelRenderer(this, 31, 0);
/* 34 */     this.Back_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 35 */     this.Back_2.func_78790_a(-0.5F, -4.15F, 4.2F, 1, 2, 9, 0.0F);
/* 36 */     this.Back_7 = new ModelRenderer(this, 29, 0);
/* 37 */     this.Back_7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 38 */     this.Back_7.func_78790_a(-0.5F, 1.35F, 13.2F, 1, 4, 3, 0.0F);
/* 39 */     this.Back_5 = new ModelRenderer(this, 40, 13);
/* 40 */     this.Back_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 41 */     this.Back_5.func_78790_a(-3.7F, -0.7F, 4.2F, 2, 1, 9, 0.0F);
/* 42 */     this.Back = new ModelRenderer(this, 0, 19);
/* 43 */     this.Back.func_78793_a(0.0F, 0.0F, 0.0F);
/* 44 */     this.Back.func_78790_a(-2.5F, -2.7F, 4.1F, 5, 5, 7, 0.0F);
/* 45 */     this.Back_4 = new ModelRenderer(this, 40, 13);
/* 46 */     this.Back_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 47 */     this.Back_4.func_78790_a(1.8F, -0.7F, 4.2F, 2, 1, 9, 0.0F);
/* 48 */     this.Base = new ModelRenderer(this, 0, 0);
/* 49 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/* 50 */     this.Base.func_78790_a(-3.0F, -3.1F, -7.2F, 6, 6, 12, 0.0F);
/* 51 */     this.Back_3 = new ModelRenderer(this, 31, 0);
/* 52 */     this.Back_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 53 */     this.Back_3.func_78790_a(-0.5F, 1.55F, 4.2F, 1, 2, 9, 0.0F);
/* 54 */     this.Front = new ModelRenderer(this, 52, 0);
/* 55 */     this.Front.func_78793_a(0.0F, 0.0F, 0.0F);
/* 56 */     this.Front.func_78790_a(-2.5F, -2.7F, -8.1F, 5, 5, 1, 0.0F);
/* 57 */     this.Back_1 = new ModelRenderer(this, 25, 22);
/* 58 */     this.Back_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 59 */     this.Back_1.func_78790_a(-2.0F, -2.25F, 10.6F, 4, 4, 5, 0.0F);
/* 60 */     this.Back_8 = new ModelRenderer(this, 47, 25);
/* 61 */     this.Back_8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 62 */     this.Back_8.func_78790_a(1.8F, -0.7F, 13.2F, 4, 1, 3, 0.0F);
/* 63 */     this.Front_1 = new ModelRenderer(this, 54, 7);
/* 64 */     this.Front_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 65 */     this.Front_1.func_78790_a(-2.0F, -2.25F, -9.0F, 4, 4, 1, 0.0F);
/* 66 */     this.Back_6 = new ModelRenderer(this, 29, 0);
/* 67 */     this.Back_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 68 */     this.Back_6.func_78790_a(-0.5F, -5.85F, 13.2F, 1, 4, 3, 0.0F);
/* 69 */     this.Back_9 = new ModelRenderer(this, 47, 25);
/* 70 */     this.Back_9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 71 */     this.Back_9.func_78790_a(-5.6F, -0.7F, 13.2F, 4, 1, 3, 0.0F);
/* 72 */     this.Front_1.func_78792_a(this.Front_2);
/* 73 */     this.Back_1.func_78792_a(this.Back_2);
/* 74 */     this.Back_3.func_78792_a(this.Back_7);
/* 75 */     this.Back_1.func_78792_a(this.Back_5);
/* 76 */     this.Base.func_78792_a(this.Back);
/* 77 */     this.Back_1.func_78792_a(this.Back_4);
/* 78 */     this.Back_1.func_78792_a(this.Back_3);
/* 79 */     this.Base.func_78792_a(this.Front);
/* 80 */     this.Back.func_78792_a(this.Back_1);
/* 81 */     this.Back_4.func_78792_a(this.Back_8);
/* 82 */     this.Front.func_78792_a(this.Front_1);
/* 83 */     this.Back_2.func_78792_a(this.Back_6);
/* 84 */     this.Back_5.func_78792_a(this.Back_9);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 89 */     this.Base.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 96 */     modelRenderer.field_78795_f = x;
/* 97 */     modelRenderer.field_78796_g = y;
/* 98 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelPrjtls_2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */