/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class ModelKiWave
/*    */   extends ModelBiped
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   ModelRenderer Shape2;
/*    */   ModelRenderer Shape3;
/*    */   ModelRenderer Shape4;
/*    */   
/*    */   public ModelKiWave() {
/* 17 */     this.field_78090_t = 128;
/* 18 */     this.field_78089_u = 128;
/*    */     
/* 20 */     this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 21 */     this.Shape1.func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/* 22 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 23 */     this.Shape1.func_78787_b(128, 128);
/* 24 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 25 */     this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0);
/* 26 */     this.Shape2.func_78789_a(-3.0F, -3.0F, -5.0F, 6, 6, 10);
/* 27 */     this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 28 */     this.Shape2.func_78787_b(128, 128);
/* 29 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 30 */     this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0);
/* 31 */     this.Shape3.func_78789_a(-3.0F, -5.0F, -3.0F, 6, 10, 6);
/* 32 */     this.Shape3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 33 */     this.Shape3.func_78787_b(128, 128);
/* 34 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/* 35 */     this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0);
/* 36 */     this.Shape4.func_78789_a(-5.0F, -3.0F, -3.0F, 10, 6, 6);
/* 37 */     this.Shape4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 38 */     this.Shape4.func_78787_b(128, 128);
/* 39 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/*    */     
/* 41 */     this.Shape1.func_78792_a(this.Shape2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 48 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 49 */     this.Shape1.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 54 */     model.field_78795_f = x;
/* 55 */     model.field_78796_g = y;
/* 56 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 61 */     float par3 = f2;
/* 62 */     float par31 = 1.0F;
/*    */ 
/*    */ 
/*    */     
/* 66 */     this.Shape1.field_78808_h = par3;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
/* 75 */     func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKiWave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */