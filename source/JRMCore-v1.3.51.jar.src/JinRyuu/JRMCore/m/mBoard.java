/*    */ package JinRyuu.JRMCore.m;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class mBoard
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer shape1;
/*    */   
/*    */   public mBoard() {
/* 17 */     byte size = 30;
/* 18 */     this.shape1 = new ModelRenderer(this, 0, -30);
/* 19 */     this.shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */     
/* 21 */     this.shape1.func_78790_a(0.0F, -5.0F, -30.0F, 0, 10, 30, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 26 */     this.shape1.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 33 */     modelRenderer.field_78795_f = x;
/* 34 */     modelRenderer.field_78796_g = y;
/* 35 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */   
/*    */   public void render(ModelRenderer a, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 39 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 40 */     a.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderModel(byte type, Entity entity, float par8, float par9, float f, float r, boolean b) {
/* 51 */     render(this.shape1, entity, 0.0F, 0.0F, r, par8, par9, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\m\mBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */