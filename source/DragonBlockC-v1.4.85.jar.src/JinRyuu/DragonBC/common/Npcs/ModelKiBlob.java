/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class ModelKiBlob
/*    */   extends ModelBiped
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   ModelRenderer Shape2;
/*    */   ModelRenderer Shape3;
/*    */   ModelRenderer Shape4;
/*    */   ModelRenderer Shape5;
/*    */   ModelRenderer Shape6;
/*    */   ModelRenderer Shape7;
/*    */   
/*    */   public ModelKiBlob() {
/* 20 */     this.field_78090_t = 128;
/* 21 */     this.field_78089_u = 128;
/*    */     
/* 23 */     this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 24 */     this.Shape1.func_78789_a(-10.0F, -10.0F, -10.0F, 20, 20, 20);
/* 25 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 26 */     this.Shape1.func_78787_b(128, 128);
/* 27 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/* 28 */     this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0);
/* 29 */     this.Shape2.func_78789_a(-8.0F, -8.0F, -12.0F, 16, 16, 24);
/* 30 */     this.Shape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 31 */     this.Shape2.func_78787_b(128, 128);
/* 32 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 33 */     this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0);
/* 34 */     this.Shape3.func_78789_a(-4.0F, -4.0F, -14.0F, 8, 8, 28);
/* 35 */     this.Shape3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 36 */     this.Shape3.func_78787_b(128, 128);
/* 37 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/* 38 */     this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0);
/* 39 */     this.Shape4.func_78789_a(-8.0F, -12.0F, -8.0F, 16, 24, 16);
/* 40 */     this.Shape4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 41 */     this.Shape4.func_78787_b(128, 128);
/* 42 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 43 */     this.Shape5 = new ModelRenderer((ModelBase)this, 0, 0);
/* 44 */     this.Shape5.func_78789_a(-4.0F, -14.0F, -4.0F, 8, 28, 8);
/* 45 */     this.Shape5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 46 */     this.Shape5.func_78787_b(128, 128);
/* 47 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/* 48 */     this.Shape6 = new ModelRenderer((ModelBase)this, 0, 0);
/* 49 */     this.Shape6.func_78789_a(-12.0F, -8.0F, -8.0F, 24, 16, 16);
/* 50 */     this.Shape6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 51 */     this.Shape6.func_78787_b(128, 128);
/* 52 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/* 53 */     this.Shape7 = new ModelRenderer((ModelBase)this, 0, 0);
/* 54 */     this.Shape7.func_78789_a(-14.0F, -4.0F, -4.0F, 28, 8, 8);
/* 55 */     this.Shape7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 56 */     this.Shape7.func_78787_b(128, 128);
/* 57 */     setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
/*    */     
/* 59 */     this.Shape1.func_78792_a(this.Shape2);
/* 60 */     this.Shape1.func_78792_a(this.Shape3);
/* 61 */     this.Shape1.func_78792_a(this.Shape4);
/* 62 */     this.Shape1.func_78792_a(this.Shape5);
/* 63 */     this.Shape1.func_78792_a(this.Shape6);
/* 64 */     this.Shape1.func_78792_a(this.Shape7);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 70 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 71 */     this.Shape1.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 76 */     model.field_78795_f = x;
/* 77 */     model.field_78796_g = y;
/* 78 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 83 */     float par3 = f2;
/* 84 */     float par31 = 1.0F;
/*    */ 
/*    */     
/* 87 */     this.Shape1.field_78808_h = par3;
/*    */     
/* 89 */     this.Shape1.field_78796_g = par3;
/*    */     
/* 91 */     this.Shape1.field_78795_f = par3;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
/* 99 */     func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKiBlob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */