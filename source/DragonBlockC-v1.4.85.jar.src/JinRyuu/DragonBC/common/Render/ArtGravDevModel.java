/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArtGravDevModel
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer bottom;
/*    */   
/*    */   public ArtGravDevModel() {
/* 25 */     this.field_78090_t = 128;
/* 26 */     this.field_78089_u = 32;
/*    */     
/* 28 */     this.bottom = new ModelRenderer(this, 0, 0);
/* 29 */     this.bottom.func_78789_a(-8.0F, -16.0F, -8.0F, 16, 16, 16);
/* 30 */     this.bottom.func_78793_a(0.0F, 24.0F, 0.0F);
/* 31 */     this.bottom.func_78787_b(128, 32);
/* 32 */     setRotation(this.bottom, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 37 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 38 */     setRotationAngles(f, f1, f2, f3, f4, f5);
/* 39 */     this.bottom.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   public void renderModel(float f5) {
/* 43 */     this.bottom.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 47 */     model.field_78795_f = x;
/* 48 */     model.field_78796_g = y;
/* 49 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
/* 54 */     func_78087_a(f, f1, f2, f3, f4, f5, null);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ArtGravDevModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */