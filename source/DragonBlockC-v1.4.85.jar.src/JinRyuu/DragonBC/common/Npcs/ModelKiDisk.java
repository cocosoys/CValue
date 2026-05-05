/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class ModelKiDisk
/*    */   extends ModelBiped
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   ModelRenderer Shape2;
/*    */   ModelRenderer Shape3;
/*    */   
/*    */   public ModelKiDisk() {
/* 16 */     this.field_78090_t = 128;
/* 17 */     this.field_78089_u = 32;
/*    */     
/* 19 */     this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 20 */     this.Shape1.func_78789_a(-10.0F, -1.0F, -10.0F, 20, 2, 20);
/* 21 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 22 */     this.Shape1.func_78787_b(128, 32);
/* 23 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 24 */     this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0);
/* 25 */     this.Shape2.func_78789_a(-7.0F, -0.5F, -12.0F, 14, 1, 24);
/* 26 */     this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 27 */     this.Shape2.func_78787_b(128, 32);
/* 28 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 29 */     this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0);
/* 30 */     this.Shape3.func_78789_a(-12.0F, -0.5F, -7.0F, 24, 1, 14);
/* 31 */     this.Shape3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 32 */     this.Shape3.func_78787_b(128, 32);
/* 33 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*    */ 
/*    */     
/* 36 */     this.Shape1.func_78792_a(this.Shape2);
/* 37 */     this.Shape1.func_78792_a(this.Shape3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 43 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 44 */     this.Shape1.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 49 */     model.field_78795_f = x;
/* 50 */     model.field_78796_g = y;
/* 51 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 56 */     float par3 = f2;
/* 57 */     float par31 = 1.0F;
/*    */ 
/*    */     
/* 60 */     this.Shape1.field_78796_g = 2.0F + par3;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
/* 65 */     func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKiDisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */