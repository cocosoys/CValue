/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class ModelAuraFlat extends ModelBase {
/*    */   public ModelRenderer box;
/*    */   
/*    */   public ModelAuraFlat() {
/* 11 */     this.field_78090_t = 64;
/* 12 */     this.field_78089_u = 32;
/* 13 */     this.box = new ModelRenderer(this, 0, 0);
/* 14 */     this.box.func_78793_a(0.0F, 0.0F, 0.0F);
/* 15 */     this.box.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 0, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 20 */     this.box.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 24 */     modelRenderer.field_78795_f = x;
/* 25 */     modelRenderer.field_78796_g = y;
/* 26 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelAuraFlat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */