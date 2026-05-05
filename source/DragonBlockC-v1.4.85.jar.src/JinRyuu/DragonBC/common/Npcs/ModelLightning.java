/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelBiped;
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
/*    */ public class ModelLightning
/*    */   extends ModelBiped
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   ModelRenderer Shape2;
/*    */   
/*    */   public ModelLightning() {
/* 26 */     this.field_78090_t = 256;
/* 27 */     this.field_78089_u = 128;
/*    */     
/* 29 */     this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 30 */     this.Shape1.func_78789_a(-8.0F, -8.0F, -8.0F, 16, 16, 16);
/* 31 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 32 */     this.Shape1.func_78787_b(64, 32);
/* 33 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 34 */     this.Shape2 = new ModelRenderer((ModelBase)this, 0, 42);
/* 35 */     this.Shape2.func_78789_a(-15.0F, -15.0F, -15.0F, 30, 30, 30);
/* 36 */     this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 37 */     this.Shape2.func_78787_b(64, 32);
/* 38 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 43 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 44 */     this.Shape1.func_78785_a(f5);
/* 45 */     this.Shape2.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 50 */     model.field_78795_f = x;
/* 51 */     model.field_78796_g = y;
/* 52 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 57 */     float par3 = f2;
/* 58 */     float par31 = 1.0F;
/*    */     
/* 60 */     this.Shape1.field_78797_d = 3.0F;
/* 61 */     this.Shape1.field_78796_g = par3 * 2.0F;
/* 62 */     this.Shape2.field_78797_d = 3.0F;
/* 63 */     this.Shape2.field_78796_g = -par3 * 2.0F;
/* 64 */     this.Shape2.field_78795_f = -par3 / 3.0F;
/* 65 */     this.Shape2.field_78808_h = -par3 / 3.0F;
/* 66 */     this.Shape1.field_78795_f = -par3 / 3.0F;
/* 67 */     this.Shape1.field_78808_h = -par3 / 3.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
/* 72 */     func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelLightning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */