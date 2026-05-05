/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class ModelKiHame
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer Shape2;
/*    */   ModelRenderer Shape3;
/*    */   ModelRenderer Shape4;
/*    */   ModelRenderer Shape5;
/*    */   ModelRenderer Shape6;
/*    */   ModelRenderer Shape7;
/*    */   ModelRenderer Shape1;
/*    */   public String textureFile;
/*    */   
/*    */   public ModelKiHame(String file) {
/* 21 */     this.textureFile = file;
/*    */   }
/*    */   
/*    */   public ModelKiHame() {
/* 25 */     this.field_78090_t = 128;
/* 26 */     this.field_78089_u = 64;
/*    */ 
/*    */     
/* 29 */     this.Shape2 = new ModelRenderer(this, 0, 0);
/* 30 */     this.Shape2.func_78789_a(0.0F, 0.0F, 0.0F, 25, 15, 15);
/* 31 */     this.Shape2.func_78793_a(2.5F, -5.0F, -5.0F);
/* 32 */     this.Shape2.func_78787_b(128, 64);
/* 33 */     this.Shape2.field_78809_i = true;
/* 34 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/* 35 */     this.Shape3 = new ModelRenderer(this, 0, 0);
/* 36 */     this.Shape3.func_78789_a(0.0F, 0.0F, 0.0F, 5, 30, 5);
/* 37 */     this.Shape3.func_78793_a(12.5F, -12.5F, 0.0F);
/* 38 */     this.Shape3.func_78787_b(128, 64);
/* 39 */     this.Shape3.field_78809_i = true;
/* 40 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/* 41 */     this.Shape4 = new ModelRenderer(this, 0, 0);
/* 42 */     this.Shape4.func_78789_a(0.0F, 0.0F, 0.0F, 5, 5, 30);
/* 43 */     this.Shape4.func_78793_a(12.5F, 0.0F, -12.5F);
/* 44 */     this.Shape4.func_78787_b(128, 64);
/* 45 */     this.Shape4.field_78809_i = true;
/* 46 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/* 47 */     this.Shape5 = new ModelRenderer(this, 0, 0);
/* 48 */     this.Shape5.func_78789_a(0.0F, 0.0F, 0.0F, 15, 25, 15);
/* 49 */     this.Shape5.func_78793_a(7.5F, -10.0F, -5.0F);
/* 50 */     this.Shape5.func_78787_b(128, 64);
/* 51 */     this.Shape5.field_78809_i = true;
/* 52 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/* 53 */     this.Shape6 = new ModelRenderer(this, 0, 0);
/* 54 */     this.Shape6.func_78789_a(0.0F, 0.0F, 0.0F, 15, 15, 25);
/* 55 */     this.Shape6.func_78793_a(7.5F, -5.0F, -10.0F);
/* 56 */     this.Shape6.func_78787_b(128, 64);
/* 57 */     this.Shape6.field_78809_i = true;
/* 58 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/* 59 */     this.Shape7 = new ModelRenderer(this, 0, 0);
/* 60 */     this.Shape7.func_78789_a(0.0F, 0.0F, 0.0F, 20, 20, 20);
/* 61 */     this.Shape7.func_78793_a(5.0F, -7.5F, -7.5F);
/* 62 */     this.Shape7.func_78787_b(128, 64);
/* 63 */     this.Shape7.field_78809_i = true;
/* 64 */     setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
/* 65 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/* 66 */     this.Shape1.func_78789_a(0.0F, 0.0F, 0.0F, 30, 5, 5);
/* 67 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 68 */     this.Shape1.func_78787_b(128, 64);
/* 69 */     this.Shape1.field_78809_i = true;
/* 70 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 75 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 76 */     setRotationAngles(f, f1, f2, f3, f4, f5);
/* 77 */     this.Shape2.func_78785_a(f5);
/* 78 */     this.Shape3.func_78785_a(f5);
/* 79 */     this.Shape4.func_78785_a(f5);
/* 80 */     this.Shape5.func_78785_a(f5);
/* 81 */     this.Shape6.func_78785_a(f5);
/* 82 */     this.Shape7.func_78785_a(f5);
/* 83 */     this.Shape1.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 88 */     model.field_78795_f = x;
/* 89 */     model.field_78796_g = y;
/* 90 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
/* 95 */     func_78087_a(f, f1, f2, f3, f4, f5, null);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ModelKiHame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */