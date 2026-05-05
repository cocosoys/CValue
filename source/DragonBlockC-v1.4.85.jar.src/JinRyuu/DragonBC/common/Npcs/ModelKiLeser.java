/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class ModelKiLeser
/*    */   extends ModelBiped
/*    */ {
/*    */   ModelRenderer Shape1;
/*    */   
/*    */   public ModelKiLeser() {
/* 14 */     this.field_78090_t = 128;
/* 15 */     this.field_78089_u = 128;
/*    */     
/* 17 */     this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 18 */     this.Shape1.func_78789_a(-1.0F, -1.0F, -10.0F, 2, 2, 20);
/* 19 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 20 */     this.Shape1.func_78787_b(128, 128);
/* 21 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 27 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 28 */     this.Shape1.func_78785_a(f5);
/*    */   }
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 33 */     model.field_78795_f = x;
/* 34 */     model.field_78796_g = y;
/* 35 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 40 */     float par3 = f2;
/* 41 */     float par31 = 1.0F;
/*    */     
/* 43 */     this.Shape1.field_78798_e = par3;
/* 44 */     this.Shape1.field_78808_h = par3;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
/* 49 */     func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKiLeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */