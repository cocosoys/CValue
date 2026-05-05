/*    */ package JinRyuu.JRMCore.m;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class mEnergy7
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer Base;
/*    */   public ModelRenderer BaseFront;
/*    */   public ModelRenderer BaseBack;
/*    */   public ModelRenderer BaseSide_Ball;
/*    */   public ModelRenderer BaseSide_Jobb;
/*    */   public ModelRenderer BaseTop;
/*    */   public ModelRenderer BaseBottom;
/*    */   public ModelRenderer Tail2;
/*    */   public ModelRenderer Tail1;
/*    */   
/*    */   public mEnergy7() {
/* 23 */     this.field_78090_t = 64;
/* 24 */     this.field_78089_u = 32;
/* 25 */     this.Tail1 = new ModelRenderer(this, 22, 0);
/* 26 */     this.Tail1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 27 */     this.Tail1.func_78790_a(3.1F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 28 */     this.BaseFront = new ModelRenderer(this, 0, 9);
/* 29 */     this.BaseFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 30 */     this.BaseFront.func_78790_a(-3.4F, -1.5F, -1.5F, 1, 3, 3, 0.0F);
/* 31 */     this.Base = new ModelRenderer(this, 0, 0);
/* 32 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/* 33 */     this.Base.func_78790_a(-2.6F, -1.9F, -2.0F, 5, 4, 4, 0.0F);
/* 34 */     this.Tail2 = new ModelRenderer(this, 15, 0);
/* 35 */     this.Tail2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 36 */     this.Tail2.func_78790_a(4.6F, -0.7F, -0.5F, 2, 1, 1, 0.0F);
/* 37 */     this.BaseBottom = new ModelRenderer(this, 20, 15);
/* 38 */     this.BaseBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 39 */     this.BaseBottom.func_78790_a(-2.0F, 1.4F, -1.5F, 3, 1, 3, 0.0F);
/* 40 */     this.BaseSide_Jobb = new ModelRenderer(this, 11, 15);
/* 41 */     this.BaseSide_Jobb.func_78793_a(0.0F, 0.0F, 0.0F);
/* 42 */     this.BaseSide_Jobb.func_78790_a(-2.0F, -1.5F, 1.4F, 3, 3, 1, 0.0F);
/* 43 */     this.BaseTop = new ModelRenderer(this, 20, 10);
/* 44 */     this.BaseTop.func_78793_a(0.0F, 0.0F, 0.0F);
/* 45 */     this.BaseTop.func_78790_a(-2.0F, -2.2F, -1.5F, 3, 1, 3, 0.0F);
/* 46 */     this.BaseBack = new ModelRenderer(this, 0, 16);
/* 47 */     this.BaseBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 48 */     this.BaseBack.func_78790_a(2.2F, -1.5F, -1.5F, 1, 3, 3, 0.0F);
/* 49 */     this.BaseSide_Ball = new ModelRenderer(this, 11, 10);
/* 50 */     this.BaseSide_Ball.func_78793_a(0.0F, 0.0F, 0.0F);
/* 51 */     this.BaseSide_Ball.func_78790_a(-2.0F, -1.5F, -2.4F, 3, 3, 1, 0.0F);
/* 52 */     this.Tail2.func_78792_a(this.Tail1);
/* 53 */     this.Base.func_78792_a(this.BaseFront);
/* 54 */     this.BaseBack.func_78792_a(this.Tail2);
/* 55 */     this.Base.func_78792_a(this.BaseBottom);
/* 56 */     this.Base.func_78792_a(this.BaseSide_Jobb);
/* 57 */     this.Base.func_78792_a(this.BaseTop);
/* 58 */     this.Base.func_78792_a(this.BaseBack);
/* 59 */     this.Base.func_78792_a(this.BaseSide_Ball);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 64 */     this.Base.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 71 */     modelRenderer.field_78795_f = x;
/* 72 */     modelRenderer.field_78796_g = y;
/* 73 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\m\mEnergy7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */