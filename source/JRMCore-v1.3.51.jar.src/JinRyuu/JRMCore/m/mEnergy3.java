/*    */ package JinRyuu.JRMCore.m;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class mEnergy3 extends ModelBiped {
/*    */   ModelRenderer bShape1;
/*    */   ModelRenderer bShape2;
/*    */   
/*    */   public mEnergy3() {
/* 13 */     this.field_78090_t = 128;
/* 14 */     this.field_78089_u = 128;
/* 15 */     this.bShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 16 */     this.bShape1.func_78789_a(-10.0F, -10.0F, -10.0F, 20, 20, 20);
/* 17 */     this.bShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 18 */     this.bShape1.func_78787_b(128, 128);
/* 19 */     setRotation(this.bShape1, 0.0F, 0.0F, 0.0F);
/*    */     
/* 21 */     this.bShape2 = new ModelRenderer((ModelBase)this, 0, 0);
/* 22 */     this.bShape2.func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/* 23 */     this.bShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 24 */     this.bShape2.func_78787_b(128, 128);
/* 25 */     setRotation(this.bShape1, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ModelRenderer a, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 30 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 31 */     a.func_78785_a(f5);
/*    */   }
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {}
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 36 */     model.field_78795_f = x;
/* 37 */     model.field_78796_g = y;
/* 38 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 43 */     float par3 = f2;
/* 44 */     this.bShape1.field_78808_h = par3;
/* 45 */     this.bShape1.field_78796_g = par3;
/* 46 */     this.bShape1.field_78795_f = par3;
/*    */     
/* 48 */     this.bShape2.field_78808_h = par3;
/* 49 */     this.bShape2.field_78796_g = par3;
/* 50 */     this.bShape2.field_78795_f = par3;
/*    */   }
/*    */   
/*    */   public void renderModel(byte type, Entity entity, float par8, float par9, float f, float r, boolean b) {
/* 54 */     ModelRenderer render = null;
/* 55 */     if (type == 1) render = this.bShape1; 
/* 56 */     if (type == 2) render = this.bShape2; 
/* 57 */     if (render != null) render(render, entity, 0.0F, 0.0F, r, par8, par9, f); 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\m\mEnergy3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */