/*    */ package JinRyuu.JRMCore.items;
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
/*    */ public class GiTurtleMdl
/*    */   extends ModelBiped
/*    */ {
/*    */   ModelRenderer leftarmshoulder;
/*    */   ModelRenderer rightarmshoulder;
/*    */   ModelRenderer cape;
/*    */   ModelRenderer c20;
/*    */   ModelRenderer c19;
/*    */   
/*    */   public GiTurtleMdl(float s) {
/* 28 */     super(s, 0.0F, 128, 64);
/*    */     
/* 30 */     this.rightarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/* 31 */     this.rightarmshoulder.func_78789_a(-3.0F, -5.0F, -3.0F, 7, 4, 6);
/* 32 */     this.rightarmshoulder.func_78793_a(-5.0F, 2.0F, 0.0F);
/* 33 */     this.rightarmshoulder.func_78787_b(128, 64);
/* 34 */     setRotation(this.rightarmshoulder, 0.0F, 0.0F, 0.1570796F);
/* 35 */     this.leftarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/* 36 */     this.leftarmshoulder.field_78809_i = true;
/* 37 */     this.leftarmshoulder.func_78789_a(-4.0F, -5.0F, -3.0F, 7, 4, 6);
/* 38 */     this.leftarmshoulder.func_78793_a(5.0F, 2.0F, 0.0F);
/* 39 */     this.leftarmshoulder.func_78787_b(128, 64);
/* 40 */     setRotation(this.leftarmshoulder, 0.0F, 0.0F, -0.1570796F);
/*    */     
/* 42 */     this.cape = new ModelRenderer((ModelBase)this, 100, 0);
/* 43 */     this.cape.func_78790_a(-7.0F, 1.0F, 2.0F, 14, 20, 0, s);
/* 44 */     this.cape.func_78793_a(0.0F, 0.0F, 0.0F);
/* 45 */     this.cape.func_78787_b(128, 64);
/* 46 */     setRotation(this.cape, 0.1570796F, 0.0F, 0.0F);
/*    */     
/* 48 */     this.c20 = new ModelRenderer((ModelBase)this, 76, 35);
/* 49 */     this.c20.func_78790_a(-4.0F, -12.0F, -4.0F, 8, 4, 8, s);
/* 50 */     this.c20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 51 */     this.c20.func_78787_b(128, 64);
/* 52 */     this.c20.field_78809_i = true;
/* 53 */     setRotation(this.c20, 0.0F, 0.0F, 0.0F);
/* 54 */     this.c19 = new ModelRenderer((ModelBase)this, 106, 29);
/* 55 */     this.c19.func_78790_a(-1.0F, -11.0F, -0.5F, 2, 4, 2, s);
/* 56 */     this.c19.func_78793_a(0.0F, 0.0F, 0.0F);
/* 57 */     this.c19.func_78787_b(128, 64);
/* 58 */     this.c19.field_78809_i = true;
/* 59 */     setRotation(this.c19, 0.0F, 0.0F, 0.0F);
/*    */     
/* 61 */     this.field_78116_c.func_78792_a(this.c20);
/* 62 */     this.field_78116_c.func_78792_a(this.c19);
/* 63 */     this.field_78115_e.func_78792_a(this.cape);
/* 64 */     this.field_78113_g.func_78792_a(this.leftarmshoulder);
/* 65 */     this.field_78112_f.func_78792_a(this.rightarmshoulder);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 71 */     model.field_78795_f = x;
/* 72 */     model.field_78796_g = y;
/* 73 */     model.field_78808_h = z;
/*    */   }
/*    */   
/*    */   public void setRotationPub(ModelRenderer model, float x, float y, float z) {
/* 77 */     model.field_78795_f = x;
/* 78 */     model.field_78796_g = y;
/* 79 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 85 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 86 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\GiTurtleMdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */